package com.brentvatne.exoplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.video.VideoListener;
import java.util.List;

@TargetApi(16)
public final class ExoPlayerView extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public final View f3567O000000o;
    public final SubtitleView O00000Oo;
    SimpleExoPlayer O00000o;
    public final AspectRatioFrameLayout O00000o0;
    public final Runnable O00000oO;
    private View O00000oo;
    private final O000000o O0000O0o;
    private Context O0000OOo;
    private boolean O0000Oo;
    private ViewGroup.LayoutParams O0000Oo0;
    private boolean O0000OoO;

    public ExoPlayerView(Context context) {
        this(context, null);
    }

    public ExoPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExoPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Oo = true;
        this.O0000OoO = false;
        this.O00000oO = new Runnable() {
            /* class com.brentvatne.exoplayer.ExoPlayerView.AnonymousClass1 */

            public final void run() {
                ExoPlayerView exoPlayerView = ExoPlayerView.this;
                exoPlayerView.measure(View.MeasureSpec.makeMeasureSpec(exoPlayerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ExoPlayerView.this.getHeight(), 1073741824));
                ExoPlayerView exoPlayerView2 = ExoPlayerView.this;
                exoPlayerView2.layout(exoPlayerView2.getLeft(), ExoPlayerView.this.getTop(), ExoPlayerView.this.getRight(), ExoPlayerView.this.getBottom());
            }
        };
        this.O0000OOo = context;
        this.O0000Oo0 = new ViewGroup.LayoutParams(-1, -1);
        this.O0000O0o = new O000000o(this, (byte) 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.O00000o0 = new AspectRatioFrameLayout(context);
        this.O00000o0.setLayoutParams(layoutParams);
        this.f3567O000000o = new View(getContext());
        this.f3567O000000o.setLayoutParams(this.O0000Oo0);
        this.f3567O000000o.setBackgroundColor(ContextCompat.O00000o0(context, 17170444));
        this.O00000Oo = new SubtitleView(context);
        this.O00000Oo.setLayoutParams(this.O0000Oo0);
        this.O00000Oo.setUserDefaultStyle();
        this.O00000Oo.setUserDefaultTextSize();
        O00000Oo();
        this.O00000o0.addView(this.f3567O000000o, 1, this.O0000Oo0);
        this.O00000o0.addView(this.O00000Oo, 2, this.O0000Oo0);
        addViewInLayout(this.O00000o0, 0, layoutParams);
    }

    private void O000000o() {
        View view = this.O00000oo;
        if (view instanceof TextureView) {
            this.O00000o.setVideoTextureView((TextureView) view);
        } else if (view instanceof SurfaceView) {
            this.O00000o.setVideoSurfaceView((SurfaceView) view);
        }
    }

    private void O00000Oo() {
        View textureView = this.O0000Oo ? new TextureView(this.O0000OOo) : new SurfaceView(this.O0000OOo);
        textureView.setLayoutParams(this.O0000Oo0);
        this.O00000oo = textureView;
        if (this.O00000o0.getChildAt(0) != null) {
            this.O00000o0.removeViewAt(0);
        }
        this.O00000o0.addView(this.O00000oo, 0, this.O0000Oo0);
        if (this.O00000o != null) {
            O000000o();
        }
    }

    public final void setPlayer(SimpleExoPlayer simpleExoPlayer) {
        SimpleExoPlayer simpleExoPlayer2 = this.O00000o;
        if (simpleExoPlayer2 != simpleExoPlayer) {
            if (simpleExoPlayer2 != null) {
                simpleExoPlayer2.setTextOutput(null);
                this.O00000o.setVideoListener(null);
                this.O00000o.removeListener(this.O0000O0o);
                this.O00000o.setVideoSurface(null);
            }
            this.O00000o = simpleExoPlayer;
            this.f3567O000000o.setVisibility(0);
            if (simpleExoPlayer != null) {
                O000000o();
                simpleExoPlayer.setVideoListener(this.O0000O0o);
                simpleExoPlayer.addListener(this.O0000O0o);
                simpleExoPlayer.setTextOutput(this.O0000O0o);
            }
        }
    }

    public final void setResizeMode(int i) {
        if (this.O00000o0.getResizeMode() != i) {
            this.O00000o0.setResizeMode(i);
            post(this.O00000oO);
        }
    }

    public final View getVideoSurfaceView() {
        return this.O00000oo;
    }

    public final void setUseTextureView(boolean z) {
        if (z != this.O0000Oo) {
            this.O0000Oo = z;
            O00000Oo();
        }
    }

    public final void setHideShutterView(boolean z) {
        this.O0000OoO = z;
        this.f3567O000000o.setVisibility(this.O0000OoO ? 4 : 0);
    }

    final class O000000o implements Player.EventListener, SimpleExoPlayer.VideoListener, TextOutput {
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
        }

        public final void onLoadingChanged(boolean z) {
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
        }

        public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        }

        public /* synthetic */ void onPlaybackSpeedChanged(float f) {
            Player.EventListener.CC.$default$onPlaybackSpeedChanged(this, f);
        }

        public /* synthetic */ void onPlaybackStateChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        public final void onPlayerError(ExoPlaybackException exoPlaybackException) {
        }

        public final void onPlayerStateChanged(boolean z, int i) {
        }

        public final void onPositionDiscontinuity(int i) {
        }

        public final void onRepeatModeChanged(int i) {
        }

        public final void onSeekProcessed() {
        }

        public final void onShuffleModeEnabledChanged(boolean z) {
        }

        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            VideoListener.CC.$default$onSurfaceSizeChanged(this, i, i2);
        }

        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
        }

        public final void onTimelineChanged(Timeline timeline, Object obj, int i) {
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(ExoPlayerView exoPlayerView, byte b) {
            this();
        }

        public final void onCues(List<Cue> list) {
            ExoPlayerView.this.O00000Oo.onCues(list);
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, float f) {
            boolean z = ExoPlayerView.this.O00000o0.getAspectRatio() == 0.0f;
            ExoPlayerView.this.O00000o0.setAspectRatio(i2 == 0 ? 1.0f : (((float) i) * f) / ((float) i2));
            if (z) {
                ExoPlayerView exoPlayerView = ExoPlayerView.this;
                exoPlayerView.post(exoPlayerView.O00000oO);
            }
        }

        public final void onRenderedFirstFrame() {
            ExoPlayerView.this.f3567O000000o.setVisibility(4);
        }

        public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            ExoPlayerView exoPlayerView = ExoPlayerView.this;
            if (exoPlayerView.O00000o != null) {
                TrackSelectionArray currentTrackSelections = exoPlayerView.O00000o.getCurrentTrackSelections();
                int i = 0;
                while (i < currentTrackSelections.length) {
                    if (exoPlayerView.O00000o.getRendererType(i) != 2 || currentTrackSelections.get(i) == null) {
                        i++;
                    } else {
                        return;
                    }
                }
                exoPlayerView.f3567O000000o.setVisibility(0);
            }
        }
    }
}
