package com.xiaomi.smarthome.camera.activity.local;

import _m_j.chp;
import _m_j.chr;
import _m_j.chw;
import _m_j.cia;
import _m_j.cin;
import _m_j.cki;
import _m_j.clj;
import _m_j.go;
import _m_j.gqg;
import _m_j.izb;
import _m_j.me;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IStreamCmdMessageListener;
import com.xiaomi.smarthome.camera.activity.BaseSelectActivity;
import com.xiaomi.smarthome.camera.activity.CommandTreatment;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import com.xiaomi.smarthome.camera.activity.timelapse.TimeLapseTaskManager;
import com.xiaomi.smarthome.camera.activity.timelapse.Timelapse;
import com.xiaomi.smarthome.camera.activity.timelapse.TimelapseTask;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerClickListener;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

public class AlbumActivity extends BaseSelectActivity implements cia, IStreamCmdMessageListener, RecyclerClickListener {
    ArrayList<TimelapseTask> batcheDelTLArray;
    int batcheDelTNum = 0;
    public CloudVideoDownloadManager cloudDownloadManager = null;
    private CloudVideoDownloadManager.ICloudVideoDownloadListener cloudVideoDownloadListener = new CloudVideoDownloadManager.ICloudVideoDownloadListener() {
        /* class com.xiaomi.smarthome.camera.activity.local.AlbumActivity.AnonymousClass1 */

        public void onM3U8ToMp4Finish(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        }

        public void onStart(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            cki.O00000o("AlbumActivity", "onStart");
            AlbumActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$AlbumActivity$1$4M176Y_Jj8tPWA5s15Rq42Ojw */
                private final /* synthetic */ CloudVideoDownloadInfo f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AlbumActivity.AnonymousClass1.this.lambda$onStart$0$AlbumActivity$1(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onStart$0$AlbumActivity$1(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            AlbumActivity.this.mAdapter.updateDownloadingItem(cloudVideoDownloadInfo);
        }

        public void onStop(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
            cki.O00000o("AlbumActivity", "onStop");
            cloudVideoDownloadInfo.status = 4;
            AlbumActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$AlbumActivity$1$3AsU2DpPFIS7HzU7tkUFBZh_FsQ */
                private final /* synthetic */ CloudVideoDownloadInfo f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AlbumActivity.AnonymousClass1.this.lambda$onStop$1$AlbumActivity$1(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onStop$1$AlbumActivity$1(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            AlbumActivity.this.mAdapter.updateDownloadingItem(cloudVideoDownloadInfo);
        }

        public void onFinish(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            cki.O00000o("AlbumActivity", "onFinish");
            cloudVideoDownloadInfo.status = 0;
            AlbumActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$AlbumActivity$1$Qay0luSpBi8yvZbe2bmnUThBx4 */
                private final /* synthetic */ CloudVideoDownloadInfo f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AlbumActivity.AnonymousClass1.this.lambda$onFinish$2$AlbumActivity$1(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onFinish$2$AlbumActivity$1(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            if (!TextUtils.isEmpty(cloudVideoDownloadInfo.mp4FilePath)) {
                AlbumActivity.this.insertToAlbum(cloudVideoDownloadInfo.mp4FilePath);
            }
            AlbumActivity.this.loadData();
            AlbumActivity.this.mAdapter.notifyDataSetChanged();
        }

        public void onCancelled(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            cki.O00000o("AlbumActivity", "onCancelled");
            cloudVideoDownloadInfo.status = 8;
            AlbumActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$AlbumActivity$1$PlPFM8zxDG_FOGywKwO7wwwKmR8 */
                private final /* synthetic */ CloudVideoDownloadInfo f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AlbumActivity.AnonymousClass1.this.lambda$onCancelled$3$AlbumActivity$1(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onCancelled$3$AlbumActivity$1(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            AlbumActivity.this.mAdapter.updateDownloadingItem(cloudVideoDownloadInfo);
        }

        public void onInfo(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
            cki.O00000o("AlbumActivity", "onInfo");
            AlbumActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$AlbumActivity$1$jjGXVKbjqAksZblsjCMUfrBiHng */
                private final /* synthetic */ CloudVideoDownloadInfo f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AlbumActivity.AnonymousClass1.this.lambda$onInfo$4$AlbumActivity$1(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onInfo$4$AlbumActivity$1(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            AlbumActivity.this.mAdapter.updateDownloadingItem(cloudVideoDownloadInfo);
        }

        public void onError(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
            cki.O00000o("AlbumActivity", "onError");
            cloudVideoDownloadInfo.status = 2;
            AlbumActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$AlbumActivity$1$oxBBrCLOdsfzfJJ8o3nWF1dTaJY */
                private final /* synthetic */ CloudVideoDownloadInfo f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AlbumActivity.AnonymousClass1.this.lambda$onError$5$AlbumActivity$1(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onError$5$AlbumActivity$1(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            AlbumActivity.this.mAdapter.updateDownloadingItem(cloudVideoDownloadInfo);
        }

        public void onProgress(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
            cki.O00000o("AlbumActivity", "onProgress");
            cloudVideoDownloadInfo.progress = i;
            cloudVideoDownloadInfo.status = 1;
            AlbumActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$AlbumActivity$1$weUS6hy1L26zDqcxFhnDvPvH2mw */
                private final /* synthetic */ CloudVideoDownloadInfo f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AlbumActivity.AnonymousClass1.this.lambda$onProgress$6$AlbumActivity$1(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onProgress$6$AlbumActivity$1(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            AlbumActivity.this.mAdapter.updateDownloadingItem(cloudVideoDownloadInfo);
        }

        public void onSpeed(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
            cki.O00000o("AlbumActivity", "onSpeed");
        }
    };
    public String did;
    private List<CloudVideoDownloadInfo> downloadInfos = new ArrayList();
    public AlbumAdapter mAdapter;
    private chw mCameraPlayer;
    public LinearLayout mEmptyLayout;
    public RecyclerView mListView;
    public LinearLayout mLoadLayout;
    clj mLocalFileManager;
    SimpleDateFormat mSimpleDateFormat1;
    private TimeLapseTaskManager mTImeLapseTaskManager;
    private List<LocalFileData> picData = new ArrayList();
    ArrayList<TimelapseTask> preDelTLArray;
    private List<LocalFileData> selecttimelapseList = new ArrayList();
    private ArrayList<LocalFileData> timeLapseData = new ArrayList<>();
    public String uid;

    public void onDisConnected() {
    }

    public void onDisconnectedWithCode(int i) {
    }

    public void onPauseCamera() {
    }

    public void onPrepare(int i) {
    }

    public void onRetry(int i, String str, int i2) {
    }

    public void onVideoInfo(int i, int i2, int i3, int i4, int i5) {
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_album);
        chr.O000000o(chr.O000ooOO);
        this.cloudDownloadManager = CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel());
        this.uid = this.mDeviceStat.userId;
        this.did = this.mDeviceStat.did;
        if (DeviceConstant.isSupportCloudMp4Download(this.mCameraDevice.getModel())) {
            this.cloudDownloadManager.resetStatusByMp4(this.uid, this.did);
            this.downloadInfos = this.cloudDownloadManager.getRecords(this.mDeviceStat.userId, this.mDeviceStat.did);
        }
        this.mLocalFileManager = this.mCameraDevice.O0000O0o();
        this.mSimpleDateFormat1 = new SimpleDateFormat("mm:ss");
        this.mSimpleDateFormat1.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        initView();
        if (this.mCameraDevice.O0000oOO()) {
            this.mTImeLapseTaskManager = new TimeLapseTaskManager(this.mCameraDevice, this);
        }
        checkPermissionAndDownloadCloudMP4();
    }

    public void onResume() {
        super.onResume();
        if (this.mCameraDevice != null && this.mCameraDevice.O0000oOO()) {
            if (this.mCameraPlayer == null) {
                synchronized (this) {
                    if (this.mCameraPlayer == null) {
                        this.mCameraPlayer = new chw(this.mCameraDevice, this);
                    }
                }
            }
            if (Timelapse.timeLapseList != null) {
                Timelapse.timeLapseList.clear();
            }
            cki.O00000o("AlbumActivity", "连接摄像头成功,");
            this.mCameraPlayer.O0000Oo();
            this.mCameraPlayer.O0000Oo0();
        }
        this.cloudDownloadManager.addListener(this.cloudVideoDownloadListener);
        loadData();
    }

    private void checkPermissionAndDownloadCloudMP4() {
        if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, new Callback<List<String>>() {
            /* class com.xiaomi.smarthome.camera.activity.local.AlbumActivity.AnonymousClass2 */

            public void onFailure(int i, String str) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<String>) ((List) obj));
            }

            public void onSuccess(List<String> list) {
                if (!AlbumActivity.this.isFinishing()) {
                    StringBuilder sb = new StringBuilder("checkPermissionAndDownloadCloudMP4:");
                    sb.append(AlbumActivity.this.mDeviceStat != null ? AlbumActivity.this.mDeviceStat.model : "");
                    cki.O00000o0("AlbumActivity", sb.toString());
                    if (AlbumActivity.this.mDeviceStat != null && !TextUtils.isEmpty(AlbumActivity.this.mDeviceStat.model) && DeviceConstant.isSupportCloudMp4Download(AlbumActivity.this.mDeviceStat.model)) {
                        AlbumActivity.this.cloudDownloadManager.pullDownloadFromList(AlbumActivity.this.getContext().getApplicationContext(), AlbumActivity.this.uid, AlbumActivity.this.did);
                    }
                }
            }
        }, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
        }
    }

    public void onPause() {
        super.onPause();
        this.cloudDownloadManager.removeListener(this.cloudVideoDownloadListener);
        if (this.mCameraPlayer != null && this.mCameraDevice != null && this.mCameraDevice.O0000oOO()) {
            this.mCameraPlayer.O0000O0o();
            this.mCameraPlayer = null;
        }
    }

    private void initView() {
        initSelectView();
        this.mEmptyLayout = (LinearLayout) findViewById(R.id.empty_layout);
        this.mLoadLayout = (LinearLayout) findViewById(R.id.loading_layout);
        this.mListView = (RecyclerView) findViewById(R.id.list_view);
        findViewById(R.id.select_delete).setOnClickListener(this);
        this.mAdapter = new AlbumAdapter(this, this, this.isV4);
        try {
            ((go) Objects.requireNonNull(this.mListView.getItemAnimator())).O0000o00 = false;
        } catch (Exception e) {
            cki.O00000oO("AlbumActivity", e.toString());
        }
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setLayoutManager(new GridLayoutManager(this, 3));
        this.mListView.addItemDecoration(new AlbumDecoration());
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.album);
        ((AnimationDrawable) ((ImageView) findViewById(R.id.loading_img)).getDrawable()).start();
    }

    public void loadData() {
        this.mLocalFileManager.O00000o0(new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.local.AlbumActivity.AnonymousClass3 */

            public void onSuccess(Void voidR) {
                if (!AlbumActivity.this.isFinishing()) {
                    AlbumActivity.this.mLoadLayout.setVisibility(8);
                    AlbumActivity albumActivity = AlbumActivity.this;
                    albumActivity.setData(albumActivity.mLocalFileManager.O0000O0o);
                    AlbumActivity.this.handleTimeLapseData();
                    try {
                        if (AlbumActivity.this.mIsMultiSelectMode) {
                            AlbumActivity.this.mAdapter.unSelectAll();
                        }
                        AlbumActivity.this.refreshSelectTitle();
                    } catch (Exception e) {
                        cki.O00000oO("AlbumActivity", e.getLocalizedMessage());
                    }
                }
            }

            public void onFailure(int i, String str) {
                if (!AlbumActivity.this.isFinishing()) {
                    AlbumActivity.this.mEmptyLayout.setVisibility(0);
                    AlbumActivity.this.mListView.setVisibility(8);
                    AlbumActivity.this.mLoadLayout.setVisibility(8);
                }
            }
        });
    }

    public void handleTimeLapseData() {
        if (!this.mCameraDevice.O0000oOO()) {
            refreshData();
            return;
        }
        loadTimeLapseData();
        refreshData();
    }

    /* access modifiers changed from: package-private */
    public void setData(List<clj.O000000o> list) {
        this.picData = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            clj.O000000o o000000o = list.get(size);
            LocalFileData localFileData = new LocalFileData();
            localFileData.item = o000000o;
            localFileData.videoType = 0;
            localFileData.title = this.mSimpleDateFormat1.format(Long.valueOf(o000000o.O00000Oo));
            this.picData.add(localFileData);
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshData() {
        cki.O00000o("AlbumActivity", "setData timeLapseData===" + this.timeLapseData.size());
        ArrayList arrayList = new ArrayList();
        if (DeviceConstant.isSupportCloudMp4Download(this.mCameraDevice.getModel())) {
            this.downloadInfos = this.cloudDownloadManager.getRecords(this.mDeviceStat.userId, this.mDeviceStat.did);
            List<CloudVideoDownloadInfo> list = this.downloadInfos;
            if (list != null && !list.isEmpty()) {
                arrayList.addAll(this.downloadInfos);
            }
        }
        arrayList.addAll(this.picData);
        arrayList.addAll(this.timeLapseData);
        if (arrayList.isEmpty()) {
            this.mEmptyLayout.setVisibility(0);
            this.mListView.setVisibility(8);
            this.mEditBtn.setVisibility(8);
        } else {
            this.mEmptyLayout.setVisibility(8);
            this.mListView.setVisibility(0);
            this.mAdapter.setData(arrayList);
            this.mEditBtn.setVisibility(0);
        }
        cki.O00000o("AlbumActivity", "相册中总长度=" + arrayList.size());
        this.mAdapter.notifyDataSetChanged();
    }

    public int getSelectCount() {
        return this.mAdapter.getSelectCount();
    }

    public int getDataCount() {
        return this.mAdapter.getItemCount();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.title_bar_more) {
            setMultiSelectMode(true);
        } else if (id == R.id.ivSelectAll) {
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
        } else if (id == R.id.ivSelectAllCancel) {
            setMultiSelectMode(false);
        } else if (id == R.id.select_delete) {
            delete();
        }
    }

    public void setMultiSelectMode(boolean z) {
        super.setMultiSelectMode(z);
        this.mAdapter.setSelectMode(z);
    }

    public void onBackPressed() {
        if (this.mIsMultiSelectMode) {
            setMultiSelectMode(false);
        } else {
            super.onBackPressed();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        AlbumAdapter albumAdapter = this.mAdapter;
        if (albumAdapter != null) {
            albumAdapter.destroyDisplayImageOptions();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r0 != 8) goto L_0x009a;
     */
    public void onRecyclerClick(View view) {
        int childLayoutPosition = this.mListView.getChildLayoutPosition(view);
        if (this.mIsMultiSelectMode) {
            this.mAdapter.selectToggle(childLayoutPosition);
            refreshSelectTitle();
            this.mAdapter.notifyItemChanged(childLayoutPosition);
            return;
        }
        LocalFileData item = this.mAdapter.getItem(childLayoutPosition);
        if (item != null) {
            if (item instanceof CloudVideoDownloadInfo) {
                CloudVideoDownloadInfo cloudVideoDownloadInfo = (CloudVideoDownloadInfo) item;
                int i = cloudVideoDownloadInfo.status;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 4) {
                            }
                        }
                        if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                            gqg.O000000o((int) R.string.no_write_permission);
                            return;
                        }
                        cloudVideoDownloadInfo.status = 4;
                        this.cloudDownloadManager.updateRecord(cloudVideoDownloadInfo);
                        this.cloudDownloadManager.pullDownloadFromList(getApplicationContext(), this.uid, this.did);
                    }
                    if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        gqg.O000000o((int) R.string.no_write_permission);
                        return;
                    }
                    this.cloudDownloadManager.cancelCurrentDownload(cloudVideoDownloadInfo.did, cloudVideoDownloadInfo.fileId);
                    this.cloudDownloadManager.cancelConvertTask();
                    cloudVideoDownloadInfo.status = 8;
                    this.cloudDownloadManager.updateRecord(cloudVideoDownloadInfo);
                    this.cloudDownloadManager.pullDownloadFromList(getApplicationContext(), this.uid, this.did);
                }
                this.mAdapter.notifyDataSetChanged();
                return;
            }
            Intent intent = new Intent();
            cki.O00000o("AlbumActivity", "onRecyclerClick localFileData.videoType=" + item.videoType);
            if (item.videoType == 3) {
                if (item.videoFile != null) {
                    intent.putExtra("file_path", item.videoFile.getAbsolutePath());
                    cki.O00000o("AlbumActivity", "onRecyclerClick localFileData.file_path=" + item.videoFile.getAbsolutePath());
                }
                intent.putExtra("file_realtime", item.realStartTimeInSec);
                intent.putExtra("video_path", item.videoPath);
                intent.putExtra("file_time", item.startTimeInSec);
                intent.setClass(this, TimelapsePhotographPlayActivity.class);
                startActivity(intent);
                return;
            }
            cki.O00000o("AlbumActivity", "onRecyclerClick localFileData.item.path=" + item.item.O00000o);
            intent.putExtra("file_path", item.item.O00000o);
            intent.setClass(this, LocalPicActivity.class);
            startActivity(intent);
        }
    }

    public void onRecyclerLongClick(View view) {
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

    private void delete() {
        ArrayList<LocalFileData> selectItems = this.mAdapter.getSelectItems();
        if (selectItems.isEmpty()) {
            izb.O000000o(this, (int) R.string.bottom_action_tip, 0).show();
            return;
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O00000Oo((int) R.string.delete_alert);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(selectItems) {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$AlbumActivity$zfjgtvwhiTtwUzfnUP4QltPqqjg */
            private final /* synthetic */ ArrayList f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlbumActivity.this.lambda$delete$0$AlbumActivity(this.f$1, dialogInterface, i);
            }
        });
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O00000oo();
    }

    public /* synthetic */ void lambda$delete$0$AlbumActivity(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        this.selecttimelapseList = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LocalFileData localFileData = (LocalFileData) it.next();
            cki.O00000o("AlbumActivity", "data=" + localFileData.videoType);
            cki.O00000o("AlbumActivity", "data=" + localFileData.videoPath);
            cki.O00000o("AlbumActivity", "data=" + localFileData.startTimeInSec);
            cki.O00000o("AlbumActivity", "data=" + localFileData.imgPath);
            if (localFileData instanceof CloudVideoDownloadInfo) {
                arrayList3.add((CloudVideoDownloadInfo) localFileData);
            } else if (localFileData.videoType == 3) {
                this.selecttimelapseList.add(localFileData);
            } else {
                arrayList2.add(localFileData.item);
            }
        }
        this.cloudDownloadManager.deleteRecords(arrayList3);
        setMultiSelectMode(false);
        deleteTimeLapse(this.selecttimelapseList);
        clj clj = this.mLocalFileManager;
        AnonymousClass4 r9 = new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.local.AlbumActivity.AnonymousClass4 */

            public void onSuccess(Void voidR) {
                if (!AlbumActivity.this.isFinishing()) {
                    AlbumActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$AlbumActivity$4$zneAwHnJgasTKhQUzpv1SB9B1SE */

                        public final void run() {
                            AlbumActivity.AnonymousClass4.this.lambda$onSuccess$0$AlbumActivity$4();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$AlbumActivity$4() {
                AlbumActivity albumActivity = AlbumActivity.this;
                albumActivity.setData(albumActivity.mLocalFileManager.O0000O0o);
                AlbumActivity.this.refreshData();
            }

            public void onFailure(int i, String str) {
                if (!AlbumActivity.this.isFinishing()) {
                    AlbumActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$AlbumActivity$4$Y_kJrBqv430ywFuNhvfZDeX0M */

                        public final void run() {
                            AlbumActivity.AnonymousClass4.this.lambda$onFailure$1$AlbumActivity$4();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$1$AlbumActivity$4() {
                AlbumActivity albumActivity = AlbumActivity.this;
                albumActivity.setData(albumActivity.mLocalFileManager.O0000O0o);
                AlbumActivity.this.refreshData();
            }
        };
        if (arrayList2.isEmpty()) {
            r9.onSuccess((Object) null);
            return;
        }
        clj.O0000O0o.removeAll(arrayList2);
        new Thread(new Runnable(arrayList2, r9) {
            /* class _m_j.clj.AnonymousClass3 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ List f14069O000000o;
            final /* synthetic */ Callback O00000Oo;

            {
                this.f14069O000000o = r2;
                this.O00000Oo = r3;
            }

            public final void run() {
                for (O000000o o000000o : this.f14069O000000o) {
                    o000000o.O00000o0.delete();
                }
                this.O00000Oo.onSuccess(null);
            }
        }).start();
    }

    private void loadTimeLapseData() {
        cki.O00000o("AlbumActivity", "----------------loadTimeLapseData------------------");
        this.timeLapseData = new ArrayList<>();
        try {
            refreshSDCardFolder(this, me.O00000o(this.mCameraDevice.getDid()));
            Timelapse.getSavedTimeLapseData(this.mCameraDevice);
            if (this.mTImeLapseTaskManager != null) {
                cki.O00000o("AlbumActivity", "发送了获取延时摄影列表的命令");
                this.mTImeLapseTaskManager.getTimelapseList(this);
            }
        } catch (Exception e) {
            cki.O00000o("AlbumActivity", "Exception: " + e.getMessage());
        }
        if (Timelapse.timeLapseList == null || Timelapse.timeLapseList.size() <= 0) {
            cki.O00000o("AlbumActivity", "Timelapse list length: 0");
            return;
        }
        cki.O00000o("AlbumActivity", "Timelapse list length: " + Timelapse.timeLapseList.size());
        Iterator<TimelapseTask> it = Timelapse.timeLapseList.iterator();
        while (it.hasNext()) {
            addTimelapseData(this, this.timeLapseData, it.next());
        }
        cki.O00000o("AlbumActivity", "延时摄像的长度=" + this.timeLapseData.size());
    }

    public void refreshSDCardFolder(Context context, String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    Uri parse = Uri.parse("file://" + file2.getAbsolutePath());
                    cki.O00000o("AlbumActivity", "loadTimeLapseData ----------- f.getAbsolutePath()=" + file2.getAbsolutePath());
                    sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", parse));
                } else {
                    refreshSDCardFolder(context, file2.getAbsolutePath());
                }
            }
        }
    }

    public ArrayList<LocalFileData> addTimelapseData(Context context, ArrayList<LocalFileData> arrayList, TimelapseTask timelapseTask) {
        if (!(timelapseTask == null || arrayList == null)) {
            int hasItem = hasItem(arrayList, timelapseTask);
            if (hasItem >= 0) {
                arrayList.get(hasItem).copyTimeLapse(timelapseTask, this.mCameraDevice);
            } else {
                LocalFileData localFileData = new LocalFileData(timelapseTask, this.mCameraDevice);
                localFileData.imgPath = timelapseTask.getLatestPicPath();
                LocalFileData.timelapseSaveType = timelapseTask.getTimelapseSaveType();
                cki.O00000o("AlbumActivity", "tem.recordStatus=" + localFileData.recordStatus);
                arrayList.add(localFileData);
            }
        }
        return arrayList;
    }

    private int hasItem(ArrayList<LocalFileData> arrayList, TimelapseTask timelapseTask) {
        for (int i = 0; i < arrayList.size(); i++) {
            LocalFileData localFileData = arrayList.get(i);
            if (localFileData.getStartTimeInSec() == timelapseTask.getStartTimestampInUTCSeconds() && localFileData.getVideoType() == 3) {
                return i;
            }
        }
        return -1;
    }

    private void deleteTimeLapse(List<LocalFileData> list) {
        this.preDelTLArray = new ArrayList<>();
        this.preDelTLArray.clear();
        for (LocalFileData next : list) {
            cki.O00000o("AlbumActivity", " 删除Timelapse：" + next.getStartTimeInSec());
            cki.O00000o("AlbumActivity", " 删除Timelapse：" + next.videoPath);
            this.preDelTLArray.add(new TimelapseTask(3, (int) (next.getStartTimeInSec() + ((long) cin.O00000o())), next.getStartTimeInSec()));
        }
        if (this.preDelTLArray.size() > 0) {
            cki.O00000oo("AlbumActivity", "=====================================0");
            if (this.mTImeLapseTaskManager != null) {
                cki.O00000o("AlbumActivity", "发送了删除延时摄影的命令 preDelTLArray.size==" + this.preDelTLArray.size());
                this.mTImeLapseTaskManager.deleteRecord(this.preDelTLArray, this);
            }
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i != 21006) {
            if (i == 21007) {
                cki.O00000o("AlbumActivity", "相册中的数据删除成功 msg.arg1=" + message.arg1);
                cki.O00000o("AlbumActivity", "相册中的删除数据后的长度=" + this.mAdapter.getItemCount());
                if (message.arg1 == 1) {
                    cki.O00000o("AlbumActivity", "相册中的数据删除成功前 timeLapseData===" + this.timeLapseData.size());
                    cki.O00000o("AlbumActivity", "相册中的数据删除成功前 preDelTLArray===" + this.selecttimelapseList.size());
                    cki.O00000o("AlbumActivity", "相册中的数据删除成功preDelTLArray.size=" + this.preDelTLArray.size());
                    if (this.preDelTLArray.size() > 3) {
                        deteBatcheTimeLapse();
                        cki.O00000o("AlbumActivity", "相册中的数据删除成功batcheDelTNum=" + this.batcheDelTNum);
                        if (this.batcheDelTNum == 0) {
                            boolean removeAll = this.timeLapseData.removeAll(this.selecttimelapseList);
                            cki.O00000o("AlbumActivity", "相册中的数据删除成功后 timeLapseData===" + this.timeLapseData.size());
                            cki.O00000o("AlbumActivity", "相册中的数据删除成功后 result===".concat(String.valueOf(removeAll)));
                            deleteLocalTimeLapse(this.preDelTLArray);
                            setData(this.mLocalFileManager.O0000O0o);
                        }
                    } else {
                        boolean removeAll2 = this.timeLapseData.removeAll(this.selecttimelapseList);
                        cki.O00000o("AlbumActivity", "相册中的数据删除成功后 timeLapseData===" + this.timeLapseData.size());
                        cki.O00000o("AlbumActivity", "相册中的数据删除成功后 result===".concat(String.valueOf(removeAll2)));
                        deleteLocalTimeLapse(this.preDelTLArray);
                        setData(this.mLocalFileManager.O0000O0o);
                    }
                    refreshData();
                    return;
                }
                cki.O00000o("AlbumActivity", "延时摄影删除失败");
                this.batcheDelTNum = 0;
                activity();
                gqg.O000000o(getString(R.string.delete_timelapse_failed));
            }
        } else if (message.obj != null) {
            cki.O00000o("AlbumActivity", "======SD timeLapseTask size ==========" + ((ArrayList) message.obj).size());
            Iterator it = ((ArrayList) message.obj).iterator();
            while (it.hasNext()) {
                TimelapseTask timelapseTask = (TimelapseTask) it.next();
                cki.O00000o("AlbumActivity", "==============tlt==============" + timelapseTask.status);
                long startTimestampInUTCSeconds = timelapseTask.getStartTimestampInUTCSeconds();
                if (Timelapse.getTimeLapseFromList(startTimestampInUTCSeconds) != null) {
                    cki.O00000o("AlbumActivity", "==============列表中有");
                    Timelapse.getTimeLapseFromList(startTimestampInUTCSeconds).setTimelapseSaveType(1);
                    Timelapse.getTimeLapseFromList(startTimestampInUTCSeconds).setFileStatus(timelapseTask.getFileStatus());
                    if (timelapseTask.status == 2) {
                        Timelapse.getTimeLapseFromList(startTimestampInUTCSeconds).refreshState();
                    }
                } else {
                    cki.O00000o("AlbumActivity", "==============列表没有，新建,taskID=" + timelapseTask.getTaskID());
                    timelapseTask.createLocalFolder(true, false, this.mCameraDevice);
                    Timelapse.timeLapseList.add(timelapseTask);
                    addTimelapseData(activity(), this.timeLapseData, timelapseTask);
                }
            }
            refreshData();
            cki.O00000o("AlbumActivity", "相册中的数据的总长度=" + this.mAdapter.getItemCount());
        }
    }

    private void deteBatcheTimeLapse() {
        this.batcheDelTLArray = new ArrayList<>();
        this.batcheDelTLArray.clear();
        this.batcheDelTNum += 3;
        cki.O00000o("AlbumActivity", "deteBatcheTimeLapse batcheDelTNum=" + this.batcheDelTNum);
        if (this.preDelTLArray.size() > 3) {
            for (int i = this.batcheDelTNum; i < this.preDelTLArray.size(); i++) {
                this.batcheDelTLArray.add(this.preDelTLArray.get(i));
            }
        }
        cki.O00000o("AlbumActivity", "deteBatcheTimeLapse batcheDelTLArray.size()=" + this.batcheDelTLArray.size());
        if (this.batcheDelTLArray.size() <= 0) {
            cki.O00000o("AlbumActivity", "要删除的延时摄影为空");
            this.batcheDelTNum = 0;
        } else if (this.mCameraPlayer != null) {
            cki.O00000o("AlbumActivity", "deteBatcheTimeLapse 发送了删除延时摄影的命令 preDelTLArray.size==" + this.batcheDelTLArray.size());
            this.mTImeLapseTaskManager.deleteRecord(this.batcheDelTLArray, this);
        }
    }

    private void deleteLocalTimeLapse(ArrayList<TimelapseTask> arrayList) {
        Iterator<TimelapseTask> it = arrayList.iterator();
        while (it.hasNext()) {
            TimelapseTask next = it.next();
            cki.O00000o("AlbumActivity", " 删除Timelapse22：" + next.startTimestampInUTCSeconds);
            TimelapseTask timeLapseFromList = Timelapse.getTimeLapseFromList(next.startTimestampInUTCSeconds);
            if (timeLapseFromList != null) {
                timeLapseFromList.deleLocalDataNew(null);
            } else {
                return;
            }
        }
    }

    public void onVideoPlayError(int i, String str) {
        cki.O00000o("AlbumActivity", "onVideoPlayError .....error=" + i + ",errorInfo=" + str);
    }

    public void onConnected() {
        cki.O00000o("AlbumActivity", "onConnected  。。。。");
        if (this.mCameraPlayer != null && this.mCameraDevice != null && this.mCameraDevice.O0000oOO()) {
            cki.O00000o("AlbumActivity", "连接摄像头成功,");
            this.mCameraPlayer.O0000Oo();
            this.mCameraPlayer.O0000Oo0();
        }
    }

    public void onServerCmd(int i, byte[] bArr) {
        cki.O00000o("AlbumActivity", "CommandTreatment onServerCmd type=" + i + ",mHandler=" + this.mHandler);
        new CommandTreatment(this.mHandler, this.mCameraDevice).processData(bArr);
    }

    public void onSendCmdError() {
        cki.O00000o("AlbumActivity", "onSendCmdError");
    }

    class AlbumDecoration extends RecyclerView.O0000Oo {
        private int space = ((int) (chp.O00000o0 * 2.0f));

        AlbumDecoration() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            if ((recyclerView.getChildAdapterPosition(view) + 1) % 3 == 0) {
                rect.set(0, this.space, 0, 0);
                return;
            }
            int i = this.space;
            rect.set(0, i, i, 0);
        }
    }

    public void insertToAlbum(String str) {
        File file = new File(str);
        if (file.exists()) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
        }
    }
}
