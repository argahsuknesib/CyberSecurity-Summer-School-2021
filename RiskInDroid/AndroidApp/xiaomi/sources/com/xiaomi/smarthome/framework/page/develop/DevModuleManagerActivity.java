package com.xiaomi.smarthome.framework.page.develop;

import _m_j.fbs;
import _m_j.gpc;
import _m_j.gqg;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.List;

public class DevModuleManagerActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dev_module_manager_activity);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.$$Lambda$DevModuleManagerActivity$9tg3B0GZL3UyGs77oONqiWz7A */

            public final void onClick(View view) {
                DevModuleManagerActivity.this.O000000o(view);
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_content);
        List<String> O000000o2 = fbs.O000000o();
        gqg.O00000Oo("组件个数：" + O000000o2.size());
        for (String text : O000000o2) {
            TextView textView = new TextView(this);
            textView.setText(text);
            textView.setTextColor(-16777216);
            textView.setTextIsSelectable(true);
            textView.setPadding(gpc.O000000o(10.0f), gpc.O000000o(10.0f), gpc.O000000o(10.0f), gpc.O000000o(10.0f));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
    }
}
