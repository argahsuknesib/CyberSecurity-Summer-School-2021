package com.xiaomi.smarthome.camera.v4.activity.alarm;

import _m_j.chp;
import _m_j.clb;
import _m_j.gwg;
import _m_j.hzf;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity;
import com.xiaomi.smarthome.camera.v4.activity.BaseSelectActivity;
import com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayAdapter;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout;
import com.xiaomi.smarthome.camera.view.widget.WeekView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AlarmDayActivity extends BaseSelectActivity implements AlarmDayAdapter.ClickCallBack, WeekView.OnDayChangeListener {
    private HashMap<Integer, ArrayList<AlarmDayBean>> cachMap = new HashMap<>();
    private boolean isFromRn;
    public AlarmDayAdapter mAdapter;
    public LinearLayout mCareNoEventOfDayLl;
    public RecyclerView mMediaListView;
    public XQProgressDialog mProgressDlg;
    public XQProgressDialog mPulingDlg;
    public RecyclerViewRefreshLayout mRefreshLayout;
    private SimpleDateFormat mTimeFormater0 = new SimpleDateFormat("HH:mm");
    private WeekView mWeekView;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_alarm_day);
        gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.title_bar_container));
        this.isFromRn = getIntent().getBooleanExtra("is_from_rn", false);
        initView();
        loadData(true, true);
    }

    public void onResume() {
        super.onResume();
        if (this.mCameraDevice != null && this.mCameraDevice.isReadOnlyShared()) {
            findViewById(R.id.title_bar_more).setEnabled(false);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.cachMap.clear();
        AlarmDayAdapter alarmDayAdapter = this.mAdapter;
        if (alarmDayAdapter != null) {
            alarmDayAdapter.destroyDisplayImageOptions();
        }
    }

    private void initView() {
        initSelectView();
        this.mWeekView = (WeekView) findViewById(R.id.view_week_view);
        this.mCareNoEventOfDayLl = (LinearLayout) findViewById(R.id.layout_care_no_event_of_day_ll);
        this.mWeekView.setOnDayChangeListener(this);
        findViewById(R.id.select_delete).setOnClickListener(this);
        this.mMediaListView = (RecyclerView) findViewById(R.id.list_event_listview);
        ((TextView) findViewById(R.id.title_bar_title)).setText(getResources().getString(R.string.history_alarm_string));
        this.mRefreshLayout = (RecyclerViewRefreshLayout) findViewById(R.id.recycle_refresh);
        this.mRefreshLayout.setOnPullRefreshListener(new RecyclerViewRefreshLayout.OnPullRefreshListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayActivity.AnonymousClass1 */

            public void onPullDistance(int i) {
            }

            public void onPullEnable(boolean z) {
            }

            public void onRefresh() {
                if (!AlarmDayActivity.this.isFinishing()) {
                    AlarmDayActivity.this.loadData(true, false);
                }
            }
        });
        this.mMediaListView.setLayoutManager(new GridLayoutManager(this, 3));
        this.mAdapter = new AlarmDayAdapter(this, this);
        this.mMediaListView.setAdapter(this.mAdapter);
        this.mMediaListView.addItemDecoration(new ItemDecoration());
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.select_delete) {
            deleteAlertDialog();
        } else if (id == R.id.ivSelectAllCancel) {
            if (this.mIsMultiSelectMode) {
                setMultiSelectMode(false);
            }
        } else if (id == R.id.title_bar_more) {
            if (this.mCareNoEventOfDayLl.getVisibility() == 0) {
                izb.O000000o(this, (int) R.string.edit_no_data, 0).show();
            } else {
                setMultiSelectMode(true);
            }
        } else if (id != R.id.ivSelectAll) {
        } else {
            if (this.mSelectAllShowed) {
                this.mSelectAllShowed = false;
                this.mSelectAllBtn.setImageResource(R.drawable.icon_edit_deselect_all_black);
                this.mAdapter.selectAll();
                refreshSelectTitle();
                return;
            }
            this.mSelectAllShowed = true;
            this.mSelectAllBtn.setImageResource(R.drawable.icon_edit_select_all_black);
            this.mAdapter.unSelectAll();
            refreshSelectTitle();
        }
    }

    public void onDayChange(boolean z, int i, int i2, int i3) {
        setMultiSelectMode(false);
        loadData(false, true);
    }

    public void loadData(boolean z, boolean z2) {
        ArrayList arrayList = this.cachMap.get(Integer.valueOf(this.mWeekView.getCurrentDay()));
        if (arrayList == null || arrayList.isEmpty() || z) {
            final int currentDay = this.mWeekView.getCurrentDay();
            if (z2) {
                showLoadDlg();
            }
            this.mCameraDevice.O0000o0O().O000000o((long) this.mWeekView.getCurrentStartTime(), (long) this.mWeekView.getCurrentEndTime(), new Callback<List<clb>>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayActivity.AnonymousClass2 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<clb>) ((List) obj));
                }

                public void onSuccess(final List<clb> list) {
                    AlarmDayActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayActivity.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            if (!AlarmDayActivity.this.isFinishing()) {
                                AlarmDayActivity.this.dealAlarm(currentDay, list);
                                if (AlarmDayActivity.this.mPulingDlg != null && AlarmDayActivity.this.mPulingDlg.isShowing()) {
                                    AlarmDayActivity.this.mPulingDlg.dismiss();
                                }
                                if (AlarmDayActivity.this.mRefreshLayout.isRefreshing()) {
                                    AlarmDayActivity.this.mRefreshLayout.setRefreshing(false);
                                }
                            }
                        }
                    });
                }

                public void onFailure(int i, String str) {
                    AlarmDayActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayActivity.AnonymousClass2.AnonymousClass2 */

                        public void run() {
                            if (!AlarmDayActivity.this.isFinishing()) {
                                if (AlarmDayActivity.this.mPulingDlg != null) {
                                    AlarmDayActivity.this.mPulingDlg.dismiss();
                                }
                                if (AlarmDayActivity.this.mRefreshLayout.isRefreshing()) {
                                    AlarmDayActivity.this.mRefreshLayout.setRefreshing(false);
                                }
                                AlarmDayActivity.this.mMediaListView.setVisibility(8);
                                AlarmDayActivity.this.mCareNoEventOfDayLl.setVisibility(0);
                            }
                        }
                    });
                }
            });
            return;
        }
        this.mAdapter.setData(arrayList);
        this.mCareNoEventOfDayLl.setVisibility(8);
        this.mMediaListView.setVisibility(0);
    }

    public void dealAlarm(int i, List<clb> list) {
        Object obj;
        List<clb> list2 = list;
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            Date date = new Date(list2.get(0).O00000Oo);
            date.setMinutes(0);
            date.setSeconds(0);
            long time = date.getTime();
            long j = 3600000;
            String format = this.mTimeFormater0.format(date);
            date.setTime(date.getTime() + 3600000);
            arrayList.add(new AlarmDayBean(format + "-" + this.mTimeFormater0.format(date), null));
            long j2 = time + 3600000;
            long j3 = time;
            int i2 = 0;
            while (i2 < list.size()) {
                clb clb = list2.get(i2);
                long j4 = clb.O00000Oo;
                if (j4 < j3 || j4 >= j2) {
                    j3 -= j;
                    j2 -= j;
                    date.setTime(j3);
                    String format2 = this.mTimeFormater0.format(date);
                    date.setTime(j2);
                    obj = null;
                    arrayList.add(new AlarmDayBean(format2 + "-" + this.mTimeFormater0.format(date), null));
                    arrayList.add(new AlarmDayBean(this.mTimeFormater0.format(new Date(j4)), clb));
                } else {
                    arrayList.add(new AlarmDayBean(this.mTimeFormater0.format(new Date(j4)), clb));
                    obj = null;
                }
                i2++;
                j = 3600000;
            }
        }
        if (!arrayList.isEmpty()) {
            this.cachMap.put(Integer.valueOf(i), arrayList);
            if (this.mWeekView.getCurrentDay() == i) {
                this.mCareNoEventOfDayLl.setVisibility(8);
                this.mMediaListView.setVisibility(0);
                this.mAdapter.setData(arrayList);
                return;
            }
            return;
        }
        this.mAdapter.setData(new ArrayList());
        this.cachMap.put(Integer.valueOf(i), arrayList);
        this.mMediaListView.setVisibility(8);
        this.mCareNoEventOfDayLl.setVisibility(0);
    }

    public void onRecyclerClick(View view) {
        if (this.mIsMultiSelectMode) {
            int childLayoutPosition = this.mMediaListView.getChildLayoutPosition(view);
            if (childLayoutPosition >= 0 && childLayoutPosition < this.mAdapter.getItemCount()) {
                this.mAdapter.selectToggle(childLayoutPosition);
                refreshSelectTitle();
                this.mAdapter.notifyItemChanged(childLayoutPosition);
                return;
            }
            return;
        }
        Object tag = view.getTag();
        if (tag != null) {
            Intent intent = new Intent();
            intent.putExtra("time", ((clb) tag).O00000Oo / 1000);
            intent.setClass(this, LocalAlarmPlayerActivity.class);
            intent.putExtra("isFromRn", this.isFromRn);
            startActivityForResult(intent, 1001);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            loadData(true, false);
        }
    }

    public void onRecyclerLongClick(View view) {
        int childLayoutPosition = this.mMediaListView.getChildLayoutPosition(view);
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

    public void setMultiSelectMode(boolean z) {
        setMultiSelectMode(z, false);
        this.mAdapter.setSelectMode(z);
    }

    private void deleteAlertDialog() {
        if (this.mAdapter.getSelectedCount() == 0) {
            izb.O000000o(this, (int) R.string.bottom_action_tip, 0).show();
            return;
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O00000Oo(getString(R.string.delete_hint, new Object[]{Integer.valueOf(this.mAdapter.getSelectedCount())}));
        builder.O00000Oo((int) R.string.camera_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayActivity.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                AlarmDayActivity.this.setMultiSelectMode(false);
                dialogInterface.dismiss();
            }
        });
        builder.O000000o((int) R.string.camera_sure, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayActivity.AnonymousClass4 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                AlarmDayActivity.this.showProgressDlg();
                ArrayList<clb> selectList = AlarmDayActivity.this.mAdapter.getSelectList();
                AlarmDayActivity.this.setMultiSelectMode(false);
                AlarmDayActivity.this.mCameraDevice.O0000o0O().O000000o(selectList, new Callback<Void>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayActivity.AnonymousClass4.AnonymousClass1 */

                    public void onSuccess(Void voidR) {
                        if (!AlarmDayActivity.this.isFinishing()) {
                            AlarmDayActivity.this.runOnUiThread(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayActivity.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    if (AlarmDayActivity.this.mProgressDlg != null && AlarmDayActivity.this.mProgressDlg.isShowing()) {
                                        AlarmDayActivity.this.mProgressDlg.dismiss();
                                    }
                                    izb.O000000o(AlarmDayActivity.this, (int) R.string.delete_sucess, 0).show();
                                    AlarmDayActivity.this.loadData(true, false);
                                }
                            });
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!AlarmDayActivity.this.isFinishing()) {
                            AlarmDayActivity.this.runOnUiThread(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayActivity.AnonymousClass4.AnonymousClass1.AnonymousClass2 */

                                public void run() {
                                    if (AlarmDayActivity.this.mProgressDlg != null && AlarmDayActivity.this.mProgressDlg.isShowing()) {
                                        AlarmDayActivity.this.mProgressDlg.dismiss();
                                    }
                                    izb.O000000o(AlarmDayActivity.this, (int) R.string.delete_failed, 0).show();
                                }
                            });
                        }
                    }
                });
            }
        });
        builder.O00000oo();
    }

    public void showLoadDlg() {
        if (this.mPulingDlg == null) {
            this.mPulingDlg = new XQProgressDialog(this);
            this.mPulingDlg.setMessage(getResources().getString(R.string.camera_loading));
            this.mPulingDlg.setCancelable(false);
        }
        this.mPulingDlg.show();
    }

    public void showProgressDlg() {
        if (this.mProgressDlg == null) {
            this.mProgressDlg = new XQProgressDialog(this);
            this.mProgressDlg.setCancelable(false);
            this.mProgressDlg.setMessage(getResources().getString(R.string.deleting));
        }
        this.mProgressDlg.show();
    }

    public void onBackPressed() {
        if (this.mIsMultiSelectMode) {
            setMultiSelectMode(false);
        } else {
            super.onBackPressed();
        }
    }

    public int getSelectCount() {
        return this.mAdapter.getSelectedCount();
    }

    public int getDataCount() {
        return this.mAdapter.getDataCount();
    }

    class ItemDecoration extends RecyclerView.O0000Oo {
        private int space;

        public ItemDecoration() {
            this.space = 0;
            this.space = (int) (chp.O00000o0 * 2.0f);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            int i;
            int i2;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition >= 0 && childAdapterPosition < AlarmDayActivity.this.mAdapter.getItemCount()) {
                if (recyclerView.getAdapter().getItemViewType(childAdapterPosition) == 0) {
                    rect.set(0, 0, 0, 0);
                    return;
                }
                int dayIndex = AlarmDayActivity.this.mAdapter.getDayIndex(childAdapterPosition);
                if (dayIndex >= 0) {
                    int i3 = dayIndex % 3;
                    if (i3 == 1) {
                        i2 = this.space;
                        i = i2 * 7;
                    } else {
                        if (i3 == 2) {
                            i2 = this.space;
                        } else {
                            i2 = this.space * 7;
                        }
                        i = 0;
                    }
                    rect.set(i, 0, i2, 0);
                }
            }
        }
    }
}
