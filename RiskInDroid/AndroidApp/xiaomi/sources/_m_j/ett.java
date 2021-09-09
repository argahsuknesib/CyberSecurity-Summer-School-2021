package _m_j;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@TargetApi(GmsLogger.MAX_PII_TAG_LENGTH)
public final class ett {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pattern f15807O000000o = Pattern.compile(";");

    public static void O000000o(Camera.Parameters parameters, boolean z) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String O000000o2 = O000000o("focus mode", supportedFocusModes, "auto");
        if (!z && O000000o2 == null) {
            O000000o2 = O000000o("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (O000000o2 == null) {
            return;
        }
        if (O000000o2.equals(parameters.getFocusMode())) {
            Log.i("CameraConfiguration", "Focus mode already set to ".concat(String.valueOf(O000000o2)));
        } else {
            parameters.setFocusMode(O000000o2);
        }
    }

    public static void O00000Oo(Camera.Parameters parameters, boolean z) {
        String str;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            str = O000000o("flash mode", supportedFlashModes, "torch", "on");
        } else {
            str = O000000o("flash mode", supportedFlashModes, "off");
        }
        if (str == null) {
            return;
        }
        if (str.equals(parameters.getFlashMode())) {
            Log.i("CameraConfiguration", "Flash mode already set to ".concat(String.valueOf(str)));
            return;
        }
        Log.i("CameraConfiguration", "Setting flash mode to ".concat(String.valueOf(str)));
        parameters.setFlashMode(str);
    }

    public static void O000000o(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            Log.i("CameraConfiguration", "Old focus areas: " + O000000o(parameters.getFocusAreas()));
            List<Camera.Area> O000000o2 = O000000o();
            Log.i("CameraConfiguration", "Setting focus area to : " + O000000o(O000000o2));
            parameters.setFocusAreas(O000000o2);
            return;
        }
        Log.i("CameraConfiguration", "Device does not support focus areas");
    }

    public static void O00000Oo(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            Log.i("CameraConfiguration", "Old metering areas: " + parameters.getMeteringAreas());
            List<Camera.Area> O000000o2 = O000000o();
            Log.i("CameraConfiguration", "Setting metering area to : " + O000000o(O000000o2));
            parameters.setMeteringAreas(O000000o2);
            return;
        }
        Log.i("CameraConfiguration", "Device does not support metering areas");
    }

    private static List<Camera.Area> O000000o() {
        return Collections.singletonList(new Camera.Area(new Rect(-400, -400, 400, 400), 1));
    }

    public static void O00000o0(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            Log.i("CameraConfiguration", "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            Log.i("CameraConfiguration", "Video stabilization already enabled");
        } else {
            Log.i("CameraConfiguration", "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static Point O000000o(Camera.Parameters parameters, Point point) {
        Point point2 = point;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList<Camera.Size> arrayList = new ArrayList<>(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            /* class _m_j.ett.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                Camera.Size size = (Camera.Size) obj;
                Camera.Size size2 = (Camera.Size) obj2;
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            Log.i("CameraConfiguration", "Supported preview sizes: ".concat(String.valueOf(sb)));
        }
        double d = (double) point2.x;
        double d2 = (double) point2.y;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        Iterator it = arrayList.iterator();
        while (true) {
            boolean z = false;
            if (it.hasNext()) {
                Camera.Size size2 = (Camera.Size) it.next();
                int i = size2.width;
                int i2 = size2.height;
                if (i * i2 < 153600) {
                    it.remove();
                } else {
                    if (i < i2) {
                        z = true;
                    }
                    int i3 = z ? i2 : i;
                    int i4 = z ? i : i2;
                    double d4 = (double) i3;
                    double d5 = (double) i4;
                    Double.isNaN(d4);
                    Double.isNaN(d5);
                    if (Math.abs((d4 / d5) - d3) > 0.15d) {
                        it.remove();
                    } else if (i3 == point2.x && i4 == point2.y) {
                        Point point3 = new Point(i, i2);
                        Log.i("CameraConfiguration", "Found preview size exactly matching screen size: ".concat(String.valueOf(point3)));
                        return point3;
                    }
                }
            } else if (!arrayList.isEmpty()) {
                Camera.Size size3 = (Camera.Size) arrayList.get(0);
                Point point4 = new Point(size3.width, size3.height);
                Log.i("CameraConfiguration", "Using largest suitable preview size: ".concat(String.valueOf(point4)));
                return point4;
            } else {
                Camera.Size previewSize2 = parameters.getPreviewSize();
                if (previewSize2 != null) {
                    Point point5 = new Point(previewSize2.width, previewSize2.height);
                    Log.i("CameraConfiguration", "No suitable preview sizes, using default: ".concat(String.valueOf(point5)));
                    return point5;
                }
                throw new IllegalStateException("Parameters contained no preview size!");
            }
        }
    }

    private static String O000000o(String str, Collection<String> collection, String... strArr) {
        Log.i("CameraConfiguration", "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i("CameraConfiguration", "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i("CameraConfiguration", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i("CameraConfiguration", "No supported values match");
        return null;
    }

    private static String O000000o(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area next : iterable) {
            sb.append(next.rect);
            sb.append(':');
            sb.append(next.weight);
            sb.append(' ');
        }
        return sb.toString();
    }
}
