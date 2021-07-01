package domain.models.nomenclature;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "NOMENCLATURE_GROUPS")
public class NomenclatureGroups extends TypoTable {

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    private List<NomenclatureItems> items;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NomenclatureItems> getItems() {
        if (items == null) return new ArrayList<>();
        return items;
    }

    public void setItems(List<NomenclatureItems> items) {
        this.items = items;
    }
}
