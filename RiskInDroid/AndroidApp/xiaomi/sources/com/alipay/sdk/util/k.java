package com.alipay.sdk.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.cons.a;

public class k {
    public static String a(Context context) {
        if (EnvUtils.isSandBox()) {
            return "https://mobilegw.alipaydev.com/mgw.htm";
        }
        if (context == null) {
            return a.f3185a;
        }
        String str = a.f3185a;
        return TextUtils.isEmpty(str) ? a.f3185a : str;
    }

    private static String b(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.alipay.android.app.settings.data.ServerProvider/current_server"), null, null, null, null);
        String str = null;
        if (query != null && query.getCount() > 0) {
            if (query.moveToFirst()) {
                str = query.getString(query.getColumnIndex("url"));
            }
            query.close();
        }
        return str;
    }
}
