package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import java.io.IOException;

class RepeaterParser {
    private RepeaterParser() {
    }

    static Repeater parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3519) {
                        if (hashCode == 3710 && nextName.equals("tr")) {
                            c = 3;
                        }
                    } else if (nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("o")) {
                    c = 2;
                }
            } else if (nextName.equals("c")) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (c == 2) {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
            }
        }
        return new Repeater(str, animatableFloatValue, animatableFloatValue2, animatableTransform);
    }
}
