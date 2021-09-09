package com.mibi.sdk.network;

import android.text.TextUtils;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.network.ConnectionDefault;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionPartner extends ConnectionDefault {
    private String mUserId;

    /* access modifiers changed from: protected */
    public ConnectionDefault.Parameter onQueryCreated(ConnectionDefault.Parameter parameter) {
        return parameter;
    }

    ConnectionPartner(String str, String str2) {
        super(str);
        this.mUserId = str2;
    }

    public String requestString() throws PaymentException {
        super.requestString();
        if (this.mString != null) {
            return this.mString;
        }
        throw new ResultException("requestString error, decode failed");
    }

    /* access modifiers changed from: protected */
    public boolean checkURL(URL url) {
        if (!TextUtils.isEmpty(url.getQuery())) {
            return false;
        }
        return super.checkURL(url);
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection onConnectionCreated(HttpURLConnection httpURLConnection) {
        StringBuilder sb = new StringBuilder();
        sb.append("userId=" + this.mUserId);
        sb.append("; ");
        httpURLConnection.setRequestProperty("Cookie", sb.toString());
        return httpURLConnection;
    }
}
