package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeB {
    Map<String,Integer> createUpdatedCollection(Map<String,Integer> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。

        return collectionA.entrySet().stream().map(entry ->{
            entry.setValue(object.get("value").contains(entry.getKey()) ? entry.getValue()-entry.getValue()/3 : entry.getValue());
            return entry;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
