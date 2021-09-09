package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.cd;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

final class dr {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3711a = new aa("SliceMetadataManager");
    private final byte[] b = new byte[8192];
    private final bc c;
    private final String d;
    private final int e;
    private final long f;
    private final String g;
    private int h;

    dr(bc bcVar, String str, int i, long j, String str2) {
        this.c = bcVar;
        this.d = str;
        this.e = i;
        this.f = j;
        this.g = str2;
        this.h = 0;
    }

    private final File e() {
        File f2 = this.c.f(this.d, this.e, this.f, this.g);
        if (!f2.exists()) {
            f2.mkdirs();
        }
        return f2;
    }

    private final File f() throws IOException {
        File c2 = this.c.c(this.d, this.e, this.f, this.g);
        c2.getParentFile().mkdirs();
        c2.createNewFile();
        return c2;
    }

    /* access modifiers changed from: package-private */
    public final dq a() throws IOException {
        File c2 = this.c.c(this.d, this.e, this.f, this.g);
        if (c2.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(c2);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new by("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.h = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new bk(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e2) {
                    throw new by("Slice checkpoint file corrupt.", e2);
                }
            } catch (Throwable th) {
                cd.a(th, th);
            }
        } else {
            throw new by("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "3");
        properties.put("fileOffset", String.valueOf(b().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(f());
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public final void a(InputStream inputStream, long j) throws IOException {
        int read;
        File b2 = b();
        b2.getParentFile().mkdirs();
        RandomAccessFile randomAccessFile = new RandomAccessFile(b2, "rw");
        randomAccessFile.seek(j);
        do {
            read = inputStream.read(this.b);
            if (read > 0) {
                randomAccessFile.write(this.b, 0, read);
            }
        } while (read == this.b.length);
        randomAccessFile.close();
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(f());
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public final void a(byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        File e2 = e();
        int i = this.h;
        this.h = i + 1;
        try {
            fileOutputStream = new FileOutputStream(new File(e2, String.format("%s-LFH.dat", Integer.valueOf(i))));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return;
        } catch (IOException e3) {
            throw new by("Could not write metadata file.", e3);
        } catch (Throwable th) {
            cd.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void a(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(f());
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
        File d2 = this.c.d(this.d, this.e, this.f, this.g);
        if (d2.exists()) {
            d2.delete();
        }
        FileOutputStream fileOutputStream2 = new FileOutputStream(d2);
        fileOutputStream2.write(bArr);
        fileOutputStream2.close();
    }

    /* access modifiers changed from: package-private */
    public final void a(byte[] bArr, InputStream inputStream) throws IOException {
        File e2 = e();
        int i = this.h;
        this.h = i + 1;
        FileOutputStream fileOutputStream = new FileOutputStream(new File(e2, String.format("%s-NAM.dat", Integer.valueOf(i))));
        fileOutputStream.write(bArr);
        int read = inputStream.read(this.b);
        while (read > 0) {
            fileOutputStream.write(this.b, 0, read);
            read = inputStream.read(this.b);
        }
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public final File b() {
        return new File(e(), String.format("%s-NAM.dat", Integer.valueOf(this.h - 1)));
    }

    /* access modifiers changed from: package-private */
    public final void b(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(f());
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public final int c() throws IOException {
        File c2 = this.c.c(this.d, this.e, this.f, this.g);
        if (!c2.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(c2);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
            return -1;
        }
        if (properties.getProperty("previousChunk") != null) {
            return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
        }
        throw new by("Slice checkpoint file corrupt.");
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        File c2 = this.c.c(this.d, this.e, this.f, this.g);
        if (c2.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(c2);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                if (properties.getProperty("fileStatus") != null) {
                    return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
                }
                f3711a.b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
                return false;
            } catch (IOException e2) {
                f3711a.b("Could not read checkpoint while checking if extraction finished. %s", e2);
            }
        }
        return false;
    }
}
