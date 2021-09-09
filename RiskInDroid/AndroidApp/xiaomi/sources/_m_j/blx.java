package _m_j;

import _m_j.bls;
import android.database.Cursor;
import com.ishumei.O000O00000OoO.O000O00000OoO.O0000O000000oO;

public final class blx {

    /* renamed from: O000000o  reason: collision with root package name */
    O0000O000000oO f13082O000000o = bls.O000000o.f13076O000000o.f13075O000000o;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055 A[SYNTHETIC, Splitter:B:21:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c A[SYNTHETIC, Splitter:B:27:0x005c] */
    public final bly O000000o() {
        Cursor cursor;
        bly bly = null;
        try {
            cursor = this.f13082O000000o.O000000o("net_error_t", "1");
            try {
                if (cursor.moveToNext()) {
                    bly bly2 = new bly();
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    String string4 = cursor.getString(3);
                    String string5 = cursor.getString(4);
                    bly2.O00000Oo = string;
                    bly2.f13083O000000o = string2;
                    bly2.O00000o0 = string3;
                    bly2.O00000o = string4;
                    bly2.O00000oO = string5;
                    this.f13082O000000o.O000000o().delete("net_error_t", null, null);
                    bly = bly2;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                    }
                }
                return bly;
            } catch (Throwable th) {
                th = th;
                try {
                    bmz.O000000o(th);
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
                try {
                    cursor.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }
}
