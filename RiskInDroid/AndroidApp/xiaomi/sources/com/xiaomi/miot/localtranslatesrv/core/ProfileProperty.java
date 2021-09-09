package com.xiaomi.miot.localtranslatesrv.core;

import com.xiaomi.miot.localtranslatesrv.core.metaDatas.translateStatus;
import org.json.JSONObject;

public class ProfileProperty {
    private String deviceInstanceId;
    private String model;
    private String name;
    private String specialGetMethod;
    private String specialSetMethod;
    private translateStatus status = translateStatus.TRANSLATE_STATUS_DEFAULT;
    private String subscribePropName;
    private Object value;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public int getStatus() {
        return this.status.getValue();
    }

    public void setStatus(int i) {
        this.status = translateStatus.statusFactory(i);
    }

    public void setStatus(translateStatus translatestatus) {
        this.status = translatestatus;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.name);
        jSONObject.put("model", this.model);
        Object obj = this.value;
        jSONObject.put("value", obj != null ? obj.toString() : null);
        String str = this.specialGetMethod;
        if (str != null) {
            jSONObject.put("specialGetMethod", str);
        }
        String str2 = this.specialSetMethod;
        if (str2 != null) {
            jSONObject.put("specialSetMethod", str2);
        }
        String str3 = this.subscribePropName;
        if (str3 != null) {
            jSONObject.put("subscribePropName", str3);
        }
        jSONObject.put("status", this.status.getValue());
        return "ProfileProperty\t" + jSONObject.toString();
    }

    public String getDeviceInstanceId() {
        return this.deviceInstanceId;
    }

    public void setDeviceInstanceId(String str) {
        this.deviceInstanceId = str;
    }

    public String getSpecialGetMethod() {
        return this.specialGetMethod;
    }

    public void setSpecialGetMethod(String str) {
        this.specialGetMethod = str;
    }

    public String getSpecialSetMethod() {
        return this.specialSetMethod;
    }

    public void setSpecialSetMethod(String str) {
        this.specialSetMethod = str;
    }

    public String getSubscribePropName() {
        return this.subscribePropName;
    }

    public void setSubscribePropName(String str) {
        this.subscribePropName = str;
    }
}
