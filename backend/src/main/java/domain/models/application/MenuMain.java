package domain.models.application;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "MENU_MAIN")
public class MenuMain extends TypoTable {

    @Column(name = "ENTRY_CODE")
    private String entryCode;

    @Column(name = "ENTRY")
    private String entry;

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
