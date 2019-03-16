package cn.school.thoughtworks.section2;

import javafx.scene.shape.VLineTo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String,Integer> map = new HashMap<>();
        collection1.forEach(i -> {
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
        return map;
    }
}
