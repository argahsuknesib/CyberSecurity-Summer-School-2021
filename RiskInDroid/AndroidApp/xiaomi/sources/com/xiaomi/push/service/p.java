package com.xiaomi.push.service;

import _m_j.eml;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static p f6571a;

    /* renamed from: a  reason: collision with other field name */
    private Context f343a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f344a = new ArrayList();
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();

    private p(Context context) {
        this.f343a = context.getApplicationContext();
        if (this.f343a == null) {
            this.f343a = context;
        }
        SharedPreferences sharedPreferences = this.f343a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f344a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.c.add(str3);
            }
        }
    }

    public static p a(Context context) {
        if (f6571a == null) {
            f6571a = new p(context);
        }
        return f6571a;
    }

    public void a(String str) {
        synchronized (this.f344a) {
            if (!this.f344a.contains(str)) {
                this.f344a.add(str);
                this.f343a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", eml.O000000o(this.f344a, ",")).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m225a(String str) {
        boolean contains;
        synchronized (this.f344a) {
            contains = this.f344a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.b) {
            if (!this.b.contains(str)) {
                this.b.add(str);
                this.f343a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", eml.O000000o(this.b, ",")).commit();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m226b(String str) {
        boolean contains;
        synchronized (this.b) {
            contains = this.b.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.f343a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", eml.O000000o(this.c, ",")).commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m227c(String str) {
        boolean contains;
        synchronized (this.c) {
            contains = this.c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f344a) {
            if (this.f344a.contains(str)) {
                this.f344a.remove(str);
                this.f343a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", eml.O000000o(this.f344a, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.b) {
            if (this.b.contains(str)) {
                this.b.remove(str);
                this.f343a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", eml.O000000o(this.b, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.f343a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", eml.O000000o(this.c, ",")).commit();
            }
        }
    }
}
