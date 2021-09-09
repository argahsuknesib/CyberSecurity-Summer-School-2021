package com.xiaomi.smarthome.feedback;

import _m_j.fsi;
import _m_j.fsj;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gwg;
import _m_j.hzf;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.feedback.view.BatchBar;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import java.util.HashSet;
import java.util.List;

public class FeedbackHistoryActivity extends BaseActivity implements BatchBar.O000000o {
    public List<fsi.O000000o> feebackHistoryDatas;
    public BatchBar mBatchBar;
    public View mEmptyView;
    public O000000o mHistoryAdapter;
    public CustomPullDownRefreshListView mHistoryListView;
    public ProgressBar mProgressBar;
    public View space;

    public View getContentViewOfBatchActionBar() {
        return null;
    }

    public View getContentViewOfBatchSelectBar() {
        return null;
    }

    public void onStartBatchMode() {
    }

    public void onUpdateBatchBarViewState(int i) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.feedback_history_layout);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (textView != null) {
            textView.setText((int) R.string.feedback_history);
        }
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass6 */

                public final void onClick(View view) {
                    FeedbackHistoryActivity.this.finish();
                }
            });
        }
        this.mHistoryAdapter = new O000000o();
        this.mHistoryListView = (CustomPullDownRefreshListView) findViewById(R.id.pull_down_lv_feedback_history);
        this.mHistoryListView.O00000Oo();
        this.mProgressBar = (ProgressBar) findViewById(R.id.pb_loading);
        this.mBatchBar = new BatchBar(getContext());
        this.mEmptyView = findViewById(R.id.tv_empty_view);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.batch_select_bar);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.batch_action_bar);
        if (viewGroup != null && gwg.O000000o((Activity) this)) {
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), viewGroup);
        }
        BatchBar batchBar = this.mBatchBar;
        batchBar.f7420O000000o = new fsj(batchBar.O00000Oo, viewGroup, viewGroup2);
        this.mBatchBar.O0000Oo = this;
        this.mHistoryListView.setAdapter((ListAdapter) this.mHistoryAdapter);
        this.mHistoryListView.setOnScrollListener(new O00000Oo(new Runnable() {
            /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass1 */

            public final void run() {
                if (!FeedbackManager.INSTANCE.isLoadingHistory() && !FeedbackManager.INSTANCE.isAllLoaded()) {
                    FeedbackHistoryActivity.this.mProgressBar.setVisibility(0);
                    FeedbackHistoryActivity.this.loadMoreHistoryData();
                }
            }
        }));
        this.mHistoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass2 */

            /* JADX WARN: Type inference failed for: r2v1, types: [android.widget.Adapter] */
            /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
                	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
                	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
                	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
                	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
                	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
                	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
                */
            public final void onItemClick(android.widget.AdapterView<?> r2, android.view.View r3, int r4, long r5) {
                /*
                    r1 = this;
                    java.lang.Object r3 = r3.getTag()
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity$O00000o0 r3 = (com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.O00000o0) r3
                    if (r3 != 0) goto L_0x0009
                    return
                L_0x0009:
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    java.util.List<_m_j.fsi$O000000o> r5 = r5.feebackHistoryDatas
                    if (r5 == 0) goto L_0x0067
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    java.util.List<_m_j.fsi$O000000o> r5 = r5.feebackHistoryDatas
                    int r5 = r5.size()
                    if (r5 > 0) goto L_0x001a
                    goto L_0x0067
                L_0x001a:
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    com.xiaomi.smarthome.feedback.view.BatchBar r5 = r5.mBatchBar
                    boolean r5 = r5.O0000OoO
                    if (r5 == 0) goto L_0x0037
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r2 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    com.xiaomi.smarthome.feedback.view.BatchBar r2 = r2.mBatchBar
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r3 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView r3 = r3.mHistoryListView
                    int r3 = r3.getHeaderViewsCount()
                    int r4 = r4 - r3
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
                    r2.O000000o(r3)
                    return
                L_0x0037:
                    android.content.Intent r5 = new android.content.Intent
                    r5.<init>()
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r6 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    android.content.Context r6 = r6.getContext()
                    java.lang.Class<com.xiaomi.smarthome.feedback.FeedbackDetailActivity> r0 = com.xiaomi.smarthome.feedback.FeedbackDetailActivity.class
                    r5.setClass(r6, r0)
                    android.widget.Adapter r2 = r2.getAdapter()
                    java.lang.Object r2 = r2.getItem(r4)
                    _m_j.fsi$O000000o r2 = (_m_j.fsi.O000000o) r2
                    java.lang.String r4 = r2.f17054O000000o
                    java.lang.String r6 = "extra_id"
                    r5.putExtra(r6, r4)
                    android.view.View r3 = r3.O00000o0
                    r4 = 8
                    r3.setVisibility(r4)
                    r3 = 0
                    r2.O00000o0 = r3
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r2 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    r2.startActivity(r5)
                L_0x0067:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass2.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
        this.mHistoryListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass3 */

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FeedbackHistoryActivity.this.mHistoryListView.O00000o || FeedbackHistoryActivity.this.feebackHistoryDatas == null || FeedbackHistoryActivity.this.feebackHistoryDatas.size() <= 0) {
                    return false;
                }
                if (!FeedbackHistoryActivity.this.mBatchBar.O0000OoO) {
                    BatchBar batchBar = FeedbackHistoryActivity.this.mBatchBar;
                    batchBar.O0000Ooo = FeedbackHistoryActivity.this.mHistoryAdapter;
                    batchBar.O0000o00.clear();
                    batchBar.O0000OoO = true;
                    if (batchBar.O00000oO == null) {
                        if (batchBar.O0000Oo != null) {
                            batchBar.O00000oO = batchBar.O0000Oo.getContentViewOfBatchSelectBar();
                        }
                        if (batchBar.O00000oO == null) {
                            batchBar.O00000o0 = true;
                            batchBar.O00000oO = LayoutInflater.from(batchBar.O00000Oo).inflate((int) R.layout.batch_select_bar, (ViewGroup) null);
                            batchBar.O00000oO.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.feedback.view.BatchBar.AnonymousClass1 */

                                public final void onClick(View view) {
                                    BatchBar.this.O000000o(0);
                                }
                            });
                            batchBar.O0000O0o = (ImageView) batchBar.O00000oO.findViewById(R.id.btn_select_all);
                            batchBar.O0000O0o.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.feedback.view.BatchBar.AnonymousClass2 */

                                public final void onClick(View view) {
                                    if (((Boolean) BatchBar.this.O0000O0o.getTag()).booleanValue()) {
                                        for (int i = 0; i < BatchBar.this.O0000Ooo.getCount(); i++) {
                                            BatchBar.this.O0000o00.add(Integer.valueOf(i));
                                        }
                                        BatchBar.this.O0000O0o.setImageResource(R.drawable.un_select_selector);
                                        BatchBar.this.O0000O0o.setContentDescription(BatchBar.this.O00000Oo.getString(R.string.unselect_all));
                                        BatchBar.this.O0000O0o.setTag(Boolean.FALSE);
                                    } else {
                                        BatchBar.this.O0000o00.clear();
                                        BatchBar.this.O0000O0o.setImageResource(R.drawable.all_select_selector);
                                        BatchBar.this.O0000O0o.setContentDescription(BatchBar.this.O00000Oo.getString(R.string.select_all));
                                        BatchBar.this.O0000O0o.setTag(Boolean.TRUE);
                                    }
                                    BatchBar.this.O000000o();
                                    BatchBar.this.O0000Ooo.notifyDataSetChanged();
                                }
                            });
                            batchBar.O0000OOo = (TextView) batchBar.O00000oO.findViewById(R.id.text_prompt);
                        }
                    }
                    if (batchBar.O00000oo == null) {
                        if (batchBar.O0000Oo != null) {
                            batchBar.O00000oo = batchBar.O0000Oo.getContentViewOfBatchActionBar();
                        }
                        if (batchBar.O00000oo == null) {
                            batchBar.O00000o = true;
                            batchBar.O00000oo = LayoutInflater.from(batchBar.O00000Oo).inflate((int) R.layout.batch_action_bar, (ViewGroup) null);
                            batchBar.O0000Oo0 = batchBar.O00000oo.findViewById(R.id.btn_ok);
                            batchBar.O0000Oo0.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.feedback.view.BatchBar.AnonymousClass3 */

                                public final void onClick(View view) {
                                    BatchBar.this.O000000o(1);
                                }
                            });
                        }
                    }
                    batchBar.f7420O000000o.O000000o();
                    fsj fsj = batchBar.f7420O000000o;
                    View view2 = batchBar.O00000oO;
                    View view3 = batchBar.O00000oo;
                    if (!(fsj.f17055O000000o == null || view2 == null)) {
                        fsj.f17055O000000o.addView(view2);
                        fsj.O00000o0 = view2;
                        fsj.O00000o0.setVisibility(8);
                    }
                    if (!(fsj.O00000Oo == null || view3 == null)) {
                        fsj.O00000o = view3;
                        fsj.O00000o.setVisibility(8);
                        fsj.O00000Oo.addView(view3);
                    }
                    batchBar.f7420O000000o.O00000oO = batchBar.O0000o0O;
                    batchBar.f7420O000000o.O00000oo = batchBar.O0000o0o;
                    fsj fsj2 = batchBar.f7420O000000o;
                    if (fsj2.O00000o0 != null) {
                        fsj2.O0000Oo0 = true;
                        fsj2.O00000o0.startAnimation(fsj2.O0000O0o);
                        fsj2.O00000o0.setVisibility(0);
                    }
                    if (fsj2.O00000o != null) {
                        if (fsj2.O00000o0 == null) {
                            fsj2.O0000Oo0 = false;
                        }
                        fsj2.O00000o.startAnimation(fsj2.O0000OOo);
                        fsj2.O00000o.setVisibility(0);
                    }
                }
                if (FeedbackHistoryActivity.this.mBatchBar.O0000OoO) {
                    FeedbackHistoryActivity.this.mBatchBar.O000000o(Integer.valueOf(i - FeedbackHistoryActivity.this.mHistoryListView.getHeaderViewsCount()));
                }
                return true;
            }
        });
        this.space = LayoutInflater.from(this).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.mHistoryListView, false);
        loadHistoryData();
    }

    public void loadHistoryData() {
        FeedbackManager.INSTANCE.loadFeedbackHistory(getContext(), new fsm<List<fsi.O000000o>, fso>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                final List list = (List) obj;
                FeedbackHistoryActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        FeedbackHistoryActivity.this.feebackHistoryDatas = list;
                        FeedbackHistoryActivity.this.mHistoryAdapter.notifyDataSetChanged();
                        if (list.size() == 0) {
                            FeedbackHistoryActivity.this.mEmptyView.setVisibility(0);
                        } else {
                            FeedbackHistoryActivity.this.mEmptyView.setVisibility(8);
                            FeedbackHistoryActivity.this.mHistoryListView.addHeaderView(FeedbackHistoryActivity.this.space);
                        }
                        FeedbackHistoryActivity.this.mHistoryListView.O00000Oo();
                    }
                });
            }

            public final void onFailure(fso fso) {
                FeedbackHistoryActivity.this.mHistoryListView.O00000Oo();
            }
        });
    }

    public void loadMoreHistoryData() {
        FeedbackManager.INSTANCE.loadMoreFeedbackHistory(getContext(), new fsm<List<fsi.O000000o>, fso>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                final List list = (List) obj;
                FeedbackHistoryActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        FeedbackHistoryActivity.this.feebackHistoryDatas = list;
                        FeedbackHistoryActivity.this.mProgressBar.setVisibility(8);
                        FeedbackHistoryActivity.this.mHistoryAdapter.notifyDataSetChanged();
                        FeedbackHistoryActivity.this.mHistoryListView.O00000Oo();
                    }
                });
            }

            public final void onFailure(fso fso) {
                FeedbackHistoryActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass5.AnonymousClass2 */

                    public final void run() {
                        FeedbackHistoryActivity.this.mProgressBar.setVisibility(8);
                        FeedbackHistoryActivity.this.mHistoryListView.O00000Oo();
                    }
                });
            }
        });
        this.mProgressBar.setVisibility(0);
    }

    public void onExitBatchMode(int i, BaseAdapter baseAdapter) {
        if (i == 1) {
            BatchBar batchBar = this.mBatchBar;
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.addAll(batchBar.O0000o00);
            if (!hashSet.isEmpty()) {
                String[] strArr = new String[hashSet.size()];
                int i2 = 0;
                for (Integer intValue : hashSet) {
                    strArr[i2] = this.feebackHistoryDatas.get(intValue.intValue()).f17054O000000o;
                    i2++;
                }
                FeedbackApi.INSTANCE.deleteFeedback(getContext(), strArr, new fsm<Boolean, fso>() {
                    /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass7 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        FeedbackHistoryActivity.this.mHandler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass7.AnonymousClass1 */

                            public final void run() {
                                FeedbackHistoryActivity.this.loadHistoryData();
                            }
                        });
                    }
                });
            }
        }
    }

    public void onBackPressed() {
        BatchBar batchBar = this.mBatchBar;
        if (batchBar == null || !batchBar.O0000OoO) {
            super.onBackPressed();
        } else {
            this.mBatchBar.O000000o(0);
        }
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f7414O000000o;
        TextView O00000Oo;
        View O00000o;
        View O00000o0;
        CheckBox O00000oO;

        O00000o0() {
        }
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return 0;
        }

        O000000o() {
        }

        public final int getCount() {
            if (FeedbackHistoryActivity.this.feebackHistoryDatas == null) {
                return 0;
            }
            return FeedbackHistoryActivity.this.feebackHistoryDatas.size();
        }

        public final Object getItem(int i) {
            return FeedbackHistoryActivity.this.feebackHistoryDatas.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000o0 o00000o0;
            fsi.O000000o o000000o;
            String str;
            if (view == null) {
                view = LayoutInflater.from(FeedbackHistoryActivity.this.getContext()).inflate((int) R.layout.feedback_history_item, viewGroup, false);
                o00000o0 = new O00000o0();
                o00000o0.O00000o0 = view.findViewById(R.id.red_point);
                o00000o0.O00000o = view.findViewById(R.id.right_hint);
                o00000o0.f7414O000000o = (TextView) view.findViewById(R.id.feedback_title);
                o00000o0.O00000Oo = (TextView) view.findViewById(R.id.feedback_desc);
                o00000o0.O00000oO = (CheckBox) view.findViewById(R.id.ckb_edit_selected);
                view.setTag(o00000o0);
            } else {
                o00000o0 = (O00000o0) view.getTag();
            }
            if (!(FeedbackHistoryActivity.this.feebackHistoryDatas == null || (o000000o = FeedbackHistoryActivity.this.feebackHistoryDatas.get(i)) == null)) {
                if (i == getCount() - 1) {
                    view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding_no_left_margin);
                } else {
                    view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding);
                }
                if (o000000o.O00000oo != null && !o000000o.O00000oo.isEmpty()) {
                    o00000o0.f7414O000000o.setText(o000000o.O00000oo);
                }
                if (FeedbackHistoryActivity.this.mBatchBar.O0000OoO) {
                    o00000o0.O00000o0.setVisibility(8);
                    o00000o0.O00000o.setVisibility(8);
                    o00000o0.O00000oO.setVisibility(0);
                    if (FeedbackHistoryActivity.this.mBatchBar.O0000o00.contains(Integer.valueOf(i))) {
                        o00000o0.O00000oO.setChecked(true);
                    } else {
                        o00000o0.O00000oO.setChecked(false);
                    }
                } else {
                    o00000o0.O00000oO.setVisibility(8);
                    if (o000000o.O00000o0) {
                        o00000o0.O00000o0.setVisibility(0);
                        o00000o0.O00000o.setVisibility(8);
                    } else {
                        o00000o0.O00000o0.setVisibility(8);
                        o00000o0.O00000o.setVisibility(0);
                    }
                }
                String feedbackDeviceName = FeedbackManager.INSTANCE.getFeedbackDeviceName(FeedbackHistoryActivity.this.getContext(), o000000o.O00000o);
                if (feedbackDeviceName != null) {
                    str = String.format("%s | %s", feedbackDeviceName, o000000o.O00000Oo);
                } else {
                    str = o000000o.O00000Oo;
                }
                if (str != null) {
                    o00000o0.O00000Oo.setText(str);
                }
            }
            return view;
        }
    }

    public class O00000Oo implements AbsListView.OnScrollListener {
        private Runnable O00000Oo;
        private boolean O00000o = false;
        private boolean O00000o0 = false;
        private boolean O00000oO = false;

        public O00000Oo(Runnable runnable) {
            this.O00000Oo = runnable;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            this.O00000o0 = i3 == i + i2;
            if (i3 != i2) {
                z = false;
            }
            this.O00000o = z;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && this.O00000o0 && this.O00000Oo != null) {
                if (this.O00000oO || !this.O00000o) {
                    this.O00000Oo.run();
                }
            }
        }
    }
}
