package com.xiaomi.smarthome.smartconfig.step;

import _m_j.fwq;
import _m_j.gwg;
import _m_j.htr;
import _m_j.huf;
import _m_j.hui;
import _m_j.hxi;
import _m_j.hze;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.CameraResetStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.Locale;

public class CameraResetStep extends SmartConfigStep {
    public static boolean O00000Oo = false;

    /* renamed from: O000000o  reason: collision with root package name */
    public long f11646O000000o;
    @BindView(6986)
    Button mButton;
    @BindView(6290)
    CheckBox mCheck;
    @BindView(6292)
    View mCheckBoxRootView;
    @BindView(6421)
    TextView mDeviceDetail;
    @BindView(6920)
    View mReturnBtn;
    @BindView(6925)
    TextView mTitle;
    @BindView(7517)
    View mTitleBar;
    @BindView(6753)
    SmartHomeWebView mWebView;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    CameraResetStep() {
        this.O000Ooo = "camera-config :CameraResetStep";
    }

    public final void O000000o(final Context context) {
        String str;
        String str2;
        O000000o("create step", new Object[0]);
        O000000o(context, (int) R.layout.smart_config_camera_reset);
        this.f11646O000000o = System.currentTimeMillis();
        SmartConfigRouterFactory.getStatPageV2Manager().page_addcamerareset(0);
        gwg.O000000o(this.mTitleBar);
        this.mWebView.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.smartconfig.step.CameraResetStep.AnonymousClass1 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        Locale globalSettingLocale = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingLocale();
        if (globalSettingLocale == null) {
            globalSettingLocale = Locale.getDefault();
        }
        final String str3 = (String) htr.O000000o().O000000o("device_model");
        this.mTitle.setText(SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(str3).O0000Oo0());
        if (SmartConfigRouterFactory.getCoreApiManager().isInternationalServer()) {
            ServerBean globalSettingServer = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServer();
            StringBuilder sb = new StringBuilder("https://");
            if (globalSettingServer != null) {
                str2 = globalSettingServer.f7546O000000o + ".";
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append("home.mi.com/views/deviceReset.html?model=");
            sb.append(str3);
            sb.append("&locale=");
            sb.append(hze.O000000o(globalSettingLocale));
            str = sb.toString();
        } else {
            str = "https://home.mi.com/views/deviceReset.html?model=" + str3 + "&locale=" + hze.O000000o(globalSettingLocale);
        }
        this.mWebView.loadUrl(str);
        this.mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.CameraResetStep.AnonymousClass2 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CameraResetStep.this.mButton.setEnabled(z);
                if (z) {
                    CameraResetStep.this.mButton.setTextColor(CameraResetStep.this.mButton.getResources().getColor(R.color.mj_color_white_100_transparent));
                } else {
                    CameraResetStep.this.mButton.setTextColor(CameraResetStep.this.mButton.getResources().getColor(R.color.mj_color_gray_lighter));
                }
            }
        });
        this.mCheckBoxRootView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.CameraResetStep.AnonymousClass3 */

            public final void onClick(View view) {
                CameraResetStep.this.mCheck.setChecked(!CameraResetStep.this.mCheck.isChecked());
            }
        });
        this.mButton.setEnabled(false);
        this.mButton.setTextColor(this.O000O0oo.getResources().getColor(R.color.mj_color_gray_lighter));
        this.mButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.CameraResetStep.AnonymousClass4 */

            public final void onClick(View view) {
                if (CameraResetStep.this.O00000Oo()) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_addcamerareset(CameraResetStep.this.f11646O000000o);
                    CameraResetStep.this.O000000o(SmartConfigStep.Step.STEP_CHOOSE_WIFI);
                }
            }
        });
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.CameraResetStep.AnonymousClass5 */

            public final void onClick(View view) {
                CameraResetStep.this.G_();
            }
        });
        htr.O000000o().O00000Oo("camera_process", Boolean.TRUE);
        SmartConfigRouterFactory.getSmartConfigManager().getDeviceDetailPageUrl(str3, new huf() {
            /* class com.xiaomi.smarthome.smartconfig.step.CameraResetStep.AnonymousClass6 */

            public final void accept(String str) {
                CameraResetStep.this.mDeviceDetail.setVisibility(0);
                CameraResetStep.this.mDeviceDetail.setOnClickListener(new View.OnClickListener(context, str, str3) {
                    /* class com.xiaomi.smarthome.smartconfig.step.$$Lambda$CameraResetStep$6$8sVOJXxja8C5cSyWFAYdGjRw0M */
                    private final /* synthetic */ Context f$0;
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        CameraResetStep.AnonymousClass6.O000000o(this.f$0, this.f$1, this.f$2, view);
                    }
                });
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ void O000000o(Context context, String str, String str2, View view) {
                OperationCommonWebViewActivity.start(context, str, null);
                SmartConfigRouterFactory.getStatClickManager().adddevice_reset_details(str2);
            }
        });
    }

    public final boolean G_() {
        SmartConfigRouterFactory.getStatPageV2Manager().page_addcamerareset(this.f11646O000000o);
        b_(false);
        return true;
    }

    public final boolean O00000Oo() {
        if (Build.VERSION.SDK_INT < 26 || (fwq.O00000Oo() && fwq.O000000o())) {
            return true;
        }
        SmartConfigRouterFactory.getSmartConfigManager().checkScanWifiLocationPermissionAndShowDialog((Activity) this.O000O0oo, R.string.permission_location_rational_desc_new, new hui() {
            /* class com.xiaomi.smarthome.smartconfig.step.CameraResetStep.AnonymousClass7 */

            public final void O000000o(boolean z) {
                CameraResetStep.O00000Oo = false;
                hxi.O00000o0.O000000o(z ? 1 : 2, 2);
            }

            public final void O00000Oo(boolean z) {
                CameraResetStep.O00000Oo = false;
                hxi.O00000o.O0000oo0(z ? 2 : 4);
            }

            public final void O00000o0(boolean z) {
                hxi.O00000o.O0000oo0(z ? 1 : 3);
                CameraResetStep.this.x_().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.smartconfig.step.CameraResetStep.AnonymousClass7.AnonymousClass1 */

                    public final void run() {
                        CameraResetStep.O00000Oo = true;
                    }
                }, 800);
            }
        });
        return false;
    }
}
