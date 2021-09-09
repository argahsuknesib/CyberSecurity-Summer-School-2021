package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.chp;
import _m_j.chr;
import _m_j.civ;
import _m_j.clc;
import _m_j.cle;
import _m_j.clf;
import _m_j.gqg;
import _m_j.gwg;
import _m_j.hzf;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.BaseSelectActivity;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Adapter;
import com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerV2Activity;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayoutEx;
import com.xiaomi.smarthome.camera.view.widget.WeekView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmDayV2Activity extends BaseSelectActivity implements AlarmDayV2Adapter.ClickCallBack, WeekView.OnDayChangeListener {
    public HashMap<Integer, ArrayList<AlarmDayBeanV2>> cachMap = new HashMap<>();
    public AlarmDayV2Adapter mAdapter;
    public LinearLayout mCareNoEventOfDayLl;
    public RecyclerView mMediaListView;
    private XQProgressDialog mProgressDlg;
    private XQProgressDialog mPulingDlg;
    public RecyclerViewRefreshLayoutEx mRefreshLayout;
    private SimpleDateFormat mTimeFormater0 = new SimpleDateFormat("HH:mm");
    public WeekView mWeekView;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_alarm_day_v2);
        gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.title_bar_container));
        initView();
        loadData(true, true);
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        this.cachMap.clear();
        AlarmDayV2Adapter alarmDayV2Adapter = this.mAdapter;
        if (alarmDayV2Adapter != null) {
            alarmDayV2Adapter.destroyDisplayImageOptions();
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
        this.mRefreshLayout = (RecyclerViewRefreshLayoutEx) findViewById(R.id.recycle_refresh);
        this.mRefreshLayout.setLoadMore(false);
        this.mRefreshLayout.setRefreshing(false);
        this.mRefreshLayout.setMode(3);
        this.mRefreshLayout.setOnPullRefreshListener(new RecyclerViewRefreshLayout.OnPullRefreshListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Activity.AnonymousClass1 */

            public void onPullDistance(int i) {
            }

            public void onPullEnable(boolean z) {
            }

            public void onRefresh() {
                if (!AlarmDayV2Activity.this.isFinishing() && !AlarmDayV2Activity.this.mIsMultiSelectMode) {
                    AlarmDayV2Activity.this.loadData(true, false);
                }
            }
        });
        this.mRefreshLayout.setFooterRefreshView(LayoutInflater.from(this).inflate((int) R.layout.camera_list_load_more, (ViewGroup) null));
        this.mRefreshLayout.setOnPushLoadMoreListener(new RecyclerViewRefreshLayout.OnPushLoadMoreListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Activity.AnonymousClass2 */

            public void onPushDistance(int i) {
            }

            public void onPushEnable(boolean z) {
            }

            public void onLoadMore() {
                if (!AlarmDayV2Activity.this.isFinishing()) {
                    AlarmDayV2Activity.this.setMultiSelectMode(false);
                    AlarmDayV2Activity.this.loadMoreData(false);
                }
            }
        });
        this.mMediaListView.setLayoutManager(new GridLayoutManager(this, 3));
        this.mAdapter = new AlarmDayV2Adapter(this, this);
        this.mMediaListView.setAdapter(this.mAdapter);
        this.mMediaListView.addItemDecoration(new ItemDecoration());
        if (this.mCameraDevice.isReadOnlyShared()) {
            findViewById(R.id.layout_select_bottom).setVisibility(8);
            this.mAdapter.disableLongPress(true);
            this.mEditBtn.setVisibility(8);
        }
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
            if (this.mCameraDevice.isReadOnlyShared()) {
                gqg.O000000o((int) R.string.auth_fail_read_only);
            } else if (this.mCareNoEventOfDayLl.getVisibility() == 0) {
                gqg.O000000o((int) R.string.edit_no_data);
            } else {
                setMultiSelectMode(true);
            }
        } else if (id != R.id.ivSelectAll) {
        } else {
            if (this.mSelectAllShowed) {
                this.mSelectAllShowed = false;
                this.mSelectAllBtn.setImageResource(R.drawable.camera_edit_deselect_all_black);
                this.mAdapter.selectAll();
                refreshSelectTitle();
                return;
            }
            this.mSelectAllShowed = true;
            this.mSelectAllBtn.setImageResource(R.drawable.camera_edit_select_all_black);
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
            AnonymousClass3 r9 = new cle.O000000o<List<clc>>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Activity.AnonymousClass3 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj, Object obj2) {
                    onSuccess((List<clc>) ((List) obj), obj2);
                }

                public void onSuccess(List<clc> list, Object obj) {
                    if (!AlarmDayV2Activity.this.isFinishing()) {
                        AlarmDayV2Activity.this.dealAlarm(currentDay, list, false);
                        AlarmDayV2Activity.this.hideLoadDlg();
                        if (AlarmDayV2Activity.this.mRefreshLayout.isRefreshing()) {
                            AlarmDayV2Activity.this.mRefreshLayout.setRefreshing(false);
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmDayV2Activity.this.isFinishing()) {
                        civ.O000000o("AlarmDayV2Activity", "loadData errorCode:" + i + " errorMessage:" + str);
                        AlarmDayV2Activity.this.hideLoadDlg();
                        if (AlarmDayV2Activity.this.mRefreshLayout.isRefreshing()) {
                            AlarmDayV2Activity.this.mRefreshLayout.setRefreshing(false);
                        }
                        if (AlarmDayV2Activity.this.mAdapter == null || AlarmDayV2Activity.this.mAdapter.getData().size() <= 0) {
                            AlarmDayV2Activity.this.mMediaListView.setVisibility(8);
                        } else {
                            AlarmDayV2Activity.this.mMediaListView.setVisibility(0);
                        }
                        AlarmDayV2Activity.this.mCareNoEventOfDayLl.setVisibility(0);
                    }
                }
            };
            this.mCameraDevice.O0000o0o().O000000o(((long) this.mWeekView.getCurrentStartTime()) * 1000, ((long) this.mWeekView.getCurrentEndTime()) * 1000, r9);
            return;
        }
        this.mAdapter.setData(arrayList);
        this.mCareNoEventOfDayLl.setVisibility(8);
        this.mMediaListView.setVisibility(0);
    }

    public void loadMoreData(boolean z) {
        final int currentDay = this.mWeekView.getCurrentDay();
        if (z) {
            showLoadDlg();
        }
        List list = this.cachMap.get(Integer.valueOf(currentDay));
        this.mCameraDevice.O0000o0o().O000000o(((long) this.mWeekView.getCurrentStartTime()) * 1000, ((AlarmDayBeanV2) list.get(list.size() - 1)).item.O00000o0, new cle.O000000o<List<clc>>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Activity.AnonymousClass4 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj, Object obj2) {
                onSuccess((List<clc>) ((List) obj), obj2);
            }

            public void onSuccess(List<clc> list, Object obj) {
                if (!AlarmDayV2Activity.this.isFinishing()) {
                    AlarmDayV2Activity.this.hideLoadDlg();
                    AlarmDayV2Activity.this.mRefreshLayout.setLoadMore(false);
                    AlarmDayV2Activity.this.dealAlarm(currentDay, list, true);
                    if (AlarmDayV2Activity.this.mRefreshLayout.isRefreshing()) {
                        AlarmDayV2Activity.this.mRefreshLayout.setRefreshing(false);
                    }
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmDayV2Activity.this.isFinishing()) {
                    civ.O000000o("AlarmDayV2Activity", "loadMoreData errorCode:" + i + " errorMessage:" + str);
                    AlarmDayV2Activity.this.hideLoadDlg();
                    if (AlarmDayV2Activity.this.mRefreshLayout.isRefreshing()) {
                        AlarmDayV2Activity.this.mRefreshLayout.setRefreshing(false);
                    }
                    if (AlarmDayV2Activity.this.mAdapter == null || AlarmDayV2Activity.this.mAdapter.getData().size() <= 0) {
                        AlarmDayV2Activity.this.mMediaListView.setVisibility(8);
                    } else {
                        AlarmDayV2Activity.this.mMediaListView.setVisibility(0);
                    }
                    AlarmDayV2Activity.this.mCareNoEventOfDayLl.setVisibility(0);
                }
            }
        });
    }

    public void dealAlarm(int i, List<clc> list, boolean z) {
        Object obj;
        List<clc> list2 = list;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            Iterator it = this.cachMap.get(Integer.valueOf(this.mWeekView.getCurrentDay())).iterator();
            while (it.hasNext()) {
                AlarmDayBeanV2 alarmDayBeanV2 = (AlarmDayBeanV2) it.next();
                if (alarmDayBeanV2.item != null) {
                    arrayList2.add(alarmDayBeanV2.item);
                }
            }
            arrayList2.addAll(list2);
        } else {
            arrayList2.addAll(list2);
        }
        if (!arrayList2.isEmpty()) {
            Date date = new Date(((clc) arrayList2.get(0)).O00000o0);
            date.setMinutes(0);
            date.setSeconds(0);
            long time = date.getTime();
            String format = this.mTimeFormater0.format(date);
            date.setTime(date.getTime() + 3600000);
            String format2 = this.mTimeFormater0.format(date);
            Object obj2 = null;
            arrayList.add(new AlarmDayBeanV2(format + "-" + format2, null));
            long j = time + 3600000;
            long j2 = time;
            int i2 = 0;
            while (i2 < arrayList2.size()) {
                clc clc = (clc) arrayList2.get(i2);
                long j3 = clc.O00000o0;
                if (j3 < j2 || j3 >= j) {
                    while (true) {
                        if (j3 >= j2 && j3 <= j) {
                            break;
                        }
                        j2 -= 3600000;
                        j -= 3600000;
                        obj2 = obj2;
                    }
                    date.setTime(j2);
                    String format3 = this.mTimeFormater0.format(date);
                    date.setTime(j);
                    String format4 = this.mTimeFormater0.format(date);
                    obj = null;
                    arrayList.add(new AlarmDayBeanV2(format3 + "-" + format4, null));
                    arrayList.add(new AlarmDayBeanV2(this.mTimeFormater0.format(new Date(j3)), clc));
                } else {
                    arrayList.add(new AlarmDayBeanV2(this.mTimeFormater0.format(new Date(j3)), clc));
                    obj = obj2;
                }
                i2++;
                obj2 = obj;
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
        chr.O000000o(chr.O00O00o0);
        Object tag = view.getTag();
        if (tag != null) {
            clc clc = (clc) tag;
            Intent intent = new Intent();
            if (this.mCameraDevice.O0000oOO()) {
                intent.putExtra("alarmItem", clc.O000000o());
                intent.setClass(this, LocalAlarmPlayerForV3UpgradeActivity.class);
                startActivityForResult(intent, 1001);
            } else if (clc != null && !TextUtils.isEmpty(clc.O0000O0o)) {
                intent.putExtra("alarmItem", clc.O000000o());
                intent.setClass(this, LocalAlarmPlayerV2Activity.class);
                startActivityForResult(intent, 1001);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            loadData(true, true);
        }
    }

    public void onRecyclerLongClick(View view) {
        int childLayoutPosition;
        if (!this.mCameraDevice.isReadOnlyShared() && (childLayoutPosition = this.mMediaListView.getChildLayoutPosition(view)) >= 0 && childLayoutPosition < this.mAdapter.getItemCount()) {
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

    public void setMultiSelectMode(boolean z, boolean z2) {
        if (z) {
            this.mRefreshLayout.setMode(2);
        } else {
            this.mRefreshLayout.setMode(3);
        }
        super.setMultiSelectMode(z, z2);
    }

    private void deleteAlertDialog() {
        if (this.mAdapter.getSelectedCount() == 0) {
            gqg.O000000o((int) R.string.bottom_action_tip);
            return;
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O00000Oo(getString(R.string.delete_hint, new Object[]{Integer.valueOf(this.mAdapter.getSelectedCount())}));
        builder.O00000Oo((int) R.string.camera_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Activity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                AlarmDayV2Activity.this.setMultiSelectMode(false);
                dialogInterface.dismiss();
            }
        });
        builder.O000000o((int) R.string.camera_sure, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Activity.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                AlarmDayV2Activity.this.showDeleteDlg();
                ArrayList<clc> selectList = AlarmDayV2Activity.this.mAdapter.getSelectList();
                AlarmDayV2Activity.this.setMultiSelectMode(false);
                if (selectList != null && selectList.size() > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        Iterator<clc> it = selectList.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next().O0000O0o);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("fileIds", jSONArray);
                        jSONObject.put("fileIds", jSONObject2);
                        jSONObject.put("did", AlarmDayV2Activity.this.mCameraDevice.getDid());
                        jSONObject.put("model", AlarmDayV2Activity.this.mCameraDevice.getModel());
                        clf.O000000o().O0000Oo0(AlarmDayV2Activity.this.mCameraDevice.getModel(), jSONObject.toString(), new Callback<JSONObject>() {
                            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Activity.AnonymousClass6.AnonymousClass1 */

                            public void onSuccess(JSONObject jSONObject) {
                                if (!AlarmDayV2Activity.this.isFinishing()) {
                                    AlarmDayV2Activity.this.hideDeleteDlg();
                                    if (jSONObject == null) {
                                        gqg.O000000o((int) R.string.delete_failed);
                                    } else if (jSONObject.optInt("code") == 0) {
                                        List list = AlarmDayV2Activity.this.cachMap.get(Integer.valueOf(AlarmDayV2Activity.this.mWeekView.getCurrentDay()));
                                        if (list != null) {
                                            list.clear();
                                        }
                                        AlarmDayV2Activity.this.loadData(true, true);
                                        gqg.O000000o((int) R.string.delete_sucess);
                                    } else {
                                        gqg.O000000o((int) R.string.delete_failed);
                                    }
                                    AlarmDayV2Activity.this.setResult(-1);
                                }
                            }

                            public void onFailure(int i, String str) {
                                if (!AlarmDayV2Activity.this.isFinishing()) {
                                    AlarmDayV2Activity.this.hideDeleteDlg();
                                    gqg.O000000o((int) R.string.delete_failed);
                                }
                            }
                        });
                    } catch (JSONException unused) {
                    }
                }
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

    public void hideLoadDlg() {
        XQProgressDialog xQProgressDialog = this.mPulingDlg;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mPulingDlg.dismiss();
        }
    }

    public void showDeleteDlg() {
        if (this.mProgressDlg == null) {
            this.mProgressDlg = new XQProgressDialog(this);
            this.mProgressDlg.setCancelable(false);
            this.mProgressDlg.setMessage(getResources().getString(R.string.deleting));
        }
        this.mProgressDlg.show();
    }

    public void hideDeleteDlg() {
        XQProgressDialog xQProgressDialog = this.mProgressDlg;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mProgressDlg.dismiss();
        }
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
            if (childAdapterPosition >= 0 && childAdapterPosition < AlarmDayV2Activity.this.mAdapter.getItemCount()) {
                if (recyclerView.getAdapter().getItemViewType(childAdapterPosition) == 0) {
                    rect.set(0, 0, 0, 0);
                    return;
                }
                int dayIndex = AlarmDayV2Activity.this.mAdapter.getDayIndex(childAdapterPosition);
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

    public boolean isSelectedMaxium() {
        return getSelectCount() == 50;
    }
}
