package _m_j;

import _m_j.fca;
import _m_j.fno;
import _m_j.ggb;
import _m_j.gsj;
import _m_j.gzs;
import _m_j.hbr;
import _m_j.hic;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.material.appbar.AppBarLayout;
import com.xiaomi.smarthome.DeviceMainPageRouterFactory;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.KeyValuePair;
import com.xiaomi.smarthome.device.renderer.DeviceRenderer;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.login.MijiaLoginManager;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.contentprovider.SmartHomeContentProvider;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.framework.plugin.rn.view.DraggingButton;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.AddMenuPopupWindow;
import com.xiaomi.smarthome.newui.ChangeHomePopupWindow;
import com.xiaomi.smarthome.newui.HomeEnvInfoFragment;
import com.xiaomi.smarthome.newui.HomeEnvInfoSettingFragment;
import com.xiaomi.smarthome.newui.OnPageChangeListenerWithIdleType;
import com.xiaomi.smarthome.newui.adapter.DviceEditInterface;
import com.xiaomi.smarthome.newui.mainpage.EditMaskView;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.page.DeviceEditPage;
import com.xiaomi.smarthome.newui.widget.AppBarStateChangeListener;
import com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2;
import com.xiaomi.smarthome.newui.widget.MainPageAppBarLayout;
import com.xiaomi.smarthome.newui.widget.SimplePushToRefreshHeader;
import com.xiaomi.smarthome.newui.widget.banner.CustomBannerHeaderView;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.newui.widget.topnavi.indicator.MagicIndicator;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.MyIndicator;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.MyViewPager;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.MyViewPager$dispose$$inlined$filterIsInstance$1;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gzs extends guc implements gzr, hmv {
    public static int O000O00o = 201;
    public CompositeDisposable O00000Oo = new CompositeDisposable();
    public volatile boolean O00000o = false;
    public XQProgressDialog O00000o0;
    public MLAlertDialog O00000oO;
    public volatile boolean O00000oo = false;
    public CoordinatorLayout O0000O0o;
    public MainPageAppBarLayout O0000OOo;
    public CustomBannerHeaderView O0000Oo;
    public View O0000Oo0;
    public MyIndicator O0000OoO;
    public MyViewPager O0000Ooo;
    public boolean O0000o = false;
    public boolean O0000o0 = false;
    public ImageView O0000o00;
    public boolean O0000o0O = false;
    public PopupWindow O0000o0o;
    protected TextView O0000oO;
    public fnr O0000oO0;
    public TextView O0000oOO;
    public View O0000oOo;
    public Handler O0000oo = new Handler() {
        /* class _m_j.gzs.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (!gzs.this.O0000o0 && gzs.this.isValid()) {
                int i = message.what;
                if (i == 1) {
                    gzs.this.O00000oo = true;
                } else if (i == 3) {
                    gzs.this.O0000O0o();
                }
            }
        }
    };
    public TextView O0000oo0;
    public View O0000ooO;
    public View O0000ooo;
    public DviceEditInterface O000O0OO;
    public AtomicBoolean O000O0Oo = new AtomicBoolean(false);
    private TextView O000O0o;
    private ViewGroup O000O0o0;
    private View O000O0oO;
    private ImageView O000O0oo;
    private boolean O000OO = true;
    private DraggingButton O000OO00;
    private boolean O000OO0o = true;
    private ImageView O000OOOo;
    private boolean O000OOo;
    private ImageView O000OOo0;
    private EditMaskView O000OOoO;
    private fjv O000OOoo = new fjv() {
        /* class _m_j.gzs.AnonymousClass12 */

        public final void onUnitChange(String str, String str2, String str3) {
            gzs.this.O0000Oo.setDeviceMainPage(gzs.this);
        }
    };
    private Disposable O000Oo0;
    private BroadcastReceiver O000Oo00 = new BroadcastReceiver() {
        /* class _m_j.gzs.AnonymousClass21 */

        public final void onReceive(Context context, Intent intent) {
            if (gzs.this.O0000o) {
                if (TextUtils.equals(intent.getAction(), "force_update_data_completed")) {
                    MainPageAppBarLayout mainPageAppBarLayout = gzs.this.O0000OOo;
                    CoordinatorLayout coordinatorLayout = gzs.this.O0000O0o;
                    if (mainPageAppBarLayout.O00000oO != null) {
                        mainPageAppBarLayout.O00000oO.refreshComplete(coordinatorLayout, mainPageAppBarLayout);
                    }
                    gzs.this.O0000oo.removeMessages(5);
                    gzs.this.O0000oo.sendEmptyMessageDelayed(5, gzs.this.O0000o0O ? 3000 : 4000);
                    gzs gzs = gzs.this;
                    if (!gzs.O00oOooO.getAndSet(true)) {
                        gzs.O0000oo.postDelayed(new Runnable() {
                            /* class _m_j.gzs.AnonymousClass22 */

                            public final void run() {
                                gva.O000000o().checkAndShow((CommonActivity) gzs.this.getActivity());
                            }
                        }, 1000);
                    }
                    gzs.this.O0000Oo0();
                    hgz O000000o2 = hgz.O000000o();
                    $$Lambda$gzs$21$7anU7lnRKab5tVTLDs7LLR5_jBw r7 = $$Lambda$gzs$21$7anU7lnRKab5tVTLDs7LLR5_jBw.INSTANCE;
                    if (O000000o2.f18926O000000o <= 0 || Math.abs(System.currentTimeMillis() - O000000o2.f18926O000000o) >= DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                        O000000o2.f18926O000000o = System.currentTimeMillis();
                        r7.run();
                    }
                } else if ("com.smarthome.refresh_list_view".equals(intent.getAction())) {
                    gzs.this.O00000oo();
                } else if ("home_room_updated".equals(intent.getAction())) {
                    gsy.O00000Oo(LogType.MAIN_PAGE, "DeviceMainPage", "onReceive: home ready: ");
                    gzs.this.O00000oo();
                    goq.O000000o(new Runnable() {
                        /* class _m_j.gzs.AnonymousClass21.AnonymousClass1 */

                        public final void run() {
                            gtj.O000000o().O00000o0();
                        }
                    });
                } else if ("user_mgr_user_info_updated".equals(intent.getAction())) {
                    gzs.this.O0000OOo();
                } else if ("home_room_home_changed".equals(intent.getAction())) {
                    gzs.this.O00000Oo();
                    gzs.this.O00000Oo(true);
                    Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
                    if (!(gzs.this.O0000ooo == null || O0000Oo0 == null)) {
                        gzs.this.O0000ooo.setActivated(O0000Oo0.isOwner());
                    }
                    gzs.this.O0000Oo0();
                } else if ("action_business_data_ready".equals(intent.getAction())) {
                    gzs.this.O00000o0();
                } else if ("category_info_updated_action".equals(intent.getAction())) {
                    gzs gzs2 = gzs.this;
                    gzs2.O0000oo.removeMessages(3);
                    gzs2.O0000oo.sendEmptyMessage(3);
                } else if ("force_update_data".equals(intent.getAction())) {
                    gsy.O00000Oo("DeviceMainPage", "receive broadcast, will startRefresh...");
                    gzs.this.O00000Oo(true);
                } else if ("switch_refresh_success".equals(intent.getAction())) {
                    gzs.this.O00000oo();
                }
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o() {
            cki.O00000o0("DeviceMainPage", "do runOnce");
            CameraRouterFactory.getCameraManagerApi().forceGetMissTutkVersionConfig(null);
            CameraRouterFactory.getCameraManagerApi().getRNConfigCameraRNUtils();
            CameraRouterFactory.getCameraManagerApi().cameraPreConnectionNative();
            if (CameraRouterFactory.getCameraManagerApi().checkShouldPreloadCameraCameraOperationUtils()) {
                PluginRuntimeManager.getInstance().initCameraProcess();
            }
            CameraRouterFactory.getCameraManagerApi().cameraAudioConfig();
        }
    };
    private boolean O000Oo0O;
    private final fno.O000000o O000Oo0o = new fno.O000000o() {
        /* class _m_j.gzs.AnonymousClass23 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                LogType logType = LogType.MAIN_PAGE;
                gsy.O00000Oo(logType, "DeviceMainPage", "UPDATE_DEVICE_DATA_READY getCurrentState " + ServiceApplication.getStateNotifier().f15923O000000o + ",device size=" + fno.O000000o().O0000O0o().size());
                LogType logType2 = LogType.MIJIA_WIDGET;
                gsy.O00000o0(logType2, "zhudong_send", "DeviceMainPage_mIClientDeviceListener_type:" + i + "---loginState:" + ServiceApplication.getStateNotifier().f15923O000000o);
                if (ServiceApplication.getStateNotifier().f15923O000000o >= 3) {
                    hza.O000000o((Application) ServiceApplication.getApplication());
                }
                if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                    SmartHomeContentProvider.O000000o(gzs.this.getActivity(), "online_devices_count");
                    if (!gzs.this.O0000o0O) {
                        ((gzz) fo.O000000o((FragmentActivity) Objects.requireNonNull(gzs.this.getActivity())).O000000o(gzz.class)).O00000Oo(ggb.O00000Oo().O0000OOo());
                        ((gzz) fo.O000000o((FragmentActivity) Objects.requireNonNull(gzs.this.getActivity())).O000000o(gzz.class)).O000000o(ggb.O00000Oo().O0000OOo());
                    }
                    gzs gzs = gzs.this;
                    gzs.O0000o0O = true;
                    if (!gzs.O00oOooo) {
                        gzs.this.O00oOooo = true;
                        fnr.O000000o();
                    }
                    boolean z = ggb.O00000Oo().O0000OoO.O00000oo;
                    gsy.O00000Oo(LogType.MAIN_PAGE, "DeviceMainPage", "onReceive: data ready; isHomeManagerInited: ".concat(String.valueOf(z)));
                    if (z) {
                        gsy.O00000Oo("DeviceMainPage", "Device Data Is Ready,But View Not!");
                        gzs.this.O0000Ooo.O00000Oo();
                    }
                    gzs.this.O00000oo();
                    hsl.O00000Oo().sendRefreshMsg();
                    hsl.O00000Oo().clearTempSubtitle();
                    gtj.O000000o().O00000o0();
                    if (!gzs.this.O000O0Oo.getAndSet(true)) {
                        gzs gzs2 = gzs.this;
                        hsw.O000000o().checkMsgAlert((BaseActivity) gzs2.getActivity(), 1);
                        hsw.O000000o().checkMsgAlert((BaseActivity) gzs2.getActivity(), 8);
                    }
                }
            }
        }
    };
    private boolean O000OoO = false;
    private long O000OoO0 = 0;
    private MijiaLoginManager.O000000o O000OoOO = new MijiaLoginManager.O000000o() {
        /* class _m_j.gzs.AnonymousClass20 */

        public final void O000000o() {
            gzs.this.O0000Oo();
        }

        public final void O00000Oo() {
            gzs.this.O0000OoO();
        }
    };
    private DeviceEditPage O00O0Oo = null;
    public AtomicBoolean O00oOoOo = new AtomicBoolean(false);
    AtomicBoolean O00oOooO = new AtomicBoolean(false);
    public boolean O00oOooo = false;

    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public final void O00000Oo() {
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        if (O0000Oo02 == null || O0000Oo02.isOwner()) {
            this.O000Oo0O = true;
            return;
        }
        this.O000Oo0O = false;
        this.O0000oOO.setVisibility(8);
        this.O0000oOo.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CoreApi.O000000o().O000000o(getActivity(), new CoreApi.O0000o0() {
            /* class _m_j.gzs.AnonymousClass24 */

            public final void onCoreReady() {
                goq.O000000o(new Runnable() {
                    /* class _m_j.gzs.AnonymousClass24.AnonymousClass1 */

                    public final void run() {
                        gsj gsj;
                        gsj gsj2;
                        String str;
                        String str2;
                        String str3 = "_preview";
                        fbv.O000000o().O00000Oo();
                        fbz O000000o2 = fbz.O000000o();
                        ArrayList arrayList = new ArrayList();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("lang", "en");
                            StringBuilder sb = new StringBuilder("multimedia_spec_config");
                            if (gfr.O0000oo0) {
                                str2 = str3;
                            } else {
                                str2 = "";
                            }
                            sb.append(str2);
                            jSONObject.put("name", sb.toString());
                            jSONObject.put("version", "1");
                        } catch (Exception e) {
                            gsy.O00000Oo("MultimediaConfigManager", "getMultimediaConfig:" + e.getLocalizedMessage());
                        }
                        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                        gsj gsj3 = null;
                        try {
                            gsj.O000000o o000000o = new gsj.O000000o();
                            o000000o.f18212O000000o = "GET";
                            gsj = o000000o.O00000Oo(fbz.O000000o(jSONObject)).O000000o();
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                            gsj = null;
                        }
                        if (gsj != null) {
                            gsg.O00000Oo(gsj, 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x008b: INVOKE  
                                  (r0v2 'gsj' _m_j.gsj)
                                  (wrap: _m_j.fbz$1 : 0x0088: CONSTRUCTOR  (r13v2 _m_j.fbz$1) = (r11v0 'O000000o2' _m_j.fbz) call: _m_j.fbz.1.<init>(_m_j.fbz):void type: CONSTRUCTOR)
                                 type: STATIC call: _m_j.gsg.O00000Oo(_m_j.gsj, _m_j.gsl):_m_j.gsn in method: _m_j.gzs.24.1.run():void, dex: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
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
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0088: CONSTRUCTOR  (r13v2 _m_j.fbz$1) = (r11v0 'O000000o2' _m_j.fbz) call: _m_j.fbz.1.<init>(_m_j.fbz):void type: CONSTRUCTOR in method: _m_j.gzs.24.1.run():void, dex: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 100 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.fbz, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 106 more
                                */
                            /*
                                this = this;
                                java.lang.String r1 = "1"
                                java.lang.String r2 = "getMultimediaConfig:"
                                java.lang.String r3 = "MultimediaConfigManager"
                                java.lang.String r4 = "version"
                                java.lang.String r5 = "_preview"
                                java.lang.String r6 = ""
                                java.lang.String r7 = "GET"
                                java.lang.String r8 = "name"
                                java.lang.String r9 = "en"
                                java.lang.String r10 = "lang"
                                _m_j.fbv r0 = _m_j.fbv.O000000o()
                                r0.O00000Oo()
                                _m_j.fbz r11 = _m_j.fbz.O000000o()
                                java.util.ArrayList r12 = new java.util.ArrayList
                                r12.<init>()
                                org.json.JSONObject r13 = new org.json.JSONObject
                                r13.<init>()
                                r13.put(r10, r9)     // Catch:{ Exception -> 0x0048 }
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0048 }
                                java.lang.String r14 = "multimedia_spec_config"
                                r0.<init>(r14)     // Catch:{ Exception -> 0x0048 }
                                boolean r14 = _m_j.gfr.O0000oo0     // Catch:{ Exception -> 0x0048 }
                                if (r14 == 0) goto L_0x0039
                                r14 = r5
                                goto L_0x003a
                            L_0x0039:
                                r14 = r6
                            L_0x003a:
                                r0.append(r14)     // Catch:{ Exception -> 0x0048 }
                                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0048 }
                                r13.put(r8, r0)     // Catch:{ Exception -> 0x0048 }
                                r13.put(r4, r1)     // Catch:{ Exception -> 0x0048 }
                                goto L_0x005c
                            L_0x0048:
                                r0 = move-exception
                                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                                r14.<init>(r2)
                                java.lang.String r0 = r0.getLocalizedMessage()
                                r14.append(r0)
                                java.lang.String r0 = r14.toString()
                                _m_j.gsy.O00000Oo(r3, r0)
                            L_0x005c:
                                com.xiaomi.smarthome.device.api.KeyValuePair r0 = new com.xiaomi.smarthome.device.api.KeyValuePair
                                java.lang.String r14 = r13.toString()
                                java.lang.String r15 = "data"
                                r0.<init>(r15, r14)
                                r12.add(r0)
                                r12 = 0
                                _m_j.gsj$O000000o r0 = new _m_j.gsj$O000000o     // Catch:{ UnsupportedEncodingException -> 0x007f }
                                r0.<init>()     // Catch:{ UnsupportedEncodingException -> 0x007f }
                                r0.f18212O000000o = r7     // Catch:{ UnsupportedEncodingException -> 0x007f }
                                java.lang.String r13 = _m_j.fbz.O000000o(r13)     // Catch:{ UnsupportedEncodingException -> 0x007f }
                                _m_j.gsj$O000000o r0 = r0.O00000Oo(r13)     // Catch:{ UnsupportedEncodingException -> 0x007f }
                                _m_j.gsj r0 = r0.O000000o()     // Catch:{ UnsupportedEncodingException -> 0x007f }
                                goto L_0x0084
                            L_0x007f:
                                r0 = move-exception
                                r0.printStackTrace()
                                r0 = r12
                            L_0x0084:
                                if (r0 == 0) goto L_0x008e
                                _m_j.fbz$1 r13 = new _m_j.fbz$1
                                r13.<init>()
                                _m_j.gsg.O00000Oo(r0, r13)
                            L_0x008e:
                                _m_j.hzg r0 = _m_j.hzj.O000000o()
                                r0.syncUwbConfig()
                                _m_j.fbz r11 = _m_j.fbz.O000000o()
                                org.json.JSONObject r13 = new org.json.JSONObject
                                r13.<init>()
                                r13.put(r10, r9)     // Catch:{ Exception -> 0x00bd }
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bd }
                                java.lang.String r14 = "miss_pre_connection_control"
                                r0.<init>(r14)     // Catch:{ Exception -> 0x00bd }
                                boolean r14 = _m_j.gfr.O0000oo0     // Catch:{ Exception -> 0x00bd }
                                if (r14 == 0) goto L_0x00ae
                                r14 = r5
                                goto L_0x00af
                            L_0x00ae:
                                r14 = r6
                            L_0x00af:
                                r0.append(r14)     // Catch:{ Exception -> 0x00bd }
                                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00bd }
                                r13.put(r8, r0)     // Catch:{ Exception -> 0x00bd }
                                r13.put(r4, r1)     // Catch:{ Exception -> 0x00bd }
                                goto L_0x00d3
                            L_0x00bd:
                                r0 = move-exception
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                java.lang.String r14 = "getPreConnectConfig:"
                                r1.<init>(r14)
                                java.lang.String r0 = r0.getLocalizedMessage()
                                r1.append(r0)
                                java.lang.String r0 = r1.toString()
                                _m_j.gsy.O00000Oo(r3, r0)
                            L_0x00d3:
                                _m_j.gsj$O000000o r0 = new _m_j.gsj$O000000o     // Catch:{ UnsupportedEncodingException -> 0x00e7 }
                                r0.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00e7 }
                                r0.f18212O000000o = r7     // Catch:{ UnsupportedEncodingException -> 0x00e7 }
                                java.lang.String r1 = _m_j.fbz.O000000o(r13)     // Catch:{ UnsupportedEncodingException -> 0x00e7 }
                                _m_j.gsj$O000000o r0 = r0.O00000Oo(r1)     // Catch:{ UnsupportedEncodingException -> 0x00e7 }
                                _m_j.gsj r0 = r0.O000000o()     // Catch:{ UnsupportedEncodingException -> 0x00e7 }
                                goto L_0x00ec
                            L_0x00e7:
                                r0 = move-exception
                                r0.printStackTrace()
                                r0 = r12
                            L_0x00ec:
                                if (r0 == 0) goto L_0x00f6
                                _m_j.fbz$2 r1 = new _m_j.fbz$2
                                r1.<init>()
                                _m_j.gsg.O00000Oo(r0, r1)
                            L_0x00f6:
                                _m_j.cjo r1 = _m_j.cjo.O000000o()
                                java.util.ArrayList r3 = new java.util.ArrayList
                                r3.<init>()
                                org.json.JSONObject r11 = new org.json.JSONObject
                                r11.<init>()
                                r11.put(r10, r9)     // Catch:{ Exception -> 0x0124 }
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0124 }
                                java.lang.String r9 = "camera_player_config"
                                r0.<init>(r9)     // Catch:{ Exception -> 0x0124 }
                                boolean r9 = _m_j.gfr.O0000oo0     // Catch:{ Exception -> 0x0124 }
                                if (r9 == 0) goto L_0x0113
                                goto L_0x0114
                            L_0x0113:
                                r5 = r6
                            L_0x0114:
                                r0.append(r5)     // Catch:{ Exception -> 0x0124 }
                                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0124 }
                                r11.put(r8, r0)     // Catch:{ Exception -> 0x0124 }
                                java.lang.String r0 = "5"
                                r11.put(r4, r0)     // Catch:{ Exception -> 0x0124 }
                                goto L_0x013a
                            L_0x0124:
                                r0 = move-exception
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                r4.<init>(r2)
                                java.lang.String r0 = r0.getLocalizedMessage()
                                r4.append(r0)
                                java.lang.String r0 = r4.toString()
                                java.lang.String r2 = "CameraPlayerConfigManager"
                                _m_j.gsy.O00000Oo(r2, r0)
                            L_0x013a:
                                com.xiaomi.smarthome.device.api.KeyValuePair r0 = new com.xiaomi.smarthome.device.api.KeyValuePair
                                java.lang.String r2 = r11.toString()
                                r0.<init>(r15, r2)
                                r3.add(r0)
                                _m_j.gsj$O000000o r0 = new _m_j.gsj$O000000o     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                r0.<init>()     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                r0.f18212O000000o = r7     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                r2.<init>()     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                android.content.Context r3 = _m_j.gkv.f17949O000000o     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                java.lang.String r3 = _m_j.hsk.O000000o(r3)     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                r2.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                java.lang.String r3 = "/app/service/getappconfig?data="
                                r2.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                java.lang.String r3 = r11.toString()     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                java.lang.String r4 = "UTF-8"
                                java.lang.String r3 = java.net.URLEncoder.encode(r3, r4)     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                r2.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                java.lang.String r2 = r2.toString()     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                _m_j.gsj$O000000o r0 = r0.O00000Oo(r2)     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                _m_j.gsj r12 = r0.O000000o()     // Catch:{ UnsupportedEncodingException -> 0x017a }
                                goto L_0x017e
                            L_0x017a:
                                r0 = move-exception
                                r0.printStackTrace()
                            L_0x017e:
                                if (r12 == 0) goto L_0x0188
                                _m_j.cjo$1 r0 = new _m_j.cjo$1
                                r0.<init>()
                                _m_j.gsg.O00000Oo(r12, r0)
                            L_0x0188:
                                _m_j.gtf r0 = _m_j.gtf.O000000o()
                                r0.O00000Oo()
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: _m_j.gzs.AnonymousClass24.AnonymousClass1.run():void");
                        }
                    });
                }
            });
            MijiaLoginManager O000000o2 = MijiaLoginManager.O000000o();
            MijiaLoginManager.O000000o o000000o = this.O000OoOO;
            if (!O000000o2.f7521O000000o.contains(o000000o)) {
                O000000o2.f7521O000000o.add(o000000o);
            }
            O00000Oo();
            gtt O000000o3 = gtt.O000000o();
            if (!O000000o3.O0000O0o && O000000o3.f18273O000000o == null) {
                O000000o3.O00000oo.sendEmptyMessage(1);
            }
        }

        public void onScan(List<?> list) {
            if (this.O0000oOO != null && this.O0000oOo != null) {
                int i = fbv.O000000o().O00000oo;
                int size = list.size();
                boolean z = ServiceApplication.getStateNotifier().f15923O000000o == 4;
                LogType logType = LogType.MAIN_PAGE;
                StringBuilder sb = new StringBuilder("redpoint onScan:scanResult=");
                sb.append(list == null ? null : Integer.valueOf(list.size()));
                sb.append(",type=");
                sb.append(i);
                sb.append(",isLogin=");
                sb.append(z);
                gsy.O00000o0(logType, "DeviceMainPage", sb.toString());
                if (i == 0 || size <= 0 || !z) {
                    this.O0000oOO.setVisibility(8);
                    this.O0000oOo.setVisibility(8);
                } else if (i == 1) {
                    this.O0000oOO.setVisibility(8);
                    this.O0000oOo.setVisibility(0);
                } else {
                    this.O0000oOO.setVisibility(0);
                    this.O0000oOo.setVisibility(8);
                    this.O0000oOO.setText(String.valueOf(Math.min(size, 99)));
                }
            }
        }

        /* JADX WARN: Type inference failed for: r1v44, types: [android.content.Context] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            fju.O000000o().O000000o(this.O000OOoo);
            if (this.f17283O000000o == null) {
                FragmentActivity fragmentActivity = null;
                this.f17283O000000o = layoutInflater.inflate((int) R.layout.client_all_page_v2_top_navi_layout, (ViewGroup) null);
                this.O0000o = true;
                gsy.O00000Oo("DeviceMainPage", "initViews");
                this.O000O0o0 = (ViewGroup) this.f17283O000000o.findViewById(R.id.root_view);
                View findViewById = this.f17283O000000o.findViewById(R.id.new_home_red_dot);
                this.O0000O0o = (CoordinatorLayout) this.f17283O000000o.findViewById(R.id.coordinator_layout_vs);
                this.O0000OOo = (MainPageAppBarLayout) this.f17283O000000o.findViewById(R.id.main_appbar);
                this.O0000ooo = this.O0000OOo.findViewById(R.id.add_device_btn);
                if (Build.VERSION.SDK_INT >= 29) {
                    this.O0000ooo.setForceDarkAllowed(false);
                }
                this.O0000ooo.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gzs.AnonymousClass2 */

                    public final void onClick(View view) {
                        Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
                        if (O0000Oo0 == null || O0000Oo0.isOwner()) {
                            hxk hxk = hxi.O00000o;
                            hxi.O0000Oo.O00000Oo();
                            hxk.f952O000000o.O000000o("home_whole_device", new Object[0]);
                            gzs.this.O0000oOO.setVisibility(8);
                            gzs.this.O0000oOo.setVisibility(8);
                            new AddMenuPopupWindow(gzs.this.getActivity(), gzs.this.O0000ooo).e_();
                            int i = fbv.O000000o().O00000oo;
                            hxi.O00000o.f952O000000o.O000000o("home_adddevice", "type", Integer.valueOf(i));
                            return;
                        }
                        gqg.O00000Oo((int) R.string.mj_home_member_add_device_tips);
                        hxi.O00000o.f952O000000o.O000000o("shared_family_member.add", new Object[0]);
                    }
                });
                this.O0000OOo.findViewById(R.id.message_center_icon).setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gzs.AnonymousClass3 */

                    public final void onClick(View view) {
                        if (!(ServiceApplication.getStateNotifier().f15923O000000o == 4)) {
                            gty.O000000o().startLogin(gzs.this.getContext(), 1, null);
                            return;
                        }
                        fbs.O000000o(new fbt(gzs.this.getContext(), "/message/MessageCenterActivity"));
                        if (gzs.this.O0000ooO != null) {
                            gzs.this.O0000ooO.setVisibility(8);
                        }
                    }
                });
                if (Build.VERSION.SDK_INT >= 29) {
                    this.O0000OOo.findViewById(R.id.message_center_icon).setForceDarkAllowed(false);
                }
                this.O0000ooO = this.O0000OOo.findViewById(R.id.message_center_new_message_tag);
                this.O000Oo0 = ggc.O000000o().O00000oo.throttleLast(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(findViewById) {
                    /* class _m_j.$$Lambda$gzs$h6QwMUXUIy_9Sl_I7iINRQoFU */
                    private final /* synthetic */ View f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void accept(Object obj) {
                        gzs.this.O000000o(this.f$1, (Boolean) obj);
                    }
                });
                this.O0000o00 = DeviceMainPageRouterFactory.getSmartHomeMainActivityProvider().getWallPaperView(getActivity());
                this.O0000Ooo = (MyViewPager) this.f17283O000000o.findViewById(R.id.viewpager);
                this.O0000Ooo.addOnPageChangeListener(new OnPageChangeListenerWithIdleType() {
                    /* class _m_j.gzs.AnonymousClass4 */

                    public final void O000000o(OnPageChangeListenerWithIdleType.Reason reason) {
                    }

                    public final void onPageSelected(int i) {
                        hid hid;
                        super.onPageSelected(i);
                        haj roomAdapter = gzs.this.O0000Ooo.getRoomAdapter();
                        if (roomAdapter != null) {
                            List<hid> list = roomAdapter.O00000oo;
                            PageBean pageBean = null;
                            if (!(list == null || (hid = list.get(i)) == null)) {
                                pageBean = hid.f18959O000000o;
                            }
                            if (pageBean != null) {
                                hxf.O000000o().O000000o(ggb.O00000Oo().O0000OOo(), pageBean.O00000Oo);
                            }
                            roomAdapter.O0000O0o = i;
                            ggb.O0000O0o.O000000o().onNext(ggb.O0000O0o.O000000o(roomAdapter.O000000o(i), new boolean[0]));
                        }
                    }
                });
                this.O0000OoO = (MyIndicator) this.f17283O000000o.findViewById(R.id.top_indicator);
                this.O000O0o = (TextView) this.f17283O000000o.findViewById(R.id.home_name_tv);
                this.O000O0oO = this.f17283O000000o.findViewById(R.id.home_name_tv_click_delegate);
                this.O000O0oO.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.$$Lambda$gzs$VBJQgIsfqz2JQtJm_qBCJfpLVRk */

                    public final void onClick(View view) {
                        gzs.this.O00000o0(view);
                    }
                });
                this.O000O0oo = (ImageView) this.f17283O000000o.findViewById(R.id.home_name_arrow);
                this.O0000oOO = (TextView) this.f17283O000000o.findViewById(R.id.new_message_text);
                this.O0000oOo = this.f17283O000000o.findViewById(R.id.new_message_tag);
                this.O0000Oo0 = this.f17283O000000o.findViewById(R.id.indicator_bg_mask);
                this.O000OOoO = (EditMaskView) this.f17283O000000o.findViewById(R.id.edit_mode_mask);
                this.O0000Oo = (CustomBannerHeaderView) this.O000O0o0.findViewById(R.id.custom_header_view);
                this.O0000Oo.setDeviceMainPage(this);
                this.O0000OOo.setOnRefreshListener(new SimplePushToRefreshHeader.O000000o() {
                    /* class _m_j.gzs.AnonymousClass5 */

                    public final void O000000o() {
                        gsy.O00000Oo("DeviceMainPage", "start refresh");
                        gzs.this.O00000Oo(true);
                        hna.O00000o0().checkAiotDeviceWifi();
                    }
                });
                this.O0000OOo.setDeviceMainPage(this);
                this.O0000OOo.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this.O0000OoO);
                this.O0000OOo.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarStateChangeListener() {
                    /* class _m_j.gzs.AnonymousClass6 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    ViewPropertyAnimator f18667O000000o = gzs.this.O0000Oo0.animate();

                    public final void O000000o(AppBarStateChangeListener.State state) {
                        if (state == AppBarStateChangeListener.State.COLLAPSED) {
                            this.f18667O000000o.alpha(1.0f);
                            return;
                        }
                        this.f18667O000000o.cancel();
                        gzs.this.O0000Oo0.setAlpha(0.0f);
                    }
                });
                this.O0000OOo.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
                    /* class _m_j.gzs.AnonymousClass7 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    boolean f18668O000000o = false;
                    boolean O00000Oo = false;

                    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                        float abs = Math.abs(((float) i) / ((float) appBarLayout.getTotalScrollRange()));
                        if (gzs.this.O00000o) {
                            return;
                        }
                        if (Float.compare(abs, 0.3f) > 0) {
                            if (!this.f18668O000000o) {
                                this.f18668O000000o = true;
                                this.O00000Oo = false;
                            }
                        } else if (!this.O00000Oo) {
                            this.O00000Oo = true;
                            this.f18668O000000o = false;
                        }
                    }
                });
                MyViewPager myViewPager = this.O0000Ooo;
                MyIndicator myIndicator = this.O0000OoO;
                WeakReference<gzs> weakReference = new WeakReference<>(this);
                ixe.O00000o(myIndicator, "indicator");
                ixe.O00000o(weakReference, "deviceMainPageRef");
                myViewPager.O00000Oo = myIndicator;
                myViewPager.O00000o0 = weakReference;
                ViewPager viewPager = myViewPager;
                ixe.O00000o(viewPager, "viewPager");
                myIndicator.f10370O000000o.O00000Oo = viewPager;
                viewPager.addOnPageChangeListener(new ViewPager.O0000O0o(myIndicator.f10370O000000o) {
                    /* class _m_j.hhq.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ MagicIndicator f18953O000000o;

                    {
                        this.f18953O000000o = r1;
                    }

                    public final void onPageScrolled(int i, float f, int i2) {
                        MagicIndicator magicIndicator = this.f18953O000000o;
                        if (magicIndicator.f10342O000000o != null) {
                            magicIndicator.f10342O000000o.O000000o(i, f);
                        }
                    }

                    public final void onPageSelected(int i) {
                        MagicIndicator magicIndicator = this.f18953O000000o;
                        if (magicIndicator.f10342O000000o != null) {
                            magicIndicator.f10342O000000o.O000000o(i);
                        }
                    }

                    public final void onPageScrollStateChanged(int i) {
                        MagicIndicator magicIndicator = this.f18953O000000o;
                        if (magicIndicator.f10342O000000o != null) {
                            magicIndicator.f10342O000000o.O00000Oo(i);
                        }
                    }
                });
                Context context = myViewPager.getContext();
                ixe.O00000Oo(context, "context");
                gzs gzs = weakReference.get();
                if (gzs != null) {
                    myViewPager.setAdapter(new haj(context, myViewPager, new WeakReference(gzs)));
                    haj roomAdapter = myViewPager.getRoomAdapter();
                    if (roomAdapter != null) {
                        roomAdapter.O000000o(myViewPager.O0000O0o);
                    }
                    ? context2 = myViewPager.getContext();
                    if (context2 instanceof FragmentActivity) {
                        fragmentActivity = context2;
                    }
                    if (fragmentActivity != null) {
                        hic.O000000o o000000o = hic.f18958O000000o;
                        hic O000000o2 = hic.O000000o.O000000o(fragmentActivity);
                        hbr.O000000o o000000o2 = hbr.f18756O000000o;
                        hbr O000000o3 = hbr.O000000o.O000000o(fragmentActivity);
                        haj roomAdapter2 = myViewPager.getRoomAdapter();
                        if (roomAdapter2 != null) {
                            roomAdapter2.O000000o(O000000o2);
                        }
                        haj roomAdapter3 = myViewPager.getRoomAdapter();
                        if (roomAdapter3 != null) {
                            roomAdapter3.O000000o(O000000o3);
                        }
                    }
                    had O00000oO2 = had.O00000oO();
                    MyViewPager myViewPager2 = this.O0000Ooo;
                    ixe.O00000o(myViewPager2, "viewPager");
                    ixe.O00000o(this, "page");
                    O00000oO2.O00000o0 = this;
                    O00000oO2.O00000Oo = myViewPager2;
                    O00000oO2.O000000o();
                    boolean z = ggb.O00000Oo().O0000OoO.O00000oo;
                    gsy.O00000Oo(LogType.MAIN_PAGE, "DeviceMainPage", "initViews: mIsDeviceDataReady: " + this.O0000o0O + " ;isHomeManagerInited: " + z);
                    if (this.O0000o0O && z) {
                        this.O0000Ooo.O00000Oo();
                    }
                    O0000OOo();
                    if (gwg.O000000o((Activity) getActivity()) && this.O0000OOo != null) {
                        int O000000o4 = hzf.O000000o(CommonApplication.getAppContext());
                        if (this.O0000OOo.getLayoutParams().height > 0) {
                            this.O0000OOo.getLayoutParams().height += O000000o4;
                            MainPageAppBarLayout mainPageAppBarLayout = this.O0000OOo;
                            mainPageAppBarLayout.setContentHeight(mainPageAppBarLayout.getLayoutParams().height);
                        }
                        this.O0000OOo.setPadding(0, O000000o4, 0, 0);
                        MainPageAppBarLayout mainPageAppBarLayout2 = this.O0000OOo;
                        mainPageAppBarLayout2.setLayoutParams(mainPageAppBarLayout2.getLayoutParams());
                        if (this.O0000Oo0.getLayoutParams().height > 0) {
                            this.O0000Oo0.getLayoutParams().height += O000000o4;
                        }
                        this.O0000Oo0.setPadding(0, O000000o4, 0, 0);
                        View view = this.O0000Oo0;
                        view.setLayoutParams(view.getLayoutParams());
                    }
                    ggb.O0000O0o.O000000o().observeOn(Schedulers.io()).filter($$Lambda$gzs$0n9zYmUsP8uMX5r0TeFGNNmGOw.INSTANCE).distinctUntilChanged().map($$Lambda$KiZGAXmbaVvwqhTeGf96VKbw4Ig.INSTANCE).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Bitmap>() {
                        /* class _m_j.gzs.AnonymousClass8 */

                        public final void onComplete() {
                        }

                        public final /* synthetic */ void onNext(Object obj) {
                            Bitmap bitmap = (Bitmap) obj;
                            if (bitmap == null || !gzs.this.isValid() || gzs.this.O0000o00 == null) {
                                LogType logType = LogType.HOME_ROOM;
                                gsy.O00000o0(logType, "zzzOnNext: ", "bitmap = " + bitmap + " isValid = " + gzs.this.isValid() + " mRoomBg " + gzs.this.O0000o00);
                                return;
                            }
                            Drawable drawable = gzs.this.O0000o00.getDrawable();
                            if (drawable == null) {
                                drawable = new BitmapDrawable(gzs.this.getResources(), bitmap);
                            } else if (drawable instanceof TransitionDrawable) {
                                drawable = ((TransitionDrawable) drawable).getDrawable(1);
                            }
                            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable, new BitmapDrawable(gzs.this.getResources(), bitmap)});
                            gzs.this.O0000o00.setImageDrawable(transitionDrawable);
                            transitionDrawable.startTransition(400);
                        }

                        public final void onSubscribe(Disposable disposable) {
                            gzs.this.O00000Oo.add(disposable);
                        }

                        public final void onError(Throwable th) {
                            gsy.O00000o0(LogType.HOME_ROOM, "zzzOnError ", th.getMessage());
                        }
                    });
                    gsy.O00000Oo(LogType.MAIN_PAGE, "DeviceMainPage", "registerClientDeviceListener: ");
                    this.O0000o0O = fno.O000000o().O0000o00();
                    fno.O000000o().O000000o(this.O000Oo0o);
                    if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                        O0000Oo();
                    }
                    IntentFilter intentFilter = new IntentFilter("force_update_data_completed");
                    intentFilter.addAction("com.smarthome.refresh_list_view");
                    intentFilter.addAction("home_room_updated");
                    intentFilter.addAction("user_mgr_user_info_updated");
                    intentFilter.addAction(CommonActivity.ACTION_SPLIT_SCREEN_MODE_CHANGED);
                    intentFilter.addAction("home_room_home_changed");
                    intentFilter.addAction("action_business_data_ready");
                    intentFilter.addAction("category_info_updated_action");
                    intentFilter.addAction("force_update_data");
                    intentFilter.addAction("switch_refresh_success");
                    ft.O000000o(getContext()).O000000o(this.O000Oo00, intentFilter);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.newui.DeviceListPageActionInterface");
                }
            }
            this.O0000o0 = false;
            return this.f17283O000000o;
        }

        public final void O00000o0() {
            List<fca.O000000o> list;
            if (this.O000OO0o && ServiceApplication.getStateNotifier().f15923O000000o == 4 && (list = fca.O000000o().f16062O000000o.get(1L)) != null && list.size() > 0) {
                for (final fca.O000000o o000000o : list) {
                    if (!TextUtils.isEmpty(o000000o.O00000Oo) && o000000o.O0000Oo != null) {
                        fca.O000000o();
                        if (fca.O000000o(o000000o)) {
                            fca.O000000o();
                            if (fca.O00000Oo(o000000o)) {
                                final Uri parse = Uri.parse(o000000o.O00000Oo);
                                fca O000000o2 = fca.O000000o();
                                AnonymousClass25 r3 = new fsm<Boolean, fso>() {
                                    /* class _m_j.gzs.AnonymousClass25 */

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        if (((Boolean) obj).booleanValue()) {
                                            gzs.this.O000000o(o000000o);
                                            return;
                                        }
                                        fca O000000o2 = fca.O000000o();
                                        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(parse).setProgressiveRenderingEnabled(true).build(), ServiceApplication.getAppContext()).subscribe(new BaseBitmapDataSubscriber(true) {
                                            /* class _m_j.fca.AnonymousClass4 */

                                            /* renamed from: O000000o */
                                            final /* synthetic */ boolean f16069O000000o = true;

                                            public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                                            }

                                            public final void onNewResultImpl(Bitmap bitmap) {
                                                if (this.f16069O000000o) {
                                                    ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("action_business_data_ready"));
                                                }
                                            }
                                        }, CallerThreadExecutor.getInstance());
                                    }

                                    public final void onFailure(fso fso) {
                                        if (fso != null) {
                                            gsy.O00000Oo("refreshBusinessView", fso.O00000Oo);
                                        }
                                        gzs.this.O000000o(o000000o);
                                    }
                                };
                                if (parse != null) {
                                    ImagePipeline imagePipeline = Fresco.getImagePipeline();
                                    if (imagePipeline.isInBitmapMemoryCache(parse)) {
                                        r3.onSuccess(Boolean.TRUE);
                                        return;
                                    } else {
                                        imagePipeline.isInDiskCache(parse).subscribe(new BaseDataSubscriber<Boolean>(r3) {
                                            /* class _m_j.fca.AnonymousClass3 */

                                            /* renamed from: O000000o */
                                            final /* synthetic */ fsm f16065O000000o;

                                            {
                                                this.f16065O000000o = r2;
                                            }

                                            public final void onNewResultImpl(DataSource<Boolean> dataSource) {
                                                if (dataSource == null || !dataSource.isFinished()) {
                                                    ServiceApplication.getGlobalHandler().post(new Runnable() {
                                                        /* class _m_j.fca.AnonymousClass3.AnonymousClass1 */

                                                        public final void run() {
                                                            AnonymousClass3.this.f16065O000000o.onFailure(new fso(-1, "dataSource finished"));
                                                        }
                                                    });
                                                }
                                                final boolean booleanValue = dataSource.getResult().booleanValue();
                                                ServiceApplication.getGlobalHandler().post(new Runnable() {
                                                    /* class _m_j.fca.AnonymousClass3.AnonymousClass2 */

                                                    public final void run() {
                                                        AnonymousClass3.this.f16065O000000o.onSuccess(Boolean.valueOf(booleanValue));
                                                    }
                                                });
                                            }

                                            public final void onFailureImpl(DataSource<Boolean> dataSource) {
                                                ServiceApplication.getGlobalHandler().post(new Runnable() {
                                                    /* class _m_j.fca.AnonymousClass3.AnonymousClass3 */

                                                    public final void run() {
                                                        AnonymousClass3.this.f16065O000000o.onFailure(new fso(-1, "dataSource FailureImpl"));
                                                    }
                                                });
                                            }
                                        }, CallerThreadExecutor.getInstance());
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void}
         arg types: [android.view.View, int, int, int]
         candidates:
          ClspMth{android.widget.PopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void}
          ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void} */
        public final void O000000o(final fca.O000000o o000000o) {
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isFinishing()) {
                PopupWindow popupWindow = this.O0000o0o;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    View inflate = activity.getLayoutInflater().inflate((int) R.layout.home_page_interstitial_popup_window, (ViewGroup) null);
                    this.O0000o0o = new PopupWindow(inflate, -1, -1, true);
                    this.O0000o0o.setTouchable(true);
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) inflate.findViewById(R.id.business_image);
                    Uri parse = Uri.parse(o000000o.O00000Oo);
                    simpleDraweeView.setHierarchy(GenericDraweeHierarchyBuilder.newInstance(getResources()).setFadeDuration(200).setRoundingParams(RoundingParams.fromCornersRadius(15.0f)).setPlaceholderImage(getResources().getDrawable(R.drawable.device_list_phone_no)).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build());
                    simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setUri(parse).build());
                    inflate.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                        /* class _m_j.gzs.AnonymousClass26 */

                        public final void onClick(View view) {
                            if (gzs.this.O0000o0o != null && gzs.this.O0000o0o.isShowing()) {
                                gzs.this.O0000o0o.dismiss();
                            }
                        }
                    });
                    inflate.findViewById(R.id.click_more).setOnClickListener(new View.OnClickListener() {
                        /* class _m_j.gzs.AnonymousClass27 */

                        public final void onClick(View view) {
                            fca.O000000o();
                            fca.O00000o0(o000000o);
                            gzs.this.O0000oo.postDelayed(new Runnable() {
                                /* class _m_j.gzs.AnonymousClass27.AnonymousClass1 */

                                public final void run() {
                                    if (gzs.this.O0000o0o != null && gzs.this.O0000o0o.isShowing()) {
                                        try {
                                            gzs.this.O0000o0o.dismiss();
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            }, 1000);
                        }
                    });
                    try {
                        this.O0000o0o.showAtLocation(this.f17283O000000o, 17, -1, -1);
                        fca.O000000o();
                        long j = o000000o.f16070O000000o;
                        long currentTimeMillis = System.currentTimeMillis();
                        SharedPreferences sharedPreferences = ServiceApplication.getAppContext().getSharedPreferences("smart_home_business_config", 0);
                        sharedPreferences.edit().putLong(fca.O000000o(1, j), currentTimeMillis).apply();
                    } catch (Exception unused) {
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view, Boolean bool) throws Exception {
            if (isValid()) {
                view.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000o0(View view) {
            if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                new ChangeHomePopupWindow(getActivity(), this.O000O0o).e_();
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean O00000Oo(String str) throws Exception {
            boolean O00000oo2 = gsc.O00000oo(str);
            if (!O00000oo2) {
                LogType logType = LogType.HOME_ROOM;
                gsy.O00000o0(logType, "zzztest: ", "path " + str + " fileExists = false");
            }
            return O00000oo2;
        }

        public final void O00000o() {
            MainPageAppBarLayout mainPageAppBarLayout = this.O0000OOo;
            CoordinatorLayout coordinatorLayout = this.O0000O0o;
            if (mainPageAppBarLayout.O00000oO != null) {
                mainPageAppBarLayout.O00000oO.expand(coordinatorLayout, mainPageAppBarLayout);
            }
        }

        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
        }

        public void O00000oO() {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0000Ooo, "scaleX", 0.9f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.O0000Ooo, "scaleY", 0.9f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f17283O000000o, "alpha", 0.0f, 1.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.O0000OoO, "scaleX", 0.9f, 1.0f);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.O0000OoO, "scaleY", 0.9f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.O0000OoO, "translationY", (((float) this.O0000Ooo.getHeight()) * 0.100000024f) / 2.0f, 0.0f);
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat6);
            animatorSet.start();
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            String stringExtra;
            if ((i == O000O00o && i2 == -1) || i != 4 || i2 != -1 || (stringExtra = intent.getStringExtra("QRDebug")) == null) {
                return;
            }
            if (hmq.O000000o().isExperiencePluginQRCode(stringExtra)) {
                Intent intent2 = new Intent(getContext(), hmq.O000000o().getLoadingRNActivityClass());
                intent2.putExtra("activity_start_from", 1002);
                intent2.putExtra(fvt.O00000oo, "mock.did.xiaomi.demo");
                intent2.putExtra(fvt.O0000O0o, MockRnDevicePluginManager.getInstance().getMockPluginDownloadUrl("mock.did.xiaomi.demo"));
                intent2.putExtra("pageName", "OfficialDemos");
                exz exz = exz.f15941O000000o;
                exz.O000000o(intent2, "mock.model.xiaomi.demo");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("isBackToMainPage", Boolean.FALSE);
                } catch (JSONException unused) {
                }
                intent2.putExtra("pageParams", jSONObject.toString());
                startActivity(intent2);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(stringExtra);
                if (this.O000OO00 == null) {
                    this.O000OO00 = (DraggingButton) ((ViewStub) this.f17283O000000o.findViewById(R.id.debug_dragbutton)).inflate().findViewById(R.id.drag_button_main_debug);
                } else {
                    this.O000OO00.setVisibility(0);
                }
                String optString = jSONObject2.optString(fvt.O0000OOo);
                String str = optString + ":8081";
                hmq.O000000o().initQrDebugMode(str, jSONObject2.optString(fvt.O0000Oo0));
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
                edit.putString("debug_http_host", str);
                edit.apply();
                this.O000OO00.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.$$Lambda$gzs$GRBTyxGWoafpYnBPrTQmnuQdR4Q */

                    public final void onClick(View view) {
                        gzs.this.O000000o(view);
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void onSwitchtoPage(int i, boolean z) {
            O000000o(z);
            if (z) {
                this.O000OoO0 = hxi.O00000o0.O000000o(0L);
            } else if (this.O000OoO0 > 0) {
                hxi.O00000o0.O000000o(this.O000OoO0);
                this.O000OoO0 = 0;
            }
            this.O000OO0o = z;
            MainPageAppBarLayout mainPageAppBarLayout = this.O0000OOo;
            if (!(mainPageAppBarLayout == null || !this.O000OO0o || mainPageAppBarLayout.f10315O000000o == null)) {
                hxi.O00000oO.f958O000000o.O000000o("home_device_popup", new Object[0]);
            }
            O00000o0();
            if (!z) {
                O0000oO0();
            }
            if (!z) {
                this.O00000oo = true;
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                hic O000000o2 = hic.O000000o(activity);
                if (z != O000000o2.O00000Oo) {
                    O000000o2.O00000Oo = z;
                    if (z) {
                        O000000o2.O000000o();
                    }
                }
            }
        }

        public void onPause() {
            super.onPause();
            this.O000OOo = false;
            if (this.O000Oo0O) {
                hna.O00000o0().doScanOnPause(this);
                this.O000Oo0O = false;
            }
        }

        public void onResume() {
            super.onResume();
            O0000OOo();
            this.O000O0oO.sendAccessibilityEvent(8);
            this.O000OOo = true;
            this.O0000oo.postDelayed(new Runnable() {
                /* class _m_j.gzs.AnonymousClass13 */

                public final void run() {
                    if (!gzs.this.O0000o0 && gzs.this.isValid()) {
                        if (fqw.O00000o0()) {
                            gor.O000000o(new AsyncTask<Object, Object, Object>() {
                                /* class _m_j.gzs.AnonymousClass13.AnonymousClass1 */

                                /* access modifiers changed from: protected */
                                public final Object doInBackground(Object... objArr) {
                                    try {
                                        fqw.O000000o(CommonApplication.getAppContext());
                                        return null;
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                        return null;
                                    }
                                }

                                /* access modifiers changed from: protected */
                                public final void onPostExecute(Object obj) {
                                    if (gzs.this.isValid()) {
                                        gzs.this.O00000oo();
                                    }
                                }
                            }, new Object[0]);
                        }
                        if (gzs.this.O0000oO0 == null) {
                            gzs.this.O0000oO0 = new fnr();
                        }
                        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                            gsy.O00000Oo("forceUpdateAllData", "startRefresh STATE_LOGIN_SUCCESS");
                            gzs.this.O00000Oo(false);
                        }
                        gtj.O000000o().O00000Oo();
                    }
                }
            }, 1000);
            Device device = DeviceRenderer.mClickedDevice;
            if (device != null) {
                DeviceRenderer.get(device).refreshClickedDeviceDesc();
            }
            if (this.O000OO0o) {
                if (!this.O00000oo && !ggb.O0000o00()) {
                    this.O0000oo.sendEmptyMessageDelayed(1, 2000);
                }
                if (!fno.O000000o().O0000o0()) {
                    O0000o0O();
                }
            }
            if (this.O000Oo0O) {
                hna.O00000o0().doScanOnResume(this);
            }
            gva.O000000o().setRedPointView("red_point_message_center", new gus() {
                /* class _m_j.gzs.AnonymousClass14 */

                public final void showRedPoint(boolean z) {
                    if (gzs.this.O0000ooO != null) {
                        gzs.this.O0000oo.post(new Runnable(z) {
                            /* class _m_j.$$Lambda$gzs$14$PwCqj01DfHn8XjSF5LAJUYsEmtA */
                            private final /* synthetic */ boolean f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                gzs.AnonymousClass14.this.O000000o(this.f$1);
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(boolean z) {
                    gzs.this.O0000ooO.setVisibility((!z || ServiceApplication.getStateNotifier().f15923O000000o != 4) ? 8 : 0);
                }
            });
            CoreApi.O000000o().O000000o(getContext(), new CoreApi.O0000o0() {
                /* class _m_j.gzs.AnonymousClass15 */

                public final void onCoreReady() {
                    gsy.O00000o0(LogType.KUAILIAN, "wugan", "start check zero-link success state");
                    hsw.O000000o().checkMsgAlert((BaseActivity) gzs.this.getActivity(), 11);
                }
            });
            Room room = ggb.O00000Oo().O0000o0;
            if (room == null) {
                hxf.O000000o().O000000o(ggb.O00000Oo().O0000OOo(), "mijia.roomid.common");
            } else {
                hxf.O000000o().O000000o(ggb.O00000Oo().O0000OOo(), room.getId());
            }
        }

        public final void O00000Oo(boolean z) {
            gsj gsj;
            gsj gsj2;
            String str;
            boolean z2 = z;
            String str2 = "_preview";
            gsy.O00000Oo("forceUpdateAllData", "startRefresh " + z2 + ",loginstate=" + ServiceApplication.getStateNotifier().f15923O000000o);
            if (this.O00000o) {
                ft.O000000o(getContext()).O000000o(new Intent("force_update_data_completed"));
            } else if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                if (z2) {
                    LogType logType = LogType.MAIN_PAGE;
                    gsy.O00000Oo(logType, "forceUpdateAllData", "forceUpdate getCurrentState=" + ServiceApplication.getStateNotifier().f15923O000000o);
                    if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("force_update_data_completed"));
                    } else {
                        boolean O00000oO2 = ggb.O00000Oo().O00000oO();
                        gsy.O00000Oo("forceUpdateAllData", "forceUpdate isTransferred=".concat(String.valueOf(O00000oO2)));
                        if (O00000oO2) {
                            LogType logType2 = LogType.MAIN_PAGE;
                            gsy.O00000Oo(logType2, "forceUpdateAllData", "HomeManager forceUpdateAllData start mIsDeviceDataReady=" + this.O0000o0O + ",DeviceManager isInited=" + fno.O000000o().O0000o00());
                            ggb.O00000Oo().O000000o(!this.O0000o0O && fno.O000000o().O0000o00());
                            if (this.O0000o0O) {
                                ((gzz) fo.O000000o((FragmentActivity) Objects.requireNonNull(getActivity())).O000000o(gzz.class)).O00000Oo(ggb.O00000Oo().O0000OOo());
                                ((gzz) fo.O000000o((FragmentActivity) Objects.requireNonNull(getActivity())).O000000o(gzz.class)).O000000o(ggb.O00000Oo().O0000OOo());
                            }
                        } else {
                            ggb.O00000Oo().O000000o(new ggb.O00000o() {
                                /* class _m_j.gzs.AnonymousClass11 */

                                public final void O000000o(int i, fso fso) {
                                }

                                public final void O000000o() {
                                    if (gzs.this.isValid()) {
                                        if (ggb.O00000Oo().O00000oO()) {
                                            ggb.O00000Oo().O000000o(false);
                                            if (gzs.this.O0000o0O) {
                                                ((gzz) fo.O000000o((FragmentActivity) Objects.requireNonNull(gzs.this.getActivity())).O000000o(gzz.class)).O00000Oo(ggb.O00000Oo().O0000OOo());
                                                ((gzz) fo.O000000o((FragmentActivity) Objects.requireNonNull(gzs.this.getActivity())).O000000o(gzz.class)).O000000o(ggb.O00000Oo().O0000OOo());
                                                return;
                                            }
                                            return;
                                        }
                                        gsy.O00000Oo(LogType.MAIN_PAGE, "forceUpdateAllData", "transfer complete, but state is wrong!!");
                                    }
                                }
                            });
                        }
                    }
                }
                if (this.O000OO) {
                    this.O000OO = false;
                    gsy.O00000Oo("forceUpdateAllData", "startRefresh SmartHomeDeviceManager inited=".concat(String.valueOf(fno.O000000o().O0000o00())));
                    gzz gzz = (gzz) fo.O000000o((FragmentActivity) Objects.requireNonNull(getActivity())).O000000o(gzz.class);
                    String O0000OOo2 = ggb.O00000Oo().O0000OOo();
                    if (gzz.O00000o0 == null) {
                        gzz.O00000o0 = ServiceApplication.getAppContext().getSharedPreferences("home_env_info", 0);
                    }
                    try {
                        SharedPreferences sharedPreferences = gzz.O00000o0;
                        String string = sharedPreferences.getString(O0000OOo2 + "top_data", "");
                        if (TextUtils.isEmpty(string)) {
                            gsy.O00000Oo(gzz.f18676O000000o, "readTopInfoCache: empty!");
                        } else {
                            hgu O000000o2 = hgu.O000000o(new JSONObject(string));
                            Map value = gzz.O0000OoO.getValue();
                            if (value == null) {
                                value = new HashMap();
                            }
                            value.put(O0000OOo2, O000000o2);
                            gzz.O0000OoO.postValue(value);
                            gsy.O00000Oo(gzz.f18676O000000o, "readTopInfoCache : ".concat(String.valueOf(string)));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                fbv.O000000o().O00000Oo();
                gtf.O000000o().O00000Oo();
                hsl.O00000Oo().forceRefresh();
                gtj.O000000o().O00000o0();
                ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
                    /* class _m_j.gzs.AnonymousClass18 */

                    public final void run() {
                        if (gzs.this.isValid()) {
                            gva.O000000o().checkNewMessage();
                            gva.O000000o().checkFeedback();
                        }
                    }
                });
                fca O000000o3 = fca.O000000o();
                if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                    ArrayList arrayList = new ArrayList();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("preview", gfr.O0000oo0);
                    } catch (JSONException unused) {
                    }
                    arrayList.add(new com.xiaomi.smarthome.core.entity.net.KeyValuePair("data", jSONObject.toString()));
                    NetRequest O000000o4 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/service/getactivityconfig").O000000o(arrayList).O000000o();
                    fca.AnonymousClass1 r10 = new fsm<String, fso>() {
                        /* class _m_j.fca.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONArray jSONArray;
                            JSONArray jSONArray2;
                            JSONArray jSONArray3;
                            String str = (String) obj;
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    fca fca = fca.this;
                                    HashMap hashMap = new HashMap();
                                    if (!TextUtils.isEmpty(str)) {
                                        try {
                                            JSONArray jSONArray4 = new JSONArray(str);
                                            if (jSONArray4.length() > 0) {
                                                int i = 0;
                                                while (i < jSONArray4.length()) {
                                                    JSONObject optJSONObject = jSONArray4.optJSONObject(i);
                                                    if (optJSONObject != null) {
                                                        long j = -1;
                                                        long optLong = optJSONObject.optLong("business_id", -1);
                                                        JSONArray optJSONArray = optJSONObject.optJSONArray("business_content");
                                                        if (!(optLong == -1 || optJSONArray == null || optJSONArray.length() <= 0)) {
                                                            ArrayList arrayList = new ArrayList();
                                                            int i2 = 0;
                                                            while (i2 < optJSONArray.length()) {
                                                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                                                if (optJSONObject2 != null) {
                                                                    long optLong2 = optJSONObject2.optLong("content_id", j);
                                                                    int optInt = optJSONObject2.optInt("start_version_code", -1);
                                                                    int optInt2 = optJSONObject2.optInt("end_version_code", -1);
                                                                    int i3 = gfr.O00000oO;
                                                                    if (optLong2 != -1) {
                                                                        jSONArray2 = jSONArray4;
                                                                        if ((optInt == -1 || optInt <= i3) && (optInt2 == -1 || i3 <= optInt2)) {
                                                                            O000000o o000000o = new O000000o();
                                                                            o000000o.f16070O000000o = optLong2;
                                                                            o000000o.O00000Oo = optJSONObject2.optString("image_url");
                                                                            o000000o.O00000o0 = optJSONObject2.optString("press_image_url");
                                                                            o000000o.O00000o = optJSONObject2.optLong("start_date", -1);
                                                                            o000000o.O00000oO = optJSONObject2.optLong("end_date", -1);
                                                                            o000000o.O00000oo = optJSONObject2.optLong("start_time", -1);
                                                                            o000000o.O0000O0o = optJSONObject2.optLong("end_time", -1);
                                                                            o000000o.O0000OOo = optJSONObject2.optInt("frequency", 0);
                                                                            o000000o.O0000Oo0 = optJSONObject2.optBoolean("permanent", false);
                                                                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("target");
                                                                            if (optJSONObject3 != null) {
                                                                                O00000Oo o00000Oo = new O00000Oo();
                                                                                o00000Oo.f16071O000000o = optJSONObject3.optInt("type", -1);
                                                                                o00000Oo.O00000Oo = optJSONObject3.optString("title");
                                                                                o00000Oo.O00000o0 = optJSONObject3.optString("url");
                                                                                o00000Oo.O00000o = optJSONObject3.optString("package_name");
                                                                                o00000Oo.O00000oO = optJSONObject3.optString("action");
                                                                                o00000Oo.O00000oo = optJSONObject3.optString("class_name");
                                                                                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("params_string");
                                                                                if (optJSONObject4 != null) {
                                                                                    HashMap hashMap2 = new HashMap();
                                                                                    Iterator<String> keys = optJSONObject4.keys();
                                                                                    while (keys.hasNext()) {
                                                                                        String next = keys.next();
                                                                                        JSONArray jSONArray5 = optJSONArray;
                                                                                        String optString = optJSONObject4.optString(next);
                                                                                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                                                                                            hashMap2.put(next, optString);
                                                                                        }
                                                                                        optJSONArray = jSONArray5;
                                                                                    }
                                                                                    jSONArray3 = optJSONArray;
                                                                                    o00000Oo.O0000O0o = hashMap2;
                                                                                } else {
                                                                                    jSONArray3 = optJSONArray;
                                                                                }
                                                                                JSONObject optJSONObject5 = optJSONObject3.optJSONObject("params_bool");
                                                                                if (optJSONObject5 != null) {
                                                                                    HashMap hashMap3 = new HashMap();
                                                                                    Iterator<String> keys2 = optJSONObject5.keys();
                                                                                    while (keys2.hasNext()) {
                                                                                        String next2 = keys2.next();
                                                                                        boolean optBoolean = optJSONObject5.optBoolean(next2);
                                                                                        if (!TextUtils.isEmpty(next2)) {
                                                                                            hashMap3.put(next2, Boolean.valueOf(optBoolean));
                                                                                        }
                                                                                    }
                                                                                    o00000Oo.O0000OOo = hashMap3;
                                                                                }
                                                                                JSONObject optJSONObject6 = optJSONObject3.optJSONObject("params_int");
                                                                                if (optJSONObject6 != null) {
                                                                                    HashMap hashMap4 = new HashMap();
                                                                                    Iterator<String> keys3 = optJSONObject6.keys();
                                                                                    while (keys3.hasNext()) {
                                                                                        String next3 = keys3.next();
                                                                                        int optInt3 = optJSONObject6.optInt(next3);
                                                                                        if (!TextUtils.isEmpty(next3)) {
                                                                                            hashMap4.put(next3, Integer.valueOf(optInt3));
                                                                                        }
                                                                                    }
                                                                                    o00000Oo.O0000Oo0 = hashMap4;
                                                                                }
                                                                                JSONObject optJSONObject7 = optJSONObject3.optJSONObject("params_long");
                                                                                if (optJSONObject7 != null) {
                                                                                    HashMap hashMap5 = new HashMap();
                                                                                    Iterator<String> keys4 = optJSONObject7.keys();
                                                                                    while (keys4.hasNext()) {
                                                                                        String next4 = keys4.next();
                                                                                        long optLong3 = optJSONObject7.optLong(next4);
                                                                                        if (!TextUtils.isEmpty(next4)) {
                                                                                            hashMap5.put(next4, Long.valueOf(optLong3));
                                                                                        }
                                                                                    }
                                                                                    o00000Oo.O0000Oo = hashMap5;
                                                                                }
                                                                                JSONObject optJSONObject8 = optJSONObject3.optJSONObject("params_double");
                                                                                if (optJSONObject8 != null) {
                                                                                    HashMap hashMap6 = new HashMap();
                                                                                    Iterator<String> keys5 = optJSONObject8.keys();
                                                                                    while (keys5.hasNext()) {
                                                                                        String next5 = keys5.next();
                                                                                        double optDouble = optJSONObject8.optDouble(next5);
                                                                                        if (!TextUtils.isEmpty(next5)) {
                                                                                            hashMap6.put(next5, Double.valueOf(optDouble));
                                                                                        }
                                                                                    }
                                                                                    o00000Oo.O0000OoO = hashMap6;
                                                                                }
                                                                                JSONObject optJSONObject9 = optJSONObject3.optJSONObject("params_float");
                                                                                if (optJSONObject9 != null) {
                                                                                    HashMap hashMap7 = new HashMap();
                                                                                    Iterator<String> keys6 = optJSONObject9.keys();
                                                                                    while (keys6.hasNext()) {
                                                                                        String next6 = keys6.next();
                                                                                        String optString2 = optJSONObject9.optString(next6);
                                                                                        if (!TextUtils.isEmpty(next6) && !TextUtils.isEmpty(optString2)) {
                                                                                            try {
                                                                                                hashMap7.put(next6, Float.valueOf(Float.valueOf(optString2).floatValue()));
                                                                                            } catch (Exception unused) {
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    o00000Oo.O0000Ooo = hashMap7;
                                                                                }
                                                                                o000000o.O0000Oo = o00000Oo;
                                                                            } else {
                                                                                jSONArray3 = optJSONArray;
                                                                            }
                                                                            arrayList.add(o000000o);
                                                                            i2++;
                                                                            optJSONArray = jSONArray3;
                                                                            jSONArray4 = jSONArray2;
                                                                            j = -1;
                                                                        }
                                                                        jSONArray3 = optJSONArray;
                                                                        i2++;
                                                                        optJSONArray = jSONArray3;
                                                                        jSONArray4 = jSONArray2;
                                                                        j = -1;
                                                                    }
                                                                }
                                                                jSONArray2 = jSONArray4;
                                                                jSONArray3 = optJSONArray;
                                                                i2++;
                                                                optJSONArray = jSONArray3;
                                                                jSONArray4 = jSONArray2;
                                                                j = -1;
                                                            }
                                                            jSONArray = jSONArray4;
                                                            hashMap.put(Long.valueOf(optLong), arrayList);
                                                            i++;
                                                            jSONArray4 = jSONArray;
                                                        }
                                                    }
                                                    jSONArray = jSONArray4;
                                                    i++;
                                                    jSONArray4 = jSONArray;
                                                }
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    fca.f16062O000000o = hashMap;
                                    ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("action_business_data_ready"));
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            } else {
                                fca.this.f16062O000000o = new HashMap();
                            }
                        }
                    };
                    CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), O000000o4, new fss<String>() {
                        /* class _m_j.fca.AnonymousClass2 */

                        public final /* synthetic */ Object parse(JSONObject jSONObject) {
                            gsy.O00000Oo("SHBusinessManager", "response = " + jSONObject.toString());
                            JSONObject optJSONObject = jSONObject.optJSONObject("content");
                            return optJSONObject != null ? optJSONObject.optString("business_config") : "";
                        }
                    }, Crypto.RC4, r10);
                }
                fbx O000000o5 = fbx.O000000o();
                ArrayList arrayList2 = new ArrayList();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("lang", "zh_CN");
                    StringBuilder sb = new StringBuilder("common_extra_config");
                    if (gfr.O0000oo0) {
                        str = str2;
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    jSONObject2.put("name", sb.toString());
                    jSONObject2.put("version", "1");
                } catch (Exception unused2) {
                }
                arrayList2.add(new com.xiaomi.smarthome.core.entity.net.KeyValuePair("data", jSONObject2.toString()));
                try {
                    gsj.O000000o o000000o = new gsj.O000000o();
                    o000000o.f18212O000000o = "GET";
                    gsj = o000000o.O00000Oo(hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject2.toString(), "UTF-8")).O000000o();
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    gsj = null;
                }
                if (gsj != null) {
                    gsg.O00000Oo(gsj, new gsl() {
                        /* class _m_j.fbx.AnonymousClass1 */

                        public final void onFailure(gsf gsf, Exception exc, Response response) {
                        }

                        public final void onSuccess(Object obj, Response response) {
                        }

                        public final void processFailure(Call call, IOException iOException) {
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.Object} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: org.json.JSONObject} */
                        /* JADX WARNING: Multi-variable type inference failed */
                        public final void processResponse(Response response) {
                            try {
                                JSONObject jSONObject = new JSONObject(response.body().string());
                                if (!jSONObject.isNull("result")) {
                                    JSONObject optJSONObject = jSONObject.optJSONObject("result");
                                    LogType logType = LogType.NETWORK;
                                    gsy.O000000o(logType, "CommonExtraConfigManager", "getRemoteConfig  result" + optJSONObject.toString());
                                    if (!optJSONObject.isNull("content")) {
                                        JSONObject jSONObject2 = null;
                                        Object obj = optJSONObject.get("content");
                                        if (obj instanceof JSONObject) {
                                            jSONObject2 = obj;
                                        } else if (obj instanceof String) {
                                            jSONObject2 = new JSONObject((String) obj);
                                        }
                                        if (jSONObject2 != null) {
                                            if (!jSONObject2.isNull("filter_model_config")) {
                                                HashMap hashMap = new HashMap();
                                                JSONArray optJSONArray = jSONObject2.optJSONArray("filter_model_config");
                                                if (optJSONArray != null) {
                                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                                        String optString = optJSONArray.getJSONObject(i).optString("request_model");
                                                        JSONArray optJSONArray2 = optJSONArray.getJSONObject(i).optJSONArray("filter_model");
                                                        if (!TextUtils.isEmpty(optString) && optJSONArray2 != null && optJSONArray2.length() > 0) {
                                                            ArrayList arrayList = new ArrayList();
                                                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                                                arrayList.add(optJSONArray2.getString(i2));
                                                            }
                                                            hashMap.put(optString, arrayList);
                                                        }
                                                    }
                                                }
                                                fbx.this.f16054O000000o = hashMap;
                                                return;
                                            }
                                            fbx.this.f16054O000000o = new HashMap();
                                        }
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    });
                }
                fcc O000000o6 = fcc.O000000o();
                ArrayList arrayList3 = new ArrayList();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("lang", "zh_CN");
                    StringBuilder sb2 = new StringBuilder("local_timer_config");
                    if (!gfr.O0000oo0) {
                        str2 = "";
                    }
                    sb2.append(str2);
                    jSONObject3.put("name", sb2.toString());
                    jSONObject3.put("version", "1");
                } catch (Exception unused3) {
                }
                arrayList3.add(new com.xiaomi.smarthome.core.entity.net.KeyValuePair("data", jSONObject3.toString()));
                try {
                    gsj.O000000o o000000o2 = new gsj.O000000o();
                    o000000o2.f18212O000000o = "GET";
                    gsj2 = o000000o2.O00000Oo(hsk.O000000o(ServiceApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject3.toString(), "UTF-8")).O000000o();
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                    gsj2 = null;
                }
                if (gsj2 != null) {
                    gsg.O00000Oo(gsj2, new gsl() {
                        /* class _m_j.fcc.AnonymousClass1 */

                        public final void onFailure(gsf gsf, Exception exc, Response response) {
                        }

                        public final void onSuccess(Object obj, Response response) {
                        }

                        public final void processFailure(Call call, IOException iOException) {
                        }

                        public final void processResponse(Response response) {
                            JSONObject optJSONObject;
                            try {
                                JSONObject jSONObject = new JSONObject(response.body().string());
                                if (!jSONObject.isNull("result") && (optJSONObject = jSONObject.optJSONObject("result")) != null && optJSONObject.has("content")) {
                                    JSONArray jSONArray = new JSONArray(optJSONObject.optString("content"));
                                    ArrayList arrayList = new ArrayList();
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        String optString = jSONArray.optString(i);
                                        if (!TextUtils.isEmpty(optString)) {
                                            arrayList.add(optString);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        fcc.this.f16073O000000o.clear();
                                        fcc.this.f16073O000000o.addAll(arrayList);
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            } else if (ServiceApplication.getStateNotifier().f15923O000000o == 3) {
                ft.O000000o(getContext()).O000000o(new Intent("force_update_data_completed"));
            }
        }

        public void onDestroyView() {
            this.O0000o0 = true;
            super.onDestroyView();
            fju.O000000o().O00000Oo(this.O000OOoo);
            MyViewPager myViewPager = this.O0000Ooo;
            myViewPager.O00000o.dispose();
            MyIndicator myIndicator = myViewPager.O00000Oo;
            if (myIndicator != null) {
                myIndicator.O00000Oo.clear();
                Iterator O000000o2 = iye.O000000o(gzw.O000000o(myViewPager), MyViewPager$dispose$$inlined$filterIsInstance$1.f10372O000000o).O000000o();
                while (O000000o2.hasNext()) {
                    ((RecyclerView) O000000o2.next()).setAdapter(null);
                }
                haj roomAdapter = myViewPager.getRoomAdapter();
                if (roomAdapter != null) {
                    roomAdapter.O00000Oo();
                }
                haj roomAdapter2 = myViewPager.getRoomAdapter();
                if (roomAdapter2 != null) {
                    roomAdapter2.O00000Oo(myViewPager.O0000O0o);
                }
                myViewPager.setAdapter(null);
                return;
            }
            ixe.O000000o("indicator");
            throw null;
        }

        public void onStop() {
            super.onStop();
            CameraRouterFactory.getCameraManagerApi().saveSeqToSPCameraOperationUtils();
        }

        public void onDestroy() {
            haj roomAdapter;
            super.onDestroy();
            CameraRouterFactory.getCameraManagerApi().addExceptionCamerasFloatWindow();
            CameraRouterFactory.getCameraManagerApi().disconnectAllXmStreamClient();
            this.O000OO = true;
            this.O0000oo.removeCallbacksAndMessages(null);
            hsl.O00000Oo().destroyDeviceListSwitch();
            fno.O000000o().O00000Oo(this.O000Oo0o);
            try {
                ft.O000000o(getContext()).O000000o(this.O000Oo00);
                if (this.O000Oo0 != null && !this.O000Oo0.isDisposed()) {
                    this.O000Oo0.dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.O00000oo = true;
            gtt O000000o2 = gtt.O000000o();
            gtt.O00000o = null;
            O000000o2.O0000O0o = true;
            if (O000000o2.O00000oo != null) {
                O000000o2.O00000oo.sendEmptyMessage(2);
            }
            XQProgressDialog xQProgressDialog = this.O00000o0;
            if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
                this.O00000o0.dismiss();
            }
            MLAlertDialog mLAlertDialog = this.O00000oO;
            if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
                this.O00000oO.dismiss();
            }
            MijiaLoginManager.O000000o().f7521O000000o.remove(this.O000OoOO);
            hmq.O000000o().exitQRDebugMode();
            had O00000oO2 = had.O00000oO();
            MyViewPager myViewPager = O00000oO2.O00000Oo;
            if (!(myViewPager == null || (roomAdapter = myViewPager.getRoomAdapter()) == null)) {
                roomAdapter.O00000Oo(O00000oO2.O0000OOo);
            }
            O00000oO2.O00000o.dispose();
            had.O0000Oo0 = null;
            this.O00000Oo.clear();
        }

        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            this.O0000oo.postDelayed(new Runnable() {
                /* class _m_j.gzs.AnonymousClass16 */

                public final void run() {
                    if (!gzs.this.O00oOoOo.get()) {
                        gzs.this.O00000Oo(true);
                    }
                }
            }, 1000);
            this.O00000Oo.add(Observable.merge(gzq.O000000o().map($$Lambda$gzs$LuXbXYeINNuR6GEtRygH0mUJA.INSTANCE), gzq.O00000Oo().map($$Lambda$gzs$4n3rXC58AKCjXe8P0vSHWuOjAzM.INSTANCE), gzq.O00000o0().map($$Lambda$gzs$6VvgoYQ6lx1tSNyPIEORqoROdQ.INSTANCE)).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class _m_j.$$Lambda$gzs$m6U9fgZj1zBcWvjOsa7DbdtlZCM */

                public final void accept(Object obj) {
                    gzs.this.O000000o((Boolean) obj);
                }
            }));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(Boolean bool) throws Exception {
            EditMaskView editMaskView = this.O000OOoO;
            if (editMaskView != null) {
                editMaskView.setAlpha(bool.booleanValue() ? 1.0f : 0.0f);
                this.O000OOoO.setShouldMask(bool.booleanValue());
            }
        }

        public void refreshTitleBar() {
            gwg.O00000Oo(getActivity().getWindow());
        }

        public void onClickCommonUseDevice(Device device, RectF rectF, String str) {
            FragmentActivity activity = getActivity();
            if (activity != null && isValid()) {
                DeviceMainPageRouterFactory.getSmartHomeMainActivityProvider().onClickCommonUseDevice(activity, device, rectF, str);
            }
        }

        private DeviceEditPage O0000Ooo() {
            if (this.O00O0Oo == null) {
                this.O00O0Oo = new DeviceEditPage(getActivity(), new DeviceEditPage.O000000o() {
                    /* class _m_j.$$Lambda$gzs$Vbr2Dtfa5kzdJW7pt8C3gYYL5VU */

                    public final void onExit() {
                        gzs.this.O0000oO0();
                    }
                });
            }
            return this.O00O0Oo;
        }

        public void enterEditMode(DviceEditInterface dviceEditInterface) {
            if (!this.O00000o && dviceEditInterface != null) {
                this.O000OoO = false;
                MyViewPager.O00000o0();
                FragmentActivity activity = getActivity();
                if (activity != null && !activity.isFinishing()) {
                    TextView textView = this.O0000oo0;
                    if (textView != null && textView.getVisibility() == 0) {
                        this.O0000oo0.setVisibility(8);
                    }
                    this.O00000o = true;
                    this.O000O0OO = dviceEditInterface;
                    fpo.O00000Oo();
                    try {
                        DeviceEditPage O0000Ooo2 = O0000Ooo();
                        if (!O0000Ooo2.f10267O000000o) {
                            O0000Ooo2.f10267O000000o = true;
                            O0000Ooo2.e_();
                            DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = O0000Ooo2.O00000o0;
                            if (deviceMainPageEditBarV2 != null) {
                                deviceMainPageEditBarV2.setVisibility(0);
                                View view = O0000Ooo2.O00000Oo;
                                if (view != null) {
                                    view.setVisibility(0);
                                    View view2 = O0000Ooo2.O00000Oo;
                                    if (view2 != null) {
                                        View view3 = O0000Ooo2.O00000Oo;
                                        if (view3 != null) {
                                            view2.setTranslationY(-((float) gpc.O00000o0(view3.getContext(), 86.0f)));
                                            View view4 = O0000Ooo2.O00000Oo;
                                            if (view4 != null) {
                                                view4.animate().translationY(0.0f);
                                                DeviceMainPageEditBarV2 deviceMainPageEditBarV22 = O0000Ooo2.O00000o0;
                                                if (deviceMainPageEditBarV22 != null) {
                                                    View view5 = O0000Ooo2.O00000Oo;
                                                    if (view5 != null) {
                                                        deviceMainPageEditBarV22.setTranslationY((float) gpc.O00000o0(view5.getContext(), 90.0f));
                                                        DeviceMainPageEditBarV2 deviceMainPageEditBarV23 = O0000Ooo2.O00000o0;
                                                        if (deviceMainPageEditBarV23 != null) {
                                                            deviceMainPageEditBarV23.animate().translationY(0.0f);
                                                            View view6 = O0000Ooo2.O00000Oo;
                                                            if (view6 != null) {
                                                                view6.sendAccessibilityEvent(8);
                                                            } else {
                                                                ixe.O000000o("titleBar");
                                                                throw null;
                                                            }
                                                        } else {
                                                            ixe.O000000o("menuBar");
                                                            throw null;
                                                        }
                                                    } else {
                                                        ixe.O000000o("titleBar");
                                                        throw null;
                                                    }
                                                } else {
                                                    ixe.O000000o("menuBar");
                                                    throw null;
                                                }
                                            } else {
                                                ixe.O000000o("titleBar");
                                                throw null;
                                            }
                                        } else {
                                            ixe.O000000o("titleBar");
                                            throw null;
                                        }
                                    } else {
                                        ixe.O000000o("titleBar");
                                        throw null;
                                    }
                                } else {
                                    ixe.O000000o("titleBar");
                                    throw null;
                                }
                            } else {
                                ixe.O000000o("menuBar");
                                throw null;
                            }
                        }
                        View view7 = O0000Ooo().O00000Oo;
                        if (view7 != null) {
                            this.O000OOo0 = (ImageView) view7.findViewById(16908313);
                            this.O000OOOo = (ImageView) view7.findViewById(16908314);
                            this.O000OOOo.setImageResource(R.drawable.title_right_tick_drawable);
                            this.O0000oO = (TextView) view7.findViewById(R.id.module_a_4_return_more_title);
                            this.O000OOOo.setOnClickListener(new View.OnClickListener() {
                                /* class _m_j.$$Lambda$gzs$CvJ0d2zwbIz3ZxcbqK5d5CNxyOE */

                                public final void onClick(View view) {
                                    gzs.this.O00000Oo(view);
                                }
                            });
                            this.O000OOo0.setOnClickListener(new View.OnClickListener() {
                                /* class _m_j.$$Lambda$gzs$LuQG82DguMATQqVY9ziLe5nHw */

                                public final void onClick(View view) {
                                    gzs.O000000o(DviceEditInterface.this, view);
                                }
                            });
                            DeviceMainPageEditBarV2 deviceMainPageEditBarV24 = (DeviceMainPageEditBarV2) O0000Ooo().O00000oO();
                            deviceMainPageEditBarV24.setDeviceMainPage(this);
                            deviceMainPageEditBarV24.O000000o(dviceEditInterface);
                            refreshTitleBar();
                            if (this.f17283O000000o != null) {
                                this.f17283O000000o.requestLayout();
                            }
                            dviceEditInterface.O00000oo();
                            hxi.O00000o0.O00000Oo(dviceEditInterface.O0000o0o());
                            return;
                        }
                        ixe.O000000o("titleBar");
                        throw null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(View view) {
            O0000oO0();
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface, View view) {
            boolean z = dviceEditInterface.O0000Oo0().size() < dviceEditInterface.O0000o0O();
            dviceEditInterface.a_(z);
            dviceEditInterface.O0000o0();
            hxi.O00000o.O00000o(z ? 1 : 0);
        }

        /* renamed from: exitEditMode */
        public void O0000oO0() {
            MLAlertDialog mLAlertDialog = this.O00000oO;
            if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
                this.O00000oO.dismiss();
            }
            if (this.O00000o) {
                MyViewPager.O00000o();
                FragmentActivity activity = getActivity();
                if (activity != null && !activity.isFinishing()) {
                    this.O00000o = false;
                    DeviceEditPage deviceEditPage = this.O00O0Oo;
                    if (deviceEditPage != null) {
                        deviceEditPage.O00000Oo();
                        this.O00O0Oo = null;
                    }
                    refreshTitleBar();
                    DviceEditInterface dviceEditInterface = this.O000O0OO;
                    if (dviceEditInterface != null) {
                        dviceEditInterface.O0000O0o();
                        this.O000O0OO.O0000o0();
                        this.O000O0OO = null;
                    }
                    if (this.O000OoO) {
                        O00000oo();
                    }
                }
            }
        }

        public void updateActionItems(DviceEditInterface dviceEditInterface, int i) {
            if (i > 0) {
                try {
                    this.O0000oO.setText(getResources().getQuantityString(R.plurals.edit_choosed_device, i, Integer.valueOf(i)));
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            } else {
                this.O0000oO.setText((int) R.string.title_choose_device);
            }
            this.O0000oO.sendAccessibilityEvent(2);
            this.O0000oO.setTypeface(null, 0);
            if (i >= dviceEditInterface.O0000o0O()) {
                this.O000OOo0.setImageResource(R.drawable.un_select_selector);
                this.O000OOo0.setContentDescription(getString(R.string.unselect_all));
            } else {
                this.O000OOo0.setImageResource(R.drawable.all_select_selector);
                this.O000OOo0.setContentDescription(getString(R.string.select_all));
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            if (!activity.isFinishing()) {
                ((DeviceMainPageEditBarV2) this.O00O0Oo.O00000oO()).O00000Oo(dviceEditInterface);
            }
        }

        public boolean onBackPressed() {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                Fragment O000000o2 = activity.getSupportFragmentManager().O000000o(HomeEnvInfoFragment.class.getSimpleName());
                Fragment O000000o3 = activity.getSupportFragmentManager().O000000o(HomeEnvInfoSettingFragment.class.getSimpleName());
                if (O000000o3 != null && !O000000o3.isDetached()) {
                    ((HomeEnvInfoSettingFragment) O000000o3).onBackPressed();
                    return true;
                } else if (O000000o2 != null && !O000000o2.isDetached()) {
                    ((HomeEnvInfoFragment) O000000o2).onBackPressed();
                    return true;
                }
            }
            if (activity != null) {
                activity.finish();
            }
            return true;
        }

        public void onStateChanged() {
            gsy.O00000Oo("DeviceMainPage", "onStateChanged");
            O00000oo();
            O0000oO0();
            ((gzz) fo.O000000o((FragmentActivity) Objects.requireNonNull(getActivity())).O000000o(gzz.class)).O000000o(ggb.O00000Oo().O0000OOo());
            XQProgressDialog xQProgressDialog = this.O00000o0;
            if (xQProgressDialog != null) {
                xQProgressDialog.dismiss();
            }
            MLAlertDialog mLAlertDialog = this.O00000oO;
            if (mLAlertDialog != null) {
                mLAlertDialog.dismiss();
                this.O00000oO = null;
            }
        }

        public final void O00000oo() {
            this.O0000oo.removeMessages(3);
            O0000O0o();
        }

        public final void O0000O0o() {
            if (this.O0000o) {
                if (this.O00000o) {
                    this.O000OoO = true;
                    return;
                }
                O0000Oo0();
                gsy.O00000Oo("DeviceMainPage", "notifyDataSetChanged");
                O0000OOo();
                O0000o00();
            }
        }

        private void O0000o00() {
            if (ggb.O00000Oo().O0000OoO.O00000oo && this.O0000o0O) {
                this.O0000Ooo.O00000Oo();
                O0000o0o();
            }
        }

        public final void O0000OOo() {
            if (O000000o()) {
                if (O0000o0()) {
                    TextView textView = this.O000O0o;
                    if (textView != null) {
                        textView.setVisibility(8);
                        this.O000O0o.setText("");
                        this.O000O0oO.setContentDescription("");
                        this.O000O0oo.setVisibility(8);
                    }
                    CustomBannerHeaderView customBannerHeaderView = this.O0000Oo;
                    if (customBannerHeaderView != null) {
                        customBannerHeaderView.O00000Oo();
                        return;
                    }
                    return;
                }
                TextView textView2 = this.O000O0o;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                    Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
                    ggb.O00000Oo();
                    String O000000o2 = ggb.O000000o(O0000Oo02);
                    if (O0000Oo02 == null || TextUtils.isEmpty(O000000o2)) {
                        this.O000O0o.setText("");
                        this.O000O0oO.setContentDescription("");
                        this.O000O0oo.setVisibility(8);
                        return;
                    }
                    this.O000O0o.setText(O000000o2);
                    this.O000O0oO.setContentDescription(O000000o2);
                    this.O000O0oo.setVisibility(0);
                    boolean isOwner = O0000Oo02.isOwner();
                    this.O0000ooo.setActivated(isOwner);
                    if (!isOwner) {
                        this.O0000oOo.setVisibility(8);
                        this.O0000oOO.setVisibility(8);
                    }
                }
            }
        }

        public final void O0000Oo0() {
            CustomBannerHeaderView customBannerHeaderView = this.O0000Oo;
            if (customBannerHeaderView != null && customBannerHeaderView.getVisibility() == 8) {
            }
        }

        public final void O0000Oo() {
            gsy.O00000Oo(LogType.MAIN_PAGE, "forceUpdateAllData", "DeviceMainPage onLoginSuccess in");
            goq.O000000o(new Runnable() {
                /* class _m_j.gzs.AnonymousClass17 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
                 arg types: [android.content.Context, java.lang.String, java.lang.String, int]
                 candidates:
                  _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
                  _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
                public final void run() {
                    if (gzs.this.isValid()) {
                        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                            fal.getInstance().O000000o((fsm<Void, fso>) null);
                        }
                        hsl.O00000Oo().syncServer(false);
                        hor.O000000o().updateCustomScene(null, null);
                        try {
                            hyv.O000000o().requestData(gzs.this.getActivity(), null, false, null);
                        } catch (Exception unused) {
                        }
                        String O0000o0 = CoreApi.O000000o().O0000o0();
                        ServerBean O000000o2 = ftn.O000000o(gzs.this.mContext);
                        gva.O000000o().setUserInfoToSecurityCenter(gzs.this.mContext, true, O0000o0, O000000o2 != null ? O000000o2.f7546O000000o : "");
                        gzs.this.O0000oo.post(new Runnable() {
                            /* class _m_j.$$Lambda$gzs$17$Ub6oj4Q68iYS3BjOlHNZuwB75s */

                            public final void run() {
                                gzs.AnonymousClass17.this.O000000o();
                            }
                        });
                        gzs.this.O00000Oo(true);
                        hxg.O000000o();
                        Context appContext = CommonApplication.getAppContext();
                        ggc.O000000o().O00000oo.onNext(Boolean.valueOf(gpy.O00000o0(appContext, "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "show_change_home_red_dot", false)));
                        gzs.this.O00oOoOo.set(true);
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o() {
                    gzs.this.O0000OOo();
                }
            });
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.Boolean]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final void O0000OoO() {
            gsy.O00000Oo("forceUpdateAllData", "startRefresh onLogout");
            fqv fqv = (fqv) fnn.O000000o().O00000Oo();
            TextView textView = this.O000O0o;
            if (textView != null) {
                textView.setText("");
                this.O000O0oO.setContentDescription("");
                this.O000O0oo.setVisibility(8);
            }
            fqv.O0000OoO();
            this.O0000o0O = false;
            O0000OOo();
            gzz gzz = (gzz) fo.O000000o((FragmentActivity) Objects.requireNonNull(getActivity())).O000000o(gzz.class);
            gsy.O00000Oo(gzz.f18676O000000o, "clear");
            gzz.O0000OOo.clear();
            gzz.O0000Oo0.clear();
            gzz.O00000oo.set(false);
            Map value = gzz.O0000Oo.getValue();
            if (value != null) {
                value.clear();
            }
            Map value2 = gzz.O0000OoO.getValue();
            if (value2 != null) {
                value2.clear();
            }
            if (gzz.O00000o0 == null) {
                gzz.O00000o0 = ServiceApplication.getAppContext().getSharedPreferences("home_env_info", 0);
            }
            gzz.O00000o0.edit().clear().commit();
            this.O000O0Oo.set(false);
            goq.O000000o(new Runnable() {
                /* class _m_j.$$Lambda$gzs$64_6l3aKe0KvbUmDUzFuXKfKWiE */

                public final void run() {
                    gzs.this.O0000o();
                }
            });
            hxg.O00000Oo();
            this.O00oOoOo.set(false);
            hjx.O000000o();
            hlq.O000000o(getContext());
            synchronized (hfz.f18889O000000o) {
                hfz.O00000o0 = false;
                String O0000OOo2 = ggb.O00000Oo().O0000OOo();
                gsy.O00000Oo(LogType.CARD, "MainPageCacheStore", ixe.O000000o("clear: is homeId exist : ", (Object) Boolean.valueOf(O0000OOo2 != null)));
                hfz.O00000o.O000000o(O0000OOo2);
                hfz hfz = hfz.f18889O000000o;
                hfz.O000000o((ArrayList<MainPageDeviceModel>) null);
                hfz hfz2 = hfz.f18889O000000o;
                hfz.O00000Oo(null);
                hfz hfz3 = hfz.f18889O000000o;
                hfz.O00000o0(null);
                hfz hfz4 = hfz.f18889O000000o;
                hfz.O000000o(0);
                hfz hfz5 = hfz.f18889O000000o;
                hfz.O000000o("");
                hfz hfz6 = hfz.f18889O000000o;
                hfz.O00000o(null);
                iuh iuh = iuh.f1631O000000o;
            }
            View view = this.O0000ooO;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O0000o() {
            gva.O000000o().setUserInfoToSecurityCenter(this.mContext, false, "", "");
        }

        public final boolean O000000o() {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z = activeNetworkInfo != null;
                gsy.O00000Oo("DeviceMainPage", "showOffline ".concat(String.valueOf(z)));
                if (this.O0000O0o != null) {
                    this.O0000O0o.setVisibility(0);
                }
                if (this.O0000Oo != null) {
                    if (!z) {
                        this.O0000Oo.O000000o();
                        this.O000O0o.setText("");
                        this.O000O0oO.setContentDescription("");
                        this.O000O0oo.setVisibility(8);
                    } else if (!O0000o0()) {
                        this.O0000Oo.O00000o0();
                        O0000Oo0();
                    } else {
                        this.O0000Oo.O00000Oo();
                    }
                }
                if (activeNetworkInfo != null) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }

        private static boolean O0000o0() {
            return ServiceApplication.getStateNotifier().f15923O000000o == 3;
        }

        private void O0000o0O() {
            Map<String, Device> O0000O0o2;
            String O0000o0o2 = fno.O000000o().O0000o0o();
            if (!TextUtils.isEmpty(O0000o0o2) && (O0000O0o2 = fno.O000000o().O0000O0o()) != null && !O0000O0o2.isEmpty()) {
                boolean z = false;
                Iterator<Map.Entry<String, Device>> it = O0000O0o2.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Device device = (Device) it.next().getValue();
                        if (device != null && TextUtils.equals(device.did, O0000o0o2)) {
                            device.isNew = true;
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    htw O000000o2 = htv.O000000o();
                    if (O000000o2 != null) {
                        O000000o2.cleanScrollToDid();
                    }
                    MainPageAppBarLayout mainPageAppBarLayout = this.O0000OOo;
                    mainPageAppBarLayout.O000000o(this.O0000O0o, mainPageAppBarLayout);
                    this.O0000Ooo.O000000o(O0000o0o2);
                }
            }
        }

        public final void O000000o(String str) {
            htw O000000o2 = htv.O000000o();
            if (O000000o2 != null) {
                O000000o2.setCurrentScrollToDid(str);
            }
            O0000o0O();
        }

        private void O0000o0o() {
            if (ftn.O00000o0(fju.O000000o().O00000o())) {
                Context appContext = CommonApplication.getAppContext();
                if (!fkz.O000000o(appContext, CoreApi.O000000o().O0000o0() + "home_page_fireware_autoupdate_hint_ipc")) {
                    this.O0000oo0 = (TextView) this.f17283O000000o.findViewById(R.id.tv_auto_update_guide);
                    gfb.O000000o().O000000o(getContext(), new ArrayList(), new fsm<gfg, fso>() {
                        /* class _m_j.gzs.AnonymousClass19 */

                        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
                            if (_m_j.fkz.O000000o(r4, com.xiaomi.smarthome.frame.core.CoreApi.O000000o().O0000o0() + "home_page_fireware_autoupdate_hint_ipc") == false) goto L_0x0032;
                         */
                        /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
                        /* JADX WARNING: Removed duplicated region for block: B:13:0x0054  */
                        public final /* synthetic */ void onSuccess(Object obj) {
                            boolean z;
                            gfg gfg = (gfg) obj;
                            if (gfg != null) {
                                if (gfg.O00000Oo) {
                                    if (gfg.f17652O000000o) {
                                        Context appContext = CommonApplication.getAppContext();
                                    }
                                    z = false;
                                    if (z) {
                                        Context appContext2 = CommonApplication.getAppContext();
                                        fkz.O00000Oo(appContext2, CoreApi.O000000o().O0000o0() + "home_page_fireware_autoupdate_hint_ipc");
                                        return;
                                    }
                                    gfb.O000000o();
                                    gfb.O00000Oo(gzs.this.getContext(), new fsm<ArrayList<com.xiaomi.smarthome.core.entity.net.KeyValuePair>, fso>() {
                                        /* class _m_j.gzs.AnonymousClass19.AnonymousClass1 */

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            if (((ArrayList) obj).size() > 0) {
                                                Context appContext = CommonApplication.getAppContext();
                                                fkz.O00000Oo(appContext, CoreApi.O000000o().O0000o0() + "home_page_fireware_autoupdate_hint_ipc");
                                                gzs.this.O0000oo0.setVisibility(0);
                                                gzs.this.O0000oo0.setText((int) R.string.auto_fireware_update_guide);
                                                gzs.this.O0000oo0.setCompoundDrawablesWithIntrinsicBounds(0, 0, (int) R.drawable.into_icon_nor_3x, 0);
                                                gzs.this.O0000oo0.setOnClickListener(
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0055: INVOKE  
                                                      (wrap: android.widget.TextView : 0x004e: IGET  (r3v16 android.widget.TextView) = 
                                                      (wrap: _m_j.gzs : 0x004c: IGET  (r3v15 _m_j.gzs) = 
                                                      (wrap: _m_j.gzs$19 : 0x004a: IGET  (r3v14 _m_j.gzs$19) = (r2v0 'this' _m_j.gzs$19$1 A[THIS]) _m_j.gzs.19.1.O000000o _m_j.gzs$19)
                                                     _m_j.gzs.19.O000000o _m_j.gzs)
                                                     _m_j.gzs.O0000oo0 android.widget.TextView)
                                                      (wrap: _m_j.-$$Lambda$gzs$19$1$T_8OGYEusPhOpoMn96H2EAWOuHk : 0x0052: CONSTRUCTOR  (r0v4 _m_j.-$$Lambda$gzs$19$1$T_8OGYEusPhOpoMn96H2EAWOuHk) = (r2v0 'this' _m_j.gzs$19$1 A[THIS]) call: _m_j.-$$Lambda$gzs$19$1$T_8OGYEusPhOpoMn96H2EAWOuHk.<init>(_m_j.gzs$19$1):void type: CONSTRUCTOR)
                                                     type: VIRTUAL call: android.widget.TextView.setOnClickListener(android.view.View$OnClickListener):void in method: _m_j.gzs.19.1.onSuccess(java.lang.Object):void, dex: classes7.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
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
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0052: CONSTRUCTOR  (r0v4 _m_j.-$$Lambda$gzs$19$1$T_8OGYEusPhOpoMn96H2EAWOuHk) = (r2v0 'this' _m_j.gzs$19$1 A[THIS]) call: _m_j.-$$Lambda$gzs$19$1$T_8OGYEusPhOpoMn96H2EAWOuHk.<init>(_m_j.gzs$19$1):void type: CONSTRUCTOR in method: _m_j.gzs.19.1.onSuccess(java.lang.Object):void, dex: classes7.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                    	... 130 more
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$gzs$19$1$T_8OGYEusPhOpoMn96H2EAWOuHk, state: NOT_LOADED
                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                    	... 136 more
                                                    */
                                                /*
                                                    this = this;
                                                    java.util.ArrayList r3 = (java.util.ArrayList) r3
                                                    int r3 = r3.size()
                                                    if (r3 <= 0) goto L_0x0059
                                                    android.content.Context r3 = com.xiaomi.smarthome.application.CommonApplication.getAppContext()
                                                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                                    r0.<init>()
                                                    com.xiaomi.smarthome.frame.core.CoreApi r1 = com.xiaomi.smarthome.frame.core.CoreApi.O000000o()
                                                    java.lang.String r1 = r1.O0000o0()
                                                    r0.append(r1)
                                                    java.lang.String r1 = "home_page_fireware_autoupdate_hint_ipc"
                                                    r0.append(r1)
                                                    java.lang.String r0 = r0.toString()
                                                    _m_j.fkz.O00000Oo(r3, r0)
                                                    _m_j.gzs$19 r3 = _m_j.gzs.AnonymousClass19.this
                                                    _m_j.gzs r3 = _m_j.gzs.this
                                                    android.widget.TextView r3 = r3.O0000oo0
                                                    r0 = 0
                                                    r3.setVisibility(r0)
                                                    _m_j.gzs$19 r3 = _m_j.gzs.AnonymousClass19.this
                                                    _m_j.gzs r3 = _m_j.gzs.this
                                                    android.widget.TextView r3 = r3.O0000oo0
                                                    r1 = 2132672947(0x7f1e01b3, float:2.1002685E38)
                                                    r3.setText(r1)
                                                    _m_j.gzs$19 r3 = _m_j.gzs.AnonymousClass19.this
                                                    _m_j.gzs r3 = _m_j.gzs.this
                                                    android.widget.TextView r3 = r3.O0000oo0
                                                    r1 = 2132085163(0x7f1509ab, float:1.9810517E38)
                                                    r3.setCompoundDrawablesWithIntrinsicBounds(r0, r0, r1, r0)
                                                    _m_j.gzs$19 r3 = _m_j.gzs.AnonymousClass19.this
                                                    _m_j.gzs r3 = _m_j.gzs.this
                                                    android.widget.TextView r3 = r3.O0000oo0
                                                    _m_j.-$$Lambda$gzs$19$1$T_8OGYEusPhOpoMn96H2EAWOuHk r0 = new _m_j.-$$Lambda$gzs$19$1$T_8OGYEusPhOpoMn96H2EAWOuHk
                                                    r0.<init>(r2)
                                                    r3.setOnClickListener(r0)
                                                    return
                                                L_0x0059:
                                                    com.xiaomi.smarthome.library.log.LogType r3 = com.xiaomi.smarthome.library.log.LogType.MAIN_PAGE
                                                    java.lang.String r0 = "DeviceMainPage"
                                                    java.lang.String r1 = "checkAutoUpdateDevice size == 0"
                                                    _m_j.gsy.O00000o0(r3, r0, r1)
                                                    return
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: _m_j.gzs.AnonymousClass19.AnonymousClass1.onSuccess(java.lang.Object):void");
                                            }

                                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                             method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
                                             arg types: [java.lang.String, int]
                                             candidates:
                                              _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
                                              _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
                                              _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
                                              _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
                                              _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                                              _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
                                              _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
                                              _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
                                              _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
                                              _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
                                              _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
                                            /* access modifiers changed from: private */
                                            public /* synthetic */ void O000000o(View view) {
                                                gzs.this.O0000oo0.setVisibility(8);
                                                fbt fbt = new fbt(gzs.this.getContext(), "ShowFirmwareUpdateActivity");
                                                fbt.O000000o("from_guide", true);
                                                fbs.O000000o(fbt);
                                            }

                                            public final void onFailure(fso fso) {
                                                gsy.O00000o0(LogType.MAIN_PAGE, "DeviceMainPage", "checkAutoUpdateDevice ".concat(String.valueOf(fso)));
                                            }
                                        });
                                        return;
                                    }
                                    z = true;
                                    if (z) {
                                    }
                                }
                            }

                            public final void onFailure(fso fso) {
                                gsy.O00000o0(LogType.MAIN_PAGE, "DeviceMainPage", "checkFirmwareUpdateBatch ".concat(String.valueOf(fso)));
                            }
                        });
                    }
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(View view) {
                new MLAlertDialog.Builder(getContext()).O000000o("提示").O00000Oo("是否退出调试模式").O000000o("确定", new DialogInterface.OnClickListener() {
                    /* class _m_j.$$Lambda$gzs$pi0YlV9u681yyaUdAKkoJljVQ */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        gzs.this.O000000o(dialogInterface, i);
                    }
                }).O00000Oo("取消", (DialogInterface.OnClickListener) null).O00000oo();
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
                hmq.O000000o().exitQRDebugMode();
                this.O000OO00.setVisibility(8);
            }

            public void onConfigurationChanged(Configuration configuration) {
                super.onConfigurationChanged(configuration);
                if (this.f17283O000000o != null) {
                    View findViewById = this.f17283O000000o.findViewById(R.id.main_collapsing);
                    int dimension = (int) getResources().getDimension(R.dimen.main_page_flex_padding);
                    findViewById.setPadding(dimension, 0, dimension, 0);
                }
            }
        }
