package com.miui.tsmclient.entity;

import com.miui.tsmclient.database.JSONSerializable;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import org.json.JSONException;
import org.json.JSONObject;

public class Block implements JSONSerializable {
    public static final ByteArray BLANK = ByteArray.wrap(Coder.hexStringToBytes("00000000000000000000000000000000"));
    private int number;
    private String value;

    Block(int i, String str) {
        this.number = i;
        this.value = str;
    }

    public JSONObject serialize() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("number", this.number);
            jSONObject.put("value", this.value);
        } catch (JSONException unused) {
            LogUtils.d("Block parse failed");
        }
        return jSONObject;
    }
}
