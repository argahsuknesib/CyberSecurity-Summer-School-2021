package com.mi.global.shop.activity;

import _m_j.bxs;
import _m_j.byl;
import _m_j.bzu;
import _m_j.bzw;
import _m_j.cad;
import _m_j.cak;
import _m_j.cal;
import _m_j.cam;
import _m_j.cap;
import _m_j.cav;
import _m_j.caw;
import _m_j.cbc;
import _m_j.cbe;
import _m_j.cbf;
import _m_j.cbg;
import _m_j.cbi;
import _m_j.cbm;
import _m_j.ccn;
import _m_j.ccp;
import _m_j.ccr;
import _m_j.ccx;
import _m_j.cec;
import _m_j.ced;
import _m_j.ceh;
import _m_j.cei;
import _m_j.cem;
import _m_j.cen;
import _m_j.kj;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mi.global.shop.model.SyncInfo;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.domain.DomainModel;
import com.mi.global.shop.newmodel.domain.DomainResult;
import com.mi.global.shop.newmodel.notice.NewNoticeData;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoData;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoResult;
import com.mi.util.Device;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainTabActivity extends BaseActivity {
    public static final String TAG = "MainTabActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    private Handler f4630O000000o;
    private boolean O00000Oo = false;
    private cap O00000o0;
    public NewUserInfoData userInfoData;

    public void installHotfix(String str) {
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        int O000000o2;
        ccr.O00000Oo(TAG, "STARTUP start onCreate");
        if (byl.O00000oo() == null) {
            finish();
        } else {
            cem.O000000o(this, new cen() {
                /* class com.mi.global.shop.activity.MainTabActivity.AnonymousClass5 */

                public final void O00000Oo() {
                }

                public final void O00000o0() {
                    MainTabActivity.this.initDeviceWithCheckPermission();
                }
            }, "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
        }
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_maintabs);
        Intent intent = getIntent();
        String action = intent.getAction();
        String dataString = intent.getDataString();
        if ("android.intent.action.VIEW".equals(action) && dataString != null) {
            ccr.O00000Oo(TAG, "Get Google APP link =".concat(String.valueOf(dataString)));
            O000000o(dataString);
        }
        Uri O000000o3 = kj.O000000o(this, getIntent());
        if (O000000o3 != null) {
            String str = TAG;
            ccr.O00000Oo(str, "get facebook app link:" + O000000o3.toString());
            O000000o(O000000o3.toString());
        } else {
            ccr.O00000Oo(TAG, "failed to get facebook app link");
        }
        ceh.O000000o(new Runnable() {
            /* class com.mi.global.shop.activity.MainTabActivity.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
             arg types: [com.mi.global.shop.activity.MainTabActivity, java.lang.String, int]
             candidates:
              _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
              _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
              _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
              _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
             arg types: [com.mi.global.shop.activity.MainTabActivity, java.lang.String, int]
             candidates:
              _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
              _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
              _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
            public final void run() {
                ccn O0000o00 = ccn.O0000o00();
                if (O0000o00.O0000O0o() && !cbm.O00000o0.O000000o((Context) MainTabActivity.this, "pref_miui_account_available", false)) {
                    String str = MainTabActivity.TAG;
                    StringBuilder sb = new StringBuilder("hasSystemAccount ,get getServiceID:");
                    caw.O000000o.O00000oO();
                    sb.append(String.valueOf(caw.O000000o.O00000o0()));
                    ccr.O00000Oo(str, sb.toString());
                    caw.O000000o.O00000oO();
                    String O000000o2 = O0000o00.O000000o(caw.O000000o.O00000o0(), true);
                    String str2 = MainTabActivity.TAG;
                    ccr.O00000Oo(str2, "hasSystemAccount ,get authToken:" + String.valueOf(O000000o2));
                    if (!TextUtils.isEmpty(O000000o2)) {
                        cbm.O00000o0.O00000Oo((Context) MainTabActivity.this, "pref_miui_account_available", true);
                    }
                }
            }
        });
        this.f4630O000000o = new Handler();
        goon(null);
        this.O00000o0 = new cap();
        getSupportFragmentManager().O000000o().O00000Oo(R.id.fragment, this.O00000o0, null).O00000Oo();
        findViewById(R.id.fab_product).setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.MainTabActivity.AnonymousClass6 */

            public final void onClick(View view) {
                MainTabActivity mainTabActivity = MainTabActivity.this;
                mainTabActivity.startActivity(new Intent(mainTabActivity, ProductActivity.class));
            }
        });
        this.mBackView.setVisibility(0);
        setTitle((int) R.string.main_home);
        this.mOrderListView.setVisibility(0);
        O000000o(getIntent());
        if (!bzw.O000000o() || !cbf.O00000o0() || (O000000o2 = cbm.O00000o0.O000000o(this, "pref_data_saver_toast_count", 0)) >= 3) {
            z = false;
        } else {
            cbm.O00000o0.O00000Oo(this, "pref_data_saver_toast_count", O000000o2 + 1);
            z = true;
        }
        if (z) {
            cec.O000000o(this, (int) R.string.shop_settting_data_saver_toast, 1);
        }
        if (cbf.O00000o()) {
            cec.O000000o(this, (int) R.string.shop_toast_network_unavailable, 1);
        }
        new O000000o((byte) 0).execute(new Void[0]);
        String str2 = TAG;
        ccr.O00000Oo(str2, "on Create finish ,this:" + toString());
        cbc.O000000o(this);
        if (!TextUtils.isEmpty(cbc.O00000Oo())) {
            cbe.O000000o("locationEvent", TAG, "location", "location", cbc.O00000Oo());
        }
        getDomain();
    }

    public void getDomain() {
        Request request;
        Uri.Builder buildUpon = Uri.parse(cav.O000Oo0()).buildUpon();
        AnonymousClass1 r1 = new cak<DomainResult>() {
            /* class com.mi.global.shop.activity.MainTabActivity.AnonymousClass1 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                DomainResult domainResult = (DomainResult) baseResult;
                if (domainResult.domainModels.size() > 0) {
                    cbm.O00000o0.O000000o(byl.O00000oO(), caw.O00000o0.f13573O000000o, new Gson().toJson(domainResult.domainModels));
                    MainTabActivity.this.updateConfig();
                    cav.O00000Oo();
                    return;
                }
                cbm.O00000o0.O000000o(byl.O00000oO(), caw.O00000o0.f13573O000000o, "[\n{\nlocal: \"in\",\nsid: \"i18n_in_mo_pro\",\ndns: [\n{\nhostname: \"//in-push.buy.mi.com\",\noldHostname: \"//push.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.store.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//store.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"ru\",\nsid: \"i18n_ru_mo_pro\",\ndns: [\n{\nhostname: \"//ru.mbuy.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.buy.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"id\",\nsid: \"mi_mo_overseaid_new\",\ndns: [\n{\nhostname: \"//mobile.mi.co.id\",\noldHostname: \"//mobile.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//api.buy.mi.co.id\",\noldHostname: \"//sgp-api.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.buy.mi.co.id\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//www.mi.co.id\",\noldHostname: \"//www.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//buy.mi.co.id\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//event.mi.co.id\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//staging.api.id.mipay.com\",\noldHostname: \"//staging.api.idp.intl.xiaomi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//hd.mi.co.id\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.co.id\",\nlaunchTime: 1531548915\n}\n]");
            }

            public final void O000000o(String str) {
                ccr.O00000Oo(MainTabActivity.TAG, "getDomain Exception:".concat(String.valueOf(str)));
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(buildUpon.toString(), DomainResult.class, r1);
        } else {
            request = new cal(buildUpon.toString(), DomainResult.class, r1);
        }
        request.setTag(TAG);
        ced.f13683O000000o.add(request);
        updateConfig();
    }

    public void updateConfig() {
        ArrayList arrayList;
        String O00000Oo2 = cbm.O00000o0.O00000Oo(byl.O00000oO(), caw.O00000o0.f13573O000000o, "[\n{\nlocal: \"in\",\nsid: \"i18n_in_mo_pro\",\ndns: [\n{\nhostname: \"//in-push.buy.mi.com\",\noldHostname: \"//push.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.store.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//store.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"ru\",\nsid: \"i18n_ru_mo_pro\",\ndns: [\n{\nhostname: \"//ru.mbuy.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.buy.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"id\",\nsid: \"mi_mo_overseaid_new\",\ndns: [\n{\nhostname: \"//mobile.mi.co.id\",\noldHostname: \"//mobile.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//api.buy.mi.co.id\",\noldHostname: \"//sgp-api.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.buy.mi.co.id\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//www.mi.co.id\",\noldHostname: \"//www.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//buy.mi.co.id\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//event.mi.co.id\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//staging.api.id.mipay.com\",\noldHostname: \"//staging.api.idp.intl.xiaomi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//hd.mi.co.id\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.co.id\",\nlaunchTime: 1531548915\n}\n]");
        if (!TextUtils.isEmpty(O00000Oo2)) {
            ArrayList arrayList2 = new ArrayList();
            try {
                arrayList = (ArrayList) new Gson().fromJson(O00000Oo2, new TypeToken<ArrayList<DomainModel>>() {
                    /* class com.mi.global.shop.activity.MainTabActivity.AnonymousClass4 */
                }.getType());
            } catch (Exception unused) {
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    DomainModel domainModel = (DomainModel) it.next();
                    if (cad.f13513O000000o.endsWith(domainModel.local)) {
                        if (System.currentTimeMillis() >= domainModel.launchTime) {
                            bxs.O000000o.f13388O000000o = domainModel.sid;
                            cav.O0000oO = domainModel.cookieDomain;
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public void initDeviceWithCheckPermission() {
        boolean O000000o2 = cem.O000000o(this, "android.permission.READ_PHONE_STATE");
        if (O000000o2) {
            Device.O000000o(byl.O00000oO(), O000000o2);
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onLogin(String str, String str2, String str3) {
        super.onLogin(str, str2, str3);
        ccr.O00000Oo(TAG, "refresh userinfo after login");
        O00000Oo();
    }

    public void onLogout() {
        super.onLogout();
        ccr.O00000Oo(TAG, "Maintab logout start");
        ccr.O00000Oo(TAG, "Maintab logout end");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.app.Application, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
     arg types: [android.app.Application, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
    public void onResume() {
        super.onResume();
        updateUnpaidBadge();
        O00000Oo();
        if (!this.O00000Oo) {
            ccr.O00000Oo(TAG, "check app link");
            List asList = Arrays.asList(cav.O000O0oo(), cav.O000OO00(), cav.O000OOOo(), "mistore://mobile.mi.com/in/?diagnosetool=1");
            if (cbm.O00000o0.O000000o((Context) byl.O00000oO(), "pref_applink_haslink", false)) {
                ccr.O00000Oo(TAG, "has app link");
                String O00000Oo2 = cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_applink_url", "");
                cbm.O00000o0.O00000Oo((Context) byl.O00000oO(), "pref_applink_haslink", false);
                cbm.O00000o0.O000000o(byl.O00000oO(), "pref_applink_url", "");
                if (!TextUtils.isEmpty(O00000Oo2)) {
                    ccr.O00000Oo(TAG, "Get applink url:".concat(String.valueOf(O00000Oo2)));
                    if (asList.contains(O00000Oo2)) {
                        ccr.O00000Oo(TAG, "Filter url:".concat(String.valueOf(O00000Oo2)));
                        return;
                    }
                    String str = TAG;
                    ccr.O00000Oo(str, "send applink url:" + O00000Oo2 + " to webactivity");
                    Intent intent = new Intent(this, WebActivity.class);
                    intent.putExtra("url", O00000Oo2);
                    startActivity(intent);
                    return;
                }
                return;
            }
            ccr.O00000Oo(TAG, "No applink url detected");
        }
    }

    public void onPause() {
        super.onPause();
        ccr.O00000Oo(TAG, "on Resume finish");
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        O000000o(intent);
    }

    private void O000000o(Intent intent) {
        Bundle extras;
        if (byl.O0000O0o == null) {
            byl.O0000O0o = new ccp.O000000o("community_sdk", cad.O00000o).O000000o();
        }
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("com.mi.global.shop.action_show_m_site")) {
            if (getIntent().getData() != null) {
                Uri data = getIntent().getData();
                if (!TextUtils.isEmpty(data.getQueryParameter("nativeOpenUrl"))) {
                    this.O00000Oo = true;
                    String queryParameter = data.getQueryParameter("nativeOpenUrl");
                    try {
                        String host = Uri.parse(queryParameter).getHost();
                        if (TextUtils.isEmpty(host)) {
                            return;
                        }
                        if (host.endsWith(".mi.com") || host.endsWith(".mi.co.id") || host.endsWith(".po.co") || host.endsWith(".poco.co.id")) {
                            Log.d("openUrl", queryParameter);
                            Intent intent2 = new Intent(this, WebActivity.class);
                            intent2.putExtra("url", queryParameter);
                            startActivity(intent2);
                        } else {
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                } else if (!TextUtils.isEmpty(data.getQueryParameter("diagnosetool"))) {
                    this.O00000Oo = true;
                    if ("1".equals(data.getQueryParameter("diagnosetool"))) {
                        startActivity(new Intent(this, OTExActivity.class));
                    }
                } else {
                    this.O00000Oo = false;
                }
            }
            if (intent != null) {
                String stringExtra = intent.getStringExtra("action_url");
                String stringExtra2 = intent.getStringExtra("start_from");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    ccx.O00000o0(stringExtra2);
                }
                if (!TextUtils.isEmpty(stringExtra)) {
                    Intent intent3 = new Intent(this, WebActivity.class);
                    intent3.putExtra("url", stringExtra);
                    startActivity(intent3);
                }
            }
            if (intent == null || (extras = intent.getExtras()) == null || extras.getString("com.mi.global.shop.action_switch_main") == null) {
            }
            return;
        }
        String stringExtra3 = intent.getStringExtra("url");
        ccr.O00000Oo(TAG, "url:".concat(String.valueOf(stringExtra3)));
        if (!TextUtils.isEmpty(stringExtra3) && !cbg.O000000o(this, stringExtra3)) {
            LaunchWebActivity.startActivityStandard(this, stringExtra3);
        }
        if (!isOnlyActivity()) {
            finish();
        }
    }

    public boolean isOnlyActivity() {
        try {
            if (((ActivityManager) getSystemService("activity")).getRunningTasks(10).get(0).numActivities == 1) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isRunningForeground(Context context) {
        String packageName = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName();
        if (packageName == null || !packageName.equals(context.getPackageName())) {
            return false;
        }
        return true;
    }

    public void changeRegion() {
        PendingIntent activity = PendingIntent.getActivity(this, 123456, new Intent(this, MainTabActivity.class), 268435456);
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(1, System.currentTimeMillis() + 100, activity);
        } else {
            alarmManager.set(1, System.currentTimeMillis() + 100, activity);
        }
        finish();
        System.exit(0);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 15 && i2 != 0 && i2 == -1 && intent.getIntExtra("changeRegion", 0) == 1) {
            changeRegion();
        }
        if (i != 22 || i2 != 0) {
            byl.O0000Oo().onActivityResult(i, i2, intent);
        }
    }

    public void startCartActivity() {
        if (cad.O00000o()) {
            startActivityForResult(new Intent(this, ShoppingCartActivity.class), 22);
            return;
        }
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", cav.O000OOo());
        startActivity(intent);
    }

    public void checkServerIps() {
        String[] O000OoOo = cav.O000OoOo();
        for (int i = 0; i < 2; i++) {
            final String str = O000OoOo[i];
            StringRequest stringRequest = new StringRequest(0, str, new Response.Listener<String>() {
                /* class com.mi.global.shop.activity.MainTabActivity.AnonymousClass7 */

                public final /* synthetic */ void onResponse(Object obj) {
                    String str = MainTabActivity.TAG;
                    ccr.O00000Oo(str, str + " : " + ((String) obj));
                }
            }, new Response.ErrorListener() {
                /* class com.mi.global.shop.activity.MainTabActivity.AnonymousClass8 */

                public final void onErrorResponse(VolleyError volleyError) {
                    String str = MainTabActivity.TAG;
                    VolleyLog.d(str, "Error: " + volleyError.getMessage());
                }
            });
            stringRequest.setTag(TAG);
            ced.f13683O000000o.add(stringRequest);
        }
    }

    public void finish() {
        super.finish();
        ccx.O0000Oo0();
    }

    public void onDestroy() {
        super.onDestroy();
        String str = TAG;
        ccr.O00000Oo(str, "on Destroy,this:" + toString());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
     arg types: [android.app.Application, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
    private static void O000000o(String str) {
        ccr.O00000Oo(TAG, "process applink:".concat(String.valueOf(str)));
        String replace = str.replace("applink:", "");
        cbm.O00000o0.O00000Oo((Context) byl.O00000oO(), "pref_applink_haslink", true);
        cbm.O00000o0.O000000o(byl.O00000oO(), "pref_applink_url", replace);
    }

    public void showHomeNotice(NewNoticeData newNoticeData) {
        try {
            this.O00000o0.O000000o(newNoticeData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goon(SyncInfo.LaunchInfo launchInfo) {
        cbi.O000000o(this, new Runnable() {
            /* class com.mi.global.shop.activity.MainTabActivity.AnonymousClass9 */

            public final void run() {
            }
        }, new cbi.O00000o0() {
            /* class com.mi.global.shop.activity.MainTabActivity.AnonymousClass10 */

            public final void O000000o(NewNoticeData newNoticeData) {
            }
        });
    }

    static class O000000o extends AsyncTask<Void, Void, Void> {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            bzu.O00000Oo();
            bzu.O000000o();
            return null;
        }
    }

    private void O00000Oo() {
        Request request;
        if (ccn.O0000o00().O0000o0O() && !TextUtils.isEmpty(ccn.O0000o00().O00000Oo())) {
            Uri.Builder buildUpon = Uri.parse(cav.O000OoOO()).buildUpon();
            buildUpon.appendQueryParameter("mUserId", cei.O000000o(ccn.O0000o00().O00000Oo()));
            buildUpon.appendQueryParameter("cUserId", cei.O00000Oo(ccn.O0000o00().O00000Oo()));
            buildUpon.appendQueryParameter("security", "true");
            AnonymousClass3 r1 = new cak<NewUserInfoResult>() {
                /* class com.mi.global.shop.activity.MainTabActivity.AnonymousClass3 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    NewUserInfoResult newUserInfoResult = (NewUserInfoResult) baseResult;
                    if (newUserInfoResult.data != null) {
                        if (newUserInfoResult.data.jsonUserInfoData == null) {
                            MainTabActivity.this.userInfoData = newUserInfoResult.data;
                        } else {
                            MainTabActivity.this.userInfoData = newUserInfoResult.data.jsonUserInfoData;
                        }
                        MainTabActivity mainTabActivity = MainTabActivity.this;
                        mainTabActivity.saveAndUpdateUnpaidNum(mainTabActivity.userInfoData.not_pay_order_count);
                    }
                }

                public final void O000000o(String str) {
                    ccr.O00000Oo(MainTabActivity.TAG, "RefreshUserInfo Exception:".concat(String.valueOf(str)));
                }
            };
            if (byl.O0000OoO()) {
                request = new cam(buildUpon.toString(), NewUserInfoResult.class, r1);
            } else {
                request = new cal(buildUpon.toString(), NewUserInfoResult.class, r1);
            }
            request.setTag(TAG);
            ced.f13683O000000o.add(request);
        }
    }
}
