package com.xiaomi.mico;

import _m_j.cox;
import _m_j.dka;
import _m_j.fno;
import _m_j.ft;
import _m_j.ftn;
import _m_j.fvn;
import _m_j.fvq;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.hxi;
import _m_j.hxp;
import _m_j.jgc;
import _m_j.jgi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseFragment;
import com.xiaomi.mico.common.adapter.TabPagerAdapter;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.event.KKBoxAuthEvent;
import com.xiaomi.mico.common.event.QQAuthUiListener;
import com.xiaomi.mico.common.immersionmenu.ImmersionPopupWindowV3;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.schema.handler.SkillSchemaHandler;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.MicoLoadingView;
import com.xiaomi.mico.main.MicoRecyclerAdapter;
import com.xiaomi.mico.main.MicoTabsApi;
import com.xiaomi.mico.main.TabInfo;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.banner.TabBannerHelper;
import com.xiaomi.mico.music.channel.ChannelManager;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.patchwall.DeDaoPatchWallFragment;
import com.xiaomi.mico.music.patchwall.IntelligentPatchWallFragment;
import com.xiaomi.mico.music.patchwall.KKBoxPatchWallFragment;
import com.xiaomi.mico.music.patchwall.KidsPatchWallFragment;
import com.xiaomi.mico.music.patchwall.MiPatchWallFragment;
import com.xiaomi.mico.music.patchwall.QQPatchWallFragment;
import com.xiaomi.mico.music.patchwall.RadioPatchWallFragment;
import com.xiaomi.mico.music.patchwall.TopQualityPatchWallFragment;
import com.xiaomi.mico.music.patchwall.micoselect.MicoSelectPatchWallFragment;
import com.xiaomi.mico.music.patchwall.micoselect.SelectPagerListener;
import com.xiaomi.mico.music.player.PlayerControler;
import com.xiaomi.mico.music.search.SearchActivity;
import com.xiaomi.mico.setting.MicoMyActivity;
import com.xiaomi.mico.setting.mijia.MijiaCacheManager;
import com.xiaomi.mico.setting.mijia.event.MijiaEvent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

