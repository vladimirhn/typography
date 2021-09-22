package rest.abstracts;

import domain.services.abstracts.TypoServiceUser;
import repository.tables.AbstractView;
import repository.tables.StringIdTable;
import rest.AbstractTableController;
import rest.AbstractViewController;
import rest.dictionary.DictionaryService;

public abstract class TypoViewController<T extends AbstractView> extends AbstractViewController<T> implements TypoServiceUser {

    protected DictionaryService getDictionaryService() {
        return typoDictionaryService;
    }
}
