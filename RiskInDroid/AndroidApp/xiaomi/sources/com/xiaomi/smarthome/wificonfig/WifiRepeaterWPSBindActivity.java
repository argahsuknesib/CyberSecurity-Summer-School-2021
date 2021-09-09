package com.xiaomi.smarthome.wificonfig;

import _m_j.cub;
import _m_j.cuh;
import _m_j.dxe;
import _m_j.eyr;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.htk;
import _m_j.htl;
import _m_j.hto;
import _m_j.htq;
import _m_j.hua;
import _m_j.hud;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.WifiRepeater;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.wificonfig.WifiRepeaterWPSBindActivity;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class WifiRepeaterWPSBindActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    SimpleDraweeView f12020O000000o;
    TextView O00000Oo;
    TextView O00000o;
    ImageView O00000o0;
    EditText O00000oO;
    TextView O00000oo;
    Button O0000O0o;
    XQProgressDialog O0000OOo = null;
    public boolean isRpcSuccess = false;
    public String mBindKey;
    public WifiRepeater mWifiRepeater;

    public static void invokeActivity(Context context, WifiRepeater wifiRepeater) {
        Intent intent = new Intent(context, WifiRepeaterWPSBindActivity.class);
        intent.putExtra("wifiRepeater", wifiRepeater);
        context.startActivity(intent);
    }

    public void writeLog(String str, Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            gsy.O00000o0(LogType.KUAILIAN, "Repeater-Binder", str);
            return;
        }
        gsy.O00000o0(LogType.KUAILIAN, "Repeater-Binder", String.format(str, objArr));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wifi_repeater_wps_bind);
        this.O00000o0 = (ImageView) findViewById(R.id.module_a_3_return_btn);
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_return_title);
        this.f12020O000000o = (SimpleDraweeView) findViewById(R.id.img_wps_device_icon);
        this.O00000o = (TextView) findViewById(R.id.txt_wps_connect_ssid);
        this.O00000oO = (EditText) findViewById(R.id.edt_input_ssid_pwd);
        this.O00000oo = (TextView) findViewById(R.id.txt_wps_forget_pwd);
        this.O0000O0o = (Button) findViewById(R.id.btn_wps_start_bind);
        this.O00000oo.getPaint().setFlags(8);
        boolean z = true;
        this.O00000oo.getPaint().setAntiAlias(true);
        this.O00000o0.setOnClickListener(this);
        this.O0000O0o.setOnClickListener(this);
        this.O00000oo.setOnClickListener(this);
        Button button = this.O0000O0o;
        if (this.O00000oO.length() <= 0) {
            z = false;
        }
        button.setEnabled(z);
        this.O00000oO.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWPSBindActivity.AnonymousClass2 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                WifiRepeaterWPSBindActivity.this.O0000O0o.setEnabled(editable.length() > 0);
            }
        });
        this.O00000Oo.setText((int) R.string.wps_connect_wifi_repeater);
        this.mWifiRepeater = (WifiRepeater) getIntent().getSerializableExtra("wifiRepeater");
        if (this.mWifiRepeater == null) {
            gsy.O00000o0(LogType.KUAILIAN, "Repeater-Binder", "bind activity wifi repeater is null,finish it");
            finish();
        }
        TextView textView = this.O00000o;
        textView.setText(getString(R.string.wps_connect_ssid) + this.mWifiRepeater.ssid);
        SmartConfigRouterFactory.getSmartConfigManager().requestDeviceImage(this.mWifiRepeater.model, new hua<String, hud>() {
            /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWPSBindActivity.AnonymousClass1 */

            public final void O000000o(hud hud) {
            }

            public final /* synthetic */ void O000000o(Object obj) {
                WifiRepeaterWPSBindActivity.this.f12020O000000o.setImageURI((String) obj);
            }
        });
    }

    public void handleMessage(Message message) {
        if (message.what == 8944) {
            dismissDialog();
            writeLog("handle message trigger check device bind timeout ", new Object[0]);
            Toast.makeText(this, (int) R.string.wps_bind_fail_and_retry, 0).show();
            return;
        }
        super.handleMessage(message);
    }

    public void onResume() {
        super.onResume();
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWPSBindActivity.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                WifiRepeaterWPSBindActivity.this.mBindKey = (String) obj;
            }

            public final void O000000o(hud hud) {
                if (hud != null) {
                    LogType logType = LogType.KUAILIAN;
                    gsy.O00000o0(logType, "Repeater-Binder", "requestBindKey onFail, " + hud.O000000o());
                    return;
                }
                gsy.O00000o0(LogType.KUAILIAN, "Repeater-Binder", "requestBindKey onFail,no detail msg ");
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_return_btn) {
            finish();
        } else if (view.getId() == R.id.btn_wps_start_bind) {
            String obj = this.O00000oO.getText().toString();
            writeLog("startBind isRpcSuccess = %s", Boolean.valueOf(this.isRpcSuccess));
            if (this.isRpcSuccess) {
                checkDeviceBind();
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", O000000o());
                    jSONObject.put("method", "localIO.check_ssid_pwd");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ssid", this.mWifiRepeater.ssid);
                    jSONObject2.put("pwd", obj);
                    jSONObject.put("params", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MiioLocalAPI.O000000o(this.mWifiRepeater.ip, jSONObject.toString(), this.mWifiRepeater.did, this.mWifiRepeater.token, new dxe.O000000o() {
                    /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWPSBindActivity.AnonymousClass4 */

                    public final void O000000o(JSONObject jSONObject) {
                        boolean z = false;
                        WifiRepeaterWPSBindActivity.this.writeLog("check_ssid_pwd onSuccess, result =".concat(String.valueOf(jSONObject)), new Object[0]);
                        if (jSONObject.optInt("code", -1) == 0) {
                            z = true;
                        }
                        if (z) {
                            WifiRepeaterWPSBindActivity.this.O000000o("RPC: 校验密码成功");
                            WifiRepeaterWPSBindActivity.this.bind();
                            return;
                        }
                        WifiRepeaterWPSBindActivity.this.dismissDialog();
                        WifiRepeaterWPSBindActivity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.wificonfig.$$Lambda$WifiRepeaterWPSBindActivity$4$xbdAGq5DJ1HNjj_xOmHelcBCvU */

                            public final void run() {
                                WifiRepeaterWPSBindActivity.AnonymousClass4.this.O000000o();
                            }
                        });
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O000000o() {
                        Toast.makeText(WifiRepeaterWPSBindActivity.this, (int) R.string.wps_ssid_pwd_invalid, 1).show();
                    }

                    public final void O000000o(int i, String str, Throwable th) {
                        WifiRepeaterWPSBindActivity.this.writeLog("check_ssid_pwd onFail code=%d, result=%s", Integer.valueOf(i), str);
                        WifiRepeaterWPSBindActivity.this.dismissDialog();
                    }
                });
            }
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.wificonfig.$$Lambda$WifiRepeaterWPSBindActivity$3tcXWF8GK1YUN1HbJ669ACmOZIc */

                public final void run() {
                    WifiRepeaterWPSBindActivity.this.O00000o0();
                }
            });
        } else if (view.getId() == R.id.txt_wps_forget_pwd) {
            cub.O000000o(new cuh(this, "ResetDevicePage").O000000o("model", this.mWifiRepeater.model));
            finish();
        }
    }

    private static int O000000o() {
        return (int) ((System.currentTimeMillis() / 1000) + ((long) new Random().nextInt(1000)));
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        if (gfr.O0000OOo) {
            runOnUiThread(new Runnable(str) {
                /* class com.xiaomi.smarthome.wificonfig.$$Lambda$WifiRepeaterWPSBindActivity$OBSsmrNHtoLx6J6DIuT6CoqM8qY */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    WifiRepeaterWPSBindActivity.this.O00000Oo(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(String str) {
        Toast.makeText(this, str, 1).show();
    }

    public void bind() {
        if (TextUtils.isEmpty(this.mBindKey)) {
            runOnUiThread($$Lambda$WifiRepeaterWPSBindActivity$urhHrRrg3ZUYww3eTb1LtRJYI.INSTANCE);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", O000000o());
            jSONObject.put("method", "localIO.set_system_bind_info");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uid", SmartConfigRouterFactory.getCoreApiManager().getMiId());
            jSONObject2.put("country_code", SmartConfigRouterFactory.getCoreApiManager().getCountryCode());
            jSONObject2.put("country_domain", SmartConfigRouterFactory.getCoreApiManager().getCountryDomain());
            jSONObject2.put("bind_key", this.mBindKey);
            jSONObject2.put("tz", TimeZone.getDefault().getID());
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        writeLog("set_system_bind_info start", new Object[0]);
        MiioLocalAPI.O000000o(this.mWifiRepeater.ip, jSONObject.toString(), this.mWifiRepeater.did, this.mWifiRepeater.token, new dxe.O000000o() {
            /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWPSBindActivity.AnonymousClass5 */

            public final void O000000o(JSONObject jSONObject) {
                WifiRepeaterWPSBindActivity.this.writeLog("set_system_bind_info onSuccess,result=".concat(String.valueOf(jSONObject)), new Object[0]);
                if (jSONObject.optInt("code", -1) == 0) {
                    WifiRepeaterWPSBindActivity.this.O000000o("RPC: 设置绑定信息成功");
                    WifiRepeaterWPSBindActivity wifiRepeaterWPSBindActivity = WifiRepeaterWPSBindActivity.this;
                    wifiRepeaterWPSBindActivity.isRpcSuccess = true;
                    wifiRepeaterWPSBindActivity.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.wificonfig.$$Lambda$WifiRepeaterWPSBindActivity$5$Rvm3EpKYAsUtb6_B5ES5eUsjYNw */

                        public final void run() {
                            WifiRepeaterWPSBindActivity.AnonymousClass5.this.O000000o();
                        }
                    });
                    WifiRepeaterWPSBindActivity.this.mHandler.sendEmptyMessageDelayed(8944, 50000);
                    return;
                }
                WifiRepeaterWPSBindActivity.this.dismissDialog();
                Toast.makeText(WifiRepeaterWPSBindActivity.this, (int) R.string.wps_ssid_pwd_invalid, 0).show();
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o() {
                WifiRepeaterWPSBindActivity.this.checkDeviceBind();
            }

            public final void O000000o(int i, String str, Throwable th) {
                WifiRepeaterWPSBindActivity.this.dismissDialog();
                WifiRepeaterWPSBindActivity.this.writeLog("set_system_bind_info onFail, code=%d,result=%s", Integer.valueOf(i), str);
            }
        });
    }

    public void checkDeviceBind() {
        writeLog("checkDeviceBind", new Object[0]);
        O000000o("开始向服务器轮训设备");
        long O0000Oo0 = (long) (eyr.O00000Oo().O0000Oo0(this.mWifiRepeater.model) + 50000);
        hto hto = new hto(this.mWifiRepeater.deviceMac, String.valueOf(this.mWifiRepeater.did), this.mBindKey, this.mWifiRepeater.model);
        this.mHandler.removeMessages(8944);
        this.mHandler.sendEmptyMessageDelayed(8944, O0000Oo0);
        htk.O000000o().O000000o(hto, O0000Oo0, new htl() {
            /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWPSBindActivity.AnonymousClass6 */

            public final void onDeviceConnectionSuccess(List<Device> list) {
                WifiRepeaterWPSBindActivity.this.O000000o("成功绑定设备");
                WifiRepeaterWPSBindActivity.this.dismissDialog();
                WifiRepeaterWPSBindActivity.this.mHandler.removeMessages(8944);
                cub.O000000o(new cuh(WifiRepeaterWPSBindActivity.this, "initDeviceRoomActivity").O000000o("device_id", String.valueOf(WifiRepeaterWPSBindActivity.this.mWifiRepeater.did)));
                WifiRepeaterWPSBindActivity.this.finish();
            }

            public final void onDeviceConnectionFailure() {
                WifiRepeaterWPSBindActivity.this.mHandler.removeMessages(8944);
                WifiRepeaterWPSBindActivity.this.O000000o("绑定失败");
                WifiRepeaterWPSBindActivity.this.dismissDialog();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0() {
        dismissDialog();
        this.O0000OOo = XQProgressDialog.O000000o(this, null, getString(R.string.loading));
    }

    public void dismissDialog() {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.wificonfig.$$Lambda$WifiRepeaterWPSBindActivity$wkgecTX6oWLp94FGDViCwDSjis */

            public final void run() {
                WifiRepeaterWPSBindActivity.this.O00000Oo();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo() {
        XQProgressDialog xQProgressDialog = this.O0000OOo;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O0000OOo.dismiss();
        }
    }
}
