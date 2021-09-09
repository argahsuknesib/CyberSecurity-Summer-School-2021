package com.miui.tsmclient.sesdk.tsmsdkcard;

import android.content.Context;
import android.location.Location;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.entity.CardGroupType;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoFactory;
import com.miui.tsmclient.entity.CloudTransitCardInfo;
import com.miui.tsmclient.entity.DoorCardProduct;
import com.miui.tsmclient.entity.MifareCardInfo;
import com.miui.tsmclient.entity.d;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.TSMAuthManager;
import com.miui.tsmclient.net.request.f;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.seitsm.a;
import com.miui.tsmclient.sesdk.CardCategory;
import com.miui.tsmclient.sesdk.ICardList;
import com.miui.tsmclient.sesdk.SeCard;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.TSMLocationService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TSMSDKService implements ICardList {
    private List<SeCard> build(List<? extends CardInfo> list, boolean z, CardCategory cardCategory) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (CardInfo cardInfo : list) {
            arrayList.add(cardCategory == CardCategory.TRANSIT ? cardInfo.isHasChildren() ? new TransitCardGroup(cardInfo) : new TransitCard(cardInfo) : cardCategory == CardCategory.CLOUD_TRANSIT ? new CloudTransitCard(cardInfo) : new KeyCard(cardInfo, z));
        }
        return arrayList;
    }

    private List<SeCard> getCloudTransitCardList() throws AuthApiException {
        TSMAuthManager tSMAuthManager = new TSMAuthManager();
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray queryCloudTransitCard = tSMAuthManager.queryCloudTransitCard(EnvironmentConfig.getContext(), CardGroupType.TRANSCARD, null, TSMLocationService.getInstance(EnvironmentConfig.getContext()).getLastLocation());
            ArrayList arrayList2 = new ArrayList();
            if (queryCloudTransitCard != null) {
                for (int i = 0; i < queryCloudTransitCard.length(); i++) {
                    JSONObject jSONObject = queryCloudTransitCard.getJSONObject(i);
                    arrayList2.add(new CloudTransitCardInfo(jSONObject.optString("cardName"), jSONObject));
                }
            }
            arrayList.addAll(build(arrayList2, false, CardCategory.CLOUD_TRANSIT));
            return arrayList;
        } catch (JSONException e) {
            LogUtils.e("failed to get cloud cards on network!", e);
            throw new AuthApiException(16);
        }
    }

    private List<SeCard> getDoorCardList() throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        f fVar = new f(null);
        try {
            d dVar = (d) HttpClient.getInstance(EnvironmentConfig.getContext()).execute(fVar).getResult();
            if (!fVar.isSuccess()) {
                int errorCode = dVar == null ? 2 : dVar.getErrorCode();
                if (dVar != null) {
                    str = dVar.getErrorDesc();
                }
                throw new AuthApiException(errorCode, str);
            }
            ArrayList arrayList2 = new ArrayList();
            for (DoorCardProduct next : dVar.a()) {
                MifareCardInfo mifareCardInfo = new MifareCardInfo();
                mifareCardInfo.mCardArt = next.getCardArt();
                mifareCardInfo.mCardName = next.getProductName();
                mifareCardInfo.setProductId(next.getProductId());
                mifareCardInfo.mMifareCardType = next.getCardType();
                arrayList2.add(mifareCardInfo);
            }
            arrayList.addAll(build(arrayList2, false, CardCategory.DOOR));
            return arrayList;
        } catch (IOException unused) {
            throw new AuthApiException(2);
        }
    }

    public List<SeCard> getIssuedCardList(CardCategory cardCategory) throws AuthApiException {
        String str;
        int i;
        a aVar = new a();
        Context context = EnvironmentConfig.getContext();
        ArrayList arrayList = new ArrayList();
        if (cardCategory == null || cardCategory == CardCategory.TRANSIT) {
            for (SeCard next : getTransitCardList(null, false)) {
                if (next.isIssued()) {
                    arrayList.add(next);
                }
            }
        }
        if (cardCategory != null && cardCategory != CardCategory.DOOR) {
            return arrayList;
        }
        try {
            TsmRpcModels.QueryDoorCardInfoResponse b = aVar.b(context);
            if (b == null) {
                return arrayList;
            }
            i = com.miui.tsmclient.model.e.f.a(b.getResult());
            str = b.getErrorDesc();
            LogUtils.d("getDoorCardList result: ".concat(String.valueOf(i)));
            if (i == 0) {
                arrayList.addAll(build(com.miui.tsmclient.model.d.a.a(context, b.getCardInfoListList()), true, CardCategory.DOOR));
                return arrayList;
            }
            throw new AuthApiException(i, str);
        } catch (com.miui.tsmclient.seitsm.a.a e) {
            LogUtils.e("getDoorCardList failed", e);
            i = e.a();
            str = e.getMessage();
        }
    }

    public List<SeCard> getSupportedCardList(CardCategory cardCategory) throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        if (cardCategory == null || cardCategory == CardCategory.CLOUD_TRANSIT) {
            try {
                arrayList.addAll(getCloudTransitCardList());
            } catch (AuthApiException e) {
                LogUtils.e("getCloudTransitCardList failed", e);
            }
        }
        if (cardCategory == null || cardCategory == CardCategory.TRANSIT) {
            arrayList.addAll(getTransitCardList(null, false));
        }
        if (cardCategory == null || cardCategory == CardCategory.DOOR) {
            arrayList.addAll(getDoorCardList());
        }
        return arrayList;
    }

    public List<SeCard> getSupportedCardListWithGroup(CardCategory cardCategory) throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        if (cardCategory == null || cardCategory == CardCategory.CLOUD_TRANSIT) {
            try {
                arrayList.addAll(getCloudTransitCardList());
            } catch (AuthApiException e) {
                LogUtils.e("getCloudTransitCardList failed", e);
            }
        }
        if (cardCategory == null || cardCategory == CardCategory.TRANSIT) {
            arrayList.addAll(getTransitCardList(null, true));
        }
        if (cardCategory == null || cardCategory == CardCategory.DOOR) {
            arrayList.addAll(getDoorCardList());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<SeCard> getTransitCardList(String str, boolean z) throws AuthApiException {
        TSMAuthManager tSMAuthManager = new TSMAuthManager();
        Context context = EnvironmentConfig.getContext();
        ArrayList arrayList = new ArrayList();
        try {
            Location lastLocation = TSMLocationService.getInstance(context).getLastLocation();
            JSONArray queryCardProductGroup = z ? tSMAuthManager.queryCardProductGroup(context, CardGroupType.TRANSCARD, str, lastLocation) : tSMAuthManager.queryCardProduct(context, CardGroupType.TRANSCARD, str, lastLocation);
            ArrayList arrayList2 = new ArrayList();
            if (queryCardProductGroup != null) {
                for (int i = 0; i < queryCardProductGroup.length(); i++) {
                    JSONObject jSONObject = queryCardProductGroup.getJSONObject(i);
                    CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(jSONObject.optString("cardName"), null);
                    makeCardInfo.parse(jSONObject);
                    arrayList2.add(makeCardInfo);
                }
            }
            arrayList.addAll(build(arrayList2, false, CardCategory.TRANSIT));
            return arrayList;
        } catch (JSONException e) {
            LogUtils.e("failed to get cards on network!", e);
            throw new AuthApiException(16);
        }
    }
}
