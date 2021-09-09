package com.xiaomi.smarthome.camera.activity;

import _m_j.chr;
import _m_j.chv;
import _m_j.chw;
import _m_j.cia;
import _m_j.cin;
import _m_j.cky;
import _m_j.clm;
import _m_j.dty;
import _m_j.fta;
import _m_j.gqc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.me;
import _m_j.mg;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.Utils.NetworkMonitor;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.view.DialogCameraDeviceError;
import com.xiaomi.smarthome.camera.view.widget.MultiStateView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

@Deprecated
public abstract class CameraPlayerBaseActivity extends CameraBaseActivity implements cia, View.OnClickListener {
    private final long LIMIT_CONNECT_TIME = 120000;
    private final int RETRY_TIME = 90000;
    private String UPDATE_ING = "";
    protected Runnable delayedReconnectRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity.AnonymousClass8 */

        public void run() {
            if (CameraPlayerBaseActivity.this.mCameraPlayerEx != null) {
                CameraPlayerBaseActivity.this.mCameraPlayerEx.O000000o(new IMISSListener() {
                    /* class com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity.AnonymousClass8.AnonymousClass1 */

                    public void onProgress(int i) {
                    }

                    public void onSuccess(String str, Object obj) {
                        gsy.O00000Oo("CameraPlayerBaseActivity", "handleVideoPlayErrorOnMISS onSuccess:".concat(String.valueOf(str)));
                    }

                    public void onFailed(int i, String str) {
                        gsy.O00000Oo("CameraPlayerBaseActivity", "handleVideoPlayErrorOnMISS onFailed:" + i + ":" + str);
                    }
                });
            }
        }
    };
    public boolean is4GToWifi = false;
    public boolean isChangeNetworkType = false;
    private boolean isOffline = false;
    protected boolean isTimeLapsePhotography = false;
    protected boolean mAllowMobileNetwork = false;
    CheckBox mCBMuteLandscape;
    CheckBox mCBVoiceLandscape;
    public chv mCameraPlayer;
    public chw mCameraPlayerEx;
    public long mConnectStartTime = 0;
    public boolean mConnected = false;
    private int mCurrentRecordTime = 0;
    public long mEmptyTime = 0;
    protected TextView mErrorInfoView;
    protected View mErrorRetryView;
    TextView mFrameRate;
    protected XmMp4Record.IRecordTimeListener mIRecodeTimeListener = new XmMp4Record.IRecordTimeListener() {
        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$v_UuHn9OgIAV9m9GP_EmvBWsiXk */

        public final void upDateTime(int i) {
            CameraPlayerBaseActivity.this.lambda$new$11$CameraPlayerBaseActivity(i);
        }
    };
    LinearLayout mLLRightCtrlLandscape;
    MultiStateView mLandCallView;
    protected AnimationDrawable mLoadingAnimation;
    protected ImageView mLoadingImageView;
    protected TextView mLoadingProgress;
    protected TextView mLoadingTitle;
    protected View mLoadingView;
    protected boolean mNeedPincode = false;
    public boolean mNeedSpeed = false;
    boolean mNeedTry = false;
    protected NetworkMonitor mNetworkMonitor = NetworkMonitor.O000000o();
    NetworkMonitor.O000000o mOnNetworkChange = new NetworkMonitor.O000000o() {
        /* class com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity.AnonymousClass2 */

        public void onDisconnected(int i) {
            if (CameraPlayerBaseActivity.this.mCameraDevice.O00000o() && CameraPlayerBaseActivity.this.mCameraPlayerEx != null) {
                CameraPlayerBaseActivity.this.pauseCamera();
                CameraPlayerBaseActivity.this.mCameraPlayerEx.O00000oo();
            }
            CameraPlayerBaseActivity cameraPlayerBaseActivity = CameraPlayerBaseActivity.this;
            cameraPlayerBaseActivity.showError(cameraPlayerBaseActivity.getString(R.string.common_net_error));
        }

        public void onConnected(int i) {
            if ((!CameraPlayerBaseActivity.this.is4GToWifi || CameraPlayerBaseActivity.this.isHistory()) && ((mg.O00000o0(CameraPlayerBaseActivity.this) && !CameraPlayerBaseActivity.this.mAllowMobileNetwork) || CameraPlayerBaseActivity.this.mUserPause)) {
                CameraPlayerBaseActivity.this.hidError();
                CameraPlayerBaseActivity.this.pauseCamera();
            } else if (CameraPlayerBaseActivity.this.mCameraDevice.O00000o()) {
                if (CameraPlayerBaseActivity.this.mCameraPlayerEx != null && CameraPlayerBaseActivity.this.mConnected) {
                    CameraPlayerBaseActivity.this.hidError();
                    CameraPlayerBaseActivity.this.doResume();
                } else if (CameraPlayerBaseActivity.this.mCameraPlayerEx != null && CameraPlayerBaseActivity.this.isChangeNetworkType) {
                    CameraPlayerBaseActivity cameraPlayerBaseActivity = CameraPlayerBaseActivity.this;
                    cameraPlayerBaseActivity.isChangeNetworkType = false;
                    cameraPlayerBaseActivity.hidError();
                    CameraPlayerBaseActivity.this.doResume();
                }
            } else if (CameraPlayerBaseActivity.this.mCameraPlayer != null && CameraPlayerBaseActivity.this.mConnected) {
                CameraPlayerBaseActivity.this.hidError();
                CameraPlayerBaseActivity.this.doResume();
            } else if (CameraPlayerBaseActivity.this.mCameraPlayer != null && CameraPlayerBaseActivity.this.isChangeNetworkType) {
                CameraPlayerBaseActivity.this.hidError();
                CameraPlayerBaseActivity.this.doResume();
                CameraPlayerBaseActivity.this.isChangeNetworkType = false;
            }
        }

        public void onConnecting(int i) {
            if (CameraPlayerBaseActivity.this.mCameraDevice.O00000o() && CameraPlayerBaseActivity.this.mCameraPlayerEx != null) {
                CameraPlayerBaseActivity.this.pauseCamera();
                CameraPlayerBaseActivity.this.mCameraPlayerEx.O00000oo();
            }
        }

        public void onChange(int i) {
            if (CameraPlayerBaseActivity.this.mCameraPlayerEx != null && CameraPlayerBaseActivity.this.mCameraPlayerEx.O00000oO.isConnecting() && CameraPlayerBaseActivity.this.mCameraDevice != null && CameraPlayerBaseActivity.this.mCameraDevice.O00000o()) {
                CameraPlayerBaseActivity.this.pauseCamera();
                CameraPlayerBaseActivity.this.mCameraPlayerEx.O00000oo();
            }
            CameraPlayerBaseActivity cameraPlayerBaseActivity = CameraPlayerBaseActivity.this;
            cameraPlayerBaseActivity.isChangeNetworkType = true;
            if (i == 1) {
                cameraPlayerBaseActivity.is4GToWifi = true;
            } else {
                cameraPlayerBaseActivity.is4GToWifi = false;
            }
        }
    };
    public View mPauseView;
    protected boolean mPowerCheck = false;
    protected View mPowerOffView;
    private int mProgress = 0;
    protected clm.O000000o mPropertyChangeListener = new clm.O000000o() {
        /* class com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity.AnonymousClass1 */

        public void onPropertyChanged(dty dty, HashSet<String> hashSet) {
            CameraPlayerBaseActivity.this.mHandler.post(new Runnable(hashSet) {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$1$_Z1VKXxwD0oVOqa_d2WISpb_2zQ */
                private final /* synthetic */ HashSet f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CameraPlayerBaseActivity.AnonymousClass1.this.lambda$onPropertyChanged$0$CameraPlayerBaseActivity$1(this.f$1);
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
        public /* synthetic */ void lambda$onPropertyChanged$0$CameraPlayerBaseActivity$1(HashSet hashSet) {
            if (hashSet.contains("power")) {
                gsy.O00000Oo("CameraPlay", "power change:".concat(String.valueOf(hashSet)));
                if (mg.O00000Oo(CameraPlayerBaseActivity.this) || (mg.O00000o0(CameraPlayerBaseActivity.this) && CameraPlayerBaseActivity.this.mAllowMobileNetwork)) {
                    if (CameraPlayerBaseActivity.this.mCameraDevice.O000000o().O000000o("power", true) && CameraPlayerBaseActivity.this.mCameraPlayer != null && !CameraPlayerBaseActivity.this.mCameraPlayer.O000000o()) {
                        CameraPlayerBaseActivity.this.doResume();
                    }
                    if (CameraPlayerBaseActivity.this.mCameraDevice.O000000o().O000000o("power", true) && CameraPlayerBaseActivity.this.mCameraPlayerEx != null && !CameraPlayerBaseActivity.this.mCameraPlayerEx.O000000o()) {
                        CameraPlayerBaseActivity.this.doResume();
                    }
                }
                CameraPlayerBaseActivity.this.refreshUI();
            } else if (hashSet.contains("only_wifi")) {
                CameraPlayerBaseActivity cameraPlayerBaseActivity = CameraPlayerBaseActivity.this;
                cameraPlayerBaseActivity.mAllowMobileNetwork = !cameraPlayerBaseActivity.mCameraDevice.O00000oO().O0000o0;
            }
        }
    };
    public int mPwdCount = 5;
    public int mRetryCount = 0;
    protected View mRetryView;
    protected boolean mShowView = false;
    protected float mSurfaceViewOffsetX = 0.0f;
    protected float mSurfaceViewOffsetY = 0.0f;
    protected float mSurfaceViewScale = 1.0f;
    protected TextView mTitleView;
    private boolean mUpdating = false;
    public boolean mUserPause = false;
    protected FrameLayout mVideoLayout;
    protected XmVideoViewGl mVideoView;
    protected FrameLayout mVideoViewFrame;
    protected TextView offline_time;
    protected TextView retry_tv;
    protected TextView see_help;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm", Locale.getDefault());
    private long startPlayTimeStamp = 0;

    public boolean canStepOut(int i, int i2) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract void detectSDCard();

    /* access modifiers changed from: protected */
    public abstract void doResume();

    /* access modifiers changed from: protected */
    public void doStopCall() {
    }

    /* access modifiers changed from: protected */
    public void doStopRecord() {
    }

    public abstract boolean isHistory();

    /* access modifiers changed from: protected */
    public void onPlayError() {
    }

    /* access modifiers changed from: protected */
    public abstract void refreshUI();

    /* access modifiers changed from: protected */
    public abstract void resumeCamera();

    /* access modifiers changed from: protected */
    public boolean shouldRecordPlayTime() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: startPlay */
    public abstract void lambda$hideUpdateIng$8$CameraPlayerBaseActivity();

    /* access modifiers changed from: protected */
    public void upDateTimeTitle(String str) {
    }

    public void onDestroy() {
        super.onDestroy();
        this.mConnectStartTime = 0;
        if (this.mCameraDevice != null) {
            this.mCameraDevice.O00000Oo().O00000Oo(this.mPropertyChangeListener);
        }
    }

    /* access modifiers changed from: protected */
    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        gwg.O00000o0(this);
        getWindow().clearFlags(2048);
        this.mAllowMobileNetwork = !this.mCameraDevice.O00000oO().O0000o0;
        this.UPDATE_ING = getResources().getString(R.string.update_ing);
    }

    public void onResume() {
        chv chv;
        chw chw;
        super.onResume();
        chw chw2 = this.mCameraPlayerEx;
        if (chw2 != null) {
            chw2.onResume();
        }
        XmVideoViewGl xmVideoViewGl = this.mVideoView;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.onResume();
        }
        if (this.mCameraDevice.O00000o()) {
            if (!this.mUserPause && (chw = this.mCameraPlayerEx) != null && chw.O00000o()) {
                if (!mg.O00000o(this)) {
                    pauseCamera();
                    showError(getString(R.string.common_net_error));
                } else if (mg.O00000o0(this) && !this.mAllowMobileNetwork) {
                    pauseCamera();
                } else if (this.mCameraDevice.deviceStat().isOnline) {
                    doResume();
                }
            }
        } else if (!this.mUserPause && (chv = this.mCameraPlayer) != null && chv.O00000o()) {
            if (!mg.O00000o(this)) {
                pauseCamera();
                showError(getString(R.string.common_net_error));
            } else if (mg.O00000o0(this) && !this.mAllowMobileNetwork) {
                pauseCamera();
            } else if (this.mCameraDevice.deviceStat().isOnline) {
                doResume();
            }
        }
        this.mNetworkMonitor.O000000o(this.mOnNetworkChange);
        refreshUI();
    }

    public void onStop() {
        super.onStop();
        recordVideoPlayTime();
    }

    public void handleMessage(Message message) {
        int i;
        View view;
        super.handleMessage(message);
        if (message.what != 4) {
            return;
        }
        if (!this.mUpdating || (view = this.mLoadingView) == null || view.getVisibility() != 0) {
            if (this.mLoadingProgress.getTag() != null) {
                int intValue = ((Integer) this.mLoadingProgress.getTag()).intValue();
                if (intValue < 100 && (i = this.mProgress) <= 100) {
                    if (intValue == i) {
                        this.mHandler.sendEmptyMessageDelayed(4, 100);
                        return;
                    } else if (intValue <= i || this.mRetryCount == 0) {
                        int i2 = intValue + 1;
                        if (i2 > this.mProgress) {
                            this.mLoadingTitle.setText(cin.O00000o(getResources(), this.mProgress));
                            this.mLoadingProgress.setText(getString(R.string.percentage_tag, new Object[]{Integer.valueOf(this.mProgress)}));
                            this.mLoadingProgress.setTag(Integer.valueOf(this.mProgress));
                        } else if (i2 <= 100) {
                            this.mLoadingTitle.setText(cin.O00000o(getResources(), i2));
                            this.mLoadingProgress.setText(getString(R.string.percentage_tag, new Object[]{Integer.valueOf(i2)}));
                            this.mLoadingProgress.setTag(Integer.valueOf(i2));
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
                this.mLoadingProgress.setText(getString(R.string.percentage_tag, new Object[]{Integer.valueOf(this.mProgress)}));
                this.mLoadingProgress.setTag(Integer.valueOf(this.mProgress));
            } else {
                return;
            }
            if (this.mLoadingProgress.getVisibility() == 0) {
                this.mHandler.sendEmptyMessageDelayed(4, 20);
                return;
            }
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(4, 1000);
    }

    public void onPause() {
        super.onPause();
        chv chv = this.mCameraPlayer;
        if (chv != null) {
            chv.O00000o0();
        }
        chw chw = this.mCameraPlayerEx;
        if (chw != null) {
            chw.onPause();
            this.mCameraPlayerEx.O00000o0();
        }
        this.mNetworkMonitor.O00000Oo(this.mOnNetworkChange);
        this.mConnectStartTime = 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void onPrepare(int i) {
        gsy.O00000Oo("CameraPlay", "prepare ".concat(String.valueOf(i)));
        this.mProgress = i;
        if (i == 5 && this.mRetryCount == 0) {
            this.mConnectStartTime = System.currentTimeMillis();
        }
        if (i >= 101) {
            XmVideoViewGl xmVideoViewGl = this.mVideoView;
            if (xmVideoViewGl != null) {
                xmVideoViewGl.setTouch(true);
            }
            if (this.mCameraDevice.O00000o()) {
                if (i == 101 && this.mCameraPlayerEx != null && !isHistory() && this.mCameraPlayerEx.O0000o) {
                    this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$ZbUl4K7WtxXLpDzdjXE2nx31Cfw */

                        public final void run() {
                            CameraPlayerBaseActivity.this.lambda$onPrepare$1$CameraPlayerBaseActivity();
                        }
                    }, 2000);
                }
            } else if (i == 101 && this.mCameraPlayer != null && !isHistory() && this.mCameraPlayer.O0000o0O) {
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$Z7D8ye62QCOAewkRojnfItWTX8Q */

                    public final void run() {
                        CameraPlayerBaseActivity.this.lambda$onPrepare$3$CameraPlayerBaseActivity();
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
                    /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$CSd8hz3VL3f9GtsWLSaEtqAfNU */

                    public final void run() {
                        CameraPlayerBaseActivity.this.lambda$onPrepare$4$CameraPlayerBaseActivity();
                    }
                }, 1500);
            }
            this.mRetryCount = 0;
            hideLoading();
            hidError();
            refreshUI();
            gsy.O00000Oo("CameraPlay", "onPrepare finish");
            this.startPlayTimeStamp = System.currentTimeMillis();
        } else if (i == 0 && this.mCameraDevice != null && this.mCameraDevice.O000000o().O000000o("power", true)) {
            View view = this.mLoadingView;
            if ((view != null && view.getVisibility() != 0) || this.mRetryCount == 0) {
                String string = getString(R.string.camera_play_initial_0);
                hidError();
                showLoading(string);
            }
        }
    }

    public /* synthetic */ void lambda$onPrepare$1$CameraPlayerBaseActivity() {
        XmVideoViewGl xmVideoViewGl = this.mVideoView;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.snap(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$0HDXMmOdeYGZaN9XcSaJe2ydEEQ */

                public final void onSnap(Bitmap bitmap) {
                    CameraPlayerBaseActivity.this.lambda$null$0$CameraPlayerBaseActivity(bitmap);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$0$CameraPlayerBaseActivity(Bitmap bitmap) {
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

    public /* synthetic */ void lambda$onPrepare$3$CameraPlayerBaseActivity() {
        XmVideoViewGl xmVideoViewGl = this.mVideoView;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.snap(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$eeLJZpEqZbXEnrkMthOU5dMwB24 */

                public final void onSnap(Bitmap bitmap) {
                    CameraPlayerBaseActivity.this.lambda$null$2$CameraPlayerBaseActivity(bitmap);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$2$CameraPlayerBaseActivity(Bitmap bitmap) {
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

    public /* synthetic */ void lambda$onPrepare$4$CameraPlayerBaseActivity() {
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
        if (this.mCameraDevice == null || !this.mCameraDevice.O00000o()) {
            if (i == -20009) {
                gsy.O00000Oo("CameraPlay", "PlayError PWD");
                this.mRetryCount++;
                if (this.mRetryCount <= 3) {
                    updatePwd();
                } else {
                    hideLoading();
                    showError(getString(R.string.camera_play_error1, new Object[]{Integer.valueOf(i)}));
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
                        /* class com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity.AnonymousClass3 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
                         arg types: [java.lang.String, int]
                         candidates:
                          _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                          _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                          _m_j.cll.O000000o(java.lang.String, boolean):boolean */
                        public void onSuccess(Void voidR) {
                            if (!CameraPlayerBaseActivity.this.isFinishing()) {
                                CameraPlayerBaseActivity cameraPlayerBaseActivity = CameraPlayerBaseActivity.this;
                                cameraPlayerBaseActivity.mPowerCheck = true;
                                if (!cameraPlayerBaseActivity.mCameraDevice.O000000o().O000000o("power", true)) {
                                    CameraPlayerBaseActivity.this.hideLoading();
                                    CameraPlayerBaseActivity.this.refreshUI();
                                    return;
                                }
                                CameraPlayerBaseActivity.this.dealRetry(true, i);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!CameraPlayerBaseActivity.this.isFinishing()) {
                                CameraPlayerBaseActivity.this.hideLoading();
                                CameraPlayerBaseActivity cameraPlayerBaseActivity = CameraPlayerBaseActivity.this;
                                cameraPlayerBaseActivity.showError(cameraPlayerBaseActivity.getString(R.string.camera_play_error1, new Object[]{Integer.valueOf(i)}));
                                long currentTimeMillis = System.currentTimeMillis() - CameraPlayerBaseActivity.this.mConnectStartTime;
                                if (currentTimeMillis > 0 && currentTimeMillis < 120000) {
                                    chr.O000000o(i, CameraPlayerBaseActivity.this.mRetryCount, currentTimeMillis);
                                }
                            }
                        }
                    });
                } else if (i != -20015) {
                    dealRetry(true, i);
                } else if (this.mCameraDevice.O000000o().O000000o("power", true)) {
                    this.mCameraDevice.O000000o().O000000o(new String[]{"max_client"}, new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity.AnonymousClass4 */

                        public void onSuccess(Void voidR) {
                            if (!CameraPlayerBaseActivity.this.isFinishing()) {
                                CameraPlayerBaseActivity.this.dealRetry(true, i);
                            }
                        }

                        public void onFailure(int i, String str) {
                            CameraPlayerBaseActivity.this.hideLoading();
                            CameraPlayerBaseActivity cameraPlayerBaseActivity = CameraPlayerBaseActivity.this;
                            cameraPlayerBaseActivity.showError(cameraPlayerBaseActivity.getString(R.string.camera_play_error1, new Object[]{Integer.valueOf(i)}));
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
            gsy.O00000Oo("CameraPlayerBaseActivity", "error:" + i + " errorInfo:" + str);
            int i2 = this.mRetryCount;
            this.mRetryCount = i2 + 1;
            if (i2 <= 3 && (i == 19 || i == 3 || i == 4)) {
                handleVideoPlayErrorOnMISS();
            }
            if (this.mRetryCount > 3) {
                hideLoading();
                showError(getString(R.string.camera_play_error1, new Object[]{Integer.valueOf(i)}));
                this.mConnectStartTime = 0;
                this.mRetryCount = 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkMaxClient() {
        if (this.mCameraDevice != null && this.mCameraDevice.O000000o() != null) {
            this.mCameraDevice.O000000o().O000000o(new String[]{"max_client"}, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity.AnonymousClass5 */

                public void onSuccess(Void voidR) {
                    if (!CameraPlayerBaseActivity.this.isFinishing()) {
                        CameraPlayerBaseActivity.this.hideLoading();
                        if (CameraPlayerBaseActivity.this.mCameraDevice.O000000o().O00000o()) {
                            CameraPlayerBaseActivity cameraPlayerBaseActivity = CameraPlayerBaseActivity.this;
                            cameraPlayerBaseActivity.showError(cameraPlayerBaseActivity.getString(R.string.max_client_3));
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    if (!CameraPlayerBaseActivity.this.isFinishing()) {
                        CameraPlayerBaseActivity.this.hideLoading();
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
            if (this.mCameraDevice.O00000o()) {
                chw chw = this.mCameraPlayerEx;
                if (chw != null && chw.O0000o0) {
                    return;
                }
            } else {
                chv chv = this.mCameraPlayer;
                if (chv != null && chv.O0000Ooo) {
                    return;
                }
            }
            this.mHandler.post(new Runnable(i4) {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$GeeL3qzDpNravrnytNR93Bxi89c */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CameraPlayerBaseActivity.this.lambda$onVideoInfo$7$CameraPlayerBaseActivity(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onVideoInfo$7$CameraPlayerBaseActivity(int i) {
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
        if (this.mCameraDevice.O00000o()) {
            chw chw = this.mCameraPlayerEx;
            if (chw != null && !chw.O0000o0) {
                this.mHandler.post(new Runnable(i) {
                    /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$dWbAEJWif7JqEA4ROcPU6gNBJmU */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        CameraPlayerBaseActivity.this.lambda$null$5$CameraPlayerBaseActivity(this.f$1);
                    }
                });
                return;
            }
            return;
        }
        chv chv = this.mCameraPlayer;
        if (chv != null && !chv.O0000Ooo) {
            this.mHandler.post(new Runnable(i) {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$O3cIC7Aw7M372mzhs9ypZGRyyAA */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CameraPlayerBaseActivity.this.lambda$null$6$CameraPlayerBaseActivity(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$5$CameraPlayerBaseActivity(int i) {
        TextView textView = this.mFrameRate;
        if (!(textView == null || textView.getVisibility() == 0)) {
            this.mFrameRate.setVisibility(0);
        }
        TextView textView2 = this.mFrameRate;
        if (textView2 != null) {
            textView2.setText(i + "KB/S");
        }
    }

    public /* synthetic */ void lambda$null$6$CameraPlayerBaseActivity(int i) {
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
        this.mConnected = true;
        detectSDCard();
        if (this.mCameraDevice.O00000o()) {
            chw chw = this.mCameraPlayerEx;
            if (chw != null && chw.O00000o()) {
                this.mCameraPlayerEx.O00000o0();
            }
            chw chw2 = this.mCameraPlayerEx;
            if (chw2 != null) {
                if (chw2.O0000o0O) {
                    this.mCameraPlayerEx.O00000o(false);
                } else {
                    this.mCameraPlayerEx.O00000o(true);
                }
                chw chw3 = this.mCameraPlayerEx;
                if (chw3.O00000oO != null) {
                    chw3.O00000oO.streamGetDeviceInfo(null);
                    return;
                }
                return;
            }
            return;
        }
        chv chv = this.mCameraPlayer;
        if (chv != null && chv.O00000o()) {
            this.mCameraPlayer.O00000o0();
        }
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
        if (TextUtils.isEmpty(XmPluginHostApi.instance().getDevicePincode(this.mDid)) && !this.mCameraDevice.O0000oO()) {
            this.mNeedTry = true;
        }
        gsy.O00000Oo("CameraPlay", "start upd");
        this.mCameraDevice.O00000Oo(new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity.AnonymousClass6 */

            public void onSuccess(Void voidR) {
                if (!CameraPlayerBaseActivity.this.isFinishing()) {
                    gsy.O00000Oo("CameraPlay", "updatePwd:onSuccess");
                    CameraPlayerBaseActivity.this.lambda$hideUpdateIng$8$CameraPlayerBaseActivity();
                }
            }

            public void onFailure(int i, String str) {
                if (!CameraPlayerBaseActivity.this.isFinishing()) {
                    if (i == 33) {
                        long j = 0;
                        if (CameraPlayerBaseActivity.this.mEmptyTime == 0) {
                            CameraPlayerBaseActivity.this.mEmptyTime = System.currentTimeMillis();
                        } else {
                            j = System.currentTimeMillis() - CameraPlayerBaseActivity.this.mEmptyTime;
                        }
                        if (j <= 5000) {
                            CameraPlayerBaseActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$6$Q6XYvAlc3Z2zMwCVk7PQP4JQcQU */

                                public final void run() {
                                    CameraPlayerBaseActivity.AnonymousClass6.this.lambda$onFailure$0$CameraPlayerBaseActivity$6();
                                }
                            }, 1000);
                            return;
                        }
                    }
                    gsy.O00000Oo("CameraPlay", "updatePwd:onFailure:" + str + " uid: " + CameraPlayerBaseActivity.this.mCameraDevice.O0000oOo() + " pwd:" + CameraPlayerBaseActivity.this.mCameraDevice.O00oOooo());
                    if (!CameraPlayerBaseActivity.this.mNeedTry || CameraPlayerBaseActivity.this.mPwdCount <= 0) {
                        CameraPlayerBaseActivity.this.hideLoading();
                        CameraPlayerBaseActivity cameraPlayerBaseActivity = CameraPlayerBaseActivity.this;
                        cameraPlayerBaseActivity.showError(cameraPlayerBaseActivity.getString(R.string.camera_play_error2));
                        return;
                    }
                    CameraPlayerBaseActivity cameraPlayerBaseActivity2 = CameraPlayerBaseActivity.this;
                    cameraPlayerBaseActivity2.mPwdCount--;
                    CameraPlayerBaseActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$6$fK0WRvJq2sCrSiGj00vRFNG1YX4 */

                        public final void run() {
                            CameraPlayerBaseActivity.AnonymousClass6.this.lambda$onFailure$1$CameraPlayerBaseActivity$6();
                        }
                    }, 3000);
                }
            }

            public /* synthetic */ void lambda$onFailure$0$CameraPlayerBaseActivity$6() {
                CameraPlayerBaseActivity.this.updatePwd();
            }

            public /* synthetic */ void lambda$onFailure$1$CameraPlayerBaseActivity$6() {
                CameraPlayerBaseActivity.this.updatePwd();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void pauseCamera() {
        View view = this.mPauseView;
        if (view != null && view.getVisibility() == 8) {
            this.mPauseView.setVisibility(0);
        }
        if (this.mCameraDevice.O00000o()) {
            chw chw = this.mCameraPlayerEx;
            if (chw != null) {
                chw.O00000o0();
            }
        } else {
            chv chv = this.mCameraPlayer;
            if (chv != null) {
                chv.O00000o0();
            }
        }
        if (mg.O00000o0(this) && !this.mAllowMobileNetwork) {
            gqg.O000000o((int) R.string.nowifi_pausing);
            this.mUserPause = true;
        }
        hideLoading();
        recordVideoPlayTime();
    }

    private void recordVideoPlayTime() {
        if (shouldRecordPlayTime() && this.startPlayTimeStamp > 0) {
            chr.O000000o(chr.O000o0o0, "time", Long.valueOf((System.currentTimeMillis() - this.startPlayTimeStamp) / 1000));
            this.startPlayTimeStamp = 0;
        }
    }

    public boolean doOnClick(View view) {
        int id = view.getId();
        if (id == R.id.pause_view) {
            this.mUserPause = false;
            resumeCamera();
        } else if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.retry_tv || id == R.id.retry_btn) {
            this.mRetryCount = 0;
            if (!mg.O00000o(this)) {
                showError(getString(R.string.common_net_error));
                return true;
            } else if (!mg.O00000o0(this) || this.mAllowMobileNetwork) {
                hidError();
                showLoading(getString(R.string.camera_play_initial_0));
                if (this.mCameraDevice.O00000o()) {
                    chw chw = this.mCameraPlayerEx;
                    if (chw != null) {
                        chw.O00000oO();
                    } else {
                        lambda$hideUpdateIng$8$CameraPlayerBaseActivity();
                    }
                } else {
                    chv chv = this.mCameraPlayer;
                    if (chv != null) {
                        chv.O00000oo();
                    } else {
                        lambda$hideUpdateIng$8$CameraPlayerBaseActivity();
                    }
                }
            } else {
                hidError();
                pauseCamera();
                return true;
            }
        } else if (id != R.id.see_help) {
            return false;
        } else {
            new DialogCameraDeviceError(this, this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), this.isOffline).show();
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
            View view = this.mPauseView;
            if (view != null && view.getVisibility() == 0) {
                this.mPauseView.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void showLastLoading() {
        View view = this.mLoadingView;
        if (view != null) {
            if (!this.mUpdating || view.getVisibility() != 0) {
                hidError();
                if (this.mLoadingView.getVisibility() != 0) {
                    this.mLoadingView.bringToFront();
                    this.mLoadingAnimation.start();
                    this.mLoadingView.setVisibility(0);
                }
                this.mLoadingTitle.setText(cin.O00000o(getResources(), this.mProgress));
                int i = this.mProgress;
                if (i > 100) {
                    this.mLoadingProgress.setText(getString(R.string.percentage_tag, new Object[]{100}));
                    return;
                }
                this.mLoadingProgress.setText(getString(R.string.percentage_tag, new Object[]{Integer.valueOf(i)}));
                this.mLoadingProgress.setTag(Integer.valueOf(this.mProgress));
                this.mHandler.removeMessages(4);
                this.mHandler.sendEmptyMessage(4);
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
        View view = this.mPauseView;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mLoadingView;
        if (view2 != null) {
            view2.setVisibility(0);
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
                    this.mLoadingProgress.setText("0%");
                    this.mLoadingProgress.setTag(null);
                    return;
                }
                this.mLoadingTitle.setText((int) R.string.camera_play_initial_buffer);
                this.mLoadingProgress.setText("");
                this.mLoadingProgress.setTag(null);
            }
        }
    }

    public void hideLoading() {
        if (this.mLoadingView != null) {
            if (!this.mUpdating || !mg.O000000o(this)) {
                this.mLoadingAnimation.stop();
                this.mLoadingProgress.setText("");
                this.mLoadingProgress.setTag(null);
                this.mHandler.removeMessages(4);
                this.mLoadingView.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void showUpdateIng(int i) {
        View view = this.mLoadingView;
        if (view != null) {
            this.mUpdating = true;
            if (view.getVisibility() != 0) {
                this.mLoadingAnimation.start();
                hidError();
                this.mLoadingView.setVisibility(0);
            }
            View view2 = this.mPauseView;
            if (view2 != null && view2.getVisibility() == 0) {
                this.mPauseView.setVisibility(8);
            }
            CharSequence text = this.mLoadingTitle.getText();
            if (text != null && !text.toString().equals(this.UPDATE_ING)) {
                if (this.mCameraDevice.O00000o()) {
                    chw chw = this.mCameraPlayerEx;
                    if (chw != null) {
                        chw.O00000o0();
                    }
                } else {
                    chv chv = this.mCameraPlayer;
                    if (chv != null) {
                        chv.O00000o0();
                    }
                }
            }
            this.mLoadingTitle.setText(this.UPDATE_ING);
            String language = getResources().getConfiguration().locale.getLanguage();
            if (TextUtils.isEmpty(language) || !language.contains("tr")) {
                TextView textView = this.mLoadingProgress;
                textView.setText(i + "%");
            } else {
                this.mLoadingProgress.setText("%".concat(String.valueOf(i)));
            }
            this.mLoadingProgress.setTag(null);
        }
    }

    /* access modifiers changed from: protected */
    public void hideUpdateIng(boolean z) {
        CharSequence text;
        View view = this.mLoadingView;
        if (view != null) {
            this.mUpdating = false;
            if (view.getVisibility() == 0 && (text = this.mLoadingTitle.getText()) != null && text.toString().equals(this.UPDATE_ING)) {
                this.mLoadingAnimation.stop();
                this.mLoadingView.setVisibility(8);
                this.mLoadingProgress.setText("");
                this.mLoadingTitle.setText("");
                this.mLoadingProgress.setTag(null);
                if (z) {
                    this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$CTgBFXpOfQwVbrBPsTCxAutY9_Y */

                        public final void run() {
                            CameraPlayerBaseActivity.this.lambda$hideUpdateIng$8$CameraPlayerBaseActivity();
                        }
                    }, 3000);
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
    public void showError(String str) {
        if (this.mCameraDevice.O00000o()) {
            chw chw = this.mCameraPlayerEx;
            if (chw != null) {
                if (chw.O0000o0) {
                    doStopRecord();
                }
                if (this.mCameraPlayerEx.O0000OOo) {
                    doStopCall();
                }
            }
        } else {
            chv chv = this.mCameraPlayer;
            if (chv != null) {
                if (chv.O0000Ooo) {
                    doStopRecord();
                }
                if (this.mCameraPlayer.O0000O0o) {
                    doStopCall();
                }
            }
        }
        if (this.mIsResumed) {
            View view = this.mPauseView;
            if (view != null && view.getVisibility() == 0) {
                this.mPauseView.setVisibility(8);
            }
            if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                View view2 = this.mPowerOffView;
                if (view2 != null && view2.getVisibility() == 8) {
                    this.mPowerOffView.setVisibility(0);
                }
                this.mErrorRetryView.setVisibility(8);
            } else {
                if (this.mErrorRetryView.getVisibility() != 0) {
                    View view3 = this.mLoadingView;
                    if (view3 == null || view3.getVisibility() != 0 || !((String) this.mLoadingTitle.getText()).equals(this.UPDATE_ING)) {
                        this.mErrorRetryView.setVisibility(0);
                        refreshUI();
                    } else {
                        refreshUI();
                        return;
                    }
                }
                if (str.equals(getString(R.string.device_offline))) {
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
                        /* class com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity.AnonymousClass7 */

                        public void onSuccess(Long l) {
                            if (!CameraPlayerBaseActivity.this.isFinishing() && CameraPlayerBaseActivity.this.offline_time != null) {
                                CameraPlayerBaseActivity.this.offline_time.setText(MessageFormat.format("{0}：{1}", CameraPlayerBaseActivity.this.getString(R.string.offline_time_str), CameraPlayerBaseActivity.this.simpleDateFormat.format(new Date(l.longValue() * 1000))));
                                CameraPlayerBaseActivity.this.offline_time.setVisibility(0);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (CameraPlayerBaseActivity.this.isFinishing()) {
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
    }

    /* access modifiers changed from: protected */
    public boolean isGPUDecoder() {
        XmVideoViewGl xmVideoViewGl = this.mVideoView;
        return xmVideoViewGl != null && xmVideoViewGl.isGPUDecoder();
    }

    /* access modifiers changed from: protected */
    public void setWindow(Configuration configuration) {
        if (configuration.orientation == 2) {
            getWindow().setFlags(1024, 1024);
            gqc.O000000o(false, getWindow().getDecorView());
            return;
        }
        getWindow().clearFlags(1024);
        gqc.O000000o(true, getWindow().getDecorView());
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
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$Id4dgsHbXQa8HLuihwJBJqevgVY */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CameraPlayerBaseActivity.this.lambda$dealRetry$9$CameraPlayerBaseActivity(this.f$1);
                }
            }, 2000);
            return;
        }
        hideLoading();
        showError(getString(R.string.camera_play_error1, new Object[]{Integer.valueOf(i)}));
        if (j2 > 0) {
            int i2 = this.mRetryCount;
            if (j2 < ((long) (60000 * i2)) + 120000) {
                chr.O000000o(i, i2, j2);
            }
        }
        this.mConnectStartTime = 0;
        this.mRetryCount = 0;
    }

    public /* synthetic */ void lambda$dealRetry$9$CameraPlayerBaseActivity(int i) {
        gsy.O00000Oo("CameraPlay", "retry " + this.mRetryCount + " " + i);
        if (this.mCameraDevice.O00000o()) {
            chw chw = this.mCameraPlayerEx;
            if (chw != null) {
                chw.O00000oO();
                return;
            }
            return;
        }
        chv chv = this.mCameraPlayer;
        if (chv != null) {
            chv.O00000oo();
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
        super.handleVideoPlayErrorOnMISS();
        if (this.mCameraPlayerEx != null && this.mHandler != null) {
            gsy.O00000Oo("CameraPlayerBaseActivity", "run handleVideoPlayErrorOnMISS");
            this.mCameraPlayerEx.O00000oo();
            this.mHandler.removeCallbacks(this.delayedReconnectRunnable);
            this.mHandler.postDelayed(this.delayedReconnectRunnable, 5000);
        }
    }

    public /* synthetic */ void lambda$new$11$CameraPlayerBaseActivity(int i) {
        int i2;
        if (i >= 0 && (i2 = i / 1000) != this.mCurrentRecordTime) {
            this.mCurrentRecordTime = i2;
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraPlayerBaseActivity$OnKggWSQwRNyDRExvNXQqIXejw */

                public final void run() {
                    CameraPlayerBaseActivity.this.lambda$null$10$CameraPlayerBaseActivity();
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, int):java.lang.String
     arg types: [com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(android.content.Context, float):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String */
    public /* synthetic */ void lambda$null$10$CameraPlayerBaseActivity() {
        upDateTimeTitle(cin.O000000o((Context) this, this.mCurrentRecordTime));
    }
}
