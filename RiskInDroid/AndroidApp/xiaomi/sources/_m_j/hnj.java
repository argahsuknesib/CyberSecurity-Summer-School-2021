package _m_j;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.ChangeHomePopupWindow;
import com.xiaomi.smarthome.scene.MySceneFragmentNew;
import com.xiaomi.smarthome.scene.SceneTabSwitcher;
import com.xiaomi.smarthome.scene.activity.SceneLogActivity;
import com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.ui.rec.RecommendSceneTab;
import com.xiaomi.smarthome.scene.view.SceneTabViewPagerWithSwipeEnable;
import com.xiaomi.smarthome.scene.widget.SceneTabIndicator;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.ArrayList;
import java.util.List;

public class hnj extends hoo {
    View O00000Oo;
    public SceneTabViewPagerWithSwipeEnable O00000o;
    O000000o O00000o0;
    public DevicePtrFrameLayout O00000oO;
    public fvm O00000oo;
    public List<Integer> O0000O0o;
    TabLayout O0000OOo;
    public SceneTabIndicator O0000Oo;
    public TextView O0000Oo0;
    int O0000OoO = -1;
    public hke O0000Ooo;
    private ImageView O0000o;
    public MySceneFragmentNew O0000o0;
    public RecommendSceneTab O0000o00;
    IntentFilter O0000o0O = new IntentFilter("action_on_login_success");
    private ConstraintLayout O0000o0o;
    private View O0000oO;
    private ImageView O0000oO0;
    private boolean O0000oOO = false;
    private ImageView O0000oOo;
    private BroadcastReceiver O0000oo0 = new BroadcastReceiver() {
        /* class _m_j.hnj.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("action_on_logout".equals(action) || "action_on_login_success".equals(action) || "action_on_login_success".equals(action)) {
                hnj.this.O00000o0();
                hnj hnj = hnj.this;
                if (hnj.O0000o0 != null) {
                    hnj.O0000o0.O0000O0o();
                }
                if (hnj.O0000o00 != null) {
                    RecommendSceneTab recommendSceneTab = hnj.O0000o00;
                    if (!ftn.O00000oO(recommendSceneTab.mContext)) {
                        PtrFrameLayout ptrFrameLayout = recommendSceneTab.O00000oO;
                        if (ptrFrameLayout != null) {
                            ptrFrameLayout.setVisibility(0);
                        }
                        if (!RecommendSceneTab.O00000o0()) {
                            recommendSceneTab.O00000oo();
                        }
                    }
                }
                if (hnj.O0000Ooo != null) {
                    hnj.O0000Ooo.loginStateUpdate();
                }
            } else if ("home_room_updated".equals(action) || "force_update_data_completed".equals(action) || "home_room_home_changed".equals(action)) {
                hnj.this.O00000o();
            }
        }
    };

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogType logType = LogType.SCENE;
        StringBuilder sb = new StringBuilder("SceneTabFragment  onCreateViewmRootView == null ");
        sb.append(this.O00000Oo == null);
        gsy.O000000o(logType, "scene", sb.toString());
        if (this.O00000Oo == null) {
            this.O0000oOO = false;
            this.O00000Oo = layoutInflater.inflate((int) R.layout.fragment_scene_tab_layout, (ViewGroup) null);
            this.O0000o0o = (ConstraintLayout) this.O00000Oo.findViewById(R.id.title_bar_content);
            this.O0000OOo = (TabLayout) this.O00000Oo.findViewById(R.id.tab_layout);
            this.O00000oO = (DevicePtrFrameLayout) this.O00000Oo.findViewById(R.id.pull_down_refresh);
            this.O00000o = (SceneTabViewPagerWithSwipeEnable) this.O00000Oo.findViewById(R.id.view_pager);
            this.O0000oO = this.O00000Oo.findViewById(R.id.loading_view);
            this.O0000o = (ImageView) this.O00000Oo.findViewById(R.id.add_btn);
            this.O0000oO0 = (ImageView) this.O00000Oo.findViewById(R.id.iv_log);
            this.O0000Oo0 = (TextView) this.O00000Oo.findViewById(R.id.tv_home_filter);
            this.O00000Oo.findViewById(R.id.home_name_tv_click_delegate).setOnClickListener(new View.OnClickListener() {
                /* class _m_j.$$Lambda$hnj$VUUPhZHUB8AY2kr98O0UGYBRts */

                public final void onClick(View view) {
                    hnj.this.O000000o(view);
                }
            });
            this.O0000oOo = (ImageView) this.O00000Oo.findViewById(R.id.iv_arrow_down_img);
            this.O0000Oo = (SceneTabIndicator) this.O00000Oo.findViewById(R.id.top_indicator);
            if (gwg.O000000o((Activity) getActivity()) && this.O0000o0o != null) {
                int O000000o2 = hzf.O000000o(CommonApplication.getAppContext());
                if (this.O0000o0o.getLayoutParams().height > 0) {
                    this.O0000o0o.getLayoutParams().height += O000000o2;
                }
                this.O0000o0o.setPadding(0, O000000o2, 0, 0);
                ConstraintLayout constraintLayout = this.O0000o0o;
                constraintLayout.setLayoutParams(constraintLayout.getLayoutParams());
            }
        }
        return this.O00000Oo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        this.O0000Oo0.performClick();
    }

    public void onViewCreated(View view, Bundle bundle) {
        gsy.O000000o(LogType.SCENE, "scene", "SceneTabFragment  onViewCreated");
        super.onViewCreated(view, bundle);
        CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class _m_j.$$Lambda$hnj$T2GeMcyc_Io0XcTG3eEdgY2TlM */

            public final void run() {
                hnj.this.O00000oo();
            }
        }, 10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo() {
        int i;
        if (!this.O0000oOO) {
            SceneTabSwitcher.INSTANCE.init(this);
            this.O0000O0o = SceneTabSwitcher.INSTANCE.getPageItems();
            if (this.O0000O0o.size() == 1) {
                this.O00000Oo.findViewById(R.id.tab_bar).setVisibility(8);
                this.O00000Oo.findViewById(R.id.top_indicator).setVisibility(8);
            }
            gsy.O000000o(LogType.SCENE, "scene", "SceneTabFragment  initViewPager");
            if (getActivity() != null && !getActivity().isFinishing()) {
                this.O00000o0 = new O000000o(getActivity().getSupportFragmentManager());
                this.O00000o.setAdapter(this.O00000o0);
                this.O0000Oo.f11333O000000o = this.O00000o;
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.O0000O0o.size(); i2++) {
                    arrayList.add(getString(this.O0000O0o.get(i2).intValue()));
                }
                this.O0000Oo.O000000o(arrayList);
                this.O00000o.addOnPageChangeListener(new ViewPager.O0000O0o() {
                    /* class _m_j.hnj.AnonymousClass3 */

                    public final void onPageScrolled(int i, float f, int i2) {
                        hnj.this.O0000Oo.O000000o(i, f, i2);
                    }

                    public final void onPageSelected(int i) {
                        hnj.this.O0000Oo.O000000o(i);
                        gpv.O000000o(CommonApplication.getAppContext(), hnj.O00000Oo(), i);
                        fvm fvm = hnj.this.O00000oo;
                        fvm fvm2 = (fvm) hnj.this.O00000o0.getItem(i);
                        if (!(fvm == null || fvm == fvm2)) {
                            fvm.onPageDeselected();
                        }
                        hnj hnj = hnj.this;
                        hnj.O00000oo = fvm2;
                        if (hnj.O00000oO != null && hnj.this.O00000oO.isRefreshing()) {
                            hnj.this.O00000oO.refreshComplete();
                        }
                        if (hnj.this.O00000oo != null) {
                            hnj.this.O00000oo.onPageSelected();
                        }
                    }

                    public final void onPageScrollStateChanged(int i) {
                        hnj.this.O0000Oo.O00000Oo(i);
                    }
                });
                O00000oO();
                MySceneFragmentNew mySceneFragmentNew = this.O0000o0;
                if (mySceneFragmentNew != null && this.O00000oo == mySceneFragmentNew) {
                    mySceneFragmentNew.O0000OOo();
                }
                this.O0000oO.setVisibility(8);
                if (this.O0000OoO >= 0 && this.O00000o.getChildCount() > (i = this.O0000OoO)) {
                    this.O0000Oo.setCurrentItem(i);
                    this.O00000o0.notifyDataSetChanged();
                    this.O00000o.setCurrentItem(this.O0000OoO);
                }
            }
            ImageView imageView = this.O0000o;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.hnj.AnonymousClass4 */

                    public final void onClick(View view) {
                        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                            hnw.O000000o(hnj.this.getActivity());
                            return;
                        }
                        hxk hxk = hxi.O00000o;
                        String O0000OOo = ggb.O00000Oo().O0000OOo();
                        hxk.f952O000000o.O000000o("scene_plus_click", "homeid", O0000OOo);
                        hpq.O000000o().O000000o((SceneApi.O000OOOo) null);
                        hnj.this.startActivity(new Intent(hnj.this.getActivity(), SmarthomeCreateAutoSceneActivity.class));
                    }
                });
            }
            this.O0000oO0.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.hnj.AnonymousClass5 */

                public final void onClick(View view) {
                    if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                        hnw.O000000o(hnj.this.getActivity());
                        return;
                    }
                    hxk hxk = hxi.O00000o;
                    String O0000OOo = ggb.O00000Oo().O0000OOo();
                    hxk.f952O000000o.O000000o("scene_log_click", "homeid", O0000OOo);
                    hnj.this.startActivity(new Intent(hnj.this.getActivity(), SceneLogActivity.class));
                }
            });
            this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.hnj.AnonymousClass6 */

                public final void onClick(View view) {
                    hxk hxk = hxi.O00000o;
                    String O0000OOo = ggb.O00000Oo().O0000OOo();
                    hxk.f952O000000o.O000000o("scene_changehome_click", "homeid", O0000OOo);
                    new ChangeHomePopupWindow(hnj.this.getActivity(), hnj.this.O0000Oo0).e_();
                }
            });
            O00000o();
            hpu.O000000o().O0000OoO = this;
            gsy.O000000o(LogType.SCENE, "scene", "SceneTabFragment  initView");
            if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                if (CoreApi.O000000o().O0000O0o()) {
                    hod.O0000OoO().O00000o();
                    hod.O0000OoO().O00000o0();
                    hpr.O00000o0().O00000Oo();
                } else {
                    CoreApi.O000000o().O000000o(getActivity(), new CoreApi.O0000o0() {
                        /* class _m_j.hnj.AnonymousClass7 */

                        public final void onCoreReady() {
                            hod.O0000OoO().O00000o();
                            hod.O0000OoO().O00000o0();
                            hpr.O00000o0().O00000Oo();
                        }
                    });
                }
            }
            this.O0000oOO = true;
        }
    }

    public void onSwitchtoPage(int i, boolean z) {
        O000000o(z);
        gsy.O000000o(LogType.SCENE, "scene", "SceneTabFragment  onSwitchtoPage switchIn=".concat(String.valueOf(z)));
        hxk hxk = hxi.O00000o;
        String O0000OOo2 = ggb.O00000Oo().O0000OOo();
        hxk.f952O000000o.O000000o("scene_tab_click", "homeid", O0000OOo2);
        if (z && this.O0000oOO && isValid()) {
            CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class _m_j.hnj.AnonymousClass2 */

                public final void run() {
                    if (hnj.this.O0000o0 != null && hnj.this.O00000oo == hnj.this.O0000o0) {
                        hnj.this.O0000o0.O0000OOo();
                    }
                    if (hnj.this.O0000o00 != null && hnj.this.O00000oo == hnj.this.O0000o00) {
                        hnj.this.O0000o00.O0000O0o();
                    }
                }
            }, 200);
        }
        if (z) {
            O00000oO();
        }
        for (int i2 = 0; i2 < this.O00000o0.getCount(); i2++) {
            Fragment item = this.O00000o0.getItem(i2);
            if (item != null) {
                item.setUserVisibleHint(z);
            }
        }
    }

    private void O00000oO() {
        O000000o o000000o;
        int i;
        this.O0000OoO = gpv.O000000o(CommonApplication.getAppContext(), O00000Oo());
        if (this.O0000OoO >= 0 && (o000000o = this.O00000o0) != null && o000000o.getCount() > (i = this.O0000OoO)) {
            this.O0000Oo.setCurrentItem(i);
            this.O00000o0.notifyDataSetChanged();
            this.O00000o.setCurrentItem(this.O0000OoO);
        }
    }

    public final boolean O000000o() {
        O000000o o000000o;
        if (this.O00000o != null && (o000000o = this.O00000o0) != null && o000000o.O00000o0 >= 0 && this.O00000o0.O00000o0 < this.O00000o0.getCount()) {
            try {
                this.O00000o.setCurrentItem(this.O00000o0.O00000o0);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String O00000Oo() {
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            return CoreApi.O000000o().O0000o0() + "_last_select_indexinter";
        }
        return CoreApi.O000000o().O0000o0() + "_last_select_index";
    }

    public boolean onBackPressed() {
        fvm fvm = this.O00000oo;
        if (fvm instanceof MySceneFragmentNew) {
            return fvm.onBackPressed();
        }
        getActivity().finish();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 999) {
            MySceneFragmentNew mySceneFragmentNew = this.O0000o0;
            if (mySceneFragmentNew != null) {
                mySceneFragmentNew.onActivityResult(i, i2, intent);
            }
        } else if (i == 998) {
            RecommendSceneTab recommendSceneTab = this.O0000o00;
            if (recommendSceneTab != null) {
                recommendSceneTab.onActivityResult(i, i2, intent);
            }
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        gsy.O000000o(LogType.SCENE, "scene", "SceneTabFragment  onCreate");
        super.onCreate(bundle);
        this.O0000o0O.addAction("action_on_logout");
        this.O0000o0O.addAction("action_on_login_success");
        this.O0000o0O.addAction("home_room_updated");
        this.O0000o0O.addAction("force_update_data_completed");
        this.O0000o0O.addAction("home_room_home_changed");
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O0000oo0, this.O0000o0O);
    }

    public void onResume() {
        super.onResume();
        hxp hxp = hxi.O00000o0;
        String O0000OOo2 = ggb.O00000Oo().O0000OOo();
        hxp.f957O000000o.O000000o("scene_tab_show", "homeid", O0000OOo2);
        O00000o0();
    }

    public void onDestroy() {
        super.onDestroy();
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O0000oo0);
        gsy.O000000o(LogType.SCENE, "scene", "SceneTabFragment  onDestroy");
    }

    public final void O00000o0() {
        if (isValid()) {
            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                hni.O000000o().O00000Oo();
                this.O0000Oo0.setText("");
                this.O0000oOo.setVisibility(8);
                return;
            }
            O00000o();
        }
    }

    public final void O00000o() {
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        if (O0000Oo02 != null) {
            TextView textView = this.O0000Oo0;
            ggb.O00000Oo();
            textView.setText(ggb.O000000o(O0000Oo02));
            this.O0000oOo.setVisibility(0);
        }
    }

    class O000000o extends eh {

        /* renamed from: O000000o  reason: collision with root package name */
        List<fvm> f19093O000000o = new ArrayList();
        int O00000Oo;
        int O00000o0;

        public O000000o(ee eeVar) {
            super(eeVar);
            if (fbv.O000000o().O00000oO) {
                hnj.this.O0000Ooo = hnf.O000000o(hka.O000000o() + "/miot/activity/operation-smart/index.html?native_page=smart", "");
                this.f19093O000000o.add(hnj.this.O0000Ooo);
            }
            if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && !hnw.O000000o()) {
                hnj.this.O0000o00 = new RecommendSceneTab();
                hnj.this.O0000o00.setArguments(hnj.this.getArguments());
                this.f19093O000000o.add(hnj.this.O0000o00);
                this.O00000Oo = this.f19093O000000o.size() - 1;
            }
            hnj.this.O0000o0 = new MySceneFragmentNew();
            hnj.this.O0000o0.setArguments(hnj.this.getArguments());
            hnj.this.O0000o0.O0000OoO = hnj.this;
            this.f19093O000000o.add(hnj.this.O0000o0);
            this.O00000o0 = this.f19093O000000o.size() - 1;
            hnj.this.O00000oo = this.f19093O000000o.get(0);
            hnj.this.O00000oo.onPageSelected();
        }

        public final Fragment getItem(int i) {
            return this.f19093O000000o.get(i);
        }

        public final CharSequence getPageTitle(int i) {
            hnj hnj = hnj.this;
            return hnj.getString(hnj.O0000O0o.get(i).intValue());
        }

        public final int getCount() {
            return hnj.this.O0000O0o.size();
        }
    }
}
