package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeB {
    Map<String,Integer> createUpdatedCollection(Map<String,Integer> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        return collectionA.entrySet().stream().map(entry -> {
            Integer value = entry.getValue();
            entry.setValue(object.get("value").contains(entry.getKey()) ? value - value / 3 : value);
            return entry;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
