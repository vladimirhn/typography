//package domain.services.defaults.consumables;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import domain.models.nomenclature.consumables.ConsumableItem;
//import domain.models.nomenclature.consumables.ConsumableProperty;
//import domain.models.nomenclature.consumables.ConsumablePropertyValue;
//import domain.models.nomenclature.consumables.ConsumableType;
//import kpersistence.v2.RandomId;
//import domain.services.nomenclature.consumables.ConsumableItemsService;
//import domain.services.nomenclature.consumables.ConsumablePropertiesService;
//import domain.services.nomenclature.consumables.ConsumablePropertiesValuesService;
//import domain.services.nomenclature.consumables.ConsumableTypesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.concurrent.atomic.AtomicReference;
//
//@Service
//public class ConsumablesDefaultsService {
//
//    @Autowired
//    ConsumableTypesService consumableTypesService;
//    @Autowired
//    ConsumablePropertiesService consumablePropertiesService;
//    @Autowired
//    ConsumableItemsService consumableItemsService;
//    @Autowired
//    ConsumablePropertiesValuesService consumablePropertiesValuesService;
//
//    @Value("file:defaults/consumables.json")
//    Resource consumablesFile;
//    public void setDefaults() throws IOException {
//
//        File data = consumablesFile.getFile();
//        String content = new Scanner(data, StandardCharsets.UTF_8).useDelimiter("\\Z").next();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<ConsumablesTypeDefaultJson> types = objectMapper.readValue(content, new TypeReference<List<ConsumablesTypeDefaultJson>>(){});
//
//        types.forEach(type -> {
//            ConsumableType consumableType = new ConsumableType(type.type);
//            String typeId = consumableTypesService.insertIfNew(consumableType);
//
//            Map<Integer, String> orderToPropId = new HashMap<>();
//
//            for (int i = 0; i < type.properties.size(); i++) {
//                String property = type.properties.get(i);
//
//                AtomicReference<String> propertyId = new AtomicReference<>();
//                ConsumableProperty consumableProperty = new ConsumableProperty(property);
//                consumableProperty.setTypeId(typeId);
//
//                consumablePropertiesService.selectFirst(consumableProperty)
//                        .ifSomething(existedCP -> {
//                            propertyId.set(existedCP.getId());
//                        })
//                        .ifNothing(() -> {
//                            propertyId.set(RandomId.next());
//                            consumableProperty.setId(propertyId.get());
//                            consumablePropertiesService.insert(consumableProperty);
//                        });
//
//                orderToPropId.put(i, propertyId.get());
//            }
//
//            type.data.forEach(item -> {
//                AtomicReference<String> itemId = new AtomicReference<>();
//                ConsumableItem consumableItem = new ConsumableItem(item.item);
//                consumableItem.setTypeId(typeId);
//
//                consumableItemsService.selectFirst(consumableItem)
//                        .ifSomething(existedCI -> {
//                            itemId.set(existedCI.getId());
//                        })
//                        .ifNothing(() -> {
//                            itemId.set(RandomId.next());
//                            consumableItem.setTypeId(typeId);
//                            consumableItem.setId(itemId.get());
//                            consumableItemsService.insert(consumableItem);
//                        });
//
//                for (int i = 0; i < item.values.size(); i++) {
//                    String value = item.values.get(i);
//
//                    ConsumablePropertyValue propertyValue = new ConsumablePropertyValue(value);
//                    propertyValue.setItemId(itemId.get());
//                    propertyValue.setPropertyId(orderToPropId.get(i));
//
//                    consumablePropertiesValuesService.selectFirst(propertyValue)
//                            .ifNothing(() -> consumablePropertiesValuesService.insert(propertyValue));
//                }
//            });
//        });
//    }
//}
