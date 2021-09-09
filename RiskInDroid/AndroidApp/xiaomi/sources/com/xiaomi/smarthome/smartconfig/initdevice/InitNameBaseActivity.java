package com.xiaomi.smarthome.smartconfig.initdevice;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gpa;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gve;
import _m_j.gzb;
import _m_j.hmc;
import _m_j.hme;
import _m_j.hor;
import _m_j.htr;
import _m_j.huf;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageHandle;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;

class InitNameBaseActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f11513O000000o = 0;
    protected int O00000Oo = 2;
    protected Device O00000o;
    protected XQProgressHorizontalDialog O00000o0;
    private final SendMessageHandle O00000oO = new SendMessageHandle();
    public boolean mCanJumpMiBrain = false;
    public boolean mCanJumpShare = false;
    public boolean mCanSwicthMiSoundGateway = false;
    public final gzb mControl = new gzb(this);

    public void onBackPressed() {
    }

    InitNameBaseActivity() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("device_id");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.O00000o = fno.O000000o().O000000o(stringExtra);
            if (this.O00000o == null) {
                this.O00000o = fno.O000000o().O00000oo(stringExtra);
                LogType logType = LogType.HOME_ROOM;
                StringBuilder sb = new StringBuilder("getDeviceByDid is null, getVirtualGroupDeviceByDid got device? ");
                sb.append(this.O00000o != null);
                gsy.O00000o0(logType, "InitNameBaseActivity", sb.toString());
            }
        }
        if (this.O00000o == null) {
            String stringExtra2 = intent.getStringExtra("device_mac");
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.O00000o = fno.O000000o().O00000o(stringExtra2);
            }
        }
        Device device = (Device) htr.O000000o().O000000o("connected_device");
        if (this.O00000o == null && device != null && TextUtils.equals(stringExtra, device.did)) {
            this.O00000o = device;
        }
        if (this.O00000o == null) {
            finish();
            return;
        }
        this.f11513O000000o = getIntent().getIntExtra("step_count", 0);
        this.O00000Oo = getIntent().getIntExtra("current_step", 1) + 1;
        this.mCanJumpShare = getIntent().getBooleanExtra("can_jump_share", false);
        this.mCanJumpMiBrain = getIntent().getBooleanExtra("can_jump_mibrain", false);
        this.mCanSwicthMiSoundGateway = getIntent().getBooleanExtra("can_show_misound_gateway_switch", false);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        TextView textView = (TextView) findViewById(R.id.step);
        if (this.f11513O000000o > 0) {
            textView.setText(this.O00000Oo + "/" + this.f11513O000000o);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.O00000Oo == this.f11513O000000o) {
            this.mControl.f18610O000000o = true;
        }
    }

    public void onPause() {
        super.onPause();
        if (this.O00000Oo == this.f11513O000000o) {
            this.mControl.O00000Oo();
        }
    }

    public void finish() {
        super.finish();
        this.O00000oO.cancel();
        sendBroadcast(getIntent().setAction("smarthome_init_device_finish"));
    }

    /* access modifiers changed from: protected */
    public final void O000000o(final Device device, String str, final huf huf) {
        gpa.O000000o(this, device, str, null, new fsm() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitNameBaseActivity.AnonymousClass1 */

            public final void onSuccess(Object obj) {
                if (InitNameBaseActivity.this.isValid()) {
                    huf.accept(String.valueOf(obj));
                }
            }

            public final void onFailure(fso fso) {
                if (InitNameBaseActivity.this.isValid()) {
                    gqg.O00000Oo((int) R.string.change_back_name_fail);
                    if (InitNameBaseActivity.this.O00000o0 != null && InitNameBaseActivity.this.O00000o0.isShowing()) {
                        InitNameBaseActivity.this.O00000o0.dismiss();
                    }
                    LogType logType = LogType.HOME_ROOM;
                    gsy.O00000Oo(logType, "InitNameBaseActivity", device + "error" + fso);
                }
            }
        }, true);
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        O00000Oo();
        if (!this.O00000o0.isShowing()) {
            this.O00000o0.show();
        }
        gve.getInstance().syncMiBrainDeviceIfNeed(this.O00000o.did, true, new fsm() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitNameBaseActivity.AnonymousClass2 */

            public final void onSuccess(Object obj) {
                LogType logType = LogType.HOME_ROOM;
                gsy.O00000o0(logType, "InitNameBaseActivity", "goNextPage onSuccess  did:" + InitNameBaseActivity.this.O00000o.did);
                if (InitNameBaseActivity.this.O00000o0 != null && InitNameBaseActivity.this.O00000o0.isShowing()) {
                    InitNameBaseActivity.this.O00000o0.dismiss();
                }
                Intent intent = null;
                if (hor.O000000o().isShowRecSceneInitDeviceStep(InitNameBaseActivity.this.O00000o)) {
                    Intent intent2 = new Intent();
                    intent2.putExtras(InitNameBaseActivity.this.getIntent());
                    intent2.putExtra("current_step", InitNameBaseActivity.this.O00000Oo);
                    intent2.putExtra("can_jump_mibrain", InitNameBaseActivity.this.mCanJumpMiBrain);
                    intent2.putExtra("can_show_misound_gateway_switch", InitNameBaseActivity.this.mCanSwicthMiSoundGateway);
                    intent2.putExtra("can_jump_share", InitNameBaseActivity.this.mCanJumpShare);
                    hor.O000000o().startInitDeviceRecSpecSceneActivity(InitNameBaseActivity.this, intent2);
                    InitNameBaseActivity.this.finish();
                    return;
                }
                if (InitNameBaseActivity.this.mCanJumpMiBrain || InitNameBaseActivity.this.mCanJumpShare || InitNameBaseActivity.this.mCanSwicthMiSoundGateway) {
                    intent = new Intent(InitNameBaseActivity.this.getContext(), InitShareAndMibrainActivity.class);
                }
                if (intent != null) {
                    intent.putExtras(InitNameBaseActivity.this.getIntent());
                    intent.putExtra("current_step", InitNameBaseActivity.this.O00000Oo);
                    intent.putExtra("can_jump_mibrain", InitNameBaseActivity.this.mCanJumpMiBrain);
                    intent.putExtra("can_show_misound_gateway_switch", InitNameBaseActivity.this.mCanSwicthMiSoundGateway);
                    intent.putExtra("can_jump_share", InitNameBaseActivity.this.mCanJumpShare);
                    InitNameBaseActivity.this.startActivity(intent);
                    InitNameBaseActivity.this.finish();
                    return;
                }
                InitNameBaseActivity.this.enterPlugin();
            }

            public final void onFailure(fso fso) {
                LogType logType = LogType.HOME_ROOM;
                gsy.O00000o0(logType, "InitNameBaseActivity", "goNextPage onFailure  did:" + InitNameBaseActivity.this.O00000o.did);
                onSuccess(null);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        if (this.O00000o0 == null) {
            this.O00000o0 = new XQProgressHorizontalDialog(this);
            this.O00000o0.setCancelable(true);
            this.O00000o0.setMessage(getResources().getString(R.string.loading_share_info));
        }
    }

    public void enterPlugin() {
        O00000Oo();
        PluginApi.getInstance().sendMessage(this, this.O00000o.model, 1, new Intent(), DeviceRouterFactory.getDeviceWrapper().newDeviceStat(this.O00000o), null, false, new hme(this, this.O00000o.model, this.O00000oO, this.O00000o0, new hmc() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitNameBaseActivity.AnonymousClass3 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
             arg types: [java.lang.String, int]
             candidates:
              ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
            public final void onLoadingFinish(boolean z) {
                if (z) {
                    InitNameBaseActivity.this.getIntent().putExtra("type", true);
                    InitNameBaseActivity.this.mControl.O000000o();
                } else if (InitNameBaseActivity.this.O00000o0 != null && InitNameBaseActivity.this.O00000o0.isShowing()) {
                    InitNameBaseActivity.this.O00000o0.dismiss();
                }
            }
        }));
    }
}
