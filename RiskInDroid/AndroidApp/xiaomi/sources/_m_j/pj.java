package _m_j;

import _m_j.sb;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import java.util.LinkedList;
import java.util.List;

public final class pj {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f2384O000000o;
    private pf O00000Oo;
    private ProviderInfo O00000o;
    private List<String> O00000o0 = new LinkedList();
    private ContentValues O00000oO = new ContentValues();

    public pj(Context context, pg pgVar, pf pfVar) {
        this.f2384O000000o = context;
        this.O00000Oo = pfVar;
        O000000o(pgVar, pfVar);
    }

    private void O000000o() {
        this.O00000o = null;
        if (!this.O00000o0.isEmpty()) {
            this.O00000o0.remove(0);
        }
    }

    private void O000000o(pg pgVar, pf pfVar) {
        this.O00000o0.clear();
        int i = 0;
        if (pfVar != null && pfVar.O00000oo() != null) {
            String[] O00000oo = pfVar.O00000oo();
            int length = O00000oo.length;
            while (i < length) {
                this.O00000o0.add(O00000oo[i]);
                i++;
            }
        } else if (pgVar != null && pgVar.O0000Ooo != null) {
            String[] strArr = pgVar.O0000Ooo;
            int length2 = strArr.length;
            while (i < length2) {
                this.O00000o0.add(strArr[i]);
                i++;
            }
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:23:? */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [_m_j.sb$O000000o] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r1 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0032, code lost:
        if (r1 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e A[SYNTHETIC, Splitter:B:14:0x003e] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final sb.O000000o O000000o(os osVar, int i, String str) {
        ? r0;
        Cursor cursor;
        while (O000000o(str)) {
            r0 = 0;
            try {
                cursor = this.f2384O000000o.getContentResolver().query(Uri.parse("content://" + this.O00000o.authority), null, null, sb.O000000o(str, osVar, null, i), null);
                try {
                    sb.O000000o O000000o2 = sb.O000000o(cursor);
                    r0 = O000000o2;
                    r0 = O000000o2;
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    r0 = cursor;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (r0 != 0) {
                }
                throw th;
            }
        }
        return new sb.O000000o();
        if (r0 != 0 && r0.f2449O000000o) {
            return r0;
        }
        O000000o();
    }

    public final boolean O000000o(os osVar, op opVar, String str) {
        boolean z = false;
        if (!O000000o(str)) {
            return false;
        }
        try {
            if (this.f2384O000000o.getContentResolver().update(Uri.parse("content://" + this.O00000o.authority), this.O00000oO, null, sb.O000000o(str, osVar, opVar, 0)) == 1) {
                z = true;
            }
        } catch (Exception unused) {
        }
        if (z) {
            return true;
        }
        O000000o();
        return O000000o(str);
    }

    public final boolean O000000o(String str) {
        ProviderInfo providerInfo = this.O00000o;
        if (providerInfo != null) {
            if (str == null || !str.equals(providerInfo.packageName)) {
                return true;
            }
            O000000o();
        }
        while (!this.O00000o0.isEmpty()) {
            try {
                ProviderInfo resolveContentProvider = this.f2384O000000o.getPackageManager().resolveContentProvider(this.O00000o0.get(0), 0);
                if (resolveContentProvider != null && (str == null || !str.equals(resolveContentProvider.packageName))) {
                    this.O00000o = resolveContentProvider;
                    return true;
                }
            } catch (Exception unused) {
            }
            this.O00000o0.remove(0);
        }
        return false;
    }
}
