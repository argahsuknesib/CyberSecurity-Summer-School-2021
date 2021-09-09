package com.xiaomi.smarthome.frame.baseui;

import _m_j.fsp;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.hyy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.mi.activity.BaseActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity;
import java.util.Locale;

public class BasePluginActivity extends FragmentActivity {
    public static Runnable sClearRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.frame.baseui.BasePluginActivity.AnonymousClass1 */

        public final void run() {
            Intent intent = new Intent();
            intent.setAction("miot_activit_finish_tag");
            LocalBroadcastManager.getInstance(fsp.O000000o().O00000Oo).sendBroadcast(intent);
            gsy.O000000o(6, BaseActivity.TAG, "finish page");
        }
    };
    private Context mApplicationContext;
    private final BroadcastReceiver mFinishReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.frame.baseui.BasePluginActivity.AnonymousClass3 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "miot_activit_finish_tag") && BasePluginActivity.this.mIsPaused) {
                BasePluginActivity.this.finish();
            }
        }
    };
    private String mFullReferer;
    private final BroadcastReceiver mHomeKeyReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.frame.baseui.BasePluginActivity.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                fsp.O000000o().O00000o0.removeCallbacks(BasePluginActivity.sClearRunnable);
                fsp.O000000o().O00000o0.postDelayed(BasePluginActivity.sClearRunnable, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                gsy.O000000o(6, BaseActivity.TAG, "add Callback");
            }
        }
    };
    protected boolean mIsPaused = false;
    long mOnResumeTimestamp;
    String mPageName;
    private Resources mResource;
    private String mSingleReferer;

    /* access modifiers changed from: protected */
    public String getPageName() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        hyy.O000000o(this);
        fixLocalIfNeeded();
        super.onCreate(bundle);
        fsp.O000000o().O0000O0o.O000000o();
        registerReceiver(this.mHomeKeyReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        LocalBroadcastManager.getInstance(fsp.O000000o().O00000Oo).registerReceiver(this.mFinishReceiver, new IntentFilter("miot_activit_finish_tag"));
        requestWindowFeature(1);
        Intent intent = getIntent();
        if (!(this instanceof PluginHostActivity)) {
            this.mSingleReferer = intent.getStringExtra("single_referer_key");
            this.mFullReferer = intent.getStringExtra("full_referer_key");
        }
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        hyy.O0000O0o(this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        hyy.O00000Oo(this);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        hyy.O00000Oo(this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        hyy.O00000Oo(this);
    }

    public void onResume() {
        super.onResume();
        hyy.O00000o();
        this.mIsPaused = false;
        fsp.O000000o().O00000o0.removeCallbacks(sClearRunnable);
        CoreApi O000000o2 = CoreApi.O000000o();
        try {
            O000000o2.O00000Oo().onActivityResume(getPageName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        gsy.O000000o(6, BaseActivity.TAG, "Remove Callback");
        this.mPageName = getPageName();
        if (TextUtils.isEmpty(this.mPageName)) {
            this.mPageName = getClass().getName();
            String packageName = getPackageName();
            if (this.mPageName.startsWith(packageName)) {
                this.mPageName = this.mPageName.replace(packageName, "");
            }
        }
        this.mOnResumeTimestamp = hxi.O00000Oo.O000000o(this, this.mPageName);
        CoreApi.O000000o().O000000o(this.mPageName, getSingleReferer());
    }

    public void onPause() {
        super.onPause();
        hyy.O00000o0();
        this.mIsPaused = true;
        if (!(this instanceof PluginHostActivity)) {
            hxi.O00000Oo.O000000o(this, this.mOnResumeTimestamp, this.mPageName);
            CoreApi.O000000o().O000000o(this.mPageName, getSingleReferer(), (int) (this.mOnResumeTimestamp / 1000));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        fsp.O000000o().O0000O0o.O00000Oo();
        unregisterReceiver(this.mHomeKeyReceiver);
        LocalBroadcastManager.getInstance(fsp.O000000o().O00000Oo).unregisterReceiver(this.mFinishReceiver);
    }

    public String getSingleReferer() {
        String str = this.mSingleReferer;
        return str == null ? "" : str;
    }

    public String getFullReferer() {
        String str = this.mFullReferer;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: protected */
    public boolean shouldFixLocale() {
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            return true;
        }
        LocaleList locales = getResources().getConfiguration().getLocales();
        if (locales == null) {
            return false;
        }
        if (!locales.isEmpty() && O00oOooo.equals(locales.get(0))) {
            return false;
        }
        return true;
    }

    private void fixLocalIfNeeded() {
        if (shouldFixLocale() && Build.VERSION.SDK_INT >= 24) {
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    O00oOooo = Resources.getSystem().getConfiguration().getLocales().get(0);
                } else {
                    O00oOooo = Locale.getDefault();
                }
            }
            Configuration configuration = new Configuration(getResources().getConfiguration());
            configuration.setLocale(O00oOooo);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        Locale O00oOooo;
        if (Build.VERSION.SDK_INT >= 17 && (O00oOooo = CoreApi.O000000o().O00oOooo()) != null) {
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17) {
                configuration.setLocale(O00oOooo);
                context = context.createConfigurationContext(configuration);
            }
        }
        super.attachBaseContext(context);
    }

    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isValid() {
        if (isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !isDestroyed()) {
            return true;
        }
        return false;
    }

    public Resources getResources() {
        if (!hyy.O000000o(getIntent())) {
            return super.getResources();
        }
        if (this.mResource == null) {
            Resources resources = super.getResources();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(resources.getDisplayMetrics());
            Configuration configuration = new Configuration();
            configuration.setTo(resources.getConfiguration());
            this.mResource = new Resources(resources.getAssets(), displayMetrics, configuration);
        }
        return this.mResource;
    }

    public void finish() {
        hyy.O000000o(this, new Runnable() {
            /* class com.xiaomi.smarthome.frame.baseui.$$Lambda$BasePluginActivity$7uSXPZc6MBrycwnHp_hNJTUuCs */

            public final void run() {
                BasePluginActivity.this.lambda$finish$0$BasePluginActivity();
            }
        });
    }

    public /* synthetic */ void lambda$finish$0$BasePluginActivity() {
        super.finish();
    }

    public Context getApplicationContext() {
        if (this.mApplicationContext == null) {
            this.mApplicationContext = hyy.O00000oo(this);
        }
        return this.mApplicationContext;
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        hyy.O000000o(this, intent);
        super.startActivityForResult(intent, i, bundle);
    }

    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(i, i2);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hyy.O000000o(this, configuration);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        hyy.O000000o(this, i2, intent);
    }
}
