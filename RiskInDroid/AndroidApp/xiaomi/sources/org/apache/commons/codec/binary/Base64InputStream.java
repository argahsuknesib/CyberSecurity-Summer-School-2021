package org.apache.commons.codec.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Base64InputStream extends FilterInputStream {
    private final Base64 base64;
    private final boolean doEncode;
    private final byte[] singleByte;

    public boolean markSupported() {
        return false;
    }

    public Base64InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public Base64InputStream(InputStream inputStream, boolean z) {
        super(inputStream);
        this.singleByte = new byte[1];
        this.doEncode = z;
        this.base64 = new Base64();
    }

    public Base64InputStream(InputStream inputStream, boolean z, int i, byte[] bArr) {
        super(inputStream);
        this.singleByte = new byte[1];
        this.doEncode = z;
        this.base64 = new Base64(i, bArr);
    }

    public int read() throws IOException {
        int read = read(this.singleByte, 0, 1);
        while (read == 0) {
            read = read(this.singleByte, 0, 1);
        }
        if (read <= 0) {
            return -1;
        }
        byte[] bArr = this.singleByte;
        return bArr[0] < 0 ? bArr[0] + 256 : bArr[0];
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        } else if (i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i > bArr.length || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            if (!this.base64.hasData()) {
                byte[] bArr2 = new byte[(this.doEncode ? 4096 : 8192)];
                int read = this.in.read(bArr2);
                if (read > 0 && bArr.length == i2) {
                    this.base64.setInitialBuffer(bArr, i, i2);
                }
                if (this.doEncode) {
                    this.base64.encode(bArr2, 0, read);
                } else {
                    this.base64.decode(bArr2, 0, read);
                }
            }
            return this.base64.readResults(bArr, i, i2);
        }
    }
}
