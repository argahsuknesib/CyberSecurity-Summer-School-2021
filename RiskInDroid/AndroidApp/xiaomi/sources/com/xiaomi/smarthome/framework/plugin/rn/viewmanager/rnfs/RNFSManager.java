package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs;

import _m_j.gcv;
import _m_j.gcw;
import _m_j.gcx;
import _m_j.gcz;
import _m_j.gda;
import _m_j.gdb;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "RNFSManager")
public class RNFSManager extends ReactContextBaseJavaModule {
    private SparseArray<gcx> downloaders = new SparseArray<>();
    private ReactApplicationContext reactContext;
    private SparseArray<gdb> uploaders = new SparseArray<>();

    public String getName() {
        return "RNFSManager";
    }

    @ReactMethod
    public void pathForBundle(String str, Promise promise) {
    }

    @ReactMethod
    public void pathForGroup(String str, Promise promise) {
    }

    public RNFSManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    private Uri getFileUri(String str, boolean z) throws IORejectionException {
        Uri parse = Uri.parse(str);
        if (parse.getScheme() != null) {
            return parse;
        }
        File file = new File(str);
        if (z || !file.isDirectory()) {
            return Uri.parse("file://".concat(String.valueOf(str)));
        }
        throw new IORejectionException("EISDIR", "EISDIR: illegal operation on a directory, read '" + str + "'");
    }

    private String getOriginalFilepath(String str, boolean z) throws IORejectionException {
        Uri fileUri = getFileUri(str, z);
        if (fileUri.getScheme().equals("content")) {
            try {
                Cursor query = this.reactContext.getContentResolver().query(fileUri, null, null, null, null);
                if (query.moveToFirst()) {
                    str = query.getString(query.getColumnIndexOrThrow("_data"));
                }
                query.close();
            } catch (IllegalArgumentException unused) {
            }
        }
        return str;
    }

    public InputStream getInputStream(String str) throws IORejectionException {
        try {
            InputStream openInputStream = this.reactContext.getContentResolver().openInputStream(getFileUri(str, false));
            if (openInputStream != null) {
                return openInputStream;
            }
            throw new IORejectionException("ENOENT", "ENOENT: could not open an input stream for '" + str + "'");
        } catch (FileNotFoundException e) {
            throw new IORejectionException("ENOENT", "ENOENT: " + e.getMessage() + ", open '" + str + "'");
        }
    }

    public OutputStream getOutputStream(String str, boolean z) throws IORejectionException {
        try {
            OutputStream openOutputStream = this.reactContext.getContentResolver().openOutputStream(getFileUri(str, false), z ? "wa" : "w");
            if (openOutputStream != null) {
                return openOutputStream;
            }
            throw new IORejectionException("ENOENT", "ENOENT: could not open an output stream for '" + str + "'");
        } catch (FileNotFoundException e) {
            throw new IORejectionException("ENOENT", "ENOENT: " + e.getMessage() + ", open '" + str + "'");
        }
    }

