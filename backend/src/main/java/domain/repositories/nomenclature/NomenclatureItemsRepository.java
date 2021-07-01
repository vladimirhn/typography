package domain.repositories.nomenclature;

import domain.models.nomenclature.NomenclatureItems;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NomenclatureItemsRepository extends TypoRepository<NomenclatureItems> {

    public NomenclatureItemsRepository() {
        super(NomenclatureItems.class);
    }

    public List<NomenclatureItems> findByGroupCode(String groupCode) {
        String sql = "SELECT * FROM NOMENCLATURE_ITEMS WHERE GROUP_CODE = ?";
        return jdbcOperations.query(sql, new Object[]{groupCode}, rowMapper);
    }
}
