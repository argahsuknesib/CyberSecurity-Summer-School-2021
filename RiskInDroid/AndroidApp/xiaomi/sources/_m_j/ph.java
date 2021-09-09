package _m_j;

import _m_j.rp;
import _m_j.sb;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import com.google.android.exoplayer2.C;

public class ph {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile ph f2382O000000o;
    private pg O00000Oo;
    private Context O00000o;
    private pi O00000o0;
    private ra O00000oO;
    private pj O00000oo;
    private rb O0000O0o;

    private ph() {
    }

    public static ph O000000o() {
        if (f2382O000000o == null) {
            synchronized (ph.class) {
                if (f2382O000000o == null) {
                    f2382O000000o = new ph();
                }
            }
        }
        return f2382O000000o;
    }

    public final synchronized op O000000o(os osVar, int i, boolean z, String str) {
        if (!O00000o0()) {
            return null;
        }
        if (this.O0000O0o == null) {
            sb.O000000o O000000o2 = this.O00000oo.O000000o(osVar, i, str);
            if (O000000o2.f2449O000000o) {
                return O000000o2.O00000Oo;
            }
            O00000o();
        }
        return this.O0000O0o.O000000o(osVar, i, z);
    }

    public final synchronized void O000000o(os osVar) {
        O000000o(osVar, 0, true, this.O00000o.getPackageName());
    }

    public final synchronized void O000000o(os osVar, op opVar) {
        O000000o(osVar, opVar, this.O00000o.getPackageName());
    }

    public final synchronized boolean O00000o0() {
        return (this.O00000oo == null || this.O00000Oo == null || !this.O00000Oo.O0000OoO || this.O00000o0 == null || !this.O00000o0.O000000o()) ? false : true;
    }

