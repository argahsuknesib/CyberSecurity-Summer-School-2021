package com.mibi.sdk.task;

import android.content.Context;
import android.util.Log;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.exception.NotConnectedException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.exception.ServerErrorCodeException;
import com.mibi.sdk.common.exception.ServiceTokenExpiredException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.privacy.PrivacyManager;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.network.DeviceManager;
import com.mibi.sdk.network.DomainManager;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class RxBasePaymentTask<R> extends RxTask<R> {
    private boolean mCacheReadEnabled;
    private boolean mCacheWriteEnabled;
    protected Context mContext;
    private SortedParameter mParams;
    protected Session mSession;

    /* access modifiers changed from: protected */
    public abstract Connection getConnection(SortedParameter sortedParameter);

    /* access modifiers changed from: protected */
    public void parseResultInCommon(JSONObject jSONObject, R r) throws PaymentException {
    }

    /* access modifiers changed from: protected */
    public boolean parseResultInError(JSONObject jSONObject, R r) throws PaymentException {
        return false;
    }

    /* access modifiers changed from: protected */
    public void parseResultInSuccess(JSONObject jSONObject, R r) throws PaymentException {
    }

    public RxBasePaymentTask(Context context, Session session, Class<R> cls) {
        super(cls);
        this.mContext = context;
        this.mSession = session;
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.mContext;
    }

    public void setParams(SortedParameter sortedParameter) {
        if (sortedParameter == null) {
            sortedParameter = new SortedParameter();
        }
        this.mParams = sortedParameter;
    }

    /* access modifiers changed from: protected */
    public void setCacheWriteEnabled(boolean z) {
        this.mCacheWriteEnabled = z;
    }

    public void setCacheReadEnabled(boolean z) {
        this.mCacheReadEnabled = z;
    }

    public boolean isReadingFromCache() {
        return this.mCacheReadEnabled;
    }

    /* access modifiers changed from: protected */
    public void doLoad(R r) throws PaymentException {
        if (Utils.isConnected(this.mContext) || this.mCacheReadEnabled) {
            this.mSession.load(this.mContext);
            try {
                connect(this.mParams, r);
            } catch (ServiceTokenExpiredException e) {
                Log.e("BasePaymentTask", "service token expired, re-login exception ", e);
                this.mSession.reload(this.mContext);
                connect(this.mParams, r);
            }
        } else {
            throw new NotConnectedException();
        }
    }

    /* access modifiers changed from: protected */
    public void connect(SortedParameter sortedParameter, R r) throws PaymentException {
        Connection connection;
        if (this.mCacheReadEnabled) {
            connection = ConnectionFactory.createCacheReaderConnection(getConnection(sortedParameter), this.mSession);
        } else {
            DomainManager.updateDomainByAccount(this.mSession);
            DeviceManager.uploadDevice(this.mSession);
            PrivacyManager.uploadPrivacy(this.mSession);
            connection = getConnection(sortedParameter);
            if (this.mCacheWriteEnabled) {
                connection = ConnectionFactory.createCacheWriterConnection(connection, this.mSession);
            }
        }
        JSONObject requestJSON = connection.requestJSON();
        parseResultInCommon(requestJSON, r);
        try {
            int i = requestJSON.getInt("errcode");
            String optString = requestJSON.optString("errDesc");
            if (i == 1984) {
                throw new ServiceTokenExpiredException();
            } else if (i != 200) {
                if (CommonConstants.DEBUG) {
                    Log.w("BasePaymentTask", "result error : error code ".concat(String.valueOf(i)));
                    Log.w("BasePaymentTask", "result error : error desc ".concat(String.valueOf(optString)));
                }
                if (!parseResultInError(requestJSON, r)) {
                    throw new ServerErrorCodeException(i, optString, r);
                }
            } else {
                parseResultInSuccess(requestJSON, r);
            }
        } catch (JSONException e) {
            throw new ResultException("error code not exists", e);
        }
    }

    public Session getSession() {
        return this.mSession;
    }
}
