package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        collection1.forEach(a -> {
            StringBuilder key = new StringBuilder();
            String regex = "^(\\w+)\\[(\\d+)]$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(a);
            int number = 1;
            if (a.contains("-") || a.contains(":")) {
                String[] split = a.split("[-:]");
                key.append(split[0]);
                number = Integer.parseInt(split[1]);
            } else if (matcher.find()) {
                key.append(matcher.group(1));
                number = Integer.parseInt(matcher.group(2));
            } else {
                key.append(a);
            }
            hashMap.put(key.toString(), hashMap.containsKey(key.toString()) ? hashMap.get(key.toString()) + number : number);
        });
        return hashMap;
    }
}
