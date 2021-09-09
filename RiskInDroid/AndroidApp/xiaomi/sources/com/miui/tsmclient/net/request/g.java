package com.miui.tsmclient.net.request;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.ActionToken;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.util.DeviceUtils;
import java.io.IOException;

public class g extends SecureRequest<com.miui.tsmclient.entity.g> {

    /* renamed from: a  reason: collision with root package name */
    private CardInfo f3891a;

    public g(Context context, PayableCardInfo payableCardInfo, ResponseListener<com.miui.tsmclient.entity.g> responseListener) {
        super(1, "api/%s/transferCard/startTransferIn", com.miui.tsmclient.entity.g.class, responseListener);
        this.f3891a = payableCardInfo;
        addParams("orderId", payableCardInfo.getTransferInOrder().mOrderId).addParams("deviceId", DeviceUtils.getDeviceId(context, payableCardInfo)).addParams("deviceModel", DeviceUtils.getDeviceModel(payableCardInfo));
    }

    public void addExtraParams() throws IOException {
        try {
            addParams("cplc", this.f3891a.getTerminal().getCPLC());
        } catch (IOException | InterruptedException e) {
            throw new IOException("StartTransferInRequest getExtraParams failed", e);
        }
    }

    public Gson getGson() {
        return new GsonBuilder().registerTypeAdapter(OrderInfo.OrderStatus.class, new OrderInfo.OrderStatusDeserializer()).registerTypeAdapter(ActionToken.TokenType.class, new ActionToken.TokenTypeDeserializer()).create();
    }

    public boolean isSuccess() {
        return super.isSuccess() && ((com.miui.tsmclient.entity.g) getResult()).a() != null;
    }
}
