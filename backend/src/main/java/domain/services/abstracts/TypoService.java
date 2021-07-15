package domain.services.abstracts;

import domain.models.abstracts.TypoTable;
import domain.repositories.abstracts.TypoRepository;
import koptional.KOptional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class TypoService<T extends TypoTable> {

    protected abstract TypoRepository<T> getRepository();

    //Main functionality
    //CHECKS
    public KOptional<T> selectFirst(T obj) {
        return getRepository().selectFirst(obj);
    }

    //SELECT
    public Optional<T> findOne(long id) {
        return getRepository().findOne(id);
    }

    public List<T> findAll() {
        return getRepository().selectAll();
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

    public long insertIfNew(T obj) {
        return getRepository().insertIfNew(obj);
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
