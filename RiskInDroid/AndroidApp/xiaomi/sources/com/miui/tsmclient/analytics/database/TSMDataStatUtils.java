package com.miui.tsmclient.analytics.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.miui.tsmclient.analytics.entity.DataStatInfo;
import com.miui.tsmclient.database.DatabaseConstants;
import com.miui.tsmclient.util.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class TSMDataStatUtils {
    private static volatile TSMDataStatUtils sInstance;

    private TSMDataStatUtils() {
    }

    public static TSMDataStatUtils getInstance() {
        if (sInstance == null) {
            synchronized (TSMDataStatUtils.class) {
                if (sInstance == null) {
                    sInstance = new TSMDataStatUtils();
                }
            }
        }
        return sInstance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        return;
     */
    public synchronized void insertData(Context context, DataStatInfo dataStatInfo) {
        if (!(context == null || dataStatInfo == null)) {
            if (dataStatInfo.getDataID() > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("data_id", Integer.valueOf(dataStatInfo.getDataID()));
                contentValues.put("data_value", dataStatInfo.getDataValue());
                contentValues.put("data_time", dataStatInfo.getDataTime());
                try {
                    context.getContentResolver().insert(DatabaseConstants.CONTENT_URI_DATA_STAT, contentValues);
                } catch (Exception unused) {
                    LogUtils.w("TSMDataStatUtils insertData failed");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        return r0;
     */
    public synchronized List<DataStatInfo> getAllData(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(DatabaseConstants.CONTENT_URI_DATA_STAT, DatabaseConstants.PROJECTION_DATA_STAT_INFO, null, null, null);
        } catch (Exception unused) {
            LogUtils.w("TSMDataStatUtils getAllData failed");
        }
        if (cursor != null) {
            while (cursor.moveToNext()) {
                DataStatInfo dataStatInfo = new DataStatInfo();
                int columnIndex = cursor.getColumnIndex("data_id");
                if (columnIndex >= 0) {
                    dataStatInfo.setDataID(cursor.getInt(columnIndex));
                    int columnIndex2 = cursor.getColumnIndex("data_value");
                    if (columnIndex2 >= 0) {
                        dataStatInfo.setDataValue(cursor.getString(columnIndex2));
                    }
                    int columnIndex3 = cursor.getColumnIndex("data_time");
                    if (columnIndex3 >= 0) {
                        dataStatInfo.setDataTime(cursor.getString(columnIndex3));
                    } else {
                        dataStatInfo.setDataTime("");
                    }
                    arrayList.add(dataStatInfo);
                }
            }
            cursor.close();
        }
    }

    public synchronized int deleteAllData(Context context) {
        int i;
        i = 0;
        if (context != null) {
            try {
                i = context.getContentResolver().delete(DatabaseConstants.CONTENT_URI_DATA_STAT, null, null);
            } catch (Exception unused) {
                LogUtils.w("TSMDataStatUtils deleteAllData failed");
            }
        }
        LogUtils.i("delete all data stat, data count is ".concat(String.valueOf(i)));
        return i;
    }
}
