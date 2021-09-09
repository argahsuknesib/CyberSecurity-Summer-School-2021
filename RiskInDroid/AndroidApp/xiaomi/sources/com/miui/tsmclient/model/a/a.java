package com.miui.tsmclient.model.a;

import android.content.Context;
import com.miui.tsmclient.entity.BankCardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.e.d;
import com.miui.tsmclient.model.e.f;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.util.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class a extends d {
    public static List<BankCardInfo> a(List<TsmRpcModels.BankCardInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (TsmRpcModels.BankCardInfo next : list) {
            BankCardInfo bankCardInfo = new BankCardInfo();
            bankCardInfo.mAid = next.getAid();
            bankCardInfo.mBankCardPan = next.getCardNumber();
            bankCardInfo.mVCReferenceId = next.getVirtualCardReferenceId();
            bankCardInfo.mVCardNumber = next.getVirtualCardNumber();
            bankCardInfo.mPanLastDigits = next.getLastDigits();
            bankCardInfo.mVCStatus = next.getVcStatus();
            bankCardInfo.mCardProductTypeId = next.getProductId();
            bankCardInfo.mCardProductName = next.getProductName();
            bankCardInfo.mUserTerms = next.getUserTerms();
            bankCardInfo.mCardArt = next.getCardArt();
            bankCardInfo.mBankCardType = next.getCardType();
            TsmRpcModels.CardIssuerInfo issuerInfo = next.getIssuerInfo();
            bankCardInfo.mBankName = issuerInfo.getBankName();
            bankCardInfo.mIssuerId = issuerInfo.getIssuerId();
            bankCardInfo.mIssuerChannel = issuerInfo.getCardIssueChannel().getNumber();
            bankCardInfo.mBankLogoUrl = issuerInfo.getLogoUrl();
            bankCardInfo.mBankLogoWithNameUrl = issuerInfo.getLogoWithBankNameUrl();
            bankCardInfo.mBankContactNum = issuerInfo.getContactNumber();
            bankCardInfo.mCardFrontColor = next.getFrontColor();
            bankCardInfo.mHasQRToken = next.getHasQrToken();
            bankCardInfo.mServiceHotline = next.getServiceHotline();
            bankCardInfo.mSuggestion = next.getSuggestion();
            bankCardInfo.setCardElementsOption(next.getCardElementsOption());
            arrayList.add(bankCardInfo);
        }
        return arrayList;
    }

    public BaseResponse a(Context context) {
        String str;
        int i;
        try {
            TsmRpcModels.CommonResponse a2 = this.c.a(context);
            if (a2 != null) {
                i = f.a(a2.getResult());
                str = a2.getErrorDesc();
            } else {
                i = -2;
                str = "";
            }
            LogUtils.d("deleteCards result: ".concat(String.valueOf(i)));
        } catch (com.miui.tsmclient.seitsm.a.a e) {
            i = e.a();
            String message = e.getMessage();
            LogUtils.e("failed to delete all bank cards", e);
            str = message;
        }
        return new BaseResponse(i, str, new Object[0]);
    }

    public BaseResponse a(Context context, String str) {
        int i;
        String str2;
        try {
            TsmRpcModels.QueryBankCardInfoResponse a2 = this.c.a(context, str);
            if (a2 == null) {
                i = -1;
                str2 = "";
            } else {
                i = f.a(a2.getResult());
                str2 = a2.getErrorDesc();
            }
            LogUtils.d("queryBankCardList result: ".concat(String.valueOf(i)));
            if (i == 0) {
                return new BaseResponse(0, a2);
            }
        } catch (com.miui.tsmclient.seitsm.a.a e) {
            i = e.a();
            str2 = e.getMessage();
            LogUtils.e("queryBankCardList failed with an tsmapi exception.", e);
        }
        return new BaseResponse(i, str2, new Object[0]);
    }
}
