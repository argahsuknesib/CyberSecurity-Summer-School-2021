package com.miui.tsmclient.sesdk.tsmsdkcard;

import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoFactory;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.sesdk.CardCategory;
import com.miui.tsmclient.sesdk.SeCard;
import com.miui.tsmclient.sesdk.TransitCardGroupDetail;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class TransitCardGroup extends SeCard {
    private List<SeCard> mCardList;

    TransitCardGroup(CardInfo cardInfo) {
        super(cardInfo);
    }

    private List<SeCard> build(List<? extends CardInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (CardInfo transitCard : list) {
                arrayList.add(new TransitCard(transitCard));
            }
        }
        return arrayList;
    }

    public void cloneExtraCardInfo() {
        if (this.mCardInfo.mCardUIInfo != null) {
            this.mCardFace = this.mCardInfo.mCardUIInfo.getBackground();
            this.mIsIssued = this.mCardInfo.mHasIssue;
        }
    }

    public SeCard.IOnlineProperties createOnlineProperties() {
        return new TransitCardGroupDetail(this);
    }

    public List<SeCard> getCardList() throws AuthApiException {
        List<SeCard> list = this.mCardList;
        if (list != null) {
            return list;
        }
        try {
            this.mCardList = new ArrayList();
            JSONArray queryChildCardProduct = this.mTSMAuthManager.queryChildCardProduct(EnvironmentConfig.getContext(), this.mCardInfo.mCardName);
            ArrayList arrayList = new ArrayList();
            if (queryChildCardProduct != null) {
                for (int i = 0; i < queryChildCardProduct.length(); i++) {
                    JSONObject jSONObject = queryChildCardProduct.getJSONObject(i);
                    CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(jSONObject.optString("cardName"), null);
                    makeCardInfo.parse(jSONObject);
                    arrayList.add(makeCardInfo);
                }
            }
            this.mCardList.addAll(build(arrayList));
            return this.mCardList;
        } catch (JSONException e) {
            LogUtils.e("failed to get cards on network!", e);
            throw new AuthApiException(16);
        }
    }

    public CardCategory getCategory() {
        return CardCategory.TRANSIT;
    }

    public String getDetail() {
        return new TransitCardGroupDetail(this).toJson();
    }

    public boolean isGroup() {
        return true;
    }
}
