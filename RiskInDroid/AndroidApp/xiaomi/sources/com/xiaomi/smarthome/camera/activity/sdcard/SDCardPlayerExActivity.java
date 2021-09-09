package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.C0118cif;
import _m_j.chr;
import _m_j.chw;
import _m_j.chx;
import _m_j.cid;
import _m_j.cih;
import _m_j.cin;
import _m_j.civ;
import _m_j.cki;
import _m_j.ckq;
import _m_j.clj;
import _m_j.clo;
import _m_j.clr;
import _m_j.cls;
import _m_j.clu;
import _m_j.clv;
import _m_j.exz;
import _m_j.ftn;
import _m_j.goq;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hyy;
import _m_j.izb;
import _m_j.me;
import _m_j.mg;
import _m_j.mi;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.mistream.MIStreamStatistic;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity;
import com.xiaomi.smarthome.camera.view.TextViewS;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerClickListener;
import com.xiaomi.smarthome.camera.view.widget.CenterDrawableCheckBox;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SDCardPlayerExActivity extends CameraPlayerBaseActivity implements clo.O00000Oo, RecyclerClickListener {
    public int UPDATE_DURATION = 200;
    private CenterDrawableCheckBox cdcToggleAudio;
    private CenterDrawableCheckBox cdcTogglePlay;
    private CardView cvFuncPopup;
    private Runnable dismissRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$6C_Etk5zxObSRLUGcU5_FlnKn54 */

        public final void run() {
            SDCardPlayerExActivity.this.lambda$new$13$SDCardPlayerExActivity();
        }
    };
    private ImageView ivCameraShot;
    private ImageView ivFullScreen;
    private LinearLayout llSelectBottom;
    private LinearLayout llVideoViewBottomCtrl;
    private clr mCameraSdcardFileManager;
    private cls mCameraSdcardFileManagerEx;
    public Date mDate;
    private int mDay;
    private clo mDownloadSdCardFileManager;
    public int mDuration;
    private int mEndTime;
    private FrameLayout mFLTitleBar;
    private int mHour;
    private boolean mIsSetTime = false;
    private int mLastOffsetTime = 0;
    private long mLastSetTime = 0;
    private long mLastUpdateTime = 0;
    HashSet<Long> mNeedCheckList = new HashSet<>();
    private CompoundButton.OnCheckedChangeListener mPlayOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass1 */

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            gsy.O00000Oo("SDCardPlayerExActivity", "cdcTogglePlay isChecked:".concat(String.valueOf(z)));
            if (z) {
                if (SDCardPlayerExActivity.this.mCameraPlayerEx != null) {
                    SDCardPlayerExActivity.this.mCameraPlayerEx.O00000o0();
                }
                SDCardPlayerExActivity.this.mHandler.removeMessages(2);
                SDCardPlayerExActivity.this.mUserPause = true;
                return;
            }
            int progress = SDCardPlayerExActivity.this.mProgress.getProgress();
            if (progress >= SDCardPlayerExActivity.this.mDuration) {
                SDCardPlayerExActivity.this.setPlayTime(0);
                SDCardPlayerExActivity.this.mProgress.setProgress(0);
                return;
            }
            SDCardPlayerExActivity.this.setPlayTime(progress);
        }
    };
    public SeekBar mProgress;
    private XQProgressDialog mProgressDialog;
    private TextView mProgressEnd;
    public TextView mProgressStart;
    public boolean mSeekBarTouched = false;
    SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("mm:ss");
    private int mStartTime;
    public TimeItem mTimeItem;
    List<TimeItemData> mTimeItemDataList = new ArrayList();
    List<TimeItem> mTimeItemList = new ArrayList();
    private TextView mTimeUpdateView;
    private RecyclerView rvHistoryVideoList;
    public SDCardHourAdapter sdCardVideoAdapter;
    private SimpleDateFormat sdf;
    private SimpleDateFormat sdfHHmm;
    private SimpleDateFormat sdfMMdd;
    private ImageView title_bar_more;
    private ImageView title_bar_return;
    private TextView tvBack;
    public TextView tvRecordTimer;
    private TextView tvSelectAll;
    private TextView tvSelectDelete;
    private TextView tvSelectSave;
    private TextViewS tvsMultiSpeed;

    public void detectSDCard() {
    }

    public boolean isHistory() {
        return true;
    }

    public void onDisConnected() {
    }

    public void onDisconnectedWithCode(int i) {
    }

    public void onRecyclerLongClick(View view) {
    }

    public boolean supportOrientationListen() {
        return true;
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        civ.O000000o("SDCardPlayerExActivity", "onCreate");
        setContentView((int) R.layout.camera_activity_camera_sdcard_player);
        this.mFLTitleBar = (FrameLayout) findViewById(R.id.title_bar);
        this.mFLTitleBar.setBackgroundResource(R.drawable.camera_shape_gradient_bg);
        this.title_bar_return = (ImageView) findViewById(R.id.title_bar_return);
        this.title_bar_return.setOnClickListener(this);
        this.title_bar_more = (ImageView) findViewById(R.id.title_bar_more);
        this.title_bar_more.setImageResource(R.drawable.camera_title_edit_drawable_white);
        this.title_bar_more.setOnClickListener(this);
        this.mFLTitleBar.bringToFront();
        this.mDay = getIntent().getExtras().getInt("mDay");
        this.mHour = getIntent().getExtras().getInt("mHour");
        this.mTimeItem = (TimeItem) getIntent().getExtras().getParcelable("time");
        if (this.mTimeItem == null) {
            gqg.O000000o((int) R.string.loading_failed);
            finish();
        }
        this.mStartTime = (int) (this.mTimeItem.f5243O000000o / 1000);
        this.mEndTime = (int) (this.mTimeItem.O00000o0 / 1000);
        this.mDuration = (int) (this.mTimeItem.O00000Oo / 1000);
        this.mDate = new Date();
        initView();
        startPlay();
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O000000o(true);
        }
        if (this.mCameraDevice.O00000o()) {
            this.mCameraSdcardFileManagerEx = this.mCameraDevice.O0000Oo0();
        } else {
            this.mCameraSdcardFileManager = this.mCameraDevice.O0000OOo();
        }
        if (this.mCameraDevice.O00000o()) {
            this.mDownloadSdCardFileManager = this.mCameraDevice.O0000o0();
        } else {
            this.mDownloadSdCardFileManager = this.mCameraDevice.O0000o00();
        }
        this.mDownloadSdCardFileManager.O000000o(this);
        this.sdfMMdd = new SimpleDateFormat(getString(R.string.simple_date_format_mm_dd));
        this.sdfMMdd.setTimeZone(mi.O000000o());
        this.sdfHHmm = new SimpleDateFormat(getString(R.string.simple_date_format_hh_mm));
        this.sdfHHmm.setTimeZone(mi.O000000o());
        this.mTitleView.setText(String.valueOf(this.sdfHHmm.format(Long.valueOf(this.mTimeItem.f5243O000000o)) + "-" + this.sdfHHmm.format(Long.valueOf(this.mTimeItem.O00000o0))));
        loadData();
        chr.O000000o(chr.O00O00oO);
    }

    private void initView() {
        this.llSelectBottom = (LinearLayout) findViewById(R.id.llSelectBottom);
        this.tvSelectSave = (TextView) findViewById(R.id.tvSelectSave);
        if (DeviceConstant.supportDownloadToPhone(this.mCameraDevice.getModel())) {
            findViewById(R.id.select_down).setVisibility(0);
            findViewById(R.id.select_down).setOnClickListener(this);
        } else {
            this.tvSelectSave.setVisibility(0);
            this.tvSelectSave.setOnClickListener(this);
        }
        this.tvSelectDelete = (TextView) findViewById(R.id.tvSelectDelete);
        this.tvSelectDelete.setOnClickListener(this);
        this.ivCameraShot = (ImageView) findViewById(R.id.ivCameraShot);
        this.ivCameraShot.setOnClickListener(this);
        this.tvRecordTimer = (TextView) findViewById(R.id.tvRecordTimer);
        this.llVideoViewBottomCtrl = (LinearLayout) findViewById(R.id.llVideoViewBottomCtrl);
        this.tvsMultiSpeed = (TextViewS) findViewById(R.id.tvsMultiSpeed);
        this.tvsMultiSpeed.setOnClickListener(this);
        if (this.mCameraDevice.O0000oOO()) {
            this.tvsMultiSpeed.setVisibility(8);
        }
        if (this.mCameraPlayerEx != null) {
            TextViewS textViewS = this.tvsMultiSpeed;
            textViewS.setText(this.mCameraPlayerEx.O0000oo + "X");
        } else {
            this.tvsMultiSpeed.setText("1X");
        }
        this.cdcToggleAudio = (CenterDrawableCheckBox) findViewById(R.id.cdcToggleAudio);
        this.cdcToggleAudio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$jd28dNsNjNOJH03O8yd581A0hLg */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SDCardPlayerExActivity.this.lambda$initView$0$SDCardPlayerExActivity(compoundButton, z);
            }
        });
        this.cdcTogglePlay = (CenterDrawableCheckBox) findViewById(R.id.cdcTogglePlay);
        this.cdcTogglePlay.setOnCheckedChangeListener(this.mPlayOnCheckedChangeListener);
        this.ivFullScreen = (ImageView) findViewById(R.id.ivFullScreen);
        this.ivFullScreen.setOnClickListener(this);
        this.cvFuncPopup = (CardView) findViewById(R.id.cvFuncPopup);
        this.cvFuncPopup.setOnClickListener(this);
        this.mTimeUpdateView = (TextView) findViewById(R.id.time_container_center);
        this.mTitleView = (TextView) findViewById(R.id.title_bar_title);
        this.mTitleView.setText((int) R.string.record_files_sdcard_title);
        this.mTitleView.setTextColor(Color.parseColor("#ffffff"));
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.video_frame);
        this.mVideoLayout = new FrameLayout(this);
        this.mVideoViewFrame.addView(this.mVideoLayout, 0, new FrameLayout.LayoutParams(-1, -1));
        this.mVideoView = XmPluginHostApi.instance().createVideoView(this, this.mVideoLayout, true, 2);
        this.mVideoView.setMaxScale(6.0f, 6.0f);
        this.mLoadingView = LayoutInflater.from(this).inflate((int) R.layout.camera_progress, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mVideoLayout.addView(this.mLoadingView, layoutParams);
        this.mLoadingView.setVisibility(8);
        this.mLoadingProgress = (TextView) this.mLoadingView.findViewById(R.id.loading_progress);
        this.mLoadingTitle = (TextView) this.mLoadingView.findViewById(R.id.loading_title);
        this.mLoadingImageView = (ImageView) this.mLoadingView.findViewById(R.id.loading_anim);
        this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_anim_camera_loading);
        this.mLoadingImageView.setImageDrawable(this.mLoadingAnimation);
        this.mErrorRetryView = LayoutInflater.from(this).inflate((int) R.layout.camera_error_retry, (ViewGroup) null);
        this.mVideoLayout.addView(this.mErrorRetryView, layoutParams);
        this.mErrorRetryView.setVisibility(8);
        this.mRetryView = this.mErrorRetryView.findViewById(R.id.retry_btn);
        this.mErrorInfoView = (TextView) this.mErrorRetryView.findViewById(R.id.error_info);
        this.mPowerOffView = LayoutInflater.from(this).inflate((int) R.layout.camera_closed, (ViewGroup) null);
        this.mVideoLayout.addView(this.mPowerOffView, layoutParams);
        this.mPowerOffView.setVisibility(8);
        this.mVideoView.setVideoViewListener(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$9fiMlPYxsWgTIUauxjQGSDDhNVU */

            public final void onVideoViewClick() {
                SDCardPlayerExActivity.this.lambda$initView$1$SDCardPlayerExActivity();
            }
        });
        this.mPauseView = findViewById(R.id.pause_view);
        this.mCameraDevice.O00000Oo().O000000o(this.mPropertyChangeListener);
        this.mCameraDevice.O00000Oo().O000000o();
        this.mProgressStart = (TextView) findViewById(R.id.progress_playtime);
        this.mProgressEnd = (TextView) findViewById(R.id.progress_duration);
        this.mDate.setTime(this.mTimeItem.f5243O000000o);
        this.mProgressStart.setText(this.mSimpleDateFormat.format(this.mDate));
        this.mDate.setTime(this.mTimeItem.O00000o0);
        this.mProgressEnd.setText(this.mSimpleDateFormat.format(this.mDate));
        this.mProgress = (SeekBar) findViewById(R.id.progress_bar);
        this.mProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass2 */

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                SDCardPlayerExActivity sDCardPlayerExActivity = SDCardPlayerExActivity.this;
                sDCardPlayerExActivity.mSeekBarTouched = true;
                sDCardPlayerExActivity.mHandler.removeMessages(1001);
                SDCardPlayerExActivity.this.mHandler.removeMessages(2);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                SDCardPlayerExActivity.this.mDate.setTime(SDCardPlayerExActivity.this.mTimeItem.f5243O000000o + ((long) (seekBar.getProgress() * 1000)));
                SDCardPlayerExActivity.this.mProgressStart.setText(SDCardPlayerExActivity.this.mSimpleDateFormat.format(SDCardPlayerExActivity.this.mDate));
                SDCardPlayerExActivity.this.mHandler.removeMessages(1001);
                SDCardPlayerExActivity.this.mHandler.sendEmptyMessage(1001);
                SDCardPlayerExActivity.this.mHandler.removeMessages(2);
                SDCardPlayerExActivity.this.mHandler.sendEmptyMessageDelayed(2, (long) SDCardPlayerExActivity.this.UPDATE_DURATION);
            }
        });
        this.mProgress.setMax(this.mDuration);
        showLoading();
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mPauseView.setOnClickListener(this);
        this.mVideoView.initial();
        if (this.mCameraDevice.O0000oOO()) {
            this.mCameraDevice.O000000o().O000000o(chx.O00000Oo, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass3 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(Void voidR) {
                    SDCardPlayerExActivity.this.refreshUI();
                }
            });
        } else {
            this.mCameraDevice.O000000o().O000000o(chx.f13863O000000o, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass4 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(Void voidR) {
                    SDCardPlayerExActivity.this.refreshUI();
                }
            });
        }
        this.rvHistoryVideoList = (RecyclerView) findViewById(R.id.list_view);
        this.rvHistoryVideoList.setLayoutManager(new GridLayoutManager(this, 3));
        this.sdCardVideoAdapter = new SDCardHourAdapter(this.rvHistoryVideoList, this, this, this.mDid, this.isV4);
        this.sdCardVideoAdapter.selectedPos = getIntent().getIntExtra("pos", -1);
        this.rvHistoryVideoList.setAdapter(this.sdCardVideoAdapter);
        if (this.sdCardVideoAdapter.selectedPos >= 0) {
            this.rvHistoryVideoList.scrollToPosition(this.sdCardVideoAdapter.selectedPos);
        }
        initEditView();
    }

    public /* synthetic */ void lambda$initView$0$SDCardPlayerExActivity(CompoundButton compoundButton, boolean z) {
        chr.O000000o(chr.O00O00oo);
        civ.O000000o("SDCardPlayerExActivity", "cdcToggleAudio isChecked:".concat(String.valueOf(z)));
        if (this.mCameraPlayerEx == null) {
            return;
        }
        if (z) {
            this.mCameraPlayerEx.O000000o(false);
        } else {
            this.mCameraPlayerEx.O000000o(true);
        }
    }

    public /* synthetic */ void lambda$initView$1$SDCardPlayerExActivity() {
        if (this.llVideoViewBottomCtrl.getTranslationY() > 0.0f) {
            LinearLayout linearLayout = this.llVideoViewBottomCtrl;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", (float) linearLayout.getHeight(), 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.start();
            return;
        }
        LinearLayout linearLayout2 = this.llVideoViewBottomCtrl;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout2, "translationY", 0.0f, (float) linearLayout2.getHeight());
        ofFloat2.setDuration(200L);
        ofFloat2.start();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    private void initEditView() {
        this.tvSelectAll = new TextView(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 21;
        layoutParams.rightMargin = cin.O000000o((Context) this, 14.0f);
        this.tvSelectAll.setPadding(10, 10, 10, 10);
        this.tvSelectAll.setLayoutParams(layoutParams);
        this.tvSelectAll.setBackgroundResource(R.drawable.camera_edit_select_all_white);
        this.tvSelectAll.setVisibility(8);
        this.mFLTitleBar.addView(this.tvSelectAll);
        this.tvSelectAll.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$s3N2GX1NN2nrXYgWVHoBnjDJF4 */

            public final void onClick(View view) {
                SDCardPlayerExActivity.this.lambda$initEditView$2$SDCardPlayerExActivity(view);
            }
        });
        this.tvBack = new TextView(this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 19;
        layoutParams2.leftMargin = cin.O000000o((Context) this, 14.0f);
        this.tvBack.setPadding(10, 10, 10, 10);
        this.tvBack.setLayoutParams(layoutParams2);
        this.tvBack.setBackgroundResource(R.drawable.camera_tittlebar_back_white);
        this.tvBack.setVisibility(8);
        this.mFLTitleBar.addView(this.tvBack);
        this.tvBack.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$fRY0xhL0mvk8KqZEeawUH2nyLmg */

            public final void onClick(View view) {
                SDCardPlayerExActivity.this.lambda$initEditView$3$SDCardPlayerExActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$initEditView$2$SDCardPlayerExActivity(View view) {
        SDCardHourAdapter sDCardHourAdapter = this.sdCardVideoAdapter;
        if (sDCardHourAdapter != null) {
            if (sDCardHourAdapter.getSelectCount() < this.sdCardVideoAdapter.getItemCount()) {
                this.tvSelectAll.setBackgroundResource(R.drawable.camera_edit_deselect_all_white);
                this.sdCardVideoAdapter.selectAll();
            } else {
                this.tvSelectAll.setBackgroundResource(R.drawable.camera_edit_select_all_white);
                this.sdCardVideoAdapter.unSelectAll();
            }
            refreshSelectTitle();
        }
    }

    public /* synthetic */ void lambda$initEditView$3$SDCardPlayerExActivity(View view) {
        this.sdCardVideoAdapter.unSelectAll();
        this.sdCardVideoAdapter.setMultiSelectMode(false);
        hideEditView();
        refreshSelectTitle();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    private void showEditView() {
        this.title_bar_more.setVisibility(8);
        this.title_bar_return.setVisibility(8);
        this.tvSelectAll.setVisibility(0);
        this.tvBack.setVisibility(0);
        this.llSelectBottom.setVisibility(0);
        this.rvHistoryVideoList.getHeight();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.rvHistoryVideoList.getHeight() - cin.O000000o((Context) this, 67.0f));
        layoutParams.addRule(3, this.mVideoViewFrame.getId());
        this.rvHistoryVideoList.setLayoutParams(layoutParams);
    }

    public void hideEditView() {
        this.title_bar_more.setVisibility(0);
        this.title_bar_return.setVisibility(0);
        this.tvSelectAll.setVisibility(8);
        this.tvBack.setVisibility(8);
        this.llSelectBottom.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, this.mVideoViewFrame.getId());
        this.rvHistoryVideoList.setLayoutParams(layoutParams);
        refreshSelectTitle();
    }

    public void onPause() {
        if (this.mCameraPlayerEx != null && this.mCameraDevice.O0000oOO()) {
            this.mCameraPlayerEx.O00000Oo(false);
        }
        super.onPause();
        chr.O0000OOo();
        CardView cardView = this.cvFuncPopup;
        if (cardView != null && cardView.getVisibility() != 8) {
            this.cvFuncPopup.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_snap_shot_out));
            this.cvFuncPopup.setVisibility(8);
        }
    }

    public void onDestroy() {
        if (this.mVideoView != null) {
            this.mVideoView.release();
            this.mVideoView = null;
        }
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O0000O0o();
        }
        SDCardHourAdapter sDCardHourAdapter = this.sdCardVideoAdapter;
        if (sDCardHourAdapter != null) {
            sDCardHourAdapter.destroyDisplayImageOptions();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        chr.O0000O0o();
        if (!(this.mCameraDevice == null || this.title_bar_more == null || !this.mCameraDevice.isReadOnlyShared())) {
            this.title_bar_more.setVisibility(4);
        }
        if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O0000o0O) {
            this.mCameraPlayerEx.O000000o(false);
        }
    }

    public void doResume() {
        if (this.mUserPause && this.cdcTogglePlay.isChecked()) {
            return;
        }
        if (this.mProgress.getProgress() > this.mDuration) {
            setPlayTime(0);
        } else {
            setPlayTime(this.mProgress.getProgress());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void refreshUI() {
        if (this.mCameraDevice.O000000o().O000000o("power", true)) {
            if (this.mPowerOffView.getVisibility() == 0) {
                this.mPowerOffView.setVisibility(8);
                startPlay();
            }
        } else if (this.mPowerOffView.getVisibility() == 8) {
            this.mPowerOffView.setVisibility(0);
        }
        if (this.mCameraPlayerEx == null) {
            return;
        }
        if (!this.mCameraPlayerEx.O0000o0O) {
            this.cdcToggleAudio.setChecked(true);
        } else {
            this.cdcToggleAudio.setChecked(false);
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i != 2) {
            if (i == 1001) {
                this.mSeekBarTouched = false;
                if (this.mProgress.getProgress() >= this.mDuration) {
                    this.mHandler.removeMessages(2);
                    pauseCamera();
                } else if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O00000Oo()) {
                    setPlayTime(this.mProgress.getProgress(), new IMISSListener() {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass5 */

                        public void onProgress(int i) {
                        }

                        public void onSuccess(String str, Object obj) {
                            if (SDCardPlayerExActivity.this.isFinishing()) {
                            }
                        }

                        public void onFailed(int i, String str) {
                            if (!SDCardPlayerExActivity.this.isFinishing()) {
                                SDCardPlayerExActivity.this.runOnUiThread(new Runnable() {
                                    /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$5$mNMMco_KmrvyLpV7yA9HPsVRhCw */

                                    public final void run() {
                                        SDCardPlayerExActivity.AnonymousClass5.this.lambda$onFailed$0$SDCardPlayerExActivity$5();
                                    }
                                });
                            }
                        }

                        public /* synthetic */ void lambda$onFailed$0$SDCardPlayerExActivity$5() {
                            SDCardPlayerExActivity.this.hideLoading();
                        }
                    });
                }
            } else if (i == 4000) {
                this.mNeedSpeed = false;
                this.mTimeUpdateView.setVisibility(8);
            }
        } else if (this.mCameraPlayerEx != null) {
            long j = this.mCameraPlayerEx.O0000o0o;
            if (this.mLastUpdateTime == j || this.mSeekBarTouched) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
            } else if (Math.abs(j - ((long) this.mStartTime)) > 61) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
            } else {
                this.mLastUpdateTime = j;
                int i2 = (int) (j - (this.mTimeItem.f5243O000000o / 1000));
                if (this.mIsSetTime) {
                    if (Math.abs(this.mLastOffsetTime - i2) <= 3 || System.currentTimeMillis() - this.mLastSetTime > 6000) {
                        this.mIsSetTime = false;
                        hideLoading();
                    } else {
                        this.mHandler.removeMessages(2);
                        this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
                        return;
                    }
                }
                if (i2 < 0) {
                    this.mProgress.setProgress(1);
                } else {
                    int i3 = this.mDuration;
                    if (i2 > i3) {
                        this.mProgress.setProgress(i3);
                        this.mDate.setTime(this.mTimeItem.O00000o0);
                        this.mProgressStart.setText(this.mSimpleDateFormat.format(this.mDate));
                        return;
                    } else if (i2 > this.mProgress.getProgress()) {
                        this.mProgress.setProgress(i2);
                    }
                }
                this.mDate.setTime(this.mTimeItem.f5243O000000o + ((long) (this.mProgress.getProgress() * 1000)));
                this.mProgressStart.setText(this.mSimpleDateFormat.format(this.mDate));
                this.mHandler.removeMessages(2);
                this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
            }
        }
    }

    public void startPlay() {
        if (TextUtils.isEmpty(this.mCameraDevice.getModel()) || TextUtils.isEmpty(this.mCameraDevice.getDid())) {
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$ykm6NfL3L1bPJm3XQXOpP4JIv8Y */

                public final void run() {
                    SDCardPlayerExActivity.this.lambda$startPlay$4$SDCardPlayerExActivity();
                }
            });
            return;
        }
        if (this.mCameraPlayerEx == null) {
            this.mCameraPlayerEx = new chw(this, this.mCameraDevice, this, this.mVideoView);
            chw chw = this.mCameraPlayerEx;
            if ("isa.camera.hlc6".equals(chw.O0000Oo0.getModel())) {
                chw.O0000ooO = true;
            }
            this.mCameraPlayerEx.O0000O0o = this.mIRecodeTimeListener;
        }
        if (mg.O00000o0(this) && !this.mAllowMobileNetwork) {
            pauseCamera();
        } else if (this.mCameraPlayerEx.O00000oO.isConnected()) {
            setPlayTime(0, new IMISSListener() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass6 */

                public void onProgress(int i) {
                }

                public void onSuccess(String str, Object obj) {
                    if (SDCardPlayerExActivity.this.isFinishing()) {
                    }
                }

                public void onFailed(int i, String str) {
                    if (!SDCardPlayerExActivity.this.isFinishing()) {
                        SDCardPlayerExActivity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$6$tIDnxAiVJnpF5aGBZVG7IO89ifk */

                            public final void run() {
                                SDCardPlayerExActivity.AnonymousClass6.this.lambda$onFailed$0$SDCardPlayerExActivity$6();
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onFailed$0$SDCardPlayerExActivity$6() {
                    SDCardPlayerExActivity.this.hideLoading();
                }
            });
        } else {
            showLoading();
            chw chw2 = this.mCameraPlayerEx;
            AnonymousClass7 r3 = new IMISSListener() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass7 */

                public void onProgress(int i) {
                }

                public void onSuccess(String str, Object obj) {
                    if (SDCardPlayerExActivity.this.isFinishing()) {
                    }
                }

                public void onFailed(int i, String str) {
                    if (!SDCardPlayerExActivity.this.isFinishing()) {
                        SDCardPlayerExActivity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$7$7UOVCTG1JwqhsLtD17My9zYPB88 */

                            public final void run() {
                                SDCardPlayerExActivity.AnonymousClass7.this.lambda$onFailed$0$SDCardPlayerExActivity$7();
                            }
                        });
                        gsy.O000000o(6, "SDCardPlayerExActivity", "SDCardPlayerExActivity startConnect onFailed:" + i + " " + str);
                        SDCardPlayerExActivity sDCardPlayerExActivity = SDCardPlayerExActivity.this;
                        sDCardPlayerExActivity.showError(sDCardPlayerExActivity.getString(R.string.video_play_failed));
                    }
                }

                public /* synthetic */ void lambda$onFailed$0$SDCardPlayerExActivity$7() {
                    SDCardPlayerExActivity.this.hideLoading();
                }
            };
            chw2.O00000oO.setClientListener(chw2);
            MIStreamStatistic.getInstance().latestCameraConnect = System.currentTimeMillis();
            chw2.O00000oO.setAutoVideo(false);
            chw2.O00000oO.setAutoAudio(false);
            chw2.O00000oO.streamStart(r3);
        }
        if (this.mCameraDevice.O0000oOO()) {
            this.mCameraPlayerEx.O00000Oo(true);
        }
    }

    public /* synthetic */ void lambda$startPlay$4$SDCardPlayerExActivity() {
        hideLoading();
        showError(getString(R.string.camera_play_error2));
    }

    public void onStop() {
        super.onStop();
    }

    public void resumeCamera() {
        this.mPauseView.setVisibility(8);
        int progress = this.mProgress.getProgress();
        if (progress >= this.mDuration) {
            setPlayTime(0);
            this.mProgress.setProgress(0);
        } else {
            setPlayTime(progress);
        }
        if (mg.O00000o0(this)) {
            this.mAllowMobileNetwork = true;
        }
        refreshUI();
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
    }

    public void onClick(View view) {
        doOnClick(view);
        if (view.getId() == R.id.tvsMultiSpeed) {
            toggleSpeed();
        } else if (view.getId() == R.id.ivFullScreen) {
            if (this.mFullScreen) {
                setOrientation(false);
            } else {
                setOrientation(true);
            }
        } else if (view.getId() == R.id.ivCameraShot) {
            snapShot();
        } else if (view.getId() == R.id.title_bar_more) {
            if (this.mCameraDevice.isReadOnlyShared()) {
                gqg.O000000o((int) R.string.auth_fail_read_only);
                return;
            }
            if (!this.sdCardVideoAdapter.mIsMultiSelectMode) {
                this.sdCardVideoAdapter.setMultiSelectMode(true);
            }
            showEditView();
        } else if (view.getId() == R.id.tvSelectSave) {
            saveSDCardFile();
        } else if (view.getId() == R.id.select_down) {
            if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                getContext();
                gqg.O000000o((int) R.string.no_write_permission);
                return;
            }
            initProgressDlg();
            ArrayList<TimeItem> selectItems = this.sdCardVideoAdapter.getSelectItems();
            if (selectItems.size() != 0) {
                for (TimeItem O00000o0 : selectItems) {
                    this.mDownloadSdCardFileManager.O00000o0(O00000o0);
                }
                this.mDownloadSdCardFileManager.O000000o();
                this.mProgressDialog.setCanceledOnTouchOutside(false);
                this.mProgressDialog.setMessage(getString(R.string.cs_downloading));
                this.mProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$2IfJjXt94N4q05leB6oRlcsFhDU */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        SDCardPlayerExActivity.this.lambda$onClick$5$SDCardPlayerExActivity(dialogInterface);
                    }
                });
                this.mProgressDialog.show();
                refreshData();
                this.sdCardVideoAdapter.unSelectAll();
                this.sdCardVideoAdapter.setMultiSelectMode(false);
                hideEditView();
                refreshSelectTitle();
            }
        } else if (view.getId() == R.id.tvSelectDelete) {
            deleteSDCardFile();
        }
    }

    public /* synthetic */ void lambda$onClick$5$SDCardPlayerExActivity(DialogInterface dialogInterface) {
        this.mProgressDialog.setOnDismissListener(null);
        this.mDownloadSdCardFileManager.O00000o = true;
    }

    public void onBackPressed() {
        SDCardHourAdapter sDCardHourAdapter = this.sdCardVideoAdapter;
        if (sDCardHourAdapter != null && sDCardHourAdapter.mIsMultiSelectMode) {
            this.sdCardVideoAdapter.unSelectAll();
            this.sdCardVideoAdapter.setMultiSelectMode(false);
            hideEditView();
        } else if (this.mFullScreen) {
            exitFullScreen(this.mCameraDevice.getModel());
        } else {
            super.onBackPressed();
        }
    }

    public void setPlayTime(int i) {
        int i2 = i + 2;
        cki.O00000o0("SDCardPlayerExActivity", "setPlayTime %d", Integer.valueOf(i2));
        int i3 = this.mDuration;
        if (i2 == i3) {
            i2 = i3 - 2;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        this.mLastSetTime = System.currentTimeMillis();
        this.mIsSetTime = true;
        this.mLastOffsetTime = i2;
        if (this.mPauseView.getVisibility() == 0) {
            this.mPauseView.setVisibility(8);
        }
        this.mUserPause = false;
        this.cdcTogglePlay.setOnCheckedChangeListener(null);
        this.cdcTogglePlay.setChecked(false);
        this.cdcTogglePlay.setOnCheckedChangeListener(this.mPlayOnCheckedChangeListener);
        if (this.mCameraPlayerEx != null) {
            hidError();
            showLoading();
            if (!TextUtils.isEmpty(this.mCameraDevice.getModel()) && "isa.camera.hlc6".equalsIgnoreCase(this.mCameraDevice.getModel())) {
                this.mCameraPlayerEx.O00000o0(true);
                if (this.cdcToggleAudio.isChecked()) {
                    this.mCameraPlayerEx.O000000o(false);
                } else {
                    this.mCameraPlayerEx.O000000o(true);
                }
            }
            if (this.mCameraDevice.O0000oOO()) {
                this.mCameraPlayerEx.O0000OOo();
                this.mCameraPlayerEx.O00000Oo(true);
            }
            this.mCameraPlayerEx.O000000o(this.mStartTime, i2, this.mEndTime, new IMISSListener() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass8 */

                public void onProgress(int i) {
                }

                public void onSuccess(String str, Object obj) {
                    if (!SDCardPlayerExActivity.this.isFinishing()) {
                        SDCardPlayerExActivity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$8$Y0hHOPlfsqpCpn0UVSNMon4GubE */

                            public final void run() {
                                SDCardPlayerExActivity.AnonymousClass8.this.lambda$onSuccess$0$SDCardPlayerExActivity$8();
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onSuccess$0$SDCardPlayerExActivity$8() {
                    SDCardPlayerExActivity.this.hideLoading();
                }

                public void onFailed(int i, String str) {
                    if (!SDCardPlayerExActivity.this.isFinishing()) {
                        SDCardPlayerExActivity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$8$bQUCS3FgEjErjg_co5Vv3hRHhg */

                            public final void run() {
                                SDCardPlayerExActivity.AnonymousClass8.this.lambda$onFailed$1$SDCardPlayerExActivity$8();
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onFailed$1$SDCardPlayerExActivity$8() {
                    SDCardPlayerExActivity.this.hideLoading();
                }
            });
        }
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
        gsy.O00000Oo("SDCardPlayerExActivity", "SDCardPlayer PlayTime " + this.mStartTime + " offset " + i2 + " end " + this.mEndTime);
    }

    private void setPlayTime(int i, IMISSListener iMISSListener) {
        cki.O00000o0("SDCardPlayerExActivity", "setPlayTimeWithListener %d", Integer.valueOf(i));
        int i2 = this.mDuration;
        if (i == i2) {
            i = i2 - 2;
        }
        if (i < 0) {
            i = 0;
        }
        this.mLastSetTime = System.currentTimeMillis();
        this.mIsSetTime = true;
        this.mLastOffsetTime = i;
        if (this.mPauseView.getVisibility() == 0) {
            this.mPauseView.setVisibility(8);
        }
        this.mUserPause = false;
        this.cdcTogglePlay.setOnCheckedChangeListener(null);
        this.cdcTogglePlay.setChecked(false);
        this.cdcTogglePlay.setOnCheckedChangeListener(this.mPlayOnCheckedChangeListener);
        if (this.mCameraPlayerEx != null) {
            hidError();
            showLoading();
            if (!TextUtils.isEmpty(this.mCameraDevice.getModel()) && "isa.camera.hlc6".equalsIgnoreCase(this.mCameraDevice.getModel())) {
                this.mCameraPlayerEx.O00000o0(true);
            }
            this.mCameraPlayerEx.O000000o(this.mStartTime, i, this.mEndTime, iMISSListener);
        }
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
    }

    public void onServerCmd(int i, byte[] bArr) {
        String optString;
        char c;
        if (!isFinishing() && i == 270) {
            gsy.O00000Oo("SDCardPlayerExActivity", "onServerCmd thread " + Thread.currentThread());
            try {
                String str = new String(bArr);
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("id", -1);
                civ.O00000o0("CameraPlay", "id ".concat(str));
                if (optInt == this.mStartTime && (optString = jSONObject.optString("status", null)) != null) {
                    switch (optString.hashCode()) {
                        case -1897432978:
                            if (optString.equals("endoffile")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1309954170:
                            if (optString.equals("filefound")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1107950030:
                            if (optString.equals("readerror")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 250180107:
                            if (optString.equals("filenotfound")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c == 0) {
                        int optInt2 = jSONObject.optInt("duration", -1);
                        if (optInt2 > 0 && this.mDuration != optInt2) {
                            this.mDuration = optInt2;
                            if (this.mProgress.getProgress() >= optInt2) {
                                this.mProgress.setProgress(optInt2);
                            }
                            this.mProgress.setMax(optInt2);
                            this.mEndTime = this.mStartTime + optInt2;
                        }
                    } else if (c == 1) {
                        hideLoading();
                        pauseCamera();
                        showError(getString(R.string.camera_play_error_file));
                    } else if (c == 2) {
                        this.mHandler.removeMessages(2);
                        pauseCamera();
                        this.mProgress.setProgress(0);
                    } else if (c == 3) {
                        hideLoading();
                        pauseCamera();
                        showError(getString(R.string.sd_read_fail));
                    }
                    civ.O00000o0("CameraPlay", " onServerCmd status ".concat(String.valueOf(optString)));
                }
            } catch (Exception e) {
                civ.O00000o0("CameraPlay", e.toString());
            }
        }
    }

    public void onConnected() {
        super.onConnected();
        if (this.cdcTogglePlay.isChecked()) {
            hideLoading();
        } else if (this.mProgress.getProgress() > this.mDuration) {
            setPlayTime(0);
            this.mProgress.setProgress(0);
        } else {
            setPlayTime(this.mProgress.getProgress());
        }
        civ.O00000o0("CameraPlay", "SDCardPlayer reconnect");
    }

    private void loadData() {
        List<clu> list;
        clv O000000o2;
        List<TimeItem> arrayList = new ArrayList<>();
        if (this.mCameraDevice != null) {
            list = this.mCameraDevice.O00000o() ? this.mCameraSdcardFileManagerEx.O0000OOo() : this.mCameraSdcardFileManager.O0000OOo();
        } else {
            list = null;
        }
        int i = this.mDay;
        if (i >= 0 && i < list.size() && (O000000o2 = ((clu) list.get(this.mDay)).O000000o(this.mHour)) != null) {
            arrayList = O000000o2.O00000o0;
        }
        ArrayList arrayList2 = new ArrayList();
        for (TimeItem timeItem : arrayList) {
            TimeItemData timeItemData = new TimeItemData();
            timeItemData.timeItem = timeItem;
            timeItemData.title = this.sdfHHmm.format(Long.valueOf(timeItem.f5243O000000o)) + "-" + this.sdfHHmm.format(Long.valueOf(timeItem.O00000o0));
            timeItemData.subTitle = this.sdfMMdd.format(Long.valueOf(timeItem.f5243O000000o));
            timeItemData.localFile = this.mCameraDevice.O0000O0o().O000000o(timeItem.f5243O000000o);
            timeItemData.downloadItem = this.mDownloadSdCardFileManager.O000000o(timeItem);
            arrayList2.add(timeItemData);
        }
        this.mTimeItemDataList = arrayList2;
        if (this.mTimeItemDataList.size() > 0) {
            this.sdCardVideoAdapter.setData(this.mTimeItemDataList);
            this.sdCardVideoAdapter.notifyDataSetChanged();
        }
    }

    public void onDownloading(clo.O000000o o000000o, String str, int i) {
        runMainThread(new Runnable(o000000o) {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$JbyWvvpG3D34ffEvvVHqBhVP9wo */
            private final /* synthetic */ clo.O000000o f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SDCardPlayerExActivity.this.lambda$onDownloading$6$SDCardPlayerExActivity(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onDownloading$6$SDCardPlayerExActivity(clo.O000000o o000000o) {
        if (this.mNeedCheckList.contains(Long.valueOf(o000000o.f14088O000000o.f5243O000000o))) {
            for (int i = 0; i < this.mTimeItemDataList.size(); i++) {
                if (this.mTimeItemDataList.get(i).timeItem.equals(o000000o.f14088O000000o)) {
                    this.mTimeItemDataList.get(i).downloadItem = o000000o;
                    this.sdCardVideoAdapter.notifyItemChanged(i);
                    return;
                }
            }
        }
    }

    public void onDownloadSuccess(clo.O000000o o000000o, String str) {
        if (this.mNeedCheckList.contains(Long.valueOf(o000000o.f14088O000000o.f5243O000000o))) {
            runMainThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$htJX9tFBjyBlfOrfASsIhxbRqQ */

                public final void run() {
                    SDCardPlayerExActivity.this.lambda$onDownloadSuccess$7$SDCardPlayerExActivity();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onDownloadSuccess$7$SDCardPlayerExActivity() {
        disProgressDlg();
        refreshData();
    }

    public void onDownloadFailed(clo.O000000o o000000o, String str, int i, String str2) {
        if (this.mNeedCheckList.contains(Long.valueOf(o000000o.f14088O000000o.f5243O000000o))) {
            runMainThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$XcwO8I5IypZ52kHGjIDlhb91Ar4 */

                public final void run() {
                    SDCardPlayerExActivity.this.lambda$onDownloadFailed$8$SDCardPlayerExActivity();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onDownloadFailed$8$SDCardPlayerExActivity() {
        disProgressDlg();
        refreshData();
    }

    public void onRecyclerClick(View view) {
        if (this.sdCardVideoAdapter != null) {
            int childLayoutPosition = this.rvHistoryVideoList.getChildLayoutPosition(view);
            if (this.sdCardVideoAdapter.mIsMultiSelectMode) {
                if (childLayoutPosition >= 0 && childLayoutPosition < this.sdCardVideoAdapter.getItemCount()) {
                    this.sdCardVideoAdapter.selectToggle(childLayoutPosition);
                    refreshSelectTitle();
                    this.sdCardVideoAdapter.notifyItemChanged(childLayoutPosition);
                }
            } else if (this.sdCardVideoAdapter.selectedPos != childLayoutPosition) {
                this.sdCardVideoAdapter.setSelected(childLayoutPosition);
                doClickOtherItem(childLayoutPosition);
                this.sdCardVideoAdapter.notifyDataSetChanged();
            }
        }
    }

    public void doClickOtherItem(int i) {
        TimeItemData data = this.sdCardVideoAdapter.getData(i);
        if (data != null) {
            this.mStartTime = (int) (data.timeItem.f5243O000000o / 1000);
            this.mEndTime = (int) (data.timeItem.O00000o0 / 1000);
            this.mDuration = ((int) data.timeItem.O00000Oo) / 1000;
            this.mProgress.setMax(this.mDuration);
            this.mProgress.setProgress(0);
            this.mLastUpdateTime = 0;
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
            this.mTimeItem = data.timeItem;
            this.mDate.setTime(this.mTimeItem.f5243O000000o);
            this.mProgressStart.setText(this.mSimpleDateFormat.format(this.mDate));
            this.mDate.setTime(this.mTimeItem.O00000o0);
            this.mProgressEnd.setText(this.mSimpleDateFormat.format(this.mDate));
            this.mTitleView.setText(String.format("%s-%s", this.sdfHHmm.format(Long.valueOf(data.timeItem.f5243O000000o)), this.sdfHHmm.format(Long.valueOf(data.timeItem.O00000o0))));
            startPlay();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    /* access modifiers changed from: protected */
    public void setOrientation(boolean z) {
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            gqg.O000000o((int) R.string.power_off);
        } else if (z) {
            enterPadFullScreen();
            setRequestedOrientation(0);
            SDCardHourAdapter sDCardHourAdapter = this.sdCardVideoAdapter;
            if (sDCardHourAdapter != null && sDCardHourAdapter.mIsMultiSelectMode) {
                this.sdCardVideoAdapter.unSelectAll();
                this.sdCardVideoAdapter.setMultiSelectMode(false);
                hideEditView();
            }
        } else {
            setRequestedOrientation(1);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyy.O000000o(android.app.Activity, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity, boolean]
     candidates:
      _m_j.hyy.O000000o(android.app.Activity, int):void
      _m_j.hyy.O000000o(android.app.Activity, android.content.Intent):void
      _m_j.hyy.O000000o(android.app.Activity, android.content.res.Configuration):void
      _m_j.hyy.O000000o(android.app.Activity, java.lang.Runnable):void
      _m_j.hyy.O000000o(android.content.Intent, android.content.Intent):void
      _m_j.hyy.O000000o(android.content.Intent, boolean):void
      _m_j.hyy.O000000o(android.view.Window, android.widget.FrameLayout):void
      _m_j.hyy.O000000o(android.content.Context, java.lang.String):boolean
      _m_j.hyy.O000000o(android.app.Activity, boolean):void */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setWindow(configuration);
        if (this.mIsResumed) {
            this.mFullScreen = configuration.orientation != 1;
            if (hyy.O000000o()) {
                exz exz = exz.f15941O000000o;
                if (!exz.O000000o().contains(this.mCameraDevice.getModel())) {
                    this.mFullScreen = ((CameraBaseActivity) getContext()).getFullScreenThroughPad(this.mFullScreen);
                }
            }
            if (this.mFullScreen) {
                this.title_bar_more.setVisibility(8);
                this.rvHistoryVideoList.setVisibility(8);
                int O000000o2 = ckq.O000000o(this);
                this.llVideoViewBottomCtrl.setPadding(O000000o2, 0, O000000o2, 0);
                FrameLayout frameLayout = this.mFLTitleBar;
                frameLayout.setPadding(O000000o2, frameLayout.getPaddingTop(), O000000o2, 0);
                this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.mVideoView.setIsFull(true);
                this.ivFullScreen.setImageResource(R.drawable.camera_icon_fullscreen2_exit);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cvFuncPopup.getLayoutParams();
                layoutParams.leftMargin = O000000o2 + gpc.O000000o(20.0f);
                this.cvFuncPopup.setLayoutParams(layoutParams);
            } else {
                this.title_bar_more.setVisibility(0);
                this.rvHistoryVideoList.setVisibility(0);
                this.llVideoViewBottomCtrl.setPadding(0, 0, 0, 0);
                FrameLayout frameLayout2 = this.mFLTitleBar;
                frameLayout2.setPadding(0, frameLayout2.getPaddingTop(), 0, 0);
                this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, cin.O000000o((Context) this, 350.0f)));
                this.mVideoView.setIsFull(false);
                this.ivFullScreen.setImageResource(R.drawable.camera_icon_fullscreen2);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cvFuncPopup.getLayoutParams();
                layoutParams2.leftMargin = gpc.O000000o(20.0f);
                this.cvFuncPopup.setLayoutParams(layoutParams2);
            }
            hyy.O000000o((Activity) this, this.mFullScreen);
        }
    }

    private void toggleSpeed() {
        if (this.mCameraPlayerEx == null) {
            return;
        }
        if (this.mCameraPlayerEx.O000000o()) {
            int i = this.mCameraPlayerEx.O0000oo;
            civ.O000000o("SDCardPlayerExActivity", "speed:".concat(String.valueOf(i)));
            int i2 = 16;
            if (i == 1) {
                i2 = 4;
            } else if (i != 4) {
                i2 = 1;
            }
            chw chw = this.mCameraPlayerEx;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("speed", i2);
                jSONObject.put("sessionid", chw.O0000oo0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            chw.O00000oO.streamPlaybackSpeed(jSONObject.toString(), new IMISSListener(i2) {
                /* class _m_j.chw.AnonymousClass10 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ int f13853O000000o;

                public final void onProgress(int i) {
                }

                {
                    this.f13853O000000o = r2;
                }

                public final void onSuccess(String str, Object obj) {
                    gsy.O00000Oo("CameraPlayerEx", "streamPlaybackSpeed onSuccess:" + str + " " + obj);
                    chw.this.O0000oo = this.f13853O000000o;
                }

                public final void onFailed(int i, String str) {
                    gsy.O00000Oo("CameraPlayerEx", "streamPlaybackSpeed onFailed:" + i + " " + str);
                }
            });
            if (i2 == 1) {
                this.cdcToggleAudio.setEnabled(true);
            } else {
                if (this.cdcToggleAudio.isChecked()) {
                    this.cdcToggleAudio.performClick();
                }
                this.cdcToggleAudio.setEnabled(false);
            }
            TextViewS textViewS = this.tvsMultiSpeed;
            textViewS.setText(i2 + "X");
            return;
        }
        gqg.O000000o((int) R.string.sd_card_video_not_playing);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    private void snapShot() {
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            gqg.O000000o((int) R.string.power_off);
        } else if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
        } else if (this.mCameraDevice == null || this.mCameraDevice.O000000o() == null || !this.mCameraDevice.O000000o().O000000o("power", true)) {
            gqg.O000000o((int) R.string.power_off);
        } else if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O00000oO.isConnected()) {
            gqg.O000000o((int) R.string.snap_failed_paused);
        } else {
            this.mVideoView.snap(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$i__6HDCmsxB6qymcGLT5SGAdc */

                public final void onSnap(Bitmap bitmap) {
                    SDCardPlayerExActivity.this.lambda$snapShot$10$SDCardPlayerExActivity(bitmap);
                }
            });
        }
    }

    public /* synthetic */ void lambda$snapShot$10$SDCardPlayerExActivity(Bitmap bitmap) {
        goq.O000000o(new Runnable(bitmap) {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$cIWFUq5FPkfi43nGoCNmnk85r9M */
            private final /* synthetic */ Bitmap f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SDCardPlayerExActivity.this.lambda$null$9$SDCardPlayerExActivity(this.f$1);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    /* access modifiers changed from: package-private */
    /* renamed from: onSnapShot */
    public void lambda$null$9$SDCardPlayerExActivity(Bitmap bitmap) {
        String O000000o2 = me.O000000o(false, this.mCameraDevice.getDid());
        if (O000000o2 != null && bitmap != null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap);
            if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                createBitmap = C0118cif.O000000o(createBitmap, this);
            }
            if (createBitmap != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(O000000o2);
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException unused) {
                    return;
                }
            }
            int O000000o3 = gpc.O000000o(100.0f);
            runOnUiThread(new Runnable(O000000o2, Bitmap.createScaledBitmap(createBitmap, O000000o3, (createBitmap.getHeight() * O000000o3) / createBitmap.getWidth(), false)) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$OyarbolGRNHxxToG0Okaa8kcg */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ Bitmap f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SDCardPlayerExActivity.this.lambda$onSnapShot$12$SDCardPlayerExActivity(this.f$1, this.f$2);
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    public /* synthetic */ void lambda$onSnapShot$12$SDCardPlayerExActivity(String str, Bitmap bitmap) {
        if (new File(str).exists()) {
            ImageView imageView = (ImageView) findViewById(R.id.ivShotPic);
            if (this.cvFuncPopup.getVisibility() == 0) {
                this.cvFuncPopup.setVisibility(8);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cvFuncPopup.getLayoutParams();
            layoutParams.topMargin = this.llVideoViewBottomCtrl.getHeight() + cin.O000000o((Context) this, 55.0f);
            this.cvFuncPopup.setLayoutParams(layoutParams);
            this.cvFuncPopup.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_snap_shot_in));
            this.cvFuncPopup.setVisibility(0);
            dismissSnapshotPopupRunnable(3000);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            ContentValues contentValues = new ContentValues(4);
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("_data", str);
            contentValues.put("mime_type", "image/jpeg");
            try {
                if (!Build.MODEL.equals("HM 1SC")) {
                    getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                }
                civ.O000000o("SDCardPlayerExActivity", "snap success");
            } catch (Throwable unused) {
            }
            clj.O000000o O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str);
            if (O00000Oo != null) {
                imageView.setOnClickListener(new View.OnClickListener(O00000Oo) {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$M7QjcXZ5ZcaQDC_zTmN1CHIOTpk */
                    private final /* synthetic */ clj.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        SDCardPlayerExActivity.this.lambda$null$11$SDCardPlayerExActivity(this.f$1, view);
                    }
                });
            }
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
    public /* synthetic */ void lambda$null$11$SDCardPlayerExActivity(clj.O000000o o000000o, View view) {
        dismissSnapshotPopupRunnable(0);
        Intent intent = new Intent(this, LocalPicActivity.class);
        intent.putExtra("noScroll", true);
        intent.putExtra("file_path", o000000o.O00000o);
        startActivity(intent);
    }

    public /* synthetic */ void lambda$new$13$SDCardPlayerExActivity() {
        if (this.cvFuncPopup.getVisibility() != 8) {
            this.cvFuncPopup.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_snap_shot_out));
            this.cvFuncPopup.setVisibility(8);
        }
    }

    private void dismissSnapshotPopupRunnable(long j) {
        this.mHandler.removeCallbacks(this.dismissRunnable);
        this.mHandler.postDelayed(this.dismissRunnable, j);
    }

    public void doStopRecord() {
        if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O0000o0) {
            chw chw = this.mCameraPlayerEx;
            AnonymousClass9 r1 = new XmMp4Record.IRecordListener() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass9 */

                public void onSuccess(String str) {
                    SDCardPlayerExActivity.this.tvRecordTimer.setVisibility(8);
                    SDCardPlayerExActivity.this.onVideoRecorded(str);
                }

                public void onFailed(int i, String str) {
                    civ.O000000o("SDCardPlayerExActivity", "error:" + i + " info:" + str);
                    SDCardPlayerExActivity.this.tvRecordTimer.setVisibility(8);
                    gqg.O000000o((int) R.string.snip_video_failed);
                }
            };
            gsy.O00000Oo("CameraPlayerEx", "stopRecord");
            chw.O0000o0 = false;
            if (chw.O0000o00 == null) {
                r1.onFailed(-1, "");
                return;
            }
            chw.O0000o00.stopRecord(r1);
            chw.O0000o00 = null;
            int i = ((cid) chw.O0000Oo0).O00000oO().O0000o00;
            if (chw.O00000oO != null) {
                chw.O00000oO.streamResolution(i, null);
            }
        }
    }

    public void upDateTimeTitle(String str) {
        this.tvRecordTimer.setText(str);
    }

    public void onVideoRecorded(String str) {
        File file = new File(str);
        if (file.exists()) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            clj.O000000o O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str);
            if (O00000Oo != null && this.mVideoView != null) {
                this.mVideoView.snap(new XmVideoViewGl.PhotoSnapCallback(O00000Oo) {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$b0_i5aqda3o8zUalPqAmnCsl860 */
                    private final /* synthetic */ clj.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onSnap(Bitmap bitmap) {
                        SDCardPlayerExActivity.this.lambda$onVideoRecorded$16$SDCardPlayerExActivity(this.f$1, bitmap);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onVideoRecorded$16$SDCardPlayerExActivity(clj.O000000o o000000o, Bitmap bitmap) {
        int O000000o2 = gpc.O000000o(100.0f);
        if (bitmap != null) {
            runOnUiThread(new Runnable(Bitmap.createScaledBitmap(bitmap, O000000o2, (bitmap.getHeight() * O000000o2) / bitmap.getWidth(), false), o000000o) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$5M88E8vwouvY0U5MxC22BWb08Pw */
                private final /* synthetic */ Bitmap f$1;
                private final /* synthetic */ clj.O000000o f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SDCardPlayerExActivity.this.lambda$null$15$SDCardPlayerExActivity(this.f$1, this.f$2);
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    public /* synthetic */ void lambda$null$15$SDCardPlayerExActivity(Bitmap bitmap, clj.O000000o o000000o) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) findViewById(R.id.ivShotPic);
            imageView.setImageBitmap(bitmap);
            if (this.cvFuncPopup.getVisibility() == 0) {
                this.cvFuncPopup.setVisibility(8);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cvFuncPopup.getLayoutParams();
            layoutParams.topMargin = this.llVideoViewBottomCtrl.getHeight() + cin.O000000o((Context) this, 55.0f);
            this.cvFuncPopup.setLayoutParams(layoutParams);
            this.cvFuncPopup.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_snap_shot_in));
            this.cvFuncPopup.setVisibility(0);
            dismissSnapshotPopupRunnable(3000);
            imageView.setOnClickListener(new View.OnClickListener(o000000o) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$6Pcs4wGDGy6ZjD9ucy_os0tf1T8 */
                private final /* synthetic */ clj.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    SDCardPlayerExActivity.this.lambda$null$14$SDCardPlayerExActivity(this.f$1, view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$14$SDCardPlayerExActivity(clj.O000000o o000000o, View view) {
        dismissSnapshotPopupRunnable(0);
        Intent intent = new Intent(this, LocalPicActivity.class);
        intent.putExtra("file_path", o000000o.O00000o);
        startActivity(intent);
    }

    public void refreshSelectTitle() {
        if (this.sdCardVideoAdapter != null) {
            String str = this.sdfHHmm.format(Long.valueOf(this.mTimeItem.f5243O000000o)) + "-" + this.sdfHHmm.format(Long.valueOf(this.mTimeItem.O00000o0));
            int selectCount = this.sdCardVideoAdapter.getSelectCount();
            if (this.sdCardVideoAdapter.mIsMultiSelectMode) {
                if (selectCount == 0) {
                    this.mTitleView.setText(str);
                } else {
                    this.mTitleView.setText(getString(R.string.select_title_2, new Object[]{Integer.valueOf(selectCount)}));
                }
                if (selectCount == 0 || selectCount != this.sdCardVideoAdapter.getItemCount()) {
                    this.tvSelectAll.setBackgroundResource(R.drawable.camera_edit_select_all_white);
                } else {
                    this.tvSelectAll.setBackgroundResource(R.drawable.camera_edit_deselect_all_white);
                }
            } else {
                this.mTitleView.setText(str);
            }
        }
    }

    private void saveSDCardFile() {
        ArrayList<TimeItem> selectItems = this.sdCardVideoAdapter.getSelectItems();
        initProgressDlg();
        cih.O00000Oo(this, this.mCameraDevice, selectItems, this.mProgressDialog, new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass10 */

            public void onSuccess(Void voidR) {
                if (!SDCardPlayerExActivity.this.isFinishing()) {
                    SDCardPlayerExActivity.this.runMainThread(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$10$kHtbkw7eBOlCnizLIHi9q8aImak */

                        public final void run() {
                            SDCardPlayerExActivity.AnonymousClass10.this.lambda$onSuccess$0$SDCardPlayerExActivity$10();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$SDCardPlayerExActivity$10() {
                izb.O000000o(SDCardPlayerExActivity.this, (int) R.string.save_sucess, 0).show();
                SDCardPlayerExActivity.this.disProgressDlg();
                SDCardPlayerExActivity.this.hideEditView();
                SDCardPlayerExActivity.this.sdCardVideoAdapter.setMultiSelectMode(false);
                SDCardPlayerExActivity.this.refreshSelectTitle();
                SDCardPlayerExActivity.this.refreshData();
            }

            public void onFailure(int i, String str) {
                if (!SDCardPlayerExActivity.this.isFinishing()) {
                    SDCardPlayerExActivity.this.runMainThread(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$10$iHk7uW1Md4TU_rMlWmUSky8NI0 */

                        public final void run() {
                            SDCardPlayerExActivity.AnonymousClass10.this.lambda$onFailure$1$SDCardPlayerExActivity$10();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$1$SDCardPlayerExActivity$10() {
                SDCardPlayerExActivity.this.disProgressDlg();
                SDCardPlayerExActivity.this.hideEditView();
                SDCardPlayerExActivity.this.refreshSelectTitle();
                izb.O000000o(SDCardPlayerExActivity.this, (int) R.string.save_failed, 0).show();
            }
        });
    }

    private void deleteSDCardFile() {
        ArrayList<TimeItem> selectItems = this.sdCardVideoAdapter.getSelectItems();
        initProgressDlg();
        cih.O000000o(this, this.mCameraDevice, selectItems, this.mProgressDialog, new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardPlayerExActivity.AnonymousClass11 */

            public void onSuccess(Void voidR) {
                if (!SDCardPlayerExActivity.this.isFinishing()) {
                    SDCardPlayerExActivity.this.runMainThread(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$11$nXEe07SPMlJyMkmtakpn7pgfD8Y */

                        public final void run() {
                            SDCardPlayerExActivity.AnonymousClass11.this.lambda$onSuccess$0$SDCardPlayerExActivity$11();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$SDCardPlayerExActivity$11() {
                SDCardPlayerExActivity.this.disProgressDlg();
                SDCardPlayerExActivity.this.hideEditView();
                izb.O000000o(SDCardPlayerExActivity.this, (int) R.string.delete_sucess, 0).show();
                SDCardPlayerExActivity.this.sdCardVideoAdapter.setMultiSelectMode(false);
                SDCardPlayerExActivity.this.refreshSelectTitle();
                SDCardPlayerExActivity.this.refreshData();
                SDCardPlayerExActivity sDCardPlayerExActivity = SDCardPlayerExActivity.this;
                sDCardPlayerExActivity.doClickOtherItem(sDCardPlayerExActivity.sdCardVideoAdapter.selectedPos);
            }

            public void onFailure(int i, String str) {
                if (!SDCardPlayerExActivity.this.isFinishing()) {
                    SDCardPlayerExActivity.this.runMainThread(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardPlayerExActivity$11$GZWTWykYaCCCp56GjZWyN3_Cs7g */

                        public final void run() {
                            SDCardPlayerExActivity.AnonymousClass11.this.lambda$onFailure$1$SDCardPlayerExActivity$11();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$1$SDCardPlayerExActivity$11() {
                SDCardPlayerExActivity.this.disProgressDlg();
                SDCardPlayerExActivity.this.hideEditView();
                SDCardPlayerExActivity.this.refreshSelectTitle();
                izb.O000000o(SDCardPlayerExActivity.this, (int) R.string.delete_failed, 0).show();
            }
        });
    }

    public void initProgressDlg() {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new XQProgressDialog(this);
        }
    }

    public void disProgressDlg() {
        XQProgressDialog xQProgressDialog = this.mProgressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    public void refreshData() {
        List<clu> list;
        int i;
        if (this.mCameraDevice.O00000o()) {
            list = this.mCameraDevice.O0000Oo0().O0000OOo();
        } else {
            list = this.mCameraDevice.O0000OOo().O0000OOo();
        }
        if (list == null || (i = this.mDay) < 0 || i >= list.size()) {
            this.mTimeItemList = new ArrayList();
        } else {
            clv O000000o2 = ((clu) list.get(this.mDay)).O000000o(this.mHour);
            if (O000000o2 != null) {
                this.mTimeItemList = O000000o2.O00000o0;
            } else {
                this.mTimeItemList = new ArrayList();
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.mTimeItemList.size(); i2++) {
            TimeItem timeItem = this.mTimeItemList.get(i2);
            TimeItemData timeItemData = new TimeItemData();
            timeItemData.timeItem = timeItem;
            timeItemData.title = this.sdfHHmm.format(Long.valueOf(timeItem.f5243O000000o)) + "-" + this.sdfHHmm.format(Long.valueOf(timeItem.O00000o0));
            timeItemData.subTitle = this.mSimpleDateFormat.format(Long.valueOf(timeItem.f5243O000000o));
            timeItemData.localFile = this.mCameraDevice.O0000O0o().O000000o(timeItem.f5243O000000o);
            timeItemData.downloadItem = this.mDownloadSdCardFileManager.O000000o(timeItem);
            arrayList.add(timeItemData);
            this.mNeedCheckList.add(Long.valueOf(timeItem.f5243O000000o));
        }
        this.mTimeItemDataList = arrayList;
        if (this.mTimeItemDataList.isEmpty()) {
            this.rvHistoryVideoList.setVisibility(8);
            super.onBackPressed();
        } else {
            this.rvHistoryVideoList.setVisibility(0);
        }
        this.sdCardVideoAdapter.setData(this.mTimeItemDataList);
        if (this.sdCardVideoAdapter.selectedPos >= this.sdCardVideoAdapter.getItemCount()) {
            SDCardHourAdapter sDCardHourAdapter = this.sdCardVideoAdapter;
            sDCardHourAdapter.setSelected(sDCardHourAdapter.selectedPos - 1);
        }
        this.sdCardVideoAdapter.notifyDataSetChanged();
        this.rvHistoryVideoList.scrollToPosition(this.sdCardVideoAdapter.selectedPos);
    }

    public void pauseCamera() {
        super.pauseCamera();
        this.cdcTogglePlay.setChecked(true);
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O0000OOo();
        }
    }
}