    public final synchronized void O000000o(Context context, pg pgVar, pf pfVar) {
        if (this.O00000Oo == null) {
            if (pgVar == null) {
                pgVar = new pg();
            }
            this.O00000Oo = pgVar;
        }
        if (this.O00000o0 == null) {
            this.O00000o0 = new pi();
            this.O00000o0.f2383O000000o = pfVar;
        }
        if (this.O00000oO == null) {
            this.O00000oO = new ra(context, this.O00000Oo, this.O00000o0);
            ra raVar = this.O00000oO;
            if (raVar.O00000Oo.O00000Oo == 4 && raVar.O00000Oo.O0000OoO && raVar.O00000o0.O000000o()) {
                raVar.O00000o = qm.O000000o();
                raVar.O00000o.O000000o(raVar.O00000oO);
                sm smVar = new sm();
                smVar.O00000Oo = raVar.O00000Oo.O00000Oo;
                smVar.O00000o0 = raVar.O00000Oo.O00000o;
                smVar.O00000oO = raVar.O00000Oo.O0000Oo0;
                smVar.O00000o = raVar.O00000Oo.O0000Oo;
                smVar.O000000o(raVar.O00000Oo.O0000OOo);
                smVar.O00000Oo(ol.O000000o());
                smVar.O0000O0o = raVar.O00000Oo.O0000o0;
                raVar.O00000o.O000000o(raVar.f2419O000000o, smVar);
            }
        }
        if (this.O00000oo == null) {
            this.O00000o = context.getApplicationContext();
            Context context2 = this.O00000o;
            pg pgVar2 = this.O00000Oo;
            pi piVar = this.O00000o0;
            if (pgVar2.O00000Oo == 4 && pgVar2.O0000OoO && piVar.O000000o()) {
                ok.O000000o((byte) 4);
                ok.O000000o(pgVar2.O00000o);
                ok.O00000o(pgVar2.O00000o0);
                ol.O000000o(pgVar2.O00000oO);
                ok.O00000o0(pgVar2.O0000Oo);
                ok.O00000Oo(pgVar2.O0000Oo0);
                st stVar = new st();
                stVar.O00000oo = pgVar2.O0000o0;
                stVar.O00000Oo = new sz(pgVar2) {
                    /* class _m_j.pl.AnonymousClass1 */

                    /* renamed from: O000000o */
                    final /* synthetic */ pg f2386O000000o;

                    {
                        this.f2386O000000o = r1;
                    }

                    public final int O000000o() {
                        return 10;
                    }

                    public final long O000000o(int i) {
                        if (this.f2386O000000o.O0000o0O != null) {
                            return this.f2386O000000o.O0000o0O.O00000oo;
                        }
                        return 1000;
                    }

                    public final long O00000Oo() {
                        if (this.f2386O000000o.O0000o0O != null) {
                            return this.f2386O000000o.O0000o0O.f2385O000000o;
                        }
                        return 100;
                    }

                    public final long O00000Oo(int i) {
                        if (this.f2386O000000o.O0000o0O != null) {
                            return this.f2386O000000o.O0000o0O.O0000O0o;
                        }
                        return 5000;
                    }

                    public final long O00000o() {
                        if (this.f2386O000000o.O0000o0O != null) {
                            return this.f2386O000000o.O0000o0O.O00000o;
                        }
                        return 60000;
                    }

                    public final long O00000o0() {
                        if (this.f2386O000000o.O0000o0O != null) {
                            return this.f2386O000000o.O0000o0O.O00000oO;
                        }
                        return 300000;
                    }

                    public final boolean O00000o0(int i) {
                        if (i == 1) {
                            return true;
                        }
                        if (i != 0 || this.f2386O000000o.O0000o0O == null) {
                            return false;
                        }
                        return this.f2386O000000o.O0000o0O.O0000OOo;
                    }

                    public final int O00000oO() {
                        return C.MSG_CUSTOM_BASE;
                    }

                    public final long O00000oo() {
                        if (this.f2386O000000o.O0000o0O != null) {
                            return this.f2386O000000o.O0000o0O.O00000Oo;
                        }
                        return 100000;
                    }

                    public final long O0000O0o() {
                        if (this.f2386O000000o.O0000o0O != null) {
                            return this.f2386O000000o.O0000o0O.O00000o0;
                        }
                        return 864000000;
                    }
                };
                stVar.f2481O000000o = new sy(pgVar2) {
                    /* class _m_j.pl.AnonymousClass2 */

                    /* renamed from: O000000o */
                    final /* synthetic */ pg f2387O000000o;

                    {
                        this.f2387O000000o = r1;
                    }

                    public final long O000000o() {
                        return 10;
                    }

                    public final long O000000o(int i) {
                        if (this.f2387O000000o.O0000o0O != null) {
                            return this.f2387O000000o.O0000o0O.O00000oo;
                        }
                        return 1000;
                    }

                    public final long O00000Oo() {
                        if (this.f2387O000000o.O0000o0O != null) {
                            return this.f2387O000000o.O0000o0O.f2385O000000o;
                        }
                        return 100;
                    }

                    public final long O00000Oo(int i) {
                        if (this.f2387O000000o.O0000o0O != null) {
                            return this.f2387O000000o.O0000o0O.O0000O0o;
                        }
                        return 5000;
                    }

                    public final long O00000o() {
                        if (this.f2387O000000o.O0000o0O != null) {
                            return this.f2387O000000o.O0000o0O.O00000o;
                        }
                        return 60000;
                    }

                    public final long O00000o0() {
                        if (this.f2387O000000o.O0000o0O != null) {
                            return this.f2387O000000o.O0000o0O.O00000oO;
                        }
                        return 300000;
                    }

                    public final boolean O00000o0(int i) {
                        if (i == 1) {
                            return true;
                        }
                        if (i != 0 || this.f2387O000000o.O0000o0O == null) {
                            return false;
                        }
                        return this.f2387O000000o.O0000o0O.O0000OOo;
                    }

                    public final int O00000oO() {
                        return C.MSG_CUSTOM_BASE;
                    }

                    public final long O00000oo() {
                        if (this.f2387O000000o.O0000o0O != null) {
                            return this.f2387O000000o.O0000o0O.O00000Oo;
                        }
                        return 100000;
                    }

                    public final long O0000O0o() {
                        if (this.f2387O000000o.O0000o0O != null) {
                            return this.f2387O000000o.O0000o0O.O00000o0;
                        }
                        return 864000000;
                    }
                };
                su.O000000o(context2, stVar);
            }
            this.O00000oo = new pj(context, this.O00000Oo, this.O00000o0);
            if (!this.O00000oo.O000000o(this.O00000o.getPackageName()) && this.O0000O0o == null) {
                O00000o();
            }
        }
    }

