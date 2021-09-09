package _m_j;

import android.media.CamcorderProfile;
import android.os.Build;
import android.view.ViewGroup;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.facedetector.RNFaceDetector;

public final class jlu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[][] f1934O000000o = {new String[]{"string", "Artist"}, new String[]{"int", "BitsPerSample"}, new String[]{"int", "Compression"}, new String[]{"string", "Copyright"}, new String[]{"string", "DateTime"}, new String[]{"string", "ImageDescription"}, new String[]{"int", "ImageLength"}, new String[]{"int", "ImageWidth"}, new String[]{"int", "JPEGInterchangeFormat"}, new String[]{"int", "JPEGInterchangeFormatLength"}, new String[]{"string", "Make"}, new String[]{"string", "Model"}, new String[]{"int", "Orientation"}, new String[]{"int", "PhotometricInterpretation"}, new String[]{"int", "PlanarConfiguration"}, new String[]{"double", "PrimaryChromaticities"}, new String[]{"double", "ReferenceBlackWhite"}, new String[]{"int", "ResolutionUnit"}, new String[]{"int", "RowsPerStrip"}, new String[]{"int", "SamplesPerPixel"}, new String[]{"string", "Software"}, new String[]{"int", "StripByteCounts"}, new String[]{"int", "StripOffsets"}, new String[]{"int", "TransferFunction"}, new String[]{"double", "WhitePoint"}, new String[]{"double", "XResolution"}, new String[]{"double", "YCbCrCoefficients"}, new String[]{"int", "YCbCrPositioning"}, new String[]{"int", "YCbCrSubSampling"}, new String[]{"double", "YResolution"}, new String[]{"double", "ApertureValue"}, new String[]{"double", "BrightnessValue"}, new String[]{"string", "CFAPattern"}, new String[]{"int", "ColorSpace"}, new String[]{"string", "ComponentsConfiguration"}, new String[]{"double", "CompressedBitsPerPixel"}, new String[]{"int", "Contrast"}, new String[]{"int", "CustomRendered"}, new String[]{"string", "DateTimeDigitized"}, new String[]{"string", "DateTimeOriginal"}, new String[]{"string", "DeviceSettingDescription"}, new String[]{"double", "DigitalZoomRatio"}, new String[]{"string", "ExifVersion"}, new String[]{"double", "ExposureBiasValue"}, new String[]{"double", "ExposureIndex"}, new String[]{"int", "ExposureMode"}, new String[]{"int", "ExposureProgram"}, new String[]{"double", "ExposureTime"}, new String[]{"double", "FNumber"}, new String[]{"string", "FileSource"}, new String[]{"int", "Flash"}, new String[]{"double", "FlashEnergy"}, new String[]{"string", "FlashpixVersion"}, new String[]{"double", "FocalLength"}, new String[]{"int", "FocalLengthIn35mmFilm"}, new String[]{"int", "FocalPlaneResolutionUnit"}, new String[]{"double", "FocalPlaneXResolution"}, new String[]{"double", "FocalPlaneYResolution"}, new String[]{"int", "GainControl"}, new String[]{"int", "ISOSpeedRatings"}, new String[]{"string", "ImageUniqueID"}, new String[]{"int", "LightSource"}, new String[]{"string", "MakerNote"}, new String[]{"double", "MaxApertureValue"}, new String[]{"int", "MeteringMode"}, new String[]{"int", "NewSubfileType"}, new String[]{"string", "OECF"}, new String[]{"int", "PixelXDimension"}, new String[]{"int", "PixelYDimension"}, new String[]{"string", "RelatedSoundFile"}, new String[]{"int", "Saturation"}, new String[]{"int", "SceneCaptureType"}, new String[]{"string", "SceneType"}, new String[]{"int", "SensingMethod"}, new String[]{"int", "Sharpness"}, new String[]{"double", "ShutterSpeedValue"}, new String[]{"string", "SpatialFrequencyResponse"}, new String[]{"string", "SpectralSensitivity"}, new String[]{"int", "SubfileType"}, new String[]{"string", "SubSecTime"}, new String[]{"string", "SubSecTimeDigitized"}, new String[]{"string", "SubSecTimeOriginal"}, new String[]{"int", "SubjectArea"}, new String[]{"double", "SubjectDistance"}, new String[]{"int", "SubjectDistanceRange"}, new String[]{"int", "SubjectLocation"}, new String[]{"string", "UserComment"}, new String[]{"int", "WhiteBalance"}, new String[]{"int", "GPSAltitudeRef"}, new String[]{"string", "GPSAreaInformation"}, new String[]{"double", "GPSDOP"}, new String[]{"string", "GPSDateStamp"}, new String[]{"double", "GPSDestBearing"}, new String[]{"string", "GPSDestBearingRef"}, new String[]{"double", "GPSDestDistance"}, new String[]{"string", "GPSDestDistanceRef"}, new String[]{"double", "GPSDestLatitude"}, new String[]{"string", "GPSDestLatitudeRef"}, new String[]{"double", "GPSDestLongitude"}, new String[]{"string", "GPSDestLongitudeRef"}, new String[]{"int", "GPSDifferential"}, new String[]{"double", "GPSImgDirection"}, new String[]{"string", "GPSImgDirectionRef"}, new String[]{"string", "GPSLatitudeRef"}, new String[]{"string", "GPSLongitudeRef"}, new String[]{"string", "GPSMapDatum"}, new String[]{"string", "GPSMeasureMode"}, new String[]{"string", "GPSProcessingMethod"}, new String[]{"string", "GPSSatellites"}, new String[]{"double", "GPSSpeed"}, new String[]{"string", "GPSSpeedRef"}, new String[]{"string", "GPSStatus"}, new String[]{"string", "GPSTimeStamp"}, new String[]{"double", "GPSTrack"}, new String[]{"string", "GPSTrackRef"}, new String[]{"string", "GPSVersionID"}, new String[]{"string", "InteroperabilityIndex"}, new String[]{"int", "ThumbnailImageLength"}, new String[]{"int", "ThumbnailImageWidth"}, new String[]{"int", "DNGVersion"}, new String[]{"int", "DefaultCropSize"}, new String[]{"int", "PreviewImageStart"}, new String[]{"int", "PreviewImageLength"}, new String[]{"int", "AspectFrame"}, new String[]{"int", "SensorBottomBorder"}, new String[]{"int", "SensorLeftBorder"}, new String[]{"int", "SensorRightBorder"}, new String[]{"int", "SensorTopBorder"}, new String[]{"int", "ISO"}};

    public static void O000000o(final ViewGroup viewGroup, final String str) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            /* class _m_j.jlu.AnonymousClass1 */

            public final void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(jly.O000000o(viewGroup.getId(), str));
            }
        });
    }

    public static void O000000o(final ViewGroup viewGroup) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            /* class _m_j.jlu.AnonymousClass3 */

            public final void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(jlz.O000000o(viewGroup.getId()));
            }
        });
    }

    public static void O000000o(final ViewGroup viewGroup, final WritableMap writableMap) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            /* class _m_j.jlu.AnonymousClass4 */

            public final void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(jmc.O000000o(viewGroup.getId(), writableMap));
            }
        });
    }

    public static void O00000Oo(final ViewGroup viewGroup) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            /* class _m_j.jlu.AnonymousClass5 */

            public final void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(jmd.O000000o(viewGroup.getId()));
            }
        });
    }

    public static void O000000o(final ViewGroup viewGroup, final WritableArray writableArray) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            /* class _m_j.jlu.AnonymousClass6 */

            public final void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(jmb.O000000o(viewGroup.getId(), writableArray));
            }
        });
    }

    public static void O000000o(final ViewGroup viewGroup, final RNFaceDetector rNFaceDetector) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            /* class _m_j.jlu.AnonymousClass7 */

            public final void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(jma.O000000o(viewGroup.getId(), rNFaceDetector));
            }
        });
    }

    public static void O00000Oo(final ViewGroup viewGroup, final WritableArray writableArray) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            /* class _m_j.jlu.AnonymousClass8 */

            public final void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(jlx.O000000o(viewGroup.getId(), writableArray));
            }
        });
    }

    public static void O000000o(final ViewGroup viewGroup, final RNBarcodeDetector rNBarcodeDetector) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            /* class _m_j.jlu.AnonymousClass9 */

            public final void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(jlw.O000000o(viewGroup.getId(), rNBarcodeDetector));
            }
        });
    }

    public static void O000000o(ViewGroup viewGroup, idf idf, int i, int i2) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        final ViewGroup viewGroup2 = viewGroup;
        final idf idf2 = idf;
        final int i3 = i;
        final int i4 = i2;
        final ReactContext reactContext2 = reactContext;
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            /* class _m_j.jlu.AnonymousClass10 */

            public final void run() {
                ((UIManagerModule) reactContext2.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(jlv.O000000o(viewGroup2.getId(), idf2, i3, i4));
            }
        });
    }

    public static void O00000o0(final ViewGroup viewGroup, final WritableArray writableArray) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            /* class _m_j.jlu.AnonymousClass2 */

            public final void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(jme.O000000o(viewGroup.getId(), writableArray));
            }
        });
    }

    public static int O000000o(int i, int i2, int i3) {
        boolean z = true;
        if (i2 == 1) {
            return (i3 + i) % 360;
        }
        int i4 = 0;
        if (!(i == 90 || i == 270)) {
            z = false;
        }
        if (z) {
            i4 = 180;
        }
        return ((i3 - i) + i4) % 360;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
    public static CamcorderProfile O000000o(int i) {
        int i2 = 1;
        CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    i2 = 5;
                } else if (i == 3 || i == 4) {
                    i2 = 4;
                }
                if (CamcorderProfile.hasProfile(i2)) {
                    camcorderProfile = CamcorderProfile.get(i2);
                    if (i == 4) {
                        camcorderProfile.videoFrameWidth = 640;
                    }
                }
                return camcorderProfile;
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            i2 = 8;
            if (CamcorderProfile.hasProfile(i2)) {
            }
            return camcorderProfile;
        }
        i2 = 6;
        if (CamcorderProfile.hasProfile(i2)) {
        }
        return camcorderProfile;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dx.O000000o(java.lang.String, double):double
     arg types: [java.lang.String, int]
     candidates:
      _m_j.dx.O000000o(int, int):void
      _m_j.dx.O000000o(_m_j.dx$O000000o, int):void
      _m_j.dx.O000000o(_m_j.dx$O000000o, java.util.HashMap):void
      _m_j.dx.O000000o(java.io.InputStream, java.io.OutputStream):void
      _m_j.dx.O000000o(java.lang.String, int):int
      _m_j.dx.O000000o(java.lang.String, java.lang.String):void
      _m_j.dx.O000000o(java.lang.String, double):double */
    public static WritableMap O000000o(dx dxVar) {
        WritableMap createMap = Arguments.createMap();
        for (String[] strArr : f1934O000000o) {
            String str = strArr[1];
            if (dxVar.O000000o(str) != null) {
                String str2 = strArr[0];
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != -1325958191) {
                    if (hashCode != -891985903) {
                        if (hashCode == 104431 && str2.equals("int")) {
                            c = 1;
                        }
                    } else if (str2.equals("string")) {
                        c = 0;
                    }
                } else if (str2.equals("double")) {
                    c = 2;
                }
                if (c == 0) {
                    createMap.putString(str, dxVar.O000000o(str));
                } else if (c == 1) {
                    createMap.putInt(str, dxVar.O000000o(str, 0));
                } else if (c == 2) {
                    createMap.putDouble(str, dxVar.O000000o(str, 0.0d));
                }
            }
        }
        double[] O00000Oo = dxVar.O00000Oo();
        if (O00000Oo != null) {
            createMap.putDouble("GPSLatitude", O00000Oo[0]);
            createMap.putDouble("GPSLongitude", O00000Oo[1]);
            createMap.putDouble("GPSAltitude", dxVar.O00000o0());
        }
        return createMap;
    }

    public static void O000000o(dx dxVar, ReadableMap readableMap) {
        for (String[] strArr : f1934O000000o) {
            String str = strArr[1];
            if (readableMap.hasKey(str)) {
                String str2 = strArr[0];
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != -1325958191) {
                    if (hashCode != -891985903) {
                        if (hashCode == 104431 && str2.equals("int")) {
                            c = 1;
                        }
                    } else if (str2.equals("string")) {
                        c = 0;
                    }
                } else if (str2.equals("double")) {
                    c = 2;
                }
                if (c == 0) {
                    dxVar.O000000o(str, readableMap.getString(str));
                } else if (c == 1) {
                    dxVar.O000000o(str, Integer.toString(readableMap.getInt(str)));
                    readableMap.getInt(str);
                } else if (c == 2) {
                    dxVar.O000000o(str, Double.toString(readableMap.getDouble(str)));
                    readableMap.getDouble(str);
                }
            }
        }
        if (readableMap.hasKey("GPSLatitude") && readableMap.hasKey("GPSLongitude")) {
            double d = readableMap.getDouble("GPSLatitude");
            double d2 = readableMap.getDouble("GPSLongitude");
            if (d < -90.0d || d > 90.0d || Double.isNaN(d)) {
                throw new IllegalArgumentException("Latitude value " + d + " is not valid.");
            } else if (d2 < -180.0d || d2 > 180.0d || Double.isNaN(d2)) {
                throw new IllegalArgumentException("Longitude value " + d2 + " is not valid.");
            } else {
                dxVar.O000000o("GPSLatitudeRef", d >= 0.0d ? "N" : "S");
                dxVar.O000000o("GPSLatitude", dx.O00000Oo(Math.abs(d)));
                dxVar.O000000o("GPSLongitudeRef", d2 >= 0.0d ? "E" : "W");
                dxVar.O000000o("GPSLongitude", dx.O00000Oo(Math.abs(d2)));
            }
        }
        if (readableMap.hasKey("GPSAltitude")) {
            dxVar.O000000o(readableMap.getDouble("GPSAltitude"));
        }
    }

    public static void O00000Oo(dx dxVar) {
        for (String[] strArr : f1934O000000o) {
            dxVar.O000000o(strArr[1], (String) null);
        }
        dxVar.O000000o("GPSLatitude", (String) null);
        dxVar.O000000o("GPSLongitude", (String) null);
        dxVar.O000000o("GPSAltitude", (String) null);
    }
}
