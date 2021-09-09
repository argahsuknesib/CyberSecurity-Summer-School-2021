package _m_j;

import _m_j.bmv;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;
import org.json.JSONObject;

public final class blp {

    /* renamed from: O000000o  reason: collision with root package name */
    blr f13064O000000o;
    public String O00000Oo;
    public bmv.O000000o O00000o;
    public String O00000o0;
    private Context O00000oO;

    public static class O000000o {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final blp f13066O000000o = new blp((byte) 0);
    }

    private blp() {
        this.O00000oO = null;
        this.O00000o = new bmv.O000000o() {
            /* class _m_j.blp.AnonymousClass1 */

            public final boolean O000000o(String str, int i) {
                super.O000000o(str, i);
                return false;
            }

            public final void O000000o(String str) {
                blr O000000o2 = blp.this.O000000o(str);
                if (O000000o2 != null) {
                    blp.this.f13064O000000o = O000000o2;
                }
            }
        };
        this.O00000oO = blw.f13081O000000o;
    }

    /* synthetic */ blp(byte b) {
        this();
    }

    public final synchronized blr O000000o() {
        if (this.f13064O000000o == null) {
            this.f13064O000000o = O00000Oo();
        }
        blr blr = this.f13064O000000o;
        if (blr == null) {
            return null;
        }
        blr blr2 = new blr();
        blr2.O0000Oo0 = blr.O0000Oo0;
        blr2.O0000OOo = blr.O0000OOo;
        blr2.O0000O0o = blr.O0000O0o;
        blr2.O00000Oo = blr.O00000Oo;
        blr2.O00000o0 = blr.O00000o0;
        blr2.O00000o = blr.O00000o;
        blr2.O00000oO = blr.O00000oO;
        blr2.O0000OoO = blr.O0000OoO;
        blr2.O0000Oo = blr.O0000Oo;
        blr2.f13070O000000o = blr.f13070O000000o;
        blr2.O0000Ooo = blr.O0000Ooo;
        blr2.O0000o0O = blr.O0000o0O;
        blr2.O0000o0o = blr.O0000o0o;
        blr2.O00000oo = blr.O00000oo;
        blr2.O0000o0 = blr.O0000o0;
        blr2.O0000o00 = blr.O0000o00;
        blr2.O0000o = blr.O0000o;
        blr2.O0000oO0 = blr.O0000oO0;
        blr2.O0000oO = blr.O0000oO;
        blr2.O0000oOO = blr.O0000oOO;
        blr2.O0000oOo = blr.O0000oOo;
        blr2.O0000oo0 = blr.O0000oo0;
        blr2.O0000oo = blr.O0000oo;
        return blr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ba, code lost:
        return r0;
     */
    private synchronized blr O00000Oo() {
        blr blr;
        blr blr2 = null;
        int i = 0;
        try {
            String string = this.O00000oO.getSharedPreferences("cloudms.conf", 0).getString("conf", null);
            bnd.O000000o(string);
            if (bnd.O000000o(string == null ? null : string.trim())) {
                blr = null;
            } else {
                JSONObject jSONObject = new JSONObject(string);
                blr = O000000o(jSONObject.getString("data"), jSONObject.getInt("length"), jSONObject.has("enc") ? jSONObject.getInt("enc") : 0, jSONObject.has("ver") ? jSONObject.getInt("ver") : 0);
                blr.O0000Oo0 = "local";
            }
            if (blr != null) {
                return blr;
            }
        } catch (Exception e) {
            bmz.O00000o("CloudConfiguration", "load local cloud conf failed: %s", Log.getStackTraceString(e));
        }
        try {
            JSONObject jSONObject2 = new JSONObject("{\"code\":0,\"data\":\"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\",\"enc\":1,\"length\":4323,\"ver\":1}");
            int i2 = jSONObject2.getInt("length");
            int i3 = jSONObject2.has("enc") ? jSONObject2.getInt("enc") : 0;
            if (jSONObject2.has("ver")) {
                i = jSONObject2.getInt("ver");
            }
            blr O000000o2 = O000000o(jSONObject2.getString("data"), i2, i3, i);
            O000000o2.O0000Oo0 = "code";
            if (O000000o2 != null) {
                return O000000o2;
            }
            blr2 = O000000o2;
            if (blr2 == null) {
                blr2 = new blr();
            }
        } catch (Exception unused) {
        }
    }

    private static blr O000000o(String str, int i, int i2, int i3) {
        String str2;
        int inflate;
        if (str == null) {
            return null;
        }
        try {
            byte[] O0000O0o = bne.O0000O0o(str);
            if (i2 == 1) {
                byte[] O00000Oo2 = bmx.O00000Oo("zaq1mko0", O0000O0o, i);
                byte[] bArr = new byte[4096];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(O00000Oo2.length);
                Inflater inflater = new Inflater();
                inflater.setInput(O00000Oo2, 0, O00000Oo2.length);
                while (!inflater.finished() && (inflate = inflater.inflate(bArr)) > 0) {
                    byteArrayOutputStream.write(bArr, 0, inflate);
                }
                inflater.end();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                str2 = new String(byteArray, 0, byteArray.length, "utf-8");
            } else {
                str2 = bmx.O000000o("zaq1mko0", O0000O0o, i);
            }
            return i3 == 1 ? blr.O000000o(str2) : blr.O00000Oo(str2);
        } catch (Exception e) {
            Log.e("lty", "e: " + Log.getStackTraceString(e));
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final blr O000000o(String str) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (1100 != jSONObject2.getInt("code") || (jSONObject = jSONObject2.getJSONObject("detail")) == null || jSONObject.getInt("code") != 0) {
                return null;
            }
            int i = jSONObject.getInt("length");
            int i2 = jSONObject.has("enc") ? jSONObject.getInt("enc") : 0;
            int i3 = jSONObject.has("ver") ? jSONObject.getInt("ver") : 0;
            String string = jSONObject.getString("data");
            blr O000000o2 = O000000o(string, i, i2, i3);
            O000000o2.O0000Oo0 = "cloud";
            HashMap hashMap = new HashMap();
            hashMap.put("data", string);
            hashMap.put("length", Integer.valueOf(i));
            hashMap.put("enc", Integer.valueOf(i2));
            hashMap.put("ver", Integer.valueOf(i3));
            Context context = this.O00000oO;
            String jSONObject3 = bne.O000000o((Map<?, ?>) hashMap).toString();
            SharedPreferences.Editor edit = context.getSharedPreferences("cloudms.conf", 0).edit();
            edit.putString("conf", jSONObject3);
            if (edit.commit()) {
                return O000000o2;
            }
            throw new IOException("editor commit failed");
        } catch (Exception unused) {
            return null;
        }
    }
}
