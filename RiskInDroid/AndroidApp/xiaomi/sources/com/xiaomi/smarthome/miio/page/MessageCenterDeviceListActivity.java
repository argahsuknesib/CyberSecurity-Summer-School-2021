package com.xiaomi.smarthome.miio.page;

import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.guf;
import _m_j.gui;
import _m_j.gul;
import _m_j.gwc;
import _m_j.gwg;
import _m_j.hte;
import _m_j.hzf;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
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
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.smarthome.library.common.widget.viewflow.LoadingMoreView;
import com.xiaomi.smarthome.messagecenter.TypeListMsgCacheManager;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MessageCenterDeviceListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f9761O000000o;
    long O00000Oo = 0;
    long O00000o;
    ImageView O00000o0;
    private View O00000oO;
    private String O00000oo;
    private String O0000O0o;
    private View O0000OOo;
    private View O0000Oo;
    private ImageView O0000Oo0;
    private TextView O0000OoO;
    private TextView O0000Ooo;
    private View O0000o;
    private LoadingMoreView O0000o0;
    private View O0000o00;
    private boolean O0000o0O = false;
    private CharSequence O0000o0o;
    public SparseBooleanArray mCheckedItems = new SparseBooleanArray();
    public boolean mEditMode = false;
    public ImageView mIvSelectAll;
    public int mLastNewMsgPos = -1;
    public PullDownDragListView mList;
    public List<gul> mRequestList = new ArrayList();
    public TextView mSelectedCntTv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.message_center_list);
        Intent intent = getIntent();
        if (intent != null) {
            this.O00000oo = intent.getStringExtra("device_id");
            this.O0000O0o = intent.getStringExtra("device_model");
        }
        if (TextUtils.isEmpty(this.O00000oo) || TextUtils.isEmpty(this.O0000O0o)) {
            finish();
            return;
        }
        this.O0000o0o = intent.getStringExtra("title_name");
        this.mList = (PullDownDragListView) findViewById(R.id.share_message_list);
        this.O0000o0 = new LoadingMoreView(this);
        this.O0000o0.setVisibility(0);
        this.mList.O00000Oo();
        this.mList.setPullDownEnabled(false);
        this.O00000oO = findViewById(R.id.common_white_empty_view);
        this.O00000oO.setVisibility(8);
        ((TextView) findViewById(R.id.common_white_empty_text)).setText((int) R.string.miio_no_message);
        if (!TextUtils.isEmpty(this.O0000o0o)) {
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText(this.O0000o0o);
        } else {
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.miio_setting_message_center);
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.AnonymousClass1 */

            public final void onClick(View view) {
                MessageCenterDeviceListActivity.this.updateTimestamp();
                MessageCenterDeviceListActivity.this.finish();
            }
        });
        this.O00000o0 = (ImageView) findViewById(R.id.module_a_3_return_more_more_btn);
        this.O00000o0.setVisibility(8);
        this.O00000o0.setImageResource(R.drawable.common_title_bar_clear);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.AnonymousClass2 */

            public final void onClick(View view) {
                if (MessageCenterDeviceListActivity.this.mRequestList.size() != 0) {
                    new MLAlertDialog.Builder(MessageCenterDeviceListActivity.this).O00000Oo(MessageCenterDeviceListActivity.this.getResources().getString(R.string.log_clear_all_logs)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            long j = 0;
                            for (gul next : guf.O000000o().O00000o) {
                                if (next.O000000o() > j) {
                                    j = next.O000000o();
                                }
                            }
                            fru.O000000o();
                            fru.O000000o(MessageCenterDeviceListActivity.this, j + 1, new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    MessageRecord.deleteAll();
                                    MessageCenterDeviceListActivity.this.O000000o();
                                }
                            });
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000o().show();
                }
            }
        });
        this.f9761O000000o = new O000000o();
        this.mList.setAdapter((ListAdapter) this.f9761O000000o);
        this.O0000o00 = findViewById(R.id.title_bar);
        this.O0000OOo = findViewById(R.id.top_delete_bar);
        this.mSelectedCntTv = (TextView) this.O0000OOo.findViewById(R.id.selected_cnt);
        this.O0000Oo0 = (ImageView) this.O0000OOo.findViewById(R.id.cancel_btn);
        this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.AnonymousClass3 */

            public final void onClick(View view) {
                MessageCenterDeviceListActivity.this.dismissEditMode();
            }
        });
        this.mIvSelectAll = (ImageView) this.O0000OOo.findViewById(R.id.select_all_btn);
        this.mIvSelectAll.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.AnonymousClass4 */

            public final void onClick(View view) {
                if (MessageCenterDeviceListActivity.this.mCheckedItems.size() == MessageCenterDeviceListActivity.this.mRequestList.size()) {
                    MessageCenterDeviceListActivity.this.unSelectAll();
                } else {
                    MessageCenterDeviceListActivity.this.selectAll();
                }
            }
        });
        this.O0000Oo = findViewById(R.id.bottom_delete_bar);
        this.O0000OoO = (TextView) this.O0000Oo.findViewById(R.id.delete_msg_btn);
        this.O0000OoO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.AnonymousClass5 */

            public final void onClick(View view) {
                MessageCenterDeviceListActivity.this.deleteSelected();
            }
        });
        this.O0000Ooo = (TextView) this.O0000Oo.findViewById(R.id.btm_tip_tv);
        this.O0000Ooo.setVisibility(8);
        if (gwg.O000000o((Activity) this)) {
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.O0000OOo);
        }
        this.O00000o = PreferenceManager.getDefaultSharedPreferences(this).getLong("last_update_time", 0);
        this.O00000Oo = 0;
        O000000o();
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
            gui.O00000Oo(this.O00000oo, Math.max(this.mRequestList.get(0).O00000oo.receiveTime, list2.get(list2.size() - 1).O00000oo.receiveTime));
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        this.mLastNewMsgPos = 0;
        List<Pair<TypeListMsgCacheManager.O000000o, List<gul>>> list = TypeListMsgCacheManager.O000000o().O00000Oo;
        if (list != null) {
            Iterator it = new ArrayList(list).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair pair = (Pair) it.next();
                if (pair.first != null && TextUtils.equals(((TypeListMsgCacheManager.O000000o) pair.first).f9424O000000o, this.O00000oo)) {
                    this.mRequestList = new ArrayList((Collection) pair.second);
                    this.mList.setSelection(this.mRequestList.size() - 1);
                    this.f9761O000000o.notifyDataSetChanged();
                    break;
                }
            }
            List<gul> list2 = this.mRequestList;
            if (list2 != null && list2.size() > 0) {
                int i = 0;
                for (int i2 = 0; i2 < this.mRequestList.size(); i2++) {
                    gul gul = this.mRequestList.get(i2);
                    if (gul != null) {
                        if (!gul.O00000o()) {
                            break;
                        }
                        i++;
                    }
                }
                if (i >= 6) {
                    this.mLastNewMsgPos = i;
                    O00000Oo();
                }
            }
        }
    }

    public void dismissNewMsgTip() {
        this.O0000o.setVisibility(8);
    }

    private void O00000Oo() {
        this.O0000o = findViewById(R.id.new_msg_tip_layout);
        if (this.mLastNewMsgPos <= 0) {
            this.O0000o.setVisibility(8);
            return;
        }
        this.O0000o.setVisibility(0);
        Resources resources = getResources();
        int i = this.mLastNewMsgPos;
        ((TextView) this.O0000o.findViewById(R.id.new_msg_tv)).setText(resources.getQuantityString(R.plurals.msg_center_new_msg_tip, i, Integer.valueOf(i)));
        this.O0000o.findViewById(R.id.new_msg_tip).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.AnonymousClass6 */

            public final void onClick(View view) {
                int count = (MessageCenterDeviceListActivity.this.mList.getCount() - MessageCenterDeviceListActivity.this.mLastNewMsgPos) - MessageCenterDeviceListActivity.this.mList.getFooterViewsCount();
                if (count < 0) {
                    count = 0;
                }
                MessageCenterDeviceListActivity.this.mList.setSelection(count);
                MessageCenterDeviceListActivity.this.dismissNewMsgTip();
            }
        });
        this.mList.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.AnonymousClass7 */

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i2 != 0 && MessageCenterDeviceListActivity.this.mList.getLastVisiblePosition() >= 0 && i3 - i >= MessageCenterDeviceListActivity.this.mLastNewMsgPos) {
                    MessageCenterDeviceListActivity.this.dismissNewMsgTip();
                }
            }
        });
    }

    public void dismissEditMode() {
        this.mList.setPullDownEnabled(true);
        this.mEditMode = false;
        this.mCheckedItems.clear();
        hideDeleteBars();
        this.f9761O000000o.notifyDataSetChanged();
    }

    public void selectAll() {
        int size = this.mRequestList.size();
        for (int i = 0; i < size; i++) {
            this.mCheckedItems.put(i, true);
        }
        this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.unselect_all));
        this.f9761O000000o.notifyDataSetChanged();
        this.mSelectedCntTv.setVisibility(0);
        this.mSelectedCntTv.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size())));
    }

    public void unSelectAll() {
        this.mCheckedItems.clear();
        this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.select_all));
        this.f9761O000000o.notifyDataSetChanged();
        this.mSelectedCntTv.setVisibility(8);
    }

    public void deleteSelected() {
        if (this.mCheckedItems.size() == 0) {
            hte.O000000o(this, (int) R.string.not_select_deleted_msg);
            return;
        }
        new MLAlertDialog.Builder(this).O000000o((int) R.string.delete_msg_title).O00000Oo(getResources().getQuantityString(R.plurals.delete_msg, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size()))).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < MessageCenterDeviceListActivity.this.mCheckedItems.size(); i2++) {
                    int keyAt = MessageCenterDeviceListActivity.this.mCheckedItems.keyAt(i2);
                    if (MessageCenterDeviceListActivity.this.mCheckedItems.get(keyAt) && MessageCenterDeviceListActivity.this.mRequestList.size() > keyAt) {
                        gul gul = (gul) MessageCenterDeviceListActivity.this.f9761O000000o.getItem(keyAt);
                        try {
                            arrayList.add(gul.O00000o0());
                            arrayList2.add(gul);
                        } catch (Exception unused) {
                        }
                    }
                }
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
        TextView f9777O000000o;
        TextView O00000Oo;
        CheckBox O00000o0;

        O00000Oo() {
        }
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        DateFormat f9772O000000o;

        public final long getItemId(int i) {
            return 0;
        }

        public O000000o() {
            this.f9772O000000o = gwc.O000000o((Activity) MessageCenterDeviceListActivity.this);
        }

        public final int getCount() {
            return MessageCenterDeviceListActivity.this.mRequestList.size();
        }

        public final Object getItem(int i) {
            int size = (MessageCenterDeviceListActivity.this.mRequestList.size() - i) - 1;
            if (size < 0 || size >= MessageCenterDeviceListActivity.this.mRequestList.size()) {
                return null;
            }
            return MessageCenterDeviceListActivity.this.mRequestList.get(size);
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
                view = LayoutInflater.from(MessageCenterDeviceListActivity.this).inflate((int) R.layout.message_item_device_list, viewGroup, false);
                o00000Oo = new O00000Oo();
                o00000Oo.f9777O000000o = (TextView) view.findViewById(R.id.date_time_tv);
                o00000Oo.O00000o0 = (CheckBox) view.findViewById(R.id.ratio_btn);
                o00000Oo.O00000Oo = (TextView) view.findViewById(R.id.content_tv);
                view.setTag(o00000Oo);
                o00000Oo.O00000Oo.setTag(o00000Oo);
            } else {
                o00000Oo = (O00000Oo) view.getTag();
            }
            final gul gul = (gul) getItem(i);
            if (gul == null) {
                return view;
            }
            o00000Oo.f9777O000000o.setText(this.f9772O000000o.format(new Date(gul.O00000oo.receiveTime * 1000)));
            if (gul.O00000o()) {
                o00000Oo.O00000Oo.setTextColor(MessageCenterDeviceListActivity.this.getResources().getColor(R.color.mj_color_gray_heavier));
            } else {
                o00000Oo.O00000Oo.setTextColor(MessageCenterDeviceListActivity.this.getResources().getColor(R.color.mj_color_black_50_transparent));
            }
            gul.O000000o(o00000Oo.O00000Oo);
            if (MessageCenterDeviceListActivity.this.mEditMode) {
                o00000Oo.O00000o0.setVisibility(0);
                o00000Oo.O00000Oo.setOnLongClickListener(null);
                o00000Oo.O00000Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.O000000o.AnonymousClass1 */

                    public final void onClick(View view) {
                        ((O00000Oo) view.getTag()).O00000o0.performClick();
                    }
                });
                if (MessageCenterDeviceListActivity.this.mCheckedItems.get(i)) {
                    o00000Oo.O00000o0.setChecked(true);
                } else {
                    o00000Oo.O00000o0.setChecked(false);
                }
            } else {
                o00000Oo.O00000o0.setVisibility(4);
                o00000Oo.O00000Oo.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.O000000o.AnonymousClass2 */

                    public final boolean onLongClick(View view) {
                        if (!MessageCenterDeviceListActivity.this.mEditMode) {
                            MessageCenterDeviceListActivity.this.mList.setPullDownEnabled(false);
                            if (!MessageCenterDeviceListActivity.this.mCheckedItems.get(i)) {
                                ((O00000Oo) view.getTag()).O00000o0.performClick();
                            }
                            MessageCenterDeviceListActivity.this.showDeleteBars();
                            MessageCenterDeviceListActivity.this.mEditMode = true;
                            O000000o.this.notifyDataSetChanged();
                        }
                        return true;
                    }
                });
                o00000Oo.O00000Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.O000000o.AnonymousClass3 */

                    public final void onClick(View view) {
                        gul.O000000o(MessageCenterDeviceListActivity.this);
                    }
                });
            }
            o00000Oo.O00000o0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.page.MessageCenterDeviceListActivity.O000000o.AnonymousClass4 */

                public final void onClick(View view) {
                    if (!MessageCenterDeviceListActivity.this.mCheckedItems.get(i)) {
                        MessageCenterDeviceListActivity.this.mCheckedItems.put(i, true);
                    } else {
                        MessageCenterDeviceListActivity.this.mCheckedItems.delete(i);
                    }
                    if (MessageCenterDeviceListActivity.this.mCheckedItems.size() == MessageCenterDeviceListActivity.this.mRequestList.size()) {
                        MessageCenterDeviceListActivity.this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
                        MessageCenterDeviceListActivity.this.mIvSelectAll.setContentDescription(MessageCenterDeviceListActivity.this.getString(R.string.unselect_all));
                    } else {
                        MessageCenterDeviceListActivity.this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
                        MessageCenterDeviceListActivity.this.mIvSelectAll.setContentDescription(MessageCenterDeviceListActivity.this.getString(R.string.select_all));
                    }
                    if (MessageCenterDeviceListActivity.this.mCheckedItems.size() > 0) {
                        MessageCenterDeviceListActivity.this.mSelectedCntTv.setVisibility(0);
                        MessageCenterDeviceListActivity.this.mSelectedCntTv.setText(MessageCenterDeviceListActivity.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, MessageCenterDeviceListActivity.this.mCheckedItems.size(), Integer.valueOf(MessageCenterDeviceListActivity.this.mCheckedItems.size())));
                        return;
                    }
                    MessageCenterDeviceListActivity.this.mSelectedCntTv.setVisibility(0);
                    MessageCenterDeviceListActivity.this.mSelectedCntTv.setText(MessageCenterDeviceListActivity.this.getString(R.string.selected_0_cnt_tips));
                }
            });
            return view;
        }
    }
}
