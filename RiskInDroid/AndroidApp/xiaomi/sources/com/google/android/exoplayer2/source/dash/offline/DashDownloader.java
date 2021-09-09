package com.google.android.exoplayer2.source.dash.offline;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.offline.DownloadException;
import com.google.android.exoplayer2.offline.DownloaderConstructorHelper;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DashDownloader extends SegmentDownloader<DashManifest> {
    public DashDownloader(Uri uri, List<StreamKey> list, DownloaderConstructorHelper downloaderConstructorHelper) {
        super(uri, list, downloaderConstructorHelper);
    }

    /* access modifiers changed from: protected */
    public final DashManifest getManifest(DataSource dataSource, DataSpec dataSpec) throws IOException {
        return (DashManifest) ParsingLoadable.load(dataSource, new DashManifestParser(), dataSpec, 4);
    }

    /* access modifiers changed from: protected */
    public final List<SegmentDownloader.Segment> getSegments(DataSource dataSource, DashManifest dashManifest, boolean z) throws InterruptedException, IOException {
        DashManifest dashManifest2 = dashManifest;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dashManifest.getPeriodCount(); i++) {
            Period period = dashManifest2.getPeriod(i);
            long msToUs = C.msToUs(period.startMs);
            long periodDurationUs = dashManifest2.getPeriodDurationUs(i);
            int i2 = 0;
            for (List<AdaptationSet> list = period.adaptationSets; i2 < list.size(); list = list) {
                addSegmentsForAdaptationSet(dataSource, list.get(i2), msToUs, periodDurationUs, z, arrayList);
                i2++;
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0081 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007c A[SYNTHETIC] */
    private static void addSegmentsForAdaptationSet(DataSource dataSource, AdaptationSet adaptationSet, long j, long j2, boolean z, ArrayList<SegmentDownloader.Segment> arrayList) throws IOException, InterruptedException {
        AdaptationSet adaptationSet2 = adaptationSet;
        long j3 = j;
        ArrayList<SegmentDownloader.Segment> arrayList2 = arrayList;
        int i = 0;
        while (i < adaptationSet2.representations.size()) {
            Representation representation = adaptationSet2.representations.get(i);
            try {
                try {
                    DashSegmentIndex segmentIndex = getSegmentIndex(dataSource, adaptationSet2.type, representation);
                    if (segmentIndex != null) {
                        int segmentCount = segmentIndex.getSegmentCount(j2);
                        if (segmentCount != -1) {
                            String str = representation.baseUrl;
                            RangedUri initializationUri = representation.getInitializationUri();
                            if (initializationUri != null) {
                                addSegment(j3, str, initializationUri, arrayList2);
                            }
                            RangedUri indexUri = representation.getIndexUri();
                            if (indexUri != null) {
                                addSegment(j3, str, indexUri, arrayList2);
                            }
                            long firstSegmentNum = segmentIndex.getFirstSegmentNum();
                            long j4 = (((long) segmentCount) + firstSegmentNum) - 1;
                            while (firstSegmentNum <= j4) {
                                addSegment(j3 + segmentIndex.getTimeUs(firstSegmentNum), str, segmentIndex.getSegmentUrl(firstSegmentNum), arrayList2);
                                firstSegmentNum++;
                            }
                            i++;
                            adaptationSet2 = adaptationSet;
                        } else {
                            throw new DownloadException("Unbounded segment index");
                        }
                    } else {
                        try {
                            throw new DownloadException("Missing segment index");
                        } catch (IOException e) {
                            e = e;
                            if (z) {
                            }
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    if (z) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                if (z) {
                    i++;
                    adaptationSet2 = adaptationSet;
                } else {
                    throw e;
                }
            }
        }
    }

    private static void addSegment(long j, String str, RangedUri rangedUri, ArrayList<SegmentDownloader.Segment> arrayList) {
        arrayList.add(new SegmentDownloader.Segment(j, new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length)));
    }

    private static DashSegmentIndex getSegmentIndex(DataSource dataSource, int i, Representation representation) throws IOException, InterruptedException {
        DashSegmentIndex index = representation.getIndex();
        if (index != null) {
            return index;
        }
        ChunkIndex loadChunkIndex = DashUtil.loadChunkIndex(dataSource, i, representation);
        if (loadChunkIndex == null) {
            return null;
        }
        return new DashWrappingSegmentIndex(loadChunkIndex, representation.presentationTimeOffsetUs);
    }
}
