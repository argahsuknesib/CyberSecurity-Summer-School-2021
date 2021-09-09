package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.model.DocumentData;
import com.google.android.exoplayer2.C;
import java.io.IOException;

public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = new DocumentDataParser();

    private DocumentDataParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010b  */
    public DocumentData parse(JsonReader jsonReader, float f) throws IOException {
        char c;
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode != 102) {
                if (hashCode != 106) {
                    if (hashCode != 3261) {
                        if (hashCode != 3452) {
                            if (hashCode != 3463) {
                                if (hashCode != 3543) {
                                    if (hashCode != 3664) {
                                        if (hashCode != 3684) {
                                            if (hashCode != 3710) {
                                                if (hashCode != 115) {
                                                    if (hashCode == 116 && nextName.equals("t")) {
                                                        c = 0;
                                                        switch (c) {
                                                            case 0:
                                                                str = jsonReader.nextString();
                                                                break;
                                                            case 1:
                                                                str2 = jsonReader.nextString();
                                                                break;
                                                            case 2:
                                                                d = jsonReader.nextDouble();
                                                                break;
                                                            case 3:
                                                                i = jsonReader.nextInt();
                                                                break;
                                                            case 4:
                                                                i2 = jsonReader.nextInt();
                                                                break;
                                                            case 5:
                                                                d2 = jsonReader.nextDouble();
                                                                break;
                                                            case 6:
                                                                d3 = jsonReader.nextDouble();
                                                                break;
                                                            case 7:
                                                                i3 = JsonUtils.jsonToColor(jsonReader);
                                                                break;
                                                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                                                                i4 = JsonUtils.jsonToColor(jsonReader);
                                                                break;
                                                            case 9:
                                                                d4 = jsonReader.nextDouble();
                                                                break;
                                                            case 10:
                                                                z = jsonReader.nextBoolean();
                                                                break;
                                                            default:
                                                                jsonReader.skipValue();
                                                                break;
                                                        }
                                                    }
                                                } else if (nextName.equals("s")) {
                                                    c = 2;
                                                    switch (c) {
                                                    }
                                                }
                                            } else if (nextName.equals("tr")) {
                                                c = 4;
                                                switch (c) {
                                                }
                                            }
                                        } else if (nextName.equals("sw")) {
                                            c = 9;
                                            switch (c) {
                                            }
                                        }
                                    } else if (nextName.equals("sc")) {
                                        c = 8;
                                        switch (c) {
                                        }
                                    }
                                } else if (nextName.equals("of")) {
                                    c = 10;
                                    switch (c) {
                                    }
                                }
                            } else if (nextName.equals("ls")) {
                                c = 6;
                                switch (c) {
                                }
                            }
                        } else if (nextName.equals("lh")) {
                            c = 5;
                            switch (c) {
                            }
                        }
                    } else if (nextName.equals("fc")) {
                        c = 7;
                        switch (c) {
                        }
                    }
                } else if (nextName.equals("j")) {
                    c = 3;
                    switch (c) {
                    }
                }
            } else if (nextName.equals("f")) {
                c = 1;
                switch (c) {
                }
            }
            c = 65535;
            switch (c) {
            }
        }
        jsonReader.endObject();
        return new DocumentData(str, str2, d, i, i2, d2, d3, i3, i4, d4, z);
    }
}
