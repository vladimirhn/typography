package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import karrays.KArrays;
import kcollections.CollectionFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import repository.v2.AbstractStringIdTableRepository;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ConsumableItems2Repository extends AbstractStringIdTableRepository<ConsumableItem> {

    private RowMapper<ConsumableItem> minimumDataRowMapper = (ResultSet rs, int i) -> {

        ConsumableItem dto = new ConsumableItem();
        dto.setId(rs.getString("item_id"));
        dto.setItem(rs.getString("item_name"));

        return dto;
    };

    public List<ConsumableItem> getAllMinimum() {

        String sql = "SELECT DISTINCT item_id, item_name FROM all_consumables_view WHERE user_id = ?";
        
        return CollectionFactory.makeListFrom(jdbcOperations::query, sql, KArrays.of(user()), minimumDataRowMapper);
    }

    public List<ConsumableItem> getByTypeMinimum(String typeId) {
        String sql = "SELECT DISTINCT item_id, item_name FROM all_consumables_view " +
                "WHERE user_id = ? AND type_id = ?";

        return CollectionFactory.makeListFrom(jdbcOperations::query, sql, KArrays.of(user(), typeId), minimumDataRowMapper);
    }
}
