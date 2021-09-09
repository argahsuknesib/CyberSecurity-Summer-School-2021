package _m_j;

import _m_j.blp;
import _m_j.blq;
import _m_j.blr;
import _m_j.blv;
import _m_j.bma;
import _m_j.bmj;
import _m_j.bmm;
import _m_j.bmp;
import _m_j.bmt;
import _m_j.bmy;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.util.Log;
import com.ishumei.smantifraud.SmAntiFraud;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class blg implements blk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f13034O000000o;
    private static String O00000Oo;
    private static String O00000o;
    private static String O00000o0;
    private static String O00000oO;
    private static String O00000oo;
    private static String O0000O0o;
    private static String O0000OOo;
    private static String O0000Oo;
    private static String O0000Oo0;
    private static String O0000OoO;
    private static String O0000Ooo;
    private static String O0000o;
    private static String O0000o0;
    private static String O0000o00;
    private static String O0000o0O;
    private static String O0000o0o;
    private static String O0000oO;
    private static String O0000oO0;
    private static blg O0000oOO = null;

    static {
        try {
            f13034O000000o = bnd.O00000o0("919a8b88908d94");
            O00000Oo = bnd.O00000o0("908f9a8d9e8b908d");
            O00000o0 = bnd.O00000o0("929e9c");
            O00000o = bnd.O00000o0("8c8c969b");
            O00000oO = bnd.O00000o0("9d8c8c969b");
            O00000oo = bnd.O00000o0("88969996968f");
            O0000O0o = bnd.O00000o0("96929a96");
            O0000OOo = bnd.O00000o0("96928c96");
            O0000Oo0 = bnd.O00000o0("969c9c969b");
            O0000Oo = bnd.O00000o0("9e9b969b");
            O0000OoO = bnd.O00000o0("9e8f8c");
            O0000Ooo = bnd.O00000o0("9c9a9393");
            O0000o00 = bnd.O00000o0("9e8f8f8c");
            O0000o0 = bnd.O00000o0("919a8b");
            O0000o0O = bnd.O00000o0("8c9a918c908d");
            O0000o0o = bnd.O00000o0("9e9d8b929e9c");
            O0000o = bnd.O00000o0("9e96919990");
            O0000oO0 = bnd.O00000o0("8897968b9a9e8f8f");
            O0000oO = bnd.O00000o0("8d968c949e8f8f");
        } catch (Exception unused) {
        }
    }

    public static blg O000000o() {
        if (O0000oOO == null) {
            synchronized (blg.class) {
                if (O0000oOO == null) {
                    O0000oOO = new blg();
                }
            }
        }
        return O0000oOO;
    }

    public final Map<String, Object> O000000o(int i) {
        blh blh = new blh();
        O000000o(i, blh);
        return bne.O000000o(bne.O000000o(blh));
    }

    private static Map<String, Object> O000000o(Map<String, blr.O000000o> map) {
        HashMap hashMap = new HashMap();
        if (map == null || map.size() == 0 || blw.f13081O000000o == null) {
            return hashMap;
        }
        PackageManager packageManager = blw.f13081O000000o.getPackageManager();
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            blr.O000000o o000000o = (blr.O000000o) next.getValue();
            hashMap2.put(o000000o.O00000Oo, str);
            try {
                if (packageManager.getLaunchIntentForPackage(o000000o.O00000Oo) != null) {
                    hashMap.put(str, 1);
                }
                if (packageManager.getPackageInfo(o000000o.O00000Oo, 0) != null) {
                    hashMap.put(str, 1);
                }
                if (new File("/data/app/" + o000000o.O00000Oo + "-1/").exists()) {
                    hashMap.put(str, 1);
                } else {
                    if (new File("/data/app/" + o000000o.O00000Oo + "-2/").exists()) {
                        hashMap.put(str, 1);
                    }
                }
            } catch (Exception unused) {
            }
        }
        try {
            ArrayList<PackageInfo> arrayList = new ArrayList<>();
            for (ApplicationInfo applicationInfo : new ArrayList()) {
                if (hashMap2.containsKey(applicationInfo.packageName)) {
                    hashMap.put(hashMap2.get(applicationInfo.packageName), 1);
                }
            }
            for (PackageInfo packageInfo : arrayList) {
                if (hashMap2.containsKey(packageInfo.packageName)) {
                    hashMap.put(hashMap2.get(packageInfo.packageName), 1);
                }
            }
        } catch (Exception unused2) {
        }
        return hashMap;
    }

    private static Map<String, Object> O00000Oo(Map<String, blr.O00000Oo> map) {
        HashMap hashMap = new HashMap();
        if (!(map == null || map.size() == 0)) {
            for (Map.Entry next : map.entrySet()) {
                try {
                    String str = (String) next.getKey();
                    blr.O00000Oo o00000Oo = (blr.O00000Oo) next.getValue();
                    if (o00000Oo.O00000Oo == 0) {
                        if (bne.O000000o(o00000Oo.O00000o0)) {
                            hashMap.put(str, 1);
                        }
                    } else if (1 == o00000Oo.O00000Oo && bne.O00000Oo(o00000Oo.O00000o0)) {
                        hashMap.put(str, 1);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return hashMap;
    }

    public static void O000000o(int i, blh blh) {
        Map<String, blr.O000000o> map;
        Map<String, blr.O00000o> map2;
        int i2;
        int i3;
        String str;
        String str2 = "";
        blr O000000o2 = blp.O000000o.f13066O000000o.O000000o();
        try {
            Set<String> set = SmAntiFraud.f4498O000000o.O0000Ooo;
            if (set == null) {
                set = Collections.emptySet();
            }
            blh.O000oo0O = set;
            blh.O000oo0o = SmAntiFraud.f4498O000000o.O000000o();
            Map<String, blr.O00000Oo> map3 = null;
            Set<String> set2 = O000000o2 == null ? null : O000000o2.O00000oO;
            blh.f13035O000000o = "all";
            blo.O000000o().O00000o0();
            blh.O00000Oo = blo.O000000o().O00000Oo();
            int i4 = 1;
            int i5 = i & 1;
            blh.O00000o0 = i5 == 1 ? "md5" : "none";
            blh.O00000o = blm.O000000o().O00000Oo();
            blh.O00000oO = SmAntiFraud.f4498O000000o.O00000Oo;
            blh.O00000oo = "android";
            blh.O0000O0o = "2.9.4";
            blh.O0000OOo = str2;
            blh.O0000Oo0 = Long.valueOf(System.currentTimeMillis());
            blh.O0000Oo = Build.VERSION.RELEASE;
            blh.O0000OoO = SmAntiFraud.f4498O000000o.O0000o00;
            blh.O0000Ooo = Integer.valueOf(Process.myPid());
            blh.O0000o00 = Build.MODEL;
            if (!set.contains(O0000o0o)) {
                bmh.O000000o();
                blh.O0000o0 = bmh.O00000o0();
            }
            if (set2 != null && set2.contains(O0000o)) {
                StringBuilder sb = new StringBuilder();
                sb.append(bmh.O000000o().O00000o());
                blh.O0000o0O = sb.toString();
                bmh.O000000o();
                if (O000000o2 != null) {
                    str2 = O000000o2.O0000O0o;
                }
                bmh.O000000o(blh, str2, O000000o2 != null && O000000o2.O0000Ooo, SmAntiFraud.f4498O000000o.O0000o0O);
            }
            if (!set.contains(O0000o0)) {
                bmo.O000000o();
                List<String> O0000OOo2 = bmo.O0000OOo();
                if (i5 == 1) {
                    ArrayList arrayList = new ArrayList(O0000OOo2.size());
                    for (String O00000oo2 : O0000OOo2) {
                        arrayList.add(bne.O00000oo(O00000oo2));
                    }
                    blh.O0000o = arrayList;
                } else {
                    blh.O0000o = O0000OOo2;
                }
            }
            bmr.O000000o();
            HashMap<String, String> O000000o3 = bmr.O000000o(!set.contains("sn"));
            if (i5 == 1 && (str = O000000o3.get("ro.serialno")) != null) {
                O000000o3.put("ro.serialno", bne.O00000oo(str));
            }
            blh.O0000oO0 = O000000o3;
            if (set2 != null && set2.contains(O00000oO) && !set.contains(O00000oO)) {
                if (i5 == 1) {
                    blh.O0000oO = bne.O00000oo(bmo.O000000o().O00000o0());
                } else {
                    blh.O0000oO = bmo.O000000o().O00000o0();
                }
            }
            if (!set.contains(O0000O0o)) {
                if (i5 == 1) {
                    blh.O0000oOO = bne.O00000oo(bms.O000000o().O00000Oo());
                } else {
                    blh.O0000oOO = bms.O000000o().O00000Oo();
                }
                if (i5 == 1) {
                    blh.O0000oOo = bne.O00000oo(bms.O000000o().O000000o(1));
                } else {
                    blh.O0000oOo = bms.O000000o().O000000o(1);
                }
                if (i5 == 1) {
                    blh.O0000oo0 = bne.O00000oo(bms.O000000o().O000000o(2));
                } else {
                    blh.O0000oo0 = bms.O000000o().O000000o(2);
                }
            }
            if (!set.contains(O0000Oo)) {
                if (i5 == 1) {
                    blh.O0000oo = bne.O00000oo(bmq.O000000o().O00000Oo());
                } else {
                    blh.O0000oo = bmq.O000000o().O00000Oo();
                }
            }
            if (set2 != null && set2.contains(O0000OOo) && !set.contains(O0000OOo)) {
                if (i5 == 1) {
                    blh.O0000ooO = bne.O00000oo(bms.O000000o().O00000o());
                } else {
                    blh.O0000ooO = bms.O000000o().O00000o();
                }
            }
            if (set2 != null && set2.contains(O00000o0) && !set.contains(O00000o0)) {
                if (i5 == 1) {
                    blh.O0000ooo = bne.O00000oo(bmo.O000000o().O00000o());
                } else {
                    blh.O0000ooo = bmo.O000000o().O00000o();
                }
            }
            if (set2 != null && set2.contains(O0000o00) && !set.contains(O0000o00)) {
                if (O000000o2 == null) {
                    map2 = null;
                } else {
                    map2 = O000000o2.O00000o;
                }
                bmi O000000o4 = bmi.O000000o();
                if (O000000o2 == null) {
                    i2 = 0;
                } else {
                    i2 = O000000o2.O0000o0;
                }
                if (O000000o2 == null) {
                    i3 = 0;
                } else {
                    i3 = O000000o2.O0000o00;
                }
                Map<String, Object> O000000o5 = O000000o4.O000000o(map2, i2, i3);
                blh.O00oOooO = (List) O000000o5.get(O0000o00);
                blh.O00oOooo = (Map) O000000o5.get(O0000oO0);
            }
            blh.O000O00o = Build.getRadioVersion();
            if (set2 != null && set2.contains(O00000o) && !set.contains(O00000o)) {
                blh.O000O0OO = bmo.O000000o().O00000Oo();
            }
            if (!set.contains(O00000oo)) {
                blh.O000O0Oo = bmo.O000000o().O00000oO();
            }
            bmh.O000000o();
            blh.O000oo0 = bmh.O0000Oo0();
            bmh.O000000o();
            blh.O000oo = bmh.O0000Oo();
            blh.O00oOoOo = Integer.valueOf(bml.O000000o().O00000Oo());
            blh.O000O0o0 = bml.O000000o().f13100O000000o;
            blh.O000O0o = Integer.valueOf(bml.O000000o().O00000o0());
            blh.O000O0oO = bml.O000000o().O00000Oo;
            bmm unused = bmm.O000000o.f13102O000000o;
            blh.O000O0oo = bmm.O000000o();
            blh.O000OO00 = Integer.valueOf(bmq.O000000o().O00000oO());
            blh.O000OO0o = bmi.O000000o().O00000Oo();
            blh.O000OO = bmi.O000000o().O00000o0();
            bmq.O000000o();
            blh.O000OOOo = Long.valueOf(bmq.O00000o0());
            blh.O000OOo0 = bmi.O000000o().O00000o();
            blh.O000OOo = bmq.O000000o().O00000o();
            blh.O000OOoO = Build.BRAND;
            if (!set.contains(f13034O000000o)) {
                blh.O000OOoo = bmo.O000000o().O0000O0o();
            }
            if (!set.contains(O00000Oo)) {
                blh.O000Oo00 = bms.O000000o().O00000o0();
            }
            bmk.O000000o();
            blh.O000Oo0 = bmk.O000000o(!set.contains("sn"));
            if (!set.contains(O0000o0O)) {
                blh.O000Oo0O = bmp.O0000OOo.f13111O000000o.O000000o();
            }
            blh.O000Oo0o = Long.valueOf(bml.O000000o().O00000o());
            if (set2 != null && set2.contains(O0000Oo0) && !set.contains(O0000Oo0)) {
                blh.O000OoO0 = bms.O000000o().O00000oO();
            }
            if (set2 != null && set2.contains(O0000Ooo) && !set.contains(O0000Ooo)) {
                blh.O00O0Oo = bms.O000000o().O00000oo();
            }
            if (set2 != null && set2.contains(O0000OoO) && !set.contains(O0000OoO)) {
                blh.O000OoO = bmo.O000000o().O00000oo();
            }
            if (!set.contains(O0000oO)) {
                if (O000000o2 == null) {
                    map = null;
                } else {
                    map = O000000o2.O00000Oo;
                }
                blh.O000OoOO = O000000o(map);
            }
            if (O000000o2 != null) {
                map3 = O000000o2.O00000o0;
            }
            blh.O000OoOo = O00000Oo(map3);
            blh.O000Ooo0 = bmn.O000000o().O00000Oo();
            if (O000000o2 != null) {
                blh.O000Ooo = O000000o2.O0000OOo;
            }
            Object O00000oO2 = bmi.O000000o().O00000oO();
            if (O00000oO2 != null) {
                bmi.O000000o();
                blh.O000OooO = bmi.O000000o(O00000oO2);
                blh.O000Oooo = Integer.valueOf(O00000oO2.hashCode());
            }
            bmt.O000000o.f13116O000000o.O000000o(blh);
            if (blw.f13081O000000o != null) {
                blh.O000o0 = blw.f13081O000000o.getFilesDir().toString();
            }
            bmh.O000000o();
            blh.O000o0O0 = bmh.O00000Oo();
            bmh.O000000o();
            blh.O000o0O = bmh.O0000O0o();
            long O00000Oo2 = bmy.O000000o.f13125O000000o.O00000Oo();
            if (O00000Oo2 != -1) {
                blh.O000o0OO = Long.valueOf(O00000Oo2);
            }
            blh.O000o0Oo = bma.O000000o.f13086O000000o.O000000o();
            blh.O000o0o0 = blq.O000000o.f13069O000000o.O000000o();
            blh.O000o0o = blv.O000000o.f13080O000000o.O00000Oo();
            bmm unused2 = bmm.O000000o.f13102O000000o;
            bmm.O000000o(blh);
            bmj unused3 = bmj.O000000o.f13098O000000o;
            blh.O000oO0 = bmj.O000000o();
            bmq.O000000o();
            blh.O000oO0O = Integer.valueOf(bmq.O00000oo());
            if (!Debug.isDebuggerConnected()) {
                i4 = 0;
            }
            blh.O000oO0o = Integer.valueOf(i4);
            bmi.O000000o();
            blh.O000oO = Integer.valueOf(bmi.O00000oo());
            bmo.O000000o();
            blh.O000oOO0 = bmo.O0000Oo0();
            bmh.O000000o();
            blh.O000oOO = bmh.O00000oo();
            bmh.O000000o();
            blh.O000oOOO = bmh.O00000oO();
            bmh.O000000o();
            blh.O000oOoo = bmh.O0000OOo();
        } catch (Throwable th) {
            blh.O000oOOo = Log.getStackTraceString(th);
        }
    }
}
