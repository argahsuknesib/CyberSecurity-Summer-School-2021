package _m_j;

import _m_j.jof;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import pl.droidsonroids.relinker.MissingLibraryException;

public final class joe implements jof.O000000o {

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public ZipFile f1993O000000o;
        public ZipEntry O00000Oo;

        public O000000o(ZipFile zipFile, ZipEntry zipEntry) {
            this.f1993O000000o = zipFile;
            this.O00000Oo = zipEntry;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00a2 A[SYNTHETIC, Splitter:B:68:0x00a2] */
    public final void O000000o(Context context, String[] strArr, String str, File file, jog jog) {
        O000000o o000000o;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            o000000o = O000000o(context, strArr, str, jog);
            if (o000000o != null) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i < 5) {
                        try {
                            jog.O000000o("Found %s! Extracting...", str);
                            try {
                                if (file.exists() || file.createNewFile()) {
                                    inputStream = o000000o.f1993O000000o.getInputStream(o000000o.O00000Oo);
                                    try {
                                        fileOutputStream = new FileOutputStream(file);
                                    } catch (FileNotFoundException unused) {
                                        fileOutputStream = null;
                                        O000000o(inputStream);
                                        O000000o(fileOutputStream);
                                        i = i2;
                                    } catch (IOException unused2) {
                                        fileOutputStream = null;
                                        O000000o(inputStream);
                                        O000000o(fileOutputStream);
                                        i = i2;
                                    } catch (Throwable th) {
                                        th = th;
                                        O000000o(inputStream);
                                        O000000o(fileOutputStream2);
                                        throw th;
                                    }
                                    try {
                                        long O000000o2 = O000000o(inputStream, fileOutputStream);
                                        fileOutputStream.getFD().sync();
                                        if (O000000o2 != file.length()) {
                                            O000000o(inputStream);
                                            O000000o(fileOutputStream);
                                            i = i2;
                                        } else {
                                            O000000o(inputStream);
                                            O000000o(fileOutputStream);
                                            file.setReadable(true, false);
                                            file.setExecutable(true, false);
                                            file.setWritable(true);
                                            if (o000000o != null) {
                                                try {
                                                    if (o000000o.f1993O000000o != null) {
                                                        o000000o.f1993O000000o.close();
                                                        return;
                                                    }
                                                    return;
                                                } catch (IOException unused3) {
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                    } catch (FileNotFoundException unused4) {
                                        O000000o(inputStream);
                                        O000000o(fileOutputStream);
                                        i = i2;
                                    } catch (IOException unused5) {
                                        O000000o(inputStream);
                                        O000000o(fileOutputStream);
                                        i = i2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileOutputStream2 = fileOutputStream;
                                        O000000o(inputStream);
                                        O000000o(fileOutputStream2);
                                        throw th;
                                    }
                                } else {
                                    i = i2;
                                }
                            } catch (IOException unused6) {
                            }
                        } catch (FileNotFoundException unused7) {
                            inputStream = null;
                            fileOutputStream = null;
                            O000000o(inputStream);
                            O000000o(fileOutputStream);
                            i = i2;
                        } catch (IOException unused8) {
                            inputStream = null;
                            fileOutputStream = null;
                            O000000o(inputStream);
                            O000000o(fileOutputStream);
                            i = i2;
                        } catch (Throwable th3) {
                            th = th3;
                            if (o000000o != null) {
                                try {
                                    if (o000000o.f1993O000000o != null) {
                                        o000000o.f1993O000000o.close();
                                    }
                                } catch (IOException unused9) {
                                }
                            }
                            throw th;
                        }
                    } else if (o000000o != null) {
                        try {
                            if (o000000o.f1993O000000o != null) {
                                o000000o.f1993O000000o.close();
                                return;
                            }
                            return;
                        } catch (IOException unused10) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                throw new MissingLibraryException(str);
            }
        } catch (Throwable th4) {
            th = th4;
            o000000o = null;
            if (o000000o != null) {
            }
            throw th;
        }
    }

    private static long O000000o(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                outputStream.flush();
                return j;
            }
        }
    }

    private static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static O000000o O000000o(Context context, String[] strArr, String str, jog jog) {
        String[] strArr2;
        String[] strArr3 = strArr;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        char c = 0;
        if (Build.VERSION.SDK_INT < 21 || applicationInfo.splitSourceDirs == null || applicationInfo.splitSourceDirs.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[(applicationInfo.splitSourceDirs.length + 1)];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(applicationInfo.splitSourceDirs, 0, strArr2, 1, applicationInfo.splitSourceDirs.length);
        }
        int length = strArr2.length;
        ZipFile zipFile = null;
        int i = 0;
        while (i < length) {
            String str2 = strArr2[i];
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i2 = i3;
                }
            }
            if (zipFile != null) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 < 5) {
                        int length2 = strArr3.length;
                        int i6 = 0;
                        while (i6 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr3[i6] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c] = str3;
                            objArr[1] = str2;
                            jog.O000000o("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new O000000o(zipFile, entry);
                            }
                            i6++;
                            c = 0;
                        }
                        i4 = i5;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i++;
            c = 0;
        }
        return null;
    }
}
