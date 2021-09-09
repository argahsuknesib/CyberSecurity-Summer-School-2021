package com.payu.custombrowser;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.payu.custombrowser.analytics.CBAnalytics;
import com.payu.custombrowser.analytics.PayuDeviceAnalytics;
import com.payu.custombrowser.bean.CustomBrowserConfig;
import com.payu.custombrowser.bean.CustomBrowserData;
import com.payu.custombrowser.util.CBConstant;
import com.payu.custombrowser.util.CBUtil;
import com.payu.custombrowser.util.L;
import com.payu.magicretry.MagicRetryFragment;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public class CustomBrowserMain extends Fragment implements CBConstant {
    final String CB_URL = "https://secure.payu.in/js/sdk_js/v3/";
    Activity activity;
    protected boolean autoApprove;
    protected boolean autoSelectOtp;
    protected boolean backwardJourneyStarted = false;
    Set<String> backwardJourneyUrls;
    String bankName;
    Bundle bundle;
    FrameLayout cbBaseView;
    boolean cbOldFlow;
    View cbSlideBarView;
    View cbTransparentView;
    CBUtil cbUtil;
    private boolean cbVisibleOnce;
    ProgressBar cbWebPageProgressBar;
    WebView cbWebView;
    int checkForInput;
    CountDownTimer countDownTimer;
    protected CustomBrowserConfig customBrowserConfig;
    Drawable drawable;
    View enterOTPView;
    ArrayList<String> eventArray = new ArrayList<>();
    String eventRecorded;
    protected boolean firstTouch = false;
    protected boolean forwardJourneyForChromeLoaderIsComplete = false;
    int frameState;
    boolean isSnoozeWindowVisible = false;
    Boolean isSuccessTransaction;
    private boolean isTransactionStatusReceived;
    protected boolean isTxnNBType;
    protected boolean isWebviewReloading;
    int lastProgress;
    View loadingLayout;
    int loading_height;
    CBAnalytics mAnalytics;
    JSONObject mBankJS;
    BroadcastReceiver mBroadcastReceiver;
    public int mCounter = 0;
    protected Handler mHandler = new Handler();
    JSONObject mJS;
    BroadcastReceiver mReceiver = null;
    protected Runnable mResetCounter = new Runnable() {
        /* class com.payu.custombrowser.CustomBrowserMain.AnonymousClass8 */

        public void run() {
            CustomBrowserMain.this.mCounter = 0;
        }
    };
    MagicRetryFragment magicRetryFragment;
    int maxWebview;
    String merchantResponse;
    boolean merchantSMSPermission;
    int minWebview;
    boolean nbhelpVisible;
    protected String pageType = "";
    protected boolean payuChromeLoaderDisabled = false;
    PayuDeviceAnalytics payuDeviceAnalytics;
    boolean payuPG;
    String payuReponse;
    ProgressDialog progressDialog;
    Set<String> retryUrls;
    Executor serialExecutor;
    AlertDialog snoozeDialog;
    public int snoozeMode = 1;
    int storeOneClickHash;
    protected String timeOfArrival;
    protected String timeOfDeparture;
    protected Timer timerProgress;
    boolean verificationMsgReceived;
    protected ViewOnClickListener viewOnClickListener;
    String webviewUrl;

    public void loadUrlWebView(JSONObject jSONObject, String str) {
    }

    public void onBackApproved() {
    }

    public void onBackCancelled() {
    }

    public void onBackPressed(AlertDialog.Builder builder) {
    }

    /* access modifiers changed from: protected */
    public boolean checkIfTransactionNBType(String str) {
        try {
            if (this.cbUtil.getDataFromPostData(this.customBrowserConfig.getPayuPostData(), "pg").equalsIgnoreCase("nb")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void resetAutoSelectOTP() {
        CustomBrowserConfig customBrowserConfig2 = this.customBrowserConfig;
        boolean z = true;
        if (customBrowserConfig2 == null || customBrowserConfig2.getAutoSelectOTP() != 1) {
            z = false;
        }
        this.autoSelectOtp = z;
    }

    public Drawable getCbDrawable(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getResources().getDrawable(i, context.getTheme());
        }
        return context.getResources().getDrawable(i);
    }

    /* access modifiers changed from: package-private */
    public void showTransparentView(final View view, Context context) {
        if (view != null) {
            view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.cb_fade_in));
            new Handler().postDelayed(new Runnable() {
                /* class com.payu.custombrowser.CustomBrowserMain.AnonymousClass1 */

                public void run() {
                    view.setVisibility(0);
                }
            }, 500);
        }
    }

    public void checkVisibilityCB(String str) {
        checkVisibilityCB(str, false);
    }

    public void checkVisibilityCB(final String str, final boolean z) {
        try {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    /* class com.payu.custombrowser.CustomBrowserMain.AnonymousClass2 */

                    public void run() {
                        String str;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("androidosversion", Build.VERSION.RELEASE);
                            jSONObject.put("androidmanufacturer", (Build.MANUFACTURER).toLowerCase());
                            jSONObject.put("model", (Build.MODEL).toLowerCase());
                            jSONObject.put("merchantid", Bank.keyAnalytics);
                            jSONObject.put("sdkname", Bank.sdkVersion);
                            jSONObject.put("cbname", "6.1.3");
                            if (z) {
                                if (CustomBrowserMain.this.mBankJS.has("set_dynamic_snooze")) {
                                    str = CustomBrowserMain.this.mBankJS.getString("set_dynamic_snooze") + "(" + jSONObject + ")";
                                } else {
                                    str = "";
                                }
                                CustomBrowserMain.this.cbWebView.loadUrl("javascript:".concat(String.valueOf(str)));
                                return;
                            }
                            jSONObject.put("bankname", str.toLowerCase());
                            CustomBrowserMain.this.cbWebView.loadUrl("javascript:" + CustomBrowserMain.this.mBankJS.getString("checkVisibilityCBCall") + "(" + jSONObject + ")");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void showSoftKeyboard(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        ((InputMethodManager) this.activity.getSystemService("input_method")).showSoftInput(view, 2);
    }

    /* access modifiers changed from: package-private */
    public void hideSoftKeyboard() {
        this.activity.getWindow().setSoftInputMode(3);
    }

    /* access modifiers changed from: protected */
    public void initAnalytics(String str) {
        this.mAnalytics = CBAnalytics.getInstance(this.activity.getApplicationContext(), "local_cache_analytics");
        deviceAnalytics(str, this.activity.getApplicationContext());
    }

    private void deviceAnalytics(String str, Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("payu_id", this.cbUtil.getCookie("PAYUID", context));
            jSONObject.put("txnid", Bank.transactionID);
            jSONObject.put("merchant_key", str);
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            jSONObject.put("device_os_version", sb.toString());
            jSONObject.put("device_resolution", this.cbUtil.getDeviceDensity(this.activity));
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("network_info", this.cbUtil.getNetworkStatus(this.activity.getApplicationContext()));
            jSONObject.put("sdk_version_name", Bank.sdkVersion);
            jSONObject.put("cb_version_name", "6.1.3");
            jSONObject.put("package_name", context.getPackageName());
            jSONObject.put("network_strength", this.cbUtil.getNetworkStrength(this.activity.getApplicationContext()));
            CBUtil.setVariableReflection("com.payu.magicretry.MagicRetryFragment", str, "analyticsKey");
            this.payuDeviceAnalytics = new PayuDeviceAnalytics(this.activity.getApplicationContext(), "cb_local_cache_device");
            this.payuDeviceAnalytics.log(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void addEventAnalytics(String str, String str2) {
        if (str2 != null) {
            try {
                if (!str2.trim().equalsIgnoreCase("")) {
                    this.mAnalytics.log(this.cbUtil.getLogMessage(this.activity.getApplicationContext(), str, str2.toLowerCase(), this.bankName, Bank.keyAnalytics, Bank.transactionID, this.pageType));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cbSetBankDrawable(String str) {
        if (this.drawable == null && str != null) {
            try {
                if (!str.equalsIgnoreCase("sbinet") && !str.equalsIgnoreCase("sbi")) {
                    if (!str.startsWith("sbi_")) {
                        if (!str.equalsIgnoreCase("icici") && !str.equalsIgnoreCase("icicinet") && !str.equalsIgnoreCase("icicicc")) {
                            if (!str.startsWith("icici_")) {
                                if (!str.equalsIgnoreCase("kotaknet") && !str.equalsIgnoreCase("kotak")) {
                                    if (!str.startsWith("kotak_")) {
                                        if (!str.equalsIgnoreCase("indus")) {
                                            if (!str.startsWith("indus_")) {
                                                if (!str.equalsIgnoreCase("hdfc") && !str.equalsIgnoreCase("hdfcnet")) {
                                                    if (!str.startsWith("hdfc_")) {
                                                        if (!str.equalsIgnoreCase("yesnet")) {
                                                            if (!str.startsWith("yes_")) {
                                                                if (!str.equalsIgnoreCase("sc")) {
                                                                    if (!str.startsWith("sc_")) {
                                                                        if (!str.equalsIgnoreCase("axisnet") && !str.equalsIgnoreCase("axis")) {
                                                                            if (!str.startsWith("axis_")) {
                                                                                if (!str.equalsIgnoreCase("amex")) {
                                                                                    if (!str.startsWith("amex_")) {
                                                                                        if (!str.equalsIgnoreCase("hdfcnet") && !str.equalsIgnoreCase("hdfc")) {
                                                                                            if (!str.startsWith("hdfc_")) {
                                                                                                if (!str.equalsIgnoreCase("ing")) {
                                                                                                    if (!str.startsWith("ing_")) {
                                                                                                        if (!str.equalsIgnoreCase("idbi")) {
                                                                                                            if (!str.startsWith("idbi_")) {
                                                                                                                if (!str.equalsIgnoreCase("citi")) {
                                                                                                                    if (!str.startsWith("citi_")) {
                                                                                                                        this.drawable = null;
                                                                                                                        return;
                                                                                                                    }
                                                                                                                }
                                                                                                                this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.citi);
                                                                                                                return;
                                                                                                            }
                                                                                                        }
                                                                                                        this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.idbi);
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.ing_logo);
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        this.drawable = this.cbUtil.getDrawableCB(this.activity, R.drawable.hdfc_bank);
                                                                                        return;
                                                                                    }
                                                                                }
                                                                                this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.cb_amex_logo);
                                                                                return;
                                                                            }
                                                                        }
                                                                        this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.axis_logo);
                                                                        return;
                                                                    }
                                                                }
                                                                this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.scblogo);
                                                                return;
                                                            }
                                                        }
                                                        this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.yesbank_logo);
                                                        return;
                                                    }
                                                }
                                                this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.hdfc_bank);
                                                return;
                                            }
                                        }
                                        this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.induslogo);
                                        return;
                                    }
                                }
                                this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.kotak);
                                return;
                            }
                        }
                        this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.icici);
                        return;
                    }
                }
                this.drawable = this.cbUtil.getDrawableCB(this.activity.getApplicationContext(), R.drawable.sbi);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void hideKeyboardForcefully() {
        View currentFocus = this.activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) this.activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void calculateCBHeight(View view) {
        view.measure(-2, -2);
        this.loading_height = view.getMeasuredHeight();
        int i = this.maxWebview;
        if (i != 0) {
            this.minWebview = i - this.loading_height;
        }
    }

    /* access modifiers changed from: package-private */
    public void calculateMaximumWebViewHeight() {
        try {
            if (this.maxWebview == 0 && this.bankName != null) {
                this.cbWebView.measure(-1, -1);
                this.cbWebView.requestLayout();
                this.maxWebview = this.cbWebView.getMeasuredHeight();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void maximiseWebviewHeight() {
        if (this.maxWebview == 0) {
            calculateMaximumWebViewHeight();
        }
        if (this.maxWebview != 0) {
            this.cbWebView.getLayoutParams().height = this.maxWebview;
            this.cbWebView.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void minimizeWebviewHeight() {
        if (this.maxWebview != 0) {
            this.cbWebView.getLayoutParams().height = this.minWebview;
            this.cbWebView.requestLayout();
        }
    }

    private ProgressDialog showProgress(Context context) {
        if (this.activity == null || !isAdded() || context == null || this.activity.isFinishing()) {
            return null;
        }
        LayoutInflater from = LayoutInflater.from(context);
        final Drawable[] drawableArr = {getCbDrawable(this.activity.getApplicationContext(), R.drawable.l_icon1), getCbDrawable(this.activity.getApplicationContext(), R.drawable.l_icon2), getCbDrawable(this.activity.getApplicationContext(), R.drawable.l_icon3), getCbDrawable(this.activity.getApplicationContext(), R.drawable.l_icon4)};
        View inflate = from.inflate((int) R.layout.cb_prog_dialog, (ViewGroup) null);
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.imageView);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_desc);
        if (this.isWebviewReloading) {
            textView.setText(this.activity.getText(R.string.cb_resuming_transaction));
            this.isWebviewReloading = false;
        } else {
            textView.setText(this.activity.getText(R.string.cb_please_wait));
        }
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 == null) {
            progressDialog2 = new ProgressDialog(context, R.style.cb_progress_dialog);
        }
        this.cbUtil.cancelTimer(this.timerProgress);
        this.timerProgress = new Timer();
        this.timerProgress.scheduleAtFixedRate(new TimerTask() {
            /* class com.payu.custombrowser.CustomBrowserMain.AnonymousClass3 */
            int i = -1;

            public synchronized void run() {
                if (CustomBrowserMain.this.activity != null) {
                    CustomBrowserMain.this.activity.runOnUiThread(new Runnable() {
                        /* class com.payu.custombrowser.CustomBrowserMain.AnonymousClass3.AnonymousClass1 */

                        public void run() {
                            if (CustomBrowserMain.this.activity != null) {
                                AnonymousClass3.this.i++;
                                if (AnonymousClass3.this.i >= drawableArr.length) {
                                    AnonymousClass3.this.i = 0;
                                }
                                imageView.setImageBitmap(null);
                                imageView.destroyDrawingCache();
                                imageView.refreshDrawableState();
                                imageView.setImageDrawable(drawableArr[AnonymousClass3.this.i]);
                            }
                        }
                    });
                }
            }
        }, 0, 500);
        progressDialog2.show();
        progressDialog2.setContentView(inflate);
        progressDialog2.setCancelable(true);
        progressDialog2.setCanceledOnTouchOutside(false);
        progressDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.payu.custombrowser.CustomBrowserMain.AnonymousClass4 */

            public void onDismiss(DialogInterface dialogInterface) {
                CustomBrowserMain.this.cbUtil.cancelTimer(CustomBrowserMain.this.timerProgress);
            }
        });
        return progressDialog2;
    }

    /* access modifiers changed from: package-private */
    public void progressBarVisibilityPayuChrome(int i, String str) {
        Activity activity2 = this.activity;
        if (activity2 != null && !activity2.isFinishing() && !isRemoving() && isAdded()) {
            if (i == 8 || i == 4) {
                ProgressDialog progressDialog2 = this.progressDialog;
                if (progressDialog2 != null) {
                    progressDialog2.dismiss();
                }
            } else if (i == 0 && !this.payuChromeLoaderDisabled && !this.isSnoozeWindowVisible) {
                this.progressDialog = showProgress(this.activity);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void communicationError() {
        progressBarVisibilityPayuChrome(8, "");
    }

    /* access modifiers changed from: package-private */
    public void startAnimation(int i) {
        Activity activity2 = this.activity;
        if (activity2 != null && !activity2.isFinishing() && !isRemoving() && isAdded()) {
            if (this.lastProgress > i) {
                this.cbWebPageProgressBar.setProgress(i);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this.cbWebPageProgressBar, "progress", i);
                ofInt.setDuration(50L);
                ofInt.setInterpolator(new AccelerateInterpolator());
                ofInt.start();
            } else {
                if (i <= 10) {
                    i = 10;
                }
                this.cbWebPageProgressBar.setProgress(i);
            }
            this.lastProgress = i;
        }
    }

    /* access modifiers changed from: package-private */
    public void hideCB() {
        maximiseWebviewHeight();
        this.frameState = 1;
        onHelpUnavailable();
    }

    public void registerBroadcast(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.mReceiver = broadcastReceiver;
        getActivity().registerReceiver(broadcastReceiver, intentFilter);
    }

    public void unregisterBroadcast(BroadcastReceiver broadcastReceiver) {
        if (this.mReceiver != null) {
            this.activity.unregisterReceiver(broadcastReceiver);
            this.mReceiver = null;
        }
    }

    public void onHelpUnavailable() {
        Activity activity2 = this.activity;
        if (activity2 != null && !activity2.isFinishing()) {
            this.activity.findViewById(R.id.parent).setVisibility(8);
        }
    }

    public void onBankError() {
        this.activity.findViewById(R.id.parent).setVisibility(8);
    }

    public void onHelpAvailable() {
        this.cbVisibleOnce = true;
        this.activity.findViewById(R.id.parent).setVisibility(0);
    }

    public boolean wasCBVisibleOnce() {
        return this.cbVisibleOnce;
    }

    public boolean isRetryURL(String str) {
        if (this.retryUrls.size() == 0) {
            return str.contains("https://secure.payu.in/_payment_options");
        }
        for (String contains : this.retryUrls) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setUrlString() {
        JSONObject jSONObject = this.mBankJS;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("postPaymentPgUrlList")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(this.mBankJS.getString("postPaymentPgUrlList").replace(" ", ""), "||");
                    while (stringTokenizer.hasMoreTokens()) {
                        this.backwardJourneyUrls.add(stringTokenizer.nextToken());
                    }
                }
                if (this.mBankJS.has("retryList")) {
                    StringTokenizer stringTokenizer2 = new StringTokenizer(this.mBankJS.getString("retryUrlList").replace(" ", ""), "||");
                    while (stringTokenizer2.hasMoreTokens()) {
                        this.retryUrls.add(stringTokenizer2.nextToken());
                    }
                }
            } catch (Exception e) {
                communicationError();
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void callTimer() {
        this.countDownTimer = new CountDownTimer(5000, 1000) {
            /* class com.payu.custombrowser.CustomBrowserMain.AnonymousClass5 */

            public void onTick(long j) {
            }

            public void onFinish() {
                if (CustomBrowserMain.this.activity != null) {
                    CustomBrowserMain.this.activity.runOnUiThread(new Runnable() {
                        /* class com.payu.custombrowser.CustomBrowserMain.AnonymousClass5.AnonymousClass1 */

                        public void run() {
                            if (CustomBrowserMain.this.activity != null && !CustomBrowserMain.this.activity.isFinishing() && CustomBrowserMain.this.isAdded()) {
                                CustomBrowserMain.this.onMerchantUrlFinished();
                            }
                        }
                    });
                }
            }
        }.start();
    }

    /* access modifiers changed from: package-private */
    public void onMerchantUrlFinished() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                /* class com.payu.custombrowser.CustomBrowserMain.AnonymousClass6 */

                public void run() {
                    if (CustomBrowserMain.this.activity != null && !CustomBrowserMain.this.activity.isFinishing() && CustomBrowserMain.this.isAdded()) {
                        if (CustomBrowserMain.this.cbOldFlow) {
                            Intent intent = new Intent();
                            intent.putExtra(CustomBrowserMain.this.getString(R.string.cb_result), CustomBrowserMain.this.merchantResponse);
                            intent.putExtra(CustomBrowserMain.this.getString(R.string.cb_payu_response), CustomBrowserMain.this.payuReponse);
                            if (CustomBrowserMain.this.isSuccessTransaction.booleanValue()) {
                                if (CustomBrowserMain.this.storeOneClickHash == 1) {
                                    new StoreMerchantHashTask().execute(CustomBrowserMain.this.payuReponse);
                                }
                                CustomBrowserMain.this.activity.setResult(-1, intent);
                            } else {
                                CustomBrowserMain.this.activity.setResult(0, intent);
                            }
                        } else if (CustomBrowserMain.this.isSuccessTransaction.booleanValue()) {
                            if (CustomBrowserMain.this.customBrowserConfig.getStoreOneClickHash() == 1) {
                                new StoreMerchantHashTask().execute(CustomBrowserMain.this.payuReponse);
                            }
                            if (CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() != null) {
                                CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().onPaymentSuccess(CustomBrowserMain.this.payuReponse, CustomBrowserMain.this.merchantResponse);
                            } else {
                                L.v("PayuError", "No PayUCustomBrowserCallback found, please assign a callback: com.payu.custombrowser.PayUCustomBrowserCallback.setPayuCustomBrowserCallback(PayUCustomBrowserCallback payuCustomBrowserCallback)");
                            }
                        } else if (CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() != null) {
                            CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().onPaymentFailure(CustomBrowserMain.this.payuReponse, CustomBrowserMain.this.merchantResponse);
                        } else {
                            L.v("PayuError", "No PayUCustomBrowserCallback found, please assign a callback: com.payu.custombrowser.PayUCustomBrowserCallback.setPayuCustomBrowserCallback(PayUCustomBrowserCallback payuCustomBrowserCallback)");
                        }
                        CustomBrowserMain.this.activity.finish();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void cancelTransactionNotification() {
        NotificationManager notificationManager = (NotificationManager) this.activity.getSystemService("notification");
        notificationManager.cancel(CBConstant.TRANSACTION_STATUS_NOTIFICATION_ID);
        notificationManager.cancel(CBConstant.SNOOZE_NOTIFICATION_ID);
    }

    public class CBMainViewOnTouchListener implements View.OnTouchListener {
        int height = 0;
        float initialY;
        boolean isTouch = true;

        public CBMainViewOnTouchListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (CustomBrowserMain.this.nbhelpVisible) {
                return false;
            }
            CustomBrowserMain.this.maximiseWebviewHeight();
            if (!this.isTouch) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (CustomBrowserMain.this.cbSlideBarView.getVisibility() == 0) {
                CustomBrowserMain.this.cbSlideBarView.setClickable(false);
                CustomBrowserMain.this.cbSlideBarView.setOnTouchListener(null);
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) this.height, 0.0f);
                translateAnimation.setDuration(500);
                translateAnimation.setFillBefore(true);
                view.startAnimation(translateAnimation);
                CustomBrowserMain.this.cbBaseView.setVisibility(0);
                this.isTouch = false;
                new Handler().postDelayed(new Runnable() {
                    /* class com.payu.custombrowser.CustomBrowserMain.CBMainViewOnTouchListener.AnonymousClass1 */

                    public void run() {
                        CustomBrowserMain.this.cbSlideBarView.setVisibility(8);
                    }
                }, 20);
                new Handler().postDelayed(new Runnable() {
                    /* class com.payu.custombrowser.CustomBrowserMain.CBMainViewOnTouchListener.AnonymousClass2 */

                    public void run() {
                        CBMainViewOnTouchListener cBMainViewOnTouchListener = CBMainViewOnTouchListener.this;
                        cBMainViewOnTouchListener.isTouch = true;
                        CustomBrowserMain.this.frameState = 2;
                        if (CustomBrowserMain.this.cbTransparentView != null && CustomBrowserMain.this.activity != null && !CustomBrowserMain.this.activity.isFinishing()) {
                            CustomBrowserMain.this.showTransparentView(CustomBrowserMain.this.cbTransparentView, CustomBrowserMain.this.activity);
                        }
                    }
                }, 500);
            } else if (actionMasked == 0) {
                this.initialY = motionEvent.getY();
            } else if (actionMasked == 1) {
                float y = motionEvent.getY();
                if (this.initialY < y && CustomBrowserMain.this.cbBaseView.getVisibility() == 0 && y - this.initialY > 0.0f) {
                    this.height = view.getHeight();
                    TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (view.getHeight() - 30));
                    translateAnimation2.setDuration(500);
                    translateAnimation2.setFillBefore(false);
                    translateAnimation2.setFillEnabled(true);
                    translateAnimation2.setZAdjustment(1);
                    view.startAnimation(translateAnimation2);
                    if (CustomBrowserMain.this.cbTransparentView != null) {
                        CustomBrowserMain.this.cbTransparentView.setVisibility(8);
                    }
                    this.isTouch = false;
                    this.isTouch = true;
                    new Handler().postDelayed(new Runnable() {
                        /* class com.payu.custombrowser.CustomBrowserMain.CBMainViewOnTouchListener.AnonymousClass3 */

                        public void run() {
                            CustomBrowserMain.this.frameState = 1;
                            CustomBrowserMain.this.cbBaseView.setVisibility(8);
                            CustomBrowserMain.this.cbSlideBarView.setVisibility(0);
                        }
                    }, 400);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void setTransactionStatusReceived(boolean z) {
        this.isTransactionStatusReceived = z;
    }

    /* access modifiers changed from: protected */
    public boolean getTransactionStatusReceived() {
        return this.isTransactionStatusReceived;
    }

    /* access modifiers changed from: protected */
    public void postToPaytxn() {
        if (this.payuPG) {
            Thread thread = new Thread(new Runnable() {
                /* class com.payu.custombrowser.CustomBrowserMain.AnonymousClass7 */

                public void run() {
                    try {
                        if (CustomBrowserMain.this.cbUtil.getHttpsConn("https://secure.payu.in/paytxn", null, -1, CustomBrowserMain.this.cbUtil.getCookieList(CustomBrowserMain.this.getActivity().getApplicationContext(), "https://secure.payu.in")).getResponseCode() != 200) {
                            Log.d("PayU", "BackButtonClick - UnSuccessful post to Paytxn");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.setPriority(10);
            thread.start();
        }
    }

    public class ViewOnClickListener implements View.OnClickListener {
        public ViewOnClickListener() {
        }

        public void onClick(View view) {
            if (view.getId() == R.id.bank_logo) {
                if (CustomBrowserMain.this.mCounter == 0) {
                    CustomBrowserMain.this.mHandler.postDelayed(CustomBrowserMain.this.mResetCounter, 3000);
                }
                CustomBrowserMain.this.mCounter++;
                if (CustomBrowserMain.this.mCounter == 5) {
                    CustomBrowserMain.this.mHandler.removeCallbacks(CustomBrowserMain.this.mResetCounter);
                    CustomBrowserMain customBrowserMain = CustomBrowserMain.this;
                    customBrowserMain.mCounter = 0;
                    Toast.makeText(customBrowserMain.activity, "Version Name: 6.1.3", 0).show();
                }
            }
        }
    }
}
