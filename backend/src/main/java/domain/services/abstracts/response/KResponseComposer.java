package domain.services.abstracts.response;

import domain.models.abstracts.MainTable;
import domain.models.abstracts.TypoTable;
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
