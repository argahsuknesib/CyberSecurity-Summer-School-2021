package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.chr;
import _m_j.fno;
import _m_j.ftn;
import _m_j.gkv;
import _m_j.goq;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwc;
import _m_j.hxi;
import _m_j.hzf;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDateListViewAdapter;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.adapter.PlayListAdapter;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoChildListData;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDate;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoUserStatus;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.DailyList;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.StatsRecord2;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.views.RecyclerViewRefreshLayout;
import com.xiaomi.smarthome.miio.camera.cloudstorage.views.RecyclerViewRefreshLayoutEx;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudVideoListActivity extends CloudVideoBaseActivity implements View.OnClickListener {
    private final int ON_VIDEO_DELETED = 1001;
    private long createTime = 0;
    private String currentDateString = null;
    public long currentDateTS = 0;
    private CloudVideoDateListView cvdlvDays;
    public CloudVideoListView cvlvVideos;
    public CloudVideoDateListViewAdapter dateListViewAdapter;
    public int datesUpdateVar = 0;
    public String did = null;
    private boolean isFromRn;
    private boolean isReadyOnly;
    public boolean isShared;
    private ImageView ivCrown;
    private ImageView ivHeaderLeftBack;
    private ImageView ivHeaderRightEdit;
    private ImageView ivHeaderRightSetting;
    private ImageView ivLoading;
    private LinearLayout llBottomCtrl;
    private boolean mIsHsPanoramaVideo;
    public volatile boolean mMaxSelecting = false;
    private String model = null;
    private String[] monthArray;
    public PlayListAdapter playListAdapter;
    private RelativeLayout rlCloudVideo;
    private RelativeLayout rlTitleBar;
    public RecyclerViewRefreshLayoutEx rvrlVideoList;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String title = null;
    public TextView tvBlankHint;
    public TextView tvCapacity;
    private TextView tvDelete;
    private TextView tvDownload;
    public TextView tvDownloadHint;
    public TextView tvInterval;
    private TextView tvManage;
    public TextView tvOrderName;
    private TextView tvTitleBarTitle;
    public TextView tvValidity;

    static /* synthetic */ void lambda$downloadHint$12(DialogInterface dialogInterface) {
    }

    static /* synthetic */ void lambda$downloadHint$13(DialogInterface dialogInterface, int i) {
    }

    public void onCreate(Bundle bundle) {
        Device O000000o2;
        super.onCreate(bundle);
        chr.O000000o(chr.O00O0O0o);
        setContentView((int) R.layout.cs_activity_video_list);
        this.did = getIntent().getStringExtra("did");
        this.title = getIntent().getStringExtra("title");
        this.mIsHsPanoramaVideo = getIntent().getBooleanExtra("is_hs_panorama_video", false);
        this.isFromRn = getIntent().getBooleanExtra("isFromRn", false);
        if (TextUtils.isEmpty(this.did)) {
            finish();
        }
        if (!TextUtils.isEmpty(this.did) && (O000000o2 = fno.O000000o().O000000o(this.did)) != null) {
            this.model = O000000o2.model;
            this.isReadyOnly = O000000o2.isSharedReadOnly();
            this.isShared = O000000o2.isShared();
        }
        this.monthArray = gkv.f17949O000000o.getResources().getStringArray(R.array.cs_month_array);
        initViews();
        hxi.O00000oO.f958O000000o.O000000o("pintro_storage_popup", new Object[0]);
        this.createTime = System.currentTimeMillis();
        if (this.isFromRn) {
            chr.O000000o(this.did, XmPluginHostApi.instance().getDeviceByDid(this.did).model);
        }
    }

    public void onResume() {
        super.onResume();
        getStatus();
        getCapacity();
    }

    public void onPause() {
        super.onPause();
        exitEditMode();
        this.tvDownloadHint.setVisibility(8);
    }

    private void initViews() {
        this.rlTitleBar = (RelativeLayout) findViewById(R.id.rlTitleBar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.rlTitleBar.getLayoutParams());
        layoutParams.setMargins(0, hzf.O000000o(CommonApplication.getAppContext()), 0, 0);
        this.rlTitleBar.setLayoutParams(layoutParams);
        this.rlTitleBar.bringToFront();
        this.tvTitleBarTitle = (TextView) findViewById(R.id.tvTitleBarTitle);
        this.tvTitleBarTitle.setVisibility(0);
        this.tvTitleBarTitle.setText((int) R.string.cs_my_service);
        this.ivHeaderLeftBack = (ImageView) findViewById(R.id.ivHeaderLeftBack);
        this.ivHeaderLeftBack.setImageResource(R.drawable.mj_tittlebar_main_device_back);
        this.ivHeaderLeftBack.setOnClickListener(this);
        this.ivHeaderRightSetting = (ImageView) findViewById(R.id.ivHeaderRightSetting);
        this.ivHeaderRightSetting.setVisibility(8);
        this.ivHeaderRightSetting.setOnClickListener(this);
        this.ivHeaderRightEdit = (ImageView) findViewById(R.id.ivHeaderRightEdit);
        this.ivHeaderRightEdit.setVisibility(0);
        this.ivHeaderRightEdit.setImageResource(R.drawable.camera_title_edit_drawable);
        this.ivHeaderRightEdit.setOnClickListener(this);
        this.llBottomCtrl = (LinearLayout) findViewById(R.id.llBottomCtrl);
        this.tvDelete = (TextView) findViewById(R.id.tvDelete);
        this.tvDelete.setOnClickListener(this);
        this.tvDownload = (TextView) findViewById(R.id.tvDownload);
        this.tvDownload.setVisibility(0);
        this.tvDownload.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.tvDelete.getLayoutParams());
        layoutParams2.setMargins(gpc.O000000o(20.0f), 0, 0, 0);
        this.tvDelete.setLayoutParams(layoutParams2);
        this.tvBlankHint = (TextView) findViewById(R.id.tvBlankHint);
        this.tvDownloadHint = (TextView) findViewById(R.id.tvDownloadHint);
        this.tvDownloadHint.setOnClickListener(this);
        this.rlCloudVideo = (RelativeLayout) findViewById(R.id.rl_cloud_video);
        this.ivCrown = (ImageView) findViewById(R.id.iv_crown);
        this.tvOrderName = (TextView) findViewById(R.id.tv_order_name);
        this.tvInterval = (TextView) findViewById(R.id.tv_interval);
        this.tvCapacity = (TextView) findViewById(R.id.tv_capacity);
        this.tvValidity = (TextView) findViewById(R.id.tv_validity);
        this.tvManage = (TextView) findViewById(R.id.tv_manage);
        this.tvManage.setOnClickListener(this);
        if (this.isShared) {
            this.tvManage.setVisibility(8);
        }
        this.tvManage.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$bAioG8XgcZELeZcyWFxBsamM37k */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CloudVideoListActivity.this.lambda$initViews$0$CloudVideoListActivity(view, motionEvent);
            }
        });
        this.rvrlVideoList = (RecyclerViewRefreshLayoutEx) findViewById(R.id.rvrlVideoList);
        this.rvrlVideoList.setMode(3);
        this.rvrlVideoList.setOnPullRefreshListener(new RecyclerViewRefreshLayout.OnPullRefreshListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity.AnonymousClass1 */

            public void onPullDistance(int i) {
            }

            public void onPullEnable(boolean z) {
            }

            public void onRefresh() {
                if (CloudVideoListActivity.this.rvrlVideoList.getMode() != 2) {
                    CloudVideoListActivity.this.exitEditMode();
                    CloudVideoDate cloudVideoDate = (CloudVideoDate) CloudVideoListActivity.this.dateListViewAdapter.getItem(CloudVideoListActivity.this.dateListViewAdapter.selectedItemPosition);
                    CloudVideoListActivity.this.getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, 86399000 + cloudVideoDate.timeStamp, true, true);
                }
            }
        });
        this.rvrlVideoList.setFooterRefreshView(LayoutInflater.from(this).inflate((int) R.layout.list_load_more, (ViewGroup) null));
        this.rvrlVideoList.setOnPushLoadMoreListener(new RecyclerViewRefreshLayout.OnPushLoadMoreListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity.AnonymousClass2 */

            public void onPushDistance(int i) {
            }

            public void onPushEnable(boolean z) {
            }

            public void onLoadMore() {
                CloudVideoListActivity.this.handleLoadMore(false);
            }
        });
        this.rvrlVideoList.setRefreshing(false);
        this.rvrlVideoList.setLoadMore(false);
        initLoadingView();
        initListView();
        getVideoDatesSerial(true);
        if (this.isReadyOnly) {
            this.llBottomCtrl.setVisibility(8);
            this.ivHeaderRightEdit.setVisibility(8);
            this.playListAdapter.disableLongPress();
        }
    }

    public /* synthetic */ boolean lambda$initViews$0$CloudVideoListActivity(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.tvManage.setAlpha(0.5f);
            return false;
        } else if (motionEvent.getAction() != 1) {
            return false;
        } else {
            this.tvManage.setAlpha(1.0f);
            return false;
        }
    }

    private void getStatus() {
        ServerBean O0000ooO;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.did);
            if (CoreApi.O000000o().O0000O0o() && CoreApi.O000000o().O0000ooO() != null && (O0000ooO = CoreApi.O000000o().O0000ooO()) != null && !TextUtils.isEmpty(O0000ooO.O00000Oo)) {
                jSONObject.put("region", O0000ooO.O00000Oo);
            }
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo != null) {
                jSONObject.put("language", O00oOooo.getCountry());
            } else {
                jSONObject.put("language", Locale.getDefault().getCountry());
            }
            gsy.O00000Oo("CloudVideoListActivity", "jsonObject:" + jSONObject.toString());
            CloudVideoNetUtils.getInstance().getSettingStatus(this, jSONObject.toString(), new ICloudVideoCallback<CloudVideoUserStatus>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity.AnonymousClass3 */

                public void onCloudVideoSuccess(CloudVideoUserStatus cloudVideoUserStatus, Object obj) {
                    if (!CloudVideoListActivity.this.isFinishing() && cloudVideoUserStatus != null) {
                        gsy.O00000Oo("CloudVideoListActivity", "onCloudVideoSuccess" + cloudVideoUserStatus.toString());
                        CloudVideoListActivity.this.runOnUiThread(new Runnable(cloudVideoUserStatus) {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$3$Mg3WlvFvGZVmMA9OGxY4AhJ1S_A */
                            private final /* synthetic */ CloudVideoUserStatus f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                CloudVideoListActivity.AnonymousClass3.this.lambda$onCloudVideoSuccess$0$CloudVideoListActivity$3(this.f$1);
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onCloudVideoSuccess$0$CloudVideoListActivity$3(CloudVideoUserStatus cloudVideoUserStatus) {
                    CloudVideoUserStatus cloudVideoUserStatus2 = cloudVideoUserStatus;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(gwc.O00000Oo(ftn.O00000o0(CloudVideoListActivity.this.getApplicationContext())));
                    CloudVideoListActivity.this.tvOrderName.setText(cloudVideoUserStatus2.packageType);
                    String string = CloudVideoListActivity.this.getString(R.string.cs_validity);
                    long currentTimeMillis = System.currentTimeMillis() - cloudVideoUserStatus2.startTime;
                    long currentTimeMillis2 = cloudVideoUserStatus2.endTime - System.currentTimeMillis();
                    int millisToDay = CloudVideoListActivity.this.millisToDay(currentTimeMillis2);
                    int millisToDay2 = CloudVideoListActivity.this.millisToDay(currentTimeMillis);
                    CloudVideoListActivity.this.tvInterval.setText(CloudVideoListActivity.this.getResources().getQuantityString(R.plurals.cs_service_time, millisToDay2, Integer.valueOf(millisToDay2)));
                    if (!cloudVideoUserStatus2.vip) {
                        String string2 = CloudVideoListActivity.this.getString(R.string.cs_expire);
                        String replace = string2.replace("#start#", "").replace("#end#", "");
                        AnonymousClass1 r4 = new ClickableSpan() {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity.AnonymousClass3.AnonymousClass1 */

                            public void onClick(View view) {
                                if (!CloudVideoListActivity.this.isShared) {
                                    CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(CloudVideoListActivity.this, CloudVideoListActivity.this.did);
                                }
                            }

                            public void updateDrawState(TextPaint textPaint) {
                                super.updateDrawState(textPaint);
                                textPaint.setUnderlineText(true);
                                textPaint.setColor(CloudVideoListActivity.this.getResources().getColor(R.color.mj_color_possible_result_points));
                            }
                        };
                        SpannableString spannableString = new SpannableString(replace);
                        spannableString.setSpan(r4, string2.indexOf("#start#"), string2.indexOf("#end#") - 7, 33);
                        CloudVideoListActivity.this.tvValidity.setText(spannableString);
                        CloudVideoListActivity.this.tvValidity.setMovementMethod(LinkMovementMethod.getInstance());
                    } else if (cloudVideoUserStatus2.isRenew) {
                        CloudVideoListActivity.this.tvValidity.setText(String.format(CloudVideoListActivity.this.getString(R.string.cs_validity_deduct_order), simpleDateFormat.format(new Date(cloudVideoUserStatus2.endTime))));
                    } else if (millisToDay <= 7) {
                        String format = String.format(string, simpleDateFormat.format(new Date(cloudVideoUserStatus2.endTime)), Integer.valueOf(CloudVideoListActivity.this.millisToDay(currentTimeMillis2)));
                        String replace2 = format.replace("#start#", "").replace("#end#", "");
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(CloudVideoListActivity.this.getResources().getColor(R.color.mj_color_possible_result_points));
                        SpannableString spannableString2 = new SpannableString(replace2);
                        spannableString2.setSpan(foregroundColorSpan, format.indexOf("#start#"), format.indexOf("#end#") - 7, 33);
                        CloudVideoListActivity.this.tvValidity.setText(spannableString2);
                    } else {
                        CloudVideoListActivity.this.tvValidity.setText(String.format(CloudVideoListActivity.this.getString(R.string.cs_validity_2), simpleDateFormat.format(new Date(cloudVideoUserStatus2.endTime))));
                    }
                }

                public void onCloudVideoFailed(int i, String str) {
                    if (!CloudVideoListActivity.this.isFinishing()) {
                        gsy.O000000o(6, "CloudVideoListActivity", "errorCode:" + i + " errorInfo:" + str);
                    }
                }
            });
        } catch (JSONException unused) {
        }
    }

    private void getCapacity() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.did);
            jSONObject.put("region", Locale.getDefault().getCountry());
            CloudVideoNetUtils.getInstance().getSettingCapacity(this, jSONObject.toString(), new ICloudVideoCallback<Long>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity.AnonymousClass4 */

                public void onCloudVideoSuccess(Long l, Object obj) {
                    if (!CloudVideoListActivity.this.isFinishing()) {
                        CloudVideoListActivity.this.runOnUiThread(new Runnable(l) {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$4$aPherzzZA0P0PreXt2TvMLsBWxE */
                            private final /* synthetic */ Long f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                CloudVideoListActivity.AnonymousClass4.this.lambda$onCloudVideoSuccess$0$CloudVideoListActivity$4(this.f$1);
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onCloudVideoSuccess$0$CloudVideoListActivity$4(Long l) {
                    String capacityTranslation = CloudVideoListActivity.this.capacityTranslation(l.longValue());
                    String string = CloudVideoListActivity.this.getString(R.string.cs_capacity);
                    CloudVideoListActivity.this.tvCapacity.setText(String.format(string, capacityTranslation));
                }

                public void onCloudVideoFailed(int i, String str) {
                    if (!CloudVideoListActivity.this.isFinishing()) {
                        gsy.O000000o(6, "CloudVideoListActivity", "errorCode:" + i + " errorInfo:" + str);
                    }
                }
            });
        } catch (JSONException unused) {
        }
    }

    private void initLoadingView() {
        this.ivLoading = (ImageView) findViewById(R.id.ivLoading);
    }

    private void showVideoLoading(boolean z) {
        ImageView imageView = this.ivLoading;
        if (imageView != null) {
            imageView.setVisibility(0);
            Drawable drawable = this.ivLoading.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).start();
            }
            if (z) {
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$o1ajqIPvbwmkvCwQdxeUwCgaGL0 */

                    public final void run() {
                        CloudVideoListActivity.this.lambda$showVideoLoading$1$CloudVideoListActivity();
                    }
                }, 5000);
            }
        }
    }

    /* renamed from: hideVideoLoading */
    public void lambda$showVideoLoading$1$CloudVideoListActivity() {
        if (this.ivLoading != null && !isFinishing()) {
            Drawable drawable = this.ivLoading.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).stop();
            }
            this.ivLoading.setVisibility(8);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void
     arg types: [com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity, int, int, int]
     candidates:
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void */
    private void initListView() {
        this.cvlvVideos = (CloudVideoListView) findViewById(R.id.cvlvVideos);
        this.playListAdapter = new PlayListAdapter();
        this.playListAdapter.isDownloadEnabled = true;
        this.cvlvVideos.setLayoutManager(new GridLayoutManager((Context) this, 3, 1, false));
        this.cvlvVideos.setAdapter(this.playListAdapter);
        PlayListAdapter playListAdapter2 = this.playListAdapter;
        playListAdapter2.modeChangedListener = new PlayListAdapter.ModeChangedListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$OCiEOS9sqULnQYViKUbVV_msYB8 */

            public final void onEditModeChanged(boolean z) {
                CloudVideoListActivity.this.lambda$initListView$2$CloudVideoListActivity(z);
            }
        };
        playListAdapter2.iItemClickListener = new PlayListAdapter.IItemClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$IX0G4deYLK80QWSmPOCL32Rng5w */

            public final void onItemClick(View view, int i, Object obj) {
                CloudVideoListActivity.this.lambda$initListView$3$CloudVideoListActivity(view, i, obj);
            }
        };
        playListAdapter2.iItemLongClickListener = new PlayListAdapter.IItemLongClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$b2zeo8R5E_InUzao_A4oKDtAf0w */

            public final void onItemLongClick(View view, int i) {
                CloudVideoListActivity.this.lambda$initListView$4$CloudVideoListActivity(view, i);
            }
        };
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        this.currentDateString = simpleDateFormat.format(Long.valueOf(timeInMillis));
        this.currentDateTS = timeInMillis;
        gsy.O00000Oo("CloudVideoListActivity", "currentDateString:" + this.currentDateString);
        for (int i = 29; i >= 0; i--) {
            CloudVideoDate cloudVideoDate = new CloudVideoDate();
            long j = timeInMillis - (((long) i) * 86400000);
            String format = simpleDateFormat.format(Long.valueOf(j));
            cloudVideoDate.day = format.split("-")[2];
            cloudVideoDate.month = format.split("-")[1];
            cloudVideoDate.monthChinaPattern = this.monthArray[Integer.valueOf(cloudVideoDate.month).intValue() - 1];
            cloudVideoDate.year = format.split("-")[0];
            cloudVideoDate.timeStamp = j;
            arrayList.add(cloudVideoDate);
        }
        this.cvdlvDays = (CloudVideoDateListView) findViewById(R.id.cvdlvDays);
        this.dateListViewAdapter = new CloudVideoDateListViewAdapter(arrayList);
        this.cvdlvDays.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.cvdlvDays.setAdapter(this.dateListViewAdapter);
        this.cvdlvDays.scrollToPosition(this.dateListViewAdapter.getItemCount() - 1);
        CloudVideoDateListViewAdapter cloudVideoDateListViewAdapter = this.dateListViewAdapter;
        cloudVideoDateListViewAdapter.selectedItemPosition = cloudVideoDateListViewAdapter.getItemCount() - 1;
        this.dateListViewAdapter.iItemClickListener = new CloudVideoDateListViewAdapter.IItemClickListener(simpleDateFormat) {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$Yw2SGDTl4I08SH2lVMw_GLxJwFk */
            private final /* synthetic */ SimpleDateFormat f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemClick(View view, int i, Object obj) {
                CloudVideoListActivity.this.lambda$initListView$5$CloudVideoListActivity(this.f$1, view, i, (CloudVideoDate) obj);
            }
        };
    }

    public /* synthetic */ void lambda$initListView$2$CloudVideoListActivity(boolean z) {
        if (z) {
            this.llBottomCtrl.setVisibility(0);
        } else {
            this.llBottomCtrl.setVisibility(8);
        }
        getWindow().getDecorView().requestLayout();
    }

    public /* synthetic */ void lambda$initListView$3$CloudVideoListActivity(View view, int i, Object obj) {
        Object itemDataByPosition = this.playListAdapter.getItemDataByPosition(i);
        if (itemDataByPosition instanceof CloudVideoChildListData) {
            if (this.playListAdapter.getEditMode()) {
                CloudVideoChildListData cloudVideoChildListData = (CloudVideoChildListData) itemDataByPosition;
                if (cloudVideoChildListData.isSelected || this.playListAdapter.getSelectedItemCount() < PlayListAdapter.MAX_SELECT_COUNT || !this.playListAdapter.isDownloadEnabled) {
                    if (cloudVideoChildListData.isSelected) {
                        cloudVideoChildListData.isSelected = false;
                    } else {
                        cloudVideoChildListData.isSelected = true;
                    }
                    this.playListAdapter.notifyItemChanged(i);
                } else {
                    gqg.O00000Oo((int) R.string.cs_max_download_50);
                    return;
                }
            } else {
                CloudVideoChildListData cloudVideoChildListData2 = (CloudVideoChildListData) itemDataByPosition;
                if (this.mIsHsPanoramaVideo) {
                    CloudHSPlayerActivity.startCloud(getContext(), this.title, this.did, cloudVideoChildListData2.fileId);
                } else {
                    Intent intent = new Intent(getContext(), CloudVideoGeneralPlayerActivity.class);
                    if (!TextUtils.isEmpty(this.title)) {
                        intent.putExtra("title", this.title);
                    }
                    if (!TextUtils.isEmpty(this.model)) {
                        intent.putExtra("model", this.model);
                    }
                    intent.putExtra("did", this.did);
                    intent.putExtra("fileId", cloudVideoChildListData2.fileId);
                    intent.putExtra("selectedItemPosition", this.dateListViewAdapter.selectedItemPosition);
                    intent.putExtra("startTime", cloudVideoChildListData2.startTime);
                    intent.putExtra("duration", cloudVideoChildListData2.duration);
                    intent.putExtra("currentDateTS", this.currentDateTS);
                    startActivityForResult(intent, 1001);
                }
            }
        }
        refreshHeaderRightEdit();
    }

    public /* synthetic */ void lambda$initListView$4$CloudVideoListActivity(View view, int i) {
        if (!this.playListAdapter.getEditMode()) {
            enterEditMode();
            Object itemDataByPosition = this.playListAdapter.getItemDataByPosition(i);
            if (itemDataByPosition instanceof CloudVideoChildListData) {
                ((CloudVideoChildListData) itemDataByPosition).isSelected = true;
                this.playListAdapter.notifyItemChanged(i, "itemChanged");
            }
            refreshHeaderRightEdit();
        }
    }

    public /* synthetic */ void lambda$initListView$5$CloudVideoListActivity(SimpleDateFormat simpleDateFormat, View view, int i, CloudVideoDate cloudVideoDate) {
        exitEditMode();
        if (cloudVideoDate != null) {
            this.currentDateString = simpleDateFormat.format(Long.valueOf(cloudVideoDate.timeStamp));
            this.currentDateTS = cloudVideoDate.timeStamp;
        }
        if (cloudVideoDate.isHasVideo) {
            this.tvBlankHint.setVisibility(8);
            getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, cloudVideoDate.timeStamp + 86399000, true, true);
            return;
        }
        lambda$showVideoLoading$1$CloudVideoListActivity();
        RecyclerViewRefreshLayoutEx recyclerViewRefreshLayoutEx = this.rvrlVideoList;
        if (recyclerViewRefreshLayoutEx != null) {
            recyclerViewRefreshLayoutEx.setLoadMore(false);
            if (this.rvrlVideoList.isRefreshing()) {
                this.rvrlVideoList.setRefreshing(false);
            }
        }
        this.tvBlankHint.setVisibility(0);
        this.playListAdapter.listData.clear();
        this.playListAdapter.notifyDataSetChanged();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            exitEditMode();
            getVideoDatesSerial(false);
            CloudVideoDateListViewAdapter cloudVideoDateListViewAdapter = this.dateListViewAdapter;
            CloudVideoDate cloudVideoDate = (CloudVideoDate) cloudVideoDateListViewAdapter.getItem(cloudVideoDateListViewAdapter.selectedItemPosition);
            getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, 86399000 + cloudVideoDate.timeStamp, true, true);
        }
    }

    public void onBackPressed() {
        RecyclerViewRefreshLayoutEx recyclerViewRefreshLayoutEx = this.rvrlVideoList;
        if (recyclerViewRefreshLayoutEx != null && recyclerViewRefreshLayoutEx.getMode() == 2) {
            this.rvrlVideoList.setMode(3);
        }
        this.ivHeaderRightEdit.setImageResource(R.drawable.camera_title_edit_drawable);
        PlayListAdapter playListAdapter2 = this.playListAdapter;
        if (playListAdapter2 == null || !playListAdapter2.getEditMode()) {
            super.onBackPressed();
            return;
        }
        this.playListAdapter.setEditMode(false);
        this.playListAdapter.notifyDataSetChanged();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void onClick(View view) {
        if (view.getId() == R.id.ivHeaderLeftBack) {
            onBackPressed();
        } else if (view.getId() == R.id.ivHeaderRightEdit) {
            PlayListAdapter playListAdapter2 = this.playListAdapter;
            if (playListAdapter2 == null) {
                return;
            }
            if (playListAdapter2.getEditMode()) {
                if (this.playListAdapter.hasMaxSelect()) {
                    gsy.O00000Oo("CloudVideoListActivity", "cancel max selecting");
                    this.mMaxSelecting = false;
                    this.playListAdapter.unSelectAllItem();
                } else {
                    this.playListAdapter.selectMaxCntItems();
                    if (this.playListAdapter.getChildItemCount() <= PlayListAdapter.MAX_SELECT_COUNT) {
                        gsy.O00000Oo("CloudVideoListActivity", "start max selecting: " + this.playListAdapter.getChildItemCount());
                        handleLoadMore(true);
                    }
                }
                refreshHeaderRightEdit();
                return;
            }
            PlayListAdapter playListAdapter3 = this.playListAdapter;
            if (playListAdapter3 == null || playListAdapter3.getChildItemCount() <= 0) {
                gqg.O00000Oo((int) R.string.cs_no_video_today);
                return;
            }
            enterEditMode();
            if (this.playListAdapter.getEditMode()) {
                this.ivHeaderRightEdit.setImageResource(R.drawable.camera_edit_select_all_black);
            }
        } else if (view.getId() == R.id.tvDelete) {
            PlayListAdapter playListAdapter4 = this.playListAdapter;
            if (playListAdapter4 == null || playListAdapter4.getSelectedItemCount() <= 0) {
                gqg.O00000Oo((int) R.string.cs_select_video);
            } else if (this.playListAdapter.getSelectedItems().size() > PlayListAdapter.MAX_SELECT_COUNT) {
                gqg.O00000Oo((int) R.string.cs_max_delete_50);
            } else if (this.mMaxSelecting) {
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$d4cCYY3r8WBlmHBa3tE4UxH3CIs */

                    public final void run() {
                        CloudVideoListActivity.this.lambda$onClick$6$CloudVideoListActivity();
                    }
                }, 100);
            } else {
                videoDeleteCheck(this.playListAdapter.getSelectedItems());
            }
        } else if (view.getId() == R.id.tvDownload) {
            int selectedItemCount = this.playListAdapter.getSelectedItemCount();
            if (this.playListAdapter == null || selectedItemCount <= 0 || selectedItemCount > PlayListAdapter.MAX_SELECT_COUNT) {
                if (this.playListAdapter == null || selectedItemCount <= PlayListAdapter.MAX_SELECT_COUNT) {
                    gqg.O00000Oo((int) R.string.cs_select_video);
                } else {
                    gqg.O00000Oo((int) R.string.cs_max_download_50);
                }
            } else if (this.mMaxSelecting) {
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$2a97ohKo7k23ovlowNCvIdbhnLA */

                    public final void run() {
                        CloudVideoListActivity.this.lambda$onClick$7$CloudVideoListActivity();
                    }
                }, 100);
            } else {
                lambda$onClick$7$CloudVideoListActivity();
            }
        } else if (view.getId() == R.id.tvDownloadHint) {
            if (DeviceConstant.isSupportCloudMp4Download(this.model)) {
                Intent intent = new Intent(this, AlbumActivity.class);
                intent.putExtra("extra_device_did", this.did);
                intent.putExtra("extra_device_model", this.model);
                intent.putExtra("is_v4", true);
                intent.putExtra("did", this.did);
                if (!TextUtils.isEmpty(this.title)) {
                    intent.putExtra("title", this.title);
                }
                Device O000000o2 = fno.O000000o().O000000o(this.did);
                if (O000000o2 != null) {
                    intent.putExtra("uid", O000000o2.userId);
                    startActivity(intent);
                    return;
                }
                return;
            }
            Intent intent2 = new Intent(this, CloudVideoDownloadActivity.class);
            intent2.putExtra("did", this.did);
            if (!TextUtils.isEmpty(this.title)) {
                intent2.putExtra("title", this.title);
            }
            intent2.putExtra("is_hs_panorama_video", this.mIsHsPanoramaVideo);
            Device O000000o3 = fno.O000000o().O000000o(this.did);
            if (O000000o3 != null) {
                intent2.putExtra("uid", O000000o3.userId);
                startActivity(intent2);
            }
        } else if (view.getId() == R.id.tv_manage) {
            hxi.O00000o.f952O000000o.O000000o("pintro_vip_click", new Object[0]);
            CloudVideoNetUtils.getInstance().openCloudVideoManagePage(this, this.did, this.mIsHsPanoramaVideo);
        }
    }

    public /* synthetic */ void lambda$onClick$6$CloudVideoListActivity() {
        videoDeleteCheck(this.playListAdapter.getSelectedItems());
    }

    public void getPlayListLimit(CloudVideoDate cloudVideoDate, long j, long j2, boolean z, boolean z2) {
        getPlayListLimit(cloudVideoDate, j, j2, z, z2, false);
    }

    private void getPlayListLimit(CloudVideoDate cloudVideoDate, long j, long j2, final boolean z, boolean z2, boolean z3) {
        if (cloudVideoDate.isHasVideo) {
            try {
                gsy.O00000Oo("CloudVideoListActivity", "getPlayListLimit:" + cloudVideoDate.year + "-" + cloudVideoDate.month + "-" + cloudVideoDate.day);
                long gMT8TimeZone = CloudVideoNetUtils.getInstance().toGMT8TimeZone(j);
                long gMT8TimeZone2 = CloudVideoNetUtils.getInstance().toGMT8TimeZone(j2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("did", this.did);
                jSONObject.put("model", this.model);
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("language", Locale.getDefault().getLanguage());
                jSONObject.put("beginTime", gMT8TimeZone);
                jSONObject.put("endTime", gMT8TimeZone2);
                jSONObject.put("limit", 20);
                if (z2) {
                    showVideoLoading(false);
                }
                this.cvlvVideos.setEnabled(false);
                this.mMaxSelecting = z3;
                CloudVideoNetUtils.getInstance().getVideoDailyListLimitV2(getContext(), jSONObject.toString(), new ICloudVideoCallback<List<DailyList>>() {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity.AnonymousClass5 */

                    public /* bridge */ /* synthetic */ void onCloudVideoSuccess(Object obj, Object obj2) {
                        onCloudVideoSuccess((List<DailyList>) ((List) obj), obj2);
                    }

                    public void onCloudVideoSuccess(List<DailyList> list, Object obj) {
                        if (!CloudVideoListActivity.this.isFinishing()) {
                            CloudVideoListActivity.this.cvlvVideos.setEnabled(true);
                            long localTimeZone = CloudVideoNetUtils.getInstance().toLocalTimeZone(((Long) obj).longValue());
                            long j = (CloudVideoListActivity.this.currentDateTS + 86400000) - 1000;
                            CloudVideoListActivity.this.rvrlVideoList.setLoadMore(false);
                            if (CloudVideoListActivity.this.rvrlVideoList.isRefreshing()) {
                                CloudVideoListActivity.this.rvrlVideoList.setRefreshing(false);
                            }
                            if (z) {
                                CloudVideoListActivity.this.playListAdapter.clearAllData();
                            }
                            long dayTS0 = CloudVideoUtils.getDayTS0(localTimeZone);
                            long dayTS02 = CloudVideoUtils.getDayTS0(j);
                            if (localTimeZone <= 0 || dayTS0 != dayTS02) {
                                CloudVideoListActivity.this.lambda$showVideoLoading$1$CloudVideoListActivity();
                            } else if (list == null || list.isEmpty()) {
                                CloudVideoListActivity.this.lambda$showVideoLoading$1$CloudVideoListActivity();
                                if (CloudVideoListActivity.this.playListAdapter != null) {
                                    CloudVideoListActivity.this.playListAdapter.notifyDataSetChanged();
                                }
                                CloudVideoListActivity.this.isTodayHasVideo();
                            } else {
                                goq.O000000o(new Runnable(list, CloudVideoListActivity.this.playListAdapter.getAllItemCount()) {
                                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$5$4huovM_2S_phY0ouOlEuxUGJWY */
                                    private final /* synthetic */ List f$1;
                                    private final /* synthetic */ int f$2;

                                    {
                                        this.f$1 = r2;
                                        this.f$2 = r3;
                                    }

                                    public final void run() {
                                        CloudVideoListActivity.AnonymousClass5.this.lambda$onCloudVideoSuccess$1$CloudVideoListActivity$5(this.f$1, this.f$2);
                                    }
                                });
                            }
                        }
                    }

                    public /* synthetic */ void lambda$onCloudVideoSuccess$1$CloudVideoListActivity$5(List list, int i) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            DailyList dailyList = (DailyList) it.next();
                            CloudVideoChildListData cloudVideoChildListData = new CloudVideoChildListData();
                            cloudVideoChildListData.duration = dailyList.duration;
                            cloudVideoChildListData.imgStoreId = dailyList.imgStoreId;
                            cloudVideoChildListData.isPeople = dailyList.isHuman;
                            cloudVideoChildListData.fileId = dailyList.fileId;
                            cloudVideoChildListData.imgStoreUrl = CloudVideoNetUtils.getInstance().getSnapshotUrl(CloudVideoListActivity.this.did, dailyList.fileId, dailyList.imgStoreId);
                            cloudVideoChildListData.startTime = dailyList.createTime;
                            CloudVideoListActivity.this.playListAdapter.append(Integer.valueOf(simpleDateFormat.format(Long.valueOf(cloudVideoChildListData.startTime))).intValue(), cloudVideoChildListData);
                        }
                        CloudVideoListActivity.this.runOnUiThread(new Runnable(i) {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$5$UsCNohjMnMFbPu45AEDJz9TuzUM */
                            private final /* synthetic */ int f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                CloudVideoListActivity.AnonymousClass5.this.lambda$null$0$CloudVideoListActivity$5(this.f$1);
                            }
                        });
                    }

                    public /* synthetic */ void lambda$null$0$CloudVideoListActivity$5(int i) {
                        CloudVideoListActivity.this.lambda$showVideoLoading$1$CloudVideoListActivity();
                        CloudVideoListActivity.this.isTodayHasVideo();
                        int allItemCount = CloudVideoListActivity.this.playListAdapter.getAllItemCount();
                        if (allItemCount == i) {
                            gqg.O00000Oo((int) R.string.cs_alarm_none_data);
                        }
                        CloudVideoListActivity.this.playListAdapter.notifyDataSetChanged();
                        if (CloudVideoListActivity.this.mMaxSelecting) {
                            CloudVideoListActivity.this.playListAdapter.selectMaxCntItems();
                            if (CloudVideoListActivity.this.playListAdapter.getChildItemCount() >= PlayListAdapter.MAX_SELECT_COUNT || allItemCount == i) {
                                gsy.O00000Oo("CloudVideoListActivity", "end max selecting: " + CloudVideoListActivity.this.playListAdapter.getChildItemCount());
                                CloudVideoListActivity.this.mMaxSelecting = false;
                                return;
                            }
                            CloudVideoListActivity.this.handleLoadMore(true);
                        }
                    }

                    public void onCloudVideoFailed(int i, String str) {
                        if (!CloudVideoListActivity.this.isFinishing()) {
                            if (z && -90002 == i && CloudVideoListActivity.this.playListAdapter != null) {
                                CloudVideoListActivity.this.playListAdapter.clearAllData();
                            }
                            if (CloudVideoListActivity.this.playListAdapter != null) {
                                CloudVideoListActivity.this.playListAdapter.notifyDataSetChanged();
                            }
                            CloudVideoListActivity.this.cvlvVideos.setEnabled(true);
                            CloudVideoListActivity.this.rvrlVideoList.setLoadMore(false);
                            if (CloudVideoListActivity.this.rvrlVideoList.isRefreshing()) {
                                CloudVideoListActivity.this.rvrlVideoList.setRefreshing(false);
                            }
                            CloudVideoListActivity cloudVideoListActivity = CloudVideoListActivity.this;
                            cloudVideoListActivity.mMaxSelecting = false;
                            cloudVideoListActivity.lambda$showVideoLoading$1$CloudVideoListActivity();
                            CloudVideoListActivity.this.isTodayHasVideo();
                            gsy.O000000o(6, "CloudVideoListActivity", "errorCode:" + i + " errorInfo:" + str);
                        }
                    }
                });
            } catch (JSONException unused) {
                if (!isFinishing()) {
                    lambda$showVideoLoading$1$CloudVideoListActivity();
                    this.rvrlVideoList.setLoadMore(false);
                    if (this.rvrlVideoList.isRefreshing()) {
                        this.rvrlVideoList.setRefreshing(false);
                    }
                    this.mMaxSelecting = false;
                }
            }
        } else {
            if (z) {
                this.playListAdapter.listData.clear();
                if (!this.playListAdapter.getEditMode()) {
                    this.playListAdapter.notifyDataSetChanged();
                }
            }
            this.rvrlVideoList.setLoadMore(false);
            if (this.rvrlVideoList.isRefreshing()) {
                this.rvrlVideoList.setRefreshing(false);
            }
        }
    }

    private void refreshHeaderRightEdit() {
        if (this.playListAdapter.hasMaxSelect()) {
            this.ivHeaderRightEdit.setImageResource(R.drawable.camera_edit_deselect_all_black);
        } else {
            this.ivHeaderRightEdit.setImageResource(R.drawable.camera_edit_select_all_black);
        }
    }

    public void getVideoDatesSerial(boolean z) {
        int i;
        this.datesUpdateVar = 0;
        int i2 = 29;
        for (int i3 = 0; i3 < 5; i3++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.did);
                jSONObject.put("model", this.model);
                Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                if (O00oOooo != null) {
                    jSONObject.put("region", O00oOooo.getCountry());
                } else {
                    jSONObject.put("region", Locale.getDefault().getCountry());
                }
                JSONArray jSONArray = new JSONArray();
                i = i2;
                int i4 = 0;
                while (i4 < 6) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        CloudVideoDate cloudVideoDate = this.dateListViewAdapter.cloudVideoDates.get(i);
                        long gMT8TimeZone = CloudVideoNetUtils.getInstance().toGMT8TimeZone(cloudVideoDate.timeStamp);
                        long gMT8TimeZone2 = CloudVideoNetUtils.getInstance().toGMT8TimeZone(cloudVideoDate.timeStamp + 86399000);
                        jSONObject2.put("beginTime", gMT8TimeZone);
                        jSONObject2.put("endTime", gMT8TimeZone2);
                        jSONArray.put(jSONObject2);
                        i--;
                        i4++;
                    } catch (JSONException e) {
                        e = e;
                        lambda$showVideoLoading$1$CloudVideoListActivity();
                        gsy.O000000o(6, "CloudVideoListActivity", "exception:" + e.toString());
                        i2 = i;
                    }
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("intervals", jSONArray);
                jSONObject.put("intervals", jSONObject3);
                if (!TextUtils.isEmpty(this.did)) {
                    showVideoLoading(false);
                    this.datesUpdateVar++;
                    final boolean z2 = z;
                    try {
                        CloudVideoNetUtils.getInstance().getVideoDatesSerial(this, jSONObject.toString(), new ICloudVideoCallback<List<StatsRecord2>>() {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity.AnonymousClass6 */

                            public /* bridge */ /* synthetic */ void onCloudVideoSuccess(Object obj, Object obj2) {
                                onCloudVideoSuccess((List<StatsRecord2>) ((List) obj), obj2);
                            }

                            public void onCloudVideoSuccess(List<StatsRecord2> list, Object obj) {
                                if (!CloudVideoListActivity.this.isFinishing()) {
                                    CloudVideoListActivity.this.datesUpdateVar--;
                                    CloudVideoListActivity.this.lambda$showVideoLoading$1$CloudVideoListActivity();
                                    for (StatsRecord2 next : list) {
                                        for (CloudVideoDate next2 : CloudVideoListActivity.this.dateListViewAdapter.cloudVideoDates) {
                                            if (CloudVideoNetUtils.getInstance().toLocalTimeZone(next.timeStamp) == next2.timeStamp + 86399000) {
                                                if (next.isExist) {
                                                    next2.isHasVideo = true;
                                                } else {
                                                    next2.isHasVideo = false;
                                                }
                                                next2.lastUpdateTS = System.currentTimeMillis();
                                            }
                                        }
                                    }
                                    CloudVideoListActivity.this.dateListViewAdapter.notifyDataSetChanged();
                                    CloudVideoListActivity.this.isTodayHasVideo();
                                    if (((CloudVideoDate) CloudVideoListActivity.this.dateListViewAdapter.getItem(CloudVideoListActivity.this.dateListViewAdapter.selectedItemPosition)).isHasVideo) {
                                        CloudVideoListActivity.this.tvBlankHint.setVisibility(8);
                                        if (CloudVideoListActivity.this.datesUpdateVar == 0 && z2 && CloudVideoListActivity.this.dateListViewAdapter != null && CloudVideoListActivity.this.dateListViewAdapter.getItemCount() > 0) {
                                            CloudVideoDate cloudVideoDate = (CloudVideoDate) CloudVideoListActivity.this.dateListViewAdapter.getItem(CloudVideoListActivity.this.dateListViewAdapter.selectedItemPosition >= 0 ? CloudVideoListActivity.this.dateListViewAdapter.selectedItemPosition : CloudVideoListActivity.this.dateListViewAdapter.getItemCount() - 1);
                                            CloudVideoListActivity.this.getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, cloudVideoDate.timeStamp + 86399000, true, true);
                                            return;
                                        }
                                        return;
                                    }
                                    CloudVideoListActivity.this.lambda$showVideoLoading$1$CloudVideoListActivity();
                                    if (CloudVideoListActivity.this.rvrlVideoList != null) {
                                        CloudVideoListActivity.this.rvrlVideoList.setLoadMore(false);
                                        if (CloudVideoListActivity.this.rvrlVideoList.isRefreshing()) {
                                            CloudVideoListActivity.this.rvrlVideoList.setRefreshing(false);
                                        }
                                    }
                                    CloudVideoListActivity.this.tvBlankHint.setVisibility(0);
                                    CloudVideoListActivity.this.playListAdapter.listData.clear();
                                    CloudVideoListActivity.this.playListAdapter.notifyDataSetChanged();
                                }
                            }

                            public void onCloudVideoFailed(int i, String str) {
                                if (!CloudVideoListActivity.this.isFinishing()) {
                                    CloudVideoListActivity.this.lambda$showVideoLoading$1$CloudVideoListActivity();
                                    CloudVideoListActivity.this.isTodayHasVideo();
                                    CloudVideoListActivity cloudVideoListActivity = CloudVideoListActivity.this;
                                    cloudVideoListActivity.datesUpdateVar--;
                                    if (CloudVideoListActivity.this.datesUpdateVar == 0 && z2 && CloudVideoListActivity.this.dateListViewAdapter != null && CloudVideoListActivity.this.dateListViewAdapter.getItemCount() > 0) {
                                        CloudVideoDate cloudVideoDate = (CloudVideoDate) CloudVideoListActivity.this.dateListViewAdapter.getItem(CloudVideoListActivity.this.dateListViewAdapter.selectedItemPosition >= 0 ? CloudVideoListActivity.this.dateListViewAdapter.selectedItemPosition : CloudVideoListActivity.this.dateListViewAdapter.getItemCount() - 1);
                                        CloudVideoListActivity.this.getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, 86399000 + cloudVideoDate.timeStamp, true, true);
                                    }
                                    gsy.O000000o(6, "CloudVideoListActivity", "errorCode:" + i + ":" + str);
                                }
                            }
                        });
                    } catch (JSONException e2) {
                        e = e2;
                        lambda$showVideoLoading$1$CloudVideoListActivity();
                        gsy.O000000o(6, "CloudVideoListActivity", "exception:" + e.toString());
                        i2 = i;
                    }
                } else {
                    boolean z3 = z;
                    gqg.O00000Oo((int) R.string.cs_device_info_fail);
                }
            } catch (JSONException e3) {
                e = e3;
                i = i2;
                lambda$showVideoLoading$1$CloudVideoListActivity();
                gsy.O000000o(6, "CloudVideoListActivity", "exception:" + e.toString());
                i2 = i;
            }
            i2 = i;
        }
    }

    private void deleteVideos(List<CloudVideoChildListData> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.did);
            jSONObject.put("model", this.model);
            JSONArray jSONArray = new JSONArray();
            for (CloudVideoChildListData cloudVideoChildListData : list) {
                jSONArray.put(cloudVideoChildListData.fileId);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fileIds", jSONArray);
            jSONObject.put("fileIds", jSONObject2);
            showVideoLoading(true);
            CloudVideoNetUtils.getInstance().deleteFiles(getContext(), jSONObject.toString(), new ICloudVideoCallback<String>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity.AnonymousClass7 */

                public void onCloudVideoSuccess(String str, Object obj) {
                    if (!CloudVideoListActivity.this.isFinishing()) {
                        CloudVideoListActivity.this.lambda$showVideoLoading$1$CloudVideoListActivity();
                        CloudVideoListActivity.this.exitEditMode();
                        CloudVideoListActivity.this.getVideoDatesSerial(false);
                        CloudVideoDate cloudVideoDate = (CloudVideoDate) CloudVideoListActivity.this.dateListViewAdapter.getItem(CloudVideoListActivity.this.dateListViewAdapter.selectedItemPosition);
                        CloudVideoListActivity.this.getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, 86399000 + cloudVideoDate.timeStamp, true, true);
                        CloudVideoListActivity.this.setResult(-1);
                    }
                }

                public void onCloudVideoFailed(int i, String str) {
                    if (!CloudVideoListActivity.this.isFinishing()) {
                        CloudVideoListActivity.this.lambda$showVideoLoading$1$CloudVideoListActivity();
                        gqg.O000000o((int) R.string.delete_failed);
                        gsy.O000000o(6, "CloudVideoListActivity", "errorCode:" + i + " errorInfo:" + str);
                        CloudVideoListActivity.this.exitEditMode();
                        CloudVideoListActivity.this.getVideoDatesSerial(false);
                    }
                }
            });
        } catch (JSONException unused) {
            lambda$showVideoLoading$1$CloudVideoListActivity();
        }
    }

    public void exitEditMode() {
        this.ivHeaderRightEdit.setImageResource(R.drawable.camera_title_edit_drawable);
        PlayListAdapter playListAdapter2 = this.playListAdapter;
        if (playListAdapter2 != null && playListAdapter2.getEditMode()) {
            this.playListAdapter.setEditMode(false);
            this.playListAdapter.notifyDataSetChanged();
        }
        RecyclerViewRefreshLayoutEx recyclerViewRefreshLayoutEx = this.rvrlVideoList;
        if (recyclerViewRefreshLayoutEx != null) {
            recyclerViewRefreshLayoutEx.setMode(3);
        }
    }

    private void enterEditMode() {
        RecyclerViewRefreshLayoutEx recyclerViewRefreshLayoutEx = this.rvrlVideoList;
        if (recyclerViewRefreshLayoutEx != null) {
            recyclerViewRefreshLayoutEx.setMode(2);
            this.rvrlVideoList.setRefreshing(false);
            this.rvrlVideoList.setLoadMore(false);
        }
        PlayListAdapter playListAdapter2 = this.playListAdapter;
        if (playListAdapter2 != null && !playListAdapter2.getEditMode()) {
            this.playListAdapter.setEditMode(true);
            this.playListAdapter.notifyDataSetChanged();
        }
    }

    private void videoDeleteCheck(List<CloudVideoChildListData> list) {
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.cs_delete_video)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(list) {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$jKRkeY868jl7a7iDgab1kYCX1oI */
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                CloudVideoListActivity.this.lambda$videoDeleteCheck$8$CloudVideoListActivity(this.f$1, dialogInterface, i);
            }
        }).O000000o(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$zk4KThZhFJQHeKpQvbTdecM8cA */

            public final void onCancel(DialogInterface dialogInterface) {
                CloudVideoListActivity.this.lambda$videoDeleteCheck$9$CloudVideoListActivity(dialogInterface);
            }
        }).O00000Oo((int) R.string.camera_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$A_EWHopGzxQKaunc5VatoW5PzVE */

            public final void onClick(DialogInterface dialogInterface, int i) {
                CloudVideoListActivity.this.lambda$videoDeleteCheck$10$CloudVideoListActivity(dialogInterface, i);
            }
        }).O00000oo();
    }

    public /* synthetic */ void lambda$videoDeleteCheck$8$CloudVideoListActivity(List list, DialogInterface dialogInterface, int i) {
        gsy.O00000Oo("CloudVideoListActivity", "deleteVideos size:" + list.size());
        deleteVideos(list);
    }

    public /* synthetic */ void lambda$videoDeleteCheck$10$CloudVideoListActivity(DialogInterface dialogInterface, int i) {
        exitEditMode();
    }

    public /* synthetic */ void lambda$videoDeleteCheck$9$CloudVideoListActivity(DialogInterface dialogInterface) {
        exitEditMode();
    }

    public void isTodayHasVideo() {
        PlayListAdapter playListAdapter2 = this.playListAdapter;
        if (playListAdapter2 == null || playListAdapter2.listData == null || !this.playListAdapter.isContainVideoData()) {
            this.tvBlankHint.setVisibility(0);
        } else {
            this.tvBlankHint.setVisibility(8);
        }
    }

    private void addDownloadList(List<CloudVideoChildListData> list) {
        if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
        } else if (!TextUtils.isEmpty(this.did) && list != null) {
            chr.O000000o(chr.O000oooO);
            gsy.O00000Oo("CloudVideoListActivity", "addDownloadList size:" + list.size());
            Device O000000o2 = fno.O000000o().O000000o(this.did);
            if (O000000o2 != null) {
                ArrayList arrayList = new ArrayList();
                for (CloudVideoChildListData next : list) {
                    CloudVideoDownloadInfo cloudVideoDownloadInfo = new CloudVideoDownloadInfo();
                    cloudVideoDownloadInfo.uid = O000000o2.userId;
                    cloudVideoDownloadInfo.did = this.did;
                    if (!TextUtils.isEmpty(cloudVideoDownloadInfo.uid) && !TextUtils.isEmpty(cloudVideoDownloadInfo.did)) {
                        cloudVideoDownloadInfo.videoUrl = CloudVideoNetUtils.getInstance().getVideoFileUrl(this.did, next.fileId, false);
                        cloudVideoDownloadInfo.mp4FilePath = null;
                        cloudVideoDownloadInfo.m3u8FilePath = null;
                        cloudVideoDownloadInfo.fileId = next.fileId;
                        if (!TextUtils.isEmpty(this.title)) {
                            cloudVideoDownloadInfo.title = this.title;
                        }
                        cloudVideoDownloadInfo.status = 4;
                        cloudVideoDownloadInfo.createTime = System.currentTimeMillis();
                        cloudVideoDownloadInfo.startTime = next.startTime;
                        cloudVideoDownloadInfo.endTime = next.startTime + next.duration;
                        cloudVideoDownloadInfo.duration = next.duration;
                        cloudVideoDownloadInfo.createTimePretty = this.sdf.format(Long.valueOf(cloudVideoDownloadInfo.createTime));
                        cloudVideoDownloadInfo.startTimePretty = this.sdf.format(Long.valueOf(cloudVideoDownloadInfo.startTime));
                        cloudVideoDownloadInfo.endTimePretty = this.sdf.format(Long.valueOf(cloudVideoDownloadInfo.endTime));
                        cloudVideoDownloadInfo.size = 0;
                        cloudVideoDownloadInfo.progress = 0;
                        arrayList.add(cloudVideoDownloadInfo);
                    }
                }
                if (arrayList.size() != 1 || !CloudVideoDownloadManager.getInstance(this.model).isExistsVideo(this.model, (CloudVideoDownloadInfo) arrayList.get(0))) {
                    showDownloadActivityHint();
                    CloudVideoDownloadManager.getInstance(this.model).insertRecords(arrayList);
                    CloudVideoDownloadManager.getInstance(this.model).pullDownloadFromList(getContext(), O000000o2.userId, this.did);
                    return;
                }
                gqg.O00000Oo((int) R.string.cloud_mp4_download_exists);
            }
        }
    }

    private void showDownloadActivityHint() {
        this.tvDownloadHint.setVisibility(0);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity.AnonymousClass8 */

            public void run() {
                if (CloudVideoListActivity.this.tvDownloadHint != null) {
                    CloudVideoListActivity.this.tvDownloadHint.setVisibility(8);
                }
            }
        }, 5000);
    }

    /* access modifiers changed from: private */
    /* renamed from: downloadHint */
    public void lambda$onClick$7$CloudVideoListActivity() {
        if (CloudVideoNetUtils.getInstance().isWifiConnected(this)) {
            addDownloadList(this.playListAdapter.getSelectedItems());
            exitEditMode();
            return;
        }
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.cs_non_wifi_environment)).O000000o((int) R.string.cs_go_on, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListActivity$q_9pt5EAhxrN2zt3nzum1TQB_Lo */

            public final void onClick(DialogInterface dialogInterface, int i) {
                CloudVideoListActivity.this.lambda$downloadHint$11$CloudVideoListActivity(dialogInterface, i);
            }
        }).O000000o($$Lambda$CloudVideoListActivity$sbdfdFZJCWkhIHAWvoKrNYDthok.INSTANCE).O00000Oo((int) R.string.cs_cancel, $$Lambda$CloudVideoListActivity$nnuD_EYn2plcCAUQBP0tG_z8uEA.INSTANCE).O00000oo();
    }

    public /* synthetic */ void lambda$downloadHint$11$CloudVideoListActivity(DialogInterface dialogInterface, int i) {
        addDownloadList(this.playListAdapter.getSelectedItems());
        exitEditMode();
    }

    public String capacityTranslation(long j) {
        if (j < 1024) {
            try {
                return String.valueOf(j) + "MB";
            } catch (Exception unused) {
            }
        } else if (j < 1048576) {
            return String.format(Locale.getDefault(), "%.2f", Float.valueOf(((float) j) / 1024.0f)) + "GB";
        } else {
            if (j < 1073741824) {
                return String.format(Locale.getDefault(), "%.2f", Float.valueOf(((float) j) / 1048576.0f)) + "TB";
            }
            return "MAX";
        }
    }

    public int millisToDay(long j) {
        if (j > 0) {
            return ((int) (j / 86400000)) + 1;
        }
        return 0;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.isFromRn) {
            chr.O000000o("u5v.u1o.4k5.5e7", "time", Integer.valueOf((int) ((System.currentTimeMillis() - this.createTime) / 1000)));
        }
    }

    /* access modifiers changed from: protected */
    public void handleLoadMore(boolean z) {
        CloudVideoDateListViewAdapter cloudVideoDateListViewAdapter = this.dateListViewAdapter;
        CloudVideoDate cloudVideoDate = (CloudVideoDate) cloudVideoDateListViewAdapter.getItem(cloudVideoDateListViewAdapter.selectedItemPosition);
        PlayListAdapter playListAdapter2 = this.playListAdapter;
        Object itemDataByPosition = playListAdapter2.getItemDataByPosition(playListAdapter2.getItemCount() - 1);
        if (itemDataByPosition instanceof CloudVideoChildListData) {
            long j = cloudVideoDate.timeStamp;
            long j2 = ((CloudVideoChildListData) itemDataByPosition).startTime;
            gsy.O00000Oo("CloudVideoListActivity", "onLoadMore beginTime:" + this.sdf.format(Long.valueOf(j)) + " endTime:" + this.sdf.format(Long.valueOf(j2)));
            getPlayListLimit(cloudVideoDate, j, j2, false, true, z);
            return;
        }
        this.rvrlVideoList.setLoadMore(false);
        if (this.rvrlVideoList.isRefreshing()) {
            this.rvrlVideoList.setRefreshing(false);
        }
    }
}
