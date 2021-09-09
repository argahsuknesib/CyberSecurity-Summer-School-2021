package com.airbnb.lottie.parser;

import _m_j.cp;
import _m_j.o0OO00o0;
import android.graphics.PointF;
import android.os.Build;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

class KeyframeParser {
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static o0OO00o0<WeakReference<Interpolator>> pathInterpolatorCache;

    KeyframeParser() {
    }

    private static o0OO00o0<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new o0OO00o0<>();
        }
        return pathInterpolatorCache;
    }

    private static WeakReference<Interpolator> getInterpolator(int i) {
        WeakReference<Interpolator> O000000o2;
        synchronized (KeyframeParser.class) {
            O000000o2 = pathInterpolatorCache().O000000o(i, null);
        }
        return O000000o2;
    }

    private static void putInterpolator(int i, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.O00000Oo(i, weakReference);
        }
    }

    static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z) throws IOException {
        if (z) {
            return parseKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        return parseStaticValue(jsonReader, f, valueParser);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cc  */
    private static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        T t;
        Interpolator interpolator2;
        char c;
        JsonReader jsonReader2 = jsonReader;
        float f2 = f;
        ValueParser<T> valueParser2 = valueParser;
        jsonReader.beginObject();
        boolean z = false;
        PointF pointF = null;
        PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        float f3 = 0.0f;
        PointF pointF3 = null;
        PointF pointF4 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 111) {
                    if (hashCode != 3701) {
                        if (hashCode != 3707) {
                            if (hashCode != 104) {
                                if (hashCode != 105) {
                                    if (hashCode != 115) {
                                        if (hashCode == 116 && nextName.equals("t")) {
                                            c = 0;
                                            switch (c) {
                                                case 0:
                                                    f3 = (float) jsonReader.nextDouble();
                                                    break;
                                                case 1:
                                                    t3 = valueParser2.parse(jsonReader2, f2);
                                                    break;
                                                case 2:
                                                    t2 = valueParser2.parse(jsonReader2, f2);
                                                    break;
                                                case 3:
                                                    pointF = JsonUtils.jsonToPoint(jsonReader, f);
                                                    break;
                                                case 4:
                                                    pointF2 = JsonUtils.jsonToPoint(jsonReader, f);
                                                    break;
                                                case 5:
                                                    if (jsonReader.nextInt() != 1) {
                                                        z = false;
                                                        break;
                                                    } else {
                                                        z = true;
                                                        break;
                                                    }
                                                case 6:
                                                    pointF3 = JsonUtils.jsonToPoint(jsonReader, f);
                                                    break;
                                                case 7:
                                                    pointF4 = JsonUtils.jsonToPoint(jsonReader, f);
                                                    break;
                                                default:
                                                    jsonReader.skipValue();
                                                    break;
                                            }
                                        }
                                    } else if (nextName.equals("s")) {
                                        c = 1;
                                        switch (c) {
                                        }
                                    }
                                } else if (nextName.equals("i")) {
                                    c = 4;
                                    switch (c) {
                                    }
                                }
                            } else if (nextName.equals("h")) {
                                c = 5;
                                switch (c) {
                                }
                            }
                        } else if (nextName.equals("to")) {
                            c = 6;
                            switch (c) {
                            }
                        }
                    } else if (nextName.equals("ti")) {
                        c = 7;
                        switch (c) {
                        }
                    }
                } else if (nextName.equals("o")) {
                    c = 3;
                    switch (c) {
                    }
                }
            } else if (nextName.equals("e")) {
                c = 2;
                switch (c) {
                }
            }
            c = 65535;
            switch (c) {
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = LINEAR_INTERPOLATOR;
            t = t3;
        } else {
            if (pointF == null || pointF2 == null) {
                interpolator = LINEAR_INTERPOLATOR;
            } else {
                float f4 = -f2;
                pointF.x = MiscUtils.clamp(pointF.x, f4, f2);
                pointF.y = MiscUtils.clamp(pointF.y, -100.0f, 100.0f);
                pointF2.x = MiscUtils.clamp(pointF2.x, f4, f2);
                pointF2.y = MiscUtils.clamp(pointF2.y, -100.0f, 100.0f);
                int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, pointF2.y);
                WeakReference<Interpolator> interpolator3 = getInterpolator(hashFor);
                Interpolator interpolator4 = interpolator3 != null ? interpolator3.get() : null;
                if (interpolator3 == null || interpolator4 == null) {
                    float f5 = pointF.x / f2;
                    float f6 = pointF.y / f2;
                    float f7 = pointF2.x / f2;
                    float f8 = pointF2.y / f2;
                    if (Build.VERSION.SDK_INT >= 21) {
                        interpolator2 = new PathInterpolator(f5, f6, f7, f8);
                    } else {
                        interpolator2 = new cp(f5, f6, f7, f8);
                    }
                    try {
                        putInterpolator(hashFor, new WeakReference(interpolator2));
                        interpolator = interpolator2;
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        interpolator4 = interpolator2;
                    }
                }
                t = t2;
                interpolator = interpolator4;
            }
            t = t2;
        }
        Keyframe keyframe = new Keyframe(lottieComposition, t3, t, interpolator, f3, null);
        keyframe.pathCp1 = pointF3;
        keyframe.pathCp2 = pointF4;
        return keyframe;
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.parse(jsonReader, f));
    }
}
