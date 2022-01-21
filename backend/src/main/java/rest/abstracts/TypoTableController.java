package rest.abstracts;

import domain.services.abstracts.TypoServiceUser;
import kpersistence.query.KFilter;
import repository.tables.StringIdTable;
import rest.controllers.AbstractTableController;
import rest.dictionary.DictionaryService;

public abstract class TypoTableController<T extends StringIdTable, F extends KFilter> extends AbstractTableController<T, F> implements TypoServiceUser {

    protected DictionaryService getDictionaryService() {
        return typoDictionaryService;
    }
}
