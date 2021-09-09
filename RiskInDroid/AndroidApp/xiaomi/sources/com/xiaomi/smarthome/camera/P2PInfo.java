package com.xiaomi.smarthome.camera;

public abstract class P2PInfo {
    public int mFrameInfoSize = 28;
    public String mModel = "";
    public byte[] mPrivateKey = new byte[32];
    public byte[] mPublicKey = new byte[32];
    public String mRemoteKey = "";
    public String mRemoteSing = "";
    public byte[] mShareKey = null;

    public abstract String getKey();

    public abstract String getUid();
}
