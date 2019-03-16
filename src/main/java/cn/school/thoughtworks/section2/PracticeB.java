package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeB {
    Map<String, Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String,Integer> map = new HashMap<>();
        collection1.forEach(i -> {
            int value = 1;
            String key = "";
            if(i.contains("-")){
                String[] s = i.split("-");
                value = Integer.parseInt(s[1]);
                key = s[0];
            }else {
                key = i;
            }
            map.put(key,map.containsKey(key) ? map.get(key)+value : value);
        });
//        System.out.println(map.toString());
        return map;
    }
}
