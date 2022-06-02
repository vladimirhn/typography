package domain.models.stock;

import domain.models.abstracts.TypographyTable;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

@Entity
@Table(name = "STOCKS")
public class Stock extends TypographyTable {

    @Column(name = "NAME")
    String name;

    @Column(name = "ADDRESS")
    String address;

    public Stock() {}

    @Override
    public void setDefaults() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
