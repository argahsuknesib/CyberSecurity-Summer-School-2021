package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

public class MediaPlayerProxy implements IMediaPlayer {
    protected final IMediaPlayer mBackEndMediaPlayer;

    public boolean isPlayable() {
        return false;
    }

    public void setLogEnabled(boolean z) {
    }

    public MediaPlayerProxy(IMediaPlayer iMediaPlayer) {
        this.mBackEndMediaPlayer = iMediaPlayer;
    }

    public IMediaPlayer getInternalMediaPlayer() {
        return this.mBackEndMediaPlayer;
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mBackEndMediaPlayer.setDisplay(surfaceHolder);
    }

    @TargetApi(14)
    public void setSurface(Surface surface) {
        this.mBackEndMediaPlayer.setSurface(surface);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(context, uri);
    }

    @TargetApi(14)
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(context, uri, map);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(str);
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        this.mBackEndMediaPlayer.setDataSource(iMediaDataSource);
    }

    public String getDataSource() {
        return this.mBackEndMediaPlayer.getDataSource();
    }

    public void prepareAsync() throws IllegalStateException {
        this.mBackEndMediaPlayer.prepareAsync();
    }

    public void start() throws IllegalStateException {
        this.mBackEndMediaPlayer.start();
    }

    public void stop() throws IllegalStateException {
        this.mBackEndMediaPlayer.stop();
    }

    public void pause() throws IllegalStateException {
        this.mBackEndMediaPlayer.pause();
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.mBackEndMediaPlayer.setScreenOnWhilePlaying(z);
    }

    public int getVideoWidth() {
        return this.mBackEndMediaPlayer.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.mBackEndMediaPlayer.getVideoHeight();
    }

    public boolean isPlaying() {
        return this.mBackEndMediaPlayer.isPlaying();
    }

    public void seekTo(long j) throws IllegalStateException {
        this.mBackEndMediaPlayer.seekTo(j);
    }

    public long getCurrentPosition() {
        return this.mBackEndMediaPlayer.getCurrentPosition();
    }

    public long getDuration() {
        return this.mBackEndMediaPlayer.getDuration();
    }

    public void release() {
        this.mBackEndMediaPlayer.release();
    }

    public void reset() {
        this.mBackEndMediaPlayer.reset();
    }

    public void setVolume(float f, float f2) {
        this.mBackEndMediaPlayer.setVolume(f, f2);
    }

    public int getAudioSessionId() {
        return this.mBackEndMediaPlayer.getAudioSessionId();
    }

    public MediaInfo getMediaInfo() {
        return this.mBackEndMediaPlayer.getMediaInfo();
    }

    public void setOnPreparedListener(final IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener != null) {
            this.mBackEndMediaPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
                /* class tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass1 */

                public void onPrepared(IMediaPlayer iMediaPlayer) {
                    onPreparedListener.onPrepared(MediaPlayerProxy.this);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnPreparedListener(null);
        }
    }

    public void setOnCompletionListener(final IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            this.mBackEndMediaPlayer.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
                /* class tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass2 */

                public void onCompletion(IMediaPlayer iMediaPlayer) {
                    onCompletionListener.onCompletion(MediaPlayerProxy.this);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnCompletionListener(null);
        }
    }

    public void setOnBufferingUpdateListener(final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener != null) {
            this.mBackEndMediaPlayer.setOnBufferingUpdateListener(new IMediaPlayer.OnBufferingUpdateListener() {
                /* class tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass3 */

                public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                    onBufferingUpdateListener.onBufferingUpdate(MediaPlayerProxy.this, i);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnBufferingUpdateListener(null);
        }
    }

    public void setOnSeekCompleteListener(final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener != null) {
            this.mBackEndMediaPlayer.setOnSeekCompleteListener(new IMediaPlayer.OnSeekCompleteListener() {
                /* class tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass4 */

                public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                    onSeekCompleteListener.onSeekComplete(MediaPlayerProxy.this);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnSeekCompleteListener(null);
        }
    }

    public void setOnVideoSizeChangedListener(final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener != null) {
            this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(new IMediaPlayer.OnVideoSizeChangedListener() {
                /* class tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass5 */

                public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                    onVideoSizeChangedListener.onVideoSizeChanged(MediaPlayerProxy.this, i, i2, i3, i4);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(null);
        }
    }

    public void setOnErrorListener(final IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener != null) {
            this.mBackEndMediaPlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
                /* class tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass6 */

                public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                    return onErrorListener.onError(MediaPlayerProxy.this, i, i2);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnErrorListener(null);
        }
    }

    public void setOnInfoListener(final IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener != null) {
            this.mBackEndMediaPlayer.setOnInfoListener(new IMediaPlayer.OnInfoListener() {
                /* class tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass7 */

                public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                    return onInfoListener.onInfo(MediaPlayerProxy.this, i, i2);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnInfoListener(null);
        }
    }

    public void setOnTimedTextListener(final IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener != null) {
            this.mBackEndMediaPlayer.setOnTimedTextListener(new IMediaPlayer.OnTimedTextListener() {
                /* class tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass8 */

                public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
                    onTimedTextListener.onTimedText(MediaPlayerProxy.this, ijkTimedText);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnTimedTextListener(null);
        }
    }

    public void setAudioStreamType(int i) {
        this.mBackEndMediaPlayer.setAudioStreamType(i);
    }

    public void setKeepInBackground(boolean z) {
        this.mBackEndMediaPlayer.setKeepInBackground(z);
    }

    public int getVideoSarNum() {
        return this.mBackEndMediaPlayer.getVideoSarNum();
    }

    public int getVideoSarDen() {
        return this.mBackEndMediaPlayer.getVideoSarDen();
    }

    public void setWakeMode(Context context, int i) {
        this.mBackEndMediaPlayer.setWakeMode(context, i);
    }

    public ITrackInfo[] getTrackInfo() {
        return this.mBackEndMediaPlayer.getTrackInfo();
    }

    public void setLooping(boolean z) {
        this.mBackEndMediaPlayer.setLooping(z);
    }

    public boolean isLooping() {
        return this.mBackEndMediaPlayer.isLooping();
    }
}
