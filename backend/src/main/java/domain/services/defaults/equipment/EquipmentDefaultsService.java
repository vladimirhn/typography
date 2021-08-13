package domain.services.defaults.equipment;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.models.nomenclature.equipment.ComponentItem;
import domain.models.nomenclature.equipment.EquipmentItem;
import domain.models.nomenclature.equipment.EquipmentType;
import domain.services.application.IdService;
import domain.services.nomenclature.equipment.ComponentItemsService;
import domain.services.nomenclature.equipment.EquipmentItemsService;
import domain.services.nomenclature.equipment.EquipmentTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

@Service
public class EquipmentDefaultsService {

    @Autowired
    EquipmentTypesService equipmentTypesService;
    @Autowired
    EquipmentItemsService equipmentItemsService;
    @Autowired
    ComponentItemsService componentItemsService;

    @Autowired
    IdService idService;

    @Value("file:defaults/equipment.json")
    Resource equipmentFile;
    public void setDefaults() throws IOException {

        File data = equipmentFile.getFile();
        String content = new Scanner(data, StandardCharsets.UTF_8).useDelimiter("\\Z").next();

        ObjectMapper objectMapper = new ObjectMapper();
        List<EquipmentTypeDefaultJson> types = objectMapper.readValue(content, new TypeReference<List<EquipmentTypeDefaultJson>>(){});

        types.forEach(type -> {
            EquipmentType equipmentType = new EquipmentType(type.type);
            String typeId = equipmentTypesService.insertIfNew(equipmentType);

            type.items.forEach(item -> {
                EquipmentItem equipmentItem = new EquipmentItem(typeId, item.item, item.model);

                equipmentItemsService.selectFirst(equipmentItem)
                        .ifHasNothing(()-> equipmentItemsService.insert(equipmentItem));
            });

            type.components.forEach(component -> {
                ComponentItem componentItem = new ComponentItem(typeId, component.item, component.model);
                componentItemsService.selectFirst(componentItem)
                        .ifHasNothing(() -> componentItemsService.insert(componentItem));
            });
        });
    }
}
