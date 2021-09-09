package com.xiaomi.smarthome.smartconfig.router;

import _m_j.ddn;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fir;
import _m_j.fno;
import _m_j.fow;
import _m_j.foy;
import _m_j.foz;
import _m_j.fpa;
import _m_j.gky;
import _m_j.gog;
import _m_j.gsy;
import _m_j.hnb;
import _m_j.htm;
import _m_j.htq;
import _m_j.htv;
import _m_j.htw;
import _m_j.hua;
import _m_j.hud;
import _m_j.huh;
import _m_j.huw;
import _m_j.iad;
import _m_j.iag;
import _m_j.izb;
import _m_j.jdn;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class HualaiRouterConfigActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    iad f11532O000000o = new iad() {
        /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass29 */

        public final void O000000o(Network network) {
            super.O000000o(network);
            gsy.O00000o0(LogType.KUAILIAN, "HLRouterConfigActivity", "connectToWifi onAvailable");
        }

        public final void O000000o() {
            super.O000000o();
            gsy.O00000o0(LogType.KUAILIAN, "HLRouterConfigActivity", "connectToWifi onUnavailable");
        }

        public final void O00000Oo(Network network) {
            super.O00000Oo(network);
            gsy.O00000o0(LogType.KUAILIAN, "HLRouterConfigActivity", "connectToWifi onLost");
        }
    };
    private huw O00000Oo;
    private BroadcastReceiver O00000o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            gsy.O000000o(3, "HLRouterConfigActivity", "onReceive mBroadcastReceiver");
            if (HualaiRouterConfigActivity.this.mIsConnecting) {
                List<ScanResult> scanResults = HualaiRouterConfigActivity.this.mWifiManager.getScanResults();
                for (int i = 0; i < scanResults.size(); i++) {
                    ScanResult scanResult = scanResults.get(i);
                    if (HualaiRouterConfigActivity.this.mRouterName != null && HualaiRouterConfigActivity.this.mRouterName.equals(scanResult.SSID)) {
                        HualaiRouterConfigActivity hualaiRouterConfigActivity = HualaiRouterConfigActivity.this;
                        hualaiRouterConfigActivity.connectToWifi(scanResult, hualaiRouterConfigActivity.mPwd);
                        HualaiRouterConfigActivity hualaiRouterConfigActivity2 = HualaiRouterConfigActivity.this;
                        hualaiRouterConfigActivity2.mIsConnecting = false;
                        hualaiRouterConfigActivity2.mHandler.removeMessages(99);
                        SmartConfigRouterFactory.getSmartConfigManager().getGlobalWorkerHandler().postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                String str = null;
                                int i = 8;
                                while (TextUtils.isEmpty(str) && i > 0) {
                                    try {
                                        Thread.sleep(1000);
                                        i--;
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    str = hnb.O000000o(HualaiRouterConfigActivity.this);
                                }
                                HualaiRouterConfigActivity.this.checkRouterBindStatus();
                            }
                        }, 1000);
                    }
                }
            }
        }
    };
    private XQProgressDialog O00000o0;
    private final fpa O00000oO = new fpa() {
        /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass12 */

        public final void O000000o(int i) {
            int i2;
            if (i >= 0 && i <= 100) {
                if (i <= 60) {
                    i2 = (i * 100) / 60;
                } else {
                    i2 = i <= 99 ? ((i - 60) * 100) / 39 : i;
                }
                HualaiRouterConfigActivity.this.mCommonBindView.setProgress(i2);
            }
            if (i == 100) {
                HualaiRouterConfigActivity.this.onFinalComplete();
            }
        }
    };
    private WebViewClient O00000oo = new WebViewClient() {
        /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass28 */

        public final void onPageFinished(WebView webView, String str) {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    };
    private WebChromeClient O0000O0o = new WebChromeClient() {
        /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass35 */

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return true;
        }

        public void onProgressChanged(WebView webView, int i) {
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }
    };
    @BindView(6920)
    ImageView mBackImage;
    public final fow mBindBoostCallback = new fow() {
        /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass15 */

        public final void onBoostComplete() {
            HualaiRouterConfigActivity.this.updateBindSuccessView();
            HualaiRouterConfigActivity.this.updateDownloadingView();
        }
    };
    public String mBindKey;
    @BindView(6184)
    View mBindingPage;
    @BindView(6306)
    TextView mChooseRouterButton;
    @BindView(6305)
    TextView mChooseRouterButton1;
    @BindView(6307)
    View mChooseRouterItem;
    @BindView(6308)
    View mChooseRouterPage;
    @BindView(6336)
    CommonBindView mCommonBindView;
    public int mCurrentPage = -1;
    public String mDeviceDid;
    public String mDeviceMac;
    public String mDeviceModel;
    public String mGatewayIp = "";
    @BindView(6600)
    TextView mHasBoundRouterButton;
    @BindView(6601)
    SimpleDraweeView mHasBoundRouterImage;
    @BindView(6602)
    TextView mHasBoundRouterName;
    @BindView(6603)
    View mHasBoundRouterPage;
    @BindView(6700)
    View mInitPage;
    @BindView(6703)
    EditText mInputPwdEditText;
    public boolean mIsConnecting = false;
    public foy mProgressCounter;
    public String mPwd;
    public Runnable mRetryGetRouterInfoRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass23 */

        public final void run() {
            if (!HualaiRouterConfigActivity.this.mIsPaused) {
                HualaiRouterConfigActivity.this.checkRouterBindStatus();
            }
        }
    };
    public int mRetryGetRouterInfoTime = 0;
    public String mRouterDid;
    public String mRouterName = "";
    @BindView(7325)
    TextView mSetRouterButton;
    @BindView(7410)
    TextView mStartBindButton;
    @BindView(6925)
    TextView mTitleView;
    @BindView(7680)
    SimpleDraweeView mUninitRouterImage;
    @BindView(7681)
    TextView mUninitRouterName;
    @BindView(7682)
    View mUninitRouterPage;
    @BindView(7684)
    SimpleDraweeView mUnsupportRouterImage;
    @BindView(7685)
    View mUnsupportRouterPage;
    @BindView(7734)
    SimpleDraweeView mWaitBindRouterImage;
    @BindView(7735)
    TextView mWaitBindRouterNameView;
    @BindView(7736)
    View mWaitBindRouterPage;
    @BindView(7798)
    WebView mWebView;
    public WifiManager mWifiManager;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_router_config);
        ButterKnife.bind(this);
        this.mBackImage.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass30 */

            public final void onClick(View view) {
                if (HualaiRouterConfigActivity.this.mCurrentPage == 7) {
                    HualaiRouterConfigActivity.this.showUninitRouterPage();
                } else {
                    HualaiRouterConfigActivity.this.finish();
                }
            }
        });
        this.mChooseRouterItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass31 */

            public final void onClick(View view) {
                HualaiRouterConfigActivity.this.gotoSystemWifiPage();
            }
        });
        this.mChooseRouterButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass32 */

            public final void onClick(View view) {
                HualaiRouterConfigActivity.this.gotoSystemWifiPage();
            }
        });
        this.mChooseRouterButton1.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass33 */

            public final void onClick(View view) {
                HualaiRouterConfigActivity.this.gotoSystemWifiPage();
            }
        });
        this.mHasBoundRouterButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass34 */

            public final void onClick(View view) {
                HualaiRouterConfigActivity.this.gotoSystemWifiPage();
            }
        });
        this.mSetRouterButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass36 */

            public final void onClick(View view) {
                try {
                    HualaiRouterConfigActivity.this.showInitView();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mInputPwdEditText.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass2 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().length() > 0) {
                    HualaiRouterConfigActivity.this.mStartBindButton.setEnabled(true);
                    HualaiRouterConfigActivity.this.mStartBindButton.setBackgroundResource(R.drawable.bg_wide_button_normal_shape);
                    return;
                }
                HualaiRouterConfigActivity.this.mStartBindButton.setEnabled(false);
                HualaiRouterConfigActivity.this.mStartBindButton.setBackgroundResource(R.drawable.ble_mesh_update_button_disable_shape);
            }
        });
        this.mStartBindButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass3 */

            public final void onClick(View view) {
                HualaiRouterConfigActivity.this.mStartBindButton.setClickable(false);
                HualaiRouterConfigActivity.this.startBindRouter();
            }
        });
        this.mWebView.addJavascriptInterface(new O000000o(), "JSBridge");
        this.mWebView.setWebChromeClient(this.O0000O0o);
        this.mWebView.setWebViewClient(this.O00000oo);
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setCacheMode(2);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        this.mProgressCounter = new foz(this.O00000oO);
        this.mDeviceModel = getIntent().getStringExtra("model");
        if (TextUtils.isEmpty(this.mDeviceModel)) {
            Toast.makeText(this, "model is empty", 1).show();
            finish();
        } else {
            this.O00000Oo = SmartConfigRouterFactory.getCoreApiManager().getInstallInfo(this.mDeviceModel);
            if (this.O00000Oo == null) {
                Toast.makeText(this, "plugin record is empty", 1).show();
                finish();
            }
        }
        this.mWifiManager = (WifiManager) getContext().getApplicationContext().getSystemService("wifi");
        registerReceiver(this.O00000o, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
    }

    public void gotoSystemWifiPage() {
        Intent intent = new Intent();
        intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getRouterTokenFailed() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass4 */

            public final void run() {
                HualaiRouterConfigActivity.this.mStartBindButton.setClickable(true);
                izb.O000000o(HualaiRouterConfigActivity.this, (int) R.string.router_admin_password_failed, 1).show();
                HualaiRouterConfigActivity.this.mInputPwdEditText.setText("");
                HualaiRouterConfigActivity.this.showWaitBindRouterPage();
            }
        });
    }

    public void startBindRouter() {
        gsy.O000000o(3, "HLRouterConfigActivity", "startBindRouter");
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass16 */

            public final void run() {
                HualaiRouterConfigActivity hualaiRouterConfigActivity = HualaiRouterConfigActivity.this;
                hualaiRouterConfigActivity.mCurrentPage = 6;
                hualaiRouterConfigActivity.resetAllPage();
                HualaiRouterConfigActivity.this.mTitleView.setText((int) R.string.kuailian_connect_device);
                HualaiRouterConfigActivity.this.mBindingPage.setVisibility(0);
                HualaiRouterConfigActivity.this.mProgressCounter.O000000o(0);
                HualaiRouterConfigActivity.this.mCommonBindView.O000000o();
                HualaiRouterConfigActivity.this.updateBindingView();
                HualaiRouterConfigActivity.this.mProgressCounter.O000000o(60, 30000, HualaiRouterConfigActivity.this.mBindBoostCallback);
            }
        });
        SmartConfigRouterFactory.getSmartConfigManager().getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass5 */

            public final void run() {
                htq.O000000o().O000000o(new hua<String, hud>() {
                    /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass5.AnonymousClass1 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        String str = (String) obj;
                        gsy.O000000o(3, "HLRouterConfigActivity", "getBindkey success ".concat(String.valueOf(str)));
                        HualaiRouterConfigActivity.this.mBindKey = str;
                        gsy.O000000o(3, "HLRouterConfigActivity", "HualaiRouterDeviceApi.sendBindKey mRouterDid " + HualaiRouterConfigActivity.this.mRouterDid + "pwd = " + HualaiRouterConfigActivity.this.mInputPwdEditText.getText().toString());
                        String str2 = HualaiRouterConfigActivity.this.mGatewayIp;
                        String str3 = HualaiRouterConfigActivity.this.mRouterDid;
                        String obj2 = HualaiRouterConfigActivity.this.mInputPwdEditText.getText().toString();
                        AnonymousClass1 r9 = new Callback<String>() {
                            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                String str = (String) obj;
                                gsy.O000000o(3, "HLRouterConfigActivity", "sendBindKey success ".concat(String.valueOf(str)));
                                try {
                                    if (new JSONObject(str).getInt("code") == 0) {
                                        SmartConfigRouterFactory.getSmartConfigManager().getGlobalWorkerHandler().postDelayed(new Runnable() {
                                            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass5.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                HualaiRouterConfigActivity.this.pollingDeviceBind(HualaiRouterConfigActivity.this.mRouterDid);
                                            }
                                        }, 3000);
                                    } else {
                                        HualaiRouterConfigActivity.this.getRouterTokenFailed();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            public final void onFailure(int i, String str) {
                                gsy.O000000o(3, "HLRouterConfigActivity", "sendBindKey onFailure ".concat(String.valueOf(str)));
                                HualaiRouterConfigActivity.this.getRouterTokenFailed();
                            }
                        };
                        String format = String.format("http://%s/miservice/bindkey", str2);
                        byte[] O000000o2 = fir.O000000o(hnb.O000000o(str3, obj2), new byte[]{16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 0}, str.getBytes());
                        ArrayList arrayList = new ArrayList();
                        String encodeToString = Base64.encodeToString(O000000o2, 0);
                        arrayList.add(new gky("data", encodeToString));
                        gsy.O000000o(3, "HLRouterConfigActivity", "sendBindKey data = ".concat(String.valueOf(encodeToString)));
                        SmartConfigRouterFactory.getSmartConfigManager().commonRequestHandle(format, "POST", arrayList, r9, new Parser<String>() {
                            /* class _m_j.hnb.AnonymousClass2 */

                            public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                                return str;
                            }
                        });
                    }

                    public final void O000000o(hud hud) {
                        gsy.O000000o(3, "HLRouterConfigActivity", "getBindkey failed " + hud.toString());
                    }
                });
            }
        });
    }

    public void pollingDeviceBind(String str) {
        gsy.O000000o(3, "HLRouterConfigActivity", "pollingDeviceBind did = " + str + " bindkey = " + this.mBindKey + " model = " + this.mDeviceModel);
        htw O000000o2 = htv.O000000o();
        if (O000000o2 != null) {
            O000000o2.scanNewDevice(new htm() {
                /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass6 */

                public final void onDeviceConnectionFailure(int i) {
                    gsy.O000000o(3, "HLRouterConfigActivity", "getNewDevice failed: ".concat(String.valueOf(i)));
                    HualaiRouterConfigActivity.this.updateBindFailedView();
                }

                public final void onDeviceConnectionSuccess(List<Device> list) {
                    if (list != null && list.size() > 0) {
                        HualaiRouterConfigActivity.this.mDeviceDid = list.get(0).did;
                        HualaiRouterConfigActivity.this.mDeviceMac = list.get(0).mac;
                        fno.O000000o().O000000o(list.get(0));
                    }
                    HualaiRouterConfigActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            HualaiRouterConfigActivity.this.mProgressCounter.O000000o(99, 15000, null);
                            HualaiRouterConfigActivity.this.mHandler.sendEmptyMessageDelayed(4097, 15000);
                            HualaiRouterConfigActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    HualaiRouterConfigActivity.this.startDownloadPlugin();
                                }
                            }, 2000);
                        }
                    });
                }

                public final void onDeviceConnectionFailure() {
                    gsy.O000000o(3, "HLRouterConfigActivity", "getNewDevice failed: ");
                    HualaiRouterConfigActivity.this.updateBindFailedView();
                }
            }, null, null, null, this.mBindKey, this.mDeviceModel, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
        }
    }

    public void startDownloadPlugin() {
        gsy.O00000Oo("HLRouterConfigActivity", "Start load plugin");
        huw installInfo = SmartConfigRouterFactory.getCoreApiManager().getInstallInfo(this.mDeviceModel);
        if (installInfo.O000000o() || installInfo.O00000Oo()) {
            this.mHandler.removeMessages(4097);
            updateDownloadPluginSuccessView();
            this.mProgressCounter.O000000o(101, 1000, null);
            return;
        }
        SmartConfigRouterFactory.getCoreApiManager().downloadPlugin(this.mDeviceModel, new huh() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass7 */

            public final void O000000o() {
            }

            public final void O000000o(float f) {
            }

            public final void O000000o(String str) {
                if (!HualaiRouterConfigActivity.this.isFinishing()) {
                    gsy.O00000Oo("HLRouterConfigActivity", " Plugin Download onSuccess");
                    HualaiRouterConfigActivity.this.mHandler.removeMessages(4097);
                    HualaiRouterConfigActivity.this.updateDownloadPluginSuccessView();
                    HualaiRouterConfigActivity.this.mProgressCounter.O000000o(101, 1000, null);
                }
            }

            public final void O00000Oo() {
                if (!HualaiRouterConfigActivity.this.isFinishing()) {
                    HualaiRouterConfigActivity.this.mHandler.removeMessages(4097);
                    gsy.O00000Oo("HLRouterConfigActivity", "Plugin Download onFailure");
                    HualaiRouterConfigActivity.this.mProgressCounter.O000000o(0);
                    HualaiRouterConfigActivity.this.updateDownloadPluginFailedView();
                }
            }

            public final void O00000o0() {
                if (!HualaiRouterConfigActivity.this.isFinishing()) {
                    HualaiRouterConfigActivity.this.mHandler.removeMessages(4097);
                    gsy.O00000Oo("HLRouterConfigActivity", "Plugin Download onCancel");
                    HualaiRouterConfigActivity.this.mProgressCounter.O000000o(0);
                    HualaiRouterConfigActivity.this.updateDownloadPluginFailedView();
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.mRetryGetRouterInfoTime = 0;
        if (this.O00000Oo != null && this.mCurrentPage != 6) {
            checkRouterBindStatus();
        }
    }

    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacks(this.mRetryGetRouterInfoRunnable);
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 99) {
            O000000o();
            dismissConnectingDialog();
        } else if (i == 4097) {
            this.mHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass24 */

                public final void run() {
                    HualaiRouterConfigActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.LOADING, HualaiRouterConfigActivity.this.getResources().getText(R.string.ble_new_download_plugin_step_timeout).toString(), (int) R.string.ble_new_network_failed_title);
                    HualaiRouterConfigActivity.this.showCompleteButton();
                }
            });
        }
    }

    public void checkRouterBindStatus() {
        gsy.O000000o(3, "HLRouterConfigActivity", "checkRouterBindStatus ");
        final String O000000o2 = hnb.O000000o(this);
        gsy.O000000o(3, "HLRouterConfigActivity", "getRouterInfo ".concat(String.valueOf(O000000o2)));
        if (!gog.O00000oo(this) || TextUtils.isEmpty(O000000o2)) {
            O000000o();
        } else {
            SmartConfigRouterFactory.getSmartConfigManager().getGlobalWorkerHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass8 */

                public final void run() {
                    HualaiRouterConfigActivity hualaiRouterConfigActivity = HualaiRouterConfigActivity.this;
                    String str = O000000o2;
                    hualaiRouterConfigActivity.mGatewayIp = str;
                    AnonymousClass1 r6 = new Callback<String>() {
                        /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass8.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            char c;
                            String str = (String) obj;
                            gsy.O000000o(3, "HLRouterConfigActivity", "getRouterInfo Result".concat(String.valueOf(str)));
                            HualaiRouterConfigActivity.this.dismissConnectingDialog();
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.optInt("code") != 0) {
                                    HualaiRouterConfigActivity.this.showUnsupportRouterPage();
                                    return;
                                }
                                HualaiRouterConfigActivity.this.mRouterName = HualaiRouterConfigActivity.this.mWifiManager.getConnectionInfo().getSSID().replace(jdn.f1779O000000o, "");
                                HualaiRouterConfigActivity.this.mRouterDid = jSONObject.getString("did");
                                String string = jSONObject.getString("state");
                                switch (string.hashCode()) {
                                    case -1756604044:
                                        if (string.equals("Unkown")) {
                                            c = 3;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -1393078604:
                                        if (string.equals("Initialized")) {
                                            c = 1;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -916201861:
                                        if (string.equals("Uninitialized")) {
                                            c = 0;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 64375134:
                                        if (string.equals("Bound")) {
                                            c = 2;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    default:
                                        c = 65535;
                                        break;
                                }
                                if (c == 0) {
                                    HualaiRouterConfigActivity.this.showUninitRouterPage();
                                } else if (c == 1) {
                                    HualaiRouterConfigActivity.this.showWaitBindRouterPage();
                                } else if (c == 2) {
                                    HualaiRouterConfigActivity.this.showHasBoundRouterPage();
                                } else if (c == 3) {
                                    HualaiRouterConfigActivity.this.showUnsupportRouterPage();
                                }
                            } catch (JSONException e) {
                                HualaiRouterConfigActivity.this.showUnsupportRouterPage();
                                e.printStackTrace();
                            }
                        }

                        public final void onFailure(int i, String str) {
                            gsy.O000000o(3, "HLRouterConfigActivity", "getRouterInfo onFailure".concat(String.valueOf(i)));
                            HualaiRouterConfigActivity.this.showUnsupportRouterPage();
                            if (!HualaiRouterConfigActivity.this.mIsPaused && HualaiRouterConfigActivity.this.mRetryGetRouterInfoTime < 2) {
                                HualaiRouterConfigActivity.this.mRetryGetRouterInfoTime++;
                                HualaiRouterConfigActivity.this.mHandler.removeCallbacks(HualaiRouterConfigActivity.this.mRetryGetRouterInfoRunnable);
                                HualaiRouterConfigActivity.this.mHandler.postDelayed(HualaiRouterConfigActivity.this.mRetryGetRouterInfoRunnable, 1000);
                            }
                        }
                    };
                    SmartConfigRouterFactory.getSmartConfigManager().commonRequestHandle(String.format("http://%s/miservice/router_info", str), "GET", new ArrayList(), r6, new Parser<String>() {
                        /* class _m_j.hnb.AnonymousClass1 */

                        public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                            return str;
                        }
                    });
                }
            });
        }
    }

    public void resetAllPage() {
        this.mChooseRouterPage.setVisibility(8);
        this.mUnsupportRouterPage.setVisibility(8);
        this.mUninitRouterPage.setVisibility(8);
        this.mHasBoundRouterPage.setVisibility(8);
        this.mWaitBindRouterPage.setVisibility(8);
        this.mBindingPage.setVisibility(8);
        this.mInitPage.setVisibility(8);
    }

    private void O000000o() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass9 */

            public final void run() {
                HualaiRouterConfigActivity hualaiRouterConfigActivity = HualaiRouterConfigActivity.this;
                hualaiRouterConfigActivity.mCurrentPage = 1;
                hualaiRouterConfigActivity.resetAllPage();
                HualaiRouterConfigActivity.this.mTitleView.setText((int) R.string.device_choose_wifi);
                HualaiRouterConfigActivity.this.mChooseRouterPage.setVisibility(0);
                HualaiRouterConfigActivity.this.mInputPwdEditText.setText("");
            }
        });
    }

    public void showUnsupportRouterPage() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass10 */

            public final void run() {
                HualaiRouterConfigActivity hualaiRouterConfigActivity = HualaiRouterConfigActivity.this;
                hualaiRouterConfigActivity.mCurrentPage = 2;
                hualaiRouterConfigActivity.resetAllPage();
                HualaiRouterConfigActivity.this.mTitleView.setText((int) R.string.choose_other_wifi_title);
                HualaiRouterConfigActivity.this.mUnsupportRouterPage.setVisibility(0);
                DeviceFactory.O00000Oo(HualaiRouterConfigActivity.this.mDeviceModel, HualaiRouterConfigActivity.this.mUnsupportRouterImage);
                HualaiRouterConfigActivity.this.mInputPwdEditText.setText("");
            }
        });
    }

    public void showUninitRouterPage() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass11 */

            public final void run() {
                HualaiRouterConfigActivity hualaiRouterConfigActivity = HualaiRouterConfigActivity.this;
                hualaiRouterConfigActivity.mCurrentPage = 3;
                hualaiRouterConfigActivity.resetAllPage();
                HualaiRouterConfigActivity.this.mTitleView.setText((int) R.string.set_router_title);
                HualaiRouterConfigActivity.this.mUninitRouterPage.setVisibility(0);
                String O00000o0 = gog.O00000o0(HualaiRouterConfigActivity.this.getContext());
                DeviceFactory.O00000Oo(HualaiRouterConfigActivity.this.mDeviceModel, HualaiRouterConfigActivity.this.mUninitRouterImage);
                HualaiRouterConfigActivity.this.mUninitRouterName.setText(HualaiRouterConfigActivity.this.getString(R.string.uninit_router_tips, new Object[]{O00000o0}));
                HualaiRouterConfigActivity.this.mInputPwdEditText.setText("");
            }
        });
    }

    public void showHasBoundRouterPage() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass13 */

            public final void run() {
                HualaiRouterConfigActivity hualaiRouterConfigActivity = HualaiRouterConfigActivity.this;
                hualaiRouterConfigActivity.mCurrentPage = 4;
                hualaiRouterConfigActivity.resetAllPage();
                HualaiRouterConfigActivity.this.mTitleView.setText((int) R.string.choose_other_wifi_title);
                HualaiRouterConfigActivity.this.mHasBoundRouterPage.setVisibility(0);
                DeviceFactory.O00000Oo(HualaiRouterConfigActivity.this.mDeviceModel, HualaiRouterConfigActivity.this.mHasBoundRouterImage);
                String O00000o0 = gog.O00000o0(HualaiRouterConfigActivity.this.getContext());
                HualaiRouterConfigActivity.this.mHasBoundRouterName.setText(HualaiRouterConfigActivity.this.getString(R.string.has_bound_router_tip, new Object[]{O00000o0}));
                HualaiRouterConfigActivity.this.mInputPwdEditText.setText("");
            }
        });
    }

    public void showWaitBindRouterPage() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass14 */

            public final void run() {
                HualaiRouterConfigActivity hualaiRouterConfigActivity = HualaiRouterConfigActivity.this;
                hualaiRouterConfigActivity.mCurrentPage = 5;
                hualaiRouterConfigActivity.resetAllPage();
                HualaiRouterConfigActivity.this.mTitleView.setText((int) R.string.choose_other_wifi_title);
                HualaiRouterConfigActivity.this.mWaitBindRouterPage.setVisibility(0);
                HualaiRouterConfigActivity.this.mStartBindButton.setClickable(true);
                String O00000o0 = gog.O00000o0(HualaiRouterConfigActivity.this.getContext());
                DeviceFactory.O00000Oo(HualaiRouterConfigActivity.this.mDeviceModel, HualaiRouterConfigActivity.this.mWaitBindRouterImage);
                HualaiRouterConfigActivity.this.mWaitBindRouterNameView.setText(HualaiRouterConfigActivity.this.getString(R.string.has_connected_router_tip, new Object[]{O00000o0}));
            }
        });
    }

    public void updateBindingView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass17 */

            public final void run() {
                Resources resources = HualaiRouterConfigActivity.this.mCommonBindView.getResources();
                HualaiRouterConfigActivity.this.mCommonBindView.O000000o(resources.getString(R.string.ble_new_bind_step_loading), resources.getString(R.string.ble_new_network_loading_title));
                HualaiRouterConfigActivity.this.mCommonBindView.O000000o(3);
            }
        });
    }

    public void updateBindSuccessView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass18 */

            public final void run() {
                HualaiRouterConfigActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_bind_step_success, (int) R.string.ble_new_connect_loading_title);
            }
        });
    }

    public void updateBindFailedView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass19 */

            public final void run() {
                HualaiRouterConfigActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.FAILED, HualaiRouterConfigActivity.this.getResources().getText(R.string.ble_new_bind_step_failed), R.string.ble_new_network_failed_title, true);
                HualaiRouterConfigActivity.this.mCommonBindView.setBindFailed(R.drawable.common_bind_app_connect_network_failed);
                HualaiRouterConfigActivity.this.showRetryConnectButton();
            }
        });
    }

    public void updateDownloadingView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass20 */

            public final void run() {
                HualaiRouterConfigActivity.this.mCommonBindView.O000000o((int) R.string.ble_new_download_plugin_step_loading, (int) R.string.ble_new_network_loading_title);
                HualaiRouterConfigActivity.this.mCommonBindView.O000000o(4);
            }
        });
    }

    public void updateDownloadPluginSuccessView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass21 */

            public final void run() {
                HualaiRouterConfigActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_download_plugin_step_success, (int) R.string.ble_new_add_device_success_title);
            }
        });
    }

    public void updateDownloadPluginFailedView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass22 */

            public final void run() {
                HualaiRouterConfigActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.FAILED, HualaiRouterConfigActivity.this.getResources().getText(R.string.ble_new_download_plugin_step_failed).toString(), (int) R.string.ble_new_network_failed_title);
                HualaiRouterConfigActivity.this.showCompleteButton();
            }
        });
    }

    public void showInitView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass25 */

            public final void run() {
                HualaiRouterConfigActivity hualaiRouterConfigActivity = HualaiRouterConfigActivity.this;
                hualaiRouterConfigActivity.mCurrentPage = 7;
                hualaiRouterConfigActivity.resetAllPage();
                HualaiRouterConfigActivity.this.mInitPage.setVisibility(0);
                HualaiRouterConfigActivity.this.mWebView.loadUrl("http://192.168.58.1");
            }
        });
    }

    public void showRetryConnectButton() {
        this.mCommonBindView.setCommonBtnVisibility(0);
        this.mCommonBindView.setCommonBtnText(getString(R.string.mj_retry));
        this.mCommonBindView.setCommonBtnListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass26 */

            public final void onClick(View view) {
                HualaiRouterConfigActivity.this.startBindRouter();
            }
        });
    }

    public void showCompleteButton() {
        this.mCommonBindView.setCommonBtnVisibility(0);
        this.mCommonBindView.setCommonBtnListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.AnonymousClass27 */

            public final void onClick(View view) {
                fbt fbt = new fbt(HualaiRouterConfigActivity.this, "initDeviceRoomActivity");
                fbt.O000000o("device_id", HualaiRouterConfigActivity.this.mDeviceDid);
                fbt.O000000o("device_mac", HualaiRouterConfigActivity.this.mDeviceMac);
                fbs.O000000o(fbt);
                HualaiRouterConfigActivity.this.finish();
            }
        });
        this.mCommonBindView.O00000o0();
    }

    public void onFinalComplete() {
        showCompleteButton();
    }

    public void showConnectingDialog() {
        if (this.O00000o0 == null) {
            this.O00000o0 = new XQProgressDialog(this);
            this.O00000o0.setMessage(getResources().getString(R.string.connecting_device));
            this.O00000o0.setCancelable(false);
        }
        this.O00000o0.show();
    }

    public void dismissConnectingDialog() {
        XQProgressDialog xQProgressDialog = this.O00000o0;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    class O000000o {
        O000000o() {
        }

        @JavascriptInterface
        public final void dataToApp(final String str) {
            gsy.O000000o(3, "HLRouterConfigActivity", "dataToApp ".concat(String.valueOf(str)));
            HualaiRouterConfigActivity.this.showUninitRouterPage();
            ddn ddn = new ddn();
            ddn.setCancelable(false);
            ddn.O00000Oo = str;
            ddn.f14503O000000o = new ddn.O000000o() {
                /* class com.xiaomi.smarthome.smartconfig.router.HualaiRouterConfigActivity.O000000o.AnonymousClass1 */

                public final void O000000o(String str) {
                    HualaiRouterConfigActivity.this.showConnectingDialog();
                    HualaiRouterConfigActivity.this.mPwd = str;
                    HualaiRouterConfigActivity.this.mRouterName = str;
                    HualaiRouterConfigActivity.this.mWifiManager.startScan();
                    HualaiRouterConfigActivity.this.mIsConnecting = true;
                    HualaiRouterConfigActivity.this.mHandler.sendEmptyMessageDelayed(99, 10000);
                }

                public final void O000000o() {
                    HualaiRouterConfigActivity.this.showUninitRouterPage();
                }
            };
            ddn.show(HualaiRouterConfigActivity.this.getSupportFragmentManager(), "");
        }
    }

    public void connectToWifi(ScanResult scanResult, String str) {
        LogType logType = LogType.KUAILIAN;
        gsy.O00000o0(logType, "HLRouterConfigActivity", "connectToWifi " + scanResult.SSID);
        iag.O000000o((ConnectivityManager) getSystemService("connectivity"), this.mWifiManager, scanResult.SSID, str, scanResult.BSSID, scanResult.capabilities, this.f11532O000000o, false, true);
    }
}
