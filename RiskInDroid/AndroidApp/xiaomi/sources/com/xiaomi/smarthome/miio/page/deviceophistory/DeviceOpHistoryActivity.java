package com.xiaomi.smarthome.miio.page.deviceophistory;

import _m_j.fmh;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gou;
import _m_j.gpv;
import _m_j.gqg;
import _m_j.gwg;
import _m_j.gxs;
import _m_j.gxu;
import _m_j.hzf;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.smarthome.library.common.widget.viewflow.LoadingMoreView;
import java.util.ArrayList;
import java.util.List;

public class DeviceOpHistoryActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O00000o0 f9877O000000o;
    boolean O00000Oo = true;
    ImageView O00000o;
    long O00000o0 = 0;
    private View O00000oO;
    private ImageView O00000oo;
    private ImageView O0000O0o;
    private View O0000OOo;
    private TextView O0000Oo;
    private TextView O0000Oo0;
    private TextView O0000OoO;
    private String O0000Ooo;
    private TextView O0000o;
    private SimpleDraweeView O0000o0;
    private String O0000o00 = null;
    private TextView O0000o0O;
    private TextView O0000o0o;
    private ImageView O0000oO0;
    public SparseBooleanArray mCheckedItems = new SparseBooleanArray();
    public boolean mEditMode = false;
    public View mEmptyView;
    public O00000Oo mEndlessScrollListener = new O00000Oo() {
        /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass1 */

        public final boolean O000000o() {
            return DeviceOpHistoryActivity.this.startLoadMore();
        }
    };
    public Handler mHandler = new Handler();
    public View mHeaderView;
    public PullDownDragListView mList;
    public O000000o mListener = new O000000o() {
        /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass6 */

        public final void O000000o(List<gxu> list) {
            DeviceOpHistoryActivity.this.mCheckedItems.clear();
            DeviceOpHistoryActivity.this.f9877O000000o.O000000o(list, false);
            DeviceOpHistoryActivity.this.f9877O000000o.notifyDataSetChanged();
            if (DeviceOpHistoryActivity.this.mRequestList.size() == 0) {
                DeviceOpHistoryActivity.this.mEmptyView.setVisibility(0);
                DeviceOpHistoryActivity.this.mList.setVisibility(8);
                DeviceOpHistoryActivity.this.hideDeleteBars();
                DeviceOpHistoryActivity deviceOpHistoryActivity = DeviceOpHistoryActivity.this;
                deviceOpHistoryActivity.mEditMode = false;
                deviceOpHistoryActivity.setTitleBarAlpha(false);
            } else {
                DeviceOpHistoryActivity.this.mEmptyView.setVisibility(8);
                DeviceOpHistoryActivity.this.mList.setVisibility(0);
                DeviceOpHistoryActivity.this.mList.setOnScrollListener(DeviceOpHistoryActivity.this.mEndlessScrollListener);
            }
            DeviceOpHistoryActivity.this.mLoadingMoreView.setVisibility(8);
            DeviceOpHistoryActivity.this.mList.O00000Oo();
            DeviceOpHistoryActivity.this.updateHeader();
        }

        public final void O00000Oo(List<gxu> list) {
            if (list == null || list.size() == 0) {
                DeviceOpHistoryActivity.this.mLoadingMoreView.setVisibility(8);
                DeviceOpHistoryActivity.this.mLoadingMoreFinished = true;
                return;
            }
            DeviceOpHistoryActivity.this.f9877O000000o.O000000o(list, true);
            DeviceOpHistoryActivity.this.f9877O000000o.notifyDataSetChanged();
        }

        public final void O000000o() {
            DeviceOpHistoryActivity.this.mCheckedItems.clear();
            DeviceOpHistoryActivity.this.f9877O000000o.notifyDataSetChanged();
            DeviceOpHistoryActivity.this.mList.O00000Oo();
            if (DeviceOpHistoryActivity.this.mRequestList.size() == 0) {
                DeviceOpHistoryActivity.this.mEmptyView.setVisibility(0);
                DeviceOpHistoryActivity.this.mList.setVisibility(8);
                DeviceOpHistoryActivity.this.setTitleBarAlpha(false);
                return;
            }
            DeviceOpHistoryActivity.this.mEmptyView.setVisibility(8);
            DeviceOpHistoryActivity.this.mList.setVisibility(0);
        }
    };
    public boolean mLoadingMoreFinished = false;
    public LoadingMoreView mLoadingMoreView;
    public List<gxu> mRequestList = new ArrayList();
    public View mTitleBar;
    public int mTitleBarHeight;

    public interface O000000o {
        void O000000o();

        void O000000o(List<gxu> list);

        void O00000Oo(List<gxu> list);
    }

    public static void openOpHistoryActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, DeviceOpHistoryActivity.class);
        intent.putExtra("did", str);
        activity.startActivity(intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.PullDownDragListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_op_history);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.O0000o00 = intent.getStringExtra("did");
        if (TextUtils.isEmpty(this.O0000o00)) {
            finish();
            return;
        }
        gwg.O00000o0(this);
        this.mList = (PullDownDragListView) findViewById(R.id.share_message_list);
        this.mLoadingMoreView = new LoadingMoreView(this);
        this.mList.addFooterView(this.mLoadingMoreView);
        this.mLoadingMoreView.setVisibility(0);
        this.mList.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass7 */

            public final void startRefresh() {
                DeviceOpHistoryActivity deviceOpHistoryActivity = DeviceOpHistoryActivity.this;
                deviceOpHistoryActivity.O00000o0 = 0;
                deviceOpHistoryActivity.O000000o();
            }
        });
        this.mEmptyView = findViewById(R.id.common_white_empty_view);
        this.mEmptyView.setVisibility(8);
        ((TextView) findViewById(R.id.common_white_empty_text)).setText((int) R.string.no_data_tips);
        this.O0000o = (TextView) findViewById(R.id.title_bar_title);
        if (!TextUtils.isEmpty(this.O0000Ooo)) {
            this.O0000o.setText(this.O0000Ooo);
        } else {
            this.O0000o.setText((int) R.string.device_op_history);
        }
        this.O0000o.setVisibility(4);
        this.O0000oO0 = (ImageView) findViewById(R.id.title_bar_return);
        this.O0000oO0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass8 */

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
                DeviceOpHistoryActivity.this.finish();
            }
        });
        this.O00000o = (ImageView) findViewById(R.id.title_bar_more);
        this.O00000o.setVisibility(8);
        this.O00000o.setImageResource(R.drawable.common_title_bar_clear);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass9 */

            public final void onClick(View view) {
            }
        });
        this.f9877O000000o = new O00000o0();
        this.mList.setPullDownEnabled(false);
        this.mTitleBar = findViewById(R.id.title_bar);
        this.O00000oO = findViewById(R.id.top_delete_bar);
        this.O0000OoO = (TextView) this.O00000oO.findViewById(R.id.selected_cnt);
        this.O00000oo = (ImageView) this.O00000oO.findViewById(R.id.cancel_btn);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass10 */

            public final void onClick(View view) {
                DeviceOpHistoryActivity.this.dismissEditMode();
            }
        });
        this.O0000O0o = (ImageView) this.O00000oO.findViewById(R.id.select_all_btn);
        this.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass11 */

            public final void onClick(View view) {
                if (DeviceOpHistoryActivity.this.mCheckedItems.size() == DeviceOpHistoryActivity.this.mRequestList.size()) {
                    DeviceOpHistoryActivity.this.unSelectAll();
                } else {
                    DeviceOpHistoryActivity.this.selectAll();
                }
            }
        });
        this.O0000OOo = findViewById(R.id.bottom_delete_bar);
        this.O0000OOo.setVisibility(8);
        this.O0000Oo0 = (TextView) this.O0000OOo.findViewById(R.id.delete_msg_btn);
        this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass12 */

            public final void onClick(View view) {
            }
        });
        this.O0000Oo0.setVisibility(4);
        this.O0000Oo = (TextView) this.O0000OOo.findViewById(R.id.btm_tip_tv);
        this.O0000Oo.setVisibility(0);
        this.O0000Oo = (TextView) this.O0000OOo.findViewById(R.id.btm_tip_tv);
        this.O0000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass13 */

            public final void onClick(View view) {
            }
        });
        if (gwg.O000000o((Activity) this)) {
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.O00000oO);
        }
        this.mHeaderView = LayoutInflater.from(this).inflate((int) R.layout.device_op_history_header, (ViewGroup) this.mList, false);
        this.mList.addHeaderView(this.mHeaderView);
        this.O0000o0 = (SimpleDraweeView) this.mHeaderView.findViewById(R.id.device_icon);
        this.O0000o0O = (TextView) this.mHeaderView.findViewById(R.id.device_name);
        this.O0000o0o = (TextView) this.mHeaderView.findViewById(R.id.device_status);
        Device O000000o2 = fno.O000000o().O000000o(this.O0000o00);
        if (O000000o2 != null) {
            DeviceFactory.O00000Oo(O000000o2.model, this.O0000o0);
            this.O0000o0O.setText(O000000o2.getName());
        }
        setTitleBarAlpha(true);
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass2 */

            public final void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= 16) {
                    DeviceOpHistoryActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                DeviceOpHistoryActivity deviceOpHistoryActivity = DeviceOpHistoryActivity.this;
                deviceOpHistoryActivity.mTitleBarHeight = deviceOpHistoryActivity.mTitleBar.getHeight();
                if (gwg.O000000o((Activity) DeviceOpHistoryActivity.this)) {
                    DeviceOpHistoryActivity.this.mHeaderView.setPadding(DeviceOpHistoryActivity.this.mHeaderView.getPaddingLeft(), DeviceOpHistoryActivity.this.getResources().getDimensionPixelSize(R.dimen.title_bar_top_padding), DeviceOpHistoryActivity.this.mHeaderView.getPaddingRight(), DeviceOpHistoryActivity.this.mHeaderView.getPaddingBottom());
                }
            }
        });
        this.mList.setAdapter((ListAdapter) this.f9877O000000o);
        this.O00000Oo = false;
        this.O00000o0 = 0;
        O000000o();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.O00000Oo = false;
        this.O00000o0 = 0;
        O000000o();
    }

    public void updateHeader() {
        gxu gxu;
        gxs gxs;
        if (this.mRequestList.size() > 0 && (gxu = this.mRequestList.get(0)) != null && gxu.O00000oO != null && gxu.O00000oO.size() != 0 && (gxs = gxu.O00000oO.get(0)) != null) {
            TextView textView = this.O0000o0o;
            textView.setText(gou.O00000Oo(gxs.f18483O000000o) + " " + gxs.O00000o0);
        }
    }

    public void setTitleBarAlpha(boolean z) {
        if (z) {
            this.O0000o.setVisibility(4);
            this.mTitleBar.setBackgroundResource(R.drawable.mj_color_white_00_transparent);
            this.O0000o.setTextColor(getResources().getColor(R.color.mj_color_white));
            this.O0000oO0.setImageResource(R.drawable.std_tittlebar_main_device_back_white);
            gwg.O00000o0(this);
        } else {
            this.O0000o.setVisibility(0);
            this.mTitleBar.setBackgroundResource(R.drawable.mj_color_white);
            this.O0000o.setTextColor(getResources().getColor(R.color.mj_color_black_80_transparent));
            this.O0000oO0.setImageResource(R.drawable.std_tittlebar_main_device_back);
            gwg.O00000Oo(getWindow());
        }
        this.mTitleBar.invalidate();
    }

    public void showDeleteBars() {
        this.O00000oO.setVisibility(0);
        this.O0000OOo.setVisibility(0);
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo.setVisibility(8);
        this.O00000oO.measure(0, 0);
        this.O0000OOo.measure(0, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O00000oO, View.Y, (float) (-this.O00000oO.getMeasuredHeight()), 0.0f);
        ViewGroup viewGroup = (ViewGroup) this.O0000OOo.getParent();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.O0000OOo, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - this.O0000OOo.getMeasuredHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public void hideDeleteBars() {
        this.O00000oO.setVisibility(8);
        this.O0000OOo.setVisibility(0);
        this.O0000Oo0.setVisibility(4);
        this.O0000Oo.setVisibility(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
    public void onBackPressed() {
        super.onBackPressed();
        gpv.O00000Oo("message_center_red_dot_clicked", true);
        gpv.O00000Oo("my_home_red_dot_clicked", true);
        gpv.O000000o(ServiceApplication.getAppContext(), "new_message_count", 0);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean startLoadMore() {
        List<gxu> list = this.mRequestList;
        gxu gxu = list.get(list.size() - 1);
        if (gxu == null || this.mLoadingMoreFinished || gxu.O00000oO == null || gxu.O00000oO.size() == 0) {
            return false;
        }
        this.mLoadingMoreView.setVisibility(0);
        this.mLoadingMoreView.O000000o();
        fmh.O000000o().O000000o(this, this.O0000o00, gxu.O00000oO.get(gxu.O00000oO.size() - 1).f18483O000000o - 1, new fsm<List<gxu>, fso>() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                final List list = (List) obj;
                if (list == null) {
                    list = new ArrayList();
                }
                if (list.isEmpty()) {
                    DeviceOpHistoryActivity.this.mLoadingMoreFinished = true;
                }
                DeviceOpHistoryActivity.this.mRequestList.addAll(list);
                DeviceOpHistoryActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        if (DeviceOpHistoryActivity.this.isValid()) {
                            DeviceOpHistoryActivity.this.mListener.O00000Oo(list);
                        }
                    }
                });
            }

            public final void onFailure(fso fso) {
                if (DeviceOpHistoryActivity.this.isValid()) {
                    DeviceOpHistoryActivity.this.mListener.O000000o();
                }
            }
        });
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (this.O00000Oo || this.O00000o0 <= 0) {
            fmh.O000000o().O000000o(this, this.O0000o00, this.O00000o0, new fsm<List<gxu>, fso>() {
                /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    final List<gxu> list = (List) obj;
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    DeviceOpHistoryActivity deviceOpHistoryActivity = DeviceOpHistoryActivity.this;
                    deviceOpHistoryActivity.mRequestList = list;
                    deviceOpHistoryActivity.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            if (DeviceOpHistoryActivity.this.isValid()) {
                                DeviceOpHistoryActivity.this.mListener.O000000o(list);
                            }
                        }
                    });
                }

                public final void onFailure(fso fso) {
                    if (DeviceOpHistoryActivity.this.isValid()) {
                        DeviceOpHistoryActivity.this.mListener.O000000o();
                    }
                }
            });
        } else {
            this.mList.O00000Oo();
        }
    }

    public void dismissEditMode() {
        this.mList.setPullDownEnabled(true);
        this.mEditMode = false;
        this.mCheckedItems.clear();
        hideDeleteBars();
        this.f9877O000000o.notifyDataSetChanged();
    }

    public void selectAll() {
        int size = this.mRequestList.size();
        for (int i = 0; i < size; i++) {
            this.mCheckedItems.put(i, true);
        }
        this.O0000O0o.setImageResource(R.drawable.un_select_selector);
        this.O0000O0o.setContentDescription(getString(R.string.unselect_all));
        this.f9877O000000o.notifyDataSetChanged();
        this.O0000OoO.setVisibility(0);
        this.O0000OoO.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size())));
    }

    public void unSelectAll() {
        this.mCheckedItems.clear();
        this.O0000O0o.setImageResource(R.drawable.all_select_selector);
        this.O0000O0o.setContentDescription(getString(R.string.select_all));
        this.f9877O000000o.notifyDataSetChanged();
        this.O0000OoO.setVisibility(8);
    }

    public void deleteSelected() {
        if (this.mCheckedItems.size() == 0) {
            gqg.O000000o((int) R.string.not_select_deleted_msg);
            return;
        }
        new MLAlertDialog.Builder(this).O000000o((int) R.string.delete_msg_title).O00000Oo(getResources().getQuantityString(R.plurals.delete_msg, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size()))).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryActivity.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                new ArrayList();
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

    class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        View f9894O000000o;
        TextView O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        TextView O00000oO;
        ImageView O00000oo;
        View O0000O0o;
        TextView O0000OOo;
        TextView O0000Oo;
        TextView O0000Oo0;

        O00000o() {
        }
    }

    class O00000o0 extends BaseAdapter {
        private List<Object> O00000Oo = new ArrayList();
        private int[] O00000o0 = {R.drawable.device_op_history_dot_2, R.drawable.device_op_history_dot_1, R.drawable.device_op_history_dot_3, R.drawable.device_op_history_dot_4, R.drawable.device_op_history_dot_5};

        public final long getItemId(int i) {
            return 0;
        }

        O00000o0() {
        }

        public final void O000000o(List<gxu> list, boolean z) {
            if (list != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    gxu gxu = list.get(i);
                    ArrayList<gxs> arrayList2 = gxu.O00000oO;
                    if (!(arrayList2 == null || arrayList2.size() == 0)) {
                        arrayList.add(gxu);
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            arrayList.add(arrayList2.get(i2));
                        }
                    }
                }
                if (z) {
                    this.O00000Oo.addAll(arrayList);
                } else {
                    this.O00000Oo = arrayList;
                }
            }
        }

        public final int getCount() {
            return this.O00000Oo.size();
        }

        public final Object getItem(int i) {
            if (i < 0 || i >= this.O00000Oo.size()) {
                return null;
            }
            return this.O00000Oo.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000o o00000o;
            if (view == null) {
                view = LayoutInflater.from(DeviceOpHistoryActivity.this).inflate((int) R.layout.item_device_op_history_view, viewGroup, false);
                o00000o = new O00000o();
                o00000o.f9894O000000o = view.findViewById(R.id.child_view);
                o00000o.O00000Oo = (TextView) o00000o.f9894O000000o.findViewById(R.id.hourminute);
                o00000o.O00000o0 = (TextView) o00000o.f9894O000000o.findViewById(R.id.action);
                o00000o.O00000o = (TextView) o00000o.f9894O000000o.findViewById(R.id.result);
                o00000o.O00000oO = (TextView) o00000o.f9894O000000o.findViewById(R.id.source);
                o00000o.O00000oO.setMaxLines(2);
                o00000o.O00000oO.setEllipsize(TextUtils.TruncateAt.END);
                o00000o.O00000oo = (ImageView) o00000o.f9894O000000o.findViewById(R.id.device_history_dot_iv);
                o00000o.O0000O0o = view.findViewById(R.id.group_view);
                o00000o.O0000OOo = (TextView) o00000o.O0000O0o.findViewById(R.id.day);
                o00000o.O0000Oo0 = (TextView) o00000o.O0000O0o.findViewById(R.id.month);
                o00000o.O0000Oo = (TextView) o00000o.O0000O0o.findViewById(R.id.weekday);
                view.setTag(o00000o);
            } else {
                o00000o = (O00000o) view.getTag();
            }
            Object item = getItem(i);
            if (item == null) {
                return view;
            }
            if (item instanceof gxu) {
                gxu gxu = (gxu) item;
                o00000o.f9894O000000o.setVisibility(8);
                o00000o.O0000O0o.setVisibility(0);
                TextView textView = o00000o.O0000OOo;
                StringBuilder sb = new StringBuilder();
                sb.append(gxu.f18484O000000o);
                textView.setText(sb.toString());
                TextView textView2 = o00000o.O0000Oo0;
                textView2.setText(gxu.O00000Oo + DeviceOpHistoryActivity.this.getResources().getString(R.string.month));
                o00000o.O0000Oo.setText(gxu.O00000o0);
            } else if (item instanceof gxs) {
                gxs gxs = (gxs) item;
                o00000o.f9894O000000o.setVisibility(0);
                o00000o.O0000O0o.setVisibility(8);
                o00000o.O00000Oo.setText(gxs.O00000Oo);
                o00000o.O00000o0.setText(gxs.O00000o0);
                if (!TextUtils.isEmpty(gxs.O00000o) || !TextUtils.isEmpty(gxs.O00000oO)) {
                    if (TextUtils.isEmpty(gxs.O00000o)) {
                        o00000o.O00000o.setVisibility(8);
                    } else {
                        o00000o.O00000o.setVisibility(0);
                        o00000o.O00000o.setText(gxs.O00000o);
                    }
                    if (TextUtils.isEmpty(gxs.O00000oO)) {
                        o00000o.O00000oO.setVisibility(8);
                    } else {
                        o00000o.O00000oO.setVisibility(0);
                        o00000o.O00000oO.setText(gxs.O00000oO);
                    }
                } else {
                    o00000o.O00000o.setVisibility(8);
                    o00000o.O00000oO.setVisibility(8);
                }
                if (TextUtils.isEmpty(gxs.O00000o0)) {
                    o00000o.O00000oo.setImageResource(R.drawable.device_op_history_dot_1);
                } else {
                    o00000o.O00000oo.setImageResource(this.O00000o0[gxs.O00000o0.hashCode() % this.O00000o0.length]);
                }
            }
            return view;
        }
    }

    public abstract class O00000Oo implements AbsListView.OnScrollListener {

        /* renamed from: O000000o  reason: collision with root package name */
        private int f9893O000000o = 5;
        private int O00000o = 0;
        private int O00000o0 = 0;
        private boolean O00000oO = true;
        private int O00000oo = 0;

        public abstract boolean O000000o();

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public O00000Oo() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (DeviceOpHistoryActivity.this.mHeaderView.getBottom() <= DeviceOpHistoryActivity.this.mTitleBar.getBottom()) {
                DeviceOpHistoryActivity.this.setTitleBarAlpha(false);
            } else {
                DeviceOpHistoryActivity.this.setTitleBarAlpha(true);
            }
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
            if (!this.O00000oO && i3 - i2 <= i + this.f9893O000000o) {
                this.O00000oO = O000000o();
            }
        }
    }
}
