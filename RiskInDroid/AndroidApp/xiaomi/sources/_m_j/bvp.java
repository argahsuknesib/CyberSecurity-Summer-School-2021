package _m_j;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.loc.ee;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class bvp {

    /* renamed from: O000000o  reason: collision with root package name */
    Hashtable<String, ArrayList<O000000o>> f13316O000000o = new Hashtable<>();
    public boolean O00000Oo = false;
    boolean O00000o = true;
    String O00000o0 = "2.0.201501131131".replace(".", "");
    long O00000oO = 0;
    String O00000oo = null;
    bvm O0000O0o = null;
    long O0000OOo = 0;
    boolean O0000Oo = true;
    boolean O0000Oo0 = true;
    String O0000OoO = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
    private long O0000Ooo = 0;
    private String O0000o0 = null;
    private String O0000o00 = null;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        AMapLocationServer f13317O000000o = null;
        String O00000Oo = null;

        protected O000000o() {
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private String O000000o(String str, StringBuilder sb, Context context) {
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (this.O0000o00 == null) {
            this.O0000o00 = bvo.O000000o("MD5", bwt.O00000o0(context));
        }
        if (str.contains("&")) {
            str = str.substring(0, str.indexOf("&"));
        }
        String substring = str.substring(str.lastIndexOf("#") + 1);
        if (substring.equals("cgi")) {
            jSONObject.put("cgi", str.substring(0, str.length() - 12));
        } else if (!TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
            jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + 9)));
            String[] split = sb.toString().split(",access");
            jSONObject.put("mmac", split[0].contains("#") ? split[0].substring(split[0].lastIndexOf("#") + 1) : split[0]);
        }
        try {
            return bwx.O00000Oo(bvo.O00000o0(jSONObject.toString().getBytes("UTF-8"), this.O0000o00));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase$CursorFactory] */
    private void O000000o(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context != null) {
            if (this.O0000o00 == null) {
                this.O0000o00 = bvo.O000000o("MD5", bwt.O00000o0(context));
            }
            Object O000000o2 = O000000o(str, sb, context);
            StringBuilder sb2 = new StringBuilder();
            ? r2 = 0;
            try {
                SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, r2);
                sb2.append("CREATE TABLE IF NOT EXISTS hist");
                sb2.append(this.O00000o0);
                sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
                openOrCreateDatabase.execSQL(sb2.toString());
                sb2.delete(0, sb2.length());
                sb2.append("REPLACE INTO ");
                sb2.append("hist");
                sb2.append(this.O00000o0);
                sb2.append(" VALUES (?, ?, ?, ?)");
                Object O00000o02 = bvo.O00000o0(sb.toString().getBytes("UTF-8"), this.O0000o00);
                Object[] objArr = {O000000o2, O00000o02, bvo.O00000o0(aMapLocation.toStr().getBytes("UTF-8"), this.O0000o00), Long.valueOf(aMapLocation.getTime())};
                for (int i = 1; i < 3; i++) {
                    objArr[i] = bwx.O00000Oo((byte[]) objArr[i]);
                }
                openOrCreateDatabase.execSQL(sb2.toString(), objArr);
                sb2.delete(0, sb2.length());
                sb2.delete(0, sb2.length());
                if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                    openOrCreateDatabase.close();
                }
            } catch (Throwable th) {
                sb2.delete(0, sb2.length());
                if (r2 != 0 && r2.isOpen()) {
                    r2.close();
                }
                throw th;
            }
        }
    }

    private static void O000000o(String str, Hashtable<String, String> hashtable) {
        if (!TextUtils.isEmpty(str)) {
            hashtable.clear();
            for (String str2 : str.split("#")) {
                if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                    hashtable.put(str2, "");
                }
            }
        }
    }

    private static double[] O000000o(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr;
        double[] dArr4 = new double[3];
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dArr3.length; i3++) {
            d2 += dArr3[i3] * dArr3[i3];
            d3 += dArr2[i3] * dArr2[i3];
            d += dArr3[i3] * dArr2[i3];
            if (dArr2[i3] == 1.0d) {
                i2++;
                if (dArr3[i3] == 1.0d) {
                    i++;
                }
            }
        }
        dArr4[0] = d / (Math.sqrt(d2) * Math.sqrt(d3));
        double d4 = (double) i;
        Double.isNaN(d4);
        double d5 = (double) i2;
        Double.isNaN(d5);
        dArr4[1] = (d4 * 1.0d) / d5;
        dArr4[2] = d4;
        for (int i4 = 0; i4 < 2; i4++) {
            if (dArr4[i4] > 1.0d) {
                dArr4[i4] = 1.0d;
            }
        }
        return dArr4;
    }

    private boolean O00000Oo() {
        long O00000o02 = bwi.O00000o0();
        long j = this.O0000Ooo;
        return j != 0 && (this.f13316O000000o.size() > 360 || O00000o02 - j > 36000000);
    }

    public final AMapLocationServer O000000o(Context context, String str, StringBuilder sb, boolean z) {
        if (TextUtils.isEmpty(str) || !bvy.O0000o0O()) {
            return null;
        }
        String str2 = str + "&" + this.O0000Oo0 + "&" + this.O0000Oo + "&" + this.O0000OoO;
        if (str2.contains("gps") || !bvy.O0000o0O() || sb == null) {
            return null;
        }
        if (O00000Oo()) {
            O000000o();
            return null;
        }
        if (z && !this.O00000Oo) {
            try {
                String O000000o2 = O000000o(str2, sb, context);
                O000000o();
                O000000o(context, O000000o2);
            } catch (Throwable unused) {
            }
        }
        if (this.f13316O000000o.isEmpty()) {
            return null;
        }
        return O000000o(str2, sb);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bvp.O000000o(android.content.Context, java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer
     arg types: [android.content.Context, java.lang.String, java.lang.StringBuilder, int]
     candidates:
      _m_j.bvp.O000000o(java.lang.String, com.amap.api.location.AMapLocation, java.lang.StringBuilder, android.content.Context):void
      _m_j.bvp.O000000o(android.content.Context, java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0048 A[Catch:{ Throwable -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0067 A[Catch:{ Throwable -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a4 A[Catch:{ Throwable -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ab A[Catch:{ Throwable -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b1 A[Catch:{ Throwable -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d4 A[Catch:{ Throwable -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d9 A[Catch:{ Throwable -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e2 A[ADDED_TO_REGION, Catch:{ Throwable -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f0 A[Catch:{ Throwable -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00fa A[Catch:{ Throwable -> 0x0107 }] */
    public final AMapLocationServer O000000o(ee eeVar, boolean z, AMapLocationServer aMapLocationServer, bvn bvn, StringBuilder sb, String str, Context context) {
        boolean z2;
        boolean z3;
        boolean z4;
        String str2;
        long O00000Oo2;
        AMapLocationServer aMapLocationServer2 = aMapLocationServer;
        String str3 = str;
        boolean z5 = true;
        if (!((this.O00000o && bvy.O0000o0O()) && (aMapLocationServer2 == null || bvy.O00000Oo(aMapLocationServer.getTime())))) {
            return null;
        }
        try {
            bvm O000000o2 = eeVar.O000000o();
            if (!(O000000o2 == null && this.O0000O0o == null)) {
                if (this.O0000O0o != null) {
                    if (!this.O0000O0o.equals(O000000o2)) {
                    }
                }
                z2 = true;
                if (aMapLocationServer2 != null) {
                    int size = bvn.O00000Oo().size();
                    if (aMapLocationServer.getAccuracy() > 299.0f && size > 5) {
                        z3 = true;
                        if (aMapLocationServer2 != null || this.O00000oo == null || z3 || z2) {
                            z4 = false;
                        } else {
                            z4 = bwi.O000000o(this.O00000oo, sb.toString());
                            boolean z6 = this.O00000oO != 0 && bwi.O00000o0() - this.O00000oO < 3000;
                            if ((z4 || z6) && bwi.O000000o(aMapLocationServer)) {
                                aMapLocationServer2.e("mem");
                                aMapLocationServer2.setLocationType(2);
                                return aMapLocationServer2;
                            }
                        }
                        if (!z4) {
                            this.O00000oO = bwi.O00000o0();
                        } else {
                            this.O00000oO = 0;
                        }
                        if (this.O0000o0 != null || str3.equals(this.O0000o0)) {
                            if (this.O0000o0 == null) {
                                O00000Oo2 = bwi.O00000Oo();
                            } else {
                                this.O0000OOo = bwi.O00000Oo();
                                str2 = str3;
                                AMapLocationServer O000000o3 = (!z3 || z) ? null : O000000o(context, str2, sb, false);
                                if (!z || bwi.O000000o(O000000o3)) {
                                    z5 = false;
                                }
                                if (!z5) {
                                    if (!z3) {
                                        if (z) {
                                            return null;
                                        }
                                        this.O00000oO = 0;
                                        O000000o3.setLocationType(4);
                                        return O000000o3;
                                    }
                                }
                                return null;
                            }
                        } else if (bwi.O00000Oo() - this.O0000OOo < 3000) {
                            str2 = this.O0000o0;
                            if (!z3) {
                            }
                            if (!z) {
                            }
                            z5 = false;
                            if (!z5) {
                            }
                            return null;
                        } else {
                            O00000Oo2 = bwi.O00000Oo();
                        }
                        this.O0000OOo = O00000Oo2;
                        this.O0000o0 = str3;
                        str2 = str3;
                        if (!z3) {
                        }
                        if (!z) {
                        }
                        z5 = false;
                        if (!z5) {
                        }
                        return null;
                    }
                }
                z3 = false;
                if (aMapLocationServer2 != null) {
                }
                z4 = false;
                if (!z4) {
                }
                if (this.O0000o0 != null) {
                }
                if (this.O0000o0 == null) {
                }
            }
            z2 = false;
            if (aMapLocationServer2 != null) {
            }
            z3 = false;
            if (aMapLocationServer2 != null) {
            }
            z4 = false;
            if (!z4) {
            }
            if (this.O0000o0 != null) {
            }
            if (this.O0000o0 == null) {
            }
        } catch (Throwable unused) {
        }
    }

    public final void O000000o() {
        this.O0000Ooo = 0;
        if (!this.f13316O000000o.isEmpty()) {
            this.f13316O000000o.clear();
        }
        this.O00000Oo = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x021f A[EDGE_INSN: B:104:0x021f->B:70:0x021f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f0 A[Catch:{ Throwable -> 0x0245, all -> 0x0243 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0167 A[Catch:{ Throwable -> 0x0245, all -> 0x0243 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x022f A[LOOP:0: B:26:0x0096->B:71:0x022f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x026c  */
    public final void O000000o(Context context, String str) throws Exception {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        StringBuilder sb;
        Context context2 = context;
        String str2 = str;
        if (bvy.O0000o0O() && context2 != null) {
            Cursor cursor2 = null;
            int i = 0;
            try {
                sQLiteDatabase = context2.openOrCreateDatabase("hmdb", 0, null);
                try {
                    if (bwi.O000000o(sQLiteDatabase, "hist")) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SELECT feature, nb, loc FROM ");
                        sb2.append("hist");
                        sb2.append(this.O00000o0);
                        sb2.append(" WHERE time > ");
                        sb2.append(bwi.O00000Oo() - bvy.O0000o0());
                        if (str2 != null) {
                            sb2.append(" and feature = '");
                            sb2.append(str2 + "'");
                        }
                        sb2.append(" ORDER BY time ASC;");
                        cursor = sQLiteDatabase.rawQuery(sb2.toString(), null);
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.O0000o00 == null) {
                                this.O0000o00 = bvo.O000000o("MD5", bwt.O00000o0(context));
                            }
                            if (cursor != null && cursor.moveToFirst()) {
                                while (true) {
                                    String str3 = ",access";
                                    if (cursor.getString(i).startsWith("{")) {
                                        jSONObject2 = new JSONObject(cursor.getString(i));
                                        sb3.delete(i, sb3.length());
                                        if (!TextUtils.isEmpty(cursor.getString(1))) {
                                            str3 = cursor.getString(1);
                                        } else {
                                            if (bwi.O000000o(jSONObject2, "mmac")) {
                                                sb3.append("#");
                                                sb3.append(jSONObject2.getString("mmac"));
                                            }
                                            jSONObject = new JSONObject(cursor.getString(2));
                                            if (bwi.O000000o(jSONObject, "type")) {
                                                jSONObject.put("type", "new");
                                            }
                                        }
                                        sb3.append(str3);
                                        jSONObject = new JSONObject(cursor.getString(2));
                                        if (bwi.O000000o(jSONObject, "type")) {
                                        }
                                    } else {
                                        JSONObject jSONObject3 = new JSONObject(new String(bvo.O00000o(bwx.O00000Oo(cursor.getString(i)), this.O0000o00), "UTF-8"));
                                        sb3.delete(0, sb3.length());
                                        if (!TextUtils.isEmpty(cursor.getString(1))) {
                                            str3 = new String(bvo.O00000o(bwx.O00000Oo(cursor.getString(1)), this.O0000o00), "UTF-8");
                                        } else {
                                            if (bwi.O000000o(jSONObject3, "mmac")) {
                                                sb3.append("#");
                                                sb3.append(jSONObject3.getString("mmac"));
                                            }
                                            jSONObject = new JSONObject(new String(bvo.O00000o(bwx.O00000Oo(cursor.getString(2)), this.O0000o00), "UTF-8"));
                                            if (bwi.O000000o(jSONObject, "type")) {
                                                jSONObject.put("type", "new");
                                            }
                                            jSONObject2 = jSONObject3;
                                        }
                                        sb3.append(str3);
                                        jSONObject = new JSONObject(new String(bvo.O00000o(bwx.O00000Oo(cursor.getString(2)), this.O0000o00), "UTF-8"));
                                        if (bwi.O000000o(jSONObject, "type")) {
                                        }
                                        jSONObject2 = jSONObject3;
                                    }
                                    AMapLocationServer aMapLocationServer = new AMapLocationServer("");
                                    aMapLocationServer.b(jSONObject);
                                    if (bwi.O000000o(jSONObject2, "mmac")) {
                                        if (bwi.O000000o(jSONObject2, "cgi")) {
                                            String str4 = (jSONObject2.getString("cgi") + "#") + "network#";
                                            if (jSONObject2.getString("cgi").contains("#")) {
                                                sb = new StringBuilder();
                                                sb.append(str4);
                                                sb.append("cgiwifi");
                                            } else {
                                                sb = new StringBuilder();
                                                sb.append(str4);
                                                sb.append("wifi");
                                            }
                                            O000000o(sb.toString(), sb3, aMapLocationServer, context, false);
                                            if (cursor.moveToNext()) {
                                                break;
                                            }
                                            i = 0;
                                        }
                                    }
                                    if (bwi.O000000o(jSONObject2, "cgi")) {
                                        String str5 = (jSONObject2.getString("cgi") + "#") + "network#";
                                        if (jSONObject2.getString("cgi").contains("#")) {
                                            sb = new StringBuilder();
                                            sb.append(str5);
                                            sb.append("cgi");
                                            O000000o(sb.toString(), sb3, aMapLocationServer, context, false);
                                        }
                                    }
                                    if (cursor.moveToNext()) {
                                    }
                                }
                                sb3.delete(0, sb3.length());
                                sb2.delete(0, sb2.length());
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    } else if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bvz.O000000o(th, "DB", "fetchHist p2");
                    if (cursor2 != null) {
                    }
                    if (sQLiteDatabase == null) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
                cursor = null;
                if (cursor != null) {
                }
                sQLiteDatabase.close();
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e A[Catch:{ Throwable -> 0x01ad, Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ab A[Catch:{ Throwable -> 0x01ad, Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bd A[SYNTHETIC, Splitter:B:40:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0122 A[Catch:{ Throwable -> 0x01ad, Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x016d A[Catch:{ Throwable -> 0x01ad, Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x016f A[Catch:{ Throwable -> 0x01ad, Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0179 A[Catch:{ Throwable -> 0x01ad, Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x017c A[Catch:{ Throwable -> 0x01ad, Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x018c A[Catch:{ Throwable -> 0x01ad, Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0198 A[Catch:{ Throwable -> 0x01ad, Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01a7  */
    public final void O000000o(String str, StringBuilder sb, AMapLocationServer aMapLocationServer, Context context, boolean z) {
        boolean z2;
        JSONObject f;
        AMapLocationServer O000000o2;
        String sb2;
        StringBuilder sb3 = sb;
        AMapLocationServer aMapLocationServer2 = aMapLocationServer;
        try {
            if (bwi.O000000o(aMapLocationServer)) {
                String str2 = str + "&" + aMapLocationServer.isOffset() + "&" + aMapLocationServer.i() + "&" + aMapLocationServer.j();
                if (!TextUtils.isEmpty(str2)) {
                    if (bwi.O000000o(aMapLocationServer)) {
                        if (!str2.startsWith("#")) {
                            z2 = str2.contains("network");
                            if (z2 && !aMapLocationServer.e().equals("mem") && !aMapLocationServer.e().equals("file") && !aMapLocationServer.e().equals("wifioff") && !"-3".equals(aMapLocationServer.d())) {
                                if (O00000Oo()) {
                                    O000000o();
                                }
                                f = aMapLocationServer.f();
                                if (bwi.O000000o(f, "offpct")) {
                                    f.remove("offpct");
                                    aMapLocationServer2.a(f);
                                }
                                if (!str2.contains("wifi")) {
                                    if (!TextUtils.isEmpty(sb)) {
                                        if (aMapLocationServer.getAccuracy() >= 300.0f) {
                                            int i = 0;
                                            for (String contains : sb.toString().split("#")) {
                                                if (contains.contains(",")) {
                                                    i++;
                                                }
                                            }
                                            if (i >= 8) {
                                                return;
                                            }
                                        } else if (aMapLocationServer.getAccuracy() <= 3.0f) {
                                            return;
                                        }
                                        if (str2.contains("cgiwifi") && !TextUtils.isEmpty(aMapLocationServer.g())) {
                                            String replace = str2.replace("cgiwifi", "cgi");
                                            AMapLocationServer h = aMapLocationServer.h();
                                            if (bwi.O000000o(h)) {
                                                O000000o(replace, new StringBuilder(), h, context, true);
                                            }
                                        }
                                    } else {
                                        return;
                                    }
                                } else if (str2.contains("cgi") && (!(sb3 == null || sb3.indexOf(",") == -1) || "4".equals(aMapLocationServer.d()))) {
                                    return;
                                }
                                O000000o2 = O000000o(str2, sb3);
                                if (bwi.O000000o(O000000o2) || !O000000o2.toStr().equals(aMapLocationServer2.toStr(3))) {
                                    this.O0000Ooo = bwi.O00000o0();
                                    O000000o o000000o = new O000000o();
                                    o000000o.f13317O000000o = aMapLocationServer2;
                                    sb2 = !TextUtils.isEmpty(sb) ? null : sb.toString();
                                    if (!TextUtils.isEmpty(sb2)) {
                                        o000000o.O00000Oo = null;
                                    } else {
                                        o000000o.O00000Oo = sb2.replace("##", "#");
                                    }
                                    if (!this.f13316O000000o.containsKey(str2)) {
                                        this.f13316O000000o.get(str2).add(o000000o);
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(o000000o);
                                        this.f13316O000000o.put(str2, arrayList);
                                    }
                                    if (!z) {
                                        O000000o(str2, aMapLocationServer2, sb3, context);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    if (O00000Oo()) {
                    }
                    f = aMapLocationServer.f();
                    if (bwi.O000000o(f, "offpct")) {
                    }
                    if (!str2.contains("wifi")) {
                    }
                    O000000o2 = O000000o(str2, sb3);
                    if (bwi.O000000o(O000000o2)) {
                    }
                    this.O0000Ooo = bwi.O00000o0();
                    O000000o o000000o2 = new O000000o();
                    o000000o2.f13317O000000o = aMapLocationServer2;
                    if (!TextUtils.isEmpty(sb)) {
                    }
                    if (!TextUtils.isEmpty(sb2)) {
                    }
                    if (!this.f13316O000000o.containsKey(str2)) {
                    }
                    if (!z) {
                    }
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "Cache", "add");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058 A[Catch:{ Throwable -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067 A[Catch:{ Throwable -> 0x007f }] */
    private AMapLocationServer O000000o(String str, StringBuilder sb) {
        O000000o o000000o;
        AMapLocationServer aMapLocationServer;
        try {
            if (!str.contains("cgiwifi")) {
                if (!str.contains("wifi")) {
                    o000000o = (!str.contains("cgi") || !this.f13316O000000o.containsKey(str)) ? null : (O000000o) this.f13316O000000o.get(str).get(0);
                    if (o000000o != null && bwi.O000000o(o000000o.f13317O000000o)) {
                        aMapLocationServer = o000000o.f13317O000000o;
                        aMapLocationServer.e("mem");
                        aMapLocationServer.h(o000000o.O00000Oo);
                        if (!bvy.O00000Oo(aMapLocationServer.getTime())) {
                            if (bwi.O000000o(aMapLocationServer)) {
                                this.O00000oO = 0;
                            }
                            aMapLocationServer.setLocationType(4);
                            return aMapLocationServer;
                        } else if (this.f13316O000000o != null && this.f13316O000000o.containsKey(str)) {
                            this.f13316O000000o.get(str).remove(o000000o);
                        }
                    }
                    return null;
                }
            }
            o000000o = O000000o(sb, str);
            aMapLocationServer = o000000o.f13317O000000o;
            aMapLocationServer.e("mem");
            aMapLocationServer.h(o000000o.O00000Oo);
            if (!bvy.O00000Oo(aMapLocationServer.getTime())) {
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "Cache", "get1");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00df A[LOOP:1: B:34:0x00d7->B:36:0x00df, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7 A[LOOP:2: B:38:0x00f1->B:40:0x00f7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0166 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0141 A[SYNTHETIC] */
    private O000000o O000000o(StringBuilder sb, String str) {
        O000000o o000000o;
        O000000o o000000o2;
        boolean z;
        boolean z2;
        double[] dArr;
        double[] dArr2;
        Iterator it;
        int i;
        double[] O000000o2;
        String str2;
        String str3 = str;
        if (this.f13316O000000o.isEmpty() || TextUtils.isEmpty(sb)) {
            return null;
        }
        if (!this.f13316O000000o.containsKey(str3)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        ArrayList arrayList = this.f13316O000000o.get(str3);
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                o000000o = null;
                break;
            }
            o000000o2 = (O000000o) arrayList.get(size);
            if (!TextUtils.isEmpty(o000000o2.O00000Oo)) {
                String str4 = o000000o2.O00000Oo;
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(sb) && str4.contains(",access")) {
                    if (sb.indexOf(",access") != -1) {
                        String[] split = str4.split(",access");
                        String substring = split[0].contains("#") ? split[0].substring(split[0].lastIndexOf("#") + 1) : split[0];
                        if (!TextUtils.isEmpty(substring)) {
                            z = sb.toString().contains(substring + ",access");
                            if (z) {
                                z2 = false;
                            } else if (bwi.O000000o(o000000o2.O00000Oo, sb.toString())) {
                                break;
                            } else {
                                z2 = true;
                            }
                            O000000o(o000000o2.O00000Oo, hashtable);
                            O000000o(sb.toString(), hashtable2);
                            hashtable3.clear();
                            for (String put : hashtable.keySet()) {
                                hashtable3.put(put, "");
                            }
                            for (String put2 : hashtable2.keySet()) {
                                hashtable3.put(put2, "");
                            }
                            Set keySet = hashtable3.keySet();
                            dArr = new double[keySet.size()];
                            dArr2 = new double[keySet.size()];
                            it = keySet.iterator();
                            i = 0;
                            while (it != null && it.hasNext()) {
                                str2 = (String) it.next();
                                double d = 1.0d;
                                dArr[i] = !hashtable.containsKey(str2) ? 1.0d : 0.0d;
                                if (hashtable2.containsKey(str2)) {
                                    d = 0.0d;
                                }
                                dArr2[i] = d;
                                i++;
                            }
                            keySet.clear();
                            O000000o2 = O000000o(dArr, dArr2);
                            if (O000000o2[0] >= 0.800000011920929d) {
                                if (O000000o2[1] >= 0.618d) {
                                    if (z2 && O000000o2[0] >= 0.618d) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
                z = false;
                if (z) {
                }
                O000000o(o000000o2.O00000Oo, hashtable);
                O000000o(sb.toString(), hashtable2);
                hashtable3.clear();
                while (r10.hasNext()) {
                }
                while (r10.hasNext()) {
                }
                Set keySet2 = hashtable3.keySet();
                dArr = new double[keySet2.size()];
                dArr2 = new double[keySet2.size()];
                it = keySet2.iterator();
                i = 0;
                while (it != null) {
                    str2 = (String) it.next();
                    double d2 = 1.0d;
                    dArr[i] = !hashtable.containsKey(str2) ? 1.0d : 0.0d;
                    if (hashtable2.containsKey(str2)) {
                    }
                    dArr2[i] = d2;
                    i++;
                }
                keySet2.clear();
                O000000o2 = O000000o(dArr, dArr2);
                if (O000000o2[0] >= 0.800000011920929d || O000000o2[1] >= 0.618d) {
                    break;
                    break;
                }
            }
            size--;
        }
        o000000o = o000000o2;
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        return o000000o;
    }
}
