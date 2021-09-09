package com.xiaomi.miio;

public class JNIBridge {
    public static native MiioMsg decrypt(byte[] bArr, byte[] bArr2);

    public static native byte[] encrypt(MiioMsg miioMsg);

    public static native MiioMsg hdecrypt(byte[] bArr);

    public static native byte[] hencrypt(MiioMsg miioMsg);

    public static native byte[] smencrypt(byte[] bArr, long j);

    public static native byte[] smencryptpk(byte[] bArr, long j, byte[] bArr2);

    static {
        System.loadLibrary("miio");
    }

    public static class MiioMsg {
        public long did;
        public byte[] message;
        public int stamp;
        public byte[] token;

        public MiioMsg() {
        }

        public MiioMsg(long j, int i, byte[] bArr, byte[] bArr2) {
            this.did = j;
            this.stamp = i;
            this.token = bArr;
            this.message = bArr2;
        }
    }
}
