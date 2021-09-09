package _m_j;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.horcrux.svg.TextProperties;

public final class bak {
    static final bak O0000o00 = new bak();

    /* renamed from: O000000o  reason: collision with root package name */
    public final double f12745O000000o;
    public final String O00000Oo;
    public final ReadableMap O00000o;
    public final TextProperties.FontStyle O00000o0;
    public final TextProperties.FontWeight O00000oO;
    public final String O00000oo;
    public final TextProperties.FontVariantLigatures O0000O0o;
    public final TextProperties.TextAnchor O0000OOo;
    public final double O0000Oo;
    public final double O0000Oo0;
    public final double O0000OoO;
    public final boolean O0000Ooo;
    private final TextProperties.TextDecoration O0000o0;

    private bak() {
        this.O00000o = null;
        this.O00000Oo = "";
        this.O00000o0 = TextProperties.FontStyle.normal;
        this.O00000oO = TextProperties.FontWeight.Normal;
        this.O00000oo = "";
        this.O0000O0o = TextProperties.FontVariantLigatures.normal;
        this.O0000OOo = TextProperties.TextAnchor.start;
        this.O0000o0 = TextProperties.TextDecoration.None;
        this.O0000Ooo = false;
        this.O0000Oo0 = 0.0d;
        this.f12745O000000o = 12.0d;
        this.O0000Oo = 0.0d;
        this.O0000OoO = 0.0d;
    }

    bak(ReadableMap readableMap, bak bak, double d) {
        double d2;
        double d3;
        double d4;
        double d5 = bak.f12745O000000o;
        if (!readableMap.hasKey("fontSize")) {
            this.f12745O000000o = d5;
        } else if (readableMap.getType("fontSize") == ReadableType.Number) {
            this.f12745O000000o = readableMap.getDouble("fontSize");
        } else {
            this.f12745O000000o = bao.O000000o(readableMap.getString("fontSize"), d5, 1.0d, d5);
        }
        this.O00000o = readableMap.hasKey("fontData") ? readableMap.getMap("fontData") : bak.O00000o;
        this.O00000Oo = readableMap.hasKey("fontFamily") ? readableMap.getString("fontFamily") : bak.O00000Oo;
        this.O00000o0 = readableMap.hasKey("fontStyle") ? TextProperties.FontStyle.valueOf(readableMap.getString("fontStyle")) : bak.O00000o0;
        this.O00000oO = readableMap.hasKey("fontWeight") ? TextProperties.FontWeight.getEnum(readableMap.getString("fontWeight")) : bak.O00000oO;
        this.O00000oo = readableMap.hasKey("fontFeatureSettings") ? readableMap.getString("fontFeatureSettings") : bak.O00000oo;
        this.O0000O0o = readableMap.hasKey("fontVariantLigatures") ? TextProperties.FontVariantLigatures.valueOf(readableMap.getString("fontVariantLigatures")) : bak.O0000O0o;
        this.O0000OOo = readableMap.hasKey("textAnchor") ? TextProperties.TextAnchor.valueOf(readableMap.getString("textAnchor")) : bak.O0000OOo;
        this.O0000o0 = readableMap.hasKey("textDecoration") ? TextProperties.TextDecoration.getEnum(readableMap.getString("textDecoration")) : bak.O0000o0;
        boolean hasKey = readableMap.hasKey("kerning");
        this.O0000Ooo = hasKey || bak.O0000Ooo;
        if (hasKey) {
            d2 = bao.O000000o(readableMap.getString("kerning"), 0.0d, d, this.f12745O000000o);
        } else {
            d2 = bak.O0000Oo0;
        }
        this.O0000Oo0 = d2;
        if (readableMap.hasKey("wordSpacing")) {
            d3 = bao.O000000o(readableMap.getString("wordSpacing"), 0.0d, d, this.f12745O000000o);
        } else {
            d3 = bak.O0000Oo;
        }
        this.O0000Oo = d3;
        if (readableMap.hasKey("letterSpacing")) {
            d4 = bao.O000000o(readableMap.getString("letterSpacing"), 0.0d, d, this.f12745O000000o);
        } else {
            d4 = bak.O0000OoO;
        }
        this.O0000OoO = d4;
    }
}
