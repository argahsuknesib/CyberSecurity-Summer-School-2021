package com.kookong.app.data;

import java.io.Serializable;

public class RcRemoteKeyExt implements Serializable, Cloneable {
    protected int tag;
    protected String value;

    public int getTag() {
        return this.tag;
    }

    public void setTag(int i) {
        this.tag = i;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#com.kookong.app.data\n");
        stringBuffer.append("tag=" + this.tag + "\n");
        stringBuffer.append("value=" + this.value + "\n");
        return stringBuffer.toString();
    }
}
