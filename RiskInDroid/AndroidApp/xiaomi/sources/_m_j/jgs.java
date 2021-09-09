package _m_j;

import org.libsodium.jni.SodiumJNI;

public final class jgs {
    public static int O000000o(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        return SodiumJNI.crypto_stream_chacha20_xor(bArr, bArr2, i, bArr3, bArr4);
    }
}
