package domain.models.orders;

import kpersistence.v2.annotations.Column;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v2.annotations.Table;
import kpersistence.v2.tables.StringIdTable;

@Entity
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
