package com.payu.custombrowser;

import _m_j.ee;
import _m_j.ei;
import _m_j.ft;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.payu.custombrowser.bean.CustomBrowserData;
import com.payu.custombrowser.custombar.CustomProgressBar;
import com.payu.custombrowser.services.SnoozeService;
import com.payu.custombrowser.util.CBAnalyticsConstant;
import com.payu.custombrowser.util.CBConstant;
import com.payu.custombrowser.util.CBUtil;
import com.payu.custombrowser.util.L;
import com.payu.custombrowser.util.MissingParamException;
import com.payu.custombrowser.widgets.SnoozeLoaderView;
import com.payu.magicretry.MagicRetryFragment;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Permission;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class Bank extends PayUCBLifecycle {
    public static String Version = "6.1.3";
    public static String keyAnalytics;
    static String paymentMode;
    static String sdkVersion;
    static String transactionID;
    private static List<String> whiteListedUrls = new ArrayList();
    public ButtonOnclickListener buttonClickListener = new ButtonOnclickListener();
    private int currentLoadingProgress;
    Runnable enterOtpRunnable;
    private boolean firstFinish = true;
    private boolean isFirstURLLoaded;
    private boolean isMRDataSet = false;
    public boolean isPageStoppedForcefully = false;
    public boolean isSnoozeTimerRunning = false;
    private boolean isSurePayResumed = false;
    private CountDownTimer mCountDownTimer = null;
    public boolean mLoadingJS = false;
    public boolean pageStarted = false;
    private CountDownTimer payUChromeLoaderDisableTimer;
    private CountDownTimer payUChromeLoaderEnableTimer;
    public boolean saveUserIDCheck = true;
    public boolean showSnoozeWindow = true;
    public boolean showToggleCheck = false;
    public long snoozeClickedTime;
    private View snoozeLayout;
    public SnoozeLoaderView snoozeLoaderView;
    private boolean stopOnlyOnce;
    private boolean visibilitychecked;
    private boolean webpageNotFoundError = false;

    public Bank() {
        this.customProgressBar = new CustomProgressBar();
        this.backwardJourneyUrls = new HashSet();
        this.cbUtil = new CBUtil();
        this.serialExecutor = Executors.newCachedThreadPool();
        this.retryUrls = new HashSet();
    }

    public static boolean isUrlWhiteListed(String str) {
        if ((str.contains("https://secure.payu.in") || str.contains("https://mobiletest.payu.in")) && str.contains("_response")) {
            return true;
        }
        for (String next : whiteListedUrls) {
            if (str != null && str.contains(next)) {
                return true;
            }
        }
        return false;
    }

    public SnoozeLoaderView getSnoozeLoaderView() {
        return this.snoozeLoaderView;
    }

    public String getPageType() {
        return this.pageType;
    }

    public void reloadWebView(String str, String str2) {
        this.forwardJourneyForChromeLoaderIsComplete = false;
        this.backwardJourneyStarted = false;
        this.isWebviewReloading = true;
        registerSMSBroadcast();
        this.backwardJourneyStarted = false;
        if (this.snoozeService != null) {
            this.snoozeService.killSnoozeService();
        }
        if (this.isSnoozeWindowVisible) {
            dismissSnoozeWindow();
        }
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
        }
        this.progressDialog = null;
        if (Build.VERSION.SDK_INT == 16 || Build.VERSION.SDK_INT == 17 || Build.VERSION.SDK_INT == 18) {
            this.cbWebView.loadUrl("about:blank");
        }
        setSurePayResumeStatus(true);
        resetAutoSelectOTP();
        this.cbUtil.resetPayuID();
        this.cbWebView.postUrl(str, str2.getBytes());
    }

    public void killSnoozeService() {
        if (this.snoozeService != null) {
            this.snoozeService.killSnoozeService();
        }
    }

    public void reloadWebView() {
        if (this.snoozeService != null) {
            this.snoozeService.killSnoozeService();
        }
        if (this.isSnoozeWindowVisible) {
            dismissSnoozeWindow();
        }
        registerSMSBroadcast();
        this.isWebviewReloading = true;
        if (this.isSnoozeEnabled) {
            initializeSnoozeTimer();
        }
        if (this.cbWebView.getUrl() != null) {
            setSurePayResumeStatus(true);
            if (19 == Build.VERSION.SDK_INT) {
                this.cbWebView.reload();
            } else {
                reloadWVUsingJS();
            }
        }
    }

    public void reloadWebView(String str) {
        if (this.snoozeService != null) {
            this.snoozeService.killSnoozeService();
        }
        if (this.isSnoozeWindowVisible) {
            dismissSnoozeWindow();
        }
        registerSMSBroadcast();
        this.isWebviewReloading = true;
        if (this.isSnoozeEnabled) {
            initializeSnoozeTimer();
        }
        if (this.cbWebView.getUrl() != null) {
            setSurePayResumeStatus(true);
            if (19 == Build.VERSION.SDK_INT) {
                this.cbWebView.reload();
            } else {
                reloadWVUsingJS();
            }
        } else {
            reloadWebView(this.customBrowserConfig.getPostURL(), this.customBrowserConfig.getPayuPostData());
        }
    }

    public String getBankName() {
        if (this.bankName == null) {
            return "";
        }
        return this.bankName;
    }

    public void checkPermission() {
        boolean z = true;
        if (this.checkedPermission || Build.VERSION.SDK_INT < 23 || !this.merchantSMSPermission) {
            onHelpAvailable();
            if (ContextCompat.O000000o(this.activity, Permission.RECEIVE_SMS) != 0) {
                z = false;
            }
            this.permissionGranted = z;
            if (this.SMSOTPClicked) {
                try {
                    WebView webView = this.cbWebView;
                    webView.loadUrl("javascript:" + this.mJS.getString(getString(R.string.cb_otp)));
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.checkedPermission = true;
            if (ContextCompat.O000000o(this.activity, Permission.RECEIVE_SMS) != 0) {
                requestPermissions(new String[]{Permission.RECEIVE_SMS}, 1);
                this.checkPermissionVisibility = true;
                return;
            }
            this.permissionGranted = true;
            if (this.SMSOTPClicked) {
                try {
                    WebView webView2 = this.cbWebView;
                    webView2.loadUrl("javascript:" + this.mJS.getString(getString(R.string.cb_otp)));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    @JavascriptInterface
    public void showCustomBrowser(final boolean z) {
        this.showCB = z;
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                /* class com.payu.custombrowser.Bank.AnonymousClass1 */

                public void run() {
                    if (!z) {
                        Bank.this.maximiseWebviewHeight();
                        Bank bank = Bank.this;
                        bank.frameState = 1;
                        try {
                            if (bank.cbSlideBarView != null) {
                                Bank.this.cbSlideBarView.setVisibility(8);
                            }
                            Bank.this.onHelpUnavailable();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void setMRData(String str) {
        if (!this.isMRDataSet) {
            MagicRetryFragment.setMRData(str, getActivity().getApplicationContext());
            updateWhitelistedRetryUrls(CBUtil.updateRetryData(str, getActivity().getApplicationContext()));
            this.isMRDataSet = true;
        }
    }

    public void onOverrideURL(String str) {
        if (this.cbWebPageProgressBar != null) {
            this.cbWebPageProgressBar.setProgress(10);
        }
    }

    private void snoozeOnReceivedError() {
        setIsPageStoppedForcefully(true);
        if (this.snoozeConfigMap != null) {
            stopSnoozeCountDownTimer();
            this.surePayDisableStatus = this.cbUtil.getSurePayDisableStatus(this.snoozeConfigMap, this.webviewUrl);
            launchSnoozeWindow(2);
        }
    }

    public void onReceivedErrorWebClient(int i, String str) {
        this.webpageNotFoundError = true;
        try {
            if (getActivity() != null && !getActivity().isFinishing() && CustomBrowserData.SINGLETON != null && CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() != null) {
                if (!this.backwardJourneyStarted) {
                    snoozeOnReceivedError();
                } else if (this.backwardJourneyStarted && this.isTxnNBType && this.snoozeCountBackwardJourney < this.customBrowserConfig.getEnableSurePay()) {
                    dismissSnoozeWindow();
                    snoozeOnReceivedError();
                }
                onHelpUnavailable();
                this.cbBaseView.removeAllViews();
                if (this.cbWebPageProgressBar != null) {
                    this.cbWebPageProgressBar.setVisibility(8);
                }
                if (this.maxWebview != 0) {
                    maximiseWebviewHeight();
                    this.frameState = 1;
                }
                hideCB();
                if (!this.cbOldFlow) {
                    CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().onCBErrorReceived(i, str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMagicRetryCB() {
        try {
            WebView webView = this.cbWebView;
            webView.loadUrl("javascript:" + this.mBankJS.getString("getMagicRetryUrls") + "('" + keyAnalytics + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onProgressChanged(int i) {
        if (this.activity != null && !this.activity.isFinishing() && !isRemoving() && isAdded() && this.cbWebPageProgressBar != null) {
            this.cbWebPageProgressBar.setVisibility(0);
            if (i != 100) {
                startAnimation(i);
            } else if (this.cbWebPageProgressBar != null) {
                this.cbWebPageProgressBar.setProgress(100);
                new Handler().postDelayed(new Runnable() {
                    /* class com.payu.custombrowser.Bank.AnonymousClass2 */

                    public void run() {
                        if (Bank.this.activity != null && !Bank.this.activity.isFinishing() && !Bank.this.isRemoving() && Bank.this.isAdded()) {
                            Bank.this.cbWebPageProgressBar.setVisibility(8);
                            Bank.this.lastProgress = 0;
                        }
                    }
                }, 100);
            }
        }
    }

    @JavascriptInterface
    public void onMerchantHashReceived(final String str) {
        if (getActivity() != null && !getActivity().isFinishing() && !isRemoving() && isAdded()) {
            getActivity().runOnUiThread(new Runnable() {
                /* class com.payu.custombrowser.Bank.AnonymousClass3 */

                public void run() {
                    if (Bank.this.storeOneClickHash == 2) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            Bank.this.cbUtil.storeInSharedPreferences(Bank.this.getActivity().getApplicationContext(), jSONObject.getString("card_token"), jSONObject.getString("merchant_hash"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    private void initializeSnoozeTimer() {
        if (CustomBrowserData.SINGLETON != null && CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() != null && this.customBrowserConfig != null && this.cbUtil.getBooleanSharedPreferenceDefaultTrue("snoozeEnabled", this.activity.getApplicationContext()) && this.customBrowserConfig.getEnableSurePay() > this.snoozeCount) {
            if (this.isSnoozeTimerRunning) {
                stopSnoozeCountDownTimer();
            }
            startSnoozeCountDownTimer();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a2, code lost:
        if (r11.contains(java.net.URLDecoder.decode(r10.cbUtil.getDataFromPostData(r10.customBrowserConfig.getPayuPostData(), "surl"), "UTF-8")) == false) goto L_0x01a4;
     */
    public void onPageStartedWebclient(String str) {
        this.pageStarted = true;
        this.isPageStoppedForcefully = false;
        if ((Build.VERSION.SDK_INT == 16 || Build.VERSION.SDK_INT == 17 || Build.VERSION.SDK_INT == 18) && this.webpageNotFoundError) {
            jellyBeanOnReceivedError();
        }
        this.webpageNotFoundError = false;
        dismissSlowUserWarning();
        if (!this.payuPG && str != null && (str.equalsIgnoreCase("https://secure.payu.in/_payment") || str.equalsIgnoreCase("https://secure.payu.in/_seamless_payment"))) {
            this.payuPG = true;
        }
        if (!this.isFirstURLLoaded) {
            if (this.customBrowserConfig != null && this.customBrowserConfig.getPayuPostData() == null && this.customBrowserConfig.getPostURL() == null) {
                if (CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().getPostData() == null || CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().getPostURL() == null) {
                    throw new MissingParamException("POST Data or POST URL Missing or wrong POST URL");
                }
                this.customBrowserConfig.setPayuPostData(CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().getPostData());
                this.customBrowserConfig.setPostURL(CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().getPostURL());
                CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().setPostURL(null);
                CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().setPostData(null);
            }
            if (this.customBrowserConfig != null) {
                this.isTxnNBType = checkIfTransactionNBType(this.customBrowserConfig.getPayuPostData());
            }
            this.isFirstURLLoaded = true;
        }
        this.showSnoozeWindow = true;
        if (this.pageType != null && !this.pageType.equalsIgnoreCase("")) {
            addEventAnalytics("departure", "-1");
            this.pageType = "";
        }
        if (this.activity != null && !this.activity.isFinishing() && !isRemoving() && isAdded()) {
            this.cbUtil.setStringSharedPreferenceLastURL(this.activity.getApplicationContext(), "last_url", "s:".concat(String.valueOf(str)));
            if (this.cbWebPageProgressBar != null) {
                this.cbWebPageProgressBar.setVisibility(0);
            }
            CountDownTimer countDownTimer = this.payUChromeLoaderDisableTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            if (this.cbWebPageProgressBar != null) {
                this.cbWebPageProgressBar.setVisibility(0);
                this.cbWebPageProgressBar.setProgress(10);
            }
            this.backwardJourneyStarted = isInBackWardJourney(str);
            if (!this.forwardJourneyForChromeLoaderIsComplete || this.backwardJourneyStarted) {
                progressBarVisibilityPayuChrome(0, str);
            }
            this.webviewUrl = (this.cbWebView.getUrl() == null || this.cbWebView.getUrl().equalsIgnoreCase("")) ? str : this.cbWebView.getUrl();
            if (CustomBrowserData.SINGLETON != null && CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() != null) {
                if (this.backwardJourneyStarted) {
                    if (this.isTxnNBType) {
                        this.isSnoozeWindowVisible = false;
                    } else {
                        dismissSnoozeWindow();
                    }
                }
                if (str.contains("https://secure.payu.in/_payment_options")) {
                    this.mJS = null;
                    this.drawable = null;
                }
                try {
                    if (!this.cbUtil.getDataFromPostData(this.customBrowserConfig.getPayuPostData(), "surl").equals("")) {
                    }
                    if ((this.cbUtil.getDataFromPostData(this.customBrowserConfig.getPayuPostData(), "furl").equals("") || !str.contains(URLDecoder.decode(this.cbUtil.getDataFromPostData(this.customBrowserConfig.getPayuPostData(), "furl"), "UTF-8"))) && !isRetryURL(str)) {
                        if (this.isSnoozeEnabled && this.customBrowserConfig.getSurePayMode() == 1 && !this.backwardJourneyStarted) {
                            this.snoozeLoadPercentageAndTimeOut = this.snoozeConfigMap.getPercentageAndTimeout(str);
                            this.snoozeUrlLoadingPercentage = this.snoozeLoadPercentageAndTimeOut[0];
                            this.snoozeUrlLoadingTimeout = this.snoozeLoadPercentageAndTimeOut[1];
                            this.surePayDisableStatus = this.cbUtil.getSurePayDisableStatus(this.snoozeConfigMap, str);
                            initializeSnoozeTimer();
                            return;
                        }
                        return;
                    }
                    this.showSnoozeWindow = false;
                    dismissSnoozeWindow();
                    hideCB();
                    if (isRetryURL(str)) {
                        resetAutoSelectOTP();
                        this.backwardJourneyStarted = false;
                    }
                    stopSnoozeCountDownTimer();
                    if (this.snoozeService != null) {
                        this.snoozeService.killSnoozeService();
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void jellyBeanOnReceivedError() {
        setIsPageStoppedForcefully(true);
        if (this.snoozeConfigMap != null && !this.cbOldFlow) {
            stopSnoozeCountDownTimer();
            this.surePayDisableStatus = this.cbUtil.getSurePayDisableStatus(this.snoozeConfigMap, this.webviewUrl);
            launchSnoozeWindow(2);
        }
    }

    public boolean isInBackWardJourney(String str) {
        try {
            if (!this.backwardJourneyStarted) {
                if ((str.contains("https://secure.payu.in") || str.contains("https://mobiletest.payu.in")) && str.contains("_response")) {
                    return true;
                }
                if (this.backwardJourneyUrls != null) {
                    for (String contains : this.backwardJourneyUrls) {
                        if (str.contains(contains)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return this.backwardJourneyStarted;
        } catch (Exception e) {
            e.printStackTrace();
            return this.backwardJourneyStarted;
        }
    }

    public void onLoadResourse(WebView webView, String str) {
        if (this.activity != null && !this.activity.isFinishing() && !isRemoving() && isAdded() && !str.equalsIgnoreCase("https://mwsrec.npci.org.in/MWS/Scripts/MerchantScript_v1.0.js") && !str.contains("https://swasrec2.npci.org.in")) {
            str.contains("https://swasrec.npci.org.in");
        }
    }

    public void onPageFinishWebclient(String str) {
        this.pageStarted = false;
        if (this.activity != null && !this.activity.isFinishing() && !isRemoving() && isAdded()) {
            if (this.isSurePayResumed) {
                addEventAnalytics("snooze_resume_url", str);
                setSurePayResumeStatus(false);
            }
            this.cbUtil.setStringSharedPreferenceLastURL(this.activity.getApplicationContext(), "last_url", "f:".concat(String.valueOf(str)));
            startPayUChromeLoaderDisbaleTimer();
            if (!(!this.firstFinish || getArguments() == null || getArguments().getInt("mainLayout", -1) == -1)) {
                try {
                    final View findViewById = this.activity.findViewById(getArguments().getInt("mainLayout"));
                    findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        /* class com.payu.custombrowser.Bank.AnonymousClass4 */
                        private final int DefaultKeyboardDP = 100;
                        private final int EstimatedKeyboardDP;
                        private final Rect r;

                        {
                            this.EstimatedKeyboardDP = (Build.VERSION.SDK_INT >= 21 ? 48 : 0) + 100;
                            this.r = new Rect();
                        }

                        public void onGlobalLayout() {
                            if (Bank.this.activity != null && !Bank.this.activity.isFinishing() && !Bank.this.isRemoving() && Bank.this.isAdded()) {
                                int applyDimension = (int) TypedValue.applyDimension(1, (float) this.EstimatedKeyboardDP, findViewById.getResources().getDisplayMetrics());
                                findViewById.getWindowVisibleDisplayFrame(this.r);
                                if ((findViewById.getRootView().getHeight() - (this.r.bottom - this.r.top) >= applyDimension) && Bank.this.checkForInput == 0) {
                                    ((InputMethodManager) Bank.this.activity.getSystemService("input_method")).toggleSoftInput(3, 0);
                                    Bank.this.checkForInput = 1;
                                }
                            }
                        }
                    });
                    this.firstFinish = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!this.isPageStoppedForcefully) {
            stopSnoozeCountDownTimer();
        }
        new Handler().postDelayed(new Runnable() {
            /* class com.payu.custombrowser.Bank.AnonymousClass5 */

            public void run() {
                if (!Bank.this.isPageStoppedForcefully && !Bank.this.pageStarted && Bank.this.isSnoozeWindowVisible && !Bank.this.backwardJourneyStarted) {
                    if (Bank.this.isSnoozeWindowVisible) {
                        Bank.this.addEventAnalytics("snooze_window_automatically_disappear_time", "-1");
                    }
                    Bank.this.dismissSnoozeWindow();
                }
            }
        }, 1000);
    }

    @JavascriptInterface
    public void setSnoozeEnabled(boolean z) {
        if (!z) {
            this.customBrowserConfig.setEnableSurePay(0);
        }
        this.cbUtil.setBooleanSharedPreference("snoozeEnabled", z, this.activity.getApplicationContext());
    }

    private void startPayUChromeLoaderDisbaleTimer() {
        CountDownTimer countDownTimer = this.payUChromeLoaderDisableTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.payUChromeLoaderEnableTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        this.payUChromeLoaderDisableTimer = new CountDownTimer(2000, 1000) {
            /* class com.payu.custombrowser.Bank.AnonymousClass6 */

            public void onTick(long j) {
            }

            public void onFinish() {
                Bank.this.dismissPayULoader();
            }
        }.start();
    }

    private void startPayUChromeLoaderEnableTimer() {
        CountDownTimer countDownTimer = this.payUChromeLoaderEnableTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.payUChromeLoaderEnableTimer = new CountDownTimer(1000, 1000) {
            /* class com.payu.custombrowser.Bank.AnonymousClass7 */

            public void onTick(long j) {
            }

            public void onFinish() {
                Bank.this.progressBarVisibilityPayuChrome(0, "");
                Bank.this.forwardJourneyForChromeLoaderIsComplete = true;
            }
        }.start();
    }

    @JavascriptInterface
    public void getUserId() {
        if (this.activity != null && !this.activity.isFinishing()) {
            this.activity.runOnUiThread(new Runnable() {
                /* class com.payu.custombrowser.Bank.AnonymousClass8 */

                public void run() {
                    try {
                        if (Bank.this.cbUtil.getStringSharedPreference(Bank.this.activity.getApplicationContext(), Bank.this.bankName) != null && !Bank.this.cbUtil.getStringSharedPreference(Bank.this.activity.getApplicationContext(), Bank.this.bankName).equals("")) {
                            WebView webView = Bank.this.cbWebView;
                            webView.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_populate_user_id)) + "(\"" + Bank.this.cbUtil.getStringSharedPreference(Bank.this.activity.getApplicationContext(), Bank.this.bankName) + "\")");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void setUserId(String str) {
        if (this.saveUserIDCheck) {
            if (this.activity != null && !this.activity.isFinishing()) {
                this.cbUtil.storeInSharedPreferences(this.activity.getApplicationContext(), this.bankName, str);
            }
        } else if (!this.cbUtil.getStringSharedPreference(this.activity.getApplicationContext(), this.bankName).equals("")) {
            this.cbUtil.removeFromSharedPreferences(this.activity.getApplicationContext(), this.bankName);
        }
    }

    @JavascriptInterface
    public void nativeHelperForNB(final String str, final String str2) {
        if (this.activity != null && !this.activity.isFinishing()) {
            this.activity.runOnUiThread(new Runnable() {
                /* class com.payu.custombrowser.Bank.AnonymousClass9 */

                public void run() {
                    try {
                        if (Bank.this.isSnoozeWindowVisible) {
                            Bank.this.dismissSnoozeWindow();
                            Bank.this.addEventAnalytics("snooze_window_action", "snooze_window_dismissed_by_cb");
                            Bank.this.addEventAnalytics("snooze_window_automatically_disappear_time", "-1");
                        }
                        Bank.this.pageType = "NBLogin Page";
                        Bank.this.addEventAnalytics("arrival", "-1");
                        Bank.this.onHelpAvailable();
                        Bank.this.addEventAnalytics("cb_status", CBAnalyticsConstant.NB_CUSTOM_BROWSER);
                        if (str != null && Bank.this.activity != null) {
                            Bank.this.dismissSnoozeWindow();
                            View inflate = Bank.this.activity.getLayoutInflater().inflate((int) R.layout.nb_layout, (ViewGroup) null);
                            final Button button = (Button) inflate.findViewById(R.id.b_continue);
                            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkbox);
                            JSONObject jSONObject = new JSONObject(str2);
                            String string = Bank.this.getString(R.string.cb_btn_text);
                            if (!jSONObject.has(string) || jSONObject.getString(string) == null || jSONObject.getString(string).equalsIgnoreCase("")) {
                                Bank.this.onHelpUnavailable();
                                Bank.this.cbBaseView.removeAllViews();
                            } else if (str.equals(Bank.this.getString(R.string.cb_button))) {
                                if (!jSONObject.has(Bank.this.getString(R.string.cb_checkbox))) {
                                    checkBox.setVisibility(8);
                                } else if (jSONObject.getBoolean(Bank.this.getString(R.string.cb_checkbox))) {
                                    if (Bank.this.saveUserIDCheck) {
                                        Bank.this.addEventAnalytics(CBAnalyticsConstant.INITIAL_USER_NAME_CHECKBOX_STATUS, "y");
                                        checkBox.setChecked(true);
                                    } else {
                                        Bank.this.addEventAnalytics(CBAnalyticsConstant.INITIAL_USER_NAME_CHECKBOX_STATUS, "n");
                                        checkBox.setChecked(false);
                                    }
                                    checkBox.setOnClickListener(new View.OnClickListener() {
                                        /* class com.payu.custombrowser.Bank.AnonymousClass9.AnonymousClass1 */

                                        public void onClick(View view) {
                                            Bank.this.saveUserIDCheck = checkBox.isChecked();
                                            if (Bank.this.saveUserIDCheck) {
                                                Bank bank = Bank.this;
                                                bank.addEventAnalytics("user_input", CBAnalyticsConstant.USER_NAME_CHECKBOX_STATUS + "y");
                                                return;
                                            }
                                            Bank bank2 = Bank.this;
                                            bank2.addEventAnalytics("user_input", CBAnalyticsConstant.USER_NAME_CHECKBOX_STATUS + "n");
                                        }
                                    });
                                    checkBox.setVisibility(0);
                                } else {
                                    checkBox.setVisibility(8);
                                }
                                button.setText(jSONObject.getString(string));
                                button.setTransformationMethod(null);
                                button.setOnClickListener(new View.OnClickListener() {
                                    /* class com.payu.custombrowser.Bank.AnonymousClass9.AnonymousClass2 */

                                    public void onClick(View view) {
                                        try {
                                            Bank bank = Bank.this;
                                            bank.addEventAnalytics("user_input", CBAnalyticsConstant.NB_BUTTON_CLICK + ((Object) button.getText()));
                                            WebView webView = Bank.this.cbWebView;
                                            webView.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_btn_action)));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                Bank.this.cbBaseView.removeAllViews();
                                Bank.this.cbBaseView.addView(inflate);
                                Bank.this.nbhelpVisible = true;
                            } else if (str.equals(Bank.this.getString(R.string.cb_pwd_btn))) {
                                button.setText(jSONObject.getString(string));
                                if (Bank.this.showToggleCheck) {
                                    checkBox.setChecked(true);
                                } else {
                                    checkBox.setChecked(false);
                                }
                                if (checkBox.isChecked()) {
                                    try {
                                        WebView webView = Bank.this.cbWebView;
                                        webView.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_toggle_field)) + "(\"true\")");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                checkBox.setText(Bank.this.getString(R.string.cb_show_password));
                                checkBox.setVisibility(0);
                                checkBox.setOnClickListener(new View.OnClickListener() {
                                    /* class com.payu.custombrowser.Bank.AnonymousClass9.AnonymousClass3 */

                                    public void onClick(View view) {
                                        Bank.this.showToggleCheck = checkBox.isChecked();
                                        if (checkBox.isChecked()) {
                                            try {
                                                WebView webView = Bank.this.cbWebView;
                                                webView.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_toggle_field)) + "(\"true\")");
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            try {
                                                WebView webView2 = Bank.this.cbWebView;
                                                webView2.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_toggle_field)) + "(\"false\")");
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                });
                                button.setOnClickListener(new View.OnClickListener() {
                                    /* class com.payu.custombrowser.Bank.AnonymousClass9.AnonymousClass4 */

                                    public void onClick(View view) {
                                        try {
                                            WebView webView = Bank.this.cbWebView;
                                            webView.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_btn_action)));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                Bank.this.nbhelpVisible = true;
                                Bank.this.cbBaseView.removeAllViews();
                                Bank.this.cbBaseView.addView(inflate);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
        this.activity.runOnUiThread(new Runnable() {
            /* class com.payu.custombrowser.Bank.AnonymousClass10 */

            public void run() {
                Bank.this.dismissPayULoader();
            }
        });
    }

    @JavascriptInterface
    public void reInit() {
        if (this.activity != null && !this.activity.isFinishing()) {
            this.activity.runOnUiThread(new Runnable() {
                /* class com.payu.custombrowser.Bank.AnonymousClass11 */

                public void run() {
                    Bank.this.onPageFinished();
                }
            });
        }
    }

    @JavascriptInterface
    public void bankFound(final String str) {
        if (!this.visibilitychecked) {
            checkVisibilityCB(str);
            this.visibilitychecked = true;
        }
        cbSetBankDrawable(str);
        CBUtil.setVariableReflection("com.payu.magicretry.MagicRetryFragment", str, "bankName");
        if (this.activity != null && !this.activity.isFinishing()) {
            this.activity.runOnUiThread(new Runnable() {
                /* class com.payu.custombrowser.Bank.AnonymousClass12 */

                public void run() {
                    Bank.this.calculateMaximumWebViewHeight();
                }
            });
        }
        this.bankName = str;
        if (!this.mPageReady) {
            try {
                if (this.loadingLayout != null) {
                    this.activity.runOnUiThread(new Runnable() {
                        /* class com.payu.custombrowser.Bank.AnonymousClass13 */

                        public void run() {
                            Bank.this.customProgressBar.removeProgressDialog(Bank.this.loadingLayout.findViewById(R.id.progress));
                        }
                    });
                }
                if (!this.isPageStoppedForcefully) {
                    if (this.loadingLayout == null) {
                        convertToNative("loading", "{}");
                    } else if (!(this.activity == null || this.loadingLayout == ((ViewGroup) this.activity.findViewById(R.id.help_view)).getChildAt(0))) {
                        convertToNative("loading", "{}");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!this.mLoadingJS && this.mJS == null) {
            this.serialExecutor.execute(new Runnable() {
                /* class com.payu.custombrowser.Bank.AnonymousClass14 */

                public void run() {
                    Bank bank = Bank.this;
                    bank.mLoadingJS = true;
                    try {
                        if (bank.activity != null) {
                            String string = Bank.this.mBankJS.getString(str);
                            if (!new File(Bank.this.activity.getFilesDir(), string).exists()) {
                                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://secure.payu.in/js/sdk_js/v3/" + string + ".js").openConnection();
                                httpURLConnection.setRequestMethod("GET");
                                httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                                if (httpURLConnection.getResponseCode() == 200) {
                                    Bank.this.cbUtil.writeFileOutputStream(httpURLConnection.getInputStream(), Bank.this.activity, string, 0);
                                }
                            }
                        }
                        try {
                            if (Bank.this.activity != null) {
                                String string2 = Bank.this.mBankJS.getString(str);
                                Bank.this.mJS = new JSONObject(CBUtil.decodeContents(Bank.this.activity.openFileInput(string2)));
                                if (Bank.this.mPageReady && Bank.this.activity != null) {
                                    Bank.this.activity.runOnUiThread(new Runnable() {
                                        /* class com.payu.custombrowser.Bank.AnonymousClass14.AnonymousClass1 */

                                        public void run() {
                                            Bank.this.onPageFinished();
                                        }
                                    });
                                }
                                Bank.this.mLoadingJS = false;
                            }
                        } catch (FileNotFoundException | JSONException e) {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        try {
                            if (Bank.this.activity != null) {
                                String string3 = Bank.this.mBankJS.getString(str);
                                Bank.this.mJS = new JSONObject(CBUtil.decodeContents(Bank.this.activity.openFileInput(string3)));
                                if (Bank.this.mPageReady && Bank.this.activity != null) {
                                    Bank.this.activity.runOnUiThread(new Runnable() {
                                        /* class com.payu.custombrowser.Bank.AnonymousClass14.AnonymousClass1 */

                                        public void run() {
                                            Bank.this.onPageFinished();
                                        }
                                    });
                                }
                                Bank.this.mLoadingJS = false;
                            }
                        } catch (FileNotFoundException | JSONException e4) {
                            e4.printStackTrace();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    } catch (Throwable th) {
                        try {
                            if (Bank.this.activity != null) {
                                String string4 = Bank.this.mBankJS.getString(str);
                                Bank.this.mJS = new JSONObject(CBUtil.decodeContents(Bank.this.activity.openFileInput(string4)));
                                if (Bank.this.mPageReady && Bank.this.activity != null) {
                                    Bank.this.activity.runOnUiThread(new Runnable() {
                                        /* class com.payu.custombrowser.Bank.AnonymousClass14.AnonymousClass1 */

                                        public void run() {
                                            Bank.this.onPageFinished();
                                        }
                                    });
                                }
                                Bank.this.mLoadingJS = false;
                            }
                        } catch (FileNotFoundException | JSONException e6) {
                            e6.printStackTrace();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                        throw th;
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void convertToNative(final String str, final String str2) {
        if (this.isSnoozeWindowVisible) {
            dismissSnoozeWindow();
            killSnoozeService();
            cancelTransactionNotification();
            addEventAnalytics("snooze_window_action", "snooze_window_dismissed_by_cb");
            addEventAnalytics("snooze_window_automatically_disappear_time", "-1");
        }
        this.activity.runOnUiThread(new Runnable() {
            /* class com.payu.custombrowser.Bank.AnonymousClass15 */

            public void run() {
                Bank.this.dismissPayULoader();
            }
        });
        if (this.pageType != null && !this.pageType.equalsIgnoreCase("")) {
            addEventAnalytics("departure", "-1");
            this.pageType = "";
        }
        if (this.activity != null && this.showCB) {
            this.activity.runOnUiThread(new Runnable() {
                /* class com.payu.custombrowser.Bank.AnonymousClass16 */

                public void run() {
                    if (Bank.this.loadingLayout != null) {
                        Bank.this.customProgressBar.removeProgressDialog(Bank.this.loadingLayout.findViewById(R.id.progress));
                    }
                    if (Bank.this.enterOTPView != null) {
                        Bank.this.customProgressBar.removeProgressDialog(Bank.this.enterOTPView.findViewById(R.id.progress));
                    }
                    try {
                        if (!(Bank.this.waitingOTPTimer == null || Bank.this.enterOtpRunnable == null)) {
                            Bank.this.cbUtil.cancelTimer(Bank.this.waitingOTPTimer);
                        }
                        if (str.equals(Bank.this.getString(R.string.cb_error))) {
                            Bank.this.onBankError();
                        } else if (str.equals("parse error")) {
                            Bank.this.onBankError();
                        } else if (!str.contentEquals("loading") || Bank.this.pin_selected_flag || !Bank.this.checkLoading) {
                            boolean z = true;
                            if (str.equals(Bank.this.getString(R.string.cb_choose))) {
                                Bank.this.addCustomBrowserEventAnalytics();
                                Bank.this.frameState = 2;
                                Bank.this.checkLoading = true;
                                if (Bank.this.cbTransparentView != null) {
                                    Bank.this.cbTransparentView.setVisibility(0);
                                }
                                View inflate = Bank.this.activity.getLayoutInflater().inflate((int) R.layout.choose_action, (ViewGroup) null);
                                if (Bank.this.maxWebview == 0) {
                                    Bank.this.calculateMaximumWebViewHeight();
                                    Bank.this.maximiseWebviewHeight();
                                }
                                Bank.this.cbBaseView.setVisibility(0);
                                if (Bank.this.cbSlideBarView != null) {
                                    Bank.this.cbSlideBarView.setVisibility(8);
                                }
                                Bank.this.calculateCBHeight(inflate);
                                Bank.this.onHelpAvailable();
                                inflate.measure(-2, -2);
                                Bank.this.chooseActionHeight = inflate.getMeasuredHeight();
                                ImageView imageView = (ImageView) inflate.findViewById(R.id.bank_logo);
                                imageView.setOnClickListener(Bank.this.viewOnClickListener);
                                if (Bank.this.drawable != null) {
                                    imageView.setImageDrawable(Bank.this.drawable);
                                }
                                Bank.this.cbBaseView.removeAllViews();
                                Bank.this.cbBaseView.addView(inflate);
                                if (Bank.this.cbBaseView.isShown()) {
                                    Bank.this.frameState = 2;
                                }
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("Select an option for Faster payment");
                                spannableStringBuilder.setSpan(new StyleSpan(1), 21, 27, 33);
                                ((TextView) inflate.findViewById(R.id.choose_text)).setText(spannableStringBuilder);
                                try {
                                    final JSONObject jSONObject = new JSONObject(str2);
                                    if ((!jSONObject.has(Bank.this.getString(R.string.cb_otp)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_otp))) && (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin)))) {
                                        Bank.this.pageType = "";
                                    } else {
                                        Bank.this.pageType = "Choose Screen";
                                    }
                                    if (!jSONObject.has(Bank.this.getString(R.string.cb_otp)) || jSONObject.getBoolean(Bank.this.getString(R.string.cb_otp))) {
                                        inflate.findViewById(R.id.otp).setOnClickListener(Bank.this.buttonClickListener);
                                        if (Bank.this.autoSelectOtp) {
                                            Bank.this.eventRecorded = "auto_otp_select";
                                            Bank.this.addEventAnalytics("user_input", Bank.this.eventRecorded);
                                            inflate.findViewById(R.id.otp).performClick();
                                            Bank.this.autoSelectOtp = false;
                                        }
                                    } else {
                                        inflate.findViewById(R.id.otp).setVisibility(8);
                                        inflate.findViewById(R.id.view).setVisibility(8);
                                    }
                                    inflate.findViewById(R.id.otp).setOnClickListener(Bank.this.buttonClickListener);
                                    if (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                        inflate.findViewById(R.id.pin).setOnClickListener(new View.OnClickListener() {
                                            /* class com.payu.custombrowser.Bank.AnonymousClass16.AnonymousClass1 */

                                            public void onClick(View view) {
                                                Bank.this.pin_selected_flag = true;
                                                Bank.this.approve_flag = Boolean.TRUE;
                                                Bank.this.maximiseWebviewHeight();
                                                Bank.this.frameState = 1;
                                                if (Bank.this.cbTransparentView != null) {
                                                    Bank.this.cbTransparentView.setVisibility(8);
                                                }
                                                try {
                                                    if (!jSONObject.has(Bank.this.getString(R.string.cb_register)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_register))) {
                                                        Bank.this.eventRecorded = "password_click";
                                                        Bank.this.addEventAnalytics("user_input", Bank.this.eventRecorded);
                                                        Bank.this.onHelpUnavailable();
                                                        WebView webView = Bank.this.cbWebView;
                                                        webView.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_pin)));
                                                        Bank.this.updateHeight(view);
                                                    }
                                                    view = Bank.this.activity.getLayoutInflater().inflate((int) R.layout.register_pin, (ViewGroup) null);
                                                    Bank.this.cbBaseView.removeAllViews();
                                                    Bank.this.cbBaseView.addView(view);
                                                    if (Bank.this.cbBaseView.isShown()) {
                                                        Bank.this.frameState = 2;
                                                    }
                                                    view.findViewById(R.id.pin).setOnClickListener(new View.OnClickListener() {
                                                        /* class com.payu.custombrowser.Bank.AnonymousClass16.AnonymousClass1.AnonymousClass1 */

                                                        public void onClick(View view) {
                                                            try {
                                                                Bank.this.eventRecorded = "password_click";
                                                                Bank.this.addEventAnalytics("user_input", Bank.this.eventRecorded);
                                                                WebView webView = Bank.this.cbWebView;
                                                                webView.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_pin)));
                                                            } catch (JSONException e) {
                                                                e.printStackTrace();
                                                            }
                                                        }
                                                    });
                                                    if (jSONObject.has(Bank.this.getString(R.string.cb_otp)) && !jSONObject.getBoolean(Bank.this.getString(R.string.cb_otp))) {
                                                        view.findViewById(R.id.otp).setVisibility(8);
                                                    }
                                                    view.findViewById(R.id.otp).setOnClickListener(Bank.this.buttonClickListener);
                                                    Bank.this.updateHeight(view);
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        });
                                    } else {
                                        inflate.findViewById(R.id.pin).setVisibility(8);
                                        inflate.findViewById(R.id.view).setVisibility(8);
                                    }
                                    if (jSONObject.has(Bank.this.getString(R.string.cb_error))) {
                                        inflate.findViewById(R.id.error_message).setVisibility(0);
                                        ((TextView) inflate.findViewById(R.id.error_message)).setText(jSONObject.getString("error"));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            } else if (str.equals(Bank.this.getString(R.string.cb_incorrect_OTP_2))) {
                                Bank.this.pageType = "OTP Page";
                                Bank.this.addCustomBrowserEventAnalytics();
                                Bank.this.checkLoading = true;
                                Bank.this.onHelpAvailable();
                                View inflate2 = Bank.this.activity.getLayoutInflater().inflate((int) R.layout.retry_otp, (ViewGroup) null);
                                ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.bank_logo);
                                imageView2.setOnClickListener(Bank.this.viewOnClickListener);
                                if (Bank.this.drawable != null) {
                                    imageView2.setImageDrawable(Bank.this.drawable);
                                }
                                Bank.this.cbBaseView.removeAllViews();
                                Bank.this.cbBaseView.addView(inflate2);
                                if (Bank.this.cbBaseView.isShown()) {
                                    Bank.this.frameState = 2;
                                } else {
                                    if (Bank.this.cbSlideBarView != null) {
                                        Bank.this.cbSlideBarView.setVisibility(0);
                                    }
                                    Bank.this.maximiseWebviewHeight();
                                }
                                if (Bank.this.mPassword == null) {
                                    inflate2.findViewById(R.id.regenerate_layout).setVisibility(0);
                                    inflate2.findViewById(R.id.Regenerate_layout_gone).setVisibility(8);
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(str2);
                                        if (!jSONObject2.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject2.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                            z = false;
                                        }
                                        inflate2.findViewById(R.id.enter_manually).setOnClickListener(Bank.this.buttonClickListener);
                                        if (z) {
                                            inflate2.findViewById(R.id.pin_layout_gone).setVisibility(0);
                                        } else {
                                            inflate2.findViewById(R.id.pin_layout_gone).setVisibility(8);
                                        }
                                        inflate2.findViewById(R.id.pin).setOnClickListener(Bank.this.buttonClickListener);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                Bank.this.updateHeight(inflate2);
                            } else if (str.equals(Bank.this.getString(R.string.cb_retry_otp))) {
                                Bank.this.pageType = "OTP Page";
                                Bank.this.addCustomBrowserEventAnalytics();
                                Bank.this.checkLoading = true;
                                Bank.this.onHelpAvailable();
                                Bank.this.hideSoftKeyboard();
                                if (Bank.this.cbTransparentView != null) {
                                    Bank.this.cbTransparentView.setVisibility(0);
                                }
                                View inflate3 = Bank.this.activity.getLayoutInflater().inflate((int) R.layout.retry_otp, (ViewGroup) null);
                                ImageView imageView3 = (ImageView) inflate3.findViewById(R.id.bank_logo);
                                imageView3.setOnClickListener(Bank.this.viewOnClickListener);
                                if (Bank.this.drawable != null) {
                                    imageView3.setImageDrawable(Bank.this.drawable);
                                }
                                Bank.this.cbBaseView.removeAllViews();
                                Bank.this.cbBaseView.addView(inflate3);
                                if (Bank.this.cbBaseView.isShown()) {
                                    Bank.this.frameState = 2;
                                } else {
                                    if (Bank.this.cbSlideBarView != null) {
                                        Bank.this.cbSlideBarView.setVisibility(0);
                                    }
                                    Bank.this.maximiseWebviewHeight();
                                }
                                try {
                                    if (Bank.this.mPassword == null) {
                                        JSONObject jSONObject3 = new JSONObject(str2);
                                        boolean z2 = jSONObject3.has(Bank.this.getString(R.string.cb_regenerate)) && jSONObject3.getBoolean(Bank.this.getString(R.string.cb_regenerate));
                                        if (!jSONObject3.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject3.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                            z = false;
                                        }
                                        inflate3.findViewById(R.id.regenerate_layout).setVisibility(0);
                                        if (z2) {
                                            inflate3.findViewById(R.id.Regenerate_layout_gone).setVisibility(0);
                                            if (z) {
                                                inflate3.findViewById(R.id.Enter_manually_gone).setVisibility(8);
                                                inflate3.findViewById(R.id.pin_layout_gone).setVisibility(0);
                                            } else {
                                                inflate3.findViewById(R.id.Enter_manually_gone).setVisibility(0);
                                                inflate3.findViewById(R.id.pin_layout_gone).setVisibility(8);
                                            }
                                        } else {
                                            if (z) {
                                                inflate3.findViewById(R.id.pin_layout_gone).setVisibility(0);
                                            } else {
                                                inflate3.findViewById(R.id.pin_layout_gone).setVisibility(8);
                                            }
                                            inflate3.findViewById(R.id.Regenerate_layout_gone).setVisibility(8);
                                            inflate3.findViewById(R.id.Enter_manually_gone).setVisibility(0);
                                        }
                                    }
                                    inflate3.findViewById(R.id.pin).setOnClickListener(Bank.this.buttonClickListener);
                                    inflate3.findViewById(R.id.enter_manually).setOnClickListener(Bank.this.buttonClickListener);
                                    inflate3.findViewById(R.id.retry).setOnClickListener(Bank.this.buttonClickListener);
                                    Bank.this.buttonClickListener.setView(inflate3);
                                    inflate3.findViewById(R.id.approve).setOnClickListener(Bank.this.buttonClickListener);
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                                Bank.this.updateHeight(inflate3);
                            } else if (str.equals(Bank.this.getString(R.string.cb_enter_pin))) {
                                Bank.this.pageType = "PIN Page";
                                Bank.this.addCustomBrowserEventAnalytics();
                                if (Bank.this.cbSlideBarView != null) {
                                    Bank.this.cbSlideBarView.setVisibility(8);
                                }
                                Bank.this.onHelpUnavailable();
                                Bank.this.pin_selected_flag = true;
                                Bank.this.approve_flag = Boolean.TRUE;
                                Bank.this.maximiseWebviewHeight();
                                Bank.this.frameState = 1;
                                if (Bank.this.cbTransparentView != null) {
                                    Bank.this.cbTransparentView.setVisibility(8);
                                }
                                Bank.this.maximiseWebviewHeight();
                                Bank.this.cbBaseView.removeAllViews();
                            } else if (str.equals(Bank.this.getString(R.string.cb_enter_otp))) {
                                Bank.this.pageType = "OTP Page";
                                Bank.this.SMSOTPClicked = false;
                                Bank.this.checkPermission();
                                Bank.this.enterOtpParams = str2;
                                if (!Bank.this.checkPermissionVisibility) {
                                    Bank.this.addCustomBrowserEventAnalytics();
                                    Bank.this.enter_otp(str2);
                                }
                            } else if (str.equals(Bank.this.getString(R.string.cb_incorrect_pin))) {
                                Bank.this.pageType = "Choose Screen";
                                Bank.this.addCustomBrowserEventAnalytics();
                                try {
                                    JSONObject jSONObject4 = new JSONObject(str2);
                                    if (jSONObject4.has(Bank.this.getString(R.string.cb_otp)) && jSONObject4.getBoolean(Bank.this.getString(R.string.cb_otp))) {
                                        Bank.this.checkLoading = true;
                                        Bank.this.onHelpAvailable();
                                        View inflate4 = Bank.this.activity.getLayoutInflater().inflate((int) R.layout.choose_action, (ViewGroup) null);
                                        ImageView imageView4 = (ImageView) inflate4.findViewById(R.id.bank_logo);
                                        imageView4.setOnClickListener(Bank.this.viewOnClickListener);
                                        if (Bank.this.drawable != null) {
                                            imageView4.setImageDrawable(Bank.this.drawable);
                                        }
                                        TextView textView = (TextView) inflate4.findViewById(R.id.error_message);
                                        textView.setVisibility(0);
                                        textView.setText(Bank.this.activity.getResources().getString(R.string.cb_incorrect_password));
                                        TextView textView2 = (TextView) inflate4.findViewById(R.id.choose_text);
                                        textView2.setVisibility(0);
                                        textView2.setText(Bank.this.activity.getResources().getString(R.string.cb_retry));
                                        Bank.this.cbBaseView.removeAllViews();
                                        Bank.this.cbBaseView.addView(inflate4);
                                        inflate4.findViewById(R.id.otp).setOnClickListener(Bank.this.buttonClickListener);
                                        inflate4.findViewById(R.id.pin).setOnClickListener(Bank.this.buttonClickListener);
                                        Bank.this.updateHeight(inflate4);
                                        if (Bank.this.cbBaseView.isShown()) {
                                            Bank.this.frameState = 2;
                                        } else {
                                            Bank.this.maximiseWebviewHeight();
                                        }
                                    }
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            } else if (str.equals(Bank.this.getString(R.string.cb_register_option))) {
                                Bank.this.pageType = "Register Page";
                                Bank.this.addCustomBrowserEventAnalytics();
                                Bank.this.onHelpAvailable();
                                View inflate5 = Bank.this.activity.getLayoutInflater().inflate((int) R.layout.register, (ViewGroup) null);
                                Bank.this.cbBaseView.removeAllViews();
                                Bank.this.cbBaseView.addView(inflate5);
                                ImageView imageView5 = (ImageView) inflate5.findViewById(R.id.bank_logo);
                                imageView5.setOnClickListener(Bank.this.viewOnClickListener);
                                if (Bank.this.drawable != null) {
                                    imageView5.setImageDrawable(Bank.this.drawable);
                                }
                                Bank.this.updateHeight(inflate5);
                                if (Bank.this.cbBaseView.isShown()) {
                                    Bank.this.frameState = 2;
                                } else {
                                    Bank.this.maximiseWebviewHeight();
                                }
                            } else {
                                Bank.this.maximiseWebviewHeight();
                                Bank.this.frameState = 1;
                                if (Bank.this.cbSlideBarView != null) {
                                    Bank.this.cbSlideBarView.setVisibility(8);
                                }
                                Bank.this.onHelpUnavailable();
                            }
                        } else {
                            Bank.this.onHelpAvailable();
                            if (Bank.this.cbTransparentView != null) {
                                Bank.this.cbTransparentView.setVisibility(0);
                            }
                            if (Bank.this.loadingLayout == null) {
                                Bank.this.loadingLayout = Bank.this.activity.getLayoutInflater().inflate((int) R.layout.loading, (ViewGroup) null);
                            }
                            ImageView imageView6 = (ImageView) Bank.this.loadingLayout.findViewById(R.id.bank_logo);
                            imageView6.setOnClickListener(Bank.this.viewOnClickListener);
                            if (Bank.this.drawable != null) {
                                imageView6.setImageDrawable(Bank.this.drawable);
                            }
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, Bank.this.chooseActionHeight);
                            View findViewById = Bank.this.loadingLayout.findViewById(R.id.loading);
                            findViewById.setLayoutParams(layoutParams);
                            findViewById.requestLayout();
                            findViewById.invalidate();
                            Bank.this.customProgressBar.showDialog(Bank.this.loadingLayout.findViewById(R.id.progress));
                            Bank.this.cbBaseView.removeAllViews();
                            Bank.this.cbBaseView.addView(Bank.this.loadingLayout);
                            if (Bank.this.cbBaseView.isShown()) {
                                Bank.this.frameState = 2;
                            } else {
                                Bank.this.maximiseWebviewHeight();
                            }
                            Bank.this.updateHeight(Bank.this.loadingLayout);
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    if (Bank.this.pageType != null && !Bank.this.pageType.equalsIgnoreCase("")) {
                        Bank.this.addEventAnalytics("arrival", "-1");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void addCustomBrowserEventAnalytics() {
        if (!this.eventArray.contains("CUSTOM_BROWSER")) {
            this.eventRecorded = "CUSTOM_BROWSER";
            this.eventArray.add("CUSTOM_BROWSER");
            addEventAnalytics("cb_status", this.eventRecorded);
        }
    }

    public void onPageFinished() {
        if (isAdded() && !isRemoving() && this.activity != null) {
            this.mPageReady = true;
            if (this.approve_flag.booleanValue()) {
                onHelpUnavailable();
                this.approve_flag = Boolean.FALSE;
            }
            if (this.loadingLayout != null && this.loadingLayout.isShown()) {
                this.frameState = 1;
                maximiseWebviewHeight();
                onHelpUnavailable();
            }
            this.activity.getWindow().setSoftInputMode(3);
            if (this.mJS != null && this.showCB && !this.isPageStoppedForcefully) {
                try {
                    WebView webView = this.cbWebView;
                    webView.loadUrl("javascript:" + this.mJS.getString(getString(R.string.cb_init)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (this.mBankJS != null && this.mJS == null && this.cbTransparentView != null) {
                this.cbTransparentView.setVisibility(8);
            }
        }
    }

    public void onPageStarted() {
        if (this.activity != null && !this.activity.isFinishing() && !isRemoving() && isAdded()) {
            if (this.nbhelpVisible) {
                onHelpUnavailable();
                this.nbhelpVisible = false;
            }
            if (isAdded() && !isRemoving()) {
                this.mPageReady = false;
                if (this.mBankJS != null) {
                    try {
                        if (this.showCB) {
                            WebView webView = this.cbWebView;
                            webView.loadUrl("javascript:" + this.mBankJS.getString(getString(R.string.cb_detect_bank)));
                            showMagicRetryCB();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (this.cbTransparentView != null) {
                    this.cbTransparentView.setVisibility(8);
                }
            }
        }
    }

    @JavascriptInterface
    public void onFailure(String str) {
        this.merchantResponse = str;
    }

    @JavascriptInterface
    public void onPayuFailure(String str) {
        if (this.snoozeService != null) {
            this.snoozeService.killSnoozeService();
        }
        if (this.activity != null) {
            this.eventRecorded = "failure_transaction";
            addEventAnalytics("trxn_status", this.eventRecorded);
            this.isSuccessTransaction = Boolean.FALSE;
            this.payuReponse = str;
        }
        cancelTransactionNotification();
        callTimer();
    }

    @JavascriptInterface
    public void onSuccess() {
        onSuccess("");
    }

    @JavascriptInterface
    public void onPayuSuccess(String str) {
        if (this.snoozeService != null) {
            this.snoozeService.killSnoozeService();
        }
        this.isSuccessTransaction = Boolean.TRUE;
        this.eventRecorded = "success_transaction";
        addEventAnalytics("trxn_status", this.eventRecorded);
        this.payuReponse = str;
        if (this.storeOneClickHash == 2) {
            try {
                JSONObject jSONObject = new JSONObject(this.payuReponse);
                this.cbUtil.storeInSharedPreferences(this.activity.getApplicationContext(), jSONObject.getString("card_token"), jSONObject.getString("merchant_hash"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        cancelTransactionNotification();
        callTimer();
    }

    @JavascriptInterface
    public void onSuccess(String str) {
        this.merchantResponse = str;
    }

    @JavascriptInterface
    public void onCancel() {
        onCancel("");
    }

    @JavascriptInterface
    public void onCancel(final String str) {
        this.activity.runOnUiThread(new Runnable() {
            /* class com.payu.custombrowser.Bank.AnonymousClass17 */

            public void run() {
                if (Bank.this.activity != null && !Bank.this.activity.isFinishing() && Bank.this.isAdded()) {
                    Intent intent = new Intent();
                    intent.putExtra(Bank.this.getString(R.string.cb_result), str);
                    Bank.this.activity.setResult(0, intent);
                    Bank.this.activity.finish();
                }
            }
        });
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:51:0x01cc */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r2v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v37, types: [java.lang.String] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01cc A[SYNTHETIC, Splitter:B:51:0x01cc] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0227 A[Catch:{ Exception -> 0x0292 }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public void enter_otp(String str) {
        View view;
        EditText editText;
        boolean z;
        View view2;
        boolean z2;
        int i;
        if (!this.webpageNotFoundError) {
            prepareSmsListener();
            if (this.eventRecorded.equals("payment_initiated")) {
                this.eventRecorded = "CUSTOM_BROWSER";
                this.eventArray.add("CUSTOM_BROWSER");
                addEventAnalytics("cb_status", this.eventRecorded);
            }
            if (this.enterOTPView != null) {
                this.customProgressBar.removeProgressDialog(this.enterOTPView.findViewById(R.id.progress));
            }
            this.checkLoading = true;
            onHelpAvailable();
            if (this.cbTransparentView != null) {
                this.cbTransparentView.setVisibility(0);
            }
            if (this.enterOTPView == null) {
                this.enterOTPView = this.activity.getLayoutInflater().inflate((int) R.layout.wait_for_otp, (ViewGroup) null);
            }
            Button button = (Button) this.enterOTPView.findViewById(R.id.approve);
            final View findViewById = this.enterOTPView.findViewById(R.id.Regenerate_layout_gone);
            final View findViewById2 = this.enterOTPView.findViewById(R.id.Enter_manually_gone);
            final View findViewById3 = this.enterOTPView.findViewById(R.id.pin_layout_gone);
            View findViewById4 = this.enterOTPView.findViewById(R.id.regenerate_layout);
            TextView textView = (TextView) this.enterOTPView.findViewById(R.id.timer);
            final EditText editText2 = (EditText) this.enterOTPView.findViewById(R.id.otp_sms);
            View findViewById5 = this.enterOTPView.findViewById(R.id.waiting);
            View findViewById6 = this.enterOTPView.findViewById(R.id.pin);
            View findViewById7 = this.enterOTPView.findViewById(R.id.retry);
            View findViewById8 = this.enterOTPView.findViewById(R.id.enter_manually);
            Object obj = "CUSTOM_BROWSER";
            View findViewById9 = this.enterOTPView.findViewById(R.id.retry_text);
            Object obj2 = "payment_initiated";
            View findViewById10 = this.enterOTPView.findViewById(R.id.progress);
            ImageView imageView = (ImageView) this.enterOTPView.findViewById(R.id.bank_logo);
            View findViewById11 = this.enterOTPView.findViewById(R.id.otp_recieved);
            button.setVisibility(0);
            CBUtil.setAlpha(0.3f, button);
            Button button2 = button;
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(8);
            findViewById4.setVisibility(8);
            textView.setVisibility(0);
            editText2.setVisibility(8);
            findViewById5.setVisibility(0);
            findViewById6.setVisibility(0);
            findViewById7.setVisibility(0);
            findViewById8.setVisibility(0);
            findViewById9.setVisibility(8);
            findViewById10.setVisibility(0);
            findViewById11.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
            }
            final Button button3 = button2;
            editText2.addTextChangedListener(new TextWatcher() {
                /* class com.payu.custombrowser.Bank.AnonymousClass18 */

                public void afterTextChanged(Editable editable) {
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (editText2.getText().toString().length() > 5) {
                        Bank.this.buttonClickListener.setView(Bank.this.enterOTPView);
                        button3.setOnClickListener(Bank.this.buttonClickListener);
                        button3.setClickable(true);
                        CBUtil.setAlpha(1.0f, button3);
                        return;
                    }
                    button3.setClickable(false);
                    CBUtil.setAlpha(1.0f, button3);
                    button3.setOnClickListener(null);
                }
            });
            this.customProgressBar.showDialog(findViewById10);
            this.cbBaseView.removeAllViews();
            View view3 = findViewById11;
            this.cbBaseView.addView(this.enterOTPView);
            if (this.cbBaseView.isShown()) {
                this.frameState = 2;
            } else {
                maximiseWebviewHeight();
            }
            TextView textView2 = textView;
            if (this.frameState == 1 && this.cbSlideBarView != null) {
                this.cbSlideBarView.setVisibility(0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean z3 = jSONObject.has(getString(R.string.cb_regenerate)) && jSONObject.getBoolean(getString(R.string.cb_regenerate));
                View view4 = findViewById10;
                try {
                    z = jSONObject.has(getString(R.string.cb_skip_screen)) && jSONObject.getBoolean(getString(R.string.cb_skip_screen));
                    view2 = findViewById8;
                } catch (Exception e) {
                    e = e;
                    view = view4;
                    e.printStackTrace();
                    View view5 = view3;
                    EditText editText3 = editText2;
                    final int i2 = (Build.VERSION.SDK_INT >= 23 || this.permissionGranted) ? 30 : 45;
                    AnonymousClass21 r0 = r1;
                    final TextView textView3 = textView2;
                    View view6 = findViewById5;
                    final String str2 = str;
                    View view7 = findViewById4;
                    final View view8 = findViewById9;
                    Button button4 = button3;
                    final View view9 = view7;
                    View view10 = findViewById7;
                    final Button button5 = button4;
                    View view11 = findViewById6;
                    final View view12 = view6;
                    View view13 = findViewById9;
                    Object obj3 = obj;
                    final EditText editText4 = editText3;
                    View view14 = view;
                    Object obj4 = obj2;
                    final View view15 = view11;
                    final View view16 = view10;
                    final View view17 = findViewById8;
                    AnonymousClass21 r1 = new Runnable() {
                        /* class com.payu.custombrowser.Bank.AnonymousClass21 */
                        int i = i2;

                        public void run() {
                            String str;
                            boolean z = true;
                            if (this.i == 0) {
                                try {
                                    if (Bank.this.activity != null && Bank.this.enterOTPView.isShown() && Bank.this.activity.findViewById(R.id.otp_sms) != null) {
                                        textView3.setVisibility(8);
                                        JSONObject jSONObject = new JSONObject(str2);
                                        boolean z2 = jSONObject.has(Bank.this.getString(R.string.cb_regenerate)) && jSONObject.getBoolean(Bank.this.getString(R.string.cb_regenerate));
                                        if (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                            z = false;
                                        }
                                        if (z2) {
                                            findViewById.setVisibility(0);
                                            findViewById3.setVisibility(8);
                                            findViewById2.setVisibility(0);
                                        } else {
                                            if (z) {
                                                findViewById3.setVisibility(0);
                                            } else {
                                                findViewById3.setVisibility(8);
                                            }
                                            findViewById.setVisibility(8);
                                            findViewById2.setVisibility(0);
                                        }
                                        view8.setVisibility(0);
                                        view9.setVisibility(0);
                                        button5.setVisibility(8);
                                        view12.setVisibility(8);
                                        editText4.setVisibility(8);
                                        view15.setOnClickListener(Bank.this.buttonClickListener);
                                        view16.setOnClickListener(Bank.this.buttonClickListener);
                                        view17.setOnClickListener(Bank.this.buttonClickListener);
                                        Bank.this.updateHeight(Bank.this.enterOTPView);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else if (!editText4.hasFocus() && editText4.getText().toString().matches("")) {
                                if (this.i == i2) {
                                    textView3.setVisibility(0);
                                }
                                if (Build.VERSION.SDK_INT < 23 || Bank.this.permissionGranted) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(this.i);
                                    str = sb.toString();
                                } else if (this.i != 1) {
                                    str = this.i + "  secs remaining to regenerate OTP\n";
                                } else {
                                    str = this.i + " sec remaining to regenerate OTP\n";
                                }
                                textView3.setText(str);
                                this.i--;
                            }
                        }
                    };
                    this.enterOtpRunnable = r0;
                    this.cbUtil.cancelTimer(this.waitingOTPTimer);
                    this.activity.findViewById(R.id.timer).setVisibility(8);
                    this.eventRecorded = "received_otp_direct";
                    addEventAnalytics("otp_received", this.eventRecorded);
                    editText.setText(this.mPassword);
                    Button button6 = button4;
                    button6.setText(getString(R.string.cb_approve_otp));
                    button6.setClickable(true);
                    if (this.autoApprove) {
                    }
                    CBUtil.setAlpha(1.0f, button6);
                    view5.setVisibility(0);
                    this.customProgressBar.removeDialog(view14);
                    view13.setVisibility(8);
                    view7.setVisibility(8);
                    button6.setVisibility(0);
                    view6.setVisibility(8);
                    editText.setVisibility(0);
                    this.buttonClickListener.setView(this.enterOTPView);
                    button6.setOnClickListener(this.buttonClickListener);
                    updateHeight(this.enterOTPView);
                    if (this.cbBaseView.isShown()) {
                    }
                }
                try {
                    ? has = jSONObject.has(getString(R.string.cb_pin));
                    View view18 = has;
                    if (has != 0) {
                        ? string = getString(R.string.cb_pin);
                        boolean z4 = jSONObject.getBoolean(string);
                        view18 = string;
                        if (z4) {
                            z2 = true;
                            findViewById8 = string;
                            if (!z) {
                                try {
                                    if (this.activity == null || editText2 == null || editText2.getVisibility() == 0) {
                                        findViewById8 = view2;
                                    } else {
                                        findViewById9.setVisibility(0);
                                        if (z3) {
                                            findViewById.setVisibility(0);
                                            findViewById3.setVisibility(8);
                                            findViewById2.setVisibility(0);
                                            i = 8;
                                        } else {
                                            if (z2) {
                                                findViewById3.setVisibility(0);
                                                i = 8;
                                            } else {
                                                i = 8;
                                                findViewById3.setVisibility(8);
                                            }
                                            findViewById.setVisibility(i);
                                            findViewById2.setVisibility(0);
                                        }
                                        findViewById4.setVisibility(0);
                                        button3.setVisibility(i);
                                        findViewById5.setVisibility(i);
                                        findViewById6.setOnClickListener(this.buttonClickListener);
                                        findViewById7.setOnClickListener(this.buttonClickListener);
                                        findViewById8 = view2;
                                        findViewById8.setOnClickListener(this.buttonClickListener);
                                        updateHeight(this.enterOTPView);
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    findViewById8 = view2;
                                    view = view4;
                                    e.printStackTrace();
                                    View view52 = view3;
                                    EditText editText32 = editText2;
                                    final int i22 = (Build.VERSION.SDK_INT >= 23 || this.permissionGranted) ? 30 : 45;
                                    AnonymousClass21 r02 = r1;
                                    final TextView textView32 = textView2;
                                    View view62 = findViewById5;
                                    final String str22 = str;
                                    View view72 = findViewById4;
                                    final View view82 = findViewById9;
                                    Button button42 = button3;
                                    final View view92 = view72;
                                    View view102 = findViewById7;
                                    final Button button52 = button42;
                                    View view112 = findViewById6;
                                    final View view122 = view62;
                                    View view132 = findViewById9;
                                    Object obj32 = obj;
                                    final EditText editText42 = editText32;
                                    View view142 = view;
                                    Object obj42 = obj2;
                                    final View view152 = view112;
                                    final View view162 = view102;
                                    final View view172 = findViewById8;
                                    AnonymousClass21 r12 = new Runnable() {
                                        /* class com.payu.custombrowser.Bank.AnonymousClass21 */
                                        int i = i22;

                                        public void run() {
                                            String str;
                                            boolean z = true;
                                            if (this.i == 0) {
                                                try {
                                                    if (Bank.this.activity != null && Bank.this.enterOTPView.isShown() && Bank.this.activity.findViewById(R.id.otp_sms) != null) {
                                                        textView32.setVisibility(8);
                                                        JSONObject jSONObject = new JSONObject(str22);
                                                        boolean z2 = jSONObject.has(Bank.this.getString(R.string.cb_regenerate)) && jSONObject.getBoolean(Bank.this.getString(R.string.cb_regenerate));
                                                        if (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                                            z = false;
                                                        }
                                                        if (z2) {
                                                            findViewById.setVisibility(0);
                                                            findViewById3.setVisibility(8);
                                                            findViewById2.setVisibility(0);
                                                        } else {
                                                            if (z) {
                                                                findViewById3.setVisibility(0);
                                                            } else {
                                                                findViewById3.setVisibility(8);
                                                            }
                                                            findViewById.setVisibility(8);
                                                            findViewById2.setVisibility(0);
                                                        }
                                                        view82.setVisibility(0);
                                                        view92.setVisibility(0);
                                                        button52.setVisibility(8);
                                                        view122.setVisibility(8);
                                                        editText42.setVisibility(8);
                                                        view152.setOnClickListener(Bank.this.buttonClickListener);
                                                        view162.setOnClickListener(Bank.this.buttonClickListener);
                                                        view172.setOnClickListener(Bank.this.buttonClickListener);
                                                        Bank.this.updateHeight(Bank.this.enterOTPView);
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            } else if (!editText42.hasFocus() && editText42.getText().toString().matches("")) {
                                                if (this.i == i22) {
                                                    textView32.setVisibility(0);
                                                }
                                                if (Build.VERSION.SDK_INT < 23 || Bank.this.permissionGranted) {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(this.i);
                                                    str = sb.toString();
                                                } else if (this.i != 1) {
                                                    str = this.i + "  secs remaining to regenerate OTP\n";
                                                } else {
                                                    str = this.i + " sec remaining to regenerate OTP\n";
                                                }
                                                textView32.setText(str);
                                                this.i--;
                                            }
                                        }
                                    };
                                    this.enterOtpRunnable = r02;
                                    this.cbUtil.cancelTimer(this.waitingOTPTimer);
                                    this.activity.findViewById(R.id.timer).setVisibility(8);
                                    this.eventRecorded = "received_otp_direct";
                                    addEventAnalytics("otp_received", this.eventRecorded);
                                    editText.setText(this.mPassword);
                                    Button button62 = button42;
                                    button62.setText(getString(R.string.cb_approve_otp));
                                    button62.setClickable(true);
                                    if (this.autoApprove) {
                                    }
                                    CBUtil.setAlpha(1.0f, button62);
                                    view52.setVisibility(0);
                                    this.customProgressBar.removeDialog(view142);
                                    view132.setVisibility(8);
                                    view72.setVisibility(8);
                                    button62.setVisibility(0);
                                    view62.setVisibility(8);
                                    editText.setVisibility(0);
                                    this.buttonClickListener.setView(this.enterOTPView);
                                    button62.setOnClickListener(this.buttonClickListener);
                                    updateHeight(this.enterOTPView);
                                    if (this.cbBaseView.isShown()) {
                                    }
                                }
                            } else {
                                findViewById8 = view2;
                                this.waitingOTPTimer = new Timer();
                                this.waitingOTPTimer.scheduleAtFixedRate(new TimerTask() {
                                    /* class com.payu.custombrowser.Bank.AnonymousClass19 */

                                    public synchronized void run() {
                                        if (Bank.this.activity != null) {
                                            Bank.this.activity.runOnUiThread(Bank.this.enterOtpRunnable);
                                        }
                                    }
                                }, 0, 1000);
                            }
                            if (Build.VERSION.SDK_INT >= 23 || this.permissionGranted) {
                                view = view4;
                                View view522 = view3;
                                EditText editText322 = editText2;
                                final int i222 = (Build.VERSION.SDK_INT >= 23 || this.permissionGranted) ? 30 : 45;
                                AnonymousClass21 r022 = r12;
                                final TextView textView322 = textView2;
                                View view622 = findViewById5;
                                final String str222 = str;
                                View view722 = findViewById4;
                                final View view822 = findViewById9;
                                Button button422 = button3;
                                final View view922 = view722;
                                View view1022 = findViewById7;
                                final Button button522 = button422;
                                View view1122 = findViewById6;
                                final View view1222 = view622;
                                View view1322 = findViewById9;
                                Object obj322 = obj;
                                final EditText editText422 = editText322;
                                View view1422 = view;
                                Object obj422 = obj2;
                                final View view1522 = view1122;
                                final View view1622 = view1022;
                                final View view1722 = findViewById8;
                                AnonymousClass21 r122 = new Runnable() {
                                    /* class com.payu.custombrowser.Bank.AnonymousClass21 */
                                    int i = i222;

                                    public void run() {
                                        String str;
                                        boolean z = true;
                                        if (this.i == 0) {
                                            try {
                                                if (Bank.this.activity != null && Bank.this.enterOTPView.isShown() && Bank.this.activity.findViewById(R.id.otp_sms) != null) {
                                                    textView322.setVisibility(8);
                                                    JSONObject jSONObject = new JSONObject(str222);
                                                    boolean z2 = jSONObject.has(Bank.this.getString(R.string.cb_regenerate)) && jSONObject.getBoolean(Bank.this.getString(R.string.cb_regenerate));
                                                    if (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                                        z = false;
                                                    }
                                                    if (z2) {
                                                        findViewById.setVisibility(0);
                                                        findViewById3.setVisibility(8);
                                                        findViewById2.setVisibility(0);
                                                    } else {
                                                        if (z) {
                                                            findViewById3.setVisibility(0);
                                                        } else {
                                                            findViewById3.setVisibility(8);
                                                        }
                                                        findViewById.setVisibility(8);
                                                        findViewById2.setVisibility(0);
                                                    }
                                                    view822.setVisibility(0);
                                                    view922.setVisibility(0);
                                                    button522.setVisibility(8);
                                                    view1222.setVisibility(8);
                                                    editText422.setVisibility(8);
                                                    view1522.setOnClickListener(Bank.this.buttonClickListener);
                                                    view1622.setOnClickListener(Bank.this.buttonClickListener);
                                                    view1722.setOnClickListener(Bank.this.buttonClickListener);
                                                    Bank.this.updateHeight(Bank.this.enterOTPView);
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        } else if (!editText422.hasFocus() && editText422.getText().toString().matches("")) {
                                            if (this.i == i222) {
                                                textView322.setVisibility(0);
                                            }
                                            if (Build.VERSION.SDK_INT < 23 || Bank.this.permissionGranted) {
                                                StringBuilder sb = new StringBuilder();
                                                sb.append(this.i);
                                                str = sb.toString();
                                            } else if (this.i != 1) {
                                                str = this.i + "  secs remaining to regenerate OTP\n";
                                            } else {
                                                str = this.i + " sec remaining to regenerate OTP\n";
                                            }
                                            textView322.setText(str);
                                            this.i--;
                                        }
                                    }
                                };
                                this.enterOtpRunnable = r022;
                                if (!(this.mPassword == null || (editText = editText322) == null || editText.getVisibility() == 0)) {
                                    this.cbUtil.cancelTimer(this.waitingOTPTimer);
                                    this.activity.findViewById(R.id.timer).setVisibility(8);
                                    if (this.eventRecorded.equals(obj422) || this.eventRecorded.equals(obj322)) {
                                        this.eventRecorded = "received_otp_direct";
                                        addEventAnalytics("otp_received", this.eventRecorded);
                                    }
                                    editText.setText(this.mPassword);
                                    Button button622 = button422;
                                    button622.setText(getString(R.string.cb_approve_otp));
                                    button622.setClickable(true);
                                    if (this.autoApprove) {
                                        button622.performClick();
                                        this.eventRecorded = "auto_approve";
                                        addEventAnalytics("user_input", this.eventRecorded);
                                    }
                                    CBUtil.setAlpha(1.0f, button622);
                                    view522.setVisibility(0);
                                    this.customProgressBar.removeDialog(view1422);
                                    view1322.setVisibility(8);
                                    view722.setVisibility(8);
                                    button622.setVisibility(0);
                                    view622.setVisibility(8);
                                    editText.setVisibility(0);
                                    this.buttonClickListener.setView(this.enterOTPView);
                                    button622.setOnClickListener(this.buttonClickListener);
                                }
                                updateHeight(this.enterOTPView);
                                if (this.cbBaseView.isShown()) {
                                    this.frameState = 2;
                                    return;
                                } else {
                                    maximiseWebviewHeight();
                                    return;
                                }
                            } else {
                                try {
                                    button3.setClickable(false);
                                    this.enterOTPView.findViewById(R.id.linear_layout_waiting_for_otp);
                                    showSoftKeyboard(editText2);
                                    editText2.setVisibility(0);
                                    button3.setVisibility(0);
                                } catch (Exception e3) {
                                    e = e3;
                                    view = view4;
                                    e.printStackTrace();
                                    View view5222 = view3;
                                    EditText editText3222 = editText2;
                                    final int i2222 = (Build.VERSION.SDK_INT >= 23 || this.permissionGranted) ? 30 : 45;
                                    AnonymousClass21 r0222 = r122;
                                    final TextView textView3222 = textView2;
                                    View view6222 = findViewById5;
                                    final String str2222 = str;
                                    View view7222 = findViewById4;
                                    final View view8222 = findViewById9;
                                    Button button4222 = button3;
                                    final View view9222 = view7222;
                                    View view10222 = findViewById7;
                                    final Button button5222 = button4222;
                                    View view11222 = findViewById6;
                                    final View view12222 = view6222;
                                    View view13222 = findViewById9;
                                    Object obj3222 = obj;
                                    final EditText editText4222 = editText3222;
                                    View view14222 = view;
                                    Object obj4222 = obj2;
                                    final View view15222 = view11222;
                                    final View view16222 = view10222;
                                    final View view17222 = findViewById8;
                                    AnonymousClass21 r1222 = new Runnable() {
                                        /* class com.payu.custombrowser.Bank.AnonymousClass21 */
                                        int i = i2222;

                                        public void run() {
                                            String str;
                                            boolean z = true;
                                            if (this.i == 0) {
                                                try {
                                                    if (Bank.this.activity != null && Bank.this.enterOTPView.isShown() && Bank.this.activity.findViewById(R.id.otp_sms) != null) {
                                                        textView3222.setVisibility(8);
                                                        JSONObject jSONObject = new JSONObject(str2222);
                                                        boolean z2 = jSONObject.has(Bank.this.getString(R.string.cb_regenerate)) && jSONObject.getBoolean(Bank.this.getString(R.string.cb_regenerate));
                                                        if (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                                            z = false;
                                                        }
                                                        if (z2) {
                                                            findViewById.setVisibility(0);
                                                            findViewById3.setVisibility(8);
                                                            findViewById2.setVisibility(0);
                                                        } else {
                                                            if (z) {
                                                                findViewById3.setVisibility(0);
                                                            } else {
                                                                findViewById3.setVisibility(8);
                                                            }
                                                            findViewById.setVisibility(8);
                                                            findViewById2.setVisibility(0);
                                                        }
                                                        view8222.setVisibility(0);
                                                        view9222.setVisibility(0);
                                                        button5222.setVisibility(8);
                                                        view12222.setVisibility(8);
                                                        editText4222.setVisibility(8);
                                                        view15222.setOnClickListener(Bank.this.buttonClickListener);
                                                        view16222.setOnClickListener(Bank.this.buttonClickListener);
                                                        view17222.setOnClickListener(Bank.this.buttonClickListener);
                                                        Bank.this.updateHeight(Bank.this.enterOTPView);
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            } else if (!editText4222.hasFocus() && editText4222.getText().toString().matches("")) {
                                                if (this.i == i2222) {
                                                    textView3222.setVisibility(0);
                                                }
                                                if (Build.VERSION.SDK_INT < 23 || Bank.this.permissionGranted) {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(this.i);
                                                    str = sb.toString();
                                                } else if (this.i != 1) {
                                                    str = this.i + "  secs remaining to regenerate OTP\n";
                                                } else {
                                                    str = this.i + " sec remaining to regenerate OTP\n";
                                                }
                                                textView3222.setText(str);
                                                this.i--;
                                            }
                                        }
                                    };
                                    this.enterOtpRunnable = r0222;
                                    this.cbUtil.cancelTimer(this.waitingOTPTimer);
                                    this.activity.findViewById(R.id.timer).setVisibility(8);
                                    this.eventRecorded = "received_otp_direct";
                                    addEventAnalytics("otp_received", this.eventRecorded);
                                    editText.setText(this.mPassword);
                                    Button button6222 = button4222;
                                    button6222.setText(getString(R.string.cb_approve_otp));
                                    button6222.setClickable(true);
                                    if (this.autoApprove) {
                                    }
                                    CBUtil.setAlpha(1.0f, button6222);
                                    view5222.setVisibility(0);
                                    this.customProgressBar.removeDialog(view14222);
                                    view13222.setVisibility(8);
                                    view7222.setVisibility(8);
                                    button6222.setVisibility(0);
                                    view6222.setVisibility(8);
                                    editText.setVisibility(0);
                                    this.buttonClickListener.setView(this.enterOTPView);
                                    button6222.setOnClickListener(this.buttonClickListener);
                                    updateHeight(this.enterOTPView);
                                    if (this.cbBaseView.isShown()) {
                                    }
                                }
                                try {
                                    findViewById5.setVisibility(8);
                                    view = view4;
                                    try {
                                        view.setVisibility(8);
                                        findViewById4.setVisibility(0);
                                        findViewById2.setVisibility(8);
                                        editText2.addTextChangedListener(new TextWatcher() {
                                            /* class com.payu.custombrowser.Bank.AnonymousClass20 */

                                            public void afterTextChanged(Editable editable) {
                                            }

                                            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                            }

                                            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                                if (editText2.getText().toString().length() > 5) {
                                                    Bank.this.buttonClickListener.setView(Bank.this.enterOTPView);
                                                    button3.setOnClickListener(Bank.this.buttonClickListener);
                                                    button3.setClickable(true);
                                                    CBUtil.setAlpha(1.0f, button3);
                                                    return;
                                                }
                                                button3.setClickable(false);
                                                CBUtil.setAlpha(0.3f, button3);
                                                button3.setOnClickListener(null);
                                            }
                                        });
                                    } catch (Exception e4) {
                                        e = e4;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    view = view4;
                                    e.printStackTrace();
                                    View view52222 = view3;
                                    EditText editText32222 = editText2;
                                    final int i22222 = (Build.VERSION.SDK_INT >= 23 || this.permissionGranted) ? 30 : 45;
                                    AnonymousClass21 r02222 = r1222;
                                    final TextView textView32222 = textView2;
                                    View view62222 = findViewById5;
                                    final String str22222 = str;
                                    View view72222 = findViewById4;
                                    final View view82222 = findViewById9;
                                    Button button42222 = button3;
                                    final View view92222 = view72222;
                                    View view102222 = findViewById7;
                                    final Button button52222 = button42222;
                                    View view112222 = findViewById6;
                                    final View view122222 = view62222;
                                    View view132222 = findViewById9;
                                    Object obj32222 = obj;
                                    final EditText editText42222 = editText32222;
                                    View view142222 = view;
                                    Object obj42222 = obj2;
                                    final View view152222 = view112222;
                                    final View view162222 = view102222;
                                    final View view172222 = findViewById8;
                                    AnonymousClass21 r12222 = new Runnable() {
                                        /* class com.payu.custombrowser.Bank.AnonymousClass21 */
                                        int i = i22222;

                                        public void run() {
                                            String str;
                                            boolean z = true;
                                            if (this.i == 0) {
                                                try {
                                                    if (Bank.this.activity != null && Bank.this.enterOTPView.isShown() && Bank.this.activity.findViewById(R.id.otp_sms) != null) {
                                                        textView32222.setVisibility(8);
                                                        JSONObject jSONObject = new JSONObject(str22222);
                                                        boolean z2 = jSONObject.has(Bank.this.getString(R.string.cb_regenerate)) && jSONObject.getBoolean(Bank.this.getString(R.string.cb_regenerate));
                                                        if (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                                            z = false;
                                                        }
                                                        if (z2) {
                                                            findViewById.setVisibility(0);
                                                            findViewById3.setVisibility(8);
                                                            findViewById2.setVisibility(0);
                                                        } else {
                                                            if (z) {
                                                                findViewById3.setVisibility(0);
                                                            } else {
                                                                findViewById3.setVisibility(8);
                                                            }
                                                            findViewById.setVisibility(8);
                                                            findViewById2.setVisibility(0);
                                                        }
                                                        view82222.setVisibility(0);
                                                        view92222.setVisibility(0);
                                                        button52222.setVisibility(8);
                                                        view122222.setVisibility(8);
                                                        editText42222.setVisibility(8);
                                                        view152222.setOnClickListener(Bank.this.buttonClickListener);
                                                        view162222.setOnClickListener(Bank.this.buttonClickListener);
                                                        view172222.setOnClickListener(Bank.this.buttonClickListener);
                                                        Bank.this.updateHeight(Bank.this.enterOTPView);
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            } else if (!editText42222.hasFocus() && editText42222.getText().toString().matches("")) {
                                                if (this.i == i22222) {
                                                    textView32222.setVisibility(0);
                                                }
                                                if (Build.VERSION.SDK_INT < 23 || Bank.this.permissionGranted) {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(this.i);
                                                    str = sb.toString();
                                                } else if (this.i != 1) {
                                                    str = this.i + "  secs remaining to regenerate OTP\n";
                                                } else {
                                                    str = this.i + " sec remaining to regenerate OTP\n";
                                                }
                                                textView32222.setText(str);
                                                this.i--;
                                            }
                                        }
                                    };
                                    this.enterOtpRunnable = r02222;
                                    this.cbUtil.cancelTimer(this.waitingOTPTimer);
                                    this.activity.findViewById(R.id.timer).setVisibility(8);
                                    this.eventRecorded = "received_otp_direct";
                                    addEventAnalytics("otp_received", this.eventRecorded);
                                    editText.setText(this.mPassword);
                                    Button button62222 = button42222;
                                    button62222.setText(getString(R.string.cb_approve_otp));
                                    button62222.setClickable(true);
                                    if (this.autoApprove) {
                                    }
                                    CBUtil.setAlpha(1.0f, button62222);
                                    view52222.setVisibility(0);
                                    this.customProgressBar.removeDialog(view142222);
                                    view132222.setVisibility(8);
                                    view72222.setVisibility(8);
                                    button62222.setVisibility(0);
                                    view62222.setVisibility(8);
                                    editText.setVisibility(0);
                                    this.buttonClickListener.setView(this.enterOTPView);
                                    button62222.setOnClickListener(this.buttonClickListener);
                                    updateHeight(this.enterOTPView);
                                    if (this.cbBaseView.isShown()) {
                                    }
                                }
                                View view522222 = view3;
                                EditText editText322222 = editText2;
                                final int i222222 = (Build.VERSION.SDK_INT >= 23 || this.permissionGranted) ? 30 : 45;
                                AnonymousClass21 r022222 = r12222;
                                final TextView textView322222 = textView2;
                                View view622222 = findViewById5;
                                final String str222222 = str;
                                View view722222 = findViewById4;
                                final View view822222 = findViewById9;
                                Button button422222 = button3;
                                final View view922222 = view722222;
                                View view1022222 = findViewById7;
                                final Button button522222 = button422222;
                                View view1122222 = findViewById6;
                                final View view1222222 = view622222;
                                View view1322222 = findViewById9;
                                Object obj322222 = obj;
                                final EditText editText422222 = editText322222;
                                View view1422222 = view;
                                Object obj422222 = obj2;
                                final View view1522222 = view1122222;
                                final View view1622222 = view1022222;
                                final View view1722222 = findViewById8;
                                AnonymousClass21 r122222 = new Runnable() {
                                    /* class com.payu.custombrowser.Bank.AnonymousClass21 */
                                    int i = i222222;

                                    public void run() {
                                        String str;
                                        boolean z = true;
                                        if (this.i == 0) {
                                            try {
                                                if (Bank.this.activity != null && Bank.this.enterOTPView.isShown() && Bank.this.activity.findViewById(R.id.otp_sms) != null) {
                                                    textView322222.setVisibility(8);
                                                    JSONObject jSONObject = new JSONObject(str222222);
                                                    boolean z2 = jSONObject.has(Bank.this.getString(R.string.cb_regenerate)) && jSONObject.getBoolean(Bank.this.getString(R.string.cb_regenerate));
                                                    if (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                                        z = false;
                                                    }
                                                    if (z2) {
                                                        findViewById.setVisibility(0);
                                                        findViewById3.setVisibility(8);
                                                        findViewById2.setVisibility(0);
                                                    } else {
                                                        if (z) {
                                                            findViewById3.setVisibility(0);
                                                        } else {
                                                            findViewById3.setVisibility(8);
                                                        }
                                                        findViewById.setVisibility(8);
                                                        findViewById2.setVisibility(0);
                                                    }
                                                    view822222.setVisibility(0);
                                                    view922222.setVisibility(0);
                                                    button522222.setVisibility(8);
                                                    view1222222.setVisibility(8);
                                                    editText422222.setVisibility(8);
                                                    view1522222.setOnClickListener(Bank.this.buttonClickListener);
                                                    view1622222.setOnClickListener(Bank.this.buttonClickListener);
                                                    view1722222.setOnClickListener(Bank.this.buttonClickListener);
                                                    Bank.this.updateHeight(Bank.this.enterOTPView);
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        } else if (!editText422222.hasFocus() && editText422222.getText().toString().matches("")) {
                                            if (this.i == i222222) {
                                                textView322222.setVisibility(0);
                                            }
                                            if (Build.VERSION.SDK_INT < 23 || Bank.this.permissionGranted) {
                                                StringBuilder sb = new StringBuilder();
                                                sb.append(this.i);
                                                str = sb.toString();
                                            } else if (this.i != 1) {
                                                str = this.i + "  secs remaining to regenerate OTP\n";
                                            } else {
                                                str = this.i + " sec remaining to regenerate OTP\n";
                                            }
                                            textView322222.setText(str);
                                            this.i--;
                                        }
                                    }
                                };
                                this.enterOtpRunnable = r022222;
                                this.cbUtil.cancelTimer(this.waitingOTPTimer);
                                this.activity.findViewById(R.id.timer).setVisibility(8);
                                this.eventRecorded = "received_otp_direct";
                                addEventAnalytics("otp_received", this.eventRecorded);
                                editText.setText(this.mPassword);
                                Button button622222 = button422222;
                                button622222.setText(getString(R.string.cb_approve_otp));
                                button622222.setClickable(true);
                                if (this.autoApprove) {
                                }
                                CBUtil.setAlpha(1.0f, button622222);
                                view522222.setVisibility(0);
                                this.customProgressBar.removeDialog(view1422222);
                                view1322222.setVisibility(8);
                                view722222.setVisibility(8);
                                button622222.setVisibility(0);
                                view622222.setVisibility(8);
                                editText.setVisibility(0);
                                this.buttonClickListener.setView(this.enterOTPView);
                                button622222.setOnClickListener(this.buttonClickListener);
                                updateHeight(this.enterOTPView);
                                if (this.cbBaseView.isShown()) {
                                }
                            }
                        }
                    }
                    z2 = false;
                    findViewById8 = view18;
                    if (!z) {
                    }
                    if (Build.VERSION.SDK_INT >= 23) {
                    }
                    view = view4;
                } catch (Exception e6) {
                    e = e6;
                    view = view4;
                    findViewById8 = view2;
                    e.printStackTrace();
                    View view5222222 = view3;
                    EditText editText3222222 = editText2;
                    final int i2222222 = (Build.VERSION.SDK_INT >= 23 || this.permissionGranted) ? 30 : 45;
                    AnonymousClass21 r0222222 = r122222;
                    final TextView textView3222222 = textView2;
                    View view6222222 = findViewById5;
                    final String str2222222 = str;
                    View view7222222 = findViewById4;
                    final View view8222222 = findViewById9;
                    Button button4222222 = button3;
                    final View view9222222 = view7222222;
                    View view10222222 = findViewById7;
                    final Button button5222222 = button4222222;
                    View view11222222 = findViewById6;
                    final View view12222222 = view6222222;
                    View view13222222 = findViewById9;
                    Object obj3222222 = obj;
                    final EditText editText4222222 = editText3222222;
                    View view14222222 = view;
                    Object obj4222222 = obj2;
                    final View view15222222 = view11222222;
                    final View view16222222 = view10222222;
                    final View view17222222 = findViewById8;
                    AnonymousClass21 r1222222 = new Runnable() {
                        /* class com.payu.custombrowser.Bank.AnonymousClass21 */
                        int i = i2222222;

                        public void run() {
                            String str;
                            boolean z = true;
                            if (this.i == 0) {
                                try {
                                    if (Bank.this.activity != null && Bank.this.enterOTPView.isShown() && Bank.this.activity.findViewById(R.id.otp_sms) != null) {
                                        textView3222222.setVisibility(8);
                                        JSONObject jSONObject = new JSONObject(str2222222);
                                        boolean z2 = jSONObject.has(Bank.this.getString(R.string.cb_regenerate)) && jSONObject.getBoolean(Bank.this.getString(R.string.cb_regenerate));
                                        if (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                            z = false;
                                        }
                                        if (z2) {
                                            findViewById.setVisibility(0);
                                            findViewById3.setVisibility(8);
                                            findViewById2.setVisibility(0);
                                        } else {
                                            if (z) {
                                                findViewById3.setVisibility(0);
                                            } else {
                                                findViewById3.setVisibility(8);
                                            }
                                            findViewById.setVisibility(8);
                                            findViewById2.setVisibility(0);
                                        }
                                        view8222222.setVisibility(0);
                                        view9222222.setVisibility(0);
                                        button5222222.setVisibility(8);
                                        view12222222.setVisibility(8);
                                        editText4222222.setVisibility(8);
                                        view15222222.setOnClickListener(Bank.this.buttonClickListener);
                                        view16222222.setOnClickListener(Bank.this.buttonClickListener);
                                        view17222222.setOnClickListener(Bank.this.buttonClickListener);
                                        Bank.this.updateHeight(Bank.this.enterOTPView);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else if (!editText4222222.hasFocus() && editText4222222.getText().toString().matches("")) {
                                if (this.i == i2222222) {
                                    textView3222222.setVisibility(0);
                                }
                                if (Build.VERSION.SDK_INT < 23 || Bank.this.permissionGranted) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(this.i);
                                    str = sb.toString();
                                } else if (this.i != 1) {
                                    str = this.i + "  secs remaining to regenerate OTP\n";
                                } else {
                                    str = this.i + " sec remaining to regenerate OTP\n";
                                }
                                textView3222222.setText(str);
                                this.i--;
                            }
                        }
                    };
                    this.enterOtpRunnable = r0222222;
                    this.cbUtil.cancelTimer(this.waitingOTPTimer);
                    this.activity.findViewById(R.id.timer).setVisibility(8);
                    this.eventRecorded = "received_otp_direct";
                    addEventAnalytics("otp_received", this.eventRecorded);
                    editText.setText(this.mPassword);
                    Button button6222222 = button4222222;
                    button6222222.setText(getString(R.string.cb_approve_otp));
                    button6222222.setClickable(true);
                    if (this.autoApprove) {
                    }
                    CBUtil.setAlpha(1.0f, button6222222);
                    view5222222.setVisibility(0);
                    this.customProgressBar.removeDialog(view14222222);
                    view13222222.setVisibility(8);
                    view7222222.setVisibility(8);
                    button6222222.setVisibility(0);
                    view6222222.setVisibility(8);
                    editText.setVisibility(0);
                    this.buttonClickListener.setView(this.enterOTPView);
                    button6222222.setOnClickListener(this.buttonClickListener);
                    updateHeight(this.enterOTPView);
                    if (this.cbBaseView.isShown()) {
                    }
                }
            } catch (Exception e7) {
                e = e7;
                view = findViewById10;
                e.printStackTrace();
                View view52222222 = view3;
                EditText editText32222222 = editText2;
                final int i22222222 = (Build.VERSION.SDK_INT >= 23 || this.permissionGranted) ? 30 : 45;
                AnonymousClass21 r02222222 = r1222222;
                final TextView textView32222222 = textView2;
                View view62222222 = findViewById5;
                final String str22222222 = str;
                View view72222222 = findViewById4;
                final View view82222222 = findViewById9;
                Button button42222222 = button3;
                final View view92222222 = view72222222;
                View view102222222 = findViewById7;
                final Button button52222222 = button42222222;
                View view112222222 = findViewById6;
                final View view122222222 = view62222222;
                View view132222222 = findViewById9;
                Object obj32222222 = obj;
                final EditText editText42222222 = editText32222222;
                View view142222222 = view;
                Object obj42222222 = obj2;
                final View view152222222 = view112222222;
                final View view162222222 = view102222222;
                final View view172222222 = findViewById8;
                AnonymousClass21 r12222222 = new Runnable() {
                    /* class com.payu.custombrowser.Bank.AnonymousClass21 */
                    int i = i22222222;

                    public void run() {
                        String str;
                        boolean z = true;
                        if (this.i == 0) {
                            try {
                                if (Bank.this.activity != null && Bank.this.enterOTPView.isShown() && Bank.this.activity.findViewById(R.id.otp_sms) != null) {
                                    textView32222222.setVisibility(8);
                                    JSONObject jSONObject = new JSONObject(str22222222);
                                    boolean z2 = jSONObject.has(Bank.this.getString(R.string.cb_regenerate)) && jSONObject.getBoolean(Bank.this.getString(R.string.cb_regenerate));
                                    if (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                        z = false;
                                    }
                                    if (z2) {
                                        findViewById.setVisibility(0);
                                        findViewById3.setVisibility(8);
                                        findViewById2.setVisibility(0);
                                    } else {
                                        if (z) {
                                            findViewById3.setVisibility(0);
                                        } else {
                                            findViewById3.setVisibility(8);
                                        }
                                        findViewById.setVisibility(8);
                                        findViewById2.setVisibility(0);
                                    }
                                    view82222222.setVisibility(0);
                                    view92222222.setVisibility(0);
                                    button52222222.setVisibility(8);
                                    view122222222.setVisibility(8);
                                    editText42222222.setVisibility(8);
                                    view152222222.setOnClickListener(Bank.this.buttonClickListener);
                                    view162222222.setOnClickListener(Bank.this.buttonClickListener);
                                    view172222222.setOnClickListener(Bank.this.buttonClickListener);
                                    Bank.this.updateHeight(Bank.this.enterOTPView);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (!editText42222222.hasFocus() && editText42222222.getText().toString().matches("")) {
                            if (this.i == i22222222) {
                                textView32222222.setVisibility(0);
                            }
                            if (Build.VERSION.SDK_INT < 23 || Bank.this.permissionGranted) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.i);
                                str = sb.toString();
                            } else if (this.i != 1) {
                                str = this.i + "  secs remaining to regenerate OTP\n";
                            } else {
                                str = this.i + " sec remaining to regenerate OTP\n";
                            }
                            textView32222222.setText(str);
                            this.i--;
                        }
                    }
                };
                this.enterOtpRunnable = r02222222;
                this.cbUtil.cancelTimer(this.waitingOTPTimer);
                this.activity.findViewById(R.id.timer).setVisibility(8);
                this.eventRecorded = "received_otp_direct";
                addEventAnalytics("otp_received", this.eventRecorded);
                editText.setText(this.mPassword);
                Button button62222222 = button42222222;
                button62222222.setText(getString(R.string.cb_approve_otp));
                button62222222.setClickable(true);
                if (this.autoApprove) {
                }
                CBUtil.setAlpha(1.0f, button62222222);
                view52222222.setVisibility(0);
                this.customProgressBar.removeDialog(view142222222);
                view132222222.setVisibility(8);
                view72222222.setVisibility(8);
                button62222222.setVisibility(0);
                view62222222.setVisibility(8);
                editText.setVisibility(0);
                this.buttonClickListener.setView(this.enterOTPView);
                button62222222.setOnClickListener(this.buttonClickListener);
                updateHeight(this.enterOTPView);
                if (this.cbBaseView.isShown()) {
                }
            }
            View view522222222 = view3;
            EditText editText322222222 = editText2;
            final int i222222222 = (Build.VERSION.SDK_INT >= 23 || this.permissionGranted) ? 30 : 45;
            AnonymousClass21 r022222222 = r12222222;
            final TextView textView322222222 = textView2;
            View view622222222 = findViewById5;
            final String str222222222 = str;
            View view722222222 = findViewById4;
            final View view822222222 = findViewById9;
            Button button422222222 = button3;
            final View view922222222 = view722222222;
            View view1022222222 = findViewById7;
            final Button button522222222 = button422222222;
            View view1122222222 = findViewById6;
            final View view1222222222 = view622222222;
            View view1322222222 = findViewById9;
            Object obj322222222 = obj;
            final EditText editText422222222 = editText322222222;
            View view1422222222 = view;
            Object obj422222222 = obj2;
            final View view1522222222 = view1122222222;
            final View view1622222222 = view1022222222;
            final View view1722222222 = findViewById8;
            AnonymousClass21 r122222222 = new Runnable() {
                /* class com.payu.custombrowser.Bank.AnonymousClass21 */
                int i = i222222222;

                public void run() {
                    String str;
                    boolean z = true;
                    if (this.i == 0) {
                        try {
                            if (Bank.this.activity != null && Bank.this.enterOTPView.isShown() && Bank.this.activity.findViewById(R.id.otp_sms) != null) {
                                textView322222222.setVisibility(8);
                                JSONObject jSONObject = new JSONObject(str222222222);
                                boolean z2 = jSONObject.has(Bank.this.getString(R.string.cb_regenerate)) && jSONObject.getBoolean(Bank.this.getString(R.string.cb_regenerate));
                                if (!jSONObject.has(Bank.this.getString(R.string.cb_pin)) || !jSONObject.getBoolean(Bank.this.getString(R.string.cb_pin))) {
                                    z = false;
                                }
                                if (z2) {
                                    findViewById.setVisibility(0);
                                    findViewById3.setVisibility(8);
                                    findViewById2.setVisibility(0);
                                } else {
                                    if (z) {
                                        findViewById3.setVisibility(0);
                                    } else {
                                        findViewById3.setVisibility(8);
                                    }
                                    findViewById.setVisibility(8);
                                    findViewById2.setVisibility(0);
                                }
                                view822222222.setVisibility(0);
                                view922222222.setVisibility(0);
                                button522222222.setVisibility(8);
                                view1222222222.setVisibility(8);
                                editText422222222.setVisibility(8);
                                view1522222222.setOnClickListener(Bank.this.buttonClickListener);
                                view1622222222.setOnClickListener(Bank.this.buttonClickListener);
                                view1722222222.setOnClickListener(Bank.this.buttonClickListener);
                                Bank.this.updateHeight(Bank.this.enterOTPView);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (!editText422222222.hasFocus() && editText422222222.getText().toString().matches("")) {
                        if (this.i == i222222222) {
                            textView322222222.setVisibility(0);
                        }
                        if (Build.VERSION.SDK_INT < 23 || Bank.this.permissionGranted) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.i);
                            str = sb.toString();
                        } else if (this.i != 1) {
                            str = this.i + "  secs remaining to regenerate OTP\n";
                        } else {
                            str = this.i + " sec remaining to regenerate OTP\n";
                        }
                        textView322222222.setText(str);
                        this.i--;
                    }
                }
            };
            this.enterOtpRunnable = r022222222;
            this.cbUtil.cancelTimer(this.waitingOTPTimer);
            this.activity.findViewById(R.id.timer).setVisibility(8);
            this.eventRecorded = "received_otp_direct";
            addEventAnalytics("otp_received", this.eventRecorded);
            editText.setText(this.mPassword);
            Button button622222222 = button422222222;
            button622222222.setText(getString(R.string.cb_approve_otp));
            button622222222.setClickable(true);
            if (this.autoApprove) {
            }
            CBUtil.setAlpha(1.0f, button622222222);
            view522222222.setVisibility(0);
            this.customProgressBar.removeDialog(view1422222222);
            view1322222222.setVisibility(8);
            view722222222.setVisibility(8);
            button622222222.setVisibility(0);
            view622222222.setVisibility(8);
            editText.setVisibility(0);
            this.buttonClickListener.setView(this.enterOTPView);
            button622222222.setOnClickListener(this.buttonClickListener);
            updateHeight(this.enterOTPView);
            if (this.cbBaseView.isShown()) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getCode(String str) {
        if (str.equalsIgnoreCase("pin")) {
            return 3;
        }
        if (str.equalsIgnoreCase("password")) {
            return 1;
        }
        if (str.equalsIgnoreCase("enter manually")) {
            return 4;
        }
        if (str.equalsIgnoreCase("approve")) {
            return 5;
        }
        if (str.equalsIgnoreCase("otp") || str.equalsIgnoreCase("use sms otp")) {
            return 6;
        }
        if (str.equalsIgnoreCase("sms otp")) {
            return 7;
        }
        return str.equalsIgnoreCase("regenerate otp") ? 2 : 0;
    }

    private void startSnoozeCountDownTimer() {
        this.mCountDownTimer = new CountDownTimer((long) this.snoozeUrlLoadingTimeout, 500) {
            /* class com.payu.custombrowser.Bank.AnonymousClass22 */

            public void onTick(long j) {
                Bank.this.isSnoozeTimerRunning = true;
            }

            public void onFinish() {
                Bank bank = Bank.this;
                bank.isSnoozeTimerRunning = false;
                if (bank.cbWebView.getProgress() < Bank.this.snoozeUrlLoadingPercentage && !Bank.this.isSnoozeWindowVisible && Bank.this.showSnoozeWindow && !Bank.this.getTransactionStatusReceived()) {
                    Bank.this.launchSnoozeWindow();
                }
                Bank.this.stopSnoozeCountDownTimer();
            }
        };
        this.mCountDownTimer.start();
    }

    public void stopSnoozeCountDownTimer() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            this.isSnoozeTimerRunning = false;
            countDownTimer.cancel();
            this.mCountDownTimer = null;
        }
    }

    public void launchSnoozeWindow() {
        launchSnoozeWindow(1);
    }

    public void launchSnoozeWindow(int i) {
        int i2 = i;
        if (this.surePayDisableStatus != 3) {
            if (i2 != 2 || this.surePayDisableStatus != 2) {
                if (i2 != 1 || this.surePayDisableStatus != 1) {
                    showCbBlankOverlay(8);
                    if (this.backwardJourneyStarted) {
                        if (this.snoozeCountBackwardJourney >= this.customBrowserConfig.getEnableSurePay()) {
                            return;
                        }
                    } else if (this.snoozeCount >= this.customBrowserConfig.getEnableSurePay()) {
                        return;
                    }
                    this.snoozeMode = i2;
                    if (this.activity != null && !this.activity.isFinishing()) {
                        dismissSlowUserWarning();
                        progressBarVisibilityPayuChrome(8, "");
                        this.isSnoozeWindowVisible = true;
                        addEventAnalytics("snooze_window_status", "snooze_visible");
                        addEventAnalytics("snooze_appear_url", this.webviewUrl);
                        addEventAnalytics("snooze_window_launch_mode", i2 == 1 ? "Warn" : "Fail");
                        addEventAnalytics("snooze_window_appear_time", "-1");
                        this.snoozeLayout = this.activity.getLayoutInflater().inflate((int) R.layout.cb_layout_snooze, (ViewGroup) null);
                        TextView textView = (TextView) this.snoozeLayout.findViewById(R.id.text_view_snooze_message);
                        final TextView textView2 = (TextView) this.snoozeLayout.findViewById(R.id.text_view_transaction_snoozed_message1);
                        TextView textView3 = (TextView) this.snoozeLayout.findViewById(R.id.button_cancel_transaction);
                        Button button = (Button) this.snoozeLayout.findViewById(R.id.button_snooze_transaction);
                        Button button2 = (Button) this.snoozeLayout.findViewById(R.id.button_retry_transaction);
                        TextView textView4 = (TextView) this.snoozeLayout.findViewById(R.id.text_view_cancel_snooze_window);
                        TextView textView5 = (TextView) this.snoozeLayout.findViewById(R.id.t_confirm);
                        final TextView textView6 = (TextView) this.snoozeLayout.findViewById(R.id.t_nconfirm);
                        TextView textView7 = (TextView) this.snoozeLayout.findViewById(R.id.snooze_header_txt);
                        TextView textView8 = (TextView) this.snoozeLayout.findViewById(R.id.text_view_retry_message_detail);
                        Button button3 = (Button) this.snoozeLayout.findViewById(R.id.button_retry_anyway);
                        this.snoozeLoaderView = (SnoozeLoaderView) this.snoozeLayout.findViewById(R.id.snooze_loader_view);
                        this.snoozeLoaderView.setVisibility(8);
                        textView4.setVisibility(0);
                        textView3.setVisibility(0);
                        button.setVisibility(0);
                        button2.setVisibility(0);
                        textView.setVisibility(0);
                        textView2.setVisibility(8);
                        textView8.setVisibility(0);
                        textView5.setVisibility(8);
                        textView6.setVisibility(8);
                        button3.setVisibility(8);
                        textView.setText(this.activity.getString(R.string.cb_slownetwork_status));
                        textView7.setText(this.activity.getString(R.string.cb_try_later));
                        textView8.setText(this.activity.getString(R.string.cb_retry_restart));
                        if (!this.backwardJourneyStarted || !this.payuPG) {
                            this.snoozeVisibleCountFwdJourney++;
                        } else {
                            textView.setText(this.activity.getResources().getString(R.string.cb_slow_internet_confirmation));
                            textView2.setText(this.activity.getResources().getString(R.string.cb_receive_sms));
                            textView7.setText(this.activity.getResources().getString(R.string.cb_confirm_transaction));
                            button.setVisibility(8);
                            textView8.setVisibility(8);
                            button2.setVisibility(8);
                            textView3.setVisibility(8);
                            textView.setVisibility(0);
                            textView2.setVisibility(0);
                            textView5.setVisibility(0);
                            textView6.setVisibility(0);
                            button3.setVisibility(8);
                            this.snoozeVisibleCountBackwdJourney++;
                            addEventAnalytics("snooze_backward_visible", "Y");
                        }
                        TextView textView9 = textView3;
                        AnonymousClass23 r12 = r0;
                        final TextView textView10 = textView7;
                        final TextView textView11 = textView;
                        Button button4 = button3;
                        final Button button5 = button;
                        TextView textView12 = textView8;
                        final TextView textView13 = textView2;
                        TextView textView14 = textView7;
                        final TextView textView15 = textView5;
                        AnonymousClass23 r0 = new View.OnClickListener() {
                            /* class com.payu.custombrowser.Bank.AnonymousClass23 */

                            public void onClick(View view) {
                                Bank.this.addEventAnalytics(CBAnalyticsConstant.SNOOZE_BACKWARD_WINDOW_ACTION, "confirm_deduction_y");
                                if (Bank.this.waitingOTPTimer != null) {
                                    Bank.this.waitingOTPTimer.cancel();
                                    Bank.this.waitingOTPTimer.purge();
                                }
                                Bank.this.snoozeCountBackwardJourney++;
                                Bank.this.snoozeDialog.setCanceledOnTouchOutside(false);
                                textView10.setText(Bank.this.activity.getResources().getString(R.string.cb_confirm_transaction));
                                textView11.setText(Bank.this.activity.getString(R.string.cb_transaction_status));
                                Bank.this.snoozeLoaderView.setVisibility(0);
                                Bank.this.snoozeLoaderView.startAnimation();
                                button5.setVisibility(8);
                                textView13.setVisibility(8);
                                textView15.setVisibility(8);
                                textView6.setVisibility(8);
                                if (Bank.this.verificationMsgReceived) {
                                    Bank bank = Bank.this;
                                    bank.startSnoozeServiceVerifyPayment(bank.activity.getResources().getString(R.string.cb_verify_message_received));
                                    return;
                                }
                                Bank bank2 = Bank.this;
                                bank2.startSnoozeServiceVerifyPayment(bank2.activity.getResources().getString(R.string.cb_user_input_confirm_transaction));
                            }
                        };
                        textView5.setOnClickListener(r12);
                        textView6.setOnClickListener(new View.OnClickListener() {
                            /* class com.payu.custombrowser.Bank.AnonymousClass24 */

                            public void onClick(View view) {
                                Bank.this.snoozeCountBackwardJourney++;
                                Bank.this.dismissSnoozeWindow();
                                Bank.this.addEventAnalytics(CBAnalyticsConstant.SNOOZE_BACKWARD_WINDOW_ACTION, "confirm_deduction_n");
                            }
                        });
                        textView4.setOnClickListener(new View.OnClickListener() {
                            /* class com.payu.custombrowser.Bank.AnonymousClass25 */

                            public void onClick(View view) {
                                if (Bank.this.backwardJourneyStarted) {
                                    Bank.this.snoozeCountBackwardJourney++;
                                } else {
                                    Bank.this.snoozeCount++;
                                }
                                Bank.this.addEventAnalytics("snooze_interaction_time", "-1");
                                if (!Bank.this.backwardJourneyStarted) {
                                    Bank.this.addEventAnalytics("snooze_window_action", "snooze_cancel_window_click");
                                }
                                Bank.this.dismissSnoozeWindow();
                            }
                        });
                        button2.setOnClickListener(new View.OnClickListener() {
                            /* class com.payu.custombrowser.Bank.AnonymousClass26 */

                            public void onClick(View view) {
                                Bank.this.hideCB();
                                Bank.this.retryPayment(view);
                            }
                        });
                        final TextView textView16 = textView4;
                        final TextView textView17 = textView9;
                        final Button button6 = button2;
                        final TextView textView18 = textView;
                        final TextView textView19 = textView12;
                        final TextView textView20 = textView14;
                        final Button button7 = button4;
                        button.setOnClickListener(new View.OnClickListener() {
                            /* class com.payu.custombrowser.Bank.AnonymousClass27 */

                            public void onClick(View view) {
                                Bank.this.snoozeCount++;
                                Bank.this.addEventAnalytics("snooze_interaction_time", "-1");
                                Bank.this.maximiseWebviewHeight();
                                Bank bank = Bank.this;
                                bank.frameState = 1;
                                if (bank.cbSlideBarView != null) {
                                    Bank.this.cbSlideBarView.setVisibility(8);
                                }
                                Bank.this.onHelpUnavailable();
                                Bank.this.snoozeClickedTime = System.currentTimeMillis();
                                Bank bank2 = Bank.this;
                                bank2.isSnoozeBroadCastReceiverRegistered = true;
                                bank2.isPageStoppedForcefully = true;
                                bank2.cbWebView.stopLoading();
                                if (!(CustomBrowserData.SINGLETON == null || CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() == null)) {
                                    Bank.this.bindService();
                                }
                                Bank bank3 = Bank.this;
                                bank3.mPassword = null;
                                bank3.unregisterBroadcast(bank3.mBroadcastReceiver);
                                textView16.setVisibility(8);
                                textView17.setVisibility(8);
                                button5.setVisibility(8);
                                button6.setVisibility(8);
                                textView18.setText("We have paused your transaction because the network was unable to process it now. We will notify you when the network improves.");
                                textView19.setVisibility(8);
                                textView20.setText(Bank.this.activity.getResources().getString(R.string.cb_transaction_paused));
                                textView2.setVisibility(0);
                                button7.setVisibility(0);
                                Bank.this.progressBarVisibilityPayuChrome(8, "");
                                Bank.this.addEventAnalytics("snooze_window_action", "snooze_click");
                                Bank bank4 = Bank.this;
                                bank4.addEventAnalytics("snooze_load_url", bank4.cbWebView.getUrl() == null ? Bank.this.webviewUrl : Bank.this.cbWebView.getUrl());
                                Bank bank5 = Bank.this;
                                bank5.slowUserCountDownTimer = null;
                                bank5.showCbBlankOverlay(0);
                            }
                        });
                        textView9.setOnClickListener(new View.OnClickListener() {
                            /* class com.payu.custombrowser.Bank.AnonymousClass28 */

                            public void onClick(View view) {
                                if (Bank.this.backwardJourneyStarted) {
                                    Bank.this.snoozeCountBackwardJourney++;
                                } else {
                                    Bank.this.snoozeCount++;
                                }
                                Bank.this.addEventAnalytics("snooze_interaction_time", "-1");
                                Bank.this.addEventAnalytics("snooze_window_action", "snooze_cancel_transaction_click");
                                Bank.this.showBackButtonDialog();
                            }
                        });
                        button4.setOnClickListener(new View.OnClickListener() {
                            /* class com.payu.custombrowser.Bank.AnonymousClass29 */

                            public void onClick(View view) {
                                Bank.this.hideCB();
                                Bank.this.retryPayment(view);
                            }
                        });
                        if (this.snoozeDialog == null || !this.snoozeDialog.isShowing()) {
                            this.snoozeDialog = new AlertDialog.Builder(this.activity).create();
                            this.snoozeDialog.O000000o(this.snoozeLayout);
                            this.snoozeDialog.setCanceledOnTouchOutside(false);
                            this.snoozeDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                /* class com.payu.custombrowser.Bank.AnonymousClass30 */

                                public void onDismiss(DialogInterface dialogInterface) {
                                    Bank.this.showCbBlankOverlay(8);
                                }
                            });
                            this.snoozeDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                                /* class com.payu.custombrowser.Bank.AnonymousClass31 */

                                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                    if (i != 4 || keyEvent.getAction() != 0) {
                                        return true;
                                    }
                                    Bank.this.addEventAnalytics("user_input", "payu_back_button".toLowerCase());
                                    Bank.this.showBackButtonDialog();
                                    return true;
                                }
                            });
                        }
                        this.snoozeDialog.show();
                    }
                }
            }
        }
    }

    public void bindService() {
        ft.O000000o(this.activity).O000000o(this.snoozeBroadCastReceiver);
        ft.O000000o(this.activity.getApplicationContext()).O000000o(this.snoozeBroadCastReceiver, new IntentFilter(this.SNOOZE_GET_WEBVIEW_STATUS_INTENT_ACTION));
        Intent intent = new Intent(this.activity, SnoozeService.class);
        intent.putExtra("cb_config", this.customBrowserConfig);
        intent.putExtra("currentUrl", this.webviewUrl);
        intent.putExtra("merchantCheckoutActivity", this.customBrowserConfig.getMerchantCheckoutActivityPath());
        this.isSnoozeServiceBounded = true;
        this.activity.bindService(intent, this.snoozeServiceConnection, 1);
        this.activity.startService(intent);
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
    public void startSnoozeServiceVerifyPayment(String str) {
        ft.O000000o(this.activity).O000000o(this.snoozeBroadCastReceiver);
        ft.O000000o(this.activity.getApplicationContext()).O000000o(this.snoozeBroadCastReceiver, new IntentFilter(this.SNOOZE_GET_WEBVIEW_STATUS_INTENT_ACTION));
        Intent intent = new Intent(this.activity, SnoozeService.class);
        intent.putExtra("cb_config", this.customBrowserConfig);
        intent.putExtra("verificationMsgReceived", true);
        intent.putExtra("merchantCheckoutActivity", this.customBrowserConfig.getMerchantCheckoutActivityPath());
        intent.putExtra("verify_add_param", str);
        this.isSnoozeServiceBounded = true;
        this.activity.bindService(intent, this.snoozeServiceConnection, 1);
        this.isSnoozeBroadCastReceiverRegistered = true;
        this.activity.startService(intent);
    }

    public void dismissSnoozeWindow() {
        this.isSnoozeWindowVisible = false;
        if (this.snoozeDialog != null) {
            this.snoozeDialog.dismiss();
            this.snoozeDialog.cancel();
            showCbBlankOverlay(8);
        }
    }

    public void setMagicRetry(Map<String, String> map) {
        if (this.magicRetryFragment != null) {
            this.magicRetryFragment.setUrlListWithPostData(map);
        }
    }

    public void initMagicRetry() {
        ee supportFragmentManager = getActivity().getSupportFragmentManager();
        this.magicRetryFragment = new MagicRetryFragment();
        Bundle bundle = new Bundle();
        if (!(CustomBrowserData.SINGLETON == null || CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() == null)) {
            bundle.putString("transaction_id", this.customBrowserConfig.getTransactionID());
        }
        this.magicRetryFragment.setArguments(bundle);
        supportFragmentManager.O000000o().O000000o(R.id.magic_retry_container, this.magicRetryFragment, "magicRetry").O00000Oo();
        toggleFragmentVisibility(0);
        this.magicRetryFragment.isWhiteListingEnabled(true);
        this.magicRetryFragment.setWebView(this.cbWebView);
        this.magicRetryFragment.initMRSettingsFromSharedPreference(this.activity);
        if (this.customBrowserConfig.getEnableSurePay() > 0) {
            this.cbWebView.setWebViewClient(new PayUSurePayWebViewClient(this, keyAnalytics));
        } else {
            this.cbWebView.setWebViewClient(new PayUWebViewClient(this, this.magicRetryFragment, keyAnalytics));
        }
    }

    public void toggleFragmentVisibility(int i) {
        if (getActivity() != null && !getActivity().isFinishing() && isAdded() && !isRemoving()) {
            ei O000000o2 = getActivity().getSupportFragmentManager().O000000o();
            if (this.magicRetryFragment != null && i == 1) {
                O000000o2.O00000o0(this.magicRetryFragment).O00000o0();
            } else if (this.magicRetryFragment != null && i == 0) {
                O000000o2.O00000Oo(this.magicRetryFragment).O00000o0();
            }
        }
    }

    public void showMagicRetry() {
        dismissSnoozeWindow();
        toggleFragmentVisibility(1);
    }

    public void hideMagicRetry() {
        toggleFragmentVisibility(0);
    }

    public void showBackButtonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        builder.setCancelable(false);
        builder.setMessage("Do you really want to cancel the transaction ?");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            /* class com.payu.custombrowser.Bank.AnonymousClass32 */

            public void onClick(DialogInterface dialogInterface, int i) {
                Bank.this.postToPaytxn();
                if (Bank.this.snoozeDialog != null && Bank.this.snoozeDialog.isShowing()) {
                    Bank.this.snoozeDialog.cancel();
                }
                Bank.this.killSnoozeService();
                Bank.this.cancelTransactionNotification();
                Bank.this.addEventAnalytics("user_input", "back_button_ok");
                Bank.this.dismissSnoozeWindow();
                if (!(CustomBrowserData.SINGLETON == null || CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() == null)) {
                    CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().onBackApprove();
                }
                Bank.this.activity.finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            /* class com.payu.custombrowser.Bank.AnonymousClass33 */

            public void onClick(DialogInterface dialogInterface, int i) {
                Bank.this.addEventAnalytics("user_input", "back_button_cancel");
                dialogInterface.dismiss();
                if (CustomBrowserData.SINGLETON != null && CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() != null) {
                    CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().onBackDismiss();
                }
            }
        });
        if (!(CustomBrowserData.SINGLETON == null || CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() == null)) {
            CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().onBackButton(builder);
        }
        builder.create().getWindow().getAttributes().type = 2003;
        builder.show();
    }

    public void setIsPageStoppedForcefully(boolean z) {
        this.isPageStoppedForcefully = z;
    }

    private void updateWhitelistedRetryUrls(List<String> list) {
        whiteListedUrls.clear();
        L.v("#### PAYU", "MR Cleared whitelisted urls, length: " + whiteListedUrls.size());
        whiteListedUrls.addAll(list);
        L.v("#### PAYU", "MR Updated whitelisted urls, length: " + whiteListedUrls.size());
    }

    @JavascriptInterface
    public void setSnoozeConfig(String str) {
        this.snoozeConfigMap = this.cbUtil.storeSnoozeConfigInSharedPref(this.activity.getApplicationContext(), str);
    }

    @JavascriptInterface
    public void dismissPayULoader() {
        if (this.activity != null && !this.activity.isFinishing() && this.progressDialog != null) {
            this.progressDialog.dismiss();
            this.progressDialog.cancel();
            if (!this.webpageNotFoundError) {
                this.forwardJourneyForChromeLoaderIsComplete = true;
                L.v("stag", "Setting forwardJourneyForChromeLoaderIsComplete = " + this.forwardJourneyForChromeLoaderIsComplete);
                startSlowUserWarningTimer();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void startSlowUserWarningTimer() {
        L.v("sTag", "Attempting to start slowUserCountDownTimer");
        if (this.slowUserCountDownTimer == null) {
            L.v("sTag", "Starting slowUserCountDownTimer");
        }
    }

    /* access modifiers changed from: protected */
    public void dismissSlowUserWarningTimer() {
        if (this.slowUserCountDownTimer != null) {
            L.v("sTag", "Shutting down slowUserCountDownTimer");
            this.slowUserCountDownTimer.cancel();
        }
    }

    public class ButtonOnclickListener implements View.OnClickListener {
        private View view_edit;

        public ButtonOnclickListener() {
        }

        public void setView(View view) {
            this.view_edit = view;
        }

        public void onClick(View view) {
            String str;
            if (view instanceof Button) {
                str = ((Button) view).getText().toString();
            } else if (view instanceof TextView) {
                str = ((TextView) view).getText().toString();
            } else {
                str = "";
            }
            switch (Bank.this.getCode(str.toLowerCase())) {
                case 1:
                case 3:
                    Bank bank = Bank.this;
                    bank.pin_selected_flag = true;
                    bank.approve_flag = Boolean.TRUE;
                    Bank.this.maximiseWebviewHeight();
                    Bank bank2 = Bank.this;
                    bank2.frameState = 1;
                    bank2.onHelpUnavailable();
                    if (Bank.this.cbSlideBarView != null) {
                        Bank.this.cbSlideBarView.setVisibility(8);
                    }
                    if (Bank.this.cbTransparentView != null) {
                        Bank.this.cbTransparentView.setVisibility(8);
                    }
                    try {
                        WebView webView = Bank.this.cbWebView;
                        webView.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_pin)));
                        Bank.this.eventRecorded = "password_click";
                        Bank.this.addEventAnalytics("user_input", Bank.this.eventRecorded);
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                case 2:
                    try {
                        Bank.this.eventRecorded = "regenerate_click";
                        Bank.this.addEventAnalytics("user_input", Bank.this.eventRecorded);
                        Bank.this.mPassword = null;
                        WebView webView2 = Bank.this.cbWebView;
                        webView2.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_regen_otp)));
                        Bank.this.prepareSmsListener();
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                case 4:
                    final View inflate = Bank.this.activity.getLayoutInflater().inflate((int) R.layout.wait_for_otp, (ViewGroup) null);
                    Bank bank3 = Bank.this;
                    bank3.eventRecorded = "enter_manually_click";
                    bank3.addEventAnalytics("user_input", bank3.eventRecorded);
                    if (Bank.this.chooseActionHeight == 0) {
                        inflate.measure(-2, -2);
                        Bank.this.chooseActionHeight = inflate.getMeasuredHeight();
                    }
                    Bank.this.cbBaseView.removeAllViews();
                    Bank.this.cbBaseView.addView(inflate);
                    if (Bank.this.cbBaseView.isShown()) {
                        Bank.this.frameState = 2;
                    } else {
                        Bank.this.maximiseWebviewHeight();
                    }
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.bank_logo);
                    imageView.setOnClickListener(Bank.this.viewOnClickListener);
                    if (Bank.this.drawable != null) {
                        imageView.setImageDrawable(Bank.this.drawable);
                    }
                    inflate.findViewById(R.id.waiting).setVisibility(8);
                    final Button button = (Button) inflate.findViewById(R.id.approve);
                    button.setClickable(false);
                    EditText editText = (EditText) inflate.findViewById(R.id.otp_sms);
                    Bank.this.showSoftKeyboard(editText);
                    CBUtil.setAlpha(0.3f, button);
                    button.setVisibility(0);
                    editText.setVisibility(0);
                    inflate.findViewById(R.id.regenerate_layout).setVisibility(8);
                    inflate.findViewById(R.id.progress).setVisibility(4);
                    Bank.this.showSoftKeyboard(editText);
                    editText.addTextChangedListener(new TextWatcher() {
                        /* class com.payu.custombrowser.Bank.ButtonOnclickListener.AnonymousClass1 */

                        public void afterTextChanged(Editable editable) {
                        }

                        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        }

                        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            if (((EditText) inflate.findViewById(R.id.otp_sms)).getText().toString().length() > 5) {
                                Bank.this.buttonClickListener.setView(inflate);
                                button.setOnClickListener(Bank.this.buttonClickListener);
                                button.setClickable(true);
                                CBUtil.setAlpha(1.0f, button);
                                return;
                            }
                            button.setClickable(false);
                            CBUtil.setAlpha(0.3f, button);
                            button.setOnClickListener(null);
                        }
                    });
                    Bank.this.updateHeight(inflate);
                    return;
                case 5:
                    try {
                        Bank.this.hideKeyboardForcefully();
                        Bank.this.mPassword = null;
                        Bank.this.checkLoading = false;
                        Bank.this.approve_flag = Boolean.TRUE;
                        Bank.this.onHelpUnavailable();
                        Bank.this.maximiseWebviewHeight();
                        Bank.this.frameState = 1;
                        Bank.this.prepareSmsListener();
                        if (((EditText) this.view_edit.findViewById(R.id.otp_sms)).getText().toString().length() > 5) {
                            Bank.this.eventRecorded = "approved_otp";
                            Bank.this.addEventAnalytics("user_input", Bank.this.eventRecorded);
                            Bank.this.addEventAnalytics("Approve_btn_clicked_time", "-1");
                            WebView webView3 = Bank.this.cbWebView;
                            webView3.loadUrl("javascript:" + Bank.this.mJS.getString(Bank.this.getString(R.string.cb_process_otp)) + "(\"" + ((TextView) Bank.this.activity.findViewById(R.id.otp_sms)).getText().toString() + "\")");
                            ((EditText) this.view_edit.findViewById(R.id.otp_sms)).setText("");
                            return;
                        }
                        return;
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        return;
                    }
                case 6:
                case 7:
                    Bank bank4 = Bank.this;
                    bank4.SMSOTPClicked = true;
                    bank4.checkPermission();
                    Bank bank5 = Bank.this;
                    bank5.eventRecorded = "otp_click";
                    bank5.addEventAnalytics("user_input", bank5.eventRecorded);
                    if (Build.VERSION.SDK_INT < 23) {
                        Bank bank6 = Bank.this;
                        bank6.mPassword = null;
                        bank6.prepareSmsListener();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void reloadWVUsingJS() {
        this.cbWebView.loadUrl("javascript:window.location.reload(true)");
    }

    public void reloadWVNative() {
        this.cbWebView.reload();
    }

    public void reloadWVUsingJSFromCache() {
        this.cbWebView.loadUrl("javascript:window.location.reload()");
    }

    public void retryPayment(View view) {
        if (view.getId() == R.id.button_retry_transaction) {
            this.snoozeCount++;
            addEventAnalytics("snooze_interaction_time", "-1");
            addEventAnalytics("snooze_window_action", "snooze_retry_click");
        } else if (view.getId() == R.id.button_retry_anyway) {
            addEventAnalytics("snooze_txn_paused_user_interaction_time", "-1");
            addEventAnalytics("snooze_txn_paused_window_action", "retry_anyway_click");
        }
        setTransactionStatusReceived(false);
        if (CBUtil.isNetworkAvailable(this.activity.getApplicationContext())) {
            if (this.cbWebView.getUrl() == null || this.cbWebView.getUrl().contentEquals("https://secure.payu.in/_payment") || this.cbWebView.getUrl().contentEquals("https://secure.payu.in/_seamless_payment") || !isUrlWhiteListed(this.cbWebView.getUrl())) {
                this.cbUtil.clearCookie();
                if (this.customBrowserConfig.getPostURL().contentEquals("https://secure.payu.in/_payment") || this.customBrowserConfig.getPostURL().contentEquals("https://mobiletest.payu.in/_payment")) {
                    markPreviousTxnAsUserCanceled(this.cbUtil.getLogMessage(this.activity.getApplicationContext(), "sure_pay_cancelled", this.customBrowserConfig.getTransactionID(), "", keyAnalytics, this.customBrowserConfig.getTransactionID(), ""));
                }
                reloadWebView(this.customBrowserConfig.getPostURL(), this.customBrowserConfig.getPayuPostData());
            } else {
                reloadWebView();
            }
            dismissSnoozeWindow();
            this.slowUserCountDownTimer = null;
            if (view.getId() == R.id.button_retry_anyway) {
                killSnoozeService();
                ((NotificationManager) this.activity.getSystemService("notification")).cancel(CBConstant.SNOOZE_NOTIFICATION_ID);
                return;
            }
            return;
        }
        Toast.makeText(this.activity.getApplicationContext(), "Not internet connection", 0).show();
    }

    @JavascriptInterface
    public void spResumedWindowTTL(String str) {
        try {
            this.mInternetRestoredWindowTTL = Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setSurePayResumeStatus(boolean z) {
        this.isSurePayResumed = z;
    }
}
