package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.io.IOException;
import java.util.ArrayList;

class ShapeGroupParser {
    private ShapeGroupParser() {
    }

    static ShapeGroup parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3371) {
                if (hashCode == 3519 && nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals("it")) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c != 1) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    ContentModel parse = ContentModelParser.parse(jsonReader, lottieComposition);
                    if (parse != null) {
                        arrayList.add(parse);
                    }
                }
                jsonReader.endArray();
            }
        }
        return new ShapeGroup(str, arrayList);
    }
}
