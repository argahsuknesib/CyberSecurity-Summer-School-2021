package com.xiaomi.smarthome.device.api;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import java.lang.reflect.Field;

public class BaseFragment extends Fragment {
    XmPluginBaseActivity mXmPluginBaseActivity;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        initilXmPlugActivity(activity);
    }

    /* access modifiers changed from: package-private */
    public void initilXmPlugActivity(Activity activity) {
        Field field;
        Class<? super Object> superclass;
        try {
            field = activity.getClass().getDeclaredField("mXmPluginActivity");
        } catch (NoSuchFieldException unused) {
            field = null;
        }
        if (field == null && (superclass = activity.getClass().getSuperclass()) != null) {
            try {
                field = superclass.getDeclaredField("mXmPluginActivity");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        if (field != null) {
            try {
                field.setAccessible(true);
                this.mXmPluginBaseActivity = (XmPluginBaseActivity) field.get(activity);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public XmPluginBaseActivity xmPluginActivity() {
        return this.mXmPluginBaseActivity;
    }

    public void startActivityForResult(Intent intent, String str, int i) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginBaseActivity;
        if (xmPluginBaseActivity != null) {
            xmPluginBaseActivity.startActivityForResult(intent, str, i);
        }
    }
}
