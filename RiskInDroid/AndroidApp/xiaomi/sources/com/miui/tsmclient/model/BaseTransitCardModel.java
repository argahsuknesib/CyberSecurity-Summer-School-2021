package com.miui.tsmclient.model;

import android.location.Location;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.entity.ActionToken;
import com.miui.tsmclient.entity.CardGroupType;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoFactory;
import com.miui.tsmclient.entity.CloudTransitCardInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.entity.TransferOutOrderInfo;
import com.miui.tsmclient.entity.UncompletedBusiness;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.TSMAuthManager;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.TSMLocationService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseTransitCardModel extends BaseModel {
    protected TSMAuthManager mTSMAuthManager;

    /* access modifiers changed from: protected */
    public void onInit() {
        this.mTSMAuthManager = new TSMAuthManager();
    }

    public List<CardInfo> getCardsFromNetwork(CardInfo cardInfo) throws AuthApiException {
        Location lastLocation = TSMLocationService.getInstance(getContext()).getLastLocation();
        ArrayList arrayList = new ArrayList();
        parseJsonArrayToList(this.mTSMAuthManager.queryCardProduct(getContext(), CardGroupType.TRANSCARD, cardInfo == null ? null : cardInfo.mCardType, lastLocation), arrayList);
        return arrayList;
    }

    public List<CardInfo> getCardsWithGroupFromNetWork(CardInfo cardInfo) throws AuthApiException {
        Location lastLocation = TSMLocationService.getInstance(getContext()).getLastLocation();
        ArrayList arrayList = new ArrayList();
        parseJsonArrayToList(this.mTSMAuthManager.queryCardProductGroup(getContext(), CardGroupType.TRANSCARD, cardInfo == null ? null : cardInfo.mCardType, lastLocation), arrayList);
        return arrayList;
    }

    public List<CardInfo> getChildCardsFromNetWork(CardInfo cardInfo) throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        parseJsonArrayToList(this.mTSMAuthManager.queryChildCardProduct(getContext(), cardInfo.mCardType), arrayList);
        return arrayList;
    }

    public CardInfo getCardFromNetwork(String str) {
        try {
            JSONArray queryCardProduct = this.mTSMAuthManager.queryCardProduct(getContext(), str);
            if (queryCardProduct == null) {
                return null;
            }
            for (int i = 0; i < queryCardProduct.length(); i++) {
                JSONObject jSONObject = queryCardProduct.getJSONObject(i);
                CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(jSONObject.optString("cardName"), jSONObject);
                if (TextUtils.equals(str, makeCardInfo.mCardType)) {
                    return makeCardInfo;
                }
            }
            return null;
        } catch (JSONException e) {
            LogUtils.e("failed to parse card info!", e);
        } catch (IOException e2) {
            LogUtils.e("failed to get card info!", e2);
        } catch (AuthApiException e3) {
            LogUtils.e("failed to get card info. errorCode: " + e3.mErrorCode + ", msg: " + e3.mErrorMsg, e3);
        }
    }

    public List<OrderInfo> getCardOrderList(CardInfo cardInfo) throws AuthApiException {
        if (cardInfo != null) {
            HashMap hashMap = new HashMap();
            try {
                JSONArray queryByUserId = queryByUserId(hashMap);
                List<OrderInfo> list = (List) hashMap.get(cardInfo.mCardType);
                if (queryByUserId == null) {
                    return null;
                }
                return list == null ? new ArrayList() : list;
            } catch (JSONException e) {
                LogUtils.e("failed to getCardOrderList!", e);
            }
        }
        return null;
    }

    public Map<String, List<OrderInfo>> queryByUserId() throws JSONException, AuthApiException {
        HashMap hashMap = new HashMap();
        queryByUserId(hashMap);
        return hashMap;
    }

    public List<CardInfo> getCloudCardsFromNetwork() throws AuthApiException {
        Location lastLocation = TSMLocationService.getInstance(getContext()).getLastLocation();
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray queryCloudTransitCard = new TSMAuthManager().queryCloudTransitCard(getContext(), CardGroupType.TRANSCARD, null, lastLocation);
            if (queryCloudTransitCard != null) {
                for (int i = 0; i < queryCloudTransitCard.length(); i++) {
                    JSONObject jSONObject = queryCloudTransitCard.getJSONObject(i);
                    CloudTransitCardInfo cloudTransitCardInfo = new CloudTransitCardInfo(jSONObject.optString("cardName"), jSONObject);
                    cloudTransitCardInfo.mDataSource = CardInfo.DataSource.Network;
                    cloudTransitCardInfo.parse(jSONObject);
                    arrayList.add(cloudTransitCardInfo);
                }
            }
            return arrayList;
        } catch (JSONException e) {
            LogUtils.e("failed to get cloud cards on network!", e);
            throw new AuthApiException(16);
        }
    }

    public List<CardInfo> getRecommendedCardsFromNetWork(int i) throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        parseJsonArrayToList(new TSMAuthManager().queryRecommendedTransitCard(getContext(), CardGroupType.TRANSCARD, null, i), arrayList);
        return arrayList;
    }

    public void removeUnTransferInOrder(List<CardInfo> list) {
        List<ActionToken> list2;
        int size = list == null ? 0 : list.size();
        for (int i = 0; i < size; i++) {
            CardInfo cardInfo = list.get(i);
            if (cardInfo instanceof PayableCardInfo) {
                PayableCardInfo payableCardInfo = (PayableCardInfo) cardInfo;
                if (payableCardInfo.hasTransferInOrder() && (list2 = payableCardInfo.mUnfinishOrderInfos.get(0).mActionTokens) != null) {
                    for (ActionToken canShiftIn : list2) {
                        if (!canShiftIn.canShiftIn()) {
                            payableCardInfo.mUnfinishOrderInfos.clear();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public JSONArray queryByUserId(Map<String, List<OrderInfo>> map) throws JSONException, AuthApiException {
        JSONArray queryByUserId = this.mTSMAuthManager.queryByUserId(getContext());
        if (queryByUserId == null) {
            return queryByUserId;
        }
        for (int i = 0; i < queryByUserId.length(); i++) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.parse(queryByUserId.getJSONObject(i));
            List list = map.get(orderInfo.mCardType);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                map.put(orderInfo.mCardType, list);
            }
            list.add(orderInfo);
        }
        return queryByUserId;
    }

    private void queryWithdrawCardOrder(List<CardInfo> list) throws AuthApiException {
        List<TransferOutOrderInfo> queryWithdrawCardOrder;
        if (list != null && !list.isEmpty() && (queryWithdrawCardOrder = this.mTSMAuthManager.queryWithdrawCardOrder(getContext())) != null) {
            for (TransferOutOrderInfo next : queryWithdrawCardOrder) {
                Iterator<CardInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PayableCardInfo payableCardInfo = (PayableCardInfo) it.next();
                    if (TextUtils.equals(next.getCardType(), payableCardInfo.mCardType)) {
                        payableCardInfo.setUnfinishTransferOutInfo(next);
                        break;
                    }
                }
            }
        }
    }

    public List<UncompletedBusiness> queryUncompletedBusiness(String str) throws AuthApiException {
        return (List) new Gson().fromJson(this.mTSMAuthManager.queryUncompletedBusiness(getContext(), str).toString(), new TypeToken<List<UncompletedBusiness>>() {
            /* class com.miui.tsmclient.model.BaseTransitCardModel.AnonymousClass1 */
        }.getType());
    }

    private void parseJsonArrayToList(JSONArray jSONArray, List<CardInfo> list) throws AuthApiException {
        if (jSONArray != null) {
            try {
                HashMap hashMap = new HashMap();
                boolean z = false;
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    PayableCardInfo payableCardInfo = new PayableCardInfo(jSONObject.optString("cardName"));
                    payableCardInfo.mDataSource = CardInfo.DataSource.Network;
                    payableCardInfo.parse(jSONObject);
                    list.add(payableCardInfo);
                    if (!z) {
                        try {
                            queryByUserId(hashMap);
                            z = true;
                        } catch (AuthApiException e) {
                            LogUtils.e("queryByUserId failed. errorCode: " + e.mErrorCode + ", msg: " + e.mErrorMsg, e);
                        }
                    }
                    PayableCardInfo payableCardInfo2 = payableCardInfo;
                    if (hashMap.containsKey(payableCardInfo.mCardType)) {
                        payableCardInfo2.mUnfinishOrderInfos = (List) hashMap.get(payableCardInfo.mCardType);
                    }
                }
                queryWithdrawCardOrder(list);
            } catch (JSONException e2) {
                LogUtils.e("failed to get cards on network!", e2);
                throw new AuthApiException(16);
            }
        }
    }
}
