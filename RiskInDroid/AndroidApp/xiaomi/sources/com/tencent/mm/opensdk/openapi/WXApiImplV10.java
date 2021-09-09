package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.mm.opensdk.modelbiz.HandleScanResult;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
import java.net.URLEncoder;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

final class WXApiImplV10 implements IWXAPI {
    private static String wxappPayEntryClassname;
    private String appId;
    private boolean checkSignature = false;
    private Context context;
    private boolean detached = false;

    WXApiImplV10(Context context2, String str, boolean z) {
        Log.d("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + str + ", checkSignature = " + z);
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
        Log.e("MicroMsg.SDK.WXApiImplV10", str);
        return false;
    }

    private boolean createChatroom(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean handleWxInternalRespType(String str, IWXAPIEventHandler iWXAPIEventHandler) {
        Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, extInfo = ".concat(String.valueOf(str)));
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("wx_internal_resptype");
            Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, respType = ".concat(String.valueOf(queryParameter)));
            if (d.a(queryParameter)) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, respType is null");
                return false;
            } else if (queryParameter.equals("subscribemessage")) {
                SubscribeMessage.Resp resp = new SubscribeMessage.Resp();
                resp.openId = parse.getQueryParameter("openid");
                resp.templateID = parse.getQueryParameter("template_id");
                resp.scene = d.b(parse.getQueryParameter("scene"));
                resp.action = parse.getQueryParameter("action");
                resp.reserved = parse.getQueryParameter("reserved");
                iWXAPIEventHandler.onResp(resp);
                return true;
            } else if (queryParameter.contains("invoice_auth_insert")) {
                WXInvoiceAuthInsert.Resp resp2 = new WXInvoiceAuthInsert.Resp();
                resp2.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp2);
                return true;
            } else if (queryParameter.contains("payinsurance")) {
                WXPayInsurance.Resp resp3 = new WXPayInsurance.Resp();
                resp3.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp3);
                return true;
            } else if (queryParameter.contains("nontaxpay")) {
                WXNontaxPay.Resp resp4 = new WXNontaxPay.Resp();
                resp4.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp4);
                return true;
            } else {
                Log.e("MicroMsg.SDK.WXApiImplV10", "this open sdk version not support the request type");
                return false;
            }
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, ex = " + e.getMessage());
        }
    }

    private boolean joinChatroom(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
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

    private boolean sendChooseCardFromWX(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendHandleScanResult(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendInvoiceAuthInsert(Context context2, BaseReq baseReq) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "2", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXInvoiceAuthInsert.Req) baseReq).url)))}, null);
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

    private boolean sendLaunchWXMiniprogram(Context context2, BaseReq baseReq) {
        WXLaunchMiniProgram.Req req = (WXLaunchMiniProgram.Req) baseReq;
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
        StringBuilder sb = new StringBuilder();
        sb.append(req.miniprogramType);
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, req.userName, req.path, sb.toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendNonTaxPay(Context context2, BaseReq baseReq) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "3", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXNontaxPay.Req) baseReq).url)))}, null);
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

    private boolean sendPayInSurance(Context context2, BaseReq baseReq) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "4", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXPayInsurance.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context2, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context2).getString("_wxapp_pay_entry_classname_", null);
            Log.d("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = context2.getPackageManager().getApplicationInfo("com.tencent.mm", NotificationCompat.FLAG_HIGH_PRIORITY).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.WXApiImplV10", "get from metaData failed : " + e.getMessage());
                }
            }
            if (wxappPayEntryClassname == null) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.bundle = bundle;
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = wxappPayEntryClassname;
        return MMessageActV2.send(context2, args);
    }

    private boolean sendSubscribeMessage(Context context2, BaseReq baseReq) {
        SubscribeMessage.Req req = (SubscribeMessage.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "1", String.valueOf(req.scene), req.templateID, req.reserved}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    public final void detach() {
        Log.d("MicroMsg.SDK.WXApiImplV10", "detach");
        this.detached = true;
        this.context = null;
    }

    public final int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        } else if (!isWXAppInstalled()) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
            return 0;
        } else {
            int i = new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
            if (i != 0) {
                return i;
            }
            try {
                return this.context.getPackageManager().getApplicationInfo("com.tencent.mm", NotificationCompat.FLAG_HIGH_PRIORITY).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
            } catch (Exception e) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "get from metaData failed : " + e.getMessage());
                return i;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        try {
            if (!WXApiImplComm.isIntentFromWx(intent, "com.tencent.mm.openapi.token")) {
                Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
                return false;
            } else if (!this.detached) {
                String stringExtra = intent.getStringExtra("_mmessage_content");
                int intExtra = intent.getIntExtra("_mmessage_sdkVersion", 0);
                String stringExtra2 = intent.getStringExtra("_mmessage_appPackage");
                if (stringExtra2 != null) {
                    if (stringExtra2.length() != 0) {
                        if (!checkSumConsistent(intent.getByteArrayExtra("_mmessage_checksum"), b.a(stringExtra, intExtra, stringExtra2))) {
                            Log.e("MicroMsg.SDK.WXApiImplV10", "checksum fail");
                            return false;
                        }
                        int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                        Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, cmd = ".concat(String.valueOf(intExtra2)));
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
                                ShowMessageFromWX.Req req = new ShowMessageFromWX.Req(intent.getExtras());
                                String str = req.message.messageExt;
                                if (str == null || !str.contains("wx_internal_resptype")) {
                                    iWXAPIEventHandler.onReq(req);
                                    return true;
                                }
                                boolean handleWxInternalRespType = handleWxInternalRespType(str, iWXAPIEventHandler);
                                Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, extInfo contains wx_internal_resptype, ret = ".concat(String.valueOf(handleWxInternalRespType)));
                                return handleWxInternalRespType;
                            case 5:
                                iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                                return true;
                            case 6:
                                iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                                return true;
                            case 7:
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            case 10:
                            case 11:
                            case 13:
                            case 18:
                            default:
                                Log.e("MicroMsg.SDK.WXApiImplV10", "unknown cmd = ".concat(String.valueOf(intExtra2)));
                                break;
                            case 9:
                                iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                                return true;
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                                return true;
                            case 14:
                                iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                                return true;
                            case GmsLogger.MAX_PII_TAG_LENGTH:
                                iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                                return true;
                            case 16:
                                iWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(intent.getExtras()));
                                return true;
                            case 17:
                                iWXAPIEventHandler.onResp(new HandleScanResult.Resp(intent.getExtras()));
                                return true;
                            case 19:
                                iWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(intent.getExtras()));
                                return true;
                        }
                        return false;
                    }
                }
                Log.e("MicroMsg.SDK.WXApiImplV10", "invalid argument");
                return false;
            } else {
                throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
            }
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, ex = " + e.getMessage());
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
            return getWXAppSupportAPI() >= 620823552;
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
            Log.e("MicroMsg.SDK.WXApiImplV10", str);
            return false;
        }
        throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    }

    public final boolean registerApp(String str) {
        return registerApp(str, 0);
    }

    public final boolean registerApp(String str, long j) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        } else {
            Log.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = ".concat(String.valueOf(str)));
            if (str != null) {
                this.appId = str;
            }
            Log.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = ".concat(String.valueOf(str)));
            if (str != null) {
                this.appId = str;
            }
            Log.d("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
            a.C0048a aVar = new a.C0048a();
            aVar.f5860a = "com.tencent.mm";
            aVar.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
            aVar.content = "weixin://registerapp?appid=" + this.appId;
            aVar.b = j;
            return a.a(this.context, aVar);
        }
    }

    public final boolean sendReq(BaseReq baseReq) {
        StringBuilder sb;
        String str;
        String str2;
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                str2 = "sendReq failed for wechat app signature check failed";
            } else if (!baseReq.checkArgs()) {
                str2 = "sendReq checkArgs fail";
            } else {
                Log.i("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + baseReq.getType());
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
                if (baseReq.getType() == 16) {
                    return sendChooseCardFromWX(this.context, bundle);
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
                if (baseReq.getType() == 17) {
                    return sendHandleScanResult(this.context, bundle);
                }
                if (baseReq.getType() == 18) {
                    return sendSubscribeMessage(this.context, baseReq);
                }
                if (baseReq.getType() == 19) {
                    return sendLaunchWXMiniprogram(this.context, baseReq);
                }
                if (baseReq.getType() == 20) {
                    return sendInvoiceAuthInsert(this.context, baseReq);
                }
                if (baseReq.getType() == 21) {
                    return sendNonTaxPay(this.context, baseReq);
                }
                if (baseReq.getType() == 22) {
                    return sendPayInSurance(this.context, baseReq);
                }
                if (baseReq.getType() == 2 && bundle.getInt("_wxapi_sendmessagetowx_req_media_type") == 36) {
                    SendMessageToWX.Req req = (SendMessageToWX.Req) baseReq;
                    if (getWXAppSupportAPI() < 620756993) {
                        WXWebpageObject wXWebpageObject = new WXWebpageObject();
                        wXWebpageObject.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                        req.message.mediaObject = wXWebpageObject;
                    } else {
                        WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) req.message.mediaObject;
                        wXMiniProgramObject.userName += "@app";
                        String str3 = wXMiniProgramObject.path;
                        if (!d.a(str3)) {
                            String[] split = str3.split("\\?");
                            if (split.length > 1) {
                                sb = new StringBuilder();
                                sb.append(split[0]);
                                sb.append(".html?");
                                str = split[1];
                            } else {
                                sb = new StringBuilder();
                                sb.append(split[0]);
                                str = ".html";
                            }
                            sb.append(str);
                            wXMiniProgramObject.path = sb.toString();
                        }
                    }
                    req.scene = 0;
                    baseReq.toBundle(bundle);
                }
                MMessageActV2.Args args = new MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendreq?appid=" + this.appId;
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return MMessageActV2.send(this.context, args);
            }
            Log.e("MicroMsg.SDK.WXApiImplV10", str2);
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
                MMessageActV2.Args args = new MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendresp?appid=" + this.appId;
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return MMessageActV2.send(this.context, args);
            }
            Log.e("MicroMsg.SDK.WXApiImplV10", str);
            return false;
        }
        throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    }

    public final void setLogImpl(ILog iLog) {
        Log.setLogImpl(iLog);
    }

    public final void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
        } else {
            Log.d("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
            String str = this.appId;
            if (str == null || str.length() == 0) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
                return;
            }
            Log.d("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
            a.C0048a aVar = new a.C0048a();
            aVar.f5860a = "com.tencent.mm";
            aVar.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
            aVar.content = "weixin://unregisterapp?appid=" + this.appId;
            a.a(this.context, aVar);
        }
    }
}
