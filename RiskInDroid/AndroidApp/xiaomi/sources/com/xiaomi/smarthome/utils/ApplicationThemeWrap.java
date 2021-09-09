package com.xiaomi.smarthome.utils;

import _m_j.dxw;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Method;

public class ApplicationThemeWrap extends Application {

    /* renamed from: O000000o  reason: collision with root package name */
    private Resources.Theme f11910O000000o;
    private LayoutInflater O00000Oo;
    private Resources O00000o;
    private Configuration O00000o0;
    private int O00000oO;

    public ApplicationThemeWrap(Context context) {
        attachBaseContext(context);
    }

    public ApplicationThemeWrap(Context context, Resources.Theme theme) {
        attachBaseContext(context);
        this.f11910O000000o = theme;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        dxw.O00000Oo().O000000o();
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return O000000o().getAssets();
    }

    public Resources getResources() {
        return O000000o();
    }

    private Resources O000000o() {
        if (this.O00000o == null) {
            Configuration configuration = this.O00000o0;
            if (configuration == null) {
                this.O00000o = super.getResources();
            } else {
                this.O00000o = createConfigurationContext(configuration).getResources();
            }
        }
        return this.O00000o;
    }

    public void setTheme(int i) {
        if (this.O00000oO != i) {
            this.O00000oO = i;
            O00000Oo();
        }
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f11910O000000o;
        if (theme != null) {
            return theme;
        }
        Class<Resources> cls = Resources.class;
        try {
            Method declaredMethod = cls.getDeclaredMethod("selectDefaultTheme", Integer.TYPE, Integer.TYPE);
            declaredMethod.setAccessible(true);
            this.O00000oO = ((Integer) declaredMethod.invoke(null, Integer.valueOf(this.O00000oO), Integer.valueOf(getApplicationInfo().targetSdkVersion))).intValue();
        } catch (Throwable th) {
            Log.e("ApplicationThemeWrap", "", th);
        }
        O00000Oo();
        return this.f11910O000000o;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.O00000Oo == null) {
            this.O00000Oo = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.O00000Oo;
    }

    private void O00000Oo() {
        if (this.f11910O000000o == null) {
            this.f11910O000000o = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f11910O000000o.setTo(theme);
            }
        }
        this.f11910O000000o.applyStyle(this.O00000oO, true);
    }
}
