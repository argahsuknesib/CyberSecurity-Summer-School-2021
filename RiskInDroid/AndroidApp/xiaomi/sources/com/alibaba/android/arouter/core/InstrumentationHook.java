package com.alibaba.android.arouter.core;

import _m_j.ny;
import _m_j.oe;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import java.lang.reflect.Field;

@Deprecated
public class InstrumentationHook extends Instrumentation {
    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String[] stringArrayExtra;
        Class<?> loadClass = classLoader.loadClass(str);
        Object newInstance = loadClass.newInstance();
        if (ny.O00000o0() && (stringArrayExtra = intent.getStringArrayExtra("wmHzgD4lOj5o4241")) != null && stringArrayExtra.length > 0) {
            for (String str2 : stringArrayExtra) {
                Object obj = intent.getExtras().get(oe.O000000o(str2));
                if (obj != null) {
                    try {
                        Field declaredField = loadClass.getDeclaredField(oe.O000000o(str2));
                        declaredField.setAccessible(true);
                        declaredField.set(newInstance, obj);
                    } catch (Exception e) {
                        ny.f2212O000000o.error("ARouter::", "Inject values for activity error! [" + e.getMessage() + "]");
                    }
                }
            }
        }
        return (Activity) newInstance;
    }
}
