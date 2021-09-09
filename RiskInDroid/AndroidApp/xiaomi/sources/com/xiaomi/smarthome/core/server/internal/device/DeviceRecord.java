package com.xiaomi.smarthome.core.server.internal.device;

import android.database.Cursor;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceRecord {
    private static int INDEX_bssid;
    private static int INDEX_canAuth;
    private static int INDEX_canUseNotBind;
    private static int INDEX_comFlag;
    private static int INDEX_desc;
    private static int INDEX_descNew;
    private static int INDEX_descTimeJString;
    private static int INDEX_did;
    private static int INDEX_eventInfo;
    private static int INDEX_extraInfo;
    private static int INDEX_freqFlag;
    private static int INDEX_index;
    private static int INDEX_isOnline;
    private static int INDEX_latitude;
    private static int INDEX_localIP;
    private static int INDEX_location;
    private static int INDEX_longitude;
    private static int INDEX_mac;
    private static int INDEX_methodInfo;
    private static int INDEX_model;
    private static int INDEX_name;
    private static int INDEX_ownerId;
    private static int INDEX_ownerName;
    private static int INDEX_parentId;
    private static int INDEX_parentModel;
    private static int INDEX_permitLevel;
    private static int INDEX_pid;
    private static int INDEX_propInfo;
    private static int INDEX_resetFlag;
    private static int INDEX_rssi;
    private static int INDEX_showMode;
    private static int INDEX_specUrn;
    private static int INDEX_ssid;
    private static int INDEX_token;
    private static int INDEX_userId;
    private static int INDEX_version;
    private static int INDEX_voiceCtrl;
    private static boolean indexInited;
    @DatabaseField
    public String bssid;
    @DatabaseField
    public int canAuth;
    @DatabaseField
    public int canUseNotBind;
    @DatabaseField
    public int comFlag;
    @DatabaseField
    public String desc;
    @DatabaseField
    public String descNew;
    @DatabaseField
    public String descTimeJString;
    @DatabaseField
    public String did;
    @DatabaseField
    public String eventInfo;
    @DatabaseField
    public String extraInfo;
    @DatabaseField
    public boolean freqFlag;
    @DatabaseField(generatedId = true)
    public int index;
    @DatabaseField
    public int isOnline;
    @DatabaseField
    public double latitude;
    @DatabaseField
    public String localIP;
    @DatabaseField
    public int location;
    @DatabaseField
    public double longitude;
    @DatabaseField
    public String mac;
    @DatabaseField
    public String methodInfo;
    @DatabaseField
    public String model;
    @DatabaseField
    public String name;
    @DatabaseField
    public String ownerId;
    @DatabaseField
    public String ownerName;
    @DatabaseField
    public String parentId;
    @DatabaseField
    public String parentModel;
    @DatabaseField
    public int permitLevel;
    @DatabaseField
    public int pid;
    @DatabaseField
    public String propInfo;
    @DatabaseField
    public int resetFlag;
    @DatabaseField
    public int rssi;
    @DatabaseField
    public int showMode;
    @DatabaseField
    public String specUrn;
    @DatabaseField
    public String ssid;
    @DatabaseField
    public String token;
    @DatabaseField
    public String userId;
    @DatabaseField
    public String version;
    @DatabaseField
    public int voiceCtrl;

    public static boolean insert(DeviceRecord deviceRecord) {
        try {
            Dao<DeviceRecord, Integer> deviceRecordDao = MiioDBHelper.getsInstance(CommonApplication.getAppContext()).getDeviceRecordDao();
            QueryBuilder<DeviceRecord, Integer> queryBuilder = deviceRecordDao.queryBuilder();
            Where<DeviceRecord, Integer> where = queryBuilder.where();
            where.eq("userId", deviceRecord.userId);
            where.and();
            where.eq("did", deviceRecord.did);
            List<DeviceRecord> query = queryBuilder.query();
            if (query != null) {
                deviceRecordDao.delete(query);
            }
            deviceRecordDao.create((MessageRecord) deviceRecord);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteByUserId(String str) {
        try {
            Dao<DeviceRecord, Integer> deviceRecordDao = MiioDBHelper.getsInstance(CommonApplication.getAppContext()).getDeviceRecordDao();
            DeleteBuilder<DeviceRecord, Integer> deleteBuilder = deviceRecordDao.deleteBuilder();
            deleteBuilder.where().eq("userId", str);
            deviceRecordDao.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r1 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r1 == null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        _m_j.gsy.O000000o(3, "ABC", "query finish");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        return r0;
     */
    public static List<DeviceRecord> queryAllByUserId(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = MiioDBHelper.getsInstance(CommonApplication.getAppContext()).getReadableDatabase().rawQuery("select * from DeviceRecord where userId = ?", new String[]{str});
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    DeviceRecord readCursor = readCursor(cursor);
                    if (readCursor != null) {
                        arrayList.add(readCursor);
                    }
                    if (cursor == null) {
                        break;
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static DeviceRecord readCursor(Cursor cursor) {
        boolean z = true;
        if (!indexInited) {
            INDEX_index = cursor.getColumnIndex("index");
            INDEX_userId = cursor.getColumnIndex("userId");
            INDEX_did = cursor.getColumnIndex("did");
            INDEX_model = cursor.getColumnIndex("model");
            INDEX_name = cursor.getColumnIndex("name");
            INDEX_mac = cursor.getColumnIndex("mac");
            INDEX_isOnline = cursor.getColumnIndex("isOnline");
            INDEX_pid = cursor.getColumnIndex("pid");
            INDEX_permitLevel = cursor.getColumnIndex("permitLevel");
            INDEX_resetFlag = cursor.getColumnIndex("resetFlag");
            INDEX_rssi = cursor.getColumnIndex("rssi");
            INDEX_token = cursor.getColumnIndex("token");
            INDEX_localIP = cursor.getColumnIndex("localIP");
            INDEX_longitude = cursor.getColumnIndex("longitude");
            INDEX_latitude = cursor.getColumnIndex("latitude");
            INDEX_ssid = cursor.getColumnIndex("ssid");
            INDEX_bssid = cursor.getColumnIndex("bssid");
            INDEX_showMode = cursor.getColumnIndex("showMode");
            INDEX_desc = cursor.getColumnIndex("desc");
            INDEX_parentId = cursor.getColumnIndex("parentId");
            INDEX_parentModel = cursor.getColumnIndex("parentModel");
            INDEX_ownerName = cursor.getColumnIndex("ownerName");
            INDEX_ownerId = cursor.getColumnIndex("ownerId");
            INDEX_propInfo = cursor.getColumnIndex("propInfo");
            INDEX_methodInfo = cursor.getColumnIndex("methodInfo");
            INDEX_extraInfo = cursor.getColumnIndex("extraInfo");
            INDEX_eventInfo = cursor.getColumnIndex("eventInfo");
            INDEX_location = cursor.getColumnIndex("location");
            INDEX_version = cursor.getColumnIndex("version");
            INDEX_canUseNotBind = cursor.getColumnIndex("canUseNotBind");
            INDEX_canAuth = cursor.getColumnIndex("canAuth");
            INDEX_descNew = cursor.getColumnIndex("descNew");
            INDEX_descTimeJString = cursor.getColumnIndex("descTimeJString");
            INDEX_specUrn = cursor.getColumnIndex("specUrn");
            INDEX_voiceCtrl = cursor.getColumnIndex("voiceCtrl");
            INDEX_freqFlag = cursor.getColumnIndex("freqFlag");
            INDEX_comFlag = cursor.getColumnIndex("comFlag");
            indexInited = true;
        }
        DeviceRecord deviceRecord = new DeviceRecord();
        deviceRecord.index = cursor.getInt(INDEX_index);
        deviceRecord.userId = cursor.getString(INDEX_userId);
        deviceRecord.did = cursor.getString(INDEX_did);
        deviceRecord.model = cursor.getString(INDEX_model);
        deviceRecord.name = cursor.getString(INDEX_name);
        deviceRecord.mac = cursor.getString(INDEX_mac);
        deviceRecord.isOnline = cursor.getInt(INDEX_isOnline);
        deviceRecord.pid = cursor.getInt(INDEX_pid);
        deviceRecord.permitLevel = cursor.getInt(INDEX_permitLevel);
        deviceRecord.resetFlag = cursor.getInt(INDEX_resetFlag);
        deviceRecord.rssi = cursor.getInt(INDEX_rssi);
        deviceRecord.token = cursor.getString(INDEX_token);
        deviceRecord.localIP = cursor.getString(INDEX_localIP);
        deviceRecord.longitude = cursor.getDouble(INDEX_longitude);
        deviceRecord.latitude = cursor.getDouble(INDEX_latitude);
        deviceRecord.ssid = cursor.getString(INDEX_ssid);
        deviceRecord.bssid = cursor.getString(INDEX_bssid);
        deviceRecord.showMode = cursor.getInt(INDEX_showMode);
        deviceRecord.desc = cursor.getString(INDEX_desc);
        deviceRecord.parentId = cursor.getString(INDEX_parentId);
        deviceRecord.parentModel = cursor.getString(INDEX_parentModel);
        deviceRecord.ownerName = cursor.getString(INDEX_ownerName);
        deviceRecord.ownerId = cursor.getString(INDEX_ownerId);
        deviceRecord.propInfo = cursor.getString(INDEX_propInfo);
        deviceRecord.methodInfo = cursor.getString(INDEX_methodInfo);
        deviceRecord.extraInfo = cursor.getString(INDEX_extraInfo);
        deviceRecord.eventInfo = cursor.getString(INDEX_eventInfo);
        deviceRecord.location = cursor.getInt(INDEX_location);
        deviceRecord.version = cursor.getString(INDEX_version);
        deviceRecord.canUseNotBind = cursor.getInt(INDEX_canUseNotBind);
        deviceRecord.canAuth = cursor.getInt(INDEX_canAuth);
        deviceRecord.descNew = cursor.getString(INDEX_descNew);
        deviceRecord.descTimeJString = cursor.getString(INDEX_descTimeJString);
        deviceRecord.specUrn = cursor.getString(INDEX_specUrn);
        deviceRecord.voiceCtrl = cursor.getInt(INDEX_voiceCtrl);
        if (cursor.getInt(INDEX_freqFlag) <= 0) {
            z = false;
        }
        deviceRecord.freqFlag = z;
        deviceRecord.comFlag = cursor.getInt(INDEX_comFlag);
        return deviceRecord;
    }
}
