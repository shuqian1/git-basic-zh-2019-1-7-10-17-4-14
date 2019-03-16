package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeD {
    Map<String, Integer> createUpdatedCollection(List<String> collectionA, Map<String, List<String>> object) {
        //实现练习要求，并改写该行代码。
        HashMap<String, Integer> hashMap = countNumbers(collectionA);
        return compareToCollectionAndDiscount(object, hashMap);
    }

    Map<String, Integer> compareToCollectionAndDiscount(Map<String, List<String>> object, HashMap<String, Integer> hashMap) {
        return hashMap.entrySet().stream().peek(entry -> {
            if (object.get("value").contains(entry.getKey())) {
                Integer value = entry.getValue();
                entry.setValue(value - value / 3);
            }
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public HashMap<String, Integer> countNumbers(List<String> collectionA) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        collectionA.forEach(a -> {
            StringBuilder key = new StringBuilder();
            int number = 1;
            if (a.contains("-")) {
                String[] split = a.split("-");
                key.append(split[0]);
                number = Integer.parseInt(split[1]);
            } else {
                key.append(a);
            }
            hashMap.put(key.toString(), hashMap.containsKey(key.toString()) ? hashMap.get(key.toString()) + number : number);
        });
        return hashMap;
    }
}
