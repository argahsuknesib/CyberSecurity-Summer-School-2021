package tv.danmaku.ijk.media.player.misc;

public interface ITrackInfo {
    IMediaFormat getFormat();

    String getInfoInline();

    String getLanguage();

    int getTrackType();
}
