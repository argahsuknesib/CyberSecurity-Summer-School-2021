package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ein {
    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|8|9|11) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
    public static File O000000o(Context context, InputStream inputStream, String str) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(context.openFileOutput(str, 0));
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return context.getFileStreamPath(str);
                }
            } catch (Throwable th) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                throw th;
            }
        }
    }

    public static Bitmap O000000o(Context context, String str) {
        FileInputStream openFileInput;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            openFileInput = context.openFileInput(str);
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openFileInput.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            O000000o(byteArrayOutputStream);
            O000000o(openFileInput);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray != null) {
                return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            return null;
        } catch (FileNotFoundException unused) {
            AccountLog.e("BitmapUtils", "File is not found");
            return null;
        } catch (IOException unused2) {
            AccountLog.e("BitmapUtils", "Read data error");
            return null;
        } catch (Throwable th) {
            O000000o(byteArrayOutputStream);
            O000000o(openFileInput);
            throw th;
        }
    }

    private static void O000000o(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|2|3|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    private static void O000000o(OutputStream outputStream) {
        outputStream.flush();
        outputStream.close();
    }
}
