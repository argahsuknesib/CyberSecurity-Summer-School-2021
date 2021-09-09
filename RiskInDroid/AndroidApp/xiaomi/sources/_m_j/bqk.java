package _m_j;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.http.HttpEntity;

public final class bqk {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0072, code lost:
        r13.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0075, code lost:
        r6 = r13;
        r7 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r18.O000000o(r15, r4, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0080, code lost:
        _m_j.brl.O000000o(r7);
        _m_j.brl.O000000o(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        if (r3.exists() == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
        if (android.text.TextUtils.isEmpty(r21) != false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0092, code lost:
        r0 = new java.io.File(r3.getParent(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009f, code lost:
        if (r0.exists() != false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a5, code lost:
        if (r3.renameTo(r0) == false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a7, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a9, code lost:
        r0 = new java.io.File(r3.getParent(), java.lang.String.valueOf(java.lang.System.currentTimeMillis()) + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c7, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e5, code lost:
        r0 = th;
     */
    public static File O000000o(HttpEntity httpEntity, bqn bqn, String str, boolean z, String str2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        String str3 = str;
        String str4 = str2;
        BufferedInputStream bufferedInputStream2 = null;
        if (httpEntity == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str3);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                file.createNewFile();
            }
        }
        long j = 0;
        if (z) {
            try {
                j = file.length();
                fileOutputStream = new FileOutputStream(str3, true);
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
                brl.O000000o(bufferedInputStream2);
                brl.O000000o(bufferedOutputStream);
                throw th;
            }
        } else {
            fileOutputStream = new FileOutputStream(str3);
        }
        long contentLength = httpEntity.getContentLength() + j;
        BufferedInputStream bufferedInputStream3 = new BufferedInputStream(httpEntity.getContent());
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
            try {
                if (!bqn.O000000o(contentLength, j, true)) {
                    brl.O000000o(bufferedInputStream3);
                    brl.O000000o(bufferedOutputStream2);
                    return file;
                }
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream3.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream = bufferedOutputStream2;
                    bufferedInputStream = bufferedInputStream3;
                    bufferedOutputStream.write(bArr, 0, read);
                    j += (long) read;
                    if (!bqn.O000000o(contentLength, j, false)) {
                        brl.O000000o(bufferedInputStream);
                        brl.O000000o(bufferedOutputStream);
                        return file;
                    }
                    bufferedOutputStream2 = bufferedOutputStream;
                    bufferedInputStream3 = bufferedInputStream;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream = bufferedInputStream3;
                bufferedInputStream2 = bufferedInputStream;
                brl.O000000o(bufferedInputStream2);
                brl.O000000o(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = bufferedInputStream3;
            bufferedOutputStream = null;
            bufferedInputStream2 = bufferedInputStream;
            brl.O000000o(bufferedInputStream2);
            brl.O000000o(bufferedOutputStream);
            throw th;
        }
    }
}
