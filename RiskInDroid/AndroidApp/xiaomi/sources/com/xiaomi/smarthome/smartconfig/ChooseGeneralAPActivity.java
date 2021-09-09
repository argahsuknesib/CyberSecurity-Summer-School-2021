package com.xiaomi.smarthome.smartconfig;

import _m_j.fno;
import _m_j.gnk;
import _m_j.gqg;
import _m_j.htv;
import _m_j.htw;
import _m_j.hxi;
import _m_j.izb;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.ProgressButton;
import com.xiaomi.smarthome.miio.device.GeneralAPDevice;
import com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity;

public class ChooseGeneralAPActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleDraweeView f11426O000000o;
    private TextView O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    private View O00000oO;
    private PluginDeviceInfo O00000oo;
    public ProgressButton mBtnAdd;
    public O000000o mCallback;
    public GeneralAPDevice mDevice;
    public int mScType;
    public TextView mTvRight;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.feimi_choose);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("model");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        this.mScType = intent.getIntExtra("sc_type", 7);
        this.mDevice = DeviceRouterFactory.getDeviceHelper().newGeneralAPDevice(stringExtra);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ChooseGeneralAPActivity.AnonymousClass1 */

            public final void onClick(View view) {
                ChooseGeneralAPActivity.this.finish();
            }
        });
        this.O00000oO = findViewById(R.id.bottom_btn_container);
        this.O00000o = (TextView) findViewById(R.id.left_btn);
        this.mTvRight = (TextView) findViewById(R.id.right_btn);
        findViewById(R.id.title_bar).setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        this.O00000Oo = (TextView) findViewById(R.id.name);
        this.O00000o0 = (TextView) findViewById(R.id.desc);
        this.mBtnAdd = (ProgressButton) findViewById(R.id.add_btn);
        this.f11426O000000o = (SimpleDraweeView) findViewById(R.id.icon);
        this.f11426O000000o.setHierarchy(new GenericDraweeHierarchyBuilder(this.f11426O000000o.getResources()).setPlaceholderImage(getResources().getDrawable(R.drawable.device_list_phone_no)).setFadeDuration(200).build());
        this.O00000oo = CoreApi.O000000o().O00000oO(this.mDevice.model);
        PluginDeviceInfo pluginDeviceInfo = this.O00000oo;
        if (pluginDeviceInfo != null) {
            this.O00000Oo.setText(pluginDeviceInfo.O0000Oo0());
            this.O00000o0.setText(this.O00000oo.O0000o0o());
            this.f11426O000000o.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.O00000oo.O0000o0())).build())).build());
        }
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ChooseGeneralAPActivity.AnonymousClass2 */

            public final void onClick(View view) {
                ChooseGeneralAPActivity.this.finish();
            }
        });
        this.mTvRight.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ChooseGeneralAPActivity.AnonymousClass3 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("scene_type", ChooseGeneralAPActivity.this.mScType);
                PluginApi instance = PluginApi.getInstance();
                ChooseGeneralAPActivity chooseGeneralAPActivity = ChooseGeneralAPActivity.this;
                instance.sendMessage(chooseGeneralAPActivity, chooseGeneralAPActivity.mDevice.model, 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(ChooseGeneralAPActivity.this.mDevice), null, ChooseGeneralAPActivity.this.mScType == 9, new SendMessageCallback() {
                    /* class com.xiaomi.smarthome.smartconfig.ChooseGeneralAPActivity.AnonymousClass3.AnonymousClass1 */

                    public final void onMessageSuccess(Intent intent) {
                        String stringExtra = intent.getStringExtra("value");
                        Intent intent2 = new Intent(ChooseGeneralAPActivity.this, InitDeviceRoomActivity.class);
                        intent2.putExtra("device_id", stringExtra);
                        ChooseGeneralAPActivity.this.startActivity(intent2);
                        ChooseGeneralAPActivity.this.finishConnect();
                    }

                    public final void onSendSuccess(Bundle bundle) {
                        ChooseGeneralAPActivity.this.finishConnect();
                    }
                });
            }
        });
        final PluginPackageInfo O0000OoO = CoreApi.O000000o().O0000OoO(this.mDevice.model);
        if (this.mScType == 9) {
            this.mBtnAdd.setText((int) R.string.family_add_member_immediately);
        } else if (O0000OoO != null) {
            this.mBtnAdd.setText((int) R.string.open_imediate);
        } else {
            this.mBtnAdd.setText((int) R.string.add_btn_text);
        }
        this.mBtnAdd.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ChooseGeneralAPActivity.AnonymousClass4 */

            public final void onClick(View view) {
                if (O0000OoO != null) {
                    ChooseGeneralAPActivity.this.mTvRight.performClick();
                } else {
                    ChooseGeneralAPActivity.this.startDownloadingPlugin();
                }
            }
        });
    }

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
    public void finishConnect() {
        Intent intent = new Intent();
        intent.putExtra("finish", true);
        setResult(-1, intent);
        finish();
    }

    static abstract class O000000o implements CoreApi.O0000OOo {
        boolean O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    private void O000000o(int i) {
        this.mBtnAdd.setVisibility(i);
    }

    public void reset() {
        this.mBtnAdd.setButtonMode(0);
        O000000o(0);
        if (this.mScType == 9) {
            this.mBtnAdd.setText((int) R.string.family_add_member_immediately);
        } else {
            this.mBtnAdd.setText((int) R.string.add_btn_text);
        }
        this.O00000oO.setVisibility(8);
        this.mBtnAdd.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ChooseGeneralAPActivity.AnonymousClass5 */

            public final void onClick(View view) {
                ChooseGeneralAPActivity.this.startDownloadingPlugin();
            }
        });
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            int i = message.arg1;
            this.mBtnAdd.setProgress(i);
            if (i == 100) {
                onPluginDownloadComplete();
                return;
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, i + 1, 0), 10);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.smartconfig.ChooseGeneralAPActivity$O000000o]
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
            /* class com.xiaomi.smarthome.smartconfig.ChooseGeneralAPActivity.AnonymousClass6 */

            public final void onClick(View view) {
                if (ChooseGeneralAPActivity.this.mCallback != null) {
                    ChooseGeneralAPActivity.this.mCallback.O00000Oo = true;
                }
                ChooseGeneralAPActivity.this.mHandler.removeCallbacksAndMessages(null);
                ChooseGeneralAPActivity.this.reset();
            }
        });
        this.O00000oO.setVisibility(8);
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(this.mDevice.model);
        PluginPackageInfo O0000OoO = CoreApi.O000000o().O0000OoO(this.mDevice.model);
        if (O0000Oo == null && O0000OoO == null) {
            this.mCallback = new O000000o() {
                /* class com.xiaomi.smarthome.smartconfig.ChooseGeneralAPActivity.AnonymousClass7 */
                private long O00000o0 = 0;

                public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                }

                public final void onStart(String str, PluginDownloadTask pluginDownloadTask) {
                    this.O00000o0 = System.currentTimeMillis();
                }

                public final void onProgress(String str, float f) {
                    if (!this.O00000Oo) {
                        ChooseGeneralAPActivity.this.mBtnAdd.setProgress((int) (f * 100.0f));
                    }
                }

                public final void onSuccess(String str) {
                    if (this.O00000o0 > 0 && str != null) {
                        hxi.O0000Oo.O000000o(System.currentTimeMillis() - this.O00000o0, str);
                    }
                    gnk.O00000oO("Plugin Download onSuccess");
                    if (!this.O00000Oo) {
                        ChooseGeneralAPActivity.this.onPluginDownloadComplete();
                    }
                }

                public final void onFailure(PluginError pluginError) {
                    gnk.O00000oO("Plugin Download onFailure");
                    if (!this.O00000Oo) {
                        gqg.O00000Oo(pluginError.O000000o(ChooseGeneralAPActivity.this.getContext()));
                        ChooseGeneralAPActivity.this.reset();
                    }
                }

                public final void onCancel() {
                    gnk.O00000oO("Plugin Download onCancel");
                    if (!this.O00000Oo) {
                        izb.O000000o(ChooseGeneralAPActivity.this.getContext(), (int) R.string.fimi_add_failed, 0).show();
                        ChooseGeneralAPActivity.this.reset();
                    }
                }
            };
            CoreApi.O000000o().O000000o(this.mDevice.model, true, (CoreApi.O0000OOo) this.mCallback);
            return;
        }
        this.mHandler.sendEmptyMessage(1);
    }

    public void onPluginDownloadComplete() {
        gnk.O00000o0(String.format("onPluginDownloadComplete", new Object[0]));
        izb.O000000o(this, (int) R.string.fimi_add_success, 0).show();
        if (this.mScType == 9) {
            O000000o(0);
            this.mBtnAdd.setButtonMode(0);
            this.mBtnAdd.setText((int) R.string.family_add_member_immediately);
            this.mTvRight.performClick();
            this.O00000oO.setVisibility(8);
        } else {
            O000000o(8);
            this.O00000oO.setVisibility(0);
        }
        if (!isFinishing() && this.mScType == 7) {
            DeviceRouterFactory.getDeviceHelper().addGeneralAPDevice(this.mDevice);
            DeviceRouterFactory.getDeviceHelper().setGeneralAPDeviceEnable(true, this.mDevice.model);
            fno.O000000o().O000000o(this.mDevice);
            htw O000000o2 = htv.O000000o();
            if (O000000o2 != null) {
                O000000o2.setCurrentScrollToDid(this.mDevice.did);
            }
        }
    }
}
