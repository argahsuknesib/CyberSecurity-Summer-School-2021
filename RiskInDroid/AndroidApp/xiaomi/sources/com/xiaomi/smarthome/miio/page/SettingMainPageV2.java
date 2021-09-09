package com.xiaomi.smarthome.miio.page;

import _m_j.chl;
import _m_j.chm;
import _m_j.cho;
import _m_j.exq;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fbv;
import _m_j.fca;
import _m_j.flk;
import _m_j.fno;
import _m_j.ft;
import _m_j.ftn;
import _m_j.ftt;
import _m_j.fvo;
import _m_j.gfr;
import _m_j.gny;
import _m_j.goy;
import _m_j.gpc;
import _m_j.gpv;
import _m_j.gpy;
import _m_j.grv;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gus;
import _m_j.guz;
import _m_j.gva;
import _m_j.gwg;
import _m_j.gwv;
import _m_j.gyl;
import _m_j.hjm;
import _m_j.hjo;
import _m_j.hjp;
import _m_j.hjs;
import _m_j.hjt;
import _m_j.hju;
import _m_j.hlr;
import _m_j.hte;
import _m_j.hxg;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxm;
import _m_j.hxr;
import _m_j.hyw;
import _m_j.hyx;
import _m_j.hyy;
import _m_j.hzf;
import _m_j.izb;
import _m_j.oOO0OOo0;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.mibigkoo.convenientbanner.ConvenientBanner;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.feedback.FeedBackMainActivity;
import com.xiaomi.smarthome.feedback.FeedbackActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.login.ui.LogoutActivity;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.rndebug.RnDebugClassifyActivity;
import com.xiaomi.smarthome.framework.permission.PermissionRequestActivity;
import com.xiaomi.smarthome.framework.redpoint.ServerTimerManager;
import com.xiaomi.smarthome.homeroom.homedevicelist.DeviceCountManager;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.activity.ConsumablesActivity;
import com.xiaomi.smarthome.miio.activity.LaboratoryActivity;
import com.xiaomi.smarthome.miio.activity.LicenseChooseActivity;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import com.xiaomi.smarthome.miio.page.SettingMainPageV2;
import com.xiaomi.smarthome.operation.view.OperationImageView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class SettingMainPageV2 extends hyw {
    public static final String O00000Oo = "SettingMainPageV2";
    boolean O00000o = false;
    public hlr<List<hju>> O00000o0 = hjm.O00000Oo();
    public boolean O00000oO = false;
    public Handler O00000oo = new Handler(Looper.getMainLooper());
    public final List<hjt> O0000O0o = new ArrayList();
    public boolean O0000OOo = false;
    private List<ViewGroup> O0000Oo = new ArrayList();
    private final CompositeDisposable O0000Oo0 = new CompositeDisposable();
    private boolean O0000OoO = false;
    private long O0000Ooo;
    private BroadcastReceiver O0000o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("action_on_logout".equals(action)) {
                SettingMainPageV2.O00000o0();
            } else if ("action_on_login_success".equals(action)) {
                if (SettingMainPageV2.this.mNickView != null) {
                    SettingMainPageV2.this.mNickView.setText((int) R.string.already_logged_in);
                }
                if (SettingMainPageV2.this.mTitle != null) {
                    SettingMainPageV2.this.mTitle.setText((int) R.string.already_logged_in);
                }
            } else if ("action_locale_changed".equals(action)) {
                SettingMainPageV2 settingMainPageV2 = SettingMainPageV2.this;
                settingMainPageV2.O000000o(settingMainPageV2.f17283O000000o);
            }
        }
    };
    private ConvenientBanner O0000o0;
    private boolean O0000o00;
    private ConstraintLayout O0000o0O;
    private O00000Oo O0000o0o = null;
    private boolean O0000oO = true;
    private String O0000oO0;
    private final List<hjs> O0000oOO = new ArrayList();
    private BroadcastReceiver O0000oOo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass5 */

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
                String action = intent.getAction();
                char c = 65535;
                if (action.hashCode() == 735880982 && action.equals("action.passwordlogin.login.complete")) {
                    c = 0;
                }
                if (c == 0 && intent.getBooleanExtra("login_success", false)) {
                    SettingMainPageV2.this.O000000o();
                }
            }
        }
    };
    private BroadcastReceiver O0000oo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass6 */

        public final void onReceive(Context context, Intent intent) {
            SettingMainPageV2.this.O0000OOo = true;
        }
    };
    private long O0000oo0 = 0;
    @BindView(5766)
    View layoutRnDebug;
    @BindView(4952)
    AppBarLayout mAppBarLayout;
    @BindView(5095)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(5112)
    View mConsumableRedDot;
    @BindView(5759)
    RelativeLayout mConsumables;
    @BindView(6126)
    TextView mDevCountView;
    @BindView(5760)
    RelativeLayout mFamily;
    @BindView(5853)
    ViewGroup mGroup1;
    @BindView(5854)
    ViewGroup mGroup2;
    @BindView(5855)
    ViewGroup mGroup3;
    @BindView(4849)
    View mImgAboutDot;
    @BindView(5243)
    View mImgFeedbackDot;
    @BindView(5762)
    RelativeLayout mLaboratory;
    @BindView(5409)
    View mLaboratoryRedDot;
    @BindView(5427)
    ViewGroup mLfGroup;
    @BindView(5077)
    View mLoginFrame;
    @BindView(5771)
    RelativeLayout mMyShopBtn;
    @BindView(6135)
    TextView mNickView;
    @BindView(5764)
    ViewGroup mPermissionBtn;
    @BindView(5768)
    RelativeLayout mScore;
    @BindView(5772)
    RelativeLayout mThirdAccountBtn;
    @BindView(6079)
    TextView mTitle;
    @BindView(5994)
    View mToolbar;
    @BindView(6134)
    SimpleDraweeView mUsrIcon;
    @BindView(6147)
    CoordinatorLayout mViewContainer;
    @BindView(5774)
    RelativeLayout mVoiceAssistant;
    @BindView(5775)
    RelativeLayout mVoiceControl;
    @BindView(6155)
    View mVoiceRedDot;
    @BindView(6074)
    TextView tvRnDebugLeftInfo2;

    static class O00000Oo implements fno.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<SettingMainPageV2> f9833O000000o;

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public O00000Oo(SettingMainPageV2 settingMainPageV2) {
            this.f9833O000000o = new WeakReference<>(settingMainPageV2);
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            SettingMainPageV2 settingMainPageV2;
            if (i == 3 && (settingMainPageV2 = this.f9833O000000o.get()) != null && settingMainPageV2.isValid()) {
                settingMainPageV2.O00000o();
            }
        }
    }

    public static void O00000o0() {
        fca.O000000o().f16062O000000o.clear();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hlr.O000000o(io.reactivex.functions.Consumer<java.util.List<_m_j.hju>>, boolean):void
     arg types: [com.xiaomi.smarthome.miio.page.-$$Lambda$SettingMainPageV2$TVtwJpcn-FPzzW1l-pVwdT1pwvg, int]
     candidates:
      _m_j.hlr.O000000o(java.lang.String, com.facebook.drawee.view.SimpleDraweeView):void
      _m_j.hlr.O000000o(io.reactivex.functions.Consumer<java.util.List<_m_j.hju>>, boolean):void */
    public final void O000000o(View view) {
        this.O00000o0.O000000o((Consumer<List<hju>>) new Consumer(view) {
            /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$TVtwJpcnFPzzW1lpVwdT1pwvg */
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                SettingMainPageV2.this.O00000Oo(this.f$1, (List) obj);
            }
        }, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public void O00000Oo(View view, List<hju> list) {
        if (view != null && list != null && !list.isEmpty()) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.my_banner);
            this.O0000o0O = (ConstraintLayout) view.findViewById(R.id.cl_banner);
            this.O0000O0o.clear();
            this.O0000oOO.clear();
            for (hju next : list) {
                if (next instanceof hjt) {
                    this.O0000O0o.add((hjt) next);
                } else {
                    this.O0000oOO.add((hjs) next);
                }
            }
            if (this.O0000O0o.isEmpty()) {
                constraintLayout.findViewById(R.id.tab_container).setVisibility(8);
            } else {
                constraintLayout.findViewById(R.id.tab_container).setVisibility(0);
                oOO0OOo0 ooo0ooo0 = new oOO0OOo0();
                ooo0ooo0.O00000Oo(this.O0000o0O);
                ooo0ooo0.O000000o(hyy.O000000o() ? "5.6:1" : "2.8:1");
                ooo0ooo0.O00000o0(this.O0000o0O);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                TransitionManager.beginDelayedTransition((ViewGroup) view);
            }
            this.O0000o0 = (ConvenientBanner) constraintLayout.findViewById(R.id.op_banner);
            int[] iArr = {R.id.tab_1, R.id.tab_2, R.id.tab_3, R.id.tab_4};
            for (int i = 0; i < 4; i++) {
                ((ViewGroup) constraintLayout.findViewById(iArr[i])).setVisibility(8);
            }
            for (int i2 = 0; i2 < Math.min(this.O0000O0o.size(), 4); i2++) {
                ViewGroup viewGroup = (ViewGroup) constraintLayout.findViewById(iArr[i2]);
                viewGroup.setVisibility(0);
                final hjt hjt = this.O0000O0o.get(i2);
                OperationImageView operationImageView = (OperationImageView) viewGroup.getChildAt(0);
                this.O00000o0.O000000o(hjt.O0000Ooo, operationImageView);
                operationImageView.registerOnVisibleToUser(new OperationImageView.O000000o() {
                    /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass7 */

                    public final void onVisible(View view) {
                        hxr hxr = hxi.O00000oO;
                        String str = hjt.f19003O000000o;
                        hxr.f958O000000o.O000000o("profile_service_icon_popup", "url", str);
                        hxm hxm = hxi.O0000o00;
                        String str2 = hjt.f19003O000000o;
                        String str3 = hjt.O00000o0;
                        String str4 = hjt.O00000Oo;
                        String str5 = hjt.O00000o;
                        int indexOf = SettingMainPageV2.this.O0000O0o.indexOf(hjt);
                        hxm.f954O000000o.O000000o("profile_service_icon_expose", "link", str2, "asset_id", str3, "asset_name", str4, "exp_id", str5, hxg.f948O000000o, Integer.valueOf(indexOf));
                    }
                });
                ((TextView) viewGroup.getChildAt(1)).setText(hjt.O00000Oo);
                viewGroup.setTag(Integer.valueOf(i2));
                viewGroup.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$IsBk9ZwKrK3BnTPuNukOrnn40R0 */

                    public final void onClick(View view) {
                        SettingMainPageV2.O000000o(hjt.this, view);
                    }
                });
            }
            if (this.O0000oOO.isEmpty()) {
                this.O0000o0.setVisibility(8);
                if (!(this.O0000o0.getViewPager() == null || this.O0000o0.getViewPager().getAdapter() == null)) {
                    this.O0000o0.O000000o();
                }
            } else {
                this.O0000o0.setVisibility(0);
                if (this.O0000o0.getViewPager() == null || this.O0000o0.getViewPager().getAdapter() == null) {
                    this.O0000o0.O000000o(new ViewPager.O0000O0o() {
                        /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass8 */

                        public final void onPageScrollStateChanged(int i) {
                        }

                        public final void onPageScrolled(int i, float f, int i2) {
                        }

                        public final void onPageSelected(int i) {
                            SettingMainPageV2.this.O000000o(i);
                        }
                    });
                    this.O0000o0.O000000o(new chl() {
                        /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$Nj9xqkK7VXu29gRBxNTIkl5wpvU */

                        public final Object createHolder() {
                            return SettingMainPageV2.this.O0000oO0();
                        }
                    }, this.O0000oOO).O000000o(hyy.O000000o() ? ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_LEFT : ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL).O000000o(new int[]{R.drawable.dot_indicator_unselected, R.drawable.dot_indicator_selected}).O000000o(new cho() {
                        /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$78wDYhgOG214poZ3FN1BRh8C_Ok */

                        public final void onItemClick(int i) {
                            SettingMainPageV2.this.O00000Oo(i);
                        }
                    }).O000000o(hyy.O000000o()).O000000o(3000);
                } else {
                    this.O0000o0.O000000o();
                }
                if (this.O0000oOO.size() == 1) {
                    this.O0000o0.setCanLoop(false);
                    this.O0000o0.O000000o(new int[]{R.drawable.dot_indicator_transparent, R.drawable.dot_indicator_transparent});
                    this.O0000o0.setManualPageable(false);
                } else {
                    this.O0000o0.setCanLoop(true);
                    this.O0000o0.O000000o(new int[]{R.drawable.dot_indicator_unselected, R.drawable.dot_indicator_selected});
                }
                if (hyy.O000000o()) {
                    this.O0000o0.setPointViewBottomMargin(gpc.O000000o(10.0f));
                    this.O0000o0.setPointViewLeftMargin(gpc.O000000o(20.0f));
                }
            }
            constraintLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object O0000oO0() {
        return new O000000o(this, (byte) 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(int i) {
        hjs hjs = this.O0000oOO.get(i);
        hjo.O000000o(hjs.O0000OOo, hjs.f19002O000000o, hjs.O00000o0);
        hjs hjs2 = this.O0000oOO.get(i);
        hxk hxk = hxi.O00000o;
        String str = hjs2.f19002O000000o;
        String str2 = hjs2.O0000Oo0;
        String str3 = hjs2.O00000o0;
        String str4 = hjs2.O0000OoO;
        hxk.f952O000000o.O000000o("profile_ad_click", "link", str, "asset_id", str2, "asset_name", str3, "exp_id", str4, hxg.f948O000000o, Integer.valueOf(i));
    }

    public final void O000000o(int i) {
        try {
            if (!this.O0000o00) {
                return;
            }
            if (hyy.O000000o()) {
                int i2 = i + 1;
                hjs hjs = this.O0000oOO.get(i2 % this.O0000oOO.size());
                hxi.O0000o00.O000000o(hjs.f19002O000000o, hjs.O0000Oo0, hjs.O00000o0, hjs.O0000OoO, i2 % this.O0000oOO.size());
                return;
            }
            hjs hjs2 = this.O0000oOO.get(i);
            hxi.O0000o00.O000000o(hjs2.f19002O000000o, hjs2.O0000Oo0, hjs2.O00000o0, hjs2.O0000OoO, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class O000000o implements chm<hjs> {
        private OperationImageView O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(SettingMainPageV2 settingMainPageV2, byte b) {
            this();
        }

        public final /* synthetic */ void O000000o(Context context, int i, Object obj) {
            hjs hjs = (hjs) obj;
            SettingMainPageV2.this.O00000o0.O000000o(hjs.O0000Ooo, this.O00000Oo);
            this.O00000Oo.registerOnVisibleToUser(new OperationImageView.O000000o() {
                /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$O000000o$NXvFk9A7YqFpiMrO8XgWPxeMY */

                public final void onVisible(View view) {
                    SettingMainPageV2.O000000o.O000000o(hjs.this, view);
                }
            });
        }

        public final View O000000o(Context context, ViewGroup viewGroup) {
            this.O00000Oo = new OperationImageView(context);
            this.O00000Oo.setScaleType(ImageView.ScaleType.FIT_XY);
            return this.O00000Oo;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(hjs hjs, View view) {
            hxr hxr = hxi.O00000oO;
            String str = hjs.f19002O000000o;
            hxr.f958O000000o.O000000o("profile_ad_popup", "url", str);
        }
    }

    @SuppressLint({"CheckResult"})
    public final void O00000o() {
        if (this.mDevCountView != null) {
            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                this.mDevCountView.setText("");
                this.mDevCountView.setVisibility(8);
                return;
            }
            DeviceCountManager O000000o2 = DeviceCountManager.O000000o();
            if (O000000o2.O00000o0 == null) {
                O000000o2.O00000o0 = BehaviorSubject.createDefault(Integer.valueOf(O000000o2.O00000o0()));
            }
            O000000o2.O00000o0.hide().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Integer>() {
                /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass9 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    String str;
                    Integer num = (Integer) obj;
                    if (SettingMainPageV2.this.isValid()) {
                        try {
                            if (num.intValue() == 0) {
                                str = SettingMainPageV2.this.getResources().getString(R.string.tag_no_device);
                            } else {
                                str = SettingMainPageV2.this.getResources().getQuantityString(R.plurals.setting_total_device, num.intValue(), num);
                            }
                            gsy.O00000o0(LogType.GENERAL, "", str);
                            SettingMainPageV2.this.mDevCountView.setText(str);
                            SettingMainPageV2.this.mDevCountView.setVisibility(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = O00000Oo;
        gsy.O00000Oo(str, O00000Oo + "onCreateView");
        this.O00000o = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f17283O000000o == null) {
            this.f17283O000000o = layoutInflater.inflate((int) R.layout.setting_main_page_v2, (ViewGroup) null);
            this.O0000oO = !ServiceApplication.isCurrentHotStart();
            if (this.O0000oO) {
                ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$NRSiUSv4UNw3yzDk_XwbVnJpFk */

                    public final void run() {
                        SettingMainPageV2.this.O0000OOo();
                    }
                }, 1000);
            } else {
                O0000OOo();
            }
        }
        String str2 = O00000Oo;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        gsy.O000000o(3, str2, sb.toString());
        return this.f17283O000000o;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == 1001) {
            ((hyx) fbs.O000000o(hyx.class, "key.com.xiaomi.smarthome.usercenter.router")).gotoDevicePage(getActivity());
        }
    }

    /* access modifiers changed from: private */
    public void O0000OOo() {
        if (!this.O00000o && isValid() && this.f17283O000000o != null) {
            ViewStub viewStub = (ViewStub) this.f17283O000000o.findViewById(R.id.setting_main_page_content_view_stub);
            if (viewStub != null) {
                viewStub.inflate();
            }
            ButterKnife.bind(this, this.f17283O000000o);
            O000000o(this.f17283O000000o);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.O0000oO) {
            ServiceApplication.getGlobalHandler().postDelayed(new Runnable(view) {
                /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$AdXSNw4TqlLqXtWpv5RI5MtpecU */
                private final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SettingMainPageV2.this.O00000o(this.f$1);
                }
            }, 1000);
        } else {
            O00000o(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000Oo */
    public void O00000o(View view) {
        if (!this.O00000o && isValid()) {
            O0000o0();
            this.O0000Oo.add(this.mGroup1);
            this.O0000Oo.add(this.mGroup2);
            this.O0000Oo.add(this.mGroup3);
            CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$Z9DdQYn6MPfcPuNyvPbsGAC9gcE */

                public final void onCoreReady() {
                    SettingMainPageV2.this.O0000Oo0();
                }
            });
            View findViewById = view.findViewById(R.id.rl_about);
            if (findViewById != null) {
                findViewById.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$fN8vzRtt2neMBG5BN50lqwgdBpA */

                    public final boolean onLongClick(View view) {
                        return SettingMainPageV2.this.O00000o0(view);
                    }
                });
            }
            O00000Oo();
            O00000o();
            gva.O000000o().checkFeedback();
            ft.O000000o(getContext()).O000000o(this.O0000oo, new IntentFilter("action_user_info_updated"));
            AppBarLayout appBarLayout = this.mAppBarLayout;
            if (appBarLayout != null) {
                appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
                    /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass10 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    Interpolator f9819O000000o = new DecelerateInterpolator(2.0f);

                    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                        float abs = Math.abs(((float) i) / ((float) appBarLayout.getTotalScrollRange()));
                        int i2 = 8;
                        if (((double) abs) < 0.64d) {
                            SettingMainPageV2.this.mTitle.setVisibility(8);
                        } else {
                            SettingMainPageV2.this.mTitle.setVisibility(0);
                        }
                        View view = SettingMainPageV2.this.mToolbar;
                        if (abs != 0.0f) {
                            i2 = 0;
                        }
                        view.setVisibility(i2);
                        SettingMainPageV2.this.mToolbar.setAlpha(this.f9819O000000o.getInterpolation(abs));
                    }
                });
            }
            RelativeLayout relativeLayout = this.mFamily;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            if (this.O00000o0.O000000o()) {
                O00000Oo(this.f17283O000000o, this.O00000o0.O00000Oo());
            }
            if (hyy.O000000o()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mLfGroup.getLayoutParams();
                marginLayoutParams.leftMargin = gpc.O000000o(10.0f);
                marginLayoutParams.rightMargin = gpc.O000000o(10.0f);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean O00000o0(View view) {
        if (!gfr.O0000o0o) {
            return false;
        }
        if (gfr.O0000oOO) {
            gfr.O0000oOO = false;
            izb.O000000o(getActivity(), (int) R.string.about_normal, 0).show();
        } else {
            gfr.O0000oOO = true;
            izb.O000000o(getActivity(), (int) R.string.about_test, 0).show();
        }
        gpy.O000000o(getContext(), "dev_pref", "use_test_url", gfr.O0000oOO);
        return true;
    }

    public final void O00000oO() {
        View view = this.layoutRnDebug;
        if (view != null) {
            if (this.O00000oO) {
                view.setVisibility(0);
                fvo.O000000o();
                this.O0000OoO = fvo.O00000oO();
                this.tvRnDebugLeftInfo2.setText(this.O0000OoO ? "开发模式已打开" : "开发模式已关闭");
                LogType logType = LogType.GENERAL;
                String str = O00000Oo;
                gsy.O00000o0(logType, str, "debug build type: " + gfr.O0000OOo + "  sdk build type: " + gfr.O0000Oo + "  is rn debug enable: " + this.O0000OoO);
            } else {
                view.setVisibility(8);
            }
            ViewParent parent = this.layoutRnDebug.getParent();
            if (parent instanceof ViewGroup) {
                O000000o((ViewGroup) parent);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O000000o(android.content.Context, java.lang.String):int
      _m_j.gpv.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String):boolean
      _m_j.gpv.O000000o(java.lang.String, boolean):boolean */
    /* access modifiers changed from: private */
    public void O0000Oo0() {
        try {
            if (!this.O00000o) {
                if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                    this.mVoiceAssistant.setVisibility(0);
                    this.mConsumables.setVisibility(8);
                    this.mThirdAccountBtn.setVisibility(8);
                    this.mMyShopBtn.setVisibility(8);
                    if (!TextUtils.isEmpty(goy.O00000Oo(getContext()))) {
                        this.mScore.setVisibility(0);
                    }
                    this.mFamily.setVisibility(8);
                    this.mVoiceControl.setVisibility(8);
                } else {
                    this.mVoiceAssistant.setVisibility(8);
                    this.mConsumables.setVisibility(0);
                    this.mMyShopBtn.setVisibility(0);
                    if (fbv.O000000o().O00000o) {
                        this.mThirdAccountBtn.setVisibility(0);
                    }
                    this.mScore.setVisibility(8);
                    gpv.O000000o("lab_red_dot_shown", false);
                    this.mLaboratoryRedDot.setVisibility(8);
                    this.mFamily.setVisibility(0);
                    this.mVoiceControl.setVisibility(0);
                }
                for (int i = 0; i < this.O0000Oo.size(); i++) {
                    O000000o(this.O0000Oo.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
        gsy.O000000o(LogType.GENERAL, O00000Oo, "onResume");
        this.O0000Ooo = System.currentTimeMillis();
        if (this.O0000oO) {
            ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$kpXQO3lJAjjUYfd43Dgl7CbxPeA */

                public final void run() {
                    SettingMainPageV2.this.O0000Oo();
                }
            }, 1000);
        } else {
            O0000Oo();
        }
    }

    public void refreshTitleBar() {
        gwg.O00000Oo(getActivity().getWindow());
    }

    public final void O00000oo() {
        O0000o00();
        TextView textView = this.mNickView;
        if (textView != null) {
            textView.setText((int) R.string.already_logged_in);
            this.mNickView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass13 */

                public final void onClick(View view) {
                    SettingMainPageV2.this.O0000O0o();
                }
            });
        }
        TextView textView2 = this.mTitle;
        if (textView2 != null) {
            textView2.setText((int) R.string.already_logged_in);
        }
    }

    /* access modifiers changed from: private */
    public void O0000Oo() {
        ViewGroup viewGroup;
        if (!this.O00000o) {
            if (!(getActivity() == null || (viewGroup = this.mPermissionBtn) == null)) {
                PermissionRequestActivity.O00000Oo o00000Oo = PermissionRequestActivity.Companion;
                viewGroup.setVisibility(PermissionRequestActivity.O00000Oo.O00000Oo(getActivity()) ? 8 : 0);
            }
            XmPluginHostApi.instance().callSmartHomeApi((String) null, "/v2/developer/check_developer", "", new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass11 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        gsy.O00000Oo("rn-debug", jSONObject.toString());
                        SettingMainPageV2.this.O00000oO = jSONObject.optBoolean("result", false);
                    } else {
                        gsy.O00000Oo("rn-debug", "requestUserDedbugAuthority is null...");
                        SettingMainPageV2.this.O00000oO = false;
                    }
                    SettingMainPageV2.this.O00000oO();
                }

                public final void onFailure(int i, String str) {
                    gsy.O00000Oo("rn-debug", str);
                    SettingMainPageV2 settingMainPageV2 = SettingMainPageV2.this;
                    settingMainPageV2.O00000oO = false;
                    settingMainPageV2.O00000oO();
                }
            }, Parser.DEFAULT_PARSER);
            if (TextUtils.isEmpty(this.O0000oO0) && ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                O0000o00();
                this.mNickView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass12 */

                    public final void onClick(View view) {
                        SettingMainPageV2.this.mLoginFrame.performClick();
                    }
                });
                this.mNickView.setText((int) R.string.not_logged_in_desc);
                this.mTitle.setText((int) R.string.not_logged_in);
            } else if (TextUtils.isEmpty(this.O0000oO0) || ServiceApplication.getStateNotifier().f15923O000000o != 4 || !this.O0000oO0.equals(CoreApi.O000000o().O0000o0()) || this.O0000OOo) {
                this.O0000OOo = false;
                this.O0000oO0 = CoreApi.O000000o().O0000o0();
                O00000Oo();
                O00000o();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(boolean z) {
        if (this.mImgAboutDot != null && z) {
            this.O00000oo.post(new Runnable() {
                /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$mVSXMIWAxZZPZyUDMLlKVhVXqZM */

                public final void run() {
                    SettingMainPageV2.this.O0000o();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000o() {
        this.mImgAboutDot.setVisibility(0);
    }

    public final void O000000o() {
        ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.miio.page.$$Lambda$Z0tr90JznXX5bwGJmU8erE114 */

            public final void run() {
                SettingMainPageV2.this.O00000Oo();
            }
        }, 1000);
    }

    public void O00000Oo() {
        if (this.mNickView != null) {
            O0000o00();
            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                try {
                    this.mNickView.setText((int) R.string.not_logged_in_desc);
                    this.mTitle.setText((int) R.string.not_logged_in);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                O0000O0o();
            }
        }
    }

    public final void O0000O0o() {
        gyl.O000000o().O000000o(new ftt<ShareUserRecord>() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass4 */

            public final /* synthetic */ void O000000o(Object obj) {
                ShareUserRecord shareUserRecord = (ShareUserRecord) obj;
                if (SettingMainPageV2.this.isValid()) {
                    try {
                        SettingMainPageV2.this.mNickView.setText(shareUserRecord.nickName);
                        SettingMainPageV2.this.mTitle.setText(shareUserRecord.nickName);
                        SettingMainPageV2.this.mNickView.setVisibility(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    gyl O000000o2 = gyl.O000000o();
                    O000000o2.f18543O000000o = shareUserRecord;
                    if (O000000o2.f18543O000000o != null) {
                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("user_mgr_user_info_updated"));
                    }
                    gsy.O00000Oo(LogType.GENERAL, SettingMainPageV2.O00000Oo, "refreshUIByReloadingUserInfo onSuccess ".concat(String.valueOf(shareUserRecord)));
                    gyl.O000000o();
                    gyl.O00000Oo(shareUserRecord.url, SettingMainPageV2.this.mUsrIcon, new gny());
                }
            }

            public final void O000000o(int i) {
                if (SettingMainPageV2.this.isValid()) {
                    gsy.O00000Oo(LogType.GENERAL, SettingMainPageV2.O00000Oo, "refreshUIByReloadingUserInfo onFailure ".concat(String.valueOf(i)));
                    SettingMainPageV2.this.O00000oo();
                }
            }

            public final void O000000o(int i, Object obj) {
                if (SettingMainPageV2.this.isValid()) {
                    LogType logType = LogType.GENERAL;
                    String str = SettingMainPageV2.O00000Oo;
                    gsy.O00000Oo(logType, str, "refreshUIByReloadingUserInfo onFailure " + i + "," + obj);
                    SettingMainPageV2.this.O00000oo();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O0000o0o = new O00000Oo(this);
        fno.O000000o().O000000o(this.O0000o0o);
        IntentFilter intentFilter = new IntentFilter("force_update_data_completed");
        intentFilter.addAction("action_on_login_success");
        intentFilter.addAction("action_on_logout");
        intentFilter.addAction("action_locale_changed");
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.O0000o, intentFilter);
        String str = O00000Oo;
        gsy.O00000Oo(str, O00000Oo + "onCreate");
    }

    public void onPause() {
        super.onPause();
        gva.O000000o().removeRedPointView("loc_setting_btn_help");
        gva.O000000o().removeRedPointView("loc_setting_btn_detail_setting");
    }

    public void onDestroyView() {
        this.O00000o = true;
        this.f17283O000000o = null;
        super.onDestroyView();
    }

    public void onDestroy() {
        super.onDestroy();
        fno.O000000o().O00000Oo(this.O0000o0o);
        try {
            ft.O000000o(getContext()).O000000o(this.O0000oo);
            ft.O000000o(getContext()).O000000o(this.O0000o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.O00000o0.O00000oO();
    }

    private void O0000OoO() {
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.O0000oOo);
    }

    public void onSwitchtoPage(int i, boolean z) {
        this.O0000o00 = z;
        if (z && this.O0000o0 != null) {
            if (hyy.O000000o()) {
                O000000o(this.O0000o0.getCurrentItem() - 1);
            }
            O000000o(this.O0000o0.getCurrentItem());
        }
        O000000o(z);
        if (z) {
            this.O0000oo0 = hxi.O00000o0.O00000o0(0L);
            if (!CoreApi.O000000o().O0000Ooo()) {
                O0000OoO();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("action.passwordlogin.login.complete");
                ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.O0000oOo, intentFilter);
            }
        } else if (this.O0000oo0 > 0) {
            hxi.O00000o0.O00000o0(this.O0000oo0);
            this.O0000oo0 = 0;
            O0000OoO();
        }
        gsy.O000000o(LogType.GENERAL, O00000Oo, "onSwitchtoPage  ".concat(String.valueOf(z)));
        if (z) {
            gva.O000000o().setRedPointView("loc_setting_btn_help", new gus() {
                /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass14 */

                public final void showRedPoint(boolean z) {
                    if (SettingMainPageV2.this.mImgFeedbackDot != null) {
                        SettingMainPageV2.this.O00000oo.post(new Runnable(z) {
                            /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$14$ueOFAB_9pFpfprxkYjVJ9LNAFU */
                            private final /* synthetic */ boolean f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                SettingMainPageV2.AnonymousClass14.this.O000000o(this.f$1);
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(boolean z) {
                    SettingMainPageV2.this.mImgFeedbackDot.setVisibility(z ? 0 : 8);
                }
            });
            gva.O000000o().setRedPointView("loc_setting_btn_detail_setting", new gus() {
                /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass2 */

                public final void showRedPoint(boolean z) {
                    if (SettingMainPageV2.this.mImgAboutDot != null) {
                        SettingMainPageV2.this.O00000oo.post(new Runnable(z) {
                            /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$2$lTYVciETlMtIvN7hkxBpclYx4ic */
                            private final /* synthetic */ boolean f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                SettingMainPageV2.AnonymousClass2.this.O000000o(this.f$1);
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(boolean z) {
                    SettingMainPageV2.this.mImgAboutDot.setVisibility(z ? 0 : 8);
                }
            });
            gva.O000000o().setRedPointView("loc_pincode_new", new gus() {
                /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$t4PZGTZQZNAmJqHimDPqsSxzf0 */

                public final void showRedPoint(boolean z) {
                    SettingMainPageV2.this.O00000Oo(z);
                }
            });
            gva.O000000o().setRedPointView("red_point_consumables", new gus() {
                /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2.AnonymousClass3 */

                public final void showRedPoint(boolean z) {
                    if (SettingMainPageV2.this.mConsumableRedDot != null) {
                        if (z) {
                            z = ServiceApplication.getStateNotifier().f15923O000000o == 4;
                        }
                        SettingMainPageV2.this.O00000oo.post(new Runnable(z) {
                            /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$3$Egfv1SEbt0REor9T7lv69kXVApQ */
                            private final /* synthetic */ boolean f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                SettingMainPageV2.AnonymousClass3.this.O000000o(this.f$1);
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(boolean z) {
                    SettingMainPageV2.this.mConsumableRedDot.setVisibility(z ? 0 : 8);
                }
            });
            new Thread(new Runnable() {
                /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$PxQZYzvehWGQM4S8jZDAQmrex0k */

                public final void run() {
                    SettingMainPageV2.this.O0000o0o();
                }
            }).start();
            ServiceApplication.getGlobalWorkerHandler().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.miio.page.$$Lambda$SettingMainPageV2$U0vDlGEMPrSATJNfJz6RGqAxjcI */

                public final void run() {
                    SettingMainPageV2.this.O0000o0O();
                }
            }, 100);
            if (this.mThirdAccountBtn == null) {
                return;
            }
            if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || !fbv.O000000o().O00000o) {
                this.mThirdAccountBtn.setVisibility(8);
            } else {
                this.mThirdAccountBtn.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000o0o() {
        if (isValid()) {
            FragmentActivity activity = getActivity();
            gpv.O000000o(activity, "setting_main_new_msg_timestamp" + CoreApi.O000000o().O0000o0(), (System.currentTimeMillis() + ServerTimerManager.O000000o(CommonApplication.getAppContext()).O00000Oo()) / 1000);
            gva.O000000o().setAllModelUpdateIgnore();
            gva.O000000o().setAllPluginUpdateIgnore();
            gva.O000000o().ignoreThisNewVersion();
            gwv.O00000Oo().O000000o(getContext());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000o0O() {
        if (isValid()) {
            gva.O000000o().checkAppUpdate(getActivity());
            gva.O000000o().checkModelUpdate(getActivity());
            guz O000000o2 = gva.O000000o();
            Context appContext = ServiceApplication.getAppContext();
            O000000o2.checkNewMessageForProfile(gpv.O00000Oo(appContext, "setting_main_new_msg_timestamp" + CoreApi.O000000o().O0000o0(), System.currentTimeMillis()), 2);
            gva.O000000o().setSignStateTodayIgnore();
            gva.O000000o().checkFeedback();
            gva.O000000o().checkPluginUpdate();
        }
    }

    private void O0000Ooo() {
        if (getActivity() != null) {
            PermissionRequestActivity.Companion.O000000o(getActivity());
        }
        hxi.O00000o.f952O000000o.O000000o("mycanter_authorize", new Object[0]);
    }

    private void O0000o00() {
        SimpleDraweeView simpleDraweeView = this.mUsrIcon;
        if (simpleDraweeView != null) {
            simpleDraweeView.setImageResource(R.drawable.user_not_log_in_v2);
        }
    }

    private void O0000o0() {
        if (gwg.O000000o((Activity) getActivity()) && this.mLoginFrame != null) {
            int O000000o2 = hzf.O000000o(CommonApplication.getAppContext());
            if (this.mLoginFrame.getLayoutParams().height > 0) {
                this.mLoginFrame.getLayoutParams().height += O000000o2;
            }
            this.mLoginFrame.setPadding(0, O000000o2, 0, 0);
            View view = this.mLoginFrame;
            view.setLayoutParams(view.getLayoutParams());
        }
    }

    @OnClick({5077, 6134, 6135})
    public void onClickLoginFrame() {
        hxi.O00000o.f952O000000o.O000000o("mycanter_personal", new Object[0]);
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            gty.O000000o().startLogin(getActivity(), 1, null);
            return;
        }
        Intent intent = new Intent(getActivity(), LogoutActivity.class);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000o0(android.content.Context, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.gpv.O00000o0(android.content.SharedPreferences, java.lang.String, java.lang.String):void
      _m_j.gpv.O00000o0(android.content.Context, java.lang.String, boolean):void */
    @OnClick({5396, 5759, 5769, 5775, 5758, 5771, 5760, 5762, 5772, 5761, 5757, 5766, 5774, 5768, 5765, 5764})
    public void onClickDispatcher(View view) {
        String str;
        if (view != null) {
            int id = view.getId();
            if (id == R.id.iv_qrcode) {
                hte.O000000o(getContext(), "iv_qrcode");
            } else if (id == R.id.rl_consumables) {
                if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                    gty.O000000o().showLoginDialog(getActivity(), false);
                    return;
                }
                hxi.O00000o.f952O000000o.O000000o("mycanter_consumables", new Object[0]);
                hxi.O00000o.f952O000000o.O000000o("android_native_consumable_page", new Object[0]);
                Intent intent = new Intent();
                intent.setClass(getActivity(), ConsumablesActivity.class);
                startActivity(intent);
                if (this.mConsumableRedDot.getVisibility() == 0) {
                    gwv O00000Oo2 = gwv.O00000Oo();
                    try {
                        String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
                        if (!TextUtils.isEmpty(O000000o2)) {
                            O00000Oo2.O00000Oo = ServiceApplication.getAppContext().getSharedPreferences(O000000o2 + "_consumable_list", 0);
                        }
                    } catch (Exception unused) {
                    }
                    if (O00000Oo2.O00000Oo != null) {
                        SharedPreferences.Editor edit = O00000Oo2.O00000Oo.edit();
                        edit.putLong("timestamp", System.currentTimeMillis());
                        edit.apply();
                    }
                }
                gva.O000000o().notifyViewClicked("red_point_consumables");
            } else if (id == R.id.rl_share) {
                if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                    startActivity(new Intent(getActivity(), SharePolymerizationActivity.class));
                } else {
                    gty.O000000o().showLoginDialog(getActivity(), false);
                }
                hxi.O00000o.f952O000000o.O000000o("mycanter_shareddevices", new Object[0]);
            } else if (id == R.id.rl_voice_control) {
                hxi.O00000o.f952O000000o.O000000o("mycanter_voivecontrol", new Object[0]);
                if (getActivity() == null) {
                    return;
                }
                if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                    fbs.O000000o(new fbt(getActivity(), "VoiceSettingActivity"));
                } else {
                    gty.O000000o().showLoginDialog(getActivity(), false);
                }
            } else if (id == R.id.rl_bluetooth_gateway) {
                if (getActivity() == null) {
                    return;
                }
                if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                    gty.O000000o().showLoginDialog(getActivity(), false);
                    return;
                }
                hxi.O00000o.f952O000000o.O000000o("mycanter_BLEgate", new Object[0]);
                fbs.O000000o(new fbt(getActivity(), "BleGatewayListActivity"));
            } else if (id == R.id.rl_shop) {
                hxi.O00000o.f952O000000o.O000000o("mycanter_myshop", new Object[0]);
                if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                    hjp.O000000o("https://home.mi.com/shop/shopshortcut");
                } else {
                    gty.O000000o().showLoginDialog(getActivity(), false);
                }
            } else if (id == R.id.rl_family) {
            } else {
                if (id == R.id.rl_laboratory) {
                    startActivity(new Intent(getActivity(), LaboratoryActivity.class));
                    gpv.O00000o0(this.mContext.getApplicationContext(), "lab_red_dot_shown", true);
                    this.mLaboratoryRedDot.setVisibility(8);
                    hxi.O00000o.f952O000000o.O000000o("mycanter_experimentalfeatures", new Object[0]);
                } else if (id == R.id.rl_third_account) {
                    hxi.O00000o.f952O000000o.O000000o("mycanter_otherplatforms", new Object[0]);
                    if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                        fbs.O000000o(new fbt(getActivity(), "ThirdAccountGroupListActivity"));
                    } else {
                        gty.O000000o().showLoginDialog(getActivity(), false);
                    }
                } else if (id == R.id.rl_feedback) {
                    hxi.O00000o.f952O000000o.O000000o("mycanter_help", new Object[0]);
                    gva.O000000o().notifyViewClicked("loc_setting_btn_help");
                    if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                        Intent intent2 = new Intent();
                        intent2.setClass(getActivity(), FeedBackMainActivity.class);
                        startActivity(intent2);
                        return;
                    }
                    Intent intent3 = new Intent();
                    intent3.setClass(getActivity(), FeedbackActivity.class);
                    intent3.putExtra("extra_device_model", "exp");
                    intent3.putExtra("extra_source", 0);
                    startActivity(intent3);
                } else if (id == R.id.rl_about) {
                    gva.O000000o().notifyViewClicked("loc_setting_btn_detail_setting");
                    hxi.O00000o.f952O000000o.O000000o("mycanter_set", new Object[0]);
                    fbt fbt = new fbt(getActivity(), "/setting/AboutActivity");
                    fbt.O000000o(100);
                    fbs.O000000o(fbt);
                } else if (id == R.id.rl_rn_debug) {
                    RnDebugClassifyActivity.startActivity(getActivity());
                } else if (id == R.id.rl_voice_assistant) {
                    hxi.O00000o.f952O000000o.O000000o("mycanter_navigationi", "title", "语音助手");
                    fbt fbt2 = new fbt(CommonApplication.getAppContext(), "CommonWebViewActivity");
                    Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                    if (O00oOooo == null) {
                        O00oOooo = Locale.getDefault();
                    }
                    StringBuilder sb = new StringBuilder();
                    String str2 = "home.mi.com";
                    ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                    String O00oOooO = CoreApi.O000000o().O00oOooO();
                    if (O0000ooO == null || ftn.O00000o0(O0000ooO)) {
                        if (!TextUtils.isEmpty(O00oOooO) && !O00oOooO.equalsIgnoreCase("release") && O00oOooO.equalsIgnoreCase("preview")) {
                            str2 = "pv.".concat(str2);
                        }
                    } else if (TextUtils.isEmpty(O00oOooO) || O00oOooO.equalsIgnoreCase("release") || !O00oOooO.equalsIgnoreCase("preview")) {
                        str2 = O0000ooO.f7546O000000o + "." + str2;
                    } else {
                        str2 = "pv." + O0000ooO.f7546O000000o + "." + str2;
                    }
                    sb.append("https://".concat(String.valueOf(str2)));
                    sb.append("/views/voice_assistant.html");
                    if (O00oOooo == null) {
                        str = "";
                    } else {
                        str = "?locale=" + flk.O000000o(O00oOooo);
                    }
                    sb.append(str);
                    fbs.O000000o(fbt2.O000000o("url", sb.toString()).O000000o("title", getString(R.string.miio_setting_voice_service)).O00000Oo(268435456));
                } else if (id == R.id.rl_score) {
                    hxi.O00000o.f952O000000o.O000000o("mycanter_app_score", new Object[0]);
                    exq.O000000o((BaseActivity) getActivity());
                } else if (id == R.id.rl_privacy) {
                    hxi.O00000o.f952O000000o.O000000o("mycanter_privacypolicy", new Object[0]);
                    startActivity(new Intent(getActivity(), LicenseChooseActivity.class));
                } else if (id == R.id.rl_permission) {
                    O0000Ooo();
                }
            }
        }
    }

    private static void O000000o(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    z = true;
                    break;
                } else if (viewGroup.getChildAt(i).getVisibility() == 0) {
                    break;
                } else {
                    i++;
                }
            }
            if (viewGroup.getParent() != null) {
                ((ViewGroup) viewGroup.getParent()).setVisibility(z ? 8 : viewGroup.getVisibility());
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.O0000oOO.isEmpty()) {
            this.O0000o0.O000000o(3000);
            this.O0000o0.O000000o(hyy.O000000o());
            this.O0000o0.O000000o(hyy.O000000o() ? ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_LEFT : ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
            this.O0000o0.O000000o();
            oOO0OOo0 ooo0ooo0 = new oOO0OOo0();
            ooo0ooo0.O00000Oo(this.O0000o0O);
            ooo0ooo0.O000000o(hyy.O000000o() ? "5.6:1" : "2.8:1");
            ooo0ooo0.O00000o0(this.O0000o0O);
            if (hyy.O000000o()) {
                this.O0000o0.setPointViewBottomMargin(gpc.O000000o(10.0f));
                this.O0000o0.setPointViewLeftMargin(gpc.O000000o(20.0f));
                return;
            }
            this.O0000o0.setPointViewBottomMargin(gpc.O000000o(5.0f));
            this.O0000o0.setPointViewLeftMargin(gpc.O000000o(0.0f));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(hjt hjt, View view) {
        hjo.O000000o(4, hjt.f19003O000000o, hjt.O00000Oo);
        int intValue = ((Integer) view.getTag()).intValue();
        hxk hxk = hxi.O00000o;
        String str = hjt.f19003O000000o;
        String str2 = hjt.O00000o0;
        String str3 = hjt.O00000Oo;
        String str4 = hjt.O00000o;
        hxk.f952O000000o.O000000o("profile_service_icon_click", "link", str, "asset_id", str2, "asset_name", str3, "exp_id", str4, hxg.f948O000000o, Integer.valueOf(intValue));
    }
}
