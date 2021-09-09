package com.xiaomi.smarthome.framework.plugin.rn;

import _m_j.ba;
import _m_j.bcy;
import _m_j.fpp;
import _m_j.fqx;
import _m_j.fsp;
import _m_j.ft;
import _m_j.fvo;
import _m_j.fvt;
import _m_j.fvu;
import _m_j.fwv;
import _m_j.fwx;
import _m_j.fwy;
import _m_j.fwz;
import _m_j.fxa;
import _m_j.fyc;
import _m_j.gat;
import _m_j.gav;
import _m_j.gaw;
import _m_j.gax;
import _m_j.gbc;
import _m_j.gbd;
import _m_j.gbe;
import _m_j.gbf;
import _m_j.gbq;
import _m_j.gbt;
import _m_j.gbu;
import _m_j.gdt;
import _m_j.gdv;
import _m_j.gku;
import _m_j.gle;
import _m_j.gqc;
import _m_j.grj;
import _m_j.gsy;
import _m_j.hyy;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.modules.debug.FpsDebugFrameCallback;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.IPluginRnActivity;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.LockSecurePinUtil;
import com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPackageModule;
import com.xiaomi.smarthome.framework.plugin.rn.view.FpsMemoryView;
import com.xiaomi.smarthome.framework.plugin.rn.view.PluginFrameLayout;
import com.xiaomi.smarthome.library.log.LogType;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public class PluginRNActivity extends LoadingBaseActivity implements bcy, PermissionAwareActivity, IPluginRnActivity {
    private static boolean O0000OoO = true;
    private static String O0000Ooo;
    private static long O0000o00;
    List<Runnable> O0000O0o = new ArrayList();
    boolean O0000OOo = true;
    protected FpsMemoryView O0000Oo;
    FrameLayout O0000Oo0 = null;
    private BroadcastReceiver O0000o;
    private int O0000o0;
    private Callback O0000o0O;
    private Set<String> O0000o0o = new HashSet();
    private gbc O0000oO = null;
    private OfflineViewDelegate O0000oO0;
    private gbd O0000oOO;
    private gbf O0000oOo;
    private fwy O0000oo;
    private MessageQueue.IdleHandler O0000oo0;
    private BroadcastReceiver O0000ooO = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass12 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && PluginRNActivity.this.O00000oO != null && PluginRNActivity.this.O00000oO.model != null && action.equals("miui.action_open_floating_window") && PluginRNActivity.this.O00000oO.model.contains("camera")) {
                PluginRNActivity.this.finish();
            }
        }
    };
    public DefaultHardwareBackBtnHandler handler = new DefaultHardwareBackBtnHandler() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass1 */

        public final void invokeDefaultOnBackPressed() {
            gbu.O000000o("rn activity... invoke on backpressed");
            try {
                if (!PluginRNActivity.this.isDestroyed()) {
                    PluginRNActivity.super.onBackPressed();
                }
            } catch (Exception e) {
                gbu.O00000Oo("invokeDefaultOnBackPressed error:" + Log.getStackTraceString(e));
            }
        }
    };
    public volatile boolean mActivityFinished = false;
    public boolean mIsSendLaunchPluginFinishAction = false;
    public PermissionListener mPermissionListener;
    public int mStateTarget = 0;

    public void setPermissionListener(PermissionListener permissionListener) {
    }

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        TextView textView;
        fwy O00000Oo = fwz.O000000o().O00000Oo();
        if (!(O00000Oo.O0000o0o == null || O00000Oo.O0000o0o.size() == 0)) {
            O00000Oo.O0000o0o = null;
        }
        ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o();
        fwy O00000Oo2 = fwz.O000000o().O00000Oo();
        if (O00000Oo2.O0000o0o != null) {
            O00000Oo2.O0000o0o.clear();
            O00000Oo2.O0000o0o = null;
        }
        super.onCreate(bundle);
        gbu.O00000oo("================= 进入插件 ======================");
        gbu.O00000oo("PluginRNActivity-->onCreate..." + this.O0000OOo + " " + this);
        fwz.O000000o().O000000o(false);
        this.O0000o0o.add("chuangmi.light.028a01");
        if (this.O0000o0o.contains(getDeviceModel())) {
            getWindow().addFlags(6291584);
            if (Build.VERSION.SDK_INT >= 27) {
                setShowWhenLocked(true);
            } else {
                getWindow().addFlags(524288);
            }
        }
        long longExtra = getIntent().getLongExtra("openTime", System.currentTimeMillis());
        long currentTimeMillis = System.currentTimeMillis();
        gsy.O00000Oo("statistic-time", "statistic time:  msg-->onCreate is cost " + (currentTimeMillis - longExtra));
        long longExtra2 = getIntent().getLongExtra("open_plugin_click_start_time", 0);
        long longExtra3 = getIntent().getLongExtra("open_plugin_download_plugin_finish_time", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("open_plugin_cached", false);
        fwx.O000000o().f17339O000000o = longExtra2;
        if (booleanExtra) {
            fwx.O000000o().O00000Oo = longExtra2;
        } else {
            fwx.O000000o().O00000Oo = longExtra3;
        }
        fwx.O000000o().O00000oO = booleanExtra;
        fyc.O000000o("rn-plugin", "statistic-time: openStartTime=" + longExtra2 + ",downloadPackageFinishTime=" + longExtra3);
        PluginDeviceInfo pluginInfo = getPluginInfo();
        if (pluginInfo == null) {
            gbu.O00000oo("PluginRNActivity-->onCreate-->finish  pluginRecord is null...");
            finish();
            return;
        }
        fyc.O00000Oo("rn-plugin", "deviceInfo, model:" + pluginInfo.O00000Oo());
        if (getIntent().getBooleanExtra("isOpenLoadingRNActivity", false) && (textView = (TextView) findViewById(R.id.tv_plugin_download_progress)) != null) {
            textView.setVisibility(0);
            textView.setText(getString(R.string.mj_loading_hint) + "100%");
        }
        try {
            str = getExternalFilesDir("logs").getAbsolutePath() + File.separator + "RnPlugin.log";
        } catch (Exception unused) {
            str = "";
        }
        gbu.O000000o("pluginLogFilePath: ".concat(String.valueOf(str)));
        gbu.O0000O0o("========== 进入插件 ============");
        long currentTimeMillis2 = System.currentTimeMillis();
        fwz O000000o2 = fwz.O000000o();
        gbu.O00000oo("RNRuntimeManager initRuntime()");
        O000000o2.O00000Oo().O00000Oo(true);
        if (gbt.O000000o()) {
            boolean O00000Oo3 = gbt.O00000Oo(O000000o2.O00000Oo().O0000o00.model);
            gbu.O00000oo("RNRuntimeManager initRuntime()-->supportMultiRNRuntimeReuse:".concat(String.valueOf(O00000Oo3)));
            if (O00000Oo3 && O000000o2.O00000Oo().O00000oO() != null) {
                fxa.O000000o().O000000o(O000000o2.O00000Oo().O00000oO(), O000000o2.O00000Oo());
            }
        }
        fwz.O000000o().O00000Oo(true);
        this.O0000oo = fwz.O000000o().O00000Oo();
        gbu.O000000o("PluginRNActivity  initRuntime cost time " + (System.currentTimeMillis() - currentTimeMillis2));
        this.O0000o0 = getIntent().getIntExtra("type_loading_sendmessage", 0);
        int intExtra = getIntent().getIntExtra("activity_start_from", -1);
        if (this.O0000o0 == 1) {
            if (intExtra == 1001) {
                overridePendingTransition(R.anim.activity_rn_no_anim, R.anim.activity_rn_no_anim);
            } else {
                overridePendingTransition(R.anim.activity_anim_no_in, R.anim.activity_anim_no_out);
            }
            this.f8119O000000o.setBackgroundColor(0);
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.O00000o.getHierarchy();
            if (genericDraweeHierarchy != null) {
                genericDraweeHierarchy.setFadeDuration(0);
                genericDraweeHierarchy.setPlaceholderImage((Drawable) null);
            }
        } else if (intExtra == 1001) {
            overridePendingTransition(R.anim.activity_rn_no_anim, R.anim.activity_rn_no_anim);
        } else {
            overridePendingTransition(R.anim.activity_slide_in_right, R.anim.activity_slide_out_left);
        }
        if (this.O00000oo != 3) {
            if (fqx.O000000o(this.O00000oO.model, this.O00000oO.version)) {
                final boolean isEmpty = TextUtils.isEmpty(LockSecurePinUtil.getPropLtmk(this.O00000oO.mac));
                final boolean isEmpty2 = TextUtils.isEmpty(LockSecurePinUtil.getPropPincode(this.O00000oO.mac));
                String str4 = "not";
                if (!CoreApi.O000000o().O0000o(this.O00000oO.model)) {
                    boolean propShowPincode = LockSecurePinUtil.getPropShowPincode(this.O00000oO.mac);
                    if (isEmpty || isEmpty2 || propShowPincode) {
                        LogType logType = LogType.PLUGIN;
                        StringBuilder sb = new StringBuilder("RNPlugin Lock device,model=");
                        sb.append(this.O00000oO.model);
                        sb.append(",local LTMK is ");
                        if (isEmpty) {
                            str2 = "";
                        } else {
                            str2 = str4;
                        }
                        sb.append(str2);
                        sb.append(" empty");
                        gsy.O00000o0(logType, "rn-plugin", sb.toString());
                        LogType logType2 = LogType.PLUGIN;
                        StringBuilder sb2 = new StringBuilder("RNPlugin Lock device,model=");
                        sb2.append(this.O00000oO.model);
                        sb2.append(",local pinCode is ");
                        if (isEmpty2) {
                            str4 = "";
                        }
                        sb2.append(str4);
                        sb2.append(" empty");
                        gsy.O00000o0(logType2, "rn-plugin", sb2.toString());
                        gsy.O00000o0(LogType.PLUGIN, "rn-plugin", "RNPlugin Lock device,model=" + this.O00000oO.model + ",local showPinCode is " + propShowPincode);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("extra_device_did", this.O00000oO.did);
                        fsp.O000000o().O0000Oo.openVerfyPincode(this, bundle2, 9999);
                        if (LockSecurePinUtil.isNetworkAvailable(this)) {
                            LockSecurePinUtil.checkSecurePinChanged(this, this.O00000oO.did, this.O00000oO.mac);
                            LockSecurePinUtil.checkLtmkChanged(this, this.O00000oO.did, this.O00000oO.mac, true);
                        }
                    } else if (LockSecurePinUtil.isNetworkAvailable(this)) {
                        LockSecurePinUtil.checkSecurePinChanged(this, this.O00000oO.did, this.O00000oO.mac);
                        LockSecurePinUtil.checkLtmkChanged(this, this.O00000oO.did, this.O00000oO.mac, false);
                    }
                } else if (LockSecurePinUtil.isNetworkAvailable(this)) {
                    LockSecurePinUtil.checkSecurePinChangedV2(this, this.O00000oO.did, this.O00000oO.mac, new ba<Void>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass21 */

                        public final /* synthetic */ void accept(Object obj) {
                            boolean propShowPincode = LockSecurePinUtil.getPropShowPincode(PluginRNActivity.this.O00000oO.mac);
                            LogType logType = LogType.PLUGIN;
                            StringBuilder sb = new StringBuilder("RNPlugin Lock device,model=");
                            sb.append(PluginRNActivity.this.O00000oO.model);
                            sb.append(",local LTMK is ");
                            String str = "";
                            sb.append(isEmpty ? str : "not");
                            sb.append(" empty");
                            gsy.O00000o0(logType, "rn-plugin", sb.toString());
                            LogType logType2 = LogType.PLUGIN;
                            StringBuilder sb2 = new StringBuilder("RNPlugin Lock device,model=");
                            sb2.append(PluginRNActivity.this.O00000oO.model);
                            sb2.append(",local pinCode is ");
                            if (!isEmpty2) {
                                str = "not";
                            }
                            sb2.append(str);
                            sb2.append(" empty");
                            gsy.O00000o0(logType2, "rn-plugin", sb2.toString());
                            LogType logType3 = LogType.PLUGIN;
                            gsy.O00000o0(logType3, "rn-plugin", "RNPlugin Lock device,model=" + PluginRNActivity.this.O00000oO.model + ",local showPinCode is " + propShowPincode);
                            if (propShowPincode) {
                                Bundle bundle = new Bundle();
                                bundle.putString("extra_device_did", PluginRNActivity.this.O00000oO.did);
                                fsp.O000000o().O0000Oo.openVerfyPincode(PluginRNActivity.this, bundle, 9999);
                            }
                        }
                    });
                    LockSecurePinUtil.checkLtmkChanged(this, this.O00000oO.did, this.O00000oO.mac, true);
                } else {
                    boolean propShowPincode2 = LockSecurePinUtil.getPropShowPincode(this.O00000oO.mac);
                    LogType logType3 = LogType.PLUGIN;
                    StringBuilder sb3 = new StringBuilder("RNPlugin Lock device,model=");
                    sb3.append(this.O00000oO.model);
                    sb3.append(",local LTMK is ");
                    if (isEmpty) {
                        str3 = "";
                    } else {
                        str3 = str4;
                    }
                    sb3.append(str3);
                    sb3.append(" empty");
                    gsy.O00000o0(logType3, "rn-plugin", sb3.toString());
                    LogType logType4 = LogType.PLUGIN;
                    StringBuilder sb4 = new StringBuilder("RNPlugin Lock device,model=");
                    sb4.append(this.O00000oO.model);
                    sb4.append(",local pinCode is ");
                    if (isEmpty2) {
                        str4 = "";
                    }
                    sb4.append(str4);
                    sb4.append(" empty");
                    gsy.O00000o0(logType4, "rn-plugin", sb4.toString());
                    gsy.O00000o0(LogType.PLUGIN, "rn-plugin", "RNPlugin Lock device,model=" + this.O00000oO.model + ",local showPinCode is " + propShowPincode2);
                    if (propShowPincode2) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("extra_device_did", this.O00000oO.did);
                        fsp.O000000o().O0000Oo.openVerfyPincode(this, bundle3, 9999);
                    }
                }
            } else if (this.O00000oO.isSetPinCode != 0) {
                Bundle bundle4 = new Bundle();
                bundle4.putString("extra_device_did", this.O00000oO.did);
                fsp.O000000o().O0000Oo.openVerfyPincode(this, bundle4, 9999);
            }
        }
        if (!CoreApi.O000000o().O0000O0o()) {
            gsy.O000000o(6, "rn-plugin", "core process not ready,initial core process");
            this.O0000OOo = false;
            this.O0000O0o.clear();
            final Bundle bundle5 = bundle;
            this.O0000O0o.add(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass22 */

                public final void run() {
                    PluginRNActivity.this.doCreate(bundle5);
                }
            });
            CoreApi.O000000o().O000000o(getApplicationContext(), new CoreApi.O0000o0() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass23 */

                public final void onCoreReady() {
                    CoreApi.O000000o().O000000o(PluginRNActivity.this.getApplicationContext(), new CoreApi.O0000o() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass23.AnonymousClass1 */

                        public final void onPluginCacheReady() {
                            if (CoreApi.O000000o().O0000O0o()) {
                                PluginRNActivity.this.O0000OOo = true;
                                for (int i = 0; i < PluginRNActivity.this.O0000O0o.size(); i++) {
                                    PluginRNActivity.this.O0000O0o.get(i).run();
                                }
                                PluginRNActivity.this.O0000O0o.clear();
                                return;
                            }
                            gbu.O00000oo("PluginRnActivity   core process not ready, finish...");
                            gsy.O000000o(6, "rn-plugin", "core process not ready");
                            PluginRNActivity.this.O0000O0o.clear();
                            PluginRNActivity.this.finish();
                        }
                    });
                }
            });
        } else {
            this.O0000OOo = true;
            doCreate(bundle);
        }
        PluginPackageInfo pluginRecord = getPluginRecord();
        if (gax.O000000o(this.O00000oo, pluginInfo.O00000Oo())) {
            gav.O000000o(pluginInfo.O00000Oo(), pluginRecord, "plugin_downloaded");
        }
    }

    public String getDeviceModel() {
        return getIntent().getStringExtra("model");
    }

    public DeviceStat getDeviceStat() {
        String stringExtra = getIntent().getStringExtra("did");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return XmPluginHostApi.instance().getDeviceByDid(stringExtra);
    }

    public PluginPackageInfo getPluginRecord() {
        return fwz.O000000o().O00000Oo().O0000OoO;
    }

    public PluginDeviceInfo getPluginInfo() {
        return fwz.O000000o().O00000Oo().O0000Ooo;
    }

    public void doCreate(Bundle bundle) {
        boolean z;
        if (bundle == null || !bundle.getBoolean("extra_recycle_plugin", false)) {
            fwy O00000Oo = fwz.O000000o().O00000Oo();
            O00000Oo.O0000OOo = this;
            O00000Oo.O00000oO.O000000o();
            if (O00000Oo.O000000o()) {
                try {
                    O00000Oo.O0000O0o.onHostResume(this, O00000Oo.O000O0o0);
                } catch (Exception e) {
                    Log.i("RNRuntimeTAG", "failed to resume the activity on registry", e);
                }
            }
            String stringExtra = getIntent().getStringExtra("model");
            fwz.O000000o().O000000o(new fwy.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass24 */

                public final void onAttachPlugin(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
                    if (reactRootView == null) {
                        gbu.O00000oo("doCreate,registerListener reactView==null");
                        return;
                    }
                    if (reactRootView.getParent() instanceof ViewGroup) {
                        ((ViewGroup) reactRootView.getParent()).removeView(reactRootView);
                    }
                    PluginRNActivity.this.f8119O000000o.addView(reactRootView, 0);
                    gsy.O00000Oo("PluginStartTime", "onAttachPlugin  " + System.currentTimeMillis());
                    reactRootView.setAlpha(0.3f);
                    final ReactRootView reactRootView2 = reactRootView;
                    final ReactInstanceManager reactInstanceManager2 = reactInstanceManager;
                    final DeviceStat deviceStat2 = deviceStat;
                    final PluginPackageInfo pluginPackageInfo2 = pluginPackageInfo;
                    reactRootView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass24.AnonymousClass1 */
                        private grj O00000oo = new grj() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass24.AnonymousClass1.AnonymousClass1 */

                            public final void onAnimationEnd(Animator animator) {
                                XmPluginHostApi instance = XmPluginHostApi.instance();
                                instance.log("PluginRNActivity.doCreate", System.currentTimeMillis() + " reactView:" + reactRootView2 + " instanceManager:" + reactInstanceManager2 + " deviceStat:" + deviceStat2 + " record:" + pluginPackageInfo2);
                                PluginRNActivity.this.O00000Oo.setVisibility(8);
                                gbu.O00000oo("Broadcast:  sendBroadcast ACTION_LAUNCH_PLUGIN_FINISH");
                                PluginRNActivity.this.sendBroadcast(new Intent("action_launch_plugin_finish"));
                                PluginRNActivity.this.mIsSendLaunchPluginFinishAction = true;
                                reactRootView2.setAlpha(1.0f);
                                if (PluginRNActivity.this.O00000o0 != null) {
                                    PluginRNActivity.this.O00000o0.stop();
                                }
                            }
                        };

                        public final boolean onPreDraw() {
                            int childCount = reactRootView2.getChildCount();
                            if (childCount <= 0) {
                                return true;
                            }
                            gbu.O00000oo("OnPreDrawListener(), onPreDraw,childCount=".concat(String.valueOf(childCount)));
                            gsy.O00000Oo("PluginStartTime", "onPreDraw  ".concat(String.valueOf(childCount)));
                            reactRootView2.getViewTreeObserver().removeOnPreDrawListener(this);
                            if (gku.O000000o(PluginRNActivity.this.getApplicationContext())) {
                                PluginRNActivity.this.f8119O000000o.setBackgroundColor(-16777216);
                                PluginRNActivity.this.O00000Oo.setBackgroundColor(-16777216);
                            } else {
                                PluginRNActivity.this.f8119O000000o.setBackgroundColor(-1);
                                PluginRNActivity.this.O00000Oo.setBackgroundColor(-1);
                            }
                            if (System.currentTimeMillis() - PluginRNActivity.this.getIntent().getLongExtra("extra_click_device_time", 0) < 300) {
                                this.O00000oo.onAnimationEnd(null);
                                return true;
                            }
                            ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.3f).setDuration(350L);
                            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass24.AnonymousClass1.AnonymousClass2 */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                    PluginRNActivity.this.O00000Oo.setAlpha(floatValue);
                                    reactRootView2.setAlpha((1.0f - floatValue) + 0.3f);
                                }
                            });
                            duration.addListener(this.O00000oo);
                            duration.start();
                            return true;
                        }
                    });
                }
            });
            JSONObject O000000o2 = fvu.O000000o(stringExtra);
            if (!"t.t.t".equals(stringExtra) && (O000000o2 == null || !O000000o2.optBoolean(fvt.O00000o0))) {
                z = false;
            } else {
                z = true;
            }
            boolean O000000o3 = fwz.O000000o().O00000Oo().O000000o();
            gbu.O00000oo("PluginRNActivity  is_debug=" + O000000o3 + "  isPluginDebugChecked=" + z + "  model=" + stringExtra);
            if (this.O00000oo != 1 || O000000o3) {
                fwx.O000000o().O00000o = false;
            } else {
                fwx.O000000o().O00000o = true;
            }
            if (O000000o3) {
                View findViewById = findViewById(R.id.drag_button_dev_setting);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass25 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    volatile boolean f8155O000000o = false;

                    public final void onClick(View view) {
                        final ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
                        fyc.O00000Oo("rn-plugin", "handleReloadJS,isReloading:" + this.f8155O000000o);
                        if (reactInstanceManager != null && !this.f8155O000000o) {
                            this.f8155O000000o = true;
                            reactInstanceManager.getDevSupportManager().handleReloadJS();
                            reactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
                                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass25.AnonymousClass1 */

                                public final void onReactContextInitialized(ReactContext reactContext) {
                                    reactInstanceManager.removeReactInstanceEventListener(this);
                                    try {
                                        reactInstanceManager.getCurrentReactContext().getCatalystInstance().getReactQueueConfiguration().getJSQueueThread().runOnQueue(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001c: INVOKE  
                                              (wrap: com.facebook.react.bridge.queue.MessageQueueThread : 0x0013: INVOKE  (r3v8 com.facebook.react.bridge.queue.MessageQueueThread) = 
                                              (wrap: com.facebook.react.bridge.queue.ReactQueueConfiguration : 0x000f: INVOKE  (r3v7 com.facebook.react.bridge.queue.ReactQueueConfiguration) = 
                                              (wrap: com.facebook.react.bridge.CatalystInstance : 0x000b: INVOKE  (r3v6 com.facebook.react.bridge.CatalystInstance) = 
                                              (wrap: com.facebook.react.bridge.ReactContext : 0x0007: INVOKE  (r3v5 com.facebook.react.bridge.ReactContext) = 
                                              (wrap: com.facebook.react.ReactInstanceManager : 0x0005: IGET  (r3v4 com.facebook.react.ReactInstanceManager) = (r2v0 'this' com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity$25$1 A[THIS]) com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.25.1.O000000o com.facebook.react.ReactInstanceManager)
                                             type: VIRTUAL call: com.facebook.react.ReactInstanceManager.getCurrentReactContext():com.facebook.react.bridge.ReactContext)
                                             type: VIRTUAL call: com.facebook.react.bridge.ReactContext.getCatalystInstance():com.facebook.react.bridge.CatalystInstance)
                                             type: INTERFACE call: com.facebook.react.bridge.CatalystInstance.getReactQueueConfiguration():com.facebook.react.bridge.queue.ReactQueueConfiguration)
                                             type: INTERFACE call: com.facebook.react.bridge.queue.ReactQueueConfiguration.getJSQueueThread():com.facebook.react.bridge.queue.MessageQueueThread)
                                              (wrap: com.xiaomi.smarthome.framework.plugin.rn.-$$Lambda$PluginRNActivity$25$1$AdaUHcV8YpNetdr4ggbZkptn8D0 : 0x0019: CONSTRUCTOR  (r0v2 com.xiaomi.smarthome.framework.plugin.rn.-$$Lambda$PluginRNActivity$25$1$AdaUHcV8YpNetdr4ggbZkptn8D0) = (r2v0 'this' com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity$25$1 A[THIS]) call: com.xiaomi.smarthome.framework.plugin.rn.-$$Lambda$PluginRNActivity$25$1$AdaUHcV8YpNetdr4ggbZkptn8D0.<init>(com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity$25$1):void type: CONSTRUCTOR)
                                             type: INTERFACE call: com.facebook.react.bridge.queue.MessageQueueThread.runOnQueue(java.lang.Runnable):void in method: com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.25.1.onReactContextInitialized(com.facebook.react.bridge.ReactContext):void, dex: classes5.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:318)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: CONSTRUCTOR  (r0v2 com.xiaomi.smarthome.framework.plugin.rn.-$$Lambda$PluginRNActivity$25$1$AdaUHcV8YpNetdr4ggbZkptn8D0) = (r2v0 'this' com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity$25$1 A[THIS]) call: com.xiaomi.smarthome.framework.plugin.rn.-$$Lambda$PluginRNActivity$25$1$AdaUHcV8YpNetdr4ggbZkptn8D0.<init>(com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity$25$1):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.25.1.onReactContextInitialized(com.facebook.react.bridge.ReactContext):void, dex: classes5.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	... 119 more
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.framework.plugin.rn.-$$Lambda$PluginRNActivity$25$1$AdaUHcV8YpNetdr4ggbZkptn8D0, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	... 125 more
                                            */
                                        /*
                                            this = this;
                                            com.facebook.react.ReactInstanceManager r3 = r3
                                            r3.removeReactInstanceEventListener(r2)
                                            com.facebook.react.ReactInstanceManager r3 = r3     // Catch:{ Throwable -> 0x0020 }
                                            com.facebook.react.bridge.ReactContext r3 = r3.getCurrentReactContext()     // Catch:{ Throwable -> 0x0020 }
                                            com.facebook.react.bridge.CatalystInstance r3 = r3.getCatalystInstance()     // Catch:{ Throwable -> 0x0020 }
                                            com.facebook.react.bridge.queue.ReactQueueConfiguration r3 = r3.getReactQueueConfiguration()     // Catch:{ Throwable -> 0x0020 }
                                            com.facebook.react.bridge.queue.MessageQueueThread r3 = r3.getJSQueueThread()     // Catch:{ Throwable -> 0x0020 }
                                            com.xiaomi.smarthome.framework.plugin.rn.-$$Lambda$PluginRNActivity$25$1$AdaUHcV8YpNetdr4ggbZkptn8D0 r0 = new com.xiaomi.smarthome.framework.plugin.rn.-$$Lambda$PluginRNActivity$25$1$AdaUHcV8YpNetdr4ggbZkptn8D0     // Catch:{ Throwable -> 0x0020 }
                                            r0.<init>(r2)     // Catch:{ Throwable -> 0x0020 }
                                            r3.runOnQueue(r0)     // Catch:{ Throwable -> 0x0020 }
                                            return
                                        L_0x0020:
                                            r3 = move-exception
                                            java.lang.String r0 = "rn-plugin"
                                            java.lang.String r1 = "handleReloadJS,onReactContextInitialized error,"
                                            _m_j.fyc.O000000o(r0, r1, r3)
                                            com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity$25 r3 = com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass25.this
                                            r0 = 0
                                            r3.f8155O000000o = r0
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass25.AnonymousClass1.onReactContextInitialized(com.facebook.react.bridge.ReactContext):void");
                                    }

                                    /* access modifiers changed from: private */
                                    public /* synthetic */ void O000000o() {
                                        AnonymousClass25.this.f8155O000000o = false;
                                    }
                                });
                            }
                        }
                    });
                }
                this.O0000o = new RNEventReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("action.more.rename.notify");
                intentFilter.addAction("startscan_callback");
                intentFilter.addAction("discoverservices_callback");
                intentFilter.addAction("discovercharacteristics_callback");
                intentFilter.addAction("devicestatuschanged");
                intentFilter.addAction("push_action_plugin");
                ft.O000000o(this).O000000o(this.O0000o, intentFilter);
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("action.more.rename.notify");
                intentFilter2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                intentFilter2.addAction("com.xiaomi.smarthome.bluetooth.connect_status_changed");
                intentFilter2.addAction("com.xiaomi.smarthome.bluetooth.character_changed");
                intentFilter2.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
                intentFilter2.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
                intentFilter2.addAction("com.xiaomi.deviceStatusChanged");
                intentFilter2.addAction("com.xiaomi.iot.firmware.new_version");
                intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter2.addAction("com.xiaomi.smarthome.ble.spec.notify");
                intentFilter2.addAction("NETWORK.CONNECTION.CHANGED");
                intentFilter2.addAction("device_pincode_switch_changed");
                registerReceiver(this.O0000o, intentFilter2);
                this.O0000oO0 = new OfflineViewDelegate(this, this.O00000oO);
                this.O0000oO0.onCreate();
                return;
            }
            gbu.O00000oo("PluginRNActivity-->doCreate-->finish");
            finish();
        }

        public void doResume() {
            fwz.O000000o().O000000o(new fwy.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass26 */

                public final void onAttachPlugin(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
                    if (!(reactInstanceManager == null || reactInstanceManager.getLifecycleState() == LifecycleState.RESUMED)) {
                        gbu.O00000oo("PluginRNActivity doResume  onAttachPlugin...");
                        PluginRNActivity pluginRNActivity = PluginRNActivity.this;
                        reactInstanceManager.onHostResume(pluginRNActivity, pluginRNActivity.handler);
                        ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("eventName", "packageDidResume_36621");
                        if (currentReactContext != null) {
                            ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("packageDidResume_36621", createMap);
                        } else {
                            gbu.O00000oo("PluginRnActivity-->doResume-->onAttachPlugin reactContext is null...");
                        }
                    }
                    PluginRNActivity.this.initFpsMemoryView(reactInstanceManager);
                    PluginRNActivity.this.initReportSubscriber(reactInstanceManager);
                }
            });
            this.O0000oo0 = new MessageQueue.IdleHandler() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass27 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.fwz.O000000o(boolean, int):void
                 arg types: [int, int]
                 candidates:
                  _m_j.fwz.O000000o(boolean, com.facebook.react.bridge.WritableMap):void
                  _m_j.fwz.O000000o(boolean, int):void */
                public final boolean queueIdle() {
                    if (gbt.O00000oO()) {
                        fwz.O000000o().O000000o(false, -1);
                    }
                    return false;
                }
            };
            Looper.myQueue().addIdleHandler(this.O0000oo0);
        }

        public void initReportSubscriber(ReactInstanceManager reactInstanceManager) {
            boolean booleanValue = ((Boolean) gat.O000000o("fps_mem_report_switch", Boolean.TRUE)).booleanValue();
            fyc.O000000o("rn-plugin", "reportFpsMem:".concat(String.valueOf(booleanValue)));
            if (booleanValue && gaw.O000000o()) {
                if (this.O0000oOO == null || this.O0000oOo == null) {
                    UiThreadUtil.runOnUiThread(new Runnable(reactInstanceManager) {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.$$Lambda$PluginRNActivity$5PF_h1IWNZ3TfixNaYC2jL_hT_8 */
                        private final /* synthetic */ ReactInstanceManager f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            PluginRNActivity.this.O00000Oo(this.f$1);
                        }
                    }, 5000);
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(ReactInstanceManager reactInstanceManager) {
            ReactContext currentReactContext;
            gbe.O000000o().O00000Oo();
            if (!(reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null || this.O0000oOO != null)) {
                this.O0000oOO = new gbd(currentReactContext);
                this.O0000oOO.O000000o();
            }
            if (this.O0000oOo == null) {
                this.O0000oOo = new gbf();
                gbf gbf = this.O0000oOo;
                if (!gbf.O00000Oo) {
                    gbf.O00000Oo = true;
                    gbf.O00000o0 = 0;
                    gbf.O00000o = 0;
                    gbf.O00000oO = 0;
                    gbf.O00000oo = -1;
                    gbf.O0000O0o = -1;
                    gbf.O0000OOo = -1;
                    gbf.O0000Oo0 = -1;
                    gbf.f17494O000000o.postDelayed(gbf.O0000Oo, 500);
                }
            }
        }

        public void initFpsMemoryView(ReactInstanceManager reactInstanceManager) {
            boolean z;
            gbu.O000000o("FpsMemoryView  initFpsMemoryView...");
            if (reactInstanceManager != null && this.O0000Oo == null) {
                fvo.O000000o();
                if (fvo.O00000oO()) {
                    fvo.O000000o();
                    if (fvo.O0000O0o()) {
                        z = true;
                        if (z && this.O0000Oo == null) {
                            runOnUiThread(new Runnable(reactInstanceManager) {
                                /* class com.xiaomi.smarthome.framework.plugin.rn.$$Lambda$PluginRNActivity$xKmnkJMDy3M3taEJ5qavJVbR6qk */
                                private final /* synthetic */ ReactInstanceManager f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    PluginRNActivity.this.O000000o(this.f$1);
                                }
                            });
                            return;
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(ReactInstanceManager reactInstanceManager) {
            this.O0000Oo = (FpsMemoryView) this.f8119O000000o.findViewById(R.id.fps_memory_view);
            this.O0000Oo.setVisibility(0);
            FpsMemoryView fpsMemoryView = this.O0000Oo;
            fpsMemoryView.f8463O000000o = new FpsDebugFrameCallback(reactInstanceManager.getCurrentReactContext());
            fpsMemoryView.O00000Oo = new FpsMemoryView.O000000o(fpsMemoryView, (byte) 0);
            if (fpsMemoryView.f8463O000000o != null) {
                fpsMemoryView.f8463O000000o.reset();
                fpsMemoryView.f8463O000000o.start();
            }
            if (fpsMemoryView.O00000Oo != null) {
                FpsMemoryView.O000000o o000000o = fpsMemoryView.O00000Oo;
                if (o000000o.f8466O000000o) {
                    o000000o.f8466O000000o = false;
                    FpsMemoryView.this.post(o000000o);
                }
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            gsy.O000000o(3, "rn-plugin", "onSaveInstanceState");
            bundle.putBoolean("extra_recycle_plugin", true);
        }

        public void doPause() {
            fwz.O000000o().O000000o(new fwy.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass2 */

                public final void onAttachPlugin(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
                    fyc.O00000Oo("rn-plugin", "doPause,onAttachPlugin");
                    ReactContext currentReactContext = reactInstanceManager != null ? reactInstanceManager.getCurrentReactContext() : null;
                    if (currentReactContext != null && currentReactContext.getCurrentActivity() != PluginRNActivity.this) {
                        fyc.O00000o0("rn-plugin", "doPause, currentActivity: " + currentReactContext.getCurrentActivity() + ", PluginRNActivity.this:" + PluginRNActivity.this + ", so just return");
                    } else if (reactInstanceManager.getLifecycleState() == LifecycleState.RESUMED) {
                        try {
                            reactInstanceManager.onHostPause(PluginRNActivity.this);
                        } catch (Exception e) {
                            Log.e("doPause", "fatal", e);
                        }
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("eventName", "packageWillPause_36621");
                        if (currentReactContext != null) {
                            ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("packageWillPause_36621", createMap);
                        } else {
                            gbu.O00000oo("PluginRnActivity-->doPause-->onAttachPlugin reactContext is null...");
                        }
                    }
                }
            });
        }

        public void doNewIntent(final Intent intent) {
            final WritableNativeMap writableNativeMap = new WritableNativeMap();
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String next : extras.keySet()) {
                    writableNativeMap.putString(next, String.valueOf(extras.get(next)));
                }
            }
            fwz.O000000o().O000000o(new fwy.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass3 */

                public final void onAttachPlugin(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
                    ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                    reactInstanceManager.onNewIntent(intent);
                    if ("ScenePush".equals(intent.getStringExtra("type"))) {
                        if (currentReactContext != null) {
                            ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("packageReceivedInformation_36621", writableNativeMap);
                        } else {
                            gbu.O00000oo("PluginRnActivity-->doNewIntent-->onAttachPlugin  ScenePush reactContext is null...");
                        }
                    } else if (currentReactContext != null) {
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("deviceStatusUpdatedEventName_36621", writableNativeMap);
                    } else {
                        gbu.O00000oo("PluginRnActivity-->doNewIntent-->onAttachPlugin  reactContext is null...");
                    }
                }
            });
        }

        public void onConfigurationChanged(Configuration configuration) {
            ReactContext currentReactContext;
            super.onConfigurationChanged(configuration);
            getWindow().getDecorView().dispatchConfigurationChanged(configuration);
            gsy.O000000o(3, "receiver", String.valueOf(configuration.orientation));
            String str = configuration.orientation == 1 ? "PORTRAIT" : "LANDSCAPE";
            WritableMap createMap = Arguments.createMap();
            createMap.putString("orientation", str);
            ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
            if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
                gbu.O00000Oo("rncamera ReactInstanceManager is null, can not send event, eventName: reactContext");
            } else if (fwz.O000000o().O00000Oo().O00000o0()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("orientationDidChange", createMap);
            } else {
                gbu.O00000Oo("rncamera can not send event, eventName: reactContext");
            }
            gqc.O000000o(!(configuration.orientation == 2), getWindow().getDecorView());
        }

        public void doActivityResult(final int i, final int i2, final Intent intent) {
            gle remove;
            gbu.O00000o0("doActivityResult,requestCode:" + i + ",resultCode:" + i);
            if (9999 == i) {
                if (i2 == 0) {
                    gbu.O00000oo("PluginRNActivity-->doActivityResult-->finish...");
                    finish();
                    return;
                }
                Bundle bundleExtra = intent.getBundleExtra("login_response_bundle");
                if (!(bundleExtra == null || !CoreApi.O000000o().O0000o(this.O00000oO.model) || (remove = fpp.O00000Oo.remove(getDeviceStat().did)) == null)) {
                    fyc.O00000o0("rn-plugin", "doActivityResult security chip login success");
                    remove.O00000o(0, bundleExtra);
                }
                fwz.O000000o().O000000o(new fwy.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.$$Lambda$PluginRNActivity$xHGmHWEit3yk8s28yujOJTlv_os */

                    public final void onAttachPlugin(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
                        PluginRNActivity.this.O000000o(reactRootView, reactInstanceManager, deviceStat, pluginPackageInfo);
                    }
                });
            } else if (404 == i) {
                Intent intent2 = new Intent("miot-rn-framework.ui.generate_crontab_string");
                if (intent != null) {
                    intent2.putExtras(intent);
                }
                ft.O000000o(this).O000000o(intent2);
            } else {
                if (fwz.O000000o().O00000Oo().O0000O0o != null) {
                    fwz.O000000o().O00000Oo().O0000O0o.onActivityResult(this, i, i2, intent);
                }
                fwz.O000000o().O000000o(new fwy.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass4 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.fwz.O000000o(boolean, com.facebook.react.bridge.WritableMap):void
                     arg types: [int, com.facebook.react.bridge.WritableMap]
                     candidates:
                      _m_j.fwz.O000000o(boolean, int):void
                      _m_j.fwz.O000000o(boolean, com.facebook.react.bridge.WritableMap):void */
                    public final void onAttachPlugin(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
                        WritableMap writableMap;
                        Intent intent;
                        fyc.O00000Oo("rn-plugin", "doActivityResult,onAttachPlugin");
                        ReactContext currentReactContext = reactInstanceManager != null ? reactInstanceManager.getCurrentReactContext() : null;
                        if (currentReactContext == null || currentReactContext.getCurrentActivity() == PluginRNActivity.this) {
                            boolean z = true;
                            if (i == 101 && i2 == -1 && (intent = intent) != null) {
                                String stringExtra = intent.getStringExtra("extra_list_entity");
                                WritableMap createMap = Arguments.createMap();
                                createMap.putString("eventName", "multiSwitchNameChanged_36621");
                                createMap.putString("did", deviceStat.did);
                                createMap.putString("value", stringExtra);
                                if (i2 != -1) {
                                    z = false;
                                }
                                createMap.putBoolean("success", z);
                                gsy.O00000Oo("multiSwitchNameChanged", "resultCode:" + i2 + "  value: " + stringExtra + "  did: " + deviceStat.did);
                                if (currentReactContext != null) {
                                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("multiSwitchNameChanged_36621", createMap);
                                } else {
                                    gbu.O00000oo("PluginRnActivity-->doActivityResult-->onAttachPlugin multiSwitchNameChanged  reactContext is null...");
                                }
                            } else {
                                Intent intent2 = intent;
                                if (intent2 == null || i != 3 || i2 != 4) {
                                    Intent intent3 = intent;
                                    if (intent3 == null || i != 201) {
                                        if (intent == null || i != 301) {
                                            int i = i;
                                            if (i != 401) {
                                                Intent intent4 = intent;
                                                if (intent4 == null || i != 400) {
                                                    if (intent != null && i == 402) {
                                                        Intent intent5 = new Intent("miot-rn-framework.file_select");
                                                        intent5.putExtras(intent);
                                                        intent5.putExtra("intent.mData", intent.getData());
                                                        ft.O000000o(PluginRNActivity.this).O000000o(intent5);
                                                    } else if (intent != null && i == 403) {
                                                        Intent intent6 = new Intent("miot-rn-framework.file_select");
                                                        intent6.putExtras(intent);
                                                        intent6.putExtra("intent.mData", intent.getData());
                                                        ft.O000000o(PluginRNActivity.this).O000000o(intent6);
                                                    } else if (intent == null || i != 1002) {
                                                        Intent intent7 = intent;
                                                        if (intent7 != null && -1 == i2 && "removedLicense".equals(intent7.getStringExtra("result_data"))) {
                                                            WritableMap createMap2 = Arguments.createMap();
                                                            createMap2.putString("eventName", "packageAuthorizationCancel_36621");
                                                            if (currentReactContext != null) {
                                                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("packageAuthorizationCancel_36621", createMap2);
                                                            } else {
                                                                gbu.O00000oo("PluginRnActivity-->doActivityResult-->onAttachPlugin 撤销隐私授权  reactContext is null...");
                                                            }
                                                            DeviceStat deviceStat2 = fwz.O000000o().O00000Oo().O0000o00;
                                                            PluginPackageInfo pluginPackageInfo2 = fwz.O000000o().O00000Oo().O0000OoO;
                                                            StringBuilder sb = new StringBuilder();
                                                            sb.append(MIOTPackageModule.getPluginDir(PluginRNActivity.this, pluginPackageInfo2).getAbsolutePath());
                                                            sb.append(File.separator);
                                                            sb.append(deviceStat2 == null ? "0" : deviceStat.did);
                                                            fwz.O000000o().O000000o(sb.toString());
                                                            PluginRNActivity.this.finishActivityDelay(500);
                                                        }
                                                    } else {
                                                        WritableMap createMap3 = Arguments.createMap();
                                                        createMap3.putMap("home", Arguments.fromBundle(intent.getExtras()));
                                                        createMap3.putString("eventName", "packageReceivedInformation_36621");
                                                        if (currentReactContext != null) {
                                                            ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("packageReceivedInformation_36621", createMap3);
                                                        } else {
                                                            gbu.O00000oo("PluginRnActivity-->doActivityResult-->onAttachPlugin RNEventReceiver.VIEWWILLAPPEAR  reactContext is null...");
                                                        }
                                                    }
                                                } else if (-1 == i2) {
                                                    String stringExtra2 = intent4.getStringExtra("rn_plugin");
                                                    WritableMap createMap4 = Arguments.createMap();
                                                    createMap4.putString("result", stringExtra2);
                                                    gbu.O00000o0("qrCodeScDevice:".concat(String.valueOf(stringExtra2)));
                                                    fwz.O000000o().O00000Oo(true, gbq.O000000o(0, createMap4));
                                                } else {
                                                    gbu.O00000o0("RESULT_OK != resultCode");
                                                    fwz.O000000o().O00000Oo(false, gbq.O000000o(-1, "unknown error"));
                                                }
                                            } else if (intent != null) {
                                                Intent intent8 = new Intent("miotwifispeaker.address_select");
                                                intent8.putExtras(intent);
                                                ft.O000000o(PluginRNActivity.this).O000000o(intent8);
                                            } else {
                                                ft.O000000o(PluginRNActivity.this).O000000o(new Intent("miotwifispeaker.address_select"));
                                            }
                                        } else {
                                            Intent intent9 = new Intent("miotwifispeaker.pick_alarm_ring");
                                            intent9.putExtras(intent);
                                            ft.O000000o(PluginRNActivity.this).O000000o(intent9);
                                        }
                                    } else if (intent3.getExtras() != null) {
                                        try {
                                            fwz.O000000o().O000000o(true, gbq.O000000o(0, Arguments.fromBundle(intent.getExtras())));
                                        } catch (Exception e) {
                                            fwz.O000000o().O000000o(false, gbq.O000000o(-1, e.toString()));
                                        }
                                    }
                                } else if (deviceStat != null) {
                                    TimeZone timeZone = (TimeZone) intent2.getSerializableExtra("TimeZone");
                                    TimeZone timeZone2 = TimeZone.getDefault();
                                    TimeZone.setDefault(timeZone);
                                    String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
                                    TimeZone.setDefault(timeZone2);
                                    WritableMap createMap5 = Arguments.createMap();
                                    createMap5.putString("eventName", "deviceTimeZoneChanged_36621");
                                    createMap5.putString("timeZone", displayName);
                                    createMap5.putString("did", deviceStat.did);
                                    gsy.O00000Oo("deviceTimeZoneChangedEvent", "  offset: " + displayName + "  did: " + deviceStat.did);
                                    if (currentReactContext != null) {
                                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("deviceTimeZoneChanged_36621", createMap5);
                                    } else {
                                        gbu.O00000oo("PluginRnActivity-->doActivityResult-->onAttachPlugin deviceTimeZoneChangedEvent  reactContext is null...");
                                    }
                                }
                            }
                            Intent intent10 = intent;
                            if (intent10 == null || intent10.getExtras() == null) {
                                writableMap = Arguments.createMap();
                            } else {
                                try {
                                    writableMap = Arguments.fromBundle(intent.getExtras());
                                } catch (IllegalArgumentException e2) {
                                    WritableMap createMap6 = Arguments.createMap();
                                    gsy.O00000Oo("PluginRNActivity", e2.toString());
                                    writableMap = createMap6;
                                }
                            }
                            writableMap.putString("eventName", "packageViewWillAppear_36621");
                            if (currentReactContext != null) {
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("packageViewWillAppear_36621", writableMap);
                            } else {
                                gbu.O00000oo("PluginRnActivity-->doActivityResult-->onAttachPlugin RNEventReceiver.VIEWWILLAPPEAR  reactContext is null...");
                            }
                        } else {
                            fyc.O00000o0("rn-plugin", "doActivityResult, currentActivity: " + currentReactContext.getCurrentActivity() + ", PluginRNActivity.this:" + PluginRNActivity.this + ", so just return");
                        }
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
            fyc.O00000Oo("rn-plugin", "doActivityResult,onAttachPlugin");
            ReactContext currentReactContext = reactInstanceManager != null ? reactInstanceManager.getCurrentReactContext() : null;
            if (currentReactContext == null || currentReactContext.getCurrentActivity() == this) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("eventName", "pinCodeVerifyPassed_36621");
                createMap.putString("did", deviceStat.did);
                gsy.O00000Oo("pinCodeVerifyPassed", "  did: " + deviceStat.did);
                if (currentReactContext != null) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("pinCodeVerifyPassed_36621", createMap);
                } else {
                    gbu.O00000oo("PluginRnActivity-->doActivityResult-->onAttachPlugin pinCodeVerifyPassed  reactContext is null...");
                }
            } else {
                fyc.O00000o0("rn-plugin", "doActivityResult, currentActivity: " + currentReactContext.getCurrentActivity() + ", PluginRNActivity.this:" + this + ", so just return");
            }
        }

        public void finishActivityDelay(long j) {
            if (this.f8119O000000o != null) {
                this.f8119O000000o.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass5 */

                    public final void run() {
                        gbu.O00000oo("PluginRNActivity-->finishActivityDelay  mActivityFinished=" + PluginRNActivity.this.mActivityFinished);
                        if (!PluginRNActivity.this.mActivityFinished) {
                            PluginRNActivity.this.finish();
                        }
                    }
                }, j);
            }
        }

        public void onBackPressed() {
            ReactContext currentReactContext;
            gbu.O00000oo("rn activity... onBackPressed...mIsReady is " + this.O0000OOo);
            if (this.O0000OOo) {
                ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
                if (reactInstanceManager != null && fwz.O000000o().O00000Oo().O00000o0()) {
                    fwy O00000Oo = fwz.O000000o().O00000Oo();
                    boolean z = false;
                    if (!(O00000Oo.O0000O0o == null || (currentReactContext = O00000Oo.O0000O0o.getCurrentReactContext()) == null)) {
                        z = currentReactContext.hasActiveCatalystInstance();
                    }
                    if (z) {
                        reactInstanceManager.onBackPressed();
                        return;
                    }
                }
                super.onBackPressed();
                return;
            }
            super.onBackPressed();
        }

        public void doFinish() {
            DeviceStat deviceStat = getDeviceStat();
            if (deviceStat != null) {
                fpp.O00000Oo.remove(deviceStat.did);
            }
            fwz.O000000o().O000000o(new fwy.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass6 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.fwy.O000000o(com.xiaomi.smarthome.device.api.DeviceStat, com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.os.Bundle, boolean):void
                 arg types: [com.xiaomi.smarthome.device.api.DeviceStat, com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.os.Bundle, int]
                 candidates:
                  _m_j.fwy.O000000o(long, long, java.lang.String, int, int):void
                  _m_j.fwy.O000000o(com.xiaomi.smarthome.device.api.DeviceStat, com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, int, boolean):void
                  _m_j.fwy.O000000o(com.xiaomi.smarthome.device.api.DeviceStat, com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.os.Bundle, boolean):void */
                public final void onAttachPlugin(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
                    fwy O00000Oo;
                    fyc.O00000Oo("rn-plugin", "doFinish,onAttachPlugin");
                    ReactContext currentReactContext = reactInstanceManager != null ? reactInstanceManager.getCurrentReactContext() : null;
                    if (currentReactContext == null || currentReactContext.getCurrentActivity() == PluginRNActivity.this) {
                        ft.O000000o(PluginRNActivity.this).O000000o(PluginRNActivity.this.getIntent().setAction("scene_action_plugin"));
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("eventName", "packageWillExit_36621");
                        if (currentReactContext != null) {
                            ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("packageWillExit_36621", createMap);
                        } else {
                            gbu.O00000oo("PluginRnActivity-->doFinish-->onAttachPlugin reactContext is null...");
                        }
                        fwz O000000o2 = fwz.O000000o();
                        gbu.O00000oo("RNRuntimeManager onActivityFinish()");
                        if (gbt.O000000o()) {
                            if (!(!gbt.O00000Oo() || (O00000Oo = O000000o2.O00000Oo()) == null || O00000Oo.O0000o00 == null || gbt.O00000Oo(O00000Oo.O0000o00.model) || O00000Oo.O0000o00 == null)) {
                                DeviceStat deviceStat2 = O00000Oo.O0000o00;
                                PluginPackageInfo pluginPackageInfo2 = O00000Oo.O0000OoO;
                                PluginDeviceInfo pluginDeviceInfo = O00000Oo.O0000Ooo;
                                Bundle bundle = O00000Oo.O0000o0;
                                gbu.O00000oo("RNRuntimeManager onActivityFinish(),addRnRuntimeCopyToCache");
                                fwy O00000o0 = fwz.O00000o0(false);
                                O00000o0.O000000o(deviceStat2, pluginPackageInfo2, pluginDeviceInfo, bundle, false);
                                fwv O00000oO = O00000o0.O00000oO();
                                if (O00000oO != null) {
                                    fxa.O000000o().O000000o(O00000oO, O00000o0);
                                }
                                O00000o0.O00000Oo(false);
                            }
                            if (fxa.O000000o().O00000o0 == null) {
                                gbu.O00000oo("RNRuntimeManager onActivityFinish(),getClearRNRuntime() == null");
                                fxa.O000000o().O000000o(fwz.O00000o0(true));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    fyc.O00000o0("rn-plugin", "doFinish, currentActivity: " + currentReactContext.getCurrentActivity() + ", PluginRNActivity.this:" + PluginRNActivity.this + ", so just return");
                }
            });
        }

        public void doDestroy() {
            fwy fwy = this.O0000oo;
            if (fwy != null) {
                if (fwy.O0000OOo == this) {
                    this.O0000oo.O0000OOo = null;
                } else {
                    fyc.O00000o0("rn-plugin", "doDestroy, relativeActivity: " + this.O0000oo.O0000OOo + ", this:" + this + ", not unregisterActivity");
                }
            }
            BroadcastReceiver broadcastReceiver = this.O0000o;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
                ft.O000000o(this).O000000o(this.O0000o);
                this.O0000o = null;
            }
            if (this.O0000oo0 != null) {
                Looper.myQueue().removeIdleHandler(this.O0000oo0);
                this.O0000oo0 = null;
            }
            fwy fwy2 = this.O0000oo;
            if (fwy2 != null) {
                fwy2.O000000o(new fwy.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass7 */

                    public final void onAttachPlugin(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
                        fyc.O00000Oo("rn-plugin", "doDestroy,onAttachPlugin");
                        ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                        if (currentReactContext == null || currentReactContext.getCurrentActivity() == PluginRNActivity.this) {
                            if (reactRootView.getParent() instanceof ViewGroup) {
                                ((ViewGroup) reactRootView.getParent()).removeView(reactRootView);
                            }
                            if (reactInstanceManager.getCurrentReactContext() != null) {
                                fyc.O00000Oo("rn-plugin", "doDestroy,unmountReactApplication");
                                reactRootView.unmountReactApplication();
                            }
                            reactInstanceManager.onHostDestroy(PluginRNActivity.this);
                            if (gbt.O000000o()) {
                                boolean O00000Oo = gbt.O00000Oo(PluginRNActivity.this.getDeviceModel());
                                gbu.O00000oo("PluginRNActivity doDestroy,onAttachPlugin()-->supportMultiRNRuntimeReuse:".concat(String.valueOf(O00000Oo)));
                                if (!O00000Oo) {
                                    gbu.O00000oo("PluginRNActivity-->instanceManager.destroy()...".concat(String.valueOf(this)));
                                    reactInstanceManager.destroy();
                                    return;
                                }
                                return;
                            }
                            boolean O000000o2 = gbt.O000000o(PluginRNActivity.this.getDeviceModel());
                            gbu.O00000oo("PluginRNActivity doDestroy,onAttachPlugin()-->processReuseEnable:".concat(String.valueOf(O000000o2)));
                            if (!O000000o2) {
                                reactInstanceManager.destroy();
                                return;
                            }
                            return;
                        }
                        fyc.O00000o0("rn-plugin", "doDestroy, currentActivity: " + currentReactContext.getCurrentActivity() + ", PluginRNActivity.this:" + PluginRNActivity.this + ", so just return");
                    }
                });
            }
            gbu.O000000o("launchMsgType:  " + this.O00000oo);
            OfflineViewDelegate offlineViewDelegate = this.O0000oO0;
            if (offlineViewDelegate != null) {
                offlineViewDelegate.onDestroy();
            }
            Observable.just(0).subscribeOn(Schedulers.io()).map(new Function<Integer, Boolean>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass8 */

                public final /* synthetic */ Object apply(Object obj) throws Exception {
                    gat.O000000o();
                    return Boolean.TRUE;
                }
            }).subscribe();
        }

        public void onResume() {
            super.onResume();
            gbu.O00000oo("PluginRNActivity-->onResume..." + this.O0000OOo + " " + this);
            if (this.O0000OOo) {
                doResume();
            } else {
                this.O0000O0o.add(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass9 */

                    public final void run() {
                        PluginRNActivity.this.doResume();
                    }
                });
            }
            Callback callback = this.O0000o0O;
            if (callback != null) {
                callback.invoke(new Object[0]);
            }
            if (this.O0000oO == null) {
                this.O0000oO = new gbc(fwz.O000000o().O00000Oo().O0000o00, new gbc.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass10 */

                    public final void O000000o(String str, String str2, JSONArray jSONArray) {
                        PluginRNActivity.this.processRnDevicePropSubscriber(str, str2, jSONArray);
                    }
                });
            }
            gbd gbd = this.O0000oOO;
            if (gbd != null) {
                gbd.O000000o();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("miui.action_open_floating_window");
            registerReceiver(this.O0000ooO, intentFilter);
        }

        public void processRnDevicePropSubscriber(String str, String str2, JSONArray jSONArray) {
            boolean z;
            boolean z2;
            if (jSONArray != null) {
                int length = jSONArray.length();
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("key");
                        if ("event.dev_offline".equals(optString)) {
                            z = true;
                            break;
                        } else if ("event.dev_online".equals(optString)) {
                            z = false;
                            z2 = true;
                            break;
                        }
                    }
                    i++;
                }
                z2 = false;
                if (z) {
                    O000000o(str, false);
                }
                if (z2) {
                    OfflineViewDelegate offlineViewDelegate = this.O0000oO0;
                    if (offlineViewDelegate != null) {
                        offlineViewDelegate.deviceStatusOnline(this.O0000Oo0);
                    }
                    O000000o(str, true);
                }
            }
        }

        private static void O000000o(String str, boolean z) {
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putBoolean("isOnline", z);
            createMap.putMap("newStatus", createMap2);
            createMap.putString("did", str);
            try {
                gbu.O000000o("send RNEventReceiver.DEVICE_STATUS_CHANGED..." + createMap.toString());
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) fwz.O000000o().O00000Oo().O0000O0o.getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("deviceStatusChanged_36621", createMap);
            } catch (Exception e) {
                gsy.O000000o(6, "rn-plugin", e.toString());
            }
        }

        public void onDestroy() {
            HashMap hashMap;
            super.onDestroy();
            gbu.O00000oo("================= 退出插件 ======================" + this.O0000OOo);
            gbu.O000000o(this);
            gbu.O0000O0o("================= 退出插件 ======================");
            gbu.O00000oo("PluginRNActivity-->onDestroy...".concat(String.valueOf(this)));
            this.mActivityFinished = true;
            fwz.O000000o().O00000Oo(false);
            gbc gbc = this.O0000oO;
            if (gbc != null) {
                gbc.O000000o();
                gbc.O00000o0 = null;
                gbc.O00000Oo.removeMessages(1);
                gbc.f17487O000000o.quit();
                gbc.O00000Oo = null;
                gbc.f17487O000000o = null;
            }
            gbd gbd = this.O0000oOO;
            if (gbd != null) {
                gbd.O00000Oo();
                gbd gbd2 = this.O0000oOO;
                if (gbd2.O00000o != null) {
                    gbd2.O00000o.removeCallbacks(gbd2.O00000o0);
                }
                gbd2.O00000Oo = null;
                gbd2.O00000o = null;
                gbd2.f17491O000000o = null;
            }
            gbf gbf = this.O0000oOo;
            if (gbf != null) {
                if (gbf.O00000Oo) {
                    gbf.O00000Oo = false;
                    gbf.O000000o();
                }
                try {
                    gbf gbf2 = this.O0000oOo;
                    if (gbf2.O00000o0 <= 0) {
                        hashMap = null;
                    } else {
                        hashMap = new HashMap();
                        int i = (int) (gbf2.O00000oo / 1048576);
                        int i2 = (int) (gbf2.O0000O0o / 1048576);
                        int i3 = (int) ((gbf2.O00000o / ((long) gbf2.O00000o0)) / 1048576);
                        gbu.O000000o("RnMemoryInfoSubscriber use  minMemory=" + i + "  maxMemory=" + i2 + "  averageMemory=" + i3 + "  mGetMemoryCount=" + gbf2.O00000o0);
                        hashMap.put("plugin_use_memory_min", Integer.valueOf(i));
                        hashMap.put("plugin_use_memory_max", Integer.valueOf(i2));
                        hashMap.put("plugin_use_memory_average", Integer.valueOf(i3));
                        int i4 = ((int) gbf2.O0000OOo) / ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
                        int i5 = ((int) gbf2.O0000Oo0) / ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
                        int i6 = (((int) gbf2.O00000oO) / gbf2.O00000o0) / ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
                        gbu.O000000o("RnMemoryInfoSubscriber allocate  minMemory=" + i4 + "  maxMemory=" + i5 + "  averageMemory=" + i6 + "  mGetMemoryCount=" + gbf2.O00000o0);
                        hashMap.put("plugin_allocate_memory_min", Integer.valueOf(i4));
                        hashMap.put("plugin_allocate_memory_max", Integer.valueOf(i5));
                        hashMap.put("plugin_allocate_memory_average", Integer.valueOf(i6));
                        double maxMemory = (double) Runtime.getRuntime().maxMemory();
                        Double.isNaN(maxMemory);
                        hashMap.put("plugin_allocate_memory_percent", Integer.valueOf((i6 * 100) / ((int) (maxMemory / 1048576.0d))));
                    }
                    long O00000Oo = fwz.O000000o().O00000Oo().O0000OoO.O00000Oo();
                    long O000000o2 = fwz.O000000o().O00000Oo().O0000OoO.O000000o();
                    String str = fwz.O000000o().O00000Oo().O0000o00.model;
                    hashMap.put("package_id", String.valueOf(O00000Oo));
                    hashMap.put("plugin_id", String.valueOf(O000000o2));
                    hashMap.put("device_model", str);
                    hashMap.put("sdk_level", 10058);
                    PluginHostApi.instance().statReport("rn_plugin_framework", "rn_plugin_memory", hashMap);
                } catch (Exception unused) {
                }
                gbf gbf3 = this.O0000oOo;
                if (gbf3.f17494O000000o != null) {
                    gbf3.f17494O000000o.removeCallbacks(gbf3.O0000Oo);
                }
                gbf3.f17494O000000o = null;
            }
            gbe O000000o3 = gbe.O000000o();
            if (O000000o3.f17493O000000o != null) {
                O000000o3.f17493O000000o.quit();
            }
            O000000o3.f17493O000000o = null;
            gbe.O00000Oo = null;
            if (this.O0000OOo) {
                doDestroy();
            } else {
                this.O0000O0o.add(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass11 */

                    public final void run() {
                        PluginRNActivity.this.doDestroy();
                    }
                });
            }
            CameraRouterFactory.getRNCameraApi().clearRNCameraFactory();
        }

        public void finish() {
            super.finish();
            if (hyy.O000000o(getIntent())) {
                overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
            } else {
                overridePendingTransition(R.anim.activity_slide_in_left, R.anim.activity_slide_out_right);
            }
            gbu.O00000oo("activity will finish， send broadcast, mIsSendLaunchPluginFinishAction is " + this.mIsSendLaunchPluginFinishAction);
            if (!this.mIsSendLaunchPluginFinishAction) {
                sendBroadcast(new Intent("action_launch_plugin_finish"));
            }
            if (this.O0000OOo) {
                doFinish();
            } else {
                this.O0000O0o.add(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass13 */

                    public final void run() {
                        PluginRNActivity.this.doFinish();
                    }
                });
            }
        }

        public void onPause() {
            HashMap hashMap;
            super.onPause();
            gbu.O00000oo("PluginRNActivity-->onPause..." + this.O0000OOo + " " + this);
            gbd gbd = this.O0000oOO;
            if (gbd != null) {
                gbd.O00000Oo();
                try {
                    long O00000Oo = fwz.O000000o().O00000Oo().O0000OoO.O00000Oo();
                    long O000000o2 = fwz.O000000o().O00000Oo().O0000OoO.O000000o();
                    String str = fwz.O000000o().O00000Oo().O0000o00.model;
                    gbd gbd2 = this.O0000oOO;
                    if (gbd2.O00000oO <= 0) {
                        hashMap = null;
                    } else {
                        double d = gbd2.O00000oo;
                        double d2 = (double) gbd2.O00000oO;
                        Double.isNaN(d2);
                        int i = (int) (d / d2);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("plugin_fps_average", Integer.valueOf(i));
                        gbu.O000000o("RnFpsInfoSubscriber  report plugin fps is ".concat(String.valueOf(i)));
                        hashMap = hashMap2;
                    }
                    hashMap.put("package_id", String.valueOf(O00000Oo));
                    hashMap.put("plugin_id", String.valueOf(O000000o2));
                    hashMap.put("device_model", str);
                    hashMap.put("sdk_level", 10058);
                    PluginHostApi.instance().statReport("rn_plugin_framework", "rn_plugin_fps", hashMap);
                } catch (Exception unused) {
                }
            }
            if (this.O0000OOo) {
                doPause();
            } else {
                this.O0000O0o.add(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass14 */

                    public final void run() {
                        PluginRNActivity.this.doPause();
                    }
                });
            }
            unregisterReceiver(this.O0000ooO);
        }

        public void onStop() {
            super.onStop();
            if (this.O0000OOo) {
                doStop();
            } else {
                this.O0000O0o.add(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass15 */

                    public final void run() {
                        PluginRNActivity.this.doStop();
                    }
                });
            }
        }

        public void doStop() {
            fwz.O000000o().O000000o(new fwy.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass16 */

                public final void onAttachPlugin(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
                    fyc.O00000Oo("rn-plugin", "doStop,onAttachPlugin");
                    ReactContext currentReactContext = reactInstanceManager != null ? reactInstanceManager.getCurrentReactContext() : null;
                    if (currentReactContext != null && currentReactContext.getCurrentActivity() != PluginRNActivity.this) {
                        fyc.O00000o0("rn-plugin", "doStop, currentActivity: " + currentReactContext.getCurrentActivity() + ", PluginRNActivity.this:" + PluginRNActivity.this + ", so just return");
                    } else if (reactInstanceManager != null && reactInstanceManager.getLifecycleState() != LifecycleState.RESUMED) {
                        fyc.O00000Oo("rn-plugin", "PluginRNActivity doOnStop  onAttachPlugin...");
                        if (currentReactContext != null) {
                            WritableMap createMap = Arguments.createMap();
                            createMap.putString("eventName", "packageWillStop_36621");
                            ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("packageWillStop_36621", createMap);
                            return;
                        }
                        fyc.O00000Oo("rn-plugin", "PluginRnActivity-->doResume-->onAttachPlugin reactContext is null...");
                    }
                }
            });
        }

        public void onNewIntent(final Intent intent) {
            super.onNewIntent(intent);
            this.O0000oo = fwz.O000000o().O00000Oo();
            gbu.O00000oo("PluginRNActivity-->onNewIntent()...");
            if (this.O0000OOo) {
                doNewIntent(intent);
            } else {
                this.O0000O0o.add(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass17 */

                    public final void run() {
                        PluginRNActivity.this.doNewIntent(intent);
                    }
                });
            }
        }

        public void startActivityForResult(Intent intent, int i, Bundle bundle) {
            if (i == -1) {
                i = 0;
            }
            super.startActivityForResult(intent, i, bundle);
        }

        public void onActivityResult(final int i, final int i2, final Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (this.O0000OOo) {
                doActivityResult(i, i2, intent);
            } else {
                this.O0000O0o.add(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass18 */

                    public final void run() {
                        PluginRNActivity.this.doActivityResult(i, i2, intent);
                    }
                });
            }
        }

        public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
            gbu.O00000oo("permissions: " + strArr + "   requestCode: " + i);
            this.mPermissionListener = permissionListener;
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(strArr, i);
            }
        }

        public void onRequestPermissionsResult(final int i, final String[] strArr, final int[] iArr) {
            gbu.O00000oo("permissions: " + strArr + "   requestCode: " + i + "  grantResults:" + iArr);
            this.O0000o0O = new Callback() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass19 */

                public final void invoke(Object... objArr) {
                    if (PluginRNActivity.this.mPermissionListener != null && PluginRNActivity.this.mPermissionListener.onRequestPermissionsResult(i, strArr, iArr)) {
                        PluginRNActivity.this.mPermissionListener = null;
                    }
                }
            };
        }

        public void onPagePause(ReactRootView reactRootView, int i) {
            FrameLayout frameLayout;
            gsy.O000000o(4, "rn-plugin", "onPagePause ".concat(String.valueOf(i)));
            if (i == 0 && this.mStateTarget == 2 && (frameLayout = this.O0000Oo0) != null) {
                frameLayout.setVisibility(8);
            }
        }

        public void onPageResume(ReactRootView reactRootView, int i) {
            FrameLayout frameLayout;
            gsy.O000000o(4, "rn-plugin", "onPageResume ".concat(String.valueOf(i)));
            if (this.O00000oo == 1) {
                if (i == 0) {
                    int i2 = this.mStateTarget;
                    if (i2 == 0) {
                        if (reactRootView != null) {
                            final View childAt = reactRootView.getChildAt(0);
                            if (childAt instanceof ReactViewGroup) {
                                ReactViewGroup reactViewGroup = (ReactViewGroup) childAt;
                                if (reactViewGroup.getChildCount() > 0) {
                                    View childAt2 = reactViewGroup.getChildAt(0);
                                    if (childAt2 instanceof ReactViewGroup) {
                                        PluginFrameLayout pluginFrameLayout = new PluginFrameLayout(this);
                                        ((ReactViewGroup) childAt2).addView(pluginFrameLayout, 0, 0);
                                        this.O0000Oo0 = pluginFrameLayout;
                                        this.mStateTarget = 1;
                                    }
                                    gsy.O00000Oo("rn-plugin", "onPageResume targetView is negivation child 2");
                                } else {
                                    reactViewGroup.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass20 */

                                        public final void onChildViewRemoved(View view, View view2) {
                                        }

                                        public final void onChildViewAdded(View view, View view2) {
                                            ((ReactViewGroup) childAt).setOnHierarchyChangeListener(null);
                                            childAt.post(new Runnable() {
                                                /* class com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity.AnonymousClass20.AnonymousClass1 */

                                                public final void run() {
                                                    if (PluginRNActivity.this.O0000Oo0 == null) {
                                                        PluginRNActivity.this.O0000Oo0 = new PluginFrameLayout(PluginRNActivity.this);
                                                    } else {
                                                        ((ViewGroup) PluginRNActivity.this.O0000Oo0.getParent()).removeView(PluginRNActivity.this.O0000Oo0);
                                                    }
                                                    ((ReactViewGroup) ((ReactViewGroup) childAt).getChildAt(0)).addView(PluginRNActivity.this.O0000Oo0, 0, 0);
                                                    PluginRNActivity.this.mStateTarget = 1;
                                                    gsy.O00000Oo("rn-plugin", "onPageResume targetView is delay negivation child 2");
                                                }
                                            });
                                        }
                                    });
                                }
                            }
                        }
                        if (this.O0000Oo0 == null) {
                            View findViewById = findViewById(16908290);
                            if (findViewById instanceof ViewGroup) {
                                PluginFrameLayout pluginFrameLayout2 = new PluginFrameLayout(this);
                                ((ViewGroup) findViewById).addView(pluginFrameLayout2, -1, -1);
                                this.O0000Oo0 = pluginFrameLayout2;
                                this.mStateTarget = 2;
                                gsy.O00000Oo("rn-plugin", "onPageResume targetView is content");
                            }
                        }
                        this.O0000oO0.showWeakRssiIfNeed(this.O0000Oo0);
                        if (this.O00000oo != 3) {
                            this.O0000oO0.showOfflineIfNeeded(this.O0000Oo0);
                            gav.O000000o(this.O00000oO);
                        }
                    } else if (i2 == 2 && (frameLayout = this.O0000Oo0) != null) {
                        frameLayout.setVisibility(0);
                    }
                } else {
                    FrameLayout frameLayout2 = this.O0000Oo0;
                    if (!(frameLayout2 == null || this.mStateTarget != 1 || frameLayout2.getParent() == null)) {
                        ViewParent parent = this.O0000Oo0.getParent().getParent();
                        if ((parent instanceof ReactViewGroup) && ((ReactViewGroup) parent).getChildCount() != i + 1) {
                            gsy.O00000Oo("rn-plugin", "onPageResume targetView attach not negivation");
                            this.mStateTarget = 2;
                            this.O0000Oo0.setVisibility(8);
                        }
                    }
                }
                this.O0000oO0.onRnPageResume(i, this.O0000Oo0);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fwz.O000000o(boolean, int):void
         arg types: [int, int]
         candidates:
          _m_j.fwz.O000000o(boolean, com.facebook.react.bridge.WritableMap):void
          _m_j.fwz.O000000o(boolean, int):void */
        public void onTrimMemory(int i) {
            super.onTrimMemory(i);
            if (i == 5 || i == 10 || i == 15) {
                sendMemoryWarningEvent(i);
                if (gbt.O00000oO()) {
                    fwz.O000000o().O000000o(true, i);
                }
            }
        }

        public static void sendMemoryWarningEvent(int i) {
            ReactContext currentReactContext;
            gbu.O00000o0("sendMemoryWarningEvent,level:".concat(String.valueOf(i)));
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("level", i);
            createMap.putString("eventName", "onMemoryWarning_36621");
            ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
            if (reactInstanceManager != null && (currentReactContext = reactInstanceManager.getCurrentReactContext()) != null) {
                gbu.O00000o0("sendMemoryWarningEvent,emit");
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onMemoryWarning_36621", createMap);
            }
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (!fwz.O000000o().O00000Oo().O0000ooo) {
                return super.onKeyDown(i, keyEvent);
            }
            if (i != 24 && i != 25) {
                return super.onKeyDown(i, keyEvent);
            }
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            int i2 = i == 24 ? 1 : -1;
            if (audioManager != null) {
                audioManager.adjustStreamVolume(3, i2, 0);
            }
            return true;
        }
    }
