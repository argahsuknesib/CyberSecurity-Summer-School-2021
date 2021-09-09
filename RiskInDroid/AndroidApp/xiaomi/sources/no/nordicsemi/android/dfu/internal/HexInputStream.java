package no.nordicsemi.android.dfu.internal;

import android.support.v4.app.NotificationCompat;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;

public class HexInputStream extends FilterInputStream {
    private final int LINE_LENGTH = NotificationCompat.FLAG_HIGH_PRIORITY;
    private final int MBRSize;
    private int available;
    private int bytesRead;
    private int lastAddress = 0;
    private final byte[] localBuf = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
    private int localPos = NotificationCompat.FLAG_HIGH_PRIORITY;
    private int pos;
    private int size = this.localBuf.length;

    private int asciiToInt(int i) {
        if (i >= 65) {
            return i - 55;
        }
        if (i >= 48) {
            return i - 48;
        }
        return -1;
    }

    public HexInputStream(InputStream inputStream, int i) throws HexFileValidationException, IOException {
        super(new BufferedInputStream(inputStream));
        this.MBRSize = i;
        this.available = calculateBinSize(i);
    }

    public HexInputStream(byte[] bArr, int i) throws HexFileValidationException, IOException {
        super(new ByteArrayInputStream(bArr));
        this.MBRSize = i;
        this.available = calculateBinSize(i);
    }

    private int calculateBinSize(int i) throws IOException {
        int i2;
        InputStream inputStream = this.in;
        inputStream.mark(inputStream.available());
        try {
            int read = inputStream.read();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                checkComma(read);
                int readByte = readByte(inputStream);
                int readAddress = readAddress(inputStream);
                int readByte2 = readByte(inputStream);
                if (readByte2 != 0) {
                    if (readByte2 != 1) {
                        if (readByte2 == 2) {
                            i2 = readAddress(inputStream) << 4;
                            if (i4 <= 0 || (i2 >> 16) == (i3 >> 16) + 1) {
                                skip(inputStream, 2);
                            } else {
                                inputStream.reset();
                                return i4;
                            }
                        } else if (readByte2 == 4) {
                            int readAddress2 = readAddress(inputStream);
                            if (i4 > 0 && readAddress2 != (i3 >> 16) + 1) {
                                return i4;
                            }
                            i2 = readAddress2 << 16;
                            skip(inputStream, 2);
                        }
                        i3 = i2;
                        while (true) {
                            read = inputStream.read();
                            if (read != 10 || read == 13) {
                            }
                        }
                    } else {
                        inputStream.reset();
                        return i4;
                    }
                } else if (readAddress + i3 >= i) {
                    i4 += readByte;
                }
                skip(inputStream, (long) ((readByte * 2) + 2));
                while (true) {
                    read = inputStream.read();
                    if (read != 10) {
                    }
                }
            }
        } finally {
            inputStream.reset();
        }
    }

    public int available() {
        return this.available - this.bytesRead;
    }

    public int readPacket(byte[] bArr) throws HexFileValidationException, IOException {
        int i = 0;
        while (i < bArr.length) {
            int i2 = this.localPos;
            if (i2 < this.size) {
                byte[] bArr2 = this.localBuf;
                this.localPos = i2 + 1;
                bArr[i] = bArr2[i2];
                i++;
            } else {
                int i3 = this.bytesRead;
                int readLine = readLine();
                this.size = readLine;
                this.bytesRead = i3 + readLine;
                if (this.size == 0) {
                    break;
                }
            }
        }
        return i;
    }

    public int read() throws IOException {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public int read(byte[] bArr) throws IOException {
        return readPacket(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public int sizeInBytes() {
        return this.available;
    }

    public int sizeInPackets(int i) throws IOException {
        int sizeInBytes = sizeInBytes();
        return (sizeInBytes / i) + (sizeInBytes % i > 0 ? 1 : 0);
    }

    private int readLine() throws IOException {
        if (this.pos == -1) {
            return 0;
        }
        InputStream inputStream = this.in;
        while (true) {
            int read = inputStream.read();
            this.pos++;
            if (!(read == 10 || read == 13)) {
                checkComma(read);
                int readByte = readByte(inputStream);
                this.pos += 2;
                int readAddress = readAddress(inputStream);
                this.pos += 4;
                int readByte2 = readByte(inputStream);
                this.pos += 2;
                if (readByte2 != 0) {
                    if (readByte2 == 1) {
                        this.pos = -1;
                        return 0;
                    } else if (readByte2 == 2) {
                        int readAddress2 = readAddress(inputStream) << 4;
                        this.pos += 4;
                        if (this.bytesRead > 0 && (readAddress2 >> 16) != (this.lastAddress >> 16) + 1) {
                            return 0;
                        }
                        this.lastAddress = readAddress2;
                        this.pos = (int) (((long) this.pos) + skip(inputStream, 2));
                    } else if (readByte2 != 4) {
                        this.pos = (int) (((long) this.pos) + skip(inputStream, (long) ((readByte * 2) + 2)));
                    } else {
                        int readAddress3 = readAddress(inputStream);
                        this.pos += 4;
                        if (this.bytesRead > 0 && readAddress3 != (this.lastAddress >> 16) + 1) {
                            return 0;
                        }
                        this.lastAddress = readAddress3 << 16;
                        this.pos = (int) (((long) this.pos) + skip(inputStream, 2));
                    }
                } else if (this.lastAddress + readAddress < this.MBRSize) {
                    this.pos = (int) (((long) this.pos) + skip(inputStream, (long) ((readByte * 2) + 2)));
                    readByte2 = -1;
                }
                if (readByte2 == 0) {
                    int i = 0;
                    while (i < this.localBuf.length && i < readByte) {
                        int readByte3 = readByte(inputStream);
                        this.pos += 2;
                        this.localBuf[i] = (byte) readByte3;
                        i++;
                    }
                    this.pos = (int) (((long) this.pos) + skip(inputStream, 2));
                    this.localPos = 0;
                    return readByte;
                }
            }
        }
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.pos = 0;
        this.bytesRead = 0;
        this.localPos = 0;
    }

    private void checkComma(int i) throws HexFileValidationException {
        if (i != 58) {
            throw new HexFileValidationException("Not a HEX file");
        }
    }

    private long skip(InputStream inputStream, long j) throws IOException {
        long skip = inputStream.skip(j);
        return skip < j ? skip + inputStream.skip(j - skip) : skip;
    }

    private int readByte(InputStream inputStream) throws IOException {
        return asciiToInt(inputStream.read()) | (asciiToInt(inputStream.read()) << 4);
    }

    private int readAddress(InputStream inputStream) throws IOException {
        return readByte(inputStream) | (readByte(inputStream) << 8);
    }
}
