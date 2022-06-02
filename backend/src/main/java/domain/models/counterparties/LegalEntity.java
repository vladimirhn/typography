package domain.models.counterparties;

import domain.models.abstracts.TypographyTable;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v1.mapping.annotations.Label;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

@Entity
@Table(name = "LEGAL_ENTITIES")
public class LegalEntity extends TypographyTable {

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
