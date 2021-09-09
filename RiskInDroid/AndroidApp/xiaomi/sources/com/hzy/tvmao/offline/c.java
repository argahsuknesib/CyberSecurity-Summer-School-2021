package com.hzy.tvmao.offline;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.hzy.tvmao.KookongSDK;
import com.hzy.tvmao.utils.LogUtil;
import com.lidroid.xutils.DbUtils;
import java.io.File;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4442a = (b().getFilesDir() + File.separator);
    private static int b = 7;

    private static Context b() {
        return KookongSDK.getContext();
    }

    public static DbUtils a() {
        try {
            File file = new File(f4442a + "kkoffline.db");
            int a2 = a(file);
            LogUtil.i("sdkDBVersion=" + b + "，localDBVersion=" + a2);
            if (b > a2) {
                LogUtil.d("sdk db version is newer than local db file in apk ：sdkDBVersion=" + b + ",localDBVersion=" + a2);
                StringBuilder sb = new StringBuilder();
                sb.append(f4442a);
                sb.append("kkoffline.db.tmp");
                a(sb.toString());
                File file2 = new File(f4442a + "kkoffline.db.tmp");
                int a3 = a(file2);
                LogUtil.d("sdkDBVersion=" + b + "，assetDBVersion=" + a3);
                if (b != a3) {
                    LogUtil.e("Error!!! : data not consistency, plz check kkoffline.db in assets and your sdk! sdkDBVersion=" + b + "，assetDBVersion=" + a3);
                    return null;
                }
                if (file.exists()) {
                    LogUtil.i("delete old db file： ".concat(String.valueOf(file.delete())));
                }
                file2.renameTo(file);
                a2 = b;
            }
            LogUtil.i("执行创建DBUtil currentDBVersion： ".concat(String.valueOf(a2)));
            return DbUtils.O000000o(b(), f4442a, "kkoffline.db", a2, new d());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int a(File file) {
        if (!file.exists()) {
            return -1;
        }
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        int version = openOrCreateDatabase.getVersion();
        openOrCreateDatabase.close();
        return version;
    }

    private static boolean a(String str) {
        LogUtil.d("copying db....");
        a.a("kkoffline.db", str);
        return true;
    }
}
