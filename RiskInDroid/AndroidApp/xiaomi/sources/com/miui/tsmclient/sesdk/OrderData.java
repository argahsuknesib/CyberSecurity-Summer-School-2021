package com.miui.tsmclient.sesdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.entity.ActionToken;
import com.miui.tsmclient.entity.CardGroupType;
import com.miui.tsmclient.entity.CardInfoFactory;
import com.miui.tsmclient.entity.CouponInfo;
import com.miui.tsmclient.entity.FeeInfo;
import com.miui.tsmclient.entity.OrderDetailInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.entity.RechargeOrderInfo;
import com.miui.tsmclient.entity.RechargeOrderResponseInfo;
import com.miui.tsmclient.entity.RefundInfo;
import com.miui.tsmclient.entity.a;
import com.miui.tsmclient.entity.b;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.TSMAuthManager;
import com.miui.tsmclient.net.request.RechargeOrderListRequest;
import com.miui.tsmclient.net.request.e;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.TSMLocationService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderData {
    private String mCaptcha;
    private SeCard mCard;
    private Fee mFee;
    private String mPayChannel;
    private String mPhoneNum;
    private int mServiceFee;
    private TSMAuthManager mTSMAuthManager = new TSMAuthManager();

    public static class Coupon {
        private a mCouponDetail;
        public CouponInfo mCouponInfo;

        private Coupon(CouponInfo couponInfo) {
            this.mCouponInfo = couponInfo;
            this.mCouponDetail = a.a(this.mCouponInfo.getExtra());
        }

        public String getDiscountAmount() {
            return this.mCouponDetail.c();
        }

        public String getDiscountDesc() {
            return this.mCouponDetail.d();
        }

        public String getExpireDesc() {
            return this.mCouponDetail.b();
        }

        public String getTitle() {
            return this.mCouponDetail.a();
        }

        public boolean isHighLight() {
            return this.mCouponDetail.e();
        }

        public boolean isValid() {
            return this.mCouponInfo.isValid();
        }
    }

    public static class CouponList {
        private List<Coupon> mList;

        private CouponList(List<Coupon> list) {
            this.mList = list;
        }

        public List<Coupon> getList() {
            return this.mList;
        }

        public boolean isEmpty() {
            List<Coupon> list = this.mList;
            return list != null && list.isEmpty();
        }
    }

    public static class Fee {
        public FeeInfo mFeeInfo;

        private Fee(FeeInfo feeInfo) {
            this.mFeeInfo = feeInfo;
        }

        public int getRechargeFee() {
            return this.mFeeInfo.getRechargeFee();
        }

        public int getServiceFee() {
            return this.mFeeInfo.getDiscountIssueFee();
        }

        public int getTotalPay() {
            return this.mFeeInfo.getDiscountPayFee();
        }

        public boolean isSuggested() {
            return this.mFeeInfo.isSuggested();
        }
    }

    public static class FeeList {
        private List<Fee> mList;

        private FeeList(List<Fee> list) {
            this.mList = list;
        }

        public List<Fee> getList() {
            return this.mList;
        }

        public boolean isEmpty() {
            List<Fee> list = this.mList;
            return list != null && list.isEmpty();
        }
    }

    public static class Order {
        private SeCard mCard;
        private OrderInfo mOrderInfo;

        private Order(OrderInfo orderInfo, SeCard seCard) {
            this.mOrderInfo = orderInfo;
            this.mCard = seCard;
            this.mCard.setCityId(this.mOrderInfo.mCityId);
        }

        public String getCityId() {
            return this.mOrderInfo.mCityId;
        }

        @Deprecated
        public String getIssueToken() {
            if (this.mOrderInfo.mActionTokens == null) {
                return null;
            }
            for (ActionToken next : this.mOrderInfo.mActionTokens) {
                if (next.isIssueType()) {
                    return next.mToken;
                }
            }
            return null;
        }

        public String getOrderId() {
            return this.mOrderInfo.mOrderId;
        }

        public int getPayFee() {
            return this.mOrderInfo.mPayFee;
        }

        public String getPayString() {
            return this.mOrderInfo.mPayExtra;
        }

        @Deprecated
        public String getRechargeToken() {
            if (this.mOrderInfo.mActionTokens == null) {
                return null;
            }
            for (ActionToken next : this.mOrderInfo.mActionTokens) {
                if (next.isRechargeType()) {
                    return next.mToken;
                }
            }
            return null;
        }

        public String getToken() {
            if (this.mOrderInfo.mActionTokens == null) {
                return null;
            }
            for (ActionToken next : this.mOrderInfo.mActionTokens) {
                if (!this.mCard.isIssued()) {
                    if (next.isIssueType() || next.isWithdrawType()) {
                        return next.mToken;
                    }
                } else if (next.isRechargeType()) {
                    return next.mToken;
                }
            }
            return null;
        }

        @Deprecated
        public String getTransferInToken() {
            if (this.mOrderInfo.mActionTokens == null) {
                return null;
            }
            for (ActionToken next : this.mOrderInfo.mActionTokens) {
                if (next.isWithdrawType()) {
                    return next.mToken;
                }
            }
            return null;
        }

        public boolean isPaid() {
            return this.mOrderInfo.isPaid();
        }

        public void update() throws AuthApiException {
            this.mOrderInfo = new TSMAuthManager().queryByOrderId(EnvironmentConfig.getContext(), getOrderId());
        }
    }

    public static class OrderList {
        private List<Order> mList;

        private OrderList(List<Order> list) {
            this.mList = list;
        }

        public List<Order> getList() {
            return this.mList;
        }

        public boolean isEmpty() {
            List<Order> list = this.mList;
            return list != null && list.isEmpty();
        }
    }

    public static class OrderRecord {
        private SeCard mCard;
        private RechargeOrderInfo mRecord;

        private OrderRecord(RechargeOrderInfo rechargeOrderInfo, SeCard seCard) {
            this.mRecord = rechargeOrderInfo;
            this.mCard = seCard;
        }

        public int getAmount() {
            return this.mRecord.getAmount();
        }

        public OrderRecordDetail getDetail() throws AuthApiException {
            return new OrderRecordDetail(new TSMAuthManager().getOrderDetailById(EnvironmentConfig.getContext(), this.mCard.mCardInfo, getOrderId()), this.mCard);
        }

        public String getOrderId() {
            return this.mRecord.getOrderId();
        }

        public String getStatusDesc() {
            return this.mRecord.getStatusDesc();
        }

        public String getTime() {
            return this.mRecord.getTime();
        }

        public String getTitle() {
            return this.mRecord.getTitle();
        }
    }

    public static class OrderRecordDetail {
        private SeCard mCard;
        private OrderDetailInfo mDetail;
        private OrderFlowList mOrderFlowList;
        private TSMAuthManager mTSMAuthManager;

        public static class OrderFlow {
            private OrderDetailInfo.OrderFlow mOrderFlow;

            public OrderFlow(OrderDetailInfo.OrderFlow orderFlow) {
                this.mOrderFlow = orderFlow;
            }

            public int getAmount() {
                return this.mOrderFlow.getAmount();
            }

            public String getDesc() {
                return this.mOrderFlow.getDesc();
            }

            public String getKey() {
                return this.mOrderFlow.getKey();
            }

            public String getSubKey() {
                return this.mOrderFlow.getSubKey();
            }

            public String getSubValue() {
                return this.mOrderFlow.getSubValue();
            }

            public String getTime() {
                return this.mOrderFlow.getTime();
            }

            public String getTitle() {
                return this.mOrderFlow.getTitle();
            }

            public String getValue() {
                return this.mOrderFlow.getValue();
            }
        }

        public static class OrderFlowList {
            private List<OrderFlow> mList;

            private OrderFlowList(List<OrderFlow> list) {
                this.mList = list;
            }

            public List<OrderFlow> getList() {
                return this.mList;
            }

            public boolean isEmpty() {
                List<OrderFlow> list = this.mList;
                return list != null && list.isEmpty();
            }
        }

        private OrderRecordDetail(OrderDetailInfo orderDetailInfo, SeCard seCard) {
            this.mDetail = orderDetailInfo;
            this.mCard = seCard;
            this.mTSMAuthManager = new TSMAuthManager();
        }

        public String getCardType() {
            return this.mDetail.getCardType();
        }

        public String getHint() {
            return this.mDetail.getHint();
        }

        public OrderFlowList getOrderFlows() {
            OrderFlowList orderFlowList = this.mOrderFlowList;
            if (orderFlowList != null) {
                return orderFlowList;
            }
            ArrayList arrayList = new ArrayList();
            List<OrderDetailInfo.OrderFlow> orderFlows = this.mDetail.getOrderFlows();
            if (orderFlows != null) {
                for (OrderDetailInfo.OrderFlow orderFlow : orderFlows) {
                    arrayList.add(new OrderFlow(orderFlow));
                }
            }
            this.mOrderFlowList = new OrderFlowList(arrayList);
            return this.mOrderFlowList;
        }

        public String getOrderId() {
            return this.mDetail.getOrderId();
        }

        public String getRefundDesc() {
            return this.mDetail.getRefundDesc();
        }

        public int getStatus() {
            return this.mDetail.getStatus();
        }

        public String getStatusDesc() {
            return this.mDetail.getStatusDesc();
        }

        public String getTime() {
            return this.mDetail.getTime();
        }

        public boolean isCanRefund() {
            return this.mDetail.canRefund();
        }

        public boolean isCanRetry() {
            return this.mDetail.canRetry() && this.mDetail.getUnfinishedOrder() != null;
        }

        public boolean isRefundSuccess() {
            return this.mDetail.isRefundSuccess();
        }

        public boolean isSuccess() {
            return this.mDetail.isSuccess();
        }

        public RefundInfo refund() throws AuthApiException {
            if (isCanRefund()) {
                if (this.mDetail.isSyncBeforeRefund()) {
                    RefundInfo refundInfo = new RefundInfo();
                    Bundle bundle = new Bundle();
                    bundle.putString("orderId", getOrderId());
                    bundle.putString("spOrderId", this.mDetail.getSpOrderId());
                    BaseResponse h = this.mCard.mCardOperation.h(EnvironmentConfig.getContext(), this.mCard.mCardInfo, bundle);
                    if (!h.isSuccess()) {
                        refundInfo.setResponseCode(Integer.toString(h.mResultCode));
                        refundInfo.setResponseDesc(h.mMsg);
                        return refundInfo;
                    }
                }
                return this.mTSMAuthManager.refund(EnvironmentConfig.getContext(), getOrderId());
            }
            throw new IllegalStateException("refund is not available");
        }

        public BaseResponse retryOrder() {
            if (isCanRetry()) {
                BaseResponse baseResponse = new BaseResponse(0, new Object[0]);
                Order order = new Order(this.mDetail.getUnfinishedOrder(), this.mCard);
                if (order.getTransferInToken() != null) {
                    baseResponse = this.mCard.transferIn(order.getTransferInToken());
                } else if (order.getIssueToken() != null) {
                    baseResponse = this.mCard.issue(order.getIssueToken());
                }
                return (!baseResponse.isSuccess() || order.getRechargeToken() == null) ? baseResponse : this.mCard.recharge(order.getRechargeToken());
            }
            throw new IllegalStateException("The order can not be retried");
        }

        public void update() throws AuthApiException {
            this.mDetail = this.mTSMAuthManager.getOrderDetailById(EnvironmentConfig.getContext(), this.mCard.mCardInfo, getOrderId());
        }
    }

    public static class OrderRecordList {
        private List<OrderRecord> mList;

        private OrderRecordList(List<OrderRecord> list) {
            this.mList = list;
        }

        public List<OrderRecord> getList() {
            return this.mList;
        }

        public boolean isEmpty() {
            List<OrderRecord> list = this.mList;
            return list != null && list.isEmpty();
        }
    }

    public OrderData(SeCard seCard, int i) {
        this.mCard = seCard;
        this.mServiceFee = i;
    }

    public Order createOrder() throws AuthApiException {
        Fee fee = this.mFee;
        if (fee != null) {
            FeeInfo feeInfo = fee.mFeeInfo;
            Bundle bundle = new Bundle();
            bundle.putString("payChannel", TextUtils.isEmpty(this.mPayChannel) ? "UCashier" : this.mPayChannel);
            CouponInfo couponInfo = feeInfo.getCouponInfo();
            if (couponInfo != null && couponInfo.isValid()) {
                bundle.putLong("couponId", couponInfo.getCouponId());
            }
            if (!TextUtils.isEmpty(this.mPhoneNum)) {
                bundle.putString("phone", this.mPhoneNum);
            }
            if (!TextUtils.isEmpty(this.mCaptcha)) {
                bundle.putString("captcha", this.mCaptcha);
            }
            bundle.putAll(feeInfo.getCustomFeeExtra(new PayableCardInfo("DUMMY")));
            JSONObject createOrder = this.mTSMAuthManager.createOrder(EnvironmentConfig.getContext(), feeInfo.mId, CardInfoFactory.makeCardInfo("DUMMY", null), bundle);
            if (createOrder == null) {
                return null;
            }
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.parse(createOrder);
            LogUtils.d("order create success, orderId:" + orderInfo.mOrderId);
            return new Order(orderInfo, this.mCard);
        }
        throw new IllegalStateException("fee is null on createOrder");
    }

    public CouponList getCouponList() throws AuthApiException {
        if (this.mFee != null) {
            ArrayList arrayList = new ArrayList();
            FeeInfo feeInfo = this.mFee.mFeeInfo;
            PayableCardInfo payableCardInfo = new PayableCardInfo("DUMMY");
            try {
                b bVar = (b) HttpClient.getInstance(EnvironmentConfig.getContext()).execute(new e(EnvironmentConfig.getContext(), payableCardInfo, feeInfo, feeInfo.getCustomFeeExtra(payableCardInfo), null)).getResult();
                if (bVar.isSuccess()) {
                    List<CouponInfo> a2 = bVar.a();
                    if (a2 == null) {
                        return new CouponList(arrayList);
                    }
                    for (CouponInfo coupon : a2) {
                        arrayList.add(new Coupon(coupon));
                    }
                    return new CouponList(arrayList);
                }
                throw new AuthApiException(bVar.getErrorCode(), bVar.getErrorDesc());
            } catch (IOException unused) {
                throw new AuthApiException(2);
            }
        } else {
            throw new IllegalStateException("fee is null on getCouponList");
        }
    }

    public FeeList getFeeList() throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        FeeInfo.ActionType[] actionTypeArr = this.mCard.isIssued() ? new FeeInfo.ActionType[]{FeeInfo.ActionType.recharge} : new FeeInfo.ActionType[]{FeeInfo.ActionType.issue, FeeInfo.ActionType.issueAndRecharge};
        try {
            JSONArray queryCardProduct = this.mTSMAuthManager.queryCardProduct(EnvironmentConfig.getContext(), CardGroupType.TRANSCARD, this.mCard.getId(), TSMLocationService.getInstance(EnvironmentConfig.getContext()).getLastLocation());
            if (queryCardProduct != null) {
                if (queryCardProduct.length() > 0) {
                    JSONArray jSONArray = queryCardProduct.getJSONObject(0).getJSONArray("fees");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        FeeInfo feeInfo = new FeeInfo();
                        feeInfo.parse(jSONObject);
                        if (Arrays.asList(actionTypeArr).contains(feeInfo.mActionType)) {
                            arrayList.add(new Fee(feeInfo));
                        }
                    }
                    return new FeeList(arrayList);
                }
            }
            return new FeeList(null);
        } catch (JSONException e) {
            LogUtils.e("failed to get cards on network!", e);
            throw new AuthApiException(16);
        }
    }

    public OrderRecordList getOrderRecordList() throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        try {
            RechargeOrderResponseInfo rechargeOrderResponseInfo = (RechargeOrderResponseInfo) HttpClient.getInstance(EnvironmentConfig.getContext()).execute(new RechargeOrderListRequest(this.mCard.mCardInfo, null)).getResult();
            if (rechargeOrderResponseInfo.isSuccess()) {
                List<RechargeOrderInfo> rechargeOrderInfoList = rechargeOrderResponseInfo.getRechargeOrderInfoList();
                if (rechargeOrderInfoList == null) {
                    return new OrderRecordList(arrayList);
                }
                for (RechargeOrderInfo orderRecord : rechargeOrderInfoList) {
                    arrayList.add(new OrderRecord(orderRecord, this.mCard));
                }
                return new OrderRecordList(arrayList);
            }
            throw new AuthApiException(rechargeOrderResponseInfo.getErrorCode(), rechargeOrderResponseInfo.getErrorDesc());
        } catch (IOException unused) {
            throw new AuthApiException(2);
        }
    }

    public List<String> getPayChannelList() {
        SeCard seCard = this.mCard;
        return (seCard == null || !(seCard.mCardInfo instanceof PayableCardInfo)) ? Collections.EMPTY_LIST : ((PayableCardInfo) this.mCard.mCardInfo).getPaymentChannels();
    }

    public OrderList getPendingOrderList() throws AuthApiException {
        ArrayList arrayList = new ArrayList();
        JSONArray queryByUserId = this.mTSMAuthManager.queryByUserId(EnvironmentConfig.getContext());
        if (queryByUserId == null) {
            return new OrderList(null);
        }
        for (int i = 0; i < queryByUserId.length(); i++) {
            OrderInfo orderInfo = new OrderInfo();
            try {
                orderInfo.parse(queryByUserId.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.mCard.getId().equals(orderInfo.mCardType)) {
                arrayList.add(new Order(orderInfo, this.mCard));
            }
        }
        return new OrderList(arrayList);
    }

    public int getServiceFee() {
        return this.mServiceFee;
    }

    public void setCaptcha(String str) {
        this.mCaptcha = str;
    }

    public void setCoupon(Coupon coupon) {
        Fee fee = this.mFee;
        if (fee != null) {
            fee.mFeeInfo.setCouponInfo(coupon == null ? null : coupon.mCouponInfo);
            return;
        }
        throw new IllegalStateException("fee is null on setCoupon");
    }

    public void setFee(Fee fee) {
        Fee fee2 = this.mFee;
        if (fee2 != null) {
            fee2.mFeeInfo.setCouponInfo(null);
        }
        this.mFee = fee;
    }

    public void setPayChannel(String str) {
        this.mPayChannel = str;
    }

    public void setPhoneNum(String str) {
        this.mPhoneNum = str;
    }
}
