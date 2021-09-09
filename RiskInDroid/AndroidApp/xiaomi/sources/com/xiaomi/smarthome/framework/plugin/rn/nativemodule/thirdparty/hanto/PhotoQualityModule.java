package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto;

import _m_j.ayy;
import _m_j.ayz;
import android.graphics.Bitmap;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PhotoQualityModule extends HTReactContextBaseJavaModule {
    public String getName() {
        return "HTRCTPhotoQualityModule";
    }

    public PhotoQualityModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3 A[SYNTHETIC, Splitter:B:32:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b5 A[SYNTHETIC, Splitter:B:39:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @ReactMethod
    public void imageCompress(ReadableMap readableMap, final Callback callback) {
        if (isNoNull(readableMap, "sandBoxFolder")) {
            String string = readableMap.getString("sandBoxFolder");
            if (isNoNull(readableMap, "imagePath")) {
                String string2 = readableMap.getString("imagePath");
                if (isNoNull(readableMap, "imageName")) {
                    String string3 = readableMap.getString("imageName");
                    int i = 70;
                    if (isNoNull(readableMap, "quality")) {
                        i = readableMap.getInt("quality");
                    }
                    final WritableNativeMap writableNativeMap = new WritableNativeMap();
                    final WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    AnonymousClass1 r5 = new ayy.O000000o() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.PhotoQualityModule.AnonymousClass1 */

                        public final void O000000o(String str) {
                            writableNativeMap.putString("filePath", ayz.O000000o(str));
                            writableNativeMap2.putInt(HTReactContextBaseJavaModule.RESULT_CODE, HTReactContextBaseJavaModule.SUCCESS_CODE);
                            writableNativeMap2.putMap(HTReactContextBaseJavaModule.RESULT_DATA, writableNativeMap);
                            callback.invoke(writableNativeMap2);
                        }

                        public final void O000000o(int i, String str) {
                            writableNativeMap2.putInt(HTReactContextBaseJavaModule.RESULT_CODE, i);
                            writableNativeMap2.putString(HTReactContextBaseJavaModule.RESULT_MESSAGE, str);
                            writableNativeMap2.putMap(HTReactContextBaseJavaModule.RESULT_DATA, writableNativeMap);
                            callback.invoke(writableNativeMap2);
                        }
                    };
                    if (ayy.O000000o(string, string2, string3, r5)) {
                        String str = string3 + ".jpg";
                        Bitmap O000000o2 = ayy.O000000o(string2.replace("file://", ""));
                        if (O000000o2 == null) {
                            r5.O000000o(-3, "load bitmap failed");
                            return;
                        }
                        FileOutputStream fileOutputStream = null;
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(string, str));
                            try {
                                O000000o2.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream2);
                                r5.O000000o(new File(string, str).getAbsolutePath());
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    r5.O000000o(-1, e.getMessage());
                                }
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    e.printStackTrace();
                                    r5.O000000o(-1, e.getMessage());
                                    if (fileOutputStream == null) {
                                        fileOutputStream.close();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                            r5.O000000o(-1, e3.getMessage());
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            r5.O000000o(-1, e.getMessage());
                            if (fileOutputStream == null) {
                            }
                        }
                    }
                } else {
                    showMessage("imageName is not null");
                }
            } else {
                showMessage("imagePath is not null");
            }
        } else {
            showMessage("sandBoxFolder is not null");
        }
    }

    @ReactMethod
    public void imageSizeQualityCompress(ReadableMap readableMap, final Callback callback) {
        if (isNoNull(readableMap, "sandBoxFolder")) {
            String string = readableMap.getString("sandBoxFolder");
            if (isNoNull(readableMap, "imagePath")) {
                String string2 = readableMap.getString("imagePath");
                if (isNoNull(readableMap, "imageName")) {
                    String string3 = readableMap.getString("imageName");
                    int i = 5120;
                    if (isNoNull(readableMap, "maxSize")) {
                        i = readableMap.getInt("maxSize");
                    }
                    final WritableNativeMap writableNativeMap = new WritableNativeMap();
                    final WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    AnonymousClass2 r5 = new ayy.O000000o() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.PhotoQualityModule.AnonymousClass2 */

                        public final void O000000o(String str) {
                            writableNativeMap.putString("filePath", ayz.O000000o(str));
                            writableNativeMap2.putInt(HTReactContextBaseJavaModule.RESULT_CODE, HTReactContextBaseJavaModule.SUCCESS_CODE);
                            writableNativeMap2.putMap(HTReactContextBaseJavaModule.RESULT_DATA, writableNativeMap);
                            callback.invoke(writableNativeMap2);
                        }

                        public final void O000000o(int i, String str) {
                            writableNativeMap2.putInt(HTReactContextBaseJavaModule.RESULT_CODE, i);
                            writableNativeMap2.putString(HTReactContextBaseJavaModule.RESULT_MESSAGE, str);
                            writableNativeMap2.putMap(HTReactContextBaseJavaModule.RESULT_DATA, writableNativeMap);
                            callback.invoke(writableNativeMap2);
                        }
                    };
                    if (ayy.O000000o(string, string2, string3, r5)) {
                        String str = string3 + ".jpg";
                        Bitmap O000000o2 = ayy.O000000o(string2.replace("file://", ""));
                        if (O000000o2 == null) {
                            r5.O000000o(-3, "load bitmap failed");
                            return;
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                        int i2 = 100;
                        while (true) {
                            O000000o2.compress(compressFormat, i2, byteArrayOutputStream);
                            if (byteArrayOutputStream.toByteArray().length / 1024 > i) {
                                byteArrayOutputStream.reset();
                                i2 -= 10;
                                compressFormat = Bitmap.CompressFormat.JPEG;
                            } else {
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(new File(string, str));
                                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    r5.O000000o(new File(string, str).getAbsolutePath());
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    r5.O000000o(-1, e.getMessage());
                                    return;
                                }
                            }
                        }
                    }
                } else {
                    showMessage("imageName is not null");
                }
            } else {
                showMessage("imagePath is not null");
            }
        } else {
            showMessage("sandBoxFolder is not null");
        }
    }

    @ReactMethod
    public void imageSizeCompress(ReadableMap readableMap, final Callback callback) {
        if (isNoNull(readableMap, "sandBoxFolder")) {
            String string = readableMap.getString("sandBoxFolder");
            if (isNoNull(readableMap, "imagePath")) {
                String string2 = readableMap.getString("imagePath");
                if (isNoNull(readableMap, "imageName")) {
                    String string3 = readableMap.getString("imageName");
                    int i = isNoNull(readableMap, "imageWidth") ? readableMap.getInt("imageWidth") : 2400;
                    int i2 = isNoNull(readableMap, "imageHeight") ? readableMap.getInt("imageHeight") : 3600;
                    int i3 = isNoNull(readableMap, "maxSize") ? readableMap.getInt("maxSize") : 5120;
                    final WritableNativeMap writableNativeMap = new WritableNativeMap();
                    final WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    ayy.O000000o(string2, string, string3, i, i2, i3, new ayy.O000000o() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.PhotoQualityModule.AnonymousClass3 */

                        public final void O000000o(String str) {
                            writableNativeMap.putString("filePath", ayz.O000000o(str));
                            writableNativeMap2.putInt(HTReactContextBaseJavaModule.RESULT_CODE, HTReactContextBaseJavaModule.SUCCESS_CODE);
                            writableNativeMap2.putMap(HTReactContextBaseJavaModule.RESULT_DATA, writableNativeMap);
                            callback.invoke(writableNativeMap2);
                        }

                        public final void O000000o(int i, String str) {
                            writableNativeMap2.putInt(HTReactContextBaseJavaModule.RESULT_CODE, i);
                            writableNativeMap2.putString(HTReactContextBaseJavaModule.RESULT_MESSAGE, str);
                            writableNativeMap2.putMap(HTReactContextBaseJavaModule.RESULT_DATA, writableNativeMap);
                            callback.invoke(writableNativeMap2);
                        }
                    });
                    return;
                }
                showMessage("imageName is not null");
                return;
            }
            showMessage("imagePath is not null");
            return;
        }
        showMessage("sandBoxFolder is not null");
    }
}
