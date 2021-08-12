package domain.models.application;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Id;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "USERS")
public class User extends TypoTable {

    @Column(name = "NAME")
    private String name;

    @Override
    public void setDefaults() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
