package domain.services.abstracts;

import domain.models.abstracts.TypoView;
import domain.repositories.abstracts.TypoViewRepository;
import kcollections.KList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class TypoViewService<T extends TypoView> {

    protected abstract TypoViewRepository<T> getRepository();

    //Main functionality
    //SELECT ONLY
    public Optional<T> findOne(long id) {
        return getRepository().findOne(id);
    }

    public KList<T> findAll() {
        return getRepository().findAll();
    }

    public Stream<T> streamAll() {
        return getRepository().streamAll();
    }

    public List<T> findWithQuery(String sql) {
        return getRepository().findWithQuery(sql);
    }
}
