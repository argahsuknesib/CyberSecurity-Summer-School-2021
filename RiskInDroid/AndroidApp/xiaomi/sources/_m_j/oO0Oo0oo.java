package _m_j;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class oO0Oo0oo {

    /* renamed from: O000000o  reason: collision with root package name */
    static HashMap<String, Constructor<? extends oO0000o0>> f2288O000000o = new HashMap<>();
    private HashMap<Integer, ArrayList<oO0000o0>> O00000Oo = new HashMap<>();

    static {
        try {
            f2288O000000o.put("KeyAttribute", oO000O0O.class.getConstructor(new Class[0]));
            f2288O000000o.put("KeyPosition", oO000OOO.class.getConstructor(new Class[0]));
            f2288O000000o.put("KeyCycle", oO0Ooooo.class.getConstructor(new Class[0]));
            f2288O000000o.put("KeyTimeCycle", oO0OOo0o.class.getConstructor(new Class[0]));
            f2288O000000o.put("KeyTrigger", oO000Oo0.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e) {
            Log.e("KeyFrames", "unable to load", e);
        }
    }

    public oO0Oo0oo(Context context, XmlPullParser xmlPullParser) {
        oO0000o0 oo0000o0;
        Exception e;
        oO0000o0 oo0000o02 = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        if (f2288O000000o.containsKey(name)) {
                            try {
                                oo0000o0 = (oO0000o0) f2288O000000o.get(name).newInstance(new Object[0]);
                                try {
                                    oo0000o0.O000000o(context, Xml.asAttributeSet(xmlPullParser));
                                    if (!this.O00000Oo.containsKey(Integer.valueOf(oo0000o0.O00000o0))) {
                                        this.O00000Oo.put(Integer.valueOf(oo0000o0.O00000o0), new ArrayList());
                                    }
                                    this.O00000Oo.get(Integer.valueOf(oo0000o0.O00000o0)).add(oo0000o0);
                                } catch (Exception e2) {
                                    e = e2;
                                    Log.e("KeyFrames", "unable to create ", e);
                                    oo0000o02 = oo0000o0;
                                    eventType = xmlPullParser.next();
                                }
                            } catch (Exception e3) {
                                Exception exc = e3;
                                oo0000o0 = oo0000o02;
                                e = exc;
                                Log.e("KeyFrames", "unable to create ", e);
                                oo0000o02 = oo0000o0;
                                eventType = xmlPullParser.next();
                            }
                            oo0000o02 = oo0000o0;
                        } else if (!(!name.equalsIgnoreCase("CustomAttribute") || oo0000o02 == null || oo0000o02.O00000oo == null)) {
                            ConstraintAttribute.O000000o(context, xmlPullParser, oo0000o02.O00000oo);
                        }
                    } else if (eventType == 3) {
                        if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                            return;
                        }
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public final void O000000o(oO0Oo0O0 oo0oo0o0) {
        ArrayList arrayList = this.O00000Oo.get(Integer.valueOf(oo0oo0o0.O00000Oo));
        if (arrayList != null) {
            oo0oo0o0.O0000o0o.addAll(arrayList);
        }
        ArrayList arrayList2 = this.O00000Oo.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                oO0000o0 oo0000o0 = (oO0000o0) it.next();
                String str = ((ConstraintLayout.LayoutParams) oo0oo0o0.f2287O000000o.getLayoutParams()).O000OoO0;
                if ((oo0000o0.O00000o == null || str == null) ? false : str.matches(oo0000o0.O00000o)) {
                    oo0oo0o0.O0000o0o.add(oo0000o0);
                }
            }
        }
    }
}
