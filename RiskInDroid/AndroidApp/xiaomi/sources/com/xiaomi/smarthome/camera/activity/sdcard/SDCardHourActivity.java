package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.chr;
import _m_j.cih;
import _m_j.clf;
import _m_j.clo;
import _m_j.clq;
import _m_j.clu;
import _m_j.clv;
import _m_j.ft;
import _m_j.gkv;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.izb;
import _m_j.mi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.BaseSelectActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.RecyclerEventTypeAdapter;
import com.xiaomi.smarthome.camera.activity.alarm2.bean.EventType;
import com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerClickListener;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SDCardHourActivity extends BaseSelectActivity implements clo.O00000Oo, RecyclerClickListener {
    public static final String TAG = "SDCardHourActivity";
    private List<TimeItemData> allEventList = new ArrayList();
    RecyclerEventTypeAdapter eventTypeAdapter;
    private int[] eventTypes = {-1, 4, 0, 1, 2, 7};
    private String[] eventTypesDesc = {gkv.f17949O000000o.getResources().getString(R.string.event_type_all), gkv.f17949O000000o.getResources().getString(R.string.event_type_face), gkv.f17949O000000o.getResources().getString(R.string.event_type_obj_motion), gkv.f17949O000000o.getResources().getString(R.string.event_type_people_motion), gkv.f17949O000000o.getResources().getString(R.string.pet_move), gkv.f17949O000000o.getResources().getString(R.string.event_type_baby_cry)};
    RecyclerView event_type_recycler;
    ImageView iv_more_record;
    LinearLayout ll_calendar_bg;
    public SDCardHourAdapter mAdapter;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            if (SDCardHourActivity.this.mCameraDevice == null) {
                return;
            }
            if (SDCardHourActivity.this.mCameraDevice.O00000o()) {
                SDCardHourActivity.this.mCameraDevice.O0000Oo0();
                if ("com.mijia.camera.SdcardManagerEx".equals(intent.getAction())) {
                    SDCardHourActivity.this.refreshData();
                    return;
                }
                return;
            }
            SDCardHourActivity.this.mCameraDevice.O0000OOo();
            if ("com.mijia.camera.SdcardManager".equals(intent.getAction())) {
                SDCardHourActivity.this.refreshData();
            }
        }
    };
    public EventType mCurEventType = new EventType();
    private int mDay;
    clo mDownloadSdCardFileManager;
    public LinearLayout mEmptyLayout;
    private int mHour;
    public RecyclerView mListView;
    ft mLocalBroadcastManager;
    HashSet<Long> mNeedCheckList = new HashSet<>();
    public XQProgressDialog mProgressDialog;
    SimpleDateFormat mSimpleDateFormat;
    SimpleDateFormat mSimpleDateFormat1;
    List<TimeItemData> mTimeItemDataList = new ArrayList();
    List<TimeItem> mTimeItemList = new ArrayList();
    private long timeStamp = 0;
    TextView tv_all_record;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_sdcard_hour);
        this.mDay = getIntent().getIntExtra("TimeItemsDays", 0);
        this.mHour = getIntent().getIntExtra("TimeItemsHour", 0);
        this.mSimpleDateFormat = new SimpleDateFormat(getString(R.string.simple_date_format_mm_dd));
        this.mSimpleDateFormat1 = new SimpleDateFormat(getString(R.string.simple_date_format_hh_mm));
        if (getIntent().getExtras() != null) {
            this.timeStamp = getIntent().getExtras().getLong("timeStamp", 0);
        }
        String str = TAG;
        gsy.O00000Oo(str, "mDay=" + this.mDay + " mHour=" + this.mHour);
        this.mSimpleDateFormat.setTimeZone(mi.O000000o());
        this.mSimpleDateFormat1.setTimeZone(mi.O000000o());
        this.mLocalBroadcastManager = ft.O000000o(activity());
        if (this.mCameraDevice.O00000o()) {
            this.mDownloadSdCardFileManager = this.mCameraDevice.O0000o0();
        } else {
            this.mDownloadSdCardFileManager = this.mCameraDevice.O0000o00();
        }
        this.mDownloadSdCardFileManager.O000000o(this);
        IntentFilter intentFilter = new IntentFilter();
        this.mCameraDevice.O0000O0o();
        intentFilter.addAction("com.mijia.camera.LocalFileManager");
        this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver, intentFilter);
        initView();
        updateEventType(true);
    }

    private void updateEventType(boolean z) {
        int length = this.eventTypes.length;
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            if ((DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel()) || i != 3) && ((DeviceConstant.isSupportFaceNative(this.mCameraDevice.getModel()) || i != 1) && ((DeviceConstant.isSupportPetNative(this.mCameraDevice.getModel()) || i != 4) && (7 != this.eventTypes[i] || clf.f14036O000000o)))) {
                EventType eventType = new EventType();
                int[] iArr = this.eventTypes;
                eventType.eventType = iArr[i];
                if (iArr[i] == 2) {
                    eventType.eventTypeB = 3;
                }
                if (this.eventTypes[i] == 4) {
                    eventType.eventTypeB = 5;
                }
                eventType.desc = this.eventTypesDesc[i];
                arrayList.add(eventType);
            }
        }
        this.mCurEventType = (EventType) arrayList.get(0);
        this.tv_all_record.setText(this.mCurEventType.desc);
        this.eventTypeAdapter = new RecyclerEventTypeAdapter(activity(), arrayList, new RecyclerEventTypeAdapter.OnItemClick() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass2 */

            public void onItemClick(int i) {
                SDCardHourActivity.this.mCurEventType = (EventType) arrayList.get(i);
                SDCardHourActivity.this.tv_all_record.setText(SDCardHourActivity.this.mCurEventType.desc);
                SDCardHourActivity.this.onEventTypeBgClick();
                SDCardHourActivity.this.setEventTypeDatas();
                if (SDCardHourActivity.this.mTimeItemDataList.isEmpty()) {
                    SDCardHourActivity.this.mListView.setVisibility(8);
                    SDCardHourActivity.this.mEmptyLayout.setVisibility(0);
                } else {
                    SDCardHourActivity.this.mListView.setVisibility(0);
                    SDCardHourActivity.this.mEmptyLayout.setVisibility(8);
                    if (!SDCardHourActivity.this.mCameraDevice.isReadOnlyShared()) {
                        SDCardHourActivity.this.mEditBtn.setVisibility(0);
                        SDCardHourActivity.this.mAdapter.setData(SDCardHourActivity.this.mTimeItemDataList);
                        SDCardHourActivity.this.mAdapter.notifyDataSetChanged();
                        SDCardHourActivity.this.refreshSelectTitle();
                    }
                }
                SDCardHourActivity.this.mEditBtn.setVisibility(8);
                SDCardHourActivity.this.mAdapter.setData(SDCardHourActivity.this.mTimeItemDataList);
                SDCardHourActivity.this.mAdapter.notifyDataSetChanged();
                SDCardHourActivity.this.refreshSelectTitle();
            }
        });
        this.event_type_recycler.setLayoutManager(new GridLayoutManager(activity(), 2));
        this.event_type_recycler.setAdapter(this.eventTypeAdapter);
    }

    private void initView() {
        this.iv_more_record = (ImageView) findViewById(R.id.iv_more_record);
        this.tv_all_record = (TextView) findViewById(R.id.tv_all_record);
        this.event_type_recycler = (RecyclerView) findViewById(R.id.event_type_recycler);
        this.ll_calendar_bg = (LinearLayout) findViewById(R.id.ll_calendar_bg);
        this.ll_calendar_bg.setOnClickListener(this);
        initSelectView();
        findViewById(R.id.ll_all_record).setOnClickListener(this);
        if (DeviceConstant.supportNewPlayBack(this.mCameraDevice.getModel())) {
            findViewById(R.id.ll_all_record).setVisibility(0);
        }
        this.mEmptyLayout = (LinearLayout) findViewById(R.id.empty_layout);
        this.mListView = (RecyclerView) findViewById(R.id.list_view);
        this.mAdapter = new SDCardHourAdapter(this.mListView, this, this, this.mDid, this.isV4);
        this.mListView.setLayoutManager(new GridLayoutManager(this, 3));
        this.mListView.setAdapter(this.mAdapter);
        TextView textView = (TextView) findViewById(R.id.title_bar_title);
        long j = this.timeStamp;
        if (j == 0) {
            textView.setText((int) R.string.record_files_sdcard_title);
        } else {
            String O00000o = mi.O00000o(j);
            Object[] objArr = new Object[2];
            objArr[0] = O00000o;
            StringBuilder sb = this.mHour > 9 ? new StringBuilder() : new StringBuilder("0");
            sb.append(this.mHour);
            objArr[1] = sb.toString();
            textView.setText(String.format("%s %s:00", objArr));
        }
        if (DeviceConstant.supportDownloadToPhone(this.mCameraDevice.getModel())) {
            findViewById(R.id.select_down).setVisibility(0);
            findViewById(R.id.select_down).setOnClickListener(this);
        } else {
            findViewById(R.id.select_save).setVisibility(0);
            findViewById(R.id.select_save).setOnClickListener(this);
        }
        findViewById(R.id.select_delete).setOnClickListener(this);
    }

    public int getSelectCount() {
        return this.mAdapter.getSelectCount();
    }

    public int getDataCount() {
        return this.mAdapter.getItemCount();
    }

    public void onResume() {
        super.onResume();
        refreshData();
    }

    public void onPause() {
        super.onPause();
    }

    public void setMultiSelectMode(boolean z) {
        super.setMultiSelectMode(z);
        this.mAdapter.setSelectMode(z);
    }

    public void onEventTypeBgClick() {
        showOrHideEventType(false, null);
    }

    public void showOrHideEventType(boolean z, AnimUtil.AnimEndListener animEndListener) {
        if (z) {
            AnimUtil.animLayoutTop(activity(), true, null, this.ll_calendar_bg, this.event_type_recycler, animEndListener);
            this.iv_more_record.setImageResource(R.drawable.icon_select_up);
            this.tv_all_record.setTextColor(getResources().getColorStateList(R.color.mj_color_green_normal));
            return;
        }
        AnimUtil.animLayoutTop(activity(), false, null, this.ll_calendar_bg, this.event_type_recycler, animEndListener);
        this.iv_more_record.setImageResource(R.drawable.icon_select_down);
        this.tv_all_record.setTextColor(getResources().getColorStateList(R.color.mj_color_black));
    }

    public void onClick(View view) {
        boolean z = true;
        if (view.getId() == R.id.ll_all_record) {
            if (this.event_type_recycler.getVisibility() == 0) {
                z = false;
            }
            showOrHideEventType(z, null);
        } else if (view.getId() == R.id.ll_calendar_bg) {
            if (this.event_type_recycler.getVisibility() == 0) {
                onEventTypeBgClick();
            }
        } else if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.title_bar_more) {
            if (this.mCameraDevice.isReadOnlyShared()) {
                activity();
                gqg.O000000o((int) R.string.auth_fail_read_only);
                return;
            }
            setMultiSelectMode(true);
        } else if (view.getId() == R.id.ivSelectAll) {
            if (this.mSelectAllShowed) {
                this.mSelectAllShowed = false;
                this.mSelectAllBtn.setImageResource(R.drawable.camera_edit_deselect_all_black);
                this.mAdapter.selectAll();
            } else {
                this.mSelectAllShowed = true;
                this.mSelectAllBtn.setImageResource(R.drawable.camera_edit_select_all_black);
                this.mAdapter.unSelectAll();
            }
            refreshSelectTitle();
        } else if (view.getId() == R.id.ivSelectAllCancel) {
            setMultiSelectMode(false);
        } else if (view.getId() == R.id.select_down) {
            if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                getContext();
                gqg.O000000o((int) R.string.no_write_permission);
                return;
            }
            initProgressDlg();
            ArrayList<TimeItem> selectItems = this.mAdapter.getSelectItems();
            if (selectItems == null || selectItems.size() == 0) {
                gqg.O00000Oo((int) R.string.bottom_action_tip);
                return;
            }
            for (TimeItem O00000o0 : selectItems) {
                this.mDownloadSdCardFileManager.O00000o0(O00000o0);
            }
            this.mDownloadSdCardFileManager.O000000o();
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setMessage(getString(R.string.cs_downloading));
            this.mProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass3 */

                public void onDismiss(DialogInterface dialogInterface) {
                    SDCardHourActivity.this.mProgressDialog.setOnDismissListener(null);
                    SDCardHourActivity.this.mDownloadSdCardFileManager.O00000o = true;
                }
            });
            this.mProgressDialog.show();
            setMultiSelectMode(false);
        } else if (view.getId() == R.id.select_save) {
            ArrayList<TimeItem> selectItems2 = this.mAdapter.getSelectItems();
            initProgressDlg();
            cih.O00000Oo(activity(), this.mCameraDevice, selectItems2, this.mProgressDialog, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass4 */

                public void onSuccess(Void voidR) {
                    if (!SDCardHourActivity.this.isFinishing()) {
                        SDCardHourActivity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass4.AnonymousClass1 */

                            public void run() {
                                izb.O000000o(SDCardHourActivity.this.activity(), (int) R.string.save_sucess, 0).show();
                                SDCardHourActivity.this.disProgressDlg();
                                SDCardHourActivity.this.setMultiSelectMode(false);
                                SDCardHourActivity.this.refreshData();
                            }
                        });
                    }
                }

                public void onFailure(int i, String str) {
                    if (!SDCardHourActivity.this.isFinishing()) {
                        SDCardHourActivity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass4.AnonymousClass2 */

                            public void run() {
                                SDCardHourActivity.this.disProgressDlg();
                                izb.O000000o(SDCardHourActivity.this.activity(), (int) R.string.save_failed, 0).show();
                            }
                        });
                    }
                }
            });
        } else if (view.getId() == R.id.select_delete) {
            ArrayList<TimeItem> selectItems3 = this.mAdapter.getSelectItems();
            initProgressDlg();
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setMessage(getString(R.string.deleting));
            cih.O000000o(activity(), this.mCameraDevice, selectItems3, this.mProgressDialog, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass5 */

                public void onSuccess(Void voidR) {
                    if (!SDCardHourActivity.this.isFinishing()) {
                        SDCardHourActivity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass5.AnonymousClass1 */

                            public void run() {
                                izb.O000000o(SDCardHourActivity.this.activity(), (int) R.string.delete_sucess, 0).show();
                                SDCardHourActivity.this.disProgressDlg();
                                SDCardHourActivity.this.setMultiSelectMode(false);
                                SDCardHourActivity.this.refreshData();
                            }
                        });
                    }
                }

                public void onFailure(int i, String str) {
                    if (!SDCardHourActivity.this.isFinishing()) {
                        SDCardHourActivity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass5.AnonymousClass2 */

                            public void run() {
                                SDCardHourActivity.this.disProgressDlg();
                                izb.O000000o(SDCardHourActivity.this.activity(), (int) R.string.delete_failed, 0).show();
                            }
                        });
                    }
                }
            });
        }
    }

    public void refreshData() {
        if (!this.mIsMultiSelectMode) {
            List<clu> O0000OOo = this.mCameraDevice.O0000OOo().O0000OOo();
            if (this.mCameraDevice.O00000o()) {
                O0000OOo = this.mCameraDevice.O0000Oo0().O0000OOo();
            }
            int i = this.mDay;
            if (i < 0 || i >= O0000OOo.size()) {
                this.mTimeItemList = new ArrayList();
            } else {
                clv O000000o2 = O0000OOo.get(this.mDay).O000000o(this.mHour);
                if (O000000o2 != null) {
                    this.mTimeItemList = O000000o2.O00000o0;
                } else {
                    this.mTimeItemList = new ArrayList();
                }
            }
            this.allEventList.clear();
            for (int i2 = 0; i2 < this.mTimeItemList.size(); i2++) {
                TimeItem timeItem = this.mTimeItemList.get(i2);
                TimeItemData timeItemData = new TimeItemData();
                timeItemData.timeItem = timeItem;
                timeItemData.timeItem.O00000o = clq.O000000o(timeItem.f5243O000000o);
                timeItemData.title = this.mSimpleDateFormat1.format(Long.valueOf(timeItem.f5243O000000o)) + "-" + this.mSimpleDateFormat1.format(Long.valueOf(timeItem.O00000o0));
                timeItemData.subTitle = this.mSimpleDateFormat.format(Long.valueOf(timeItem.f5243O000000o));
                timeItemData.localFile = this.mCameraDevice.O0000O0o().O000000o(timeItem.f5243O000000o);
                timeItemData.downloadItem = this.mDownloadSdCardFileManager.O000000o(timeItem);
                this.allEventList.add(timeItemData);
                this.mNeedCheckList.add(Long.valueOf(timeItem.f5243O000000o));
            }
            setEventTypeDatas();
            if (this.mTimeItemDataList.isEmpty()) {
                this.mListView.setVisibility(8);
                this.mEmptyLayout.setVisibility(0);
            } else {
                this.mListView.setVisibility(0);
                this.mEmptyLayout.setVisibility(8);
                if (!this.mCameraDevice.isReadOnlyShared()) {
                    this.mEditBtn.setVisibility(0);
                    this.mAdapter.setData(this.mTimeItemDataList);
                    this.mAdapter.notifyDataSetChanged();
                }
            }
            this.mEditBtn.setVisibility(8);
            this.mAdapter.setData(this.mTimeItemDataList);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setEventTypeDatas() {
        this.mTimeItemDataList.clear();
        if (this.mCurEventType.eventType == -1) {
            this.mTimeItemDataList.addAll(this.allEventList);
            return;
        }
        for (TimeItemData next : this.allEventList) {
            if (next.timeItem.O00000o == this.mCurEventType.eventType) {
                this.mTimeItemDataList.add(next);
            } else if (2 == this.mCurEventType.eventType && next.timeItem.O00000o == this.mCurEventType.eventTypeB) {
                this.mTimeItemDataList.add(next);
            } else if (4 == this.mCurEventType.eventType && next.timeItem.O00000o == this.mCurEventType.eventTypeB) {
                this.mTimeItemDataList.add(next);
            }
        }
    }

    public void initProgressDlg() {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new XQProgressDialog(activity());
        }
    }

    public void disProgressDlg() {
        XQProgressDialog xQProgressDialog = this.mProgressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        SDCardHourAdapter sDCardHourAdapter = this.mAdapter;
        if (sDCardHourAdapter != null) {
            sDCardHourAdapter.destroyDisplayImageOptions();
        }
        if (this.mCameraDevice != null) {
            this.mDownloadSdCardFileManager.O000000o((clo.O00000Oo) null);
        }
        ft ftVar = this.mLocalBroadcastManager;
        if (ftVar != null) {
            ftVar.O000000o(this.mBroadcastReceiver);
        }
    }

    public void onDownloading(final clo.O000000o o000000o, String str, int i) {
        runMainThread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass6 */

            public void run() {
                if (SDCardHourActivity.this.mNeedCheckList.contains(Long.valueOf(o000000o.f14088O000000o.f5243O000000o))) {
                    for (int i = 0; i < SDCardHourActivity.this.mTimeItemDataList.size(); i++) {
                        if (SDCardHourActivity.this.mTimeItemDataList.get(i).timeItem.equals(o000000o.f14088O000000o)) {
                            SDCardHourActivity.this.mTimeItemDataList.get(i).downloadItem = o000000o;
                            SDCardHourActivity.this.mAdapter.notifyItemChanged(i);
                            return;
                        }
                    }
                }
            }
        });
    }

    public void onDownloadSuccess(clo.O000000o o000000o, String str) {
        if (this.mNeedCheckList.contains(Long.valueOf(o000000o.f14088O000000o.f5243O000000o))) {
            runMainThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass7 */

                public void run() {
                    SDCardHourActivity.this.disProgressDlg();
                }
            });
        }
    }

    public void onDownloadFailed(clo.O000000o o000000o, String str, int i, String str2) {
        if (this.mNeedCheckList.contains(Long.valueOf(o000000o.f14088O000000o.f5243O000000o))) {
            runMainThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourActivity.AnonymousClass8 */

                public void run() {
                    SDCardHourActivity.this.disProgressDlg();
                }
            });
        }
    }

    public void onRecyclerClick(View view) {
        int childLayoutPosition = this.mListView.getChildLayoutPosition(view);
        if (!this.mIsMultiSelectMode) {
            chr.O000000o(chr.O00O00o);
            if (view.getTag() != null) {
                TimeItemData timeItemData = (TimeItemData) view.getTag();
                Intent intent = new Intent(this, SDCardPlayerActivity.class);
                if (this.mCameraDevice != null && this.mCameraDevice.O00000o()) {
                    intent.setClass(this, SDCardPlayerExActivity.class);
                }
                intent.putExtra("mDay", this.mDay);
                intent.putExtra("mHour", this.mHour);
                intent.putExtra("pos", this.allEventList.indexOf(timeItemData));
                intent.putExtra("time", timeItemData.timeItem);
                startActivity(intent);
            }
        } else if (childLayoutPosition >= 0 && childLayoutPosition < this.mAdapter.getItemCount()) {
            this.mAdapter.selectToggle(childLayoutPosition);
            refreshSelectTitle();
            this.mAdapter.notifyItemChanged(childLayoutPosition);
        }
    }

    public void onRecyclerLongClick(View view) {
        if (this.mCameraDevice.isReadOnlyShared()) {
            activity();
            gqg.O000000o((int) R.string.auth_fail_read_only);
            return;
        }
        int childLayoutPosition = this.mListView.getChildLayoutPosition(view);
        if (childLayoutPosition >= 0 && childLayoutPosition < this.mAdapter.getItemCount()) {
            this.mAdapter.selectToggle(childLayoutPosition);
            if (!this.mIsMultiSelectMode) {
                setMultiSelectMode(true, true);
                this.mAdapter.setSelectMode(true);
            } else {
                this.mAdapter.notifyItemChanged(childLayoutPosition);
            }
            refreshSelectTitle();
        }
    }
}
