package domain.services.abstracts.response;

import kpersistence.repository.tables.MainTable;
import kpersistence.repository.tables.TypoTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("responseComposer")
public class KResponseComposer {

    @Autowired
    DictionaryService dictionaryService;

    public SimpleTableResponse createFrom(Collection<?> data, Class<?> type) {

        if (TypoTable.class.isAssignableFrom(type)) {

            if (MainTable.class.isAssignableFrom(type)) {

            } else {
                return new SimpleTableResponse(data, type, dictionaryService);
            }
        }

        return null;
    }
}
