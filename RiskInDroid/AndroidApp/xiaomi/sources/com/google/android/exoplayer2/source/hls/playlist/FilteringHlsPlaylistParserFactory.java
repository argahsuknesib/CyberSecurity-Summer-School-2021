package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.util.List;

public final class FilteringHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    private final HlsPlaylistParserFactory hlsPlaylistParserFactory;
    private final List<StreamKey> streamKeys;

    public FilteringHlsPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory2, List<StreamKey> list) {
        this.hlsPlaylistParserFactory = hlsPlaylistParserFactory2;
        this.streamKeys = list;
    }

    public final ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser() {
        return new FilteringManifestParser(this.hlsPlaylistParserFactory.createPlaylistParser(), this.streamKeys);
    }

    public final ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist) {
        return new FilteringManifestParser(this.hlsPlaylistParserFactory.createPlaylistParser(hlsMasterPlaylist), this.streamKeys);
    }
}
