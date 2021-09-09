package com.miui.tsmclient.model;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.entity.ActionToken;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.entity.UserExceptionLogInfo;
import com.miui.tsmclient.model.e.c;
import com.miui.tsmclient.model.e.d;
import com.miui.tsmclient.model.e.f;
import com.miui.tsmclient.model.e.h;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.seitsm.a.a;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.b;
import com.tsmclient.smartcard.exception.NfcEeIOException;
import com.tsmclient.smartcard.terminal.IScTerminal;
import java.io.IOException;
import java.util.Iterator;

public class k extends c {
    public k(d dVar) {
        super(dVar);
    }

    private BaseResponse a(Context context, CardInfo cardInfo, TsmRpcModels.TsmSessionInfo tsmSessionInfo, String str, Bundle bundle) throws IOException, a, InterruptedException {
        BaseResponse a2 = d.get() ? a(context, cardInfo, tsmSessionInfo, bundle) : null;
        if (d.get()) {
            return a2;
        }
        TsmRpcModels.TsmAPDUCommand a3 = this.c.a(context, tsmSessionInfo, cardInfo, str, bundle);
        if (a3 == null) {
            LogUtils.d("can not get apduCommand,startTopupOperation failed.");
            return new BaseResponse(16, new Object[0]);
        }
        int a4 = f.a(a3.getResult());
        if (a4 != 0) {
            throw new a(a4, a3.getErrorDesc());
        } else if (a3.getApdusList() == null || a3.getApdusList().isEmpty()) {
            return new BaseResponse(0, new Object[0]);
        } else {
            IScTerminal terminal = cardInfo.getTerminal();
            try {
                terminal.open();
                return a(context, terminal, tsmSessionInfo, a3);
            } finally {
                terminal.close();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.e.c.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, boolean):com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo
     arg types: [android.content.Context, com.miui.tsmclient.entity.PayableCardInfo, com.miui.tsmclient.model.e.h$a, int]
     candidates:
      com.miui.tsmclient.model.e.c.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.tsmclient.smartcard.terminal.IScTerminal, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.c.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, boolean):com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01c8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01c9, code lost:
        r3 = r4;
        r17 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x020a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x020b, code lost:
        r3 = r4;
        r17 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0241, code lost:
        if (r14.needUpload() == false) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0132, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0133, code lost:
        r3 = r4;
        r1 = "recharge";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0138, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0139, code lost:
        r3 = r4;
        r17 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0166, code lost:
        if (r14.needUpload() == false) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0168, code lost:
        r14.setObjectName(r8.mCardType);
        r14.setCoreOperation(r1);
        com.miui.tsmclient.model.p.a(r21).a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0177, code lost:
        r9 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0180, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0181, code lost:
        r3 = r4;
        r1 = "recharge";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0132 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:20:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0180 A[ExcHandler: a (e com.miui.tsmclient.seitsm.a.a), Splitter:B:20:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0195 A[Catch:{ all -> 0x01c5 }] */
    public BaseResponse a(Context context, PayableCardInfo payableCardInfo, OrderInfo orderInfo, Tag tag, Bundle bundle) {
        boolean z;
        h.a aVar;
        int i;
        String str;
        String str2;
        int i2;
        String str3;
        h.a aVar2;
        String str4;
        h.a aVar3;
        String str5;
        h.a aVar4;
        String str6;
        long j;
        BaseResponse baseResponse;
        String str7;
        Context context2 = context;
        PayableCardInfo payableCardInfo2 = payableCardInfo;
        OrderInfo orderInfo2 = orderInfo;
        if (payableCardInfo2 == null) {
            return new BaseResponse(1, new Object[0]);
        }
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        boolean z2 = bundle2.getBoolean("out_operation");
        if (!z2 && orderInfo2 == null) {
            return new BaseResponse(1, new Object[0]);
        }
        UserExceptionLogInfo userExceptionLogInfo = new UserExceptionLogInfo();
        long j2 = bundle2.getLong("version_control_id", 0);
        String a2 = b.a(j2);
        if (!TextUtils.isEmpty(a2)) {
            bundle2.putString("need_phone_number", a2);
            z = true;
        } else {
            z = false;
        }
        h.a aVar5 = z2 ? h.a.OUT_RECHARGE : h.a.RECHARGE;
        try {
            TsmRpcModels.TsmSessionInfo a3 = a(context2, (CardInfo) payableCardInfo2, aVar5, true);
            userExceptionLogInfo.setSessionId(a3 != null ? a3.getSessionId() : "");
            if (z2) {
                str3 = "";
                aVar4 = aVar5;
                str6 = "recharge";
                j = j2;
                try {
                    baseResponse = a(context, payableCardInfo, a3, TsmRpcModels.SeOperationType.OUT_TOPUP, bundle2);
                } catch (NfcEeIOException e) {
                    e = e;
                    str4 = str6;
                    aVar2 = aVar4;
                    try {
                        LogUtils.e("recharge failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                    } catch (Throwable th) {
                        th = th;
                        i = 0;
                        if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                            h.a().a(payableCardInfo2, aVar);
                        }
                        userExceptionLogInfo.setErrorCode(i);
                        if (userExceptionLogInfo.needUpload()) {
                            userExceptionLogInfo.setObjectName(payableCardInfo2.mCardType);
                            userExceptionLogInfo.setCoreOperation(str);
                            p.a(context).a(userExceptionLogInfo);
                        }
                        throw th;
                    }
                    try {
                        userExceptionLogInfo.setExtra(e.getMessage());
                        if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                            h.a().a(payableCardInfo2, aVar);
                        }
                        i2 = 10;
                        userExceptionLogInfo.setErrorCode(10);
                    } catch (Throwable th2) {
                        th = th2;
                        i = 10;
                        if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                        }
                        userExceptionLogInfo.setErrorCode(i);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    str5 = str6;
                    aVar3 = aVar4;
                    LogUtils.e("recharge failed with an io exception.", e);
                    try {
                        userExceptionLogInfo.setExtra(e.getMessage());
                        if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                            h.a().a(payableCardInfo2, aVar);
                        }
                        userExceptionLogInfo.setErrorCode(2);
                        if (userExceptionLogInfo.needUpload()) {
                            userExceptionLogInfo.setObjectName(payableCardInfo2.mCardType);
                            userExceptionLogInfo.setCoreOperation(str);
                            p.a(context).a(userExceptionLogInfo);
                        }
                        str2 = str3;
                        i2 = 2;
                        return new BaseResponse(i2, str2, new Object[0]);
                    } catch (Throwable th3) {
                        th = th3;
                        i = 2;
                        if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                        }
                        userExceptionLogInfo.setErrorCode(i);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        throw th;
                    }
                } catch (a e3) {
                    e = e3;
                    String str8 = str6;
                    h.a aVar6 = aVar4;
                    LogUtils.e("recharge failed with an tsmapi exception.", e);
                    i = e.a();
                    try {
                        str2 = e.getMessage();
                        if (i > 1000000) {
                            i = 1001;
                        }
                        userExceptionLogInfo.setExtra(e.getMessage());
                        if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                            h.a().a(payableCardInfo2, aVar);
                        }
                        userExceptionLogInfo.setErrorCode(i2);
                        if (userExceptionLogInfo.needUpload()) {
                            userExceptionLogInfo.setObjectName(payableCardInfo2.mCardType);
                            userExceptionLogInfo.setCoreOperation(str);
                            p.a(context).a(userExceptionLogInfo);
                        }
                        return new BaseResponse(i2, str2, new Object[0]);
                    } catch (Throwable th4) {
                        th = th4;
                        if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                        }
                        userExceptionLogInfo.setErrorCode(i);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        throw th;
                    }
                } catch (InterruptedException e4) {
                    e = e4;
                    str = str6;
                    aVar = aVar4;
                    try {
                        LogUtils.e("recharge is interrupted.", e);
                    } catch (Throwable th5) {
                        th = th5;
                        i = 0;
                        if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                        }
                        userExceptionLogInfo.setErrorCode(i);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        throw th;
                    }
                    try {
                        userExceptionLogInfo.setExtra(e.getMessage());
                        Thread.currentThread().interrupt();
                        if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                            h.a().a(payableCardInfo2, aVar);
                        }
                        i2 = 11;
                        userExceptionLogInfo.setErrorCode(11);
                    } catch (Throwable th6) {
                        th = th6;
                        i = 11;
                        if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                        }
                        userExceptionLogInfo.setErrorCode(i);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str = str6;
                    aVar = aVar4;
                    i = 0;
                    if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                    }
                    userExceptionLogInfo.setErrorCode(i);
                    if (userExceptionLogInfo.needUpload()) {
                    }
                    throw th;
                }
            } else {
                aVar4 = aVar5;
                Object obj = "";
                str6 = "recharge";
                j = j2;
                Iterator<ActionToken> it = orderInfo2.mActionTokens.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str7 = null;
                        break;
                    }
                    ActionToken next = it.next();
                    if (next.isRechargeType()) {
                        str7 = next.mToken;
                        break;
                    }
                }
                baseResponse = a(context, payableCardInfo, a3, str7, bundle2);
            }
            if (!baseResponse.isSuccess()) {
                userExceptionLogInfo.setErrorCode(baseResponse.mResultCode);
            } else if (z) {
                b.a().b(context2, payableCardInfo2.mCardType, j);
            }
            if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                h.a().a(payableCardInfo2, aVar4);
            }
            userExceptionLogInfo.setErrorCode(0);
            if (userExceptionLogInfo.needUpload()) {
                userExceptionLogInfo.setObjectName(payableCardInfo2.mCardType);
                userExceptionLogInfo.setCoreOperation(str6);
                p.a(context).a(userExceptionLogInfo);
            }
            return baseResponse;
        } catch (NfcEeIOException e5) {
            e = e5;
            String str9 = "";
            aVar2 = aVar5;
            str4 = "recharge";
            LogUtils.e("recharge failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
            userExceptionLogInfo.setExtra(e.getMessage());
            if (!bundle2.getBoolean("extras_key_session_not_finish")) {
            }
            i2 = 10;
            userExceptionLogInfo.setErrorCode(10);
        } catch (IOException e6) {
            e = e6;
            String str10 = "";
            aVar3 = aVar5;
            str5 = "recharge";
            LogUtils.e("recharge failed with an io exception.", e);
            userExceptionLogInfo.setExtra(e.getMessage());
            if (!bundle2.getBoolean("extras_key_session_not_finish")) {
            }
            userExceptionLogInfo.setErrorCode(2);
            if (userExceptionLogInfo.needUpload()) {
            }
            str2 = str3;
            i2 = 2;
            return new BaseResponse(i2, str2, new Object[0]);
        } catch (a e7) {
        } catch (InterruptedException e8) {
            e = e8;
            str3 = "";
            aVar = aVar5;
            str = "recharge";
            LogUtils.e("recharge is interrupted.", e);
            userExceptionLogInfo.setExtra(e.getMessage());
            Thread.currentThread().interrupt();
            if (!bundle2.getBoolean("extras_key_session_not_finish")) {
            }
            i2 = 11;
            userExceptionLogInfo.setErrorCode(11);
        } catch (Throwable th8) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.e.c.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, boolean):com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo
     arg types: [android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, int]
     candidates:
      com.miui.tsmclient.model.e.c.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.tsmclient.smartcard.terminal.IScTerminal, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.c.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, boolean):com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r11.getBoolean("extras_key_session_not_finish") != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        com.miui.tsmclient.model.e.h.a().a(r10, com.miui.tsmclient.model.e.h.a.READ_CARD);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r11.getBoolean("extras_key_session_not_finish") != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0076, code lost:
        if (r11.getBoolean("extras_key_session_not_finish") != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0081, code lost:
        return new com.miui.tsmclient.model.BaseResponse(r9, r7, new java.lang.Object[0]);
     */
    public BaseResponse a_(Context context, CardInfo cardInfo, Bundle bundle) {
        int i;
        if (bundle == null) {
            bundle = new Bundle();
        }
        String str = "";
        try {
            BaseResponse a2 = a(context, cardInfo, a(context, cardInfo, h.a.READ_CARD, true), TsmRpcModels.SeOperationType.READ_CARD, bundle);
            if (!bundle.getBoolean("extras_key_session_not_finish")) {
                h.a().a(cardInfo, h.a.READ_CARD);
            }
            return a2;
        } catch (a e) {
            LogUtils.e("check failed with an tsmapi exception before refund.", e);
            int a3 = e.a();
            str = e.getMessage();
            i = a3 > 1000000 ? 1001 : a3;
        } catch (IOException e2) {
            LogUtils.e("check failed with an io exception before refund.", e2);
            i = 2;
        } catch (InterruptedException e3) {
            LogUtils.e("check is interrupted before refund.", e3);
            i = 11;
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            if (!bundle.getBoolean("extras_key_session_not_finish")) {
                h.a().a(cardInfo, h.a.READ_CARD);
            }
            throw th;
        }
    }
}
