package com.airbnb.lottie.network;

import _m_j.be;
import android.content.Context;
import com.airbnb.lottie.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class NetworkCache {
    private final Context appContext;
    private final String url;

    NetworkCache(Context context, String str) {
        this.appContext = context.getApplicationContext();
        this.url = str;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public be<FileExtension, InputStream> fetch() {
        FileExtension fileExtension;
        try {
            File cachedFile = getCachedFile(this.url);
            if (cachedFile == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(cachedFile);
            if (cachedFile.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.Zip;
            } else {
                fileExtension = FileExtension.Json;
            }
            L.debug("Cache hit for " + this.url + " at " + cachedFile.getAbsolutePath());
            return new be<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public File writeTempCacheFile(InputStream inputStream, FileExtension fileExtension) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(this.appContext.getCacheDir(), filenameForUrl(this.url, fileExtension, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void renameTempFile(FileExtension fileExtension) {
        File file = new File(this.appContext.getCacheDir(), filenameForUrl(this.url, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        L.debug("Copying temp file to real file (" + file2 + ")");
        if (!renameTo) {
            L.warn("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    private File getCachedFile(String str) throws FileNotFoundException {
        File file = new File(this.appContext.getCacheDir(), filenameForUrl(str, FileExtension.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.appContext.getCacheDir(), filenameForUrl(str, FileExtension.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private static String filenameForUrl(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.extension : fileExtension.tempExtension());
        return sb.toString();
    }
}
