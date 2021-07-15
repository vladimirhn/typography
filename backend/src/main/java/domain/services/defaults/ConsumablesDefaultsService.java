package domain.services.defaults;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.nomenclature.consumables.ConsumableProperty;
import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.models.nomenclature.consumables.ConsumableType;
import domain.services.application.IdService;
import domain.services.nomenclature.consumables.ConsumableItemsService;
import domain.services.nomenclature.consumables.ConsumablePropertiesService;
import domain.services.nomenclature.consumables.ConsumablePropertiesValuesService;
import domain.services.nomenclature.consumables.ConsumableTypesService;
import koptional.KOptional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ConsumablesDefaultsService {

    @Autowired
    ConsumableTypesService consumableTypesService;
    @Autowired
    ConsumablePropertiesService consumablePropertiesService;
    @Autowired
    ConsumableItemsService consumableItemsService;
    @Autowired
    ConsumablePropertiesValuesService consumablePropertiesValuesService;

    @Autowired
    IdService idService;

    @Value("file:defaults/consumables.json")
    Resource consumablesFile;
    public void setDefaults() throws IOException {

        File data = consumablesFile.getFile();
        String content = new Scanner(data).useDelimiter("\\Z").next();

        ObjectMapper objectMapper = new ObjectMapper();
        List<ConsumablesTypeDefaultJson> types = objectMapper.readValue(content, new TypeReference<List<ConsumablesTypeDefaultJson>>(){});

        types.forEach(type -> {
            ConsumableType consumableType = new ConsumableType(type.type);
            long typeId = consumableTypesService.insertIfNew(consumableType);

            Map<Integer, Long> orderToPropId = new HashMap<>();

            for (int i = 0; i < type.properties.size(); i++) {
                String property = type.properties.get(i);

                AtomicLong propertyId = new AtomicLong();
                ConsumableProperty consumableProperty = new ConsumableProperty(property);
                consumableProperty.setTypeId(typeId);

                consumablePropertiesService.selectFirst(consumableProperty)
                        .ifHasSomething(existedCP -> {
                            propertyId.set(existedCP.getId());
                        })
                        .ifHasNothing(() -> {
                            propertyId.set(idService.next());
                            consumableProperty.setId(propertyId.get());
                            consumablePropertiesService.insert(consumableProperty);
                        });

                orderToPropId.put(i, propertyId.get());
            }

            type.data.forEach(item -> {
                AtomicLong itemId = new AtomicLong();
                ConsumableItem consumableItem = new ConsumableItem(item.item);
                consumableItem.setTypeId(typeId);

                consumableItemsService.selectFirst(consumableItem)
                        .ifHasSomething(existedCI -> {
                            itemId.set(existedCI.getId());
                        })
                        .ifHasNothing(() -> {
                            itemId.set(idService.next());
                            consumableItem.setTypeId(typeId);
                            consumableItem.setId(itemId.get());
                            consumableItemsService.insert(consumableItem);
                        });

                for (int i = 0; i < item.values.size(); i++) {
                    String value = item.values.get(i);

                    ConsumablePropertyValue propertyValue = new ConsumablePropertyValue(value);
                    propertyValue.setItemId(itemId.get());
                    propertyValue.setPropertyId(orderToPropId.get(i));

                    consumablePropertiesValuesService.selectFirst(propertyValue)
                            .ifHasNothing(() -> consumablePropertiesValuesService.insert(propertyValue));
                }
            });
        });
    }
}
