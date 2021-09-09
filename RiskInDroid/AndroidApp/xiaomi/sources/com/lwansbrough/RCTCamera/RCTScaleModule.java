package com.lwansbrough.RCTCamera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class RCTScaleModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "AndroidScaleImage";
    }

    public RCTScaleModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        return super.getConstants();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c6 A[SYNTHETIC, Splitter:B:37:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cc A[SYNTHETIC, Splitter:B:41:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @ReactMethod
    public void scale(ReadableMap readableMap, Promise promise) {
        if (readableMap.hasKey("path")) {
            String string = readableMap.getString("path");
            int i = readableMap.hasKey("targetWidth") ? readableMap.getInt("targetWidth") : 0;
            int i2 = readableMap.hasKey("targetHeight") ? readableMap.getInt("targetHeight") : 0;
            if (i == 0 || i2 == 0) {
                promise.reject("error", "targetWidth or targetHeight is 0!");
            }
            int i3 = 80;
            if (readableMap.hasKey("jpegQuality")) {
                i3 = readableMap.getInt("jpegQuality");
            }
            FileOutputStream fileOutputStream = null;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                BitmapFactory.decodeFile(string, options);
                options.inJustDecodeBounds = false;
                int pow = (int) Math.pow(2.0d, (double) ((int) Math.sqrt((double) Math.max(((float) options.outWidth) / ((float) i), ((float) options.outHeight) / ((float) i2)))));
                if (pow <= 1) {
                    pow = 1;
                }
                options.inSampleSize = pow;
                Bitmap scale = MutableImage.scale(BitmapFactory.decodeFile(string, options), i, i2);
                File file = new File(string + "_scale.jpg");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    scale.compress(Bitmap.CompressFormat.JPEG, i3, fileOutputStream2);
                    fileOutputStream2.flush();
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putString("path", Uri.fromFile(file).toString());
                    promise.resolve(writableNativeMap);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception unused2) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        promise.reject("error", "image scale fail!");
                        if (fileOutputStream == null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
                promise.reject("error", "image scale fail!");
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused5) {
                    }
                }
            }
        } else {
            promise.reject("error", "image not found!");
        }
    }
}
