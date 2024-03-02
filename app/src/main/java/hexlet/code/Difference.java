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
        var type = getDifferenceType(name, map1, map2);
        diff.put("type", type);
        switch (type) {
            case "added":
                diff.put("addedValue", map2.get(name));
                break;
            case "removed":
                diff.put("removedValue", map1.get(name));
                break;
            case "unchanged":
                diff.put("unchangedValue", map1.get(name));
                break;
            case "updated":
                diff.put("oldValue", map1.get(name));
                diff.put("newValue", map2.get(name));
                break;
            default:
                throw new RuntimeException();
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

    private static String getDifferenceType(String name, Map<String, Object> map1, Map<String, Object> map2)
        throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("'Name' is null");
        }
        if (!map1.containsKey(name) && !map2.containsKey(name)) {
            throw new IllegalArgumentException("No 'name' value in map1 and map2");
        }
        if (!map1.containsKey(name)) {
            return "added";
        }
        if (!map2.containsKey(name)) {
            return "removed";
        }
        if (Objects.equals(map1.get(name), map2.get(name))) {
            return "unchanged";
        } else {
            return "updated";
        }
    }

}
