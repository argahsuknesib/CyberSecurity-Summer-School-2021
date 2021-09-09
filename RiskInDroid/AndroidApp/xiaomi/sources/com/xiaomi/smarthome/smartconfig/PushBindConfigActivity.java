package com.xiaomi.smarthome.smartconfig;

import _m_j.fag;
import _m_j.fml;
import _m_j.fqy;
import _m_j.fuf;
import _m_j.gnl;
import _m_j.gri;
import _m_j.gsy;
import _m_j.htq;
import _m_j.hua;
import _m_j.hud;
import _m_j.hul;
import _m_j.hxi;
import _m_j.hze;
import _m_j.iag;
import _m_j.izb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.widget.ProgressView;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class PushBindConfigActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private BroadcastReceiver f11448O000000o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.smartconfig.PushBindConfigActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (PushBindConfigActivity.this.tvHint != null) {
                PushBindConfigActivity.this.setHint();
            }
        }
    };
    public PushBindEntity mEntity;
    public TextView tvHint;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mEntity = (PushBindEntity) getIntent().getParcelableExtra("bind_aiot_wifi");
        PushBindEntity pushBindEntity = this.mEntity;
        if (pushBindEntity == null) {
            gsy.O00000Oo(LogType.PUSH, "PushBindConfigActivity", "onCreate data is null EXTRA_BINDWIFI");
            finish();
            return;
        }
        if (fml.O00000Oo(pushBindEntity.f11457O000000o.O00000Oo())) {
            setContentView((int) R.layout.activity_pushhint);
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.push_bindhint_title);
            final ProgressView progressView = (ProgressView) findViewById(R.id.image);
            final View findViewById = findViewById(R.id.tv_title);
            final View findViewById2 = findViewById(R.id.tv_content);
            int O000000o2 = gri.O000000o(1.5f);
            progressView.f10321O000000o = O000000o2;
            progressView.O00000Oo = O000000o2;
            progressView.requestLayout();
            progressView.setColor$4868d30e(0);
            progressView.setProgress(-1.0f);
            findViewById.setVisibility(4);
            findViewById2.setVisibility(4);
            htq.O000000o().O000000o(this.mEntity.f11457O000000o.O00000Oo(), this.mEntity.O00000Oo, this.mEntity.O00000o0, this.mEntity.O00000o, new hua<JSONObject, hud>() {
                /* class com.xiaomi.smarthome.smartconfig.PushBindConfigActivity.AnonymousClass2 */

                public final void O000000o(hud hud) {
                    LogType logType = LogType.PUSH;
                    gsy.O00000Oo(logType, "PushBindConfigActivity", PushBindConfigActivity.this.mEntity + "  bindPushApDevice error:" + hud);
                    PushBindConfigActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.smartconfig.PushBindConfigActivity.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            if (PushBindConfigActivity.this.isValid()) {
                                htq.O000000o().O000000o(PushBindConfigActivity.this.mEntity.f11457O000000o.O00000Oo(), PushBindConfigActivity.this.mEntity.O00000Oo, PushBindConfigActivity.this.mEntity.O00000o0, PushBindConfigActivity.this.mEntity.O00000o, this);
                            }
                        }
                    }, 1000);
                }

                public final /* synthetic */ void O000000o(Object obj) {
                    SmartConfigRouterFactory.getSmartConfigManager().bind(PushBindConfigActivity.this.mEntity.O00000o);
                    progressView.setColor$4868d30e(-14105143);
                    progressView.setProgress(100.0f);
                    findViewById.setVisibility(0);
                    findViewById2.setVisibility(0);
                }
            });
        } else {
            setContentView((int) R.layout.activity_pushbind);
            registerReceiver(this.f11448O000000o, new IntentFilter("android.net.wifi.STATE_CHANGE"));
            this.tvHint = (TextView) findViewById(R.id.tvHint);
            setHint();
            ((TextView) findViewById(R.id.tv_name)).setText(this.mEntity.f11457O000000o.O0000Oo0());
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.push_confirmbind_title);
            findViewById(R.id.module_a_3_right_tv_text).setVisibility(8);
            hxi.O00000o0.f957O000000o.O000000o("push_bind_page_show", "source", Integer.valueOf(this.mEntity.O0000OoO ? 1 : 2));
            findViewById(R.id.next_btn).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.PushBindConfigActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    if (fml.O000000o(PushBindConfigActivity.this.mEntity.f11457O000000o)) {
                        PushBindConfigActivity pushBindConfigActivity = PushBindConfigActivity.this;
                        if (hze.O000000o(pushBindConfigActivity, pushBindConfigActivity.mEntity.O00000oO, PushBindConfigActivity.this.mEntity.O00000oo)) {
                            final XQProgressDialog xQProgressDialog = new XQProgressDialog(PushBindConfigActivity.this);
                            xQProgressDialog.setCancelable(true);
                            xQProgressDialog.setMessage(PushBindConfigActivity.this.getResources().getString(R.string.mj_loading));
                            xQProgressDialog.show();
                            SmartConfigRouterFactory.getSmartConfigManager().getLocalMiRouterDetail(new hul<fuf.O00000o0>() {
                                /* class com.xiaomi.smarthome.smartconfig.PushBindConfigActivity.AnonymousClass3.AnonymousClass1 */

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
                                public final /* synthetic */ void O000000o(Object obj) {
                                    xQProgressDialog.dismiss();
                                    Iterator<WifiInfo> it = ((fuf.O00000o0) obj).f17173O000000o.iterator();
                                    while (it.hasNext()) {
                                        WifiInfo next = it.next();
                                        if (iag.O000000o(next.O00000o0, PushBindConfigActivity.this.mEntity.O00000oO)) {
                                            Intent intent = new Intent(PushBindConfigActivity.this.getContext(), SmartConfigMainActivity.class);
                                            fqy.O000000o(intent, PushBindConfigActivity.this);
                                            intent.putExtra("strategy_id", 9);
                                            intent.putExtra("model", PushBindConfigActivity.this.mEntity.f11457O000000o.O00000Oo());
                                            intent.putExtra("bssid", PushBindConfigActivity.this.mEntity.O00000oo);
                                            intent.putExtra("mi_router_info", next);
                                            intent.putExtra("use_password_page", false);
                                            intent.putExtra("use_reset_page", false);
                                            intent.putExtra("aiot_wifi", PushBindConfigActivity.this.mEntity);
                                            PushBindConfigActivity.this.startActivityForResult(intent, 100);
                                            return;
                                        }
                                    }
                                    fag.O000000o(PushBindConfigActivity.this, PushBindConfigActivity.this.getString(R.string.push_getwifiinfo_error));
                                }

                                public final void O000000o(int i) {
                                    xQProgressDialog.dismiss();
                                    fag.O000000o(PushBindConfigActivity.this, PushBindConfigActivity.this.getString(R.string.push_getwifiinfo_error));
                                }

                                public final void O00000Oo(int i) {
                                    xQProgressDialog.dismiss();
                                    fag.O000000o(PushBindConfigActivity.this, PushBindConfigActivity.this.getString(R.string.push_getwifiinfo_error));
                                }
                            });
                            return;
                        }
                        PushBindConfigActivity pushBindConfigActivity2 = PushBindConfigActivity.this;
                        fag.O000000o(pushBindConfigActivity2, pushBindConfigActivity2.getString(R.string.push_changewifi_hint, new Object[]{pushBindConfigActivity2.mEntity.O00000oO}));
                        return;
                    }
                    Intent intent = new Intent(PushBindConfigActivity.this.getContext(), SmartConfigMainActivity.class);
                    fqy.O000000o(intent, PushBindConfigActivity.this);
                    if (PushBindConfigActivity.this.mEntity.O0000OoO) {
                        intent.putExtra("strategy_id", 17);
                    } else {
                        intent.putExtra("strategy_id", 16);
                    }
                    intent.putExtra("aiot_wifi", PushBindConfigActivity.this.mEntity);
                    PushBindConfigActivity.this.startActivityForResult(intent, 100);
                }
            });
            SmartConfigRouterFactory.getSmartConfigManager().requestDeviceImage(this.mEntity.f11457O000000o.O00000Oo(), new hua<String, hud>() {
                /* class com.xiaomi.smarthome.smartconfig.PushBindConfigActivity.AnonymousClass4 */

                public final /* synthetic */ void O000000o(Object obj) {
                    DeviceFactory.O000000o((SimpleDraweeView) PushBindConfigActivity.this.findViewById(R.id.icon_static), (String) obj, 0);
                }

                public final void O000000o(hud hud) {
                    DeviceFactory.O000000o((SimpleDraweeView) PushBindConfigActivity.this.findViewById(R.id.icon_static), (String) null, 0);
                }
            });
            View findViewById3 = findViewById(R.id.checkWifi);
            try {
                findViewById3.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.PushBindConfigActivity.AnonymousClass5 */

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
                    public final void onClick(View view) {
                        if (!PushBindConfigActivity.this.mEntity.f11457O000000o.O000000o()) {
                            izb.O000000o(PushBindConfigActivity.this.getContext(), PushBindConfigActivity.this.getContext().getString(R.string.device_not_support_now), 0).show();
                            return;
                        }
                        hxi.O00000o.f952O000000o.O000000o("choose_other_wifi", "source", Integer.valueOf(PushBindConfigActivity.this.mEntity.O0000OoO ? 1 : 2));
                        Intent intent = new Intent(PushBindConfigActivity.this.getContext(), SmartConfigMainActivity.class);
                        fqy.O000000o(intent, PushBindConfigActivity.this);
                        if (PushBindConfigActivity.this.mEntity.f11457O000000o.O00000o() == 4) {
                            List<Integer> O0000O0o = PushBindConfigActivity.this.mEntity.f11457O000000o.O0000O0o();
                            if (O0000O0o != null && O0000O0o.contains(1) && gnl.O000000o()) {
                                intent.putExtra("strategy_id", 4);
                            } else if (O0000O0o == null || !O0000O0o.contains(0)) {
                                intent.putExtra("strategy_id", 9);
                                intent.putExtra("use_reset_page", false);
                            } else {
                                intent.putExtra("strategy_id", 2);
                            }
                        } else if (DeviceFactory.O00000Oo(PushBindConfigActivity.this.mEntity.O00000o0, PushBindConfigActivity.this.mEntity.O00000o) == DeviceFactory.AP_TYPE.AP_MIBAP && gnl.O000000o()) {
                            intent.putExtra("strategy_id", 4);
                        } else if (PushBindConfigActivity.this.mEntity.O0000OoO) {
                            intent.putExtra("strategy_id", 17);
                        } else {
                            intent.putExtra("strategy_id", 2);
                        }
                        if (PushBindConfigActivity.this.mEntity.O0000OoO) {
                            intent.putExtra("isChooseWifi", true);
                        }
                        intent.putExtra("aiot_wifi", PushBindConfigActivity.this.mEntity);
                        intent.putExtra("ssid", PushBindConfigActivity.this.mEntity.O00000o0);
                        intent.putExtra("model", PushBindConfigActivity.this.mEntity.f11457O000000o.O00000Oo());
                        PushBindConfigActivity.this.startActivityForResult(intent, 100);
                    }
                });
                if (this.mEntity != null && this.mEntity.f11457O000000o.O00000o() == 20) {
                    findViewById3.setVisibility(8);
                }
            } catch (Exception e) {
                findViewById3.setVisibility(8);
                Log.e("DevicePushBindManager", "PushBindConfigActivity", e);
            }
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.PushBindConfigActivity.AnonymousClass6 */

            public final void onClick(View view) {
                PushBindConfigActivity.this.onBackPressed();
            }
        });
    }

    public void setHint() {
        if (!fml.O000000o(this.mEntity.f11457O000000o) || hze.O000000o(this, this.mEntity.O00000oO, this.mEntity.O00000oo)) {
            this.tvHint.setText(getString(R.string.push_confirmbind_hint, new Object[]{this.mEntity.O00000oO}));
            SmartConfigRouterFactory.getSmartConfigManager().getLocalMiRouterDetail(null);
            return;
        }
        this.tvHint.setText(getString(R.string.push_confirmbind_hint, new Object[]{this.mEntity.O00000oO}));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        if (intent != null) {
            z = intent.getBooleanExtra("finish", true);
        }
        if (i2 == 0) {
            z = false;
        }
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent);
        }
        intent2.putExtra("finish", z);
        setResult(-1, intent2);
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.f11448O000000o);
        } catch (Exception unused) {
        }
    }
}
