package _m_j;

import _m_j.qu;
import _m_j.qv;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Looper;
import com.amap.location.uptunnel.core.db.DBProvider;
import com.amap.openapi.dt;
import java.util.ArrayList;

public final class tn {

    /* renamed from: O000000o  reason: collision with root package name */
    String f2502O000000o = null;
    Uri O00000Oo;
    dt O00000o;
    DBProvider O00000o0;
    sz O00000oO;
    ox O00000oo;
    int O0000O0o;
    qu<O00000o0> O0000OOo;
    private qv O0000Oo;
    private String O0000Oo0 = "DataTunnel";

    static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        byte[] f2505O000000o;
        long O00000Oo;
        long O00000o0;

        O00000o() {
        }
    }

    static class O00000o0 implements qu.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2506O000000o;
        long O00000Oo;
        byte[] O00000o0;

        O00000o0() {
        }

        public final long O000000o() {
            byte[] bArr = this.O00000o0;
            return (long) ((bArr == null ? 0 : bArr.length) + 24);
        }
    }

    public final void O000000o() {
        this.O0000OOo.O000000o();
        this.O0000Oo.O000000o();
    }

    public final void O000000o(int i) {
        if (i != -1) {
            this.O0000Oo.O000000o(20000);
        }
    }

    public final void O000000o(int i, byte[] bArr) {
        O00000o0 o00000o0 = new O00000o0();
        o00000o0.f2506O000000o = i;
        o00000o0.O00000Oo = System.currentTimeMillis();
        o00000o0.O00000o0 = bArr;
        this.O0000OOo.O000000o(o00000o0);
    }

    public final void O000000o(dt dtVar, sz szVar, ox oxVar, int i, Looper looper) {
        this.f2502O000000o = dt.O00000o0(i);
        this.O0000Oo0 += this.f2502O000000o;
        this.O00000o = dtVar;
        this.O0000O0o = i;
        this.O00000oO = new tm(szVar);
        this.O00000oo = oxVar;
        this.O00000o0 = dtVar.O00000Oo();
        this.O00000Oo = dt.O00000Oo(i);
        this.O0000OOo = new qu<>();
        this.O0000Oo = new qv();
        this.O0000OOo.O000000o(new O000000o(), looper);
        this.O0000Oo.O000000o(dtVar.O000000o(), new O00000Oo(), looper);
        this.O0000Oo.O000000o(20000);
    }

    class O000000o implements qu.O00000Oo<O00000o0> {
        O000000o() {
        }

        public final void O000000o() {
        }

        public final long O00000Oo() {
            return tn.this.O00000oO.O00000Oo();
        }

        public final long O00000o0() {
            return tn.this.O00000oO.O00000o();
        }

        public final boolean O000000o(long j) {
            Cursor O000000o2 = tn.this.O00000o0.O000000o(tn.this.O00000Oo, new String[]{"sum(size)"}, null, null);
            if (O000000o2 != null) {
                try {
                    if (O000000o2.moveToFirst()) {
                        long j2 = O000000o2.getLong(0);
                        long j3 = j + j2;
                        if (j3 > tn.this.O00000oO.O00000oo()) {
                            return O000000o(j2, j3 - tn.this.O00000oO.O00000oo());
                        }
                        pd.O000000o(O000000o2);
                        return true;
                    }
                } catch (Exception unused) {
                    return false;
                } finally {
                    pd.O000000o(O000000o2);
                }
            }
            pd.O000000o(O000000o2);
            return false;
        }

        public final void O000000o(ArrayList<O00000o0> arrayList) {
            ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                O00000o0 o00000o0 = arrayList.get(i);
                ContentValues contentValues = new ContentValues();
                contentValues.put("type", Integer.valueOf(o00000o0.f2506O000000o));
                contentValues.put("time", Long.valueOf(o00000o0.O00000Oo));
                contentValues.put("size", Long.valueOf(o00000o0.O000000o()));
                contentValues.put("value", o00000o0.O00000o0);
                contentValuesArr[i] = contentValues;
            }
            tn.this.O00000o0.O000000o(tn.this.O00000Oo, contentValuesArr);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e4, code lost:
            _m_j.pd.O000000o(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e7, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e8, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e9, code lost:
            _m_j.pd.O000000o(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ec, code lost:
            throw r9;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00e8 A[ExcHandler:  FINALLY, Splitter:B:25:0x0097] */
        private boolean O000000o(long j, long j2) {
            if (tn.this.O00000o0.O000000o(tn.this.O00000Oo, "time < ?", new String[]{String.valueOf(System.currentTimeMillis() - tn.this.O00000oO.O0000O0o())}) > 0) {
                Cursor O000000o2 = tn.this.O00000o0.O000000o(tn.this.O00000Oo, new String[]{"sum(size)"}, null, null);
                if (O000000o2 != null) {
                    try {
                        if (O000000o2.moveToFirst()) {
                            j2 -= j - O000000o2.getLong(0);
                        }
                    } catch (Exception unused) {
                        return false;
                    } finally {
                        pd.O000000o(O000000o2);
                    }
                }
                pd.O000000o(O000000o2);
                return false;
            }
            SQLiteDatabase O00000o0 = tn.this.O00000o0.O00000o0();
            if (O00000o0 == null) {
                return false;
            }
            while (j2 > 0) {
                try {
                    Cursor rawQuery = O00000o0.rawQuery("select sum(size) from (select * from " + tn.this.f2502O000000o + " limit 0, " + tn.this.O00000oO.O000000o() + ")", null);
                    if (rawQuery != null) {
                        try {
                            if (rawQuery.moveToFirst()) {
                                long j3 = rawQuery.getLong(0);
                                if (j3 <= 0) {
                                    pd.O000000o(rawQuery);
                                    return false;
                                }
                                O00000o0.execSQL("delete from " + tn.this.f2502O000000o + " where ID < ( select ID from " + tn.this.f2502O000000o + " limit " + tn.this.O00000oO.O000000o() + ", 1)");
                                j2 -= j3;
                            }
                        } catch (Exception unused2) {
                            return false;
                        } finally {
                        }
                    }
                    pd.O000000o(rawQuery);
                } catch (Exception unused3) {
                }
                return false;
            }
            return true;
        }
    }

    class O00000Oo implements qv.O000000o {
        O00000Oo() {
        }

        public final void O000000o(int i) {
        }

        public final int O00000Oo() {
            return 3;
        }

        public final void O00000oO() {
        }

        public final boolean O00000Oo(int i) {
            return tn.this.O00000oO.O00000o0(i);
        }

        public final long O00000o0(int i) {
            return tn.this.O00000oO.O00000Oo(i) - tn.this.O00000o.O000000o(tn.this.O0000O0o, i);
        }

        public final void O000000o(int i, Object obj) {
            if (obj instanceof O00000o) {
                tn.this.O00000o.O000000o(tn.this.O0000O0o, i, ((O00000o) obj).O00000o0);
            }
        }

        public final long O000000o() {
            Cursor O000000o2 = tn.this.O00000o0.O000000o(tn.this.O00000Oo, new String[]{"sum(size)"}, null, null);
            long j = 0;
            if (O000000o2 != null) {
                try {
                    if (O000000o2.moveToFirst()) {
                        j = O000000o2.getLong(0);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    pd.O000000o(O000000o2);
                    throw th;
                }
            }
            pd.O000000o(O000000o2);
            return j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            _m_j.pd.O000000o(r4);
         */
        public final Object O000000o(long j) {
            long j2;
            long j3;
            O00000o o00000o = new O00000o();
            bwk bwk = new bwk();
            ArrayList arrayList = new ArrayList();
            long j4 = -1;
            long j5 = 0;
            long j6 = 0;
            while (true) {
                if (j5 >= j) {
                    break;
                }
                Cursor O000000o2 = tn.this.O00000o0.O000000o(tn.this.O00000Oo, td.f2492O000000o, null, "ID limit " + j6 + ", " + tn.this.O00000oO.O000000o());
                if (O000000o2 != null) {
                    try {
                        if (O000000o2.getCount() != 0) {
                            long O000000o3 = j6 + ((long) tn.this.O00000oO.O000000o());
                            while (true) {
                                try {
                                    if (!O000000o2.moveToNext()) {
                                        j2 = O000000o3;
                                        j3 = j4;
                                        break;
                                    }
                                    long j7 = O000000o2.getLong(0);
                                    int i = O000000o2.getInt(1);
                                    byte[] blob = O000000o2.getBlob(2);
                                    j2 = O000000o3;
                                    long j8 = O000000o2.getLong(3);
                                    j3 = j4;
                                    long j9 = ((long) O000000o2.getInt(4)) + j5;
                                    if (j9 > j) {
                                        break;
                                    }
                                    arrayList.add(Integer.valueOf(tg.O000000o(bwk, i, tg.O000000o(bwk, blob), j8)));
                                    j5 = j9;
                                    j4 = j7;
                                    O000000o3 = j2;
                                } catch (Exception unused) {
                                    pd.O000000o(O000000o2);
                                    return null;
                                } catch (Throwable th) {
                                    pd.O000000o(O000000o2);
                                    throw th;
                                }
                            }
                            pd.O000000o(O000000o2);
                            j6 = j2;
                            j4 = j3;
                        }
                    } catch (Exception unused2) {
                        pd.O000000o(O000000o2);
                    }
                }
                break;
            }
            if (j4 < 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            int O000000o4 = qw.O000000o(bwk, tn.this.O00000o.O000000o());
            int O00000Oo = th.O00000Oo(bwk, iArr);
            th.O000000o(bwk);
            th.O000000o(bwk, (byte) 1);
            th.O000000o(bwk, O000000o4);
            th.O00000o0(bwk, O00000Oo);
            th.O00000o(bwk, th.O00000Oo(bwk));
            o00000o.f2505O000000o = bwk.O00000o0();
            o00000o.O00000Oo = j4;
            o00000o.O00000o0 = j5;
            return o00000o;
        }

        public final boolean O000000o(Object obj) {
            if (obj instanceof O00000o) {
                return tj.O000000o(tn.this.O00000oo, tn.this.O00000o.O000000o(tn.this.O0000O0o), ((O00000o) obj).f2505O000000o, tn.this.O00000oO.O00000oO());
            }
            return false;
        }

        public final void O00000Oo(Object obj) {
            if (obj instanceof O00000o) {
                tn.this.O00000o0.O000000o(tn.this.O00000Oo, "ID <= ? ", new String[]{String.valueOf(((O00000o) obj).O00000Oo)});
            }
        }

        public final long O00000o(int i) {
            return tn.this.O00000oO.O000000o(i);
        }

        public final long O00000o0() {
            return tn.this.O00000oO.O00000o0();
        }

        public final int O00000o() {
            return tn.this.O00000oO.O00000oO();
        }
    }
}
