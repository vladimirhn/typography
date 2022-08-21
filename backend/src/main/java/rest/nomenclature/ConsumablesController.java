package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumablesView;
import domain.services.abstracts.TypoServiceUser;
import kcollections.CollectionFactory;
import kcollections.KList;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.v2.controllers.AbstractViewController;
import rest.v2.response.tables.TableDataResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

@RestController
@Transactional
@RequestMapping(EndPoint.CONSUMABLES)
public class ConsumablesController extends AbstractViewController<ConsumablesView> implements TypoServiceUser {

    @PostMapping("/get_filtered")
    public TableDataResponse<ConsumablesView> selectFiltered(@RequestBody ConsumablesView data) {

        KList<ConsumablesView> result = foldView(service().selectFiltered(data));
        TableDataResponse<ConsumablesView> response = new TableDataResponse<>(result);
        return response;
    }

    private KList<ConsumablesView> foldView(KList<ConsumablesView> selection) {

        KList<ConsumablesView> result = CollectionFactory.makeArrayList();

        selection.forEach(line -> {

            Map<String, String> propertyIds;

            Predicate<ConsumablesView> sameType = entry -> Objects.equals(entry.getTypeId(), line.getTypeId());
            Predicate<ConsumablesView> sameItem = entry -> Objects.equals(entry.getItemId(), line.getItemId());

            ConsumablesView type;
            ConsumablesView item;
            ConsumablesView property = line.toProperty();

            if (result.stream().noneMatch(sameType)) {
                type = line.toType();
                item = line.toItem();
                propertyIds = new HashMap<>();

                item.setProperties(CollectionFactory.makeArrayList());
                item.getProperties().add(property);

                type.setItems(CollectionFactory.makeArrayList());
                if (item.getItemId() != null) type.getItems().add(item);

                result.add(type);

            } else if (result.stream().flatMap(res -> res.getItems().stream()).noneMatch(sameItem)) {
                type = result.filter(sameType).getAny();
                item = line.toItem();
                propertyIds = type.getPropertyIds();

                item.setProperties(CollectionFactory.makeArrayList());
                item.getProperties().add(property);

                if (item.getItemId() != null) type.getItems().add(item);

            } else {
                type = result.filter(sameType).getAny();
                item = type.getItems().filter(sameItem).getAny();
                propertyIds = type.getPropertyIds();

                item.getProperties().add(property);
            }

            if (propertyIds.keySet().stream().noneMatch(entry -> Objects.equals(entry, property.getPropertyId()))
                && property.getPropertyId() != null) {
                propertyIds.put(property.getPropertyId(), property.getPropertyName());
                type.setPropertyIds(propertyIds);
            }

        });

        return result;
    }
}
