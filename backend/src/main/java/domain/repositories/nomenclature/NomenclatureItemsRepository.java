package domain.repositories.nomenclature;

import domain.models.nomenclature.NomenclatureItem;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NomenclatureItemsRepository extends TypoRepository<NomenclatureItem> {

    public NomenclatureItemsRepository() {
        super(NomenclatureItem.class);
    }

    public List<NomenclatureItem> findByGroupCode(String groupCode) {
        String sql = "SELECT * FROM NOMENCLATURE_ITEMS WHERE GROUP_CODE = ?";
        return jdbcOperations.query(sql, new Object[]{groupCode}, rowMapper);
    }
}
