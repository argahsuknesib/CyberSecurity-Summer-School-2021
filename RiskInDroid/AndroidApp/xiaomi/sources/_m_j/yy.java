package _m_j;

import com.drew.lang.Rational;
import java.util.HashMap;

public class yy extends yk {
    protected static final HashMap<Integer, String> O0000O0o;

    public final String O000000o() {
        return "GPS";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O0000O0o = hashMap;
        O000000o(hashMap);
        O0000O0o.put(0, "GPS Version ID");
        O0000O0o.put(1, "GPS Latitude Ref");
        O0000O0o.put(2, "GPS Latitude");
        O0000O0o.put(3, "GPS Longitude Ref");
        O0000O0o.put(4, "GPS Longitude");
        O0000O0o.put(5, "GPS Altitude Ref");
        O0000O0o.put(6, "GPS Altitude");
        O0000O0o.put(7, "GPS Time-Stamp");
        O0000O0o.put(8, "GPS Satellites");
        O0000O0o.put(9, "GPS Status");
        O0000O0o.put(10, "GPS Measure Mode");
        O0000O0o.put(11, "GPS DOP");
        O0000O0o.put(12, "GPS Speed Ref");
        O0000O0o.put(13, "GPS Speed");
        O0000O0o.put(14, "GPS Track Ref");
        O0000O0o.put(15, "GPS Track");
        O0000O0o.put(16, "GPS Img Direction Ref");
        O0000O0o.put(17, "GPS Img Direction");
        O0000O0o.put(18, "GPS Map Datum");
        O0000O0o.put(19, "GPS Dest Latitude Ref");
        O0000O0o.put(20, "GPS Dest Latitude");
        O0000O0o.put(21, "GPS Dest Longitude Ref");
        O0000O0o.put(22, "GPS Dest Longitude");
        O0000O0o.put(23, "GPS Dest Bearing Ref");
        O0000O0o.put(24, "GPS Dest Bearing");
        O0000O0o.put(25, "GPS Dest Distance Ref");
        O0000O0o.put(26, "GPS Dest Distance");
        O0000O0o.put(27, "GPS Processing Method");
        O0000O0o.put(28, "GPS Area Information");
        O0000O0o.put(29, "GPS Date Stamp");
        O0000O0o.put(30, "GPS Differential");
    }

    public yy() {
        O000000o(new yx(this));
    }

    public final HashMap<Integer, String> O00000Oo() {
        return O0000O0o;
    }

    public final xh O00000oo() {
        Rational[] O0000o00 = O0000o00(2);
        Rational[] O0000o002 = O0000o00(4);
        String O0000o0 = O0000o0(1);
        String O0000o02 = O0000o0(3);
        if (!(O0000o00 == null || O0000o00.length != 3 || O0000o002 == null || O0000o002.length != 3 || O0000o0 == null || O0000o02 == null)) {
            Double O000000o2 = xh.O000000o(O0000o00[0], O0000o00[1], O0000o00[2], O0000o0.equalsIgnoreCase("S"));
            Double O000000o3 = xh.O000000o(O0000o002[0], O0000o002[1], O0000o002[2], O0000o02.equalsIgnoreCase("W"));
            if (!(O000000o2 == null || O000000o3 == null)) {
                return new xh(O000000o2.doubleValue(), O000000o3.doubleValue());
            }
        }
        return null;
    }
}
