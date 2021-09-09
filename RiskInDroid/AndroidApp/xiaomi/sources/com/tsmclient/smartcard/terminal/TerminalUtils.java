package com.tsmclient.smartcard.terminal;

import com.tsmclient.smartcard.Coder;

public class TerminalUtils {
    private TerminalUtils() {
    }

    public static CommandApdu buildSetStatusApdu(String str, boolean z) {
        CommandApdu commandApdu;
        if (z) {
            commandApdu = APDUConstants.COMM_PREFIX_ACTIVATE_CARD.clone();
        } else {
            commandApdu = APDUConstants.COMM_PREFIX_DEACTIVATE_CARD.clone();
        }
        byte[] hexStringToBytes = Coder.hexStringToBytes(str);
        byte[] bArr = new byte[(hexStringToBytes.length + 2)];
        bArr[0] = 79;
        bArr[1] = (byte) (hexStringToBytes.length & 255);
        System.arraycopy(hexStringToBytes, 0, bArr, 2, hexStringToBytes.length);
        commandApdu.setData(bArr);
        return commandApdu;
    }
}
