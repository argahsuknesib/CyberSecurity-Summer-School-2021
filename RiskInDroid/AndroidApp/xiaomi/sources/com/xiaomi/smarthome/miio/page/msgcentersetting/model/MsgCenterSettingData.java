package com.xiaomi.smarthome.miio.page.msgcentersetting.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MsgCenterSettingData implements Serializable {
    private Map<String, Object> additionalProperties = new HashMap();
    private String command;
    public Param param;

    public static MsgCenterSettingData O000000o(JSONObject jSONObject) {
        MsgCenterSettingData msgCenterSettingData = new MsgCenterSettingData();
        msgCenterSettingData.param = Param.O000000o(jSONObject);
        return msgCenterSettingData;
    }

    public final void O000000o(int i) {
        this.param.O00000Oo(Integer.valueOf(i));
    }

    public final void O00000Oo(int i) {
        this.param.O00000o0(Integer.valueOf(i));
    }

    public final void O00000o0(int i) {
        this.param.O00000o(Integer.valueOf(i));
    }

    public final void O00000o(int i) {
        this.param.O00000oO(Integer.valueOf(i));
    }
}
