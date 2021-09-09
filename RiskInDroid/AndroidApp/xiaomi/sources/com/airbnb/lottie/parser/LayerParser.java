package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class LayerParser {
    private LayerParser() {
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect bounds = lottieComposition.getBounds();
        List emptyList = Collections.emptyList();
        Layer.LayerType layerType = Layer.LayerType.PreComp;
        List emptyList2 = Collections.emptyList();
        AnimatableTransform animatableTransform = r4;
        AnimatableTransform animatableTransform2 = new AnimatableTransform();
        return new Layer(emptyList, lottieComposition, "__container", -1, layerType, -1, null, emptyList2, animatableTransform, 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), Layer.MatteType.None, null);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0266  */
    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        float f;
        ArrayList arrayList;
        char c;
        char c2;
        LottieComposition lottieComposition2 = lottieComposition;
        Layer.MatteType matteType = Layer.MatteType.None;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.beginObject();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        boolean z = false;
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        AnimatableTransform animatableTransform = null;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        long j = 0;
        long j2 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f5 = 0.0f;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case -995424086:
                    if (nextName.equals("parent")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -903568142:
                    if (nextName.equals("shapes")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = 12;
                        break;
                    }
                    c = 65535;
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 3177:
                    if (nextName.equals("cl")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 3233:
                    if (nextName.equals("ef")) {
                        c = 13;
                        break;
                    }
                    c = 65535;
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 3432:
                    if (nextName.equals("ks")) {
                        c = 8;
                        break;
                    }
                    c = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 3669:
                    if (nextName.equals("sh")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3679:
                    if (nextName.equals("sr")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 3681:
                    if (nextName.equals("st")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3705:
                    if (nextName.equals("tm")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 3712:
                    if (nextName.equals("tt")) {
                        c = 9;
                        break;
                    }
                    c = 65535;
                    break;
                case 3717:
                    if (nextName.equals("ty")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 108390670:
                    if (nextName.equals("refId")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1441620890:
                    if (nextName.equals("masksProperties")) {
                        c = 10;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    str3 = jsonReader.nextString();
                    break;
                case 1:
                    j = (long) jsonReader.nextInt();
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    if (nextInt >= Layer.LayerType.Unknown.ordinal()) {
                        layerType = Layer.LayerType.Unknown;
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[nextInt];
                        break;
                    }
                case 4:
                    j2 = (long) jsonReader.nextInt();
                    break;
                case 5:
                    i = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    break;
                case 6:
                    i2 = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    break;
                case 7:
                    i3 = Color.parseColor(jsonReader.nextString());
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    break;
                case 9:
                    matteType2 = Layer.MatteType.values()[jsonReader.nextInt()];
                    break;
                case 10:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList2.add(MaskParser.parse(jsonReader, lottieComposition));
                    }
                    jsonReader.endArray();
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel parse = ContentModelParser.parse(jsonReader, lottieComposition);
                        if (parse != null) {
                            arrayList3.add(parse);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        int hashCode = nextName2.hashCode();
                        if (hashCode != 97) {
                            if (hashCode == 100 && nextName2.equals("d")) {
                                c2 = 0;
                                if (c2 == 0) {
                                    animatableTextFrame = AnimatableValueParser.parseDocumentData(jsonReader, lottieComposition);
                                } else if (c2 != 1) {
                                    jsonReader.skipValue();
                                } else {
                                    jsonReader.beginArray();
                                    if (jsonReader.hasNext()) {
                                        animatableTextProperties = AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                                    }
                                    while (jsonReader.hasNext()) {
                                        jsonReader.skipValue();
                                    }
                                    jsonReader.endArray();
                                }
                            }
                        } else if (nextName2.equals("a")) {
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
                case 13:
                    jsonReader.beginArray();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            if (((nextName3.hashCode() == 3519 && nextName3.equals("nm")) ? (char) 0 : 65535) != 0) {
                                jsonReader.skipValue();
                            } else {
                                arrayList4.add(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition2.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList4)));
                    break;
                case 14:
                    f4 = (float) jsonReader.nextDouble();
                    continue;
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    f5 = (float) jsonReader.nextDouble();
                    continue;
                case 16:
                    i4 = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    continue;
                case 17:
                    i5 = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    continue;
                case 18:
                    f2 = (float) jsonReader.nextDouble();
                    continue;
                case 19:
                    f3 = (float) jsonReader.nextDouble();
                    continue;
                case 20:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition2, z);
                    continue;
                case 21:
                    str2 = jsonReader.nextString();
                    continue;
                default:
                    jsonReader.skipValue();
                    break;
            }
            z = false;
        }
        jsonReader.endObject();
        float f6 = f2 / f4;
        float f7 = f3 / f4;
        ArrayList arrayList5 = new ArrayList();
        if (f6 > 0.0f) {
            Keyframe keyframe = r0;
            f = f4;
            arrayList = arrayList5;
            Keyframe keyframe2 = new Keyframe(lottieComposition, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f6));
            arrayList.add(keyframe);
        } else {
            f = f4;
            arrayList = arrayList5;
        }
        if (f7 <= 0.0f) {
            f7 = lottieComposition.getEndFrame();
        }
        LottieComposition lottieComposition3 = lottieComposition;
        Keyframe keyframe3 = r0;
        Keyframe keyframe4 = new Keyframe(lottieComposition3, valueOf, valueOf, null, f6, Float.valueOf(f7));
        arrayList.add(keyframe3);
        arrayList.add(new Keyframe(lottieComposition3, valueOf2, valueOf2, null, f7, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            lottieComposition2.addWarning("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList3, lottieComposition, str3, j, layerType, j2, str, arrayList2, animatableTransform, i, i2, i3, f, f5, i4, i5, animatableTextFrame, animatableTextProperties, arrayList, matteType2, animatableFloatValue);
    }
}
