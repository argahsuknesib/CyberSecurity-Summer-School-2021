package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class oOO0OO0O {

    /* renamed from: O000000o  reason: collision with root package name */
    oOO0OOo0 f2300O000000o;
    int O00000Oo = -1;
    public oOO0Oo00 O00000o = null;
    int O00000o0 = -1;
    private final ConstraintLayout O00000oO;
    private SparseArray<O000000o> O00000oo = new SparseArray<>();
    private SparseArray<oOO0OOo0> O0000O0o = new SparseArray<>();

    public oOO0OO0O(Context context, ConstraintLayout constraintLayout, int i) {
        this.O00000oO = constraintLayout;
        O000000o(context, i);
    }

    public final void O000000o(int i, float f, float f2) {
        oOO0OOo0 ooo0ooo0;
        O000000o o000000o;
        int O000000o2;
        oOO0OOo0 ooo0ooo02;
        int i2 = this.O00000Oo;
        if (i2 == i) {
            if (i == -1) {
                o000000o = this.O00000oo.valueAt(0);
            } else {
                o000000o = this.O00000oo.get(i2);
            }
            if ((this.O00000o0 == -1 || !o000000o.O00000Oo.get(this.O00000o0).O000000o(f, f2)) && this.O00000o0 != (O000000o2 = o000000o.O000000o(f, f2))) {
                if (O000000o2 == -1) {
                    ooo0ooo02 = this.f2300O000000o;
                } else {
                    ooo0ooo02 = o000000o.O00000Oo.get(O000000o2).O00000oo;
                }
                if (O000000o2 != -1) {
                    o000000o.O00000Oo.get(O000000o2);
                }
                if (ooo0ooo02 != null) {
                    this.O00000o0 = O000000o2;
                    ooo0ooo02.O00000o0(this.O00000oO);
                    return;
                }
                return;
            }
            return;
        }
        this.O00000Oo = i;
        O000000o o000000o2 = this.O00000oo.get(this.O00000Oo);
        int O000000o3 = o000000o2.O000000o(f, f2);
        if (O000000o3 == -1) {
            ooo0ooo0 = o000000o2.O00000o;
        } else {
            ooo0ooo0 = o000000o2.O00000Oo.get(O000000o3).O00000oo;
        }
        if (O000000o3 != -1) {
            o000000o2.O00000Oo.get(O000000o3);
        }
        if (ooo0ooo0 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i + ", dim =" + f + ", " + f2);
            return;
        }
        this.O00000o0 = O000000o3;
        ooo0ooo0.O00000o0(this.O00000oO);
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2301O000000o;
        ArrayList<O00000Oo> O00000Oo = new ArrayList<>();
        oOO0OOo0 O00000o;
        int O00000o0 = -1;

        public O000000o(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{16842960, R.attr.constraints});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.f2301O000000o = obtainStyledAttributes.getResourceId(index, this.f2301O000000o);
                } else if (index == 1) {
                    this.O00000o0 = obtainStyledAttributes.getResourceId(index, this.O00000o0);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.O00000o0);
                    context.getResources().getResourceName(this.O00000o0);
                    if ("layout".equals(resourceTypeName)) {
                        this.O00000o = new oOO0OOo0();
                        this.O00000o.O000000o(context, this.O00000o0);
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

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        float f2302O000000o = Float.NaN;
        float O00000Oo = Float.NaN;
        float O00000o = Float.NaN;
        float O00000o0 = Float.NaN;
        int O00000oO = -1;
        oOO0OOo0 O00000oo;

        public O00000Oo(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{R.attr.constraints, R.attr.region_heightLessThan, R.attr.region_heightMoreThan, R.attr.region_widthLessThan, R.attr.region_widthMoreThan});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.O00000oO = obtainStyledAttributes.getResourceId(index, this.O00000oO);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.O00000oO);
                    context.getResources().getResourceName(this.O00000oO);
                    if ("layout".equals(resourceTypeName)) {
                        this.O00000oo = new oOO0OOo0();
                        this.O00000oo.O000000o(context, this.O00000oO);
                    }
                } else if (index == 1) {
                    this.O00000o = obtainStyledAttributes.getDimension(index, this.O00000o);
                } else if (index == 2) {
                    this.O00000Oo = obtainStyledAttributes.getDimension(index, this.O00000Oo);
                } else if (index == 3) {
                    this.O00000o0 = obtainStyledAttributes.getDimension(index, this.O00000o0);
                } else if (index == 4) {
                    this.f2302O000000o = obtainStyledAttributes.getDimension(index, this.f2302O000000o);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(float f, float f2) {
            if (!Float.isNaN(this.f2302O000000o) && f < this.f2302O000000o) {
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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.oOO0OOo0.O000000o(android.content.Context, org.xmlpull.v1.XmlPullParser):void
     arg types: [android.content.Context, android.content.res.XmlResourceParser]
     candidates:
      _m_j.oOO0OOo0.O000000o(android.content.Context, android.util.AttributeSet):_m_j.oOO0OOo0$O000000o
      _m_j.oOO0OOo0.O000000o(_m_j.oOO0OOo0$O000000o, android.content.res.TypedArray):void
      _m_j.oOO0OOo0.O000000o(android.view.View, java.lang.String):int[]
      _m_j.oOO0OOo0.O000000o(int, int):void
      _m_j.oOO0OOo0.O000000o(int, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams):void
      _m_j.oOO0OOo0.O000000o(android.content.Context, int):void
      _m_j.oOO0OOo0.O000000o(android.content.Context, org.xmlpull.v1.XmlPullParser):void */
    private void O000000o(Context context, int i) {
        char c;
        int i2;
        XmlResourceParser xml = context.getResources().getXml(i);
        O000000o o000000o = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    int i3 = 0;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (!(c == 0 || c == 1)) {
                        if (c == 2) {
                            o000000o = new O000000o(context, xml);
                            this.O00000oo.put(o000000o.f2301O000000o, o000000o);
                        } else if (c == 3) {
                            O00000Oo o00000Oo = new O00000Oo(context, xml);
                            if (o000000o != null) {
                                o000000o.O00000Oo.add(o00000Oo);
                            }
                        } else if (c != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag ".concat(String.valueOf(name)));
                        } else {
                            oOO0OOo0 ooo0ooo0 = new oOO0OOo0();
                            int attributeCount = xml.getAttributeCount();
                            while (true) {
                                if (i3 < attributeCount) {
                                    if ("id".equals(xml.getAttributeName(i3))) {
                                        String attributeValue = xml.getAttributeValue(i3);
                                        if (attributeValue.contains("/")) {
                                            i2 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                                        } else {
                                            i2 = -1;
                                        }
                                        if (i2 == -1) {
                                            if (attributeValue == null || attributeValue.length() <= 1) {
                                                Log.e("ConstraintLayoutStates", "error in parsing id");
                                            } else {
                                                i2 = Integer.parseInt(attributeValue.substring(1));
                                            }
                                        }
                                        ooo0ooo0.O000000o(context, (XmlPullParser) xml);
                                        this.O0000O0o.put(i2, ooo0ooo0);
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
