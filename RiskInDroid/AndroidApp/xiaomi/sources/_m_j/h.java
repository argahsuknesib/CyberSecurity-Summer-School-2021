package _m_j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class h {
    public static ColorStateList O000000o(Resources resources, int i, Resources.Theme theme) {
        try {
            return O000000o(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    public static ColorStateList O000000o(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return O000000o(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList O000000o(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return O00000Oo(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static ColorStateList O00000Oo(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        TypedArray typedArray;
        AttributeSet attributeSet2 = attributeSet;
        Resources.Theme theme2 = theme;
        int i = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArr2 = new int[20];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                int[] iArr3 = new int[i2];
                int[][] iArr4 = new int[i2][];
                System.arraycopy(iArr2, 0, iArr3, 0, i2);
                System.arraycopy(iArr, 0, iArr4, 0, i2);
            } else {
                if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                    int[] iArr5 = {16843173, 16843551, R.attr.alpha};
                    if (theme2 == null) {
                        typedArray = resources.obtainAttributes(attributeSet2, iArr5);
                    } else {
                        typedArray = theme2.obtainStyledAttributes(attributeSet2, iArr5, 0, 0);
                    }
                    int color = typedArray.getColor(0, -65281);
                    float f = 1.0f;
                    if (typedArray.hasValue(i)) {
                        f = typedArray.getFloat(i, 1.0f);
                    } else if (typedArray.hasValue(2)) {
                        f = typedArray.getFloat(2, 1.0f);
                    }
                    typedArray.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr6 = new int[attributeCount];
                    int i3 = 0;
                    for (int i4 = 0; i4 < attributeCount; i4++) {
                        int attributeNameResource = attributeSet2.getAttributeNameResource(i4);
                        if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == R.attr.alpha)) {
                            int i5 = i3 + 1;
                            if (!attributeSet2.getAttributeBooleanValue(i4, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr6[i3] = attributeNameResource;
                            i3 = i5;
                        }
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr6, i3);
                    int round = (Math.round(((float) Color.alpha(color)) * f) << 24) | (color & 16777215);
                    int i6 = i2 + 1;
                    if (i6 > iArr2.length) {
                        int[] iArr7 = new int[l.O000000o(i2)];
                        System.arraycopy(iArr2, 0, iArr7, 0, i2);
                        iArr2 = iArr7;
                    }
                    iArr2[i2] = round;
                    if (i6 > iArr.length) {
                        ? r8 = (Object[]) Array.newInstance(iArr.getClass().getComponentType(), l.O000000o(i2));
                        System.arraycopy(iArr, 0, r8, 0, i2);
                        iArr = r8;
                    }
                    iArr[i2] = trimStateSet;
                    iArr = iArr;
                    i2 = i6;
                }
                i = 1;
            }
        }
        int[] iArr32 = new int[i2];
        int[][] iArr42 = new int[i2][];
        System.arraycopy(iArr2, 0, iArr32, 0, i2);
        System.arraycopy(iArr, 0, iArr42, 0, i2);
        return new ColorStateList(iArr42, iArr32);
    }
}
