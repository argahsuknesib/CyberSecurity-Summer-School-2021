package com.xiaomi.smarthome.scene;

import _m_j.axs;
import _m_j.axx;
import _m_j.axy;
import _m_j.aya;
import _m_j.eys;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.fvm;
import _m_j.gfr;
import _m_j.ggb;
import _m_j.gnn;
import _m_j.gno;
import _m_j.gof;
import _m_j.goz;
import _m_j.gpc;
import _m_j.gqb;
import _m_j.gqd;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.hah;
import _m_j.hni;
import _m_j.hnj;
import _m_j.hnv;
import _m_j.hnw;
import _m_j.hny;
import _m_j.hob;
import _m_j.hod;
import _m_j.hop;
import _m_j.hpn;
import _m_j.hpp;
import _m_j.hpq;
import _m_j.hpr;
import _m_j.hpu;
import _m_j.hrg;
import _m_j.hrl;
import _m_j.hrv;
import _m_j.hxi;
import _m_j.hxp;
import _m_j.hzf;
import _m_j.izb;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.AnimateLinearLayout;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity;
import com.xiaomi.smarthome.scene.MySceneFragmentNew;
import com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity;
import com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity;
import com.xiaomi.smarthome.scene.activity.SmarthomeSortLiteSceneActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MySceneFragmentNew extends fvm implements TabLayout.OnTabSelectedListener, RecyclerViewExpandableItemManager.O000000o, RecyclerViewExpandableItemManager.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    View f10553O000000o;
    ViewGroup O00000Oo;
    List<Pair<O0000O0o, List<SceneApi.O000OOOo>>> O00000o = new ArrayList();
    PtrFrameLayout O00000o0;
    List<SceneApi.O000OOOo> O00000oO = new ArrayList();
    List<SceneApi.O000OOOo> O00000oo = new ArrayList();
    RecyclerView.O000000o<Object> O0000O0o;
    public boolean O0000OOo = false;
    public boolean O0000Oo = false;
    public boolean O0000Oo0 = false;
    public hnj O0000OoO;
    O0000Oo0 O0000Ooo;
    public hny O0000o = new hny() {
        /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass20 */

        public final void onRefreshScenceSuccess(int i) {
            if (MySceneFragmentNew.this.isValid()) {
                gsy.O00000Oo("MySceneFragmentNew", "onRefreshScenceSuccess LiteSceneManager" + i + "LiteSceneManager.getInstance().isUpdateSuccess()" + hpr.O00000o0().O00000o);
                if (i == 4) {
                    MySceneFragmentNew.this.O0000o0O.O00000o0();
                } else if (i == 5) {
                    MySceneFragmentNew mySceneFragmentNew = MySceneFragmentNew.this;
                    mySceneFragmentNew.O0000OOo = true;
                    mySceneFragmentNew.O0000o0O.O00000o0();
                }
                if (MySceneFragmentNew.this.O0000OOo && MySceneFragmentNew.this.O0000Oo0 && MySceneFragmentNew.this.O0000Oo) {
                    MySceneFragmentNew.this.O00000o();
                    MySceneFragmentNew.this.O000000o();
                }
            }
        }

        public final void onRefreshScenceFailed(int i) {
            if (MySceneFragmentNew.this.isValid()) {
                MySceneFragmentNew.this.O000000o();
                MySceneFragmentNew.this.O0000Ooo.notifyDataSetChanged();
                if (i != 4) {
                    gqg.O00000Oo((int) R.string.smarthome_scene_update_failed);
                    if (gfr.f17662O000000o) {
                        gqg.O00000Oo("——Lite failed with type ".concat(String.valueOf(i)));
                    }
                    if (gfr.O0000Ooo) {
                        gsy.O00000o0(LogType.GENERAL, "", "——Lite failed with type ".concat(String.valueOf(i)));
                    }
                }
                MySceneFragmentNew.this.O00000o();
            }
        }
    };
    public String O0000o0 = null;
    RecyclerViewExpandableItemManager O0000o00;
    public hrv O0000o0O;
    LinearLayoutManager O0000o0o = null;
    LayoutInflater O0000oO;
    public hny O0000oO0 = new hny() {
        /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass2 */

        public final void onRefreshScenceSuccess(int i) {
            if (MySceneFragmentNew.this.isValid()) {
                MySceneFragmentNew.this.getActivity().runOnUiThread(new Runnable(i) {
                    /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$2$1F48p1dhpYLGkaxaJSSMiZzUnm8 */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        MySceneFragmentNew.AnonymousClass2.this.O00000Oo(this.f$1);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(int i) {
            if (MySceneFragmentNew.this.isValid()) {
                gsy.O00000Oo("MySceneFragmentNew", "onRefreshScenceSuccess SceneManager".concat(String.valueOf(i)));
                if (i == 4) {
                    MySceneFragmentNew.this.O000000o(i);
                    MySceneFragmentNew.this.O0000o0O.O00000o0();
                } else if (i == 5) {
                    MySceneFragmentNew mySceneFragmentNew = MySceneFragmentNew.this;
                    mySceneFragmentNew.O0000Oo0 = true;
                    mySceneFragmentNew.O0000o0O.O00000o0();
                } else if (i == 12) {
                    MySceneFragmentNew mySceneFragmentNew2 = MySceneFragmentNew.this;
                    mySceneFragmentNew2.O0000Oo = true;
                    mySceneFragmentNew2.O0000o0O.O00000o0();
                }
                if (MySceneFragmentNew.this.O0000OOo && MySceneFragmentNew.this.O0000Oo0 && MySceneFragmentNew.this.O0000Oo) {
                    MySceneFragmentNew.this.O000000o();
                    MySceneFragmentNew.this.O00000o();
                }
            }
        }

        public final void onRefreshScenceFailed(int i) {
            if (MySceneFragmentNew.this.isValid()) {
                MySceneFragmentNew.this.getActivity().runOnUiThread(new Runnable(i) {
                    /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$2$jJ1eXUmzM6dVngRW8Zr8J8zIORQ */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        MySceneFragmentNew.AnonymousClass2.this.O000000o(this.f$1);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i) {
            if (MySceneFragmentNew.this.isValid()) {
                MySceneFragmentNew.this.O000000o();
                MySceneFragmentNew.this.O0000Ooo.notifyDataSetChanged();
                if (i != 4 && i != 6) {
                    gqg.O00000Oo((int) R.string.smarthome_scene_update_failed);
                    if (gfr.f17662O000000o) {
                        gqg.O00000Oo("——Auto failed with type ".concat(String.valueOf(i)));
                    }
                    if (gfr.O0000Ooo) {
                        gsy.O00000o0(LogType.GENERAL, "", "——Auto failed with type ".concat(String.valueOf(i)));
                    }
                } else if (i == 6) {
                    if (gfr.f17662O000000o) {
                        gqg.O00000Oo("——Load tpl failed");
                    }
                    if (gfr.O0000Ooo) {
                        gsy.O00000o0(LogType.GENERAL, "", "——Load tpl failed ");
                    }
                }
                MySceneFragmentNew.this.O00000o();
            }
        }
    };
    public boolean O0000oOO = false;
    public ImageView O0000oOo;
    public Button O0000oo;
    public ImageView O0000oo0;
    public Button O0000ooO;
    public Button O0000ooo;
    public HashMap<String, Integer> O000O00o = new HashMap<>();
    public boolean O000O0OO = false;
    List<SceneApi.O000OOOo> O000O0Oo = new ArrayList();
    private boolean O000O0o = true;
    private boolean O000O0o0 = true;
    private axx O000O0oO;
    private boolean O000O0oo;
    private Room O000OO;
    private BroadcastReceiver O000OO00 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "home_room_updated") && TextUtils.equals("home_room_sync", intent.getStringExtra("operation")) && intent.getIntExtra("result_code", -1) == ErrorCode.SUCCESS.getCode() && MySceneFragmentNew.this.O0000o0O != null) {
                MySceneFragmentNew.this.O0000o0O.O000000o();
                MySceneFragmentNew.this.O00000Oo();
            }
        }
    };
    private BroadcastReceiver O000OO0o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass12 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "home_room_home_changed") && MySceneFragmentNew.this.O0000o0O != null) {
                if (ggb.O00000Oo().O0000Oo0().isOwner()) {
                    MySceneFragmentNew.this.O0000o0O.O00000Oo(ggb.O00000Oo().O0000Oo0());
                    MySceneFragmentNew.this.O0000o0O.O000000o();
                    MySceneFragmentNew.this.O0000o0O.O000000o(ggb.O00000Oo().O0000Oo0());
                    return;
                }
                MySceneFragmentNew.this.O00000o();
            }
        }
    };
    private O0000O0o O000OOOo;
    private O0000O0o O000OOo;
    private O0000O0o O000OOo0;
    private O0000O0o O000OOoO;
    private O0000O0o O000OOoo;
    private hni.O000000o O000Oo00 = new hni.O000000o() {
        /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass19 */

        public final void O000000o(List<SceneApi.O000OOOo> list) {
            gsy.O00000Oo(LogType.SCENE, "MySceneFragmentNew", "scene status changed");
            if (MySceneFragmentNew.this.O00000o0 != null && !MySceneFragmentNew.this.O00000o0.isRefreshing()) {
                List list2 = null;
                if (MySceneFragmentNew.this.O00000o != null) {
                    int i = 0;
                    while (true) {
                        if (i >= MySceneFragmentNew.this.O00000o.size()) {
                            break;
                        } else if (((O0000O0o) MySceneFragmentNew.this.O00000o.get(i).first).O00000Oo == 15) {
                            list2 = (List) MySceneFragmentNew.this.O00000o.get(i).second;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (list2 != null && list2.size() != 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            if (TextUtils.equals(((SceneApi.O000OOOo) list2.get(i3)).f11131O000000o, list.get(i2).f11131O000000o)) {
                                LogType logType = LogType.SCENE;
                                gsy.O00000Oo(logType, "MySceneFragmentNew", ((SceneApi.O000OOOo) list2.get(i3)).f11131O000000o + " status changed to " + list.get(i2).O0000Oo0);
                                ((SceneApi.O000OOOo) list2.get(i3)).O0000Oo0 = list.get(i2).O0000Oo0;
                                hod.O0000OoO().O000000o(((SceneApi.O000OOOo) list2.get(i3)).f11131O000000o, (SceneApi.O000OOOo) list2.get(i3));
                            }
                        }
                    }
                    MySceneFragmentNew.this.O0000Ooo.notifyDataSetChanged();
                }
            }
        }
    };
    private int O00oOoOo = 0;
    public Button O00oOooO;
    public TextView O00oOooo;
    @BindView(5270)
    TextView mEmptyTV;
    @BindView(5272)
    View mEmptyView;
    @BindView(5991)
    View mPlaceHolderView;
    @BindView(6155)
    RecyclerView mSceneViewRV;
    @BindView(6574)
    View mShareHomeView;

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabSelected(TabLayout.Tab tab) {
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }

    public static class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f10579O000000o;
        public int O00000Oo;

        public O0000O0o(String str, int i) {
            this.f10579O000000o = str;
            this.O00000Oo = i;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        gsy.O000000o(LogType.SCENE, "MySceneFragment", "  onCreateView");
        if (this.f10553O000000o == null) {
            this.f10553O000000o = layoutInflater.inflate((int) R.layout.fragment_my_scene_layout_new, (ViewGroup) null);
            ButterKnife.bind(this, this.f10553O000000o);
            this.O0000oO = LayoutInflater.from(getActivity());
            this.mContext = getActivity();
            this.O00000Oo = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            this.O00000o0 = (PtrFrameLayout) this.O00000Oo.findViewById(R.id.pull_down_refresh);
            this.O000OOOo = new O0000O0o(getResources().getString(R.string.smarthome_scene_all_id), 20);
            this.O000OOo0 = new O0000O0o(getResources().getString(R.string.smarthome_scene_empty_id), 22);
            this.O000OOo = new O0000O0o(getResources().getString(R.string.smarthome_new_scene_by_voice), 50);
            this.O000OOoO = new O0000O0o(getResources().getString(R.string.smarthome_new_scene_by_hand), 30);
            this.O000OOoo = new O0000O0o(getResources().getString(R.string.smarthome_new_scene_auto), 15);
            this.O0000o0O = new hrv(getActivity(), (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()) {
                /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass14 */

                public final void O000000o(Home home) {
                    MySceneFragmentNew.this.O000000o(0, home, (Object) null);
                }

                public final void O000000o(Home home, Room room) {
                    if (MySceneFragmentNew.this.O00000o != null && MySceneFragmentNew.this.O00000o.size() > 0 && ((O0000O0o) MySceneFragmentNew.this.O00000o.get(0).first).O00000Oo == 20) {
                        if (room == null || TextUtils.isEmpty(room.getName())) {
                            ((O0000O0o) MySceneFragmentNew.this.O00000o.get(0).first).f10579O000000o = MySceneFragmentNew.this.getString(R.string.tag_all);
                        } else {
                            ((O0000O0o) MySceneFragmentNew.this.O00000o.get(0).first).f10579O000000o = room.getName();
                        }
                    }
                    MySceneFragmentNew.this.O000000o(1, home, room);
                    if (MySceneFragmentNew.this.O0000Ooo != null) {
                        MySceneFragmentNew.this.O0000Ooo.notifyDataSetChanged();
                    }
                }

                public final void O000000o(Home home, DeviceTagInterface.Category category) {
                    if (MySceneFragmentNew.this.O00000o == null || MySceneFragmentNew.this.O00000o.size() <= 0 || ((O0000O0o) MySceneFragmentNew.this.O00000o.get(0).first).O00000Oo != 20) {
                        ((O0000O0o) MySceneFragmentNew.this.O00000o.get(0).first).f10579O000000o = MySceneFragmentNew.this.getString(R.string.tag_all);
                    } else if (category == null || TextUtils.isEmpty(category.name)) {
                        ((O0000O0o) MySceneFragmentNew.this.O00000o.get(0).first).f10579O000000o = MySceneFragmentNew.this.getString(R.string.tag_all);
                    } else {
                        ((O0000O0o) MySceneFragmentNew.this.O00000o.get(0).first).f10579O000000o = category.name;
                    }
                    if (MySceneFragmentNew.this.O0000Ooo != null) {
                        MySceneFragmentNew.this.O0000Ooo.notifyDataSetChanged();
                    }
                    MySceneFragmentNew.this.O000000o(2, home, category);
                }
            };
            this.mEmptyTV.setText((int) R.string.my_scene_no_data);
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.f10553O000000o.findViewById(R.id.title_bar_choose_device));
            hrl O000000o2 = hrl.O000000o();
            O000000o2.O00000Oo = new hrl.O00000o();
            this.O000O0Oo.addAll(hod.O0000OoO().f416O000000o);
            this.O0000o0o = new LinearLayoutManager(this.mContext);
            this.O000O0oO = new axx();
            axx axx = this.O000O0oO;
            axx.O0000OOo = true;
            axx.O00000Oo();
            this.O0000o00 = new RecyclerViewExpandableItemManager();
            this.O0000o00.O000000o((RecyclerViewExpandableItemManager.O000000o) this);
            this.O0000o00.O000000o((RecyclerViewExpandableItemManager.O00000Oo) this);
            this.O0000Ooo = new O0000Oo0();
            this.O0000O0o = this.O0000o00.O000000o(this.O0000Ooo);
            this.mSceneViewRV.setLayoutManager(this.O0000o0o);
            this.mSceneViewRV.setAdapter(this.O0000O0o);
            this.mSceneViewRV.setOnScrollListener(new RecyclerView.O00oOooO() {
                /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass16 */

                public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    FragmentActivity validActivity;
                    View currentFocus;
                    super.onScrollStateChanged(recyclerView, i);
                    if (i != 0 && (validActivity = MySceneFragmentNew.this.getValidActivity()) != null && MySceneFragmentNew.this.isValid() && (currentFocus = validActivity.getCurrentFocus()) != null) {
                        currentFocus.clearFocus();
                    }
                }
            });
            this.O000O0oO.O000000o(this.mSceneViewRV);
            this.O0000o00.O000000o(this.mSceneViewRV);
            this.O0000o00.O000000o();
            O0000Oo0();
            if (this.O000O0o && this.O00000o0 != null) {
                O00000Oo();
                this.O000O0o = false;
            }
        }
        return this.f10553O000000o;
    }

    public void onViewCreated(View view, Bundle bundle) {
        gsy.O000000o(LogType.SCENE, "MySceneFragment", "  onViewCreated");
        super.onViewCreated(view, bundle);
    }

    public void onPageSelected() {
        PtrFrameLayout ptrFrameLayout;
        super.onPageSelected();
        this.O000O0oo = true;
        hxi.O00000o.f952O000000o.O000000o("scene_customize_click", "homeid", ggb.O00000Oo().O0000OOo());
        gsy.O00000Oo("MySceneFragmentNew", "onPageSelected");
        O0000Oo0();
        PtrFrameLayout ptrFrameLayout2 = this.O00000o0;
        if (ptrFrameLayout2 != null) {
            ptrFrameLayout2.setEnabled(true);
            this.O00000o0.requestDisallowInterceptTouchEvent(false);
        }
        if (this.O000O0o && (ptrFrameLayout = this.O00000o0) != null) {
            ptrFrameLayout.autoRefresh();
            this.O000O0o = false;
        }
        if (this.O0000Ooo != null && (!TextUtils.isEmpty(hpu.O000000o().O00000o) || !TextUtils.isEmpty(this.O0000o0))) {
            this.O0000Ooo.notifyDataSetChanged();
        }
        O0000OOo();
    }

    public void onPageDeselected() {
        super.onPageDeselected();
        this.O000O0oo = false;
    }

    public final void O000000o() {
        PtrFrameLayout ptrFrameLayout;
        if (this.O000O0oo && (ptrFrameLayout = this.O00000o0) != null) {
            ptrFrameLayout.refreshComplete();
        }
    }

    public final void O000000o(boolean z) {
        ServiceApplication.getGlobalHandler().postDelayed(new Runnable(z) {
            /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$g39dPNXdm_EjkHZja5AHLpWtVg */
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MySceneFragmentNew.this.O00000Oo(this.f$1);
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(boolean z) {
        this.O0000o0O.O00000Oo(ggb.O00000Oo().O0000Oo0());
        this.O0000o0O.O00000o();
        if (z) {
            List<Pair<O0000O0o, List<SceneApi.O000OOOo>>> list = this.O00000o;
            if (list != null && list.size() > 1 && ((O0000O0o) this.O00000o.get(1).first).O00000Oo == 30 && ((List) this.O00000o.get(1).second).size() > 0) {
                this.mSceneViewRV.scrollToPosition(((List) this.O00000o.get(1).second).size());
                return;
            }
            return;
        }
        int itemCount = this.O0000o0o.getItemCount();
        this.mSceneViewRV.scrollToPosition(itemCount - 1);
        ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass15 */

            public final void run() {
                MySceneFragmentNew.this.mSceneViewRV.smoothScrollBy(0, gpc.O000000o(99.0f));
            }
        }, 1000);
        gsy.O00000Oo("MySceneFragmentNew", "  count  ".concat(String.valueOf(itemCount)));
    }

    private void O0000Oo0() {
        if (this.O000O0oo) {
            PtrFrameLayout ptrFrameLayout = this.O00000o0;
            if (ptrFrameLayout != null) {
                ptrFrameLayout.setEnabled(true);
                this.O00000o0.requestDisallowInterceptTouchEvent(false);
                this.O00000o0.setPtrHandler(new PtrDefaultHandler() {
                    /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass17 */

                    public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                        MySceneFragmentNew.this.O00000Oo();
                    }
                });
            }
            View view = this.mEmptyView;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$M0rejdVctFmI908QPTX46St7oQ */

                    public final void onClick(View view) {
                        MySceneFragmentNew.this.O0000O0o(view);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000O0o(View view) {
        if (this.O00000o0 != null) {
            O000000o();
            this.O00000o0.autoRefresh();
        }
    }

    public final void O00000Oo() {
        if (this.O00oOoOo == 1) {
            O000000o();
        } else if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            O000000o();
            O00000o();
        } else if (CoreApi.O000000o().O0000O0o()) {
            hpr.O00000o0().O00000Oo(this.O0000o);
            hod.O0000OoO().O00000Oo(this.O0000oO0);
            O00000o0();
        } else {
            CoreApi.O000000o().O000000o(getContext(), new CoreApi.O0000o0() {
                /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass18 */

                public final void onCoreReady() {
                    hpr.O00000o0().O00000Oo(MySceneFragmentNew.this.O0000o);
                    hod.O0000OoO().O00000Oo(MySceneFragmentNew.this.O0000oO0);
                    MySceneFragmentNew.this.O00000o0();
                }
            });
        }
    }

    public final void O00000o0() {
        this.O0000OOo = false;
        this.O0000Oo0 = false;
        hpr.O00000o0().O00000Oo();
        O0000Oo();
        hod.O0000OoO().O00000o();
        hod.O0000OoO().O00000o0();
    }

    private void O0000Oo() {
        this.O0000Oo = false;
        hod.O0000OoO().O0000O0o();
    }

    public void onResume() {
        super.onResume();
        hxp hxp = hxi.O00000o0;
        String O0000OOo2 = ggb.O00000Oo().O0000OOo();
        hxp.f957O000000o.O000000o("scene_customize_show", "homeid", O0000OOo2);
        gsy.O00000Oo("MySceneFragmentNew", "onresume");
        if (this.O000O0o0) {
            this.O000O0o0 = false;
        }
        if (this.O0000Ooo != null) {
            O0000OOo();
            this.O0000Ooo.notifyDataSetChanged();
        }
        O0000O0o();
    }

    public void onPause() {
        super.onPause();
        gsy.O00000Oo("MySceneFragmentNew", "onPause");
        hpu.O000000o().O00000o = null;
        this.O0000o0 = null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gsy.O00000Oo("MySceneFragmentNew", "onCreate");
        hpr.O00000o0().O00000Oo(this.O0000o);
        hod.O0000OoO().O00000Oo(this.O0000oO0);
        new IntentFilter("action_on_login_success").addAction("action_on_logout");
        hni.O000000o().O000000o(this.O000Oo00);
        hni.O000000o().O00000o0();
        ft.O000000o(getContext()).O000000o(this.O000OO0o, new IntentFilter("home_room_home_changed"));
    }

    public boolean onBackPressed() {
        gsy.O00000Oo("MySceneFragmentNew", "onBackPressed");
        if (this.O00oOoOo == 1) {
            O00000oo();
            return true;
        }
        hrv hrv = this.O0000o0O;
        boolean z = false;
        if (hrv.O0000Oo0 >= 0) {
            if (hrv.O0000Oo0 == 0) {
                z = true;
            }
            hrv.O000000o(z);
            z = true;
        }
        if (!z) {
            getActivity().finish();
        }
        return true;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0019 */
    public void onDestroy() {
        super.onDestroy();
        hpr.O00000o0().O00000o0(this.O0000o);
        ft.O000000o(getContext()).O000000o(this.O000OO00);
        try {
            ft.O000000o(getContext()).O000000o(this.O000OO0o);
        } catch (Exception unused) {
        }
        hod.O0000OoO().O00000o0(this.O0000oO0);
        hni.O000000o().O00000Oo(this.O000Oo00);
        hni.O000000o().O00000Oo();
    }

    public final void O00000o() {
        if (ggb.O00000Oo().O0000Oo0() == null || ggb.O00000Oo().O0000Oo0().isOwner()) {
            this.mShareHomeView.setVisibility(8);
            if (this.O00000o.size() == 0) {
                this.mEmptyView.setVisibility(0);
                this.mSceneViewRV.setVisibility(8);
                return;
            }
            this.mSceneViewRV.setVisibility(0);
            this.mEmptyView.setVisibility(8);
            return;
        }
        O0000Ooo();
        this.mSceneViewRV.setVisibility(8);
        this.mShareHomeView.setVisibility(0);
    }

    private void O0000OoO() {
        List<Pair<O0000O0o, List<SceneApi.O000OOOo>>> list = this.O00000o;
        if (list == null) {
            this.O00000o = new ArrayList();
            this.O00000o.add(0, new Pair(this.O000OOo, null));
        } else if (list.size() <= 0) {
            this.O00000o.add(0, new Pair(this.O000OOo, null));
        } else if (((O0000O0o) this.O00000o.get(0).first).O00000Oo != 20) {
            this.O00000o.add(0, new Pair(this.O000OOo, null));
        }
        this.O0000Ooo.notifyDataSetChanged();
    }

    private void O0000Ooo() {
        List<Pair<O0000O0o, List<SceneApi.O000OOOo>>> list = this.O00000o;
        if (list != null && list.size() > 0 && ((O0000O0o) this.O00000o.get(0).first).O00000Oo == 20) {
            this.O00000o.remove(0);
        }
        this.O0000Ooo.notifyDataSetChanged();
    }

    public final void O000000o(int i) {
        if (i == 4) {
            this.O000O0Oo.clear();
            this.O000O0Oo.addAll(hod.O0000OoO().O0000o00);
        } else {
            this.O000O0Oo.clear();
            this.O000O0Oo.addAll(hod.O0000OoO().f416O000000o);
        }
        LogType logType = LogType.SCENE;
        gsy.O00000Oo(logType, "myscene", "refreshCustomScenes---type---" + i + " mCustomScenes.size() " + this.O000O0Oo.size());
        hrl.O000000o().O0000O0o = this.O000O0Oo;
    }

    class O000000o extends axy implements axs {

        /* renamed from: O000000o  reason: collision with root package name */
        ConstraintLayout f10577O000000o;
        LinearLayout O00000Oo;
        ImageView O00000o;
        SimpleDraweeView O00000o0;
        TextView O00000oO;
        CheckBox O00000oo;
        ImageView O0000O0o;
        SwitchButton O0000OOo;
        TextView O0000Oo;
        View O0000Oo0;
        TextView O0000OoO;
        TextView O0000Ooo;
        TextView O0000o00;
        private int O0000o0O;

        public O000000o(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.f10577O000000o = (ConstraintLayout) view.findViewById(R.id.card_layout);
            this.O00000o = (ImageView) view.findViewById(R.id.icon_condition_more);
            this.O0000O0o = (ImageView) view.findViewById(R.id.right_view);
            this.O0000Oo = (TextView) view.findViewById(R.id.new_tag);
            this.O0000OOo = (SwitchButton) view.findViewById(R.id.open_check);
            this.O00000o0 = (SimpleDraweeView) view.findViewById(R.id.icon_condition);
            this.O00000Oo = (LinearLayout) view.findViewById(R.id.action_ll);
            this.O00000oO = (TextView) view.findViewById(R.id.tv_scene_name);
            this.O00000oo = (CheckBox) view.findViewById(R.id.ckb_edit_selected);
            this.O0000Oo0 = view.findViewById(R.id.scene_new_more_icon);
            this.O0000OoO = (TextView) view.findViewById(R.id.execute_tv);
            this.O0000Ooo = (TextView) view.findViewById(R.id.txt_happen_time);
            TextView textView = this.O0000Ooo;
            if (textView != null) {
                textView.setTypeface(gno.O000000o(MySceneFragmentNew.this.getContext(), "fonts/KLight.ttf"));
            }
            this.O0000o00 = (TextView) view.findViewById(R.id.txt_tomorrow_tag);
        }

        public final void setExpandStateFlags(int i) {
            this.O0000o0O = i;
        }

        public final int getExpandStateFlags() {
            return this.O0000o0O;
        }
    }

    abstract class O00000Oo extends axy implements axs {
        public O00000Oo(View view) {
            super(view);
        }
    }

    class O00000o0 extends O00000Oo {
        private int O00000o0;

        public O00000o0(View view) {
            super(view);
            view.findViewById(R.id.common_white_empty_view).setVisibility(0);
            ((TextView) view.findViewById(R.id.common_white_empty_text)).setText((int) R.string.my_scene_no_data);
        }

        public final void setExpandStateFlags(int i) {
            this.O00000o0 = i;
        }

        public final int getExpandStateFlags() {
            return this.O00000o0;
        }
    }

    class O00000o extends O00000Oo {
        TextView O00000Oo;
        private int O00000o;

        public O00000o(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv_home_filter);
        }

        public final void setExpandStateFlags(int i) {
            this.O00000o = i;
        }

        public final int getExpandStateFlags() {
            return this.O00000o;
        }
    }

    class O0000OOo extends O00000Oo {
        TextView O00000Oo;
        private int O00000o;

        public O0000OOo(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.group_tv);
        }

        public final void setExpandStateFlags(int i) {
            this.O00000o = i;
        }

        public final int getExpandStateFlags() {
            return this.O00000o;
        }
    }

    class O0000Oo0 extends aya<O00000Oo, O000000o> {
        private int O00000Oo;

        public final long getChildId(int i, int i2) {
            return (long) i2;
        }

        public final long getGroupId(int i) {
            return (long) i;
        }

        public final /* bridge */ /* synthetic */ boolean onCheckCanExpandOrCollapseGroup(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, boolean z) {
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:67:0x021f  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x029e  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x02bd  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x02c6  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x02d1  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x035b  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x03af  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x03b5  */
        public final /* synthetic */ void onBindChildViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, final int i2, final int i3) {
            final O000000o o000000o = (O000000o) o000OOo0;
            final SceneApi.O000OOOo o000OOOo = (i < 0 || i >= getGroupCount() || i2 < 0 || i2 >= getChildCount(i)) ? null : (SceneApi.O000OOOo) ((List) MySceneFragmentNew.this.O00000o.get(i).second).get(i2);
            if (o000OOOo != null) {
                if (getChildCount(i) == 1) {
                    o000000o.f10577O000000o.setBackgroundResource(R.drawable.all_radius_rectangle_bg);
                } else if (i2 == 0) {
                    o000000o.f10577O000000o.setBackgroundResource(R.drawable.top_radius_rectangle_bg);
                } else if (i2 == getChildCount(i) - 1) {
                    o000000o.f10577O000000o.setBackgroundResource(R.drawable.bottom_radius_rectangle_bg);
                } else {
                    o000000o.f10577O000000o.setBackgroundResource(R.color.mj_color_dialog_bg_nor);
                }
                if (i3 == 50) {
                    o000000o.O00000oO.setText(o000OOOo.O00000Oo);
                    o000000o.O00000oO.setMaxWidth(gpc.O00000Oo(MySceneFragmentNew.this.getContext()));
                    o000000o.O0000o00.setMaxLines(1);
                    hnw.O000000o(o000OOOo, o000000o.O00000Oo);
                    o000000o.O0000Oo0.setVisibility(8);
                    if (o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() <= 0 || o000OOOo.O0000O0o.get(0).O00000Oo == null) {
                        o000000o.O0000Ooo.setText("");
                        o000000o.O0000o00.setVisibility(8);
                    } else {
                        o000000o.O0000Ooo.setText(SmartHomeSceneTimerActivity.getTimerHint(MySceneFragmentNew.this.getActivity(), o000OOOo.O0000O0o.get(0).O00000Oo));
                        CorntabUtils.CorntabParam corntabParam = o000OOOo.O0000O0o.get(0).O00000Oo.f11124O000000o;
                        FragmentActivity activity = MySceneFragmentNew.this.getActivity();
                        StringBuilder sb = new StringBuilder();
                        Calendar instance = Calendar.getInstance();
                        Calendar instance2 = Calendar.getInstance();
                        instance2.set(instance.get(1), corntabParam.O00000oO - 1, corntabParam.O00000o);
                        if (!goz.O000000o(instance, instance2)) {
                            if (goz.O000000o(instance2, 1)) {
                                sb.append(activity.getString(R.string.plug_timer_tomorrow));
                            } else if (goz.O000000o(instance2, 2)) {
                                sb.append(activity.getString(R.string.plug_timer_after_tommorrow));
                            }
                        }
                        String sb2 = sb.toString();
                        if (TextUtils.isEmpty(sb2)) {
                            o000000o.O0000o00.setVisibility(8);
                        } else {
                            o000000o.O0000o00.setVisibility(0);
                            o000000o.O0000o00.setText(sb2);
                            int O000000o2 = O000000o(o000000o.O0000o00) + gpc.O000000o(10.0f);
                            if (sb2.length() > 13 && O000000o(o000000o.O00000oO) + O000000o2 + gpc.O000000o(33.0f) > this.O00000Oo) {
                                o000000o.O0000o00.setMaxLines(2);
                                O000000o2 = gpc.O000000o(60.0f);
                            }
                            o000000o.O0000o00.setMaxWidth(O000000o2);
                            o000000o.O00000oO.setMaxWidth((this.O00000Oo - O000000o2) - gpc.O000000o(33.0f));
                        }
                    }
                    if (MySceneFragmentNew.this.O0000oOO) {
                        o000000o.O00000oo.setVisibility(0);
                        if (MySceneFragmentNew.this.O000O00o.containsKey(o000OOOo.f11131O000000o)) {
                            o000000o.O00000oo.setChecked(true);
                        } else {
                            o000000o.O00000oo.setChecked(false);
                        }
                    } else {
                        o000000o.O00000oo.setVisibility(4);
                    }
                    if (MySceneFragmentNew.this.O0000oOO) {
                        o000000o.O00000oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.O0000Oo0.AnonymousClass3 */

                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                gsy.O00000Oo("MySceneFragmentNew", "onCheckedChanged  scene.mIsLite " + o000OOOo.O0000oO0 + "  childPosition " + i2 + "  isChecked  " + z);
                                int i = i3;
                                if (i == 30) {
                                    MySceneFragmentNew.this.O000000o(i2, z, 30);
                                } else if (i == 50) {
                                    MySceneFragmentNew.this.O000000o(i2, z, 50);
                                } else {
                                    MySceneFragmentNew.this.O000000o(i2, z, 15);
                                }
                            }
                        });
                    }
                    o000000o.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.O0000Oo0.AnonymousClass4 */

                        public final void onClick(View view) {
                            if (MySceneFragmentNew.this.O0000oOO) {
                                o000000o.O00000oo.setChecked(!o000000o.O00000oo.isChecked());
                            } else if (gfr.f17662O000000o) {
                                gqg.O00000Oo("us_id:" + o000OOOo.f11131O000000o + "\n" + o000OOOo.O0000O0o.get(0).O00000Oo.f11124O000000o.toString());
                            }
                        }
                    });
                    o000000o.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.O0000Oo0.AnonymousClass5 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(int, boolean, int):void
                         arg types: [int, int, int]
                         candidates:
                          com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(int, com.xiaomi.smarthome.homeroom.model.Home, java.lang.Object):void
                          com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(int, boolean, int):void */
                        public final boolean onLongClick(View view) {
                            if (!MySceneFragmentNew.this.O0000oOO && !MySceneFragmentNew.this.O00000o0.isRefreshing()) {
                                MySceneFragmentNew.this.O00000oO();
                                MySceneFragmentNew.this.O000000o(i2, true, i3);
                            }
                            return true;
                        }
                    });
                    return;
                }
                if (!(o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() == 0)) {
                    hod.O0000OoO();
                    if (!hod.O00000oO(o000OOOo)) {
                        o000000o.itemView.setOnClickListener(new View.OnClickListener(o000000o) {
                            /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$O0000Oo0$Nf9bkhOIc3Ag9oUCNA2Y6Pj43rM */
                            private final /* synthetic */ MySceneFragmentNew.O000000o f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                MySceneFragmentNew.O0000Oo0.this.O000000o(this.f$1, view);
                            }
                        });
                        o000000o.O00000oO.setTextColor(MySceneFragmentNew.this.getResources().getColor(R.color.mj_color_black_40_transparent));
                        if (o000OOOo.O0000O0o.size() <= 0) {
                            o000000o.O00000o0.setVisibility(0);
                            o000000o.O00000o0.setHierarchy(new GenericDraweeHierarchyBuilder(o000000o.O00000o0.getResources()).setFadeDuration(200).setPlaceholderImage(o000000o.O00000o0.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
                            if (o000OOOo == null || o000OOOo.O0000O0o.size() <= 0) {
                                o000000o.O00000o0.setImageURI(gqd.O000000o((int) R.drawable.intelligence_icon_default_nor));
                            } else {
                                hnw.O000000o(o000000o.O00000o0, o000OOOo.O0000O0o.get(0));
                            }
                            if (o000OOOo.O0000O0o.size() > 1) {
                                o000000o.O00000o.setVisibility(0);
                            } else {
                                o000000o.O00000o.setVisibility(8);
                            }
                            o000000o.O00000o.setImageResource(hnw.O00000o0(o000OOOo.O0000Ooo));
                        } else {
                            o000000o.O00000o0.setVisibility(8);
                            o000000o.O00000o.setVisibility(8);
                        }
                        hnw.O000000o(o000OOOo, o000000o.O00000Oo);
                        o000000o.O0000Oo0.setVisibility(8);
                        o000000o.O00000oO.setText(o000OOOo.O00000Oo);
                        if (o000OOOo.O0000o0o == 0) {
                            o000000o.O0000O0o.setImageResource(R.drawable.exclamation_mark);
                        } else {
                            o000000o.O0000O0o.setVisibility(4);
                        }
                        if (!MySceneFragmentNew.this.O0000oOO) {
                            o000000o.O00000oo.setVisibility(0);
                            o000000o.O0000O0o.setVisibility(4);
                            o000000o.O0000OOo.setVisibility(4);
                            o000000o.O00000oo.setOnCheckedChangeListener(null);
                            o000000o.O0000OoO.setVisibility(8);
                            gsy.O00000Oo("MySceneFragmentNew", "mEditModeMap.containsKey(scene.id)" + MySceneFragmentNew.this.O000O00o.containsKey(o000OOOo.f11131O000000o) + "  mEditModeMap.get(scene.id) " + MySceneFragmentNew.this.O000O00o.get(o000OOOo.f11131O000000o) + " mEditModeMap.size " + MySceneFragmentNew.this.O000O00o.size() + " mEditModeMap.values " + MySceneFragmentNew.this.O000O00o.values());
                            if (MySceneFragmentNew.this.O000O00o.containsKey(o000OOOo.f11131O000000o)) {
                                o000000o.O00000oo.setChecked(true);
                            } else {
                                o000000o.O00000oo.setChecked(false);
                            }
                            o000000o.O00000oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(o000OOOo, i2, i3) {
                                /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$O0000Oo0$2FiPubat9pkOY5d_a0gnX40NCuI */
                                private final /* synthetic */ SceneApi.O000OOOo f$1;
                                private final /* synthetic */ int f$2;
                                private final /* synthetic */ int f$3;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                    this.f$3 = r4;
                                }

                                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                    MySceneFragmentNew.O0000Oo0.this.O000000o(this.f$1, this.f$2, this.f$3, compoundButton, z);
                                }
                            });
                        } else {
                            o000000o.O00000oo.setVisibility(8);
                            o000000o.O0000O0o.setVisibility(8);
                            if (o000OOOo.O0000oO0) {
                                o000000o.O0000OoO.setVisibility(0);
                                o000000o.O0000OOo.setVisibility(8);
                            } else {
                                o000000o.O0000OoO.setVisibility(8);
                                o000000o.O0000OOo.setVisibility(0);
                            }
                        }
                        o000000o.O0000OOo.setChecked(o000OOOo.O0000Oo0);
                        o000000o.O0000OOo.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(o000000o, o000OOOo) {
                            /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$O0000Oo0$oYhHwVQfvGhXkHMfsWL9O1LP4Q */
                            private final /* synthetic */ MySceneFragmentNew.O000000o f$1;
                            private final /* synthetic */ SceneApi.O000OOOo f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                MySceneFragmentNew.O0000Oo0.this.O000000o(this.f$1, this.f$2, compoundButton, z);
                            }
                        });
                        o000000o.itemView.setOnLongClickListener(new View.OnLongClickListener(o000OOOo, i2) {
                            /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$O0000Oo0$nVENQQcEQKYwqgDVmCMrtsZFvLk */
                            private final /* synthetic */ SceneApi.O000OOOo f$1;
                            private final /* synthetic */ int f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final boolean onLongClick(View view) {
                                return MySceneFragmentNew.O0000Oo0.this.O000000o(this.f$1, this.f$2, view);
                            }
                        });
                        o000000o.O0000OoO.setOnClickListener(new View.OnClickListener(o000OOOo) {
                            /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$O0000Oo0$hA6gQRJcTThOfHRkZjtUff33o8 */
                            private final /* synthetic */ SceneApi.O000OOOo f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                MySceneFragmentNew.O0000Oo0.this.O000000o(this.f$1, view);
                            }
                        });
                        if (!TextUtils.equals(MySceneFragmentNew.this.O0000o0, o000OOOo.f11131O000000o)) {
                            o000000o.O0000Oo.setVisibility(0);
                            return;
                        } else {
                            o000000o.O0000Oo.setVisibility(8);
                            return;
                        }
                    }
                }
                o000000o.itemView.setOnClickListener(new View.OnClickListener(o000000o, o000OOOo) {
                    /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$O0000Oo0$CRhmNU4uxMUaZNQ3eBJp8Qao_yo */
                    private final /* synthetic */ MySceneFragmentNew.O000000o f$1;
                    private final /* synthetic */ SceneApi.O000OOOo f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        MySceneFragmentNew.O0000Oo0.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
                o000000o.O00000oO.setTextColor(MySceneFragmentNew.this.getResources().getColor(R.color.mj_color_black_80_transparent));
                if (o000OOOo.O0000O0o.size() <= 0) {
                }
                hnw.O000000o(o000OOOo, o000000o.O00000Oo);
                o000000o.O0000Oo0.setVisibility(8);
                o000000o.O00000oO.setText(o000OOOo.O00000Oo);
                if (o000OOOo.O0000o0o == 0) {
                }
                if (!MySceneFragmentNew.this.O0000oOO) {
                }
                o000000o.O0000OOo.setChecked(o000OOOo.O0000Oo0);
                o000000o.O0000OOo.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(o000000o, o000OOOo) {
                    /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$O0000Oo0$oYhHwVQfvGhXkHMfsWL9O1LP4Q */
                    private final /* synthetic */ MySceneFragmentNew.O000000o f$1;
                    private final /* synthetic */ SceneApi.O000OOOo f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        MySceneFragmentNew.O0000Oo0.this.O000000o(this.f$1, this.f$2, compoundButton, z);
                    }
                });
                o000000o.itemView.setOnLongClickListener(new View.OnLongClickListener(o000OOOo, i2) {
                    /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$O0000Oo0$nVENQQcEQKYwqgDVmCMrtsZFvLk */
                    private final /* synthetic */ SceneApi.O000OOOo f$1;
                    private final /* synthetic */ int f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final boolean onLongClick(View view) {
                        return MySceneFragmentNew.O0000Oo0.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
                o000000o.O0000OoO.setOnClickListener(new View.OnClickListener(o000OOOo) {
                    /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$O0000Oo0$hA6gQRJcTThOfHRkZjtUff33o8 */
                    private final /* synthetic */ SceneApi.O000OOOo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        MySceneFragmentNew.O0000Oo0.this.O000000o(this.f$1, view);
                    }
                });
                if (!TextUtils.equals(MySceneFragmentNew.this.O0000o0, o000OOOo.f11131O000000o)) {
                }
            }
        }

        public final /* synthetic */ void onBindGroupViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            gsy.O00000Oo("MySceneFragmentNew", "onBindGroupViewHolder" + MySceneFragmentNew.this.O00000o.size());
            if (i2 == 22) {
                return;
            }
            if (i2 == 20) {
                if (MySceneFragmentNew.this.O0000oOO) {
                    o00000Oo.itemView.setEnabled(false);
                } else {
                    o00000Oo.itemView.setEnabled(true);
                }
                O00000o o00000o = (O00000o) o00000Oo;
                o00000o.O00000Oo.setText(((O0000O0o) MySceneFragmentNew.this.O00000o.get(i).first).f10579O000000o);
                o00000o.O00000Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.O0000Oo0.AnonymousClass1 */

                    public final void onClick(View view) {
                        MySceneFragmentNew.this.O0000o0O.O00000Oo();
                    }
                });
                hrv hrv = MySceneFragmentNew.this.O0000o0O;
                hrv.O0000OOo = o00000Oo.itemView;
                hrv.O0000OOo.findViewById(R.id.arrow_down_img).getLocationInWindow(hrv.O0000O0o);
                hrv.O0000OOo.getViewTreeObserver().addOnGlobalLayoutListener(hrv.O0000Oo);
                o00000Oo.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.O0000Oo0.AnonymousClass2 */

                    public final void onClick(View view) {
                        MySceneFragmentNew.this.O0000o0O.O00000Oo();
                    }
                });
            } else if (MySceneFragmentNew.this.O00000o != null && MySceneFragmentNew.this.O00000o.size() != 0 && ((O0000O0o) MySceneFragmentNew.this.O00000o.get(i).first) != null && (o00000Oo instanceof O0000OOo)) {
                ((O0000OOo) o00000Oo).O00000Oo.setText(((O0000O0o) MySceneFragmentNew.this.O00000o.get(i).first).f10579O000000o);
            }
        }

        public O0000Oo0() {
            setHasStableIds(true);
            this.O00000Oo = gpc.O00000Oo(MySceneFragmentNew.this.getContext());
        }

        public final int getGroupCount() {
            gsy.O00000Oo("MySceneFragmentNew", "getGroupCount" + MySceneFragmentNew.this.O00000o.size());
            return MySceneFragmentNew.this.O00000o.size();
        }

        public final int getGroupItemViewType(int i) {
            if (MySceneFragmentNew.this.O00000o == null || MySceneFragmentNew.this.O00000o.size() == 0) {
                return super.getGroupItemViewType(i);
            }
            return ((O0000O0o) MySceneFragmentNew.this.O00000o.get(i).first).O00000Oo;
        }

        public final int getChildCount(int i) {
            if (MySceneFragmentNew.this.O00000o == null || MySceneFragmentNew.this.O00000o.size() == 0 || MySceneFragmentNew.this.O00000o.get(i).second == null) {
                return 0;
            }
            return ((List) MySceneFragmentNew.this.O00000o.get(i).second).size();
        }

        public final int getChildItemViewType(int i, int i2) {
            if (MySceneFragmentNew.this.O00000o == null || MySceneFragmentNew.this.O00000o.size() == 0) {
                return super.getChildItemViewType(i, i2);
            }
            return ((O0000O0o) MySceneFragmentNew.this.O00000o.get(i).first).O00000Oo;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O000000o o000000o, SceneApi.O000OOOo o000OOOo, View view) {
            if (MySceneFragmentNew.this.O0000oOO) {
                o000000o.O00000oo.setChecked(!o000000o.O00000oo.isChecked());
                return;
            }
            hod.O0000OoO();
            if (!hod.O000000o(o000OOOo)) {
                hod.O0000OoO();
                if (!hod.O00000Oo(o000OOOo)) {
                    if (o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() <= 0 || o000OOOo.O0000O0o.get(0).f11121O000000o != LAUNCH_TYPE.NFC) {
                        Intent intent = new Intent(MySceneFragmentNew.this.getActivity(), SmarthomeCreateAutoSceneActivity.class);
                        hpq.O000000o().O000000o(o000OOOo);
                        MySceneFragmentNew.this.getActivity().startActivityForResult(intent, 999);
                        return;
                    }
                    Intent intent2 = new Intent(MySceneFragmentNew.this.getActivity(), NFCActionListActivity.class);
                    intent2.putExtra("us_id", o000OOOo.f11131O000000o);
                    MySceneFragmentNew.this.startActivity(intent2);
                    hpq.O000000o().O00000o0();
                    return;
                }
            }
            Intent intent3 = new Intent(MySceneFragmentNew.this.getActivity(), GoLeaveHomeSceneCreateEditActivity.class);
            intent3.putExtra("scene_id", o000OOOo.f11131O000000o);
            MySceneFragmentNew.this.startActivity(intent3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O000000o o000000o, View view) {
            if (MySceneFragmentNew.this.O0000oOO) {
                o000000o.O00000oo.setChecked(!o000000o.O00000oo.isChecked());
            } else {
                izb.O000000o(MySceneFragmentNew.this.getActivity(), (int) R.string.cannot_edit_ios_scene, 0).show();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(SceneApi.O000OOOo o000OOOo, int i, int i2, CompoundButton compoundButton, boolean z) {
            gsy.O00000Oo("MySceneFragmentNew", "onCheckedChanged  scene.mIsLite " + o000OOOo.O0000oO0 + "  childPosition " + i + "  isChecked  " + z);
            if (i2 == 30) {
                MySceneFragmentNew.this.O000000o(i, z, 30);
            } else if (i2 == 50) {
                MySceneFragmentNew.this.O000000o(i, z, 50);
            } else {
                MySceneFragmentNew.this.O000000o(i, z, 15);
            }
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
        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O000000o o000000o, SceneApi.O000OOOo o000OOOo, CompoundButton compoundButton, boolean z) {
            Device O00000o0;
            String str;
            Device O00000o02;
            String str2;
            if (!gof.O00000o0()) {
                izb.O000000o(MySceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_set_fail, 0).show();
                o000000o.O0000OOo.setChecked(o000OOOo.O0000Oo0);
                return;
            }
            o000OOOo.O0000Oo0 = z;
            if (!TextUtils.isEmpty(o000OOOo.f11131O000000o) && eys.f15955O000000o) {
                MySceneFragmentNew mySceneFragmentNew = MySceneFragmentNew.this;
                mySceneFragmentNew.O000O0OO = true;
                String str3 = null;
                boolean z2 = false;
                for (SceneApi.O000000o next : o000OOOo.O0000O0o) {
                    if (!(next.O00000o0 == null || next.O00000o0.O00000o == null || (O00000o02 = fno.O000000o().O00000o0(next.O00000o0.f11122O000000o)) == null)) {
                        if (O00000o02.isSubDevice()) {
                            str2 = O00000o02.parentId;
                        } else {
                            str2 = O00000o02.did;
                        }
                        if (hnw.O000000o(fno.O000000o().O00000o0(str2))) {
                            str3 = str2;
                            z2 = true;
                        }
                    }
                }
                if (!z2) {
                    for (SceneApi.Action next2 : o000OOOo.O00000oo) {
                        if (!(next2.O00000oO == null || next2.O0000O0o.O00000o == null || (O00000o0 = fno.O000000o().O00000o0(next2.O0000O0o.O00000o)) == null)) {
                            if (O00000o0.isSubDevice()) {
                                str = O00000o0.parentId;
                            } else {
                                str = O00000o0.did;
                            }
                            if (hnw.O000000o(fno.O000000o().O00000o0(str))) {
                                str3 = str;
                                z2 = true;
                            }
                        }
                    }
                }
                if (!z2 || str3 == null) {
                    mySceneFragmentNew.O000000o(o000OOOo, (String) null);
                } else {
                    Device O00000o03 = fno.O000000o().O00000o0(str3);
                    if (O00000o03 == null || O00000o03.isOnline) {
                        SceneApi.O000000o(o000OOOo);
                        hpp.O000000o().O000000o(hod.O00000o(o000OOOo), new Callback<SceneInfo>(o000OOOo, O00000o03) {
                            /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass9 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ SceneApi.O000OOOo f10576O000000o;
                            final /* synthetic */ Device O00000Oo;

                            {
                                this.f10576O000000o = r2;
                                this.O00000Oo = r3;
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                SceneInfo sceneInfo = (SceneInfo) obj;
                                if (sceneInfo != null) {
                                    for (int i = 0; i < sceneInfo.mLaunchList.size(); i++) {
                                        if (this.f10576O000000o.O0000O0o.get(i).O00000o0 != null && (this.f10576O000000o.O0000O0o.get(i).O00000o0 instanceof SceneApi.O00000o0)) {
                                            ((SceneApi.O00000o0) this.f10576O000000o.O0000O0o.get(i).O00000o0).O0000o00 = sceneInfo.mLaunchList.get(i).mExtra;
                                        }
                                    }
                                    for (int i2 = 0; i2 < sceneInfo.mActions.size(); i2++) {
                                        if (this.f10576O000000o.O00000oo.get(i2).O0000O0o != null && (this.f10576O000000o.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000OO0o)) {
                                            ((SceneApi.O000OO0o) this.f10576O000000o.O00000oo.get(i2).O0000O0o).f11130O000000o = sceneInfo.mActions.get(i2).mExtra;
                                        }
                                    }
                                }
                                MySceneFragmentNew.this.O000000o(this.f10576O000000o, this.O00000Oo.did);
                            }

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                             arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                             candidates:
                              com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(java.lang.String, int):com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo
                              com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                              com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                            public final void onFailure(int i, String str) {
                                gsy.O000000o(6, "lumiscene", str);
                                MySceneFragmentNew.this.O000000o(false, this.f10576O000000o);
                            }
                        });
                    } else {
                        if (mySceneFragmentNew.O000O0OO) {
                            mySceneFragmentNew.O000O0OO = false;
                            o000OOOo.O0000Oo0 = true ^ o000OOOo.O0000Oo0;
                            if (mySceneFragmentNew.O0000Ooo != null) {
                                mySceneFragmentNew.O0000Ooo.notifyDataSetChanged();
                            }
                        }
                        izb.O000000o(mySceneFragmentNew.getActivity(), (int) R.string.smarthome_scene_getway_offline, 0).show();
                    }
                }
            }
            CoreApi.O000000o().O000000o(StatType.EVENT, "open_slip_button_click", "scene_all_activity", (String) null, false);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(int, boolean, int):void
         arg types: [int, int, int]
         candidates:
          com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(int, com.xiaomi.smarthome.homeroom.model.Home, java.lang.Object):void
          com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(int, boolean, int):void */
        /* access modifiers changed from: private */
        public /* synthetic */ boolean O000000o(SceneApi.O000OOOo o000OOOo, int i, View view) {
            if (!MySceneFragmentNew.this.O0000oOO && !MySceneFragmentNew.this.O00000o0.isRefreshing()) {
                MySceneFragmentNew.this.O00000oO();
                if (o000OOOo.O0000oO0) {
                    MySceneFragmentNew.this.O000000o(i, true, 30);
                } else {
                    MySceneFragmentNew.this.O000000o(i, true, 15);
                }
            }
            return true;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(SceneApi.O000OOOo o000OOOo, View view) {
            MySceneFragmentNew mySceneFragmentNew = MySceneFragmentNew.this;
            if (o000OOOo != null) {
                hob.O000000o();
                hob.O000000o(ServiceApplication.getAppContext(), o000OOOo.f11131O000000o, "click", new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass3 */

                    public final void onFailure(fso fso) {
                        if (MySceneFragmentNew.this.isValid()) {
                            gqg.O00000Oo((int) R.string.execute_fail);
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (MySceneFragmentNew.this.isValid()) {
                            gqg.O00000Oo((int) R.string.execute_success);
                        }
                    }
                });
            }
        }

        private static int O000000o(TextView textView) {
            if (textView == null) {
                return 0;
            }
            Rect rect = new Rect();
            CharSequence text = textView.getText();
            textView.getPaint().getTextBounds(text.toString(), 0, text.length(), rect);
            double measureText = (double) textView.getPaint().measureText(text, 0, text.length());
            Double.isNaN(measureText);
            return (int) (measureText + 0.5d);
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateChildViewHolder(ViewGroup viewGroup, int i) {
            View view;
            gsy.O00000Oo("MySceneFragmentNew", "onCreateChildViewHolder" + MySceneFragmentNew.this.O00000o.size());
            if (i == 50) {
                view = MySceneFragmentNew.this.O0000oO.inflate((int) R.layout.item_voice_scene, (ViewGroup) null);
            } else {
                view = MySceneFragmentNew.this.O0000oO.inflate((int) R.layout.my_scene_fragment_scene_item, (ViewGroup) null);
            }
            gsy.O00000Oo("youhua", "SceneAdapteronCreateViewHolder  viewType".concat(String.valueOf(i)));
            return new O000000o(view);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
            gsy.O00000Oo("MySceneFragmentNew", "onCreateGroupViewHolder" + MySceneFragmentNew.this.O00000o.size());
            if (i == 20) {
                MySceneFragmentNew mySceneFragmentNew = MySceneFragmentNew.this;
                return new O00000o(mySceneFragmentNew.O0000oO.inflate((int) R.layout.item_scene_filter, viewGroup, false));
            } else if (i == 22) {
                MySceneFragmentNew mySceneFragmentNew2 = MySceneFragmentNew.this;
                return new O00000o0(mySceneFragmentNew2.O0000oO.inflate((int) R.layout.common_white_empty_view_new, viewGroup, false));
            } else {
                MySceneFragmentNew mySceneFragmentNew3 = MySceneFragmentNew.this;
                return new O0000OOo(mySceneFragmentNew3.O0000oO.inflate((int) R.layout.fragment_my_scene_group_item, (ViewGroup) null));
            }
        }
    }

    public final void O00000oO() {
        FragmentActivity activity;
        if (this.O00oOoOo != 1) {
            this.O00oOoOo = 1;
            this.O0000oOO = true;
            this.O00000o0.setPullToRefresh(false);
            if (!getActivity().isFinishing() && (activity = getActivity()) != null && !activity.isFinishing()) {
                try {
                    View chooseSceneTitleBar = hop.O000000o().getChooseSceneTitleBar(activity);
                    AnimateLinearLayout animateLinearLayout = (AnimateLinearLayout) hop.O000000o().getChooseSceneMenuBar(activity);
                    this.O00oOooo = (TextView) chooseSceneTitleBar.findViewById(R.id.module_a_4_return_more_title);
                    TextView textView = this.O00oOooo;
                    Resources resources = getResources();
                    int size = this.O000O00o == null ? 0 : this.O000O00o.size();
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(this.O000O00o == null ? 0 : this.O000O00o.size());
                    textView.setText(resources.getQuantityString(R.plurals.selected_cnt_tips, size, objArr));
                    this.O0000oOo = (ImageView) chooseSceneTitleBar.findViewById(16908313);
                    this.O0000oo0 = (ImageView) chooseSceneTitleBar.findViewById(16908314);
                    this.O0000oo = (Button) animateLinearLayout.findViewById(R.id.btn_edit_rename);
                    this.O0000oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$it3uw_MGw5F8sWSb1I9UtiWkYg */

                        public final void onClick(View view) {
                            MySceneFragmentNew.this.O00000oo(view);
                        }
                    });
                    this.O0000ooO = (Button) animateLinearLayout.findViewById(R.id.btn_edit_delete);
                    this.O0000ooO.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$xUzQRHwQ3bNyIF0l0G4LPT3YuRM */

                        public final void onClick(View view) {
                            MySceneFragmentNew.this.O00000oO(view);
                        }
                    });
                    this.O0000ooo = (Button) animateLinearLayout.findViewById(R.id.btn_edit_sort);
                    this.O0000ooo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$AgFx4Q8dACdwFLVsW8qYL1zAK88 */

                        public final void onClick(View view) {
                            MySceneFragmentNew.this.O00000o(view);
                        }
                    });
                    this.O00oOooO = (Button) animateLinearLayout.findViewById(R.id.btn_edit_add_toLauncher);
                    this.O00oOooO.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$UX6RiXr9DxNjFgCXnv1kaVhjuyQ */

                        public final void onClick(View view) {
                            MySceneFragmentNew.this.O00000o0(view);
                        }
                    });
                    this.O0000oOo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$TVZk6E3WJecho10RhvgvkkwbRIw */

                        public final void onClick(View view) {
                            MySceneFragmentNew.this.O00000Oo(view);
                        }
                    });
                    this.O0000oo0.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$F_cu1zSCVFcTUnghqrUcr4bGmy0 */

                        public final void onClick(View view) {
                            MySceneFragmentNew.this.O000000o(view);
                        }
                    });
                    chooseSceneTitleBar.setVisibility(0);
                    animateLinearLayout.setVisibility(0);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chooseSceneTitleBar, View.TRANSLATION_Y, -getResources().getDimension(R.dimen.titlebar_height), 0.0f);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(animateLinearLayout, "translationY", (float) animateLinearLayout.getHeight(), 0.0f);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(200L);
                    animatorSet.play(ofFloat).with(ofFloat2);
                    animatorSet.start();
                    animateLinearLayout.O000000o(0, AnimateLinearLayout.O000000o(animateLinearLayout.getChildCount()));
                    this.O0000Ooo.notifyDataSetChanged();
                    if (!(this.O0000OoO == null || this.O0000OoO.O00000o == null)) {
                        this.O0000OoO.O00000o.setSwipeEnabled(false);
                    }
                    if (this.mPlaceHolderView != null && this.mPlaceHolderView.getVisibility() == 8) {
                        this.mPlaceHolderView.setVisibility(0);
                    }
                    this.mSceneViewRV.setPadding(0, 0, 0, gpc.O000000o(44.0f));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r10 = O000000o((java.lang.String) r9.O000O00o.entrySet().iterator().next().getKey(), ((java.lang.Integer) r9.O000O00o.entrySet().iterator().next().getValue()).intValue());
     */
    public /* synthetic */ void O00000oo(View view) {
        final SceneApi.O000OOOo O000000o2;
        HashMap<String, Integer> hashMap = this.O000O00o;
        if (hashMap != null && hashMap.size() != 0 && O000000o2 != null) {
            this.O000O00o.get(O000000o2.f11131O000000o).intValue();
            if (O000000o2 != null) {
                String O000000o3 = gqb.O000000o(TextUtils.isEmpty(O000000o2.O00000Oo) ? "" : O000000o2.O00000Oo, hpq.f480O000000o * 2);
                hah.O000000o(getActivity(), -1, O000000o3, getString(R.string.smarthome_scene_set_name), O000000o3, hpq.f480O000000o, new hah.O00000Oo() {
                    /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass7 */

                    public final void O000000o(String str) {
                    }

                    public final void O000000o(ClientRemarkInputView clientRemarkInputView, String str) {
                        final XQProgressDialog xQProgressDialog = new XQProgressDialog(MySceneFragmentNew.this.getActivity());
                        xQProgressDialog.setMessage(MySceneFragmentNew.this.getString(R.string.changeing_back_name));
                        xQProgressDialog.setCancelable(false);
                        xQProgressDialog.show();
                        final String str2 = O000000o2.O00000Oo;
                        O000000o2.O00000Oo = str;
                        if (!TextUtils.isEmpty(str) && !O000000o2.O00000oo.isEmpty()) {
                            Iterator<SceneApi.Action> it = O000000o2.O00000oo.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                SceneApi.Action next = it.next();
                                if (next.O0000O0o != null && (next.O0000O0o instanceof SceneApi.O000OO)) {
                                    ((SceneApi.O000OO) next.O0000O0o).O00000Oo = str;
                                    break;
                                }
                            }
                        }
                        hob O000000o2 = hob.O000000o();
                        MySceneFragmentNew.this.getActivity();
                        O000000o2.O000000o(O000000o2, new fsm<Void, fso>() {
                            /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass7.AnonymousClass1 */

                            public final void onFailure(fso fso) {
                                if (MySceneFragmentNew.this.isValid()) {
                                    if (fso == null || fso.f17063O000000o != -1) {
                                        izb.O000000o(MySceneFragmentNew.this.getActivity(), (int) R.string.change_back_name_fail, 0).show();
                                    } else {
                                        izb.O000000o(MySceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_has_deleted_device, 0).show();
                                    }
                                    xQProgressDialog.dismiss();
                                    SceneApi.O000OOOo o000OOOo = O000000o2;
                                    String str = str2;
                                    o000OOOo.O00000Oo = str;
                                    if (!TextUtils.isEmpty(str) && !O000000o2.O00000oo.isEmpty()) {
                                        for (SceneApi.Action next : O000000o2.O00000oo) {
                                            if (next.O0000O0o != null && (next.O0000O0o instanceof SceneApi.O000OO)) {
                                                ((SceneApi.O000OO) next.O0000O0o).O00000Oo = str2;
                                                return;
                                            }
                                        }
                                    }
                                }
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                if (MySceneFragmentNew.this.isValid()) {
                                    xQProgressDialog.dismiss();
                                    MySceneFragmentNew.this.O0000Ooo.notifyDataSetChanged();
                                    if (O000000o2.O0000oO0) {
                                        hpr.O00000o0().O00000Oo();
                                    } else {
                                        hod.O0000OoO().O00000o();
                                    }
                                }
                            }
                        });
                    }

                    public final String O00000Oo(String str) {
                        if (TextUtils.equals(O000000o2.O00000Oo, str)) {
                            return MySceneFragmentNew.this.getString(R.string.smarthome_scene_reset_name);
                        }
                        for (SceneApi.O000OOOo next : hod.O0000OoO().O00000o0) {
                            if (!TextUtils.equals(next.f11131O000000o, O000000o2.f11131O000000o) && TextUtils.equals(next.O00000Oo, str)) {
                                return MySceneFragmentNew.this.getString(R.string.scene_modify_name_error);
                            }
                        }
                        for (SceneApi.O000OOOo next2 : hpr.O00000o0().O0000O0o) {
                            if (!TextUtils.equals(next2.f11131O000000o, O000000o2.f11131O000000o) && TextUtils.equals(next2.O00000Oo, str)) {
                                return MySceneFragmentNew.this.getString(R.string.scene_modify_name_error);
                            }
                        }
                        return "";
                    }
                });
            }
            O00000oo();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO(View view) {
        SceneApi.O000OOOo O00000Oo2;
        String quantityString = getResources().getQuantityString(R.plurals.scene_confirm_delete_plurals, this.O000O00o.size(), Integer.valueOf(this.O000O00o.size()));
        HashMap<String, Integer> hashMap = this.O000O00o;
        if (hashMap != null && hashMap.size() == 1 && ((Integer) this.O000O00o.entrySet().iterator().next().getValue()).intValue() == 15 && (O00000Oo2 = hod.O0000OoO().O00000Oo((String) this.O000O00o.entrySet().iterator().next().getKey())) != null && O00000Oo2.O0000O0o != null && O00000Oo2.O0000O0o.size() == 1 && O00000Oo2.O0000O0o.get(0).f11121O000000o == LAUNCH_TYPE.NFC) {
            quantityString = getString(R.string.nfc_scene_confirm_delete);
        }
        hrg.O000000o(getContext(), quantityString, getString(R.string.sh_common_cancel), getString(R.string.confirm), new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass4 */

            public final void onClick(View view) {
                MySceneFragmentNew mySceneFragmentNew = MySceneFragmentNew.this;
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, Integer> key : mySceneFragmentNew.O000O00o.entrySet()) {
                    arrayList.add(key.getKey());
                }
                mySceneFragmentNew.O000000o(arrayList);
                mySceneFragmentNew.O00000oo();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        getActivity().startActivityForResult(new Intent(getActivity(), SmarthomeSortLiteSceneActivity.class), 999);
        O00000oo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        HashMap<String, Integer> hashMap = this.O000O00o;
        if (hashMap != null && hashMap.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : this.O000O00o.entrySet()) {
                SceneApi.O000OOOo O000000o2 = O000000o((String) next.getKey(), ((Integer) next.getValue()).intValue());
                if (O000000o2 != null) {
                    arrayList.add(O000000o2);
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                SceneApi.O000OOOo o000OOOo = (SceneApi.O000OOOo) arrayList.get(i);
                if (o000OOOo != null) {
                    hnw.O000000o(getActivity(), o000OOOo, hnw.O00000Oo(o000OOOo.O00000o));
                }
            }
            O00000oo();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        O00000oo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        gsy.O00000Oo("MySceneFragmentNew", "getCheckedCount()" + O0000o0O() + "    mCustomScenes.size()" + this.O000O0Oo.size());
        gsy.O00000Oo("MySceneFragmentNew", "getCheckedCount()" + O0000o0O() + "    mSmartHomeScenes.size()" + this.O00000oO.size());
        boolean z = O0000o0O() < (this.O000O0Oo.size() + this.O00000oO.size()) + this.O00000oo.size();
        for (int i = 0; i < this.O000O0Oo.size(); i++) {
            O000000o(i, z, 15);
        }
        for (int i2 = 0; i2 < this.O00000oO.size(); i2++) {
            O000000o(i2, z, 30);
        }
        for (int i3 = 0; i3 < this.O00000oo.size(); i3++) {
            O000000o(i3, z, 50);
        }
        this.O0000Ooo.notifyDataSetChanged();
    }

    public final void O000000o(final List<String> list) {
        hob.O000000o().O000000o(getActivity(), list, new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass5 */

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o() {
                Object arrayList;
                MySceneFragmentNew mySceneFragmentNew = MySceneFragmentNew.this;
                int i = 1;
                while (true) {
                    if (i >= mySceneFragmentNew.O00000o.size()) {
                        arrayList = new ArrayList();
                        break;
                    } else if (((O0000O0o) mySceneFragmentNew.O00000o.get(i).first).O00000Oo == 30) {
                        arrayList = (List) mySceneFragmentNew.O00000o.get(i).second;
                        break;
                    } else {
                        i++;
                    }
                }
                if (arrayList != null) {
                    hpr.O00000o0().O000000o((fsm) null);
                }
            }

            public final void onFailure(fso fso) {
                if (MySceneFragmentNew.this.isValid()) {
                    if (fso == null || fso.f17063O000000o != -2) {
                        izb.O000000o(MySceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_delete_fail, 0).show();
                        return;
                    }
                    MySceneFragmentNew mySceneFragmentNew = MySceneFragmentNew.this;
                    hrg.O000000o(mySceneFragmentNew.mContext, mySceneFragmentNew.getString(R.string.delete_scene_fail_title), mySceneFragmentNew.getString(R.string.sh_common_cancel), mySceneFragmentNew.getString(R.string.mj_retry), new View.OnClickListener(list) {
                        /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass8 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ List f10575O000000o;

                        {
                            this.f10575O000000o = r2;
                        }

                        public final void onClick(View view) {
                            MySceneFragmentNew.this.O000000o(this.f10575O000000o);
                        }
                    });
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (MySceneFragmentNew.this.isValid()) {
                    boolean z = false;
                    izb.O000000o(MySceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_delete_succ, 0).show();
                    for (String str : list) {
                        hod.O0000OoO().O00000o0(str);
                        z |= hpr.O00000o0().O00000Oo(str);
                    }
                    gsy.O00000Oo("MySceneFragmentNew", "hasChangeLiteScene".concat(String.valueOf(z)));
                    hod.O0000OoO().O0000Oo();
                    MySceneFragmentNew.this.O000000o(-1);
                    MySceneFragmentNew.this.O0000o0O.O00000o0();
                    MySceneFragmentNew.this.O00000o();
                    if (z) {
                        ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
                            /* class com.xiaomi.smarthome.scene.$$Lambda$MySceneFragmentNew$5$iIlYdyDGOnwUxlwBSG6eKzS44M */

                            public final void run() {
                                MySceneFragmentNew.AnonymousClass5.this.O000000o();
                            }
                        });
                    }
                }
            }
        });
    }

    public final void O00000oo() {
        if (this.O00oOoOo != 0) {
            this.O00oOoOo = 0;
            this.O0000oOO = false;
            if (!getActivity().isFinishing() && !getActivity().isFinishing()) {
                this.O00000o0.setPullToRefresh(true);
                FragmentActivity activity = getActivity();
                if (activity != null && !activity.isFinishing()) {
                    try {
                        final View chooseSceneTitleBar = hop.O000000o().getChooseSceneTitleBar(activity);
                        final AnimateLinearLayout animateLinearLayout = (AnimateLinearLayout) hop.O000000o().getChooseSceneMenuBar(activity);
                        animateLinearLayout.getParent();
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chooseSceneTitleBar, View.Y, 0.0f, (float) (-chooseSceneTitleBar.getHeight()));
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(animateLinearLayout, "translationY", 0.0f, (float) animateLinearLayout.getHeight());
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.setDuration(200L);
                        animatorSet.play(ofFloat).with(ofFloat2);
                        animatorSet.start();
                        animatorSet.addListener(new Animator.AnimatorListener() {
                            /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass6 */

                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }

                            public final void onAnimationStart(Animator animator) {
                            }

                            public final void onAnimationEnd(Animator animator) {
                                chooseSceneTitleBar.clearAnimation();
                                animateLinearLayout.clearAnimation();
                                chooseSceneTitleBar.setVisibility(8);
                                animateLinearLayout.setVisibility(8);
                            }
                        });
                        this.O000O00o.clear();
                        TextView textView = this.O00oOooo;
                        Resources resources = getResources();
                        int size = this.O000O00o == null ? 0 : this.O000O00o.size();
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.O000O00o == null ? 0 : this.O000O00o.size());
                        textView.setText(resources.getQuantityString(R.plurals.selected_cnt_tips, size, objArr));
                        this.O0000Ooo.notifyDataSetChanged();
                        if (!(this.O0000OoO == null || this.O0000OoO.O00000o == null)) {
                            this.O0000OoO.O00000o.setSwipeEnabled(true);
                        }
                        if (this.mPlaceHolderView != null && this.mPlaceHolderView.getVisibility() == 0) {
                            this.mPlaceHolderView.setVisibility(8);
                        }
                        this.mSceneViewRV.setPadding(0, 0, 0, 0);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public final void O000000o(int i, boolean z, int i2) {
        SceneApi.O000OOOo O00000Oo2;
        if (i2 == 15) {
            if (i >= this.O000O0Oo.size()) {
                gsy.O000000o(6, "MySceneFragmentNew", "position" + i + "mCustomScenes.size()" + this.O000O0Oo.size());
                return;
            } else if (z) {
                this.O000O00o.put(this.O000O0Oo.get(i).f11131O000000o, Integer.valueOf(i2));
            } else {
                this.O000O00o.remove(this.O000O0Oo.get(i).f11131O000000o);
            }
        } else if (i2 == 30) {
            if (i >= this.O00000oO.size()) {
                gsy.O000000o(6, "MySceneFragmentNew", "position" + i + "mSmartHomeScenes.size()" + this.O00000oO.size());
                return;
            } else if (z) {
                this.O000O00o.put(this.O00000oO.get(i).f11131O000000o, Integer.valueOf(i2));
            } else {
                this.O000O00o.remove(this.O00000oO.get(i).f11131O000000o);
            }
        } else if (i2 == 50) {
            if (i < this.O00000oo.size()) {
                if (z) {
                    this.O000O00o.put(this.O00000oo.get(i).f11131O000000o, Integer.valueOf(i2));
                } else {
                    this.O000O00o.remove(this.O00000oo.get(i).f11131O000000o);
                }
            } else {
                return;
            }
        }
        HashMap<String, Integer> hashMap = this.O000O00o;
        int size = hashMap == null ? 0 : hashMap.size();
        this.O00oOooo.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, size, Integer.valueOf(size)));
        try {
            if (size >= this.O000O0Oo.size() + this.O00000oO.size() + this.O00000oo.size()) {
                this.O0000oo0.setImageResource(R.drawable.un_select_selector);
                this.O00oOooO.setContentDescription(getString(R.string.unselect_all));
            } else {
                this.O0000oo0.setImageResource(R.drawable.all_select_selector);
                this.O0000oo0.setContentDescription(getString(R.string.select_all));
            }
            if (this.O000O00o == null || this.O000O00o.size() != 1 || ((((Integer) this.O000O00o.entrySet().iterator().next().getValue()).intValue() == 15 && (O00000Oo2 = hod.O0000OoO().O00000Oo((String) this.O000O00o.entrySet().iterator().next().getKey())) != null && O00000Oo2.O0000O0o != null && O00000Oo2.O0000O0o.size() == 1 && O00000Oo2.O0000O0o.get(0).f11121O000000o == LAUNCH_TYPE.NFC) || ((Integer) this.O000O00o.entrySet().iterator().next().getValue()).intValue() == 50)) {
                this.O0000oo.setEnabled(false);
                this.O0000oo.setVisibility(8);
            } else {
                this.O0000oo.setEnabled(true);
                this.O0000oo.setVisibility(0);
            }
            if (this.O000O00o != null) {
                if (this.O000O00o.size() > 0) {
                    this.O0000ooO.setEnabled(true);
                    this.O0000ooO.setVisibility(0);
                    O0000o0();
                    O0000o00();
                }
            }
            this.O0000ooO.setEnabled(false);
            this.O0000ooO.setVisibility(8);
            O0000o0();
            O0000o00();
        } catch (Exception unused) {
        }
    }

    private void O0000o00() {
        HashMap<String, Integer> hashMap;
        HashMap<String, Integer> hashMap2 = this.O000O00o;
        if (hashMap2 == null || hashMap2.size() == 0) {
            this.O00oOooO.setEnabled(false);
            this.O00oOooO.setVisibility(8);
        } else if (!gnn.O00000o0 || (hashMap = this.O000O00o) == null || hashMap.size() <= 1) {
            for (Map.Entry next : this.O000O00o.entrySet()) {
                next.getKey();
                if (((Integer) next.getValue()).intValue() != 30) {
                    this.O00oOooO.setEnabled(false);
                    this.O00oOooO.setVisibility(8);
                    return;
                }
            }
            this.O00oOooO.setEnabled(true);
            this.O00oOooO.setVisibility(0);
        } else {
            this.O00oOooO.setEnabled(false);
            this.O00oOooO.setVisibility(8);
        }
    }

    private void O0000o0() {
        HashMap<String, Integer> hashMap = this.O000O00o;
        if (hashMap == null || hashMap.size() <= 0) {
            this.O0000ooo.setEnabled(false);
            this.O0000ooo.setVisibility(8);
            return;
        }
        for (Map.Entry<String, Integer> value : this.O000O00o.entrySet()) {
            if (((Integer) value.getValue()).intValue() != 30) {
                this.O0000ooo.setEnabled(false);
                this.O0000ooo.setVisibility(8);
                return;
            }
        }
        this.O0000ooo.setEnabled(true);
        this.O0000ooo.setVisibility(0);
    }

    private static SceneApi.O000OOOo O000000o(String str, int i) {
        if (i == 15) {
            return hod.O0000OoO().O00000Oo(str);
        }
        return hpr.O00000o0().O000000o(str);
    }

    private int O0000o0O() {
        HashMap<String, Integer> hashMap = this.O000O00o;
        if (hashMap == null) {
            return 0;
        }
        return hashMap.size();
    }

    public final void O000000o(final SceneApi.O000OOOo o000OOOo, final String str) {
        if (eys.f15955O000000o) {
            ServiceApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass10 */

                public final void run() {
                    hob.O000000o().O000000o(MySceneFragmentNew.this.getActivity(), o000OOOo, new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass10.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                         arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                         candidates:
                          com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(java.lang.String, int):com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo
                          com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                          com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (MySceneFragmentNew.this.isValid()) {
                                MySceneFragmentNew mySceneFragmentNew = MySceneFragmentNew.this;
                                SceneApi.O000OOOo o000OOOo = o000OOOo;
                                String str = str;
                                String optString = jSONObject.optString("us_id");
                                boolean optBoolean = jSONObject.optBoolean("local");
                                o000OOOo.f11131O000000o = optString;
                                if (TextUtils.isEmpty(str) || !optBoolean) {
                                    mySceneFragmentNew.O000000o(true, o000OOOo);
                                } else if (fno.O000000o().O00000o0(str) != null) {
                                    hpn.O000000o().O000000o(XmPluginHostApi.instance().getDeviceByDid(str), jSONObject.optJSONObject("data").toString(), new MessageCallback(o000OOOo) {
                                        /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass13 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ SceneApi.O000OOOo f10559O000000o;

                                        {
                                            this.f10559O000000o = r2;
                                        }

                                        public final void onSuccess(Intent intent) {
                                            hob.O000000o();
                                            hob.O00000Oo(MySceneFragmentNew.this.getActivity(), this.f10559O000000o, new fsm<Void, fso>() {
                                                /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass13.AnonymousClass1 */

                                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                                 method: com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                                                 arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                                                 candidates:
                                                  com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(java.lang.String, int):com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo
                                                  com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                                                  com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                                                public final void onFailure(fso fso) {
                                                    if (MySceneFragmentNew.this.isValid()) {
                                                        MySceneFragmentNew.this.O000000o(false, AnonymousClass13.this.f10559O000000o);
                                                    }
                                                }

                                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                                 method: com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                                                 arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                                                 candidates:
                                                  com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(java.lang.String, int):com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo
                                                  com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                                                  com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                                                public final /* synthetic */ void onSuccess(Object obj) {
                                                    if (MySceneFragmentNew.this.isValid()) {
                                                        MySceneFragmentNew.this.O000000o(true, AnonymousClass13.this.f10559O000000o);
                                                    }
                                                }
                                            });
                                        }

                                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                         method: com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                                         arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                                         candidates:
                                          com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(java.lang.String, int):com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo
                                          com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                                          com.xiaomi.smarthome.scene.MySceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                                        public final void onFailure(int i, String str) {
                                            gsy.O000000o(6, "lumiscene", str);
                                            if (MySceneFragmentNew.this.isValid()) {
                                                MySceneFragmentNew.this.O000000o(false, this.f10559O000000o);
                                            }
                                        }
                                    });
                                }
                            }
                        }

                        public final void onFailure(fso fso) {
                            if (MySceneFragmentNew.this.isValid()) {
                                if (MySceneFragmentNew.this.O000O0OO) {
                                    MySceneFragmentNew.this.O000O0OO = false;
                                    o000OOOo.O0000Oo0 = !o000OOOo.O0000Oo0;
                                    MySceneFragmentNew.this.O0000Ooo.notifyDataSetChanged();
                                }
                                if (fso.f17063O000000o == -1) {
                                    izb.O000000o(MySceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_has_deleted_device, 0).show();
                                } else {
                                    izb.O000000o(MySceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_change_switch_fail, 0).show();
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final boolean z, final SceneApi.O000OOOo o000OOOo) {
        if (isValid()) {
            ServiceApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.scene.MySceneFragmentNew.AnonymousClass11 */

                public final void run() {
                    if (!z) {
                        if (MySceneFragmentNew.this.O000O0OO) {
                            MySceneFragmentNew.this.O000O0OO = false;
                            SceneApi.O000OOOo o000OOOo = o000OOOo;
                            o000OOOo.O0000Oo0 = !o000OOOo.O0000Oo0;
                            MySceneFragmentNew.this.O0000Ooo.notifyDataSetChanged();
                        }
                        izb.O000000o(MySceneFragmentNew.this.getActivity(), (int) R.string.local_sync_failed, 0).show();
                    } else if (MySceneFragmentNew.this.O000O0OO) {
                        MySceneFragmentNew.this.O000O0OO = false;
                    }
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        gsy.O00000Oo("MySceneFragmentNew", "onActivityResult" + i + "resultCode" + i2);
        if (i == 999 && i2 == -1 && this.O0000Oo0 && this.O0000OOo) {
            this.O0000o0O.O00000o0();
            O00000o();
        }
    }

    public final void O0000O0o() {
        if (isValid()) {
            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                hni.O000000o().O00000Oo();
                ft.O000000o(getContext()).O000000o(this.O000OO00);
                this.O000OO = null;
                O0000Ooo();
                this.O0000o0O.O00000Oo((Home) null);
                this.O00000o.clear();
                O00000o();
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("home_room_updated");
            O0000OoO();
            if (ggb.O00000Oo().O00000oO()) {
                this.O0000o0O.O000000o();
                this.O0000o0O.O00000o0();
            } else {
                ft.O000000o(getContext()).O000000o(this.O000OO00, intentFilter);
            }
            hni.O000000o().O00000o0();
            O00000o();
        }
    }

    public final void O0000OOo() {
        List<SceneApi.O000OOOo> list;
        if (this.O0000Ooo != null && (list = this.O00000oo) != null && list.size() != 0) {
            CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
            boolean z = false;
            for (int size = this.O00000oo.size() - 1; size >= 0; size--) {
                if (this.O00000oo.get(size).O0000O0o == null || this.O00000oo.get(size).O0000O0o.size() == 0 || this.O00000oo.get(size).O0000O0o.get(0).O00000Oo == null || this.O00000oo.get(size).O0000O0o.get(0).O00000Oo.f11124O000000o == null) {
                    this.O00000oo.remove(size);
                } else {
                    hod.O0000OoO();
                    if (!hod.O000000o(corntabParam, this.O00000oo.get(size).O0000O0o.get(0).O00000Oo.f11124O000000o)) {
                        this.O00000oo.remove(size);
                    }
                }
                z = true;
            }
            if (z) {
                if (this.O00000oo.size() == 0) {
                    for (int size2 = this.O00000o.size() - 1; size2 > 0; size2--) {
                        if (this.O00000o.get(size2).second == null || ((List) this.O00000o.get(size2).second).size() == 0) {
                            this.O00000o.remove(size2);
                        }
                    }
                }
                this.O0000Ooo.notifyDataSetChanged();
            }
        }
    }

    public final void O000000o(int i, Home home, Object obj) {
        List<SceneApi.O000OOOo> list;
        boolean z;
        ArrayList arrayList = new ArrayList();
        List<SceneApi.O000OOOo> list2 = hpr.O00000o0().O0000O0o;
        if (!hpr.O00000o0().O00000o && list2.size() == 0) {
            list2 = hpr.O00000o0().O0000OOo;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!hod.O0000OoO().O00000oo) {
            arrayList2.addAll(hod.O0000OoO().O0000o00);
        } else {
            arrayList2.addAll(hod.O0000OoO().f416O000000o);
        }
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            if (((SceneApi.O000OOOo) arrayList2.get(size)).O0000O0o != null && ((SceneApi.O000OOOo) arrayList2.get(size)).O0000O0o.size() > 0 && ((SceneApi.O000OOOo) arrayList2.get(size)).O0000O0o.get(0).f11121O000000o == LAUNCH_TYPE.NFC) {
                arrayList2.remove(size);
            }
        }
        if (!hod.O0000OoO().O0000O0o) {
            list = hod.O0000OoO().O0000o0;
        } else {
            list = hod.O0000OoO().O00000Oo;
        }
        this.O00000oO.clear();
        this.O00000oo.clear();
        this.O000O0Oo.clear();
        if (i == 0) {
            this.O00000oO = hnv.O000000o(home, list2);
            this.O000O0Oo = hnv.O000000o(home, arrayList2);
            this.O00000oo = hnv.O000000o(home, list);
        } else if (i != 1) {
            if (i == 2) {
                DeviceTagInterface.Category category = (DeviceTagInterface.Category) obj;
                this.O00000oO = hnv.O000000o(home, category, list2);
                this.O000O0Oo = hnv.O000000o(home, category, arrayList2);
                this.O00000oo = hnv.O000000o(home, category, list);
            }
        } else if (obj instanceof Room) {
            Room room = (Room) obj;
            this.O00000oO = hnv.O000000o(home, room, list2);
            this.O000O0Oo = hnv.O000000o(home, room, arrayList2);
            this.O00000oo = hnv.O000000o(home, room, list);
        } else {
            List<Room> list3 = (List) obj;
            if (list3 != null) {
                for (Room room2 : list3) {
                    this.O00000oO.addAll(hnv.O000000o(home, room2, list2));
                    this.O000O0Oo.addAll(hnv.O000000o(home, room2, arrayList2));
                    this.O00000oo.addAll(hnv.O000000o(home, room2, list));
                }
            }
        }
        if (this.O00000oo.size() > 0) {
            arrayList.add(new Pair(this.O000OOo, this.O00000oo));
            z = true;
        } else {
            z = false;
        }
        if (this.O00000oO.size() > 0) {
            arrayList.add(new Pair(this.O000OOoO, this.O00000oO));
            z = true;
        }
        if (this.O000O0Oo.size() > 0) {
            arrayList.add(new Pair(this.O000OOoo, this.O000O0Oo));
            z = true;
        }
        arrayList.add(0, new Pair(this.O000OOOo, new ArrayList()));
        if (!z) {
            arrayList.add(1, new Pair(this.O000OOo0, new ArrayList()));
        }
        this.O00000o = arrayList;
        O00000o();
        this.O0000Ooo.notifyDataSetChanged();
        for (int i2 = 0; i2 < this.O00000o.size(); i2++) {
            if (!this.O0000o00.O00000Oo(i2)) {
                this.O0000o00.O000000o(i2);
            }
        }
        if (!TextUtils.isEmpty(hpu.O000000o().O00000o)) {
            this.O0000o0 = hpu.O000000o().O00000o;
            hpu.O000000o().O00000o = null;
            if (hpr.O00000o0().O000000o(this.O0000o0) != null) {
                O000000o(true);
            } else {
                O000000o(false);
            }
        }
    }
}
