package com.xiaomi.push;

import _m_j.duv;
import _m_j.emg;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

@SuppressLint({"NewApi"})
public class ex extends Notification.Builder {
    protected Context O00000o0;

    public ex(Context context) {
        super(context);
        this.O00000o0 = context;
    }

    public static int O000000o(Resources resources, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return 0;
    }

    /* renamed from: O000000o */
    public final ex addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    /* renamed from: O000000o */
    public final ex setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
     arg types: [com.xiaomi.push.ex, java.lang.String, java.lang.Object[]]
     candidates:
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T */
    public final ex O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                emg.O000000o((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e) {
                duv.O00000o("fail to set color. ".concat(String.valueOf(e)));
            }
        }
        return this;
    }

    public ex O000000o(Map<String, String> map) {
        return this;
    }

    /* access modifiers changed from: protected */
    public void O00000o() {
    }

    public Notification build() {
        O00000o();
        return super.build();
    }
}
