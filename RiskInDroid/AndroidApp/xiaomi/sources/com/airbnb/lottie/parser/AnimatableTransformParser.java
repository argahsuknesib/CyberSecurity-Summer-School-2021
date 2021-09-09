package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

public class AnimatableTransformParser {
    private AnimatableTransformParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cb  */
    public static AnimatableTransform parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        AnimatablePathValue animatablePathValue = null;
        AnimatableScaleValue animatableScaleValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode != 97) {
                if (hashCode != 3242) {
                    if (hashCode != 3656) {
                        if (hashCode != 3676) {
                            if (hashCode != 111) {
                                if (hashCode != 112) {
                                    if (hashCode != 114) {
                                        if (hashCode == 115 && nextName.equals("s")) {
                                            c = 2;
                                            switch (c) {
                                                case 0:
                                                    jsonReader.beginObject();
                                                    while (jsonReader.hasNext()) {
                                                        if (jsonReader.nextName().equals("k")) {
                                                            animatablePathValue = AnimatablePathValueParser.parse(jsonReader, lottieComposition);
                                                        } else {
                                                            jsonReader.skipValue();
                                                        }
                                                    }
                                                    jsonReader.endObject();
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 1:
                                                    animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 2:
                                                    animatableScaleValue = AnimatableValueParser.parseScale(jsonReader, lottieComposition);
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 3:
                                                    lottieComposition.addWarning("Lottie doesn't support 3D layers.");
                                                    break;
                                                case 4:
                                                    break;
                                                case 5:
                                                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 6:
                                                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 7:
                                                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                default:
                                                    jsonReader.skipValue();
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                            }
                                            animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                                        }
                                    } else if (nextName.equals("r")) {
                                        c = 4;
                                        switch (c) {
                                        }
                                        animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                                    }
                                } else if (nextName.equals("p")) {
                                    c = 1;
                                    switch (c) {
                                    }
                                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                                }
                            } else if (nextName.equals("o")) {
                                c = 5;
                                switch (c) {
                                }
                                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                            }
                        } else if (nextName.equals("so")) {
                            c = 6;
                            switch (c) {
                            }
                            animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                        }
                    } else if (nextName.equals("rz")) {
                        c = 3;
                        switch (c) {
                        }
                        animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    }
                } else if (nextName.equals("eo")) {
                    c = 7;
                    switch (c) {
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                }
            } else if (nextName.equals("a")) {
                c = 0;
                switch (c) {
                }
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            }
            c = 65535;
            switch (c) {
            }
            animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
        }
        if (z) {
            jsonReader.endObject();
        }
        if (animatablePathValue == null) {
            Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            animatablePathValue = new AnimatablePathValue();
        }
        AnimatablePathValue animatablePathValue2 = animatablePathValue;
        if (animatableScaleValue == null) {
            animatableScaleValue = new AnimatableScaleValue(new ScaleXY(1.0f, 1.0f));
        }
        AnimatableScaleValue animatableScaleValue2 = animatableScaleValue;
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue();
        }
        return new AnimatableTransform(animatablePathValue2, animatableValue, animatableScaleValue2, animatableFloatValue, animatableIntegerValue, animatableFloatValue2, animatableFloatValue3);
    }
}
