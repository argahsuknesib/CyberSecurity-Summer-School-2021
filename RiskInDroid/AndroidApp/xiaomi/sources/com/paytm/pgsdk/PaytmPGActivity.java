package com.paytm.pgsdk;

import _m_j.cqp;
import _m_j.cqq;
import _m_j.cqr;
import _m_j.cqs;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class PaytmPGActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected volatile ProgressBar f5402O000000o;
    private volatile O000000o O00000Oo;
    private boolean O00000o;
    private boolean O00000o0;
    public Dialog mDlg;
    public volatile Bundle mParams;
    public volatile PaytmWebView mWV;
    public boolean mbChecksumGenerated;
    public boolean mbIsCancellingRequest;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    public synchronized void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (O000000o()) {
            O00000Oo();
            return;
        }
        finish();
        cqq cqq = cqp.O000000o().O00000oO;
        if (cqq != null) {
            cqq.O000000o("Some error occured while initializing UI of Payment Gateway Activity");
        }
    }

    private synchronized boolean O000000o() {
        try {
            if (getIntent() != null) {
                this.O00000o0 = getIntent().getBooleanExtra("HIDE_HEADER", false);
                this.O00000o = getIntent().getBooleanExtra("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", false);
            }
            cqs.O000000o("Hide Header " + this.O00000o0);
            cqs.O000000o("Initializing the UI of Transaction Page...");
            RelativeLayout relativeLayout = new RelativeLayout(this);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            relativeLayout2.setId(1);
            relativeLayout2.setBackgroundColor(Color.parseColor("#bdbdbd"));
            Button button = new Button(this, null, 16842825);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            layoutParams.leftMargin = (int) (getResources().getDisplayMetrics().density * 5.0f);
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.paytm.pgsdk.PaytmPGActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    cqs.O000000o("User pressed back button which is present in Header Bar.");
                    PaytmPGActivity.this.cancelTransaction();
                }
            });
            button.setLayoutParams(layoutParams);
            button.setText("Cancel");
            TextView textView = new TextView(this);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            textView.setLayoutParams(layoutParams2);
            textView.setTextColor(-16777216);
            textView.setText("Paytm Payments");
            relativeLayout2.addView(button);
            relativeLayout2.addView(textView);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(3, relativeLayout2.getId());
            relativeLayout3.setLayoutParams(layoutParams3);
            Bundle bundle = this.mParams;
            this.mWV = new PaytmWebView(this);
            this.mWV.setVisibility(8);
            this.mWV.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f5402O000000o = new ProgressBar(this, null, 16842873);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            this.f5402O000000o.setLayoutParams(layoutParams4);
            relativeLayout3.addView(this.mWV);
            relativeLayout3.addView(this.f5402O000000o);
            relativeLayout.addView(relativeLayout2);
            relativeLayout.addView(relativeLayout3);
            if (this.O00000o0) {
                relativeLayout2.setVisibility(8);
            }
            requestWindowFeature(1);
            setContentView(relativeLayout);
            cqs.O000000o("Initialized UI of Transaction Page.");
        } catch (Exception e) {
            cqs.O000000o("Some exception occurred while initializing UI.");
            cqs.O000000o(e);
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public synchronized void onDestroy() {
        super.onDestroy();
        try {
            if (this.O00000Oo != null) {
                this.O00000Oo.cancel(true);
            }
            cqp.O000000o().O00000o();
        } catch (Exception e) {
            cqp.O000000o().O00000o();
            cqs.O000000o("Some exception occurred while destroying the PaytmPGActivity.");
            cqs.O000000o(e);
        }
    }

    class O000000o extends AsyncTask<String, Void, String> {
        private O000000o() {
        }

        /* synthetic */ O000000o(PaytmPGActivity paytmPGActivity, byte b) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: O000000o */
        public synchronized String doInBackground(String... strArr) {
            String str;
            str = "";
            URLConnection uRLConnection = null;
            try {
                URL url = new URL(strArr[0]);
                cqs.O000000o("URL is " + url.toString());
                uRLConnection = url.openConnection();
                cqs.O000000o("New Connection is created.");
                if (URLUtil.isHttpsUrl(url.toString())) {
                    cqs.O000000o("Https url");
                    cqs.O000000o("Setting SSLSocketFactory to connection...");
                    ((HttpsURLConnection) uRLConnection).setSSLSocketFactory(new cqr(PaytmPGActivity.this, cqp.O000000o().O00000Oo));
                    cqs.O000000o("SSLSocketFactory is set to connection.");
                }
                uRLConnection.setDoOutput(true);
                ((HttpURLConnection) uRLConnection).setRequestMethod("POST");
                String O000000o2 = cqs.O000000o(PaytmPGActivity.this.mParams);
                if (O000000o2 != null && O000000o2.length() > 0) {
                    cqs.O000000o("Getting the output stream to post");
                    PrintWriter printWriter = new PrintWriter(uRLConnection.getOutputStream());
                    cqs.O000000o("posting......");
                    printWriter.print(O000000o2);
                    printWriter.close();
                    cqs.O000000o("posted parameters and closing output stream");
                    int responseCode = ((HttpURLConnection) uRLConnection).getResponseCode();
                    String responseMessage = ((HttpURLConnection) uRLConnection).getResponseMessage();
                    cqs.O000000o("Response code is ".concat(String.valueOf(responseCode)));
                    cqs.O000000o("Response Message is ".concat(String.valueOf(responseMessage)));
                    if (responseCode == 200) {
                        cqs.O000000o("Getting the input stream to read response");
                        Scanner scanner = new Scanner(uRLConnection.getInputStream());
                        cqs.O000000o("reading......");
                        while (scanner.hasNextLine()) {
                            str = str + scanner.nextLine();
                        }
                        scanner.close();
                        cqs.O000000o("read response and closing input stream");
                    }
                }
            } catch (Exception e) {
                cqs.O000000o("Some exception occurred while making client authentication.");
                cqs.O000000o(e);
            }
            if (uRLConnection != null) {
                try {
                    ((HttpURLConnection) uRLConnection).disconnect();
                } catch (Exception e2) {
                    cqs.O000000o(e2);
                }
            }
            cqs.O000000o("connection is disconnected");
            return str;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
            return;
         */
        /* renamed from: O000000o */
        public synchronized void onPostExecute(String str) {
            if (str != null) {
                try {
                    if (!str.equalsIgnoreCase("")) {
                        cqs.O000000o("Response is ".concat(String.valueOf(str)));
                        if (PaytmPGActivity.this.extractJSON(str)) {
                            PaytmPGActivity.this.mbChecksumGenerated = true;
                            PaytmPGActivity.this.mWV.setVisibility(0);
                            PaytmPGActivity.this.mWV.postUrl(cqp.O000000o().O00000o, cqs.O00000Oo(PaytmPGActivity.this.mParams).getBytes());
                            PaytmPGActivity.this.mWV.requestFocus(130);
                            return;
                        }
                        PaytmPGActivity.this.finish();
                        cqq cqq = cqp.O000000o().O00000oO;
                        if (cqq != null) {
                            cqq.O00000Oo("Client authentication failed. Please try again later.");
                        }
                    }
                } catch (Exception e) {
                    PaytmPGActivity.this.finish();
                    cqq cqq2 = cqp.O000000o().O00000oO;
                    if (cqq2 != null) {
                        cqq2.O000000o("Some UI error occured in WebView of Payment Gateway Activity");
                    }
                    cqs.O000000o("Some exception occurred while posting data to PG Server.");
                    cqs.O000000o(e);
                    return;
                }
            }
            PaytmPGActivity.this.finish();
            cqq cqq3 = cqp.O000000o().O00000oO;
            if (cqq3 != null) {
                cqq3.O00000Oo("Client authentication failed due to server error. Please try again later.");
            }
        }
    }

    public synchronized boolean extractJSON(String str) {
        boolean z;
        z = false;
        try {
            cqs.O000000o("Parsing JSON");
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            cqs.O000000o("Appending Key Value pairs");
            cqs.O000000o("Send All Checksum Response Parameters to PG " + this.O00000o);
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                String trim = next.trim();
                cqs.O000000o(trim + " = " + string);
                if (trim.equals("CHECKSUMHASH")) {
                    this.mParams.putString(trim, string);
                } else if (this.O00000o) {
                    this.mParams.putString(trim, string);
                }
                if (trim.equals("payt_STATUS") && string.equals("1")) {
                    z = true;
                }
            }
        } catch (Exception e) {
            cqs.O000000o("Some exception occurred while extracting the checksum from CAS Response.");
            cqs.O000000o(e);
        }
        return z;
    }

    private synchronized void O00000Oo() {
        cqs.O000000o("Starting the Process...");
        if (!(getIntent() == null || getIntent().getBundleExtra("Parameters") == null)) {
            this.mParams = getIntent().getBundleExtra("Parameters");
            if (this.mParams != null && this.mParams.size() > 0) {
                cqs.O000000o("Starting the Client Authentication...");
                this.O00000Oo = new O000000o(this, (byte) 0);
                if (cqp.O000000o() != null) {
                    this.mWV.setVisibility(0);
                    this.mWV.postUrl(cqp.O000000o().O00000o, cqs.O00000Oo(this.mParams).getBytes());
                    this.mWV.requestFocus(130);
                }
            }
        }
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        cqs.O000000o("User pressed key and key code is ".concat(String.valueOf(i)));
        if (i == 4) {
            cqs.O000000o("User pressed hard key back button");
            cancelTransaction();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public synchronized void cancelTransaction() {
        if (!this.mbIsCancellingRequest) {
            cqs.O000000o("Displaying Confirmation Dialog");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Cancel Transaction");
            builder.setMessage("Are you sure you want to cancel transaction");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                /* class com.paytm.pgsdk.PaytmPGActivity.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    PaytmPGActivity.this.onBackPressed();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                /* class com.paytm.pgsdk.PaytmPGActivity.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    PaytmPGActivity.this.mDlg.dismiss();
                }
            });
            this.mDlg = builder.create();
            this.mDlg.show();
        }
    }

    public void onBackPressed() {
        cqp.O000000o().O00000oO.O00000Oo();
        super.onBackPressed();
    }
}
