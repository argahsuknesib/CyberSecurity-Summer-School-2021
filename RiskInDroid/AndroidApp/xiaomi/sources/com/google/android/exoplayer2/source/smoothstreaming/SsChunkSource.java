package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;

public interface SsChunkSource extends ChunkSource {

    public interface Factory {
        SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, TrackSelection trackSelection, TransferListener transferListener);
    }

    void updateManifest(SsManifest ssManifest);

    void updateTrackSelection(TrackSelection trackSelection);
}
