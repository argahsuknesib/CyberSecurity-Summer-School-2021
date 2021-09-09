package tv.danmaku.ijk.media.player.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class AndroidTrackInfo implements ITrackInfo {
    private final MediaPlayer.TrackInfo mTrackInfo;

    public static AndroidTrackInfo[] fromMediaPlayer(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 16) {
            return fromTrackInfo(mediaPlayer.getTrackInfo());
        }
        return null;
    }

    private static AndroidTrackInfo[] fromTrackInfo(MediaPlayer.TrackInfo[] trackInfoArr) {
        if (trackInfoArr == null) {
            return null;
        }
        AndroidTrackInfo[] androidTrackInfoArr = new AndroidTrackInfo[trackInfoArr.length];
        for (int i = 0; i < trackInfoArr.length; i++) {
            androidTrackInfoArr[i] = new AndroidTrackInfo(trackInfoArr[i]);
        }
        return androidTrackInfoArr;
    }

    private AndroidTrackInfo(MediaPlayer.TrackInfo trackInfo) {
        this.mTrackInfo = trackInfo;
    }

    @TargetApi(19)
    public IMediaFormat getFormat() {
        MediaFormat format;
        if (this.mTrackInfo == null || Build.VERSION.SDK_INT < 19 || (format = this.mTrackInfo.getFormat()) == null) {
            return null;
        }
        return new AndroidMediaFormat(format);
    }

    @TargetApi(16)
    public String getLanguage() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null) {
            return "und";
        }
        return trackInfo.getLanguage();
    }

    @TargetApi(16)
    public int getTrackType() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null) {
            return 0;
        }
        return trackInfo.getTrackType();
    }

    @TargetApi(16)
    public String toString() {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        sb.append(getClass().getSimpleName());
        sb.append('{');
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo != null) {
            sb.append(trackInfo.toString());
        } else {
            sb.append("null");
        }
        sb.append('}');
        return sb.toString();
    }

    @TargetApi(16)
    public String getInfoInline() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        return trackInfo != null ? trackInfo.toString() : "null";
    }
}
