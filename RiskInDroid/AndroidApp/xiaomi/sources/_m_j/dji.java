package _m_j;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

public final class dji {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final djq f14717O000000o = new djq();
    private static final djr O00000Oo = new djr();

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Properties f14718O000000o;
        byte[] O00000Oo;

        private O000000o() {
            this.f14718O000000o = new Properties();
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final String toString() {
            return "ApkExternalInfo [p=" + this.f14718O000000o + ", otherData=" + Arrays.toString(this.O00000Oo) + "]";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092  */
    private static String O000000o(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] O000000o2 = O000000o(randomAccessFile);
                if (O000000o2 == null) {
                    randomAccessFile.close();
                    return null;
                }
                O000000o o000000o = new O000000o((byte) 0);
                if (O000000o2 != null) {
                    ByteBuffer wrap = ByteBuffer.wrap(O000000o2);
                    byte[] bArr = new byte[2];
                    wrap.get(bArr);
                    if (!O00000Oo.equals(new djr(bArr))) {
                        throw new ProtocolException("unknow protocl [" + Arrays.toString(O000000o2) + "]");
                    } else if (O000000o2.length - 2 > 2) {
                        byte[] bArr2 = new byte[2];
                        wrap.get(bArr2);
                        int i = new djr(bArr2).f14729O000000o;
                        if ((O000000o2.length - 2) - 2 >= i) {
                            byte[] bArr3 = new byte[i];
                            wrap.get(bArr3);
                            o000000o.f14718O000000o.load(new ByteArrayInputStream(bArr3));
                            int length = ((O000000o2.length - 2) - i) - 2;
                            if (length > 0) {
                                o000000o.O00000Oo = new byte[length];
                                wrap.get(o000000o.O00000Oo);
                            }
                        }
                    }
                }
                String property = o000000o.f14718O000000o.getProperty(str);
                randomAccessFile.close();
                return property;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    public static String O000000o(File file) throws IOException {
        return O000000o(file, "channelNo");
    }

    private static byte[] O000000o(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        djq djq = f14717O000000o;
        boolean z = false;
        byte[] bArr = {(byte) ((int) (djq.f14728O000000o & 255)), (byte) ((int) ((djq.f14728O000000o & 65280) >> 8)), (byte) ((int) ((djq.f14728O000000o & 16711680) >> 16)), (byte) ((int) ((djq.f14728O000000o & 4278190080L) >> 24))};
        int read = randomAccessFile.read();
        while (true) {
            if (read != -1) {
                if (read == bArr[0] && randomAccessFile.read() == bArr[1] && randomAccessFile.read() == bArr[2] && randomAccessFile.read() == bArr[3]) {
                    z = true;
                    break;
                }
                length--;
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            } else {
                break;
            }
        }
        if (z) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr2 = new byte[2];
            randomAccessFile.readFully(bArr2);
            int i = new djr(bArr2).f14729O000000o;
            if (i == 0) {
                return null;
            }
            byte[] bArr3 = new byte[i];
            randomAccessFile.read(bArr3);
            return bArr3;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
