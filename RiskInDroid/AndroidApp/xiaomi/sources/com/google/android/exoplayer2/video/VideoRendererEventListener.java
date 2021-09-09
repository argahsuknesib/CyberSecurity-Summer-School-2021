package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public interface VideoRendererEventListener {

    /* renamed from: com.google.android.exoplayer2.video.VideoRendererEventListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onDroppedFrames(VideoRendererEventListener videoRendererEventListener, int i, long j) {
        }

        public static void $default$onRenderedFirstFrame(VideoRendererEventListener videoRendererEventListener, Surface surface) {
        }

        public static void $default$onVideoDecoderInitialized(VideoRendererEventListener videoRendererEventListener, String str, long j, long j2) {
        }

        public static void $default$onVideoDisabled(VideoRendererEventListener videoRendererEventListener, DecoderCounters decoderCounters) {
        }

        public static void $default$onVideoEnabled(VideoRendererEventListener videoRendererEventListener, DecoderCounters decoderCounters) {
        }

        public static void $default$onVideoFrameProcessingOffset(VideoRendererEventListener videoRendererEventListener, long j, int i, Format format) {
        }

        public static void $default$onVideoInputFormatChanged(VideoRendererEventListener videoRendererEventListener, Format format) {
        }

        public static void $default$onVideoSizeChanged(VideoRendererEventListener videoRendererEventListener, int i, int i2, int i3, float f) {
        }
    }

    void onDroppedFrames(int i, long j);

    void onRenderedFirstFrame(Surface surface);

    void onVideoDecoderInitialized(String str, long j, long j2);

    void onVideoDisabled(DecoderCounters decoderCounters);

    void onVideoEnabled(DecoderCounters decoderCounters);

    void onVideoFrameProcessingOffset(long j, int i, Format format);

    void onVideoInputFormatChanged(Format format);

    void onVideoSizeChanged(int i, int i2, int i3, float f);

    public static final class EventDispatcher {
        private final Handler handler;
        private final VideoRendererEventListener listener;

        public EventDispatcher(Handler handler2, VideoRendererEventListener videoRendererEventListener) {
            this.handler = videoRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler2) : null;
            this.listener = videoRendererEventListener;
        }

        public final void enabled(DecoderCounters decoderCounters) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(decoderCounters) {
                    /* class com.google.android.exoplayer2.video.$$Lambda$VideoRendererEventListener$EventDispatcher$Zf6ofdxzBBJ5SL288lE0HglRj8g */
                    private final /* synthetic */ DecoderCounters f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$enabled$0$VideoRendererEventListener$EventDispatcher(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$enabled$0$VideoRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoEnabled(decoderCounters);
        }

        public final void decoderInitialized(String str, long j, long j2) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(str, j, j2) {
                    /* class com.google.android.exoplayer2.video.$$Lambda$VideoRendererEventListener$EventDispatcher$Y232CA7hogfrRJjYu2VeUSxg0VQ */
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ long f$2;
                    private final /* synthetic */ long f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r5;
                    }

                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$decoderInitialized$1$VideoRendererEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$decoderInitialized$1$VideoRendererEventListener$EventDispatcher(String str, long j, long j2) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDecoderInitialized(str, j, j2);
        }

        public final void inputFormatChanged(Format format) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(format) {
                    /* class com.google.android.exoplayer2.video.$$Lambda$VideoRendererEventListener$EventDispatcher$26y6c6BFFT4OL6bJiMmdsfxDEMQ */
                    private final /* synthetic */ Format f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$inputFormatChanged$2$VideoRendererEventListener$EventDispatcher(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$inputFormatChanged$2$VideoRendererEventListener$EventDispatcher(Format format) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoInputFormatChanged(format);
        }

        public final void droppedFrames(int i, long j) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(i, j) {
                    /* class com.google.android.exoplayer2.video.$$Lambda$VideoRendererEventListener$EventDispatcher$wpJzum9NimWREQi3I6t6RZgGzs */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ long f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$droppedFrames$3$VideoRendererEventListener$EventDispatcher(this.f$1, this.f$2);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$droppedFrames$3$VideoRendererEventListener$EventDispatcher(int i, long j) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onDroppedFrames(i, j);
        }

        public final void reportVideoFrameProcessingOffset(long j, int i, Format format) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(j, i, format) {
                    /* class com.google.android.exoplayer2.video.$$Lambda$VideoRendererEventListener$EventDispatcher$B3qrkzuSnbLMZskwympI9i06rI */
                    private final /* synthetic */ long f$1;
                    private final /* synthetic */ int f$2;
                    private final /* synthetic */ Format f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r4;
                        this.f$3 = r5;
                    }

                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$reportVideoFrameProcessingOffset$4$VideoRendererEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$reportVideoFrameProcessingOffset$4$VideoRendererEventListener$EventDispatcher(long j, int i, Format format) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoFrameProcessingOffset(j, i, format);
        }

        public final void videoSizeChanged(int i, int i2, int i3, float f) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(i, i2, i3, f) {
                    /* class com.google.android.exoplayer2.video.$$Lambda$VideoRendererEventListener$EventDispatcher$qX0rv_q0N3E3GHjBeTczrImBbkY */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ int f$2;
                    private final /* synthetic */ int f$3;
                    private final /* synthetic */ float f$4;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                    }

                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$videoSizeChanged$5$VideoRendererEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3, this.f$4);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$videoSizeChanged$5$VideoRendererEventListener$EventDispatcher(int i, int i2, int i3, float f) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoSizeChanged(i, i2, i3, f);
        }

        public final void renderedFirstFrame(Surface surface) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(surface) {
                    /* class com.google.android.exoplayer2.video.$$Lambda$VideoRendererEventListener$EventDispatcher$lvbB9ufxEWaRPUEgazOqCqG1o */
                    private final /* synthetic */ Surface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$renderedFirstFrame$6$VideoRendererEventListener$EventDispatcher(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$renderedFirstFrame$6$VideoRendererEventListener$EventDispatcher(Surface surface) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onRenderedFirstFrame(surface);
        }

        public final void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(decoderCounters) {
                    /* class com.google.android.exoplayer2.video.$$Lambda$VideoRendererEventListener$EventDispatcher$JliJEM2S4OsPp4P8Q67nSBnDxks */
                    private final /* synthetic */ DecoderCounters f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.this.lambda$disabled$7$VideoRendererEventListener$EventDispatcher(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$disabled$7$VideoRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDisabled(decoderCounters);
        }
    }
}
