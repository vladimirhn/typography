package domain.models.counterparties;

import kpersistence.annotations.Column;
import kpersistence.annotations.Label;
import kpersistence.annotations.Table;
import rest.models.JsonNonNullUserIdStringIdTable;

@Table(name = "LEGAL_ENTITIES")
public class LegalEntity extends JsonNonNullUserIdStringIdTable {

    @Label
    @Column(name = "NAME")
    String name;

    @Column(name = "PHONE")
    String phone;

    @Column(name = "ADDRESS")
    String address;

    public LegalEntity() {}

    @Override
    public void setDefaults() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
