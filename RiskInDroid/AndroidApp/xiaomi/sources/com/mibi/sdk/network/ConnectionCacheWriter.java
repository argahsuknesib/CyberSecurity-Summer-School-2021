package com.mibi.sdk.network;

import com.mibi.sdk.common.Coder;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.session.Session;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionCacheWriter implements Connection {
    private Connection mConnection;
    private Session mSession;

    public ConnectionCacheWriter(Connection connection, Session session) {
        this.mConnection = connection;
        this.mSession = session;
    }

    public static String connect(String str, String str2) {
        return Utils.join(str, str2);
    }

    public JSONObject getResponse() {
        return this.mConnection.getResponse();
    }

    public String getStringResponse() {
        return this.mConnection.getStringResponse();
    }

    public int getResponseCode() {
        return this.mConnection.getResponseCode();
    }

    public SortedParameter getParameter() {
        return this.mConnection.getParameter();
    }

    public void setUseGet(boolean z) {
        this.mConnection.setUseGet(z);
    }

    public void setNeedGzipRequest(boolean z) {
        this.mConnection.setNeedGzipRequest(z);
    }

    public JSONObject requestJSON() throws PaymentException {
        int i;
        JSONObject requestJSON = this.mConnection.requestJSON();
        try {
            i = requestJSON.getInt("errcode");
        } catch (JSONException unused) {
            i = 0;
        }
        if (i == 200) {
            this.mSession.getUserStorage().write(Coder.encodeMD5(this.mConnection.getUrl().toString()), requestJSON.toString());
        }
        return requestJSON;
    }

    public String requestString() throws PaymentException {
        return this.mConnection.requestString();
    }

    public URL getUrl() {
        return this.mConnection.getUrl();
    }
}
