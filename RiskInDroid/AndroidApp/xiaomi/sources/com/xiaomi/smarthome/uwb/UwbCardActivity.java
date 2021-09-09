package com.xiaomi.smarthome.uwb;

import _m_j.dcp;
import _m_j.exu;
import _m_j.frb;
import _m_j.fso;
import _m_j.ggb;
import _m_j.ggw;
import _m_j.goq;
import _m_j.gpc;
import _m_j.hbz;
import _m_j.hcc;
import _m_j.hcc.O000000o;
import _m_j.hcf;
import _m_j.hch;
import _m_j.hcz;
import _m_j.hdg;
import _m_j.heh;
import _m_j.hey;
import _m_j.hfa;
import _m_j.hzf;
import _m_j.hzq;
import _m_j.hzu;
import _m_j.itz;
import _m_j.iua;
import _m_j.ixc;
import _m_j.ixe;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.ProgressCallback;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.miui10.MIUI10CardActivity;
import com.xiaomi.smarthome.newui.card.BaseCardRender;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.ui.UwbBaseCallback;
import com.xiaomi.smarthome.uwb.lib.ui.UwbBaseHelper;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.ui.widget.CardLoadingDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 <*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00040\u0005*\u0004\b\u0002\u0010\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00062\u00020\u0007:\u0001<B\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\"H\u0014J\u001a\u0010#\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0012\u0010*\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020\u001eH\u0016J\u0012\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020\u001eH\u0014J\b\u00101\u001a\u00020&H\u0016J\b\u00102\u001a\u00020\u001eH\u0002J$\u00103\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00162\u0006\u00104\u001a\u000205H\u0014J&\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u000108H\u0014R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/xiaomi/smarthome/uwb/UwbCardActivity;", "C", "Lcom/xiaomi/smarthome/newui/card/Card;", "E", "T", "Lcom/xiaomi/smarthome/newui/card/Card$CardType;", "Lcom/xiaomi/smarthome/miui10/MIUI10CardActivity;", "Lcom/xiaomi/smarthome/uwb/lib/ui/UwbBaseCallback;", "()V", "flRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "getFlRoot", "()Landroid/widget/FrameLayout;", "flRoot$delegate", "Lkotlin/Lazy;", "mLoadingDialog", "Lcom/xiaomi/smarthome/uwb/ui/widget/CardLoadingDialog;", "getMLoadingDialog", "()Lcom/xiaomi/smarthome/uwb/ui/widget/CardLoadingDialog;", "mLoadingDialog$delegate", "render", "Lcom/xiaomi/smarthome/newui/card/BaseCardRenderWrapper;", "requestSender", "Lcom/xiaomi/smarthome/uwb/UwbRequestRender;", "uwbBaseHelper", "Lcom/xiaomi/smarthome/uwb/lib/ui/UwbBaseHelper;", "createDevicePropSubscriber", "Lcom/xiaomi/smarthome/devicesubscribe/BaseDevicePropSubscriber;", "downSpecUrns", "", "uwbDevice", "Lcom/xiaomi/smarthome/uwb/UwbDevice;", "getCancelListener", "Landroid/view/View$OnClickListener;", "getRequestSender", "Lcom/xiaomi/smarthome/newui/card/RequestSender;", "isPlugin", "", "matchCard", "intent", "Landroid/content/Intent;", "matchCardCheckSpec", "needExitUwb", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "retryNetwork", "setNavigationColor", "showCard", "creator", "Lcom/xiaomi/smarthome/newui/card/CardRenderFactory$CardItemCreater;", "showToast", "profile", "", "fail", "Lcom/xiaomi/smarthome/frame/Error;", "specError", "Companion", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbCardActivity<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends MIUI10CardActivity<C, E, T> implements UwbBaseCallback {
    public static final Companion Companion = new Companion(null);
    private final itz flRoot$delegate = iua.O000000o(new UwbCardActivity$flRoot$2(this));
    private final itz mLoadingDialog$delegate = iua.O000000o(new UwbCardActivity$mLoadingDialog$2(this));
    private hbz<C, E, T> render;
    private final UwbRequestRender<C, E, T> requestSender = new UwbRequestRender<>();
    private final UwbBaseHelper uwbBaseHelper = new UwbBaseHelper();

    /* access modifiers changed from: private */
    /* renamed from: getCancelListener$lambda-3  reason: not valid java name */
    public static final void m490getCancelListener$lambda3(View view) {
    }

    public final void _$_clearFindViewByIdCache() {
    }

    public final View.OnClickListener getCancelListener() {
        return $$Lambda$UwbCardActivity$a5QGpWHP036C3mt20ZQFNQfKU.INSTANCE;
    }

    public final boolean isPlugin() {
        return false;
    }

    public final boolean needExitUwb() {
        return true;
    }

    private final FrameLayout getFlRoot() {
        return (FrameLayout) this.flRoot$delegate.O000000o();
    }

    private final CardLoadingDialog getMLoadingDialog() {
        return (CardLoadingDialog) this.mLoadingDialog$delegate.O000000o();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/uwb/UwbCardActivity$Companion;", "", "()V", "TAG", "", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(ixc ixc) {
            this();
        }

        private Companion() {
        }
    }

    public final void onCreate(Bundle bundle) {
        setNavigationColor();
        getWindow().addFlags(524288);
        this.requestSender.onCreate();
        super.onCreate(bundle);
        this.uwbBaseHelper.onCreate(this, this);
        getMLoadingDialog().show();
        UwbLogUtil.d("Mijia-UWB-UwbCardActivityTag", "onCreate");
        dcp.O000000o().O00000Oo(true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hzq.O000000o(com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice, boolean):java.lang.String
     arg types: [com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice, int]
     candidates:
      _m_j.hzq.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>):void
      _m_j.hzq.O000000o(java.lang.String, java.lang.String):boolean
      _m_j.hzq.O000000o(com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice, boolean):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void matchCard(Intent intent) {
        UwbDevice uwbDevice;
        Device device;
        UwbScanDevice uwbScanDevice;
        UwbScanDevice uwbScanDevice2;
        getFlRoot().setVisibility(4);
        UwbScanDevice uwbScanDevice3 = null;
        this.uwbBaseHelper.startShowAni(getWindow().getDecorView(), null, getFlRoot());
        if (intent == null) {
            uwbDevice = null;
        } else {
            uwbDevice = (UwbDevice) intent.getParcelableExtra("uwb_scan_device");
        }
        this.mDevice = uwbDevice;
        if (uwbDevice == null) {
            device = null;
        } else {
            device = uwbDevice.getBaseDevice();
        }
        if (device == null) {
            if (uwbDevice == null) {
                uwbScanDevice = null;
            } else {
                uwbScanDevice = uwbDevice.getUwbDevice();
            }
            if (hzu.O00000o0(uwbScanDevice)) {
                downSpecUrns(uwbDevice);
                return;
            }
            if (uwbDevice == null) {
                uwbScanDevice2 = null;
            } else {
                uwbScanDevice2 = uwbDevice.getUwbDevice();
            }
            String O000000o2 = hzq.O000000o(uwbScanDevice2, true);
            if (ggb.O00000Oo().O0000Oo(O000000o2).isEmpty()) {
                UwbLogUtil.d("Mijia-UWB-UwbCardActivityTag", ixe.O000000o("getDeviceByHomeId isEmpty ", (Object) O000000o2));
                ggw O000000o3 = ggw.O000000o();
                ixe.O00000Oo(O000000o2, "homeId");
                O000000o3.O000000o(Long.parseLong(O000000o2), new UwbCardActivity$matchCard$1(uwbDevice, this));
                return;
            }
            if (uwbDevice != null) {
                uwbScanDevice3 = uwbDevice.getUwbDevice();
            }
            Device O000000o4 = hzq.O000000o(uwbScanDevice3);
            if (uwbDevice != null) {
                uwbDevice.attachBaseDevice(O000000o4);
            }
            UwbLogUtil.d("Mijia-UWB-UwbCardActivityTag", "UWBPERFORMANCE-8-mijia-card-complete  " + System.currentTimeMillis() + " getDeviceByHomeId  " + O000000o4);
            super.matchCard(intent);
            return;
        }
        UwbLogUtil.d("Mijia-UWB-UwbCardActivityTag", "UWBPERFORMANCE-8-mijia-card-complete  " + System.currentTimeMillis() + " ownerDevice");
        super.matchCard(intent);
    }

    public final void downSpecUrns(UwbDevice uwbDevice) {
        UwbScanDevice uwbScanDevice = null;
        String str = uwbDevice == null ? null : uwbDevice.model;
        StringBuilder sb = new StringBuilder("handleIotMemberKeyRetrieve：there is no home for ");
        sb.append((Object) UwbDeviceUtil.getDeviceAccountId(uwbDevice == null ? null : uwbDevice.getUwbDevice()));
        sb.append(' ');
        if (uwbDevice != null) {
            uwbScanDevice = uwbDevice.getUwbDevice();
        }
        sb.append(uwbScanDevice);
        UwbLogUtil.d("Mijia-UWB-UwbCardActivityTag", sb.toString());
        exu.O000000o o000000o = exu.f15933O000000o;
        exu O000000o2 = exu.O000000o.O000000o();
        Context appContext = CommonApplication.getAppContext();
        ixe.O00000Oo(appContext, "getAppContext()");
        ProgressCallback uwbCardActivity$downSpecUrns$1 = new UwbCardActivity$downSpecUrns$1(this, str, uwbDevice);
        ixe.O00000o(appContext, "c");
        ixe.O00000o("http://miot-spec.org/miot-spec-v2/instances?status=released", "url");
        ixe.O00000o(uwbCardActivity$downSpecUrns$1, "callback");
        O000000o2.O000000o(new File(appContext.getExternalCacheDir() + ((Object) File.separator) + "app_download" + ((Object) File.separator) + "http://miot-spec.org/miot-spec-v2/instances?status=released".hashCode()), "http://miot-spec.org/miot-spec-v2/instances?status=released", uwbCardActivity$downSpecUrns$1);
    }

    private final void setNavigationColor() {
        if (Build.VERSION.SDK_INT >= 26) {
            getWindow().setNavigationBarColor(getResources().getColor(17170444));
            getWindow().getDecorView().setSystemUiVisibility(-8215);
        }
    }

    public final void matchCardCheckSpec(UwbDevice uwbDevice) {
        String O000000o2 = hfa.O000000o((Device) uwbDevice);
        SpecDevice O00000o0 = hcz.getInstance().getSpecCache().O00000o0(O000000o2);
        UwbLogUtil.e("Mijia-UWB-UwbCardActivityTag", "matchCardCheckSpec onSuccess match " + uwbDevice + ' ' + O00000o0);
        if (O00000o0 == null) {
            goq.O00000oO(new Runnable(Collections.singleton(O000000o2), this, O000000o2, uwbDevice) {
                /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbCardActivity$v3cNhHkxZqUk0HZjFLHqwCB88E */
                private final /* synthetic */ Set f$0;
                private final /* synthetic */ UwbCardActivity f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ UwbDevice f$3;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    UwbCardActivity.m494matchCardCheckSpec$lambda1(this.f$0, this.f$1, this.f$2, this.f$3);
                }
            });
        } else {
            runOnUiThread(new Runnable(this) {
                /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbCardActivity$YsQU9yL1eLq0R_MpvqebsSzqUQ */
                private final /* synthetic */ UwbCardActivity f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    UwbCardActivity.m496matchCardCheckSpec$lambda2(UwbDevice.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: matchCardCheckSpec$lambda-1  reason: not valid java name */
    public static final void m494matchCardCheckSpec$lambda1(Set set, UwbCardActivity uwbCardActivity, String str, UwbDevice uwbDevice) {
        ixe.O00000o(uwbCardActivity, "this$0");
        hcz.getInstance().getSpecCache().O000000o("/instance/v2/multiLanguage", set);
        hcz.getInstance().getSpecCache().O000000o("/miot-spec-v2/instance", set);
        uwbCardActivity.runOnUiThread(new Runnable(str, uwbCardActivity, uwbDevice) {
            /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbCardActivity$ragt7DkGy6vZxkF3hLPyD4_uKZ4 */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ UwbCardActivity f$1;
            private final /* synthetic */ UwbDevice f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                UwbCardActivity.m495matchCardCheckSpec$lambda1$lambda0(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: matchCardCheckSpec$lambda-1$lambda-0  reason: not valid java name */
    public static final void m495matchCardCheckSpec$lambda1$lambda0(String str, UwbCardActivity uwbCardActivity, UwbDevice uwbDevice) {
        ixe.O00000o(uwbCardActivity, "this$0");
        if (hcz.getInstance().getSpecCache().O00000o0(str) == null) {
            uwbCardActivity.showToast("uwb", null, uwbCardActivity.getString(R.string.code_did_is_empty));
            return;
        }
        UwbLogUtil.d("Mijia-UWB-UwbCardActivityTag", "UWBPERFORMANCE-8-mijia-card-complete  " + System.currentTimeMillis() + " loadHomeDevice " + uwbDevice + " getSpecInstance");
        super.matchCard(uwbCardActivity.getIntent());
    }

    /* access modifiers changed from: private */
    /* renamed from: matchCardCheckSpec$lambda-2  reason: not valid java name */
    public static final void m496matchCardCheckSpec$lambda2(UwbDevice uwbDevice, UwbCardActivity uwbCardActivity) {
        ixe.O00000o(uwbCardActivity, "this$0");
        UwbLogUtil.d("Mijia-UWB-UwbCardActivityTag", "UWBPERFORMANCE-8-mijia-card-complete  " + System.currentTimeMillis() + " loadHomeDevice  " + uwbDevice);
        super.matchCard(uwbCardActivity.getIntent());
    }

    public final hbz<C, E, T> showCard(hch.O000000o o000000o) {
        View findViewById;
        ArrayList<hcf> arrayList;
        BaseCardRender.LayoutPosition layoutPosition;
        ixe.O00000o(o000000o, "creator");
        this.render = super.showCard(new UwbCardActivity$showCard$1(o000000o));
        int O000000o2 = gpc.O000000o(40.0f);
        hbz<C, E, T> hbz = this.render;
        TextPaint textPaint = null;
        if (!(hbz == null || (arrayList = hbz.f10206O000000o) == null)) {
            for (hcf hcf : arrayList) {
                hcf.O0000o0 = $$Lambda$UwbCardActivity$hCyrnSOqhNaDNJJXG9wV9KW6D1A.INSTANCE;
                hbz<C, E, T> hbz2 = this.render;
                if (hbz2 == null) {
                    layoutPosition = null;
                } else {
                    layoutPosition = hbz2.O000000o(hcf.O0000o00);
                }
                if (layoutPosition == BaseCardRender.LayoutPosition.TITLE) {
                    if (hcf instanceof hey) {
                        hey hey = (hey) hcf;
                        hey.O0000oO.getLayoutParams().width = O000000o2;
                        hey.O0000oO.getLayoutParams().height = O000000o2;
                    } else if (hcf instanceof heh) {
                        heh heh = (heh) hcf;
                        heh.O0000o0o.getLayoutParams().width = O000000o2;
                        heh.O0000o0o.getLayoutParams().height = O000000o2;
                    }
                }
            }
        }
        TextView textView = (TextView) findViewById(R.id.bottom_text);
        if (textView != null) {
            textView.setText((int) R.string.uwb_card_more_operation);
        }
        if (textView != null) {
            textView.setTextSize(2, 16.0f);
        }
        Device device = this.mDevice;
        UwbDevice uwbDevice = device instanceof UwbDevice ? (UwbDevice) device : null;
        if ((uwbDevice == null ? null : uwbDevice.getBaseDevice()) == null && (findViewById = findViewById(R.id.layout_bottom)) != null) {
            findViewById.setVisibility(8);
        }
        View childAt = getFlRoot().getChildAt(0);
        childAt.setBackgroundResource(R.drawable.uwb_mico_card_view_bg);
        int O000000o3 = gpc.O000000o(20.0f);
        View findViewById2 = findViewById(R.id.ssl);
        View findViewById3 = findViewById(R.id.rl_title_root);
        ViewGroup.LayoutParams layoutParams = findViewById3 == null ? null : findViewById3.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.height = -2;
        }
        findViewById2.setPadding(0, O000000o3, 0, 0);
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = O000000o3;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = O000000o3;
        }
        findViewById2.requestLayout();
        TextView textView2 = (TextView) findViewById(R.id.tv_device_name);
        if (textView2 != null) {
            textView2.setTextSize(20.0f);
        }
        if (textView2 != null) {
            textPaint = textView2.getPaint();
        }
        if (textPaint != null) {
            textPaint.setFakeBoldText(true);
        }
        ViewGroup.LayoutParams layoutParams3 = childAt.getLayoutParams();
        if (layoutParams3 != null) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.bottomMargin = hzf.O00000Oo((Context) this);
            layoutParams4.gravity = 81;
            findViewById(R.id.enter_device_divider).setVisibility(8);
            return this.render;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    /* access modifiers changed from: private */
    /* renamed from: showCard$lambda-5$lambda-4  reason: not valid java name */
    public static final void m497showCard$lambda5$lambda4(View view) {
        hzf.O00000oO(view);
    }

    public final void showToast(String str, fso fso, String str2) {
        UwbLogUtil.d("Mijia-UWB-UwbCardActivityTag", "dismissLoading");
        getFlRoot().setVisibility(0);
        super.showToast(str, fso, str2);
        getMLoadingDialog().dismiss();
        setNavigationColor();
    }

    public final boolean retryNetwork() {
        Device device = this.mDevice;
        Device device2 = null;
        UwbDevice uwbDevice = device instanceof UwbDevice ? (UwbDevice) device : null;
        if (uwbDevice != null) {
            device2 = uwbDevice.getBaseDevice();
        }
        return device2 != null;
    }

    public final hdg<C, E, T> getRequestSender() {
        return this.requestSender;
    }

    public final void onBackPressed() {
        super.onBackPressed();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.uwbBaseHelper.onDestroy(this);
        this.requestSender.onDestroy();
        dcp.O000000o().O00000Oo(false);
        UwbLogUtil.d("Mijia-UWB-UwbCardActivityTag", "onDestroy");
    }

    public final frb createDevicePropSubscriber() {
        return this.requestSender;
    }
}
