package _m_j;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;

public final class rb {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f2422O000000o;
    public pg O00000Oo;
    private O000000o O00000o = new O000000o((byte) 0);
    public rp O00000o0;
    private int O00000oO = 0;

    public rb(Context context, pg pgVar, pf pfVar) {
        this.f2422O000000o = context;
        this.O00000Oo = pgVar;
        this.O00000o0 = new rp(context, pgVar, pfVar);
    }

    public final re O000000o(or orVar) {
        String O000000o2 = sa.O000000o(orVar);
        return rk.O000000o(this.f2422O000000o).O000000o(O000000o2, sa.O000000o(O000000o2));
    }

    public final rg O000000o(ou ouVar) {
        rg rgVar = new rg();
        rk.O000000o(this.f2422O000000o).O000000o(O000000o(ouVar, rgVar), rgVar);
        return rgVar;
    }

    static class O000000o implements Comparator<ot> {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((ot) obj2).O00000o0 - ((ot) obj).O00000o0;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, boolean):void
     arg types: [android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, int]
     candidates:
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, java.util.HashSet<java.lang.Long>, android.content.ContentValues):void
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, long, android.content.ContentValues):boolean
      _m_j.rk.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0150 A[Catch:{ all -> 0x00fd, Throwable -> 0x0223 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015d A[Catch:{ all -> 0x00fd, Throwable -> 0x0223 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x015e A[Catch:{ all -> 0x00fd, Throwable -> 0x0223 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0163 A[Catch:{ all -> 0x00fd, Throwable -> 0x0223 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0181 A[SYNTHETIC, Splitter:B:64:0x0181] */
    public final op O000000o(os osVar, int i, boolean z) {
        op opVar;
        rk O000000o2;
        String str;
        String str2;
        int i2;
        Lock readLock;
        String str3;
        os osVar2 = osVar;
        int i3 = i;
        try {
            re O000000o3 = O000000o(osVar2.f2373O000000o);
            rg O000000o4 = O000000o(osVar2.O00000Oo);
            if (!z) {
                op O000000o5 = rc.O000000o(O000000o3, O000000o4, i3);
                if (O000000o5 != null) {
                    StringBuilder sb = new StringBuilder("@_18_1_1_@");
                    sb.append(om.O000000o(O000000o3.toString() + "," + O000000o4.toString() + "," + i3));
                    str3 = sb.toString();
                } else {
                    str3 = "@_18_1_3_@" + O000000o3.f2423O000000o + "," + O000000o4.f2425O000000o + "," + O000000o4.O00000o0;
                }
                om.O00000Oo("@_18_1_@", str3);
                opVar = O000000o5;
            } else {
                opVar = null;
            }
            O000000o2 = rk.O000000o(this.f2422O000000o);
            long j = O000000o3.O0000O0o;
            String str4 = O000000o3.O00000oo;
            if (!TextUtils.isEmpty(str4)) {
                ContentValues contentValues = new ContentValues();
                O000000o2.O00000o0.readLock().lock();
                try {
                    SQLiteDatabase writableDatabase = O000000o2.f2428O000000o.getWritableDatabase();
                    SQLiteDatabase writableDatabase2 = O000000o2.O00000Oo.getWritableDatabase();
                    if (O000000o3.f2423O000000o) {
                        SQLiteDatabase sQLiteDatabase = writableDatabase2;
                        if (O000000o3.O00000oO > 60) {
                            rk.O000000o(writableDatabase, "CL", j, contentValues);
                        }
                        if (O000000o3.O0000OOo) {
                            str = "|";
                            str2 = ",";
                            i2 = 1;
                            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                            try {
                                rk.O000000o(contentValues, j, str4, 0, 100000);
                                rk.O000000o(sQLiteDatabase2, "CL", contentValues, true);
                            } catch (Throwable th) {
                                th = th;
                                om.O00000Oo("@_18_4_@", "@_18_4_5_@" + Log.getStackTraceString(th));
                                readLock = O000000o2.O00000o0.readLock();
                                readLock.unlock();
                                rk.O000000o(this.f2422O000000o).O000000o(O000000o4);
                                ry.O000000o().O000000o(this.f2422O000000o, O000000o3);
                                this.O00000oO += i2;
                                if (this.O00000oO > 20) {
                                }
                                if (i3 <= 0) {
                                }
                                if (opVar != null) {
                                }
                                opVar = null;
                                if (opVar != null) {
                                }
                                return opVar;
                            }
                        } else {
                            str = "|";
                            str2 = ",";
                            i2 = 1;
                        }
                    } else {
                        str = "|";
                        str2 = ",";
                        SQLiteDatabase sQLiteDatabase3 = writableDatabase2;
                        i2 = 1;
                        rk.O000000o(contentValues, j, str4, 0, 0);
                        rk.O000000o(sQLiteDatabase3, "CL", contentValues, true);
                        rk.O000000o(sQLiteDatabase3, "CL", j, contentValues);
                    }
                    readLock = O000000o2.O00000o0.readLock();
                } catch (Throwable th2) {
                    th = th2;
                    str = "|";
                    str2 = ",";
                    i2 = 1;
                    om.O00000Oo("@_18_4_@", "@_18_4_5_@" + Log.getStackTraceString(th));
                    readLock = O000000o2.O00000o0.readLock();
                    readLock.unlock();
                    rk.O000000o(this.f2422O000000o).O000000o(O000000o4);
                    ry.O000000o().O000000o(this.f2422O000000o, O000000o3);
                    this.O00000oO += i2;
                    if (this.O00000oO > 20) {
                    }
                    if (i3 <= 0) {
                    }
                    if (opVar != null) {
                    }
                    opVar = null;
                    if (opVar != null) {
                    }
                    return opVar;
                }
                readLock.unlock();
            } else {
                str = "|";
                str2 = ",";
                i2 = 1;
            }
            rk.O000000o(this.f2422O000000o).O000000o(O000000o4);
            ry.O000000o().O000000o(this.f2422O000000o, O000000o3);
            this.O00000oO += i2;
            if (this.O00000oO > 20) {
                rk.O000000o(this.f2422O000000o).O00000Oo();
                this.O00000oO = 0;
            }
            if (i3 <= 0) {
                i2 = 0;
            }
            if (opVar != null) {
                if (i2 == 0 || !"file".equals(opVar.O00000oO)) {
                    if (i2 != 0) {
                        su.O000000o(100035);
                    } else {
                        su.O000000o(100036);
                    }
                    if (opVar != null) {
                        try {
                            if (this.O00000Oo.O0000o00 != null) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(opVar.O00000oO);
                                String str5 = str;
                                sb2.append(str5);
                                sb2.append(opVar.f2369O000000o);
                                String str6 = str2;
                                sb2.append(str6);
                                sb2.append(opVar.O00000Oo);
                                sb2.append(str6);
                                sb2.append(opVar.O00000o0);
                                sb2.append(str5);
                                if (opVar.O00000oO.equals("wifioff")) {
                                    sb2.append((CharSequence) O000000o4.O00000o);
                                    sb2.append("@");
                                    sb2.append((CharSequence) O000000o4.O00000oO);
                                    sb2.append("@");
                                    sb2.append(i3);
                                    sb2.append("@");
                                    sb2.append(O000000o4.f2425O000000o);
                                    if (O000000o3 != null) {
                                        sb2.append("@");
                                        sb2.append(O000000o3.O00000o0 + str6 + O000000o3.O00000Oo + str6 + O000000o3.O00000o);
                                    }
                                } else {
                                    sb2.append(O000000o3.O00000oo);
                                    sb2.append("@");
                                    sb2.append(O000000o3.O00000o0);
                                    sb2.append(str6);
                                    sb2.append(O000000o3.O00000Oo);
                                    sb2.append(str6);
                                    sb2.append(O000000o3.O00000o);
                                }
                                sb2.toString().getBytes();
                            }
                        } catch (Exception unused) {
                        }
                    }
                    return opVar;
                }
            }
            opVar = null;
            if (opVar != null) {
            }
            return opVar;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private String O000000o(ou ouVar, rg rgVar) {
        StringBuilder sb = new StringBuilder();
        if (ouVar != null && ouVar.O000000o() > 0) {
            List<ot> list = ouVar.O00000o0;
            Collections.sort(list, this.O00000o);
            int min = Math.min(list.size(), 30);
            rgVar.f2425O000000o = min;
            boolean z = true;
            for (int i = 0; i < min; i++) {
                ot otVar = list.get(i);
                long O000000o2 = sa.O000000o(otVar.f2374O000000o);
                if (O000000o2 != -1) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append(O000000o2);
                    rf rfVar = new rf();
                    rfVar.f2424O000000o = O000000o2;
                    rfVar.O00000Oo = otVar.f2374O000000o;
                    rfVar.O00000o0 = otVar.O00000o0;
                    rgVar.O00000Oo.put(Long.valueOf(O000000o2), rfVar);
                }
            }
        }
        return sb.toString();
    }
}
