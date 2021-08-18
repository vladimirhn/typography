package domain.services.abstracts.response;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("dictionaryService")
public class DictionaryService implements DictionaryDataProvider {

    Map<String, String> enRus;

    public String russian(String orig) {
        String rus = getEnRusDict().get(orig.toLowerCase());
        if (rus == null) {
            if (orig.endsWith("Name")) return "наименование";
            if (orig.endsWith("Date")) return "дата";
            return orig;
        }
        return rus;
    }

    private Map<String, String> getEnRusDict() {
        if (enRus == null) createEnRusDict();
        return enRus;
    }

    private void createEnRusDict() {
        enRus = new HashMap<>();

        enRus.put("amount", "количество");
        enRus.put("name", "наименование");
        enRus.put("price", "цена");

    }
}
