package com.xiaomi.smarthome.framework.plugin.rn.ota.nodrc.dfu;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;

public class NotificationActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ReactInstanceManager f8460O000000o;

    public Class getMainActivityClass(ReactContext reactContext) {
        try {
            return Class.forName(reactContext.getPackageManager().getLaunchIntentForPackage(reactContext.getPackageName()).getComponent().getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isTaskRoot()) {
            this.f8460O000000o = ((ReactApplication) getApplication()).getReactNativeHost().getReactInstanceManager();
            Intent intent = new Intent(this, getMainActivityClass(this.f8460O000000o.getCurrentReactContext()));
            intent.addFlags(268435456);
            intent.putExtras(getIntent().getExtras());
            startActivity(intent);
        }
        finish();
    }
}
