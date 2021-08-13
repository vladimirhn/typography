package domain.services.abstracts;

import domain.models.abstracts.TypoTable;
import domain.repositories.abstracts.TypoTableRepository;
import kcollections.KList;
import koptional.KOptional;
import kpersistence.QueryGenerator;
import kpersistence.UnnamedParametersQuery;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public abstract class TypoTableService<T extends TypoTable> {

    protected abstract TypoTableRepository<T> getRepository();

    //Main functionality
    //CHECKS
    public KOptional<T> selectFirst(T obj) {
        return getRepository().selectFirst(obj);
    }

    //SELECT
    public Optional<T> findOne(long id) {
        return getRepository().findOne(id);
    }

    public KList<T> selectAll() {
        return getRepository().selectAll();
    }

    public Stream<T> streamAll() {
        return getRepository().streamAll();
    }

    public KList<T> findWithQuery(String sql) {
        return getRepository().selectWithQuery(sql);
    }

    public <V> KList<T> selectByField(BiConsumer<T, V> fieldSetter, V fieldValue) {
        return getRepository().selectByField(fieldSetter, fieldValue);
    }

    //INSERT
    public void insert(T obj) {
        getRepository().insert(obj);
    }

    public String insertIfNew(T obj) {
        return getRepository().insertIfNew(obj);
    }

    //UPDATE
    public void update(T obj) {
        getRepository().update(obj);
    }

    //DELETE
    public void delete(String id) {
        getRepository().delete(id);
    }

    public void deleteSimilar(T obj) {
        getRepository().deleteSimilar(obj);
    }

    public <V> void deleteByField(BiConsumer<T, V> fieldSetter, V fieldValue) {
        getRepository().deleteByField(fieldSetter, fieldValue);
    }
}
