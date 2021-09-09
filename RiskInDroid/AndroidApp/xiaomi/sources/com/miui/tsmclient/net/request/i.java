package com.miui.tsmclient.net.request;

import android.content.Context;
import android.location.Location;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.TravelInfo;
import com.miui.tsmclient.util.DeviceUtils;
import java.io.IOException;

public class i extends SecureRequest<a> {

    /* renamed from: a  reason: collision with root package name */
    private CardInfo f3892a;

    public static final class a extends CommonResponseInfo {
        @SerializedName("data")

        /* renamed from: a  reason: collision with root package name */
        private TravelInfo f3893a;

        public final TravelInfo a() {
            return this.f3893a;
        }
    }

    public i(Context context, String str, String str2, CardInfo cardInfo, Location location, ResponseListener<a> responseListener) {
        super(1, "api/%s/spcard/queryCardSiteInfo", a.class, responseListener);
        this.f3892a = cardInfo;
        addParams("aid", str);
        addParams("hciContent", str2);
        addParams("deviceId", DeviceUtils.getDeviceId(context, cardInfo));
        if (location != null) {
            addParams("la", String.valueOf(location.getLatitude()));
            addParams("lo", String.valueOf(location.getLongitude()));
        }
    }

    public void addExtraParams() throws IOException {
        try {
            addParams("cplc", this.f3892a.getTerminal().getCPLC());
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("QueryCouponsRequest getExtraParams failed", e);
        }
    }
}
