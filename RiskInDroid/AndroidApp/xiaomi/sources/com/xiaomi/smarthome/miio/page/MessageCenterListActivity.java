package com.xiaomi.smarthome.miio.page;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfr;
import _m_j.ggb;
import _m_j.ggc;
import _m_j.gpv;
import _m_j.gpy;
import _m_j.grv;
import _m_j.gsy;
import _m_j.gtx;
import _m_j.gty;
import _m_j.guf;
import _m_j.guk;
import _m_j.gul;
import _m_j.guw;
import _m_j.gwg;
import _m_j.hte;
import _m_j.hxi;
import _m_j.hzf;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.family.api.MessageApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.smarthome.library.common.widget.viewflow.LoadingMoreView;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import com.xiaomi.smarthome.miio.db.record.MessageRecordTypeList;
import com.xiaomi.smarthome.miio.page.MessageCenterListActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MessageCenterListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O00000Oo f9778O000000o;
    XQProgressDialog O00000Oo;
    long O00000o = 0;
    boolean O00000o0 = true;
    ImageView O00000oO;
    long O00000oo;
    private View O0000O0o;
    private ImageView O0000OOo;
    private TextView O0000Oo;
    private View O0000Oo0;
    private TextView O0000OoO;
    private View O0000Ooo;
    private long O0000o0 = 0;
    private String O0000o00;
    public boolean isSelectAllClicked = false;
    public SparseBooleanArray mCheckedItems = new SparseBooleanArray();
    public boolean mEditMode = false;
    public View mEmptyView;
    public Handler mHandler = new Handler();
    public ImageView mIvSelectAll;
    public PullDownDragListView mList;
    public guf.O000000o mListener = new guf.O000000o() {
        /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass1 */

        public final void O000000o() {
            MessageCenterListActivity.this.mCheckedItems.clear();
            if (MessageCenterListActivity.this.mRequestList.size() == 0) {
                MessageCenterListActivity.this.mEmptyView.setVisibility(0);
                MessageCenterListActivity.this.mList.setVisibility(8);
                MessageCenterListActivity.this.hideDeleteBars();
                MessageCenterListActivity.this.mEditMode = false;
            } else {
                MessageCenterListActivity.this.mEmptyView.setVisibility(8);
                MessageCenterListActivity.this.mList.setVisibility(0);
                MessageCenterListActivity.this.mList.setOnScrollListener(new O000000o() {
                    /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass1.AnonymousClass1 */

                    {
                        MessageCenterListActivity messageCenterListActivity = MessageCenterListActivity.this;
                    }

                    public final boolean O000000o() {
                        return MessageCenterListActivity.this.startLoadMore();
                    }
                });
            }
            MessageCenterListActivity.this.mLoadingMoreView.setVisibility(8);
            MessageCenterListActivity.this.mList.O00000Oo();
            MessageCenterListActivity.this.f9778O000000o.notifyDataSetChanged();
        }

        public final void O000000o(List<gul> list) {
            if (list == null || list.size() == 0) {
                MessageCenterListActivity.this.mLoadingMoreView.setVisibility(8);
                MessageCenterListActivity.this.mLoadingMoreFinished = true;
                return;
            }
            MessageCenterListActivity.this.f9778O000000o.notifyDataSetChanged();
        }

        public final void O000000o(int i) {
            MessageCenterListActivity.this.mCheckedItems.clear();
            MessageCenterListActivity.this.f9778O000000o.notifyDataSetChanged();
            MessageCenterListActivity.this.mList.O00000Oo();
            if (MessageCenterListActivity.this.mRequestList.size() == 0) {
                MessageCenterListActivity.this.mEmptyView.setVisibility(0);
                MessageCenterListActivity.this.mList.setVisibility(8);
            } else {
                MessageCenterListActivity.this.mEmptyView.setVisibility(8);
                MessageCenterListActivity.this.mList.setVisibility(0);
            }
            if (i == 10) {
                MessageCenterListActivity.this.mList.O00000Oo();
            }
        }

        public final void O00000Oo() {
            MessageCenterListActivity.this.mLoadingMoreView.O000000o(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass1.AnonymousClass2 */

                public final void onClick(View view) {
                    MessageCenterListActivity.this.startLoadMore();
                }
            });
        }
    };
    public boolean mLoadingMoreFinished = false;
    public LoadingMoreView mLoadingMoreView;
    public int mMessageType = -1;
    public List<gul> mRequestList = new ArrayList();
    public TextView mSelectedCntTv;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.PullDownDragListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.message_center);
        Intent intent = getIntent();
        if (intent != null) {
            this.mMessageType = intent.getIntExtra("message_type", -1);
        }
        if (this.mMessageType == -1) {
            finish();
            return;
        }
        this.O0000o00 = intent.getStringExtra("message_title");
        this.mList = (PullDownDragListView) findViewById(R.id.share_message_list);
        this.mLoadingMoreView = new LoadingMoreView(this);
        this.mList.addFooterView(this.mLoadingMoreView);
        this.mLoadingMoreView.setVisibility(0);
        this.mList.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass7 */

            public final void startRefresh() {
                MessageCenterListActivity messageCenterListActivity = MessageCenterListActivity.this;
                messageCenterListActivity.O00000o = 0;
                messageCenterListActivity.O000000o();
            }
        });
        this.mList.addHeaderView(LayoutInflater.from(this).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.mList, false));
        this.mEmptyView = findViewById(R.id.common_white_empty_view);
        this.mEmptyView.setVisibility(8);
        ((TextView) findViewById(R.id.common_white_empty_text)).setText((int) R.string.miio_no_message);
        if (!TextUtils.isEmpty(this.O0000o00)) {
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText(this.O0000o00);
        } else {
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.miio_setting_message_center);
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass8 */

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
                MessageCenterListActivity.this.finish();
            }
        });
        this.O00000oO = (ImageView) findViewById(R.id.module_a_3_return_more_more_btn);
        this.O00000oO.setVisibility(8);
        this.O00000oO.setImageResource(R.drawable.common_title_bar_clear);
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass9 */

            public final void onClick(View view) {
                if (MessageCenterListActivity.this.mRequestList.size() != 0) {
                    new MLAlertDialog.Builder(MessageCenterListActivity.this).O00000Oo(MessageCenterListActivity.this.getResources().getString(R.string.log_clear_all_logs)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass9.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            long j = 0;
                            for (gul next : guf.O000000o().O00000o) {
                                if (next.O000000o() > j) {
                                    j = next.O000000o();
                                }
                            }
                            fru.O000000o();
                            fru.O000000o(MessageCenterListActivity.this, j + 1, new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    MessageRecord.deleteAll();
                                    MessageCenterListActivity.this.O000000o();
                                }
                            });
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000o().show();
                }
            }
        });
        this.f9778O000000o = new O00000Oo();
        this.mList.setAdapter((ListAdapter) this.f9778O000000o);
        this.O0000Ooo = findViewById(R.id.title_bar);
        this.O0000O0o = findViewById(R.id.top_delete_bar);
        this.mSelectedCntTv = (TextView) this.O0000O0o.findViewById(R.id.selected_cnt);
        this.O0000OOo = (ImageView) this.O0000O0o.findViewById(R.id.cancel_btn);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass10 */

            public final void onClick(View view) {
                MessageCenterListActivity.this.dismissEditMode();
            }
        });
        this.mIvSelectAll = (ImageView) this.O0000O0o.findViewById(R.id.select_all_btn);
        this.mIvSelectAll.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass11 */

            public final void onClick(View view) {
                if (MessageCenterListActivity.this.mCheckedItems.size() == MessageCenterListActivity.this.mRequestList.size()) {
                    MessageCenterListActivity.this.unSelectAll();
                } else {
                    MessageCenterListActivity.this.selectAll();
                }
                MessageCenterListActivity messageCenterListActivity = MessageCenterListActivity.this;
                messageCenterListActivity.isSelectAllClicked = messageCenterListActivity.mCheckedItems.size() == MessageCenterListActivity.this.mRequestList.size();
                gsy.O000000o(6, "MessageCenterListActivi", "is select all : " + MessageCenterListActivity.this.isSelectAllClicked);
            }
        });
        this.O0000Oo0 = findViewById(R.id.bottom_delete_bar);
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo = (TextView) this.O0000Oo0.findViewById(R.id.delete_msg_btn);
        this.O0000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass12 */

            public final void onClick(View view) {
                MessageCenterListActivity.this.deleteSelected();
            }
        });
        this.O0000Oo.setVisibility(4);
        this.O0000OoO = (TextView) this.O0000Oo0.findViewById(R.id.btm_tip_tv);
        this.O0000OoO.setVisibility(0);
        int i = this.mMessageType;
        if (i == 1) {
            this.O0000OoO.setText((int) R.string.msg_center_list_btm_tips_device_share);
        } else if (i == 5) {
            this.O0000OoO.setText((int) R.string.msg_center_list_btm_tips_family);
        } else if (i == 8) {
            this.O0000OoO.setText((int) R.string.msg_center_list_btm_tips_home_share);
        }
        this.O0000OoO = (TextView) this.O0000Oo0.findViewById(R.id.btm_tip_tv);
        this.O0000OoO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass13 */

            public final void onClick(View view) {
                if (MessageCenterListActivity.this.mMessageType == 1) {
                    if (CoreApi.O000000o().O0000Ooo()) {
                        fbt fbt = new fbt(MessageCenterListActivity.this, "/share/ShareDeviceinfoActivity");
                        fbt.O000000o("user_id", CoreApi.O000000o().O0000o0());
                        fbs.O000000o(fbt);
                        return;
                    }
                    MessageCenterListActivity messageCenterListActivity = MessageCenterListActivity.this;
                    messageCenterListActivity.showLoginDialog(messageCenterListActivity, false);
                } else if (MessageCenterListActivity.this.mMessageType != 5 && MessageCenterListActivity.this.mMessageType == 8) {
                    if (CoreApi.O000000o().O0000Ooo()) {
                        fbt fbt2 = new fbt(MessageCenterListActivity.this, "MultiHomeManagerActivity");
                        fbt2.O000000o("from", 3);
                        fbs.O000000o(fbt2);
                        return;
                    }
                    MessageCenterListActivity messageCenterListActivity2 = MessageCenterListActivity.this;
                    messageCenterListActivity2.showLoginDialog(messageCenterListActivity2, false);
                }
            }
        });
        if (gwg.O000000o((Activity) this)) {
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.O0000O0o);
        }
        this.O00000oo = PreferenceManager.getDefaultSharedPreferences(this).getLong("last_update_time", 0);
        this.O00000o0 = false;
        this.O00000o = 0;
        this.mList.O000000o();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.O00000o0 = false;
        this.O00000o = 0;
        O000000o();
        this.mList.O000000o();
    }

    public Dialog showLoginDialog(final Activity activity, final boolean z) {
        return new MLAlertDialog.Builder(activity).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                gtx O000000o2 = gty.O000000o();
                if (O000000o2 != null) {
                    O000000o2.startLogin(activity, 1, null);
                }
                dialogInterface.dismiss();
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass14 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (z) {
                    activity.finish();
                }
            }
        }).O000000o(true).O00000Oo((int) R.string.loing_helper_title).O00000oo();
    }

    public void showDeleteBars() {
        this.O0000O0o.setVisibility(0);
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo.setVisibility(0);
        this.O0000OoO.setVisibility(8);
        this.O0000O0o.measure(0, 0);
        this.O0000Oo0.measure(0, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0000O0o, View.TRANSLATION_Y, (float) (-this.O0000O0o.getMeasuredHeight()), 0.0f);
        ViewGroup viewGroup = (ViewGroup) this.O0000Oo0.getParent();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.O0000Oo0, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - this.O0000Oo0.getMeasuredHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public void hideDeleteBars() {
        this.O0000O0o.setVisibility(8);
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo.setVisibility(4);
        this.O0000OoO.setVisibility(0);
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
    }

    public boolean startLoadMore() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.O0000o0 < 800) {
            return false;
        }
        this.O0000o0 = currentTimeMillis;
        O00000Oo o00000Oo = this.f9778O000000o;
        gul gul = (gul) o00000Oo.getItem(o00000Oo.getCount() - 1);
        if (gul == null || this.mLoadingMoreFinished || this.mEditMode) {
            return false;
        }
        this.mLoadingMoreView.setVisibility(0);
        this.mLoadingMoreView.O000000o();
        MessageApi.instance.getMessageListOfType(this, this.mMessageType, gul.O000000o() - 1, 100, new fsm<List<MessageRecordTypeList>, fso>() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                if (MessageCenterListActivity.this.isValid()) {
                    MessageCenterListActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            if (MessageCenterListActivity.this.isValid()) {
                                MessageCenterListActivity.this.mLoadingMoreView.setVisibility(8);
                                guf.O000000o o000000o = MessageCenterListActivity.this.mListener;
                                MessageCenterListActivity.this.mRequestList.size();
                                o000000o.O000000o();
                            }
                        }
                    });
                    List<gul> O000000o2 = guw.O000000o().O000000o(list);
                    if (O000000o2 == null || O000000o2.isEmpty()) {
                        MessageCenterListActivity.this.mLoadingMoreFinished = true;
                    } else {
                        MessageCenterListActivity.this.mRequestList.addAll(O000000o2);
                    }
                }
            }

            public final void onFailure(fso fso) {
                String str;
                if (MessageCenterListActivity.this.isValid()) {
                    MessageCenterListActivity.this.mListener.O00000Oo();
                    MessageCenterListActivity messageCenterListActivity = MessageCenterListActivity.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(ServiceApplication.getAppContext().getResources().getString(R.string.failed_to_load));
                    if (!gfr.O0000OOo || fso == null) {
                        str = "";
                    } else {
                        str = ":" + fso.f17063O000000o + ":" + fso.O00000Oo;
                    }
                    sb.append(str);
                    hte.O000000o(messageCenterListActivity, sb.toString());
                    MessageCenterListActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass3.AnonymousClass2 */

                        public final void run() {
                            MessageCenterListActivity.this.mLoadingMoreView.O000000o(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass3.AnonymousClass2.AnonymousClass1 */

                                public final void onClick(View view) {
                                    MessageCenterListActivity.this.startLoadMore();
                                }
                            });
                        }
                    });
                }
            }
        });
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (this.O00000o0 || this.O00000o <= 0) {
            HashSet hashSet = new HashSet();
            StringBuilder sb = new StringBuilder();
            sb.append(this.mMessageType);
            hashSet.add(sb.toString());
            MessageApi.instance.getMessageListOfType(this, this.mMessageType, 0, 100, new fsm<List<MessageRecordTypeList>, fso>() {
                /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    if (MessageCenterListActivity.this.isValid()) {
                        List<gul> O000000o2 = guw.O000000o().O000000o(list);
                        if (O000000o2 == null || O000000o2.isEmpty()) {
                            MessageCenterListActivity.this.mRequestList = new ArrayList();
                        } else {
                            MessageCenterListActivity.this.mRequestList = O000000o2;
                        }
                        MessageCenterListActivity.this.mHandler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                if (MessageCenterListActivity.this.isValid()) {
                                    guf.O000000o o000000o = MessageCenterListActivity.this.mListener;
                                    MessageCenterListActivity.this.mRequestList.size();
                                    o000000o.O000000o();
                                }
                            }
                        });
                    }
                }

                public final void onFailure(fso fso) {
                    String str;
                    if (MessageCenterListActivity.this.isValid()) {
                        MessageCenterListActivity messageCenterListActivity = MessageCenterListActivity.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(ServiceApplication.getAppContext().getResources().getString(R.string.failed_to_load));
                        if (!gfr.O0000OOo || fso == null) {
                            str = "";
                        } else {
                            str = ":" + fso.f17063O000000o + ":" + fso.O00000Oo;
                        }
                        sb.append(str);
                        hte.O000000o(messageCenterListActivity, sb.toString());
                    }
                }
            });
            return;
        }
        this.mList.O00000Oo();
    }

    public void dismissEditMode() {
        this.mList.setPullDownEnabled(true);
        this.mEditMode = false;
        this.mCheckedItems.clear();
        hideDeleteBars();
        this.isSelectAllClicked = false;
        this.mCheckedItems.clear();
        this.f9778O000000o.notifyDataSetChanged();
    }

    public void selectAll() {
        int size = this.mRequestList.size();
        for (int i = 0; i < size; i++) {
            this.mCheckedItems.put(i, true);
        }
        this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.unselect_all));
        this.f9778O000000o.notifyDataSetChanged();
        this.mSelectedCntTv.setVisibility(0);
        this.mSelectedCntTv.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size())));
    }

    public void unSelectAll() {
        this.mCheckedItems.clear();
        this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.select_all));
        this.f9778O000000o.notifyDataSetChanged();
        this.mSelectedCntTv.setVisibility(8);
    }

    public void deleteSelected() {
        if (this.mCheckedItems.size() == 0) {
            hte.O000000o(this, (int) R.string.not_select_deleted_msg);
            return;
        }
        new MLAlertDialog.Builder(this).O000000o((int) R.string.delete_msg_title).O00000Oo(getResources().getQuantityString(R.plurals.delete_msg, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size()))).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                final ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < MessageCenterListActivity.this.mCheckedItems.size(); i2++) {
                    int keyAt = MessageCenterListActivity.this.mCheckedItems.keyAt(i2);
                    if (MessageCenterListActivity.this.mCheckedItems.get(keyAt) && MessageCenterListActivity.this.mRequestList.size() > keyAt) {
                        try {
                            arrayList.add(MessageCenterListActivity.this.mRequestList.get(keyAt).O00000o0());
                        } catch (Exception unused) {
                        }
                    }
                }
                fru.O000000o();
                MessageCenterListActivity messageCenterListActivity = MessageCenterListActivity.this;
                fru.O000000o(messageCenterListActivity, messageCenterListActivity.mMessageType, (String) null, (String[]) arrayList.toArray(new String[0]), new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass5.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        MessageCenterListActivity.this.mCheckedItems.clear();
                        MessageRecord.batchDelete(arrayList);
                        MessageCenterListActivity.this.O000000o();
                        MessageCenterListActivity.this.mSelectedCntTv.setVisibility(8);
                        MessageCenterListActivity.this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
                        MessageCenterListActivity.this.mIvSelectAll.setContentDescription(MessageCenterListActivity.this.getString(R.string.select_all));
                        MessageCenterListActivity.this.mList.setSelectionAfterHeaderView();
                        MessageCenterListActivity.this.mLoadingMoreFinished = false;
                    }
                });
            }
        }).O00000o().show();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0 || !this.mEditMode) {
            return super.onKeyUp(i, keyEvent);
        }
        dismissEditMode();
        return true;
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f9809O000000o;
        SimpleDraweeView O00000Oo;
        CheckBox O00000o;
        TextView O00000o0;
        TextView O00000oO;
        TextView O00000oo;
        View O0000O0o;

        O00000o0() {
        }
    }

    class O00000Oo extends BaseAdapter {
        public final long getItemId(int i) {
            return 0;
        }

        O00000Oo() {
        }

        public final void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            if (MessageCenterListActivity.this.mEditMode) {
                MessageCenterListActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.miio.page.$$Lambda$MessageCenterListActivity$O00000Oo$OWmyDIOK23Bj_lQbt1bzH8QxLhw */

                    public final void run() {
                        MessageCenterListActivity.O00000Oo.this.O000000o();
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o() {
            if (MessageCenterListActivity.this.mEditMode && MessageCenterListActivity.this.isSelectAllClicked) {
                MessageCenterListActivity.this.mSelectedCntTv.setVisibility(0);
                MessageCenterListActivity.this.mSelectedCntTv.setText(MessageCenterListActivity.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, MessageCenterListActivity.this.mRequestList.size(), Integer.valueOf(MessageCenterListActivity.this.mRequestList.size())));
            } else if (MessageCenterListActivity.this.mEditMode) {
                MessageCenterListActivity.this.mSelectedCntTv.setVisibility(0);
                MessageCenterListActivity.this.mSelectedCntTv.setText(MessageCenterListActivity.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, MessageCenterListActivity.this.mCheckedItems.size(), Integer.valueOf(MessageCenterListActivity.this.mCheckedItems.size())));
            }
        }

        public final int getCount() {
            return MessageCenterListActivity.this.mRequestList.size();
        }

        public final Object getItem(int i) {
            if (i < 0 || i >= MessageCenterListActivity.this.mRequestList.size()) {
                return null;
            }
            return MessageCenterListActivity.this.mRequestList.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(final int i, View view, ViewGroup viewGroup) {
            O00000o0 o00000o0;
            if (view == null) {
                view = LayoutInflater.from(MessageCenterListActivity.this).inflate((int) R.layout.message_item_new, viewGroup, false);
                o00000o0 = new O00000o0();
                o00000o0.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.device_icon);
                o00000o0.O00000Oo.setHierarchy(new GenericDraweeHierarchyBuilder(o00000o0.O00000Oo.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build());
                o00000o0.O00000o0 = (TextView) view.findViewById(R.id.right_tv);
                o00000o0.O00000o = (CheckBox) view.findViewById(R.id.ratio_btn);
                o00000o0.O00000oO = (TextView) view.findViewById(R.id.device_item);
                o00000o0.O00000oo = (TextView) view.findViewById(R.id.device_item_info);
                o00000o0.f9809O000000o = view.findViewById(R.id.right_fl);
                o00000o0.O0000O0o = view.findViewById(R.id.new_message_tag);
                view.setTag(o00000o0);
            } else {
                o00000o0 = (O00000o0) view.getTag();
            }
            final gul gul = MessageCenterListActivity.this.mRequestList.get(i);
            gul.O000000o(o00000o0.O00000oO);
            gul.O00000Oo(o00000o0.O00000oo);
            gul.O000000o(o00000o0.O00000Oo);
            if (gul.O00000o()) {
                o00000o0.O00000oO.setTextColor(MessageCenterListActivity.this.getResources().getColor(R.color.mj_color_black_80_transparent));
                o00000o0.O00000oo.setTextColor(MessageCenterListActivity.this.getResources().getColor(R.color.mj_color_black_50_transparent));
            } else {
                o00000o0.O00000oO.setTextColor(MessageCenterListActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                o00000o0.O00000oo.setTextColor(MessageCenterListActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
            }
            view.findViewById(R.id.arrow).setVisibility(8);
            o00000o0.O00000o.setClickable(false);
            o00000o0.O00000o.setFocusable(false);
            o00000o0.O00000o0.setOnClickListener(null);
            if (MessageCenterListActivity.this.mEditMode) {
                o00000o0.f9809O000000o.setVisibility(0);
                o00000o0.O00000o.setVisibility(0);
                o00000o0.O00000o0.setVisibility(8);
                if (MessageCenterListActivity.this.isSelectAllClicked) {
                    MessageCenterListActivity.this.mCheckedItems.put(i, true);
                }
                if (MessageCenterListActivity.this.mCheckedItems.get(i)) {
                    o00000o0.O00000o.setChecked(true);
                } else {
                    o00000o0.O00000o.setChecked(false);
                }
            } else {
                o00000o0.f9809O000000o.setVisibility(0);
                o00000o0.O00000o.setVisibility(8);
                o00000o0.O00000o0.setVisibility(0);
                if (!gul.O00000Oo()) {
                    o00000o0.O00000o0.setTextColor(MessageCenterListActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                    float f = MessageCenterListActivity.this.getResources().getDisplayMetrics().density;
                    int i2 = (int) (15.0f * f);
                    int i3 = (int) (f * 7.0f);
                    o00000o0.O00000o0.setPadding(i2, i3, i2, i3);
                    o00000o0.O00000o0.setBackgroundResource(0);
                    gul.O00000o0(o00000o0.O00000o0);
                    if (o00000o0.O00000o0.getVisibility() == 8) {
                        o00000o0.f9809O000000o.setVisibility(8);
                    }
                } else {
                    o00000o0.O00000o0.setTextColor(MessageCenterListActivity.this.getResources().getColorStateList(R.color.selector_common_text));
                    o00000o0.O00000o0.setBackgroundResource(R.drawable.selector_common_btn);
                    float f2 = MessageCenterListActivity.this.getResources().getDisplayMetrics().density;
                    int i4 = (int) (15.0f * f2);
                    int i5 = (int) (f2 * 7.0f);
                    o00000o0.O00000o0.setPadding(i4, i5, i4, i5);
                    o00000o0.O00000o0.setText((int) R.string.smarthome_share_accept);
                    o00000o0.O00000o0.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.O00000Oo.AnonymousClass1 */

                        public final void onClick(View view) {
                            MessageCenterListActivity.this.O00000Oo = new XQProgressDialog(MessageCenterListActivity.this);
                            MessageCenterListActivity.this.O00000Oo.setCancelable(false);
                            MessageCenterListActivity.this.O00000Oo.setMessage(MessageCenterListActivity.this.getResources().getString(R.string.loading_share_info));
                            MessageCenterListActivity.this.O00000Oo.show();
                            MessageCenterListActivity.this.O00000Oo.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.O00000Oo.AnonymousClass1.AnonymousClass1 */

                                public final void onDismiss(DialogInterface dialogInterface) {
                                    try {
                                        MessageCenterListActivity.this.O000000o();
                                        if (gul instanceof guk.O000000o) {
                                            MessageCenterListActivity.this.showChangeHomeDialog(String.valueOf(((guk.O000000o) gul).f18300O000000o));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            gul.O000000o(MessageCenterListActivity.this.O00000Oo);
                        }
                    });
                }
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.O00000Oo.AnonymousClass2 */

                public final void onClick(View view) {
                    if (MessageCenterListActivity.this.mEditMode) {
                        ((CheckBox) view.findViewById(R.id.ratio_btn)).toggle();
                        if (!MessageCenterListActivity.this.mCheckedItems.get(i)) {
                            MessageCenterListActivity.this.mCheckedItems.put(i, true);
                        } else {
                            MessageCenterListActivity.this.mCheckedItems.delete(i);
                        }
                        if (MessageCenterListActivity.this.mCheckedItems.size() == MessageCenterListActivity.this.mRequestList.size()) {
                            MessageCenterListActivity.this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
                            MessageCenterListActivity.this.mIvSelectAll.setContentDescription(MessageCenterListActivity.this.getString(R.string.unselect_all));
                        } else {
                            MessageCenterListActivity.this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
                            MessageCenterListActivity.this.mIvSelectAll.setContentDescription(MessageCenterListActivity.this.getString(R.string.select_all));
                        }
                        if (MessageCenterListActivity.this.mCheckedItems.size() > 0) {
                            MessageCenterListActivity.this.mSelectedCntTv.setVisibility(0);
                            MessageCenterListActivity.this.mSelectedCntTv.setText(MessageCenterListActivity.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, MessageCenterListActivity.this.mCheckedItems.size(), Integer.valueOf(MessageCenterListActivity.this.mCheckedItems.size())));
                        } else {
                            MessageCenterListActivity.this.mSelectedCntTv.setVisibility(0);
                            MessageCenterListActivity.this.mSelectedCntTv.setText(MessageCenterListActivity.this.getString(R.string.selected_0_cnt_tips));
                        }
                        MessageCenterListActivity.this.isSelectAllClicked = false;
                        return;
                    }
                    MessageCenterListActivity.this.mRequestList.get(i).O000000o(MessageCenterListActivity.this);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.O00000Oo.AnonymousClass3 */

                public final boolean onLongClick(View view) {
                    if (MessageCenterListActivity.this.mEditMode) {
                        return false;
                    }
                    MessageCenterListActivity.this.mList.setPullDownEnabled(false);
                    MessageCenterListActivity.this.showDeleteBars();
                    MessageCenterListActivity.this.mEditMode = true;
                    MessageCenterListActivity.this.mCheckedItems.put(i, true);
                    O00000Oo.this.notifyDataSetChanged();
                    return true;
                }
            });
            return view;
        }
    }

    public void showChangeHomeDialog(String str) {
        final Home O00000o2 = ggb.O00000Oo().O00000o(str);
        if (O00000o2 != null) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            String string = getString(R.string.home_share_response_success1);
            ggb.O00000Oo();
            builder.O00000Oo(String.format(string, ggb.O000000o(O00000o2))).O000000o((int) R.string.view_now, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass6 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void
                 arg types: [android.content.Context, java.lang.String, java.lang.String, int]
                 candidates:
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void */
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Context appContext = ServiceApplication.getAppContext();
                    gpy.O00000Oo(appContext, "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "show_change_home_red_dot", false);
                    ggc.O000000o().O00000oo.onNext(Boolean.FALSE);
                    MessageCenterListActivity.this.O00000Oo.show();
                    MessageCenterListActivity.this.O00000Oo.setOnDismissListener(null);
                    ggb.O00000Oo().O000000o(O00000o2.getId(), new fsm() {
                        /* class com.xiaomi.smarthome.miio.page.MessageCenterListActivity.AnonymousClass6.AnonymousClass1 */

                        public final void onSuccess(Object obj) {
                            if (MessageCenterListActivity.this.isValid()) {
                                if (MessageCenterListActivity.this.O00000Oo != null) {
                                    MessageCenterListActivity.this.O00000Oo.dismiss();
                                }
                                fbt fbt = new fbt(MessageCenterListActivity.this, "SmartHomeMainActivity");
                                fbt.O00000Oo(67108864);
                                fbs.O000000o(fbt);
                                hxi.O00000o.O00000oO(2);
                            }
                        }

                        public final void onFailure(fso fso) {
                            if (MessageCenterListActivity.this.O00000Oo != null) {
                                MessageCenterListActivity.this.O00000Oo.dismiss();
                            }
                            hxi.O00000o.O0000Ooo();
                        }
                    });
                }
            }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
        }
    }

    public abstract class O000000o implements AbsListView.OnScrollListener {

        /* renamed from: O000000o  reason: collision with root package name */
        private int f9803O000000o = 5;
        private int O00000o = 0;
        private int O00000o0 = 0;
        private boolean O00000oO = true;
        private int O00000oo = 0;

        public abstract boolean O000000o();

        public O000000o() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i3 < this.O00000o) {
                this.O00000o0 = this.O00000oo;
                this.O00000o = i3;
                if (i3 == 0) {
                    this.O00000oO = true;
                }
            }
            if (this.O00000oO && i3 > this.O00000o) {
                this.O00000oO = false;
                this.O00000o = i3;
                this.O00000o0++;
            }
            if (!MessageCenterListActivity.this.mLoadingMoreFinished && !this.O00000oO && absListView.getLastVisiblePosition() == ((ListAdapter) absListView.getAdapter()).getCount() - 1 && absListView.getChildAt(absListView.getChildCount() - 1).getBottom() <= absListView.getHeight()) {
                this.O00000oO = O000000o();
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            View currentFocus;
            if (1 == i && (currentFocus = MessageCenterListActivity.this.getCurrentFocus()) != null) {
                currentFocus.clearFocus();
            }
        }
    }
}
