package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.chr;
import _m_j.cjm;
import _m_j.cki;
import _m_j.ckv;
import _m_j.fno;
import _m_j.gkv;
import _m_j.goq;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hzf;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mijia.generalplayer.videoview.BasicVideoView;
import com.mijia.generalplayer.videoview.GeneralVideoView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDateListViewAdapter;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoGeneralPlayerActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.adapter.PlayListAdapter;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoChildListData;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDate;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.DailyList;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.StatsRecord2;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.views.RecyclerViewRefreshLayout;
import com.xiaomi.smarthome.miio.camera.cloudstorage.views.RecyclerViewRefreshLayoutEx;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudVideoGeneralPlayerActivity extends CloudVideoBaseActivity implements View.OnClickListener {
    public long currentDateTS = 0;
    private CloudVideoDateListView cvdlvDays;
    public CloudVideoListView cvlvVideos;
    public CloudVideoDateListViewAdapter dateListViewAdapter;
    public int datesUpdateVar = 0;
    public String did;
    public long duration;
    public String fileId;
    public GeneralVideoView generalVideoView;
    private boolean isReadOnly;
    private boolean isShared;
    private boolean isV4;
    private ImageView ivDataLoading;
    private ImageView ivHeaderLeftBack;
    private ImageView ivHeaderRightSetting;
    private String model = null;
    private String[] monthArray;
    public PlayListAdapter playListAdapter;
    private RelativeLayout rlTitleBar;
    public RecyclerViewRefreshLayoutEx rvrlVideoList;
    public long startTime;
    private String title;
    private TextView tvBlankHint;
    private TextView tvDownloadHint;
    private TextView tvTitleBarTitle;
    private String videoUrl;
    private ViewGroup videoViewParent;

    static /* synthetic */ void lambda$doCheckAndDelete$6(DialogInterface dialogInterface) {
    }

    static /* synthetic */ void lambda$doCheckAndDelete$7(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ void lambda$downloadHint$10(DialogInterface dialogInterface) {
    }

    static /* synthetic */ void lambda$downloadHint$11(DialogInterface dialogInterface, int i) {
    }

    public void hideVideoLoading() {
    }

    public boolean supportOrientationListen() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        Device O000000o2;
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_video_general_player);
        this.title = getIntent().getStringExtra("title");
        this.did = getIntent().getStringExtra("did");
        this.fileId = getIntent().getStringExtra("fileId");
        this.startTime = getIntent().getLongExtra("startTime", 0);
        this.duration = getIntent().getLongExtra("duration", 0);
        this.currentDateTS = getIntent().getLongExtra("currentDateTS", 0);
        this.monthArray = gkv.f17949O000000o.getResources().getStringArray(R.array.cs_month_array);
        if (!TextUtils.isEmpty(this.did) && (O000000o2 = fno.O000000o().O000000o(this.did)) != null) {
            this.model = O000000o2.model;
            this.isShared = O000000o2.isShared();
            this.isReadOnly = O000000o2.isSharedReadOnly();
            this.isV4 = "chuangmi.camera.ipc009".equals(this.model) || "chuangmi.camera.ipc019".equals(this.model);
        }
        initViews();
        getData();
        chr.O000000o(chr.O00O0OO);
    }

    public void onResume() {
        super.onResume();
        chr.O0000OoO();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Window window = getWindow();
        if (configuration.orientation != 1) {
            window.clearFlags(2048);
        } else {
            window.addFlags(2048);
        }
        GeneralVideoView generalVideoView2 = this.generalVideoView;
        if (generalVideoView2 != null) {
            generalVideoView2.O000000o(configuration);
        }
        if (this.mFullScreen) {
            hideStatusBar();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.videoViewParent.getLayoutParams();
            layoutParams.height = -1;
            this.videoViewParent.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.videoViewParent.getLayoutParams();
        layoutParams2.height = -2;
        this.videoViewParent.setLayoutParams(layoutParams2);
    }

    /* access modifiers changed from: protected */
    public void hideStatusBar() {
        getWindow().clearFlags(2048);
        getWindow().clearFlags(1024);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(1024);
    }

    private void initViews() {
        this.rlTitleBar = (RelativeLayout) findViewById(R.id.rlTitleBar);
        this.videoViewParent = (ViewGroup) findViewById(R.id.videoViewParent);
        this.generalVideoView = new GeneralVideoView(this);
        this.videoViewParent.addView(this.generalVideoView);
        this.generalVideoView.O000000o(this.model, this.did);
        this.generalVideoView.setOnConfigurationChangedListener(new BasicVideoView.O000000o() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$UrqhOQ0CF3RToAeuOehYNqNAHSU */

            public final void onChangeOrientation(boolean z) {
                CloudVideoGeneralPlayerActivity.this.lambda$initViews$0$CloudVideoGeneralPlayerActivity(z);
            }
        });
        this.generalVideoView.O000000o(!this.isReadOnly ? new int[]{ckv.camera_ic_player_snapshot, ckv.camera_ic_player_download, ckv.camera_ic_player_delete} : null, new ckv.O000000o() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$rN0s7_YnmyJfyOfBln9LUKVc4 */

            public final void onActionClick(int i) {
                CloudVideoGeneralPlayerActivity.this.lambda$initViews$1$CloudVideoGeneralPlayerActivity(i);
            }
        });
        this.ivHeaderRightSetting = (ImageView) findViewById(R.id.ivHeaderRightSetting);
        this.ivHeaderRightSetting.setOnClickListener(this);
        if (this.isShared) {
            this.ivHeaderRightSetting.setVisibility(8);
        }
        this.ivHeaderLeftBack = (ImageView) findViewById(R.id.ivHeaderLeftBack);
        this.ivHeaderLeftBack.setOnClickListener(this);
        this.tvBlankHint = (TextView) findViewById(R.id.tvBlankHint);
        this.rvrlVideoList = (RecyclerViewRefreshLayoutEx) findViewById(R.id.rvrlVideoList);
        this.rvrlVideoList.setMode(3);
        this.rvrlVideoList.setOnPullRefreshListener(new RecyclerViewRefreshLayout.OnPullRefreshListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoGeneralPlayerActivity.AnonymousClass1 */

            public void onPullDistance(int i) {
            }

            public void onPullEnable(boolean z) {
            }

            public void onRefresh() {
                CloudVideoDate cloudVideoDate = (CloudVideoDate) CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.getItem(CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.selectedItemPosition);
                CloudVideoGeneralPlayerActivity.this.getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, 86399000 + cloudVideoDate.timeStamp, true, true);
            }
        });
        this.rvrlVideoList.setFooterRefreshView(LayoutInflater.from(this).inflate((int) R.layout.list_load_more, (ViewGroup) null));
        this.rvrlVideoList.setOnPushLoadMoreListener(new RecyclerViewRefreshLayout.OnPushLoadMoreListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoGeneralPlayerActivity.AnonymousClass2 */

            public void onPushDistance(int i) {
            }

            public void onPushEnable(boolean z) {
            }

            public void onLoadMore() {
                CloudVideoDate cloudVideoDate = (CloudVideoDate) CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.getItem(CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.selectedItemPosition);
                Object itemDataByPosition = CloudVideoGeneralPlayerActivity.this.playListAdapter.getItemDataByPosition(CloudVideoGeneralPlayerActivity.this.playListAdapter.getItemCount() - 1);
                if (itemDataByPosition instanceof CloudVideoChildListData) {
                    CloudVideoGeneralPlayerActivity.this.getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, ((CloudVideoChildListData) itemDataByPosition).startTime, false, true);
                }
            }
        });
        this.rvrlVideoList.setRefreshing(false);
        this.rvrlVideoList.setLoadMore(false);
        this.tvDownloadHint = (TextView) findViewById(R.id.tvDownloadHint);
        this.tvDownloadHint.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.rlTitleBar.getLayoutParams());
        layoutParams.setMargins(0, hzf.O000000o(CommonApplication.getAppContext()), 0, 0);
        this.rlTitleBar.setLayoutParams(layoutParams);
        this.rlTitleBar.bringToFront();
        this.tvTitleBarTitle = (TextView) findViewById(R.id.tvTitleBarTitle);
        this.tvTitleBarTitle.setVisibility(0);
        if (!TextUtils.isEmpty(this.title)) {
            this.tvTitleBarTitle.setText(this.title);
        }
        initDataLoadingView();
        initListView();
    }

    public /* synthetic */ void lambda$initViews$0$CloudVideoGeneralPlayerActivity(boolean z) {
        int i = z ? 0 : 8;
        this.rlTitleBar.setVisibility(i);
        this.cvlvVideos.setVisibility(i);
        this.cvdlvDays.setVisibility(i);
        ViewGroup.LayoutParams layoutParams = this.videoViewParent.getLayoutParams();
        int i2 = -1;
        layoutParams.width = -1;
        if (z) {
            i2 = -2;
        }
        layoutParams.height = i2;
        this.videoViewParent.setLayoutParams(layoutParams);
    }

    public /* synthetic */ void lambda$initViews$1$CloudVideoGeneralPlayerActivity(int i) {
        if (i == ckv.camera_ic_player_snapshot) {
            if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                gqg.O000000o((int) R.string.no_write_permission);
                return;
            }
            Intent intent = new Intent(this, LocalPicActivity.class);
            intent.putExtra("extra_device_did", this.did);
            this.generalVideoView.O000000o(intent);
        } else if (i == ckv.camera_ic_player_download) {
            downloadHint();
        } else if (i != ckv.camera_ic_player_delete) {
        } else {
            if (!TextUtils.isEmpty(this.fileId)) {
                doCheckAndDelete();
            } else {
                gqg.O00000Oo((int) R.string.cs_select_video);
            }
        }
    }

    private synchronized void initDataLoadingView() {
        this.ivDataLoading = (ImageView) findViewById(R.id.ivDataLoading);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void
     arg types: [com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoGeneralPlayerActivity, int, int, int]
     candidates:
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void */
    private void initListView() {
        this.cvlvVideos = (CloudVideoListView) findViewById(R.id.cvlvVideos);
        this.cvlvVideos.setLayoutManager(new GridLayoutManager((Context) this, 3, 1, false));
        this.playListAdapter = new PlayListAdapter();
        PlayListAdapter playListAdapter2 = this.playListAdapter;
        playListAdapter2.isDownloadEnabled = true;
        this.cvlvVideos.setAdapter(playListAdapter2);
        PlayListAdapter playListAdapter3 = this.playListAdapter;
        playListAdapter3.iItemClickListener = new PlayListAdapter.IItemClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$O1PZ8Cqbk5N6uCaJxDqQ_zAObsE */

            public final void onItemClick(View view, int i, Object obj) {
                CloudVideoGeneralPlayerActivity.this.lambda$initListView$3$CloudVideoGeneralPlayerActivity(view, i, obj);
            }
        };
        if (playListAdapter3 != null && !TextUtils.isEmpty(this.fileId)) {
            this.playListAdapter.setCurrentPlayItem(this.fileId);
            PlayListAdapter playListAdapter4 = this.playListAdapter;
            playListAdapter4.notifyItemRangeChanged(0, playListAdapter4.getItemCount(), "currentPlayPosition");
        }
        ArrayList arrayList = new ArrayList();
        long currentDayTS0 = CloudVideoUtils.getCurrentDayTS0();
        if (this.currentDateTS <= 0) {
            this.currentDateTS = currentDayTS0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 29; i >= 0; i--) {
            CloudVideoDate cloudVideoDate = new CloudVideoDate();
            long j = currentDayTS0 - (((long) i) * 86400000);
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
        this.dateListViewAdapter.selectedItemPosition = getIntent().getIntExtra("selectedItemPosition", -1);
        CloudVideoDateListViewAdapter cloudVideoDateListViewAdapter = this.dateListViewAdapter;
        cloudVideoDateListViewAdapter.iItemClickListener = new CloudVideoDateListViewAdapter.IItemClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$HbUE59rFOkbnpNtasBOn6uO6b_U */

            public final void onItemClick(View view, int i, Object obj) {
                CloudVideoGeneralPlayerActivity.this.lambda$initListView$4$CloudVideoGeneralPlayerActivity(view, i, (CloudVideoDate) obj);
            }
        };
        this.cvdlvDays.scrollToPosition(cloudVideoDateListViewAdapter.selectedItemPosition >= 0 ? this.dateListViewAdapter.selectedItemPosition : this.dateListViewAdapter.getItemCount() - 1);
    }

    public /* synthetic */ void lambda$initListView$3$CloudVideoGeneralPlayerActivity(View view, int i, Object obj) {
        CloudVideoChildListData cloudVideoChildListData;
        Object itemDataByPosition = this.playListAdapter.getItemDataByPosition(i);
        if ((itemDataByPosition instanceof CloudVideoChildListData) && (cloudVideoChildListData = (CloudVideoChildListData) itemDataByPosition) != null) {
            this.fileId = cloudVideoChildListData.fileId;
            this.startTime = cloudVideoChildListData.startTime;
            this.duration = cloudVideoChildListData.duration;
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$FfIifBwOBkFUgZdY8lCy287qtzU */

                public final void run() {
                    CloudVideoGeneralPlayerActivity.this.lambda$null$2$CloudVideoGeneralPlayerActivity();
                }
            });
        }
    }

    public /* synthetic */ void lambda$initListView$4$CloudVideoGeneralPlayerActivity(View view, int i, CloudVideoDate cloudVideoDate) {
        gsy.O00000Oo("CloudVideoGeneralPlayerActivity", "id:" + view.getId() + " position:" + i);
        if (cloudVideoDate != null) {
            this.currentDateTS = cloudVideoDate.timeStamp;
        }
        if (cloudVideoDate.isHasVideo) {
            this.tvBlankHint.setVisibility(8);
            getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, cloudVideoDate.timeStamp + 86399000, true, true);
            return;
        }
        hideVideoLoading();
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

    private void getData() {
        getVideoDatesSerial();
        lambda$null$2$CloudVideoGeneralPlayerActivity();
    }

    private void showVideoLoading(boolean z) {
        this.generalVideoView.O000000o(z);
    }

    private void showDataLoading() {
        if (this.ivDataLoading != null && !isFinishing()) {
            this.ivDataLoading.setVisibility(0);
            this.ivDataLoading.bringToFront();
            this.generalVideoView.O000000o(false);
        }
    }

    public void hideDataLoading() {
        ImageView imageView = this.ivDataLoading;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void onPause() {
        this.tvDownloadHint.setVisibility(8);
        super.onPause();
        chr.O0000Ooo();
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            exitFullScreen(null);
        } else {
            super.onBackPressed();
        }
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
        if (view.getId() == R.id.ivHeaderRightSetting) {
            CloudVideoNetUtils.getInstance().openCloudVideoManagePage(this, this.did);
        } else if (view.getId() == R.id.ivHeaderLeftBack) {
            onBackPressed();
        } else if (view.getId() == R.id.tvDownloadHint) {
            this.tvDownloadHint.setVisibility(8);
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
            Device O000000o3 = fno.O000000o().O000000o(this.did);
            if (O000000o3 != null) {
                intent2.putExtra("uid", O000000o3.userId);
                startActivity(intent2);
            }
        }
    }

    /* renamed from: getLinkAndPlay */
    public void lambda$null$2$CloudVideoGeneralPlayerActivity() {
        PlayListAdapter playListAdapter2;
        CloudVideoDateListViewAdapter cloudVideoDateListViewAdapter;
        if (!TextUtils.isEmpty(this.did) && !TextUtils.isEmpty(this.fileId)) {
            this.videoUrl = CloudVideoNetUtils.getInstance().getVideoFileUrl(this.did, this.fileId, false);
            if (TextUtils.isEmpty(this.videoUrl)) {
                gsy.O000000o(6, "CloudVideoGeneralPlayerActivity", "videoUrl is null");
                cki.O0000OOo("2000.5.2", "cloud:videoUrl is null");
                return;
            }
            CloudVideoDateListView cloudVideoDateListView = this.cvdlvDays;
            if (!(cloudVideoDateListView == null || (cloudVideoDateListViewAdapter = this.dateListViewAdapter) == null)) {
                cloudVideoDateListView.scrollToPosition(cloudVideoDateListViewAdapter.selectedItemPosition);
            }
            PlayListAdapter playListAdapter3 = this.playListAdapter;
            if (playListAdapter3 != null) {
                playListAdapter3.setCurrentPlayItem(this.fileId);
                PlayListAdapter playListAdapter4 = this.playListAdapter;
                playListAdapter4.notifyItemRangeChanged(0, playListAdapter4.getItemCount(), "currentPlayPosition");
            }
            CloudVideoListView cloudVideoListView = this.cvlvVideos;
            if (!(cloudVideoListView == null || (playListAdapter2 = this.playListAdapter) == null)) {
                cloudVideoListView.scrollToPosition(playListAdapter2.currentPlayPosition);
            }
            HashMap hashMap = new HashMap();
            MiServiceTokenInfo tokenInfo = CloudVideoNetUtils.getInstance().getTokenInfo();
            if (tokenInfo != null) {
                hashMap.put("Cookie", "yetAnotherServiceToken=" + tokenInfo.O00000o0);
                showVideoLoading(false);
                this.generalVideoView.O000000o(this.videoUrl, hashMap);
            }
        }
    }

    public void getPlayListLimit(CloudVideoDate cloudVideoDate, long j, long j2, final boolean z, boolean z2) {
        if (cloudVideoDate.isHasVideo) {
            try {
                gsy.O00000Oo("CloudVideoGeneralPlayerActivity", "getPlayListLimit:" + cloudVideoDate.year + "-" + cloudVideoDate.month + "-" + cloudVideoDate.day);
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
                    showDataLoading();
                }
                this.cvlvVideos.setEnabled(false);
                CloudVideoNetUtils.getInstance().getVideoDailyListLimitV2(getContext(), jSONObject.toString(), new ICloudVideoCallback<List<DailyList>>() {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoGeneralPlayerActivity.AnonymousClass3 */

                    public /* bridge */ /* synthetic */ void onCloudVideoSuccess(Object obj, Object obj2) {
                        onCloudVideoSuccess((List<DailyList>) ((List) obj), obj2);
                    }

                    public void onCloudVideoSuccess(List<DailyList> list, Object obj) {
                        if (!CloudVideoGeneralPlayerActivity.this.isFinishing()) {
                            CloudVideoGeneralPlayerActivity.this.cvlvVideos.setEnabled(true);
                            long localTimeZone = CloudVideoNetUtils.getInstance().toLocalTimeZone(((Long) obj).longValue());
                            long j = (CloudVideoGeneralPlayerActivity.this.currentDateTS + 86400000) - 1000;
                            CloudVideoGeneralPlayerActivity.this.rvrlVideoList.setLoadMore(false);
                            if (CloudVideoGeneralPlayerActivity.this.rvrlVideoList.isRefreshing()) {
                                CloudVideoGeneralPlayerActivity.this.rvrlVideoList.setRefreshing(false);
                            }
                            if (z) {
                                CloudVideoGeneralPlayerActivity.this.playListAdapter.clearAllData();
                            }
                            long dayTS0 = CloudVideoUtils.getDayTS0(localTimeZone);
                            long dayTS02 = CloudVideoUtils.getDayTS0(j);
                            if (dayTS0 <= 0 || dayTS0 != dayTS02) {
                                CloudVideoGeneralPlayerActivity.this.hideDataLoading();
                                CloudVideoGeneralPlayerActivity.this.isTodayHasVideo();
                            } else if (list == null || list.isEmpty()) {
                                CloudVideoGeneralPlayerActivity.this.hideDataLoading();
                                if (CloudVideoGeneralPlayerActivity.this.playListAdapter != null) {
                                    CloudVideoGeneralPlayerActivity.this.playListAdapter.notifyDataSetChanged();
                                }
                                CloudVideoGeneralPlayerActivity.this.isTodayHasVideo();
                            } else {
                                goq.O000000o(new Runnable(list, CloudVideoGeneralPlayerActivity.this.playListAdapter.getAllItemCount()) {
                                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$3$10gph2RmYxYLcKq3XNUobCJlU */
                                    private final /* synthetic */ List f$1;
                                    private final /* synthetic */ int f$2;

                                    {
                                        this.f$1 = r2;
                                        this.f$2 = r3;
                                    }

                                    public final void run() {
                                        CloudVideoGeneralPlayerActivity.AnonymousClass3.this.lambda$onCloudVideoSuccess$1$CloudVideoGeneralPlayerActivity$3(this.f$1, this.f$2);
                                    }
                                });
                            }
                        }
                    }

                    public /* synthetic */ void lambda$onCloudVideoSuccess$1$CloudVideoGeneralPlayerActivity$3(List list, int i) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            DailyList dailyList = (DailyList) it.next();
                            CloudVideoChildListData cloudVideoChildListData = new CloudVideoChildListData();
                            cloudVideoChildListData.duration = dailyList.duration;
                            cloudVideoChildListData.imgStoreId = dailyList.imgStoreId;
                            cloudVideoChildListData.isPeople = dailyList.isHuman;
                            cloudVideoChildListData.fileId = dailyList.fileId;
                            cloudVideoChildListData.imgStoreUrl = CloudVideoNetUtils.getInstance().getSnapshotUrl(CloudVideoGeneralPlayerActivity.this.did, dailyList.fileId, dailyList.imgStoreId);
                            cloudVideoChildListData.startTime = dailyList.createTime;
                            CloudVideoGeneralPlayerActivity.this.playListAdapter.append(Integer.valueOf(simpleDateFormat.format(Long.valueOf(cloudVideoChildListData.startTime))).intValue(), cloudVideoChildListData);
                        }
                        CloudVideoGeneralPlayerActivity.this.runOnUiThread(new Runnable(i) {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$3$24Vob_roV5OSEKOefhITl7c31aU */
                            private final /* synthetic */ int f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                CloudVideoGeneralPlayerActivity.AnonymousClass3.this.lambda$null$0$CloudVideoGeneralPlayerActivity$3(this.f$1);
                            }
                        });
                    }

                    public /* synthetic */ void lambda$null$0$CloudVideoGeneralPlayerActivity$3(int i) {
                        CloudVideoChildListData currentVideoData;
                        CloudVideoGeneralPlayerActivity.this.hideDataLoading();
                        CloudVideoGeneralPlayerActivity.this.isTodayHasVideo();
                        if (CloudVideoGeneralPlayerActivity.this.playListAdapter.getAllItemCount() == i) {
                            gqg.O00000Oo((int) R.string.cs_alarm_none_data);
                        }
                        if (TextUtils.isEmpty(CloudVideoGeneralPlayerActivity.this.fileId) && CloudVideoGeneralPlayerActivity.this.playListAdapter.currentPlayPosition < CloudVideoGeneralPlayerActivity.this.playListAdapter.getChildItemCount() && (currentVideoData = CloudVideoGeneralPlayerActivity.this.playListAdapter.getCurrentVideoData()) != null) {
                            CloudVideoGeneralPlayerActivity.this.fileId = currentVideoData.fileId;
                            CloudVideoGeneralPlayerActivity.this.startTime = currentVideoData.startTime;
                            CloudVideoGeneralPlayerActivity.this.duration = currentVideoData.duration;
                            CloudVideoGeneralPlayerActivity.this.lambda$null$2$CloudVideoGeneralPlayerActivity();
                        }
                        CloudVideoGeneralPlayerActivity.this.playListAdapter.setCurrentPlayItem(CloudVideoGeneralPlayerActivity.this.fileId);
                        CloudVideoGeneralPlayerActivity.this.playListAdapter.notifyDataSetChanged();
                        CloudVideoGeneralPlayerActivity.this.isTodayHasVideo();
                    }

                    public void onCloudVideoFailed(int i, String str) {
                        if (!CloudVideoGeneralPlayerActivity.this.isFinishing()) {
                            if (i == -90004) {
                                gqg.O00000Oo(CloudVideoGeneralPlayerActivity.this.getString(R.string.cs_alarm_none_data));
                            }
                            if (z && -90002 == i && CloudVideoGeneralPlayerActivity.this.playListAdapter != null) {
                                CloudVideoGeneralPlayerActivity.this.playListAdapter.clearAllData();
                            }
                            if (CloudVideoGeneralPlayerActivity.this.playListAdapter != null) {
                                CloudVideoGeneralPlayerActivity.this.playListAdapter.notifyDataSetChanged();
                            }
                            CloudVideoGeneralPlayerActivity.this.cvlvVideos.setEnabled(true);
                            CloudVideoGeneralPlayerActivity.this.rvrlVideoList.setLoadMore(false);
                            if (CloudVideoGeneralPlayerActivity.this.rvrlVideoList.isRefreshing()) {
                                CloudVideoGeneralPlayerActivity.this.rvrlVideoList.setRefreshing(false);
                            }
                            CloudVideoGeneralPlayerActivity.this.hideDataLoading();
                            CloudVideoGeneralPlayerActivity.this.isTodayHasVideo();
                            gsy.O000000o(6, "CloudVideoGeneralPlayerActivity", "errorCode:" + i + " errorInfo:" + str);
                            cki.O0000OOo("2000.5.1", "cloud:" + i + ":" + str);
                        }
                    }
                });
            } catch (JSONException unused) {
                if (!isFinishing()) {
                    hideDataLoading();
                    this.rvrlVideoList.setLoadMore(false);
                    if (this.rvrlVideoList.isRefreshing()) {
                        this.rvrlVideoList.setRefreshing(false);
                    }
                }
            }
        } else {
            if (z) {
                this.playListAdapter.listData.clear();
                this.playListAdapter.notifyDataSetChanged();
            }
            this.rvrlVideoList.setLoadMore(false);
            if (this.rvrlVideoList.isRefreshing()) {
                this.rvrlVideoList.setRefreshing(false);
            }
        }
    }

    private void getVideoDatesSerial() {
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
                        hideVideoLoading();
                        gsy.O000000o(6, "CloudVideoGeneralPlayerActivity", "exception:" + e.toString());
                        i2 = i;
                    }
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("intervals", jSONArray);
                jSONObject.put("intervals", jSONObject3);
                if (!TextUtils.isEmpty(this.did)) {
                    showVideoLoading(false);
                    this.datesUpdateVar++;
                    CloudVideoNetUtils.getInstance().getVideoDatesSerial(this, jSONObject.toString(), new ICloudVideoCallback<List<StatsRecord2>>() {
                        /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoGeneralPlayerActivity.AnonymousClass4 */

                        public /* bridge */ /* synthetic */ void onCloudVideoSuccess(Object obj, Object obj2) {
                            onCloudVideoSuccess((List<StatsRecord2>) ((List) obj), obj2);
                        }

                        public void onCloudVideoSuccess(List<StatsRecord2> list, Object obj) {
                            if (!CloudVideoGeneralPlayerActivity.this.isFinishing()) {
                                CloudVideoGeneralPlayerActivity.this.datesUpdateVar--;
                                CloudVideoGeneralPlayerActivity.this.hideVideoLoading();
                                for (StatsRecord2 next : list) {
                                    for (CloudVideoDate next2 : CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.cloudVideoDates) {
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
                                CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.notifyDataSetChanged();
                                if (CloudVideoGeneralPlayerActivity.this.datesUpdateVar == 0 && CloudVideoGeneralPlayerActivity.this.dateListViewAdapter != null && CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.getItemCount() > 0) {
                                    CloudVideoDate cloudVideoDate = (CloudVideoDate) CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.getItem(CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.selectedItemPosition >= 0 ? CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.selectedItemPosition : CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.getItemCount() - 1);
                                    CloudVideoGeneralPlayerActivity.this.getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, cloudVideoDate.timeStamp + 86399000, true, true);
                                }
                            }
                        }

                        public void onCloudVideoFailed(int i, String str) {
                            if (!CloudVideoGeneralPlayerActivity.this.isFinishing()) {
                                CloudVideoGeneralPlayerActivity cloudVideoGeneralPlayerActivity = CloudVideoGeneralPlayerActivity.this;
                                cloudVideoGeneralPlayerActivity.datesUpdateVar--;
                                if (CloudVideoGeneralPlayerActivity.this.datesUpdateVar == 0 && CloudVideoGeneralPlayerActivity.this.dateListViewAdapter != null && CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.getItemCount() > 0) {
                                    CloudVideoDate cloudVideoDate = (CloudVideoDate) CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.getItem(CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.selectedItemPosition >= 0 ? CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.selectedItemPosition : CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.getItemCount() - 1);
                                    CloudVideoGeneralPlayerActivity.this.getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, 86399000 + cloudVideoDate.timeStamp, true, true);
                                }
                                CloudVideoGeneralPlayerActivity.this.hideVideoLoading();
                                CloudVideoGeneralPlayerActivity.this.isTodayHasVideo();
                                gsy.O000000o(6, "CloudVideoGeneralPlayerActivity", "errorCode:" + i + ":" + str);
                            }
                        }
                    });
                } else {
                    gqg.O00000Oo((int) R.string.cs_device_info_fail);
                }
            } catch (JSONException e2) {
                e = e2;
                i = i2;
                hideVideoLoading();
                gsy.O000000o(6, "CloudVideoGeneralPlayerActivity", "exception:" + e.toString());
                i2 = i;
            }
            i2 = i;
        }
    }

    public void isTodayHasVideo() {
        PlayListAdapter playListAdapter2 = this.playListAdapter;
        if (playListAdapter2 == null || playListAdapter2.listData == null || !this.playListAdapter.isContainVideoData()) {
            this.tvBlankHint.setVisibility(0);
        } else {
            this.tvBlankHint.setVisibility(8);
        }
    }

    private void doCheckAndDelete() {
        cjm.O000000o(this.model, "plg.4gw.zv6.o3c");
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.cs_delete_video)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$tmU_6Yybvb9CaxFZeVOyhWx2Hc */

            public final void onClick(DialogInterface dialogInterface, int i) {
                CloudVideoGeneralPlayerActivity.this.lambda$doCheckAndDelete$5$CloudVideoGeneralPlayerActivity(dialogInterface, i);
            }
        }).O000000o($$Lambda$CloudVideoGeneralPlayerActivity$hl3l0S7KOJBPCbbjHGKJ2eYmG1o.INSTANCE).O00000Oo((int) R.string.camera_cancel, $$Lambda$CloudVideoGeneralPlayerActivity$SAf5AAgCPBsZGfmeapahDTMiRB0.INSTANCE).O00000oo();
    }

    public /* synthetic */ void lambda$doCheckAndDelete$5$CloudVideoGeneralPlayerActivity(DialogInterface dialogInterface, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.did);
            jSONObject.put("model", this.model);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.fileId);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fileIds", jSONArray);
            jSONObject.put("fileIds", jSONObject2);
            showDataLoading();
            CloudVideoNetUtils.getInstance().deleteFiles(getContext(), jSONObject.toString(), new ICloudVideoCallback<String>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoGeneralPlayerActivity.AnonymousClass5 */

                public void onCloudVideoSuccess(String str, Object obj) {
                    if (!CloudVideoGeneralPlayerActivity.this.isFinishing()) {
                        CloudVideoGeneralPlayerActivity cloudVideoGeneralPlayerActivity = CloudVideoGeneralPlayerActivity.this;
                        cloudVideoGeneralPlayerActivity.fileId = null;
                        cloudVideoGeneralPlayerActivity.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$5$WIOohRSkzbDQZszdbf4vNgRijo */

                            public final void run() {
                                CloudVideoGeneralPlayerActivity.AnonymousClass5.this.lambda$onCloudVideoSuccess$0$CloudVideoGeneralPlayerActivity$5();
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onCloudVideoSuccess$0$CloudVideoGeneralPlayerActivity$5() {
                    CloudVideoGeneralPlayerActivity.this.hideDataLoading();
                    CloudVideoGeneralPlayerActivity.this.generalVideoView.O0000Ooo();
                    CloudVideoDate cloudVideoDate = (CloudVideoDate) CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.getItem(CloudVideoGeneralPlayerActivity.this.dateListViewAdapter.selectedItemPosition);
                    CloudVideoGeneralPlayerActivity.this.getPlayListLimit(cloudVideoDate, cloudVideoDate.timeStamp, 86399000 + cloudVideoDate.timeStamp, true, true);
                    CloudVideoGeneralPlayerActivity.this.setResult(-1);
                }

                public void onCloudVideoFailed(int i, String str) {
                    if (!CloudVideoGeneralPlayerActivity.this.isFinishing()) {
                        CloudVideoGeneralPlayerActivity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$5$pCLmt6qanIPkwRBMLnW2Q9BvrF4 */

                            public final void run() {
                                CloudVideoGeneralPlayerActivity.AnonymousClass5.this.lambda$onCloudVideoFailed$1$CloudVideoGeneralPlayerActivity$5();
                            }
                        });
                        gsy.O000000o(6, "CloudVideoGeneralPlayerActivity", "errorCode:" + i + " errorInfo:" + str);
                    }
                }

                public /* synthetic */ void lambda$onCloudVideoFailed$1$CloudVideoGeneralPlayerActivity$5() {
                    CloudVideoGeneralPlayerActivity.this.hideDataLoading();
                }
            });
        } catch (JSONException unused) {
            hideDataLoading();
        }
    }

    private void doDownload() {
        if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
            return;
        }
        chr.O000000o(chr.O000oooO);
        cjm.O000000o(this.model, "plg.4gw.zv6.m1p");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Device O000000o2 = fno.O000000o().O000000o(this.did);
        if (O000000o2 != null) {
            ArrayList arrayList = new ArrayList();
            CloudVideoDownloadInfo cloudVideoDownloadInfo = new CloudVideoDownloadInfo();
            cloudVideoDownloadInfo.uid = O000000o2.userId;
            cloudVideoDownloadInfo.did = this.did;
            cloudVideoDownloadInfo.title = this.title;
            cloudVideoDownloadInfo.videoUrl = CloudVideoNetUtils.getInstance().getVideoFileUrl(this.did, this.fileId, false);
            cloudVideoDownloadInfo.fileId = this.fileId;
            cloudVideoDownloadInfo.mp4FilePath = null;
            cloudVideoDownloadInfo.m3u8FilePath = null;
            cloudVideoDownloadInfo.status = 4;
            cloudVideoDownloadInfo.createTime = System.currentTimeMillis();
            long j = this.startTime;
            cloudVideoDownloadInfo.startTime = j;
            long j2 = this.duration;
            cloudVideoDownloadInfo.endTime = j + j2;
            cloudVideoDownloadInfo.duration = j2;
            cloudVideoDownloadInfo.createTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.createTime));
            cloudVideoDownloadInfo.startTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.startTime));
            cloudVideoDownloadInfo.endTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.endTime));
            cloudVideoDownloadInfo.size = 0;
            cloudVideoDownloadInfo.progress = 0;
            arrayList.add(cloudVideoDownloadInfo);
            if (arrayList.size() != 1 || !CloudVideoDownloadManager.getInstance(this.model).isExistsVideo(this.model, (CloudVideoDownloadInfo) arrayList.get(0))) {
                showDownloadActivityHint();
                CloudVideoDownloadManager.getInstance(this.model).insertRecords(arrayList);
                CloudVideoDownloadManager.getInstance(this.model).pullDownloadFromList(getContext(), O000000o2.userId, this.did);
                return;
            }
            gqg.O00000Oo((int) R.string.cloud_mp4_download_exists);
        }
    }

    private void showDownloadActivityHint() {
        this.tvDownloadHint.setVisibility(0);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$BUhw3cyGjZ1oAkemSg5flIWWk18 */

            public final void run() {
                CloudVideoGeneralPlayerActivity.this.lambda$showDownloadActivityHint$8$CloudVideoGeneralPlayerActivity();
            }
        }, 5000);
    }

    public /* synthetic */ void lambda$showDownloadActivityHint$8$CloudVideoGeneralPlayerActivity() {
        TextView textView = this.tvDownloadHint;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void downloadHint() {
        if (CloudVideoNetUtils.getInstance().isWifiConnected(this)) {
            doDownload();
        } else {
            new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.cs_non_wifi_environment)).O000000o((int) R.string.cs_go_on, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoGeneralPlayerActivity$T7QB1s7SA3P79LjPEd59h_d3Iw */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    CloudVideoGeneralPlayerActivity.this.lambda$downloadHint$9$CloudVideoGeneralPlayerActivity(dialogInterface, i);
                }
            }).O000000o($$Lambda$CloudVideoGeneralPlayerActivity$brXlhRVb49TIV56kAplHj1To24.INSTANCE).O00000Oo((int) R.string.cs_cancel, $$Lambda$CloudVideoGeneralPlayerActivity$oGXMkQ9NLwysMtoUkkcTC7TiJGk.INSTANCE).O00000oo();
        }
    }

    public /* synthetic */ void lambda$downloadHint$9$CloudVideoGeneralPlayerActivity(DialogInterface dialogInterface, int i) {
        doDownload();
    }
}
