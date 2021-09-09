package com.ximalaya.ting.android.opensdk.util.dh;

import java.io.Serializable;
import java.math.BigInteger;

public class DhKeyPair implements Serializable {
    public BigInteger privateKey;
    public BigInteger publicKey;

    public String toString() {
        return "DhKeyPair{publicKey=" + this.publicKey + ", privateKey=" + this.privateKey + '}';
    }
}
