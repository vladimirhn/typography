package rest.abstracts;

import domain.models.abstracts.TypoTable;
import domain.services.abstracts.TypoTableService;
import kcollections.KList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class TableController<T extends TypoTable> {

    protected abstract TypoTableService<T> getService();

    @GetMapping("/get_all")
    public KList<T> getAll() {
        return getService().selectAll();
    }

    @PostMapping("/add")
    public void addType(@RequestBody T data) {
        getService().insert(data);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        getService().delete(id);
    }
}
