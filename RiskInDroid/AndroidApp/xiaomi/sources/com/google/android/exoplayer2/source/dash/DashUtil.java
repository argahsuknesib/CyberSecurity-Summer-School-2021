package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;

public final class DashUtil {
    public static DataSpec buildDataSpec(Representation representation, RangedUri rangedUri) {
        return new DataSpec.Builder().setUri(rangedUri.resolveUri(representation.baseUrl)).setPosition(rangedUri.start).setLength(rangedUri.length).setKey(representation.getCacheKey()).build();
    }

    public static DashManifest loadManifest(DataSource dataSource, Uri uri) throws IOException {
        return (DashManifest) ParsingLoadable.load(dataSource, new DashManifestParser(), uri, 4);
    }

    public static DrmInitData loadDrmInitData(DataSource dataSource, Period period) throws IOException {
        int i = 2;
        Representation firstRepresentation = getFirstRepresentation(period, 2);
        if (firstRepresentation == null) {
            firstRepresentation = getFirstRepresentation(period, 1);
            if (firstRepresentation == null) {
                return null;
            }
            i = 1;
        }
        Format format = firstRepresentation.format;
        Format loadSampleFormat = loadSampleFormat(dataSource, i, firstRepresentation);
        if (loadSampleFormat == null) {
            return format.drmInitData;
        }
        return loadSampleFormat.withManifestFormatInfo(format).drmInitData;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.source.dash.DashUtil.loadInitializationData(com.google.android.exoplayer2.upstream.DataSource, int, com.google.android.exoplayer2.source.dash.manifest.Representation, boolean):com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper
     arg types: [com.google.android.exoplayer2.upstream.DataSource, int, com.google.android.exoplayer2.source.dash.manifest.Representation, int]
     candidates:
      com.google.android.exoplayer2.source.dash.DashUtil.loadInitializationData(com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.source.dash.manifest.Representation, com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper, com.google.android.exoplayer2.source.dash.manifest.RangedUri):void
      com.google.android.exoplayer2.source.dash.DashUtil.loadInitializationData(com.google.android.exoplayer2.upstream.DataSource, int, com.google.android.exoplayer2.source.dash.manifest.Representation, boolean):com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper */
    public static Format loadSampleFormat(DataSource dataSource, int i, Representation representation) throws IOException {
        ChunkExtractorWrapper loadInitializationData = loadInitializationData(dataSource, i, representation, false);
        if (loadInitializationData == null) {
            return null;
        }
        return ((Format[]) Assertions.checkStateNotNull(loadInitializationData.getSampleFormats()))[0];
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.source.dash.DashUtil.loadInitializationData(com.google.android.exoplayer2.upstream.DataSource, int, com.google.android.exoplayer2.source.dash.manifest.Representation, boolean):com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper
     arg types: [com.google.android.exoplayer2.upstream.DataSource, int, com.google.android.exoplayer2.source.dash.manifest.Representation, int]
     candidates:
      com.google.android.exoplayer2.source.dash.DashUtil.loadInitializationData(com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.source.dash.manifest.Representation, com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper, com.google.android.exoplayer2.source.dash.manifest.RangedUri):void
      com.google.android.exoplayer2.source.dash.DashUtil.loadInitializationData(com.google.android.exoplayer2.upstream.DataSource, int, com.google.android.exoplayer2.source.dash.manifest.Representation, boolean):com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper */
    public static ChunkIndex loadChunkIndex(DataSource dataSource, int i, Representation representation) throws IOException {
        ChunkExtractorWrapper loadInitializationData = loadInitializationData(dataSource, i, representation, true);
        if (loadInitializationData == null) {
            return null;
        }
        return (ChunkIndex) loadInitializationData.getSeekMap();
    }

    private static ChunkExtractorWrapper loadInitializationData(DataSource dataSource, int i, Representation representation, boolean z) throws IOException {
        RangedUri initializationUri = representation.getInitializationUri();
        if (initializationUri == null) {
            return null;
        }
        ChunkExtractorWrapper newWrappedExtractor = newWrappedExtractor(i, representation.format);
        if (z) {
            RangedUri indexUri = representation.getIndexUri();
            if (indexUri == null) {
                return null;
            }
            RangedUri attemptMerge = initializationUri.attemptMerge(indexUri, representation.baseUrl);
            if (attemptMerge == null) {
                loadInitializationData(dataSource, representation, newWrappedExtractor, initializationUri);
                initializationUri = indexUri;
            } else {
                initializationUri = attemptMerge;
            }
        }
        loadInitializationData(dataSource, representation, newWrappedExtractor, initializationUri);
        return newWrappedExtractor;
    }

    private static void loadInitializationData(DataSource dataSource, Representation representation, ChunkExtractorWrapper chunkExtractorWrapper, RangedUri rangedUri) throws IOException {
        new InitializationChunk(dataSource, buildDataSpec(representation, rangedUri), representation.format, 0, null, chunkExtractorWrapper).load();
    }

    private static ChunkExtractorWrapper newWrappedExtractor(int i, Format format) {
        String str = format.containerMimeType;
        return new ChunkExtractorWrapper(str != null && (str.startsWith("video/webm") || str.startsWith("audio/webm")) ? new MatroskaExtractor() : new FragmentedMp4Extractor(), i, format);
    }

    private static Representation getFirstRepresentation(Period period, int i) {
        int adaptationSetIndex = period.getAdaptationSetIndex(i);
        if (adaptationSetIndex == -1) {
            return null;
        }
        List<Representation> list = period.adaptationSets.get(adaptationSetIndex).representations;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private DashUtil() {
    }
}
