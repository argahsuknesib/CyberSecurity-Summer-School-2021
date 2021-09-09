package com.xiaomi.smarthome.smartconfig.step;

import _m_j.fio;
import _m_j.fip;
import _m_j.fir;
import _m_j.got;
import android.util.Log;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import javax.crypto.SecretKey;

public enum ECCurve {
    SECP192R1(1, "secp192r1"),
    SECP224R1(2, "secp224r1"),
    SECP256R1(3, "secp256r1"),
    SECP384R1(4, "secp384r1"),
    SECP521R1(5, "secp521r1"),
    SECP192K1(10, "secp192k1"),
    SECP224K1(11, "secp224k1"),
    SECP256K1(12, "secp256k1");
    
    private KeyPairGenerator generator = null;
    private int index;
    private KeyPair keyPair;
    private String name;

    private ECCurve(int i, String str) {
        this.name = str;
        this.index = i;
    }

    public final int getIndex() {
        return this.index;
    }

    public static ECCurve search(int i) {
        ECCurve[] values = values();
        int length = values.length;
        int i2 = 0;
        while (i2 < length) {
            ECCurve eCCurve = values[i2];
            if (eCCurve.index == i) {
                try {
                    eCCurve.createGenerator();
                    return eCCurve;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                i2++;
            }
        }
        return null;
    }

    public final KeyPair generateKeyPair() {
        if (this.generator == null) {
            try {
                createGenerator();
            } catch (Exception unused) {
                return null;
            }
        }
        this.keyPair = this.generator.generateKeyPair();
        return this.keyPair;
    }

    private void createGenerator() throws Exception {
        this.generator = KeyPairGenerator.getInstance("EC");
        this.generator.initialize(new ECGenParameterSpec(this.name));
    }

    public final byte[] verify(SignType signType, String str, byte[] bArr, byte[] bArr2) {
        try {
            ECPublicKey eCPublicKey = (ECPublicKey) this.keyPair.getPublic();
            SecretKey O000000o2 = fir.O000000o(fio.O000000o(bArr, eCPublicKey.getParams()), this.keyPair.getPrivate());
            fip O000000o3 = fip.O000000o("HmacSHA256");
            O000000o3.O000000o(O000000o2.getEncoded(), str.getBytes());
            byte[] O000000o4 = O000000o3.O000000o("".getBytes(), 16);
            if (SignType.HMACSHA256 != signType) {
                if (SignType.ECDSASHA256 == signType) {
                    Signature instance = Signature.getInstance("SHA256WithECDSA");
                    instance.initVerify(eCPublicKey);
                    instance.update(bArr);
                    if (instance.verify(bArr2)) {
                        return O000000o4;
                    }
                }
                return null;
            } else if (got.O000000o(fir.O000000o(O000000o4, bArr), bArr2)) {
                return O000000o4;
            } else {
                return null;
            }
        } catch (Exception e) {
            Log.e("fatal", "ECCurve.verify", e);
            return null;
        }
    }

    public enum SignType {
        ECDSASHA256(2),
        HMACSHA256(1);
        
        private final int type;

        private SignType(int i) {
            this.type = i;
        }

        public static SignType index(int i) {
            if (i == 1) {
                return HMACSHA256;
            }
            if (i != 2) {
                return null;
            }
            return ECDSASHA256;
        }
    }
}
