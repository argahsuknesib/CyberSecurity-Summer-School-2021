package com.tsmclient.smartcard.apdu;

import com.tsmclient.smartcard.ByteArray;

public interface ISmartCardCommand {
    byte getCls();

    ByteArray getData();

    byte getIns();

    int getLc();

    int getLe();

    byte getP1();

    byte getP2();

    ByteArray toRawAPDU();
}
