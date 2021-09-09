package com.xiaomi.idm.tap.dispatcher;

public interface ConditionVerifier {
    boolean isConditionSatisfied();

    void setParameter(byte[] bArr);
}
