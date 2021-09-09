package com.tsmclient.smartcard.tlv;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.exception.TagNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ArrayTLVValue implements ITLVValue {
    private ByteArray mOrigin;
    private List<ITLVObject> mValues = new ArrayList();

    public ArrayTLVValue(ByteArray byteArray, Collection<? extends ITLVObject> collection) {
        this.mOrigin = byteArray;
        this.mValues.addAll(collection);
    }

    public ITLVObject findTLV(ByteArray byteArray) throws TagNotFoundException {
        for (ITLVObject next : this.mValues) {
            if (ByteArray.equals(byteArray, next.getTag())) {
                return next;
            }
        }
        throw new TagNotFoundException("tag not found: " + Coder.bytesToHexString(byteArray.toBytes()));
    }

    public List<ITLVObject> findTLVList(ByteArray byteArray) throws TagNotFoundException {
        ArrayList arrayList = new ArrayList();
        for (ITLVObject next : this.mValues) {
            if (ByteArray.equals(byteArray, next.getTag())) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        throw new TagNotFoundException("tag not found: " + Coder.bytesToHexString(byteArray.toBytes()));
    }

    public ByteArray toBytes() {
        return this.mOrigin;
    }

    public int getSize() {
        return this.mValues.size();
    }
}
