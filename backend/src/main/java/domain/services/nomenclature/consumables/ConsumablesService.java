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

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

@Service("consumablesService")
public class ConsumablesService extends TypoViewService<ConsumablesViewLine> {

    @Autowired
    AllConsumablesViewRepository repository;

    @Override
    protected TypoViewRepository<ConsumablesViewLine> getRepository() {
        return repository;
    }

    public Map<Long, JsonConsumableType> createConsumableTypesResponse() {

        Map<Long, JsonConsumableType> result = new TreeMap<>();

        Map<Long, KList<ConsumablesViewLine>> groupByTypeId = findAll().groupBy(ConsumablesViewLine::getTypeId);
        groupByTypeId.forEach((typeId, typeLines) -> {

            JsonConsumableType typeEntry = new JsonConsumableType();
            typeEntry.setType(typeLines.getAny().getTypeName());
            typeEntry.setProperties(new TreeMap<>());
            typeEntry.setData(new TreeMap<>());

            Map<Long, KList<ConsumablesViewLine>> groupByPropertyId = typeLines.groupByWithNulls(ConsumablesViewLine::getPropertyId);
            groupByPropertyId.forEach((propId, propLines) -> {

                String measure = propLines.getAny().getPropertyMeasure() == null ? "" : " (" + propLines.getAny().getPropertyMeasure() + ")";
                typeEntry.getProperties().put(propId, propLines.getAny().getPropertyName() + measure);
            });

            Map<Long, KList<JsonConsumableItem>> data = new TreeMap<>();
            Map<Long, KList<ConsumablesViewLine>> groupByItemId = typeLines.groupByWithNulls(ConsumablesViewLine::getItemId);
            groupByItemId.forEach((itemId, itemLines) -> {
                JsonConsumableItem itemEntry = new JsonConsumableItem();
                itemEntry.setItem(itemLines.getAny().getItemName());
                itemEntry.setValues(new TreeMap<>());

                itemLines.forEach(itemLine -> {
                    if (itemLine.getPropertyId() != null && itemLine.getValueId() != null) {
                        itemEntry.getValues().put(itemLine.getPropertyId(), Collections.singletonMap(itemLine.getValueId(), itemLine.getValueValue()));
                    }
                });

                if (!data.containsKey(itemId)) data.put(itemId, CollectionFactory.makeLinkedList());

                data.get(itemId).add(itemEntry);
            });

            typeEntry.setData(data);
            result.put(typeId, typeEntry);
        });


        return result;
    }
}
