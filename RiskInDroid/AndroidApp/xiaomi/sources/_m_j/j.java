package _m_j;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class j {

    public interface O000000o {
    }

    public static final class O00000o implements O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final at f1688O000000o;
        public final int O00000Oo;
        public final int O00000o0;

        public O00000o(at atVar, int i, int i2) {
            this.f1688O000000o = atVar;
            this.O00000o0 = i;
            this.O00000Oo = i2;
        }
    }

    public static final class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f1689O000000o;
        public int O00000Oo;
        public String O00000o;
        public boolean O00000o0;
        public int O00000oO;
        public int O00000oo;

        public O00000o0(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f1689O000000o = str;
            this.O00000Oo = i;
            this.O00000o0 = z;
            this.O00000o = str2;
            this.O00000oO = i2;
            this.O00000oo = i3;
        }
    }

    public static final class O00000Oo implements O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final O00000o0[] f1687O000000o;

        public O00000Oo(O00000o0[] o00000o0Arr) {
            this.f1687O000000o = o00000o0Arr;
        }
    }

    public static O000000o O000000o(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlPullParser.require(2, null, "font-family");
            if (xmlPullParser.getName().equals("font-family")) {
                return O00000Oo(xmlPullParser, resources);
            }
            O000000o(xmlPullParser);
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static O000000o O00000Oo(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{R.attr.fontProviderAuthority, R.attr.fontProviderCerts, R.attr.fontProviderFetchStrategy, R.attr.fontProviderFetchTimeout, R.attr.fontProviderPackage, R.attr.fontProviderQuery});
        String string = obtainAttributes.getString(0);
        String string2 = obtainAttributes.getString(4);
        String string3 = obtainAttributes.getString(5);
        int resourceId = obtainAttributes.getResourceId(1, 0);
        int integer = obtainAttributes.getInteger(2, 1);
        int integer2 = obtainAttributes.getInteger(3, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(O00000o0(xmlPullParser, resources));
                    } else {
                        O000000o(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new O00000Oo((O00000o0[]) arrayList.toArray(new O00000o0[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            O000000o(xmlPullParser);
        }
        return new O00000o(new at(string, string2, string3, O000000o(resources, resourceId)), integer, integer2);
    }

    public static List<List<byte[]>> O000000o(Resources resources, int i) {
        int i2;
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 21) {
                i2 = obtainTypedArray.getType(0);
            } else {
                TypedValue typedValue = new TypedValue();
                obtainTypedArray.getValue(0, typedValue);
                i2 = typedValue.type;
            }
            if (i2 == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(O000000o(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(O000000o(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> O000000o(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static O00000o0 O00000o0(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{16844082, 16844083, 16844095, 16844143, 16844144, R.attr.font, R.attr.fontStyle, R.attr.fontVariationSettings, R.attr.fontWeight, R.attr.ttcIndex});
        int i = 8;
        if (!obtainAttributes.hasValue(8)) {
            i = 1;
        }
        int i2 = obtainAttributes.getInt(i, 400);
        int i3 = 6;
        if (!obtainAttributes.hasValue(6)) {
            i3 = 2;
        }
        boolean z = 1 == obtainAttributes.getInt(i3, 0);
        int i4 = 9;
        if (!obtainAttributes.hasValue(9)) {
            i4 = 3;
        }
        int i5 = 7;
        if (!obtainAttributes.hasValue(7)) {
            i5 = 4;
        }
        String string = obtainAttributes.getString(i5);
        int i6 = obtainAttributes.getInt(i4, 0);
        int i7 = 5;
        if (!obtainAttributes.hasValue(5)) {
            i7 = 0;
        }
        int resourceId = obtainAttributes.getResourceId(i7, 0);
        String string2 = obtainAttributes.getString(i7);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            O000000o(xmlPullParser);
        }
        return new O00000o0(string2, i2, z, string, i6, resourceId);
    }

    private static void O000000o(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
