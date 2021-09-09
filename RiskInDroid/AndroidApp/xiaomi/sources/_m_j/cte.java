package _m_j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.CamcorderProfile;
import android.os.Build;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.gms.vision.face.Face;
import com.google.zxing.Result;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public final class cte {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[][] f14338O000000o = {new String[]{"string", "Artist"}, new String[]{"int", "BitsPerSample"}, new String[]{"int", "Compression"}, new String[]{"string", "Copyright"}, new String[]{"string", "DateTime"}, new String[]{"string", "ImageDescription"}, new String[]{"int", "ImageLength"}, new String[]{"int", "ImageWidth"}, new String[]{"int", "JPEGInterchangeFormat"}, new String[]{"int", "JPEGInterchangeFormatLength"}, new String[]{"string", "Make"}, new String[]{"string", "Model"}, new String[]{"int", "Orientation"}, new String[]{"int", "PhotometricInterpretation"}, new String[]{"int", "PlanarConfiguration"}, new String[]{"double", "PrimaryChromaticities"}, new String[]{"double", "ReferenceBlackWhite"}, new String[]{"int", "ResolutionUnit"}, new String[]{"int", "RowsPerStrip"}, new String[]{"int", "SamplesPerPixel"}, new String[]{"string", "Software"}, new String[]{"int", "StripByteCounts"}, new String[]{"int", "StripOffsets"}, new String[]{"int", "TransferFunction"}, new String[]{"double", "WhitePoint"}, new String[]{"double", "XResolution"}, new String[]{"double", "YCbCrCoefficients"}, new String[]{"int", "YCbCrPositioning"}, new String[]{"int", "YCbCrSubSampling"}, new String[]{"double", "YResolution"}, new String[]{"double", "ApertureValue"}, new String[]{"double", "BrightnessValue"}, new String[]{"string", "CFAPattern"}, new String[]{"int", "ColorSpace"}, new String[]{"string", "ComponentsConfiguration"}, new String[]{"double", "CompressedBitsPerPixel"}, new String[]{"int", "Contrast"}, new String[]{"int", "CustomRendered"}, new String[]{"string", "DateTimeDigitized"}, new String[]{"string", "DateTimeOriginal"}, new String[]{"string", "DeviceSettingDescription"}, new String[]{"double", "DigitalZoomRatio"}, new String[]{"string", "ExifVersion"}, new String[]{"double", "ExposureBiasValue"}, new String[]{"double", "ExposureIndex"}, new String[]{"int", "ExposureMode"}, new String[]{"int", "ExposureProgram"}, new String[]{"double", "ExposureTime"}, new String[]{"double", "FNumber"}, new String[]{"string", "FileSource"}, new String[]{"int", "Flash"}, new String[]{"double", "FlashEnergy"}, new String[]{"string", "FlashpixVersion"}, new String[]{"double", "FocalLength"}, new String[]{"int", "FocalLengthIn35mmFilm"}, new String[]{"int", "FocalPlaneResolutionUnit"}, new String[]{"double", "FocalPlaneXResolution"}, new String[]{"double", "FocalPlaneYResolution"}, new String[]{"int", "GainControl"}, new String[]{"int", "ISOSpeedRatings"}, new String[]{"string", "ImageUniqueID"}, new String[]{"int", "LightSource"}, new String[]{"string", "MakerNote"}, new String[]{"double", "MaxApertureValue"}, new String[]{"int", "MeteringMode"}, new String[]{"int", "NewSubfileType"}, new String[]{"string", "OECF"}, new String[]{"int", "PixelXDimension"}, new String[]{"int", "PixelYDimension"}, new String[]{"string", "RelatedSoundFile"}, new String[]{"int", "Saturation"}, new String[]{"int", "SceneCaptureType"}, new String[]{"string", "SceneType"}, new String[]{"int", "SensingMethod"}, new String[]{"int", "Sharpness"}, new String[]{"double", "ShutterSpeedValue"}, new String[]{"string", "SpatialFrequencyResponse"}, new String[]{"string", "SpectralSensitivity"}, new String[]{"int", "SubfileType"}, new String[]{"string", "SubSecTime"}, new String[]{"string", "SubSecTimeDigitized"}, new String[]{"string", "SubSecTimeOriginal"}, new String[]{"int", "SubjectArea"}, new String[]{"double", "SubjectDistance"}, new String[]{"int", "SubjectDistanceRange"}, new String[]{"int", "SubjectLocation"}, new String[]{"string", "UserComment"}, new String[]{"int", "WhiteBalance"}, new String[]{"int", "GPSAltitudeRef"}, new String[]{"string", "GPSAreaInformation"}, new String[]{"double", "GPSDOP"}, new String[]{"string", "GPSDateStamp"}, new String[]{"double", "GPSDestBearing"}, new String[]{"string", "GPSDestBearingRef"}, new String[]{"double", "GPSDestDistance"}, new String[]{"string", "GPSDestDistanceRef"}, new String[]{"double", "GPSDestLatitude"}, new String[]{"string", "GPSDestLatitudeRef"}, new String[]{"double", "GPSDestLongitude"}, new String[]{"string", "GPSDestLongitudeRef"}, new String[]{"int", "GPSDifferential"}, new String[]{"double", "GPSImgDirection"}, new String[]{"string", "GPSImgDirectionRef"}, new String[]{"string", "GPSLatitudeRef"}, new String[]{"string", "GPSLongitudeRef"}, new String[]{"string", "GPSMapDatum"}, new String[]{"string", "GPSMeasureMode"}, new String[]{"string", "GPSProcessingMethod"}, new String[]{"string", "GPSSatellites"}, new String[]{"double", "GPSSpeed"}, new String[]{"string", "GPSSpeedRef"}, new String[]{"string", "GPSStatus"}, new String[]{"string", "GPSTimeStamp"}, new String[]{"double", "GPSTrack"}, new String[]{"string", "GPSTrackRef"}, new String[]{"string", "GPSVersionID"}, new String[]{"string", "InteroperabilityIndex"}, new String[]{"int", "ThumbnailImageLength"}, new String[]{"int", "ThumbnailImageWidth"}, new String[]{"int", "DNGVersion"}, new String[]{"int", "DefaultCropSize"}, new String[]{"int", "PreviewImageStart"}, new String[]{"int", "PreviewImageLength"}, new String[]{"int", "AspectFrame"}, new String[]{"int", "SensorBottomBorder"}, new String[]{"int", "SensorLeftBorder"}, new String[]{"int", "SensorRightBorder"}, new String[]{"int", "SensorTopBorder"}, new String[]{"int", "ISO"}};

    public static void O000000o(ViewGroup viewGroup) {
        ((UIManagerModule) ((ReactContext) viewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(ctg.O000000o(viewGroup.getId()));
    }

    public static void O00000Oo(ViewGroup viewGroup) {
        ((UIManagerModule) ((ReactContext) viewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(cth.O000000o(viewGroup.getId()));
    }

    public static void O000000o(ViewGroup viewGroup, SparseArray<Face> sparseArray, cts cts) {
        float f = viewGroup.getResources().getDisplayMetrics().density;
        double width = (double) viewGroup.getWidth();
        double O000000o2 = (double) (((float) cts.O000000o()) * f);
        Double.isNaN(width);
        Double.isNaN(O000000o2);
        double d = width / O000000o2;
        double height = (double) viewGroup.getHeight();
        double O00000Oo = (double) (((float) cts.O00000Oo()) * f);
        Double.isNaN(height);
        Double.isNaN(O00000Oo);
        ((UIManagerModule) ((ReactContext) viewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(ctj.O000000o(viewGroup.getId(), sparseArray, cts, d, height / O00000Oo));
    }

    public static void O00000o0(ViewGroup viewGroup) {
        ((UIManagerModule) ((ReactContext) viewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(cti.O000000o(viewGroup.getId()));
    }

    public static void O000000o(ViewGroup viewGroup, Result result) {
        ((UIManagerModule) ((ReactContext) viewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(ctf.O000000o(viewGroup.getId(), result));
    }

    public static int O000000o(int i, int i2) {
        if (i2 == 1) {
            return ((i - 90) + 360) % 360;
        }
        return (((-i) + 90) + 360) % 360;
    }

    public static CamcorderProfile O000000o(int i) {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
        if (i == 0) {
            return Build.VERSION.SDK_INT >= 21 ? CamcorderProfile.get(8) : camcorderProfile;
        }
        if (i == 1) {
            return CamcorderProfile.get(6);
        }
        if (i == 2) {
            return CamcorderProfile.get(5);
        }
        if (i == 3) {
            return CamcorderProfile.get(4);
        }
        if (i != 4) {
            return camcorderProfile;
        }
        CamcorderProfile camcorderProfile2 = CamcorderProfile.get(4);
        camcorderProfile2.videoFrameWidth = 640;
        return camcorderProfile2;
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
        for (String[] strArr : f14338O000000o) {
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

    public static Bitmap O00000Oo(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        float f = (float) i;
        float f2 = (float) i2;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(-256);
        paint2.setTextSize(35.0f);
        canvas.drawText(new SimpleDateFormat("dd.MM.YY HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().getTime()), f * 0.1f, f2 * 0.9f, paint2);
        return createBitmap;
    }
}
