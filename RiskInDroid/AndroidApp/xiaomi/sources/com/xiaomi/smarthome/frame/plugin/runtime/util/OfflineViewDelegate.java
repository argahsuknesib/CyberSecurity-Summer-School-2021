package com.xiaomi.smarthome.frame.plugin.runtime.util;

import _m_j.be;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.ffs;
import _m_j.fqy;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsp;
import _m_j.fss;
import _m_j.ftn;
import _m_j.gfr;
import _m_j.gnl;
import _m_j.gpb;
import _m_j.gpy;
import _m_j.gqb;
import _m_j.gsy;
import _m_j.hlz;
import _m_j.hvg;
import _m_j.hxc;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import _m_j.oOO0OOo0;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.device.MiTVDevice;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineViewDelegate {
    private boolean haveShown = false;
    private boolean isDestroy = true;
    public boolean isHide = false;
    private AtomicBoolean isShowAtomRec = new AtomicBoolean(false);
    public Activity mActivity;
    public ConstraintLayout mAtomRecommendedBannerView;
    private List<be<Integer, Integer>> mBleOfflineDesc = new ArrayList<be<Integer, Integer>>() {
        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass3 */

        {
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_1), -1));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_6), Integer.valueOf((int) R.string.desc_reconnect)));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_7), -1));
        }
    };
    private oOO0OOo0 mBottomSet;
    public oOO0OOo0 mCenterSet;
    private BroadcastReceiver mConnectChangedReceive = null;
    public final Context mContext;
    public DeviceStat mDevice;
    private List<be<Integer, Integer>> mElseOfflineDesc = new ArrayList<be<Integer, Integer>>() {
        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass7 */

        {
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_8), -1));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_6), Integer.valueOf((int) R.string.desc_reconnect)));
        }
    };
    private List<be<Integer, Integer>> mElseOfflineDescForBluetooh = new ArrayList<be<Integer, Integer>>() {
        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass8 */

        {
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_8), -1));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_6), Integer.valueOf((int) R.string.retry_network)));
        }
    };
    private List<be<Integer, Integer>> mIRfflineDesc = new ArrayList<be<Integer, Integer>>() {
        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass4 */

        {
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_5), -1));
        }
    };
    private boolean mIsJumpFromPlugin;
    private boolean mIsNeedOfflineView = false;
    private List<be<Integer, Integer>> mNBIotOfflineDesc = new ArrayList<be<Integer, Integer>>() {
        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass5 */

        {
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_8), -1));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_6), Integer.valueOf((int) R.string.desc_reconnect)));
        }
    };
    public TouchDelegateConstraintLayout mOfflineView;
    private ConstraintLayout mPluginRecView;
    public int mRnPageIndex = 0;
    private List<be<Integer, Integer>> mTvOfflineDesc = new ArrayList<be<Integer, Integer>>() {
        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass6 */

        {
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_9), -1));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_2), -1));
        }
    };
    private List<be<Integer, Integer>> mWifiOfflineDesc = new ArrayList<be<Integer, Integer>>() {
        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass1 */

        {
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_1), -1));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_2), -1));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_3), Integer.valueOf((int) R.string.desc_reconnect)));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_4), -1));
        }
    };
    private List<be<Integer, Integer>> mZigbeeOfflineDesc = new ArrayList<be<Integer, Integer>>() {
        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass2 */

        {
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_1), -1));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_5), -1));
            add(be.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_6), Integer.valueOf((int) R.string.desc_reconnect)));
        }
    };

    public OfflineViewDelegate(Activity activity, DeviceStat deviceStat) {
        this.mActivity = activity;
        this.mContext = this.mActivity;
        this.mDevice = deviceStat;
    }

    public void onCreate() {
        gsy.O00000Oo("OfflineViewDelegate", "onCreate: " + this.mActivity.hashCode());
        boolean z = false;
        this.isDestroy = false;
        if (!(this.mActivity.getCallingPackage() == null && this.mActivity.getCallingActivity() == null)) {
            z = true;
        }
        this.mIsJumpFromPlugin = z;
    }

    public void onDestroy() {
        gsy.O00000Oo("OfflineViewDelegate", "onDestroy: " + this.mActivity.hashCode());
        this.isDestroy = true;
        unregisterConnectChangedReceive();
    }

    public boolean isValid() {
        return (this.mDevice == null || this.mActivity == null || this.isDestroy) ? false : true;
    }

    private void registerConnectChangedReceive(final FrameLayout frameLayout) {
        if (this.mConnectChangedReceive == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.xiaomi.smarthome.bluetooth.connect_status_changed");
            this.mConnectChangedReceive = new BroadcastReceiver() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass9 */

                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals("com.xiaomi.smarthome.bluetooth.connect_status_changed", intent.getAction())) {
                        String stringExtra = intent.getStringExtra("key_device_address");
                        if (OfflineViewDelegate.this.mDevice != null && OfflineViewDelegate.this.mDevice.mac.equalsIgnoreCase(stringExtra) && intent.getIntExtra("key_connect_status", 5) == 16 && OfflineViewDelegate.this.isValid()) {
                            if (OfflineViewDelegate.this.isHide) {
                                try {
                                    if (frameLayout != null) {
                                        frameLayout.removeView(OfflineViewDelegate.this.mOfflineView);
                                    }
                                    OfflineViewDelegate.this.mOfflineView.setClickable(false);
                                    OfflineViewDelegate.this.mOfflineView.setOnClickListener(null);
                                    OfflineViewDelegate.this.mOfflineView.setDialogIsShowing(false);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                OfflineViewDelegate.this.hide(true, frameLayout);
                            }
                            OfflineViewDelegate.this.unregisterConnectChangedReceive();
                        }
                    }
                }
            };
            gnl.O000000o(this.mConnectChangedReceive, intentFilter);
        }
    }

    public void unregisterConnectChangedReceive() {
        BroadcastReceiver broadcastReceiver = this.mConnectChangedReceive;
        if (broadcastReceiver != null) {
            gnl.O000000o(broadcastReceiver);
            this.mConnectChangedReceive = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r0 = com.xiaomi.smarthome.frame.core.CoreApi.O000000o().O00000oO(r5.mDevice.model);
     */
    public void showOfflineIfNeeded(final FrameLayout frameLayout) {
        DeviceStat deviceStat;
        boolean z;
        final PluginDeviceInfo O00000oO;
        if (!this.mIsJumpFromPlugin && (deviceStat = this.mDevice) != null) {
            if (DeviceCategory.fromPid(deviceStat.pid) == DeviceCategory.Bluetooth) {
                z = gnl.O00000o0(this.mDevice.mac);
            } else {
                z = this.mDevice.isOnline;
            }
            if ((!z) && O00000oO != null && O00000oO.O00000o() != 18 && O00000oO.O0000oOo() != 2 && DeviceCategory.fromPid(this.mDevice.pid) != DeviceCategory.LocalAp && DeviceCategory.fromPid(this.mDevice.pid) != DeviceCategory.BleMesh) {
                if (DeviceCategory.fromPid(this.mDevice.pid) != DeviceCategory.Bluetooth || (O00000oO.O0000oOo() != 1 && O00000oO.O0000oOo() != 2 && ffs.O00000o0(this.mDevice.model))) {
                    this.mIsNeedOfflineView = true;
                    this.mActivity.getWindow().getDecorView().post(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass10 */

                        public void run() {
                            OfflineViewDelegate.this.show(O00000oO.O0000oOo(), frameLayout);
                        }
                    });
                }
            }
        }
    }

    public void showWeakRssiIfNeed(final FrameLayout frameLayout) {
        DeviceStat deviceStat;
        if (!this.mIsJumpFromPlugin && (deviceStat = this.mDevice) != null) {
            if (DeviceCategory.fromPid(deviceStat.pid) != DeviceCategory.Wifi) {
                if (!this.mIsNeedOfflineView) {
                    showPluginRecSceneIdNeed(frameLayout);
                }
            } else if (this.mDevice.isOnline) {
                checkDeviceRssi(this.mContext, new fsm<be<Integer, JSONObject>, fso>() {
                    /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass11 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((be<Integer, JSONObject>) ((be) obj));
                    }

                    public void onSuccess(be<Integer, JSONObject> beVar) {
                        if (beVar != null && OfflineViewDelegate.this.isValid() && beVar.f12896O000000o != null && beVar.O00000Oo != null) {
                            int intValue = ((Integer) beVar.f12896O000000o).intValue();
                            String optString = ((JSONObject) beVar.O00000Oo).optString("note");
                            if (intValue == 0) {
                                OfflineViewDelegate.this.showPluginRecSceneIdNeed(frameLayout);
                                return;
                            }
                            Context context = OfflineViewDelegate.this.mContext;
                            SharedPreferences sharedPreferences = context.getSharedPreferences("cache_rssi_showtime" + CoreApi.O000000o().O0000o0(), 0);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (sharedPreferences.getLong(OfflineViewDelegate.this.mDevice.did, 0) + 604800000 < currentTimeMillis) {
                                OfflineViewDelegate.this.addWeakRssiToActivity(frameLayout, optString, new Runnable(sharedPreferences, currentTimeMillis) {
                                    /* class com.xiaomi.smarthome.frame.plugin.runtime.util.$$Lambda$OfflineViewDelegate$11$WEG9d7voOrD98du1dX1y8RXIM3U */
                                    private final /* synthetic */ SharedPreferences f$1;
                                    private final /* synthetic */ long f$2;

                                    {
                                        this.f$1 = r2;
                                        this.f$2 = r3;
                                    }

                                    public final void run() {
                                        OfflineViewDelegate.AnonymousClass11.this.lambda$onSuccess$0$OfflineViewDelegate$11(this.f$1, this.f$2);
                                    }
                                });
                            }
                        }
                    }

                    public /* synthetic */ void lambda$onSuccess$0$OfflineViewDelegate$11(SharedPreferences sharedPreferences, long j) {
                        sharedPreferences.edit().putLong(OfflineViewDelegate.this.mDevice.did, j).apply();
                    }

                    public void onFailure(fso fso) {
                        if (OfflineViewDelegate.this.isValid()) {
                            if (gfr.f17662O000000o) {
                                gsy.O00000Oo("OfflineViewDelegate", "onFailure: " + fso.O00000Oo);
                            }
                            OfflineViewDelegate.this.showPluginRecSceneIdNeed(frameLayout);
                        }
                    }
                }, this.mDevice.did, 2);
            }
        }
    }

    public void showPluginRecSceneIdNeed(FrameLayout frameLayout) {
        showAtomRecommendIfNeeded(frameLayout);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.FrameLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View addWeakRssiToActivity(final FrameLayout frameLayout, String str, final Runnable runnable) {
        if (TextUtils.isEmpty(str) || frameLayout == null || this.mActivity.isFinishing() || this.mActivity.isDestroyed()) {
            return null;
        }
        final View inflate = LayoutInflater.from(this.mActivity.getApplicationContext()).inflate((int) R.layout.plugin_weak_rssi_view, (ViewGroup) frameLayout, false);
        ((FrameLayout.LayoutParams) inflate.getLayoutParams()).topMargin = (int) ((this.mContext.getResources().getDisplayMetrics().density * 94.0f) + 0.5f);
        frameLayout.addView(inflate);
        ((TextView) inflate.findViewById(R.id.rssi_title)).setText(str);
        TextView textView = (TextView) inflate.findViewById(R.id.rssi_details);
        textView.getPaint().setFlags(8);
        textView.getPaint().setAntiAlias(true);
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass12 */

            public void onClick(View view) {
                fsp.O000000o().O0000Oo.openNetworkInfoActivity(OfflineViewDelegate.this.mActivity, OfflineViewDelegate.this.mDevice.did);
            }
        });
        inflate.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass13 */

            public void onClick(View view) {
                frameLayout.removeView(inflate);
                runnable.run();
            }
        });
        frameLayout.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass14 */

            public void run() {
                if (OfflineViewDelegate.this.isValid()) {
                    inflate.setVisibility(0);
                }
            }
        }, 1500);
        return inflate;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.FrameLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void show(int i, FrameLayout frameLayout) {
        int i2 = i;
        final FrameLayout frameLayout2 = frameLayout;
        if (isValid() && !this.haveShown) {
            this.haveShown = true;
            if (frameLayout2 != null) {
                try {
                    this.mOfflineView = (TouchDelegateConstraintLayout) LayoutInflater.from(this.mContext.getApplicationContext()).inflate((int) R.layout.plugin_offline_view, (ViewGroup) frameLayout2, false);
                    frameLayout2.addView(this.mOfflineView);
                    final SimpleDraweeView simpleDraweeView = (SimpleDraweeView) this.mOfflineView.findViewById(R.id.device_icon);
                    TextView textView = (TextView) this.mOfflineView.findViewById(R.id.offline_desc);
                    TextView textView2 = (TextView) this.mOfflineView.findViewById(R.id.offline_reason);
                    TextView textView3 = (TextView) this.mOfflineView.findViewById(R.id.more_reason);
                    View findViewById = this.mOfflineView.findViewById(R.id.close);
                    TextView textView4 = (TextView) this.mOfflineView.findViewById(R.id.back);
                    this.mBottomSet = new oOO0OOo0();
                    this.mBottomSet.O00000Oo(this.mOfflineView);
                    this.mCenterSet = new oOO0OOo0();
                    oOO0OOo0 ooo0ooo0 = this.mCenterSet;
                    oOO0OOo0 ooo0ooo02 = this.mBottomSet;
                    ooo0ooo0.O00000o.clear();
                    for (Integer next : ooo0ooo02.O00000o.keySet()) {
                        ooo0ooo0.O00000o.put(next, ooo0ooo02.O00000o.get(next).clone());
                    }
                    oOO0OOo0 ooo0ooo03 = this.mCenterSet;
                    oOO0OOo0 ooo0ooo04 = ooo0ooo03;
                    ooo0ooo04.O000000o(R.id.float_main, 3, 0, 3, 0);
                    ooo0ooo04.O000000o(R.id.float_main, 4, 0, 4, 0);
                    ooo0ooo03.O00000o.get(Integer.valueOf((int) R.id.float_main)).O00000o.O0000oo0 = 0.5f;
                    this.mOfflineView.findViewById(R.id.float_main).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass15 */

                        public void onClick(View view) {
                        }
                    });
                    final boolean z = i2 == 1 || i2 == 2;
                    gsy.O00000Oo("OfflineViewDelegate", "show: canUserOperate: ".concat(String.valueOf(z)));
                    this.mOfflineView.setClickable(true);
                    this.mOfflineView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass16 */

                        public void onClick(View view) {
                            OfflineViewDelegate.this.hide(z, frameLayout2);
                        }
                    });
                    Locale O00000o0 = ftn.O00000o0(this.mContext);
                    gqb.O000000o(this.mActivity, O00000o0, (int) R.string.device_is_offline, textView);
                    gqb.O000000o(this.mActivity, O00000o0, (int) R.string.action_back_main, textView4);
                    setOfflineReasonByDeviceType(textView2);
                    String O000000o2 = gqb.O000000o(this.mActivity, O00000o0, (int) R.string.more_offline_reason);
                    SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(O000000o2);
                    valueOf.setSpan(new UnderlineSpan(), 0, O000000o2.length(), 33);
                    textView3.setHighlightColor(0);
                    textView3.setTextColor(-10066330);
                    textView3.setText(valueOf);
                    textView3.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass17 */

                        public void onClick(View view) {
                            String str;
                            Intent intent = new Intent();
                            hvg.O000000o(OfflineViewDelegate.this.mContext).O000000o(OfflineViewDelegate.this.mDevice.model);
                            hxc.O000000o().O000000o(OfflineViewDelegate.this.mDevice.model, 9);
                            intent.setClassName(OfflineViewDelegate.this.mActivity.getPackageName(), "com.xiaomi.smarthome.miio.activity.DeviceOfflineDetailActivity");
                            intent.putExtra("extra_model", OfflineViewDelegate.this.mDevice.model);
                            intent.putExtra("did", OfflineViewDelegate.this.mDevice.did);
                            fqy.O000000o(intent, 9);
                            if (gpb.O000000o(OfflineViewDelegate.this.mDevice.model) == MiTVDevice.class) {
                                str = "TV_etc";
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append(OfflineViewDelegate.this.mDevice.pid);
                                str = sb.toString();
                            }
                            intent.putExtra("arg_device_type", str);
                            intent.addFlags(268435456);
                            Intent intent2 = OfflineViewDelegate.this.mActivity.getIntent();
                            if (intent2 != null) {
                                intent.putExtras(intent2.getExtras());
                            }
                            OfflineViewDelegate.this.mContext.startActivity(intent);
                        }
                    });
                    findViewById.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass18 */

                        public void onClick(View view) {
                            OfflineViewDelegate.this.hide(z, frameLayout2);
                        }
                    });
                    textView4.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass19 */

                        public void onClick(View view) {
                            fbt fbt = new fbt(OfflineViewDelegate.this.mActivity, "SmartHomeMainActivity");
                            fbt.O00000Oo(603979776);
                            fbs.O000000o(fbt);
                            OfflineViewDelegate.this.mActivity.finish();
                        }
                    });
                    if (!TextUtils.isEmpty(this.mDevice.model)) {
                        hlz.O000000o(this.mDevice.model, new fsm<hlz.O000000o, fso>() {
                            /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass20 */

                            public void onSuccess(hlz.O000000o o000000o) {
                                if (OfflineViewDelegate.this.isValid()) {
                                    if (!TextUtils.isEmpty(o000000o.f19057O000000o)) {
                                        simpleDraweeView.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(o000000o.f19057O000000o).setAutoPlayAnimations(true)).build());
                                        return;
                                    }
                                    OfflineViewDelegate.setIconByUrl(OfflineViewDelegate.this.mDevice.model, simpleDraweeView, 0);
                                }
                            }

                            public void onFailure(fso fso) {
                                if (OfflineViewDelegate.this.isValid()) {
                                    OfflineViewDelegate.setIconByUrl(OfflineViewDelegate.this.mDevice.model, simpleDraweeView, 0);
                                }
                            }
                        });
                    }
                    final TextView textView5 = (TextView) this.mOfflineView.findViewById(R.id.offline_rssi);
                    textView5.setVisibility(8);
                    if (DeviceCategory.fromPid(this.mDevice.pid) == DeviceCategory.Wifi) {
                        System.currentTimeMillis();
                        checkDeviceRssi(this.mContext, new fsm<be<Integer, JSONObject>, fso>() {
                            /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass21 */

                            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                onSuccess((be<Integer, JSONObject>) ((be) obj));
                            }

                            public void onSuccess(be<Integer, JSONObject> beVar) {
                                if (beVar != null && OfflineViewDelegate.this.isValid() && beVar.f12896O000000o != null && beVar.O00000Oo != null) {
                                    int intValue = ((Integer) beVar.f12896O000000o).intValue();
                                    final String optString = ((JSONObject) beVar.O00000Oo).optString("note");
                                    if (intValue != 0 && !TextUtils.isEmpty(optString)) {
                                        textView5.setVisibility(0);
                                        textView5.setText(gqb.O000000o(OfflineViewDelegate.this.mActivity, ftn.O00000o0(OfflineViewDelegate.this.mContext), (int) R.string.device_rssi_check));
                                        textView5.postDelayed(new Runnable() {
                                            /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass21.AnonymousClass1 */

                                            public void run() {
                                                if (OfflineViewDelegate.this.isValid()) {
                                                    textView5.setText(optString);
                                                }
                                            }
                                        }, 1500);
                                    }
                                }
                            }

                            public void onFailure(fso fso) {
                                if (OfflineViewDelegate.this.isValid() && gfr.f17662O000000o) {
                                    gsy.O00000Oo("OfflineViewDelegate", "onFailure: " + fso.O00000Oo);
                                }
                            }
                        }, this.mDevice.did, 0);
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.mActivity.getWindow().getDecorView().postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass22 */

                            public void run() {
                                AutoTransition autoTransition = new AutoTransition();
                                autoTransition.setInterpolator((TimeInterpolator) new DecelerateInterpolator());
                                autoTransition.setDuration(320L);
                                TransitionManager.beginDelayedTransition(frameLayout2, autoTransition);
                                OfflineViewDelegate.this.mCenterSet.O00000o0(OfflineViewDelegate.this.mOfflineView);
                            }
                        }, 200);
                    } else {
                        this.mCenterSet.O00000o0(this.mOfflineView);
                    }
                    registerConnectChangedReceive(frameLayout2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setOfflineReasonByDeviceType(final TextView textView) {
        List<be<Integer, Integer>> list;
        if (gpb.O000000o(this.mDevice.model) == MiTVDevice.class) {
            list = this.mTvOfflineDesc;
        } else {
            int i = AnonymousClass28.$SwitchMap$com$xiaomi$smarthome$frame$plugin$runtime$util$DeviceCategory[DeviceCategory.fromPid(this.mDevice.pid).ordinal()];
            if (i == 1) {
                list = this.mWifiOfflineDesc;
            } else if (i == 2) {
                list = this.mZigbeeOfflineDesc;
            } else if (i == 3) {
                list = this.mBleOfflineDesc;
            } else if (i == 4) {
                list = this.mIRfflineDesc;
            } else if (i == 5) {
                list = this.mNBIotOfflineDesc;
            } else if (DeviceCategory.fromPid(this.mDevice.pid) == DeviceCategory.Bluetooth) {
                list = this.mElseOfflineDescForBluetooh;
            } else {
                list = this.mElseOfflineDesc;
            }
        }
        Locale O00000o0 = ftn.O00000o0(this.mContext);
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf("");
        if (list.size() == 1) {
            valueOf.append((CharSequence) gqb.O000000o(this.mActivity, O00000o0, ((Integer) ((be) list.get(0)).f12896O000000o).intValue()));
            textView.setTextAlignment(4);
            textView.setGravity(17);
        } else {
            int i2 = 0;
            while (i2 < list.size()) {
                be beVar = (be) list.get(i2);
                int i3 = i2 + 1;
                valueOf.append((CharSequence) String.valueOf(i3)).append((CharSequence) ".");
                String O000000o2 = gqb.O000000o(this.mActivity, ftn.O00000o0(this.mContext), ((Integer) beVar.f12896O000000o).intValue());
                if (-1 == ((Integer) beVar.O00000Oo).intValue()) {
                    valueOf.append((CharSequence) O000000o2);
                } else {
                    String O000000o3 = gqb.O000000o(this.mActivity, ftn.O00000o0(this.mContext), ((Integer) beVar.O00000Oo).intValue());
                    String format = String.format(O000000o2, O000000o3);
                    AnonymousClass23 r8 = new ClickableSpan() {
                        /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass23 */

                        public void onClick(View view) {
                            if (DeviceCategory.fromPid(OfflineViewDelegate.this.mDevice.pid) == DeviceCategory.Bluetooth) {
                                XmPluginHostApi.instance().visualSecureBind(OfflineViewDelegate.this.mDevice.did);
                                if (OfflineViewDelegate.this.mActivity != null) {
                                    OfflineViewDelegate.this.mActivity.finish();
                                    return;
                                }
                                return;
                            }
                            hvg.O000000o(OfflineViewDelegate.this.mContext).O000000o(OfflineViewDelegate.this.mDevice.model);
                            Intent intent = new Intent();
                            hxc.O000000o().O000000o(OfflineViewDelegate.this.mDevice.model, 9);
                            intent.setClassName(OfflineViewDelegate.this.mActivity.getPackageName(), "com.xiaomi.smarthome.device.choosedevice.ResetPageRoute");
                            intent.putExtra("extra_model", OfflineViewDelegate.this.mDevice.model);
                            fqy.O000000o(intent, 9);
                            intent.addFlags(268435456);
                            OfflineViewDelegate.this.mContext.startActivity(intent);
                        }

                        public void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(textView.getResources().getColor(R.color.mj_color_green_normal));
                        }
                    };
                    valueOf.append((CharSequence) format);
                    int indexOf = valueOf.toString().indexOf(O000000o3);
                    valueOf.setSpan(r8, indexOf, O000000o3.length() + indexOf, 33);
                }
                if (i2 != list.size() - 1) {
                    valueOf.append((CharSequence) "\n");
                }
                i2 = i3;
            }
        }
        textView.setHighlightColor(0);
        textView.setText(valueOf);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* renamed from: com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate$28  reason: invalid class name */
    static /* synthetic */ class AnonymousClass28 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$smarthome$frame$plugin$runtime$util$DeviceCategory = new int[DeviceCategory.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$xiaomi$smarthome$frame$plugin$runtime$util$DeviceCategory[DeviceCategory.Wifi.ordinal()] = 1;
            $SwitchMap$com$xiaomi$smarthome$frame$plugin$runtime$util$DeviceCategory[DeviceCategory.SubDevice.ordinal()] = 2;
            $SwitchMap$com$xiaomi$smarthome$frame$plugin$runtime$util$DeviceCategory[DeviceCategory.BleMesh.ordinal()] = 3;
            $SwitchMap$com$xiaomi$smarthome$frame$plugin$runtime$util$DeviceCategory[DeviceCategory.IR.ordinal()] = 4;
            $SwitchMap$com$xiaomi$smarthome$frame$plugin$runtime$util$DeviceCategory[DeviceCategory.NBIOT.ordinal()] = 5;
        }
    }

    public void hide(final boolean z, final FrameLayout frameLayout) {
        if (!this.isHide && frameLayout != null) {
            this.isHide = true;
            if (Build.VERSION.SDK_INT >= 19) {
                AutoTransition autoTransition = new AutoTransition();
                autoTransition.setInterpolator((TimeInterpolator) new AccelerateInterpolator());
                autoTransition.setDuration(300L);
                autoTransition.addListener((Transition.TransitionListener) new Transition.TransitionListener() {
                    /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass24 */

                    public void onTransitionCancel(Transition transition) {
                    }

                    public void onTransitionPause(Transition transition) {
                    }

                    public void onTransitionResume(Transition transition) {
                    }

                    public void onTransitionStart(Transition transition) {
                    }

                    public void onTransitionEnd(Transition transition) {
                        if (z) {
                            frameLayout.removeView(OfflineViewDelegate.this.mOfflineView);
                        }
                    }
                });
                TransitionManager.beginDelayedTransition(frameLayout, autoTransition);
                this.mBottomSet.O00000o0(this.mOfflineView);
            } else {
                this.mBottomSet.O00000o0(this.mOfflineView);
                if (z) {
                    frameLayout.removeView(this.mOfflineView);
                }
            }
            this.mOfflineView.setClickable(false);
            this.mOfflineView.setOnClickListener(null);
            this.mOfflineView.setDialogIsShowing(false);
            showAtomRecommendIfNeeded(frameLayout);
        }
    }

    public void deviceStatusOnline(FrameLayout frameLayout) {
        if (isValid() && this.haveShown) {
            this.mActivity.runOnUiThread(new Runnable(frameLayout) {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.util.$$Lambda$OfflineViewDelegate$ujiHeMq8cMK6P8mjppbRcm1zCsA */
                private final /* synthetic */ FrameLayout f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    OfflineViewDelegate.this.lambda$deviceStatusOnline$0$OfflineViewDelegate(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$deviceStatusOnline$0$OfflineViewDelegate(FrameLayout frameLayout) {
        hide(true, frameLayout);
    }

    public static void setIconByUrl(String str, SimpleDraweeView simpleDraweeView, int i) {
        if (i == 0) {
            i = R.drawable.device_list_phone_no;
        }
        final String pluginIcon = getPluginIcon(str);
        if (simpleDraweeView.getHierarchy() == null) {
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(i)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        }
        if (TextUtils.isEmpty(pluginIcon) || !pluginIcon.startsWith("http")) {
            int resource = ClientIconMap.getResource(str);
            if (resource != 0) {
                simpleDraweeView.setImageURI(getResoursUri(resource));
            } else {
                simpleDraweeView.setImageURI(getResoursUri(i));
            }
        } else {
            simpleDraweeView.setImageURI(Uri.parse(pluginIcon));
            DraweeController controller = simpleDraweeView.getController();
            if (controller != null && (controller instanceof AbstractDraweeController)) {
                ((AbstractDraweeController) controller).addControllerListener(new BaseControllerListener() {
                    /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass25 */

                    public final void onFailure(String str, Throwable th) {
                        gsy.O000000o(6, "Failure", str + " decode failed");
                        Fresco.getImagePipeline().evictFromMemoryCache(Uri.parse(pluginIcon));
                        Fresco.getImagePipeline().evictFromDiskCache(Uri.parse(pluginIcon));
                    }
                });
            }
        }
    }

    public static Uri getResoursUri(int i) {
        return Uri.parse("res://" + gfr.O0000O0o + "/" + i);
    }

    public static String getPluginIcon(String str) {
        PluginDeviceInfo O00000oO;
        if (str == null || !CoreApi.O000000o().O00000o(str) || (O00000oO = CoreApi.O000000o().O00000oO(str)) == null) {
            return null;
        }
        return O00000oO.O0000o0();
    }

    public static void checkDeviceRssi(Context context, fsm<be<Integer, JSONObject>, fso> fsm, final String str, int i) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONObject.put("dids", jSONArray);
            jSONObject.put("type", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/device/devicerssi").O000000o(arrayList).O000000o(), new fss<be<Integer, JSONObject>>() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass26 */

            public final be<Integer, JSONObject> parse(JSONObject jSONObject) throws JSONException {
                gsy.O00000Oo("OfflineViewDelegate", jSONObject.toString());
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject(str);
                    return be.O000000o(Integer.valueOf(optJSONObject.getInt("net_stat")), optJSONObject);
                } catch (Exception unused) {
                    return null;
                }
            }
        }, Crypto.RC4, fsm);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    private void showAtomRecommendIfNeeded(final ViewGroup viewGroup) {
        Context context = this.mContext;
        if (!gpy.O00000o0(context, "ATOM_RECOMMEND_NAME" + CoreApi.O000000o().O0000o0(), this.mDevice.model, false) && viewGroup != null && this.isShowAtomRec.compareAndSet(false, true) && !ftn.O00000oO(this.mActivity)) {
            getAtomRecommendResponse(this.mActivity, new fsm<be<String, String>, fso>() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass27 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((be<String, String>) ((be) obj));
                }

                public void onSuccess(be<String, String> beVar) {
                    if (beVar != null) {
                        final String str = (String) beVar.f12896O000000o;
                        final String str2 = (String) beVar.O00000Oo;
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            OfflineViewDelegate.this.mActivity.runOnUiThread(new Runnable() {
                                /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass27.AnonymousClass1 */

                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                 method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
                                 arg types: [?, android.view.ViewGroup, int]
                                 candidates:
                                  ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
                                  ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
                                public void run() {
                                    if (OfflineViewDelegate.this.mRnPageIndex == 0) {
                                        hxp hxp = hxi.O00000o0;
                                        String str = OfflineViewDelegate.this.mDevice.model;
                                        String str2 = OfflineViewDelegate.this.mDevice.did;
                                        String O0000o0 = CoreApi.O000000o().O0000o0();
                                        hxp.f957O000000o.O000000o("ad_light_plugin", "model", str, "did", str2, "uid", O0000o0);
                                        OfflineViewDelegate.this.mAtomRecommendedBannerView = (ConstraintLayout) LayoutInflater.from(OfflineViewDelegate.this.mContext).inflate((int) R.layout.plugin_rec_scene_entrance, viewGroup, false);
                                        ((FrameLayout.LayoutParams) OfflineViewDelegate.this.mAtomRecommendedBannerView.getLayoutParams()).topMargin = (int) ((OfflineViewDelegate.this.mContext.getResources().getDisplayMetrics().density * 94.0f) + 0.5f);
                                        OfflineViewDelegate.this.mAtomRecommendedBannerView.setVisibility(0);
                                        viewGroup.addView(OfflineViewDelegate.this.mAtomRecommendedBannerView);
                                        ((TextView) OfflineViewDelegate.this.mAtomRecommendedBannerView.findViewById(R.id.tv_entrance_title)).setText(str);
                                        OfflineViewDelegate.this.mAtomRecommendedBannerView.setOnClickListener(new View.OnClickListener() {
                                            /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass27.AnonymousClass1.AnonymousClass1 */

                                            public void onClick(View view) {
                                                fsp.O000000o().O0000Oo.loadUrl(str2, "", false);
                                                hxk hxk = hxi.O00000o;
                                                String str = OfflineViewDelegate.this.mDevice.model;
                                                String str2 = OfflineViewDelegate.this.mDevice.did;
                                                String O0000o0 = CoreApi.O000000o().O0000o0();
                                                hxk.f952O000000o.O000000o("ad_light_plugin", "model", str, "did", str2, "uid", O0000o0);
                                            }
                                        });
                                        OfflineViewDelegate.this.mAtomRecommendedBannerView.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                                            /* class com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate.AnonymousClass27.AnonymousClass1.AnonymousClass2 */

                                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                             method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
                                             arg types: [android.content.Context, java.lang.String, java.lang.String, int]
                                             candidates:
                                              _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
                                              _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
                                              _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
                                              _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
                                              _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
                                            public void onClick(View view) {
                                                hxk hxk = hxi.O00000o;
                                                String str = OfflineViewDelegate.this.mDevice.model;
                                                String str2 = OfflineViewDelegate.this.mDevice.did;
                                                String O0000o0 = CoreApi.O000000o().O0000o0();
                                                hxk.f952O000000o.O000000o("ad_light_close", "model", str, "did", str2, "uid", O0000o0);
                                                Context context = OfflineViewDelegate.this.mContext;
                                                gpy.O000000o(context, "ATOM_RECOMMEND_NAME" + CoreApi.O000000o().O0000o0(), OfflineViewDelegate.this.mDevice.model, true);
                                                viewGroup.removeView(OfflineViewDelegate.this.mAtomRecommendedBannerView);
                                            }
                                        });
                                    }
                                }
                            });
                        }
                    }
                }

                public void onFailure(fso fso) {
                    gsy.O000000o(3, "OfflineViewDelegate", "showAtomRecIfNeeded onFailure: ".concat(String.valueOf(fso)));
                }
            }, this.mDevice.model);
        }
    }

    public static void getAtomRecommendResponse(Context context, fsm<be<String, String>, fso> fsm, String str) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/device/get_atom_rec").O000000o(arrayList).O000000o(), $$Lambda$OfflineViewDelegate$JeDSgeCUroQVBhm6puByX_iLmQ.INSTANCE, Crypto.RC4, fsm);
    }

    static /* synthetic */ be lambda$getAtomRecommendResponse$1(JSONObject jSONObject) throws JSONException {
        try {
            gsy.O00000Oo("OfflineViewDelegate", "getAtomRec: " + jSONObject.toString());
            boolean optBoolean = jSONObject.optBoolean("support");
            String optString = jSONObject.optString("note");
            String optString2 = jSONObject.optString("link");
            if (optBoolean) {
                return be.O000000o(optString, optString2);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void onRnPageResume(int i, FrameLayout frameLayout) {
        this.mRnPageIndex = i;
        if (this.mAtomRecommendedBannerView != null && frameLayout != null && isValid()) {
            if (i == 0 && this.mAtomRecommendedBannerView.getParent() == null) {
                frameLayout.addView(this.mAtomRecommendedBannerView);
            } else if (i > 0) {
                frameLayout.removeView(this.mAtomRecommendedBannerView);
            }
        }
    }
}
