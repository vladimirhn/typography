package domain.models.stock;

import kpersistence.annotations.Column;
import kpersistence.annotations.Table;
import rest.v2.models.JsonNonNullUserIdStringIdTable;

@Table(name = "STOCKS")
public class Stock extends JsonNonNullUserIdStringIdTable {

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
