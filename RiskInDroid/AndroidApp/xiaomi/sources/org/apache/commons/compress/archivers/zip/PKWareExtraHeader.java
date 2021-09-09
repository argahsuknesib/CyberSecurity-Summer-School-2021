package org.apache.commons.compress.archivers.zip;

import _m_j.jcn;
import _m_j.jco;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class PKWareExtraHeader implements jcn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ZipShort f15422O000000o;
    private byte[] O00000Oo;
    private byte[] O00000o0;

    protected PKWareExtraHeader(ZipShort zipShort) {
        this.f15422O000000o = zipShort;
    }

    public final ZipShort O00000oO() {
        return this.f15422O000000o;
    }

    public final ZipShort O00000o() {
        byte[] bArr = this.O00000Oo;
        return new ZipShort(bArr != null ? bArr.length : 0);
    }

    public final byte[] O00000o0() {
        return jco.O00000Oo(this.O00000Oo);
    }

    public final ZipShort O00000Oo() {
        byte[] bArr = this.O00000o0;
        if (bArr != null) {
            return new ZipShort(bArr.length);
        }
        return O00000o();
    }

    public final byte[] O000000o() {
        byte[] bArr = this.O00000o0;
        if (bArr != null) {
            return jco.O00000Oo(bArr);
        }
        return jco.O00000Oo(this.O00000Oo);
    }

    public void O000000o(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.O00000Oo = jco.O00000Oo(bArr2);
    }

    public enum EncryptionAlgorithm {
        DES(26113),
        RC2pre52(26114),
        TripleDES168(26115),
        TripleDES192(26121),
        AES128(26126),
        AES192(26127),
        AES256(26128),
        RC2(26370),
        RC4(26625),
        UNKNOWN(65535);
        
        private static final Map<Integer, EncryptionAlgorithm> codeToEnum;
        private final int code;

        static {
            HashMap hashMap = new HashMap();
            for (EncryptionAlgorithm encryptionAlgorithm : values()) {
                hashMap.put(Integer.valueOf(encryptionAlgorithm.getCode()), encryptionAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(hashMap);
        }

        private EncryptionAlgorithm(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }

        public static EncryptionAlgorithm getAlgorithmByCode(int i) {
            return codeToEnum.get(Integer.valueOf(i));
        }
    }

    public enum HashAlgorithm {
        NONE(0),
        CRC32(1),
        MD5(32771),
        SHA1(32772),
        RIPEND160(32775),
        SHA256(32780),
        SHA384(32781),
        SHA512(32782);
        
        private static final Map<Integer, HashAlgorithm> codeToEnum;
        private final int code;

        static {
            HashMap hashMap = new HashMap();
            for (HashAlgorithm hashAlgorithm : values()) {
                hashMap.put(Integer.valueOf(hashAlgorithm.getCode()), hashAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(hashMap);
        }

        private HashAlgorithm(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }

        public static HashAlgorithm getAlgorithmByCode(int i) {
            return codeToEnum.get(Integer.valueOf(i));
        }
    }
}
