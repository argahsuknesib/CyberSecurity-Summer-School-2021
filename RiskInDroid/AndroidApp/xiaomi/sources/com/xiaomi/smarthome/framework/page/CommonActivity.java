package com.xiaomi.smarthome.framework.page;

import _m_j.cub;
import _m_j.ft;
import _m_j.ftn;
import _m_j.fut;
import _m_j.fvk;
import _m_j.fvl;
import _m_j.gpc;
import _m_j.gqd;
import _m_j.gsy;
import _m_j.gwc;
import _m_j.gwg;
import _m_j.hxi;
import _m_j.hyy;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.framework.crash.MainCrashHandler;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class CommonActivity extends AppCompatActivity implements fut, fvk.O000000o {
    public static String ACTION_SPLIT_SCREEN_MODE_CHANGED = "split_screen_mode_changed";
    public static Map<Integer, WeakReference<Activity>> mActivityStack = new TreeMap();
    private static int sDefaultNavBarColor = Color.argb(255, 255, 255, 255);
    private Context mApplicationContext;
    private final BroadcastReceiver mBaseActivityLocalReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.framework.page.CommonActivity.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "miot_activit_finish_tag") && CommonActivity.this.mIsPaused) {
                CommonActivity.this.finish();
            }
        }
    };
    private final BroadcastReceiver mBaseActivityReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.framework.page.CommonActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                CommonActivity.this.onHomeKeyPressed();
                CommonApplication.getGlobalHandler().removeCallbacks(fvl.f17280O000000o);
                CommonApplication.getGlobalHandler().postDelayed(fvl.f17280O000000o, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
            }
        }
    };
    public long mEnterTime;
    private String mFullReferer;
    public Handler mHandler;
    private final IntentFilter mIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    private boolean mIsDelayFrescoInit = false;
    public boolean mIsDestroyed = false;
    public boolean mIsPaused = false;
    private final IntentFilter mLocalIntentFilter = new IntentFilter("miot_activit_finish_tag");
    long mOnresumeTimestamp;
    public String mPageId = "";
    String mPageName;
    private Resources mResource;
    private String mSingleReferer;
    private XQProgressDialog progressDialog;

    /* access modifiers changed from: protected */
    public boolean enablePageId() {
        return true;
    }

    /* access modifiers changed from: protected */
    public String getActivityName() {
        return null;
    }

    public Context getContext() {
        return this;
    }

    public void handleMessage(Message message) {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public void onHomeKeyPressed() {
    }

    /* access modifiers changed from: protected */
    public boolean useActivityAsStat() {
        return true;
    }

    public void setDelayFrescoInit() {
        this.mIsDelayFrescoInit = true;
    }

    /* access modifiers changed from: protected */
    public boolean shouldFixLocale() {
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        Locale O00000o0 = ftn.O00000o0(this);
        if (O00000o0 == null) {
            return true;
        }
        LocaleList locales = getResources().getConfiguration().getLocales();
        if (locales == null) {
            return false;
        }
        if (!locales.isEmpty() && O00000o0.equals(locales.get(0))) {
            return false;
        }
        return true;
    }

    private void fixLocalIfNeeded() {
        if (shouldFixLocale() && Build.VERSION.SDK_INT >= 24) {
            Locale O00000o0 = ftn.O00000o0(getApplicationContext());
            if (O00000o0 == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    O00000o0 = Resources.getSystem().getConfiguration().getLocales().get(0);
                } else {
                    O00000o0 = Locale.getDefault();
                }
            }
            gwc.O000000o(O00000o0);
        }
    }

    public void onCreate(Bundle bundle) {
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && TextUtils.equals("android.intent.action.MAIN", action)) {
                finish();
            }
        }
        hyy.O000000o(this);
        fixLocalIfNeeded();
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 24) {
            CommonApplication.setInSplitScreenMode(isInMultiWindowMode());
        }
        registerReceiver(this.mBaseActivityReceiver, this.mIntentFilter);
        try {
            requestWindowFeature(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (CommonApplication.getAppContext() != null) {
            ft.O000000o(CommonApplication.getAppContext()).O000000o(this.mBaseActivityLocalReceiver, this.mLocalIntentFilter);
        }
        if (bundle != null) {
            CommonApplication.getApplication().onApplicationLifeCycleStart();
        }
        ActivityStack.instance.registerActivityListener(this);
        Intent intent2 = getIntent();
        if (enablePageId()) {
            this.mPageId = getIntent().getStringExtra("iid");
        }
        this.mSingleReferer = intent2.getStringExtra("single_referer_key");
        this.mFullReferer = intent2.getStringExtra("full_refetitle_barrer_key");
        this.mHandler = new fvk(this);
        setNavBarColor();
        mActivityStack.put(Integer.valueOf(hashCode()), new WeakReference(this));
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        hyy.O0000O0o(this);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        hyy.O00000Oo(this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        hyy.O00000Oo(this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        hyy.O00000Oo(this);
    }

    private void setNavBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setNavigationBarColor(getPageNavBarColor());
        }
    }

    /* access modifiers changed from: protected */
    public int getPageNavBarColor() {
        return getResources().getColor(R.color.mj_color_white);
    }

    public void onContentChanged() {
        super.onContentChanged();
        if (hyy.O000000o(getIntent())) {
            gwg.O000000o(this, null, 0);
        } else {
            gwg.O00000o(this);
        }
    }

    public String getSingleReferer() {
        String str = this.mSingleReferer;
        return str == null ? "" : str;
    }

    public String getFullReferer() {
        String str = this.mFullReferer;
        return str == null ? "" : str;
    }

    public void onResume() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed($$Lambda$CommonActivity$HDVF_5Ci0oQKZzSObbG9fNfHqTE.INSTANCE, 1000);
        }
        try {
            super.onResume();
            this.mIsDestroyed = false;
            this.mIsPaused = false;
            this.mEnterTime = System.currentTimeMillis();
            CommonApplication.getGlobalHandler().removeCallbacks(fvl.f17280O000000o);
            if (useActivityAsStat()) {
                this.mPageName = getActivityName();
                if (TextUtils.isEmpty(this.mPageName)) {
                    this.mPageName = getClass().getName();
                    String packageName = getPackageName();
                    if (this.mPageName.startsWith(packageName)) {
                        this.mPageName = this.mPageName.replace(packageName, "");
                    }
                }
                this.mOnresumeTimestamp = hxi.O00000Oo.O000000o(this, this.mPageName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogType logType = LogType.GENERAL;
            gsy.O00000o0(logType, "", "Exception in super.onResume in " + this + ":" + e.getMessage());
            MainCrashHandler.O000000o(e);
            Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity");
            if (O00000Oo != null) {
                Intent intent = new Intent(this, O00000Oo);
                intent.setFlags(268468224);
                startActivity(intent);
            }
            finish();
        }
    }

    public void onPause() {
        super.onPause();
        this.mIsPaused = true;
        if (useActivityAsStat()) {
            hxi.O00000Oo.O000000o(this, this.mOnresumeTimestamp, this.mPageName);
        }
    }

    public void onDestroy() {
        this.mIsDestroyed = true;
        unregisterReceiver(this.mBaseActivityReceiver);
        CoreApi O000000o2 = CoreApi.O000000o();
        int hashCode = hashCode();
        O000000o2.O00000o0.post(new Runnable(hashCode) {
            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass12 */

            /* renamed from: O000000o */
            final /* synthetic */ int f7436O000000o;

            {
                this.f7436O000000o = r2;
            }

            public final void run() {
                for (int i = 0; i < CoreApi.this.O00000oO.size(); i++) {
                    O000O0OO o000o0oo = CoreApi.this.O00000oO.get(i);
                    if (!(o000o0oo.O00000Oo != this.f7436O000000o || o000o0oo.O00000o0 == null || o000o0oo.O00000o0.get() == null)) {
                        o000o0oo.O00000o0.get().cancel();
                    }
                }
            }
        });
        O000000o2.O00000o0.post(new Runnable(hashCode) {
            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass15 */

            /* renamed from: O000000o */
            final /* synthetic */ int f7439O000000o;

            {
                this.f7439O000000o = r2;
            }

            public final void run() {
                for (int i = 0; i < CoreApi.this.O00000oo.size(); i++) {
                    O000O00o o000O00o = CoreApi.this.O00000oo.get(i);
                    if (!(o000O00o.O00000Oo != this.f7439O000000o || o000O00o.O00000o0 == null || o000O00o.O00000o0.get() == null)) {
                        o000O00o.O00000o0.get().cancel();
                    }
                }
            }
        });
        ActivityStack.instance.unregisterActivityListener(this);
        if (CommonApplication.getAppContext() != null) {
            ft.O000000o(CommonApplication.getAppContext()).O000000o(this.mBaseActivityLocalReceiver);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (!(getWindow() == null || getWindow().getDecorView() == null || getWindow().getDecorView().getHandler() == null)) {
            getWindow().getDecorView().getHandler().removeCallbacksAndMessages(null);
        }
        try {
            CommonApplication.getGlobalHandler().postDelayed(new O000000o((byte) 0), 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            super.onDestroy();
            mActivityStack.remove(Integer.valueOf(hashCode()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        hyy.O000000o(this, i2, intent);
    }

    public void setRequestedOrientation(int i) {
        if (Build.VERSION.SDK_INT != 26 || !gpc.O00000o0(this)) {
            try {
                super.setRequestedOrientation(i);
            } catch (Exception unused) {
                gsy.O00000o0(LogType.GENERAL, "CommonActivity", "setRequestedOrientation error");
            }
        }
    }

    static class O000000o implements Runnable {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final void run() {
            System.gc();
            CoreApi.O000000o().O0000Oo0();
        }
    }

    public void onUnauthorized() {
        if (getClass() != cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity")) {
            finish();
        }
        ((PluginHostApi) PluginHostApi.instance()).login(this, 2);
    }

    public void onActivityResume(int i, int i2, String str) {
        CommonApplication.getGlobalHandler().removeCallbacks(fvl.f17280O000000o);
    }

    public void onServerChanged() {
        finish();
    }

    public boolean isValid() {
        return gqd.O000000o((Activity) this);
    }

    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        CommonApplication.setInSplitScreenMode(z);
        ft.O000000o(this).O000000o(new Intent(ACTION_SPLIT_SCREEN_MODE_CHANGED));
    }

    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
        CommonApplication.setInSplitScreenMode(z);
        ft.O000000o(this).O000000o(new Intent(ACTION_SPLIT_SCREEN_MODE_CHANGED));
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(gwc.O00000Oo(context));
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog = this.progressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }

    public void showProgressDialog(CharSequence charSequence) {
        showProgressDialog(charSequence, false, null);
    }

    public void showProgressDialog(CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        if (this.progressDialog == null) {
            this.progressDialog = new XQProgressDialog(this);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.progressDialog.setMessage(charSequence);
        }
        this.progressDialog.setCancelable(z);
        if (onCancelListener != null) {
            this.progressDialog.setOnCancelListener(onCancelListener);
        }
        if (!isDestroyed() && !isFinishing()) {
            this.progressDialog.show();
        }
    }

    public Resources getResources() {
        if (!hyy.O000000o(getIntent())) {
            return getLocalizedResources(this, super.getResources());
        }
        if (this.mResource == null) {
            Resources resources = super.getResources();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(resources.getDisplayMetrics());
            Configuration configuration = new Configuration();
            createConfigurationContext(configuration);
            configuration.setTo(resources.getConfiguration());
            AssetManager assetManager = null;
            try {
                assetManager = createPackageContext(getPackageName(), 1).getResources().getAssets();
            } catch (PackageManager.NameNotFoundException e) {
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "CommonActivity", "createPackageContext error:" + Log.getStackTraceString(e));
            }
            if (assetManager == null) {
                assetManager = resources.getAssets();
            }
            this.mResource = new Resources(assetManager, displayMetrics, configuration);
        }
        return this.mResource;
    }

    private Resources getLocalizedResources(Activity activity, Resources resources) {
        try {
            if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 25) {
                Configuration configuration = resources.getConfiguration();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                configuration.locale = gwc.O00000o0();
                resources.updateConfiguration(configuration, displayMetrics);
            }
        } catch (Exception e) {
            gsy.O000000o(LogType.MAIN_PAGE.value(), "Locale_setting", e.getMessage());
        }
        return resources;
    }

    public Context getApplicationContext() {
        if (this.mApplicationContext == null) {
            this.mApplicationContext = hyy.O00000oo(this);
        }
        return this.mApplicationContext;
    }

    public void finish() {
        hyy.O000000o(this, new Runnable() {
            /* class com.xiaomi.smarthome.framework.page.$$Lambda$CommonActivity$z4zZXzfu_TB5ErhbBR7mPEsWPw */

            public final void run() {
                CommonActivity.this.lambda$finish$1$CommonActivity();
            }
        });
    }

    public /* synthetic */ void lambda$finish$1$CommonActivity() {
        super.finish();
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        hyy.O000000o(this, intent);
        super.startActivityForResult(intent, i, bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hyy.O000000o(this, configuration);
    }
}
