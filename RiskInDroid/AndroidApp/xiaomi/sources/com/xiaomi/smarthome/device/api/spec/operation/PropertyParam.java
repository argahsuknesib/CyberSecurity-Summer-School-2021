package com.xiaomi.smarthome.device.api.spec.operation;

import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;

public class PropertyParam extends SpecParam {
    private int piid;
    private long timestamp;
    private Object value;

    @Deprecated
    public PropertyParam() {
        super(null, 0);
    }

    @Deprecated
    public PropertyParam(String str, int i, int i2) {
        this(str, 0, i, i2);
    }

    @Deprecated
    public PropertyParam(String str, int i, int i2, int i3) {
        super(str, i, i2);
        this.piid = i3;
    }

    public PropertyParam(String str, SpecProperty specProperty) {
        super(str, Spec.getIid(specProperty, 2), Spec.getIid(specProperty, 1));
        this.piid = Spec.getIid(specProperty, 0);
    }

    public PropertyParam(String str, SpecProperty specProperty, int i) {
        super(str, Spec.getIid(specProperty, 2), Spec.getIid(specProperty, 1), i);
        this.piid = Spec.getIid(specProperty, 0);
    }

    public int getPiid() {
        return this.piid;
    }

    public void setPiid(int i) {
        this.piid = i;
    }

    public Object getValue() {
        return this.value;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public PropertyParam setValue(Object obj) {
        this.value = obj;
        return this;
    }

    public String toString() {
        return "PropertyParam{did='" + getDid() + '\'' + ", miid=" + getMiid() + ", siid=" + getSiid() + ", piid=" + this.piid + ", value=" + this.value + ", timestamp=" + this.timestamp + ", resultCode=" + getResultCode() + '}';
    }
}
