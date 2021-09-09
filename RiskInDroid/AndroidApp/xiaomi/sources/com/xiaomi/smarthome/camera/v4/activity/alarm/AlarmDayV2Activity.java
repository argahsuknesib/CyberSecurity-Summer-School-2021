package com.xiaomi.smarthome.camera.v4.activity.alarm;

import _m_j.chp;
import _m_j.chr;
import _m_j.clb;
import _m_j.cld;
import _m_j.clf;
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
import com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerV2Activity;
import com.xiaomi.smarthome.camera.v4.activity.BaseSelectActivity;
import com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayAdapterV2;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout;
import com.xiaomi.smarthome.camera.view.widget.WeekView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmDayV2Activity extends BaseSelectActivity implements AlarmDayAdapterV2.ClickCallBack, WeekView.OnDayChangeListener {
    private HashMap<Integer, ArrayList<AlarmDayBean>> cachMap = new HashMap<>();
    public boolean isDeleted = false;
    public AlarmDayAdapterV2 mAdapter;
    public LinearLayout mCareNoEventOfDayLl;
    public RecyclerView mMediaListView;
    public XQProgressDialog mProgressDlg;
    public XQProgressDialog mPulingDlg;
    public RecyclerViewRefreshLayout mRefreshLayout;
    private SimpleDateFormat mTimeFormater0 = new SimpleDateFormat("HH:mm");
    public WeekView mWeekView;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_alarm_day);
        gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.title_bar_container));
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
        AlarmDayAdapterV2 alarmDayAdapterV2 = this.mAdapter;
        if (alarmDayAdapterV2 != null) {
            alarmDayAdapterV2.destroyDisplayImageOptions();
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
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass1 */

            public void onPullDistance(int i) {
            }

            public void onPullEnable(boolean z) {
            }

            public void onRefresh() {
                if (!AlarmDayV2Activity.this.isFinishing()) {
                    AlarmDayV2Activity.this.loadData(true, false);
                }
            }
        });
        this.mMediaListView.setLayoutManager(new GridLayoutManager(this, 3));
        this.mAdapter = new AlarmDayAdapterV2(this, this);
        this.mMediaListView.setAdapter(this.mAdapter);
        this.mMediaListView.addItemDecoration(new ItemDecoration());
        if (this.mEditBtn != null && this.mCameraDevice.isReadOnlyShared()) {
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
            if (DeviceConstant.isNewChuangmi(this.mCameraDevice.getModel())) {
                new Thread(new Runnable((long) this.mWeekView.getCurrentEndTime(), (long) this.mWeekView.getCurrentStartTime(), new Callback<List<clb>>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass2 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<clb>) ((List) obj));
                    }

                    public void onSuccess(final List<clb> list) {
                        AlarmDayV2Activity.this.mHandler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass2.AnonymousClass1 */

                            public void run() {
                                if (!AlarmDayV2Activity.this.isFinishing()) {
                                    AlarmDayV2Activity.this.dealAlarm(currentDay, list, ((long) AlarmDayV2Activity.this.mWeekView.getCurrentStartTime()) * 1000, 1000 * ((long) AlarmDayV2Activity.this.mWeekView.getCurrentEndTime()));
                                    if (AlarmDayV2Activity.this.mPulingDlg != null && AlarmDayV2Activity.this.mPulingDlg.isShowing()) {
                                        AlarmDayV2Activity.this.mPulingDlg.dismiss();
                                    }
                                    if (AlarmDayV2Activity.this.mRefreshLayout.isRefreshing()) {
                                        AlarmDayV2Activity.this.mRefreshLayout.setRefreshing(false);
                                    }
                                    AlarmDayV2Activity.this.refreshSelectTitle();
                                }
                            }
                        });
                    }

                    public void onFailure(int i, String str) {
                        AlarmDayV2Activity.this.mHandler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass2.AnonymousClass2 */

                            public void run() {
                                if (!AlarmDayV2Activity.this.isFinishing()) {
                                    if (AlarmDayV2Activity.this.mPulingDlg != null) {
                                        AlarmDayV2Activity.this.mPulingDlg.dismiss();
                                    }
                                    if (AlarmDayV2Activity.this.mRefreshLayout.isRefreshing()) {
                                        AlarmDayV2Activity.this.mRefreshLayout.setRefreshing(false);
                                    }
                                    AlarmDayV2Activity.this.mMediaListView.setVisibility(8);
                                    AlarmDayV2Activity.this.mCareNoEventOfDayLl.setVisibility(0);
                                    AlarmDayV2Activity.this.refreshSelectTitle();
                                }
                            }
                        });
                    }
                }) {
                    /* class _m_j.cld.AnonymousClass13 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ long f13998O000000o;
                    final /* synthetic */ long O00000Oo;
                    final /* synthetic */ Callback O00000o0;

                    {
                        this.f13998O000000o = r2;
                        this.O00000Oo = r4;
                        this.O00000o0 = r6;
                    }

                    public final void run() {
                        int i = 1;
                        long j = this.f13998O000000o;
                        long[] jArr = {j};
                        jArr[0] = j;
                        int[] iArr = {0};
                        ArrayList arrayList = new ArrayList();
                        while (true) {
                            CountDownLatch countDownLatch = new CountDownLatch(i);
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("did", cld.this.O0000O0o.getDid());
                                jSONObject.put("model", cld.this.O0000O0o.getModel());
                                jSONObject.put("region", Locale.getDefault().getCountry());
                                jSONObject.put("language", Locale.getDefault().getLanguage());
                                jSONObject.put("beginTime", this.O00000Oo * 1000);
                                jSONObject.put("endTime", jArr[0] * 1000);
                                jSONObject.put("limit", 20);
                                PrintStream printStream = System.out;
                                printStream.println("mytest:getAlarmPlaylistLimitV2:" + (this.O00000Oo * 1000) + " " + (jArr[0] * 1000));
                                clf O000000o2 = clf.O000000o();
                                String model = cld.this.O0000O0o.getModel();
                                final long[] jArr2 = jArr;
                                final int[] iArr2 = iArr;
                                AnonymousClass1 r8 = r1;
                                final ArrayList arrayList2 = arrayList;
                                String jSONObject2 = jSONObject.toString();
                                final CountDownLatch countDownLatch2 = countDownLatch;
                                AnonymousClass1 r1 = new Callback<JSONObject>() {
                                    /* class _m_j.cld.AnonymousClass13.AnonymousClass1 */

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject == null || jSONObject.optInt("code") != 0 || jSONObject.optJSONObject("data") == null) {
                                            iArr2[0] = 0;
                                        } else {
                                            JSONArray optJSONArray = jSONObject.optJSONObject("data").optJSONArray("thirdPartPlayUnits");
                                            PrintStream printStream = System.out;
                                            printStream.println("mytest:getAlarmPlaylistLimitV2:" + optJSONArray.length());
                                            ArrayList arrayList = new ArrayList();
                                            for (int i = 0; i < optJSONArray.length(); i++) {
                                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                                if (optJSONObject != null) {
                                                    clb clb = new clb();
                                                    clb.O0000o0 = optJSONObject.optLong("duration");
                                                    clb.O0000o0O = optJSONObject.optLong("expireTime");
                                                    clb.O0000o0o = optJSONObject.optLong("createTime");
                                                    clb.O0000oO0 = optJSONObject.optString("imgStoreId");
                                                    clb.O0000oOO = optJSONObject.optString("fileId");
                                                    clb.O0000oo0 = optJSONObject.optString("desc");
                                                    clb.O0000oo = optJSONObject.optString("tags");
                                                    clb.O0000o = optJSONObject.optInt("offset");
                                                    clb.O0000oOo = optJSONObject.optString("videoStoreId");
                                                    clb.O0000oO = XmPluginHostApi.instance().getCloudImageUrl(cld.this.O0000O0o.getDid(), clb.O0000oOO, clb.O0000oO0);
                                                    clb.O0000Ooo = true;
                                                    clb.O0000o00 = true;
                                                    clb.O00000Oo = clb.O0000o0o;
                                                    arrayList.add(clb);
                                                }
                                            }
                                            if (arrayList.size() == 20) {
                                                jArr2[0] = (((clb) arrayList.get(arrayList.size() - 1)).O00000Oo / 1000) - 1;
                                                iArr2[0] = 20;
                                            } else {
                                                iArr2[0] = arrayList.size();
                                            }
                                            arrayList2.addAll(arrayList);
                                        }
                                        countDownLatch2.countDown();
                                    }

                                    public final void onFailure(int i, String str) {
                                        iArr2[0] = -1;
                                        countDownLatch2.countDown();
                                    }
                                };
                                O000000o2.O0000OOo(model, jSONObject2, r8);
                            } catch (JSONException unused) {
                                iArr[0] = -1;
                                countDownLatch.countDown();
                            }
                            try {
                                countDownLatch.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (iArr[0] != 20) {
                                break;
                            }
                            i = 1;
                        }
                        if (this.O00000o0 == null) {
                            return;
                        }
                        if (iArr[0] != -1 || !arrayList.isEmpty()) {
                            this.O00000o0.onSuccess(arrayList);
                        } else {
                            this.O00000o0.onFailure(-1, "");
                        }
                    }
                }).start();
                return;
            }
            cld O0000o0O = this.mCameraDevice.O0000o0O();
            long currentStartTime = (long) this.mWeekView.getCurrentStartTime();
            long currentEndTime = (long) this.mWeekView.getCurrentEndTime();
            AnonymousClass3 r12 = new Callback<List<clb>>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass3 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<clb>) ((List) obj));
                }

                public void onSuccess(final List<clb> list) {
                    AlarmDayV2Activity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass3.AnonymousClass1 */

                        public void run() {
                            if (!AlarmDayV2Activity.this.isFinishing()) {
                                AlarmDayV2Activity.this.dealAlarm(currentDay, list, ((long) AlarmDayV2Activity.this.mWeekView.getCurrentStartTime()) * 1000, 1000 * ((long) AlarmDayV2Activity.this.mWeekView.getCurrentEndTime()));
                                if (AlarmDayV2Activity.this.mPulingDlg != null && AlarmDayV2Activity.this.mPulingDlg.isShowing()) {
                                    AlarmDayV2Activity.this.mPulingDlg.dismiss();
                                }
                                if (AlarmDayV2Activity.this.mRefreshLayout.isRefreshing()) {
                                    AlarmDayV2Activity.this.mRefreshLayout.setRefreshing(false);
                                }
                                AlarmDayV2Activity.this.refreshSelectTitle();
                            }
                        }
                    });
                }

                public void onFailure(int i, String str) {
                    AlarmDayV2Activity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass3.AnonymousClass2 */

                        public void run() {
                            if (!AlarmDayV2Activity.this.isFinishing()) {
                                if (AlarmDayV2Activity.this.mPulingDlg != null) {
                                    AlarmDayV2Activity.this.mPulingDlg.dismiss();
                                }
                                if (AlarmDayV2Activity.this.mRefreshLayout.isRefreshing()) {
                                    AlarmDayV2Activity.this.mRefreshLayout.setRefreshing(false);
                                }
                                AlarmDayV2Activity.this.mMediaListView.setVisibility(8);
                                AlarmDayV2Activity.this.mCareNoEventOfDayLl.setVisibility(0);
                                AlarmDayV2Activity.this.refreshSelectTitle();
                            }
                        }
                    });
                }
            };
            if (O0000o0O.O0000Oo0 / 1000 > currentEndTime) {
                O0000o0O.O000000o(currentStartTime, currentEndTime, r12);
            } else if (O0000o0O.O0000Oo0 / 1000 < currentStartTime) {
                new Thread(new Runnable(currentEndTime, currentStartTime, r12) {
                    /* class _m_j.cld.AnonymousClass11 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ long f13992O000000o;
                    final /* synthetic */ long O00000Oo;
                    final /* synthetic */ Callback O00000o0;

                    {
                        this.f13992O000000o = r2;
                        this.O00000Oo = r4;
                        this.O00000o0 = r6;
                    }

                    public final void run() {
                        int i = 1;
                        long j = this.f13992O000000o;
                        long[] jArr = {j};
                        jArr[0] = j;
                        int[] iArr = {0};
                        ArrayList arrayList = new ArrayList();
                        while (true) {
                            CountDownLatch countDownLatch = new CountDownLatch(i);
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("did", cld.this.O0000O0o.getDid());
                                jSONObject.put("region", Locale.getDefault().getCountry());
                                jSONObject.put("language", Locale.getDefault().getLanguage());
                                jSONObject.put("beginTime", this.O00000Oo * 1000);
                                jSONObject.put("endTime", jArr[0] * 1000);
                                jSONObject.put("limit", 20);
                                PrintStream printStream = System.out;
                                printStream.println("mytest:getAlarmPlaylistLimit:" + (this.O00000Oo * 1000) + " " + (jArr[0] * 1000));
                                clf O000000o2 = clf.O000000o();
                                String model = cld.this.O0000O0o.getModel();
                                final long[] jArr2 = jArr;
                                final int[] iArr2 = iArr;
                                AnonymousClass1 r8 = r1;
                                final ArrayList arrayList2 = arrayList;
                                String jSONObject2 = jSONObject.toString();
                                final CountDownLatch countDownLatch2 = countDownLatch;
                                AnonymousClass1 r1 = new Callback<JSONObject>() {
                                    /* class _m_j.cld.AnonymousClass11.AnonymousClass1 */

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject == null || jSONObject.optInt("code") != 0 || jSONObject.optJSONObject("data") == null) {
                                            iArr2[0] = 0;
                                        } else {
                                            JSONArray optJSONArray = jSONObject.optJSONObject("data").optJSONArray("playUnits");
                                            PrintStream printStream = System.out;
                                            printStream.println("mytest:getAlarmPlaylistLimit:" + optJSONArray.length());
                                            ArrayList arrayList = new ArrayList();
                                            for (int i = 0; i < optJSONArray.length(); i++) {
                                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                                if (optJSONObject != null) {
                                                    clb clb = new clb();
                                                    clb.O0000o0 = optJSONObject.optLong("duration");
                                                    clb.O0000o0O = optJSONObject.optLong("expireTime");
                                                    clb.O0000o0o = optJSONObject.optLong("createTime");
                                                    clb.O0000oO0 = optJSONObject.optString("imgStoreId");
                                                    clb.O0000oOO = optJSONObject.optString("fileId");
                                                    clb.O0000oo0 = optJSONObject.optString("desc");
                                                    clb.O0000oo = optJSONObject.optString("tags");
                                                    clb.O0000o = optJSONObject.optInt("offset");
                                                    clb.O0000oOo = optJSONObject.optString("videoStoreId");
                                                    clb.O0000oO = XmPluginHostApi.instance().getCloudImageUrl(cld.this.O0000O0o.getDid(), clb.O0000oOO, clb.O0000oO0);
                                                    clb.O0000Ooo = true;
                                                    clb.O00000Oo = clb.O0000o0o;
                                                    arrayList.add(clb);
                                                }
                                            }
                                            if (arrayList.size() == 20) {
                                                jArr2[0] = (((clb) arrayList.get(arrayList.size() - 1)).O00000Oo / 1000) - 1;
                                                iArr2[0] = 20;
                                            } else {
                                                iArr2[0] = arrayList.size();
                                            }
                                            arrayList2.addAll(arrayList);
                                        }
                                        countDownLatch2.countDown();
                                    }

                                    public final void onFailure(int i, String str) {
                                        iArr2[0] = -1;
                                        countDownLatch2.countDown();
                                    }
                                };
                                O000000o2.O0000O0o(model, jSONObject2, r8);
                            } catch (JSONException unused) {
                                iArr[0] = -1;
                                countDownLatch.countDown();
                            }
                            try {
                                countDownLatch.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (iArr[0] != 20) {
                                break;
                            }
                            i = 1;
                        }
                        if (this.O00000o0 == null) {
                            return;
                        }
                        if (iArr[0] != -1 || !arrayList.isEmpty()) {
                            this.O00000o0.onSuccess(arrayList);
                        } else {
                            this.O00000o0.onFailure(-1, "");
                        }
                    }
                }).start();
            } else {
                new Thread(new Runnable(currentEndTime, currentStartTime, r12) {
                    /* class _m_j.cld.AnonymousClass12 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ long f13994O000000o;
                    final /* synthetic */ long O00000Oo;
                    final /* synthetic */ Callback O00000o0;

                    {
                        this.f13994O000000o = r2;
                        this.O00000Oo = r4;
                        this.O00000o0 = r6;
                    }

                    public final void run() {
                        int i = 1;
                        long j = this.f13994O000000o;
                        long[] jArr = {j};
                        jArr[0] = j;
                        int[] iArr = {0};
                        final ArrayList arrayList = new ArrayList();
                        while (true) {
                            CountDownLatch countDownLatch = new CountDownLatch(i);
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("did", cld.this.O0000O0o.getDid());
                                jSONObject.put("region", Locale.getDefault().getCountry());
                                jSONObject.put("language", Locale.getDefault().getLanguage());
                                jSONObject.put("beginTime", cld.this.O0000Oo0);
                                jSONObject.put("endTime", jArr[0] * 1000);
                                jSONObject.put("limit", 20);
                                PrintStream printStream = System.out;
                                printStream.println("mytest:getAlarmPlaylistLimit:" + (this.O00000Oo * 1000) + " " + (jArr[0] * 1000));
                                clf O000000o2 = clf.O000000o();
                                String model = cld.this.O0000O0o.getModel();
                                final long[] jArr2 = jArr;
                                final int[] iArr2 = iArr;
                                AnonymousClass1 r8 = r1;
                                final ArrayList arrayList2 = arrayList;
                                String jSONObject2 = jSONObject.toString();
                                final CountDownLatch countDownLatch2 = countDownLatch;
                                AnonymousClass1 r1 = new Callback<JSONObject>() {
                                    /* class _m_j.cld.AnonymousClass12.AnonymousClass1 */

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject == null || jSONObject.optInt("code") != 0 || jSONObject.optJSONObject("data") == null) {
                                            iArr2[0] = 0;
                                        } else {
                                            JSONArray optJSONArray = jSONObject.optJSONObject("data").optJSONArray("playUnits");
                                            PrintStream printStream = System.out;
                                            printStream.println("mytest:getAlarmPlaylistLimit:" + optJSONArray.length());
                                            ArrayList arrayList = new ArrayList();
                                            for (int i = 0; i < optJSONArray.length(); i++) {
                                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                                if (optJSONObject != null) {
                                                    clb clb = new clb();
                                                    clb.O0000o0 = optJSONObject.optLong("duration");
                                                    clb.O0000o0O = optJSONObject.optLong("expireTime");
                                                    clb.O0000o0o = optJSONObject.optLong("createTime");
                                                    clb.O0000oO0 = optJSONObject.optString("imgStoreId");
                                                    clb.O0000oOO = optJSONObject.optString("fileId");
                                                    clb.O0000oo0 = optJSONObject.optString("desc");
                                                    clb.O0000oo = optJSONObject.optString("tags");
                                                    clb.O0000o = optJSONObject.optInt("offset");
                                                    clb.O0000oOo = optJSONObject.optString("videoStoreId");
                                                    clb.O0000oO = XmPluginHostApi.instance().getCloudImageUrl(cld.this.O0000O0o.getDid(), clb.O0000oOO, clb.O0000oO0);
                                                    clb.O0000Ooo = true;
                                                    clb.O00000Oo = clb.O0000o0o;
                                                    arrayList.add(clb);
                                                }
                                            }
                                            if (arrayList.size() == 20) {
                                                jArr2[0] = (((clb) arrayList.get(arrayList.size() - 1)).O00000Oo / 1000) - 1;
                                                iArr2[0] = 20;
                                            } else {
                                                iArr2[0] = arrayList.size();
                                            }
                                            arrayList2.addAll(arrayList);
                                        }
                                        countDownLatch2.countDown();
                                    }

                                    public final void onFailure(int i, String str) {
                                        iArr2[0] = -1;
                                        countDownLatch2.countDown();
                                    }
                                };
                                O000000o2.O0000O0o(model, jSONObject2, r8);
                            } catch (JSONException unused) {
                                iArr[0] = -1;
                                countDownLatch.countDown();
                            }
                            try {
                                countDownLatch.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (iArr[0] != 20) {
                                new Thread(new Runnable() {
                                    /* class _m_j.cld.AnonymousClass12.AnonymousClass2 */

                                    public final void run() {
                                        final long[] jArr = {AnonymousClass12.this.f13994O000000o};
                                        jArr[0] = cld.this.O0000Oo0;
                                        final int[] iArr = {0};
                                        do {
                                            final CountDownLatch countDownLatch = new CountDownLatch(1);
                                            cld.this.O000000o(AnonymousClass12.this.O00000Oo, jArr[0], 50, new Callback<JSONArray>() {
                                                /* class _m_j.cld.AnonymousClass12.AnonymousClass2.AnonymousClass1 */

                                                public final /* synthetic */ void onSuccess(Object obj) {
                                                    JSONArray jSONArray = (JSONArray) obj;
                                                    ArrayList arrayList = new ArrayList();
                                                    if (jSONArray == null || jSONArray.length() <= 0) {
                                                        iArr[0] = 0;
                                                    } else {
                                                        for (int i = 0; i < jSONArray.length(); i++) {
                                                            arrayList.add(clb.O000000o(jSONArray.optJSONObject(i)));
                                                        }
                                                        if (jSONArray.length() == 50) {
                                                            jArr[0] = (((clb) arrayList.get(arrayList.size() - 1)).O00000Oo / 1000) - 1;
                                                            iArr[0] = 50;
                                                        } else {
                                                            iArr[0] = jSONArray.length();
                                                        }
                                                        arrayList.addAll(arrayList);
                                                    }
                                                    countDownLatch.countDown();
                                                }

                                                public final void onFailure(int i, String str) {
                                                    iArr[0] = -1;
                                                    countDownLatch.countDown();
                                                }
                                            });
                                            try {
                                                countDownLatch.await();
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        } while (iArr[0] == 50);
                                        if (AnonymousClass12.this.O00000o0 == null) {
                                            return;
                                        }
                                        if (arrayList.isEmpty()) {
                                            AnonymousClass12.this.O00000o0.onFailure(-1, "");
                                        } else {
                                            AnonymousClass12.this.O00000o0.onSuccess(arrayList);
                                        }
                                    }
                                }).start();
                                return;
                            }
                            i = 1;
                        }
                    }
                }).start();
            }
        } else {
            this.mAdapter.setData(arrayList);
            this.mCareNoEventOfDayLl.setVisibility(8);
            this.mMediaListView.setVisibility(0);
        }
    }

    public void dealAlarm(int i, List<clb> list, long j, long j2) {
        List<clb> list2 = list;
        ArrayList arrayList = new ArrayList();
        Collections.sort(list2, new Comparator<clb>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass4 */

            public int compare(clb clb, clb clb2) {
                return clb.O00000Oo > clb2.O00000Oo ? -1 : 1;
            }
        });
        Iterator<clb> it = list.iterator();
        while (it.hasNext()) {
            clb next = it.next();
            if (next.O00000Oo < j || next.O00000Oo > j2) {
                it.remove();
            }
        }
        if (!list.isEmpty()) {
            clb clb = list2.get(0);
            Date date = new Date(clb.O00000Oo);
            date.setHours(0);
            date.setMinutes(0);
            date.setSeconds(0);
            Date date2 = new Date(clb.O00000Oo);
            date2.setMinutes(0);
            date2.setSeconds(0);
            long time = date2.getTime();
            String format = this.mTimeFormater0.format(date2);
            date2.setTime(date2.getTime() + 3600000);
            String format2 = this.mTimeFormater0.format(date2);
            arrayList.add(new AlarmDayBean(format + "-" + format2, null));
            long j3 = time + 3600000;
            long j4 = time;
            int i2 = 0;
            while (i2 < list.size()) {
                clb clb2 = list2.get(i2);
                long j5 = clb2.O00000Oo;
                if (j4 > 0 && j3 > 0 && j5 > 0) {
                    if (j5 < j4 || j5 >= j3) {
                        while (true) {
                            if ((j5 < j4 || j5 > j3) && j4 > date.getTime()) {
                                j4 -= 3600000;
                                j3 -= 3600000;
                            }
                        }
                        date2.setTime(j4);
                        String format3 = this.mTimeFormater0.format(date2);
                        date2.setTime(j3);
                        String format4 = this.mTimeFormater0.format(date2);
                        arrayList.add(new AlarmDayBean(format3 + "-" + format4, null));
                        arrayList.add(new AlarmDayBean(this.mTimeFormater0.format(new Date(j5)), clb2));
                    } else {
                        arrayList.add(new AlarmDayBean(this.mTimeFormater0.format(new Date(j5)), clb2));
                    }
                }
                i2++;
                list2 = list;
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
            clb clb = (clb) tag;
            Intent intent = new Intent();
            if (clb.O0000o00) {
                intent.putExtra("alarmItem", clb.O00000Oo());
                intent.setClass(this, LocalAlarmPlayerForV3UpgradeActivity.class);
                startActivityForResult(intent, 1001);
            } else if (clb.O0000Ooo) {
                intent.putExtra("time", clb.O00000Oo / 1000);
                intent.putExtra("alarmItem", clb.O00000Oo());
                intent.setClass(this, LocalAlarmPlayerV2Activity.class);
                startActivityForResult(intent, 1001);
            } else {
                intent.putExtra("time", clb.O00000Oo / 1000);
                intent.setClass(this, LocalAlarmPlayerActivity.class);
                startActivityForResult(intent, 1001);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            loadData(true, false);
            this.isDeleted = true;
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

    private void deleteAlertDialog() {
        if (this.mAdapter.getSelectedCount() == 0) {
            izb.O000000o(this, (int) R.string.bottom_action_tip, 0).show();
            return;
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O00000Oo(getString(R.string.delete_hint, new Object[]{Integer.valueOf(this.mAdapter.getSelectedCount())}));
        builder.O00000Oo((int) R.string.camera_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                AlarmDayV2Activity.this.setMultiSelectMode(false);
                dialogInterface.dismiss();
            }
        });
        builder.O000000o((int) R.string.camera_sure, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                AlarmDayV2Activity.this.showProgressDlg();
                final ArrayList<clb> selectList = AlarmDayV2Activity.this.mAdapter.getSelectList();
                ArrayList<clb> selectList2 = AlarmDayV2Activity.this.mAdapter.getSelectList();
                AlarmDayV2Activity.this.setMultiSelectMode(false);
                if (selectList != null && selectList.size() > 0) {
                    Iterator<clb> it = selectList.iterator();
                    while (it.hasNext()) {
                        if (it.next().O0000Ooo) {
                            it.remove();
                        }
                    }
                }
                if (selectList2 != null && selectList2.size() > 0) {
                    Iterator<clb> it2 = selectList2.iterator();
                    while (it2.hasNext()) {
                        if (!it2.next().O0000Ooo) {
                            it2.remove();
                        }
                    }
                }
                if (selectList2 != null && selectList2.size() > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("region", Locale.getDefault().getCountry());
                        JSONArray jSONArray = new JSONArray();
                        Iterator<clb> it3 = selectList2.iterator();
                        while (it3.hasNext()) {
                            jSONArray.put(it3.next().O0000oOO);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("fileIds", jSONArray);
                        jSONObject.put("fileIds", jSONObject2);
                        jSONObject.put("did", AlarmDayV2Activity.this.mCameraDevice.getDid());
                        jSONObject.put("model", AlarmDayV2Activity.this.mCameraDevice.getModel());
                        clf.O000000o().O0000Oo0(AlarmDayV2Activity.this.mCameraDevice.getModel(), jSONObject.toString(), new Callback<JSONObject>() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass6.AnonymousClass1 */

                            public void onSuccess(JSONObject jSONObject) {
                                if (!AlarmDayV2Activity.this.isFinishing()) {
                                    ArrayList arrayList = selectList;
                                    if (arrayList == null || arrayList.size() <= 0) {
                                        if (AlarmDayV2Activity.this.mProgressDlg != null && AlarmDayV2Activity.this.mProgressDlg.isShowing()) {
                                            AlarmDayV2Activity.this.mProgressDlg.dismiss();
                                        }
                                        izb.O000000o(AlarmDayV2Activity.this, (int) R.string.delete_sucess, 0).show();
                                        AlarmDayV2Activity.this.loadData(true, false);
                                        AlarmDayV2Activity.this.isDeleted = true;
                                        return;
                                    }
                                    AlarmDayV2Activity.this.mCameraDevice.O0000o0O().O000000o(selectList, new Callback<Void>() {
                                        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                        public void onSuccess(Void voidR) {
                                            if (!AlarmDayV2Activity.this.isFinishing()) {
                                                AlarmDayV2Activity.this.runOnUiThread(new Runnable() {
                                                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass6.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                    public void run() {
                                                        if (AlarmDayV2Activity.this.mProgressDlg != null && AlarmDayV2Activity.this.mProgressDlg.isShowing()) {
                                                            AlarmDayV2Activity.this.mProgressDlg.dismiss();
                                                        }
                                                        izb.O000000o(AlarmDayV2Activity.this, (int) R.string.delete_sucess, 0).show();
                                                        AlarmDayV2Activity.this.loadData(true, true);
                                                        AlarmDayV2Activity.this.isDeleted = true;
                                                    }
                                                });
                                            }
                                        }

                                        public void onFailure(int i, String str) {
                                            if (!AlarmDayV2Activity.this.isFinishing()) {
                                                AlarmDayV2Activity.this.runOnUiThread(new Runnable() {
                                                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass6.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                                    public void run() {
                                                        if (AlarmDayV2Activity.this.mProgressDlg != null && AlarmDayV2Activity.this.mProgressDlg.isShowing()) {
                                                            AlarmDayV2Activity.this.mProgressDlg.dismiss();
                                                        }
                                                        izb.O000000o(AlarmDayV2Activity.this, (int) R.string.delete_failed, 0).show();
                                                    }
                                                });
                                            }
                                        }
                                    });
                                }
                            }

                            public void onFailure(int i, String str) {
                                if (!AlarmDayV2Activity.this.isFinishing()) {
                                    if (AlarmDayV2Activity.this.mProgressDlg != null && AlarmDayV2Activity.this.mProgressDlg.isShowing()) {
                                        AlarmDayV2Activity.this.mProgressDlg.dismiss();
                                    }
                                    izb.O000000o(AlarmDayV2Activity.this, (int) R.string.delete_failed, 0).show();
                                }
                            }
                        });
                    } catch (JSONException unused) {
                    }
                } else if (selectList != null && selectList.size() > 0) {
                    AlarmDayV2Activity.this.mCameraDevice.O0000o0O().O000000o(selectList, new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass6.AnonymousClass2 */

                        public void onSuccess(Void voidR) {
                            if (!AlarmDayV2Activity.this.isFinishing()) {
                                AlarmDayV2Activity.this.runOnUiThread(new Runnable() {
                                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass6.AnonymousClass2.AnonymousClass1 */

                                    public void run() {
                                        if (AlarmDayV2Activity.this.mProgressDlg != null && AlarmDayV2Activity.this.mProgressDlg.isShowing()) {
                                            AlarmDayV2Activity.this.mProgressDlg.dismiss();
                                        }
                                        izb.O000000o(AlarmDayV2Activity.this, (int) R.string.delete_sucess, 0).show();
                                        AlarmDayV2Activity.this.loadData(true, false);
                                        AlarmDayV2Activity.this.isDeleted = true;
                                    }
                                });
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!AlarmDayV2Activity.this.isFinishing()) {
                                AlarmDayV2Activity.this.runOnUiThread(new Runnable() {
                                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity.AnonymousClass6.AnonymousClass2.AnonymousClass2 */

                                    public void run() {
                                        if (AlarmDayV2Activity.this.mProgressDlg != null && AlarmDayV2Activity.this.mProgressDlg.isShowing()) {
                                            AlarmDayV2Activity.this.mProgressDlg.dismiss();
                                        }
                                        izb.O000000o(AlarmDayV2Activity.this, (int) R.string.delete_failed, 0).show();
                                    }
                                });
                            }
                        }
                    });
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
            return;
        }
        if (this.isDeleted) {
            setResult(-1);
        }
        super.onBackPressed();
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
}
