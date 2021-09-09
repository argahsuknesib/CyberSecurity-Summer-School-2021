package com.tsmclient.smartcard.apdu;

public class GetDataCommand extends BaseCommand {
    public byte getCls() {
        return Byte.MIN_VALUE;
    }

    public byte getIns() {
        return -54;
    }
}
