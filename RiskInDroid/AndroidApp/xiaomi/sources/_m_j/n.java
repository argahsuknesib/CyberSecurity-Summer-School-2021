package _m_j;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public final class n {
    public static boolean O000000o(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static float O000000o(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        if (!O000000o(xmlPullParser, str)) {
            return f;
        }
        return typedArray.getFloat(i, f);
    }

    public static boolean O000000o(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        if (!O000000o(xmlPullParser, str)) {
            return z;
        }
        return typedArray.getBoolean(i, z);
    }

    public static int O000000o(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!O000000o(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getInt(i, i2);
    }

    public static int O000000o(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!O000000o(xmlPullParser, str)) {
            return 0;
        }
        return typedArray.getColor(i, 0);
    }

    public static i O000000o(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        if (O000000o(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return i.O000000o(typedValue.data);
            }
            i O000000o2 = i.O000000o(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (O000000o2 != null) {
                return O000000o2;
            }
        }
        return i.O000000o(0);
    }

    public static int O00000Oo(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!O000000o(xmlPullParser, str)) {
            return 0;
        }
        return typedArray.getResourceId(i, 0);
    }

    public static String O00000o0(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!O000000o(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i);
    }

    public static TypedValue O000000o(TypedArray typedArray, XmlPullParser xmlPullParser, String str) {
        if (!O000000o(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(0);
    }

    public static TypedArray O000000o(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
