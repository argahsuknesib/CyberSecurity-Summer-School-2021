package com.xiaomi.smarthome.miio.db.record;

import _m_j.gsy;
import _m_j.hsx;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.db.BaseDBRecord;
import com.xiaomi.smarthome.miio.db.MiioDBHelper;
import java.sql.SQLException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareUserRecord extends BaseDBRecord {
    @DatabaseField
    public String birth;
    @DatabaseField
    public String email;
    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField
    public String localPath;
    @DatabaseField
    public String nickName;
    @DatabaseField
    public String phone;
    @DatabaseField
    public String sex;
    @DatabaseField
    public long shareTime;
    @DatabaseField
    public String url;
    @DatabaseField
    public String userId;

    public UserInfo createUserInfo() {
        UserInfo userInfo = new UserInfo();
        String str = this.nickName;
        userInfo.O00000Oo = str;
        userInfo.f7549O000000o = this.userId;
        userInfo.O00000o0 = this.url;
        userInfo.O00000o = "";
        userInfo.O00000oO = str;
        userInfo.O00000oo = 0;
        userInfo.O0000O0o = 0;
        return userInfo;
    }

    public static void insert(List<hsx> list) {
        if (list != null) {
            for (hsx insert : list) {
                insert(insert);
            }
        }
    }

    public static boolean batchInsert(List<hsx> list) {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        SQLiteDatabase writableDatabase = instance.getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            Dao<ShareUserRecord, Integer> shareUserRecordDao = instance.getShareUserRecordDao();
            String O0000o0 = CoreApi.O000000o().O0000o0();
            for (hsx next : list) {
                ShareUserRecord shareUserRecord = get(next.f607O000000o);
                if (shareUserRecord != null) {
                    shareUserRecord.nickName = next.O00000Oo;
                    shareUserRecord.url = next.O00000o0;
                    if (next.O00000o > 0) {
                        shareUserRecord.shareTime = next.O00000o;
                    }
                    shareUserRecord.userId = O0000o0;
                    shareUserRecordDao.create((MessageRecord) shareUserRecord);
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            instance.release();
            return true;
        } catch (SQLException unused) {
            writableDatabase.endTransaction();
            instance.release();
            return false;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            instance.release();
            throw th;
        }
    }

    public static boolean insert(hsx hsx) {
        ShareUserRecord shareUserRecord;
        if (hsx == null || (shareUserRecord = get(hsx.f607O000000o)) == null) {
            return false;
        }
        shareUserRecord.nickName = hsx.O00000Oo;
        shareUserRecord.url = hsx.O00000o0;
        if (hsx.O00000o > 0) {
            shareUserRecord.shareTime = hsx.O00000o;
        }
        return insert(shareUserRecord);
    }

    public static boolean insert(ShareUserRecord shareUserRecord) {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            Dao<ShareUserRecord, Integer> shareUserRecordDao = instance.getShareUserRecordDao();
            QueryBuilder<ShareUserRecord, Integer> queryBuilder = shareUserRecordDao.queryBuilder();
            queryBuilder.where().eq("userId", shareUserRecord.userId);
            List<ShareUserRecord> query = queryBuilder.query();
            if (query != null) {
                shareUserRecordDao.delete(query);
            }
            if (shareUserRecord.shareTime == 0) {
                shareUserRecord.shareTime = System.currentTimeMillis() / 1000;
            }
            shareUserRecordDao.create((MessageRecord) shareUserRecord);
            instance.release();
            return true;
        } catch (SQLException unused) {
            instance.release();
            return false;
        } catch (Exception unused2) {
            instance.release();
            return false;
        } catch (Throwable th) {
            instance.release();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        r0.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        r5 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037 A[ExcHandler: all (r5v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
    public static ShareUserRecord get(String str) {
        ShareUserRecord shareUserRecord;
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            QueryBuilder<ShareUserRecord, Integer> queryBuilder = instance.getShareUserRecordDao().queryBuilder();
            queryBuilder.where().eq("userId", str);
            List<ShareUserRecord> query = queryBuilder.query();
            if (query == null || query.size() <= 0) {
                ShareUserRecord shareUserRecord2 = new ShareUserRecord();
                shareUserRecord2.userId = str;
                shareUserRecord = shareUserRecord2;
                instance.release();
                return shareUserRecord;
            }
            shareUserRecord = query.get(0);
            instance.release();
            return shareUserRecord;
        } catch (Exception | SQLException unused) {
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: finally extract failed */
    public static List<ShareUserRecord> queryAll() {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            List<ShareUserRecord> query = instance.getShareUserRecordDao().queryBuilder().orderBy("shareTime", false).query();
            instance.release();
            return query;
        } catch (SQLException unused) {
            instance.release();
            return null;
        } catch (Throwable th) {
            instance.release();
            throw th;
        }
    }

    public static boolean deleteAll(ShareUserRecord shareUserRecord) {
        MiioDBHelper miioDBHelper = null;
        try {
            miioDBHelper = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
            miioDBHelper.getShareUserRecordDao();
            if (miioDBHelper == null) {
                return true;
            }
            miioDBHelper.release();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (miioDBHelper == null) {
                return false;
            }
            miioDBHelper.release();
            return false;
        } catch (Throwable th) {
            if (miioDBHelper != null) {
                miioDBHelper.release();
            }
            throw th;
        }
    }

    public static boolean batchDelete(List<String> list) {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        SQLiteDatabase writableDatabase = instance.getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            Dao<ShareUserRecord, Integer> shareUserRecordDao = instance.getShareUserRecordDao();
            for (String eq : list) {
                DeleteBuilder<ShareUserRecord, Integer> deleteBuilder = shareUserRecordDao.deleteBuilder();
                deleteBuilder.where().eq("userId", eq);
                shareUserRecordDao.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            instance.release();
            return true;
        } catch (Exception | SQLException unused) {
            writableDatabase.endTransaction();
            instance.release();
            return false;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            instance.release();
            throw th;
        }
    }

    public JSONObject getSyncDownJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "device");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: finally extract failed */
    public static int update(ShareUserRecord shareUserRecord) {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            UpdateBuilder<ShareUserRecord, Integer> updateBuilder = instance.getShareUserRecordDao().updateBuilder();
            updateBuilder.where().eq("userId", shareUserRecord.userId);
            if (!TextUtils.isEmpty(shareUserRecord.url)) {
                updateBuilder.updateColumnValue("url", shareUserRecord.url);
            }
            if (!TextUtils.isEmpty(shareUserRecord.nickName)) {
                updateBuilder.updateColumnValue("nickName", shareUserRecord.nickName);
            }
            if (!TextUtils.isEmpty(shareUserRecord.phone)) {
                updateBuilder.updateColumnValue("phone", shareUserRecord.phone);
            }
            if (!TextUtils.isEmpty(shareUserRecord.email)) {
                updateBuilder.updateColumnValue("email", shareUserRecord.email);
            }
            if (!TextUtils.isEmpty(shareUserRecord.sex)) {
                updateBuilder.updateColumnValue("sex", shareUserRecord.sex);
            }
            if (!TextUtils.isEmpty(shareUserRecord.birth)) {
                updateBuilder.updateColumnValue("birth", shareUserRecord.birth);
            }
            int update = updateBuilder.update();
            instance.release();
            return update;
        } catch (Exception e) {
            gsy.O00000o0(LogType.GENERAL, "", e.getMessage());
            instance.release();
            return 0;
        } catch (Throwable th) {
            instance.release();
            throw th;
        }
    }
}
