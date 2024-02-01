package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Difference {
    /*
    private String type;
    private String name;
    private Object oldValue;
    private Object newValue;

    private Difference(String type, String name, Object oldValue, Object newValue) {
        this.type = type;
        this.name = name;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    private Difference(String type, String name, Object someValue) {
        this(type, name, someValue, someValue);
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public static final String ADDED = "added";
    public static final String REMOVED = "removed";
    public static final String UNCHANGED = "unchanged";
    public static final String UPDATED = "updated";

    public static Difference
            getDifference(String key, Map<String, Object> map1, Map<String, Object> map2) {
        if (!map1.containsKey(key)) {
            return new Difference(ADDED, key, map2.get(key));
        } else if (!map2.containsKey(key)) {
            return new Difference(REMOVED, key, map1.get(key));
        } else if (Objects.equals(map1.get(key), map2.get(key))) {
            return new Difference(UNCHANGED, key, map1.get(key), map2.get(key));
        } else {
            return new Difference(UPDATED, key, map1.get(key), map2.get(key));
        }
    }

     */
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
