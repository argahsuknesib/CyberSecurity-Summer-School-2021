package com.miui.tsmclient.model.e;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.UserExceptionLogInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.e.h;
import com.miui.tsmclient.model.p;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.seitsm.a.a;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.exception.NfcEeIOException;
import com.tsmclient.smartcard.terminal.IScTerminal;
import java.io.IOException;

public class b extends c {
    private int e;

    public b(d dVar) {
        super(dVar);
    }

    private Bundle a(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("extras_key_session_not_finish", true);
        return bundle;
    }

    private void h(Context context, CardInfo cardInfo, Bundle bundle) {
        long j = bundle.getLong("version_control_id", 0);
        if (!TextUtils.isEmpty(com.miui.tsmclient.util.b.a(j))) {
            com.miui.tsmclient.util.b.a().b(context, cardInfo.mCardType, j);
        }
    }

    public BaseResponse a(Context context, CardInfo cardInfo, Bundle bundle) {
        Bundle a2 = a(bundle);
        g gVar = a2.getBoolean("out_operation") ? g.OUT_ISSUE : g.ISSUE;
        BaseResponse baseResponse = null;
        int i = this.e;
        if (i == 0) {
            baseResponse = super.a(context, cardInfo, a2);
        } else if (i == 10) {
            this.e = 0;
        }
        if (a2.getBoolean("pre_load") || !(baseResponse == null || baseResponse.mResultCode == 0)) {
            h.a().a(cardInfo, gVar.a());
            return baseResponse;
        }
        BaseResponse a3 = a(context, cardInfo, gVar);
        if (a3.isSuccess()) {
            h(context, cardInfo, a2);
        }
        return a3;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:234:0x0356 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:206:0x02db */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [com.tsmclient.smartcard.terminal.IScTerminal] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [com.tsmclient.smartcard.terminal.IScTerminal] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01a7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01a8, code lost:
        r15 = r3;
        r3 = 3007;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01ac, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01af, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01b0, code lost:
        r15 = r3;
        r3 = 3007;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01b4, code lost:
        r7 = r1;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01b8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01b9, code lost:
        r15 = r3;
        r3 = 3007;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01bd, code lost:
        r7 = r1;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        r0 = new com.miui.tsmclient.model.BaseResponse(0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01cf, code lost:
        if (3007 == r15) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01d1, code lost:
        r8.e = 0;
        com.miui.tsmclient.model.e.h.a().a(r10, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01da, code lost:
        if (r1 == null) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01dc, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01df, code lost:
        r12.setErrorCode(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01e6, code lost:
        if (r12.needUpload() == false) goto L_0x01fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x01e8, code lost:
        r12.setObjectName(r10.mCardType);
        r12.setCoreOperation(r24.c());
        com.miui.tsmclient.model.p.a(r22).a(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01fb, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0204, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0206, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0208, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x020a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x020b, code lost:
        r3 = 3007;
        r14 = 0;
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0258, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x025c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0262, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0265, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0266, code lost:
        r3 = 3007;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0269, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x026b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x026c, code lost:
        r3 = 3007;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0271, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0272, code lost:
        r3 = 3007;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0275, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0278, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0279, code lost:
        r3 = 3007;
        r5 = 10;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x02b5, code lost:
        if (r12.needUpload() != false) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x02b7, code lost:
        r12.setObjectName(r10.mCardType);
        r12.setCoreOperation(r24.c());
        com.miui.tsmclient.model.p.a(r22).a(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0302, code lost:
        if (r12.needUpload() == false) goto L_0x039e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b6, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ba, code lost:
        r7 = r1;
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00be, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bf, code lost:
        r7 = r1;
        r2 = r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00ad */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0258 A[ExcHandler: InterruptedException (e java.lang.InterruptedException), PHI: r1 r3 r14 10  PHI: (r1v31 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v32 com.tsmclient.smartcard.terminal.IScTerminal), (r1v32 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:157:0x0218, B:158:?, B:147:0x01fc, B:148:?, B:137:0x01c8, B:138:?] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r3v27 int) = (r3v28 int), (r3v28 int), (r3v37 int), (r3v37 int), (r3v41 int), (r3v41 int) binds: [B:157:0x0218, B:158:?, B:147:0x01fc, B:148:?, B:137:0x01c8, B:138:?] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r14v23 int) = (r14v24 int), (r14v24 int), (r14v31 int), (r14v31 int), (r14v35 int), (r14v35 int) binds: [B:157:0x0218, B:158:?, B:147:0x01fc, B:148:?, B:137:0x01c8, B:138:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:157:0x0218] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x025c A[ExcHandler: IOException (e java.io.IOException), PHI: r1 r3 r14 10  PHI: (r1v30 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v32 com.tsmclient.smartcard.terminal.IScTerminal), (r1v32 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:157:0x0218, B:158:?, B:147:0x01fc, B:148:?, B:137:0x01c8, B:138:?] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r3v26 int) = (r3v28 int), (r3v28 int), (r3v37 int), (r3v37 int), (r3v41 int), (r3v41 int) binds: [B:157:0x0218, B:158:?, B:147:0x01fc, B:148:?, B:137:0x01c8, B:138:?] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r14v22 int) = (r14v24 int), (r14v24 int), (r14v31 int), (r14v31 int), (r14v35 int), (r14v35 int) binds: [B:157:0x0218, B:158:?, B:147:0x01fc, B:148:?, B:137:0x01c8, B:138:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:137:0x01c8] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0262 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:21:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0265 A[ExcHandler: InterruptedException (e java.lang.InterruptedException), Splitter:B:21:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x026b A[ExcHandler: a (e com.miui.tsmclient.seitsm.a.a), Splitter:B:21:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0271 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:21:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0326  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x03c6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077 A[ExcHandler: InterruptedException (e java.lang.InterruptedException), PHI: r1 10  PHI: (r1v49 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v44 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:64:0x00d7, B:65:?, B:43:0x009d, B:44:?, B:49:0x00ad, B:50:?, B:24:0x006e] A[DONT_GENERATE, DONT_INLINE], Splitter:B:24:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e A[ExcHandler: IOException (e java.io.IOException), PHI: r1 10  PHI: (r1v48 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v44 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:64:0x00d7, B:65:?, B:43:0x009d, B:44:?, B:46:0x00a2, B:49:0x00ad, B:50:?, B:47:?, B:24:0x006e] A[DONT_GENERATE, DONT_INLINE], Splitter:B:24:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b5 A[ExcHandler: all (th java.lang.Throwable), PHI: r1 10  PHI: (r1v47 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v44 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:64:0x00d7, B:65:?, B:43:0x009d, B:44:?, B:46:0x00a2, B:49:0x00ad, B:50:?, B:47:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:43:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b9 A[ExcHandler: a (e com.miui.tsmclient.seitsm.a.a), PHI: r1 10  PHI: (r1v46 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v44 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:64:0x00d7, B:65:?, B:43:0x009d, B:44:?, B:46:0x00a2, B:49:0x00ad, B:50:?, B:47:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:43:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00be A[ExcHandler: NfcEeIOException (e com.tsmclient.smartcard.exception.NfcEeIOException), PHI: r1 10  PHI: (r1v45 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v44 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal), (r1v25 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:64:0x00d7, B:65:?, B:43:0x009d, B:44:?, B:46:0x00a2, B:49:0x00ad, B:50:?, B:47:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:43:0x009d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:234:0x0356=Splitter:B:234:0x0356, B:206:0x02db=Splitter:B:206:0x02db} */
    /* JADX WARNING: Unknown variable types count: 1 */
    public BaseResponse a(Context context, CardInfo cardInfo, g gVar) {
        int i;
        int i2;
        int i3;
        IScTerminal iScTerminal;
        int i4;
        int i5;
        IScTerminal iScTerminal2;
        IScTerminal iScTerminal3;
        String str;
        TsmRpcModels.TsmAPDUCommand tsmAPDUCommand;
        Object obj;
        IScTerminal iScTerminal4;
        int i6;
        IScTerminal iScTerminal5;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        BaseResponse a2;
        Context context2 = context;
        CardInfo cardInfo2 = cardInfo;
        String str2 = "";
        UserExceptionLogInfo userExceptionLogInfo = new UserExceptionLogInfo();
        h.a a3 = gVar.a();
        ? r7 = 0;
        int i12 = 3007;
        try {
            TsmRpcModels.TsmSessionInfo a4 = a(context2, cardInfo2, a3);
            if (a4 != null) {
                try {
                    str = a4.getSessionId();
                } catch (NfcEeIOException e2) {
                    e = e2;
                    i3 = -2;
                    i2 = 3007;
                    i5 = 10;
                    i = 0;
                    r7 = r7;
                    LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                    try {
                        userExceptionLogInfo.setExtra(e.getMessage());
                        this.e = i;
                        h.a().a(cardInfo2, a3);
                        if (r7 != 0) {
                        }
                        userExceptionLogInfo.setErrorCode(i5);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        i4 = 10;
                        return new BaseResponse(i4, str2, new Object[i]);
                    } catch (Throwable th) {
                        th = th;
                        iScTerminal = r7;
                        i3 = 10;
                        if (i2 != i3) {
                        }
                        if (iScTerminal != null) {
                        }
                        userExceptionLogInfo.setErrorCode(i3);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    i2 = 3007;
                    i = 0;
                    iScTerminal2 = r7;
                    try {
                        userExceptionLogInfo.setExtra(e.getMessage());
                        LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an io exception.", e);
                        this.e = i;
                        h.a().a(cardInfo2, a3);
                        if (iScTerminal2 != null) {
                        }
                        userExceptionLogInfo.setErrorCode(2);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        i4 = 2;
                        return new BaseResponse(i4, str2, new Object[i]);
                    } catch (Throwable th2) {
                        th = th2;
                        iScTerminal = iScTerminal2;
                        i3 = 2;
                        if (i2 != i3) {
                        }
                        if (iScTerminal != null) {
                        }
                        userExceptionLogInfo.setErrorCode(i3);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        throw th;
                    }
                } catch (a e4) {
                    e = e4;
                    i3 = -2;
                    i2 = 3007;
                    i = 0;
                    r7 = r7;
                    try {
                        i4 = e.a();
                        try {
                            str2 = e.getMessage();
                            userExceptionLogInfo.setExtra(str2);
                            LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an tsm api exception.", e);
                            if (i2 != i4) {
                            }
                            if (r7 != 0) {
                            }
                            userExceptionLogInfo.setErrorCode(i4);
                        } catch (Throwable th3) {
                            th = th3;
                            i3 = i4;
                            iScTerminal = r7;
                            if (i2 != i3) {
                            }
                            if (iScTerminal != null) {
                            }
                            userExceptionLogInfo.setErrorCode(i3);
                            if (userExceptionLogInfo.needUpload()) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r7 = r7;
                        iScTerminal = r7;
                        if (i2 != i3) {
                        }
                        if (iScTerminal != null) {
                        }
                        userExceptionLogInfo.setErrorCode(i3);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        throw th;
                    }
                } catch (InterruptedException e5) {
                    e = e5;
                    i2 = 3007;
                    i = 0;
                    iScTerminal3 = r7;
                    try {
                        userExceptionLogInfo.setExtra(e.getMessage());
                        LogUtils.e("AsyncMiTSMClient: pullPersoData is interrupted.", e);
                        this.e = i;
                        h.a().a(cardInfo2, a3);
                        if (iScTerminal3 != null) {
                        }
                        i4 = 11;
                        userExceptionLogInfo.setErrorCode(11);
                    } catch (Throwable th5) {
                        th = th5;
                        iScTerminal = iScTerminal3;
                        i3 = 11;
                        if (i2 != i3) {
                        }
                        if (iScTerminal != null) {
                        }
                        userExceptionLogInfo.setErrorCode(i3);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    iScTerminal = null;
                    i3 = -2;
                    i2 = 3007;
                    i = 0;
                    if (i2 != i3) {
                    }
                    if (iScTerminal != null) {
                    }
                    userExceptionLogInfo.setErrorCode(i3);
                    if (userExceptionLogInfo.needUpload()) {
                    }
                    throw th;
                }
            } else {
                str = str2;
            }
            userExceptionLogInfo.setSessionId(str);
            iScTerminal = null;
            i3 = -2;
            while (true) {
                try {
                    LogUtils.d("AsyncMiTSMClient: pullPersoData, retryCount: " + this.e + ", cardType: " + cardInfo2.mCardType);
                    if ("VSIM".equals(cardInfo2.mCardType)) {
                        try {
                            tsmAPDUCommand = this.c.a(context2, a4, cardInfo2, (Bundle) r7);
                        } catch (InterruptedException ) {
                            Thread.currentThread().interrupt();
                        } catch (NfcEeIOException e6) {
                        } catch (IOException e7) {
                        } catch (a e8) {
                        } catch (Throwable th7) {
                        }
                    } else {
                        tsmAPDUCommand = this.c.a(context2, a4, gVar);
                    }
                    TsmRpcModels.TsmAPDUCommand tsmAPDUCommand2 = tsmAPDUCommand;
                    if (tsmAPDUCommand2 != null) {
                        int a5 = f.a(tsmAPDUCommand2.getResult());
                        if (i12 != a5) {
                            if (a5 == 0) {
                                if (tsmAPDUCommand2.getApdusList() != null && !tsmAPDUCommand2.getApdusList().isEmpty()) {
                                    if (iScTerminal == null) {
                                        iScTerminal = cardInfo.getTerminal();
                                        iScTerminal.open();
                                    }
                                    iScTerminal5 = iScTerminal;
                                    try {
                                        i7 = a5;
                                        i = 0;
                                        TsmRpcModels.TsmAPDUCommand tsmAPDUCommand3 = tsmAPDUCommand2;
                                        obj = r7;
                                        try {
                                            a2 = a(context, iScTerminal5, a4, tsmAPDUCommand3, gVar.b(), false);
                                            if (a2 == null) {
                                                break;
                                            }
                                            try {
                                                if (a2.mResultCode != 0) {
                                                    break;
                                                }
                                                this.e = 0;
                                                i3 = i7;
                                                iScTerminal = iScTerminal5;
                                                i2 = 3007;
                                            } catch (NfcEeIOException e9) {
                                                e = e9;
                                                i3 = i7;
                                                iScTerminal4 = iScTerminal5;
                                                i2 = 3007;
                                                i5 = 10;
                                                r7 = iScTerminal4;
                                                LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                                                userExceptionLogInfo.setExtra(e.getMessage());
                                                this.e = i;
                                                h.a().a(cardInfo2, a3);
                                                if (r7 != 0) {
                                                }
                                                userExceptionLogInfo.setErrorCode(i5);
                                                if (userExceptionLogInfo.needUpload()) {
                                                }
                                                i4 = 10;
                                                return new BaseResponse(i4, str2, new Object[i]);
                                            } catch (IOException e10) {
                                                e = e10;
                                                iScTerminal2 = iScTerminal5;
                                                i2 = 3007;
                                                userExceptionLogInfo.setExtra(e.getMessage());
                                                LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an io exception.", e);
                                                this.e = i;
                                                h.a().a(cardInfo2, a3);
                                                if (iScTerminal2 != null) {
                                                }
                                                userExceptionLogInfo.setErrorCode(2);
                                                if (userExceptionLogInfo.needUpload()) {
                                                }
                                                i4 = 2;
                                                return new BaseResponse(i4, str2, new Object[i]);
                                            } catch (a e11) {
                                                e = e11;
                                                i3 = i7;
                                                r7 = iScTerminal5;
                                                i2 = 3007;
                                                i4 = e.a();
                                                str2 = e.getMessage();
                                                userExceptionLogInfo.setExtra(str2);
                                                LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an tsm api exception.", e);
                                                if (i2 != i4) {
                                                }
                                                if (r7 != 0) {
                                                }
                                                userExceptionLogInfo.setErrorCode(i4);
                                            } catch (InterruptedException e12) {
                                                e = e12;
                                                iScTerminal3 = iScTerminal5;
                                                i2 = 3007;
                                                userExceptionLogInfo.setExtra(e.getMessage());
                                                LogUtils.e("AsyncMiTSMClient: pullPersoData is interrupted.", e);
                                                this.e = i;
                                                h.a().a(cardInfo2, a3);
                                                if (iScTerminal3 != null) {
                                                }
                                                i4 = 11;
                                                userExceptionLogInfo.setErrorCode(11);
                                            } catch (Throwable th8) {
                                                th = th8;
                                                i3 = i7;
                                                iScTerminal = iScTerminal5;
                                                i2 = 3007;
                                                if (i2 != i3) {
                                                }
                                                if (iScTerminal != null) {
                                                }
                                                userExceptionLogInfo.setErrorCode(i3);
                                                if (userExceptionLogInfo.needUpload()) {
                                                }
                                                throw th;
                                            }
                                        } catch (NfcEeIOException e13) {
                                            e = e13;
                                            i8 = 3007;
                                            i3 = i7;
                                            iScTerminal4 = iScTerminal5;
                                            i5 = 10;
                                            r7 = iScTerminal4;
                                            LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                                            userExceptionLogInfo.setExtra(e.getMessage());
                                            this.e = i;
                                            h.a().a(cardInfo2, a3);
                                            if (r7 != 0) {
                                            }
                                            userExceptionLogInfo.setErrorCode(i5);
                                            if (userExceptionLogInfo.needUpload()) {
                                            }
                                            i4 = 10;
                                            return new BaseResponse(i4, str2, new Object[i]);
                                        } catch (IOException e14) {
                                            e = e14;
                                            i9 = 3007;
                                            iScTerminal2 = iScTerminal5;
                                            userExceptionLogInfo.setExtra(e.getMessage());
                                            LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an io exception.", e);
                                            this.e = i;
                                            h.a().a(cardInfo2, a3);
                                            if (iScTerminal2 != null) {
                                            }
                                            userExceptionLogInfo.setErrorCode(2);
                                            if (userExceptionLogInfo.needUpload()) {
                                            }
                                            i4 = 2;
                                            return new BaseResponse(i4, str2, new Object[i]);
                                        } catch (a e15) {
                                            e = e15;
                                            i10 = 3007;
                                            i3 = i7;
                                            r7 = iScTerminal5;
                                            i4 = e.a();
                                            str2 = e.getMessage();
                                            userExceptionLogInfo.setExtra(str2);
                                            LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an tsm api exception.", e);
                                            if (i2 != i4) {
                                            }
                                            if (r7 != 0) {
                                            }
                                            userExceptionLogInfo.setErrorCode(i4);
                                        } catch (InterruptedException e16) {
                                            e = e16;
                                            i11 = 3007;
                                            iScTerminal3 = iScTerminal5;
                                            userExceptionLogInfo.setExtra(e.getMessage());
                                            LogUtils.e("AsyncMiTSMClient: pullPersoData is interrupted.", e);
                                            this.e = i;
                                            h.a().a(cardInfo2, a3);
                                            if (iScTerminal3 != null) {
                                            }
                                            i4 = 11;
                                            userExceptionLogInfo.setErrorCode(11);
                                        } catch (Throwable th9) {
                                            th = th9;
                                            i2 = 3007;
                                            i3 = i7;
                                            iScTerminal = iScTerminal5;
                                            if (i2 != i3) {
                                            }
                                            if (iScTerminal != null) {
                                            }
                                            userExceptionLogInfo.setErrorCode(i3);
                                            if (userExceptionLogInfo.needUpload()) {
                                            }
                                            throw th;
                                        }
                                    } catch (NfcEeIOException e17) {
                                        e = e17;
                                        i7 = a5;
                                        i8 = 3007;
                                        i = 0;
                                        i3 = i7;
                                        iScTerminal4 = iScTerminal5;
                                        i5 = 10;
                                        r7 = iScTerminal4;
                                        LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                                        userExceptionLogInfo.setExtra(e.getMessage());
                                        this.e = i;
                                        h.a().a(cardInfo2, a3);
                                        if (r7 != 0) {
                                        }
                                        userExceptionLogInfo.setErrorCode(i5);
                                        if (userExceptionLogInfo.needUpload()) {
                                        }
                                        i4 = 10;
                                        return new BaseResponse(i4, str2, new Object[i]);
                                    } catch (IOException e18) {
                                        e = e18;
                                        i9 = 3007;
                                        i = 0;
                                        iScTerminal2 = iScTerminal5;
                                        userExceptionLogInfo.setExtra(e.getMessage());
                                        LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an io exception.", e);
                                        this.e = i;
                                        h.a().a(cardInfo2, a3);
                                        if (iScTerminal2 != null) {
                                        }
                                        userExceptionLogInfo.setErrorCode(2);
                                        if (userExceptionLogInfo.needUpload()) {
                                        }
                                        i4 = 2;
                                        return new BaseResponse(i4, str2, new Object[i]);
                                    } catch (a e19) {
                                        e = e19;
                                        i7 = a5;
                                        i10 = 3007;
                                        i = 0;
                                        i3 = i7;
                                        r7 = iScTerminal5;
                                        i4 = e.a();
                                        str2 = e.getMessage();
                                        userExceptionLogInfo.setExtra(str2);
                                        LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an tsm api exception.", e);
                                        if (i2 != i4) {
                                        }
                                        if (r7 != 0) {
                                        }
                                        userExceptionLogInfo.setErrorCode(i4);
                                    } catch (InterruptedException e20) {
                                        e = e20;
                                        i11 = 3007;
                                        i = 0;
                                        iScTerminal3 = iScTerminal5;
                                        userExceptionLogInfo.setExtra(e.getMessage());
                                        LogUtils.e("AsyncMiTSMClient: pullPersoData is interrupted.", e);
                                        this.e = i;
                                        h.a().a(cardInfo2, a3);
                                        if (iScTerminal3 != null) {
                                        }
                                        i4 = 11;
                                        userExceptionLogInfo.setErrorCode(11);
                                    } catch (Throwable th10) {
                                        th = th10;
                                        i7 = a5;
                                        i2 = 3007;
                                        i = 0;
                                        i3 = i7;
                                        iScTerminal = iScTerminal5;
                                        if (i2 != i3) {
                                        }
                                        if (iScTerminal != null) {
                                        }
                                        userExceptionLogInfo.setErrorCode(i3);
                                        if (userExceptionLogInfo.needUpload()) {
                                        }
                                        throw th;
                                    }
                                }
                            }
                            i6 = a5;
                            obj = r7;
                            i2 = 3007;
                            i = 0;
                            if (i6 == 0) {
                                break;
                            }
                        } else {
                            LogUtils.d("pullCardPersoData, but data not ready.");
                            Thread.sleep(2000);
                            i6 = a5;
                            obj = r7;
                            i2 = 3007;
                            i = 0;
                        }
                        this.e++;
                        i3 = i6;
                    } else {
                        obj = r7;
                        i2 = 3007;
                        i = 0;
                    }
                    try {
                        if (this.e >= 10) {
                            if (i2 != i3) {
                                this.e = i;
                                h.a().a(cardInfo2, a3);
                            }
                            if (iScTerminal != null) {
                                iScTerminal.close();
                            }
                            userExceptionLogInfo.setErrorCode(i3);
                            if (userExceptionLogInfo.needUpload()) {
                                userExceptionLogInfo.setObjectName(cardInfo2.mCardType);
                                userExceptionLogInfo.setCoreOperation(gVar.c());
                                p.a(context).a(userExceptionLogInfo);
                            }
                            i4 = i3;
                        } else {
                            r7 = obj;
                            i12 = 3007;
                        }
                    } catch (NfcEeIOException e21) {
                        e = e21;
                        i5 = 10;
                        r7 = iScTerminal;
                        LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                        userExceptionLogInfo.setExtra(e.getMessage());
                        this.e = i;
                        h.a().a(cardInfo2, a3);
                        if (r7 != 0) {
                        }
                        userExceptionLogInfo.setErrorCode(i5);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        i4 = 10;
                        return new BaseResponse(i4, str2, new Object[i]);
                    } catch (IOException e22) {
                    } catch (a e23) {
                        e = e23;
                        r7 = iScTerminal;
                        i4 = e.a();
                        str2 = e.getMessage();
                        userExceptionLogInfo.setExtra(str2);
                        LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an tsm api exception.", e);
                        if (i2 != i4) {
                        }
                        if (r7 != 0) {
                        }
                        userExceptionLogInfo.setErrorCode(i4);
                    } catch (InterruptedException e24) {
                    } catch (Throwable th11) {
                        th = th11;
                        if (i2 != i3) {
                        }
                        if (iScTerminal != null) {
                        }
                        userExceptionLogInfo.setErrorCode(i3);
                        if (userExceptionLogInfo.needUpload()) {
                        }
                        throw th;
                    }
                } catch (NfcEeIOException e25) {
                    e = e25;
                    r7 = iScTerminal;
                } catch (IOException e72) {
                } catch (a e26) {
                    e = e26;
                    r7 = iScTerminal;
                    i2 = 3007;
                    i = 0;
                    r7 = r7;
                    i4 = e.a();
                    str2 = e.getMessage();
                    userExceptionLogInfo.setExtra(str2);
                    LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an tsm api exception.", e);
                    if (i2 != i4) {
                    }
                    if (r7 != 0) {
                    }
                    userExceptionLogInfo.setErrorCode(i4);
                } catch (InterruptedException e27) {
                } catch (Throwable th12) {
                }
            }
            int i13 = a2 == null ? -2 : a2.mResultCode;
            if (3007 != i13) {
                this.e = 0;
                h.a().a(cardInfo2, a3);
            }
            if (iScTerminal5 != null) {
                iScTerminal5.close();
            }
            userExceptionLogInfo.setErrorCode(i13);
            if (userExceptionLogInfo.needUpload()) {
                userExceptionLogInfo.setObjectName(cardInfo2.mCardType);
                userExceptionLogInfo.setCoreOperation(gVar.c());
                p.a(context).a(userExceptionLogInfo);
            }
            return a2;
        } catch (NfcEeIOException e28) {
            e = e28;
            i2 = 3007;
            i5 = 10;
            i = 0;
            i3 = -2;
            LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
            userExceptionLogInfo.setExtra(e.getMessage());
            this.e = i;
            h.a().a(cardInfo2, a3);
            if (r7 != 0) {
                r7.close();
            }
            userExceptionLogInfo.setErrorCode(i5);
            if (userExceptionLogInfo.needUpload()) {
                userExceptionLogInfo.setObjectName(cardInfo2.mCardType);
                userExceptionLogInfo.setCoreOperation(gVar.c());
                p.a(context).a(userExceptionLogInfo);
            }
            i4 = 10;
            return new BaseResponse(i4, str2, new Object[i]);
        } catch (IOException e29) {
            e = e29;
            i2 = 3007;
            i = 0;
            iScTerminal2 = r7;
            userExceptionLogInfo.setExtra(e.getMessage());
            LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an io exception.", e);
            this.e = i;
            h.a().a(cardInfo2, a3);
            if (iScTerminal2 != null) {
                iScTerminal2.close();
            }
            userExceptionLogInfo.setErrorCode(2);
            if (userExceptionLogInfo.needUpload()) {
                userExceptionLogInfo.setObjectName(cardInfo2.mCardType);
                userExceptionLogInfo.setCoreOperation(gVar.c());
                p.a(context).a(userExceptionLogInfo);
            }
            i4 = 2;
            return new BaseResponse(i4, str2, new Object[i]);
        } catch (a e30) {
            e = e30;
            i2 = 3007;
            i = 0;
            i3 = -2;
            i4 = e.a();
            str2 = e.getMessage();
            userExceptionLogInfo.setExtra(str2);
            LogUtils.e("AsyncMiTSMClient: pullPersoData failed with an tsm api exception.", e);
            if (i2 != i4) {
                this.e = i;
                h.a().a(cardInfo2, a3);
            }
            if (r7 != 0) {
                r7.close();
            }
            userExceptionLogInfo.setErrorCode(i4);
        } catch (InterruptedException e31) {
            e = e31;
            i2 = 3007;
            i = 0;
            iScTerminal3 = r7;
            userExceptionLogInfo.setExtra(e.getMessage());
            LogUtils.e("AsyncMiTSMClient: pullPersoData is interrupted.", e);
            this.e = i;
            h.a().a(cardInfo2, a3);
            if (iScTerminal3 != null) {
                iScTerminal3.close();
            }
            i4 = 11;
            userExceptionLogInfo.setErrorCode(11);
        } catch (Throwable th13) {
            th = th13;
            i2 = 3007;
            i = 0;
            iScTerminal = null;
            i3 = -2;
            if (i2 != i3) {
                this.e = i;
                h.a().a(cardInfo2, a3);
            }
            if (iScTerminal != null) {
                iScTerminal.close();
            }
            userExceptionLogInfo.setErrorCode(i3);
            if (userExceptionLogInfo.needUpload()) {
                userExceptionLogInfo.setObjectName(cardInfo2.mCardType);
                userExceptionLogInfo.setCoreOperation(gVar.c());
                p.a(context).a(userExceptionLogInfo);
            }
            throw th;
        }
    }

    public BaseResponse b(Context context, CardInfo cardInfo, Bundle bundle) {
        BaseResponse baseResponse;
        LogUtils.d("AsyncMiTSMClient transferIn called.");
        Bundle a2 = a(bundle);
        int i = this.e;
        if (i == 0) {
            baseResponse = super.b(context, cardInfo, a2);
        } else {
            if (i == 10) {
                this.e = 0;
            }
            baseResponse = null;
        }
        if (baseResponse == null || baseResponse.isSuccess()) {
            BaseResponse a3 = a(context, cardInfo, g.TRANSFER_IN);
            if (a3.isSuccess()) {
                h(context, cardInfo, a2);
            }
            return a3;
        }
        h.a().a(cardInfo, h.a.TRANSFER_IN);
        return baseResponse;
    }

    public BaseResponse c(Context context, CardInfo cardInfo, Bundle bundle) {
        BaseResponse baseResponse;
        LogUtils.d("AsyncMiTSMClient transferOut called.");
        Bundle a2 = a(bundle);
        int i = this.e;
        if (i == 0) {
            baseResponse = super.c(context, cardInfo, a2);
        } else {
            if (i == 10) {
                this.e = 0;
            }
            baseResponse = null;
        }
        if (baseResponse == null || baseResponse.isSuccess()) {
            return a(context, cardInfo, g.TRANSFER_OUT);
        }
        h.a().a(cardInfo, h.a.TRANSFER_OUT);
        return baseResponse;
    }

    public BaseResponse d(Context context, CardInfo cardInfo, Bundle bundle) {
        BaseResponse baseResponse;
        LogUtils.d("AsyncMiTSMClient returnCard called.");
        Bundle a2 = a(bundle);
        g gVar = g.OUT_RETURN;
        int i = this.e;
        if (i == 0) {
            baseResponse = super.d(context, cardInfo, a2);
        } else {
            if (i == 10) {
                this.e = 0;
            }
            baseResponse = null;
        }
        if (baseResponse == null || baseResponse.isSuccess()) {
            return a(context, cardInfo, gVar);
        }
        h.a().a(cardInfo, gVar.a());
        return baseResponse;
    }
}
