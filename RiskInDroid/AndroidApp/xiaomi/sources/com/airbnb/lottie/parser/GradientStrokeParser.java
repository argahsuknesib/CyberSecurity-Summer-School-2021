package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;

class GradientStrokeParser {
    private GradientStrokeParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x017c  */
    static GradientStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        ShapeStroke.LineCapType lineCapType;
        ShapeStroke.LineJoinType lineJoinType;
        char c2;
        char c3;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        ShapeStroke.LineCapType lineCapType2 = null;
        ShapeStroke.LineJoinType lineJoinType2 = null;
        float f = 0.0f;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            AnimatableFloatValue animatableFloatValue3 = animatableFloatValue2;
            float f2 = f;
            if (hashCode != 100) {
                if (hashCode != 101) {
                    if (hashCode != 103) {
                        if (hashCode != 111) {
                            if (hashCode != 119) {
                                if (hashCode != 3447) {
                                    if (hashCode != 3454) {
                                        if (hashCode != 3487) {
                                            if (hashCode != 3519) {
                                                if (hashCode != 115) {
                                                    if (hashCode == 116 && nextName.equals("t")) {
                                                        c = 3;
                                                        switch (c) {
                                                            case 0:
                                                                lineCapType = lineCapType2;
                                                                str = jsonReader.nextString();
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                                lineCapType2 = lineCapType;
                                                            case 1:
                                                                lineCapType = lineCapType2;
                                                                lineJoinType = lineJoinType2;
                                                                jsonReader.beginObject();
                                                                int i = -1;
                                                                while (jsonReader.hasNext()) {
                                                                    String nextName2 = jsonReader.nextName();
                                                                    int hashCode2 = nextName2.hashCode();
                                                                    if (hashCode2 != 107) {
                                                                        if (hashCode2 == 112 && nextName2.equals("p")) {
                                                                            c2 = 0;
                                                                            if (c2 == 0) {
                                                                                i = jsonReader.nextInt();
                                                                            } else if (c2 != 1) {
                                                                                jsonReader.skipValue();
                                                                            } else {
                                                                                animatableGradientColorValue = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, i);
                                                                            }
                                                                        }
                                                                    } else if (nextName2.equals("k")) {
                                                                        c2 = 1;
                                                                        if (c2 == 0) {
                                                                        }
                                                                    }
                                                                    c2 = 65535;
                                                                    if (c2 == 0) {
                                                                    }
                                                                }
                                                                jsonReader.endObject();
                                                                lineJoinType2 = lineJoinType;
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                                lineCapType2 = lineCapType;
                                                            case 2:
                                                                animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                            case 3:
                                                                lineCapType = lineCapType2;
                                                                lineJoinType = lineJoinType2;
                                                                gradientType = jsonReader.nextInt() == 1 ? GradientType.Linear : GradientType.Radial;
                                                                lineJoinType2 = lineJoinType;
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                                lineCapType2 = lineCapType;
                                                            case 4:
                                                                animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                            case 5:
                                                                animatablePointValue2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                            case 6:
                                                                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                            case 7:
                                                                lineCapType2 = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                                                                lineJoinType2 = lineJoinType2;
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                                                                lineCapType = lineCapType2;
                                                                lineJoinType2 = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                                lineCapType2 = lineCapType;
                                                            case 9:
                                                                lineCapType = lineCapType2;
                                                                f = (float) jsonReader.nextDouble();
                                                                lineJoinType2 = lineJoinType2;
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                lineCapType2 = lineCapType;
                                                            case 10:
                                                                jsonReader.beginArray();
                                                                while (jsonReader.hasNext()) {
                                                                    jsonReader.beginObject();
                                                                    String str2 = null;
                                                                    AnimatableFloatValue animatableFloatValue4 = null;
                                                                    while (jsonReader.hasNext()) {
                                                                        String nextName3 = jsonReader.nextName();
                                                                        ShapeStroke.LineJoinType lineJoinType3 = lineJoinType2;
                                                                        int hashCode3 = nextName3.hashCode();
                                                                        ShapeStroke.LineCapType lineCapType3 = lineCapType2;
                                                                        if (hashCode3 != 110) {
                                                                            if (hashCode3 == 118 && nextName3.equals("v")) {
                                                                                c3 = 1;
                                                                                if (c3 == 0) {
                                                                                    str2 = jsonReader.nextString();
                                                                                } else if (c3 != 1) {
                                                                                    jsonReader.skipValue();
                                                                                } else {
                                                                                    animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                                                                }
                                                                                lineJoinType2 = lineJoinType3;
                                                                                lineCapType2 = lineCapType3;
                                                                            }
                                                                        } else if (nextName3.equals("n")) {
                                                                            c3 = 0;
                                                                            if (c3 == 0) {
                                                                            }
                                                                            lineJoinType2 = lineJoinType3;
                                                                            lineCapType2 = lineCapType3;
                                                                        }
                                                                        c3 = 65535;
                                                                        if (c3 == 0) {
                                                                        }
                                                                        lineJoinType2 = lineJoinType3;
                                                                        lineCapType2 = lineCapType3;
                                                                    }
                                                                    ShapeStroke.LineCapType lineCapType4 = lineCapType2;
                                                                    ShapeStroke.LineJoinType lineJoinType4 = lineJoinType2;
                                                                    jsonReader.endObject();
                                                                    if (str2.equals("o")) {
                                                                        animatableFloatValue3 = animatableFloatValue4;
                                                                    } else if (str2.equals("d") || str2.equals("g")) {
                                                                        arrayList.add(animatableFloatValue4);
                                                                    }
                                                                    lineJoinType2 = lineJoinType4;
                                                                    lineCapType2 = lineCapType4;
                                                                }
                                                                lineCapType = lineCapType2;
                                                                lineJoinType = lineJoinType2;
                                                                jsonReader.endArray();
                                                                if (arrayList.size() == 1) {
                                                                    arrayList.add(arrayList.get(0));
                                                                }
                                                                lineJoinType2 = lineJoinType;
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                                lineCapType2 = lineCapType;
                                                                break;
                                                            default:
                                                                lineCapType = lineCapType2;
                                                                lineJoinType = lineJoinType2;
                                                                jsonReader.skipValue();
                                                                lineJoinType2 = lineJoinType;
                                                                animatableFloatValue2 = animatableFloatValue3;
                                                                f = f2;
                                                                lineCapType2 = lineCapType;
                                                        }
                                                    }
                                                } else if (nextName.equals("s")) {
                                                    c = 4;
                                                    switch (c) {
                                                    }
                                                }
                                            } else if (nextName.equals("nm")) {
                                                c = 0;
                                                switch (c) {
                                                }
                                            }
                                        } else if (nextName.equals("ml")) {
                                            c = 9;
                                            switch (c) {
                                            }
                                        }
                                    } else if (nextName.equals("lj")) {
                                        c = 8;
                                        switch (c) {
                                        }
                                    }
                                } else if (nextName.equals("lc")) {
                                    c = 7;
                                    switch (c) {
                                    }
                                }
                            } else if (nextName.equals("w")) {
                                c = 6;
                                switch (c) {
                                }
                            }
                        } else if (nextName.equals("o")) {
                            c = 2;
                            switch (c) {
                            }
                        }
                    } else if (nextName.equals("g")) {
                        c = 1;
                        switch (c) {
                        }
                    }
                } else if (nextName.equals("e")) {
                    c = 5;
                    switch (c) {
                    }
                }
            } else if (nextName.equals("d")) {
                c = 10;
                switch (c) {
                }
            }
            c = 65535;
            switch (c) {
            }
        }
        return new GradientStroke(str, gradientType, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue, lineCapType2, lineJoinType2, f, arrayList, animatableFloatValue2);
    }
}
