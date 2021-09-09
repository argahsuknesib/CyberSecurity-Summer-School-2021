package com.xiaomi.smarthome.uwb.tv.remote;

import _m_j.fde;
import _m_j.fdg;
import _m_j.fdv;
import _m_j.fdw;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsi;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.ibc;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.tv.remote.TVInfo;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TVRemoteApi {
    public static final String TAG = "com.xiaomi.smarthome.uwb.tv.remote.TVRemoteApi";

    public static void tryMediaList(String str, String str2, final fde fde) {
        TreeMap treeMap = new TreeMap();
        StringBuilder sb = new StringBuilder();
        sb.append((int) (System.currentTimeMillis() / 1000));
        treeMap.put("t", sb.toString());
        treeMap.put("channel", "uwb");
        if (!TextUtils.isEmpty(str2)) {
            treeMap.put("ids", str2);
        }
        treeMap.put("ucType", "1");
        treeMap.put("page", "1");
        treeMap.put("pageSize", "32");
        if (!TextUtils.isEmpty(str)) {
            treeMap.put("uid", str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("/api/aux/media/list");
        Set<Map.Entry> entrySet = new TreeMap((SortedMap) treeMap).entrySet();
        for (Map.Entry entry : entrySet) {
            arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
        }
        StringBuilder sb2 = new StringBuilder();
        for (String append : arrayList) {
            sb2.append(append);
        }
        String str3 = TAG;
        UwbLogUtil.w(str3, "UwbLogUtilPlus tryMediaList targetStr: " + sb2.toString());
        String signature = getSignature(sb2.toString(), "96d8b216d7174e3aaaacbeddf40cc53b");
        UwbLogUtil.w(TAG, "UwbLogUtilPlus reqSignature: ".concat(String.valueOf(signature)));
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry2 : entrySet) {
            arrayList2.add(new gsi((String) entry2.getKey(), (String) entry2.getValue()));
        }
        arrayList2.add(new gsi("sign", signature));
        gsj O000000o2 = new gsj.O000000o().O000000o("GET").O00000Oo("http://auxin.tv.mi.com/api/aux/media/list").O000000o(arrayList2).O000000o();
        final AnonymousClass1 r7 = new fdv<TVInfo>() {
            /* class com.xiaomi.smarthome.uwb.tv.remote.TVRemoteApi.AnonymousClass1 */

            public final TVInfo parse(JSONObject jSONObject) {
                TVInfo.TVItem parseTVItem;
                TVInfo tVInfo = new TVInfo();
                tVInfo.medias = new ArrayList();
                tVInfo.uc = new ArrayList();
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("medias");
                    if (optJSONObject2 != null) {
                        JSONArray names = optJSONObject2.names();
                        for (int i = 0; i < names.length(); i++) {
                            try {
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(names.getString(i));
                                if (!(optJSONObject3 == null || (parseTVItem = TVRemoteApi.parseTVItem(optJSONObject3)) == null)) {
                                    tVInfo.medias.add(parseTVItem);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("uc");
                    if (optJSONArray != null) {
                        int min = Math.min(3, optJSONArray.length());
                        for (int i2 = 0; i2 < min; i2++) {
                            TVInfo.TVItem parseTVItem2 = TVRemoteApi.parseTVItem(optJSONArray.optJSONObject(i2));
                            if (parseTVItem2 != null) {
                                tVInfo.uc.add(parseTVItem2);
                            }
                        }
                    }
                }
                return tVInfo;
            }
        };
        gsg.O00000Oo(O000000o2, new gsl() {
            /* class com.xiaomi.smarthome.uwb.tv.remote.TVRemoteApi.AnonymousClass2 */

            public final void onSuccess(Object obj, Response response) {
            }

            public final void processResponse(Response response) {
                try {
                    String string = response.body().string();
                    UwbLogUtil.w(TVRemoteApi.TAG, "UwbLogUtilPlus tryMediaList processResponse: ".concat(String.valueOf(string)));
                    NetResult netResult = new NetResult();
                    netResult.O00000o0 = string;
                    fdw.O000000o().O000000o(netResult, r7, fde);
                } catch (Exception e) {
                    e.printStackTrace();
                    fde.onFailure(new fdg(-901, "response error"));
                }
            }

            public final void processFailure(Call call, IOException iOException) {
                fde.onFailure(new fdg(-900, "network error"));
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                fde.onFailure(new fdg(gsf.O000000o(), gsf.O00000Oo()));
            }
        });
    }

    public static String getSignature(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            return ibc.O000000o(instance.doFinal(str.getBytes()));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    protected static void setCookie(CookieManager cookieManager, String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            cookieManager.setCookie(str3, str + "=" + str2 + ";path=/;domain=" + str3);
            String str4 = TAG;
            UwbLogUtil.w(str4, "UwbLogUtilPlus setCookie: domain: " + str3 + " ;name: " + str + " ;value: " + str2);
        }
    }

    protected static TVInfo.TVItem parseTVItem(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        TVInfo.TVItem tVItem = new TVInfo.TVItem();
        tVItem.id = jSONObject.optInt("id");
        tVItem.source = jSONObject.optInt("source");
        tVItem.mediatype = jSONObject.optInt("mediatype");
        tVItem.poster = jSONObject.optString("poster");
        tVItem.title = jSONObject.optString("title");
        tVItem.extra = new TVInfo.Extra();
        JSONObject optJSONObject = jSONObject.optJSONObject("extra");
        if (optJSONObject != null) {
            tVItem.extra.status_text = optJSONObject.optString("status_text");
            tVItem.extra.ci = optJSONObject.optInt("ci");
            tVItem.extra.seconds = (long) optJSONObject.optInt("seconds");
            tVItem.extra.percent = optJSONObject.optDouble("percent");
            tVItem.extra.moviepercent = optJSONObject.optDouble("moviepercent");
            tVItem.extra.date = optJSONObject.optString("date");
        }
        return tVItem;
    }
}
