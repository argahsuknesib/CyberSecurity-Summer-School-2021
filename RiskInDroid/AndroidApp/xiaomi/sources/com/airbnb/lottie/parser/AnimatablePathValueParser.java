package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;

public class AnimatablePathValueParser {
    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(PathKeyframeParser.parse(jsonReader, lottieComposition));
            }
            jsonReader.endArray();
            KeyframesParser.setEndFrames(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.jsonToPoint(jsonReader, Utils.dpScale())));
        }
        return new AnimatablePathValue(arrayList);
    }

    static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 107) {
                if (hashCode != 120) {
                    if (hashCode == 121 && nextName.equals("y")) {
                        c = 2;
                    }
                } else if (nextName.equals("x")) {
                    c = 1;
                }
            } else if (nextName.equals("k")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        if (jsonReader.peek() != JsonToken.STRING) {
                            animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                        }
                    }
                    jsonReader.skipValue();
                } else if (jsonReader.peek() != JsonToken.STRING) {
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                }
                z = true;
                jsonReader.skipValue();
            } else {
                animatablePathValue = parse(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        if (z) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        if (animatablePathValue != null) {
            return animatablePathValue;
        }
        return new AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
    }
}