public class MicoMainFragment extends MicoBaseFragment implements fvn, fvq, SelectPagerListener {
    public static boolean hasCheckKkBoxMembership;
    public static String sCurrentPageType;
    private static long sLastShowTime;
    int currentItem = 0;
    boolean deviceOnlineStatusChange = false;
    String fromPluginDid = "";
    boolean isRequestingTabs = false;
    private long lastSwitchInTime = 0;
    @BindView(6570)
    AppBarLayout mAppBarLayout;
    @BindView(6531)
    ImageView mBackImgView;
    @BindView(7228)
    CoordinatorLayout mCoordinatorLayout;
    Admin.Mico mCurMico = null;
    private MicoBaseFragment mCurrentFragment;
    private fno.O000000o mDeviceListener = new fno.O000000o() {
        /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass11 */

        public void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public void onRefreshClientDeviceFailed(int i) {
        }

        public void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                MicoMainFragment.this.reloadMicoList();
            }
        }
    };
    boolean mDeviceStatusChange = false;
    @BindView(6540)
    ImageView mDropDwonView;
    String mExternalTabType = "";
    private volatile boolean mIsDestroyed = true;
    @BindView(6564)
    MicoLoadingView mLoadingView;
    public LoginManager.LoginManagerCallback mLoginManagerCallback = new LoginManager.LoginManagerCallback() {
        /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass9 */

        public void onLoginSuccess() {
            MicoMainFragment.this.refreshData();
        }

        public void onLogout() {
            MicoMainFragment.this.updateMicoStatus();
            MusicEvent.PlayerStatusUpdate playerStatusUpdate = (MusicEvent.PlayerStatusUpdate) jgc.O000000o().O000000o(MusicEvent.PlayerStatusUpdate.class);
            if (playerStatusUpdate != null) {
                jgc.O000000o().O00000oo(playerStatusUpdate);
            }
            MicoMainFragment.this.mPlayerControler.updatePlayerStatus(null);
        }
    };
    @BindView(6572)
    TextView mMenu;
    @BindView(6569)
    SimpleDraweeView mMenuIcon;
    @BindView(6533)
    RelativeLayout mMicoChooseView;
    @BindView(6593)
    LinearLayout mMicoTitleView;
    @BindView(6675)
    PlayerControler mPlayerControler;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass14 */

        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals("action_device_move_to home_or_room", intent.getAction())) {
                MicoMainFragment.this.reloadMicoList();
            }
        }
    };
    List<TabInfo> mRemoteTabs = null;
    @BindView(6580)
    View mRightFade;
    View mRootView;
    @BindView(6581)
    ImageView mSearchIcon;
    @BindView(6589)
    ImageView mTabSearchIcon;
    @BindView(6590)
    ImageView mTabUserIcon;
    @BindView(6575)
    LinearLayout mTipsContainerView;
    @BindView(6573)
    Toolbar mToolBar;
    @BindView(6596)
    ImageView mUserIcon;
    @BindView(6693)
    ViewPager mViewPager;
    MicoRecyclerAdapter micoRecyclerAdapter;
    boolean needMicoPatchwall = false;
    public long showOfflineTime = 0;
    @BindView(6591)
    SmartTabLayout smartTabLayout;
    @BindView(7162)
    View tabLeftSpace;
    private TabPagerAdapter tabPagerAdapter;
    public List<TabPagerAdapter.TabPage> tabPages;
    private boolean titleSettled;

    public boolean onBackPressed() {
        return false;
    }

    public void onPageSelected() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fromPluginDid = arguments.getString("did");
            this.mExternalTabType = arguments.getString("tabType");
        }
        CoreApi.O000000o().O000000o(getActivity(), new CoreApi.O0000o00() {
            /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass1 */

            public void onAccountReady(boolean z, String str) {
                LoginManager.getInstance().addLoginManagerCallback(MicoMainFragment.this.mLoginManagerCallback);
            }
        });
        jgc.O000000o().O000000o(this);
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.mReceiver, new IntentFilter("action_device_move_to home_or_room"));
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate((int) R.layout.mico_activity_main, (ViewGroup) null);
            ButterKnife.bind(this, this.mRootView);
            initViews();
            refreshData();
        }
        this.mIsDestroyed = false;
        fno.O000000o().O000000o(this.mDeviceListener);
        return this.mRootView;
    }

    public void refreshData() {
        updateCurrentMicoInfo();
        getOriginName();
        this.mLoadingView.startLoading(true, true);
        MicoManager.getInstance().getMicoList(new IncompleteApiListener() {
            /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass2 */

            public void onSuccess() {
                if (!TextUtils.isEmpty(MicoMainFragment.this.fromPluginDid)) {
                    MicoManager.getInstance().selectMicoByMiotDID(MicoMainFragment.this.fromPluginDid);
                }
                MicoMainFragment.this.loadTabData();
                if (MicoMainFragment.this.deviceOnlineStatusChange) {
                    MicoMainFragment.this.checkOffline();
                    MicoMainFragment.this.deviceOnlineStatusChange = false;
                }
                MijiaCacheManager.loadHomeData(null, MicoMainFragment.this.getActivity(), MijiaEvent.Reason.MAIN_ACTIVITY);
            }

            public void onFailure(ApiError apiError) {
                LogType logType = LogType.GENERAL;
                gsy.O00000Oo(logType, "Mico-Api", "getMicoList-->" + apiError.toString());
                MicoMainFragment.this.loadTabData();
            }
        }, false);
        TabBannerHelper.getInstance().updateBanner();
        AccountProfile.current().getMusicSourceInfo(true).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<AccountProfile.MusicSuorce>() {
            /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass3 */

            public void call(AccountProfile.MusicSuorce musicSuorce) {
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass4 */

            public void call(Throwable th) {
            }
        }, new Action0() {
            /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass5 */

            public void call() {
            }
        });
    }

    public void loadTabData() {
        if (ftn.O00000oo(this.mContext)) {
            this.isRequestingTabs = true;
            MicoTabsApi.getInstance().getMicoTabInfo(new MicoTabsApi.OnTabsInfoReadyListener() {
                /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass6 */

                public void onTabsInfoReady(List<TabInfo> list) {
                    if (list != null) {
                        gsy.O00000Oo("Mico-Api", "tabInfos->" + list.size());
                    }
                    MicoMainFragment.this.mLoadingView.stopLoading();
                    MicoMainFragment micoMainFragment = MicoMainFragment.this;
                    micoMainFragment.mRemoteTabs = list;
                    micoMainFragment.isRequestingTabs = false;
                    micoMainFragment.setPatchwall();
                    if (!TextUtils.isEmpty(MicoMainFragment.this.mExternalTabType)) {
                        MicoMainFragment micoMainFragment2 = MicoMainFragment.this;
                        if (micoMainFragment2.canFindExTabIndex(micoMainFragment2.mExternalTabType)) {
                            MicoMainFragment micoMainFragment3 = MicoMainFragment.this;
                            micoMainFragment3.switchMusicPage(micoMainFragment3.mExternalTabType);
                            MicoMainFragment micoMainFragment4 = MicoMainFragment.this;
                            micoMainFragment4.mExternalTabType = "";
                            micoMainFragment4.getArguments().remove("tabType");
                        }
                    }
                }

                public void onErrorTabs() {
                    gsy.O00000Oo("Mico-Api", "loadTabData-->error");
                    MicoMainFragment.this.mLoadingView.stopLoading();
                    MicoMainFragment.this.isRequestingTabs = false;
                    ToastUtil.showToast((int) R.string.common_server_error);
                }
            }, musicSource().getSource());
        } else if (ftn.O0000Oo0(this.mContext)) {
            this.mLoadingView.stopLoading();
            setPatchwall();
        }
    }

    private void initViews() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mUserIcon.setForceDarkAllowed(false);
            this.mSearchIcon.setForceDarkAllowed(false);
            this.mRightFade.setForceDarkAllowed(false);
        }
        this.mUserIcon.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.$$Lambda$MicoMainFragment$os5hFvdoOYb0kyJEbhLkhMomOrc */

            public final void onClick(View view) {
                MicoMainFragment.this.lambda$initViews$0$MicoMainFragment(view);
            }
        });
        this.mSearchIcon.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.$$Lambda$MicoMainFragment$WPzrZ91ydSm4EOswMKxULZWieK8 */

            public final void onClick(View view) {
                MicoMainFragment.this.lambda$initViews$1$MicoMainFragment(view);
            }
        });
        this.mTabSearchIcon.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.$$Lambda$MicoMainFragment$i8neW5Z9FwJ8I8bEsVkyMSGFIw8 */

            public final void onClick(View view) {
                MicoMainFragment.this.lambda$initViews$2$MicoMainFragment(view);
            }
        });
        this.mTabUserIcon.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.$$Lambda$MicoMainFragment$VNeZaLKnXuqDMHSv8Y5_qq098 */

            public final void onClick(View view) {
                MicoMainFragment.this.lambda$initViews$3$MicoMainFragment(view);
            }
        });
        this.mBackImgView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.$$Lambda$MicoMainFragment$g63IvG8lgGwBYJzuX6bcMe4UtPw */

            public final void onClick(View view) {
                MicoMainFragment.this.lambda$initViews$4$MicoMainFragment(view);
            }
        });
        if (getArguments() == null || !TextUtils.equals("micoPlugin", getArguments().getString("from"))) {
            this.mBackImgView.setVisibility(8);
        } else {
            this.mBackImgView.setVisibility(0);
        }
        this.mAppBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
            /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass7 */
            int lastSate;
            int titleBarHight = DisplayUtils.dip2px(MicoMainFragment.this.getContext(), 53.0f);

            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int abs = Math.abs(i);
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                if (i == 0) {
                    MicoMainFragment.this.mToolBar.setVisibility(0);
                    MicoMainFragment.this.mTabSearchIcon.setVisibility(8);
                    MicoMainFragment.this.mTabUserIcon.setVisibility(8);
                    if (this.lastSate == 2) {
                        MicoMainFragment.this.mPlayerControler.showWithAnimation();
                    }
                    MicoMainFragment.this.mMicoTitleView.setVisibility(0);
                    MicoMainFragment.this.mMicoTitleView.setAlpha(1.0f);
                    this.lastSate = 1;
                } else if (abs >= totalScrollRange) {
                    MicoMainFragment.this.mToolBar.setVisibility(8);
                    MicoMainFragment.this.mMicoTitleView.setVisibility(4);
                    MicoMainFragment.this.mTabSearchIcon.setVisibility(0);
                    MicoMainFragment.this.mTabUserIcon.setVisibility(0);
                    if (this.lastSate == 1) {
                        MicoMainFragment.this.mPlayerControler.hideWithAnimation();
                    }
                    this.lastSate = 2;
                } else {
                    if (MicoMainFragment.this.mMicoTitleView.getVisibility() != 0) {
                        MicoMainFragment.this.mMicoTitleView.setVisibility(0);
                        MicoMainFragment.this.mTabSearchIcon.setVisibility(8);
                        MicoMainFragment.this.mTabUserIcon.setVisibility(8);
                    }
                    float f = 1.0f - ((((float) abs) * 1.0f) / ((float) totalScrollRange));
                    if (abs > this.titleBarHight) {
                        MicoMainFragment.this.mToolBar.setVisibility(8);
                        MicoMainFragment.this.mMicoTitleView.setAlpha(f);
                        return;
                    }
                    MicoMainFragment.this.mMicoTitleView.setAlpha(1.0f);
                    MicoMainFragment.this.mToolBar.setVisibility(0);
                }
            }
        });
        this.smartTabLayout.setOnTabClickListener(new SmartTabLayout.O00000o() {
            /* class com.xiaomi.mico.$$Lambda$MicoMainFragment$vsKt2QhiX4L7erqRa6MXWObv7g */

            public final void onTabClicked(int i) {
                MicoMainFragment.this.lambda$initViews$5$MicoMainFragment(i);
            }
        });
        this.smartTabLayout.setOnPageChangeListener(new ViewPager.O0000O0o() {
            /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass8 */
            private int currentPosition;
            private int currentScrollState;
            private int direction;
            private int lastScrollState;
            private int mPosition;
            private int nextPosiiton;
            private float width = ((float) DisplayUtils.getScreenWidthPixels(MicoMainFragment.this.getContext()));
            private float widthPixels = ((float) (DisplayUtils.getScreenWidthPixels(MicoMainFragment.this.getContext()) / 2));

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.lang.Math.max(float, float):float}
             arg types: [int, float]
             candidates:
              ClspMth{java.lang.Math.max(double, double):double}
              ClspMth{java.lang.Math.max(int, int):int}
              ClspMth{java.lang.Math.max(long, long):long}
              ClspMth{java.lang.Math.max(float, float):float} */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.lang.Math.min(float, float):float}
             arg types: [int, float]
             candidates:
              ClspMth{java.lang.Math.min(double, double):double}
              ClspMth{java.lang.Math.min(long, long):long}
              ClspMth{java.lang.Math.min(int, int):int}
              ClspMth{java.lang.Math.min(float, float):float} */
            public void onPageScrolled(int i, float f, int i2) {
                float f2;
                float f3;
                if (this.lastScrollState == 1 || this.currentScrollState == 1) {
                    if (this.direction == 0) {
                        this.direction = ((float) i2) < this.widthPixels ? 1 : -1;
                    }
                    if (i2 > 0) {
                        float f4 = ((float) i2) / this.width;
                        int i3 = this.direction;
                        if (i3 > 0) {
                            this.currentPosition = i;
                            this.nextPosiiton = i + i3;
                            f3 = (1.0f - f4) * 22.0f;
                            f2 = (f4 + 1.0f) * 22.0f;
                        } else {
                            this.nextPosiiton = i;
                            this.currentPosition = i + 1;
                            f3 = f4 * 22.0f;
                            f2 = (2.0f - f4) * 22.0f;
                        }
                        ((TextView) MicoMainFragment.this.smartTabLayout.O000000o(this.currentPosition)).setTextSize(Math.max(22.0f, f3));
                        ((TextView) MicoMainFragment.this.smartTabLayout.O000000o(this.nextPosiiton)).setTextSize(Math.min(22.0f, f2));
                        return;
                    }
                    this.direction = 0;
                    this.mPosition = i;
                    ((TextView) MicoMainFragment.this.smartTabLayout.O000000o(i)).setTextSize(22.0f);
                }
            }

            public void onPageSelected(int i) {
                TabPagerAdapter.TabPage tabPage;
                int i2;
                MicoMainFragment.this.refreshTabState(i);
                MicoMainFragment micoMainFragment = MicoMainFragment.this;
                micoMainFragment.currentItem = i;
                if (i >= 0 && i < micoMainFragment.tabPages.size() && (tabPage = MicoMainFragment.this.tabPages.get(i)) != null) {
                    String str = "content_music_page";
                    if (TextUtils.equals(tabPage.type, "music")) {
                        AccountProfile.MusicSuorce musicSource = AccountProfile.current().getMusicSource();
                        if (AccountProfile.MusicSuorce.MI.getSource().equals(musicSource.getSource())) {
                            i2 = 2;
                        } else {
                            i2 = AccountProfile.MusicSuorce.QQ.getSource().equals(musicSource.getSource()) ? 1 : 0;
                        }
                        hxi.O00000o0.f957O000000o.O000000o(str, "type", Integer.valueOf(i2));
                    } else {
                        hxp hxp = hxi.O00000o0;
                        String str2 = tabPage.type;
                        if (TextUtils.equals(str2, "handpick")) {
                            str = "content_recommend_page";
                        } else if (TextUtils.equals(str2, "intelligent")) {
                            str = "content_intelligence_page";
                        } else if (!TextUtils.equals(str2, "music")) {
                            if (TextUtils.equals(str2, "kid")) {
                                str = "content_children_page";
                            } else if (TextUtils.equals(str2, "audioBook")) {
                                str = "content_sound_page";
                            } else {
                                str = TextUtils.equals(str2, "dedao") ? "content_obtain_page" : "";
                            }
                        }
                        hxp.f957O000000o.O000000o(str, new Object[0]);
                    }
                    MicoMainFragment.sCurrentPageType = tabPage.type;
                }
            }

            public void onPageScrollStateChanged(int i) {
                this.lastScrollState = this.currentScrollState;
                this.currentScrollState = i;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: handleTabClick */
    public void lambda$initViews$5$MicoMainFragment(int i) {
        if (i >= 0 && i < this.tabPages.size()) {
            hxi.O00000o.O000000o("content_tab_recommend", generateStatPos(i));
        }
        refreshTabState(i);
    }

    private JSONObject generateStatPos(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.tabPages.get(i).type;
            if (TextUtils.equals(str, "handpick")) {
                jSONObject.put("position", 1);
            } else if (TextUtils.equals(str, "intelligent")) {
                jSONObject.put("position", 2);
            } else if (TextUtils.equals(str, "music")) {
                jSONObject.put("position", 3);
            } else if (TextUtils.equals(str, "kid")) {
                jSONObject.put("position", 4);
            } else if (TextUtils.equals(str, "audioBook")) {
                jSONObject.put("position", 5);
            } else if (TextUtils.equals(str, "dedao")) {
                jSONObject.put("position", 6);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public void refreshTabState(int i) {
        int count = this.tabPagerAdapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            TextView textView = (TextView) this.smartTabLayout.O000000o(i2);
            if (textView != null) {
                if (i2 == i) {
                    textView.setTextSize(22.0f);
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    textView.setTextSize(22.0f);
                    textView.setTypeface(Typeface.defaultFromStyle(0));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onClickView */
    public void lambda$initViews$4$MicoMainFragment(View view) {
        int id = view.getId();
        if (id == R.id.mico_search_entrance) {
            getContext().startActivity(new Intent(getContext(), SearchActivity.class));
            hxi.O00000o.O000000o("content_search", (JSONObject) null);
        } else if (id == R.id.mico_user_entrance) {
            getContext().startActivity(new Intent(getContext(), MicoMyActivity.class));
            hxi.O00000o.O000000o("content_me", (JSONObject) null);
        } else if (id == R.id.mico_tab_search_entrance) {
            getContext().startActivity(new Intent(getContext(), SearchActivity.class));
            hxi.O00000o.O000000o("content_search", (JSONObject) null);
        } else if (id == R.id.mico_tab_user_entrance) {
            getContext().startActivity(new Intent(getContext(), MicoMyActivity.class));
            hxi.O00000o.O000000o("content_me", (JSONObject) null);
        } else if (id == R.id.mico_back_img) {
            getActivity().finish();
        }
    }

    public FragmentActivity getValidActivity() {
        FragmentActivity activity = super.getActivity();
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            return activity;
        }
        return null;
    }

    public boolean isValid() {
        return !this.mIsDestroyed;
    }

    public void refreshTitleBar() {
        gwg.O00000Oo(getActivity().getWindow());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mIsDestroyed = false;
        ChannelManager.getInstance().loadChannelList();
    }

    public void onDestroy() {
        this.mIsDestroyed = true;
        super.onDestroy();
        PlayerControler playerControler = this.mPlayerControler;
        if (playerControler != null) {
            playerControler.onDestroy();
        }
    }

    public void onSwitchtoPage(int i, boolean z) {
        doStatOnSwitchToPage(null, z);
        if (z) {
            if (this.deviceOnlineStatusChange) {
                checkOffline();
                this.deviceOnlineStatusChange = false;
            }
            if (ftn.O00000oo(this.mContext) && !this.isRequestingTabs) {
                List<TabInfo> list = this.mRemoteTabs;
                if (list == null || (list != null && list.size() == 0)) {
                    refreshData();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void doStatOnSwitchToPage(String str, boolean z) {
        View view;
        if (z) {
            this.lastSwitchInTime = hxi.O00000Oo.O000000o(this, str);
        } else if (this.lastSwitchInTime > 0) {
            hxi.O00000Oo.O000000o(this, this.lastSwitchInTime, str);
            this.lastSwitchInTime = 0;
        }
        if (z && (view = this.mRootView) != null) {
            view.requestLayout();
        }
    }

    public void onDestroyView() {
        ViewParent parent;
        super.onDestroyView();
        View view = this.mRootView;
        if (!(view == null || (parent = view.getParent()) == null || !(parent instanceof ViewGroup))) {
            ((ViewGroup) parent).removeView(this.mRootView);
        }
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.mReceiver);
        fno.O000000o().O00000Oo(this.mDeviceListener);
        jgc.O000000o().O00000o0(this);
        LoginManager.getInstance().removeLoginManagerCallbackCallback(this.mLoginManagerCallback);
        MijiaCacheManager.clear();
        MicoTabsApi.getInstance().removeTabsReadyListener();
    }

    public void onActivate() {
        super.onActivate();
        this.mPlayerControler.onResume();
    }

    public void onDeactivate() {
        super.onDeactivate();
        this.mPlayerControler.onPause();
    }

    public void setPatchwall() {
        if (isAdded()) {
            List<TabPagerAdapter.TabPage> list = this.tabPages;
            if (list != null) {
                list.clear();
                this.tabPages = null;
            }
            this.tabPages = new ArrayList();
            if (ftn.O00000oo(this.mContext)) {
                List<TabInfo> list2 = this.mRemoteTabs;
                if (list2 == null || list2.size() <= 0) {
                    List<TabInfo> generateCacheTabs = TabInfo.generateCacheTabs();
                    if (generateCacheTabs != null) {
                        for (TabInfo generatePageData : generateCacheTabs) {
                            generatePageData(generatePageData);
                        }
                    }
                } else {
                    for (TabInfo generatePageData2 : this.mRemoteTabs) {
                        generatePageData(generatePageData2);
                    }
                }
            } else if (ftn.O0000Oo0(this.mContext)) {
                this.tabPages.add(TabPagerAdapter.TabPage.newPage(new KKBoxPatchWallFragment(), getString(R.string.mico_tab_music_kkbox)));
                this.tabPages.add(TabPagerAdapter.TabPage.newPage(new RadioPatchWallFragment(), getString(R.string.mico_tab_audiobook_kkbox)));
            }
            this.smartTabLayout.setIndicationInterpolator(cox.O00000Oo);
            this.tabPagerAdapter = new TabPagerAdapter(getFragmentManager(), this.tabPages);
            this.mViewPager.setAdapter(this.tabPagerAdapter);
            if (ApiConstants.isAreaCodeInTaiWan()) {
                this.mViewPager.setOffscreenPageLimit(1);
            } else {
                this.mViewPager.setOffscreenPageLimit(2);
            }
            int i = 0;
            int i2 = this.currentItem;
            if (i2 != 0 && i2 >= 0) {
                i = i2;
            }
            this.smartTabLayout.setViewPager(this.mViewPager);
            this.mViewPager.setCurrentItem(i);
            refreshTabState(i);
            this.smartTabLayout.post(new Runnable() {
                /* class com.xiaomi.mico.$$Lambda$MicoMainFragment$sZADQsRzJtpwX6yy623JNKn0BJI */

                public final void run() {
                    MicoMainFragment.this.lambda$setPatchwall$6$MicoMainFragment();
                }
            });
        }
    }

    public /* synthetic */ void lambda$setPatchwall$6$MicoMainFragment() {
        this.smartTabLayout.fullScroll(17);
    }

    private void generatePageData(TabInfo tabInfo) {
        if (TextUtils.equals(tabInfo.type, "handpick")) {
            MicoSelectPatchWallFragment micoSelectPatchWallFragment = new MicoSelectPatchWallFragment();
            micoSelectPatchWallFragment.setSelectPagerListener(this);
            this.tabPages.add(TabPagerAdapter.TabPage.newPage(micoSelectPatchWallFragment, tabInfo.name, "handpick"));
        } else if (TextUtils.equals(tabInfo.type, "intelligent")) {
            this.tabPages.add(TabPagerAdapter.TabPage.newPage(new IntelligentPatchWallFragment(), tabInfo.name, "intelligent"));
        } else if (CoreApi.O000000o().O0000Ooo() && this.needMicoPatchwall) {
            if (TextUtils.equals(tabInfo.type, "music")) {
                if (TextUtils.equals(musicSource().getSource(), "QQ")) {
                    this.tabPages.add(TabPagerAdapter.TabPage.newPage(new QQPatchWallFragment(), tabInfo.name, "music"));
                } else {
                    this.tabPages.add(TabPagerAdapter.TabPage.newPage(new MiPatchWallFragment(), tabInfo.name, "music"));
                }
            } else if (TextUtils.equals(tabInfo.type, "kid")) {
                this.tabPages.add(TabPagerAdapter.TabPage.newPage(new KidsPatchWallFragment(), tabInfo.name, "kid"));
            } else if (TextUtils.equals(tabInfo.type, "audioBook")) {
                this.tabPages.add(TabPagerAdapter.TabPage.newPage(new RadioPatchWallFragment(), tabInfo.name, "audioBook"));
            } else if (TextUtils.equals(tabInfo.type, "uncleCassie")) {
                this.tabPages.add(TabPagerAdapter.TabPage.newPage(new TopQualityPatchWallFragment(), tabInfo.name, "uncleCassie"));
            } else if (TextUtils.equals(tabInfo.type, "dedao")) {
                this.tabPages.add(TabPagerAdapter.TabPage.newPage(new DeDaoPatchWallFragment(), tabInfo.name, "dedao"));
            }
        }
    }

    private void updateCurrentMicoInfo() {
        String str;
        MijiaCacheManager.Location location;
        Admin.Mico mico;
        Admin.Mico mico2;
        Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
        if ((this.mCurMico != null || currentMico == null) && (((mico = this.mCurMico) == null || !mico.isValid() || currentMico.isValid()) && ((mico2 = this.mCurMico) == null || mico2.isValid() || !currentMico.isValid()))) {
            this.mDeviceStatusChange = false;
        } else {
            this.mDeviceStatusChange = true;
        }
        setDeviceOnlineStatus(currentMico);
        this.mCurMico = currentMico;
        if (TextUtils.isEmpty(currentMico.deviceID) || TextUtils.isEmpty(currentMico.serialNumber)) {
            this.mMenu.setText(getString(R.string.mico_no_device));
            this.needMicoPatchwall = false;
            this.mMicoChooseView.setBackground(null);
            this.mMicoChooseView.setOnClickListener(null);
            this.mDropDwonView.setVisibility(8);
            this.mMenuIcon.setImageResource(R.drawable.mico_icon_unknown_device);
            this.mMenu.setAlpha(0.3f);
            if (ftn.O0000Oo0(this.mContext)) {
                this.mTipsContainerView.setVisibility(0);
                this.mViewPager.setVisibility(8);
                this.smartTabLayout.setVisibility(8);
            } else {
                this.mTipsContainerView.setVisibility(8);
                this.mViewPager.setVisibility(0);
                this.smartTabLayout.setVisibility(0);
            }
            setViewStatus(this.mUserIcon, false);
            setViewStatus(this.mSearchIcon, false);
            setViewStatus(this.mTabUserIcon, false);
            setViewStatus(this.mTabSearchIcon, false);
            return;
        }
        this.mMenu.setAlpha(1.0f);
        this.mViewPager.setVisibility(0);
        this.smartTabLayout.setVisibility(0);
        this.mTipsContainerView.setVisibility(8);
        this.mDropDwonView.setVisibility(0);
        setViewStatus(this.mUserIcon, true);
        setViewStatus(this.mSearchIcon, true);
        setViewStatus(this.mTabUserIcon, true);
        setViewStatus(this.mTabSearchIcon, true);
        this.mMicoChooseView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.$$Lambda$MicoMainFragment$er1kxVp4MAzkXj8vERsBkvDQ4VU */

            public final void onClick(View view) {
                MicoMainFragment.this.lambda$updateCurrentMicoInfo$7$MicoMainFragment(view);
            }
        });
        this.needMicoPatchwall = true;
        HashMap<Admin.Mico, MijiaCacheManager.Location> micoLocationMap = MijiaCacheManager.getMicoLocationMap();
        if (micoLocationMap != null) {
            Iterator<Map.Entry<Admin.Mico, MijiaCacheManager.Location>> it = micoLocationMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (TextUtils.equals(((Admin.Mico) next.getKey()).deviceID, currentMico.deviceID) && (location = (MijiaCacheManager.Location) next.getValue()) != null && location.room != null) {
                    str = location.room.name;
                    break;
                }
            }
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
            this.mMenu.setText(currentMico.getDisplayName());
        } else {
            SpannableString spannableString = new SpannableString(currentMico.getDisplayName() + " -" + str);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF999999")), currentMico.getDisplayName().length(), spannableString.length(), 33);
            this.mMenu.setText(spannableString);
        }
        this.mMicoChooseView.setBackground(null);
        if (currentMico.isOnline()) {
            this.mMenu.setAlpha(1.0f);
            this.mMenuIcon.setAlpha(1.0f);
        } else {
            this.mMenu.setAlpha(0.3f);
            this.mMenuIcon.setAlpha(0.3f);
        }
        if (!TextUtils.isEmpty(currentMico.miotDID)) {
            Device O000000o2 = fno.O000000o().O000000o(currentMico.miotDID);
            if (O000000o2 != null) {
                DeviceFactory.O00000Oo(O000000o2.model, this.mMenuIcon);
            } else if (currentMico.getHardwareType() != null) {
                this.mMenuIcon.setImageResource(currentMico.getHardwareType().getMenuIcon());
            } else {
                this.mMenuIcon.setImageResource(R.drawable.mico_icon_lx06_menu);
            }
        } else if (currentMico.getHardwareType() != null) {
            this.mMenuIcon.setImageResource(currentMico.getHardwareType().getMenuIcon());
        } else {
            this.mMenuIcon.setImageResource(R.drawable.mico_icon_lx06_menu);
        }
    }

    public /* synthetic */ void lambda$updateCurrentMicoInfo$7$MicoMainFragment(View view) {
        onMicoSelect();
    }

    private void setDeviceOnlineStatus(Admin.Mico mico) {
        Admin.Mico mico2 = this.mCurMico;
        if (mico2 == null || mico == null) {
            if (this.mCurMico == null && mico != null && mico.isOffline()) {
                this.deviceOnlineStatusChange = true;
            }
        } else if (TextUtils.equals(mico2.deviceID, mico.deviceID)) {
            if (this.mCurMico.isOnline() && mico.isOffline()) {
                this.deviceOnlineStatusChange = true;
            } else if (this.mCurMico.isOffline() && mico.isOnline()) {
                this.deviceOnlineStatusChange = false;
            }
        } else if (mico.isOffline()) {
            this.deviceOnlineStatusChange = true;
        }
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onCurrentMicoChanged(MicoEvent.CurrentMicoChanged currentMicoChanged) {
        if (this.mPlayerControler != null && TextUtils.isEmpty(currentMicoChanged.queryDeviceId)) {
            this.mPlayerControler.setVisibility(8);
        }
        this.mPlayerControler.resetCachedPlayerStatus();
        updateMicoStatus();
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onCurrentMicoInfoUpdate(MicoEvent.CurrentMicoInfoUpdate currentMicoInfoUpdate) {
        updateMicoStatus();
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onNeedChangePlayerControler(MusicEvent.PlayerControlerDisplay playerControlerDisplay) {
        if (isActivated() && this.mPlayerControler != null) {
            if (playerControlerDisplay.display()) {
                this.mPlayerControler.showWithAnimation();
            } else if (playerControlerDisplay.hide()) {
                this.mPlayerControler.hideWithAnimation();
            }
        }
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onMusicSourceChanged(MusicEvent.MusicSourceChanged musicSourceChanged) {
        loadTabData();
        ChannelManager.getInstance().reset();
        ChannelManager.getInstance().getChannelList(null);
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onHomeChanged(MijiaEvent.MijiaCurrHomeChanged mijiaCurrHomeChanged) {
        updateMicoStatus();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        updateCurrentMicoInfo();
    }

    public boolean titleBarSettled() {
        if (this.titleSettled) {
            return true;
        }
        this.titleSettled = true;
        return false;
    }

    public void onResume() {
        super.onResume();
        MicoManager.getInstance().startCheck();
    }

    public void onPause() {
        super.onPause();
        MicoManager.getInstance().stopCheck();
    }

    private void getOriginName() {
        ApiHelper.getOriginNameMap(new ApiRequest.Listener<Map<String, String>>() {
            /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass10 */

            public void onFailure(ApiError apiError) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((Map<String, String>) ((Map) obj));
            }

            public void onSuccess(Map<String, String> map) {
                MusicHelper.CP_TO_NAME_SERVER.putAll(map);
            }
        }).bindToLifecycle(this);
    }

    public void updateMicoStatus() {
        MicoRecyclerAdapter micoRecyclerAdapter2 = this.micoRecyclerAdapter;
        if (micoRecyclerAdapter2 != null) {
            micoRecyclerAdapter2.updatePopupWindow();
        }
        updateCurrentMicoInfo();
        if (this.mDeviceStatusChange) {
            loadTabData();
        }
    }

    private AccountProfile.MusicSuorce musicSource() {
        AccountProfile.MusicSuorce musicSource = AccountProfile.current().getMusicSource();
        if (musicSource == null) {
            musicSource = AccountProfile.current().getCacheMusicSource(AccountProfile.current().getUserId());
        }
        if (musicSource != null) {
            return musicSource;
        }
        AccountProfile.MusicSuorce musicSuorce = AccountProfile.MusicSuorce.QQ;
        AccountProfile.current().setMusicSource(musicSuorce.getSource());
        return musicSuorce;
    }

    public void onMicoSelect() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = sLastShowTime;
        sLastShowTime = currentTimeMillis;
        if (currentTimeMillis - j >= 1000) {
            hxi.O00000o.O000000o("content_device_switch", (JSONObject) null);
            ImmersionPopupWindowV3 immersionPopupWindowV3 = new ImmersionPopupWindowV3(getContext());
            this.micoRecyclerAdapter = new MicoRecyclerAdapter(getActivity());
            this.micoRecyclerAdapter.init(immersionPopupWindowV3);
            immersionPopupWindowV3.setAdapter(this.micoRecyclerAdapter);
            immersionPopupWindowV3.show(getActivity(), this.micoRecyclerAdapter.getItemCount() * DisplayUtils.dip2px(getContext(), 43.0f) < (DisplayUtils.getScreenHeightPixels(getActivity()) / 3) * 2 ? -2 : (DisplayUtils.getScreenHeightPixels(getActivity()) / 3) * 2, -1);
            statPopDevice();
        }
    }

    private void statPopDevice() {
        List<Object> allData;
        HashSet hashSet = new HashSet();
        MicoRecyclerAdapter micoRecyclerAdapter2 = this.micoRecyclerAdapter;
        if (!(micoRecyclerAdapter2 == null || (allData = micoRecyclerAdapter2.getAllData()) == null)) {
            for (Object next : allData) {
                if (next instanceof Admin.Mico) {
                    hashSet.add(((Admin.Mico) next).miotDID);
                }
            }
        }
        Iterator it = hashSet.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + ((String) it.next()) + ";";
        }
        hxi.O00000o0.f957O000000o.O000000o("content_device_select", "model", str, "number", Integer.valueOf(hashSet.size()));
    }

    public void switchMusicPage(String str) {
        int findTabIndex = findTabIndex(str);
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(findTabIndex);
            refreshTabState(findTabIndex);
        }
    }

    public boolean canFindExTabIndex(String str) {
        if (this.tabPages == null) {
            return false;
        }
        for (int i = 0; i < this.tabPages.size(); i++) {
            if (TextUtils.equals(str, this.tabPages.get(i).type)) {
                return true;
            }
        }
        return false;
    }

    private int findTabIndex(String str) {
        for (int i = 0; i < this.tabPages.size(); i++) {
            if (TextUtils.equals(str, this.tabPages.get(i).type)) {
                return i;
            }
        }
        return this.currentItem;
    }

    public void reloadMicoList() {
        MicoManager.getInstance().getMicoList(new IncompleteApiListener() {
            /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass12 */

            public void onSuccess() {
                MicoMainFragment.this.updateMicoStatus();
                MijiaCacheManager.loadHomeData(null, MicoMainFragment.this.getActivity(), MijiaEvent.Reason.MAIN_ACTIVITY);
            }

            public void onFailure(ApiError apiError) {
                gsy.O00000Oo("Mico-Api", "reloadMicoList-->" + apiError.toString());
            }
        }, false);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 11101) {
            dka.O000000o(i, i2, intent, new QQAuthUiListener());
        }
        if (i2 == -1 && i == 1102) {
            KKBoxAuthEvent completeEvent = KKBoxAuthEvent.completeEvent(intent.getData());
            if (completeEvent.success) {
                acquireMembership();
            }
            jgc.O000000o().O00000o(completeEvent);
        }
    }

    public static void checkKkBoxMembership() {
        if (!hasCheckKkBoxMembership) {
            acquireMembership();
        }
    }

    public static String getCurrentPageType() {
        return sCurrentPageType;
    }

    private static void acquireMembership() {
        String currentMicoID = MicoManager.getInstance().getCurrentMicoID();
        String currentMicoSN = MicoManager.getInstance().getCurrentMicoSN();
        if (!TextUtils.isEmpty(currentMicoID)) {
            ApiHelper.kkboxSalesPromotion(currentMicoID, currentMicoSN, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.MicoMainFragment.AnonymousClass13 */

                public final void onFailure(ApiError apiError) {
                }

                public final void onSuccess(String str) {
                    MicoMainFragment.hasCheckKkBoxMembership = true;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        try {
                            String optString = new JSONObject(str).optString("url");
                            if (!TextUtils.isEmpty(optString)) {
                                SchemaManager.handleSchema(MicoApplication.getInstance().getGlobalContext(), SkillSchemaHandler.buildWebSchema("", optString, false));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void checkOffline() {
        Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
        if (currentMico.isValid() && !currentMico.isOnline() && System.currentTimeMillis() - this.showOfflineTime > 1000) {
            this.showOfflineTime = System.currentTimeMillis();
        }
    }

    private void setViewStatus(View view, boolean z) {
        if (z) {
            view.setEnabled(true);
            view.setAlpha(1.0f);
            return;
        }
        view.setEnabled(false);
        view.setAlpha(0.3f);
    }

    public void setExternalTabType(String str) {
        this.mExternalTabType = str;
        if (!TextUtils.isEmpty(this.mExternalTabType) && canFindExTabIndex(this.mExternalTabType)) {
            switchMusicPage(this.mExternalTabType);
            this.mExternalTabType = "";
        }
    }
}
