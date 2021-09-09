package com.google.android.gms.internal.measurement;

import _m_j.o0O0OOO0;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzei extends zzjq {
    /* access modifiers changed from: private */
    public static final String[] zzaev = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzaew = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzaex = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzaey = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzaez = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzafa = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzel zzafb = new zzel(this, getContext(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzjm zzafc = new zzjm(zzbt());

    zzei(zzjr zzjr) {
        super(zzjr);
    }

    private final long zza(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzge().zzim().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzge().zzim().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzge().zzim().log("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzge().zzim().zzg("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzge().zzim().log("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    static void zza(zzfg zzfg, SQLiteDatabase sQLiteDatabase) {
        if (zzfg != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                zzfg.zzip().log("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzfg.zzip().log("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzfg.zzip().log("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzfg.zzip().log("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    static void zza(zzfg zzfg, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (zzfg != null) {
            if (!zza(zzfg, sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            if (zzfg != null) {
                try {
                    Set<String> zzb = zzb(sQLiteDatabase, str);
                    String[] split = str3.split(",");
                    int length = split.length;
                    int i = 0;
                    while (i < length) {
                        String str4 = split[i];
                        if (zzb.remove(str4)) {
                            i++;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length());
                            sb.append("Table ");
                            sb.append(str);
                            sb.append(" is missing required column: ");
                            sb.append(str4);
                            throw new SQLiteException(sb.toString());
                        }
                    }
                    if (strArr != null) {
                        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                            if (!zzb.remove(strArr[i2])) {
                                sQLiteDatabase.execSQL(strArr[i2 + 1]);
                            }
                        }
                    }
                    if (!zzb.isEmpty()) {
                        zzfg.zzip().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", zzb));
                    }
                } catch (SQLiteException e) {
                    zzfg.zzim().zzg("Failed to verify columns on table that was just created", str);
                    throw e;
                }
            } else {
                throw new IllegalArgumentException("Monitor must not be null");
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    private static boolean zza(zzfg zzfg, SQLiteDatabase sQLiteDatabase, String str) {
        if (zzfg != null) {
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean moveToFirst = query.moveToFirst();
                if (query != null) {
                    query.close();
                }
                return moveToFirst;
            } catch (SQLiteException e) {
                zzfg.zzip().zze("Error querying for table", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    private final boolean zza(String str, int i, zzke zzke) {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzke);
        if (TextUtils.isEmpty(zzke.zzarq)) {
            zzge().zzip().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(str), Integer.valueOf(i), String.valueOf(zzke.zzarp));
            return false;
        }
        try {
            byte[] bArr = new byte[zzke.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzke.zza(zzb);
            zzb.zzve();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzke.zzarp);
            contentValues.put("event_name", zzke.zzarq);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert event filter (got -1). appId", zzfg.zzbm(str));
                return true;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing event filter. appId", zzfg.zzbm(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Configuration loss. Failed to serialize event filter. appId", zzfg.zzbm(str), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzkh zzkh) {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzkh);
        if (TextUtils.isEmpty(zzkh.zzasf)) {
            zzge().zzip().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(str), Integer.valueOf(i), String.valueOf(zzkh.zzarp));
            return false;
        }
        try {
            byte[] bArr = new byte[zzkh.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkh.zza(zzb);
            zzb.zzve();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzkh.zzarp);
            contentValues.put("property_name", zzkh.zzasf);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert property filter (got -1). appId", zzfg.zzbm(str));
                return false;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing property filter. appId", zzfg.zzbm(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Configuration loss. Failed to serialize property filter. appId", zzfg.zzbm(str), e2);
            return false;
        }
    }

    private final boolean zza(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzch();
        zzab();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            long zza = zza("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzgg().zzb(str, zzew.zzahn)));
            if (zza <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return writableDatabase.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e);
            return false;
        }
    }

    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private final boolean zzhv() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }

    public final void beginTransaction() {
        zzch();
        getWritableDatabase().beginTransaction();
    }

    public final void endTransaction() {
        zzch();
        getWritableDatabase().endTransaction();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final SQLiteDatabase getWritableDatabase() {
        zzab();
        try {
            return this.zzafb.getWritableDatabase();
        } catch (SQLiteException e) {
            zzge().zzip().zzg("Error opening database", e);
            throw e;
        }
    }

    public final void setTransactionSuccessful() {
        zzch();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final long zza(zzkq zzkq) throws IOException {
        long j;
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkq);
        Preconditions.checkNotEmpty(zzkq.zzti);
        try {
            byte[] bArr = new byte[zzkq.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkq.zza(zzb);
            zzb.zzve();
            zzka zzgb = zzgb();
            Preconditions.checkNotNull(bArr);
            zzgb.zzab();
            MessageDigest messageDigest = zzka.getMessageDigest("MD5");
            if (messageDigest == null) {
                zzgb.zzge().zzim().log("Failed to get MD5");
                j = 0;
            } else {
                j = zzka.zzc(messageDigest.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkq.zzti);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing raw event metadata. appId", zzfg.zzbm(zzkq.zzti), e);
                throw e;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Data loss. Failed to serialize event metadata. appId", zzfg.zzbm(zzkq.zzti), e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008f  */
    public final Pair<zzkn, Long> zza(String str, Long l) {
        Cursor cursor;
        zzab();
        zzch();
        try {
            cursor = getWritableDatabase().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
            try {
                if (!cursor.moveToFirst()) {
                    zzge().zzit().log("Main event not found");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                byte[] blob = cursor.getBlob(0);
                Long valueOf = Long.valueOf(cursor.getLong(1));
                zzabv zza = zzabv.zza(blob, 0, blob.length);
                zzkn zzkn = new zzkn();
                try {
                    zzkn.zzb(zza);
                    Pair<zzkn, Long> create = Pair.create(zzkn, valueOf);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return create;
                } catch (IOException e) {
                    zzge().zzim().zzd("Failed to merge main event. appId, eventId", zzfg.zzbm(str), l, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zzg("Error selecting main event", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzge().zzim().zzg("Error selecting main event", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzej zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        String[] strArr = {str};
        zzej zzej = new zzej();
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            cursor = writableDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            if (!cursor.moveToFirst()) {
                zzge().zzip().zzg("Not updating daily counts, app is not known. appId", zzfg.zzbm(str));
                if (cursor != null) {
                    cursor.close();
                }
                return zzej;
            }
            if (cursor.getLong(0) == j) {
                zzej.zzafe = cursor.getLong(1);
                zzej.zzafd = cursor.getLong(2);
                zzej.zzaff = cursor.getLong(3);
                zzej.zzafg = cursor.getLong(4);
                zzej.zzafh = cursor.getLong(5);
            }
            if (z) {
                zzej.zzafe++;
            }
            if (z2) {
                zzej.zzafd++;
            }
            if (z3) {
                zzej.zzaff++;
            }
            if (z4) {
                zzej.zzafg++;
            }
            if (z5) {
                zzej.zzafh++;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzej.zzafd));
            contentValues.put("daily_events_count", Long.valueOf(zzej.zzafe));
            contentValues.put("daily_conversions_count", Long.valueOf(zzej.zzaff));
            contentValues.put("daily_error_events_count", Long.valueOf(zzej.zzafg));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzej.zzafh));
            writableDatabase.update("apps", contentValues, "app_id=?", strArr);
            if (cursor != null) {
                cursor.close();
            }
            return zzej;
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error updating daily counts. appId", zzfg.zzbm(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return zzej;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zza(zzdy zzdy) {
        Preconditions.checkNotNull(zzdy);
        zzab();
        zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzdy.zzah());
        contentValues.put("app_instance_id", zzdy.getAppInstanceId());
        contentValues.put("gmp_app_id", zzdy.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzdy.zzgi());
        contentValues.put("last_bundle_index", Long.valueOf(zzdy.zzgq()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzdy.zzgk()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzdy.zzgl()));
        contentValues.put("app_version", zzdy.zzag());
        contentValues.put("app_store", zzdy.zzgn());
        contentValues.put("gmp_version", Long.valueOf(zzdy.zzgo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzdy.zzgp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzdy.isMeasurementEnabled()));
        contentValues.put("day", Long.valueOf(zzdy.zzgu()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzdy.zzgv()));
        contentValues.put("daily_events_count", Long.valueOf(zzdy.zzgw()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzdy.zzgx()));
        contentValues.put("config_fetched_time", Long.valueOf(zzdy.zzgr()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzdy.zzgs()));
        contentValues.put("app_version_int", Long.valueOf(zzdy.zzgm()));
        contentValues.put("firebase_instance_id", zzdy.zzgj());
        contentValues.put("daily_error_events_count", Long.valueOf(zzdy.zzgz()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzdy.zzgy()));
        contentValues.put("health_monitor_sample", zzdy.zzha());
        contentValues.put("android_id", Long.valueOf(zzdy.zzhc()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzdy.zzhd()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzdy.zzhe()));
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{zzdy.zzah()})) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update app (got -1). appId", zzfg.zzbm(zzdy.zzah()));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing app. appId", zzfg.zzbm(zzdy.zzah()), e);
        }
    }

    public final void zza(zzeq zzeq) {
        Preconditions.checkNotNull(zzeq);
        zzab();
        zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzeq.zzti);
        contentValues.put("name", zzeq.name);
        contentValues.put("lifetime_count", Long.valueOf(zzeq.zzafr));
        contentValues.put("current_bundle_count", Long.valueOf(zzeq.zzafs));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzeq.zzaft));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzeq.zzafu));
        contentValues.put("last_sampled_complex_event_id", zzeq.zzafv);
        contentValues.put("last_sampling_rate", zzeq.zzafw);
        contentValues.put("last_exempt_from_sampling", (zzeq.zzafx == null || !zzeq.zzafx.booleanValue()) ? null : 1L);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update event aggregates (got -1). appId", zzfg.zzbm(zzeq.zzti));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing event aggregates. appId", zzfg.zzbm(zzeq.zzti), e);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0094, code lost:
        r9.zze(r12, r13, r10);
     */
    public final void zza(String str, zzkd[] zzkdArr) {
        boolean z;
        zzfi zzip;
        String str2;
        Object zzbm;
        Integer num;
        String str3 = str;
        zzkd[] zzkdArr2 = zzkdArr;
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzkdArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzch();
            zzab();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            writableDatabase2.delete("property_filters", "app_id=?", new String[]{str3});
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str3});
            for (zzkd zzkd : zzkdArr2) {
                zzch();
                zzab();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzkd);
                Preconditions.checkNotNull(zzkd.zzarn);
                Preconditions.checkNotNull(zzkd.zzarm);
                if (zzkd.zzarl == null) {
                    zzge().zzip().zzg("Audience with no ID. appId", zzfg.zzbm(str));
                } else {
                    int intValue = zzkd.zzarl.intValue();
                    zzke[] zzkeArr = zzkd.zzarn;
                    int length = zzkeArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            zzkh[] zzkhArr = zzkd.zzarm;
                            int length2 = zzkhArr.length;
                            int i2 = 0;
                            while (i2 < length2) {
                                if (zzkhArr[i2].zzarp == null) {
                                    zzip = zzge().zzip();
                                    str2 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
                                    zzbm = zzfg.zzbm(str);
                                    num = zzkd.zzarl;
                                } else {
                                    i2++;
                                }
                            }
                            zzke[] zzkeArr2 = zzkd.zzarn;
                            int length3 = zzkeArr2.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length3) {
                                    z = true;
                                    break;
                                } else if (!zza(str3, intValue, zzkeArr2[i3])) {
                                    z = false;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            if (z) {
                                zzkh[] zzkhArr2 = zzkd.zzarm;
                                int length4 = zzkhArr2.length;
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= length4) {
                                        break;
                                    } else if (!zza(str3, intValue, zzkhArr2[i4])) {
                                        z = false;
                                        break;
                                    } else {
                                        i4++;
                                    }
                                }
                            }
                            if (!z) {
                                zzch();
                                zzab();
                                Preconditions.checkNotEmpty(str);
                                SQLiteDatabase writableDatabase3 = getWritableDatabase();
                                writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str3, String.valueOf(intValue)});
                                writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str3, String.valueOf(intValue)});
                            }
                        } else if (zzkeArr[i].zzarp == null) {
                            zzip = zzge().zzip();
                            str2 = "Event filter with no ID. Audience definition ignored. appId, audienceId";
                            zzbm = zzfg.zzbm(str);
                            num = zzkd.zzarl;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzkd zzkd2 : zzkdArr2) {
                arrayList.add(zzkd2.zzarl);
            }
            zza(str3, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final boolean zza(zzed zzed) {
        Preconditions.checkNotNull(zzed);
        zzab();
        zzch();
        if (zzh(zzed.packageName, zzed.zzaep.name) == null) {
            if (zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzed.packageName}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzed.packageName);
        contentValues.put("origin", zzed.origin);
        contentValues.put("name", zzed.zzaep.name);
        zza(contentValues, "value", zzed.zzaep.getValue());
        contentValues.put("active", Boolean.valueOf(zzed.active));
        contentValues.put("trigger_event_name", zzed.triggerEventName);
        contentValues.put("trigger_timeout", Long.valueOf(zzed.triggerTimeout));
        zzgb();
        contentValues.put("timed_out_event", zzka.zza(zzed.zzaeq));
        contentValues.put("creation_timestamp", Long.valueOf(zzed.creationTimestamp));
        zzgb();
        contentValues.put("triggered_event", zzka.zza(zzed.zzaer));
        contentValues.put("triggered_timestamp", Long.valueOf(zzed.zzaep.zzaqz));
        contentValues.put("time_to_live", Long.valueOf(zzed.timeToLive));
        zzgb();
        contentValues.put("expired_event", zzka.zza(zzed.zzaes));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update conditional user property (got -1)", zzfg.zzbm(zzed.packageName));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing conditional user property", zzfg.zzbm(zzed.packageName), e);
        }
        return true;
    }

    public final boolean zza(zzep zzep, long j, boolean z) {
        zzfi zzim;
        Object zzbm;
        String str;
        zzab();
        zzch();
        Preconditions.checkNotNull(zzep);
        Preconditions.checkNotEmpty(zzep.zzti);
        zzkn zzkn = new zzkn();
        zzkn.zzatc = Long.valueOf(zzep.zzafp);
        zzkn.zzata = new zzko[zzep.zzafq.size()];
        Iterator<String> it = zzep.zzafq.iterator();
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            zzko zzko = new zzko();
            int i2 = i + 1;
            zzkn.zzata[i] = zzko;
            zzko.name = next;
            zzgb().zza(zzko, zzep.zzafq.get(next));
            i = i2;
        }
        try {
            byte[] bArr = new byte[zzkn.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkn.zza(zzb);
            zzb.zzve();
            zzge().zzit().zze("Saving event, name, data size", zzga().zzbj(zzep.name), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzep.zzti);
            contentValues.put("name", zzep.name);
            contentValues.put("timestamp", Long.valueOf(zzep.timestamp));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert raw event (got -1). appId", zzfg.zzbm(zzep.zzti));
                return false;
            } catch (SQLiteException e) {
                e = e;
                zzim = zzge().zzim();
                zzbm = zzfg.zzbm(zzep.zzti);
                str = "Error storing raw event. appId";
                zzim.zze(str, zzbm, e);
                return false;
            }
        } catch (IOException e2) {
            e = e2;
            zzim = zzge().zzim();
            zzbm = zzfg.zzbm(zzep.zzti);
            str = "Data loss. Failed to serialize event params/data. appId";
            zzim.zze(str, zzbm, e);
            return false;
        }
    }

    public final boolean zza(zzjz zzjz) {
        Preconditions.checkNotNull(zzjz);
        zzab();
        zzch();
        if (zzh(zzjz.zzti, zzjz.name) == null) {
            if (zzka.zzcc(zzjz.name)) {
                if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzjz.zzti}) >= 25) {
                    return false;
                }
            } else {
                if (zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzjz.zzti, zzjz.origin}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjz.zzti);
        contentValues.put("origin", zzjz.origin);
        contentValues.put("name", zzjz.name);
        contentValues.put("set_timestamp", Long.valueOf(zzjz.zzaqz));
        zza(contentValues, "value", zzjz.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update user property (got -1). appId", zzfg.zzbm(zzjz.zzti));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing user property. appId", zzfg.zzbm(zzjz.zzti), e);
        }
        return true;
    }

    public final boolean zza(zzkq zzkq, boolean z) {
        zzfi zzim;
        Object zzbm;
        String str;
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkq);
        Preconditions.checkNotEmpty(zzkq.zzti);
        Preconditions.checkNotNull(zzkq.zzatm);
        zzhp();
        long currentTimeMillis = zzbt().currentTimeMillis();
        if (zzkq.zzatm.longValue() < currentTimeMillis - zzef.zzhh() || zzkq.zzatm.longValue() > zzef.zzhh() + currentTimeMillis) {
            zzge().zzip().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfg.zzbm(zzkq.zzti), Long.valueOf(currentTimeMillis), zzkq.zzatm);
        }
        try {
            byte[] bArr = new byte[zzkq.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkq.zza(zzb);
            zzb.zzve();
            byte[] zza = zzgb().zza(bArr);
            zzge().zzit().zzg("Saving bundle, size", Integer.valueOf(zza.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkq.zzti);
            contentValues.put("bundle_end_timestamp", zzkq.zzatm);
            contentValues.put("data", zza);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzkq.zzauj != null) {
                contentValues.put("retry_count", zzkq.zzauj);
            }
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert bundle (got -1). appId", zzfg.zzbm(zzkq.zzti));
                return false;
            } catch (SQLiteException e) {
                e = e;
                zzim = zzge().zzim();
                zzbm = zzfg.zzbm(zzkq.zzti);
                str = "Error storing bundle. appId";
                zzim.zze(str, zzbm, e);
                return false;
            }
        } catch (IOException e2) {
            e = e2;
            zzim = zzge().zzim();
            zzbm = zzfg.zzbm(zzkq.zzti);
            str = "Data loss. Failed to serialize bundle. appId";
            zzim.zze(str, zzbm, e);
            return false;
        }
    }

    public final boolean zza(String str, Long l, long j, zzkn zzkn) {
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkn);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        try {
            byte[] bArr = new byte[zzkn.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkn.zza(zzb);
            zzb.zzve();
            zzge().zzit().zze("Saving complex main event, appId, data size", zzga().zzbj(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert complex main event (got -1). appId", zzfg.zzbm(str));
                return false;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing complex main event. appId", zzfg.zzbm(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzfg.zzbm(str), l, e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    public final String zzab(long j) {
        Cursor cursor;
        zzab();
        zzch();
        try {
            cursor = getWritableDatabase().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (!cursor.moveToFirst()) {
                    zzge().zzit().log("No expired configs for apps with pending events");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                if (cursor != null) {
                    cursor.close();
                }
                return string;
            } catch (SQLiteException e) {
                e = e;
                try {
                    zzge().zzim().zzg("Error selecting expired configs", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
            zzge().zzim().zzg("Error selecting expired configs", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c3 A[LOOP:0: B:18:0x0054->B:42:0x00c3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c5 A[EDGE_INSN: B:56:0x00c5->B:43:0x00c5 ?: BREAK  , SYNTHETIC] */
    public final List<Pair<zzkq, Long>> zzb(String str, int i, int i2) {
        zzfi zzim;
        String str2;
        Object zzbm;
        zzab();
        zzch();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            if (!cursor.moveToFirst()) {
                List<Pair<zzkq, Long>> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            do {
                long j = cursor.getLong(0);
                try {
                    byte[] zzb = zzgb().zzb(cursor.getBlob(1));
                    if (!arrayList.isEmpty() && zzb.length + i3 > i2) {
                        break;
                    }
                    zzabv zza = zzabv.zza(zzb, 0, zzb.length);
                    zzkq zzkq = new zzkq();
                    try {
                        zzkq.zzb(zza);
                        if (!cursor.isNull(2)) {
                            zzkq.zzauj = Integer.valueOf(cursor.getInt(2));
                        }
                        i3 += zzb.length;
                        arrayList.add(Pair.create(zzkq, Long.valueOf(j)));
                    } catch (IOException e) {
                        e = e;
                        zzim = zzge().zzim();
                        str2 = "Failed to merge queued bundle. appId";
                        zzbm = zzfg.zzbm(str);
                        zzim.zze(str2, zzbm, e);
                        if (!cursor.moveToNext()) {
                        }
                        if (cursor != null) {
                        }
                        return arrayList;
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    e = e2;
                    zzim = zzge().zzim();
                    str2 = "Failed to unzip queued bundle. appId";
                    zzbm = zzfg.zzbm(str);
                    zzim.zze(str2, zzbm, e);
                    if (!cursor.moveToNext()) {
                    }
                    if (cursor != null) {
                    }
                    return arrayList;
                }
            } while (i3 <= i2);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzge().zzim().zze("Error querying bundles. appId", zzfg.zzbm(str), e3);
            List<Pair<zzkq, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0100, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0104, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0100 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0127  */
    public final List<zzjz> zzb(String str, String str2, String str3) {
        Cursor cursor;
        String str4;
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            ArrayList arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder sb = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                str4 = str2;
                arrayList2.add(str4);
                sb.append(" and origin=?");
            } else {
                str4 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                sb.append(" and name glob ?");
            }
            cursor = getWritableDatabase().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                while (true) {
                    if (arrayList.size() >= 1000) {
                        zzge().zzim().zzg("Read more than the max allowed user properties, ignoring excess", 1000);
                        break;
                    }
                    String string = cursor.getString(0);
                    long j = cursor.getLong(1);
                    try {
                        Object zza = zza(cursor, 2);
                        String string2 = cursor.getString(3);
                        if (zza == null) {
                            try {
                                zzge().zzim().zzd("(2)Read invalid user property value, ignoring it", zzfg.zzbm(str), string2, str3);
                            } catch (SQLiteException e) {
                                e = e;
                                str4 = string2;
                                try {
                                    zzge().zzim().zzd("(2)Error querying user properties", zzfg.zzbm(str), str4, e);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            String str5 = str3;
                            arrayList.add(new zzjz(str, string2, string, j, zza));
                        }
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        str4 = string2;
                    } catch (SQLiteException e2) {
                        e = e2;
                        zzge().zzim().zzd("(2)Error querying user properties", zzfg.zzbm(str), str4, e);
                        if (cursor != null) {
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                e = e3;
                zzge().zzim().zzd("(2)Error querying user properties", zzfg.zzbm(str), str4, e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            str4 = str2;
            cursor = null;
            zzge().zzim().zzd("(2)Error querying user properties", zzfg.zzbm(str), str4, e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th3) {
        }
    }

    public final List<zzed> zzb(String str, String[] strArr) {
        zzab();
        zzch();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza = zza(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    long j2 = cursor.getLong(8);
                    long j3 = cursor.getLong(10);
                    boolean z2 = z;
                    zzed zzed = r3;
                    zzed zzed2 = new zzed(string, string2, new zzjx(string3, j3, zza, string2), j2, z2, string4, (zzeu) zzgb().zza(cursor.getBlob(7), zzeu.CREATOR), j, (zzeu) zzgb().zza(cursor.getBlob(9), zzeu.CREATOR), cursor.getLong(11), (zzeu) zzgb().zza(cursor.getBlob(12), zzeu.CREATOR));
                    arrayList.add(zzed);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzge().zzim().zzg("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzge().zzim().zzg("Error querying conditional user property value", e);
            List<zzed> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a1  */
    public final List<zzjz> zzbb(String str) {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        ArrayList arrayList = new ArrayList();
        try {
            cursor = getWritableDatabase().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = cursor.getLong(2);
                    Object zza = zza(cursor, 3);
                    if (zza == null) {
                        zzge().zzim().zzg("Read invalid user property value, ignoring it. appId", zzfg.zzbm(str));
                    } else {
                        arrayList.add(new zzjz(str, str2, string, j, zza));
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                e = e;
                try {
                    zzge().zzim().zze("Error querying user properties. appId", zzfg.zzbm(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
            zzge().zzim().zze("Error querying user properties. appId", zzfg.zzbm(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0113 A[Catch:{ SQLiteException -> 0x019d }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0117 A[Catch:{ SQLiteException -> 0x019d }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x014b A[Catch:{ SQLiteException -> 0x019d }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x014e A[Catch:{ SQLiteException -> 0x019d }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x015d A[Catch:{ SQLiteException -> 0x019d }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0172 A[Catch:{ SQLiteException -> 0x019d }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0186 A[Catch:{ SQLiteException -> 0x019d }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ca  */
    public final zzdy zzbc(String str) {
        Cursor cursor;
        boolean z;
        boolean z2;
        String str2 = str;
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        try {
            boolean z3 = true;
            cursor = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled"}, "app_id=?", new String[]{str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    zzdy zzdy = new zzdy(this.zzajp.zzla(), str2);
                    zzdy.zzal(cursor.getString(0));
                    zzdy.zzam(cursor.getString(1));
                    zzdy.zzan(cursor.getString(2));
                    zzdy.zzr(cursor.getLong(3));
                    zzdy.zzm(cursor.getLong(4));
                    zzdy.zzn(cursor.getLong(5));
                    zzdy.setAppVersion(cursor.getString(6));
                    zzdy.zzap(cursor.getString(7));
                    zzdy.zzp(cursor.getLong(8));
                    zzdy.zzq(cursor.getLong(9));
                    if (!cursor.isNull(10)) {
                        if (cursor.getInt(10) == 0) {
                            z = false;
                            zzdy.setMeasurementEnabled(z);
                            zzdy.zzu(cursor.getLong(11));
                            zzdy.zzv(cursor.getLong(12));
                            zzdy.zzw(cursor.getLong(13));
                            zzdy.zzx(cursor.getLong(14));
                            zzdy.zzs(cursor.getLong(15));
                            zzdy.zzt(cursor.getLong(16));
                            zzdy.zzo(!cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                            zzdy.zzao(cursor.getString(18));
                            zzdy.zzz(cursor.getLong(19));
                            zzdy.zzy(cursor.getLong(20));
                            zzdy.zzaq(cursor.getString(21));
                            zzdy.zzaa(!cursor.isNull(22) ? 0 : cursor.getLong(22));
                            if (!cursor.isNull(23)) {
                                if (cursor.getInt(23) == 0) {
                                    z2 = false;
                                    zzdy.zzd(z2);
                                    if (!cursor.isNull(24)) {
                                        if (cursor.getInt(24) == 0) {
                                            z3 = false;
                                        }
                                    }
                                    zzdy.zze(z3);
                                    zzdy.zzgh();
                                    if (cursor.moveToNext()) {
                                        zzge().zzim().zzg("Got multiple records for app, expected one. appId", zzfg.zzbm(str));
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return zzdy;
                                }
                            }
                            z2 = true;
                            zzdy.zzd(z2);
                            if (!cursor.isNull(24)) {
                            }
                            zzdy.zze(z3);
                            zzdy.zzgh();
                            if (cursor.moveToNext()) {
                            }
                            if (cursor != null) {
                            }
                            return zzdy;
                        }
                    }
                    z = true;
                    zzdy.setMeasurementEnabled(z);
                    zzdy.zzu(cursor.getLong(11));
                    zzdy.zzv(cursor.getLong(12));
                    zzdy.zzw(cursor.getLong(13));
                    zzdy.zzx(cursor.getLong(14));
                    zzdy.zzs(cursor.getLong(15));
                    zzdy.zzt(cursor.getLong(16));
                    zzdy.zzo(!cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                    zzdy.zzao(cursor.getString(18));
                    zzdy.zzz(cursor.getLong(19));
                    zzdy.zzy(cursor.getLong(20));
                    zzdy.zzaq(cursor.getString(21));
                    zzdy.zzaa(!cursor.isNull(22) ? 0 : cursor.getLong(22));
                    if (!cursor.isNull(23)) {
                    }
                    z2 = true;
                    zzdy.zzd(z2);
                    if (!cursor.isNull(24)) {
                    }
                    zzdy.zze(z3);
                    zzdy.zzgh();
                    if (cursor.moveToNext()) {
                    }
                    if (cursor != null) {
                    }
                    return zzdy;
                } catch (SQLiteException e) {
                    e = e;
                    try {
                        zzge().zzim().zze("Error querying app. appId", zzfg.zzbm(str), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                zzge().zzim().zze("Error querying app. appId", zzfg.zzbm(str), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzge().zzim().zze("Error querying app. appId", zzfg.zzbm(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zzbd(String str) {
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        try {
            return (long) getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzgg().zzb(str, zzew.zzagx))))});
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error deleting over the limit events. appId", zzfg.zzbm(str), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    public final byte[] zzbe(String str) {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        try {
            cursor = getWritableDatabase().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                byte[] blob = cursor.getBlob(0);
                if (cursor.moveToNext()) {
                    zzge().zzim().zzg("Got multiple records for app config, expected one. appId", zzfg.zzbm(str));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return blob;
            } catch (SQLiteException e) {
                e = e;
                try {
                    zzge().zzim().zze("Error querying remote config. appId", zzfg.zzbm(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
            zzge().zzim().zze("Error querying remote config. appId", zzfg.zzbm(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0098  */
    public final Map<Integer, zzkr> zzbf(String str) {
        Cursor cursor;
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        try {
            cursor = getWritableDatabase().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
                do {
                    int i = cursor.getInt(0);
                    byte[] blob = cursor.getBlob(1);
                    zzabv zza = zzabv.zza(blob, 0, blob.length);
                    zzkr zzkr = new zzkr();
                    try {
                        zzkr.zzb(zza);
                        o0o0ooo0.put(Integer.valueOf(i), zzkr);
                    } catch (IOException e) {
                        zzge().zzim().zzd("Failed to merge filter results. appId, audienceId, error", zzfg.zzbm(str), Integer.valueOf(i), e);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return o0o0ooo0;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zze("Database error querying filter results. appId", zzfg.zzbm(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzge().zzim().zze("Database error querying filter results. appId", zzfg.zzbm(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public final long zzbg(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final List<zzed> zzc(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzb(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzc(List<Long> list) {
        zzab();
        zzch();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzhv()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zza(sb3.toString(), (String[]) null) > 0) {
                zzge().zzip().log("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                writableDatabase.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzge().zzim().zzg("Error incrementing retry count. error", e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0105  */
    public final zzeq zzf(String str, String str2) {
        Cursor cursor;
        Boolean bool;
        String str3 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            boolean z = false;
            Cursor query = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (!query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                long j = query.getLong(0);
                long j2 = query.getLong(1);
                long j3 = query.getLong(2);
                long j4 = query.isNull(3) ? 0 : query.getLong(3);
                Long valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                Long valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                if (!query.isNull(6)) {
                    if (query.getLong(6) == 1) {
                        z = true;
                    }
                    bool = Boolean.valueOf(z);
                } else {
                    bool = null;
                }
                long j5 = j4;
                cursor = query;
                try {
                    zzeq zzeq = new zzeq(str, str2, j, j2, j3, j5, valueOf, valueOf2, bool);
                    if (cursor.moveToNext()) {
                        zzge().zzim().zzg("Got multiple records for event aggregates, expected one. appId", zzfg.zzbm(str));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzeq;
                } catch (SQLiteException e) {
                    e = e;
                    try {
                        zzge().zzim().zzd("Error querying events. appId", zzfg.zzbm(str), zzga().zzbj(str3), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                zzge().zzim().zzd("Error querying events. appId", zzfg.zzbm(str), zzga().zzbj(str3), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzge().zzim().zzd("Error querying events. appId", zzfg.zzbm(str), zzga().zzbj(str3), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public final void zzg(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            zzge().zzit().zzg("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzge().zzim().zzd("Error deleting user attribute. appId", zzfg.zzbm(str), zzga().zzbl(str2), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a9  */
    public final zzjz zzh(String str, String str2) {
        Cursor cursor;
        String str3 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            cursor = getWritableDatabase().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    zzjz zzjz = new zzjz(str, cursor.getString(2), str2, cursor.getLong(0), zza(cursor, 1));
                    if (cursor.moveToNext()) {
                        zzge().zzim().zzg("Got multiple records for user property, expected one. appId", zzfg.zzbm(str));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzjz;
                } catch (SQLiteException e) {
                    e = e;
                    try {
                        zzge().zzim().zzd("Error querying user property. appId", zzfg.zzbm(str), zzga().zzbl(str3), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                zzge().zzim().zzd("Error querying user property. appId", zzfg.zzbm(str), zzga().zzbl(str3), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzge().zzim().zzd("Error querying user property. appId", zzfg.zzbm(str), zzga().zzbl(str3), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    public final String zzhn() {
        Cursor cursor;
        try {
            cursor = getWritableDatabase().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return string;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (SQLiteException e) {
                e = e;
                try {
                    zzge().zzim().zzg("Database error getting next bundle app id", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
            zzge().zzim().zzg("Database error getting next bundle app id", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean zzho() {
        return zza("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzhp() {
        int delete;
        zzab();
        zzch();
        if (zzhv()) {
            long j = zzgf().zzajx.get();
            long elapsedRealtime = zzbt().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzew.zzahg.get().longValue()) {
                zzgf().zzajx.set(elapsedRealtime);
                zzab();
                zzch();
                if (zzhv() && (delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzbt().currentTimeMillis()), String.valueOf(zzef.zzhh())})) > 0) {
                    zzge().zzit().zzg("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    public final long zzhq() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long zzhr() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean zzhs() {
        return zza("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzht() {
        return zza("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzhu() {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzge().zzim().zzg("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0125  */
    public final zzed zzi(String str, String str2) {
        Cursor cursor;
        String str3 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            cursor = getWritableDatabase().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                try {
                    Object zza = zza(cursor, 1);
                    boolean z = cursor.getInt(2) != 0;
                    String str4 = str;
                    zzed zzed = new zzed(str4, string, new zzjx(str2, cursor.getLong(8), zza, string), cursor.getLong(6), z, cursor.getString(3), (zzeu) zzgb().zza(cursor.getBlob(5), zzeu.CREATOR), cursor.getLong(4), (zzeu) zzgb().zza(cursor.getBlob(7), zzeu.CREATOR), cursor.getLong(9), (zzeu) zzgb().zza(cursor.getBlob(10), zzeu.CREATOR));
                    if (cursor.moveToNext()) {
                        zzge().zzim().zze("Got multiple records for conditional property, expected one", zzfg.zzbm(str), zzga().zzbl(str3));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzed;
                } catch (SQLiteException e) {
                    e = e;
                    try {
                        zzge().zzim().zzd("Error querying conditional property", zzfg.zzbm(str), zzga().zzbl(str3), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                zzge().zzim().zzd("Error querying conditional property", zzfg.zzbm(str), zzga().zzbl(str3), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzge().zzim().zzd("Error querying conditional property", zzfg.zzbm(str), zzga().zzbl(str3), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public final int zzj(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzge().zzim().zzd("Error deleting conditional property", zzfg.zzbm(str), zzga().zzbl(str2), e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2  */
    public final Map<Integer, List<zzke>> zzk(String str, String str2) {
        Cursor cursor;
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
        try {
            cursor = getWritableDatabase().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<zzke>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    byte[] blob = cursor.getBlob(1);
                    zzabv zza = zzabv.zza(blob, 0, blob.length);
                    zzke zzke = new zzke();
                    try {
                        zzke.zzb(zza);
                        int i = cursor.getInt(0);
                        List list = (List) o0o0ooo0.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            o0o0ooo0.put(Integer.valueOf(i), list);
                        }
                        list.add(zzke);
                    } catch (IOException e) {
                        zzge().zzim().zze("Failed to merge filter. appId", zzfg.zzbm(str), e);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return o0o0ooo0;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2  */
    public final Map<Integer, List<zzkh>> zzl(String str, String str2) {
        Cursor cursor;
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
        try {
            cursor = getWritableDatabase().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<zzkh>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    byte[] blob = cursor.getBlob(1);
                    zzabv zza = zzabv.zza(blob, 0, blob.length);
                    zzkh zzkh = new zzkh();
                    try {
                        zzkh.zzb(zza);
                        int i = cursor.getInt(0);
                        List list = (List) o0o0ooo0.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            o0o0ooo0.put(Integer.valueOf(i), list);
                        }
                        list.add(zzkh);
                    } catch (IOException e) {
                        zzge().zzim().zze("Failed to merge filter", zzfg.zzbm(str), e);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return o0o0ooo0;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final long zzm(String str, String str2) {
        long j;
        String str3 = str;
        String str4 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str4);
            sb.append(" from app2 where app_id=?");
            try {
                j = zza(sb.toString(), new String[]{str3}, -1);
                if (j == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (writableDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzge().zzim().zze("Failed to insert column (got -1). appId", zzfg.zzbm(str), str4);
                        writableDatabase.endTransaction();
                        return -1;
                    }
                    j = 0;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str3);
                    contentValues2.put(str4, Long.valueOf(1 + j));
                    if (((long) writableDatabase.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                        zzge().zzim().zze("Failed to update column (got 0). appId", zzfg.zzbm(str), str4);
                        writableDatabase.endTransaction();
                        return -1;
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    return j;
                } catch (SQLiteException e) {
                    e = e;
                }
            } catch (SQLiteException e2) {
                e = e2;
                j = 0;
                try {
                    zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str4, e);
                    writableDatabase.endTransaction();
                    return j;
                } catch (Throwable th) {
                    th = th;
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            j = 0;
            zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str4, e);
            writableDatabase.endTransaction();
            return j;
        } catch (Throwable th2) {
            th = th2;
            writableDatabase.endTransaction();
            throw th;
        }
    }
}
