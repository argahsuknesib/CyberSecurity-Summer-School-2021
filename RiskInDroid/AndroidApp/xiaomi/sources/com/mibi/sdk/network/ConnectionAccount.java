package com.mibi.sdk.network;

import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.Coder;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.network.ConnectionDefault;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TreeMap;

public class ConnectionAccount extends ConnectionDefault {
    private String mSecurity;
    private String mServiceToken;
    private String mUserId;

    ConnectionAccount(String str, String str2, String str3, String str4) {
        super(str);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            throw new IllegalArgumentException("account detail is empty");
        }
        this.mUserId = str2;
        this.mSecurity = str3;
        this.mServiceToken = str4;
    }

    public String requestString() throws PaymentException {
        super.requestString();
        this.mString = Coder.decodeAES(this.mString, this.mSecurity);
        if (this.mString != null) {
            return this.mString;
        }
        throw new ResultException("requestString error, decode failed");
    }

    /* access modifiers changed from: protected */
    public ConnectionDefault.Parameter onQueryCreated(ConnectionDefault.Parameter parameter) {
        return new EncryptParameter(parameter, this.mSecurity);
    }

    /* access modifiers changed from: protected */
    public boolean checkURL(URL url) {
        if (!TextUtils.isEmpty(url.getQuery())) {
            return false;
        }
        return super.checkURL(url);
    }

    /* access modifiers changed from: protected */
    public URL onURLCreated(URL url, ConnectionDefault.Parameter parameter) {
        String str;
        String str2;
        String path = url.getPath();
        String query = url.getQuery();
        String url2 = url.toString();
        try {
            str = URLEncoder.encode(genSignature(this.mUseGet ? "GET" : "POST", path, parameter.getParams(), this.mSecurity), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("ConnectionAccount", "generate signature error :".concat(String.valueOf(e)));
            str = "";
        }
        if (TextUtils.isEmpty(query)) {
            str2 = url2 + "?signature=" + str;
        } else {
            str2 = url2 + "&signature=" + str;
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection onConnectionCreated(HttpURLConnection httpURLConnection) {
        StringBuilder sb = new StringBuilder();
        sb.append("userId=" + this.mUserId);
        sb.append("; ");
        sb.append("serviceToken=" + this.mServiceToken);
        httpURLConnection.setRequestProperty("Cookie", sb.toString());
        return httpURLConnection;
    }

    private String genSignature(String str, String str2, TreeMap<String, Object> treeMap, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str.toUpperCase(Locale.getDefault()));
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (treeMap != null && !treeMap.isEmpty()) {
            for (String next : treeMap.keySet()) {
                String obj = treeMap.get(next).toString();
                if (!TextUtils.isEmpty(obj)) {
                    arrayList.add(String.format("%s=%s", next, obj));
                }
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3);
        }
        return genSHASignature(TextUtils.join("&", arrayList));
    }

    private String genSHASignature(String str) {
        byte[] encodeSHABytes = Coder.encodeSHABytes(str);
        if (encodeSHABytes == null) {
            return null;
        }
        return Coder.encodeBase64(encodeSHABytes);
    }

    class EncryptParameter extends ConnectionDefault.Parameter {
        EncryptParameter(ConnectionDefault.Parameter parameter, String str) {
            super();
            if (!parameter.isEmpty()) {
                TreeMap<String, Object> params = parameter.getParams();
                for (String next : params.keySet()) {
                    String obj = params.get(next).toString();
                    if (!TextUtils.isEmpty(obj)) {
                        String encodeAES = Coder.encodeAES(obj, str);
                        if (!TextUtils.isEmpty(encodeAES)) {
                            add(next, encodeAES);
                        }
                    }
                }
            }
        }
    }
}
