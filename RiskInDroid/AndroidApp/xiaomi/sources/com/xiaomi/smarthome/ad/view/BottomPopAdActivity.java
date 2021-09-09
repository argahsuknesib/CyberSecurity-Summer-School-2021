package com.xiaomi.smarthome.ad.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.smarthome.ad.api.Advertisement;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class BottomPopAdActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private Advertisement f4158O000000o;

    public static void start(Activity activity, Advertisement advertisement) {
        Intent intent = new Intent(activity, BottomPopAdActivity.class);
        intent.putExtra("advertisement", advertisement);
        activity.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4158O000000o = (Advertisement) getIntent().getParcelableExtra("advertisement");
    }

    public void onResume() {
        super.onResume();
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
