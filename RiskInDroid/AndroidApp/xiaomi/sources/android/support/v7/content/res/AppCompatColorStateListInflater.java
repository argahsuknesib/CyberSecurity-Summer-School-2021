package android.support.v7.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class AppCompatColorStateListInflater {
    private AppCompatColorStateListInflater() {
    }

    @NonNull
    public static ColorStateList createFromXml(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    private static ColorStateList createFromXmlInner(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    private static ColorStateList inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        AttributeSet attributeSet2 = attributeSet;
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
                    TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet2, new int[]{16843173, 16843551, R.attr.alpha});
                    int color = obtainAttributes.getColor(0, -65281);
                    float f = 1.0f;
                    if (obtainAttributes.hasValue(i)) {
                        f = obtainAttributes.getFloat(i, 1.0f);
                    } else if (obtainAttributes.hasValue(2)) {
                        f = obtainAttributes.getFloat(2, 1.0f);
                    }
                    obtainAttributes.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr5 = new int[attributeCount];
                    int i3 = 0;
                    for (int i4 = 0; i4 < attributeCount; i4++) {
                        int attributeNameResource = attributeSet2.getAttributeNameResource(i4);
                        if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == R.attr.alpha)) {
                            int i5 = i3 + 1;
                            if (!attributeSet2.getAttributeBooleanValue(i4, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr5[i3] = attributeNameResource;
                            i3 = i5;
                        }
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr5, i3);
                    iArr2 = GrowingArrayUtils.append(iArr2, i2, modulateColorAlpha(color, f));
                    iArr = GrowingArrayUtils.append(iArr, i2, trimStateSet);
                    i2++;
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

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static int modulateColorAlpha(int i, float f) {
        return ColorUtils.setAlphaComponent(i, Math.round(((float) Color.alpha(i)) * f));
    }
}
