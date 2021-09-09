package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.Xml;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    private static final Pattern CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
    private static final Pattern CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private final XmlPullParserFactory xmlParserFactory;

    public DashManifestParser() {
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public DashManifest parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return parseMediaPresentationDescription(newPullParser, uri.toString());
            }
            throw new ParserException("inputStream does not contain a valid media presentation description");
        } catch (XmlPullParserException e) {
            throw new ParserException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0176 A[LOOP:0: B:15:0x0067->B:61:0x0176, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0131 A[SYNTHETIC] */
    public DashManifest parseMediaPresentationDescription(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long j3;
        DashManifestParser dashManifestParser = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long parseDateTime = parseDateTime(xmlPullParser2, "availabilityStartTime", -9223372036854775807L);
        long parseDuration = parseDuration(xmlPullParser2, "mediaPresentationDuration", -9223372036854775807L);
        long parseDuration2 = parseDuration(xmlPullParser2, "minBufferTime", -9223372036854775807L);
        boolean equals = "dynamic".equals(xmlPullParser2.getAttributeValue(null, "type"));
        long parseDuration3 = equals ? parseDuration(xmlPullParser2, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long parseDuration4 = equals ? parseDuration(xmlPullParser2, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long parseDuration5 = equals ? parseDuration(xmlPullParser2, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long parseDateTime2 = parseDateTime(xmlPullParser2, "publishTime", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        UtcTimingElement utcTimingElement = null;
        Uri uri = null;
        long j4 = equals ? -9223372036854775807L : 0;
        boolean z2 = false;
        String str2 = str;
        ProgramInformation programInformation = null;
        while (true) {
            xmlPullParser.next();
            long j5 = parseDuration4;
            if (!XmlPullParserUtil.isStartTag(xmlPullParser2, "BaseURL")) {
                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "ProgramInformation")) {
                    j = parseDuration3;
                    programInformation = parseProgramInformation(xmlPullParser);
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "UTCTiming")) {
                    j = parseDuration3;
                    utcTimingElement = parseUtcTiming(xmlPullParser);
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Location")) {
                    j = parseDuration3;
                    uri = Uri.parse(xmlPullParser.nextText());
                } else if (!XmlPullParserUtil.isStartTag(xmlPullParser2, "Period") || z2) {
                    j2 = j4;
                    j = parseDuration3;
                    maybeSkipTag(xmlPullParser);
                } else {
                    Pair<Period, Long> parsePeriod = dashManifestParser.parsePeriod(xmlPullParser2, str2, j4);
                    long j6 = j4;
                    Period period = (Period) parsePeriod.first;
                    j = parseDuration3;
                    if (period.startMs != -9223372036854775807L) {
                        long longValue = ((Long) parsePeriod.second).longValue();
                        if (longValue == -9223372036854775807L) {
                            j3 = -9223372036854775807L;
                        } else {
                            j3 = longValue + period.startMs;
                        }
                        arrayList.add(period);
                        j4 = j3;
                    } else if (equals) {
                        j4 = j6;
                        z2 = true;
                    } else {
                        throw new ParserException("Unable to determine start of period " + arrayList.size());
                    }
                }
                if (XmlPullParserUtil.isEndTag(xmlPullParser2, "MPD")) {
                }
            } else if (!z) {
                str2 = dashManifestParser.parseBaseUrl(xmlPullParser2, str2);
                j = parseDuration3;
                z = true;
                if (XmlPullParserUtil.isEndTag(xmlPullParser2, "MPD")) {
                    if (parseDuration == -9223372036854775807L) {
                        if (j4 != -9223372036854775807L) {
                            parseDuration = j4;
                        } else if (!equals) {
                            throw new ParserException("Unable to determine duration of static manifest.");
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        return buildMediaPresentationDescription(parseDateTime, parseDuration, parseDuration2, equals, j, j5, parseDuration5, parseDateTime2, programInformation, utcTimingElement, uri, arrayList);
                    }
                    throw new ParserException("No periods found.");
                }
                dashManifestParser = this;
                parseDuration4 = j5;
                parseDuration3 = j;
            } else {
                j2 = j4;
                j = parseDuration3;
            }
            j4 = j2;
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "MPD")) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public DashManifest buildMediaPresentationDescription(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, ProgramInformation programInformation, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        return new DashManifest(j, j2, j3, z, j4, j5, j6, j7, programInformation, utcTimingElement, uri, list);
    }

    /* access modifiers changed from: protected */
    public UtcTimingElement parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    /* access modifiers changed from: protected */
    public UtcTimingElement buildUtcTimingElement(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    /* access modifiers changed from: protected */
    public Pair<Period, Long> parsePeriod(XmlPullParser xmlPullParser, String str, long j) throws XmlPullParserException, IOException {
        String str2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        long parseDuration = parseDuration(xmlPullParser2, "start", j);
        long parseDuration2 = parseDuration(xmlPullParser2, "duration", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str3 = str;
        SegmentBase segmentBase = null;
        Descriptor descriptor = null;
        boolean z = false;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "BaseURL")) {
                if (!z) {
                    str3 = parseBaseUrl(xmlPullParser2, str3);
                    z = true;
                } else {
                    str2 = str3;
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "AdaptationSet")) {
                str2 = str3;
                arrayList.add(parseAdaptationSet(xmlPullParser, str3, segmentBase, parseDuration2));
            } else {
                str2 = str3;
                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "EventStream")) {
                    arrayList2.add(parseEventStream(xmlPullParser));
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentBase")) {
                    segmentBase = parseSegmentBase(xmlPullParser2, null);
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentList")) {
                    segmentBase = parseSegmentList(xmlPullParser2, null, parseDuration2);
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                    segmentBase = parseSegmentTemplate(xmlPullParser, null, Collections.emptyList(), parseDuration2);
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "AssetIdentifier")) {
                    descriptor = parseDescriptor(xmlPullParser2, "AssetIdentifier");
                } else {
                    maybeSkipTag(xmlPullParser);
                }
            }
            str3 = str2;
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "Period"));
        return Pair.create(buildPeriod(attributeValue, parseDuration, arrayList, arrayList2, descriptor), Long.valueOf(parseDuration2));
    }

    /* access modifiers changed from: protected */
    public Period buildPeriod(String str, long j, List<AdaptationSet> list, List<EventStream> list2, Descriptor descriptor) {
        return new Period(str, j, list, list2, descriptor);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v5, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x029e A[LOOP:0: B:1:0x0073->B:67:0x029e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0263 A[EDGE_INSN: B:68:0x0263->B:61:0x0263 ?: BREAK  , SYNTHETIC] */
    public AdaptationSet parseAdaptationSet(XmlPullParser xmlPullParser, String str, SegmentBase segmentBase, long j) throws XmlPullParserException, IOException {
        String str2;
        String str3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        DashManifestParser dashManifestParser;
        XmlPullParser xmlPullParser2;
        ArrayList arrayList7;
        int i;
        String str4;
        String str5;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        ArrayList arrayList11;
        ArrayList arrayList12;
        ArrayList arrayList13;
        String str6;
        String str7;
        int i2;
        XmlPullParser xmlPullParser3;
        DashManifestParser dashManifestParser2;
        SegmentBase parseSegmentTemplate;
        DashManifestParser dashManifestParser3 = this;
        XmlPullParser xmlPullParser4 = xmlPullParser;
        int parseInt = parseInt(xmlPullParser4, "id", -1);
        int parseContentType = parseContentType(xmlPullParser);
        String str8 = null;
        String attributeValue = xmlPullParser4.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser4.getAttributeValue(null, "codecs");
        int parseInt2 = parseInt(xmlPullParser4, "width", -1);
        int parseInt3 = parseInt(xmlPullParser4, "height", -1);
        float parseFrameRate = parseFrameRate(xmlPullParser4, -1.0f);
        int parseInt4 = parseInt(xmlPullParser4, "audioSamplingRate", -1);
        String str9 = "lang";
        String attributeValue3 = xmlPullParser4.getAttributeValue(null, str9);
        String attributeValue4 = xmlPullParser4.getAttributeValue(null, "label");
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        ArrayList arrayList19 = new ArrayList();
        ArrayList arrayList20 = new ArrayList();
        String str10 = str;
        SegmentBase segmentBase2 = segmentBase;
        String str11 = attributeValue4;
        String str12 = null;
        boolean z = false;
        int i3 = -1;
        String str13 = attributeValue3;
        int i4 = parseContentType;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser4, "BaseURL")) {
                if (!z) {
                    str10 = dashManifestParser3.parseBaseUrl(xmlPullParser4, str10);
                    arrayList5 = arrayList19;
                    arrayList4 = arrayList18;
                    arrayList3 = arrayList17;
                    arrayList2 = arrayList16;
                    arrayList = arrayList14;
                    str3 = str9;
                    str2 = str8;
                    xmlPullParser2 = xmlPullParser4;
                    dashManifestParser = dashManifestParser3;
                    z = true;
                }
                str5 = str13;
                str4 = str10;
                arrayList8 = arrayList19;
                arrayList9 = arrayList18;
                arrayList10 = arrayList17;
                arrayList11 = arrayList16;
                arrayList13 = arrayList14;
                str6 = str9;
                str7 = str8;
                xmlPullParser3 = xmlPullParser4;
                dashManifestParser2 = dashManifestParser3;
                i2 = i4;
                arrayList7 = arrayList20;
                arrayList6 = arrayList15;
                str13 = str5;
                str10 = str4;
                if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                    break;
                }
                i4 = i;
                arrayList20 = arrayList7;
                xmlPullParser4 = xmlPullParser2;
                dashManifestParser3 = dashManifestParser;
                arrayList15 = arrayList6;
                arrayList19 = arrayList5;
                arrayList18 = arrayList4;
                arrayList17 = arrayList3;
                arrayList16 = arrayList2;
                arrayList14 = arrayList;
                str9 = str3;
                str8 = str2;
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser4, "ContentProtection")) {
                    Pair<String, DrmInitData.SchemeData> parseContentProtection = parseContentProtection(xmlPullParser);
                    if (parseContentProtection.first != null) {
                        str12 = parseContentProtection.first;
                    }
                    if (parseContentProtection.second != null) {
                        arrayList14.add(parseContentProtection.second);
                    }
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser4, "ContentComponent")) {
                    str13 = checkLanguageConsistency(str13, xmlPullParser4.getAttributeValue(str8, str9));
                    arrayList5 = arrayList19;
                    arrayList4 = arrayList18;
                    arrayList3 = arrayList17;
                    arrayList2 = arrayList16;
                    arrayList = arrayList14;
                    str3 = str9;
                    str2 = str8;
                    xmlPullParser2 = xmlPullParser4;
                    dashManifestParser = dashManifestParser3;
                    i = checkContentTypeConsistency(i4, parseContentType(xmlPullParser));
                    arrayList7 = arrayList20;
                    arrayList6 = arrayList15;
                    if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                    }
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser4, "Role")) {
                        arrayList17.add(parseDescriptor(xmlPullParser4, "Role"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser4, "AudioChannelConfiguration")) {
                        i3 = parseAudioChannelConfiguration(xmlPullParser);
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser4, "Accessibility")) {
                        arrayList16.add(parseDescriptor(xmlPullParser4, "Accessibility"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser4, "EssentialProperty")) {
                        arrayList18.add(parseDescriptor(xmlPullParser4, "EssentialProperty"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser4, "SupplementalProperty")) {
                        arrayList19.add(parseDescriptor(xmlPullParser4, "SupplementalProperty"));
                    } else {
                        if (XmlPullParserUtil.isStartTag(xmlPullParser4, "Representation")) {
                            str5 = str13;
                            str4 = str10;
                            arrayList8 = arrayList19;
                            arrayList9 = arrayList18;
                            arrayList10 = arrayList17;
                            arrayList11 = arrayList16;
                            arrayList12 = arrayList15;
                            arrayList13 = arrayList14;
                            str6 = str9;
                            str7 = str8;
                            RepresentationInfo parseRepresentation = parseRepresentation(xmlPullParser, str10, attributeValue, attributeValue2, parseInt2, parseInt3, parseFrameRate, i3, parseInt4, str5, arrayList10, arrayList11, arrayList9, arrayList8, segmentBase2, j);
                            int checkContentTypeConsistency = checkContentTypeConsistency(i4, MimeTypes.getTrackType(parseRepresentation.format.sampleMimeType));
                            arrayList7 = arrayList20;
                            arrayList7.add(parseRepresentation);
                            dashManifestParser2 = this;
                            xmlPullParser3 = xmlPullParser;
                            i2 = checkContentTypeConsistency;
                        } else {
                            str5 = str13;
                            str4 = str10;
                            arrayList8 = arrayList19;
                            arrayList9 = arrayList18;
                            arrayList10 = arrayList17;
                            arrayList11 = arrayList16;
                            arrayList12 = arrayList15;
                            arrayList13 = arrayList14;
                            str6 = str9;
                            str7 = str8;
                            i2 = i4;
                            arrayList7 = arrayList20;
                            xmlPullParser3 = xmlPullParser;
                            if (XmlPullParserUtil.isStartTag(xmlPullParser3, "SegmentBase")) {
                                dashManifestParser2 = this;
                                parseSegmentTemplate = dashManifestParser2.parseSegmentBase(xmlPullParser3, (SegmentBase.SingleSegmentBase) segmentBase2);
                            } else {
                                dashManifestParser2 = this;
                                if (XmlPullParserUtil.isStartTag(xmlPullParser3, "SegmentList")) {
                                    parseSegmentTemplate = dashManifestParser2.parseSegmentList(xmlPullParser3, (SegmentBase.SegmentList) segmentBase2, j);
                                } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "SegmentTemplate")) {
                                    parseSegmentTemplate = parseSegmentTemplate(xmlPullParser, (SegmentBase.SegmentTemplate) segmentBase2, arrayList8, j);
                                } else {
                                    if (XmlPullParserUtil.isStartTag(xmlPullParser3, "InbandEventStream")) {
                                        arrayList6 = arrayList12;
                                        arrayList6.add(parseDescriptor(xmlPullParser3, "InbandEventStream"));
                                    } else {
                                        arrayList6 = arrayList12;
                                        if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Label")) {
                                            str11 = parseLabel(xmlPullParser);
                                        } else if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                                            parseAdaptationSetChild(xmlPullParser);
                                        }
                                    }
                                    str13 = str5;
                                    str10 = str4;
                                    if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                                    }
                                }
                            }
                            segmentBase2 = parseSegmentTemplate;
                        }
                        str13 = str5;
                        str10 = str4;
                        arrayList6 = arrayList12;
                        if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                        }
                    }
                    str5 = str13;
                    str4 = str10;
                    arrayList8 = arrayList19;
                    arrayList9 = arrayList18;
                    arrayList10 = arrayList17;
                    arrayList11 = arrayList16;
                    arrayList13 = arrayList14;
                    str6 = str9;
                    str7 = str8;
                    xmlPullParser3 = xmlPullParser4;
                    dashManifestParser2 = dashManifestParser3;
                    i2 = i4;
                    arrayList7 = arrayList20;
                    arrayList6 = arrayList15;
                    str13 = str5;
                    str10 = str4;
                    if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                    }
                }
                arrayList5 = arrayList19;
                arrayList4 = arrayList18;
                arrayList3 = arrayList17;
                arrayList2 = arrayList16;
                arrayList = arrayList14;
                str3 = str9;
                str2 = str8;
                xmlPullParser2 = xmlPullParser4;
                dashManifestParser = dashManifestParser3;
            }
            i = i4;
            arrayList7 = arrayList20;
            arrayList6 = arrayList15;
            if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
            }
        }
        ArrayList arrayList21 = new ArrayList(arrayList7.size());
        for (int i5 = 0; i5 < arrayList7.size(); i5++) {
            arrayList21.add(buildRepresentation((RepresentationInfo) arrayList7.get(i5), str11, str12, arrayList, arrayList6));
        }
        return buildAdaptationSet(parseInt, i, arrayList21, arrayList2, arrayList4, arrayList5);
    }

    /* access modifiers changed from: protected */
    public AdaptationSet buildAdaptationSet(int i, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        return new AdaptationSet(i, i2, list, list2, list3, list4);
    }

    /* access modifiers changed from: protected */
    public int parseContentType(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010b  */
    public Pair<String, DrmInitData.SchemeData> parseContentProtection(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String str;
        byte[] bArr;
        byte[] bArr2;
        UUID uuid;
        DrmInitData.SchemeData schemeData = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue != null) {
            String lowerInvariant = Util.toLowerInvariant(attributeValue);
            char c = 65535;
            int hashCode = lowerInvariant.hashCode();
            if (hashCode != 489446379) {
                if (hashCode != 755418770) {
                    if (hashCode == 1812765994 && lowerInvariant.equals("urn:mpeg:dash:mp4protection:2011")) {
                        c = 0;
                    }
                } else if (lowerInvariant.equals("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed")) {
                    c = 2;
                }
            } else if (lowerInvariant.equals("urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95")) {
                c = 1;
            }
            if (c != 0) {
                if (c == 1) {
                    uuid = C.PLAYREADY_UUID;
                } else if (c == 2) {
                    uuid = C.WIDEVINE_UUID;
                }
                bArr2 = null;
                bArr = bArr2;
                str = bArr;
                do {
                    xmlPullParser.next();
                    if (!XmlPullParserUtil.isStartTag(xmlPullParser, "ms:laurl")) {
                        str = xmlPullParser.getAttributeValue(null, "licenseUrl");
                    } else if (bArr2 == null && XmlPullParserUtil.isStartTagIgnorePrefix(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                        byte[] decode = Base64.decode(xmlPullParser.getText(), 0);
                        UUID parseUuid = PsshAtomUtil.parseUuid(decode);
                        if (parseUuid == null) {
                            Log.w("MpdParser", "Skipping malformed cenc:pssh data");
                            uuid = parseUuid;
                            bArr2 = null;
                        } else {
                            UUID uuid2 = parseUuid;
                            bArr2 = decode;
                            uuid = uuid2;
                        }
                    } else if (bArr2 != null || !C.PLAYREADY_UUID.equals(uuid) || !XmlPullParserUtil.isStartTag(xmlPullParser, "mspr:pro") || xmlPullParser.next() != 4) {
                        maybeSkipTag(xmlPullParser);
                    } else {
                        bArr2 = PsshAtomUtil.buildPsshAtom(C.PLAYREADY_UUID, Base64.decode(xmlPullParser.getText(), 0));
                    }
                } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
                if (uuid != null) {
                    schemeData = new DrmInitData.SchemeData(uuid, str, "video/mp4", bArr2);
                }
                return Pair.create(bArr, schemeData);
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
            String attributeValueIgnorePrefix = XmlPullParserUtil.getAttributeValueIgnorePrefix(xmlPullParser, "default_KID");
            if (TextUtils.isEmpty(attributeValueIgnorePrefix) || "00000000-0000-0000-0000-000000000000".equals(attributeValueIgnorePrefix)) {
                bArr2 = null;
                str = null;
                bArr = attributeValue2;
                uuid = null;
                do {
                    xmlPullParser.next();
                    if (!XmlPullParserUtil.isStartTag(xmlPullParser, "ms:laurl")) {
                    }
                } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
                if (uuid != null) {
                }
                return Pair.create(bArr, schemeData);
            }
            String[] split = attributeValueIgnorePrefix.split("\\s+");
            UUID[] uuidArr = new UUID[split.length];
            for (int i = 0; i < split.length; i++) {
                uuidArr[i] = UUID.fromString(split[i]);
            }
            bArr2 = PsshAtomUtil.buildPsshAtom(C.COMMON_PSSH_UUID, uuidArr, null);
            str = null;
            bArr = attributeValue2;
            uuid = C.COMMON_PSSH_UUID;
            do {
                xmlPullParser.next();
                if (!XmlPullParserUtil.isStartTag(xmlPullParser, "ms:laurl")) {
                }
            } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
            if (uuid != null) {
            }
            return Pair.create(bArr, schemeData);
        }
        uuid = null;
        bArr2 = null;
        bArr = bArr2;
        str = bArr;
        do {
            xmlPullParser.next();
            if (!XmlPullParserUtil.isStartTag(xmlPullParser, "ms:laurl")) {
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
        if (uuid != null) {
        }
        return Pair.create(bArr, schemeData);
    }

    /* access modifiers changed from: protected */
    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        maybeSkipTag(xmlPullParser);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01a6 A[LOOP:0: B:1:0x0062->B:48:0x01a6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0162 A[EDGE_INSN: B:49:0x0162->B:42:0x0162 ?: BREAK  , SYNTHETIC] */
    public RepresentationInfo parseRepresentation(XmlPullParser xmlPullParser, String str, String str2, String str3, int i, int i2, float f, int i3, int i4, String str4, List<Descriptor> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, SegmentBase segmentBase, long j) throws XmlPullParserException, IOException {
        int i5;
        int i6;
        SegmentBase segmentBase2;
        String str5;
        int i7;
        String str6;
        int i8;
        int i9;
        SegmentBase parseSegmentTemplate;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        int parseInt = parseInt(xmlPullParser2, "bandwidth", -1);
        String parseString = parseString(xmlPullParser2, "mimeType", str2);
        String parseString2 = parseString(xmlPullParser2, "codecs", str3);
        int parseInt2 = parseInt(xmlPullParser2, "width", i);
        int parseInt3 = parseInt(xmlPullParser2, "height", i2);
        float parseFrameRate = parseFrameRate(xmlPullParser2, f);
        int parseInt4 = parseInt(xmlPullParser2, "audioSamplingRate", i4);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list3);
        ArrayList arrayList4 = new ArrayList(list4);
        boolean z = false;
        int i10 = i3;
        SegmentBase segmentBase3 = segmentBase;
        String str7 = null;
        String str8 = str;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "BaseURL")) {
                if (!z) {
                    str8 = parseBaseUrl(xmlPullParser2, str8);
                    i5 = parseInt4;
                    i6 = parseInt;
                    i7 = i10;
                    z = true;
                    segmentBase2 = segmentBase3;
                } else {
                    str6 = str8;
                    i8 = parseInt4;
                    i9 = parseInt;
                    i7 = i10;
                    segmentBase2 = segmentBase3;
                    str5 = str6;
                    if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "Representation")) {
                        break;
                    }
                    parseInt4 = i5;
                    str8 = str5;
                    segmentBase3 = segmentBase2;
                    parseInt = i6;
                    i10 = i7;
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "AudioChannelConfiguration")) {
                i7 = parseAudioChannelConfiguration(xmlPullParser);
                i5 = parseInt4;
                i6 = parseInt;
                segmentBase2 = segmentBase3;
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentBase")) {
                    parseSegmentTemplate = parseSegmentBase(xmlPullParser2, (SegmentBase.SingleSegmentBase) segmentBase3);
                    str5 = str8;
                    i8 = parseInt4;
                    i9 = parseInt;
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentList")) {
                        i8 = parseInt4;
                        i9 = parseInt;
                        parseSegmentTemplate = parseSegmentList(xmlPullParser2, (SegmentBase.SegmentList) segmentBase3, j);
                    } else {
                        i8 = parseInt4;
                        i9 = parseInt;
                        if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                            parseSegmentTemplate = parseSegmentTemplate(xmlPullParser, (SegmentBase.SegmentTemplate) segmentBase3, list4, j);
                        } else {
                            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "ContentProtection")) {
                                Pair<String, DrmInitData.SchemeData> parseContentProtection = parseContentProtection(xmlPullParser);
                                str6 = str8;
                                if (parseContentProtection.first != null) {
                                    str7 = parseContentProtection.first;
                                }
                                if (parseContentProtection.second != null) {
                                    arrayList.add(parseContentProtection.second);
                                }
                            } else {
                                str6 = str8;
                                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "InbandEventStream")) {
                                    arrayList2.add(parseDescriptor(xmlPullParser2, "InbandEventStream"));
                                } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "EssentialProperty")) {
                                    arrayList3.add(parseDescriptor(xmlPullParser2, "EssentialProperty"));
                                } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SupplementalProperty")) {
                                    arrayList4.add(parseDescriptor(xmlPullParser2, "SupplementalProperty"));
                                } else {
                                    maybeSkipTag(xmlPullParser);
                                }
                            }
                            i7 = i10;
                            segmentBase2 = segmentBase3;
                            str5 = str6;
                            if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "Representation")) {
                            }
                        }
                    }
                    str5 = str8;
                }
                int i11 = i10;
                segmentBase2 = parseSegmentTemplate;
                i7 = i11;
                if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "Representation")) {
                }
            }
            str5 = str8;
            if (!XmlPullParserUtil.isEndTag(xmlPullParser2, "Representation")) {
            }
        }
        return new RepresentationInfo(buildFormat(attributeValue, parseString, parseInt2, parseInt3, parseFrameRate, i7, i5, i6, str4, list, list2, parseString2, arrayList3, arrayList4), str5, segmentBase2 != null ? segmentBase2 : new SegmentBase.SingleSegmentBase(), str7, arrayList, arrayList2, -1);
    }

    /* access modifiers changed from: protected */
    public Format buildFormat(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3, List<Descriptor> list, List<Descriptor> list2, String str4, List<Descriptor> list3, List<Descriptor> list4) {
        List<Descriptor> list5 = list;
        String str5 = str4;
        String sampleMimeType = getSampleMimeType(str2, str5);
        if ("audio/eac3".equals(sampleMimeType)) {
            sampleMimeType = parseEac3SupplementalProperties(list4);
        }
        int parseSelectionFlagsFromRoleDescriptors = parseSelectionFlagsFromRoleDescriptors(list5);
        Format.Builder language = new Format.Builder().setId(str).setContainerMimeType(str2).setSampleMimeType(sampleMimeType).setCodecs(str5).setPeakBitrate(i5).setSelectionFlags(parseSelectionFlagsFromRoleDescriptors).setRoleFlags(parseRoleFlagsFromRoleDescriptors(list5) | parseRoleFlagsFromAccessibilityDescriptors(list2) | parseRoleFlagsFromProperties(list3) | parseRoleFlagsFromProperties(list4)).setLanguage(str3);
        if (MimeTypes.isVideo(sampleMimeType)) {
            language.setWidth(i).setHeight(i2).setFrameRate(f);
        } else if (MimeTypes.isAudio(sampleMimeType)) {
            language.setChannelCount(i3).setSampleRate(i4);
        } else if (MimeTypes.isText(sampleMimeType)) {
            int i6 = -1;
            if ("application/cea-608".equals(sampleMimeType)) {
                i6 = parseCea608AccessibilityChannel(list2);
            } else if ("application/cea-708".equals(sampleMimeType)) {
                i6 = parseCea708AccessibilityChannel(list2);
            }
            language.setAccessibilityChannel(i6);
        }
        return language.build();
    }

    /* access modifiers changed from: protected */
    public Representation buildRepresentation(RepresentationInfo representationInfo, String str, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        Format.Builder buildUpon = representationInfo.format.buildUpon();
        if (str != null) {
            buildUpon.setLabel(str);
        }
        String str3 = representationInfo.drmSchemeType;
        if (str3 == null) {
            str3 = str2;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = representationInfo.drmSchemeDatas;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            filterRedundantIncompleteSchemeDatas(arrayList3);
            buildUpon.setDrmInitData(new DrmInitData(str3, arrayList3));
        }
        ArrayList<Descriptor> arrayList4 = representationInfo.inbandEventStreams;
        arrayList4.addAll(arrayList2);
        return Representation.newInstance(representationInfo.revisionId, buildUpon.build(), representationInfo.baseUrl, representationInfo.segmentBase, arrayList4);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long j;
        long j2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SingleSegmentBase singleSegmentBase2 = singleSegmentBase;
        long parseLong = parseLong(xmlPullParser2, "timescale", singleSegmentBase2 != null ? singleSegmentBase2.timescale : 1);
        long j3 = 0;
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", singleSegmentBase2 != null ? singleSegmentBase2.presentationTimeOffset : 0);
        long j4 = singleSegmentBase2 != null ? singleSegmentBase2.indexStart : 0;
        if (singleSegmentBase2 != null) {
            j3 = singleSegmentBase2.indexLength;
        }
        RangedUri rangedUri = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            long parseLong3 = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - parseLong3) + 1;
            j2 = parseLong3;
        } else {
            j = j3;
            j2 = j4;
        }
        if (singleSegmentBase2 != null) {
            rangedUri = singleSegmentBase2.initialization;
        }
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentBase"));
        return buildSingleSegmentBase(rangedUri, parseLong, parseLong2, j2, j);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j, j2, j3, j4);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlPullParser, SegmentBase.SegmentList segmentList, long j) throws XmlPullParserException, IOException {
        RangedUri rangedUri;
        List list;
        RangedUri rangedUri2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentList segmentList2 = segmentList;
        long j2 = 1;
        long parseLong = parseLong(xmlPullParser2, "timescale", segmentList2 != null ? segmentList2.timescale : 1);
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", segmentList2 != null ? segmentList2.presentationTimeOffset : 0);
        long parseLong3 = parseLong(xmlPullParser2, "duration", segmentList2 != null ? segmentList2.duration : -9223372036854775807L);
        if (segmentList2 != null) {
            j2 = segmentList2.startNumber;
        }
        long parseLong4 = parseLong(xmlPullParser2, "startNumber", j2);
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        List list3 = null;
        RangedUri rangedUri3 = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri3 = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTimeline")) {
                list2 = parseSegmentTimeline(xmlPullParser, parseLong, j);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentURL")) {
                if (list3 == null) {
                    list3 = new ArrayList();
                }
                list3.add(parseSegmentUrl(xmlPullParser));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentList"));
        if (segmentList2 != null) {
            if (rangedUri3 != null) {
                rangedUri2 = rangedUri3;
            } else {
                rangedUri2 = segmentList2.initialization;
            }
            if (list2 == null) {
                list2 = segmentList2.segmentTimeline;
            }
            if (list3 == null) {
                list3 = segmentList2.mediaSegments;
            }
            rangedUri = rangedUri2;
            list = list3;
        } else {
            list = list3;
            rangedUri = rangedUri3;
        }
        return buildSegmentList(rangedUri, parseLong, parseLong2, parseLong4, parseLong3, list2, list);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentList buildSegmentList(RangedUri rangedUri, long j, long j2, long j3, long j4, List<SegmentBase.SegmentTimelineElement> list, List<RangedUri> list2) {
        return new SegmentBase.SegmentList(rangedUri, j, j2, j3, j4, list, list2);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, SegmentBase.SegmentTemplate segmentTemplate, List<Descriptor> list, long j) throws XmlPullParserException, IOException {
        RangedUri rangedUri;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentTemplate segmentTemplate2 = segmentTemplate;
        long j2 = 1;
        long parseLong = parseLong(xmlPullParser2, "timescale", segmentTemplate2 != null ? segmentTemplate2.timescale : 1);
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", segmentTemplate2 != null ? segmentTemplate2.presentationTimeOffset : 0);
        long parseLong3 = parseLong(xmlPullParser2, "duration", segmentTemplate2 != null ? segmentTemplate2.duration : -9223372036854775807L);
        if (segmentTemplate2 != null) {
            j2 = segmentTemplate2.startNumber;
        }
        long parseLong4 = parseLong(xmlPullParser2, "startNumber", j2);
        long parseLastSegmentNumberSupplementalProperty = parseLastSegmentNumberSupplementalProperty(list);
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        UrlTemplate parseUrlTemplate = parseUrlTemplate(xmlPullParser2, "media", segmentTemplate2 != null ? segmentTemplate2.mediaTemplate : null);
        UrlTemplate parseUrlTemplate2 = parseUrlTemplate(xmlPullParser2, "initialization", segmentTemplate2 != null ? segmentTemplate2.initializationTemplate : null);
        RangedUri rangedUri2 = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri2 = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTimeline")) {
                list2 = parseSegmentTimeline(xmlPullParser, parseLong, j);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentTemplate"));
        if (segmentTemplate2 != null) {
            if (rangedUri2 != null) {
                rangedUri = rangedUri2;
            } else {
                rangedUri = segmentTemplate2.initialization;
            }
            if (list2 == null) {
                list2 = segmentTemplate2.segmentTimeline;
            }
        } else {
            rangedUri = rangedUri2;
        }
        return buildSegmentTemplate(rangedUri, parseLong, parseLong2, parseLong4, parseLastSegmentNumberSupplementalProperty, parseLong3, list2, parseUrlTemplate2, parseUrlTemplate);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long j, long j2, long j3, long j4, long j5, List<SegmentBase.SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
        return new SegmentBase.SegmentTemplate(rangedUri, j, j2, j3, j4, j5, list, urlTemplate, urlTemplate2);
    }

    /* access modifiers changed from: protected */
    public EventStream parseEventStream(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", "");
        long parseLong = parseLong(xmlPullParser, "timescale", 1);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Event")) {
                arrayList.add(parseEvent(xmlPullParser, parseString, parseString2, parseLong, byteArrayOutputStream));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            jArr[i] = ((Long) pair.first).longValue();
            eventMessageArr[i] = (EventMessage) pair.second;
        }
        return buildEventStream(parseString, parseString2, parseLong, jArr, eventMessageArr);
    }

    /* access modifiers changed from: protected */
    public EventStream buildEventStream(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        return new EventStream(str, str2, j, jArr, eventMessageArr);
    }

    /* access modifiers changed from: protected */
    public Pair<Long, EventMessage> parseEvent(XmlPullParser xmlPullParser, String str, String str2, long j, ByteArrayOutputStream byteArrayOutputStream) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long parseLong = parseLong(xmlPullParser2, "id", 0);
        long parseLong2 = parseLong(xmlPullParser2, "duration", -9223372036854775807L);
        long parseLong3 = parseLong(xmlPullParser2, "presentationTime", 0);
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(parseLong2, 1000, j);
        long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(parseLong3, 1000000, j);
        String parseString = parseString(xmlPullParser2, "messageData", null);
        byte[] parseEventObject = parseEventObject(xmlPullParser2, byteArrayOutputStream);
        Long valueOf = Long.valueOf(scaleLargeTimestamp2);
        if (parseString != null) {
            parseEventObject = Util.getUtf8Bytes(parseString);
        }
        return Pair.create(valueOf, buildEvent(str, str2, parseLong, scaleLargeTimestamp, parseEventObject));
    }

    /* access modifiers changed from: protected */
    public byte[] parseEventObject(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, "UTF-8");
        xmlPullParser.nextToken();
        while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: protected */
    public EventMessage buildEvent(String str, String str2, long j, long j2, byte[] bArr) {
        return new EventMessage(str, str2, j2, j, bArr);
    }

    /* access modifiers changed from: protected */
    public List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xmlPullParser, long j, long j2) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        long j4 = -9223372036854775807L;
        boolean z = false;
        int i = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "S")) {
                long parseLong = parseLong(xmlPullParser2, "t", -9223372036854775807L);
                if (z) {
                    j3 = addSegmentTimelineElementsToList(arrayList, j3, j4, i, parseLong);
                }
                if (parseLong == -9223372036854775807L) {
                    parseLong = j3;
                }
                j4 = parseLong(xmlPullParser2, "d", -9223372036854775807L);
                i = parseInt(xmlPullParser2, "r", 0);
                j3 = parseLong;
                z = true;
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentTimeline"));
        if (z) {
            addSegmentTimelineElementsToList(arrayList, j3, j4, i, Util.scaleLargeTimestamp(j2, j, 1000));
        }
        return arrayList;
    }

    private long addSegmentTimelineElementsToList(List<SegmentBase.SegmentTimelineElement> list, long j, long j2, int i, long j3) {
        int ceilDivide = i >= 0 ? i + 1 : (int) Util.ceilDivide(j3 - j, j2);
        for (int i2 = 0; i2 < ceilDivide; i2++) {
            list.add(buildSegmentTimelineElement(j, j2));
            j += j2;
        }
        return j;
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j, long j2) {
        return new SegmentBase.SegmentTimelineElement(j, j2);
    }

    /* access modifiers changed from: protected */
    public UrlTemplate parseUrlTemplate(XmlPullParser xmlPullParser, String str, UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? UrlTemplate.compile(attributeValue) : urlTemplate;
    }

    /* access modifiers changed from: protected */
    public RangedUri parseInitialization(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    /* access modifiers changed from: protected */
    public RangedUri parseSegmentUrl(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "media", "mediaRange");
    }

    /* access modifiers changed from: protected */
    public RangedUri parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j2 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j = (Long.parseLong(split[1]) - j2) + 1;
                return buildRangedUri(attributeValue, j2, j);
            }
        } else {
            j2 = 0;
        }
        j = -1;
        return buildRangedUri(attributeValue, j2, j);
    }

    /* access modifiers changed from: protected */
    public RangedUri buildRangedUri(String str, long j, long j2) {
        return new RangedUri(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public ProgramInformation parseProgramInformation(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = null;
        String parseString = parseString(xmlPullParser, "moreInformationURL", null);
        String parseString2 = parseString(xmlPullParser, "lang", null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
            String str4 = str3;
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "ProgramInformation")) {
                return new ProgramInformation(str, str2, str4, parseString, parseString2);
            }
            str3 = str4;
        }
    }

    /* access modifiers changed from: protected */
    public String parseLabel(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return parseText(xmlPullParser, "Label");
    }

    /* access modifiers changed from: protected */
    public String parseBaseUrl(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        return UriUtil.resolve(str, parseText(xmlPullParser, "BaseURL"));
    }

    /* access modifiers changed from: protected */
    public int parseAudioChannelConfiguration(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", null);
        int i = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(parseString)) {
            i = parseInt(xmlPullParser, "value", -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(parseString) || "urn:dolby:dash:audio_channel_configuration:2011".equals(parseString)) {
            i = parseDolbyChannelConfiguration(xmlPullParser);
        }
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    /* access modifiers changed from: protected */
    public int parseSelectionFlagsFromRoleDescriptors(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri) && "main".equals(descriptor.value)) {
                return 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int parseRoleFlagsFromRoleDescriptors(List<Descriptor> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri)) {
                i |= parseDashRoleSchemeValue(descriptor.value);
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int parseRoleFlagsFromAccessibilityDescriptors(List<Descriptor> list) {
        int parseTvaAudioPurposeCsValue;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseDashRoleSchemeValue(descriptor.value);
            } else if ("urn:tva:metadata:cs:AudioPurposeCS:2007".equalsIgnoreCase(descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseTvaAudioPurposeCsValue(descriptor.value);
            }
            i |= parseTvaAudioPurposeCsValue;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int parseRoleFlagsFromProperties(List<Descriptor> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if ("http://dashif.org/guidelines/trickmode".equalsIgnoreCase(list.get(i2).schemeIdUri)) {
                i |= 16384;
            }
        }
        return i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public int parseDashRoleSchemeValue(String str) {
        char c;
        if (str == null) {
            return 0;
        }
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 99825:
                if (str.equals("dub")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3343801:
                if (str.equals("main")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3530173:
                if (str.equals("sign")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case 552573414:
                if (str.equals("caption")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    c = 2;
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
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return NotificationCompat.FLAG_HIGH_PRIORITY;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return 256;
            case 9:
                return 512;
            case 10:
                return 2048;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public int parseTvaAudioPurposeCsValue(String str) {
        if (str == null) {
            return 0;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c = 4;
                    break;
                }
                break;
        }
        if (c == 0) {
            return 512;
        }
        if (c == 1) {
            return 2048;
        }
        if (c == 2) {
            return 4;
        }
        if (c != 3) {
            return c != 4 ? 0 : 1;
        }
        return 8;
    }

    public static void maybeSkipTag(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                    i++;
                } else if (XmlPullParserUtil.isEndTag(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    private static void filterRedundantIncompleteSchemeDatas(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        break;
                    } else if (arrayList.get(i).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    private static String getSampleMimeType(String str, String str2) {
        if (MimeTypes.isAudio(str)) {
            return MimeTypes.getAudioMediaMimeType(str2);
        }
        if (MimeTypes.isVideo(str)) {
            return MimeTypes.getVideoMediaMimeType(str2);
        }
        if (MimeTypes.isText(str)) {
            return "application/x-rawcc".equals(str) ? MimeTypes.getTextMediaMimeType(str2) : str;
        }
        if ("application/mp4".equals(str)) {
            return MimeTypes.getMediaMimeType(str2);
        }
        return null;
    }

    private static String checkLanguageConsistency(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        Assertions.checkState(str.equals(str2));
        return str;
    }

    private static int checkContentTypeConsistency(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        Assertions.checkState(i == i2);
        return i;
    }

    protected static Descriptor parseDescriptor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", null);
        String parseString3 = parseString(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return new Descriptor(parseString, parseString2, parseString3);
    }

    protected static int parseCea608AccessibilityChannel(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && descriptor.value != null) {
                Matcher matcher = CEA_608_ACCESSIBILITY_PATTERN.matcher(descriptor.value);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w("MpdParser", "Unable to parse CEA-608 channel number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static int parseCea708AccessibilityChannel(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && descriptor.value != null) {
                Matcher matcher = CEA_708_ACCESSIBILITY_PATTERN.matcher(descriptor.value);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w("MpdParser", "Unable to parse CEA-708 service block number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static String parseEac3SupplementalProperties(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            String str = descriptor.schemeIdUri;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(descriptor.value)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(descriptor.value)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    protected static float parseFrameRate(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        return !TextUtils.isEmpty(group) ? ((float) parseInt) / ((float) Integer.parseInt(group)) : (float) parseInt;
    }

    protected static long parseDuration(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j;
        }
        return Util.parseXsDuration(attributeValue);
    }

    protected static long parseDateTime(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j;
        }
        return Util.parseXsDateTime(attributeValue);
    }

    protected static String parseText(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return str2;
    }

    protected static int parseInt(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return i;
        }
        return Integer.parseInt(attributeValue);
    }

    protected static long parseLong(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j;
        }
        return Long.parseLong(attributeValue);
    }

    protected static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    protected static int parseDolbyChannelConfiguration(XmlPullParser xmlPullParser) {
        char c;
        String lowerInvariant = Util.toLowerInvariant(xmlPullParser.getAttributeValue(null, "value"));
        if (lowerInvariant == null) {
            return -1;
        }
        switch (lowerInvariant.hashCode()) {
            case 1596796:
                if (lowerInvariant.equals("4000")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2937391:
                if (lowerInvariant.equals("a000")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3094035:
                if (lowerInvariant.equals("f801")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3133436:
                if (lowerInvariant.equals("fa01")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 1;
        }
        if (c == 1) {
            return 2;
        }
        if (c == 2) {
            return 6;
        }
        if (c != 3) {
            return -1;
        }
        return 8;
    }

    protected static long parseLastSegmentNumberSupplementalProperty(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("http://dashif.org/guidelines/last-segment-number".equalsIgnoreCase(descriptor.schemeIdUri)) {
                return Long.parseLong(descriptor.value);
            }
        }
        return -1;
    }

    public static final class RepresentationInfo {
        public final String baseUrl;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        public final String drmSchemeType;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final long revisionId;
        public final SegmentBase segmentBase;

        public RepresentationInfo(Format format2, String str, SegmentBase segmentBase2, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2, long j) {
            this.format = format2;
            this.baseUrl = str;
            this.segmentBase = segmentBase2;
            this.drmSchemeType = str2;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
            this.revisionId = j;
        }
    }
}
