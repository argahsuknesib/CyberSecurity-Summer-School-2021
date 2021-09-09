package com.xiaomi.smarthome.smartconfig.router;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fow;
import _m_j.foy;
import _m_j.foz;
import _m_j.fpa;
import _m_j.gky;
import _m_j.gog;
import _m_j.grr;
import _m_j.grw;
import _m_j.gsy;
import _m_j.hmz;
import _m_j.hnc;
import _m_j.htm;
import _m_j.htv;
import _m_j.htw;
import _m_j.huc;
import _m_j.huh;
import _m_j.huw;
import _m_j.izb;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class RouterConfigActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private PluginDeviceInfo f11579O000000o;
    private final fpa O00000Oo = new fpa() {
        /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass1 */

        public final void O000000o(int i) {
            int i2;
            if (i >= 0 && i <= 100) {
                if (i <= 60) {
                    i2 = (i * 100) / 60;
                } else {
                    i2 = i <= 99 ? ((i - 60) * 100) / 39 : i;
                }
                RouterConfigActivity.this.mCommonBindView.setProgress(i2);
            }
            if (i == 100) {
                RouterConfigActivity.this.onFinalComplete();
            }
        }
    };
    @BindView(6920)
    ImageView mBackImage;
    public final fow mBindBoostCallback = new fow() {
        /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass15 */

        public final void onBoostComplete() {
            RouterConfigActivity.this.updateBindSuccessView();
            RouterConfigActivity.this.updateDownloadingView();
        }
    };
    public String mBindSuccessRouterId = "";
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
    @BindView(6703)
    EditText mInputPwdEditText;
    public foy mProgressCounter;
    public Runnable mRetryGetRouterInfoRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass12 */

        public final void run() {
            if (!RouterConfigActivity.this.mIsPaused) {
                RouterConfigActivity.this.checkRouterBindStatus();
            }
        }
    };
    public int mRetryGetRouterInfoTime = 0;
    public String mRouterIdentity;
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_router_config);
        ButterKnife.bind(this);
        this.mBackImage.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass23 */

            public final void onClick(View view) {
                RouterConfigActivity.this.finish();
            }
        });
        this.mChooseRouterItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass27 */

            public final void onClick(View view) {
                RouterConfigActivity.this.gotoSystemWifiPage();
            }
        });
        this.mChooseRouterButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass28 */

            public final void onClick(View view) {
                RouterConfigActivity.this.gotoSystemWifiPage();
            }
        });
        this.mChooseRouterButton1.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass29 */

            public final void onClick(View view) {
                RouterConfigActivity.this.gotoSystemWifiPage();
            }
        });
        this.mHasBoundRouterButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass30 */

            public final void onClick(View view) {
                RouterConfigActivity.this.gotoSystemWifiPage();
            }
        });
        this.mSetRouterButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass31 */

            public final void onClick(View view) {
                try {
                    SmartConfigRouterFactory.getSmartConfigManager().open(RouterConfigActivity.this, "http://miwifi.com");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mInputPwdEditText.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass32 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().length() > 0) {
                    RouterConfigActivity.this.mStartBindButton.setEnabled(true);
                    RouterConfigActivity.this.mStartBindButton.setBackgroundResource(R.drawable.bg_wide_button_normal_shape);
                    return;
                }
                RouterConfigActivity.this.mStartBindButton.setEnabled(false);
                RouterConfigActivity.this.mStartBindButton.setBackgroundResource(R.drawable.ble_mesh_update_button_disable_shape);
            }
        });
        this.mStartBindButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass2 */

            public final void onClick(View view) {
                RouterConfigActivity.this.mStartBindButton.setClickable(false);
                SmartConfigRouterFactory.getSmartConfigManager().getGlobalWorkerHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        Context applicationContext = RouterConfigActivity.this.getApplicationContext();
                        String str = RouterConfigActivity.this.mGatewayIp;
                        String obj = RouterConfigActivity.this.mInputPwdEditText.getText().toString();
                        AnonymousClass1 r7 = new Callback<String>() {
                            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                try {
                                    String string = new JSONObject((String) obj).getString("token");
                                    if (!TextUtils.isEmpty(string)) {
                                        String str = RouterConfigActivity.this.mGatewayIp;
                                        AnonymousClass1 r5 = new Callback<String>() {
                                            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass2.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                try {
                                                    String string = new JSONObject((String) obj).getString("info");
                                                    if (!TextUtils.isEmpty(string)) {
                                                        RouterConfigActivity.this.mRouterIdentity = string;
                                                        RouterConfigActivity.this.mHandler.post(new Runnable() {
                                                            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass2.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                            public final void run() {
                                                                RouterConfigActivity.this.mStartBindButton.setClickable(true);
                                                                RouterConfigActivity.this.startBindRouter();
                                                            }
                                                        });
                                                        return;
                                                    }
                                                    RouterConfigActivity.this.getRouterTokenFailed();
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                    RouterConfigActivity.this.getRouterTokenFailed();
                                                }
                                            }

                                            public final void onFailure(int i, String str) {
                                                gsy.O000000o(3, "RouterConfigActivity", "getRouterIdentify failed, error = " + i + ", errorInfo = " + str);
                                                RouterConfigActivity.this.getRouterTokenFailed();
                                            }
                                        };
                                        SmartConfigRouterFactory.getSmartConfigManager().commonRequestHandle(String.format("http://%s/cgi-bin/luci/;stok=%s/api/xqdatacenter/identify_device", str, string), "GET", new ArrayList(), r5, new Parser<String>() {
                                            /* class _m_j.hnc.AnonymousClass3 */

                                            public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                                                return str;
                                            }
                                        });
                                        return;
                                    }
                                    RouterConfigActivity.this.getRouterTokenFailed();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    RouterConfigActivity.this.getRouterTokenFailed();
                                }
                            }

                            public final void onFailure(int i, String str) {
                                gsy.O000000o(3, "RouterConfigActivity", "getRouterToken failed, error = " + i + ", errorInfo = " + str);
                                RouterConfigActivity.this.getRouterTokenFailed();
                            }
                        };
                        String format = String.format("http://%s/cgi-bin/luci/api/xqsystem/token", str);
                        StringBuilder sb = new StringBuilder();
                        sb.append("1");
                        sb.append("_");
                        grr.O000000o();
                        sb.append(grr.O000000o(applicationContext, SmartConfigRouterFactory.getSmartConfigManager().isEurope(applicationContext)));
                        sb.append("_");
                        sb.append(System.currentTimeMillis());
                        sb.append("_");
                        sb.append(new Random().nextInt(99999999));
                        String lowerCase = grw.O000000o(obj + "a2ffa5c9be07488bbb04a3a47d3c5f6a").toLowerCase();
                        String lowerCase2 = grw.O000000o(sb.toString() + lowerCase).toLowerCase();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new gky("username", "admin"));
                        arrayList.add(new gky("nonce", sb.toString()));
                        arrayList.add(new gky("password", lowerCase2));
                        SmartConfigRouterFactory.getSmartConfigManager().commonRequestHandle(format, "POST", arrayList, r7, new Parser<String>() {
                            /* class _m_j.hnc.AnonymousClass2 */

                            public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                                return str;
                            }
                        });
                    }
                });
            }
        });
        this.mProgressCounter = new foz(this.O00000Oo);
        this.mDeviceModel = getIntent().getStringExtra("model");
        if (TextUtils.isEmpty(this.mDeviceModel)) {
            izb.O000000o(this, "model is empty", 1).show();
            finish();
            return;
        }
        this.f11579O000000o = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.mDeviceModel);
        if (this.f11579O000000o == null) {
            izb.O000000o(this, "plugin record is empty", 1).show();
            finish();
        }
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
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass3 */

            public final void run() {
                RouterConfigActivity.this.mStartBindButton.setClickable(true);
                izb.O000000o(RouterConfigActivity.this, (int) R.string.router_admin_password_failed, 1).show();
                RouterConfigActivity.this.mInputPwdEditText.setText("");
                RouterConfigActivity routerConfigActivity = RouterConfigActivity.this;
                routerConfigActivity.showWaitBindRouterPage(routerConfigActivity.mRouterName);
            }
        });
    }

    public void pollingDeviceBind(String str) {
        gsy.O00000o0(LogType.KUAILIAN, "RouterConfigActivity", "pollingDeviceBind:");
        htw O000000o2 = htv.O000000o();
        if (O000000o2 != null) {
            O000000o2.scanNewDevice(new htm() {
                /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass6 */

                public final void onDeviceConnectionFailure(int i) {
                    gsy.O00000o0(LogType.KUAILIAN, "RouterConfigActivity", "onDeviceConnectionFailure:".concat(String.valueOf(i)));
                    gsy.O000000o(3, "RouterConfigActivity", "getNewDevice failed: ".concat(String.valueOf(i)));
                    RouterConfigActivity.this.updateBindFailedView();
                }

                public final void onDeviceConnectionSuccess(List<Device> list) {
                    if (list != null && list.size() > 0) {
                        RouterConfigActivity.this.mDeviceDid = list.get(0).did;
                        RouterConfigActivity.this.mDeviceMac = list.get(0).mac;
                        fno.O000000o().O000000o(list.get(0));
                    }
                    RouterConfigActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            RouterConfigActivity.this.mProgressCounter.O000000o(99, 15000, null);
                            RouterConfigActivity.this.mHandler.sendEmptyMessageDelayed(4097, 15000);
                            RouterConfigActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    RouterConfigActivity.this.startDownloadPlugin();
                                }
                            }, 2000);
                        }
                    });
                }

                public final void onDeviceConnectionFailure() {
                    gsy.O00000o0(LogType.KUAILIAN, "RouterConfigActivity", "onDeviceConnectionFailure:");
                    RouterConfigActivity.this.updateBindFailedView();
                }
            }, null, str, null, null, this.mDeviceModel, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
        }
    }

    public void startDownloadPlugin() {
        gsy.O00000Oo("RouterConfigActivity", " Start load plugin");
        huw installInfo = SmartConfigRouterFactory.getCoreApiManager().getInstallInfo(this.mDeviceModel);
        if (installInfo.O000000o() || installInfo.O00000Oo()) {
            this.mHandler.removeMessages(4097);
            updateDownloadPluginSuccessView();
            this.mProgressCounter.O000000o(101, 1000, null);
            return;
        }
        SmartConfigRouterFactory.getCoreApiManager().downloadPlugin(this.mDeviceModel, new huh() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass7 */

            public final void O000000o() {
            }

            public final void O000000o(float f) {
            }

            public final void O000000o(String str) {
                if (!RouterConfigActivity.this.isFinishing()) {
                    gsy.O00000Oo("RouterConfigActivity", " Plugin Download onSuccess");
                    RouterConfigActivity.this.mHandler.removeMessages(4097);
                    RouterConfigActivity.this.updateDownloadPluginSuccessView();
                    RouterConfigActivity.this.mProgressCounter.O000000o(101, 1000, null);
                }
            }

            public final void O00000Oo() {
                if (!RouterConfigActivity.this.isFinishing()) {
                    RouterConfigActivity.this.mHandler.removeMessages(4097);
                    gsy.O00000Oo(LogType.KUAILIAN, "RouterConfigActivity", "Plugin Download onFailure");
                    RouterConfigActivity.this.mProgressCounter.O000000o(0);
                    RouterConfigActivity.this.updateDownloadPluginFailedView();
                }
            }

            public final void O00000o0() {
                if (!RouterConfigActivity.this.isFinishing()) {
                    RouterConfigActivity.this.mHandler.removeMessages(4097);
                    gsy.O00000Oo("RouterConfigActivity", "Plugin Download onCancel");
                    RouterConfigActivity.this.mProgressCounter.O000000o(0);
                    RouterConfigActivity.this.updateDownloadPluginFailedView();
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.mRetryGetRouterInfoTime = 0;
        if (this.f11579O000000o != null && this.mCurrentPage != 6) {
            checkRouterBindStatus();
        }
    }

    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacks(this.mRetryGetRouterInfoRunnable);
    }

    public void handleMessage(Message message) {
        if (message.what == 4097) {
            this.mHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass24 */

                public final void run() {
                    RouterConfigActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.LOADING, RouterConfigActivity.this.getResources().getText(R.string.ble_new_download_plugin_step_timeout).toString(), (int) R.string.ble_new_network_failed_title);
                    RouterConfigActivity.this.showCompleteButton();
                }
            });
        }
    }

    public void checkRouterBindStatus() {
        if (!gog.O00000oo(this) || TextUtils.isEmpty(hnc.O000000o(this))) {
            this.mHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass9 */

                public final void run() {
                    RouterConfigActivity routerConfigActivity = RouterConfigActivity.this;
                    routerConfigActivity.mCurrentPage = 1;
                    routerConfigActivity.resetAllPage();
                    RouterConfigActivity.this.mTitleView.setText((int) R.string.device_choose_wifi);
                    RouterConfigActivity.this.mChooseRouterPage.setVisibility(0);
                    RouterConfigActivity.this.mInputPwdEditText.setText("");
                }
            });
        } else {
            SmartConfigRouterFactory.getSmartConfigManager().getGlobalWorkerHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass8 */

                public final void run() {
                    String O000000o2 = hnc.O000000o(RouterConfigActivity.this.getApplicationContext());
                    RouterConfigActivity.this.mGatewayIp = O000000o2;
                    hnc.O000000o(O000000o2, new Callback<String>() {
                        /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass8.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            String str = (String) obj;
                            gsy.O000000o(3, "RouterConfigActivity", "isRouterInited success");
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                int i = jSONObject.getInt("inited");
                                String string = jSONObject.getString("id");
                                String string2 = jSONObject.getString("routerId");
                                final String string3 = jSONObject.getString("routername");
                                String optString = jSONObject.optString("hardware");
                                String optString2 = jSONObject.optString("model");
                                gsy.O00000Oo("RouterConfigActivity", "checkRouterBindStatus result = " + str.toString());
                                if (!TextUtils.equals(optString, hmz.O00000Oo(RouterConfigActivity.this.mDeviceModel))) {
                                    if (!TextUtils.equals(optString2, RouterConfigActivity.this.mDeviceModel)) {
                                        gsy.O000000o(3, "RouterConfigActivity", "don't support hardware: ".concat(String.valueOf(optString)));
                                        RouterConfigActivity.this.showUnsupportRouterPage();
                                        return;
                                    }
                                }
                                RouterConfigActivity.this.mRouterName = string3;
                                if (i == 1) {
                                    RouterConfigActivity.this.getApplicationContext();
                                    hnc.O000000o(string, string2, new huc() {
                                        /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                                        public final void O000000o(String str) {
                                            try {
                                                if (new JSONObject(str).optBoolean("result", false)) {
                                                    RouterConfigActivity.this.showHasBoundRouterPage(string3);
                                                } else {
                                                    RouterConfigActivity.this.showWaitBindRouterPage(string3);
                                                }
                                            } catch (JSONException e) {
                                                RouterConfigActivity.this.showUnsupportRouterPage();
                                                e.printStackTrace();
                                            }
                                        }

                                        public final void O000000o(int i, String str) {
                                            RouterConfigActivity.this.showUnsupportRouterPage();
                                            if (!RouterConfigActivity.this.mIsPaused && RouterConfigActivity.this.mRetryGetRouterInfoTime < 2) {
                                                RouterConfigActivity.this.mRetryGetRouterInfoTime++;
                                                RouterConfigActivity.this.mHandler.removeCallbacks(RouterConfigActivity.this.mRetryGetRouterInfoRunnable);
                                                RouterConfigActivity.this.mHandler.postDelayed(RouterConfigActivity.this.mRetryGetRouterInfoRunnable, 1000);
                                            }
                                        }
                                    });
                                    return;
                                }
                                RouterConfigActivity.this.showUninitRouterPage(string3);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                RouterConfigActivity.this.showUnsupportRouterPage();
                            }
                        }

                        public final void onFailure(int i, String str) {
                            gsy.O000000o(3, "RouterConfigActivity", "isRouterInited failed, error = " + i + ", errorInfo = " + str);
                            RouterConfigActivity.this.showUnsupportRouterPage();
                            if (!RouterConfigActivity.this.mIsPaused && RouterConfigActivity.this.mRetryGetRouterInfoTime < 2) {
                                RouterConfigActivity.this.mRetryGetRouterInfoTime++;
                                RouterConfigActivity.this.mHandler.removeCallbacks(RouterConfigActivity.this.mRetryGetRouterInfoRunnable);
                                RouterConfigActivity.this.mHandler.postDelayed(RouterConfigActivity.this.mRetryGetRouterInfoRunnable, 1000);
                            }
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
    }

    public void showUnsupportRouterPage() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass10 */

            public final void run() {
                RouterConfigActivity routerConfigActivity = RouterConfigActivity.this;
                routerConfigActivity.mCurrentPage = 2;
                routerConfigActivity.resetAllPage();
                RouterConfigActivity.this.mTitleView.setText((int) R.string.choose_other_wifi_title);
                RouterConfigActivity.this.mUnsupportRouterPage.setVisibility(0);
                DeviceFactory.O00000Oo(RouterConfigActivity.this.mDeviceModel, RouterConfigActivity.this.mUnsupportRouterImage);
                RouterConfigActivity.this.mInputPwdEditText.setText("");
            }
        });
    }

    public void showUninitRouterPage(final String str) {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass11 */

            public final void run() {
                RouterConfigActivity routerConfigActivity = RouterConfigActivity.this;
                routerConfigActivity.mCurrentPage = 3;
                routerConfigActivity.resetAllPage();
                RouterConfigActivity.this.mTitleView.setText((int) R.string.set_router_title);
                RouterConfigActivity.this.mUninitRouterPage.setVisibility(0);
                DeviceFactory.O00000Oo(RouterConfigActivity.this.mDeviceModel, RouterConfigActivity.this.mUninitRouterImage);
                RouterConfigActivity.this.mUninitRouterName.setText(RouterConfigActivity.this.getString(R.string.uninit_router_tips, new Object[]{str}));
                RouterConfigActivity.this.mInputPwdEditText.setText("");
            }
        });
    }

    public void showHasBoundRouterPage(final String str) {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass13 */

            public final void run() {
                RouterConfigActivity routerConfigActivity = RouterConfigActivity.this;
                routerConfigActivity.mCurrentPage = 4;
                routerConfigActivity.resetAllPage();
                RouterConfigActivity.this.mTitleView.setText((int) R.string.choose_other_wifi_title);
                RouterConfigActivity.this.mHasBoundRouterPage.setVisibility(0);
                DeviceFactory.O00000Oo(RouterConfigActivity.this.mDeviceModel, RouterConfigActivity.this.mHasBoundRouterImage);
                RouterConfigActivity.this.mHasBoundRouterName.setText(RouterConfigActivity.this.getString(R.string.has_bound_router_tip, new Object[]{str}));
                RouterConfigActivity.this.mInputPwdEditText.setText("");
            }
        });
    }

    public void showWaitBindRouterPage(final String str) {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass14 */

            public final void run() {
                RouterConfigActivity routerConfigActivity = RouterConfigActivity.this;
                routerConfigActivity.mCurrentPage = 5;
                routerConfigActivity.resetAllPage();
                RouterConfigActivity.this.mTitleView.setText((int) R.string.choose_other_wifi_title);
                RouterConfigActivity.this.mWaitBindRouterPage.setVisibility(0);
                RouterConfigActivity.this.mStartBindButton.setClickable(true);
                DeviceFactory.O00000Oo(RouterConfigActivity.this.mDeviceModel, RouterConfigActivity.this.mWaitBindRouterImage);
                RouterConfigActivity.this.mWaitBindRouterNameView.setText(RouterConfigActivity.this.getString(R.string.has_connected_router_tip, new Object[]{str}));
            }
        });
    }

    public void updateBindingView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass17 */

            public final void run() {
                Resources resources = RouterConfigActivity.this.mCommonBindView.getResources();
                RouterConfigActivity.this.mCommonBindView.O000000o(resources.getString(R.string.ble_new_bind_step_loading), resources.getString(R.string.ble_new_network_loading_title));
                RouterConfigActivity.this.mCommonBindView.O000000o(3);
            }
        });
    }

    public void updateBindSuccessView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass18 */

            public final void run() {
                RouterConfigActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_bind_step_success, (int) R.string.ble_new_connect_loading_title);
            }
        });
    }

    public void updateBindFailedView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass19 */

            public final void run() {
                RouterConfigActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.FAILED, RouterConfigActivity.this.getResources().getText(R.string.ble_new_bind_step_failed), R.string.ble_new_network_failed_title, true);
                RouterConfigActivity.this.mCommonBindView.setBindFailed(R.drawable.common_bind_app_connect_network_failed);
                RouterConfigActivity.this.showRetryConnectButton();
            }
        });
    }

    public void updateDownloadingView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass20 */

            public final void run() {
                RouterConfigActivity.this.mCommonBindView.O000000o((int) R.string.ble_new_download_plugin_step_loading, (int) R.string.ble_new_network_loading_title);
                RouterConfigActivity.this.mCommonBindView.O000000o(4);
            }
        });
    }

    public void updateDownloadPluginSuccessView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass21 */

            public final void run() {
                RouterConfigActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_download_plugin_step_success, (int) R.string.ble_new_add_device_success_title);
            }
        });
    }

    public void updateDownloadPluginFailedView() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass22 */

            public final void run() {
                RouterConfigActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.FAILED, RouterConfigActivity.this.getResources().getText(R.string.ble_new_download_plugin_step_failed).toString(), (int) R.string.ble_new_network_failed_title);
                RouterConfigActivity.this.showCompleteButton();
            }
        });
    }

    public void showRetryConnectButton() {
        this.mCommonBindView.setCommonBtnVisibility(0);
        this.mCommonBindView.setCommonBtnText(getString(R.string.mj_retry));
        this.mCommonBindView.setCommonBtnListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass25 */

            public final void onClick(View view) {
                RouterConfigActivity.this.startBindRouter();
            }
        });
    }

    public void showCompleteButton() {
        this.mCommonBindView.setCommonBtnVisibility(0);
        this.mCommonBindView.setCommonBtnListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass26 */

            public final void onClick(View view) {
                fbt fbt = new fbt(RouterConfigActivity.this, "initDeviceRoomActivity");
                fbt.O000000o("device_id", RouterConfigActivity.this.mDeviceDid);
                fbt.O000000o("device_mac", RouterConfigActivity.this.mDeviceMac);
                fbs.O000000o(fbt);
                RouterConfigActivity.this.finish();
            }
        });
        this.mCommonBindView.O00000o0();
    }

    public void onFinalComplete() {
        showCompleteButton();
    }

    public void startBindRouter() {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass16 */

            public final void run() {
                RouterConfigActivity routerConfigActivity = RouterConfigActivity.this;
                routerConfigActivity.mCurrentPage = 6;
                routerConfigActivity.resetAllPage();
                RouterConfigActivity.this.mTitleView.setText((int) R.string.kuailian_connect_device);
                RouterConfigActivity.this.mBindingPage.setVisibility(0);
                RouterConfigActivity.this.mProgressCounter.O000000o(0);
                RouterConfigActivity.this.mCommonBindView.O000000o();
                RouterConfigActivity.this.updateBindingView();
                RouterConfigActivity.this.mProgressCounter.O000000o(60, 30000, RouterConfigActivity.this.mBindBoostCallback);
            }
        });
        if (TextUtils.isEmpty(this.mBindSuccessRouterId)) {
            getApplicationContext();
            String str = this.mRouterName;
            String str2 = this.mRouterIdentity;
            AnonymousClass4 r2 = new huc() {
                /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass4 */

                public final void O000000o(String str) {
                    try {
                        gsy.O00000o0(LogType.KUAILIAN, "RouterConfigActivity", "startBindRouter:");
                        JSONObject jSONObject = new JSONObject(str);
                        String string = jSONObject.getString("code");
                        final String concat = "miwifi.".concat(String.valueOf(jSONObject.getString("id")));
                        if (TextUtils.equals(string, "0")) {
                            RouterConfigActivity.this.mBindSuccessRouterId = concat;
                            SmartConfigRouterFactory.getSmartConfigManager().getGlobalWorkerHandler().postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    RouterConfigActivity.this.pollingDeviceBind(concat);
                                }
                            }, 3000);
                            return;
                        }
                        RouterConfigActivity.this.updateBindFailedView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        RouterConfigActivity.this.updateBindFailedView();
                    }
                }

                public final void O000000o(int i, String str) {
                    gsy.O00000o0(LogType.KUAILIAN, "RouterConfigActivity", "startBindRouter failed:".concat(String.valueOf(i)));
                    RouterConfigActivity.this.updateBindFailedView();
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", "POST");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("deviceName", str);
                jSONObject2.put("d", str2);
                jSONObject.put("params", jSONObject2);
            } catch (JSONException unused) {
            }
            SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(hnc.O000000o("/appgateway/third/miwifi/app/s/register", jSONObject), r2);
            return;
        }
        SmartConfigRouterFactory.getSmartConfigManager().getGlobalWorkerHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.router.RouterConfigActivity.AnonymousClass5 */

            public final void run() {
                RouterConfigActivity routerConfigActivity = RouterConfigActivity.this;
                routerConfigActivity.pollingDeviceBind(routerConfigActivity.mBindSuccessRouterId);
            }
        }, 3000);
    }
}
