package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final CellResolution DEFAULT_CELL_RESOLUTION = new CellResolution(32, 15);
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern PIXEL_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private final XmlPullParserFactory xmlParserFactory;

    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
            this.xmlParserFactory.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public final Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        TtmlSubtitle ttmlSubtitle;
        TtsExtent ttsExtent;
        CellResolution cellResolution;
        FrameAndTickRate frameAndTickRate;
        FrameAndTickRate frameAndTickRate2;
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new TtmlRegion(""));
            TtsExtent ttsExtent2 = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRate3 = DEFAULT_FRAME_AND_TICK_RATE;
            CellResolution cellResolution2 = DEFAULT_CELL_RESOLUTION;
            TtmlSubtitle ttmlSubtitle2 = null;
            int i2 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            FrameAndTickRate parseFrameAndTickRates = parseFrameAndTickRates(newPullParser);
                            cellResolution = parseCellResolution(newPullParser, DEFAULT_CELL_RESOLUTION);
                            ttsExtent = parseTtsExtent(newPullParser);
                            frameAndTickRate = parseFrameAndTickRates;
                        } else {
                            ttsExtent = ttsExtent2;
                            frameAndTickRate = frameAndTickRate3;
                            cellResolution = cellResolution2;
                        }
                        if (!isSupportedTag(name)) {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i2++;
                            frameAndTickRate3 = frameAndTickRate;
                            cellResolution2 = cellResolution;
                            ttsExtent2 = ttsExtent;
                            newPullParser.next();
                        } else {
                            if ("head".equals(name)) {
                                ttmlSubtitle = ttmlSubtitle2;
                                frameAndTickRate2 = frameAndTickRate;
                                parseHeader(newPullParser, hashMap, cellResolution, ttsExtent, hashMap2, hashMap3);
                            } else {
                                ttmlSubtitle = ttmlSubtitle2;
                                frameAndTickRate2 = frameAndTickRate;
                                try {
                                    TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate2);
                                    arrayDeque.push(parseNode);
                                    if (ttmlNode != null) {
                                        ttmlNode.addChild(parseNode);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    Log.w("TtmlDecoder", "Suppressing parser error", e);
                                    i2++;
                                }
                            }
                            frameAndTickRate3 = frameAndTickRate2;
                            cellResolution2 = cellResolution;
                            ttsExtent2 = ttsExtent;
                        }
                    } else {
                        ttmlSubtitle = ttmlSubtitle2;
                        if (eventType == 4) {
                            ((TtmlNode) Assertions.checkNotNull(ttmlNode)).addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                        } else if (eventType == 3) {
                            ttmlSubtitle2 = newPullParser.getName().equals("tt") ? new TtmlSubtitle((TtmlNode) Assertions.checkNotNull(arrayDeque.peek()), hashMap, hashMap2, hashMap3) : ttmlSubtitle;
                            arrayDeque.pop();
                            newPullParser.next();
                        }
                    }
                } else {
                    ttmlSubtitle = ttmlSubtitle2;
                    if (eventType == 2) {
                        i2++;
                    } else if (eventType == 3) {
                        i2--;
                    }
                }
                ttmlSubtitle2 = ttmlSubtitle;
                newPullParser.next();
            }
            TtmlSubtitle ttmlSubtitle3 = ttmlSubtitle2;
            if (ttmlSubtitle3 != null) {
                return ttmlSubtitle3;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (XmlPullParserException e2) {
            throw new SubtitleDecoderException("Unable to decode source", e2);
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        }
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = Util.split(attributeValue2, " ");
            if (split.length == 2) {
                f = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        }
        int i = DEFAULT_FRAME_AND_TICK_RATE.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = DEFAULT_FRAME_AND_TICK_RATE.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(((float) parseInt) * f, i, i2);
    }

    private CellResolution parseCellResolution(XmlPullParser xmlPullParser, CellResolution cellResolution) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return cellResolution;
        }
        Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", "Ignoring malformed cell resolution: ".concat(String.valueOf(attributeValue)));
            return cellResolution;
        }
        try {
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new CellResolution(parseInt, parseInt2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", "Ignoring malformed cell resolution: ".concat(String.valueOf(attributeValue)));
            return cellResolution;
        }
    }

    private TtsExtent parseTtsExtent(XmlPullParser xmlPullParser) {
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue == null) {
            return null;
        }
        Matcher matcher = PIXEL_COORDINATES.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", "Ignoring non-pixel tts extent: ".concat(String.valueOf(attributeValue)));
            return null;
        }
        try {
            return new TtsExtent(Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", "Ignoring malformed tts extent: ".concat(String.valueOf(attributeValue)));
            return null;
        }
    }

    private Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, CellResolution cellResolution, TtsExtent ttsExtent, Map<String, TtmlRegion> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        parseStyleAttributes.chain(map.get(str));
                    }
                }
                String id = parseStyleAttributes.getId();
                if (id != null) {
                    map.put(id, parseStyleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region")) {
                TtmlRegion parseRegionAttributes = parseRegionAttributes(xmlPullParser, cellResolution, ttsExtent);
                if (parseRegionAttributes != null) {
                    map2.put(parseRegionAttributes.id, parseRegionAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "metadata")) {
                parseMetadata(xmlPullParser, map3);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "head"));
        return map;
    }

    private void parseMetadata(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String attributeValue;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "image") && (attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id")) != null) {
                map.put(attributeValue, xmlPullParser.nextText());
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "metadata"));
    }

    private TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser, CellResolution cellResolution, TtsExtent ttsExtent) {
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        TtsExtent ttsExtent2 = ttsExtent;
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser2, "id");
        if (attributeValue == null) {
            return null;
        }
        String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser2, "origin");
        if (attributeValue2 != null) {
            Matcher matcher = PERCENTAGE_COORDINATES.matcher(attributeValue2);
            Matcher matcher2 = PIXEL_COORDINATES.matcher(attributeValue2);
            if (matcher.matches()) {
                try {
                    float parseFloat = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))) / 100.0f;
                    f = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(2))) / 100.0f;
                    f2 = parseFloat;
                } catch (NumberFormatException unused) {
                    Log.w("TtmlDecoder", "Ignoring region with malformed origin: ".concat(String.valueOf(attributeValue2)));
                    return null;
                }
            } else if (!matcher2.matches()) {
                Log.w("TtmlDecoder", "Ignoring region with unsupported origin: ".concat(String.valueOf(attributeValue2)));
                return null;
            } else if (ttsExtent2 == null) {
                Log.w("TtmlDecoder", "Ignoring region with missing tts:extent: ".concat(String.valueOf(attributeValue2)));
                return null;
            } else {
                try {
                    int parseInt = Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(1)));
                    int parseInt2 = Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(2)));
                    f2 = ((float) parseInt) / ((float) ttsExtent2.width);
                    f = ((float) parseInt2) / ((float) ttsExtent2.height);
                } catch (NumberFormatException unused2) {
                    Log.w("TtmlDecoder", "Ignoring region with malformed origin: ".concat(String.valueOf(attributeValue2)));
                    return null;
                }
            }
            String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser2, "extent");
            if (attributeValue3 != null) {
                Matcher matcher3 = PERCENTAGE_COORDINATES.matcher(attributeValue3);
                Matcher matcher4 = PIXEL_COORDINATES.matcher(attributeValue3);
                if (matcher3.matches()) {
                    try {
                        f4 = Float.parseFloat((String) Assertions.checkNotNull(matcher3.group(1))) / 100.0f;
                        f3 = Float.parseFloat((String) Assertions.checkNotNull(matcher3.group(2))) / 100.0f;
                    } catch (NumberFormatException unused3) {
                        Log.w("TtmlDecoder", "Ignoring region with malformed extent: ".concat(String.valueOf(attributeValue2)));
                        return null;
                    }
                } else if (!matcher4.matches()) {
                    Log.w("TtmlDecoder", "Ignoring region with unsupported extent: ".concat(String.valueOf(attributeValue2)));
                    return null;
                } else if (ttsExtent2 == null) {
                    Log.w("TtmlDecoder", "Ignoring region with missing tts:extent: ".concat(String.valueOf(attributeValue2)));
                    return null;
                } else {
                    try {
                        int parseInt3 = Integer.parseInt((String) Assertions.checkNotNull(matcher4.group(1)));
                        int parseInt4 = Integer.parseInt((String) Assertions.checkNotNull(matcher4.group(2)));
                        f4 = ((float) parseInt3) / ((float) ttsExtent2.width);
                        f3 = ((float) parseInt4) / ((float) ttsExtent2.height);
                    } catch (NumberFormatException unused4) {
                        Log.w("TtmlDecoder", "Ignoring region with malformed extent: ".concat(String.valueOf(attributeValue2)));
                        return null;
                    }
                }
                String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser2, "displayAlign");
                if (attributeValue4 != null) {
                    String lowerInvariant = Util.toLowerInvariant(attributeValue4);
                    char c = 65535;
                    int hashCode = lowerInvariant.hashCode();
                    if (hashCode != -1364013995) {
                        if (hashCode == 92734940 && lowerInvariant.equals("after")) {
                            c = 1;
                        }
                    } else if (lowerInvariant.equals("center")) {
                        c = 0;
                    }
                    if (c == 0) {
                        f += f3 / 2.0f;
                        i = 1;
                    } else if (c == 1) {
                        f += f3;
                        i = 2;
                    }
                    return new TtmlRegion(attributeValue, f2, f, 0, i, f4, f3, 1, 1.0f / ((float) cellResolution.rows));
                }
                i = 0;
                return new TtmlRegion(attributeValue, f2, f, 0, i, f4, f3, 1, 1.0f / ((float) cellResolution.rows));
            }
            Log.w("TtmlDecoder", "Ignoring region without an extent");
            return null;
        }
        Log.w("TtmlDecoder", "Ignoring region without an origin");
        return null;
    }

    private String[] parseStyleIds(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : Util.split(trim, "\\s+");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        char c;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle ttmlStyle2 = ttmlStyle;
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            char c2 = 65535;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c = 9;
                        break;
                    }
                    c = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c = 8;
                        break;
                    }
                    c = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c = 10;
                        break;
                    }
                    c = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1427167391:
                    if (attributeName.equals("writingMode")) {
                        c = 12;
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
                    if (!"style".equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        ttmlStyle2 = createIfNull(ttmlStyle2).setId(attributeValue);
                        break;
                    }
                case 1:
                    ttmlStyle2 = createIfNull(ttmlStyle2);
                    try {
                        ttmlStyle2.setBackgroundColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        Log.w("TtmlDecoder", "Failed parsing background value: ".concat(String.valueOf(attributeValue)));
                        break;
                    }
                case 2:
                    ttmlStyle2 = createIfNull(ttmlStyle2);
                    try {
                        ttmlStyle2.setFontColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused2) {
                        Log.w("TtmlDecoder", "Failed parsing color value: ".concat(String.valueOf(attributeValue)));
                        break;
                    }
                case 3:
                    ttmlStyle2 = createIfNull(ttmlStyle2).setFontFamily(attributeValue);
                    break;
                case 4:
                    try {
                        ttmlStyle2 = createIfNull(ttmlStyle2);
                        parseFontSize(attributeValue, ttmlStyle2);
                        break;
                    } catch (SubtitleDecoderException unused3) {
                        Log.w("TtmlDecoder", "Failed parsing fontSize value: ".concat(String.valueOf(attributeValue)));
                        break;
                    }
                case 5:
                    ttmlStyle2 = createIfNull(ttmlStyle2).setBold("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 6:
                    ttmlStyle2 = createIfNull(ttmlStyle2).setItalic("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    String lowerInvariant = Util.toLowerInvariant(attributeValue);
                    switch (lowerInvariant.hashCode()) {
                        case -1364013995:
                            if (lowerInvariant.equals("center")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 100571:
                            if (lowerInvariant.equals("end")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 3317767:
                            if (lowerInvariant.equals("left")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 108511772:
                            if (lowerInvariant.equals("right")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 109757538:
                            if (lowerInvariant.equals("start")) {
                                c2 = 1;
                                break;
                            }
                            break;
                    }
                    if (c2 != 0 && c2 != 1) {
                        if (c2 != 2 && c2 != 3) {
                            if (c2 == 4) {
                                ttmlStyle2 = createIfNull(ttmlStyle2).setTextAlign(Layout.Alignment.ALIGN_CENTER);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            ttmlStyle2 = createIfNull(ttmlStyle2).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            break;
                        }
                    } else {
                        ttmlStyle2 = createIfNull(ttmlStyle2).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                        break;
                    }
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    String lowerInvariant2 = Util.toLowerInvariant(attributeValue);
                    int hashCode = lowerInvariant2.hashCode();
                    if (hashCode != 96673) {
                        if (hashCode == 3387192 && lowerInvariant2.equals("none")) {
                            c2 = 0;
                        }
                    } else if (lowerInvariant2.equals("all")) {
                        c2 = 1;
                    }
                    if (c2 != 0) {
                        if (c2 == 1) {
                            ttmlStyle2 = createIfNull(ttmlStyle2).setTextCombine(true);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        ttmlStyle2 = createIfNull(ttmlStyle2).setTextCombine(false);
                        break;
                    }
                case 9:
                    String lowerInvariant3 = Util.toLowerInvariant(attributeValue);
                    switch (lowerInvariant3.hashCode()) {
                        case -618561360:
                            if (lowerInvariant3.equals("baseContainer")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case -410956671:
                            if (lowerInvariant3.equals("container")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -250518009:
                            if (lowerInvariant3.equals("delimiter")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case -136074796:
                            if (lowerInvariant3.equals("textContainer")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 3016401:
                            if (lowerInvariant3.equals("base")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 3556653:
                            if (lowerInvariant3.equals("text")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    if (c2 != 0) {
                        if (c2 != 1 && c2 != 2) {
                            if (c2 != 3 && c2 != 4) {
                                if (c2 == 5) {
                                    ttmlStyle2 = createIfNull(ttmlStyle2).setRubyType(4);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                ttmlStyle2 = createIfNull(ttmlStyle2).setRubyType(3);
                                break;
                            }
                        } else {
                            ttmlStyle2 = createIfNull(ttmlStyle2).setRubyType(2);
                            break;
                        }
                    } else {
                        ttmlStyle2 = createIfNull(ttmlStyle2).setRubyType(1);
                        break;
                    }
                case 10:
                    String lowerInvariant4 = Util.toLowerInvariant(attributeValue);
                    int hashCode2 = lowerInvariant4.hashCode();
                    if (hashCode2 != -1392885889) {
                        if (hashCode2 == 92734940 && lowerInvariant4.equals("after")) {
                            c2 = 1;
                        }
                    } else if (lowerInvariant4.equals("before")) {
                        c2 = 0;
                    }
                    if (c2 != 0) {
                        if (c2 == 1) {
                            ttmlStyle2 = createIfNull(ttmlStyle2).setRubyPosition(2);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        ttmlStyle2 = createIfNull(ttmlStyle2).setRubyPosition(1);
                        break;
                    }
                case 11:
                    String lowerInvariant5 = Util.toLowerInvariant(attributeValue);
                    switch (lowerInvariant5.hashCode()) {
                        case -1461280213:
                            if (lowerInvariant5.equals("nounderline")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (lowerInvariant5.equals("underline")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 913457136:
                            if (lowerInvariant5.equals("nolinethrough")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (lowerInvariant5.equals("linethrough")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    if (c2 != 0) {
                        if (c2 != 1) {
                            if (c2 != 2) {
                                if (c2 == 3) {
                                    ttmlStyle2 = createIfNull(ttmlStyle2).setUnderline(false);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                ttmlStyle2 = createIfNull(ttmlStyle2).setUnderline(true);
                                break;
                            }
                        } else {
                            ttmlStyle2 = createIfNull(ttmlStyle2).setLinethrough(false);
                            break;
                        }
                    } else {
                        ttmlStyle2 = createIfNull(ttmlStyle2).setLinethrough(true);
                        break;
                    }
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    String lowerInvariant6 = Util.toLowerInvariant(attributeValue);
                    int hashCode3 = lowerInvariant6.hashCode();
                    if (hashCode3 != 3694) {
                        if (hashCode3 != 3553396) {
                            if (hashCode3 == 3553576 && lowerInvariant6.equals("tbrl")) {
                                c2 = 2;
                            }
                        } else if (lowerInvariant6.equals("tblr")) {
                            c2 = 1;
                        }
                    } else if (lowerInvariant6.equals("tb")) {
                        c2 = 0;
                    }
                    if (c2 != 0 && c2 != 1) {
                        if (c2 == 2) {
                            ttmlStyle2 = createIfNull(ttmlStyle2).setVerticalType(1);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        ttmlStyle2 = createIfNull(ttmlStyle2).setVerticalType(2);
                        break;
                    }
            }
        }
        return ttmlStyle2;
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map<String, TtmlRegion> map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        long j;
        long j2;
        char c;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        TtmlNode ttmlNode2 = ttmlNode;
        FrameAndTickRate frameAndTickRate2 = frameAndTickRate;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser2, null);
        String str = "";
        String str2 = null;
        String[] strArr = null;
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        long j5 = -9223372036854775807L;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser2.getAttributeName(i);
            String attributeValue = xmlPullParser2.getAttributeValue(i);
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                j3 = parseTimeExpression(attributeValue, frameAndTickRate2);
            } else if (c == 1) {
                j4 = parseTimeExpression(attributeValue, frameAndTickRate2);
            } else if (c == 2) {
                j5 = parseTimeExpression(attributeValue, frameAndTickRate2);
            } else if (c == 3) {
                String[] parseStyleIds = parseStyleIds(attributeValue);
                if (parseStyleIds.length > 0) {
                    strArr = parseStyleIds;
                }
            } else if (c != 4) {
                if (c == 5 && attributeValue.startsWith("#")) {
                    str2 = attributeValue.substring(1);
                }
            } else if (map.containsKey(attributeValue)) {
                str = attributeValue;
            }
        }
        if (ttmlNode2 != null) {
            j = -9223372036854775807L;
            if (ttmlNode2.startTimeUs != -9223372036854775807L) {
                if (j3 != -9223372036854775807L) {
                    j3 += ttmlNode2.startTimeUs;
                }
                if (j4 != -9223372036854775807L) {
                    j4 += ttmlNode2.startTimeUs;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        long j6 = j3;
        if (j4 == j) {
            if (j5 != j) {
                j2 = j5 + j6;
            } else if (!(ttmlNode2 == null || ttmlNode2.endTimeUs == j)) {
                j2 = ttmlNode2.endTimeUs;
            }
            return TtmlNode.buildNode(xmlPullParser.getName(), j6, j2, parseStyleAttributes, strArr, str, str2, ttmlNode);
        }
        j2 = j4;
        return TtmlNode.buildNode(xmlPullParser.getName(), j6, j2, parseStyleAttributes, strArr, str, str2, ttmlNode);
    }

    private static boolean isSupportedTag(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] split = Util.split(str, "\\s+");
        if (split.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (split.length == 2) {
            matcher = FONT_SIZE.matcher(split[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(3));
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 37) {
                if (hashCode != 3240) {
                    if (hashCode == 3592 && str2.equals("px")) {
                        c = 0;
                    }
                } else if (str2.equals("em")) {
                    c = 1;
                }
            } else if (str2.equals("%")) {
                c = 2;
            }
            if (c == 0) {
                ttmlStyle.setFontSizeUnit(1);
            } else if (c == 1) {
                ttmlStyle.setFontSizeUnit(2);
            } else if (c == 2) {
                ttmlStyle.setFontSizeUnit(3);
            } else {
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
            }
            ttmlStyle.setFontSize(Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))));
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013e  */
    private static long parseTimeExpression(String str, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        char c;
        double d;
        double d2;
        Matcher matcher = CLOCK_TIME.matcher(str);
        if (matcher.matches()) {
            double parseLong = (double) (Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) * 3600);
            double parseLong2 = (double) (Long.parseLong((String) Assertions.checkNotNull(matcher.group(2))) * 60);
            Double.isNaN(parseLong);
            Double.isNaN(parseLong2);
            double parseLong3 = (double) Long.parseLong((String) Assertions.checkNotNull(matcher.group(3)));
            Double.isNaN(parseLong3);
            double d3 = parseLong + parseLong2 + parseLong3;
            String group = matcher.group(4);
            double d4 = 0.0d;
            double parseDouble = d3 + (group != null ? Double.parseDouble(group) : 0.0d);
            String group2 = matcher.group(5);
            double parseLong4 = parseDouble + (group2 != null ? (double) (((float) Long.parseLong(group2)) / frameAndTickRate.effectiveFrameRate) : 0.0d);
            String group3 = matcher.group(6);
            if (group3 != null) {
                double parseLong5 = (double) Long.parseLong(group3);
                double d5 = (double) frameAndTickRate.subFrameRate;
                Double.isNaN(parseLong5);
                Double.isNaN(d5);
                double d6 = (double) frameAndTickRate.effectiveFrameRate;
                Double.isNaN(d6);
                d4 = (parseLong5 / d5) / d6;
            }
            return (long) ((parseLong4 + d4) * 1000000.0d);
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (matcher2.matches()) {
            double parseDouble2 = Double.parseDouble((String) Assertions.checkNotNull(matcher2.group(1)));
            String str2 = (String) Assertions.checkNotNull(matcher2.group(2));
            int hashCode = str2.hashCode();
            if (hashCode != 102) {
                if (hashCode != 104) {
                    if (hashCode != 109) {
                        if (hashCode != 3494) {
                            if (hashCode != 115) {
                                if (hashCode == 116 && str2.equals("t")) {
                                    c = 5;
                                    if (c == 0) {
                                        d = 3600.0d;
                                    } else if (c != 1) {
                                        if (c != 2) {
                                            if (c == 3) {
                                                d2 = 1000.0d;
                                            } else if (c == 4) {
                                                d2 = (double) frameAndTickRate.effectiveFrameRate;
                                                Double.isNaN(d2);
                                            } else if (c == 5) {
                                                d2 = (double) frameAndTickRate.tickRate;
                                                Double.isNaN(d2);
                                            }
                                            parseDouble2 /= d2;
                                        }
                                        return (long) (parseDouble2 * 1000000.0d);
                                    } else {
                                        d = 60.0d;
                                    }
                                    parseDouble2 *= d;
                                    return (long) (parseDouble2 * 1000000.0d);
                                }
                            } else if (str2.equals("s")) {
                                c = 2;
                                if (c == 0) {
                                }
                                parseDouble2 *= d;
                                return (long) (parseDouble2 * 1000000.0d);
                            }
                        } else if (str2.equals("ms")) {
                            c = 3;
                            if (c == 0) {
                            }
                            parseDouble2 *= d;
                            return (long) (parseDouble2 * 1000000.0d);
                        }
                    } else if (str2.equals("m")) {
                        c = 1;
                        if (c == 0) {
                        }
                        parseDouble2 *= d;
                        return (long) (parseDouble2 * 1000000.0d);
                    }
                } else if (str2.equals("h")) {
                    c = 0;
                    if (c == 0) {
                    }
                    parseDouble2 *= d;
                    return (long) (parseDouble2 * 1000000.0d);
                }
            } else if (str2.equals("f")) {
                c = 4;
                if (c == 0) {
                }
                parseDouble2 *= d;
                return (long) (parseDouble2 * 1000000.0d);
            }
            c = 65535;
            if (c == 0) {
            }
            parseDouble2 *= d;
            return (long) (parseDouble2 * 1000000.0d);
        }
        throw new SubtitleDecoderException("Malformed time expression: ".concat(String.valueOf(str)));
    }

    static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f, int i, int i2) {
            this.effectiveFrameRate = f;
            this.subFrameRate = i;
            this.tickRate = i2;
        }
    }

    static final class CellResolution {
        final int columns;
        final int rows;

        CellResolution(int i, int i2) {
            this.columns = i;
            this.rows = i2;
        }
    }

    static final class TtsExtent {
        final int height;
        final int width;

        TtsExtent(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }
}
