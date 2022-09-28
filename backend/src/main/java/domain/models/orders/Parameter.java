package domain.models.orders;

import kpersistence.annotations.Column;
import kpersistence.annotations.Table;
import kpersistence.tables.StringIdTable;

@Table(name = "PARAMETERS")
public class Parameter extends StringIdTable {

    @Column(name = "NAME")
    String name;

    public Parameter() {}

    public Parameter(String name) {
        this.name = name;
    }

    @Override
    public void setDefaults() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
