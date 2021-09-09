package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.viewshot;

import _m_j.gaq;
import _m_j.gsy;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.util.Log;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.UIManagerModule;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class RNViewShotModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "RNViewShot";
    }

    public RNViewShotModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    public Map<String, Object> getConstants() {
        return Collections.emptyMap();
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        new O000000o(getReactApplicationContext(), (byte) 0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void releaseCapture(String str) {
        String path = Uri.parse(str).getPath();
        if (path != null) {
            File file = new File(path);
            if (file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile.equals(this.reactContext.getExternalCacheDir()) || parentFile.equals(this.reactContext.getCacheDir())) {
                    file.delete();
                }
            }
        }
    }

    @ReactMethod
    public void captureRef(int i, ReadableMap readableMap, Promise promise) {
        int i2;
        Integer num;
        Integer num2;
        ReadableMap readableMap2 = readableMap;
        DisplayMetrics displayMetrics = getReactApplicationContext().getResources().getDisplayMetrics();
        String string = readableMap2.getString("format");
        if ("jpg".equals(string)) {
            i2 = 0;
        } else if ("webm".equals(string)) {
            i2 = 2;
        } else {
            i2 = "raw".equals(string) ? -1 : 1;
        }
        double d = readableMap2.getDouble("quality");
        if (readableMap2.hasKey("width")) {
            double d2 = (double) displayMetrics.density;
            double d3 = readableMap2.getDouble("width");
            Double.isNaN(d2);
            num = Integer.valueOf((int) (d2 * d3));
        } else {
            num = null;
        }
        if (readableMap2.hasKey("height")) {
            double d4 = (double) displayMetrics.density;
            double d5 = readableMap2.getDouble("height");
            Double.isNaN(d4);
            num2 = Integer.valueOf((int) (d4 * d5));
        } else {
            num2 = null;
        }
        String string2 = readableMap2.getString("result");
        try {
            ((UIManagerModule) this.reactContext.getNativeModule(UIManagerModule.class)).addUIBlock(new gaq(i, string, i2, d, num, num2, "tmpfile".equals(string2) ? createTempFile(getReactApplicationContext(), string) : null, string2, Boolean.valueOf(readableMap2.getBoolean("snapshotContentContainer")), this.reactContext, getCurrentActivity(), promise));
        } catch (Throwable th) {
            Log.e("RNViewShot", "Failed to snapshot view tag ".concat(String.valueOf(i)), th);
            promise.reject("E_UNABLE_TO_SNAPSHOT", "Failed to snapshot view tag ".concat(String.valueOf(i)));
        }
    }

    @ReactMethod
    public void captureScreen(ReadableMap readableMap, Promise promise) {
        captureRef(-1, readableMap, promise);
    }

    static class O000000o extends GuardedAsyncTask<Void, Void> implements FilenameFilter {

        /* renamed from: O000000o  reason: collision with root package name */
        private final File f8442O000000o;
        private final File O00000Oo;

        /* synthetic */ O000000o(ReactContext reactContext, byte b) {
            this(reactContext);
        }

        private O000000o(ReactContext reactContext) {
            super(reactContext);
            this.f8442O000000o = reactContext.getCacheDir();
            this.O00000Oo = reactContext.getExternalCacheDir();
        }

        public final boolean accept(File file, String str) {
            return str.startsWith("ReactNative-snapshot-image");
        }

        private void O000000o(File file) {
            File[] listFiles = file.listFiles(this);
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.delete()) {
                        gsy.O000000o(3, "RNViewShot", "deleted file: " + file2.getAbsolutePath());
                    }
                }
            }
        }

        public final /* synthetic */ void doInBackgroundGuarded(Object[] objArr) {
            File file = this.f8442O000000o;
            if (file != null) {
                O000000o(file);
            }
            File file2 = this.O00000Oo;
            if (file2 != null) {
                O000000o(file2);
            }
        }
    }

    private File createTempFile(Context context, String str) throws IOException {
        File externalCacheDir = context.getExternalCacheDir();
        File cacheDir = context.getCacheDir();
        if (externalCacheDir == null && cacheDir == null) {
            throw new IOException("No cache directory available");
        }
        if (externalCacheDir != null && (cacheDir == null || externalCacheDir.getFreeSpace() > cacheDir.getFreeSpace())) {
            cacheDir = externalCacheDir;
        }
        return File.createTempFile("ReactNative-snapshot-image", ".".concat(String.valueOf(str)), cacheDir);
    }
}
