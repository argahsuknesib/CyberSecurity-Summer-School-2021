package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.google.android.exoplayer2.C;
import java.io.IOException;

class PolystarShapeParser {
    private PolystarShapeParser() {
    }

    static PolystarShape parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 114) {
                    if (hashCode != 3519) {
                        if (hashCode != 3588) {
                            if (hashCode != 3686) {
                                if (hashCode != 3369) {
                                    if (hashCode != 3370) {
                                        if (hashCode != 3555) {
                                            if (hashCode == 3556 && nextName.equals("os")) {
                                                c = 6;
                                            }
                                        } else if (nextName.equals("or")) {
                                            c = 5;
                                        }
                                    } else if (nextName.equals("is")) {
                                        c = 8;
                                    }
                                } else if (nextName.equals("ir")) {
                                    c = 7;
                                }
                            } else if (nextName.equals("sy")) {
                                c = 1;
                            }
                        } else if (nextName.equals("pt")) {
                            c = 2;
                        }
                    } else if (nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("r")) {
                    c = 4;
                }
            } else if (nextName.equals("p")) {
                c = 3;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.nextInt());
                    break;
                case 2:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 3:
                    animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                    break;
                case 4:
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 5:
                    animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue6 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 7:
                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    animatableFloatValue5 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(str, type, animatableFloatValue, animatableValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4, animatableFloatValue5, animatableFloatValue6);
    }
}
