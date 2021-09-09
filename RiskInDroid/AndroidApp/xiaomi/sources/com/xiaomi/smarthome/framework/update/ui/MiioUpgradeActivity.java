package com.xiaomi.smarthome.framework.update.ui;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfb;
import _m_j.gfi;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.gyf;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.TitleBarUtil;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiioUpgradeActivity extends BaseActivity {
    private static final String[] O00oOooO = {"idle", "downloading", "downloaded", "wait_install", "installing", "installed", "failed", "busy"};

    /* renamed from: O000000o  reason: collision with root package name */
    gyf f8698O000000o;
    Device O00000Oo;
    View O00000o;
    ViewSwitcher O00000o0;
    PieProgressBar O00000oO;
    TextView O00000oo;
    TextView O0000O0o;
    TextView O0000OOo;
    Button O0000Oo;
    TextView O0000Oo0;
    ProgressBar O0000OoO;
    boolean O0000Ooo = false;
    DISPLAY_STATE O0000o;
    boolean O0000o0 = false;
    boolean O0000o00 = false;
    gfi O0000o0O;
    OTA_STATE O0000o0o;
    int O0000oO = 0;
    int O0000oO0 = 0;
    String O0000oOO;
    boolean O0000oOo = false;
    int O0000oo = 0;
    ValueAnimator O0000oo0;
    int O0000ooO = 0;
    int O0000ooo = -1;
    private boolean O00oOooo = false;

    enum DISPLAY_STATE {
        DISPLAY_IDLE,
        DISPLAY_DOWNLOADING,
        DISPLAY_DOWNLOADED,
        DISPLAY_WAIT_INSTALL,
        DISPLAY_INSTALLING,
        DISPLAY_INSTALLED,
        DISPLAY_FAILED,
        DISPLAY_BUSY,
        DISPLAY_FINISHED
    }

    enum OTA_STATE {
        OTA_STATE_IDLE,
        OTA_STATE_DOWNLOADING,
        OTA_STATE_DOWNLOADED,
        OTA_STATE_WAIT_INSTALL,
        OTA_STATE_INSTALLING,
        OTA_STATE_INSTALLED,
        OTA_STATE_FAILED,
        OTA_STATE_BUSY
    }

    public void handleMessage(Message message) {
        Message message2 = message;
        final int i = -1;
        final boolean z = false;
        if (message2.what == 10001) {
            StringBuilder sb = new StringBuilder("handleMessage UPDATE_INFO_MSG ,args: ( ");
            sb.append(message2.arg1 != 0);
            sb.append(",");
            sb.append(message2.arg2 == 0 ? -1 : message2.arg2);
            sb.append(" )");
            O000000o(sb.toString());
            if (message2.arg1 != 0) {
                z = true;
            }
            if (message2.arg2 != 0) {
                i = message2.arg2;
            }
            O000000o("updateModelUpdateInfo, args:( ignoreError :" + z + ",retryCount: " + i + " ); mIsPollingInfo: " + this.O0000Ooo);
            if (!this.O0000Ooo) {
                this.O0000Ooo = true;
                gfb.O000000o().O00000Oo(this, this.f8698O000000o.O00000Oo, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass11 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (MiioUpgradeActivity.this.isValid()) {
                            gsy.O000000o(3, "ABC", "result ".concat(String.valueOf(jSONObject)));
                            MiioUpgradeActivity.this.O000000o("updateModelUpdateInfo result: ".concat(String.valueOf(jSONObject)));
                            MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                            miioUpgradeActivity.O0000Ooo = false;
                            try {
                                miioUpgradeActivity.processUpdateInfo(jSONObject, i);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
                     arg types: [java.lang.String, int]
                     candidates:
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void */
                    public final void onFailure(fso fso) {
                        if (MiioUpgradeActivity.this.isValid()) {
                            gsy.O000000o(3, "ABC", "update info error " + fso.O00000Oo);
                            MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                            miioUpgradeActivity.O000000o("update info error " + fso.O00000Oo + "; ignoreError: " + z);
                            MiioUpgradeActivity miioUpgradeActivity2 = MiioUpgradeActivity.this;
                            miioUpgradeActivity2.O0000Ooo = false;
                            if (z) {
                                int i = i;
                                if (i == -1) {
                                    Message obtainMessage = miioUpgradeActivity2.mHandler.obtainMessage();
                                    obtainMessage.what = 10001;
                                    obtainMessage.arg1 = 1;
                                    MiioUpgradeActivity.this.mHandler.sendMessageDelayed(obtainMessage, 2000);
                                    return;
                                }
                                int i2 = i - 1;
                                if (i2 > 0) {
                                    gsy.O000000o(3, "ABC", "retry ".concat(String.valueOf(i2)));
                                    MiioUpgradeActivity.this.O000000o("retry ".concat(String.valueOf(i2)));
                                    Message obtainMessage2 = MiioUpgradeActivity.this.mHandler.obtainMessage();
                                    obtainMessage2.what = 10001;
                                    obtainMessage2.arg1 = 1;
                                    obtainMessage2.arg2 = i2;
                                    MiioUpgradeActivity.this.mHandler.sendMessageDelayed(obtainMessage2, 2000);
                                    return;
                                }
                                miioUpgradeActivity2.O0000o0 = true;
                                CoreApi.O000000o().O000000o(MiioUpgradeActivity.this.f8698O000000o.O00000Oo, false);
                                MiioUpgradeActivity.this.mHandler.sendEmptyMessage(10002);
                                return;
                            }
                            miioUpgradeActivity2.O0000o00 = true;
                            miioUpgradeActivity2.O0000o0 = true;
                            CoreApi.O000000o().O000000o(MiioUpgradeActivity.this.f8698O000000o.O00000Oo, false);
                            MiioUpgradeActivity.this.O0000o = DISPLAY_STATE.DISPLAY_FAILED;
                            MiioUpgradeActivity.this.mHandler.sendEmptyMessage(10002);
                        }
                    }
                });
            }
        } else if (message2.what == 10002) {
            O000000o("handleMessage REFRESH_UI_MSG ");
            if (this.O0000o != null) {
                if (this.O00000o0.getCurrentView() == this.O00000o) {
                    this.O00000o0.showNext();
                }
                O000000o("showInfo");
                this.O0000OoO.setVisibility(8);
                this.O0000O0o.setVisibility(0);
                this.O0000Oo.setEnabled(true);
                O000000o("refreshUI---mDisplayState:" + this.O0000o + "---mIsFailure:" + this.O0000o00 + "---mTimeout:" + this.O0000o0);
                if (this.O0000o00 || this.O0000o0 || this.O0000o.ordinal() == DISPLAY_STATE.DISPLAY_FAILED.ordinal()) {
                    gsy.O000000o(3, "ABC", "fail type failed " + this.O0000o00 + " timeout " + this.O0000o0 + " state " + this.O0000o.ordinal());
                    gsy.O000000o(3, "ABC", "showFailure");
                    this.O0000OOo.setVisibility(8);
                    this.O0000Oo0.setVisibility(8);
                    this.O0000Oo.setVisibility(this.O0000o0O != null ? 0 : 8);
                    this.O0000Oo.setText((int) R.string.mj_retry);
                    this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass12 */

                        public final void onClick(View view) {
                            MiioUpgradeActivity.this.resetState();
                            MiioUpgradeActivity.this.O0000o = DISPLAY_STATE.DISPLAY_DOWNLOADING;
                            MiioUpgradeActivity.this.mHandler.sendEmptyMessage(10002);
                            MiioUpgradeActivity.this.O000000o();
                        }
                    });
                    this.O00000oO.setBackgroundResource(R.drawable.update_img_failed);
                    this.O00000oO.setPercent(0.0f);
                    this.O00000oo.setVisibility(8);
                    this.O0000OoO.setVisibility(8);
                    this.O00000oO.setVisibility(0);
                    if (!CoreApi.O000000o().O0000Ooo()) {
                        this.O0000O0o.setText((int) R.string.update_failed_not_login);
                        this.O00000oO.setOnClickListener(null);
                    } else if (!this.O00000Oo.isOnline) {
                        this.O0000O0o.setText((int) R.string.update_failed_offline);
                    } else if (this.O0000o0) {
                        this.O0000O0o.setText((int) R.string.update_failed_timeout);
                    } else if (!TextUtils.isEmpty(this.O0000o0O.O0000Oo0)) {
                        this.O0000O0o.setText(this.O0000o0O.O0000Oo0);
                    } else {
                        this.O0000O0o.setText((int) R.string.update_failed_retry);
                    }
                    O000000o("showFailure");
                } else if (this.O0000o.ordinal() == DISPLAY_STATE.DISPLAY_DOWNLOADING.ordinal() || this.O0000o.ordinal() == DISPLAY_STATE.DISPLAY_DOWNLOADED.ordinal()) {
                    gsy.O000000o(3, "ABC", "showProgress");
                    this.O0000O0o.setText((int) R.string.model_updating);
                    this.O0000OOo.setVisibility(8);
                    this.O0000Oo0.setVisibility(0);
                    if (this.O0000o0o != OTA_STATE.OTA_STATE_FAILED || TextUtils.isEmpty(this.O0000o0O.O0000Oo0)) {
                        this.O0000Oo0.setText((int) R.string.miio_update_tips);
                    } else {
                        this.O0000Oo0.setText(this.O0000o0O.O0000Oo0);
                    }
                    this.O0000Oo.setVisibility(4);
                    this.O00000oO.setVisibility(0);
                    this.O00000oO.setOnClickListener(null);
                    this.O00000oO.setBackgroundResource(R.drawable.kuailian_progress_filled_not);
                    this.O00000oo.setVisibility(0);
                    if ((this.O0000oO != 0 || this.O0000oO0 == 100) && this.O0000oO0 - this.O0000oO >= 10) {
                        gsy.O00000Oo("ABC", "animate Progress: mDisplayProgress: " + this.O0000oO0 + " ;mLastDisplayProgress: " + this.O0000oO);
                        O000000o("animate Progress: mDisplayProgress: " + this.O0000oO0 + " ;mLastDisplayProgress: " + this.O0000oO);
                        if (this.O0000oo0 == null) {
                            this.O0000oo0 = new ValueAnimator();
                            this.O0000oo0.setFloatValues(0.0f, 1.0f);
                            this.O0000oo0.setDuration(1000L);
                            this.O0000oo0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass13 */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    int animatedFraction = (int) (((float) MiioUpgradeActivity.this.O0000oO) + (((float) (MiioUpgradeActivity.this.O0000oO0 - MiioUpgradeActivity.this.O0000oO)) * valueAnimator.getAnimatedFraction()));
                                    MiioUpgradeActivity.this.O00000oO.setPercent((float) animatedFraction);
                                    gsy.O00000Oo("ABC", "onAnimationUpdate: ".concat(String.valueOf(animatedFraction)));
                                    MiioUpgradeActivity.this.O000000o("onAnimationUpdate: ".concat(String.valueOf(animatedFraction)));
                                }
                            });
                            this.O0000oo0.addListener(new Animator.AnimatorListener() {
                                /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass14 */

                                public final void onAnimationRepeat(Animator animator) {
                                }

                                public final void onAnimationStart(Animator animator) {
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                                    miioUpgradeActivity.O0000oO = miioUpgradeActivity.O0000oO0;
                                    MiioUpgradeActivity.this.O00000oO.setPercent((float) MiioUpgradeActivity.this.O0000oO0);
                                    gsy.O00000Oo("ABC", "onAnimationEnd: " + MiioUpgradeActivity.this.O0000oO0);
                                    MiioUpgradeActivity miioUpgradeActivity2 = MiioUpgradeActivity.this;
                                    miioUpgradeActivity2.O000000o("onAnimationEnd: " + MiioUpgradeActivity.this.O0000oO0);
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    MiioUpgradeActivity.this.O00000oO.setPercent((float) MiioUpgradeActivity.this.O0000oO0);
                                    MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                                    miioUpgradeActivity.O0000oO = miioUpgradeActivity.O0000oO0;
                                }
                            });
                        }
                        if (this.O0000oo0.isRunning()) {
                            gsy.O00000Oo("ABC", "cancel the running animator : ");
                            O000000o("cancel the running animator : ");
                            this.O0000oo0.cancel();
                        }
                        this.O0000oo0.start();
                    } else {
                        this.O00000oO.setPercent((float) this.O0000oO0);
                        this.O0000oO = this.O0000oO0;
                        gsy.O00000Oo("ABC", "showProgress: mDisplayProgress: " + this.O0000oO0 + " ;mLastDisplayProgress: " + this.O0000oO);
                        O000000o("showProgress: mDisplayProgress: " + this.O0000oO0 + " ;mLastDisplayProgress: " + this.O0000oO);
                    }
                    int i2 = this.O0000ooo;
                    if (i2 == -1) {
                        Message obtainMessage = this.mHandler.obtainMessage();
                        obtainMessage.what = 10001;
                        obtainMessage.arg1 = 1;
                        this.mHandler.sendMessageDelayed(obtainMessage, 2000);
                    } else {
                        this.O0000ooo = i2 - 1;
                        if (this.O0000ooo == 0) {
                            this.O0000o0 = true;
                            this.mHandler.sendEmptyMessage(10002);
                        } else {
                            Message obtainMessage2 = this.mHandler.obtainMessage();
                            obtainMessage2.what = 10001;
                            obtainMessage2.arg1 = 1;
                            obtainMessage2.arg2 = this.O0000ooo;
                            this.mHandler.sendMessageDelayed(obtainMessage2, 2000);
                        }
                    }
                    O000000o("showProgress");
                } else if (this.O0000o.ordinal() == DISPLAY_STATE.DISPLAY_WAIT_INSTALL.ordinal()) {
                    gsy.O000000o(3, "ABC", "showWaitInstall");
                    this.O00000oo.setVisibility(8);
                    this.O00000oO.setBackgroundResource(R.drawable.update_img_update);
                    this.O00000oO.setPercent(0.0f);
                    this.O00000oO.setOnClickListener(null);
                    this.O0000O0o.setText(getResources().getString(R.string.list_item_curr_version) + " " + this.O0000o0O.O00000Oo + "\n\n" + getResources().getString(R.string.list_item_latest_version) + " " + this.O0000o0O.O00000o0);
                    this.O0000OOo.setVisibility(0);
                    this.O0000OOo.setText(this.O0000o0O.O00000o);
                    this.O0000Oo0.setVisibility(8);
                    this.O0000Oo.setVisibility(0);
                    this.O0000Oo.setText((int) R.string.update_now);
                    this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass2 */

                        public final void onClick(View view) {
                            MiioUpgradeActivity.this.O0000o = DISPLAY_STATE.DISPLAY_INSTALLING;
                            MiioUpgradeActivity.this.mHandler.sendEmptyMessage(10002);
                            if (MiioUpgradeActivity.this.O0000o0o.ordinal() == OTA_STATE.OTA_STATE_DOWNLOADED.ordinal()) {
                                MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                                miioUpgradeActivity.O000000o("startRestartUpdate");
                                if (!miioUpgradeActivity.O0000Ooo) {
                                    miioUpgradeActivity.O0000Ooo = true;
                                    miioUpgradeActivity.O0000oOO = miioUpgradeActivity.O0000o0O.O00000o0;
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("method", "miIO.ota_install");
                                        jSONObject.put("params", new JSONArray());
                                    } catch (Exception unused) {
                                    }
                                    DeviceApi.getInstance().rpcAsyncRemote(miioUpgradeActivity, miioUpgradeActivity.f8698O000000o.O00000Oo, jSONObject.toString(), new fsm<JSONObject, fso>() {
                                        /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass3 */

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            JSONObject jSONObject = (JSONObject) obj;
                                            gsy.O000000o(3, "ABC", "start restart success ".concat(String.valueOf(jSONObject)));
                                            MiioUpgradeActivity.this.O000000o("start restart success ".concat(String.valueOf(jSONObject)));
                                            MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                                            miioUpgradeActivity.O0000Ooo = false;
                                            Message obtainMessage = miioUpgradeActivity.mHandler.obtainMessage();
                                            obtainMessage.what = 10001;
                                            obtainMessage.arg1 = 1;
                                            MiioUpgradeActivity.this.mHandler.sendMessageDelayed(obtainMessage, 2000);
                                            MiioUpgradeActivity.this.mHandler.sendEmptyMessage(10002);
                                        }

                                        public final void onFailure(fso fso) {
                                            gsy.O000000o(3, "ABC", "on failure 615 " + fso.O00000Oo);
                                            MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                                            miioUpgradeActivity.O000000o("on failure 615 " + fso.O00000Oo);
                                            MiioUpgradeActivity.this.O0000Ooo = false;
                                            if (fso.f17063O000000o == ErrorCode.ERROR_REQUEST_TIME_OUT.getCode()) {
                                                Message obtainMessage = MiioUpgradeActivity.this.mHandler.obtainMessage();
                                                obtainMessage.what = 10001;
                                                obtainMessage.arg1 = 1;
                                                obtainMessage.arg2 = 5;
                                                MiioUpgradeActivity.this.mHandler.sendMessageDelayed(obtainMessage, 2000);
                                            } else {
                                                MiioUpgradeActivity.this.O0000o00 = true;
                                            }
                                            MiioUpgradeActivity.this.mHandler.sendEmptyMessage(10002);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            MiioUpgradeActivity.this.O000000o();
                        }
                    });
                    Message obtainMessage3 = this.mHandler.obtainMessage();
                    obtainMessage3.what = 10001;
                    obtainMessage3.arg1 = 1;
                    this.mHandler.sendMessageDelayed(obtainMessage3, 2000);
                    O000000o("showWaitInstall");
                } else if (this.O0000o.ordinal() == DISPLAY_STATE.DISPLAY_INSTALLING.ordinal() || this.O0000o.ordinal() == DISPLAY_STATE.DISPLAY_INSTALLED.ordinal()) {
                    gsy.O000000o(3, "ABC", "show installing");
                    this.O0000O0o.setText((int) R.string.update_installing);
                    this.O0000OOo.setVisibility(8);
                    this.O0000Oo0.setVisibility(0);
                    this.O0000Oo.setVisibility(4);
                    this.O0000OoO.setVisibility(0);
                    this.O00000oO.setVisibility(8);
                    this.O00000oO.setOnClickListener(null);
                    this.O00000oO.setBackgroundResource(R.drawable.kuailian_progress_filled_not);
                    this.O00000oo.setVisibility(8);
                    this.O0000Oo0.setText((int) R.string.update_installing_info);
                    if (this.O0000o.ordinal() == DISPLAY_STATE.DISPLAY_INSTALLING.ordinal()) {
                        if ((System.currentTimeMillis() / 1000) - this.O0000o0O.O0000OoO > ((long) this.O0000o0O.O0000Oo)) {
                            this.O0000oo++;
                        }
                        if (this.O0000oo > 90) {
                            this.O0000o0 = true;
                            this.mHandler.sendEmptyMessage(10002);
                        } else {
                            Message obtainMessage4 = this.mHandler.obtainMessage();
                            obtainMessage4.what = 10001;
                            obtainMessage4.arg1 = 1;
                            this.mHandler.sendMessageDelayed(obtainMessage4, 2000);
                        }
                    } else {
                        this.O0000ooO++;
                        if (this.O0000ooO > 90) {
                            this.O0000o0 = true;
                            this.mHandler.sendEmptyMessage(10002);
                        } else {
                            Message obtainMessage5 = this.mHandler.obtainMessage();
                            obtainMessage5.what = 10001;
                            obtainMessage5.arg1 = 1;
                            this.mHandler.sendMessageDelayed(obtainMessage5, 2000);
                        }
                    }
                    O000000o("showInstalling");
                } else if (!this.O0000o0O.O00000oO) {
                    gsy.O000000o(3, "ABC", "showUpdateInfo");
                    this.O00000oo.setVisibility(8);
                    this.O00000oO.setBackgroundResource(R.drawable.update_img_update);
                    this.O00000oO.setPercent(0.0f);
                    this.O00000oO.setOnClickListener(null);
                    this.O0000O0o.setText(getResources().getString(R.string.list_item_curr_version) + " " + this.O0000o0O.O00000Oo + "\n\n" + getResources().getString(R.string.list_item_latest_version) + " " + this.O0000o0O.O00000o0);
                    this.O0000OOo.setVisibility(0);
                    this.O0000OOo.setText(this.O0000o0O.O00000o);
                    this.O0000Oo0.setVisibility(8);
                    this.O0000Oo.setVisibility(0);
                    this.O0000Oo.setText((int) R.string.update_now);
                    this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass5 */

                        public final void onClick(View view) {
                            MiioUpgradeActivity.this.resetState();
                            MiioUpgradeActivity.this.O0000o = DISPLAY_STATE.DISPLAY_DOWNLOADING;
                            MiioUpgradeActivity.this.mHandler.sendEmptyMessage(10002);
                            MiioUpgradeActivity.this.O000000o();
                        }
                    });
                    if (!this.O00000Oo.isOnline) {
                        this.O0000Oo.setEnabled(false);
                    }
                    O000000o("showUpdateInfo");
                } else {
                    O000000o("showFinish");
                    gsy.O000000o(3, "ABC", "showFinish");
                    if (this.O0000oOo) {
                        this.O00000oO.setBackgroundResource(R.drawable.update_img_success);
                        this.O0000O0o.setText(getResources().getString(R.string.model_update_success) + "\n\n" + getResources().getString(R.string.app_curr_version) + " " + this.O0000o0O.O00000Oo);
                    } else {
                        this.O00000oO.setBackgroundResource(R.drawable.update_img_latest);
                        this.O0000O0o.setText(getResources().getString(R.string.model_latest) + "\n\n" + getResources().getString(R.string.app_curr_version) + " " + this.O0000o0O.O00000Oo);
                    }
                    this.O00000oo.setVisibility(8);
                    this.O00000oO.setPercent(0.0f);
                    this.O00000oO.setOnClickListener(null);
                    this.O00000oO.setVisibility(0);
                    this.O0000OOo.setVisibility(8);
                    this.O0000Oo0.setVisibility(8);
                    this.O0000Oo.setVisibility(0);
                    this.O0000Oo.setText((int) R.string.ok_button);
                    this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass6 */

                        public final void onClick(View view) {
                            MiioUpgradeActivity.this.finish();
                        }
                    });
                }
            }
        }
        super.handleMessage(message);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o("onCreate ");
        setContentView((int) R.layout.miio_setting_update);
        Intent intent = getIntent();
        this.f8698O000000o = new gyf();
        this.f8698O000000o.O00000Oo = intent.getStringExtra("miio_upgrade_did");
        this.f8698O000000o.O00000o0 = intent.getIntExtra("miio_upgrade_pid", 0);
        this.f8698O000000o.O00000o = intent.getStringExtra("miio_upgrade_name");
        this.O00000Oo = fno.O000000o().O000000o(this.f8698O000000o.O00000Oo);
        if (this.O00000Oo == null) {
            finish();
            return;
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass7 */

            public final void onClick(View view) {
                MiioUpgradeActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(this.f8698O000000o.O00000o);
        this.O00000o0 = (ViewSwitcher) findViewById(R.id.vs_root);
        this.O00000o = findViewById(R.id.ll_loading);
        this.O00000oO = (PieProgressBar) findViewById(R.id.pb_progress);
        this.O00000oo = (TextView) findViewById(R.id.txt_progress);
        this.O0000O0o = (TextView) findViewById(R.id.txt_update_title);
        this.O0000OOo = (TextView) findViewById(R.id.txt_update_desc);
        this.O0000Oo0 = (TextView) findViewById(R.id.txt_updating_tip);
        this.O0000Oo = (Button) findViewById(R.id.btn_bottom);
        this.O00000oO.setPercentView(this.O00000oo);
        this.O0000OoO = (ProgressBar) findViewById(R.id.installing_progress_bar);
        if (!this.O00000Oo.isOnline) {
            getWindow().getDecorView().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass1 */

                public final void run() {
                    MiioUpgradeActivity.this.addOfflineFloatingView();
                }
            });
        }
        if (this.O00000o0.getCurrentView() != this.O00000o) {
            this.O00000o0.showNext();
        }
        O000000o("showLoading");
    }

    public void onResume() {
        O000000o("onResume: ");
        super.onResume();
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 10001;
        obtainMessage.arg1 = 0;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void onPause() {
        super.onPause();
        O000000o("onPause: ");
        ValueAnimator valueAnimator = this.O0000oo0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mHandler.removeMessages(10001);
        this.mHandler.removeMessages(10002);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void */
    public void onDestroy() {
        super.onDestroy();
        O000000o("onDestroy: ");
        CoreApi.O000000o().O000000o(this.f8698O000000o.O00000Oo, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x008f, code lost:
        if (r6.y == r5.y) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a1, code lost:
        if (r5 == false) goto L_0x00a4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ab  */
    public void addOfflineFloatingView() {
        boolean z;
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        final ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate((int) R.layout.device_offline_floating_view, (ViewGroup) null);
        int i = 0;
        viewGroup.setClickable(false);
        viewGroup.findViewById(R.id.read_detail_tv).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass8 */

            public final void onClick(View view) {
                fbt fbt = new fbt(MiioUpgradeActivity.this, "DeviceOfflineDetailActivity");
                if (MiioUpgradeActivity.this.O00000Oo != null) {
                    fbt.O000000o("extra_model", MiioUpgradeActivity.this.O00000Oo.model);
                }
                Intent intent = MiioUpgradeActivity.this.getIntent();
                if (intent != null) {
                    fbt.O000000o(intent.getExtras());
                }
                fbt.O00000Oo(268435456);
                fbs.O000000o(fbt);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Resources resources = getResources();
        if (TitleBarUtil.TRANSLUCENT_STATUS_ENABLED) {
            layoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.mj_titlebar_height) + resources.getDimensionPixelOffset(R.dimen.title_bar_top_padding);
        } else {
            layoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.mj_titlebar_height) + resources.getDimensionPixelOffset(R.dimen.title_bar_top_padding) + resources.getDimensionPixelOffset(R.dimen.title_bar_top_padding);
        }
        if (Build.VERSION.SDK_INT < 17 || Settings.Global.getInt(getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
            if (Build.VERSION.SDK_INT >= 17) {
                Display defaultDisplay = getWindowManager().getDefaultDisplay();
                Point point = new Point();
                Point point2 = new Point();
                defaultDisplay.getSize(point);
                defaultDisplay.getRealSize(point2);
            } else {
                boolean hasPermanentMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey();
                boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
                if (!hasPermanentMenuKey) {
                }
            }
            z = true;
            this.O00oOooo = z;
            if (this.O00oOooo) {
                if (Build.VERSION.SDK_INT < 24 || !isInMultiWindowMode()) {
                    if (hasNavBar(this)) {
                        Resources resources2 = getResources();
                        i = resources2.getDimensionPixelSize(resources2.getIdentifier("navigation_bar_height", "dimen", "android"));
                    }
                    layoutParams.bottomMargin = i;
                } else {
                    layoutParams.bottomMargin = 0;
                }
            }
            frameLayout.addView(viewGroup, layoutParams);
            viewGroup.findViewById(R.id.delete_btn).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass9 */

                public final void onClick(View view) {
                    MiioUpgradeActivity.this.disappearBtmBar(viewGroup.findViewById(R.id.bottom_rl));
                }
            });
            final View findViewById = viewGroup.findViewById(R.id.bottom_rl);
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass10 */

                public final void run() {
                    findViewById.setVisibility(0);
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    int bottom = viewGroup.getBottom() - viewGroup.getTop();
                    float f = MiioUpgradeActivity.this.getResources().getDisplayMetrics().density;
                    float f2 = (float) bottom;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, View.Y, f2, f2 - (f * 70.0f));
                    ofFloat.setInterpolator(new TimeInterpolator() {
                        /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass10.AnonymousClass1 */

                        public final float getInterpolation(float f) {
                            if (f <= 0.8f) {
                                double d = (double) f;
                                Double.isNaN(d);
                                return (float) (d * 1.5d);
                            }
                            double d2 = (double) f;
                            Double.isNaN(d2);
                            return (float) (2.0d - d2);
                        }
                    });
                    ofFloat.setDuration(600L);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.play(ofFloat);
                    animatorSet.start();
                }
            }, 1000);
        }
        z = false;
        this.O00oOooo = z;
        if (this.O00oOooo) {
        }
        frameLayout.addView(viewGroup, layoutParams);
        viewGroup.findViewById(R.id.delete_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass9 */

            public final void onClick(View view) {
                MiioUpgradeActivity.this.disappearBtmBar(viewGroup.findViewById(R.id.bottom_rl));
            }
        });
        final View findViewById2 = viewGroup.findViewById(R.id.bottom_rl);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass10 */

            public final void run() {
                findViewById2.setVisibility(0);
                ViewGroup viewGroup = (ViewGroup) findViewById2.getParent();
                int bottom = viewGroup.getBottom() - viewGroup.getTop();
                float f = MiioUpgradeActivity.this.getResources().getDisplayMetrics().density;
                float f2 = (float) bottom;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById2, View.Y, f2, f2 - (f * 70.0f));
                ofFloat.setInterpolator(new TimeInterpolator() {
                    /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass10.AnonymousClass1 */

                    public final float getInterpolation(float f) {
                        if (f <= 0.8f) {
                            double d = (double) f;
                            Double.isNaN(d);
                            return (float) (d * 1.5d);
                        }
                        double d2 = (double) f;
                        Double.isNaN(d2);
                        return (float) (2.0d - d2);
                    }
                });
                ofFloat.setDuration(600L);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(ofFloat);
                animatorSet.start();
            }
        }, 1000);
    }

    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        String O00000Oo2 = O00000Oo();
        if ("1".equals(O00000Oo2)) {
            return false;
        }
        if ("0".equals(O00000Oo2)) {
            return true;
        }
        return z;
    }

    private static String O00000Oo() {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void disappearBtmBar(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.Y, (float) (viewGroup.getHeight() - view.getHeight()), (float) viewGroup.getHeight());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        if (gfr.O0000Ooo) {
            try {
                StringBuilder sb = new StringBuilder("MiioUpgradeActivity : ");
                sb.append(str);
                sb.append(" : ");
                sb.append("mLastState: ");
                String str2 = "null";
                sb.append(this.O0000o0o == null ? str2 : this.O0000o0o);
                sb.append("; ");
                sb.append("mDisplayState: ");
                sb.append(this.O0000o == null ? str2 : this.O0000o);
                sb.append("; ");
                sb.append("mLastDisplayProgress: ");
                sb.append(this.O0000oO);
                sb.append("; ");
                sb.append("mDisplayProgress: ");
                sb.append(this.O0000oO0);
                sb.append("; ");
                sb.append("mRetryCount: ");
                sb.append(this.O0000ooo);
                sb.append("; ");
                sb.append("mRetartCount: ");
                sb.append(this.O0000ooO);
                sb.append("; ");
                sb.append("mIsFailure: ");
                sb.append(this.O0000o00);
                sb.append(";");
                sb.append("mUpdateSucc: ");
                sb.append(this.O0000oOo);
                sb.append("; ");
                sb.append("mTimeout: ");
                sb.append(this.O0000o0);
                sb.append("; ");
                sb.append("mInstallingCount: ");
                sb.append(this.O0000oo);
                sb.append("; ");
                sb.append("mInfo: ");
                if (this.O0000o0O != null) {
                    str2 = this.O0000o0O.toString();
                }
                sb.append(str2);
                sb.append("; ");
                sb.append("stamp: ");
                sb.append(System.currentTimeMillis());
                sb.append("; ");
                gsy.O00000o0(LogType.GENERAL, "", sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean O00000Oo(String str) {
        gfi gfi = this.O0000o0O;
        if (gfi == null) {
            return false;
        }
        String str2 = gfi.O00000Oo;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (str2.startsWith("_")) {
            str2 = str2.substring(1);
        }
        if (str.startsWith("_")) {
            str = str.substring(1);
        }
        return str2.equals(str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void */
    /* access modifiers changed from: package-private */
    public final void O000000o() {
        O000000o("startModelUpdate");
        if (!this.O0000Ooo) {
            this.O0000Ooo = true;
            this.O0000oOO = this.O0000o0O.O00000o0;
            CoreApi.O000000o().O000000o(this.f8698O000000o.O00000Oo, true);
            gfb.O000000o().O00000o0(this, this.f8698O000000o.O00000Oo, this.f8698O000000o.O00000o0, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity.AnonymousClass4 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
                 arg types: [java.lang.String, int]
                 candidates:
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void */
                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    gsy.O000000o(3, "ABC", "start model update success ".concat(String.valueOf(jSONObject)));
                    MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                    miioUpgradeActivity.O0000Ooo = false;
                    miioUpgradeActivity.O000000o("start model update success ".concat(String.valueOf(jSONObject)));
                    CoreApi.O000000o().O000000o(MiioUpgradeActivity.this.f8698O000000o.O00000Oo, true);
                    Message obtainMessage = MiioUpgradeActivity.this.mHandler.obtainMessage();
                    obtainMessage.what = 10001;
                    obtainMessage.arg1 = 1;
                    MiioUpgradeActivity.this.mHandler.sendMessageDelayed(obtainMessage, 2000);
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
                 arg types: [java.lang.String, int]
                 candidates:
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void */
                public final void onFailure(fso fso) {
                    gsy.O000000o(3, "ABC", "on fail 642 " + fso.O00000Oo + " " + fso.f17063O000000o);
                    MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                    miioUpgradeActivity.O000000o("on fail 642 " + fso.O00000Oo + " " + fso.f17063O000000o);
                    MiioUpgradeActivity.this.O0000Ooo = false;
                    if (fso.f17063O000000o == ErrorCode.ERROR_REQUEST_TIME_OUT.getCode()) {
                        Message obtainMessage = MiioUpgradeActivity.this.mHandler.obtainMessage();
                        obtainMessage.what = 10001;
                        obtainMessage.arg1 = 1;
                        obtainMessage.arg2 = 5;
                        MiioUpgradeActivity.this.mHandler.sendMessageDelayed(obtainMessage, 2000);
                    } else {
                        MiioUpgradeActivity.this.O0000o00 = true;
                        CoreApi.O000000o().O000000o(MiioUpgradeActivity.this.f8698O000000o.O00000Oo, false);
                    }
                    MiioUpgradeActivity.this.mHandler.sendEmptyMessage(10002);
                }
            });
        }
    }

    public void resetState() {
        this.O0000o00 = false;
        this.O0000o0 = false;
        this.O0000ooO = 0;
        this.O0000oO0 = 0;
        this.O0000oO = 0;
        this.O0000o0o = OTA_STATE.OTA_STATE_IDLE;
        this.O0000oo = 0;
        this.O0000o = DISPLAY_STATE.DISPLAY_IDLE;
        this.O0000ooo = -1;
    }

    public void processUpdateInfo(JSONObject jSONObject, int i) {
        long j;
        gfi gfi = new gfi();
        gfi.f17655O000000o = jSONObject.optBoolean("updating");
        gfi.O00000Oo = jSONObject.optString("curr");
        gfi.O00000o0 = jSONObject.optString("latest");
        gfi.O00000o = jSONObject.optString("description");
        gfi.O00000oO = jSONObject.optBoolean("isLatest");
        gfi.O00000oo = jSONObject.optInt("ota_progress");
        gfi.O0000O0o = jSONObject.optString("ota_status");
        gfi.O0000OOo = jSONObject.optInt("ota_failed_code");
        gfi.O0000Oo0 = jSONObject.optString("ota_failed_reason");
        gfi.O0000Oo = jSONObject.optInt("timeout_time");
        gfi.O0000OoO = jSONObject.optLong("ota_start_time");
        gfi.O0000Ooo = jSONObject.optInt("force");
        O000000o("总是走这个分支");
        gfi gfi2 = this.O0000o0O;
        if (gfi2 != null && gfi2.f17655O000000o) {
            long j2 = this.O0000o0O.O0000OoO;
            if (gfi.O0000OoO == 0) {
                gfi.O0000OoO = j2;
            }
        }
        if (TextUtils.isEmpty(gfi.O00000Oo)) {
            gfi.O00000Oo = this.O00000Oo.version;
        }
        this.O0000o0O = gfi;
        OTA_STATE ota_state = this.O0000o0o;
        if (ota_state == null) {
            ota_state = OTA_STATE.OTA_STATE_IDLE;
        }
        for (int i2 = 0; i2 < O00oOooO.length; i2++) {
            if (TextUtils.equals(gfi.O0000O0o, O00oOooO[i2])) {
                if (i2 != 0 || gfi.O00000oo <= 0 || gfi.O00000oo > 100) {
                    ota_state = OTA_STATE.values()[i2];
                } else {
                    ota_state = OTA_STATE.values()[i2 + 1];
                }
            }
        }
        O000000o("state:".concat(String.valueOf(ota_state)));
        if (this.O0000o0o == null || ota_state.ordinal() == OTA_STATE.OTA_STATE_IDLE.ordinal() || ota_state.ordinal() > this.O0000o0o.ordinal() || ota_state.ordinal() == OTA_STATE.OTA_STATE_FAILED.ordinal()) {
            this.O0000o0o = ota_state;
        }
        O000000o("mLastState:" + this.O0000o0o);
        if (this.O0000o0o.ordinal() == OTA_STATE.OTA_STATE_IDLE.ordinal()) {
            O000000o("空闲状态进入的分支");
            if (O00000Oo(this.O0000oOO)) {
                O000000o("升级成功");
                this.O0000oOo = true;
                fno.O000000o().O0000o0O();
                this.O0000o = DISPLAY_STATE.DISPLAY_FINISHED;
            } else {
                this.O0000ooo = i;
                O000000o("升级失败，重试？mRetryCount:" + this.O0000ooo);
                if (i == -1) {
                    this.O0000o = DISPLAY_STATE.DISPLAY_IDLE;
                }
            }
        } else {
            O000000o("非空闲状态进入的分支");
            if (this.O0000o0O.f17655O000000o) {
                this.O0000oOO = gfi.O00000o0;
            }
            if (O00000Oo(this.O0000oOO)) {
                O000000o("升级成功");
                this.O0000oOo = true;
                fno.O000000o().O0000o0O();
                this.O0000o = DISPLAY_STATE.DISPLAY_FINISHED;
            } else {
                O000000o("没有升级成功");
                long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.O0000o0O.O0000OoO;
                if ((currentTimeMillis - ((long) this.O0000o0O.O0000Oo) <= 5 || this.O0000o0O.f17655O000000o) && !this.O0000o0O.O00000oO) {
                    O000000o("超时但在升级中||没超时||不是最新版本||下载||下载完成||等待安装||安装中||安装完成||失败||忙");
                    DISPLAY_STATE display_state = DISPLAY_STATE.values()[this.O0000o0o.ordinal()];
                    if (this.O0000o == null || display_state.ordinal() > this.O0000o.ordinal()) {
                        this.O0000o = display_state;
                    }
                    if (this.O0000o.ordinal() <= DISPLAY_STATE.DISPLAY_IDLE.ordinal() || this.O0000o.ordinal() >= DISPLAY_STATE.DISPLAY_INSTALLING.ordinal()) {
                        O000000o("超时但在升级中||没超时||不是最新版本||安装中||安装完成||失败||忙");
                        if (currentTimeMillis > ((long) this.O0000o0O.O0000Oo)) {
                            O000000o("超时");
                            if (!this.O0000o0O.f17655O000000o) {
                                this.O0000o = DISPLAY_STATE.DISPLAY_IDLE;
                            }
                        }
                    } else {
                        O000000o("下载，下载完成 或 等待安装中");
                        if (currentTimeMillis > ((long) this.O0000o0O.O0000Oo)) {
                            O000000o("超时了");
                            if (currentTimeMillis - ((long) this.O0000o0O.O0000Oo) < 5) {
                                this.O0000o0 = true;
                                this.O0000o = DISPLAY_STATE.DISPLAY_FAILED;
                            } else if (!gfi.f17655O000000o) {
                                this.O0000o = DISPLAY_STATE.DISPLAY_IDLE;
                            }
                        } else {
                            long j3 = (long) this.O0000o0O.O0000Oo;
                            if (j3 > 0) {
                                j = (currentTimeMillis / j3) * 90;
                            } else {
                                j = currentTimeMillis / 2;
                            }
                            int i3 = (int) j;
                            O000000o("没有超时 progress: ".concat(String.valueOf(i3)));
                            if (this.O0000o0O.O00000oo > 0) {
                                O000000o("正常的进度:".concat(String.valueOf(i3)));
                                if (this.O0000o0O.O00000oo > i3) {
                                    i3 = this.O0000o0O.O00000oo;
                                }
                                O000000o("mDisplayProgress: " + this.O0000oO0);
                                if (i3 > this.O0000oO0) {
                                    this.O0000oO0 = i3;
                                    if (this.O0000oO0 > this.O0000o0O.O00000oo && this.O0000o0O.O00000oo < 90 && this.O0000oO0 > 90) {
                                        this.O0000oO0 = 90;
                                    }
                                    if (this.O0000oO0 > 100) {
                                        this.O0000oO0 = 100;
                                    }
                                }
                            } else {
                                O000000o("异常的进度 可能为-1 也可能大于100");
                                if (i3 > this.O0000oO0) {
                                    this.O0000oO0 = i3;
                                    if (this.O0000oO0 > 90) {
                                        this.O0000oO0 = 90;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    O000000o("超时并且没有在升级中 或者 已经是最新版本了");
                    this.O0000o = DISPLAY_STATE.DISPLAY_IDLE;
                }
            }
        }
        gsy.O000000o(3, "ABC", "display state " + this.O0000o);
        this.mHandler.sendEmptyMessage(10002);
    }
}
