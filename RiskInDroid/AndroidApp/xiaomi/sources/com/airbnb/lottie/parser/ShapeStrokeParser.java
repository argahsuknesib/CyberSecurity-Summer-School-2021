package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.io.IOException;
import java.util.ArrayList;

class ShapeStrokeParser {
    private ShapeStrokeParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0156  */
    static ShapeStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        char c2;
        char c3;
        ArrayList arrayList = new ArrayList();
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 100) {
                    if (hashCode != 111) {
                        if (hashCode != 119) {
                            if (hashCode != 3447) {
                                if (hashCode != 3454) {
                                    if (hashCode != 3487) {
                                        if (hashCode == 3519 && nextName.equals("nm")) {
                                            c = 0;
                                            switch (c) {
                                                case 0:
                                                    str = jsonReader.nextString();
                                                    break;
                                                case 1:
                                                    animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                                                    break;
                                                case 2:
                                                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                                    break;
                                                case 3:
                                                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                                                    break;
                                                case 4:
                                                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                                                    break;
                                                case 5:
                                                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                                                    break;
                                                case 6:
                                                    f = (float) jsonReader.nextDouble();
                                                    break;
                                                case 7:
                                                    jsonReader.beginArray();
                                                    while (jsonReader.hasNext()) {
                                                        jsonReader.beginObject();
                                                        String str2 = null;
                                                        AnimatableFloatValue animatableFloatValue3 = null;
                                                        while (jsonReader.hasNext()) {
                                                            String nextName2 = jsonReader.nextName();
                                                            int hashCode2 = nextName2.hashCode();
                                                            if (hashCode2 != 110) {
                                                                if (hashCode2 == 118 && nextName2.equals("v")) {
                                                                    c3 = 1;
                                                                    if (c3 == 0) {
                                                                        str2 = jsonReader.nextString();
                                                                    } else if (c3 != 1) {
                                                                        jsonReader.skipValue();
                                                                    } else {
                                                                        animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                                                    }
                                                                }
                                                            } else if (nextName2.equals("n")) {
                                                                c3 = 0;
                                                                if (c3 == 0) {
                                                                }
                                                            }
                                                            c3 = 65535;
                                                            if (c3 == 0) {
                                                            }
                                                        }
                                                        jsonReader.endObject();
                                                        int hashCode3 = str2.hashCode();
                                                        if (hashCode3 != 100) {
                                                            if (hashCode3 != 103) {
                                                                if (hashCode3 == 111 && str2.equals("o")) {
                                                                    c2 = 0;
                                                                    if (c2 == 0) {
                                                                        if (c2 != 1) {
                                                                            if (c2 != 2) {
                                                                            }
                                                                        }
                                                                        arrayList.add(animatableFloatValue3);
                                                                    } else {
                                                                        animatableFloatValue = animatableFloatValue3;
                                                                    }
                                                                }
                                                            } else if (str2.equals("g")) {
                                                                c2 = 2;
                                                                if (c2 == 0) {
                                                                }
                                                            }
                                                        } else if (str2.equals("d")) {
                                                            c2 = 1;
                                                            if (c2 == 0) {
                                                            }
                                                        }
                                                        c2 = 65535;
                                                        if (c2 == 0) {
                                                        }
                                                    }
                                                    jsonReader.endArray();
                                                    if (arrayList.size() != 1) {
                                                        break;
                                                    } else {
                                                        arrayList.add(arrayList.get(0));
                                                        break;
                                                    }
                                                default:
                                                    jsonReader.skipValue();
                                                    break;
                                            }
                                        }
                                    } else if (nextName.equals("ml")) {
                                        c = 6;
                                        switch (c) {
                                        }
                                    }
                                } else if (nextName.equals("lj")) {
                                    c = 5;
                                    switch (c) {
                                    }
                                }
                            } else if (nextName.equals("lc")) {
                                c = 4;
                                switch (c) {
                                }
                            }
                        } else if (nextName.equals("w")) {
                            c = 2;
                            switch (c) {
                            }
                        }
                    } else if (nextName.equals("o")) {
                        c = 3;
                        switch (c) {
                        }
                    }
                } else if (nextName.equals("d")) {
                    c = 7;
                    switch (c) {
                    }
                }
            } else if (nextName.equals("c")) {
                c = 1;
                switch (c) {
                }
            }
            c = 65535;
            switch (c) {
            }
        }
        return new ShapeStroke(str, animatableFloatValue, arrayList, animatableColorValue, animatableIntegerValue, animatableFloatValue2, lineCapType, lineJoinType, f);
    }
}
