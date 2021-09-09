package _m_j;

import _m_j.qu;
import _m_j.qv;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.SparseIntArray;
import com.amap.location.uptunnel.core.db.DBProvider;
import com.amap.openapi.dt;
import java.util.ArrayList;

public final class tl {

    /* renamed from: O000000o  reason: collision with root package name */
    Uri f2496O000000o;
    DBProvider O00000Oo;
    sy O00000o;
    dt O00000o0;
    ox O00000oO;
    int O00000oo;
    qv O0000O0o;
    qu O0000OOo;
    volatile long O0000Oo;
    SparseIntArray O0000Oo0 = new SparseIntArray();

    static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        byte[] f2499O000000o;
        long O00000Oo;
        long O00000o0;

        O00000o() {
        }
    }

    static class O00000o0 implements qu.O000000o {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O00000o0 f2500O000000o = new O00000o0();

        O00000o0() {
        }

        public final long O000000o() {
            return 1;
        }
    }

    class O000000o implements qu.O00000Oo<O00000o0> {
        O000000o() {
        }

        public final void O000000o() {
        }

        public final long O00000Oo() {
            return tl.this.O00000o.O00000Oo();
        }

        public final long O00000o0() {
            return tl.this.O00000o.O00000o();
        }

        public final boolean O000000o(long j) {
            try {
                long O000000o2 = (tl.this.O00000Oo.O000000o(tl.this.f2496O000000o) * 24) + (j * 24);
                if (O000000o2 > tl.this.O00000o.O00000oo()) {
                    return O00000Oo(O000000o2 - tl.this.O00000o.O00000oo());
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00f7 A[SYNTHETIC] */
        public final void O000000o(ArrayList<O00000o0> arrayList) {
            boolean z;
            int size = tl.this.O0000Oo0.size();
            char c = 0;
            int i = 0;
            while (i < size) {
                int keyAt = tl.this.O0000Oo0.keyAt(i);
                int valueAt = tl.this.O0000Oo0.valueAt(i);
                DBProvider dBProvider = tl.this.O00000Oo;
                Uri uri = tl.this.f2496O000000o;
                String[] strArr = te.f2493O000000o;
                boolean z2 = true;
                String[] strArr2 = new String[1];
                strArr2[c] = String.valueOf(keyAt);
                Cursor O00000Oo = dBProvider.O00000Oo(uri, strArr, "type = ? ", strArr2, "time DESC", "0, 1");
                if (O00000Oo != null) {
                    try {
                        if (O00000Oo.moveToFirst()) {
                            long currentTimeMillis = System.currentTimeMillis() - O00000Oo.getLong(O00000Oo.getColumnIndex("time"));
                            if (currentTimeMillis > 0 && currentTimeMillis < tl.this.O00000o.O000000o()) {
                                long j = O00000Oo.getLong(O00000Oo.getColumnIndex("ID"));
                                if (!(j <= tl.this.O0000Oo)) {
                                    int i2 = O00000Oo.getInt(O00000Oo.getColumnIndex("value"));
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("ID", Long.valueOf(j));
                                    contentValues.put("value", Integer.valueOf(i2 + valueAt));
                                    if (tl.this.O00000Oo.O000000o(tl.this.f2496O000000o, contentValues, "ID = ".concat(String.valueOf(j))) < 0) {
                                        z2 = false;
                                    }
                                    z = z2;
                                    pd.O000000o(O00000Oo);
                                    if (z) {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        ContentValues contentValues2 = new ContentValues();
                                        contentValues2.put("type", Integer.valueOf(keyAt));
                                        contentValues2.put("time", Long.valueOf(currentTimeMillis2));
                                        contentValues2.put("value", Integer.valueOf(valueAt));
                                        if (tl.this.O00000Oo.O000000o(tl.this.f2496O000000o, contentValues2) == -1) {
                                            break;
                                        }
                                    }
                                    i++;
                                    c = 0;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        pd.O000000o(O00000Oo);
                        z = false;
                    } catch (Throwable th) {
                        pd.O000000o(O00000Oo);
                        throw th;
                    }
                }
                z = false;
                pd.O000000o(O00000Oo);
                if (z) {
                }
                i++;
                c = 0;
            }
            tl.this.O0000Oo0.clear();
        }

        private boolean O00000Oo(long j) {
            boolean z = true;
            int O000000o2 = tl.this.O00000Oo.O000000o(tl.this.f2496O000000o, "time < ?", new String[]{String.valueOf(System.currentTimeMillis() - tl.this.O00000o.O0000O0o())});
            if (O000000o2 > 0) {
                j -= (long) (O000000o2 * 24);
            }
            long j2 = (j / 24) + ((long) (j % 24 > 0 ? 1 : 0));
            if (j2 <= 0) {
                return true;
            }
            try {
                Cursor O000000o3 = tl.this.O00000Oo.O000000o(tl.this.f2496O000000o, new String[]{"ID"}, null, null, null, (j2 - 1) + ", 1");
                if (O000000o3 != null) {
                    try {
                        if (O000000o3.moveToFirst()) {
                            if (tl.this.O00000Oo.O000000o(tl.this.f2496O000000o, "ID <= ?", new String[]{String.valueOf(O000000o3.getLong(0))}) <= 0) {
                                z = false;
                            }
                            return z;
                        }
                    } catch (Exception unused) {
                        return false;
                    } finally {
                        pd.O000000o(O000000o3);
                    }
                }
                pd.O000000o(O000000o3);
            } catch (Exception unused2) {
            }
            return false;
        }
    }

    class O00000Oo implements qv.O000000o {
        O00000Oo() {
        }

        public final int O00000Oo() {
            return 3;
        }

        public final void O00000oO() {
            tl.this.O0000Oo = -1;
        }

        public final boolean O00000Oo(int i) {
            return tl.this.O00000o.O00000o0(i);
        }

        public final long O00000o0(int i) {
            return tl.this.O00000o.O00000Oo(i) - tl.this.O00000o0.O000000o(tl.this.O00000oo, i);
        }

        public final void O000000o(int i, Object obj) {
            if (obj instanceof O00000o) {
                tl.this.O00000o0.O000000o(tl.this.O00000oo, i, ((O00000o) obj).O00000o0);
            }
        }

        public final long O000000o() {
            try {
                return tl.this.O00000Oo.O000000o(tl.this.f2496O000000o) * 24;
            } catch (Exception unused) {
                return 0;
            }
        }

        public final Object O000000o(long j) {
            O00000o o00000o = new O00000o();
            long j2 = j / 24;
            if (j2 <= 0) {
                return null;
            }
            Cursor O00000Oo = tl.this.O00000Oo.O00000Oo(tl.this.f2496O000000o, te.f2493O000000o, null, null, null, "0, ".concat(String.valueOf(j2)));
            if (O00000Oo != null) {
                try {
                    if (O00000Oo.getCount() > 0) {
                        bwk bwk = new bwk();
                        int O000000o2 = qw.O000000o(bwk, tl.this.O00000o0.O000000o());
                        int count = O00000Oo.getCount();
                        int[] iArr = new int[count];
                        long j3 = -1;
                        int i = 0;
                        while (O00000Oo.moveToNext()) {
                            j3 = O00000Oo.getLong(O00000Oo.getColumnIndex("ID"));
                            iArr[i] = tf.O000000o(bwk, O00000Oo.getInt(O00000Oo.getColumnIndex("type")), O00000Oo.getInt(O00000Oo.getColumnIndex("value")), O00000Oo.getLong(O00000Oo.getColumnIndex("time")));
                            i++;
                        }
                        int O000000o3 = th.O000000o(bwk, iArr);
                        th.O000000o(bwk);
                        th.O000000o(bwk, (byte) 0);
                        th.O000000o(bwk, O000000o2);
                        th.O00000Oo(bwk, O000000o3);
                        th.O00000o(bwk, th.O00000Oo(bwk));
                        o00000o.f2499O000000o = bwk.O00000o0();
                        o00000o.O00000Oo = j3;
                        o00000o.O00000o0 = (long) (count * 24);
                        tl.this.O0000Oo = j3;
                        pd.O000000o(O00000Oo);
                        return o00000o;
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    pd.O000000o(O00000Oo);
                    throw th;
                }
            }
            pd.O000000o(O00000Oo);
            return null;
        }

        public final boolean O000000o(Object obj) {
            if (obj instanceof O00000o) {
                return tj.O000000o(tl.this.O00000oO, tl.this.O00000o0.O000000o(tl.this.O00000oo), ((O00000o) obj).f2499O000000o, tl.this.O00000o.O00000oO());
            }
            return false;
        }

        public final void O00000Oo(Object obj) {
            if (obj instanceof O00000o) {
                tl.this.O00000Oo.O000000o(tl.this.f2496O000000o, "ID <= ? ", new String[]{String.valueOf(((O00000o) obj).O00000Oo)});
            }
        }

        public final long O00000o(int i) {
            return tl.this.O00000o.O000000o(i);
        }

        public final long O00000o0() {
            return tl.this.O00000o.O00000o0();
        }

        public final int O00000o() {
            return tl.this.O00000o.O00000oO();
        }

        public final void O000000o(int i) {
            tl.this.O0000Oo = -1;
        }
    }
}
