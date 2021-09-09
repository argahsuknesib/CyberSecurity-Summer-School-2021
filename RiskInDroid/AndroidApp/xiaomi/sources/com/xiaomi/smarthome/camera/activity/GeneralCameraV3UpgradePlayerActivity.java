package com.xiaomi.smarthome.camera.activity;

import _m_j.C0118cif;
import _m_j.chr;
import _m_j.chw;
import _m_j.chx;
import _m_j.cih;
import _m_j.cin;
import _m_j.ciq;
import _m_j.civ;
import _m_j.ciw;
import _m_j.ciy;
import _m_j.cjh;
import _m_j.clf;
import _m_j.clh;
import _m_j.clj;
import _m_j.cll;
import _m_j.dvp;
import _m_j.fsp;
import _m_j.ftl;
import _m_j.gkv;
import _m_j.goq;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.grv;
import _m_j.gsy;
import _m_j.hyu;
import _m_j.hyv;
import _m_j.hyy;
import _m_j.izb;
import _m_j.me;
import _m_j.mg;
import _m_j.mi;
import _m_j.mk;
import _m_j.wd;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tutk.TuTkClient;
import com.xiaomi.mistream.MIStreamStatistic;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.LocalLicenseUtil;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmGuideActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity;
import com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew;
import com.xiaomi.smarthome.camera.activity.timelapse.DownLoadTimeLapseDemo;
import com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import com.xiaomi.smarthome.camera.activity.utils.SingleClickListener;
import com.xiaomi.smarthome.camera.v4.activity.setting.NoMemoryCardActivity;
import com.xiaomi.smarthome.camera.view.SDCardHintDialog;
import com.xiaomi.smarthome.camera.view.widget.GuideView;
import com.xiaomi.smarthome.camera.view.widget.MultiStateView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceUpdateInfo;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GeneralCameraV3UpgradePlayerActivity extends GeneralCameraPlayerBaseActivity {
    private final int CALL_VOLUME_DELAY = 500;
    private final int FIRST_RESUME = 2100;
    private final int MSG_CALL_VOLUME = 2101;
    private final int MSG_UPDATE_FIRM = 1;
    private final int UPDATE_CHECK = 3051;
    public FrameLayout flCloudVideoTips;
    private FrameLayout flTitleBar;
    private int fps = 20;
    private boolean isFirstResumed = false;
    private ViewGroup llBottomTools;
    public boolean mAudioOn = false;
    public boolean mCallingAudioOn = false;
    private View mExitFullScreen;
    private long mFullInTime = 0;
    public GuideView mGuideCenter;
    private PopupWindow mGuideMore;
    private boolean mIsInit = false;
    private LinearLayout mLLFuncPopup;
    private LinearLayout mLLTopCtrlLandscape;
    public MultiStateView mLandAudioView;
    public TextView mLandRecordTimer;
    public MultiStateView mLandRecordView;
    private TextView mLandResolution;
    public MultiStateView mLandSleepView;
    private ImageView mLandSnapshot;
    public boolean mNeedLicense = false;
    private View mNewFirmView;
    private OfflineViewDelegate mOfflineViewDelegate;
    public MultiStateView mPortAudioView;
    public MultiStateView mPortCallView;
    public MultiStateView mPortRecordView;
    private TextView mPortResolution;
    public MultiStateView mPortSleepView;
    private ImageView mPortSnapshot;
    private LinearLayout mPortraitControlLayout;
    private SDCardHintDialog mSDCardHintDialog;
    private CameraActivityUtils.SdcardDetectResult mSdcardDetectResult = new CameraActivityUtils.SdcardDetectResult();
    private TextView mTimeUpdateView;
    public ImageView mTitleMore;
    private ViewGroup mVideoParentView;
    public TextView record_time;
    private String recordingfilePath;
    int selectedIndex;
    private TextView tvAlert;
    private TextView tvCloud;
    private TextView tvFace;
    private ImageView tvFullScreen;
    private TextView tvPlayback;

    public int getResolutionIndexNew(int i) {
        if (i < 0 || i > 2) {
            return 0;
        }
        return i;
    }

    public boolean isHistory() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean shouldRecordPlayTime() {
        return true;
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
    /* access modifiers changed from: protected */
    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass1 */

            public void run() {
                clh.O000000o(GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice);
            }
        }, 2000);
        LogType logType = LogType.CAMERA;
        gsy.O00000o0(logType, "GenCameraV3UpgradePlayerAct", "doCreate did=" + this.mCameraDevice.getDid() + " model=" + this.mCameraDevice.getModel());
        setContentView((int) R.layout.activity_camera_player_v3_upgrade_new);
        this.flTitleBar = (FrameLayout) findViewById(R.id.title_bar);
        this.flTitleBar.setBackgroundResource(R.drawable.camera_shape_gradient_bg);
        this.flTitleBar.bringToFront();
        if (XmPluginHostApi.instance().getApiLevel() < 63) {
            showUpdateDlg(this, false);
            return;
        }
        if (!getIntent().getBooleanExtra("pincod", false)) {
            globalPinCodeVerifyFunc();
            if (this.mCameraDevice.O0000oO()) {
                this.mNeedPincode = true;
            }
        }
        if (getIntent().getBooleanExtra("fail_unbind", false) && this.mCameraDevice.isOwner()) {
            Intent intent = new Intent();
            intent.putExtra("security_setting_enable", false);
            intent.putExtra("unbind_enable", true);
            intent.putExtra("delete_enable", true);
            intent.putExtra("share_enable", false);
            CameraJumpUtils.openMoreMenu(this, this.mDid, new ArrayList(), true, 1002, intent);
            finish();
        }
        initView();
        if (!(this.mCameraDevice == null || this.mCameraDevice.O00000Oo() == null)) {
            this.mCameraDevice.O00000Oo().O000000o(this.mPropertyChangeListener);
            this.mCameraDevice.O00000Oo().O00000Oo();
            setResolutionTextNew(getResolutionIndexNew(this.mCameraDevice.O00000oO().O0000o00));
        }
        this.mNetworkMonitor.O000000o(this);
        if (!(this.mCameraDevice == null || this.mCameraDevice.O000000o() == null)) {
            this.mCameraDevice.O000000o().O000000o(chx.O00000Oo, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass2 */

                public void onFailure(int i, String str) {
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
                 arg types: [java.lang.String, int]
                 candidates:
                  _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                  _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                  _m_j.cll.O000000o(java.lang.String, boolean):boolean */
                public void onSuccess(Void voidR) {
                    if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                        GeneralCameraV3UpgradePlayerActivity generalCameraV3UpgradePlayerActivity = GeneralCameraV3UpgradePlayerActivity.this;
                        generalCameraV3UpgradePlayerActivity.isPowerCheck = true;
                        generalCameraV3UpgradePlayerActivity.refreshUI();
                        GeneralCameraV3UpgradePlayerActivity.this.checkMinLevel();
                        boolean O000000o2 = GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("improve_program", false);
                        boolean isUsrExpPlanEnabled = XmPluginHostApi.instance().isUsrExpPlanEnabled(GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.getDid());
                        if (O000000o2 != isUsrExpPlanEnabled) {
                            GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("improve_program", isUsrExpPlanEnabled, (Callback<Void>) null);
                        }
                    }
                }
            });
        }
        setDeviceTimezone();
        showLicense();
        showCloudVideoTips();
        TuTkClient.mConnect_Public_Key = 0;
        if (!(this.mCameraDevice == null || this.mCameraDevice.O000000o() == null)) {
            this.mCameraDevice.O000000o().O00000oO = new cll.O000000o() {
                /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass3 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
                 arg types: [java.lang.String, int]
                 candidates:
                  _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                  _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                  _m_j.cll.O000000o(java.lang.String, boolean):boolean */
                public void onCameraPropertyChanged(String str) {
                    if (!TextUtils.isEmpty(str) && "power".equals(str)) {
                        GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000Oo().O000000o("power");
                        if (GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx != null && GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice != null && !GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                            GeneralCameraV3UpgradePlayerActivity.this.hideLoading();
                            GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O0000OOo();
                        }
                    }
                }
            };
        }
        if (!(this.mCameraDevice == null || this.mCameraDevice.O000000o() == null)) {
            cll O000000o2 = this.mCameraDevice.O000000o();
            AnonymousClass4 r0 = new Callback<JSONArray>() {
                /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass4 */

                public void onSuccess(JSONArray jSONArray) {
                    if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing() && jSONArray != null) {
                        civ.O00000o("CameraProperties", "jsonArray==" + jSONArray.toString());
                        if (jSONArray.length() > 1) {
                            String optString = jSONArray.optString(0);
                            String optString2 = jSONArray.optString(1);
                            civ.O00000o("CameraProperties", "isAuto==" + optString + ",kbps=" + optString2);
                            if ("on".equals(optString)) {
                                civ.O00000o("CameraProperties", "获取自动");
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O000000o(1);
                            } else if ("off".equals(optString)) {
                                if (Integer.parseInt(optString2) > 70) {
                                    civ.O00000o("CameraProperties", "获取高清");
                                    GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O000000o(2);
                                } else {
                                    civ.O00000o("CameraProperties", "获取流畅");
                                    GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O000000o(0);
                                }
                            }
                            if (GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice != null && GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO() != null) {
                                GeneralCameraV3UpgradePlayerActivity generalCameraV3UpgradePlayerActivity = GeneralCameraV3UpgradePlayerActivity.this;
                                generalCameraV3UpgradePlayerActivity.setResolutionTextNew(generalCameraV3UpgradePlayerActivity.getResolutionIndexNew(generalCameraV3UpgradePlayerActivity.mCameraDevice.O00000oO().O0000o00));
                            }
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    if (GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                    }
                }
            };
            O000000o2.O00000o0.callMethod("GetAutoBitrate", new JSONArray(), new Callback<JSONArray>(r0) {
                /* class _m_j.cll.AnonymousClass6 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Callback f14079O000000o;

                {
                    this.f14079O000000o = r2;
                }

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONArray jSONArray = (JSONArray) obj;
                    Callback callback = this.f14079O000000o;
                    if (callback != null) {
                        callback.onSuccess(jSONArray);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = this.f14079O000000o;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, new Parser<JSONArray>() {
                /* class _m_j.cll.AnonymousClass7 */

                public final /* synthetic */ Object parse(String str) throws JSONException {
                    civ.O000000o("CameraProperties", "getAutoBitrate result=".concat(String.valueOf(str)));
                    return new JSONObject(str).optJSONArray("result");
                }
            });
        }
        chr.O000000o(this.mCameraDevice.getDid(), this.mCameraDevice.getModel());
        chr.O000000o(chr.O000o0Oo);
        chr.O000000o();
        civ.O000000o(this.mCameraDevice.getModel());
        addWeekRssi();
    }

    private void addWeekRssi() {
        this.mOfflineViewDelegate = new OfflineViewDelegate(this, this.mDeviceStat);
        this.mOfflineViewDelegate.onCreate();
        this.mOfflineViewDelegate.showWeakRssiIfNeed(hyy.O00000oO(this));
    }

    private void setDeviceTimezone() {
        if (this.mCameraDevice != null && this.mCameraDevice.O000000o() != null) {
            cll O000000o2 = this.mCameraDevice.O000000o();
            AnonymousClass5 r2 = new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass5 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(JSONObject jSONObject) {
                }
            };
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 3600000);
            O000000o2.O00000o0.callMethod("set_timezone", jSONArray, new Callback<JSONObject>(r2) {
                /* class _m_j.cll.AnonymousClass10 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Callback f14074O000000o;

                {
                    this.f14074O000000o = r2;
                }

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = this.f14074O000000o;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = this.f14074O000000o;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, new Parser<JSONObject>() {
                /* class _m_j.cll.AnonymousClass2 */

                public final /* synthetic */ Object parse(String str) throws JSONException {
                    cki.O00000o("CameraProperties", "set_timezone result=".concat(String.valueOf(str)));
                    return new JSONObject(str);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        initTitlebar();
        initCallView();
        initVideoView();
        initVideoControlView();
        initImagePopupView();
        initBottomNavigationView();
        this.mLandRecordTimer = (TextView) findViewById(R.id.landRecordTimer);
        this.record_time = (TextView) findViewById(R.id.record_time);
    }

    private void initBottomNavigationView() {
        this.llBottomTools = (ViewGroup) findViewById(R.id.port_bottom_functions);
        this.tvAlert = (TextView) findViewById(R.id.tvAlert);
        this.tvAlert.setOnClickListener(this);
        this.tvFace = (TextView) findViewById(R.id.tvFace);
        this.tvCloud = (TextView) findViewById(R.id.tvCloud);
        this.flCloudVideoTips = (FrameLayout) findViewById(R.id.fl_cloud_video_tips);
        if (this.mCameraDevice.isShared()) {
            this.flCloudVideoTips.setVisibility(8);
        }
        if (!XmPluginHostApi.instance().isInternationalServer(this)) {
            this.tvCloud.setVisibility(0);
            this.tvCloud.setOnClickListener(this);
            this.tvFace.setVisibility(0);
            this.tvFace.setOnClickListener(this);
        } else {
            this.tvCloud.setVisibility(8);
            this.tvFace.setVisibility(8);
        }
        this.tvPlayback = (TextView) findViewById(R.id.tvPlayback);
        this.tvPlayback.setOnClickListener(this);
    }

    private void initImagePopupView() {
        this.mLLFuncPopup = (LinearLayout) findViewById(R.id.llFuncPopup);
    }

    private void initVideoControlView() {
        this.mPortraitControlLayout = (LinearLayout) findViewById(R.id.port_control_layout);
        this.mPortraitControlLayout.setVisibility(0);
        this.mLLTopCtrlLandscape = (LinearLayout) findViewById(R.id.llLandTopCtrlLandscape);
        this.mLLTopCtrlLandscape.setVisibility(8);
        this.tvFullScreen = (ImageView) findViewById(R.id.port_fullscreen);
        this.tvFullScreen.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass6 */

            public void onClick(View view) {
                GeneralCameraV3UpgradePlayerActivity.this.setOrientation(true);
                chr.O000000o(chr.O000oOOO);
            }
        });
        this.mExitFullScreen = findViewById(R.id.land_fullScreen);
        this.mExitFullScreen.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass7 */

            public void onClick(View view) {
                GeneralCameraV3UpgradePlayerActivity.this.setOrientation(false);
                chr.O000000o(chr.O000oOOO);
            }
        });
        $$Lambda$GeneralCameraV3UpgradePlayerActivity$ecKkgyOjz9hL_eEy0ysJJpftR3E r0 = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$ecKkgyOjz9hL_eEy0ysJJpftR3E */

            public final void onClick(View view) {
                GeneralCameraV3UpgradePlayerActivity.this.lambda$initVideoControlView$0$GeneralCameraV3UpgradePlayerActivity(view);
            }
        };
        this.mPortResolution = (TextView) findViewById(R.id.port_resolution);
        this.mPortResolution.setOnClickListener(r0);
        this.mLandResolution = (TextView) findViewById(R.id.land_resolution);
        this.mLandResolution.setOnClickListener(r0);
        this.mPortSnapshot = (ImageView) findViewById(R.id.port_snapshot_view);
        this.mLandSnapshot = (ImageView) findViewById(R.id.land_snapshot);
        AnonymousClass8 r02 = new SingleClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass8 */

            public void onSingleClick() {
                chr.O000000o(chr.O000oO0);
                GeneralCameraV3UpgradePlayerActivity.this.snapShot();
            }

            public void onFastClick() {
                gqg.O000000o((int) R.string.btn_click_too_much);
            }
        };
        this.mPortSnapshot.setOnClickListener(r02);
        this.mLandSnapshot.setOnClickListener(r02);
        this.mPortAudioView = (MultiStateView) findViewById(R.id.port_audio_view);
        this.mLandAudioView = (MultiStateView) findViewById(R.id.land_audio_view);
        MultiStateView.StateItem stateItem = new MultiStateView.StateItem(R.drawable.camera_control_audio_mute_v1, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass9 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public void onClick(View view) {
                if (!GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    gqg.O000000o((int) R.string.power_off);
                    return;
                }
                chr.O000000o(chr.O000oO00);
                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O00000o0(false);
                    GeneralCameraV3UpgradePlayerActivity.this.mPortAudioView.setCurrentState(1);
                    GeneralCameraV3UpgradePlayerActivity.this.mLandAudioView.setCurrentState(1);
                }
            }
        });
        MultiStateView.StateItem stateItem2 = new MultiStateView.StateItem(R.drawable.camera_control_audio_v1, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass10 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public void onClick(View view) {
                if (!GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    gqg.O000000o((int) R.string.power_off);
                    return;
                }
                chr.O000000o(chr.O000oO00);
                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O00000o0(true);
                    GeneralCameraV3UpgradePlayerActivity.this.mPortAudioView.setCurrentState(0);
                    GeneralCameraV3UpgradePlayerActivity.this.mLandAudioView.setCurrentState(0);
                }
            }
        });
        this.mPortAudioView.addState(stateItem);
        this.mPortAudioView.addState(stateItem2);
        this.mPortAudioView.setCurrentState(0);
        this.mLandAudioView.addState(stateItem);
        this.mLandAudioView.addState(stateItem2);
        this.mLandAudioView.setCurrentState(0);
        this.mPortRecordView = (MultiStateView) findViewById(R.id.port_record_view);
        this.mLandRecordView = (MultiStateView) findViewById(R.id.land_record);
        MultiStateView.StateItem stateItem3 = new MultiStateView.StateItem(R.drawable.camera_control_record_v1, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass11 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public void onClick(View view) {
                if (!GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    gqg.O000000o((int) R.string.power_off);
                } else {
                    GeneralCameraV3UpgradePlayerActivity.this.doStartRecord();
                }
            }
        });
        MultiStateView.StateItem stateItem4 = new MultiStateView.StateItem(R.drawable.camera_control_recording_v1, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass12 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public void onClick(View view) {
                if (!GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    gqg.O000000o((int) R.string.power_off);
                } else {
                    GeneralCameraV3UpgradePlayerActivity.this.doStopRecord();
                }
            }
        });
        this.mPortRecordView.addState(stateItem3);
        this.mPortRecordView.addState(stateItem4);
        this.mPortRecordView.setCurrentState(0);
        this.mLandRecordView.addState(stateItem3);
        this.mLandRecordView.addState(stateItem4);
        this.mLandRecordView.setCurrentState(0);
        this.mPortSleepView = (MultiStateView) findViewById(R.id.port_sleep_view);
        this.mLandSleepView = (MultiStateView) findViewById(R.id.land_sleep_view);
        MultiStateView.StateItem stateItem5 = new MultiStateView.StateItem(R.drawable.camera_control_sleep_v1, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass13 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
             arg types: [java.lang.String, int, com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity$13$1]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void */
            public void onClick(View view) {
                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.isReadOnlyShared()) {
                    izb.O000000o(GeneralCameraV3UpgradePlayerActivity.this.mContext, (int) R.string.auth_fail_read_only, 0).show();
                } else if (GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice != null && GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o() != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", false, (Callback<Void>) new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass13.AnonymousClass1 */

                        public void onSuccess(Void voidR) {
                            if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                                GeneralCameraV3UpgradePlayerActivity.this.mPortSleepView.setCurrentState(1);
                                GeneralCameraV3UpgradePlayerActivity.this.mLandSleepView.setCurrentState(1);
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000Oo().O000000o("power");
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", Boolean.FALSE);
                                wd.O000000o("GenCameraV3UpgradePlayerAct", "set sleep success");
                                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000o() && GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx != null) {
                                    GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O0000o0o();
                                }
                                GeneralCameraV3UpgradePlayerActivity.this.toggleCtrlContainerVisibility();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                                GeneralCameraV3UpgradePlayerActivity.this.mPortSleepView.setCurrentState(0);
                                GeneralCameraV3UpgradePlayerActivity.this.mLandSleepView.setCurrentState(0);
                                GeneralCameraV3UpgradePlayerActivity.this.getContext();
                                gqg.O000000o((int) R.string.action_fail);
                                wd.O000000o("GenCameraV3UpgradePlayerAct", "set sleep failed:" + i + " s:" + str);
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000Oo().O000000o("power");
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", Boolean.TRUE);
                                GeneralCameraV3UpgradePlayerActivity.this.toggleCtrlContainerVisibility();
                            }
                        }
                    });
                }
            }
        });
        MultiStateView.StateItem stateItem6 = new MultiStateView.StateItem(R.drawable.camera_control_sleep_stop_v1, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass14 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
             arg types: [java.lang.String, int, com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity$14$1]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void */
            public void onClick(View view) {
                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.isReadOnlyShared()) {
                    izb.O000000o(GeneralCameraV3UpgradePlayerActivity.this.mContext, (int) R.string.auth_fail_read_only, 0).show();
                } else if (!GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", false) && GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice != null && GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o() != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", true, (Callback<Void>) new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass14.AnonymousClass1 */

                        public void onSuccess(Void voidR) {
                            if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                                GeneralCameraV3UpgradePlayerActivity.this.mPortSleepView.setCurrentState(0);
                                GeneralCameraV3UpgradePlayerActivity.this.mLandSleepView.setCurrentState(0);
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000Oo().O000000o("power");
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", Boolean.TRUE);
                                wd.O000000o("GenCameraV3UpgradePlayerAct", "set sleep success");
                                GeneralCameraV3UpgradePlayerActivity.this.toggleCtrlContainerVisibility();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                                GeneralCameraV3UpgradePlayerActivity.this.mPortSleepView.setCurrentState(1);
                                GeneralCameraV3UpgradePlayerActivity.this.mLandSleepView.setCurrentState(1);
                                GeneralCameraV3UpgradePlayerActivity.this.getContext();
                                gqg.O000000o((int) R.string.action_fail);
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000Oo().O000000o("power");
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", Boolean.FALSE);
                                GeneralCameraV3UpgradePlayerActivity.this.toggleCtrlContainerVisibility();
                                wd.O000000o("GenCameraV3UpgradePlayerAct", "set sleep failed:" + i + " s:" + str);
                            }
                        }
                    });
                }
            }
        });
        this.mPortSleepView.addState(stateItem5);
        this.mPortSleepView.addState(stateItem6);
        this.mPortSleepView.setCurrentState(0);
        this.mLandSleepView.addState(stateItem5);
        this.mLandSleepView.addState(stateItem6);
        this.mLandSleepView.setCurrentState(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public /* synthetic */ void lambda$initVideoControlView$0$GeneralCameraV3UpgradePlayerActivity(View view) {
        chr.O000000o(chr.O0000OOo);
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            gqg.O000000o((int) R.string.power_off);
        } else {
            toggleResolution();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float */
    private void initVideoView() {
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.camera_up_layout);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this);
        this.mVideoViewFrame.addView(frameLayout, 0, layoutParams);
        this.mVideoParentView = (ViewGroup) findViewById(R.id.rlParent);
        this.mVideoView = ciy.O000000o(this.mCameraDevice.getModel(), frameLayout);
        this.mVideoView.O00000Oo(6.0f, 6.0f);
        this.mVideoView.O000000o(0.2734375f);
        this.mCameraPlayerEx = ciy.O000000o(this, this.mCameraDevice, this);
        this.mCameraPlayerEx.O000000o(this.mIRecodeTimeListener);
        this.mCameraPlayerEx.O000000o(this.mVideoView);
        float f = 1.0f;
        this.mSurfaceViewScale = 1.0f;
        this.mSurfaceViewOffsetX = 0.0f;
        this.mSurfaceViewOffsetY = 0.0f;
        if (this.mCameraDevice != null && !TextUtils.isEmpty(this.mCameraDevice.getModel()) && !TextUtils.isEmpty(this.mCameraDevice.getModel())) {
            String O000000o2 = grv.O000000o(this.mCameraDevice.getModel() + this.mCameraDevice.getDid());
            this.mSurfaceViewScale = gpy.O000000o(gkv.f17949O000000o, O000000o2, "scale", 1.0f);
            this.mSurfaceViewOffsetX = gpy.O000000o(gkv.f17949O000000o, O000000o2, "offsetX", 0.0f);
            this.mSurfaceViewOffsetY = gpy.O000000o(gkv.f17949O000000o, O000000o2, "offsetY", 0.0f);
        }
        cjh cjh = this.mVideoView;
        if (this.mSurfaceViewScale > 0.0f) {
            f = this.mSurfaceViewScale;
        }
        cjh.O00000Oo(f);
        this.mVideoView.O00000o0(this.mSurfaceViewOffsetX);
        this.mVideoView.O00000o(this.mSurfaceViewOffsetY);
        this.mLoadingView = LayoutInflater.from(this).inflate((int) R.layout.camera_progress, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        frameLayout.addView(this.mLoadingView, layoutParams2);
        this.mLoadingProgress = (TextView) this.mLoadingView.findViewById(R.id.loading_progress);
        this.mLoadingTitle = (TextView) this.mLoadingView.findViewById(R.id.loading_title);
        this.mLoadingImageView = (ImageView) this.mLoadingView.findViewById(R.id.loading_anim);
        this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_anim_camera_loading);
        this.mLoadingImageView.setImageDrawable(this.mLoadingAnimation);
        if (!cin.O000000o()) {
            this.mLoadingImageView.setVisibility(8);
        }
        this.mLoadingView.setVisibility(8);
        this.mErrorRetryView = LayoutInflater.from(this).inflate((int) R.layout.camera_error_retry, (ViewGroup) null);
        this.mErrorRetryView = LayoutInflater.from(this).inflate((int) R.layout.camera_error_retry, (ViewGroup) null);
        this.retry_tv = (TextView) this.mErrorRetryView.findViewById(R.id.retry_tv);
        this.retry_tv.setOnClickListener(this);
        this.retry_tv.setVisibility(0);
        this.see_help = (TextView) this.mErrorRetryView.findViewById(R.id.see_help);
        this.see_help.setOnClickListener(this);
        this.see_help.setVisibility(0);
        this.offline_time = (TextView) this.mErrorRetryView.findViewById(R.id.offline_time);
        ((ImageView) this.mErrorRetryView.findViewById(R.id.retry_btn)).setImageResource(R.drawable.camera_state_sequence_sleep_hualai);
        frameLayout.addView(this.mErrorRetryView, layoutParams2);
        this.mErrorRetryView.setVisibility(8);
        this.mRetryView = this.mErrorRetryView.findViewById(R.id.retry_btn);
        this.mErrorInfoView = (TextView) this.mErrorRetryView.findViewById(R.id.error_info);
        this.mPowerOffView = LayoutInflater.from(this).inflate((int) R.layout.camera_closed, (ViewGroup) null);
        ((ImageView) this.mPowerOffView.findViewById(R.id.icon)).setImageResource(R.drawable.camera_state_sequence_sleep_hualai);
        frameLayout.addView(this.mPowerOffView, layoutParams2);
        this.mPowerOffView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass15 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
             arg types: [java.lang.String, int, com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity$15$1]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void */
            public void onClick(View view) {
                civ.O00000o("GenCameraV3UpgradePlayerAct", "mPowerOffView");
                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice != null && GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o() != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", true, (Callback<Void>) new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass15.AnonymousClass1 */

                        public void onSuccess(Void voidR) {
                            if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000Oo().O000000o("power");
                                GeneralCameraV3UpgradePlayerActivity.this.mPortAudioView.setCurrentState(0);
                                GeneralCameraV3UpgradePlayerActivity.this.mLandAudioView.setCurrentState(0);
                                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx != null) {
                                    GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O00000o0(true);
                                }
                                civ.O00000o("GenCameraV3UpgradePlayerAct", "set wakeup success");
                                GeneralCameraV3UpgradePlayerActivity.this.toggleCtrlContainerVisibility();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                                GeneralCameraV3UpgradePlayerActivity.this.mPortAudioView.setCurrentState(0);
                                GeneralCameraV3UpgradePlayerActivity.this.mLandAudioView.setCurrentState(0);
                                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx != null) {
                                    GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O00000o0(true);
                                }
                                GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", Boolean.FALSE);
                                gqg.O000000o((int) R.string.action_fail);
                                civ.O00000o("GenCameraV3UpgradePlayerAct", "set wakeup failed:" + i + " s:" + str);
                                GeneralCameraV3UpgradePlayerActivity.this.toggleCtrlContainerVisibility();
                            }
                        }
                    });
                }
            }
        });
        this.mPowerOffView.setVisibility(8);
        this.mVideoView.O000000o(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$Cq600JRIQ5nKec1QjCaIEl2MbeI */

            public final void onVideoViewClick() {
                GeneralCameraV3UpgradePlayerActivity.this.lambda$initVideoView$1$GeneralCameraV3UpgradePlayerActivity();
            }
        });
        this.mFrameRate = (TextView) findViewById(R.id.sub_title_bar_title);
        this.mFrameRate.setTextColor(getResources().getColor(R.color.camera_white_50_transparent));
        this.mVideoView.O000000o(new XmVideoViewGl.IVideoViewScaleListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass16 */

            public void reportVideoViewScaleEvent(int i) {
                String str;
                if (i == 1) {
                    str = chr.O000o;
                } else if (i != 2) {
                    str = i != 3 ? "" : chr.O000o0oo;
                } else {
                    str = chr.O000o0o;
                }
                if (!TextUtils.isEmpty(str)) {
                    chr.O000000o(str);
                }
            }
        });
        this.mRetryView.setOnClickListener(this);
        this.mPauseView = findViewById(R.id.pause_view);
        this.mPauseView.setOnClickListener(this);
        this.mVideoView.O000000o($$Lambda$GeneralCameraV3UpgradePlayerActivity$27xv_2B7gk9SCahmnzrz6CZy9VE.INSTANCE);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public /* synthetic */ void lambda$initVideoView$1$GeneralCameraV3UpgradePlayerActivity() {
        if (this.mCameraDevice.O000000o().O000000o("power", true)) {
            videoClick();
        }
    }

    static /* synthetic */ void lambda$initVideoView$2(int i) {
        String str;
        if (i == 1) {
            str = chr.O000o;
        } else if (i != 2) {
            str = i != 3 ? "" : chr.O000o0oo;
        } else {
            str = chr.O000o0o;
        }
        if (!TextUtils.isEmpty(str)) {
            chr.O000000o(str);
        }
    }

    private void initCallView() {
        this.mPortCallView = (MultiStateView) findViewById(R.id.port_call_view);
        this.mLandCallView = (MultiStateView) findViewById(R.id.land_call_view);
        AnonymousClass17 r0 = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass17 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public void onClick(View view) {
                if (!GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    gqg.O000000o((int) R.string.power_off);
                    return;
                }
                chr.O000000o(chr.O000oOoo);
                if (ciw.O000000o(GeneralCameraV3UpgradePlayerActivity.this.getRequestedOrientation())) {
                    GeneralCameraV3UpgradePlayerActivity.this.mLandCallView.startAnimation(AnimationUtils.loadAnimation(GeneralCameraV3UpgradePlayerActivity.this.mContext, R.anim.anim_scale_in_out));
                } else {
                    GeneralCameraV3UpgradePlayerActivity.this.mPortCallView.startAnimation(AnimationUtils.loadAnimation(GeneralCameraV3UpgradePlayerActivity.this.mContext, R.anim.anim_scale_in_out));
                }
                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx == null || !GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O0000Ooo()) {
                    gqg.O000000o((int) R.string.call_no_play);
                } else if (!GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O00000Oo()) {
                    gqg.O000000o((int) R.string.not_on_live);
                } else {
                    GeneralCameraV3UpgradePlayerActivity generalCameraV3UpgradePlayerActivity = GeneralCameraV3UpgradePlayerActivity.this;
                    generalCameraV3UpgradePlayerActivity.mCallingAudioOn = generalCameraV3UpgradePlayerActivity.mPortAudioView.getCurrentState() == 1;
                    if (XmPluginHostApi.instance().checkAndRequestPermisson(GeneralCameraV3UpgradePlayerActivity.this.mContext, true, new Callback<List<String>>() {
                        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass17.AnonymousClass1 */

                        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                            onSuccess((List<String>) ((List) obj));
                        }

                        public void onSuccess(List<String> list) {
                            if (GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                                gqg.O000000o((int) R.string.audio_permission_denied);
                            }
                        }
                    }, "android.permission.RECORD_AUDIO")) {
                        if (!GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O00000o0()) {
                            GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O00000o();
                            GeneralCameraV3UpgradePlayerActivity.this.mHandler.sendEmptyMessageDelayed(2101, 500);
                            GeneralCameraV3UpgradePlayerActivity.this.mLandCallView.setCurrentState(1);
                            GeneralCameraV3UpgradePlayerActivity.this.mPortCallView.setCurrentState(1);
                            GeneralCameraV3UpgradePlayerActivity.this.mPortAudioView.setCurrentState(1);
                            GeneralCameraV3UpgradePlayerActivity.this.mLandAudioView.setCurrentState(1);
                            chr.O0000Oo0();
                            return;
                        }
                        civ.O00000o("GenCameraV3UpgradePlayerAct", "正在通话中");
                    }
                }
            }
        };
        MultiStateView.StateItem stateItem = new MultiStateView.StateItem(R.drawable.icon_call_new, r0);
        MultiStateView.StateItem stateItem2 = new MultiStateView.StateItem(R.drawable.selector_icon_call, r0);
        AnonymousClass18 r02 = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass18 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public void onClick(View view) {
                if (!GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    gqg.O000000o((int) R.string.power_off);
                    return;
                }
                if (ciw.O000000o(GeneralCameraV3UpgradePlayerActivity.this.getRequestedOrientation())) {
                    GeneralCameraV3UpgradePlayerActivity.this.mLandCallView.startAnimation(AnimationUtils.loadAnimation(GeneralCameraV3UpgradePlayerActivity.this.mContext, R.anim.anim_scale_in_out));
                } else {
                    GeneralCameraV3UpgradePlayerActivity.this.mPortCallView.startAnimation(AnimationUtils.loadAnimation(GeneralCameraV3UpgradePlayerActivity.this.mContext, R.anim.anim_scale_in_out));
                }
                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O00000oO();
                    GeneralCameraV3UpgradePlayerActivity.this.mHandler.removeMessages(2101);
                    GeneralCameraV3UpgradePlayerActivity.this.mLandCallView.setCurrentState(0);
                    GeneralCameraV3UpgradePlayerActivity.this.mPortCallView.setCurrentState(0);
                    chr.O0000Oo();
                }
                if (GeneralCameraV3UpgradePlayerActivity.this.mAudioOn) {
                    GeneralCameraV3UpgradePlayerActivity.this.mPortAudioView.setCurrentState(1);
                    GeneralCameraV3UpgradePlayerActivity.this.mLandAudioView.setCurrentState(1);
                    if (GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx != null) {
                        GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O00000o0(false);
                        return;
                    }
                    return;
                }
                GeneralCameraV3UpgradePlayerActivity.this.mPortAudioView.setCurrentState(0);
                GeneralCameraV3UpgradePlayerActivity.this.mLandAudioView.setCurrentState(0);
                if (GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx.O00000o0(true);
                }
            }
        };
        MultiStateView.StateItem stateItem3 = new MultiStateView.StateItem(R.drawable.icon_calling_new, r02);
        MultiStateView.StateItem stateItem4 = new MultiStateView.StateItem(R.drawable.selector_icon_calling, r02);
        this.mLandCallView.addState(stateItem2);
        this.mPortCallView.addState(stateItem);
        this.mLandCallView.addState(stateItem4);
        this.mPortCallView.addState(stateItem3);
        this.mPortCallView.setCurrentState(0);
        this.mLandCallView.setCurrentState(0);
    }

    private void initTitlebar() {
        this.mNewFirmView = findViewById(R.id.title_bar_redpoint);
        this.mTitleView = (TextView) findViewById(R.id.title_bar_title);
        this.mTitleView.setTextColor(getResources().getColor(R.color.camera_white_80_transparent));
        this.mTimeUpdateView = (TextView) findViewById(R.id.time_container_center);
        this.mTitleMore = (ImageView) findViewById(R.id.title_bar_more);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        ((ImageView) findViewById(R.id.title_bar_return)).setImageResource(R.drawable.camera_icon_back_white);
        this.mTitleMore.setVisibility(0);
        this.mTitleMore.setImageResource(R.drawable.camera_icon_right_more_white);
        this.mTitleMore.setOnClickListener(new SingleClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass19 */

            public void onSingleClick() {
                GeneralCameraV3UpgradePlayerActivity generalCameraV3UpgradePlayerActivity = GeneralCameraV3UpgradePlayerActivity.this;
                generalCameraV3UpgradePlayerActivity.onClick(generalCameraV3UpgradePlayerActivity.mTitleMore);
            }
        });
        this.mTitleMore.setOnClickListener(this);
        findViewById(R.id.title_bar_share).setVisibility(8);
    }

    private void showCloudVideoTips() {
        if (!this.mCameraDevice.isShared() && this.mCameraDevice.O00000oO().O0000O0o()) {
            CloudVideoNetUtils.getInstance().getCloudPromoteTips(this.mDid, new ICloudVideoCallback<String>() {
                /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass20 */

                public void onCloudVideoSuccess(String str, Object obj) {
                    GeneralCameraV3UpgradePlayerActivity.this.flCloudVideoTips.setVisibility(0);
                    GeneralCameraV3UpgradePlayerActivity.this.flCloudVideoTips.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$auPtbzoolGR1vzf8HUiXuQKDg0 */

                        public final void onClick(View view) {
                            GeneralCameraV3UpgradePlayerActivity.this.onClick(view);
                        }
                    });
                    ((TextView) GeneralCameraV3UpgradePlayerActivity.this.findViewById(R.id.tv_cloud_video_tips)).setText(str);
                    if (GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O0000Ooo == 0) {
                        GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O00000Oo(System.currentTimeMillis());
                    }
                }

                public void onCloudVideoFailed(int i, String str) {
                    gsy.O00000Oo("GenCameraV3UpgradePlayerAct", str);
                }
            });
        }
    }

    public boolean canStepOut() {
        return canStepOut(0, 0);
    }

    public boolean canStepOut(int i, int i2) {
        if (this.mCameraPlayerEx == null) {
            return true;
        }
        if (this.mCameraPlayerEx.O00000oo() || this.mCameraPlayerEx.O00000o0()) {
            if (i > 0) {
                gqg.O000000o(i);
            } else {
                gqg.O000000o((int) R.string.speaking_block);
            }
            return false;
        } else if (!this.mCameraPlayerEx.O0000O0o()) {
            return true;
        } else {
            if (i2 > 0) {
                gqg.O000000o(i2);
            } else {
                gqg.O000000o((int) R.string.recording_block);
            }
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyy.O000000o(android.app.Activity, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity, boolean]
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
        civ.O00000o("GenCameraV3UpgradePlayerAct", "newConfig.orientation:" + configuration.orientation);
        setWindow(configuration);
        try {
            if (this.mFullScreen) {
                this.flTitleBar.setVisibility(8);
                this.mPortraitControlLayout.setVisibility(8);
                this.llBottomTools.setVisibility(8);
                this.mLLTopCtrlLandscape.setVisibility(0);
                this.mVideoView.O000000o(true);
                if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O0000O0o()) {
                    this.mLandRecordTimer.setVisibility(0);
                }
                this.mFullInTime = System.currentTimeMillis();
                this.mLandCallView.setVisibility(0);
                this.mPortCallView.setVisibility(8);
                changeVideoFrame(false);
            } else {
                this.flTitleBar.setVisibility(0);
                this.mPortraitControlLayout.setVisibility(0);
                this.llBottomTools.setVisibility(0);
                this.mLLTopCtrlLandscape.setVisibility(8);
                this.mVideoView.O000000o(false);
                if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O0000O0o()) {
                    this.mLandRecordTimer.setVisibility(8);
                }
                if (this.mFullInTime > 0) {
                    this.mFullInTime = 0;
                }
                this.mPortCallView.setVisibility(0);
                this.mLandCallView.setVisibility(8);
                changeVideoFrame(true);
            }
            hyy.O000000o((Activity) this, this.mFullScreen);
        } catch (Exception e) {
            gsy.O000000o(6, "GenCameraV3UpgradePlayerAct", "onConfigurationChanged:" + e.getLocalizedMessage());
        }
    }

    private void changeVideoFrame(boolean z) {
        if (z) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mVideoViewFrame.getLayoutParams();
            layoutParams.O000OOoO = 0.65f;
            layoutParams.O0000OoO = -1;
            layoutParams.O00000o = 0;
            layoutParams.O0000O0o = 0;
            layoutParams.O0000OOo = 0;
            this.mVideoViewFrame.setLayoutParams(layoutParams);
            return;
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.mVideoViewFrame.getLayoutParams();
        layoutParams2.O0000OoO = 0;
        layoutParams2.O00000o = 0;
        layoutParams2.O0000O0o = 0;
        layoutParams2.O0000OOo = 0;
        layoutParams2.O000OOoO = 1.0f;
        this.mVideoViewFrame.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public void onClick(View view) {
        if (!doOnClick(view)) {
            int id = view.getId();
            if (id == R.id.title_bar_more) {
                if (canStepOut(R.string.speaking_block, R.string.recording_block) && !CameraJumpUtils.openMoreSetting(this, this.mCameraDevice)) {
                    this.mNewFirmView.setVisibility(8);
                    civ.O00000o0("CameraPlay", "more");
                }
            } else if (id == R.id.title_bar_share) {
                if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                    gqg.O000000o((int) R.string.power_off_share);
                } else if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
                        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass21 */

                        public void onSnap(Bitmap bitmap) {
                            String O000000o2 = C0118cif.O000000o(bitmap, GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.getDid());
                            if (O000000o2 != null) {
                                CameraJumpUtils.openShareMediaActivity(GeneralCameraV3UpgradePlayerActivity.this.mContext, GeneralCameraV3UpgradePlayerActivity.this.mDeviceStat.name, "", O000000o2);
                            }
                        }
                    });
                }
            } else if (id == R.id.tvCloud) {
                chr.O000000o(chr.O000oo0);
                if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    if (clf.O00000o0()) {
                        if (!this.mCameraDevice.isShared() || this.mCameraDevice.O00000oO().O00000Oo()) {
                            String O0000o0 = CoreApi.O000000o().O0000o0();
                            if (this.mCameraDevice.O00000oO().O00000Oo() || this.mCameraDevice.O00000oO().O000000o()) {
                                LogType logType = LogType.CAMERA;
                                String model = this.mCameraDevice.getModel();
                                gsy.O00000o0(logType, model, "GenCameraV3UpgradePlayerAct", "openCloudVideoList did=" + this.mCameraDevice.getDid() + " uid=" + O0000o0 + " vip=" + this.mCameraDevice.O00000oO().O00000Oo() + " window=" + this.mCameraDevice.O00000oO().O000000o());
                                fsp.O000000o().O0000Oo.openCloudVideoListActivity(this, this.mCameraDevice.getDid(), this.mCameraDevice.getName());
                            } else {
                                LogType logType2 = LogType.CAMERA;
                                String model2 = this.mCameraDevice.getModel();
                                gsy.O00000o0(logType2, model2, "GenCameraV3UpgradePlayerAct", "openCloudVideoBuyPage did=" + this.mCameraDevice.getDid() + " uid=" + O0000o0 + " vip=" + this.mCameraDevice.O00000oO().O00000Oo() + " window=" + this.mCameraDevice.O00000oO().O000000o());
                                CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(this, this.mCameraDevice.getDid());
                            }
                            this.mCameraDevice.O00000oO().O00000oo();
                        } else {
                            gqg.O000000o((int) R.string.cloud_share_hint);
                            return;
                        }
                    }
                    this.flCloudVideoTips.setVisibility(8);
                }
            } else if (id == R.id.tvAlert) {
                civ.O00000o("GenCameraV3UpgradePlayerAct", "tvAlarm click");
                chr.O000000o(chr.O00000o);
                chr.O000000o(chr.O000oOo);
                if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    if (!this.mCameraDevice.O00000oO().O0000O0o || this.mCameraDevice.isReadOnlyShared()) {
                        startActivity(new Intent(this, AlarmVideoActivity.class));
                    } else {
                        startActivity(new Intent(this, AlarmGuideActivity.class));
                    }
                }
            } else if (id == R.id.tvPlayback) {
                chr.O0000o0o();
                chr.O000000o(chr.O000oOoO);
                if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                    gqg.O000000o((int) R.string.power_off);
                } else if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O0000Ooo()) {
                        gqg.O000000o((int) R.string.no_playback_for_connect);
                    } else if (!this.mSdcardDetectResult.sdcardGetSuccess) {
                        gqg.O000000o((int) R.string.sd_card_hint_title);
                    } else if (this.mSdcardDetectResult.sdcardStatus == 4) {
                        gqg.O000000o(getString(R.string.camera_storage_sdcard_formating_tips));
                    } else if (this.mSdcardDetectResult.sdcardStatus == 3) {
                        startActivity(new Intent(this, SDCardStatusActivityNew.class));
                    } else if (this.mSdcardDetectResult.sdcardStatus == 1 || this.mSdcardDetectResult.sdcardStatus == 5) {
                        startActivity(new Intent(this, NoMemoryCardActivity.class));
                    } else {
                        startActivity(new Intent(this, CameraActivityUtils.isFirmWareSupportTimelineVersion(this.mCameraDevice.O00000o0(), "4.0.4_0068") ? SDCardTimeLinePlayerExActivity.class : SDCardActivity.class));
                    }
                }
            } else if (id == R.id.fl_cloud_video_tips) {
                CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(this, this.mCameraDevice.getDid());
                this.mCameraDevice.O00000oO().O00000oo();
                this.flCloudVideoTips.setVisibility(8);
            } else if (id == R.id.tvFace) {
                chr.O000000o(chr.O000oo0O);
                if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    if (this.mCameraDevice.isShared()) {
                        gqg.O000000o(getString(R.string.no_permit_for_face_tips));
                    } else if (!this.mCameraDevice.O00000oO().O00000Oo()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("is_vip_user", false);
                            jSONObject.put("is_from_camera", true);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        fsp.O000000o().O0000Oo.openFaceManagerActivity(546, this.mContext, this.mCameraDevice.getDid(), jSONObject.toString());
                    } else {
                        fsp.O000000o().O0000Oo.openFaceManagerActivity(this, this.mCameraDevice.getDid());
                    }
                }
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    public void doStartRecord() {
        chr.O000000o(chr.O00000oO);
        chr.O000000o(chr.O000oO0O);
        if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O0000O0o()) {
            this.mLandRecordView.setCurrentState(1);
            this.mPortRecordView.setCurrentState(1);
        } else if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            gqg.O000000o((int) R.string.power_off);
            this.mLandRecordView.setCurrentState(0);
            this.mPortRecordView.setCurrentState(0);
        } else {
            this.recordingfilePath = me.O000000o(true, this.mCameraDevice.getDid());
            if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000Oo()) {
                gqg.O000000o((int) R.string.record_not_connect);
                this.mLandRecordView.setCurrentState(0);
                this.mPortRecordView.setCurrentState(0);
            } else if (!mk.O000000o(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                gqg.O000000o((int) R.string.no_write_permission);
                this.mLandRecordView.setCurrentState(0);
                this.mPortRecordView.setCurrentState(0);
            } else if (!TextUtils.isEmpty(this.recordingfilePath)) {
                this.mCameraPlayerEx.O000000o((IXmConnectionClient.XmActionCallback) null);
                gsy.O00000Oo("GenCameraV3UpgradePlayerAct", "获取当前的帧率");
                if (this.mFullScreen) {
                    this.mLandRecordTimer.setText(getString(R.string.main_recording, new Object[]{"00:00:00"}));
                    this.mLandRecordTimer.setVisibility(0);
                } else {
                    this.record_time.setTextColor(-65536);
                    this.record_time.setVisibility(0);
                    this.record_time.setText(getString(R.string.main_recording, new Object[]{"00:00:00"}));
                }
                civ.O000000o("GenCameraV3UpgradePlayerAct", "startRecord");
                this.mLandRecordView.setCurrentState(1);
                this.mPortRecordView.setCurrentState(1);
                if (this.mCameraPlayerEx != null) {
                    this.mCameraPlayerEx.O00000Oo(true);
                }
            } else {
                gqg.O000000o((int) R.string.snip_video_failed);
                this.mLandRecordView.setCurrentState(0);
                this.mPortRecordView.setCurrentState(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void doStopRecord() {
        if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000O0o()) {
            MultiStateView multiStateView = this.mLandRecordView;
            if (multiStateView != null) {
                multiStateView.setCurrentState(0);
            }
            MultiStateView multiStateView2 = this.mPortRecordView;
            if (multiStateView2 != null) {
                multiStateView2.setCurrentState(0);
                return;
            }
            return;
        }
        if (this.mCameraPlayerEx.O0000OoO()) {
            this.mCameraPlayerEx.O00000Oo(false);
        }
        this.mCameraPlayerEx.O000000o(new XmMp4Record.IRecordListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass22 */

            public void onSuccess(String str) {
                if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                    GeneralCameraV3UpgradePlayerActivity.this.runOnUiThread(new Runnable(str) {
                        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$22$RL1XnRzwIjxsr3kqyPadxA8s94 */
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            GeneralCameraV3UpgradePlayerActivity.AnonymousClass22.this.lambda$onSuccess$0$GeneralCameraV3UpgradePlayerActivity$22(this.f$1);
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$GeneralCameraV3UpgradePlayerActivity$22(String str) {
                GeneralCameraV3UpgradePlayerActivity.this.mLandRecordTimer.setVisibility(8);
                GeneralCameraV3UpgradePlayerActivity.this.onVideoRecorded(str);
                if (GeneralCameraV3UpgradePlayerActivity.this.mLandRecordView != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mLandRecordView.setCurrentState(0);
                }
                if (GeneralCameraV3UpgradePlayerActivity.this.mPortRecordView != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mPortRecordView.setCurrentState(0);
                }
                GeneralCameraV3UpgradePlayerActivity.this.record_time.setVisibility(8);
            }

            public void onFailed(int i, String str) {
                if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                    GeneralCameraV3UpgradePlayerActivity.this.runOnUiThread(new Runnable(i) {
                        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$22$vw4T5nuJpGS2GUiXNp878niHRX4 */
                        private final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            GeneralCameraV3UpgradePlayerActivity.AnonymousClass22.this.lambda$onFailed$1$GeneralCameraV3UpgradePlayerActivity$22(this.f$1);
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailed$1$GeneralCameraV3UpgradePlayerActivity$22(int i) {
                GeneralCameraV3UpgradePlayerActivity.this.mLandRecordTimer.setVisibility(8);
                if (GeneralCameraV3UpgradePlayerActivity.this.mLandRecordView != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mLandRecordView.setCurrentState(0);
                }
                if (GeneralCameraV3UpgradePlayerActivity.this.mPortRecordView != null) {
                    GeneralCameraV3UpgradePlayerActivity.this.mPortRecordView.setCurrentState(0);
                }
                if (i == -2) {
                    gqg.O000000o((int) R.string.snip_video_failed_time_mini);
                } else {
                    gqg.O000000o((int) R.string.snip_video_failed);
                }
                GeneralCameraV3UpgradePlayerActivity.this.record_time.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void doStopCall() {
        if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O00000o0()) {
            this.mCameraPlayerEx.O00000oO();
            this.mHandler.removeMessages(2101);
        }
        if (this.mLandCallView != null && this.mLandCallView.getCurrentState() == 1) {
            this.mLandCallView.setCurrentState(0);
        }
        MultiStateView multiStateView = this.mPortCallView;
        if (multiStateView != null && multiStateView.getCurrentState() == 1) {
            this.mPortCallView.setCurrentState(0);
        }
        if (this.mCallingAudioOn) {
            this.mPortAudioView.setCurrentState(1);
            this.mLandAudioView.setCurrentState(1);
            if (this.mCameraPlayerEx != null) {
                this.mCameraPlayerEx.O00000o0(false);
            }
        } else {
            if (!(ciq.O000000o().f13906O000000o.get(this.mCameraDevice.getDid()) != null)) {
                this.mPortAudioView.setCurrentState(0);
                this.mLandAudioView.setCurrentState(0);
                if (this.mCameraPlayerEx != null) {
                    this.mCameraPlayerEx.O00000o0(true);
                }
            }
        }
        this.mAudioOn = this.mCallingAudioOn;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1220) {
            if (this.mDeviceStat != null) {
                boolean isUsrExpPlanEnabled = XmPluginHostApi.instance().isUsrExpPlanEnabled(this.mDeviceStat.did);
                chr.O00Ooo0O = isUsrExpPlanEnabled;
                if (isUsrExpPlanEnabled != this.mCameraDevice.O000000o().O000000o("improve_program", false)) {
                    this.mCameraDevice.O000000o().O000000o("improve_program", isUsrExpPlanEnabled, (Callback<Void>) null);
                }
            }
            if (i2 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra("result_data");
                if (TextUtils.isEmpty(stringExtra) || !stringExtra.equals("removedLicense")) {
                    String stringExtra2 = intent.getStringExtra("menu");
                    if (!TextUtils.isEmpty(stringExtra2) && stringExtra2.equals(getString(R.string.more_alarm_setting))) {
                        izb.O000000o(this, (int) R.string.auth_fail, 0).show();
                    }
                } else {
                    this.mCameraDevice.O00000oO().O00000oO(true);
                    finish();
                }
                if (intent.getBooleanExtra("open_float_window", false)) {
                    finish();
                    return;
                }
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void setResolutionTextNew(int i) {
        TextView textView = this.mLandResolution;
        if (textView != null) {
            if (i == 0) {
                textView.setText((int) R.string.quality_360P);
                this.mPortResolution.setText((int) R.string.quality_360P);
            } else if (i == 1) {
                this.mPortResolution.setText((int) R.string.quality_auto);
                this.mLandResolution.setText((int) R.string.quality_auto);
            } else if (i != 2) {
                this.mPortResolution.setText((int) R.string.quality_360P);
                this.mLandResolution.setText((int) R.string.quality_360P);
            } else {
                textView.setText((int) R.string.quality_1080P);
                this.mPortResolution.setText((int) R.string.quality_1080P);
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
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void setOrientation(boolean z) {
        if (!z) {
            setRequestedOrientation(1);
            if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O0000O0o()) {
                this.record_time.setVisibility(0);
            }
        } else if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            gqg.O000000o((int) R.string.power_off);
        } else {
            enterPadFullScreen();
            setRequestedOrientation(0);
            this.record_time.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        mi.O00000Oo();
        MIStreamStatistic.getInstance().latestLiveVideo = System.currentTimeMillis();
        civ.O00000o("GenCameraV3UpgradePlayerAct", "onResume  ....isTimeLapsePhotography=" + this.isTimeLapsePhotography);
        if (this.isTimeLapsePhotography) {
            doResume();
        }
        this.isTimeLapsePhotography = false;
        CameraActivityUtils.isCloudVideoUser(this.mCameraDevice, this);
        this.mCameraDevice.updateDeviceStatus();
        if (this.mCameraDevice.isOwner()) {
            this.mCameraDevice.checkDeviceUpdateInfo(new Callback<DeviceUpdateInfo>() {
                /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass23 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(DeviceUpdateInfo deviceUpdateInfo) {
                    Message.obtain(GeneralCameraV3UpgradePlayerActivity.this.mHandler, 1, deviceUpdateInfo).sendToTarget();
                }
            });
        }
        ((TextView) findViewById(R.id.title_bar_title)).setText(this.mCameraDevice.getName());
        if (!this.mNeedLicense || this.mCameraDevice.isShared()) {
            if (!this.isFirstResumed || this.mCameraDevice.deviceStat().isOnline) {
                this.isFirstResumed = true;
                if (this.mNeedPincode) {
                    this.mHandler.removeMessages(2100);
                    this.mHandler.sendEmptyMessageDelayed(2100, 1000);
                } else {
                    this.mHandler.removeMessages(2100);
                    this.mHandler.sendEmptyMessage(2100);
                }
            }
            this.mHandler.sendEmptyMessage(3051);
        }
        TextView textView = this.mTimeUpdateView;
        if (textView != null && textView.getVisibility() == 0) {
            this.mTimeUpdateView.setVisibility(8);
        }
        this.mNeedPincode = false;
        if (this.mAudioOn) {
            this.mPortAudioView.setCurrentState(1);
            this.mLandAudioView.setCurrentState(1);
            if (this.mCameraPlayerEx != null) {
                this.mCameraPlayerEx.O00000o0(false);
                return;
            }
            return;
        }
        this.mPortAudioView.setCurrentState(0);
        this.mLandAudioView.setCurrentState(0);
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O00000o0(true);
        }
    }

    public void onStop() {
        super.onStop();
        this.mHandler.removeMessages(2100);
        doStopCall();
        doStopRecord();
    }

    public void onPause() {
        if (!this.isTimeLapsePhotography && this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O0000OOo();
        }
        if (this.mPortAudioView.getCurrentState() == 1) {
            this.mAudioOn = true;
        } else {
            this.mAudioOn = false;
        }
        dismissSnapshotPopupRunnable(0);
        eventLiveVideoDuration();
        super.onPause();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    /* access modifiers changed from: protected */
    public void resumeCamera() {
        if (this.mPauseView != null) {
            this.mPauseView.setVisibility(8);
        }
        if (mg.O00000o0(this)) {
            this.mAllowMobileNetwork = true;
        }
        if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O0000o0() && this.mCameraDevice != null && this.mCameraDevice.O000000o().O000000o("power", true)) {
            hidError();
            showLoading("");
            this.mCameraPlayerEx.O0000o0O();
        }
        refreshUI();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i != 1) {
            if (i == 3051) {
                this.mCameraDevice.O00000Oo(getContext(), new Callback<Integer[]>() {
                    /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass24 */

                    public void onSuccess(Integer[] numArr) {
                        if (GeneralCameraV3UpgradePlayerActivity.this.isFinishing() || numArr == null) {
                            return;
                        }
                        if (numArr[0].intValue() == 0) {
                            GeneralCameraV3UpgradePlayerActivity.this.hideUpdateIng(true);
                            GeneralCameraV3UpgradePlayerActivity.this.mHandler.removeMessages(3051);
                        } else if (numArr[1].intValue() < 100) {
                            GeneralCameraV3UpgradePlayerActivity.this.showUpdateIng(numArr[1].intValue());
                            GeneralCameraV3UpgradePlayerActivity.this.mHandler.sendEmptyMessageDelayed(3051, 1500);
                        } else {
                            GeneralCameraV3UpgradePlayerActivity.this.hideUpdateIng(true);
                            GeneralCameraV3UpgradePlayerActivity.this.mHandler.removeMessages(3051);
                            GeneralCameraV3UpgradePlayerActivity.this.startPlay();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!GeneralCameraV3UpgradePlayerActivity.this.isFinishing()) {
                            GeneralCameraV3UpgradePlayerActivity.this.hideUpdateIng(false);
                            GeneralCameraV3UpgradePlayerActivity.this.mHandler.removeMessages(3051);
                        }
                    }
                });
            } else if (i == 4000) {
                this.mNeedSpeed = false;
                this.mTimeUpdateView.setVisibility(8);
            } else if (i == 21003) {
                byte[] bArr = (byte[]) message.obj;
                if (bArr != null && bArr.length >= 6) {
                    int O000000o2 = dvp.O000000o(bArr, 0);
                    gsy.O00000Oo("GenCameraV3UpgradePlayerAct", "获取的码流=".concat(String.valueOf(O000000o2)));
                    if (O000000o2 >= 90) {
                        this.mCameraDevice.O00000oO().O000000o(2);
                    } else {
                        this.mCameraDevice.O00000oO().O000000o(0);
                    }
                    setResolutionTextNew(getResolutionIndexNew(this.mCameraDevice.O00000oO().O0000o00));
                }
            } else if (i == 2100) {
                hidError();
                if ((!mg.O00000o0(this) || this.mAllowMobileNetwork) && this.mCameraDevice.O000000o().O000000o("power", true)) {
                    hidError();
                    showLoading(getString(R.string.camera_play_initial_0));
                }
                startPlay();
            } else if (i != 2101) {
                switch (i) {
                    case 210012:
                        civ.O00000o("GenCameraV3UpgradePlayerAct", "获取设备实时帧率");
                        byte[] bArr2 = (byte[]) message.obj;
                        if (bArr2 != null) {
                            this.fps = bArr2[0];
                            civ.O00000o("GenCameraV3UpgradePlayerAct", "data fps===" + this.fps + ",recordingfilePath=" + this.recordingfilePath);
                            this.mCameraPlayerEx.O000000o(this.recordingfilePath, 2, this.fps);
                            return;
                        }
                        return;
                    case 210013:
                        civ.O00000o("GenCameraV3UpgradePlayerAct", "打开speek通道的结果");
                        byte[] bArr3 = (byte[]) message.obj;
                        civ.O00000o("GenCameraV3UpgradePlayerAct", "data 0===" + ((int) bArr3[0]));
                        civ.O00000o("GenCameraV3UpgradePlayerAct", "data 1===" + ((int) bArr3[1]));
                        return;
                    default:
                        return;
                }
            } else if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O00000o0()) {
                this.mHandler.sendEmptyMessageDelayed(2101, 500);
            }
        } else if (((DeviceUpdateInfo) message.obj).mHasNewFirmware) {
            this.mNewFirmView.setVisibility(0);
        }
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            exitFullScreen(null);
        } else if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
            super.onBackPressed();
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
    public void startPlay() {
        if (TextUtils.isEmpty(this.mCameraDevice.getModel()) || TextUtils.isEmpty(this.mCameraDevice.getDid())) {
            showError(getString(R.string.camera_play_error2));
        } else if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            hideLoading();
            if (this.mPowerOffView.getVisibility() == 8) {
                this.mPowerOffView.setVisibility(0);
            }
        } else {
            if (this.mPauseView.getVisibility() == 0) {
                this.mPauseView.setVisibility(8);
            }
            if (mg.O00000o0(this) && !this.mAllowMobileNetwork) {
                pauseCamera();
            } else if (this.mCameraDevice != null && this.mCameraDevice.O000000o().O000000o("power", true)) {
                hidError();
                showLoading(null);
                this.mCameraPlayerEx.O0000o0O();
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
    public void refreshUI() {
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            hideLoading();
            if (this.mPowerOffView.getVisibility() == 8) {
                this.mPowerOffView.setVisibility(0);
                if (this.mCameraPlayerEx != null) {
                    this.mCameraPlayerEx.O0000OOo();
                }
                if (this.mPauseView.getVisibility() == 0) {
                    this.mPauseView.setVisibility(8);
                }
            }
            if (this.mCameraPlayerEx != null) {
                if (this.mCameraPlayerEx.O0000O0o()) {
                    doStopRecord();
                }
                if (this.mCameraPlayerEx.O00000o0()) {
                    doStopCall();
                }
            }
            this.mLandSleepView.setCurrentState(1);
            this.mPortSleepView.setCurrentState(1);
            return;
        }
        this.mLandSleepView.setCurrentState(0);
        this.mPortSleepView.setCurrentState(0);
        if (this.mPowerOffView.getVisibility() == 0) {
            this.mPowerOffView.setVisibility(8);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void */
    public void onDestroy() {
        this.isFirstResumed = false;
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O000000o(false);
            this.mCameraPlayerEx = null;
        }
        if (this.mVideoView != null && this.mCameraDevice != null && !TextUtils.isEmpty(this.mCameraDevice.getModel()) && !TextUtils.isEmpty(this.mCameraDevice.getDid())) {
            String O000000o2 = grv.O000000o(this.mCameraDevice.getModel() + this.mCameraDevice.getDid());
            this.mSurfaceViewScale = this.mVideoView.O00000o();
            if (this.mSurfaceViewScale >= this.mVideoView.O00000o0()) {
                gpy.O00000Oo(gkv.f17949O000000o, O000000o2, "scale", this.mSurfaceViewScale);
                this.mSurfaceViewOffsetX = this.mVideoView.O00000oO();
                gpy.O00000Oo(gkv.f17949O000000o, O000000o2, "offsetX", this.mSurfaceViewOffsetX);
                this.mSurfaceViewOffsetY = this.mVideoView.O00000oo();
                gpy.O00000Oo(gkv.f17949O000000o, O000000o2, "offsetY", this.mSurfaceViewOffsetY);
            } else {
                gpy.O00000Oo(gkv.f17949O000000o, O000000o2, "scale", 1.0f);
                gpy.O00000Oo(gkv.f17949O000000o, O000000o2, "offsetX", 0.0f);
                gpy.O00000Oo(gkv.f17949O000000o, O000000o2, "offsetY", 0.0f);
            }
        }
        if (this.mNetworkMonitor != null) {
            this.mNetworkMonitor.O00000Oo();
        }
        if (this.mCameraDevice != null) {
            cih.O000000o(this.mCameraDevice);
        }
        OfflineViewDelegate offlineViewDelegate = this.mOfflineViewDelegate;
        if (offlineViewDelegate != null) {
            offlineViewDelegate.onDestroy();
        }
        super.onDestroy();
        chr.O00000Oo();
    }

    public void onServerCmd(int i, byte[] bArr) {
        if (i == chw.f13851O000000o) {
            new CommandTreatment(this.mHandler, this.mCameraDevice).processData(bArr);
        } else if (i == 263) {
            gsy.O00000Oo("GenCameraV3UpgradePlayerAct", "MISS_CMD_SPEAKER_START_RESP:" + bArr.toString());
            try {
                int intValue = Integer.valueOf(new String(bArr)).intValue();
                if (intValue == -1) {
                    if (this.mCameraPlayerEx != null) {
                        this.mCameraPlayerEx.O00000oO();
                    }
                    this.mHandler.removeMessages(2101);
                    this.mLandCallView.setCurrentState(0);
                    this.mPortCallView.setCurrentState(0);
                    if (this.mAudioOn) {
                        this.mPortAudioView.setCurrentState(1);
                        this.mLandAudioView.setCurrentState(1);
                        if (this.mCameraPlayerEx != null) {
                            this.mCameraPlayerEx.O00000o0(false);
                        }
                    } else {
                        this.mPortAudioView.setCurrentState(0);
                        this.mLandAudioView.setCurrentState(0);
                        if (this.mCameraPlayerEx != null) {
                            this.mCameraPlayerEx.O00000o0(true);
                        }
                    }
                    gqg.O000000o((int) R.string.devcie_on_calling);
                } else if (4 == intValue) {
                    gqg.O000000o(getString(R.string.speak_info));
                    this.mLandCallView.setCurrentState(0);
                    this.mPortCallView.setCurrentState(0);
                    this.mPortAudioView.setCurrentState(0);
                    this.mLandAudioView.setCurrentState(0);
                    civ.O00000o("Huang", "onServerCmd setMute true 33333333");
                    this.mCameraPlayerEx.O00000o0(true);
                    this.mCameraPlayerEx.O00000oO();
                } else if (1 != intValue) {
                    gqg.O000000o(getString(R.string.speak_faile));
                    this.mLandCallView.setCurrentState(0);
                    this.mPortCallView.setCurrentState(0);
                    this.mPortAudioView.setCurrentState(0);
                    this.mLandAudioView.setCurrentState(0);
                    civ.O00000o("Huang", "onServerCmd setMute true 44444444");
                    this.mCameraPlayerEx.O00000o0(true);
                    this.mCameraPlayerEx.O00000oO();
                }
            } catch (Exception e) {
                gsy.O000000o(6, "GenCameraV3UpgradePlayerAct", "Exception:" + e.getLocalizedMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void doResume() {
        this.mPauseView.setVisibility(8);
        if (this.mCameraPlayerEx == null || this.mCameraPlayerEx.O0000Oo()) {
            setPlayTime();
            return;
        }
        showLastLoading();
        this.mCameraPlayerEx.O0000Oo0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    private void videoClick() {
        civ.O00000o("GenCameraV3UpgradePlayerAct", "videoClick");
        if (this.mCameraDevice != null && this.mCameraDevice.O00000Oo() != null && this.mCameraDevice != null && this.mCameraDevice.O000000o() != null && this.mCameraDevice.O000000o().O000000o("power", true)) {
            if (ciw.O000000o(getRequestedOrientation())) {
                if (this.mLLTopCtrlLandscape.getTranslationY() < 0.0f) {
                    LinearLayout linearLayout = this.mLLTopCtrlLandscape;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", (float) (-linearLayout.getHeight()), 0.0f);
                    ofFloat.setDuration(200L);
                    ofFloat.start();
                } else {
                    LinearLayout linearLayout2 = this.mLLTopCtrlLandscape;
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout2, "translationY", 0.0f, (float) (-linearLayout2.getHeight()));
                    ofFloat2.setDuration(200L);
                    ofFloat2.start();
                }
                if (this.mLandCallView.getTranslationY() > 0.0f) {
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mLandCallView, "translationY", (float) this.mLandCallView.getHeight(), 0.0f);
                    ofFloat3.setDuration(200L);
                    ofFloat3.start();
                    return;
                }
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mLandCallView, "translationY", 0.0f, (float) this.mLandCallView.getHeight());
                ofFloat4.setDuration(200L);
                ofFloat4.start();
                return;
            }
            this.mPortraitControlLayout.getLayoutParams();
            if (this.mPortraitControlLayout.getTranslationY() > 0.0f) {
                LinearLayout linearLayout3 = this.mPortraitControlLayout;
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(linearLayout3, "translationY", (float) linearLayout3.getHeight(), 0.0f);
                ofFloat5.setDuration(200L);
                ofFloat5.start();
                return;
            }
            LinearLayout linearLayout4 = this.mPortraitControlLayout;
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(linearLayout4, "translationY", 0.0f, (float) linearLayout4.getHeight());
            ofFloat6.setDuration(200L);
            ofFloat6.start();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void toggleCtrlContainerVisibility() {
        boolean O000000o2 = this.mCameraDevice.O000000o().O000000o("power", true);
        civ.O00000o("GenCameraV3UpgradePlayerAct", "isShow::".concat(String.valueOf(O000000o2)));
        if (!ciw.O000000o(getRequestedOrientation())) {
            this.mPortraitControlLayout.getLayoutParams();
            if (O000000o2) {
                if (this.mPortraitControlLayout.getTranslationY() > 0.0f) {
                    LinearLayout linearLayout = this.mPortraitControlLayout;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", (float) linearLayout.getHeight(), 0.0f);
                    ofFloat.setDuration(200L);
                    ofFloat.start();
                }
            } else if (this.mPortraitControlLayout.getTranslationY() <= 0.0f) {
                LinearLayout linearLayout2 = this.mPortraitControlLayout;
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout2, "translationY", 0.0f, (float) linearLayout2.getHeight());
                ofFloat2.setDuration(200L);
                ofFloat2.start();
            }
        } else if (O000000o2) {
            if (this.mLLTopCtrlLandscape.getTranslationY() < 0.0f) {
                this.mLLTopCtrlLandscape.bringToFront();
                LinearLayout linearLayout3 = this.mLLTopCtrlLandscape;
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout3, "translationY", (float) (-linearLayout3.getHeight()), 0.0f);
                ofFloat3.setDuration(200L);
                ofFloat3.start();
            }
            if (this.mLandCallView.getTranslationY() > 0.0f) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mLandCallView, "translationY", (float) this.mLandCallView.getHeight(), 0.0f);
                ofFloat4.setDuration(200L);
                ofFloat4.start();
            }
        } else {
            if (this.mLLTopCtrlLandscape.getTranslationY() >= 0.0f) {
                LinearLayout linearLayout4 = this.mLLTopCtrlLandscape;
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(linearLayout4, "translationY", 0.0f, (float) (-linearLayout4.getHeight()));
                ofFloat5.setDuration(200L);
                ofFloat5.start();
            }
            if (this.mLandCallView.getTranslationY() == 0.0f) {
                ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mLandCallView, "translationY", 0.0f, (float) this.mLandCallView.getHeight());
                ofFloat6.setDuration(200L);
                ofFloat6.start();
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
    public void snapShot() {
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            gqg.O000000o((int) R.string.power_off);
        } else if (!mk.O000000o(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
        } else if (this.mCameraDevice == null || this.mCameraDevice.O000000o() == null || !this.mCameraDevice.O000000o().O000000o("power", true)) {
            gqg.O000000o((int) R.string.power_off);
        } else if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000Oo()) {
            gqg.O000000o((int) R.string.snap_failed_paused);
        } else {
            this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$15XuIplS82uLFsnrtTKkDDisXOc */

                public final void onSnap(Bitmap bitmap) {
                    GeneralCameraV3UpgradePlayerActivity.this.lambda$snapShot$4$GeneralCameraV3UpgradePlayerActivity(bitmap);
                }
            });
        }
    }

    public /* synthetic */ void lambda$snapShot$4$GeneralCameraV3UpgradePlayerActivity(Bitmap bitmap) {
        goq.O000000o(new Runnable(bitmap) {
            /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$O2PzaMZuipJOnjbNqGlOuWSDteQ */
            private final /* synthetic */ Bitmap f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                GeneralCameraV3UpgradePlayerActivity.this.lambda$null$3$GeneralCameraV3UpgradePlayerActivity(this.f$1);
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: onSnapShot */
    public void lambda$null$3$GeneralCameraV3UpgradePlayerActivity(Bitmap bitmap) {
        String O000000o2 = C0118cif.O000000o(bitmap, this.mCameraDevice.getDid());
        if (O000000o2 != null) {
            runOnUiThread(new Runnable(O000000o2, Bitmap.createScaledBitmap(bitmap, 300, (bitmap.getHeight() * 300) / bitmap.getWidth(), false)) {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$A7HgHXapLnnDiwYTmBU4NUHtX4 */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ Bitmap f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    GeneralCameraV3UpgradePlayerActivity.this.lambda$onSnapShot$6$GeneralCameraV3UpgradePlayerActivity(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onSnapShot$6$GeneralCameraV3UpgradePlayerActivity(String str, Bitmap bitmap) {
        clj.O000000o O00000Oo;
        if (new File(str).exists()) {
            ImageView imageView = (ImageView) findViewById(R.id.ivShotPic);
            if (this.mLLFuncPopup.getVisibility() == 0) {
                this.mLLFuncPopup.setVisibility(8);
            }
            this.mLLFuncPopup.setLayoutParams((FrameLayout.LayoutParams) this.mLLFuncPopup.getLayoutParams());
            this.mLLFuncPopup.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.anim_snap_shot_in));
            this.mLLFuncPopup.setVisibility(0);
            dismissSnapshotPopupRunnable(3000);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            if (C0118cif.O000000o(this, str) && (O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str)) != null) {
                imageView.setOnClickListener(new View.OnClickListener(O00000Oo) {
                    /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$4zwFtWk1ANwMw5K5dPLTc6OzdBU */
                    private final /* synthetic */ clj.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        GeneralCameraV3UpgradePlayerActivity.this.lambda$null$5$GeneralCameraV3UpgradePlayerActivity(this.f$1, view);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$null$5$GeneralCameraV3UpgradePlayerActivity(clj.O000000o o000000o, View view) {
        if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
            dismissSnapshotPopupRunnable(0);
            Intent intent = new Intent(this.mContext, LocalPicActivity.class);
            intent.putExtra("file_path", o000000o.O00000o);
            startActivity(intent);
        }
    }

    private void dismissSnapshotPopupRunnable(long j) {
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$F4c435UDksxfVid1RQrs7WlUMI */

            public final void run() {
                GeneralCameraV3UpgradePlayerActivity.this.lambda$dismissSnapshotPopupRunnable$7$GeneralCameraV3UpgradePlayerActivity();
            }
        }, j);
    }

    public /* synthetic */ void lambda$dismissSnapshotPopupRunnable$7$GeneralCameraV3UpgradePlayerActivity() {
        LinearLayout linearLayout = this.mLLFuncPopup;
        if (linearLayout != null && linearLayout.getVisibility() != 8) {
            this.mLLFuncPopup.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.anim_snap_shot_out));
            this.mLLFuncPopup.setVisibility(8);
        }
    }

    public void onVideoRecorded(String str) {
        File file = new File(str);
        if (file.exists()) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            clj.O000000o O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str);
            if (O00000Oo != null && this.mVideoView != null) {
                this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback(O00000Oo) {
                    /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$ZvqbuKRl0QcXXDb0YgygmiGhsk */
                    private final /* synthetic */ clj.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onSnap(Bitmap bitmap) {
                        GeneralCameraV3UpgradePlayerActivity.this.lambda$onVideoRecorded$10$GeneralCameraV3UpgradePlayerActivity(this.f$1, bitmap);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onVideoRecorded$10$GeneralCameraV3UpgradePlayerActivity(clj.O000000o o000000o, Bitmap bitmap) {
        if (bitmap != null) {
            runOnUiThread(new Runnable(Bitmap.createScaledBitmap(bitmap, 300, (bitmap.getHeight() * 300) / bitmap.getWidth(), false), o000000o) {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$6PSCnW8AtY5Zk0ifPHnq5hzdjo */
                private final /* synthetic */ Bitmap f$1;
                private final /* synthetic */ clj.O000000o f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    GeneralCameraV3UpgradePlayerActivity.this.lambda$null$9$GeneralCameraV3UpgradePlayerActivity(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$9$GeneralCameraV3UpgradePlayerActivity(Bitmap bitmap, clj.O000000o o000000o) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) findViewById(R.id.ivShotPic);
            imageView.setImageBitmap(bitmap);
            if (this.mLLFuncPopup.getVisibility() == 0) {
                this.mLLFuncPopup.setVisibility(8);
            }
            this.mLLFuncPopup.setLayoutParams((FrameLayout.LayoutParams) this.mLLFuncPopup.getLayoutParams());
            this.mLLFuncPopup.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.anim_snap_shot_in));
            this.mLLFuncPopup.setVisibility(0);
            dismissSnapshotPopupRunnable(3000);
            imageView.setOnClickListener(new View.OnClickListener(o000000o) {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraV3UpgradePlayerActivity$U7AJDg6s21NMvgNSsxWsOOc9ML0 */
                private final /* synthetic */ clj.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    GeneralCameraV3UpgradePlayerActivity.this.lambda$null$8$GeneralCameraV3UpgradePlayerActivity(this.f$1, view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$8$GeneralCameraV3UpgradePlayerActivity(clj.O000000o o000000o, View view) {
        if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
            dismissSnapshotPopupRunnable(0);
            Intent intent = new Intent(this.mContext, LocalPicActivity.class);
            intent.putExtra("file_path", o000000o.O00000o);
            startActivity(intent);
        }
    }

    private void toggleResolution() {
        chr.O000000o(chr.O000oO0o);
        if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O00000Oo()) {
            gqg.O000000o((int) R.string.history_video_resolution_hd_only);
        } else if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000O0o()) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O000000o((int) R.string.quality_choice);
            final String[] strArr = {getString(R.string.quality_360P), getString(R.string.quality_auto), getString(R.string.quality_1080P)};
            this.selectedIndex = this.mCameraDevice.O00000oO().O0000o00;
            if (this.selectedIndex == 3) {
                this.selectedIndex = 2;
            }
            builder.O000000o(strArr, this.selectedIndex, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass27 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    GeneralCameraV3UpgradePlayerActivity.this.selectedIndex = i;
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass26 */

                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass25 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (GeneralCameraV3UpgradePlayerActivity.this.selectedIndex >= 0) {
                        int i2 = GeneralCameraV3UpgradePlayerActivity.this.selectedIndex;
                        String[] strArr = strArr;
                        if (i2 < strArr.length && !TextUtils.isEmpty(strArr[GeneralCameraV3UpgradePlayerActivity.this.selectedIndex])) {
                            GeneralCameraV3UpgradePlayerActivity generalCameraV3UpgradePlayerActivity = GeneralCameraV3UpgradePlayerActivity.this;
                            generalCameraV3UpgradePlayerActivity.setResolutionTextNew(generalCameraV3UpgradePlayerActivity.selectedIndex);
                            civ.O00000o("GenCameraV3UpgradePlayerAct", "设置了码流=" + GeneralCameraV3UpgradePlayerActivity.this.selectedIndex);
                            GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O000000o(GeneralCameraV3UpgradePlayerActivity.this.selectedIndex);
                            if (GeneralCameraV3UpgradePlayerActivity.this.mCameraPlayerEx != null) {
                                boolean z = false;
                                int i3 = 110;
                                if (GeneralCameraV3UpgradePlayerActivity.this.selectedIndex == 1) {
                                    z = true;
                                } else if (GeneralCameraV3UpgradePlayerActivity.this.selectedIndex != 2) {
                                    i3 = 20;
                                }
                                cll O000000o2 = GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O000000o();
                                AnonymousClass1 r1 = new Callback<Void>() {
                                    /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass25.AnonymousClass1 */

                                    public void onFailure(int i, String str) {
                                    }

                                    public void onSuccess(Void voidR) {
                                    }
                                };
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.put(z ? "on" : "off");
                                jSONArray.put(String.valueOf(i3));
                                civ.O000000o("CameraProperties", "setAutoBitrate params=" + jSONArray.toString());
                                O000000o2.O00000o0.callMethod("SetAutoBitrate", jSONArray, new Callback<Object>(r1) {
                                    /* class _m_j.cll.AnonymousClass5 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ Callback f14078O000000o;

                                    {
                                        this.f14078O000000o = r2;
                                    }

                                    public final void onSuccess(Object obj) {
                                        civ.O000000o("CameraProperties", "setAutoBitrate result=".concat(String.valueOf(obj)));
                                        Callback callback = this.f14078O000000o;
                                        if (callback != null) {
                                            callback.onSuccess(null);
                                        }
                                    }

                                    public final void onFailure(int i, String str) {
                                        Callback callback = this.f14078O000000o;
                                        if (callback != null) {
                                            callback.onFailure(i, str);
                                        }
                                    }
                                }, (Parser) null);
                            }
                        }
                    }
                }
            }).O00000oo();
        } else {
            gqg.O000000o((int) R.string.record_resolution_block);
        }
    }

    /* access modifiers changed from: protected */
    public void upDateTimeTitle(String str) {
        this.mLandRecordTimer.setText(str);
        this.record_time.setText(str);
    }

    /* access modifiers changed from: protected */
    public void detectSDCard() {
        CameraActivityUtils.detectSDCard(this, this.mCameraDevice, this.mSdcardDetectResult);
    }

    public void showSDCardHintDialog() {
        this.mSDCardHintDialog = new SDCardHintDialog(this, R.style.popupDialog);
        this.mSDCardHintDialog.show();
        this.mSDCardHintDialog.setCancelable(true);
        this.mCameraDevice.O00000oO().O0000Oo0 = false;
    }

    public void checkMinLevel() {
        if (this.mCameraDevice.O000000o().O000000o("mini_level") > 1) {
            showUpdateDlg(this, false);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.mIsInit) {
            this.mIsInit = true;
            if (this.mCameraDevice.O00000oO().O00000o) {
                initGuideCenter();
            }
        }
    }

    public void initGuideCenter() {
        XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mGuideCenter == null) {
            this.mGuideCenter = CameraActivityUtils.initGuideCenter(this.mContext, this.mCameraDevice, this.mVideoViewFrame);
            GuideView guideView = this.mGuideCenter;
            if (guideView != null) {
                guideView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass28 */

                    public void onClick(View view) {
                        GeneralCameraV3UpgradePlayerActivity.this.mGuideCenter.hide();
                        GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O00000o();
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
    private void showLicense() {
        if (this.mDeviceStat != null && !TextUtils.isEmpty(this.mDeviceStat.did)) {
            if (this.mCameraDevice.isShared()) {
                civ.O00000o("GenCameraV3UpgradePlayerAct", "分享用户不弹出隐私协议");
                return;
            }
            try {
                if (this.mCameraDevice.O00000oO().O00000oo) {
                    this.mIsInit = true;
                    this.mNeedLicense = true;
                    LocalLicenseUtil.LocalLicense v3UpgradeLicense = LocalLicenseUtil.getV3UpgradeLicense(getResources());
                    int i = v3UpgradeLicense.mLicense;
                    int i2 = v3UpgradeLicense.mPrivacy;
                    if (i == 0 && i2 == 0 && v3UpgradeLicense.mPrivacySpanned == null && v3UpgradeLicense.mLicenseSpanned == null) {
                        civ.O00000o("CameraPlay", "load raw fail");
                        this.mCameraDevice.O00000oO().O00000oO(false);
                        if (this.mCameraDevice.O00000oO().O00000o) {
                            initGuideCenter();
                        }
                    } else if (XmPluginHostApi.instance().getApiLevel() >= 67) {
                        Intent intent = new Intent();
                        if ("cn".equalsIgnoreCase(ftl.O000000o())) {
                            intent.putExtra("enable_privacy_setting", true);
                            intent.putExtra("usrExpPlanContentUri", v3UpgradeLicense.mPlan);
                        } else {
                            intent.putExtra("enable_privacy_setting", false);
                        }
                        if (this.mDeviceStat == null) {
                            return;
                        }
                        if (!TextUtils.isEmpty(this.mDeviceStat.did)) {
                            Spanned spanned = v3UpgradeLicense.mLicenseSpanned;
                            Spanned spanned2 = v3UpgradeLicense.mPrivacySpanned;
                            if (i == 0 || i2 == 0) {
                                if (spanned2 == null || spanned == null) {
                                    this.mNeedLicense = false;
                                    this.mHandler.removeMessages(2100);
                                    this.mHandler.sendEmptyMessage(2100);
                                    this.mHandler.sendEmptyMessage(3051);
                                    this.mCameraDevice.O00000oO().O00000oO(false);
                                    if (this.mCameraDevice.O00000oO().O00000o) {
                                        initGuideCenter();
                                    }
                                } else if (!this.mCameraDevice.isShared()) {
                                    Intent intent2 = intent;
                                    hyv.O000000o().showUserLicenseDialog(activity(), this.mDid, this.mDeviceStat.name, getString(R.string.licences_content), spanned, getString(R.string.privacy_content), spanned2, new View.OnClickListener() {
                                        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass30 */

                                        public void onClick(View view) {
                                            GeneralCameraV3UpgradePlayerActivity generalCameraV3UpgradePlayerActivity = GeneralCameraV3UpgradePlayerActivity.this;
                                            generalCameraV3UpgradePlayerActivity.mNeedLicense = false;
                                            generalCameraV3UpgradePlayerActivity.mHandler.removeMessages(2100);
                                            GeneralCameraV3UpgradePlayerActivity.this.mHandler.sendEmptyMessage(2100);
                                            GeneralCameraV3UpgradePlayerActivity.this.mHandler.sendEmptyMessage(3051);
                                            GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O00000oO(false);
                                            if (GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O00000o) {
                                                GeneralCameraV3UpgradePlayerActivity.this.initGuideCenter();
                                            }
                                        }
                                    }, intent2);
                                }
                            } else if (!this.mCameraDevice.isShared()) {
                                hyu O000000o2 = hyv.O000000o();
                                Activity activity = activity();
                                O000000o2.showUserLicenseDialog(activity, this.mDid, this.mDeviceStat.name, getString(R.string.licences_content), i, getString(R.string.privacy_content), i2, new View.OnClickListener() {
                                    /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass29 */

                                    public void onClick(View view) {
                                        GeneralCameraV3UpgradePlayerActivity generalCameraV3UpgradePlayerActivity = GeneralCameraV3UpgradePlayerActivity.this;
                                        generalCameraV3UpgradePlayerActivity.mNeedLicense = false;
                                        generalCameraV3UpgradePlayerActivity.mHandler.removeMessages(2100);
                                        GeneralCameraV3UpgradePlayerActivity.this.mHandler.sendEmptyMessage(2100);
                                        GeneralCameraV3UpgradePlayerActivity.this.mHandler.sendEmptyMessage(3051);
                                        GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O00000oO(false);
                                        if (GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O00000oO().O00000o) {
                                            GeneralCameraV3UpgradePlayerActivity.this.initGuideCenter();
                                        }
                                    }
                                }, intent);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                gsy.O000000o(6, "GenCameraV3UpgradePlayerAct", "showLicense exception:" + e.getLocalizedMessage());
            }
        }
    }

    private static void showUpdateDlg(final Activity activity, final boolean z) {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity);
        builder.O000000o((int) R.string.api_tip);
        builder.O00000Oo((int) R.string.api_tip_title);
        builder.O000000o(false);
        builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass31 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (!activity.isFinishing()) {
                    dialogInterface.dismiss();
                    activity.finish();
                }
            }
        });
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass32 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (!activity.isFinishing()) {
                    if (z) {
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://app.mi.com/details?id=com.xiaomi.smarthome")));
                    }
                    dialogInterface.dismiss();
                    activity.finish();
                }
            }
        });
        builder.O00000oo();
    }

    private void eventLiveVideoDuration() {
        if (MIStreamStatistic.getInstance().latestLiveVideo > 0 && this.mCameraDevice != null) {
            try {
                MIStreamStatistic.getInstance().sendCameraWatchDuration(this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), System.currentTimeMillis() - MIStreamStatistic.getInstance().latestLiveVideo);
            } catch (Exception e) {
                gsy.O00000Oo("GenCameraV3UpgradePlayerAct", "timestamp:" + e.getLocalizedMessage());
            }
        }
    }

    public void onConnected() {
        super.onConnected();
        civ.O00000o("GenCameraV3UpgradePlayerAct", "摄像机连接成功");
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass33 */

            public void run() {
                GeneralCameraV3UpgradePlayerActivity.this.connectedSuccessfully();
            }
        }, 500);
        judgeDownloadTimeLapseDemo();
    }

    private String getDownloadFilePath() {
        String O000000o2 = me.O000000o();
        if (TextUtils.isEmpty(O000000o2)) {
            return O000000o2;
        }
        File file = new File(O000000o2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return O000000o2 + File.separator + "timelaps_demo.gif";
    }

    private void judgeDownloadTimeLapseDemo() {
        if (!new File(getDownloadFilePath()).exists()) {
            civ.O000000o("AlbumActivity", "gif 图片本地不存在 下载 ");
            DownLoadTimeLapseDemo.getInstance(this, this.mCameraDevice.getDid(), this.mHandler).downLoadFile();
            return;
        }
        civ.O000000o("AlbumActivity", "gif 图片本地存在 不下载 ");
    }

    public void connectedSuccessfully() {
        if (this.mCameraPlayerEx != null) {
            civ.O00000o("GenCameraV3UpgradePlayerAct", "mNeedLicense22 ==" + this.mNeedLicense + ",mCameraDevice did ==" + this.mCameraDevice.getDid() + ",mCameraDevice uid=" + this.mCameraDevice.O0000oOo());
            civ.O00000o("GenCameraV3UpgradePlayerAct", "发送10002");
            this.mCameraPlayerEx.O0000oO0();
            civ.O00000o("GenCameraV3UpgradePlayerAct", "打开设备端的声音");
            this.mCameraPlayerEx.O00000Oo(true);
            civ.O00000o("Huang", "connectedSuccessfully setMute true llllllllllll");
            this.mCameraPlayerEx.O00000o0(true);
            civ.O00000o("GenCameraV3UpgradePlayerAct", "发送校时命令");
            this.mCameraPlayerEx.O0000oO();
            civ.O00000o("GenCameraV3UpgradePlayerAct", "发送了拉RDT数据 isHistory=" + isHistory());
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity.AnonymousClass34 */

                public void run() {
                    if (!GeneralCameraV3UpgradePlayerActivity.this.isHistory()) {
                        GeneralCameraV3UpgradePlayerActivity.this.mCameraDevice.O0000Oo0().O00000Oo((Callback<Void>) null);
                    }
                }
            }, 2000);
        }
    }

    public void setPlayTime() {
        if (!this.mIsUserPause) {
            showLoading("");
        }
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O0000o0O();
        }
    }
}
