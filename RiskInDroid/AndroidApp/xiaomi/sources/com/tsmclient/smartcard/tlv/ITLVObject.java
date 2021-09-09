package com.tsmclient.smartcard.tlv;

import com.tsmclient.smartcard.ByteArray;

public interface ITLVObject {
    ByteArray getLength();

    ByteArray getTag();

    ITLVValue getValue();
}
