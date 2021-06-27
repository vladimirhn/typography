package domain.models.abstracts;

import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Id;

public abstract class TypoTable {

    @Id
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
