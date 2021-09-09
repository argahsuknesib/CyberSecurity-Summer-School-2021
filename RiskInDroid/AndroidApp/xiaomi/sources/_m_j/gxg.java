package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class gxg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Byte[] f18455O000000o = new Byte[0];
    public static final Handler O00000Oo = new Handler(Looper.getMainLooper());
    private static volatile gxg O0000OOo;
    public List<O000000o> O00000o;
    public Device O00000o0;
    public List<gxh> O00000oO;
    public List<gxi> O00000oo;
    public gxj O0000O0o;

    public interface O000000o {
        void onSleepDataChanged();

        void onStepDataChanged();

        void onUserDataChanged();
    }

    public static gxg O000000o() {
        if (O0000OOo == null) {
            synchronized (gxg.class) {
                if (O0000OOo == null) {
                    gxg gxg = new gxg();
                    O0000OOo = gxg;
                    gxg.O00000o = new ArrayList();
                    gxg.O00000oO = new ArrayList();
                    gxg.O00000oo = new ArrayList();
                }
            }
        }
        return O0000OOo;
    }

    public static String O000000o(Context context, int i, long j) {
        if (j < 0) {
            return "";
        }
        Date date = new Date(j);
        Calendar instance = Calendar.getInstance();
        if (i == 3) {
            instance.setTime(goz.O00000o0(date));
            return instance.get(11) + ":00";
        } else if (i == 2) {
            Date O00000Oo2 = goz.O00000Oo(date);
            instance.setTime(O00000Oo2);
            if (goz.O000000o(O00000Oo2)) {
                return context.getString(R.string.timer_today);
            }
            if (goz.O00000o0(O00000Oo2, Calendar.getInstance().getTime())) {
                return context.getString(R.string.timer_yesterday);
            }
            if (instance.get(7) == 2) {
                return context.getString(R.string.timer_monday);
            }
            return (instance.get(2) + 1) + "/" + instance.get(5);
        } else {
            int i2 = -1;
            if (i == 1) {
                if (goz.O00000Oo(instance.getTime(), date)) {
                    return context.getString(R.string.timer_this_week);
                }
                instance.add(3, -1);
                if (goz.O00000Oo(instance.getTime(), date)) {
                    return context.getString(R.string.timer_last_week);
                }
                instance.setTime(date);
                int i3 = 0;
                if (instance.get(7) == 2) {
                    i3 = 5;
                } else if (instance.get(7) == 3) {
                    i2 = -2;
                    i3 = 4;
                } else if (instance.get(7) == 4) {
                    i2 = -3;
                    i3 = 3;
                } else if (instance.get(7) == 5) {
                    i2 = -4;
                    i3 = 2;
                } else if (instance.get(7) == 6) {
                    i2 = -5;
                    i3 = 1;
                } else if (instance.get(7) == 7) {
                    i2 = -6;
                } else {
                    if (instance.get(7) == 1) {
                        i3 = 6;
                    }
                    i2 = 0;
                }
                instance.add(5, i2);
                String str = (instance.get(2) + 1) + "/" + instance.get(5);
                instance.add(5, i3 - i2);
                return str + "-" + (instance.get(2) + 1) + "/" + instance.get(5);
            } else if (i != 0) {
                return "";
            } else {
                if (goz.O000000o(instance.getTime(), date)) {
                    return context.getString(R.string.timer_this_month);
                }
                instance.add(2, -1);
                if (goz.O000000o(instance.getTime(), date)) {
                    return context.getString(R.string.timer_last_month);
                }
                instance.setTime(date);
                int i4 = instance.get(2) + 1;
                if (i4 == 0) {
                    return instance.get(1) + context.getResources().getString(R.string.mj_picker_year) + i4 + context.getResources().getString(R.string.mj_picker_month);
                }
                return i4 + context.getResources().getString(R.string.mj_picker_month);
            }
        }
    }

    public final void O00000Oo() {
        O00000Oo.post(new Runnable() {
            /* class _m_j.gxg.AnonymousClass2 */

            public final void run() {
                for (O000000o next : gxg.this.O00000o) {
                    next.onSleepDataChanged();
                    next.onStepDataChanged();
                }
            }
        });
    }

    public final void O00000o0() {
        O00000Oo.post(new Runnable() {
            /* class _m_j.gxg.AnonymousClass3 */

            public final void run() {
                for (O000000o onUserDataChanged : gxg.this.O00000o) {
                    onUserDataChanged.onUserDataChanged();
                }
            }
        });
    }

    public final void O000000o(final Date date, final Date date2) {
        String O00000Oo2 = gxm.O00000o0().O00000Oo();
        String O000000o2 = gxm.O00000o0().O000000o();
        if (O00000Oo2 != null && O000000o2 != null && !O00000Oo2.isEmpty() && !O000000o2.isEmpty()) {
            ftu.O000000o().O000000o(date, date2, O00000Oo2, O000000o2, new ftt<JSONObject>() {
                /* class _m_j.gxg.AnonymousClass4 */

                public final void O000000o(int i) {
                }

                public final void O000000o(int i, Object obj) {
                }

                public final /* synthetic */ void O000000o(Object obj) {
                    final JSONObject jSONObject = (JSONObject) obj;
                    goq.O000000o(new Runnable() {
                        /* class _m_j.gxg.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            JSONArray optJSONArray;
                            JSONObject jSONObject = jSONObject;
                            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                                int length = optJSONArray.length();
                                ArrayList arrayList = new ArrayList();
                                ArrayList arrayList2 = new ArrayList();
                                for (int i = 0; i < length; i++) {
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                    if (optJSONObject != null) {
                                        gxh O000000o2 = gxh.O000000o(optJSONObject);
                                        gxi O000000o3 = gxi.O000000o(optJSONObject);
                                        if (O000000o2 != null) {
                                            arrayList2.add(0, O000000o2);
                                        }
                                        if (O000000o3 != null) {
                                            arrayList.add(0, O000000o3);
                                        }
                                    }
                                }
                                gxg.O000000o(date, date2, arrayList2);
                                gxg.O00000Oo(date, date2, arrayList);
                                gxg.this.O00000Oo(arrayList);
                                gxg.this.O000000o(arrayList2);
                                gxg.this.O000000o(CommonApplication.getAppContext());
                                arrayList.clear();
                                arrayList2.clear();
                                gxg.this.O00000Oo();
                            }
                        }
                    });
                }
            });
        }
    }

    public static Date O000000o(Calendar calendar, Date date) {
        calendar.setTime(date);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public final gxh O000000o(Date date) {
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(date);
        for (gxh next : this.O00000oO) {
            if (format.equalsIgnoreCase(next.O00000oo)) {
                return next;
            }
        }
        return null;
    }

    public final gxi O00000Oo(Date date) {
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(date);
        for (gxi next : this.O00000oo) {
            if (format.equalsIgnoreCase(next.O0000OOo)) {
                return next;
            }
        }
        return null;
    }

    public final int O00000o() {
        gxj gxj = this.O0000O0o;
        if (gxj != null) {
            return gxj.O00000oO;
        }
        return 0;
    }

    public final void O000000o(List<gxh> list) {
        synchronized (f18455O000000o) {
            for (gxh remove : list) {
                this.O00000oO.remove(remove);
            }
            this.O00000oO.addAll(list);
            Collections.sort(this.O00000oO);
        }
    }

    public final void O00000Oo(List<gxi> list) {
        synchronized (f18455O000000o) {
            for (gxi remove : list) {
                this.O00000oo.remove(remove);
            }
            this.O00000oo.addAll(list);
            Collections.sort(this.O00000oo);
        }
    }

    public final void O000000o(Context context) {
        SharedPreferences sharedPreferences;
        String O0000o0 = CoreApi.O000000o().O0000o0();
        if (O0000o0 != null && !O0000o0.isEmpty() && !O0000o0.equalsIgnoreCase("0") && (sharedPreferences = context.getSharedPreferences("mi.band.data.cache".concat(String.valueOf(O0000o0)), 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            JSONArray jSONArray = new JSONArray();
            synchronized (f18455O000000o) {
                for (gxh O000000o2 : this.O00000oO) {
                    jSONArray.put(O000000o2.O000000o());
                }
                edit.remove("mi.band.sleep.data");
                edit.putString("mi.band.sleep.data", jSONArray.toString());
                JSONArray jSONArray2 = new JSONArray();
                for (gxi O000000o3 : this.O00000oo) {
                    jSONArray2.put(O000000o3.O000000o());
                }
                edit.remove("mi.band.step.data");
                edit.putString("mi.band.step.data", jSONArray2.toString());
            }
            edit.apply();
        }
    }

    public final void O000000o(O000000o o000000o) {
        for (O000000o equals : this.O00000o) {
            if (o000000o.equals(equals)) {
                return;
            }
        }
        this.O00000o.add(o000000o);
    }

    public final void O00000Oo(O000000o o000000o) {
        this.O00000o.remove(o000000o);
    }

    public static void O000000o(Date date, Date date2, List<gxh> list) {
        boolean z;
        Calendar instance = Calendar.getInstance();
        instance.setTime(goz.O00000Oo(date));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        ArrayList arrayList = new ArrayList();
        for (Date time = instance.getTime(); !time.after(date2); time = instance.getTime()) {
            String format = simpleDateFormat.format(time);
            Iterator<gxh> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().O00000oo.equalsIgnoreCase(format)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                arrayList.add(0, new gxh(time));
            }
            instance.add(6, 1);
        }
        list.addAll(arrayList);
    }

    public static void O00000Oo(Date date, Date date2, List<gxi> list) {
        boolean z;
        Calendar instance = Calendar.getInstance();
        instance.setTime(goz.O00000Oo(date));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        ArrayList arrayList = new ArrayList();
        for (Date time = instance.getTime(); !time.after(date2); time = instance.getTime()) {
            String format = simpleDateFormat.format(time);
            Iterator<gxi> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().O0000OOo.equalsIgnoreCase(format)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                arrayList.add(0, new gxi(time));
            }
            instance.add(6, 1);
        }
        list.addAll(arrayList);
    }

    private gxg() {
    }
}
