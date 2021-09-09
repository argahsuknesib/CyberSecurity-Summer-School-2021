package com.payu.custombrowser;

import _m_j.ft;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.SmsMessage;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.payu.custombrowser.CustomBrowserMain;
import com.payu.custombrowser.bean.CustomBrowserConfig;
import com.payu.custombrowser.bean.CustomBrowserData;
import com.payu.custombrowser.cbinterface.MagicRetryCallbacks;
import com.payu.custombrowser.custombar.CustomProgressBar;
import com.payu.custombrowser.services.SnoozeService;
import com.payu.custombrowser.util.CBAnalyticsConstant;
import com.payu.custombrowser.util.CBUtil;
import com.payu.custombrowser.util.L;
import com.payu.custombrowser.util.SharedPreferenceUtil;
import com.payu.custombrowser.util.SnoozeConfigMap;
import com.payu.custombrowser.widgets.SnoozeLoaderView;
import com.payu.custombrowser.widgets.SurePayCancelAsyncTaskHelper;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Permission;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PayUCBLifecycle extends CustomBrowserMain implements MagicRetryCallbacks {
    private static boolean isFromSnoozeService;
    public static int snoozeImageDownloadTimeout;
    protected static List<String> whiteListedUrls = new ArrayList();
    boolean SMSOTPClicked = false;
    public String SNOOZE_BROAD_CAST_MESSAGE = "snooze_broad_cast_message";
    protected String SNOOZE_GET_WEBVIEW_STATUS_INTENT_ACTION = "webview_status_action";
    Boolean approve_flag = Boolean.FALSE;
    View cbBlankOverlay;
    boolean checkLoading;
    boolean checkPermissionVisibility;
    boolean checkedPermission = false;
    int chooseActionHeight;
    CustomProgressBar customProgressBar;
    String enterOtpParams;
    protected boolean isSnoozeBroadCastReceiverRegistered = false;
    protected boolean isSnoozeEnabled = true;
    boolean isSnoozeNotificationLaunched;
    protected boolean isSnoozeServiceBounded = false;
    int mInternetRestoredWindowTTL = 0;
    boolean mPageReady = false;
    String mPassword;
    boolean permissionGranted = true;
    boolean pin_selected_flag;
    boolean showCB = true;
    protected CountDownTimer slowUserCountDownTimer;
    protected AlertDialog slowUserWarningDialog;
    protected BroadcastReceiver snoozeBroadCastReceiver;
    SnoozeConfigMap snoozeConfigMap;
    protected int snoozeCount = 0;
    protected int snoozeCountBackwardJourney = 0;
    int[] snoozeLoadPercentageAndTimeOut;
    Intent snoozeNotificationIntent;
    protected SnoozeService snoozeService;
    protected ServiceConnection snoozeServiceConnection = new ServiceConnection() {
        /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass1 */

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            PayUCBLifecycle.this.snoozeService = ((SnoozeService.SnoozeBinder) iBinder).getSnoozeService();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            PayUCBLifecycle.this.snoozeService = null;
        }
    };
    protected int snoozeUrlLoadingPercentage;
    protected int snoozeUrlLoadingTimeout;
    protected int snoozeVisibleCountBackwdJourney;
    protected int snoozeVisibleCountFwdJourney;
    int surePayDisableStatus = 0;
    Timer waitingOTPTimer;

    /* access modifiers changed from: package-private */
    public abstract void dismissSlowUserWarningTimer();

    /* access modifiers changed from: package-private */
    public abstract void enter_otp(String str);

    /* access modifiers changed from: package-private */
    public abstract void onPageStarted();

    /* access modifiers changed from: package-private */
    public abstract void reloadWebView();

    /* access modifiers changed from: package-private */
    public abstract void reloadWebView(String str);

    /* access modifiers changed from: package-private */
    public abstract void reloadWebView(String str, String str2);

    /* access modifiers changed from: package-private */
    public abstract void startSlowUserWarningTimer();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.activity = getActivity();
        this.cbUtil.resetPayuID();
        this.isSnoozeEnabled = this.cbUtil.getBooleanSharedPreferenceDefaultTrue("snoozeEnabled", getActivity().getApplicationContext());
        isFromSnoozeService = false;
        this.snoozeConfigMap = this.cbUtil.convertToSnoozeConfigMap(SharedPreferenceUtil.getSharedPrefMap(this.activity, "com.payu.custombrowser.snoozepref"));
        this.snoozeLoadPercentageAndTimeOut = this.snoozeConfigMap.getPercentageAndTimeout("*");
        int[] iArr = this.snoozeLoadPercentageAndTimeOut;
        this.snoozeUrlLoadingPercentage = iArr[0];
        this.snoozeUrlLoadingTimeout = iArr[1];
        this.surePayDisableStatus = this.cbUtil.getSurePayDisableStatus(this.snoozeConfigMap, "*");
        whiteListedUrls = CBUtil.processAndAddWhiteListedUrls(SharedPreferenceUtil.getStringFromSharedPreference(this.activity, "RETRY_SETTINGS", "RETRY_WHITELISTED_URLS", ""));
        snoozeImageDownloadTimeout = SharedPreferenceUtil.getIntFromSharedPreference(this.activity.getApplicationContext(), "com.payu.custombrowser.payucustombrowser", "sp_image_download_time_out", 0);
        SnoozeService snoozeService2 = this.snoozeService;
        if (snoozeService2 != null) {
            snoozeService2.killSnoozeService();
        }
        if (this.activity.getIntent().getStringExtra("sender") != null && this.activity.getIntent().getStringExtra("sender").contentEquals("snoozeService")) {
            isFromSnoozeService = true;
        }
        this.snoozeBroadCastReceiver = new BroadcastReceiver() {
            /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass2 */

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
            public void onReceive(Context context, Intent intent) {
                if (intent.hasExtra("broadcaststatus")) {
                    Intent intent2 = new Intent(PayUCBLifecycle.this.activity, CBActivity.class);
                    intent2.putExtra("sender", "snoozeService");
                    intent2.putExtra("verificationMsgReceived", true);
                    intent2.putExtra("payu_response", intent.getExtras().getString("payu_response"));
                    intent2.setFlags(805306368);
                    PayUCBLifecycle.this.startActivity(intent2);
                }
                if (intent.hasExtra(PayUCBLifecycle.this.SNOOZE_BROAD_CAST_MESSAGE) && PayUCBLifecycle.this.snoozeService != null) {
                    PayUCBLifecycle.this.snoozeService.updateWebviewStatus(intent.getStringExtra(PayUCBLifecycle.this.SNOOZE_BROAD_CAST_MESSAGE));
                }
                if (intent.getBooleanExtra("BROAD_CAST_FROM_SNOOZE_SERVICE", false)) {
                    PayUCBLifecycle.this.addEventAnalytics(intent.getStringExtra("event_key"), intent.getStringExtra("event_value"));
                }
                if (intent.hasExtra("snoozeServiceStatus")) {
                    PayUCBLifecycle.this.isSnoozeNotificationLaunched = true;
                    if (CBActivity.STATE != 2) {
                        int i = CBActivity.STATE;
                    }
                    PayUCBLifecycle.this.updateSnoozeDialogWithSnoozeServiceStatus();
                }
                if (intent.getBooleanExtra("broadcast_from_service_update_ui", false) && intent.hasExtra("is_forward_journey")) {
                    if (intent.getStringExtra("key").contentEquals("good_network_notification_launched")) {
                        PayUCBLifecycle payUCBLifecycle = PayUCBLifecycle.this;
                        payUCBLifecycle.isSnoozeNotificationLaunched = true;
                        payUCBLifecycle.snoozeNotificationIntent = intent;
                        return;
                    }
                    PayUCBLifecycle payUCBLifecycle2 = PayUCBLifecycle.this;
                    payUCBLifecycle2.isSnoozeNotificationLaunched = false;
                    payUCBLifecycle2.killSnoozeWindowAndContinuePayment(intent);
                }
            }
        };
        if (!this.activity.getClass().getSimpleName().equalsIgnoreCase("CBActivity")) {
            this.cbOldFlow = true;
            cbOldOnCreate();
        } else {
            cbOnCreate();
        }
        initAnalytics(Bank.keyAnalytics);
        this.pin_selected_flag = false;
        if (this.activity != null) {
            this.cbUtil.clearCookie();
        }
        if (this.customBrowserConfig != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.customBrowserConfig.getEnableSurePay());
            addEventAnalytics("snooze_enable_count", sb.toString());
            addEventAnalytics("snooze_mode_set_merchant", this.customBrowserConfig.getSurePayMode() == 1 ? "WARN" : "FAIL");
        }
    }

    public void updateSnoozeDialogWithSnoozeServiceStatus() {
        if (this.snoozeDialog != null && this.snoozeDialog.isShowing()) {
            this.snoozeDialog.cancel();
            this.snoozeDialog.dismiss();
        }
        View inflate = this.activity.getLayoutInflater().inflate((int) R.layout.cb_layout_snooze, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.snooze_header_txt)).setText(getString(R.string.cb_snooze_network_error));
        inflate.findViewById(R.id.text_view_cancel_snooze_window).setVisibility(8);
        ((TextView) inflate.findViewById(R.id.text_view_snooze_message)).setText(getString(R.string.cb_snooze_network_down_message));
        inflate.findViewById(R.id.snooze_loader_view).setVisibility(8);
        inflate.findViewById(R.id.button_snooze_transaction).setVisibility(8);
        inflate.findViewById(R.id.text_view_retry_message_detail).setVisibility(8);
        inflate.findViewById(R.id.button_retry_transaction).setVisibility(8);
        inflate.findViewById(R.id.button_cancel_transaction).setVisibility(8);
        inflate.findViewById(R.id.t_confirm).setVisibility(8);
        inflate.findViewById(R.id.t_nconfirm).setVisibility(8);
        Button button = (Button) inflate.findViewById(R.id.button_go_back_snooze);
        button.setVisibility(0);
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass3 */

            public void onClick(View view) {
                PayUCBLifecycle.this.activity.finish();
            }
        });
        this.snoozeDialog = new AlertDialog.Builder(this.activity).create();
        this.snoozeDialog.O000000o(inflate);
        this.snoozeDialog.setCanceledOnTouchOutside(false);
        this.snoozeDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass4 */

            public void onCancel(DialogInterface dialogInterface) {
                PayUCBLifecycle.this.activity.finish();
            }
        });
        this.snoozeDialog.show();
    }

    public void cbOldOnCreate() {
        this.bundle = getArguments();
        this.autoApprove = this.bundle.getBoolean("auto_approve", false);
        this.autoSelectOtp = this.bundle.getBoolean("auto_select_otp", false);
        this.storeOneClickHash = this.bundle.getInt("store_one_click_hash", 0);
        this.merchantSMSPermission = this.bundle.getBoolean("smsPermission", false);
        if (Bank.sdkVersion == null || Bank.sdkVersion.equalsIgnoreCase("")) {
            Bank.sdkVersion = getArguments().getString("sdkname");
        }
        if (Bank.transactionID == null || Bank.transactionID.equalsIgnoreCase("")) {
            Bank.transactionID = getArguments().getString("txnid");
        }
        if (Bank.keyAnalytics == null || Bank.keyAnalytics.equalsIgnoreCase("")) {
            Bank.keyAnalytics = getArguments().getString("merchantid");
        }
    }

    public void cbOnCreate() {
        if (getArguments() != null && getArguments().containsKey("cb_config")) {
            this.customBrowserConfig = (CustomBrowserConfig) getArguments().getParcelable("cb_config");
            int i = 0;
            boolean z = true;
            this.merchantSMSPermission = this.customBrowserConfig != null && this.customBrowserConfig.getMerchantSMSPermission() == 1;
            this.autoApprove = this.customBrowserConfig != null && this.customBrowserConfig.getAutoApprove() == 1;
            if (this.customBrowserConfig == null || this.customBrowserConfig.getAutoSelectOTP() != 1) {
                z = false;
            }
            this.autoSelectOtp = z;
            if (this.customBrowserConfig != null) {
                i = this.customBrowserConfig.getStoreOneClickHash();
            }
            this.storeOneClickHash = i;
            if (this.customBrowserConfig != null) {
                this.customBrowserConfig.getPostURL();
            }
            if (this.customBrowserConfig != null) {
                if (Bank.keyAnalytics == null || Bank.keyAnalytics.trim().equals("")) {
                    if (this.customBrowserConfig.getMerchantKey() != null || !this.customBrowserConfig.getMerchantKey().trim().equals("")) {
                        Bank.keyAnalytics = this.customBrowserConfig.getMerchantKey();
                    } else {
                        Bank.keyAnalytics = "";
                    }
                }
                if (Bank.transactionID == null || Bank.transactionID.trim().equals("")) {
                    if (this.customBrowserConfig.getTransactionID() == null || this.customBrowserConfig.getTransactionID().trim().equals("")) {
                        Bank.transactionID = "123";
                    } else {
                        Bank.transactionID = this.customBrowserConfig.getTransactionID();
                    }
                }
                if (Bank.sdkVersion != null && !Bank.sdkVersion.trim().equals("")) {
                    return;
                }
                if (this.customBrowserConfig.getSdkVersionName() == null || this.customBrowserConfig.getSdkVersionName().trim().equals("")) {
                    Bank.sdkVersion = "";
                } else {
                    Bank.sdkVersion = this.customBrowserConfig.getSdkVersionName();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        View view2;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.cbOldFlow) {
            view2 = layoutInflater.inflate((int) R.layout.bankold, viewGroup, false);
            view2.bringToFront();
            cbOldFlowOnCreateView();
            view = view2;
        } else {
            view2 = layoutInflater.inflate((int) R.layout.bank, viewGroup, false);
            this.cbTransparentView = view2.findViewById(R.id.trans_overlay);
            this.cbWebView = (WebView) view2.findViewById(R.id.webview);
            this.cbBlankOverlay = view2.findViewById(R.id.cb_blank_overlay);
            view = view2.findViewById(R.id.parent);
            cbOnCreateView();
        }
        CBUtil.setVariableReflection("com.payu.magicretry.MagicRetryFragment", "6.1.3", "cbVersion");
        this.cbBaseView = (FrameLayout) view2.findViewById(R.id.help_view);
        this.cbSlideBarView = view2.findViewById(R.id.view);
        this.cbWebPageProgressBar = (ProgressBar) view2.findViewById(R.id.cb_progressbar);
        initCBSettings();
        this.viewOnClickListener = new CustomBrowserMain.ViewOnClickListener();
        getInitializeJS();
        view.setOnTouchListener(new PayUCBLifeCycleTouchListener());
        return view2;
    }

    private void initCBSettings() {
        this.cbWebView.getSettings().setJavaScriptEnabled(true);
        this.cbWebView.addJavascriptInterface(this, "PayU");
        this.cbWebView.getSettings().setSupportMultipleWindows(true);
        this.cbWebView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass5 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                PayUCBLifecycle.this.dismissSlowUserWarningTimerOnTouch();
                if (PayUCBLifecycle.this.cbTransparentView != null) {
                    PayUCBLifecycle.this.cbTransparentView.setVisibility(8);
                }
                if (PayUCBLifecycle.this.frameState != 2) {
                    return false;
                }
                PayUCBLifecycle.this.minimizeWebviewHeight();
                return false;
            }
        });
        this.cbWebView.getSettings().setDomStorageEnabled(true);
        this.cbWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.cbWebView.getSettings().setCacheMode(2);
        this.cbWebView.getSettings().setAppCacheEnabled(false);
    }

    public void cbOldFlowOnCreateView() {
        this.cbWebView = (WebView) this.activity.findViewById(getArguments().getInt("webView"));
        if (Bank.paymentMode != null && Bank.paymentMode.equalsIgnoreCase("nb")) {
            this.cbWebView.getSettings().setUseWideViewPort(true);
        } else if (this.customBrowserConfig != null && this.customBrowserConfig.getViewPortWideEnable() == 1) {
            this.cbWebView.getSettings().setUseWideViewPort(true);
        }
        this.cbWebView.setFocusable(true);
        if (getArguments().getBoolean("backButton", true)) {
            this.cbWebView.setOnKeyListener(new View.OnKeyListener() {
                /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass6 */

                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (keyEvent.getAction() == 1 && i == 4) {
                        if (PayUCBLifecycle.this.getArguments().getBoolean("backButton", true)) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(PayUCBLifecycle.this.activity);
                            builder.setCancelable(false);
                            builder.setMessage("Do you really want to cancel the transaction ?");
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass6.AnonymousClass1 */

                                public void onClick(DialogInterface dialogInterface, int i) {
                                    PayUCBLifecycle.this.postToPaytxn();
                                    PayUCBLifecycle.this.addEventAnalytics("user_input", "back_button_ok");
                                    dialogInterface.dismiss();
                                    PayUCBLifecycle.this.onBackApproved();
                                    PayUCBLifecycle.this.activity.finish();
                                }
                            });
                            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass6.AnonymousClass2 */

                                public void onClick(DialogInterface dialogInterface, int i) {
                                    PayUCBLifecycle.this.addEventAnalytics("user_input", "back_button_cancel");
                                    PayUCBLifecycle.this.onBackCancelled();
                                    dialogInterface.dismiss();
                                }
                            });
                            PayUCBLifecycle.this.addEventAnalytics("user_input", "payu_back_button");
                            PayUCBLifecycle.this.onBackPressed(builder);
                            builder.show();
                            return true;
                        }
                        PayUCBLifecycle.this.addEventAnalytics("user_input", "m_back_button");
                        PayUCBLifecycle.this.activity.onBackPressed();
                    }
                    return false;
                }
            });
        }
        if (Bank.paymentMode != null && Bank.paymentMode.equalsIgnoreCase("nb")) {
            this.cbWebView.getSettings().setUseWideViewPort(true);
        } else if (this.bundle.getBoolean("viewPortWide", false)) {
            this.cbWebView.getSettings().setUseWideViewPort(true);
        }
    }

    public void cbOnCreateView() {
        if (Bank.paymentMode != null && Bank.paymentMode.equalsIgnoreCase("nb")) {
            this.cbWebView.getSettings().setUseWideViewPort(true);
        } else if (this.customBrowserConfig != null && this.customBrowserConfig.getViewPortWideEnable() == 1) {
            this.cbWebView.getSettings().setUseWideViewPort(true);
        }
        Bank bank = (Bank) this;
        this.cbWebView.setWebChromeClient(new PayUWebChromeClient(bank));
        if (this.customBrowserConfig.getEnableSurePay() > 0) {
            this.cbWebView.setWebViewClient(new PayUSurePayWebViewClient(bank, Bank.keyAnalytics));
        } else {
            this.cbWebView.setWebViewClient(new PayUWebViewClient(bank, Bank.keyAnalytics));
        }
        if (!(this.customBrowserConfig == null || this.customBrowserConfig.getPostURL() == null || this.customBrowserConfig.getPayuPostData() == null)) {
            this.cbWebView.postUrl(this.customBrowserConfig.getPostURL(), this.customBrowserConfig.getPayuPostData().getBytes());
        }
        if (CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() != null) {
            CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().setCBProperties(this.cbWebView, bank);
        }
        if (this.customBrowserConfig != null && this.customBrowserConfig.getMagicretry() == 1) {
            if (this.customBrowserConfig.getEnableSurePay() == 0) {
                initMagicRetry();
            }
            if (CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() != null) {
                CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().initializeMagicRetry(bank, this.cbWebView, this.magicRetryFragment);
            }
        }
    }

    public void logOnTerminate() {
        try {
            addEventAnalytics("last_url", CBUtil.updateLastUrl(this.cbUtil.getStringSharedPreference(this.activity.getApplicationContext(), "last_url")));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.cbUtil.deleteSharedPrefKey(this.activity.getApplicationContext(), "last_url");
            throw th;
        }
        this.cbUtil.deleteSharedPrefKey(this.activity.getApplicationContext(), "last_url");
        if (!this.eventArray.contains("CUSTOM_BROWSER")) {
            this.eventRecorded = "NON_CUSTOM_BROWSER";
            addEventAnalytics("cb_status", this.eventRecorded);
        }
        this.eventRecorded = "terminate_transaction";
        addEventAnalytics("user_input", this.eventRecorded);
        if (this.progressDialog != null && !this.progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
        if (this.mBroadcastReceiver != null) {
            unregisterBroadcast(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.cbUtil.cancelTimer(this.timerProgress);
        if (this.snoozeDialog != null && this.snoozeDialog.isShowing()) {
            this.snoozeDialog.dismiss();
        }
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.mResetCounter);
        this.cbUtil.cancelTimer(this.timerProgress);
        this.cbUtil.cancelTimer(this.waitingOTPTimer);
        CountDownTimer countDownTimer = this.slowUserCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.snoozeVisibleCountBackwdJourney + this.snoozeVisibleCountFwdJourney);
        addEventAnalytics("snooze_count", sb.toString());
        CustomBrowserData.SINGLETON.setPayuCustomBrowserCallback(null);
        if (this.snoozeDialog != null && this.snoozeDialog.isShowing()) {
            this.snoozeDialog.dismiss();
        }
        if (this.snoozeBroadCastReceiver != null && this.isSnoozeBroadCastReceiverRegistered && !isFromSnoozeService) {
            ft.O000000o(this.activity.getApplicationContext()).O000000o(this.snoozeBroadCastReceiver);
        }
        if (this.snoozeServiceConnection != null && this.isSnoozeServiceBounded) {
            this.activity.unbindService(this.snoozeServiceConnection);
        }
        SnoozeService snoozeService2 = this.snoozeService;
        if (snoozeService2 != null && isFromSnoozeService) {
            snoozeService2.killSnoozeService();
        }
        if (this.loadingLayout != null) {
            this.customProgressBar.removeProgressDialog(this.loadingLayout.findViewById(R.id.progress));
        }
        if (this.enterOTPView != null) {
            this.customProgressBar.removeProgressDialog(this.enterOTPView.findViewById(R.id.progress));
        }
        if (this.payuDeviceAnalytics != null) {
            this.cbUtil.cancelTimer(this.payuDeviceAnalytics.getmTimer());
        }
        if (this.mAnalytics != null) {
            this.cbUtil.cancelTimer(this.mAnalytics.getmTimer());
        }
        this.cbUtil.cancelTimer(this.waitingOTPTimer);
        if (this.countDownTimer != null) {
            this.countDownTimer.cancel();
        }
        logOnTerminate();
        Bank.sdkVersion = null;
        Bank.keyAnalytics = null;
        Bank.transactionID = null;
        Bank.paymentMode = null;
        this.cbUtil.resetPayuID();
    }

    public void onResume() {
        super.onResume();
        if (this.isSnoozeNotificationLaunched) {
            this.isSnoozeNotificationLaunched = false;
            cancelTransactionNotification();
            if (this.snoozeNotificationIntent != null) {
                if (this.backwardJourneyStarted) {
                    try {
                        if (Integer.parseInt(new JSONObject(this.snoozeNotificationIntent.getStringExtra("value")).get(getString(R.string.cb_snooze_verify_api_status)).toString()) == 1) {
                            addEventAnalytics("transaction_verified_dialog_recent_app", "-1");
                        } else {
                            addEventAnalytics("transaction_not_verified_dialog_recent_app", "-1");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        addEventAnalytics("transaction_not_verified_dialog_recent_app", "-1");
                    }
                } else {
                    addEventAnalytics("internet_restored_dialog_recent_app", "-1");
                }
                killSnoozeWindowAndContinuePayment(this.snoozeNotificationIntent);
                return;
            }
            addEventAnalytics("internet_not_restored_dialog_recent_app", "-1");
        }
    }

    /* access modifiers changed from: package-private */
    public void prepareSmsListener() {
        if (this.mBroadcastReceiver == null) {
            this.mBroadcastReceiver = new BroadcastReceiver() {
                /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass7 */

                public void onReceive(Context context, Intent intent) {
                    Bundle extras;
                    String str;
                    try {
                        if (PayUCBLifecycle.this.mBankJS != null) {
                            Bundle extras2 = intent.getExtras();
                            if (PayUCBLifecycle.this.getActivity() != null && (extras = intent.getExtras()) != null) {
                                Object[] objArr = (Object[]) extras.get("pdus");
                                String str2 = null;
                                if (objArr != null) {
                                    SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                                    str = null;
                                    for (int i = 0; i < smsMessageArr.length; i++) {
                                        if (Build.VERSION.SDK_INT >= 23) {
                                            smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i], extras2.getString("format"));
                                        } else {
                                            smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                                        }
                                        str2 = str2 + smsMessageArr[i].getMessageBody();
                                        str = smsMessageArr[i].getDisplayOriginatingAddress();
                                    }
                                } else {
                                    str = null;
                                }
                                PayUCBLifecycle.this.mPassword = CBUtil.filterSMS(PayUCBLifecycle.this.mBankJS, str2, PayUCBLifecycle.this.activity.getApplicationContext());
                                if (PayUCBLifecycle.this.mPassword != null) {
                                    PayUCBLifecycle.this.fillOTP(this);
                                    return;
                                }
                                if (PayUCBLifecycle.this.payuPG) {
                                    PayUCBLifecycle.this.verificationMsgReceived = PayUCBLifecycle.this.checkConfirmMessage(str, str2);
                                }
                                if (PayUCBLifecycle.this.verificationMsgReceived) {
                                    PayUCBLifecycle.this.addEventAnalytics(CBAnalyticsConstant.SNOOZE_BACKWARD_WINDOW_SMS_RECEIVED, CBAnalyticsConstant.RECEIVED);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(9999999);
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            registerBroadcast(this.mBroadcastReceiver, intentFilter);
        }
    }

    public void registerSMSBroadcast() {
        if (this.mBroadcastReceiver == null) {
            prepareSmsListener();
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(9999999);
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerBroadcast(this.mBroadcastReceiver, intentFilter);
    }

    /* access modifiers changed from: package-private */
    public String getValueFromPostData(String str) {
        for (String split : this.customBrowserConfig.getPayuPostData().split("&")) {
            String[] split2 = split.split("=");
            if (split2.length >= 2 && split2[0].equalsIgnoreCase(str)) {
                return split2[1];
            }
        }
        return null;
    }

    public boolean checkConfirmMessage(String str, String str2) {
        String lowerCase = str2.toLowerCase();
        int i = str.contains(this.bankName) ? 1 : 0;
        if (lowerCase.toLowerCase().contains(getValueFromPostData("amount").replace(",", ""))) {
            i++;
        }
        boolean z = i == 2;
        if (i != 0) {
            if ((!lowerCase.contains("made") || !lowerCase.contains("purchase")) && ((!lowerCase.contains("account") || !lowerCase.contains("debited")) && ((!lowerCase.contains("ac") || !lowerCase.contains("debited")) && ((!lowerCase.contains("tranx") || !lowerCase.contains("made")) && ((!lowerCase.contains("transaction") || !lowerCase.contains("made")) && !lowerCase.contains("spent") && !lowerCase.contains("Thank you using card for")))))) {
                if (!lowerCase.contains("charge") || !lowerCase.contains("initiated")) {
                    return z;
                }
                if (!lowerCase.contains("charge") || !lowerCase.contains("initiated")) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void fillOTP(BroadcastReceiver broadcastReceiver) {
        if (getActivity().findViewById(R.id.otp_sms) != null) {
            final TextView textView = (TextView) getActivity().findViewById(R.id.otp_sms);
            if (this.showCB && this.mPassword != null && textView.getVisibility() != 0) {
                this.cbUtil.cancelTimer(this.waitingOTPTimer);
                String str = this.eventRecorded;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -557081102) {
                    if (hashCode != 674270068) {
                        if (hashCode == 2084916017 && str.equals("regenerate_click")) {
                            c = 2;
                        }
                    } else if (str.equals("otp_click")) {
                        c = 1;
                    }
                } else if (str.equals("payment_initiated")) {
                    c = 0;
                }
                if (c == 0) {
                    this.eventRecorded = "received_otp_direct";
                } else if (c == 1) {
                    this.eventRecorded = "received_otp_selected";
                } else if (c != 2) {
                    this.eventRecorded = "otp_web";
                } else {
                    this.eventRecorded = "received_otp_regenerate";
                }
                addEventAnalytics("otp_received", this.eventRecorded);
                textView.setText(this.mPassword);
                this.mPassword = null;
                this.customProgressBar.removeDialog(getActivity().findViewById(R.id.progress));
                Button button = (Button) getActivity().findViewById(R.id.approve);
                button.setClickable(true);
                CBUtil.setAlpha(1.0f, button);
                button.setVisibility(0);
                this.activity.findViewById(R.id.timer).setVisibility(8);
                this.activity.findViewById(R.id.retry_text).setVisibility(8);
                this.activity.findViewById(R.id.regenerate_layout).setVisibility(8);
                this.activity.findViewById(R.id.waiting).setVisibility(8);
                this.activity.findViewById(R.id.otp_recieved).setVisibility(0);
                textView.setVisibility(0);
                if (this.autoApprove) {
                    button.performClick();
                    this.eventRecorded = "auto_approve";
                    addEventAnalytics("user_input", this.eventRecorded);
                }
                button.setOnClickListener(new View.OnClickListener() {
                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass8 */

                    public void onClick(View view) {
                        try {
                            PayUCBLifecycle.this.mPassword = null;
                            PayUCBLifecycle.this.eventRecorded = "approved_otp";
                            PayUCBLifecycle.this.addEventAnalytics("user_input", PayUCBLifecycle.this.eventRecorded);
                            PayUCBLifecycle.this.addEventAnalytics("Approve_btn_clicked_time", "-1");
                            PayUCBLifecycle.this.prepareSmsListener();
                            PayUCBLifecycle.this.checkLoading = false;
                            PayUCBLifecycle.this.approve_flag = Boolean.TRUE;
                            PayUCBLifecycle.this.onHelpUnavailable();
                            PayUCBLifecycle.this.maximiseWebviewHeight();
                            PayUCBLifecycle.this.frameState = 1;
                            WebView webView = PayUCBLifecycle.this.cbWebView;
                            webView.loadUrl("javascript:" + PayUCBLifecycle.this.mJS.getString(PayUCBLifecycle.this.getString(R.string.cb_process_otp)) + "(\"" + textView.getText().toString() + "\")");
                            textView.setText("");
                            PayUCBLifecycle.this.hideSoftKeyboard();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
                if (this.mBroadcastReceiver != null) {
                    broadcastReceiver.abortBroadcast();
                    unregisterBroadcast(this.mBroadcastReceiver);
                    this.mBroadcastReceiver = null;
                }
            }
        }
    }

    private void getInitializeJS() {
        prepareSmsListener();
        this.eventRecorded = "payment_initiated";
        addEventAnalytics("user_input", this.eventRecorded);
        this.serialExecutor.execute(new Runnable() {
            /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass9 */

            public void run() {
                final String str;
                final String str2;
                final String str3;
                HttpURLConnection httpsConn = CBUtil.getHttpsConn("https://secure.payu.in/js/sdk_js/v3/" + "initialize" + ".js");
                String str4 = "0";
                final String str5 = "";
                if (httpsConn != null) {
                    try {
                        if (httpsConn.getResponseCode() == 200) {
                            PayUCBLifecycle.this.cbUtil.writeFileOutputStream(httpsConn.getInputStream(), PayUCBLifecycle.this.activity, "initialize", 0);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            if (PayUCBLifecycle.this.activity != null) {
                                PayUCBLifecycle.this.mBankJS = new JSONObject(CBUtil.decodeContents(PayUCBLifecycle.this.activity.openFileInput("initialize")));
                                PayUCBLifecycle.this.setUrlString();
                                PayUCBLifecycle.this.checkVisibilityCB(str5, true);
                                if (PayUCBLifecycle.this.mBankJS.has("snooze_config")) {
                                    str2 = PayUCBLifecycle.this.mBankJS.get("snooze_config") + "('" + Bank.keyAnalytics + "')";
                                } else {
                                    str2 = str5;
                                }
                                if (PayUCBLifecycle.this.mBankJS.has("snooze_image_download_time")) {
                                    str4 = PayUCBLifecycle.this.mBankJS.get("snooze_image_download_time").toString();
                                }
                                PayUCBLifecycle.snoozeImageDownloadTimeout = Integer.parseInt(str4);
                                SharedPreferenceUtil.addIntToSharedPreference(PayUCBLifecycle.this.activity.getApplicationContext(), "com.payu.custombrowser.payucustombrowser", "sp_image_download_time_out", PayUCBLifecycle.snoozeImageDownloadTimeout);
                                if (PayUCBLifecycle.this.mBankJS.has(PayUCBLifecycle.this.getString(R.string.sp_internet_restored_ttl))) {
                                    str5 = PayUCBLifecycle.this.mBankJS.get(PayUCBLifecycle.this.getString(R.string.sp_internet_restored_ttl)) + "('" + Bank.keyAnalytics + "')";
                                }
                                PayUCBLifecycle.this.activity.runOnUiThread(new Runnable() {
                                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass9.AnonymousClass1 */

                                    public void run() {
                                        WebView webView = PayUCBLifecycle.this.cbWebView;
                                        webView.loadUrl("javascript:" + str);
                                    }
                                });
                                PayUCBLifecycle.this.activity.runOnUiThread(new Runnable() {
                                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass9.AnonymousClass2 */

                                    public void run() {
                                        WebView webView = PayUCBLifecycle.this.cbWebView;
                                        webView.loadUrl("javascript:" + str5);
                                    }
                                });
                                if (PayUCBLifecycle.this.mPageReady && PayUCBLifecycle.this.activity != null) {
                                    PayUCBLifecycle.this.activity.runOnUiThread(new Runnable() {
                                        /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass9.AnonymousClass3 */

                                        public void run() {
                                            PayUCBLifecycle.this.onPageStarted();
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (FileNotFoundException | JSONException e2) {
                            PayUCBLifecycle.this.communicationError();
                            e2.printStackTrace();
                            return;
                        } catch (Exception e3) {
                            PayUCBLifecycle.this.communicationError();
                            e3.printStackTrace();
                            return;
                        }
                    } catch (Throwable th) {
                        try {
                            if (PayUCBLifecycle.this.activity != null) {
                                PayUCBLifecycle.this.mBankJS = new JSONObject(CBUtil.decodeContents(PayUCBLifecycle.this.activity.openFileInput("initialize")));
                                PayUCBLifecycle.this.setUrlString();
                                PayUCBLifecycle.this.checkVisibilityCB(str5, true);
                                if (PayUCBLifecycle.this.mBankJS.has("snooze_config")) {
                                    str3 = PayUCBLifecycle.this.mBankJS.get("snooze_config") + "('" + Bank.keyAnalytics + "')";
                                } else {
                                    str3 = str5;
                                }
                                if (PayUCBLifecycle.this.mBankJS.has("snooze_image_download_time")) {
                                    str4 = PayUCBLifecycle.this.mBankJS.get("snooze_image_download_time").toString();
                                }
                                PayUCBLifecycle.snoozeImageDownloadTimeout = Integer.parseInt(str4);
                                SharedPreferenceUtil.addIntToSharedPreference(PayUCBLifecycle.this.activity.getApplicationContext(), "com.payu.custombrowser.payucustombrowser", "sp_image_download_time_out", PayUCBLifecycle.snoozeImageDownloadTimeout);
                                if (PayUCBLifecycle.this.mBankJS.has(PayUCBLifecycle.this.getString(R.string.sp_internet_restored_ttl))) {
                                    str5 = PayUCBLifecycle.this.mBankJS.get(PayUCBLifecycle.this.getString(R.string.sp_internet_restored_ttl)) + "('" + Bank.keyAnalytics + "')";
                                }
                                PayUCBLifecycle.this.activity.runOnUiThread(new Runnable() {
                                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass9.AnonymousClass1 */

                                    public void run() {
                                        WebView webView = PayUCBLifecycle.this.cbWebView;
                                        webView.loadUrl("javascript:" + str);
                                    }
                                });
                                PayUCBLifecycle.this.activity.runOnUiThread(new Runnable() {
                                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass9.AnonymousClass2 */

                                    public void run() {
                                        WebView webView = PayUCBLifecycle.this.cbWebView;
                                        webView.loadUrl("javascript:" + str5);
                                    }
                                });
                                if (PayUCBLifecycle.this.mPageReady && PayUCBLifecycle.this.activity != null) {
                                    PayUCBLifecycle.this.activity.runOnUiThread(new Runnable() {
                                        /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass9.AnonymousClass3 */

                                        public void run() {
                                            PayUCBLifecycle.this.onPageStarted();
                                        }
                                    });
                                }
                            }
                        } catch (FileNotFoundException | JSONException e4) {
                            PayUCBLifecycle.this.communicationError();
                            e4.printStackTrace();
                        } catch (Exception e5) {
                            PayUCBLifecycle.this.communicationError();
                            e5.printStackTrace();
                        }
                        throw th;
                    }
                }
                try {
                    if (PayUCBLifecycle.this.activity != null) {
                        PayUCBLifecycle.this.mBankJS = new JSONObject(CBUtil.decodeContents(PayUCBLifecycle.this.activity.openFileInput("initialize")));
                        PayUCBLifecycle.this.setUrlString();
                        PayUCBLifecycle.this.checkVisibilityCB(str5, true);
                        if (PayUCBLifecycle.this.mBankJS.has("snooze_config")) {
                            str = PayUCBLifecycle.this.mBankJS.get("snooze_config") + "('" + Bank.keyAnalytics + "')";
                        } else {
                            str = str5;
                        }
                        if (PayUCBLifecycle.this.mBankJS.has("snooze_image_download_time")) {
                            str4 = PayUCBLifecycle.this.mBankJS.get("snooze_image_download_time").toString();
                        }
                        PayUCBLifecycle.snoozeImageDownloadTimeout = Integer.parseInt(str4);
                        SharedPreferenceUtil.addIntToSharedPreference(PayUCBLifecycle.this.activity.getApplicationContext(), "com.payu.custombrowser.payucustombrowser", "sp_image_download_time_out", PayUCBLifecycle.snoozeImageDownloadTimeout);
                        if (PayUCBLifecycle.this.mBankJS.has(PayUCBLifecycle.this.getString(R.string.sp_internet_restored_ttl))) {
                            str5 = PayUCBLifecycle.this.mBankJS.get(PayUCBLifecycle.this.getString(R.string.sp_internet_restored_ttl)) + "('" + Bank.keyAnalytics + "')";
                        }
                        PayUCBLifecycle.this.activity.runOnUiThread(new Runnable() {
                            /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass9.AnonymousClass1 */

                            public void run() {
                                WebView webView = PayUCBLifecycle.this.cbWebView;
                                webView.loadUrl("javascript:" + str);
                            }
                        });
                        PayUCBLifecycle.this.activity.runOnUiThread(new Runnable() {
                            /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass9.AnonymousClass2 */

                            public void run() {
                                WebView webView = PayUCBLifecycle.this.cbWebView;
                                webView.loadUrl("javascript:" + str5);
                            }
                        });
                        if (PayUCBLifecycle.this.mPageReady && PayUCBLifecycle.this.activity != null) {
                            PayUCBLifecycle.this.activity.runOnUiThread(new Runnable() {
                                /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass9.AnonymousClass3 */

                                public void run() {
                                    PayUCBLifecycle.this.onPageStarted();
                                }
                            });
                        }
                    }
                } catch (FileNotFoundException | JSONException e6) {
                    PayUCBLifecycle.this.communicationError();
                    e6.printStackTrace();
                } catch (Exception e7) {
                    PayUCBLifecycle.this.communicationError();
                    e7.printStackTrace();
                }
            }
        });
    }

    public void updateHeight(View view) {
        if (this.maxWebview == 0) {
            calculateMaximumWebViewHeight();
            maximiseWebviewHeight();
        }
        calculateCBHeight(view);
    }

    public void updateLoaderHeight() {
        if (this.chooseActionHeight == 0) {
            this.cbWebView.measure(-1, -1);
            double measuredHeight = (double) this.cbWebView.getMeasuredHeight();
            Double.isNaN(measuredHeight);
            this.chooseActionHeight = (int) (measuredHeight * 0.35d);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            this.checkPermissionVisibility = false;
            if (this.SMSOTPClicked) {
                try {
                    WebView webView = this.cbWebView;
                    webView.loadUrl("javascript:" + this.mJS.getString(getString(R.string.cb_otp)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (ContextCompat.O000000o(this.activity, Permission.RECEIVE_SMS) == 0) {
                this.permissionGranted = true;
                this.mPassword = null;
                prepareSmsListener();
                enter_otp(this.enterOtpParams);
                return;
            }
            this.permissionGranted = false;
            enter_otp(this.enterOtpParams);
        }
    }

    /* access modifiers changed from: protected */
    public void showSlowUserWarning() {
        if (this.activity != null && !this.activity.isFinishing() && !this.isSnoozeWindowVisible) {
            View inflate = this.activity.getLayoutInflater().inflate((int) R.layout.cb_layout_snooze_slow_user, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.snooze_header_txt)).setText((int) R.string.cb_snooze_slow_user_warning_header);
            TextView textView = (TextView) inflate.findViewById(R.id.text_view_cancel_snooze_window);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.snooze_status_icon);
            imageView.setVisibility(0);
            imageView.setImageDrawable(getCbDrawable(this.activity.getApplicationContext(), R.drawable.hourglass));
            if (this.slowUserWarningDialog == null) {
                this.slowUserWarningDialog = new AlertDialog.Builder(this.activity).create();
                this.slowUserWarningDialog.setView(inflate);
                this.slowUserWarningDialog.setCanceledOnTouchOutside(true);
                this.slowUserWarningDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass10 */

                    public void onDismiss(DialogInterface dialogInterface) {
                    }
                });
                this.slowUserWarningDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass11 */

                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4 || keyEvent.getAction() != 0) {
                            return true;
                        }
                        PayUCBLifecycle.this.slowUserWarningDialog.dismiss();
                        return true;
                    }
                });
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass12 */

                    public void onClick(View view) {
                        PayUCBLifecycle.this.slowUserWarningDialog.dismiss();
                    }
                });
            }
            this.slowUserWarningDialog.show();
            if (CBActivity.STATE == 1) {
                showSlowUserWarningNotification();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dismissSlowUserWarning() {
        android.app.AlertDialog alertDialog = this.slowUserWarningDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void dismissSlowUserWarningTimerOnTouch() {
        if (this.forwardJourneyForChromeLoaderIsComplete) {
            this.firstTouch = true;
            dismissSlowUserWarningTimer();
        }
    }

    /* access modifiers changed from: protected */
    public void showSlowUserWarningNotification() {
        if (this.activity != null && !this.activity.isFinishing()) {
            new Intent();
        }
    }

    public class PayUCBLifeCycleTouchListener extends CustomBrowserMain.CBMainViewOnTouchListener {
        public PayUCBLifeCycleTouchListener() {
            super();
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            L.v("sTag", "onTouch of PayUCBLifeCycleCalled");
            PayUCBLifecycle.this.dismissSlowUserWarningTimerOnTouch();
            return super.onTouch(view, motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void showCbBlankOverlay(int i) {
        View view = this.cbBlankOverlay;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    /* access modifiers changed from: protected */
    public void updateSnoozeDialogWithMessage(String str, String str2) {
        if (this.snoozeDialog != null && this.snoozeDialog.isShowing()) {
            this.snoozeDialog.cancel();
            this.snoozeDialog.dismiss();
        }
        View inflate = this.activity.getLayoutInflater().inflate((int) R.layout.cb_layout_snooze, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.snooze_header_txt)).setText(str);
        inflate.findViewById(R.id.text_view_cancel_snooze_window).setVisibility(8);
        ((TextView) inflate.findViewById(R.id.text_view_snooze_message)).setText(str2);
        SnoozeLoaderView snoozeLoaderView = (SnoozeLoaderView) inflate.findViewById(R.id.snooze_loader_view);
        snoozeLoaderView.setVisibility(0);
        snoozeLoaderView.startAnimation();
        inflate.findViewById(R.id.button_snooze_transaction).setVisibility(8);
        inflate.findViewById(R.id.text_view_retry_message_detail).setVisibility(8);
        inflate.findViewById(R.id.button_retry_transaction).setVisibility(8);
        inflate.findViewById(R.id.button_cancel_transaction).setVisibility(8);
        inflate.findViewById(R.id.t_confirm).setVisibility(8);
        inflate.findViewById(R.id.t_nconfirm).setVisibility(8);
        inflate.findViewById(R.id.button_go_back_snooze).setVisibility(8);
        this.snoozeDialog = new AlertDialog.Builder(this.activity).create();
        this.snoozeDialog.O000000o(inflate);
        this.snoozeDialog.setCancelable(false);
        this.snoozeDialog.setCanceledOnTouchOutside(false);
        this.snoozeDialog.show();
    }

    public void killSnoozeWindowAndContinuePayment(final Intent intent) {
        int internetRestoredWindowTTL = this.customBrowserConfig != null ? this.customBrowserConfig.getInternetRestoredWindowTTL() : 5000;
        int i = this.mInternetRestoredWindowTTL;
        if (i != 0) {
            internetRestoredWindowTTL = i;
        }
        if (this.backwardJourneyStarted) {
            try {
                if (this.cbUtil.getValueOfJSONKey(intent.getStringExtra("value"), getString(R.string.cb_snooze_verify_api_status)).contentEquals("1")) {
                    updateSnoozeDialogWithMessage(getString(R.string.cb_transaction_verified), getString(R.string.redirect_back_to_merchant));
                } else {
                    updateSnoozeDialogWithMessage(getString(R.string.cb_transaction_state_unknown), getString(R.string.status_unknown_redirect_to_merchant));
                }
            } catch (Exception e) {
                e.printStackTrace();
                updateSnoozeDialogWithMessage(getString(R.string.cb_transaction_state_unknown), getString(R.string.status_unknown_redirect_to_merchant));
            }
        } else {
            updateSnoozeDialogWithMessage(getString(R.string.internet_restored), getString(R.string.resuming_your_transaction));
        }
        new Handler().postDelayed(new Runnable() {
            /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass13 */

            public void run() {
                if (PayUCBLifecycle.this.snoozeDialog != null) {
                    PayUCBLifecycle.this.snoozeDialog.dismiss();
                }
                if (PayUCBLifecycle.this.backwardJourneyStarted) {
                    if (PayUCBLifecycle.this.snoozeService != null) {
                        PayUCBLifecycle.this.snoozeService.killSnoozeService();
                    }
                    PayUCBLifecycle.this.showTransactionStatusDialog(intent.getStringExtra("value"), false);
                    return;
                }
                PayUCBLifecycle.this.resumeTransaction(intent);
            }
        }, (long) internetRestoredWindowTTL);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa A[Catch:{ Exception -> 0x01f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0135 A[Catch:{ Exception -> 0x01f2 }] */
    public void showTransactionStatusDialog(String str, boolean z) {
        final String str2;
        String str3 = str;
        try {
            setTransactionStatusReceived(true);
            String valueOfJSONKey = this.cbUtil.getValueOfJSONKey(str3, getString(R.string.cb_snooze_verify_api_status));
            View inflate = this.activity.getLayoutInflater().inflate((int) R.layout.cb_layout_snooze, (ViewGroup) null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
            builder.setView(inflate);
            this.snoozeDialog = builder.create();
            if (valueOfJSONKey.contentEquals("1")) {
                if (Bank.isUrlWhiteListed(this.cbWebView.getUrl() != null ? this.cbWebView.getUrl() : "")) {
                    if (19 != Build.VERSION.SDK_INT) {
                        addEventAnalytics("snooze_transaction_status_update", "data_repost");
                        progressBarVisibilityPayuChrome(8, "");
                        reloadWebView();
                        return;
                    }
                }
                addEventAnalytics("snooze_transaction_status_update", "post_to_surl");
                try {
                    str2 = this.cbUtil.getValueOfJSONKey(str3, "response");
                    try {
                        postDataToSurl(str2, new CBUtil().getDataFromPostData(this.customBrowserConfig.getPayuPostData(), "surl"));
                    } catch (JSONException e) {
                        e = e;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    str2 = "";
                    e.printStackTrace();
                    if (!z) {
                    }
                }
                if (!z) {
                    inflate.findViewById(R.id.snooze_status_icon).setVisibility(0);
                    ((TextView) inflate.findViewById(R.id.snooze_header_txt)).setText((int) R.string.cb_transaction_sucess);
                    inflate.findViewById(R.id.text_view_cancel_snooze_window).setVisibility(8);
                    ((TextView) inflate.findViewById(R.id.text_view_snooze_message)).setText(getString(R.string.cb_transaction_success_msg));
                    inflate.findViewById(R.id.snooze_loader_view).setVisibility(8);
                    inflate.findViewById(R.id.button_snooze_transaction).setVisibility(8);
                    inflate.findViewById(R.id.text_view_retry_message_detail).setVisibility(8);
                    inflate.findViewById(R.id.button_retry_transaction).setVisibility(8);
                    inflate.findViewById(R.id.button_cancel_transaction).setVisibility(8);
                    inflate.findViewById(R.id.t_confirm).setVisibility(8);
                    inflate.findViewById(R.id.t_nconfirm).setVisibility(8);
                    this.snoozeDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass14 */

                        public void onDismiss(DialogInterface dialogInterface) {
                            try {
                                if (!(CustomBrowserData.SINGLETON == null || CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() == null)) {
                                    CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().onPaymentSuccess(str2, "");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            PayUCBLifecycle.this.snoozeDialog.dismiss();
                            PayUCBLifecycle.this.snoozeDialog.cancel();
                            PayUCBLifecycle.this.activity.finish();
                        }
                    });
                    this.snoozeDialog.setCanceledOnTouchOutside(false);
                    this.snoozeDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass15 */

                        public void run() {
                            if (PayUCBLifecycle.this.snoozeDialog != null && PayUCBLifecycle.this.snoozeDialog.isShowing()) {
                                PayUCBLifecycle.this.snoozeDialog.cancel();
                                PayUCBLifecycle.this.snoozeDialog.dismiss();
                                PayUCBLifecycle.this.activity.finish();
                            }
                        }
                    }, 5000);
                    return;
                }
                if (!(CustomBrowserData.SINGLETON == null || CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() == null)) {
                    CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().onPaymentSuccess(str2, "");
                }
                this.activity.finish();
            } else if (z) {
                inflate.findViewById(R.id.button_snooze_transaction).setVisibility(0);
                inflate.findViewById(R.id.snooze_status_icon).setVisibility(0);
                inflate.findViewById(R.id.text_view_cancel_snooze_window).setVisibility(8);
                inflate.findViewById(R.id.button_snooze_transaction).setVisibility(8);
                ((TextView) inflate.findViewById(R.id.snooze_header_txt)).setText((int) R.string.cb_transaction_failed_title);
                ((TextView) inflate.findViewById(R.id.text_view_snooze_message)).setText((int) R.string.cb_transaction_failed);
                inflate.findViewById(R.id.button_retry_transaction).setVisibility(8);
                inflate.findViewById(R.id.button_cancel_transaction).setVisibility(0);
                inflate.findViewById(R.id.button_snooze_transaction).setVisibility(8);
                inflate.findViewById(R.id.text_view_retry_message_detail).setVisibility(8);
                inflate.findViewById(R.id.text_view_transaction_snoozed_message1).setVisibility(8);
                inflate.findViewById(R.id.text_view_ac_debited_twice).setVisibility(8);
                inflate.findViewById(R.id.button_cancel_transaction).setOnClickListener(new View.OnClickListener() {
                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass16 */

                    public void onClick(View view) {
                        PayUCBLifecycle.this.addEventAnalytics("snooze_interaction_time", "-1");
                        PayUCBLifecycle.this.addEventAnalytics("snooze_window_action", "snooze_cancel_transaction_click");
                        PayUCBLifecycle.this.snoozeDialog.dismiss();
                        PayUCBLifecycle.this.snoozeDialog.cancel();
                        PayUCBLifecycle.this.activity.finish();
                    }
                });
                this.snoozeDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass17 */

                    public void onDismiss(DialogInterface dialogInterface) {
                        PayUCBLifecycle.this.snoozeDialog.dismiss();
                        PayUCBLifecycle.this.snoozeDialog.cancel();
                    }
                });
                this.snoozeDialog.setCanceledOnTouchOutside(false);
                this.snoozeDialog.show();
                new Handler().postDelayed(new Runnable() {
                    /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass18 */

                    public void run() {
                        if (PayUCBLifecycle.this.snoozeDialog != null && PayUCBLifecycle.this.snoozeDialog.isShowing()) {
                            PayUCBLifecycle.this.snoozeDialog.cancel();
                            PayUCBLifecycle.this.snoozeDialog.dismiss();
                            PayUCBLifecycle.this.activity.finish();
                        }
                    }
                }, 5000);
            } else {
                this.activity.finish();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void postDataToSurl(final String str, final String str2) {
        new Thread(new Runnable() {
            /* class com.payu.custombrowser.PayUCBLifecycle.AnonymousClass19 */

            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(URLDecoder.decode(str2, "UTF-8")).openConnection();
                    String str = str;
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str.length()));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.getOutputStream().write(str.getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void resumeTransaction(Intent intent) {
        this.customBrowserConfig = (CustomBrowserConfig) intent.getExtras().getParcelable("cb_config");
        if (intent.getStringExtra("currentUrl") == null) {
            reloadWebView(this.customBrowserConfig.getPostURL(), this.customBrowserConfig.getPayuPostData());
        } else if (intent.getStringExtra("currentUrl").equalsIgnoreCase(this.customBrowserConfig.getPostURL())) {
            if (this.customBrowserConfig.getPostURL().contentEquals("https://secure.payu.in/_payment") || this.customBrowserConfig.getPostURL().contentEquals("https://mobiletest.payu.in/_payment")) {
                markPreviousTxnAsUserCanceled(this.cbUtil.getLogMessage(this.activity.getApplicationContext(), "sure_pay_cancelled", this.customBrowserConfig.getTransactionID(), "", Bank.keyAnalytics, this.customBrowserConfig.getTransactionID(), ""));
            }
            reloadWebView(this.customBrowserConfig.getPostURL(), this.customBrowserConfig.getPayuPostData());
        } else if (Bank.isUrlWhiteListed(intent.getStringExtra("currentUrl"))) {
            reloadWebView(intent.getStringExtra("currentUrl"));
        } else {
            if (this.customBrowserConfig.getPostURL().contentEquals("https://secure.payu.in/_payment") || this.customBrowserConfig.getPostURL().contentEquals("https://mobiletest.payu.in/_payment")) {
                markPreviousTxnAsUserCanceled(this.cbUtil.getLogMessage(this.activity.getApplicationContext(), "sure_pay_cancelled", this.customBrowserConfig.getTransactionID(), "", Bank.keyAnalytics, this.customBrowserConfig.getTransactionID(), ""));
            }
            reloadWebView(this.customBrowserConfig.getPostURL(), this.customBrowserConfig.getPayuPostData());
        }
    }

    public void markPreviousTxnAsUserCanceled(String str) {
        new SurePayCancelAsyncTaskHelper(str).execute();
    }
}
