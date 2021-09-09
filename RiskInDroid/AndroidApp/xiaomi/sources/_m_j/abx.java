package _m_j;

import java.util.HashMap;

public final class abx extends xr {
    protected static final HashMap<Integer, String> O0000O0o;

    public final String O000000o() {
        return "GIF Header";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O0000O0o = hashMap;
        hashMap.put(1, "GIF Format Version");
        O0000O0o.put(3, "Image Height");
        O0000O0o.put(2, "Image Width");
        O0000O0o.put(4, "Color Table Size");
        O0000O0o.put(5, "Is Color Table Sorted");
        O0000O0o.put(6, "Bits per Pixel");
        O0000O0o.put(7, "Has Global Color Table");
        O0000O0o.put(8, "Background Color Index");
        O0000O0o.put(9, "Pixel Aspect Ratio");
    }

    public abx() {
        O000000o(new abw(this));
    }

    public final HashMap<Integer, String> O00000Oo() {
        return O0000O0o;
    }
}
