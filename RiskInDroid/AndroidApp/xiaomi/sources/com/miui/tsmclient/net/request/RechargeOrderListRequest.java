package com.miui.tsmclient.net.request;

import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.RechargeOrderResponseInfo;
import java.io.IOException;

public class RechargeOrderListRequest extends SecureRequest<RechargeOrderResponseInfo> {
    private CardInfo mCardInfo;

    public RechargeOrderListRequest(CardInfo cardInfo, ResponseListener<RechargeOrderResponseInfo> responseListener) {
        super(1, "api/%s/sporder/queryTradeOrders", RechargeOrderResponseInfo.class, responseListener);
        this.mCardInfo = cardInfo;
        addParams("cardName", this.mCardInfo.mCardType);
    }

    public void addExtraParams() throws IOException {
        super.addExtraParams();
        try {
            addParams("cplc", this.mCardInfo.getTerminal().getCPLC());
        } catch (IOException | InterruptedException e) {
            throw new IOException("RechargeOrderListRequest getExtraParams failed", e);
        }
    }
}
