package rest.abstracts;

import domain.services.abstracts.TypoServiceUser;
import kpersistence.v1.query.KFilter;
import kpersistence.v2.tables.StringIdTable;
import rest.v1.controllers.AbstractTableController;

public abstract class TypoTableController<T extends StringIdTable, F extends KFilter> extends AbstractTableController<T, F> implements TypoServiceUser {

}
