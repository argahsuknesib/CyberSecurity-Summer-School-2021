package com.squareup.wire;

import _m_j.jay;
import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import okio.ByteString;

public final class ProtoWriter {
    private final jay sink;

    static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    static int varint32Size(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    static int varint64Size(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private static int makeTag(int i, FieldEncoding fieldEncoding) {
        return (i << 3) | fieldEncoding.value;
    }

    static int tagSize(int i) {
        return varint32Size(makeTag(i, FieldEncoding.VARINT));
    }

    static int utf8Length(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i3 += 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i3 += 3;
                } else if (charAt <= 56319 && (i = i2 + 1) < length && str.charAt(i) >= 56320 && str.charAt(i) <= 57343) {
                    i3 += 4;
                    i2 = i;
                }
                i2++;
            }
            i3++;
            i2++;
        }
        return i3;
    }

    static int int32Size(int i) {
        if (i >= 0) {
            return varint32Size(i);
        }
        return 10;
    }

    public ProtoWriter(jay jay) {
        this.sink = jay;
    }

    public final void writeBytes(ByteString byteString) throws IOException {
        this.sink.O00000o0(byteString);
    }

    public final void writeString(String str) throws IOException {
        this.sink.O00000Oo(str);
    }

    public final void writeTag(int i, FieldEncoding fieldEncoding) throws IOException {
        writeVarint32(makeTag(i, fieldEncoding));
    }

    /* access modifiers changed from: package-private */
    public final void writeSignedVarint32(int i) throws IOException {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64((long) i);
        }
    }

    public final void writeVarint32(int i) throws IOException {
        while ((i & -128) != 0) {
            this.sink.O0000Oo((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            i >>>= 7;
        }
        this.sink.O0000Oo(i);
    }

    public final void writeVarint64(long j) throws IOException {
        while ((-128 & j) != 0) {
            this.sink.O0000Oo((((int) j) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            j >>>= 7;
        }
        this.sink.O0000Oo((int) j);
    }

    public final void writeFixed32(int i) throws IOException {
        this.sink.O0000O0o(i);
    }

    public final void writeFixed64(long j) throws IOException {
        this.sink.O0000o0o(j);
    }
}
