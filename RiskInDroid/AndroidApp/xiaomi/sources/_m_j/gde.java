package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableNativeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class gde {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f17557O000000o = "gde";
    private static gde O00000Oo;

    private gde() {
    }

    public static gde O000000o() {
        if (O00000Oo == null) {
            O00000Oo = new gde();
        }
        return O00000Oo;
    }

    private static void O000000o(Promise promise, String str, Exception exc) {
        if (exc instanceof FileNotFoundException) {
            O000000o(promise, str);
        } else {
            promise.reject((String) null, exc.getMessage());
        }
    }

    private static void O000000o(Promise promise, String str) {
        promise.reject("ENOENT", "ENOENT: no such file or directory, open '" + str + "'");
    }

    private static void O00000Oo(Promise promise, String str) {
        promise.reject("EINVAL", "EINVAL: invalid parameter, read '" + str + "'");
    }

    public static void O000000o(String str, Promise promise) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    File file = new File(str);
                    if (!file.exists()) {
                        O000000o(promise, str);
                        return;
                    } else if (file.isDirectory()) {
                        promise.reject("EISDIR", "EISDIR: illegal operation on a directory, open '" + str + "'");
                        return;
                    } else {
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        if (decodeFile != null) {
                            Mat mat = new Mat(decodeFile.getHeight(), decodeFile.getWidth(), CvType.CV_8UC4);
                            Utils.O000000o(decodeFile, mat);
                            gdg.O000000o();
                            int O000000o2 = gdg.O000000o(mat);
                            WritableNativeMap writableNativeMap = new WritableNativeMap();
                            writableNativeMap.putInt("cols", mat.cols());
                            writableNativeMap.putInt("rows", mat.rows());
                            writableNativeMap.putInt("matIndex", O000000o2);
                            promise.resolve(writableNativeMap);
                            return;
                        }
                        throw new IOException("Decoding error unable to decode: ".concat(String.valueOf(str)));
                    }
                }
            } catch (Exception e) {
                O000000o(promise, "EGENERIC", e);
                return;
            }
        }
        O00000Oo(promise, str);
    }

    public static void O000000o(Mat mat, String str, Promise promise) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(mat.cols(), mat.rows(), Bitmap.Config.ARGB_8888);
                    Utils.O000000o(mat, createBitmap);
                    int width = createBitmap.getWidth();
                    int height = createBitmap.getHeight();
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    int lastIndexOf = str.lastIndexOf(46);
                    if (lastIndexOf > 0) {
                        String lowerCase = str.substring(lastIndexOf + 1).toLowerCase();
                        if (lowerCase.equals("png")) {
                            createBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        } else {
                            if (!lowerCase.equals("jpg")) {
                                if (!lowerCase.equals("jpeg")) {
                                    O00000Oo(promise, str);
                                    fileOutputStream.close();
                                    return;
                                }
                            }
                            createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                        }
                        fileOutputStream.close();
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putInt("width", width);
                        writableNativeMap.putInt("height", height);
                        writableNativeMap.putString("uri", str);
                        promise.resolve(writableNativeMap);
                        return;
                    }
                    O00000Oo(promise, str);
                    fileOutputStream.close();
                    return;
                }
            } catch (Exception e) {
                O000000o(promise, "EGENERIC", e);
                return;
            }
        }
        O00000Oo(promise, str);
    }
}
