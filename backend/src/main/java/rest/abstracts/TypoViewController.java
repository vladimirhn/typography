package rest.abstracts;

import domain.services.abstracts.TypoServiceUser;
import repository.v1.tables.AbstractView;
import rest.v1.controllers.AbstractViewController;

public abstract class TypoViewController<T extends AbstractView> extends AbstractViewController<T> implements TypoServiceUser {
}
