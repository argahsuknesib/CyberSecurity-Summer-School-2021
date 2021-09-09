package com.xiaomi.smarthome.camera.activity.sdcard.fragment;

import _m_j.C0118cif;
import _m_j.chr;
import _m_j.chx;
import _m_j.cia;
import _m_j.cib;
import _m_j.cid;
import _m_j.cin;
import _m_j.civ;
import _m_j.ciw;
import _m_j.ciy;
import _m_j.cjg;
import _m_j.cjh;
import _m_j.cki;
import _m_j.ckq;
import _m_j.cky;
import _m_j.clj;
import _m_j.clm;
import _m_j.cls;
import _m_j.dty;
import _m_j.ft;
import _m_j.fta;
import _m_j.ftn;
import _m_j.fvk;
import _m_j.fvm;
import _m_j.gkv;
import _m_j.goq;
import _m_j.gpc;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.grv;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.hyy;
import _m_j.me;
import _m_j.mg;
import _m_j.mi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import com.Utils.NetworkMonitor;
import com.google.android.gms.common.ConnectionResult;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardCloudVideoActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment;
import com.xiaomi.smarthome.camera.activity.sdcard.view.FlowLayout;
import com.xiaomi.smarthome.camera.v4.utils.CameraToastUtil;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView2;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineWithDatePickView2;
import com.xiaomi.smarthome.camera.view.widget.CenterDrawableCheckBox;
import com.xiaomi.smarthome.camera.view.widget.MultiStateView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

public class SDCardTimeLineFragment extends fvm implements cia, fvk.O000000o, View.OnClickListener {
    public static final String TAG = "SDCardTimeLineFragment";
    public int HideToolsDaly = 5000;
    private final long LIMIT_CONNECT_TIME = 120000;
    private final int RETRY_TIME = 90000;
    private int UPDATE_DURATION = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    private String UPDATE_ING = "";
    Animation alphaIn;
    Animation alphaOut;
    private LinearLayout bottom_ctrl_ll;
    private TextView cb_area_move;
    private TextView cb_baby_cry;
    private TextView cb_face;
    private TextView cb_people_move;
    public CenterDrawableCheckBox cdcCameraRecord;
    public CheckBox cdcCameraRecord_land;
    private CenterDrawableCheckBox cdcToggleAudio;
    private CheckBox cdcToggleAudio_land;
    private ImageView cdcTogglePlay;
    private boolean curChecked = false;
    public boolean curCordChecked = false;
    private int currentVideoHeight = 0;
    protected Runnable delayedReconnectRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass18 */

