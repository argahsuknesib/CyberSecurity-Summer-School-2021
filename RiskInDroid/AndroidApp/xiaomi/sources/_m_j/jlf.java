package _m_j;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class jlf {

    /* renamed from: O000000o  reason: collision with root package name */
    static Pattern f1916O000000o = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");

    public static <T extends jgy> List<T> O000000o(jgy jgy, String str) {
        return O000000o(jgy, str, false);
    }

    private static <T extends jgy> List<T> O000000o(Object obj, String str, boolean z) {
        String str2;
        if (str.startsWith("/")) {
            throw new RuntimeException("Cannot start at / - only relative path expression into the structure are allowed");
        } else if (str.length() != 0) {
            int i = 0;
            if (str.contains("/")) {
                str2 = str.substring(str.indexOf(47) + 1);
                str = str.substring(0, str.indexOf(47));
            } else {
                str2 = "";
            }
            Matcher matcher = f1916O000000o.matcher(str);
            if (matcher.matches()) {
                String group = matcher.group(1);
                if ("..".equals(group)) {
                    throw new RuntimeException(".. notation no longer allowed");
                } else if (!(obj instanceof jha)) {
                    return Collections.emptyList();
                } else {
                    int parseInt = matcher.group(2) != null ? Integer.parseInt(matcher.group(3)) : -1;
                    LinkedList linkedList = new LinkedList();
                    for (jgy next : ((jha) obj).getBoxes()) {
                        if (next.getType().matches(group)) {
                            if (parseInt == -1 || parseInt == i) {
                                linkedList.addAll(O000000o(next, str2, z));
                            }
                            i++;
                        }
                        if ((z || parseInt >= 0) && !linkedList.isEmpty()) {
                            return linkedList;
                        }
                    }
                    return linkedList;
                }
            } else {
                throw new RuntimeException(String.valueOf(str) + " is invalid path.");
            }
        } else if (obj instanceof jhd) {
            return Collections.singletonList((jgy) obj);
        } else {
            throw new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
        }
    }

    public static <T extends jgy> T O000000o(jha jha, String str) {
        List O000000o2 = O000000o(jha, str, true);
        if (O000000o2.isEmpty()) {
            return null;
        }
        return (jgy) O000000o2.get(0);
    }

    public static <T extends jgy> T O000000o(jko jko, String str) {
        List O000000o2 = O000000o(jko, str, true);
        if (O000000o2.isEmpty()) {
            return null;
        }
        return (jgy) O000000o2.get(0);
    }

    public static <T extends jgy> List<T> O00000Oo(jha jha, String str) {
        return O000000o(jha, str, false);
    }
}
