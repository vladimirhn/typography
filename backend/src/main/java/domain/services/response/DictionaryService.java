package domain.services.response;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("dictionaryService")
public class DictionaryService implements DictionaryDataProvider {

    Map<String, String> enRus;

    public String russian(String orig) {
        String rus = getEnRusDict().get(orig.toLowerCase());
        if (rus == null) return orig;
        return rus;
    }

    private Map<String, String> getEnRusDict() {
        if (enRus == null) createEnRusDict();
        return enRus;
    }

    private void createEnRusDict() {
        enRus = new HashMap<>();

        enRus.put("name", "Наименование");

    }
}
