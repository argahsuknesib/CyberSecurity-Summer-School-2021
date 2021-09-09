package com.tsmclient.smartcard.apdu;

public class SelectCommand extends BaseCommand {
    public byte getIns() {
        return -92;
    }

    public byte getP2() {
        return 0;
    }

    public void setCls(byte b) {
        super.setCls(b);
    }
}
