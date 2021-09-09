package com.xiaomi.smarthome.scene.activity;

import _m_j.axs;
import _m_j.axx;
import _m_j.axy;
import _m_j.axz;
import _m_j.aya;
import _m_j.eys;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.fvm;
import _m_j.ggb;
import _m_j.gof;
import _m_j.gpc;
import _m_j.gqd;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.hni;
import _m_j.hnj;
import _m_j.hnw;
import _m_j.hny;
import _m_j.hob;
import _m_j.hod;
import _m_j.hpn;
import _m_j.hpp;
import _m_j.hpq;
import _m_j.hpr;
import _m_j.hpu;
import _m_j.hzf;
import _m_j.izb;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
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
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.AnimateLinearLayout;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MyDeviceSceneFragmentNew extends fvm implements RecyclerViewExpandableItemManager.O000000o, RecyclerViewExpandableItemManager.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    View f10742O000000o;
    List<Pair<O000000o, List<SceneApi.O000OOOo>>> O00000Oo = new ArrayList();
    RecyclerView.O000000o<SceneChildViewHolder> O00000o;
    List<SceneApi.O000OOOo> O00000o0 = new ArrayList();
    public int O00000oO = 0;
    hnj O00000oo;
    O00000o0 O0000O0o;
    RecyclerViewExpandableItemManager O0000OOo;
    LinearLayoutManager O0000Oo = null;
    public String O0000Oo0;
    List<Room> O0000OoO = new ArrayList();
    public Room O0000Ooo;
    public Button O0000o;
    public boolean O0000o0 = false;
    LayoutInflater O0000o00;
    public ImageView O0000o0O;
    public ImageView O0000o0o;
    public Button O0000oO;
    public Button O0000oO0;
    public Button O0000oOO;
    public TextView O0000oOo;
    public boolean O0000oo = false;
    public HashMap<String, Boolean> O0000oo0 = new HashMap<>();
    ArrayList<SceneApi.O000OOOo> O0000ooO = new ArrayList<>();
    private boolean O0000ooo = true;
    private boolean O000O00o = true;
    private axx O000O0OO;
    private boolean O000O0Oo = false;
    private O000000o O000O0o;
    private O000000o O000O0o0;
    private BroadcastReceiver O000O0oO = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass20 */

        public final void onReceive(Context context, Intent intent) {
            gsy.O00000Oo("MySceneFragment", intent.getAction());
            if ("action_on_login_success".equals(intent.getAction())) {
                hni.O000000o().O00000o0();
            } else if ("action_on_logout".equals(intent.getAction())) {
                hni.O000000o().O00000Oo();
            }
        }
    };
    private hni.O000000o O000O0oo = new hni.O000000o() {
        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass21 */

        public final void O000000o(List<SceneApi.O000OOOo> list) {
            if (MyDeviceSceneFragmentNew.this.mPullRefreshLL != null && !MyDeviceSceneFragmentNew.this.mPullRefreshLL.isRefreshing()) {
                List list2 = null;
                if (MyDeviceSceneFragmentNew.this.O00000Oo != null) {
                    int i = 0;
                    while (true) {
                        if (i >= MyDeviceSceneFragmentNew.this.O00000Oo.size()) {
                            break;
                        } else if (((O000000o) MyDeviceSceneFragmentNew.this.O00000Oo.get(i).first).O00000Oo == 15) {
                            list2 = (List) MyDeviceSceneFragmentNew.this.O00000Oo.get(i).second;
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
                                ((SceneApi.O000OOOo) list2.get(i3)).O0000Oo0 = list.get(i2).O0000Oo0;
                                hod.O0000OoO().O000000o(((SceneApi.O000OOOo) list2.get(i3)).f11131O000000o, (SceneApi.O000OOOo) list2.get(i3));
                            }
                        }
                    }
                    MyDeviceSceneFragmentNew.this.O0000O0o.notifyDataSetChanged();
                }
            }
        }
    };
    private hny O00oOoOo = new hny() {
        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass19 */

        public final void onRefreshScenceSuccess(int i) {
            if (MyDeviceSceneFragmentNew.this.isValid() && i == 5) {
                MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                myDeviceSceneFragmentNew.O000000o(myDeviceSceneFragmentNew.O0000Ooo);
                MyDeviceSceneFragmentNew.this.O00000Oo();
                if (MyDeviceSceneFragmentNew.this.mPullRefreshLL != null) {
                    MyDeviceSceneFragmentNew.this.mPullRefreshLL.refreshComplete();
                }
            }
        }

        public final void onRefreshScenceFailed(int i) {
            if (MyDeviceSceneFragmentNew.this.isValid()) {
                MyDeviceSceneFragmentNew.this.mPullRefreshLL.refreshComplete();
                MyDeviceSceneFragmentNew.this.O00000Oo();
            }
        }
    };
    private boolean O00oOooO = false;
    private boolean O00oOooo = false;
    @BindView(5270)
    TextView mEmptyTV;
    @BindView(5272)
    View mEmptyView;
    @BindView(5991)
    View mPlaceHolderView;
    @BindView(6025)
    PtrFrameLayout mPullRefreshLL;
    @BindView(6155)
    RecyclerView mSceneViewRV;

    public class SceneChildViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private SceneChildViewHolder f10784O000000o;

        public SceneChildViewHolder_ViewBinding(SceneChildViewHolder sceneChildViewHolder, View view) {
            this.f10784O000000o = sceneChildViewHolder;
            sceneChildViewHolder.mDivideLine = Utils.findRequiredView(view, R.id.divide_line, "field 'mDivideLine'");
            sceneChildViewHolder.mDivideLineBottom = Utils.findRequiredView(view, R.id.divide_line_bottom, "field 'mDivideLineBottom'");
        }

        public void unbind() {
            SceneChildViewHolder sceneChildViewHolder = this.f10784O000000o;
            if (sceneChildViewHolder != null) {
                this.f10784O000000o = null;
                sceneChildViewHolder.mDivideLine = null;
                sceneChildViewHolder.mDivideLineBottom = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class AutoSceneViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private AutoSceneViewHolder f10773O000000o;

        public AutoSceneViewHolder_ViewBinding(AutoSceneViewHolder autoSceneViewHolder, View view) {
            this.f10773O000000o = autoSceneViewHolder;
            autoSceneViewHolder.actionLL = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.action_ll, "field 'actionLL'", LinearLayout.class);
            autoSceneViewHolder.mIconCondition = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.icon_condition, "field 'mIconCondition'", SimpleDraweeView.class);
            autoSceneViewHolder.mIconConditionMore = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon_condition_more, "field 'mIconConditionMore'", ImageView.class);
            autoSceneViewHolder.tvSceneName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_scene_name, "field 'tvSceneName'", TextView.class);
            autoSceneViewHolder.mCheckBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ckb_edit_selected, "field 'mCheckBox'", CheckBox.class);
            autoSceneViewHolder.mRightView = (ImageView) Utils.findRequiredViewAsType(view, R.id.right_view, "field 'mRightView'", ImageView.class);
            autoSceneViewHolder.mOpenCheck = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.open_check, "field 'mOpenCheck'", SwitchButton.class);
            autoSceneViewHolder.mMoreIcon = Utils.findRequiredView(view, R.id.scene_new_more_icon, "field 'mMoreIcon'");
            autoSceneViewHolder.mNewTagTV = (TextView) Utils.findRequiredViewAsType(view, R.id.new_tag, "field 'mNewTagTV'", TextView.class);
            autoSceneViewHolder.mDivideLine = Utils.findRequiredView(view, R.id.divide_line, "field 'mDivideLine'");
            autoSceneViewHolder.mDivideLineBottom = Utils.findRequiredView(view, R.id.divide_line_bottom, "field 'mDivideLineBottom'");
            autoSceneViewHolder.mExecuteTV = (TextView) Utils.findRequiredViewAsType(view, R.id.execute_tv, "field 'mExecuteTV'", TextView.class);
        }

        public void unbind() {
            AutoSceneViewHolder autoSceneViewHolder = this.f10773O000000o;
            if (autoSceneViewHolder != null) {
                this.f10773O000000o = null;
                autoSceneViewHolder.actionLL = null;
                autoSceneViewHolder.mIconCondition = null;
                autoSceneViewHolder.mIconConditionMore = null;
                autoSceneViewHolder.tvSceneName = null;
                autoSceneViewHolder.mCheckBox = null;
                autoSceneViewHolder.mRightView = null;
                autoSceneViewHolder.mOpenCheck = null;
                autoSceneViewHolder.mMoreIcon = null;
                autoSceneViewHolder.mNewTagTV = null;
                autoSceneViewHolder.mDivideLine = null;
                autoSceneViewHolder.mDivideLineBottom = null;
                autoSceneViewHolder.mExecuteTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f10774O000000o;
        public int O00000Oo;

        public O000000o(String str, int i) {
            this.f10774O000000o = str;
            this.O00000Oo = i;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        gsy.O000000o(LogType.SCENE, "scene", "MySceneFragment  onCreateView");
        if (this.f10742O000000o == null) {
            this.f10742O000000o = layoutInflater.inflate((int) R.layout.fragment_my_device_scene_layout_new, (ViewGroup) null);
            ButterKnife.bind(this, this.f10742O000000o);
            this.O0000o00 = LayoutInflater.from(getActivity());
            this.mContext = getActivity();
            this.O000O0o0 = new O000000o(getResources().getString(R.string.smarthome_new_scene_by_hand), 30);
            this.O000O0o = new O000000o(getResources().getString(R.string.smarthome_new_scene_auto), 15);
            this.mEmptyTV.setText((int) R.string.my_scene_no_data);
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.f10742O000000o.findViewById(R.id.title_bar_choose_device));
            this.O0000Oo = new LinearLayoutManager(this.mContext);
            this.O000O0OO = new axx();
            axx axx = this.O000O0OO;
            axx.O0000OOo = true;
            axx.O00000Oo();
            this.O0000OOo = new RecyclerViewExpandableItemManager();
            this.O0000OOo.O000000o((RecyclerViewExpandableItemManager.O000000o) this);
            this.O0000OOo.O000000o((RecyclerViewExpandableItemManager.O00000Oo) this);
            this.O0000O0o = new O00000o0();
            this.O00000o = this.O0000OOo.O000000o(this.O0000O0o);
            this.mSceneViewRV.setLayoutManager(this.O0000Oo);
            this.mSceneViewRV.setAdapter(this.O00000o);
            this.O000O0OO.O000000o(this.mSceneViewRV);
            this.O0000OOo.O000000o(this.mSceneViewRV);
            this.O0000OOo.O000000o();
            this.mPullRefreshLL.setPtrHandler(new PtrHandler() {
                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass12 */

                public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                    if (Build.VERSION.SDK_INT < 14) {
                        if (view instanceof AbsListView) {
                            AbsListView absListView = (AbsListView) view;
                            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
                        } else if (!(view instanceof RecyclerView)) {
                            return view.getScrollY() > 0;
                        } else {
                            LinearLayoutManager linearLayoutManager = MyDeviceSceneFragmentNew.this.O0000Oo;
                            return linearLayoutManager != null && linearLayoutManager.findFirstCompletelyVisibleItemPosition() - 1 < 0;
                        }
                    } else if (!(view instanceof RecyclerView)) {
                        return view.canScrollVertically(-1);
                    } else {
                        LinearLayoutManager linearLayoutManager2 = MyDeviceSceneFragmentNew.this.O0000Oo;
                        return linearLayoutManager2 != null && linearLayoutManager2.findFirstCompletelyVisibleItemPosition() - 1 < 0;
                    }
                }

                public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                    if (MyDeviceSceneFragmentNew.this.O00000oO == 1) {
                        MyDeviceSceneFragmentNew.this.mPullRefreshLL.refreshComplete();
                    } else if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                        MyDeviceSceneFragmentNew.this.mPullRefreshLL.refreshComplete();
                        MyDeviceSceneFragmentNew.this.O00000Oo();
                    } else if (!TextUtils.isEmpty(MyDeviceSceneFragmentNew.this.O0000Oo0)) {
                        MyDeviceSceneFragmentNew.this.O000000o();
                    } else {
                        MyDeviceSceneFragmentNew.this.O00000Oo();
                    }
                }
            });
            this.mEmptyView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass18 */

                public final void onClick(View view) {
                    if (MyDeviceSceneFragmentNew.this.mPullRefreshLL != null) {
                        MyDeviceSceneFragmentNew.this.mPullRefreshLL.autoRefresh();
                    }
                }
            });
            if (getArguments() != null && getArguments().containsKey("device_id")) {
                this.O0000Oo0 = getArguments().getString("device_id");
            }
            if (this.mPullRefreshLL != null) {
                if (!TextUtils.isEmpty(this.O0000Oo0)) {
                    ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass1 */

                        public final void run() {
                            MyDeviceSceneFragmentNew.this.mPullRefreshLL.autoRefresh();
                        }
                    }, 300);
                } else {
                    O00000Oo();
                }
            }
        }
        return this.f10742O000000o;
    }

    public void onViewCreated(View view, Bundle bundle) {
        gsy.O000000o(LogType.SCENE, "scene", "MySceneFragment  onViewCreated");
        super.onViewCreated(view, bundle);
        hpr.O00000o0().O00000Oo();
    }

    public final void O000000o() {
        this.O00oOooO = false;
        this.O00oOooo = false;
        hod.O0000OoO().O000000o(this.O00oOoOo);
        hod.O0000OoO().O00000o0();
    }

    public final void O000000o(Room room) {
        boolean z;
        boolean z2;
        this.O0000Ooo = room;
        List<SceneApi.O000OOOo> O000000o2 = hod.O0000OoO().O000000o(this.O0000Oo0);
        this.O0000ooO.clear();
        if (room == null) {
            this.O0000ooO.addAll(O000000o2);
        } else if (room.getId().equalsIgnoreCase("ALL_ROOM")) {
            this.O0000ooO.addAll(O000000o2);
        } else if (room.getId().equalsIgnoreCase("DEFAULT_ROOM")) {
            List<Device> O0000O0o2 = ggb.O00000Oo().O0000O0o();
            for (int i = 0; i < O000000o2.size(); i++) {
                SceneApi.O000OOOo o000OOOo = O000000o2.get(i);
                int i2 = 0;
                while (true) {
                    if (i2 >= o000OOOo.O0000O0o.size()) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= o000OOOo.O00000oo.size()) {
                                z2 = false;
                                break;
                            }
                            SceneApi.Action action = o000OOOo.O00000oo.get(i3);
                            if (action.O0000O0o instanceof SceneApi.O000OO0o) {
                                for (int i4 = 0; i4 < O0000O0o2.size(); i4++) {
                                    if (O0000O0o2.get(i4).did.equalsIgnoreCase(action.O0000O0o.O00000o)) {
                                        break;
                                    }
                                }
                                continue;
                            }
                            i3++;
                        }
                    } else {
                        SceneApi.O000000o o000000o = o000OOOo.O0000O0o.get(i2);
                        if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
                            for (int i5 = 0; i5 < O0000O0o2.size(); i5++) {
                                if (O0000O0o2.get(i5).did.equalsIgnoreCase(o000000o.O00000o0.f11122O000000o)) {
                                    break;
                                }
                            }
                            continue;
                        }
                        i2++;
                    }
                }
                z2 = true;
                if (z2) {
                    this.O0000ooO.add(o000OOOo);
                }
            }
        } else {
            List<String> dids = room.getDids();
            for (int i6 = 0; i6 < O000000o2.size(); i6++) {
                SceneApi.O000OOOo o000OOOo2 = O000000o2.get(i6);
                int i7 = 0;
                while (true) {
                    if (i7 >= o000OOOo2.O0000O0o.size()) {
                        int i8 = 0;
                        while (true) {
                            if (i8 >= o000OOOo2.O00000oo.size()) {
                                z = false;
                                break;
                            }
                            SceneApi.Action action2 = o000OOOo2.O00000oo.get(i8);
                            if (action2.O0000O0o instanceof SceneApi.O000OO0o) {
                                for (int i9 = 0; i9 < dids.size(); i9++) {
                                    if (dids.get(i9).equalsIgnoreCase(action2.O0000O0o.O00000o)) {
                                        break;
                                    }
                                }
                                continue;
                            }
                            i8++;
                        }
                    } else {
                        SceneApi.O000000o o000000o2 = o000OOOo2.O0000O0o.get(i7);
                        if (o000000o2.f11121O000000o == LAUNCH_TYPE.DEVICE) {
                            for (int i10 = 0; i10 < dids.size(); i10++) {
                                if (dids.get(i10).equalsIgnoreCase(o000000o2.O00000o0.f11122O000000o)) {
                                    break;
                                }
                            }
                            continue;
                        }
                        i7++;
                    }
                }
                z = true;
                if (z) {
                    this.O0000ooO.add(o000OOOo2);
                }
            }
        }
        ArrayList<SceneApi.O000OOOo> arrayList = this.O0000ooO;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (this.O0000ooO.get(size).O0000O0o != null && this.O0000ooO.get(size).O0000O0o.size() > 0 && this.O0000ooO.get(size).O0000O0o.get(0).f11121O000000o == LAUNCH_TYPE.NFC) {
                    this.O0000ooO.remove(size);
                }
            }
        }
        this.O00000Oo.clear();
        if (this.O00000o0.size() > 0) {
            this.O00000Oo.add(new Pair(this.O000O0o0, this.O00000o0));
        }
        if (this.O0000ooO.size() > 0) {
            this.O00000Oo.add(new Pair(this.O000O0o, this.O0000ooO));
        }
        gsy.O00000Oo("MySceneFragment", "mScenes.size" + this.O00000Oo.size());
        this.O0000O0o.notifyDataSetChanged();
        for (int i11 = 0; i11 < this.O00000Oo.size(); i11++) {
            if (!this.O0000OOo.O00000Oo(i11)) {
                this.O0000OOo.O000000o(i11);
            }
        }
    }

    public void onResume() {
        super.onResume();
        gsy.O00000Oo("MySceneFragment", "onresume");
        if (this.O0000ooo) {
            this.O0000ooo = false;
        } else {
            O000000o();
        }
    }

    public void onPause() {
        super.onPause();
        gsy.O00000Oo("MySceneFragment", "onPause");
        hpu.O000000o().O00000o = null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gsy.O00000Oo("MySceneFragment", "onCreate");
        IntentFilter intentFilter = new IntentFilter("action_on_login_success");
        intentFilter.addAction("action_on_logout");
        ft.O000000o(getContext()).O000000o(this.O000O0oO, intentFilter);
        hni.O000000o().O000000o(this.O000O0oo);
        hni.O000000o().O00000o0();
    }

    public void onDestroy() {
        super.onDestroy();
        hni.O000000o().O00000Oo(this.O000O0oo);
        hni.O000000o().O00000Oo();
        ft.O000000o(getContext()).O000000o(this.O000O0oO);
        hod.O0000OoO().O00000o0(this.O00oOoOo);
    }

    public final void O00000Oo() {
        if (this.O00000Oo.size() == 0) {
            this.mPullRefreshLL.setPullToRefresh(false);
            this.mEmptyView.setVisibility(0);
            this.mSceneViewRV.setVisibility(8);
            return;
        }
        this.mSceneViewRV.setVisibility(0);
        this.mPullRefreshLL.setPullToRefresh(true);
        this.mEmptyView.setVisibility(8);
    }

    class AutoSceneViewHolder extends axy implements axs {
        private int O00000Oo;
        @BindView(5051)
        LinearLayout actionLL;
        @BindView(5239)
        CheckBox mCheckBox;
        @BindView(5375)
        View mDivideLine;
        @BindView(5376)
        View mDivideLineBottom;
        @BindView(5453)
        TextView mExecuteTV;
        @BindView(5588)
        SimpleDraweeView mIconCondition;
        @BindView(5589)
        ImageView mIconConditionMore;
        @BindView(6152)
        View mMoreIcon;
        @BindView(5892)
        TextView mNewTagTV;
        @BindView(5925)
        SwitchButton mOpenCheck;
        @BindView(6098)
        ImageView mRightView;
        @BindView(6485)
        TextView tvSceneName;

        public AutoSceneViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setExpandStateFlags(int i) {
            this.O00000Oo = i;
        }

        public int getExpandStateFlags() {
            return this.O00000Oo;
        }
    }

    class O00000Oo extends axy implements axs {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f10775O000000o;
        View O00000Oo;
        private int O00000o;

        public O00000Oo(View view) {
            super(view);
            this.f10775O000000o = (TextView) view.findViewById(R.id.group_tv);
            this.O00000Oo = view.findViewById(R.id.divide_line);
        }

        public final void setExpandStateFlags(int i) {
            this.O00000o = i;
        }

        public final int getExpandStateFlags() {
            return this.O00000o;
        }
    }

    class O00000o0 extends aya<O00000Oo, AutoSceneViewHolder> {
        public final long getChildId(int i, int i2) {
            return (long) i2;
        }

        public final long getGroupId(int i) {
            return (long) i;
        }

        public final /* bridge */ /* synthetic */ boolean onCheckCanExpandOrCollapseGroup(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, boolean z) {
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00f0  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0110  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0119  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0124  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x01c1  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0217  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x021d  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0229  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0234  */
        public final /* synthetic */ void onBindChildViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, final int i2, int i3) {
            final AutoSceneViewHolder autoSceneViewHolder = (AutoSceneViewHolder) o000OOo0;
            final SceneApi.O000OOOo o000OOOo = (SceneApi.O000OOOo) ((List) MyDeviceSceneFragmentNew.this.O00000Oo.get(i).second).get(i2);
            if (!(o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() == 0)) {
                hod.O0000OoO();
                if (!hod.O00000oO(o000OOOo)) {
                    autoSceneViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O00000o0.AnonymousClass2 */

                        public final void onClick(View view) {
                            if (MyDeviceSceneFragmentNew.this.O0000o0) {
                                autoSceneViewHolder.mCheckBox.setChecked(!autoSceneViewHolder.mCheckBox.isChecked());
                            } else {
                                izb.O000000o(MyDeviceSceneFragmentNew.this.getActivity(), (int) R.string.cannot_edit_ios_scene, 0).show();
                            }
                        }
                    });
                    autoSceneViewHolder.tvSceneName.setTextColor(MyDeviceSceneFragmentNew.this.getResources().getColor(R.color.mj_color_black_40_transparent));
                    if (o000OOOo.O0000O0o.size() <= 0) {
                        autoSceneViewHolder.mIconCondition.setVisibility(0);
                        autoSceneViewHolder.mIconCondition.setHierarchy(new GenericDraweeHierarchyBuilder(autoSceneViewHolder.mIconCondition.getResources()).setFadeDuration(200).setPlaceholderImage(autoSceneViewHolder.mIconCondition.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
                        if (o000OOOo == null || o000OOOo.O0000O0o.size() <= 0) {
                            autoSceneViewHolder.mIconCondition.setImageURI(gqd.O000000o((int) R.drawable.intelligence_icon_default_nor));
                        } else {
                            hnw.O000000o(autoSceneViewHolder.mIconCondition, o000OOOo.O0000O0o.get(0));
                        }
                        if (o000OOOo.O0000O0o.size() > 1) {
                            autoSceneViewHolder.mIconConditionMore.setVisibility(0);
                        } else {
                            autoSceneViewHolder.mIconConditionMore.setVisibility(8);
                        }
                        autoSceneViewHolder.mIconConditionMore.setImageResource(hnw.O00000o0(o000OOOo.O0000Ooo));
                    } else {
                        autoSceneViewHolder.mIconCondition.setVisibility(8);
                        autoSceneViewHolder.mIconConditionMore.setVisibility(8);
                    }
                    hnw.O000000o(o000OOOo, autoSceneViewHolder.actionLL);
                    autoSceneViewHolder.mMoreIcon.setVisibility(8);
                    autoSceneViewHolder.tvSceneName.setText(o000OOOo.O00000Oo);
                    if (o000OOOo.O0000o0o == 0) {
                        autoSceneViewHolder.mRightView.setImageResource(R.drawable.exclamation_mark);
                    } else {
                        autoSceneViewHolder.mRightView.setVisibility(4);
                    }
                    if (!MyDeviceSceneFragmentNew.this.O0000o0) {
                        autoSceneViewHolder.mCheckBox.setVisibility(0);
                        autoSceneViewHolder.mRightView.setVisibility(4);
                        autoSceneViewHolder.mOpenCheck.setVisibility(4);
                        autoSceneViewHolder.mCheckBox.setOnCheckedChangeListener(null);
                        autoSceneViewHolder.mExecuteTV.setVisibility(8);
                        gsy.O00000Oo("MySceneFragment", "mEditModeMap.containsKey(scene.id)" + MyDeviceSceneFragmentNew.this.O0000oo0.containsKey(o000OOOo.f11131O000000o) + "  mEditModeMap.get(scene.id) " + MyDeviceSceneFragmentNew.this.O0000oo0.get(o000OOOo.f11131O000000o) + " mEditModeMap.size " + MyDeviceSceneFragmentNew.this.O0000oo0.size() + " mEditModeMap.values " + MyDeviceSceneFragmentNew.this.O0000oo0.values());
                        if (!MyDeviceSceneFragmentNew.this.O0000oo0.containsKey(o000OOOo.f11131O000000o) || !MyDeviceSceneFragmentNew.this.O0000oo0.get(o000OOOo.f11131O000000o).booleanValue()) {
                            autoSceneViewHolder.mCheckBox.setChecked(false);
                        } else {
                            autoSceneViewHolder.mCheckBox.setChecked(true);
                        }
                        autoSceneViewHolder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O00000o0.AnonymousClass3 */

                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                gsy.O00000Oo("MySceneFragment", "onCheckedChanged  scene.mIsLite " + o000OOOo.O0000oO0 + "  childPosition " + i2 + "  isChecked  " + z);
                                if (o000OOOo.O0000oO0) {
                                    MyDeviceSceneFragmentNew.this.O000000o(i2, z, 30);
                                } else {
                                    MyDeviceSceneFragmentNew.this.O000000o(i2, z, 15);
                                }
                            }
                        });
                    } else {
                        autoSceneViewHolder.mCheckBox.setVisibility(8);
                        autoSceneViewHolder.mRightView.setVisibility(8);
                        if (o000OOOo.O0000oO0) {
                            autoSceneViewHolder.mExecuteTV.setVisibility(0);
                            autoSceneViewHolder.mOpenCheck.setVisibility(8);
                        } else {
                            autoSceneViewHolder.mExecuteTV.setVisibility(8);
                            autoSceneViewHolder.mOpenCheck.setVisibility(0);
                        }
                    }
                    autoSceneViewHolder.mOpenCheck.setChecked(o000OOOo.O0000Oo0);
                    autoSceneViewHolder.mOpenCheck.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O00000o0.AnonymousClass4 */

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
                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            Device O00000o02;
                            String str;
                            Device O00000o03;
                            String str2;
                            if (!gof.O00000o0()) {
                                izb.O000000o(MyDeviceSceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_set_fail, 0).show();
                                autoSceneViewHolder.mOpenCheck.setChecked(o000OOOo.O0000Oo0);
                                return;
                            }
                            SceneApi.O000OOOo o000OOOo = o000OOOo;
                            o000OOOo.O0000Oo0 = z;
                            if (!TextUtils.isEmpty(o000OOOo.f11131O000000o) && eys.f15955O000000o) {
                                MyDeviceSceneFragmentNew.this.O0000oo = true;
                                MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                                SceneApi.O000OOOo o000OOOo2 = o000OOOo;
                                if (!gof.O00000o0()) {
                                    gqg.O00000Oo((int) R.string.network_fake_connected);
                                } else {
                                    String str3 = null;
                                    boolean z2 = false;
                                    for (SceneApi.O000000o next : o000OOOo2.O0000O0o) {
                                        if (!(next.O00000o0 == null || next.O00000o0.O00000o == null || (O00000o03 = fno.O000000o().O00000o0(next.O00000o0.f11122O000000o)) == null)) {
                                            if (O00000o03.isSubDevice()) {
                                                str2 = O00000o03.parentId;
                                            } else {
                                                str2 = O00000o03.did;
                                            }
                                            if (hnw.O000000o(fno.O000000o().O00000o0(str2))) {
                                                str3 = str2;
                                                z2 = true;
                                            }
                                        }
                                    }
                                    if (!z2) {
                                        for (SceneApi.Action next2 : o000OOOo2.O00000oo) {
                                            if (!(next2.O00000oO == null || next2.O0000O0o.O00000o == null || (O00000o02 = fno.O000000o().O00000o0(next2.O0000O0o.O00000o)) == null)) {
                                                if (O00000o02.isSubDevice()) {
                                                    str = O00000o02.parentId;
                                                } else {
                                                    str = O00000o02.did;
                                                }
                                                if (hnw.O000000o(fno.O000000o().O00000o0(str))) {
                                                    str3 = str;
                                                    z2 = true;
                                                }
                                            }
                                        }
                                    }
                                    if (!z2 || str3 == null) {
                                        myDeviceSceneFragmentNew.O000000o(o000OOOo2, (String) null);
                                    } else {
                                        Device O00000o04 = fno.O000000o().O00000o0(str3);
                                        if (O00000o04 == null || O00000o04.isOnline) {
                                            SceneApi.O000000o(o000OOOo2);
                                            hpp.O000000o().O000000o(hod.O00000o(o000OOOo2), new Callback<SceneInfo>(o000OOOo2, O00000o04) {
                                                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass13 */

                                                /* renamed from: O000000o  reason: collision with root package name */
                                                final /* synthetic */ SceneApi.O000OOOo f10747O000000o;
                                                final /* synthetic */ Device O00000Oo;

                                                {
                                                    this.f10747O000000o = r2;
                                                    this.O00000Oo = r3;
                                                }

                                                public final /* synthetic */ void onSuccess(Object obj) {
                                                    SceneInfo sceneInfo = (SceneInfo) obj;
                                                    if (sceneInfo != null) {
                                                        for (int i = 0; i < sceneInfo.mLaunchList.size(); i++) {
                                                            if (this.f10747O000000o.O0000O0o.get(i).O00000o0 != null && (this.f10747O000000o.O0000O0o.get(i).O00000o0 instanceof SceneApi.O00000o0)) {
                                                                ((SceneApi.O00000o0) this.f10747O000000o.O0000O0o.get(i).O00000o0).O0000o00 = sceneInfo.mLaunchList.get(i).mExtra;
                                                            }
                                                        }
                                                        for (int i2 = 0; i2 < sceneInfo.mActions.size(); i2++) {
                                                            if (this.f10747O000000o.O00000oo.get(i2).O0000O0o != null && (this.f10747O000000o.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000OO0o)) {
                                                                ((SceneApi.O000OO0o) this.f10747O000000o.O00000oo.get(i2).O0000O0o).f11130O000000o = sceneInfo.mActions.get(i2).mExtra;
                                                            }
                                                        }
                                                    }
                                                    MyDeviceSceneFragmentNew.this.O000000o(this.f10747O000000o, this.O00000Oo.did);
                                                }

                                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                                 method: com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                                                 arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                                                 candidates:
                                                  com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                                                  com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.util.List<java.lang.String>):void
                                                  com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                                                public final void onFailure(int i, String str) {
                                                    gsy.O000000o(6, "lumiscene", str);
                                                    MyDeviceSceneFragmentNew.this.O000000o(false, this.f10747O000000o);
                                                }
                                            });
                                        } else {
                                            if (myDeviceSceneFragmentNew.O0000oo) {
                                                myDeviceSceneFragmentNew.O0000oo = false;
                                                o000OOOo2.O0000Oo0 = true ^ o000OOOo2.O0000Oo0;
                                                if (myDeviceSceneFragmentNew.O0000O0o != null) {
                                                    myDeviceSceneFragmentNew.O0000O0o.notifyDataSetChanged();
                                                }
                                            }
                                            izb.O000000o(myDeviceSceneFragmentNew.getActivity(), (int) R.string.smarthome_scene_getway_offline, 0).show();
                                        }
                                    }
                                }
                            }
                            CoreApi.O000000o().O000000o(StatType.EVENT, "open_slip_button_click", "scene_all_activity", (String) null, false);
                        }
                    });
                    autoSceneViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O00000o0.AnonymousClass5 */

                        public final boolean onLongClick(View view) {
                            DeviceSceneActivityNew deviceSceneActivityNew;
                            if (!MyDeviceSceneFragmentNew.this.O0000o0) {
                                MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                                if (myDeviceSceneFragmentNew.O00000oO != 1) {
                                    myDeviceSceneFragmentNew.O00000oO = 1;
                                    myDeviceSceneFragmentNew.O0000o0 = true;
                                    myDeviceSceneFragmentNew.mPullRefreshLL.setPullToRefresh(false);
                                    if (!myDeviceSceneFragmentNew.getActivity().isFinishing() && (deviceSceneActivityNew = (DeviceSceneActivityNew) myDeviceSceneFragmentNew.getActivity()) != null && !deviceSceneActivityNew.isFinishing()) {
                                        try {
                                            View chooseSceneTitleBar = deviceSceneActivityNew.getChooseSceneTitleBar();
                                            AnimateLinearLayout animateLinearLayout = (AnimateLinearLayout) deviceSceneActivityNew.getChooseSceneMenuBar();
                                            myDeviceSceneFragmentNew.O0000oOo = (TextView) chooseSceneTitleBar.findViewById(R.id.module_a_4_return_more_title);
                                            myDeviceSceneFragmentNew.O0000o0O = (ImageView) chooseSceneTitleBar.findViewById(16908313);
                                            myDeviceSceneFragmentNew.O0000o0o = (ImageView) chooseSceneTitleBar.findViewById(16908314);
                                            myDeviceSceneFragmentNew.O0000o = (Button) animateLinearLayout.findViewById(R.id.btn_edit_rename);
                                            myDeviceSceneFragmentNew.O0000oO0 = (Button) animateLinearLayout.findViewById(R.id.btn_edit_delete);
                                            myDeviceSceneFragmentNew.O0000oO = (Button) animateLinearLayout.findViewById(R.id.btn_edit_sort);
                                            myDeviceSceneFragmentNew.O0000oO.setVisibility(8);
                                            myDeviceSceneFragmentNew.O0000oOO = (Button) animateLinearLayout.findViewById(R.id.btn_edit_add_toLauncher);
                                            myDeviceSceneFragmentNew.O0000oOO.setVisibility(8);
                                            myDeviceSceneFragmentNew.O0000o0O.setOnClickListener(new View.OnClickListener() {
                                                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass23 */

                                                public final void onClick(View view) {
                                                    MyDeviceSceneFragmentNew.this.O00000o0();
                                                }
                                            });
                                            myDeviceSceneFragmentNew.O0000o0o.setOnClickListener(new View.OnClickListener() {
                                                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass24 */

                                                public final void onClick(View view) {
                                                    gsy.O00000Oo("MySceneFragment", "getCheckedCount()" + MyDeviceSceneFragmentNew.this.O00000o() + "    mCustomScenes.size()" + MyDeviceSceneFragmentNew.this.O0000ooO.size());
                                                    boolean z = MyDeviceSceneFragmentNew.this.O00000o() < MyDeviceSceneFragmentNew.this.O0000ooO.size() + MyDeviceSceneFragmentNew.this.O00000o0.size();
                                                    for (int i = 0; i < MyDeviceSceneFragmentNew.this.O0000ooO.size(); i++) {
                                                        MyDeviceSceneFragmentNew.this.O000000o(i, z, 15);
                                                    }
                                                    for (int i2 = 0; i2 < MyDeviceSceneFragmentNew.this.O00000o0.size(); i2++) {
                                                        MyDeviceSceneFragmentNew.this.O000000o(i2, z, 30);
                                                    }
                                                    MyDeviceSceneFragmentNew.this.O0000O0o.notifyDataSetChanged();
                                                }
                                            });
                                            chooseSceneTitleBar.setVisibility(0);
                                            animateLinearLayout.setVisibility(0);
                                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chooseSceneTitleBar, View.TRANSLATION_Y, -myDeviceSceneFragmentNew.getResources().getDimension(R.dimen.titlebar_height), 0.0f);
                                            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(animateLinearLayout, "translationY", (float) animateLinearLayout.getHeight(), 0.0f);
                                            AnimatorSet animatorSet = new AnimatorSet();
                                            animatorSet.setDuration(200L);
                                            animatorSet.play(ofFloat).with(ofFloat2);
                                            animatorSet.start();
                                            animateLinearLayout.O000000o(0, AnimateLinearLayout.O000000o(animateLinearLayout.getChildCount()));
                                            myDeviceSceneFragmentNew.O0000O0o.notifyDataSetChanged();
                                            if (!(myDeviceSceneFragmentNew.O00000oo == null || myDeviceSceneFragmentNew.O00000oo.O00000o == null)) {
                                                myDeviceSceneFragmentNew.O00000oo.O00000o.setSwipeEnabled(false);
                                            }
                                            if (myDeviceSceneFragmentNew.mPlaceHolderView != null && myDeviceSceneFragmentNew.mPlaceHolderView.getVisibility() == 8) {
                                                myDeviceSceneFragmentNew.mPlaceHolderView.setVisibility(0);
                                            }
                                            myDeviceSceneFragmentNew.mSceneViewRV.setPadding(0, 0, 0, gpc.O000000o(99.0f));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                if (o000OOOo.O0000oO0) {
                                    MyDeviceSceneFragmentNew.this.O000000o(i2, true, 30);
                                } else {
                                    MyDeviceSceneFragmentNew.this.O000000o(i2, true, 15);
                                }
                            }
                            return true;
                        }
                    });
                    autoSceneViewHolder.mExecuteTV.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O00000o0.AnonymousClass6 */

                        public final void onClick(View view) {
                            MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                            SceneApi.O000OOOo o000OOOo = o000OOOo;
                            hob.O000000o();
                            hob.O000000o(ServiceApplication.getAppContext(), o000OOOo.f11131O000000o, "click", new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass22 */

                                public final void onFailure(fso fso) {
                                    if (MyDeviceSceneFragmentNew.this.isValid()) {
                                        gqg.O00000Oo((int) R.string.execute_fail);
                                    }
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    if (MyDeviceSceneFragmentNew.this.isValid()) {
                                        gqg.O00000Oo((int) R.string.execute_success);
                                    }
                                }
                            });
                        }
                    });
                    if (!TextUtils.equals(hpu.O000000o().O00000o, o000OOOo.f11131O000000o)) {
                        autoSceneViewHolder.mNewTagTV.setVisibility(0);
                    } else {
                        autoSceneViewHolder.mNewTagTV.setVisibility(8);
                    }
                    if (i2 != getChildCount(i) - 1) {
                        autoSceneViewHolder.mDivideLine.setVisibility(8);
                        autoSceneViewHolder.mDivideLineBottom.setVisibility(0);
                        return;
                    }
                    autoSceneViewHolder.mDivideLine.setVisibility(0);
                    autoSceneViewHolder.mDivideLineBottom.setVisibility(8);
                    return;
                }
            }
            autoSceneViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O00000o0.AnonymousClass1 */

                public final void onClick(View view) {
                    if (MyDeviceSceneFragmentNew.this.O0000o0) {
                        autoSceneViewHolder.mCheckBox.setChecked(!autoSceneViewHolder.mCheckBox.isChecked());
                        return;
                    }
                    hod.O0000OoO();
                    if (!hod.O000000o(o000OOOo)) {
                        hod.O0000OoO();
                        if (!hod.O00000Oo(o000OOOo)) {
                            Intent intent = new Intent(MyDeviceSceneFragmentNew.this.getActivity(), SmarthomeCreateAutoSceneActivity.class);
                            intent.putExtra("extra_device_id", ((DeviceSceneActivityNew) MyDeviceSceneFragmentNew.this.getActivity()).O00000Oo);
                            hpq.O000000o().O000000o(o000OOOo);
                            MyDeviceSceneFragmentNew.this.startActivity(intent);
                            return;
                        }
                    }
                    Intent intent2 = new Intent(MyDeviceSceneFragmentNew.this.getActivity(), GoLeaveHomeSceneCreateEditActivity.class);
                    intent2.putExtra("scene_id", o000OOOo.f11131O000000o);
                    MyDeviceSceneFragmentNew.this.startActivity(intent2);
                }
            });
            autoSceneViewHolder.tvSceneName.setTextColor(MyDeviceSceneFragmentNew.this.getResources().getColor(R.color.mj_color_black_80_transparent));
            if (o000OOOo.O0000O0o.size() <= 0) {
            }
            hnw.O000000o(o000OOOo, autoSceneViewHolder.actionLL);
            autoSceneViewHolder.mMoreIcon.setVisibility(8);
            autoSceneViewHolder.tvSceneName.setText(o000OOOo.O00000Oo);
            if (o000OOOo.O0000o0o == 0) {
            }
            if (!MyDeviceSceneFragmentNew.this.O0000o0) {
            }
            autoSceneViewHolder.mOpenCheck.setChecked(o000OOOo.O0000Oo0);
            autoSceneViewHolder.mOpenCheck.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O00000o0.AnonymousClass4 */

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
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Device O00000o02;
                    String str;
                    Device O00000o03;
                    String str2;
                    if (!gof.O00000o0()) {
                        izb.O000000o(MyDeviceSceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_set_fail, 0).show();
                        autoSceneViewHolder.mOpenCheck.setChecked(o000OOOo.O0000Oo0);
                        return;
                    }
                    SceneApi.O000OOOo o000OOOo = o000OOOo;
                    o000OOOo.O0000Oo0 = z;
                    if (!TextUtils.isEmpty(o000OOOo.f11131O000000o) && eys.f15955O000000o) {
                        MyDeviceSceneFragmentNew.this.O0000oo = true;
                        MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                        SceneApi.O000OOOo o000OOOo2 = o000OOOo;
                        if (!gof.O00000o0()) {
                            gqg.O00000Oo((int) R.string.network_fake_connected);
                        } else {
                            String str3 = null;
                            boolean z2 = false;
                            for (SceneApi.O000000o next : o000OOOo2.O0000O0o) {
                                if (!(next.O00000o0 == null || next.O00000o0.O00000o == null || (O00000o03 = fno.O000000o().O00000o0(next.O00000o0.f11122O000000o)) == null)) {
                                    if (O00000o03.isSubDevice()) {
                                        str2 = O00000o03.parentId;
                                    } else {
                                        str2 = O00000o03.did;
                                    }
                                    if (hnw.O000000o(fno.O000000o().O00000o0(str2))) {
                                        str3 = str2;
                                        z2 = true;
                                    }
                                }
                            }
                            if (!z2) {
                                for (SceneApi.Action next2 : o000OOOo2.O00000oo) {
                                    if (!(next2.O00000oO == null || next2.O0000O0o.O00000o == null || (O00000o02 = fno.O000000o().O00000o0(next2.O0000O0o.O00000o)) == null)) {
                                        if (O00000o02.isSubDevice()) {
                                            str = O00000o02.parentId;
                                        } else {
                                            str = O00000o02.did;
                                        }
                                        if (hnw.O000000o(fno.O000000o().O00000o0(str))) {
                                            str3 = str;
                                            z2 = true;
                                        }
                                    }
                                }
                            }
                            if (!z2 || str3 == null) {
                                myDeviceSceneFragmentNew.O000000o(o000OOOo2, (String) null);
                            } else {
                                Device O00000o04 = fno.O000000o().O00000o0(str3);
                                if (O00000o04 == null || O00000o04.isOnline) {
                                    SceneApi.O000000o(o000OOOo2);
                                    hpp.O000000o().O000000o(hod.O00000o(o000OOOo2), new Callback<SceneInfo>(o000OOOo2, O00000o04) {
                                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass13 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ SceneApi.O000OOOo f10747O000000o;
                                        final /* synthetic */ Device O00000Oo;

                                        {
                                            this.f10747O000000o = r2;
                                            this.O00000Oo = r3;
                                        }

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            SceneInfo sceneInfo = (SceneInfo) obj;
                                            if (sceneInfo != null) {
                                                for (int i = 0; i < sceneInfo.mLaunchList.size(); i++) {
                                                    if (this.f10747O000000o.O0000O0o.get(i).O00000o0 != null && (this.f10747O000000o.O0000O0o.get(i).O00000o0 instanceof SceneApi.O00000o0)) {
                                                        ((SceneApi.O00000o0) this.f10747O000000o.O0000O0o.get(i).O00000o0).O0000o00 = sceneInfo.mLaunchList.get(i).mExtra;
                                                    }
                                                }
                                                for (int i2 = 0; i2 < sceneInfo.mActions.size(); i2++) {
                                                    if (this.f10747O000000o.O00000oo.get(i2).O0000O0o != null && (this.f10747O000000o.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000OO0o)) {
                                                        ((SceneApi.O000OO0o) this.f10747O000000o.O00000oo.get(i2).O0000O0o).f11130O000000o = sceneInfo.mActions.get(i2).mExtra;
                                                    }
                                                }
                                            }
                                            MyDeviceSceneFragmentNew.this.O000000o(this.f10747O000000o, this.O00000Oo.did);
                                        }

                                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                         method: com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                                         arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                                         candidates:
                                          com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                                          com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.util.List<java.lang.String>):void
                                          com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                                        public final void onFailure(int i, String str) {
                                            gsy.O000000o(6, "lumiscene", str);
                                            MyDeviceSceneFragmentNew.this.O000000o(false, this.f10747O000000o);
                                        }
                                    });
                                } else {
                                    if (myDeviceSceneFragmentNew.O0000oo) {
                                        myDeviceSceneFragmentNew.O0000oo = false;
                                        o000OOOo2.O0000Oo0 = true ^ o000OOOo2.O0000Oo0;
                                        if (myDeviceSceneFragmentNew.O0000O0o != null) {
                                            myDeviceSceneFragmentNew.O0000O0o.notifyDataSetChanged();
                                        }
                                    }
                                    izb.O000000o(myDeviceSceneFragmentNew.getActivity(), (int) R.string.smarthome_scene_getway_offline, 0).show();
                                }
                            }
                        }
                    }
                    CoreApi.O000000o().O000000o(StatType.EVENT, "open_slip_button_click", "scene_all_activity", (String) null, false);
                }
            });
            autoSceneViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O00000o0.AnonymousClass5 */

                public final boolean onLongClick(View view) {
                    DeviceSceneActivityNew deviceSceneActivityNew;
                    if (!MyDeviceSceneFragmentNew.this.O0000o0) {
                        MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                        if (myDeviceSceneFragmentNew.O00000oO != 1) {
                            myDeviceSceneFragmentNew.O00000oO = 1;
                            myDeviceSceneFragmentNew.O0000o0 = true;
                            myDeviceSceneFragmentNew.mPullRefreshLL.setPullToRefresh(false);
                            if (!myDeviceSceneFragmentNew.getActivity().isFinishing() && (deviceSceneActivityNew = (DeviceSceneActivityNew) myDeviceSceneFragmentNew.getActivity()) != null && !deviceSceneActivityNew.isFinishing()) {
                                try {
                                    View chooseSceneTitleBar = deviceSceneActivityNew.getChooseSceneTitleBar();
                                    AnimateLinearLayout animateLinearLayout = (AnimateLinearLayout) deviceSceneActivityNew.getChooseSceneMenuBar();
                                    myDeviceSceneFragmentNew.O0000oOo = (TextView) chooseSceneTitleBar.findViewById(R.id.module_a_4_return_more_title);
                                    myDeviceSceneFragmentNew.O0000o0O = (ImageView) chooseSceneTitleBar.findViewById(16908313);
                                    myDeviceSceneFragmentNew.O0000o0o = (ImageView) chooseSceneTitleBar.findViewById(16908314);
                                    myDeviceSceneFragmentNew.O0000o = (Button) animateLinearLayout.findViewById(R.id.btn_edit_rename);
                                    myDeviceSceneFragmentNew.O0000oO0 = (Button) animateLinearLayout.findViewById(R.id.btn_edit_delete);
                                    myDeviceSceneFragmentNew.O0000oO = (Button) animateLinearLayout.findViewById(R.id.btn_edit_sort);
                                    myDeviceSceneFragmentNew.O0000oO.setVisibility(8);
                                    myDeviceSceneFragmentNew.O0000oOO = (Button) animateLinearLayout.findViewById(R.id.btn_edit_add_toLauncher);
                                    myDeviceSceneFragmentNew.O0000oOO.setVisibility(8);
                                    myDeviceSceneFragmentNew.O0000o0O.setOnClickListener(new View.OnClickListener() {
                                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass23 */

                                        public final void onClick(View view) {
                                            MyDeviceSceneFragmentNew.this.O00000o0();
                                        }
                                    });
                                    myDeviceSceneFragmentNew.O0000o0o.setOnClickListener(new View.OnClickListener() {
                                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass24 */

                                        public final void onClick(View view) {
                                            gsy.O00000Oo("MySceneFragment", "getCheckedCount()" + MyDeviceSceneFragmentNew.this.O00000o() + "    mCustomScenes.size()" + MyDeviceSceneFragmentNew.this.O0000ooO.size());
                                            boolean z = MyDeviceSceneFragmentNew.this.O00000o() < MyDeviceSceneFragmentNew.this.O0000ooO.size() + MyDeviceSceneFragmentNew.this.O00000o0.size();
                                            for (int i = 0; i < MyDeviceSceneFragmentNew.this.O0000ooO.size(); i++) {
                                                MyDeviceSceneFragmentNew.this.O000000o(i, z, 15);
                                            }
                                            for (int i2 = 0; i2 < MyDeviceSceneFragmentNew.this.O00000o0.size(); i2++) {
                                                MyDeviceSceneFragmentNew.this.O000000o(i2, z, 30);
                                            }
                                            MyDeviceSceneFragmentNew.this.O0000O0o.notifyDataSetChanged();
                                        }
                                    });
                                    chooseSceneTitleBar.setVisibility(0);
                                    animateLinearLayout.setVisibility(0);
                                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chooseSceneTitleBar, View.TRANSLATION_Y, -myDeviceSceneFragmentNew.getResources().getDimension(R.dimen.titlebar_height), 0.0f);
                                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(animateLinearLayout, "translationY", (float) animateLinearLayout.getHeight(), 0.0f);
                                    AnimatorSet animatorSet = new AnimatorSet();
                                    animatorSet.setDuration(200L);
                                    animatorSet.play(ofFloat).with(ofFloat2);
                                    animatorSet.start();
                                    animateLinearLayout.O000000o(0, AnimateLinearLayout.O000000o(animateLinearLayout.getChildCount()));
                                    myDeviceSceneFragmentNew.O0000O0o.notifyDataSetChanged();
                                    if (!(myDeviceSceneFragmentNew.O00000oo == null || myDeviceSceneFragmentNew.O00000oo.O00000o == null)) {
                                        myDeviceSceneFragmentNew.O00000oo.O00000o.setSwipeEnabled(false);
                                    }
                                    if (myDeviceSceneFragmentNew.mPlaceHolderView != null && myDeviceSceneFragmentNew.mPlaceHolderView.getVisibility() == 8) {
                                        myDeviceSceneFragmentNew.mPlaceHolderView.setVisibility(0);
                                    }
                                    myDeviceSceneFragmentNew.mSceneViewRV.setPadding(0, 0, 0, gpc.O000000o(99.0f));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        if (o000OOOo.O0000oO0) {
                            MyDeviceSceneFragmentNew.this.O000000o(i2, true, 30);
                        } else {
                            MyDeviceSceneFragmentNew.this.O000000o(i2, true, 15);
                        }
                    }
                    return true;
                }
            });
            autoSceneViewHolder.mExecuteTV.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O00000o0.AnonymousClass6 */

                public final void onClick(View view) {
                    MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                    SceneApi.O000OOOo o000OOOo = o000OOOo;
                    hob.O000000o();
                    hob.O000000o(ServiceApplication.getAppContext(), o000OOOo.f11131O000000o, "click", new fsm<Void, fso>() {
                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass22 */

                        public final void onFailure(fso fso) {
                            if (MyDeviceSceneFragmentNew.this.isValid()) {
                                gqg.O00000Oo((int) R.string.execute_fail);
                            }
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (MyDeviceSceneFragmentNew.this.isValid()) {
                                gqg.O00000Oo((int) R.string.execute_success);
                            }
                        }
                    });
                }
            });
            if (!TextUtils.equals(hpu.O000000o().O00000o, o000OOOo.f11131O000000o)) {
            }
            if (i2 != getChildCount(i) - 1) {
            }
        }

        public final /* synthetic */ void onBindGroupViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            gsy.O00000Oo("MySceneFragment", "onBindGroupViewHolder" + MyDeviceSceneFragmentNew.this.O00000Oo.size());
            O000000o o000000o = (O000000o) MyDeviceSceneFragmentNew.this.O00000Oo.get(i).first;
            if (o000000o.O00000Oo == 30) {
                Drawable drawable = MyDeviceSceneFragmentNew.this.getResources().getDrawable(R.drawable.lite_scene_hand_icon);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                o00000Oo.f10775O000000o.setCompoundDrawables(drawable, null, null, null);
            } else {
                if (o000000o.O00000Oo == 15) {
                    Drawable drawable2 = MyDeviceSceneFragmentNew.this.getResources().getDrawable(R.drawable.auto_scene_icon);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    o00000Oo.f10775O000000o.setCompoundDrawables(drawable2, null, null, null);
                    if (MyDeviceSceneFragmentNew.this.O00000Oo.size() == 2) {
                        o00000Oo.O00000Oo.setVisibility(0);
                    }
                }
                o00000Oo.f10775O000000o.setText(((O000000o) MyDeviceSceneFragmentNew.this.O00000Oo.get(i).first).f10774O000000o);
            }
            o00000Oo.O00000Oo.setVisibility(8);
            o00000Oo.f10775O000000o.setText(((O000000o) MyDeviceSceneFragmentNew.this.O00000Oo.get(i).first).f10774O000000o);
        }

        public O00000o0() {
            setHasStableIds(true);
        }

        public final int getGroupCount() {
            gsy.O00000Oo("MySceneFragment", "getGroupCount" + MyDeviceSceneFragmentNew.this.O00000Oo.size());
            return MyDeviceSceneFragmentNew.this.O00000Oo.size();
        }

        public final int getChildCount(int i) {
            return ((List) MyDeviceSceneFragmentNew.this.O00000Oo.get(i).second).size();
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateChildViewHolder(ViewGroup viewGroup, int i) {
            gsy.O00000Oo("MySceneFragment", "onCreateChildViewHolder" + MyDeviceSceneFragmentNew.this.O00000Oo.size());
            View inflate = MyDeviceSceneFragmentNew.this.O0000o00.inflate((int) R.layout.device_my_scene_fragment_scene_item, (ViewGroup) null);
            gsy.O00000Oo("youhua", "SceneAdapteronCreateViewHolder  viewType".concat(String.valueOf(i)));
            return new AutoSceneViewHolder(inflate);
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
            gsy.O00000Oo("MySceneFragment", "onCreateGroupViewHolder" + MyDeviceSceneFragmentNew.this.O00000Oo.size());
            MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
            return new O00000Oo(myDeviceSceneFragmentNew.O0000o00.inflate((int) R.layout.fragment_device_my_scene_group_item, (ViewGroup) null));
        }
    }

    public final void O00000o0() {
        if (this.O00000oO != 0) {
            this.O00000oO = 0;
            this.O0000o0 = false;
            if (!getActivity().isFinishing() && !getActivity().isFinishing()) {
                this.mPullRefreshLL.setPullToRefresh(true);
                DeviceSceneActivityNew deviceSceneActivityNew = (DeviceSceneActivityNew) getActivity();
                if (deviceSceneActivityNew != null && !deviceSceneActivityNew.isFinishing()) {
                    try {
                        final View chooseSceneTitleBar = deviceSceneActivityNew.getChooseSceneTitleBar();
                        final AnimateLinearLayout animateLinearLayout = (AnimateLinearLayout) deviceSceneActivityNew.getChooseSceneMenuBar();
                        animateLinearLayout.getParent();
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chooseSceneTitleBar, View.Y, 0.0f, (float) (-chooseSceneTitleBar.getHeight()));
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(animateLinearLayout, "translationY", 0.0f, (float) animateLinearLayout.getHeight());
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.setDuration(200L);
                        animatorSet.play(ofFloat).with(ofFloat2);
                        animatorSet.start();
                        animatorSet.addListener(new Animator.AnimatorListener() {
                            /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass2 */

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
                        this.O0000oo0.clear();
                        this.O0000O0o.notifyDataSetChanged();
                        if (!(this.O00000oo == null || this.O00000oo.O00000o == null)) {
                            this.O00000oo.O00000o.setSwipeEnabled(true);
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

    public final void O000000o(int i, boolean z, final int i2) {
        if (i2 == 15) {
            if (i >= this.O0000ooO.size()) {
                gqg.O00000Oo("position" + i + "mCustomScenes.size()" + this.O0000ooO.size());
                return;
            }
            this.O0000oo0.put(this.O0000ooO.get(i).f11131O000000o, Boolean.valueOf(z));
            gsy.O000000o(6, "MySceneFragment", this.O0000ooO.get(i).f11131O000000o + " " + z + "   mEditModeMap  " + this.O0000oo0.size() + "  type" + i2);
        } else if (i2 == 30) {
            if (i >= this.O00000o0.size()) {
                gqg.O00000Oo("position" + i + "mSmartHomeScenes.size()" + this.O00000o0.size());
                return;
            }
            this.O0000oo0.put(this.O00000o0.get(i).f11131O000000o, Boolean.valueOf(z));
            gsy.O000000o(6, "MySceneFragment", this.O00000o0.get(i).f11131O000000o + " " + z + "   mEditModeMap  " + this.O0000oo0.size() + "  type" + i2);
        }
        String str = null;
        int i3 = 0;
        for (Map.Entry next : this.O0000oo0.entrySet()) {
            if (((Boolean) next.getValue()).booleanValue()) {
                str = (String) next.getKey();
                i3++;
            }
        }
        try {
            if (i3 >= this.O0000ooO.size() + this.O00000o0.size()) {
                this.O0000o0o.setImageResource(R.drawable.un_select_selector);
                this.O0000o0o.setContentDescription(getString(R.string.unselect_all));
            } else {
                this.O0000o0o.setImageResource(R.drawable.all_select_selector);
                this.O0000o0o.setContentDescription(getString(R.string.select_all));
            }
            if (i3 <= 0) {
                this.O0000o.setEnabled(false);
                this.O0000oO0.setEnabled(false);
                this.O0000oOO.setEnabled(false);
                this.O0000o.setVisibility(8);
                this.O0000oO0.setVisibility(8);
                this.O0000oOO.setVisibility(8);
            } else if (i3 == 1) {
                final SceneApi.O000OOOo O00000Oo2 = hod.O0000OoO().O00000Oo(str);
                this.O0000o.setEnabled(true);
                this.O0000oO0.setEnabled(true);
                this.O0000o.setVisibility(0);
                this.O0000oO0.setVisibility(0);
                this.O0000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass3 */

                    public final void onClick(View view) {
                        MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                        SceneApi.O000OOOo o000OOOo = O00000Oo2;
                        String str = TextUtils.isEmpty(o000OOOo.O00000Oo) ? "" : o000OOOo.O00000Oo;
                        ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) myDeviceSceneFragmentNew.O0000o00.inflate((int) R.layout.client_remark_input_view, (ViewGroup) null);
                        clientRemarkInputView.O000000o(new ClientRemarkInputView.O000000o(o000OOOo) {
                            /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass8 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ SceneApi.O000OOOo f10769O000000o;

                            {
                                this.f10769O000000o = r2;
                            }

                            public final void modifyBackName(String str) {
                                final XQProgressDialog xQProgressDialog = new XQProgressDialog(MyDeviceSceneFragmentNew.this.getActivity());
                                xQProgressDialog.setMessage(MyDeviceSceneFragmentNew.this.getString(R.string.changeing_back_name));
                                xQProgressDialog.setCancelable(false);
                                xQProgressDialog.show();
                                final String str2 = this.f10769O000000o.O00000Oo;
                                this.f10769O000000o.O00000Oo = str;
                                if (!TextUtils.isEmpty(str) && !this.f10769O000000o.O00000oo.isEmpty()) {
                                    Iterator<SceneApi.Action> it = this.f10769O000000o.O00000oo.iterator();
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
                                if (eys.f15955O000000o) {
                                    hob O000000o2 = hob.O000000o();
                                    MyDeviceSceneFragmentNew.this.getActivity();
                                    O000000o2.O000000o(this.f10769O000000o, new fsm<Void, fso>() {
                                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass8.AnonymousClass1 */

                                        public final void onFailure(fso fso) {
                                            if (MyDeviceSceneFragmentNew.this.isValid()) {
                                                if (fso.f17063O000000o == -1) {
                                                    izb.O000000o(MyDeviceSceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_has_deleted_device, 0).show();
                                                } else {
                                                    izb.O000000o(MyDeviceSceneFragmentNew.this.getActivity(), (int) R.string.change_back_name_fail, 0).show();
                                                }
                                                xQProgressDialog.dismiss();
                                                SceneApi.O000OOOo o000OOOo = AnonymousClass8.this.f10769O000000o;
                                                String str = str2;
                                                o000OOOo.O00000Oo = str;
                                                if (!TextUtils.isEmpty(str) && !AnonymousClass8.this.f10769O000000o.O00000oo.isEmpty()) {
                                                    for (SceneApi.Action next : AnonymousClass8.this.f10769O000000o.O00000oo) {
                                                        if (next.O0000O0o != null && (next.O0000O0o instanceof SceneApi.O000OO)) {
                                                            ((SceneApi.O000OO) next.O0000O0o).O00000Oo = str2;
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            if (MyDeviceSceneFragmentNew.this.isValid()) {
                                                SmarthomeCreateAutoSceneActivity.notifyPlugin(MyDeviceSceneFragmentNew.this.getActivity(), true, AnonymousClass8.this.f10769O000000o, MyDeviceSceneFragmentNew.this.O0000Oo0);
                                                xQProgressDialog.dismiss();
                                                MyDeviceSceneFragmentNew.this.O0000O0o.notifyDataSetChanged();
                                                MyDeviceSceneFragmentNew.this.O00000oO();
                                            }
                                        }
                                    });
                                }
                            }
                        }, new MLAlertDialog.Builder(myDeviceSceneFragmentNew.getActivity()).O000000o((int) R.string.change_back_name).O000000o(clientRemarkInputView).O00000Oo(false).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(clientRemarkInputView) {
                            /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass7 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ ClientRemarkInputView f10768O000000o;

                            {
                                this.f10768O000000o = r2;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (TextUtils.isEmpty(this.f10768O000000o.getEditText().getText().toString())) {
                                    gqg.O00000Oo((int) R.string.scene_name_can_not_null);
                                } else {
                                    this.f10768O000000o.O000000o(dialogInterface);
                                }
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass6 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                            }
                        }).O00000oo(), str, str);
                        MyDeviceSceneFragmentNew.this.O00000o0();
                    }
                });
                this.O0000oO0.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass4 */

                    public final void onClick(View view) {
                        int O00000o = MyDeviceSceneFragmentNew.this.O00000o();
                        new MLAlertDialog.Builder(MyDeviceSceneFragmentNew.this.getActivity()).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass4.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ArrayList arrayList = new ArrayList();
                                for (Map.Entry next : MyDeviceSceneFragmentNew.this.O0000oo0.entrySet()) {
                                    if (((Boolean) next.getValue()).booleanValue()) {
                                        arrayList.add(next.getKey());
                                    }
                                }
                                MyDeviceSceneFragmentNew.this.O000000o(O00000Oo2, arrayList);
                                MyDeviceSceneFragmentNew.this.O00000o0();
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass4.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).O000000o(true).O00000Oo(MyDeviceSceneFragmentNew.this.getResources().getQuantityString(R.plurals.scene_confirm_delete_plurals, O00000o, Integer.valueOf(O00000o))).O00000oo();
                    }
                });
                if (hnw.O00000Oo(O00000Oo2)) {
                    this.O0000oOO.setEnabled(true);
                    this.O0000oOO.setVisibility(0);
                } else {
                    this.O0000oOO.setEnabled(false);
                    this.O0000oOO.setVisibility(8);
                }
                this.O0000oOO.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass5 */

                    public final void onClick(View view) {
                        FragmentActivity activity = MyDeviceSceneFragmentNew.this.getActivity();
                        SceneApi.O000OOOo o000OOOo = O00000Oo2;
                        hnw.O000000o(activity, o000OOOo, hnw.O00000Oo(o000OOOo.O00000o));
                        MyDeviceSceneFragmentNew.this.O00000o0();
                    }
                });
            } else if (i3 >= 2) {
                this.O0000o.setEnabled(false);
                this.O0000oO0.setEnabled(true);
                this.O0000oOO.setEnabled(false);
                this.O0000o.setVisibility(8);
                this.O0000oO0.setVisibility(0);
                this.O0000oOO.setVisibility(8);
            }
            this.O0000oOo.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, i3, Integer.valueOf(i3)));
            this.O0000O0o.notifyDataSetChanged();
        } catch (Exception unused) {
        }
    }

    public final int O00000o() {
        HashMap<String, Boolean> hashMap = this.O0000oo0;
        int i = 0;
        if (hashMap == null) {
            gsy.O00000Oo("MySceneFragment", "mEditModeMap==null");
            return 0;
        }
        for (Map.Entry next : hashMap.entrySet()) {
            if (((Boolean) next.getValue()).booleanValue()) {
                i++;
            }
            gsy.O00000Oo("MySceneFragment", "entry.getValue()" + next.getValue() + "  checkedCount" + i);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final SceneApi.O000OOOo o000OOOo, final List<String> list) {
        hob.O000000o().O000000o(getActivity(), list, new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass11 */

            public final void onFailure(fso fso) {
                if (MyDeviceSceneFragmentNew.this.isValid()) {
                    if (fso == null || fso.f17063O000000o != -2) {
                        izb.O000000o(MyDeviceSceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_delete_fail, 0).show();
                        return;
                    }
                    MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                    new MLAlertDialog.Builder(myDeviceSceneFragmentNew.getActivity()).O000000o((int) R.string.mj_retry, new DialogInterface.OnClickListener(o000OOOo) {
                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass10 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ SceneApi.O000OOOo f10744O000000o;

                        {
                            this.f10744O000000o = r2;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(this.f10744O000000o.f11131O000000o);
                            MyDeviceSceneFragmentNew.this.O000000o(this.f10744O000000o, arrayList);
                            dialogInterface.dismiss();
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass9 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).O000000o(true).O00000Oo((int) R.string.delete_scene_fail_title).O00000oo();
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (MyDeviceSceneFragmentNew.this.isValid()) {
                    SmarthomeCreateAutoSceneActivity.notifyPlugin(MyDeviceSceneFragmentNew.this.getActivity(), true, o000OOOo, MyDeviceSceneFragmentNew.this.O0000Oo0);
                    izb.O000000o(MyDeviceSceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_delete_succ, 0).show();
                    for (String O00000o02 : list) {
                        hod.O0000OoO().O00000o0(O00000o02);
                    }
                    gsy.O00000Oo("MySceneFragment", new StringBuilder("hasChangeLiteScenefalse").toString());
                    MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                    myDeviceSceneFragmentNew.O000000o(myDeviceSceneFragmentNew.O0000Ooo);
                    MyDeviceSceneFragmentNew.this.O00000Oo();
                    MyDeviceSceneFragmentNew.this.O00000oO();
                }
            }
        });
    }

    public final void O000000o(final SceneApi.O000OOOo o000OOOo, final String str) {
        if (eys.f15955O000000o) {
            ServiceApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass14 */

                public final void run() {
                    hob.O000000o().O000000o(MyDeviceSceneFragmentNew.this.getActivity(), o000OOOo, new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass14.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                         arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                         candidates:
                          com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                          com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.util.List<java.lang.String>):void
                          com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (MyDeviceSceneFragmentNew.this.isValid()) {
                                MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = MyDeviceSceneFragmentNew.this;
                                SceneApi.O000OOOo o000OOOo = o000OOOo;
                                String str = str;
                                String optString = jSONObject.optString("us_id");
                                boolean optBoolean = jSONObject.optBoolean("local");
                                o000OOOo.f11131O000000o = optString;
                                if (TextUtils.isEmpty(str) || !optBoolean) {
                                    myDeviceSceneFragmentNew.O000000o(true, o000OOOo);
                                } else if (fno.O000000o().O00000o0(str) != null) {
                                    hpn.O000000o().O000000o(XmPluginHostApi.instance().getDeviceByDid(str), jSONObject.optJSONObject("data").toString(), new MessageCallback(o000OOOo) {
                                        /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass16 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ SceneApi.O000OOOo f10751O000000o;

                                        {
                                            this.f10751O000000o = r2;
                                        }

                                        public final void onSuccess(Intent intent) {
                                            hob.O000000o();
                                            hob.O00000Oo(MyDeviceSceneFragmentNew.this.getActivity(), this.f10751O000000o, new fsm<Void, fso>() {
                                                /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass16.AnonymousClass1 */

                                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                                 method: com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                                                 arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                                                 candidates:
                                                  com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                                                  com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.util.List<java.lang.String>):void
                                                  com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                                                public final void onFailure(fso fso) {
                                                    if (MyDeviceSceneFragmentNew.this.isValid()) {
                                                        MyDeviceSceneFragmentNew.this.O000000o(false, AnonymousClass16.this.f10751O000000o);
                                                    }
                                                }

                                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                                 method: com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                                                 arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                                                 candidates:
                                                  com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                                                  com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.util.List<java.lang.String>):void
                                                  com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                                                public final /* synthetic */ void onSuccess(Object obj) {
                                                    if (MyDeviceSceneFragmentNew.this.isValid()) {
                                                        MyDeviceSceneFragmentNew.this.O000000o(true, AnonymousClass16.this.f10751O000000o);
                                                    }
                                                }
                                            });
                                        }

                                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                         method: com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void
                                         arg types: [int, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo]
                                         candidates:
                                          com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.lang.String):void
                                          com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, java.util.List<java.lang.String>):void
                                          com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.O000000o(boolean, com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo):void */
                                        public final void onFailure(int i, String str) {
                                            gsy.O000000o(6, "lumiscene", str);
                                            if (MyDeviceSceneFragmentNew.this.isValid()) {
                                                MyDeviceSceneFragmentNew.this.O000000o(false, this.f10751O000000o);
                                            }
                                        }
                                    });
                                }
                            }
                        }

                        public final void onFailure(fso fso) {
                            if (MyDeviceSceneFragmentNew.this.isValid()) {
                                if (MyDeviceSceneFragmentNew.this.O0000oo) {
                                    MyDeviceSceneFragmentNew.this.O0000oo = false;
                                    o000OOOo.O0000Oo0 = !o000OOOo.O0000Oo0;
                                    MyDeviceSceneFragmentNew.this.O0000O0o.notifyDataSetChanged();
                                }
                                if (fso.f17063O000000o == -1) {
                                    izb.O000000o(MyDeviceSceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_has_deleted_device, 0).show();
                                } else {
                                    izb.O000000o(MyDeviceSceneFragmentNew.this.getActivity(), (int) R.string.smarthome_scene_change_switch_fail, 0).show();
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
        ServiceApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass15 */

            public final void run() {
                if (!z) {
                    if (MyDeviceSceneFragmentNew.this.O0000oo) {
                        MyDeviceSceneFragmentNew.this.O0000oo = false;
                        SceneApi.O000OOOo o000OOOo = o000OOOo;
                        o000OOOo.O0000Oo0 = !o000OOOo.O0000Oo0;
                        MyDeviceSceneFragmentNew.this.O0000O0o.notifyDataSetChanged();
                    }
                    gqg.O00000Oo((int) R.string.local_sync_failed);
                } else if (MyDeviceSceneFragmentNew.this.O0000oo) {
                    MyDeviceSceneFragmentNew.this.O0000oo = false;
                }
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        gsy.O00000Oo("MySceneFragment", "onActivityResult" + i + "resultCode" + i2);
        if (i == 999 && i2 == -1 && this.O00oOooo && this.O00oOooO) {
            O000000o(this.O0000Ooo);
            O00000Oo();
        }
    }

    public final void O00000oO() {
        ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.scene.activity.MyDeviceSceneFragmentNew.AnonymousClass17 */

            public final void run() {
                hod.O0000OoO().O00000o();
            }
        }, 500);
    }

    public static class SceneChildViewHolder extends axz {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f10783O000000o;
        @BindView(5375)
        View mDivideLine;
        @BindView(5376)
        View mDivideLineBottom;

        public View getSwipeableContainerView() {
            return this.f10783O000000o;
        }
    }
}
