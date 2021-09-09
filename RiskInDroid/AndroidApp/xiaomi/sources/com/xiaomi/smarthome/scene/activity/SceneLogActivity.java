package com.xiaomi.smarthome.scene.activity;

import _m_j.ggb;
import _m_j.hxi;
import _m_j.hxp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class SceneLogActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_scene_log_layout);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneLogActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SceneLogActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.smarthome_new_scene_log);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("device_id");
        intent.getStringExtra("from");
        Bundle bundle2 = new Bundle();
        bundle2.putString("device_id", stringExtra);
        getSupportFragmentManager().O000000o((int) R.id.fragment_scene_log).setArguments(bundle2);
    }

    public void onResume() {
        super.onResume();
        hxp hxp = hxi.O00000o0;
        String O0000OOo = ggb.O00000Oo().O0000OOo();
        hxp.f957O000000o.O000000o("scene_log_show", "homeid", O0000OOo);
    }
}
