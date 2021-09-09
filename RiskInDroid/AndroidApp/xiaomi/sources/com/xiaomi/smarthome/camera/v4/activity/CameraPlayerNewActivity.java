package com.xiaomi.smarthome.camera.v4.activity;

import _m_j.C0118cif;
import _m_j.chq;
import _m_j.chr;
import _m_j.cht;
import _m_j.chx;
import _m_j.chz;
import _m_j.cia;
import _m_j.cid;
import _m_j.cie;
import _m_j.cih;
import _m_j.cin;
import _m_j.civ;
import _m_j.ciw;
import _m_j.ciy;
import _m_j.cjg;
import _m_j.cki;
import _m_j.ckj;
import _m_j.ckq;
import _m_j.cld;
import _m_j.cle;
import _m_j.clf;
import _m_j.clh;
import _m_j.clj;
import _m_j.clk;
import _m_j.cnx;
import _m_j.cod;
import _m_j.com;
import _m_j.coo;
import _m_j.faw;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsp;
import _m_j.ft;
import _m_j.ftl;
import _m_j.ftn;
import _m_j.fwg;
import _m_j.gkv;
import _m_j.goq;
import _m_j.gpc;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.grv;
import _m_j.gsy;
import _m_j.gwc;
import _m_j.gwg;
import _m_j.hjm;
import _m_j.hjp;
import _m_j.hjr;
import _m_j.hju;
import _m_j.hlr;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxm;
import _m_j.hyv;
import _m_j.hyy;
import _m_j.me;
import _m_j.mg;
import _m_j.mi;
import _m_j.mk;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mijia.model.alarmcloud.AlarmCloudCallback;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.mijia.model.alarmcloud.FaceInfoMeta;
import com.mijia.model.sdcard.TimeItem;
import com.mijia.widget.PanoramicMaskView;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.LocalLicenseUtil;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmAISwitchActivity;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.activity.alarm.IDMPairingInfo;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardCloudVideoActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity;
import com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity;
import com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew;
import com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import com.xiaomi.smarthome.camera.activity.utils.SpecConstantUtils;
import com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity;
import com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity;
import com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmGuideActivity;
import com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingActivity;
import com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity;
import com.xiaomi.smarthome.camera.v4.activity.setting.NoMemoryCardActivity;
import com.xiaomi.smarthome.camera.v4.utils.ActivityHelperUtils;
import com.xiaomi.smarthome.camera.v4.utils.CameraToastUtil;
import com.xiaomi.smarthome.camera.v4.utils.UpdateFirmwareHelper;
import com.xiaomi.smarthome.camera.v4.view.AngleView;
import com.xiaomi.smarthome.camera.v4.view.DirectionCtrlView;
import com.xiaomi.smarthome.camera.v4.view.DirectionCtrlViewNew;
import com.xiaomi.smarthome.camera.v4.view.DirectionCtrlViewSingle;
import com.xiaomi.smarthome.camera.v4.view.MIDrawerLayout2;
import com.xiaomi.smarthome.camera.v4.view.MoreDialog;
import com.xiaomi.smarthome.camera.v4.view.PanoramicDialog;
import com.xiaomi.smarthome.camera.v4.view.PreSetPositionView;
import com.xiaomi.smarthome.camera.view.GuidePage1;
import com.xiaomi.smarthome.camera.view.MultiStateImageView;
import com.xiaomi.smarthome.camera.view.SDCardHintDialog;
import com.xiaomi.smarthome.camera.view.widget.CenterDrawableCheckBox;
import com.xiaomi.smarthome.camera.view.widget.DirectPushItemView;
import com.xiaomi.smarthome.camera.view.widget.MultiStateView;
import com.xiaomi.smarthome.camera.view.widget.WaveView;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.FirmwareUpdateResult;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.RoundedImageView;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.operation.view.OperationImageView;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraPlayerNewActivity extends GeneralCameraPlayerBaseActivity implements cia {
    public static String DrawerCloseState = "MIDrawerLayout2_State";
    public static String IDM_FIRST_OPEN_BUTTON = "IDM_FIRST_OPEN_BUTTON";
    public static String JUMP_ACTION = "jump_action";
    public static String KOREA_FORCE_PIN_CODE = "korea_force_pin_code";
    public static volatile boolean drawerClosed = true;
    public static SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm", Locale.CHINA);
    private final int ANGLE_VIEW_GONE_DELAYED_TIME = 3000;
    private final int BOTTOM_CTRL_GONE_DELAYED_TIME = 5000;
    private final int CALL_VOLUME_DELAY = 500;
    private final int FIRST_RESUME = 2100;
    private final int MSG_CALL_VOLUME = 2101;
    private final int MSG_DISMISS_HINT = 1002;
    private final int MSG_UPDATE_FIRM = 1;
    public DirectionCtrlView.OnDirectionCtrlListener OnDirectionCtrlListener = new DirectionCtrlView.OnDirectionCtrlListener() {
        /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass5 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
         arg types: [java.lang.String, int]
         candidates:
          _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
          _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
          _m_j.cll.O000000o(java.lang.String, boolean):boolean */
        public void onClickPTZDirection(int i) {
            if (CameraPlayerNewActivity.this.mCameraDevice == null) {
                return;
            }
            if (CameraPlayerNewActivity.this.mCameraDevice.isReadOnlyShared()) {
                cki.O00000o0("CameraPlayerNewActivity", "onClickPTZDirection ReadOnlyShared");
            } else if (!CameraPlayerNewActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                CameraToastUtil.showPowerOffToast(CameraPlayerNewActivity.this.mCameraDevice.getModel(), CameraPlayerNewActivity.this, R.string.power_off);
            } else {
                chr.O000000o(i);
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4 && CameraPlayerNewActivity.this.mCameraPlayerEx != null) {
                                CameraPlayerNewActivity.this.mCameraPlayerEx.O000000o(4, (IXmConnectionClient.XmActionCallback) null);
                            }
                        } else if (CameraPlayerNewActivity.this.mCameraPlayerEx != null) {
                            CameraPlayerNewActivity.this.mCameraPlayerEx.O000000o(3, (IXmConnectionClient.XmActionCallback) null);
                        }
                    } else if (CameraPlayerNewActivity.this.mCameraPlayerEx != null) {
                        CameraPlayerNewActivity.this.mCameraPlayerEx.O000000o(2, (IXmConnectionClient.XmActionCallback) null);
                    }
                } else if (CameraPlayerNewActivity.this.mCameraPlayerEx != null) {
                    CameraPlayerNewActivity.this.mCameraPlayerEx.O000000o(1, (IXmConnectionClient.XmActionCallback) null);
                }
            }
        }

        public void onActionDown() {
            if (CameraPlayerNewActivity.this.mCameraPlayerEx != null && CameraPlayerNewActivity.this.mCameraPlayerEx.O0000Ooo()) {
                CameraPlayerNewActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$5$5s2kcU8GEm_xFx9OFJWsGNVdWE */

                    public final void run() {
                        CameraPlayerNewActivity.AnonymousClass5.this.lambda$onActionDown$0$CameraPlayerNewActivity$5();
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onActionDown$0$CameraPlayerNewActivity$5() {
            if (CameraPlayerNewActivity.this.mCameraDevice.isReadOnlyShared()) {
                gqg.O000000o((int) R.string.auth_fail_read_only);
                return;
            }
            CameraPlayerNewActivity.this.video_scale_tv.setVisibility(8);
            if (CameraPlayerNewActivity.this.getRequestedOrientation() == 1) {
                CameraPlayerNewActivity.this.mHandler.removeCallbacks(CameraPlayerNewActivity.this.angleViewVisibilityGoneRunnable);
                CameraPlayerNewActivity.this.mAVCamera.setVisibility(0);
                return;
            }
            CameraPlayerNewActivity.this.mHandler.removeCallbacks(CameraPlayerNewActivity.this.angleViewLandscapeVisibilityGoneRunnable);
            CameraPlayerNewActivity.this.mAVCameraLandscape.setVisibility(0);
        }

        public void onActionUp(boolean z) {
            chr.O000000o(chr.O000oOOo);
            if (CameraPlayerNewActivity.this.mCameraDevice.isReadOnlyShared()) {
                cki.O00000o0("CameraPlayerNewActivity", "onActionUp ReadOnlyShared");
                return;
            }
            if (z && CameraPlayerNewActivity.this.mCameraPlayerEx != null) {
                CameraPlayerNewActivity.this.mCameraPlayerEx.O000000o(-1001, (IXmConnectionClient.XmActionCallback) null);
            }
            chr.O0000ooO();
            if (CameraPlayerNewActivity.this.mCameraPlayerEx != null && CameraPlayerNewActivity.this.mCameraPlayerEx.O0000Ooo()) {
                if (CameraPlayerNewActivity.this.getRequestedOrientation() == 1) {
                    CameraPlayerNewActivity.this.runOnUiThread(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$5$oE5ziVh4i1iFdVWtTvlvuFvkwa0 */

                        public final void run() {
                            CameraPlayerNewActivity.AnonymousClass5.this.lambda$onActionUp$1$CameraPlayerNewActivity$5();
                        }
                    });
                } else {
                    CameraPlayerNewActivity.this.runOnUiThread(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$5$CFsXQsp3w7JjTkblbmUqy_DUeNI */

                        public final void run() {
                            CameraPlayerNewActivity.AnonymousClass5.this.lambda$onActionUp$2$CameraPlayerNewActivity$5();
                        }
                    });
                }
            }
        }

        public /* synthetic */ void lambda$onActionUp$1$CameraPlayerNewActivity$5() {
            CameraPlayerNewActivity.this.mHandler.postDelayed(CameraPlayerNewActivity.this.angleViewVisibilityGoneRunnable, 3000);
        }

        public /* synthetic */ void lambda$onActionUp$2$CameraPlayerNewActivity$5() {
            CameraPlayerNewActivity.this.mHandler.postDelayed(CameraPlayerNewActivity.this.angleViewLandscapeVisibilityGoneRunnable, 3000);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
         arg types: [java.lang.String, int]
         candidates:
          _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
          _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
          _m_j.cll.O000000o(java.lang.String, boolean):boolean */
        public void onCenterClick() {
            if (CameraPlayerNewActivity.this.mCameraPlayerEx != null && CameraPlayerNewActivity.this.mCameraDevice != null) {
                CameraPlayerNewActivity.this.getPreSetPositionWrapper();
                if (!CameraPlayerNewActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    if (DeviceConstant.isSupportAiNative(CameraPlayerNewActivity.this.mCameraDevice.getModel())) {
                        gqg.O00000Oo((int) R.string.camera_closed_wulizhebi_tip);
                    } else {
                        gqg.O00000Oo((int) R.string.power_off);
                    }
                } else if (CameraPlayerNewActivity.this.mCameraDevice.isReadOnlyShared() && CameraPlayerNewActivity.this.isInternationalServer) {
                    gqg.O000000o((int) R.string.auth_fail_read_only);
                } else if (!CameraPlayerNewActivity.this.mCameraPlayerEx.O0000Ooo()) {
                    gqg.O000000o((int) R.string.panorama_no_play);
                } else {
                    CameraPlayerNewActivity.this.reSetPanoramic();
                    CameraPlayerNewActivity.this.iv_panoramic.setVisibility(4);
                    CameraPlayerNewActivity.this.iv_panoramic_mask.setVisibility(4);
                    CameraPlayerNewActivity.this.iv_panoramic_edit.setVisibility(4);
                    CameraPlayerNewActivity.this.ll_panoramic_tip.setVisibility(8);
                    CameraPlayerNewActivity.this.ll_panoramic_doing.setVisibility(0);
                    CameraPlayerNewActivity.this.iv_loading_panoramic.startAnimation(CameraPlayerNewActivity.this.rotate);
                    CameraPlayerNewActivity.this.mCameraDevice.O0000Ooo().O000000o(new chz.O000000o() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$5$gcKz65KPlqYETRuV337GKpmig_I */

                        public final void onPositionReceived() {
                            CameraPlayerNewActivity.AnonymousClass5.this.lambda$onCenterClick$4$CameraPlayerNewActivity$5();
                        }
                    });
                    CameraPlayerNewActivity.this.dcvDirectionCtrl_container.setVisibility(8);
                    if ("chuangmi.camera.ipc021".equals(CameraPlayerNewActivity.this.mCameraDevice.getModel()) && CameraPlayerNewActivity.this.isPresetPositionVersion) {
                        CameraPlayerNewActivity.this.ll_yuzhiwei.setVisibility(0);
                    }
                    if (CameraPlayerNewActivity.this.isPresetPositionVersion) {
                        CameraPlayerNewActivity.this.iv_preset_edit.setVisibility(0);
                    }
                    CameraPlayerNewActivity.this.fl_panoramic.setVisibility(0);
                }
            }
        }

        public /* synthetic */ void lambda$onCenterClick$4$CameraPlayerNewActivity$5() {
            CameraPlayerNewActivity.this.mHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$5$GUjrIX6eyuj86QUphZdYKb0Rqg */

                public final void run() {
                    CameraPlayerNewActivity.AnonymousClass5.this.lambda$null$3$CameraPlayerNewActivity$5();
                }
            });
        }

        public /* synthetic */ void lambda$null$3$CameraPlayerNewActivity$5() {
            CameraPlayerNewActivity.this.mCameraDevice.O0000OoO().O000000o(0, new Callback<String[]>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass5.AnonymousClass1 */

                public void onSuccess(String[] strArr) {
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        String str = strArr[1];
                        gsy.O00000Oo(cht.f13831O000000o, "onCenterClick cache onSuccess stoId=".concat(String.valueOf(str)));
                        CameraPlayerNewActivity.this.showPanoramic2(str, true);
                    }
                }

                public void onFailure(int i, String str) {
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        gsy.O000000o(6, cht.f13831O000000o, "onCenterClick cache onFailure=".concat(String.valueOf(str)));
                        CameraPlayerNewActivity.this.reSetPanoramic();
                        if (!CameraPlayerNewActivity.this.isPresetPositionVersion) {
                            CameraPlayerNewActivity.this.iv_preset_edit.setVisibility(8);
                        }
                    }
                }
            });
        }
    };
    private final String OperationADShortKey = "OperationADShortKey";
    final int REQUEST_CAMERA_TIPS_ACTIVITY = 1221;
    final int REQUEST_MORE_ACTIVITY = 1220;
    private final int UPDATE_CHECK = 3051;
    private final int UPDATE_CHECK_DIALOG = 3052;
    private final int UPDATE_PLAY_TIME_DURATION = 2000;
    TextView alarm_menu_sub_text;
    RelativeLayout alarm_new;
    public Runnable angleViewLandscapeVisibilityGoneRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$C6eFYH5KtyWZ38NoUNwPSMULcPA */

        public final void run() {
            CameraPlayerNewActivity.this.lambda$new$2$CameraPlayerNewActivity();
        }
    };
    public Runnable angleViewVisibilityGoneRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$SS4DfqF26hgjEOSfIduj6wzZso */

        public final void run() {
            CameraPlayerNewActivity.this.lambda$new$1$CameraPlayerNewActivity();
        }
    };
    boolean babycry = false;
    private Runnable bottomCtrlVisibilityGoneRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$IpqcCzmDixFXRfS8ZLOT6y60pRs */

        public final void run() {
            CameraPlayerNewActivity.this.bottomCtrlAnimDown();
        }
    };
    public volatile chz.O00000o curPosition;
    public volatile PreSetPositionView curPositionView;
    private hjr currentOperation = null;
    public int currentVideoHeight = 0;
    public FrameLayout dcvDirectionCtrlLandscapeContainer;
    public FrameLayout dcvDirectionCtrl_container;
    public TextView directPushTV;
    private ImageView direct_push_close_ic;
    public LinearLayout direct_push_ll;
    public ImageView direction_select_iv;
    boolean face = false;
    boolean faceManager = false;
    public FrameLayout flCloudVideoTips;
    private FrameLayout flTitleBar;
    private FrameLayout flTopCtrlLandscape;
    private RelativeLayout fl_direction_ctrl;
    public FrameLayout fl_panoramic;
    public boolean gestureEnable = true;
    private volatile long getPreSetPositionTime = 0;
    public float h_w_ratio = 0.0f;
    private int height_16_9 = 0;
    public Runnable hideScaleTvR = new Runnable() {
        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$yQfyK3IXCOj9MAuRZsGwWxjH9Zg */

        public final void run() {
            CameraPlayerNewActivity.this.lambda$new$3$CameraPlayerNewActivity();
        }
    };
    public volatile boolean isFirstFrameShowed = false;
    private boolean isFirstResumed = false;
    public boolean isInternationalServer;
    private boolean isLanguageCN;
    public volatile boolean isMinScale = true;
    public boolean isPresetPositionVersion = false;
    private boolean isSnapshotting = false;
    private boolean isStartPlay = false;
    private ImageView ivCameraShot;
    private ImageView ivFullScreen;
    private ImageView ivShotPic;
    private ImageView iv_back_landscape;
    public ImageView iv_loading_panoramic;
    public RoundedImageView iv_panoramic;
    public ImageView iv_panoramic_close;
    public ImageView iv_panoramic_edit;
    public PanoramicMaskView iv_panoramic_mask;
    public ImageView iv_preset_edit;
    private String language = "";
    public LinearLayout ll_panoramic_doing;
    public LinearLayout ll_panoramic_tip;
    public LinearLayout ll_yuzhiwei;
    public AngleView mAVCamera;
    public AngleView mAVCameraLandscape;
    int mActionRetry = 0;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            if (CameraPlayerNewActivity.this.mCameraDevice.O0000OOo() != null) {
                CameraPlayerNewActivity.this.mCameraDevice.O0000OOo();
                if ("com.mijia.camera.SdcardManager".equals(intent.getAction()) && CameraPlayerNewActivity.this.isFinishing()) {
                    return;
                }
            }
            if (CameraPlayerNewActivity.this.mCameraDevice.O0000Oo0() != null) {
                CameraPlayerNewActivity.this.mCameraDevice.O0000Oo0();
                if (!"com.mijia.camera.SdcardManagerEx".equals(intent.getAction()) || CameraPlayerNewActivity.this.isFinishing()) {
                }
            }
        }
    };
    public CenterDrawableCheckBox mCDCCameraRecord;
    public CheckBox mCDCCameraRecordFull;
    private CenterDrawableCheckBox mCDCToggleAudio;
    private WaveView mCallWave;
    Runnable mCameraPlayBackRunnable;
    Runnable mCameraPresetpositionRunnable;
    public MultiStateView mCdcToggleSleep;
    public int mCurrentTime = 0;
    private DirectionCtrlView mDcvDirectionCtrl;
    private DirectionCtrlView mDcvDirectionCtrlLandscape;
    private boolean mIsInit = false;
    private boolean mIsReal = true;
    boolean mIsSetPlayTime = false;
    boolean mKeepConnection = false;
    private CardView mLLFuncPopup;
    public LinearLayout mLLVideoViewBottomCtrl;
    private View mLandLayout;
    private long mLastPlayTime = 0;
    long mLastSetPlayTime = 0;
    private int mLastSetStart = 0;
    public int mLastTime = 0;
    private ft mLocalBroadcastManager;
    private MultiStateImageView mMSTVVoice;
    private boolean mNeedCheckAlive = false;
    public boolean mNeedLicense = false;
    private View mNewFirmView;
    private cie mPanoramaRotateAngle;
    private MIDrawerLayout2 mRLDirectionCtl;
    private RelativeLayout mRLParent;
    public String mSAnglePanorama = "1";
    private SDCardHintDialog mSDCardHintDialog;
    private CameraActivityUtils.SdcardDetectResult mSdcardDetectResult = new CameraActivityUtils.SdcardDetectResult();
    private long mSelectTime;
    private SimpleDateFormat mSimpleDateFormat;
    boolean mStoredLandscape = false;
    private TextView mTVAlarm;
    private TextView mTVAlbum;
    public TextView mTVRecordTimer;
    private ImageView mTVSResolution;
    private ImageView mTVSResolution_land;
    private TextView mTimeUpdateView;
    private RelativeLayout mTipsNewLayout;
    private ImageView mTitleMore;
    private UpdateFirmwareHelper mUpdateFirmwareHelper;
    private cjg.O00000Oo mVideoLiveExListener = new cjg.O00000Oo() {
        /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass3 */

        public void onVideoLiveChanged(boolean z) {
            CameraPlayerNewActivity.this.runOnUiThread(new Runnable(z) {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$3$fQ4fcHaHfBRqzVirZmyK7EBZPw */
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CameraPlayerNewActivity.AnonymousClass3.this.lambda$onVideoLiveChanged$0$CameraPlayerNewActivity$3(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onVideoLiveChanged$0$CameraPlayerNewActivity$3(boolean z) {
            if (z) {
                if (ciw.O000000o(CameraPlayerNewActivity.this.getRequestedOrientation())) {
                    CameraPlayerNewActivity.this.dcvDirectionCtrlLandscapeContainer.setVisibility(0);
                }
                CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                cameraPlayerNewActivity.setResolutionText(cameraPlayerNewActivity.mCameraDevice.O00000oO().O0000o00);
            } else {
                if (CameraPlayerNewActivity.this.mCameraPlayerEx != null && CameraPlayerNewActivity.this.mCameraPlayerEx.O00000o0()) {
                    CameraPlayerNewActivity.this.doStopCall();
                }
                if (ciw.O000000o(CameraPlayerNewActivity.this.getRequestedOrientation())) {
                    CameraPlayerNewActivity.this.dcvDirectionCtrlLandscapeContainer.setVisibility(8);
                }
            }
            CameraPlayerNewActivity.this.mVideoViewFrame.invalidate();
        }
    };
    private ViewGroup mVideoParentView;
    public View mask_bg;
    private String md5Name;
    private MoreDialog moreDialog;
    private hlr<List<hjr>> operationProvider = hjm.O000000o();
    float panoramScale = 0.17125382f;
    boolean pet = false;
    public List<chz.O00000o> positions = new ArrayList();
    private BroadcastReceiver receiver2 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass2 */

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("miui.action_open_floating_window")) {
                CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                cameraPlayerNewActivity.mKeepConnection = true;
                cameraPlayerNewActivity.finish();
            }
        }
    };
    private cjg.O000000o resolutionChangedExListener = new cjg.O000000o() {
        /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass4 */

        public void onResolutionChanged(int i, int i2) {
            CameraPlayerNewActivity.this.runOnUiThread(new Runnable(i2, i) {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$4$ZOuQIHTfYpZQPsE5ysmaycPzjNQ */
                private final /* synthetic */ int f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    CameraPlayerNewActivity.AnonymousClass4.this.lambda$onResolutionChanged$0$CameraPlayerNewActivity$4(this.f$1, this.f$2);
                }
            });
            if (CameraPlayerNewActivity.this.mCameraPlayerEx == null) {
                return;
            }
            if (CameraPlayerNewActivity.this.mCameraPlayerEx.O00000Oo()) {
                CameraPlayerNewActivity.this.runOnUiThread(new Runnable(i, i2) {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$4$zvW1x4TYJPLkREBIZkz2927lhU */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ int f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        CameraPlayerNewActivity.AnonymousClass4.this.lambda$onResolutionChanged$1$CameraPlayerNewActivity$4(this.f$1, this.f$2);
                    }
                });
            } else {
                CameraPlayerNewActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$4$ZLVWQSWqz5X0O46rJPmCYsFi5uc */

                    public final void run() {
                        CameraPlayerNewActivity.AnonymousClass4.this.lambda$onResolutionChanged$2$CameraPlayerNewActivity$4();
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onResolutionChanged$0$CameraPlayerNewActivity$4(int i, int i2) {
            CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
            cameraPlayerNewActivity.h_w_ratio = ((float) i) / ((float) i2);
            if (!cameraPlayerNewActivity.mFullScreen) {
                CameraPlayerNewActivity cameraPlayerNewActivity2 = CameraPlayerNewActivity.this;
                cameraPlayerNewActivity2.currentVideoHeight = (int) (((float) cameraPlayerNewActivity2.getScreenWidth()) * CameraPlayerNewActivity.this.h_w_ratio);
                gsy.O00000Oo("CameraPlayerNewActivity", "doOnFirstFrame height - width=" + i + " - " + i2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) CameraPlayerNewActivity.this.mVideoViewFrame.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = CameraPlayerNewActivity.this.currentVideoHeight + (CameraPlayerNewActivity.this.titleBarHeight * 2);
                CameraPlayerNewActivity.this.mVideoViewFrame.setLayoutParams(layoutParams);
                CameraPlayerNewActivity.this.onSnapBabySleep(false);
            }
        }

        public /* synthetic */ void lambda$onResolutionChanged$1$CameraPlayerNewActivity$4(int i, int i2) {
            gsy.O00000Oo("CameraPlayerNewActivity", "width" + i + "height" + i2);
            CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
            cameraPlayerNewActivity.setResolutionText(cameraPlayerNewActivity.mCameraDevice.O00000oO().O0000o00);
            CameraPlayerNewActivity.this.refreshUI();
        }

        public /* synthetic */ void lambda$onResolutionChanged$2$CameraPlayerNewActivity$4() {
            CameraPlayerNewActivity.this.refreshUI();
        }
    };
    public boolean resolutionDialogShowing = false;
    public RelativeLayout rl_panoramic;
    RotateAnimation rotate;
    int sdcardErrorCode = 0;
    boolean sdcardGetSuccess = false;
    int sdcardStatus = 0;
    int selectedIndex;
    private long snapBabySleepTime = 0;
    private Runnable snapshotRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$QngKVCh2eVfJK4vC_y9LbTybZLo */

        public final void run() {
            CameraPlayerNewActivity.this.lambda$new$0$CameraPlayerNewActivity();
        }
    };
    public int titleBarHeight = 0;
    private TextView tvCloudVideo;
    public TextView tvRecordTimerLand;
    private TextView tvShortPlay;
    private TextView tv_panoramic_start;
    public TextView video_scale_tv;

    private int getResolutionIndex(int i) {
        if (i != 1) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    static /* synthetic */ void lambda$onClick$28(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ void lambda$toggleResolution$49(DialogInterface dialogInterface, int i) {
    }

    public boolean isHistory() {
        return false;
    }

    public boolean shouldRecordPlayTime() {
        return true;
    }

    public /* synthetic */ void lambda$new$0$CameraPlayerNewActivity() {
        if (this.mLLFuncPopup.getVisibility() != 8) {
            this.mLLFuncPopup.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_snap_shot_out));
            this.mLLFuncPopup.setVisibility(8);
        }
    }

    public /* synthetic */ void lambda$new$1$CameraPlayerNewActivity() {
        this.mAVCamera.setVisibility(8);
    }

    public /* synthetic */ void lambda$new$2$CameraPlayerNewActivity() {
        this.mAVCameraLandscape.setVisibility(8);
    }

    public /* synthetic */ void lambda$new$3$CameraPlayerNewActivity() {
        if (this.video_scale_tv.getVisibility() == 0) {
            this.video_scale_tv.setVisibility(8);
        }
    }

    public int getScreenWidth() {
        return hyy.O00000Oo(getIntent()).widthPixels;
    }

    public void onDisConnected() {
        super.onDisConnected();
    }

    public void onDisconnectedWithCode(int i) {
        super.onDisconnectedWithCode(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
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
    public void doCreate(Bundle bundle) {
        Locale locale;
        super.doCreate(bundle);
        gwg.O00000Oo(getWindow());
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$mSrERXoUwUciAjmACcWnO16dXbo */

            public final void run() {
                CameraPlayerNewActivity.this.lambda$doCreate$4$CameraPlayerNewActivity();
            }
        }, 2000);
        LogType logType = LogType.CAMERA;
        gsy.O00000o0(logType, "CameraPlayerNewActivity", "doCreate did=" + this.mCameraDevice.getDid() + " model=" + this.mCameraDevice.getModel());
        chr.O000000o(this.mCameraDevice.getDid(), this.mCameraDevice.getModel());
        this.md5Name = grv.O000000o(this.mCameraDevice.getModel() + this.mCameraDevice.getDid());
        setContentView((int) R.layout.activity_camera_new_player);
        this.isLanguageCN = gwc.O000000o(ftn.O00000o0(getContext()), Locale.CHINA);
        this.flTitleBar = (FrameLayout) findViewById(R.id.title_bar);
        if (hyy.O000000o()) {
            this.flTitleBar.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        }
        if (!getIntent().getBooleanExtra("pincod", false)) {
            globalPinCodeVerifyFunc();
            if (this.mCameraDevice.O0000oO()) {
                this.mNeedPincode = true;
            }
        }
        if (gpy.O00000o0(gkv.f17949O000000o, this.md5Name, KOREA_FORCE_PIN_CODE, false) && ftn.O0000OOo(this) && this.mCameraDevice != null && this.mCameraDevice.isOwner()) {
            this.verifyGlobalManager.O000000o(this, new fwg<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass6 */

                public void onSuccess(JSONObject jSONObject) {
                    if (jSONObject.optInt("status") == 2) {
                        CameraPlayerNewActivity.this.mCameraDevice.deviceStat().pinCodeType = 2;
                        if (CameraPlayerNewActivity.this.mCameraDevice.deviceStat().isSetPinCode == 0) {
                            CameraPlayerNewActivity.this.globalPinCodeOnOffFunc();
                            return;
                        }
                        return;
                    }
                    CameraPlayerNewActivity.this.globalPinCodeSettingFunc();
                }

                public void onFailure(fso fso) {
                    gqg.O00000Oo(CameraPlayerNewActivity.this.getString(R.string.toast_failed_retry));
                    CameraPlayerNewActivity.this.finish();
                }
            });
        }
        this.mLocalBroadcastManager = ft.O000000o(XmPluginHostApi.instance().context());
        this.mSimpleDateFormat = new SimpleDateFormat("mm:ss");
        this.mSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        if (getIntent().getBooleanExtra("fail_unbind", false) && this.mCameraDevice.isOwner()) {
            Intent intent = new Intent();
            intent.putExtra("security_setting_enable", false);
            intent.putExtra("unbind_enable", true);
            intent.putExtra("delete_enable", true);
            intent.putExtra("share_enable", false);
            CameraJumpUtils.openMoreMenu(this, this.mCameraDevice.getDid(), new ArrayList(), true, 1002, intent);
            finish();
        }
        initView();
        if (!(this.mCameraDevice == null || this.mCameraDevice.O00000Oo() == null)) {
            this.mCameraDevice.O00000Oo().O000000o(this.mPropertyChangeListener);
            this.mCameraDevice.O00000Oo().O000000o();
        }
        setResolutionText(getResolutionIndex(this.mCameraDevice.O00000oO().O0000o00));
        this.mNetworkMonitor.O000000o(this);
        if (this.mCameraSpecDevice != null) {
            toDetectSpecSDCard();
        } else if (!(this.mCameraDevice == null || this.mCameraDevice.O000000o() == null)) {
            this.mCameraDevice.O000000o().O000000o(chx.f13863O000000o, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass7 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(Void voidR) {
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                        cameraPlayerNewActivity.isPowerCheck = true;
                        cameraPlayerNewActivity.refreshUI();
                        CameraPlayerNewActivity.this.updateUserExperiencePlan();
                    }
                }
            });
        }
        getCameraCloudProps();
        civ.O000000o(this.mCameraDevice.getModel());
        showLicense();
        chr.O000000o(this.mCameraDevice.getDid(), this.mCameraDevice.getModel());
        chr.O000000o(chr.O000o0Oo);
        chr.O000000o();
        this.language = getResources().getConfiguration().locale.getLanguage();
        if (gpy.O00000o0(CommonApplication.getAppContext(), "language_setting", "is_default", false)) {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Resources.getSystem().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            this.language = locale.getLanguage();
        }
        if (DeviceConstant.isSupportOperation(this.mCameraDevice.getModel()) && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && "zh".equalsIgnoreCase(this.language)) {
            this.mTipsNewLayout.setClickable(!drawerClosed);
            updateOperationView();
        }
        lockPreConnectedStatus();
        this.mUpdateFirmwareHelper = new UpdateFirmwareHelper(this);
        goq.O000000o($$Lambda$CameraPlayerNewActivity$DZlA0UAbcxmbwkycNNXQC9XhZ8.INSTANCE);
    }

    public /* synthetic */ void lambda$doCreate$4$CameraPlayerNewActivity() {
        clh.O000000o(this.mCameraDevice);
    }

    private void getCameraCloudProps() {
        if (isPanoramSupportDegree()) {
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("did", this.mCameraDevice.getDid());
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put("prop.s_angle_panorama");
                jSONObject.put("props", jSONArray2);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                cki.O00000oO("CameraPlayerNewActivity", "getCameraCloudProps:" + e.getLocalizedMessage());
            }
            XmPluginHostApi.instance().batchGetDeviceProps(this.mCameraDevice.getModel(), jSONArray, new Callback<String>("prop.s_angle_panorama") {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass8 */

                public void onSuccess(String str) {
                    gsy.O00000Oo("CameraPlayerNewActivity", str);
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!jSONObject.isNull(CameraPlayerNewActivity.this.mCameraDevice.getDid())) {
                            JSONObject optJSONObject = jSONObject.optJSONObject(CameraPlayerNewActivity.this.mCameraDevice.getDid());
                            if (!optJSONObject.isNull("prop.s_angle_panorama")) {
                                String optString = optJSONObject.optString("prop.s_angle_panorama");
                                if (!TextUtils.isEmpty(optString)) {
                                    CameraPlayerNewActivity.this.mSAnglePanorama = optString;
                                }
                            }
                        }
                    } catch (JSONException e) {
                        cki.O00000oO("CameraPlayerNewActivity", "batchGetDeviceProps:" + e.getLocalizedMessage());
                    }
                }

                public void onFailure(int i, String str) {
                    gsy.O00000Oo("CameraPlayerNewActivity", str);
                }
            });
        }
    }

    private void setCameraPanoramCloudProps(final String str) {
        if (isPanoramSupportDegree()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mCameraDevice.getDid());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("prop.s_angle_panorama", str);
                jSONObject.put("props", jSONObject2);
            } catch (JSONException e) {
                cki.O00000oO("CameraPlayerNewActivity", "setCameraPanoramCloudProps:" + e.getLocalizedMessage());
            }
            XmPluginHostApi.instance().setDeviceProps(this.mCameraDevice.getModel(), jSONObject, new Callback<String>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass9 */

                public void onSuccess(String str) {
                    gsy.O00000Oo("CameraPlayerNewActivity", str);
                    CameraPlayerNewActivity.this.mSAnglePanorama = str;
                }

                public void onFailure(int i, String str) {
                    gsy.O00000Oo("CameraPlayerNewActivity", str);
                }
            });
        }
    }

    private void showCloudVideoTips() {
        if (this.mCameraDevice.O00000oO().O0000O0o()) {
            CloudVideoNetUtils.getInstance().getCloudPromoteTips(this.mDid, new ICloudVideoCallback<String>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass10 */

                public void onCloudVideoSuccess(String str, Object obj) {
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        CameraPlayerNewActivity.this.flCloudVideoTips.setVisibility(0);
                        CameraPlayerNewActivity.this.flCloudVideoTips.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$jEZuXwTpV1lEuB5zbhlYQYnwd8Y */

                            public final void onClick(View view) {
                                CameraPlayerNewActivity.this.onClick(view);
                            }
                        });
                        ((TextView) CameraPlayerNewActivity.this.findViewById(R.id.tv_cloud_video_tips)).setText(str);
                        if (CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O0000Ooo == 0) {
                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000Oo(System.currentTimeMillis());
                        }
                    }
                }

                public void onCloudVideoFailed(int i, String str) {
                    gsy.O00000Oo("CameraPlayerNewActivity", str);
                }
            });
        }
    }

    private boolean isSupportNewPlayback() {
        if (this.mCameraDevice == null || !this.mCameraDevice.O00000o() || !DeviceConstant.isNewPlayback(this.mCameraDevice.getModel()) || ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.camera.v4.view.DirectionCtrlViewSingle.<init>(android.content.Context, boolean, float):void
     arg types: [com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity, int, int]
     candidates:
      com.xiaomi.smarthome.camera.v4.view.DirectionCtrlViewSingle.<init>(android.content.Context, android.util.AttributeSet, int):void
      com.xiaomi.smarthome.camera.v4.view.DirectionCtrlViewSingle.<init>(android.content.Context, boolean, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.camera.v4.view.DirectionCtrlViewNew.<init>(android.content.Context, boolean, float):void
     arg types: [com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity, int, int]
     candidates:
      com.xiaomi.smarthome.camera.v4.view.DirectionCtrlViewNew.<init>(android.content.Context, android.util.AttributeSet, int):void
      com.xiaomi.smarthome.camera.v4.view.DirectionCtrlViewNew.<init>(android.content.Context, boolean, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
     arg types: [com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void
     arg types: [com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hxt.O000000o(java.lang.String, boolean, boolean, int, java.lang.String):void
     arg types: [java.lang.String, int, boolean, int, java.lang.String]
     candidates:
      _m_j.hxt.O000000o(java.lang.String, java.lang.String, boolean, int, int):void
      _m_j.hxt.O000000o(java.lang.String, boolean, boolean, int, java.lang.String):void */
    /* access modifiers changed from: protected */
    public void initView() {
        this.direct_push_ll = (LinearLayout) findViewById(R.id.direct_push_ll);
        this.directPushTV = (TextView) findViewById(R.id.directPushTV);
        this.direct_push_close_ic = (ImageView) findViewById(R.id.direct_push_close_ic);
        this.direct_push_close_ic.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$7mGUYQYik6i_tlzuStjsOOrNUQg */

            public final void onClick(View view) {
                CameraPlayerNewActivity.this.lambda$initView$6$CameraPlayerNewActivity(view);
            }
        });
        this.isPresetPositionVersion = clf.O00000Oo(this.mCameraDevice.O00000o0(), "4.0.9_0240");
        this.isPresetPositionVersion = false;
        MIDrawerLayout2.isShowFace = isShowFace();
        drawerClosed = gpy.O00000o0(gkv.f17949O000000o, this.md5Name, DrawerCloseState, true);
        this.mRLDirectionCtl = (MIDrawerLayout2) findViewById(R.id.rlDirectionCtl);
        this.direction_select_iv = (ImageView) findViewById(R.id.direction_select_iv);
        if (!drawerClosed) {
            this.direction_select_iv.setImageResource(R.drawable.home_icon_camera_direction_new);
        } else {
            this.direction_select_iv.setImageResource(R.drawable.home_icon_camera_direction_select_new);
        }
        this.direction_select_iv.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$Wv5dGs4stJRFH0bbVL_gshzdEc */

            public final void onClick(View view) {
                CameraPlayerNewActivity.this.lambda$initView$7$CameraPlayerNewActivity(view);
            }
        });
        this.ll_yuzhiwei = (LinearLayout) findViewById(R.id.ll_yuzhiwei);
        this.iv_preset_edit = (ImageView) findViewById(R.id.iv_preset_edit);
        this.iv_preset_edit.setOnClickListener(this);
        this.alarm_new = (RelativeLayout) findViewById(R.id.alarm_new);
        this.alarm_menu_sub_text = (TextView) findViewById(R.id.menu_sub_text);
        this.alarm_new.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.playback_new);
        relativeLayout.setOnClickListener(this);
        ((ImageView) relativeLayout.findViewById(R.id.menu_icon)).setImageResource(R.drawable.camera_home_menu_icon_huikan);
        ((TextView) relativeLayout.findViewById(R.id.menu_text)).setText((int) R.string.item_history_video);
        ((TextView) relativeLayout.findViewById(R.id.menu_sub_text)).setText((int) R.string.home_new_menu_sub_text_huikan2);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.cloud_video_new);
        relativeLayout2.setOnClickListener(this);
        ((ImageView) relativeLayout2.findViewById(R.id.menu_icon)).setImageResource(R.drawable.camera_home_menu_icon_cunchu);
        ((TextView) relativeLayout2.findViewById(R.id.menu_text)).setText((int) R.string.item_cloud_video);
        ((TextView) relativeLayout2.findViewById(R.id.menu_sub_text)).setText((int) R.string.home_new_menu_sub_text_cunchu);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.face_info_new);
        relativeLayout3.setOnClickListener(this);
        ((ImageView) relativeLayout3.findViewById(R.id.menu_icon)).setImageResource(R.drawable.camera_home_menu_icon_face);
        ((TextView) relativeLayout3.findViewById(R.id.menu_text)).setText((int) R.string.face_info);
        ((TextView) relativeLayout3.findViewById(R.id.menu_sub_text)).setText((int) R.string.face_info_help);
        if (needShowFaceInfo()) {
            relativeLayout3.setVisibility(0);
        }
        this.alarm_new.setClickable(!drawerClosed);
        relativeLayout.setClickable(!drawerClosed);
        relativeLayout2.setClickable(!drawerClosed);
        relativeLayout3.setClickable(!drawerClosed);
        if (isShowFace() || cih.O000000o()) {
            relativeLayout2.setVisibility(0);
        }
        this.mTipsNewLayout = (RelativeLayout) findViewById(R.id.tips_new);
        ((TextView) this.mTipsNewLayout.findViewById(R.id.menu_text)).setText((int) R.string.camera_tips);
        this.mTipsNewLayout.setClickable(!drawerClosed);
        this.mRLDirectionCtl.setStateChangedListener(new MIDrawerLayout2.StateChangedListener(relativeLayout, relativeLayout2, relativeLayout3) {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$QmNHNny_wYd5JtEKfe5x7hFQXRo */
            private final /* synthetic */ RelativeLayout f$1;
            private final /* synthetic */ RelativeLayout f$2;
            private final /* synthetic */ RelativeLayout f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClosed(boolean z) {
                CameraPlayerNewActivity.this.lambda$initView$8$CameraPlayerNewActivity(this.f$1, this.f$2, this.f$3, z);
            }
        });
        this.video_scale_tv = (TextView) findViewById(R.id.video_scale_tv);
        if (DeviceConstant.isNewChuangmi(this.mCameraDevice.getModel())) {
            this.video_scale_tv.getPaint();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.video_scale_tv.getLayoutParams();
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.direction_view_bg);
            layoutParams.width = decodeResource.getWidth();
            layoutParams.height = decodeResource.getHeight();
            this.video_scale_tv.setLayoutParams(layoutParams);
            this.video_scale_tv.setVisibility(8);
        }
        this.iv_back_landscape = (ImageView) findViewById(R.id.iv_back_landscape);
        this.iv_back_landscape.setOnClickListener(this);
        if (hyy.O000000o()) {
            ((ViewGroup.MarginLayoutParams) this.iv_back_landscape.getLayoutParams()).setMarginStart(gpc.O000000o(30.0f));
        }
        this.fl_direction_ctrl = (RelativeLayout) findViewById(R.id.fl_direction_ctrl);
        this.rl_panoramic = (RelativeLayout) findViewById(R.id.rl_panoramic);
        this.ll_yuzhiwei = (LinearLayout) findViewById(R.id.ll_yuzhiwei);
        this.fl_panoramic = (FrameLayout) findViewById(R.id.fl_panoramic);
        this.iv_panoramic_close = (ImageView) findViewById(R.id.iv_panoramic_close);
        this.iv_panoramic_close.setOnClickListener(this);
        this.iv_panoramic_edit = (ImageView) findViewById(R.id.iv_panoramic_edit);
        this.iv_panoramic_edit.setOnClickListener(this);
        this.tv_panoramic_start = (TextView) findViewById(R.id.tv_panoramic_start);
        this.tv_panoramic_start.setOnClickListener(this);
        if (!this.mCameraDevice.isReadOnlyShared()) {
            this.tv_panoramic_start.setVisibility(0);
        }
        this.iv_panoramic = (RoundedImageView) findViewById(R.id.iv_panoramic);
        this.iv_loading_panoramic = (ImageView) findViewById(R.id.iv_loading_panoramic);
        this.rotate = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.rotate.setInterpolator(new LinearInterpolator());
        this.rotate.setDuration(2000);
        this.rotate.setRepeatCount(-1);
        this.rotate.setFillAfter(true);
        this.rotate.setStartOffset(10);
        this.iv_panoramic_mask = (PanoramicMaskView) findViewById(R.id.iv_panoramic_mask);
        this.iv_panoramic_mask.setCameraGetPanorama(this.mCameraDevice.O0000OoO());
        this.iv_panoramic_mask.setOnUpListener(new PanoramicMaskView.O000000o() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$6VCdSJ3HTdbDeZL9JUKvjdQ7oxw */

            public final void onUpEvent(short s, short s2) {
                CameraPlayerNewActivity.this.lambda$initView$9$CameraPlayerNewActivity(s, s2);
            }
        });
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.rl_panoramic_middle);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) relativeLayout4.getLayoutParams();
        layoutParams2.width = getScreenWidth() - gpc.O000000o(48.0f);
        layoutParams2.height = (int) (((float) layoutParams2.width) * this.panoramScale);
        String str = cht.f13831O000000o;
        gsy.O00000Oo(str, "iv_panoramic width/height=" + layoutParams2.width + "/" + layoutParams2.height);
        relativeLayout4.setLayoutParams(layoutParams2);
        this.ll_panoramic_tip = (LinearLayout) findViewById(R.id.ll_panoramic_tip);
        this.ll_panoramic_doing = (LinearLayout) findViewById(R.id.ll_panoramic_doing);
        this.mLandLayout = findViewById(R.id.land_layout);
        this.mNewFirmView = findViewById(R.id.title_bar_redpoint);
        this.mTitleView = (TextView) findViewById(R.id.title_bar_title);
        this.mTimeUpdateView = (TextView) findViewById(R.id.time_container_center);
        this.dcvDirectionCtrl_container = (FrameLayout) findViewById(R.id.dcvDirectionCtrl_container);
        this.dcvDirectionCtrlLandscapeContainer = (FrameLayout) findViewById(R.id.dcvDirectionCtrlLandscapeContainer);
        if (DeviceConstant.isSingle(this.mDeviceStat.model)) {
            if (isSupportCenter(this.mDeviceStat.model)) {
                this.iv_panoramic_close.setVisibility(0);
            }
            this.mDcvDirectionCtrl = new DirectionCtrlViewSingle((Context) this, false, 1.0f);
            this.mDcvDirectionCtrlLandscape = new DirectionCtrlViewSingle((Context) this, false, 1.0f);
        } else if (isSupportCenter(this.mDeviceStat.model)) {
            this.iv_panoramic_close.setVisibility(0);
            this.mDcvDirectionCtrl = new DirectionCtrlViewNew((Context) this, false, 1.0f);
            this.mDcvDirectionCtrlLandscape = new DirectionCtrlView(this, false, 1.3f, false);
        } else {
            this.mDcvDirectionCtrl = new DirectionCtrlViewNew((Context) this, false, 1.0f);
            this.mDcvDirectionCtrlLandscape = new DirectionCtrlView(this, false, 1.2f, false);
        }
        this.dcvDirectionCtrl_container.removeAllViews();
        this.dcvDirectionCtrl_container.addView(this.mDcvDirectionCtrl, new FrameLayout.LayoutParams(-2, -2));
        this.dcvDirectionCtrlLandscapeContainer.removeAllViews();
        this.dcvDirectionCtrlLandscapeContainer.addView(this.mDcvDirectionCtrlLandscape, new FrameLayout.LayoutParams(-2, -2));
        this.dcvDirectionCtrl_container.setVisibility(0);
        this.mDcvDirectionCtrl.setOnDirectionCtrlListener(this.OnDirectionCtrlListener);
        this.mDcvDirectionCtrlLandscape.setOnDirectionCtrlListener(this.OnDirectionCtrlListener);
        this.mTitleMore = (ImageView) findViewById(R.id.title_bar_more);
        this.ivShotPic = (ImageView) findViewById(R.id.ivShotPic);
        if (this.mCameraDevice.isReadOnlyShared()) {
            this.mTitleMore.setVisibility(8);
        } else {
            this.mTitleMore.setVisibility(0);
        }
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.video_frame);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this);
        this.mVideoViewFrame.addView(frameLayout, 0, layoutParams3);
        this.mVideoParentView = (ViewGroup) findViewById(R.id.video_parent);
        this.mVideoView = ciy.O000000o(this.mCameraDevice.getModel(), frameLayout);
        this.mVideoView.O00000Oo(6.0f, 6.0f);
        this.mVideoView.O000000o(0.24375f);
        this.mVideoView.O00000Oo();
        this.mSurfaceViewScale = 1.0f;
        this.mSurfaceViewOffsetX = 0.0f;
        this.mSurfaceViewOffsetY = 0.0f;
        if (this.mCameraDevice != null && !TextUtils.isEmpty(this.mCameraDevice.getModel()) && !TextUtils.isEmpty(this.mCameraDevice.getModel())) {
            this.mSurfaceViewScale = gpy.O000000o(gkv.f17949O000000o, this.md5Name, "scale", 0.0f);
            this.mSurfaceViewScaleX = gpy.O000000o(gkv.f17949O000000o, this.md5Name, "video_View_scaleX", 1.0f);
            this.isMinScale = gpy.O00000o0(gkv.f17949O000000o, this.md5Name, "SP_KEY_SCALE_IS_MINISCALE", true);
            this.mSurfaceViewOffsetX = gpy.O000000o(gkv.f17949O000000o, this.md5Name, "offsetX", 0.0f);
            this.mSurfaceViewOffsetY = gpy.O000000o(gkv.f17949O000000o, this.md5Name, "offsetY", 0.0f);
        }
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            this.mVideoView.O000000o(0.0f, 0.0f, 0.0f);
        } else {
            this.mVideoView.O000000o(255.0f, 255.0f, 255.0f);
        }
        this.mVideoView.O00000Oo(true);
        if (this.mSurfaceViewScale > 0.0f) {
            this.mVideoView.O00000Oo(this.mSurfaceViewScale);
        }
        this.mVideoView.O00000o0(this.mSurfaceViewOffsetX);
        this.mVideoView.O00000o(this.mSurfaceViewOffsetY);
        this.mVideoView.O000000o(new XmVideoViewGl.OnDirectionCtrlListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass11 */

            public void onClickPTZDirection(int i) {
                cki.O00000o("CameraPlayerNewActivity", "on gesture gestureEnable = " + CameraPlayerNewActivity.this.gestureEnable);
                if (CameraPlayerNewActivity.this.gestureEnable && CameraPlayerNewActivity.this.mCameraDevice != null && !CameraPlayerNewActivity.this.mCameraDevice.isReadOnlyShared()) {
                    if (CameraPlayerNewActivity.this.mFullScreen) {
                        CameraPlayerNewActivity.this.mAVCameraLandscape.setVisibility(0);
                        CameraPlayerNewActivity.this.video_scale_tv.setVisibility(8);
                    }
                    if (CameraPlayerNewActivity.this.OnDirectionCtrlListener != null) {
                        CameraPlayerNewActivity.this.OnDirectionCtrlListener.onActionDown();
                        CameraPlayerNewActivity.this.OnDirectionCtrlListener.onClickPTZDirection(i);
                        CameraPlayerNewActivity.this.OnDirectionCtrlListener.onActionUp(false);
                    }
                }
            }
        });
        this.mVideoView.O000000o(new XmVideoViewGl.OnScaleListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass12 */

            public void onScaleChage(float f) {
                if (CameraPlayerNewActivity.this.mVideoView.O00000o0() != 0.0f) {
                    if (CameraPlayerNewActivity.this.mLLVideoViewBottomCtrl.getTranslationY() <= 0.0f) {
                        CameraPlayerNewActivity.this.bottomCtrlAnimDown();
                    }
                    double O00000o0 = (double) CameraPlayerNewActivity.this.mVideoView.O00000o0();
                    Double.isNaN(O00000o0);
                    if (((double) f) > O00000o0 + 0.05d) {
                        if (CameraPlayerNewActivity.this.isMinScale) {
                            if (CameraPlayerNewActivity.this.mFullScreen) {
                                CameraPlayerNewActivity.this.hideStatusBar();
                            } else {
                                CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                                cameraPlayerNewActivity.isMinScale = false;
                                cameraPlayerNewActivity.onMinScaleChanged(false);
                            }
                        }
                    } else if (!CameraPlayerNewActivity.this.isMinScale) {
                        if (CameraPlayerNewActivity.this.mFullScreen) {
                            CameraPlayerNewActivity.this.hideStatusBar();
                        } else {
                            CameraPlayerNewActivity cameraPlayerNewActivity2 = CameraPlayerNewActivity.this;
                            cameraPlayerNewActivity2.isMinScale = true;
                            cameraPlayerNewActivity2.onMinScaleChanged(true);
                        }
                    }
                    float O00000o02 = CameraPlayerNewActivity.this.mVideoView.O00000o0();
                    CameraPlayerNewActivity cameraPlayerNewActivity3 = CameraPlayerNewActivity.this;
                    cameraPlayerNewActivity3.mSurfaceViewScaleX = f;
                    cameraPlayerNewActivity3.resetLeftTopTools();
                    float round = ((float) Math.round((f / O00000o02) * 10.0f)) / 10.0f;
                    gsy.O00000Oo("CameraPlayerNewActivity", "mSurfaceViewScaleX = " + f + ":" + round);
                    CameraPlayerNewActivity.this.video_scale_tv.setText(String.format(Locale.getDefault(), "%.1fx", Float.valueOf(round)));
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) CameraPlayerNewActivity.this.video_scale_tv.getLayoutParams();
                    layoutParams.topMargin = gpc.O000000o(CameraPlayerNewActivity.this.mFullScreen ? 85.0f : 115.0f);
                    CameraPlayerNewActivity.this.video_scale_tv.setLayoutParams(layoutParams);
                    CameraPlayerNewActivity.this.video_scale_tv.setVisibility(0);
                    CameraPlayerNewActivity.this.mAVCamera.setVisibility(8);
                    CameraPlayerNewActivity.this.mAVCameraLandscape.setVisibility(8);
                    CameraPlayerNewActivity.this.mHandler.removeCallbacks(CameraPlayerNewActivity.this.hideScaleTvR);
                    CameraPlayerNewActivity.this.mHandler.postDelayed(CameraPlayerNewActivity.this.hideScaleTvR, 3000);
                }
            }

            public void onFirstVideoShow() {
                ckj O000000o2 = ckj.O000000o();
                O000000o2.O000000o("CameraPlayerNewActivity" + hashCode(), "FIRST_RENDER:onFirstVideoShow call");
                CameraPlayerNewActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$12$bMbIvBCFgBc2joRPIe2ufQPJns */

                    public final void run() {
                        CameraPlayerNewActivity.AnonymousClass12.this.lambda$onFirstVideoShow$0$CameraPlayerNewActivity$12();
                    }
                });
            }

            public /* synthetic */ void lambda$onFirstVideoShow$0$CameraPlayerNewActivity$12() {
                gsy.O00000Oo("CameraPlayerNewActivity", "onFirstVideoShow");
                CameraPlayerNewActivity.this.mask_bg.setVisibility(8);
                CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                cameraPlayerNewActivity.isFirstFrameShowed = true;
                if (!cameraPlayerNewActivity.mFullScreen) {
                    CameraPlayerNewActivity cameraPlayerNewActivity2 = CameraPlayerNewActivity.this;
                    cameraPlayerNewActivity2.onMinScaleChanged(cameraPlayerNewActivity2.isMinScale);
                }
                CameraPlayerNewActivity.this.video_scale_tv.setText(String.format(Locale.getDefault(), "%.1fx", Float.valueOf(CameraPlayerNewActivity.this.mSurfaceViewScaleX)));
                ckj O000000o2 = ckj.O000000o();
                O000000o2.O000000o("CameraPlayerNewActivity" + hashCode(), "FIRST_RENDER:onFirstVideoShow");
            }
        });
        this.mVideoView.O000000o($$Lambda$CameraPlayerNewActivity$HWzSJnVZeg0Q3vcPIrS5nAIQDQ.INSTANCE);
        this.mVideoView.O000000o(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$4Tww8n319HekeSEV8p7xVPmNgr4 */

            public final void onVideoViewClick() {
                CameraPlayerNewActivity.this.lambda$initView$11$CameraPlayerNewActivity();
            }
        });
        if (this.mCameraDevice.isOwner()) {
            this.mCameraDevice.O000000o(getContext(), new Callback<FirmwareUpdateResult>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass13 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(FirmwareUpdateResult firmwareUpdateResult) {
                    Message.obtain(CameraPlayerNewActivity.this.mHandler, 1, firmwareUpdateResult).sendToTarget();
                }
            });
        }
        this.video_scale_tv.setText(String.format(Locale.getDefault(), "%.1fx", Float.valueOf(1.0f)));
        this.mLoadingView = LayoutInflater.from(this).inflate((int) R.layout.camera_progress, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
        this.mVideoViewFrame.addView(this.mLoadingView, layoutParams4);
        this.mLoadingProgress = (TextView) this.mLoadingView.findViewById(R.id.loading_progress);
        this.mLoadingTitle = (TextView) this.mLoadingView.findViewById(R.id.loading_title);
        this.mLoadingImageView = (ImageView) this.mLoadingView.findViewById(R.id.loading_anim);
        this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_anim_camera_loading);
        this.mLoadingImageView.setImageDrawable(this.mLoadingAnimation);
        this.mLoadingView.setVisibility(8);
        this.mErrorRetryView = LayoutInflater.from(this).inflate((int) R.layout.camera_error_retry, (ViewGroup) null);
        this.retry_tv = (TextView) this.mErrorRetryView.findViewById(R.id.retry_tv);
        this.retry_tv.setOnClickListener(this);
        this.retry_tv.setVisibility(0);
        this.see_help = (TextView) this.mErrorRetryView.findViewById(R.id.see_help);
        this.see_help.setOnClickListener(this);
        this.see_help.setVisibility(0);
        this.offline_time = (TextView) this.mErrorRetryView.findViewById(R.id.offline_time);
        this.mVideoViewFrame.addView(this.mErrorRetryView, layoutParams4);
        this.mErrorRetryView.setVisibility(8);
        this.mRetryView = this.mErrorRetryView.findViewById(R.id.retry_btn);
        this.mErrorInfoView = (TextView) this.mErrorRetryView.findViewById(R.id.error_info);
        this.mPowerOffView = LayoutInflater.from(this).inflate((int) R.layout.camera_closed_v4, (ViewGroup) null);
        if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
            ((TextView) this.mPowerOffView.findViewById(R.id.closed_tips_tv)).setText((int) R.string.camera_closed_wulizhebi_tip);
        }
        this.mVideoViewFrame.addView(this.mPowerOffView, layoutParams4);
        this.mPowerOffView.setVisibility(8);
        this.mPowerOffView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass14 */

            public void onClick(View view) {
                if (CameraPlayerNewActivity.this.mLLVideoViewBottomCtrl.getTranslationY() > 0.0f) {
                    CameraPlayerNewActivity.this.bottomCtrlAnimUp();
                } else {
                    CameraPlayerNewActivity.this.dismissBottomCtrlVisibilityGoneRunnable(0);
                }
            }
        });
        this.mHintView = LayoutInflater.from(this).inflate((int) R.layout.camera_hint_view, (ViewGroup) null);
        this.mVideoViewFrame.addView(this.mHintView, layoutParams4);
        this.mFrameRate = (TextView) findViewById(R.id.sub_title_bar_title);
        this.mTVExitFullScreen = (TextView) findViewById(R.id.tvExitFullScreen);
        this.mTVExitFullScreen.setOnClickListener(this);
        this.mCBMuteLandscape = (CheckBox) findViewById(R.id.cbMuteLandscape_land);
        this.mLLVideoViewBottomCtrl = (LinearLayout) findViewById(R.id.llVideoViewBottomCtrl);
        this.mLLVideoViewBottomCtrl.bringToFront();
        this.mCBMuteLandscape.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$BMAv5FJgOtGxELK4IGiIyiHGW8 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CameraPlayerNewActivity.this.lambda$initView$12$CameraPlayerNewActivity(view, motionEvent);
            }
        });
        this.mCBMuteLandscape.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$WVuO6vdNPSNNxlhrB01aWbfPqY8 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CameraPlayerNewActivity.this.lambda$initView$13$CameraPlayerNewActivity(compoundButton, z);
            }
        });
        this.mCBVoiceLandscape = (CheckBox) findViewById(R.id.cbVoiceLandscape);
        this.mCBVoiceLandscape.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$OH523JfShIRsZ9lISx4meHanJPY */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CameraPlayerNewActivity.this.lambda$initView$14$CameraPlayerNewActivity(compoundButton, z);
            }
        });
        this.mLLRightCtrlLandscape = (LinearLayout) findViewById(R.id.llRightCtrlLandscape);
        this.mTitleMore.setOnClickListener(this);
        this.mRetryView.setOnClickListener(this);
        this.tvCloudVideo = (TextView) findViewById(R.id.tvCloudVideo);
        this.flCloudVideoTips = (FrameLayout) findViewById(R.id.fl_cloud_video_tips);
        this.mLLFuncPopup = (CardView) findViewById(R.id.llFuncPopup);
        this.tvShortPlay = (TextView) findViewById(R.id.tvShortPlay);
        this.mRLDirectionCtl = (MIDrawerLayout2) findViewById(R.id.rlDirectionCtl);
        this.mRLParent = (RelativeLayout) findViewById(R.id.rlParent);
        this.tvCloudVideo = (TextView) findViewById(R.id.tvCloudVideo);
        this.flCloudVideoTips = (FrameLayout) findViewById(R.id.fl_cloud_video_tips);
        this.flTopCtrlLandscape = (FrameLayout) findViewById(R.id.flTopCtrlLandscape);
        findViewById(R.id.cbShortLandscape).setOnClickListener(this);
        this.mRLParent = (RelativeLayout) findViewById(R.id.rlParent);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mTVAlbum = (TextView) findViewById(R.id.tvAlbum);
        this.mTVAlbum.setOnClickListener(this);
        this.mTVSResolution = (ImageView) findViewById(R.id.tvsResolution);
        this.mTVSResolution_land = (ImageView) findViewById(R.id.tvsResolution_land);
        this.mTVSResolution.setOnClickListener(this);
        this.mTVSResolution_land.setOnClickListener(this);
        this.ivFullScreen = (ImageView) findViewById(R.id.ivFullScreen);
        this.ivFullScreen.setOnClickListener(this);
        this.ivCameraShot = (ImageView) findViewById(R.id.ivCameraShot);
        this.ivCameraShot.setOnClickListener(this);
        this.mPauseView = findViewById(R.id.pause_view);
        this.mPauseView.setOnClickListener(this);
        this.mTVAlarm = (TextView) findViewById(R.id.tvAlarm);
        this.mTVAlarm.setOnClickListener(this);
        findViewById(R.id.tvStorage).setOnClickListener(this);
        this.mTVRecordTimer = (TextView) findViewById(R.id.tvRecordTimer);
        this.tvRecordTimerLand = (TextView) findViewById(R.id.tvRecordTimerLand);
        this.mAVCamera = (AngleView) findViewById(R.id.avCamera);
        this.mAVCameraLandscape = (AngleView) findViewById(R.id.avCameraLandscape);
        this.mCDCCameraRecord = (CenterDrawableCheckBox) findViewById(R.id.cdcCameraRecord);
        this.mCDCCameraRecordFull = (CheckBox) findViewById(R.id.cbRecordLandscape);
        AnonymousClass15 r1 = new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass15 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (CameraPlayerNewActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    return false;
                }
                if (motionEvent.getAction() == 1) {
                    CameraToastUtil.showPowerOffToast(CameraPlayerNewActivity.this.mCameraDevice.getModel(), CameraPlayerNewActivity.this, R.string.sleep_recode_error);
                }
                return true;
            }
        };
        this.mCDCCameraRecord.setOnTouchListener(r1);
        this.mCDCCameraRecordFull.setOnTouchListener(r1);
        AnonymousClass16 r12 = new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass16 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
             arg types: [int, java.lang.String]
             candidates:
              _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
              _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cin.O000000o(android.content.Context, int):java.lang.String
             arg types: [com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity, int]
             candidates:
              _m_j.cin.O000000o(int, boolean):int
              _m_j.cin.O000000o(android.content.Context, float):int
              _m_j.cin.O000000o(java.lang.String, java.lang.String):int
              _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
              _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
              _m_j.cin.O000000o(android.content.Context, int):java.lang.String */
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O000oO0O);
                if (compoundButton.isPressed()) {
                    CameraPlayerNewActivity.this.mCDCCameraRecord.setOnCheckedChangeListener(null);
                    CameraPlayerNewActivity.this.mCDCCameraRecordFull.setOnCheckedChangeListener(null);
                    CameraPlayerNewActivity.this.mCDCCameraRecord.setChecked(z);
                    CameraPlayerNewActivity.this.mCDCCameraRecordFull.setChecked(z);
                    CameraPlayerNewActivity.this.mCDCCameraRecord.setOnCheckedChangeListener(this);
                    CameraPlayerNewActivity.this.mCDCCameraRecordFull.setOnCheckedChangeListener(this);
                }
                if (z) {
                    CameraPlayerNewActivity.this.mCDCCameraRecord.setBackgroundResource(R.drawable.home_icon_camera_recording_v4_new);
                    CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                    cameraPlayerNewActivity.mLastTime = 0;
                    cameraPlayerNewActivity.mCurrentTime = 0;
                    String O000000o2 = me.O000000o(true, cameraPlayerNewActivity.mCameraDevice.getDid());
                    if (CameraPlayerNewActivity.this.mCameraDevice != null && CameraPlayerNewActivity.this.mCameraPlayerEx != null && !CameraPlayerNewActivity.this.mCameraPlayerEx.O0000Ooo()) {
                        gqg.O000000o((int) R.string.record_not_connect);
                        CameraPlayerNewActivity.this.mCDCCameraRecord.setBackgroundResource(R.drawable.home_icon_camera_record_v4_new);
                        CameraPlayerNewActivity.this.mCDCCameraRecord.setChecked(false);
                        CameraPlayerNewActivity.this.mCDCCameraRecordFull.setChecked(false);
                    } else if (!XmPluginHostApi.instance().checkAndRequestPermisson(CameraPlayerNewActivity.this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        gqg.O000000o((int) R.string.no_write_permission);
                        CameraPlayerNewActivity.this.mCDCCameraRecord.setBackgroundResource(R.drawable.home_icon_camera_record_v4_new);
                        CameraPlayerNewActivity.this.mCDCCameraRecord.setChecked(false);
                        CameraPlayerNewActivity.this.mCDCCameraRecordFull.setChecked(false);
                    } else if (!TextUtils.isEmpty(O000000o2)) {
                        if (!(CameraPlayerNewActivity.this.mCameraDevice == null || CameraPlayerNewActivity.this.mCameraPlayerEx == null || CameraPlayerNewActivity.this.mCameraPlayerEx.O0000O0o())) {
                            CameraPlayerNewActivity.this.mCameraPlayerEx.O000000o(O000000o2, 2);
                            CameraPlayerNewActivity.this.mCameraPlayerEx.O00000Oo(true);
                        }
                        CameraPlayerNewActivity.this.disableRecord();
                        CameraPlayerNewActivity cameraPlayerNewActivity2 = CameraPlayerNewActivity.this;
                        cameraPlayerNewActivity2.upDateTimeTitle(cin.O000000o((Context) cameraPlayerNewActivity2, 0));
                        if (CameraPlayerNewActivity.this.mFullScreen) {
                            CameraPlayerNewActivity.this.tvRecordTimerLand.setVisibility(0);
                        } else {
                            CameraPlayerNewActivity.this.mTVRecordTimer.setVisibility(0);
                        }
                        gsy.O00000Oo("CameraPlayerNewActivity", "startRecord");
                        chr.O0000oOO();
                        CameraPlayerNewActivity.this.mCDCCameraRecordFull.setChecked(z);
                    } else {
                        gqg.O000000o((int) R.string.snip_video_failed);
                    }
                } else {
                    chr.O0000oOo();
                    CameraPlayerNewActivity.this.mCDCCameraRecord.setBackgroundResource(R.drawable.home_icon_camera_record_v4_new);
                    CameraPlayerNewActivity.this.mCDCCameraRecordFull.setChecked(false);
                    CameraPlayerNewActivity.this.enabledBtns(false, true);
                    CameraPlayerNewActivity.this.doStopRecord();
                }
            }
        };
        this.mCDCCameraRecord.setOnCheckedChangeListener(r12);
        this.mCDCCameraRecordFull.setOnCheckedChangeListener(r12);
        findViewById(R.id.tvMore).setOnClickListener(this);
        this.mCallWave = (WaveView) findViewById(R.id.call_wave);
        this.mMSTVVoice = (MultiStateImageView) findViewById(R.id.mstvVoice);
        this.mMSTVVoice.addState(new MultiStateImageView.StateItem(R.string.call_start, R.drawable.call_start_bg_new, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$gapu2fG4SmapgZxybuHOGTiYcA */

            public final void onClick(View view) {
                CameraPlayerNewActivity.this.lambda$initView$15$CameraPlayerNewActivity(view);
            }
        }));
        this.mMSTVVoice.addState(new MultiStateImageView.StateItem(R.string.call_end, R.drawable.call_end_bg_new, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$JyEy_bMt72Oz1XYMczJEVtmcWQ */

            public final void onClick(View view) {
                CameraPlayerNewActivity.this.lambda$initView$16$CameraPlayerNewActivity(view);
            }
        }));
        this.mMSTVVoice.setCurrentState(0);
        this.mCDCToggleAudio = (CenterDrawableCheckBox) findViewById(R.id.cdcToggleAudio);
        this.mCDCToggleAudio.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$yZYLdn1ehzWa18Yeoea6hBY_E0 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CameraPlayerNewActivity.this.lambda$initView$17$CameraPlayerNewActivity(view, motionEvent);
            }
        });
        this.mCDCToggleAudio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$uX8ux4yISwgbGvBx8VymZ_77lMk */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CameraPlayerNewActivity.this.lambda$initView$18$CameraPlayerNewActivity(compoundButton, z);
            }
        });
        this.mCdcToggleSleep = (MultiStateView) findViewById(R.id.cdcToggleSleep);
        this.mCdcToggleSleep.addState(new MultiStateView.StateItem(R.drawable.home_icon_sleep_new, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$RjUqkeq4YUFTKY5y6V_YfbLASEQ */

            public final void onClick(View view) {
                CameraPlayerNewActivity.this.lambda$initView$20$CameraPlayerNewActivity(view);
            }
        }));
        this.mCdcToggleSleep.addState(new MultiStateView.StateItem(R.drawable.home_icon_sleep_new, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$LrENOpvprZhtKzVBAidITkW89gU */

            public final void onClick(View view) {
                CameraPlayerNewActivity.this.lambda$initView$21$CameraPlayerNewActivity(view);
            }
        }));
        if (!(this.mCameraDevice == null || this.mCameraDevice.O000000o() == null)) {
            this.mCdcToggleSleep.setCurrentState(this.mCameraDevice.O000000o().O000000o("power", true) ^ true ? 1 : 0);
        }
        TextView textView = (TextView) findViewById(R.id.tvMore);
        if (!isShowFace()) {
            textView.setText((int) R.string.item_shortcut);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.home_icon_more), (Drawable) null, (Drawable) null);
        }
        this.mask_bg = findViewById(R.id.mask_bg);
        int O000000o2 = gpy.O000000o((Context) this, this.md5Name, "SP_KEY_SAFE_PASSWORD", -1);
        if ("chuangmi.camera.029a02".equals(this.mCameraDevice.getModel()) && ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && O000000o2 != 1) {
            gpy.O00000Oo((Context) this, this.md5Name, "SP_KEY_SAFE_PASSWORD", 1);
            DirectPushItemView directPushItemView = new DirectPushItemView(this);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams5.topMargin = gpc.O000000o(100.0f);
            layoutParams5.leftMargin = gpc.O000000o(10.0f);
            layoutParams5.rightMargin = gpc.O000000o(10.0f);
            layoutParams5.gravity = 1;
            this.mVideoViewFrame.addView(directPushItemView, layoutParams5);
            directPushItemView.setCloseListener(new View.OnClickListener(directPushItemView) {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$4YOeYZRAWiyi0b7AEzo6fHpRE */
                private final /* synthetic */ DirectPushItemView f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CameraPlayerNewActivity.this.lambda$initView$22$CameraPlayerNewActivity(this.f$1, view);
                }
            });
            directPushItemView.setTextClickListener(new View.OnClickListener(directPushItemView) {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$QGYAtqPVDR4Ot8NIpiSlIHsgKQ */
                private final /* synthetic */ DirectPushItemView f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CameraPlayerNewActivity.this.lambda$initView$23$CameraPlayerNewActivity(this.f$1, view);
                }
            });
        }
        if (this.mDeviceStat != null) {
            hxi.O0000Oo.O000000o(this.mDeviceStat.model, false, this.mDeviceStat.isOnline, this.mDeviceStat.pid, this.mDeviceStat.did);
        }
    }

    public /* synthetic */ void lambda$initView$6$CameraPlayerNewActivity(View view) {
        this.direct_push_ll.setVisibility(8);
    }

    public /* synthetic */ void lambda$initView$7$CameraPlayerNewActivity(View view) {
        chr.O000000o(chr.O000oOO0);
        if (this.mRLDirectionCtl.isClosed()) {
            this.direction_select_iv.setImageResource(R.drawable.home_icon_camera_direction_new);
        } else {
            this.direction_select_iv.setImageResource(R.drawable.home_icon_camera_direction_select_new);
        }
        this.mRLDirectionCtl.toggleDrawer();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.chr.O000000o(int, int, long):void
      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
    public /* synthetic */ void lambda$initView$8$CameraPlayerNewActivity(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, boolean z) {
        if (z) {
            this.alarm_new.setClickable(false);
            relativeLayout.setClickable(false);
            relativeLayout2.setClickable(false);
            this.mTipsNewLayout.setClickable(false);
            relativeLayout3.setClickable(false);
            this.direction_select_iv.setImageResource(R.drawable.home_icon_camera_direction_select_new);
            chr.O000000o(chr.O000oOO, "type", (Object) 1);
        } else {
            this.alarm_new.setClickable(true);
            relativeLayout.setClickable(true);
            relativeLayout2.setClickable(true);
            this.mTipsNewLayout.setClickable(true);
            relativeLayout3.setClickable(true);
            this.direction_select_iv.setImageResource(R.drawable.home_icon_camera_direction_new);
            chr.O000000o(chr.O000oOO, "type", (Object) 2);
        }
        drawerClosed = z;
    }

    public /* synthetic */ void lambda$initView$9$CameraPlayerNewActivity(short s, short s2) {
        if (this.mPanoramaRotateAngle == null) {
            this.mPanoramaRotateAngle = new cie(this.mCameraDevice);
        }
        cie cie = this.mPanoramaRotateAngle;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((int) s);
        jSONArray.put((int) s2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac", "F1F2F3F4F5F6");
            jSONObject.put("angle", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String str = cie.f13891O000000o;
        gsy.O00000Oo(str, "rotateAngle params=" + jSONObject.toString());
        cie.O00000Oo.O00oOooO().streamSendMessage(13, 13, jSONObject.toString().getBytes(), null, new IMISSListener() {
            /* class _m_j.cie.AnonymousClass1 */

            public final void onProgress(int i) {
            }

            public final void onSuccess(String str, Object obj) {
                String str2 = cie.f13891O000000o;
                gsy.O00000Oo(str2, "rotateAngle onSuccess = " + str + " " + obj);
            }

            public final void onFailed(int i, String str) {
                String str2 = cie.f13891O000000o;
                gsy.O00000Oo(str2, "rotateAngle onFailed = " + i + " " + str);
            }
        });
    }

    static /* synthetic */ void lambda$initView$10(int i) {
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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public /* synthetic */ void lambda$initView$11$CameraPlayerNewActivity() {
        if (this.mCameraDevice.O000000o().O000000o("power", true)) {
            videoClick();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public /* synthetic */ boolean lambda$initView$12$CameraPlayerNewActivity(View view, MotionEvent motionEvent) {
        if (this.mCameraDevice.O000000o().O000000o("power", true)) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
        }
        return true;
    }

    public /* synthetic */ void lambda$initView$13$CameraPlayerNewActivity(CompoundButton compoundButton, boolean z) {
        if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O00000o0()) {
            chr.O000000o(chr.O000oO00);
            this.mCDCToggleAudio.setChecked(z);
            if (this.mCameraPlayerEx == null) {
                return;
            }
            if (z) {
                this.mCameraPlayerEx.O00000o0(false);
            } else {
                this.mCameraPlayerEx.O00000o0(true);
            }
        } else {
            this.mCBMuteLandscape.setChecked(!z);
            canStepOut();
        }
    }

    public /* synthetic */ void lambda$initView$14$CameraPlayerNewActivity(CompoundButton compoundButton, boolean z) {
        gsy.O00000Oo("CameraPlayerNewActivity", "mCBVoiceLandscape:".concat(String.valueOf(z)));
        if (this.mCameraPlayerEx == null) {
            return;
        }
        if (!z) {
            chr.O0000Oo();
            this.mCameraPlayerEx.O00000oO();
            if (this.mCBMuteLandscape.isChecked()) {
                this.mCBMuteLandscape.setChecked(false);
            }
            this.mHandler.removeMessages(2101);
        } else if (this.mCameraDevice.isReadOnlyShared()) {
            gqg.O000000o((int) R.string.auth_fail_read_only);
            this.mCBVoiceLandscape.setChecked(false);
        } else if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.RECORD_AUDIO")) {
            gqg.O000000o((int) R.string.audio_permission_denied);
            this.mCBVoiceLandscape.setChecked(false);
        } else if (!this.mCameraPlayerEx.O00000Oo()) {
            gqg.O000000o((int) R.string.call_no_play);
            this.mCBVoiceLandscape.setChecked(false);
        } else if (!this.mCameraPlayerEx.O00000o0()) {
            if (!this.mCBMuteLandscape.isChecked()) {
                this.mCBMuteLandscape.setChecked(true);
            }
            chr.O0000Oo0();
            this.mCameraPlayerEx.O00000o();
        }
    }

    public /* synthetic */ void lambda$initView$15$CameraPlayerNewActivity(View view) {
        chr.O000000o(chr.O000oOoo);
        if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.RECORD_AUDIO")) {
            gqg.O000000o((int) R.string.audio_permission_denied);
        } else if (this.mCameraPlayerEx == null) {
        } else {
            if (!this.mCameraPlayerEx.O0000Ooo()) {
                gqg.O000000o((int) R.string.call_no_play);
            } else if (!this.mCameraPlayerEx.O00000Oo()) {
                gqg.O000000o((int) R.string.call_no_play);
            } else if (this.mCameraDevice.isReadOnlyShared()) {
                gqg.O000000o((int) R.string.auth_fail_read_only);
            } else {
                if (!this.mCDCToggleAudio.isChecked()) {
                    this.mCDCToggleAudio.setChecked(true);
                }
                if (!this.mCameraPlayerEx.O00000o0()) {
                    chr.O000000o("call");
                    this.mCameraPlayerEx.O00000o();
                    this.mMSTVVoice.setCurrentState(1);
                    startCallAnim();
                    chr.O0000Oo0();
                }
            }
        }
    }

    public /* synthetic */ void lambda$initView$16$CameraPlayerNewActivity(View view) {
        this.mCDCToggleAudio.setEnabled(true);
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O00000oO();
            this.mHandler.removeMessages(2101);
            if (this.mCDCToggleAudio.isChecked()) {
                this.mCDCToggleAudio.setChecked(false);
            }
            this.mMSTVVoice.setCurrentState(0);
            gqg.O000000o((int) R.string.stop_voice);
            chr.O0000Oo();
            stopCallAnim();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public /* synthetic */ boolean lambda$initView$17$CameraPlayerNewActivity(View view, MotionEvent motionEvent) {
        if (this.mCameraDevice.O000000o().O000000o("power", true)) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
        }
        return true;
    }

    public /* synthetic */ void lambda$initView$18$CameraPlayerNewActivity(CompoundButton compoundButton, boolean z) {
        if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O00000o0()) {
            this.mCBMuteLandscape.setChecked(z);
            chr.O000000o(chr.O000oO00);
            if (this.mCameraPlayerEx != null) {
                if (z) {
                    this.mCameraPlayerEx.O00000o0(false);
                } else {
                    this.mCameraPlayerEx.O00000o0(true);
                }
            }
            dismissBottomCtrlVisibilityGoneRunnable(5000);
            return;
        }
        this.mCDCToggleAudio.setChecked(!z);
        canStepOut();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    public /* synthetic */ void lambda$initView$20$CameraPlayerNewActivity(View view) {
        chr.O000000o(chr.O000oo);
        if (this.mCameraDevice.isReadOnlyShared()) {
            gqg.O000000o((int) R.string.auth_fail_read_only);
            return;
        }
        if (gpy.O00000o0((Context) this, this.md5Name, "NEED_SHOW_SLEEP_DIALOG", true)) {
            setSleepOff();
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            if (DeviceConstant.isSupportWuliZhebi(this.mCameraDevice.getModel())) {
                builder.O000000o((int) R.string.camera_setting_wulizhebi_title);
            } else {
                builder.O000000o((int) R.string.home_sleep_off_title);
            }
            builder.O00000Oo((int) R.string.home_sleep_off_subtitle);
            builder.O000000o(false);
            builder.O000000o((int) R.string.home_sleep_off, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$RQgiO_26PM5jQ9oR9boBfoxKPE */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    CameraPlayerNewActivity.this.lambda$null$19$CameraPlayerNewActivity(dialogInterface, i);
                }
            });
            builder.O00000oo();
            gpy.O000000o((Context) this, this.md5Name, "NEED_SHOW_SLEEP_DIALOG", false);
        } else {
            setSleepOff();
        }
        dismissBottomCtrlVisibilityGoneRunnable(5000);
    }

    public /* synthetic */ void lambda$null$19$CameraPlayerNewActivity(DialogInterface dialogInterface, int i) {
        if (!isFinishing()) {
            dialogInterface.dismiss();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity$18]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void */
    public /* synthetic */ void lambda$initView$21$CameraPlayerNewActivity(View view) {
        chr.O000000o(chr.O000oo);
        if (this.mCameraDevice.isReadOnlyShared()) {
            gqg.O000000o((int) R.string.auth_fail_read_only);
            return;
        }
        if (this.mCameraSpecDevice != null) {
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o("camera-control");
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "on");
            if (!(O000000o2 == null || O000000o3 == null)) {
                faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Boolean.TRUE, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass17 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!CameraPlayerNewActivity.this.isFinishing()) {
                            CameraPlayerNewActivity.this.mCdcToggleSleep.setCurrentState(0);
                            CameraPlayerNewActivity.this.mCameraDevice.O000000o().O00000Oo("power", Boolean.TRUE);
                            cki.O00000o("CameraPlayerNewActivity", "set sleep success");
                            CameraPlayerNewActivity.this.refreshUI();
                        }
                    }

                    public void onFailure(fso fso) {
                        if (!CameraPlayerNewActivity.this.isFinishing()) {
                            CameraPlayerNewActivity.this.mCdcToggleSleep.setCurrentState(1);
                            CameraPlayerNewActivity.this.getContext();
                            gqg.O000000o((int) R.string.action_fail);
                            CameraPlayerNewActivity.this.refreshUI();
                            if (fso != null) {
                                cki.O00000o("CameraPlayerNewActivity", "set sleep failed:" + fso.f17063O000000o + " s:" + fso.O00000Oo);
                            }
                        }
                    }
                });
            }
        } else if (!(this.mCameraDevice == null || this.mCameraDevice.O000000o() == null)) {
            this.mCameraDevice.O000000o().O000000o("power", true, (Callback<Void>) new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass18 */

                public void onSuccess(Void voidR) {
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        CameraPlayerNewActivity.this.mCdcToggleSleep.setCurrentState(0);
                        CameraPlayerNewActivity.this.mCameraDevice.O00000Oo().O000000o("power");
                        cki.O00000o("CameraPlayerNewActivity", "set sleep success");
                    }
                }

                public void onFailure(int i, String str) {
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        CameraPlayerNewActivity.this.mCdcToggleSleep.setCurrentState(1);
                        CameraPlayerNewActivity.this.getContext();
                        gqg.O000000o((int) R.string.action_fail);
                        cki.O00000o("CameraPlayerNewActivity", "set sleep failed:" + i + " s:" + str);
                    }
                }
            });
        }
        dismissBottomCtrlVisibilityGoneRunnable(5000);
    }

    public /* synthetic */ void lambda$initView$22$CameraPlayerNewActivity(DirectPushItemView directPushItemView, View view) {
        this.mVideoViewFrame.removeView(directPushItemView);
    }

    public /* synthetic */ void lambda$initView$23$CameraPlayerNewActivity(DirectPushItemView directPushItemView, View view) {
        fbt fbt = new fbt(this, "RNSecuritySettingActivity");
        fbt.O000000o("extra_device_did", this.mCameraDevice.getDid());
        fbt.O000000o("xiaomi.smarthome.custom_hint", "");
        fbs.O000000o(fbt);
        this.mVideoViewFrame.removeView(directPushItemView);
    }

    private boolean needShowFaceInfo() {
        return TextUtils.equals(this.mCameraDevice.getModel(), "chuangmi.camera.ipc022") && CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && !this.mCameraDevice.isShared();
    }

    public void resetLeftTopTools() {
        this.video_scale_tv.setVisibility(8);
        this.mLLFuncPopup.clearAnimation();
        this.mLLFuncPopup.setVisibility(8);
    }

    private void showPowerOffView() {
        if (this.mPowerOffView.getVisibility() == 8) {
            this.mPowerOffView.setVisibility(0);
        }
        onShowError(true);
    }

    private void hidePowerOffView() {
        if (this.mPowerOffView.getVisibility() == 0) {
            this.mPowerOffView.setVisibility(8);
        }
        onHidError();
    }

    public void onHidError() {
        gsy.O00000Oo("CameraPlayerNewActivity", "onHidError");
        if (this.isFirstFrameShowed) {
            onMinScaleChanged(this.isMinScale);
        }
        enabledBtns(false, true);
        if (this.mCDCToggleAudio.isChecked()) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass19 */

                public void run() {
                    CameraPlayerNewActivity.this.mCameraPlayerEx.O00000o0(false);
                }
            }, 500);
        }
    }

    public void onShowError(boolean z) {
        gsy.O00000Oo("CameraPlayerNewActivity", "onShowError");
        onMinScaleChanged(true);
        this.flTitleBar.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        this.flTitleBar.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        enabledBtns(z, false);
    }

    public void enabledBtns(boolean z, boolean z2) {
        if (z2 || !z) {
            this.mCdcToggleSleep.setEnabled(z2);
        }
        this.mCDCToggleAudio.setEnabled(z2);
        this.mTVSResolution.setEnabled(z2);
        this.ivFullScreen.setEnabled(z2);
        this.mMSTVVoice.setEnabled(z2);
        this.ivCameraShot.setEnabled(z2);
        this.mCDCCameraRecord.setEnabled(z2);
    }

    public void disableRecord() {
        this.mCdcToggleSleep.setEnabled(false);
        this.mTVSResolution.setEnabled(false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity$21]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void */
    private void setSleepOff() {
        if (this.mCameraSpecDevice != null) {
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o("camera-control");
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "on");
            if (O000000o2 != null && O000000o3 != null) {
                faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Boolean.FALSE, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass20 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!CameraPlayerNewActivity.this.isFinishing()) {
                            CameraPlayerNewActivity.this.mCdcToggleSleep.setCurrentState(1);
                            CameraPlayerNewActivity.this.mCameraDevice.O000000o().O00000Oo("power", Boolean.FALSE);
                            cki.O00000o("CameraPlayerNewActivity", "set sleep success");
                            CameraPlayerNewActivity.this.closePanoram();
                            CameraPlayerNewActivity.this.refreshUI();
                        }
                    }

                    public void onFailure(fso fso) {
                        if (!CameraPlayerNewActivity.this.isFinishing()) {
                            CameraPlayerNewActivity.this.mCdcToggleSleep.setCurrentState(0);
                            CameraPlayerNewActivity.this.getContext();
                            gqg.O000000o((int) R.string.action_fail);
                            if (fso != null) {
                                cki.O00000o("CameraPlayerNewActivity", "set sleep failed:" + fso.f17063O000000o + " s:" + fso.O00000Oo);
                            }
                            CameraPlayerNewActivity.this.refreshUI();
                        }
                    }
                });
            }
        } else if (this.mCameraDevice != null && this.mCameraDevice.O000000o() != null) {
            this.mCameraDevice.O000000o().O000000o("power", false, (Callback<Void>) new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass21 */

                public void onSuccess(Void voidR) {
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        CameraPlayerNewActivity.this.mCdcToggleSleep.setCurrentState(1);
                        CameraPlayerNewActivity.this.mCameraDevice.O00000Oo().O000000o("power");
                        cki.O00000o("CameraPlayerNewActivity", "set sleep success");
                    }
                }

                public void onFailure(int i, String str) {
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        CameraPlayerNewActivity.this.mCdcToggleSleep.setCurrentState(0);
                        CameraPlayerNewActivity.this.getContext();
                        gqg.O000000o((int) R.string.action_fail);
                        cki.O00000o("CameraPlayerNewActivity", "set sleep failed:" + i + " s:" + str);
                    }
                }
            });
        }
    }

    private boolean isShowFace() {
        if (this.mDeviceStat == null || TextUtils.isEmpty(this.mDeviceStat.model) || !CoreApi.O000000o().O0000O0o() || ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            return false;
        }
        if ("chuangmi.camera.ipc009".equals(this.mDeviceStat.model)) {
            clf.O00000Oo(clf.O000000o(this.mCameraDevice.O00000o0(), "3.4.2_0200"));
            return clf.O00000oO();
        } else if ("chuangmi.camera.ipc019".equals(this.mDeviceStat.model) || DeviceConstant.isNewChuangmi(this.mCameraDevice.getModel())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean useNewAlarmUI() {
        boolean z = false;
        if (this.mDeviceStat == null || TextUtils.isEmpty(this.mDeviceStat.model)) {
            return false;
        }
        if (!"chuangmi.camera.ipc009".equals(this.mDeviceStat.model) || clf.O000000o(this.mCameraDevice.O00000o0(), "3.4.2_0200")) {
            z = true;
        }
        clf.O00000Oo(z);
        return clf.O00000oO();
    }

    public boolean canStepOut() {
        return canStepOut(0, 0);
    }

    public boolean canStepOut(int i, int i2) {
        if (this.mCameraPlayerEx != null) {
            if (this.mCameraPlayerEx.O00000oo() || this.mCameraPlayerEx.O00000o0()) {
                if (i > 0) {
                    gqg.O000000o(i, 1);
                } else {
                    gqg.O000000o((int) R.string.speaking_block, 1);
                }
                return false;
            } else if (this.mCameraPlayerEx.O0000O0o()) {
                if (i2 > 0) {
                    gqg.O000000o(i2, 1);
                } else {
                    gqg.O000000o((int) R.string.recording_block, 1);
                }
                return false;
            }
        }
        return true;
    }

    public void setPlayTime(long j) {
        setPlayTime(j, true);
    }

    public void setPlayTime(long j, boolean z) {
        int i;
        int i2;
        int i3;
        gsy.O00000Oo("CameraPlayerNewActivity", "setPlayTime setPlayTime setPlayTime");
        TimeItem O000000o2 = this.mCameraDevice.O0000OOo().O000000o(j);
        if (this.mCameraDevice.O0000Oo0() != null && this.mCameraDevice.O00000o()) {
            O000000o2 = this.mCameraDevice.O0000Oo0().O000000o(j);
        }
        boolean z2 = true;
        if (O000000o2 != null) {
            gsy.O00000Oo("CameraPlayerNewActivity", "last set time before " + mi.O00000Oo(j));
            i2 = (int) (O000000o2.f5243O000000o / 1000);
            i = O000000o2.f5243O000000o < j ? ((int) (j - O000000o2.f5243O000000o)) / 1000 : 0;
            gsy.O00000Oo("CameraPlayerNewActivity", "last set time after  " + mi.O00000Oo(O000000o2.f5243O000000o + ((long) (i * 1000))));
            this.mIsSetPlayTime = true;
            this.mSelectTime = (long) (i2 + i);
            this.mLastSetStart = i2;
        } else {
            gsy.O00000Oo("CameraPlayerNewActivity", "last set time alive");
            runMainThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$4walP6mlzihmzp4iKiilAhFg1s */

                public final void run() {
                    CameraPlayerNewActivity.this.lambda$setPlayTime$24$CameraPlayerNewActivity();
                }
            });
            this.mHandler.removeMessages(2);
            this.mNeedCheckAlive = true;
            this.mIsSetPlayTime = false;
            if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O00000Oo() || this.mCameraPlayerEx.O0000o00()) {
                i3 = 0;
            } else {
                i3 = 0;
                z2 = false;
            }
            i2 = 0;
        }
        if (!this.mIsUserPause && z2) {
            showLoading("");
        }
        this.mLastSetPlayTime = System.currentTimeMillis();
        if (this.mCameraPlayerEx != null && (!this.mCameraPlayerEx.O0000o00() || !z)) {
            this.mCameraPlayerEx.O000000o(i2, i, 0, null);
        }
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 3000);
    }

    public /* synthetic */ void lambda$setPlayTime$24$CameraPlayerNewActivity() {
        this.mCDCToggleAudio.setEnabled(true);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        gsy.O00000Oo("CameraPlayerNewActivity", "newConfig.orientation:" + configuration.orientation);
        setWindow(configuration);
        if (this.mIsResumed) {
            this.video_scale_tv.setVisibility(8);
            this.mDcvDirectionCtrl.myConfigurationChanged(this.mFullScreen ? 2 : 1);
            this.mDcvDirectionCtrlLandscape.myConfigurationChanged(this.mFullScreen ? 2 : 1);
            if (this.mFullScreen) {
                this.mTVRecordTimer.setVisibility(8);
                if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000O0o()) {
                    this.tvRecordTimerLand.setVisibility(8);
                } else {
                    this.tvRecordTimerLand.setVisibility(0);
                }
                if (this.mVideoViewFrame != null) {
                    ViewGroup.LayoutParams layoutParams = this.mVideoViewFrame.getLayoutParams();
                    layoutParams.height = -1;
                    layoutParams.width = -1;
                    this.mVideoViewFrame.setLayoutParams(layoutParams);
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mask_bg.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                this.mask_bg.setLayoutParams(layoutParams2);
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mErrorRetryView.getLayoutParams();
                layoutParams3.bottomMargin = 0;
                layoutParams3.topMargin = 0;
                this.mErrorRetryView.setLayoutParams(layoutParams3);
                this.flTitleBar.setVisibility(8);
                this.mLLVideoViewBottomCtrl.setVisibility(8);
                this.mHandler.removeCallbacks(this.bottomCtrlVisibilityGoneRunnable);
                this.mRLDirectionCtl.setVisibility(8);
                this.mRLParent.setBackgroundColor(-16777216);
                this.dcvDirectionCtrlLandscapeContainer.setVisibility(0);
                this.mLLRightCtrlLandscape.setVisibility(0);
                this.mVideoView.O000000o(true);
                this.mAVCamera.setVisibility(8);
                int O000000o2 = ckq.O000000o(this);
                this.flTopCtrlLandscape.setPadding(O000000o2, 0, O000000o2, 0);
                this.dcvDirectionCtrlLandscapeContainer.setPadding(O000000o2, 0, O000000o2, 0);
                this.mLLRightCtrlLandscape.setPadding(O000000o2, 0, O000000o2, 0);
                findViewById(R.id.zhanwei_direction).setPadding(O000000o2, 0, 0, 0);
                if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O00000Oo()) {
                    this.dcvDirectionCtrlLandscapeContainer.setVisibility(8);
                } else {
                    this.dcvDirectionCtrlLandscapeContainer.setVisibility(0);
                }
                if (this.mMSTVVoice.getCurrentState() == 1) {
                    this.mCBVoiceLandscape.setChecked(true);
                } else {
                    this.mCBVoiceLandscape.setChecked(false);
                }
            } else {
                try {
                    if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000O0o()) {
                        this.mTVRecordTimer.setVisibility(8);
                    } else {
                        this.mTVRecordTimer.setVisibility(0);
                    }
                    this.tvRecordTimerLand.setVisibility(8);
                    if (this.mVideoViewFrame != null) {
                        ViewGroup.LayoutParams layoutParams4 = this.mVideoViewFrame.getLayoutParams();
                        if (this.h_w_ratio != 0.0f) {
                            this.currentVideoHeight = (int) (((float) getScreenWidth()) * this.h_w_ratio);
                        }
                        if (this.currentVideoHeight <= 0) {
                            layoutParams4.height = this.height_16_9 + (this.titleBarHeight * 2);
                        } else {
                            layoutParams4.height = this.currentVideoHeight + (this.titleBarHeight * 2);
                        }
                        layoutParams4.width = -1;
                        this.mVideoViewFrame.setLayoutParams(layoutParams4);
                    }
                    FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.mask_bg.getLayoutParams();
                    layoutParams5.width = -1;
                    layoutParams5.height = this.height_16_9 + this.titleBarHeight;
                    this.mask_bg.setLayoutParams(layoutParams5);
                    FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.mErrorRetryView.getLayoutParams();
                    layoutParams6.bottomMargin = this.titleBarHeight;
                    layoutParams6.topMargin = this.titleBarHeight;
                    this.mErrorRetryView.setLayoutParams(layoutParams6);
                    this.flTitleBar.setVisibility(0);
                    this.mLLVideoViewBottomCtrl.setVisibility(0);
                    this.mHandler.postDelayed(this.bottomCtrlVisibilityGoneRunnable, 5000);
                    this.mRLDirectionCtl.setVisibility(0);
                    this.mRLParent.setBackgroundColor(-1);
                    this.dcvDirectionCtrlLandscapeContainer.setVisibility(8);
                    this.mLLRightCtrlLandscape.setVisibility(8);
                    this.mLandLayout.setVisibility(8);
                    this.mVideoView.O000000o(false);
                    this.flTopCtrlLandscape.setPadding(0, 0, 0, 0);
                    this.dcvDirectionCtrlLandscapeContainer.setPadding(0, 0, 0, 0);
                    this.mLLRightCtrlLandscape.setPadding(0, 0, 0, 0);
                    findViewById(R.id.zhanwei_direction).setVisibility(8);
                    if (this.mCBVoiceLandscape.isChecked()) {
                        this.mMSTVVoice.setCurrentState(1);
                        startCallAnim();
                    } else {
                        this.mMSTVVoice.setCurrentState(0);
                        stopCallAnim();
                    }
                } catch (Exception e) {
                    gsy.O000000o(6, "CameraPlayerNewActivity", "onConfigurationChanged:" + e.getLocalizedMessage());
                }
            }
            resetShotPicPos();
            hyy.O000000o((Activity) getContext(), this.mFullScreen);
            if (this.mFullScreen) {
                hideStatusBar();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    private void resetShotPicPos() {
        if (this.mFullScreen) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mLLFuncPopup.getLayoutParams();
            layoutParams.topMargin = cin.O000000o((Context) this, 70.0f);
            layoutParams.leftMargin = cin.O000000o((Context) this, 35.0f);
            this.mLLFuncPopup.setLayoutParams(layoutParams);
            this.mLLFuncPopup.clearAnimation();
            this.mLLFuncPopup.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mLLFuncPopup.getLayoutParams();
        layoutParams2.topMargin = this.titleBarHeight + cin.O000000o((Context) this, 25.0f);
        layoutParams2.leftMargin = cin.O000000o((Context) this, 25.0f);
        this.mLLFuncPopup.setLayoutParams(layoutParams2);
        this.mLLFuncPopup.clearAnimation();
        this.mLLFuncPopup.setVisibility(8);
    }

    private void toDetectSpecSDCard() {
        loadPropertiesFromCache();
        detectSpecSDCard();
        cki.O00000o0("CameraPlayerNewActivity", "start toDetectSpecSDCard");
        loadPropertiesFromServer(SpecConstantUtils.MCMSpecKV(null), new Callback<List<PropertyParam>>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass22 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<PropertyParam>) ((List) obj));
            }

            public void onSuccess(List<PropertyParam> list) {
                if (!CameraPlayerNewActivity.this.isFinishing()) {
                    cki.O00000o0("CameraPlayerNewActivity", "toDetectSpecSDCard onSuccess");
                    CameraPlayerNewActivity.this.loadPropertiesFromCache();
                    CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                    cameraPlayerNewActivity.isPowerCheck = true;
                    cameraPlayerNewActivity.refreshUI();
                    CameraPlayerNewActivity.this.mCameraDevice.O000000o(XmPluginHostApi.instance().isUsrExpPlanEnabled(CameraPlayerNewActivity.this.mCameraDevice.getDid()));
                    CameraPlayerNewActivity.this.detectSpecSDCard();
                }
            }

            public void onFailure(int i, String str) {
                if (!CameraPlayerNewActivity.this.isFinishing()) {
                    cki.O00000o0("CameraPlayerNewActivity", "toDetectSpecSDCard onFailure (" + i + ")" + str);
                    CameraPlayerNewActivity.this.loadPropertiesFromCache();
                }
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
    public void onSnapBabySleep(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis - this.snapBabySleepTime >= 120000) {
            this.snapBabySleepTime = currentTimeMillis;
            cki.O00000o0("CameraPlayerNewActivity", "onSnapBabySleep");
            if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                cki.O00000o0("CameraPlayerNewActivity", "onSnapBabySleep return isPowerOff");
            } else {
                this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$HmN4RiUe6pkpnIoT354qmz_Nos */

                    public final void onSnap(Bitmap bitmap) {
                        CameraPlayerNewActivity.this.lambda$onSnapBabySleep$25$CameraPlayerNewActivity(bitmap);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onSnapBabySleep$25$CameraPlayerNewActivity(Bitmap bitmap) {
        if (bitmap != null) {
            if ("cn".equalsIgnoreCase(ftl.O000000o())) {
                bitmap = C0118cif.O000000o(bitmap, this);
            }
            File file = chq.O00000o0;
            String O000000o2 = me.O000000o("SETTINGS_BABY_SLEEP_IMG_" + this.mCameraDevice.getDid(), this.mCameraDevice.getDid());
            if (O000000o2 != null) {
                File file2 = new File(O000000o2);
                if (file2.exists()) {
                    file2.delete();
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(O000000o2);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                    bitmap.recycle();
                } catch (IOException unused) {
                }
            }
        }
    }

    private void initAiSettings() {
        if (DeviceConstant.isSupportNewUI(this.mCameraDevice.getModel()) && CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.faceManager = true;
            this.face = true;
        }
        if ((DeviceConstant.isSupportBabyCryNative(this.mCameraDevice.getModel()) || this.mCameraDevice.O00000oO().O00000Oo()) && (!"chuangmi.camera.021a04".equals(this.mCameraDevice.getModel()) || !"IN".equalsIgnoreCase(ftl.O000000o()))) {
            this.babycry = true;
        }
        if (!this.babycry) {
            clf.f14036O000000o = false;
        }
        if (!this.mCameraDevice.O00000oO().O00000Oo() && !DeviceConstant.isSupportFaceNative(this.mCameraDevice.getModel())) {
            this.face = false;
        }
        if (DeviceConstant.isSupportPetNative(this.mCameraDevice.getModel())) {
            this.pet = true;
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
            if (view.getId() == R.id.iv_preset_edit) {
                if (this.mCameraDevice.isReadOnlyShared()) {
                    gqg.O000000o((int) R.string.cloud_share_hint);
                } else if (this.mCameraDevice.O000000o().O000000o("power", true)) {
                    boolean isSelected = this.iv_preset_edit.isSelected();
                    for (int i = 0; i < this.positions.size(); i++) {
                        PreSetPositionView preSetPositionView = (PreSetPositionView) this.ll_yuzhiwei.getChildAt(i);
                        preSetPositionView.setEditEnable(!preSetPositionView.editEnable);
                        isSelected = preSetPositionView.editEnable;
                    }
                    if (this.ll_yuzhiwei.getVisibility() != 0) {
                        isSelected = !isSelected;
                    }
                    this.iv_preset_edit.setSelected(isSelected);
                    if (this.iv_panoramic_mask.getVisibility() != 0) {
                        return;
                    }
                    if (isSelected) {
                        this.iv_panoramic_edit.setVisibility(0);
                    } else {
                        this.iv_panoramic_edit.setVisibility(4);
                    }
                } else if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
                    gqg.O00000Oo((int) R.string.camera_closed_wulizhebi_tip);
                } else {
                    gqg.O00000Oo((int) R.string.power_off);
                }
            } else if (view.getId() == R.id.title_bar_more) {
                onSnapBabySleep(true);
                chr.O000000o(chr.O000ooOo);
                if (canStepOut()) {
                    chr.O000000o(chr.O0000Oo);
                    ArrayList arrayList = new ArrayList();
                    IXmPluginHostActivity.IntentMenuItem intentMenuItem = new IXmPluginHostActivity.IntentMenuItem();
                    intentMenuItem.name = getString(R.string.more_camera_setting);
                    intentMenuItem.intent = new Intent(this, MoreCameraSettingActivity.class);
                    intentMenuItem.intent.putExtra("extra_device_did", this.mDid);
                    intentMenuItem.intent.putExtra("is_v4", this.isV4);
                    arrayList.add(intentMenuItem);
                    IXmPluginHostActivity.IntentMenuItem intentMenuItem2 = new IXmPluginHostActivity.IntentMenuItem();
                    intentMenuItem2.name = getString(R.string.more_alarm_setting_v4);
                    clf.O00000Oo();
                    if (clf.O00000oO()) {
                        intentMenuItem2.intent = new Intent(this, AlarmSettingV2Activity.class);
                    } else {
                        intentMenuItem2.intent = new Intent(this, AlarmSettingActivity.class);
                    }
                    intentMenuItem2.intent.putExtra("extra_device_did", this.mDid);
                    intentMenuItem2.intent.putExtra("is_v4", this.isV4);
                    arrayList.add(intentMenuItem2);
                    IXmPluginHostActivity.IntentMenuItem intentMenuItem3 = new IXmPluginHostActivity.IntentMenuItem();
                    intentMenuItem3.name = getString(R.string.more_store_setting);
                    intentMenuItem3.intent = new Intent();
                    intentMenuItem3.intent.setClass(this, FileManagerSettingActivity.class);
                    intentMenuItem3.intent.putExtra("extra_device_did", this.mDid);
                    intentMenuItem3.intent.putExtra("is_v4", this.isV4);
                    arrayList.add(intentMenuItem3);
                    IXmPluginHostActivity.IntentMenuItem intentMenuItem4 = new IXmPluginHostActivity.IntentMenuItem();
                    intentMenuItem4.name = getString(R.string.album);
                    intentMenuItem4.intent = new Intent(this, AlbumActivity.class);
                    intentMenuItem4.intent.putExtra("extra_device_did", this.mDid);
                    arrayList.add(intentMenuItem4);
                    if ((isShowFace() || DeviceConstant.isNewChuangmi(this.mCameraDevice.getModel())) && !this.mCameraDevice.isReadOnlyShared() && (this.faceManager || this.face || this.babycry || this.pet)) {
                        IXmPluginHostActivity.IntentMenuItem intentMenuItem5 = new IXmPluginHostActivity.IntentMenuItem();
                        intentMenuItem5.name = getString(R.string.face_ai_setting);
                        intentMenuItem5.intent = new Intent(this, AlarmAISwitchActivity.class);
                        intentMenuItem5.intent.putExtra("extra_device_did", this.mDid);
                        arrayList.add(intentMenuItem5);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("security_setting_enable", true);
                    intent.putExtra("auto_dissmiss", false);
                    if (!this.mCameraDevice.isShared()) {
                        clf.O00000Oo();
                        if (cih.O000000o() && clf.O00000oO()) {
                            intent.putExtra("cloud_storage", true);
                            intent.putExtra("title", this.mCameraDevice.getName());
                        }
                    }
                    LocalLicenseUtil.LocalLicense v4LocalLicense = LocalLicenseUtil.getV4LocalLicense(getResources(), this.mCameraDevice.getModel());
                    Intent intent2 = new Intent();
                    if (v4LocalLicense.mLicense > 0 && v4LocalLicense.mPrivacy > 0) {
                        intent2.putExtra("enableRemoveLicense", true);
                        intent2.putExtra("licenseContentHtmlRes", v4LocalLicense.mLicense);
                        intent2.putExtra("privacyContentHtmlRes", v4LocalLicense.mPrivacy);
                    }
                    if (!"cn".equalsIgnoreCase(ftl.O000000o()) || TextUtils.isEmpty(v4LocalLicense.mPlan)) {
                        intent2.putExtra("enable_privacy_setting", false);
                    } else {
                        intent2.putExtra("enable_privacy_setting", true);
                        intent2.putExtra("usrExpPlanContent", Html.fromHtml(v4LocalLicense.mPlan));
                    }
                    CameraJumpUtils.openMoreMenu2(this, this.mCameraDevice.getDid(), arrayList, true, 1220, intent, intent2);
                    this.mNewFirmView.setVisibility(8);
                }
            } else if (view.getId() == R.id.title_bar_share) {
                if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                    gqg.O000000o((int) R.string.power_off_share);
                } else if (canStepOut()) {
                    this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$zzZWuDFI5fJcAv9WA1R7khOcxTI */

                        public final void onSnap(Bitmap bitmap) {
                            CameraPlayerNewActivity.this.lambda$onClick$26$CameraPlayerNewActivity(bitmap);
                        }
                    });
                }
            } else if (view.getId() == R.id.tvPIP) {
                gsy.O00000Oo("CameraPlayerNewActivity", "tvPIP click");
                if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                    CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
                } else if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    chr.O000000o(chr.O0000o00);
                    chr.O000000o(chr.O000ooO);
                    if (mk.O000000o(this)) {
                        XmPluginHostApi.instance().openCameraFloatingWindow(this.mCameraDevice.getDid());
                        MoreDialog moreDialog2 = this.moreDialog;
                        if (moreDialog2 != null) {
                            moreDialog2.dismiss();
                        }
                        finish();
                        return;
                    }
                    gqg.O000000o(getResources().getString(R.string.float_tip));
                }
            } else if (view.getId() == R.id.tvsResolution || view.getId() == R.id.tvsResolution_land) {
                gsy.O00000Oo("CameraPlayerNewActivity", "tvsResolution click");
                if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                    CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
                    return;
                }
                if (this.mCameraPlayerEx == null || this.mCameraPlayerEx.O00000Oo()) {
                    toggleResolution();
                } else {
                    toggleSpeed();
                }
                dismissBottomCtrlVisibilityGoneRunnable(5000);
            } else if (view.getId() == R.id.ivFullScreen) {
                if (!this.isConnected) {
                    activity();
                    gqg.O000000o((int) R.string.no_playback_for_connect2);
                    return;
                }
                gsy.O00000Oo("CameraPlayerNewActivity", "ivFullScreen click");
                enterPadFullScreen();
                setOrientation(0);
                chr.O000000o(chr.O000oOOO);
            } else if (view.getId() == R.id.alarm_new || view.getId() == R.id.tvAlarm) {
                gsy.O00000Oo("CameraPlayerNewActivity", "tvAlarm click");
                chr.O0000o0O();
                chr.O000000o(chr.O000oOo);
                if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    setFloatingUIGone();
                    if (this.mCameraDevice.O00000oO().O0000O0o && !this.mCameraDevice.isReadOnlyShared()) {
                        Intent intent3 = new Intent(this, AlarmGuideActivity.class);
                        if (useNewAlarmUI()) {
                            intent3.putExtra("useNewAlarmVideo", true);
                        }
                        startActivity(intent3);
                        overridePendingTransition(0, 0);
                    } else if (!useNewAlarmUI()) {
                        startActivity(new Intent(this, AlarmActivity.class));
                        overridePendingTransition(0, 0);
                    } else if (!DeviceConstant.isSupportNewAlarm(this.mCameraDevice.getModel()) || ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                        startActivity(new Intent(this, AlarmVideoActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        startActivity(new Intent(this, AlarmVideoActivityNew.class));
                        overridePendingTransition(0, 0);
                    }
                }
            } else if (view.getId() == R.id.playback_new || view.getId() == R.id.tvStorage) {
                chr.O0000o0o();
                chr.O000000o(chr.O000oOoO);
                if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                    CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
                } else if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    setFloatingUIGone();
                    LogType logType = LogType.CAMERA;
                    String model = this.mCameraDevice.getModel();
                    gsy.O00000o0(logType, model, "CameraPlayerNewActivity", "onclick playback sdcardGetSuccess=" + this.mSdcardDetectResult.sdcardGetSuccess);
                    if (!this.mSdcardDetectResult.sdcardGetSuccess) {
                        detectSDCard();
                    }
                    if (isSupportNewPlayback()) {
                        Intent intent4 = new Intent(this, SDCardCloudVideoActivity.class);
                        intent4.putExtra("sdcardGetSuccess", this.mSdcardDetectResult.sdcardGetSuccess);
                        intent4.putExtra("sdcardStatus", this.mSdcardDetectResult.sdcardStatus);
                        startActivity(intent4);
                    } else if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O0000Ooo()) {
                        activity();
                        gqg.O000000o((int) R.string.no_playback_for_connect);
                    } else if (!this.mSdcardDetectResult.sdcardGetSuccess) {
                        activity();
                        gqg.O000000o((int) R.string.sd_card_hint_title);
                    } else if (this.mSdcardDetectResult.sdcardStatus == 4) {
                        gqg.O000000o(getString(R.string.camera_storage_sdcard_formating_tips));
                    } else if (this.mSdcardDetectResult.sdcardStatus == 3) {
                        startActivity(new Intent(this, SDCardStatusActivityNew.class));
                    } else if (this.mSdcardDetectResult.sdcardStatus == 1 || this.mSdcardDetectResult.sdcardStatus == 5) {
                        startActivity(new Intent(this, NoMemoryCardActivity.class));
                    } else {
                        startActivity(new Intent(this, SDCardTimeLinePlayerExActivity.class));
                    }
                }
            } else if (view.getId() == R.id.cbShortLandscape || view.getId() == R.id.ivCameraShot) {
                gsy.O00000Oo("CameraPlayerNewActivity", "ivCameraShot click");
                chr.O000000o(chr.O00000o0);
                chr.O000000o(chr.O000oO0);
                snapShot();
            } else if (view.getId() == R.id.tvMore) {
                gsy.O00000Oo("CameraPlayerNewActivity", "tvMore click");
                chr.O000000o(chr.O00000Oo);
                chr.O000000o(chr.O000oo0o);
                if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    if (!isShowFace()) {
                        chr.O000000o(chr.O000oo0o);
                        popupMoreDialog();
                        return;
                    }
                    chr.O000000o(chr.O000oo0O);
                    if (this.mCameraDevice.isShared()) {
                        gqg.O000000o(getString(R.string.no_permit_for_face_tips));
                    } else if (!this.mCameraDevice.O00000oO().O00000Oo()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("is_vip_user", false);
                            jSONObject.put("is_from_camera", true);
                            if (this.mCameraDevice != null && DeviceConstant.isSupportFaceNative(this.mCameraDevice.getModel())) {
                                jSONObject.put("is_using_service", true);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        fsp.O000000o().O0000Oo.openFaceManagerActivity(546, this, this.mCameraDevice.getDid(), jSONObject.toString());
                    } else {
                        fsp.O000000o().O0000Oo.openFaceManagerActivity(this, this.mCameraDevice.getDid());
                    }
                }
            } else if (view.getId() == R.id.mstvVoice) {
                gsy.O00000Oo("CameraPlayerNewActivity", "mstvVoice click");
            } else if (view.getId() == R.id.iv_back_landscape || view.getId() == R.id.tvExitFullScreen) {
                this.mAVCameraLandscape.setVisibility(8);
                exitFullScreen(null);
            } else if (view.getId() == R.id.tvCancel) {
                MoreDialog moreDialog3 = this.moreDialog;
                if (moreDialog3 != null) {
                    moreDialog3.dismiss();
                }
            } else if (view.getId() == R.id.tvAlbum2 || view.getId() == R.id.tvAlbum) {
                chr.O000000o(chr.O000ooOO);
                gsy.O00000Oo("CameraPlayerNewActivity", "R.id.tvAlbum");
                if (canStepOut()) {
                    startActivity(new Intent(this, AlbumActivity.class));
                }
            } else if (view.getId() == R.id.tvCalibration) {
                lambda$onActivityResult$34$CameraPlayerNewActivity();
            } else if (view.getId() == R.id.tvMotionTrack) {
                gsy.O00000Oo("CameraPlayerNewActivity", "R.id.tvMotionTrack");
            } else if (view.getId() == R.id.mstvSleep) {
                gsy.O00000Oo("CameraPlayerNewActivity", "R.id.mstvSleep:");
            } else if (view.getId() == R.id.face_info_new) {
                if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    AlarmAISwitchActivity.openFaceManagerActivity(this.mCameraDevice, this);
                }
            } else if (view.getId() == R.id.cloud_video_new || view.getId() == R.id.tvCloudVideo) {
                chr.O000000o(chr.O000oo0);
                if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
                    setFloatingUIGone();
                    if (clf.O00000oO() && cih.O000000o()) {
                        if (!this.mCameraDevice.isShared() || this.mCameraDevice.O00000oO().O00000Oo()) {
                            String O0000o0 = CoreApi.O000000o().O0000o0();
                            if (this.mCameraDevice.O00000oO().O00000Oo() || this.mCameraDevice.O00000oO().O000000o()) {
                                LogType logType2 = LogType.CAMERA;
                                String model2 = this.mCameraDevice.getModel();
                                gsy.O00000o0(logType2, model2, "CameraPlayerNewActivity", "openCloudVideoList did=" + this.mCameraDevice.getDid() + " uid=" + O0000o0 + " vip=" + this.mCameraDevice.O00000oO().O00000Oo() + " window=" + this.mCameraDevice.O00000oO().O000000o());
                                fsp.O000000o().O0000Oo.openCloudVideoListActivity(this, this.mCameraDevice.getDid(), this.mCameraDevice.getName());
                            } else {
                                LogType logType3 = LogType.CAMERA;
                                String model3 = this.mCameraDevice.getModel();
                                gsy.O00000o0(logType3, model3, "CameraPlayerNewActivity", "openCloudVideoBuyPage did=" + this.mCameraDevice.getDid() + " uid=" + O0000o0 + " vip=" + this.mCameraDevice.O00000oO().O00000Oo() + " window=" + this.mCameraDevice.O00000oO().O000000o());
                                CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(this, this.mCameraDevice.getDid());
                            }
                            this.mCameraDevice.O00000oO().O00000oo();
                            this.flCloudVideoTips.setVisibility(8);
                            return;
                        }
                        gqg.O000000o((int) R.string.cloud_share_hint);
                    }
                }
            } else if (view.getId() == R.id.fl_cloud_video_tips) {
                CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(this, this.mCameraDevice.getDid());
                this.mCameraDevice.O00000oO().O00000oo();
                this.flCloudVideoTips.setVisibility(8);
            } else if (view.getId() == R.id.iv_panoramic_close) {
                if (this.fl_panoramic.getVisibility() == 0) {
                    closePanoram();
                } else {
                    this.OnDirectionCtrlListener.onCenterClick();
                }
            } else if (view.getId() == R.id.iv_panoramic_edit) {
                if (this.mCameraPlayerEx == null) {
                    return;
                }
                if (!this.mCameraPlayerEx.O0000Ooo()) {
                    gqg.O000000o((int) R.string.panorama_no_play);
                } else if (!this.mIsResumed) {
                } else {
                    if (!isPanoramSupportDegree() || this.mCameraDevice == null) {
                        new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.panorama_retry_tips).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$Z1LsqYwH8pjjy10G0PmdLdtlD4E */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                CameraPlayerNewActivity.this.lambda$onClick$27$CameraPlayerNewActivity(dialogInterface, i);
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, $$Lambda$CameraPlayerNewActivity$8MC6he2mH4NQLhy0_okQVkCIeI.INSTANCE).O000000o(false).O00000o().show();
                    } else {
                        showChoosePanoramAngleDialog();
                    }
                }
            } else if (view.getId() == R.id.tv_panoramic_start && this.mCameraPlayerEx != null) {
                if (!this.mCameraPlayerEx.O0000Ooo()) {
                    gqg.O000000o((int) R.string.panorama_no_play);
                } else {
                    beginStartPanoramic();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    public /* synthetic */ void lambda$onClick$26$CameraPlayerNewActivity(Bitmap bitmap) {
        if (bitmap != null) {
            if ("cn".equalsIgnoreCase(ftl.O000000o())) {
                bitmap = C0118cif.O000000o(bitmap, this);
            }
            String O000000o2 = me.O000000o(false, this.mCameraDevice.getDid());
            if (O000000o2 != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(O000000o2);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                    bitmap.recycle();
                    CameraJumpUtils.openShareMediaActivity(getContext(), this.mDeviceStat.name, "", O000000o2);
                } catch (IOException unused) {
                }
            }
        }
    }

    public /* synthetic */ void lambda$onClick$27$CameraPlayerNewActivity(DialogInterface dialogInterface, int i) {
        startPanoramic("");
    }

    private void setFloatingUIGone() {
        dismissBottomCtrlVisibilityGoneRunnable(0);
        this.mHandler.removeCallbacks(this.angleViewVisibilityGoneRunnable);
        this.mAVCamera.setVisibility(8);
        this.mHandler.removeCallbacks(this.hideScaleTvR);
        this.mHandler.postDelayed(this.hideScaleTvR, 0);
    }

    public void closePanoram() {
        this.dcvDirectionCtrl_container.setVisibility(0);
        this.ll_yuzhiwei.setVisibility(8);
        this.iv_preset_edit.setVisibility(8);
        this.fl_panoramic.setVisibility(4);
        this.ll_panoramic_tip.setVisibility(0);
        this.ll_panoramic_doing.setVisibility(8);
        this.iv_panoramic.setVisibility(4);
        this.iv_panoramic_mask.setVisibility(4);
        this.iv_loading_panoramic.clearAnimation();
        this.mCameraDevice.O0000OoO().O0000OoO = true;
    }

    private boolean isPanoramSupportDegree() {
        if (this.mCameraDevice == null || !CoreApi.O000000o().O0000O0o() || ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            return false;
        }
        String O00000o0 = this.mCameraDevice.O00000o0();
        if (TextUtils.isEmpty(O00000o0)) {
            return false;
        }
        if (TextUtils.equals(this.mCameraDevice.getModel(), "chuangmi.camera.ip026c") && cin.O00000Oo(O00000o0, "4.0.6_0165") > 0) {
            return true;
        }
        if (!TextUtils.equals(this.mCameraDevice.getModel(), "chuangmi.camera.ip029a") || cin.O00000Oo(O00000o0, "4.0.8_0170") <= 0) {
            return (TextUtils.equals(this.mCameraDevice.getModel(), "chuangmi.camera.ipc021") && cin.O00000Oo(O00000o0, "4.0.9_0176") > 0) || TextUtils.equals(this.mCameraDevice.getModel(), "chuangmi.camera.021a04") || TextUtils.equals(this.mCameraDevice.getModel(), "chuangmi.camera.029a02") || TextUtils.equals(this.mCameraDevice.getModel(), "chuangmi.camera.ipc022") || TextUtils.equals(this.mCameraDevice.getModel(), "chuangmi.camera.026c02");
        }
        return true;
    }

    private boolean isSupportCenter(String str) {
        return DeviceConstant.isSupportCenter(str) && CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
    }

    private void beginStartPanoramic() {
        if (!isPanoramSupportDegree() || this.mCameraDevice == null) {
            startPanoramic("");
        } else {
            showChoosePanoramAngleDialog();
        }
    }

    private void showChoosePanoramAngleDialog() {
        PanoramicDialog.newInstance(this.mCameraDevice.getModel(), this.mSAnglePanorama).setClickListener(new PanoramicDialog.PanoramicClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$xiB9_KPTbStu33ysTVSxKDhw0A */

            public final void onClick(String str) {
                CameraPlayerNewActivity.this.lambda$showChoosePanoramAngleDialog$29$CameraPlayerNewActivity(str);
            }
        }).show(getSupportFragmentManager(), (String) null);
    }

    public /* synthetic */ void lambda$showChoosePanoramAngleDialog$29$CameraPlayerNewActivity(String str) {
        startPanoramic(str);
        if (!TextUtils.equals(str, this.mSAnglePanorama)) {
            setCameraPanoramCloudProps(str);
        }
    }

    private void startPanoramic(String str) {
        if (this.mCameraPlayerEx == null) {
            return;
        }
        if (!this.mCameraPlayerEx.O0000Ooo()) {
            gqg.O000000o((int) R.string.panorama_no_play);
            return;
        }
        this.iv_panoramic.setVisibility(4);
        this.iv_panoramic_mask.setVisibility(4);
        this.iv_panoramic_edit.setVisibility(4);
        this.ll_panoramic_tip.setVisibility(8);
        this.ll_panoramic_doing.setVisibility(0);
        this.iv_loading_panoramic.startAnimation(this.rotate);
        this.mCameraDevice.O0000Ooo().O000000o(new chz.O000000o(str) {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$i_iFBfYglw0edwTQtnQvqGMoBg */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onPositionReceived() {
                CameraPlayerNewActivity.this.lambda$startPanoramic$31$CameraPlayerNewActivity(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$startPanoramic$31$CameraPlayerNewActivity(String str) {
        this.mHandler.post(new Runnable(str) {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$8ikRfu88gsmIpGG_zn7jXeesOoM */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CameraPlayerNewActivity.this.lambda$null$30$CameraPlayerNewActivity(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$null$30$CameraPlayerNewActivity(final String str) {
        cht O0000OoO = this.mCameraDevice.O0000OoO();
        AnonymousClass23 r1 = new Callback<String[]>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass23 */

            public void onSuccess(String[] strArr) {
                if (!CameraPlayerNewActivity.this.isFinishing()) {
                    if (!(CameraPlayerNewActivity.this.mCameraDevice == null || CameraPlayerNewActivity.this.mCameraDevice.O000000o() == null)) {
                        CameraPlayerNewActivity.this.mCameraDevice.O000000o().O000000o("s_angle_panorama", str, (Callback<Void>) null);
                    }
                    String str = strArr[0];
                    if (str.equals("0")) {
                        String str2 = strArr[1];
                        gsy.O00000Oo(cht.f13831O000000o, "getPanorama2 onSuccess stoId=".concat(String.valueOf(str2)));
                        CameraPlayerNewActivity.this.showPanoramic2(str2, false);
                    } else if (str.equals("1")) {
                        gqg.O000000o(CameraPlayerNewActivity.this.getString(R.string.panorama_ing), 1);
                        CameraPlayerNewActivity.this.iv_panoramic_close.performClick();
                    } else {
                        gqg.O000000o(CameraPlayerNewActivity.this.getString(R.string.panorama_fail) + "：" + str, 1);
                        CameraPlayerNewActivity.this.iv_panoramic_close.performClick();
                    }
                }
            }

            public void onFailure(int i, String str) {
                if (!CameraPlayerNewActivity.this.isFinishing()) {
                    gqg.O000000o(CameraPlayerNewActivity.this.getString(R.string.panorama_fail) + "：" + str, 1);
                    CameraPlayerNewActivity.this.iv_panoramic_close.performClick();
                }
            }
        };
        O0000OoO.O0000Oo0 = System.currentTimeMillis() / 1000;
        O0000OoO.O0000OoO = false;
        O0000OoO.O0000Oo.set(0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeStamp", (int) O0000OoO.O0000Oo0);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("panoramType", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String str2 = cht.f13831O000000o;
        gsy.O00000Oo(str2, "getPanorama2 params=" + jSONObject.toString());
        O0000OoO.O00000o0.callMethod("get_panoram", jSONObject, new Callback<JSONObject>(r1) {
            /* class _m_j.cht.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Callback f13832O000000o;

            {
                this.f13832O000000o = r2;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    String str = cht.f13831O000000o;
                    gsy.O00000Oo(str, "getPanorama2 onSuccess = " + jSONObject.toString());
                    int optInt = jSONObject.optInt("panoramState", -1);
                    if (optInt == 0) {
                        cht.this.O0000OOo.postDelayed(new Runnable() {
                            /* class _m_j.cht.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                cht.this.O000000o(cht.this.O0000Oo0, AnonymousClass1.this.f13832O000000o);
                            }
                        }, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                        return;
                    }
                    this.f13832O000000o.onSuccess(new String[]{String.valueOf(optInt), ""});
                } catch (Exception e) {
                    gsy.O000000o(6, cht.f13831O000000o, e.toString());
                    this.f13832O000000o.onFailure(0, "exception!");
                }
            }

            public final void onFailure(int i, String str) {
                this.f13832O000000o.onFailure(i, str);
            }
        }, Parser.DEFAULT_PARSER);
    }

    private void showPanoramic(String str) {
        gsy.O00000Oo(cht.f13831O000000o, "showPanoramic=".concat(String.valueOf(str)));
        this.mHandler.post(new Runnable(str) {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$z6aZq8QAz0n_7hEVYqbsm09OQ */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CameraPlayerNewActivity.this.lambda$showPanoramic$32$CameraPlayerNewActivity(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$showPanoramic$32$CameraPlayerNewActivity(String str) {
        if (new File(str).exists()) {
            gsy.O00000Oo(cht.f13831O000000o, "mHandler.post");
            final Bitmap decodeFile = BitmapFactory.decodeFile(str);
            gsy.O00000Oo(cht.f13831O000000o, "mHandler.post");
            if (this.iv_panoramic.getMeasuredWidth() == 0) {
                this.rl_panoramic.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass24 */

                    public void onGlobalLayout() {
                        CameraPlayerNewActivity.this.rl_panoramic.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                        cameraPlayerNewActivity.showPanoramic(cameraPlayerNewActivity.panoramScale, decodeFile, true);
                    }
                });
            } else {
                showPanoramic(this.panoramScale, decodeFile, true);
            }
        } else {
            gqg.O000000o("error");
        }
    }

    public void showPanoramic2(String str, boolean z) {
        gsy.O00000Oo(cht.f13831O000000o, "showPanoramic2 stoId=".concat(String.valueOf(str)));
        this.mHandler.post(new Runnable(str, z) {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$zsLenjKS9zTjzcHe3iGM0xyLixo */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CameraPlayerNewActivity.this.lambda$showPanoramic2$33$CameraPlayerNewActivity(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$showPanoramic2$33$CameraPlayerNewActivity(String str, final boolean z) {
        String snapshotUrl = CloudVideoNetUtils.getInstance().getSnapshotUrl(this.mCameraDevice.getDid(), "0", str);
        gsy.O00000Oo(cht.f13831O000000o, "showPanoramic2 imgStoreUrl=".concat(String.valueOf(snapshotUrl)));
        if (cnx.O000000o().O00000Oo()) {
            cnx O000000o2 = cnx.O000000o();
            AnonymousClass25 r7 = new coo() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass25 */

                public void onLoadingCancelled(String str, View view) {
                }

                public void onLoadingFailed(String str, View view, FailReason failReason) {
                }

                public void onLoadingStarted(String str, View view) {
                }

                public void onLoadingComplete(String str, View view, final Bitmap bitmap) {
                    if (CameraPlayerNewActivity.this.iv_panoramic.getMeasuredWidth() == 0) {
                        CameraPlayerNewActivity.this.rl_panoramic.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass25.AnonymousClass1 */

                            public void onGlobalLayout() {
                                CameraPlayerNewActivity.this.rl_panoramic.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                CameraPlayerNewActivity.this.showPanoramic(CameraPlayerNewActivity.this.panoramScale, bitmap, z);
                            }
                        });
                        return;
                    }
                    CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                    cameraPlayerNewActivity.showPanoramic(cameraPlayerNewActivity.panoramScale, bitmap, z);
                }
            };
            O000000o2.O00000o0();
            cod O000000o3 = O000000o2.O00000Oo.O000000o();
            O000000o2.O000000o(snapshotUrl, new com(snapshotUrl, O000000o3, ViewScaleType.CROP), O000000o2.O00000Oo.O0000oO0, r7, null);
        }
    }

    public void showPanoramic(float f, Bitmap bitmap, boolean z) {
        this.iv_panoramic.setImageBitmap(bitmap);
        this.iv_panoramic.setCornerRadius((float) gpc.O000000o(10.0f));
        this.ll_panoramic_tip.setVisibility(8);
        this.ll_panoramic_doing.setVisibility(8);
        this.iv_loading_panoramic.clearAnimation();
        if (!this.mCameraDevice.isReadOnlyShared() && this.iv_preset_edit.isSelected()) {
            this.iv_panoramic_edit.setVisibility(0);
        }
        this.iv_panoramic.setVisibility(0);
        this.iv_panoramic_mask.initialAngle(this, this.mCameraDevice.getDid());
        this.iv_panoramic_mask.initialPosition(chz.O00000Oo);
        this.iv_panoramic_mask.setVisibility(0);
        if (!z) {
            gqg.O00000Oo((int) R.string.panorama_success);
        }
        this.iv_preset_edit.setVisibility(0);
        this.iv_preset_edit.setEnabled(true);
    }

    public void reSetPanoramic() {
        this.ll_panoramic_tip.setVisibility(0);
        this.ll_panoramic_doing.setVisibility(8);
        this.iv_loading_panoramic.clearAnimation();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    /* access modifiers changed from: private */
    /* renamed from: startCalibration */
    public void lambda$onActivityResult$34$CameraPlayerNewActivity() {
        chr.O000000o(chr.O00000oo);
        chr.O000000o(chr.O000ooO0);
        gsy.O00000Oo("CameraPlayerNewActivity", "R.id.tvCalibration");
        if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000Oo()) {
            gqg.O000000o((int) R.string.not_connect_check);
        } else if (this.mCameraDevice.isReadOnlyShared()) {
            gqg.O000000o((int) R.string.auth_fail_read_only);
        } else if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
        } else {
            gqg.O000000o((int) R.string.calibrating);
            this.mCameraPlayerEx.O000000o(5, (IXmConnectionClient.XmActionCallback) null);
        }
    }

    public void doStopRecord() {
        this.mLastTime = 0;
        this.mCurrentTime = 0;
        this.mTVRecordTimer.setVisibility(8);
        this.tvRecordTimerLand.setVisibility(8);
        if (this.mCameraDevice == null) {
            return;
        }
        if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000O0o()) {
            this.mCDCCameraRecord.setChecked(false);
            this.mCDCCameraRecordFull.setChecked(false);
            return;
        }
        if (this.mCameraPlayerEx.O0000OoO()) {
            this.mCameraPlayerEx.O00000Oo(false);
        }
        this.mCameraPlayerEx.O000000o(new XmMp4Record.IRecordListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass26 */

            public void onSuccess(String str) {
                CameraPlayerNewActivity.this.onVideoRecorded(str);
                CameraPlayerNewActivity.this.mCDCCameraRecord.setChecked(false);
                CameraPlayerNewActivity.this.mCDCCameraRecordFull.setChecked(false);
            }

            public void onFailed(int i, String str) {
                CameraPlayerNewActivity.this.mCDCCameraRecord.setChecked(false);
                CameraPlayerNewActivity.this.mCDCCameraRecordFull.setChecked(false);
                if (i == -2) {
                    gqg.O000000o((int) R.string.snip_video_failed_time_mini);
                } else {
                    gqg.O000000o((int) R.string.snip_video_failed);
                }
            }
        });
    }

    public void doStopCall() {
        if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O00000o0()) {
            this.mCameraPlayerEx.O00000oO();
            this.mHandler.removeMessages(2101);
        }
        if (this.mMSTVVoice.getCurrentState() == 1) {
            this.mMSTVVoice.setCurrentState(0);
        }
        if (this.mCBVoiceLandscape.isChecked()) {
            this.mCBVoiceLandscape.setChecked(false);
        }
        if (this.mCBMuteLandscape.isChecked()) {
            this.mCBMuteLandscape.setChecked(false);
        }
        if (this.mCDCToggleAudio.isChecked()) {
            this.mCDCToggleAudio.setChecked(false);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1220 || i == 1221) {
            if (this.mDeviceStat != null) {
                boolean isUsrExpPlanEnabled = XmPluginHostApi.instance().isUsrExpPlanEnabled(this.mDeviceStat.did);
                chr.O00Ooo0O = isUsrExpPlanEnabled;
                this.mCameraDevice.O000000o(isUsrExpPlanEnabled);
            }
            if (i2 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra("result_data");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("removedLicense")) {
                    this.mCameraDevice.O00000oO().O00000oO(true);
                    finish();
                }
                if (intent.getBooleanExtra("start_calibration", false)) {
                    if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000Oo()) {
                        this.runnableList.add(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$vsK9rCqzEtOjzEvmO0PTJMkvPRY */

                            public final void run() {
                                CameraPlayerNewActivity.this.lambda$onActivityResult$34$CameraPlayerNewActivity();
                            }
                        });
                    } else {
                        lambda$onActivityResult$34$CameraPlayerNewActivity();
                    }
                }
                if (intent.getBooleanExtra("open_float_window", false)) {
                    this.mKeepConnection = true;
                    finish();
                }
            }
        } else if (102 == i || 112 == i) {
            cki.O00000o0("CameraPlayerNewActivity", "requestCode:" + i + " resultCode:" + i2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mDid);
            fno.O000000o().O000000o(arrayList, new fsm<List<Device>, fso>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass27 */

                public void onFailure(fso fso) {
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<Device>) ((List) obj));
                }

                public void onSuccess(List<Device> list) {
                    if (!CameraPlayerNewActivity.this.isFinishing() && list != null && list.size() > 0) {
                        ft.O000000o(gkv.f17949O000000o).O000000o(new Intent("com.smarthome.refresh_list_view"));
                    }
                }
            });
            if (i2 == -1 || i2 == 211) {
                Device O000000o2 = fno.O000000o().O000000o(this.mDid);
                if (O000000o2 == null) {
                    finish();
                }
                this.mCameraDevice.deviceStat().pinCodeType = O000000o2.pinCodeType;
                this.mCameraDevice.deviceStat().isSetPinCode = O000000o2.isSetPinCode;
                if (this.mCameraDevice.deviceStat().isSetPinCode == 1 && this.mCameraDevice.deviceStat().pinCodeType == 2) {
                    gpy.O000000o(gkv.f17949O000000o, this.md5Name, KOREA_FORCE_PIN_CODE, false);
                } else if (112 == i) {
                    globalPinCodeOnOffFunc();
                } else {
                    finish();
                }
            } else {
                finish();
            }
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void setResolutionText(int i) {
        if (i != 1) {
            if (i == 2 || i == 3) {
                if (DeviceConstant.is2K(this.mCameraDevice.getModel())) {
                    this.mTVSResolution.setImageResource(R.drawable.home_icon_resolution_2k_new);
                    this.mTVSResolution_land.setImageResource(R.drawable.home_icon_resolution_2k_new);
                    return;
                }
                this.mTVSResolution.setImageResource(R.drawable.home_icon_resolution_1080p_new);
                this.mTVSResolution_land.setImageResource(R.drawable.home_icon_resolution_1080p_new);
            } else if (this.isLanguageCN) {
                this.mTVSResolution.setImageResource(R.drawable.home_icon_resolution_auto_new_cn);
                this.mTVSResolution_land.setImageResource(R.drawable.home_icon_resolution_auto_new_cn);
            } else {
                this.mTVSResolution.setImageResource(R.drawable.home_icon_resolution_auto_new);
                this.mTVSResolution_land.setImageResource(R.drawable.home_icon_resolution_auto_new);
            }
        } else if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
            this.mTVSResolution.setImageResource(R.drawable.home_icon_resolution_480p_new);
            this.mTVSResolution_land.setImageResource(R.drawable.home_icon_resolution_480p_new);
        } else {
            this.mTVSResolution.setImageResource(R.drawable.home_icon_resolution_360p_new);
            this.mTVSResolution_land.setImageResource(R.drawable.home_icon_resolution_360p_new);
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
    public void setOrientation(int i) {
        if (!this.mFullScreen && ciw.O000000o(i)) {
            if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
                return;
            }
            chr.O0000oo0();
        }
        if (i == 1) {
            chr.O0000oo();
        }
        setRequestedOrientation(i);
    }

    private void popupMoreDialog() {
        if (this.mIsResumed) {
            cid cid = this.mCameraDevice;
            clf.O00000Oo();
            this.moreDialog = new MoreDialog(this, R.style.popupDialog, cid, this, clf.O00000o0() && clf.O00000oO());
            MoreDialog moreDialog2 = this.moreDialog;
            moreDialog2.moreDialogListener = new MoreDialog.IMoreDialogListener() {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$E7vmf71XaI4V_YRRHjBmnnTH1c */

                public final void onPowerStateChanged(boolean z) {
                    CameraPlayerNewActivity.this.lambda$popupMoreDialog$35$CameraPlayerNewActivity(z);
                }
            };
            moreDialog2.show();
            this.moreDialog.setCancelable(true);
        }
    }

    public /* synthetic */ void lambda$popupMoreDialog$35$CameraPlayerNewActivity(boolean z) {
        gsy.O00000Oo("CameraPlayerNewActivity", "isPowerOn:".concat(String.valueOf(z)));
        if (z) {
            this.mFrameRate.setVisibility(0);
        } else {
            this.mFrameRate.setVisibility(8);
        }
    }

    public void loadPropertiesFromCache() {
        Object propertyValueFromCache = getPropertyValueFromCache("camera-control", "on");
        this.mCameraDevice.O000000o().O00000Oo("power", Boolean.valueOf(propertyValueFromCache != null ? ((Boolean) propertyValueFromCache).booleanValue() : true));
    }

    public void onStart() {
        super.onStart();
        if (this.mStoredLandscape) {
            setOrientation(0);
            this.mStoredLandscape = false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public void onResume() {
        super.onResume();
        detectSDCard();
        calculateTitleBarHeight();
        chr.O0000o();
        mi.O00000Oo();
        showCloudVideoTips();
        isCloudVideoUser();
        this.mCameraDevice.updateDeviceStatus();
        IntentFilter intentFilter = new IntentFilter();
        if (this.mCameraDevice == null || !this.mCameraDevice.O00000o()) {
            this.mCameraDevice.O0000OOo();
            intentFilter.addAction("com.mijia.camera.SdcardManager");
        } else {
            this.mCameraDevice.O0000Oo0();
            intentFilter.addAction("com.mijia.camera.SdcardManagerEx");
        }
        this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("miui.action_open_floating_window");
        registerReceiver(this.receiver2, intentFilter2);
        ((TextView) findViewById(R.id.title_bar_title)).setText(this.mCameraDevice.getName());
        if (!this.mNeedLicense || this.mCameraDevice.isShared()) {
            this.mHandler.sendEmptyMessage(3051);
            this.mHandler.sendEmptyMessage(3052);
            if (!this.isFirstResumed || this.mCameraDevice.deviceStat().isOnline) {
                if (this.mNeedPincode) {
                    this.mHandler.removeMessages(2100);
                    this.mHandler.sendEmptyMessageDelayed(2100, 1000);
                } else {
                    this.isFirstResumed = true;
                    this.mHandler.removeMessages(2100);
                    this.mHandler.sendEmptyMessage(2100);
                }
            }
        }
        if (this.mTimeUpdateView.getVisibility() == 0) {
            this.mTimeUpdateView.setVisibility(8);
        }
        if (!this.mNeedPincode) {
            processDirectTips();
        }
        boolean z = false;
        this.mNeedPincode = false;
        loadProps();
        getIdmConfigs();
        refreshTips();
        this.mHandler.postDelayed(this.bottomCtrlVisibilityGoneRunnable, 5000);
        hjr hjr = this.currentOperation;
        if (hjr != null) {
            updateRedPoint(hjr);
        }
        if (!CoreApi.O000000o().O0000O0o() || ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.gestureEnable = true;
        } else {
            this.gestureEnable = gpy.O00000o0(gkv.f17949O000000o, this.md5Name, "SP_KEY_GESTURE_CTRL_DIRECTION", true);
        }
        if (CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            z = true;
        }
        this.isInternationalServer = z;
        goq.O000000o($$Lambda$CameraPlayerNewActivity$HENmooJACHadJ3PbcPfzilgpx4.INSTANCE);
        initAiSettings();
    }

    public void doDirectTipClick(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = isShowFace() && !this.mCameraDevice.isShared();
            boolean z2 = DeviceConstant.isSupportNewUI(this.mCameraDevice.getModel()) && CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
            gsy.O00000Oo("CameraPlayerNewActivity", "doDirectTipClick isShowFace: " + z + " isShowFaceManager: " + z2);
            startActivityForResult(OpenNativeWebViewActivity.getIntent(this, str, "", this.mDid, z && z2, this.mSdcardDetectResult.sdcardGetSuccess, this.mSdcardDetectResult.sdcardStatus, true), 1221);
            this.direct_push_ll.setVisibility(8);
        } else if (i == 1) {
            this.direct_push_ll.setVisibility(8);
            LogType logType = LogType.CAMERA;
            String model = this.mCameraDevice.getModel();
            gsy.O00000o0(logType, model, "CameraPlayerNewActivity", "openCloudVideoList by doDirectTipClick did=" + this.mCameraDevice.getDid() + " vip=" + this.mCameraDevice.O00000oO().O00000Oo() + " window=" + this.mCameraDevice.O00000oO().O000000o());
            fsp.O000000o().O0000Oo.openCloudVideoListActivity(this, this.mCameraDevice.getDid(), this.mCameraDevice.getName());
        }
    }

    private void processDirectTips() {
        clf O000000o2 = clf.O000000o();
        String did = this.mCameraDevice.getDid();
        String model = this.mCameraDevice.getModel();
        String str = this.language;
        AnonymousClass28 r3 = new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass28 */

            public void onSuccess(JSONObject jSONObject) {
                StringBuilder sb = new StringBuilder("directTargetPush onSuccess did=");
                sb.append(CameraPlayerNewActivity.this.mCameraDevice.getDid());
                sb.append(" model=");
                sb.append(CameraPlayerNewActivity.this.mCameraDevice.getModel());
                sb.append(" result=");
                sb.append(jSONObject == null ? "null" : jSONObject.toString());
                cki.O00000o0("CameraPlayerNewActivity", sb.toString());
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject.optBoolean("showTip")) {
                        int optInt = optJSONObject.optInt("pushType");
                        String optString = optJSONObject.optString("targetUrl");
                        String optString2 = optJSONObject.optString("tip");
                        if (CameraPlayerNewActivity.this.directPushTV != null) {
                            CameraPlayerNewActivity.this.directPushTV.setText(optString2);
                            CameraPlayerNewActivity.this.direct_push_ll.setVisibility(0);
                            CameraPlayerNewActivity.this.directPushTV.setOnClickListener(new View.OnClickListener(optInt, optString) {
                                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$28$ZGgorDcLxMwJ7rVMbhWcLKkXhQ */
                                private final /* synthetic */ int f$1;
                                private final /* synthetic */ String f$2;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void onClick(View view) {
                                    CameraPlayerNewActivity.AnonymousClass28.this.lambda$onSuccess$0$CameraPlayerNewActivity$28(this.f$1, this.f$2, view);
                                }
                            });
                        }
                        cki.O00000o0("CameraPlayerNewActivity", "directCloseTargetPush did=" + CameraPlayerNewActivity.this.mCameraDevice.getDid() + " model=" + CameraPlayerNewActivity.this.mCameraDevice.getModel());
                        clf O000000o2 = clf.O000000o();
                        String did = CameraPlayerNewActivity.this.mCameraDevice.getDid();
                        String model = CameraPlayerNewActivity.this.mCameraDevice.getModel();
                        AnonymousClass1 r4 = new Callback<JSONObject>() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass28.AnonymousClass1 */

                            public void onSuccess(JSONObject jSONObject) {
                                StringBuilder sb = new StringBuilder("directCloseTargetPush onSuccess did=");
                                sb.append(CameraPlayerNewActivity.this.mCameraDevice.getDid());
                                sb.append(" model=");
                                sb.append(CameraPlayerNewActivity.this.mCameraDevice.getModel());
                                sb.append(" result=");
                                sb.append(jSONObject == null ? "null" : jSONObject.toString());
                                cki.O00000o0("CameraPlayerNewActivity", sb.toString());
                            }

                            public void onFailure(int i, String str) {
                                cki.O00000oO("CameraPlayerNewActivity", "directCloseTargetPush onFailure =" + i + "  " + str);
                            }
                        };
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("did", did);
                            jSONObject2.put("pushType", optInt);
                        } catch (Exception e) {
                            cki.O00000oO("AlarmNetUtils", e.toString());
                        }
                        XmPluginHostApi.instance().callSmartHomeApi(model, "business.smartcamera.", "/miot/camera/app/v1/vip/closeRnPush", "POST", jSONObject2, new Callback<JSONObject>(r4) {
                            /* class _m_j.clf.AnonymousClass12 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ Callback f14040O000000o;

                            {
                                this.f14040O000000o = r2;
                            }

                            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                JSONObject jSONObject = (JSONObject) obj;
                                Callback callback = this.f14040O000000o;
                                if (callback != null) {
                                    callback.onSuccess(jSONObject);
                                }
                            }

                            public final void onFailure(int i, String str) {
                                Callback callback = this.f14040O000000o;
                                if (callback != null) {
                                    callback.onFailure(i, str);
                                }
                            }
                        }, Parser.DEFAULT_PARSER);
                    }
                } catch (Exception e2) {
                    cki.O00000oO("CameraPlayerNewActivity", e2.toString());
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$CameraPlayerNewActivity$28(int i, String str, View view) {
                CameraPlayerNewActivity.this.doDirectTipClick(i, str);
            }

            public void onFailure(int i, String str) {
                cki.O000000o("CameraPlayerNewActivity", "directTargetPush onFailure =" + i + "  " + str);
            }
        };
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", did);
            jSONObject.put("model", model);
            jSONObject.put("language", str);
        } catch (Exception e) {
            cki.O00000oO("AlarmNetUtils", e.toString());
        }
        XmPluginHostApi.instance().callSmartHomeApi(model, "business.smartcamera.", "/miot/camera/app/v1/vip/targetPush", "GET", jSONObject, new Callback<JSONObject>(r3) {
            /* class _m_j.clf.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Callback f14037O000000o;

            {
                this.f14037O000000o = r2;
            }

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Callback callback = this.f14037O000000o;
                if (callback != null) {
                    callback.onSuccess(jSONObject);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = this.f14037O000000o;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hlr.O000000o(io.reactivex.functions.Consumer<java.util.List<_m_j.hju>>, boolean):void
     arg types: [com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity$29, int]
     candidates:
      _m_j.hlr.O000000o(java.lang.String, com.facebook.drawee.view.SimpleDraweeView):void
      _m_j.hlr.O000000o(io.reactivex.functions.Consumer<java.util.List<_m_j.hju>>, boolean):void */
    /* access modifiers changed from: package-private */
    public void refreshTips() {
        this.operationProvider.O000000o((Consumer<List<hju>>) new Consumer<List<hjr>>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass29 */

            public /* bridge */ /* synthetic */ void accept(Object obj) throws Exception {
                accept((List<hjr>) ((List) obj));
            }

            public void accept(List<hjr> list) throws Exception {
                CameraPlayerNewActivity.this.updateOperationView();
            }
        }, false);
    }

    private hjr getShowOperation(List<hjr> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<hjr>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass30 */

            public int compare(hjr hjr, hjr hjr2) {
                if (hjr.O00000oo < hjr2.O00000oo) {
                    return -1;
                }
                return hjr.O00000oo > hjr2.O00000oo ? 1 : 0;
            }
        });
        return list.get(0);
    }

    public void getIdmConfigs() {
        if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel()) && cin.O00000o0(this.mCameraDevice.O00000o0(), "4.1.6_0078") >= 0) {
            clf.O000000o().O00000Oo(this.mCameraDevice.getDid(), this.mCameraDevice.getModel(), new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass31 */

                public void onSuccess(JSONObject jSONObject) {
                    cki.O00000oO("CameraPlayerNewActivity", "getRangeExtraData onSuccess result=".concat(String.valueOf(jSONObject)));
                    try {
                        IDMPairingInfo iDMPairingInfo = (IDMPairingInfo) new Gson().fromJson(jSONObject.toString(), IDMPairingInfo.class);
                        chr.O000000o(chr.O00Oo0OO, "type", Integer.valueOf(Integer.parseInt(iDMPairingInfo.idm_eventType)));
                        int parseInt = Integer.parseInt(iDMPairingInfo.idm_switch);
                        String str = chr.O00Oo0;
                        int i = 1;
                        if (parseInt != 1) {
                            i = 2;
                        }
                        chr.O000000o(str, "type", Integer.valueOf(i));
                    } catch (Exception e) {
                        cki.O00000oO("CameraPlayerNewActivity", e.toString());
                    }
                }

                public void onFailure(int i, String str) {
                    cki.O00000oO("CameraPlayerNewActivity", "getRangeExtraData onFailure=" + i + " " + str);
                }
            });
        }
    }

    public void loadProps() {
        final cle O0000o0o = this.mCameraDevice.O0000o0o();
        if (this.mCameraSpecDevice != null) {
            gsy.O00000o0(LogType.CAMERA, this.mCameraDevice.getModel(), "CameraPlayerNewActivity", "start loadPropFromSpecServer ... ");
            loadPropertiesFromServer(SpecConstantUtils.MotionDetectionSpecKV(this.mCameraDevice.getModel()), new Callback<List<PropertyParam>>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass32 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<PropertyParam>) ((List) obj));
                }

                public void onSuccess(List<PropertyParam> list) {
                    cki.O00000o0("CameraPlayerNewActivity", "MotionDetectionSpecKV onSuccess");
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        Object propertyValueFromCache = CameraPlayerNewActivity.this.getPropertyValueFromCache("motion-detection", "motion-detection");
                        if (propertyValueFromCache != null ? ((Boolean) propertyValueFromCache).booleanValue() : false) {
                            CameraPlayerNewActivity.this.getAlarmEvent();
                        } else {
                            CameraPlayerNewActivity.this.alarm_menu_sub_text.setText((int) R.string.home_new_menu_sub_text_kanjia);
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    cki.O00000o0("CameraPlayerNewActivity", "MotionDetectionSpecKV onFailure " + i + "-" + str);
                    CameraPlayerNewActivity.this.alarm_menu_sub_text.setText((int) R.string.home_new_menu_sub_text_kanjia);
                }
            });
            loadPropertiesFromServer(SpecConstantUtils.CameraControlSpecKV(this.mCameraDevice.getModel()), new Callback<List<PropertyParam>>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass33 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<PropertyParam>) ((List) obj));
                }

                public void onSuccess(List<PropertyParam> list) {
                    cki.O00000o0("CameraPlayerNewActivity", "CameraControlSpecKV onSuccess");
                }

                public void onFailure(int i, String str) {
                    cki.O00000o0("CameraPlayerNewActivity", "CameraControlSpecKV onFailure " + i + "-" + str);
                }
            });
            if (this.mCameraDevice != null && TextUtils.equals(this.mCameraDevice.getModel(), "chuangmi.camera.ipc022")) {
                loadPropertiesFromServer(SpecConstantUtils.NativeAISpecKV(null), new Callback<List<PropertyParam>>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass34 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<PropertyParam>) ((List) obj));
                    }

                    public void onSuccess(List<PropertyParam> list) {
                        cki.O00000o0("CameraPlayerNewActivity", "NativeAISpecKV onSuccess");
                    }

                    public void onFailure(int i, String str) {
                        cki.O00000o0("CameraPlayerNewActivity", "NativeAISpecKV onFailure:" + i + "_" + str);
                    }
                });
                loadPropertiesFromServer(SpecConstantUtils.ChuangmiBabySleepKV(this.mCameraDevice.getModel()), new Callback<List<PropertyParam>>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass35 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<PropertyParam>) ((List) obj));
                    }

                    /* JADX INFO: additional move instructions added (1) to help type inference */
                    public void onSuccess(List<PropertyParam> list) {
                        try {
                            StringBuilder sb = new StringBuilder("loadPropertiesFromServer ChuangmiBabySleepKV onSuccess result=");
                            sb.append(list == null ? list : list.toString());
                            cki.O000000o("CameraPlayerNewActivity", sb.toString());
                            Object propertyValueFromCache = CameraPlayerNewActivity.this.getPropertyValueFromCache("chuangmi-ai", "baby-wake-switch");
                            int i = 1;
                            boolean z = propertyValueFromCache != null && ((Boolean) propertyValueFromCache).booleanValue();
                            String str = chr.O00Oo00o;
                            if (!z) {
                                i = 2;
                            }
                            chr.O000000o(str, "type", Integer.valueOf(i));
                        } catch (Exception e) {
                            cki.O00000oO("CameraPlayerNewActivity", e.toString());
                            gqg.O00000Oo((int) R.string.action_fail);
                        }
                    }

                    public void onFailure(int i, String str) {
                        cki.O00000o0("CameraPlayerNewActivity", "ChuangmiBabySleepKV onFailure:" + i + "_" + str);
                    }
                });
            }
            loadPropertiesFromServer(SpecConstantUtils.IndicatorLightSpecKV(this.mCameraDevice.getModel()), new Callback<List<PropertyParam>>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass36 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<PropertyParam>) ((List) obj));
                }

                public void onSuccess(List<PropertyParam> list) {
                    cki.O00000o0("CameraPlayerNewActivity", "IndicatorLightSpecKV onSuccess");
                }

                public void onFailure(int i, String str) {
                    cki.O00000o0("CameraPlayerNewActivity", "IndicatorLightSpecKV onFailure " + i + "-" + str);
                }
            });
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("did", this.mCameraDevice.getDid());
                jSONObject.put("region", Locale.getDefault().getCountry());
                LogType logType = LogType.CAMERA;
                String model = this.mCameraDevice.getModel();
                gsy.O00000o0(logType, model, "CameraPlayerNewActivity", "start getAlarmConfig ... params=" + jSONObject.toString());
                O0000o0o.O000000o(this.mCameraDevice.getModel(), jSONObject, new cle.O000000o() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass37 */

                    public void onSuccess(Object obj, Object obj2) {
                        if (!CameraPlayerNewActivity.this.isFinishing()) {
                            if (O0000o0o.f14020O000000o.f13985O000000o) {
                                CameraPlayerNewActivity.this.getAlarmEvent();
                            } else {
                                CameraPlayerNewActivity.this.alarm_menu_sub_text.setText((int) R.string.home_new_menu_sub_text_kanjia);
                            }
                        }
                    }

                    public void onFailure(int i, String str) {
                        gsy.O000000o(6, "CameraPlayerNewActivity", str + "--" + i);
                        CameraPlayerNewActivity.this.alarm_menu_sub_text.setText((int) R.string.home_new_menu_sub_text_kanjia);
                    }
                });
            } catch (JSONException e) {
                gsy.O000000o(6, "CameraPlayerNewActivity", e.toString());
            }
        }
        if (this.mHandler != null && this.mCameraDevice != null && this.mCameraDevice.getModel().equalsIgnoreCase("chuangmi.camera.ipc022")) {
            this.mHandler.postDelayed(new Runnable(O0000o0o) {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$6iRSZWm7YthgquVcrg4GSUQCxm4 */
                private final /* synthetic */ cle f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CameraPlayerNewActivity.this.lambda$loadProps$37$CameraPlayerNewActivity(this.f$1);
                }
            }, 2000);
        }
    }

    public /* synthetic */ void lambda$loadProps$37$CameraPlayerNewActivity(cle cle) {
        ActivityHelperUtils.getInstance().statProfileBabyCrySwitch(cle, this.mCameraDevice.getModel(), this.mCameraDevice.getDid());
    }

    public void getAlarmEvent() {
        this.mCameraDevice.O00000oo().getEventList("Default", 0, new Date().getTime(), new AlarmCloudCallback<ArrayList<AlarmVideo>>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass38 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj));
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj, long j, boolean z) {
                onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj), j, z);
            }

            /* JADX WARNING: Removed duplicated region for block: B:66:0x01df A[LOOP:0: B:7:0x002a->B:66:0x01df, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x01e3 A[SYNTHETIC] */
            public void onSuccess(ArrayList<AlarmVideo> arrayList, long j, boolean z) {
                boolean z2;
                String str;
                if (arrayList != null && arrayList.size() > 0) {
                    AlarmVideo alarmVideo = arrayList.get(0);
                    String[] split = alarmVideo.eventType.split(":");
                    AlarmVideoAdapter.sortByEventType(split);
                    if (split.length > 2) {
                        split = (String[]) Arrays.copyOfRange(split, 0, 2);
                    }
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    while (i < split.length) {
                        String str2 = split[i];
                        char c = 65535;
                        switch (str2.hashCode()) {
                            case -1293551627:
                                if (str2.equals("ObjectMotion")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 2088:
                                if (str2.equals("AI")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 80127:
                                if (str2.equals("Pet")) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case 2181757:
                                if (str2.equals("Face")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 722651973:
                                if (str2.equals("PeopleMotion")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 1316906260:
                                if (str2.equals("BabyCry")) {
                                    c = 4;
                                    break;
                                }
                                break;
                        }
                        if (c == 0) {
                            sb.delete(0, sb.length());
                            sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.ai_scene_desc));
                            sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.and));
                        } else if (c != 1) {
                            if (c == 2) {
                                sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.event_type_people_motion));
                                sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.and));
                            } else if (c != 3) {
                                if (c == 4) {
                                    sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.baby_cry_desc));
                                    sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.and));
                                } else if (c != 5) {
                                    sb.append(str2);
                                    sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.and));
                                } else {
                                    sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.event_type_pet));
                                    sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.and));
                                }
                                z2 = false;
                                if (z2) {
                                    i++;
                                } else {
                                    sb.replace(sb.length() - CameraPlayerNewActivity.this.getResources().getString(R.string.and).length(), sb.length(), "!");
                                    CameraPlayerNewActivity.this.alarm_menu_sub_text.setText(String.format("%s %s", CameraPlayerNewActivity.mSdf.format(Long.valueOf(alarmVideo.createTime)), sb.toString()));
                                }
                            } else if (alarmVideo.fileIdMetaResult == null || alarmVideo.fileIdMetaResult.faceInfoMetas == null || alarmVideo.fileIdMetaResult.faceInfoMetas.size() == 0) {
                                sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.unknown_people_desc));
                                sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.and));
                            } else {
                                Iterator<FaceInfoMeta> it = alarmVideo.fileIdMetaResult.faceInfoMetas.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FaceInfoMeta next = it.next();
                                        if (next != null && next.matched) {
                                            str = next.figureName;
                                        }
                                    } else {
                                        str = "";
                                    }
                                }
                                if (TextUtils.isEmpty(str)) {
                                    sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.unknown_people_desc));
                                    sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.and));
                                } else {
                                    sb.append(String.format(CameraPlayerNewActivity.this.getResources().getString(R.string.known_people_desc), str));
                                    sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.and));
                                }
                            }
                        } else if (TextUtils.isEmpty(sb)) {
                            sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.event_type_obj_motion));
                            sb.append(CameraPlayerNewActivity.this.getResources().getString(R.string.and));
                        }
                        z2 = true;
                        if (z2) {
                        }
                    }
                    sb.replace(sb.length() - CameraPlayerNewActivity.this.getResources().getString(R.string.and).length(), sb.length(), "!");
                    CameraPlayerNewActivity.this.alarm_menu_sub_text.setText(String.format("%s %s", CameraPlayerNewActivity.mSdf.format(Long.valueOf(alarmVideo.createTime)), sb.toString()));
                }
            }

            public void onSuccess(ArrayList<AlarmVideo> arrayList) {
                gsy.O00000Oo("CameraPlayerNewActivity", "onSuccess");
            }

            public void onFailure(int i, String str) {
                gsy.O00000Oo("CameraPlayerNewActivity", "onFailure" + i + "--" + str);
            }
        });
    }

    public void onStop() {
        super.onStop();
        doStopCall();
        doStopRecord();
        if (ciw.O000000o(getRequestedOrientation())) {
            this.mStoredLandscape = true;
            setOrientation(1);
        }
        gpy.O000000o(gkv.f17949O000000o, this.md5Name, DrawerCloseState, drawerClosed);
    }

    public void onPause() {
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O0000OOo();
        }
        this.mCDCToggleAudio.setChecked(false);
        this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver);
        unregisterReceiver(this.receiver2);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(2100);
        dismissSnapshotPopupRunnable(0);
        if (this.mCameraPlayerEx != null) {
            this.mIsReal = this.mCameraPlayerEx.O00000Oo();
        }
        if (this.mCameraDevice != null) {
            cih.O000000o(this.mCameraDevice);
        }
        super.onPause();
        goq.O000000o($$Lambda$CameraPlayerNewActivity$hA79iZON_JuVCJ_e0m9g07aA4.INSTANCE);
    }

    public void resumeCamera() {
        gsy.O00000Oo("CameraPlayerNewActivity", "resumeCamera");
        this.mPauseView.setVisibility(8);
        if (this.mCameraPlayerEx != null) {
            if (!this.mCameraPlayerEx.O00000Oo() || !this.mCameraPlayerEx.O0000o0()) {
                gsy.O00000Oo("CameraPlayerNewActivity", "resumeCamera startStreamPlay");
                showLoading(null);
                this.mCameraPlayerEx.O0000o0O();
            } else if (this.mCameraPlayerEx.O00000Oo()) {
                gsy.O00000Oo("CameraPlayerNewActivity", "resumeCamera setPlayTime");
                setPlayTime(0, false);
            }
        }
        refreshUI();
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                if (i == 1002) {
                    this.mHintView.setVisibility(8);
                } else if (i == 4000) {
                    this.mNeedSpeed = false;
                    this.mTimeUpdateView.setVisibility(8);
                } else if (i == 2100) {
                    hidError();
                    if (!mg.O00000o0(this) || this.mAllowMobileNetwork) {
                        showLoading(getString(R.string.camera_play_initial_0));
                    }
                    startPlay();
                } else if (i == 2101) {
                } else {
                    if (i == 3051) {
                        this.mCameraDevice.O00000Oo(getContext(), new Callback<Integer[]>() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass39 */

                            public void onSuccess(Integer[] numArr) {
                                if (numArr != null) {
                                    if (numArr[0].intValue() == 0) {
                                        CameraPlayerNewActivity.this.hideUpdateIng(true);
                                        CameraPlayerNewActivity.this.mHandler.removeMessages(3051);
                                        CameraPlayerNewActivity.this.mHandler.sendEmptyMessage(3052);
                                    } else if (numArr[1].intValue() < 100) {
                                        CameraPlayerNewActivity.this.showUpdateIng(numArr[1].intValue());
                                        CameraPlayerNewActivity.this.mHandler.sendEmptyMessageDelayed(3051, 1500);
                                    } else {
                                        CameraPlayerNewActivity.this.hideUpdateIng(true);
                                        CameraPlayerNewActivity.this.mHandler.removeMessages(3051);
                                        CameraPlayerNewActivity.this.startPlay();
                                    }
                                }
                            }

                            public void onFailure(int i, String str) {
                                CameraPlayerNewActivity.this.hideUpdateIng(false);
                                CameraPlayerNewActivity.this.mHandler.removeMessages(3051);
                            }
                        });
                    } else if (i == 3052) {
                        this.mUpdateFirmwareHelper.fetchFirmwareUpdateInfo(this.mCameraDevice);
                    }
                }
            } else if (this.mCameraPlayerEx == null) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendEmptyMessageDelayed(2, 2000);
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (this.mCameraPlayerEx != null) {
                    currentTimeMillis = this.mCameraPlayerEx.O0000oOo();
                }
                if (this.mLastPlayTime == currentTimeMillis) {
                    this.mHandler.removeMessages(2);
                    this.mHandler.sendEmptyMessageDelayed(2, 2000);
                    return;
                }
                if (this.mNeedCheckAlive) {
                    if ((this.mCameraPlayerEx == null || this.mCameraPlayerEx.O00000Oo()) && System.currentTimeMillis() - this.mLastSetPlayTime <= 10000) {
                        hideLoading();
                        this.mNeedCheckAlive = false;
                    } else {
                        this.mHandler.removeMessages(2);
                        this.mHandler.sendEmptyMessageDelayed(2, 2000);
                        return;
                    }
                }
                this.mLastPlayTime = currentTimeMillis;
                this.mHandler.removeMessages(2);
                this.mHandler.sendEmptyMessageDelayed(2, 2000);
            }
        } else if (!((FirmwareUpdateResult) message.obj).isLatest) {
            this.mNewFirmView.setVisibility(0);
        }
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            exitFullScreen(null);
            this.mAVCameraLandscape.setVisibility(8);
        } else if (canStepOut()) {
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
    public void startPlay() {
        if (this.mCameraDevice == null) {
            return;
        }
        if (!this.mCameraDevice.O00000o() && TextUtils.isEmpty(this.mCameraDevice.O00oOooo())) {
            updatePwd();
        } else if (!TextUtils.isEmpty(this.mCameraDevice.getModel()) && !TextUtils.isEmpty(this.mCameraDevice.getDid())) {
            if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                showPowerOffView();
                return;
            }
            if (this.mPauseView.getVisibility() == 0) {
                this.mPauseView.setVisibility(8);
            }
            if (this.mCameraPlayerEx == null) {
                this.mCameraPlayerEx = ciy.O000000o(this, this.mCameraDevice, this);
                this.mCameraPlayerEx.O000000o(this.mVideoView);
                this.mVideoView.O0000O0o();
                this.mCameraPlayerEx.O000000o(this.mIRecodeTimeListener);
                this.mCameraPlayerEx.O000000o(this.resolutionChangedExListener);
                this.mCameraPlayerEx.O000000o(this.mVideoLiveExListener);
            }
            if (!this.mCameraPlayerEx.O0000Oo()) {
                this.mCameraPlayerEx.O0000o0o();
            }
            if (!mg.O00000o0(this) || this.mAllowMobileNetwork) {
                if (this.mCameraPlayerEx != null) {
                    this.mCameraPlayerEx.O0000o0O();
                }
                this.isStartPlay = true;
            } else {
                this.mIsUserPause = true;
                pauseCamera();
            }
            this.mHandler.sendEmptyMessageDelayed(2, 2000);
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
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            if (this.mPowerOffView.getVisibility() == 8) {
                showPowerOffView();
                if (this.mCameraPlayerEx != null) {
                    this.mCameraPlayerEx.O0000OOo();
                }
                if (this.mPauseView.getVisibility() == 0) {
                    this.mPauseView.setVisibility(8);
                }
            }
            this.mCdcToggleSleep.setCurrentState(1);
            if (this.mCameraPlayerEx != null) {
                if (this.mCameraPlayerEx.O0000O0o()) {
                    doStopRecord();
                }
                if (this.mCameraPlayerEx.O00000o0()) {
                    doStopCall();
                }
            }
        } else {
            if (this.mPowerOffView.getVisibility() == 0) {
                hidePowerOffView();
                if (this.mCameraPlayerEx != null) {
                    this.mCameraPlayerEx.O0000o0O();
                } else {
                    startPlay();
                }
            }
            this.mCdcToggleSleep.setCurrentState(0);
        }
        if (this.mCameraDevice != null && this.mCameraDevice.O000000o().O000000o("track", false)) {
            this.mFrameRate.setText(getString(R.string.is_move_track));
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
        if (this.mNetworkMonitor != null) {
            this.mNetworkMonitor.O00000Oo();
        }
        if (this.mCameraPlayerEx != null) {
            if (this.mCameraDevice != null && cih.O00000o0(this.mCameraDevice.deviceStat()) && this.mCameraDevice.O00000o0 && this.mProgress >= 100) {
                cki.O00000o("CameraPlayerNewActivity", "delayed release: true");
                unlockPreConnectedStatus();
                this.mKeepConnection = true;
            }
            cki.O00000o("CameraPlayerNewActivity", "delayed release: " + this.mKeepConnection);
            this.mCameraPlayerEx.O000000o(this.mKeepConnection);
        }
        if (this.mVideoView != null && this.mCameraDevice != null && !TextUtils.isEmpty(this.mCameraDevice.getModel()) && !TextUtils.isEmpty(this.mCameraDevice.getDid())) {
            this.mSurfaceViewScale = this.mVideoView.O00000o();
            if (this.mSurfaceViewScale >= this.mVideoView.O00000o0()) {
                gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "scale", this.mSurfaceViewScale);
                this.mSurfaceViewOffsetX = this.mVideoView.O00000oO();
                gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "offsetX", this.mSurfaceViewOffsetX);
                this.mSurfaceViewOffsetY = this.mVideoView.O00000oo();
                gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "offsetY", this.mSurfaceViewOffsetY);
            } else {
                gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "scale", 1.0f);
                gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "offsetX", 0.0f);
                gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "offsetY", 0.0f);
            }
            gpy.O00000Oo(gkv.f17949O000000o, this.md5Name, "video_View_scaleX", this.mSurfaceViewScaleX);
            gpy.O000000o(gkv.f17949O000000o, this.md5Name, "SP_KEY_SCALE_IS_MINISCALE", this.isMinScale);
        }
        this.operationProvider.O00000oO();
        super.onDestroy();
        chr.O00000Oo();
    }

    public void onServerCmd(int i, byte[] bArr) {
        String optString;
        if (!isFinishing()) {
            if (i == 61442) {
                try {
                    String str = new String(bArr);
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("id", -1);
                    gsy.O00000Oo("CameraPlayerNewActivity", "id ".concat(str));
                    if (optInt == this.mLastSetStart && (optString = jSONObject.optString("status", null)) != null) {
                        if (optString.equals("filenotfound")) {
                            this.mSelectTime = (long) (this.mLastSetStart + 60);
                            gsy.O00000Oo("CameraPlayerNewActivity", " onServerCmd file not find to alive");
                        } else if (optString.equals("readerror")) {
                            long optInt2 = (((long) jSONObject.optInt("starttime")) * 1000) + 61000;
                            this.mCameraDevice.O0000OOo().O000000o(optInt2);
                            if (this.mCameraDevice != null && this.mCameraDevice.O00000o()) {
                                this.mCameraDevice.O0000Oo0().O000000o(optInt2);
                            }
                        }
                    }
                } catch (Exception e) {
                    gsy.O000000o(6, "CameraPlayerNewActivity", e.toString());
                }
            } else if (i == 61446 || i == 275) {
                String str2 = new String(bArr);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        runOnUiThread(new Runnable(new JSONObject(str2)) {
                            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$ezkOdVneDJxe1QGqxgsRpuuK8E */
                            private final /* synthetic */ JSONObject f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                CameraPlayerNewActivity.this.lambda$onServerCmd$39$CameraPlayerNewActivity(this.f$1);
                            }
                        });
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void doResume() {
        this.mPauseView.setVisibility(8);
        if (this.mCameraDevice != null && this.mCameraPlayerEx != null) {
            setPlayTime();
        }
    }

    private void videoClick() {
        if (this.mFullScreen) {
            if (this.mLandLayout.getVisibility() == 0) {
                if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O00000Oo()) {
                    this.dcvDirectionCtrlLandscapeContainer.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_direction_view_out));
                }
                this.dcvDirectionCtrlLandscapeContainer.setVisibility(8);
                this.mLLRightCtrlLandscape.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_ctrl_view_x_trans_out));
                this.mLLRightCtrlLandscape.setVisibility(8);
                this.flTopCtrlLandscape.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_direction_view_out2));
                this.flTopCtrlLandscape.setVisibility(4);
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$V_1XtqMy3Bw4Y36S5P_sA30owI */

                    public final void run() {
                        CameraPlayerNewActivity.this.lambda$videoClick$40$CameraPlayerNewActivity();
                    }
                }, 300);
                return;
            }
            this.mLandLayout.setVisibility(0);
            if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O00000Oo()) {
                this.dcvDirectionCtrlLandscapeContainer.setVisibility(8);
            } else {
                this.dcvDirectionCtrlLandscapeContainer.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_direction_view_in));
                this.dcvDirectionCtrlLandscapeContainer.setVisibility(0);
            }
            this.mLLRightCtrlLandscape.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_ctrl_view_x_trans_in));
            this.mLLRightCtrlLandscape.setVisibility(0);
            this.flTopCtrlLandscape.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_direction_view_in2));
            this.flTopCtrlLandscape.setVisibility(0);
        } else if (this.mLLVideoViewBottomCtrl.getTranslationY() > 0.0f) {
            bottomCtrlAnimUp();
        } else {
            dismissBottomCtrlVisibilityGoneRunnable(0);
        }
    }

    public /* synthetic */ void lambda$videoClick$40$CameraPlayerNewActivity() {
        this.mLandLayout.setVisibility(8);
    }

    public void bottomCtrlAnimUp() {
        LinearLayout linearLayout = this.mLLVideoViewBottomCtrl;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", (float) linearLayout.getHeight(), 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
        dismissBottomCtrlVisibilityGoneRunnable(5000);
    }

    public void bottomCtrlAnimDown() {
        if (this.mLLVideoViewBottomCtrl.getTranslationY() <= 0.0f) {
            LinearLayout linearLayout = this.mLLVideoViewBottomCtrl;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", 0.0f, (float) linearLayout.getHeight());
            ofFloat.setDuration(200L);
            ofFloat.start();
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
        if (this.isSnapshotting) {
            gqg.O000000o((int) R.string.btn_click_too_much);
            return;
        }
        this.isSnapshotting = true;
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
            this.isSnapshotting = false;
        } else if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
            this.isSnapshotting = false;
        } else if (this.mCameraDevice == null || this.mCameraDevice.O000000o() == null || !this.mCameraDevice.O000000o().O000000o("power", true)) {
            this.isSnapshotting = false;
            gqg.O000000o((int) R.string.power_off);
        } else if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000Oo()) {
            this.isSnapshotting = false;
            gqg.O000000o((int) R.string.snap_failed_paused);
        } else {
            this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$tM5hvcWSheMDEV5NFWHGQzFlxvc */

                public final void onSnap(Bitmap bitmap) {
                    CameraPlayerNewActivity.this.lambda$snapShot$42$CameraPlayerNewActivity(bitmap);
                }
            });
        }
    }

    public /* synthetic */ void lambda$snapShot$42$CameraPlayerNewActivity(Bitmap bitmap) {
        goq.O000000o(new Runnable(bitmap) {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$yZUobUGu4sp4YL6uC5xjlmm_D0 */
            private final /* synthetic */ Bitmap f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CameraPlayerNewActivity.this.lambda$null$41$CameraPlayerNewActivity(this.f$1);
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
    public void lambda$null$41$CameraPlayerNewActivity(Bitmap bitmap) {
        String O000000o2 = me.O000000o(false, this.mCameraDevice.getDid());
        if (O000000o2 == null || bitmap == null) {
            this.isSnapshotting = false;
            return;
        }
        if ("cn".equalsIgnoreCase(ftl.O000000o())) {
            bitmap = C0118cif.O000000o(bitmap, this);
        }
        if (bitmap != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(O000000o2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
            } catch (IOException unused) {
                this.isSnapshotting = false;
                return;
            }
        }
        int O000000o3 = gpc.O000000o(100.0f);
        runOnUiThread(new Runnable(O000000o2, Bitmap.createScaledBitmap(bitmap, O000000o3, (bitmap.getHeight() * O000000o3) / bitmap.getWidth(), false)) {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$WKDoy5Vx3xdMOwtZrR6XAPjLVfk */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Bitmap f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CameraPlayerNewActivity.this.lambda$onSnapShot$44$CameraPlayerNewActivity(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$onSnapShot$44$CameraPlayerNewActivity(String str, Bitmap bitmap) {
        if (new File(str).exists()) {
            resetLeftTopTools();
            this.tvShortPlay.setVisibility(8);
            this.mLLFuncPopup.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_snap_shot_in));
            this.mLLFuncPopup.setVisibility(0);
            dismissSnapshotPopupRunnable(3000);
            if (bitmap != null) {
                this.ivShotPic.setImageBitmap(bitmap);
            }
            ContentValues contentValues = new ContentValues(4);
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("_data", str);
            contentValues.put("mime_type", "image/jpeg");
            try {
                if (!Build.MODEL.equals("HM 1SC")) {
                    getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                }
                gsy.O00000Oo("CameraPlayerNewActivity", "snap success");
                this.isSnapshotting = false;
                clj.O000000o O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str);
                if (O00000Oo != null) {
                    this.ivShotPic.setOnClickListener(new View.OnClickListener(O00000Oo) {
                        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$DXAgR_on54qvLP5_VQUC8L6nws */
                        private final /* synthetic */ clj.O000000o f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            CameraPlayerNewActivity.this.lambda$null$43$CameraPlayerNewActivity(this.f$1, view);
                        }
                    });
                }
            } catch (Throwable unused) {
                this.isSnapshotting = false;
            }
        } else {
            this.isSnapshotting = false;
        }
    }

    public /* synthetic */ void lambda$null$43$CameraPlayerNewActivity(clj.O000000o o000000o, View view) {
        if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
            dismissSnapshotPopupRunnable(0);
            Intent intent = new Intent(this, LocalPicActivity.class);
            intent.putExtra("file_path", o000000o.O00000o);
            startActivity(intent);
        }
    }

    private void dismissSnapshotPopupRunnable(long j) {
        this.mHandler.removeCallbacks(this.snapshotRunnable);
        this.mHandler.postDelayed(this.snapshotRunnable, j);
    }

    public void dismissBottomCtrlVisibilityGoneRunnable(long j) {
        this.mHandler.removeCallbacks(this.bottomCtrlVisibilityGoneRunnable);
        this.mHandler.postDelayed(this.bottomCtrlVisibilityGoneRunnable, j);
    }

    public void onVideoRecorded(String str) {
        File file = new File(str);
        if (file.exists()) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            clj.O000000o O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str);
            if (O00000Oo != null && this.mVideoView != null) {
                this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback(O00000Oo) {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$lKq7uBaRPwu1A3QvankTNbUeXl4 */
                    private final /* synthetic */ clj.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onSnap(Bitmap bitmap) {
                        CameraPlayerNewActivity.this.lambda$onVideoRecorded$47$CameraPlayerNewActivity(this.f$1, bitmap);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onVideoRecorded$47$CameraPlayerNewActivity(clj.O000000o o000000o, Bitmap bitmap) {
        int O000000o2 = gpc.O000000o(100.0f);
        if (bitmap != null) {
            runOnUiThread(new Runnable(Bitmap.createScaledBitmap(bitmap, O000000o2, (bitmap.getHeight() * O000000o2) / bitmap.getWidth(), false), o000000o) {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$xWoeM8j0IODPs3BD_EZVicIshcc */
                private final /* synthetic */ Bitmap f$1;
                private final /* synthetic */ clj.O000000o f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    CameraPlayerNewActivity.this.lambda$null$46$CameraPlayerNewActivity(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$46$CameraPlayerNewActivity(Bitmap bitmap, clj.O000000o o000000o) {
        if (bitmap != null) {
            this.ivShotPic.setImageBitmap(bitmap);
            resetLeftTopTools();
            this.tvShortPlay.setVisibility(0);
            this.tvShortPlay.setText(this.tvRecordTimerLand.getText());
            this.mLLFuncPopup.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_snap_shot_in));
            this.mLLFuncPopup.setVisibility(0);
            dismissSnapshotPopupRunnable(3000);
            this.ivShotPic.setOnClickListener(new View.OnClickListener(o000000o) {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$nUSecsScId3SXE1OZ1aDnFEWgE */
                private final /* synthetic */ clj.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CameraPlayerNewActivity.this.lambda$null$45$CameraPlayerNewActivity(this.f$1, view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$45$CameraPlayerNewActivity(clj.O000000o o000000o, View view) {
        if (canStepOut(R.string.speaking_block, R.string.recording_block)) {
            dismissSnapshotPopupRunnable(0);
            Intent intent = new Intent();
            intent.putExtra("file_path", o000000o.O00000o);
            intent.setClass(this, LocalPicActivity.class);
            startActivity(intent);
        }
    }

    private void toggleResolution() {
        if (this.mIsResumed) {
            chr.O000000o(chr.O000oO0o);
            if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O00000Oo()) {
                gqg.O000000o((int) R.string.history_video_resolution_hd_only);
            } else if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O0000O0o()) {
                gqg.O000000o((int) R.string.record_resolution_block);
            } else if (!this.resolutionDialogShowing) {
                chr.O000000o(chr.O0000OOo);
                this.resolutionDialogShowing = true;
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
                builder.O000000o((int) R.string.quality_choice);
                String[] strArr = {getString(R.string.quality_auto), getString(R.string.chuangmi_quality_low_dialog), getString(R.string.chuangmi_quality_fhd_dialog)};
                if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
                    strArr = new String[]{getString(R.string.quality_auto), getString(R.string.chuangmi_quality_low_dialog480), getString(R.string.chuangmi_quality_fhd2K_dialog)};
                } else if (DeviceConstant.is2K(this.mCameraDevice.getModel())) {
                    strArr = new String[]{getString(R.string.quality_auto), getString(R.string.chuangmi_quality_low_dialog), getString(R.string.chuangmi_quality_fhd2K_dialog)};
                }
                this.selectedIndex = this.mCameraDevice.O00000oO().O0000o00;
                if (this.selectedIndex == 3) {
                    this.selectedIndex = 2;
                }
                builder.O000000o(new MLAlertDialog.O000000o() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass40 */

                    public void beforeDismissCallBack() {
                    }

                    public void afterDismissCallBack() {
                        CameraPlayerNewActivity.this.resolutionDialogShowing = false;
                    }
                });
                builder.O000000o(strArr, this.selectedIndex, new DialogInterface.OnClickListener(strArr) {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$FNL2DSZGc0SOZpqr04n2OVjlDA */
                    private final /* synthetic */ String[] f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CameraPlayerNewActivity.this.lambda$toggleResolution$48$CameraPlayerNewActivity(this.f$1, dialogInterface, i);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, $$Lambda$CameraPlayerNewActivity$98uW1l22oToMtSMHjsFkJ3o3hyc.INSTANCE).O00000oo();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.chr.O000000o(int, int, long):void
      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
    public /* synthetic */ void lambda$toggleResolution$48$CameraPlayerNewActivity(String[] strArr, DialogInterface dialogInterface, int i) {
        this.selectedIndex = i;
        dialogInterface.dismiss();
        int i2 = this.selectedIndex;
        if (i2 >= 0 && i2 < strArr.length && !TextUtils.isEmpty(strArr[i2])) {
            int i3 = this.selectedIndex;
            if (i3 == 0) {
                chr.O000000o(chr.O000oO, "type", (Object) 1);
            } else if (i3 == 1) {
                chr.O000000o(chr.O000oO, "type", (Object) 2);
            } else if (i3 == 2) {
                chr.O000000o(chr.O000oO, "type", (Object) 3);
            }
            setResolutionText(this.selectedIndex);
            if (this.selectedIndex == 2) {
                this.selectedIndex = 3;
            }
            this.mCameraDevice.O00000oO().O000000o(this.selectedIndex);
            if (this.mCameraPlayerEx != null) {
                this.mCameraPlayerEx.O000000o(this.selectedIndex);
            }
        }
    }

    public void upDateTimeTitle(String str) {
        this.mTVRecordTimer.setText(str);
        this.tvRecordTimerLand.setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: parseAngle */
    public void lambda$onServerCmd$39$CameraPlayerNewActivity(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("angle");
            int optInt2 = jSONObject.optInt("ret");
            int optInt3 = jSONObject.optInt("elevation");
            gsy.O00000Oo("CameraPlayerNewActivity", "ret " + optInt2 + " angele " + optInt + " elevation " + optInt3);
            if (optInt2 < 0) {
                if (optInt2 == -5) {
                    gqg.O000000o((int) R.string.calibrating);
                } else if (this.mHintView.getVisibility() != 0) {
                    this.mHintView.setVisibility(0);
                }
                this.mHandler.removeMessages(1002);
                this.mHandler.sendEmptyMessageDelayed(1002, 1000);
                return;
            }
            float f = (float) ((-optInt) + 101);
            float f2 = (float) ((-optInt3) + 101);
            this.mAVCamera.setCoordinate(f, f2);
            this.mAVCameraLandscape.setCoordinate(f, f2);
            this.mHandler.removeMessages(1002);
            this.mHandler.sendEmptyMessage(1002);
            if (this.curPosition != null && this.curPositionView != null) {
                cki.O00000o("CameraPlayerNewActivity", "curPosition h-v=" + this.curPosition.O00000o0 + " - " + this.curPosition.O00000o);
                if (optInt > this.curPosition.O00000o0 - 2 && optInt < this.curPosition.O00000o0 + 2 && optInt3 > this.curPosition.O00000o - 2 && optInt3 < this.curPosition.O00000o + 2) {
                    cki.O00000o("CameraPlayerNewActivity", "update img by parseAngle h-v=" + optInt + " - " + optInt3);
                    this.curPositionView.updateImg(this.mCameraDevice.getDid(), this.mCameraDevice.getModel(), this.curPosition.f13873O000000o);
                    this.curPosition = null;
                    this.curPositionView = null;
                }
            }
        }
    }

    public void detectSpecSDCard() {
        Object propertyValueFromCache = getPropertyValueFromCache("memory-card-management", "status");
        if (propertyValueFromCache != null) {
            this.mSdcardDetectResult.sdcardStatus = ((Integer) propertyValueFromCache).intValue();
            this.mCameraDevice.O00000oO();
            this.mSdcardDetectResult.sdcardGetSuccess = true;
        } else {
            CameraActivityUtils.SdcardDetectResult sdcardDetectResult = this.mSdcardDetectResult;
            sdcardDetectResult.sdcardStatus = 1;
            sdcardDetectResult.sdcardGetSuccess = false;
        }
        updateOperationView();
    }

    private void invisibleChildren() {
        for (int i = 0; i < this.ll_yuzhiwei.getChildCount(); i++) {
            this.ll_yuzhiwei.getChildAt(i).setVisibility(4);
        }
    }

    private void unSelectedChildren() {
        for (int i = 0; i < this.ll_yuzhiwei.getChildCount(); i++) {
            this.ll_yuzhiwei.getChildAt(i).setSelected(false);
        }
    }

    public void onConnected() {
        super.onConnected();
        getPreSetPositionWrapper();
        this.isConnected = true;
    }

    public void getPreSetPositionWrapper() {
        if (this.mCameraDevice != null && this.isPresetPositionVersion && "chuangmi.camera.ipc021".equals(this.mCameraDevice.getModel())) {
            long currentTimeMillis = System.currentTimeMillis() - this.getPreSetPositionTime;
            if (currentTimeMillis >= 1000 || currentTimeMillis <= 0) {
                getPreSetPositions();
            } else {
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$nN6usLlosIK5IrFDoCSaXNN2nrE */

                    public final void run() {
                        CameraPlayerNewActivity.this.getPreSetPositions();
                    }
                }, currentTimeMillis);
            }
        }
    }

    /* access modifiers changed from: private */
    public void getPreSetPositions() {
        chz O0000Ooo = this.mCameraDevice.O0000Ooo();
        AnonymousClass41 r1 = new chz.O00000o0() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass41 */

            public void onReceived(List<chz.O00000o> list) {
                if (!CameraPlayerNewActivity.this.isFinishing()) {
                    CameraPlayerNewActivity.this.runOnUiThread(new Runnable(list) {
                        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$41$m6T0gQnPaU5UOoHyEDDrYmX_6rg */
                        private final /* synthetic */ List f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CameraPlayerNewActivity.AnonymousClass41.this.lambda$onReceived$1$CameraPlayerNewActivity$41(this.f$1);
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onReceived$1$CameraPlayerNewActivity$41(List list) {
                CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                cameraPlayerNewActivity.positions = list;
                if (cameraPlayerNewActivity.positions == null) {
                    CameraPlayerNewActivity.this.positions = new ArrayList();
                    return;
                }
                Collections.sort(CameraPlayerNewActivity.this.positions, $$Lambda$CameraPlayerNewActivity$41$qyPSg6_cJT0MshyPLjxeL_E9Zo.INSTANCE);
                CameraPlayerNewActivity cameraPlayerNewActivity2 = CameraPlayerNewActivity.this;
                cameraPlayerNewActivity2.matchPositions(cameraPlayerNewActivity2.positions);
            }

            static /* synthetic */ int lambda$null$0(chz.O00000o o00000o, chz.O00000o o00000o2) {
                if (o00000o.O00000oO > o00000o2.O00000oO) {
                    return 1;
                }
                return o00000o.O00000oO < o00000o2.O00000oO ? -1 : 0;
            }

            public void onError(String str, int i) {
                if (!CameraPlayerNewActivity.this.isFinishing()) {
                    cki.O00000oO("CameraPlayerNewActivity", str + " " + i);
                }
            }
        };
        JSONArray jSONArray = new JSONArray();
        civ.O000000o(chz.f13865O000000o, "getPreSetPositions start");
        O0000Ooo.O00000o0.callMethod("get_preset_position", jSONArray, new Callback<String>(r1) {
            /* class _m_j.chz.AnonymousClass3 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000o0 f13868O000000o;

            {
                this.f13868O000000o = r2;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                civ.O000000o(chz.f13865O000000o, str);
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("result");
                    this.f13868O000000o.onReceived((ArrayList) new Gson().fromJson(jSONArray.toString(), new TypeToken<ArrayList<O00000o>>() {
                        /* class _m_j.chz.AnonymousClass3.AnonymousClass1 */
                    }.getType()));
                } catch (Exception e) {
                    civ.O00000o0(chz.f13865O000000o, e.toString());
                    this.f13868O000000o.onError(e.toString(), -9999);
                }
            }

            public final void onFailure(int i, String str) {
                String str2 = chz.f13865O000000o;
                civ.O000000o(str2, str + "--" + i);
                this.f13868O000000o.onError(str, i);
            }
        }, new Parser<String>() {
            /* class _m_j.chz.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                return str;
            }
        });
        this.getPreSetPositionTime = System.currentTimeMillis();
    }

    public void matchPositions(List<chz.O00000o> list) {
        if (!isFinishing()) {
            invisibleChildren();
            int i = 0;
            for (chz.O00000o next : list) {
                if (next.O00000Oo != 0) {
                    PreSetPositionView preSetPositionView = (PreSetPositionView) this.ll_yuzhiwei.getChildAt(i);
                    preSetPositionView.setmVideoView(this.mVideoView);
                    preSetPositionView.setTag(next);
                    preSetPositionView.setNormalState(this.mCameraDevice.getDid(), this.mCameraDevice.getModel(), new PreSetPositionView.OnUpdatePicListener(preSetPositionView) {
                        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$wl4fksZD6vBF5_dzzEhWbDBMddk */
                        private final /* synthetic */ PreSetPositionView f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onUpdate(chz.O00000o o00000o) {
                            CameraPlayerNewActivity.this.lambda$matchPositions$50$CameraPlayerNewActivity(this.f$1, o00000o);
                        }
                    });
                    preSetPositionView.setEditStateListener(new PreSetPositionView.OnDeletePicListener(list, next) {
                        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$HBUJhibvZafxgq5VxRFI8uGOMM */
                        private final /* synthetic */ List f$1;
                        private final /* synthetic */ chz.O00000o f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onDelete(chz.O00000o o00000o) {
                            CameraPlayerNewActivity.this.lambda$matchPositions$51$CameraPlayerNewActivity(this.f$1, this.f$2, o00000o);
                        }
                    });
                    preSetPositionView.setVisibility(0);
                    i++;
                }
            }
            chr.O000000o("8fq.a57.2w9.yz3", "num", Integer.valueOf(i));
            if (i > 0) {
                this.iv_preset_edit.setEnabled(true);
                this.iv_preset_edit.setSelected(((PreSetPositionView) this.ll_yuzhiwei.getChildAt(0)).editEnable);
                if (!this.iv_preset_edit.isSelected()) {
                    this.iv_panoramic_edit.setVisibility(4);
                } else if (this.iv_panoramic_mask.getVisibility() == 0) {
                    this.iv_panoramic_edit.setVisibility(0);
                }
            } else if (this.iv_panoramic_mask.getVisibility() != 0) {
                this.iv_preset_edit.setSelected(false);
                this.iv_panoramic_edit.setVisibility(4);
                this.iv_preset_edit.setEnabled(false);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    ((PreSetPositionView) this.ll_yuzhiwei.getChildAt(i2)).setEditEnable(false);
                }
            }
            if (i < 3) {
                PreSetPositionView preSetPositionView2 = (PreSetPositionView) this.ll_yuzhiwei.getChildAt(i);
                preSetPositionView2.setmVideoView(this.mVideoView);
                preSetPositionView2.setAddState(new View.OnClickListener(list, preSetPositionView2) {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$tmNyPQv2tuUn1TSIS4yvdaDkScs */
                    private final /* synthetic */ List f$1;
                    private final /* synthetic */ PreSetPositionView f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        CameraPlayerNewActivity.this.lambda$matchPositions$53$CameraPlayerNewActivity(this.f$1, this.f$2, view);
                    }
                });
                preSetPositionView2.setVisibility(0);
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
    public /* synthetic */ void lambda$matchPositions$50$CameraPlayerNewActivity(PreSetPositionView preSetPositionView, chz.O00000o o00000o) {
        chr.O000000o("8fq.a57.2w9.yz2");
        if (this.mCameraDevice.O000000o().O000000o("power", true)) {
            this.curPosition = o00000o;
            this.curPositionView = preSetPositionView;
            cki.O00000o("CameraPlayerNewActivity", "h-v=" + this.curPosition.O00000o0 + " - " + this.curPosition.O00000o);
            unSelectedChildren();
            preSetPositionView.setSelected(true);
            this.mCameraDevice.O0000Ooo().O000000o(new chz.O00000Oo() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass42 */

                public void onSuccess(String str) {
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        try {
                            int optInt = new JSONObject(str).optInt("result", -1);
                            if (optInt == -4) {
                                CameraPlayerNewActivity.this.runOnUiThread($$Lambda$CameraPlayerNewActivity$42$SMbqkZbUs1wHhZEZjWEmHxHgUE.INSTANCE);
                            } else if (optInt == -3) {
                                CameraPlayerNewActivity.this.getPreSetPositionWrapper();
                            } else if (optInt != 0) {
                                cki.O00000oO("CameraPlayerNewActivity", "ctrl = " + optInt + " ");
                            } else if (!(CameraPlayerNewActivity.this.curPosition == null || CameraPlayerNewActivity.this.curPositionView == null)) {
                                cki.O00000o("CameraPlayerNewActivity", "update img by callback");
                                CameraPlayerNewActivity.this.curPositionView.updateImg(CameraPlayerNewActivity.this.mCameraDevice.getDid(), CameraPlayerNewActivity.this.mCameraDevice.getModel(), CameraPlayerNewActivity.this.curPosition.f13873O000000o);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                        cameraPlayerNewActivity.curPosition = null;
                        cameraPlayerNewActivity.curPositionView = null;
                    }
                }

                public void onError(String str, int i) {
                    cki.O00000oO("CameraPlayerNewActivity", str + " " + i);
                }
            }, "ctrl", o00000o.f13873O000000o);
        } else if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
            gqg.O00000Oo((int) R.string.camera_closed_wulizhebi_tip);
        } else {
            gqg.O00000Oo((int) R.string.power_off);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public /* synthetic */ void lambda$matchPositions$51$CameraPlayerNewActivity(final List list, final chz.O00000o o00000o, final chz.O00000o o00000o2) {
        if (this.mCameraDevice.isReadOnlyShared()) {
            gqg.O000000o((int) R.string.cloud_share_hint);
        } else if (this.mCameraDevice.O000000o().O000000o("power", true)) {
            chr.O000000o("8fq.a57.2w9.yz4");
            this.mCameraDevice.O0000Ooo().O000000o(new chz.O00000Oo() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass43 */
                static final /* synthetic */ boolean $assertionsDisabled = false;

                static {
                    Class<CameraPlayerNewActivity> cls = CameraPlayerNewActivity.class;
                }

                public void onSuccess(String str) {
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        try {
                            int optInt = new JSONObject(str).optInt("result", -1);
                            if (optInt == -4) {
                                CameraPlayerNewActivity.this.runOnUiThread($$Lambda$CameraPlayerNewActivity$43$Ho9FI8eW1gCDi7KSUWtsOxOedzE.INSTANCE);
                            } else if (optInt == -3) {
                                CameraPlayerNewActivity.this.getPreSetPositionWrapper();
                            } else if (optInt != 0) {
                                CameraPlayerNewActivity.this.runOnUiThread($$Lambda$CameraPlayerNewActivity$43$jBmTf4wQ8Sig8z8FgMdPaR6otXg.INSTANCE);
                            } else {
                                o00000o2.O00000Oo = 0;
                                CameraPlayerNewActivity.this.matchPositions(list);
                                CameraPlayerNewActivity.this.runOnUiThread($$Lambda$CameraPlayerNewActivity$43$cZbGHlihrqmc3q5kKqfkSiaRoVM.INSTANCE);
                                try {
                                    File file = new File(me.O000000o(CameraPlayerNewActivity.this.mCameraDevice.getDid(), CameraPlayerNewActivity.this.mCameraDevice.getModel(), o00000o.f13873O000000o));
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                } catch (Exception e) {
                                    cki.O00000oO("CameraPlayerNewActivity", e.toString());
                                }
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                public void onError(String str, int i) {
                    cki.O00000oO("CameraPlayerNewActivity", str + " " + i);
                    if (!CameraPlayerNewActivity.this.isFinishing()) {
                        CameraPlayerNewActivity.this.runOnUiThread($$Lambda$CameraPlayerNewActivity$43$8gyAJqfOY8Q_MteKsrV7pmfMQtY.INSTANCE);
                    }
                }
            }, "del", o00000o2.f13873O000000o);
        } else if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
            gqg.O00000Oo((int) R.string.camera_closed_wulizhebi_tip);
        } else {
            gqg.O00000Oo((int) R.string.power_off);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public /* synthetic */ void lambda$matchPositions$53$CameraPlayerNewActivity(List list, final PreSetPositionView preSetPositionView, View view) {
        if (this.mCameraDevice.isReadOnlyShared()) {
            gqg.O000000o((int) R.string.cloud_share_hint);
            return;
        }
        final int i = 1;
        if (this.mCameraDevice.O000000o().O000000o("power", true)) {
            Collections.sort(list, $$Lambda$CameraPlayerNewActivity$gDdTgxOQODkteaXlz8O18nbbLL4.INSTANCE);
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (((chz.O00000o) list.get(i2)).O00000Oo == 0) {
                    i = ((chz.O00000o) list.get(i2)).f13873O000000o;
                    break;
                } else {
                    i2++;
                }
            }
            if (i > 0) {
                chr.O000000o("8fq.a57.2w9.yz1");
                this.mCameraDevice.O0000Ooo().O000000o(new chz.O00000Oo() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass44 */

                    public void onSuccess(String str) {
                        if (!CameraPlayerNewActivity.this.isFinishing()) {
                            try {
                                int optInt = new JSONObject(str).optInt("result", -1);
                                if (optInt != -4) {
                                    if (optInt != -3) {
                                        if (optInt == -2) {
                                            CameraPlayerNewActivity.this.runOnUiThread($$Lambda$CameraPlayerNewActivity$44$iZrcTLdlL3TaLDrX2fqkAWJWmo.INSTANCE);
                                            return;
                                        } else if (optInt != 0) {
                                            CameraPlayerNewActivity.this.runOnUiThread($$Lambda$CameraPlayerNewActivity$44$sVxbouQNg59FIYlrXSUp5lCd4s.INSTANCE);
                                            return;
                                        }
                                    }
                                    CameraPlayerNewActivity.this.getPreSetPositionWrapper();
                                    CameraPlayerNewActivity.this.runOnUiThread(new Runnable(preSetPositionView, i) {
                                        /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$44$njOGu6ZWNOGQwnqwQzFhBLGd0 */
                                        private final /* synthetic */ PreSetPositionView f$1;
                                        private final /* synthetic */ int f$2;

                                        {
                                            this.f$1 = r2;
                                            this.f$2 = r3;
                                        }

                                        public final void run() {
                                            CameraPlayerNewActivity.AnonymousClass44.this.lambda$onSuccess$0$CameraPlayerNewActivity$44(this.f$1, this.f$2);
                                        }
                                    });
                                    return;
                                }
                                CameraPlayerNewActivity.this.runOnUiThread($$Lambda$CameraPlayerNewActivity$44$398YpyMrwGPZ2mLzfoEUfuDGso.INSTANCE);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    public /* synthetic */ void lambda$onSuccess$0$CameraPlayerNewActivity$44(PreSetPositionView preSetPositionView, int i) {
                        preSetPositionView.updateImg(CameraPlayerNewActivity.this.mCameraDevice.getDid(), CameraPlayerNewActivity.this.mCameraDevice.getModel(), i);
                    }

                    public void onError(String str, int i) {
                        cki.O00000oO("CameraPlayerNewActivity", str + " " + i);
                        if (!CameraPlayerNewActivity.this.isFinishing()) {
                            if (i == -2) {
                                CameraPlayerNewActivity.this.runOnUiThread($$Lambda$CameraPlayerNewActivity$44$jy_Cr5HBRP6lJJuB2EHnXgZHsy8.INSTANCE);
                            } else {
                                CameraPlayerNewActivity.this.runOnUiThread(new Runnable(str, i) {
                                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$44$5afp6f4r0_Kw1O9kTz6h7BrH13o */
                                    private final /* synthetic */ String f$1;
                                    private final /* synthetic */ int f$2;

                                    {
                                        this.f$1 = r2;
                                        this.f$2 = r3;
                                    }

                                    public final void run() {
                                        CameraPlayerNewActivity.AnonymousClass44.this.lambda$onError$5$CameraPlayerNewActivity$44(this.f$1, this.f$2);
                                    }
                                });
                            }
                        }
                    }

                    public /* synthetic */ void lambda$onError$5$CameraPlayerNewActivity$44(String str, int i) {
                        gqg.O00000Oo(CameraPlayerNewActivity.this.getString(R.string.preset_position_add_failed2) + str + " code:" + i);
                    }
                }, "set", i);
            }
        } else if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
            gqg.O00000Oo((int) R.string.camera_closed_wulizhebi_tip);
        } else {
            gqg.O00000Oo((int) R.string.power_off);
        }
    }

    static /* synthetic */ int lambda$null$52(chz.O00000o o00000o, chz.O00000o o00000o2) {
        if (o00000o.f13873O000000o > o00000o2.f13873O000000o) {
            return 1;
        }
        return o00000o.f13873O000000o < o00000o2.f13873O000000o ? -1 : 0;
    }

    public void detectSDCard() {
        if (this.mCameraDevice != null) {
            if (this.mCameraSpecDevice != null) {
                toDetectSpecSDCard();
            } else {
                CameraActivityUtils.detectSDCard(this, this.mCameraDevice, this.mSdcardDetectResult);
            }
        }
    }

    public void showSDCardHintDialog() {
        if (this.mIsResumed) {
            this.mSDCardHintDialog = new SDCardHintDialog(this, R.style.popupDialog);
            this.mSDCardHintDialog.show();
            this.mSDCardHintDialog.setCancelable(true);
            this.mCameraDevice.O00000oO().O0000Oo0 = false;
        }
    }

    private void checkMinLevel() {
        if (this.mCameraDevice.O000000o().O000000o("mini_level") > 1) {
            showUpdateDlg(false);
        }
    }

    private void startCallAnim() {
        chr.O0000Oo0();
    }

    private void stopCallAnim() {
        chr.O0000Oo();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.mIsInit) {
            this.mIsInit = true;
            if (this.mCameraDevice.O00000oO().O00000oO) {
                initGuideCenter();
            }
        }
    }

    public void initGuideCenter() {
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$V7sjUQmwBKkHtmx_AJppCWxdANE */

            public final void run() {
                CameraPlayerNewActivity.this.lambda$initGuideCenter$55$CameraPlayerNewActivity();
            }
        }, 1000);
        clk O00000oO = this.mCameraDevice.O00000oO();
        if (O00000oO.O00000oO) {
            O00000oO.O00000oO = false;
            O00000oO.O00000Oo.edit().putBoolean("need_guide2", false).apply();
        }
    }

    public /* synthetic */ void lambda$initGuideCenter$55$CameraPlayerNewActivity() {
        MIDrawerLayout2 mIDrawerLayout2 = this.mRLDirectionCtl;
        if (mIDrawerLayout2 != null) {
            mIDrawerLayout2.toggleDrawer();
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$ZaA5ECj4bIP9xSW5lbldlscB2Yc */

                public final void run() {
                    CameraPlayerNewActivity.this.lambda$null$54$CameraPlayerNewActivity();
                }
            }, 1000);
        }
    }

    public /* synthetic */ void lambda$null$54$CameraPlayerNewActivity() {
        MIDrawerLayout2 mIDrawerLayout2 = this.mRLDirectionCtl;
        if (mIDrawerLayout2 != null) {
            mIDrawerLayout2.toggleDrawer();
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
        if (!this.mCameraDevice.isShared() && this.mCameraDevice.O00000oO().O00000oo) {
            this.mIsInit = true;
            this.mNeedLicense = true;
            LocalLicenseUtil.LocalLicense v4LocalLicense = LocalLicenseUtil.getV4LocalLicense(getResources(), this.mCameraDevice.getModel());
            if (v4LocalLicense.mLicense <= 0 || v4LocalLicense.mPrivacy <= 0) {
                gsy.O00000Oo("CameraPlay", "load raw fail");
                this.mCameraDevice.O00000oO().O00000oO(false);
                if (this.mCameraDevice.O00000oO().O00000oO) {
                    initGuideCenter();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            if (!"cn".equalsIgnoreCase(ftl.O000000o()) || TextUtils.isEmpty(v4LocalLicense.mPlan)) {
                intent.putExtra("enable_privacy_setting", false);
            } else {
                intent.putExtra("enable_privacy_setting", true);
                intent.putExtra("usrExpPlanContent", Html.fromHtml(v4LocalLicense.mPlan));
            }
            if (this.mDeviceStat != null && !TextUtils.isEmpty(this.mDeviceStat.did)) {
                hyv.O000000o().showUserLicenseDialog(this, this.mDid, this.mDeviceStat.name, getString(R.string.licences_content), v4LocalLicense.mLicense, getString(R.string.privacy_content), v4LocalLicense.mPrivacy, new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass45 */

                    public void onClick(View view) {
                        CameraPlayerNewActivity cameraPlayerNewActivity = CameraPlayerNewActivity.this;
                        cameraPlayerNewActivity.mNeedLicense = false;
                        cameraPlayerNewActivity.mHandler.removeMessages(2100);
                        CameraPlayerNewActivity.this.mHandler.sendEmptyMessage(2100);
                        CameraPlayerNewActivity.this.mHandler.sendEmptyMessage(3051);
                        CameraPlayerNewActivity.this.mHandler.sendEmptyMessage(3052);
                        if (CameraPlayerNewActivity.this.mCameraDevice != null) {
                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000oO(false);
                            if (CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000oO) {
                                CameraPlayerNewActivity.this.initGuideCenter();
                            }
                            boolean isUsrExpPlanEnabled = XmPluginHostApi.instance().isUsrExpPlanEnabled(CameraPlayerNewActivity.this.mDid);
                            chr.O00Ooo0O = isUsrExpPlanEnabled;
                            CameraPlayerNewActivity.this.mCameraDevice.O000000o(isUsrExpPlanEnabled);
                        }
                    }
                }, intent);
            }
        }
    }

    private void toggleSpeed() {
        if (this.mCameraPlayerEx == null) {
            return;
        }
        if (this.mCameraPlayerEx.O0000Ooo()) {
            int O0000oOO = this.mCameraPlayerEx.O0000oOO();
            gsy.O00000Oo("CameraPlayerNewActivity", "speed:".concat(String.valueOf(O0000oOO)));
            int i = 16;
            if (O0000oOO == 1) {
                i = 4;
            } else if (O0000oOO != 4) {
                i = 1;
            }
            this.mCameraPlayerEx.O00000Oo(i);
            if (i == 1) {
                this.mCDCToggleAudio.setEnabled(true);
                this.mCBMuteLandscape.setEnabled(true);
                return;
            }
            if (this.mCDCToggleAudio.isChecked()) {
                this.mCDCToggleAudio.performClick();
            }
            this.mCDCToggleAudio.setEnabled(false);
            this.mCBMuteLandscape.setEnabled(false);
            return;
        }
        gqg.O000000o((int) R.string.sd_card_video_not_playing);
    }

    private void showGuide() {
        if (this.mIsResumed) {
            GuidePage1 guidePage1 = new GuidePage1(this, R.style.guide_dialog);
            guidePage1.show();
            guidePage1.setCancelable(true);
            this.mCameraDevice.O00000oO().O00000o();
        }
    }

    private void showUpdateDlg(boolean z) {
        if (this.mIsResumed) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O000000o((int) R.string.api_tip);
            builder.O00000Oo((int) R.string.api_tip_title);
            builder.O000000o(false);
            builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$TsBEFgKLasJr6CXPtpC1yCWIJk */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    CameraPlayerNewActivity.this.lambda$showUpdateDlg$56$CameraPlayerNewActivity(dialogInterface, i);
                }
            });
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(z) {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$bG2bBVq2q9_LaC43pS_CRthVwCU */
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    CameraPlayerNewActivity.this.lambda$showUpdateDlg$57$CameraPlayerNewActivity(this.f$1, dialogInterface, i);
                }
            });
            builder.O00000oo();
        }
    }

    public /* synthetic */ void lambda$showUpdateDlg$56$CameraPlayerNewActivity(DialogInterface dialogInterface, int i) {
        if (!isFinishing()) {
            dialogInterface.dismiss();
            finish();
        }
    }

    public /* synthetic */ void lambda$showUpdateDlg$57$CameraPlayerNewActivity(boolean z, DialogInterface dialogInterface, int i) {
        if (!isFinishing()) {
            if (z) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://app.mi.com/details?id=com.xiaomi.smarthome")));
            }
            dialogInterface.dismiss();
            finish();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f A[Catch:{ Exception -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a0 A[Catch:{ Exception -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e1  */
    private void isCloudVideoUser() {
        boolean z;
        if (!TextUtils.isEmpty(this.mCameraDevice.getDid())) {
            try {
                if ("chuangmi.camera.ipc009".equals(this.mDeviceStat.model)) {
                    if (!clf.O000000o(this.mCameraDevice.O00000o0(), "3.4.2_0200")) {
                        z = false;
                        clf.O00000Oo(z);
                        if (cih.O000000o() || !clf.O00000oO()) {
                            findViewById(R.id.tvCloudVideo).setVisibility(8);
                            findViewById(R.id.tvCloudVideo).setOnClickListener(null);
                            findViewById(R.id.tvAlbum).setVisibility(0);
                        } else {
                            findViewById(R.id.tvCloudVideo).setVisibility(0);
                            findViewById(R.id.tvCloudVideo).setOnClickListener(this);
                            findViewById(R.id.tvAlbum).setVisibility(8);
                        }
                        if (clf.O00000oO() && this.mCameraDevice.O0000o0O().O0000Oo0 < 0) {
                            if (this.mCameraDevice.O00000oO().O0000o0O <= 0) {
                                this.mCameraDevice.O0000o0O().O0000Oo0 = this.mCameraDevice.O00000oO().O0000o0O;
                            } else {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("did", this.mCameraDevice.getDid());
                                jSONObject.put("region", Locale.getDefault().getCountry());
                                this.mCameraDevice.O0000o0O().O000000o(this.mCameraDevice.getModel(), jSONObject, new cld.O000000o() {
                                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass46 */

                                    public void onFailure(int i, String str) {
                                    }

                                    public void onSuccess(Object obj, Object obj2) {
                                        CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O000000o(CameraPlayerNewActivity.this.mCameraDevice.O0000o0o().f14020O000000o.O0000OOo);
                                    }
                                });
                            }
                        }
                        if (this.mCameraDevice.O00000oO().O0000o0o != 0) {
                            clf.O000000o(true);
                        } else if (this.mCameraDevice.O00000oO().O0000o0o == 1) {
                            clf.O000000o(false);
                        }
                        clf.O0000Oo(this.mCameraDevice.getDid(), this.mCameraDevice.getModel(), new Callback<JSONObject>() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass47 */

                            /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[Catch:{ NullPointerException -> 0x0135 }] */
                            /* JADX WARNING: Removed duplicated region for block: B:24:0x008f A[Catch:{ NullPointerException -> 0x0135 }] */
                            /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4 A[Catch:{ NullPointerException -> 0x0135 }] */
                            public void onSuccess(JSONObject jSONObject) {
                                JSONObject optJSONObject;
                                boolean z;
                                int i;
                                if (!CameraPlayerNewActivity.this.isFinishing() && jSONObject != null) {
                                    try {
                                        if (jSONObject.optInt("code", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                            boolean optBoolean = optJSONObject.optBoolean("vip");
                                            boolean optBoolean2 = optJSONObject.optBoolean("closeWindow");
                                            if (optBoolean2) {
                                                if (!optBoolean) {
                                                    z = false;
                                                    clf.O000000o(z);
                                                    clk O00000oO = CameraPlayerNewActivity.this.mCameraDevice.O00000oO();
                                                    if (optBoolean2) {
                                                        if (!optBoolean) {
                                                            i = 1;
                                                            O00000oO.O0000o0o = i;
                                                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                                            CameraPlayerNewActivity.this.findViewById(R.id.tvCloudVideo).setOnClickListener(CameraPlayerNewActivity.this);
                                                            final long optLong = optJSONObject.optLong("endTime");
                                                            int optInt = optJSONObject.optInt("status");
                                                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000Oo(optInt);
                                                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o(optBoolean2);
                                                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                                            if (optBoolean) {
                                                                JSONObject jSONObject2 = new JSONObject();
                                                                try {
                                                                    jSONObject2.put("did", CameraPlayerNewActivity.this.mDid);
                                                                    Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                                                                    if (O00oOooo != null) {
                                                                        jSONObject2.put("region", O00oOooo.getCountry());
                                                                    } else {
                                                                        jSONObject2.put("region", Locale.getDefault().getCountry());
                                                                    }
                                                                } catch (JSONException e) {
                                                                    e.printStackTrace();
                                                                }
                                                                CloudVideoNetUtils.getInstance().getDeductOrders(CameraPlayerNewActivity.this, jSONObject2.toString(), new ICloudVideoCallback<Boolean>() {
                                                                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass47.AnonymousClass1 */

                                                                    public void onCloudVideoSuccess(Boolean bool, Object obj) {
                                                                        if (!bool.booleanValue()) {
                                                                            CameraPlayerNewActivity.this.processCVExpireUI(optLong);
                                                                        }
                                                                    }

                                                                    public void onCloudVideoFailed(int i, String str) {
                                                                        CameraPlayerNewActivity.this.processCVExpireUI(optLong);
                                                                    }
                                                                });
                                                                return;
                                                            } else if (optInt == 1 && !CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O0000o.equals("0|0")) {
                                                                ((TextView) CameraPlayerNewActivity.this.findViewById(R.id.tvCloudEndTip)).setText(CameraPlayerNewActivity.this.getString(R.string.home_cloud_end_tip));
                                                                CameraPlayerNewActivity.this.findViewById(R.id.ivCloudEndTip).setOnClickListener(new View.OnClickListener() {
                                                                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass47.AnonymousClass2 */

                                                                    public void onClick(View view) {
                                                                        CameraPlayerNewActivity.this.findViewById(R.id.rlCloudEndTip).setVisibility(8);
                                                                        CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O000000o("0|0");
                                                                    }
                                                                });
                                                                CameraPlayerNewActivity.this.findViewById(R.id.rlCloudEndTip).setOnClickListener(new View.OnClickListener() {
                                                                    /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass47.AnonymousClass3 */

                                                                    public void onClick(View view) {
                                                                        CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(CameraPlayerNewActivity.this, CameraPlayerNewActivity.this.mDid);
                                                                    }
                                                                });
                                                                if (CameraPlayerNewActivity.this.mCameraDevice.isOwner()) {
                                                                    CameraPlayerNewActivity.this.findViewById(R.id.rlCloudEndTip).setVisibility(0);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    }
                                                    i = 0;
                                                    O00000oO.O0000o0o = i;
                                                    CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                                    CameraPlayerNewActivity.this.findViewById(R.id.tvCloudVideo).setOnClickListener(CameraPlayerNewActivity.this);
                                                    final long optLong2 = optJSONObject.optLong("endTime");
                                                    int optInt2 = optJSONObject.optInt("status");
                                                    CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000Oo(optInt2);
                                                    CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o(optBoolean2);
                                                    CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                                    if (optBoolean) {
                                                    }
                                                }
                                            }
                                            z = true;
                                            clf.O000000o(z);
                                            clk O00000oO2 = CameraPlayerNewActivity.this.mCameraDevice.O00000oO();
                                            if (optBoolean2) {
                                            }
                                            i = 0;
                                            O00000oO2.O0000o0o = i;
                                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                            CameraPlayerNewActivity.this.findViewById(R.id.tvCloudVideo).setOnClickListener(CameraPlayerNewActivity.this);
                                            final long optLong22 = optJSONObject.optLong("endTime");
                                            int optInt22 = optJSONObject.optInt("status");
                                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000Oo(optInt22);
                                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o(optBoolean2);
                                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                            if (optBoolean) {
                                            }
                                        }
                                    } catch (NullPointerException e2) {
                                        gsy.O000000o(6, "CameraPlayerNewActivity", "NullPointerException:" + e2.getLocalizedMessage());
                                    }
                                }
                            }

                            public void onFailure(int i, String str) {
                                if (CameraPlayerNewActivity.this.isFinishing()) {
                                }
                            }
                        });
                    }
                }
                z = true;
                clf.O00000Oo(z);
                if (cih.O000000o()) {
                }
                findViewById(R.id.tvCloudVideo).setVisibility(8);
                findViewById(R.id.tvCloudVideo).setOnClickListener(null);
                findViewById(R.id.tvAlbum).setVisibility(0);
                if (this.mCameraDevice.O00000oO().O0000o0O <= 0) {
                }
            } catch (Exception unused) {
            }
            if (this.mCameraDevice.O00000oO().O0000o0o != 0) {
            }
            clf.O0000Oo(this.mCameraDevice.getDid(), this.mCameraDevice.getModel(), new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass47 */

                /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[Catch:{ NullPointerException -> 0x0135 }] */
                /* JADX WARNING: Removed duplicated region for block: B:24:0x008f A[Catch:{ NullPointerException -> 0x0135 }] */
                /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4 A[Catch:{ NullPointerException -> 0x0135 }] */
                public void onSuccess(JSONObject jSONObject) {
                    JSONObject optJSONObject;
                    boolean z;
                    int i;
                    if (!CameraPlayerNewActivity.this.isFinishing() && jSONObject != null) {
                        try {
                            if (jSONObject.optInt("code", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                boolean optBoolean = optJSONObject.optBoolean("vip");
                                boolean optBoolean2 = optJSONObject.optBoolean("closeWindow");
                                if (optBoolean2) {
                                    if (!optBoolean) {
                                        z = false;
                                        clf.O000000o(z);
                                        clk O00000oO2 = CameraPlayerNewActivity.this.mCameraDevice.O00000oO();
                                        if (optBoolean2) {
                                            if (!optBoolean) {
                                                i = 1;
                                                O00000oO2.O0000o0o = i;
                                                CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                                CameraPlayerNewActivity.this.findViewById(R.id.tvCloudVideo).setOnClickListener(CameraPlayerNewActivity.this);
                                                final long optLong22 = optJSONObject.optLong("endTime");
                                                int optInt22 = optJSONObject.optInt("status");
                                                CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000Oo(optInt22);
                                                CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o(optBoolean2);
                                                CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                                if (optBoolean) {
                                                    JSONObject jSONObject2 = new JSONObject();
                                                    try {
                                                        jSONObject2.put("did", CameraPlayerNewActivity.this.mDid);
                                                        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                                                        if (O00oOooo != null) {
                                                            jSONObject2.put("region", O00oOooo.getCountry());
                                                        } else {
                                                            jSONObject2.put("region", Locale.getDefault().getCountry());
                                                        }
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }
                                                    CloudVideoNetUtils.getInstance().getDeductOrders(CameraPlayerNewActivity.this, jSONObject2.toString(), new ICloudVideoCallback<Boolean>() {
                                                        /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass47.AnonymousClass1 */

                                                        public void onCloudVideoSuccess(Boolean bool, Object obj) {
                                                            if (!bool.booleanValue()) {
                                                                CameraPlayerNewActivity.this.processCVExpireUI(optLong22);
                                                            }
                                                        }

                                                        public void onCloudVideoFailed(int i, String str) {
                                                            CameraPlayerNewActivity.this.processCVExpireUI(optLong22);
                                                        }
                                                    });
                                                    return;
                                                } else if (optInt22 == 1 && !CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O0000o.equals("0|0")) {
                                                    ((TextView) CameraPlayerNewActivity.this.findViewById(R.id.tvCloudEndTip)).setText(CameraPlayerNewActivity.this.getString(R.string.home_cloud_end_tip));
                                                    CameraPlayerNewActivity.this.findViewById(R.id.ivCloudEndTip).setOnClickListener(new View.OnClickListener() {
                                                        /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass47.AnonymousClass2 */

                                                        public void onClick(View view) {
                                                            CameraPlayerNewActivity.this.findViewById(R.id.rlCloudEndTip).setVisibility(8);
                                                            CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O000000o("0|0");
                                                        }
                                                    });
                                                    CameraPlayerNewActivity.this.findViewById(R.id.rlCloudEndTip).setOnClickListener(new View.OnClickListener() {
                                                        /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass47.AnonymousClass3 */

                                                        public void onClick(View view) {
                                                            CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(CameraPlayerNewActivity.this, CameraPlayerNewActivity.this.mDid);
                                                        }
                                                    });
                                                    if (CameraPlayerNewActivity.this.mCameraDevice.isOwner()) {
                                                        CameraPlayerNewActivity.this.findViewById(R.id.rlCloudEndTip).setVisibility(0);
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        i = 0;
                                        O00000oO2.O0000o0o = i;
                                        CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                        CameraPlayerNewActivity.this.findViewById(R.id.tvCloudVideo).setOnClickListener(CameraPlayerNewActivity.this);
                                        final long optLong222 = optJSONObject.optLong("endTime");
                                        int optInt222 = optJSONObject.optInt("status");
                                        CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000Oo(optInt222);
                                        CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o(optBoolean2);
                                        CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                        if (optBoolean) {
                                        }
                                    }
                                }
                                z = true;
                                clf.O000000o(z);
                                clk O00000oO22 = CameraPlayerNewActivity.this.mCameraDevice.O00000oO();
                                if (optBoolean2) {
                                }
                                i = 0;
                                O00000oO22.O0000o0o = i;
                                CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                CameraPlayerNewActivity.this.findViewById(R.id.tvCloudVideo).setOnClickListener(CameraPlayerNewActivity.this);
                                final long optLong2222 = optJSONObject.optLong("endTime");
                                int optInt2222 = optJSONObject.optInt("status");
                                CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000Oo(optInt2222);
                                CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o(optBoolean2);
                                CameraPlayerNewActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                                if (optBoolean) {
                                }
                            }
                        } catch (NullPointerException e2) {
                            gsy.O000000o(6, "CameraPlayerNewActivity", "NullPointerException:" + e2.getLocalizedMessage());
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    if (CameraPlayerNewActivity.this.isFinishing()) {
                    }
                }
            });
        }
    }

    public void processCVExpireUI(long j) {
        int currentTimeMillis = j - System.currentTimeMillis() < 86400000 ? 1 : (int) (((((j - System.currentTimeMillis()) / 1000) / 60) / 60) / 24);
        if (currentTimeMillis == 1 || currentTimeMillis == 3 || currentTimeMillis == 7) {
            String str = this.mCameraDevice.O00000oO().O0000o;
            if (!str.equals(j + "|" + currentTimeMillis)) {
                ((TextView) findViewById(R.id.tvCloudEndTip)).setText(getResources().getQuantityString(R.plurals.home_cloud_will_end_tip, currentTimeMillis, Integer.valueOf(currentTimeMillis)));
                findViewById(R.id.ivCloudEndTip).setOnClickListener(new View.OnClickListener(j, currentTimeMillis) {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$QAhb2WxcxDnmn1Bt_JbQIwQwHk */
                    private final /* synthetic */ long f$1;
                    private final /* synthetic */ int f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r4;
                    }

                    public final void onClick(View view) {
                        CameraPlayerNewActivity.this.lambda$processCVExpireUI$58$CameraPlayerNewActivity(this.f$1, this.f$2, view);
                    }
                });
                findViewById(R.id.rlCloudEndTip).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$qq9W7JcwUist4tVlmw2SZByYn_E */

                    public final void onClick(View view) {
                        CameraPlayerNewActivity.this.lambda$processCVExpireUI$59$CameraPlayerNewActivity(view);
                    }
                });
                if (this.mCameraDevice.isOwner()) {
                    findViewById(R.id.rlCloudEndTip).setVisibility(0);
                }
            }
        }
    }

    public /* synthetic */ void lambda$processCVExpireUI$58$CameraPlayerNewActivity(long j, int i, View view) {
        findViewById(R.id.rlCloudEndTip).setVisibility(8);
        clk O00000oO = this.mCameraDevice.O00000oO();
        O00000oO.O000000o(j + "|" + i);
    }

    public /* synthetic */ void lambda$processCVExpireUI$59$CameraPlayerNewActivity(View view) {
        fsp.O000000o().O0000Oo.openCloudVideoListActivity(this, this.mCameraDevice.getDid(), this.mCameraDevice.getName());
    }

    private boolean isMijiaLgIncloudSyCurrentLg(String str) {
        String[] strArr = {"zh", "en", "es", "ru", "ko", "it", "fr", "de", "in", "pl", "vi", "ja", "th"};
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < 13; i++) {
            if (str.equals(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    public void setPlayTime() {
        if (!this.mIsUserPause) {
            showLoading("");
        }
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O0000o0O();
        }
    }

    private void calculateTitleBarHeight() {
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$HMPzetKDLX8cB3RQSOQ6vHs3cFk */

            public final void run() {
                CameraPlayerNewActivity.this.lambda$calculateTitleBarHeight$60$CameraPlayerNewActivity();
            }
        }, 300);
    }

    public /* synthetic */ void lambda$calculateTitleBarHeight$60$CameraPlayerNewActivity() {
        if (this.titleBarHeight <= 0) {
            this.titleBarHeight = this.flTitleBar.getMeasuredHeight();
            this.height_16_9 = (int) (((float) getScreenWidth()) / 1.78f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mVideoViewFrame.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = this.height_16_9 + (this.titleBarHeight * 2);
            this.mVideoViewFrame.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mRLDirectionCtl.getLayoutParams();
            layoutParams2.topMargin = -this.titleBarHeight;
            this.mRLDirectionCtl.setLayoutParams(layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mLLVideoViewBottomCtrl.getLayoutParams();
            layoutParams3.bottomMargin = this.titleBarHeight;
            this.mLLVideoViewBottomCtrl.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.mask_bg.getLayoutParams();
            layoutParams4.width = -1;
            layoutParams4.height = this.height_16_9 + this.titleBarHeight;
            this.mask_bg.setLayoutParams(layoutParams4);
            this.mAVCamera.setLayoutParams((FrameLayout.LayoutParams) this.mAVCamera.getLayoutParams());
            this.mAVCamera.setMode(2);
            this.mAVCameraLandscape.setMode(2);
            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.mErrorRetryView.getLayoutParams();
            int i = this.titleBarHeight;
            layoutParams5.bottomMargin = i;
            layoutParams5.topMargin = i;
            this.mErrorRetryView.setLayoutParams(layoutParams5);
            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.mLLFuncPopup.getLayoutParams();
            layoutParams6.topMargin = this.titleBarHeight + gpc.O000000o(25.0f);
            this.mLLFuncPopup.setLayoutParams(layoutParams6);
            this.mRLDirectionCtl.myScrollView.setVisibility(0);
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getStringExtra(JUMP_ACTION) != null && intent.getStringExtra(JUMP_ACTION).equals("camera_PresetPosition")) {
            resetAction();
            initCameraPresetpositionRunnable();
            this.mHandler.postDelayed(this.mCameraPresetpositionRunnable, 1000);
        }
    }

    /* access modifiers changed from: package-private */
    public void initCameraPresetpositionRunnable() {
        this.mCameraPresetpositionRunnable = new Runnable() {
            /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass48 */

            public void run() {
                if ((CameraPlayerNewActivity.this.mCameraPlayerEx == null || CameraPlayerNewActivity.this.mCameraPlayerEx.O0000Ooo()) || CameraPlayerNewActivity.this.mActionRetry > 5) {
                    CameraPlayerNewActivity.this.direction_select_iv.callOnClick();
                    CameraPlayerNewActivity.this.OnDirectionCtrlListener.onCenterClick();
                    return;
                }
                CameraPlayerNewActivity.this.mActionRetry++;
                CameraPlayerNewActivity.this.mHandler.removeCallbacks(CameraPlayerNewActivity.this.mCameraPresetpositionRunnable);
                CameraPlayerNewActivity.this.mHandler.postDelayed(CameraPlayerNewActivity.this.mCameraPresetpositionRunnable, 500);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void resetAction() {
        if (this.mCameraPresetpositionRunnable != null) {
            this.mHandler.removeCallbacks(this.mCameraPresetpositionRunnable);
        }
        if (this.mCameraPlayBackRunnable != null) {
            this.mHandler.removeCallbacks(this.mCameraPlayBackRunnable);
        }
        this.mActionRetry = 0;
    }

    public void updateOperationView() {
        final hjr showOperation = getShowOperation(this.operationProvider.O00000Oo());
        if (showOperation != null) {
            if (this.mCameraDevice.isReadOnlyShared() || showOperation.O000000o() || !isZh()) {
                gsy.O00000Oo("CameraPlayerNewActivity", "cameratip hide tips");
                this.mTipsNewLayout.setVisibility(8);
                this.mTipsNewLayout.setOnClickListener(null);
                return;
            }
            gsy.O00000Oo("cameratip", "cameratip show tips");
            this.currentOperation = showOperation;
            this.mTipsNewLayout.setVisibility(0);
            this.mTipsNewLayout.setClickable(!drawerClosed);
            OperationImageView operationImageView = (OperationImageView) this.mTipsNewLayout.findViewById(R.id.menu_icon);
            this.operationProvider.O000000o(showOperation.O00000Oo, operationImageView);
            operationImageView.registerOnVisibleToUser(new OperationImageView.O000000o() {
                /* class com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity.AnonymousClass49 */

                public void onVisible(View view) {
                    hxm hxm = hxi.O0000o00;
                    String str = showOperation.O00000o;
                    String str2 = showOperation.O0000o0O;
                    String str3 = showOperation.O00000o0;
                    String str4 = showOperation.O0000o0o;
                    hxm.f954O000000o.O000000o("Camera_Recommend_Show", "link", str, "asset_id", str2, "asset_name", str3, "exp_id", str4);
                }
            });
            ((TextView) this.mTipsNewLayout.findViewById(R.id.menu_sub_text)).setText(showOperation.O00000o0);
            updateRedPoint(showOperation);
            this.mTipsNewLayout.setOnClickListener(new View.OnClickListener(showOperation) {
                /* class com.xiaomi.smarthome.camera.v4.activity.$$Lambda$CameraPlayerNewActivity$omaMEu0YhJ2BnGGjAUqhMk7CH0 */
                private final /* synthetic */ hjr f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CameraPlayerNewActivity.this.lambda$updateOperationView$61$CameraPlayerNewActivity(this.f$1, view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$updateOperationView$61$CameraPlayerNewActivity(hjr hjr, View view) {
        hjr hjr2 = hjr;
        gpy.O000000o(this, this.md5Name, "OperationADShortKey", hjr2.O0000o0O);
        if (!this.mSdcardDetectResult.sdcardGetSuccess) {
            detectSDCard();
        }
        if (canStepOut(R.string.speaking_block, R.string.recording_block) && !hjp.O000000o(hjr2.O00000o, getString(R.string.camera_tips))) {
            boolean z = isShowFace() && !this.mCameraDevice.isShared();
            boolean z2 = DeviceConstant.isSupportNewUI(this.mCameraDevice.getModel()) && CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
            gsy.O00000Oo("CameraPlayerNewActivity", "cameratips isShowFace: " + z + " isShowFaceManager: " + z2);
            startActivityForResult(OpenNativeWebViewActivity.getIntent(this, hjr2.O00000o, getString(R.string.camera_tips), this.mDid, z && z2, this.mSdcardDetectResult.sdcardGetSuccess, this.mSdcardDetectResult.sdcardStatus, true), 1221);
            this.operationProvider.O00000o();
            hxk hxk = hxi.O00000o;
            String str = hjr2.O00000o;
            String str2 = hjr2.O0000o0O;
            String str3 = hjr2.O00000o0;
            String str4 = hjr2.O0000o0o;
            hxk.f952O000000o.O000000o("Camera_Recommend_ClickNum", "link", str, "asset_id", str2, "asset_name", str3, "exp_id", str4, str4);
        }
    }

    private boolean isZh() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    private void updateRedPoint(hjr hjr) {
        TextView textView = (TextView) this.mTipsNewLayout.findViewById(R.id.new_text);
        if (shouldShowRedPoint(hjr)) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    private boolean shouldShowRedPoint(hjr hjr) {
        String O00000o0 = gpy.O00000o0(this, this.md5Name, "OperationADShortKey", "");
        if (hjr.O0000o <= 0 || (!TextUtils.isEmpty(O00000o0) && O00000o0.equals(hjr.O0000o0O))) {
            gsy.O00000Oo("CameraPlayerNewActivity", "cameratip shouldShowRedPoint false");
            return false;
        }
        gsy.O00000Oo("CameraPlayerNewActivity", "cameratip shouldShowRedPoint true");
        return true;
    }

    private void lockPreConnectedStatus() {
        DeviceStat deviceStat = this.mCameraDevice.deviceStat();
        if (XmStreamClient.sDelayedDisconnectDevices.containsKey(deviceStat.model + "_" + deviceStat.did)) {
            this.mCameraDevice.O00000o0 = true;
        }
        cih.O00000Oo(this.mCameraDevice.deviceStat());
    }

    private void unlockPreConnectedStatus() {
        this.mCameraDevice.O00000o0 = false;
        cih.O000000o(this.mCameraDevice.deviceStat());
        cih.O00000oO();
    }

    public void onMinScaleChanged(boolean z) {
        int i = R.color.mj_color_black_00_transparent;
        if (z) {
            try {
                gwg.O00000Oo(getWindow());
                ((ImageView) findViewById(R.id.title_bar_return)).setImageResource(R.drawable.mj_tittlebar_main_device_back);
                ((TextView) findViewById(R.id.title_bar_title)).setTextColor(getResources().getColor(R.color.mj_color_black));
                this.mFrameRate.setTextColor(getResources().getColor(R.color.mj_color_black));
                this.mTitleMore.setImageResource(R.drawable.mj_tittlebar_main_device_more);
                FrameLayout frameLayout = this.flTitleBar;
                Resources resources = getResources();
                if (hyy.O000000o()) {
                    i = R.color.mj_color_white;
                }
                frameLayout.setBackgroundColor(resources.getColor(i));
            } catch (Exception e) {
                gsy.O00000Oo("CameraPlayerNewActivity", "exception:" + e.getLocalizedMessage());
            }
        } else {
            gwg.O00000o0(this);
            ((ImageView) findViewById(R.id.title_bar_return)).setImageResource(R.drawable.std_tittlebar_main_device_back_white);
            ((TextView) findViewById(R.id.title_bar_title)).setTextColor(getResources().getColor(R.color.camera_white));
            this.mFrameRate.setTextColor(getResources().getColor(R.color.camera_white));
            this.mTitleMore.setImageResource(R.drawable.std_tittlebar_main_device_more_white);
            FrameLayout frameLayout2 = this.flTitleBar;
            if (!hyy.O000000o()) {
                i = R.drawable.camera_title_background;
            }
            frameLayout2.setBackgroundResource(i);
        }
    }
}
