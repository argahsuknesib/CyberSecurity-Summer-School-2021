package com.airbnb.lottie.parser;

import _m_j.o0O0o000;
import _m_j.o0OO00o0;
import android.graphics.Rect;
import android.util.JsonReader;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottieCompositionParser {
    private LottieCompositionParser() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static LottieComposition parse(JsonReader jsonReader) throws IOException {
        char c;
        o0OO00o0 o0oo00o0;
        HashMap hashMap;
        JsonReader jsonReader2 = jsonReader;
        float dpScale = Utils.dpScale();
        o0O0o000 o0o0o000 = new o0O0o000();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        o0OO00o0 o0oo00o02 = new o0OO00o0();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.beginObject();
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case -1408207997:
                    if (nextName.equals("assets")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1109732030:
                    if (nextName.equals("layers")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 118:
                    if (nextName.equals("v")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3276:
                    if (nextName.equals("fr")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 94623709:
                    if (nextName.equals("chars")) {
                        c = 9;
                        break;
                    }
                    c = 65535;
                    break;
                case 97615364:
                    if (nextName.equals("fonts")) {
                        c = 8;
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
                    i = jsonReader.nextInt();
                    continue;
                case 1:
                    i2 = jsonReader.nextInt();
                    continue;
                case 2:
                    o0oo00o0 = o0oo00o02;
                    hashMap = hashMap4;
                    f = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    o0oo00o0 = o0oo00o02;
                    hashMap = hashMap4;
                    f2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 4:
                    f3 = (float) jsonReader.nextDouble();
                    continue;
                case 5:
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!Utils.isAtLeastVersion(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                    }
                    o0oo00o0 = o0oo00o02;
                    hashMap = hashMap4;
                    break;
                case 6:
                    parseLayers(jsonReader2, lottieComposition, arrayList, o0o0o000);
                    o0oo00o0 = o0oo00o02;
                    hashMap = hashMap4;
                    break;
                case 7:
                    parseAssets(jsonReader2, lottieComposition, hashMap2, hashMap3);
                    o0oo00o0 = o0oo00o02;
                    hashMap = hashMap4;
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    parseFonts(jsonReader2, hashMap4);
                    o0oo00o0 = o0oo00o02;
                    hashMap = hashMap4;
                    break;
                case 9:
                    parseChars(jsonReader2, lottieComposition, o0oo00o02);
                    o0oo00o0 = o0oo00o02;
                    hashMap = hashMap4;
                    break;
                default:
                    o0oo00o0 = o0oo00o02;
                    hashMap = hashMap4;
                    jsonReader.skipValue();
                    break;
            }
            hashMap4 = hashMap;
            o0oo00o02 = o0oo00o0;
        }
        jsonReader.endObject();
        lottieComposition.init(new Rect(0, 0, (int) (((float) i) * dpScale), (int) (((float) i2) * dpScale)), f, f2, f3, arrayList, o0o0o000, hashMap2, hashMap3, o0oo00o02, hashMap4);
        return lottieComposition;
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, o0O0o000<Layer> o0o0o000) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer parse = LayerParser.parse(jsonReader, lottieComposition);
            if (parse.getLayerType() == Layer.LayerType.Image) {
                i++;
            }
            list.add(parse);
            o0o0o000.O00000Oo(parse.getId(), parse);
            if (i > 4) {
                L.warn("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void parseAssets(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            o0O0o000 o0o0o000 = new o0O0o000();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != -1109732030) {
                    if (hashCode != 104) {
                        if (hashCode != 112) {
                            if (hashCode != 117) {
                                if (hashCode != 119) {
                                    if (hashCode == 3355 && nextName.equals("id")) {
                                        c = 0;
                                    }
                                } else if (nextName.equals("w")) {
                                    c = 2;
                                }
                            } else if (nextName.equals("u")) {
                                c = 5;
                            }
                        } else if (nextName.equals("p")) {
                            c = 4;
                        }
                    } else if (nextName.equals("h")) {
                        c = 3;
                    }
                } else if (nextName.equals("layers")) {
                    c = 1;
                }
                if (c == 0) {
                    str = jsonReader.nextString();
                } else if (c == 1) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        Layer parse = LayerParser.parse(jsonReader, lottieComposition);
                        o0o0o000.O00000Oo(parse.getId(), parse);
                        arrayList.add(parse);
                    }
                    jsonReader.endArray();
                } else if (c == 2) {
                    i = jsonReader.nextInt();
                } else if (c == 3) {
                    i2 = jsonReader.nextInt();
                } else if (c == 4) {
                    str2 = jsonReader.nextString();
                } else if (c != 5) {
                    jsonReader.skipValue();
                } else {
                    str3 = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(i, i2, str, str2, str3);
                map2.put(lottieImageAsset.getId(), lottieImageAsset);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void parseFonts(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 3322014 && nextName.equals("list")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Font parse = FontParser.parse(jsonReader);
                    map.put(parse.getName(), parse);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    private static void parseChars(JsonReader jsonReader, LottieComposition lottieComposition, o0OO00o0<FontCharacter> o0oo00o0) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            FontCharacter parse = FontCharacterParser.parse(jsonReader, lottieComposition);
            o0oo00o0.O00000Oo(parse.hashCode(), parse);
        }
        jsonReader.endArray();
    }
}
