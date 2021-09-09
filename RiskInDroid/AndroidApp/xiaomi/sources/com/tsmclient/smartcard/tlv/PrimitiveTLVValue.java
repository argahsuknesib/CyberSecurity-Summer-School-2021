package com.tsmclient.smartcard.tlv;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.exception.TagNotFoundException;
import java.util.List;

class PrimitiveTLVValue implements ITLVValue {
    private ByteArray mValue;

    PrimitiveTLVValue(ByteArray byteArray) {
        this.mValue = byteArray;
    }

    public ITLVObject findTLV(ByteArray byteArray) throws TagNotFoundException {
        throw new TagNotFoundException("it is a primitive tlv");
    }

    public List<ITLVObject> findTLVList(ByteArray byteArray) throws TagNotFoundException {
        throw new TagNotFoundException("it is a primitive tlv");
    }

    public ByteArray toBytes() {
        return this.mValue;
    }

    public String toString() {
        return this.mValue.toString();
    }
}
