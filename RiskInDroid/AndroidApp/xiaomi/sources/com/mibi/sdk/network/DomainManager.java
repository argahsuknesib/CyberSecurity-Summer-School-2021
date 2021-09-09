package com.mibi.sdk.network;

import android.text.TextUtils;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.account.loader.MiAccountLoader;
import com.mibi.sdk.common.exception.NotConnectedException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.exception.ServiceTokenExpiredException;
import com.mibi.sdk.common.session.Session;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class DomainManager {
    private static String KEY_DOMAIN_LOCK = "domainLock";

    public static void updateDomainByAccount(Session session) throws PaymentException {
        if (session != null) {
            synchronized (session.getLock(KEY_DOMAIN_LOCK)) {
                updateServer(session, updateHostAndServiceId(session, null, null));
            }
            return;
        }
        throw new IllegalArgumentException("Session should not be null in updateHostAndServiceId");
    }

    public static void updateDomainByOrder(Session session, String str, String str2) throws PaymentException {
        if (session != null) {
            synchronized (session.getLock(KEY_DOMAIN_LOCK)) {
                updateServer(session, updateHostAndServiceId(session, str, str2));
            }
            return;
        }
        throw new IllegalArgumentException("Session should not be null in updateHostAndServiceId");
    }

    private static DomainParam updateHostAndServiceId(Session session, String str, String str2) throws PaymentException {
        Connection connection;
        DomainParam domainParam = (DomainParam) session.getMemoryStorage().getSerializable("domainParam");
        if (domainParam != null && !TextUtils.isEmpty(domainParam.mHost) && !TextUtils.isEmpty(domainParam.mServiceId)) {
            return domainParam;
        }
        updateServer(session, new DomainParam(CommonConstants.URL_BASE_DEFAULT, CommonConstants.SERVICE_ID_DEFAULT));
        if (session.getAccountLoader() instanceof MiAccountLoader) {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("domain"), session);
        } else {
            connection = ConnectionFactory.createNoAccountConnection(session.getAppContext(), CommonConstants.getUrl(session.getMemoryStorage().getBoolean("isPartnerAccount") ? "/partner/domain" : "/na/domain"));
        }
        if (!TextUtils.isEmpty(str)) {
            connection.getParameter().add("order", str);
        } else if (!TextUtils.isEmpty(str2)) {
            connection.getParameter().add("orderQrUrl", str2);
        }
        try {
            JSONObject requestJSON = connection.requestJSON();
            try {
                if (requestJSON.getInt("errcode") != 1984) {
                    try {
                        String string = requestJSON.getString("domain");
                        String string2 = requestJSON.getString("serviceId");
                        if (Utils.checkStrings(string, string2)) {
                            try {
                                new URL(string);
                                return new DomainParam(string, string2);
                            } catch (MalformedURLException e) {
                                throw new ResultException(e);
                            }
                        } else {
                            throw new ResultException("baseUrl or serviceId should not be empty!");
                        }
                    } catch (JSONException e2) {
                        throw new ResultException("domain content not exists", e2);
                    }
                } else {
                    throw new ServiceTokenExpiredException();
                }
            } catch (JSONException e3) {
                throw new ResultException("error code not exists", e3);
            }
        } catch (NotConnectedException e4) {
            throw e4;
        } catch (PaymentException e5) {
            session.getMemoryStorage().remove("domainParam");
            updateServer(session, new DomainParam(CommonConstants.URL_BASE_DEFAULT, CommonConstants.SERVICE_ID_DEFAULT));
            throw e5;
        }
    }

    private static void updateServer(Session session, DomainParam domainParam) throws PaymentException {
        if (!(session.getAccountLoader() instanceof MiAccountLoader)) {
            CommonConstants.setServer(domainParam.mHost, domainParam.mServiceId);
        } else if (!TextUtils.equals(CommonConstants.URL_BASE, domainParam.mHost) || !TextUtils.equals(CommonConstants.SERVICE_ID, domainParam.mServiceId)) {
            CommonConstants.setServer(domainParam.mHost, domainParam.mServiceId);
            session.reload(session.getAppContext());
        } else {
            CommonConstants.setServer(domainParam.mHost, domainParam.mServiceId);
        }
        session.getMemoryStorage().put("domainParam", domainParam);
    }

    public static class DomainParam implements Serializable {
        public final String mHost;
        public final String mServiceId;

        public DomainParam(String str, String str2) {
            this.mHost = str;
            this.mServiceId = str2;
        }
    }
}
