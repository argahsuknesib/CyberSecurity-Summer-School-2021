package _m_j;

import _m_j.k;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Shader f1061O000000o;
    public int O00000Oo;
    private final ColorStateList O00000o0;

    private i(Shader shader, ColorStateList colorStateList, int i) {
        this.f1061O000000o = shader;
        this.O00000o0 = colorStateList;
        this.O00000Oo = i;
    }

    static i O000000o(int i) {
        return new i(null, null, i);
    }

    public final boolean O000000o() {
        return this.f1061O000000o != null;
    }

    public final boolean O00000Oo() {
        ColorStateList colorStateList;
        return this.f1061O000000o == null && (colorStateList = this.O00000o0) != null && colorStateList.isStateful();
    }

    public final boolean O000000o(int[] iArr) {
        if (O00000Oo()) {
            ColorStateList colorStateList = this.O00000o0;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.O00000Oo) {
                this.O00000Oo = colorForState;
                return true;
            }
        }
        return false;
    }

    public final boolean O00000o0() {
        return O000000o() || this.O00000Oo != 0;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v10, types: [android.graphics.Shader] */
    /* JADX WARN: Type inference failed for: r21v2, types: [android.graphics.RadialGradient] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r16v1, types: [android.graphics.LinearGradient] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float
     arg types: [android.content.res.TypedArray, android.content.res.XmlResourceParser, java.lang.String, int, int]
     candidates:
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme, java.lang.String, int):_m_j.i
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int
     arg types: [android.content.res.TypedArray, android.content.res.XmlResourceParser, java.lang.String, int, int]
     candidates:
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme, java.lang.String, int):_m_j.i
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static i O000000o(Resources resources, int i, Resources.Theme theme) {
        int next;
        ? r1;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                String name = xml.getName();
                char c = 65535;
                int hashCode = name.hashCode();
                if (hashCode != 89650992) {
                    if (hashCode == 1191572447) {
                        if (name.equals("selector")) {
                            c = 0;
                        }
                    }
                } else if (name.equals("gradient")) {
                    c = 1;
                }
                if (c == 0) {
                    ColorStateList O000000o2 = h.O000000o(resources2, xml, asAttributeSet, theme2);
                    return new i(null, O000000o2, O000000o2.getDefaultColor());
                } else if (c == 1) {
                    String name2 = xml.getName();
                    if (name2.equals("gradient")) {
                        TypedArray O000000o3 = n.O000000o(resources2, theme2, asAttributeSet, new int[]{16843165, 16843166, 16843169, 16843170, 16843171, 16843172, 16843265, 16843275, 16844048, 16844049, 16844050, 16844051});
                        float O000000o4 = n.O000000o(O000000o3, (XmlPullParser) xml, "startX", 8, 0.0f);
                        float O000000o5 = n.O000000o(O000000o3, (XmlPullParser) xml, "startY", 9, 0.0f);
                        float O000000o6 = n.O000000o(O000000o3, (XmlPullParser) xml, "endX", 10, 0.0f);
                        float O000000o7 = n.O000000o(O000000o3, (XmlPullParser) xml, "endY", 11, 0.0f);
                        float O000000o8 = n.O000000o(O000000o3, (XmlPullParser) xml, "centerX", 3, 0.0f);
                        float O000000o9 = n.O000000o(O000000o3, (XmlPullParser) xml, "centerY", 4, 0.0f);
                        int O000000o10 = n.O000000o(O000000o3, (XmlPullParser) xml, "type", 2, 0);
                        int O000000o11 = n.O000000o(O000000o3, xml, "startColor", 0);
                        boolean O000000o12 = n.O000000o(xml, "centerColor");
                        int O000000o13 = n.O000000o(O000000o3, xml, "centerColor", 7);
                        int O000000o14 = n.O000000o(O000000o3, xml, "endColor", 1);
                        int O000000o15 = n.O000000o(O000000o3, (XmlPullParser) xml, "tileMode", 6, 0);
                        float O000000o16 = n.O000000o(O000000o3, (XmlPullParser) xml, "gradientRadius", 5, 0.0f);
                        O000000o3.recycle();
                        k.O000000o O000000o17 = k.O000000o(resources2, xml, asAttributeSet, theme2);
                        if (O000000o17 == null) {
                            if (O000000o12) {
                                O000000o17 = new k.O000000o(O000000o11, O000000o13, O000000o14);
                            } else {
                                O000000o17 = new k.O000000o(O000000o11, O000000o14);
                            }
                        }
                        if (O000000o10 != 1) {
                            if (O000000o10 != 2) {
                                int[] iArr = O000000o17.f2126O000000o;
                                r1 = new LinearGradient(O000000o4, O000000o5, O000000o6, O000000o7, iArr, O000000o17.O00000Oo, k.O000000o(O000000o15));
                            } else {
                                r1 = new SweepGradient(O000000o8, O000000o9, O000000o17.f2126O000000o, O000000o17.O00000Oo);
                            }
                        } else if (O000000o16 > 0.0f) {
                            int[] iArr2 = O000000o17.f2126O000000o;
                            r1 = new RadialGradient(O000000o8, O000000o9, O000000o16, iArr2, O000000o17.O00000Oo, k.O000000o(O000000o15));
                        } else {
                            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                        }
                        return new i(r1, null, 0);
                    }
                    throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
                } else {
                    throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
                }
            } else {
                throw new XmlPullParserException("No start tag found");
            }
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }
}
