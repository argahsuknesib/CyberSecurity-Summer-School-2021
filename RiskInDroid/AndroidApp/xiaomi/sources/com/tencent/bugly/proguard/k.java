package com.tencent.bugly.proguard;

import _m_j.dhq;
import _m_j.dhr;
import java.io.Serializable;

public abstract class k implements Serializable {
    public abstract void O000000o(dhq dhq);

    public abstract void O000000o(dhr dhr);

    public abstract void O000000o(StringBuilder sb, int i);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        O000000o(sb, 0);
        return sb.toString();
    }
}
