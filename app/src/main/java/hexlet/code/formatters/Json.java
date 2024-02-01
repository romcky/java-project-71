package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

    public static String format(List<Map<String, Object>> diffList)
            throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(diffList);
    }
    /*
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public String format(List<Difference> diffList) {
        return "[" + diffList.stream()
            .sorted(Comparator.comparing(Difference::getName))
            .map(this::toJson)
            .filter(str -> !str.isEmpty())
            .collect(Collectors.joining(",")) + "]";
    }

    public String toJson(Difference diff) {
        try {
            var nodeMap = new HashMap<String, Object>();
            nodeMap.put("type", diff.getType());
            nodeMap.put("name", diff.getName());
            switch (diff.getType()) {
                case Difference.UPDATED:
                    nodeMap.put("oldValue", diff.getOldValue());
                    nodeMap.put("newValue", diff.getNewValue());
                    break;
                case Difference.UNCHANGED:
                case Difference.REMOVED:
                    nodeMap.put("oldValue", diff.getOldValue());
                    break;
                case Difference.ADDED:
                    nodeMap.put("newValue", diff.getNewValue());
                    break;
                default:
                    return "";
            }
            return MAPPER.writeValueAsString(nodeMap);
        } catch (Exception e) {
            return "";
        }
    }

     */
}
