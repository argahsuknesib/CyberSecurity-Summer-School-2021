package com.tsmclient.smartcard.apdu;

public class ReadBinaryCommand extends BaseCommand {
    public byte getCls() {
        return 0;
    }

    public byte getIns() {
        return -80;
    }

    public byte getP2() {
        return 0;
    }
}
