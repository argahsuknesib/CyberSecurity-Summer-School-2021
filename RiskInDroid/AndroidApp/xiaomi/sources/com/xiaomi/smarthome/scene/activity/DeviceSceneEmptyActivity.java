package com.xiaomi.smarthome.scene.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class DeviceSceneEmptyActivity extends BaseActivity {
    @BindView(5822)
    ImageView mReturnIV;
    @BindView(5826)
    TextView mTitleTV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_scene_layout);
        ButterKnife.bind(this);
        this.mTitleTV.setText((int) R.string.scene_plugin_title);
        this.mReturnIV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.DeviceSceneEmptyActivity.AnonymousClass1 */

            public final void onClick(View view) {
                DeviceSceneEmptyActivity.this.finish();
            }
        });
    }
}
