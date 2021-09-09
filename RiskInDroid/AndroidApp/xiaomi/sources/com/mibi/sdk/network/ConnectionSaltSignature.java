package com.mibi.sdk.network;

import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.Coder;
import com.mibi.sdk.network.ConnectionDefault;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TreeMap;

public class ConnectionSaltSignature extends ConnectionDefault {
    ConnectionSaltSignature(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    public ConnectionDefault.Parameter onQueryCreated(ConnectionDefault.Parameter parameter) {
        return new NonEmptyParameter(parameter);
    }

    class NonEmptyParameter extends ConnectionDefault.Parameter {
        NonEmptyParameter(ConnectionDefault.Parameter parameter) {
            super();
            if (!parameter.isEmpty()) {
                TreeMap<String, Object> params = parameter.getParams();
                for (String next : params.keySet()) {
                    String obj = params.get(next).toString();
                    if (!TextUtils.isEmpty(obj)) {
                        add(next, obj);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public URL onURLCreated(URL url, ConnectionDefault.Parameter parameter) {
        String str;
        String str2;
        String query = url.getQuery();
        String url2 = url.toString();
        try {
            str = URLEncoder.encode(genSignature(parameter.getParams(), "8007236f-a2d6-4847-ac83-c49395ad6d65"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("ConnectionSaltSignature", "generate signature error :".concat(String.valueOf(e)));
            str = "";
        }
        if (TextUtils.isEmpty(query)) {
            str2 = url2 + "?s=" + str;
        } else {
            str2 = url2 + "&s=" + str;
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private String genSignature(TreeMap<String, Object> treeMap, String str) {
        ArrayList arrayList = new ArrayList();
        if (treeMap != null && !treeMap.isEmpty()) {
            for (String next : treeMap.keySet()) {
                String obj = treeMap.get(next).toString();
                if (!TextUtils.isEmpty(obj)) {
                    arrayList.add(String.format("%s=%s", next, obj));
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        return Coder.encodeMD5(Coder.encodeBase64(TextUtils.join("&", arrayList))).toUpperCase(Locale.getDefault());
    }
}
