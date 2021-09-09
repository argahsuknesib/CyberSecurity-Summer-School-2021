package com.tsmclient.smartcard.apdu;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;

public abstract class BaseCommand implements ISmartCardCommand {
    private byte mCls;
    private ByteArray mData = ByteArray.EMPTY;
    private byte mIns;
    private byte mP1;
    private byte mP2;

    public int getLe() {
        return 0;
    }

    public int getLc() {
        return getData().length();
    }

    public byte getCls() {
        return this.mCls;
    }

    /* access modifiers changed from: protected */
    public void setCls(byte b) {
        this.mCls = b;
    }

    public byte getIns() {
        return this.mIns;
    }

    /* access modifiers changed from: protected */
    public void setIns(byte b) {
        this.mIns = b;
    }

    public byte getP1() {
        return this.mP1;
    }

    public void setP1(byte b) {
        this.mP1 = b;
    }

    public byte getP2() {
        return this.mP2;
    }

    public void setP2(byte b) {
        this.mP2 = b;
    }

    public ByteArray getData() {
        return this.mData;
    }

    public void setData(ByteArray byteArray) {
        this.mData = byteArray;
    }

    public ByteArray toRawAPDU() {
        ByteArray data = getData();
        byte[] bArr = new byte[(data.length() + 5)];
        bArr[0] = getCls();
        bArr[1] = getIns();
        bArr[2] = getP1();
        bArr[3] = getP2();
        if (data.length() > 0) {
            bArr[4] = (byte) data.length();
            System.arraycopy(data.toBytes(), 0, bArr, 5, data.length());
        }
        return ByteArray.wrap(bArr);
    }

    public String toString() {
        return Coder.bytesToHexString(toRawAPDU().toBytes());
    }
}
