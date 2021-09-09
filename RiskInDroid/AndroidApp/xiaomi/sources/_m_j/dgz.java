package _m_j;

import _m_j.dgj;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class dgz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f14627O000000o;
    private Context O00000Oo;
    private dhv O00000o;
    private dia O00000o0;
    private dgu O00000oO;
    private dhu O00000oo = null;
    private dgj.O000000o O0000O0o;

    public dgz(int i, Context context, dia dia, dhv dhv, dgu dgu, dgj.O000000o o000000o, dhu dhu) {
        f14627O000000o = 1004;
        this.O00000Oo = context;
        this.O00000o0 = dia;
        this.O00000o = dhv;
        this.O00000oO = dgu;
        this.O0000O0o = o000000o;
    }

    private static List<dgv> O00000o(List<dgv> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (dgv next : list) {
            if (next.O00000o && next.O00000Oo <= currentTimeMillis - 86400000) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static CrashDetailBean O000000o(List<dgv> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> O000000o2;
        String[] split;
        if (list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (dgv next : list) {
            if (next.O00000oO) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0 && (O000000o2 = O000000o(arrayList)) != null && O000000o2.size() > 0) {
            Collections.sort(O000000o2);
            CrashDetailBean crashDetailBean3 = null;
            for (int i = 0; i < O000000o2.size(); i++) {
                CrashDetailBean crashDetailBean4 = O000000o2.get(i);
                if (i == 0) {
                    crashDetailBean3 = crashDetailBean4;
                } else if (!(crashDetailBean4.O0000oO == null || (split = crashDetailBean4.O0000oO.split("\n")) == null)) {
                    for (String str : split) {
                        if (!crashDetailBean3.O0000oO.contains(String.valueOf(str))) {
                            crashDetailBean3.O0000oOO++;
                            crashDetailBean3.O0000oO += str + "\n";
                        }
                    }
                }
            }
            crashDetailBean2 = crashDetailBean3;
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.O0000Oo = true;
            crashDetailBean.O0000oOO = 0;
            crashDetailBean.O0000oO = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (dgv next2 : list) {
            if (!next2.O00000oO && !next2.O00000o) {
                String str2 = crashDetailBean2.O0000oO;
                StringBuilder sb = new StringBuilder();
                sb.append(next2.O00000Oo);
                if (!str2.contains(sb.toString())) {
                    crashDetailBean2.O0000oOO++;
                    crashDetailBean2.O0000oO += next2.O00000Oo + "\n";
                }
            }
        }
        if (crashDetailBean2.O0000oO0 != crashDetailBean.O0000oO0) {
            String str3 = crashDetailBean2.O0000oO;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.O0000oO0);
            if (!str3.contains(sb2.toString())) {
                crashDetailBean2.O0000oOO++;
                crashDetailBean2.O0000oO += crashDetailBean.O0000oO0 + "\n";
            }
        }
        return crashDetailBean2;
    }

    public final boolean O000000o(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return true;
        }
        if (dha.O0000o00 != null && !dha.O0000o00.isEmpty()) {
            did.O00000o0("Crash filter for crash stack is: %s", dha.O0000o00);
            if (crashDetailBean.O0000o.contains(dha.O0000o00)) {
                did.O00000o("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (dha.O0000o0 != null && !dha.O0000o0.isEmpty()) {
            did.O00000o0("Crash regular filter for crash stack is: %s", dha.O0000o0);
            if (Pattern.compile(dha.O0000o0).matcher(crashDetailBean.O0000o).find()) {
                did.O00000o("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        dhu dhu = this.O00000oo;
        if (dhu == null || dhu.O00000o0()) {
            if (crashDetailBean.O00000Oo != 2) {
                dhx dhx = new dhx();
                dhx.O00000Oo = 1;
                dhx.O00000o0 = crashDetailBean.O00oOooO;
                dhx.O00000o = crashDetailBean.O00oOooo;
                dhx.O00000oO = crashDetailBean.O0000oO0;
                this.O00000o.O00000Oo(1);
                this.O00000o.O000000o(dhx);
                did.O00000Oo("[crash] a crash occur, handling...", new Object[0]);
            } else {
                did.O00000Oo("[crash] a caught exception occur, handling...", new Object[0]);
            }
            List<dgv> O000000o2 = O000000o();
            ArrayList arrayList = null;
            if (O000000o2 != null && O000000o2.size() > 0) {
                arrayList = new ArrayList(10);
                ArrayList<dgv> arrayList2 = new ArrayList<>(10);
                arrayList.addAll(O00000o(O000000o2));
                O000000o2.removeAll(arrayList);
                if (!dgm.O00000o0 && dha.O00000o) {
                    boolean z = false;
                    for (dgv next : O000000o2) {
                        if (crashDetailBean.O0000oOo.equals(next.O00000o0)) {
                            if (next.O00000oO) {
                                z = true;
                            }
                            arrayList2.add(next);
                        }
                    }
                    if (z || arrayList2.size() >= dha.O00000o0) {
                        did.O000000o("same crash occur too much do merged!", new Object[0]);
                        CrashDetailBean O000000o3 = O000000o(arrayList2, crashDetailBean);
                        for (dgv dgv : arrayList2) {
                            if (dgv.f14619O000000o != O000000o3.f5815O000000o) {
                                arrayList.add(dgv);
                            }
                        }
                        O00000o0(O000000o3);
                        O00000Oo(arrayList);
                        did.O00000Oo("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                        return true;
                    }
                }
            }
            O00000o0(crashDetailBean);
            if (arrayList != null && !arrayList.isEmpty()) {
                O00000Oo(arrayList);
            }
            did.O00000Oo("[crash] save crash success", new Object[0]);
            return false;
        }
        did.O00000o("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
        return true;
    }

    public final void O000000o(CrashDetailBean crashDetailBean, boolean z) {
        if (dha.O0000Ooo) {
            did.O000000o("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            O000000o(arrayList, 3000, z, crashDetailBean.O00000Oo == 7, z);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a7 A[Catch:{ Throwable -> 0x00fb, Throwable -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00af A[Catch:{ Throwable -> 0x00fb, Throwable -> 0x0112 }] */
    public final void O000000o(List<CrashDetailBean> list, long j, boolean z, boolean z2, boolean z3) {
        dia dia;
        al alVar;
        final List<CrashDetailBean> list2 = list;
        if (!dgs.O000000o(this.O00000Oo).O0000O0o || (dia = this.O00000o0) == null) {
            return;
        }
        if (z3 || dia.O00000Oo(dha.f14631O000000o)) {
            StrategyBean O00000o02 = this.O00000oO.O00000o0();
            if (!O00000o02.O0000O0o) {
                did.O00000o("remote report is disable!", new Object[0]);
                did.O00000Oo("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            } else if (list2 != null && list.size() != 0) {
                try {
                    String str = this.O00000o0.O00000oo ? O00000o02.O0000oO : O00000o02.O0000oOO;
                    String str2 = this.O00000o0.O00000oo ? StrategyBean.O00000o0 : StrategyBean.f5812O000000o;
                    int i = this.O00000o0.O00000oo ? 830 : 630;
                    Context context = this.O00000Oo;
                    dgs O000000o2 = dgs.O000000o();
                    if (!(context == null || list2 == null || list.size() == 0)) {
                        if (O000000o2 != null) {
                            alVar = new al();
                            alVar.f5826a = new ArrayList<>();
                            for (CrashDetailBean O000000o3 : list) {
                                alVar.f5826a.add(O000000o(context, O000000o3, O000000o2));
                            }
                            if (alVar != null) {
                                did.O00000o("create eupPkg fail!", new Object[0]);
                                return;
                            }
                            byte[] O000000o4 = dhg.O000000o((k) alVar);
                            if (O000000o4 == null) {
                                did.O00000o("send encode fail!", new Object[0]);
                                return;
                            }
                            am O000000o5 = dhg.O000000o(this.O00000Oo, i, O000000o4);
                            if (O000000o5 == null) {
                                did.O00000o("request package is null.", new Object[0]);
                                return;
                            }
                            AnonymousClass1 r12 = new dhz() {
                                /* class _m_j.dgz.AnonymousClass1 */

                                public final void O000000o(boolean z) {
                                    dgz.O000000o(z, list2);
                                }
                            };
                            if (z) {
                                dia dia2 = this.O00000o0;
                                dia2.O000000o(new dib(dia2.f14654O000000o, f14627O000000o, O000000o5.g, dhg.O000000o((Object) O000000o5), str, str2, r12, dia2.O00000oo, z2), true, true, j);
                                return;
                            }
                            this.O00000o0.O000000o(f14627O000000o, O000000o5, str, str2, r12, false);
                            return;
                        }
                    }
                    did.O00000o("enEXPPkg args == null!", new Object[0]);
                    alVar = null;
                    if (alVar != null) {
                    }
                } catch (Throwable th) {
                    did.O00000oO("req cr error %s", th.toString());
                    if (!did.O00000Oo(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public static void O000000o(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            did.O00000o0("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean next : list) {
                did.O00000o0("pre uid:%s uc:%d re:%b me:%b", next.O00000o0, Integer.valueOf(next.O0000Ooo), Boolean.valueOf(next.O00000o), Boolean.valueOf(next.O0000Oo));
                next.O0000Ooo++;
                next.O00000o = z;
                did.O00000o0("set uid:%s uc:%d re:%b me:%b", next.O00000o0, Integer.valueOf(next.O0000Ooo), Boolean.valueOf(next.O00000o), Boolean.valueOf(next.O0000Oo));
            }
            for (CrashDetailBean O00000o02 : list) {
                dha.O000000o();
                O00000o0(O00000o02);
            }
            did.O00000o0("update state size %d", Integer.valueOf(list.size()));
        }
        if (!z) {
            did.O00000Oo("[crash] upload fail.", new Object[0]);
        }
    }

    public final void O00000Oo(CrashDetailBean crashDetailBean) {
        Map<String, String> map;
        String str;
        HashMap hashMap;
        if (this.O0000O0o != null || this.O00000oo != null) {
            try {
                did.O000000o("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
                switch (crashDetailBean.O00000Oo) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        byte[] bArr = null;
                        if (this.O00000oo != null) {
                            String O00000Oo2 = this.O00000oo.O00000Oo();
                            if (O00000Oo2 != null) {
                                hashMap = new HashMap(1);
                                hashMap.put("userData", O00000Oo2);
                            } else {
                                hashMap = null;
                            }
                            map = hashMap;
                        } else {
                            map = this.O0000O0o != null ? this.O0000O0o.O000000o() : null;
                        }
                        if (map != null && map.size() > 0) {
                            crashDetailBean.O000OOo0 = new LinkedHashMap(map.size());
                            for (Map.Entry entry : map.entrySet()) {
                                if (!dif.O000000o((String) entry.getKey())) {
                                    String str2 = (String) entry.getKey();
                                    if (str2.length() > 100) {
                                        str2 = str2.substring(0, 100);
                                        did.O00000o("setted key length is over limit %d substring to %s", 100, str2);
                                    }
                                    if (dif.O000000o((String) entry.getValue()) || ((String) entry.getValue()).length() <= 30000) {
                                        str = ((String) entry.getValue());
                                    } else {
                                        str = ((String) entry.getValue()).substring(((String) entry.getValue()).length() - 30000);
                                        did.O00000o("setted %s value length is over limit %d substring", str2, 30000);
                                    }
                                    crashDetailBean.O000OOo0.put(str2, str);
                                    did.O000000o("add setted key %s value size:%d", str2, Integer.valueOf(str.length()));
                                }
                            }
                        }
                        did.O000000o("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                        if (this.O00000oo != null) {
                            bArr = this.O00000oo.O000000o();
                        } else if (this.O0000O0o != null) {
                            bArr = this.O0000O0o.O00000Oo();
                        }
                        crashDetailBean.O000Oo0 = bArr;
                        if (crashDetailBean.O000Oo0 != null) {
                            if (crashDetailBean.O000Oo0.length > 30000) {
                                did.O00000o("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(crashDetailBean.O000Oo0.length), 30000);
                            }
                            did.O000000o("add extra bytes %d ", Integer.valueOf(crashDetailBean.O000Oo0.length));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                did.O00000o("crash handle callback somthing wrong! %s", th.getClass().getName());
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static ContentValues O00000o(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f5815O000000o > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.f5815O000000o));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.O0000oO0));
            contentValues.put("_s1", crashDetailBean.O0000oOo);
            int i = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.O00000o ? 1 : 0));
            if (!crashDetailBean.O0000Oo) {
                i = 0;
            }
            contentValues.put("_me", Integer.valueOf(i));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.O0000Ooo));
            contentValues.put("_dt", dif.O000000o(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static CrashDetailBean O000000o(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) dif.O000000o(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f5815O000000o = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static void O00000o0(CrashDetailBean crashDetailBean) {
        ContentValues O00000o2;
        if (crashDetailBean != null && (O00000o2 = O00000o(crashDetailBean)) != null) {
            long O000000o2 = dhv.O000000o().O000000o("t_cr", O00000o2, (dhu) null);
            if (O000000o2 >= 0) {
                did.O00000o0("insert %s success!", "t_cr");
                crashDetailBean.f5815O000000o = O000000o2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b8 A[Catch:{ all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c4  */
    static List<CrashDetailBean> O000000o(List<dgv> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (dgv dgv : list) {
            sb.append(" or _id = ");
            sb.append(dgv.f14619O000000o);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        sb.setLength(0);
        try {
            cursor = dhv.O000000o().O000000o("t_cr", (String[]) null, sb2);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    CrashDetailBean O000000o2 = O000000o(cursor);
                    if (O000000o2 != null) {
                        arrayList.add(O000000o2);
                    } else {
                        long j = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb.append(" or _id = ");
                        sb.append(j);
                    }
                }
                String sb3 = sb.toString();
                if (sb3.length() > 0) {
                    did.O00000o("deleted %s illegle data %d", "t_cr", Integer.valueOf(dhv.O000000o().O000000o("t_cr", sb3.substring(4))));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!did.O000000o(th)) {
                    }
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static dgv O00000Oo(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            dgv dgv = new dgv();
            dgv.f14619O000000o = cursor.getLong(cursor.getColumnIndex("_id"));
            dgv.O00000Oo = cursor.getLong(cursor.getColumnIndex("_tm"));
            dgv.O00000o0 = cursor.getString(cursor.getColumnIndex("_s1"));
            boolean z = false;
            dgv.O00000o = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            if (cursor.getInt(cursor.getColumnIndex("_me")) == 1) {
                z = true;
            }
            dgv.O00000oO = z;
            dgv.O00000oo = cursor.getInt(cursor.getColumnIndex("_uc"));
            return dgv;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008a, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009b, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a1, code lost:
        r3.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0087 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0096 A[Catch:{ all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1  */
    static List<dgv> O000000o() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            cursor = dhv.O000000o().O000000o("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, (String) null);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (cursor.moveToNext()) {
                    dgv O00000Oo2 = O00000Oo(cursor);
                    if (O00000Oo2 != null) {
                        arrayList.add(O00000Oo2);
                    } else {
                        long j = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb.append(" or _id = ");
                        sb.append(j);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    did.O00000o("deleted %s illegle data %d", "t_cr", Integer.valueOf(dhv.O000000o().O000000o("t_cr", sb2.substring(4))));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!did.O000000o(th)) {
                }
                if (cursor2 != null) {
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                cursor = cursor2;
                if (cursor != null) {
                }
                throw th;
            }
        }
    }

    static void O00000Oo(List<dgv> list) {
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (dgv dgv : list) {
                sb.append(" or _id = ");
                sb.append(dgv.f14619O000000o);
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                sb2 = sb2.substring(4);
            }
            sb.setLength(0);
            try {
                did.O00000o0("deleted %s data %d", "t_cr", Integer.valueOf(dhv.O000000o().O000000o("t_cr", sb2)));
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    static void O00000o0(List<CrashDetailBean> list) {
        try {
            if (list.size() != 0) {
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or _id = ");
                    sb.append(crashDetailBean.f5815O000000o);
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    sb2 = sb2.substring(4);
                }
                sb.setLength(0);
                did.O00000o0("deleted %s data %d", "t_cr", Integer.valueOf(dhv.O000000o().O000000o("t_cr", sb2)));
            }
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
    }

    private static ak O000000o(Context context, CrashDetailBean crashDetailBean, dgs dgs) {
        aj O000000o2;
        aj O000000o3;
        aj ajVar;
        boolean z = false;
        if (context == null || crashDetailBean == null || dgs == null) {
            did.O00000o("enExp args == null", new Object[0]);
            return null;
        }
        ak akVar = new ak();
        switch (crashDetailBean.O00000Oo) {
            case 0:
                akVar.f5824a = crashDetailBean.O0000Oo ? "200" : "100";
                break;
            case 1:
                akVar.f5824a = crashDetailBean.O0000Oo ? "201" : "101";
                break;
            case 2:
                akVar.f5824a = crashDetailBean.O0000Oo ? "202" : "102";
                break;
            case 3:
                akVar.f5824a = crashDetailBean.O0000Oo ? "203" : "103";
                break;
            case 4:
                akVar.f5824a = crashDetailBean.O0000Oo ? "204" : "104";
                break;
            case 5:
                akVar.f5824a = crashDetailBean.O0000Oo ? "207" : "107";
                break;
            case 6:
                akVar.f5824a = crashDetailBean.O0000Oo ? "206" : "106";
                break;
            case 7:
                akVar.f5824a = crashDetailBean.O0000Oo ? "208" : "108";
                break;
            default:
                did.O00000oO("crash type error! %d", Integer.valueOf(crashDetailBean.O00000Oo));
                break;
        }
        akVar.b = crashDetailBean.O0000oO0;
        akVar.c = crashDetailBean.O0000o0;
        akVar.d = crashDetailBean.O0000o0O;
        akVar.e = crashDetailBean.O0000o0o;
        akVar.g = crashDetailBean.O0000o;
        akVar.h = crashDetailBean.O0000ooo;
        akVar.i = crashDetailBean.O00000o0;
        akVar.j = null;
        akVar.l = crashDetailBean.O0000o00;
        akVar.m = crashDetailBean.O00000oO;
        akVar.f = crashDetailBean.O00oOooo;
        akVar.t = dgs.O000000o().O00000oo();
        akVar.n = null;
        if (crashDetailBean.O0000Oo0 != null && crashDetailBean.O0000Oo0.size() > 0) {
            akVar.o = new ArrayList<>();
            for (Map.Entry next : crashDetailBean.O0000Oo0.entrySet()) {
                ah ahVar = new ah();
                ahVar.f5818a = ((PlugInBean) next.getValue()).f5811O000000o;
                ahVar.c = ((PlugInBean) next.getValue()).O00000o0;
                ahVar.d = ((PlugInBean) next.getValue()).O00000Oo;
                ahVar.b = dgs.O0000o0O();
                akVar.o.add(ahVar);
            }
        }
        if (crashDetailBean.O0000OOo != null && crashDetailBean.O0000OOo.size() > 0) {
            akVar.p = new ArrayList<>();
            for (Map.Entry next2 : crashDetailBean.O0000OOo.entrySet()) {
                ah ahVar2 = new ah();
                ahVar2.f5818a = ((PlugInBean) next2.getValue()).f5811O000000o;
                ahVar2.c = ((PlugInBean) next2.getValue()).O00000o0;
                ahVar2.d = ((PlugInBean) next2.getValue()).O00000Oo;
                akVar.p.add(ahVar2);
            }
        }
        if (crashDetailBean.O0000Oo) {
            akVar.k = crashDetailBean.O0000oOO;
            if (crashDetailBean.O0000oO != null && crashDetailBean.O0000oO.length() > 0) {
                if (akVar.q == null) {
                    akVar.q = new ArrayList<>();
                }
                try {
                    akVar.q.add(new aj((byte) 1, "alltimes.txt", crashDetailBean.O0000oO.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    akVar.q = null;
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(akVar.k);
            objArr[1] = Integer.valueOf(akVar.q != null ? akVar.q.size() : 0);
            did.O00000o0("crashcount:%d sz:%d", objArr);
        }
        if (crashDetailBean.O0000oo != null) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            try {
                akVar.q.add(new aj((byte) 1, "log.txt", crashDetailBean.O0000oo.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                akVar.q = null;
            }
        }
        if (!dif.O000000o(crashDetailBean.O000Oo0O)) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            try {
                ajVar = new aj((byte) 1, "crashInfos.txt", crashDetailBean.O000Oo0O.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                ajVar = null;
            }
            if (ajVar != null) {
                did.O00000o0("attach crash infos", new Object[0]);
                akVar.q.add(ajVar);
            }
        }
        if (crashDetailBean.O000Oo0o != null) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            aj O000000o4 = O000000o("backupRecord.zip", context, crashDetailBean.O000Oo0o);
            if (O000000o4 != null) {
                did.O00000o0("attach backup record", new Object[0]);
                akVar.q.add(O000000o4);
            }
        }
        if (crashDetailBean.O0000ooO != null && crashDetailBean.O0000ooO.length > 0) {
            aj ajVar2 = new aj((byte) 2, "buglylog.zip", crashDetailBean.O0000ooO);
            did.O00000o0("attach user log", new Object[0]);
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            akVar.q.add(ajVar2);
        }
        if (crashDetailBean.O00000Oo == 3) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            if (crashDetailBean.O000OOo0 != null && crashDetailBean.O000OOo0.containsKey("BUGLY_CR_01")) {
                try {
                    akVar.q.add(new aj((byte) 1, "anrMessage.txt", crashDetailBean.O000OOo0.get("BUGLY_CR_01").getBytes("utf-8")));
                    did.O00000o0("attach anr message", new Object[0]);
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                    akVar.q = null;
                }
                crashDetailBean.O000OOo0.remove("BUGLY_CR_01");
            }
            if (!(crashDetailBean.O0000oo0 == null || (O000000o3 = O000000o("trace.zip", context, crashDetailBean.O0000oo0)) == null)) {
                did.O00000o0("attach traces", new Object[0]);
                akVar.q.add(O000000o3);
            }
        }
        if (crashDetailBean.O00000Oo == 1) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            if (!(crashDetailBean.O0000oo0 == null || (O000000o2 = O000000o("tomb.zip", context, crashDetailBean.O0000oo0)) == null)) {
                did.O00000o0("attach tombs", new Object[0]);
                akVar.q.add(O000000o2);
            }
        }
        if (dgs.O000OO0o != null && !dgs.O000OO0o.isEmpty()) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder();
            for (String append : dgs.O000OO0o) {
                sb.append(append);
            }
            try {
                akVar.q.add(new aj((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                did.O00000o0("attach pageTracingList", new Object[0]);
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
            }
        }
        if (crashDetailBean.O000Oo0 != null && crashDetailBean.O000Oo0.length > 0) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            akVar.q.add(new aj((byte) 1, "userExtraByteData", crashDetailBean.O000Oo0));
            did.O00000o0("attach extraData", new Object[0]);
        }
        akVar.r = new HashMap();
        Map<String, String> map = akVar.r;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(crashDetailBean.O000O00o);
        map.put("A9", sb2.toString());
        Map<String, String> map2 = akVar.r;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(crashDetailBean.O000O0OO);
        map2.put("A11", sb3.toString());
        Map<String, String> map3 = akVar.r;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(crashDetailBean.O000O0Oo);
        map3.put("A10", sb4.toString());
        akVar.r.put("A23", crashDetailBean.O00000oo);
        akVar.r.put("A7", dgs.O0000OOo);
        akVar.r.put("A6", dgs.O0000o0o());
        akVar.r.put("A5", dgs.O0000o0O());
        akVar.r.put("A22", dgs.O00000oO());
        Map<String, String> map4 = akVar.r;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(crashDetailBean.O000O0o0);
        map4.put("A2", sb5.toString());
        Map<String, String> map5 = akVar.r;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(crashDetailBean.O00oOoOo);
        map5.put("A1", sb6.toString());
        akVar.r.put("A24", dgs.O0000Oo);
        Map<String, String> map6 = akVar.r;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(crashDetailBean.O000O0o);
        map6.put("A17", sb7.toString());
        akVar.r.put("A3", dgs.O0000OOo());
        akVar.r.put("A16", dgs.O0000Oo());
        akVar.r.put("A25", dgs.O0000OoO());
        akVar.r.put("A14", dgs.O0000Oo0());
        akVar.r.put("A15", dgs.O0000oOO());
        Map<String, String> map7 = akVar.r;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(dgs.O0000oOo());
        map7.put("A13", sb8.toString());
        akVar.r.put("A34", crashDetailBean.O00oOooO);
        if (dgs.O000O0o0 != null) {
            akVar.r.put("productIdentify", dgs.O000O0o0);
        }
        try {
            akVar.r.put("A26", URLEncoder.encode(crashDetailBean.O000O0oO, "utf-8"));
        } catch (UnsupportedEncodingException e6) {
            e6.printStackTrace();
        }
        if (crashDetailBean.O00000Oo == 1) {
            akVar.r.put("A27", crashDetailBean.O000OO00);
            akVar.r.put("A28", crashDetailBean.O000O0oo);
            Map<String, String> map8 = akVar.r;
            StringBuilder sb9 = new StringBuilder();
            sb9.append(crashDetailBean.O0000OoO);
            map8.put("A29", sb9.toString());
        }
        akVar.r.put("A30", crashDetailBean.O000OO0o);
        Map<String, String> map9 = akVar.r;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(crashDetailBean.O000OO);
        map9.put("A18", sb10.toString());
        Map<String, String> map10 = akVar.r;
        StringBuilder sb11 = new StringBuilder();
        sb11.append(!crashDetailBean.O000OOOo);
        map10.put("A36", sb11.toString());
        Map<String, String> map11 = akVar.r;
        StringBuilder sb12 = new StringBuilder();
        sb12.append(dgs.O0000ooo);
        map11.put("F02", sb12.toString());
        Map<String, String> map12 = akVar.r;
        StringBuilder sb13 = new StringBuilder();
        sb13.append(dgs.O00oOooO);
        map12.put("F03", sb13.toString());
        akVar.r.put("F04", dgs.O00000Oo());
        Map<String, String> map13 = akVar.r;
        StringBuilder sb14 = new StringBuilder();
        sb14.append(dgs.O00oOooo);
        map13.put("F05", sb14.toString());
        akVar.r.put("F06", dgs.O0000ooO);
        akVar.r.put("F08", dgs.O000O0Oo);
        akVar.r.put("F09", dgs.O00oOoOo);
        Map<String, String> map14 = akVar.r;
        StringBuilder sb15 = new StringBuilder();
        sb15.append(dgs.O000O00o);
        map14.put("F10", sb15.toString());
        if (crashDetailBean.O000OOo >= 0) {
            Map<String, String> map15 = akVar.r;
            StringBuilder sb16 = new StringBuilder();
            sb16.append(crashDetailBean.O000OOo);
            map15.put("C01", sb16.toString());
        }
        if (crashDetailBean.O000OOoO >= 0) {
            Map<String, String> map16 = akVar.r;
            StringBuilder sb17 = new StringBuilder();
            sb17.append(crashDetailBean.O000OOoO);
            map16.put("C02", sb17.toString());
        }
        if (crashDetailBean.O000OOoo != null && crashDetailBean.O000OOoo.size() > 0) {
            for (Map.Entry next3 : crashDetailBean.O000OOoo.entrySet()) {
                akVar.r.put("C03_" + ((String) next3.getKey()), next3.getValue());
            }
        }
        if (crashDetailBean.O000Oo00 != null && crashDetailBean.O000Oo00.size() > 0) {
            for (Map.Entry next4 : crashDetailBean.O000Oo00.entrySet()) {
                akVar.r.put("C04_" + ((String) next4.getKey()), next4.getValue());
            }
        }
        akVar.s = null;
        if (crashDetailBean.O000OOo0 != null && crashDetailBean.O000OOo0.size() > 0) {
            akVar.s = crashDetailBean.O000OOo0;
            did.O000000o("setted message size %d", Integer.valueOf(akVar.s.size()));
        }
        Object[] objArr2 = new Object[12];
        objArr2[0] = crashDetailBean.O0000o0;
        objArr2[1] = crashDetailBean.O00000o0;
        objArr2[2] = dgs.O00000Oo();
        objArr2[3] = Long.valueOf((crashDetailBean.O0000oO0 - crashDetailBean.O000OO) / 1000);
        objArr2[4] = Boolean.valueOf(crashDetailBean.O0000OoO);
        objArr2[5] = Boolean.valueOf(crashDetailBean.O000OOOo);
        objArr2[6] = Boolean.valueOf(crashDetailBean.O0000Oo);
        if (crashDetailBean.O00000Oo == 1) {
            z = true;
        }
        objArr2[7] = Boolean.valueOf(z);
        objArr2[8] = Integer.valueOf(crashDetailBean.O0000oOO);
        objArr2[9] = crashDetailBean.O0000oO;
        objArr2[10] = Boolean.valueOf(crashDetailBean.O00000o);
        objArr2[11] = Integer.valueOf(akVar.r.size());
        did.O00000o0("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
        return akVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0091 A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0096 A[SYNTHETIC, Splitter:B:37:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b6 A[SYNTHETIC, Splitter:B:49:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ca  */
    private static aj O000000o(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            did.O00000o("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        did.O00000o0("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (!dif.O000000o(file, file2)) {
            did.O00000o("zip fail!", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file2);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                did.O00000o0("read bytes :%d", Integer.valueOf(byteArray.length));
                aj ajVar = new aj((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    if (!did.O000000o(e)) {
                        e.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    did.O00000o0("del tmp", new Object[0]);
                    file2.delete();
                }
                return ajVar;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!did.O000000o(th)) {
                    }
                    if (fileInputStream != null) {
                    }
                    if (file2.exists()) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                    }
                    if (file2.exists()) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    if (!did.O000000o(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
            if (file2.exists()) {
                did.O00000o0("del tmp", new Object[0]);
                file2.delete();
            }
            throw th;
        }
    }

    public static void O000000o(String str, String str2, String str3, Thread thread, String str4, CrashDetailBean crashDetailBean) {
        String str5;
        dgs O000000o2 = dgs.O000000o();
        if (O000000o2 != null) {
            did.O00000oO("#++++++++++Record By Bugly++++++++++#", new Object[0]);
            did.O00000oO("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
            did.O00000oO("# PKG NAME: %s", O000000o2.O00000oO);
            did.O00000oO("# APP VER: %s", O000000o2.O0000o0);
            did.O00000oO("# LAUNCH TIME: %s", dif.O000000o(new Date(dgs.O000000o().O00000o0)));
            did.O00000oO("# CRASH TYPE: %s", str);
            did.O00000oO("# CRASH TIME: %s", str2);
            did.O00000oO("# CRASH PROCESS: %s", str3);
            if (thread != null) {
                did.O00000oO("# CRASH THREAD: %s", thread.getName());
            }
            if (crashDetailBean != null) {
                did.O00000oO("# REPORT ID: %s", crashDetailBean.O00000o0);
                Object[] objArr = new Object[2];
                objArr[0] = O000000o2.O0000Oo0;
                objArr[1] = O000000o2.O0000oOo().booleanValue() ? "ROOTED" : "UNROOT";
                did.O00000oO("# CRASH DEVICE: %s %s", objArr);
                did.O00000oO("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.O000O00o), Long.valueOf(crashDetailBean.O000O0OO), Long.valueOf(crashDetailBean.O000O0Oo));
                did.O00000oO("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.O00oOoOo), Long.valueOf(crashDetailBean.O000O0o0), Long.valueOf(crashDetailBean.O000O0o));
                if (!dif.O000000o(crashDetailBean.O000OO00)) {
                    did.O00000oO("# EXCEPTION FIRED BY %s %s", crashDetailBean.O000OO00, crashDetailBean.O000O0oo);
                } else if (crashDetailBean.O00000Oo == 3) {
                    Object[] objArr2 = new Object[1];
                    if (crashDetailBean.O000OOo0 == null) {
                        str5 = "null";
                    } else {
                        str5 = crashDetailBean.O000OOo0.get("BUGLY_CR_01");
                    }
                    objArr2[0] = str5;
                    did.O00000oO("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
                }
            }
            if (!dif.O000000o(str4)) {
                did.O00000oO("# CRASH STACK: ", new Object[0]);
                did.O00000oO(str4, new Object[0]);
            }
            did.O00000oO("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
        }
    }
}
