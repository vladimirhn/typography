package rest.abstracts;

import domain.services.abstracts.TypoServiceUser;
import repository.tables.AbstractView;
import rest.controllers.AbstractViewController;
import rest.dictionary.DictionaryService;

public abstract class TypoViewController<T extends AbstractView> extends AbstractViewController<T> implements TypoServiceUser {

    protected DictionaryService getDictionaryService() {
        return typoDictionaryService;
    }
}
