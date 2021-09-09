package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$id;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class oO00O0Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public final MotionLayout f2270O000000o;
    public ooooO0O0 O00000Oo = null;
    public ArrayList<O000000o> O00000o = new ArrayList<>();
    public O000000o O00000o0 = null;
    public SparseArray<oOO0OOo0> O00000oO = new SparseArray<>();
    public int O00000oo = 400;
    public int O0000O0o = 0;
    float O0000OOo;
    private boolean O0000Oo = false;
    float O0000Oo0;
    private O000000o O0000OoO = null;
    private ArrayList<O000000o> O0000Ooo = new ArrayList<>();
    private boolean O0000o = false;
    private SparseIntArray O0000o0 = new SparseIntArray();
    private HashMap<String, Integer> O0000o00 = new HashMap<>();
    private boolean O0000o0O = false;
    private MotionEvent O0000o0o;
    private boolean O0000oO;
    private MotionLayout.O00000o O0000oO0;

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x0018;
     */
    public final void O000000o(int i, int i2) {
        int i3;
        int i4;
        ooooO0O0 ooooo0o0 = this.O00000Oo;
        if (ooooo0o0 != null) {
            i4 = ooooo0o0.O000000o(i, -1, -1);
            if (i4 == -1) {
                i4 = i;
            }
            i3 = this.O00000Oo.O000000o(i2, -1, -1);
        } else {
            i4 = i;
        }
        i3 = i2;
        Iterator<O000000o> it = this.O00000o.iterator();
        while (it.hasNext()) {
            O000000o next = it.next();
            if ((next.O00000o0 == i3 && next.O00000o == i4) || (next.O00000o0 == i2 && next.O00000o == i)) {
                this.O00000o0 = next;
                O000000o o000000o = this.O00000o0;
                if (o000000o != null && o000000o.O0000Ooo != null) {
                    this.O00000o0.O0000Ooo.O000000o(this.O0000oO);
                    return;
                }
                return;
            }
        }
        O000000o o000000o2 = this.O0000OoO;
        Iterator<O000000o> it2 = this.O0000Ooo.iterator();
        while (it2.hasNext()) {
            O000000o next2 = it2.next();
            if (next2.O00000o0 == i2) {
                o000000o2 = next2;
            }
        }
        O000000o o000000o3 = new O000000o(this, o000000o2);
        o000000o3.O00000o = i4;
        o000000o3.O00000o0 = i3;
        if (i4 != -1) {
            this.O00000o.add(o000000o3);
        }
        this.O00000o0 = o000000o3;
    }

    public final void O000000o(O000000o o000000o) {
        this.O00000o0 = o000000o;
        O000000o o000000o2 = this.O00000o0;
        if (o000000o2 != null && o000000o2.O0000Ooo != null) {
            this.O00000o0.O0000Ooo.O000000o(this.O0000oO);
        }
    }

    public final void O000000o(MotionLayout motionLayout, int i) {
        Iterator<O000000o> it = this.O00000o.iterator();
        while (it.hasNext()) {
            O000000o next = it.next();
            if (next.O0000o00.size() > 0) {
                Iterator<O000000o.C0008O000000o> it2 = next.O0000o00.iterator();
                while (it2.hasNext()) {
                    it2.next().O000000o(motionLayout);
                }
            }
        }
        Iterator<O000000o> it3 = this.O0000Ooo.iterator();
        while (it3.hasNext()) {
            O000000o next2 = it3.next();
            if (next2.O0000o00.size() > 0) {
                Iterator<O000000o.C0008O000000o> it4 = next2.O0000o00.iterator();
                while (it4.hasNext()) {
                    it4.next().O000000o(motionLayout);
                }
            }
        }
        Iterator<O000000o> it5 = this.O00000o.iterator();
        while (it5.hasNext()) {
            O000000o next3 = it5.next();
            if (next3.O0000o00.size() > 0) {
                Iterator<O000000o.C0008O000000o> it6 = next3.O0000o00.iterator();
                while (it6.hasNext()) {
                    it6.next().O000000o(motionLayout, i, next3);
                }
            }
        }
        Iterator<O000000o> it7 = this.O0000Ooo.iterator();
        while (it7.hasNext()) {
            O000000o next4 = it7.next();
            if (next4.O0000o00.size() > 0) {
                Iterator<O000000o.C0008O000000o> it8 = next4.O0000o00.iterator();
                while (it8.hasNext()) {
                    it8.next().O000000o(motionLayout, i, next4);
                }
            }
        }
    }

    public final void O000000o(boolean z) {
        this.O0000oO = z;
        O000000o o000000o = this.O00000o0;
        if (o000000o != null && o000000o.O0000Ooo != null) {
            this.O00000o0.O0000Ooo.O000000o(this.O0000oO);
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f2272O000000o = -1;
        public boolean O00000Oo = false;
        public int O00000o = -1;
        public int O00000o0 = -1;
        public int O00000oO = 0;
        public String O00000oo = null;
        public int O0000O0o = -1;
        public int O0000OOo = 400;
        public final oO00O0Oo O0000Oo;
        public float O0000Oo0 = 0.0f;
        public ArrayList<oO0Oo0oo> O0000OoO = new ArrayList<>();
        public oOo00OO0 O0000Ooo = null;
        public int O0000o = 0;
        public int O0000o0 = 0;
        public ArrayList<C0008O000000o> O0000o00 = new ArrayList<>();
        public boolean O0000o0O = false;
        public int O0000o0o = -1;
        public int O0000oO0 = 0;

        public final boolean O000000o() {
            return !this.O0000o0O;
        }

        /* renamed from: _m_j.oO00O0Oo$O000000o$O000000o  reason: collision with other inner class name */
        static class C0008O000000o implements View.OnClickListener {

            /* renamed from: O000000o  reason: collision with root package name */
            int f2273O000000o = -1;
            int O00000Oo = 17;
            private final O000000o O00000o0;

            public C0008O000000o(Context context, O000000o o000000o, XmlPullParser xmlPullParser) {
                this.O00000o0 = o000000o;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{R.attr.clickAction, R.attr.targetId});
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == 1) {
                        this.f2273O000000o = obtainStyledAttributes.getResourceId(index, this.f2273O000000o);
                    } else if (index == 0) {
                        this.O00000Oo = obtainStyledAttributes.getInt(index, this.O00000Oo);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX INFO: additional move instructions added (1) to help type inference */
            public final void O000000o(MotionLayout motionLayout, int i, O000000o o000000o) {
                int i2 = this.f2273O000000o;
                View view = motionLayout;
                if (i2 != -1) {
                    view = motionLayout.findViewById(i2);
                }
                if (view == null) {
                    Log.e("MotionScene", "OnClick could not find id " + this.f2273O000000o);
                    return;
                }
                int i3 = o000000o.O00000o;
                int i4 = o000000o.O00000o0;
                if (i3 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                boolean z = true;
                boolean z2 = ((this.O00000Oo & 1) != 0 && i == i3) | ((this.O00000Oo & 1) != 0 && i == i3) | ((this.O00000Oo & 256) != 0 && i == i3) | ((this.O00000Oo & 16) != 0 && i == i4);
                if ((this.O00000Oo & 4096) == 0 || i != i4) {
                    z = false;
                }
                if (z2 || z) {
                    view.setOnClickListener(this);
                }
            }

            public final void O000000o(MotionLayout motionLayout) {
                int i = this.f2273O000000o;
                if (i != -1) {
                    View findViewById = motionLayout.findViewById(i);
                    if (findViewById == null) {
                        Log.e("MotionScene", " (*)  could not find id " + this.f2273O000000o);
                        return;
                    }
                    findViewById.setOnClickListener(null);
                }
            }

            public final void onClick(View view) {
                MotionLayout motionLayout = this.O00000o0.O0000Oo.f2270O000000o;
                if (motionLayout.O0000Oo) {
                    if (this.O00000o0.O00000o == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.O000000o(this.O00000o0.O00000o0);
                            return;
                        }
                        O000000o o000000o = new O000000o(this.O00000o0.O0000Oo, this.O00000o0);
                        o000000o.O00000o = currentState;
                        o000000o.O00000o0 = this.O00000o0.O00000o0;
                        motionLayout.setTransition(o000000o);
                        motionLayout.O00000o();
                        return;
                    }
                    O000000o o000000o2 = this.O00000o0.O0000Oo.O00000o0;
                    int i = this.O00000Oo;
                    boolean z = false;
                    boolean z2 = ((i & 1) == 0 && (i & 256) == 0) ? false : true;
                    int i2 = this.O00000Oo;
                    boolean z3 = ((i2 & 16) == 0 && (i2 & 4096) == 0) ? false : true;
                    if (z2 && z3) {
                        O000000o o000000o3 = this.O00000o0.O0000Oo.O00000o0;
                        O000000o o000000o4 = this.O00000o0;
                        if (o000000o3 != o000000o4) {
                            motionLayout.setTransition(o000000o4);
                        }
                        if (motionLayout.getCurrentState() == motionLayout.getEndState() || motionLayout.getProgress() > 0.5f) {
                            z2 = false;
                        } else {
                            z3 = false;
                        }
                    }
                    O000000o o000000o5 = this.O00000o0;
                    if (o000000o5 != o000000o2) {
                        int i3 = o000000o5.O00000o0;
                        int i4 = this.O00000o0.O00000o;
                        if (i4 != -1) {
                        }
                    }
                    z = true;
                    if (!z) {
                        return;
                    }
                    if (z2 && (this.O00000Oo & 1) != 0) {
                        motionLayout.setTransition(this.O00000o0);
                        motionLayout.O00000o();
                    } else if (z3 && (this.O00000Oo & 16) != 0) {
                        motionLayout.setTransition(this.O00000o0);
                        motionLayout.O00000o0();
                    } else if (z2 && (this.O00000Oo & 256) != 0) {
                        motionLayout.setTransition(this.O00000o0);
                        motionLayout.setProgress(1.0f);
                    } else if (z3 && (this.O00000Oo & 4096) != 0) {
                        motionLayout.setTransition(this.O00000o0);
                        motionLayout.setProgress(0.0f);
                    }
                }
            }
        }

        O000000o(oO00O0Oo oo00o0oo, O000000o o000000o) {
            this.O0000Oo = oo00o0oo;
            if (o000000o != null) {
                this.O0000o0o = o000000o.O0000o0o;
                this.O00000oO = o000000o.O00000oO;
                this.O00000oo = o000000o.O00000oo;
                this.O0000O0o = o000000o.O0000O0o;
                this.O0000OOo = o000000o.O0000OOo;
                this.O0000OoO = o000000o.O0000OoO;
                this.O0000Oo0 = o000000o.O0000Oo0;
                this.O0000o = o000000o.O0000o;
            }
        }

        O000000o(oO00O0Oo oo00o0oo, Context context, XmlPullParser xmlPullParser) {
            this.O0000OOo = oo00o0oo.O00000oo;
            this.O0000o = oo00o0oo.O0000O0o;
            this.O0000Oo = oo00o0oo;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{16842960, 16843073, 16843160, R.attr.autoTransition, R.attr.constraintSetEnd, R.attr.constraintSetStart, R.attr.duration, R.attr.interpolator, R.attr.layoutDuringTransition, R.attr.matchOrder, R.attr.motionInterpolator, R.attr.pathMotionArc, R.attr.staggered, R.attr.startDelay, R.attr.transitionDisable, R.attr.transitionFlags});
            O000000o(oo00o0oo, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        private void O000000o(oO00O0Oo oo00o0oo, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == 4) {
                    this.O00000o0 = typedArray.getResourceId(index, this.O00000o0);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.O00000o0))) {
                        oOO0OOo0 ooo0ooo0 = new oOO0OOo0();
                        ooo0ooo0.O00000Oo(context, this.O00000o0);
                        oo00o0oo.O00000oO.append(this.O00000o0, ooo0ooo0);
                    }
                } else if (index == 5) {
                    this.O00000o = typedArray.getResourceId(index, this.O00000o);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.O00000o))) {
                        oOO0OOo0 ooo0ooo02 = new oOO0OOo0();
                        ooo0ooo02.O00000Oo(context, this.O00000o);
                        oo00o0oo.O00000oO.append(this.O00000o, ooo0ooo02);
                    }
                } else if (index == 10) {
                    TypedValue peekValue = typedArray.peekValue(index);
                    if (peekValue.type == 1) {
                        this.O0000O0o = typedArray.getResourceId(index, -1);
                        if (this.O0000O0o != -1) {
                            this.O00000oO = -2;
                        }
                    } else if (peekValue.type == 3) {
                        this.O00000oo = typedArray.getString(index);
                        if (this.O00000oo.indexOf("/") > 0) {
                            this.O0000O0o = typedArray.getResourceId(index, -1);
                            this.O00000oO = -2;
                        } else {
                            this.O00000oO = -1;
                        }
                    } else {
                        this.O00000oO = typedArray.getInteger(index, this.O00000oO);
                    }
                } else if (index == 6) {
                    this.O0000OOo = typedArray.getInt(index, this.O0000OOo);
                } else if (index == 12) {
                    this.O0000Oo0 = typedArray.getFloat(index, this.O0000Oo0);
                } else if (index == 3) {
                    this.O0000o0 = typedArray.getInteger(index, this.O0000o0);
                } else if (index == 0) {
                    this.f2272O000000o = typedArray.getResourceId(index, this.f2272O000000o);
                } else if (index == 14) {
                    this.O0000o0O = typedArray.getBoolean(index, this.O0000o0O);
                } else if (index == 11) {
                    this.O0000o0o = typedArray.getInteger(index, -1);
                } else if (index == 8) {
                    this.O0000o = typedArray.getInteger(index, 0);
                } else if (index == 15) {
                    this.O0000oO0 = typedArray.getInteger(index, 0);
                }
            }
            if (this.O00000o == -1) {
                this.O00000Oo = true;
            }
        }
    }

    public oO00O0Oo(Context context, MotionLayout motionLayout, int i) {
        this.f2270O000000o = motionLayout;
        O000000o(context, i);
        this.O00000oO.put(R$id.motion_base, new oOO0OOo0());
        this.O0000o00.put("motion_base", Integer.valueOf(R$id.motion_base));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void O000000o(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        O000000o o000000o = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c = 1;
                if (eventType != 1) {
                    if (eventType == 0) {
                        xml.getName();
                    } else if (eventType == 2) {
                        String name = xml.getName();
                        if (this.O0000o0O) {
                            System.out.println("parsing = ".concat(String.valueOf(name)));
                        }
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1239391468:
                                if (name.equals("KeyFrameSet")) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 269306229:
                                if (name.equals("Transition")) {
                                    break;
                                }
                                c = 65535;
                                break;
                            case 312750793:
                                if (name.equals("OnClick")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 327855227:
                                if (name.equals("OnSwipe")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 793277014:
                                if (name.equals("MotionScene")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                                O000000o(context, xml);
                                continue;
                            case 1:
                                ArrayList<O000000o> arrayList = this.O00000o;
                                O000000o o000000o2 = new O000000o(this, context, xml);
                                arrayList.add(o000000o2);
                                if (this.O00000o0 == null && !o000000o2.O00000Oo) {
                                    this.O00000o0 = o000000o2;
                                    if (!(this.O00000o0 == null || this.O00000o0.O0000Ooo == null)) {
                                        this.O00000o0.O0000Ooo.O000000o(this.O0000oO);
                                    }
                                }
                                if (o000000o2.O00000Oo) {
                                    if (o000000o2.O00000o0 == -1) {
                                        this.O0000OoO = o000000o2;
                                    } else {
                                        this.O0000Ooo.add(o000000o2);
                                    }
                                    this.O00000o.remove(o000000o2);
                                }
                                o000000o = o000000o2;
                                continue;
                            case 2:
                                if (o000000o == null) {
                                    String resourceEntryName = context.getResources().getResourceEntryName(i);
                                    int lineNumber = xml.getLineNumber();
                                    Log.v("MotionScene", " OnSwipe (" + resourceEntryName + ".xml:" + lineNumber + ")");
                                }
                                o000000o.O0000Ooo = new oOo00OO0(context, this.f2270O000000o, xml);
                                continue;
                            case 3:
                                o000000o.O0000o00.add(new O000000o.C0008O000000o(context, o000000o, xml));
                                continue;
                            case 4:
                                this.O00000Oo = new ooooO0O0(context, xml);
                                continue;
                            case 5:
                                O00000Oo(context, xml);
                                continue;
                            case 6:
                                o000000o.O0000OoO.add(new oO0Oo0oo(context, xml));
                                continue;
                            default:
                                Log.v("MotionScene", "WARNING UNKNOWN ATTRIBUTE ".concat(String.valueOf(name)));
                                continue;
                        }
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void O000000o(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{R.attr.defaultDuration, R.attr.layoutDuringTransition});
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.O00000oo = obtainStyledAttributes.getInt(index, this.O00000oo);
            } else if (index == 1) {
                this.O0000O0o = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private int O000000o(Context context, String str) {
        int i;
        if (str.contains("/")) {
            i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.O0000o0O) {
                System.out.println("id getMap res = ".concat(String.valueOf(i)));
            }
        } else {
            i = -1;
        }
        if (i != -1) {
            return i;
        }
        if (str != null && str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    private void O00000Oo(Context context, XmlPullParser xmlPullParser) {
        char c;
        oOO0OOo0 ooo0ooo0 = new oOO0OOo0();
        ooo0ooo0.O00000Oo = false;
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (this.O0000o0O) {
                System.out.println("id string = ".concat(String.valueOf(attributeValue)));
            }
            int hashCode = attributeName.hashCode();
            if (hashCode != -1496482599) {
                if (hashCode == 3355 && attributeName.equals("id")) {
                    c = 0;
                    if (c == 0) {
                        i = O000000o(context, attributeValue);
                        HashMap<String, Integer> hashMap = this.O0000o00;
                        if (attributeValue == null) {
                            attributeValue = "";
                        } else {
                            int indexOf = attributeValue.indexOf(47);
                            if (indexOf >= 0) {
                                attributeValue = attributeValue.substring(indexOf + 1);
                            }
                        }
                        hashMap.put(attributeValue, Integer.valueOf(i));
                    } else if (c == 1) {
                        i2 = O000000o(context, attributeValue);
                    }
                }
            } else if (attributeName.equals("deriveConstraintsFrom")) {
                c = 1;
                if (c == 0) {
                }
            }
            c = 65535;
            if (c == 0) {
            }
        }
        if (i != -1) {
            if (this.f2270O000000o.O0000oO0 != 0) {
                ooo0ooo0.f2303O000000o = true;
            }
            ooo0ooo0.O000000o(context, xmlPullParser);
            if (i2 != -1) {
                this.O0000o0.put(i, i2);
            }
            this.O00000oO.put(i, ooo0ooo0);
        }
    }

    public final oOO0OOo0 O000000o(int i) {
        int O000000o2;
        if (this.O0000o0O) {
            System.out.println("id ".concat(String.valueOf(i)));
            PrintStream printStream = System.out;
            printStream.println("size " + this.O00000oO.size());
        }
        ooooO0O0 ooooo0o0 = this.O00000Oo;
        if (!(ooooo0o0 == null || (O000000o2 = ooooo0o0.O000000o(i, -1, -1)) == -1)) {
            i = O000000o2;
        }
        if (this.O00000oO.get(i) != null) {
            return this.O00000oO.get(i);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + oO00000o.O000000o(this.f2270O000000o.getContext(), i) + " In MotionScene");
        SparseArray<oOO0OOo0> sparseArray = this.O00000oO;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public final void O000000o(oO0Oo0O0 oo0oo0o0) {
        O000000o o000000o = this.O00000o0;
        if (o000000o == null) {
            O000000o o000000o2 = this.O0000OoO;
            if (o000000o2 != null) {
                Iterator<oO0Oo0oo> it = o000000o2.O0000OoO.iterator();
                while (it.hasNext()) {
                    it.next().O000000o(oo0oo0o0);
                }
                return;
            }
            return;
        }
        Iterator<oO0Oo0oo> it2 = o000000o.O0000OoO.iterator();
        while (it2.hasNext()) {
            it2.next().O000000o(oo0oo0o0);
        }
    }

    public final boolean O000000o() {
        Iterator<O000000o> it = this.O00000o.iterator();
        while (it.hasNext()) {
            if (it.next().O0000Ooo != null) {
                return true;
            }
        }
        O000000o o000000o = this.O00000o0;
        if (o000000o == null || o000000o.O0000Ooo == null) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public final void O000000o(MotionEvent motionEvent, int i, MotionLayout motionLayout) {
        MotionLayout.O00000o o00000o;
        float f;
        float f2;
        RectF rectF;
        View findViewById;
        MotionEvent motionEvent2;
        MotionEvent motionEvent3 = motionEvent;
        int i2 = i;
        MotionLayout motionLayout2 = motionLayout;
        RectF rectF2 = new RectF();
        if (this.O0000oO0 == null) {
            this.O0000oO0 = MotionLayout.O000000o();
        }
        this.O0000oO0.O000000o(motionEvent3);
        if (i2 != -1) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.O0000OOo = motionEvent.getRawX();
                this.O0000Oo0 = motionEvent.getRawY();
                this.O0000o0o = motionEvent3;
                if (this.O00000o0.O0000Ooo != null) {
                    oOo00OO0 ooo00oo0 = this.O00000o0.O0000Ooo;
                    MotionLayout motionLayout3 = this.f2270O000000o;
                    if (ooo00oo0.O00000o == -1 || (findViewById = motionLayout3.findViewById(ooo00oo0.O00000o)) == null) {
                        rectF = null;
                    } else {
                        rectF2.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
                        rectF = rectF2;
                    }
                    if (rectF == null || rectF.contains(this.O0000o0o.getX(), this.O0000o0o.getY())) {
                        RectF O000000o2 = this.O00000o0.O0000Ooo.O000000o(this.f2270O000000o, rectF2);
                        if (O000000o2 == null || O000000o2.contains(this.O0000o0o.getX(), this.O0000o0o.getY())) {
                            this.O0000o = false;
                        } else {
                            this.O0000o = true;
                        }
                        oOo00OO0 ooo00oo02 = this.O00000o0.O0000Ooo;
                        float f3 = this.O0000OOo;
                        float f4 = this.O0000Oo0;
                        ooo00oo02.O0000OoO = f3;
                        ooo00oo02.O0000Ooo = f4;
                        return;
                    }
                    this.O0000o0o = null;
                    return;
                }
                return;
            } else if (action == 2) {
                float rawY = motionEvent.getRawY() - this.O0000Oo0;
                float rawX = motionEvent.getRawX() - this.O0000OOo;
                if ((((double) rawX) != 0.0d || ((double) rawY) != 0.0d) && (motionEvent2 = this.O0000o0o) != null) {
                    O000000o O000000o3 = O000000o(i2, rawX, rawY, motionEvent2);
                    if (O000000o3 != null) {
                        motionLayout2.setTransition(O000000o3);
                        RectF O000000o4 = this.O00000o0.O0000Ooo.O000000o(this.f2270O000000o, rectF2);
                        this.O0000o = O000000o4 != null && !O000000o4.contains(this.O0000o0o.getX(), this.O0000o0o.getY());
                        oOo00OO0 ooo00oo03 = this.O00000o0.O0000Ooo;
                        float f5 = this.O0000OOo;
                        float f6 = this.O0000Oo0;
                        ooo00oo03.O0000OoO = f5;
                        ooo00oo03.O0000Ooo = f6;
                        ooo00oo03.O0000Oo0 = false;
                    }
                } else {
                    return;
                }
            }
        }
        O000000o o000000o = this.O00000o0;
        if (!(o000000o == null || o000000o.O0000Ooo == null || this.O0000o)) {
            oOo00OO0 ooo00oo04 = this.O00000o0.O0000Ooo;
            MotionLayout.O00000o o00000o2 = this.O0000oO0;
            o00000o2.O000000o(motionEvent3);
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                ooo00oo04.O0000OoO = motionEvent.getRawX();
                ooo00oo04.O0000Ooo = motionEvent.getRawY();
                ooo00oo04.O0000Oo0 = false;
            } else if (action2 == 1) {
                ooo00oo04.O0000Oo0 = false;
                o00000o2.O00000Oo();
                float O00000o02 = o00000o2.O00000o0();
                float O00000o2 = o00000o2.O00000o();
                float progress = ooo00oo04.O0000o00.getProgress();
                if (ooo00oo04.O00000Oo != -1) {
                    ooo00oo04.O0000o00.O000000o(ooo00oo04.O00000Oo, progress, ooo00oo04.O00000oo, ooo00oo04.O00000oO, ooo00oo04.O0000Oo);
                } else {
                    float min = (float) Math.min(ooo00oo04.O0000o00.getWidth(), ooo00oo04.O0000o00.getHeight());
                    ooo00oo04.O0000Oo[1] = ooo00oo04.O0000OOo * min;
                    ooo00oo04.O0000Oo[0] = min * ooo00oo04.O0000O0o;
                }
                if (ooo00oo04.O0000O0o != 0.0f) {
                    f = O00000o02 / ooo00oo04.O0000Oo[0];
                } else {
                    f = O00000o2 / ooo00oo04.O0000Oo[1];
                }
                float f7 = !Float.isNaN(f) ? (f / 3.0f) + progress : progress;
                if (f7 != 0.0f && f7 != 1.0f && ooo00oo04.f2329O000000o != 3) {
                    ooo00oo04.O0000o00.O000000o(ooo00oo04.f2329O000000o, ((double) f7) < 0.5d ? 0.0f : 1.0f, f);
                    if (0.0f >= progress || 1.0f <= progress) {
                        ooo00oo04.O0000o00.setState(MotionLayout.TransitionState.FINISHED);
                    }
                } else if (0.0f >= f7 || 1.0f <= f7) {
                    ooo00oo04.O0000o00.setState(MotionLayout.TransitionState.FINISHED);
                }
            } else if (action2 == 2) {
                float rawY2 = motionEvent.getRawY() - ooo00oo04.O0000Ooo;
                float rawX2 = motionEvent.getRawX() - ooo00oo04.O0000OoO;
                if (Math.abs((ooo00oo04.O0000O0o * rawX2) + (ooo00oo04.O0000OOo * rawY2)) > ooo00oo04.O0000oO || ooo00oo04.O0000Oo0) {
                    float progress2 = ooo00oo04.O0000o00.getProgress();
                    if (!ooo00oo04.O0000Oo0) {
                        ooo00oo04.O0000Oo0 = true;
                        ooo00oo04.O0000o00.setProgress(progress2);
                    }
                    if (ooo00oo04.O00000Oo != -1) {
                        ooo00oo04.O0000o00.O000000o(ooo00oo04.O00000Oo, progress2, ooo00oo04.O00000oo, ooo00oo04.O00000oO, ooo00oo04.O0000Oo);
                    } else {
                        float min2 = (float) Math.min(ooo00oo04.O0000o00.getWidth(), ooo00oo04.O0000o00.getHeight());
                        ooo00oo04.O0000Oo[1] = ooo00oo04.O0000OOo * min2;
                        ooo00oo04.O0000Oo[0] = min2 * ooo00oo04.O0000O0o;
                    }
                    if (((double) Math.abs(((ooo00oo04.O0000O0o * ooo00oo04.O0000Oo[0]) + (ooo00oo04.O0000OOo * ooo00oo04.O0000Oo[1])) * ooo00oo04.O0000o)) < 0.01d) {
                        ooo00oo04.O0000Oo[0] = 0.01f;
                        ooo00oo04.O0000Oo[1] = 0.01f;
                    }
                    if (ooo00oo04.O0000O0o != 0.0f) {
                        f2 = rawX2 / ooo00oo04.O0000Oo[0];
                    } else {
                        f2 = rawY2 / ooo00oo04.O0000Oo[1];
                    }
                    float max = Math.max(Math.min(progress2 + f2, 1.0f), 0.0f);
                    if (max != ooo00oo04.O0000o00.getProgress()) {
                        ooo00oo04.O0000o00.setProgress(max);
                        o00000o2.O00000Oo();
                        ooo00oo04.O0000o00.O00000o = ooo00oo04.O0000O0o != 0.0f ? o00000o2.O00000o0() / ooo00oo04.O0000Oo[0] : o00000o2.O00000o() / ooo00oo04.O0000Oo[1];
                    } else {
                        ooo00oo04.O0000o00.O00000o = 0.0f;
                    }
                    ooo00oo04.O0000OoO = motionEvent.getRawX();
                    ooo00oo04.O0000Ooo = motionEvent.getRawY();
                }
            }
        }
        this.O0000OOo = motionEvent.getRawX();
        this.O0000Oo0 = motionEvent.getRawY();
        if (motionEvent.getAction() == 1 && (o00000o = this.O0000oO0) != null) {
            o00000o.O000000o();
            this.O0000oO0 = null;
            if (motionLayout2.O00000oo != -1) {
                O00000Oo(motionLayout2, motionLayout2.O00000oo);
            }
        }
    }

    public final int O00000Oo() {
        O000000o o000000o = this.O00000o0;
        if (o000000o == null) {
            return -1;
        }
        return o000000o.O00000o;
    }

    public final int O00000o0() {
        O000000o o000000o = this.O00000o0;
        if (o000000o == null) {
            return -1;
        }
        return o000000o.O00000o0;
    }

    public final Interpolator O00000o() {
        switch (this.O00000o0.O00000oO) {
            case -2:
                return AnimationUtils.loadInterpolator(this.f2270O000000o.getContext(), this.O00000o0.O0000O0o);
            case -1:
                final o0OO0o00 O000000o2 = o0OO0o00.O000000o(this.O00000o0.O00000oo);
                return new Interpolator() {
                    /* class _m_j.oO00O0Oo.AnonymousClass1 */

                    public final float getInterpolation(float f) {
                        return (float) O000000o2.O000000o((double) f);
                    }
                };
            case 0:
                return new AccelerateDecelerateInterpolator();
            case 1:
                return new AccelerateInterpolator();
            case 2:
                return new DecelerateInterpolator();
            case 3:
                return null;
            case 4:
                return new AnticipateInterpolator();
            case 5:
                return new BounceInterpolator();
            default:
                return null;
        }
    }

    public final int O00000oO() {
        O000000o o000000o = this.O00000o0;
        if (o000000o != null) {
            return o000000o.O0000OOo;
        }
        return this.O00000oo;
    }

    public final float O00000oo() {
        O000000o o000000o = this.O00000o0;
        if (o000000o != null) {
            return o000000o.O0000Oo0;
        }
        return 0.0f;
    }

    public final float O0000O0o() {
        O000000o o000000o = this.O00000o0;
        if (o000000o == null || o000000o.O0000Ooo == null) {
            return 0.0f;
        }
        return this.O00000o0.O0000Ooo.O0000o0O;
    }

    public final float O0000OOo() {
        O000000o o000000o = this.O00000o0;
        if (o000000o == null || o000000o.O0000Ooo == null) {
            return 0.0f;
        }
        return this.O00000o0.O0000Ooo.O0000o0;
    }

    public final void O0000Oo0() {
        O000000o o000000o = this.O00000o0;
        if (o000000o != null && o000000o.O0000Ooo != null) {
            this.O00000o0.O0000Ooo.O000000o();
        }
    }

    public final void O000000o(MotionLayout motionLayout) {
        int i = 0;
        while (i < this.O00000oO.size()) {
            int keyAt = this.O00000oO.keyAt(i);
            if (O00000Oo(keyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            } else {
                O00000o0(keyAt);
                i++;
            }
        }
        for (int i2 = 0; i2 < this.O00000oO.size(); i2++) {
            this.O00000oO.valueAt(i2).O000000o(motionLayout);
        }
    }

    private boolean O00000Oo(int i) {
        int i2 = this.O0000o0.get(i);
        int size = this.O0000o0.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.O0000o0.get(i2);
            size = i3;
        }
        return false;
    }

    private void O00000o0(int i) {
        int i2 = this.O0000o0.get(i);
        if (i2 > 0) {
            O00000o0(this.O0000o0.get(i));
            oOO0OOo0 ooo0ooo0 = this.O00000oO.get(i);
            oOO0OOo0 ooo0ooo02 = this.O00000oO.get(i2);
            if (ooo0ooo02 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + oO00000o.O000000o(this.f2270O000000o.getContext(), i2));
                return;
            }
            ooo0ooo0.O000000o(ooo0ooo02);
            this.O0000o0.put(i, -1);
        }
    }

    private O000000o O000000o(int i, float f, float f2, MotionEvent motionEvent) {
        int i2;
        RectF O000000o2;
        if (i == -1) {
            return this.O00000o0;
        }
        ooooO0O0 ooooo0o0 = this.O00000Oo;
        if (ooooo0o0 == null || (i2 = ooooo0o0.O000000o(i, -1, -1)) == -1) {
            i2 = i;
        }
        ArrayList<O000000o> arrayList = new ArrayList<>();
        Iterator<O000000o> it = this.O00000o.iterator();
        while (it.hasNext()) {
            O000000o next = it.next();
            if (next.O00000o == i2 || next.O00000o0 == i2) {
                arrayList.add(next);
            }
        }
        float f3 = 0.0f;
        O000000o o000000o = null;
        RectF rectF = new RectF();
        for (O000000o o000000o2 : arrayList) {
            if (!o000000o2.O0000o0O && o000000o2.O0000Ooo != null) {
                o000000o2.O0000Ooo.O000000o(this.O0000oO);
                RectF O000000o3 = o000000o2.O0000Ooo.O000000o(this.f2270O000000o, rectF);
                if ((O000000o3 == null || motionEvent == null || O000000o3.contains(motionEvent.getX(), motionEvent.getY())) && ((O000000o2 = o000000o2.O0000Ooo.O000000o(this.f2270O000000o, rectF)) == null || motionEvent == null || O000000o2.contains(motionEvent.getX(), motionEvent.getY()))) {
                    oOo00OO0 ooo00oo0 = o000000o2.O0000Ooo;
                    float f4 = ((ooo00oo0.O0000O0o * f) + (ooo00oo0.O0000OOo * f2)) * (o000000o2.O00000o0 == i ? -1.0f : 1.1f);
                    if (f4 > f3) {
                        o000000o = o000000o2;
                        f3 = f4;
                    }
                }
            }
        }
        return o000000o;
    }

    public final boolean O00000Oo(MotionLayout motionLayout, int i) {
        if ((this.O0000oO0 != null) || this.O0000Oo) {
            return false;
        }
        Iterator<O000000o> it = this.O00000o.iterator();
        while (it.hasNext()) {
            O000000o next = it.next();
            if (next.O0000o0 != 0) {
                if (i == next.O00000o && (next.O0000o0 == 4 || next.O0000o0 == 2)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.O0000o0 == 4) {
                        motionLayout.O00000o();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.O000000o(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    }
                    return true;
                } else if (i == next.O00000o0 && (next.O0000o0 == 3 || next.O0000o0 == 1)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.O0000o0 == 3) {
                        motionLayout.O00000o0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.O000000o(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
