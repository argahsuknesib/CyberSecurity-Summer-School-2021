package com.xiaomi.passport.uicontroller;

import com.xiaomi.accountsdk.futureservice.ClientFuture;

public abstract class UIControllerFuture<ModelDataType, UIDataType> extends ClientFuture<ModelDataType, UIDataType> {

    public interface O000000o<UIDataType> extends ClientFuture.ClientCallback<UIDataType> {
    }

    /* access modifiers changed from: protected */
    public abstract UIDataType convertModelDataToUIData(Object obj) throws Throwable;

    protected UIControllerFuture(O000000o<UIDataType> o000000o) {
        super(o000000o);
    }

    public final UIDataType convertServerDataToClientData(ModelDataType modeldatatype) throws Throwable {
        return convertModelDataToUIData(modeldatatype);
    }
}