    private static byte[] getInputStreamBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused2) {
        }
        return byteArray;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027 A[SYNTHETIC, Splitter:B:18:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002d A[SYNTHETIC, Splitter:B:22:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @ReactMethod
    public void writeFile(String str, String str2, ReadableMap readableMap, Promise promise) {
        OutputStream outputStream = null;
        try {
            byte[] decode = Base64.decode(str2, 0);
            OutputStream outputStream2 = getOutputStream(str, false);
            try {
                outputStream2.write(decode);
                promise.resolve(null);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                try {
                    e.printStackTrace();
                    reject(promise, str, e);
                    if (outputStream == null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (outputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            reject(promise, str, e);
            if (outputStream == null) {
                try {
                    outputStream.close();
                } catch (IOException unused3) {
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0028 A[SYNTHETIC, Splitter:B:18:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002e A[SYNTHETIC, Splitter:B:22:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @ReactMethod
    public void appendFile(String str, String str2, Promise promise) {
        OutputStream outputStream = null;
        try {
            byte[] decode = Base64.decode(str2, 0);
            OutputStream outputStream2 = getOutputStream(str, true);
            try {
                outputStream2.write(decode);
                promise.resolve(null);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                try {
                    e.printStackTrace();
                    reject(promise, str, e);
                    if (outputStream == null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (outputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            reject(promise, str, e);
            if (outputStream == null) {
                try {
                    outputStream.close();
                } catch (IOException unused3) {
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x004c A[SYNTHETIC, Splitter:B:40:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0053 A[SYNTHETIC, Splitter:B:44:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x005a A[SYNTHETIC, Splitter:B:49:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0061 A[SYNTHETIC, Splitter:B:53:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @ReactMethod
    public void write(String str, String str2, int i, Promise promise) {
        RandomAccessFile randomAccessFile;
        OutputStream outputStream;
        OutputStream outputStream2 = null;
        try {
            byte[] decode = Base64.decode(str2, 0);
            if (i < 0) {
                outputStream = getOutputStream(str, true);
                try {
                    outputStream.write(decode);
                    randomAccessFile = null;
                } catch (Exception e) {
                    e = e;
                    randomAccessFile = null;
                    outputStream2 = outputStream;
                    try {
                        e.printStackTrace();
                        reject(promise, str, e);
                        if (outputStream2 != null) {
                        }
                        if (randomAccessFile == null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = null;
                    outputStream2 = outputStream;
                    if (outputStream2 != null) {
                    }
                    if (randomAccessFile != null) {
                    }
                    throw th;
                }
            } else {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    randomAccessFile.seek((long) i);
                    randomAccessFile.write(decode);
                    outputStream = null;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    reject(promise, str, e);
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile == null) {
                        try {
                            randomAccessFile.close();
                            return;
                        } catch (IOException unused4) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                promise.resolve(null);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused6) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                outputStream2 = outputStream;
                e.printStackTrace();
                reject(promise, str, e);
                if (outputStream2 != null) {
                }
                if (randomAccessFile == null) {
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream2 = outputStream;
                if (outputStream2 != null) {
                }
                if (randomAccessFile != null) {
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            e.printStackTrace();
            reject(promise, str, e);
            if (outputStream2 != null) {
            }
            if (randomAccessFile == null) {
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            if (outputStream2 != null) {
            }
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    @ReactMethod
    public void exists(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(new File(str).exists()));
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
        }
    }

    @ReactMethod
    public void readFile(String str, Promise promise) {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream(str);
            promise.resolve(Base64.encodeToString(getInputStreamBytes(inputStream), 2));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    @ReactMethod
    public void read(String str, int i, int i2, Promise promise) {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream(str);
            byte[] bArr = new byte[i];
            inputStream.skip((long) i2);
            promise.resolve(Base64.encodeToString(bArr, 0, inputStream.read(bArr, 0, i), 2));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    @ReactMethod
    public void readFileAssets(String str, Promise promise) {
        InputStream inputStream = null;
        try {
            inputStream = getReactApplicationContext().getAssets().open(str, 0);
            if (inputStream == null) {
                reject(promise, str, new Exception("Failed to open file"));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } else {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                promise.resolve(Base64.encodeToString(bArr, 2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    @ReactMethod
    public void readFileRes(String str, Promise promise) {
        InputStream inputStream = null;
        try {
            inputStream = getReactApplicationContext().getResources().openRawResource(getResIdentifier(str));
            if (inputStream == null) {
                reject(promise, str, new Exception("Failed to open file"));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } else {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                promise.resolve(Base64.encodeToString(bArr, 2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    private int getResIdentifier(String str) {
        boolean z = true;
        String substring = str.substring(str.lastIndexOf(".") + 1);
        String substring2 = str.substring(0, str.lastIndexOf("."));
        if (!substring.equals("png") && !substring.equals("jpg") && !substring.equals("jpeg") && !substring.equals("bmp") && !substring.equals("gif") && !substring.equals("webp") && !substring.equals("psd") && !substring.equals("svg") && !substring.equals("tiff")) {
            z = false;
        }
        return getReactApplicationContext().getResources().getIdentifier(substring2, Boolean.valueOf(z).booleanValue() ? "drawable" : "raw", getReactApplicationContext().getPackageName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b6 A[SYNTHETIC, Splitter:B:38:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bc A[SYNTHETIC, Splitter:B:42:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    @ReactMethod
    public void hash(String str, String str2, Promise promise) {
        FileInputStream fileInputStream = null;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("md5", "MD5");
            hashMap.put("sha1", "SHA-1");
            hashMap.put("sha224", "SHA-224");
            hashMap.put("sha256", "SHA-256");
            hashMap.put("sha384", "SHA-384");
            hashMap.put("sha512", "SHA-512");
            if (hashMap.containsKey(str2)) {
                File file = new File(str);
                if (file.isDirectory()) {
                    rejectFileIsDirectory(promise);
                } else if (!file.exists()) {
                    rejectFileNotFound(promise, str);
                } else {
                    MessageDigest instance = MessageDigest.getInstance((String) hashMap.get(str2));
                    FileInputStream fileInputStream2 = new FileInputStream(str);
                    try {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            instance.update(bArr, 0, read);
                        }
                        StringBuilder sb = new StringBuilder();
                        byte[] digest = instance.digest();
                        int length = digest.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format("%02x", Byte.valueOf(digest[i])));
                        }
                        promise.resolve(sb.toString());
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            reject(promise, str, e);
                            if (fileInputStream == null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } else {
                throw new Exception("Invalid hash algorithm");
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            reject(promise, str, e);
            if (fileInputStream == null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
            }
        }
    }

    @ReactMethod
    public void moveFile(final String str, String str2, ReadableMap readableMap, final Promise promise) {
        try {
            final File file = new File(str);
            if (!file.renameTo(new File(str2))) {
                new O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs.RNFSManager.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ void onPostExecute(Object obj) {
                        Exception exc = (Exception) obj;
                        if (exc == null) {
                            file.delete();
                            promise.resolve(Boolean.TRUE);
                            return;
                        }
                        exc.printStackTrace();
                        RNFSManager.this.reject(promise, str, exc);
                    }
                }.execute(new String[]{str, str2});
                return;
            }
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
        }
    }

    @ReactMethod
    public void copyFile(final String str, String str2, ReadableMap readableMap, final Promise promise) {
        new O000000o() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs.RNFSManager.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                Exception exc = (Exception) obj;
                if (exc == null) {
                    promise.resolve(null);
                    return;
                }
                exc.printStackTrace();
                RNFSManager.this.reject(promise, str, exc);
            }
        }.execute(new String[]{str, str2});
    }

    class O000000o extends AsyncTask<String, Void, Exception> {
        private O000000o() {
        }

        /* synthetic */ O000000o(RNFSManager rNFSManager, byte b) {
            this();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0046 A[SYNTHETIC, Splitter:B:30:0x0046] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x004d A[SYNTHETIC, Splitter:B:34:0x004d] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0056 A[SYNTHETIC, Splitter:B:41:0x0056] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x005d A[SYNTHETIC, Splitter:B:45:0x005d] */
        /* renamed from: O000000o */
        public Exception doInBackground(String... strArr) {
            OutputStream outputStream;
            InputStream inputStream;
            try {
                String str = strArr[0];
                String str2 = strArr[1];
                inputStream = RNFSManager.this.getInputStream(str);
                try {
                    outputStream = RNFSManager.this.getOutputStream(str2, false);
                } catch (Exception e) {
                    e = e;
                    outputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return e;
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                        Thread.yield();
                    }
                    inputStream.close();
                    outputStream.close();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    return e;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                outputStream = null;
                inputStream = null;
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                return e;
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                inputStream = null;
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                throw th;
            }
        }
    }

    @ReactMethod
    public void readDir(String str, Promise promise) {
        try {
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                WritableArray createArray = Arguments.createArray();
                for (File file2 : listFiles) {
                    WritableMap createMap = Arguments.createMap();
                    double lastModified = (double) file2.lastModified();
                    Double.isNaN(lastModified);
                    createMap.putDouble("mtime", lastModified / 1000.0d);
                    createMap.putString("name", file2.getName());
                    createMap.putString("path", file2.getAbsolutePath());
                    createMap.putDouble("size", (double) file2.length());
                    createMap.putInt("type", file2.isDirectory() ? 1 : 0);
                    createArray.pushMap(createMap);
                }
                promise.resolve(createArray);
                return;
            }
            throw new Exception("Folder does not exist");
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065 A[Catch:{ IOException -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A[Catch:{ IOException -> 0x0074 }] */
    @ReactMethod
    public void readDirAssets(String str, Promise promise) {
        int i;
        boolean z;
        try {
            AssetManager assets = getReactApplicationContext().getAssets();
            String[] list = assets.list(str);
            WritableArray createArray = Arguments.createArray();
            for (String str2 : list) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("name", str2);
                int i2 = 1;
                if (!str.isEmpty()) {
                    str2 = String.format("%s/%s", str, str2);
                }
                createMap.putString("path", str2);
                try {
                    AssetFileDescriptor openFd = assets.openFd(str2);
                    if (openFd != null) {
                        i = (int) openFd.getLength();
                        try {
                            openFd.close();
                            z = false;
                        } catch (IOException e) {
                            e = e;
                            z = !e.getMessage().contains("compressed");
                            createMap.putInt("size", i);
                            if (!z) {
                            }
                            createMap.putInt("type", i2);
                            createArray.pushMap(createMap);
                        }
                    } else {
                        z = true;
                        i = 0;
                    }
                } catch (IOException e2) {
                    e = e2;
                    i = 0;
                    z = !e.getMessage().contains("compressed");
                    createMap.putInt("size", i);
                    if (!z) {
                    }
                    createMap.putInt("type", i2);
                    createArray.pushMap(createMap);
                }
                createMap.putInt("size", i);
                if (!z) {
                    i2 = 0;
                }
                createMap.putInt("type", i2);
                createArray.pushMap(createMap);
            }
            promise.resolve(createArray);
        } catch (IOException e3) {
            reject(promise, str, e3);
        }
    }

    @ReactMethod
    public void copyFileAssets(String str, String str2, Promise promise) {
        try {
            copyInputStream(getReactApplicationContext().getAssets().open(str), str, str2, promise);
        } catch (IOException unused) {
            reject(promise, str, new Exception(String.format("Asset '%s' could not be opened", str)));
        }
    }

    @ReactMethod
    public void copyFileRes(String str, String str2, Promise promise) {
        try {
            copyInputStream(getReactApplicationContext().getResources().openRawResource(getResIdentifier(str)), str, str2, promise);
        } catch (Exception unused) {
            reject(promise, str, new Exception(String.format("Res '%s' could not be opened", str)));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|(3:21|22|34)(1:37)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.resolve(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r1 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0039 */
    @ReactMethod
    public void existsAssets(String str, Promise promise) {
        InputStream inputStream;
        try {
            AssetManager assets = getReactApplicationContext().getAssets();
            try {
                String[] list = assets.list(str);
                if (list != null && list.length > 0) {
                    promise.resolve(Boolean.TRUE);
                    return;
                }
            } catch (Exception unused) {
            }
            inputStream = null;
            inputStream = assets.open(str);
            promise.resolve(Boolean.TRUE);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    @ReactMethod
    public void existsRes(String str, Promise promise) {
        try {
            if (getResIdentifier(str) > 0) {
                promise.resolve(Boolean.TRUE);
            } else {
                promise.resolve(Boolean.FALSE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f A[SYNTHETIC, Splitter:B:27:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[SYNTHETIC, Splitter:B:31:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005c A[SYNTHETIC, Splitter:B:35:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0063 A[SYNTHETIC, Splitter:B:39:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    private void copyInputStream(InputStream inputStream, String str, String str2, Promise promise) {
        OutputStream outputStream;
        Exception e;
        try {
            outputStream = getOutputStream(str2, false);
            try {
                byte[] bArr = new byte[10240];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                promise.resolve(null);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    reject(promise, str, new Exception(String.format("Failed to copy '%s' to %s (%s)", str, str2, e.getLocalizedMessage())));
                    if (inputStream != null) {
                    }
                    if (outputStream == null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            Exception exc = e3;
            outputStream = null;
            e = exc;
            reject(promise, str, new Exception(String.format("Failed to copy '%s' to %s (%s)", str, str2, e.getLocalizedMessage())));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            if (outputStream == null) {
                try {
                    outputStream.close();
                } catch (IOException unused6) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            if (inputStream != null) {
            }
            if (outputStream != null) {
            }
            throw th;
        }
    }

    @ReactMethod
    public void setReadable(String str, Boolean bool, Boolean bool2, Promise promise) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.setReadable(bool.booleanValue(), bool2.booleanValue());
                promise.resolve(Boolean.TRUE);
                return;
            }
            throw new Exception("File does not exist");
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
        }
    }

    @ReactMethod
    public void stat(String str, Promise promise) {
        int i = 1;
        try {
            String originalFilepath = getOriginalFilepath(str, true);
            File file = new File(originalFilepath);
            if (file.exists()) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("ctime", (int) (file.lastModified() / 1000));
                createMap.putInt("mtime", (int) (file.lastModified() / 1000));
                createMap.putDouble("size", (double) file.length());
                if (!file.isDirectory()) {
                    i = 0;
                }
                createMap.putInt("type", i);
                createMap.putString("originalFilepath", originalFilepath);
                promise.resolve(createMap);
                return;
            }
            throw new Exception("File does not exist");
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
        }
    }

    @ReactMethod
    public void unlink(String str, Promise promise) {
        try {
            File file = new File(str);
            if (file.exists()) {
                DeleteRecursive(file);
                promise.resolve(null);
                return;
            }
            throw new Exception("File does not exist");
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
        }
    }

    private void DeleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File DeleteRecursive : file.listFiles()) {
                DeleteRecursive(DeleteRecursive);
            }
        }
        file.delete();
    }

    @ReactMethod
    public void mkdir(String str, ReadableMap readableMap, Promise promise) {
        try {
            File file = new File(str);
            file.mkdirs();
            if (file.exists()) {
                promise.resolve(null);
                return;
            }
            throw new Exception("Directory could not be created");
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
        }
    }

    public void sendEvent(ReactContext reactContext2, String str, WritableMap writableMap) {
        ((RCTNativeAppEventEmitter) reactContext2.getJSModule(RCTNativeAppEventEmitter.class)).emit(str, writableMap);
    }

    @ReactMethod
    public void downloadFile(final ReadableMap readableMap, final Promise promise) {
        try {
            File file = new File(readableMap.getString("toFile"));
            URL url = new URL(readableMap.getString("fromUrl"));
            final int i = readableMap.getInt("jobId");
            ReadableMap map = readableMap.getMap("headers");
            int i2 = readableMap.getInt("progressInterval");
            int i3 = readableMap.getInt("progressDivider");
            int i4 = readableMap.getInt("readTimeout");
            int i5 = readableMap.getInt("connectionTimeout");
            boolean z = readableMap.getBoolean("hasBeginCallback");
            boolean z2 = readableMap.getBoolean("hasProgressCallback");
            gcv gcv = new gcv();
            gcv.f17543O000000o = url;
            gcv.O00000Oo = file;
            gcv.O00000o0 = map;
            gcv.O00000o = i2;
            gcv.O00000oO = (float) i3;
            gcv.O00000oo = i4;
            gcv.O0000O0o = i5;
            gcv.O0000OOo = new gcv.O00000o0() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs.RNFSManager.AnonymousClass3 */

                public final void O000000o(gcw gcw) {
                    if (gcw.O00000o0 == null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putInt("jobId", i);
                        createMap.putInt("statusCode", gcw.f17544O000000o);
                        createMap.putDouble("bytesWritten", (double) gcw.O00000Oo);
                        promise.resolve(createMap);
                        return;
                    }
                    RNFSManager.this.reject(promise, readableMap.getString("toFile"), gcw.O00000o0);
                }
            };
            if (z) {
                gcv.O0000Oo0 = new gcv.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs.RNFSManager.AnonymousClass4 */

                    public final void O000000o(int i, long j, Map<String, String> map) {
                        WritableMap createMap = Arguments.createMap();
                        for (Map.Entry next : map.entrySet()) {
                            createMap.putString((String) next.getKey(), (String) next.getValue());
                        }
                        WritableMap createMap2 = Arguments.createMap();
                        createMap2.putInt("jobId", i);
                        createMap2.putInt("statusCode", i);
                        createMap2.putDouble("contentLength", (double) j);
                        createMap2.putMap("headers", createMap);
                        RNFSManager rNFSManager = RNFSManager.this;
                        rNFSManager.sendEvent(rNFSManager.getReactApplicationContext(), "DownloadBegin", createMap2);
                    }
                };
            }
            if (z2) {
                gcv.O0000Oo = new gcv.O00000Oo() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs.RNFSManager.AnonymousClass5 */

                    public final void O000000o(long j, long j2) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putInt("jobId", i);
                        createMap.putDouble("contentLength", (double) j);
                        createMap.putDouble("bytesWritten", (double) j2);
                        RNFSManager rNFSManager = RNFSManager.this;
                        rNFSManager.sendEvent(rNFSManager.getReactApplicationContext(), "DownloadProgress", createMap);
                    }
                };
            }
            gcx gcx = new gcx();
            gcx.execute(gcv);
            this.downloaders.put(i, gcx);
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, readableMap.getString("toFile"), e);
        }
    }

    @ReactMethod
    public void stopDownload(int i) {
        gcx gcx = this.downloaders.get(i);
        if (gcx != null) {
            gcx.O00000Oo.set(true);
        }
    }

    @ReactMethod
    public void uploadFiles(ReadableMap readableMap, Promise promise) {
        String str;
        final ReadableMap readableMap2 = readableMap;
        final Promise promise2 = promise;
        try {
            ReadableArray array = readableMap2.getArray("files");
            URL url = new URL(readableMap2.getString("toUrl"));
            final int i = readableMap2.getInt("jobId");
            ReadableMap map = readableMap2.getMap("headers");
            ReadableMap map2 = readableMap2.getMap("fields");
            String string = readableMap2.getString("method");
            boolean z = readableMap2.getBoolean("binaryStreamOnly");
            boolean z2 = readableMap2.getBoolean("hasBeginCallback");
            boolean z3 = readableMap2.getBoolean("hasProgressCallback");
            ArrayList<ReadableMap> arrayList = new ArrayList<>();
            gcz gcz = new gcz();
            str = "toUrl";
            int i2 = 0;
            while (i2 < array.size()) {
                try {
                    arrayList.add(array.getMap(i2));
                    i2++;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    reject(promise2, readableMap2.getString(str), e);
                }
            }
            gcz.f17547O000000o = url;
            gcz.O00000Oo = arrayList;
            gcz.O00000o = map;
            gcz.O00000oo = string;
            gcz.O00000oO = map2;
            gcz.O00000o0 = z;
            gcz.O0000O0o = new gcz.O00000Oo() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs.RNFSManager.AnonymousClass6 */

                public final void O000000o(gda gda) {
                    if (gda.O00000o0 == null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putInt("jobId", i);
                        createMap.putInt("statusCode", gda.f17549O000000o);
                        createMap.putMap("headers", gda.O00000Oo);
                        createMap.putString("body", gda.O00000o);
                        promise2.resolve(createMap);
                        return;
                    }
                    RNFSManager.this.reject(promise2, readableMap2.getString("toUrl"), gda.O00000o0);
                }
            };
            if (z2) {
                gcz.O0000Oo0 = new gcz.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs.RNFSManager.AnonymousClass7 */

                    public final void O000000o() {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putInt("jobId", i);
                        RNFSManager rNFSManager = RNFSManager.this;
                        rNFSManager.sendEvent(rNFSManager.getReactApplicationContext(), "UploadBegin", createMap);
                    }
                };
            }
            if (z3) {
                gcz.O0000OOo = new gcz.O00000o0() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs.RNFSManager.AnonymousClass8 */

                    public final void O000000o(int i, int i2) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putInt("jobId", i);
                        createMap.putInt("totalBytesExpectedToSend", i);
                        createMap.putInt("totalBytesSent", i2);
                        RNFSManager rNFSManager = RNFSManager.this;
                        rNFSManager.sendEvent(rNFSManager.getReactApplicationContext(), "UploadProgress", createMap);
                    }
                };
            }
            gdb gdb = new gdb();
            gdb.execute(gcz);
            this.uploaders.put(i, gdb);
        } catch (Exception e2) {
            e = e2;
            str = "toUrl";
            e.printStackTrace();
            reject(promise2, readableMap2.getString(str), e);
        }
    }

    @ReactMethod
    public void stopUpload(int i) {
        gdb gdb = this.uploaders.get(i);
        if (gdb != null) {
            gdb.O00000o0.set(true);
        }
    }

    @ReactMethod
    public void getFSInfo(Promise promise) {
        long j;
        long j2;
        long j3;
        long j4;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j3 = statFs.getTotalBytes();
            long freeBytes = statFs.getFreeBytes();
            j = statFs2.getTotalBytes();
            long freeBytes2 = statFs2.getFreeBytes();
            j4 = freeBytes;
            j2 = freeBytes2;
        } else {
            long blockSize = (long) statFs.getBlockSize();
            j4 = ((long) statFs.getAvailableBlocks()) * blockSize;
            j3 = ((long) statFs.getBlockCount()) * blockSize;
            j2 = 0;
            j = 0;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("totalSpace", (double) j3);
        createMap.putDouble("freeSpace", (double) j4);
        createMap.putDouble("totalSpaceEx", (double) j);
        createMap.putDouble("freeSpaceEx", (double) j2);
        promise.resolve(createMap);
    }

    @ReactMethod
    public void touch(String str, double d, double d2, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(new File(str).setLastModified((long) d)));
        } catch (Exception e) {
            e.printStackTrace();
            reject(promise, str, e);
        }
    }

    @ReactMethod
    public void getAllExternalFilesDirs(Promise promise) {
        File[] externalFilesDirs = getReactApplicationContext().getExternalFilesDirs(null);
        WritableArray createArray = Arguments.createArray();
        for (File file : externalFilesDirs) {
            if (file != null) {
                createArray.pushString(file.getAbsolutePath());
            }
        }
        promise.resolve(createArray);
    }

    @ReactMethod
    public void scanFile(String str, final Promise promise) {
        MediaScannerConnection.scanFile(getReactApplicationContext(), new String[]{str}, null, new MediaScannerConnection.MediaScannerConnectionClient() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnfs.RNFSManager.AnonymousClass9 */

            public final void onMediaScannerConnected() {
            }

            public final void onScanCompleted(String str, Uri uri) {
                promise.resolve(str);
            }
        });
    }

    public void reject(Promise promise, String str, Exception exc) {
        if (exc instanceof FileNotFoundException) {
            rejectFileNotFound(promise, str);
        } else if (exc instanceof IORejectionException) {
            IORejectionException iORejectionException = (IORejectionException) exc;
            promise.reject(iORejectionException.getCode(), iORejectionException.getMessage());
        } else {
            promise.reject((String) null, exc.getMessage());
        }
    }

    private void rejectFileNotFound(Promise promise, String str) {
        promise.reject("ENOENT", "ENOENT: no such file or directory, open '" + str + "'");
    }

    private void rejectFileIsDirectory(Promise promise) {
        promise.reject("EISDIR", "EISDIR: illegal operation on a directory, read");
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("RNFSDocumentDirectory", 0);
        hashMap.put("RNFSDocumentDirectoryPath", getReactApplicationContext().getFilesDir().getAbsolutePath());
        hashMap.put("RNFSTemporaryDirectoryPath", getReactApplicationContext().getCacheDir().getAbsolutePath());
        hashMap.put("RNFSPicturesDirectoryPath", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        hashMap.put("RNFSCachesDirectoryPath", getReactApplicationContext().getCacheDir().getAbsolutePath());
        hashMap.put("RNFSFileTypeRegular", 0);
        hashMap.put("RNFSFileTypeDirectory", 1);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            hashMap.put("RNFSExternalStorageDirectoryPath", externalStorageDirectory.getAbsolutePath());
        } else {
            hashMap.put("RNFSExternalStorageDirectoryPath", null);
        }
        File externalFilesDir = getReactApplicationContext().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            hashMap.put("RNFSExternalDirectoryPath", externalFilesDir.getAbsolutePath());
        } else {
            hashMap.put("RNFSExternalDirectoryPath", null);
        }
        File externalCacheDir = getReactApplicationContext().getExternalCacheDir();
        if (externalCacheDir != null) {
            hashMap.put("RNFSExternalCachesDirectoryPath", externalCacheDir.getAbsolutePath());
        } else {
            hashMap.put("RNFSExternalCachesDirectoryPath", null);
        }
        return hashMap;
    }
}
