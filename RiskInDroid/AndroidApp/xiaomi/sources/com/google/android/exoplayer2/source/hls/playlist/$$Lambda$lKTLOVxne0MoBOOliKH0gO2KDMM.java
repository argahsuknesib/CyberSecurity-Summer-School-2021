package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;

/* renamed from: com.google.android.exoplayer2.source.hls.playlist.-$$Lambda$lKTLOVxne0MoBOOliKH0gO2KDMM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$lKTLOVxne0MoBOOliKH0gO2KDMM implements HlsPlaylistTracker.Factory {
    public static final /* synthetic */ $$Lambda$lKTLOVxne0MoBOOliKH0gO2KDMM INSTANCE = new $$Lambda$lKTLOVxne0MoBOOliKH0gO2KDMM();

    private /* synthetic */ $$Lambda$lKTLOVxne0MoBOOliKH0gO2KDMM() {
    }

    public final HlsPlaylistTracker createTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        return new DefaultHlsPlaylistTracker(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory);
    }
}
