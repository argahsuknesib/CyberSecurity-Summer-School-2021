package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.cib;
import _m_j.civ;
import _m_j.ckq;
import _m_j.ckv;
import _m_j.clf;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.hyy;
import _m_j.me;
import _m_j.mg;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mijia.generalplayer.videoview.BasicVideoView;
import com.mijia.generalplayer.videoview.GeneralVideoView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;

public class DailyStoryPlayActivity extends CameraBaseActivity implements View.OnClickListener {
    private View bottom_tools_container;
    private int category;
    private CheckBox cbIsMute;
    private long createTime;
    public String fileId;
    private GeneralVideoView generalVideoView;
    public boolean isNetShowing = false;
    private SimpleDateFormat mFileNameFormat;
    public boolean mHasStart = false;
    private XQProgressDialog mProgressDialog;
    private SimpleDateFormat mTimeFormat;
    private SimpleDateFormat mTitleFormat;
    public String region;
    private FrameLayout title_bar;
    private TextView title_bar_title;
    private View top_tools_container;
    public String videoFilePath;
    private String videoUrl;
    private FrameLayout video_container;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_daily_story_play);
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        this.mTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        this.mTitleFormat = new SimpleDateFormat("yyyy.MM.dd-");
        this.mFileNameFormat = new SimpleDateFormat("_yyyyMMdd'.mp4'");
        this.fileId = getIntent().getStringExtra("fileId");
        this.region = getIntent().getStringExtra("region");
        this.createTime = getIntent().getLongExtra("createTime", 0);
        this.category = getIntent().getIntExtra("category", 1);
        initView();
        playVideo();
    }

    private int getScreenWidth() {
        return hyy.O00000Oo(getIntent()).widthPixels;
    }

    private void initView() {
        this.title_bar = (FrameLayout) findViewById(R.id.title_bar);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.title_bar_title = (TextView) findViewById(R.id.title_bar_title);
        if (this.category == 1) {
            this.title_bar_title.setText(String.format(getString(R.string.title_family), this.mTitleFormat.format(Long.valueOf(this.createTime))));
        } else {
            this.title_bar_title.setText(String.format(getString(R.string.title_pet), this.mTitleFormat.format(Long.valueOf(this.createTime))));
        }
        this.video_container = (FrameLayout) findViewById(R.id.video_container);
        ViewGroup.LayoutParams layoutParams = this.video_container.getLayoutParams();
        layoutParams.height = (int) (((float) getScreenWidth()) * 0.5625f);
        this.video_container.setLayoutParams(layoutParams);
        this.generalVideoView = new GeneralVideoView(this);
        this.video_container.addView(this.generalVideoView);
        this.generalVideoView.O000000o(this.mCameraDevice.getModel(), this.mDid);
        this.generalVideoView.O000000o(true);
        int[] iArr = null;
        if (!this.mCameraDevice.isReadOnlyShared()) {
            iArr = new int[]{ckv.camera_ic_player_share, ckv.camera_ic_player_download, ckv.camera_ic_player_delete};
        }
        this.generalVideoView.O000000o(iArr, new ckv.O000000o() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$DailyStoryPlayActivity$VaR1BfLhF8mGe5PxF8Kx9dVatd4 */

            public final void onActionClick(int i) {
                DailyStoryPlayActivity.this.lambda$initView$0$DailyStoryPlayActivity(i);
            }
        });
        findViewById(R.id.tvsMultiSpeed).setVisibility(8);
        this.generalVideoView.setOnConfigurationChangedListener(new BasicVideoView.O000000o() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$DailyStoryPlayActivity$E1ZM3duMIwFjyBzHk3EU3Q167ok */

            public final void onChangeOrientation(boolean z) {
                DailyStoryPlayActivity.this.lambda$initView$1$DailyStoryPlayActivity(z);
            }
        });
        if (this.mCameraDevice.isReadOnlyShared()) {
            findViewById(R.id.bottom_tools_container).setVisibility(8);
        }
        findViewById(R.id.tv_share).setOnClickListener(this);
        findViewById(R.id.tv_delete).setOnClickListener(this);
        findViewById(R.id.tv_download).setOnClickListener(this);
        this.top_tools_container = findViewById(R.id.videoViewTopCtrl);
        this.top_tools_container.setVisibility(8);
        this.bottom_tools_container = findViewById(R.id.bottom_tools_container);
        this.cbIsMute = (CheckBox) findViewById(R.id.cbIsMute);
    }

    public /* synthetic */ void lambda$initView$0$DailyStoryPlayActivity(int i) {
        if (i == ckv.camera_ic_player_share) {
            shareVideo();
        } else if (i == ckv.camera_ic_player_download) {
            startDownloadVideo(false);
        } else if (i == ckv.camera_ic_player_delete) {
            deleteVideo();
        }
    }

    private void playVideo() {
        this.videoUrl = DailyStoryNetUtils.getInstance().getVideoFileUrl(this.mCameraDevice.getModel(), this.mDid, this.region, this.fileId);
        HashMap hashMap = new HashMap();
        MiServiceTokenInfo tokenInfo = CloudVideoNetUtils.getInstance().getTokenInfo();
        if (tokenInfo != null) {
            hashMap.put("Cookie", "yetAnotherServiceToken=" + tokenInfo.O00000o0);
            this.generalVideoView.O000000o(false);
            this.cbIsMute.setChecked(false);
            this.generalVideoView.O000000o(this.videoUrl, hashMap);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.tv_delete) {
            hxi.O00000o.f952O000000o.O000000o("DailyStory_Delete_ClickNum", new Object[0]);
            deleteVideo();
        } else if (view.getId() == R.id.tv_share) {
            hxi.O00000o.f952O000000o.O000000o("DailyStory_Share_ClickNum", new Object[0]);
            shareVideo();
        } else if (view.getId() == R.id.tv_download) {
            hxi.O00000o.f952O000000o.O000000o("DailyStory_Download_ClickNum", new Object[0]);
            startDownloadVideo(false);
        }
    }

    private void deleteVideo() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o((int) R.string.delete_title);
        builder.O000000o((int) R.string.delete, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryPlayActivity.AnonymousClass1 */

            public void onClick(DialogInterface dialogInterface, int i) {
                DailyStoryNetUtils.getInstance().deleteVideo(DailyStoryPlayActivity.this.mDid, DailyStoryPlayActivity.this.mDeviceStat.model, DailyStoryPlayActivity.this.region, new Object[]{DailyStoryPlayActivity.this.fileId}, new DailyStoryNetUtils.ICallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryPlayActivity.AnonymousClass1.AnonymousClass1 */

                    public void onSuccess(Object obj) {
                        if (!DailyStoryPlayActivity.this.isFinishing()) {
                            gqg.O00000Oo((int) R.string.delete_sucess);
                            DailyStoryPlayActivity.this.setResult(-1);
                            DailyStoryPlayActivity.this.finish();
                        }
                    }

                    public void onFailure(int i, String str) {
                        gqg.O00000Oo((int) R.string.delete_failed);
                    }
                });
            }
        });
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O00000oo();
    }

    private void startDownloadVideo(final boolean z) {
        this.videoFilePath = getFileName(this.category, false);
        if (new File(this.videoFilePath).exists()) {
            if (!z) {
                gqg.O000000o(activity(), getString(R.string.save_success), 0);
            }
            if (z) {
                toShare(this.videoFilePath);
                return;
            }
            return;
        }
        gsy.O00000Oo("DailyStoryPlayActivity", "startDownloadVideo videoFilePath=" + this.videoFilePath);
        if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
        } else if (!this.mHasStart) {
            this.mHasStart = true;
            initProgressDlg(z);
            DailyStoryNetUtils.getInstance().downloadVideo(this.mDeviceStat.model, this.mDid, this.region, this.fileId, this.videoFilePath, getContext(), z, new clf.O000000o() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryPlayActivity.AnonymousClass2 */

                public void onProgress(int i) {
                }

                public void onStart() {
                    gsy.O00000Oo("DailyStoryPlayActivity", "startDownloadVideo onStart");
                }

                public void onComplete() {
                    gsy.O00000Oo("DailyStoryPlayActivity", "startDownloadVideo onComplete");
                    if (!z) {
                        gqg.O000000o(DailyStoryPlayActivity.this.activity(), DailyStoryPlayActivity.this.getString(R.string.save_success), 0);
                    }
                    DailyStoryPlayActivity dailyStoryPlayActivity = DailyStoryPlayActivity.this;
                    dailyStoryPlayActivity.mHasStart = false;
                    dailyStoryPlayActivity.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryPlayActivity.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            DailyStoryPlayActivity.this.disProgressDlg();
                            if (z) {
                                DailyStoryPlayActivity.this.toShare(DailyStoryPlayActivity.this.videoFilePath);
                            }
                        }
                    });
                }

                public void onError(final int i, String str) {
                    gsy.O00000Oo("DailyStoryPlayActivity", "startDownloadVideo onError");
                    DailyStoryPlayActivity dailyStoryPlayActivity = DailyStoryPlayActivity.this;
                    dailyStoryPlayActivity.mHasStart = false;
                    File file = new File(dailyStoryPlayActivity.videoFilePath);
                    if (file.exists()) {
                        file.delete();
                    }
                    DailyStoryPlayActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryPlayActivity.AnonymousClass2.AnonymousClass2 */

                        public void run() {
                            DailyStoryPlayActivity.this.disProgressDlg();
                            int i = i;
                            if (i == 1002) {
                                gqg.O000000o(DailyStoryPlayActivity.this.activity(), DailyStoryPlayActivity.this.getString(R.string.net_wrong), 0);
                            } else if (i == 103) {
                                if (z) {
                                    DailyStoryPlayActivity.this.activity();
                                    gqg.O000000o((int) R.string.share_fail, 0);
                                    return;
                                }
                                DailyStoryPlayActivity.this.activity();
                                gqg.O000000o((int) R.string.download_fail, 0);
                            } else if (i == -4001) {
                                DailyStoryPlayActivity.this.activity();
                                gqg.O000000o((int) R.string.no_write_permission, 0);
                            } else {
                                Activity activity = DailyStoryPlayActivity.this.activity();
                                gqg.O000000o(activity, DailyStoryPlayActivity.this.getString(R.string.download_err) + i, 0);
                            }
                        }
                    });
                }
            });
        }
    }

    public void initProgressDlg(boolean z) {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new XQProgressDialog(activity());
        }
        this.mProgressDialog.setCancelable(false);
        this.mProgressDialog.setCanceledOnTouchOutside(false);
        if (z) {
            this.mProgressDialog.setMessage(getString(R.string.mj_loading));
        } else {
            this.mProgressDialog.setMessage(getString(R.string.cs_downloading));
        }
        this.mProgressDialog.show();
    }

    public void disProgressDlg() {
        XQProgressDialog xQProgressDialog = this.mProgressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    private String getFileName(int i, boolean z) {
        String str;
        if (z) {
            File file = new File(getExternalCacheDir().getAbsolutePath(), "daily_story");
            if (!file.exists()) {
                file.mkdirs();
            }
            str = file.getAbsolutePath() + File.separator;
        } else {
            str = me.O000000o(this.mDid) + File.separator;
        }
        if (i == 1) {
            return str + "Family" + this.fileId + this.mFileNameFormat.format(Long.valueOf(this.createTime));
        }
        return str + "Pet" + this.fileId + this.mFileNameFormat.format(Long.valueOf(this.createTime));
    }

    public void shareVideo() {
        civ.O000000o("DailyStoryPlayActivity", "分享了 videoFilePath=" + this.videoFilePath);
        if (TextUtils.isEmpty(this.videoFilePath)) {
            startDownloadVideo(true);
        } else if (!new File(this.videoFilePath).exists()) {
            startDownloadVideo(true);
        } else {
            toShare(this.videoFilePath);
        }
    }

    public void toShare(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (XmPluginHostApi.instance().getApiLevel() >= 29) {
            openShareVideoActivity(this, "", "", str, 17);
        } else {
            openSharePictureActivity("", "", str);
        }
    }

    /* access modifiers changed from: protected */
    public void setOrientation(boolean z) {
        if (z) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GeneralVideoView generalVideoView2 = this.generalVideoView;
        if (generalVideoView2 != null) {
            generalVideoView2.O000000o(configuration);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setWindow */
    public void lambda$initView$1$DailyStoryPlayActivity(boolean z) {
        boolean z2 = !z;
        if ((getContext() instanceof cib) && hyy.O000000o()) {
            z2 = ((cib) getContext()).getFullScreenThroughPad(z2);
        }
        if (z2) {
            hxi.O00000o.f952O000000o.O000000o("DailyStory_FullScreen_ClickNum", new Object[0]);
            this.title_bar.setVisibility(8);
            this.top_tools_container.setVisibility(0);
            this.bottom_tools_container.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.video_container.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            int O000000o2 = ckq.O000000o(this);
            this.video_container.setPadding(O000000o2, 0, O000000o2, 0);
            this.video_container.setLayoutParams(layoutParams);
            this.video_container.requestLayout();
            hideStatusBar();
            return;
        }
        this.title_bar.setVisibility(0);
        this.title_bar.bringToFront();
        this.top_tools_container.setVisibility(8);
        if (!this.mCameraDevice.isReadOnlyShared()) {
            this.bottom_tools_container.setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.video_container.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = (int) (((float) getScreenWidth()) * 0.5625f);
        layoutParams2.topMargin = gpc.O000000o(160.0f);
        this.video_container.setPadding(0, 0, 0, 0);
        this.video_container.setLayoutParams(layoutParams2);
        this.video_container.requestLayout();
    }

    public void onBackPressed() {
        if (1 != getRequestedOrientation()) {
            setRequestedOrientation(1);
        } else {
            super.onBackPressed();
        }
    }

    private void showNetAlarm() {
        if (!TextUtils.isEmpty(this.mCameraDevice.O0000oOo()) && mg.O00000o0(activity()) && !this.isNetShowing) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity());
            builder.O00000Oo((int) R.string.push_net_alarm);
            builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryPlayActivity.AnonymousClass3 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    DailyStoryPlayActivity.this.finish();
                }
            });
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryPlayActivity.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    DailyStoryPlayActivity.this.isNetShowing = false;
                }
            });
            builder.O00000oo();
            this.isNetShowing = true;
        }
    }
}
