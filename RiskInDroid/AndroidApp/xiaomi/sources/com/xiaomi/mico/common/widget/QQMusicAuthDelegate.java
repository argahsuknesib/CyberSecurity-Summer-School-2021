package com.xiaomi.mico.common.widget;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.djw;
import _m_j.iah;
import _m_j.jdn;
import _m_j.jgc;
import _m_j.jgi;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.qqmusic.third.api.contract.IQQMusicApi;
import com.tencent.qqmusic.third.api.contract.IQQMusicApiCallback;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.api.model.QqMiniProgramResponse;
import com.xiaomi.mico.api.model.QqResponse;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.common.event.QQMusicAuthEvent;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.utils.Threads;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;

public class QQMusicAuthDelegate implements ServiceConnection, AttachedPageLifeCycleListener {
    public static final ahg LOGGER_NEW = new ahg();
    @SuppressLint({"StaticFieldLeak"})
    private static volatile QQMusicAuthDelegate qqMusicAuthDelegate;
    private int QQMusicProcessRet = -1;
    public String authCode;
    public String authCodeOfWX;
    private int authType;
    private boolean bindFlag;
    public Context context;
    private String encryptString;
    private boolean lastAuthNoClient;
    public QQMusicAuthListener listener;
    private IQQMusicApi qqmusicApi;
    private Runnable runnableDelayStartAuth;
    private long startTime;
    public boolean successGetQqMiniProgramAuthResult;
    public boolean successGetWXMiniProgramAuthResult;

    @Retention(RetentionPolicy.SOURCE)
    @interface AuthType {
    }

    public interface QQMusicAuthListener {
        void onQQMusicAuthFail(int i);

        void onQQMusicAuthStart();

        void onQQMusicAuthSuccess();
    }

    static {
        QQMusicAuthDelegate.class.getSimpleName();
        new ahh();
    }

    public void onResume() {
        int i = this.authType;
        if (i == 2) {
            if (!this.successGetQqMiniProgramAuthResult) {
                getQqMiniProgramAuthResult();
            }
        } else if (i == 1 && !this.successGetWXMiniProgramAuthResult) {
            getWXMiniProgramAuthResult();
        }
    }

    private QQMusicAuthDelegate() {
    }

    public static QQMusicAuthDelegate getInstance() {
        if (qqMusicAuthDelegate == null) {
            synchronized (QQMusicAuthDelegate.class) {
                if (qqMusicAuthDelegate == null) {
                    qqMusicAuthDelegate = new QQMusicAuthDelegate();
                }
            }
        }
        return qqMusicAuthDelegate;
    }

    public void release() {
        if (jgc.O000000o().O00000Oo(this)) {
            jgc.O000000o().O00000o0(this);
        }
        Threads.removeCallbacksInMainThread(this.runnableDelayStartAuth);
        qqMusicAuthDelegate.unbindService();
        qqMusicAuthDelegate = null;
    }

