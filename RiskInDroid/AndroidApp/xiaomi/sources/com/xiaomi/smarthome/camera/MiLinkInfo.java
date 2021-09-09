package com.xiaomi.smarthome.camera;

public class MiLinkInfo extends P2PInfo {
    public String mMiLinkId = "android_test_guid1";
    public String mMiLinkKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDH6Tvnsh5NM6WBzRqkHS5pyijmQ/W5LaL41CS7UGFNZlsl7/dke9Rt8tErcjzydbQ+fbXMD8dw36yIV64Q7CSkWr/qmy69/wBuijWWX4evFe557y5xm8GjhAPu4Yjz8TidqbI2H2EzSEjFltmSx2gpxEts//ifjLcMKhR43HSIKwIDAQAB";
    public String mMiLinkPid = "1";
    public String mMiLinkRemoteId = "android_test_guid2";
    public long mMiLinkRomId = 429496729600000005L;
    public String mMiLinkToken = "V5+3MEnozKKNppWIu4lmPWOKvHKupP1ILFTukfDDx74=";

    public boolean equals(Object obj) {
        if (obj instanceof MiLinkInfo) {
            MiLinkInfo miLinkInfo = (MiLinkInfo) obj;
            if (!this.mMiLinkId.equals(miLinkInfo.mMiLinkId) || !this.mRemoteKey.equals(miLinkInfo.mRemoteKey)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getUid() {
        return this.mMiLinkId;
    }

    public String getKey() {
        return this.mMiLinkKey;
    }
}
