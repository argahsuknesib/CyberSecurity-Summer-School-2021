package com.sina.weibo.sdk.share;

import _m_j.dbt;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
            dbt.O00000Oo(com.mi.activity.BaseActivity.TAG, "onCreate fixOrientation when Oreo, result = ".concat(String.valueOf(fixOrientation())));
        }
        super.onCreate(bundle);
    }

    private boolean isTranslucentOrFloating() {
        boolean z = false;
        try {
            TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            boolean booleanValue = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                return booleanValue;
            } catch (Exception e) {
                boolean z2 = booleanValue;
                e = e;
                z = z2;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return z;
        }
    }

    private boolean fixOrientation() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setRequestedOrientation(int i) {
        if (Build.VERSION.SDK_INT != 26 || !isTranslucentOrFloating()) {
            super.setRequestedOrientation(i);
        } else {
            dbt.O00000Oo(com.mi.activity.BaseActivity.TAG, "avoid calling setRequestedOrientation when Oreo.");
        }
    }
}
