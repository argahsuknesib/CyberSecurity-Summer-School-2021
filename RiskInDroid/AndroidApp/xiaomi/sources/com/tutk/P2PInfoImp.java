package com.tutk;

import android.text.TextUtils;
import com.xiaomi.smarthome.camera.XmP2PInfo;

public class P2PInfoImp implements XmP2PInfo {
    public boolean isIPC009AudioFullEncryption = false;
    public boolean isIPC009VideoFullEncryption = false;
    public String mAccount = "admin";
    private String mDid = "";
    public int mFrameInfoSize = 28;
    public byte[] mHualaiShareKey;
    private String mModel = "";
    private boolean mOnLine = false;
    private long mPackId = 0;
    private long mPluginId = 0;
    private String mPluginKey;
    public byte[] mPrivateKey = new byte[32];
    public byte[] mPublicKey = new byte[32];
    private String mPwd = "";
    public String mRemoteKey = "";
    public String mRemoteSing = "";
    public byte[] mShareKey = null;
    private String mUId = "";
    private int mVersion = 0;
    public boolean useFixedRdtChannelId = false;

    public String getUid() {
        return this.mUId;
    }

    public void setUid(String str) {
        this.mUId = str;
    }

    public void setPwd(String str) {
        this.mPwd = str;
    }

    public String getPwd() {
        return this.mPwd;
    }

    public byte[] getShareKey() {
        return this.mShareKey;
    }

    public int getFrameInfoSize() {
        return this.mFrameInfoSize;
    }

    public void setFrameInfoSize(int i) {
        this.mFrameInfoSize = i;
    }

    public void setDid(String str) {
        this.mDid = str;
    }

    public String getDid() {
        return this.mDid;
    }

    public void setModel(String str) {
        this.mModel = str;
    }

    public String getModel() {
        return this.mModel;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setOnLine(boolean z) {
        this.mOnLine = z;
    }

    public boolean getOnLine() {
        return this.mOnLine;
    }

    public void setPluginId(long j) {
        this.mPluginId = j;
    }

    public void setPackId(long j) {
        this.mPackId = j;
    }

    public String getPluginKey() {
        if (TextUtils.isEmpty(this.mPluginKey)) {
            this.mPluginKey = getDeveloperName(this.mPluginId, this.mPackId);
        }
        return this.mPluginKey;
    }

    private static final String getDeveloperName(long j, long j2) {
        return "plugin." + j + "." + j2;
    }
}
