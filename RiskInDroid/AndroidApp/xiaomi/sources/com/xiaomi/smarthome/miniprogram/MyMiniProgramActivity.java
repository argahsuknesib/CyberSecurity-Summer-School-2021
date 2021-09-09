package com.xiaomi.smarthome.miniprogram;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.ft;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.gym;
import _m_j.gyn;
import _m_j.gyo;
import _m_j.gyp;
import _m_j.gys;
import _m_j.hxi;
import _m_j.hyq;
import _m_j.hyr;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshLinearLayout;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.smarthome.library.common.widget.viewflow.LoadingMoreView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyMiniProgramActivity extends BaseActivity implements gyn, gyo, gyp, hyr, View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f9976O000000o;
    private int O00000Oo;
    private MiniProgramAdapter O00000o;
    private View O00000o0;
    private O000000o O00000oO;
    private AbsListView.OnScrollListener O00000oo = new AbsListView.OnScrollListener() {
        /* class com.xiaomi.smarthome.miniprogram.MyMiniProgramActivity.AnonymousClass1 */
        private int O00000Oo = 0;
        private int O00000o0 = 10;

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            View currentFocus;
            if (1 == i && (currentFocus = MyMiniProgramActivity.this.getCurrentFocus()) != null) {
                currentFocus.clearFocus();
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i3 < this.O00000Oo) {
                this.O00000Oo = 0;
            }
            if (!gym.O000000o().O0000o0o && i3 > this.O00000Oo) {
                this.O00000Oo = i3;
            }
            if (gym.O000000o().O0000o && gym.O000000o().O0000o0 && !gym.O000000o().O0000o0o && i3 - i2 <= i + this.O00000o0) {
                MyMiniProgramActivity.this.mLoadingMoreView.O000000o();
                gym.O000000o().O00000oO();
            }
        }
    };
    private boolean O0000O0o = false;
    public Dialog loadingDialog;
    @BindView(5535)
    View mBackView;
    @BindView(4992)
    View mBottomDeleteBar;
    @BindView(5143)
    View mBottomDeleteBtn;
    @BindView(5035)
    View mCancelBtn;
    @BindView(5103)
    CustomPullDownRefreshLinearLayout mEmptyView;
    @BindView(5101)
    TextView mErrorTipTxt;
    @BindView(5842)
    ImageView mIvSelectAll;
    @BindView(5436)
    PullDownDragListView mListView;
    public LoadingMoreView mLoadingMoreView;
    @BindView(5544)
    ImageView mManageBtn;
    @BindView(5848)
    TextView mSelectCountText;
    @BindView(5991)
    TextView mTipsTxt;
    @BindView(6024)
    View mTopManageBar;
    public MLAlertDialog unAuthDialog;
    public MLAlertDialog userTipDialog;

    static class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            gsy.O000000o(2, "MyMiniProgramActivity", "ShareReceiver onReceive.");
            if (intent != null && TextUtils.equals(intent.getAction(), "com.xiaomi.smarthome.action.SHARE_RESULT")) {
                int intExtra = intent.getIntExtra("result_code", -2);
                String stringExtra = intent.getStringExtra("message");
                gsy.O000000o(3, "MyMiniProgramActivity", "received share result,errorCode:" + intExtra + ",errMsg:" + stringExtra);
                if (intExtra != 0) {
                    gqg.O00000Oo((int) R.string.share_canceled);
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.PullDownDragListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_my_mini_program);
        ButterKnife.bind(this);
        hyq.O000000o().O00000Oo = this;
        gym.O000000o().O0000OoO = this;
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.my_mini_program);
        if (gwg.O000000o((Activity) this)) {
            this.mTopManageBar.getLayoutParams().height += gwg.O00000Oo(this);
            View view = this.mTopManageBar;
            view.setPadding(0, view.getPaddingTop() + gwg.O00000Oo(this), 0, 0);
            View view2 = this.mTopManageBar;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        this.mBackView.setOnClickListener(this);
        this.mManageBtn.setOnClickListener(this);
        this.mCancelBtn.setOnClickListener(this);
        this.mIvSelectAll.setOnClickListener(this);
        this.O00000Oo = this.mListView.getHeaderViewsCount();
        this.f9976O000000o = LayoutInflater.from(this).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.mListView, false);
        this.mListView.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
            /* class com.xiaomi.smarthome.miniprogram.MyMiniProgramActivity.AnonymousClass2 */

            public final void startRefresh() {
                MyMiniProgramActivity.this.doRefresh();
            }
        });
        this.mListView.setCanPullDown(true);
        this.mLoadingMoreView = new LoadingMoreView(this);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.mLoadingMoreView, 0, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.addFooterView(frameLayout);
        this.mListView.setOnScrollListener(this.O00000oo);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.O00000o0 = LayoutInflater.from(this).inflate((int) R.layout.view_miniprogram_tip, (ViewGroup) null);
        relativeLayout.addView(this.O00000o0, 0, new RelativeLayout.LayoutParams(-1, -2));
        this.O00000o0.setVisibility(8);
        this.mListView.addFooterView(relativeLayout);
        this.O00000o0.setOnClickListener(this);
        this.mEmptyView.setRefreshListener(new CustomPullDownRefreshLinearLayout.O00000o0() {
            /* class com.xiaomi.smarthome.miniprogram.MyMiniProgramActivity.AnonymousClass3 */

            public final void O000000o() {
                MyMiniProgramActivity.this.doRefresh();
            }
        });
        this.mEmptyView.setScrollView((ScrollView) findViewById(R.id.scroll_view));
        this.O00000o = new MiniProgramAdapter(this);
        MiniProgramAdapter miniProgramAdapter = this.O00000o;
        miniProgramAdapter.f9968O000000o = this;
        miniProgramAdapter.O00000Oo = this;
        this.mListView.setAdapter((ListAdapter) miniProgramAdapter);
        this.mBottomDeleteBar.setOnClickListener(this);
        this.mSelectCountText.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, hyq.O000000o().O00000o0.size(), Integer.valueOf(hyq.O000000o().O00000o0.size())));
        this.mTipsTxt.setOnClickListener(this);
        if (gpy.O00000o0(ServiceApplication.getAppContext(), "pref_mini_program", "is_first_in", true)) {
            O00000Oo();
            gpy.O000000o(ServiceApplication.getAppContext(), "pref_mini_program", "is_first_in", false);
        }
        this.mListView.O000000o();
        if (this.O00000oO != null) {
            ft.O000000o(this).O000000o(this.O00000oO);
        }
        this.O00000oO = new O000000o((byte) 0);
        ft.O000000o(this).O000000o(this.O00000oO, new IntentFilter("com.xiaomi.smarthome.action.SHARE_RESULT"));
    }

    public void onStop() {
        super.onStop();
        hyq.O000000o().O000000o(1);
    }

    public void onDestroy() {
        super.onDestroy();
        gym.O000000o().O00000o0();
        hyq.O000000o().O00000Oo();
        ft.O000000o(this).O000000o(this.O00000oO);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (hyq.O000000o().f997O000000o == 0) {
                hyq.O000000o().O000000o(1);
                return false;
            }
            Dialog dialog = this.loadingDialog;
            if (dialog != null && dialog.isShowing()) {
                this.loadingDialog.dismiss();
                return false;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onLowMemory() {
        super.onLowMemory();
        gym.O000000o().O00000o0();
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (80 == i) {
            gym.O000000o().O00000o0();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        gym.O000000o().O0000oO = null;
    }

    public void doRefresh() {
        this.mLoadingMoreView.setVisibility(8);
        this.O00000o0.setVisibility(8);
        gym.O000000o().O00000o();
        gym.O000000o().O000000o(true);
        gym.O000000o().O00000Oo();
    }

    private void O000000o() {
        hyq.O000000o().O00000o0.clear();
        this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.select_all));
        this.O00000o.notifyDataSetChanged();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            finish();
            hxi.O00000o.f952O000000o.O000000o("mine_myminiprograms_back", new Object[0]);
        } else if (id == R.id.cancel_btn) {
            hyq.O000000o().O000000o(1);
        } else if (id == R.id.module_a_3_right_iv_setting_btn) {
            if (!this.mListView.O00000o && !this.mEmptyView.O00000o) {
                hyq.O000000o().O000000o(0);
            }
        } else if (id == R.id.select_all_btn) {
            if (hyq.O000000o().O00000o0.size() == this.O00000o.getCount()) {
                O000000o();
            } else {
                int count = this.O00000o.getCount();
                hyq.O000000o().O00000o0.clear();
                for (int i = 0; i < count; i++) {
                    hyq.O000000o().O00000o0.put(i, true);
                }
                this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
                this.mIvSelectAll.setContentDescription(getString(R.string.unselect_all));
                this.O00000o.notifyDataSetChanged();
                this.mSelectCountText.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, hyq.O000000o().O00000o0.size(), Integer.valueOf(hyq.O000000o().O00000o0.size())));
            }
            this.mSelectCountText.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, hyq.O000000o().O00000o0.size(), Integer.valueOf(hyq.O000000o().O00000o0.size())));
        } else if (id == R.id.bottom_delete_bar) {
            if (hyq.O000000o().O00000o0.size() > 0) {
                MLAlertDialog mLAlertDialog = this.unAuthDialog;
                if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
                    this.unAuthDialog.dismiss();
                }
                this.unAuthDialog = new MLAlertDialog.Builder(this).O00000Oo((int) R.string.tip_unauth).O000000o((int) R.string.program_unauth, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.miniprogram.MyMiniProgramActivity.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (MyMiniProgramActivity.this.unAuthDialog != null && MyMiniProgramActivity.this.unAuthDialog.isShowing()) {
                            MyMiniProgramActivity.this.unAuthDialog.dismiss();
                        }
                        MyMiniProgramActivity myMiniProgramActivity = MyMiniProgramActivity.this;
                        myMiniProgramActivity.loadingDialog = XQProgressDialog.O000000o(myMiniProgramActivity, "", myMiniProgramActivity.getString(R.string.unauthing));
                        final ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < gym.O000000o().O00000oO.size(); i2++) {
                            if (hyq.O000000o().O00000o0.get(i2)) {
                                arrayList.add(gym.O000000o().O00000oO.get(i2).O00000o0.did);
                            }
                        }
                        if (arrayList.size() == 0) {
                            if (MyMiniProgramActivity.this.loadingDialog != null && MyMiniProgramActivity.this.loadingDialog.isShowing()) {
                                MyMiniProgramActivity.this.loadingDialog.dismiss();
                            }
                            hyq.O000000o().O000000o(1);
                            return;
                        }
                        gym.O000000o().O00000Oo(arrayList, new fsm() {
                            /* class com.xiaomi.smarthome.miniprogram.MyMiniProgramActivity.AnonymousClass5.AnonymousClass1 */

                            public final void onSuccess(Object obj) {
                                if (MyMiniProgramActivity.this.isValid()) {
                                    gym.O000000o();
                                    gym.O000000o(arrayList, new fsm<JSONObject, fso>() {
                                        /* class com.xiaomi.smarthome.miniprogram.MyMiniProgramActivity.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                        public final void onFailure(fso fso) {
                                            if (MyMiniProgramActivity.this.isValid()) {
                                                if (MyMiniProgramActivity.this.loadingDialog != null && MyMiniProgramActivity.this.loadingDialog.isShowing()) {
                                                    MyMiniProgramActivity.this.loadingDialog.dismiss();
                                                }
                                                gqg.O00000Oo((int) R.string.share_fail_retry);
                                            }
                                        }

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            if (MyMiniProgramActivity.this.isValid()) {
                                                gym O000000o2 = gym.O000000o();
                                                List list = arrayList;
                                                AnonymousClass1 r1 = new fsm<JSONObject, fso>() {
                                                    /* class com.xiaomi.smarthome.miniprogram.MyMiniProgramActivity.AnonymousClass5.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                    public final void onFailure(fso fso) {
                                                        if (MyMiniProgramActivity.this.isValid()) {
                                                            if (MyMiniProgramActivity.this.loadingDialog != null && MyMiniProgramActivity.this.loadingDialog.isShowing()) {
                                                                MyMiniProgramActivity.this.loadingDialog.dismiss();
                                                            }
                                                            gqg.O00000Oo((int) R.string.share_fail_retry);
                                                        }
                                                    }

                                                    public final /* synthetic */ void onSuccess(Object obj) {
                                                        if (MyMiniProgramActivity.this.isValid()) {
                                                            if (MyMiniProgramActivity.this.loadingDialog != null && MyMiniProgramActivity.this.loadingDialog.isShowing()) {
                                                                MyMiniProgramActivity.this.loadingDialog.dismiss();
                                                            }
                                                            gqg.O00000Oo((int) R.string.unauth_success);
                                                            hyq.O000000o().O000000o(1);
                                                            MyMiniProgramActivity.this.mListView.O000000o();
                                                        }
                                                    }
                                                };
                                                int i = 0;
                                                O000000o2.O0000oOO = 0;
                                                O000000o2.O0000oOo = 0;
                                                if (list != null && list.size() != 0) {
                                                    O000000o2.O0000oOo = list.size() / 50;
                                                    if (list.size() % 50 != 0) {
                                                        O000000o2.O0000oOo++;
                                                    }
                                                    while (i < O000000o2.O0000oOo) {
                                                        JSONArray jSONArray = new JSONArray();
                                                        int i2 = O000000o2.O0000oOo * i;
                                                        while (i2 < list.size() && i2 < (O000000o2.O0000oOo * i) + 50) {
                                                            jSONArray.put(list.get(i2));
                                                            i2++;
                                                        }
                                                        JSONObject jSONObject = new JSONObject();
                                                        try {
                                                            jSONObject.put("dids", jSONArray);
                                                        } catch (JSONException unused) {
                                                        }
                                                        ArrayList arrayList = new ArrayList();
                                                        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                                                        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/home/cleartokencount").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                                                            /* class _m_j.gym.AnonymousClass6 */

                                                            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                                                                return jSONObject;
                                                            }
                                                        }, Crypto.RC4, new fsm<JSONObject, fso>(r1) {
                                                            /* class _m_j.gym.AnonymousClass7 */

                                                            /* renamed from: O000000o  reason: collision with root package name */
                                                            final /* synthetic */ fsm f18582O000000o;

                                                            {
                                                                this.f18582O000000o = r2;
                                                            }

                                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                                fsm fsm;
                                                                JSONObject jSONObject = (JSONObject) obj;
                                                                if (jSONObject.has("code")) {
                                                                    if (jSONObject.optInt("code") == 0) {
                                                                        gym.this.O0000oOO++;
                                                                    }
                                                                    if (gym.this.O0000oOO == gym.this.O0000oOo && (fsm = this.f18582O000000o) != null) {
                                                                        fsm.onSuccess(jSONObject);
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                fsm fsm2 = this.f18582O000000o;
                                                                if (fsm2 != null) {
                                                                    fsm2.onFailure(new fso(-999, "code is null"));
                                                                }
                                                            }

                                                            public final void onFailure(fso fso) {
                                                                fsm fsm = this.f18582O000000o;
                                                                if (fsm != null) {
                                                                    fsm.onFailure(fso);
                                                                }
                                                            }
                                                        });
                                                        i++;
                                                    }
                                                }
                                            }
                                        }
                                    });
                                }
                            }

                            public final void onFailure(fso fso) {
                                if (MyMiniProgramActivity.this.isValid()) {
                                    if (MyMiniProgramActivity.this.loadingDialog != null && MyMiniProgramActivity.this.loadingDialog.isShowing()) {
                                        MyMiniProgramActivity.this.loadingDialog.dismiss();
                                    }
                                    gqg.O00000Oo((int) R.string.unauth_failed);
                                }
                            }
                        });
                    }
                }).O00000Oo((int) R.string.mini_program_cancel, (DialogInterface.OnClickListener) null).O00000o();
                if (!this.unAuthDialog.isShowing()) {
                    this.unAuthDialog.show();
                    return;
                }
                return;
            }
            gqg.O00000Oo((int) R.string.choose_one_tip);
        } else if (id == R.id.tips || id == R.id.footer_tips) {
            O00000Oo();
            hxi.O00000o.f952O000000o.O000000o("mine_myminiprograms_help", new Object[0]);
        }
    }

    private void O00000Oo() {
        MLAlertDialog mLAlertDialog = this.userTipDialog;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.userTipDialog.dismiss();
        }
        this.userTipDialog = new MLAlertDialog.Builder(this).O000000o((TextView) LayoutInflater.from(this).inflate((int) R.layout.dialog_mini_program_tip, (ViewGroup) null)).O000000o((int) R.string.mini_program_isee, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miniprogram.MyMiniProgramActivity.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (MyMiniProgramActivity.this.userTipDialog != null && MyMiniProgramActivity.this.userTipDialog.isShowing()) {
                    dialogInterface.dismiss();
                }
            }
        }).O00000o();
        if (!this.userTipDialog.isShowing()) {
            this.userTipDialog.show();
        }
    }

    public void onBrowseMode() {
        O000000o();
        this.O00000o.notifyDataSetChanged();
        this.mTopManageBar.setVisibility(8);
        this.mBottomDeleteBar.setVisibility(8);
        this.O00000o.notifyDataSetChanged();
        this.mListView.setCanPullDown(true);
        this.mListView.setOnScrollListener(this.O00000oo);
        if (gym.O000000o().O00000oO == null || gym.O000000o().O00000oO.size() == 0) {
            this.mManageBtn.setVisibility(8);
        } else {
            this.mManageBtn.setVisibility(0);
        }
    }

    public void onManageMode() {
        hxi.O00000o.f952O000000o.O000000o("mine_myminiprograms_edit", new Object[0]);
        this.O00000o.notifyDataSetChanged();
        this.mListView.setCanPullDown(false);
        this.mListView.setOnScrollListener(null);
        this.mTopManageBar.setVisibility(0);
        this.mBottomDeleteBar.setVisibility(0);
        this.mTopManageBar.measure(0, 0);
        this.mBottomDeleteBar.measure(0, 0);
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTopManageBar, View.TRANSLATION_Y, -getResources().getDimension(R.dimen.mj_titlebar_height), 0.0f);
        ViewGroup viewGroup = (ViewGroup) this.mBottomDeleteBar.getParent();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBottomDeleteBar, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - this.mBottomDeleteBar.getMeasuredHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public void onLongClick() {
        if (!this.mListView.O00000o) {
            hyq.O000000o().O000000o(0);
        }
    }

    public boolean allowPerformLongClick() {
        if (hyq.O000000o().f997O000000o != 1 || this.mListView.O00000o || this.mEmptyView.O00000o) {
            return false;
        }
        return true;
    }

    public void onPause() {
        super.onPause();
        this.O0000O0o = false;
    }

    public void onSuccess(List<gys> list, int i, boolean z) {
        if (isValid()) {
            if (!this.O0000O0o) {
                this.O0000O0o = true;
                hxi.O00000o0.O000000o(list.size());
            }
            this.mListView.O00000Oo();
            this.mEmptyView.O00000Oo();
            this.mLoadingMoreView.setVisibility(8);
            if (i == 0) {
                this.O00000o.O000000o();
            }
            this.O00000o.O00000o0.addAll(list);
            this.O00000o.notifyDataSetChanged();
            if (this.O00000o.getCount() == 0) {
                this.mManageBtn.setVisibility(8);
                this.mEmptyView.setVisibility(0);
                this.O00000o.O000000o();
                this.mErrorTipTxt.setText((int) R.string.my_mini_program_no_data);
            } else {
                this.mEmptyView.setVisibility(8);
                this.mTipsTxt.setVisibility(8);
                this.mManageBtn.setVisibility(0);
                if (this.O00000Oo == this.mListView.getHeaderViewsCount()) {
                    this.mListView.addHeaderView(this.f9976O000000o);
                }
                if (z) {
                    this.O00000o0.setVisibility(8);
                    this.mTipsTxt.setVisibility(8);
                    return;
                }
            }
            O00000o0();
        }
    }

    private void O00000o0() {
        if (O00000o()) {
            this.O00000o0.setVisibility(8);
            this.mTipsTxt.setVisibility(0);
            return;
        }
        this.O00000o0.setVisibility(0);
        this.mTipsTxt.setVisibility(8);
    }

    private boolean O00000o() {
        WindowManager windowManager = getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        gsy.O000000o(6, "MyMiniProgramActivity", ((this.O00000o.getCount() * 70) + 135) + "$$$$$" + i);
        return (this.O00000o.getCount() * 70) + 135 < i;
    }

    public void onError(boolean z) {
        if (isValid()) {
            if (!this.O0000O0o) {
                this.O0000O0o = true;
                hxi.O00000o0.O000000o(0);
            }
            this.mListView.O00000Oo();
            this.mEmptyView.O00000Oo();
            this.mLoadingMoreView.setVisibility(8);
            if (gym.O000000o().O0000OOo == null || gym.O000000o().O0000OOo.size() == 0) {
                this.mListView.removeHeaderView(this.f9976O000000o);
                this.mEmptyView.setVisibility(0);
                this.O00000o.O000000o();
                this.mErrorTipTxt.setText((int) R.string.my_mini_program_no_data);
                this.mManageBtn.setVisibility(8);
                O00000o0();
                return;
            }
            if (z) {
                this.mLoadingMoreView.O000000o(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miniprogram.MyMiniProgramActivity.AnonymousClass6 */

                    public final void onClick(View view) {
                        gym.O000000o().O00000oO();
                    }
                });
            }
            gqg.O00000Oo((int) R.string.load_failed);
        }
    }

    public void onCheck(int i) {
        if (i == this.O00000o.getCount()) {
            this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
            this.mIvSelectAll.setContentDescription(getString(R.string.unselect_all));
        } else {
            this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
            this.mIvSelectAll.setContentDescription(getString(R.string.select_all));
        }
        this.mSelectCountText.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, i, Integer.valueOf(i)));
    }
}
