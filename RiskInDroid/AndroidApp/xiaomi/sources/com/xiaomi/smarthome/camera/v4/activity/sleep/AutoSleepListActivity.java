package com.xiaomi.smarthome.camera.v4.activity.sleep;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;

public class AutoSleepListActivity extends CameraBaseActivity implements View.OnClickListener {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_auto_sleep_list);
        initView();
    }

    private void initView() {
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.sleep_auto_setting);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        view.getId();
    }
}
