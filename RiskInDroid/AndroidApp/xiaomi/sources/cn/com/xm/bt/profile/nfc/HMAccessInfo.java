package cn.com.xm.bt.profile.nfc;

import java.util.Arrays;

public class HMAccessInfo {
    byte[] aid = null;
    int aidLen = 0;
    private String name = null;

    public HMAccessInfo() {
    }

    public HMAccessInfo(String str, int i, byte[] bArr) {
        this.name = str;
        this.aidLen = i;
        this.aid = bArr;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getAidLen() {
        return this.aidLen;
    }

    public void setAidLen(int i) {
        this.aidLen = i;
    }

    public byte[] getAid() {
        return this.aid;
    }

    public void setAid(byte[] bArr) {
        this.aid = bArr;
    }

    public String toString() {
        return "HMAccessInfo{name='" + this.name + '\'' + ", aidLen=" + this.aidLen + ", aid=" + Arrays.toString(this.aid) + '}';
    }
}
