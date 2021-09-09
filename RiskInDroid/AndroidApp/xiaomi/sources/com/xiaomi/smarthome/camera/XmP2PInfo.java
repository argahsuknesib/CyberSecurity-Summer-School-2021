package com.xiaomi.smarthome.camera;

public interface XmP2PInfo {
    String getDid();

    int getFrameInfoSize();

    String getModel();

    boolean getOnLine();

    String getPluginKey();

    String getPwd();

    byte[] getShareKey();

    String getUid();

    int getVersion();

    void setDid(String str);

    void setFrameInfoSize(int i);

    void setModel(String str);

    void setOnLine(boolean z);

    void setPackId(long j);

    void setPluginId(long j);

    void setVersion(int i);
}
