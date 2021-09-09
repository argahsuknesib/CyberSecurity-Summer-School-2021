package com.facebook.react.modules.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

@ReactModule(name = "CameraRollManager")
public class CameraRollManager extends ReactContextBaseJavaModule {
    public static final String[] PROJECTION = {"_id", "mime_type", "bucket_display_name", "datetaken", "width", "height", "longitude", "latitude", "_data"};

    public String getName() {
        return "CameraRollManager";
    }

    public CameraRollManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void saveToCameraRoll(String str, String str2, Promise promise) {
        new SaveToCameraRoll(getReactApplicationContext(), Uri.parse(str), promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static class SaveToCameraRoll extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;
        public final Promise mPromise;
        private final Uri mUri;

        public SaveToCameraRoll(ReactContext reactContext, Uri uri, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mUri = uri;
            this.mPromise = promise;
        }

        /* JADX INFO: additional move instructions added (2) to help type inference */
        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r4v14, types: [java.nio.channels.ReadableByteChannel] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:113:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0055 A[Catch:{ IOException -> 0x0136, all -> 0x0134 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x006f A[SYNTHETIC, Splitter:B:21:0x006f] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0157  */
        public void doInBackgroundGuarded(Void... voidArr) {
            FileChannel fileChannel;
            FileChannel fileChannel2;
            FileChannel fileChannel3;
            FileChannel fileChannel4;
            File externalStoragePublicDirectory;
            String str;
            int i;
            File file = new File(this.mUri.getPath());
            FileChannel fileChannel5 = null;
            try {
                String scheme = this.mUri.getScheme();
                if (!scheme.equals("http")) {
                    if (!scheme.equals("https")) {
                        fileChannel3 = new FileInputStream(file).getChannel();
                        externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                        externalStoragePublicDirectory.mkdirs();
                        if (externalStoragePublicDirectory.isDirectory()) {
                            this.mPromise.reject("E_UNABLE_TO_LOAD", "External media storage directory not available");
                            if (fileChannel3 != null && fileChannel3.isOpen()) {
                                try {
                                    fileChannel3.close();
                                    return;
                                } catch (IOException e) {
                                    FLog.e("ReactNative", "Could not close input channel", e);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            File file2 = new File(externalStoragePublicDirectory, file.getName());
                            String name = file.getName();
                            if (name.indexOf(46) >= 0) {
                                i = 0;
                                String substring = name.substring(0, name.lastIndexOf(46));
                                str = name.substring(name.lastIndexOf(46));
                                name = substring;
                            } else {
                                str = "";
                                i = 0;
                            }
                            while (!file2.createNewFile()) {
                                file2 = new File(externalStoragePublicDirectory, name + "_" + i + str);
                                i++;
                            }
                            FileChannel channel = new FileOutputStream(file2).getChannel();
                            try {
                                ByteBuffer allocate = ByteBuffer.allocate(ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
                                while (fileChannel3.read(allocate) > 0) {
                                    allocate.flip();
                                    channel.write(allocate);
                                    allocate.compact();
                                }
                                allocate.flip();
                                while (allocate.hasRemaining()) {
                                    channel.write(allocate);
                                }
                                fileChannel3.close();
                                channel.close();
                                MediaScannerConnection.scanFile(this.mContext, new String[]{file2.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {
                                    /* class com.facebook.react.modules.camera.CameraRollManager.SaveToCameraRoll.AnonymousClass1 */

                                    public void onScanCompleted(String str, Uri uri) {
                                        if (uri != null) {
                                            SaveToCameraRoll.this.mPromise.resolve(uri.toString());
                                        } else {
                                            SaveToCameraRoll.this.mPromise.reject("E_UNABLE_TO_SAVE", "Could not add image to gallery");
                                        }
                                    }
                                });
                                if (fileChannel3 != null && fileChannel3.isOpen()) {
                                    try {
                                        fileChannel3.close();
                                    } catch (IOException e2) {
                                        FLog.e("ReactNative", "Could not close input channel", e2);
                                    }
                                }
                                if (channel != null && channel.isOpen()) {
                                    try {
                                        channel.close();
                                        return;
                                    } catch (IOException e3) {
                                        FLog.e("ReactNative", "Could not close output channel", e3);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } catch (IOException e4) {
                                fileChannel4 = fileChannel3;
                                fileChannel2 = channel;
                                e = e4;
                                fileChannel5 = fileChannel4;
                                try {
                                    this.mPromise.reject(e);
                                    try {
                                        fileChannel5.close();
                                    } catch (IOException e5) {
                                        FLog.e("ReactNative", "Could not close input channel", e5);
                                    }
                                    if (fileChannel2 == null) {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    FileChannel fileChannel6 = fileChannel2;
                                    fileChannel = fileChannel5;
                                    fileChannel5 = fileChannel6;
                                    if (fileChannel != null && fileChannel.isOpen()) {
                                        try {
                                            fileChannel.close();
                                        } catch (IOException e6) {
                                            FLog.e("ReactNative", "Could not close input channel", e6);
                                        }
                                    }
                                    if (fileChannel5 != null && fileChannel5.isOpen()) {
                                        try {
                                            fileChannel5.close();
                                        } catch (IOException e7) {
                                            FLog.e("ReactNative", "Could not close output channel", e7);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                fileChannel5 = channel;
                                th = th3;
                                fileChannel = fileChannel3;
                                fileChannel.close();
                                fileChannel5.close();
                                throw th;
                            }
                        }
                    }
                }
                fileChannel3 = Channels.newChannel(new URL(this.mUri.toString()).openStream());
                try {
                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                    externalStoragePublicDirectory.mkdirs();
                    if (externalStoragePublicDirectory.isDirectory()) {
                    }
                } catch (IOException e8) {
                    e = e8;
                    fileChannel4 = fileChannel3;
                    fileChannel2 = null;
                    fileChannel5 = fileChannel4;
                    this.mPromise.reject(e);
                    if (fileChannel5 != null && fileChannel5.isOpen()) {
                        fileChannel5.close();
                    }
                    if (fileChannel2 == null && fileChannel2.isOpen()) {
                        try {
                            fileChannel2.close();
                        } catch (IOException e9) {
                            FLog.e("ReactNative", "Could not close output channel", e9);
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileChannel = fileChannel3;
                    fileChannel.close();
                    fileChannel5.close();
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
                fileChannel2 = null;
                this.mPromise.reject(e);
                fileChannel5.close();
                if (fileChannel2 == null) {
                }
            } catch (Throwable th5) {
                th = th5;
                fileChannel = null;
                fileChannel.close();
                fileChannel5.close();
                throw th;
            }
        }
    }

    @ReactMethod
    public void getPhotos(ReadableMap readableMap, Promise promise) {
        int i = readableMap.getInt("first");
        String string = readableMap.hasKey("after") ? readableMap.getString("after") : null;
        String string2 = readableMap.hasKey("groupName") ? readableMap.getString("groupName") : null;
        String string3 = readableMap.hasKey("assetType") ? readableMap.getString("assetType") : "Photos";
        ReadableArray array = readableMap.hasKey("mimeTypes") ? readableMap.getArray("mimeTypes") : null;
        if (!readableMap.hasKey("groupTypes")) {
            new GetMediaTask(getReactApplicationContext(), i, string, string2, array, string3, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new JSApplicationIllegalArgumentException("groupTypes is not supported on Android");
    }

    static class GetMediaTask extends GuardedAsyncTask<Void, Void> {
        private final String mAfter;
        private final String mAssetType;
        private final Context mContext;
        private final int mFirst;
        private final String mGroupName;
        private final ReadableArray mMimeTypes;
        private final Promise mPromise;

        private GetMediaTask(ReactContext reactContext, int i, String str, String str2, ReadableArray readableArray, String str3, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mFirst = i;
            this.mAfter = str;
            this.mGroupName = str2;
            this.mMimeTypes = readableArray;
            this.mPromise = promise;
            this.mAssetType = str3;
        }

        /* access modifiers changed from: protected */
        public void doInBackgroundGuarded(Void... voidArr) {
            Cursor query;
            StringBuilder sb = new StringBuilder("1");
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.mAfter)) {
                sb.append(" AND datetaken < ?");
                arrayList.add(this.mAfter);
            }
            if (!TextUtils.isEmpty(this.mGroupName)) {
                sb.append(" AND bucket_display_name = ?");
                arrayList.add(this.mGroupName);
            }
            String str = this.mAssetType;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1905167199) {
                if (hashCode != -1732810888) {
                    if (hashCode == 65921 && str.equals("All")) {
                        c = 2;
                    }
                } else if (str.equals("Videos")) {
                    c = 1;
                }
            } else if (str.equals("Photos")) {
                c = 0;
            }
            if (c == 0) {
                sb.append(" AND media_type = 1");
            } else if (c == 1) {
                sb.append(" AND media_type = 3");
            } else if (c != 2) {
                Promise promise = this.mPromise;
                promise.reject("E_UNABLE_TO_FILTER", "Invalid filter option: '" + this.mAssetType + "'. Expected one of 'Photos', 'Videos" + "' or 'All'.");
                return;
            } else {
                sb.append(" AND media_type IN (3,1)");
            }
            ReadableArray readableArray = this.mMimeTypes;
            if (readableArray != null && readableArray.size() > 0) {
                sb.append(" AND mime_type IN (");
                for (int i = 0; i < this.mMimeTypes.size(); i++) {
                    sb.append("?,");
                    arrayList.add(this.mMimeTypes.getString(i));
                }
                sb.replace(sb.length() - 1, sb.length(), ")");
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ContentResolver contentResolver = this.mContext.getContentResolver();
            try {
                query = contentResolver.query(MediaStore.Files.getContentUri("external"), CameraRollManager.PROJECTION, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "datetaken DESC, date_modified DESC LIMIT " + (this.mFirst + 1));
                if (query == null) {
                    this.mPromise.reject("E_UNABLE_TO_LOAD", "Could not get media");
                    return;
                }
                CameraRollManager.putEdges(contentResolver, query, writableNativeMap, this.mFirst);
                CameraRollManager.putPageInfo(query, writableNativeMap, this.mFirst);
                query.close();
                this.mPromise.resolve(writableNativeMap);
            } catch (SecurityException e) {
                this.mPromise.reject("E_UNABLE_TO_LOAD_PERMISSION", "Could not get media: need READ_EXTERNAL_STORAGE permission", e);
            } catch (Throwable th) {
                query.close();
                this.mPromise.resolve(writableNativeMap);
                throw th;
            }
        }
    }

    public static void putPageInfo(Cursor cursor, WritableMap writableMap, int i) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("has_next_page", i < cursor.getCount());
        if (i < cursor.getCount()) {
            cursor.moveToPosition(i - 1);
            writableNativeMap.putString("end_cursor", cursor.getString(cursor.getColumnIndex("datetaken")));
        }
        writableMap.putMap("page_info", writableNativeMap);
    }

    public static void putEdges(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i) {
        WritableNativeArray writableNativeArray;
        Cursor cursor2 = cursor;
        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
        cursor.moveToFirst();
        int columnIndex = cursor2.getColumnIndex("_id");
        int columnIndex2 = cursor2.getColumnIndex("mime_type");
        int columnIndex3 = cursor2.getColumnIndex("bucket_display_name");
        int columnIndex4 = cursor2.getColumnIndex("datetaken");
        int columnIndex5 = cursor2.getColumnIndex("width");
        int columnIndex6 = cursor2.getColumnIndex("height");
        int columnIndex7 = cursor2.getColumnIndex("longitude");
        int columnIndex8 = cursor2.getColumnIndex("latitude");
        int columnIndex9 = cursor2.getColumnIndex("_data");
        int i2 = i;
        int i3 = 0;
        while (i3 < i2 && !cursor.isAfterLast()) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            WritableNativeMap writableNativeMap3 = writableNativeMap2;
            WritableNativeArray writableNativeArray3 = writableNativeArray2;
            WritableNativeMap writableNativeMap4 = writableNativeMap;
            int i4 = i3;
            int i5 = columnIndex;
            int i6 = columnIndex8;
            int i7 = columnIndex5;
            int i8 = columnIndex7;
            if (putImageInfo(contentResolver, cursor, writableNativeMap2, columnIndex, columnIndex5, columnIndex6, columnIndex9, columnIndex2)) {
                WritableNativeMap writableNativeMap5 = writableNativeMap3;
                putBasicNodeInfo(cursor2, writableNativeMap5, columnIndex2, columnIndex3, columnIndex4);
                putLocationInfo(cursor2, writableNativeMap5, i8, i6);
                writableNativeMap4.putMap("node", writableNativeMap5);
                writableNativeArray = writableNativeArray3;
                writableNativeArray.pushMap(writableNativeMap4);
            } else {
                writableNativeArray = writableNativeArray3;
                i4--;
            }
            cursor.moveToNext();
            i3 = i4 + 1;
            i2 = i;
            writableNativeArray2 = writableNativeArray;
            columnIndex8 = i6;
            columnIndex7 = i8;
            columnIndex = i5;
            columnIndex5 = i7;
        }
        writableMap.putArray("edges", writableNativeArray2);
    }

    private static void putBasicNodeInfo(Cursor cursor, WritableMap writableMap, int i, int i2, int i3) {
        writableMap.putString("type", cursor.getString(i));
        writableMap.putString("group_name", cursor.getString(i2));
        double d = (double) cursor.getLong(i3);
        Double.isNaN(d);
        writableMap.putDouble("timestamp", d / 1000.0d);
    }

    private static boolean putImageInfo(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, int i2, int i3, int i4, int i5) {
        AssetFileDescriptor openAssetFileDescriptor;
        MediaMetadataRetriever mediaMetadataRetriever;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Uri parse = Uri.parse("file://" + cursor.getString(i4));
        writableNativeMap.putString("uri", parse.toString());
        float f = (float) cursor.getInt(i2);
        float f2 = (float) cursor.getInt(i3);
        String string = cursor.getString(i5);
        if (string != null && string.startsWith("video")) {
            try {
                openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(parse, "r");
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(openAssetFileDescriptor.getFileDescriptor());
                if (f <= 0.0f || f2 <= 0.0f) {
                    try {
                        f = (float) Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        f2 = (float) Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    } catch (NumberFormatException e) {
                        FLog.e("ReactNative", "Number format exception occurred while trying to fetch video metadata for " + parse.toString(), e);
                        mediaMetadataRetriever.release();
                        openAssetFileDescriptor.close();
                        return false;
                    }
                }
                writableNativeMap.putInt("playableDuration", Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / 1000);
                mediaMetadataRetriever.release();
                openAssetFileDescriptor.close();
            } catch (Exception e2) {
                FLog.e("ReactNative", "Could not get video metadata for " + parse.toString(), e2);
                return false;
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                openAssetFileDescriptor.close();
                throw th;
            }
        }
        if (f <= 0.0f || f2 <= 0.0f) {
            try {
                AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(parse, "r");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(openAssetFileDescriptor2.getFileDescriptor(), null, options);
                float f3 = (float) options.outWidth;
                float f4 = (float) options.outHeight;
                openAssetFileDescriptor2.close();
                float f5 = f3;
                f2 = f4;
                f = f5;
            } catch (IOException e3) {
                FLog.e("ReactNative", "Could not get width/height for " + parse.toString(), e3);
                return false;
            }
        }
        writableNativeMap.putDouble("width", (double) f);
        writableNativeMap.putDouble("height", (double) f2);
        writableMap.putMap("image", writableNativeMap);
        return true;
    }

    private static void putLocationInfo(Cursor cursor, WritableMap writableMap, int i, int i2) {
        double d = cursor.getDouble(i);
        double d2 = cursor.getDouble(i2);
        if (d > 0.0d || d2 > 0.0d) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("longitude", d);
            writableNativeMap.putDouble("latitude", d2);
            writableMap.putMap("location", writableNativeMap);
        }
    }
}
