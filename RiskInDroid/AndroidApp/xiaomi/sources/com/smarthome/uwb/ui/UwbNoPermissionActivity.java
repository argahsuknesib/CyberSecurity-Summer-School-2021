package com.smarthome.uwb.ui;

import _m_j.ddu;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gsy;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UIUtils;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;
import org.json.JSONObject;

public class UwbNoPermissionActivity extends UwbBaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f5671O000000o;
    TextView O00000Oo;
    UwbScanDevice O00000o;
    SimpleDraweeView O00000o0;

    public boolean needExitUwb() {
        return true;
    }

    public static void startUwbNoPermissionActivity(Context context, UwbScanDevice uwbScanDevice) {
        Intent intent = new Intent(context, UwbNoPermissionActivity.class);
        intent.putExtra("uwb_scan_device", uwbScanDevice.toJSON().toString());
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(17170444));
        try {
            this.O00000o = UwbScanDevice.parse(new JSONObject(getIntent().getStringExtra("uwb_scan_device")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        UwbLogUtil.w("UwbNoPermissionActivity", "UwbLogUtilPlus mUwbScanDevice: " + this.O00000o);
        if (this.O00000o == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_close_auth);
        this.f5671O000000o = (TextView) findViewById(R.id.device_distance_tv);
        this.f5671O000000o.setText((int) R.string.mj_uwb_uwb_no_permission);
        this.O00000o0 = (SimpleDraweeView) findViewById(R.id.device_iv);
        this.O00000Oo = (TextView) findViewById(R.id.device_tv);
        if (UwbDeviceUtil.isThirdTagDevice(this.O00000o)) {
            O000000o(getString(R.string.mj_uwb_third_tv_name));
            ((GenericDraweeHierarchy) this.O00000o0.getHierarchy()).setPlaceholderImage((int) R.drawable.hid_device_big);
        } else if (UwbDeviceUtil.isMitvDeviceTagType(this.O00000o)) {
            O000000o(getString(R.string.mj_uwb_mitv_name));
            ((GenericDraweeHierarchy) this.O00000o0.getHierarchy()).setPlaceholderImage((int) R.drawable.mitv_big_temp);
        } else {
            ddu.O000000o(String.valueOf(this.O00000o.getPid()), new fsm<ddu.O000000o, fso>() {
                /* class com.smarthome.uwb.ui.UwbNoPermissionActivity.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    ddu.O000000o o000000o = (ddu.O000000o) obj;
                    boolean z = false;
                    if (o000000o != null) {
                        UwbLogUtil.w("UwbNoPermissionActivity", "UwbLogUtilPlus UwbNoPermissionActivity image: " + o000000o.f14524O000000o + " name: " + o000000o.O00000o);
                        if (!TextUtils.isEmpty(o000000o.f14524O000000o)) {
                            UwbNoPermissionActivity.this.O00000o0.setImageURI(Uri.parse(o000000o.f14524O000000o));
                            z = true;
                        }
                        UwbNoPermissionActivity.this.O000000o(o000000o.O00000o);
                    }
                    if (!z && UwbDeviceUtil.isTagDeviceType(UwbNoPermissionActivity.this.O00000o.getDeviceType()) && 5662 == UwbNoPermissionActivity.this.O00000o.getPid()) {
                        UwbNoPermissionActivity uwbNoPermissionActivity = UwbNoPermissionActivity.this;
                        uwbNoPermissionActivity.O000000o(uwbNoPermissionActivity.getString(R.string.mj_uwb_tag_name));
                        UwbNoPermissionActivity.this.O00000o0.setImageURI(Uri.parse(new StringBuilder("res://com.xiaomi.smarthome.uwb.lib/2132087608").toString()));
                    }
                }

                public final void onFailure(fso fso) {
                    gsy.O000000o(3, "UwbNoPermissionActivity", "CloseAuthActivity can not get image!!!");
                }
            });
        }
        UIUtils.initBottomMargin(this, findViewById(R.id.button3));
        View findViewById = findViewById(R.id.bottom_rl);
        findViewById.setVisibility(0);
        findViewById.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            /* class com.smarthome.uwb.ui.UwbNoPermissionActivity.AnonymousClass2 */

            public final void onClick(View view) {
                UwbNoPermissionActivity.this.finish();
            }
        });
        findViewById(R.id.uwb_back).setOnClickListener(new View.OnClickListener() {
            /* class com.smarthome.uwb.ui.UwbNoPermissionActivity.AnonymousClass3 */

            public final void onClick(View view) {
                UwbNoPermissionActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        this.O00000Oo.setText(str);
        this.O00000Oo.setBackground(null);
    }
}
