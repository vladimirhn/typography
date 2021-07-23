package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablesViewLine;
import domain.repositories.abstracts.TypoViewRepository;
import domain.repositories.nomenclature.consumables.AllConsumablesViewRepository;
import domain.services.abstracts.TypoViewService;
import kcollections.CollectionFactory;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.nomenclature.JsonConsumableItem;
import rest.nomenclature.JsonConsumableType;

import java.util.*;

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

        return createResult(groupByTypeId);
    }

    public JsonConsumableType createConsumableTypesResponse(Long id) {

        Map<Long, KList<ConsumablesViewLine>> groupByTypeId =
                selectByField(ConsumablesViewLine::setTypeId, id)
                .groupBy(ConsumablesViewLine::getTypeId);

        KList<JsonConsumableType> result = createResult(groupByTypeId);

        return result.getFirst().orElse(null);
    }

    private KList<JsonConsumableType> createResult(Map<Long, KList<ConsumablesViewLine>> groupByTypeId) {

        KList<JsonConsumableType> result = CollectionFactory.makeLinkedList();

        groupByTypeId.forEach((Long typeId, KList<ConsumablesViewLine> typeLines) ->
                processEachType(result, typeId, typeLines));

        result.sortAsc(JsonConsumableType::getType);
        return result;
    }

    private void processEachType(List<JsonConsumableType> result, Long typeId, KList<ConsumablesViewLine> typeLines) {

        JsonConsumableType typeEntry = new JsonConsumableType();
        typeEntry.setId(typeId);
        typeEntry.setType(typeLines.getAny().getTypeName());
        typeEntry.setProperties(new TreeMap<>());

        Map<Long, KList<ConsumablesViewLine>> groupByPropertyId = typeLines.groupByWithNulls(ConsumablesViewLine::getPropertyId);
        groupByPropertyId.forEach((propId, propLines) -> typeEntry.getProperties().put(propId, propLines.getAny().getPropertyName()));

        KList<JsonConsumableItem> data = CollectionFactory.makeLinkedList();
        Map<Long, KList<ConsumablesViewLine>> groupByItemId = typeLines.groupByWithNulls(ConsumablesViewLine::getItemId);
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

        typeEntry.setData(data);
        result.add(typeEntry);
    }
}
