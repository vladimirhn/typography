package domain.models.nomenclature.consumables;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "CONSUMABLE_PROPERTIES")
public class ConsumableProperty extends TypoTable {

    @Column(name = "TYPE_ID")
    private Long typeId;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    public ConsumableProperty() {}

    public ConsumableProperty(String propertyName) {
        this.propertyName = propertyName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
