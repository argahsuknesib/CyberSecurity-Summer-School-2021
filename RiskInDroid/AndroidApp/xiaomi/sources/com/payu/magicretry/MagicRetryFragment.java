package com.payu.magicretry;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.payu.magicretry.Helpers.L;
import com.payu.magicretry.Helpers.SharedPreferenceUtil;
import com.payu.magicretry.Helpers.Util;
import com.payu.magicretry.WaitingDots.DotsTextView;
import com.payu.magicretry.analytics.CBAnalytics;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicRetryFragment extends Fragment implements View.OnClickListener {
    private static Context context;
    private static boolean disableMagicRetry = false;
    private static List<String> whiteListedUrls = new ArrayList();
    private final String ANALYTICS_CLICK_MR_EVENT = "click_m_retry";
    private final String ANALYTICS_SHOW_MR_EVENT = "show_m_retry";
    private boolean DEBUG = true;
    private ActivityCallback activityCallbackHandler;
    private boolean errorWasReceived = true;
    private boolean fromOnReceivedError = false;
    private boolean isWhiteListingEnabled = true;
    private CBAnalytics mAnalytics;
    private WebView mWebView;
    private ProgressBar magicProgress;
    private LinearLayout magicRetryLayoutParent;
    private String reloadUrl;
    private ImageView retryButton;
    private String txnID = "";
    private Map<String, String> urlListWithPostData = new HashMap();
    private DotsTextView waitingDots;
    private LinearLayout waitingDotsLayoutParent;

    public interface ActivityCallback {
        void hideMagicRetry();

        void showMagicRetry();
    }

    public void onPageStarted(WebView webView, String str) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        context = getActivity().getBaseContext();
        this.txnID = getArguments().getString("transaction_id");
        View inflate = layoutInflater.inflate((int) R.layout.magicretry_fragment, viewGroup, false);
        initViewElements(inflate);
        ArrayList arrayList = new ArrayList();
        arrayList.add("https://secure.payu.in/_payment");
        arrayList.add("https://secure.payu.in/_secure_payment");
        arrayList.add("https://www.payumoney.com/txn/#/user/");
        arrayList.add("https://mpi.onlinesbi.com/electraSECURE/vbv/MPIEntry.jsp");
        arrayList.add("https://netsafe.hdfcbank.com/ACSWeb/com.enstage.entransact.servers.AccessControlServerSSL");
        arrayList.add("https://www.citibank.co.in/acspage/cap_nsapi.so");
        arrayList.add("https://acs.icicibank.com/acspage/cap");
        arrayList.add("https://secure.payu.in/_payment");
        arrayList.add("https://www.citibank.co.in/servlets/TransReq");
        arrayList.add("https://netsafe.hdfcbank.com/ACSWeb/com.enstage.entransact.servers.AccessControlServerSSL");
        arrayList.add("https://netsafe.hdfcbank.com/ACSWeb/jsp/MerchantPost.jsp");
        arrayList.add("https://netsafe.hdfcbank.com/ACSWeb/jsp/SCode.jsp");
        arrayList.add("https://netsafe.hdfcbank.com/ACSWeb/com.enstage.entransact.servers.AccessControlServerSSL");
        arrayList.add("https://netsafe.hdfcbank.com/ACSWeb/jsp/payerAuthOptions.jsp");
        arrayList.add("https://cardsecurity.enstage.com/ACSWeb/EnrollWeb/KotakBank/server/AccessControlServer");
        arrayList.add("https://cardsecurity.enstage.com/ACSWeb/EnrollWeb/KotakBank/server/OtpServer");
        arrayList.add("https://www.citibank.co.in/acspage/cap_nsapi.so");
        arrayList.add("https://acs.icicibank.com/acspage/cap");
        arrayList.add("https://secureonline.idbibank.com/ACSWeb/EnrollWeb/IDBIBank/server/AccessControlServer");
        arrayList.add("https://vpos.amxvpos.com/vpcpay");
        if (getActivity() != null) {
            initAnalytics(getActivity());
        }
        return inflate;
    }

    public void initAnalytics(Activity activity) {
        this.mAnalytics = CBAnalytics.getInstance(activity);
    }

    private void initViewElements(View view) {
        this.magicProgress = (ProgressBar) view.findViewById(R.id.magic_reload_progress);
        this.retryButton = (ImageView) view.findViewById(R.id.retry_btn);
        if (Build.VERSION.SDK_INT >= 11) {
            this.waitingDots = (DotsTextView) view.findViewById(R.id.waiting_dots);
        }
        this.waitingDotsLayoutParent = (LinearLayout) view.findViewById(R.id.waiting_dots_parent);
        this.magicRetryLayoutParent = (LinearLayout) view.findViewById(R.id.magic_retry_parent);
        this.magicRetryLayoutParent.setVisibility(0);
        this.waitingDotsLayoutParent.setVisibility(8);
        this.retryButton.setOnClickListener(this);
    }

    public void setWebView(WebView webView) {
        this.mWebView = webView;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.retry_btn) {
            performReload();
        }
    }

    public void onAttach(Context context2) {
        super.onAttach(context2);
        try {
            this.activityCallbackHandler = (ActivityCallback) context2;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context2.toString() + " must implement OnHeadlineSelectedListener");
        }
    }

    private void performReload() {
        Log.v("#### PAYU", "PayUWebViewClient.java Reloading URL: " + this.mWebView.getUrl());
        this.reloadUrl = this.mWebView.getUrl();
        if (this.urlListWithPostData.size() <= 0 || !this.urlListWithPostData.containsKey(this.mWebView.getUrl())) {
            if (Util.isNetworkAvailable(context)) {
                this.fromOnReceivedError = false;
                this.mWebView.reload();
                this.mAnalytics.callMixPanel("click_m_retry", "", this.txnID);
                showMagicReloadProgressDialog();
                return;
            }
            Util.showNetworkNotAvailableError(context);
        } else if (Util.isNetworkAvailable(context)) {
            this.fromOnReceivedError = false;
            WebView webView = this.mWebView;
            webView.postUrl(webView.getUrl(), this.urlListWithPostData.get(this.mWebView.getUrl()).getBytes());
            this.mAnalytics.callMixPanel("click_m_retry", "", this.txnID);
            showMagicReloadProgressDialog();
        } else {
            Util.showNetworkNotAvailableError(context);
        }
    }

    public void setUrlListWithPostData(Map<String, String> map) {
        this.urlListWithPostData = map;
    }

    private void showMagicReloadProgressDialog() {
        this.magicRetryLayoutParent.setVisibility(8);
        this.waitingDotsLayoutParent.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
            this.waitingDots.showAndPlay();
        } else {
            this.magicProgress.setVisibility(0);
        }
    }

    private void hideMagicReloadProgressDialog() {
        this.waitingDotsLayoutParent.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 11) {
            this.waitingDots.hideAndStop();
        } else {
            this.magicProgress.setVisibility(4);
        }
        this.magicRetryLayoutParent.setVisibility(0);
    }

    public void onPageFinished(WebView webView, String str) {
        if (!this.fromOnReceivedError && this.errorWasReceived && this.reloadUrl != null) {
            this.activityCallbackHandler.hideMagicRetry();
            this.errorWasReceived = true;
        }
    }

    public void onReceivedError(WebView webView, String str) {
        if (!disableMagicRetry) {
            L.v("#### PAYU", "WebView URL: " + webView.getUrl() + " FAILING URL: " + str);
            hideItems();
            if (isWhiteListedURL(str)) {
                this.fromOnReceivedError = true;
                this.activityCallbackHandler.showMagicRetry();
                this.mAnalytics.callMixPanel("show_m_retry", "", this.txnID);
                this.reloadUrl = webView.getUrl();
                return;
            }
            this.reloadUrl = null;
        }
    }

    private boolean isWhiteListedURL(String str) {
        if (!this.isWhiteListingEnabled) {
            return true;
        }
        for (String contains : whiteListedUrls) {
            if (str.contains(contains)) {
                L.v("#### PAYU", "WHITELISTED URL FOUND.. SHOWING MAGIC RETRY: ".concat(String.valueOf(str)));
                return true;
            }
        }
        return false;
    }

    private void hideItems() {
        hideMagicReloadProgressDialog();
    }

    public static void disableMagicRetry(boolean z) {
        disableMagicRetry = z;
    }

    public static void setWhitelistedURL(List<String> list) {
        whiteListedUrls.clear();
        L.v("#### PAYU", "MR Cleared whitelisted urls, length: " + whiteListedUrls.size());
        whiteListedUrls.addAll(list);
        L.v("#### PAYU", "MR Updated whitelisted urls, length: " + whiteListedUrls.size());
    }

    public void isWhiteListingEnabled(boolean z) {
        this.isWhiteListingEnabled = z;
    }

    public static void processAndAddWhiteListedUrls(String str) {
        if (str != null && !str.equalsIgnoreCase("")) {
            String[] split = str.split("\\|");
            for (String valueOf : split) {
                L.v("#### PAYU", "Split Url: ".concat(String.valueOf(valueOf)));
            }
            if (split != null && split.length > 0) {
                setWhitelistedURL(Arrays.asList(split));
            }
            L.v("#### PAYU", "Whitelisted URLs from JS: ".concat(String.valueOf(str)));
        }
    }

    public static void setMRData(String str) {
        if (str == null) {
            SharedPreferenceUtil.addBooleanToSharedPreference(context, "MR_SETTINGS", "MR_ENABLED", false);
            disableMagicRetry(true);
            L.v("#### PAYU", "MR SP Setting 1) Disable MR: " + disableMagicRetry);
            SharedPreferenceUtil.addStringToSharedPreference(context, "MR_SETTINGS", "MR_WHITELISTED_URLS", "");
            setWhitelistedURL(new ArrayList());
            L.v("#### PAYU", "MR SP Setting 2) Clear white listed urls, length: " + whiteListedUrls.size());
        } else {
            SharedPreferenceUtil.addBooleanToSharedPreference(context, "MR_SETTINGS", "MR_ENABLED", true);
            disableMagicRetry(false);
            L.v("#### PAYU", "MR SP Setting 1) Disable MR: " + disableMagicRetry);
            SharedPreferenceUtil.addStringToSharedPreference(context, "MR_SETTINGS", "MR_WHITELISTED_URLS", str);
            processAndAddWhiteListedUrls(str);
            L.v("#### PAYU", "MR SP Setting 2) Update white listed urls, length: " + whiteListedUrls.size());
        }
        L.v("#### PAYU", "MR DATA UPDATED IN SHARED PREFERENCES");
    }

    public void initMRSettingsFromSharedPreference(Context context2) {
        disableMagicRetry(!SharedPreferenceUtil.getBooleanFromSharedPreference(context2, "MR_SETTINGS", "MR_ENABLED", !disableMagicRetry));
        processAndAddWhiteListedUrls(SharedPreferenceUtil.getStringFromSharedPreference(context2, "MR_SETTINGS", "MR_WHITELISTED_URLS", ""));
    }
}
