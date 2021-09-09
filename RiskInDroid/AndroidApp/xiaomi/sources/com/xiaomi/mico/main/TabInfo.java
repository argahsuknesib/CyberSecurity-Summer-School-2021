package com.xiaomi.mico.main;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TabInfo {
    public boolean isFromCache = true;
    public String name;
    public String type;
    public int typeId;

    public static List<TabInfo> parse(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ("ok".equalsIgnoreCase(jSONObject.getString("result"))) {
                jSONObject.optJSONObject("extraData");
                JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("list");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    TabInfo tabInfo = new TabInfo();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    tabInfo.typeId = jSONObject2.optInt("typeId");
                    tabInfo.type = jSONObject2.getString("type");
                    tabInfo.name = jSONObject2.optString("name");
                    arrayList.add(tabInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            arrayList.clear();
        }
        return arrayList;
    }

    public static List<TabInfo> generateCacheTabs() {
        if (!TextUtils.isEmpty(MicoTabsApi.getInstance().getCachedTabInfo())) {
            return parse(MicoTabsApi.getInstance().getCachedTabInfo());
        }
        return null;
    }
}
