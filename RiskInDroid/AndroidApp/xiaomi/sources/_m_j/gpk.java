package _m_j;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;

public final class gpk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f18124O000000o;

    public static synchronized String O000000o(Context context) {
        String str;
        synchronized (gpk.class) {
            if (f18124O000000o == null) {
                File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(UUID.randomUUID().toString().getBytes());
                        fileOutputStream.close();
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                    byte[] bArr = new byte[((int) randomAccessFile.length())];
                    randomAccessFile.readFully(bArr);
                    randomAccessFile.close();
                    f18124O000000o = new String(bArr);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            str = f18124O000000o;
        }
        return str;
    }
}
