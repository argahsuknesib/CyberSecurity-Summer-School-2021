package com.miui.tsmclient.sesdk;

import android.content.Context;
import android.text.TextUtils;
import com.miui.tsmclient.account.IMiOAuth;
import com.miui.tsmclient.b.a.a;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.common.net.internal.okhttp.InternalIOException;
import com.miui.tsmclient.entity.BulletinResponseInfo;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.UncompletedBusiness;
import com.miui.tsmclient.model.BaseModel;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.BaseTransitCardModel;
import com.miui.tsmclient.model.ErrorCode;
import com.miui.tsmclient.model.e.d;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.request.BulletinListSyncRequest;
import com.miui.tsmclient.net.request.i;
import com.miui.tsmclient.sesdk.UncompletedOrderList;
import com.miui.tsmclient.util.CardEnvironmentConfig;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.IDeviceInfo;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.ReflectUtil;
import com.miui.tsmclient.util.TSMLocationService;
import com.tsmclient.smartcard.terminal.external.IApduExecutor;
import com.tsmclient.smartcard.terminal.external.IChannel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MiPayService implements ICardList {
    public static void initialize(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            EnvironmentConfig.initialize(context);
        } else {
            EnvironmentConfig.initialize(context, str);
        }
    }

    public static void setApduExecutor(IApduExecutor iApduExecutor) {
        a.a(iApduExecutor);
    }

    public static void setChannel(IChannel iChannel) {
        a.a(iChannel);
    }

    public static void setDeviceInfo(IDeviceInfo iDeviceInfo) {
        CardEnvironmentConfig.setDeviceInfo(iDeviceInfo);
    }

    public static void setMiOAuth(IMiOAuth iMiOAuth) {
        EnvironmentConfig.setMiOAuth(iMiOAuth);
    }

    public static void setStaging(boolean z) {
        EnvironmentConfig.setStaging(z);
    }

    public static void setStagingIndex(int i) {
        EnvironmentConfig.setStagingIndex(i);
    }

    public BaseResponse getBulletinList(SeCard seCard, String str) {
        CardInfo cardInfo;
        BaseResponse baseResponse = new BaseResponse();
        if (seCard == null) {
            cardInfo = null;
        } else {
            try {
                cardInfo = seCard.mCardInfo;
            } catch (IOException e) {
                baseResponse.mResultCode = 2;
                baseResponse.mMsg = e.getMessage();
                LogUtils.e("io exception occurs when getting bulletin list", e);
            } catch (InterruptedException e2) {
                baseResponse.mResultCode = 11;
                baseResponse.mMsg = e2.getMessage();
                LogUtils.e("interrupted exception occurs when getting bulletin list", e2);
                Thread.currentThread().interrupt();
            }
        }
        BulletinResponseInfo bulletinResponseInfo = (BulletinResponseInfo) HttpClient.getInstance(EnvironmentConfig.getContext()).execute(new BulletinListSyncRequest(str, cardInfo, (cardInfo != null ? cardInfo.getTerminal() : new CardInfo("DUMMY").getTerminal()).getCPLC(), null)).getResult();
        if (bulletinResponseInfo == null) {
            baseResponse.mResultCode = -1;
        } else {
            baseResponse.mDatas = new Object[]{bulletinResponseInfo.getBulletinList()};
            baseResponse.mResultCode = bulletinResponseInfo.getErrorCode();
            baseResponse.mMsg = bulletinResponseInfo.getErrorDesc();
        }
        return baseResponse;
    }

    public List<SeCard> getIssuedCardList(CardCategory cardCategory) throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        ICardList iCardList = (ICardList) ReflectUtil.newInstance("com.miui.tsmclient.sesdk.tsmsdkcard.TSMSDKService", (Class<?>[]) null, new Object[0]);
        if (iCardList != null) {
            arrayList.addAll(iCardList.getIssuedCardList(cardCategory));
        }
        ICardList iCardList2 = (ICardList) ReflectUtil.newInstance("com.miui.tsmclient.sesdk.upsdkcard.UPSDKService", (Class<?>[]) null, new Object[0]);
        if (iCardList2 != null) {
            arrayList.addAll(iCardList2.getIssuedCardList(cardCategory));
        }
        return arrayList;
    }

    public List<SeCard> getSupportedCardList(CardCategory cardCategory) throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        ICardList iCardList = (ICardList) ReflectUtil.newInstance("com.miui.tsmclient.sesdk.tsmsdkcard.TSMSDKService", (Class<?>[]) null, new Object[0]);
        if (iCardList != null) {
            arrayList.addAll(iCardList.getSupportedCardList(cardCategory));
        }
        ICardList iCardList2 = (ICardList) ReflectUtil.newInstance("com.miui.tsmclient.sesdk.upsdkcard.UPSDKService", (Class<?>[]) null, new Object[0]);
        if (iCardList2 != null) {
            arrayList.addAll(iCardList2.getSupportedCardList(cardCategory));
        }
        return arrayList;
    }

    public List<SeCard> getSupportedCardListWithGroup(CardCategory cardCategory) throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        ICardList iCardList = (ICardList) ReflectUtil.newInstance("com.miui.tsmclient.sesdk.tsmsdkcard.TSMSDKService", (Class<?>[]) null, new Object[0]);
        if (iCardList != null) {
            arrayList.addAll(iCardList.getSupportedCardListWithGroup(cardCategory));
        }
        ICardList iCardList2 = (ICardList) ReflectUtil.newInstance("com.miui.tsmclient.sesdk.upsdkcard.UPSDKService", (Class<?>[]) null, new Object[0]);
        if (iCardList2 != null) {
            arrayList.addAll(iCardList2.getSupportedCardListWithGroup(cardCategory));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<SeCard> getTransitCardList(String str, boolean z) throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        ICardList iCardList = (ICardList) ReflectUtil.newInstance("com.miui.tsmclient.sesdk.tsmsdkcard.TSMSDKService", (Class<?>[]) null, new Object[0]);
        if (iCardList != null) {
            arrayList.addAll(z ? iCardList.getSupportedCardListWithGroup(null) : iCardList.getSupportedCardList(null));
        }
        return arrayList;
    }

    public BaseResponse getUncompletedOrderList(List<SeCard> list) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<UncompletedBusiness> queryUncompletedBusiness = ((BaseTransitCardModel) BaseModel.create(EnvironmentConfig.getContext(), BaseTransitCardModel.class)).queryUncompletedBusiness(null);
            ArrayList arrayList = new ArrayList();
            for (UncompletedBusiness next : queryUncompletedBusiness) {
                for (SeCard next2 : list) {
                    if (next2.getAid().equals(next.getAid())) {
                        arrayList.add(new UncompletedOrderList.UncompletedOrder(next, next2));
                    }
                }
            }
            baseResponse.mDatas = new Object[]{new UncompletedOrderList(arrayList)};
            baseResponse.mResultCode = 0;
            LogUtils.d("getPendingOrderList success");
        } catch (AuthApiException e) {
            LogUtils.e("getPendingOrderList failed", e);
            baseResponse.mResultCode = 7;
            baseResponse.mMsg = e.getMessage();
        }
        return baseResponse;
    }

    public int getVersion() {
        return 4;
    }

    public BaseResponse invoke(String str, String str2) {
        int i;
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        try {
            return new d().a(EnvironmentConfig.getContext(), str, str2);
        } catch (com.miui.tsmclient.seitsm.a.a e) {
            LogUtils.e("SeiTSMApiException occurs when invoking task.", e);
            i = e.a();
            str3 = e.getMessage();
            return new BaseResponse(i, str3, new Object[0]);
        } catch (AuthApiException e2) {
            LogUtils.e("AuthApiException occurs when invoking task.", e2);
            i = 7;
            str3 = e2.getMessage();
            return new BaseResponse(i, str3, new Object[0]);
        } catch (InterruptedException e3) {
            LogUtils.e("InterruptedException happens when invoking task.", e3);
            Thread.currentThread().interrupt();
            i = 11;
            return new BaseResponse(i, str3, new Object[0]);
        }
    }

    public SiteInfo parseSite(String str, String str2) throws AuthApiException {
        Context context = EnvironmentConfig.getContext();
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        try {
            i.a aVar = (i.a) HttpClient.getInstance(context).execute(new i(context2, str3, str4, new CardInfo("DUMMY"), TSMLocationService.getInstance(context).getLastLocation(), null)).getResult();
            if (aVar.isSuccess()) {
                return new SiteInfo(aVar.a());
            }
            throw new AuthApiException(aVar.getErrorCode(), aVar.getErrorDesc());
        } catch (InternalIOException e) {
            Thread.currentThread().interrupt();
            throw new AuthApiException(e.getErrorCode(), e.getMessage());
        } catch (IOException unused) {
            Thread.currentThread().interrupt();
            throw new AuthApiException(2, ErrorCode.findText(context, 2));
        }
    }
}
