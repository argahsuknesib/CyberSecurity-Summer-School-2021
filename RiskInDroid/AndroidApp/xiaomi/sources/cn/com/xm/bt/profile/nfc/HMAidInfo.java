package cn.com.xm.bt.profile.nfc;

import java.util.Arrays;

public class HMAidInfo {
    byte[] aid = null;
    int aidLen = 0;
    int op = 1;
    int type = 1;

    public HMAidInfo(int i, int i2, byte[] bArr) {
        this.type = i;
        this.aidLen = i2;
        this.aid = bArr;
    }

    public HMAidInfo(int i, int i2, int i3, byte[] bArr) {
        this.op = i;
        this.type = i2;
        this.aidLen = i3;
        this.aid = bArr;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
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

    public int getOp() {
        return this.op;
    }

    public void setOp(int i) {
        this.op = i;
    }

    public String toString() {
        return "HMAidInfo{op=" + this.op + ", type=" + this.type + ", aidLen=" + this.aidLen + ", aid=" + Arrays.toString(this.aid) + '}';
    }
}
