package com.miui.tsmclient.model.a;

import android.content.Context;
import android.os.Bundle;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.QrBankCardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.e.d;
import com.miui.tsmclient.model.e.f;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.seitsm.a.a;
import com.miui.tsmclient.util.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class c extends d {
    public static List<QrBankCardInfo> a(List<TsmRpcModels.QrCardInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (TsmRpcModels.QrCardInfo next : list) {
            QrBankCardInfo qrBankCardInfo = new QrBankCardInfo();
            qrBankCardInfo.mVCReferenceId = next.getCardReferenceId();
            qrBankCardInfo.mPanLastDigits = next.getLastDigits();
            qrBankCardInfo.mBankCardType = next.getCardType().getNumber();
            TsmRpcModels.CardIssuerInfo issuerInfo = next.getIssuerInfo();
            qrBankCardInfo.mBankName = issuerInfo.getBankName();
            qrBankCardInfo.mIssuerId = issuerInfo.getIssuerId();
            qrBankCardInfo.mIssuerChannel = issuerInfo.getCardIssueChannel().getNumber();
            qrBankCardInfo.mBankLogoUrl = issuerInfo.getLogoUrl();
            qrBankCardInfo.mBankLogoWithNameUrl = issuerInfo.getLogoWithBankNameUrl();
            qrBankCardInfo.mBankContactNum = issuerInfo.getContactNumber();
            qrBankCardInfo.mBgImage = issuerInfo.getBgImage();
            qrBankCardInfo.mServiceHotline = issuerInfo.getHotline();
            arrayList.add(qrBankCardInfo);
        }
        return arrayList;
    }

    public BaseResponse a(Context context) {
        String str;
        int i;
        try {
            TsmRpcModels.BankCardListForQrResponse d = this.c.d(context);
            if (d == null) {
                i = -1;
                str = "";
            } else {
                i = f.a(d.getResult());
                str = d.getErrorDesc();
            }
            LogUtils.d("queryQrBankCardList result: ".concat(String.valueOf(i)));
            if (i == 0) {
                return new BaseResponse(0, d);
            }
        } catch (a e) {
            i = e.a();
            str = e.getMessage();
            LogUtils.e("queryQrBankCardList failed with an tsmapi exception.", e);
        }
        return new BaseResponse(i, str, new Object[0]);
    }

    public BaseResponse a(Context context, Bundle bundle) {
        int i;
        String str;
        try {
            TsmRpcModels.CommonResponse a2 = this.c.a(context, bundle);
            if (a2 != null) {
                i = f.a(a2.getResult());
                str = a2.getErrorDesc();
            } else {
                i = -2;
                str = "";
            }
            LogUtils.d("deleteQrBankCards result: ".concat(String.valueOf(i)));
        } catch (a e) {
            i = e.a();
            String message = e.getMessage();
            LogUtils.e("failed to delete qr bank card", e);
            str = message;
        }
        return new BaseResponse(i, str, new Object[0]);
    }

    public BaseResponse a(Context context, CardInfo cardInfo, Bundle bundle) {
        return null;
    }
}
