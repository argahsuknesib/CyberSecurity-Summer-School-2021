package _m_j;

import com.drew.metadata.jpeg.JpegComponent;
import java.util.HashMap;

public class acx extends xr {
    protected static final HashMap<Integer, String> O0000O0o;

    public final String O000000o() {
        return "JPEG";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O0000O0o = hashMap;
        hashMap.put(-3, "Compression Type");
        O0000O0o.put(0, "Data Precision");
        O0000O0o.put(3, "Image Width");
        O0000O0o.put(1, "Image Height");
        O0000O0o.put(5, "Number of Components");
        O0000O0o.put(6, "Component 1");
        O0000O0o.put(7, "Component 2");
        O0000O0o.put(8, "Component 3");
        O0000O0o.put(9, "Component 4");
    }

    public acx() {
        O000000o(new acv(this));
    }

    public final HashMap<Integer, String> O00000Oo() {
        return O0000O0o;
    }

    public final JpegComponent O0000oOO(int i) {
        return (JpegComponent) O0000o0o(i + 6);
    }
}
