package com.miui.tsmclient.model;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.entity.UserExceptionLogInfo;
import com.miui.tsmclient.model.e.d;
import com.miui.tsmclient.model.e.f;
import com.miui.tsmclient.model.e.g;
import com.miui.tsmclient.model.e.h;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.exception.NfcEeIOException;
import com.tsmclient.smartcard.terminal.IScTerminal;
import java.io.IOException;

public class a extends k {
    private int e;

    public a(d dVar) {
        super(dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x014c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x014d, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x014e, code lost:
        r4 = 3007;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x017e, code lost:
        if (3007 == r15) goto L_0x0189;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0180, code lost:
        r8.e = 0;
        com.miui.tsmclient.model.e.h.a().a(r10, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0189, code lost:
        if (r1 == null) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x018b, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x018e, code lost:
        r14.setErrorCode(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0195, code lost:
        if (r14.needUpload() == false) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0197, code lost:
        r14.setObjectName(r10.mCardType);
        r14.setCoreOperation("pullBusCardTopUpData");
        com.miui.tsmclient.model.p.a(r22).a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01a6, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01af, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01b2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01f4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01f8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x01fd, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x01fe, code lost:
        r3 = 0;
        r4 = 3007;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0204, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0205, code lost:
        r3 = 0;
        r4 = 3007;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x020a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x020b, code lost:
        r3 = 0;
        r4 = 3007;
        r9 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0213, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0214, code lost:
        r3 = 0;
        r4 = 3007;
        r15 = -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x021a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x021b, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x023c, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0248, code lost:
        if (r14.needUpload() != false) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x024a, code lost:
        r14.setObjectName(r10.mCardType);
        r14.setCoreOperation("pullBusCardTopUpData");
        com.miui.tsmclient.model.p.a(r22).a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0260, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0261, code lost:
        r3 = 0;
        r4 = 3007;
        r15 = -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0277, code lost:
        r8.e = r3;
        com.miui.tsmclient.model.e.h.a().a(r10, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0282, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x028c, code lost:
        if (r14.needUpload() != false) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x028f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0290, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x02aa, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x02b7, code lost:
        r14.setObjectName(r10.mCardType);
        r14.setCoreOperation("pullBusCardTopUpData");
        com.miui.tsmclient.model.p.a(r22).a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x02cc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x02cd, code lost:
        r3 = 0;
        r4 = 3007;
        r9 = 10;
        r15 = -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x02fa, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0306, code lost:
        r14.setObjectName(r10.mCardType);
        r14.setCoreOperation("pullBusCardTopUpData");
        com.miui.tsmclient.model.p.a(r22).a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0326, code lost:
        r8.e = r3;
        com.miui.tsmclient.model.e.h.a().a(r10, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0331, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x033d, code lost:
        r14.setObjectName(r10.mCardType);
        r14.setCoreOperation("pullBusCardTopUpData");
        com.miui.tsmclient.model.p.a(r22).a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ed, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ee, code lost:
        if (r1 != null) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f0, code lost:
        r0 = -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r0 = r1.mResultCode;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f6, code lost:
        if (3007 == r0) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00f8, code lost:
        r8.e = 0;
        com.miui.tsmclient.model.e.h.a().a(r10, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0101, code lost:
        if (r18 == null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0103, code lost:
        r18.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0106, code lost:
        r14.setErrorCode(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x010d, code lost:
        if (r14.needUpload() == false) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x010f, code lost:
        r14.setObjectName(r10.mCardType);
        r14.setCoreOperation("pullBusCardTopUpData");
        com.miui.tsmclient.model.p.a(r22).a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x011e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x011f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0121, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0123, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0125, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0127, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0129, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x012b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x012d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x012e, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x012f, code lost:
        r4 = 3007;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x013b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x013c, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x013d, code lost:
        r4 = 3007;
        r1 = r18;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0076 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x014c A[ExcHandler: IOException (e java.io.IOException), Splitter:B:35:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01f4 A[ExcHandler: InterruptedException (e java.lang.InterruptedException), PHI: r1 r3 r4 10  PHI: (r1v20 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v21 com.tsmclient.smartcard.terminal.IScTerminal), (r1v21 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:131:0x01ba, B:132:?, B:125:0x01a7, B:126:?, B:111:0x0167] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r3v25 int) = (r3v26 int), (r3v26 int), (r3v32 int), (r3v32 int), (r3v33 int) binds: [B:131:0x01ba, B:132:?, B:125:0x01a7, B:126:?, B:111:0x0167] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r4v21 int) = (r4v22 int), (r4v22 int), (r4v26 int), (r4v26 int), (r4v27 int) binds: [B:131:0x01ba, B:132:?, B:125:0x01a7, B:126:?, B:111:0x0167] A[DONT_GENERATE, DONT_INLINE], Splitter:B:125:0x01a7] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01f8 A[ExcHandler: IOException (e java.io.IOException), PHI: r1 r3 r4 10  PHI: (r1v19 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v21 com.tsmclient.smartcard.terminal.IScTerminal), (r1v21 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:131:0x01ba, B:132:?, B:125:0x01a7, B:126:?, B:111:0x0167] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r3v24 int) = (r3v26 int), (r3v26 int), (r3v32 int), (r3v32 int), (r3v33 int) binds: [B:131:0x01ba, B:132:?, B:125:0x01a7, B:126:?, B:111:0x0167] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r4v20 int) = (r4v22 int), (r4v22 int), (r4v26 int), (r4v26 int), (r4v27 int) binds: [B:131:0x01ba, B:132:?, B:125:0x01a7, B:126:?, B:111:0x0167] A[DONT_GENERATE, DONT_INLINE], Splitter:B:111:0x0167] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x021a A[ExcHandler: InterruptedException (e java.lang.InterruptedException), PHI: r1 10  PHI: (r1v14 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v0 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:1:0x001b, B:8:0x002b, B:25:0x0076] A[DONT_GENERATE, DONT_INLINE], Splitter:B:25:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x028f A[ExcHandler: IOException (e java.io.IOException), PHI: r1 10  PHI: (r1v10 com.tsmclient.smartcard.terminal.IScTerminal) = (r1v0 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal), (r1v15 com.tsmclient.smartcard.terminal.IScTerminal) binds: [B:1:0x001b, B:8:0x002b, B:14:0x0054, B:25:0x0076, B:15:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0326  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x033d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013b A[ExcHandler: InterruptedException (e java.lang.InterruptedException), Splitter:B:35:0x009b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:198:0x02d3=Splitter:B:198:0x02d3, B:174:0x0265=Splitter:B:174:0x0265} */
    private BaseResponse a(Context context, CardInfo cardInfo, g gVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int a2;
        Context context2 = context;
        CardInfo cardInfo2 = cardInfo;
        String str = "";
        h.a a3 = gVar.a();
        UserExceptionLogInfo userExceptionLogInfo = new UserExceptionLogInfo();
        int i6 = 3007;
        IScTerminal iScTerminal = null;
        try {
            TsmRpcModels.TsmSessionInfo a4 = a(context2, cardInfo2, a3);
            userExceptionLogInfo.setSessionId(a4 != null ? a4.getSessionId() : str);
            int i7 = -2;
            while (true) {
                LogUtils.d("pullBusCardTopUpData, retryCount:" + this.e);
                TsmRpcModels.TsmAPDUCommand a5 = this.c.a(context2, a4, gVar);
                if (a5 != null) {
                    a2 = f.a(a5.getResult());
                    if (i6 == a2) {
                        Thread.sleep(2000);
                        i = a2;
                        i3 = 0;
                        i5 = 3007;
                        i4 = 10;
                    } else if (a2 != 0 || a5.getApdusList() == null || a5.getApdusList().isEmpty()) {
                        i = a2;
                        i3 = 0;
                        i5 = 3007;
                        i4 = 10;
                        if (i == 0) {
                            try {
                                if (a5.getApdusList() == null || a5.getApdusList().isEmpty()) {
                                    BaseResponse baseResponse = new BaseResponse(0, new Object[0]);
                                }
                            } catch (NfcEeIOException e2) {
                                e = e2;
                                i = i7;
                                LogUtils.e("pullBusCardTopUpData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                                try {
                                    userExceptionLogInfo.setExtra(e.getMessage());
                                    this.e = i3;
                                    h.a().a(cardInfo2, a3);
                                    if (iScTerminal != null) {
                                    }
                                    userExceptionLogInfo.setErrorCode(i4);
                                    if (userExceptionLogInfo.needUpload()) {
                                    }
                                    i = 10;
                                    return new BaseResponse(i, str, new Object[i3]);
                                } catch (Throwable th) {
                                    th = th;
                                    i = 10;
                                    if (i2 != i) {
                                    }
                                    if (iScTerminal != null) {
                                    }
                                    userExceptionLogInfo.setErrorCode(i);
                                    if (userExceptionLogInfo.needUpload()) {
                                    }
                                    throw th;
                                }
                            } catch (IOException e3) {
                            } catch (com.miui.tsmclient.seitsm.a.a e4) {
                                e = e4;
                                i = i7;
                                try {
                                    i = e.a();
                                    str = e.getMessage();
                                    userExceptionLogInfo.setExtra(str);
                                    LogUtils.e("pullBusCardTopUpData failed with an tsmapi exception.", e);
                                    if (i2 != i) {
                                    }
                                    if (iScTerminal != null) {
                                    }
                                    userExceptionLogInfo.setErrorCode(i);
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (i2 != i) {
                                    }
                                    if (iScTerminal != null) {
                                    }
                                    userExceptionLogInfo.setErrorCode(i);
                                    if (userExceptionLogInfo.needUpload()) {
                                    }
                                    throw th;
                                }
                            } catch (InterruptedException e5) {
                            } catch (Throwable th3) {
                                th = th3;
                                i = i7;
                                if (i2 != i) {
                                }
                                if (iScTerminal != null) {
                                }
                                userExceptionLogInfo.setErrorCode(i);
                                if (userExceptionLogInfo.needUpload()) {
                                }
                                throw th;
                            }
                        }
                    } else {
                        if (iScTerminal == null) {
                            iScTerminal = cardInfo.getTerminal();
                            iScTerminal.open();
                        }
                        IScTerminal iScTerminal2 = iScTerminal;
                        try {
                            i = a2;
                            i4 = 10;
                            BaseResponse a6 = a(context, iScTerminal2, a4, a5, gVar.b(), false);
                            if (a6 == null) {
                                break;
                            }
                            try {
                                if (a6.mResultCode != 0) {
                                    break;
                                }
                                i3 = 0;
                                try {
                                    this.e = 0;
                                    i7 = i;
                                    iScTerminal = iScTerminal2;
                                    i5 = 3007;
                                } catch (NfcEeIOException e6) {
                                    e = e6;
                                    iScTerminal = iScTerminal2;
                                    i2 = 3007;
                                    LogUtils.e("pullBusCardTopUpData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                                    userExceptionLogInfo.setExtra(e.getMessage());
                                    this.e = i3;
                                    h.a().a(cardInfo2, a3);
                                    if (iScTerminal != null) {
                                    }
                                    userExceptionLogInfo.setErrorCode(i4);
                                    if (userExceptionLogInfo.needUpload()) {
                                    }
                                    i = 10;
                                    return new BaseResponse(i, str, new Object[i3]);
                                } catch (IOException e7) {
                                    e = e7;
                                    iScTerminal = iScTerminal2;
                                    i5 = 3007;
                                    try {
                                        userExceptionLogInfo.setExtra(e.getMessage());
                                        LogUtils.e("pullBusCardTopUpData failed with an io exception.", e);
                                        this.e = i3;
                                        h.a().a(cardInfo2, a3);
                                        if (iScTerminal != null) {
                                        }
                                        userExceptionLogInfo.setErrorCode(2);
                                        if (userExceptionLogInfo.needUpload()) {
                                        }
                                        i = 2;
                                        return new BaseResponse(i, str, new Object[i3]);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        i = 2;
                                        if (i2 != i) {
                                        }
                                        if (iScTerminal != null) {
                                        }
                                        userExceptionLogInfo.setErrorCode(i);
                                        if (userExceptionLogInfo.needUpload()) {
                                        }
                                        throw th;
                                    }
                                } catch (com.miui.tsmclient.seitsm.a.a e8) {
                                    e = e8;
                                    iScTerminal = iScTerminal2;
                                    i5 = 3007;
                                    i = e.a();
                                    str = e.getMessage();
                                    userExceptionLogInfo.setExtra(str);
                                    LogUtils.e("pullBusCardTopUpData failed with an tsmapi exception.", e);
                                    if (i2 != i) {
                                    }
                                    if (iScTerminal != null) {
                                    }
                                    userExceptionLogInfo.setErrorCode(i);
                                } catch (InterruptedException e9) {
                                    e = e9;
                                    iScTerminal = iScTerminal2;
                                    i5 = 3007;
                                    try {
                                        userExceptionLogInfo.setExtra(e.getMessage());
                                        LogUtils.e("pullBusCardTopUpData is interrupted.", e);
                                        Thread.currentThread().interrupt();
                                        this.e = i3;
                                        h.a().a(cardInfo2, a3);
                                        if (iScTerminal != null) {
                                        }
                                        i = 11;
                                        userExceptionLogInfo.setErrorCode(11);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        i = 11;
                                        if (i2 != i) {
                                        }
                                        if (iScTerminal != null) {
                                        }
                                        userExceptionLogInfo.setErrorCode(i);
                                        if (userExceptionLogInfo.needUpload()) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    iScTerminal = iScTerminal2;
                                    i2 = 3007;
                                    if (i2 != i) {
                                    }
                                    if (iScTerminal != null) {
                                    }
                                    userExceptionLogInfo.setErrorCode(i);
                                    if (userExceptionLogInfo.needUpload()) {
                                    }
                                    throw th;
                                }
                            } catch (NfcEeIOException e10) {
                                e = e10;
                                i3 = 0;
                                iScTerminal = iScTerminal2;
                                i2 = 3007;
                                LogUtils.e("pullBusCardTopUpData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                                userExceptionLogInfo.setExtra(e.getMessage());
                                this.e = i3;
                                h.a().a(cardInfo2, a3);
                                if (iScTerminal != null) {
                                }
                                userExceptionLogInfo.setErrorCode(i4);
                                if (userExceptionLogInfo.needUpload()) {
                                }
                                i = 10;
                                return new BaseResponse(i, str, new Object[i3]);
                            } catch (IOException e11) {
                                e = e11;
                                i3 = 0;
                                iScTerminal = iScTerminal2;
                                i5 = 3007;
                                userExceptionLogInfo.setExtra(e.getMessage());
                                LogUtils.e("pullBusCardTopUpData failed with an io exception.", e);
                                this.e = i3;
                                h.a().a(cardInfo2, a3);
                                if (iScTerminal != null) {
                                }
                                userExceptionLogInfo.setErrorCode(2);
                                if (userExceptionLogInfo.needUpload()) {
                                }
                                i = 2;
                                return new BaseResponse(i, str, new Object[i3]);
                            } catch (com.miui.tsmclient.seitsm.a.a e12) {
                                e = e12;
                                i3 = 0;
                                iScTerminal = iScTerminal2;
                                i5 = 3007;
                                i = e.a();
                                str = e.getMessage();
                                userExceptionLogInfo.setExtra(str);
                                LogUtils.e("pullBusCardTopUpData failed with an tsmapi exception.", e);
                                if (i2 != i) {
                                }
                                if (iScTerminal != null) {
                                }
                                userExceptionLogInfo.setErrorCode(i);
                            } catch (InterruptedException e13) {
                                e = e13;
                                i3 = 0;
                                iScTerminal = iScTerminal2;
                                i5 = 3007;
                                userExceptionLogInfo.setExtra(e.getMessage());
                                LogUtils.e("pullBusCardTopUpData is interrupted.", e);
                                Thread.currentThread().interrupt();
                                this.e = i3;
                                h.a().a(cardInfo2, a3);
                                if (iScTerminal != null) {
                                }
                                i = 11;
                                userExceptionLogInfo.setErrorCode(11);
                            } catch (Throwable th7) {
                                th = th7;
                                i3 = 0;
                                iScTerminal = iScTerminal2;
                                i2 = 3007;
                                if (i2 != i) {
                                }
                                if (iScTerminal != null) {
                                }
                                userExceptionLogInfo.setErrorCode(i);
                                if (userExceptionLogInfo.needUpload()) {
                                }
                                throw th;
                            }
                        } catch (NfcEeIOException e14) {
                            e = e14;
                            i = a2;
                            i3 = 0;
                            i2 = 3007;
                            i4 = 10;
                            iScTerminal = iScTerminal2;
                            LogUtils.e("pullBusCardTopUpData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
                            userExceptionLogInfo.setExtra(e.getMessage());
                            this.e = i3;
                            h.a().a(cardInfo2, a3);
                            if (iScTerminal != null) {
                            }
                            userExceptionLogInfo.setErrorCode(i4);
                            if (userExceptionLogInfo.needUpload()) {
                            }
                            i = 10;
                            return new BaseResponse(i, str, new Object[i3]);
                        } catch (IOException e15) {
                        } catch (com.miui.tsmclient.seitsm.a.a e16) {
                            e = e16;
                            i = a2;
                            i3 = 0;
                            i5 = 3007;
                            iScTerminal = iScTerminal2;
                            i = e.a();
                            str = e.getMessage();
                            userExceptionLogInfo.setExtra(str);
                            LogUtils.e("pullBusCardTopUpData failed with an tsmapi exception.", e);
                            if (i2 != i) {
                            }
                            if (iScTerminal != null) {
                            }
                            userExceptionLogInfo.setErrorCode(i);
                        } catch (InterruptedException e17) {
                        } catch (Throwable th8) {
                            th = th8;
                            i = a2;
                            i3 = 0;
                            i2 = 3007;
                            iScTerminal = iScTerminal2;
                            if (i2 != i) {
                            }
                            if (iScTerminal != null) {
                            }
                            userExceptionLogInfo.setErrorCode(i);
                            if (userExceptionLogInfo.needUpload()) {
                            }
                            throw th;
                        }
                    }
                    this.e++;
                    i7 = i;
                } else {
                    i3 = 0;
                    i5 = 3007;
                    i4 = 10;
                }
                if (this.e >= i4) {
                    if (i5 != i7) {
                        this.e = i3;
                        h.a().a(cardInfo2, a3);
                    }
                    if (iScTerminal != null) {
                        iScTerminal.close();
                    }
                    userExceptionLogInfo.setErrorCode(i7);
                    if (userExceptionLogInfo.needUpload()) {
                        userExceptionLogInfo.setObjectName(cardInfo2.mCardType);
                        userExceptionLogInfo.setCoreOperation("pullBusCardTopUpData");
                        p.a(context).a(userExceptionLogInfo);
                    }
                    i = i7;
                } else {
                    context2 = context;
                    i6 = 3007;
                }
            }
        } catch (NfcEeIOException e18) {
            e = e18;
            i = a2;
            i3 = 0;
            i2 = 3007;
            i4 = 10;
            LogUtils.e("pullBusCardTopUpData failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
            userExceptionLogInfo.setExtra(e.getMessage());
            this.e = i3;
            h.a().a(cardInfo2, a3);
            if (iScTerminal != null) {
            }
            userExceptionLogInfo.setErrorCode(i4);
            if (userExceptionLogInfo.needUpload()) {
            }
            i = 10;
            return new BaseResponse(i, str, new Object[i3]);
        } catch (IOException e19) {
        } catch (com.miui.tsmclient.seitsm.a.a e20) {
            e = e20;
            i = a2;
            i3 = 0;
            i5 = 3007;
            i = e.a();
            str = e.getMessage();
            userExceptionLogInfo.setExtra(str);
            LogUtils.e("pullBusCardTopUpData failed with an tsmapi exception.", e);
            if (i2 != i) {
            }
            if (iScTerminal != null) {
            }
            userExceptionLogInfo.setErrorCode(i);
        } catch (InterruptedException e21) {
        } catch (Throwable th9) {
            th = th9;
            i = a2;
            i3 = 0;
            i2 = 3007;
            if (i2 != i) {
            }
            if (iScTerminal != null) {
            }
            userExceptionLogInfo.setErrorCode(i);
            if (userExceptionLogInfo.needUpload()) {
            }
            throw th;
        }
        return new BaseResponse(i, str, new Object[i3]);
    }

    /* access modifiers changed from: protected */
    public BaseResponse a(Context context, PayableCardInfo payableCardInfo, OrderInfo orderInfo, Tag tag, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        g gVar = bundle2.getBoolean("out_operation") ? g.OUT_RECHARGE : g.RECHARGE;
        bundle2.putBoolean("extras_key_session_not_finish", true);
        BaseResponse baseResponse = null;
        int i = this.e;
        if (i == 0) {
            baseResponse = super.a(context, payableCardInfo, orderInfo, tag, bundle2);
        } else if (i == 10) {
            this.e = 0;
        }
        if (baseResponse == null || baseResponse.mResultCode == 0) {
            return a(context, payableCardInfo, gVar);
        }
        h.a().a(payableCardInfo, gVar.a());
        return baseResponse;
    }
}
