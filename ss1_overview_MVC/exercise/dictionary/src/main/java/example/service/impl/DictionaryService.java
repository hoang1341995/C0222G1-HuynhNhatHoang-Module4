package example.service.impl;

import example.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    static Map<String, String> dicMap = new HashMap<>();
    static {
        dicMap.put("run","chạy");
        dicMap.put("eat","ăn");
        dicMap.put("talk","nói");
        dicMap.put("sleep","ngủ");
    }


    @Override
    public Map<String, String> returnDictionary(String vi, String en) {
        Map<String, String> mapReturn = new HashMap<>();
        for (Map.Entry<String, String> entry : dicMap.entrySet()) {
            if (entry.getValue().equals(vi)||entry.getKey().equals(en)) {
                mapReturn.put(entry.getKey(),entry.getValue());
                break;
            }
        }
        return mapReturn;
    }
}
