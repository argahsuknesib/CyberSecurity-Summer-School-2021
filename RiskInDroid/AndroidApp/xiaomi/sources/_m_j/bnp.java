package _m_j;

import java.util.HashMap;
import java.util.Locale;

public final class bnp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final HashMap<String, Integer> f13145O000000o;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f13145O000000o = hashMap;
        hashMap.put("black", -16777216);
        f13145O000000o.put("darkgray", -12303292);
        f13145O000000o.put("gray", -7829368);
        f13145O000000o.put("lightgray", -3355444);
        f13145O000000o.put("white", -1);
        f13145O000000o.put("red", -65536);
        f13145O000000o.put("green", -16711936);
        f13145O000000o.put("blue", -16776961);
        f13145O000000o.put("yellow", -256);
        f13145O000000o.put("cyan", -16711681);
        f13145O000000o.put("magenta", -65281);
        f13145O000000o.put("aqua", -16711681);
        f13145O000000o.put("fuchsia", -65281);
        f13145O000000o.put("darkgrey", -12303292);
        f13145O000000o.put("grey", -7829368);
        f13145O000000o.put("lightgrey", -3355444);
        f13145O000000o.put("lime", -16711936);
        f13145O000000o.put("maroon", -8388608);
        f13145O000000o.put("navy", -16777088);
        f13145O000000o.put("olive", -8355840);
        f13145O000000o.put("purple", -8388480);
        f13145O000000o.put("silver", -4144960);
        f13145O000000o.put("teal", -16744320);
    }

    public static int O000000o(String str) {
        if (str.charAt(0) == '#') {
            long parseLong = Long.parseLong(str.substring(1), 16);
            if (str.length() == 7) {
                parseLong |= -16777216;
            } else if (str.length() != 9) {
                throw new IllegalArgumentException("Unknown color");
            }
            return (int) parseLong;
        }
        Integer num = f13145O000000o.get(str.toLowerCase(Locale.ROOT));
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("Unknown color");
    }
}
