package hexlet.code;

import java.util.Map;
import java.util.Objects;

public final class Difference {
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
}
