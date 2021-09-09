package com.miui.tsmclient;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.ActionToken;
import com.miui.tsmclient.entity.CardConfigManager;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoManager;
import com.miui.tsmclient.entity.CouponInfo;
import com.miui.tsmclient.entity.FeeInfo;
import com.miui.tsmclient.entity.GroupConfigInfo;
import com.miui.tsmclient.entity.MifareCardInfo;
import com.miui.tsmclient.entity.OrderDetailInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.entity.RechargeOrderInfo;
import com.miui.tsmclient.entity.RechargeOrderResponseInfo;
import com.miui.tsmclient.entity.RefundInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.BaseTransitCardModel;
import com.miui.tsmclient.model.e.d;
import com.miui.tsmclient.model.e.h;
import com.miui.tsmclient.model.l;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.TSMAuthManager;
import com.miui.tsmclient.net.request.ConfigListRequest;
import com.miui.tsmclient.net.request.RechargeOrderListRequest;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.pay.PayToolFactory;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.NetworkUtil;
import com.miui.tsmclient.util.TSMLocationService;
import com.miui.tsmclient.util.a;
import com.tsmclient.smartcard.PrefUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

@Deprecated
public class Facade {
    private l mCardManager;
    public Context mContext;
    private CompositeSubscription mSubscriptions;
    public TSMAuthManager mTSMAuthManager;
    public BaseTransitCardModel mTransitCardModel;

    public interface CardListListener extends UpdateCardListener {
        void onCardListUpdated(List<CardInfo> list);

        void onNetworkUnavailable();

        void onServerUnavailable();

        void onUpdateCardListCompleted();
    }

    public static class CityResponseInfo extends CommonResponseInfo {
        @SerializedName("data")
        public CitiesInfo mCitiesInfo;

        public static class CitiesInfo {
            @SerializedName("availableCityInfo")
            public CityInfo mAvailableCityInfo;
            @SerializedName("locationCityInfo")
            public CityInfo mLocationCityInfo;
        }

        public static class CityInfo {
            @SerializedName("cityId")
            public String mCityId;
            @SerializedName("cityName")
            public String mCityName;
        }
    }

    public interface CreateOrderListener {
        void onCreateOrderFailed(int i, String str);

        void onCreateOrderSuccess(OrderInfo orderInfo);
    }

    public interface GetCitiesInfoListener {
        void onGetCitiesInfoFailed(int i, String str);

        void onGetCitiesInfoListSuccess(CityResponseInfo.CitiesInfo citiesInfo);
    }

    public interface GetDefaultCardListener {
        void onGetDefaultCard(String str);
    }

    public interface GetIssueCardNoticeListener {
        void onGetIssueCardNoticeFailed(int i, String str);

        void onGetIssueCardNoticeSuccess(String str);
    }

    public interface GetRechargeOrderListListener {
        void onGetRechargeOrderListFailed(int i, String str);

        void onGetRechargeOrderListSuccess(List<RechargeOrderInfo> list);
    }

    public static class SimpleSubscriber<T> extends Subscriber<T> {
        private String mCompleteLog;
        private String mErrorLog;

        public SimpleSubscriber() {
            this("error occurred");
        }

        public SimpleSubscriber(String str) {
            this(null, str);
        }

        public SimpleSubscriber(String str, String str2) {
            this.mCompleteLog = str;
            this.mErrorLog = str2;
        }

        public void onCompleted() {
            if (!TextUtils.isEmpty(this.mCompleteLog)) {
                LogUtils.d(this.mCompleteLog);
            }
        }

        public void onError(Throwable th) {
            if (!TextUtils.isEmpty(this.mErrorLog)) {
                LogUtils.e(this.mErrorLog, th);
            }
        }

        public void onNext(T t) {
        }
    }

    public interface UpdateCardListener {
        void onCardUpdated(CardInfo cardInfo);
    }

    private Facade() {
    }

    public static Facade getFacade(Context context) {
        Facade facade = new Facade();
        facade.onInit(context);
        return facade;
    }

    private void onInit(Context context) {
        this.mContext = context.getApplicationContext();
        this.mTransitCardModel = new BaseTransitCardModel();
        this.mTransitCardModel.init(this.mContext, null);
        this.mTSMAuthManager = new TSMAuthManager();
        this.mSubscriptions = new CompositeSubscription();
        this.mCardManager = new l(this.mContext);
    }

    public void activateCard(CardInfo cardInfo) {
        a.b(this.mContext, cardInfo);
    }

