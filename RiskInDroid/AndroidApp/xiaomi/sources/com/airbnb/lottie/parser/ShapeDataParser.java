package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();

    private ShapeDataParser() {
    }

    public ShapeData parse(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 105) {
                    if (hashCode != 111) {
                        if (hashCode == 118 && nextName.equals("v")) {
                            c = 1;
                        }
                    } else if (nextName.equals("o")) {
                        c = 3;
                    }
                } else if (nextName.equals("i")) {
                    c = 2;
                }
            } else if (nextName.equals("c")) {
                c = 0;
            }
            if (c == 0) {
                z = jsonReader.nextBoolean();
            } else if (c == 1) {
                list = JsonUtils.jsonToPoints(jsonReader, f);
            } else if (c == 2) {
                list2 = JsonUtils.jsonToPoints(jsonReader, f);
            } else if (c == 3) {
                list3 = JsonUtils.jsonToPoints(jsonReader, f);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new CubicCurveData(MiscUtils.addPoints(list.get(i2), list3.get(i2)), MiscUtils.addPoints(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new CubicCurveData(MiscUtils.addPoints(list.get(i3), list3.get(i3)), MiscUtils.addPoints(pointF3, list2.get(0)), pointF3));
            }
            return new ShapeData(pointF, z, arrayList);
        }
    }
}
