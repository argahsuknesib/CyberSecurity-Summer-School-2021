package com.xiaomi.smarthome.miio.activity;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.flk;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.gwc;
import _m_j.gwg;
import _m_j.hsk;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Locale;

public class GDPRLicenseActivity extends CommonActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f9670O000000o;

    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        gwg.O00000Oo(getWindow());
        overridePendingTransition(R.anim.activity_slide_in_right, R.anim.activity_slide_out_left);
        setContentView((int) R.layout.activity_license_and_privacy);
        this.f9670O000000o = getIntent().getStringExtra("key_model");
        if (TextUtils.isEmpty(this.f9670O000000o)) {
            gsy.O000000o(LogType.GENERAL, "", "GDPRLicenseActivity model is null");
            finish();
            return;
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.GDPRLicenseActivity.AnonymousClass1 */

            public final void onClick(View view) {
                GDPRLicenseActivity.this.finish();
            }
        });
        findViewById(R.id.cancel_license).setVisibility(8);
        findViewById(R.id.bottom_divider).setVisibility(8);
        findViewById(R.id.list_space2).setVisibility(8);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.device_more_activity_license_privacy));
        findViewById(R.id.license).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.GDPRLicenseActivity.AnonymousClass2 */

            public final void onClick(View view) {
                GDPRLicenseActivity gDPRLicenseActivity = GDPRLicenseActivity.this;
                gDPRLicenseActivity.showWebView(1, gDPRLicenseActivity.getString(R.string.device_more_activity_license));
            }
        });
        findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.GDPRLicenseActivity.AnonymousClass3 */

            public final void onClick(View view) {
                GDPRLicenseActivity gDPRLicenseActivity = GDPRLicenseActivity.this;
                gDPRLicenseActivity.showWebView(2, gDPRLicenseActivity.getString(R.string.device_more_activity_privacy));
            }
        });
    }

    public void onContentChanged() {
        super.onContentChanged();
        gwg.O00000o(this);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(gwc.O00000Oo(context));
    }

    public void showWebView(int i, String str) {
        String str2;
        fbt fbt = new fbt(this, "SmartHomeWebActivity");
        Uri.Builder buildUpon = Uri.parse(hsk.O00000Oo(this) + "/app_page/argument.html?").buildUpon();
        buildUpon.appendQueryParameter("type", String.valueOf(i));
        buildUpon.appendQueryParameter("model", this.f9670O000000o);
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (O0000ooO == null) {
            str2 = "";
        } else {
            str2 = O0000ooO.O00000Oo;
        }
        buildUpon.appendQueryParameter("countryCode", str2);
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        buildUpon.appendQueryParameter("locale", flk.O000000o(O00oOooo).toLowerCase());
        String builder = buildUpon.toString();
        fbt.O000000o("title", str);
        fbt.O000000o("url", builder);
        fbs.O000000o(fbt);
    }
}
