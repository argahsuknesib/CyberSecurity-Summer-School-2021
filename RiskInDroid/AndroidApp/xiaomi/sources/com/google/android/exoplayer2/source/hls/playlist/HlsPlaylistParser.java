package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern REGEX_CHANNELS = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern REGEX_CHARACTERISTICS = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern REGEX_CLOSED_CAPTIONS = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
    private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");
    private static final Pattern REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern REGEX_IMPORT = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern REGEX_KEYFORMATVERSIONS = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_TITLE = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern REGEX_SUBTITLES = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern REGEX_VALUE = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern REGEX_VARIABLE_REFERENCE = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    private static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern REGEX_VIDEO = Pattern.compile("VIDEO=\"(.+?)\"");
    private final HlsMasterPlaylist masterPlaylist;

    public HlsPlaylistParser() {
        this(HlsMasterPlaylist.EMPTY);
    }

    public HlsPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist) {
        this.masterPlaylist = hlsMasterPlaylist;
    }

    public final HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (checkPlaylistHeader(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                                if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                    break;
                                } else if (trim.equals("#EXT-X-ENDLIST")) {
                                    break;
                                } else {
                                    arrayDeque.add(trim);
                                }
                            } else {
                                arrayDeque.add(trim);
                                HlsMasterPlaylist parseMasterPlaylist = parseMasterPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                                Util.closeQuietly(bufferedReader);
                                return parseMasterPlaylist;
                            }
                        }
                    } else {
                        Util.closeQuietly(bufferedReader);
                        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                arrayDeque.add(trim);
                return parseMediaPlaylist(this.masterPlaylist, new LineIterator(arrayDeque, bufferedReader), uri.toString());
            }
            throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
        } finally {
            Util.closeQuietly(bufferedReader);
        }
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int skipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, read);
        for (int i = 0; i < 7; i++) {
            if (skipIgnorableWhitespace != "#EXTM3U".charAt(i)) {
                return false;
            }
            skipIgnorableWhitespace = bufferedReader.read();
        }
        return Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, skipIgnorableWhitespace));
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean z, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z || !Util.isLinebreak(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static HlsMasterPlaylist parseMasterPlaylist(LineIterator lineIterator, String str) throws IOException {
        Uri uri;
        Uri uri2;
        char c;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        List list;
        List list2;
        String str2;
        String str3;
        String str4;
        int i;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        HashMap hashMap;
        int i2;
        int i3;
        float f;
        Uri uri3;
        int i4;
        String str5 = str;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        boolean z = false;
        boolean z2 = false;
        while (true) {
            String str6 = "application/x-mpegURL";
            if (lineIterator.hasNext()) {
                String next = lineIterator.next();
                if (next.startsWith("#EXT")) {
                    arrayList18.add(next);
                }
                boolean startsWith = next.startsWith("#EXT-X-I-FRAME-STREAM-INF");
                boolean z3 = z2;
                if (next.startsWith("#EXT-X-DEFINE")) {
                    hashMap3.put(parseStringAttr(next, REGEX_NAME, hashMap3), parseStringAttr(next, REGEX_VALUE, hashMap3));
                } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    z2 = true;
                } else if (next.startsWith("#EXT-X-MEDIA")) {
                    arrayList16.add(next);
                } else if (next.startsWith("#EXT-X-SESSION-KEY")) {
                    DrmInitData.SchemeData parseDrmSchemeData = parseDrmSchemeData(next, parseOptionalStringAttr(next, REGEX_KEYFORMAT, "identity", hashMap3), hashMap3);
                    if (parseDrmSchemeData != null) {
                        arrayList4 = arrayList15;
                        arrayList17.add(new DrmInitData(parseEncryptionScheme(parseStringAttr(next, REGEX_METHOD, hashMap3)), parseDrmSchemeData));
                        z2 = z3;
                        arrayList15 = arrayList4;
                    }
                } else {
                    ArrayList arrayList19 = arrayList15;
                    if (next.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                        boolean contains = next.contains("CLOSED-CAPTIONS=NONE") | z;
                        int i5 = startsWith ? 16384 : 0;
                        int parseIntAttr = parseIntAttr(next, REGEX_BANDWIDTH);
                        boolean z4 = contains;
                        arrayList10 = arrayList17;
                        int parseOptionalIntAttr = parseOptionalIntAttr(next, REGEX_AVERAGE_BANDWIDTH, -1);
                        String parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_CODECS, hashMap3);
                        arrayList9 = arrayList18;
                        String parseOptionalStringAttr2 = parseOptionalStringAttr(next, REGEX_RESOLUTION, hashMap3);
                        if (parseOptionalStringAttr2 != null) {
                            arrayList8 = arrayList12;
                            String[] split = parseOptionalStringAttr2.split("x");
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            if (parseInt <= 0 || parseInt2 <= 0) {
                                parseInt2 = -1;
                                i4 = -1;
                            } else {
                                i4 = parseInt;
                            }
                            i2 = parseInt2;
                            i3 = i4;
                        } else {
                            arrayList8 = arrayList12;
                            i3 = -1;
                            i2 = -1;
                        }
                        arrayList7 = arrayList13;
                        String parseOptionalStringAttr3 = parseOptionalStringAttr(next, REGEX_FRAME_RATE, hashMap3);
                        if (parseOptionalStringAttr3 != null) {
                            arrayList6 = arrayList14;
                            f = Float.parseFloat(parseOptionalStringAttr3);
                        } else {
                            arrayList6 = arrayList14;
                            f = -1.0f;
                        }
                        String parseOptionalStringAttr4 = parseOptionalStringAttr(next, REGEX_VIDEO, hashMap3);
                        arrayList5 = arrayList16;
                        String parseOptionalStringAttr5 = parseOptionalStringAttr(next, REGEX_AUDIO, hashMap3);
                        HashMap hashMap4 = hashMap2;
                        String parseOptionalStringAttr6 = parseOptionalStringAttr(next, REGEX_SUBTITLES, hashMap3);
                        String parseOptionalStringAttr7 = parseOptionalStringAttr(next, REGEX_CLOSED_CAPTIONS, hashMap3);
                        if (startsWith) {
                            uri3 = UriUtil.resolveToUri(str5, parseStringAttr(next, REGEX_URI, hashMap3));
                        } else if (lineIterator.hasNext()) {
                            uri3 = UriUtil.resolveToUri(str5, replaceVariableReferences(lineIterator.next(), hashMap3));
                        } else {
                            throw new ParserException("#EXT-X-STREAM-INF must be followed by another line");
                        }
                        arrayList11.add(new HlsMasterPlaylist.Variant(uri3, new Format.Builder().setId(arrayList11.size()).setContainerMimeType(str6).setCodecs(parseOptionalStringAttr).setAverageBitrate(parseOptionalIntAttr).setPeakBitrate(parseIntAttr).setWidth(i3).setHeight(i2).setFrameRate(f).setRoleFlags(i5).build(), parseOptionalStringAttr4, parseOptionalStringAttr5, parseOptionalStringAttr6, parseOptionalStringAttr7));
                        hashMap = hashMap4;
                        ArrayList arrayList20 = (ArrayList) hashMap.get(uri3);
                        if (arrayList20 == null) {
                            arrayList20 = new ArrayList();
                            hashMap.put(uri3, arrayList20);
                        }
                        arrayList20.add(new HlsTrackMetadataEntry.VariantInfo(parseOptionalIntAttr, parseIntAttr, parseOptionalStringAttr4, parseOptionalStringAttr5, parseOptionalStringAttr6, parseOptionalStringAttr7));
                        z = z4;
                    } else {
                        hashMap = hashMap2;
                        arrayList5 = arrayList16;
                        arrayList8 = arrayList12;
                        arrayList7 = arrayList13;
                        arrayList6 = arrayList14;
                        arrayList9 = arrayList18;
                        arrayList10 = arrayList17;
                    }
                    hashMap2 = hashMap;
                    z2 = z3;
                    arrayList15 = arrayList19;
                    arrayList17 = arrayList10;
                    arrayList18 = arrayList9;
                    arrayList12 = arrayList8;
                    arrayList13 = arrayList7;
                    arrayList14 = arrayList6;
                    arrayList16 = arrayList5;
                    str5 = str;
                }
                arrayList4 = arrayList15;
                z2 = z3;
                arrayList15 = arrayList4;
            } else {
                HashMap hashMap5 = hashMap2;
                ArrayList arrayList21 = arrayList16;
                ArrayList arrayList22 = arrayList12;
                ArrayList arrayList23 = arrayList13;
                ArrayList arrayList24 = arrayList14;
                ArrayList arrayList25 = arrayList15;
                ArrayList arrayList26 = arrayList18;
                ArrayList arrayList27 = arrayList17;
                boolean z5 = z2;
                ArrayList arrayList28 = new ArrayList();
                HashSet hashSet = new HashSet();
                int i6 = 0;
                while (true) {
                    uri = null;
                    if (i6 >= arrayList11.size()) {
                        break;
                    }
                    HlsMasterPlaylist.Variant variant = (HlsMasterPlaylist.Variant) arrayList11.get(i6);
                    if (hashSet.add(variant.url)) {
                        Assertions.checkState(variant.format.metadata == null);
                        arrayList28.add(variant.copyWithFormat(variant.format.buildUpon().setMetadata(new Metadata(new HlsTrackMetadataEntry(null, null, (List) Assertions.checkNotNull(hashMap5.get(variant.url))))).build()));
                    }
                    i6++;
                }
                List list3 = null;
                Format format = null;
                int i7 = 0;
                while (i7 < arrayList21.size()) {
                    ArrayList arrayList29 = arrayList21;
                    String str7 = (String) arrayList29.get(i7);
                    String parseStringAttr = parseStringAttr(str7, REGEX_GROUP_ID, hashMap3);
                    String parseStringAttr2 = parseStringAttr(str7, REGEX_NAME, hashMap3);
                    Format.Builder language = new Format.Builder().setId(parseStringAttr + ":" + parseStringAttr2).setLabel(parseStringAttr2).setContainerMimeType(str6).setSelectionFlags(parseSelectionFlags(str7)).setRoleFlags(parseRoleFlags(str7, hashMap3)).setLanguage(parseOptionalStringAttr(str7, REGEX_LANGUAGE, hashMap3));
                    String parseOptionalStringAttr8 = parseOptionalStringAttr(str7, REGEX_URI, hashMap3);
                    if (parseOptionalStringAttr8 == null) {
                        uri2 = uri;
                    } else {
                        uri2 = UriUtil.resolveToUri(str, parseOptionalStringAttr8);
                    }
                    arrayList21 = arrayList29;
                    String str8 = str6;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(parseStringAttr, parseStringAttr2, Collections.emptyList()));
                    String parseStringAttr3 = parseStringAttr(str7, REGEX_TYPE, hashMap3);
                    switch (parseStringAttr3.hashCode()) {
                        case -959297733:
                            if (parseStringAttr3.equals("SUBTITLES")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -333210994:
                            if (parseStringAttr3.equals("CLOSED-CAPTIONS")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 62628790:
                            if (parseStringAttr3.equals("AUDIO")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 81665115:
                            if (parseStringAttr3.equals("VIDEO")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            if (c == 2) {
                                HlsMasterPlaylist.Variant variantWithSubtitleGroup = getVariantWithSubtitleGroup(arrayList11, parseStringAttr);
                                if (variantWithSubtitleGroup != null) {
                                    String codecsOfType = Util.getCodecsOfType(variantWithSubtitleGroup.format.codecs, 3);
                                    language.setCodecs(codecsOfType);
                                    str3 = MimeTypes.getMediaMimeType(codecsOfType);
                                } else {
                                    str3 = null;
                                }
                                if (str3 == null) {
                                    str3 = "text/vtt";
                                }
                                language.setSampleMimeType(str3).setMetadata(metadata);
                                arrayList = arrayList24;
                                arrayList.add(new HlsMasterPlaylist.Rendition(uri2, language.build(), parseStringAttr, parseStringAttr2));
                                list = list3;
                                arrayList3 = arrayList22;
                                arrayList2 = arrayList23;
                            } else if (c != 3) {
                                list = list3;
                                arrayList3 = arrayList22;
                                arrayList2 = arrayList23;
                                arrayList = arrayList24;
                            } else {
                                String parseStringAttr4 = parseStringAttr(str7, REGEX_INSTREAM_ID, hashMap3);
                                if (parseStringAttr4.startsWith("CC")) {
                                    i = Integer.parseInt(parseStringAttr4.substring(2));
                                    str4 = "application/cea-608";
                                } else {
                                    i = Integer.parseInt(parseStringAttr4.substring(7));
                                    str4 = "application/cea-708";
                                }
                                if (list3 == null) {
                                    list3 = new ArrayList();
                                }
                                language.setSampleMimeType(str4).setAccessibilityChannel(i);
                                list3.add(language.build());
                                arrayList3 = arrayList22;
                                arrayList2 = arrayList23;
                                arrayList = arrayList24;
                            }
                            list3 = list;
                        } else {
                            arrayList = arrayList24;
                            HlsMasterPlaylist.Variant variantWithAudioGroup = getVariantWithAudioGroup(arrayList11, parseStringAttr);
                            if (variantWithAudioGroup != null) {
                                String codecsOfType2 = Util.getCodecsOfType(variantWithAudioGroup.format.codecs, 1);
                                language.setCodecs(codecsOfType2);
                                str2 = MimeTypes.getMediaMimeType(codecsOfType2);
                            } else {
                                str2 = null;
                            }
                            String parseOptionalStringAttr9 = parseOptionalStringAttr(str7, REGEX_CHANNELS, hashMap3);
                            if (parseOptionalStringAttr9 != null) {
                                language.setChannelCount(Integer.parseInt(Util.splitAtFirst(parseOptionalStringAttr9, "/")[0]));
                                if ("audio/eac3".equals(str2) && parseOptionalStringAttr9.endsWith("/JOC")) {
                                    str2 = "audio/eac3-joc";
                                }
                            }
                            language.setSampleMimeType(str2);
                            if (uri2 == null) {
                                format = language.build();
                                arrayList3 = arrayList22;
                                arrayList2 = arrayList23;
                            } else {
                                language.setMetadata(metadata);
                                arrayList2 = arrayList23;
                                arrayList2.add(new HlsMasterPlaylist.Rendition(uri2, language.build(), parseStringAttr, parseStringAttr2));
                                list = list3;
                            }
                        }
                        i7++;
                        arrayList22 = arrayList3;
                        arrayList23 = arrayList2;
                        arrayList24 = arrayList;
                        str6 = str8;
                        uri = null;
                    } else {
                        arrayList2 = arrayList23;
                        arrayList = arrayList24;
                        HlsMasterPlaylist.Variant variantWithVideoGroup = getVariantWithVideoGroup(arrayList11, parseStringAttr);
                        if (variantWithVideoGroup != null) {
                            Format format2 = variantWithVideoGroup.format;
                            list2 = list3;
                            String codecsOfType3 = Util.getCodecsOfType(format2.codecs, 2);
                            language.setCodecs(codecsOfType3).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType3)).setWidth(format2.width).setHeight(format2.height).setFrameRate(format2.frameRate);
                        } else {
                            list2 = list3;
                        }
                        if (uri2 != null) {
                            language.setMetadata(metadata);
                            arrayList3 = arrayList22;
                            arrayList3.add(new HlsMasterPlaylist.Rendition(uri2, language.build(), parseStringAttr, parseStringAttr2));
                            list3 = list;
                            i7++;
                            arrayList22 = arrayList3;
                            arrayList23 = arrayList2;
                            arrayList24 = arrayList;
                            str6 = str8;
                            uri = null;
                        }
                    }
                    arrayList3 = arrayList22;
                    list3 = list;
                    i7++;
                    arrayList22 = arrayList3;
                    arrayList23 = arrayList2;
                    arrayList24 = arrayList;
                    str6 = str8;
                    uri = null;
                }
                return new HlsMasterPlaylist(str, arrayList26, arrayList28, arrayList22, arrayList23, arrayList24, arrayList25, format, z ? Collections.emptyList() : list3, z5, hashMap3, arrayList27);
            }
        }
    }

    private static HlsMasterPlaylist.Variant getVariantWithAudioGroup(ArrayList<HlsMasterPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMasterPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.audioGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMasterPlaylist.Variant getVariantWithVideoGroup(ArrayList<HlsMasterPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMasterPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.videoGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMasterPlaylist.Variant getVariantWithSubtitleGroup(ArrayList<HlsMasterPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMasterPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.subtitleGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMediaPlaylist parseMediaPlaylist(HlsMasterPlaylist hlsMasterPlaylist, LineIterator lineIterator, String str) throws IOException {
        long j;
        HashMap hashMap;
        HashMap hashMap2;
        DrmInitData drmInitData;
        long j2;
        long j3;
        HlsMasterPlaylist hlsMasterPlaylist2 = hlsMasterPlaylist;
        boolean z = hlsMasterPlaylist2.hasIndependentSegments;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        TreeMap treeMap = new TreeMap();
        int i = 0;
        int i2 = 1;
        boolean z2 = z;
        String str2 = "";
        int i3 = 0;
        String str3 = null;
        String str4 = null;
        long j4 = -9223372036854775807L;
        long j5 = 0;
        boolean z3 = false;
        int i4 = 0;
        long j6 = 0;
        int i5 = 1;
        long j7 = -9223372036854775807L;
        boolean z4 = false;
        DrmInitData drmInitData2 = null;
        long j8 = 0;
        long j9 = 0;
        DrmInitData drmInitData3 = null;
        boolean z5 = false;
        String str5 = null;
        long j10 = -1;
        int i6 = 0;
        long j11 = 0;
        boolean z6 = false;
        HlsMediaPlaylist.Segment segment = null;
        while (true) {
            long j12 = 0;
            while (lineIterator.hasNext()) {
                String next = lineIterator.next();
                if (next.startsWith("#EXT")) {
                    arrayList2.add(next);
                }
                if (next.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String parseStringAttr = parseStringAttr(next, REGEX_PLAYLIST_TYPE, hashMap3);
                    if ("VOD".equals(parseStringAttr)) {
                        i3 = 1;
                    } else if ("EVENT".equals(parseStringAttr)) {
                        i3 = 2;
                    }
                } else if (next.equals("#EXT-X-I-FRAMES-ONLY")) {
                    z6 = true;
                } else if (next.startsWith("#EXT-X-START")) {
                    j4 = (long) (parseDoubleAttr(next, REGEX_TIME_OFFSET) * 1000000.0d);
                } else if (next.startsWith("#EXT-X-MAP")) {
                    String parseStringAttr2 = parseStringAttr(next, REGEX_URI, hashMap3);
                    String parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, hashMap3);
                    if (parseOptionalStringAttr != null) {
                        String[] split = parseOptionalStringAttr.split("@");
                        long parseLong = Long.parseLong(split[i]);
                        if (split.length > i2) {
                            j3 = Long.parseLong(split[i2]);
                            j2 = parseLong;
                        } else {
                            j2 = parseLong;
                            j3 = j8;
                        }
                    } else {
                        j3 = j8;
                        j2 = j10;
                    }
                    if (str3 == null || str5 != null) {
                        segment = new HlsMediaPlaylist.Segment(parseStringAttr2, j3, j2, str3, str5);
                        j8 = 0;
                        j10 = -1;
                    } else {
                        throw new ParserException("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                    }
                } else if (next.startsWith("#EXT-X-TARGETDURATION")) {
                    j7 = ((long) parseIntAttr(next, REGEX_TARGET_DURATION)) * 1000000;
                } else if (next.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    j9 = parseLongAttr(next, REGEX_MEDIA_SEQUENCE);
                    j6 = j9;
                } else if (next.startsWith("#EXT-X-VERSION")) {
                    i5 = parseIntAttr(next, REGEX_VERSION);
                } else {
                    if (next.startsWith("#EXT-X-DEFINE")) {
                        String parseOptionalStringAttr2 = parseOptionalStringAttr(next, REGEX_IMPORT, hashMap3);
                        if (parseOptionalStringAttr2 != null) {
                            String str6 = hlsMasterPlaylist2.variableDefinitions.get(parseOptionalStringAttr2);
                            if (str6 != null) {
                                hashMap3.put(parseOptionalStringAttr2, str6);
                            }
                        } else {
                            hashMap3.put(parseStringAttr(next, REGEX_NAME, hashMap3), parseStringAttr(next, REGEX_VALUE, hashMap3));
                        }
                    } else if (next.startsWith("#EXTINF")) {
                        str2 = parseOptionalStringAttr(next, REGEX_MEDIA_TITLE, "", hashMap3);
                        j12 = (long) (parseDoubleAttr(next, REGEX_MEDIA_DURATION) * 1000000.0d);
                    } else if (next.startsWith("#EXT-X-KEY")) {
                        String parseStringAttr3 = parseStringAttr(next, REGEX_METHOD, hashMap3);
                        String parseOptionalStringAttr3 = parseOptionalStringAttr(next, REGEX_KEYFORMAT, "identity", hashMap3);
                        if ("NONE".equals(parseStringAttr3)) {
                            treeMap.clear();
                            str3 = null;
                            drmInitData3 = null;
                            str5 = null;
                        } else {
                            str5 = parseOptionalStringAttr(next, REGEX_IV, hashMap3);
                            if (!"identity".equals(parseOptionalStringAttr3)) {
                                if (str4 == null) {
                                    str4 = parseEncryptionScheme(parseStringAttr3);
                                }
                                DrmInitData.SchemeData parseDrmSchemeData = parseDrmSchemeData(next, parseOptionalStringAttr3, hashMap3);
                                if (parseDrmSchemeData != null) {
                                    treeMap.put(parseOptionalStringAttr3, parseDrmSchemeData);
                                    drmInitData3 = null;
                                }
                            } else if ("AES-128".equals(parseStringAttr3)) {
                                str3 = parseStringAttr(next, REGEX_URI, hashMap3);
                            }
                            str3 = null;
                        }
                    } else if (next.startsWith("#EXT-X-BYTERANGE")) {
                        String[] split2 = parseStringAttr(next, REGEX_BYTERANGE, hashMap3).split("@");
                        j10 = Long.parseLong(split2[i]);
                        if (split2.length > i2) {
                            j8 = Long.parseLong(split2[i2]);
                        }
                    } else if (next.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                        i4 = Integer.parseInt(next.substring(next.indexOf(58) + i2));
                        z3 = true;
                    } else if (next.equals("#EXT-X-DISCONTINUITY")) {
                        i6++;
                    } else if (next.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                        if (j5 == 0) {
                            j5 = C.msToUs(Util.parseXsDateTime(next.substring(next.indexOf(58) + i2))) - j11;
                        }
                    } else if (next.equals("#EXT-X-GAP")) {
                        z5 = true;
                    } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        z2 = true;
                    } else if (next.equals("#EXT-X-ENDLIST")) {
                        z4 = true;
                    } else if (!next.startsWith("#")) {
                        String hexString = str3 == null ? null : str5 != null ? str5 : Long.toHexString(j9);
                        long j13 = j9 + 1;
                        String replaceVariableReferences = replaceVariableReferences(next, hashMap3);
                        HlsMediaPlaylist.Segment segment2 = (HlsMediaPlaylist.Segment) hashMap4.get(replaceVariableReferences);
                        if (j10 == -1) {
                            j = 0;
                        } else {
                            if (z6 && segment == null && segment2 == null) {
                                segment2 = new HlsMediaPlaylist.Segment(replaceVariableReferences, 0, j8, null, null);
                                hashMap4.put(replaceVariableReferences, segment2);
                            }
                            j = j8;
                        }
                        if (drmInitData3 != null || treeMap.isEmpty()) {
                            hashMap2 = hashMap3;
                            hashMap = hashMap4;
                            drmInitData = drmInitData3;
                        } else {
                            DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[i]);
                            drmInitData = new DrmInitData(str4, schemeDataArr);
                            if (drmInitData2 == null) {
                                DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
                                hashMap2 = hashMap3;
                                hashMap = hashMap4;
                                int i7 = 0;
                                while (i7 < schemeDataArr.length) {
                                    schemeDataArr2[i7] = schemeDataArr[i7].copyWithData(null);
                                    i7++;
                                    schemeDataArr = schemeDataArr;
                                }
                                drmInitData2 = new DrmInitData(str4, schemeDataArr2);
                            } else {
                                hashMap2 = hashMap3;
                                hashMap = hashMap4;
                            }
                        }
                        arrayList.add(new HlsMediaPlaylist.Segment(replaceVariableReferences, segment != null ? segment : segment2, str2, j12, i6, j11, drmInitData, str3, hexString, j, j10, z5));
                        j11 += j12;
                        if (j10 != -1) {
                            j += j10;
                        }
                        j8 = j;
                        hlsMasterPlaylist2 = hlsMasterPlaylist;
                        j10 = -1;
                        drmInitData3 = drmInitData;
                        str2 = "";
                        j9 = j13;
                        hashMap3 = hashMap2;
                        hashMap4 = hashMap;
                        i2 = 1;
                        i = 0;
                        z5 = false;
                    }
                    hlsMasterPlaylist2 = hlsMasterPlaylist;
                    hashMap3 = hashMap3;
                    hashMap4 = hashMap4;
                    i2 = 1;
                    i = 0;
                }
            }
            return new HlsMediaPlaylist(i3, str, arrayList2, j4, j5, z3, i4, j6, i5, j7, z2, z4, j5 != 0, drmInitData2, arrayList);
        }
    }

    private static int parseSelectionFlags(String str) {
        boolean parseOptionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_DEFAULT, false);
        if (parseOptionalBooleanAttribute(str, REGEX_FORCED, false)) {
            parseOptionalBooleanAttribute |= true;
        }
        return parseOptionalBooleanAttribute(str, REGEX_AUTOSELECT, false) ? parseOptionalBooleanAttribute | true ? 1 : 0 : parseOptionalBooleanAttribute ? 1 : 0;
    }

    private static int parseRoleFlags(String str, Map<String, String> map) {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, REGEX_CHARACTERISTICS, map);
        int i = 0;
        if (TextUtils.isEmpty(parseOptionalStringAttr)) {
            return 0;
        }
        String[] split = Util.split(parseOptionalStringAttr, ",");
        if (Util.contains(split, "public.accessibility.describes-video")) {
            i = 512;
        }
        if (Util.contains(split, "public.accessibility.transcribes-spoken-dialog")) {
            i |= 4096;
        }
        if (Util.contains(split, "public.accessibility.describes-music-and-sound")) {
            i |= 1024;
        }
        return Util.contains(split, "public.easy-to-read") ? i | 8192 : i;
    }

    private static DrmInitData.SchemeData parseDrmSchemeData(String str, String str2, Map<String, String> map) throws ParserException {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, REGEX_KEYFORMATVERSIONS, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String parseStringAttr = parseStringAttr(str, REGEX_URI, map);
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "video/mp4", Base64.decode(parseStringAttr.substring(parseStringAttr.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "hls", Util.getUtf8Bytes(str));
        } else {
            if (!"com.microsoft.playready".equals(str2) || !"1".equals(parseOptionalStringAttr)) {
                return null;
            }
            String parseStringAttr2 = parseStringAttr(str, REGEX_URI, map);
            return new DrmInitData.SchemeData(C.PLAYREADY_UUID, "video/mp4", PsshAtomUtil.buildPsshAtom(C.PLAYREADY_UUID, Base64.decode(parseStringAttr2.substring(parseStringAttr2.indexOf(44)), 0)));
        }
    }

    private static String parseEncryptionScheme(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    private static int parseIntAttr(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static int parseOptionalIntAttr(String str, Pattern pattern, int i) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))) : i;
    }

    private static long parseLongAttr(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static double parseDoubleAttr(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static String parseStringAttr(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, pattern, map);
        if (parseOptionalStringAttr != null) {
            return parseOptionalStringAttr;
        }
        throw new ParserException("Couldn't match " + pattern.pattern() + " in " + str);
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, Map<String, String> map) {
        return parseOptionalStringAttr(str, pattern, null, map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static String parseOptionalStringAttr(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = Assertions.checkNotNull(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : replaceVariableReferences(str2, map);
    }

    private static String replaceVariableReferences(String str, Map<String, String> map) {
        Matcher matcher = REGEX_VARIABLE_REFERENCE.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static boolean parseOptionalBooleanAttribute(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z;
    }

    private static Pattern compileBooleanAttrPattern(String str) {
        return Pattern.compile(str + "=(NO|YES" + ")");
    }

    static class LineIterator {
        private final Queue<String> extraLines;
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        public boolean hasNext() throws IOException {
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = (String) Assertions.checkNotNull(this.extraLines.poll());
                return true;
            }
            do {
                String readLine = this.reader.readLine();
                this.next = readLine;
                if (readLine == null) {
                    return false;
                }
                this.next = this.next.trim();
            } while (this.next.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (hasNext()) {
                String str = this.next;
                this.next = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }
}
