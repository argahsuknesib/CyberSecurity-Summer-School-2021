package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class KeyframesParser {
    private KeyframesParser() {
    }

    static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 107 && nextName.equals("k")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, false));
            }
        }
        jsonReader.endObject();
        setEndFrames(arrayList);
        return arrayList;
    }

    public static void setEndFrames(List<? extends Keyframe<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            i2++;
            ((Keyframe) list.get(i2)).endFrame = Float.valueOf(((Keyframe) list.get(i2)).startFrame);
        }
        Keyframe keyframe = (Keyframe) list.get(i);
        if (keyframe.startValue == null) {
            list.remove(keyframe);
        }
    }
}
