package _m_j;

import android.graphics.PointF;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;

public final class jms {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f1963O000000o = {"bottomMouthPosition", "leftCheekPosition", "leftEarPosition", "leftEarTipPosition", "leftEyePosition", "leftMouthPosition", "noseBasePosition", "rightCheekPosition", "rightEarPosition", "rightEarTipPosition", "rightEyePosition", "rightMouthPosition"};

    public static WritableMap O000000o(Face face) {
        return O000000o(face, 1.0d, 1.0d, 0, 0, 0, 0);
    }

    public static WritableMap O000000o(Face face, double d, double d2, int i, int i2, int i3, int i4) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("faceID", face.getId());
        createMap.putDouble("rollAngle", (double) face.getEulerZ());
        createMap.putDouble("yawAngle", (double) face.getEulerY());
        if (face.getIsSmilingProbability() >= 0.0f) {
            createMap.putDouble("smilingProbability", (double) face.getIsSmilingProbability());
        }
        if (face.getIsLeftEyeOpenProbability() >= 0.0f) {
            createMap.putDouble("leftEyeOpenProbability", (double) face.getIsLeftEyeOpenProbability());
        }
        if (face.getIsRightEyeOpenProbability() >= 0.0f) {
            createMap.putDouble("rightEyeOpenProbability", (double) face.getIsRightEyeOpenProbability());
        }
        for (Landmark next : face.getLandmarks()) {
            createMap.putMap(f1963O000000o[next.getType()], O000000o(next.getPosition(), d, d2, i, i2, i3, i4));
        }
        WritableMap createMap2 = Arguments.createMap();
        Float valueOf = Float.valueOf(face.getPosition().x);
        Float valueOf2 = Float.valueOf(face.getPosition().y);
        float f = (float) (i / 2);
        if (face.getPosition().x < f) {
            valueOf = Float.valueOf(valueOf.floatValue() + ((float) (i3 / 2)));
        } else if (face.getPosition().x > f) {
            valueOf = Float.valueOf(valueOf.floatValue() - ((float) (i3 / 2)));
        }
        float f2 = (float) (i2 / 2);
        if (face.getPosition().y < f2) {
            valueOf2 = Float.valueOf(valueOf2.floatValue() + ((float) (i4 / 2)));
        } else if (face.getPosition().y > f2) {
            valueOf2 = Float.valueOf(valueOf2.floatValue() - ((float) (i4 / 2)));
        }
        double floatValue = (double) valueOf.floatValue();
        Double.isNaN(floatValue);
        createMap2.putDouble("x", floatValue * d);
        double floatValue2 = (double) valueOf2.floatValue();
        Double.isNaN(floatValue2);
        createMap2.putDouble("y", floatValue2 * d2);
        WritableMap createMap3 = Arguments.createMap();
        double width = (double) face.getWidth();
        Double.isNaN(width);
        createMap3.putDouble("width", width * d);
        double height = (double) face.getHeight();
        Double.isNaN(height);
        createMap3.putDouble("height", height * d2);
        WritableMap createMap4 = Arguments.createMap();
        createMap4.putMap("origin", createMap2);
        createMap4.putMap("size", createMap3);
        createMap.putMap("bounds", createMap4);
        return createMap;
    }

    public static WritableMap O000000o(WritableMap writableMap, int i, double d) {
        ReadableMap map = writableMap.getMap("bounds");
        WritableMap O000000o2 = O000000o(O000000o(map.getMap("origin"), i, d), -map.getMap("size").getDouble("width"));
        WritableMap createMap = Arguments.createMap();
        createMap.merge(map);
        createMap.putMap("origin", O000000o2);
        for (String str : f1963O000000o) {
            ReadableMap map2 = writableMap.hasKey(str) ? writableMap.getMap(str) : null;
            if (map2 != null) {
                writableMap.putMap(str, O000000o(map2, i, d));
            }
        }
        writableMap.putMap("bounds", createMap);
        return writableMap;
    }

    public static WritableMap O000000o(WritableMap writableMap) {
        writableMap.putDouble("rollAngle", ((-writableMap.getDouble("rollAngle")) + 360.0d) % 360.0d);
        writableMap.putDouble("yawAngle", ((-writableMap.getDouble("yawAngle")) + 360.0d) % 360.0d);
        return writableMap;
    }

    private static WritableMap O000000o(PointF pointF, double d, double d2, int i, int i2, int i3, int i4) {
        WritableMap createMap = Arguments.createMap();
        Float valueOf = Float.valueOf(pointF.x);
        Float valueOf2 = Float.valueOf(pointF.y);
        float f = (float) (i / 2);
        if (pointF.x < f) {
            Float.valueOf(valueOf.floatValue() + ((float) (i3 / 2)));
        } else if (pointF.x > f) {
            Float.valueOf(valueOf.floatValue() - ((float) (i3 / 2)));
        }
        float f2 = (float) (i2 / 2);
        if (pointF.y < f2) {
            Float.valueOf(valueOf2.floatValue() + ((float) (i4 / 2)));
        } else if (pointF.y > f2) {
            Float.valueOf(valueOf2.floatValue() - ((float) (i4 / 2)));
        }
        double d3 = (double) pointF.x;
        Double.isNaN(d3);
        createMap.putDouble("x", d3 * d);
        double d4 = (double) pointF.y;
        Double.isNaN(d4);
        createMap.putDouble("y", d4 * d2);
        return createMap;
    }

    public static WritableMap O000000o(ReadableMap readableMap, double d) {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(readableMap);
        createMap.putDouble("x", readableMap.getDouble("x") + d);
        return createMap;
    }

    public static WritableMap O000000o(ReadableMap readableMap, int i, double d) {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(readableMap);
        createMap.putDouble("x", O000000o(readableMap.getDouble("x"), i, d));
        return createMap;
    }

    private static double O000000o(double d, int i, double d2) {
        double d3 = (double) i;
        Double.isNaN(d3);
        return (d3 - (d / d2)) * d2;
    }
}
