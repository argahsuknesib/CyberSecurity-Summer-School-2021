package com.xiaomi.smarthome.camera.view;

import _m_j.gsy;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.io.IOException;
import java.util.Map;

public class VideoView extends SurfaceView {
    public String TAG;
    private int mAudioSession;
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    public int mCurrentBufferPercentage;
    public int mCurrentState;
    private MediaPlayer.OnErrorListener mErrorListener;
    private Map<String, String> mHeaders;
    private MediaPlayer.OnInfoListener mInfoListener;
    public MediaPlayer mMediaPlayer;
    public MediaPlayer.OnCompletionListener mOnCompletionListener;
    public MediaPlayer.OnErrorListener mOnErrorListener;
    public MediaPlayer.OnInfoListener mOnInfoListener;
    public MediaPlayer.OnPreparedListener mOnPreparedListener;
    MediaPlayer.OnPreparedListener mPreparedListener;
    SurfaceHolder.Callback mSHCallback;
    public int mSeekWhenPrepared;
    MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener;
    public int mSurfaceHeight;
    public SurfaceHolder mSurfaceHolder;
    public int mSurfaceWidth;
    public int mTargetState;
    private Uri mUri;
    public int mVideoHeight;
    public int mVideoWidth;

    public VideoView(Context context) {
        super(context);
        this.TAG = "VideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass1 */

            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (VideoView.this.mVideoWidth != 0 && VideoView.this.mVideoHeight != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.mVideoWidth, VideoView.this.mVideoHeight);
                    VideoView.this.requestLayout();
                }
            }
        };
        this.mPreparedListener = new MediaPlayer.OnPreparedListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass2 */

            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoView videoView = VideoView.this;
                videoView.mCurrentState = 2;
                if (videoView.mOnPreparedListener != null) {
                    VideoView.this.mOnPreparedListener.onPrepared(VideoView.this.mMediaPlayer);
                }
                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                int i = VideoView.this.mSeekWhenPrepared;
                if (i != 0) {
                    VideoView.this.seekTo(i);
                }
                if (VideoView.this.mVideoWidth != 0 && VideoView.this.mVideoHeight != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.mVideoWidth, VideoView.this.mVideoHeight);
                    if (VideoView.this.mSurfaceWidth != VideoView.this.mVideoWidth || VideoView.this.mSurfaceHeight != VideoView.this.mVideoHeight) {
                        return;
                    }
                    if (VideoView.this.mTargetState == 3) {
                        VideoView.this.start();
                    } else if (!VideoView.this.isPlaying() && i == 0 && VideoView.this.getCurrentPosition() <= 0) {
                    }
                } else if (VideoView.this.mTargetState == 3) {
                    VideoView.this.start();
                }
            }
        };
        this.mCompletionListener = new MediaPlayer.OnCompletionListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass3 */

            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoView videoView = VideoView.this;
                videoView.mCurrentState = 5;
                videoView.mTargetState = 5;
                if (videoView.mOnCompletionListener != null) {
                    VideoView.this.mOnCompletionListener.onCompletion(VideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new MediaPlayer.OnInfoListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass4 */

            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoView.this.mOnInfoListener == null) {
                    return true;
                }
                VideoView.this.mOnInfoListener.onInfo(mediaPlayer, i, i2);
                return true;
            }
        };
        this.mErrorListener = new MediaPlayer.OnErrorListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass5 */

            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                String str = VideoView.this.TAG;
                gsy.O000000o(3, str, "Error: " + i + "," + i2);
                VideoView videoView = VideoView.this;
                videoView.mCurrentState = -1;
                videoView.mTargetState = -1;
                if (videoView.mOnErrorListener == null || VideoView.this.mOnErrorListener.onError(VideoView.this.mMediaPlayer, i, i2)) {
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass6 */

            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                VideoView.this.mCurrentBufferPercentage = i;
            }
        };
        this.mSHCallback = new SurfaceHolder.Callback() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass7 */

            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                VideoView videoView = VideoView.this;
                videoView.mSurfaceWidth = i2;
                videoView.mSurfaceHeight = i3;
                boolean z = true;
                boolean z2 = videoView.mTargetState == 3;
                if (!(VideoView.this.mVideoWidth == i2 && VideoView.this.mVideoHeight == i3)) {
                    z = false;
                }
                if (VideoView.this.mMediaPlayer != null && z2 && z) {
                    if (VideoView.this.mSeekWhenPrepared != 0) {
                        VideoView videoView2 = VideoView.this;
                        videoView2.seekTo(videoView2.mSeekWhenPrepared);
                    }
                    VideoView.this.start();
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView videoView = VideoView.this;
                videoView.mSurfaceHolder = surfaceHolder;
                videoView.openVideo();
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView videoView = VideoView.this;
                videoView.mSurfaceHolder = null;
                videoView.release(true);
            }
        };
        initVideoView();
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        initVideoView();
    }

    @TargetApi(21)
    public VideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public VideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.TAG = "VideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass1 */

            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (VideoView.this.mVideoWidth != 0 && VideoView.this.mVideoHeight != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.mVideoWidth, VideoView.this.mVideoHeight);
                    VideoView.this.requestLayout();
                }
            }
        };
        this.mPreparedListener = new MediaPlayer.OnPreparedListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass2 */

            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoView videoView = VideoView.this;
                videoView.mCurrentState = 2;
                if (videoView.mOnPreparedListener != null) {
                    VideoView.this.mOnPreparedListener.onPrepared(VideoView.this.mMediaPlayer);
                }
                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                int i = VideoView.this.mSeekWhenPrepared;
                if (i != 0) {
                    VideoView.this.seekTo(i);
                }
                if (VideoView.this.mVideoWidth != 0 && VideoView.this.mVideoHeight != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.mVideoWidth, VideoView.this.mVideoHeight);
                    if (VideoView.this.mSurfaceWidth != VideoView.this.mVideoWidth || VideoView.this.mSurfaceHeight != VideoView.this.mVideoHeight) {
                        return;
                    }
                    if (VideoView.this.mTargetState == 3) {
                        VideoView.this.start();
                    } else if (!VideoView.this.isPlaying() && i == 0 && VideoView.this.getCurrentPosition() <= 0) {
                    }
                } else if (VideoView.this.mTargetState == 3) {
                    VideoView.this.start();
                }
            }
        };
        this.mCompletionListener = new MediaPlayer.OnCompletionListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass3 */

            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoView videoView = VideoView.this;
                videoView.mCurrentState = 5;
                videoView.mTargetState = 5;
                if (videoView.mOnCompletionListener != null) {
                    VideoView.this.mOnCompletionListener.onCompletion(VideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new MediaPlayer.OnInfoListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass4 */

            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoView.this.mOnInfoListener == null) {
                    return true;
                }
                VideoView.this.mOnInfoListener.onInfo(mediaPlayer, i, i2);
                return true;
            }
        };
        this.mErrorListener = new MediaPlayer.OnErrorListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass5 */

            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                String str = VideoView.this.TAG;
                gsy.O000000o(3, str, "Error: " + i + "," + i2);
                VideoView videoView = VideoView.this;
                videoView.mCurrentState = -1;
                videoView.mTargetState = -1;
                if (videoView.mOnErrorListener == null || VideoView.this.mOnErrorListener.onError(VideoView.this.mMediaPlayer, i, i2)) {
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass6 */

            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                VideoView.this.mCurrentBufferPercentage = i;
            }
        };
        this.mSHCallback = new SurfaceHolder.Callback() {
            /* class com.xiaomi.smarthome.camera.view.VideoView.AnonymousClass7 */

            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                VideoView videoView = VideoView.this;
                videoView.mSurfaceWidth = i2;
                videoView.mSurfaceHeight = i3;
                boolean z = true;
                boolean z2 = videoView.mTargetState == 3;
                if (!(VideoView.this.mVideoWidth == i2 && VideoView.this.mVideoHeight == i3)) {
                    z = false;
                }
                if (VideoView.this.mMediaPlayer != null && z2 && z) {
                    if (VideoView.this.mSeekWhenPrepared != 0) {
                        VideoView videoView2 = VideoView.this;
                        videoView2.seekTo(videoView2.mSeekWhenPrepared);
                    }
                    VideoView.this.start();
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView videoView = VideoView.this;
                videoView.mSurfaceHolder = surfaceHolder;
                videoView.openVideo();
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView videoView = VideoView.this;
                videoView.mSurfaceHolder = null;
                videoView.release(true);
            }
        };
        initVideoView();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int defaultSize = getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = getDefaultSize(this.mVideoHeight, i2);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int mode = View.MeasureSpec.getMode(i);
            i3 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i5 = this.mVideoWidth;
                int i6 = i5 * size;
                int i7 = this.mVideoHeight;
                if (i6 < i3 * i7) {
                    defaultSize = (i5 * size) / i7;
                    defaultSize2 = size;
                } else if (i5 * size > i3 * i7) {
                    i4 = (i7 * i3) / i5;
                    setMeasuredDimension(i3, i4);
                }
            } else if (mode == 1073741824) {
                int i8 = (this.mVideoHeight * i3) / this.mVideoWidth;
                if (mode2 != Integer.MIN_VALUE || i8 <= size) {
                    i4 = i8;
                    setMeasuredDimension(i3, i4);
                }
            } else if (mode2 == 1073741824) {
                int i9 = (this.mVideoWidth * size) / this.mVideoHeight;
                if (mode != Integer.MIN_VALUE || i9 <= i3) {
                    i3 = i9;
                }
            } else {
                int i10 = this.mVideoWidth;
                int i11 = this.mVideoHeight;
                if (mode2 != Integer.MIN_VALUE || i11 <= size) {
                    i4 = i11;
                } else {
                    i10 = (i10 * size) / i11;
                    i4 = size;
                }
                if (mode != Integer.MIN_VALUE || i10 <= i3) {
                    i3 = i10;
                } else {
                    i4 = (this.mVideoHeight * i3) / this.mVideoWidth;
                }
                setMeasuredDimension(i3, i4);
            }
            i4 = size;
            setMeasuredDimension(i3, i4);
        }
        i3 = defaultSize;
        setMeasuredDimension(i3, i4);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(VideoView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(VideoView.class.getName());
    }

    public int resolveAdjustedSize(int i, int i2) {
        return getDefaultSize(i, i2);
    }

    private void initVideoView() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.mSHCallback);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    public void openVideo() {
        if (this.mUri != null && this.mSurfaceHolder != null) {
            ((AudioManager) getContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
            release(false);
            try {
                this.mMediaPlayer = new MediaPlayer();
                if (this.mAudioSession != 0) {
                    this.mMediaPlayer.setAudioSessionId(this.mAudioSession);
                } else {
                    this.mAudioSession = this.mMediaPlayer.getAudioSessionId();
                }
                this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
                this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
                this.mCurrentBufferPercentage = 0;
                this.mMediaPlayer.setDataSource(getContext(), this.mUri, this.mHeaders);
                this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mMediaPlayer.prepareAsync();
                this.mCurrentState = 1;
            } catch (IOException e) {
                String str = this.TAG;
                Log.w(str, "Unable to open content: " + this.mUri, e);
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            } catch (IllegalArgumentException e2) {
                String str2 = this.TAG;
                Log.w(str2, "Unable to open content: " + this.mUri, e2);
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void release(boolean z) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            if (z) {
                this.mTargetState = 0;
            }
        }
    }

    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    public void suspend() {
        release(false);
    }

    public void resume() {
        openVideo();
    }

    public int getDuration() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo(i);
            this.mSeekWhenPrepared = 0;
            return;
        }
        this.mSeekWhenPrepared = i;
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    private boolean isInPlaybackState() {
        int i;
        return (this.mMediaPlayer == null || (i = this.mCurrentState) == -1 || i == 0 || i == 1) ? false : true;
    }

    public int getAudioSessionId() {
        if (this.mAudioSession == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mAudioSession = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.mAudioSession;
    }
}
