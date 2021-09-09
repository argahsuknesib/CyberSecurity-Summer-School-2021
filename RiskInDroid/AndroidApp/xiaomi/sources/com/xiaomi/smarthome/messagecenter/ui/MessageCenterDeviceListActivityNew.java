package com.xiaomi.smarthome.messagecenter.ui;

import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.guf;
import _m_j.gui;
import _m_j.gul;
import _m_j.guw;
import _m_j.gwc;
import _m_j.gwg;
import _m_j.hte;
import _m_j.hzf;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Pair;
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
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.family.api.MessageApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.smarthome.library.common.widget.viewflow.LoadingMoreView;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.messagecenter.TypeListMsgCacheManager;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import com.xiaomi.smarthome.miio.db.record.MessageRecordTypeList;
import com.xiaomi.smarthome.newui.widget.SpanTouchFixTextView;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageCenterDeviceListActivityNew extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f9445O000000o;
    long O00000Oo = 0;
    long O00000o;
    ImageView O00000o0;
    private View O00000oO;
    private String O00000oo;
    private int O0000O0o = 6;
    private View O0000OOo;
    private View O0000Oo;
    private ImageView O0000Oo0;
    private TextView O0000OoO;
    private TextView O0000Ooo;
    private boolean O0000o = false;
    private LoadingMoreView O0000o0;
    private View O0000o00;
    private CharSequence O0000o0O;
    private View O0000o0o;
    public SparseBooleanArray mCheckedItems = new SparseBooleanArray();
    public String mDid;
    public boolean mEditMode = false;
    public ImageView mIvSelectAll;
    public int mLastNewMsgPos = -1;
    public PullDownDragListView mList;
    public boolean mLoadingMoreFinished = false;
    public List<gul> mRequestList = new ArrayList();
    public TextView mSelectedCntTv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.message_center_list);
        Intent intent = getIntent();
        if (intent != null) {
            this.mDid = intent.getStringExtra("device_id");
            this.O00000oo = intent.getStringExtra("device_model");
            if ("11".equals(intent.getStringExtra("message_type"))) {
                this.O0000O0o = 11;
            } else {
                this.O0000O0o = 6;
            }
        }
        gsy.O00000o0(LogType.KUAILIAN, "wugan", String.format("open message detail :did=%s,model=%s,messageType=%d", this.mDid, this.O00000oo, Integer.valueOf(this.O0000O0o)));
        if (TextUtils.isEmpty(this.mDid) || TextUtils.isEmpty(this.O00000oo)) {
            finish();
            return;
        }
        if (this.O0000O0o == 11) {
            this.O0000o0O = DeviceFactory.O0000OoO(this.O00000oo);
        } else {
            this.O0000o0O = intent.getStringExtra("title_name");
        }
        this.mList = (PullDownDragListView) findViewById(R.id.share_message_list);
        this.O0000o0 = new LoadingMoreView(this);
        this.O0000o0.setVisibility(0);
        this.mList.setPullDownEnabled(true);
        this.mList.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass1 */

            public final void startRefresh() {
                MessageCenterDeviceListActivityNew messageCenterDeviceListActivityNew = MessageCenterDeviceListActivityNew.this;
                messageCenterDeviceListActivityNew.O00000Oo = 0;
                messageCenterDeviceListActivityNew.O000000o();
            }
        });
        this.mList.O000000o();
        this.O00000oO = findViewById(R.id.common_white_empty_view);
        this.O00000oO.setVisibility(8);
        ((TextView) findViewById(R.id.common_white_empty_text)).setText((int) R.string.miio_no_message);
        if (!TextUtils.isEmpty(this.O0000o0O)) {
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText(this.O0000o0O);
        } else {
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.miio_setting_message_center);
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass3 */

            public final void onClick(View view) {
                MessageCenterDeviceListActivityNew.this.updateTimestamp();
                MessageCenterDeviceListActivityNew.this.finish();
            }
        });
        this.O00000o0 = (ImageView) findViewById(R.id.module_a_3_return_more_more_btn);
        this.O00000o0.setVisibility(8);
        this.O00000o0.setImageResource(R.drawable.common_title_bar_clear);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass4 */

            public final void onClick(View view) {
                if (MessageCenterDeviceListActivityNew.this.mRequestList.size() != 0) {
                    new MLAlertDialog.Builder(MessageCenterDeviceListActivityNew.this).O00000Oo(MessageCenterDeviceListActivityNew.this.getResources().getString(R.string.log_clear_all_logs)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass4.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            long j = 0;
                            for (gul next : guf.O000000o().O00000o) {
                                if (next.O000000o() > j) {
                                    j = next.O000000o();
                                }
                            }
                            fru.O000000o();
                            fru.O000000o(MessageCenterDeviceListActivityNew.this, j + 1, new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    MessageRecord.deleteAll();
                                    MessageCenterDeviceListActivityNew.this.O000000o();
                                }
                            });
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000o().show();
                }
            }
        });
        this.f9445O000000o = new O000000o();
        this.mList.setAdapter((ListAdapter) this.f9445O000000o);
        this.O0000o00 = findViewById(R.id.title_bar);
        this.O0000OOo = findViewById(R.id.top_delete_bar);
        this.mSelectedCntTv = (TextView) this.O0000OOo.findViewById(R.id.selected_cnt);
        this.O0000Oo0 = (ImageView) this.O0000OOo.findViewById(R.id.cancel_btn);
        this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass5 */

            public final void onClick(View view) {
                MessageCenterDeviceListActivityNew.this.dismissEditMode();
            }
        });
        this.mIvSelectAll = (ImageView) this.O0000OOo.findViewById(R.id.select_all_btn);
        this.mIvSelectAll.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass6 */

            public final void onClick(View view) {
                if (MessageCenterDeviceListActivityNew.this.mCheckedItems.size() == MessageCenterDeviceListActivityNew.this.mRequestList.size()) {
                    MessageCenterDeviceListActivityNew.this.unSelectAll();
                } else {
                    MessageCenterDeviceListActivityNew.this.selectAll();
                }
            }
        });
        this.O0000Oo = findViewById(R.id.bottom_delete_bar);
        this.O0000OoO = (TextView) this.O0000Oo.findViewById(R.id.delete_msg_btn);
        this.O0000OoO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass7 */

            public final void onClick(View view) {
                MessageCenterDeviceListActivityNew.this.deleteSelected();
            }
        });
        this.O0000Ooo = (TextView) this.O0000Oo.findViewById(R.id.btm_tip_tv);
        this.O0000Ooo.setVisibility(8);
        if (gwg.O000000o((Activity) this)) {
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.O0000OOo);
        }
        this.O00000o = PreferenceManager.getDefaultSharedPreferences(this).getLong("last_update_time", 0);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.O00000Oo = 0;
        O000000o();
    }

    public void showDeleteBars() {
        this.O0000OOo.setVisibility(0);
        this.O0000Oo.setVisibility(0);
        this.O0000OoO.setVisibility(0);
        this.O0000Ooo.setVisibility(8);
        this.O0000OOo.measure(0, 0);
        this.O0000Oo.measure(0, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0000OOo, View.Y, (float) (-this.O0000OOo.getMeasuredHeight()), 0.0f);
        ViewGroup viewGroup = (ViewGroup) this.O0000Oo.getParent();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.O0000Oo, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - this.O0000Oo.getMeasuredHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public void hideDeleteBars() {
        this.O0000OOo.setVisibility(8);
        this.O0000Oo.setVisibility(8);
        this.O0000OoO.setVisibility(8);
        this.O0000Ooo.setVisibility(8);
    }

    public void onBackPressed() {
        try {
            super.onBackPressed();
            updateTimestamp();
        } catch (Exception unused) {
        }
    }

    public void updateTimestamp() {
        List<gul> list = this.mRequestList;
        if (list != null && list.size() > 0) {
            List<gul> list2 = this.mRequestList;
            gui.O00000Oo(this.mDid, Math.max(this.mRequestList.get(0).O00000oo.receiveTime, list2.get(list2.size() - 1).O00000oo.receiveTime));
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        this.mLastNewMsgPos = 0;
        MessageApi.instance.getMessageListOfDevice(getContext(), this.mDid, this.O0000O0o, System.currentTimeMillis() / 1000, 200, new fsm<List<MessageRecordTypeList>, fso>() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List<gul> O000000o2 = guw.O000000o().O000000o((List) obj);
                if (O000000o2 == null || O000000o2.isEmpty()) {
                    MessageCenterDeviceListActivityNew.this.mRequestList = new ArrayList();
                    MessageCenterDeviceListActivityNew.this.f9445O000000o.notifyDataSetChanged();
                    return;
                }
                MessageCenterDeviceListActivityNew messageCenterDeviceListActivityNew = MessageCenterDeviceListActivityNew.this;
                messageCenterDeviceListActivityNew.mRequestList = O000000o2;
                messageCenterDeviceListActivityNew.f9445O000000o.notifyDataSetChanged();
                MessageCenterDeviceListActivityNew.this.mList.O00000Oo();
                if (MessageCenterDeviceListActivityNew.this.mRequestList != null && MessageCenterDeviceListActivityNew.this.mRequestList.size() > 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < MessageCenterDeviceListActivityNew.this.mRequestList.size(); i2++) {
                        gul gul = MessageCenterDeviceListActivityNew.this.mRequestList.get(i2);
                        if (gul != null) {
                            if (!gul.O0000O0o()) {
                                break;
                            }
                            i++;
                        }
                    }
                    gsy.O00000Oo("MsgCenterDeviceActivity", "newMsgCount=".concat(String.valueOf(i)));
                    MessageCenterDeviceListActivityNew.this.mList.setSelection(MessageCenterDeviceListActivityNew.this.f9445O000000o.getCount() - 1);
                    if (i >= 6) {
                        MessageCenterDeviceListActivityNew messageCenterDeviceListActivityNew2 = MessageCenterDeviceListActivityNew.this;
                        messageCenterDeviceListActivityNew2.mLastNewMsgPos = i;
                        messageCenterDeviceListActivityNew2.showNewMsgTip();
                    }
                }
            }

            public final void onFailure(fso fso) {
                String str;
                MessageCenterDeviceListActivityNew.this.mList.O00000Oo();
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
        });
    }

    public void dismissNewMsgTip() {
        this.O0000o0o.setVisibility(8);
    }

    public void showNewMsgTip() {
        this.O0000o0o = findViewById(R.id.new_msg_tip_layout);
        if (this.mLastNewMsgPos <= 0) {
            this.O0000o0o.setVisibility(8);
            return;
        }
        this.O0000o0o.setVisibility(0);
        Resources resources = getResources();
        int i = this.mLastNewMsgPos;
        ((TextView) this.O0000o0o.findViewById(R.id.new_msg_tv)).setText(resources.getQuantityString(R.plurals.msg_center_new_msg_tip, i, Integer.valueOf(i)));
        this.O0000o0o.findViewById(R.id.new_msg_tip).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass9 */

            public final void onClick(View view) {
                int count = (MessageCenterDeviceListActivityNew.this.mList.getCount() - MessageCenterDeviceListActivityNew.this.mLastNewMsgPos) - MessageCenterDeviceListActivityNew.this.mList.getFooterViewsCount();
                if (count < 0) {
                    count = 0;
                }
                MessageCenterDeviceListActivityNew.this.mList.setSelection(count);
                MessageCenterDeviceListActivityNew.this.dismissNewMsgTip();
            }
        });
        this.mList.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass10 */

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i2 == 0 || MessageCenterDeviceListActivityNew.this.mList.getLastVisiblePosition() < 0) {
                }
            }
        });
    }

    public void dismissEditMode() {
        this.mList.setPullDownEnabled(true);
        this.mEditMode = false;
        this.mCheckedItems.clear();
        hideDeleteBars();
        this.f9445O000000o.notifyDataSetChanged();
    }

    public void selectAll() {
        int size = this.mRequestList.size();
        for (int i = 0; i < size; i++) {
            this.mCheckedItems.put(i, true);
        }
        this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.unselect_all));
        this.f9445O000000o.notifyDataSetChanged();
        this.mSelectedCntTv.setVisibility(0);
        this.mSelectedCntTv.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size())));
    }

    public void unSelectAll() {
        this.mCheckedItems.clear();
        this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.select_all));
        this.f9445O000000o.notifyDataSetChanged();
        this.mSelectedCntTv.setVisibility(8);
    }

    public void deleteSelected() {
        if (this.mCheckedItems.size() == 0) {
            hte.O000000o(this, (int) R.string.not_select_deleted_msg);
            return;
        }
        new MLAlertDialog.Builder(this).O000000o((int) R.string.delete_msg_title).O00000Oo(getResources().getQuantityString(R.plurals.delete_msg, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size()))).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < MessageCenterDeviceListActivityNew.this.mCheckedItems.size(); i2++) {
                    int keyAt = MessageCenterDeviceListActivityNew.this.mCheckedItems.keyAt(i2);
                    if (MessageCenterDeviceListActivityNew.this.mCheckedItems.get(keyAt) && MessageCenterDeviceListActivityNew.this.mRequestList.size() > keyAt) {
                        gul gul = (gul) MessageCenterDeviceListActivityNew.this.f9445O000000o.getItem(keyAt);
                        try {
                            arrayList.add(gul.O00000o0());
                            arrayList2.add(gul);
                        } catch (Exception unused) {
                        }
                    }
                }
                fru.O000000o();
                MessageCenterDeviceListActivityNew messageCenterDeviceListActivityNew = MessageCenterDeviceListActivityNew.this;
                fru.O000000o(messageCenterDeviceListActivityNew, 6, messageCenterDeviceListActivityNew.mDid, (String[]) arrayList.toArray(new String[0]), new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.AnonymousClass2.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        String str;
                        if (MessageCenterDeviceListActivityNew.this.isValid()) {
                            MessageCenterDeviceListActivityNew messageCenterDeviceListActivityNew = MessageCenterDeviceListActivityNew.this;
                            StringBuilder sb = new StringBuilder("2132674021");
                            if (!gfr.O0000OOo || fso == null) {
                                str = "";
                            } else {
                                str = ":" + fso.f17063O000000o + ":" + fso.O00000Oo;
                            }
                            sb.append(str);
                            hte.O000000o(messageCenterDeviceListActivityNew, sb.toString());
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (MessageCenterDeviceListActivityNew.this.isValid()) {
                            MessageCenterDeviceListActivityNew.this.mCheckedItems.clear();
                            MessageCenterDeviceListActivityNew.this.mSelectedCntTv.setVisibility(8);
                            MessageCenterDeviceListActivityNew.this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
                            MessageCenterDeviceListActivityNew.this.mIvSelectAll.setContentDescription(MessageCenterDeviceListActivityNew.this.getString(R.string.select_all));
                            MessageCenterDeviceListActivityNew.this.mList.setSelectionAfterHeaderView();
                            MessageCenterDeviceListActivityNew.this.mLoadingMoreFinished = false;
                            TypeListMsgCacheManager O000000o2 = TypeListMsgCacheManager.O000000o();
                            String str = MessageCenterDeviceListActivityNew.this.mDid;
                            List list = arrayList2;
                            List<MessageRecordTypeList> list2 = O000000o2.f9421O000000o;
                            List<Pair<TypeListMsgCacheManager.O000000o, List<gul>>> list3 = O000000o2.O00000Oo;
                            list2.removeAll(list);
                            ArrayList arrayList = new ArrayList();
                            int i = 0;
                            while (true) {
                                if (i >= list3.size()) {
                                    break;
                                }
                                Pair pair = list3.get(i);
                                if (TextUtils.equals(str, ((TypeListMsgCacheManager.O000000o) pair.first).f9424O000000o)) {
                                    try {
                                        ((List) pair.second).removeAll(list);
                                        break;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    i++;
                                }
                            }
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                arrayList.add(((gul) list.get(i2)).O00000o0());
                            }
                            MessageRecordTypeList.batchDelete(arrayList);
                            MessageCenterDeviceListActivityNew.this.mRequestList.removeAll(arrayList2);
                            MessageCenterDeviceListActivityNew.this.f9445O000000o.notifyDataSetChanged();
                        }
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

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f9464O000000o;
        SpanTouchFixTextView O00000Oo;
        CheckBox O00000o0;

        O00000Oo() {
        }
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        DateFormat f9459O000000o;

        public final long getItemId(int i) {
            return 0;
        }

        public O000000o() {
            this.f9459O000000o = gwc.O000000o((Activity) MessageCenterDeviceListActivityNew.this);
        }

        public final int getCount() {
            return MessageCenterDeviceListActivityNew.this.mRequestList.size();
        }

        public final Object getItem(int i) {
            int size = (MessageCenterDeviceListActivityNew.this.mRequestList.size() - i) - 1;
            if (size < 0 || size >= MessageCenterDeviceListActivityNew.this.mRequestList.size()) {
                return null;
            }
            return MessageCenterDeviceListActivityNew.this.mRequestList.get(size);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(final int i, View view, ViewGroup viewGroup) {
            O00000Oo o00000Oo;
            if (view == null) {
                view = LayoutInflater.from(MessageCenterDeviceListActivityNew.this).inflate((int) R.layout.message_item_device_list, viewGroup, false);
                o00000Oo = new O00000Oo();
                o00000Oo.f9464O000000o = (TextView) view.findViewById(R.id.date_time_tv);
                o00000Oo.O00000o0 = (CheckBox) view.findViewById(R.id.ratio_btn);
                o00000Oo.O00000Oo = (SpanTouchFixTextView) view.findViewById(R.id.content_tv);
                view.setTag(o00000Oo);
                o00000Oo.O00000Oo.setTag(o00000Oo);
            } else {
                o00000Oo = (O00000Oo) view.getTag();
            }
            final gul gul = (gul) getItem(i);
            if (gul == null) {
                return view;
            }
            o00000Oo.O00000Oo.setMovementMethodDefault();
            o00000Oo.f9464O000000o.setText(this.f9459O000000o.format(new Date(gul.O00000oo.receiveTime * 1000)));
            if (gul.O0000O0o()) {
                o00000Oo.O00000Oo.setTextColor(MessageCenterDeviceListActivityNew.this.getResources().getColor(R.color.mj_color_gray_heavier));
            } else {
                o00000Oo.O00000Oo.setTextColor(MessageCenterDeviceListActivityNew.this.getResources().getColor(R.color.mj_color_black_50_transparent));
            }
            gul.O000000o(o00000Oo.O00000Oo);
            if (MessageCenterDeviceListActivityNew.this.mEditMode) {
                o00000Oo.O00000o0.setVisibility(0);
                o00000Oo.O00000Oo.setOnLongClickListener(null);
                o00000Oo.O00000Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.O000000o.AnonymousClass1 */

                    public final void onClick(View view) {
                        ((O00000Oo) view.getTag()).O00000o0.performClick();
                    }
                });
                if (MessageCenterDeviceListActivityNew.this.mCheckedItems.get(i)) {
                    o00000Oo.O00000o0.setChecked(true);
                } else {
                    o00000Oo.O00000o0.setChecked(false);
                }
            } else {
                o00000Oo.O00000o0.setVisibility(4);
                o00000Oo.O00000Oo.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.O000000o.AnonymousClass2 */

                    public final boolean onLongClick(View view) {
                        if (!MessageCenterDeviceListActivityNew.this.mEditMode) {
                            MessageCenterDeviceListActivityNew.this.mList.setPullDownEnabled(false);
                            if (!MessageCenterDeviceListActivityNew.this.mCheckedItems.get(i)) {
                                ((O00000Oo) view.getTag()).O00000o0.performClick();
                            }
                            MessageCenterDeviceListActivityNew.this.showDeleteBars();
                            MessageCenterDeviceListActivityNew.this.mEditMode = true;
                            O000000o.this.notifyDataSetChanged();
                        }
                        return true;
                    }
                });
                o00000Oo.O00000Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.O000000o.AnonymousClass3 */

                    public final void onClick(View view) {
                        gul.O000000o(MessageCenterDeviceListActivityNew.this);
                    }
                });
            }
            o00000Oo.O00000o0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew.O000000o.AnonymousClass4 */

                public final void onClick(View view) {
                    if (!MessageCenterDeviceListActivityNew.this.mCheckedItems.get(i)) {
                        MessageCenterDeviceListActivityNew.this.mCheckedItems.put(i, true);
                    } else {
                        MessageCenterDeviceListActivityNew.this.mCheckedItems.delete(i);
                    }
                    if (MessageCenterDeviceListActivityNew.this.mCheckedItems.size() == MessageCenterDeviceListActivityNew.this.mRequestList.size()) {
                        MessageCenterDeviceListActivityNew.this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
                        MessageCenterDeviceListActivityNew.this.mIvSelectAll.setContentDescription(MessageCenterDeviceListActivityNew.this.getString(R.string.unselect_all));
                    } else {
                        MessageCenterDeviceListActivityNew.this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
                        MessageCenterDeviceListActivityNew.this.mIvSelectAll.setContentDescription(MessageCenterDeviceListActivityNew.this.getString(R.string.select_all));
                    }
                    if (MessageCenterDeviceListActivityNew.this.mCheckedItems.size() > 0) {
                        MessageCenterDeviceListActivityNew.this.mSelectedCntTv.setVisibility(0);
                        MessageCenterDeviceListActivityNew.this.mSelectedCntTv.setText(MessageCenterDeviceListActivityNew.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, MessageCenterDeviceListActivityNew.this.mCheckedItems.size(), Integer.valueOf(MessageCenterDeviceListActivityNew.this.mCheckedItems.size())));
                        return;
                    }
                    MessageCenterDeviceListActivityNew.this.mSelectedCntTv.setVisibility(0);
                    MessageCenterDeviceListActivityNew.this.mSelectedCntTv.setText(MessageCenterDeviceListActivityNew.this.getString(R.string.selected_0_cnt_tips));
                }
            });
            return view;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 145 && i2 == 9) {
            gsy.O00000o0(LogType.KUAILIAN, "wugan", " user unregister fast connect success, now start load message list again");
            O000000o();
        }
    }
}
