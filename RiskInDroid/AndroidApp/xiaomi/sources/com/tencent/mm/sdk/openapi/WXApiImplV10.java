package com.tencent.mm.sdk.openapi;

import _m_j.dkd;
import _m_j.dke;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.a.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.sdk.modelbiz.CreateChatroom;
import com.tencent.mm.sdk.modelbiz.JoinChatroom;
import com.tencent.mm.sdk.modelbiz.OpenWebview;
import com.tencent.mm.sdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.sdk.modelmsg.LaunchFromWX;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.modelpay.PayResp;
import com.tencent.wxop.stat.MtaSDkException;
import com.tencent.wxop.stat.StatReportStrategy;
import java.util.Properties;

final class WXApiImplV10 implements IWXAPI {
    public static ActivityLifecycleCb activityCb;
    private static String wxappPayEntryClassname;
    private String appId;
    private boolean checkSignature = false;
    private Context context;
    private boolean detached = false;

    static final class ActivityLifecycleCb implements Application.ActivityLifecycleCallbacks {
        public Context context;
        private Handler handler;
        public boolean isForeground;
        private Runnable onPausedRunnable;
        private Runnable onResumedRunnable;

        private ActivityLifecycleCb(Context context2) {
            this.isForeground = false;
            this.handler = new Handler(Looper.getMainLooper());
            this.onPausedRunnable = new Runnable() {
                /* class com.tencent.mm.sdk.openapi.WXApiImplV10.ActivityLifecycleCb.AnonymousClass1 */

                public void run() {
                    if (WXApiImplV10.activityCb != null && ActivityLifecycleCb.this.isForeground) {
                        Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", "WXStat trigger onBackground");
                        dke.O000000o(ActivityLifecycleCb.this.context, "onBackground_WX", (Properties) null);
                        ActivityLifecycleCb.this.isForeground = false;
                    }
                }
            };
            this.onResumedRunnable = new Runnable() {
                /* class com.tencent.mm.sdk.openapi.WXApiImplV10.ActivityLifecycleCb.AnonymousClass2 */

                public void run() {
                    if (WXApiImplV10.activityCb != null && !ActivityLifecycleCb.this.isForeground) {
                        Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", "WXStat trigger onForeground");
                        dke.O000000o(ActivityLifecycleCb.this.context, "onForeground_WX", (Properties) null);
                        ActivityLifecycleCb.this.isForeground = true;
                    }
                }
            };
            this.context = context2;
        }

        public final void detach() {
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.context = null;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
            Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", activity.getComponentName().getClassName() + "  onActivityPaused");
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.postDelayed(this.onPausedRunnable, 800);
        }

        public final void onActivityResumed(Activity activity) {
            Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", activity.getComponentName().getClassName() + "  onActivityResumed");
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.handler.postDelayed(this.onResumedRunnable, 800);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }
    }

