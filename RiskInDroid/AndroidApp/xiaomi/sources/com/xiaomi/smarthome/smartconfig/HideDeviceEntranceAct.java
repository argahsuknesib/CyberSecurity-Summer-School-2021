package com.xiaomi.smarthome.smartconfig;

import _m_j.fno;
import _m_j.ggb;
import _m_j.gnk;
import _m_j.gqg;
import _m_j.hxi;
import _m_j.izb;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.widget.ProgressButton;
import com.xiaomi.smarthome.miio.device.TemporaryDevice;
import java.util.Iterator;
import java.util.Map;

public class HideDeviceEntranceAct extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleDraweeView f11439O000000o;
    private TextView O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    private View O00000oO;
    public ProgressButton mBtnAdd;
    public O000000o mCallback;
    public Device mDevice;
    public TextView mTvRight;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.hide_dev_entrance);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.HideDeviceEntranceAct.AnonymousClass1 */

            public final void onClick(View view) {
                HideDeviceEntranceAct.this.finish();
            }
        });
        this.O00000oO = findViewById(R.id.bottom_btn_container);
        this.O00000o = (TextView) findViewById(R.id.left_btn);
        this.mTvRight = (TextView) findViewById(R.id.right_btn);
        findViewById(R.id.title_bar).setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        this.O00000Oo = (TextView) findViewById(R.id.name);
        this.O00000o0 = (TextView) findViewById(R.id.desc);
        this.mBtnAdd = (ProgressButton) findViewById(R.id.add_btn);
        this.f11439O000000o = (SimpleDraweeView) findViewById(R.id.icon);
        this.f11439O000000o.setHierarchy(new GenericDraweeHierarchyBuilder(this.f11439O000000o.getResources()).setPlaceholderImage(getResources().getDrawable(R.drawable.device_list_phone_no)).setFadeDuration(200).build());
        String stringExtra = getIntent().getStringExtra("model");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Device device = (Device) it.next().getValue();
            if (device.model.equals(stringExtra)) {
                this.mDevice = device;
                break;
            }
        }
        if (this.mDevice == null) {
            this.mDevice = DeviceRouterFactory.getDeviceHelper().getTemporaryDevice(stringExtra);
        }
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(stringExtra);
        this.O00000Oo.setText(O00000oO2 == null ? "" : O00000oO2.O0000Oo0());
        this.mBtnAdd.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.HideDeviceEntranceAct.AnonymousClass2 */

            public final void onClick(View view) {
                HideDeviceEntranceAct.this.startDownloadingPlugin();
            }
        });
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.HideDeviceEntranceAct.AnonymousClass3 */

            public final void onClick(View view) {
                HideDeviceEntranceAct.this.finish();
            }
        });
        this.mTvRight.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.HideDeviceEntranceAct.AnonymousClass4 */

            public final void onClick(View view) {
                if (XmPluginHostApi.instance().getDeviceByDid(HideDeviceEntranceAct.this.mDevice.did) == null) {
                    DeviceRouterFactory.getDeviceHelper().setTemporaryDeviceShow(HideDeviceEntranceAct.this.mDevice.model, true);
                    fno.O000000o().O000000o(HideDeviceEntranceAct.this.mDevice);
                }
                Intent intent = new Intent();
                PluginApi instance = PluginApi.getInstance();
                HideDeviceEntranceAct hideDeviceEntranceAct = HideDeviceEntranceAct.this;
                instance.sendMessage(hideDeviceEntranceAct, hideDeviceEntranceAct.mDevice.model, 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(HideDeviceEntranceAct.this.mDevice), null, false, null);
                HideDeviceEntranceAct.this.finish();
            }
        });
        if (((this.mDevice instanceof TemporaryDevice) && DeviceRouterFactory.getDeviceHelper().shouldTemporaryDeviceShow(this.mDevice.model)) || CoreApi.O000000o().O0000OoO(stringExtra) != null || CoreApi.O000000o().O0000Oo(stringExtra) != null) {
            this.mBtnAdd.setText((int) R.string.open_imediate);
            this.mBtnAdd.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.HideDeviceEntranceAct.AnonymousClass5 */

                public final void onClick(View view) {
                    HideDeviceEntranceAct.this.mTvRight.performClick();
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.smartconfig.HideDeviceEntranceAct$O000000o]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void */
    public void startDownloadingPlugin() {
        gnk.O00000o0(String.format("startDownloadingPlugin", new Object[0]));
        gnk.O00000o0(String.format("onPluginDownloadStart", new Object[0]));
        this.mBtnAdd.setText((int) R.string.sh_common_cancel);
        O000000o(0);
        this.mBtnAdd.setButtonMode(1);
        this.mBtnAdd.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.HideDeviceEntranceAct.AnonymousClass7 */

            public final void onClick(View view) {
                if (HideDeviceEntranceAct.this.mCallback != null) {
                    HideDeviceEntranceAct.this.mCallback.O00000Oo = true;
                }
                HideDeviceEntranceAct.this.mHandler.removeCallbacksAndMessages(null);
                HideDeviceEntranceAct.this.reset();
            }
        });
        this.O00000oO.setVisibility(8);
        if (CoreApi.O000000o().O0000OoO(this.mDevice.model) == null && CoreApi.O000000o().O0000Oo(this.mDevice.model) == null) {
            this.mCallback = new O000000o() {
                /* class com.xiaomi.smarthome.smartconfig.HideDeviceEntranceAct.AnonymousClass6 */
                private long O00000o0 = 0;

                public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                }

                public final void onStart(String str, PluginDownloadTask pluginDownloadTask) {
                    this.O00000o0 = System.currentTimeMillis();
                }

                public final void onProgress(String str, float f) {
                    if (!this.O00000Oo) {
                        HideDeviceEntranceAct.this.mBtnAdd.setProgress((int) (f * 100.0f));
                    }
                }

                public final void onSuccess(String str) {
                    if (this.O00000o0 > 0 && str != null) {
                        hxi.O0000Oo.O000000o(System.currentTimeMillis() - this.O00000o0, str);
                    }
                    gnk.O00000oO("Plugin Download onSuccess");
                    if (!this.O00000Oo) {
                        HideDeviceEntranceAct.this.onPluginDownloadComplete();
                    }
                }

                public final void onFailure(PluginError pluginError) {
                    gnk.O00000oO("Plugin Download onFailure");
                    if (!this.O00000Oo) {
                        gqg.O00000Oo(pluginError.O000000o(HideDeviceEntranceAct.this.getContext()));
                        HideDeviceEntranceAct.this.onPluginDownloadComplete();
                    }
                }

                public final void onCancel() {
                    gnk.O00000oO("Plugin Download onCancel");
                    if (!this.O00000Oo) {
                        izb.O000000o(HideDeviceEntranceAct.this.getContext(), (int) R.string.fimi_add_failed, 0).show();
                        HideDeviceEntranceAct.this.reset();
                    }
                }
            };
            CoreApi.O000000o().O000000o(this.mDevice.model, true, (CoreApi.O0000OOo) this.mCallback);
            return;
        }
        this.mHandler.sendEmptyMessage(1);
    }

    public void onPluginDownloadComplete() {
        Home O0000Oo0;
        gnk.O00000o0(String.format("onPluginDownloadComplete", new Object[0]));
        izb.O000000o(this, (int) R.string.fimi_add_success, 0).show();
        O000000o(8);
        this.O00000oO.setVisibility(0);
        if (!isFinishing()) {
            DeviceRouterFactory.getDeviceHelper().setTemporaryDeviceShow(this.mDevice.model, true);
            fno.O000000o().O000000o(this.mDevice);
            Device device = this.mDevice;
            if (device != null && (O0000Oo0 = ggb.O00000Oo().O0000Oo0()) != null) {
                ggb.O00000Oo().O000000o(O0000Oo0, (Room) null, device, (ggb.O00000o) null);
            }
        }
    }

    private void O000000o(int i) {
        this.mBtnAdd.setVisibility(i);
    }

    public void reset() {
        this.mBtnAdd.setButtonMode(0);
        O000000o(0);
        this.mBtnAdd.setText((int) R.string.add_btn_text);
        this.O00000oO.setVisibility(8);
        this.mBtnAdd.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.HideDeviceEntranceAct.AnonymousClass8 */

            public final void onClick(View view) {
                HideDeviceEntranceAct.this.startDownloadingPlugin();
            }
        });
    }

    static abstract class O000000o implements CoreApi.O0000OOo {
        boolean O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }
}
