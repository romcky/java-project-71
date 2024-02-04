package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Difference {

    public static Map<String, Object>
            getDifference(String name, Map<String, Object> map1, Map<String, Object> map2) {
        var diff = new HashMap<String, Object>();
        diff.put("name", name);
        if (!map1.containsKey(name)) {
            diff.put("type", "added");
            diff.put("addedValue", map2.get(name));
        } else if (!map2.containsKey(name)) {
            diff.put("type", "removed");
            diff.put("removedValue", map1.get(name));
        } else if (Objects.equals(map1.get(name), map2.get(name))) {
            diff.put("type", "unchanged");
            diff.put("unchangedValue", map1.get(name));
        } else {
            diff.put("type", "updated");
            diff.put("oldValue", map1.get(name));
            diff.put("newValue", map2.get(name));
        }
        return diff;
    }

    public static List<Map<String, Object>>
            getDifferenceList(Map<String, Object> map1, Map<String, Object> map2) {
        return Stream.concat(map1.keySet().stream(), map2.keySet().stream())
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .map(key -> getDifference(key, map1, map2))
                .collect(Collectors.toList());
    }
}
