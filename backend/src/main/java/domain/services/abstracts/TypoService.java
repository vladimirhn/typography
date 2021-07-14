package domain.services.abstracts;

import domain.models.abstracts.TypoTable;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class TypoService<T extends TypoTable> {

    protected abstract TypoRepository<T> getRepository();

    //Main functionality
    //SELECT
    public Optional<T> findOne(long id) {
        return getRepository().findOne(id);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public Stream<T> streamAll() {
        return getRepository().streamAll();
    }

    public List<T> findWithQuery(String sql) {
        return getRepository().findWithQuery(sql);
    }

    //INSERT
    public void insert(T obj) {
        getRepository().insert(obj);
    }

    //UPDATE
    public void update(T obj) {
        getRepository().update(obj);
    }

    //DELETE
    public void delete(T obj) {
        getRepository().delete(obj);
    }
}
