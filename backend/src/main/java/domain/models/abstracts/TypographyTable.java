package domain.models.abstracts;

import com.fasterxml.jackson.annotation.JsonInclude;
import kpersistence.v2.tables.UserIdStringIdTable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class TypographyTable extends UserIdStringIdTable {
}
