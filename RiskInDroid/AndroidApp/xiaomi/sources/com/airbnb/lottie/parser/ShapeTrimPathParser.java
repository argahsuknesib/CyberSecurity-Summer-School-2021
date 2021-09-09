package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.io.IOException;

class ShapeTrimPathParser {
    private ShapeTrimPathParser() {
    }

    static ShapeTrimPath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 109) {
                    if (hashCode != 111) {
                        if (hashCode != 115) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                c = 3;
                            }
                        } else if (nextName.equals("s")) {
                            c = 0;
                        }
                    } else if (nextName.equals("o")) {
                        c = 2;
                    }
                } else if (nextName.equals("m")) {
                    c = 4;
                }
            } else if (nextName.equals("e")) {
                c = 1;
            }
            if (c == 0) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (c == 1) {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (c == 2) {
                animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (c == 3) {
                str = jsonReader.nextString();
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                type = ShapeTrimPath.Type.forId(jsonReader.nextInt());
            }
        }
        return new ShapeTrimPath(str, type, animatableFloatValue, animatableFloatValue2, animatableFloatValue3);
    }
}
