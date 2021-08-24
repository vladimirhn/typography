package rest.abstracts;

import domain.models.abstracts.TypoTable;
import domain.services.abstracts.TypoTableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import rest.responses.TableDataResponse;

public abstract class TableController<T extends TypoTable> {

    protected abstract TypoTableService<T> getService();

    @GetMapping("/get_all")
    public TableDataResponse<T> getAll() {
        return new TableDataResponse<>(getService().selectAll());
    }

    @PostMapping("/add")
    public void add(@RequestBody T data) {
        getService().insert(data);
    }
    @PostMapping("/update")
    public void update(@RequestBody T data) {
        getService().update(data);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") String id) {
        getService().delete(id);
    }
}
