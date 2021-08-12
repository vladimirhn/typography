package domain.models.abstracts;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Id;

public abstract class TypoTable {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "ID")
    private Long id;

    public abstract void setDefaults();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
