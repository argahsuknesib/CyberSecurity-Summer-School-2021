package _m_j;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.json.JSONException;

public final class dbb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static dbb f14430O000000o;
    private Context O00000Oo;
    private final byte[] O00000o0 = new byte[1];

    private dbb(Context context) {
        this.O00000Oo = context;
    }

    public static synchronized dbb O000000o(Context context) {
        dbb dbb;
        synchronized (dbb.class) {
            if (f14430O000000o == null) {
                f14430O000000o = new dbb(context);
            }
            dbb = f14430O000000o;
        }
        return dbb;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    private FileOutputStream O000000o() throws FileNotFoundException {
        try {
            return new FileOutputStream(O00000o0(), false);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private FileInputStream O00000Oo() throws FileNotFoundException {
        try {
            return new FileInputStream(O00000o0());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private File O00000o0() throws IOException {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/sysdata/config/" + this.O00000Oo.getPackageName());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "sys.cfg");
        if (!file2.exists()) {
            file2.createNewFile();
        }
        return file2;
    }

    public final String O000000o(String str) throws IOException, JSONException {
        synchronized (this.O00000o0) {
            String O000000o2 = dbe.O000000o(this.O00000Oo, str, "");
            if (!TextUtils.isEmpty(O000000o2)) {
                return O000000o2;
            }
            FileInputStream fileInputStream = null;
            try {
                Properties properties = new Properties();
                fileInputStream = O00000Oo();
                if (fileInputStream == null) {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return "";
                }
                properties.load(fileInputStream);
                properties.getProperty(str, "");
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return "";
            } catch (Throwable unused) {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return "";
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004c, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0053 A[Catch:{ all -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0058 A[Catch:{ all -> 0x004d }] */
    public final void O000000o(String str, String str2) throws IOException {
        FileInputStream fileInputStream;
        synchronized (this.O00000o0) {
            dbe.O00000Oo(this.O00000Oo, str, str2);
            FileOutputStream fileOutputStream = null;
            try {
                Properties properties = new Properties();
                fileInputStream = O00000Oo();
                if (fileInputStream != null) {
                    try {
                        properties.load(fileInputStream);
                        if (properties.containsKey(str)) {
                            properties.remove(str);
                        }
                        properties.setProperty(str, str2);
                        fileOutputStream = O000000o();
                        if (fileOutputStream == null) {
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } else {
                            properties.store(fileOutputStream, "");
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } else if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                if (fileOutputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        }
    }
}
