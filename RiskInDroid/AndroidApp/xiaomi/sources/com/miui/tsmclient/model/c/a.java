package com.miui.tsmclient.model.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.EidCardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.e.d;
import com.miui.tsmclient.model.e.f;
import com.miui.tsmclient.model.e.h;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.exception.NfcEeIOException;
import com.tsmclient.smartcard.terminal.IScTerminal;
import java.io.IOException;
import java.util.ArrayList;

public class a extends d {
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f9, code lost:
        if (r13.getBoolean("extras_key_session_not_finish") != false) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0109, code lost:
        if (r13.getBoolean("extras_key_session_not_finish") != false) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x012a, code lost:
        if (r13.getBoolean("extras_key_session_not_finish") != false) goto L_0x012d;
     */
    public BaseResponse a(Context context, CardInfo cardInfo, Bundle bundle) {
        int i;
        IScTerminal terminal;
        EidCardInfo eidCardInfo = (EidCardInfo) cardInfo;
        h.a aVar = h.a.INSTALL;
        String str = "";
        String string = bundle != null ? bundle.getString("extra_sp_token") : str;
        try {
            TsmRpcModels.TsmSessionInfo a2 = a(context, cardInfo, aVar);
            if (d.get()) {
                BaseResponse a3 = a(context, cardInfo, a2, bundle);
                LogUtils.d("EidCardClient syncEse response:" + a3.mResultCode);
            }
            TsmRpcModels.TsmAPDUCommand a4 = this.c.a(context, a2, string);
            if (a4 == null) {
                BaseResponse baseResponse = new BaseResponse(16, new Object[0]);
                if (bundle == null || !bundle.getBoolean("extras_key_session_not_finish")) {
                    h.a().a(cardInfo, aVar);
                }
                return baseResponse;
            }
            int a5 = f.a(a4.getResult());
            if (a5 == 0) {
                if (a4.getApdusList() != null) {
                    if (!a4.getApdusList().isEmpty()) {
                        terminal = cardInfo.getTerminal();
                        terminal.open();
                        BaseResponse a6 = a(context, terminal, a2, a4);
                        if (a6 != null && a6.mResultCode == 0) {
                            a(context, eidCardInfo);
                        }
                        terminal.close();
                        if (bundle == null || !bundle.getBoolean("extras_key_session_not_finish")) {
                            h.a().a(cardInfo, aVar);
                        }
                        return a6;
                    }
                }
                a(context, eidCardInfo);
                BaseResponse baseResponse2 = new BaseResponse(0, new Object[0]);
                if (bundle == null || !bundle.getBoolean("extras_key_session_not_finish")) {
                    h.a().a(cardInfo, aVar);
                }
                return baseResponse2;
            }
            throw new com.miui.tsmclient.seitsm.a.a(a5, a4.getErrorDesc());
        } catch (NfcEeIOException e) {
            LogUtils.e("issue failed with an nfc exception. errorCode:" + e.getErrorCode(), e);
            i = 10;
            if (bundle != null) {
            }
            return new BaseResponse(i, str, new Object[0]);
        } catch (IOException e2) {
            i = 2;
            LogUtils.e("issue failed with an io exception.", e2);
            if (bundle != null) {
            }
            return new BaseResponse(i, str, new Object[0]);
        } catch (com.miui.tsmclient.seitsm.a.a e3) {
            i = e3.a();
            str = e3.getMessage();
            LogUtils.e("issue failed with an tsm api exception.", e3);
            if (bundle != null) {
            }
            return new BaseResponse(i, str, new Object[0]);
        } catch (InterruptedException e4) {
            i = 11;
            try {
                LogUtils.e("issue is interrupted.", e4);
                Thread.currentThread().interrupt();
                return new BaseResponse(i, str, new Object[0]);
            } finally {
                if (bundle == null || !bundle.getBoolean("extras_key_session_not_finish")) {
                    h.a().a(cardInfo, aVar);
                }
            }
        } catch (Throwable th) {
            terminal.close();
            throw th;
        }
    }

    public BaseResponse a(Context context, EidCardInfo eidCardInfo) {
        String str;
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            TsmRpcModels.EidInfoResponse c = this.c.c(context);
            if (c != null) {
                i = f.a(c.getResult());
                str = c.getErrorDesc();
                LogUtils.d("EidCardClient updateCardInfo result: " + i + ", msg: " + str);
                TsmRpcModels.EidInfo eidInfo = c.getEidInfo();
                if (i == 0 && eidInfo != null && !TextUtils.isEmpty(eidInfo.getAid())) {
                    eidCardInfo.mAid = eidInfo.getAid();
                    eidCardInfo.mCardName = eidInfo.getName();
                    eidCardInfo.setCardArt(eidInfo.getCardArt());
                    eidCardInfo.setVCStatus(eidInfo.getVcStatus());
                    arrayList.add(eidCardInfo);
                    LogUtils.t("EidCardClient updateCardInfo eidCardInfo: " + eidCardInfo.serialize());
                }
            } else {
                i = -1;
                str = "";
            }
        } catch (com.miui.tsmclient.seitsm.a.a e) {
            LogUtils.e("EidCardClient updateCardInfo error occurred", e);
            i = e.a();
            str = e.getMessage();
        }
        return new BaseResponse(i, str, arrayList);
    }
}
