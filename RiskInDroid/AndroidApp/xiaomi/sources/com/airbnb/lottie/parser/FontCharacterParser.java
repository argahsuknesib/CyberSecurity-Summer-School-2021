package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.io.IOException;
import java.util.ArrayList;

class FontCharacterParser {
    private FontCharacterParser() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static FontCharacter parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        char c2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3173:
                    if (nextName.equals("ch")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3076010:
                    if (nextName.equals("data")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (nextName.equals("style")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                c2 = jsonReader.nextString().charAt(0);
            } else if (c == 1) {
                d = jsonReader.nextDouble();
            } else if (c == 2) {
                d2 = jsonReader.nextDouble();
            } else if (c == 3) {
                str = jsonReader.nextString();
            } else if (c == 4) {
                str2 = jsonReader.nextString();
            } else if (c != 5) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if ("shapes".equals(jsonReader.nextName())) {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList.add((ShapeGroup) ContentModelParser.parse(jsonReader, lottieComposition));
                        }
                        jsonReader.endArray();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        return new FontCharacter(arrayList, c2, d, d2, str, str2);
    }
}
