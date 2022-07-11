package rest.abstracts;

import domain.services.abstracts.TypoServiceUser;
import kpersistence.v2.tables.Table;
import repository.v1.tables.AbstractView;
import rest.v1.controllers.AbstractViewController;

public abstract class TypoViewController<T extends Table> extends AbstractViewController<T> implements TypoServiceUser {
}