    WXApiImplV10(Context context2, String str, boolean z) {
        b.e("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context2;
        this.appId = str;
        this.checkSignature = z;
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        String str;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            str = "checkSumConsistent fail, invalid arguments";
        } else if (bArr.length != bArr2.length) {
            str = "checkSumConsistent fail, length is different";
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        b.b("MicroMsg.SDK.WXApiImplV10", str);
        return false;
    }

    private boolean createChatroom(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction"), bundle.getString("_wxapi_create_chatroom_group_id"), bundle.getString("_wxapi_create_chatroom_chatroom_name"), bundle.getString("_wxapi_create_chatroom_chatroom_nickname"), bundle.getString("_wxapi_create_chatroom_ext_msg")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean joinChatroom(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction"), bundle.getString("_wxapi_join_chatroom_group_id"), bundle.getString("_wxapi_join_chatroom_chatroom_nickname"), bundle.getString("_wxapi_join_chatroom_ext_msg")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendAddCardToWX(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizProfileReq(Context context2, Bundle bundle) {
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        StringBuilder sb = new StringBuilder();
        sb.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_scene"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type"));
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), sb.toString(), sb2.toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizTempSessionReq(Context context2, Bundle bundle) {
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession");
        StringBuilder sb = new StringBuilder();
        sb.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_show_type"));
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_session_from"), sb.toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizWebviewReq(Context context2, Bundle bundle) {
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        StringBuilder sb = new StringBuilder();
        sb.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_scene"));
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), sb.toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (query == null) {
            return true;
        }
        query.close();
        return true;
    }

    private boolean sendOpenWebview(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context2, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context2).getString("_wxapp_pay_entry_classname_", null);
            b.e("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                b.b("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        a.C0049a aVar = new a.C0049a();
        aVar.Z = bundle;
        aVar.W = "com.tencent.mm";
        aVar.X = wxappPayEntryClassname;
        return a.a(context2, aVar);
    }

    public final void detach() {
        Application application;
        b.e("MicroMsg.SDK.WXApiImplV10", "detach");
        this.detached = true;
        if (activityCb != null && Build.VERSION.SDK_INT >= 14) {
            Context context2 = this.context;
            if (context2 instanceof Activity) {
                application = ((Activity) context2).getApplication();
            } else {
                if (context2 instanceof Service) {
                    application = ((Service) context2).getApplication();
                }
                activityCb.detach();
            }
            application.unregisterActivityLifecycleCallbacks(activityCb);
            activityCb.detach();
        }
        this.context = null;
    }

    public final int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        } else if (isWXAppInstalled()) {
            return new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
        } else {
            b.b("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
            return 0;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        try {
            if (!WXApiImplComm.isIntentFromWx(intent, "com.tencent.mm.openapi.token")) {
                b.d("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
                return false;
            } else if (!this.detached) {
                String stringExtra = intent.getStringExtra("_mmessage_content");
                int intExtra = intent.getIntExtra("_mmessage_sdkVersion", 0);
                String stringExtra2 = intent.getStringExtra("_mmessage_appPackage");
                if (stringExtra2 != null) {
                    if (stringExtra2.length() != 0) {
                        if (!checkSumConsistent(intent.getByteArrayExtra("_mmessage_checksum"), com.tencent.mm.sdk.a.a.b.a(stringExtra, intExtra, stringExtra2))) {
                            b.b("MicroMsg.SDK.WXApiImplV10", "checksum fail");
                            return false;
                        }
                        int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                        if (intExtra2 == 9) {
                            iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                            return true;
                        } else if (intExtra2 == 12) {
                            iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                            return true;
                        } else if (intExtra2 == 14) {
                            iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                            return true;
                        } else if (intExtra2 != 15) {
                            switch (intExtra2) {
                                case 1:
                                    iWXAPIEventHandler.onResp(new SendAuth.Resp(intent.getExtras()));
                                    return true;
                                case 2:
                                    iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                                    return true;
                                case 3:
                                    iWXAPIEventHandler.onReq(new GetMessageFromWX.Req(intent.getExtras()));
                                    return true;
                                case 4:
                                    iWXAPIEventHandler.onReq(new ShowMessageFromWX.Req(intent.getExtras()));
                                    return true;
                                case 5:
                                    iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                                    return true;
                                case 6:
                                    iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                                    return true;
                                default:
                                    b.b("MicroMsg.SDK.WXApiImplV10", "unknown cmd = ".concat(String.valueOf(intExtra2)));
                                    break;
                            }
                            return false;
                        } else {
                            iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                            return true;
                        }
                    }
                }
                b.b("MicroMsg.SDK.WXApiImplV10", "invalid argument");
                return false;
            } else {
                throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
            }
        } catch (Exception e) {
            b.a("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, ex = %s", e.getMessage());
        }
    }

    public final boolean isWXAppInstalled() {
        if (!this.detached) {
            try {
                PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
                if (packageInfo == null) {
                    return false;
                }
                return WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        } else {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
    }

    public final boolean isWXAppSupportAPI() {
        if (!this.detached) {
            return getWXAppSupportAPI() >= 587268097;
        }
        throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
    }

    public final boolean openWXApp() {
        String str;
        if (!this.detached) {
            if (!isWXAppInstalled()) {
                str = "open wx app failed, not installed or signature check failed";
            } else {
                try {
                    this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                    return true;
                } catch (Exception e) {
                    str = "startActivity fail, exception = " + e.getMessage();
                }
            }
            b.b("MicroMsg.SDK.WXApiImplV10", str);
            return false;
        }
        throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    }

    public final boolean registerApp(String str) {
        Application application;
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            b.b("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        } else {
            if (activityCb == null && Build.VERSION.SDK_INT >= 14) {
                Context context2 = this.context;
                if (context2 instanceof Activity) {
                    initMta(context2, str);
                    activityCb = new ActivityLifecycleCb(this.context);
                    application = ((Activity) this.context).getApplication();
                } else if (context2 instanceof Service) {
                    initMta(context2, str);
                    activityCb = new ActivityLifecycleCb(this.context);
                    application = ((Service) this.context).getApplication();
                } else {
                    b.c("MicroMsg.SDK.WXApiImplV10", "context is not instanceof Activity or Service, disable WXStat");
                }
                application.registerActivityLifecycleCallbacks(activityCb);
            }
            b.e("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = ".concat(String.valueOf(str)));
            if (str != null) {
                this.appId = str;
            }
            b.e("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
            a.C0050a aVar = new a.C0050a();
            aVar.aa = "com.tencent.mm";
            aVar.ab = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
            aVar.Y = "weixin://registerapp?appid=" + this.appId;
            return com.tencent.mm.sdk.a.a.a.a(this.context, aVar);
        }
    }

    public final boolean sendReq(BaseReq baseReq) {
        String str;
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                str = "sendReq failed for wechat app signature check failed";
            } else if (!baseReq.checkArgs()) {
                str = "sendReq checkArgs fail";
            } else {
                b.e("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + baseReq.getType());
                Bundle bundle = new Bundle();
                baseReq.toBundle(bundle);
                if (baseReq.getType() == 5) {
                    return sendPayReq(this.context, bundle);
                }
                if (baseReq.getType() == 7) {
                    return sendJumpToBizProfileReq(this.context, bundle);
                }
                if (baseReq.getType() == 8) {
                    return sendJumpToBizWebviewReq(this.context, bundle);
                }
                if (baseReq.getType() == 10) {
                    return sendJumpToBizTempSessionReq(this.context, bundle);
                }
                if (baseReq.getType() == 9) {
                    return sendAddCardToWX(this.context, bundle);
                }
                if (baseReq.getType() == 11) {
                    return sendOpenRankListReq(this.context, bundle);
                }
                if (baseReq.getType() == 12) {
                    return sendOpenWebview(this.context, bundle);
                }
                if (baseReq.getType() == 13) {
                    return sendOpenBusiLuckyMoney(this.context, bundle);
                }
                if (baseReq.getType() == 14) {
                    return createChatroom(this.context, bundle);
                }
                if (baseReq.getType() == 15) {
                    return joinChatroom(this.context, bundle);
                }
                a.C0049a aVar = new a.C0049a();
                aVar.Z = bundle;
                aVar.Y = "weixin://sendreq?appid=" + this.appId;
                aVar.W = "com.tencent.mm";
                aVar.X = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return com.tencent.mm.sdk.a.a.a(this.context, aVar);
            }
            b.b("MicroMsg.SDK.WXApiImplV10", str);
            return false;
        }
        throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
    }

    public final boolean sendResp(BaseResp baseResp) {
        String str;
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                str = "sendResp failed for wechat app signature check failed";
            } else if (!baseResp.checkArgs()) {
                str = "sendResp checkArgs fail";
            } else {
                Bundle bundle = new Bundle();
                baseResp.toBundle(bundle);
                a.C0049a aVar = new a.C0049a();
                aVar.Z = bundle;
                aVar.Y = "weixin://sendresp?appid=" + this.appId;
                aVar.W = "com.tencent.mm";
                aVar.X = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return com.tencent.mm.sdk.a.a.a(this.context, aVar);
            }
            b.b("MicroMsg.SDK.WXApiImplV10", str);
            return false;
        }
        throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    }

    public final void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            b.b("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
        } else {
            b.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
            String str = this.appId;
            if (str == null || str.length() == 0) {
                b.b("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
                return;
            }
            b.e("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
            a.C0050a aVar = new a.C0050a();
            aVar.aa = "com.tencent.mm";
            aVar.ab = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
            aVar.Y = "weixin://unregisterapp?appid=" + this.appId;
            com.tencent.mm.sdk.a.a.a.a(this.context, aVar);
        }
    }

    private void initMta(Context context2, String str) {
        String concat = "AWXOP".concat(String.valueOf(str));
        dkd.O000000o(context2, concat);
        dkd.O0000o0();
        dkd.O000000o(StatReportStrategy.PERIOD);
        dkd.O0000OoO();
        dkd.O00000Oo(context2, "Wechat_Sdk");
        try {
            dke.O000000o(context2, concat, "2.0.3");
        } catch (MtaSDkException e) {
            e.printStackTrace();
        }
    }
}
