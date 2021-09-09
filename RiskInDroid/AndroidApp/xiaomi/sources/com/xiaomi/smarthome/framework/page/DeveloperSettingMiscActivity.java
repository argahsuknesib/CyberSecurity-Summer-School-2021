package com.xiaomi.smarthome.framework.page;

import _m_j.gqg;
import _m_j.gsy;
import _m_j.hsi;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import java.util.Arrays;
import java.util.Set;

public class DeveloperSettingMiscActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private SwitchButton f7664O000000o;
    public boolean mThreadDumpFlag = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.developer_setting_misc_list_activity);
        findViewById(R.id.clear_common_use).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeveloperSettingMiscActivity.AnonymousClass1 */

            public final void onClick(View view) {
            }
        });
        findViewById(R.id.dump_threads).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeveloperSettingMiscActivity.AnonymousClass2 */

            public final void onClick(View view) {
                DeveloperSettingMiscActivity developerSettingMiscActivity = DeveloperSettingMiscActivity.this;
                developerSettingMiscActivity.mThreadDumpFlag = !developerSettingMiscActivity.mThreadDumpFlag;
                DeveloperSettingMiscActivity developerSettingMiscActivity2 = DeveloperSettingMiscActivity.this;
                developerSettingMiscActivity2.dumpThreadInfo(developerSettingMiscActivity2.mThreadDumpFlag);
            }
        });
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeveloperSettingMiscActivity.AnonymousClass3 */

            public final void onClick(View view) {
                DeveloperSettingMiscActivity.this.finish();
            }
        });
        this.f7664O000000o = (SwitchButton) findViewById(R.id.swb_rn_plugin_time_total);
        this.f7664O000000o.setChecked(hsi.O00000Oo());
        this.f7664O000000o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.DeveloperSettingMiscActivity.AnonymousClass4 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O00000Oo("RnPluginTimeToal", "RnPluginTimeToal isChecked: ".concat(String.valueOf(z)));
                hsi.O000000o(z);
            }
        });
    }

    public void dumpThreadInfo(boolean z) {
        Set<Thread> keySet = Thread.getAllStackTraces().keySet();
        if (keySet == null || keySet.isEmpty()) {
            gqg.O00000Oo("empty threads set");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("threads:" + keySet.size() + "\n");
        for (Thread next : keySet) {
            sb.append(next.getName() + "\n");
            if (!z) {
                sb.append(Arrays.toString(next.getStackTrace()) + "\n");
            }
            sb.append("==========================\n\n");
        }
        TextView textView = new TextView(getContext());
        textView.setText(sb.toString());
        textView.setTextColor(-16777216);
        textView.setTextIsSelectable(true);
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        new MLAlertDialog.Builder(getContext()).O000000o(scrollView).O00000oo();
    }
}
