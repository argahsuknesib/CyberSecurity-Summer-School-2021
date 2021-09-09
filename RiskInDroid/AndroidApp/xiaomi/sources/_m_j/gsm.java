package _m_j;

import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Response;

public abstract class gsm extends gsl<File, gsf> {
    static final /* synthetic */ boolean O0000Ooo = (!gsm.class.desiredAssertionStatus());
    protected final File O0000OOo;
    protected final boolean O0000Oo;
    protected final boolean O0000Oo0;
    public volatile boolean O0000OoO;

    public abstract void O000000o(File file);

    public /* synthetic */ void onSuccess(Object obj, Response response) {
        O000000o((File) obj);
    }

    public gsm(File file) {
        this(file, (byte) 0);
    }

    private gsm(File file, byte b) {
        this(file, false, false);
    }

    public gsm(File file, boolean z, boolean z2) {
        this.O0000OoO = false;
        O00000Oo(file);
        this.O0000OOo = file;
        this.O0000Oo0 = false;
        this.O0000Oo = z2;
        this.O0000OoO = false;
    }

    public static boolean O00000Oo(File file) {
        if (file == null || file.isDirectory()) {
            return false;
        }
        if (file.getParentFile().isDirectory() || file.getParentFile().mkdirs()) {
            return true;
        }
        return false;
    }

    private File O000000o() {
        if (O0000Ooo || this.O0000OOo != null) {
            return this.O0000OOo;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:18|19|20|21|22|23|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0053=Splitter:B:23:0x0053, B:14:0x003f=Splitter:B:14:0x003f} */
    private void O000000o(Response response) {
        InputStream byteStream;
        FileOutputStream fileOutputStream;
        int read;
        if (response.isSuccessful()) {
            try {
                byteStream = response.body().byteStream();
                long contentLength = response.body().contentLength();
                fileOutputStream = new FileOutputStream(O000000o(), this.O0000Oo0);
                if (byteStream != null) {
                    byte[] bArr = new byte[4096];
                    int i = 0;
                    while (!this.O0000OoO && (read = byteStream.read(bArr)) != -1) {
                        i += read;
                        fileOutputStream.write(bArr, 0, read);
                        sendProgressMessage((long) i, contentLength);
                    }
                    gox.O000000o(byteStream);
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                }
                sendSuccessMessage(O000000o(), response);
            } catch (Exception e) {
                sendFailureMessage(new gsf(-1, ""), e, response);
            } catch (Throwable th) {
                gox.O000000o(byteStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                throw th;
            }
        } else {
            sendFailureMessage(new gsf(response.code(), ""), null, response);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:27|28|29|30|31|32|33) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0074 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0060=Splitter:B:23:0x0060, B:32:0x0074=Splitter:B:32:0x0074} */
    public void processResponse(Response response) {
        InputStream byteStream;
        FileOutputStream fileOutputStream;
        int read;
        long[] O000000o2;
        if (!this.O0000Oo) {
            O000000o(response);
        } else if (response.isSuccessful()) {
            try {
                byteStream = response.body().byteStream();
                long contentLength = response.body().contentLength();
                long j = 0;
                String header = response.header("Content-Range");
                if (!TextUtils.isEmpty(header) && (O000000o2 = gsh.O000000o(header)) != null && O000000o2.length >= 3) {
                    j = O000000o2[0];
                    contentLength = O000000o2[2];
                }
                fileOutputStream = new FileOutputStream(O000000o(), true);
                if (byteStream != null) {
                    byte[] bArr = new byte[4096];
                    int i = 0;
                    while (!this.O0000OoO && (read = byteStream.read(bArr)) != -1) {
                        i += read;
                        fileOutputStream.write(bArr, 0, read);
                        sendProgressMessage(((long) i) + j, contentLength);
                    }
                    gox.O000000o(byteStream);
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (!this.O0000OoO) {
                    sendSuccessMessage(O000000o(), response);
                }
            } catch (Exception e) {
                sendFailureMessage(new gsf(-1, ""), e, response);
            } catch (Throwable th) {
                gox.O000000o(byteStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                throw th;
            }
        } else {
            sendFailureMessage(new gsf(response.code(), ""), null, response);
        }
    }

    public void processFailure(Call call, IOException iOException) {
        sendFailureMessage(new gsf(-1, ""), iOException, null);
    }
}
