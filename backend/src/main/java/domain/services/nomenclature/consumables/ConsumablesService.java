package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablesViewLine;
import domain.repositories.abstracts.TypoViewRepository;
import domain.repositories.nomenclature.consumables.AllConsumablesViewRepository;
import domain.services.abstracts.TypoViewService;
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
public class ConsumablesService extends TypoViewService<ConsumablesViewLine> {

    @Autowired
    AllConsumablesViewRepository repository;

    @Override
    protected TypoViewRepository<ConsumablesViewLine> getRepository() {
        return repository;
    }

    public List<JsonConsumableType> createConsumableTypesResponse() {

        Map<Long, KList<ConsumablesViewLine>> groupByTypeId = selectAll().groupBy(ConsumablesViewLine::getTypeId);

        return createFullFilledResult(groupByTypeId);
    }

    public JsonConsumableType createConsumableTypesResponse(Long id) {

        Map<Long, KList<ConsumablesViewLine>> groupByTypeId =
                selectByField(ConsumablesViewLine::setTypeId, id)
                .groupBy(ConsumablesViewLine::getTypeId);

        KList<JsonConsumableType> result = createFullFilledResult(groupByTypeId);

        return result.getFirst().orElse(null);
    }

    public List<JsonConsumableType> selectTypesWithProps() {

        Map<Long, KList<ConsumablesViewLine>> groupByTypeId = selectAll().groupBy(ConsumablesViewLine::getTypeId);
        return createResultWithProperties(groupByTypeId);
    }

    private KList<JsonConsumableType> createFullFilledResult(Map<Long, KList<ConsumablesViewLine>> groupByTypeId) {

        KList<Map.Entry<JsonConsumableType, KList<ConsumablesViewLine>>> entries = groupByTypeIdToEntriesList(groupByTypeId);

        return entries
                .useEachBy(this::setProperties)
                .useEachBy(this::setData)
                .mapEachBy(Map.Entry::getKey)
                .sortAsc(JsonConsumableType::getType);
    }

    private KList<JsonConsumableType> createResultWithProperties(Map<Long, KList<ConsumablesViewLine>> groupByTypeId) {
        KList<Map.Entry<JsonConsumableType, KList<ConsumablesViewLine>>> entries = groupByTypeIdToEntriesList(groupByTypeId);

        return entries
                .useEachBy(this::setProperties)
                .mapEachBy(Map.Entry::getKey)
                .sortAsc(JsonConsumableType::getType);
    }

    private KList<Map.Entry<JsonConsumableType, KList<ConsumablesViewLine>>> groupByTypeIdToEntriesList(Map<Long, KList<ConsumablesViewLine>> groupByTypeId) {

        return CollectionFactory.makeList(

                groupByTypeId.entrySet().stream()
                        .map(this::idToJsonObject)
                        .collect(Collectors.toList())
        );
    }

    private Map.Entry<JsonConsumableType, KList<ConsumablesViewLine>> idToJsonObject(Map.Entry<Long, KList<ConsumablesViewLine>> mapEntries) {

        Long typeId = mapEntries.getKey();
        KList<ConsumablesViewLine> typeLines = mapEntries.getValue();

        JsonConsumableType typeEntry = new JsonConsumableType(typeId, typeLines.getAny().getTypeName());

        return new AbstractMap.SimpleEntry<>(typeEntry, typeLines);
    }

    private void setProperties(Map.Entry<JsonConsumableType, KList<ConsumablesViewLine>> mapEntry) {

        Map<Long, KList<ConsumablesViewLine>> groupByPropertyId = mapEntry.getValue().groupByWithNulls(ConsumablesViewLine::getPropertyId);
        groupByPropertyId.forEach((propId, propLines) -> mapEntry.getKey().getProperties().put(propId, propLines.getAny().getPropertyName()));
        MapUtils.sortByValue(mapEntry.getKey().getProperties());
    }

    private void setData(Map.Entry<JsonConsumableType, KList<ConsumablesViewLine>> mapEntry) {

        KList<JsonConsumableItem> data = CollectionFactory.makeLinkedList();
        Map<Long, KList<ConsumablesViewLine>> groupByItemId = mapEntry.getValue().groupByWithNulls(ConsumablesViewLine::getItemId);
        groupByItemId.forEach((itemId, itemLines) -> {
            JsonConsumableItem itemEntry = new JsonConsumableItem();
            itemEntry.setItemId(itemId);
            itemEntry.setItem(itemLines.getAny().getItemName());
            itemEntry.setValues(new TreeMap<>());

            itemLines.forEach(itemLine -> {
                if (itemLine.getPropertyId() != null && itemLine.getValueId() != null) {
                    itemEntry.getValues().put(itemLine.getPropertyId(), Collections.singletonMap(itemLine.getValueId(), itemLine.getValueValue()));
                }
            });

            data.add(itemEntry);
        });

        mapEntry.getKey().setData(data);
    }
}
