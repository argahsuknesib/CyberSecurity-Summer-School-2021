package com.google.android.exoplayer2.source.smoothstreaming.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.DownloaderConstructorHelper;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsUtil;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class SsDownloader extends SegmentDownloader<SsManifest> {
    public SsDownloader(Uri uri, List<StreamKey> list, DownloaderConstructorHelper downloaderConstructorHelper) {
        super(SsUtil.fixManifestUri(uri), list, downloaderConstructorHelper);
    }

    /* access modifiers changed from: protected */
    public final SsManifest getManifest(DataSource dataSource, DataSpec dataSpec) throws IOException {
        return (SsManifest) ParsingLoadable.load(dataSource, new SsManifestParser(), dataSpec, 4);
    }

    /* access modifiers changed from: protected */
    public final List<SegmentDownloader.Segment> getSegments(DataSource dataSource, SsManifest ssManifest, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (SsManifest.StreamElement streamElement : ssManifest.streamElements) {
            for (int i = 0; i < streamElement.formats.length; i++) {
                for (int i2 = 0; i2 < streamElement.chunkCount; i2++) {
                    arrayList.add(new SegmentDownloader.Segment(streamElement.getStartTimeUs(i2), new DataSpec(streamElement.buildRequestUri(i, i2))));
                }
            }
        }
        return arrayList;
    }
}
