package com.mibi.sdk.task;

import android.content.Context;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.MemoryStorage;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.DeviceManager;

public abstract class RxBasePartnerTask<R> extends RxBasePaymentTask<R> {
    public RxBasePartnerTask(Context context, Session session, Class cls) {
        super(context, session, cls);
    }

    /* access modifiers changed from: protected */
    public void addPartnerParams(Connection connection, String str) {
        MemoryStorage memoryStorage = getSession().getMemoryStorage();
        String string = memoryStorage.getString(str, "partnerAccountId");
        String string2 = memoryStorage.getString(str, "accountType");
        long j = memoryStorage.getLong(str, "marketType");
        SortedParameter parameter = connection.getParameter();
        parameter.add("oaid", Client.getOaid());
        parameter.add("marketType", Long.valueOf(j));
        parameter.add("partnerAccountId", string);
        parameter.add("accountType", string2);
        parameter.add("session", getSession().getUuid());
        parameter.add("deviceId", DeviceManager.getDeviceId(getSession()));
    }

    /* access modifiers changed from: protected */
    public String getPartnerUserId(String str) {
        return getSession().getMemoryStorage().getString(str, "partnerAccountId");
    }
}
