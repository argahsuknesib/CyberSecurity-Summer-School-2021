package com.mijia.generalplayer.exo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.video.VideoListener;
import com.xiaomi.smarthome.R;
import java.util.List;

public class MJExoPlayerViewP extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public final AspectRatioFrameLayout f5192O000000o;
    public final View O00000Oo;
    public int O00000o;
    public boolean O00000o0;
    public O00000Oo O00000oO;
    public O00000o0 O00000oo;
    private final O000000o O0000O0o;
    private Player O0000OOo;
    private boolean O0000Oo;
    private boolean O0000Oo0;
    private Bitmap O0000OoO;
    private boolean O0000Ooo;
    private boolean O0000o;
    private ErrorMessageProvider<? super ExoPlaybackException> O0000o0;
    private boolean O0000o00;
    private int O0000o0O;
    private boolean O0000o0o;

    public interface O00000Oo {
        void onRenderedFirstFrame();

        void onVideoSizeChanged(int i, int i2, int i3, float f);
    }

    public interface O00000o0 {
        void O000000o();

        void O000000o(int i, int i2, int i3, float f);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public FrameLayout getOverlayFrameLayout() {
        return null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher) {
    }

    public void setControllerHideOnTouch(boolean z) {
    }

    public void setControllerShowTimeoutMs(int i) {
    }

    public void setControllerVisibilityListener(PlayerControlView.VisibilityListener visibilityListener) {
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
    }

    public void setFastForwardIncrementMs(int i) {
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer) {
    }

    public void setRepeatToggleModes(int i) {
    }

    public void setRewindIncrementMs(int i) {
    }

    public void setShowMultiWindowTimeBar(boolean z) {
    }

    public void setShowShuffleButton(boolean z) {
    }

    public void setShutterBackgroundColor(int i) {
    }

    public void setUseArtwork(boolean z) {
    }

    public void setUseController(boolean z) {
    }

    public void setExoPlayerBridgeListener(O00000Oo o00000Oo) {
        this.O00000oO = o00000Oo;
    }

    public O00000Oo getExoPlayerBridgeListener() {
        return this.O00000oO;
    }

    public void setPlayerViewListener(O00000o0 o00000o0) {
        this.O00000oo = o00000o0;
    }

    public O00000o0 getPlayerViewListener() {
        return this.O00000oo;
    }

    public MJExoPlayerViewP(Context context) {
        this(context, null);
    }

    public MJExoPlayerViewP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MJExoPlayerViewP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        int i3;
        if (isInEditMode()) {
            this.f5192O000000o = null;
            this.O00000Oo = null;
            this.O0000O0o = null;
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.ad_marker_color, R.attr.ad_marker_width, R.attr.auto_show, R.attr.bar_height, R.attr.buffered_color, R.attr.controller_layout_id, R.attr.default_artwork, R.attr.fastforward_increment, R.attr.hide_during_ads, R.attr.hide_on_touch, R.attr.keep_content_on_player_reset, R.attr.played_ad_marker_color, R.attr.played_color, R.attr.player_layout_id, R.attr.repeat_toggle_modes, R.attr.resize_mode, R.attr.rewind_increment, R.attr.scrubber_color, R.attr.scrubber_disabled_size, R.attr.scrubber_dragged_size, R.attr.scrubber_drawable, R.attr.scrubber_enabled_size, R.attr.show_buffering, R.attr.show_shuffle_button, R.attr.show_timeout, R.attr.shutter_background_color, R.attr.surface_type, R.attr.time_bar_min_update_interval, R.attr.touch_target_height, R.attr.unplayed_color, R.attr.use_artwork, R.attr.use_controller, R.attr.use_sensor_rotation}, 0, 0);
            try {
                obtainStyledAttributes.hasValue(25);
                obtainStyledAttributes.getColor(25, 0);
                obtainStyledAttributes.getResourceId(13, R.layout.exo_player_view);
                obtainStyledAttributes.getBoolean(30, true);
                obtainStyledAttributes.getResourceId(6, 0);
                obtainStyledAttributes.getBoolean(31, true);
                i3 = obtainStyledAttributes.getInt(26, 2);
                i2 = obtainStyledAttributes.getInt(15, 0);
                obtainStyledAttributes.getInt(24, 5000);
                obtainStyledAttributes.getBoolean(9, true);
                obtainStyledAttributes.getBoolean(2, true);
                obtainStyledAttributes.getBoolean(22, false);
                this.O0000o00 = obtainStyledAttributes.getBoolean(10, this.O0000o00);
                obtainStyledAttributes.getBoolean(8, true);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            i3 = 2;
            i2 = 0;
        }
        this.O0000O0o = new O000000o(this, (byte) 0);
        setDescendantFocusability(262144);
        this.f5192O000000o = new AspectRatioFrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f5192O000000o, layoutParams);
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f5192O000000o;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i2);
        }
        if (i3 != 0) {
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            this.O00000Oo = i3 == 2 ? new TextureView(context) : new SurfaceView(context);
            this.O00000Oo.setLayoutParams(layoutParams2);
            this.f5192O000000o.addView(this.O00000Oo, 0);
            return;
        }
        this.O00000Oo = null;
    }

    public Player getPlayer() {
        return this.O0000OOo;
    }

    public void setPlayer(Player player) {
        Player player2 = this.O0000OOo;
        if (player2 != player) {
            if (player2 != null) {
                player2.removeListener(this.O0000O0o);
                Player.VideoComponent videoComponent = this.O0000OOo.getVideoComponent();
                if (videoComponent != null) {
                    videoComponent.removeVideoListener(this.O0000O0o);
                    View view = this.O00000Oo;
                    if (view instanceof TextureView) {
                        videoComponent.clearVideoTextureView((TextureView) view);
                    } else if (view instanceof SurfaceView) {
                        videoComponent.clearVideoSurfaceView((SurfaceView) view);
                    }
                }
                Player.TextComponent textComponent = this.O0000OOo.getTextComponent();
                if (textComponent != null) {
                    textComponent.removeTextOutput(this.O0000O0o);
                }
            }
            this.O0000OOo = player;
            O00000o0();
            if (player != null) {
                Player.VideoComponent videoComponent2 = player.getVideoComponent();
                if (videoComponent2 != null) {
                    View view2 = this.O00000Oo;
                    if (view2 instanceof TextureView) {
                        videoComponent2.setVideoTextureView((TextureView) view2);
                    } else if (view2 instanceof SurfaceView) {
                        videoComponent2.setVideoSurfaceView((SurfaceView) view2);
                    }
                    videoComponent2.addVideoListener(this.O0000O0o);
                }
                Player.TextComponent textComponent2 = player.getTextComponent();
                if (textComponent2 != null) {
                    textComponent2.addTextOutput(this.O0000O0o);
                }
                player.addListener(this.O0000O0o);
                O000000o();
            }
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.O00000Oo;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        Assertions.checkState(this.f5192O000000o != null);
        this.f5192O000000o.setResizeMode(i);
    }

    public int getResizeMode() {
        Assertions.checkState(this.f5192O000000o != null);
        return this.f5192O000000o.getResizeMode();
    }

    public boolean getUseArtwork() {
        return this.O0000Oo;
    }

    public Bitmap getDefaultArtwork() {
        return this.O0000OoO;
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        if (this.O0000OoO != bitmap) {
            this.O0000OoO = bitmap;
            O00000o0();
        }
    }

    public boolean getUseController() {
        return this.O0000Oo0;
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.O0000o00 != z) {
            this.O0000o00 = z;
            O00000o0();
        }
    }

    public void setShowBuffering(boolean z) {
        if (this.O0000Ooo != z) {
            this.O0000Ooo = z;
        }
    }

    public void setErrorMessageProvider(ErrorMessageProvider<? super ExoPlaybackException> errorMessageProvider) {
        if (this.O0000o0 != errorMessageProvider) {
            this.O0000o0 = errorMessageProvider;
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.O0000o0O;
    }

    public boolean getControllerHideOnTouch() {
        return this.O0000o;
    }

    public boolean getControllerAutoShow() {
        return this.O0000o0o;
    }

    public void setControllerAutoShow(boolean z) {
        this.O0000o0o = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.O00000o0 = z;
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.checkState(this.f5192O000000o != null);
        this.f5192O000000o.setAspectRatioListener(aspectRatioListener);
    }

    public View getVideoSurfaceView() {
        return this.O00000Oo;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.O0000Oo0 || this.O0000OOo == null) {
            return false;
        }
        O000000o();
        return true;
    }

    public final void O000000o() {
        if (!O00000Oo() || this.O00000o0) {
        }
    }

    public final boolean O00000Oo() {
        Player player = this.O0000OOo;
        return player != null && player.isPlayingAd() && this.O0000OOo.getPlayWhenReady();
    }

    public final void O00000o0() {
        Player player = this.O0000OOo;
        if (player != null && !player.getCurrentTrackGroups().isEmpty()) {
            TrackSelectionArray currentTrackSelections = this.O0000OOo.getCurrentTrackSelections();
            int i = 0;
            while (i < currentTrackSelections.length) {
                if (this.O0000OOo.getRendererType(i) != 2 || currentTrackSelections.get(i) == null) {
                    i++;
                } else {
                    return;
                }
            }
            if (this.O0000Oo) {
                for (int i2 = 0; i2 < currentTrackSelections.length; i2++) {
                    TrackSelection trackSelection = currentTrackSelections.get(i2);
                    if (trackSelection != null) {
                        int i3 = 0;
                        while (i3 < trackSelection.length()) {
                            Metadata metadata = trackSelection.getFormat(i3).metadata;
                            if (metadata == null || !O000000o(metadata)) {
                                i3++;
                            } else {
                                return;
                            }
                        }
                        continue;
                    }
                }
                if (O000000o(this.O0000OoO)) {
                }
            }
        }
    }

    private boolean O000000o(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) entry).pictureData;
                return O000000o(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
        }
        return false;
    }

    private boolean O000000o(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return false;
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f5192O000000o;
        if (aspectRatioFrameLayout == null) {
            return true;
        }
        aspectRatioFrameLayout.setAspectRatio(((float) width) / ((float) height));
        return true;
    }

    public static void O000000o(TextureView textureView, int i) {
        float width = (float) textureView.getWidth();
        float height = (float) textureView.getHeight();
        if (width == 0.0f || height == 0.0f || i == 0) {
            textureView.setTransform(null);
            return;
        }
        Matrix matrix = new Matrix();
        float f = width / 2.0f;
        float f2 = height / 2.0f;
        matrix.postRotate((float) i, f, f2);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        textureView.setTransform(matrix);
    }

    final class O000000o extends Player.DefaultEventListener implements View.OnLayoutChangeListener, TextOutput, VideoListener {
        public final void onCues(List<Cue> list) {
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
        }

        @Deprecated
        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onLoadingChanged(this, z);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
        }

        @Deprecated
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
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

        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
        }

        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
        }

        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            VideoListener.CC.$default$onSurfaceSizeChanged(this, i, i2);
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(MJExoPlayerViewP mJExoPlayerViewP, byte b) {
            this();
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, float f) {
            if (MJExoPlayerViewP.this.O00000oO != null) {
                MJExoPlayerViewP.this.O00000oO.onVideoSizeChanged(i, i2, i3, f);
            }
            if (MJExoPlayerViewP.this.O00000oo != null) {
                MJExoPlayerViewP.this.O00000oo.O000000o(i, i2, i3, f);
            }
            if (MJExoPlayerViewP.this.f5192O000000o != null) {
                float f2 = (i2 == 0 || i == 0) ? 1.0f : (((float) i) * f) / ((float) i2);
                if (MJExoPlayerViewP.this.O00000Oo instanceof TextureView) {
                    if (i3 == 90 || i3 == 270) {
                        f2 = 1.0f / f2;
                    }
                    if (MJExoPlayerViewP.this.O00000o != 0) {
                        MJExoPlayerViewP.this.O00000Oo.removeOnLayoutChangeListener(this);
                    }
                    MJExoPlayerViewP mJExoPlayerViewP = MJExoPlayerViewP.this;
                    mJExoPlayerViewP.O00000o = i3;
                    if (mJExoPlayerViewP.O00000o != 0) {
                        MJExoPlayerViewP.this.O00000Oo.addOnLayoutChangeListener(this);
                    }
                    MJExoPlayerViewP.O000000o((TextureView) MJExoPlayerViewP.this.O00000Oo, MJExoPlayerViewP.this.O00000o);
                }
                MJExoPlayerViewP.this.f5192O000000o.setAspectRatio(f2);
            }
        }

        public final void onRenderedFirstFrame() {
            if (MJExoPlayerViewP.this.O00000oO != null) {
                MJExoPlayerViewP.this.O00000oO.onRenderedFirstFrame();
            }
            if (MJExoPlayerViewP.this.O00000oo != null) {
                MJExoPlayerViewP.this.O00000oo.O000000o();
            }
        }

        public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            MJExoPlayerViewP.this.O00000o0();
        }

        public final void onPlayerStateChanged(boolean z, int i) {
            if (!MJExoPlayerViewP.this.O00000Oo() || !MJExoPlayerViewP.this.O00000o0) {
                MJExoPlayerViewP.this.O000000o();
            }
        }

        public final void onPositionDiscontinuity(int i) {
            MJExoPlayerViewP.this.O00000Oo();
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            MJExoPlayerViewP.O000000o((TextureView) view, MJExoPlayerViewP.this.O00000o);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