    public void clearData() {
        CardInfoManager.getInstance(this.mContext).clear();
        PrefUtils.clear(this.mContext);
        com.miui.tsmclient.util.PrefUtils.clear(this.mContext);
        com.miui.tsmclient.database.a.a(this.mContext);
    }

    public void createOrder(FeeInfo feeInfo, CardInfo cardInfo, Bundle bundle, final CreateOrderListener createOrderListener) {
        if (cardInfo != null && feeInfo != null && createOrderListener != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            final Bundle bundle2 = bundle;
            if (!bundle2.containsKey("payChannel")) {
                bundle2.putString("payChannel", "UCashier");
            }
            CouponInfo couponInfo = feeInfo.getCouponInfo();
            if (couponInfo != null && couponInfo.isValid()) {
                bundle2.putLong("couponId", couponInfo.getCouponId());
            }
            final FeeInfo feeInfo2 = feeInfo;
            final CardInfo cardInfo2 = cardInfo;
            final CreateOrderListener createOrderListener2 = createOrderListener;
            this.mSubscriptions.add(Observable.fromCallable(new Callable<OrderInfo>() {
                /* class com.miui.tsmclient.Facade.AnonymousClass4 */

                public OrderInfo call() throws Exception {
                    try {
                        JSONObject createOrder = Facade.this.mTSMAuthManager.createOrder(Facade.this.mContext, feeInfo2.mId, cardInfo2, bundle2);
                        if (createOrder == null) {
                            return null;
                        }
                        OrderInfo orderInfo = new OrderInfo();
                        orderInfo.parse(createOrder);
                        LogUtils.d("order create success, orderId:" + orderInfo.mOrderId);
                        return orderInfo;
                    } catch (AuthApiException e) {
                        LogUtils.e("create order from mipay failed. errorcode: " + e.mErrorCode + ", msg:" + e.mErrorMsg, e);
                        createOrderListener2.onCreateOrderFailed(e.mErrorCode, e.mErrorMsg);
                        return null;
                    }
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new SimpleSubscriber<OrderInfo>("createOrder is completed", "createOrder error occurred") {
                /* class com.miui.tsmclient.Facade.AnonymousClass3 */

                public void onNext(OrderInfo orderInfo) {
                    if (orderInfo != null) {
                        createOrderListener.onCreateOrderSuccess(orderInfo);
                    }
                }
            }));
        }
    }

    public void deactivateCard(CardInfo cardInfo) {
        a.c(this.mContext, cardInfo);
    }

    public BaseResponse deleteCard(CardInfo cardInfo) {
        return CardInfoManager.getInstance(this.mContext).deleteCard(cardInfo, null);
    }

    public List<CardInfo> fetchCards(CardInfo cardInfo) {
        BaseResponse updateCards = CardInfoManager.getInstance(this.mContext).updateCards(cardInfo);
        if (updateCards.isSuccess()) {
            if (updateCards.mDatas[0] instanceof List) {
                ArrayList arrayList = new ArrayList();
                List list = (List) updateCards.mDatas[0];
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add((CardInfo) list.get(i));
                }
                return arrayList;
            }
        }
        return null;
    }

    public void getCardList(CardListListener cardListListener, boolean z) {
        if (NetworkUtil.isConnected(this.mContext)) {
            final CardListListener cardListListener2 = cardListListener;
            final boolean z2 = z;
            this.mSubscriptions.add(Observable.fromCallable(new Callable<List<CardInfo>>() {
                /* class com.miui.tsmclient.Facade.AnonymousClass2 */

                public List<CardInfo> call() throws Exception {
                    List<CardInfo> cardsFromNetwork = Facade.this.mTransitCardModel.getCardsFromNetwork(null);
                    if (cardsFromNetwork == null) {
                        cardsFromNetwork = Collections.emptyList();
                    } else {
                        CardConfigManager.getInstance().getSupportedTransCardMap(true);
                    }
                    Facade.this.mTransitCardModel.removeUnTransferInOrder(cardsFromNetwork);
                    return cardsFromNetwork;
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new SimpleSubscriber<List<CardInfo>>("getCardsFromNetwork complete", "getCardsFromNetwork error occurred") {
                /* class com.miui.tsmclient.Facade.AnonymousClass1 */

                public /* bridge */ /* synthetic */ void onNext(Object obj) {
                    onNext((List<CardInfo>) ((List) obj));
                }

                public void onNext(List<CardInfo> list) {
                    if (cardListListener2 == null) {
                        return;
                    }
                    if (list.isEmpty()) {
                        cardListListener2.onServerUnavailable();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(list);
                    cardListListener2.onCardListUpdated(list);
                    if (z2) {
                        Facade.this.updateTransitCardListFromLocal(arrayList, cardListListener2);
                    }
                }
            }));
        } else if (cardListListener != null) {
            cardListListener.onNetworkUnavailable();
        }
    }

    public void getCitiesInfo(CardInfo cardInfo, final GetCitiesInfoListener getCitiesInfoListener) {
        if (cardInfo != null && getCitiesInfoListener != null) {
            final CardInfo cardInfo2 = cardInfo;
            HttpClient.getInstance(this.mContext).enqueue(new SecureRequest<CityResponseInfo>(1, "api/%s/sporder/queryCityInfo", CityResponseInfo.class, new ResponseListener<CityResponseInfo>() {
                /* class com.miui.tsmclient.Facade.AnonymousClass6 */

                public void onFailed(int i, String str, CityResponseInfo cityResponseInfo) {
                    LogUtils.e("getCitiesInfo onFail! errorCode:" + i + ", errorMsg:" + str);
                    getCitiesInfoListener.onGetCitiesInfoFailed(i, str);
                }

                public void onSuccess(CityResponseInfo cityResponseInfo) {
                    LogUtils.d("getCitiesInfo onSuccess!");
                    getCitiesInfoListener.onGetCitiesInfoListSuccess(cityResponseInfo.mCitiesInfo);
                }
            }) {
                /* class com.miui.tsmclient.Facade.AnonymousClass7 */

                public void addExtraParams() throws IOException {
                    super.addExtraParams();
                    try {
                        Location lastLocation = TSMLocationService.getInstance(Facade.this.mContext).getLastLocation();
                        addParams("la", String.valueOf(lastLocation.getLatitude()));
                        addParams("lo", String.valueOf(lastLocation.getLongitude()));
                        addParams("cplc", cardInfo2.getTerminal().getCPLC());
                        addParams("cardName", cardInfo2.mCardType);
                    } catch (IOException | InterruptedException e) {
                        throw new IOException("RechargeOrderListRequest getExtraParams failed", e);
                    }
                }
            });
        }
    }

    public List<CardInfo> getCloudTransitCardList() throws AuthApiException {
        return this.mTransitCardModel.getCloudCardsFromNetwork();
    }

    public void getIssueCardNotice(final CardInfo cardInfo, final GetIssueCardNoticeListener getIssueCardNoticeListener) {
        if (cardInfo != null && getIssueCardNoticeListener != null) {
            HttpClient.getInstance(this.mContext).enqueue(new ConfigListRequest(cardInfo, "ISSUE_CARD_NOTICE", new ResponseListener<GroupConfigInfo>() {
                /* class com.miui.tsmclient.Facade.AnonymousClass8 */

                public void onFailed(int i, String str, GroupConfigInfo groupConfigInfo) {
                    LogUtils.e("getIssueCardNotice onFail! errorCode:" + i + ", errorMsg:" + str);
                    getIssueCardNoticeListener.onGetIssueCardNoticeFailed(i, str);
                }

                public void onSuccess(GroupConfigInfo groupConfigInfo) {
                    LogUtils.d("getIssueCardNotice onSuccess!");
                    List<String> contentList = groupConfigInfo.getContentList(cardInfo.mCardType, "ISSUE_CARD_NOTICE");
                    getIssueCardNoticeListener.onGetIssueCardNoticeSuccess(!contentList.isEmpty() ? contentList.get(0) : null);
                }
            }));
        }
    }

    public OrderDetailInfo getOrderDetail(CardInfo cardInfo, String str) throws AuthApiException {
        return this.mTSMAuthManager.getOrderDetailById(this.mContext, cardInfo, str);
    }

    public void getRechargeOrderList(CardInfo cardInfo, final GetRechargeOrderListListener getRechargeOrderListListener) {
        if (cardInfo != null && getRechargeOrderListListener != null) {
            HttpClient.getInstance(this.mContext).enqueue(new RechargeOrderListRequest(cardInfo, new ResponseListener<RechargeOrderResponseInfo>() {
                /* class com.miui.tsmclient.Facade.AnonymousClass5 */

                public void onFailed(int i, String str, RechargeOrderResponseInfo rechargeOrderResponseInfo) {
                    LogUtils.e("RechargeOrderListRequest onFail called! errorCode:" + i + ", errorMsg:" + str);
                    getRechargeOrderListListener.onGetRechargeOrderListFailed(i, str);
                }

                public void onSuccess(RechargeOrderResponseInfo rechargeOrderResponseInfo) {
                    LogUtils.d("RechargeOrderListRequest onSuccess called!");
                    getRechargeOrderListListener.onGetRechargeOrderListSuccess(rechargeOrderResponseInfo.getRechargeOrderInfoList());
                }
            }));
        }
    }

    public List<CardInfo> getTransitCardList(CardInfo cardInfo) throws AuthApiException {
        List<CardInfo> cardsFromNetwork = this.mTransitCardModel.getCardsFromNetwork(cardInfo);
        this.mTransitCardModel.removeUnTransferInOrder(cardsFromNetwork);
        return cardsFromNetwork;
    }

    public BaseResponse issue(CardInfo cardInfo, Bundle bundle) {
        if (cardInfo == null) {
            return new BaseResponse(1, new Object[0]);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (cardInfo instanceof PayableCardInfo) {
            PayableCardInfo payableCardInfo = (PayableCardInfo) cardInfo;
            bundle.putParcelable("card_info", payableCardInfo);
            Iterator<OrderInfo> it = payableCardInfo.mUnfinishOrderInfos.iterator();
            while (true) {
                if (it.hasNext()) {
                    OrderInfo next = it.next();
                    ActionToken issueOrWithdrawOrderToken = next.getIssueOrWithdrawOrderToken();
                    if (issueOrWithdrawOrderToken != null) {
                        bundle.putString("order_id", next.mOrderId);
                        bundle.putString("authentication_code", issueOrWithdrawOrderToken.mToken);
                        break;
                    }
                } else {
                    break;
                }
            }
        } else if (!(cardInfo instanceof MifareCardInfo)) {
            return new BaseResponse(1, new Object[0]);
        } else {
            if (!bundle.containsKey("extra_door_card_product_id")) {
                bundle.putString("extra_door_card_product_id", "99999-00001");
            }
        }
        if (cardInfo.hasTransferInOrder()) {
            BaseResponse transferIn = CardInfoManager.getInstance(this.mContext).transferIn(cardInfo, bundle);
            LogUtils.d("Facade transferIn called! result: " + transferIn.mResultCode);
            return transferIn;
        }
        BaseResponse issue = CardInfoManager.getInstance(this.mContext).issue(cardInfo, bundle);
        LogUtils.d("Facade issue called! result: " + issue.mResultCode);
        return issue;
    }

    public int parsePayResult(CardInfo cardInfo, Bundle bundle) {
        return PayToolFactory.getPayTool(cardInfo.mCardType).parsePayResult(this.mContext, cardInfo, bundle);
    }

    public int pay(Activity activity, CardInfo cardInfo, OrderInfo orderInfo) {
        return PayToolFactory.getPayTool(cardInfo.mCardType).pay(activity, orderInfo.mPayExtra, null);
    }

    public OrderInfo queryOrderInfo(String str) throws AuthApiException {
        return this.mTSMAuthManager.queryByOrderId(this.mContext, str);
    }

    public BaseResponse recharge(CardInfo cardInfo) {
        return CardInfoManager.getInstance(this.mContext).recharge(cardInfo);
    }

    public RefundInfo refund(String str) throws AuthApiException {
        return this.mTSMAuthManager.refund(this.mContext, str);
    }

    public void release() {
        this.mSubscriptions.unsubscribe();
        this.mCardManager.a();
    }

    public BaseResponse retryOrder(CardInfo cardInfo, String str) {
        OrderDetailInfo orderDetailInfo;
        StringBuilder sb;
        BaseResponse baseResponse = new BaseResponse(-1, new Object[0]);
        try {
            orderDetailInfo = getOrderDetail(cardInfo, str);
        } catch (Exception e) {
            LogUtils.e("retryOrder failed, orderId:".concat(String.valueOf(str)), e);
            orderDetailInfo = null;
        }
        if (orderDetailInfo == null || !orderDetailInfo.canRetry()) {
            return baseResponse;
        }
        boolean z = true;
        if (orderDetailInfo.isIssueOrWithdrawOrder()) {
            Bundle bundle = new Bundle();
            ActionToken issueOrWithdrawOrderToken = orderDetailInfo.getUnfinishedOrder().getIssueOrWithdrawOrderToken();
            if (issueOrWithdrawOrderToken != null) {
                bundle.putString("authentication_code", issueOrWithdrawOrderToken.mToken);
                if (cardInfo.hasTransferInOrder()) {
                    baseResponse = CardInfoManager.getInstance(this.mContext).transferIn(cardInfo, bundle);
                    sb = new StringBuilder("retryOrder transferIn called! resultCode: ");
                } else {
                    baseResponse = CardInfoManager.getInstance(this.mContext).issue(cardInfo, bundle);
                    sb = new StringBuilder("retryOrder issue called! resultCode: ");
                }
                sb.append(baseResponse.mResultCode);
                sb.append(", responseDesc:");
                sb.append(baseResponse.mMsg);
                LogUtils.d(sb.toString());
                if (baseResponse.mResultCode != 0) {
                    z = false;
                }
            }
        }
        if (!z || !orderDetailInfo.isRechargeOrder() || !(cardInfo instanceof PayableCardInfo)) {
            return baseResponse;
        }
        ((PayableCardInfo) cardInfo).updateOrderInfo(orderDetailInfo.getUnfinishedOrder());
        return CardInfoManager.getInstance(this.mContext).recharge(cardInfo);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.IOException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.miui.tsmclient.seitsm.a.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.io.IOException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.IOException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.InterruptedException} */
    /* JADX WARNING: Multi-variable type inference failed */
    public BaseResponse syncEse(CardInfo cardInfo) {
        InterruptedException interruptedException;
        String str;
        int i;
        d dVar = new d();
        String str2 = "";
        try {
            return dVar.a(this.mContext, cardInfo, dVar.a(this.mContext, cardInfo, (h.a) null), (Bundle) null);
        } catch (IOException e) {
            i = 2;
            str = "sync Ese failed with an io exception.";
            interruptedException = e;
            LogUtils.e(str, interruptedException);
            return new BaseResponse(i, str2, new Object[0]);
        } catch (com.miui.tsmclient.seitsm.a.a e2) {
            i = e2.a();
            str2 = e2.getMessage();
            str = "sync Ese failed with an tsmapi exception.";
            interruptedException = e2;
            LogUtils.e(str, interruptedException);
            return new BaseResponse(i, str2, new Object[0]);
        } catch (InterruptedException e3) {
            i = 11;
            str = "sync Ese is interrupted.";
            interruptedException = e3;
            LogUtils.e(str, interruptedException);
            return new BaseResponse(i, str2, new Object[0]);
        }
    }

    public BaseResponse updateCard(CardInfo cardInfo) {
        return CardInfoManager.getInstance(this.mContext).updateCards(cardInfo);
    }

    public void updateCardOrder(CardInfo cardInfo) throws AuthApiException {
        List<OrderInfo> cardOrderList;
        if ((cardInfo instanceof PayableCardInfo) && (cardOrderList = this.mTransitCardModel.getCardOrderList(cardInfo)) != null) {
            ((PayableCardInfo) cardInfo).mUnfinishOrderInfos = cardOrderList;
        }
    }

    public void updateTransitCardListFromLocal(List<CardInfo> list, final CardListListener cardListListener) {
        if (list != null) {
            this.mSubscriptions.add(Observable.from(list).map(new Func1<CardInfo, CardInfo>() {
                /* class com.miui.tsmclient.Facade.AnonymousClass10 */

                public CardInfo call(CardInfo cardInfo) {
                    CardInfo transCard = CardInfoManager.getInstance(Facade.this.mContext).getTransCard(null, cardInfo);
                    if (transCard == null || !transCard.mIsReadSECorrectly) {
                        CardInfoManager.getInstance(Facade.this.mContext).updateCards(cardInfo);
                    } else {
                        cardInfo.updateInfo(transCard);
                        cardInfo.mDataSource = CardInfo.DataSource.DB;
                    }
                    return cardInfo;
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new SimpleSubscriber<CardInfo>("updateFromLocal error occurred") {
                /* class com.miui.tsmclient.Facade.AnonymousClass9 */

                public void onCompleted() {
                    LogUtils.d("updateFromLocal complete");
                    CardListListener cardListListener = cardListListener;
                    if (cardListListener != null) {
                        cardListListener.onUpdateCardListCompleted();
                    }
                }

                public void onNext(CardInfo cardInfo) {
                    CardListListener cardListListener = cardListListener;
                    if (cardListListener != null) {
                        cardListListener.onCardUpdated(cardInfo);
                    }
                }
            }));
        }
    }
}
