package com.payu.custombrowser.services;

import _m_j.ft;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import androidx.appcompat.app.NotificationCompat;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import com.payu.custombrowser.Bank;
import com.payu.custombrowser.CBActivity;
import com.payu.custombrowser.bean.CustomBrowserConfig;
import com.payu.custombrowser.util.CBConstant;
import com.payu.custombrowser.util.CBUtil;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Random;
import javax.net.ssl.SSLException;
import org.json.JSONException;
import org.json.JSONObject;

public class SnoozeService extends Service {
    public static int IMAGE_DOWNLOAD_TIME_OUT;
    private final String CURRENT_URL = "currentUrl";
    public int EXPONENTIAL_BACKOFF_TIME_THRESHOLD = 60000;
    String MERCHANT_CHECKOUT_ACTIVITY = "merchantCheckoutActivity";
    private final String SNOOZE_BROAD_CAST_MESSAGE = "snooze_broad_cast_message";
    private final String SNOOZE_GET_WEBVIEW_STATUS_INTENT_ACTION = "webview_status_action";
    public int SNOOZE_SERVICE_TTL = 1800000;
    private final int TRACK_WEB_VIEW_TIME_INTERVAL = 500;
    public String broadCastingMessage = "";
    public CBUtil cbUtil;
    private String currentUrl = "";
    private CustomBrowserConfig customBrowserConfig;
    public long endTime;
    public int exponentialBackOffTime = 1000;
    public Handler handler;
    public long imageDownloadTime;
    public boolean isImageDownloadTimedOut;
    public boolean isNotificationIntentPrepared;
    public boolean isServiceAlive = true;
    public boolean isWebViewAlive;
    public boolean isWebViewIntentPrepared;
    public CountDownTimer killSnoozeServiceCounter;
    private ServiceHandler mServiceHandler;
    private Looper mServiceLooper;
    private String merchantCheckoutActivity;
    public String payuResponse;
    public String postData = "";
    private HashMap<String, String> postParamsMap;
    private String postURL = "";
    public String receivedMessage = "";
    public Runnable runnable;
    private final IBinder snoozeBinder = new SnoozeBinder();
    private HandlerThread snoozeHandlerThread;
    public long startTime;
    public long timeToNotify;
    public Handler trackWebViewStatusHandler;
    public String verifyParam;
    public boolean verifyPaymentCheck;
    public Runnable verifyPaymentRunnable = new Runnable() {
        /* class com.payu.custombrowser.services.SnoozeService.AnonymousClass1 */

        public void run() {
            StringBuffer stringBufferFromInputStream;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(SnoozeService.this.verifyURL).openConnection();
                String str = "command=verifyTxnStatus&var1=" + SnoozeService.this.cbUtil.getDataFromPostData(SnoozeService.this.postData, "txnid") + "&key=" + SnoozeService.this.cbUtil.getDataFromPostData(SnoozeService.this.postData, "key") + "&priorityParam=" + SnoozeService.this.verifyParam;
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(120000);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str.length()));
                httpURLConnection.setRequestProperty("Cookie", "PHPSESSID=" + SnoozeService.this.cbUtil.getCookie("PHPSESSID", SnoozeService.this.getApplicationContext()) + "; PAYUID=" + SnoozeService.this.cbUtil.getCookie("PAYUID", SnoozeService.this.getApplicationContext()));
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(str.getBytes());
                if (httpURLConnection.getResponseCode() != 200) {
                    SnoozeService.this.onTransactionStatusReceived("{\"api_status\":\"0\",\"message\":\"Some error occurred\"}");
                } else if (httpURLConnection.getInputStream() != null && (stringBufferFromInputStream = CBUtil.getStringBufferFromInputStream(httpURLConnection.getInputStream())) != null) {
                    new JSONObject(stringBufferFromInputStream.toString());
                    SnoozeService.this.payuResponse = stringBufferFromInputStream.toString();
                    SnoozeService.this.onTransactionStatusReceived(stringBufferFromInputStream.toString());
                }
            } catch (Exception e) {
                SnoozeService.this.onTransactionStatusReceived("{\"api_status\":\"0\",\"message\":\"Some exception occurred\"}");
                e.printStackTrace();
            }
        }
    };
    public String verifyURL = "https://info.payu.in/merchant/postservice?form=2";

    public void onTransactionStatusReceived(String str) {
        try {
            String valueOfJSONKey = this.cbUtil.getValueOfJSONKey(str, getString(R.string.cb_snooze_verify_api_status));
            if (CBActivity.STATE == 2) {
                if (valueOfJSONKey.contentEquals("1")) {
                    broadcastAnalyticsEvent("transaction_verified_notification", "-1");
                } else {
                    broadcastAnalyticsEvent("transaction_not_verified_notification", "-1");
                }
                launchNotificationTransactionUpdate(str);
                return;
            }
            if (valueOfJSONKey.contentEquals("1")) {
                broadcastAnalyticsEvent("transaction_verified_dialog_foreground", "-1");
            } else {
                broadcastAnalyticsEvent("transaction_not_verified_dialog_foreground", "-1");
            }
            broadcastEvent("backward_journey_status", str, false);
            killSnoozeService();
        } catch (JSONException e) {
            e.printStackTrace();
            if (CBActivity.STATE == 2) {
                broadcastAnalyticsEvent("transaction_not_verified_notification", "-1");
                launchNotificationTransactionUpdate(str);
                return;
            }
            broadcastAnalyticsEvent("transaction_not_verified_dialog_foreground", "-1");
            broadcastEvent("backward_journey_status", str, false);
            killSnoozeService();
        }
    }

    public IBinder onBind(Intent intent) {
        this.isWebViewAlive = true;
        return this.snoozeBinder;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.cbUtil = new CBUtil();
        this.merchantCheckoutActivity = intent.getStringExtra(this.MERCHANT_CHECKOUT_ACTIVITY);
        this.customBrowserConfig = (CustomBrowserConfig) intent.getParcelableExtra("cb_config");
        this.SNOOZE_SERVICE_TTL = this.customBrowserConfig.getSurePayBackgroundTTL();
        this.postParamsMap = this.cbUtil.getDataFromPostData(this.customBrowserConfig.getPayuPostData());
        IMAGE_DOWNLOAD_TIME_OUT = Bank.snoozeImageDownloadTimeout > 0 ? Bank.snoozeImageDownloadTimeout : C.MSG_CUSTOM_BASE;
        if (!intent.getExtras().containsKey("verificationMsgReceived") || !intent.getExtras().getBoolean("verificationMsgReceived")) {
            this.verifyPaymentCheck = false;
            this.currentUrl = intent.getStringExtra("currentUrl");
        } else {
            this.verifyPaymentCheck = true;
            if (intent.getExtras().containsKey("verify_add_param")) {
                this.verifyParam = intent.getExtras().getString("verify_add_param");
            }
            this.postData = this.customBrowserConfig.getPayuPostData();
            this.postURL = this.customBrowserConfig.getPostURL();
        }
        Message obtainMessage = this.mServiceHandler.obtainMessage();
        obtainMessage.arg1 = i2;
        this.mServiceHandler.sendMessage(obtainMessage);
        return 3;
    }

    public void onCreate() {
        this.snoozeHandlerThread = new HandlerThread("SnoozeServiceHandlerThread", 10);
        this.snoozeHandlerThread.start();
        this.mServiceLooper = this.snoozeHandlerThread.getLooper();
        this.mServiceHandler = new ServiceHandler(this.mServiceLooper);
    }

    public void killSnoozeService() {
        this.isServiceAlive = false;
        CountDownTimer countDownTimer = this.killSnoozeServiceCounter;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.snoozeHandlerThread.interrupt();
        stopSelf();
    }

    public void updateWebviewStatus(String str) {
        this.receivedMessage = str;
    }

    public void calculateInternetSpeed() {
        this.handler = new Handler(this.mServiceLooper);
        this.runnable = new Runnable() {
            /* class com.payu.custombrowser.services.SnoozeService.AnonymousClass2 */

            public void run() {
                if (SnoozeService.this.isServiceAlive) {
                    SnoozeService.this.downloadImage();
                }
            }
        };
        this.handler.postDelayed(this.runnable, (long) Math.min(this.exponentialBackOffTime, this.EXPONENTIAL_BACKOFF_TIME_THRESHOLD));
    }

    public void downloadImage() {
        this.isImageDownloadTimedOut = false;
        final String str = "https://static.payu.in/images/speed_test/" + CBConstant.SNOOZE_IMAGE_COLLECTIONS[new Random().nextInt(2)];
        final AnonymousClass3 r1 = new CountDownTimer((long) IMAGE_DOWNLOAD_TIME_OUT, 1000) {
            /* class com.payu.custombrowser.services.SnoozeService.AnonymousClass3 */

            public void onTick(long j) {
            }

            public void onFinish() {
                cancel();
                SnoozeService.this.isImageDownloadTimedOut = true;
            }
        };
        r1.start();
        new Thread(new Runnable() {
            /* class com.payu.custombrowser.services.SnoozeService.AnonymousClass4 */

            /* JADX WARNING: Removed duplicated region for block: B:7:0x0039 A[Catch:{ MalformedURLException -> 0x0151, SSLException -> 0x0134, IOException -> 0x0126, Exception -> 0x011c }] */
            public void run() {
                try {
                    if (CBUtil.isNetworkAvailable(SnoozeService.this.getApplicationContext())) {
                        SnoozeService.this.startTime = System.currentTimeMillis();
                        URLConnection openConnection = new URL(str).openConnection();
                        openConnection.setUseCaches(false);
                        openConnection.connect();
                        openConnection.getContentLength();
                        InputStream inputStream = openConnection.getInputStream();
                        byte[] bArr = new byte[1024];
                        while (!SnoozeService.this.isImageDownloadTimedOut && inputStream.read(bArr) != -1) {
                            while (!SnoozeService.this.isImageDownloadTimedOut) {
                                while (!SnoozeService.this.isImageDownloadTimedOut) {
                                }
                            }
                        }
                        if (SnoozeService.this.isImageDownloadTimedOut) {
                            r1.cancel();
                            inputStream.close();
                            SnoozeService.this.imageDownloadTime = (long) (SnoozeService.IMAGE_DOWNLOAD_TIME_OUT + 1);
                        } else {
                            r1.cancel();
                            SnoozeService.this.endTime = System.currentTimeMillis();
                            inputStream.close();
                            SnoozeService.this.imageDownloadTime = SnoozeService.this.endTime - SnoozeService.this.startTime;
                        }
                        if (SnoozeService.this.imageDownloadTime > ((long) SnoozeService.IMAGE_DOWNLOAD_TIME_OUT)) {
                            SnoozeService.this.exponentialBackOffTime += SnoozeService.this.exponentialBackOffTime;
                            SnoozeService.this.handler.postDelayed(SnoozeService.this.runnable, (long) Math.min(SnoozeService.this.exponentialBackOffTime, SnoozeService.this.EXPONENTIAL_BACKOFF_TIME_THRESHOLD));
                        } else if (!SnoozeService.this.isServiceAlive) {
                        } else {
                            if (SnoozeService.this.verifyPaymentCheck) {
                                SnoozeService.this.broadcastAnalyticsEvent("snooze_verify_api_status", "snooze_verify_api_called");
                                new Thread(SnoozeService.this.verifyPaymentRunnable).start();
                            } else if (CBActivity.STATE == 1) {
                                SnoozeService.this.broadcastEvent(SnoozeService.this.getString(R.string.internet_restored), SnoozeService.this.getString(R.string.resuming_your_transaction), true);
                                SnoozeService.this.broadcastAnalyticsEvent("internet_restored_dialog_foreground", "-1");
                                SnoozeService.this.killSnoozeService();
                            } else {
                                SnoozeService.this.launchNotification(SnoozeService.this.isWebViewAlive);
                                SnoozeService.this.broadcastAnalyticsEvent("internet_restored_notification", "-1");
                            }
                        }
                    } else {
                        SnoozeService.this.handler.postDelayed(SnoozeService.this.runnable, (long) Math.min(SnoozeService.this.exponentialBackOffTime, SnoozeService.this.EXPONENTIAL_BACKOFF_TIME_THRESHOLD));
                    }
                } catch (MalformedURLException e) {
                    SnoozeService.this.imageDownloadTime = -1;
                    r1.cancel();
                    e.printStackTrace();
                } catch (SSLException e2) {
                    SnoozeService.this.handler.postDelayed(SnoozeService.this.runnable, (long) Math.min(SnoozeService.this.exponentialBackOffTime, SnoozeService.this.EXPONENTIAL_BACKOFF_TIME_THRESHOLD));
                    e2.printStackTrace();
                } catch (IOException e3) {
                    SnoozeService.this.imageDownloadTime = -1;
                    r1.cancel();
                    e3.printStackTrace();
                } catch (Exception unused) {
                    SnoozeService.this.imageDownloadTime = -1;
                    r1.cancel();
                }
            }
        }).start();
    }

    public void launchNotification(boolean z) {
        boolean z2;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        NotificationCompat.Builder O00000Oo = builder.setContentTitle(this.customBrowserConfig.getSurePayNotificationGoodNetworkTitle()).O00000Oo(this.customBrowserConfig.getSurePayNotificationGoodNetWorkHeader()).O000000o(this.customBrowserConfig.getSurePayNotificationIcon()).O00000Oo();
        O00000Oo.O0000Ooo = 1;
        NotificationCompat.Builder O00000Oo2 = O00000Oo.O00000Oo(2);
        NotificationCompat.O00000Oo o00000Oo = new NotificationCompat.O00000Oo();
        O00000Oo2.O000000o(o00000Oo.O000000o(this.customBrowserConfig.getSurePayNotificationGoodNetWorkHeader() + "\n\n" + this.customBrowserConfig.getSurePayNotificationGoodNetWorkBody()));
        if (Build.VERSION.SDK_INT >= 23) {
            builder.setColor(getResources().getColor(R.color.cb_blue_button, null));
        } else {
            builder.setColor(getResources().getColor(R.color.cb_blue_button));
        }
        this.isNotificationIntentPrepared = true;
        Intent intent = new Intent();
        intent.putExtra("currentUrl", this.currentUrl);
        intent.putExtra("sender", "snoozeService");
        if (z) {
            this.isWebViewIntentPrepared = true;
            intent.setFlags(536870912);
            intent.putExtra("currentUrl", this.currentUrl);
            intent.putExtra("cb_config", this.customBrowserConfig);
            intent.setClass(getApplicationContext(), CBActivity.class);
            z2 = true;
        } else {
            Intent intent2 = new Intent();
            Context applicationContext = getApplicationContext();
            String str = this.merchantCheckoutActivity;
            if (str == null) {
                str = "";
            }
            intent2.setClassName(applicationContext, str);
            if (intent2.resolveActivityInfo(getPackageManager(), 0) != null) {
                intent.setClassName(getApplicationContext(), this.merchantCheckoutActivity);
                intent.putExtra("post_type", "sure_pay_payment_data");
                intent.putExtra("postData", this.customBrowserConfig.getPayuPostData());
                z2 = true;
            } else {
                z2 = false;
            }
            broadcastAnalyticsEvent("snooze_notification_expected_action", "merchant_checkout_page");
            this.isWebViewIntentPrepared = false;
            killSnoozeService();
        }
        if (z2) {
            try {
                builder.setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, intent, 134217728));
                ((NotificationManager) getSystemService("notification")).notify(CBConstant.SNOOZE_NOTIFICATION_ID, builder.build());
                broadcastEvent("good_network_notification_launched", "true", true);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            throw new ActivityNotFoundException("The Activity " + this.merchantCheckoutActivity + " is not found, Please set valid activity ");
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
    public void broadcastAnalyticsEvent(String str, String str2) {
        Intent intent = new Intent("webview_status_action");
        intent.putExtra("BROAD_CAST_FROM_SNOOZE_SERVICE", true);
        intent.putExtra("event_key", str);
        intent.putExtra("event_value", str2);
        ft.O000000o(this).O000000o(intent);
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
    public void launchNotificationTransactionUpdate(String str) {
        StringBuilder sb;
        try {
            String valueOfJSONKey = this.cbUtil.getValueOfJSONKey(str, getString(R.string.cb_snooze_verify_api_status));
            broadcastAnalyticsEvent("snooze_verify_api_response_received", String.valueOf(valueOfJSONKey));
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            if (valueOfJSONKey.contentEquals("1")) {
                sb = new StringBuilder();
                sb.append(this.customBrowserConfig.getSurePayNotificationTransactionVerifiedHeader());
                sb.append("\n\n");
                sb.append(this.customBrowserConfig.getSurePayNotificationTransactionVerifiedBody());
            } else {
                sb = new StringBuilder();
                sb.append(this.customBrowserConfig.getSurePayNotificationTransactionNotVerifiedHeader());
                sb.append("\n\n");
                sb.append(this.customBrowserConfig.getSurePayNotificationTransactionNotVerifiedBody());
            }
            String sb2 = sb.toString();
            NotificationCompat.Builder O00000Oo = builder.setContentTitle(valueOfJSONKey.contentEquals("1") ? this.customBrowserConfig.getSurePayNotificationTransactionVerifiedTitle() : this.customBrowserConfig.getSurePayNotificationTransactionNotVerifiedTitle()).O00000Oo(valueOfJSONKey.contentEquals("1") ? this.customBrowserConfig.getSurePayNotificationTransactionVerifiedHeader() : this.customBrowserConfig.getSurePayNotificationTransactionNotVerifiedHeader()).O000000o(this.customBrowserConfig.getSurePayNotificationIcon()).O00000Oo();
            boolean z = true;
            O00000Oo.O0000Ooo = 1;
            O00000Oo.O00000Oo(2).O000000o(new NotificationCompat.O00000Oo().O000000o(sb2));
            Intent intent = new Intent();
            intent.putExtra("cb_config", this.customBrowserConfig);
            this.isNotificationIntentPrepared = true;
            intent.putExtra("payu_response", str);
            if (this.isWebViewAlive) {
                intent.setFlags(805306368);
                this.isWebViewIntentPrepared = true;
                intent.putExtra("sender", "snoozeService");
                intent.putExtra("verificationMsgReceived", true);
                intent.setClass(getApplicationContext(), CBActivity.class);
            } else {
                Intent intent2 = new Intent();
                intent2.setClassName(getApplicationContext(), this.merchantCheckoutActivity == null ? "" : this.merchantCheckoutActivity);
                if (intent2.resolveActivityInfo(getPackageManager(), 0) != null) {
                    intent.putExtra("postData", str);
                    intent.setClassName(getApplicationContext(), this.merchantCheckoutActivity);
                    intent.putExtra("post_type", "verify_response_post_data");
                } else {
                    z = false;
                }
                broadcastAnalyticsEvent("snooze_notification_expected_action", "merchant_checkout_page");
                this.isWebViewIntentPrepared = false;
                killSnoozeService();
            }
            if (z) {
                try {
                    builder.setContentIntent(PendingIntent.getActivity(this, 0, intent, 134217728));
                    ((NotificationManager) getSystemService("notification")).notify(CBConstant.TRANSACTION_STATUS_NOTIFICATION_ID, builder.build());
                    broadcastEvent("good_network_notification_launched", str, false);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                throw new ActivityNotFoundException("The Activity " + this.merchantCheckoutActivity + " is not found, Please set valid activity ");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void launchNoInternetNotification() {
        broadcastAnalyticsEvent("snooze_notification_expected_action", "merchant_checkout_page");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        NotificationCompat.Builder O00000Oo = builder.setContentTitle(this.customBrowserConfig.getSurePayNotificationPoorNetWorkTitle()).O00000Oo(this.customBrowserConfig.getSurePayNotificationPoorNetWorkHeader()).O000000o(this.customBrowserConfig.getSurePayNotificationIcon()).O00000Oo();
        O00000Oo.O0000Ooo = 1;
        NotificationCompat.Builder O00000Oo2 = O00000Oo.O00000Oo(2);
        NotificationCompat.O00000Oo o00000Oo = new NotificationCompat.O00000Oo();
        O00000Oo2.O000000o(o00000Oo.O000000o(this.customBrowserConfig.getSurePayNotificationPoorNetWorkHeader() + this.customBrowserConfig.getSurePayNotificationPoorNetWorkBody()));
        if (Build.VERSION.SDK_INT >= 23) {
            builder.setColor(getResources().getColor(R.color.cb_blue_button, null));
        } else {
            builder.setColor(getResources().getColor(R.color.cb_blue_button));
        }
        Intent intent = new Intent();
        Context applicationContext = getApplicationContext();
        String str = this.merchantCheckoutActivity;
        if (str == null) {
            str = "";
        }
        intent.setClassName(applicationContext, str);
        if (intent.resolveActivityInfo(getPackageManager(), 0) != null) {
            Intent intent2 = new Intent();
            intent2.setClassName(getApplicationContext(), this.merchantCheckoutActivity);
            intent2.putExtra("post_type", "sure_pay_payment_data");
            intent2.putExtra("postData", this.customBrowserConfig.getPayuPostData());
            builder.setContentIntent(PendingIntent.getActivity(this, 0, intent2, 134217728));
            ((NotificationManager) getSystemService("notification")).notify(CBConstant.SNOOZE_NOTIFICATION_ID, builder.build());
            return;
        }
        try {
            throw new ActivityNotFoundException("The Activity " + this.merchantCheckoutActivity + " is not found, Please set valid activity ");
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            SnoozeService snoozeService = SnoozeService.this;
            snoozeService.isServiceAlive = true;
            snoozeService.killSnoozeServiceCounter = new CountDownTimer((long) snoozeService.SNOOZE_SERVICE_TTL, 5000) {
                /* class com.payu.custombrowser.services.SnoozeService.ServiceHandler.AnonymousClass1 */

                public void onTick(long j) {
                    SnoozeService.this.timeToNotify = (((long) SnoozeService.this.SNOOZE_SERVICE_TTL) - j) / 1000;
                }

                public void onFinish() {
                    if (!SnoozeService.this.isNotificationIntentPrepared && CBActivity.STATE == 2) {
                        SnoozeService.this.launchNoInternetNotification();
                        SnoozeService.this.broadcastAnalyticsEvent("internet_not_restored_notification", "-1");
                    } else if (!SnoozeService.this.isNotificationIntentPrepared && CBActivity.STATE == 1) {
                        SnoozeService.this.broadcastAnalyticsEvent("internet_not_restored_dialog_foreground", "-1");
                    }
                    if (SnoozeService.this.isWebViewAlive && !SnoozeService.this.isNotificationIntentPrepared) {
                        Intent intent = new Intent("webview_status_action");
                        intent.putExtra("snoozeServiceStatus", "snoozeServiceDead");
                        ft.O000000o(SnoozeService.this).O000000o(intent);
                    }
                    SnoozeService.this.killSnoozeService();
                }
            };
            SnoozeService.this.killSnoozeServiceCounter.start();
            SnoozeService.this.trackWebViewStatusHandler = new Handler();
            SnoozeService.this.trackWebViewStatusHandler.postDelayed(new Runnable() {
                /* class com.payu.custombrowser.services.SnoozeService.ServiceHandler.AnonymousClass2 */

                public void run() {
                    if (SnoozeService.this.isServiceAlive) {
                        if (SnoozeService.this.broadCastingMessage.contentEquals(SnoozeService.this.receivedMessage)) {
                            SnoozeService.this.isWebViewAlive = true;
                        } else {
                            SnoozeService.this.isWebViewAlive = false;
                            if (SnoozeService.this.isServiceAlive && SnoozeService.this.verifyPaymentCheck && SnoozeService.this.isNotificationIntentPrepared && SnoozeService.this.isWebViewIntentPrepared) {
                                SnoozeService.this.launchNotificationTransactionUpdate(SnoozeService.this.payuResponse);
                            } else if (SnoozeService.this.isServiceAlive && SnoozeService.this.isNotificationIntentPrepared && SnoozeService.this.isWebViewIntentPrepared) {
                                SnoozeService.this.launchNotification(SnoozeService.this.isWebViewAlive);
                            }
                        }
                        SnoozeService.this.trackWebViewStatusHandler.postDelayed(this, 500);
                        Intent intent = new Intent("webview_status_action");
                        SnoozeService snoozeService = SnoozeService.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(System.currentTimeMillis());
                        snoozeService.broadCastingMessage = sb.toString();
                        intent.putExtra("snooze_broad_cast_message", SnoozeService.this.broadCastingMessage);
                        ft.O000000o(SnoozeService.this).O000000o(intent);
                    }
                }
            }, 500);
            SnoozeService.this.calculateInternetSpeed();
        }
    }

    public class SnoozeBinder extends Binder {
        public SnoozeBinder() {
        }

        public SnoozeService getSnoozeService() {
            return SnoozeService.this;
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
    public void broadcastEvent(String str, String str2, boolean z) {
        Intent intent = new Intent("webview_status_action");
        intent.putExtra("broadcast_from_service_update_ui", true);
        intent.putExtra("key", str);
        intent.putExtra("value", str2);
        intent.putExtra("currentUrl", this.currentUrl);
        intent.putExtra("cb_config", this.customBrowserConfig);
        intent.putExtra("is_forward_journey", z);
        ft.O000000o(this).O000000o(intent);
    }
}
