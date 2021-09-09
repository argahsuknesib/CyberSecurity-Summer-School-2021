package com.xiaomi.smarthome.uwb;

import _m_j.ftd;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateConfig;
import com.xiaomi.miot.localtranslatesrv.database.DatabaseExecutor;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class TranslateRuleDBHelper implements DatabaseExecutor {
    private SQLiteDatabase databaseConnection;
    File databaseFilename = UwbSdk.getApplication().getDatabasePath("translaterules-2021-07-16.db");

    public TranslateRuleDBHelper(Context context) {
        if (!this.databaseFilename.exists()) {
            try {
                ftd.O000000o(context, "translaterules-2021-07-16.db", this.databaseFilename.getPath());
            } catch (IOException e) {
                Log.e("TranslateRuleDBHelper", "TranslateRuleDBHelper ", e);
            }
        }
        this.databaseConnection = SQLiteDatabase.openDatabase(this.databaseFilename.getPath(), null, 1);
    }

    public String getSpecTypeByModel(String str) {
        String str2;
        try {
            if (this.databaseConnection != null) {
                Cursor rawQuery = this.databaseConnection.rawQuery(str, null);
                if (rawQuery.getCount() <= 0) {
                    return null;
                }
                str2 = null;
                while (rawQuery.moveToNext()) {
                    try {
                        str2 = rawQuery.getString(rawQuery.getColumnIndex("SrcId"));
                    } catch (Exception e) {
                        e = e;
                        Log.e("TranslateRuleDBHelper", "getSpecTypeByModel ".concat(String.valueOf(str)), e);
                        return null;
                    }
                }
                return str2;
            }
            throw new Exception("database connection object is null ! ");
        } catch (Exception e2) {
            e = e2;
            str2 = null;
            Log.e("TranslateRuleDBHelper", "getSpecTypeByModel ".concat(String.valueOf(str)), e);
            if (str2 == null || str2.length() <= 0) {
            }
            return null;
        }
    }

    public TranslateConfig queryTranslateConfig(String str) {
        TranslateConfig translateConfig;
        Exception e;
        try {
            if (this.databaseConnection != null) {
                Cursor rawQuery = this.databaseConnection.rawQuery(str, null);
                if (rawQuery.getCount() <= 0) {
                    return null;
                }
                translateConfig = new TranslateConfig();
                while (rawQuery.moveToNext()) {
                    try {
                        translateConfig.setSrcId(parserStringNull(rawQuery.getString(rawQuery.getColumnIndex("SrcId"))));
                        translateConfig.setSrcKey(parserStringNull(rawQuery.getString(rawQuery.getColumnIndex("SrcKey"))));
                        translateConfig.setSrcType(rawQuery.getInt(rawQuery.getColumnIndex("SrcType")));
                        translateConfig.setSrcValueTranslateExpression(parserStringNull(rawQuery.getString(rawQuery.getColumnIndex("SrcValueTranslateExpression"))));
                        translateConfig.setAdditionalMethod(parserStringNull(rawQuery.getString(rawQuery.getColumnIndex("AdditionalMethod"))));
                        translateConfig.setMetaData(parserStringNull(rawQuery.getString(rawQuery.getColumnIndex("MetaData"))));
                        translateConfig.setTargetId(parserStringNull(rawQuery.getString(rawQuery.getColumnIndex("TargetId"))));
                        translateConfig.setTargetKey(parserStringNull(rawQuery.getString(rawQuery.getColumnIndex("TargetKey"))));
                        translateConfig.setTargetType(rawQuery.getInt(rawQuery.getColumnIndex("TargetType")));
                        translateConfig.setValueTranslateType(rawQuery.getInt(rawQuery.getColumnIndex("ValueTranslateType")));
                        translateConfig.setTargetValueTranslateExpression(parserStringNull(rawQuery.getString(rawQuery.getColumnIndex("TargetValueTranslateExpression"))));
                        translateConfig.setStatus(rawQuery.getInt(rawQuery.getColumnIndex("Status")));
                    } catch (Exception e2) {
                        e = e2;
                        Log.e("TranslateRuleDBHelper", "queryTranslateConfig ".concat(String.valueOf(str)), e);
                        return translateConfig;
                    }
                }
                return translateConfig;
            }
            throw new Exception();
        } catch (Exception e3) {
            translateConfig = null;
            e = e3;
            Log.e("TranslateRuleDBHelper", "queryTranslateConfig ".concat(String.valueOf(str)), e);
            return translateConfig;
        }
    }

    public boolean hasTargetModel(String str) throws SQLException {
        return tryExecuteQueryString(str);
    }

    public boolean hasTranslateRule(String str) throws SQLException {
        return tryExecuteQueryString(str);
    }

    private boolean tryExecuteQueryString(String str) throws SQLException {
        try {
            String str2 = null;
            Cursor rawQuery = this.databaseConnection.rawQuery(str, null);
            if (rawQuery.moveToNext()) {
                str2 = rawQuery.getString(rawQuery.getColumnIndex("model"));
            }
            return str2 != null;
        } catch (Throwable th) {
            Log.e("TranslateRuleDBHelper", "queryTranslateConfig ".concat(String.valueOf(str)), th);
            throw new SQLException("statement create failed ! ");
        }
    }

    private String parserStringNull(Object obj) {
        if (obj != null && String.valueOf(obj).length() > 0) {
            return String.valueOf(obj);
        }
        return null;
    }

    public void closeConnection() {
        SQLiteDatabase sQLiteDatabase = this.databaseConnection;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.databaseConnection = null;
        }
    }
}
