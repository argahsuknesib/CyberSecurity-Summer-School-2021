package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.EOFException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {
    private final boolean exposeCea608WhenMissingDeclarations;
    private final int payloadReaderFactoryFlags;

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    public DefaultHlsExtractorFactory(int i, boolean z) {
        this.payloadReaderFactoryFlags = i;
        this.exposeCea608WhenMissingDeclarations = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r1 == null) goto L_0x0088;
     */
    public final HlsExtractorFactory.Result createExtractor(Extractor extractor, Uri uri, Format format, List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput) throws IOException {
        Extractor extractor2;
        if (extractor != null) {
            if (isReusable(extractor)) {
                return buildResult(extractor);
            }
            if (buildResultForSameExtractorType(extractor, format, timestampAdjuster) == null) {
                throw new IllegalArgumentException("Unexpected previousExtractor type: " + extractor.getClass().getSimpleName());
            }
        }
        Extractor createExtractorByFileExtension = createExtractorByFileExtension(uri, format, list, timestampAdjuster);
        extractorInput.resetPeekPosition();
        if (createExtractorByFileExtension != null && sniffQuietly(createExtractorByFileExtension, extractorInput)) {
            return buildResult(createExtractorByFileExtension);
        }
        if (!(createExtractorByFileExtension instanceof FragmentedMp4Extractor)) {
            FragmentedMp4Extractor createFragmentedMp4Extractor = createFragmentedMp4Extractor(timestampAdjuster, format, list);
            if (sniffQuietly(createFragmentedMp4Extractor, extractorInput)) {
                return buildResult(createFragmentedMp4Extractor);
            }
        }
        if (!(createExtractorByFileExtension instanceof WebvttExtractor)) {
            WebvttExtractor webvttExtractor = new WebvttExtractor(format.language, timestampAdjuster);
            if (sniffQuietly(webvttExtractor, extractorInput)) {
                return buildResult(webvttExtractor);
            }
        }
        if (!(createExtractorByFileExtension instanceof TsExtractor)) {
            extractor2 = createTsExtractor(this.payloadReaderFactoryFlags, this.exposeCea608WhenMissingDeclarations, format, list, timestampAdjuster);
            if (sniffQuietly(extractor2, extractorInput)) {
                return buildResult(extractor2);
            }
        }
        extractor2 = createExtractorByFileExtension;
        if (!(createExtractorByFileExtension instanceof AdtsExtractor)) {
            AdtsExtractor adtsExtractor = new AdtsExtractor();
            if (sniffQuietly(adtsExtractor, extractorInput)) {
                return buildResult(adtsExtractor);
            }
        }
        if (!(createExtractorByFileExtension instanceof Ac3Extractor)) {
            Ac3Extractor ac3Extractor = new Ac3Extractor();
            if (sniffQuietly(ac3Extractor, extractorInput)) {
                return buildResult(ac3Extractor);
            }
        }
        if (!(createExtractorByFileExtension instanceof Ac4Extractor)) {
            Ac4Extractor ac4Extractor = new Ac4Extractor();
            if (sniffQuietly(ac4Extractor, extractorInput)) {
                return buildResult(ac4Extractor);
            }
        }
        if (!(createExtractorByFileExtension instanceof Mp3Extractor)) {
            Mp3Extractor mp3Extractor = new Mp3Extractor(0, 0);
            if (sniffQuietly(mp3Extractor, extractorInput)) {
                return buildResult(mp3Extractor);
            }
        }
        return buildResult((Extractor) Assertions.checkNotNull(extractor2));
    }

    private Extractor createExtractorByFileExtension(Uri uri, Format format, List<Format> list, TimestampAdjuster timestampAdjuster) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = "";
        }
        if ("text/vtt".equals(format.sampleMimeType) || lastPathSegment.endsWith(".webvtt") || lastPathSegment.endsWith(".vtt")) {
            return new WebvttExtractor(format.language, timestampAdjuster);
        }
        if (lastPathSegment.endsWith(".aac")) {
            return new AdtsExtractor();
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return new Ac3Extractor();
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return new Ac4Extractor();
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return new Mp3Extractor(0, 0);
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return createFragmentedMp4Extractor(timestampAdjuster, format, list);
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return createTsExtractor(this.payloadReaderFactoryFlags, this.exposeCea608WhenMissingDeclarations, format, list, timestampAdjuster);
        }
        return null;
    }

    private static TsExtractor createTsExtractor(int i, boolean z, Format format, List<Format> list, TimestampAdjuster timestampAdjuster) {
        int i2 = i | 16;
        if (list != null) {
            i2 |= 32;
        } else if (z) {
            list = Collections.singletonList(new Format.Builder().setSampleMimeType("application/cea-608").build());
        } else {
            list = Collections.emptyList();
        }
        String str = format.codecs;
        if (!TextUtils.isEmpty(str)) {
            if (!"audio/mp4a-latm".equals(MimeTypes.getAudioMediaMimeType(str))) {
                i2 |= 2;
            }
            if (!"video/avc".equals(MimeTypes.getVideoMediaMimeType(str))) {
                i2 |= 4;
            }
        }
        return new TsExtractor(2, timestampAdjuster, new DefaultTsPayloadReaderFactory(i2, list));
    }

    private static FragmentedMp4Extractor createFragmentedMp4Extractor(TimestampAdjuster timestampAdjuster, Format format, List<Format> list) {
        int i = isFmp4Variant(format) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new FragmentedMp4Extractor(i, timestampAdjuster, null, list);
    }

    private static boolean isFmp4Variant(Format format) {
        Metadata metadata = format.metadata;
        if (metadata == null) {
            return false;
        }
        int i = 0;
        while (i < metadata.length()) {
            Metadata.Entry entry = metadata.get(i);
            if (!(entry instanceof HlsTrackMetadataEntry)) {
                i++;
            } else if (!((HlsTrackMetadataEntry) entry).variantInfos.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private static HlsExtractorFactory.Result buildResultForSameExtractorType(Extractor extractor, Format format, TimestampAdjuster timestampAdjuster) {
        if (extractor instanceof WebvttExtractor) {
            return buildResult(new WebvttExtractor(format.language, timestampAdjuster));
        }
        if (extractor instanceof AdtsExtractor) {
            return buildResult(new AdtsExtractor());
        }
        if (extractor instanceof Ac3Extractor) {
            return buildResult(new Ac3Extractor());
        }
        if (extractor instanceof Ac4Extractor) {
            return buildResult(new Ac4Extractor());
        }
        if (extractor instanceof Mp3Extractor) {
            return buildResult(new Mp3Extractor());
        }
        return null;
    }

    private static HlsExtractorFactory.Result buildResult(Extractor extractor) {
        return new HlsExtractorFactory.Result(extractor, (extractor instanceof AdtsExtractor) || (extractor instanceof Ac3Extractor) || (extractor instanceof Ac4Extractor) || (extractor instanceof Mp3Extractor), isReusable(extractor));
    }

    /* JADX INFO: finally extract failed */
    private static boolean sniffQuietly(Extractor extractor, ExtractorInput extractorInput) throws IOException {
        try {
            boolean sniff = extractor.sniff(extractorInput);
            extractorInput.resetPeekPosition();
            return sniff;
        } catch (EOFException unused) {
            extractorInput.resetPeekPosition();
            return false;
        } catch (Throwable th) {
            extractorInput.resetPeekPosition();
            throw th;
        }
    }

    private static boolean isReusable(Extractor extractor) {
        return (extractor instanceof TsExtractor) || (extractor instanceof FragmentedMp4Extractor);
    }
}
