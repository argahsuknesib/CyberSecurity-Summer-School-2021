package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.cloud.CloudImage;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class o<T, V> extends k<T, V> {
    public o(Context context, T t) {
        super(context, t);
    }

    /* access modifiers changed from: protected */
    public CloudItemDetail a(JSONObject jSONObject) throws JSONException {
        CloudItemDetail cloudItemDetail = new CloudItemDetail(z.a(jSONObject, "_id"), z.b(jSONObject, "_location"), z.a(jSONObject, "_name"), z.a(jSONObject, "_address"));
        cloudItemDetail.setCreatetime(z.a(jSONObject, "_createtime"));
        cloudItemDetail.setUpdatetime(z.a(jSONObject, "_updatetime"));
        if (jSONObject.has("_distance")) {
            String optString = jSONObject.optString("_distance");
            if (!e(optString)) {
                cloudItemDetail.setDistance(Integer.parseInt(optString));
            }
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("_image");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            cloudItemDetail.setmCloudImage(arrayList);
            return cloudItemDetail;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            arrayList.add(new CloudImage(z.a(jSONObject2, "_id"), z.a(jSONObject2, "_preurl"), z.a(jSONObject2, "_url")));
        }
        cloudItemDetail.setmCloudImage(arrayList);
        return cloudItemDetail;
    }

    public Map<String, String> e() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 6.9.3");
        hashMap.put("X-INFO", bs.a(this.d));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "6.9.3", "cloud"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void a(CloudItem cloudItem, JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        if (keys != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && !next.toString().startsWith("_")) {
                    hashMap.put(next.toString(), jSONObject.optString(next.toString()));
                }
            }
            cloudItem.setCustomfield(hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public boolean e(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }
}
