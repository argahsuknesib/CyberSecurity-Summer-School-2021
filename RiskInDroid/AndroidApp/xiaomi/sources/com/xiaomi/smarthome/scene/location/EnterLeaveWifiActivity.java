package com.xiaomi.smarthome.scene.location;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class EnterLeaveWifiActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_enter_leave_wifi);
        findViewById(R.id.enter).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.location.EnterLeaveWifiActivity.AnonymousClass1 */

            public final void onClick(View view) {
                Intent intent = new Intent(EnterLeaveWifiActivity.this, ScenePoiSelectWifiActivity.class);
                intent.putExtra("mode", "enter");
                EnterLeaveWifiActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.leave).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.location.EnterLeaveWifiActivity.AnonymousClass2 */

            public final void onClick(View view) {
                Intent intent = new Intent(EnterLeaveWifiActivity.this, ScenePoiSelectWifiActivity.class);
                intent.putExtra("mode", "leave");
                EnterLeaveWifiActivity.this.startActivity(intent);
            }
        });
    }
}
