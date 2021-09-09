package com.tencent.connect.common;

import _m_j.dip;
import _m_j.diq;
import _m_j.diw;
import _m_j.diz;
import _m_j.djp;
import _m_j.djz;
import _m_j.dkb;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import org.json.JSONObject;

public class AssistActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected boolean f5856O000000o = false;
    protected Handler O00000Oo = new Handler() {
        /* class com.tencent.connect.common.AssistActivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 0 && !AssistActivity.this.isFinishing()) {
                diz.O00000o("openSDK_LOG.AssistActivity", "-->finish by timeout");
                AssistActivity.this.finish();
            }
        }
    };
    private String O00000o;
    private boolean O00000o0 = false;
    private O000000o O00000oO;
    private boolean O00000oo;

    public static Intent getAssistActivityIntent(Context context) {
        return new Intent(context, AssistActivity.class);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0157  */
    public void onCreate(Bundle bundle) {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Bundle bundle2 = bundle;
        getWindow().addFlags(67108864);
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.O00000oo = getIntent().getBooleanExtra(dip.O00000o0, false);
        diz.O00000o0("openSDK_LOG.AssistActivity", "--onCreate-- mRestoreLandscape=" + this.O00000oo);
        if (getIntent() == null) {
            diz.O00000oO("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        Intent intent = (Intent) getIntent().getParcelableExtra("openSDK_LOG.AssistActivity.ExtraIntent");
        if (intent == null) {
            i = 0;
        } else {
            i = intent.getIntExtra("key_request_code", 0);
        }
        if (intent == null) {
            str = "";
        } else {
            str = intent.getStringExtra("appid");
        }
        this.O00000o = str;
        Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle2 != null) {
            this.O00000o0 = bundle2.getBoolean("RESTART_FLAG");
            this.f5856O000000o = bundle2.getBoolean("RESUME_FLAG", false);
        }
        if (this.O00000o0) {
            diz.O00000Oo("openSDK_LOG.AssistActivity", "is restart");
        } else if (bundleExtra != null) {
            diz.O00000o("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            String string = bundleExtra.getString("viaShareType");
            String string2 = bundleExtra.getString("callbackAction");
            String string3 = bundleExtra.getString("url");
            String string4 = bundleExtra.getString("openId");
            String string5 = bundleExtra.getString("appId");
            if ("shareToQQ".equals(string2)) {
                str4 = "ANDROIDQQ.SHARETOQQ.XX";
                str5 = "10";
            } else if ("shareToQzone".equals(string2)) {
                str4 = "ANDROIDQQ.SHARETOQZ.XX";
                str5 = "11";
            } else {
                str3 = "";
                str2 = str3;
                if (djp.O000000o(this, string3)) {
                    djz O000000o2 = diq.O000000o().O000000o(string2);
                    if (O000000o2 != null) {
                        O000000o2.onError(new dkb(-6, "打开浏览器失败!", null));
                    }
                    diw.O000000o();
                    diw.O000000o(string4, string5, str3, str2, "3", "1", string, "0", "2", "0");
                    finish();
                } else {
                    diw.O000000o();
                    diw.O000000o(string4, string5, str3, str2, "3", "0", string, "0", "2", "0");
                }
                getIntent().removeExtra("shareH5");
            }
            str2 = str5;
            str3 = str4;
            if (djp.O000000o(this, string3)) {
            }
            getIntent().removeExtra("shareH5");
        } else if (intent != null) {
            diz.O00000o0("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = ".concat(String.valueOf(i)));
            try {
                IntentFilter intentFilter = new IntentFilter("com.tencent.tauth.opensdk.SHARE_SUCCESS_AND_STAY_QQ_".concat(String.valueOf(intent.getData().getQueryParameter("share_id"))));
                if (this.O00000oO == null) {
                    this.O00000oO = new O000000o(this, (byte) 0);
                }
                registerReceiver(this.O00000oO, intentFilter);
            } catch (Exception e) {
                diz.O00000o0("openSDK_LOG.AssistActivity", "registerReceiver exception : " + e.getMessage());
            }
            startActivityForResult(intent, i);
        } else {
            diz.O00000oO("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        diz.O00000o0("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        diz.O00000o0("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("is_login", false)) {
            if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.O00000o0 && !isFinishing()) {
                finish();
            }
            if (this.f5856O000000o) {
                this.O00000Oo.sendMessage(this.O00000Oo.obtainMessage(0));
                return;
            }
            this.f5856O000000o = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        diz.O00000o0("openSDK_LOG.AssistActivity", "-->onPause");
        this.O00000Oo.removeMessages(0);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        diz.O00000o0("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        diz.O00000o0("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            unregisterReceiver(o000000o);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        diz.O00000o0("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra("key_request_code", -1);
        if (intExtra == 10108) {
            intent.putExtra("key_action", "action_request_avatar");
            if (intent.getBooleanExtra("stay_back_stack", false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
            }
        } else if (intExtra == 10109) {
            intent.putExtra("key_action", "action_request_set_emotion");
            if (intent.getBooleanExtra("stay_back_stack", false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
            }
        } else if (intExtra == 10110) {
            intent.putExtra("key_action", "action_request_dynamic_avatar");
            if (intent.getBooleanExtra("stay_back_stack", false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
            }
        } else if (intExtra == 10111) {
            intent.putExtra("key_action", "joinGroup");
            if (intent.getBooleanExtra("stay_back_stack", false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
            }
        } else if (intExtra == 10112) {
            intent.putExtra("key_action", "bindGroup");
            if (intent.getBooleanExtra("stay_back_stack", false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
            }
        } else {
            intent.putExtra("key_action", "action_share");
            setResult(-1, intent);
            if (!isFinishing()) {
                diz.O00000o0("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        diz.O00000o0("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.f5856O000000o);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        StringBuilder sb = new StringBuilder("--onActivityResult--requestCode: ");
        sb.append(i);
        sb.append(" | resultCode: ");
        sb.append(i2);
        sb.append("data = null ? ");
        sb.append(intent == null);
        diz.O00000o0("openSDK_LOG.AssistActivity", sb.toString());
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            if (intent != null) {
                intent.putExtra("key_action", "action_login");
            }
            setResultData(i, intent);
            if (!this.O00000oo) {
                diz.O00000o0("openSDK_LOG.AssistActivity", "onActivityResult finish immediate");
                finish();
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.tencent.connect.common.AssistActivity.AnonymousClass2 */

                public final void run() {
                    diz.O00000o0("openSDK_LOG.AssistActivity", "onActivityResult finish delay");
                    AssistActivity.this.finish();
                }
            }, 200);
        }
    }

    public void setResultData(int i, Intent intent) {
        if (intent == null) {
            diz.O00000o("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i == 11101) {
                diw.O000000o();
                diw.O000000o("", this.O00000o, "2", "1", "7", "2");
                return;
            }
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("key_response");
            diz.O00000Oo("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- ");
            if (!TextUtils.isEmpty(stringExtra)) {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String optString = jSONObject.optString("openid");
                String optString2 = jSONObject.optString("access_token");
                String optString3 = jSONObject.optString("proxy_code");
                long optLong = jSONObject.optLong("proxy_expires_in");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    diz.O00000o0("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                    setResult(-1, intent);
                    diw.O000000o();
                    diw.O000000o(optString, this.O00000o, "2", "1", "7", "0");
                } else if (TextUtils.isEmpty(optString3) || optLong == 0) {
                    diz.O00000o("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                    setResult(0, intent);
                    diw.O000000o();
                    diw.O000000o("", this.O00000o, "2", "1", "7", "1");
                } else {
                    diz.O00000o0("openSDK_LOG.AssistActivity", "--setResultData--proxy_code and proxy_expires_in are valid");
                    setResult(-1, intent);
                }
            } else {
                diz.O00000o("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
            }
        } catch (Exception e) {
            diz.O00000oO("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e.printStackTrace();
        }
    }

    class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(AssistActivity assistActivity, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            String str = "#";
            Uri uri = (Uri) intent.getParcelableExtra("uriData");
            Intent intent2 = new Intent();
            try {
                String uri2 = uri.toString();
                if (!uri2.contains(str)) {
                    str = "?";
                }
                for (String split : uri2.substring(uri2.indexOf(str) + 1).split("&")) {
                    String[] split2 = split.split("=");
                    intent2.putExtra(split2[0], split2[1]);
                }
            } catch (Exception e) {
                diz.O00000o0("openSDK_LOG.AssistActivity", "QQStayReceiver parse uri error : " + e.getMessage());
            }
            intent2.putExtra("key_action", "action_share");
            intent2.setData(uri);
            AssistActivity.this.setResult(-1, intent2);
        }
    }
}
