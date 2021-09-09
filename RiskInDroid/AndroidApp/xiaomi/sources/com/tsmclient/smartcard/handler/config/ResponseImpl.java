package com.tsmclient.smartcard.handler.config;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.terminal.response.ScResponse;
import java.io.IOException;

public class ResponseImpl implements ScResponse {
    private ByteArray mData;
    private byte[] mResponseBytes;
    private ByteArray mStatus;

    public ResponseImpl(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length < 2) {
            throw new IOException("response length is illegal");
        }
        this.mResponseBytes = bArr;
        ByteArray wrap = ByteArray.wrap(bArr);
        this.mData = wrap.duplicate(0, wrap.length() - 2);
        this.mStatus = wrap.duplicate(wrap.length() - 2, 2);
    }

    public ByteArray getData() {
        return this.mData;
    }

    public ByteArray getStatus() {
        return this.mStatus;
    }

    public String toString() {
        return Coder.bytesToHexString(this.mResponseBytes);
    }

    public byte[] toBytes() {
        return this.mResponseBytes;
    }
}
