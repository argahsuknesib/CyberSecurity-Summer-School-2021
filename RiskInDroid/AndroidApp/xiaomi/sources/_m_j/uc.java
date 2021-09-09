package _m_j;

import _m_j.qu;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Looper;
import com.amap.openapi.u;
import java.util.ArrayList;
import java.util.Locale;

public class uc {
    private static final String O00000oO = "uc";

    /* renamed from: O000000o  reason: collision with root package name */
    public Looper f2525O000000o;
    public qu<ub> O00000Oo = new qu<>();
    /* access modifiers changed from: package-private */
    public u O00000o;
    public O000000o O00000o0 = new O000000o(this, (byte) 0);

    public uc(Context context, Looper looper) {
        this.f2525O000000o = looper;
        this.O00000o = new u(context);
    }

    public final void O000000o(int i, byte[] bArr) {
        this.O00000Oo.O000000o(new ub(i, bArr));
    }

    class O000000o implements qu.O00000Oo<ub> {
        private O000000o() {
        }

        /* synthetic */ O000000o(uc ucVar, byte b) {
            this();
        }

        public final boolean O000000o(long j) {
            return uc.this.O00000o.O000000o(j);
        }

        public final long O00000Oo() {
            return 10240;
        }

        public final long O00000o0() {
            return 60000;
        }

        public final void O000000o() {
            u O000000o2 = uc.this.O00000o;
            try {
                if (O000000o2.f3562O000000o != null) {
                    O000000o2.f3562O000000o.close();
                    O000000o2.f3562O000000o = null;
                }
            } catch (Exception unused) {
            }
        }

        /* JADX WARN: Failed to insert an additional move for type inference into block B:23:? */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.database.sqlite.SQLiteStatement} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.database.sqlite.SQLiteDatabase} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.database.sqlite.SQLiteDatabase} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.database.sqlite.SQLiteDatabase} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.database.sqlite.SQLiteDatabase} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.database.sqlite.SQLiteDatabase} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00d9 A[SYNTHETIC, Splitter:B:28:0x00d9] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e0 A[SYNTHETIC, Splitter:B:32:0x00e0] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00e7 A[SYNTHETIC, Splitter:B:39:0x00e7] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00ee A[SYNTHETIC, Splitter:B:43:0x00ee] */
        /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
        public final void O000000o(ArrayList<ub> arrayList) {
            SQLiteDatabase sQLiteDatabase;
            if (arrayList != null && arrayList.size() != 0) {
                u O000000o2 = uc.this.O00000o;
                SQLiteStatement sQLiteStatement = null;
                try {
                    sQLiteDatabase = O000000o2.f3562O000000o.getWritableDatabase();
                    try {
                        sQLiteDatabase.beginTransaction();
                        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("INSERT INTO base(type,data,size,time) VALUES(?,?,?,?)");
                        long currentTimeMillis = System.currentTimeMillis();
                        long j = 0;
                        long j2 = 0;
                        int i = 0;
                        for (ub next : arrayList) {
                            long j3 = j;
                            compileStatement.bindLong(1, (long) next.f2524O000000o);
                            compileStatement.bindBlob(2, next.O00000Oo);
                            long O000000o3 = next.O000000o();
                            compileStatement.bindLong(3, O000000o3);
                            compileStatement.bindLong(4, currentTimeMillis);
                            compileStatement.executeInsert();
                            if (next.f2524O000000o == 0) {
                                i++;
                                j = j3 + O000000o3;
                            } else {
                                j2 += O000000o3;
                                j = j3;
                            }
                        }
                        long j4 = j;
                        sQLiteDatabase.setTransactionSuccessful();
                        O000000o2.O00000Oo += j4;
                        O000000o2.O00000o0 += j2;
                        om.O00000Oo("@_3_2_@", String.format(Locale.getDefault(), "@_3_2_3_@" + currentTimeMillis + ";@_3_2_4_@%d，%d;@_3_2_5_@%d，%d", Integer.valueOf(arrayList.size()), Long.valueOf(j4), Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(arrayList.size() - i)));
                        if (compileStatement != null) {
                            try {
                                compileStatement.close();
                            } catch (Throwable unused) {
                            }
                        }
                        if (sQLiteDatabase != 0) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Exception unused2) {
                            }
                        }
                    } catch (Exception unused3) {
                        if (sQLiteStatement != null) {
                        }
                        if (sQLiteDatabase == 0) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (sQLiteStatement != null) {
                        }
                        if (sQLiteDatabase != 0) {
                        }
                        throw th;
                    }
                } catch (Exception unused4) {
                    sQLiteDatabase = sQLiteStatement;
                    if (sQLiteStatement != null) {
                        try {
                            sQLiteStatement.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    if (sQLiteDatabase == 0) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception unused6) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = sQLiteStatement;
                    if (sQLiteStatement != null) {
                        try {
                            sQLiteStatement.close();
                        } catch (Throwable unused7) {
                        }
                    }
                    if (sQLiteDatabase != 0) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception unused8) {
                        }
                    }
                    throw th;
                }
            }
        }
    }
}
