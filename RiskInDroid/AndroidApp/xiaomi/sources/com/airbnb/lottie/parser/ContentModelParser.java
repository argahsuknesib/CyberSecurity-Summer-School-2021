package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.Log;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

class ContentModelParser {
    private ContentModelParser() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b2, code lost:
        if (r2.equals("gs") != false) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0042 A[SYNTHETIC] */
    static ContentModel parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ContentModel contentModel;
        String str;
        char c;
        jsonReader.beginObject();
        char c2 = 2;
        int i = 2;
        while (true) {
            contentModel = null;
            if (!jsonReader.hasNext()) {
                str = null;
                break;
            }
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode != 100) {
                if (hashCode == 3717 && nextName.equals("ty")) {
                    c = 0;
                    if (c == 0) {
                        str = jsonReader.nextString();
                        break;
                    } else if (c != 1) {
                        jsonReader.skipValue();
                    } else {
                        i = jsonReader.nextInt();
                    }
                }
            } else if (nextName.equals("d")) {
                c = 1;
                if (c == 0) {
                }
            }
            c = 65535;
            if (c == 0) {
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3295:
                if (str.equals("gf")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3307:
                if (str.equals("gr")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3308:
                break;
            case 3488:
                if (str.equals("mm")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 3633:
                if (str.equals("rc")) {
                    c2 = 8;
                    break;
                }
                c2 = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c2 = 12;
                    break;
                }
                c2 = 65535;
                break;
            case 3669:
                if (str.equals("sh")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c2 = 10;
                    break;
                }
                c2 = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3705:
                if (str.equals("tm")) {
                    c2 = 9;
                    break;
                }
                c2 = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                contentModel = ShapeGroupParser.parse(jsonReader, lottieComposition);
                break;
            case 1:
                contentModel = ShapeStrokeParser.parse(jsonReader, lottieComposition);
                break;
            case 2:
                contentModel = GradientStrokeParser.parse(jsonReader, lottieComposition);
                break;
            case 3:
                contentModel = ShapeFillParser.parse(jsonReader, lottieComposition);
                break;
            case 4:
                contentModel = GradientFillParser.parse(jsonReader, lottieComposition);
                break;
            case 5:
                contentModel = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                break;
            case 6:
                contentModel = ShapePathParser.parse(jsonReader, lottieComposition);
                break;
            case 7:
                contentModel = CircleShapeParser.parse(jsonReader, lottieComposition, i);
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                contentModel = RectangleShapeParser.parse(jsonReader, lottieComposition);
                break;
            case 9:
                contentModel = ShapeTrimPathParser.parse(jsonReader, lottieComposition);
                break;
            case 10:
                contentModel = PolystarShapeParser.parse(jsonReader, lottieComposition);
                break;
            case 11:
                contentModel = MergePathsParser.parse(jsonReader);
                lottieComposition.addWarning("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                contentModel = RepeaterParser.parse(jsonReader, lottieComposition);
                break;
            default:
                Log.w("LOTTIE", "Unknown shape type ".concat(String.valueOf(str)));
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return contentModel;
    }
}
