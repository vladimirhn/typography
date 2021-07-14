package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablesViewLine;
import domain.repositories.abstracts.TypoViewRepository;
import domain.repositories.nomenclature.consumables.AllConsumablesViewRepository;
import domain.services.abstracts.TypoViewService;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.nomenclature.JsonConsumableType;

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

            Map<Long, KList<ConsumablesViewLine>> groupByPropertyId = typeLines.groupByWithNulls(ConsumablesViewLine::getPropertyId);
            groupByPropertyId.forEach((propId, propLines) -> {

                String measure = propLines.getAny().getPropertyMeasure() == null ? "" : " (" + propLines.getAny().getPropertyMeasure() + ")";
                typeEntry.getProperties().put(propId, propLines.getAny().getPropertyName() + measure);
            });

            result.put(typeId, typeEntry);
        });


        return result;
    }
}
