package _m_j;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class gdd {
    private static final HashMap<String, int[]> O00000o;
    private static final String O00000o0 = "gdd";

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17555O000000o = -1;
    public String O00000Oo = null;
    private int O00000oO = -1;
    private Mat O00000oo = null;
    private Mat O0000O0o = null;
    private HashMap<String, Mat> O0000OOo = new HashMap<>();

    static {
        HashMap<String, int[]> hashMap = new HashMap<>();
        O00000o = hashMap;
        hashMap.put("add", new int[]{2, 4});
        O00000o.put("accumulate", new int[]{1, 3});
        O00000o.put("accumulateProduct", new int[]{2, 4});
        O00000o.put("accumulateSquare", new int[]{1, 3});
        O00000o.put("accumulateWeighted", new int[]{1, 4});
        O00000o.put("applyColorMap", new int[]{1, 3});
        O00000o.put("bitwise_and", new int[]{2, 4});
        O00000o.put("bitwise_not", new int[]{1, 3});
        O00000o.put("bitwise_or", new int[]{2, 4});
        O00000o.put("bitwise_xor", new int[]{2, 4});
        O00000o.put("connectedComponents", new int[]{0, 2});
        O00000o.put("connectedComponentsWithAlgorithm", new int[]{0, 5});
        O00000o.put("connectedComponentsWithStatsWithAlgorithm", new int[]{0, 7});
        O00000o.put("dilate", new int[]{1, 3});
        O00000o.put("distanceTransformWithLabels", new int[]{1, 5});
        O00000o.put("erode", new int[]{1, 3});
        O00000o.put("filter2D", new int[]{1, 4});
        O00000o.put("findContours", new int[]{1, 5});
        O00000o.put("floodFill", new int[]{0, 4});
        O00000o.put("mulTransposed", new int[]{1, 4});
        O00000o.put("normalize", new int[]{1, 7});
        O00000o.put("morphologyEx", new int[]{1, 4});
        O00000o.put("perspectiveTransform", new int[]{1, 3});
        O00000o.put("remap", new int[]{1, 5});
        O00000o.put("sepFilter2D", new int[]{1, 5});
        O00000o.put("spatialGradient", new int[]{0, 3});
        O00000o.put("subtract", new int[]{2, 4});
        O00000o.put("transform", new int[]{1, 3});
        O00000o.put("undistort", new int[]{1, 4});
        O00000o.put("undistortPoints", new int[]{1, 4});
        O00000o.put("undistortPointsIter", new int[]{1, 7});
        O00000o.put("warpAffine", new int[]{1, 4});
        O00000o.put("warpPerspective", new int[]{1, 4});
        O00000o.put("warpPolar", new int[]{1, 6});
        O00000o.put("watershed", new int[]{0, 2});
    }

    public gdd() {
    }

    public gdd(Mat mat, Mat mat2) {
        if (mat != null) {
            this.O00000oo = mat;
        }
        if (mat2 != null) {
            this.O0000O0o = mat2;
        }
    }

    private static int O00000Oo(ReadableMap readableMap) {
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        int i = 0;
        while (keySetIterator.hasNextKey()) {
            keySetIterator.nextKey();
            i++;
        }
        return i;
    }

    private Object[] O000000o(String str, ReadableMap readableMap, Class[] clsArr) {
        String str2 = str;
        ReadableMap readableMap2 = readableMap;
        Class[] clsArr2 = clsArr;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        for (Class cls : clsArr2) {
            String concat = "p".concat(String.valueOf(i));
            ReadableType type = readableMap2.getType(concat);
            if (type == ReadableType.String) {
                String string = readableMap2.getString(concat);
                Mat mat = null;
                if (string.equals("rgba")) {
                    mat = this.O00000oo;
                } else if (string.equals("rgbat")) {
                    mat = this.O00000oo.t();
                } else if (string.equals("gray")) {
                    mat = this.O0000O0o;
                } else if (string.equals("grayt")) {
                    mat = this.O0000O0o.t();
                } else if (this.O0000OOo.containsKey(string)) {
                    mat = this.O0000OOo.get(string);
                }
                if (mat != null) {
                    if (cls == Mat.class) {
                        arrayList.add(mat);
                    } else if (cls == List.class) {
                        arrayList.add(Arrays.asList(mat));
                    }
                } else if (cls == String.class) {
                    arrayList.add(string);
                }
            } else if (type == ReadableType.Map) {
                ReadableMap map = readableMap2.getMap(concat);
                if (cls == Mat.class || cls == List.class) {
                    int i2 = map.getInt("matIndex");
                    gdg.O000000o();
                    Mat mat2 = (Mat) gdg.O000000o(i2);
                    if (cls == Mat.class) {
                        arrayList.add(mat2);
                    } else {
                        arrayList.add(Arrays.asList(mat2));
                    }
                    if (O00000o.containsKey(str2)) {
                        int[] iArr = O00000o.get(str2);
                        if (clsArr2.length < iArr[1]) {
                            this.O00000oO = i - 1;
                            this.f17555O000000o = i2;
                        } else if (iArr[0] == i - 1) {
                            this.O00000oO = iArr[0];
                            this.f17555O000000o = i2;
                        }
                    } else {
                        this.O00000oO = i - 1;
                        this.f17555O000000o = i2;
                    }
                } else if (cls == MatOfInt.class) {
                    int i3 = map.getInt("matIndex");
                    gdg.O000000o();
                    arrayList.add((MatOfInt) gdg.O000000o(i3));
                } else if (cls == MatOfFloat.class) {
                    int i4 = map.getInt("matIndex");
                    gdg.O000000o();
                    arrayList.add((MatOfFloat) gdg.O000000o(i4));
                } else if (cls == Point.class) {
                    arrayList.add(new Point(map.getDouble("x"), map.getDouble("y")));
                } else if (cls == Scalar.class) {
                    ReadableArray array = map.getArray("vals");
                    double d = array.getDouble(0);
                    double d2 = array.getDouble(1);
                    double d3 = array.getDouble(2);
                    double d4 = array.getDouble(3);
                    Scalar scalar = r11;
                    Scalar scalar2 = new Scalar(d, d2, d3, d4);
                    arrayList.add(scalar);
                } else if (cls == Size.class) {
                    arrayList.add(new Size(map.getDouble("width"), map.getDouble("height")));
                } else if (cls == Rect.class) {
                    arrayList.add(new Rect(map.getInt("top"), map.getInt("left"), map.getInt("width"), map.getInt("height")));
                }
            } else if (type == ReadableType.Number) {
                if (cls == Integer.TYPE) {
                    arrayList.add(Integer.valueOf(readableMap2.getInt(concat)));
                } else if (cls == Double.TYPE) {
                    arrayList.add(Double.valueOf(readableMap2.getDouble(concat)));
                }
            } else if (type == ReadableType.Array && cls == List.class) {
                arrayList.add(readableMap2.getArray(concat).toArrayList());
            }
            i++;
        }
        return arrayList.toArray(new Object[arrayList.size()]);
    }

    private static Method O000000o(String str, ReadableMap readableMap, Class cls) {
        int O00000Oo2 = readableMap != null ? O00000Oo(readableMap) : 0;
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        for (int i = 0; i < length; i++) {
            Method method = declaredMethods[i];
            if (method.getName().equals(str) && (O00000Oo2 <= 0 || O00000Oo2 == method.getParameterTypes().length)) {
                return method;
            }
        }
        return null;
    }

    private static WritableArray O000000o(ReadableArray readableArray) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i = 0; i < readableArray.size(); i++) {
            switch (readableArray.getType(i)) {
                case String:
                    writableNativeArray.pushString(readableArray.getString(i));
                    break;
                case Number:
                    writableNativeArray.pushDouble(readableArray.getDouble(i));
                    break;
                case Boolean:
                    writableNativeArray.pushBoolean(readableArray.getBoolean(i));
                    break;
                case Map:
                    writableNativeArray.pushMap(O00000o0(readableArray.getMap(i)));
                    break;
                case Array:
                    writableNativeArray.pushArray(O000000o(readableArray.getArray(i)));
                    break;
                case Null:
                    writableNativeArray.pushString(null);
                    break;
            }
        }
        return writableNativeArray;
    }

    private static WritableMap O00000o0(ReadableMap readableMap) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (readableMap.getType(nextKey)) {
                case String:
                    writableNativeMap.putString(nextKey, readableMap.getString(nextKey));
                    break;
                case Number:
                    writableNativeMap.putDouble(nextKey, readableMap.getDouble(nextKey));
                    break;
                case Boolean:
                    writableNativeMap.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case Map:
                    writableNativeMap.putMap(nextKey, O00000o0(readableMap.getMap(nextKey)));
                    break;
                case Array:
                    writableNativeMap.putArray(nextKey, O000000o(readableMap.getArray(nextKey)));
                    break;
                case Null:
                    writableNativeMap.putString(nextKey, null);
                    break;
            }
        }
        return writableNativeMap;
    }

    private int O00000o(ReadableMap readableMap) {
        ReadableArray array = readableMap.getArray("ins");
        ReadableArray array2 = readableMap.getArray("functions");
        ReadableArray array3 = readableMap.getArray("paramsArr");
        ReadableArray array4 = readableMap.getArray("outs");
        ReadableArray array5 = readableMap.getArray("callbacks");
        int i = -1;
        for (int size = array2.size() - 1; size >= 0; size--) {
            String string = array.getString(size);
            String string2 = array2.getString(size);
            ReadableMap map = array3.getMap(size);
            String string3 = array4.getString(size);
            array5.getType(size);
            if (size == 0) {
                this.O00000Oo = array5.getString(size);
                i = O000000o(string, string2, map, string3);
            } else {
                O000000o(string, string2, map, string3);
            }
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0120, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0122, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        _m_j.gsy.O000000o(6, _m_j.gdd.O00000o0, r12.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012d, code lost:
        return 1003;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0131, code lost:
        return 1002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0134, code lost:
        return 1001;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0137, code lost:
        return 1000;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054 A[Catch:{ SecurityException -> 0x0137, IllegalAccessException -> 0x0134, InvocationTargetException -> 0x0131, Exception -> 0x0122, all -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0109 A[SYNTHETIC, Splitter:B:66:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0122 A[ExcHandler: Exception (r12v4 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:5:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[ExcHandler: InvocationTargetException (unused java.lang.reflect.InvocationTargetException), SYNTHETIC, Splitter:B:5:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[ExcHandler: IllegalAccessException (unused java.lang.IllegalAccessException), SYNTHETIC, Splitter:B:5:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[ExcHandler: SecurityException (unused java.lang.SecurityException), SYNTHETIC, Splitter:B:5:0x0017] */
    public final int O000000o(String str, String str2, ReadableMap readableMap, String str3) {
        Method method;
        Object[] objArr;
        int i;
        int O00000Oo2 = readableMap != null ? O00000Oo(readableMap) : 0;
        if (str != null) {
            try {
                if (!str.equals("") && (str.equals("rgba") || str.equals("rgbat") || str.equals("gray") || str.equals("grayt") || this.O0000OOo.containsKey(str))) {
                    method = O000000o(str2, readableMap, Mat.class);
                    if (method == null) {
                        Mat mat = null;
                        if (O00000Oo2 > 0) {
                            objArr = O000000o(str2, readableMap, method.getParameterTypes());
                            if (O00000Oo2 != objArr.length) {
                                throw new Exception("One of the parameters is invalid and " + str2 + " cannot be invoked.");
                            }
                        } else {
                            objArr = null;
                        }
                        if (method != null) {
                            if (str != null && str.equals("rgba")) {
                                mat = this.O00000oo;
                            } else if (str != null && str.equals("rgbat")) {
                                mat = this.O00000oo.t();
                            } else if (str != null && str.equals("gray")) {
                                mat = this.O0000O0o;
                            } else if (str != null && str.equals("grayt")) {
                                mat = this.O0000O0o.t();
                            } else if (str != null && this.O0000OOo.containsKey(str)) {
                                mat = this.O0000OOo.get(str);
                            }
                            if (str3 != null && !str3.equals("")) {
                                this.O0000OOo.put(str3, (Mat) method.invoke(mat, objArr));
                            } else if (str2.equals("release")) {
                                mat.release();
                                this.O0000OOo.remove(str);
                            } else {
                                method.invoke(mat, objArr);
                            }
                        }
                        if (this.f17555O000000o < 0) {
                            return -1;
                        }
                        gdg.O000000o();
                        gdg.O000000o(this.f17555O000000o, (Mat) objArr[this.O00000oO]);
                        i = this.f17555O000000o;
                        this.f17555O000000o = -1;
                        this.O00000oO = -1;
                        return i;
                    }
                    throw new Exception(str2 + " not found make sure method exists and is part of Opencv Imgproc, Core or Mat.");
                }
            } catch (SecurityException unused) {
            } catch (IllegalAccessException unused2) {
            } catch (InvocationTargetException unused3) {
            } catch (Exception e) {
            } catch (Throwable unused4) {
                return 1003;
            }
        }
        method = O000000o(str2, readableMap, Imgproc.class);
        if (method == null) {
            method = O000000o(str2, readableMap, Core.class);
        }
        if (method == null) {
        }
    }

    public final WritableArray O000000o(ReadableMap readableMap) {
        int i;
        String str;
        int i2;
        ReadableArray readableArray;
        ReadableArray readableArray2;
        WritableMap writableMap;
        ReadableMap readableMap2 = readableMap;
        String str2 = "";
        if (readableMap2.hasKey("groupids")) {
            ReadableArray array = readableMap2.getArray("groupids");
            if (array != null && array.size() > 0) {
                ArrayList arrayList = new ArrayList();
                ReadableArray array2 = readableMap2.getArray("ins");
                String str3 = "functions";
                ReadableArray array3 = readableMap2.getArray(str3);
                String str4 = "paramsArr";
                ReadableArray array4 = readableMap2.getArray(str4);
                String str5 = "outs";
                ReadableArray array5 = readableMap2.getArray(str5);
                String str6 = "callbacks";
                ReadableArray array6 = readableMap2.getArray(str6);
                ReadableArray array7 = readableMap2.getArray("groupids");
                new WritableNativeArray();
                if (array7.size() > 0) {
                    int i3 = 0;
                    while (i3 < array7.size()) {
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        String str7 = str2;
                        WritableNativeArray writableNativeArray = new WritableNativeArray();
                        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
                        ArrayList arrayList2 = arrayList;
                        WritableNativeArray writableNativeArray3 = new WritableNativeArray();
                        String str8 = str6;
                        WritableNativeArray writableNativeArray4 = new WritableNativeArray();
                        String str9 = str5;
                        WritableNativeArray writableNativeArray5 = new WritableNativeArray();
                        String str10 = str4;
                        String string = array7.getString(i3);
                        String str11 = str3;
                        while (i3 < array7.size() && array7.getString(i3).equals(string)) {
                            String string2 = array2.getString(i3);
                            ReadableArray readableArray3 = array7;
                            String string3 = array3.getString(i3);
                            if (array4 == null || array4.getMap(i3) == null) {
                                readableArray2 = array2;
                                readableArray = array3;
                                writableMap = null;
                            } else {
                                readableArray = array3;
                                readableArray2 = array2;
                                writableMap = O00000o0(array4.getMap(i3));
                            }
                            String string4 = array5.getString(i3);
                            String str12 = string;
                            String string5 = array6.getString(i3);
                            writableNativeArray.pushString(string2);
                            writableNativeArray2.pushString(string3);
                            writableNativeArray3.pushMap(writableMap);
                            writableNativeArray4.pushString(string4);
                            writableNativeArray5.pushString(string5);
                            i3++;
                            array7 = readableArray3;
                            array2 = readableArray2;
                            array3 = readableArray;
                            string = str12;
                        }
                        ReadableArray readableArray4 = array7;
                        writableNativeMap.putArray("ins", writableNativeArray);
                        String str13 = str11;
                        writableNativeMap.putArray(str13, writableNativeArray2);
                        String str14 = str10;
                        writableNativeMap.putArray(str14, writableNativeArray3);
                        String str15 = str9;
                        writableNativeMap.putArray(str15, writableNativeArray4);
                        String str16 = str8;
                        writableNativeMap.putArray(str16, writableNativeArray5);
                        ArrayList arrayList3 = arrayList2;
                        arrayList3.add(writableNativeMap);
                        str4 = str14;
                        str3 = str13;
                        str5 = str15;
                        arrayList = arrayList3;
                        array2 = array2;
                        array3 = array3;
                        array7 = readableArray4;
                        str6 = str16;
                        str2 = str7;
                    }
                }
                ArrayList arrayList4 = arrayList;
                String str17 = str2;
                Object[] array8 = arrayList4.toArray(new Object[arrayList4.size()]);
                WritableNativeArray writableNativeArray6 = new WritableNativeArray();
                int length = array8.length - 1;
                while (length >= 0) {
                    this.f17555O000000o = O00000o((ReadableMap) array8[length]);
                    String str18 = this.O00000Oo;
                    if (str18 != null) {
                        str = str17;
                        if (!str18.equals(str) && (i2 = this.f17555O000000o) >= 0 && i2 < 1000) {
                            gdg.O000000o();
                            writableNativeArray6.pushArray(gdg.O000000o(this.f17555O000000o, 0, 0));
                        }
                    } else {
                        str = str17;
                    }
                    length--;
                    str17 = str;
                }
                return writableNativeArray6;
            }
        } else {
            String str19 = str2;
            this.f17555O000000o = O00000o(readableMap);
            String str20 = this.O00000Oo;
            if (str20 != null && !str20.equals(str19) && (i = this.f17555O000000o) >= 0 && i < 1000) {
                gdg.O000000o();
                return gdg.O000000o(this.f17555O000000o, 0, 0);
            }
        }
        return null;
    }
}
