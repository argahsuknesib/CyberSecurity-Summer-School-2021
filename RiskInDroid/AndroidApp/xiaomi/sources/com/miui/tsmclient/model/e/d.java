package com.miui.tsmclient.model.e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.protobuf.ByteString;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.UserExceptionLogInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.c;
import com.miui.tsmclient.model.e.h;
import com.miui.tsmclient.model.p;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.seitsm.a;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.ServiceUtils;
import com.miui.tsmclient.util.b;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.exception.NfcEeIOException;
import com.tsmclient.smartcard.terminal.IScTerminal;
import com.tsmclient.smartcard.terminal.external.CommandList;
import com.tsmclient.smartcard.terminal.external.IApduExecutor;
import com.tsmclient.smartcard.terminal.external.ResponseList;
import com.tsmclient.smartcard.terminal.response.ScResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class d extends c {
    protected static AtomicBoolean d = new AtomicBoolean(true);
    protected a c = new a();

    private boolean a(TsmRpcModels.SeOperationType seOperationType) {
        return seOperationType == TsmRpcModels.SeOperationType.INSTALL || seOperationType == TsmRpcModels.SeOperationType.SHIFT_IN;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, boolean):com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo
     arg types: [android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, int]
     candidates:
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.tsmclient.smartcard.terminal.IScTerminal, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, boolean):com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02c6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02c7, code lost:
        r3 = r5;
        r13 = "extras_key_session_not_finish";
        r7 = r10;
        r2 = "******* issue time:";
        r6 = ", preload:";
        r10 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02dc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02dd, code lost:
        r3 = r5;
        r13 = "extras_key_session_not_finish";
        r7 = r10;
        r2 = "******* issue time:";
        r6 = ", preload:";
        r10 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02f2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02f3, code lost:
        r10 = r2;
        r7 = r3;
        r3 = r5;
        r13 = "extras_key_session_not_finish";
        r2 = "******* issue time:";
        r6 = ", preload:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0300, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0301, code lost:
        r10 = r2;
        r7 = r3;
        r3 = r5;
        r13 = "extras_key_session_not_finish";
        r2 = "******* issue time:";
        r6 = ", preload:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0308, code lost:
        r8 = r4;
        r4 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0324, code lost:
        com.miui.tsmclient.model.e.h.a().a(r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0336, code lost:
        r10.setObjectName(r9.mCardType);
        r10.setCoreOperation("issue");
        com.miui.tsmclient.model.p.a(r27).a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0365, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0366, code lost:
        r10 = r2;
        r7 = r3;
        r3 = r5;
        r13 = "extras_key_session_not_finish";
        r2 = "******* issue time:";
        r6 = ", preload:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0387, code lost:
        com.miui.tsmclient.model.e.h.a().a(r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0397, code lost:
        r10.setObjectName(r9.mCardType);
        r10.setCoreOperation("issue");
        com.miui.tsmclient.model.p.a(r27).a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03d5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03d6, code lost:
        r10 = r2;
        r7 = r3;
        r3 = r5;
        r13 = "extras_key_session_not_finish";
        r2 = "******* issue time:";
        r6 = ", preload:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03dd, code lost:
        r8 = r4;
        r4 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03f2, code lost:
        com.miui.tsmclient.model.e.h.a().a(r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0403, code lost:
        r10.setObjectName(r9.mCardType);
        r10.setCoreOperation("issue");
        com.miui.tsmclient.model.p.a(r27).a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0446, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0447, code lost:
        r10 = r2;
        r7 = r3;
        r3 = r5;
        r13 = "extras_key_session_not_finish";
        r2 = "******* issue time:";
        r6 = ", preload:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0474, code lost:
        com.miui.tsmclient.model.e.h.a().a(r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0486, code lost:
        r10.setObjectName(r9.mCardType);
        r10.setCoreOperation("issue");
        com.miui.tsmclient.model.p.a(r27).a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
        r1 = 0;
        r8 = r4;
        r4 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d6, code lost:
        r3 = r5;
        r13 = "extras_key_session_not_finish";
        r7 = r10;
        r2 = "******* issue time:";
        r6 = ", preload:";
        r10 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00df, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e0, code lost:
        r3 = r5;
        r13 = "extras_key_session_not_finish";
        r7 = r10;
        r2 = "******* issue time:";
        r6 = ", preload:";
        r10 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ea, code lost:
        r3 = r5;
        r13 = "extras_key_session_not_finish";
        r7 = r10;
        r2 = "******* issue time:";
        r6 = ", preload:";
        r10 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0177, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        r4 = r19;
        r3 = r20;
        r1 = r2;
        r2 = "******* issue time:";
        r6 = ", preload:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0183, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0184, code lost:
        r4 = r19;
        r3 = r20;
        r1 = r2;
        r2 = "******* issue time:";
        r6 = ", preload:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x018f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0190, code lost:
        r4 = r19;
        r3 = r20;
        r1 = r2;
        r2 = "******* issue time:";
        r6 = ", preload:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a7, code lost:
        r4 = r19;
        r3 = r20;
        r2 = "******* issue time:";
        r6 = ", preload:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01bc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bd, code lost:
        r4 = r19;
        r3 = r20;
        r2 = "******* issue time:";
        r6 = ", preload:";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02c6 A[ExcHandler: InterruptedException (e java.lang.InterruptedException), Splitter:B:39:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02dc A[ExcHandler: IOException (e java.io.IOException), Splitter:B:39:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0300 A[ExcHandler: InterruptedException (e java.lang.InterruptedException), Splitter:B:10:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03d5 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:10:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0403  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0474  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0486  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04c4  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x04d4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0114 A[SYNTHETIC, Splitter:B:58:0x0114] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01a6 A[ExcHandler: InterruptedException (e java.lang.InterruptedException), Splitter:B:58:0x0114] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01bc A[ExcHandler: IOException (e java.io.IOException), Splitter:B:58:0x0114] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d2  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:165:0x0371=Splitter:B:165:0x0371, B:194:0x0452=Splitter:B:194:0x0452} */
    public BaseResponse a(Context context, CardInfo cardInfo, Bundle bundle) {
        String str;
        UserExceptionLogInfo userExceptionLogInfo;
        boolean z;
        h.a aVar;
        String str2;
        String str3;
        Bundle bundle2;
        String str4;
        int i;
        String str5;
        int i2;
        StringBuilder sb;
        String str6;
        Bundle bundle3;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        long j;
        boolean z2;
        Bundle bundle4;
        BaseResponse a2;
        String str12;
        Context context2 = context;
        CardInfo cardInfo2 = cardInfo;
        Bundle bundle5 = bundle;
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle6 = bundle5 == null ? new Bundle() : bundle5;
        boolean z3 = bundle6.getBoolean("out_operation");
        boolean z4 = bundle6.getBoolean("pre_load");
        h.a aVar2 = (h.a) bundle6.getSerializable("extras_key_business_type");
        if (aVar2 == null) {
            aVar2 = z3 ? h.a.OUT_INSTALL : h.a.INSTALL;
        }
        h.a aVar3 = aVar2;
        UserExceptionLogInfo userExceptionLogInfo2 = new UserExceptionLogInfo();
        String str13 = "";
        String str14 = " *******";
        try {
            TsmRpcModels.TsmSessionInfo a3 = a(context2, cardInfo2, aVar3, true);
            userExceptionLogInfo2.setSessionId(a3 != null ? a3.getSessionId() : str13);
            TsmRpcModels.SeOperationType valueOf = TsmRpcModels.SeOperationType.valueOf(bundle6.getInt("extras_key_se_operation", z3 ? 21 : 3));
            if (z4) {
                valueOf = TsmRpcModels.SeOperationType.LOAD;
            } else {
                d.set(true);
            }
            TsmRpcModels.SeOperationType seOperationType = valueOf;
            LogUtils.d("issue called. SeOperationType: ".concat(String.valueOf(seOperationType)));
            UserExceptionLogInfo userExceptionLogInfo3 = userExceptionLogInfo2;
            h.a aVar4 = aVar3;
            try {
                long j2 = bundle6.getLong("version_control_id", 0);
                if (a(seOperationType)) {
                    String a4 = b.a(j2);
                    if (!TextUtils.isEmpty(a4)) {
                        j = j2;
                        bundle6.putString("need_phone_number", a4);
                        z2 = true;
                        aVar = aVar4;
                        userExceptionLogInfo = userExceptionLogInfo3;
                        z = z4;
                        TsmRpcModels.TsmSessionInfo tsmSessionInfo = a3;
                        bundle4 = bundle6;
                        TsmRpcModels.SeOperationType seOperationType2 = seOperationType;
                        str = "extras_key_session_not_finish";
                        a2 = a(context, cardInfo, tsmSessionInfo, seOperationType2, bundle4);
                        if (a2.mResultCode == 0) {
                            try {
                                int i3 = a2.mResultCode;
                                userExceptionLogInfo.setErrorDesc(a2.mMsg);
                                userExceptionLogInfo.setErrorCode(i3);
                                if (!bundle4.getBoolean(str)) {
                                    h.a().a(cardInfo2, aVar);
                                }
                                userExceptionLogInfo.setErrorCode(i3);
                                if (userExceptionLogInfo.needUpload()) {
                                    userExceptionLogInfo.setObjectName(cardInfo2.mCardType);
                                    userExceptionLogInfo.setCoreOperation("issue");
                                    p.a(context).a(userExceptionLogInfo);
                                }
                                LogUtils.d("issue finished. resultCode: " + i3 + ", preload:" + z);
                                StringBuilder sb2 = new StringBuilder("******* issue time:");
                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                sb2.append(str14);
                                LogUtils.d(sb2.toString());
                                i2 = i3;
                            } catch (NfcEeIOException e) {
                                e = e;
                                str3 = str14;
                                bundle3 = bundle4;
                                str7 = "******* issue time:";
                                str6 = ", preload:";
                                int i4 = 0;
                                LogUtils.e("issue failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                                try {
                                    userExceptionLogInfo.setExtra(e.getMessage());
                                    if (!bundle2.getBoolean(str)) {
                                    }
                                    i2 = 10;
                                    userExceptionLogInfo.setErrorCode(10);
                                    if (userExceptionLogInfo.needUpload()) {
                                    }
                                    LogUtils.d("issue finished. resultCode: 10" + str2 + z);
                                    sb = new StringBuilder(str4);
                                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                                    sb.append(str3);
                                    LogUtils.d(sb.toString());
                                    str5 = str13;
                                    return new BaseResponse(i, str5, new Object[0]);
                                } catch (Throwable th) {
                                    th = th;
                                    i = 10;
                                    if (!bundle2.getBoolean(str)) {
                                    }
                                    userExceptionLogInfo.setErrorCode(i);
                                    if (userExceptionLogInfo.needUpload()) {
                                    }
                                    LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                                    StringBuilder sb3 = new StringBuilder(str4);
                                    sb3.append(System.currentTimeMillis() - currentTimeMillis);
                                    sb3.append(str3);
                                    LogUtils.d(sb3.toString());
                                    throw th;
                                }
                            } catch (IOException e2) {
                            } catch (com.miui.tsmclient.seitsm.a.a e3) {
                                e = e3;
                                str3 = str14;
                                bundle3 = bundle4;
                                str9 = "******* issue time:";
                                str6 = ", preload:";
                                i = 0;
                                try {
                                    i = e.a();
                                    str5 = e.getMessage();
                                    userExceptionLogInfo.setExtra(str5);
                                    LogUtils.e("issue failed with an tsmapi exception.", e);
                                    if (!bundle2.getBoolean(str)) {
                                    }
                                    userExceptionLogInfo.setErrorCode(i);
                                    if (userExceptionLogInfo.needUpload()) {
                                    }
                                    LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                                    StringBuilder sb4 = new StringBuilder(str4);
                                    sb4.append(System.currentTimeMillis() - currentTimeMillis);
                                    sb4.append(str3);
                                    LogUtils.d(sb4.toString());
                                    return new BaseResponse(i, str5, new Object[0]);
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (!bundle2.getBoolean(str)) {
                                    }
                                    userExceptionLogInfo.setErrorCode(i);
                                    if (userExceptionLogInfo.needUpload()) {
                                    }
                                    LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                                    StringBuilder sb32 = new StringBuilder(str4);
                                    sb32.append(System.currentTimeMillis() - currentTimeMillis);
                                    sb32.append(str3);
                                    LogUtils.d(sb32.toString());
                                    throw th;
                                }
                            } catch (InterruptedException e4) {
                            } catch (Throwable th3) {
                                th = th3;
                                str3 = str14;
                                bundle3 = bundle4;
                                str11 = "******* issue time:";
                                str6 = ", preload:";
                                i = 0;
                                if (!bundle2.getBoolean(str)) {
                                }
                                userExceptionLogInfo.setErrorCode(i);
                                if (userExceptionLogInfo.needUpload()) {
                                }
                                LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                                StringBuilder sb322 = new StringBuilder(str4);
                                sb322.append(System.currentTimeMillis() - currentTimeMillis);
                                sb322.append(str3);
                                LogUtils.d(sb322.toString());
                                throw th;
                            }
                            str5 = str13;
                            return new BaseResponse(i, str5, new Object[0]);
                        }
                        str3 = str14;
                        bundle3 = bundle4;
                        if (z2) {
                            try {
                                if (!bundle5.getBoolean(str)) {
                                    str12 = "******* issue time:";
                                    str6 = ", preload:";
                                    try {
                                        b.a().b(context, cardInfo2.mCardType, j);
                                        if (!bundle3.getBoolean(str)) {
                                            h.a().a(cardInfo2, aVar);
                                        }
                                        userExceptionLogInfo.setErrorCode(0);
                                        if (userExceptionLogInfo.needUpload()) {
                                            userExceptionLogInfo.setObjectName(cardInfo2.mCardType);
                                            userExceptionLogInfo.setCoreOperation("issue");
                                            p.a(context).a(userExceptionLogInfo);
                                        }
                                        LogUtils.d("issue finished. resultCode: 0" + str6 + z);
                                        LogUtils.d(str12 + (System.currentTimeMillis() - currentTimeMillis) + str3);
                                        return a2;
                                    } catch (NfcEeIOException e5) {
                                        e = e5;
                                        str7 = str12;
                                    } catch (IOException e6) {
                                        e = e6;
                                        str8 = str12;
                                        try {
                                            userExceptionLogInfo.setExtra(e.getMessage());
                                            LogUtils.e("issue failed with an io exception.", e);
                                            if (!bundle2.getBoolean(str)) {
                                            }
                                            i2 = 2;
                                            userExceptionLogInfo.setErrorCode(2);
                                            if (userExceptionLogInfo.needUpload()) {
                                            }
                                            LogUtils.d("issue finished. resultCode: 2" + str2 + z);
                                            sb = new StringBuilder(str4);
                                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                                            sb.append(str3);
                                            LogUtils.d(sb.toString());
                                            str5 = str13;
                                            return new BaseResponse(i, str5, new Object[0]);
                                        } catch (Throwable th4) {
                                            th = th4;
                                            i = 2;
                                            if (!bundle2.getBoolean(str)) {
                                            }
                                            userExceptionLogInfo.setErrorCode(i);
                                            if (userExceptionLogInfo.needUpload()) {
                                            }
                                            LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                                            StringBuilder sb3222 = new StringBuilder(str4);
                                            sb3222.append(System.currentTimeMillis() - currentTimeMillis);
                                            sb3222.append(str3);
                                            LogUtils.d(sb3222.toString());
                                            throw th;
                                        }
                                    } catch (com.miui.tsmclient.seitsm.a.a e7) {
                                        e = e7;
                                        str9 = str12;
                                        i = 0;
                                        i = e.a();
                                        str5 = e.getMessage();
                                        userExceptionLogInfo.setExtra(str5);
                                        LogUtils.e("issue failed with an tsmapi exception.", e);
                                        if (!bundle2.getBoolean(str)) {
                                        }
                                        userExceptionLogInfo.setErrorCode(i);
                                        if (userExceptionLogInfo.needUpload()) {
                                        }
                                        LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                                        StringBuilder sb42 = new StringBuilder(str4);
                                        sb42.append(System.currentTimeMillis() - currentTimeMillis);
                                        sb42.append(str3);
                                        LogUtils.d(sb42.toString());
                                        return new BaseResponse(i, str5, new Object[0]);
                                    } catch (InterruptedException e8) {
                                        e = e8;
                                        str10 = str12;
                                        try {
                                            userExceptionLogInfo.setExtra(e.getMessage());
                                            LogUtils.e("issue is interrupted.", e);
                                            Thread.currentThread().interrupt();
                                            if (!bundle2.getBoolean(str)) {
                                            }
                                            i2 = 11;
                                            userExceptionLogInfo.setErrorCode(11);
                                            if (userExceptionLogInfo.needUpload()) {
                                            }
                                            LogUtils.d("issue finished. resultCode: 11" + str2 + z);
                                            sb = new StringBuilder(str4);
                                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                                            sb.append(str3);
                                            LogUtils.d(sb.toString());
                                            str5 = str13;
                                            return new BaseResponse(i, str5, new Object[0]);
                                        } catch (Throwable th5) {
                                            th = th5;
                                            i = 11;
                                            if (!bundle2.getBoolean(str)) {
                                                h.a().a(cardInfo2, aVar);
                                            }
                                            userExceptionLogInfo.setErrorCode(i);
                                            if (userExceptionLogInfo.needUpload()) {
                                                userExceptionLogInfo.setObjectName(cardInfo2.mCardType);
                                                userExceptionLogInfo.setCoreOperation("issue");
                                                p.a(context).a(userExceptionLogInfo);
                                            }
                                            LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                                            StringBuilder sb32222 = new StringBuilder(str4);
                                            sb32222.append(System.currentTimeMillis() - currentTimeMillis);
                                            sb32222.append(str3);
                                            LogUtils.d(sb32222.toString());
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        str11 = str12;
                                        i = 0;
                                        if (!bundle2.getBoolean(str)) {
                                        }
                                        userExceptionLogInfo.setErrorCode(i);
                                        if (userExceptionLogInfo.needUpload()) {
                                        }
                                        LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                                        StringBuilder sb322222 = new StringBuilder(str4);
                                        sb322222.append(System.currentTimeMillis() - currentTimeMillis);
                                        sb322222.append(str3);
                                        LogUtils.d(sb322222.toString());
                                        throw th;
                                    }
                                }
                            } catch (NfcEeIOException e9) {
                                e = e9;
                                str6 = ", preload:";
                                str7 = "******* issue time:";
                                int i42 = 0;
                                LogUtils.e("issue failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                                userExceptionLogInfo.setExtra(e.getMessage());
                                if (!bundle2.getBoolean(str)) {
                                }
                                i2 = 10;
                                userExceptionLogInfo.setErrorCode(10);
                                if (userExceptionLogInfo.needUpload()) {
                                }
                                LogUtils.d("issue finished. resultCode: 10" + str2 + z);
                                sb = new StringBuilder(str4);
                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                sb.append(str3);
                                LogUtils.d(sb.toString());
                                str5 = str13;
                                return new BaseResponse(i, str5, new Object[0]);
                            } catch (IOException e10) {
                                e = e10;
                                str6 = ", preload:";
                                str8 = "******* issue time:";
                                userExceptionLogInfo.setExtra(e.getMessage());
                                LogUtils.e("issue failed with an io exception.", e);
                                if (!bundle2.getBoolean(str)) {
                                }
                                i2 = 2;
                                userExceptionLogInfo.setErrorCode(2);
                                if (userExceptionLogInfo.needUpload()) {
                                }
                                LogUtils.d("issue finished. resultCode: 2" + str2 + z);
                                sb = new StringBuilder(str4);
                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                sb.append(str3);
                                LogUtils.d(sb.toString());
                                str5 = str13;
                                return new BaseResponse(i, str5, new Object[0]);
                            } catch (com.miui.tsmclient.seitsm.a.a e11) {
                                e = e11;
                                str6 = ", preload:";
                                str9 = "******* issue time:";
                                i = 0;
                                i = e.a();
                                str5 = e.getMessage();
                                userExceptionLogInfo.setExtra(str5);
                                LogUtils.e("issue failed with an tsmapi exception.", e);
                                if (!bundle2.getBoolean(str)) {
                                }
                                userExceptionLogInfo.setErrorCode(i);
                                if (userExceptionLogInfo.needUpload()) {
                                }
                                LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                                StringBuilder sb422 = new StringBuilder(str4);
                                sb422.append(System.currentTimeMillis() - currentTimeMillis);
                                sb422.append(str3);
                                LogUtils.d(sb422.toString());
                                return new BaseResponse(i, str5, new Object[0]);
                            } catch (InterruptedException e12) {
                                e = e12;
                                str6 = ", preload:";
                                str10 = "******* issue time:";
                                userExceptionLogInfo.setExtra(e.getMessage());
                                LogUtils.e("issue is interrupted.", e);
                                Thread.currentThread().interrupt();
                                if (!bundle2.getBoolean(str)) {
                                }
                                i2 = 11;
                                userExceptionLogInfo.setErrorCode(11);
                                if (userExceptionLogInfo.needUpload()) {
                                }
                                LogUtils.d("issue finished. resultCode: 11" + str2 + z);
                                sb = new StringBuilder(str4);
                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                sb.append(str3);
                                LogUtils.d(sb.toString());
                                str5 = str13;
                                return new BaseResponse(i, str5, new Object[0]);
                            } catch (Throwable th7) {
                                th = th7;
                                str6 = ", preload:";
                                str11 = "******* issue time:";
                                i = 0;
                                if (!bundle2.getBoolean(str)) {
                                }
                                userExceptionLogInfo.setErrorCode(i);
                                if (userExceptionLogInfo.needUpload()) {
                                }
                                LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                                StringBuilder sb3222222 = new StringBuilder(str4);
                                sb3222222.append(System.currentTimeMillis() - currentTimeMillis);
                                sb3222222.append(str3);
                                LogUtils.d(sb3222222.toString());
                                throw th;
                            }
                        }
                        str12 = "******* issue time:";
                        str6 = ", preload:";
                        if (!bundle3.getBoolean(str)) {
                        }
                        userExceptionLogInfo.setErrorCode(0);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        LogUtils.d("issue finished. resultCode: 0" + str6 + z);
                        LogUtils.d(str12 + (System.currentTimeMillis() - currentTimeMillis) + str3);
                        return a2;
                    }
                }
                j = j2;
                z2 = false;
                aVar = aVar4;
                userExceptionLogInfo = userExceptionLogInfo3;
                z = z4;
                TsmRpcModels.TsmSessionInfo tsmSessionInfo2 = a3;
                bundle4 = bundle6;
                TsmRpcModels.SeOperationType seOperationType22 = seOperationType;
                str = "extras_key_session_not_finish";
                try {
                    a2 = a(context, cardInfo, tsmSessionInfo2, seOperationType22, bundle4);
                    if (a2.mResultCode == 0) {
                    }
                } catch (NfcEeIOException e13) {
                    e = e13;
                    str7 = "******* issue time:";
                    str6 = ", preload:";
                    str3 = str14;
                    bundle3 = bundle4;
                    int i422 = 0;
                    LogUtils.e("issue failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                    userExceptionLogInfo.setExtra(e.getMessage());
                    if (!bundle2.getBoolean(str)) {
                    }
                    i2 = 10;
                    userExceptionLogInfo.setErrorCode(10);
                    if (userExceptionLogInfo.needUpload()) {
                    }
                    LogUtils.d("issue finished. resultCode: 10" + str2 + z);
                    sb = new StringBuilder(str4);
                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                    sb.append(str3);
                    LogUtils.d(sb.toString());
                    str5 = str13;
                    return new BaseResponse(i, str5, new Object[0]);
                } catch (IOException e14) {
                    e = e14;
                    str8 = "******* issue time:";
                    str6 = ", preload:";
                    str3 = str14;
                    bundle3 = bundle4;
                    userExceptionLogInfo.setExtra(e.getMessage());
                    LogUtils.e("issue failed with an io exception.", e);
                    if (!bundle2.getBoolean(str)) {
                    }
                    i2 = 2;
                    userExceptionLogInfo.setErrorCode(2);
                    if (userExceptionLogInfo.needUpload()) {
                    }
                    LogUtils.d("issue finished. resultCode: 2" + str2 + z);
                    sb = new StringBuilder(str4);
                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                    sb.append(str3);
                    LogUtils.d(sb.toString());
                    str5 = str13;
                    return new BaseResponse(i, str5, new Object[0]);
                } catch (com.miui.tsmclient.seitsm.a.a e15) {
                    e = e15;
                    str9 = "******* issue time:";
                    str6 = ", preload:";
                    str3 = str14;
                    bundle3 = bundle4;
                    i = 0;
                    i = e.a();
                    str5 = e.getMessage();
                    userExceptionLogInfo.setExtra(str5);
                    LogUtils.e("issue failed with an tsmapi exception.", e);
                    if (!bundle2.getBoolean(str)) {
                    }
                    userExceptionLogInfo.setErrorCode(i);
                    if (userExceptionLogInfo.needUpload()) {
                    }
                    LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                    StringBuilder sb4222 = new StringBuilder(str4);
                    sb4222.append(System.currentTimeMillis() - currentTimeMillis);
                    sb4222.append(str3);
                    LogUtils.d(sb4222.toString());
                    return new BaseResponse(i, str5, new Object[0]);
                } catch (InterruptedException e16) {
                    e = e16;
                    str10 = "******* issue time:";
                    str6 = ", preload:";
                    str3 = str14;
                    bundle3 = bundle4;
                    userExceptionLogInfo.setExtra(e.getMessage());
                    LogUtils.e("issue is interrupted.", e);
                    Thread.currentThread().interrupt();
                    if (!bundle2.getBoolean(str)) {
                    }
                    i2 = 11;
                    userExceptionLogInfo.setErrorCode(11);
                    if (userExceptionLogInfo.needUpload()) {
                    }
                    LogUtils.d("issue finished. resultCode: 11" + str2 + z);
                    sb = new StringBuilder(str4);
                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                    sb.append(str3);
                    LogUtils.d(sb.toString());
                    str5 = str13;
                    return new BaseResponse(i, str5, new Object[0]);
                } catch (Throwable th8) {
                    th = th8;
                    str11 = "******* issue time:";
                    str6 = ", preload:";
                    str3 = str14;
                    bundle3 = bundle4;
                    i = 0;
                    if (!bundle2.getBoolean(str)) {
                    }
                    userExceptionLogInfo.setErrorCode(i);
                    if (userExceptionLogInfo.needUpload()) {
                    }
                    LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                    StringBuilder sb32222222 = new StringBuilder(str4);
                    sb32222222.append(System.currentTimeMillis() - currentTimeMillis);
                    sb32222222.append(str3);
                    LogUtils.d(sb32222222.toString());
                    throw th;
                }
            } catch (NfcEeIOException e17) {
                e = e17;
                Bundle bundle7 = bundle6;
                String str15 = "extras_key_session_not_finish";
                h.a aVar5 = aVar4;
                str7 = "******* issue time:";
                String str16 = ", preload:";
                UserExceptionLogInfo userExceptionLogInfo4 = userExceptionLogInfo3;
                z = z4;
                str3 = str14;
                int i4222 = 0;
                LogUtils.e("issue failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                userExceptionLogInfo.setExtra(e.getMessage());
                if (!bundle2.getBoolean(str)) {
                }
                i2 = 10;
                userExceptionLogInfo.setErrorCode(10);
                if (userExceptionLogInfo.needUpload()) {
                }
                LogUtils.d("issue finished. resultCode: 10" + str2 + z);
                sb = new StringBuilder(str4);
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                sb.append(str3);
                LogUtils.d(sb.toString());
                str5 = str13;
                return new BaseResponse(i, str5, new Object[0]);
            } catch (IOException e18) {
            } catch (com.miui.tsmclient.seitsm.a.a e19) {
                e = e19;
                Bundle bundle8 = bundle6;
                String str17 = "extras_key_session_not_finish";
                h.a aVar6 = aVar4;
                str9 = "******* issue time:";
                String str18 = ", preload:";
                UserExceptionLogInfo userExceptionLogInfo5 = userExceptionLogInfo3;
                z = z4;
                str3 = str14;
                i = 0;
                i = e.a();
                str5 = e.getMessage();
                userExceptionLogInfo.setExtra(str5);
                LogUtils.e("issue failed with an tsmapi exception.", e);
                if (!bundle2.getBoolean(str)) {
                }
                userExceptionLogInfo.setErrorCode(i);
                if (userExceptionLogInfo.needUpload()) {
                }
                LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                StringBuilder sb42222 = new StringBuilder(str4);
                sb42222.append(System.currentTimeMillis() - currentTimeMillis);
                sb42222.append(str3);
                LogUtils.d(sb42222.toString());
                return new BaseResponse(i, str5, new Object[0]);
            } catch (InterruptedException e20) {
            } catch (Throwable th9) {
                th = th9;
                bundle3 = bundle6;
                String str19 = "extras_key_session_not_finish";
                h.a aVar7 = aVar4;
                str11 = "******* issue time:";
                str6 = ", preload:";
                UserExceptionLogInfo userExceptionLogInfo6 = userExceptionLogInfo3;
                z = z4;
                str3 = str14;
                i = 0;
                if (!bundle2.getBoolean(str)) {
                }
                userExceptionLogInfo.setErrorCode(i);
                if (userExceptionLogInfo.needUpload()) {
                }
                LogUtils.d("issue finished. resultCode: " + i + str2 + z);
                StringBuilder sb322222222 = new StringBuilder(str4);
                sb322222222.append(System.currentTimeMillis() - currentTimeMillis);
                sb322222222.append(str3);
                LogUtils.d(sb322222222.toString());
                throw th;
            }
        } catch (NfcEeIOException e21) {
            e = e21;
            UserExceptionLogInfo userExceptionLogInfo7 = userExceptionLogInfo2;
            h.a aVar8 = aVar3;
            Bundle bundle9 = bundle6;
            String str20 = "extras_key_session_not_finish";
            String str21 = "******* issue time:";
            String str22 = ", preload:";
        } catch (IOException e22) {
        } catch (com.miui.tsmclient.seitsm.a.a e23) {
            e = e23;
            UserExceptionLogInfo userExceptionLogInfo8 = userExceptionLogInfo2;
            h.a aVar9 = aVar3;
            Bundle bundle10 = bundle6;
            String str23 = "extras_key_session_not_finish";
            String str24 = "******* issue time:";
            String str25 = ", preload:";
            i = 0;
            z = z4;
            str3 = str14;
            i = e.a();
            str5 = e.getMessage();
            userExceptionLogInfo.setExtra(str5);
            LogUtils.e("issue failed with an tsmapi exception.", e);
            if (!bundle2.getBoolean(str)) {
            }
            userExceptionLogInfo.setErrorCode(i);
            if (userExceptionLogInfo.needUpload()) {
            }
            LogUtils.d("issue finished. resultCode: " + i + str2 + z);
            StringBuilder sb422222 = new StringBuilder(str4);
            sb422222.append(System.currentTimeMillis() - currentTimeMillis);
            sb422222.append(str3);
            LogUtils.d(sb422222.toString());
            return new BaseResponse(i, str5, new Object[0]);
        } catch (InterruptedException e24) {
        } catch (Throwable th10) {
            th = th10;
            userExceptionLogInfo = userExceptionLogInfo2;
            aVar = aVar3;
            bundle2 = bundle6;
            str = "extras_key_session_not_finish";
            str4 = "******* issue time:";
            str2 = ", preload:";
            i = 0;
            z = z4;
            str3 = str14;
            if (!bundle2.getBoolean(str)) {
            }
            userExceptionLogInfo.setErrorCode(i);
            if (userExceptionLogInfo.needUpload()) {
            }
            LogUtils.d("issue finished. resultCode: " + i + str2 + z);
            StringBuilder sb3222222222 = new StringBuilder(str4);
            sb3222222222.append(System.currentTimeMillis() - currentTimeMillis);
            sb3222222222.append(str3);
            LogUtils.d(sb3222222222.toString());
            throw th;
        }
    }

    public BaseResponse a(Context context, CardInfo cardInfo, TsmRpcModels.TsmSessionInfo tsmSessionInfo, Bundle bundle) throws IOException, com.miui.tsmclient.seitsm.a.a, InterruptedException {
        TsmRpcModels.TsmAPDUCommand a2 = this.c.a(context, tsmSessionInfo, TsmRpcModels.SeOperationType.SYNC, cardInfo, bundle);
        if (a2 != null) {
            int a3 = f.a(a2.getResult());
            if (a3 != 0) {
                throw new com.miui.tsmclient.seitsm.a.a(a3, a2.getErrorDesc());
            } else if (a2.getApdusList() == null || a2.getApdusList().isEmpty()) {
                return new BaseResponse(0, "no_apdu", new Object[0]);
            } else {
                IScTerminal terminal = cardInfo.getTerminal();
                try {
                    terminal.open();
                    BaseResponse a4 = a(context, terminal, tsmSessionInfo, a2);
                    LogUtils.d("sync ese finished, result:" + a4.mResultCode);
                    if (bundle == null || !bundle.getBoolean("only_sync_card")) {
                        d.set(false);
                    }
                    return a4;
                } finally {
                    terminal.close();
                }
            }
        } else {
            LogUtils.e("syncEse failed, no apdu commands");
            throw new com.miui.tsmclient.seitsm.a.a(8, "");
        }
    }

    /* access modifiers changed from: protected */
    public BaseResponse a(Context context, CardInfo cardInfo, TsmRpcModels.TsmSessionInfo tsmSessionInfo, TsmRpcModels.SeOperationType seOperationType, Bundle bundle) throws IOException, com.miui.tsmclient.seitsm.a.a, InterruptedException {
        BaseResponse a2 = d.get() ? a(context, cardInfo, tsmSessionInfo, bundle) : null;
        if (d.get()) {
            return a2;
        }
        TsmRpcModels.TsmAPDUCommand a3 = this.c.a(context, tsmSessionInfo, seOperationType, cardInfo, bundle);
        if (a3 == null) {
            d.set(true);
            return new BaseResponse(8, new Object[0]);
        }
        int a4 = f.a(a3.getResult());
        if (a4 != 0) {
            throw new com.miui.tsmclient.seitsm.a.a(a4, a3.getErrorDesc());
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

    /* access modifiers changed from: protected */
    public BaseResponse a(Context context, CardInfo cardInfo, TsmRpcModels.TsmSessionInfo tsmSessionInfo, TsmRpcModels.TsmAPDUCommand tsmAPDUCommand) throws IOException, InterruptedException, com.miui.tsmclient.seitsm.a.a {
        IScTerminal terminal = cardInfo.getTerminal();
        try {
            terminal.open();
            return a(context, terminal, tsmSessionInfo, tsmAPDUCommand);
        } finally {
            terminal.close();
        }
    }

    /* access modifiers changed from: protected */
    public BaseResponse a(Context context, IScTerminal iScTerminal, TsmRpcModels.TsmSessionInfo tsmSessionInfo, TsmRpcModels.TsmAPDUCommand tsmAPDUCommand) throws IOException, com.miui.tsmclient.seitsm.a.a, InterruptedException {
        return a(context, iScTerminal, tsmSessionInfo, tsmAPDUCommand, null, true);
    }

    /* access modifiers changed from: protected */
    public BaseResponse a(Context context, IScTerminal iScTerminal, TsmRpcModels.TsmSessionInfo tsmSessionInfo, TsmRpcModels.TsmAPDUCommand tsmAPDUCommand, TsmRpcModels.SeOperationType seOperationType, boolean z) throws IOException, com.miui.tsmclient.seitsm.a.a, InterruptedException {
        String str;
        List<TsmRpcModels.TsmCAPDU> apdusList = tsmAPDUCommand.getApdusList();
        if (apdusList == null || apdusList.isEmpty()) {
            throw new com.miui.tsmclient.seitsm.a.a(f.a(tsmAPDUCommand.getResult()), tsmAPDUCommand.getErrorDesc());
        }
        ArrayList arrayList = new ArrayList();
        boolean a2 = a(iScTerminal, apdusList, arrayList);
        if (z) {
            TsmRpcModels.TsmAPDUCommand a3 = this.c.a(context, tsmSessionInfo, arrayList);
            if (a3 == null) {
                LogUtils.d("can not get nextApducommand, processSeResponse failed.");
                return new BaseResponse(16, new Object[0]);
            }
            int a4 = f.a(a3.getResult());
            if (a4 != 0) {
                throw new com.miui.tsmclient.seitsm.a.a(a4, a3.getErrorDesc());
            } else if (a3.getApdusList() != null && !a3.getApdusList().isEmpty()) {
                return a(context, iScTerminal, tsmSessionInfo, a3);
            } else {
                LogUtils.d("no more apdu, execute finished!");
                return new BaseResponse(0, new Object[0]);
            }
        } else {
            TsmRpcModels.CommonResponse a5 = this.c.a(context, tsmSessionInfo, a2, seOperationType, arrayList);
            if (a5 == null || a5.getResult() != 0) {
                int i = -2;
                if (a5 != null) {
                    i = a5.getResult();
                    str = a5.getErrorDesc();
                } else {
                    str = "";
                }
                throw new com.miui.tsmclient.seitsm.a.a(i, str);
            }
            return new BaseResponse(a2 ? 0 : 8, new Object[0]);
        }
    }

    public BaseResponse a(Context context, String str, String str2) throws com.miui.tsmclient.seitsm.a.a, AuthApiException, InterruptedException {
        CardInfo cardInfo = new CardInfo("DUMMY");
        TsmRpcModels.TsmStartActionResponse a2 = this.c.a(context, cardInfo, TsmRpcModels.SeOperationType.valueOf(str), str2);
        if (a2 == null) {
            LogUtils.e("startAction() returns null");
            return new BaseResponse(1, new Object[0]);
        }
        int a3 = f.a(a2.getResult());
        if (a3 != 0) {
            return new BaseResponse(a3, a2.getErrorDesc(), new Object[0]);
        }
        try {
            BaseResponse a4 = a(context, cardInfo, TsmRpcModels.TsmSessionInfo.newBuilder().setResult(a2.getResult()).setSessionId(a2.getSessionId()).setErrorDesc(a2.getErrorDesc()).build(), a2.getApduCommand());
            String aid = a2.getApduCommand().getAid();
            LogUtils.d("enroll card finished when invoking task, aid = ".concat(String.valueOf(aid)));
            a4.mDatas = new Object[]{aid};
            LogUtils.e("invoke finished, result: " + a4.mResultCode);
            return a4;
        } catch (IOException e) {
            String message = e.getMessage();
            LogUtils.e("io exception occurs when processing apdu commands.", e);
            return new BaseResponse(2, message, new Object[0]);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, boolean):com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo
     arg types: [android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, int]
     candidates:
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.tsmclient.smartcard.terminal.IScTerminal, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, boolean):com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo */
    public TsmRpcModels.TsmSessionInfo a(Context context, CardInfo cardInfo, h.a aVar) throws com.miui.tsmclient.seitsm.a.a {
        return a(context, cardInfo, aVar, false);
    }

    public TsmRpcModels.TsmSessionInfo a(Context context, CardInfo cardInfo, h.a aVar, boolean z) throws com.miui.tsmclient.seitsm.a.a {
        h a2 = h.a();
        TsmRpcModels.TsmSessionInfo a3 = aVar == null ? a2.a(context, cardInfo) : a2.a(context, cardInfo, aVar, z);
        if (a3.getResult() == 0) {
            LogUtils.d("sessionInfo : " + a3.getSessionId());
            return a3;
        }
        throw new com.miui.tsmclient.seitsm.a.a(f.a(a3.getResult()), a3.getErrorDesc());
    }

    /* access modifiers changed from: protected */
    public void a(Context context, CardInfo cardInfo) {
        Intent intent = new Intent("com.xiaomi.tsmclient.action.UPDATE_CARD_INFO");
        intent.putExtra("card_info", cardInfo);
        context.sendBroadcast(intent, "com.miui.tsmclient.permission.TSM_GROUP");
    }

    /* access modifiers changed from: protected */
    public boolean a(IScTerminal iScTerminal, List<TsmRpcModels.TsmCAPDU> list, List<TsmRpcModels.SeAPDUResponseItem> list2) throws IOException, InterruptedException {
        com.miui.tsmclient.b.a.a aVar;
        IApduExecutor b;
        int i = 0;
        if (!(iScTerminal instanceof com.miui.tsmclient.b.a.a) || (b = (aVar = (com.miui.tsmclient.b.a.a) iScTerminal).b()) == null) {
            int i2 = 0;
            for (TsmRpcModels.TsmCAPDU next : list) {
                ScResponse transmit = iScTerminal.transmit(next.getApdu().toByteArray());
                i2++;
                list2.add(TsmRpcModels.SeAPDUResponseItem.newBuilder().setIndex(i2).setResponseData(ByteString.copyFrom(transmit.getData().toBytes())).setResponseSw(ByteString.copyFrom(transmit.getStatus().toBytes())).build());
                if (TextUtils.isEmpty(next.getExpectSwRegex())) {
                    LogUtils.w("no expected sw.");
                    return false;
                } else if (!Pattern.compile(next.getExpectSwRegex()).matcher(Coder.bytesToHexString(transmit.getStatus().toBytes())).matches()) {
                    return false;
                }
            }
            return true;
        }
        CommandList commandList = new CommandList();
        for (TsmRpcModels.TsmCAPDU next2 : list) {
            commandList.addCommand(new CommandList.Command(next2.getApdu().toByteArray(), next2.getExpectSwRegex()));
        }
        LogUtils.v("internalExecute command size: " + commandList.getList().size());
        ResponseList execute = b.execute(aVar.a(), commandList);
        if (execute == null) {
            return false;
        }
        for (ResponseList.Response next3 : execute.getList()) {
            list2.add(TsmRpcModels.SeAPDUResponseItem.newBuilder().setIndex(i).setResponseData(ByteString.copyFrom(next3.getData())).setResponseSw(ByteString.copyFrom(next3.getStatus())).build());
            i++;
        }
        return execute.isSuccess();
    }

    public BaseResponse b(Context context, CardInfo cardInfo, Bundle bundle) {
        LogUtils.d("transferIn called.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extras_key_se_operation", 12);
        bundle.putSerializable("extras_key_business_type", h.a.TRANSFER_IN);
        return a(context, cardInfo, bundle);
    }

    public BaseResponse b(Context context, String str) {
        int i;
        String str2 = "";
        try {
            i = "SUCCESS".equals(this.f3875a.communityDummyCardDelete(context, str)) ? 0 : -2;
        } catch (AuthApiException e) {
            LogUtils.d("communityDummyCardDelete failed ".concat(String.valueOf(e)));
            int i2 = e.mErrorCode;
            str2 = e.mErrorMsg;
            i = i2;
        }
        return new BaseResponse(i, str2, new Object[0]);
    }

    public BaseResponse c(Context context, CardInfo cardInfo, Bundle bundle) {
        LogUtils.d("transferOut called.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extras_key_se_operation", 11);
        bundle.putSerializable("extras_key_business_type", h.a.TRANSFER_OUT);
        return e(context, cardInfo, bundle);
    }

    public BaseResponse d(Context context, CardInfo cardInfo, Bundle bundle) {
        h.a aVar;
        LogUtils.d("returnCard called.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.getBoolean("extras_key_internal_return", false)) {
            bundle.putInt("extras_key_se_operation", 24);
            aVar = h.a.INTERNAL_RETURN;
        } else {
            bundle.putInt("extras_key_se_operation", 23);
            aVar = h.a.OUT_RETURN;
        }
        bundle.putSerializable("extras_key_business_type", aVar);
        return e(context, cardInfo, bundle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, boolean):com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo
     arg types: [android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, int]
     candidates:
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.tsmclient.smartcard.terminal.IScTerminal, com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo, com.miui.tsmclient.seitsm.TsmRpcModels$TsmAPDUCommand):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.d.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, com.miui.tsmclient.model.e.h$a, boolean):com.miui.tsmclient.seitsm.TsmRpcModels$TsmSessionInfo */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0241, code lost:
        com.miui.tsmclient.model.e.h.a().a(r8, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0251, code lost:
        r9.setObjectName(r8.mCardType);
        r9.setCoreOperation("delete");
        com.miui.tsmclient.model.p.a(r20).a(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0106, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0107, code lost:
        r2 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010e, code lost:
        r2 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x011a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011b, code lost:
        r2 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0127, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0128, code lost:
        r2 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012f, code lost:
        r9 = r4;
        r1 = r6;
        r2 = " *******";
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0136, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0137, code lost:
        r9 = r4;
        r1 = r6;
        r2 = " *******";
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r9.setExtra(r0.getMessage());
        com.miui.tsmclient.util.LogUtils.e("delete is interrupted.", r0);
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0152, code lost:
        if (r1.getBoolean("extras_key_session_not_finish") == false) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0154, code lost:
        com.miui.tsmclient.model.e.h.a().a(r8, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x015b, code lost:
        r3 = 11;
        r9.setErrorCode(11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0164, code lost:
        if (r9.needUpload() != false) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0166, code lost:
        r9.setObjectName(r8.mCardType);
        r9.setCoreOperation("delete");
        com.miui.tsmclient.model.p.a(r20).a(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0175, code lost:
        r0 = new java.lang.StringBuilder("******* delete time:");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x017c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x017d, code lost:
        r3 = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0181, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0182, code lost:
        r9 = r4;
        r1 = r6;
        r2 = " *******";
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x018f, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0191, code lost:
        r3 = r0.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01a7, code lost:
        com.miui.tsmclient.model.e.h.a().a(r8, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01b7, code lost:
        r9.setObjectName(r8.mCardType);
        r9.setCoreOperation("delete");
        com.miui.tsmclient.model.p.a(r20).a(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01e0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01e1, code lost:
        r9 = r4;
        r1 = r6;
        r2 = " *******";
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r9.setExtra(r0.getMessage());
        com.miui.tsmclient.util.LogUtils.e("delete failed with an io exception.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01f5, code lost:
        if (r1.getBoolean("extras_key_session_not_finish") == false) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01f7, code lost:
        com.miui.tsmclient.model.e.h.a().a(r8, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01fe, code lost:
        r3 = 2;
        r9.setErrorCode(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0206, code lost:
        if (r9.needUpload() != false) goto L_0x0208;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0208, code lost:
        r9.setObjectName(r8.mCardType);
        r9.setCoreOperation("delete");
        com.miui.tsmclient.model.p.a(r20).a(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0217, code lost:
        r0 = new java.lang.StringBuilder("******* delete time:");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x021c, code lost:
        r0.append(java.lang.System.currentTimeMillis() - r14);
        r0.append(r2);
        com.miui.tsmclient.util.LogUtils.d(r0.toString());
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0239, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x023a, code lost:
        r3 = 2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011a A[ExcHandler: InterruptedException (e java.lang.InterruptedException), Splitter:B:21:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0127 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:21:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0136 A[ExcHandler: InterruptedException (e java.lang.InterruptedException), Splitter:B:8:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x018f A[Catch:{ all -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0191 A[Catch:{ all -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01e0 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:8:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0208  */
    public BaseResponse e(Context context, CardInfo cardInfo, Bundle bundle) {
        h.a aVar;
        UserExceptionLogInfo userExceptionLogInfo;
        int i;
        String str;
        Bundle bundle2;
        int i2;
        String str2;
        Bundle bundle3;
        Bundle bundle4;
        Context context2 = context;
        CardInfo cardInfo2 = cardInfo;
        LogUtils.d("Delete aid is : " + cardInfo2.mAid);
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle5 = bundle == null ? new Bundle() : bundle;
        h.a aVar2 = (h.a) bundle5.getSerializable("extras_key_business_type");
        if (aVar2 == null) {
            aVar2 = h.a.DELETE;
        }
        h.a aVar3 = aVar2;
        UserExceptionLogInfo userExceptionLogInfo2 = new UserExceptionLogInfo();
        TsmRpcModels.SeOperationType valueOf = TsmRpcModels.SeOperationType.valueOf(bundle5.getInt("extras_key_se_operation", 4));
        LogUtils.d("delete called. SeOperationType: ".concat(String.valueOf(valueOf)));
        String str3 = "";
        try {
            TsmRpcModels.TsmSessionInfo a2 = a(context2, cardInfo2, aVar3, true);
            userExceptionLogInfo2.setSessionId(a2 != null ? a2.getSessionId() : str3);
            userExceptionLogInfo = userExceptionLogInfo2;
            TsmRpcModels.TsmSessionInfo tsmSessionInfo = a2;
            String str4 = " *******";
            aVar = aVar3;
            Bundle bundle6 = bundle5;
            try {
                BaseResponse a3 = a(context, cardInfo, tsmSessionInfo, valueOf, bundle5);
                if (a3.isSuccess()) {
                    com.miui.tsmclient.util.a.a(context, cardInfo);
                    Intent intent = new Intent("com.miui.tsmclient.action.QUERY_CARDS");
                    intent.setPackage("com.miui.tsmclient");
                    intent.putExtra("card_type", cardInfo2.mCardType);
                    ServiceUtils.startService(context2, intent);
                    bundle4 = bundle6;
                    i = 0;
                } else {
                    i = a3.mResultCode;
                    userExceptionLogInfo.setErrorDesc(a3.mMsg);
                    userExceptionLogInfo.setErrorCode(i);
                    bundle4 = bundle6;
                }
                if (!bundle4.getBoolean("extras_key_session_not_finish")) {
                    h.a().a(cardInfo2, aVar);
                }
                userExceptionLogInfo.setErrorCode(i);
                if (userExceptionLogInfo.needUpload()) {
                    userExceptionLogInfo.setObjectName(cardInfo2.mCardType);
                    userExceptionLogInfo.setCoreOperation("delete");
                    p.a(context).a(userExceptionLogInfo);
                }
                LogUtils.d("******* delete time:" + (System.currentTimeMillis() - currentTimeMillis) + str4);
                return a3;
            } catch (IOException e) {
            } catch (com.miui.tsmclient.seitsm.a.a e2) {
                e = e2;
                str2 = str4;
                bundle3 = bundle6;
                i = 0;
                try {
                    if (e.a() != 10021) {
                    }
                    String str5 = e.getMessage();
                    userExceptionLogInfo.setExtra(str5);
                    LogUtils.e("delete failed with an tsmapi exception.", e);
                    if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                    }
                    userExceptionLogInfo.setErrorCode(i2);
                    if (userExceptionLogInfo.needUpload()) {
                    }
                    LogUtils.d("******* delete time:" + (System.currentTimeMillis() - currentTimeMillis) + str);
                    return new BaseResponse(i2, str5, new Object[0]);
                } catch (Throwable th) {
                    th = th;
                    if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                    }
                    userExceptionLogInfo.setErrorCode(i);
                    if (userExceptionLogInfo.needUpload()) {
                    }
                    LogUtils.d("******* delete time:" + (System.currentTimeMillis() - currentTimeMillis) + str);
                    throw th;
                }
            } catch (InterruptedException e3) {
            } catch (Throwable th2) {
                th = th2;
                str = str4;
                bundle2 = bundle6;
                i = 0;
                if (!bundle2.getBoolean("extras_key_session_not_finish")) {
                }
                userExceptionLogInfo.setErrorCode(i);
                if (userExceptionLogInfo.needUpload()) {
                }
                LogUtils.d("******* delete time:" + (System.currentTimeMillis() - currentTimeMillis) + str);
                throw th;
            }
        } catch (IOException e4) {
        } catch (com.miui.tsmclient.seitsm.a.a e5) {
            e = e5;
            userExceptionLogInfo = userExceptionLogInfo2;
            bundle3 = bundle5;
            str2 = " *******";
            i = 0;
            aVar = aVar3;
            if (e.a() != 10021) {
            }
            String str52 = e.getMessage();
            userExceptionLogInfo.setExtra(str52);
            LogUtils.e("delete failed with an tsmapi exception.", e);
            if (!bundle2.getBoolean("extras_key_session_not_finish")) {
            }
            userExceptionLogInfo.setErrorCode(i2);
            if (userExceptionLogInfo.needUpload()) {
            }
            LogUtils.d("******* delete time:" + (System.currentTimeMillis() - currentTimeMillis) + str);
            return new BaseResponse(i2, str52, new Object[0]);
        } catch (InterruptedException e6) {
        } catch (Throwable th3) {
            th = th3;
            userExceptionLogInfo = userExceptionLogInfo2;
            bundle2 = bundle5;
            str = " *******";
            i = 0;
            aVar = aVar3;
            if (!bundle2.getBoolean("extras_key_session_not_finish")) {
            }
            userExceptionLogInfo.setErrorCode(i);
            if (userExceptionLogInfo.needUpload()) {
            }
            LogUtils.d("******* delete time:" + (System.currentTimeMillis() - currentTimeMillis) + str);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r14.setExtra(r2.getMessage());
        com.miui.tsmclient.util.LogUtils.e("preTransferOut is interrupted.", r2);
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        r14.setErrorCode(11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        if (r14.needUpload() != false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        r14.setObjectName(r13.mCardType);
        r14.setCoreOperation("preTransferOut");
        com.miui.tsmclient.model.p.a(r12).a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0096, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b5, code lost:
        r14.setObjectName(r13.mCardType);
        r14.setCoreOperation("preTransferOut");
        com.miui.tsmclient.model.p.a(r12).a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c8, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r14.setExtra(r2.getMessage());
        com.miui.tsmclient.util.LogUtils.e("preTransferOut failed with an io exception.", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d5, code lost:
        r14.setErrorCode(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dc, code lost:
        if (r14.needUpload() != false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00de, code lost:
        r14.setObjectName(r13.mCardType);
        r14.setCoreOperation("preTransferOut");
        com.miui.tsmclient.model.p.a(r12).a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ed, code lost:
        r8 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0101, code lost:
        r14.setObjectName(r13.mCardType);
        r14.setCoreOperation("preTransferOut");
        com.miui.tsmclient.model.p.a(r12).a(r14);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069 A[ExcHandler: InterruptedException (r2v6 'e' java.lang.InterruptedException A[CUSTOM_DECLARE]), Splitter:B:4:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c8 A[ExcHandler: IOException (r2v3 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:4:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0101  */
    public BaseResponse f(Context context, CardInfo cardInfo, Bundle bundle) {
        int i;
        String str = "";
        LogUtils.d("preTransferOut called.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        UserExceptionLogInfo userExceptionLogInfo = new UserExceptionLogInfo();
        int i2 = 11;
        try {
            TsmRpcModels.TsmSessionInfo a2 = a(context, cardInfo, (h.a) null);
            userExceptionLogInfo.setSessionId(a2 != null ? a2.getSessionId() : str);
            BaseResponse a3 = a(context, cardInfo, a2, TsmRpcModels.SeOperationType.CHECK_SHIFT_OUT, bundle2);
            if (!a3.isSuccess()) {
                i = a3.mResultCode;
                userExceptionLogInfo.setErrorDesc(a3.mMsg);
                userExceptionLogInfo.setErrorCode(i);
            } else {
                i = 0;
            }
            userExceptionLogInfo.setErrorCode(i);
            if (userExceptionLogInfo.needUpload()) {
                userExceptionLogInfo.setObjectName(cardInfo.mCardType);
                userExceptionLogInfo.setCoreOperation("preTransferOut");
                p.a(context).a(userExceptionLogInfo);
            }
            return a3;
        } catch (IOException e) {
        } catch (com.miui.tsmclient.seitsm.a.a e2) {
            e = e2;
            i2 = i;
            i2 = e.a();
            String message = e.getMessage();
            userExceptionLogInfo.setExtra(e.getMessage());
            LogUtils.e("preTransferOut failed with an SeiTSMApiException.", e);
            userExceptionLogInfo.setErrorCode(i2);
            if (userExceptionLogInfo.needUpload()) {
            }
            str = message;
        } catch (InterruptedException e3) {
        } catch (Throwable th) {
            th = th;
            i2 = 2;
            userExceptionLogInfo.setErrorCode(i2);
            if (userExceptionLogInfo.needUpload()) {
            }
            throw th;
        }
        return new BaseResponse(i2, str, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public BaseResponse g(Context context, CardInfo cardInfo, Bundle bundle) {
        return this.f3875a.uploadTransferOutResult(context, cardInfo, bundle);
    }
}
