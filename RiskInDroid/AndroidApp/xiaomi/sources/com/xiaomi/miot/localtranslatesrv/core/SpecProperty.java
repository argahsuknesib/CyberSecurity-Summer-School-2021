package com.xiaomi.miot.localtranslatesrv.core;

import com.xiaomi.miot.localtranslatesrv.core.metaDatas.translateStatus;

public class SpecProperty {
    private String deviceInstanceId;
    private String model;
    private int moduleInstanceId;
    private int propActionEventId;
    private int serviceInstanceId;
    private translateStatus status = translateStatus.TRANSLATE_STATUS_DEFAULT;
    private Object value;

    public int getModuleInstanceId() {
        return this.moduleInstanceId;
    }

    public void setModuleInstanceId(int i) {
        this.moduleInstanceId = i;
    }

    public int getServiceInstanceId() {
        return this.serviceInstanceId;
    }

    public void setServiceInstanceId(int i) {
        this.serviceInstanceId = i;
    }

    public int getPropActionEventId() {
        return this.propActionEventId;
    }

    public void setPropActionEventId(int i) {
        this.propActionEventId = i;
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

    public String getDeviceInstanceId() {
        return this.deviceInstanceId;
    }

    public void setDeviceInstanceId(String str) {
        this.deviceInstanceId = str;
    }

    public String toString() {
        return "SpecProperty\t{\"siid\":" + this.serviceInstanceId + ", \"piid\":" + this.propActionEventId + ", \"model\":\"" + this.model + "\", \"value\":" + this.value + ", \"status\":" + this.status.getValue() + '}';
    }
}
