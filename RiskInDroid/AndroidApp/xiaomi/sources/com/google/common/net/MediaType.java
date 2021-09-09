package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

@GwtCompatible
@Immutable
@Beta
public final class MediaType {
    public static final MediaType AAC_AUDIO = createConstant("audio", "aac");
    public static final MediaType ANY_APPLICATION_TYPE = createConstant("application", "*");
    public static final MediaType ANY_AUDIO_TYPE = createConstant("audio", "*");
    public static final MediaType ANY_IMAGE_TYPE = createConstant("image", "*");
    public static final MediaType ANY_TEXT_TYPE = createConstant("text", "*");
    public static final MediaType ANY_TYPE = createConstant("*", "*");
    public static final MediaType ANY_VIDEO_TYPE = createConstant("video", "*");
    public static final MediaType APPLE_MOBILE_CONFIG = createConstant("application", "x-apple-aspen-config");
    public static final MediaType APPLE_PASSBOOK = createConstant("application", "vnd.apple.pkpass");
    public static final MediaType APPLICATION_BINARY = createConstant("application", "binary");
    public static final MediaType APPLICATION_XML_UTF_8 = createConstantUtf8("application", "xml");
    public static final MediaType ATOM_UTF_8 = createConstantUtf8("application", "atom+xml");
    public static final MediaType BASIC_AUDIO = createConstant("audio", "basic");
    public static final MediaType BMP = createConstant("image", "bmp");
    public static final MediaType BZIP2 = createConstant("application", "x-bzip2");
    public static final MediaType CACHE_MANIFEST_UTF_8 = createConstantUtf8("text", "cache-manifest");
    public static final MediaType CRW = createConstant("image", "x-canon-crw");
    public static final MediaType CSS_UTF_8 = createConstantUtf8("text", "css");
    public static final MediaType CSV_UTF_8 = createConstantUtf8("text", "csv");
    public static final MediaType DART_UTF_8 = createConstantUtf8("application", "dart");
    public static final MediaType EOT = createConstant("application", "vnd.ms-fontobject");
    public static final MediaType EPUB = createConstant("application", "epub+zip");
    public static final MediaType FLV_VIDEO = createConstant("video", "x-flv");
    public static final MediaType FORM_DATA = createConstant("application", "x-www-form-urlencoded");
    public static final MediaType GIF = createConstant("image", "gif");
    public static final MediaType GZIP = createConstant("application", "x-gzip");
    public static final MediaType HAL_JSON = createConstant("application", "hal+json");
    public static final MediaType HTML_UTF_8 = createConstantUtf8("text", "html");
    public static final MediaType ICO = createConstant("image", "vnd.microsoft.icon");
    public static final MediaType I_CALENDAR_UTF_8 = createConstantUtf8("text", "calendar");
    public static final MediaType JAVASCRIPT_UTF_8 = createConstantUtf8("application", "javascript");
    public static final MediaType JPEG = createConstant("image", "jpeg");
    public static final MediaType JSON_UTF_8 = createConstantUtf8("application", "json");
    public static final MediaType KEY_ARCHIVE = createConstant("application", "pkcs12");
    public static final MediaType KML = createConstant("application", "vnd.google-earth.kml+xml");
    public static final MediaType KMZ = createConstant("application", "vnd.google-earth.kmz");
    private static final Map<MediaType, MediaType> KNOWN_TYPES = Maps.newHashMap();
    public static final MediaType L16_AUDIO = createConstant("audio", "l16");
    public static final MediaType L24_AUDIO = createConstant("audio", "l24");
    private static final CharMatcher LINEAR_WHITE_SPACE = CharMatcher.anyOf(" \t\r\n");
    public static final MediaType MANIFEST_JSON_UTF_8 = createConstantUtf8("application", "manifest+json");
    public static final MediaType MBOX = createConstant("application", "mbox");
    public static final MediaType MICROSOFT_EXCEL = createConstant("application", "vnd.ms-excel");
    public static final MediaType MICROSOFT_POWERPOINT = createConstant("application", "vnd.ms-powerpoint");
    public static final MediaType MICROSOFT_WORD = createConstant("application", "msword");
    public static final MediaType MP4_AUDIO = createConstant("audio", "mp4");
    public static final MediaType MP4_VIDEO = createConstant("video", "mp4");
    public static final MediaType MPEG_AUDIO = createConstant("audio", "mpeg");
    public static final MediaType MPEG_VIDEO = createConstant("video", "mpeg");
    public static final MediaType NACL_APPLICATION = createConstant("application", "x-nacl");
    public static final MediaType NACL_PORTABLE_APPLICATION = createConstant("application", "x-pnacl");
    public static final MediaType OCTET_STREAM = createConstant("application", "octet-stream");
    public static final MediaType OGG_AUDIO = createConstant("audio", "ogg");
    public static final MediaType OGG_CONTAINER = createConstant("application", "ogg");
    public static final MediaType OGG_VIDEO = createConstant("video", "ogg");
    public static final MediaType OOXML_DOCUMENT = createConstant("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final MediaType OOXML_PRESENTATION = createConstant("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final MediaType OOXML_SHEET = createConstant("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final MediaType OPENDOCUMENT_GRAPHICS = createConstant("application", "vnd.oasis.opendocument.graphics");
    public static final MediaType OPENDOCUMENT_PRESENTATION = createConstant("application", "vnd.oasis.opendocument.presentation");
    public static final MediaType OPENDOCUMENT_SPREADSHEET = createConstant("application", "vnd.oasis.opendocument.spreadsheet");
    public static final MediaType OPENDOCUMENT_TEXT = createConstant("application", "vnd.oasis.opendocument.text");
    private static final Joiner.MapJoiner PARAMETER_JOINER = Joiner.on("; ").withKeyValueSeparator("=");
    public static final MediaType PDF = createConstant("application", "pdf");
    public static final MediaType PLAIN_TEXT_UTF_8 = createConstantUtf8("text", "plain");
    public static final MediaType PNG = createConstant("image", "png");
    public static final MediaType POSTSCRIPT = createConstant("application", "postscript");
    public static final MediaType PROTOBUF = createConstant("application", "protobuf");
    public static final MediaType PSD = createConstant("image", "vnd.adobe.photoshop");
    public static final MediaType QUICKTIME = createConstant("video", "quicktime");
    private static final CharMatcher QUOTED_TEXT_MATCHER = CharMatcher.ascii().and(CharMatcher.noneOf("\"\\\r"));
    public static final MediaType RDF_XML_UTF_8 = createConstantUtf8("application", "rdf+xml");
    public static final MediaType RTF_UTF_8 = createConstantUtf8("application", "rtf");
    public static final MediaType SFNT = createConstant("application", "font-sfnt");
    public static final MediaType SHOCKWAVE_FLASH = createConstant("application", "x-shockwave-flash");
    public static final MediaType SKETCHUP = createConstant("application", "vnd.sketchup.skp");
    public static final MediaType SOAP_XML_UTF_8 = createConstantUtf8("application", "soap+xml");
    public static final MediaType SVG_UTF_8 = createConstantUtf8("image", "svg+xml");
    public static final MediaType TAR = createConstant("application", "x-tar");
    public static final MediaType TEXT_JAVASCRIPT_UTF_8 = createConstantUtf8("text", "javascript");
    public static final MediaType THREE_GPP2_VIDEO = createConstant("video", "3gpp2");
    public static final MediaType THREE_GPP_VIDEO = createConstant("video", "3gpp");
    public static final MediaType TIFF = createConstant("image", "tiff");
    public static final CharMatcher TOKEN_MATCHER = CharMatcher.ascii().and(CharMatcher.javaIsoControl().negate()).and(CharMatcher.isNot(' ')).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
    public static final MediaType TSV_UTF_8 = createConstantUtf8("text", "tab-separated-values");
    private static final ImmutableListMultimap<String, String> UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of((Object) "charset", (Object) Ascii.toLowerCase(Charsets.UTF_8.name()));
    public static final MediaType VCARD_UTF_8 = createConstantUtf8("text", "vcard");
    public static final MediaType VND_REAL_AUDIO = createConstant("audio", "vnd.rn-realaudio");
    public static final MediaType VND_WAVE_AUDIO = createConstant("audio", "vnd.wave");
    public static final MediaType VORBIS_AUDIO = createConstant("audio", "vorbis");
    public static final MediaType VTT_UTF_8 = createConstantUtf8("text", "vtt");
    public static final MediaType WASM_APPLICATION = createConstant("application", "wasm");
    public static final MediaType WAX_AUDIO = createConstant("audio", "x-ms-wax");
    public static final MediaType WEBM_AUDIO = createConstant("audio", "webm");
    public static final MediaType WEBM_VIDEO = createConstant("video", "webm");
    public static final MediaType WEBP = createConstant("image", "webp");
    public static final MediaType WMA_AUDIO = createConstant("audio", "x-ms-wma");
    public static final MediaType WML_UTF_8 = createConstantUtf8("text", "vnd.wap.wml");
    public static final MediaType WMV = createConstant("video", "x-ms-wmv");
    public static final MediaType WOFF = createConstant("application", "font-woff");
    public static final MediaType WOFF2 = createConstant("application", "font-woff2");
    public static final MediaType XHTML_UTF_8 = createConstantUtf8("application", "xhtml+xml");
    public static final MediaType XML_UTF_8 = createConstantUtf8("text", "xml");
    public static final MediaType XRD_UTF_8 = createConstantUtf8("application", "xrd+xml");
    public static final MediaType ZIP = createConstant("application", "zip");
    @LazyInit
    private int hashCode;
    private final ImmutableListMultimap<String, String> parameters;
    @LazyInit
    private Optional<Charset> parsedCharset;
    private final String subtype;
    @LazyInit
    private String toString;
    private final String type;

    private static MediaType createConstant(String str, String str2) {
        MediaType addKnownType = addKnownType(new MediaType(str, str2, ImmutableListMultimap.of()));
        addKnownType.parsedCharset = Optional.absent();
        return addKnownType;
    }

    private static MediaType createConstantUtf8(String str, String str2) {
        MediaType addKnownType = addKnownType(new MediaType(str, str2, UTF_8_CONSTANT_PARAMETERS));
        addKnownType.parsedCharset = Optional.of(Charsets.UTF_8);
        return addKnownType;
    }

    private static MediaType addKnownType(MediaType mediaType) {
        KNOWN_TYPES.put(mediaType, mediaType);
        return mediaType;
    }

    private MediaType(String str, String str2, ImmutableListMultimap<String, String> immutableListMultimap) {
        this.type = str;
        this.subtype = str2;
        this.parameters = immutableListMultimap;
    }

    public final String type() {
        return this.type;
    }

    public final String subtype() {
        return this.subtype;
    }

    public final ImmutableListMultimap<String, String> parameters() {
        return this.parameters;
    }

    private Map<String, ImmutableMultiset<String>> parametersAsMap() {
        return Maps.transformValues(this.parameters.asMap(), new Function<Collection<String>, ImmutableMultiset<String>>() {
            /* class com.google.common.net.MediaType.AnonymousClass1 */

            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Collection<String>) ((Collection) obj));
            }

            public ImmutableMultiset<String> apply(Collection<String> collection) {
                return ImmutableMultiset.copyOf(collection);
            }
        });
    }

    public final Optional<Charset> charset() {
        Optional<Charset> optional = this.parsedCharset;
        if (optional == null) {
            Optional<Charset> absent = Optional.absent();
            UnmodifiableIterator<String> it = this.parameters.get((Object) "charset").iterator();
            Optional<Charset> optional2 = absent;
            String str = null;
            optional = optional2;
            while (it.hasNext()) {
                String next = it.next();
                if (str == null) {
                    optional = Optional.of(Charset.forName(next));
                    str = next;
                } else if (!str.equals(next)) {
                    throw new IllegalStateException("Multiple charset values defined: " + str + ", " + next);
                }
            }
            this.parsedCharset = optional;
        }
        return optional;
    }

    public final MediaType withoutParameters() {
        return this.parameters.isEmpty() ? this : create(this.type, this.subtype);
    }

    public final MediaType withParameters(Multimap<String, String> multimap) {
        return create(this.type, this.subtype, multimap);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [java.lang.String, java.lang.Object]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    public final MediaType withParameters(String str, Iterable<String> iterable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(iterable);
        String normalizeToken = normalizeToken(str);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        UnmodifiableIterator<Map.Entry<String, String>> it = this.parameters.entries().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            String str2 = (String) next.getKey();
            if (!normalizeToken.equals(str2)) {
                builder.put((Object) str2, next.getValue());
            }
        }
        for (String normalizeParameterValue : iterable) {
            builder.put((Object) normalizeToken, (Object) normalizeParameterValue(normalizeToken, normalizeParameterValue));
        }
        MediaType mediaType = new MediaType(this.type, this.subtype, builder.build());
        if (!normalizeToken.equals("charset")) {
            mediaType.parsedCharset = this.parsedCharset;
        }
        return (MediaType) MoreObjects.firstNonNull(KNOWN_TYPES.get(mediaType), mediaType);
    }

    public final MediaType withParameter(String str, String str2) {
        return withParameters(str, ImmutableSet.of(str2));
    }

    public final MediaType withCharset(Charset charset) {
        Preconditions.checkNotNull(charset);
        MediaType withParameter = withParameter("charset", charset.name());
        withParameter.parsedCharset = Optional.of(charset);
        return withParameter;
    }

    public final boolean hasWildcard() {
        return "*".equals(this.type) || "*".equals(this.subtype);
    }

    public final boolean is(MediaType mediaType) {
        if (mediaType.type.equals("*") || mediaType.type.equals(this.type)) {
            return (mediaType.subtype.equals("*") || mediaType.subtype.equals(this.subtype)) && this.parameters.entries().containsAll(mediaType.parameters.entries());
        }
        return false;
    }

    public static MediaType create(String str, String str2) {
        MediaType create = create(str, str2, ImmutableListMultimap.of());
        create.parsedCharset = Optional.absent();
        return create;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    private static MediaType create(String str, String str2, Multimap<String, String> multimap) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(multimap);
        String normalizeToken = normalizeToken(str);
        String normalizeToken2 = normalizeToken(str2);
        Preconditions.checkArgument(!"*".equals(normalizeToken) || "*".equals(normalizeToken2), "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        for (Map.Entry next : multimap.entries()) {
            String normalizeToken3 = normalizeToken((String) next.getKey());
            builder.put((Object) normalizeToken3, (Object) normalizeParameterValue(normalizeToken3, (String) next.getValue()));
        }
        MediaType mediaType = new MediaType(normalizeToken, normalizeToken2, builder.build());
        return (MediaType) MoreObjects.firstNonNull(KNOWN_TYPES.get(mediaType), mediaType);
    }

    static MediaType createApplicationType(String str) {
        return create("application", str);
    }

    static MediaType createAudioType(String str) {
        return create("audio", str);
    }

    static MediaType createImageType(String str) {
        return create("image", str);
    }

    static MediaType createTextType(String str) {
        return create("text", str);
    }

    static MediaType createVideoType(String str) {
        return create("video", str);
    }

    private static String normalizeToken(String str) {
        Preconditions.checkArgument(TOKEN_MATCHER.matchesAllOf(str));
        return Ascii.toLowerCase(str);
    }

    private static String normalizeParameterValue(String str, String str2) {
        return "charset".equals(str) ? Ascii.toLowerCase(str2) : str2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    public static MediaType parse(String str) {
        String str2;
        Preconditions.checkNotNull(str);
        Tokenizer tokenizer = new Tokenizer(str);
        try {
            String consumeToken = tokenizer.consumeToken(TOKEN_MATCHER);
            tokenizer.consumeCharacter('/');
            String consumeToken2 = tokenizer.consumeToken(TOKEN_MATCHER);
            ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
            while (tokenizer.hasMore()) {
                tokenizer.consumeTokenIfPresent(LINEAR_WHITE_SPACE);
                tokenizer.consumeCharacter(';');
                tokenizer.consumeTokenIfPresent(LINEAR_WHITE_SPACE);
                String consumeToken3 = tokenizer.consumeToken(TOKEN_MATCHER);
                tokenizer.consumeCharacter('=');
                if ('\"' == tokenizer.previewChar()) {
                    tokenizer.consumeCharacter('\"');
                    StringBuilder sb = new StringBuilder();
                    while ('\"' != tokenizer.previewChar()) {
                        if ('\\' == tokenizer.previewChar()) {
                            tokenizer.consumeCharacter('\\');
                            sb.append(tokenizer.consumeCharacter(CharMatcher.ascii()));
                        } else {
                            sb.append(tokenizer.consumeToken(QUOTED_TEXT_MATCHER));
                        }
                    }
                    str2 = sb.toString();
                    tokenizer.consumeCharacter('\"');
                } else {
                    str2 = tokenizer.consumeToken(TOKEN_MATCHER);
                }
                builder.put((Object) consumeToken3, (Object) str2);
            }
            return create(consumeToken, consumeToken2, builder.build());
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("Could not parse '" + str + "'", e);
        }
    }

    static final class Tokenizer {
        final String input;
        int position = 0;

        Tokenizer(String str) {
            this.input = str;
        }

        /* access modifiers changed from: package-private */
        public final String consumeTokenIfPresent(CharMatcher charMatcher) {
            Preconditions.checkState(hasMore());
            int i = this.position;
            this.position = charMatcher.negate().indexIn(this.input, i);
            return hasMore() ? this.input.substring(i, this.position) : this.input.substring(i);
        }

        /* access modifiers changed from: package-private */
        public final String consumeToken(CharMatcher charMatcher) {
            int i = this.position;
            String consumeTokenIfPresent = consumeTokenIfPresent(charMatcher);
            Preconditions.checkState(this.position != i);
            return consumeTokenIfPresent;
        }

        /* access modifiers changed from: package-private */
        public final char consumeCharacter(CharMatcher charMatcher) {
            Preconditions.checkState(hasMore());
            char previewChar = previewChar();
            Preconditions.checkState(charMatcher.matches(previewChar));
            this.position++;
            return previewChar;
        }

        /* access modifiers changed from: package-private */
        public final char consumeCharacter(char c) {
            Preconditions.checkState(hasMore());
            Preconditions.checkState(previewChar() == c);
            this.position++;
            return c;
        }

        /* access modifiers changed from: package-private */
        public final char previewChar() {
            Preconditions.checkState(hasMore());
            return this.input.charAt(this.position);
        }

        /* access modifiers changed from: package-private */
        public final boolean hasMore() {
            int i = this.position;
            return i >= 0 && i < this.input.length();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MediaType) {
            MediaType mediaType = (MediaType) obj;
            return this.type.equals(mediaType.type) && this.subtype.equals(mediaType.subtype) && parametersAsMap().equals(mediaType.parametersAsMap());
        }
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode2 = Objects.hashCode(this.type, this.subtype, parametersAsMap());
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        String str = this.toString;
        if (str != null) {
            return str;
        }
        String computeToString = computeToString();
        this.toString = computeToString;
        return computeToString;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Multimaps.transformValues(com.google.common.collect.ListMultimap, com.google.common.base.Function):com.google.common.collect.ListMultimap<K, V2>
     arg types: [com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.String>, com.google.common.net.MediaType$2]
     candidates:
      com.google.common.collect.Multimaps.transformValues(com.google.common.collect.Multimap, com.google.common.base.Function):com.google.common.collect.Multimap<K, V2>
      com.google.common.collect.Multimaps.transformValues(com.google.common.collect.ListMultimap, com.google.common.base.Function):com.google.common.collect.ListMultimap<K, V2> */
    private String computeToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append('/');
        sb.append(this.subtype);
        if (!this.parameters.isEmpty()) {
            sb.append("; ");
            PARAMETER_JOINER.appendTo(sb, (Iterable<? extends Map.Entry<?, ?>>) Multimaps.transformValues((ListMultimap) this.parameters, (Function) new Function<String, String>() {
                /* class com.google.common.net.MediaType.AnonymousClass2 */

                public String apply(String str) {
                    return MediaType.TOKEN_MATCHER.matchesAllOf(str) ? str : MediaType.escapeAndQuote(str);
                }
            }).entries());
        }
        return sb.toString();
    }

    public static String escapeAndQuote(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == 13 || charAt == '\\' || charAt == '\"') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        sb.append('\"');
        return sb.toString();
    }
}