        public void run() {
            if (SDCardTimeLineFragment.this.mCameraPlayerEx != null) {
                SDCardTimeLineFragment.this.mCameraPlayerEx.O0000o0O();
            }
        }
    };
    private FrameLayout flTopCtrlLandscape;
    private Runnable hideScaleTvR = new Runnable() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$8L7oUIkuXXY8W9kySMHZx_ms1pA */

        public final void run() {
            SDCardTimeLineFragment.this.lambda$new$10$SDCardTimeLineFragment();
        }
    };
    Runnable hideTools = new Runnable() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$gfeLIqV7X07Ur3lw_6NCl2VZLyM */

        public final void run() {
            SDCardTimeLineFragment.this.lambda$new$12$SDCardTimeLineFragment();
        }
    };
    View inflated;
    public boolean is4GToWifi = false;
    public boolean isChangeNetworkType = false;
    private boolean isForeground;
    boolean isFromRN = false;
    private boolean isInEnding = false;
    private boolean isOffline = false;
    private boolean isOnFileEnd;
    private boolean isShowing = true;
    protected boolean isTimeLapsePhotography = false;
    boolean isVideoPlaying = true;
    private ImageView ivCameraShot;
    private ImageView ivCameraShot_land;
    private ImageView ivFullScreen;
    private ImageView iv_back_landscape;
    private View land_layout;
    private CardView llFuncPopup;
    private LinearLayout llVideoViewBottomCtrl;
    protected boolean mAllowMobileNetwork = false;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass3 */

        public void onReceive(Context context, Intent intent) {
            SDCardTimeLineFragment.this.mCameraDevice.O0000Oo0();
            if ("com.mijia.camera.SdcardManagerEx".equals(intent.getAction()) && !((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                civ.O000000o(SDCardTimeLineFragment.TAG, "mBroadcastReceiver update time items");
                SDCardTimeLineFragment.this.mTimeLineControlView.setTimeItems(SDCardTimeLineFragment.this.mCameraDevice.O0000Oo0().O00000oo());
                if (!SDCardTimeLineFragment.this.mUserPause && SDCardTimeLineFragment.this.mCameraPlayerEx != null && !SDCardTimeLineFragment.this.mCameraPlayerEx.O0000Ooo()) {
                    SDCardTimeLineFragment.this.startPlay();
                }
            }
        }
    };
    CheckBox mCBMuteLandscape;
    CheckBox mCBVoiceLandscape;
    protected cid mCameraDevice;
    public cjg mCameraPlayerEx;
    private cls mCameraSdcardExFileManager;
    public long mConnectStartTime = 0;
    public boolean mConnected = false;
    private int mCurrentRecordTime = 0;
    public int mCurrentTime = 0;
    private int mDuration;
    public long mEmptyTime = 0;
    private int mEndTime;
    protected TextView mErrorInfoView;
    protected View mErrorRetryView;
    TextView mFrameRate;
    protected boolean mFullScreen;
    public Handler mHandler;
    protected XmMp4Record.IRecordTimeListener mIRecodeTimeListener = new XmMp4Record.IRecordTimeListener() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$wp2Q073CyNqEniMZIXhee1ljw */

        public final void upDateTime(int i) {
            SDCardTimeLineFragment.this.lambda$new$29$SDCardTimeLineFragment(i);
        }
    };
    private boolean mIsSetPlayTime;
    private boolean mIsSetTime = false;
    LinearLayout mLLRightCtrlLandscape;
    MultiStateView mLandCallView;
    private int mLastOffsetTime = 0;
    private long mLastSetPlayTime;
    private long mLastSetTime = 0;
    public int mLastTime = 0;
    private long mLastUpdateTime = 0;
    protected AnimationDrawable mLoadingAnimation;
    protected ImageView mLoadingImageView;
    protected TextView mLoadingProgress;
    protected TextView mLoadingTitle;
    protected View mLoadingView;
    private ft mLocalBroadcastManager;
    protected boolean mNeedPincode = false;
    protected boolean mNeedSpeed = false;
    boolean mNeedTry = false;
    protected NetworkMonitor mNetworkMonitor = NetworkMonitor.O000000o();
    NetworkMonitor.O000000o mOnNetworkChange = new NetworkMonitor.O000000o() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass2 */

        public void onDisconnected(int i) {
            if (SDCardTimeLineFragment.this.mCameraDevice.O00000o() && SDCardTimeLineFragment.this.mCameraPlayerEx != null) {
                SDCardTimeLineFragment.this.pauseCamera();
                SDCardTimeLineFragment.this.mCameraPlayerEx.O0000o0o();
            }
            SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
            sDCardTimeLineFragment.showError(sDCardTimeLineFragment.getString(R.string.common_net_error));
        }

        public void onConnected(int i) {
            if ((!SDCardTimeLineFragment.this.is4GToWifi || SDCardTimeLineFragment.this.isHistory()) && ((mg.O00000o0(SDCardTimeLineFragment.this.mContext) && !SDCardTimeLineFragment.this.mAllowMobileNetwork) || SDCardTimeLineFragment.this.mUserPause)) {
                SDCardTimeLineFragment.this.hidError();
                SDCardTimeLineFragment.this.pauseCamera();
            } else if (SDCardTimeLineFragment.this.mCameraPlayerEx != null && SDCardTimeLineFragment.this.mConnected) {
                SDCardTimeLineFragment.this.hidError();
                SDCardTimeLineFragment.this.doResume();
            } else if (SDCardTimeLineFragment.this.mCameraPlayerEx != null && SDCardTimeLineFragment.this.isChangeNetworkType) {
                SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
                sDCardTimeLineFragment.isChangeNetworkType = false;
                sDCardTimeLineFragment.hidError();
                SDCardTimeLineFragment.this.doResume();
            }
        }

        public void onConnecting(int i) {
            if (SDCardTimeLineFragment.this.mCameraDevice.O00000o() && SDCardTimeLineFragment.this.mCameraPlayerEx != null) {
                SDCardTimeLineFragment.this.pauseCamera();
                SDCardTimeLineFragment.this.mCameraPlayerEx.O0000o0o();
            }
        }

        public void onChange(int i) {
            if (SDCardTimeLineFragment.this.mCameraPlayerEx != null && SDCardTimeLineFragment.this.mCameraPlayerEx.O0000o0() && SDCardTimeLineFragment.this.mCameraDevice != null && SDCardTimeLineFragment.this.mCameraDevice.O00000o()) {
                SDCardTimeLineFragment.this.pauseCamera();
                SDCardTimeLineFragment.this.mCameraPlayerEx.O0000o0o();
            }
            SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
            sDCardTimeLineFragment.isChangeNetworkType = true;
            if (i == 1) {
                sDCardTimeLineFragment.is4GToWifi = true;
            } else {
                sDCardTimeLineFragment.is4GToWifi = false;
            }
        }
    };
    public ImageView mPauseView;
    private View mPlayerHint1;
    private View mPlayerHint2;
    protected boolean mPowerCheck = false;
    protected View mPowerOffView;
    private int mProgress = 0;
    protected clm.O000000o mPropertyChangeListener = new clm.O000000o() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass1 */

        public void onPropertyChanged(dty dty, HashSet<String> hashSet) {
            SDCardTimeLineFragment.this.mHandler.post(new Runnable(hashSet) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$1$yc1BoBUphnhCfRts3Ey_MQaR8As */
                private final /* synthetic */ HashSet f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SDCardTimeLineFragment.AnonymousClass1.this.lambda$onPropertyChanged$0$SDCardTimeLineFragment$1(this.f$1);
                }
            });
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
         arg types: [java.lang.String, int]
         candidates:
          _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
          _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
          _m_j.cll.O000000o(java.lang.String, boolean):boolean */
        public /* synthetic */ void lambda$onPropertyChanged$0$SDCardTimeLineFragment$1(HashSet hashSet) {
            if (hashSet.contains("power")) {
                civ.O000000o("CameraPlay", "power change:".concat(String.valueOf(hashSet)));
                if ((mg.O00000Oo(SDCardTimeLineFragment.this.mContext) || (mg.O00000o0(SDCardTimeLineFragment.this.mContext) && SDCardTimeLineFragment.this.mAllowMobileNetwork)) && SDCardTimeLineFragment.this.mCameraDevice.O000000o().O000000o("power", true) && SDCardTimeLineFragment.this.mCameraPlayerEx != null && !SDCardTimeLineFragment.this.mCameraPlayerEx.O0000Ooo()) {
                    SDCardTimeLineFragment.this.doResume();
                }
                SDCardTimeLineFragment.this.refreshUI();
            } else if (hashSet.contains("only_wifi")) {
                SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
                sDCardTimeLineFragment.mAllowMobileNetwork = !sDCardTimeLineFragment.mCameraDevice.O00000oO().O0000o0;
            }
        }
    };
    public int mPwdCount = 5;
    public int mRetryCount = 0;
    protected ImageView mRetryView;
    private View mSeeAllVieo;
    public boolean mSeekBarTouched = false;
    private int mSelectTime;
    protected boolean mShowView = false;
    private SimpleDateFormat mSimpleDateFormat;
    private int mStartTime;
    protected float mSurfaceViewOffsetX = 0.0f;
    protected float mSurfaceViewOffsetY = 0.0f;
    protected float mSurfaceViewScale = 1.0f;
    public TextView mTVRecordTimer;
    private TimeLineControlView2.TimeLineCallback mTimeCallBack = new TimeLineControlView2.TimeLineCallback() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass14 */

        public void onChangeTime(long j) {
        }

        public void onUpdateTime(long j) {
            SDCardTimeLineFragment.this.mTimeUpdateView.setText(mi.O000000o(j));
            if (SDCardTimeLineFragment.this.mNeedSpeed) {
                SDCardTimeLineFragment.this.mHandler.removeMessages(4000);
                SDCardTimeLineFragment.this.mNeedSpeed = false;
            }
            if (SDCardTimeLineFragment.this.mTimeUpdateView.getVisibility() != 0) {
                SDCardTimeLineFragment.this.mTimeUpdateView.setVisibility(0);
            }
            SDCardTimeLineFragment.this.mHandler.removeCallbacks(SDCardTimeLineFragment.this.hideTools);
        }

        public void onSelectTime(long j) {
            if (j != 0) {
                SDCardTimeLineFragment.this.mHandler.removeMessages(2);
            }
            SDCardTimeLineFragment.this.startPlayVideoWithCheckConnection(j, true);
            SDCardTimeLineFragment.this.mTimeUpdateView.setVisibility(8);
            SDCardTimeLineFragment.this.mHandler.removeCallbacks(SDCardTimeLineFragment.this.hideTools);
            SDCardTimeLineFragment.this.mHandler.postDelayed(SDCardTimeLineFragment.this.hideTools, (long) SDCardTimeLineFragment.this.HideToolsDaly);
        }

        public void onPlayLive() {
            SDCardTimeLineFragment.this.toSdFilesEnd();
            SDCardTimeLineFragment.this.mTimeUpdateView.setVisibility(8);
        }

        public void onCancel() {
            if (SDCardTimeLineFragment.this.mTimeUpdateView.getVisibility() == 0) {
                SDCardTimeLineFragment.this.mTimeUpdateView.setVisibility(8);
            }
        }
    };
    private TimeItem mTimeItem;
    public TimeLineWithDatePickView2 mTimeLineControlView;
    public TextView mTimeUpdateView;
    private boolean mUpdating = false;
    protected boolean mUserPause = false;
    protected FrameLayout mVideoLayout;
    protected cjh mVideoView;
    protected FrameLayout mVideoViewFrame;
    private String md5Name;
    protected TextView offline_time;
    private TextView pet_move;
    protected TextView retry_tv;
    private FrameLayout root;
    private View rootView;
    boolean sdcardGetSuccess = false;
    int sdcardStatus = 0;
    protected TextView see_help;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm", Locale.getDefault());
    private long startPlayTimeStamp = 0;
    private FrameLayout time_line_land;
    private TextView tvShortPlay;
    private ImageView tvsMultiSpeed;
    private ImageView tvsMultiSpeed_land;
    private TextView video_scale_tv;

    public boolean canStepOut(int i, int i2) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void doStopCall() {
    }

    public boolean isHistory() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean shouldRecordPlayTime() {
        return false;
    }

    public void setData(cid cid, Handler handler) {
        this.mCameraDevice = cid;
        this.mHandler = handler;
    }

    public void setSDCardStatus(boolean z, int i) {
        this.sdcardGetSuccess = z;
        this.sdcardStatus = i;
    }

    public void setFromRN(boolean z) {
        this.isFromRN = z;
    }

    public void updateSDCardStatus(boolean z, int i) {
        this.sdcardGetSuccess = z;
        this.sdcardStatus = i;
        if (!z || i == 1 || i == 5) {
            if (this.inflated == null) {
                if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
                    this.inflated = ((ViewStub) this.rootView.findViewById(R.id.no_sdcard_layout022)).inflate();
                    ((TextView) this.inflated.findViewById(R.id.storage_time_content1)).setText(getString(R.string.storage_hour_quality_content, 40));
                    ((TextView) this.inflated.findViewById(R.id.storage_time_content2)).setText(getString(R.string.storage_day_quality_content, "3.5"));
                    ((TextView) this.inflated.findViewById(R.id.storage_time_content3)).setText(getString(R.string.storage_day_quality_content, "7"));
                    ((TextView) this.inflated.findViewById(R.id.storage_time_content4)).setText(getString(R.string.storage_day_quality_content, "14"));
                    ((TextView) this.inflated.findViewById(R.id.storage_time_content5)).setText(getString(R.string.storage_day_quality_content, "28"));
                } else {
                    this.inflated = ((ViewStub) this.rootView.findViewById(R.id.no_sdcard_layout)).inflate();
                }
            }
            this.inflated.findViewById(R.id.title_bar_layout).setVisibility(8);
            this.inflated.findViewById(R.id.tv_buy).setVisibility(8);
            this.rootView.findViewById(R.id.play_back_layout).setVisibility(8);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        civ.O000000o(TAG, "onCreateView");
        if (this.rootView == null) {
            this.rootView = LayoutInflater.from(getContext()).inflate((int) R.layout.camera_fragment_sdcard_tab, viewGroup, false);
            doCreate();
        }
        this.alphaIn = AnimationUtils.loadAnimation(getContext(), R.anim.alpha_in);
        this.alphaOut = AnimationUtils.loadAnimation(getContext(), R.anim.alpha_out);
        return this.rootView;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        civ.O000000o(TAG, "onCreate");
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        civ.O000000o(TAG, "onHiddenChanged = ".concat(String.valueOf(z)));
        this.isShowing = !z;
        if (this.isShowing) {
            onResume();
        } else {
            onPause();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        civ.O000000o(TAG, "setUserVisibleHint = ".concat(String.valueOf(z)));
    }

    public void onDestroy() {
        super.onDestroy();
        civ.O000000o(TAG, "onDestroy");
        this.mConnectStartTime = 0;
        cid cid = this.mCameraDevice;
        if (cid != null) {
            cid.O00000Oo().O00000Oo(this.mPropertyChangeListener);
        }
        NetworkMonitor networkMonitor = this.mNetworkMonitor;
        if (networkMonitor != null) {
            networkMonitor.O00000Oo();
        }
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null) {
            cjg.O000000o(true);
        }
        cjh cjh = this.mVideoView;
        if (cjh != null) {
            cjh.O0000OOo();
        }
    }

    private int getScreenWidth() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            intent = null;
        } else {
            intent = activity.getIntent();
        }
        return hyy.O00000Oo(intent).widthPixels;
    }

    /* access modifiers changed from: protected */
    public void doCreate() {
        cki.O00000o(TAG, "doCreate");
        cid cid = this.mCameraDevice;
        if (cid == null || !cid.O00000o()) {
            gqg.O000000o((int) R.string.action_fail);
            getActivity().finish();
            return;
        }
        this.md5Name = grv.O000000o(this.mCameraDevice.getModel() + this.mCameraDevice.getDid());
        this.currentVideoHeight = (int) (((float) getScreenWidth()) / 1.78f);
        this.mAllowMobileNetwork = this.mCameraDevice.O00000oO().O0000o0 ^ true;
        this.UPDATE_ING = getResources().getString(R.string.update_ing);
        initView();
        this.mCameraSdcardExFileManager = this.mCameraDevice.O0000Oo0();
        this.mNetworkMonitor.O000000o(this.mContext);
        showLoading(null);
        updateSDCardStatus(this.sdcardGetSuccess, this.sdcardStatus);
    }

    private void showViews() {
        this.mPlayerHint1.setVisibility(8);
        this.mPlayerHint2.setVisibility(8);
        if (this.mFullScreen) {
            this.mSeeAllVieo.setVisibility(8);
        } else {
            this.mSeeAllVieo.setVisibility(0);
        }
        this.mTimeLineControlView.setVisibility(0);
        this.llVideoViewBottomCtrl.setVisibility(0);
    }

    private void switchPlayBtnStatus() {
        if (this.isVideoPlaying) {
            this.isVideoPlaying = false;
            pauseCamera();
            this.mUserPause = true;
        } else {
            this.isVideoPlaying = true;
            cjg cjg = this.mCameraPlayerEx;
            if (cjg == null || !cjg.O0000Ooo()) {
                this.mUserPause = false;
                startPlay();
            } else {
                return;
            }
        }
        changePlayBtnBg(this.isVideoPlaying);
    }

    private void changePlayBtnBg(boolean z) {
        if (this.cdcTogglePlay.getVisibility() != 0) {
            this.cdcTogglePlay.setVisibility(0);
        }
        if (z) {
            ImageView imageView = this.mPauseView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.cdcTogglePlay.setImageResource(R.drawable.camera_icon_pause02_nor);
            this.mPauseView.setImageResource(R.drawable.camera_icon_center_play2);
            return;
        }
        ImageView imageView2 = this.mPauseView;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        this.cdcTogglePlay.setImageResource(R.drawable.camera_icon_play_nor);
        this.mPauseView.setImageResource(R.drawable.camera_icon_center_pause);
    }

    private void initOtherView() {
        this.mSeeAllVieo = this.rootView.findViewById(R.id.see_all_video);
        this.mPlayerHint1 = this.rootView.findViewById(R.id.play_hint_1);
        this.mPlayerHint2 = this.rootView.findViewById(R.id.play_hint_2);
        this.mSeeAllVieo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$XZJ_bp8FvHKF7pzDVhCtgxb5dI4 */

            public final void onClick(View view) {
                SDCardTimeLineFragment.this.lambda$initOtherView$0$SDCardTimeLineFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initOtherView$0$SDCardTimeLineFragment(View view) {
        hxi.O00000o.O00000o(!TextUtils.isEmpty(this.mCameraDevice.getModel()) ? this.mCameraDevice.getModel() : "", "sdcard");
        if (this.mCameraSdcardExFileManager.O00000oo() == null || this.mCameraSdcardExFileManager.O00000oo().size() <= 0) {
            getContext();
            gqg.O000000o((int) R.string.action_fail);
        } else if (DeviceConstant.supportNewPlayBack(this.mCameraDevice.getModel())) {
            getActivity().startActivity(new Intent(getActivity(), SDCard2Activity.class));
        } else {
            getActivity().startActivity(new Intent(getActivity(), SDCardActivity.class));
        }
    }

    private void initTimeSelectView() {
        this.mLocalBroadcastManager = ft.O000000o(this.mContext);
        this.mTimeLineControlView = (TimeLineWithDatePickView2) this.rootView.findViewById(R.id.time_line_date_pick);
        this.mTimeLineControlView.synCurrentTime(System.currentTimeMillis());
        this.mTimeLineControlView.setTimeLineCallback(this.mTimeCallBack);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float */
    private void initView() {
        this.video_scale_tv = (TextView) this.rootView.findViewById(R.id.video_scale_tv);
        this.tvShortPlay = (TextView) this.rootView.findViewById(R.id.tvShortPlay);
        this.mPauseView = (ImageView) this.rootView.findViewById(R.id.pause_view);
        this.mPauseView.setOnClickListener(this);
        this.mLLRightCtrlLandscape = (LinearLayout) this.rootView.findViewById(R.id.llRightCtrlLandscape);
        this.flTopCtrlLandscape = (FrameLayout) this.rootView.findViewById(R.id.flTopCtrlLandscape);
        this.iv_back_landscape = (ImageView) this.rootView.findViewById(R.id.iv_back_landscape);
        this.iv_back_landscape.setOnClickListener(this);
        this.land_layout = this.rootView.findViewById(R.id.land_layout);
        this.mSimpleDateFormat = new SimpleDateFormat("mm:ss");
        this.mSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        this.cdcCameraRecord = (CenterDrawableCheckBox) this.rootView.findViewById(R.id.cdcCameraRecord);
        this.cdcCameraRecord_land = (CheckBox) this.rootView.findViewById(R.id.cdcCameraRecord_land);
        this.mTVRecordTimer = (TextView) this.rootView.findViewById(R.id.tvRecordTimer);
        this.cdcCameraRecord.setVisibility(0);
        this.root = (FrameLayout) this.rootView.findViewById(R.id.root);
        this.bottom_ctrl_ll = (LinearLayout) this.rootView.findViewById(R.id.bottom_ctrl_ll);
        this.time_line_land = (FrameLayout) this.rootView.findViewById(R.id.time_line_land);
        this.cb_people_move = (TextView) this.rootView.findViewById(R.id.cb_people_move);
        if (!DeviceConstant.isSupportPeopleMotion(this.mCameraDevice.getModel())) {
            ((FlowLayout) this.rootView.findViewById(R.id.ll_event_types)).removeView(this.cb_people_move);
        }
        this.cb_area_move = (TextView) this.rootView.findViewById(R.id.cb_area_move);
        this.cb_baby_cry = (TextView) this.rootView.findViewById(R.id.cb_baby_cry);
        if (!DeviceConstant.isSupportBabyCryNative(this.mCameraDevice.getModel())) {
            ((FlowLayout) this.rootView.findViewById(R.id.ll_event_types)).removeView(this.cb_baby_cry);
        }
        this.pet_move = (TextView) this.rootView.findViewById(R.id.pet_move);
        this.cb_face = (TextView) this.rootView.findViewById(R.id.cb_face);
        if (!"chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
            this.pet_move.setVisibility(8);
            this.cb_face.setVisibility(8);
        }
        this.ivCameraShot = (ImageView) this.rootView.findViewById(R.id.ivCameraShot);
        this.ivCameraShot_land = (ImageView) this.rootView.findViewById(R.id.ivCameraShot_land);
        this.ivCameraShot.setOnClickListener(this);
        this.ivCameraShot_land.setOnClickListener(this);
        this.llVideoViewBottomCtrl = (LinearLayout) this.rootView.findViewById(R.id.llVideoViewBottomCtrl);
        this.tvsMultiSpeed = (ImageView) this.rootView.findViewById(R.id.tvsMultiSpeed);
        this.tvsMultiSpeed_land = (ImageView) this.rootView.findViewById(R.id.tvsMultiSpeed_land);
        this.tvsMultiSpeed.setOnClickListener(this);
        this.tvsMultiSpeed_land.setOnClickListener(this);
        if (this.mCameraDevice.O0000oOO()) {
            this.tvsMultiSpeed.setVisibility(8);
            this.tvsMultiSpeed_land.setVisibility(8);
        }
        this.cdcToggleAudio = (CenterDrawableCheckBox) this.rootView.findViewById(R.id.cdcToggleAudio);
        this.cdcToggleAudio_land = (CheckBox) this.rootView.findViewById(R.id.cdcToggleAudio_land);
        $$Lambda$SDCardTimeLineFragment$8R5PBcxCFMduK8gVClxwR1xqf4 r0 = new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$8R5PBcxCFMduK8gVClxwR1xqf4 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SDCardTimeLineFragment.this.lambda$initView$1$SDCardTimeLineFragment(compoundButton, z);
            }
        };
        this.cdcToggleAudio_land.setOnCheckedChangeListener(r0);
        this.cdcToggleAudio.setOnCheckedChangeListener(r0);
        this.cdcTogglePlay = (ImageView) this.rootView.findViewById(R.id.cdcTogglePlay);
        this.cdcTogglePlay.setVisibility(8);
        this.mPauseView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$bjjrrbzMqfGtSAVj754I9t_PSw4 */

            public final void onClick(View view) {
                SDCardTimeLineFragment.this.lambda$initView$2$SDCardTimeLineFragment(view);
            }
        });
        this.rootView.findViewById(R.id.togglePlay).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$BKSd5z5K8Yekusrr03sLeib7lc */

            public final void onClick(View view) {
                SDCardTimeLineFragment.this.lambda$initView$3$SDCardTimeLineFragment(view);
            }
        });
        changePlayBtnBg(this.isVideoPlaying);
        this.ivFullScreen = (ImageView) this.rootView.findViewById(R.id.ivFullScreen);
        this.ivFullScreen.setOnClickListener(this);
        this.llFuncPopup = (CardView) this.rootView.findViewById(R.id.llFuncPopup);
        this.llFuncPopup.setOnClickListener(this);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.llFuncPopup.getLayoutParams();
        layoutParams.bottomMargin = cin.O000000o(this.mContext, 46.0f);
        this.llFuncPopup.setLayoutParams(layoutParams);
        this.mTimeUpdateView = (TextView) this.rootView.findViewById(R.id.time_container_center);
        this.mVideoViewFrame = (FrameLayout) this.rootView.findViewById(R.id.video_frame);
        this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.currentVideoHeight));
        this.mVideoLayout = new FrameLayout(this.mContext);
        this.mVideoViewFrame.addView(this.mVideoLayout, 0, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.mLoadingView = LayoutInflater.from(this.mContext).inflate((int) R.layout.camera_progress, (ViewGroup) null);
        this.mVideoViewFrame.addView(this.mLoadingView, layoutParams2);
        this.mLoadingView.setVisibility(8);
        this.mLoadingProgress = (TextView) this.mLoadingView.findViewById(R.id.loading_progress);
        this.mLoadingTitle = (TextView) this.mLoadingView.findViewById(R.id.loading_title);
        this.mLoadingImageView = (ImageView) this.mLoadingView.findViewById(R.id.loading_anim);
        this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_anim_camera_loading);
        this.mLoadingImageView.setImageDrawable(this.mLoadingAnimation);
        this.mErrorRetryView = LayoutInflater.from(this.mContext).inflate((int) R.layout.camera_error_retry, (ViewGroup) null);
        this.mVideoViewFrame.addView(this.mErrorRetryView, layoutParams2);
        this.mErrorRetryView.setVisibility(8);
        this.mRetryView = (ImageView) this.mErrorRetryView.findViewById(R.id.retry_btn);
        this.see_help = (TextView) this.mErrorRetryView.findViewById(R.id.see_help);
        this.see_help.setText((int) R.string.retry_network);
        this.see_help.setOnClickListener(this);
        this.see_help.setVisibility(0);
        this.mErrorInfoView = (TextView) this.mErrorRetryView.findViewById(R.id.error_info);
        this.mPowerOffView = LayoutInflater.from(this.mContext).inflate((int) R.layout.camera_closed_v4, (ViewGroup) null);
        this.mVideoViewFrame.addView(this.mPowerOffView, layoutParams2);
        this.mPowerOffView.setVisibility(8);
        this.mCameraDevice.O00000Oo().O000000o(this.mPropertyChangeListener);
        this.mCameraDevice.O00000Oo().O000000o();
        this.mCameraDevice.O000000o().O000000o(chx.f13863O000000o, new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass4 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(Void voidR) {
                SDCardTimeLineFragment.this.refreshUI();
            }
        });
        initTimeSelectView();
        initOtherView();
        this.cb_people_move.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$GGc1a5hJedt5jWZ35k6fhUls */

            public final void onClick(View view) {
                SDCardTimeLineFragment.this.lambda$initView$4$SDCardTimeLineFragment(view);
            }
        });
        this.cb_area_move.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$eZVHIgZ9dKBzEmGPyoc16J2S0Ow */

            public final void onClick(View view) {
                SDCardTimeLineFragment.this.lambda$initView$5$SDCardTimeLineFragment(view);
            }
        });
        this.cb_face.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$_qxpcvxbB9rncdCJ48KuWAyHukU */

            public final void onClick(View view) {
                SDCardTimeLineFragment.this.lambda$initView$6$SDCardTimeLineFragment(view);
            }
        });
        this.cb_baby_cry.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$6eVlg_XuHybJnJ3E5wDR5iAESc */

            public final void onClick(View view) {
                SDCardTimeLineFragment.this.lambda$initView$7$SDCardTimeLineFragment(view);
            }
        });
        this.pet_move.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$ABThqVOkpVUH43IVUxAXOAPW8Y */

            public final void onClick(View view) {
                SDCardTimeLineFragment.this.lambda$initView$8$SDCardTimeLineFragment(view);
            }
        });
        AnonymousClass5 r02 = new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass5 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SDCardTimeLineFragment.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    return false;
                }
                CameraToastUtil.showPowerOffToast(SDCardTimeLineFragment.this.mCameraDevice.getModel(), SDCardTimeLineFragment.this.mContext, R.string.sleep_recode_error);
                return true;
            }
        };
        this.cdcCameraRecord.setOnTouchListener(r02);
        this.cdcCameraRecord_land.setOnTouchListener(r02);
        final Drawable drawable = getResources().getDrawable(R.drawable.home_icon_camera_recording_v4_new);
        final Drawable drawable2 = getResources().getDrawable(R.drawable.home_icon_camera_record_playback);
        AnonymousClass6 r3 = new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass6 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
             arg types: [int, java.lang.String]
             candidates:
              _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
              _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                civ.O000000o(SDCardTimeLineFragment.TAG, "mCDCCameraRecord:".concat(String.valueOf(z)));
                if (SDCardTimeLineFragment.this.curCordChecked != z) {
                    SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
                    sDCardTimeLineFragment.curCordChecked = z;
                    sDCardTimeLineFragment.cdcCameraRecord_land.setChecked(z);
                    chr.O000000o(chr.O000oO0O);
                    SDCardTimeLineFragment.this.onRecordStateChange(z);
                    if (z) {
                        SDCardTimeLineFragment.this.cdcCameraRecord.setBackground(drawable);
                        SDCardTimeLineFragment sDCardTimeLineFragment2 = SDCardTimeLineFragment.this;
                        sDCardTimeLineFragment2.mLastTime = 0;
                        sDCardTimeLineFragment2.mCurrentTime = 0;
                        String O000000o2 = me.O000000o(true, sDCardTimeLineFragment2.mCameraDevice.getDid());
                        if (SDCardTimeLineFragment.this.mCameraPlayerEx != null && !SDCardTimeLineFragment.this.mCameraPlayerEx.O0000Ooo()) {
                            SDCardTimeLineFragment.this.getContext();
                            gqg.O000000o((int) R.string.record_not_connect);
                            SDCardTimeLineFragment.this.cdcCameraRecord.setBackground(drawable2);
                            SDCardTimeLineFragment.this.cdcCameraRecord.setChecked(false);
                            SDCardTimeLineFragment.this.cdcCameraRecord_land.setChecked(false);
                        } else if (!XmPluginHostApi.instance().checkAndRequestPermisson(SDCardTimeLineFragment.this.getActivity(), true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                            SDCardTimeLineFragment.this.getContext();
                            gqg.O000000o((int) R.string.no_write_permission);
                            SDCardTimeLineFragment.this.cdcCameraRecord.setBackground(drawable2);
                            SDCardTimeLineFragment.this.cdcCameraRecord.setChecked(false);
                            SDCardTimeLineFragment.this.cdcCameraRecord_land.setChecked(false);
                        } else if (!TextUtils.isEmpty(O000000o2)) {
                            if (SDCardTimeLineFragment.this.mCameraPlayerEx != null) {
                                if ("mijia.camera.v3".equals(SDCardTimeLineFragment.this.mCameraDevice.getModel())) {
                                    SDCardTimeLineFragment.this.mCameraPlayerEx.O000000o(O000000o2, 1);
                                } else {
                                    SDCardTimeLineFragment.this.mCameraPlayerEx.O000000o(O000000o2, 2);
                                }
                                SDCardTimeLineFragment.this.mCameraPlayerEx.O00000Oo(true);
                            }
                            SDCardTimeLineFragment sDCardTimeLineFragment3 = SDCardTimeLineFragment.this;
                            sDCardTimeLineFragment3.upDateTimeTitle(cin.O000000o(sDCardTimeLineFragment3.mContext, 0));
                            SDCardTimeLineFragment.this.mTVRecordTimer.setVisibility(0);
                            civ.O000000o(SDCardTimeLineFragment.TAG, "startRecord");
                            chr.O0000oOO();
                        } else {
                            gqg.O000000o((int) R.string.snip_video_failed);
                        }
                    } else {
                        chr.O0000oOo();
                        SDCardTimeLineFragment.this.cdcCameraRecord.setBackground(drawable2);
                        SDCardTimeLineFragment.this.doStopRecord(true);
                    }
                }
            }
        };
        this.cdcCameraRecord.setOnCheckedChangeListener(r3);
        this.cdcCameraRecord_land.setOnCheckedChangeListener(r3);
        enableBottomTools(false);
        this.mVideoView = ciy.O000000o(this.mCameraDevice.getModel(), this.mVideoLayout);
        this.mVideoView.O00000Oo(6.0f, 6.0f);
        cid cid = this.mCameraDevice;
        if (cid != null && !TextUtils.isEmpty(cid.getModel()) && !TextUtils.isEmpty(this.mCameraDevice.getModel())) {
            this.mSurfaceViewScale = gpy.O000000o(gkv.f17949O000000o, this.md5Name, "scale_sdcard", 0.0f);
            this.mSurfaceViewOffsetX = gpy.O000000o(gkv.f17949O000000o, this.md5Name, "offsetX_sdcard", 0.0f);
            this.mSurfaceViewOffsetY = gpy.O000000o(gkv.f17949O000000o, this.md5Name, "offsetY_sdcard", 0.0f);
            String str = TAG;
            gsy.O00000Oo(str, "mSurfaceViewScale = " + this.mSurfaceViewScale);
            float f = this.mSurfaceViewScale;
            if (f > 0.0f) {
                this.mVideoView.O00000Oo(f);
            }
            this.mVideoView.O00000o0(this.mSurfaceViewOffsetX);
            this.mVideoView.O00000o(this.mSurfaceViewOffsetY);
        }
        this.mVideoView.O000000o(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$InA5_KCX7oStg1m6ZZYWB2IZdmk */

            public final void onVideoViewClick() {
                SDCardTimeLineFragment.this.lambda$initView$9$SDCardTimeLineFragment();
            }
        });
        this.mVideoView.O000000o(new XmVideoViewGl.OnScaleListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass7 */

            public void onScaleChage(float f) {
                if (SDCardTimeLineFragment.this.mVideoView.O00000o0() != 0.0f) {
                    float O00000o0 = SDCardTimeLineFragment.this.mVideoView.O00000o0();
                    SDCardTimeLineFragment.this.resetLeftTopTools();
                    float round = ((float) Math.round((f / O00000o0) * 10.0f)) / 10.0f;
                    String str = SDCardTimeLineFragment.TAG;
                    gsy.O00000Oo(str, "mSurfaceViewScaleX = " + f + ":" + round);
                    SDCardTimeLineFragment.this.showScale(round);
                }
            }

            public void onFirstVideoShow() {
                cki.O00000o(SDCardTimeLineFragment.TAG, "onFirstVideoShow");
                SDCardTimeLineFragment.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$7$rYHxy2YDHo6CzlpmFOHjHlSi00 */

                    public final void run() {
                        SDCardTimeLineFragment.AnonymousClass7.this.lambda$onFirstVideoShow$0$SDCardTimeLineFragment$7();
                    }
                });
            }

            public /* synthetic */ void lambda$onFirstVideoShow$0$SDCardTimeLineFragment$7() {
                if (SDCardTimeLineFragment.this.mSurfaceViewScale > 0.0f) {
                    String str = SDCardTimeLineFragment.TAG;
                    gsy.O00000Oo(str, "mSurfaceViewScale showScale = " + SDCardTimeLineFragment.this.mSurfaceViewScale);
                    SDCardTimeLineFragment.this.showScale((float) Math.round(SDCardTimeLineFragment.this.mSurfaceViewScale));
                }
            }
        });
    }

    public /* synthetic */ void lambda$initView$1$SDCardTimeLineFragment(CompoundButton compoundButton, boolean z) {
        civ.O000000o(TAG, "cdcToggleAudio isChecked:".concat(String.valueOf(z)));
        if (this.curChecked != z) {
            this.curChecked = z;
            cjg cjg = this.mCameraPlayerEx;
            if (cjg != null) {
                if (z) {
                    cjg.O00000o0(false);
                } else {
                    cjg.O00000o0(true);
                }
            }
            this.cdcToggleAudio_land.setChecked(this.curChecked);
            this.cdcToggleAudio.setChecked(this.curChecked);
        }
    }

    public /* synthetic */ void lambda$initView$2$SDCardTimeLineFragment(View view) {
        switchPlayBtnStatus();
    }

    public /* synthetic */ void lambda$initView$3$SDCardTimeLineFragment(View view) {
        switchPlayBtnStatus();
    }

    public /* synthetic */ void lambda$initView$4$SDCardTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.cb_people_move.isSelected();
        this.cb_people_move.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setPeopleMove(z);
    }

    public /* synthetic */ void lambda$initView$5$SDCardTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.cb_area_move.isSelected();
        this.cb_area_move.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setAreaMove(z);
    }

    public /* synthetic */ void lambda$initView$6$SDCardTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.cb_face.isSelected();
        this.cb_face.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setFace(z);
    }

    public /* synthetic */ void lambda$initView$7$SDCardTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.cb_baby_cry.isSelected();
        this.cb_baby_cry.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setBabyCry(z);
    }

    public /* synthetic */ void lambda$initView$8$SDCardTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.pet_move.isSelected();
        this.pet_move.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setPetMove(z);
    }

    public void showScale(float f) {
        this.video_scale_tv.setText(String.format(Locale.getDefault(), "%.1fx", Float.valueOf(f)));
        this.video_scale_tv.setVisibility(0);
        this.mHandler.removeCallbacks(this.hideScaleTvR);
        this.mHandler.postDelayed(this.hideScaleTvR, 3000);
    }

    public /* synthetic */ void lambda$new$10$SDCardTimeLineFragment() {
        if (this.video_scale_tv.getVisibility() == 0) {
            this.video_scale_tv.setVisibility(8);
        }
    }

    public void resetLeftTopTools() {
        this.video_scale_tv.setVisibility(8);
        this.llFuncPopup.clearAnimation();
        this.llFuncPopup.setVisibility(8);
    }

    public void enableBottomTools(boolean z) {
        if (!z || this.isVideoPlaying) {
            cjg cjg = this.mCameraPlayerEx;
            if (cjg == null || !cjg.O0000O0o()) {
                this.tvsMultiSpeed.setEnabled(z);
            } else {
                this.tvsMultiSpeed.setEnabled(false);
            }
            this.ivCameraShot.setEnabled(z);
            if (!this.cdcCameraRecord.isChecked()) {
                this.cdcCameraRecord.setEnabled(z);
            } else {
                this.cdcCameraRecord.setEnabled(true);
            }
            cjg cjg2 = this.mCameraPlayerEx;
            if (cjg2 == null || cjg2.O0000oOO() == 1) {
                this.cdcToggleAudio.setEnabled(z);
                this.cdcToggleAudio_land.setEnabled(z);
            } else {
                if (this.cdcToggleAudio.isChecked()) {
                    this.cdcToggleAudio.performClick();
                }
                this.cdcToggleAudio.setEnabled(false);
                this.cdcToggleAudio_land.setEnabled(false);
            }
            this.ivFullScreen.setEnabled(z);
        }
    }

    public void onRecordStateChange(boolean z) {
        if (this.isVideoPlaying) {
            this.tvsMultiSpeed.setEnabled(!z);
            this.tvsMultiSpeed_land.setEnabled(!z);
        } else {
            this.tvsMultiSpeed.setEnabled(false);
            this.tvsMultiSpeed_land.setEnabled(false);
        }
        this.mTimeLineControlView.setEnabled(!z);
        this.mSeeAllVieo.setEnabled(!z);
        this.time_line_land.setEnabled(!z);
    }

    public void onResume() {
        cjg cjg;
        super.onResume();
        if (!this.isShowing) {
            String str = TAG;
            civ.O000000o(str, "onResume isShowing=" + this.isShowing);
            return;
        }
        String str2 = TAG;
        civ.O000000o(str2, "onResume sdcardGetSuccess=" + this.sdcardGetSuccess + " sdcardStatus=" + this.sdcardStatus);
        chr.O00000oO();
        showLoading(null);
        this.mTimeLineControlView.setTimeItems(this.mCameraDevice.O0000Oo0().O00000oo());
        cjh cjh = this.mVideoView;
        if (cjh != null) {
            cjh.O000000o();
        }
        if (!this.mUserPause && (cjg = this.mCameraPlayerEx) != null && cjg.O0000o00()) {
            if (!mg.O00000o(this.mContext)) {
                pauseCamera();
                showError(getString(R.string.common_net_error));
            } else if (mg.O00000o0(this.mContext) && !this.mAllowMobileNetwork) {
                pauseCamera();
            } else if (this.mCameraDevice.deviceStat().isOnline) {
                doResume();
            }
        }
        this.mNetworkMonitor.O000000o(this.mOnNetworkChange);
        refreshUI();
        IntentFilter intentFilter = new IntentFilter();
        this.mCameraDevice.O0000Oo0();
        intentFilter.addAction("com.mijia.camera.SdcardManagerEx");
        this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver, intentFilter);
        showViews();
        if (!hyy.O000000o() && ciw.O000000o(getActivity().getRequestedOrientation())) {
            this.mFullScreen = true;
            this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            cjh cjh2 = this.mVideoView;
            if (cjh2 != null) {
                cjh2.O000000o(true);
            }
            this.mSeeAllVieo.setVisibility(8);
        }
        cjg cjg2 = this.mCameraPlayerEx;
        if (cjg2 != null) {
            cjg2.O00000o0(true);
            setMultiSpeed(this.mCameraPlayerEx.O0000oOO());
        } else {
            setMultiSpeed(1);
        }
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$J9gPaaFo7zAe19pcoyrrC9Gg2lw */

            public final void run() {
                SDCardTimeLineFragment.this.lambda$onResume$11$SDCardTimeLineFragment();
            }
        }, 500);
        startPlay();
        this.isForeground = true;
        dismissSnapshotPopupRunnable(3000);
    }

    public /* synthetic */ void lambda$onResume$11$SDCardTimeLineFragment() {
        this.mCameraDevice.O0000Oo0().O0000O0o();
        this.mCameraDevice.O0000Oo0().O000000o();
    }

    public /* synthetic */ void lambda$new$12$SDCardTimeLineFragment() {
        if (!this.isOnFileEnd && this.isVideoPlaying) {
            try {
                if (this.mFullScreen) {
                    if (this.time_line_land.getVisibility() == 0) {
                        showTools(false);
                    }
                } else if (this.bottom_ctrl_ll.getVisibility() == 0) {
                    showTools(false);
                }
            } catch (Exception e) {
                String str = TAG;
                cki.O00000o(str, "Exception:" + e.getLocalizedMessage());
            }
        }
    }

    private void showTools(boolean z) {
        if (this.mFullScreen) {
            if (z) {
                this.time_line_land.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_direction_view_in));
                this.time_line_land.setVisibility(0);
                this.flTopCtrlLandscape.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.anim_direction_view_in2));
                this.flTopCtrlLandscape.setVisibility(0);
                this.mLLRightCtrlLandscape.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.anim_ctrl_view_x_trans_in));
                this.mLLRightCtrlLandscape.setVisibility(0);
                if (this.mPauseView.getVisibility() != 0) {
                    this.alphaIn.setDuration(200);
                    this.mPauseView.startAnimation(this.alphaIn);
                    this.mPauseView.setVisibility(0);
                }
                this.mHandler.removeCallbacks(this.hideTools);
                this.mHandler.postDelayed(this.hideTools, (long) this.HideToolsDaly);
                return;
            }
            this.mHandler.removeCallbacks(this.hideTools);
            this.time_line_land.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_direction_view_out));
            this.time_line_land.setVisibility(4);
            this.flTopCtrlLandscape.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.anim_direction_view_out2));
            this.flTopCtrlLandscape.setVisibility(4);
            this.mLLRightCtrlLandscape.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.anim_ctrl_view_x_trans_out));
            this.mLLRightCtrlLandscape.setVisibility(8);
            if (this.mPauseView.getVisibility() == 0) {
                this.alphaOut.setDuration(200);
                this.mPauseView.startAnimation(this.alphaOut);
                this.mPauseView.setVisibility(8);
            }
        } else if (z) {
            this.bottom_ctrl_ll.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_direction_view_in));
            this.bottom_ctrl_ll.setVisibility(0);
            if (this.mPauseView.getVisibility() != 0) {
                this.alphaIn.setDuration(200);
                this.mPauseView.startAnimation(this.alphaIn);
                this.mPauseView.setVisibility(0);
            }
            this.mHandler.removeCallbacks(this.hideTools);
            this.mHandler.postDelayed(this.hideTools, (long) this.HideToolsDaly);
        } else {
            this.mHandler.removeCallbacks(this.hideTools);
            this.bottom_ctrl_ll.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_direction_view_out));
            this.bottom_ctrl_ll.setVisibility(4);
            if (this.mPauseView.getVisibility() == 0) {
                this.alphaOut.setDuration(200);
                this.mPauseView.startAnimation(this.alphaOut);
                this.mPauseView.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: toggleTools */
    public void lambda$initView$9$SDCardTimeLineFragment() {
        boolean z = true;
        if (this.mFullScreen) {
            if (this.time_line_land.getVisibility() == 0) {
                z = false;
            }
            showTools(z);
            return;
        }
        if (this.bottom_ctrl_ll.getVisibility() == 0) {
            z = false;
        }
        showTools(z);
    }

    private void setMultiSpeed(int i) {
        if (i == 1) {
            this.tvsMultiSpeed.setImageResource(R.drawable.playback_icon_1x);
            this.tvsMultiSpeed_land.setImageResource(R.drawable.playback_icon_1x);
        } else if (i == 2) {
            this.tvsMultiSpeed.setImageResource(R.drawable.playback_icon_2x);
            this.tvsMultiSpeed_land.setImageResource(R.drawable.playback_icon_2x);
        } else if (i == 4) {
            this.tvsMultiSpeed.setImageResource(R.drawable.playback_icon_4x);
            this.tvsMultiSpeed_land.setImageResource(R.drawable.playback_icon_4x);
        } else if (i == 16) {
            this.tvsMultiSpeed.setImageResource(R.drawable.playback_icon_16x);
            this.tvsMultiSpeed_land.setImageResource(R.drawable.playback_icon_16x);
        }
    }

    public void startPlayVideoWithCheckConnection(long j, boolean z) {
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null) {
            if (cjg.O0000Oo()) {
                startMissPlayback(j, z);
                return;
            }
            showLoading(null);
            this.mCameraPlayerEx.O00000Oo(new IXmConnectionClient.XmActionCallback() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass8 */

                public void onSuccess(String str, Object obj) {
                    if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                        SDCardTimeLineFragment.this.enableBottomTools(true);
                        SDCardTimeLineFragment.this.mHandler.removeCallbacks(SDCardTimeLineFragment.this.hideTools);
                        SDCardTimeLineFragment.this.mHandler.postDelayed(SDCardTimeLineFragment.this.hideTools, (long) SDCardTimeLineFragment.this.HideToolsDaly);
                    }
                }

                public void onFailed(int i, String str) {
                    if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                        SDCardTimeLineFragment.this.mHandler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$8$pr5rfBdFyKsORCyclBeq8xhaT8 */

                            public final void run() {
                                SDCardTimeLineFragment.AnonymousClass8.this.lambda$onFailed$0$SDCardTimeLineFragment$8();
                            }
                        });
                        String str2 = SDCardTimeLineFragment.TAG;
                        civ.O00000o0(str2, "SDCardTimeLinePlayerExActivity startStream(); onFailed:" + i + " " + str);
                        SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
                        sDCardTimeLineFragment.showError(sDCardTimeLineFragment.getString(R.string.video_play_failed));
                    }
                }

                public /* synthetic */ void lambda$onFailed$0$SDCardTimeLineFragment$8() {
                    SDCardTimeLineFragment.this.hideLoading();
                }
            });
        }
    }

    public void onClick(View view) {
        doOnClick(view);
        if (view.getId() == R.id.tvsMultiSpeed_land || view.getId() == R.id.tvsMultiSpeed) {
            cjg cjg = this.mCameraPlayerEx;
            if (cjg == null || cjg.O0000Ooo()) {
                toggleSpeed();
                return;
            }
            getContext();
            gqg.O000000o((int) R.string.operation_failed);
        } else if (view.getId() == R.id.iv_back_landscape) {
            if (this.mFullScreen && (getContext() instanceof cib)) {
                ((cib) getContext()).exitFullScreen(null);
            }
        } else if (view.getId() == R.id.ivFullScreen) {
            cjg cjg2 = this.mCameraPlayerEx;
            if (cjg2 == null || cjg2.O0000Ooo()) {
                ((SDCardCloudVideoActivity) this.mContext).setOrientation(true);
                return;
            }
            getContext();
            gqg.O000000o((int) R.string.operation_failed);
        } else if (view.getId() != R.id.ivCameraShot_land && view.getId() != R.id.ivCameraShot) {
        } else {
            if (!XmPluginHostApi.instance().checkAndRequestPermisson(getActivity(), true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                getContext();
                gqg.O000000o((int) R.string.no_write_permission);
                return;
            }
            cjg cjg3 = this.mCameraPlayerEx;
            if (cjg3 == null || cjg3.O0000Ooo()) {
                snapShot();
                return;
            }
            getContext();
            gqg.O000000o((int) R.string.operation_failed);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.llFuncPopup.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mTVRecordTimer.getLayoutParams();
            this.mFullScreen = configuration.orientation != 1;
            if (hyy.O000000o()) {
                this.mFullScreen = ((CameraBaseActivity) getContext()).getFullScreenThroughPad(this.mFullScreen);
            }
            setWindow(this.mFullScreen);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.video_scale_tv.getLayoutParams();
            layoutParams3.topMargin = this.mFullScreen ? gpc.O000000o(80.0f) : gpc.O000000o(20.0f);
            this.video_scale_tv.setLayoutParams(layoutParams3);
            if (this.mFullScreen) {
                this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                if (this.mVideoView != null) {
                    this.mVideoView.O000000o(true);
                }
                this.mTimeLineControlView.setFull(true);
                this.mSeeAllVieo.setVisibility(8);
                this.bottom_ctrl_ll.setVisibility(8);
                this.mPauseView.setVisibility(0);
                this.mLLRightCtrlLandscape.setVisibility(0);
                int O000000o2 = ckq.O000000o(getActivity());
                this.time_line_land.removeAllViews();
                this.time_line_land.setPadding(O000000o2, 0, O000000o2, 0);
                this.root.removeAllViews();
                this.time_line_land.addView(this.mTimeLineControlView);
                this.time_line_land.setVisibility(0);
                this.land_layout.setVisibility(0);
                this.flTopCtrlLandscape.setVisibility(0);
                layoutParams2.topMargin = cin.O000000o(this.mContext, 30.0f);
                this.mTVRecordTimer.setLayoutParams(layoutParams2);
                layoutParams.topMargin = cin.O000000o(this.mContext, 90.0f);
                layoutParams.leftMargin = O000000o2;
                this.llFuncPopup.setLayoutParams(layoutParams);
                this.ivFullScreen.setImageResource(R.drawable.camera_icon_fullscreen2_exit);
            } else {
                this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.currentVideoHeight));
                if (this.mVideoView != null) {
                    this.mVideoView.O000000o(false);
                }
                this.mTimeLineControlView.setFull(false);
                this.mSeeAllVieo.setVisibility(0);
                this.bottom_ctrl_ll.setVisibility(0);
                this.mPauseView.setVisibility(0);
                this.flTopCtrlLandscape.setVisibility(4);
                this.mLLRightCtrlLandscape.setVisibility(8);
                this.time_line_land.removeAllViews();
                this.time_line_land.setVisibility(4);
                this.land_layout.setVisibility(8);
                this.root.removeAllViews();
                this.root.addView(this.mTimeLineControlView);
                layoutParams2.topMargin = cin.O000000o(this.mContext, 20.0f);
                this.mTVRecordTimer.setLayoutParams(layoutParams2);
                layoutParams.topMargin = cin.O000000o(this.mContext, 20.0f);
                layoutParams.leftMargin = cin.O000000o(this.mContext, 20.0f);
                this.llFuncPopup.setLayoutParams(layoutParams);
                this.ivFullScreen.setImageResource(R.drawable.home_icon_fullscreen_big_new);
            }
            hyy.O000000o((Activity) getContext(), this.mFullScreen);
        } catch (Exception e) {
            String str = TAG;
            civ.O00000o0(str, "onConfigurationChanged:" + e.getLocalizedMessage());
        }
    }

    private void startMissPlayback(long j, boolean z) {
        setPlayTime(j, z, new IXmConnectionClient.XmActionCallback() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass9 */

            public void onSuccess(String str, Object obj) {
                if (((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                }
            }

            public void onFailed(int i, String str) {
                if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                    SDCardTimeLineFragment.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$9$T83mGHLsBjGHjf9HD9elwG0CEDc */

                        public final void run() {
                            SDCardTimeLineFragment.AnonymousClass9.this.lambda$onFailed$0$SDCardTimeLineFragment$9();
                        }
                    });
                    String str2 = SDCardTimeLineFragment.TAG;
                    civ.O00000o0(str2, "SDCardTimeLinePlayerExActivity playbackStream onFailed:" + i + " " + str);
                    SDCardTimeLineFragment.this.mHandler.removeMessages(2);
                }
            }

            public /* synthetic */ void lambda$onFailed$0$SDCardTimeLineFragment$9() {
                SDCardTimeLineFragment.this.hideLoading();
                SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
                sDCardTimeLineFragment.showError(sDCardTimeLineFragment.getString(R.string.video_play_failed));
            }
        });
        if (!this.mCameraPlayerEx.O0000OoO()) {
            cjg cjg = this.mCameraPlayerEx;
            cjg.O00000o0(cjg.O0000OoO());
        }
    }

    public void onServerCmd(int i, byte[] bArr) {
        String optString;
        char c;
        if (!((SDCardCloudVideoActivity) this.mContext).isFinishing()) {
            String str = TAG;
            civ.O000000o(str, "server cmd:" + i + " " + new String(bArr));
            if (i == 270) {
                String str2 = TAG;
                civ.O00000o0(str2, "onServerCmd thread " + Thread.currentThread());
                try {
                    String str3 = new String(bArr);
                    JSONObject jSONObject = new JSONObject(str3);
                    int optInt = jSONObject.optInt("id", -1);
                    civ.O00000o0(TAG, "id ".concat(str3));
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
                                this.mEndTime = this.mStartTime + optInt2;
                            }
                        } else if (c == 1) {
                            hideLoading();
                            pauseCamera();
                            showError(getString(R.string.camera_play_error_file));
                        } else if (c == 2) {
                            this.mHandler.removeMessages(2);
                            this.isInEnding = false;
                            pauseCamera();
                        } else if (c == 3) {
                            hideLoading();
                            pauseCamera();
                            showError(getString(R.string.sd_read_fail));
                            jSONObject.optInt("starttime");
                        }
                        civ.O00000o0(TAG, " onServerCmd status ".concat(String.valueOf(optString)));
                    }
                } catch (Exception e) {
                    civ.O00000o0("CameraPlay", e.toString());
                }
            }
        }
    }

    private void toggleSpeed() {
        cjg cjg = this.mCameraPlayerEx;
        if (cjg == null || !cjg.O0000Ooo()) {
            getContext();
            gqg.O000000o((int) R.string.sd_card_video_not_playing);
            return;
        }
        int O0000oOO = this.mCameraPlayerEx.O0000oOO();
        civ.O000000o(TAG, "speed:".concat(String.valueOf(O0000oOO)));
        int i = 16;
        if (O0000oOO == 1) {
            i = 4;
        } else if (O0000oOO != 4) {
            i = 1;
        }
        this.mCameraPlayerEx.O00000Oo(i);
        if (i == 1) {
            this.cdcToggleAudio.setEnabled(true);
            this.cdcToggleAudio_land.setEnabled(true);
        } else {
            if (this.cdcToggleAudio.isChecked()) {
                this.cdcToggleAudio.performClick();
            }
            this.cdcToggleAudio.setEnabled(false);
            this.cdcToggleAudio_land.setEnabled(false);
        }
        setMultiSpeed(i);
    }

    public void onStart() {
        super.onStart();
        civ.O000000o(TAG, "onStart");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void */
    public void onStop() {
        super.onStop();
        civ.O000000o(TAG, "onStop");
        recordVideoPlayTime();
        try {
            this.mSurfaceViewScale = this.mVideoView.O00000o();
            if (this.mSurfaceViewScale >= this.mVideoView.O00000o0()) {
                gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "scale_sdcard", this.mSurfaceViewScale);
                this.mSurfaceViewOffsetX = this.mVideoView.O00000oO();
                gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "offsetX_sdcard", this.mSurfaceViewOffsetX);
                this.mSurfaceViewOffsetY = this.mVideoView.O00000oo();
                gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "offsetY_sdcard", this.mSurfaceViewOffsetY);
                return;
            }
            gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "scale_sdcard", 1.0f);
            gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "offsetX_sdcard", 0.0f);
            gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "offsetY_sdcard", 0.0f);
        } catch (Exception e) {
            cki.O00000oO(TAG, e.toString());
        }
    }

    public void handleMessage(Message message) {
        int i;
        View view;
        if (message.what != 4) {
            int i2 = message.what;
            if (i2 == 2) {
                cjg cjg = this.mCameraPlayerEx;
                if (cjg != null) {
                    long O0000oOo = cjg.O0000oOo();
                    if (this.mLastUpdateTime == O0000oOo || this.mSeekBarTouched || !this.mCameraPlayerEx.O0000Ooo()) {
                        this.mHandler.removeMessages(2);
                        this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
                        return;
                    }
                    if (O0000oOo >= 0) {
                        setIsConnected();
                    }
                    long endTimeOfLastVideo = getEndTimeOfLastVideo();
                    if (endTimeOfLastVideo == 0 || endTimeOfLastVideo - (O0000oOo * 1000) >= ((long) this.UPDATE_DURATION)) {
                        this.mLastUpdateTime = O0000oOo;
                        int i3 = (int) (O0000oOo - (this.mTimeItem.f5243O000000o / 1000));
                        if (this.mIsSetTime) {
                            if (Math.abs(this.mLastOffsetTime - i3) <= 3 || System.currentTimeMillis() - this.mLastSetTime > 6000) {
                                this.mIsSetTime = false;
                            } else {
                                this.mHandler.removeMessages(2);
                                this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
                                return;
                            }
                        }
                        this.mHandler.removeMessages(2);
                        this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
                        if (this.mTimeLineControlView.getIsPress()) {
                            return;
                        }
                        if (!this.mIsSetPlayTime) {
                            this.mTimeLineControlView.updatePlayTime(O0000oOo * 1000, false);
                        } else if (Math.abs(((long) this.mSelectTime) - O0000oOo) < 10 || System.currentTimeMillis() - this.mLastSetPlayTime > 10000) {
                            this.mIsSetPlayTime = false;
                            this.mTimeLineControlView.updatePlayTime(O0000oOo * 1000, false);
                            String str = TAG;
                            civ.O000000o(str, "update " + Math.abs(((long) this.mSelectTime) - O0000oOo) + "  " + ((System.currentTimeMillis() - this.mLastSetPlayTime) / 1000));
                        }
                    } else if (!this.isInEnding) {
                        toSdFilesEnd();
                    }
                }
            } else if (i2 == 4000) {
                this.mNeedSpeed = false;
                this.mTimeUpdateView.setVisibility(8);
            }
        } else if (!this.mUpdating || (view = this.mLoadingView) == null || view.getVisibility() != 0) {
            if (this.mLoadingProgress.getTag() != null) {
                int intValue = ((Integer) this.mLoadingProgress.getTag()).intValue();
                if (intValue < 100 && (i = this.mProgress) <= 100) {
                    if (intValue == i) {
                        this.mHandler.sendEmptyMessageDelayed(4, 100);
                        return;
                    } else if (intValue <= i || this.mRetryCount == 0) {
                        int i4 = intValue + 1;
                        if (i4 > this.mProgress) {
                            this.mLoadingTitle.setText(cin.O00000o(getResources(), this.mProgress));
                            this.mLoadingProgress.setText(getString(R.string.percentage_tag, Integer.valueOf(this.mProgress)));
                            this.mLoadingProgress.setTag(Integer.valueOf(this.mProgress));
                        } else if (i4 <= 100) {
                            this.mLoadingTitle.setText(cin.O00000o(getResources(), i4));
                            this.mLoadingProgress.setText(getString(R.string.percentage_tag, Integer.valueOf(i4)));
                            this.mLoadingProgress.setTag(Integer.valueOf(i4));
                        }
                    } else if (this.mLoadingProgress.getVisibility() == 0) {
                        this.mHandler.sendEmptyMessageDelayed(4, 20);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (this.mProgress <= 100) {
                this.mLoadingTitle.setText(cin.O00000o(getResources(), this.mProgress));
                this.mLoadingProgress.setText(getString(R.string.percentage_tag, Integer.valueOf(this.mProgress)));
                this.mLoadingProgress.setTag(Integer.valueOf(this.mProgress));
            } else {
                return;
            }
            if (this.mLoadingProgress.getVisibility() == 0) {
                this.mHandler.sendEmptyMessageDelayed(4, 20);
            }
        } else {
            this.mHandler.sendEmptyMessageDelayed(4, 1000);
        }
    }

    public void toSdFilesEnd() {
        civ.O000000o(TAG, "toSdFilesEnd");
        List<TimeItem> O00000oo = this.mCameraSdcardExFileManager.O00000oo();
        if (O00000oo != null && O00000oo.size() > 0) {
            this.mTimeLineControlView.updatePlayTime(getEndTimeOfLastVideo(), false);
            pauseCamera();
            this.isOnFileEnd = true;
            if (this.mPauseView.getVisibility() == 0) {
                return;
            }
            if (this.mFullScreen) {
                if (this.time_line_land.getVisibility() != 0) {
                    lambda$initView$9$SDCardTimeLineFragment();
                } else {
                    this.mPauseView.setVisibility(0);
                }
            } else if (this.bottom_ctrl_ll.getVisibility() != 0) {
                lambda$initView$9$SDCardTimeLineFragment();
            } else {
                this.mPauseView.setVisibility(0);
            }
        }
    }

    private long getEndTimeOfLastVideo() {
        List<TimeItem> O00000oo = this.mCameraSdcardExFileManager.O00000oo();
        if (O00000oo == null || O00000oo.size() == 0) {
            return 0;
        }
        return O00000oo.get(O00000oo.size() - 1).O00000o0;
    }

    public void onPause() {
        civ.O000000o(TAG, "onPause");
        doStopRecord(true);
        try {
            this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver);
            this.mCameraDevice.O0000Oo0().O00000Oo();
        } catch (Throwable unused) {
        }
        super.onPause();
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null) {
            cjg.O0000OOo();
        }
        this.mNetworkMonitor.O00000Oo(this.mOnNetworkChange);
        this.mConnectStartTime = 0;
        this.isForeground = false;
        chr.O00000oo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void onPrepare(int i) {
        cid cid;
        civ.O000000o("CameraPlay", "prepare ".concat(String.valueOf(i)));
        this.mProgress = i;
        if (i == 5 && this.mRetryCount == 0) {
            this.mConnectStartTime = System.currentTimeMillis();
        }
        if (i >= 101) {
            if (i == 101 && this.mCameraPlayerEx != null && !isHistory() && this.mCameraPlayerEx.O00000Oo()) {
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$mNuQgUqQnr9jRrN9Nki99IQnt7E */

                    public final void run() {
                        SDCardTimeLineFragment.this.lambda$onPrepare$14$SDCardTimeLineFragment();
                    }
                }, 2000);
            }
            if (this.mConnectStartTime > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.mConnectStartTime;
                this.mConnectStartTime = 0;
                if (currentTimeMillis > 0 && currentTimeMillis < ((long) (this.mRetryCount * 60000)) + 120000) {
                    chr.O000000o(chr.f13829O000000o, "time", Integer.valueOf((int) currentTimeMillis));
                    chr.O000000o(1, this.mRetryCount, currentTimeMillis);
                }
            }
            if (!this.mShowView) {
                this.mShowView = true;
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$_loZ12on7ixosifmcgTMwJ9lPRw */

                    public final void run() {
                        SDCardTimeLineFragment.this.lambda$onPrepare$15$SDCardTimeLineFragment();
                    }
                }, 1500);
            }
            this.mRetryCount = 0;
            hideLoading();
            hidError();
            refreshUI();
            civ.O000000o("CameraPlay", "onPrepare finish");
            this.startPlayTimeStamp = System.currentTimeMillis();
            enableBottomTools(true);
            this.mHandler.removeCallbacks(this.hideTools);
            this.mHandler.postDelayed(this.hideTools, (long) this.HideToolsDaly);
        } else if (i == 0 && (cid = this.mCameraDevice) != null && cid.O000000o().O000000o("power", true)) {
            View view = this.mLoadingView;
            if ((view != null && view.getVisibility() != 0) || this.mRetryCount == 0) {
                String string = getString(R.string.camera_play_initial_0);
                hidError();
                showLoading(string);
            }
        }
    }

    public /* synthetic */ void lambda$onPrepare$14$SDCardTimeLineFragment() {
        cjh cjh = this.mVideoView;
        if (cjh != null) {
            cjh.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$mmxhnPftPDRRrZsuwnkWl6Wqvo */

                public final void onSnap(Bitmap bitmap) {
                    SDCardTimeLineFragment.this.lambda$null$13$SDCardTimeLineFragment(bitmap);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$13$SDCardTimeLineFragment(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(me.O00000Oo(this.mCameraDevice.getDid()));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                this.mCameraDevice.O00000oO().O00000o0();
                fileOutputStream.close();
                bitmap.recycle();
            } catch (IOException unused) {
            }
        }
    }

    public /* synthetic */ void lambda$onPrepare$15$SDCardTimeLineFragment() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16 && !isGPUDecoder()) {
            String str = chr.O000Oo0;
            chr.O000000o(str, "type", Build.MODEL + " SDK:" + i);
        }
    }

    public void onRetry(int i, String str, int i2) {
        if (i == -90) {
            if (this.mCameraDevice.deviceStat().isOnline) {
                this.mCameraDevice.O0000oo();
            }
            dealRetry(false, i);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void onVideoPlayError(final int i, String str) {
        View view;
        cid cid = this.mCameraDevice;
        if (cid == null || !cid.O00000o()) {
            if (i == -20009) {
                civ.O000000o("CameraPlay", "PlayError PWD");
                this.mRetryCount++;
                if (this.mRetryCount <= 3) {
                    updatePwd();
                } else {
                    hideLoading();
                    showError(getString(R.string.camera_play_error1, Integer.valueOf(i)));
                    long currentTimeMillis = System.currentTimeMillis() - this.mConnectStartTime;
                    if (currentTimeMillis > 0 && currentTimeMillis < 120000) {
                        chr.O000000o(i, this.mRetryCount, currentTimeMillis);
                    }
                    this.mConnectStartTime = 0;
                    this.mRetryCount = 0;
                }
            } else if (i == -6) {
                fta fta = fta.O000000o.f17086O000000o;
                fta.O000000o(getResources().getString(R.string.max_client_exceed));
            } else if (!this.mUpdating || (view = this.mLoadingView) == null || view.getVisibility() != 0) {
                this.mRetryCount = 4;
                if (!this.mCameraDevice.deviceStat().isOnline) {
                    hideLoading();
                    showError(getString(R.string.device_offline));
                    chr.O000000o(-1, 0, 0);
                } else if (i == -90) {
                    if (this.mCameraDevice.deviceStat().isOnline) {
                        this.mCameraDevice.O0000oo();
                    }
                    dealRetry(false, i);
                } else if (!this.mPowerCheck) {
                    this.mCameraDevice.O000000o().O000000o(new String[]{"power", "max_client"}, new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass10 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
                         arg types: [java.lang.String, int]
                         candidates:
                          _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                          _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                          _m_j.cll.O000000o(java.lang.String, boolean):boolean */
                        public void onSuccess(Void voidR) {
                            if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                                SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
                                sDCardTimeLineFragment.mPowerCheck = true;
                                if (!sDCardTimeLineFragment.mCameraDevice.O000000o().O000000o("power", true)) {
                                    SDCardTimeLineFragment.this.hideLoading();
                                    SDCardTimeLineFragment.this.refreshUI();
                                    return;
                                }
                                SDCardTimeLineFragment.this.dealRetry(true, i);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                                SDCardTimeLineFragment.this.hideLoading();
                                SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
                                sDCardTimeLineFragment.showError(sDCardTimeLineFragment.getString(R.string.camera_play_error1, Integer.valueOf(i)));
                                long currentTimeMillis = System.currentTimeMillis() - SDCardTimeLineFragment.this.mConnectStartTime;
                                if (currentTimeMillis > 0 && currentTimeMillis < 120000) {
                                    chr.O000000o(i, SDCardTimeLineFragment.this.mRetryCount, currentTimeMillis);
                                }
                            }
                        }
                    });
                } else if (i != -20015) {
                    dealRetry(true, i);
                } else if (this.mCameraDevice.O000000o().O000000o("power", true)) {
                    this.mCameraDevice.O000000o().O000000o(new String[]{"max_client"}, new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass11 */

                        public void onSuccess(Void voidR) {
                            if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                                SDCardTimeLineFragment.this.dealRetry(true, i);
                            }
                        }

                        public void onFailure(int i, String str) {
                            SDCardTimeLineFragment.this.hideLoading();
                            SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
                            sDCardTimeLineFragment.showError(sDCardTimeLineFragment.getString(R.string.camera_play_error1, Integer.valueOf(i)));
                        }
                    });
                } else {
                    hideLoading();
                    refreshUI();
                }
            } else {
                return;
            }
            recordVideoPlayTime();
        } else if (!this.mCameraDevice.deviceStat().isOnline) {
            hideLoading();
            showError(getString(R.string.device_offline));
        } else {
            civ.O000000o(TAG, "error:" + i + " errorInfo:" + str);
            int i2 = this.mRetryCount;
            this.mRetryCount = i2 + 1;
            if (i2 <= 3 && (i == 19 || i == 3 || i == 4)) {
                handleVideoPlayErrorOnMISS();
            }
            if (this.mRetryCount > 3) {
                hideLoading();
                showError(getString(R.string.camera_play_error1, Integer.valueOf(i)));
                this.mConnectStartTime = 0;
                this.mRetryCount = 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkMaxClient() {
        cid cid = this.mCameraDevice;
        if (cid != null && cid.O000000o() != null) {
            this.mCameraDevice.O000000o().O000000o(new String[]{"max_client"}, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass12 */

                public void onSuccess(Void voidR) {
                    if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                        SDCardTimeLineFragment.this.hideLoading();
                        if (SDCardTimeLineFragment.this.mCameraDevice.O000000o().O00000o()) {
                            SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
                            sDCardTimeLineFragment.showError(sDCardTimeLineFragment.getString(R.string.max_client_3));
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                        SDCardTimeLineFragment.this.hideLoading();
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void onVideoInfo(int i, int i2, int i3, int i4, int i5) {
        if (this.mCameraDevice.O000000o().O000000o("power", true)) {
            cjg cjg = this.mCameraPlayerEx;
            if (cjg == null || !cjg.O0000O0o()) {
                this.mHandler.post(new Runnable(i4) {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$volgYNIDmwRhIDcPA_p809omoMg */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        SDCardTimeLineFragment.this.lambda$onVideoInfo$17$SDCardTimeLineFragment(this.f$1);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onVideoInfo$17$SDCardTimeLineFragment(int i) {
        TextView textView = this.mFrameRate;
        if (!(textView == null || textView.getVisibility() == 0)) {
            this.mFrameRate.setVisibility(0);
        }
        TextView textView2 = this.mFrameRate;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(R.color.mj_color_white_50_transparent));
            TextView textView3 = this.mFrameRate;
            textView3.setText(i + "KB/S");
        }
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null && !cjg.O0000O0o()) {
            this.mHandler.post(new Runnable(i) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$hyei2vSIacGKXAFuvtxlYX8p0B0 */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SDCardTimeLineFragment.this.lambda$null$16$SDCardTimeLineFragment(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$16$SDCardTimeLineFragment(int i) {
        TextView textView = this.mFrameRate;
        if (!(textView == null || textView.getVisibility() == 0)) {
            this.mFrameRate.setVisibility(0);
        }
        TextView textView2 = this.mFrameRate;
        if (textView2 != null) {
            textView2.setText(i + "KB/S");
        }
    }

    public void onConnected() {
        if (this.isForeground) {
            this.mConnected = true;
            cjg cjg = this.mCameraPlayerEx;
            if (cjg != null && cjg.O0000o00()) {
                this.mCameraPlayerEx.O0000OOo();
            }
            cjg cjg2 = this.mCameraPlayerEx;
            if (cjg2 != null) {
                if (cjg2.O0000OoO()) {
                    this.mCameraPlayerEx.O00000Oo(false);
                } else {
                    this.mCameraPlayerEx.O00000Oo(true);
                }
            }
            if (!this.mUserPause) {
                startPlayVideo();
                civ.O000000o(TAG, "SDCardPlayer reconnect");
            }
        }
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
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this.mContext, R.string.power_off);
            return;
        }
        cid cid = this.mCameraDevice;
        if (cid == null || cid.O000000o() == null || !this.mCameraDevice.O000000o().O000000o("power", true)) {
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this.mContext, R.string.power_off);
            return;
        }
        cjg cjg = this.mCameraPlayerEx;
        if (cjg == null || !cjg.O0000Oo()) {
            gqg.O000000o((int) R.string.snap_failed_paused);
        } else {
            this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$mMfYmYrpAQlM4npowDblSs6P1N8 */

                public final void onSnap(Bitmap bitmap) {
                    SDCardTimeLineFragment.this.lambda$snapShot$19$SDCardTimeLineFragment(bitmap);
                }
            });
        }
    }

    public /* synthetic */ void lambda$snapShot$19$SDCardTimeLineFragment(Bitmap bitmap) {
        goq.O000000o(new Runnable(bitmap) {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$fQXk053Q0oFuJSoSE_jkuxeMRE8 */
            private final /* synthetic */ Bitmap f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SDCardTimeLineFragment.this.lambda$null$18$SDCardTimeLineFragment(this.f$1);
            }
        });
    }

    public void onDisConnected() {
        TextView textView = this.mFrameRate;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void onDisconnectedWithCode(int i) {
        TextView textView = this.mFrameRate;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void updatePwd() {
        onPrepare(0);
        if (TextUtils.isEmpty(XmPluginHostApi.instance().getDevicePincode(this.mCameraDevice.getDid())) && !this.mCameraDevice.O0000oO()) {
            this.mNeedTry = true;
        }
        civ.O000000o("CameraPlay", "start upd");
        this.mCameraDevice.O00000Oo(new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass13 */

            public void onSuccess(Void voidR) {
                if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                    civ.O000000o("CameraPlay", "updatePwd:onSuccess");
                    SDCardTimeLineFragment.this.startPlay();
                }
            }

            public void onFailure(int i, String str) {
                if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                    if (i == 33) {
                        long j = 0;
                        if (SDCardTimeLineFragment.this.mEmptyTime == 0) {
                            SDCardTimeLineFragment.this.mEmptyTime = System.currentTimeMillis();
                        } else {
                            j = System.currentTimeMillis() - SDCardTimeLineFragment.this.mEmptyTime;
                        }
                        if (j <= 5000) {
                            SDCardTimeLineFragment.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$13$UB0EfeXc9W5N42BGpt8DBW_l9k0 */

                                public final void run() {
                                    SDCardTimeLineFragment.AnonymousClass13.this.lambda$onFailure$0$SDCardTimeLineFragment$13();
                                }
                            }, 1000);
                            return;
                        }
                    }
                    civ.O000000o("CameraPlay", "updatePwd:onFailure:" + str + " uid: " + SDCardTimeLineFragment.this.mCameraDevice.O0000oOo() + " pwd:" + SDCardTimeLineFragment.this.mCameraDevice.O00oOooo());
                    if (!SDCardTimeLineFragment.this.mNeedTry || SDCardTimeLineFragment.this.mPwdCount <= 0) {
                        SDCardTimeLineFragment.this.hideLoading();
                        SDCardTimeLineFragment sDCardTimeLineFragment = SDCardTimeLineFragment.this;
                        sDCardTimeLineFragment.showError(sDCardTimeLineFragment.getString(R.string.camera_play_error2));
                        return;
                    }
                    SDCardTimeLineFragment sDCardTimeLineFragment2 = SDCardTimeLineFragment.this;
                    sDCardTimeLineFragment2.mPwdCount--;
                    SDCardTimeLineFragment.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$13$HUbJ_ReQgbLxegVP4S7dglQztGQ */

                        public final void run() {
                            SDCardTimeLineFragment.AnonymousClass13.this.lambda$onFailure$1$SDCardTimeLineFragment$13();
                        }
                    }, 3000);
                }
            }

            public /* synthetic */ void lambda$onFailure$0$SDCardTimeLineFragment$13() {
                SDCardTimeLineFragment.this.updatePwd();
            }

            public /* synthetic */ void lambda$onFailure$1$SDCardTimeLineFragment$13() {
                SDCardTimeLineFragment.this.updatePwd();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void pauseCamera() {
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null) {
            cjg.O0000OOo();
        }
        hideLoading();
        changePlayBtnBg(false);
        this.isVideoPlaying = false;
        this.mHandler.removeCallbacks(this.hideTools);
        enableBottomTools(false);
    }

    private void dismissSnapshotPopupRunnable(long j) {
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$upyc6q3JYgujYHi35oJrZ8DjbAk */

            public final void run() {
                SDCardTimeLineFragment.this.lambda$dismissSnapshotPopupRunnable$20$SDCardTimeLineFragment();
            }
        }, j);
        this.mHandler.removeCallbacks(this.hideScaleTvR);
        this.mHandler.postDelayed(this.hideScaleTvR, 3000);
    }

    public /* synthetic */ void lambda$dismissSnapshotPopupRunnable$20$SDCardTimeLineFragment() {
        if (this.llFuncPopup.getVisibility() == 0) {
            this.llFuncPopup.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.anim_snap_shot_out));
            this.llFuncPopup.setVisibility(4);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    /* access modifiers changed from: package-private */
    /* renamed from: onSnapShot */
    public void lambda$null$18$SDCardTimeLineFragment(Bitmap bitmap) {
        String O000000o2 = me.O000000o(false, this.mCameraDevice.getDid());
        if (O000000o2 != null && bitmap != null) {
            if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                bitmap = C0118cif.O000000o(bitmap, this.mContext);
            }
            if (bitmap != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(O000000o2);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException unused) {
                    return;
                }
            }
            int O000000o3 = gpc.O000000o(100.0f);
            this.mHandler.post(new Runnable(O000000o2, Bitmap.createScaledBitmap(bitmap, O000000o3, (bitmap.getHeight() * O000000o3) / bitmap.getWidth(), false)) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$8ZAMhXu9wtA4V8A42jrFUSpRkNU */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ Bitmap f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SDCardTimeLineFragment.this.lambda$onSnapShot$22$SDCardTimeLineFragment(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onSnapShot$22$SDCardTimeLineFragment(String str, Bitmap bitmap) {
        if (new File(str).exists()) {
            resetLeftTopTools();
            ImageView imageView = (ImageView) this.rootView.findViewById(R.id.ivShotPic);
            if (this.llFuncPopup.getVisibility() == 0) {
                this.llFuncPopup.setVisibility(4);
            }
            this.tvShortPlay.setVisibility(8);
            this.llFuncPopup.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.anim_snap_shot_in));
            this.llFuncPopup.setVisibility(0);
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
                    this.mContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                }
                civ.O000000o(TAG, "snap success");
            } catch (Throwable unused) {
            }
            clj.O000000o O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str);
            if (O00000Oo != null) {
                imageView.setOnClickListener(new View.OnClickListener(O00000Oo) {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$1GV2msdRkT0wwnvEtTqGJ6TfjI */
                    private final /* synthetic */ clj.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        SDCardTimeLineFragment.this.lambda$null$21$SDCardTimeLineFragment(this.f$1, view);
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
    public /* synthetic */ void lambda$null$21$SDCardTimeLineFragment(clj.O000000o o000000o, View view) {
        cjg cjg = this.mCameraPlayerEx;
        if (cjg == null || !cjg.O0000O0o()) {
            dismissSnapshotPopupRunnable(0);
            Intent intent = new Intent(this.mContext, LocalPicActivity.class);
            intent.putExtra("noScroll", true);
            intent.putExtra("file_path", o000000o.O00000o);
            getActivity().startActivity(intent);
            return;
        }
        gqg.O00000Oo((int) R.string.recording_block);
    }

    public void setPlayTime(long j, boolean z, IXmConnectionClient.XmActionCallback xmActionCallback) {
        int i;
        TimeItem timeItem;
        long j2 = j;
        TimeItem O000000o2 = this.mCameraDevice.O0000Oo0().O000000o(j2);
        if (O000000o2 != null) {
            String str = TAG;
            civ.O00000o0(str, "last set time before " + mi.O00000Oo(j));
            int i2 = (int) (O000000o2.f5243O000000o / 1000);
            i = O000000o2.f5243O000000o < j2 ? ((int) (j2 - O000000o2.f5243O000000o)) / 1000 : 0;
            String str2 = TAG;
            StringBuilder sb = new StringBuilder("last set time after  ");
            long j3 = (long) (i * 1000);
            sb.append(mi.O00000Oo(O000000o2.f5243O000000o + j3));
            civ.O00000o0(str2, sb.toString());
            this.mIsSetPlayTime = true;
            this.mSelectTime = i2 + i;
            this.mTimeLineControlView.updatePlayTime(O000000o2.f5243O000000o + j3, false);
        } else {
            civ.O00000o0(TAG, "last set time alive");
            this.mHandler.removeMessages(2);
            this.mIsSetPlayTime = true;
            if (this.mCameraSdcardExFileManager.O00000oo() != null && this.mCameraSdcardExFileManager.O00000oo().size() != 0 && j2 != 0 && (timeItem = this.mCameraSdcardExFileManager.O00000oo().get(this.mCameraSdcardExFileManager.O00000oo().size() - 1)) != null) {
                if (j2 >= timeItem.O00000o0) {
                    toSdFilesEnd();
                    return;
                }
                i = 0;
            } else {
                return;
            }
        }
        if (!this.mUserPause) {
            hidError();
            showLoading(null);
        }
        this.mLastSetPlayTime = System.currentTimeMillis();
        this.mHandler.removeMessages(2);
        if (O000000o2 == null) {
            pauseCamera();
            return;
        }
        this.mStartTime = (int) (O000000o2.f5243O000000o / 1000);
        this.mEndTime = (int) (O000000o2.O00000o0 / 1000);
        this.mDuration = ((int) O000000o2.O00000Oo) / 1000;
        this.mLastUpdateTime = 0;
        this.mTimeItem = O000000o2;
        setPlayWithOffset(i, z, xmActionCallback);
    }

    private void setPlayWithOffset(int i, boolean z, IXmConnectionClient.XmActionCallback xmActionCallback) {
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
        this.mHandler.removeMessages(2);
        hidError();
        if (this.mPauseView.getVisibility() == 0) {
            this.mPauseView.setVisibility(8);
        }
        this.mUserPause = false;
        if (this.isOnFileEnd) {
            this.isOnFileEnd = false;
            z = false;
        }
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null && (!cjg.O0000o00() || !z)) {
            changePlayBtnBg(true);
            if (!this.mCameraPlayerEx.O0000Ooo()) {
                this.mCameraPlayerEx.O00000o(true);
            }
            this.mCameraPlayerEx.O000000o(this.mStartTime, i, 0, xmActionCallback);
            this.isVideoPlaying = true;
            changePlayBtnBg(true);
            View view = this.mErrorRetryView;
            if (!(view == null || view.getVisibility() == 8)) {
                this.mErrorRetryView.setVisibility(8);
            }
        }
        cjg cjg2 = this.mCameraPlayerEx;
        if (cjg2 != null && !cjg2.O0000o00()) {
            showLoading(null);
        }
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 3000);
        civ.O00000o0(TAG, "SDCardPlayer PlayTime " + this.mStartTime + " offset " + i + " end " + this.mEndTime);
    }

    private void recordVideoPlayTime() {
        if (shouldRecordPlayTime() && this.startPlayTimeStamp > 0) {
            chr.O000000o(chr.O000o0o0, "time", Long.valueOf((System.currentTimeMillis() - this.startPlayTimeStamp) / 1000));
            this.startPlayTimeStamp = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void startPlay() {
        if (TextUtils.isEmpty(this.mCameraDevice.getModel()) || TextUtils.isEmpty(this.mCameraDevice.getDid())) {
            hideLoading();
            showError(getString(R.string.camera_play_error2));
            return;
        }
        if (this.mCameraPlayerEx == null) {
            this.mCameraPlayerEx = ciy.O000000o(this.mContext, this.mCameraDevice, this);
            this.mCameraPlayerEx.O000000o(this.mIRecodeTimeListener);
            this.mCameraPlayerEx.O00000oO(true);
            this.mCameraPlayerEx.O000000o(this.mVideoView);
        }
        if (!this.isFromRN || this.mCameraPlayerEx.O0000Oo()) {
            startPlayVideo();
        } else {
            this.mCameraPlayerEx.O00000Oo(new IXmConnectionClient.XmActionCallback() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass15 */

                public void onSuccess(String str, Object obj) {
                    String str2 = SDCardTimeLineFragment.TAG;
                    cki.O00000o(str2, "startStream onSuccess:" + str + ":" + obj);
                }

                public void onFailed(int i, String str) {
                    String str2 = SDCardTimeLineFragment.TAG;
                    cki.O00000oO(str2, "startStream onFailed:" + i + ":" + str);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void refreshUI() {
        cjg cjg = this.mCameraPlayerEx;
        if (cjg == null || cjg.O0000OoO()) {
            this.cdcToggleAudio.setChecked(false);
            this.cdcToggleAudio_land.setChecked(false);
            return;
        }
        this.cdcToggleAudio.setChecked(true);
        this.cdcToggleAudio_land.setChecked(true);
    }

    public boolean doOnClick(View view) {
        if (view.getId() == R.id.pause_view) {
            this.mUserPause = false;
            resumeCamera();
        } else if (view.getId() != R.id.retry_tv && view.getId() != R.id.see_help && view.getId() != R.id.retry_btn) {
            return false;
        } else {
            this.mRetryCount = 0;
            if (mg.O00000o0(this.mContext) && !this.mAllowMobileNetwork) {
                hidError();
                pauseCamera();
            }
            hidError();
            showLoading(getString(R.string.camera_play_initial_0));
            cjg cjg = this.mCameraPlayerEx;
            if (cjg != null) {
                cjg.O0000o();
            } else {
                startPlay();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void showLoading() {
        if (this.mLoadingView != null) {
            this.mLoadingAnimation.start();
            this.mLoadingView.bringToFront();
            hidError();
            this.mLoadingView.setVisibility(0);
            this.mLoadingTitle.setText((int) R.string.camera_play_initial_buffer);
            this.mLoadingProgress.setText("");
            ImageView imageView = this.mPauseView;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.mPauseView.setVisibility(8);
            }
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
    public void showLoading(String str) {
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            refreshUI();
            return;
        }
        ImageView imageView = this.mPauseView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view = this.mLoadingView;
        if (view != null) {
            view.setVisibility(0);
            this.mLoadingView.bringToFront();
            this.mLoadingAnimation.start();
            this.mHandler.removeMessages(4);
            this.mLoadingProgress.setTag(null);
            if (this.mProgress < 100) {
                this.mHandler.sendEmptyMessage(4);
            }
            hidError();
            if (!this.mUpdating) {
                if (!TextUtils.isEmpty(str)) {
                    this.mLoadingTitle.setText(str);
                    this.mLoadingProgress.setText(getString(R.string.percentage_tag, 0));
                    this.mLoadingProgress.setTag(null);
                    return;
                }
                this.mLoadingTitle.setText((int) R.string.camera_play_initial_buffer);
                this.mLoadingProgress.setText("");
                this.mLoadingProgress.setTag(null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void hideLoading() {
        if (this.mLoadingView != null) {
            if (!this.mUpdating || !mg.O000000o(this.mContext)) {
                this.mLoadingAnimation.stop();
                this.mLoadingProgress.setText("");
                this.mLoadingProgress.setTag(null);
                this.mHandler.removeMessages(4);
                this.mLoadingView.setVisibility(8);
                if (this.bottom_ctrl_ll.getVisibility() == 0) {
                    this.mPauseView.setVisibility(0);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void hidError() {
        View view = this.mErrorRetryView;
        if (view != null && view.getVisibility() == 0) {
            this.mErrorRetryView.setVisibility(8);
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
    public void showError(String str) {
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null) {
            if (cjg.O0000O0o()) {
                doStopRecord(true);
            }
            if (this.mCameraPlayerEx.O00000o0()) {
                doStopCall();
            }
        }
        ImageView imageView = this.mPauseView;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.mPauseView.setVisibility(8);
        }
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            View view = this.mPowerOffView;
            if (view != null && view.getVisibility() == 8) {
                this.mPowerOffView.setVisibility(0);
            }
            this.mErrorRetryView.setVisibility(8);
        } else {
            if (this.mErrorRetryView.getVisibility() != 0) {
                View view2 = this.mLoadingView;
                if (view2 == null || view2.getVisibility() != 0 || !((String) this.mLoadingTitle.getText()).equals(this.UPDATE_ING)) {
                    this.mErrorRetryView.setVisibility(0);
                    this.mRetryView.setImageResource(R.drawable.camera_state_conn_error);
                    refreshUI();
                } else {
                    refreshUI();
                    return;
                }
            }
            if (str.equals(getString(R.string.device_offline))) {
                this.mRetryView.setImageResource(R.drawable.camera_state_offline);
                this.isOffline = true;
                TextView textView = this.retry_tv;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                TextView textView2 = this.offline_time;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                cky.O000000o(this.mCameraDevice.getModel(), new String[]{this.mCameraDevice.getDid()}, new Callback<Long>() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass16 */

                    public void onSuccess(Long l) {
                        if (!((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing() && SDCardTimeLineFragment.this.offline_time != null) {
                            SDCardTimeLineFragment.this.offline_time.setText(MessageFormat.format("{0}：{1}", SDCardTimeLineFragment.this.getString(R.string.offline_time_str), SDCardTimeLineFragment.this.simpleDateFormat.format(new Date(l.longValue() * 1000))));
                            SDCardTimeLineFragment.this.offline_time.setVisibility(0);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (((SDCardCloudVideoActivity) SDCardTimeLineFragment.this.mContext).isFinishing()) {
                        }
                    }
                });
            } else {
                this.isOffline = false;
                TextView textView3 = this.retry_tv;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                TextView textView4 = this.offline_time;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
            }
            this.mErrorInfoView.setText(str);
        }
        onPlayError();
    }

    /* access modifiers changed from: protected */
    public void onPlayError() {
        this.isVideoPlaying = false;
        changePlayBtnBg(false);
    }

    /* access modifiers changed from: protected */
    public void doResume() {
        if ((this.mUserPause && !this.isVideoPlaying) || !this.isForeground) {
            return;
        }
        if (getEndTimeOfLastVideo() == 0) {
            cjg cjg = this.mCameraPlayerEx;
            if (cjg != null) {
                cjg.O0000OOo();
                return;
            }
            return;
        }
        startPlayVideoWithCheckConnection(this.mTimeLineControlView.getSelectTime(), false);
    }

    /* access modifiers changed from: protected */
    public void doStopRecord(final boolean z) {
        this.mLastTime = 0;
        this.mCurrentTime = 0;
        cjg cjg = this.mCameraPlayerEx;
        if (cjg == null || !cjg.O0000O0o()) {
            this.cdcCameraRecord.setChecked(false);
            this.cdcCameraRecord_land.setChecked(false);
            if (!this.isVideoPlaying) {
                this.cdcCameraRecord.setEnabled(false);
                this.cdcCameraRecord_land.setEnabled(false);
                return;
            }
            return;
        }
        if (this.mCameraPlayerEx.O0000OoO()) {
            this.mCameraPlayerEx.O00000Oo(false);
        }
        this.mCameraPlayerEx.O000000o(new XmMp4Record.IRecordListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment.AnonymousClass17 */

            public void onSuccess(String str) {
                SDCardTimeLineFragment.this.mTVRecordTimer.setVisibility(8);
                if (z) {
                    SDCardTimeLineFragment.this.onVideoRecorded(str);
                }
                SDCardTimeLineFragment.this.cdcCameraRecord.setChecked(false);
                SDCardTimeLineFragment.this.cdcCameraRecord_land.setChecked(false);
                if (!SDCardTimeLineFragment.this.isVideoPlaying) {
                    SDCardTimeLineFragment.this.cdcCameraRecord.setEnabled(false);
                    SDCardTimeLineFragment.this.cdcCameraRecord_land.setEnabled(false);
                }
            }

            public void onFailed(int i, String str) {
                SDCardTimeLineFragment.this.mTVRecordTimer.setVisibility(8);
                SDCardTimeLineFragment.this.cdcCameraRecord.setChecked(false);
                SDCardTimeLineFragment.this.cdcCameraRecord_land.setChecked(false);
                if (!SDCardTimeLineFragment.this.isVideoPlaying) {
                    SDCardTimeLineFragment.this.cdcCameraRecord.setEnabled(false);
                    SDCardTimeLineFragment.this.cdcCameraRecord_land.setEnabled(false);
                }
                if (i == -2) {
                    gqg.O000000o((int) R.string.snip_video_failed_time_mini);
                } else {
                    gqg.O000000o((int) R.string.snip_video_failed);
                }
            }
        });
    }

    public void onVideoRecorded(String str) {
        cjh cjh;
        File file = new File(str);
        if (file.exists()) {
            this.mContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            clj.O000000o O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str);
            if (O00000Oo != null && (cjh = this.mVideoView) != null) {
                cjh.O000000o(new XmVideoViewGl.PhotoSnapCallback(O00000Oo) {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$xgSQEfFytvDpGKrAR7GkqhnFBEI */
                    private final /* synthetic */ clj.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onSnap(Bitmap bitmap) {
                        SDCardTimeLineFragment.this.lambda$onVideoRecorded$25$SDCardTimeLineFragment(this.f$1, bitmap);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onVideoRecorded$25$SDCardTimeLineFragment(clj.O000000o o000000o, Bitmap bitmap) {
        int O000000o2 = gpc.O000000o(100.0f);
        if (bitmap != null) {
            this.mHandler.post(new Runnable(Bitmap.createScaledBitmap(bitmap, O000000o2, (bitmap.getHeight() * O000000o2) / bitmap.getWidth(), false), o000000o) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$OYYyGDNGwU1bwxMqEtPvTyC9EkI */
                private final /* synthetic */ Bitmap f$1;
                private final /* synthetic */ clj.O000000o f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SDCardTimeLineFragment.this.lambda$null$24$SDCardTimeLineFragment(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$24$SDCardTimeLineFragment(Bitmap bitmap, clj.O000000o o000000o) {
        if (bitmap != null) {
            resetLeftTopTools();
            ImageView imageView = (ImageView) this.rootView.findViewById(R.id.ivShotPic);
            imageView.setImageBitmap(bitmap);
            if (this.llFuncPopup.getVisibility() == 0) {
                this.llFuncPopup.setVisibility(4);
            }
            this.tvShortPlay.setVisibility(0);
            this.tvShortPlay.setText(this.mTVRecordTimer.getText());
            this.llFuncPopup.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.anim_snap_shot_in));
            this.llFuncPopup.setVisibility(0);
            dismissSnapshotPopupRunnable(3000);
            imageView.setOnClickListener(new View.OnClickListener(o000000o) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$VSR6X6QEeBfE0udse9ThPOmqFR4 */
                private final /* synthetic */ clj.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    SDCardTimeLineFragment.this.lambda$null$23$SDCardTimeLineFragment(this.f$1, view);
                }
            });
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
    public /* synthetic */ void lambda$null$23$SDCardTimeLineFragment(clj.O000000o o000000o, View view) {
        if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
            dismissSnapshotPopupRunnable(0);
            Intent intent = new Intent();
            intent.putExtra("file_path", o000000o.O00000o);
            intent.putExtra("noScroll", true);
            intent.setClass(this.mContext, LocalPicActivity.class);
            getActivity().startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isGPUDecoder() {
        return this.mCameraPlayerEx != null;
    }

    /* access modifiers changed from: protected */
    public void resumeCamera() {
        this.mPauseView.setVisibility(8);
        refreshUI();
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
        this.isVideoPlaying = true;
        changePlayBtnBg(true);
        startPlay();
    }

    private void startPlayVideo() {
        showLoading(null);
        if (this.mTimeLineControlView.getSelectTime() < getEndTimeOfLastVideo()) {
            startPlayVideoWithCheckConnection(this.mTimeLineControlView.getSelectTime(), false);
        } else if (this.mCameraSdcardExFileManager.O00000oo() != null && this.mCameraSdcardExFileManager.O00000oo().size() != 0) {
            TimeItem timeItem = this.mCameraSdcardExFileManager.O00000oo().get(this.mCameraSdcardExFileManager.O00000oo().size() - 1);
            if (timeItem == null) {
                civ.O00000o0(TAG, "last == null");
            } else {
                startPlayVideoWithCheckConnection(timeItem.f5243O000000o, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setWindow(boolean z) {
        if (z) {
            getActivity().getWindow().setFlags(1024, 1024);
        } else {
            getActivity().getWindow().clearFlags(1024);
        }
    }

    public void dealRetry(boolean z, int i) {
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mConnectStartTime;
        long j2 = currentTimeMillis - j;
        if (j <= 0 || j2 >= 90000 || (!z ? this.mRetryCount > 5 : this.mRetryCount >= 3)) {
            z2 = false;
        } else {
            this.mRetryCount++;
            z2 = true;
        }
        if (z2) {
            this.mHandler.postDelayed(new Runnable(i) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$AcIcOudpUOMOrN3bJvegIQovQk */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SDCardTimeLineFragment.this.lambda$dealRetry$26$SDCardTimeLineFragment(this.f$1);
                }
            }, 2000);
            return;
        }
        hideLoading();
        showError(getString(R.string.camera_play_error1, Integer.valueOf(i)));
        if (j2 > 0) {
            int i2 = this.mRetryCount;
            if (j2 < ((long) (60000 * i2)) + 120000) {
                chr.O000000o(i, i2, j2);
            }
        }
        this.mConnectStartTime = 0;
        this.mRetryCount = 0;
    }

    public /* synthetic */ void lambda$dealRetry$26$SDCardTimeLineFragment(int i) {
        civ.O000000o("CameraPlay", "retry " + this.mRetryCount + " " + i);
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null) {
            cjg.O0000o();
        }
    }

    /* access modifiers changed from: protected */
    public void detectSDCard() {
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$Kuxu3n3TtTr29ZSbVZkdHQ061EM */

            public final void run() {
                SDCardTimeLineFragment.this.lambda$detectSDCard$27$SDCardTimeLineFragment();
            }
        }, 1500);
    }

    public /* synthetic */ void lambda$detectSDCard$27$SDCardTimeLineFragment() {
        try {
            ((SDCardCloudVideoActivity) getActivity()).detectSDCard(true);
        } catch (Exception e) {
            civ.O00000o0(TAG, e.toString());
        }
    }

    public void onPauseCamera() {
        pauseCamera();
    }

    /* access modifiers changed from: protected */
    public void setIsConnected() {
        this.mConnected = true;
    }

    /* access modifiers changed from: protected */
    public void handleVideoPlayErrorOnMISS() {
        if (this.mCameraPlayerEx != null && this.mHandler != null) {
            civ.O000000o(TAG, "run handleVideoPlayErrorOnMISS");
            this.mCameraPlayerEx.O0000o0o();
            this.mHandler.removeCallbacks(this.delayedReconnectRunnable);
            this.mHandler.postDelayed(this.delayedReconnectRunnable, 5000);
        }
    }

    public /* synthetic */ void lambda$new$29$SDCardTimeLineFragment(int i) {
        int i2;
        if (i >= 0 && (i2 = i / 1000) != this.mCurrentRecordTime) {
            this.mCurrentRecordTime = i2;
            this.mHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$SDCardTimeLineFragment$Vj8OHcwGv9L2jMq86jBRTU_eNA */

                public final void run() {
                    SDCardTimeLineFragment.this.lambda$null$28$SDCardTimeLineFragment();
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$28$SDCardTimeLineFragment() {
        upDateTimeTitle(cin.O000000o(this.mContext, this.mCurrentRecordTime));
    }

    /* access modifiers changed from: protected */
    public void upDateTimeTitle(String str) {
        this.mTVRecordTimer.setText(str);
    }
}
