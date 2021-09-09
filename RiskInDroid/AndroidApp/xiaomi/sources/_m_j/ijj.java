package _m_j;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public final class ijj {
    public static String O000000o(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(map);
        for (Map.Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getValue();
            if (str != null) {
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append(str);
                sb.append("&");
            } else if (entry.getKey() != null) {
                map.remove(entry.getKey());
            }
        }
        if (!map.isEmpty() && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = java.net.URLEncoder.encode((java.lang.String) r1.getValue(), "UTF-8");
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[EDGE_INSN: B:16:0x003f->B:13:0x003f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    public static Map<String, String> O00000Oo(Map<String, String> map) {
        String str;
        String str2;
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                Map.Entry next = it.next();
                str = (String) next.getKey();
                if (str.equals("q") || str.equals("tag_name")) {
                    str2 = null;
                }
                if (!it.hasNext()) {
                    break;
                }
            }
        }
        return map;
        map.put(str, str2);
        return map;
    }
}
