package com.xiaomi.smarthome.frame.plugin.runtime.activity;

import _m_j.fcx;
import _m_j.fqx;
import _m_j.fsp;
import _m_j.ftm;
import _m_j.gsy;
import _m_j.hxh;
import _m_j.hyy;
import _m_j.izb;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.BleUpgrader;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.core.server.internal.plugin.DynamicFeatureManager;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.FaceManagerCallback;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.XmPluginBaseActivity;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.baseui.BasePluginActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.RunningProcess;
import com.xiaomi.smarthome.frame.plugin.debug.PluginErrorInfoActivity;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService;
import com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate;
import com.xiaomi.smarthome.frame.plugin.runtime.util.SpecialPinDeviceUtil;
import com.xiaomi.smarthome.frame.plugin.runtime.util.TitleBarUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginHostActivity extends BasePluginActivity implements IXmPluginHostActivity {
    private static ArrayList<WeakReference<PluginHostActivity>> mPluginHostActivityRefStack = new ArrayList<>();
    private static Handler sHandle = null;
    public boolean backPressEnable = true;
    private String mClass;
    DeviceStat mDevice;
    boolean mEnableVerifyPincode = false;
    boolean mIsReady = true;
    boolean mIsSupportAd = false;
    boolean mIsVerifyed = false;
    private XmPluginPackage mLoadedInfo;
    String mModel;
    private OfflineViewDelegate mOfflineViewDelegate;
    List<Runnable> mOnReadyRunableList = new ArrayList();
    private long mOnResumeTimestamp;
    private String mPageName;
    private Resources mResources;
    Resources.Theme mTheme;
    private XmPluginBaseActivity mXmPluginActivity;

    public final FragmentActivity activity() {
        return this;
    }

    protected static Handler getHandler() {
        if (sHandle == null) {
            sHandle = new Handler(Looper.getMainLooper()) {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    if (message.what == 1) {
                        System.exit(0);
                    }
                }
            };
        }
        return sHandle;
    }

    private static synchronized void pushPluginHostActivity(PluginHostActivity pluginHostActivity) {
        synchronized (PluginHostActivity.class) {
            if (pluginHostActivity != null) {
                getHandler().removeMessages(1);
                mPluginHostActivityRefStack.add(new WeakReference(pluginHostActivity));
            }
        }
    }

    public static synchronized PluginHostActivity getTopPluginHostActivity() {
        synchronized (PluginHostActivity.class) {
            if (mPluginHostActivityRefStack.size() <= 0) {
                return null;
            }
            ArrayList<WeakReference<PluginHostActivity>> arrayList = mPluginHostActivityRefStack;
            PluginHostActivity pluginHostActivity = (PluginHostActivity) arrayList.get(arrayList.size() - 1).get();
            return pluginHostActivity;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        return;
     */
    private static synchronized void popPluginHostActivity(PluginHostActivity pluginHostActivity) {
        synchronized (PluginHostActivity.class) {
            if (pluginHostActivity != null) {
                int size = mPluginHostActivityRefStack.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    } else if (mPluginHostActivityRefStack.get(size).get() == pluginHostActivity) {
                        mPluginHostActivityRefStack.remove(size);
                        break;
                    } else {
                        size--;
                    }
                }
                if (mPluginHostActivityRefStack.size() == 0 && !ftm.O000000o(CommonApplication.getAppContext())) {
                    getHandler().sendEmptyMessageDelayed(1, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                }
            }
        }
    }

    public static synchronized void resetPluginHostActivity() {
        synchronized (PluginHostActivity.class) {
            mPluginHostActivityRefStack.clear();
        }
    }

    public XmPluginPackage getXmPluginPackage() {
        return this.mLoadedInfo;
    }

    public Resources getResources() {
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public AssetManager getAssets() {
        XmPluginPackage xmPluginPackage = this.mLoadedInfo;
        if (xmPluginPackage == null || xmPluginPackage.getAssetManager() == null || DynamicFeatureManager.instance.isDynamicFeature(this.mModel)) {
            return super.getAssets();
        }
        return this.mLoadedInfo.getAssetManager();
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.mTheme;
        return theme == null ? super.getTheme() : theme;
    }

    public ClassLoader getClassLoader() {
        XmPluginPackage xmPluginPackage = this.mLoadedInfo;
        if (xmPluginPackage == null) {
            return super.getClassLoader();
        }
        return xmPluginPackage.classLoader;
    }

    public void onCreate(final Bundle bundle) {
        gsy.O000000o(3, "PluginHostActivity", "onCreate");
        if (Build.VERSION.SDK_INT >= 29) {
            if (XmPluginHostApi.instance().isRNPluginDarkMode()) {
                setTheme((int) R.style.NoActionBarPluginDarkAllow);
            } else {
                setTheme((int) R.style.NoActionBarPlugin);
            }
        }
        if (bundle != null) {
            bundle.remove("android:support:fragments");
            bundle.remove("android:fragments");
        }
        super.onCreate(bundle);
        TitleBarUtil.enableTranslucentStatus(getWindow());
        if (!CoreApi.O000000o().O0000O0o()) {
            gsy.O000000o(6, "PluginHostActivity", "core process not ready,initial core process");
            this.mIsReady = false;
            this.mOnReadyRunableList.clear();
            this.mOnReadyRunableList.add(new Runnable() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass2 */

                public void run() {
                    PluginHostActivity.this.doCreate(bundle);
                }
            });
            CoreApi.O000000o().O000000o(getApplicationContext(), new CoreApi.O0000o0() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass3 */

                public void onCoreReady() {
                    CoreApi.O000000o().O000000o(PluginHostActivity.this.getApplicationContext(), new CoreApi.O0000o() {
                        /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass3.AnonymousClass1 */

                        public void onPluginCacheReady() {
                            if (CoreApi.O000000o().O0000O0o()) {
                                PluginHostActivity.this.mIsReady = true;
                                for (int i = 0; i < PluginHostActivity.this.mOnReadyRunableList.size(); i++) {
                                    PluginHostActivity.this.mOnReadyRunableList.get(i).run();
                                }
                                PluginHostActivity.this.mOnReadyRunableList.clear();
                                return;
                            }
                            gsy.O000000o(6, "PluginHostActivity", "core process not ready");
                            PluginHostActivity.this.mOnReadyRunableList.clear();
                            PluginHostActivity.this.finish();
                        }
                    });
                }
            });
            return;
        }
        this.mIsReady = true;
        doCreate(bundle);
    }

    /* access modifiers changed from: package-private */
    public void doCreate(Bundle bundle) {
        DeviceStat deviceStat;
        Intent intent = getIntent();
        Set<String> categories = intent.getCategories();
        String str = "";
        if (categories != null) {
            for (String next : categories) {
                if (next.startsWith("did:")) {
                    str = next.substring(4);
                } else if (next.startsWith("model:")) {
                    this.mModel = next.substring(6);
                }
            }
        }
        if (bundle != null) {
            if (bundle.getBoolean("extra_recycle_plugin", false)) {
                finish();
                return;
            }
            gsy.O000000o(3, "PluginHostActivity", "has savedInstanceState");
            if (bundle.containsKey("extra_device_did")) {
                str = bundle.getString("extra_device_did");
            }
            gsy.O000000o(3, "PluginHostActivity", "savedInstanceState did:".concat(String.valueOf(str)));
            if (bundle.containsKey("extra_device")) {
                this.mDevice = (DeviceStat) bundle.getParcelable("extra_device");
            }
            gsy.O000000o(3, "PluginHostActivity", "savedInstanceState device:" + this.mDevice);
            if (bundle.containsKey("extra_device_model")) {
                this.mModel = bundle.getString("extra_device_model");
            }
            gsy.O000000o(3, "PluginHostActivity", "savedInstanceState model:" + this.mModel);
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.mModel)) {
            str = intent.getStringExtra("extra_device_did");
        }
        if (!TextUtils.isEmpty(str) && this.mDevice == null) {
            this.mDevice = PluginBridgeService.getCachedDeviceStat(str);
            if (this.mDevice == null) {
                this.mDevice = XmPluginHostApi.instance().getDeviceByDid(str);
            }
        }
        if (this.mDevice == null) {
            gsy.O000000o(6, "PluginHostActivity", "device is null");
        }
        DeviceStat deviceStat2 = this.mDevice;
        if (deviceStat2 != null) {
            this.mModel = deviceStat2.model;
        }
        if (TextUtils.isEmpty(this.mModel)) {
            try {
                this.mModel = intent.getStringExtra("extra_device_model");
            } catch (Throwable th) {
                PluginErrorInfoActivity.showErrorInfo(this, null, th);
                finish();
                return;
            }
        }
        if (TextUtils.isEmpty(this.mModel)) {
            gsy.O000000o(6, "PluginHostActivity", "model is null");
            finish();
            return;
        }
        PluginPackageInfo O00000Oo = fcx.f16092O000000o.O00000Oo(this.mModel);
        if (O00000Oo == null) {
            gsy.O000000o(6, "PluginHostActivity", "not found PluginRecord");
            finish();
            return;
        }
        this.mLoadedInfo = PluginRuntimeManager.getInstance().getXmPluginPackage(O00000Oo);
        XmPluginPackage xmPluginPackage = this.mLoadedInfo;
        if (xmPluginPackage == null) {
            gsy.O000000o(6, "PluginHostActivity", "not found loadedinfo");
            setResult(0);
            finish();
            return;
        }
        this.mResources = new Resources(xmPluginPackage.getAssetManager(), getResources().getDisplayMetrics(), getResources().getConfiguration());
        if (DynamicFeatureManager.instance.isDynamicFeature(this.mModel)) {
            SplitCompat.installActivity(this);
        }
        this.mClass = intent.getStringExtra("extra_class");
        getActivityInfo();
        handleActivityInfo();
        Intent intent2 = (Intent) intent.getParcelableExtra("plugin_extra");
        if (intent2 == null) {
            intent2 = new Intent();
        }
        intent2.setExtrasClassLoader(this.mLoadedInfo.classLoader);
        intent.removeExtra("plugin_extra");
        intent2.putExtras(intent);
        launchActivity(intent2);
        pushPluginHostActivity(this);
        if (intent != null) {
            long currentTimeMillis = System.currentTimeMillis();
            gsy.O000000o(3, "DebugTime", "LaunchPluginActivityCreateTime:".concat(String.valueOf(currentTimeMillis - intent.getLongExtra("__StartTime__", currentTimeMillis))));
        }
        this.mOfflineViewDelegate = new OfflineViewDelegate(this, this.mDevice);
        this.mOfflineViewDelegate.onCreate();
        if (!intent.getBooleanExtra("jump_form_plugin_host", false)) {
            this.mOfflineViewDelegate.showOfflineIfNeeded(hyy.O00000oO(this));
            if (PluginBridgeService.msgType == 1) {
                this.mOfflineViewDelegate.showWeakRssiIfNeed(hyy.O00000oO(this));
            }
        }
        if (!this.mEnableVerifyPincode && (deviceStat = this.mDevice) != null) {
            this.mEnableVerifyPincode = SpecialPinDeviceUtil.isSecurityPinNativePlugin(deviceStat.model) && this.mDevice.isSetPinCode != 0;
        }
        DeviceStat deviceStat3 = this.mDevice;
        if (deviceStat3 != null && this.mEnableVerifyPincode) {
            if (fqx.O000000o(deviceStat3.model, this.mDevice.version)) {
                if (TextUtils.isEmpty(LockSecurePinUtil.getPropLtmk(this.mDevice.mac)) || TextUtils.isEmpty(LockSecurePinUtil.getPropPincode(this.mDevice.mac)) || LockSecurePinUtil.getPropShowPincode(this.mDevice.mac)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("extra_device_did", this.mDevice.did);
                    fsp.O000000o().O0000Oo.openVerfyPincode(this, bundle2, 9999);
                    if (LockSecurePinUtil.isNetworkAvailable(this)) {
                        LockSecurePinUtil.checkSecurePinChanged(this, this.mDevice.did, this.mDevice.mac);
                        LockSecurePinUtil.checkLtmkChanged(this, this.mDevice.did, this.mDevice.mac, true);
                    }
                } else if (LockSecurePinUtil.isNetworkAvailable(this)) {
                    LockSecurePinUtil.checkSecurePinChanged(this, this.mDevice.did, this.mDevice.mac);
                    LockSecurePinUtil.checkLtmkChanged(this, this.mDevice.did, this.mDevice.mac, false);
                }
            } else if (this.mDevice.isSetPinCode != 0) {
                Bundle bundle3 = new Bundle();
                bundle3.putString("extra_device_did", this.mDevice.did);
                fsp.O000000o().O0000Oo.openVerfyPincode(this, bundle3, 9999);
            }
        }
        if (this.mIsSupportAd && this.mDevice != null) {
            fsp.O000000o().O0000Oo.sendPluginAdRequest(this, this.mModel, this.mDevice.version);
        }
        gsy.O000000o(6, "PluginLocale", getResources().getConfiguration().locale.toString());
    }

    private void getActivityInfo() {
        XmPluginPackage xmPluginPackage = this.mLoadedInfo;
        if (xmPluginPackage != null) {
            PackageInfo packageInfo = xmPluginPackage.packageInfo;
            if (packageInfo.activities != null && packageInfo.activities.length > 0 && this.mClass == null) {
                this.mClass = packageInfo.activities[0].name;
            }
        }
    }

    private void handleActivityInfo() {
        Resources.Theme theme = super.getTheme();
        this.mTheme = getResources().newTheme();
        this.mTheme.setTo(theme);
        try {
            this.mTheme.applyStyle(Build.VERSION.SDK_INT >= 14 ? 16974120 : 16973829, Build.VERSION.SDK_INT < 29);
        } catch (Exception unused) {
        }
    }

    private void launchActivity(Intent intent) {
        XmPluginPackage xmPluginPackage = this.mLoadedInfo;
        if (xmPluginPackage != null) {
            try {
                this.mXmPluginActivity = (XmPluginBaseActivity) xmPluginPackage.classLoader.loadClass(this.mClass).getConstructor(new Class[0]).newInstance(new Object[0]);
                this.mXmPluginActivity.attach(this, this.mLoadedInfo, this.mDevice);
                this.mXmPluginActivity.setIntent(intent);
                this.mXmPluginActivity.onCreate(intent.getExtras());
            } catch (Throwable th) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, th);
                finish();
            }
        } else {
            try {
                this.mXmPluginActivity = (XmPluginBaseActivity) getClassLoader().loadClass(this.mClass).getConstructor(new Class[0]).newInstance(new Object[0]);
                this.mXmPluginActivity.attach(this, this.mLoadedInfo, this.mDevice);
                this.mXmPluginActivity.setIntent(intent);
                this.mXmPluginActivity.onCreate(intent.getExtras());
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void recreate() {
        super.recreate();
        if (this.mIsReady) {
            doRecreate();
        } else {
            this.mOnReadyRunableList.add(new Runnable() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass4 */

                public void run() {
                    PluginHostActivity.this.doRecreate();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void doRecreate() {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.recreate();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onPostCreate(final Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.mIsReady) {
            doPostCreate(bundle);
        } else {
            this.mOnReadyRunableList.add(new Runnable() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass5 */

                public void run() {
                    PluginHostActivity.this.doPostCreate(bundle);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void doPostCreate(Bundle bundle) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onPostCreate(bundle);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: package-private */
    public void doStart() {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onStart();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public String getPageName() {
        if (this.mXmPluginActivity == null) {
            return "";
        }
        return this.mModel + ":" + this.mXmPluginActivity.getClass().getName();
    }

    public void onResume() {
        super.onResume();
        if (this.mIsReady) {
            doStart();
            doResume();
            return;
        }
        this.mOnReadyRunableList.add(new Runnable() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass6 */

            public void run() {
                PluginHostActivity.this.doStart();
                PluginHostActivity.this.doResume();
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    /* access modifiers changed from: package-private */
    public void doResume() {
        this.mOnResumeTimestamp = System.currentTimeMillis();
        this.mPageName = getPageName();
        if (TextUtils.isEmpty(this.mPageName)) {
            this.mPageName = getClass().getName();
        }
        if (this.mLoadedInfo != null) {
            String str = "plugin." + this.mLoadedInfo.getPluginId() + "." + this.mLoadedInfo.getPackageId();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.mPageName);
                jSONObject.put("timestamp", this.mOnResumeTimestamp / 1000);
                jSONObject.put("plugin_id", this.mLoadedInfo.getPluginId());
                jSONObject.put("package_id", this.mLoadedInfo.getPackageId());
            } catch (JSONException unused) {
            }
            if (this.mDevice != null) {
                hxh.O000000o(hxh.O000000o(this.mLoadedInfo.getPluginId(), this.mLoadedInfo.getPackageId()), this.mDevice.model, this.mDevice.did, this, this.mPageName);
            }
            CoreApi.O000000o().O000000o(StatType.EVENT, str, "page_start", jSONObject.toString(), (String) null, false);
            CoreApi.O000000o().O000O0Oo();
        }
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onResume();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onPostResume() {
        try {
            super.onPostResume();
            if (this.mIsReady) {
                doPostResume();
            } else {
                this.mOnReadyRunableList.add(new Runnable() {
                    /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass7 */

                    public void run() {
                        PluginHostActivity.this.doPostResume();
                    }
                });
            }
        } catch (Exception e) {
            PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void doPostResume() {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onPostResume();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    public void onPause() {
        super.onPause();
        if (this.mLoadedInfo != null) {
            String str = "plugin." + this.mLoadedInfo.getPluginId() + "." + this.mLoadedInfo.getPackageId();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.mPageName);
                jSONObject.put("timestamp", this.mOnResumeTimestamp);
                jSONObject.put("plugin_id", this.mLoadedInfo.getPluginId());
                jSONObject.put("package_id", this.mLoadedInfo.getPackageId());
            } catch (JSONException unused) {
            }
            if (this.mDevice != null) {
                hxh.O000000o(hxh.O000000o(this.mLoadedInfo.getPluginId(), this.mLoadedInfo.getPackageId()), this.mDevice.model, this.mDevice.did, this, this.mOnResumeTimestamp, this.mPageName);
            }
            CoreApi.O000000o().O000000o(StatType.EVENT, str, "page_end", jSONObject.toString(), (String) null, false);
            CoreApi.O000000o().O000O0Oo();
        }
        doPause();
        doStop();
    }

    private void doPause() {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onPause();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onStop() {
        super.onStop();
    }

    private void doStop() {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onStop();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        gsy.O000000o(3, "PluginHostActivity", "onDestroy");
        if (this.mIsSupportAd) {
            fsp.O000000o().O0000Oo.stopPluginAd(this.mModel);
        }
        popPluginHostActivity(this);
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onDestroy();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return;
            }
        }
        OfflineViewDelegate offlineViewDelegate = this.mOfflineViewDelegate;
        if (offlineViewDelegate != null) {
            offlineViewDelegate.onDestroy();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        gsy.O000000o(3, "PluginHostActivity", "onSaveInstanceState   outState");
        DeviceStat deviceStat = this.mDevice;
        if (deviceStat != null) {
            bundle.putString("extra_device_did", deviceStat.did);
            bundle.putParcelable("extra_device", this.mDevice);
        }
        if (!TextUtils.isEmpty(this.mModel)) {
            bundle.putString("extra_device_model", this.mModel);
        }
        bundle.putBoolean("extra_recycle_plugin", true);
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onSaveInstanceState(bundle);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
        gsy.O000000o(3, "PluginHostActivity", "onSaveInstanceState");
        DeviceStat deviceStat = this.mDevice;
        if (deviceStat != null) {
            bundle.putString("extra_device_did", deviceStat.did);
            bundle.putParcelable("extra_device", this.mDevice);
        }
        if (!TextUtils.isEmpty(this.mModel)) {
            bundle.putString("extra_device_model", this.mModel);
        }
        bundle.putBoolean("extra_recycle_plugin", true);
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onSaveInstanceState(bundle);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(final Bundle bundle) {
        try {
            if (this.mLoadedInfo != null || !bundle.getBoolean("extra_recycle_plugin", false)) {
                super.onRestoreInstanceState(bundle);
                if (this.mIsReady) {
                    doRestoreInstanceState(bundle);
                } else {
                    this.mOnReadyRunableList.add(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass8 */

                        public void run() {
                            PluginHostActivity.this.doRestoreInstanceState(bundle);
                        }
                    });
                }
            }
        } catch (Exception e) {
            PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void doRestoreInstanceState(Bundle bundle) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onRestoreInstanceState(bundle);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onActivityResult(final int i, final int i2, final Intent intent) {
        super.onActivityResult(i, i2, intent);
        gsy.O000000o(3, "PluginHostActivity", "onActivityResult");
        if (this.mIsReady) {
            doActivityResult(i, i2, intent);
        } else {
            this.mOnReadyRunableList.add(new Runnable() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass9 */

                public void run() {
                    PluginHostActivity.this.doActivityResult(i, i2, intent);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void doActivityResult(int i, int i2, Intent intent) {
        if (9999 != i) {
            XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
            if (xmPluginBaseActivity != null) {
                try {
                    xmPluginBaseActivity.onActivityResult(i, i2, intent);
                } catch (Exception e) {
                    PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                    finish();
                }
            }
        } else if (i2 == 0) {
            finish();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onRequestPermissionsResult(i, strArr, iArr);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        gsy.O000000o(3, "PluginHostActivity", "onNewIntent");
        if (this.mIsReady) {
            doNewIntent(intent);
        } else {
            this.mOnReadyRunableList.add(new Runnable() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass10 */

                public void run() {
                    PluginHostActivity.this.doNewIntent(intent);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void doNewIntent(Intent intent) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onNewIntent(intent);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onBackPressed() {
        XmPluginBaseActivity xmPluginBaseActivity;
        if (this.backPressEnable && (xmPluginBaseActivity = this.mXmPluginActivity) != null) {
            try {
                xmPluginBaseActivity.onBackPressed();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                if (xmPluginBaseActivity.onTouchEvent(motionEvent)) {
                    return true;
                }
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.mXmPluginActivity == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.mXmPluginActivity.dispatchTouchEvent(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
            finish();
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                if (xmPluginBaseActivity.onKeyDown(i, keyEvent)) {
                    return true;
                }
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return false;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                if (xmPluginBaseActivity.onKeyUp(i, keyEvent)) {
                    return true;
                }
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return false;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                if (xmPluginBaseActivity.onKeyLongPress(i, keyEvent)) {
                    return true;
                }
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return false;
            }
        }
        return super.onKeyLongPress(i, keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                if (xmPluginBaseActivity.onKeyMultiple(i, i2, keyEvent)) {
                    return true;
                }
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return false;
            }
        }
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                if (xmPluginBaseActivity.onKeyShortcut(i, keyEvent)) {
                    return true;
                }
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return false;
            }
        }
        return super.onKeyShortcut(i, keyEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onWindowAttributesChanged(layoutParams);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return;
            }
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onWindowFocusChanged(z);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return;
            }
        }
        super.onWindowFocusChanged(z);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onCreateOptionsMenu(menu);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return false;
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onOptionsItemSelected(menuItem);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return false;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onContentChanged() {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onContentChanged();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onAttachedToWindow();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onDetachedFromWindow();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onLowMemory();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onTrimMemory(i);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                if (xmPluginBaseActivity.onTrackballEvent(motionEvent)) {
                    return true;
                }
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
                return false;
            }
        }
        return super.onTrackballEvent(motionEvent);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onUserInteraction();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onUserLeaveHint();
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        XmPluginBaseActivity xmPluginBaseActivity = this.mXmPluginActivity;
        if (xmPluginBaseActivity != null) {
            try {
                xmPluginBaseActivity.onConfigurationChanged(configuration);
            } catch (Exception e) {
                PluginErrorInfoActivity.showErrorInfo(this, this.mLoadedInfo, e);
                finish();
            }
        }
    }

    public void overridePendingTransition(String str, String str2) {
        overridePendingTransition(getAnimRes(str), getAnimRes(str2));
    }

    private int getAnimRes(String str) {
        if ("slide_in_left".equals(str)) {
            return R.anim.activity_slide_in_left;
        }
        if ("slide_in_right".equals(str)) {
            return R.anim.activity_slide_in_right;
        }
        if ("slide_in_top".equals(str)) {
            return R.anim.activity_slide_in_top;
        }
        if ("slide_in_bottom".equals(str)) {
            return R.anim.activity_slide_in_bottom;
        }
        if ("slide_out_left".equals(str)) {
            return R.anim.activity_slide_out_left;
        }
        if ("slide_out_right".equals(str)) {
            return R.anim.activity_slide_out_right;
        }
        if ("slide_out_top".equals(str)) {
            return R.anim.activity_slide_out_top;
        }
        if ("slide_out_bottom".equals(str)) {
            return R.anim.activity_slide_out_bottom;
        }
        if ("fade_in_left".equals(str)) {
            return R.anim.activity_fade_in_left;
        }
        if ("fade_in_right".equals(str)) {
            return R.anim.activity_fade_in_right;
        }
        if ("fade_out_left".equals(str)) {
            return R.anim.activity_fade_out_left;
        }
        if ("fade_out_right".equals(str)) {
            return R.anim.activity_fade_out_right;
        }
        return 0;
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
    public final void startActivityForResult(Intent intent, String str, String str2, int i) {
        Class pluginActivityClass = PluginRuntimeManager.getInstance().getPluginActivityClass(((PluginHostApi) XmPluginHostApi.instance()).pluginRunningProcess());
        if (pluginActivityClass != null) {
            Intent intent2 = new Intent(this, pluginActivityClass);
            intent2.putExtra("jump_form_plugin_host", true);
            if (this.mDevice != null) {
                intent2.addCategory("did:" + this.mDevice.did);
                intent2.addCategory("model:" + this.mDevice.model);
                intent2.putExtra("extra_device_did", this.mDevice.did);
            } else {
                intent2.addCategory("model:" + this.mModel);
                intent2.putExtra("extra_device_model", this.mModel);
            }
            intent2.putExtra("extra_package", str);
            intent2.putExtra("extra_class", str2);
            if (intent != null) {
                intent2.putExtra("plugin_extra", intent);
            }
            if (i < 0) {
                i = 0;
            }
            startActivityForResult(intent2, i);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.device.api.XmPluginHostApi.addRecord(com.xiaomi.plugin.core.XmPluginPackage, java.lang.String, java.lang.Object, org.json.JSONObject):void
     arg types: [com.xiaomi.plugin.core.XmPluginPackage, java.lang.String, int, ?[OBJECT, ARRAY]]
     candidates:
      com.xiaomi.smarthome.device.api.XmPluginHostApi.addRecord(java.lang.String, java.lang.String, java.lang.Object, org.json.JSONObject):void
      com.xiaomi.smarthome.device.api.XmPluginHostApi.addRecord(com.xiaomi.plugin.core.XmPluginPackage, java.lang.String, java.lang.Object, org.json.JSONObject):void */
    public final void openShareActivity() {
        View decorView;
        Bitmap bitmap;
        if (this.mDevice != null && (decorView = getWindow().getDecorView()) != null) {
            if (decorView.getWidth() <= 0 || decorView.getHeight() <= 0) {
                bitmap = null;
            } else {
                bitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.RGB_565);
                decorView.draw(new Canvas(bitmap));
            }
            if (bitmap != null) {
                File externalCacheDir = getExternalCacheDir();
                boolean z = false;
                if (externalCacheDir == null) {
                    izb.O000000o(this, (int) R.string.share_pic_not_extern_storage, 0).show();
                    return;
                }
                File file = new File(externalCacheDir, "share.jpg");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                    fileOutputStream.close();
                    try {
                        bitmap.recycle();
                    } catch (Exception unused) {
                    }
                    z = true;
                } catch (Exception unused2) {
                }
                if (z) {
                    openShareMediaActivity("米家", this.mDevice.name.toString(), file.getAbsolutePath());
                }
                XmPluginHostApi.instance().addRecord(this.mLoadedInfo, "SnapShare", (Object) 1, (JSONObject) null);
            }
        }
    }

    public final void setTitleBarPadding(View view) {
        if (!hyy.O000000o(getIntent())) {
            TitleBarUtil.setTitleBarPadding(TitleBarUtil.getStatusHeight(activity()), view);
        }
    }

    public final Intent getActivityIntent(String str, String str2) {
        RunningProcess pluginRunningProcess = ((PluginHostApi) XmPluginHostApi.instance()).pluginRunningProcess();
        if (pluginRunningProcess == null) {
            pluginRunningProcess = RunningProcess.PLUGIN0;
        }
        Class pluginActivityClass = PluginRuntimeManager.getInstance().getPluginActivityClass(pluginRunningProcess);
        if (pluginActivityClass == null) {
            return null;
        }
        Intent intent = new Intent(this, pluginActivityClass);
        if (this.mDevice != null) {
            intent.addCategory("did:" + this.mDevice.did);
            intent.putExtra("extra_device_did", this.mDevice.did);
        } else {
            intent.putExtra("extra_device_model", this.mModel);
        }
        intent.putExtra("extra_package", str);
        intent.putExtra("extra_class", str2);
        return intent;
    }

    public final void enableWhiteTranslucentStatus() {
        TitleBarUtil.enableWhiteTranslucentStatus(getWindow());
    }

    public final boolean isTranslucentStatusbarEnable() {
        return TitleBarUtil.TRANSLUCENT_STATUS_ENABLED;
    }

    public final void enableBlackTranslucentStatus() {
        TitleBarUtil.enableTranslucentStatus(getWindow());
    }

    public final void openDevice(String str, Intent intent) {
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid == null) {
            gsy.O000000o(3, "PluginHostActivity", "openDevice can not find device info by did ".concat(String.valueOf(str)));
            return;
        }
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(deviceByDid.model);
        if (O0000Oo == null || !O0000Oo.O0000o0O() || this.mXmPluginActivity == null) {
            XmPluginHostApi.instance().sendMessage(str, 1, intent, null, null);
        } else {
            fsp.O000000o().O0000Oo.openRnPlugin(this, str, intent);
        }
    }

    public void openMoreMenu(ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i) {
        fsp.O000000o().O0000Oo.openMoreMenu(this, this.mDevice, arrayList, z, i);
    }

    public void openMoreMenu(ArrayList<String> arrayList, ArrayList<Intent> arrayList2, boolean z, int i) {
        fsp.O000000o().O0000Oo.openMoreMenu(this, this.mDevice, arrayList, arrayList2, z, i);
    }

    public void openMoreMenu(String str, ArrayList<String> arrayList, ArrayList<Intent> arrayList2, boolean z, int i) {
        fsp.O000000o().O0000Oo.openMoreMenu(this, str, arrayList, arrayList2, z, i);
    }

    public void goUpdateActivity() {
        fsp.O000000o().O0000Oo.goUpdateActivity(this, this.mDevice);
    }

    public void startLoadScene() {
        fsp.O000000o().O0000Oo.startLoadScene(this.mXmPluginActivity);
    }

    public void startCreateSceneByDid(String str) {
        fsp.O000000o().O0000Oo.startCreateSceneByDid(this, str);
    }

    public void startEditScene(int i) {
        fsp.O000000o().O0000Oo.startEditScene(this, i);
    }

    public void startEditScene(String str) {
        fsp.O000000o().O0000Oo.startEditScene(this, str);
    }

    public void startSetTimerList(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        fsp.O000000o().O0000Oo.startSetTimerList(this, str, str2, str3, str4, str5, str6, str7);
    }

    public void openFeedbackActivity() {
        fsp.O000000o().O0000Oo.openFeedbackActivity(this, this.mDevice);
    }

    public void addToLauncher() {
        fsp.O000000o().O0000Oo.addToLauncher(this.mDevice);
    }

    public void loadWebView(String str, String str2) {
        fsp.O000000o().O0000Oo.loadWebView(str, str2);
    }

    public void openShopActivity(String str) {
        fsp.O000000o().O0000Oo.openShopActivity(str);
    }

    public void share(String str, String str2, String str3, String str4, String str5, Bitmap bitmap) {
        fsp.O000000o().O0000Oo.share(this, str, str2, str3, str4, str5, bitmap);
    }

    public void startSearchNewDevice(String str, String str2, IXmPluginHostActivity.DeviceFindCallback deviceFindCallback) {
        fsp.O000000o().O0000Oo.startSearchNewDevice(str, str2, deviceFindCallback);
    }

    public void openSceneActivity(String str) {
        fsp.O000000o().O0000Oo.openSceneActivity(this, this.mDevice, str);
    }

    public void getDeviceRecommendScenes(String str, IXmPluginHostActivity.AsyncCallback<List<RecommendSceneItem>> asyncCallback) {
        fsp.O000000o().O0000Oo.getDeviceRecommendScenes(str, asyncCallback);
    }

    public void startEditRecommendScenes(RecommendSceneItem recommendSceneItem, String str, String str2) {
        fsp.O000000o().O0000Oo.startEditRecommendScenes(this, recommendSceneItem, str, str2);
    }

    public List<SceneInfo> getSceneByDid(String str) {
        return fsp.O000000o().O0000Oo.getSceneByDid(str);
    }

    public void setSceneEnabled(SceneInfo sceneInfo, boolean z, IXmPluginHostActivity.AsyncCallback<Void> asyncCallback) {
        fsp.O000000o().O0000Oo.setSceneEnabled(sceneInfo, z, asyncCallback);
    }

    public void modifySceneName(SceneInfo sceneInfo, IXmPluginHostActivity.AsyncCallback<Void> asyncCallback) {
        fsp.O000000o().O0000Oo.modifySceneName(sceneInfo, asyncCallback);
    }

    public void startSetTimerList(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        fsp.O000000o().O0000Oo.startSetTimerList(this, str, str2, str3, str4, str5, str6, str7, str8);
    }

    public void openShareMediaActivity(String str, String str2, String str3, Bitmap bitmap, String str4, Bitmap bitmap2) {
        fsp.O000000o().O0000Oo.openShareMediaActivity(this, str, str2, str3, bitmap, str4, bitmap2, this.mDevice);
    }

    public void openShareMediaActivity(String str, String str2, String str3) {
        fsp.O000000o().O0000Oo.openShareMediaActivity(this, str, str2, str3, this.mDevice);
    }

    public void openShareMediaActivity(String str, String str2, String str3, Bitmap bitmap) {
        fsp.O000000o().O0000Oo.openShareMediaActivity(this, str, str2, str3, bitmap, this.mDevice);
    }

    public void openSharePictureActivity(String str, String str2, String str3) {
        fsp.O000000o().O0000Oo.openSharePictureActivity(this, str, str2, str3);
    }

    public void startEditCustomScene() {
        fsp.O000000o().O0000Oo.startEditCustomScene(this);
    }

    public void goUpdateActivity(String str) {
        fsp.O000000o().O0000Oo.goUpdateActivity(this, str);
    }

    public void startLoadScene(IXmPluginHostActivity.AsyncCallback asyncCallback) {
        fsp.O000000o().O0000Oo.startLoadScene(asyncCallback);
    }

    public void openHelpActivity() {
        fsp.O000000o().O0000Oo.openHelpActivity(this, this.mDevice);
    }

    public void goBleUpdateActivity(Intent intent, BleUpgrader bleUpgrader) {
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent);
        }
        if (bleUpgrader != null && Build.VERSION.SDK_INT >= 18) {
            Bundle bundle = new Bundle();
            bundle.putBinder("extra_upgrade_controller", bleUpgrader);
            intent2.putExtras(bundle);
        }
        fsp.O000000o().O0000Oo.goUpdateActivity(this, this.mDevice, intent2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006a  */
    public void openRechargePage(int i, double d, double d2) {
        String str;
        String str2;
        String str3;
        if (i > 0 && Math.abs(d * d2) > 0.0d) {
            try {
                List<Address> fromLocation = new Geocoder(XmPluginHostApi.instance().context(), Locale.CHINA).getFromLocation(d, d2, 1);
                if (fromLocation != null && fromLocation.size() > 0) {
                    Address address = fromLocation.get(0);
                    if (TextUtils.isEmpty("")) {
                        str3 = address.getLocality();
                    } else {
                        str3 = "";
                    }
                    try {
                        if (TextUtils.isEmpty(str3)) {
                            str3 = address.getAdminArea();
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str = address.getSubAdminArea();
                            if (TextUtils.isEmpty(str)) {
                                str2 = "https://web.recharge.pay.xiaomi.com/web/utility/v2?refs=10";
                            } else {
                                str2 = String.format("https://web.recharge.pay.xiaomi.com/web/utility/utilityCode/%d?refs=10&cityName=%s", Integer.valueOf(i), str);
                            }
                            gsy.O000000o(3, "PluginHostActivity", "loadWebView".concat(String.valueOf(str2)));
                            loadWebView(str2, "");
                            CoreApi.O000000o().O000000o(StatType.EVENT, "plugin_go_mi_recharge", Integer.toString(1), (String) null, false);
                        }
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        str = str3;
                        if (TextUtils.isEmpty(str)) {
                        }
                        gsy.O000000o(3, "PluginHostActivity", "loadWebView".concat(String.valueOf(str2)));
                        loadWebView(str2, "");
                        CoreApi.O000000o().O000000o(StatType.EVENT, "plugin_go_mi_recharge", Integer.toString(1), (String) null, false);
                    }
                    str = str3;
                    if (TextUtils.isEmpty(str)) {
                    }
                    gsy.O000000o(3, "PluginHostActivity", "loadWebView".concat(String.valueOf(str2)));
                    loadWebView(str2, "");
                    CoreApi.O000000o().O000000o(StatType.EVENT, "plugin_go_mi_recharge", Integer.toString(1), (String) null, false);
                }
            } catch (IOException e2) {
                e = e2;
                str3 = "";
                e.printStackTrace();
                str = str3;
                if (TextUtils.isEmpty(str)) {
                }
                gsy.O000000o(3, "PluginHostActivity", "loadWebView".concat(String.valueOf(str2)));
                loadWebView(str2, "");
                CoreApi.O000000o().O000000o(StatType.EVENT, "plugin_go_mi_recharge", Integer.toString(1), (String) null, false);
            }
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
        }
        gsy.O000000o(3, "PluginHostActivity", "loadWebView".concat(String.valueOf(str2)));
        loadWebView(str2, "");
        CoreApi.O000000o().O000000o(StatType.EVENT, "plugin_go_mi_recharge", Integer.toString(1), (String) null, false);
    }

    public void openScanBarcodePage(Bundle bundle, int i) {
        fsp.O000000o().O0000Oo.openScanBarcodePage(this, bundle, i);
    }

    public void openMoreMenu(ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent) {
        fsp.O000000o().O0000Oo.openMoreMenu(this, this.mDevice, arrayList, z, i, intent);
    }

    public void openMoreMenu(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, String str, int i, Intent intent) {
        fsp.O000000o().O0000Oo.openMoreMenu(this, this.mDevice, arrayList, z, i, intent, str);
    }

    public void openMoreMenu2(ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent) {
        fsp.O000000o().O0000Oo.openMoreMenu2(this, this.mDevice, arrayList, z, i, intent);
    }

    public void openAddIRController(DeviceStat deviceStat, int i, String str) {
        openAddIRController(deviceStat, i, TextUtils.isEmpty(str) ? null : new String[]{str}, null);
    }

    public void openAddIRController(DeviceStat deviceStat, int i, String[] strArr, Bundle bundle) {
        fsp.O000000o().O0000Oo.openAddIRController(this, deviceStat, i, strArr, bundle);
    }

    public void openAddIRController(DeviceStat deviceStat) {
        openAddIRController(deviceStat, 0, null, null);
    }

    public void openGatewaySubDeviceList(String str) {
        fsp.O000000o().O0000Oo.openGatewaySubDeviceList(this, str);
    }

    public void enableVerifyPincode() {
        this.mEnableVerifyPincode = true;
    }

    public void enableAd() {
        this.mIsSupportAd = true;
    }

    public void openShareVideoActivity(String str, String str2, String str3) {
        fsp.O000000o().O0000Oo.openSharePictureActivity(this, str, str2, str3);
    }

    public void showBannerAd(ViewGroup viewGroup, String str) {
        fsp.O000000o().O0000Oo.showBannerAd(activity(), viewGroup, this.mModel, str);
    }

    public void showNoticeAd(ViewGroup viewGroup, String str) {
        fsp.O000000o().O0000Oo.showNoticeAd(activity(), viewGroup, this.mModel, str);
    }

    public void clickHotSpotAd(String str) {
        fsp.O000000o().O0000Oo.clickHotSpotAd(activity(), this.mModel, str);
    }

    public void openOpHistoryActivity() {
        fsp.O000000o().O0000Oo.openOpHistoryActivity(this, this.mDevice.did);
    }

    public void reportHotSpotAdShow(String str) {
        fsp.O000000o().O0000Oo.reportHotSpotAdShow(this.mDevice.model, str);
    }

    public void openShareDeviceActivity() {
        fsp.O000000o().O0000Oo.openShareDeviceActivity(this, this.mDevice.did);
    }

    public void showUserLicenseDialog(@Deprecated String str, String str2, String str3, View.OnClickListener onClickListener) {
        fsp.O000000o().O0000Oo.showUserLicenseDialog(this, str, str2, str3, onClickListener);
    }

    private String getNewDialogTitle(String str) {
        DeviceStat deviceStat = this.mDevice;
        return (deviceStat == null || TextUtils.isEmpty(deviceStat.name)) ? str : this.mDevice.name;
    }

    public void showUserLicenseDialog(@Deprecated String str, String str2, Spanned spanned, String str3, Spanned spanned2, View.OnClickListener onClickListener) {
        fsp.O000000o().O0000Oo.showUserLicenseDialog(this, getNewDialogTitle(str), str2, spanned, str3, spanned2, onClickListener, this.mDevice.did, null);
    }

    public void showUserLicenseDialog(@Deprecated String str, String str2, Spanned spanned, String str3, Spanned spanned2, View.OnClickListener onClickListener, Intent intent) {
        fsp.O000000o().O0000Oo.showUserLicenseDialog(this, getNewDialogTitle(str), str2, spanned, str3, spanned2, onClickListener, this.mDevice.did, intent);
    }

    public void showUserLicenseHtmlDialog(@Deprecated String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener) {
        fsp.O000000o().O0000Oo.showUserLicenseHtmlDialog(this, getNewDialogTitle(str), str2, str3, str4, str5, onClickListener, this.mDevice.did);
    }

    public void showUserLicenseUriDialog(@Deprecated String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener) {
        fsp.O000000o().O0000Oo.showUserLicenseUriDialog(this, getNewDialogTitle(str), str2, str3, str4, str5, onClickListener, this.mDevice.did, null);
    }

    public void showUserLicenseUriDialog(@Deprecated String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, Intent intent) {
        fsp.O000000o().O0000Oo.showUserLicenseUriDialog(this, getNewDialogTitle(str), str2, str3, str4, str5, onClickListener, this.mDevice.did, intent);
    }

    public void openMoreMenu2(ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent, Intent intent2) {
        fsp.O000000o().O0000Oo.openMoreMenu2(this, this.mDevice, arrayList, z, i, intent, intent2);
    }

    public void showUseDefaultLicenseDialog(@Deprecated String str, View.OnClickListener onClickListener) {
        fsp.O000000o().O0000Oo.showUserLicenseDialog(this, getNewDialogTitle(str), onClickListener, this.mDevice.did);
    }

    public void startSetTimerListV2(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11) {
        fsp.O000000o().O0000Oo.startSetTimerListV2(this, str, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11);
    }

    public void startSetTimerListV3(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        fsp.O000000o().O0000Oo.startSetTimerListV3(this, str, str2, str3, str4, str5, str6, str7, str8);
    }

    public void startSetTimerListV3(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11) {
        fsp.O000000o().O0000Oo.startSetTimerListV3(this, str, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11);
    }

    public void startAddRoom() {
        fsp.O000000o().O0000Oo.startAddRoom(this);
    }

    public void startSetTimerCountDown(String str, String str2, String str3, String str4, String str5, boolean z) {
        fsp.O000000o().O0000Oo.startSetTimerCountDown(this, str, str2, str3, str4, str5, z);
    }

    public void openCloudVideoListActivity(String str, String str2) {
        fsp.O000000o().O0000Oo.openCloudVideoListActivity(this, str, str2);
    }

    public void openCloudVideoPlayerActivity(String str, String str2, String str3) {
        fsp.O000000o().O0000Oo.openCloudVideoPlayerActivity(this, str, str2, str3);
    }

    public void openCloudVideoWebActivity(String str, String str2, String str3) {
        fsp.O000000o().O0000Oo.openCloudVideoWebActivity(this, str, str2, str3);
    }

    public void onDeviceReady(String str, String str2) {
        fsp.O000000o().O0000Oo.onDeviceReady(this, str, str2, false, new IXmPluginHostActivity.AsyncCallback<Void>() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity.AnonymousClass11 */

            public void onFailure(int i, Object obj) {
            }

            public void onSuccess(Void voidR) {
            }
        });
    }

    public void openPowerSwitchNameActivity(String str, String str2) {
        fsp.O000000o().O0000Oo.openPowerSwitchNameActivity(this, str, str2);
    }

    public void openCloudVideoExoPlayerActivity(String str, String str2, String str3) {
        fsp.O000000o().O0000Oo.openCloudVideoExoPlayerActivity(this, str, str2, str3);
    }

    public void openWxBindActivity(int i) {
        fsp.O000000o().O0000Oo.openWxBindActivity(this, i);
    }

    public void openBtGatewayActivity(String str) {
        fsp.O000000o().O0000Oo.openBtGatewayActivity(this, str);
    }

    public void openOneTimePasswordActivity(String str, int i, int i2) {
        fsp.O000000o().O0000Oo.openOneTimePasswordActivity(this, str, i, i2);
    }

    public void openFaceManagerActivity(String str) {
        fsp.O000000o().O0000Oo.openFaceManagerActivity(this, str);
    }

    public void openFaceManagerActivity(int i, String str, String str2) {
        fsp.O000000o().O0000Oo.openFaceManagerActivity(i, this, str, str2);
    }

    public void openMarkFaceDialog(String str, String str2, FaceManagerCallback faceManagerCallback) {
        fsp.O000000o().O0000Oo.openMarkFaceDialog(this, str, str2, faceManagerCallback);
    }

    public void openReplaceFaceDialog(String str, String str2, String str3, String str4, FaceManagerCallback faceManagerCallback) {
        fsp.O000000o().O0000Oo.openReplaceFaceDialog(this, str, str2, str3, str4, faceManagerCallback);
    }

    public void openFaceEmptyActivity(String str) {
        fsp.O000000o().O0000Oo.openFaceEmptyActivity(this, str);
    }

    public void startRecommendSceneDetailActivityBy(String str, int i) {
        fsp.O000000o().O0000Oo.startRecommendSceneDetailActivityBy(this, str, i);
    }

    public void openVirtualGroupInitActivity(String str, int i) {
        fsp.O000000o().O0000Oo.openVirtualGroupInitActivity(this, this.mDevice.did, i);
    }

    public void openNetworkInfoActivity(String str) {
        fsp.O000000o().O0000Oo.openNetworkInfoActivity(this, this.mDevice.did);
    }

    public void openScreenDeviceLinkageSettingActivity(String str, boolean z) {
        fsp.O000000o().O0000Oo.openScreenDeviceLinkageSettingActivity(this, str, z);
    }

    public void openScreenDeviceLinkageSettingActivity(String str, boolean z, int i, String str2) {
        fsp.O000000o().O0000Oo.openScreenDeviceLinkageSettingActivity(this, str, z, i, str2);
    }
}
