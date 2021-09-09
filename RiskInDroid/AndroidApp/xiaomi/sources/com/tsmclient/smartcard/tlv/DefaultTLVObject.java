package com.tsmclient.smartcard.tlv;

import com.tsmclient.smartcard.ByteArray;

class DefaultTLVObject implements ITLVObject {
    private ByteArray mLength;
    private ByteArray mTag;
    private ITLVValue mValue;

    public DefaultTLVObject(ByteArray byteArray, ByteArray byteArray2, ITLVValue iTLVValue) {
        this.mTag = byteArray;
        this.mLength = byteArray2;
        this.mValue = iTLVValue;
    }

    public ByteArray getTag() {
        return this.mTag;
    }

    public ByteArray getLength() {
        return this.mLength;
    }

    public ITLVValue getValue() {
        return this.mValue;
    }

    public void setTag(ByteArray byteArray) {
        this.mTag = byteArray;
    }

    public void setLength(ByteArray byteArray) {
        this.mLength = byteArray;
    }

    public void setValue(ITLVValue iTLVValue) {
        this.mValue = iTLVValue;
    }
}
