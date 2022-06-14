package example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    static Map<String, String> dicMap = new HashMap<>();
    static {
        dicMap.put("run","chạy");
        dicMap.put("eat","ăn");
        dicMap.put("talk","nói");
        dicMap.put("sleep","ngủ");
    }

    public static Map<String,String> returnDictionary(String vi,String en) {
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
