package _m_j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

public final class jeb implements jfi {
    public final String[] O000000o(Throwable th) {
        return O00000Oo(th);
    }

    public static String[] O00000Oo(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
        } catch (RuntimeException unused) {
        }
        printWriter.flush();
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(stringWriter.toString()));
        ArrayList arrayList = new ArrayList();
        try {
            for (String readLine = lineNumberReader.readLine(); readLine != null; readLine = lineNumberReader.readLine()) {
                arrayList.add(readLine);
            }
        } catch (IOException e) {
            if (e instanceof InterruptedIOException) {
                Thread.currentThread().interrupt();
            }
            arrayList.add(e.toString());
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }
}
