package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ooooO0O0 {

    /* renamed from: O000000o  reason: collision with root package name */
    int f2365O000000o = -1;
    int O00000Oo = -1;
    public SparseArray<O000000o> O00000o = new SparseArray<>();
    int O00000o0 = -1;
    private SparseArray<oOO0OOo0> O00000oO = new SparseArray<>();
    private oOO0Oo00 O00000oo = null;

    public ooooO0O0(Context context, XmlPullParser xmlPullParser) {
        O000000o(context, xmlPullParser);
    }

    private void O000000o(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{R.attr.defaultState});
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.f2365O000000o = obtainStyledAttributes.getResourceId(index, this.f2365O000000o);
            }
        }
        O000000o o000000o = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    char c = 65535;
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    if (!(c == 0 || c == 1)) {
                        if (c == 2) {
                            o000000o = new O000000o(context, xmlPullParser);
                            this.O00000o.put(o000000o.f2366O000000o, o000000o);
                        } else if (c != 3) {
                            Log.v("ConstraintLayoutStates", "unknown tag ".concat(String.valueOf(name)));
                        } else {
                            O00000Oo o00000Oo = new O00000Oo(context, xmlPullParser);
                            if (o000000o != null) {
                                o000000o.O00000Oo.add(o00000Oo);
                            }
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ooooO0O0.O000000o(int, float, float):int
     arg types: [int, int, int]
     candidates:
      _m_j.ooooO0O0.O000000o(int, int, int):int
      _m_j.ooooO0O0.O000000o(int, float, float):int */
    public final int O000000o(int i, int i2, int i3) {
        return O000000o(i, -1.0f, -1.0f);
    }

    private int O000000o(int i, float f, float f2) {
        O000000o o000000o;
        int O000000o2;
        if (-1 == i) {
            if (i == -1) {
                o000000o = this.O00000o.valueAt(0);
            } else {
                o000000o = this.O00000o.get(this.O00000Oo);
            }
            if (o000000o == null) {
                return -1;
            }
            if ((this.O00000o0 == -1 || !o000000o.O00000Oo.get(-1).O000000o(f, f2)) && -1 != (O000000o2 = o000000o.O000000o(f, f2))) {
                return O000000o2 == -1 ? o000000o.O00000o0 : o000000o.O00000Oo.get(O000000o2).O00000oO;
            }
            return -1;
        }
        O000000o o000000o2 = this.O00000o.get(i);
        if (o000000o2 == null) {
            return -1;
        }
        int O000000o3 = o000000o2.O000000o(f, f2);
        return O000000o3 == -1 ? o000000o2.O00000o0 : o000000o2.O00000Oo.get(O000000o3).O00000oO;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2366O000000o;
        public ArrayList<O00000Oo> O00000Oo = new ArrayList<>();
        boolean O00000o;
        public int O00000o0 = -1;

        public O000000o(Context context, XmlPullParser xmlPullParser) {
            this.O00000o = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{16842960, R.attr.constraints});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.f2366O000000o = obtainStyledAttributes.getResourceId(index, this.f2366O000000o);
                } else if (index == 1) {
                    this.O00000o0 = obtainStyledAttributes.getResourceId(index, this.O00000o0);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.O00000o0);
                    context.getResources().getResourceName(this.O00000o0);
                    if ("layout".equals(resourceTypeName)) {
                        this.O00000o = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final int O000000o(float f, float f2) {
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                if (this.O00000Oo.get(i).O000000o(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        float f2367O000000o = Float.NaN;
        float O00000Oo = Float.NaN;
        float O00000o = Float.NaN;
        float O00000o0 = Float.NaN;
        public int O00000oO = -1;
        boolean O00000oo;

        public O00000Oo(Context context, XmlPullParser xmlPullParser) {
            this.O00000oo = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{R.attr.constraints, R.attr.region_heightLessThan, R.attr.region_heightMoreThan, R.attr.region_widthLessThan, R.attr.region_widthMoreThan});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.O00000oO = obtainStyledAttributes.getResourceId(index, this.O00000oO);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.O00000oO);
                    context.getResources().getResourceName(this.O00000oO);
                    if ("layout".equals(resourceTypeName)) {
                        this.O00000oo = true;
                    }
                } else if (index == 1) {
                    this.O00000o = obtainStyledAttributes.getDimension(index, this.O00000o);
                } else if (index == 2) {
                    this.O00000Oo = obtainStyledAttributes.getDimension(index, this.O00000Oo);
                } else if (index == 3) {
                    this.O00000o0 = obtainStyledAttributes.getDimension(index, this.O00000o0);
                } else if (index == 4) {
                    this.f2367O000000o = obtainStyledAttributes.getDimension(index, this.f2367O000000o);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final boolean O000000o(float f, float f2) {
            if (!Float.isNaN(this.f2367O000000o) && f < this.f2367O000000o) {
                return false;
            }
            if (!Float.isNaN(this.O00000Oo) && f2 < this.O00000Oo) {
                return false;
            }
            if (!Float.isNaN(this.O00000o0) && f > this.O00000o0) {
                return false;
            }
            if (Float.isNaN(this.O00000o) || f2 <= this.O00000o) {
                return true;
            }
            return false;
        }
    }
}
