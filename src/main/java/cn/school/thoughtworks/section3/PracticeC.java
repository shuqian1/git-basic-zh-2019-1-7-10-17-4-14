package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeC {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String,Integer> collection3 = new HashMap<>();
        collectionA.forEach(i -> {
            collection3.put(i, collection3.containsKey(i) ? collection3.get(i)+1 : 1);
        });
        return collection3.entrySet().stream().map(entry ->{
            entry.setValue(object.get("value").contains(entry.getKey()) ? entry.getValue()-entry.getValue()/3 : entry.getValue());
            return entry;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
