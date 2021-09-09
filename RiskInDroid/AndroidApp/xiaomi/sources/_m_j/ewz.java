package _m_j;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class ewz {
    private static boolean O000000o(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean O000000o(File file, InputStream inputStream) {
        if (inputStream == null || !O000000o(file)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        fileOutputStream2.flush();
                        O000000o(fileOutputStream2);
                        O000000o(inputStream);
                        return true;
                    }
                }
            } catch (IOException e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    O000000o(fileOutputStream);
                    O000000o(inputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    O000000o(fileOutputStream2);
                    O000000o(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                O000000o(fileOutputStream2);
                O000000o(inputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            O000000o(fileOutputStream);
            O000000o(inputStream);
            return false;
        }
    }

    private static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean O000000o(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setReadTimeout(60000);
            if (httpURLConnection.getResponseCode() > 300) {
                return false;
            }
            return O000000o(new File(str2), httpURLConnection.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
