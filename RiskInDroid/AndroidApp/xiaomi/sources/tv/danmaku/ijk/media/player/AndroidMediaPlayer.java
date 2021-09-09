package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.AndroidTrackInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

public class AndroidMediaPlayer extends AbstractMediaPlayer {
    private static MediaInfo sMediaInfo;
    private String mDataSource;
    private final Object mInitLock = new Object();
    private final AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
    private final MediaPlayer mInternalMediaPlayer;
    private boolean mIsReleased;
    private MediaDataSource mMediaDataSource;

    public int getVideoSarDen() {
        return 1;
    }

    public int getVideoSarNum() {
        return 1;
    }

    public boolean isPlayable() {
        return true;
    }

    public void setKeepInBackground(boolean z) {
    }

    public void setLogEnabled(boolean z) {
    }

    public AndroidMediaPlayer() {
        synchronized (this.mInitLock) {
            this.mInternalMediaPlayer = new MediaPlayer();
        }
        this.mInternalMediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new AndroidMediaPlayerListenerHolder(this);
        attachInternalListeners();
    }

    public MediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.mInitLock) {
            if (!this.mIsReleased) {
                this.mInternalMediaPlayer.setDisplay(surfaceHolder);
            }
        }
    }

    @TargetApi(14)
    public void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    @TargetApi(14)
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.mInternalMediaPlayer.setDataSource(str);
        } else {
            this.mInternalMediaPlayer.setDataSource(parse.getPath());
        }
    }

    @TargetApi(23)
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        releaseMediaDataSource();
        this.mMediaDataSource = new MediaDataSourceProxy(iMediaDataSource);
        this.mInternalMediaPlayer.setDataSource(this.mMediaDataSource);
    }

    @TargetApi(23)
    static class MediaDataSourceProxy extends MediaDataSource {
        private final IMediaDataSource mMediaDataSource;

        public MediaDataSourceProxy(IMediaDataSource iMediaDataSource) {
            this.mMediaDataSource = iMediaDataSource;
        }

        public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
            return this.mMediaDataSource.readAt(j, bArr, i, i2);
        }

        public long getSize() throws IOException {
            return this.mMediaDataSource.getSize();
        }

        public void close() throws IOException {
            this.mMediaDataSource.close();
        }
    }

    public String getDataSource() {
        return this.mDataSource;
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource = this.mMediaDataSource;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mMediaDataSource = null;
        }
    }

    public void prepareAsync() throws IllegalStateException {
        this.mInternalMediaPlayer.prepareAsync();
    }

    public void start() throws IllegalStateException {
        this.mInternalMediaPlayer.start();
    }

    public void stop() throws IllegalStateException {
        this.mInternalMediaPlayer.stop();
    }

    public void pause() throws IllegalStateException {
        this.mInternalMediaPlayer.pause();
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z);
    }

    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
    }

    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    public boolean isPlaying() {
        try {
            return this.mInternalMediaPlayer.isPlaying();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return false;
        }
    }

    public void seekTo(long j) throws IllegalStateException {
        this.mInternalMediaPlayer.seekTo((int) j);
    }

    public long getCurrentPosition() {
        try {
            return (long) this.mInternalMediaPlayer.getCurrentPosition();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return 0;
        }
    }

    public long getDuration() {
        try {
            return (long) this.mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return 0;
        }
    }

    public void release() {
        this.mIsReleased = true;
        this.mInternalMediaPlayer.release();
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    public void reset() {
        try {
            this.mInternalMediaPlayer.reset();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    public void setLooping(boolean z) {
        this.mInternalMediaPlayer.setLooping(z);
    }

    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    public void setVolume(float f, float f2) {
        this.mInternalMediaPlayer.setVolume(f, f2);
    }

    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    public MediaInfo getMediaInfo() {
        if (sMediaInfo == null) {
            MediaInfo mediaInfo = new MediaInfo();
            mediaInfo.mVideoDecoder = "android";
            mediaInfo.mVideoDecoderImpl = "HW";
            mediaInfo.mAudioDecoder = "android";
            mediaInfo.mAudioDecoderImpl = "HW";
            sMediaInfo = mediaInfo;
        }
        return sMediaInfo;
    }

    public void setWakeMode(Context context, int i) {
        this.mInternalMediaPlayer.setWakeMode(context, i);
    }

    public void setAudioStreamType(int i) {
        this.mInternalMediaPlayer.setAudioStreamType(i);
    }

    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnTimedTextListener(this.mInternalListenerAdapter);
    }

    class AndroidMediaPlayerListenerHolder implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        public final WeakReference<AndroidMediaPlayer> mWeakMediaPlayer;

        public AndroidMediaPlayerListenerHolder(AndroidMediaPlayer androidMediaPlayer) {
            this.mWeakMediaPlayer = new WeakReference<>(androidMediaPlayer);
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return this.mWeakMediaPlayer.get() != null && AndroidMediaPlayer.this.notifyOnInfo(i, i2);
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return this.mWeakMediaPlayer.get() != null && AndroidMediaPlayer.this.notifyOnError(i, i2);
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnVideoSizeChanged(i, i2, 1, 1);
            }
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnSeekComplete();
            }
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnBufferingUpdate(i);
            }
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnCompletion();
            }
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnPrepared();
            }
        }

        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            if (this.mWeakMediaPlayer.get() != null) {
                IjkTimedText ijkTimedText = null;
                if (timedText != null) {
                    ijkTimedText = new IjkTimedText(timedText.getBounds(), timedText.getText());
                }
                AndroidMediaPlayer.this.notifyOnTimedText(ijkTimedText);
            }
        }
    }
}
