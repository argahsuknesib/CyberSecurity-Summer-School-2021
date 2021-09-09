package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.gkv;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hzf;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadListViewAdapter;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import java.io.File;
import java.util.List;

public class CloudVideoDownloadActivity extends CloudVideoBaseActivity implements View.OnClickListener {
    public CloudVideoDownloadListViewAdapter adapter;
    public int currentDownloadingPos = -1;
    private CloudVideoDownloadListView cvdlvDownloadVideo;
    public String did = null;
    private ImageView ivHeaderLeftBack;
    public ImageView ivHeaderRightSetting;
    public boolean mIsHsPanoramaVideo;
    private final String model = "";
    private RelativeLayout rlTitleBar;
    private TextView tvBlank;
    private TextView tvDelete;
    private TextView tvTitleBarTitle;
    public String uid = null;
    private Vibrator vibrator;
    private PowerManager.WakeLock wakeLock;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_download_video);
        this.vibrator = (Vibrator) gkv.f17949O000000o.getSystemService("vibrator");
        this.uid = getIntent().getStringExtra("uid");
        this.did = getIntent().getStringExtra("did");
        this.mIsHsPanoramaVideo = getIntent().getBooleanExtra("is_hs_panorama_video", false);
        initViews();
    }

    private void initViews() {
        this.rlTitleBar = (RelativeLayout) findViewById(R.id.rlTitleBar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.rlTitleBar.getLayoutParams());
        layoutParams.setMargins(0, hzf.O000000o(CommonApplication.getAppContext()), 0, 0);
        this.rlTitleBar.setLayoutParams(layoutParams);
        this.rlTitleBar.bringToFront();
        this.ivHeaderLeftBack = (ImageView) findViewById(R.id.ivHeaderLeftBack);
        this.ivHeaderLeftBack.setOnClickListener(this);
        this.ivHeaderRightSetting = (ImageView) findViewById(R.id.ivHeaderRightSetting);
        this.ivHeaderRightSetting.setVisibility(0);
        this.ivHeaderRightSetting.setImageResource(R.drawable.ic_edit_rename_selector);
        this.ivHeaderRightSetting.setOnClickListener(this);
        this.tvTitleBarTitle = (TextView) findViewById(R.id.tvTitleBarTitle);
        String stringExtra = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.tvTitleBarTitle.setText(stringExtra);
        }
        this.tvDelete = (TextView) findViewById(R.id.tvDelete);
        this.tvDelete.setOnClickListener(this);
        this.tvBlank = (TextView) findViewById(R.id.tvBlank);
        this.cvdlvDownloadVideo = (CloudVideoDownloadListView) findViewById(R.id.cvdlvDownloadVideo);
        this.cvdlvDownloadVideo.setLayoutManager(new LinearLayoutManager(this));
        CloudVideoDownloadManager.getInstance("").resetStatus(this.uid, this.did);
        this.adapter = new CloudVideoDownloadListViewAdapter();
        this.adapter.clickListener = new CloudVideoDownloadListViewAdapter.IItemClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadActivity.AnonymousClass1 */

            public void onItemClick(View view, int i, Object obj) {
                if (CloudVideoDownloadActivity.this.adapter.getEditMode()) {
                    if (CloudVideoDownloadActivity.this.adapter.downloadInfoList.get(i).isSelected) {
                        CloudVideoDownloadActivity.this.adapter.downloadInfoList.get(i).isSelected = false;
                    } else {
                        CloudVideoDownloadActivity.this.adapter.downloadInfoList.get(i).isSelected = true;
                    }
                    CloudVideoDownloadActivity.this.adapter.notifyItemChanged(i, "editMode");
                    return;
                }
                if (obj != null && (obj instanceof CloudVideoDownloadInfo)) {
                    CloudVideoDownloadInfo cloudVideoDownloadInfo = (CloudVideoDownloadInfo) obj;
                    if (cloudVideoDownloadInfo.status == 0) {
                        Intent intent = new Intent(CloudVideoDownloadActivity.this.getContext(), CloudVideoLocalGeneralPlayerActivity.class);
                        String str = cloudVideoDownloadInfo.mp4FilePath;
                        String str2 = cloudVideoDownloadInfo.m3u8LocalPath;
                        if (CloudVideoDownloadActivity.this.mIsHsPanoramaVideo) {
                            Context context = CloudVideoDownloadActivity.this.getContext();
                            String str3 = cloudVideoDownloadInfo.did;
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            CloudHSPlayerActivity.startLocal(context, str3, str);
                            return;
                        }
                        gsy.O00000Oo("CloudVideoDownloadActivity", "mp4FilePath:" + str + " m3u8LocalPath:" + str2);
                        if (!TextUtils.isEmpty(str2)) {
                            intent.putExtra("m3u8LocalPath", String.valueOf(str2));
                        } else if (!TextUtils.isEmpty(str)) {
                            intent.putExtra("filePath", String.valueOf(str));
                        }
                        CloudVideoDownloadActivity.this.startActivity(intent);
                        return;
                    }
                }
                if (obj != null && (obj instanceof CloudVideoDownloadInfo)) {
                    CloudVideoDownloadInfo cloudVideoDownloadInfo2 = (CloudVideoDownloadInfo) obj;
                    if (cloudVideoDownloadInfo2.status == 1 || cloudVideoDownloadInfo2.status == 4) {
                        CloudVideoDownloadManager.getInstance("").cancelCurrentDownload(cloudVideoDownloadInfo2.did, cloudVideoDownloadInfo2.fileId);
                        cloudVideoDownloadInfo2.status = 8;
                        CloudVideoDownloadManager.getInstance("").updateRecord(cloudVideoDownloadInfo2);
                        CloudVideoDownloadManager.getInstance("").pullDownloadFromList(CloudVideoDownloadActivity.this.getApplicationContext(), CloudVideoDownloadActivity.this.uid, CloudVideoDownloadActivity.this.did);
                        CloudVideoDownloadActivity.this.adapter.notifyItemChanged(i, "itemClick");
                        return;
                    }
                }
                if (obj != null && (obj instanceof CloudVideoDownloadInfo)) {
                    CloudVideoDownloadInfo cloudVideoDownloadInfo3 = (CloudVideoDownloadInfo) obj;
                    if (cloudVideoDownloadInfo3.status == 8 || cloudVideoDownloadInfo3.status == 2) {
                        cloudVideoDownloadInfo3.status = 4;
                        CloudVideoDownloadManager.getInstance("").updateRecord(cloudVideoDownloadInfo3);
                        CloudVideoDownloadManager.getInstance("").pullDownloadFromList(CloudVideoDownloadActivity.this.getApplicationContext(), CloudVideoDownloadActivity.this.uid, CloudVideoDownloadActivity.this.did);
                        CloudVideoDownloadActivity.this.adapter.notifyItemChanged(i, "itemClick");
                    }
                }
            }

            public void onItemLongClick(View view, int i, Object obj) {
                CloudVideoDownloadActivity.this.enterEditMode();
                if (CloudVideoDownloadActivity.this.adapter != null && CloudVideoDownloadActivity.this.adapter.getEditMode()) {
                    CloudVideoDownloadActivity.this.ivHeaderRightSetting.setImageResource(R.drawable.cs_icon_edit_select_all);
                }
            }
        };
        CloudVideoDownloadListViewAdapter cloudVideoDownloadListViewAdapter = this.adapter;
        cloudVideoDownloadListViewAdapter.modeChangedListener = new CloudVideoDownloadListViewAdapter.ModeChangedListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$RlCvRhxRpzlN9k9kwZ8ifrD3tE */

            public final void onEditModeChanged(boolean z) {
                CloudVideoDownloadActivity.this.lambda$initViews$0$CloudVideoDownloadActivity(z);
            }
        };
        this.cvdlvDownloadVideo.setAdapter(cloudVideoDownloadListViewAdapter);
    }

    public /* synthetic */ void lambda$initViews$0$CloudVideoDownloadActivity(boolean z) {
        if (z) {
            this.tvDelete.setVisibility(0);
        } else {
            this.tvDelete.setVisibility(8);
        }
        getWindow().getDecorView().requestLayout();
    }

    public void onBackPressed() {
        CloudVideoDownloadListViewAdapter cloudVideoDownloadListViewAdapter = this.adapter;
        if (cloudVideoDownloadListViewAdapter == null || !cloudVideoDownloadListViewAdapter.getEditMode()) {
            super.onBackPressed();
        } else {
            exitEditMode();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, getClass().getSimpleName());
            this.wakeLock.acquire();
        }
        refreshData();
        download();
        CloudVideoDownloadManager.getInstance("").addListener(new CloudVideoDownloadManager.ICloudVideoDownloadListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadActivity.AnonymousClass2 */

            public void onM3U8ToMp4Finish(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            }

            public void onStart(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                gsy.O00000Oo("CloudVideoDownloadActivity", "onStart url:" + cloudVideoDownloadInfo.m3u8FilePath + " filePath:" + cloudVideoDownloadInfo.mp4FilePath);
                CloudVideoDownloadActivity.this.getDownloadingIndex(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$2$iStqjuklrzd_LfbENIxwwxuZPVQ */
                    private final /* synthetic */ CloudVideoDownloadInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        CloudVideoDownloadActivity.AnonymousClass2.this.lambda$onStart$0$CloudVideoDownloadActivity$2(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$onStart$0$CloudVideoDownloadActivity$2(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                CloudVideoDownloadActivity.this.adapter.updateDownloadingItem(cloudVideoDownloadInfo);
            }

            public void onStop(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
                cloudVideoDownloadInfo.status = 4;
                CloudVideoDownloadActivity.this.getDownloadingIndex(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$2$57aSndfQC7q0QTnwF8HDHuBQ0Y */
                    private final /* synthetic */ CloudVideoDownloadInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        CloudVideoDownloadActivity.AnonymousClass2.this.lambda$onStop$1$CloudVideoDownloadActivity$2(this.f$1);
                    }
                });
                gsy.O00000Oo("CloudVideoDownloadActivity", "onStop:".concat(String.valueOf(i)));
            }

            public /* synthetic */ void lambda$onStop$1$CloudVideoDownloadActivity$2(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                CloudVideoDownloadActivity.this.adapter.updateDownloadingItem(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.adapter.notifyItemChanged(CloudVideoDownloadActivity.this.currentDownloadingPos, "onStop");
            }

            public void onFinish(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                gsy.O00000Oo("CloudVideoDownloadActivity", "onFinish:" + cloudVideoDownloadInfo.mp4FilePath + " m3u8FilePath:" + cloudVideoDownloadInfo.m3u8FilePath);
                cloudVideoDownloadInfo.status = 0;
                CloudVideoDownloadActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$2$5nzKiE3X64vCQND3fz_wtziSMO4 */
                    private final /* synthetic */ CloudVideoDownloadInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        CloudVideoDownloadActivity.AnonymousClass2.this.lambda$onFinish$2$CloudVideoDownloadActivity$2(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$onFinish$2$CloudVideoDownloadActivity$2(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                if (!TextUtils.isEmpty(cloudVideoDownloadInfo.mp4FilePath)) {
                    CloudVideoDownloadActivity.this.insertToAlbum(cloudVideoDownloadInfo.mp4FilePath);
                }
                CloudVideoDownloadActivity.this.adapter.updateDownloadingItem(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.adapter.notifyItemChanged(CloudVideoDownloadActivity.this.currentDownloadingPos, "onFinish");
            }

            public void onCancelled(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                cloudVideoDownloadInfo.status = 8;
                CloudVideoDownloadActivity.this.getDownloadingIndex(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$2$dqaefM89UwmjunrA6iElvwHgjtI */
                    private final /* synthetic */ CloudVideoDownloadInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        CloudVideoDownloadActivity.AnonymousClass2.this.lambda$onCancelled$3$CloudVideoDownloadActivity$2(this.f$1);
                    }
                });
                gsy.O00000Oo("CloudVideoDownloadActivity", "onCancelled");
            }

            public /* synthetic */ void lambda$onCancelled$3$CloudVideoDownloadActivity$2(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                CloudVideoDownloadActivity.this.adapter.updateDownloadingItem(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.adapter.notifyItemChanged(CloudVideoDownloadActivity.this.currentDownloadingPos, "onCancelled");
            }

            public void onInfo(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
                CloudVideoDownloadActivity.this.getDownloadingIndex(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$2$rOZV86XuIBZsF8HesjEtJ9jKRQ */

                    public final void run() {
                        CloudVideoDownloadActivity.AnonymousClass2.this.lambda$onInfo$4$CloudVideoDownloadActivity$2();
                    }
                });
                gsy.O00000Oo("CloudVideoDownloadActivity", "onInfo code:".concat(String.valueOf(i)));
            }

            public /* synthetic */ void lambda$onInfo$4$CloudVideoDownloadActivity$2() {
                CloudVideoDownloadActivity.this.adapter.notifyItemChanged(CloudVideoDownloadActivity.this.currentDownloadingPos, "onInfo");
            }

            public void onError(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
                cloudVideoDownloadInfo.status = 2;
                CloudVideoDownloadActivity.this.getDownloadingIndex(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$2$Ya6sdI86eV7GNBitGdOhyBoHzI */
                    private final /* synthetic */ CloudVideoDownloadInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        CloudVideoDownloadActivity.AnonymousClass2.this.lambda$onError$5$CloudVideoDownloadActivity$2(this.f$1);
                    }
                });
                gsy.O00000Oo("CloudVideoDownloadActivity", "onError code:".concat(String.valueOf(i)));
            }

            public /* synthetic */ void lambda$onError$5$CloudVideoDownloadActivity$2(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                CloudVideoDownloadActivity.this.adapter.updateDownloadingItem(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.adapter.notifyItemChanged(CloudVideoDownloadActivity.this.currentDownloadingPos, "onError");
            }

            public void onProgress(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
                gsy.O00000Oo("CloudVideoDownloadActivity", "progress:" + i + " currentDownloadingPos:" + CloudVideoDownloadActivity.this.currentDownloadingPos);
                cloudVideoDownloadInfo.progress = i;
                cloudVideoDownloadInfo.status = 1;
                CloudVideoDownloadActivity.this.getDownloadingIndex(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.runOnUiThread(new Runnable(cloudVideoDownloadInfo) {
                    /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$2$mzx9QC5zgv8D5OCoaUK9N5RwJY */
                    private final /* synthetic */ CloudVideoDownloadInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        CloudVideoDownloadActivity.AnonymousClass2.this.lambda$onProgress$6$CloudVideoDownloadActivity$2(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$onProgress$6$CloudVideoDownloadActivity$2(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                CloudVideoDownloadActivity.this.adapter.updateDownloadingItem(cloudVideoDownloadInfo);
                CloudVideoDownloadActivity.this.adapter.notifyItemChanged(CloudVideoDownloadActivity.this.currentDownloadingPos, "onProgress");
            }

            public void onSpeed(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
                CloudVideoDownloadActivity.this.getDownloadingIndex(cloudVideoDownloadInfo);
            }
        });
    }

    public void onPause() {
        super.onPause();
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
            this.wakeLock = null;
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.ivHeaderLeftBack) {
            onBackPressed();
        } else if (view.getId() == R.id.ivHeaderRightSetting) {
            CloudVideoDownloadListViewAdapter cloudVideoDownloadListViewAdapter = this.adapter;
            if (cloudVideoDownloadListViewAdapter == null || !cloudVideoDownloadListViewAdapter.getEditMode()) {
                CloudVideoDownloadListViewAdapter cloudVideoDownloadListViewAdapter2 = this.adapter;
                if (cloudVideoDownloadListViewAdapter2 == null || cloudVideoDownloadListViewAdapter2.getItemCount() <= 0) {
                    gqg.O00000Oo((int) R.string.cs_no_data);
                    return;
                }
                enterEditMode();
                if (this.adapter.getEditMode()) {
                    this.ivHeaderRightSetting.setImageResource(R.drawable.cs_icon_edit_select_all);
                }
            } else if (this.adapter.getSelectedItemCount() == this.adapter.downloadInfoList.size()) {
                this.ivHeaderRightSetting.setImageResource(R.drawable.cs_icon_edit_select_all);
                this.adapter.clearAll();
            } else {
                this.ivHeaderRightSetting.setImageResource(R.drawable.cs_icon_edit_deselect_all);
                this.adapter.selectAll();
            }
        } else if (view.getId() == R.id.tvDelete) {
            confirmDelete();
        }
    }

    private void exitEditMode() {
        if (this.adapter != null && !TextUtils.isEmpty(this.uid) && !TextUtils.isEmpty(this.did)) {
            this.adapter.downloadInfoList.clear();
            this.adapter.downloadInfoList = CloudVideoDownloadManager.getInstance("").getRecords(this.uid, this.did);
            this.adapter.notifyDataSetChanged();
        }
        if (this.adapter.getEditMode()) {
            this.vibrator.vibrate(100);
            this.adapter.setEditMode(false);
            this.ivHeaderRightSetting.setImageResource(R.drawable.ic_edit_rename_selector);
        }
    }

    public void enterEditMode() {
        if (this.adapter != null && !TextUtils.isEmpty(this.uid) && !TextUtils.isEmpty(this.did)) {
            this.adapter.downloadInfoList.clear();
            this.adapter.downloadInfoList = CloudVideoDownloadManager.getInstance("").getRecords(this.uid, this.did);
            this.adapter.notifyDataSetChanged();
        }
        if (!this.adapter.getEditMode()) {
            this.vibrator.vibrate(100);
            this.adapter.setEditMode(true);
        }
    }

    private void confirmDelete() {
        CloudVideoDownloadListViewAdapter cloudVideoDownloadListViewAdapter = this.adapter;
        if (cloudVideoDownloadListViewAdapter == null || cloudVideoDownloadListViewAdapter.getSelectedItemCount() <= 0) {
            gqg.O00000Oo((int) R.string.cs_select_video);
            exitEditMode();
            return;
        }
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.cs_delete_video)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$evgOO9cpQs2fsalTGCZCpNR0Xw */

            public final void onClick(DialogInterface dialogInterface, int i) {
                CloudVideoDownloadActivity.this.lambda$confirmDelete$1$CloudVideoDownloadActivity(dialogInterface, i);
            }
        }).O000000o(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$yTxoVFqx5g_33uaH9_TpbHFRS8M */

            public final void onCancel(DialogInterface dialogInterface) {
                CloudVideoDownloadActivity.this.lambda$confirmDelete$2$CloudVideoDownloadActivity(dialogInterface);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadActivity$D8QrhBU9y8DIMSN8OJL8Czwh0mc */

            public final void onClick(DialogInterface dialogInterface, int i) {
                CloudVideoDownloadActivity.this.lambda$confirmDelete$3$CloudVideoDownloadActivity(dialogInterface, i);
            }
        }).O00000oo();
    }

    public /* synthetic */ void lambda$confirmDelete$1$CloudVideoDownloadActivity(DialogInterface dialogInterface, int i) {
        deleteDownloadedVideo();
    }

    public /* synthetic */ void lambda$confirmDelete$2$CloudVideoDownloadActivity(DialogInterface dialogInterface) {
        exitEditMode();
    }

    public /* synthetic */ void lambda$confirmDelete$3$CloudVideoDownloadActivity(DialogInterface dialogInterface, int i) {
        exitEditMode();
    }

    private void deleteDownloadedVideo() {
        if (this.adapter.getSelectedItemCount() > 0) {
            CloudVideoDownloadManager.getInstance("").deleteRecords(this.adapter.getSelectedItem());
            refreshData();
        } else {
            gqg.O00000Oo((int) R.string.cs_select_video);
        }
        exitEditMode();
    }

    private void refreshData() {
        List<CloudVideoDownloadInfo> records = CloudVideoDownloadManager.getInstance("").getRecords(this.uid, this.did);
        if (records == null || records.size() <= 0) {
            this.tvBlank.setVisibility(0);
        } else {
            List<CloudVideoDownloadInfo> list = this.adapter.downloadInfoList;
            this.adapter.downloadInfoList = records;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    this.adapter.updateDownloadingItem(list.get(i));
                }
            }
            this.tvBlank.setVisibility(8);
        }
        if (this.adapter != null && !TextUtils.isEmpty(this.uid) && !TextUtils.isEmpty(this.did)) {
            this.adapter.downloadInfoList.clear();
            this.adapter.downloadInfoList = CloudVideoDownloadManager.getInstance("").getRecords(this.uid, this.did);
            this.adapter.notifyDataSetChanged();
        }
    }

    private void download() {
        CloudVideoDownloadManager.getInstance("").insertRecords(this.adapter.getSelectedItem());
        CloudVideoDownloadManager.getInstance("").pullDownloadFromList(getContext().getApplicationContext(), this.uid, this.did);
    }

    public void getDownloadingIndex(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        if (this.adapter != null) {
            int i = 0;
            while (i < this.adapter.downloadInfoList.size()) {
                if (cloudVideoDownloadInfo == null || cloudVideoDownloadInfo.id != this.adapter.downloadInfoList.get(i).id) {
                    i++;
                } else {
                    this.currentDownloadingPos = i;
                    return;
                }
            }
        }
        this.currentDownloadingPos = -1;
    }

    public void insertToAlbum(String str) {
        File file = new File(str);
        if (file.exists()) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
        }
    }
}
