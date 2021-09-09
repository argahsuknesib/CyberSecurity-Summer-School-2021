package com.xiaomi.push.service;

import _m_j.elh;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

public class bg {

    /* renamed from: a  reason: collision with root package name */
    private static bg f6523a;

    /* renamed from: a  reason: collision with other field name */
    private int f286a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f287a;

    private bg(Context context) {
        this.f287a = context.getApplicationContext();
    }

    public static bg a(Context context) {
        if (f6523a == null) {
            f6523a = new bg(context);
        }
        return f6523a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i = this.f286a;
        if (i != 0) {
            return i;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.f286a = Settings.Global.getInt(this.f287a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception unused) {
            }
            return this.f286a;
        }
        this.f286a = Settings.Secure.getInt(this.f287a.getContentResolver(), "device_provisioned", 0);
        return this.f286a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m186a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m187a() {
        return elh.f15607O000000o.contains("xmsf") || elh.f15607O000000o.contains("xiaomi") || elh.f15607O000000o.contains("miui");
    }
}
