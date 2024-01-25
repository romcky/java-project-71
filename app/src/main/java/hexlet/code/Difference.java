package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Difference {
    private String info;
    private String name;
    private Object oldValue;
    private Object newValue;

    public Difference(String info, String name, Object value) {
        this(info, name, value, value);
    }
}
