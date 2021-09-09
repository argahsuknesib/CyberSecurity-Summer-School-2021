package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

public final class zzfc extends zzhh {
    private final zzfd zzaig = new zzfd(this, getContext(), "google_app_measurement_local.db");
    private boolean zzaih;

    zzfc(zzgl zzgl) {
        super(zzgl);
    }

    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (this.zzaih) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzaig.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzaih = true;
        return null;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:78:0x0115 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:69:0x0102 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c9, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x012b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:9:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00da A[SYNTHETIC, Splitter:B:55:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012b A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 2 */
    private final boolean zza(int i, byte[] bArr) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        zzab();
        ? r3 = 0;
        if (this.zzaih) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 5;
        int i3 = 0;
        int i4 = 5;
        while (i3 < i2) {
            ? r8 = 0;
            try {
                sQLiteDatabase = getWritableDatabase();
                if (sQLiteDatabase == null) {
                    try {
                        this.zzaih = true;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return r3;
                    } catch (SQLiteFullException e) {
                        e = e;
                    } catch (SQLiteDatabaseLockedException unused) {
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor = null;
                        r8 = sQLiteDatabase;
                        if (r8 != 0) {
                        }
                        zzge().zzim().zzg("Error writing entry to local database", e);
                        this.zzaih = true;
                        if (cursor != null) {
                        }
                        if (r8 == 0) {
                        }
                        i3++;
                        r3 = 0;
                        i2 = 5;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                } else {
                    sQLiteDatabase.beginTransaction();
                    long j = 0;
                    cursor = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                j = cursor.getLong(r3);
                            }
                        } catch (SQLiteFullException e3) {
                            e = e3;
                            r8 = cursor;
                            zzge().zzim().zzg("Error writing entry to local database", e);
                            this.zzaih = true;
                            if (r8 != 0) {
                            }
                            if (sQLiteDatabase == null) {
                            }
                            sQLiteDatabase.close();
                            i3++;
                            r3 = 0;
                            i2 = 5;
                        } catch (SQLiteDatabaseLockedException unused2) {
                            r8 = cursor;
                            try {
                                SystemClock.sleep((long) i4);
                                i4 += 20;
                                if (r8 != 0) {
                                }
                                if (sQLiteDatabase == null) {
                                }
                                sQLiteDatabase.close();
                                i3++;
                                r3 = 0;
                                i2 = 5;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = r8;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e4) {
                            e = e4;
                            r8 = sQLiteDatabase;
                            if (r8 != 0) {
                            }
                            zzge().zzim().zzg("Error writing entry to local database", e);
                            this.zzaih = true;
                            if (cursor != null) {
                            }
                            if (r8 == 0) {
                            }
                            i3++;
                            r3 = 0;
                            i2 = 5;
                        } catch (Throwable th3) {
                            th = th3;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    }
                    if (j >= 100000) {
                        zzge().zzim().log("Data loss, local db full");
                        long j2 = (100000 - j) + 1;
                        String[] strArr = new String[1];
                        strArr[r3] = Long.toString(j2);
                        long delete = (long) sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                        if (delete != j2) {
                            zzge().zzim().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(delete), Long.valueOf(j2 - delete));
                        }
                    }
                    sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return true;
                    }
                    sQLiteDatabase.close();
                    return true;
                }
            } catch (SQLiteFullException e5) {
                e = e5;
                sQLiteDatabase = null;
                zzge().zzim().zzg("Error writing entry to local database", e);
                this.zzaih = true;
                if (r8 != 0) {
                    r8.close();
                }
                if (sQLiteDatabase == null) {
                    i3++;
                    r3 = 0;
                    i2 = 5;
                }
                sQLiteDatabase.close();
                i3++;
                r3 = 0;
                i2 = 5;
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabase = null;
                SystemClock.sleep((long) i4);
                i4 += 20;
                if (r8 != 0) {
                    r8.close();
                }
                if (sQLiteDatabase == null) {
                    i3++;
                    r3 = 0;
                    i2 = 5;
                }
                sQLiteDatabase.close();
                i3++;
                r3 = 0;
                i2 = 5;
            } catch (SQLiteException e6) {
                e = e6;
                cursor = null;
                if (r8 != 0) {
                    try {
                        if (r8.inTransaction()) {
                            r8.endTransaction();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        sQLiteDatabase = r8;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                }
                zzge().zzim().zzg("Error writing entry to local database", e);
                this.zzaih = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (r8 == 0) {
                    r8.close();
                }
                i3++;
                r3 = 0;
                i2 = 5;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase = null;
                cursor = null;
                if (cursor != null) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        }
        zzge().zzip().log("Failed to write entry to local database");
        return false;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final void resetAnalyticsData() {
        zzab();
        try {
            int delete = getWritableDatabase().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzge().zzit().zzg("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zzg("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zza(zzeu zzeu) {
        Parcel obtain = Parcel.obtain();
        zzeu.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzge().zzip().log("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzjx zzjx) {
        Parcel obtain = Parcel.obtain();
        zzjx.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzge().zzip().log("User property too long for local database. Sending directly to service");
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final boolean zzc(zzed zzed) {
        zzgb();
        byte[] zza = zzka.zza(zzed);
        if (zza.length <= 131072) {
            return zza(2, zza);
        }
        zzge().zzip().log("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        return super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        return super.zzgg();
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:57|58|59|60) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:72|73|74|75) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:42|43|44|45|158) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x016f, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        r10 = null;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        r10 = null;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        r10 = null;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        zzge().zzim().log("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r13.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        zzge().zzim().log("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r13.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        zzge().zzim().log("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r13.recycle();
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x009f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00d1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0102 */
    /* JADX WARNING: Removed duplicated region for block: B:102:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x017f A[SYNTHETIC, Splitter:B:113:0x017f] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01c8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01c8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01c8 A[SYNTHETIC] */
    public final List<AbstractSafeParcelable> zzp(int i) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Parcel obtain;
        Object obj;
        Parcel obtain2;
        Parcel obtain3;
        zzab();
        if (this.zzaih) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!getContext().getDatabasePath("google_app_measurement_local.db").exists()) {
            return arrayList;
        }
        int i2 = 5;
        int i3 = 0;
        int i4 = 5;
        while (i3 < i2) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    try {
                        this.zzaih = true;
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        return null;
                    } catch (SQLiteFullException e) {
                        e = e;
                        sQLiteDatabase = writableDatabase;
                        cursor = null;
                        zzge().zzim().zzg("Error reading entries from local database", e);
                        this.zzaih = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i3++;
                        i2 = 5;
                    } catch (SQLiteDatabaseLockedException unused) {
                    } catch (SQLiteException e2) {
                        e = e2;
                        sQLiteDatabase = writableDatabase;
                        cursor = null;
                        if (sQLiteDatabase != null) {
                        }
                        zzge().zzim().zzg("Error reading entries from local database", e);
                        this.zzaih = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i3++;
                        i2 = 5;
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase = writableDatabase;
                        cursor = null;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                } else {
                    writableDatabase.beginTransaction();
                    sQLiteDatabase = writableDatabase;
                    try {
                        cursor = writableDatabase.query("messages", new String[]{"rowid", "type", "entry"}, null, null, null, null, "rowid asc", Integer.toString(100));
                        long j = -1;
                        while (cursor.moveToNext()) {
                            try {
                                j = cursor.getLong(0);
                                int i5 = cursor.getInt(1);
                                byte[] blob = cursor.getBlob(2);
                                if (i5 == 0) {
                                    obtain3 = Parcel.obtain();
                                    obtain3.unmarshall(blob, 0, blob.length);
                                    obtain3.setDataPosition(0);
                                    obj = zzeu.CREATOR.createFromParcel(obtain3);
                                    obtain3.recycle();
                                    if (obj == null) {
                                    }
                                } else if (i5 == 1) {
                                    obtain2 = Parcel.obtain();
                                    obtain2.unmarshall(blob, 0, blob.length);
                                    obtain2.setDataPosition(0);
                                    obj = zzjx.CREATOR.createFromParcel(obtain2);
                                    obtain2.recycle();
                                    if (obj != null) {
                                    }
                                } else if (i5 == 2) {
                                    obtain = Parcel.obtain();
                                    obtain.unmarshall(blob, 0, blob.length);
                                    obtain.setDataPosition(0);
                                    Object obj2 = zzed.CREATOR.createFromParcel(obtain);
                                    obtain.recycle();
                                    if (obj != null) {
                                    }
                                } else {
                                    zzge().zzim().log("Unknown record type in local database");
                                }
                                arrayList.add(obj);
                            } catch (SQLiteFullException e3) {
                                e = e3;
                            } catch (SQLiteDatabaseLockedException unused2) {
                                SystemClock.sleep((long) i4);
                                i4 += 20;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase == null) {
                                }
                                sQLiteDatabase.close();
                                i3++;
                                i2 = 5;
                            } catch (SQLiteException e4) {
                                e = e4;
                                if (sQLiteDatabase != null) {
                                }
                                zzge().zzim().zzg("Error reading entries from local database", e);
                                this.zzaih = true;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase == null) {
                                }
                                sQLiteDatabase.close();
                                i3++;
                                i2 = 5;
                            } catch (Throwable th2) {
                                obtain3.recycle();
                                throw th2;
                            }
                        }
                        if (sQLiteDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                            zzge().zzim().log("Fewer entries removed from local database than expected");
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return arrayList;
                    } catch (SQLiteFullException e5) {
                        e = e5;
                        cursor = null;
                        zzge().zzim().zzg("Error reading entries from local database", e);
                        this.zzaih = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i3++;
                        i2 = 5;
                    } catch (SQLiteDatabaseLockedException unused3) {
                        cursor = null;
                        SystemClock.sleep((long) i4);
                        i4 += 20;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i3++;
                        i2 = 5;
                    } catch (SQLiteException e6) {
                        e = e6;
                        cursor = null;
                        if (sQLiteDatabase != null) {
                        }
                        zzge().zzim().zzg("Error reading entries from local database", e);
                        this.zzaih = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i3++;
                        i2 = 5;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = null;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteFullException e7) {
                e = e7;
                sQLiteDatabase = null;
                cursor = null;
                zzge().zzim().zzg("Error reading entries from local database", e);
                this.zzaih = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase == null) {
                    i3++;
                    i2 = 5;
                }
                sQLiteDatabase.close();
                i3++;
                i2 = 5;
            } catch (SQLiteDatabaseLockedException unused4) {
                sQLiteDatabase = null;
                cursor = null;
                SystemClock.sleep((long) i4);
                i4 += 20;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase == null) {
                    i3++;
                    i2 = 5;
                }
                sQLiteDatabase.close();
                i3++;
                i2 = 5;
            } catch (SQLiteException e8) {
                e = e8;
                sQLiteDatabase = null;
                cursor = null;
                if (sQLiteDatabase != null) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                }
                zzge().zzim().zzg("Error reading entries from local database", e);
                this.zzaih = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase == null) {
                    i3++;
                    i2 = 5;
                }
                sQLiteDatabase.close();
                i3++;
                i2 = 5;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase = null;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        zzge().zzip().log("Failed to read events from database in reasonable time");
        return null;
    }
}
