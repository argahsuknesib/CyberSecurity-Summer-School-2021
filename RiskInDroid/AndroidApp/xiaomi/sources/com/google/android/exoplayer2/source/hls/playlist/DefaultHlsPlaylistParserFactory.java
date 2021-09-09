package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.ParsingLoadable;

public final class DefaultHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    public final ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser() {
        return new HlsPlaylistParser();
    }

    public final ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist) {
        return new HlsPlaylistParser(hlsMasterPlaylist);
    }
}
