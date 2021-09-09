package com.xiaomi.smarthome.device;

import _m_j.eyr;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.flk;
import _m_j.fno;
import _m_j.fqg;
import _m_j.fqr;
import _m_j.fqy;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.fux;
import _m_j.fwq;
import _m_j.gnl;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.hna;
import _m_j.htt;
import _m_j.htv;
import _m_j.htw;
import _m_j.huf;
import _m_j.hvg;
import _m_j.hxb;
import _m_j.hxc;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxy;
import _m_j.inc;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.qrcode.QrCodeParser;
import com.xiaomi.qrcode.ScanBarcodeActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.ResetDevicePage;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.FDDeviceApi;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.widget.CircleProgressBar;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.wificonfig.RescanWifiActivity;
import com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class ResetDevicePage extends BaseActivity {
    public View flCountDown;
    private View flError;
    public CheckBox mCheckBox;
    protected Stack<hxy> mConfigStatInfos = new Stack<>();
    private int mConnectTime;
    private TextView mDeviceDetail;
    public List<Device> mDeviceList;
    public String mGatewayDid;
    public int mGatewayStartRetry;
    private boolean mIsSubDeviceConfig = false;
    public boolean mIsSubDeviceConfigSuccess = false;
    private String mLastAnalysisErrorCode;
    public Button mNextBtn;
    private SmartHomeWebView mResetWebView;
    public String mRestModel;
    public List<Device> mResult;
    public Runnable mRun;
    public PluginDeviceInfo mSelectRecord;
    public boolean mShowTimeout;
    private int mSource;
    private TextView mTvRight;
    private String mUnique;
    public boolean mWaitingLocationResult = false;
    public CircleProgressBar progressBar;
    public TextView tvTime;

    static /* synthetic */ String lambda$scanSubdevice$3(String str) throws JSONException {
        return str;
    }

    static /* synthetic */ String lambda$scanSubdevice$4(String str) throws JSONException {
        return str;
    }

    static /* synthetic */ String lambda$scanSubdevice$5(String str) throws JSONException {
        return str;
    }

    public static void showActivity(Activity activity, PluginDeviceInfo pluginDeviceInfo, int i, Bundle bundle) {
        Intent intent = new Intent(activity, ResetDevicePage.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        pluginDeviceInfo.O00000Oo();
        fqy.O000000o(intent, 3);
        intent.putExtra("model", pluginDeviceInfo.O00000Oo());
        intent.putExtra("plugin_record", pluginDeviceInfo);
        activity.startActivityForResult(intent, i);
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
    public void onBackPressed() {
        List<Device> list;
        Device O000000o2;
        PluginDeviceInfo pluginDeviceInfo = this.mSelectRecord;
        if (pluginDeviceInfo != null && pluginDeviceInfo.O0000o() == Device.PID_SUBDEVICE && (((list = this.mResult) == null || list.size() == 0) && (O000000o2 = fno.O000000o().O000000o(this.mGatewayDid)) != null)) {
            scanSubdevice(O000000o2, new QrCodeParser(getIntent().getStringExtra("nbiot")), 0, null);
        }
        Intent intent = new Intent();
        intent.putExtra("finish", false);
        setResult(-1, intent);
        finish();
    }

    public boolean isLocationEnable() {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        if (!fwq.O00000Oo() || !fwq.O000000o()) {
            return false;
        }
        return true;
    }

    public boolean checkLocation() {
        if (isLocationEnable()) {
            return true;
        }
        fux.O000000o(this, (int) R.string.permission_location_rational_desc_new, new fux.O000000o() {
            /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass1 */

            public final void O000000o(boolean z) {
                ResetDevicePage.this.mWaitingLocationResult = false;
                hxi.O00000o0.O000000o(z ? 1 : 2, 2);
            }

            public final void O00000Oo(boolean z) {
                ResetDevicePage.this.mWaitingLocationResult = false;
                hxi.O00000o.O0000oo0(z ? 2 : 4);
            }

            public final void O00000o0(boolean z) {
                hxi.O00000o.O0000oo0(z ? 1 : 3);
                ResetDevicePage.this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        ResetDevicePage.this.mWaitingLocationResult = true;
                    }
                }, 800);
            }
        });
        return false;
    }

    @SuppressLint({"CheckResult"})
    public void onCreate(Bundle bundle) {
        PluginDeviceInfo pluginDeviceInfo;
        super.onCreate(bundle);
        setContentView((int) R.layout.choose_device_failed_page);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass7 */

            public final void onClick(View view) {
                ResetDevicePage.this.onBackPressed();
            }
        });
        this.mNextBtn = (Button) findViewById(R.id.next_btn);
        this.mTvRight = (TextView) findViewById(R.id.module_a_3_right_tv_text);
        this.mResetWebView = (SmartHomeWebView) findViewById(R.id.kuailian_reset_web_view);
        this.mCheckBox = (CheckBox) findViewById(R.id.check_box_confirm);
        this.flError = findViewById(R.id.flError);
        this.flCountDown = findViewById(R.id.flCountDown);
        this.progressBar = (CircleProgressBar) findViewById(R.id.ccv);
        this.tvTime = (TextView) findViewById(R.id.tvTime);
        TextView textView = (TextView) findViewById(R.id.tips);
        this.mTvRight.setText((int) R.string.mj_scan_barcode);
        this.mDeviceDetail = (TextView) findViewById(R.id.device_detail);
        final Intent intent = getIntent();
        if (intent != null) {
            this.mRestModel = intent.getStringExtra("model");
            this.mSelectRecord = (PluginDeviceInfo) intent.getParcelableExtra("plugin_record");
            this.mGatewayDid = intent.getStringExtra("gateway_did");
            this.mSource = intent.getIntExtra("connect_source", 0);
            this.mUnique = intent.getStringExtra("connect_unique");
            if (this.mRestModel == null && (pluginDeviceInfo = this.mSelectRecord) != null) {
                this.mRestModel = pluginDeviceInfo.O00000Oo();
            }
            if (intent.getBooleanExtra("scan_from_miui", false)) {
                if (htt.O000000o(this.mRestModel)) {
                    fbt fbt = new fbt(this, "ConfigRouterStationActivity");
                    fbt.O000000o("model", this.mRestModel);
                    if (intent.hasExtra("mac")) {
                        fbt.O000000o("mac", intent.getStringExtra("mac"));
                    }
                    if (intent.hasExtra("key_qrcode_oob")) {
                        fbt.O000000o("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
                    }
                    fbs.O000000o(fbt);
                    finish();
                    return;
                } else if (htt.O00000Oo(this.mRestModel)) {
                    fbt fbt2 = new fbt(this, "ConfigRouterSubDeviceActivity");
                    fbt2.O000000o("device_model", this.mRestModel);
                    fbt2.O000000o("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
                    fbt2.O000000o("mac", intent.getStringExtra("mac"));
                    fbs.O000000o(fbt2);
                    finish();
                    return;
                }
            }
        }
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass8 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                hxk hxk = hxi.O00000o;
                String str = ResetDevicePage.this.mRestModel;
                hxb O00000Oo = hxi.O0000Oo.O00000Oo();
                hxk.f952O000000o.O000000o("add_wait_yellow", "model", str, "add_device_session", Long.valueOf(O00000Oo.f939O000000o), "add_device_order", Integer.valueOf(O00000Oo.O00000Oo.incrementAndGet()));
                ResetDevicePage.this.mNextBtn.setEnabled(z);
                if (z) {
                    hxi.O00000o.O0000o00(ResetDevicePage.this.mRestModel);
                }
            }
        });
        findViewById(R.id.check_box_root).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass9 */

            public final void onClick(View view) {
                ResetDevicePage.this.mCheckBox.setChecked(!ResetDevicePage.this.mCheckBox.isChecked());
            }
        });
        this.mResetWebView.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass10 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.mTvRight.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass11 */

            public final void onClick(View view) {
                hna.O000000o().checkPassedForCamera(ResetDevicePage.this, true, new inc() {
                    /* class com.xiaomi.smarthome.device.$$Lambda$ResetDevicePage$11$1CX6q7gBXOOOfmO5HEkevXVXZuI */

                    public final void onAction(List list) {
                        ResetDevicePage.AnonymousClass11.this.O000000o(list);
                    }
                });
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(List list) {
                Intent intent = new Intent(ResetDevicePage.this.getContext(), ScanBarcodeActivity.class);
                intent.putExtra("from", 200);
                intent.putExtra("desc", ResetDevicePage.this.getString(R.string.msg_default_status3));
                intent.putExtra("pid", String.valueOf(ResetDevicePage.this.mSelectRecord.O00000o0()));
                ResetDevicePage.this.startActivityForResult(intent, 11);
            }
        });
        if (this.mRestModel != null) {
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(this.mRestModel);
            if (O00000oO != null) {
                ((TextView) findViewById(R.id.module_a_3_return_title)).setText(O00000oO.O0000Oo0());
            }
            if (this.mSelectRecord == null) {
                this.mSelectRecord = O00000oO;
            }
            PluginDeviceInfo pluginDeviceInfo2 = this.mSelectRecord;
            if (pluginDeviceInfo2 == null) {
                finish();
                return;
            }
            if (pluginDeviceInfo2.O0000o() == Device.PID_SUBDEVICE) {
                this.mCheckBox.setVisibility(8);
                requestGatewayStart(new QrCodeParser(getIntent().getStringExtra("nbiot")));
                textView.setVisibility(8);
            } else {
                this.mNextBtn.setEnabled(this.mCheckBox.isChecked());
            }
            try {
                initWebView();
                rightVisible();
            } catch (Exception e) {
                e.printStackTrace();
            }
            final int O00000o = this.mSelectRecord.O00000o();
            if (O00000o == 25) {
                textView.setText(getString(R.string.confirm_operation));
                openBluetoothTips();
                this.mNextBtn.setOnClickListener(new View.OnClickListener(O00000o) {
                    /* class com.xiaomi.smarthome.device.$$Lambda$ResetDevicePage$JBMvRQNUud8SUkdr8Zyva94c6As */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        ResetDevicePage.this.lambda$onCreate$0$ResetDevicePage(this.f$1, view);
                    }
                });
            } else if (O00000o == 5) {
                textView.setText(getString(R.string.confirm_operation));
                this.mNextBtn.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass12 */

                    public final void onClick(View view) {
                        hxi.O00000o.O0000o0(ResetDevicePage.this.mRestModel);
                        hxi.O00000o.O000000o(System.currentTimeMillis());
                        if (ResetDevicePage.this.checkLocation()) {
                            hna.O000000o().checkPassedForCamera(ResetDevicePage.this, true, new inc() {
                                /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass12.AnonymousClass1 */

                                public final void onAction(List<String> list) {
                                    hxi.O00000o.O00000Oo(ResetDevicePage.this.mRestModel);
                                    fbt fbt = new fbt(ResetDevicePage.this.getContext(), "SmartConfigMainActivity");
                                    if (ResetDevicePage.this.getIntent() != null) {
                                        fbt.O000000o("connect_source", ResetDevicePage.this.getIntent().getIntExtra("connect_source", 0));
                                        fbt.O000000o("connect_unique", ResetDevicePage.this.getIntent().getStringExtra("connect_unique"));
                                    }
                                    fbt.O000000o("strategy_id", 5);
                                    fbt.O000000o("model", ResetDevicePage.this.mRestModel);
                                    if (ResetDevicePage.this.getIntent() != null && ResetDevicePage.this.getIntent().hasExtra("key_qrcode_oob")) {
                                        fbt.O000000o("key_qrcode_oob", ResetDevicePage.this.getIntent().getStringExtra("key_qrcode_oob"));
                                    }
                                    fbt.O000000o(100);
                                    fbs.O000000o(fbt);
                                }
                            });
                        }
                    }
                });
            } else {
                if (O00000o == 4) {
                    textView.setText(getString(R.string.smart_config_xiaofang_checkbox_text));
                } else {
                    textView.setText(getString(R.string.confirm_operation));
                }
                this.mNextBtn.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass13 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                     arg types: [java.lang.String, android.net.wifi.ScanResult]
                     candidates:
                      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
                      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
                    public final void onClick(View view) {
                        fbt fbt;
                        hxi.O00000o.O00000Oo(ResetDevicePage.this.mRestModel);
                        hxi.O00000o.O0000o0(ResetDevicePage.this.mRestModel);
                        hxi.O00000o.O000000o(System.currentTimeMillis());
                        if (ResetDevicePage.this.mSelectRecord.O0000o() != Device.PID_BLE_MESH) {
                            int i = O00000o;
                            if (i == 2 || i == 18) {
                                if (ResetDevicePage.this.checkLocation()) {
                                    Intent intent = new Intent(ResetDevicePage.this.getContext(), ScanChooseBluetoothDevice.class);
                                    intent.putExtra("model", ResetDevicePage.this.mSelectRecord.O00000Oo());
                                    intent.putExtra("deviceName", ResetDevicePage.this.mSelectRecord.O0000Oo0());
                                    Intent intent2 = intent;
                                    if (intent2 != null) {
                                        if (intent2.hasExtra("key_qrcode_oob")) {
                                            intent.putExtra("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
                                        }
                                        if (intent.hasExtra("mac")) {
                                            intent.putExtra("mac", intent.getStringExtra("mac"));
                                        }
                                    }
                                    hvg.O000000o(ResetDevicePage.this).O00000Oo(0);
                                    ResetDevicePage.this.startActivityForResult(intent, 100);
                                }
                            } else if (i == 15) {
                                ResetDevicePage.this.startNbiotConfig();
                            } else if (ResetDevicePage.this.mSelectRecord.O0000o() == Device.PID_SUBDEVICE) {
                                ResetDevicePage.this.startZigbeeConfig();
                            } else if (ResetDevicePage.this.checkLocation()) {
                                if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                                    fbt = new fbt(ResetDevicePage.this.getContext(), RescanWifiV2Activity.TAG);
                                } else {
                                    fbt = new fbt(ResetDevicePage.this.getContext(), RescanWifiActivity.TAG);
                                }
                                if (ResetDevicePage.this.getIntent() != null) {
                                    fbt.O000000o("connect_source", ResetDevicePage.this.getIntent().getIntExtra("connect_source", 0));
                                    fbt.O000000o("connect_unique", ResetDevicePage.this.getIntent().getStringExtra("connect_unique"));
                                    fbt.O000000o("from_miui", ResetDevicePage.this.getIntent().getBooleanExtra("from_miui", false));
                                    fbt.O000000o("mac", ResetDevicePage.this.getIntent().getStringExtra("mac"));
                                    ScanResult scanResult = (ScanResult) ResetDevicePage.this.getIntent().getParcelableExtra("scanResult");
                                    if (scanResult != null) {
                                        fbt.O000000o("scanResult", (Parcelable) scanResult);
                                    }
                                }
                                fbt.O000000o("model", ResetDevicePage.this.mSelectRecord.O00000Oo());
                                if (ResetDevicePage.this.getIntent() != null && ResetDevicePage.this.getIntent().hasExtra("key_qrcode_oob")) {
                                    fbt.O000000o("key_qrcode_oob", ResetDevicePage.this.getIntent().getStringExtra("key_qrcode_oob"));
                                }
                                fbt.O000000o(100);
                                fbs.O000000o(fbt);
                            }
                        } else if (ResetDevicePage.this.checkLocation()) {
                            Intent intent3 = new Intent(ResetDevicePage.this.getContext(), ScanChooseBluetoothDevice.class);
                            fqy.O000000o(intent3, ResetDevicePage.this);
                            intent3.putExtra("model", ResetDevicePage.this.mSelectRecord.O00000Oo());
                            intent3.putExtra("deviceName", ResetDevicePage.this.mSelectRecord.O0000Oo0());
                            hvg.O000000o(ResetDevicePage.this).O00000Oo(0);
                            ResetDevicePage.this.startActivityForResult(intent3, 100);
                        }
                    }
                });
            }
            SmartConfigRouterFactory.getSmartConfigManager().getDeviceDetailPageUrl(this.mRestModel, new huf() {
                /* class com.xiaomi.smarthome.device.$$Lambda$ResetDevicePage$uzWWd6aFjJpOcAOgOe7e3s865a0 */

                public final void accept(String str) {
                    ResetDevicePage.this.lambda$onCreate$2$ResetDevicePage(str);
                }
            });
            hxi.O00000o0.O000000o(this.mRestModel);
        }
    }

    public /* synthetic */ void lambda$onCreate$0$ResetDevicePage(int i, View view) {
        hxi.O00000o.O0000o0(this.mRestModel);
        hxi.O00000o.O000000o(System.currentTimeMillis());
        if (i == 25 && checkLocation() && openBluetoothTips()) {
            Intent intent = new Intent(getContext(), ScanChooseBluetoothDevice.class);
            intent.putExtra("model", this.mSelectRecord.O00000Oo());
            intent.putExtra("deviceName", this.mSelectRecord.O0000Oo0());
            if (getIntent() != null) {
                intent.putExtra("connect_source", getIntent().getIntExtra("connect_source", 0));
                intent.putExtra("connect_unique", getIntent().getStringExtra("connect_unique"));
            }
            hvg.O000000o(this).O00000Oo(0);
            startActivityForResult(intent, 100);
        }
    }

    public /* synthetic */ void lambda$onCreate$2$ResetDevicePage(String str) {
        this.mDeviceDetail.setVisibility(0);
        this.mDeviceDetail.setOnClickListener(new View.OnClickListener(str) {
            /* class com.xiaomi.smarthome.device.$$Lambda$ResetDevicePage$d7Kk3SPSgCUW_A47SL6oe5OsKFw */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ResetDevicePage.this.lambda$null$1$ResetDevicePage(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$null$1$ResetDevicePage(String str, View view) {
        OperationCommonWebViewActivity.start(getContext(), str, null);
        hxi.O00000o.O0000o0o(this.mRestModel);
    }

    private boolean openBluetoothTips() {
        if (gnl.O00000Oo()) {
            return true;
        }
        fqr.O000000o(this, new BleResponse() {
            /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass14 */

            public final void onResponse(int i, Object obj) {
            }
        });
        return false;
    }

    private void rightVisible() {
        this.mTvRight.setVisibility(8);
    }

    private void initWebView() {
        String str;
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        String O00000Oo = this.mSelectRecord.O00000Oo();
        String str2 = "";
        if (this.mSelectRecord.O0000ooo == 2) {
            if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                StringBuilder sb = new StringBuilder("https://");
                if (O0000ooO != null) {
                    str2 = O0000ooO.f7546O000000o + ".";
                }
                sb.append(str2);
                sb.append("home.mi.com/views/productConfig.html?model=");
                sb.append(O00000Oo);
                sb.append("&key=ble_reset&locale=");
                sb.append(flk.O000000o(O00oOooo));
                str = sb.toString();
            } else {
                str = "https://home.mi.com/views/productConfig.html?model=" + O00000Oo + "&key=ble_reset&locale=" + flk.O000000o(O00oOooo);
            }
        } else if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            ServerBean O0000ooO2 = CoreApi.O000000o().O0000ooO();
            StringBuilder sb2 = new StringBuilder("https://");
            if (O0000ooO2 != null) {
                str2 = O0000ooO2.f7546O000000o + ".";
            }
            sb2.append(str2);
            sb2.append("home.mi.com/views/deviceReset.html?model=");
            sb2.append(O00000Oo);
            sb2.append("&locale=");
            sb2.append(flk.O000000o(O00oOooo));
            str = sb2.toString();
        } else {
            str = "https://home.mi.com/views/deviceReset.html?model=" + O00000Oo + "&locale=" + flk.O000000o(O00oOooo);
        }
        this.mResetWebView.loadUrl(str);
    }

    public void onResume() {
        super.onResume();
        hxc.O000000o().O000000o(this.mRestModel, BindStep.STEP_RESET_DEVICE);
        if (this.mWaitingLocationResult) {
            this.mWaitingLocationResult = false;
            hxi.O00000o.O0000oo(fux.O000000o() ? 1 : 2);
        }
    }

    public void onPause() {
        super.onPause();
        hxc.O000000o().O00000o0(this.mRestModel, BindStep.STEP_RESET_DEVICE);
    }

    public void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getStringExtra("model") != null) {
            this.mCheckBox.setChecked(false);
            this.mRestModel = intent.getStringExtra("model");
            this.mSelectRecord = CoreApi.O000000o().O00000oO(this.mRestModel);
            if (this.mSelectRecord == null) {
                finish();
                return;
            }
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText(this.mSelectRecord.O0000Oo0());
            initWebView();
            this.mNextBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass2 */

                public final void onClick(View view) {
                    hxi.O00000o.O0000o0(ResetDevicePage.this.mRestModel);
                    int O00000o = ResetDevicePage.this.mSelectRecord.O00000o();
                    if (ResetDevicePage.this.mSelectRecord.O0000o() == Device.PID_BLE_MESH) {
                        if (ResetDevicePage.this.checkLocation()) {
                            Intent intent = new Intent(ResetDevicePage.this.getContext(), ScanChooseBluetoothDevice.class);
                            fqy.O000000o(intent, ResetDevicePage.this);
                            intent.putExtra("model", ResetDevicePage.this.mSelectRecord.O00000Oo());
                            intent.putExtra("deviceName", ResetDevicePage.this.mSelectRecord.O0000Oo0());
                            ResetDevicePage.this.startActivityForResult(intent, 100);
                        }
                    } else if (O00000o == 2) {
                        if (ResetDevicePage.this.checkLocation()) {
                            Intent intent2 = new Intent(ResetDevicePage.this.getContext(), ScanChooseBluetoothDevice.class);
                            intent2.putExtra("model", ResetDevicePage.this.mSelectRecord.O00000Oo());
                            intent2.putExtra("deviceName", ResetDevicePage.this.mSelectRecord.O0000Oo0());
                            if (intent.hasExtra("key_qrcode_oob")) {
                                intent2.putExtra("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
                            }
                            ResetDevicePage.this.startActivity(intent2);
                        }
                    } else if (O00000o == 15) {
                        ResetDevicePage.this.startNbiotConfig();
                    } else if (ResetDevicePage.this.mSelectRecord.O0000o() == Device.PID_SUBDEVICE) {
                        ResetDevicePage.this.startZigbeeConfig();
                    } else if (ResetDevicePage.this.checkLocation()) {
                        hna.O000000o().checkPassedForCamera(ResetDevicePage.this, true, new inc() {
                            /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass2.AnonymousClass1 */

                            public final void onAction(List<String> list) {
                                fbt fbt = new fbt(ResetDevicePage.this.getContext(), "SmartConfigMainActivity");
                                if (ResetDevicePage.this.getIntent() != null) {
                                    fbt.O000000o("connect_source", ResetDevicePage.this.getIntent().getIntExtra("connect_source", 0));
                                    fbt.O000000o("connect_unique", ResetDevicePage.this.getIntent().getStringExtra("connect_unique"));
                                }
                                fbt.O000000o("strategy_id", 5);
                                fbt.O000000o("model", ResetDevicePage.this.mRestModel);
                                if (ResetDevicePage.this.getIntent() != null && ResetDevicePage.this.getIntent().hasExtra("key_qrcode_oob")) {
                                    fbt.O000000o("key_qrcode_oob", ResetDevicePage.this.getIntent().getStringExtra("key_qrcode_oob"));
                                }
                                fbt.O000000o(100);
                                fbs.O000000o(fbt);
                            }
                        });
                    }
                }
            });
        }
    }

    public void startNbiotConfig() {
        if (TextUtils.isEmpty(getIntent().getStringExtra("nbiot"))) {
            hna.O000000o().checkPassedForCamera(this, true, new inc() {
                /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass3 */

                public final void onAction(List<String> list) {
                    Intent intent = new Intent(ResetDevicePage.this.getContext(), ScanBarcodeActivity.class);
                    intent.putExtra("from", 200);
                    intent.putExtra("desc", ResetDevicePage.this.getString(R.string.msg_default_status3));
                    intent.putExtra("pid", String.valueOf(ResetDevicePage.this.mSelectRecord.O00000o0()));
                    ResetDevicePage.this.startActivityForResult(intent, 12);
                }
            });
            return;
        }
        fbt fbt = new fbt(getContext(), "SmartConfigMainActivity");
        if (getIntent() != null) {
            fbt.O000000o("connect_source", getIntent().getIntExtra("connect_source", 0));
            fbt.O000000o("connect_unique", getIntent().getStringExtra("connect_unique"));
        }
        String stringExtra = getIntent().getStringExtra("nbiot");
        fbt.O000000o("scan_qr_code", stringExtra);
        gsy.O00000Oo(LogType.KUAILIAN, "ResetDevicePage", "resultDevice SC_NBIOT qrCode:".concat(String.valueOf(stringExtra)));
        if (TextUtils.isEmpty(stringExtra)) {
            gsy.O00000Oo(LogType.KUAILIAN, "ResetDevicePage", "qr code is null can`t show connect step");
            return;
        }
        fbt.O000000o("model", this.mRestModel);
        fbt.O000000o("strategy_id", 12);
        fbt.O000000o(100);
        fbs.O000000o(fbt);
        onBackPressed();
    }

    public void startZigbeeConfig() {
        List<Device> list = this.mResult;
        if (list == null || list.size() == 0) {
            requestGatewayStart(new QrCodeParser(getIntent().getStringExtra("nbiot")));
        } else if (isValid()) {
            fbt fbt = new fbt(getContext(), "SmartConfigMainActivity");
            if (getIntent() != null) {
                fbt.O000000o("connect_source", getIntent().getIntExtra("connect_source", 0));
                fbt.O000000o("connect_unique", getIntent().getStringExtra("connect_unique"));
            }
            String stringExtra = getIntent().getStringExtra("nbiot");
            LogType logType = LogType.KUAILIAN;
            gsy.O00000Oo(logType, "ResetDevicePage", "resultDevice SC_NBIOT qrCode:" + stringExtra + " model:" + this.mRestModel + " gateway_did:" + this.mGatewayDid);
            if (TextUtils.isEmpty(this.mGatewayDid)) {
                gsy.O00000Oo(LogType.KUAILIAN, "ResetDevicePage", "gateway did is null can`t show connect step");
                return;
            }
            fbt.O000000o("did", this.mResult.get(0).did).O000000o("scan_qr_code", stringExtra).O000000o("strategy_id", 14).O000000o("gateway_did", this.mGatewayDid).O000000o("model", this.mRestModel).O000000o(100);
            fbs.O000000o(fbt);
            onBackPressed();
        }
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
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 11) {
            if (i2 == -1) {
                getIntent().putExtras(intent);
                rightVisible();
                requestGatewayStart(new QrCodeParser(getIntent().getStringExtra("nbiot")));
            }
        } else if (i != 12) {
            boolean booleanExtra = intent != null ? intent.getBooleanExtra("finish", true) : true;
            if (i2 == 0) {
                booleanExtra = false;
            }
            if (booleanExtra) {
                Intent intent2 = new Intent();
                intent2.putExtra("finish", true);
                if (intent != null) {
                    intent2.putExtras(intent);
                }
                setResult(-1, intent2);
                finish();
            }
        } else if (i2 == -2) {
            getIntent().putExtras(intent);
            startNbiotConfig();
        }
    }

    private void requestGatewayStart(final QrCodeParser qrCodeParser) {
        this.mIsSubDeviceConfig = true;
        if (this.mConnectTime == 0) {
            hxi.O00000o.O00000Oo(this.mRestModel, this.mSource, this.mUnique);
        }
        this.mConnectTime++;
        final Device O000000o2 = fno.O000000o().O000000o(this.mGatewayDid);
        if (O000000o2 == null) {
            gsy.O00000Oo(LogType.KUAILIAN, "ResetDevicePage", "device is null did:" + this.mGatewayDid + " run:" + this.mRun);
        } else if (CoreApi.O000000o().O00000oO(O000000o2.model) == null) {
            gsy.O00000Oo(LogType.KUAILIAN, "ResetDevicePage", "pluginrecord is null model:" + O000000o2.model + " did:" + this.mGatewayDid);
        } else {
            final int i = fqg.O00000Oo.f16899O000000o.O000000o(O000000o2) ? 61000 : 31000;
            if (this.mRun == null) {
                this.mNextBtn.setEnabled(false);
                this.flError.setVisibility(8);
                this.flCountDown.setVisibility(0);
                this.progressBar.setMaxProgress((float) i);
                CircleProgressBar circleProgressBar = this.progressBar;
                int color = getResources().getColor(R.color.mj_color_green_normal);
                int color2 = getResources().getColor(R.color.mj_color_gray_normal);
                circleProgressBar.f9153O000000o = 0;
                circleProgressBar.O00000Oo = color;
                circleProgressBar.O00000oO = color2;
                circleProgressBar.invalidate();
                this.tvTime.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
                int O000000o3 = gpc.O000000o(1.0f);
                CircleProgressBar circleProgressBar2 = this.progressBar;
                circleProgressBar2.O00000o0 = O000000o3;
                circleProgressBar2.O00000o = O000000o3;
                circleProgressBar2.requestLayout();
                final long currentTimeMillis = System.currentTimeMillis() - 1;
                CircleProgressBar circleProgressBar3 = this.progressBar;
                AnonymousClass4 r7 = new Runnable() {
                    /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass4 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    ForegroundColorSpan f7014O000000o = new ForegroundColorSpan(0);
                    RelativeSizeSpan O00000Oo = new RelativeSizeSpan(2.5f);

                    public final void run() {
                        if (ResetDevicePage.this.isValid()) {
                            long currentTimeMillis = (((long) i) - System.currentTimeMillis()) + currentTimeMillis;
                            if (currentTimeMillis > 500) {
                                ResetDevicePage.this.progressBar.setProgress((float) currentTimeMillis);
                                SpannableString spannableString = new SpannableString("s" + (currentTimeMillis / 1000) + "s");
                                int length = spannableString.length();
                                spannableString.setSpan(this.f7014O000000o, 0, 1, 17);
                                spannableString.setSpan(this.O00000Oo, 1, length - 1, 17);
                                ResetDevicePage.this.tvTime.setText(spannableString);
                                ResetDevicePage.this.progressBar.postDelayed(this, 100);
                                return;
                            }
                            ResetDevicePage resetDevicePage = ResetDevicePage.this;
                            resetDevicePage.mShowTimeout = true;
                            if (resetDevicePage.getHandler().hasMessages(264)) {
                                ResetDevicePage.this.getHandler().removeMessages(264);
                                ResetDevicePage resetDevicePage2 = ResetDevicePage.this;
                                resetDevicePage2.checkNewDevice(resetDevicePage2.mGatewayDid);
                            }
                        }
                    }
                };
                this.mRun = r7;
                circleProgressBar3.post(r7);
            }
            FDDeviceApi.getInstance().getSubDevice(this, new String[]{this.mGatewayDid}, new fsm<List<Device>, fso>() {
                /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List<Device> list = (List) obj;
                    ResetDevicePage.this.mDeviceList = list;
                    LogType logType = LogType.KUAILIAN;
                    StringBuilder sb = new StringBuilder("requestGatewayStart subdevices num:");
                    sb.append(list == null ? 0 : list.size());
                    gsy.O00000o0(logType, "ResetDevicePage", sb.toString());
                    ResetDevicePage.this.scanSubdevice(O000000o2, qrCodeParser, (i / 1000) - 1, new Callback<String>() {
                        /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass5.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            gsy.O00000Oo("ResetDevicePage", "requestGatewayStart scanSubdevice success".concat(String.valueOf((String) obj)));
                            ResetDevicePage.this.mGatewayStartRetry = 0;
                            ResetDevicePage.this.mShowTimeout = false;
                            ResetDevicePage.this.checkNewDevice(ResetDevicePage.this.mGatewayDid);
                        }

                        public final void onFailure(int i, String str) {
                            ResetDevicePage.this.onError();
                            LogType logType = LogType.KUAILIAN;
                            gsy.O00000o0(logType, "ResetDevicePage", "requestGatewayStart scanSubdevice onFailure:" + i + " errorInfo:" + str);
                        }
                    });
                }

                public final void onFailure(fso fso) {
                    ResetDevicePage.this.onError();
                    gsy.O00000o0(LogType.KUAILIAN, "ResetDevicePage", "requestGatewayStart onFailure getSubDevice:".concat(String.valueOf(fso)));
                }
            });
        }
    }

    public void onError() {
        int i = this.mGatewayStartRetry;
        this.mGatewayStartRetry = i + 1;
        if (i < 3) {
            getHandler().removeMessages(263);
            getHandler().sendEmptyMessageDelayed(263, 1000);
            return;
        }
        this.mConfigStatInfos.push(new hxy(this.mGatewayDid, this.mRestModel, 4101, "", true));
        this.mGatewayStartRetry = 0;
        this.mLastAnalysisErrorCode = "3000.4.1";
        triggerTimeoutNow();
    }

    public void checkNewDevice(String str) {
        final long currentTimeMillis = System.currentTimeMillis();
        FDDeviceApi.getInstance().getSubDevice(this, new String[]{str}, new fsm<List<Device>, fso>() {
            /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass6 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                if (list != null) {
                    ArrayList arrayList = new ArrayList(list);
                    if (ResetDevicePage.this.mDeviceList != null) {
                        for (Device next : ResetDevicePage.this.mDeviceList) {
                            int size = list.size() - 1;
                            while (true) {
                                if (size < 0) {
                                    break;
                                }
                                Device device = (Device) list.get(size);
                                if (next != null && device != null && TextUtils.equals(next.did, device.did)) {
                                    list.remove(size);
                                    break;
                                }
                                size--;
                            }
                        }
                    }
                    if (list.size() > 0) {
                        String[] strArr = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            Device device2 = (Device) list.get(i);
                            if (device2 != null) {
                                strArr[i] = device2.did;
                            }
                        }
                        FDDeviceApi.getInstance().getDeviceDetail(CommonApplication.getAppContext(), strArr, new fsm<List<Device>, fso>() {
                            /* class com.xiaomi.smarthome.device.ResetDevicePage.AnonymousClass6.AnonymousClass1 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                List<Device> list = (List) obj;
                                if (list.size() > 0) {
                                    for (int i = 0; i < list.size(); i++) {
                                        Device device = list.get(i);
                                        Device O000000o2 = fno.O000000o().O000000o(device.did);
                                        if (O000000o2 != null) {
                                            fno.O000000o().O00000Oo(O000000o2);
                                        }
                                        fno.O000000o().O000000o(device);
                                        htw O000000o3 = htv.O000000o();
                                        if (O000000o3 != null) {
                                            O000000o3.setCurrentScrollToDid(device.did);
                                        }
                                    }
                                    ResetDevicePage.this.mResult = list;
                                    ResetDevicePage.this.progressBar.removeCallbacks(ResetDevicePage.this.mRun);
                                    ResetDevicePage.this.mRun = null;
                                    ResetDevicePage.this.mNextBtn.setText((int) R.string.next_button);
                                    ResetDevicePage.this.mNextBtn.setEnabled(true);
                                    ResetDevicePage.this.flCountDown.setVisibility(8);
                                    ResetDevicePage.this.mIsSubDeviceConfigSuccess = true;
                                    ResetDevicePage.this.startZigbeeConfig();
                                    return;
                                }
                                ResetDevicePage.this.continueCheck(2000 - (System.currentTimeMillis() - currentTimeMillis));
                            }

                            public final void onFailure(fso fso) {
                                ResetDevicePage.this.continueCheck(2000 - (System.currentTimeMillis() - currentTimeMillis));
                                gsy.O00000o0(LogType.KUAILIAN, "ResetDevicePage", "checkNewDevice getDeviceDetail:".concat(String.valueOf(fso)));
                            }
                        });
                        return;
                    }
                    ResetDevicePage resetDevicePage = ResetDevicePage.this;
                    resetDevicePage.mDeviceList = arrayList;
                    resetDevicePage.continueCheck(2000 - (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                ResetDevicePage.this.continueCheck(2000 - (System.currentTimeMillis() - currentTimeMillis));
            }

            public final void onFailure(fso fso) {
                ResetDevicePage.this.continueCheck(2000 - (System.currentTimeMillis() - currentTimeMillis));
                gsy.O00000o0(LogType.KUAILIAN, "ResetDevicePage", "checkNewDevice getSubDevice:".concat(String.valueOf(fso)));
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public void continueCheck(long j) {
        if (this.mShowTimeout) {
            this.mConfigStatInfos.push(new hxy(this.mGatewayDid, this.mRestModel, 4201, "", true));
            this.mLastAnalysisErrorCode = "3000.4.2";
            triggerTimeoutNow();
            return;
        }
        getHandler().removeMessages(264);
        getHandler().sendEmptyMessageDelayed(264, Math.max(0L, j));
    }

    /* access modifiers changed from: protected */
    public void triggerTimeoutNow() {
        this.flError.setVisibility(0);
        this.progressBar.removeCallbacks(this.mRun);
        this.mRun = null;
        this.mNextBtn.setText((int) R.string.common_retry);
        this.mNextBtn.setEnabled(true);
        this.flCountDown.setVisibility(8);
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 263) {
            requestGatewayStart(new QrCodeParser(getIntent().getStringExtra("nbiot")));
        } else if (i != 264) {
            super.handleMessage(message);
        } else {
            checkNewDevice(this.mGatewayDid);
        }
    }

    public void onDestroy() {
        if (this.mIsSubDeviceConfig && !this.mIsSubDeviceConfigSuccess && !this.mConfigStatInfos.isEmpty()) {
            hxy pop = this.mConfigStatInfos.pop();
            if (pop != null && pop.O00000oO && eyr.O00000Oo().O00000o0(pop.O00000Oo)) {
                SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(pop);
            }
            this.mConfigStatInfos.clear();
        }
        if (!TextUtils.isEmpty(this.mLastAnalysisErrorCode)) {
            gsy.O00000Oo(3000, this.mLastAnalysisErrorCode, "");
        }
        super.onDestroy();
    }

    public void scanSubdevice(Device device, QrCodeParser qrCodeParser, int i, Callback<String> callback) {
        try {
            if (!fqg.O00000Oo.f16899O000000o.O000000o(device)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(i);
                gsy.O00000Oo(LogType.KUAILIAN, "ResetDevicePage", "scanSubdevice start_zigbee_join");
                XmPluginHostApi.instance().callMethodFromCloud(this.mGatewayDid, "start_zigbee_join", jSONArray, callback, $$Lambda$ResetDevicePage$N8FJwcAFpO0jZijm2uIY2npzT2E.INSTANCE);
            } else if (i == 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", -1);
                gsy.O00000Oo(LogType.KUAILIAN, "ResetDevicePage", "scanSubdevice miIO.zb_end_provision");
                XmPluginHostApi.instance().callMethodFromCloud(this.mGatewayDid, "miIO.zb_end_provision", jSONObject, callback, $$Lambda$ResetDevicePage$DuAM3chin0UrFdMiQcbPQLilqmQ.INSTANCE);
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("duration", i);
                jSONObject2.put("model", this.mSelectRecord.O00000Oo());
                jSONObject2.put("pid", this.mSelectRecord.O00000o0());
                jSONObject2.put("reserved", "");
                if (qrCodeParser.f6584O000000o == QrCodeParser.QrCodeType.ZIGBEE_30) {
                    jSONObject2.put("method", 2);
                    jSONObject2.put("mac", qrCodeParser.O00000o0.O00000Oo);
                    jSONObject2.put("install_code", qrCodeParser.O00000o.O00000Oo);
                    jSONObject2.put("dev_type", 1);
                } else {
                    int i2 = 0;
                    jSONObject2.put("method", 0);
                    if (this.mSelectRecord.O00000o() == 14) {
                        i2 = 1;
                    }
                    jSONObject2.put("dev_type", i2);
                }
                gsy.O00000Oo(LogType.KUAILIAN, "ResetDevicePage", "scanSubdevice miIO.zb_start_provision");
                XmPluginHostApi.instance().callMethodFromCloud(this.mGatewayDid, "miIO.zb_start_provision", jSONObject2, callback, $$Lambda$ResetDevicePage$IbpLb0xATo4LYdgmLsmzBNaAChc.INSTANCE);
            }
        } catch (Exception e) {
            LogType logType = LogType.KUAILIAN;
            gsy.O00000Oo(logType, "ResetDevicePage", "requestGatewayStart:" + Log.getStackTraceString(e));
        }
    }
}
