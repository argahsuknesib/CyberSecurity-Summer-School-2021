package com.xiaomi.smarthome.framework.page.rndebug;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fkl;
import _m_j.fvt;
import _m_j.fyc;
import _m_j.gfr;
import _m_j.hsi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class RnDebugClassifyActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private View.OnClickListener f7906O000000o = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugClassifyActivity.AnonymousClass2 */

        public final void onClick(View view) {
            int id = view.getId();
            if (id == R.id.layout_rn_debug) {
                fbs.O000000o(new fbt(RnDebugClassifyActivity.this, "DevSettingRnDebugListActivity"));
            } else if (id == R.id.layout_rn_plugin_demo) {
                fbt fbt = new fbt(RnDebugClassifyActivity.this, "LoadingRNActivity");
                fbt.O000000o("activity_start_from", 1002);
                fbt.O000000o(fvt.O00000oo, "mock.did.xiaomi.demo");
                fbt.O000000o(fvt.O0000O0o, MockRnDevicePluginManager.getInstance().getMockPluginDownloadUrl("mock.did.xiaomi.demo"));
                fbt.O000000o("pageName", "OfficialDemos");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("isBackToMainPage", Boolean.FALSE);
                } catch (JSONException unused) {
                }
                fbt.O000000o("pageParams", jSONObject.toString());
                fbs.O000000o(fbt);
            } else if (id == R.id.layout_rn_plugin_feedback) {
                RnDebugClassifyActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://wj.qq.com/s2/5959632/96fc")));
            }
        }
    };
    @BindView(5419)
    View mViewRnDebug;
    @BindView(5421)
    View mViewRnFeedback;
    @BindView(5420)
    View mViewRnPluginDemo;
    @BindView(5539)
    TextView tvHeadTitle;
    @BindView(5535)
    View viewHeadLeft;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, RnDebugClassifyActivity.class));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_rn_debug_classify);
        ButterKnife.bind(this);
        this.viewHeadLeft.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugClassifyActivity.AnonymousClass1 */

            public final void onClick(View view) {
                RnDebugClassifyActivity.this.finish();
            }
        });
        this.tvHeadTitle.setText(getString(R.string.string_rn_debug_dev_setting));
        this.mViewRnDebug.setOnClickListener(this.f7906O000000o);
        this.mViewRnPluginDemo.setOnClickListener(this.f7906O000000o);
        this.mViewRnFeedback.setOnClickListener(this.f7906O000000o);
        try {
            String format = String.format(getString(R.string.version_name_string), getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            TextView textView = (TextView) findViewById(R.id.txt_app_version);
            fkl.O000000o();
            hsi.O000000o O000000o2 = fkl.O000000o(this);
            long j = O000000o2 != null ? O000000o2.f598O000000o : 111;
            if (gfr.O0000o00) {
                format = format + " " + getString(R.string.version_suffix_dev_publish);
            } else if (gfr.O0000o0o) {
                format = format + " 测试版";
            }
            textView.setText(String.format("%s,SDK:%d", format, Long.valueOf(j)));
        } catch (Exception e) {
            fyc.O000000o("RnDebugClassifyActivity", "getVersion info error：", e);
        }
    }
}
