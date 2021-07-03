package domain.models.nomenclature;

import com.fasterxml.jackson.annotation.JsonInclude;
import domain.models.abstracts.SubTable;
import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "NOMENCLATURE_ITEMS")
public class NomenclatureItems extends TypoTable implements SubTable {

    @Column(name = "GROUP_CODE")
    private String groupCode;

    @Column(name = "CODE", rus = "Код")
    private String code;

    @Column(name = "NAME")
    private String name;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

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
}
