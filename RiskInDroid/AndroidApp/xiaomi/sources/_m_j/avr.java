package _m_j;

import java.util.Map;

public abstract class avr {
    public static <K, V> String O000000o(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            sb.append(", ");
            sb.append(next.getKey().toString());
            sb.append(" -> ");
            sb.append(next.getValue().toString());
            sb.append(' ');
        }
        StringBuilder sb2 = new StringBuilder("{");
        sb.append('}');
        sb2.append(sb.substring(1));
        return sb2.toString();
    }
}
