package com.xiaomi.mico.music.patchwall.micoselect.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MicoSelectInfo {
    public ArrayList<Card> cards;
    public String expid = "";
    public boolean isFromCache;
    public String name;
    public String type;
    public int typeId;

    public static List<MicoSelectInfo> parse(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ("ok".equalsIgnoreCase(jSONObject.getString("result"))) {
                JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
                JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("appDisplayInfoList");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    MicoSelectInfo micoSelectInfo = new MicoSelectInfo();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    micoSelectInfo.name = jSONObject2.optString("name");
                    micoSelectInfo.type = jSONObject2.getString("type");
                    JSONArray optJSONArray = jSONObject2.optJSONArray("cards");
                    if (optJSONArray != null) {
                        ArrayList<Card> arrayList2 = new ArrayList<>();
                        int length2 = optJSONArray.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            Card card = new Card();
                            JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                            if (jSONObject3 != null) {
                                card.id = jSONObject3.optInt("id");
                                card.jumpLink = jSONObject3.optString("jumpLink");
                                card.picture = jSONObject3.optString("picture");
                                card.mainTitle = jSONObject3.optString("mainTitle");
                                card.subTitle = jSONObject3.optString("subTitle");
                                arrayList2.add(card);
                            }
                        }
                        micoSelectInfo.cards = arrayList2;
                    }
                    if (optJSONObject != null) {
                        micoSelectInfo.expid = optJSONObject.optString("expId", "");
                    }
                    arrayList.add(micoSelectInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            arrayList.clear();
        }
        return arrayList;
    }
}
