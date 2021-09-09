package com.miui.tsmclient.entity;

import com.miui.tsmclient.database.JSONSerializable;
import com.miui.tsmclient.util.LogUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Sector implements JSONSerializable {
    private List<Block> blocks;
    private int number;

    Sector(int i, List<Block> list) {
        this.number = i;
        this.blocks = list;
    }

    public JSONObject serialize() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("number", this.number);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.blocks.size(); i++) {
                jSONArray.put(this.blocks.get(i).serialize());
            }
            jSONObject.put("blockList", jSONArray);
        } catch (JSONException unused) {
            LogUtils.d("Sector parse failed");
        }
        return jSONObject;
    }
}
