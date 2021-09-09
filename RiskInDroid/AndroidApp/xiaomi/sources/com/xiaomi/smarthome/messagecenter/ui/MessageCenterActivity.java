package com.xiaomi.smarthome.messagecenter.ui;

import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfr;
import _m_j.gof;
import _m_j.gpv;
import _m_j.gul;
import _m_j.guq;
import _m_j.guw;
import _m_j.gvc;
import _m_j.gwg;
import _m_j.hte;
import _m_j.hxi;
import _m_j.hzf;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.family.api.MessageApi;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.redpoint.ServerTimerManager;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.viewflow.LoadingMoreView;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import com.xiaomi.smarthome.miio.db.record.MessageRecordTypeList;
import com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessageCenterActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    gvc f9434O000000o;
    boolean O00000Oo = true;
    ImageView O00000o;
    long O00000o0 = 0;
    long O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private ImageView O0000OOo;
    private TextView O0000Oo;
    private View O0000Oo0;
    private View O0000OoO;
    private LoadingMoreView O0000Ooo;
    private Map<String, Integer> O0000o = new HashMap();
    private View O0000o0;
    private View O0000o00;
    private View O0000o0O;
    private RecyclerView O0000o0o;
    private boolean O0000oO0 = false;
    public Set<String> mCheckedItems = new HashSet();
    public ImageView mIvSelectAll;
    public boolean mLoadingMoreFinished = false;
    public PtrFrameLayout mPullRefreshLL;
    public List<gul> mRequestList = new ArrayList();
    public TextView mSelectedCntTv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.message_center_v4);
        this.O0000Ooo = new LoadingMoreView(this);
        this.O0000Ooo.setVisibility(8);
        this.O0000o0o = (RecyclerView) findViewById(R.id.message_list);
        this.O0000o0o.setLayoutManager(new LinearLayoutManager(this));
        this.f9434O000000o = new gvc(this);
        this.O0000o0o.setAdapter(this.f9434O000000o);
        this.O00000oo = findViewById(R.id.common_white_empty_view);
        this.O00000oo.setVisibility(8);
        ((TextView) findViewById(R.id.common_white_empty_text)).setText((int) R.string.miio_no_message);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.miio_setting_message_center);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity.AnonymousClass3 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
             arg types: [java.lang.String, int]
             candidates:
              _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
            public final void onClick(View view) {
                gpv.O00000Oo("message_center_red_dot_clicked", true);
                gpv.O00000Oo("my_home_red_dot_clicked", true);
                gpv.O000000o(ServiceApplication.getAppContext(), "new_message_count", 0);
                MessageCenterActivity.this.finish();
            }
        });
        this.O00000o = (ImageView) findViewById(R.id.module_a_3_right_iv_setting_btn);
        this.O00000o.setVisibility(0);
        this.O00000o.setContentDescription(getString(R.string.message_center_setting_title));
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity.AnonymousClass4 */

            public final void onClick(View view) {
                MessageCenterActivity.this.startActivity(new Intent(MessageCenterActivity.this, MessageCenterSettingActivity.class));
                hxi.O00000o.f952O000000o.O000000o("message_setting_click", new Object[0]);
            }
        });
        this.O0000OoO = findViewById(R.id.title_bar);
        this.O0000O0o = findViewById(R.id.top_delete_bar);
        this.mSelectedCntTv = (TextView) this.O0000O0o.findViewById(R.id.selected_cnt);
        this.O0000OOo = (ImageView) this.O0000O0o.findViewById(R.id.cancel_btn);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity.AnonymousClass5 */

            public final void onClick(View view) {
                MessageCenterActivity.this.dismissEditMode();
            }
        });
        this.mIvSelectAll = (ImageView) this.O0000O0o.findViewById(R.id.select_all_btn);
        this.mIvSelectAll.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity.AnonymousClass6 */

            public final void onClick(View view) {
                if (MessageCenterActivity.this.mCheckedItems.size() == MessageCenterActivity.this.mRequestList.size()) {
                    MessageCenterActivity.this.unSelectAll();
                } else {
                    MessageCenterActivity.this.selectAll();
                }
            }
        });
        this.O0000Oo0 = findViewById(R.id.bottom_delete_bar);
        this.O0000Oo = (TextView) this.O0000Oo0.findViewById(R.id.delete_msg_btn);
        this.O0000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity.AnonymousClass7 */

            public final void onClick(View view) {
                MessageCenterActivity.this.deleteSelected();
            }
        });
        if (gwg.O000000o((Activity) this)) {
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.O0000O0o);
        }
        this.O0000o00 = LayoutInflater.from(this).inflate((int) R.layout.message_center_group_item, (ViewGroup) null);
        this.O0000o0 = LayoutInflater.from(this).inflate((int) R.layout.message_center_group_item, (ViewGroup) null);
        this.O0000o0O = LayoutInflater.from(this).inflate((int) R.layout.message_center_group_item, (ViewGroup) null);
        this.O0000o0O.findViewById(R.id.content).setBackgroundResource(R.drawable.mj_rs_common_white_list_padding_no_left_margin);
        this.mPullRefreshLL = (PtrFrameLayout) findViewById(R.id.pull_down_refresh);
        this.mPullRefreshLL.setPtrHandler(new PtrHandler() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity.AnonymousClass8 */

            public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                return PtrDefaultHandler.checkContentCanBePulledDown(ptrFrameLayout, view, view2);
            }

            public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                MessageCenterActivity.this.startLoadData();
            }
        });
        this.O00000oO = PreferenceManager.getDefaultSharedPreferences(this).getLong("last_update_time", 0);
        this.O00000Oo = false;
        this.O00000o0 = 0;
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity.AnonymousClass1 */

            public final void run() {
                MessageCenterActivity.this.mPullRefreshLL.autoRefresh();
            }
        }, 100);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.O00000Oo = false;
        this.O00000o0 = 0;
        startLoadData();
    }

    public void onResume() {
        super.onResume();
        PtrFrameLayout ptrFrameLayout = this.mPullRefreshLL;
        if (ptrFrameLayout != null) {
            ptrFrameLayout.autoRefresh();
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void showDeleteBars() {
        this.O0000O0o.setVisibility(0);
        this.O0000Oo0.setVisibility(0);
        this.O0000O0o.measure(0, 0);
        this.O0000Oo0.measure(0, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0000O0o, View.Y, (float) (-this.O0000O0o.getMeasuredHeight()), 0.0f);
        ViewGroup viewGroup = (ViewGroup) this.O0000Oo0.getParent();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.O0000Oo0, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - this.O0000Oo0.getMeasuredHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public void hideDeleteBars() {
        this.O0000O0o.setVisibility(8);
        this.O0000Oo0.setVisibility(8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
    public void onBackPressed() {
        try {
            super.onBackPressed();
            gpv.O00000Oo("message_center_red_dot_clicked", true);
            gpv.O00000Oo("my_home_red_dot_clicked", true);
            gpv.O000000o(ServiceApplication.getAppContext(), "new_message_count", 0);
        } catch (Exception unused) {
        }
    }

    public void onDestroy() {
        super.onDestroy();
        guq.O000000o();
        gpv.O000000o(this, "message_center_new_msg_timestamp" + CoreApi.O000000o().O0000o0(), (System.currentTimeMillis() + ServerTimerManager.O000000o(CommonApplication.getAppContext()).O00000Oo()) / 1000);
    }

    public void startLoadData() {
        guw O000000o2 = guw.O000000o();
        long currentTimeMillis = System.currentTimeMillis();
        AnonymousClass9 r1 = new fsm<List<gul>, fso>() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity.AnonymousClass9 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                if (MessageCenterActivity.this.isValid()) {
                    if (MessageCenterActivity.this.mPullRefreshLL.isRefreshing()) {
                        MessageCenterActivity.this.mPullRefreshLL.refreshComplete();
                    }
                    if (MessageCenterActivity.this.f9434O000000o != null) {
                        MessageCenterActivity.this.f9434O000000o.O000000o(list);
                    }
                }
            }

            public final void onFailure(fso fso) {
                String str;
                if (MessageCenterActivity.this.isValid()) {
                    if (MessageCenterActivity.this.mPullRefreshLL.isRefreshing()) {
                        MessageCenterActivity.this.mPullRefreshLL.refreshComplete();
                    }
                    if (MessageCenterActivity.this.f9434O000000o != null) {
                        MessageCenterActivity.this.f9434O000000o.O000000o(guw.O000000o().O000000o(MessageRecordTypeList.queryAll()));
                    }
                    if (!gof.O00000o0()) {
                        hte.O000000o(ServiceApplication.getAppContext(), (int) R.string.popup_select_loc_no_network);
                        return;
                    }
                    Context appContext = ServiceApplication.getAppContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append(ServiceApplication.getAppContext().getResources().getString(R.string.failed_to_load));
                    if (!gfr.O0000OOo || fso == null) {
                        str = "";
                    } else {
                        str = ":" + fso.f17063O000000o + ":" + fso.O00000Oo;
                    }
                    sb.append(str);
                    hte.O000000o(appContext, sb.toString());
                }
            }
        };
        MessageApi.instance.getMessageTypeListV2(ServiceApplication.getAppContext(), currentTimeMillis, 200, new fsm<List<MessageRecordTypeList>, fso>(r1) {
            /* class _m_j.guw.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ fsm f18323O000000o;

            {
                this.f18323O000000o = r2;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                List<gul> O000000o2 = guw.this.O000000o(list);
                fsm fsm = this.f18323O000000o;
                if (fsm != null) {
                    fsm.onSuccess(O000000o2);
                }
                MessageRecordTypeList.deleteAll();
                if (O000000o2 == null || O000000o2.isEmpty()) {
                    guw.this.f18322O000000o = new ArrayList();
                    guw.O000000o(ErrorCode.SUCCESS.getCode());
                    return;
                }
                MessageRecordTypeList.batchInsert(list);
                guw.this.f18322O000000o.addAll(list);
            }

            public final void onFailure(fso fso) {
                fsm fsm = this.f18323O000000o;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
                guw.O000000o(fso == null ? ErrorCode.ERROR_UNLOGIN.getCode() : fso.f17063O000000o);
            }
        });
    }

    public void dismissEditMode() {
        this.O0000oO0 = false;
        this.mCheckedItems.clear();
        hideDeleteBars();
        this.f9434O000000o.notifyDataSetChanged();
    }

    public void selectAll() {
        List<gul> O000000o2 = this.f9434O000000o.O000000o();
        this.mRequestList = O000000o2;
        if (O000000o2 != null && !O000000o2.isEmpty()) {
            for (int i = 0; i < O000000o2.size(); i++) {
                gul gul = O000000o2.get(i);
                if (gul != null) {
                    this.mCheckedItems.add(gul.O00000o0());
                }
            }
            this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
            this.mIvSelectAll.setContentDescription(getString(R.string.unselect_all));
            this.f9434O000000o.notifyDataSetChanged();
            this.mSelectedCntTv.setVisibility(0);
            this.mSelectedCntTv.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size())));
        }
    }

    public void setSelected(String str, boolean z) {
        if (z) {
            this.mCheckedItems.add(str);
        } else {
            this.mCheckedItems.remove(str);
        }
        if (this.mCheckedItems.size() == this.mRequestList.size()) {
            unSelectAll();
        } else {
            selectAll();
        }
    }

    public void unSelectAll() {
        this.mCheckedItems.clear();
        this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.select_all));
        this.f9434O000000o.notifyDataSetChanged();
        this.mSelectedCntTv.setVisibility(8);
    }

    public void deleteSelected() {
        if (this.mCheckedItems.size() == 0) {
            hte.O000000o(this, (int) R.string.not_select_deleted_msg);
            return;
        }
        new MLAlertDialog.Builder(this).O000000o((int) R.string.delete_msg_title).O00000Oo(getResources().getQuantityString(R.plurals.delete_msg, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size()))).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                final ArrayList arrayList = new ArrayList();
                fru.O000000o();
                MessageCenterActivity messageCenterActivity = MessageCenterActivity.this;
                fru.O000000o(messageCenterActivity, -1, (String) null, (String[]) messageCenterActivity.mCheckedItems.toArray(new String[0]), new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity.AnonymousClass2.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        String str;
                        if (MessageCenterActivity.this.isValid()) {
                            MessageCenterActivity messageCenterActivity = MessageCenterActivity.this;
                            StringBuilder sb = new StringBuilder("2132674021");
                            if (!gfr.O0000OOo || fso == null) {
                                str = "";
                            } else {
                                str = ":" + fso.f17063O000000o + ":" + fso.O00000Oo;
                            }
                            sb.append(str);
                            hte.O000000o(messageCenterActivity, sb.toString());
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (MessageCenterActivity.this.isValid()) {
                            MessageCenterActivity.this.mCheckedItems.clear();
                            MessageRecord.batchDelete(arrayList);
                            MessageCenterActivity.this.mSelectedCntTv.setVisibility(8);
                            MessageCenterActivity.this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
                            MessageCenterActivity.this.mIvSelectAll.setContentDescription(MessageCenterActivity.this.getString(R.string.select_all));
                            MessageCenterActivity.this.mLoadingMoreFinished = false;
                        }
                    }
                });
            }
        }).O00000o().show();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0 || !this.O0000oO0) {
            return super.onKeyUp(i, keyEvent);
        }
        dismissEditMode();
        return true;
    }

    public void setNumUpIcon(int i, View view) {
        if (i == 0) {
            try {
                view.setVisibility(4);
            } catch (Throwable unused) {
            }
        } else {
            TextView textView = (TextView) view;
            textView.setVisibility(0);
            if (i <= 99) {
                textView.setText(String.valueOf(i));
                return;
            }
            textView.setText("99+");
            textView.setBackgroundResource(R.drawable.red_point_num);
        }
    }
}