    public final synchronized void O00000Oo() {
        pg pgVar = this.O00000Oo;
        this.O00000Oo = null;
        this.O00000o0 = null;
        this.O00000oo = null;
        if (this.O00000oO != null) {
            ra raVar = this.O00000oO;
            if (raVar.O00000Oo.O00000Oo == 4 && raVar.O00000o != null) {
                raVar.O00000o.O00000Oo(raVar.O00000oO);
                raVar.O00000o.O00000Oo();
            }
            this.O00000oO = null;
        }
        if (this.O0000O0o != null) {
            rp rpVar = this.O0000O0o.O00000o0;
            rpVar.O00000o.writeLock().lock();
            try {
                rp.O000000o o000000o = rpVar.O00000o0;
                rpVar.O00000o0 = null;
                if (o000000o != null) {
                    o000000o.removeCallbacksAndMessages(null);
                    o000000o.sendEmptyMessage(4);
                }
                this.O0000O0o = null;
            } finally {
                rpVar.O00000o.writeLock().unlock();
            }
        }
        if (pgVar != null && pgVar.O00000Oo == 4) {
            su.O000000o();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0014 A[Catch:{ all -> 0x000f }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b A[Catch:{ all -> 0x000f }] */
    public final synchronized op O000000o(os osVar, boolean z) {
        int i;
        if (z) {
            try {
                if (this.O00000o0 != null) {
                    i = this.O00000o0.O00000oO();
                    if (!z) {
                        su.O000000o(100033);
                    } else {
                        su.O000000o(100034);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        i = 0;
        if (!z) {
        }
        return O000000o(osVar, i, false, this.O00000o.getPackageName());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, boolean):void
     arg types: [android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, int]
     candidates:
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, java.util.HashSet<java.lang.Long>, android.content.ContentValues):void
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, long, android.content.ContentValues):boolean
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, boolean):void */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0150, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0193, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0195, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0153 A[SYNTHETIC, Splitter:B:55:0x0153] */
    public final synchronized void O000000o(os osVar, op opVar, String str) {
        String str2;
        String str3;
        boolean z;
        op O000000o2;
        if (O00000o0()) {
            if (this.O0000O0o != null) {
                rb rbVar = this.O0000O0o;
                re O000000o3 = rbVar.O000000o(osVar.f2373O000000o);
                rg O000000o4 = rbVar.O000000o(osVar.O00000Oo);
                if (rc.O000000o(O000000o3, O000000o4, 0) != null) {
                    str2 = "@_18_1_@";
                    StringBuilder sb = new StringBuilder("@_18_1_2_@");
                    sb.append(om.O000000o(O000000o3.toString() + "," + O000000o4.toString() + ",(" + opVar.O00000Oo + "," + opVar.f2369O000000o + ")"));
                    str3 = sb.toString();
                } else {
                    str2 = "@_18_1_@";
                    str3 = "@_18_1_4_@" + O000000o3.f2423O000000o + "," + O000000o4.O00000o0 + "," + O000000o4.O00000o0;
                }
                om.O00000Oo(str2, str3);
                if (opVar != null) {
                    Context context = rbVar.f2422O000000o;
                    pg pgVar = rbVar.O00000Oo;
                    if (opVar != null) {
                        if (opVar.O00000o()) {
                            String str4 = opVar.O00000oo;
                            if (!"3".equals(str4) && !"4".equals(str4)) {
                                if (!"9".equals(str4)) {
                                    z = false;
                                    if (!z && O000000o3.O0000Oo0 != null) {
                                        op O000000o5 = rd.O000000o(pgVar, O000000o3.O0000Oo0);
                                        if (O000000o5 != null) {
                                            double O000000o6 = (double) pb.O000000o(opVar, O000000o5);
                                            if (O000000o6 > 300.0d) {
                                                om.O00000Oo("@_18_3_@", "@_18_3_1_@".concat(String.valueOf(O000000o6)));
                                                rk O000000o7 = rk.O000000o(context);
                                                long j = O000000o3.O0000O0o;
                                                String str5 = O000000o3.O00000oo;
                                                ContentValues contentValues = new ContentValues();
                                                try {
                                                    O000000o7.O000000o("CL", contentValues, j);
                                                    rk.O000000o(contentValues, j, str5, 0, 100000);
                                                    rk.O000000o(O000000o7.O00000Oo.getWritableDatabase(), "CL", contentValues, false);
                                                } catch (Throwable th) {
                                                    om.O00000Oo("@_18_4_@", "@_18_4_7_@" + Log.getStackTraceString(th));
                                                }
                                                su.O000000o(100038, "cellCorrect:".concat(String.valueOf(O000000o6)).getBytes());
                                            }
                                        }
                                    } else if (!z) {
                                        if (!(O000000o4.O00000oo == null || (O000000o2 = rd.O000000o(pgVar, O000000o4.O00000oo)) == null)) {
                                            double O000000o8 = (double) pb.O000000o(opVar, O000000o2);
                                            if (O000000o8 > 100.0d) {
                                                om.O00000Oo("@_18_3_@", "@_18_3_2_@".concat(String.valueOf(O000000o8)));
                                                rk.O000000o(context).O000000o(O000000o4, opVar);
                                                su.O000000o(100038, "wifiCorrect:".concat(String.valueOf(O000000o8)).getBytes());
                                            }
                                        }
                                    }
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                            if (!z) {
                            }
                        }
                    }
                }
            } else if (!this.O00000oo.O000000o(osVar, opVar, str)) {
                O00000o();
            }
        }
    }

    private void O00000o() {
        this.O0000O0o = new rb(this.O00000o, this.O00000Oo, this.O00000o0);
        this.O0000O0o.O00000o0.O000000o();
    }
}
