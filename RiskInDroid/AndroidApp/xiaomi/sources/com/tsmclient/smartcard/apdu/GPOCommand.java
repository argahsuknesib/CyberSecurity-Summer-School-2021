package com.tsmclient.smartcard.apdu;

public class GPOCommand extends BaseCommand {
    public byte getCls() {
        return Byte.MIN_VALUE;
    }

    public byte getIns() {
        return -88;
    }

    public byte getP1() {
        return 0;
    }

    public byte getP2() {
        return 0;
    }
}
