package com.xiaomi.smarthome.miio.db.record;

import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.db.MiioDBHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageRecordShop {
    @DatabaseField
    public String content;
    @DatabaseField(generatedId = false)
    public int id;
    @DatabaseField
    public String img_url;
    @DatabaseField
    public String is_new;
    @DatabaseField
    public String is_read;
    @DatabaseField
    public String messageType;
    @DatabaseField
    public String msgId;
    @DatabaseField
    public String params;
    @DatabaseField
    public long receiveTime;
    @DatabaseField
    public String result;
    @DatabaseField
    public String senderUserId;
    @DatabaseField
    public int status;
    @DatabaseField
    public String title;
    @DatabaseField
    public String userId;
    @DatabaseField
    public String valid;

    public static boolean insert(MessageRecordShop messageRecordShop) {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            Dao<MessageRecordShop, Integer> messageRecordShopDao = instance.getMessageRecordShopDao();
            messageRecordShop.userId = CoreApi.O000000o().O0000o0();
            messageRecordShopDao.create((MessageRecord) messageRecordShop);
            instance.release();
            return true;
        } catch (SQLException unused) {
            instance.release();
            return false;
        } catch (Throwable th) {
            instance.release();
            throw th;
        }
    }

    public boolean update() {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            Dao<MessageRecordShop, Integer> messageRecordShopDao = instance.getMessageRecordShopDao();
            DeleteBuilder<MessageRecordShop, Integer> deleteBuilder = messageRecordShopDao.deleteBuilder();
            deleteBuilder.where().eq("msgId", this.msgId);
            messageRecordShopDao.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            messageRecordShopDao.create((MessageRecord) this);
            instance.release();
            return true;
        } catch (SQLException unused) {
            instance.release();
            return false;
        } catch (Throwable th) {
            instance.release();
            throw th;
        }
    }

    public boolean deleteThis() {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            Dao<MessageRecordShop, Integer> messageRecordShopDao = instance.getMessageRecordShopDao();
            QueryBuilder<MessageRecordShop, Integer> queryBuilder = messageRecordShopDao.queryBuilder();
            queryBuilder.where().eq("id", Integer.valueOf(this.id));
            MessageRecordShop queryForFirst = queryBuilder.queryForFirst();
            if (queryForFirst != null) {
                messageRecordShopDao.delete((MessageRecord) queryForFirst);
            }
            instance.release();
            return true;
        } catch (SQLException unused) {
            instance.release();
            return false;
        } catch (Throwable th) {
            instance.release();
            throw th;
        }
    }

    public static List<MessageRecordShop> queryAll() {
        List<MessageRecordShop> arrayList = new ArrayList<>();
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            QueryBuilder<MessageRecordShop, Integer> queryBuilder = instance.getMessageRecordShopDao().queryBuilder();
            queryBuilder.where().eq("userId", CoreApi.O000000o().O0000o0());
            arrayList = queryBuilder.query();
        } catch (SQLException unused) {
        } catch (Throwable th) {
            instance.release();
            throw th;
        }
        instance.release();
        return arrayList;
    }

    public static boolean remove(String str, String str2, String str3) {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            Dao<MessageRecordShop, Integer> messageRecordShopDao = instance.getMessageRecordShopDao();
            DeleteBuilder<MessageRecordShop, Integer> deleteBuilder = messageRecordShopDao.deleteBuilder();
            deleteBuilder.where().eq("userId", str);
            messageRecordShopDao.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            instance.release();
            return true;
        } catch (SQLException unused) {
            instance.release();
            return false;
        } catch (Throwable th) {
            instance.release();
            throw th;
        }
    }

    public static boolean delete(String str) {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            Dao<MessageRecordShop, Integer> messageRecordShopDao = instance.getMessageRecordShopDao();
            DeleteBuilder<MessageRecordShop, Integer> deleteBuilder = messageRecordShopDao.deleteBuilder();
            deleteBuilder.where().eq("msgId", str);
            messageRecordShopDao.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            instance.release();
            return true;
        } catch (SQLException unused) {
            instance.release();
            return false;
        } catch (Throwable th) {
            instance.release();
            throw th;
        }
    }

    public static boolean batchInsert(List<MessageRecordShop> list) {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        SQLiteDatabase writableDatabase = instance.getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            Dao<MessageRecordShop, Integer> messageRecordShopDao = instance.getMessageRecordShopDao();
            String O0000o0 = CoreApi.O000000o().O0000o0();
            for (MessageRecordShop next : list) {
                next.userId = O0000o0;
                messageRecordShopDao.create((MessageRecord) next);
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

    public static boolean batchDelete(List<Integer> list) {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        SQLiteDatabase writableDatabase = instance.getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            Dao<MessageRecordShop, Integer> messageRecordShopDao = instance.getMessageRecordShopDao();
            for (Integer intValue : list) {
                DeleteBuilder<MessageRecordShop, Integer> deleteBuilder = messageRecordShopDao.deleteBuilder();
                Where<MessageRecordShop, Integer> and = deleteBuilder.where().eq("userId", CoreApi.O000000o().O0000o0()).and();
                StringBuilder sb = new StringBuilder();
                sb.append(intValue.intValue());
                and.eq("msgId", sb.toString());
                messageRecordShopDao.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
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

    public static boolean deleteAll() {
        MiioDBHelper instance = MiioDBHelper.getInstance(ServiceApplication.getAppContext());
        try {
            Dao<MessageRecordShop, Integer> messageRecordShopDao = instance.getMessageRecordShopDao();
            DeleteBuilder<MessageRecordShop, Integer> deleteBuilder = messageRecordShopDao.deleteBuilder();
            deleteBuilder.where().eq("userId", CoreApi.O000000o().O0000o0());
            messageRecordShopDao.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            instance.release();
            return true;
        } catch (SQLException unused) {
            instance.release();
            return false;
        } catch (Throwable th) {
            instance.release();
            throw th;
        }
    }
}
