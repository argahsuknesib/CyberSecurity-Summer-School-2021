package _m_j;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import java.util.ArrayList;
import java.util.Iterator;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Scalar;

public class gdg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f17559O000000o = "gdg";
    private static ArrayList O00000Oo = new ArrayList();
    private static gdg O00000o0 = null;

    private gdg() {
    }

    public static gdg O000000o() {
        if (O00000o0 == null) {
            O00000o0 = new gdg();
        }
        return O00000o0;
    }

    public static int O00000Oo() {
        int size = O00000Oo.size();
        O00000Oo.add(new Mat());
        return size;
    }

    public static int O000000o(int i, int i2, int i3, ReadableMap readableMap) {
        Mat mat;
        int size = O00000Oo.size();
        if (readableMap != null) {
            ReadableArray array = readableMap.getArray("vals");
            mat = new Mat(i, i2, i3, new Scalar(array.getDouble(0), array.getDouble(1), array.getDouble(2), array.getDouble(3)));
        } else {
            mat = new Mat(i, i2, i3);
        }
        O00000Oo.add(mat);
        return size;
    }

    public static int O000000o(int i, int i2) {
        MatOfInt matOfInt;
        int size = O00000Oo.size();
        if (i == i2) {
            matOfInt = new MatOfInt(i);
        } else {
            matOfInt = new MatOfInt(i, i2);
        }
        O00000Oo.add(matOfInt);
        return size;
    }

    public static int O000000o(float f, float f2) {
        MatOfFloat matOfFloat;
        int size = O00000Oo.size();
        if (f == f2) {
            matOfFloat = new MatOfFloat(f);
        } else {
            matOfFloat = new MatOfFloat(f, f2);
        }
        O00000Oo.add(matOfFloat);
        return size;
    }

    public static int O000000o(Object obj) {
        int size = O00000Oo.size();
        O00000Oo.add(obj);
        return size;
    }

    public static Object O000000o(int i) {
        if (i < 0 || i >= O00000Oo.size()) {
            return null;
        }
        return O00000Oo.get(i);
    }

    public static void O000000o(int i, Object obj) {
        O00000Oo.set(i, obj);
    }

    public static WritableArray O000000o(int i, int i2, int i3) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        Mat mat = (Mat) O000000o(i);
        if (mat.rows() > 0 && mat.cols() > 0) {
            float[] fArr = new float[(mat.rows() * mat.cols() * mat.channels())];
            mat.get(i2, i3, fArr);
            for (float f : fArr) {
                writableNativeArray.pushDouble((double) f);
            }
        }
        return writableNativeArray;
    }

    public static void O000000o(int i, ReadableMap readableMap) {
        Mat mat = (Mat) O000000o(i);
        ReadableArray array = readableMap.getArray("vals");
        mat.setTo(new Scalar(array.getDouble(0), array.getDouble(1), array.getDouble(2), array.getDouble(3)));
        O000000o(i, mat);
    }

    public static void O000000o(int i, int i2, int i3, ReadableArray readableArray) {
        Mat mat = (Mat) O000000o(i);
        ArrayList<Object> arrayList = readableArray.toArrayList();
        float[] fArr = new float[arrayList.size()];
        Iterator<Object> it = arrayList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            fArr[i4] = (float) ((Double) it.next()).doubleValue();
            i4++;
        }
        mat.put(i2, i3, fArr);
        O000000o(i, mat);
    }

    public static void O00000Oo(int i) {
        Mat mat = (Mat) O000000o(i);
        mat.t();
        O000000o(i, mat);
    }

    private static void O00000Oo(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.equals("Mat")) {
            ((Mat) obj).release();
        } else if (simpleName.equals("MatOfInt")) {
            ((MatOfInt) obj).release();
        } else if (simpleName.equals("MatOfFloat")) {
            ((MatOfFloat) obj).release();
        }
    }

    public static void O00000o0(int i) {
        O00000Oo(O000000o(i));
        O00000Oo.remove(i);
    }

    public static void O00000o0() {
        int size = O00000Oo.size();
        for (int i = 0; i < size; i++) {
            O00000Oo(O000000o(i));
        }
        O00000Oo.clear();
    }
}
