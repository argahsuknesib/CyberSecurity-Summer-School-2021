package com.xiaomi.smarthome.homeroom;

import _m_j.awq;
import _m_j.axl;
import _m_j.axx;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ggb;
import _m_j.ggc;
import _m_j.gha;
import _m_j.ghh;
import _m_j.gpc;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.grv;
import _m_j.gwg;
import _m_j.hxi;
import _m_j.hxp;
import _m_j.hzf;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.AnimateLinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MultiHomeManagerActivity extends BaseActivity implements View.OnClickListener {
    public static int MAX_HOME_SIZE = 11;
    private static WeakReference<MultiHomeManagerActivity> O0000oO0;

    /* renamed from: O000000o  reason: collision with root package name */
    protected RecyclerView f8929O000000o;
    protected TextView O00000Oo;
    protected axx O00000o;
    protected RecyclerViewExpandableItemManager O00000o0;
    protected axl O00000oO;
    protected RecyclerView.O000000o O00000oo;
    protected LinearLayoutManager O0000O0o;
    boolean O0000OOo = false;
    private Button O0000Oo;
    private ImageView O0000Oo0;
    private ImageView O0000OoO;
    private boolean O0000Ooo = false;
    private BroadcastReceiver O0000o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            MultiHomeManagerActivity.this.contrlProgreassDialog(false, true, ggc.O000000o().O000000o(gha.f17769O000000o).size() > 0 ? 3000 : 500);
        }
    };
    private View O0000o0;
    private boolean O0000o00 = false;
    private View O0000o0O;
    private String O0000o0o;
    public ghh mAdapter;
    public XQProgressDialog mProcessDialog;
    public AnimateLinearLayout menuBar;
    public View titleBar;

    public void updateActionItems(int i) {
    }

    public String getLatestAcceptHomeId() {
        return this.O0000o0o;
    }

    public void setLatestAcceptHomeId(String str) {
        this.O0000o0o = str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_multi_home_manager);
        findViewById(R.id.module_a_3_right_img_btn).setVisibility(8);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.home_manage_tite);
        this.O0000o0 = findViewById(R.id.module_a_3_return_btn);
        this.O0000o0.setOnClickListener(this);
        this.O0000o0O = findViewById(R.id.addhome);
        this.O0000o0O.setOnClickListener(this);
        this.f8929O000000o = (RecyclerView) findViewById(R.id.recycler_view);
        this.f8929O000000o.setOnScrollListener(new RecyclerView.O00oOooO() {
            /* class com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity.AnonymousClass3 */

            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                View currentFocus;
                super.onScrollStateChanged(recyclerView, i);
                if (i != 0 && MultiHomeManagerActivity.this.isValid() && (currentFocus = MultiHomeManagerActivity.this.getCurrentFocus()) != null) {
                    currentFocus.clearFocus();
                }
            }
        });
        this.f8929O000000o.addItemDecoration(new O000000o());
        this.O00000o0 = new RecyclerViewExpandableItemManager();
        this.O00000oO = new axl();
        this.mAdapter = new ghh(this);
        this.mAdapter.O00000oO = new ghh.O000000o() {
            /* class com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity.AnonymousClass4 */
        };
        this.O00000oo = this.O00000o0.O000000o(this.mAdapter);
        this.O00000oo = this.O00000oO.O000000o(this.O00000oo);
        this.O0000O0o = new LinearLayoutManager(this);
        awq awq = new awq();
        awq.O0000o00 = false;
        this.f8929O000000o.setLayoutManager(this.O0000O0o);
        this.f8929O000000o.setAdapter(this.O00000oo);
        this.f8929O000000o.setItemAnimator(awq);
        this.f8929O000000o.setHasFixedSize(false);
        this.O00000o = new axx();
        axx axx = this.O00000o;
        axx.O0000OOo = true;
        axx.O00000Oo();
        this.O00000o.O000000o(this.f8929O000000o);
        this.O00000oO.O000000o(this.f8929O000000o);
        axl axl = this.O00000oO;
        axl.O0000o00 = true;
        axl.O0000Oo0 = (NinePatchDrawable) getContext().getResources().getDrawable(R.drawable.std_list_item_drag_shadow);
        axl axl2 = this.O00000oO;
        axl2.O0000o0 = true;
        axl2.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 1.5f);
        this.O00000oO.O00oOooO = new axl.O00000Oo() {
            /* class com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity.AnonymousClass5 */
        };
        this.O00000o0.O000000o(this.f8929O000000o);
        this.O00000o0.O000000o();
        this.f8929O000000o.setItemAnimator(null);
        O000000o();
        ft.O000000o(this).O000000o(this.O0000o, new IntentFilter("home_room_updated"));
    }

    private void O000000o() {
        ggc.O000000o().O000000o(new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity.AnonymousClass2 */

            public final void onFailure(fso fso) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                MultiHomeManagerActivity.this.mAdapter.O00000Oo();
                MultiHomeManagerActivity.this.O00000o0.O000000o();
                int intExtra = MultiHomeManagerActivity.this.getIntent().getIntExtra("from", 0);
                hxp hxp = hxi.O00000o0;
                int size = MultiHomeManagerActivity.this.mAdapter.O00000Oo.size();
                ghh ghh = MultiHomeManagerActivity.this.mAdapter;
                int i = 0;
                for (int i2 = 0; i2 < ghh.O00000Oo.size(); i2++) {
                    if (!ghh.O00000Oo.get(i2).isOwner()) {
                        i++;
                    }
                }
                hxp.O000000o(0, size, i, MultiHomeManagerActivity.this.mAdapter.O00000o0.size(), intExtra);
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (this.O0000OOo) {
            O000000o();
            this.O0000OOo = false;
            return;
        }
        this.mAdapter.O00000Oo();
    }

    public void onPause() {
        super.onPause();
        this.O0000OOo = true;
        hxi.O00000o0.O000000o(this.mEnterTime, 0, 0, 0, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ft.O000000o(this).O000000o(this.O0000o);
    }

    public void showProgressDialog(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R.string.loading_share_info);
        }
        this.mProcessDialog = new XQProgressDialog(this);
        this.mProcessDialog.setCancelable(true);
        this.mProcessDialog.setMessage(str);
        this.mProcessDialog.show();
    }

    public void contrlProgreassDialog(boolean z, boolean z2, int i) {
        if (isValid() && !z) {
            if (this.mProcessDialog != null) {
                getWindow().getDecorView().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity.AnonymousClass6 */

                    public final void run() {
                        if (MultiHomeManagerActivity.this.mProcessDialog != null) {
                            MultiHomeManagerActivity.this.mProcessDialog.dismiss();
                        }
                        MultiHomeManagerActivity.this.mAdapter.O00000Oo();
                        MultiHomeManagerActivity.this.showChangeHomeDialog();
                    }
                }, (long) i);
            }
            if (!z2) {
                gqg.O00000Oo((int) R.string.home_set_failed);
            }
        }
    }

    public void showChangeHomeDialog() {
        final Home O00000o2 = ggb.O00000Oo().O00000o(getLatestAcceptHomeId());
        setLatestAcceptHomeId("");
        if (O00000o2 != null) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            String string = getString(R.string.home_share_response_success1);
            ggb.O00000Oo();
            builder.O00000Oo(String.format(string, ggb.O000000o(O00000o2))).O000000o((int) R.string.view_now, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity.AnonymousClass7 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void
                 arg types: [android.content.Context, java.lang.String, java.lang.String, int]
                 candidates:
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void */
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Context appContext = CommonApplication.getAppContext();
                    gpy.O00000Oo(appContext, "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "show_change_home_red_dot", false);
                    ggc.O000000o().O00000oo.onNext(Boolean.FALSE);
                    MultiHomeManagerActivity.this.showProgressDialog("");
                    ggb.O00000Oo().O000000o(O00000o2.getId(), new fsm() {
                        /* class com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity.AnonymousClass7.AnonymousClass1 */

                        public final void onSuccess(Object obj) {
                            if (MultiHomeManagerActivity.this.isValid()) {
                                MultiHomeManagerActivity.this.contrlProgreassDialog(false, true, 0);
                                fbt fbt = new fbt(MultiHomeManagerActivity.this, "SmartHomeMainActivity");
                                fbt.O00000Oo(67108864);
                                fbs.O000000o(fbt);
                                hxi.O00000o.O00000oO(3);
                            }
                        }

                        public final void onFailure(fso fso) {
                            MultiHomeManagerActivity.this.contrlProgreassDialog(false, false, 0);
                            hxi.O00000o.O0000Ooo();
                        }
                    });
                }
            }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
        }
    }

    public void onBackPressed() {
        if (this.O0000Ooo) {
            exitEditMode();
        } else {
            finish();
        }
    }

    public void onClick(View view) {
        if (view == this.O0000Oo0) {
            exitEditMode();
            return;
        }
        if (view == this.O0000Oo) {
            this.O0000o00 = true;
            ghh ghh = this.mAdapter;
            ghh.O0000O0o = true;
            ghh.O00000o = new ArrayList<>(ghh.O00000Oo);
            ghh.notifyDataSetChanged();
            this.O00000Oo.setText((int) R.string.menu_edit_sort);
            this.O0000Oo0.setImageResource(R.drawable.title_cancel_selector);
            ViewGroup viewGroup = (ViewGroup) this.menuBar.getParent();
            ObjectAnimator.ofFloat(this.menuBar, View.Y, (float) (viewGroup.getHeight() - this.menuBar.getHeight()), (float) viewGroup.getHeight()).start();
        } else if (view == this.O0000OoO) {
            if (this.O0000o00) {
                this.mAdapter.O000000o(true);
            }
            exitEditMode();
        } else if (view == this.O0000o0) {
            finish();
        } else if (view == this.O0000o0O) {
            hxi.O00000o.O0000OOo();
            List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
            if (list != null) {
                int i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2).isOwner()) {
                        i++;
                    }
                }
                if (i >= MAX_HOME_SIZE) {
                    gqg.O00000Oo(getString(R.string.multi_home_max_home));
                    return;
                }
                startActivity(new Intent(this, HomeRoomCreatHomeActivity.class));
                O0000oO0 = new WeakReference<>(this);
            }
        }
    }

    public static void finishActivity() {
        WeakReference<MultiHomeManagerActivity> weakReference = O0000oO0;
        if (weakReference != null && weakReference.get() != null) {
            O0000oO0.get().finish();
        }
    }

    public void enterEditMode() {
        if (!this.O0000Ooo) {
            try {
                if (this.titleBar == null) {
                    this.titleBar = ((ViewStub) findViewById(R.id.title_bar_choose_device_stub)).inflate();
                    this.O0000Oo0 = (ImageView) this.titleBar.findViewById(16908313);
                    this.O0000Oo0.setOnClickListener(this);
                    this.O0000OoO = (ImageView) this.titleBar.findViewById(16908314);
                    this.O0000OoO.setOnClickListener(this);
                    this.O0000OoO.setImageResource(R.drawable.title_right_tick_drawable);
                    this.O00000Oo = (TextView) this.titleBar.findViewById(R.id.module_a_4_return_more_title);
                    gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.title_bar_choose_device));
                }
                if (this.menuBar == null) {
                    this.menuBar = (AnimateLinearLayout) ((ViewStub) findViewById(R.id.edit_action_bar_stub)).inflate();
                    this.O0000Oo = (Button) this.menuBar.findViewById(R.id.btn_edit_sort);
                    this.O0000Oo.setOnClickListener(this);
                    this.menuBar.findViewById(R.id.btn_edit_delete).setVisibility(8);
                }
                this.O00000Oo.setText((int) R.string.home_manage_tite);
                this.titleBar.setVisibility(0);
                this.menuBar.setTranslationY(0.0f);
                this.menuBar.setVisibility(0);
                this.menuBar.O000000o(0, AnimateLinearLayout.O000000o(this.menuBar.getChildCount()));
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.titleBar, View.Y, -getResources().getDimension(R.dimen.titlebar_height), 0.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.play(ofFloat);
                animatorSet.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.O0000Ooo = true;
            ghh ghh = this.mAdapter;
            ghh.O00000oo = true;
            ghh.O00000o.clear();
            ghh.notifyDataSetChanged();
        }
    }

    public void exitEditMode() {
        if (this.O0000Ooo) {
            ViewGroup viewGroup = (ViewGroup) this.menuBar.getParent();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.titleBar, View.Y, 0.0f, (float) (-this.titleBar.getHeight()));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.menuBar, View.Y, (float) (viewGroup.getHeight() - this.menuBar.getHeight()), (float) viewGroup.getHeight());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            if (!this.O0000o00) {
                animatorSet.play(ofFloat).with(ofFloat2);
            } else {
                animatorSet.play(ofFloat);
                this.mAdapter.O000000o(false);
            }
            animatorSet.start();
            animatorSet.addListener(new Animator.AnimatorListener() {
                /* class com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity.AnonymousClass8 */

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    MultiHomeManagerActivity.this.titleBar.clearAnimation();
                    MultiHomeManagerActivity.this.menuBar.clearAnimation();
                    MultiHomeManagerActivity.this.titleBar.setVisibility(8);
                    MultiHomeManagerActivity.this.menuBar.setVisibility(8);
                }
            });
            this.O0000Ooo = false;
            this.O0000o00 = false;
            ghh ghh = this.mAdapter;
            ghh.O00000oo = false;
            ghh.O0000O0o = false;
            ghh.O00000o.clear();
            ghh.notifyDataSetChanged();
        }
    }

    class O000000o extends RecyclerView.O0000Oo {
        O000000o() {
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            if (recyclerView.getChildAdapterPosition(view) == MultiHomeManagerActivity.this.O00000oo.getItemCount() - 1) {
                rect.set(0, 0, 0, gpc.O000000o(100.0f));
            }
        }
    }
}
