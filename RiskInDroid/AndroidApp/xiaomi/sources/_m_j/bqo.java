package _m_j;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;

public final class bqo {
    /* JADX INFO: finally extract failed */
    public static String O000000o(HttpEntity httpEntity, bqn bqn, String str) throws IOException {
        if (httpEntity == null) {
            return null;
        }
        long j = 0;
        long contentLength = httpEntity.getContentLength();
        if (!bqn.O000000o(contentLength, 0, true)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            InputStream content = httpEntity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content, str));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                    j += brn.O000000o(readLine, str);
                    if (!bqn.O000000o(contentLength, j, false)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            bqn.O000000o(contentLength, j, true);
            brl.O000000o(content);
            return sb.toString().trim();
        } catch (Throwable th) {
            brl.O000000o((Closeable) null);
            throw th;
        }
    }
}
