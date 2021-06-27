package domain.services.abstracts;

import domain.models.abstracts.TypoTable;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class TypoService<T extends TypoTable> {

    @Autowired
    private TypoRepository<T> repository;

    public TypoRepository<T> getRepository() {
        return repository;
    }

    protected void setRepository(TypoRepository<T> repository) {
        this.repository = repository;
    }

    //Main functionality
    //SELECT
    public Optional<T> findOne(long id) {
        return getRepository().findOne(id);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public List<T> findAll(Function<? super T, ? extends Comparable> compareBy) {
        return getRepository().findAll(compareBy);
    }

    public Stream<T> streamAll() {
        return getRepository().streamAll();
    }

    public Stream<T> streamAll(Function<? super T, ? extends Comparable> compareBy) {
        return getRepository().streamAll(compareBy);
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
