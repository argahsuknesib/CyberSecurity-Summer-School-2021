package _m_j;

import android.content.ContentValues;
import com.google.android.exoplayer2.C;
import java.util.HashMap;
import java.util.Map;

public final class bma {

    /* renamed from: O000000o  reason: collision with root package name */
    private blx f13085O000000o;

    public static class O000000o {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final bma f13086O000000o = new bma((byte) 0);
    }

    private bma() {
        if (blw.f13081O000000o != null) {
            this.f13085O000000o = new blx();
        }
    }

    /* synthetic */ bma(byte b) {
        this();
    }

    public final synchronized Map<String, String> O000000o() {
        HashMap hashMap = new HashMap();
        bly O000000o2 = this.f13085O000000o.O000000o();
        if (O000000o2 == null) {
            return hashMap;
        }
        hashMap.put("ex", O000000o2.f13083O000000o);
        hashMap.put("net", O000000o2.O00000o0);
        hashMap.put("t", O000000o2.O00000Oo);
        hashMap.put("url", O000000o2.O00000o);
        hashMap.put("dns", O000000o2.O00000oO);
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c1, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        _m_j.bmz.O000000o(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c7, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r0.f13082O000000o.O000000o().endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e8, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        _m_j.bmz.O000000o(r8);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:24:0x00b6, B:35:0x00ca, B:46:0x00de] */
    public final synchronized void O000000o(String str, String str2) {
        if (str2.contains("/v3/profile/android")) {
            str2 = "1";
        } else if (str2.contains("/v3/cloudconf")) {
            str2 = "2";
        }
        blx blx = this.f13085O000000o;
        String O0000O0o = bmo.O000000o().O0000O0o();
        bmr.O000000o();
        String O00000Oo = bmr.O00000Oo();
        try {
            blx.f13082O000000o.O000000o().beginTransaction();
            if (str.length() > 10000) {
                str = str.substring(0, C.MSG_CUSTOM_BASE);
            }
            if (str2.length() > 1000) {
                str2 = str.substring(0, 1000);
            }
            if (O0000O0o.length() > 100) {
                O0000O0o = O0000O0o.substring(0, 100);
            }
            if (O00000Oo.length() > 200) {
                O00000Oo = O0000O0o.substring(0, 200);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("ex", str);
            contentValues.put("net", O0000O0o);
            contentValues.put("url", str2);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            contentValues.put("t", sb.toString());
            contentValues.put("dns", O00000Oo);
            blx.f13082O000000o.O000000o("net_error_t", contentValues);
            blx.f13082O000000o.O000000o().delete("net_error_t", null, null);
            blx.f13082O000000o.O000000o().insert("net_error_t", null, contentValues);
            blx.f13082O000000o.O000000o().setTransactionSuccessful();
            blx.f13082O000000o.O000000o().endTransaction();
        } catch (Throwable th) {
            bmz.O000000o(th);
            return;
        }
        return;
        throw th;
    }
}
