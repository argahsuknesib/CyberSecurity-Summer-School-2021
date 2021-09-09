package _m_j;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.ReadableByteChannel;
import org.mp4parser.boxes.iso14496.part12.MovieBox;

public class jhc extends jgx implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static jks f1834O000000o = jks.O000000o(jhc.class);
    private ReadableByteChannel O00000Oo;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public jhc(ReadableByteChannel readableByteChannel) throws IOException {
        this(readableByteChannel, new jhe());
        String[] strArr = new String[0];
    }

    private jhc(ReadableByteChannel readableByteChannel, jgz jgz) throws IOException {
        this.O00000Oo = readableByteChannel;
        initContainer(readableByteChannel, -1, jgz);
    }

    public static byte[] O000000o(String str) {
        byte[] bArr = new byte[4];
        if (str != null) {
            for (int i = 0; i < Math.min(4, str.length()); i++) {
                bArr[i] = (byte) str.charAt(i);
            }
        }
        return bArr;
    }

    public static String O000000o(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(4, 4));
        try {
            return new String(bArr2, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new Error("Required character encoding is missing", e);
        }
    }

    public final MovieBox O000000o() {
        for (jgy next : getBoxes()) {
            if (next instanceof MovieBox) {
                return (MovieBox) next;
            }
        }
        return null;
    }

    public void close() throws IOException {
        this.O00000Oo.close();
    }

    public String toString() {
        return "model(" + this.O00000Oo.toString() + ")";
    }
}
