package com.amap.api.services.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.services.a.by;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cn {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f3372a = "FDF1F436161AEF5B".getBytes();
    public static byte[] b = "0102030405060708".getBytes();
    public static String c = "SOCRASH";
    private static HashSet<String> d = new HashSet<>();
    private static final String f = "SOCRASH";
    private File[] e;

    static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f3374a;
        /* access modifiers changed from: private */
        public String b;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0020 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b A[Catch:{ Throwable -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c A[Catch:{ Throwable -> 0x007e }] */
    public void a(Context context) {
        try {
            File[] b2 = b(context);
            if (b2 != null) {
                this.e = b2;
                by byVar = null;
                int i = 0;
                byVar = new by.a(f, "1.0", "").a(new String[0]).a();
                ArrayList arrayList = new ArrayList();
                while (i < b2.length && i < 10) {
                    File file = b2[i];
                    if (file != null && file.exists() && file.isFile()) {
                        byte[] b3 = b(file);
                        if (!(b3 == null || b3.length == 0)) {
                            if (b3.length > 100000) {
                                String a2 = bw.a(b3);
                                if (!a(arrayList, a2)) {
                                    if (!d.contains(a2)) {
                                        a(context, b3);
                                        d.add(a2);
                                        cm.a(byVar, context, f, bu.b(b3));
                                        a(file);
                                    }
                                }
                                file.delete();
                            }
                        }
                        file.delete();
                    }
                    i++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private File[] b(Context context) {
        File file = new File(cj.a(context));
        if (!file.isDirectory()) {
            return null;
        }
        return file.listFiles();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020 A[Catch:{ Throwable -> 0x006b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[Catch:{ Throwable -> 0x006b }] */
    private void a(Context context, byte[] bArr) {
        boolean z;
        List<a> b2;
        if (context != null) {
            try {
                String str = new String(bArr, "ISO-8859-1");
                if (str.indexOf("{\"") > 0) {
                    if (str.indexOf("\"}") > 0) {
                        z = true;
                        if (!z) {
                            JSONObject jSONObject = new JSONObject(str.substring(str.indexOf("{\""), str.lastIndexOf("\"}") + 2));
                            String optString = jSONObject.optString("ik");
                            String optString2 = jSONObject.optString("jk");
                            if (!TextUtils.isEmpty(optString2) && (b2 = a.b(optString)) != null) {
                                for (int i = 0; i < b2.size(); i++) {
                                    a aVar = b2.get(i);
                                    if (optString2.contains(aVar.e())) {
                                        a(context, aVar);
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                z = false;
                if (!z) {
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static String a() {
        return bw.a("SO_DYNAMIC_FILE_KEY");
    }

    private static void a(Context context, a aVar) throws JSONException {
        if (!TextUtils.isEmpty(aVar.b()) && !TextUtils.isEmpty(aVar.c()) && !TextUtils.isEmpty(aVar.d())) {
            int i = 0;
            SharedPreferences sharedPreferences = context.getSharedPreferences(a(), 0);
            JSONArray jSONArray = new JSONArray(bz.a(bn.b(bz.d(sharedPreferences.getString("SO_ERROR_KEY", "")))));
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!jSONObject.opt("mk").equals(aVar.a()) || !jSONObject.opt("ak").equals(aVar.b()) || !jSONObject.opt("bk").equals(aVar.c()) || !jSONObject.opt("ik").equals(aVar.d()) || !jSONObject.opt("nk").equals(aVar.e())) {
                    i++;
                } else {
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("mk", aVar.a());
            jSONObject2.putOpt("ak", aVar.b());
            jSONObject2.putOpt("bk", aVar.c());
            jSONObject2.putOpt("ik", aVar.d());
            jSONObject2.putOpt("nk", aVar.e());
            jSONArray.put(jSONObject2);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("SO_ERROR_KEY", bz.g(bn.a(bz.a(jSONArray.toString()))));
            edit.commit();
        }
    }

    private void a(File file) {
        if (file != null) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
    }

    private boolean a(List<b> list, String str) {
        if (list == null) {
            return false;
        }
        for (b next : list) {
            if (next.b.equals(str)) {
                int unused = next.f3374a = next.f3374a + 1;
                return true;
            }
        }
        return false;
    }

    private byte[] b(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            byte[] a2 = bu.a("a1f5886b7153004c5c99559f5261676f".getBytes(), bArr, "nFy1THrhajaZzz8U".getBytes());
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(a2.length - 16)];
            System.arraycopy(a2, 0, bArr2, 0, 16);
            System.arraycopy(a2, 16, bArr3, 0, a2.length - 16);
            return !a(bw.a(bArr3, "MD5"), bArr2) ? new byte[0] : bArr3;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0 || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f3373a;
        private String b;
        private String c;
        private String d;
        private String e;

        public a(String str, String str2, String str3, String str4, String str5) {
            this.f3373a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        public String a() {
            return this.f3373a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public a() {
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return new a();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.optString("mk", ""), jSONObject.optString("ak", ""), jSONObject.optString("bk", ""), jSONObject.optString("ik", ""), jSONObject.optString("nk", ""));
            } catch (Throwable unused) {
                return new a();
            }
        }

        public static List<a> b(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(a(jSONArray.getString(i)));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return arrayList;
        }
    }
}
