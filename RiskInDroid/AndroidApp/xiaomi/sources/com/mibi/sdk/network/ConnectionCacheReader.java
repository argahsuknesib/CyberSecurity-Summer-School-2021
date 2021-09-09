package com.mibi.sdk.network;

import com.mibi.sdk.common.Coder;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.storage.StorageDir;
import java.net.URL;
import org.json.JSONObject;

public class ConnectionCacheReader implements Connection {
    private Connection mConnection;
    private JSONObject mResponse;
    private int mResponseCode;
    private Session mSession;
    private String mString;
    private URL mUrl;

    public void setNeedGzipRequest(boolean z) {
    }

    public void setUseGet(boolean z) {
    }

    public ConnectionCacheReader(Connection connection, Session session) {
        this.mConnection = connection;
        this.mSession = session;
    }

    public static String connect(String str, String str2) {
        return Utils.join(str, str2);
    }

    public JSONObject getResponse() {
        return this.mResponse;
    }

    public String getStringResponse() {
        return this.mString;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public SortedParameter getParameter() {
        return this.mConnection.getParameter();
    }

    public JSONObject requestJSON() throws PaymentException {
        requestString();
        try {
            this.mResponse = new JSONObject(this.mString);
            return this.mResponse;
        } catch (Exception e) {
            throw new ResultException(e);
        }
    }

    public String requestString() throws PaymentException {
        StorageDir userStorage = this.mSession.getUserStorage();
        String encodeMD5 = Coder.encodeMD5(this.mConnection.getUrl().toString());
        if (userStorage.hasFile(encodeMD5)) {
            this.mString = userStorage.read(encodeMD5);
        } else {
            this.mString = null;
        }
        return this.mString;
    }

    public URL getUrl() {
        return this.mUrl;
    }
}
