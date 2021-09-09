package com.mibi.sdk.network;

import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import java.net.URL;
import org.json.JSONObject;

public interface Connection {
    SortedParameter getParameter();

    JSONObject getResponse();

    int getResponseCode();

    String getStringResponse();

    URL getUrl();

    JSONObject requestJSON() throws PaymentException;

    String requestString() throws PaymentException;

    void setNeedGzipRequest(boolean z);

    void setUseGet(boolean z);
}
