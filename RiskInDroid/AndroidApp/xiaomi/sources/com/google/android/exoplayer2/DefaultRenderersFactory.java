package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {
    private long allowedVideoJoiningTimeMs;
    private final Context context;
    private boolean enableDecoderFallback;
    private int extensionRendererMode;
    private int mediaCodecOperationMode;
    private MediaCodecSelector mediaCodecSelector;
    private VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    /* access modifiers changed from: protected */
    public void buildMiscellaneousRenderers(Context context2, Handler handler, int i, ArrayList<Renderer> arrayList) {
    }

    public DefaultRenderersFactory(Context context2, VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer2) {
        this(context2);
        this.videoDecoderOutputBufferRenderer = videoDecoderOutputBufferRenderer2;
    }

    public DefaultRenderersFactory(Context context2) {
        this.context = context2;
        this.extensionRendererMode = 0;
        this.allowedVideoJoiningTimeMs = 5000;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
        this.mediaCodecOperationMode = 0;
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, int i) {
        this(context2, i, 5000);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, int i, long j) {
        this.context = context2;
        this.extensionRendererMode = i;
        this.allowedVideoJoiningTimeMs = j;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int i) {
        this.extensionRendererMode = i;
        return this;
    }

    public DefaultRenderersFactory experimental_setMediaCodecOperationMode(int i) {
        this.mediaCodecOperationMode = i;
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean z) {
        this.enableDecoderFallback = z;
        return this;
    }

    public DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector2) {
        this.mediaCodecSelector = mediaCodecSelector2;
        return this;
    }

    public DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j) {
        this.allowedVideoJoiningTimeMs = j;
        return this;
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, handler, videoRendererEventListener, this.allowedVideoJoiningTimeMs, arrayList);
        buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, buildAudioProcessors(), handler, audioRendererEventListener, arrayList);
        ArrayList arrayList2 = arrayList;
        buildTextRenderers(this.context, textOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildMetadataRenderers(this.context, metadataOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList);
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0073, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007b, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c4, code lost:
        throw new java.lang.RuntimeException("Error instantiating AV1 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0073 A[ExcHandler: Exception (r0v9 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bc A[ExcHandler: Exception (r0v8 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:19:0x007f] */
    public void buildVideoRenderers(Context context2, int i, MediaCodecSelector mediaCodecSelector2, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, long j, ArrayList<Renderer> arrayList) {
        int i2;
        int i3;
        int i4 = i;
        ArrayList<Renderer> arrayList2 = arrayList;
        MediaCodecVideoRenderer mediaCodecVideoRenderer = new MediaCodecVideoRenderer(context2, mediaCodecSelector2, j, z, handler, videoRendererEventListener, 50);
        mediaCodecVideoRenderer.experimental_setMediaCodecOperationMode(this.mediaCodecOperationMode);
        arrayList2.add(mediaCodecVideoRenderer);
        if (i4 != 0) {
            int size = arrayList.size();
            if (i4 == 2) {
                size--;
            }
            try {
                i2 = size + 1;
                arrayList2.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                Log.i("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException unused) {
                i2 = size;
            } catch (Exception e) {
            }
            try {
                i3 = i2 + 1;
                arrayList2.add(i2, (Renderer) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                Log.i("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
            } catch (ClassNotFoundException unused2) {
                i3 = i2;
            } catch (Exception e2) {
            }
            try {
                arrayList2.add(i3, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE, VideoDecoderOutputBufferRenderer.class).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50, this.videoDecoderOutputBufferRenderer));
                Log.i("DefaultRenderersFactory", "Loaded FfmpegVideoRenderer.");
            } catch (ClassNotFoundException unused3) {
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e3);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0067, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00aa, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0067 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:19:0x0073] */
    public void buildAudioRenderers(Context context2, int i, MediaCodecSelector mediaCodecSelector2, boolean z, AudioProcessor[] audioProcessorArr, Handler handler, AudioRendererEventListener audioRendererEventListener, ArrayList<Renderer> arrayList) {
        int i2;
        int i3;
        int i4 = i;
        AudioProcessor[] audioProcessorArr2 = audioProcessorArr;
        ArrayList<Renderer> arrayList2 = arrayList;
        MediaCodecAudioRenderer mediaCodecAudioRenderer = new MediaCodecAudioRenderer(context2, mediaCodecSelector2, z, handler, audioRendererEventListener, new DefaultAudioSink(AudioCapabilities.getCapabilities(context2), audioProcessorArr2));
        mediaCodecAudioRenderer.experimental_setMediaCodecOperationMode(this.mediaCodecOperationMode);
        arrayList2.add(mediaCodecAudioRenderer);
        if (i4 != 0) {
            int size = arrayList.size();
            if (i4 == 2) {
                size--;
            }
            try {
                i2 = size + 1;
                arrayList2.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr2));
                Log.i("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
            } catch (ClassNotFoundException unused) {
                i2 = size;
            } catch (Exception e) {
            }
            try {
                i3 = i2 + 1;
                arrayList2.add(i2, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr2));
                Log.i("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
            } catch (ClassNotFoundException unused2) {
                i3 = i2;
            } catch (Exception e2) {
            }
            try {
                arrayList2.add(i3, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr2));
                Log.i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
            } catch (ClassNotFoundException unused3) {
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void buildTextRenderers(Context context2, TextOutput textOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildMetadataRenderers(Context context2, MetadataOutput metadataOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildCameraMotionRenderers(Context context2, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    /* access modifiers changed from: protected */
    public AudioProcessor[] buildAudioProcessors() {
        return new AudioProcessor[0];
    }
}
