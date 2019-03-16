package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class PracticeA {
    Map<String, Integer> createUpdatedCollection(Map<String, Integer> collectionA, Map<String, List<String>> object) {
        //实现练习要求，并改写该行代码。

        return collectionA.entrySet().stream().peek(entry -> entry.setValue(object.get("value").contains(entry.getKey()) ? entry.getValue() - 1 : entry.getValue())).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }
}
