package com.xiaomi.push;

import _m_j.elv;
import _m_j.est;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class bg implements elv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f6369O000000o = "content://com.vivo.vms.IdProvider/IdentifierId/";
    private static String O00000Oo = (f6369O000000o + "OAID");
    private static String O00000o = (f6369O000000o + "AAID_");
    private static String O00000o0 = (f6369O000000o + "VAID_");
    private static String O00000oO = (f6369O000000o + "OAIDSTATUS");
    private static String O00000oo = "persist.sys.identifierid.supported";
    private Context O0000O0o;

    public bg(Context context) {
        this.O0000O0o = context;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:10:0x002b */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r10 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        r10.close();
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r10 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Unknown variable types count: 1 */
    private String O000000o(String str) {
        Cursor cursor;
        ? r0 = 0;
        try {
            cursor = this.O0000O0o.getContentResolver().query(Uri.parse(str), null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        r0 = cursor.getString(cursor.getColumnIndex("value"));
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    Throwable th2 = th;
                    r0 = cursor;
                    th = th2;
                    if (r0 != 0) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    public static boolean O000000o(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f6369O000000o).getAuthority(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final boolean O000000o() {
        return "1".equals(est.O000000o(O00000oo, "0"));
    }

    public final String O00000Oo() {
        return null;
    }

    public final String O00000o() {
        return null;
    }

    public final String O00000o0() {
        return O000000o(O00000Oo);
    }

    public final String O00000oO() {
        return null;
    }
}
