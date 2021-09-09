package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.util.Base64;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.internal.cd;
import com.google.android.play.core.splitcompat.q;
import com.google.android.play.core.splitinstall.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipException;

public final class dd {

    /* renamed from: a  reason: collision with root package name */
    private static a f3698a;

    static int a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    static AssetLocation a(String str, String str2) throws IOException {
        Long l;
        String str3 = str;
        String str4 = str2;
        q.a(str3 != null, "Attempted to get file location from a null apk path.");
        q.a(str4 != null, String.format("Attempted to get file location in apk %s with a null file path.", str3));
        RandomAccessFile randomAccessFile = new RandomAccessFile(str3, "r");
        byte[] bArr = new byte[22];
        randomAccessFile.seek(randomAccessFile.length() - 22);
        randomAccessFile.readFully(bArr);
        bm a2 = a(bArr, 0) == 1347093766 ? a(bArr) : null;
        byte b = 5;
        if (a2 == null) {
            long length = randomAccessFile.length() - 22;
            long j = -65536 + length;
            if (j < 0) {
                j = 0;
            }
            int min = (int) Math.min(1024L, randomAccessFile.length());
            byte[] bArr2 = new byte[min];
            byte[] bArr3 = new byte[22];
            loop0:
            while (true) {
                long max = Math.max(3 + (length - ((long) min)), j);
                randomAccessFile.seek(max);
                randomAccessFile.readFully(bArr2);
                for (int i = min - 4; i >= 0; i -= 4) {
                    byte b2 = bArr2[i];
                    int i2 = b2 != b ? b2 != 6 ? b2 != 75 ? b2 != 80 ? -1 : 0 : 1 : 3 : 2;
                    if (i2 >= 0 && i >= i2 && a(bArr2, i - i2) == 1347093766) {
                        randomAccessFile.seek((max + ((long) i)) - ((long) i2));
                        randomAccessFile.readFully(bArr3);
                        a2 = a(bArr3);
                        break loop0;
                    }
                    b = 5;
                }
                if (max != j) {
                    length = max;
                } else {
                    throw new ZipException(String.format("End Of Central Directory signature not found in APK %s", str3));
                }
            }
        }
        long j2 = a2.f3657a;
        byte[] bytes = str4.getBytes("UTF-8");
        byte[] bArr4 = new byte[46];
        byte[] bArr5 = new byte[str2.length()];
        long j3 = j2;
        int i3 = 0;
        while (true) {
            if (i3 >= a2.b) {
                l = null;
                break;
            }
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(bArr4);
            int a3 = a(bArr4, 0);
            if (a3 == 1347092738) {
                randomAccessFile.seek(j3 + 28);
                int c = c(bArr4, 28);
                if (c == str2.length()) {
                    randomAccessFile.seek(46 + j3);
                    randomAccessFile.read(bArr5);
                    if (Arrays.equals(bArr5, bytes)) {
                        l = Long.valueOf(b(bArr4, 42));
                        break;
                    }
                }
                j3 += (long) (c + 46 + c(bArr4, 30) + c(bArr4, 32));
                i3++;
            } else {
                throw new ZipException(String.format("Missing central directory file header signature when looking for file %s in APK %s. Read %d entries out of %d. Found %d instead of the header signature %d.", str4, str3, Integer.valueOf(i3), Integer.valueOf(a2.b), Integer.valueOf(a3), 1347092738));
            }
        }
        if (l == null) {
            return null;
        }
        long longValue = l.longValue();
        byte[] bArr6 = new byte[8];
        randomAccessFile.seek(22 + longValue);
        randomAccessFile.readFully(bArr6);
        return AssetLocation.a(str3, longValue + 30 + ((long) c(bArr6, 4)) + ((long) c(bArr6, 6)), b(bArr6, 0));
    }

    static synchronized a a(Context context) {
        a aVar;
        synchronized (dd.class) {
            if (f3698a == null) {
                bt btVar = new bt(null);
                btVar.a(new n(v.a(context)));
                f3698a = btVar.a();
            }
            aVar = f3698a;
        }
        return aVar;
    }

    private static bm a(byte[] bArr) {
        int c = c(bArr, 10);
        b(bArr, 12);
        return new bm(b(bArr, 16), c);
    }

    static String a(List<File> list) throws NoSuchAlgorithmException, IOException {
        int read;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        for (File fileInputStream : list) {
            FileInputStream fileInputStream2 = new FileInputStream(fileInputStream);
            do {
                try {
                    read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    cd.a(th, th);
                }
            } while (read != -1);
            fileInputStream2.close();
        }
        return Base64.encodeToString(instance.digest(), 11);
        throw th;
    }

    public static boolean a(@AssetPackStatus int i) {
        return i == 1 || i == 7 || i == 2 || i == 3;
    }

    static boolean a(@AssetPackStatus int i, @AssetPackStatus int i2) {
        if (i == 5 && i2 != 5) {
            return true;
        }
        if (i == 6 && i2 != 6 && i2 != 5) {
            return true;
        }
        if (i == 4 && i2 != 4) {
            return true;
        }
        if (i == 3 && (i2 == 2 || i2 == 7 || i2 == 1 || i2 == 8)) {
            return true;
        }
        if (i == 2) {
            return i2 == 1 || i2 == 8;
        }
        return false;
    }

    static long b(byte[] bArr, int i) {
        return ((long) ((c(bArr, i + 2) << 16) | c(bArr, i))) & 4294967295L;
    }

    public static boolean b(@AssetPackStatus int i) {
        return i == 5 || i == 6 || i == 4;
    }

    static int c(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public static boolean c(@AssetPackStatus int i) {
        return i == 2 || i == 7 || i == 3;
    }
}
