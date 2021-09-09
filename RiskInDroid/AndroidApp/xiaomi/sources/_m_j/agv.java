package _m_j;

import java.util.HashMap;

public final class agv extends xr {
    protected static final HashMap<Integer, String> O0000O0o;
    private final ws O0000OOo;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O0000O0o = hashMap;
        hashMap.put(2, "Image Height");
        O0000O0o.put(1, "Image Width");
        O0000O0o.put(3, "Bits Per Sample");
        O0000O0o.put(4, "Color Type");
        O0000O0o.put(5, "Compression Type");
        O0000O0o.put(6, "Filter Method");
        O0000O0o.put(7, "Interlace Method");
        O0000O0o.put(8, "Palette Size");
        O0000O0o.put(9, "Palette Has Transparency");
        O0000O0o.put(10, "sRGB Rendering Intent");
        O0000O0o.put(11, "Image Gamma");
        O0000O0o.put(12, "ICC Profile Name");
        O0000O0o.put(13, "Textual Data");
        O0000O0o.put(14, "Last Modification Time");
        O0000O0o.put(15, "Background Color");
        O0000O0o.put(16, "Pixels Per Unit X");
        O0000O0o.put(17, "Pixels Per Unit Y");
        O0000O0o.put(18, "Unit Specifier");
        O0000O0o.put(19, "Significant Bits");
    }

    public agv(ws wsVar) {
        this.O0000OOo = wsVar;
        O000000o(new agu(this));
    }

    public final String O000000o() {
        return "PNG-" + this.O0000OOo.O000000o();
    }

    public final HashMap<Integer, String> O00000Oo() {
        return O0000O0o;
    }
}
