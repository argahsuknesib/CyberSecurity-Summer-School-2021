package com.xiaomi.smarthome.camera.activity;

import _m_j.chr;
import _m_j.cia;
import _m_j.cin;
import _m_j.cjg;
import _m_j.cjh;
import _m_j.cki;
import _m_j.cky;
import _m_j.clm;
import _m_j.dty;
import _m_j.fta;
import _m_j.gkv;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.me;
import _m_j.mg;
import android.app.Activity;
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
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.view.DialogCameraDeviceError;
import com.xiaomi.smarthome.camera.view.widget.MultiStateView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public abstract class GeneralCameraPlayerBaseActivity extends CameraBaseActivity implements cia, View.OnClickListener {
    private final long LIMIT_CONNECT_TIME = 120000;
    private final int RETRY_TIME = 90000;
    private String UPDATE_ING = "";
    public Runnable avCheckRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity.AnonymousClass8 */

        public void run() {
            if (GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx != null && GeneralCameraPlayerBaseActivity.this.bpsSum <= 0) {
                GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx.O0000o0o();
                if (GeneralCameraPlayerBaseActivity.this.mHandler != null) {
                    GeneralCameraPlayerBaseActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$8$xZ_QmC1bQ1V66FJEN10B5b2znwY */

                        public final void run() {
                            GeneralCameraPlayerBaseActivity.AnonymousClass8.this.lambda$run$0$GeneralCameraPlayerBaseActivity$8();
                        }
                    }, 500);
                } else {
                    return;
                }
            }
            GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity = GeneralCameraPlayerBaseActivity.this;
            generalCameraPlayerBaseActivity.bpsSum = 0;
            if (generalCameraPlayerBaseActivity.mHandler != null) {
                GeneralCameraPlayerBaseActivity.this.mHandler.removeCallbacks(GeneralCameraPlayerBaseActivity.this.avCheckRunnable);
                GeneralCameraPlayerBaseActivity.this.mHandler.postDelayed(GeneralCameraPlayerBaseActivity.this.avCheckRunnable, 10000);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
         arg types: [java.lang.String, int]
         candidates:
          _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
          _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
          _m_j.cll.O000000o(java.lang.String, boolean):boolean */
        public /* synthetic */ void lambda$run$0$GeneralCameraPlayerBaseActivity$8() {
            if (GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx == null) {
                return;
            }
            if (GeneralCameraPlayerBaseActivity.this.mCameraDevice == null || GeneralCameraPlayerBaseActivity.this.mCameraDevice.O000000o() == null || GeneralCameraPlayerBaseActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx.O0000o0O();
            }
        }
    };
    public int bpsSum = 0;
    protected Runnable delayedReconnectRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity.AnonymousClass7 */

        public void run() {
            if (GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx != null) {
                GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx.O0000o0o();
                GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx.O0000o0O();
            }
        }
    };
    public boolean is4GToWifi = false;
    public boolean isChangeNetworkType = false;
    protected boolean isConnected = false;
    private boolean isOffline = false;
    public boolean isPowerCheck = false;
    protected boolean isTimeLapsePhotography = false;
    protected boolean mAllowMobileNetwork = false;
    protected CheckBox mCBMuteLandscape;
    protected CheckBox mCBVoiceLandscape;
    public cjg mCameraPlayerEx;
    public long mConnectStartTime = 0;
    public boolean mConnected = false;
    protected Activity mContext;
    private int mCurrentRecordTime = 0;
    public long mEmptyTime = 0;
    protected TextView mErrorInfoView;
    protected View mErrorRetryView;
    protected TextView mFrameRate;
    protected View mHintView;
    protected XmMp4Record.IRecordTimeListener mIRecodeTimeListener = new XmMp4Record.IRecordTimeListener() {
        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$FtLbzeiGPT1PNChBTCz2mAWT5zA */

        public final void upDateTime(int i) {
            GeneralCameraPlayerBaseActivity.this.lambda$new$8$GeneralCameraPlayerBaseActivity(i);
        }
    };
    public boolean mIsUserPause = false;
    protected LinearLayout mLLRightCtrlLandscape;
    protected MultiStateView mLandCallView;
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
        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity.AnonymousClass2 */

        public void onDisconnected(int i) {
            if (GeneralCameraPlayerBaseActivity.this.mCameraDevice.O00000o() && GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx != null) {
                GeneralCameraPlayerBaseActivity.this.pauseCamera();
                GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx.O0000o0o();
            }
            GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity = GeneralCameraPlayerBaseActivity.this;
            generalCameraPlayerBaseActivity.showError(generalCameraPlayerBaseActivity.getString(R.string.common_net_error));
        }

        public void onConnected(int i) {
            if ((!GeneralCameraPlayerBaseActivity.this.is4GToWifi || i != 1 || GeneralCameraPlayerBaseActivity.this.isHistory()) && ((mg.O00000o0(GeneralCameraPlayerBaseActivity.this.mContext) && !GeneralCameraPlayerBaseActivity.this.mAllowMobileNetwork) || GeneralCameraPlayerBaseActivity.this.mIsUserPause)) {
                GeneralCameraPlayerBaseActivity.this.hidError();
                GeneralCameraPlayerBaseActivity.this.pauseCamera();
            } else if (GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx != null && GeneralCameraPlayerBaseActivity.this.mConnected) {
                GeneralCameraPlayerBaseActivity.this.hidError();
                GeneralCameraPlayerBaseActivity.this.doResume();
            } else if (GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx != null && GeneralCameraPlayerBaseActivity.this.isChangeNetworkType) {
                GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity = GeneralCameraPlayerBaseActivity.this;
                generalCameraPlayerBaseActivity.isChangeNetworkType = false;
                generalCameraPlayerBaseActivity.hidError();
                GeneralCameraPlayerBaseActivity.this.doResume();
            }
        }

        public void onConnecting(int i) {
            if (GeneralCameraPlayerBaseActivity.this.mCameraDevice.O00000o() && GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx != null) {
                GeneralCameraPlayerBaseActivity.this.pauseCamera();
                GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx.O0000o0o();
            }
        }

        public void onChange(int i) {
            if (GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx != null && GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx.O0000o0() && GeneralCameraPlayerBaseActivity.this.mCameraDevice != null && GeneralCameraPlayerBaseActivity.this.mCameraDevice.O00000o()) {
                GeneralCameraPlayerBaseActivity.this.pauseCamera();
                GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx.O0000o0o();
            }
            GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity = GeneralCameraPlayerBaseActivity.this;
            generalCameraPlayerBaseActivity.isChangeNetworkType = true;
            if (i == 1) {
                generalCameraPlayerBaseActivity.is4GToWifi = true;
            } else {
                generalCameraPlayerBaseActivity.is4GToWifi = false;
            }
        }
    };
    public View mPauseView;
    protected View mPowerOffView;
    protected int mProgress = 0;
    protected clm.O000000o mPropertyChangeListener = new clm.O000000o() {
        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity.AnonymousClass1 */

        public void onPropertyChanged(dty dty, HashSet<String> hashSet) {
            GeneralCameraPlayerBaseActivity.this.mHandler.post(new Runnable(hashSet) {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$1$OXdM9BEZjufTZkdMxYvQLxLjaGI */
                private final /* synthetic */ HashSet f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    GeneralCameraPlayerBaseActivity.AnonymousClass1.this.lambda$onPropertyChanged$0$GeneralCameraPlayerBaseActivity$1(this.f$1);
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
        public /* synthetic */ void lambda$onPropertyChanged$0$GeneralCameraPlayerBaseActivity$1(HashSet hashSet) {
            if (hashSet.contains("power")) {
                gsy.O00000Oo("CameraPlay", "power change".concat(String.valueOf(hashSet)));
                if ((mg.O00000Oo(GeneralCameraPlayerBaseActivity.this.mContext) || (mg.O00000o0(GeneralCameraPlayerBaseActivity.this.mContext) && GeneralCameraPlayerBaseActivity.this.mAllowMobileNetwork)) && GeneralCameraPlayerBaseActivity.this.mCameraDevice.O000000o().O000000o("power", true) && GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx != null && !GeneralCameraPlayerBaseActivity.this.mCameraPlayerEx.O0000Ooo()) {
                    GeneralCameraPlayerBaseActivity.this.doResume();
                }
                GeneralCameraPlayerBaseActivity.this.refreshUI();
            } else if (hashSet.contains("only_wifi")) {
                GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity = GeneralCameraPlayerBaseActivity.this;
                generalCameraPlayerBaseActivity.mAllowMobileNetwork = !generalCameraPlayerBaseActivity.mCameraDevice.O00000oO().O0000o0;
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
    public float mSurfaceViewScaleX = 2.0f;
    protected TextView mTVExitFullScreen;
    protected TextView mTitleView;
    private boolean mUpdating = false;
    public cjh mVideoView;
    public FrameLayout mVideoViewFrame;
    protected TextView offline_time;
    protected TextView retry_tv;
    protected List<Runnable> runnableList = new ArrayList();
    protected TextView see_help;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault());
    private long startPlayTimeStamp = 0;
    protected VerifyGlobalManager verifyGlobalManager;

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
    public void onHidError() {
    }

    /* access modifiers changed from: protected */
    public void onPlayError() {
    }

    /* access modifiers changed from: protected */
    public void onShowError(boolean z) {
    }

    /* access modifiers changed from: protected */
    public abstract void refreshUI();

    /* access modifiers changed from: protected */
    public abstract void resumeCamera();

    /* access modifiers changed from: protected */
    public boolean shouldRecordPlayTime() {
        return false;
    }

    public void showSDCardHintDialog() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: startPlay */
    public abstract void lambda$hideUpdateIng$5$GeneralCameraPlayerBaseActivity();

    public boolean supportOrientationListen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void upDateTimeTitle(String str) {
    }

    public void onDestroy() {
        super.onDestroy();
        this.mConnectStartTime = 0;
        if (this.mCameraDevice != null) {
            this.mCameraDevice.O00000Oo().O00000Oo(this.mPropertyChangeListener);
        }
        cjh cjh = this.mVideoView;
        if (cjh != null) {
            cjh.O0000OOo();
        }
    }

    /* access modifiers changed from: protected */
    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        this.mContext = this;
        this.verifyGlobalManager = VerifyGlobalManager.O000000o(this);
        gwg.O00000o0(this);
        getWindow().clearFlags(2048);
        this.mAllowMobileNetwork = !this.mCameraDevice.O00000oO().O0000o0;
        this.UPDATE_ING = getResources().getString(R.string.update_ing);
    }

    public void onResume() {
        cjg cjg;
        super.onResume();
        if (!this.mIsUserPause && (cjg = this.mCameraPlayerEx) != null && cjg.O0000o00()) {
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
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null) {
            cjg.O0000OOo();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.avCheckRunnable);
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
            this.isConnected = true;
            if (i == 101 && this.mCameraPlayerEx != null && !isHistory() && this.mCameraPlayerEx.O00000Oo()) {
                this.mCameraPlayerEx.O000000o(6, (IXmConnectionClient.XmActionCallback) null);
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$48PY2kjJGGc9I4TidXemDCHJXfg */

                    public final void run() {
                        GeneralCameraPlayerBaseActivity.this.lambda$onPrepare$1$GeneralCameraPlayerBaseActivity();
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
                    /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$naEKvDtxfhAbVkcltZmxOljniik */

                    public final void run() {
                        GeneralCameraPlayerBaseActivity.this.lambda$onPrepare$2$GeneralCameraPlayerBaseActivity();
                    }
                }, 1500);
            }
            this.mRetryCount = 0;
            hideLoading();
            hidError();
            refreshUI();
            gsy.O00000Oo("CameraPlay", "onPrepare finish");
            this.startPlayTimeStamp = System.currentTimeMillis();
            this.mHandler.removeCallbacks(this.avCheckRunnable);
            this.mHandler.postDelayed(this.avCheckRunnable, 10000);
        } else if (i == 0 && this.mCameraDevice != null && this.mCameraDevice.O000000o().O000000o("power", true)) {
            View view = this.mLoadingView;
            if ((view != null && view.getVisibility() != 0) || this.mRetryCount == 0) {
                String string = getString(R.string.camera_play_initial_0);
                hidError();
                showLoading(string);
            }
        }
    }

    public /* synthetic */ void lambda$onPrepare$1$GeneralCameraPlayerBaseActivity() {
        cjh cjh = this.mVideoView;
        if (cjh != null) {
            cjh.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$hBtLN8z2DzBbRH1t2B0k_iwRCqc */

                public final void onSnap(Bitmap bitmap) {
                    GeneralCameraPlayerBaseActivity.this.lambda$null$0$GeneralCameraPlayerBaseActivity(bitmap);
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$0$GeneralCameraPlayerBaseActivity(Bitmap bitmap) {
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

    public /* synthetic */ void lambda$onPrepare$2$GeneralCameraPlayerBaseActivity() {
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
                } else if (!this.isPowerCheck) {
                    this.mCameraDevice.O000000o().O000000o(new String[]{"power", "max_client"}, new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity.AnonymousClass3 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
                         arg types: [java.lang.String, int]
                         candidates:
                          _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                          _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                          _m_j.cll.O000000o(java.lang.String, boolean):boolean */
                        public void onSuccess(Void voidR) {
                            if (!GeneralCameraPlayerBaseActivity.this.isFinishing()) {
                                GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity = GeneralCameraPlayerBaseActivity.this;
                                generalCameraPlayerBaseActivity.isPowerCheck = true;
                                if (!generalCameraPlayerBaseActivity.mCameraDevice.O000000o().O000000o("power", true)) {
                                    GeneralCameraPlayerBaseActivity.this.hideLoading();
                                    GeneralCameraPlayerBaseActivity.this.refreshUI();
                                } else if (GeneralCameraPlayerBaseActivity.this.mCameraDevice.O000000o().O00000o()) {
                                    GeneralCameraPlayerBaseActivity.this.hideLoading();
                                    GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity2 = GeneralCameraPlayerBaseActivity.this;
                                    generalCameraPlayerBaseActivity2.showError(generalCameraPlayerBaseActivity2.getString(R.string.max_client_3));
                                } else {
                                    GeneralCameraPlayerBaseActivity.this.dealRetry(true, i);
                                }
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!GeneralCameraPlayerBaseActivity.this.isFinishing()) {
                                GeneralCameraPlayerBaseActivity.this.hideLoading();
                                GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity = GeneralCameraPlayerBaseActivity.this;
                                generalCameraPlayerBaseActivity.showError(generalCameraPlayerBaseActivity.getString(R.string.camera_play_error1, new Object[]{Integer.valueOf(i)}));
                                long currentTimeMillis = System.currentTimeMillis() - GeneralCameraPlayerBaseActivity.this.mConnectStartTime;
                                if (currentTimeMillis > 0 && currentTimeMillis < 120000) {
                                    chr.O000000o(i, GeneralCameraPlayerBaseActivity.this.mRetryCount, currentTimeMillis);
                                }
                            }
                        }
                    });
                } else if (i != -20015) {
                    dealRetry(true, i);
                } else if (this.mCameraDevice.O000000o().O000000o("power", true)) {
                    this.mCameraDevice.O000000o().O000000o(new String[]{"max_client"}, new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity.AnonymousClass4 */

                        public void onSuccess(Void voidR) {
                            if (!GeneralCameraPlayerBaseActivity.this.isFinishing()) {
                                GeneralCameraPlayerBaseActivity.this.dealRetry(true, i);
                            }
                        }

                        public void onFailure(int i, String str) {
                            GeneralCameraPlayerBaseActivity.this.hideLoading();
                            GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity = GeneralCameraPlayerBaseActivity.this;
                            generalCameraPlayerBaseActivity.showError(generalCameraPlayerBaseActivity.getString(R.string.camera_play_error1, new Object[]{Integer.valueOf(i)}));
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
            gsy.O00000Oo("GeneralCameraPlayerBaseActivity", "error:" + i + " errorInfo:" + str);
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
                this.bpsSum += i4;
                this.mHandler.post(new Runnable(i4) {
                    /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$CNfERua6_O9T3YH80vJ14IUmuA */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        GeneralCameraPlayerBaseActivity.this.lambda$onVideoInfo$4$GeneralCameraPlayerBaseActivity(this.f$1);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onVideoInfo$4$GeneralCameraPlayerBaseActivity(int i) {
        TextView textView = this.mFrameRate;
        if (!(textView == null || textView.getVisibility() == 0)) {
            this.mFrameRate.setVisibility(0);
        }
        TextView textView2 = this.mFrameRate;
        if (textView2 != null) {
            textView2.setText(i + "KB/S");
        }
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null && !cjg.O0000O0o()) {
            this.mHandler.post(new Runnable(i) {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$3gxSlv4q3let5S1h2uIifcmuE */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    GeneralCameraPlayerBaseActivity.this.lambda$null$3$GeneralCameraPlayerBaseActivity(this.f$1);
                }
            });
        }
        if (i > 0) {
            this.isConnected = true;
        }
    }

    public /* synthetic */ void lambda$null$3$GeneralCameraPlayerBaseActivity(int i) {
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
        List<Runnable> list;
        this.mConnected = true;
        detectSDCard();
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
        if (this.mHandler != null && (list = this.runnableList) != null && list.size() > 0) {
            for (Runnable post : this.runnableList) {
                this.mHandler.post(post);
            }
            this.runnableList.clear();
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
            /* class com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity.AnonymousClass5 */

            public void onSuccess(Void voidR) {
                if (!GeneralCameraPlayerBaseActivity.this.isFinishing()) {
                    gsy.O00000Oo("CameraPlay", "updatePwd:onSuccess");
                    GeneralCameraPlayerBaseActivity.this.lambda$hideUpdateIng$5$GeneralCameraPlayerBaseActivity();
                }
            }

            public void onFailure(int i, String str) {
                if (!GeneralCameraPlayerBaseActivity.this.isFinishing()) {
                    if (i == 33) {
                        long j = 0;
                        if (GeneralCameraPlayerBaseActivity.this.mEmptyTime == 0) {
                            GeneralCameraPlayerBaseActivity.this.mEmptyTime = System.currentTimeMillis();
                        } else {
                            j = System.currentTimeMillis() - GeneralCameraPlayerBaseActivity.this.mEmptyTime;
                        }
                        if (j <= 5000) {
                            GeneralCameraPlayerBaseActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$5$XZp0ZgPvHHSI0dNP4_zrTKgm5BE */

                                public final void run() {
                                    GeneralCameraPlayerBaseActivity.AnonymousClass5.this.lambda$onFailure$0$GeneralCameraPlayerBaseActivity$5();
                                }
                            }, 1000);
                            return;
                        }
                    }
                    gsy.O00000Oo("CameraPlay", "updatePwd:onFailure:" + str + " uid: " + GeneralCameraPlayerBaseActivity.this.mCameraDevice.O0000oOo() + " pwd:" + GeneralCameraPlayerBaseActivity.this.mCameraDevice.O00oOooo());
                    if (!GeneralCameraPlayerBaseActivity.this.mNeedTry || GeneralCameraPlayerBaseActivity.this.mPwdCount <= 0) {
                        GeneralCameraPlayerBaseActivity.this.hideLoading();
                        GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity = GeneralCameraPlayerBaseActivity.this;
                        generalCameraPlayerBaseActivity.showError(generalCameraPlayerBaseActivity.getString(R.string.camera_play_error2));
                        return;
                    }
                    GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity2 = GeneralCameraPlayerBaseActivity.this;
                    generalCameraPlayerBaseActivity2.mPwdCount--;
                    GeneralCameraPlayerBaseActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$5$_il33RlF6JeiVWjkR0M6cEUKyQ */

                        public final void run() {
                            GeneralCameraPlayerBaseActivity.AnonymousClass5.this.lambda$onFailure$1$GeneralCameraPlayerBaseActivity$5();
                        }
                    }, 3000);
                }
            }

            public /* synthetic */ void lambda$onFailure$0$GeneralCameraPlayerBaseActivity$5() {
                GeneralCameraPlayerBaseActivity.this.updatePwd();
            }

            public /* synthetic */ void lambda$onFailure$1$GeneralCameraPlayerBaseActivity$5() {
                GeneralCameraPlayerBaseActivity.this.updatePwd();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void pauseCamera() {
        View view = this.mPauseView;
        if (view != null && view.getVisibility() == 8) {
            this.mPauseView.setVisibility(0);
            this.mPauseView.bringToFront();
        }
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null) {
            cjg.O0000OOo();
        }
        if (mg.O00000o0(this.mContext) && !this.mAllowMobileNetwork) {
            gqg.O000000o((int) R.string.nowifi_pausing);
            this.mIsUserPause = true;
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
        if (view.getId() == R.id.pause_view) {
            this.mIsUserPause = false;
            resumeCamera();
        } else if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.retry_tv || view.getId() == R.id.retry_btn) {
            this.mRetryCount = 0;
            if (!mg.O00000o(this.mContext)) {
                showError(getString(R.string.common_net_error));
            } else if (mg.O00000o0(this.mContext) && !this.mAllowMobileNetwork) {
                hidError();
                pauseCamera();
            }
            hidError();
            showLoading(getString(R.string.camera_play_initial_0));
            cjg cjg = this.mCameraPlayerEx;
            if (cjg != null) {
                cjg.O0000o0o();
                this.mCameraPlayerEx.O0000o();
            } else {
                lambda$hideUpdateIng$5$GeneralCameraPlayerBaseActivity();
            }
        } else if (view.getId() != R.id.see_help) {
            return false;
        } else {
            new DialogCameraDeviceError(this.mContext, this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), this.isOffline).show();
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
                    String language = getResources().getConfiguration().locale.getLanguage();
                    if (TextUtils.isEmpty(language) || !language.contains("tr")) {
                        this.mLoadingProgress.setText("0%");
                    } else {
                        this.mLoadingProgress.setText("%0");
                    }
                } else {
                    this.mLoadingTitle.setText((int) R.string.camera_play_initial_buffer);
                    this.mLoadingProgress.setText("");
                    this.mLoadingProgress.setTag(null);
                }
            }
        }
    }

    public void hideLoading() {
        if (this.mLoadingView != null) {
            if (!this.mUpdating || !mg.O000000o(this.mContext)) {
                this.mLoadingAnimation.stop();
                this.mLoadingProgress.setText("");
                this.mLoadingProgress.setTag(null);
                this.mHandler.removeMessages(4);
                this.mLoadingView.setVisibility(8);
            }
        }
    }

    public void showUpdateIng(int i) {
        cjg cjg;
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
            if (!(text == null || text.toString().equals(this.UPDATE_ING) || (cjg = this.mCameraPlayerEx) == null)) {
                cjg.O0000OOo();
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
                        /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$xn2nL5UGLOEPaqpYeEgd1iIRMIY */

                        public final void run() {
                            GeneralCameraPlayerBaseActivity.this.lambda$hideUpdateIng$5$GeneralCameraPlayerBaseActivity();
                        }
                    }, 3000);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void hidError() {
        if (this.mErrorRetryView.getVisibility() == 0) {
            this.mErrorRetryView.setVisibility(8);
        }
        onHidError();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void showError(String str) {
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null) {
            if (cjg.O0000O0o()) {
                doStopRecord();
            }
            if (this.mCameraPlayerEx.O00000o0()) {
                doStopCall();
            }
        }
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
                    /* class com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity.AnonymousClass6 */

                    public void onSuccess(Long l) {
                        if (!GeneralCameraPlayerBaseActivity.this.isFinishing() && GeneralCameraPlayerBaseActivity.this.offline_time != null) {
                            GeneralCameraPlayerBaseActivity.this.offline_time.setText(MessageFormat.format("{0}：{1}", GeneralCameraPlayerBaseActivity.this.getString(R.string.offline_time_str), GeneralCameraPlayerBaseActivity.this.simpleDateFormat.format(new Date(l.longValue() * 1000))));
                            GeneralCameraPlayerBaseActivity.this.offline_time.setVisibility(0);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (GeneralCameraPlayerBaseActivity.this.isFinishing()) {
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
    public boolean isGPUDecoder() {
        return this.mCameraPlayerEx != null;
    }

    /* access modifiers changed from: protected */
    public void setWindow(Configuration configuration) {
        if (configuration.orientation == 2) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().clearFlags(1024);
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
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$timwdbjw5qG1sNDJnvU_rUBmJK4 */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    GeneralCameraPlayerBaseActivity.this.lambda$dealRetry$6$GeneralCameraPlayerBaseActivity(this.f$1);
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

    public /* synthetic */ void lambda$dealRetry$6$GeneralCameraPlayerBaseActivity(int i) {
        gsy.O00000Oo("CameraPlay", "retry " + this.mRetryCount + " " + i);
        cjg cjg = this.mCameraPlayerEx;
        if (cjg != null) {
            cjg.O0000o0o();
            this.mCameraPlayerEx.O0000o();
        }
    }

    public void onPauseCamera() {
        pauseCamera();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.avCheckRunnable);
        }
    }

    /* access modifiers changed from: protected */
    public void setIsConnected() {
        this.mConnected = true;
    }

    /* access modifiers changed from: protected */
    public void handleVideoPlayErrorOnMISS() {
        super.handleVideoPlayErrorOnMISS();
        if (this.mCameraPlayerEx != null && this.mHandler != null) {
            gsy.O00000Oo("GeneralCameraPlayerBaseActivity", "run handleVideoPlayErrorOnMISS");
            this.mCameraPlayerEx.O0000o0o();
            this.mHandler.removeCallbacks(this.delayedReconnectRunnable);
            this.mHandler.postDelayed(this.delayedReconnectRunnable, 5000);
        }
    }

    public /* synthetic */ void lambda$new$8$GeneralCameraPlayerBaseActivity(int i) {
        int i2;
        if (i >= 0 && (i2 = i / 1000) != this.mCurrentRecordTime) {
            this.mCurrentRecordTime = i2;
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$GeneralCameraPlayerBaseActivity$PvOiXlHDttlH5aQei1thdK0lN9w */

                public final void run() {
                    GeneralCameraPlayerBaseActivity.this.lambda$null$7$GeneralCameraPlayerBaseActivity();
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, int):java.lang.String
     arg types: [com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(android.content.Context, float):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String */
    public /* synthetic */ void lambda$null$7$GeneralCameraPlayerBaseActivity() {
        upDateTimeTitle(cin.O000000o((Context) this, this.mCurrentRecordTime));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public void updateUserExperiencePlan() {
        if (this.mCameraDevice != null) {
            boolean isUsrExpPlanEnabled = XmPluginHostApi.instance().isUsrExpPlanEnabled(this.mCameraDevice.getDid());
            Context context = gkv.f17949O000000o;
            boolean O00000o0 = gpy.O00000o0(context, "prefs_camera_usr_exp_plan", "camera_usr_exp_plan_" + this.mCameraDevice.getDid(), false);
            cki.O00000o("GeneralCameraPlayerBaseActivity", "updateUserExperiencePlan:" + isUsrExpPlanEnabled + ":" + O00000o0);
            if (O00000o0 != isUsrExpPlanEnabled || !isUsrExpPlanEnabled) {
                Context context2 = gkv.f17949O000000o;
                gpy.O000000o(context2, "prefs_camera_usr_exp_plan", "camera_usr_exp_plan_" + this.mCameraDevice.getDid(), isUsrExpPlanEnabled);
                this.mCameraDevice.O000000o(isUsrExpPlanEnabled);
            }
        }
    }
}
