package _m_j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import org.apache.commons.io.output.StringBuilderWriter;

public final class jcu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final char f1767O000000o = File.separatorChar;
    public static final String O00000Oo;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        r5 = r4;
        r4 = r3;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003c, code lost:
        if (r1 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0042, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0043, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0047, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r3 = th;
     */
    static {
        Throwable th;
        Throwable th2;
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter((byte) 0);
        PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
        printWriter.println();
        O00000Oo = stringBuilderWriter.toString();
        printWriter.close();
        stringBuilderWriter.close();
        return;
        throw th2;
        if (th != null) {
            try {
                printWriter.close();
            } catch (Throwable th3) {
                th.addSuppressed(th3);
            }
        } else {
            printWriter.close();
        }
        throw th2;
        throw th;
    }

    public static String O000000o(InputStream inputStream, Charset charset) throws IOException {
        Throwable th;
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        try {
            O000000o(new InputStreamReader(inputStream, jct.O000000o(charset)), stringBuilderWriter, new char[4096]);
            String stringBuilderWriter2 = stringBuilderWriter.toString();
            stringBuilderWriter.close();
            return stringBuilderWriter2;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static long O000000o(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }
}
