package _m_j;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class imr {

    /* renamed from: O000000o  reason: collision with root package name */
    private DataInputStream f1482O000000o = null;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO = 9;
    private int O00000oo = 4;
    private int O0000O0o = 11;
    private int O0000OOo = 7;
    private int O0000Oo = 8;
    private int O0000Oo0 = 2;
    private byte O0000OoO;
    private byte O0000Ooo;
    private String O0000o00;

    private static long O000000o(long j, int i, int i2) {
        return (j << i) | (((long) i2) & (4294967295 >> (32 - i)));
    }

    public imr(InputStream inputStream) throws IOException {
        boolean z = true;
        this.O0000OoO = 1;
        this.O0000Ooo = 4;
        this.O0000o00 = "FLVPARSER";
        this.f1482O000000o = new DataInputStream(inputStream);
        if (((char) this.f1482O000000o.readByte()) == 'F' && ((char) this.f1482O000000o.readByte()) == 'L' && ((char) this.f1482O000000o.readByte()) == 'V') {
            this.f1482O000000o.readUnsignedByte();
            int readUnsignedByte = this.f1482O000000o.readUnsignedByte();
            boolean z2 = (this.O0000OoO & readUnsignedByte) != 0;
            z = (this.O0000Ooo & readUnsignedByte) == 0 ? false : z;
            String str = this.O0000o00;
            imc.O000000o(str, "flv typeFlags=" + readUnsignedByte + " hasVideo=" + z2 + " hasAudio=" + z);
            if (z) {
                int readInt = this.f1482O000000o.readInt();
                imc.O000000o(this.O0000o00, "Audio Stream len:".concat(String.valueOf(readInt)));
                if (readInt != this.O00000oO) {
                    throw new IOException("Unpexpected FLV header length: ".concat(String.valueOf(readInt)));
                }
                return;
            }
            throw new IOException("No Audio Stream");
        }
        throw new IOException("The file is not a FLV file.");
    }

    public final int O000000o(byte[] bArr, int i) throws IOException {
        boolean z;
        byte[] bArr2 = bArr;
        int i2 = 0;
        int i3 = i;
        while (true) {
            int readInt = this.f1482O000000o.readInt();
            String str = this.O0000o00;
            imc.O000000o(str, "previousTagSize=" + readInt + " previousReadBytes=" + i3 + "   result = " + ((i3 - this.O0000OOo) + this.O0000Oo0 + this.O0000O0o));
            if (i3 == 0 || readInt == (i3 - this.O0000OOo) + this.O0000Oo0 + this.O0000O0o) {
                int readUnsignedByte = this.f1482O000000o.readUnsignedByte();
                imc.O000000o(this.O0000o00, "tagType0=".concat(String.valueOf(readUnsignedByte)));
                while (readUnsignedByte != this.O0000Oo) {
                    int O000000o2 = O000000o();
                    imc.O000000o(this.O0000o00, "next data size =".concat(String.valueOf(O000000o2)));
                    this.f1482O000000o.skipBytes(O000000o2 + this.O0000O0o);
                    readUnsignedByte = this.f1482O000000o.readUnsignedByte();
                    imc.O000000o(this.O0000o00, "tagType=".concat(String.valueOf(readUnsignedByte)));
                }
                int O000000o3 = O000000o();
                int readInt2 = this.f1482O000000o.readInt();
                int O000000o4 = O000000o();
                String str2 = this.O0000o00;
                imc.O000000o(str2, "previousTagSize=" + readInt + " dataSize = " + O000000o3 + ", timestamps = " + readInt2 + ", streamId = " + O000000o4);
                if (O000000o3 != 0) {
                    int readUnsignedByte2 = this.f1482O000000o.readUnsignedByte();
                    int readUnsignedByte3 = this.f1482O000000o.readUnsignedByte();
                    String str3 = this.O0000o00;
                    imc.O000000o(str3, "audioHeader=" + readUnsignedByte2 + " head=" + readUnsignedByte3);
                    if (readUnsignedByte3 != 0) {
                        z = false;
                    } else {
                        int readByte = (((this.f1482O000000o.readByte() & 255) * 256) + (this.f1482O000000o.readByte() & 255)) << 16;
                        if (O000000o3 > 4) {
                            this.f1482O000000o.skipBytes(O000000o3 - 4);
                        }
                        this.O00000Oo = readByte >> 27;
                        int i4 = readByte << 5;
                        this.O00000o0 = i4 >> 28;
                        this.O00000o = (i4 << 4) >> 28;
                        String str4 = this.O0000o00;
                        imc.O000000o(str4, "aacProf=" + this.O00000Oo + " sampleRateIndex=" + this.O00000o0 + " channelConfig=" + this.O00000o);
                        int i5 = this.O00000Oo;
                        if (i5 >= 0 && i5 <= 3) {
                            if (this.O00000o0 > 12) {
                                throw new IOException("Invalid AAC sample rate index.");
                            } else if (this.O00000o <= 6) {
                                z = true;
                            } else {
                                throw new IOException("Invalid AAC channel configuration.");
                            }
                        }
                    }
                    if (!z) {
                        int i6 = O000000o3 - this.O0000Oo0;
                        long O000000o5 = O000000o(O000000o(O000000o(0, 12, 4095), 3, i2), 1, 1);
                        bArr2[i2] = (byte) ((int) (O000000o5 >> 8));
                        bArr2[1] = (byte) ((int) O000000o5);
                        int i7 = i6 + 7;
                        long O000000o6 = O000000o(O000000o(O000000o(O000000o(O000000o(O000000o(0, 2, this.O00000Oo - 1), 4, this.O00000o0), 1, i2), 3, this.O00000o), 4, i2), 2, i7 & 6144);
                        bArr2[2] = (byte) ((int) (O000000o6 >> 8));
                        bArr2[3] = (byte) ((int) O000000o6);
                        long O000000o7 = O000000o(O000000o(O000000o(0, 11, i7 & 2047), 11, 2047), 2, 0);
                        bArr2[4] = (byte) ((int) (O000000o7 >> 16));
                        bArr2[5] = (byte) ((int) (O000000o7 >> 8));
                        bArr2[6] = (byte) ((int) O000000o7);
                        int i8 = i6;
                        this.f1482O000000o.readFully(bArr2, this.O0000OOo, i8);
                        i2 = this.O0000OOo + i8;
                    }
                    if (i2 != 0) {
                        return i2;
                    }
                    i2 = 0;
                }
                i3 = 0;
            } else {
                throw new IOException("previousTagSize not equal previousReadBytes");
            }
        }
        throw new IOException("Unsupported AAC profile.");
    }

    private int O000000o() throws IOException {
        return (this.f1482O000000o.read() << 16) + (this.f1482O000000o.read() << 8) + this.f1482O000000o.read();
    }
}
