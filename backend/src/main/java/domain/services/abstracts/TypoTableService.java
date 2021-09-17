package domain.services.abstracts;

import repository.tables.TypoTable;
import repository.TypoTableRepository;
import kcollections.KList;
import koptional.KOptional;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class TypoTableService<T extends TypoTable> {

    protected abstract TypoTableRepository<T> getRepository();

    //Main functionality
    //CHECKS
    public KOptional<T> selectFirst(T obj) {
        return getRepository().selectFirst(obj);
    }

    //SELECT
    public KOptional<T> findOne(String id) {
        return getRepository().findOne(id);
    }

    public <U> KOptional<U> findFieldValue(String id, Function<T, U> getter) {
        T entry = findOne(id).get();
        return entry == null ? KOptional.empty() : KOptional.of(getter.apply(entry));
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
    public String insert(T obj) {
        return getRepository().insert(obj);
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
