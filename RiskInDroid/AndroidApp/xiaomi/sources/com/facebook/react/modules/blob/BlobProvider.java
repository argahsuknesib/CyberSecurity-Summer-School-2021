package com.facebook.react.modules.blob;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.react.ReactApplication;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class BlobProvider extends ContentProvider {
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final boolean onCreate() {
        return true;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r3 = r6;
        r6 = r5;
        r5 = r3;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public final ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        Throwable th;
        Throwable th2;
        if (str.equals("r")) {
            Context applicationContext = getContext().getApplicationContext();
            BlobModule blobModule = applicationContext instanceof ReactApplication ? (BlobModule) ((ReactApplication) applicationContext).getReactNativeHost().getReactInstanceManager().getCurrentReactContext().getNativeModule(BlobModule.class) : null;
            if (blobModule != null) {
                byte[] resolve = blobModule.resolve(uri);
                if (resolve != null) {
                    try {
                        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
                        autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
                        autoCloseOutputStream.write(resolve);
                        autoCloseOutputStream.close();
                        return parcelFileDescriptor;
                    } catch (IOException unused) {
                        return null;
                    }
                } else {
                    throw new FileNotFoundException("Cannot open " + uri.toString() + ", blob not found.");
                }
            } else {
                throw new RuntimeException("No blob module associated with BlobProvider");
            }
        } else {
            throw new FileNotFoundException("Cannot open " + uri.toString() + " in mode '" + str + "'");
        }
        throw th2;
        if (th != null) {
            try {
                autoCloseOutputStream.close();
            } catch (Throwable th3) {
                th.addSuppressed(th3);
            }
        } else {
            autoCloseOutputStream.close();
        }
        throw th2;
    }
}
