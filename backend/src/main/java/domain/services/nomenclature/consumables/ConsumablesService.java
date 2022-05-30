package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablesView;
import repository.v1.AbstractViewRepository;
import domain.repositories.nomenclature.consumables.AllConsumablesViewRepository;
import service.v1.AbstractViewService;
import kcollections.CollectionFactory;
import kcollections.KList;
import kutils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.nomenclature.JsonConsumableItem;
import rest.nomenclature.JsonConsumableType;

import java.util.*;
import java.util.stream.Collectors;

@Service("consumablesService")
public class ConsumablesService extends AbstractViewService<ConsumablesView> {

    @Autowired
    AllConsumablesViewRepository repository;

    @Override
    protected AbstractViewRepository<ConsumablesView> getRepository() {
        return repository;
    }

    public List<JsonConsumableType> createConsumableTypesResponse() {

        Map<String, KList<ConsumablesView>> groupByTypeId = selectAll().groupBy(ConsumablesView::getTypeId);

        return createFullFilledResult(groupByTypeId);
    }

    public JsonConsumableType createConsumableTypesResponse(String id) {

        Map<String, KList<ConsumablesView>> groupByTypeId =
                selectByField(ConsumablesView::setTypeId, id)
                .groupBy(ConsumablesView::getTypeId);

        KList<JsonConsumableType> result = createFullFilledResult(groupByTypeId);

        return result.getFirst().orElse(null);
    }

    public List<JsonConsumableType> selectTypesWithProps() {

        Map<String, KList<ConsumablesView>> groupByTypeId = selectAll().groupBy(ConsumablesView::getTypeId);
        return createResultWithProperties(groupByTypeId);
    }

    private KList<JsonConsumableType> createFullFilledResult(Map<String, KList<ConsumablesView>> groupByTypeId) {

        KList<Map.Entry<JsonConsumableType, KList<ConsumablesView>>> entries = groupByTypeIdToEntriesList(groupByTypeId);

        return entries
                .useEachBy(this::setProperties)
                .useEachBy(this::setData)
                .mapEachBy(Map.Entry::getKey)
                .sortAsc(JsonConsumableType::getType);
    }

    private KList<JsonConsumableType> createResultWithProperties(Map<String, KList<ConsumablesView>> groupByTypeId) {
        KList<Map.Entry<JsonConsumableType, KList<ConsumablesView>>> entries = groupByTypeIdToEntriesList(groupByTypeId);

        return entries
                .useEachBy(this::setProperties)
                .mapEachBy(Map.Entry::getKey)
                .sortAsc(JsonConsumableType::getType);
    }

    private KList<Map.Entry<JsonConsumableType, KList<ConsumablesView>>> groupByTypeIdToEntriesList(Map<String, KList<ConsumablesView>> groupByTypeId) {

        return CollectionFactory.makeList(

                groupByTypeId.entrySet().stream()
                        .map(this::idToJsonObject)
                        .collect(Collectors.toList())
        );
    }

    private Map.Entry<JsonConsumableType, KList<ConsumablesView>> idToJsonObject(Map.Entry<String, KList<ConsumablesView>> mapEntries) {

        String typeId = mapEntries.getKey();
        KList<ConsumablesView> typeLines = mapEntries.getValue();

        JsonConsumableType typeEntry = new JsonConsumableType(typeId, typeLines.getAny().getTypeName());

        return new AbstractMap.SimpleEntry<>(typeEntry, typeLines);
    }

    private void setProperties(Map.Entry<JsonConsumableType, KList<ConsumablesView>> mapEntry) {

        Map<String, KList<ConsumablesView>> groupByPropertyId = mapEntry.getValue().groupByWithNulls(ConsumablesView::getPropertyId);
        groupByPropertyId.forEach((propId, propLines) -> mapEntry.getKey().getProperties().put(propId, propLines.getAny().getPropertyName()));
        MapUtils.sortByValue(mapEntry.getKey().getProperties());
    }

    private void setData(Map.Entry<JsonConsumableType, KList<ConsumablesView>> mapEntry) {

        KList<JsonConsumableItem> data = CollectionFactory.makeLinkedList();
        Map<String, KList<ConsumablesView>> groupByItemId = mapEntry.getValue().groupByWithNulls(ConsumablesView::getItemId);
        groupByItemId.forEach((itemId, itemLines) -> {
            JsonConsumableItem itemEntry = new JsonConsumableItem();
            itemEntry.setItemId(itemId);
            itemEntry.setItem(itemLines.getAny().getItemName());
            itemEntry.setPackageCapacity(itemLines.getAny().getPackageCapacity());
            itemEntry.setValues(new TreeMap<>());

            itemLines.forEach(itemLine -> {
                if (itemLine.getPropertyId() != null && itemLine.getValueId() != null) {
                    itemEntry.getValues().put(itemLine.getPropertyId(), Collections.singletonMap(itemLine.getValueId(), itemLine.getValueValue()));
                }
            });

            data.add(itemEntry);
        });

        data.sortAsc(JsonConsumableItem::getItem);

        mapEntry.getKey().setData(data);
    }
}
