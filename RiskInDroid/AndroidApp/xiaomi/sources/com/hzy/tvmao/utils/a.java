package com.hzy.tvmao.utils;

import android.text.TextUtils;
import com.hzy.tvmao.model.legacy.api.f;
import java.io.IOException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4470a = true;

    public static String a(Object obj) {
        try {
            return f.a().b().O000000o(obj);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T a(Class<T> cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return f.a().b().O000000o(str, cls);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
