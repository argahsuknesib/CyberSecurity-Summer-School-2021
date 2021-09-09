package _m_j;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class k {
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    static O000000o O000000o(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1 && ((depth = xmlPullParser.getDepth()) >= depth2 || next != 3)) {
                if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                    TypedArray O000000o2 = n.O000000o(resources, theme, attributeSet, new int[]{16843173, 16844052});
                    boolean hasValue = O000000o2.hasValue(0);
                    boolean hasValue2 = O000000o2.hasValue(1);
                    if (!hasValue || !hasValue2) {
                    } else {
                        int color = O000000o2.getColor(0, 0);
                        float f = O000000o2.getFloat(1, 0.0f);
                        O000000o2.recycle();
                        arrayList2.add(Integer.valueOf(color));
                        arrayList.add(Float.valueOf(f));
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            return new O000000o(arrayList2, arrayList);
        }
        return null;
    }

    static Shader.TileMode O000000o(int i) {
        if (i == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i != 2) {
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.MIRROR;
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int[] f2126O000000o;
        final float[] O00000Oo;

        O000000o(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f2126O000000o = new int[size];
            this.O00000Oo = new float[size];
            for (int i = 0; i < size; i++) {
                this.f2126O000000o[i] = list.get(i).intValue();
                this.O00000Oo[i] = list2.get(i).floatValue();
            }
        }

        O000000o(int i, int i2) {
            this.f2126O000000o = new int[]{i, i2};
            this.O00000Oo = new float[]{0.0f, 1.0f};
        }

        O000000o(int i, int i2, int i3) {
            this.f2126O000000o = new int[]{i, i2, i3};
            this.O00000Oo = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
