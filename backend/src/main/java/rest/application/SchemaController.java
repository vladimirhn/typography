package rest.application;

import kpersistence.modelsMaster.ModelsMaster;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.v2.schema.SpringTableDescription;
import rest.EndPoint;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(EndPoint.USERS_PATH + "/schema")
public class SchemaController {

    @GetMapping("/get")
    public List<SpringTableDescription> get() {

        return ModelsMaster.getSchemaDescription().stream()
                .map(SpringTableDescription::new)
                .filter(table -> table.getEndpoint() != null)
                .collect(Collectors.toList());
    }
}
