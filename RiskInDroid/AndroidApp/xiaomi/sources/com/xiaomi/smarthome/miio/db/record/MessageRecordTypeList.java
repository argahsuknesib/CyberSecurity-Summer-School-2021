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
import com.xiaomi.smarthome.miio.db.TypeListMsgDBHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class MessageRecordTypeList {
    @DatabaseField
    public String content;
    @DatabaseField
    public long homeId;
    @DatabaseField
    public long homeOwner;
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
    @DatabaseField(index = true)
    public String msgId;
    @DatabaseField
    public String params;
    @DatabaseField(index = true)
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

    public static boolean insert(MessageRecordTypeList messageRecordTypeList) {
        ServiceApplication.getAppContext();
        try {
            Dao<MessageRecordTypeList, Integer> O00000Oo = TypeListMsgDBHelper.O000000o().O00000Oo();
            messageRecordTypeList.userId = CoreApi.O000000o().O0000o0();
            O00000Oo.create((MessageRecord) messageRecordTypeList);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update() {
        ServiceApplication.getAppContext();
        try {
            Dao<MessageRecordTypeList, Integer> O00000Oo = TypeListMsgDBHelper.O000000o().O00000Oo();
            DeleteBuilder<MessageRecordTypeList, Integer> deleteBuilder = O00000Oo.deleteBuilder();
            deleteBuilder.where().eq("msgId", this.msgId);
            O00000Oo.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            O00000Oo.create((MessageRecord) this);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteThis() {
        ServiceApplication.getAppContext();
        try {
            Dao<MessageRecordTypeList, Integer> O00000Oo = TypeListMsgDBHelper.O000000o().O00000Oo();
            QueryBuilder<MessageRecordTypeList, Integer> queryBuilder = O00000Oo.queryBuilder();
            queryBuilder.where().eq("id", Integer.valueOf(this.id));
            MessageRecordTypeList queryForFirst = queryBuilder.queryForFirst();
            if (queryForFirst == null) {
                return true;
            }
            O00000Oo.delete((MessageRecord) queryForFirst);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<MessageRecordTypeList> queryAll() {
        ArrayList arrayList = new ArrayList();
        ServiceApplication.getAppContext();
        try {
            QueryBuilder<MessageRecordTypeList, Integer> queryBuilder = TypeListMsgDBHelper.O000000o().O00000Oo().queryBuilder();
            queryBuilder.where().eq("userId", CoreApi.O000000o().O0000o0());
            return queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static List<MessageRecordTypeList> queryAllByRange(long j, long j2) {
        ArrayList arrayList = new ArrayList();
        ServiceApplication.getAppContext();
        try {
            QueryBuilder<MessageRecordTypeList, Integer> queryBuilder = TypeListMsgDBHelper.O000000o().O00000Oo().queryBuilder();
            Where<MessageRecordTypeList, Integer> where = queryBuilder.where();
            where.eq("userId", CoreApi.O000000o().O0000o0());
            where.and().between("receiveTime", Long.valueOf(Math.min(j, j2)), Long.valueOf(Math.max(j, j2)));
            queryBuilder.orderBy("receiveTime", false);
            return queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static List<MessageRecordTypeList> queryAllByRange(long j, long j2, int i) {
        ArrayList arrayList = new ArrayList();
        ServiceApplication.getAppContext();
        try {
            QueryBuilder<MessageRecordTypeList, Integer> queryBuilder = TypeListMsgDBHelper.O000000o().O00000Oo().queryBuilder();
            Where<MessageRecordTypeList, Integer> where = queryBuilder.where();
            where.eq("userId", CoreApi.O000000o().O0000o0());
            where.and().between("receiveTime", Long.valueOf(Math.min(j, j2)), Long.valueOf(Math.max(j, j2)));
            queryBuilder.limit(Long.valueOf((long) i));
            queryBuilder.orderBy("receiveTime", false);
            return queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static boolean remove(String str, String str2, String str3) {
        ServiceApplication.getAppContext();
        try {
            Dao<MessageRecordTypeList, Integer> O00000Oo = TypeListMsgDBHelper.O000000o().O00000Oo();
            DeleteBuilder<MessageRecordTypeList, Integer> deleteBuilder = O00000Oo.deleteBuilder();
            deleteBuilder.where().eq("userId", str);
            O00000Oo.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(String str) {
        ServiceApplication.getAppContext();
        try {
            Dao<MessageRecordTypeList, Integer> O00000Oo = TypeListMsgDBHelper.O000000o().O00000Oo();
            DeleteBuilder<MessageRecordTypeList, Integer> deleteBuilder = O00000Oo.deleteBuilder();
            deleteBuilder.where().eq("msgId", str);
            O00000Oo.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean batchInsert(List<MessageRecordTypeList> list) {
        ServiceApplication.getAppContext();
        TypeListMsgDBHelper O000000o2 = TypeListMsgDBHelper.O000000o();
        SQLiteDatabase writableDatabase = O000000o2.getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            Dao<MessageRecordTypeList, Integer> O00000Oo = O000000o2.O00000Oo();
            String O0000o0 = CoreApi.O000000o().O0000o0();
            for (MessageRecordTypeList next : list) {
                next.userId = O0000o0;
                O00000Oo.create((MessageRecord) next);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            writableDatabase.endTransaction();
            return false;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public static boolean batchDelete(List<String> list) {
        ServiceApplication.getAppContext();
        TypeListMsgDBHelper O000000o2 = TypeListMsgDBHelper.O000000o();
        SQLiteDatabase writableDatabase = O000000o2.getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            Dao<MessageRecordTypeList, Integer> O00000Oo = O000000o2.O00000Oo();
            for (String eq : list) {
                DeleteBuilder<MessageRecordTypeList, Integer> deleteBuilder = O00000Oo.deleteBuilder();
                deleteBuilder.where().eq("userId", CoreApi.O000000o().O0000o0()).and().eq("msgId", eq);
                O00000Oo.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            writableDatabase.endTransaction();
            return false;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public static boolean deleteAll() {
        ServiceApplication.getAppContext();
        try {
            Dao<MessageRecordTypeList, Integer> O00000Oo = TypeListMsgDBHelper.O000000o().O00000Oo();
            DeleteBuilder<MessageRecordTypeList, Integer> deleteBuilder = O00000Oo.deleteBuilder();
            deleteBuilder.where().eq("userId", CoreApi.O000000o().O0000o0());
            O00000Oo.delete((PreparedDelete<MessageRecord>) deleteBuilder.prepare());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static MessageRecordTypeList copy(MessageRecord messageRecord) {
        MessageRecordTypeList messageRecordTypeList = new MessageRecordTypeList();
        messageRecordTypeList.msgId = messageRecord.msgId;
        messageRecordTypeList.userId = messageRecord.userId;
        messageRecordTypeList.senderUserId = messageRecord.senderUserId;
        messageRecordTypeList.messageType = messageRecord.messageType;
        messageRecordTypeList.receiveTime = messageRecord.receiveTime;
        messageRecordTypeList.title = messageRecord.title;
        messageRecordTypeList.content = messageRecord.content;
        messageRecordTypeList.img_url = messageRecord.img_url;
        messageRecordTypeList.params = messageRecord.params;
        messageRecordTypeList.valid = messageRecord.valid;
        messageRecordTypeList.result = messageRecord.result;
        messageRecordTypeList.is_new = messageRecord.is_new;
        messageRecordTypeList.is_read = messageRecord.is_read;
        messageRecordTypeList.status = messageRecord.status;
        return messageRecordTypeList;
    }

    public MessageRecord toMsgRecord() {
        MessageRecord messageRecord = new MessageRecord();
        messageRecord.msgId = this.msgId;
        messageRecord.userId = this.userId;
        messageRecord.senderUserId = this.senderUserId;
        messageRecord.messageType = this.messageType;
        messageRecord.receiveTime = this.receiveTime;
        messageRecord.title = this.title;
        messageRecord.content = this.content;
        messageRecord.img_url = this.img_url;
        messageRecord.params = this.params;
        messageRecord.valid = this.valid;
        messageRecord.result = this.result;
        messageRecord.is_new = this.is_new;
        messageRecord.is_read = this.is_read;
        messageRecord.status = this.status;
        messageRecord.homeId = this.homeId;
        messageRecord.homeOwner = this.homeOwner;
        return messageRecord;
    }

    public static MessageRecordTypeList parseMessageRecord(JSONObject jSONObject) {
        JSONObject optJSONObject;
        MessageRecordTypeList messageRecordTypeList = new MessageRecordTypeList();
        messageRecordTypeList.userId = jSONObject.optString("uid");
        messageRecordTypeList.msgId = jSONObject.optString("msg_id");
        messageRecordTypeList.senderUserId = jSONObject.optString("sender_uid");
        messageRecordTypeList.messageType = jSONObject.optString("type");
        messageRecordTypeList.receiveTime = Long.valueOf(jSONObject.optString("last_modify")).longValue();
        messageRecordTypeList.title = jSONObject.optString("title");
        messageRecordTypeList.content = jSONObject.optString("content");
        messageRecordTypeList.img_url = jSONObject.optString("img_url");
        messageRecordTypeList.valid = jSONObject.optString("valid");
        messageRecordTypeList.is_new = jSONObject.optString("is_new");
        messageRecordTypeList.is_read = jSONObject.optString("is_read");
        if (jSONObject.has("status")) {
            messageRecordTypeList.status = jSONObject.optInt("status");
        }
        if (!jSONObject.isNull("params") && (optJSONObject = jSONObject.optJSONObject("params")) != null) {
            messageRecordTypeList.params = optJSONObject.toString();
        }
        messageRecordTypeList.homeId = jSONObject.optLong("home_id", 0);
        messageRecordTypeList.homeOwner = jSONObject.optLong("home_owner", 0);
        return messageRecordTypeList;
    }
}
