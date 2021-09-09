package com.xiaomi.smarthome.scene;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fvm;
import _m_j.gof;
import _m_j.gpc;
import _m_j.gwg;
import _m_j.hig;
import _m_j.hjp;
import _m_j.hnw;
import _m_j.hny;
import _m_j.hob;
import _m_j.hod;
import _m_j.hpq;
import _m_j.hte;
import _m_j.hxi;
import _m_j.hzf;
import _m_j.izb;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.AnimateLinearLayout;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity;
import com.xiaomi.smarthome.scene.NFCSceneListFragment;
import com.xiaomi.smarthome.scene.activity.NFCSceneListActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class NFCSceneListFragment extends fvm {

    /* renamed from: O000000o  reason: collision with root package name */
    View f10590O000000o;
    LayoutInflater O00000Oo;
    O000000o O00000o;
    LinearLayoutManager O00000o0 = null;
    List<SceneApi.O000OOOo> O00000oO = new ArrayList();
    public boolean O00000oo = false;
    public ImageView O0000O0o;
    public ImageView O0000OOo;
    public Button O0000Oo;
    public Button O0000Oo0;
    public TextView O0000OoO;
    public HashMap<String, Boolean> O0000Ooo = new HashMap<>();
    public int O0000o0 = 0;
    public boolean O0000o00 = false;
    private boolean O0000o0O = true;
    private hny O0000o0o = new hny() {
        /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass7 */

        public final void onRefreshScenceSuccess(int i) {
            if (NFCSceneListFragment.this.isValid() && i == 5) {
                NFCSceneListFragment.this.O000000o();
                NFCSceneListFragment.this.O00000Oo();
                if (NFCSceneListFragment.this.mPullRefreshLL != null) {
                    NFCSceneListFragment.this.mPullRefreshLL.refreshComplete();
                }
            }
        }

        public final void onRefreshScenceFailed(int i) {
            if (NFCSceneListFragment.this.isValid()) {
                NFCSceneListFragment.this.mPullRefreshLL.refreshComplete();
                NFCSceneListFragment.this.O00000Oo();
            }
        }
    };
    @BindView(5188)
    View buyParent;
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
    @BindView(6440)
    View mTextBuy;

    public class MyViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private MyViewHolder f10603O000000o;

        public MyViewHolder_ViewBinding(MyViewHolder myViewHolder, View view) {
            this.f10603O000000o = myViewHolder;
            myViewHolder.mCardConstraintLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.card_layout, "field 'mCardConstraintLayout'", ConstraintLayout.class);
            myViewHolder.actionLL = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.action_ll, "field 'actionLL'", LinearLayout.class);
            myViewHolder.mIconCondition = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.icon_condition, "field 'mIconCondition'", SimpleDraweeView.class);
            myViewHolder.mIconConditionMore = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon_condition_more, "field 'mIconConditionMore'", ImageView.class);
            myViewHolder.tvSceneName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_scene_name, "field 'tvSceneName'", TextView.class);
            myViewHolder.mCheckBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ckb_edit_selected, "field 'mCheckBox'", CheckBox.class);
            myViewHolder.mRightView = (ImageView) Utils.findRequiredViewAsType(view, R.id.right_view, "field 'mRightView'", ImageView.class);
            myViewHolder.mOpenCheck = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.open_check, "field 'mOpenCheck'", SwitchButton.class);
            myViewHolder.mMoreIcon = Utils.findRequiredView(view, R.id.scene_new_more_icon, "field 'mMoreIcon'");
            myViewHolder.mExecuteTV = (TextView) Utils.findRequiredViewAsType(view, R.id.execute_tv, "field 'mExecuteTV'", TextView.class);
        }

        public void unbind() {
            MyViewHolder myViewHolder = this.f10603O000000o;
            if (myViewHolder != null) {
                this.f10603O000000o = null;
                myViewHolder.mCardConstraintLayout = null;
                myViewHolder.actionLL = null;
                myViewHolder.mIconCondition = null;
                myViewHolder.mIconConditionMore = null;
                myViewHolder.tvSceneName = null;
                myViewHolder.mCheckBox = null;
                myViewHolder.mRightView = null;
                myViewHolder.mOpenCheck = null;
                myViewHolder.mMoreIcon = null;
                myViewHolder.mExecuteTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f10590O000000o == null) {
            this.f10590O000000o = layoutInflater.inflate((int) R.layout.fragment_nfc_scene_list, (ViewGroup) null);
            ButterKnife.bind(this, this.f10590O000000o);
            this.O00000Oo = LayoutInflater.from(getActivity());
            this.mContext = getActivity();
            this.mEmptyTV.setText((int) R.string.nfc_empty_scene_list);
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.f10590O000000o.findViewById(R.id.title_bar_choose_device));
            this.O00000o0 = new LinearLayoutManager(this.mContext);
            this.O00000o = new O000000o();
            this.mSceneViewRV.setLayoutManager(this.O00000o0);
            this.mSceneViewRV.setAdapter(this.O00000o);
            this.mPullRefreshLL.setPtrHandler(new PtrHandler() {
                /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass4 */

                public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                    if (Build.VERSION.SDK_INT < 14) {
                        if (view instanceof AbsListView) {
                            AbsListView absListView = (AbsListView) view;
                            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
                        } else if (!(view instanceof RecyclerView)) {
                            return view.getScrollY() > 0;
                        } else {
                            LinearLayoutManager linearLayoutManager = NFCSceneListFragment.this.O00000o0;
                            return linearLayoutManager != null && linearLayoutManager.findFirstCompletelyVisibleItemPosition() - 1 < 0;
                        }
                    } else if (!(view instanceof RecyclerView)) {
                        return view.canScrollVertically(-1);
                    } else {
                        LinearLayoutManager linearLayoutManager2 = NFCSceneListFragment.this.O00000o0;
                        return linearLayoutManager2 != null && linearLayoutManager2.findFirstCompletelyVisibleItemPosition() - 1 < 0;
                    }
                }

                public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                    if (NFCSceneListFragment.this.O0000o0 == 1) {
                        NFCSceneListFragment.this.mPullRefreshLL.refreshComplete();
                    } else if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                        NFCSceneListFragment.this.mPullRefreshLL.refreshComplete();
                        NFCSceneListFragment.this.O00000Oo();
                    } else {
                        NFCSceneListFragment.this.O00000o0();
                    }
                }
            });
            this.mEmptyView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass5 */

                public final void onClick(View view) {
                    if (NFCSceneListFragment.this.mPullRefreshLL != null) {
                        NFCSceneListFragment.this.mPullRefreshLL.autoRefresh();
                    }
                }
            });
            this.mTextBuy.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass6 */

                public final void onClick(View view) {
                    hxi.O00000o.f952O000000o.O000000o("NFC_buy_buy", new Object[0]);
                    String O0000O0o = hig.O0000O0o();
                    if (!TextUtils.isEmpty(O0000O0o)) {
                        hjp.O000000o(O0000O0o);
                    }
                }
            });
            if (this.mPullRefreshLL != null) {
                ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass1 */

                    public final void run() {
                        NFCSceneListFragment.this.mPullRefreshLL.autoRefresh();
                    }
                }, 300);
            }
        }
        return this.f10590O000000o;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        hxi.O00000oO.f958O000000o.O000000o("NFC_scene_list", new Object[0]);
    }

    public void onResume() {
        super.onResume();
        if (this.O0000o0O) {
            this.O0000o0O = false;
        } else {
            O00000o0();
        }
    }

    public final boolean O000000o(Activity activity) {
        if (this.O0000o0 == 1) {
            O00000o();
            return true;
        }
        activity.finish();
        return true;
    }

    public final void O000000o() {
        this.O00000oO.clear();
        for (SceneApi.O000OOOo next : hod.O0000OoO().f416O000000o) {
            if (next.O0000O0o != null && next.O0000O0o.size() == 1 && next.O0000O0o.get(0).f11121O000000o == LAUNCH_TYPE.NFC) {
                this.O00000oO.add(next);
            }
        }
        this.O00000o.notifyDataSetChanged();
    }

    public final void O00000Oo() {
        if (this.O00000oO.size() == 0) {
            this.mPullRefreshLL.setPullToRefresh(false);
            this.mEmptyView.setVisibility(0);
            if (!TextUtils.isEmpty(hig.O0000O0o())) {
                this.buyParent.setVisibility(0);
            } else {
                this.buyParent.setVisibility(8);
            }
            this.mSceneViewRV.setVisibility(8);
            return;
        }
        this.mSceneViewRV.setVisibility(0);
        this.mPullRefreshLL.setPullToRefresh(true);
        this.mEmptyView.setVisibility(8);
    }

    public final void O00000o0() {
        hod.O0000OoO().O000000o(this.O0000o0o);
    }

    public final void O00000o() {
        if (this.O0000o0 != 0) {
            this.O0000o0 = 0;
            this.O00000oo = false;
            if (!getActivity().isFinishing() && !getActivity().isFinishing()) {
                this.mPullRefreshLL.setPullToRefresh(true);
                NFCSceneListActivity nFCSceneListActivity = (NFCSceneListActivity) getActivity();
                if (nFCSceneListActivity != null && !nFCSceneListActivity.isFinishing()) {
                    try {
                        final View chooseSceneTitleBar = nFCSceneListActivity.getChooseSceneTitleBar();
                        final AnimateLinearLayout animateLinearLayout = (AnimateLinearLayout) nFCSceneListActivity.getChooseSceneMenuBar();
                        animateLinearLayout.getParent();
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chooseSceneTitleBar, View.Y, 0.0f, (float) (-chooseSceneTitleBar.getHeight()));
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(animateLinearLayout, "translationY", 0.0f, (float) animateLinearLayout.getHeight());
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.setDuration(200L);
                        animatorSet.play(ofFloat).with(ofFloat2);
                        animatorSet.start();
                        animatorSet.addListener(new Animator.AnimatorListener() {
                            /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass10 */

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
                        this.O0000Ooo.clear();
                        this.O00000o.notifyDataSetChanged();
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

    public final void O000000o(int i, boolean z) {
        if (i < this.O00000oO.size()) {
            this.O0000Ooo.put(this.O00000oO.get(i).f11131O000000o, Boolean.valueOf(z));
            String str = null;
            int i2 = 0;
            for (Map.Entry next : this.O0000Ooo.entrySet()) {
                if (((Boolean) next.getValue()).booleanValue()) {
                    str = (String) next.getKey();
                    i2++;
                }
            }
            try {
                if (i2 >= this.O00000oO.size()) {
                    this.O0000OOo.setImageResource(R.drawable.un_select_selector);
                    this.O0000OOo.setContentDescription(getString(R.string.unselect_all));
                } else {
                    this.O0000OOo.setImageResource(R.drawable.all_select_selector);
                    this.O0000OOo.setContentDescription(getString(R.string.select_all));
                }
                if (i2 <= 0) {
                    this.O0000Oo0.setEnabled(false);
                    this.O0000Oo.setEnabled(false);
                } else {
                    final SceneApi.O000OOOo O00000Oo2 = hod.O0000OoO().O00000Oo(str);
                    this.O0000Oo0.setEnabled(true);
                    this.O0000Oo0.setOnClickListener(new View.OnClickListener(O00000Oo2) {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$NFCSceneListFragment$oiX54gcMB2eLyB6wvcZjJxCZRTM */
                        private final /* synthetic */ SceneApi.O000OOOo f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            NFCSceneListFragment.this.O000000o(this.f$1, view);
                        }
                    });
                    if (hnw.O00000Oo(O00000Oo2)) {
                        this.O0000Oo.setEnabled(true);
                    } else {
                        this.O0000Oo.setEnabled(false);
                    }
                    this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass11 */

                        public final void onClick(View view) {
                            FragmentActivity activity = NFCSceneListFragment.this.getActivity();
                            SceneApi.O000OOOo o000OOOo = O00000Oo2;
                            hnw.O000000o(activity, o000OOOo, hnw.O00000Oo(o000OOOo.O00000o));
                            NFCSceneListFragment.this.O00000o();
                        }
                    });
                }
                this.O0000OoO.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, i2, Integer.valueOf(i2)));
                this.O00000o.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(SceneApi.O000OOOo o000OOOo, View view) {
        new MLAlertDialog.Builder(getActivity()).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener(o000OOOo) {
            /* class com.xiaomi.smarthome.scene.$$Lambda$NFCSceneListFragment$lxw3djuebgWaYIBjF49DsRmrdkk */
            private final /* synthetic */ SceneApi.O000OOOo f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                NFCSceneListFragment.this.O000000o(this.f$1, dialogInterface, i);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, $$Lambda$NFCSceneListFragment$_gDn6UGe43luyPPLp5CnszUSlXo.INSTANCE).O000000o(true).O00000Oo((int) R.string.nfc_scene_confirm_delete).O00000oo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(SceneApi.O000OOOo o000OOOo, DialogInterface dialogInterface, int i) {
        hxi.O00000o.f952O000000o.O000000o("NFC_have_delete", new Object[0]);
        final ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.O0000Ooo.entrySet()) {
            if (((Boolean) next.getValue()).booleanValue()) {
                arrayList.add(next.getKey());
            }
        }
        hob.O000000o().O000000o(getActivity(), arrayList, new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass2 */

            public final void onFailure(fso fso) {
                if (NFCSceneListFragment.this.isValid()) {
                    izb.O000000o(NFCSceneListFragment.this.getActivity(), (int) R.string.smarthome_scene_delete_fail, 0).show();
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (NFCSceneListFragment.this.isValid()) {
                    izb.O000000o(NFCSceneListFragment.this.getActivity(), (int) R.string.smarthome_scene_delete_succ, 0).show();
                    for (String O00000o0 : arrayList) {
                        hod.O0000OoO().O00000o0(O00000o0);
                    }
                    NFCSceneListFragment.this.O000000o();
                    NFCSceneListFragment.this.O00000Oo();
                    NFCSceneListFragment.O00000oO();
                }
            }
        });
        O00000o();
    }

    public static void O00000oO() {
        ServiceApplication.getGlobalHandler().postDelayed($$Lambda$NFCSceneListFragment$E3W1DOAT9lnH5Pdf30hsvZqya9g.INSTANCE, 500);
    }

    class O000000o extends RecyclerView.O000000o<MyViewHolder> {
        public final long getItemId(int i) {
            return (long) i;
        }

        O000000o() {
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            MyViewHolder myViewHolder = (MyViewHolder) o000OOo0;
            SceneApi.O000OOOo o000OOOo = NFCSceneListFragment.this.O00000oO.get(i);
            if (getItemCount() == 1) {
                myViewHolder.mCardConstraintLayout.setBackgroundResource(R.drawable.all_radius_rectangle_bg);
            } else if (i == 0) {
                myViewHolder.mCardConstraintLayout.setBackgroundResource(R.drawable.top_radius_rectangle_bg);
            } else if (i == getItemCount() - 1) {
                myViewHolder.mCardConstraintLayout.setBackgroundResource(R.drawable.bottom_radius_rectangle_bg);
            } else {
                myViewHolder.mCardConstraintLayout.setBackgroundResource(R.color.mj_color_dialog_bg_nor);
            }
            if (o000OOOo != null) {
                myViewHolder.mIconConditionMore.setVisibility(8);
                myViewHolder.mIconCondition.setImageResource(R.drawable.std_scene_icon_nfc);
                hnw.O000000o(o000OOOo, myViewHolder.actionLL);
                myViewHolder.mMoreIcon.setVisibility(8);
                myViewHolder.tvSceneName.setText(o000OOOo.O00000Oo);
                if (NFCSceneListFragment.this.O00000oo) {
                    myViewHolder.mCheckBox.setVisibility(0);
                    myViewHolder.mRightView.setVisibility(4);
                    myViewHolder.mOpenCheck.setVisibility(4);
                    myViewHolder.mCheckBox.setOnCheckedChangeListener(null);
                    myViewHolder.mExecuteTV.setVisibility(8);
                    if (!NFCSceneListFragment.this.O0000Ooo.containsKey(o000OOOo.f11131O000000o) || !NFCSceneListFragment.this.O0000Ooo.get(o000OOOo.f11131O000000o).booleanValue()) {
                        myViewHolder.mCheckBox.setChecked(false);
                    } else {
                        myViewHolder.mCheckBox.setChecked(true);
                    }
                    myViewHolder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(i) {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$NFCSceneListFragment$O000000o$FC11tTLbALAMstxR6o5cipHLSRU */
                        private final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            NFCSceneListFragment.O000000o.this.O000000o(this.f$1, compoundButton, z);
                        }
                    });
                    myViewHolder.itemView.setOnClickListener(new View.OnClickListener(myViewHolder) {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$NFCSceneListFragment$O000000o$FUtHxFCqeo1LeWepIMDXwrBCBOc */
                        private final /* synthetic */ NFCSceneListFragment.MyViewHolder f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            NFCSceneListFragment.O000000o.this.O000000o(this.f$1, view);
                        }
                    });
                } else {
                    myViewHolder.mCheckBox.setVisibility(8);
                    myViewHolder.mRightView.setVisibility(8);
                    myViewHolder.mExecuteTV.setVisibility(8);
                    myViewHolder.mOpenCheck.setVisibility(0);
                    myViewHolder.itemView.setOnClickListener(new View.OnClickListener(o000OOOo) {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$NFCSceneListFragment$O000000o$oHnH38YXx0_iDuuPG1E3dMAr_E */
                        private final /* synthetic */ SceneApi.O000OOOo f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            NFCSceneListFragment.O000000o.this.O000000o(this.f$1, view);
                        }
                    });
                }
                myViewHolder.mOpenCheck.setChecked(o000OOOo.O0000Oo0);
                myViewHolder.mOpenCheck.setChecked(o000OOOo.O0000Oo0);
                myViewHolder.mOpenCheck.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(myViewHolder, o000OOOo) {
                    /* class com.xiaomi.smarthome.scene.$$Lambda$NFCSceneListFragment$O000000o$LqnB4GLSaSlINivRGYbqFknpa0 */
                    private final /* synthetic */ NFCSceneListFragment.MyViewHolder f$1;
                    private final /* synthetic */ SceneApi.O000OOOo f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        NFCSceneListFragment.O000000o.this.O000000o(this.f$1, this.f$2, compoundButton, z);
                    }
                });
                myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener(i) {
                    /* class com.xiaomi.smarthome.scene.$$Lambda$NFCSceneListFragment$O000000o$jzYkeG18DvIjQtyqbXKtEfAz0kg */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final boolean onLongClick(View view) {
                        return NFCSceneListFragment.O000000o.this.O000000o(this.f$1, view);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, CompoundButton compoundButton, boolean z) {
            NFCSceneListFragment.this.O000000o(i, z);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(MyViewHolder myViewHolder, View view) {
            if (NFCSceneListFragment.this.O00000oo) {
                myViewHolder.mCheckBox.setChecked(!myViewHolder.mCheckBox.isChecked());
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(SceneApi.O000OOOo o000OOOo, View view) {
            Intent intent = new Intent(NFCSceneListFragment.this.getActivity(), NFCActionListActivity.class);
            intent.putExtra("us_id", o000OOOo.f11131O000000o);
            NFCSceneListFragment.this.startActivity(intent);
            hpq.O000000o().O00000o0();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(MyViewHolder myViewHolder, SceneApi.O000OOOo o000OOOo, CompoundButton compoundButton, boolean z) {
            if (!gof.O00000o0()) {
                hte.O000000o(NFCSceneListFragment.this.getActivity(), (int) R.string.smarthome_scene_set_fail);
                myViewHolder.mOpenCheck.setChecked(o000OOOo.O0000Oo0);
                return;
            }
            o000OOOo.O0000Oo0 = z;
            if (!TextUtils.isEmpty(o000OOOo.f11131O000000o)) {
                NFCSceneListFragment nFCSceneListFragment = NFCSceneListFragment.this;
                nFCSceneListFragment.O0000o00 = true;
                if (!gof.O00000o0()) {
                    hte.O000000o(nFCSceneListFragment.getActivity(), (int) R.string.network_fake_connected);
                } else {
                    hob.O000000o().O000000o(nFCSceneListFragment.getActivity(), o000OOOo, new fsm<JSONObject, fso>(o000OOOo) {
                        /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ SceneApi.O000OOOo f10595O000000o;

                        {
                            this.f10595O000000o = r2;
                        }

                        public final void onFailure(fso fso) {
                            if (NFCSceneListFragment.this.isValid()) {
                                if (NFCSceneListFragment.this.O0000o00) {
                                    NFCSceneListFragment.this.O0000o00 = false;
                                    SceneApi.O000OOOo o000OOOo = this.f10595O000000o;
                                    o000OOOo.O0000Oo0 = !o000OOOo.O0000Oo0;
                                    NFCSceneListFragment.this.O00000o.notifyDataSetChanged();
                                }
                                if (fso.f17063O000000o == -1) {
                                    izb.O000000o(NFCSceneListFragment.this.getActivity(), (int) R.string.smarthome_scene_has_deleted_device, 0).show();
                                } else {
                                    izb.O000000o(NFCSceneListFragment.this.getActivity(), (int) R.string.smarthome_scene_change_switch_fail, 0).show();
                                }
                            }
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (NFCSceneListFragment.this.isValid()) {
                                NFCSceneListFragment.this.O0000o00 = false;
                            }
                        }
                    });
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.scene.NFCSceneListFragment.O000000o(int, boolean):void
         arg types: [int, int]
         candidates:
          com.xiaomi.smarthome.scene.NFCSceneListFragment.O000000o(android.content.DialogInterface, int):void
          com.xiaomi.smarthome.scene.NFCSceneListFragment.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, android.view.View):void
          com.xiaomi.smarthome.scene.NFCSceneListFragment.O000000o(int, boolean):void */
        /* access modifiers changed from: private */
        public /* synthetic */ boolean O000000o(int i, View view) {
            NFCSceneListActivity nFCSceneListActivity;
            if (!NFCSceneListFragment.this.O00000oo) {
                NFCSceneListFragment nFCSceneListFragment = NFCSceneListFragment.this;
                if (nFCSceneListFragment.O0000o0 != 1) {
                    nFCSceneListFragment.O0000o0 = 1;
                    nFCSceneListFragment.O00000oo = true;
                    nFCSceneListFragment.mPullRefreshLL.setPullToRefresh(false);
                    if (!nFCSceneListFragment.getActivity().isFinishing() && (nFCSceneListActivity = (NFCSceneListActivity) nFCSceneListFragment.getActivity()) != null && !nFCSceneListActivity.isFinishing()) {
                        try {
                            View chooseSceneTitleBar = nFCSceneListActivity.getChooseSceneTitleBar();
                            AnimateLinearLayout animateLinearLayout = (AnimateLinearLayout) nFCSceneListActivity.getChooseSceneMenuBar();
                            nFCSceneListFragment.O0000OoO = (TextView) chooseSceneTitleBar.findViewById(R.id.module_a_4_return_more_title);
                            nFCSceneListFragment.O0000O0o = (ImageView) chooseSceneTitleBar.findViewById(16908313);
                            nFCSceneListFragment.O0000OOo = (ImageView) chooseSceneTitleBar.findViewById(16908314);
                            nFCSceneListFragment.O0000Oo0 = (Button) animateLinearLayout.findViewById(R.id.btn_edit_delete);
                            animateLinearLayout.findViewById(R.id.btn_edit_rename).setVisibility(8);
                            animateLinearLayout.findViewById(R.id.btn_edit_sort).setVisibility(8);
                            animateLinearLayout.findViewById(R.id.btn_edit_add_toLauncher).setVisibility(8);
                            nFCSceneListFragment.O0000O0o.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass8 */

                                public final void onClick(View view) {
                                    NFCSceneListFragment.this.O00000o();
                                }
                            });
                            nFCSceneListFragment.O0000OOo.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.NFCSceneListFragment.AnonymousClass9 */

                                public final void onClick(View view) {
                                    int i;
                                    NFCSceneListFragment nFCSceneListFragment = NFCSceneListFragment.this;
                                    if (nFCSceneListFragment.O0000Ooo == null) {
                                        i = 0;
                                    } else {
                                        i = 0;
                                        for (Map.Entry<String, Boolean> value : nFCSceneListFragment.O0000Ooo.entrySet()) {
                                            if (((Boolean) value.getValue()).booleanValue()) {
                                                i++;
                                            }
                                        }
                                    }
                                    boolean z = i < NFCSceneListFragment.this.O00000oO.size();
                                    for (int i2 = 0; i2 < NFCSceneListFragment.this.O00000oO.size(); i2++) {
                                        NFCSceneListFragment.this.O000000o(i2, z);
                                    }
                                    NFCSceneListFragment.this.O00000o.notifyDataSetChanged();
                                }
                            });
                            chooseSceneTitleBar.setVisibility(0);
                            animateLinearLayout.setVisibility(0);
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chooseSceneTitleBar, View.TRANSLATION_Y, -nFCSceneListFragment.getResources().getDimension(R.dimen.titlebar_height), 0.0f);
                            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(animateLinearLayout, "translationY", (float) animateLinearLayout.getHeight(), 0.0f);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.setDuration(200L);
                            animatorSet.play(ofFloat).with(ofFloat2);
                            animatorSet.start();
                            animateLinearLayout.O000000o(0, AnimateLinearLayout.O000000o(animateLinearLayout.getChildCount()));
                            nFCSceneListFragment.O00000o.notifyDataSetChanged();
                            if (nFCSceneListFragment.mPlaceHolderView != null && nFCSceneListFragment.mPlaceHolderView.getVisibility() == 8) {
                                nFCSceneListFragment.mPlaceHolderView.setVisibility(0);
                            }
                            nFCSceneListFragment.mSceneViewRV.setPadding(0, 0, 0, gpc.O000000o(99.0f));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                NFCSceneListFragment.this.O000000o(i, true);
            }
            return true;
        }

        public final int getItemCount() {
            if (NFCSceneListFragment.this.O00000oO == null) {
                return 0;
            }
            return NFCSceneListFragment.this.O00000oO.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            NFCSceneListFragment nFCSceneListFragment = NFCSceneListFragment.this;
            return new MyViewHolder(nFCSceneListFragment.getLayoutInflater().inflate((int) R.layout.my_scene_fragment_scene_item, viewGroup, false));
        }
    }

    public class MyViewHolder extends RecyclerView.O000OOo0 {
        @BindView(5051)
        LinearLayout actionLL;
        @BindView(5201)
        ConstraintLayout mCardConstraintLayout;
        @BindView(5239)
        CheckBox mCheckBox;
        @BindView(5453)
        TextView mExecuteTV;
        @BindView(5588)
        SimpleDraweeView mIconCondition;
        @BindView(5589)
        ImageView mIconConditionMore;
        @BindView(6152)
        View mMoreIcon;
        @BindView(5925)
        SwitchButton mOpenCheck;
        @BindView(6098)
        ImageView mRightView;
        @BindView(6485)
        TextView tvSceneName;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
