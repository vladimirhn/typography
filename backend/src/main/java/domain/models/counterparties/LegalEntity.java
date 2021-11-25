package domain.models.counterparties;

import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Label;
import kpersistence.mapping.annotations.Table;
import repository.tables.UserIdStringIdTable;

@Entity
@Table(name = "LEGAL_ENTITIES")
public class LegalEntity extends UserIdStringIdTable {

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
