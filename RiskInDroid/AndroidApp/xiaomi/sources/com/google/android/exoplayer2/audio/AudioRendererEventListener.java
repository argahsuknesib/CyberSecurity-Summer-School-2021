package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public interface AudioRendererEventListener {

    /* renamed from: com.google.android.exoplayer2.audio.AudioRendererEventListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAudioDecoderInitialized(AudioRendererEventListener audioRendererEventListener, String str, long j, long j2) {
        }

        public static void $default$onAudioDisabled(AudioRendererEventListener audioRendererEventListener, DecoderCounters decoderCounters) {
        }

        public static void $default$onAudioEnabled(AudioRendererEventListener audioRendererEventListener, DecoderCounters decoderCounters) {
        }

        public static void $default$onAudioInputFormatChanged(AudioRendererEventListener audioRendererEventListener, Format format) {
        }

        public static void $default$onAudioSessionId(AudioRendererEventListener audioRendererEventListener, int i) {
        }

        public static void $default$onAudioSinkUnderrun(AudioRendererEventListener audioRendererEventListener, int i, long j, long j2) {
        }

        public static void $default$onSkipSilenceEnabledChanged(AudioRendererEventListener audioRendererEventListener, boolean z) {
        }
    }

    void onAudioDecoderInitialized(String str, long j, long j2);

    void onAudioDisabled(DecoderCounters decoderCounters);

    void onAudioEnabled(DecoderCounters decoderCounters);

    void onAudioInputFormatChanged(Format format);

    void onAudioSessionId(int i);

    void onAudioSinkUnderrun(int i, long j, long j2);

    void onSkipSilenceEnabledChanged(boolean z);

    public static final class EventDispatcher {
        private final Handler handler;
        private final AudioRendererEventListener listener;

        public EventDispatcher(Handler handler2, AudioRendererEventListener audioRendererEventListener) {
            this.handler = audioRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler2) : null;
            this.listener = audioRendererEventListener;
        }

        public final void enabled(DecoderCounters decoderCounters) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(decoderCounters) {
                    /* class com.google.android.exoplayer2.audio.$$Lambda$AudioRendererEventListener$EventDispatcher$MUMUaHcEfIpwDLi9gxmScOQxifc */
                    private final /* synthetic */ DecoderCounters f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$enabled$0$AudioRendererEventListener$EventDispatcher(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$enabled$0$AudioRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioEnabled(decoderCounters);
        }

        public final void decoderInitialized(String str, long j, long j2) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(str, j, j2) {
                    /* class com.google.android.exoplayer2.audio.$$Lambda$AudioRendererEventListener$EventDispatcher$F29t8_xYSK7h_6CpLRlp2y2yb1E */
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ long f$2;
                    private final /* synthetic */ long f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r5;
                    }

                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$decoderInitialized$1$AudioRendererEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$decoderInitialized$1$AudioRendererEventListener$EventDispatcher(String str, long j, long j2) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDecoderInitialized(str, j, j2);
        }

        public final void inputFormatChanged(Format format) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(format) {
                    /* class com.google.android.exoplayer2.audio.$$Lambda$AudioRendererEventListener$EventDispatcher$D7KvJbrpXrnWw4qzd_LI9ZtQytw */
                    private final /* synthetic */ Format f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$inputFormatChanged$2$AudioRendererEventListener$EventDispatcher(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$inputFormatChanged$2$AudioRendererEventListener$EventDispatcher(Format format) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioInputFormatChanged(format);
        }

        public final void audioTrackUnderrun(int i, long j, long j2) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(i, j, j2) {
                    /* class com.google.android.exoplayer2.audio.$$Lambda$AudioRendererEventListener$EventDispatcher$oPQKly422CpX1mqIU2N6d76OGxk */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ long f$2;
                    private final /* synthetic */ long f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r5;
                    }

                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$audioTrackUnderrun$3$AudioRendererEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$audioTrackUnderrun$3$AudioRendererEventListener$EventDispatcher(int i, long j, long j2) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioSinkUnderrun(i, j, j2);
        }

        public final void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(decoderCounters) {
                    /* class com.google.android.exoplayer2.audio.$$Lambda$AudioRendererEventListener$EventDispatcher$jb22FSnmUl2pGG0LguQS_WdLWk */
                    private final /* synthetic */ DecoderCounters f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$disabled$4$AudioRendererEventListener$EventDispatcher(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$disabled$4$AudioRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDisabled(decoderCounters);
        }

        public final void audioSessionId(int i) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(i) {
                    /* class com.google.android.exoplayer2.audio.$$Lambda$AudioRendererEventListener$EventDispatcher$a1B1YBHhPRCtc1MQAc2fSVEo22I */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$audioSessionId$5$AudioRendererEventListener$EventDispatcher(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$audioSessionId$5$AudioRendererEventListener$EventDispatcher(int i) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioSessionId(i);
        }

        public final void skipSilenceEnabledChanged(boolean z) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new Runnable(z) {
                    /* class com.google.android.exoplayer2.audio.$$Lambda$AudioRendererEventListener$EventDispatcher$eYq0akhJpQq4zlO6nT_M_J0xyK8 */
                    private final /* synthetic */ boolean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.lambda$skipSilenceEnabledChanged$6$AudioRendererEventListener$EventDispatcher(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$skipSilenceEnabledChanged$6$AudioRendererEventListener$EventDispatcher(boolean z) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onSkipSilenceEnabledChanged(z);
        }
    }
}
