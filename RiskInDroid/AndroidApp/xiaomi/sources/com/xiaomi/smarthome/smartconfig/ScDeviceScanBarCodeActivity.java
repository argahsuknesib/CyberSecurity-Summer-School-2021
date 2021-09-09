package com.xiaomi.smarthome.smartconfig;

import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.grr;
import _m_j.gsy;
import _m_j.htj;
import _m_j.htl;
import _m_j.htm;
import _m_j.htr;
import _m_j.htv;
import _m_j.htw;
import _m_j.htx;
import _m_j.hty;
import _m_j.hxi;
import _m_j.hzc;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity;
import java.util.List;
import miui.os.SystemProperties;
import org.json.JSONObject;

public class ScDeviceScanBarCodeActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f11461O000000o;
    private String O00000Oo;
    private TextView O00000o;
    private String O00000o0;
    private ImageView O00000oO;
    private TextView O00000oo;
    private Button O0000O0o;
    private Button O0000OOo;
    private htl O0000Oo = new htm() {
        /* class com.xiaomi.smarthome.smartconfig.ScDeviceScanBarCodeActivity.AnonymousClass4 */

        public final void onDeviceConnectionFailure(int i) {
            gsy.O00000Oo("ScDeviceScanBarCodeActivity", "onDeviceConnectionFailure ".concat(String.valueOf(i)));
            gqg.O00000Oo((int) R.string.login_fail);
            ScDeviceScanBarCodeActivity.this.dismissLoadingDialog();
            ScDeviceScanBarCodeActivity.this.finish();
        }

        public final void onDeviceConnectionSuccess(List<Device> list) {
            gsy.O00000Oo("ScDeviceScanBarCodeActivity", "onDeviceConnectionSuccess");
            ScDeviceScanBarCodeActivity.this.configSuccess();
        }

        public final void onDeviceConnectionFailure() {
            gsy.O00000Oo("ScDeviceScanBarCodeActivity", "onDeviceConnectionFailure");
            gqg.O00000Oo((int) R.string.login_fail);
            ScDeviceScanBarCodeActivity.this.dismissLoadingDialog();
            ScDeviceScanBarCodeActivity.this.finish();
        }
    };
    private XQProgressDialog O0000Oo0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.smart_config_sc_device_scan_activity);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ScDeviceScanBarCodeActivity.AnonymousClass1 */

            public final void onClick(View view) {
                ScDeviceScanBarCodeActivity.this.finish();
            }
        });
        this.O00000o = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000o.setText((int) R.string.choose_device_title);
        this.O00000oO = (ImageView) findViewById(R.id.iv_result);
        Picasso.get().load(ftn.O00000Oo(CoreApi.O000000o().O0000ooO(), hzc.f1008O000000o.get("passport_login_success"))).into(this.O00000oO);
        this.O00000oo = (TextView) findViewById(R.id.tv_passport_result);
        this.O00000oo.setText((int) R.string.auth_passport_tips);
        this.O0000O0o = (Button) findViewById(R.id.btn_login);
        this.O0000OOo = (Button) findViewById(R.id.btn_cancal);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ScDeviceScanBarCodeActivity.AnonymousClass2 */

            public final void onClick(View view) {
                ScDeviceScanBarCodeActivity.this.finish();
            }
        });
        this.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ScDeviceScanBarCodeActivity.AnonymousClass3 */

            public final void onClick(View view) {
                ScDeviceScanBarCodeActivity.this.parseQrCode();
            }
        });
        this.f11461O000000o = getIntent().getStringExtra("qrCode");
    }

    public void parseQrCode() {
        if (!TextUtils.isEmpty(this.f11461O000000o)) {
            Uri parse = Uri.parse(this.f11461O000000o);
            this.O00000Oo = parse.getQueryParameter("did");
            String queryParameter = parse.getQueryParameter("pid");
            this.O00000o0 = PluginDeviceManager.instance.getModelByProductId(Integer.parseInt(queryParameter));
            gsy.O00000Oo("ScDeviceScanBarCodeActivity", "parseQrCode did = " + this.O00000Oo + " pid = " + queryParameter + " model = " + this.O00000o0);
            String str = new String(Base64.decode(parse.getQueryParameter("url"), 0));
            gsy.O00000Oo("ScDeviceScanBarCodeActivity", "parseQrCode loginUrl = ".concat(str));
            MiAccountManager O00000Oo2 = MiAccountManager.O00000Oo(this);
            if (O00000Oo2.O00000oo() == null) {
                return;
            }
            if (O00000Oo2.O00000Oo()) {
                gsy.O00000Oo("ScDeviceScanBarCodeActivity", "startPassportAuth Use System Account");
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setClassName("com.xiaomi.account", "com.xiaomi.account.ui.AccountWebActivity");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(str));
                List<ResolveInfo> queryIntentActivities = getPackageManager().queryIntentActivities(intent, 1);
                if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                    gsy.O00000Oo("ScDeviceScanBarCodeActivity", "startPassportAuth No Acctivity Found!");
                } else {
                    startActivityForResult(intent, 101);
                }
            } else {
                gsy.O00000Oo("ScDeviceScanBarCodeActivity", "startPassportAuth Use Local Account!");
                Intent intent2 = new Intent(this, ScDeviceLocalAccountWebAuthActivity.class);
                intent2.putExtra("login_url", str);
                startActivityForResult(intent2, 100);
            }
        } else {
            gqg.O00000Oo((int) R.string.login_fail);
            finish();
        }
    }

    private void O000000o() {
        gsy.O00000Oo("ScDeviceScanBarCodeActivity", "startSearchNewDevice " + this.O00000Oo);
        htw O000000o2 = htv.O000000o();
        if (O000000o2 != null) {
            O000000o2.scanNewDevice(this.O0000Oo, "", this.O00000Oo, "", "", this.O00000o0, (long) O000000o2.getTimeLen());
        }
    }

    private static int O00000Oo() {
        return ((Integer) htr.O000000o().O000000o("selected_ap_level", 999)).intValue();
    }

    public void showLoadingDialog() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new XQProgressDialog(this);
            this.O0000Oo0.setMessage(getString(R.string.mj_login_passport_login_waiting));
            this.O0000Oo0.setCancelable(true);
        }
        this.O0000Oo0.show();
    }

    public void dismissLoadingDialog() {
        XQProgressDialog xQProgressDialog = this.O0000Oo0;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("login_result", false);
            gsy.O00000Oo("ScDeviceScanBarCodeActivity", "Local login onActivityResult result = ".concat(String.valueOf(booleanExtra)));
            if (booleanExtra) {
                O000000o();
                showLoadingDialog();
                return;
            }
            gqg.O00000Oo((int) R.string.login_fail);
            finish();
        } else if (i == 101) {
            gsy.O00000Oo("ScDeviceScanBarCodeActivity", "System login onActivityResult");
            O000000o();
            showLoadingDialog();
            return;
        }
        this.O0000O0o.setText((int) R.string.mj_retry);
        this.O0000OOo.setVisibility(8);
        this.O00000oo.setText((int) R.string.login_fail);
        Picasso.get().load(ftn.O00000Oo(CoreApi.O000000o().O0000ooO(), hzc.f1008O000000o.get("passport_login_failed"))).into(this.O00000oO);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hxk.O000000o(java.lang.String, long):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hxk.O000000o(int, int):void
      _m_j.hxk.O000000o(java.lang.String, int):void
      _m_j.hxk.O000000o(java.lang.String, java.lang.String):void
      _m_j.hxk.O000000o(java.lang.String, org.json.JSONObject):void
      _m_j.hxk.O000000o(java.lang.String, boolean):void
      _m_j.hxk.O000000o(boolean, java.lang.String):void
      _m_j.hxk.O000000o(java.lang.String, long):void */
    public void configSuccess() {
        String str;
        Device device = (Device) htr.O000000o().O000000o("connected_device");
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        if (!(device == null || O0000Oo02 == null)) {
            ggb.O00000Oo().O000000o(O0000Oo02, (Room) null, device, (ggb.O00000o) null);
        }
        Device device2 = (Device) htr.O000000o().O000000o("connected_device");
        if (device2 != null) {
            CommonApplication.getAppContext();
            htj.O000000o(device2.model, device2.mac);
            Long l = (Long) htr.O000000o().O000000o("key_time_start");
            if (l == null || l.longValue() == 0) {
                hxi.O00000o.O000000o(device2.model, -1L);
            } else {
                hxi.O00000o.O000000o(device2.model, System.currentTimeMillis() - l.longValue());
            }
            hxi.O00000o0.O000000o(this.O00000o0, this.mEnterTime);
            htr.O000000o().O00000Oo("connect_result", "success");
            String str2 = device2.model;
            String str3 = device2.model;
            String str4 = device2.did;
            try {
                if (!grr.O00000oO()) {
                    str = "not_miui";
                } else {
                    str = SystemProperties.get("ro.miui.ui.version.name", "");
                }
                String str5 = str;
                boolean booleanValue = ((Boolean) htr.O000000o().O000000o("from_miui")).booleanValue();
                htx O000000o2 = hty.O000000o();
                if (O000000o2 != null) {
                    if (booleanValue) {
                        hxi.O0000Oo.O000000o(str2, str5, O000000o2.getDeviceSource(), O00000Oo(), "NONE", str3, str4);
                    } else if (O000000o2.getDeviceSource() == 1) {
                        hxi.O0000Oo.O000000o(str2, str5, 1, O00000Oo(), "NONE", str3, str4);
                    } else {
                        hxi.O0000Oo.O00000Oo(str2, str5, O000000o2.getDeviceSource(), O00000Oo(), "NONE", str3, str4);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean booleanValue2 = ((Boolean) htr.O000000o().O000000o("from_miui", Boolean.FALSE)).booleanValue();
            DeviceApi.getInstance().reportNewBind(this, device2.did, booleanValue2 ? "miui" : "mijia", new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.smartconfig.ScDeviceScanBarCodeActivity.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null && jSONObject.optInt("code", -1) == 0) {
                        gsy.O000000o(3, "wangyh", "onSuccess: " + jSONObject.toString());
                    }
                }

                public final void onFailure(fso fso) {
                    gsy.O000000o(3, "wangyh", "onFailure: " + fso.toString());
                }
            });
            fru.O000000o().O000000o(device2.did, (String) htr.O000000o().O000000o("gmt_tz", ""), (JSONObject) null, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.smartconfig.ScDeviceScanBarCodeActivity.AnonymousClass6 */

                public final void onFailure(fso fso) {
                    gsy.O000000o(3, "timezone", "upload failed! Error = " + fso.toString());
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    gsy.O000000o(3, "timezone", "upload successfully!");
                }
            });
            if (booleanValue2) {
                SmartConfigRouterFactory.getSmartConfigManager().sendBrodCard(device2.did);
            }
        } else {
            gsy.O00000Oo("ConfigStep", "finishStep device is null");
        }
        gsy.O00000o0(LogType.GENERAL, "ScDeviceScanBarCodeActivity", "startChooseRoom");
        Device device3 = (Device) htr.O000000o().O000000o("connected_device");
        Context appContext = CommonApplication.getAppContext();
        Intent intent = new Intent(appContext, InitDeviceRoomActivity.class);
        if (device3 != null) {
            intent.putExtra("device_id", device3.did);
            intent.addFlags(268435456);
            appContext.startActivity(intent);
            finish();
        }
    }
}
