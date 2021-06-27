package domain.repositories.abstracts;

import domain.models.abstracts.TypoTable;
import kpersistence.KRepository;

public abstract class TypoRepository<T extends TypoTable> extends KRepository<T> {

    public TypoRepository(Class<T> clazz) {
        super(clazz, table -> table.getId().toString());
    }
}
