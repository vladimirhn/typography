package domain.models.nomenclature;

import domain.models.abstracts.MainTable;
import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

import java.util.List;

@Entity
@Table(name = "NOMENCLATURE_GROUPS")
public class NomenclatureGroups extends TypoTable implements MainTable {

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    private List<NomenclatureItems> subTableData;

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

    @Override
    public List<NomenclatureItems> getSubTableData() {
        return subTableData;
    }

    public void setSubTableData(List<NomenclatureItems> subTableData) {
        this.subTableData = subTableData;
    }
}
