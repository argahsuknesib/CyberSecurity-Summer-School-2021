package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import com.facebook.soloader.ExtractFromZipSoSource;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;

public class ApkSoSource extends ExtractFromZipSoSource {
    public final Map<String, String> mExtractLogs = new HashMap();
    public final int mFlags;

    public ApkSoSource(Context context, String str, int i) {
        super(context, str, new File(context.getApplicationInfo().sourceDir), "^lib/([^/]+)/([^/]+\\.so)$");
        this.mFlags = i;
    }

    /* access modifiers changed from: protected */
    public String getExtractLogs(String str) {
        return this.mExtractLogs.get(str);
    }

    /* access modifiers changed from: protected */
    public UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new ApkUnpacker(this);
    }

    public class ApkUnpacker extends ExtractFromZipSoSource.ZipUnpacker {
        private final int mFlags;
        private File mLibDir;

        ApkUnpacker(ExtractFromZipSoSource extractFromZipSoSource) throws IOException {
            super(extractFromZipSoSource);
            this.mLibDir = new File(ApkSoSource.this.mContext.getApplicationInfo().nativeLibraryDir);
            this.mFlags = ApkSoSource.this.mFlags;
        }

        /* access modifiers changed from: protected */
        public boolean shouldExtract(ZipEntry zipEntry, String str) {
            String str2;
            String name = zipEntry.getName();
            boolean z = true;
            if ((this.mFlags & 1) == 0) {
                str2 = "allowing consideration of " + name + ": self-extraction preferred";
            } else {
                File file = new File(this.mLibDir, str);
                if (!file.isFile()) {
                    str2 = String.format("allowing considering of %s: %s not in system lib dir", name, str);
                } else {
                    long length = file.length();
                    long size = zipEntry.getSize();
                    if (length != size) {
                        str2 = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                    } else {
                        str2 = "not allowing consideration of " + name + ": deferring to libdir";
                        z = false;
                    }
                }
            }
            ApkSoSource.this.mExtractLogs.put(str, str2);
            Log.d("ApkSoSource", str2);
            return z;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getDepsBlock() throws IOException {
        File canonicalFile = this.mZipFileName.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            obtain.writeInt(SysUtil.getAppVersionCode(this.mContext));
            if ((this.mFlags & 1) == 0) {
                obtain.writeByte((byte) 0);
                return obtain.marshall();
            }
            String str = this.mContext.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                obtain.writeByte((byte) 1);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                return marshall;
            }
            File canonicalFile2 = new File(str).getCanonicalFile();
            if (!canonicalFile2.exists()) {
                obtain.writeByte((byte) 1);
                byte[] marshall2 = obtain.marshall();
                obtain.recycle();
                return marshall2;
            }
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile2.getPath());
            obtain.writeLong(canonicalFile2.lastModified());
            byte[] marshall3 = obtain.marshall();
            obtain.recycle();
            return marshall3;
        } finally {
            obtain.recycle();
        }
    }
}
