package androidx.multidex;

import _m_j.gj;
import _m_j.jdn;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class MultiDexExtractor implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final File f2926O000000o;
    private final long O00000Oo;
    private final RandomAccessFile O00000o;
    private final File O00000o0;
    private final FileChannel O00000oO;
    private final FileLock O00000oo;

    static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    public MultiDexExtractor(File file, File file2) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f2926O000000o = file;
        this.O00000o0 = file2;
        this.O00000Oo = O00000Oo(file);
        File file3 = new File(file2, "MultiDex.lock");
        this.O00000o = new RandomAccessFile(file3, "rw");
        try {
            this.O00000oO = this.O00000o.getChannel();
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.O00000oo = this.O00000oO.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e) {
                e = e;
                O000000o(this.O00000oO);
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                O000000o(this.O00000oO);
                throw e;
            } catch (Error e3) {
                e = e3;
                O000000o(this.O00000oO);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            O000000o(this.O00000o);
            throw e4;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x007c A[SYNTHETIC, Splitter:B:10:0x007c] */
    public final List<? extends File> O000000o(Context context, String str, boolean z) throws IOException {
        List<ExtractedDex> list;
        boolean z2;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f2926O000000o.getPath() + ", " + z + ", " + str + ")");
        if (this.O00000oo.isValid()) {
            if (!z) {
                File file = this.f2926O000000o;
                long j = this.O00000Oo;
                SharedPreferences O000000o2 = O000000o(context);
                if (O000000o2.getLong(str + "timestamp", -1) == O000000o(file)) {
                    if (O000000o2.getLong(str + "crc", -1) == j) {
                        z2 = false;
                        if (!z2) {
                            try {
                                list = O000000o(context, str);
                            } catch (IOException e) {
                                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                            }
                            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                            return list;
                        }
                    }
                }
                z2 = true;
                if (!z2) {
                }
            }
            if (z) {
                Log.i("MultiDex", "Forced extraction must be performed.");
            } else {
                Log.i("MultiDex", "Detected that extraction must be performed.");
            }
            List<ExtractedDex> O000000o3 = O000000o();
            O000000o(context, str, O000000o(this.f2926O000000o), this.O00000Oo, O000000o3);
            list = O000000o3;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public final void close() throws IOException {
        this.O00000oo.release();
        this.O00000oO.close();
        this.O00000o.close();
    }

    private List<ExtractedDex> O000000o(Context context, String str) throws IOException {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        String str3 = this.f2926O000000o.getName() + ".classes";
        SharedPreferences O000000o2 = O000000o(context);
        int i = O000000o2.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + -1);
        int i2 = 2;
        while (i2 <= i) {
            ExtractedDex extractedDex = new ExtractedDex(this.O00000o0, str3 + i2 + ".zip");
            if (extractedDex.isFile()) {
                extractedDex.crc = O00000Oo(extractedDex);
                long j = O000000o2.getLong(str2 + "dex.crc." + i2, -1);
                long j2 = O000000o2.getLong(str2 + "dex.time." + i2, -1);
                long lastModified = extractedDex.lastModified();
                if (j2 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = O000000o2;
                    if (j == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i2++;
                        O000000o2 = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + extractedDex.crc);
            }
            throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
        }
        return arrayList;
    }

    private static long O000000o(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long O00000Oo(File file) throws IOException {
        long O000000o2 = gj.O000000o(file);
        return O000000o2 == -1 ? O000000o2 - 1 : O000000o2;
    }

    private List<ExtractedDex> O000000o() throws IOException {
        ExtractedDex extractedDex;
        boolean z;
        String str = this.f2926O000000o.getName() + ".classes";
        O00000Oo();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f2926O000000o);
        int i = 2;
        try {
            ZipEntry entry = zipFile.getEntry("classes2" + ".dex");
            while (entry != null) {
                extractedDex = new ExtractedDex(this.O00000o0, str + i + ".zip");
                arrayList.add(extractedDex);
                Log.i("MultiDex", "Extraction is needed for file ".concat(String.valueOf(extractedDex)));
                int i2 = 0;
                z = false;
                while (i2 < 3 && !z) {
                    i2++;
                    O000000o(zipFile, entry, extractedDex, str);
                    extractedDex.crc = O00000Oo(extractedDex);
                    z = true;
                    StringBuilder sb = new StringBuilder("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(extractedDex.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(extractedDex.length());
                    sb.append(" - crc: ");
                    sb.append(extractedDex.crc);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                        }
                    }
                }
                if (z) {
                    i++;
                    entry = zipFile.getEntry("classes" + i + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to close resource", e);
            }
            return arrayList;
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to read crc from " + extractedDex.getAbsolutePath(), e2);
            z = false;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
            throw th;
        }
    }

    private static void O000000o(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = O000000o(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + "dex.crc." + i, next.crc);
            edit.putLong(str + "dex.time." + i, next.lastModified());
            i++;
        }
        edit.commit();
    }

    private static SharedPreferences O000000o(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private void O00000Oo() {
        File[] listFiles = this.O00000o0.listFiles(new FileFilter() {
            /* class androidx.multidex.MultiDexExtractor.AnonymousClass1 */

            public final boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.O00000o0.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            }
        }
    }

    private static void O000000o(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    O000000o(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + jdn.f1779O000000o);
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            O000000o(inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static void O000000o(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }
}
