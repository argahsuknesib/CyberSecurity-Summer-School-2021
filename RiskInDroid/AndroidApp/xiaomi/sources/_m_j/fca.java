package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fca {
    private static volatile fca O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<Long, List<O000000o>> f16062O000000o = new HashMap();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f16070O000000o;
        public String O00000Oo;
        public long O00000o;
        public String O00000o0;
        public long O00000oO;
        public long O00000oo;
        public long O0000O0o;
        public int O0000OOo;
        public O00000Oo O0000Oo;
        public boolean O0000Oo0;
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f16071O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public Map<String, String> O0000O0o;
        public Map<String, Boolean> O0000OOo;
        public Map<String, Long> O0000Oo;
        public Map<String, Integer> O0000Oo0;
        public Map<String, Double> O0000OoO;
        public Map<String, Float> O0000Ooo;
        public boolean O0000o00 = true;
    }

    private fca() {
    }

    public static fca O000000o() {
        if (O00000Oo == null) {
            synchronized (fca.class) {
                if (O00000Oo == null) {
                    O00000Oo = new fca();
                }
            }
        }
        return O00000Oo;
    }

    public static String O000000o(long j, long j2) {
        return "business_content_1" + "_" + j2;
    }

    public static boolean O000000o(O000000o o000000o) {
        if (o000000o == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if ((o000000o.O00000o == -1 || o000000o.O00000o <= currentTimeMillis) && (o000000o.O00000oO == -1 || currentTimeMillis <= o000000o.O00000oO)) {
            Calendar instance = Calendar.getInstance();
            long j = (long) ((instance.get(11) * 60) + instance.get(12));
            if ((o000000o.O00000oo == -1 || o000000o.O00000oo <= j) && (o000000o.O0000O0o == -1 || j <= o000000o.O0000O0o)) {
                return true;
            }
        }
        return false;
    }

    public static boolean O00000Oo(O000000o o000000o) {
        if (o000000o != null && o000000o.f16070O000000o >= 0) {
            if (o000000o.O0000Oo0) {
                return true;
            }
            O000000o();
            long j = ServiceApplication.getAppContext().getSharedPreferences("smart_home_business_config", 0).getLong(O000000o(1, o000000o.f16070O000000o), 0);
            if (j == 0) {
                return true;
            }
            if (o000000o.O0000OOo > 0 && goz.O00000o(new Date(j), new Date()) >= o000000o.O0000OOo) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
     arg types: [java.lang.String, java.lang.Boolean]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
     arg types: [java.lang.String, java.lang.Long]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
     arg types: [java.lang.String, java.lang.Double]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
     arg types: [java.lang.String, java.lang.Float]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
    public static void O00000o0(O000000o o000000o) {
        String str;
        if (o000000o != null && o000000o.O0000Oo != null) {
            O00000Oo o00000Oo = o000000o.O0000Oo;
            int i = o00000Oo.f16071O000000o;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        Intent intent = new Intent();
                        if (!TextUtils.isEmpty(o00000Oo.O00000o)) {
                            str = o00000Oo.O00000o;
                        } else {
                            str = ServiceApplication.getAppContext().getPackageName();
                        }
                        intent.setPackage(str);
                        if (!TextUtils.isEmpty(o00000Oo.O00000oO)) {
                            intent.setAction(o00000Oo.O00000oO);
                        }
                        if (!TextUtils.isEmpty(o00000Oo.O00000oo)) {
                            intent.setClassName(str, o00000Oo.O00000oo);
                        }
                        O000000o(o00000Oo, intent);
                        intent.setFlags(268435456);
                        try {
                            ServiceApplication.getAppContext().startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (i == 4) {
                        Class O00000Oo2 = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity");
                        if (!TextUtils.isEmpty(o00000Oo.O00000o0) && O00000Oo2 != null) {
                            Intent intent2 = new Intent(ServiceApplication.getAppContext(), O00000Oo2);
                            intent2.putExtra("url", o00000Oo.O00000o0);
                            intent2.putExtra("title", o00000Oo.O00000Oo);
                            intent2.putExtra("args_use_title_bar", o00000Oo.O0000o00);
                            intent2.setFlags(268435456);
                            O000000o(o00000Oo, intent2);
                            try {
                                ServiceApplication.getAppContext().startActivity(intent2);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else if (i == 5 && !TextUtils.isEmpty(o00000Oo.O00000o0)) {
                        try {
                            Intent intent3 = new Intent();
                            intent3.setData(Uri.parse(o00000Oo.O00000o0));
                            intent3.setFlags(268435456);
                            intent3.setPackage(ServiceApplication.getAppContext().getPackageName());
                            ServiceApplication.getAppContext().startActivity(intent3);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } else if (!TextUtils.isEmpty(o00000Oo.O00000o0)) {
                    fbt fbt = new fbt(ServiceApplication.getAppContext(), "CommonWebViewActivity");
                    fbt.O000000o("url", o00000Oo.O00000o0);
                    fbt.O000000o("title", o00000Oo.O00000Oo);
                    fbt.O00000Oo(268435456);
                    if (o00000Oo.O0000O0o != null && o00000Oo.O0000O0o.size() > 0) {
                        for (Map.Entry next : o00000Oo.O0000O0o.entrySet()) {
                            String str2 = (String) next.getKey();
                            String str3 = (String) next.getValue();
                            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                                fbt.O000000o(str2, str3);
                            }
                        }
                    }
                    if (o00000Oo.O0000OOo != null && o00000Oo.O0000OOo.size() > 0) {
                        for (Map.Entry next2 : o00000Oo.O0000OOo.entrySet()) {
                            String str4 = (String) next2.getKey();
                            Boolean bool = (Boolean) next2.getValue();
                            if (!TextUtils.isEmpty(str4) && bool != null) {
                                fbt.O000000o(str4, (Serializable) bool);
                            }
                        }
                    }
                    if (o00000Oo.O0000Oo0 != null && o00000Oo.O0000Oo0.size() > 0) {
                        for (Map.Entry next3 : o00000Oo.O0000Oo0.entrySet()) {
                            String str5 = (String) next3.getKey();
                            Integer num = (Integer) next3.getValue();
                            if (!TextUtils.isEmpty(str5) && num != null) {
                                fbt.O000000o(str5, (Serializable) num);
                            }
                        }
                    }
                    if (o00000Oo.O0000Oo != null && o00000Oo.O0000Oo.size() > 0) {
                        for (Map.Entry next4 : o00000Oo.O0000Oo.entrySet()) {
                            String str6 = (String) next4.getKey();
                            Long l = (Long) next4.getValue();
                            if (!TextUtils.isEmpty(str6) && l != null) {
                                fbt.O000000o(str6, (Serializable) l);
                            }
                        }
                    }
                    if (o00000Oo.O0000OoO != null && o00000Oo.O0000OoO.size() > 0) {
                        for (Map.Entry next5 : o00000Oo.O0000OoO.entrySet()) {
                            String str7 = (String) next5.getKey();
                            Double d = (Double) next5.getValue();
                            if (!TextUtils.isEmpty(str7) && d != null) {
                                fbt.O000000o(str7, (Serializable) d);
                            }
                        }
                    }
                    if (o00000Oo.O0000Ooo != null && o00000Oo.O0000Ooo.size() > 0) {
                        for (Map.Entry next6 : o00000Oo.O0000Ooo.entrySet()) {
                            String str8 = (String) next6.getKey();
                            Float f = (Float) next6.getValue();
                            if (!TextUtils.isEmpty(str8) && f != null) {
                                fbt.O000000o(str8, (Serializable) f);
                            }
                        }
                    }
                    try {
                        fbs.O000000o(fbt);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } else if (!TextUtils.isEmpty(o00000Oo.O00000o0)) {
                try {
                    cmc.O000000o(o00000Oo.O00000o0);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private static void O000000o(O00000Oo o00000Oo, Intent intent) {
        if (o00000Oo.O0000O0o != null && o00000Oo.O0000O0o.size() > 0) {
            for (Map.Entry next : o00000Oo.O0000O0o.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    intent.putExtra(str, str2);
                }
            }
        }
        if (o00000Oo.O0000OOo != null && o00000Oo.O0000OOo.size() > 0) {
            for (Map.Entry next2 : o00000Oo.O0000OOo.entrySet()) {
                String str3 = (String) next2.getKey();
                Boolean bool = (Boolean) next2.getValue();
                if (!TextUtils.isEmpty(str3) && bool != null) {
                    intent.putExtra(str3, bool);
                }
            }
        }
        if (o00000Oo.O0000Oo0 != null && o00000Oo.O0000Oo0.size() > 0) {
            for (Map.Entry next3 : o00000Oo.O0000Oo0.entrySet()) {
                String str4 = (String) next3.getKey();
                Integer num = (Integer) next3.getValue();
                if (!TextUtils.isEmpty(str4) && num != null) {
                    intent.putExtra(str4, num);
                }
            }
        }
        if (o00000Oo.O0000Oo != null && o00000Oo.O0000Oo.size() > 0) {
            for (Map.Entry next4 : o00000Oo.O0000Oo.entrySet()) {
                String str5 = (String) next4.getKey();
                Long l = (Long) next4.getValue();
                if (!TextUtils.isEmpty(str5) && l != null) {
                    intent.putExtra(str5, l);
                }
            }
        }
        if (o00000Oo.O0000OoO != null && o00000Oo.O0000OoO.size() > 0) {
            for (Map.Entry next5 : o00000Oo.O0000OoO.entrySet()) {
                String str6 = (String) next5.getKey();
                Double d = (Double) next5.getValue();
                if (!TextUtils.isEmpty(str6) && d != null) {
                    intent.putExtra(str6, d);
                }
            }
        }
        if (o00000Oo.O0000Ooo != null && o00000Oo.O0000Ooo.size() > 0) {
            for (Map.Entry next6 : o00000Oo.O0000Ooo.entrySet()) {
                String str7 = (String) next6.getKey();
                Float f = (Float) next6.getValue();
                if (!TextUtils.isEmpty(str7) && f != null) {
                    intent.putExtra(str7, f);
                }
            }
        }
    }
}
