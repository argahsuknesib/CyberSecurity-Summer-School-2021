package com.payu.sdk;

import _m_j.cbe;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.mi.global.shop.buy.payu.PayU;
import com.payu.custombrowser.Bank;
import com.payu.custombrowser.PayUWebChromeClient;
import com.payu.custombrowser.PayUWebViewClient;
import com.xiaomi.smarthome.R;
import org.apache.http.util.EncodingUtils;

@SuppressLint({"ValidFragment"})
public class ProcessPaymentActivity extends FragmentActivity {
    boolean cancelTransaction = false;
    private BroadcastReceiver mReceiver = null;
    private WebView webView;

    public void onCreate(Bundle bundle) {
        String str = null;
        if (bundle != null) {
            super.onCreate(null);
            finish();
        } else {
            super.onCreate(bundle);
        }
        setContentView((int) R.layout.shop_activity_process_payment);
        this.webView = (WebView) findViewById(R.id.webview);
        this.webView.getSettings().setCacheMode(2);
        try {
            Class.forName("com.payu.custombrowser.Bank");
            BankFragment bankFragment = new BankFragment();
            bankFragment.setParent(findViewById(R.id.parent));
            bankFragment.setTransOverlay(findViewById(R.id.trans_overlay));
            Bundle bundle2 = new Bundle();
            bundle2.putInt("webView", R.id.webview);
            bundle2.putInt("tranLayout", R.id.trans_overlay);
            bundle2.putInt("mainLayout", R.id.r_layout);
            String[] split = getIntent().getExtras().getString("postData").split("&");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str2 = split[i];
                if (str2.contains("txnid")) {
                    str = str2.split("=")[1];
                    break;
                }
                i++;
            }
            if (str == null) {
                str = String.valueOf(System.currentTimeMillis());
            }
            bundle2.putString("txnid", str);
            if (getIntent().getExtras().containsKey("showCustom")) {
                bundle2.putBoolean("showCustom", getIntent().getBooleanExtra("showCustom", false));
            }
            bundle2.putBoolean("showCustom", true);
            bankFragment.setArguments(bundle2);
            findViewById(R.id.parent).bringToFront();
            try {
                getSupportFragmentManager().O000000o().O000000o((int) R.anim.shop_fade_in, (int) R.anim.cb_face_out).O000000o((int) R.id.parent, bankFragment).O00000Oo();
            } catch (Exception e) {
                e.printStackTrace();
                finish();
            }
            this.webView.setWebChromeClient(new PayUWebChromeClient(bankFragment));
            this.webView.setWebViewClient(new PayUWebViewClient(bankFragment, PayU.f4867O000000o));
        } catch (ClassNotFoundException unused) {
            this.webView.getSettings().setSupportMultipleWindows(true);
            this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.webView.addJavascriptInterface(new Object() {
                /* class com.payu.sdk.ProcessPaymentActivity.AnonymousClass1 */

                @JavascriptInterface
                public void onSuccess() {
                    onSuccess("");
                }

                @JavascriptInterface
                public void onSuccess(final String str) {
                    ProcessPaymentActivity.this.runOnUiThread(new Runnable() {
                        /* class com.payu.sdk.ProcessPaymentActivity.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            Intent intent = new Intent();
                            intent.putExtra("result", str);
                            ProcessPaymentActivity.this.setResult(-1, intent);
                            ProcessPaymentActivity.this.finish();
                        }
                    });
                }

                @JavascriptInterface
                public void onFailure() {
                    onFailure("");
                }

                @JavascriptInterface
                public void onFailure(final String str) {
                    ProcessPaymentActivity.this.runOnUiThread(new Runnable() {
                        /* class com.payu.sdk.ProcessPaymentActivity.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            Intent intent = new Intent();
                            intent.putExtra("result", str);
                            ProcessPaymentActivity.this.setResult(0, intent);
                            ProcessPaymentActivity.this.finish();
                        }
                    });
                }
            }, "PayU");
            this.webView.setWebChromeClient(new WebChromeClient() {
                /* class com.payu.sdk.ProcessPaymentActivity.AnonymousClass2 */
            });
            this.webView.setWebViewClient(new WebViewClient());
        }
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.postUrl(Constants.PAYMENT_URL, EncodingUtils.getBytes(getIntent().getExtras().getString("postData"), "base64"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public void onBackPressed() {
        boolean z;
        if (this.cancelTransaction) {
            this.cancelTransaction = false;
            Intent intent = new Intent();
            intent.putExtra("result", "Transaction canceled due to back pressed!");
            setResult(0, intent);
            super.onBackPressed();
            return;
        }
        try {
            Bundle bundle = getPackageManager().getApplicationInfo(getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
            if (bundle.containsKey("payu_disable_back") && bundle.getBoolean("payu_disable_back")) {
                z = true;
                if (z) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setCancelable(false);
                    builder.setMessage("Do you really want to cancel the transaction ?");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        /* class com.payu.sdk.ProcessPaymentActivity.AnonymousClass3 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            ProcessPaymentActivity.this.cancelTransaction = true;
                            dialogInterface.dismiss();
                            ProcessPaymentActivity.this.onBackPressed();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        /* class com.payu.sdk.ProcessPaymentActivity.AnonymousClass4 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();
                    return;
                }
                return;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        z = false;
        if (z) {
        }
    }

    public void onResume() {
        super.onResume();
        cbe.O00000Oo(getClass().getSimpleName());
    }

    public void onPause() {
        super.onPause();
        cbe.O000000o();
    }

    public void onDestroy() {
        super.onDestroy();
        this.webView.clearCache(true);
        this.webView.clearHistory();
        this.webView.destroy();
    }

    public static class BankFragment extends Bank {
        private BroadcastReceiver mReceiver;
        private View parent;
        private View transOverlay;

        public void setParent(View view) {
            this.parent = view;
        }

        public void setTransOverlay(View view) {
            this.transOverlay = view;
        }

        public void registerBroadcast(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            this.mReceiver = broadcastReceiver;
            getContext().registerReceiver(broadcastReceiver, intentFilter);
        }

        public void unregisterBroadcast(BroadcastReceiver broadcastReceiver) {
            if (this.mReceiver != null) {
                getContext().unregisterReceiver(this.mReceiver);
                this.mReceiver = null;
            }
        }

        public void onHelpUnavailable() {
            this.parent.setVisibility(8);
            this.transOverlay.setVisibility(8);
        }

        public void onBankError() {
            this.parent.setVisibility(8);
            this.transOverlay.setVisibility(8);
        }

        public void onHelpAvailable() {
            this.parent.setVisibility(0);
        }
    }
}
