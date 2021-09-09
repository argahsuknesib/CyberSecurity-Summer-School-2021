package com.airbnb.lottie.parser;

import android.graphics.Path;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import java.io.IOException;

class GradientFillParser {
    private GradientFillParser() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ef  */
    static GradientFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        char c2;
        String str = null;
        GradientType gradientType = null;
        Path.FillType fillType = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 103) {
                    if (hashCode != 111) {
                        if (hashCode != 3519) {
                            switch (hashCode) {
                                case 114:
                                    if (nextName.equals("r")) {
                                        c = 6;
                                        break;
                                    }
                                    break;
                                case 115:
                                    if (nextName.equals("s")) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                                case 116:
                                    if (nextName.equals("t")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    str = jsonReader.nextString();
                                    break;
                                case 1:
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
                                    break;
                                case 2:
                                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                                    break;
                                case 3:
                                    gradientType = jsonReader.nextInt() == 1 ? GradientType.Linear : GradientType.Radial;
                                    break;
                                case 4:
                                    animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                                    break;
                                case 5:
                                    animatablePointValue2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                                    break;
                                case 6:
                                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                                    break;
                                default:
                                    jsonReader.skipValue();
                                    break;
                            }
                        } else if (nextName.equals("nm")) {
                            c = 0;
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
            c = 65535;
            switch (c) {
            }
        }
        return new GradientFill(str, gradientType, fillType, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, null, null);
    }
}
