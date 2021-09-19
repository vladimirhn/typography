package rest.abstracts;

import domain.services.abstracts.TypoServiceUser;
import repository.tables.StringIdTable;
import rest.AbstractTableController;
import rest.dictionary.DictionaryService;

public abstract class TypoTableController<T extends StringIdTable> extends AbstractTableController<T> implements TypoServiceUser {

    protected DictionaryService getDictionaryService() {
        return typoDictionaryService;
    }
}
