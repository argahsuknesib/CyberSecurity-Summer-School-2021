package com.xiaomi.smarthome.miio.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.miio.db.record.MessageRecordTypeList;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class TypeListMsgDBHelper extends OrmLiteSqliteOpenHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    private static TypeListMsgDBHelper f9712O000000o;
    private static final Object O00000Oo = new Object();
    private static final AtomicInteger O00000o = new AtomicInteger(0);
    private volatile Dao<MessageRecordTypeList, Integer> O00000o0 = null;

    public TypeListMsgDBHelper(Context context) {
        super(context, "typelist.db", null, 1);
        try {
            TableUtils.createTableIfNotExists(this.connectionSource, MessageRecordTypeList.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static TypeListMsgDBHelper O000000o() {
        synchronized (O00000Oo) {
            if (f9712O000000o == null) {
                f9712O000000o = new TypeListMsgDBHelper(ServiceApplication.getAppContext());
            }
            O00000o.incrementAndGet();
        }
        return f9712O000000o;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, MessageRecordTypeList.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.table.TableUtils.dropTable(com.j256.ormlite.support.ConnectionSource, java.lang.Class, boolean):int
     arg types: [com.j256.ormlite.support.ConnectionSource, java.lang.Class, int]
     candidates:
      com.j256.ormlite.table.TableUtils.dropTable(com.j256.ormlite.support.ConnectionSource, com.j256.ormlite.table.DatabaseTableConfig, boolean):int
      com.j256.ormlite.table.TableUtils.dropTable(com.j256.ormlite.support.ConnectionSource, java.lang.Class, boolean):int */
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        try {
            TableUtils.dropTable(connectionSource, MessageRecordTypeList.class, true);
            onCreate(sQLiteDatabase, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        super.close();
    }

    public final Dao<MessageRecordTypeList, Integer> O00000Oo() throws SQLException {
        if (this.O00000o0 == null) {
            synchronized (MessageRecordTypeList.class) {
                if (this.O00000o0 == null) {
                    this.O00000o0 = getDao(MessageRecordTypeList.class);
                }
            }
        }
        return this.O00000o0;
    }
}
