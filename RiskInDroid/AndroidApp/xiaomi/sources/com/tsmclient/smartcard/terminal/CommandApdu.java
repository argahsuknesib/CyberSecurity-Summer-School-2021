package com.tsmclient.smartcard.terminal;

public class CommandApdu {
    protected int mCla;
    protected byte[] mData = new byte[0];
    protected int mIns;
    protected int mLc;
    protected int mLe;
    protected boolean mLeUsed;
    protected int mP1;
    protected int mP2;

    public CommandApdu() {
    }

    public CommandApdu(int i, int i2, int i3, int i4) {
        this.mCla = i;
        this.mIns = i2;
        this.mP1 = i3;
        this.mP2 = i4;
    }

    public CommandApdu(int i, int i2, int i3, int i4, byte[] bArr) {
        this.mCla = i;
        this.mIns = i2;
        this.mLc = bArr.length;
        this.mP1 = i3;
        this.mP2 = i4;
        this.mData = bArr;
    }

    public CommandApdu(int i, int i2, int i3, int i4, byte[] bArr, int i5) {
        this.mCla = i;
        this.mIns = i2;
        this.mLc = bArr.length;
        this.mP1 = i3;
        this.mP2 = i4;
        this.mData = bArr;
        this.mLe = i5;
        this.mLeUsed = true;
    }

    public CommandApdu(int i, int i2, int i3, int i4, int i5) {
        this.mCla = i;
        this.mIns = i2;
        this.mP1 = i3;
        this.mP2 = i4;
        this.mLe = i5;
        this.mLeUsed = true;
    }

    public void setP1(int i) {
        this.mP1 = i;
    }

    public void setP2(int i) {
        this.mP2 = i;
    }

    public void setData(byte[] bArr) {
        this.mLc = bArr.length;
        this.mData = bArr;
    }

    public void setLe(int i) {
        this.mLe = i;
        this.mLeUsed = true;
    }

    public int getP1() {
        return this.mP1;
    }

    public int getP2() {
        return this.mP2;
    }

    public int getLc() {
        return this.mLc;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getLe() {
        return this.mLe;
    }

    public byte[] toBytes() {
        byte[] bArr = this.mData;
        int i = 4;
        int length = bArr.length != 0 ? bArr.length + 5 : 4;
        if (this.mLeUsed) {
            length++;
        }
        byte[] bArr2 = new byte[length];
        bArr2[0] = (byte) this.mCla;
        bArr2[1] = (byte) this.mIns;
        bArr2[2] = (byte) this.mP1;
        bArr2[3] = (byte) this.mP2;
        byte[] bArr3 = this.mData;
        if (bArr3.length != 0) {
            bArr2[4] = (byte) this.mLc;
            System.arraycopy(bArr3, 0, bArr2, 5, bArr3.length);
            i = this.mData.length + 5;
        }
        if (this.mLeUsed) {
            bArr2[i] = (byte) (bArr2[i] + ((byte) this.mLe));
        }
        return bArr2;
    }

    public CommandApdu clone() {
        CommandApdu commandApdu = new CommandApdu();
        commandApdu.mCla = this.mCla;
        commandApdu.mIns = this.mIns;
        commandApdu.mP1 = this.mP1;
        commandApdu.mP2 = this.mP2;
        commandApdu.mLc = this.mLc;
        commandApdu.mData = new byte[this.mData.length];
        byte[] bArr = this.mData;
        System.arraycopy(bArr, 0, commandApdu.mData, 0, bArr.length);
        commandApdu.mLe = this.mLe;
        commandApdu.mLeUsed = this.mLeUsed;
        return commandApdu;
    }
}
