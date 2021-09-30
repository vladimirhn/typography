package domain.models.orders;

import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;
import repository.tables.StringIdTable;

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
