package com.xiaomi.smarthome.aitraining;

import _m_j.ezd;
import _m_j.eze;
import _m_j.ezf;
import _m_j.fws;
import _m_j.gsy;
import _m_j.gty;
import _m_j.ibh;
import _m_j.ibm;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class AiTrainingWebActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f4166O000000o = "mico://audiorecord?id=''&callback=saveAudio";
    private PopupWindow O00000Oo;
    private LinearLayout O00000o;
    private Chronometer O00000o0;
    private LinearLayout O00000oO;
    private AnimatorSet O00000oo = new AnimatorSet();
    public String cUserId;
    public int curRecordState = 99;
    public ImageView imgAudioState;
    public View imgDismissPop;
    public View imgUploadAudio;
    public ezd mAudioManager;
    public TextView mAudioOpTip;
    public eze mMediaManager;
    public ProgressBar mProgressBar;
    public WebView mWebView;
    public String serviceToken;
    public String sid_ph;
    public String sid_slh;

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.curRecordState = message.what;
        switch (message.what) {
            case 99:
                ImageView imageView = this.imgAudioState;
                if (imageView != null) {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.training_skill_start));
                }
                View view = this.imgDismissPop;
                if (view != null && this.imgUploadAudio != null) {
                    view.setVisibility(8);
                    this.imgUploadAudio.setVisibility(8);
                    return;
                }
                return;
            case 100:
                this.mAudioManager = new ezd(getFileStreamPath("recoder_clockmyk1.mp3").getAbsolutePath());
                ezd ezd = this.mAudioManager;
                try {
                    File file = new File(ezd.O00000Oo);
                    fws.O000000o(ezd.O00000Oo);
                    ezd.O00000o0 = file.getAbsolutePath();
                    ezd.f15972O000000o = new MediaRecorder();
                    ezd.f15972O000000o.setOutputFile(ezd.O00000o0);
                    ezd.f15972O000000o.setAudioSource(1);
                    ezd.f15972O000000o.setOutputFormat(0);
                    ezd.f15972O000000o.setAudioEncoder(3);
                    ezd.f15972O000000o.prepare();
                    ezd.f15972O000000o.start();
                    ezd.O00000oO = System.currentTimeMillis();
                    ezd.O00000oo = 0;
                    ezd.O00000o = true;
                    return;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            case 101:
            case 104:
                O000000o();
                return;
            case 102:
                if (this.mAudioManager != null) {
                    eze eze = this.mMediaManager;
                    if (eze != null) {
                        eze.O000000o();
                    }
                    this.mMediaManager = new eze();
                    eze eze2 = this.mMediaManager;
                    String str = this.mAudioManager.O00000o0;
                    AnonymousClass5 r4 = new MediaPlayer.OnCompletionListener() {
                        /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass5 */

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            AiTrainingWebActivity.this.stopRecordAnim();
                            AiTrainingWebActivity.this.imgAudioState.setImageDrawable(AiTrainingWebActivity.this.getResources().getDrawable(R.drawable.training_select_playtran));
                            Message obtain = Message.obtain();
                            obtain.what = 103;
                            AiTrainingWebActivity.this.mHandler.sendMessage(obtain);
                        }
                    };
                    if (eze2.f15973O000000o == null) {
                        eze2.f15973O000000o = new MediaPlayer();
                        eze2.f15973O000000o.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                            /* class _m_j.eze.AnonymousClass1 */

                            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                eze.this.f15973O000000o.reset();
                                return false;
                            }
                        });
                    } else {
                        eze2.f15973O000000o.reset();
                    }
                    try {
                        eze2.f15973O000000o.setAudioStreamType(3);
                        eze2.f15973O000000o.setOnCompletionListener(r4);
                        eze2.f15973O000000o.setDataSource(str);
                        eze2.f15973O000000o.prepare();
                        eze2.f15973O000000o.start();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    eze2.O00000o0 = 0;
                    eze2.O00000Oo = System.currentTimeMillis();
                    return;
                }
                return;
            case 103:
                O00000Oo();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.comm_web_activity);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.title_bar);
        String stringExtra = getIntent().getStringExtra("title");
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        textView.setText(stringExtra);
        ImageView imageView = (ImageView) findViewById(R.id.module_a_3_return_btn);
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.mProgressBar = (ProgressBar) findViewById(R.id.loading_progress);
        if (getIntent().getBooleanExtra("showCloseBtn", true)) {
            ImageView imageView2 = new ImageView(this);
            imageView2.setId(R.id.module_a_3_close_btn_title);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(imageView.getLayoutParams());
            layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.mj_titlebar_margin_left_right) * 2;
            layoutParams.gravity = 21;
            frameLayout.addView(imageView2, layoutParams);
            imageView.setImageResource(R.drawable.std_tittlebar_main_device_back);
            imageView2.setImageResource(R.drawable.std_tittlebar_main_device_back2);
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(this);
        }
        this.mWebView = (WebView) findViewById(R.id.webview);
        Intent intent = getIntent();
        if (!intent.hasExtra("url")) {
            finish();
            return;
        }
        final String stringExtra2 = intent.getStringExtra("url");
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setDomStorageEnabled(true);
        this.mWebView.addJavascriptInterface(new O000000o(textView), "android");
        this.mWebView.setWebChromeClient(new WebChromeClient() {
            /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass1 */

            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                AiTrainingWebActivity.this.mProgressBar.setProgress(i);
                if (i >= 80) {
                    webView.loadUrl("javascript:window.android.setTitle(document.title)");
                }
            }
        });
        this.mWebView.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass6 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str == null || !"mico://audiorecord?id=''&callback=saveAudio".equalsIgnoreCase(str)) {
                    super.shouldOverrideUrlLoading(webView, str);
                    return false;
                }
                if (XmPluginHostApi.instance().getApiLevel() < 75) {
                    AiTrainingWebActivity.this.showPopWindow();
                } else {
                    XmPluginHostApi.instance().checkAndRequestPermisson(AiTrainingWebActivity.this, true, new Callback<List<String>>() {
                        /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass6.AnonymousClass1 */

                        public final void onFailure(int i, String str) {
                            gsy.O00000Oo("WebActivity", "onFailure checkAndRequestPermisson");
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            gsy.O00000Oo("WebActivity", "onSuccess checkAndRequestPermisson");
                            AiTrainingWebActivity.this.mWebView.post(new Runnable() {
                                /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AiTrainingWebActivity.this.showPopWindow();
                                }
                            });
                        }
                    }, "android.permission.RECORD_AUDIO");
                }
                return true;
            }

            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                AiTrainingWebActivity.this.mProgressBar.setVisibility(8);
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                AiTrainingWebActivity.this.mProgressBar.setVisibility(0);
            }

            public final void onPageFinished(WebView webView, String str) {
                AiTrainingWebActivity.this.mProgressBar.setVisibility(8);
                gsy.O00000Oo("WebActivity", "WEB_URL  loading URL finish cookie= ".concat(String.valueOf(CookieManager.getInstance().getCookie(str))));
                super.onPageFinished(webView, str);
                webView.loadUrl("javascript:".concat(String.valueOf(("var newscript = document.createElement(\"script\");" + "newscript.text = function openPag(option){newPage.openPage(JSON.stringify(option));};var thirdPartConfig = { headerBgColor: '#F44D55', thirdPart: 'yeelight'};window.thirdPartConfig = thirdPartConfig;") + "document.body.appendChild(newscript);")));
            }

            @SuppressLint({"NewApi"})
            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest == null || webResourceResponse == null) {
                    gsy.O00000Oo("WebActivity", "WEB_URL  loading URL httpError=  request" + webResourceRequest + " errorResponse " + webResourceResponse);
                    return;
                }
                gsy.O00000Oo("WebActivity", "WEB_URL  loading URL httpError= " + webResourceRequest.getUrl() + " " + webResourceRequest.getRequestHeaders() + " \n " + webResourceResponse.getStatusCode() + "  " + webResourceResponse.getResponseHeaders());
            }
        });
        removeCookie(this);
        try {
            O000000o(intent.getStringExtra("extra_cookies"), stringExtra2);
            if (CoreApi.O000000o().O0000oO0()) {
                ibm.O000000o("i.ai.mi.com", CoreApi.O000000o().O000000o("i.ai.mi.com"), new ibh<MiServiceTokenInfo, ExceptionError>() {
                    /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass7 */

                    public final /* synthetic */ void onFailure(Error error) {
                        gsy.O00000Oo("WebActivity", "syncLoadWeb: onFailure ".concat(String.valueOf((ExceptionError) error)));
                        if (AiTrainingWebActivity.this.isValid()) {
                            AiTrainingWebActivity.this.doSyncLoadWeb(stringExtra2);
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (AiTrainingWebActivity.this.isValid()) {
                            AiTrainingWebActivity.this.doSyncLoadWeb(stringExtra2);
                        }
                    }
                });
            } else {
                doSyncLoadWeb(stringExtra2);
            }
        } catch (NoSuchMethodError e) {
            gsy.O000000o(6, "WebActivity", Log.getStackTraceString(e));
            synCookies(this, stringExtra2, "ai_version=audio");
            this.mWebView.loadUrl(stringExtra2);
        }
    }

    private void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject.opt(next);
                    if (opt != null) {
                        synCookies(this, str2, next + "=" + opt);
                    }
                }
            } catch (JSONException e) {
                gsy.O000000o(5, "WebActivity", "addExtraCookies:" + Log.getStackTraceString(e));
            }
        }
    }

    public void doSyncLoadWeb(final String str) {
        gty.O000000o().getAccount(getContext(), "i.ai.mi.com", new ibh<AccountInfo, Error>() {
            /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                AccountInfo accountInfo = (AccountInfo) obj;
                if (AiTrainingWebActivity.this.isValid() && AiTrainingWebActivity.this.mWebView != null) {
                    gsy.O00000Oo("WebActivity", "jsonToken: ".concat(String.valueOf(accountInfo)));
                    AiTrainingWebActivity.this.serviceToken = accountInfo.getServiceToken();
                    AiTrainingWebActivity.this.cUserId = accountInfo.getEncryptedUserId();
                    AiTrainingWebActivity.this.sid_ph = accountInfo.getPh();
                    AiTrainingWebActivity.this.sid_slh = accountInfo.getSlh();
                    try {
                        if (AiTrainingWebActivity.this.sid_ph.contains(",")) {
                            AiTrainingWebActivity.this.sid_ph = AiTrainingWebActivity.this.sid_ph.split(",")[1];
                        }
                        if (AiTrainingWebActivity.this.sid_slh.contains(",")) {
                            AiTrainingWebActivity.this.sid_slh = AiTrainingWebActivity.this.sid_slh.split(",")[1];
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AiTrainingWebActivity aiTrainingWebActivity = AiTrainingWebActivity.this;
                    Context context = aiTrainingWebActivity.getContext();
                    String str = str;
                    aiTrainingWebActivity.synCookies(context, str, "serviceToken=" + AiTrainingWebActivity.this.serviceToken);
                    AiTrainingWebActivity aiTrainingWebActivity2 = AiTrainingWebActivity.this;
                    Context context2 = aiTrainingWebActivity2.getContext();
                    String str2 = str;
                    aiTrainingWebActivity2.synCookies(context2, str2, "cUserId=" + AiTrainingWebActivity.this.cUserId);
                    AiTrainingWebActivity aiTrainingWebActivity3 = AiTrainingWebActivity.this;
                    Context context3 = aiTrainingWebActivity3.getContext();
                    String str3 = str;
                    aiTrainingWebActivity3.synCookies(context3, str3, "i.ai.mi.com_ph=" + AiTrainingWebActivity.this.sid_ph);
                    AiTrainingWebActivity aiTrainingWebActivity4 = AiTrainingWebActivity.this;
                    Context context4 = aiTrainingWebActivity4.getContext();
                    String str4 = str;
                    aiTrainingWebActivity4.synCookies(context4, str4, "i.ai.mi.com_slh=" + AiTrainingWebActivity.this.sid_slh);
                    AiTrainingWebActivity.this.mWebView.loadUrl(str);
                }
            }

            public final void onFailure(Error error) {
                gsy.O00000Oo("WebActivity", "jsonToken: onFailure ".concat(String.valueOf(error)));
            }
        });
    }

    public void synCookies(Context context, String str, String str2) {
        CookieSyncManager.createInstance(context);
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        instance.setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }

    public static void removeCookie(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public void onResume() {
        this.mWebView.onResume();
        super.onResume();
    }

    public void onPause() {
        this.mWebView.onPause();
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(this.mWebView, null);
            this.mWebView.loadUrl("");
        } catch (Exception unused) {
        }
        this.O00000oo.cancel();
        ViewParent parent = this.mWebView.getParent();
        this.mWebView.removeAllViews();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.mWebView);
        }
        this.mWebView.destroy();
        this.mWebView = null;
    }

    public void onBackPressed() {
        dismissPopWin();
        WebView webView = this.mWebView;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.mWebView.goBack();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void showPopWindow() {
        ArrayList arrayList;
        if (this.O00000Oo == null) {
            View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.popup_training_audio_record, (ViewGroup) null, false);
            inflate.findViewById(R.id.ll_btn_record_bg).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass9 */

                public final void onClick(View view) {
                }
            });
            this.mAudioOpTip = (TextView) inflate.findViewById(R.id.audio_op_tip);
            this.imgDismissPop = inflate.findViewById(R.id.img_dismiss_pop);
            this.O00000o = (LinearLayout) inflate.findViewById(R.id.tr_left_anim);
            this.O00000oO = (LinearLayout) inflate.findViewById(R.id.tr_right_anim);
            this.imgDismissPop.setVisibility(0);
            this.O00000o.setVisibility(4);
            this.O00000oO.setVisibility(4);
            int i = (int) (getResources().getDisplayMetrics().density * 2.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, (int) (getResources().getDisplayMetrics().density * 13.0f));
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            while (i2 < 9) {
                final TextView textView = new TextView(getContext());
                final TextView textView2 = new TextView(getContext());
                float random = (float) (Math.random() + 0.3d);
                if (random >= 1.0f) {
                    arrayList = arrayList2;
                    double d = (double) random;
                    Double.isNaN(d);
                    random = (float) (d * 0.3d);
                } else {
                    arrayList = arrayList2;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, random);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass10 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        textView.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, random);
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass11 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        textView2.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                i2++;
                long j = (long) (i2 * 150);
                ofFloat.setDuration(j);
                ofFloat.setRepeatMode(1);
                ofFloat.setRepeatCount(-1);
                ofFloat2.setDuration(j);
                ofFloat2.setRepeatMode(1);
                ofFloat2.setRepeatCount(-1);
                layoutParams.rightMargin = i;
                textView.setLayoutParams(layoutParams);
                textView2.setLayoutParams(layoutParams);
                textView.setBackgroundColor(getResources().getColor(R.color.mj_color_black_50_transparent));
                textView2.setBackgroundColor(getResources().getColor(R.color.mj_color_black_50_transparent));
                ArrayList arrayList3 = arrayList;
                arrayList3.add(ofFloat);
                arrayList3.add(ofFloat2);
                this.O00000o.addView(textView);
                this.O00000oO.addView(textView2);
                arrayList2 = arrayList3;
            }
            this.O00000oo.playTogether(arrayList2);
            this.imgDismissPop.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass12 */

                public final void onClick(View view) {
                    AiTrainingWebActivity.this.dismissPopWin();
                }
            });
            this.imgUploadAudio = inflate.findViewById(R.id.img_upload_audio);
            this.imgUploadAudio.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass13 */

                public final void onClick(View view) {
                    try {
                        String[] strArr = {"serviceToken", "cUserId", "i.ai.mi.com_ph", "i.ai.mi.com_slh", "userId"};
                        String[] strArr2 = {AiTrainingWebActivity.this.serviceToken, AiTrainingWebActivity.this.cUserId, AiTrainingWebActivity.this.sid_ph, AiTrainingWebActivity.this.sid_slh, XmPluginHostApi.instance().getAccountId()};
                        ezf ezf = new ezf();
                        WebView webView = AiTrainingWebActivity.this.mWebView;
                        Context context = AiTrainingWebActivity.this.getContext();
                        File file = new File(AiTrainingWebActivity.this.mAudioManager.O00000o0);
                        long O00000Oo = AiTrainingWebActivity.this.mAudioManager == null ? 0 : AiTrainingWebActivity.this.mAudioManager.O00000Oo();
                        ezf.O00000o0 = context;
                        ezf.O000000o(strArr, strArr2);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = new XQProgressHorizontalDialog(context);
                        xQProgressHorizontalDialog.setCancelable(false);
                        xQProgressHorizontalDialog.show();
                        ezf.O00000o0 o00000o0 = new ezf.O00000o0(MultipartBody.create(MediaType.parse("audio/mp3"), file), new ezf.O00000Oo(webView, xQProgressHorizontalDialog) {
                            /* class _m_j.ezf.AnonymousClass1 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ WebView f15976O000000o;
                            final /* synthetic */ XQProgressHorizontalDialog O00000Oo;

                            {
                                this.f15976O000000o = r2;
                                this.O00000Oo = r3;
                            }

                            public final void O000000o(long j, long j2) {
                                final long j3 = j2;
                                final long j4 = j;
                                this.f15976O000000o.post(new Runnable() {
                                    /* class _m_j.ezf.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AnonymousClass1.this.O00000Oo.O000000o((int) j3, (int) (((float) j4) * 0.99f));
                                    }
                                });
                            }
                        });
                        MultipartBody.create(MediaType.parse("text/plain"), XmPluginHostApi.instance().getAccountId());
                        MultipartBody.create(MediaType.parse("text/plain"), strArr2[2]);
                        MultipartBody.Builder builder = new MultipartBody.Builder();
                        builder.addFormDataPart("prefix", XmPluginHostApi.instance().getAccountId());
                        builder.addFormDataPart("i.ai.mi.com_ph", strArr2[2]);
                        builder.addFormDataPart("file", file.getName(), o00000o0);
                        ezf.O00000o.newCall(new Request.Builder().url(ezf.f15975O000000o).post(builder.build()).build()).enqueue(new okhttp3.Callback(webView, xQProgressHorizontalDialog, O00000Oo, file) {
                            /* class _m_j.ezf.AnonymousClass2 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ WebView f15978O000000o;
                            final /* synthetic */ XQProgressHorizontalDialog O00000Oo;
                            final /* synthetic */ File O00000o;
                            final /* synthetic */ long O00000o0;

                            {
                                this.f15978O000000o = r2;
                                this.O00000Oo = r3;
                                this.O00000o0 = r4;
                                this.O00000o = r6;
                            }

                            public final void onFailure(Call call, final IOException iOException) {
                                this.f15978O000000o.post(new Runnable() {
                                    /* class _m_j.ezf.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        AnonymousClass2.this.O00000Oo.dismiss();
                                        gsy.O000000o(6, "UploadFileManagerNew", Log.getStackTraceString(iOException));
                                    }
                                });
                            }

                            public final void onResponse(Call call, final Response response) throws IOException {
                                this.f15978O000000o.post(new Runnable() {
                                    /* class _m_j.ezf.AnonymousClass2.AnonymousClass2 */

                                    public final void run() {
                                        AnonymousClass2.this.O00000Oo.dismiss();
                                        try {
                                            ResponseBody body = response.body();
                                            if (body != null) {
                                                String string = body.string();
                                                JSONObject jSONObject = new JSONObject(string);
                                                jSONObject.put("fileDuration", AnonymousClass2.this.O00000o0);
                                                string = jSONObject.toString();
                                                String str = "saveAudio('', JSON.stringify(" + string + "))";
                                                AnonymousClass2.this.f15978O000000o.loadUrl("javascript:".concat(String.valueOf(str)));
                                                gsy.O00000Oo("UploadFileManagerNew", str);
                                                AnonymousClass2.this.O00000o.delete();
                                                gpg.O000000o(response);
                                            }
                                        } catch (Exception e) {
                                            gsy.O000000o(6, "UploadFileManagerNew", Log.getStackTraceString(e));
                                        } catch (Throwable th) {
                                            gsy.O000000o(6, "UploadFileManagerNew", Log.getStackTraceString(th));
                                        }
                                    }
                                });
                            }
                        });
                    } catch (Exception e) {
                        gsy.O000000o(6, "WebActivity", Log.getStackTraceString(e));
                    } catch (Throwable th) {
                        AiTrainingWebActivity.this.dismissPopWin();
                        throw th;
                    }
                    AiTrainingWebActivity.this.dismissPopWin();
                }
            });
            this.imgAudioState = (ImageView) inflate.findViewById(R.id.img_audio_state);
            this.O00000o0 = (Chronometer) inflate.findViewById(R.id.chronometer_record);
            this.O00000o0.setVisibility(4);
            this.O00000o0.setFormat("00:00");
            this.O00000o0.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass2 */

                public final void onChronometerTick(Chronometer chronometer) {
                    long j = 0;
                    if (AiTrainingWebActivity.this.mAudioManager != null && AiTrainingWebActivity.this.mAudioManager.O00000o) {
                        j = AiTrainingWebActivity.this.mAudioManager.O00000Oo();
                    } else if (AiTrainingWebActivity.this.mMediaManager != null) {
                        eze eze = AiTrainingWebActivity.this.mMediaManager;
                        if (eze.f15973O000000o != null) {
                            j = (eze.O00000o0 + System.currentTimeMillis()) - eze.O00000Oo;
                        }
                    }
                    if (j > 3599000) {
                        AiTrainingWebActivity.this.stopRecordAnim();
                        AiTrainingWebActivity.this.imgAudioState.setImageDrawable(AiTrainingWebActivity.this.getResources().getDrawable(R.drawable.training_skill_finish));
                        Message obtain = Message.obtain();
                        obtain.what = 101;
                        AiTrainingWebActivity.this.mHandler.sendMessage(obtain);
                        j = 3599000;
                    }
                    AiTrainingWebActivity.this.setTimerHint(chronometer, j);
                }
            });
            this.imgAudioState.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    Message obtain = Message.obtain();
                    switch (AiTrainingWebActivity.this.curRecordState) {
                        case 99:
                        case 104:
                            AiTrainingWebActivity.this.startRecordAnim();
                            AiTrainingWebActivity.this.imgAudioState.setImageDrawable(AiTrainingWebActivity.this.getResources().getDrawable(R.drawable.training_skill_finish));
                            AiTrainingWebActivity.this.mAudioOpTip.setText((int) R.string.click_to_stop_record_audio);
                            if (!(AiTrainingWebActivity.this.imgDismissPop == null || AiTrainingWebActivity.this.imgUploadAudio == null)) {
                                AiTrainingWebActivity.this.imgDismissPop.setVisibility(8);
                                AiTrainingWebActivity.this.imgUploadAudio.setVisibility(8);
                            }
                            obtain.what = 100;
                            AiTrainingWebActivity.this.mHandler.sendMessage(obtain);
                            return;
                        case 100:
                            AiTrainingWebActivity.this.stopRecordAnim();
                            AiTrainingWebActivity.this.imgDismissPop.setVisibility(0);
                            AiTrainingWebActivity.this.imgUploadAudio.setVisibility(0);
                            AiTrainingWebActivity.this.mAudioOpTip.setText((int) R.string.click_to_restart_record_audio);
                            AiTrainingWebActivity.this.imgAudioState.setImageDrawable(AiTrainingWebActivity.this.getResources().getDrawable(R.drawable.training_skill_start));
                            obtain.what = 104;
                            AiTrainingWebActivity.this.mHandler.sendMessage(obtain);
                            return;
                        case 101:
                            AiTrainingWebActivity.this.startRecordAnim();
                            AiTrainingWebActivity.this.imgAudioState.setImageDrawable(AiTrainingWebActivity.this.getResources().getDrawable(R.drawable.training_select_pausetran));
                            obtain.what = 102;
                            AiTrainingWebActivity.this.mHandler.sendMessage(obtain);
                            return;
                        case 102:
                            AiTrainingWebActivity.this.stopRecordAnim();
                            AiTrainingWebActivity.this.imgAudioState.setImageDrawable(AiTrainingWebActivity.this.getResources().getDrawable(R.drawable.training_select_playtran));
                            obtain.what = 103;
                            AiTrainingWebActivity.this.mHandler.sendMessage(obtain);
                            return;
                        case 103:
                            AiTrainingWebActivity.this.startRecordAnim();
                            AiTrainingWebActivity.this.imgAudioState.setImageDrawable(AiTrainingWebActivity.this.getResources().getDrawable(R.drawable.training_select_pausetran));
                            obtain.what = 102;
                            AiTrainingWebActivity.this.mHandler.sendMessage(obtain);
                            return;
                        default:
                            return;
                    }
                }
            });
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    AiTrainingWebActivity.this.dismissPopWin();
                }
            });
            this.O00000Oo = new PopupWindow(getContext());
            this.O00000Oo.setWidth(-1);
            this.O00000Oo.setHeight(-1);
            this.O00000Oo.setContentView(inflate);
            this.O00000Oo.setBackgroundDrawable(new ColorDrawable(0));
            this.O00000Oo.setOutsideTouchable(true);
            this.O00000Oo.setTouchable(true);
            this.O00000Oo.setAnimationStyle(16973910);
        }
        this.O00000Oo.showAtLocation(getWindow().getDecorView(), 80, 0, 0);
    }

    public void dismissPopWin() {
        PopupWindow popupWindow = this.O00000Oo;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.O00000Oo.dismiss();
        }
        Message obtain = Message.obtain();
        obtain.what = 99;
        this.mHandler.sendMessage(obtain);
        O000000o();
        O00000Oo();
        this.O00000Oo = null;
    }

    public void startRecordAnim() {
        AnimatorSet animatorSet = this.O00000oo;
        if (animatorSet != null) {
            animatorSet.start();
        }
        Chronometer chronometer = this.O00000o0;
        if (chronometer != null) {
            chronometer.setVisibility(0);
            this.O00000o0.setBase(SystemClock.elapsedRealtime());
            this.O00000o0.start();
        }
        LinearLayout linearLayout = this.O00000o;
        if (linearLayout != null && this.O00000oO != null) {
            linearLayout.setVisibility(0);
            this.O00000oO.setVisibility(0);
        }
    }

    public void stopRecordAnim() {
        AnimatorSet animatorSet = this.O00000oo;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Chronometer chronometer = this.O00000o0;
        if (chronometer != null) {
            ezd ezd = this.mAudioManager;
            setTimerHint(chronometer, ezd == null ? 0 : ezd.O00000Oo());
            this.O00000o0.stop();
        }
    }

    private void O000000o() {
        if (this.mAudioManager != null) {
            getFileStreamPath("recoder_clockmyk1.mp3").getAbsolutePath();
            this.mAudioManager.O000000o();
        }
    }

    private void O00000Oo() {
        eze eze = this.mMediaManager;
        if (eze != null) {
            eze.O000000o();
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void setTimerHint(Chronometer chronometer, long j) {
        int round = Math.round(((float) j) / 1000.0f);
        chronometer.setText(String.format("%1$02d:%2$02d", Integer.valueOf(round / 60), Integer.valueOf(round % 60)));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_more) {
            super.onBackPressed();
        } else if (id == R.id.module_a_3_return_btn) {
            onBackPressed();
        } else if (id == R.id.module_a_3_close_btn_title) {
            finish();
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final TextView f4182O000000o;

        public O000000o(TextView textView) {
            this.f4182O000000o = textView;
        }

        @JavascriptInterface
        public final void setTitle(final String str) {
            this.f4182O000000o.post(new Runnable() {
                /* class com.xiaomi.smarthome.aitraining.AiTrainingWebActivity.O000000o.AnonymousClass1 */

                public final void run() {
                    if (!TextUtils.isEmpty(str)) {
                        O000000o.this.f4182O000000o.setText(URLDecoder.decode(str));
                    }
                }
            });
        }
    }
}
