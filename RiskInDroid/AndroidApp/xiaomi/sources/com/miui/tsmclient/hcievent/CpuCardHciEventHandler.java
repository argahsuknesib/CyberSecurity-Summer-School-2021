package com.miui.tsmclient.hcievent;

import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import java.util.HashMap;
import java.util.Map;

public class CpuCardHciEventHandler implements IHciEventHandler {
    private ByteArray TAG_AMOUNT = ByteArray.wrap(new byte[]{-47});
    private ByteArray TAG_BALANCE = ByteArray.wrap(new byte[]{-46});
    private ByteArray TAG_MESSAGE_DES = ByteArray.wrap(new byte[]{-43});
    private ByteArray TAG_MESSAGE_TITLE = ByteArray.wrap(new byte[]{-44});
    private ByteArray TAG_TERMINAL_NO = ByteArray.wrap(new byte[]{-45});

    private Map<ByteArray, ByteArray> parseData(ByteArray byteArray) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < byteArray.length()) {
            ByteArray duplicate = byteArray.duplicate(i, 1);
            if (ByteArray.equals(duplicate, this.TAG_AMOUNT) || ByteArray.equals(duplicate, this.TAG_BALANCE) || ByteArray.equals(duplicate, this.TAG_TERMINAL_NO) || ByteArray.equals(duplicate, this.TAG_MESSAGE_TITLE) || ByteArray.equals(duplicate, this.TAG_MESSAGE_DES)) {
                int bytesToInt = Coder.bytesToInt(byteArray.duplicate(i + 1, 1).toBytes());
                int i2 = i + 2;
                hashMap.put(duplicate, byteArray.duplicate(i2, bytesToInt));
                i = i2 + bytesToInt;
            } else {
                i++;
            }
        }
        return hashMap;
    }

    public HciEventInfo handleData(byte[] bArr, long j, byte[] bArr2) {
        LogUtils.d("handle CpuCardHciEventHandler");
        ByteArray byteArray = null;
        if (bArr2 != null && bArr2.length >= 2) {
            Map<ByteArray, ByteArray> parseData = parseData(ByteArray.wrap(bArr2));
            if (parseData.size() > 0) {
                ByteArray byteArray2 = null;
                for (Map.Entry next : parseData.entrySet()) {
                    if (ByteArray.equals((ByteArray) next.getKey(), this.TAG_AMOUNT)) {
                        byteArray = (ByteArray) next.getValue();
                    } else if (ByteArray.equals((ByteArray) next.getKey(), this.TAG_BALANCE)) {
                        byteArray2 = (ByteArray) next.getValue();
                    } else if (ByteArray.equals((ByteArray) next.getKey(), this.TAG_TERMINAL_NO) || ByteArray.equals((ByteArray) next.getKey(), this.TAG_MESSAGE_TITLE) || ByteArray.equals((ByteArray) next.getKey(), this.TAG_MESSAGE_DES)) {
                        next.getValue();
                    }
                }
                return new HciEventInfo(Coder.bytesToHexString(bArr), j, byteArray == null ? 0 : Coder.bytesToInt(byteArray.toBytes()), byteArray2 == null ? 0 : Coder.bytesToInt(byteArray2.toBytes()), true);
            }
        }
        return null;
    }

    public boolean isSupport(byte[] bArr, byte[] bArr2) {
        return Coder.bytesToHexString(bArr).startsWith("A0000000006D696B65796361");
    }
}