    public void init(Context context2, QQMusicAuthListener qQMusicAuthListener) {
        this.context = context2;
        this.listener = qQMusicAuthListener;
        if (!jgc.O000000o().O00000Oo(this)) {
            jgc.O000000o().O000000o(this);
        }
        this.startTime = System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public void setAuthType(int i) {
        this.authType = i;
        ahg.O00000Oo("setAuthType authType: %d", Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public void startAuth() {
        int i = this.authType;
        if (i == 1 || i == 2) {
            qqMusicAuthEncrypt();
        } else if (!this.bindFlag) {
            boolean bindQQMusicApiService = bindQQMusicApiService(this.context);
            if (bindQQMusicApiService) {
                jgc.O000000o().O00000o(new GetApiServiceEvent());
                qqMusicAuthEncrypt();
                Threads.removeCallbacksInMainThread(this.runnableDelayStartAuth);
            } else if (timeOut()) {
                Threads.removeCallbacksInMainThread(this.runnableDelayStartAuth);
                this.listener.onQQMusicAuthFail(1);
                return;
            } else {
                if (this.QQMusicProcessRet != 0) {
                    this.QQMusicProcessRet = djw.O000000o(this.context, "com.xiaomi.smarthome");
                }
                this.runnableDelayStartAuth = new Runnable() {
                    /* class com.xiaomi.mico.common.widget.$$Lambda$ke8RHi8nVcbIr1uuZCx6jEroksU */

                    public final void run() {
                        QQMusicAuthDelegate.this.startAuth();
                    }
                };
                Threads.postDelayedInMainThread(this.runnableDelayStartAuth, 500);
            }
            ahg.O00000o0("bind qq music service state=%b", Boolean.valueOf(bindQQMusicApiService));
        } else {
            qqMusicAuthEncrypt();
        }
    }

    private boolean timeOut() {
        return System.currentTimeMillis() - this.startTime > TimeUnit.SECONDS.toMillis(10);
    }

    private void qqMusicAuthEncrypt() {
        ApiHelper.qqMusicAuthEncrypt("micoSdk://homepage/qq_music_auth", new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.common.widget.QQMusicAuthDelegate.AnonymousClass1 */

            public void onSuccess(String str) {
                QQMusicAuthDelegate.this.qqMusicAuth(str);
            }

            public void onFailure(ApiError apiError) {
                if (QQMusicAuthDelegate.this.listener != null) {
                    QQMusicAuthDelegate.this.listener.onQQMusicAuthFail(0);
                }
            }
        });
    }

    public void bindAuth(String str, String str2) {
        ApiHelper.bindQQMusicAuth(LoginManager.getInstance().getPassportInfo().getUserId(), str, str2, new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.common.widget.QQMusicAuthDelegate.AnonymousClass2 */

            public void onSuccess(String str) {
                if (QQMusicAuthDelegate.this.listener != null) {
                    QQMusicAuthDelegate.this.listener.onQQMusicAuthSuccess();
                }
            }

            public void onFailure(ApiError apiError) {
                if (QQMusicAuthDelegate.this.listener != null) {
                    QQMusicAuthDelegate.this.listener.onQQMusicAuthFail(0);
                }
            }
        });
    }

    private boolean bindQQMusicApiService(Context context2) {
        Intent intent = new Intent("com.tencent.qqmusic.third.api.QQMusicApiService");
        intent.setPackage("com.tencent.qqmusic");
        return context2.bindService(intent, this, 1);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ahg.O00000o0("onServiceConnected");
        this.qqmusicApi = IQQMusicApi.Stub.asInterface(iBinder);
        this.bindFlag = true;
        djw.O000000o("phone");
        sayHi();
        if (this.lastAuthNoClient) {
            qqMusicAuth(this.encryptString);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ahg.O00000o0("onServiceDisconnected");
        this.bindFlag = false;
        QQMusicAuthListener qQMusicAuthListener = this.listener;
        if (qQMusicAuthListener != null) {
            qQMusicAuthListener.onQQMusicAuthFail(0);
        }
    }

    public void qqMusicAuth(String str) {
        if (this.authType == 0 && this.qqmusicApi == null) {
            ahg.O00000o0("qqmusicApi is empty");
            this.encryptString = str;
            this.lastAuthNoClient = true;
            return;
        }
        this.lastAuthNoClient = false;
        int i = this.authType;
        if (i == 0) {
            QqMusicProgramAuth(str);
        } else if (i == 1) {
            getWXProgramAuthQrCode(this.context, str);
        } else if (i == 2) {
            getQqMiniProgramAuthQrCode(str);
        }
    }

    private void getQqMiniProgramAuthQrCode(String str) {
        ApiHelper.getQqMiniProgramAuthQrCode(this.context, str, new ApiRequest.Listener<QqMiniProgramResponse>() {
            /* class com.xiaomi.mico.common.widget.QQMusicAuthDelegate.AnonymousClass3 */

            public void onSuccess(QqMiniProgramResponse qqMiniProgramResponse) {
                if (!ContainerUtil.isEmpty(qqMiniProgramResponse.qqResponse)) {
                    QqResponse qqResponse = (QqResponse) GsonUtil.getGsonInstance().fromJson(qqMiniProgramResponse.qqResponse.replaceAll("\\\"", jdn.f1779O000000o), QqResponse.class);
                    QQMusicAuthDelegate.this.authCode = qqResponse.auth_code;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(qqResponse.sdk_qr_code));
                    intent.addFlags(32768);
                    intent.addFlags(268435456);
                    QQMusicAuthDelegate.this.context.startActivity(intent);
                } else if (QQMusicAuthDelegate.this.listener != null) {
                    QQMusicAuthDelegate.this.listener.onQQMusicAuthFail(0);
                }
            }

            public void onFailure(ApiError apiError) {
                if (QQMusicAuthDelegate.this.listener != null) {
                    QQMusicAuthDelegate.this.listener.onQQMusicAuthFail(0);
                }
            }
        });
    }

    private void getWXProgramAuthQrCode(final Context context2, String str) {
        ApiHelper.getWXMiniProgramAuthQrCode(this.context, str, new ApiRequest.Listener<QqMiniProgramResponse>() {
            /* class com.xiaomi.mico.common.widget.QQMusicAuthDelegate.AnonymousClass4 */

            public void onSuccess(QqMiniProgramResponse qqMiniProgramResponse) {
                if (!ContainerUtil.isEmpty(qqMiniProgramResponse.qqResponse)) {
                    String replaceAll = qqMiniProgramResponse.qqResponse.replaceAll("\\\"", jdn.f1779O000000o);
                    QQMusicAuthDelegate.this.authCodeOfWX = ((QqResponse) GsonUtil.getGsonInstance().fromJson(replaceAll, QqResponse.class)).auth_code;
                    QQMusicAuthDelegate.startWeChatMiniProgram(context2, QQMusicAuthDelegate.this.authCodeOfWX);
                } else if (QQMusicAuthDelegate.this.listener != null) {
                    QQMusicAuthDelegate.this.listener.onQQMusicAuthFail(0);
                }
            }

            public void onFailure(ApiError apiError) {
                if (QQMusicAuthDelegate.this.listener != null) {
                    QQMusicAuthDelegate.this.listener.onQQMusicAuthFail(0);
                }
            }
        });
    }

    private void getQqMiniProgramAuthResult() {
        ApiHelper.getQqMiniProgramAuthResult(this.authCode, new ApiRequest.Listener<QqMiniProgramResponse>() {
            /* class com.xiaomi.mico.common.widget.QQMusicAuthDelegate.AnonymousClass5 */

            public void onSuccess(QqMiniProgramResponse qqMiniProgramResponse) {
                QQMusicAuthDelegate.this.successGetQqMiniProgramAuthResult = true;
                if (!ContainerUtil.isEmpty(qqMiniProgramResponse.qqResponse)) {
                    QqResponse qqResponse = (QqResponse) GsonUtil.getGsonInstance().fromJson(qqMiniProgramResponse.qqResponse.replaceAll("\\\"", jdn.f1779O000000o), QqResponse.class);
                    if (qqResponse.isSuccess()) {
                        QQMusicAuthDelegate qQMusicAuthDelegate = QQMusicAuthDelegate.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(qqResponse.ret);
                        qQMusicAuthDelegate.bindAuth(sb.toString(), qqResponse.encryptString);
                    }
                } else if (QQMusicAuthDelegate.this.listener != null) {
                    QQMusicAuthDelegate.this.listener.onQQMusicAuthFail(0);
                }
            }

            public void onFailure(ApiError apiError) {
                if (QQMusicAuthDelegate.this.listener != null) {
                    QQMusicAuthDelegate.this.listener.onQQMusicAuthFail(0);
                }
            }
        });
    }

    private void getWXMiniProgramAuthResult() {
        ApiHelper.getWXMiniProgramAuthResult(this.authCodeOfWX, new ApiRequest.Listener<QqMiniProgramResponse>() {
            /* class com.xiaomi.mico.common.widget.QQMusicAuthDelegate.AnonymousClass6 */

            public void onSuccess(QqMiniProgramResponse qqMiniProgramResponse) {
                QQMusicAuthDelegate.this.successGetWXMiniProgramAuthResult = true;
                if (ContainerUtil.isEmpty(qqMiniProgramResponse.qqResponse)) {
                    ahg ahg = QQMusicAuthDelegate.LOGGER_NEW;
                    ahg.O00000Oo("getWXMiniProgramAuthResult, ContainerUtil.isEmpty(response.qqResponse)");
                    if (QQMusicAuthDelegate.this.listener != null) {
                        QQMusicAuthDelegate.this.listener.onQQMusicAuthFail(0);
                        return;
                    }
                    return;
                }
                QqResponse qqResponse = (QqResponse) GsonUtil.getGsonInstance().fromJson(qqMiniProgramResponse.qqResponse.replaceAll("\\\"", jdn.f1779O000000o), QqResponse.class);
                if (qqResponse.isSuccess()) {
                    QQMusicAuthDelegate qQMusicAuthDelegate = QQMusicAuthDelegate.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(qqResponse.ret);
                    qQMusicAuthDelegate.bindAuth(sb.toString(), qqResponse.encryptString);
                }
            }

            public void onFailure(ApiError apiError) {
                if (QQMusicAuthDelegate.this.listener != null) {
                    QQMusicAuthDelegate.this.listener.onQQMusicAuthFail(0);
                }
            }
        });
    }

    private void QqMusicProgramAuth(final String str) {
        Bundle bundle = new Bundle();
        bundle.putString("encryptString", str);
        try {
            this.qqmusicApi.executeAsync("requestAuth", bundle, new IQQMusicApiCallback.Stub() {
                /* class com.xiaomi.mico.common.widget.QQMusicAuthDelegate.AnonymousClass7 */

                public void onReturn(Bundle bundle) throws RemoteException {
                    QQMusicAuthDelegate.this.commonOpen(bundle, str);
                    int i = bundle.getInt("code");
                    String string = bundle.getString("error", "");
                    ahg ahg = QQMusicAuthDelegate.LOGGER_NEW;
                    ahg.O00000o0("qqMusicAuth code=".concat(String.valueOf(i)));
                    ahg ahg2 = QQMusicAuthDelegate.LOGGER_NEW;
                    ahg.O00000o0("qqMusicAuth error=".concat(String.valueOf(string)));
                    if (i == 0) {
                        QQMusicAuthDelegate.this.bindAuth(String.valueOf(i), bundle.getString("encryptString"));
                    }
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean commonOpen(Bundle bundle, String str) {
        if (bundle == null) {
            return false;
        }
        int i = bundle.getInt("code");
        ahg.O00000o0("commonOpen code %d:", Integer.valueOf(i));
        if (i == 5) {
            verifyRequest(str);
            return false;
        } else if (i == 7) {
            djw.O00000Oo(this.context, "micoSdk://homepage/qq_music_auth");
            return false;
        } else if (i == 2) {
            return false;
        } else {
            return true;
        }
    }

    private void verifyRequest(String str) {
        if (!TextUtils.isEmpty(str)) {
            ahg.O00000o0("verifyRequest identity=".concat(String.valueOf(djw.O000000o(this.context, "31", "com.xiaomi.smarthome", str, "micoSdk://homepage/qq_music_auth"))));
        }
    }

    private void sayHi() {
        Bundle bundle = new Bundle();
        bundle.putInt("sdkVersionCode", C.MSG_CUSTOM_BASE);
        bundle.putString("platformType", "phone");
        try {
            if (this.qqmusicApi != null && commonOpen(this.qqmusicApi.execute("hi", bundle), null)) {
                ahg.O00000o0("sayHi ok");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void unbindService() {
        Context context2;
        if (this.bindFlag && (context2 = this.context) != null) {
            context2.unbindService(this);
            this.context = null;
            this.qqmusicApi = null;
            this.bindFlag = false;
            jgc.O000000o().O00000o0(this);
        }
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onMiniProgramAuthEvent(iah iah) {
        bindAuth(iah.O00000Oo, iah.O00000o0);
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onQQMusicAuthEvent(QQMusicAuthEvent qQMusicAuthEvent) {
        qqMusicAuthEncrypt();
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onQQMusicLogin(QQMusicAuthEvent.QQMusicLogin qQMusicLogin) {
        qqMusicAuthEncrypt();
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onQQMusicCancelLogin(QQMusicAuthEvent.QQMusicCancelLogin qQMusicCancelLogin) {
        QQMusicAuthListener qQMusicAuthListener = this.listener;
        if (qQMusicAuthListener != null) {
            qQMusicAuthListener.onQQMusicAuthFail(0);
        }
    }

    public static void startWeChatMiniProgram(Context context2, String str) {
        if (MicoApplication.getInstance().getMicoHelperListener() != null) {
            if (!MicoApplication.getInstance().getMicoHelperListener().getIWXAPI().isWXAppInstalled()) {
                ToastUtil.showToast((int) R.string.mico_error_weixin_not_installed);
                return;
            }
            IWXAPI iwxapi = MicoApplication.getInstance().getMicoHelperListener().getIWXAPI();
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = "gh_1dac5028a5dd";
            req.path = new Uri.Builder().path("pages/auth/auth").appendQueryParameter("a", "31").appendQueryParameter("c", str).appendQueryParameter("packageName", context2.getApplicationContext().getPackageName()).build().toString();
            req.miniprogramType = 0;
            iwxapi.sendReq(req);
        }
    }

    static class GetApiServiceEvent {
        GetApiServiceEvent() {
        }
    }
}
