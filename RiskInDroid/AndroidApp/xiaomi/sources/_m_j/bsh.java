package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bsh {

    /* renamed from: O000000o  reason: collision with root package name */
    static HashSet<String> f13236O000000o = new HashSet<>();
    public static byte[] O00000Oo = "FDF1F436161AEF5B".getBytes();
    public static String O00000o = "SOCRASH";
    public static byte[] O00000o0 = "0102030405060708".getBytes();
    static final String O00000oo = "SOCRASH";
    File[] O00000oO;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f13237O000000o;
        String O00000Oo;
        String O00000o;
        String O00000o0;
        String O00000oO;

        public O000000o() {
        }

        private O000000o(String str, String str2, String str3, String str4, String str5) {
            this.f13237O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
            this.O00000o = str4;
            this.O00000oO = str5;
        }

        public static List<O000000o> O000000o(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(O00000Oo(jSONArray.getString(i)));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return arrayList;
        }

        private static O000000o O00000Oo(String str) {
            if (TextUtils.isEmpty(str)) {
                return new O000000o();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new O000000o(jSONObject.optString("mk", ""), jSONObject.optString("ak", ""), jSONObject.optString("bk", ""), jSONObject.optString("ik", ""), jSONObject.optString("nk", ""));
            } catch (Throwable unused) {
                return new O000000o();
            }
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        int f13238O000000o;
        String O00000Oo;
    }

    private static boolean O000000o(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr.length != 16) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    static byte[] O000000o(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            byte[] O000000o2 = bwx.O000000o("a1f5886b7153004c5c99559f5261676f".getBytes(), bArr, "nFy1THrhajaZzz8U".getBytes());
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(O000000o2.length - 16)];
            System.arraycopy(O000000o2, 0, bArr2, 0, 16);
            System.arraycopy(O000000o2, 16, bArr3, 0, O000000o2.length - 16);
            return !O000000o(brp.O000000o(bArr3, "MD5"), bArr2) ? new byte[0] : bArr3;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020 A[Catch:{ Throwable -> 0x0066 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[Catch:{ Throwable -> 0x0066 }] */
    static void O000000o(Context context, byte[] bArr) {
        boolean z;
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
                            if (!TextUtils.isEmpty(optString2)) {
                                List<O000000o> O000000o2 = O000000o.O000000o(optString);
                                for (int i = 0; i < O000000o2.size(); i++) {
                                    O000000o o000000o = O000000o2.get(i);
                                    if (optString2.contains(o000000o.O00000oO)) {
                                        O000000o(context, o000000o);
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

    private static void O000000o(Context context, O000000o o000000o) throws JSONException {
        if (!TextUtils.isEmpty(o000000o.O00000Oo) && !TextUtils.isEmpty(o000000o.O00000o0) && !TextUtils.isEmpty(o000000o.O00000o)) {
            int i = 0;
            SharedPreferences sharedPreferences = context.getSharedPreferences(brp.O000000o("SO_DYNAMIC_FILE_KEY"), 0);
            JSONArray jSONArray = new JSONArray(brs.O000000o(brt.O00000Oo(brs.O00000oO(sharedPreferences.getString("SO_ERROR_KEY", "")))));
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!jSONObject.opt("mk").equals(o000000o.f13237O000000o) || !jSONObject.opt("ak").equals(o000000o.O00000Oo) || !jSONObject.opt("bk").equals(o000000o.O00000o0) || !jSONObject.opt("ik").equals(o000000o.O00000o) || !jSONObject.opt("nk").equals(o000000o.O00000oO)) {
                    i++;
                } else {
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("mk", o000000o.f13237O000000o);
            jSONObject2.putOpt("ak", o000000o.O00000Oo);
            jSONObject2.putOpt("bk", o000000o.O00000o0);
            jSONObject2.putOpt("ik", o000000o.O00000o);
            jSONObject2.putOpt("nk", o000000o.O00000oO);
            jSONArray.put(jSONObject2);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("SO_ERROR_KEY", brs.O0000O0o(brt.O000000o(brs.O000000o(jSONArray.toString()))));
            edit.commit();
        }
    }

    static boolean O000000o(List<O00000Oo> list, String str) {
        for (O00000Oo next : list) {
            if (next.O00000Oo.equals(str)) {
                next.f13238O000000o++;
                return true;
            }
        }
        return false;
    }
}
