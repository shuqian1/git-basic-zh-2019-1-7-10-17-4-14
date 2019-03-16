package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeD {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String,Integer> map = new HashMap<>();
        collectionA.forEach(i -> {
            String key = "";
            int value = 1;
            if(i.contains("[")){
                int index = i.indexOf("[");
                key = i.substring(0,index);
                value = Integer.parseInt(i.substring(index+1,i.length()-1));
            }else if(i.contains("-") || i.contains(":")){
                String[] s = i.split("[:-]");
                key = s[0];
                value = Integer.parseInt(s[1]);
            }else {
                key = i;
            }
            map.put(key,map.containsKey(key) ? map.get(key)+value : value);
        });
        return map.entrySet().stream().map(entry ->{
            entry.setValue(object.get("value").contains(entry.getKey()) ? entry.getValue()-entry.getValue()/3 : entry.getValue());
            return entry;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
