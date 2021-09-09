package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.gkv;
import _m_j.gsy;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CloudVideoDownloadDBManager {
    private static volatile CloudVideoDownloadDBManager instance;
    public boolean isDataBaseInit;
    private CloudVideoSQLiteOpenHelper sqLiteOpenHelper;

    private CloudVideoDownloadDBManager() {
        dataBaseInit();
    }

    public static CloudVideoDownloadDBManager getInstance() {
        if (instance == null) {
            synchronized (CloudVideoDownloadDBManager.class) {
                if (instance == null) {
                    instance = new CloudVideoDownloadDBManager();
                }
            }
        }
        return instance;
    }

    public void dataBaseInit() {
        if (this.sqLiteOpenHelper == null) {
            this.sqLiteOpenHelper = new CloudVideoSQLiteOpenHelper(gkv.f17949O000000o);
            this.isDataBaseInit = true;
        }
    }

    public void insertRecords(List<CloudVideoDownloadInfo> list) {
        if (list != null && list.size() > 0) {
            for (CloudVideoDownloadInfo insertRecord : list) {
                insertRecord(insertRecord);
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0123=Splitter:B:27:0x0123, B:35:0x0145=Splitter:B:35:0x0145} */
    public void insertRecord(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        if (cloudVideoDownloadInfo != null && this.sqLiteOpenHelper != null) {
            gsy.O00000Oo("CloudVideoDownloadDBManager", "addRecord filePath:" + cloudVideoDownloadInfo.mp4FilePath + " videoUrl:" + cloudVideoDownloadInfo.videoUrl + " uid:" + cloudVideoDownloadInfo.uid + " createTime:" + cloudVideoDownloadInfo.createTime + " startTime:" + cloudVideoDownloadInfo.startTime + " endTime:" + cloudVideoDownloadInfo.endTime);
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = this.sqLiteOpenHelper.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("user_id", cloudVideoDownloadInfo.uid);
                    contentValues.put("device_id", cloudVideoDownloadInfo.did);
                    contentValues.put("file_id", cloudVideoDownloadInfo.fileId);
                    contentValues.put("title", cloudVideoDownloadInfo.title);
                    contentValues.put("video_url", cloudVideoDownloadInfo.videoUrl);
                    if (!TextUtils.isEmpty(cloudVideoDownloadInfo.m3u8LocalPath)) {
                        contentValues.put("file_path", cloudVideoDownloadInfo.m3u8LocalPath);
                    } else {
                        contentValues.put("file_path", cloudVideoDownloadInfo.mp4FilePath);
                    }
                    contentValues.put("start_time", Long.valueOf(cloudVideoDownloadInfo.startTime));
                    contentValues.put("start_time_pretty", cloudVideoDownloadInfo.startTimePretty);
                    contentValues.put("end_time", Long.valueOf(cloudVideoDownloadInfo.endTime));
                    contentValues.put("end_time_pretty", cloudVideoDownloadInfo.endTimePretty);
                    contentValues.put("create_time", Long.valueOf(cloudVideoDownloadInfo.createTime));
                    contentValues.put("create_time_pretty", cloudVideoDownloadInfo.createTimePretty);
                    contentValues.put("duration", Long.valueOf(cloudVideoDownloadInfo.duration));
                    contentValues.put("timezone_id", cloudVideoDownloadInfo.timezoneId);
                    contentValues.put("size", Integer.valueOf(cloudVideoDownloadInfo.size));
                    contentValues.put("progress", Integer.valueOf(cloudVideoDownloadInfo.progress));
                    contentValues.put("status", Integer.valueOf(cloudVideoDownloadInfo.status));
                    contentValues.put("alarm", Boolean.valueOf(cloudVideoDownloadInfo.isAlarm));
                    sQLiteDatabase2.insert(CloudVideoConst.TABLE_NAME, null, contentValues);
                    if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                        sQLiteDatabase2.close();
                    }
                } catch (SQLException e) {
                    e = e;
                    sQLiteDatabase = sQLiteDatabase2;
                    gsy.O000000o(6, "CloudVideoDownloadDBManager", "addRecord error:" + e.getLocalizedMessage());
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                } catch (IllegalStateException e2) {
                    e = e2;
                    sQLiteDatabase = sQLiteDatabase2;
                    try {
                        gsy.O000000o(6, "CloudVideoDownloadDBManager", "addRecord IllegalStateException:" + e.getLocalizedMessage());
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase2 = sQLiteDatabase;
                        sQLiteDatabase2.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            } catch (SQLException e3) {
                e = e3;
                gsy.O000000o(6, "CloudVideoDownloadDBManager", "addRecord error:" + e.getLocalizedMessage());
                if (sQLiteDatabase != null) {
                }
            } catch (IllegalStateException e4) {
                e = e4;
                gsy.O000000o(6, "CloudVideoDownloadDBManager", "addRecord IllegalStateException:" + e.getLocalizedMessage());
                if (sQLiteDatabase != null) {
                }
            }
        }
    }

    public void updateRecord(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        if (cloudVideoDownloadInfo != null && this.sqLiteOpenHelper != null) {
            gsy.O00000Oo("CloudVideoDownloadDBManager", " videoUrl:" + cloudVideoDownloadInfo.videoUrl + " uid:" + cloudVideoDownloadInfo.uid + " createTime:" + cloudVideoDownloadInfo.createTime + " startTime:" + cloudVideoDownloadInfo.startTime + " endTime:" + cloudVideoDownloadInfo.endTime);
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = this.sqLiteOpenHelper.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", cloudVideoDownloadInfo.title);
                    contentValues.put("video_url", cloudVideoDownloadInfo.videoUrl);
                    contentValues.put("file_id", cloudVideoDownloadInfo.fileId);
                    if (!TextUtils.isEmpty(cloudVideoDownloadInfo.m3u8LocalPath)) {
                        contentValues.put("file_path", cloudVideoDownloadInfo.m3u8LocalPath);
                    } else {
                        contentValues.put("file_path", cloudVideoDownloadInfo.mp4FilePath);
                    }
                    contentValues.put("start_time", Long.valueOf(cloudVideoDownloadInfo.startTime));
                    contentValues.put("start_time_pretty", cloudVideoDownloadInfo.startTimePretty);
                    contentValues.put("end_time", Long.valueOf(cloudVideoDownloadInfo.endTime));
                    contentValues.put("end_time_pretty", cloudVideoDownloadInfo.endTimePretty);
                    contentValues.put("timezone_id", cloudVideoDownloadInfo.timezoneId);
                    contentValues.put("size", Integer.valueOf(cloudVideoDownloadInfo.size));
                    contentValues.put("progress", Integer.valueOf(cloudVideoDownloadInfo.progress));
                    contentValues.put("duration", Long.valueOf(cloudVideoDownloadInfo.duration));
                    contentValues.put("status", Integer.valueOf(cloudVideoDownloadInfo.status));
                    contentValues.put("alarm", Boolean.valueOf(cloudVideoDownloadInfo.isAlarm));
                    sQLiteDatabase2.update(CloudVideoConst.TABLE_NAME, contentValues, "device_id = '" + cloudVideoDownloadInfo.did + "' and file_id = " + cloudVideoDownloadInfo.fileId, null);
                    if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                        sQLiteDatabase2.close();
                    }
                } catch (SQLException e) {
                    e = e;
                    sQLiteDatabase = sQLiteDatabase2;
                    try {
                        gsy.O000000o(6, "CloudVideoDownloadDBManager", "updateRecord error:" + e.getLocalizedMessage());
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase2 = sQLiteDatabase;
                        sQLiteDatabase2.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            } catch (SQLException e2) {
                e = e2;
                gsy.O000000o(6, "CloudVideoDownloadDBManager", "updateRecord error:" + e.getLocalizedMessage());
                if (sQLiteDatabase != null) {
                }
            }
        }
    }

    public boolean deleteRecords(List<CloudVideoDownloadInfo> list) {
        boolean z = true;
        if (list == null || list.size() <= 0 || this.sqLiteOpenHelper == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (CloudVideoDownloadInfo cloudVideoDownloadInfo : list) {
            sb.append("'" + cloudVideoDownloadInfo.did + "',");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(")");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        for (CloudVideoDownloadInfo cloudVideoDownloadInfo2 : list) {
            sb2.append("'" + cloudVideoDownloadInfo2.id + "',");
        }
        sb2.deleteCharAt(sb2.lastIndexOf(","));
        sb2.append(")");
        String str = "DELETE FROM " + CloudVideoConst.TABLE_NAME + " WHERE id IN " + ((Object) sb2);
        gsy.O00000Oo("CloudVideoDownloadDBManager", "deleteSql:".concat(String.valueOf(str)));
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = this.sqLiteOpenHelper.getWritableDatabase();
            if (writableDatabase.isOpen()) {
                writableDatabase.execSQL(str);
            } else {
                z = false;
            }
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return z;
            }
            writableDatabase.close();
            return z;
        } catch (SQLException e) {
            gsy.O000000o(6, "CloudVideoDownloadDBManager", "deleteRecord error:" + e.getLocalizedMessage());
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:30:0x0153 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0151, code lost:
        r14 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0162, code lost:
        r14 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0162 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0009] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public CloudVideoDownloadInfo getRecord(int i) {
        CloudVideoDownloadInfo cloudVideoDownloadInfo;
        ? r1 = 0;
        try {
            SQLiteDatabase sQLiteDatabase = this.sqLiteOpenHelper.getReadableDatabase();
            try {
                if (sQLiteDatabase.isOpen()) {
                    Cursor query = sQLiteDatabase.query(CloudVideoConst.TABLE_NAME, null, "id = ?", new String[]{String.valueOf(i)}, null, null, null);
                    if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                        while (true) {
                            cloudVideoDownloadInfo = new CloudVideoDownloadInfo();
                            cloudVideoDownloadInfo.id = query.getInt(query.getColumnIndex("id"));
                            cloudVideoDownloadInfo.uid = query.getString(query.getColumnIndex("user_id"));
                            cloudVideoDownloadInfo.did = query.getString(query.getColumnIndex("device_id"));
                            cloudVideoDownloadInfo.fileId = query.getString(query.getColumnIndex("file_id"));
                            cloudVideoDownloadInfo.status = query.getInt(query.getColumnIndex("status"));
                            cloudVideoDownloadInfo.title = query.getString(query.getColumnIndex("title"));
                            cloudVideoDownloadInfo.videoUrl = query.getString(query.getColumnIndex("video_url"));
                            String string = query.getString(query.getColumnIndex("file_path"));
                            if (TextUtils.isEmpty(string) || !string.endsWith("mp4")) {
                                cloudVideoDownloadInfo.m3u8LocalPath = string;
                            } else {
                                cloudVideoDownloadInfo.mp4FilePath = string;
                            }
                            cloudVideoDownloadInfo.timezoneId = query.getString(query.getColumnIndex("timezone_id"));
                            cloudVideoDownloadInfo.startTime = query.getLong(query.getColumnIndex("start_time"));
                            cloudVideoDownloadInfo.startTimePretty = query.getString(query.getColumnIndex("start_time_pretty"));
                            cloudVideoDownloadInfo.endTime = query.getLong(query.getColumnIndex("end_time"));
                            cloudVideoDownloadInfo.endTimePretty = query.getString(query.getColumnIndex("end_time_pretty"));
                            cloudVideoDownloadInfo.createTime = query.getLong(query.getColumnIndex("create_time"));
                            cloudVideoDownloadInfo.createTimePretty = query.getString(query.getColumnIndex("create_time_pretty"));
                            cloudVideoDownloadInfo.size = query.getInt(query.getColumnIndex("size"));
                            cloudVideoDownloadInfo.progress = query.getInt(query.getColumnIndex("progress"));
                            cloudVideoDownloadInfo.duration = query.getLong(query.getColumnIndex("duration"));
                            cloudVideoDownloadInfo.isAlarm = query.getInt(query.getColumnIndex("alarm")) == 1;
                            gsy.O00000Oo("CloudVideoDownloadDBManager", "getRecord:" + cloudVideoDownloadInfo.id);
                            if (!query.moveToNext()) {
                                break;
                            }
                        }
                        r1 = cloudVideoDownloadInfo;
                    }
                    query.close();
                }
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return r1;
                }
                sQLiteDatabase.close();
                return r1;
            } catch (SQLException e) {
                e = e;
                cloudVideoDownloadInfo = r1;
                r1 = sQLiteDatabase;
                try {
                    gsy.O000000o(6, "CloudVideoDownloadDBManager", "getRecord exception:" + e.getLocalizedMessage());
                    r1.close();
                    return cloudVideoDownloadInfo;
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = r1;
                    sQLiteDatabase.close();
                    throw th;
                }
            } catch (Throwable th2) {
            }
        } catch (SQLException e2) {
            e = e2;
            cloudVideoDownloadInfo = null;
            gsy.O000000o(6, "CloudVideoDownloadDBManager", "getRecord exception:" + e.getLocalizedMessage());
            r1.close();
            return cloudVideoDownloadInfo;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02fb, code lost:
        if (r4.isOpen() != false) goto L_0x02fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02fd, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0326, code lost:
        if (r4.isOpen() != false) goto L_0x02fd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01c4 A[Catch:{ Exception -> 0x0303 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02de A[Catch:{ Exception -> 0x0303 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x02e0 A[Catch:{ Exception -> 0x0303 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x02ed A[Catch:{ Exception -> 0x0303 }, LOOP:1: B:57:0x01ed->B:71:0x02ed, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02ec A[EDGE_INSN: B:96:0x02ec->B:70:0x02ec ?: BREAK  , SYNTHETIC] */
    public List<CloudVideoDownloadInfo> getRecords(String str, String str2) {
        String str3;
        String str4;
        String str5;
        SQLiteDatabase sQLiteDatabase;
        String str6;
        ArrayList arrayList = new ArrayList();
        try {
            str3 = CloudVideoNetUtils.getInstance().getTokenInfo().O00000Oo;
        } catch (Exception e) {
            gsy.O000000o(6, "CloudVideoDownloadDBManager", "Exception getRecords:" + e.getLocalizedMessage());
            str3 = null;
        }
        String str7 = "mp4";
        String str8 = "file_path";
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            try {
                SQLiteDatabase readableDatabase = this.sqLiteOpenHelper.getReadableDatabase();
                if (readableDatabase.isOpen()) {
                    Cursor query = readableDatabase.query(CloudVideoConst.TABLE_NAME, null, "user_id = ? AND device_id = ? ", new String[]{str3, str2}, null, null, "create_time desc");
                    if (query == null || query.getCount() <= 0 || !query.moveToFirst()) {
                        str5 = str7;
                        str4 = str8;
                    } else {
                        while (true) {
                            CloudVideoDownloadInfo cloudVideoDownloadInfo = new CloudVideoDownloadInfo();
                            cloudVideoDownloadInfo.id = query.getInt(query.getColumnIndex("id"));
                            cloudVideoDownloadInfo.uid = query.getString(query.getColumnIndex("user_id"));
                            cloudVideoDownloadInfo.did = query.getString(query.getColumnIndex("device_id"));
                            cloudVideoDownloadInfo.fileId = query.getString(query.getColumnIndex("file_id"));
                            cloudVideoDownloadInfo.status = query.getInt(query.getColumnIndex("status"));
                            cloudVideoDownloadInfo.title = query.getString(query.getColumnIndex("title"));
                            cloudVideoDownloadInfo.videoUrl = query.getString(query.getColumnIndex("video_url"));
                            String string = query.getString(query.getColumnIndex(str8));
                            if (TextUtils.isEmpty(string) || !string.endsWith(str7)) {
                                cloudVideoDownloadInfo.m3u8LocalPath = string;
                            } else {
                                cloudVideoDownloadInfo.mp4FilePath = string;
                            }
                            cloudVideoDownloadInfo.timezoneId = query.getString(query.getColumnIndex("timezone_id"));
                            str5 = str7;
                            str4 = str8;
                            try {
                                cloudVideoDownloadInfo.startTime = query.getLong(query.getColumnIndex("start_time"));
                                cloudVideoDownloadInfo.startTimePretty = query.getString(query.getColumnIndex("start_time_pretty"));
                                cloudVideoDownloadInfo.endTime = query.getLong(query.getColumnIndex("end_time"));
                                cloudVideoDownloadInfo.endTimePretty = query.getString(query.getColumnIndex("end_time_pretty"));
                                cloudVideoDownloadInfo.createTime = query.getLong(query.getColumnIndex("create_time"));
                                cloudVideoDownloadInfo.createTimePretty = query.getString(query.getColumnIndex("create_time_pretty"));
                                cloudVideoDownloadInfo.size = query.getInt(query.getColumnIndex("size"));
                                cloudVideoDownloadInfo.progress = query.getInt(query.getColumnIndex("progress"));
                                cloudVideoDownloadInfo.duration = query.getLong(query.getColumnIndex("duration"));
                                cloudVideoDownloadInfo.isAlarm = query.getInt(query.getColumnIndex("alarm")) == 1;
                                arrayList.add(cloudVideoDownloadInfo);
                                if (!query.moveToNext()) {
                                    break;
                                }
                                str7 = str5;
                                str8 = str4;
                            } catch (SQLException e2) {
                                e = e2;
                                gsy.O000000o(6, "CloudVideoDownloadDBManager", "getRecords error 1:" + e.getLocalizedMessage());
                                sQLiteDatabase = this.sqLiteOpenHelper.getReadableDatabase();
                                try {
                                    if (sQLiteDatabase.isOpen()) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    try {
                                        gsy.O000000o(6, "CloudVideoDownloadDBManager", "getRecords error 2:" + e.getLocalizedMessage());
                                        if (sQLiteDatabase != null) {
                                        }
                                        gsy.O00000Oo("CloudVideoDownloadDBManager", "getRecords:" + arrayList.size());
                                        return arrayList;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                            sQLiteDatabase.close();
                                        }
                                        throw th;
                                    }
                                }
                                gsy.O00000Oo("CloudVideoDownloadDBManager", "getRecords:" + arrayList.size());
                                return arrayList;
                            }
                        }
                    }
                    query.close();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        sQLiteDatabase = this.sqLiteOpenHelper.getReadableDatabase();
                        if (sQLiteDatabase.isOpen()) {
                            Cursor query2 = sQLiteDatabase.query(CloudVideoConst.TABLE_NAME, null, "user_id = ? AND device_id = ? ", new String[]{str, str2}, null, null, "create_time desc");
                            if (query2 != null && query2.getCount() > 0 && query2.moveToFirst()) {
                                while (true) {
                                    CloudVideoDownloadInfo cloudVideoDownloadInfo2 = new CloudVideoDownloadInfo();
                                    cloudVideoDownloadInfo2.id = query2.getInt(query2.getColumnIndex("id"));
                                    cloudVideoDownloadInfo2.uid = query2.getString(query2.getColumnIndex("user_id"));
                                    cloudVideoDownloadInfo2.did = query2.getString(query2.getColumnIndex("device_id"));
                                    cloudVideoDownloadInfo2.fileId = query2.getString(query2.getColumnIndex("file_id"));
                                    cloudVideoDownloadInfo2.status = query2.getInt(query2.getColumnIndex("status"));
                                    cloudVideoDownloadInfo2.title = query2.getString(query2.getColumnIndex("title"));
                                    cloudVideoDownloadInfo2.videoUrl = query2.getString(query2.getColumnIndex("video_url"));
                                    String str9 = str4;
                                    String string2 = query2.getString(query2.getColumnIndex(str9));
                                    if (!TextUtils.isEmpty(string2)) {
                                        str6 = str5;
                                        if (string2.endsWith(str6)) {
                                            cloudVideoDownloadInfo2.mp4FilePath = string2;
                                            cloudVideoDownloadInfo2.timezoneId = query2.getString(query2.getColumnIndex("timezone_id"));
                                            str4 = str9;
                                            cloudVideoDownloadInfo2.startTime = query2.getLong(query2.getColumnIndex("start_time"));
                                            cloudVideoDownloadInfo2.startTimePretty = query2.getString(query2.getColumnIndex("start_time_pretty"));
                                            cloudVideoDownloadInfo2.endTime = query2.getLong(query2.getColumnIndex("end_time"));
                                            cloudVideoDownloadInfo2.endTimePretty = query2.getString(query2.getColumnIndex("end_time_pretty"));
                                            cloudVideoDownloadInfo2.createTime = query2.getLong(query2.getColumnIndex("create_time"));
                                            cloudVideoDownloadInfo2.createTimePretty = query2.getString(query2.getColumnIndex("create_time_pretty"));
                                            cloudVideoDownloadInfo2.size = query2.getInt(query2.getColumnIndex("size"));
                                            cloudVideoDownloadInfo2.progress = query2.getInt(query2.getColumnIndex("progress"));
                                            cloudVideoDownloadInfo2.duration = query2.getLong(query2.getColumnIndex("duration"));
                                            cloudVideoDownloadInfo2.isAlarm = query2.getInt(query2.getColumnIndex("alarm")) != 1;
                                            arrayList.add(cloudVideoDownloadInfo2);
                                            if (query2.moveToNext()) {
                                                break;
                                            }
                                            str5 = str6;
                                        }
                                    } else {
                                        str6 = str5;
                                    }
                                    cloudVideoDownloadInfo2.m3u8LocalPath = string2;
                                    cloudVideoDownloadInfo2.timezoneId = query2.getString(query2.getColumnIndex("timezone_id"));
                                    str4 = str9;
                                    cloudVideoDownloadInfo2.startTime = query2.getLong(query2.getColumnIndex("start_time"));
                                    cloudVideoDownloadInfo2.startTimePretty = query2.getString(query2.getColumnIndex("start_time_pretty"));
                                    cloudVideoDownloadInfo2.endTime = query2.getLong(query2.getColumnIndex("end_time"));
                                    cloudVideoDownloadInfo2.endTimePretty = query2.getString(query2.getColumnIndex("end_time_pretty"));
                                    cloudVideoDownloadInfo2.createTime = query2.getLong(query2.getColumnIndex("create_time"));
                                    cloudVideoDownloadInfo2.createTimePretty = query2.getString(query2.getColumnIndex("create_time_pretty"));
                                    cloudVideoDownloadInfo2.size = query2.getInt(query2.getColumnIndex("size"));
                                    cloudVideoDownloadInfo2.progress = query2.getInt(query2.getColumnIndex("progress"));
                                    cloudVideoDownloadInfo2.duration = query2.getLong(query2.getColumnIndex("duration"));
                                    cloudVideoDownloadInfo2.isAlarm = query2.getInt(query2.getColumnIndex("alarm")) != 1;
                                    arrayList.add(cloudVideoDownloadInfo2);
                                    if (query2.moveToNext()) {
                                    }
                                }
                            }
                            query2.close();
                        }
                        if (sQLiteDatabase != null) {
                        }
                        gsy.O00000Oo("CloudVideoDownloadDBManager", "getRecords:" + arrayList.size());
                    }
                    return arrayList;
                }
            } catch (SQLException e4) {
                e = e4;
                str5 = str7;
                str4 = str8;
                gsy.O000000o(6, "CloudVideoDownloadDBManager", "getRecords error 1:" + e.getLocalizedMessage());
                sQLiteDatabase = this.sqLiteOpenHelper.getReadableDatabase();
                if (sQLiteDatabase.isOpen()) {
                }
                if (sQLiteDatabase != null) {
                }
                gsy.O00000Oo("CloudVideoDownloadDBManager", "getRecords:" + arrayList.size());
                return arrayList;
            }
        }
        str5 = str7;
        str4 = str8;
        try {
            sQLiteDatabase = this.sqLiteOpenHelper.getReadableDatabase();
            if (sQLiteDatabase.isOpen()) {
            }
            if (sQLiteDatabase != null) {
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabase = null;
            gsy.O000000o(6, "CloudVideoDownloadDBManager", "getRecords error 2:" + e.getLocalizedMessage());
            if (sQLiteDatabase != null) {
            }
            gsy.O00000Oo("CloudVideoDownloadDBManager", "getRecords:" + arrayList.size());
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
            sQLiteDatabase.close();
            throw th;
        }
        gsy.O00000Oo("CloudVideoDownloadDBManager", "getRecords:" + arrayList.size());
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0149, code lost:
        if (r1.isOpen() != false) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x014b, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0170, code lost:
        if (r1.isOpen() != false) goto L_0x014b;
     */
    public List<CloudVideoDownloadInfo> getRecords(int i) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.sqLiteOpenHelper.getReadableDatabase();
            if (sQLiteDatabase.isOpen()) {
                Cursor query = sQLiteDatabase.query(CloudVideoConst.TABLE_NAME, null, "status = ? ", new String[]{String.valueOf(i)}, null, null, "create_time desc");
                if (query == null || query.getCount() <= 0 || !query.moveToFirst()) {
                    query.close();
                } else {
                    do {
                        CloudVideoDownloadInfo cloudVideoDownloadInfo = new CloudVideoDownloadInfo();
                        cloudVideoDownloadInfo.id = query.getInt(query.getColumnIndex("id"));
                        cloudVideoDownloadInfo.uid = query.getString(query.getColumnIndex("user_id"));
                        cloudVideoDownloadInfo.did = query.getString(query.getColumnIndex("device_id"));
                        cloudVideoDownloadInfo.fileId = query.getString(query.getColumnIndex("file_id"));
                        cloudVideoDownloadInfo.status = query.getInt(query.getColumnIndex("status"));
                        cloudVideoDownloadInfo.title = query.getString(query.getColumnIndex("title"));
                        cloudVideoDownloadInfo.videoUrl = query.getString(query.getColumnIndex("video_url"));
                        String string = query.getString(query.getColumnIndex("file_path"));
                        if (TextUtils.isEmpty(string) || !string.endsWith("mp4")) {
                            cloudVideoDownloadInfo.m3u8LocalPath = string;
                        } else {
                            cloudVideoDownloadInfo.mp4FilePath = string;
                        }
                        cloudVideoDownloadInfo.timezoneId = query.getString(query.getColumnIndex("timezone_id"));
                        cloudVideoDownloadInfo.startTime = query.getLong(query.getColumnIndex("start_time"));
                        cloudVideoDownloadInfo.startTimePretty = query.getString(query.getColumnIndex("start_time_pretty"));
                        cloudVideoDownloadInfo.endTime = query.getLong(query.getColumnIndex("end_time"));
                        cloudVideoDownloadInfo.endTimePretty = query.getString(query.getColumnIndex("end_time_pretty"));
                        cloudVideoDownloadInfo.createTime = query.getLong(query.getColumnIndex("create_time"));
                        cloudVideoDownloadInfo.createTimePretty = query.getString(query.getColumnIndex("create_time_pretty"));
                        cloudVideoDownloadInfo.size = query.getInt(query.getColumnIndex("size"));
                        cloudVideoDownloadInfo.progress = query.getInt(query.getColumnIndex("progress"));
                        cloudVideoDownloadInfo.duration = query.getLong(query.getColumnIndex("duration"));
                        cloudVideoDownloadInfo.isAlarm = query.getInt(query.getColumnIndex("alarm")) == 1;
                        arrayList.add(cloudVideoDownloadInfo);
                    } while (query.moveToNext());
                    query.close();
                }
            }
            if (sQLiteDatabase != null) {
            }
        } catch (Exception e) {
            gsy.O000000o(6, "CloudVideoDownloadDBManager", "getRecords error 1:" + e.getLocalizedMessage());
            if (sQLiteDatabase != null) {
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        return arrayList;
    }

    class CloudVideoSQLiteOpenHelper extends SQLiteOpenHelper {
        private final String CREATE_TABLE_CONTENT = "(id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR(32), user_id VARCHAR(32), file_id VARCHAR(32), file_path VARCHAR(128), title VARCHAR(128), video_url VARCHAR(128), create_time INTEGER(16), start_time INTEGER(16), end_time INTEGER(16), duration INTEGER(16), create_time_pretty VARCHAR(32), start_time_pretty VARCHAR(32), end_time_pretty VARCHAR(32), timezone_id VARCHAR(64), size INTEGER(16), progress INTEGER, status INTEGER, alarm INTEGER)";
        private final String CREATE_TABLE_STRING_M3U8 = "CREATE TABLE mijia_camera_cloud_video(id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR(32), user_id VARCHAR(32), file_id VARCHAR(32), file_path VARCHAR(128), title VARCHAR(128), video_url VARCHAR(128), create_time INTEGER(16), start_time INTEGER(16), end_time INTEGER(16), duration INTEGER(16), create_time_pretty VARCHAR(32), start_time_pretty VARCHAR(32), end_time_pretty VARCHAR(32), timezone_id VARCHAR(64), size INTEGER(16), progress INTEGER, status INTEGER, alarm INTEGER)";
        private final String CREATE_TABLE_STRING_MP4 = "CREATE TABLE mijia_camera_cloud_video_mp4(id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR(32), user_id VARCHAR(32), file_id VARCHAR(32), file_path VARCHAR(128), title VARCHAR(128), video_url VARCHAR(128), create_time INTEGER(16), start_time INTEGER(16), end_time INTEGER(16), duration INTEGER(16), create_time_pretty VARCHAR(32), start_time_pretty VARCHAR(32), end_time_pretty VARCHAR(32), timezone_id VARCHAR(64), size INTEGER(16), progress INTEGER, status INTEGER, alarm INTEGER)";
        private final String DROP_TABLE_STRING_M3U8 = "DROP TABLE IF EXISTS mijia_camera_cloud_video";
        private final String DROP_TABLE_STRING_MP4 = "DROP TABLE IF EXISTS mijia_camera_cloud_video_mp4";

        public CloudVideoSQLiteOpenHelper(Context context) {
            super(context, "mijia_camera_cloud_video.db", (SQLiteDatabase.CursorFactory) null, 9);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE mijia_camera_cloud_video(id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR(32), user_id VARCHAR(32), file_id VARCHAR(32), file_path VARCHAR(128), title VARCHAR(128), video_url VARCHAR(128), create_time INTEGER(16), start_time INTEGER(16), end_time INTEGER(16), duration INTEGER(16), create_time_pretty VARCHAR(32), start_time_pretty VARCHAR(32), end_time_pretty VARCHAR(32), timezone_id VARCHAR(64), size INTEGER(16), progress INTEGER, status INTEGER, alarm INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE mijia_camera_cloud_video_mp4(id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR(32), user_id VARCHAR(32), file_id VARCHAR(32), file_path VARCHAR(128), title VARCHAR(128), video_url VARCHAR(128), create_time INTEGER(16), start_time INTEGER(16), end_time INTEGER(16), duration INTEGER(16), create_time_pretty VARCHAR(32), start_time_pretty VARCHAR(32), end_time_pretty VARCHAR(32), timezone_id VARCHAR(64), size INTEGER(16), progress INTEGER, status INTEGER, alarm INTEGER)");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == i2) {
                return;
            }
            if (i2 >= 4) {
                gsy.O00000Oo("CloudVideoDownloadDBManager", "onUpgrade from:" + i + " to:" + i2);
                sQLiteDatabase.beginTransaction();
                try {
                    if (sQLiteDatabase.isOpen()) {
                        doUpgrade(sQLiteDatabase, "mijia_camera_cloud_video", "DROP TABLE IF EXISTS mijia_camera_cloud_video", "CREATE TABLE mijia_camera_cloud_video(id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR(32), user_id VARCHAR(32), file_id VARCHAR(32), file_path VARCHAR(128), title VARCHAR(128), video_url VARCHAR(128), create_time INTEGER(16), start_time INTEGER(16), end_time INTEGER(16), duration INTEGER(16), create_time_pretty VARCHAR(32), start_time_pretty VARCHAR(32), end_time_pretty VARCHAR(32), timezone_id VARCHAR(64), size INTEGER(16), progress INTEGER, status INTEGER, alarm INTEGER)");
                        if (i2 <= 9) {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS mijia_camera_cloud_video_mp4");
                            sQLiteDatabase.execSQL("CREATE TABLE mijia_camera_cloud_video_mp4(id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR(32), user_id VARCHAR(32), file_id VARCHAR(32), file_path VARCHAR(128), title VARCHAR(128), video_url VARCHAR(128), create_time INTEGER(16), start_time INTEGER(16), end_time INTEGER(16), duration INTEGER(16), create_time_pretty VARCHAR(32), start_time_pretty VARCHAR(32), end_time_pretty VARCHAR(32), timezone_id VARCHAR(64), size INTEGER(16), progress INTEGER, status INTEGER, alarm INTEGER)");
                        } else {
                            doUpgrade(sQLiteDatabase, "mijia_camera_cloud_video_mp4", "DROP TABLE IF EXISTS mijia_camera_cloud_video_mp4", "CREATE TABLE mijia_camera_cloud_video_mp4(id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR(32), user_id VARCHAR(32), file_id VARCHAR(32), file_path VARCHAR(128), title VARCHAR(128), video_url VARCHAR(128), create_time INTEGER(16), start_time INTEGER(16), end_time INTEGER(16), duration INTEGER(16), create_time_pretty VARCHAR(32), start_time_pretty VARCHAR(32), end_time_pretty VARCHAR(32), timezone_id VARCHAR(64), size INTEGER(16), progress INTEGER, status INTEGER, alarm INTEGER)");
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    gsy.O00000Oo("CloudVideoDownloadDBManager", "upgrade success");
                } catch (Exception e) {
                    gsy.O000000o(6, "CloudVideoDownloadDBManager", "exception:" + e.getLocalizedMessage());
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            } else {
                gsy.O00000Oo("CloudVideoDownloadDBManager", "onUpgrade from:" + i + " to:" + i2);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS mijia_camera_cloud_video");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS mijia_camera_cloud_video_mp4");
                onCreate(sQLiteDatabase);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x012b  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x013e  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x014f A[LOOP:0: B:7:0x0045->B:27:0x014f, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x015f A[EDGE_INSN: B:47:0x015f->B:29:0x015f ?: BREAK  , SYNTHETIC] */
        private void doUpgrade(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
            String str4;
            String str5;
            String str6;
            ArrayList arrayList;
            String str7;
            Cursor query = sQLiteDatabase.query(str, null, null, null, null, null, null);
            String str8 = "create_time";
            String str9 = "timezone_id";
            String str10 = "video_url";
            String str11 = "id";
            ArrayList arrayList2 = new ArrayList();
            if (query == null || query.getCount() <= 0 || !query.moveToFirst()) {
                str4 = str9;
                str5 = str11;
                str6 = "alarm";
                arrayList = arrayList2;
            } else {
                str6 = "alarm";
                while (true) {
                    CloudVideoDownloadInfo cloudVideoDownloadInfo = new CloudVideoDownloadInfo();
                    String str12 = str8;
                    cloudVideoDownloadInfo.id = query.getInt(query.getColumnIndex(str11));
                    cloudVideoDownloadInfo.uid = query.getString(query.getColumnIndex("user_id"));
                    cloudVideoDownloadInfo.did = query.getString(query.getColumnIndex("device_id"));
                    int columnIndex = query.getColumnIndex("file_id");
                    if (columnIndex >= 0) {
                        cloudVideoDownloadInfo.fileId = query.getString(columnIndex);
                    }
                    cloudVideoDownloadInfo.status = query.getInt(query.getColumnIndex("status"));
                    cloudVideoDownloadInfo.title = query.getString(query.getColumnIndex("title"));
                    cloudVideoDownloadInfo.videoUrl = query.getString(query.getColumnIndex(str10));
                    String string = query.getString(query.getColumnIndex("file_path"));
                    if (!TextUtils.isEmpty(string)) {
                        str5 = str11;
                        if (string.endsWith("mp4")) {
                            cloudVideoDownloadInfo.mp4FilePath = string;
                            cloudVideoDownloadInfo.timezoneId = query.getString(query.getColumnIndex(str9));
                            str4 = str9;
                            cloudVideoDownloadInfo.startTime = query.getLong(query.getColumnIndex("start_time"));
                            cloudVideoDownloadInfo.startTimePretty = query.getString(query.getColumnIndex("start_time_pretty"));
                            cloudVideoDownloadInfo.endTime = query.getLong(query.getColumnIndex("end_time"));
                            cloudVideoDownloadInfo.endTimePretty = query.getString(query.getColumnIndex("end_time_pretty"));
                            str8 = str12;
                            cloudVideoDownloadInfo.createTime = query.getLong(query.getColumnIndex(str8));
                            cloudVideoDownloadInfo.createTimePretty = query.getString(query.getColumnIndex("create_time_pretty"));
                            cloudVideoDownloadInfo.size = query.getInt(query.getColumnIndex("size"));
                            cloudVideoDownloadInfo.progress = query.getInt(query.getColumnIndex("progress"));
                            cloudVideoDownloadInfo.duration = query.getLong(query.getColumnIndex("duration"));
                            str7 = str6;
                            if (query.getColumnIndex(str7) < 0) {
                                str6 = str7;
                                cloudVideoDownloadInfo.isAlarm = query.getInt(query.getColumnIndex(str7)) == 1;
                            } else {
                                str6 = str7;
                                cloudVideoDownloadInfo.isAlarm = false;
                            }
                            arrayList = arrayList2;
                            arrayList.add(cloudVideoDownloadInfo);
                            if (query.moveToNext()) {
                                break;
                            }
                            arrayList2 = arrayList;
                            str11 = str5;
                            str9 = str4;
                        }
                    } else {
                        str5 = str11;
                    }
                    cloudVideoDownloadInfo.m3u8LocalPath = string;
                    cloudVideoDownloadInfo.timezoneId = query.getString(query.getColumnIndex(str9));
                    str4 = str9;
                    cloudVideoDownloadInfo.startTime = query.getLong(query.getColumnIndex("start_time"));
                    cloudVideoDownloadInfo.startTimePretty = query.getString(query.getColumnIndex("start_time_pretty"));
                    cloudVideoDownloadInfo.endTime = query.getLong(query.getColumnIndex("end_time"));
                    cloudVideoDownloadInfo.endTimePretty = query.getString(query.getColumnIndex("end_time_pretty"));
                    str8 = str12;
                    cloudVideoDownloadInfo.createTime = query.getLong(query.getColumnIndex(str8));
                    cloudVideoDownloadInfo.createTimePretty = query.getString(query.getColumnIndex("create_time_pretty"));
                    cloudVideoDownloadInfo.size = query.getInt(query.getColumnIndex("size"));
                    cloudVideoDownloadInfo.progress = query.getInt(query.getColumnIndex("progress"));
                    cloudVideoDownloadInfo.duration = query.getLong(query.getColumnIndex("duration"));
                    str7 = str6;
                    if (query.getColumnIndex(str7) < 0) {
                    }
                    arrayList = arrayList2;
                    arrayList.add(cloudVideoDownloadInfo);
                    if (query.moveToNext()) {
                    }
                }
            }
            if (query != null) {
                query.close();
            }
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            String str13 = str5;
            sQLiteDatabase2.execSQL(str2);
            sQLiteDatabase2.execSQL(str3);
            ArrayList<ContentValues> arrayList3 = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Iterator it2 = it;
                CloudVideoDownloadInfo cloudVideoDownloadInfo2 = (CloudVideoDownloadInfo) it.next();
                ContentValues contentValues = new ContentValues();
                ArrayList arrayList4 = arrayList3;
                contentValues.put(str13, Integer.valueOf(cloudVideoDownloadInfo2.id));
                contentValues.put("user_id", cloudVideoDownloadInfo2.uid);
                contentValues.put("device_id", cloudVideoDownloadInfo2.did);
                if (!TextUtils.isEmpty(cloudVideoDownloadInfo2.fileId)) {
                    contentValues.put("file_id", cloudVideoDownloadInfo2.fileId);
                }
                if (!TextUtils.isEmpty(cloudVideoDownloadInfo2.mp4FilePath)) {
                    contentValues.put("file_path", cloudVideoDownloadInfo2.mp4FilePath);
                } else {
                    contentValues.put("file_path", cloudVideoDownloadInfo2.m3u8LocalPath);
                }
                contentValues.put("title", cloudVideoDownloadInfo2.title);
                contentValues.put(str10, cloudVideoDownloadInfo2.videoUrl);
                contentValues.put(str8, Long.valueOf(cloudVideoDownloadInfo2.createTime));
                contentValues.put("start_time", Long.valueOf(cloudVideoDownloadInfo2.startTime));
                contentValues.put("end_time", Long.valueOf(cloudVideoDownloadInfo2.endTime));
                contentValues.put("duration", Long.valueOf(cloudVideoDownloadInfo2.duration));
                contentValues.put("create_time_pretty", cloudVideoDownloadInfo2.createTimePretty);
                contentValues.put("start_time_pretty", cloudVideoDownloadInfo2.startTimePretty);
                contentValues.put("end_time_pretty", cloudVideoDownloadInfo2.endTimePretty);
                contentValues.put(str4, cloudVideoDownloadInfo2.timezoneId);
                String str14 = str8;
                contentValues.put("size", Integer.valueOf(cloudVideoDownloadInfo2.size));
                contentValues.put("progress", Integer.valueOf(cloudVideoDownloadInfo2.progress));
                contentValues.put("status", Integer.valueOf(cloudVideoDownloadInfo2.status));
                contentValues.put(str6, Boolean.valueOf(cloudVideoDownloadInfo2.isAlarm));
                ArrayList arrayList5 = arrayList4;
                arrayList5.add(contentValues);
                arrayList3 = arrayList5;
                str10 = str10;
                str8 = str14;
                it = it2;
            }
            for (ContentValues contentValues2 : arrayList3) {
                gsy.O00000Oo("CloudVideoDownloadDBManager", "insert:" + contentValues2.get(str13) + " path:" + contentValues2.get("file_path"));
                sQLiteDatabase.insert(str, null, contentValues2);
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            super.onDowngrade(sQLiteDatabase, i, i2);
            if (i != i2) {
                gsy.O00000Oo("CloudVideoDownloadDBManager", "onDowngrade from:" + i + " to:" + i2);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS mijia_camera_cloud_video");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS mijia_camera_cloud_video_mp4");
                onCreate(sQLiteDatabase);
            }
        }
    }
}
