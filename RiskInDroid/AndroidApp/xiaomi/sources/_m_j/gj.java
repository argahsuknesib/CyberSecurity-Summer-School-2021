package _m_j;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

public final class gj {

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        long f17823O000000o;
        long O00000Oo;

        O000000o() {
        }
    }

    public static long O000000o(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return O000000o(randomAccessFile, O000000o(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }

    private static O000000o O000000o(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j = 0;
        if (length >= 0) {
            long j2 = length - 65536;
            if (j2 >= 0) {
                j = j2;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() != reverseBytes) {
                    length--;
                } else {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    O000000o o000000o = new O000000o();
                    o000000o.O00000Oo = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    o000000o.f17823O000000o = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    return o000000o;
                }
            } while (length >= j);
            throw new ZipException("End Of Central Directory signature not found");
        }
        throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    private static long O000000o(RandomAccessFile randomAccessFile, O000000o o000000o) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = o000000o.O00000Oo;
        randomAccessFile.seek(o000000o.f17823O000000o);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j));
        }
        return crc32.getValue();
    }
}
