package com.xiaomi.youpin.login.api.third_part;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fju;
import _m_j.fku;
import _m_j.gnj;
import _m_j.gsy;
import _m_j.gtx;
import _m_j.gty;
import _m_j.hte;
import _m_j.ibu;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import com.xiaomi.account.openid.OauthAccount;
import com.xiaomi.account.openid.OauthAccountManager;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.ui.baseui.BaseActivity;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class Oauth3rdPartyDeviceActivity extends BaseActivity {
    private XQProgressDialog O00000Oo;
    private boolean O00000o = true;
    private boolean O00000o0 = false;
    public MLAlertDialog alertDialog;
    public boolean hasSyncHome = false;
    public View mLoadingView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.oauth_3rd_party_activity);
        this.mLoadingView = findViewById(R.id.ll_loading);
    }

    public void onResume() {
        super.onResume();
        if (this.O00000o0 && !checkLogin()) {
            finishWithMsg(0, "mannual login cancel!");
        }
        if (this.O00000o) {
            this.O00000o = false;
            if (checkLogin()) {
                checkEnv();
            } else if (fju.O000000o().O00000o0()) {
                this.O00000o0 = true;
                MiAccountManager.O00000Oo(CommonApplication.getApplication());
                gty.O000000o().startLogin(CommonApplication.getApplication(), 1, new gtx.O000000o() {
                    /* class com.xiaomi.youpin.login.api.third_part.Oauth3rdPartyDeviceActivity.AnonymousClass1 */

                    public final void O000000o() {
                        super.O000000o();
                        LogType logType = LogType.LOG_INTERNAL;
                        gsy.O00000o0(logType, "Oauth3rdPartyDeviceActivity", "user login: " + Oauth3rdPartyDeviceActivity.this.checkLogin());
                        if (Oauth3rdPartyDeviceActivity.this.checkLogin()) {
                            Oauth3rdPartyDeviceActivity.this.checkEnv();
                        }
                    }
                });
            } else {
                Context baseContext = getBaseContext();
                hte.O000000o(baseContext, "Error: " + getString(R.string.third_oauth_loggin_first), 1);
                fbt fbt = new fbt(getBaseContext(), "SmartHomeMainActivity");
                fbt.O00000Oo(268435456);
                fbs.O000000o(fbt);
                finishWithMsg(0, "Mi Home statement not agreed!");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(configureBaseContext(context, CommonApplication.getAppContext().getApplicationContext().getResources().getConfiguration().locale));
    }

    public static Context configureBaseContext(Context context, Locale locale) {
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT < 17) {
            return context;
        }
        try {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        } catch (Exception unused) {
            return context;
        }
    }

    public boolean checkLogin() {
        return gty.O000000o().isMiLoggedIn();
    }

    public void checkEnv() {
        new Thread(new Runnable() {
            /* class com.xiaomi.youpin.login.api.third_part.Oauth3rdPartyDeviceActivity.AnonymousClass2 */

            public final void run() {
                int i;
                while (!Oauth3rdPartyDeviceActivity.this.isFinishing() && !Oauth3rdPartyDeviceActivity.this.isDestroyed()) {
                    List<Home> allHomes = gty.O000000o().getAllHomes();
                    OauthAccount oauthAccount = OauthAccountManager.getOauthAccount();
                    LogType logType = LogType.LOG_INTERNAL;
                    StringBuilder sb = new StringBuilder("core ready: ");
                    sb.append(gty.O000000o().isCoreReady());
                    sb.append(", login: ");
                    sb.append(gty.O000000o().isMiLoggedIn());
                    sb.append("home size:");
                    if (allHomes == null) {
                        i = 0;
                    } else {
                        i = allHomes.size();
                    }
                    sb.append(i);
                    gsy.O00000o0(logType, "Oauth3rdPartyDeviceActivity", sb.toString());
                    if (oauthAccount == null || TextUtils.isEmpty(oauthAccount.getUserId())) {
                        Oauth3rdPartyDeviceActivity.this.doDelay500ms();
                    } else if (allHomes == null || allHomes.size() <= 0 || TextUtils.isEmpty(allHomes.get(0).getRawName())) {
                        if (!Oauth3rdPartyDeviceActivity.this.hasSyncHome) {
                            Oauth3rdPartyDeviceActivity.this.hasSyncHome = true;
                            gty.O000000o().startSyncHomes();
                        }
                        Oauth3rdPartyDeviceActivity.this.doDelay500ms();
                    } else {
                        Oauth3rdPartyDeviceActivity.this.doOauth3rdPartyDevice();
                        Oauth3rdPartyDeviceActivity.this.dismissProgress();
                        return;
                    }
                }
            }
        }).start();
    }

    public void doDelay500ms() {
        try {
            gsy.O00000o0(LogType.LOG_INTERNAL, "Oauth3rdPartyDeviceActivity", "env not ready");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dismissProgress() {
        XQProgressDialog xQProgressDialog = this.O00000Oo;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000Oo.dismiss();
        }
    }

    public void doOauth3rdPartyDevice() {
        Intent intent = getIntent();
        if (intent == null) {
            finishWithMsg(0, "intent is null!");
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("sign");
            if (TextUtils.isEmpty(stringExtra)) {
                finishWithMsg(0, "sign null!");
                return;
            }
            final long longExtra = intent.getLongExtra("appid", -1);
            if (!O000000o(stringExtra, longExtra)) {
                finishWithMsg(0, "sign is not correct!");
                return;
            }
            final String stringExtra2 = intent.getStringExtra("redirect_url");
            final XiaomiOAuthFuture<XiaomiOAuthResults> startGetOAuthCode = new XiaomiOAuthorize().setAccountAuth(OauthAccountManager.getOauthAccount()).setAppId(longExtra).setRedirectUrl(stringExtra2).setScope(new int[]{1, 3, 6000, 6002}).setNoMiui(true).startGetOAuthCode(this);
            new AsyncTask<Void, Void, Void>() {
                /* class com.xiaomi.youpin.login.api.third_part.Oauth3rdPartyDeviceActivity.AnonymousClass3 */

                /* access modifiers changed from: protected */
                public final /* synthetic */ Object doInBackground(Object[] objArr) {
                    return O000000o();
                }

                private Void O000000o() {
                    try {
                        String code = ((XiaomiOAuthResults) startGetOAuthCode.getResult()).getCode();
                        if (TextUtils.isEmpty(code)) {
                            Oauth3rdPartyDeviceActivity.this.finishWithMsg(0, "");
                        }
                        ibu.O000000o();
                        String O000000o2 = ibu.O000000o(longExtra);
                        ibu.O000000o();
                        String O00000Oo2 = ibu.O00000Oo(longExtra);
                        ibu.O000000o();
                        Oauth3rdPartyDeviceActivity.this.doSelectHome(ibu.O000000o(longExtra, O00000Oo2, stringExtra2, code), O000000o2);
                        return null;
                    } catch (Exception e) {
                        Oauth3rdPartyDeviceActivity.this.finishWithMsg(0, e.getMessage());
                        return null;
                    }
                }
            }.execute(new Void[0]);
        } catch (Exception e) {
            finishWithMsg(0, e.getMessage());
        }
    }

    public void doSelectHome(final JSONObject jSONObject, final String str) {
        String str2;
        List<Home> allHomes = gty.O000000o().getAllHomes();
        final ArrayList arrayList = new ArrayList();
        for (Home next : allHomes) {
            if (next.isOwner()) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 1) {
            if (jSONObject != null) {
                try {
                    jSONObject.put("home_id", ((Home) arrayList.get(0)).getId());
                    jSONObject.put("home_name", ((Home) arrayList.get(0)).getRawName());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (jSONObject == null) {
                str2 = "";
            } else {
                str2 = gnj.O00000o0(jSONObject.toString(), str);
            }
            finishWithMsg(-1, str2);
            return;
        }
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.youpin.login.api.third_part.Oauth3rdPartyDeviceActivity.AnonymousClass4 */

            public final void run() {
                Oauth3rdPartyDeviceActivity.this.mLoadingView.setVisibility(4);
                Oauth3rdPartyDeviceActivity oauth3rdPartyDeviceActivity = Oauth3rdPartyDeviceActivity.this;
                oauth3rdPartyDeviceActivity.alertDialog = new MLAlertDialog.Builder(oauth3rdPartyDeviceActivity).O00000o();
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(Oauth3rdPartyDeviceActivity.this).inflate((int) R.layout.oauth_3rd_party_home_list, (ViewGroup) null);
                linearLayout.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.youpin.login.api.third_part.Oauth3rdPartyDeviceActivity.AnonymousClass4.AnonymousClass1 */

                    public final void onClick(View view) {
                        Oauth3rdPartyDeviceActivity.this.onBackPressed();
                    }
                });
                ListView listView = (ListView) linearLayout.findViewById(R.id.home_select_list);
                O000000o o000000o = new O000000o(Oauth3rdPartyDeviceActivity.this, (byte) 0);
                List list = arrayList;
                JSONObject jSONObject = jSONObject;
                String str = str;
                o000000o.f12081O000000o.clear();
                o000000o.O00000Oo = jSONObject;
                o000000o.O00000o0 = str;
                if (list != null) {
                    o000000o.f12081O000000o.addAll(list);
                }
                o000000o.notifyDataSetChanged();
                listView.setAdapter((ListAdapter) o000000o);
                Oauth3rdPartyDeviceActivity.this.alertDialog.setView(linearLayout, 0, 0, 0, 0);
                Oauth3rdPartyDeviceActivity.this.alertDialog.setCancelable(false);
                Oauth3rdPartyDeviceActivity.this.alertDialog.show();
            }
        });
    }

    private boolean O000000o(String str, long j) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        try {
            ibu.O000000o();
            String O000000o2 = ibu.O000000o(j);
            if (TextUtils.isEmpty(O000000o2)) {
                gsy.O00000o0(LogType.KUAILIAN, "oauth", "checkSign: packagename is null!");
                return false;
            }
            String O000000o3 = O000000o(getPackageManager().getPackageInfo(O000000o2, 64).signatures);
            byte[] O000000o4 = fku.O000000o(str);
            SecretKeySpec secretKeySpec = new SecretKeySpec(O000000o3.substring(0, 16).getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            String str2 = new String(instance.doFinal(O000000o4), "utf-8");
            gsy.O000000o(LogType.KUAILIAN, "oauth", "checkSign: ".concat(str2));
            return O000000o2.equalsIgnoreCase(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String O000000o(Signature[] signatureArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (signatureArr != null) {
                for (Signature byteArray : signatureArr) {
                    instance.update(byteArray.toByteArray());
                }
            }
            return fku.O000000o(instance.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    public void finishWithMsg(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("result", str);
        setResult(i, intent);
        finish();
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<Home> f12081O000000o;
        public JSONObject O00000Oo;
        public String O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
            this.f12081O000000o = new ArrayList();
        }

        /* synthetic */ O000000o(Oauth3rdPartyDeviceActivity oauth3rdPartyDeviceActivity, byte b) {
            this();
        }

        public final Object getItem(int i) {
            return this.f12081O000000o.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, final View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(Oauth3rdPartyDeviceActivity.this).inflate((int) R.layout.one_home_item_layout, viewGroup, false);
            }
            final Home home = this.f12081O000000o.get(i);
            ((TextView) view.findViewById(R.id.one_home_textview)).setText(home.getRawName());
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.youpin.login.api.third_part.Oauth3rdPartyDeviceActivity.O000000o.AnonymousClass1 */

                @SuppressLint({"ResourceAsColor"})
                public final void onClick(View view) {
                    view.setBackgroundColor(Color.parseColor("#3332BAC0"));
                    view.findViewById(R.id.seleted_img).setVisibility(0);
                    if (O000000o.this.O00000Oo != null) {
                        try {
                            O000000o.this.O00000Oo.put("home_id", home.getId());
                            O000000o.this.O00000Oo.put("home_name", home.getRawName());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (Oauth3rdPartyDeviceActivity.this.alertDialog != null && Oauth3rdPartyDeviceActivity.this.alertDialog.isShowing()) {
                        Oauth3rdPartyDeviceActivity.this.alertDialog.dismiss();
                    }
                    Oauth3rdPartyDeviceActivity.this.finishWithMsg(-1, O000000o.this.O00000Oo == null ? "" : gnj.O00000o0(O000000o.this.O00000Oo.toString(), O000000o.this.O00000o0));
                }
            });
            return view;
        }

        public final int getCount() {
            return this.f12081O000000o.size();
        }
    }

    public void onBackPressed() {
        finishWithMsg(0, "mannual cancel!");
    }
}
