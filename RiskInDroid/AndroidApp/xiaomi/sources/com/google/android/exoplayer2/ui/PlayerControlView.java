package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerControlView extends FrameLayout {
    private long[] adGroupTimesMs;
    private final float buttonAlphaDisabled;
    private final float buttonAlphaEnabled;
    private final ComponentListener componentListener;
    public ControlDispatcher controlDispatcher;
    private long currentWindowOffset;
    private final TextView durationView;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;
    public final View fastForwardButton;
    public final StringBuilder formatBuilder;
    public final Formatter formatter;
    private final Runnable hideAction;
    private long hideAtMs;
    private boolean isAttachedToWindow;
    private boolean multiWindowTimeBar;
    public final View nextButton;
    public final View pauseButton;
    private final Timeline.Period period;
    public final View playButton;
    public PlaybackPreparer playbackPreparer;
    private boolean[] playedAdGroups;
    public Player player;
    public final TextView positionView;
    public final View previousButton;
    private ProgressUpdateListener progressUpdateListener;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;
    public final ImageView repeatToggleButton;
    public int repeatToggleModes;
    public final View rewindButton;
    public boolean scrubbing;
    private boolean showMultiWindowTimeBar;
    private boolean showShuffleButton;
    private int showTimeoutMs;
    public final ImageView shuffleButton;
    private final Drawable shuffleOffButtonDrawable;
    private final String shuffleOffContentDescription;
    private final Drawable shuffleOnButtonDrawable;
    private final String shuffleOnContentDescription;
    private final TimeBar timeBar;
    private int timeBarMinUpdateIntervalMs;
    private final Runnable updateProgressAction;
    private final CopyOnWriteArrayList<VisibilityListener> visibilityListeners;
    private final View vrButton;
    private final Timeline.Window window;

    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    @SuppressLint({"InlinedApi"})
    private static boolean isHandledMediaKey(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int i2 = 5000;
        this.showTimeoutMs = 5000;
        this.repeatToggleModes = 0;
        this.timeBarMinUpdateIntervalMs = 200;
        this.hideAtMs = -9223372036854775807L;
        this.showShuffleButton = false;
        int i3 = 15000;
        int i4 = R.layout.exo_player_control_view;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, new int[]{R.attr.ad_marker_color, R.attr.ad_marker_width, R.attr.bar_height, R.attr.buffered_color, R.attr.controller_layout_id, R.attr.fastforward_increment, R.attr.played_ad_marker_color, R.attr.played_color, R.attr.repeat_toggle_modes, R.attr.rewind_increment, R.attr.scrubber_color, R.attr.scrubber_disabled_size, R.attr.scrubber_dragged_size, R.attr.scrubber_drawable, R.attr.scrubber_enabled_size, R.attr.show_shuffle_button, R.attr.show_timeout, R.attr.time_bar_min_update_interval, R.attr.touch_target_height, R.attr.unplayed_color}, 0, 0);
            try {
                i2 = obtainStyledAttributes.getInt(9, 5000);
                i3 = obtainStyledAttributes.getInt(5, 15000);
                this.showTimeoutMs = obtainStyledAttributes.getInt(16, this.showTimeoutMs);
                i4 = obtainStyledAttributes.getResourceId(4, R.layout.exo_player_control_view);
                this.repeatToggleModes = getRepeatToggleModes(obtainStyledAttributes, this.repeatToggleModes);
                this.showShuffleButton = obtainStyledAttributes.getBoolean(15, this.showShuffleButton);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(17, this.timeBarMinUpdateIntervalMs));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.visibilityListeners = new CopyOnWriteArrayList<>();
        this.period = new Timeline.Period();
        this.window = new Timeline.Window();
        this.formatBuilder = new StringBuilder();
        this.formatter = new Formatter(this.formatBuilder, Locale.getDefault());
        this.adGroupTimesMs = new long[0];
        this.playedAdGroups = new boolean[0];
        this.extraAdGroupTimesMs = new long[0];
        this.extraPlayedAdGroups = new boolean[0];
        this.componentListener = new ComponentListener();
        this.controlDispatcher = new DefaultControlDispatcher((long) i3, (long) i2);
        this.updateProgressAction = new Runnable() {
            /* class com.google.android.exoplayer2.ui.$$Lambda$UNnS0kV7Qp5A4iJshVHLVqmqwTE */

            public final void run() {
                PlayerControlView.this.updateProgress();
            }
        };
        this.hideAction = new Runnable() {
            /* class com.google.android.exoplayer2.ui.$$Lambda$1vmvJI4HM5BSJdnh7cGvyaODZdE */

            public final void run() {
                PlayerControlView.this.hide();
            }
        };
        LayoutInflater.from(context).inflate(i4, this);
        setDescendantFocusability(262144);
        TimeBar timeBar2 = (TimeBar) findViewById(R.id.exo_progress);
        View findViewById = findViewById(R.id.exo_progress_placeholder);
        if (timeBar2 != null) {
            this.timeBar = timeBar2;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(R.id.exo_progress);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.timeBar = defaultTimeBar;
        } else {
            this.timeBar = null;
        }
        this.durationView = (TextView) findViewById(R.id.exo_duration);
        this.positionView = (TextView) findViewById(R.id.exo_position);
        TimeBar timeBar3 = this.timeBar;
        if (timeBar3 != null) {
            timeBar3.addListener(this.componentListener);
        }
        this.playButton = findViewById(R.id.exo_play);
        View view = this.playButton;
        if (view != null) {
            view.setOnClickListener(this.componentListener);
        }
        this.pauseButton = findViewById(R.id.exo_pause);
        View view2 = this.pauseButton;
        if (view2 != null) {
            view2.setOnClickListener(this.componentListener);
        }
        this.previousButton = findViewById(R.id.exo_prev);
        View view3 = this.previousButton;
        if (view3 != null) {
            view3.setOnClickListener(this.componentListener);
        }
        this.nextButton = findViewById(R.id.exo_next);
        View view4 = this.nextButton;
        if (view4 != null) {
            view4.setOnClickListener(this.componentListener);
        }
        this.rewindButton = findViewById(R.id.exo_rew);
        View view5 = this.rewindButton;
        if (view5 != null) {
            view5.setOnClickListener(this.componentListener);
        }
        this.fastForwardButton = findViewById(R.id.exo_ffwd);
        View view6 = this.fastForwardButton;
        if (view6 != null) {
            view6.setOnClickListener(this.componentListener);
        }
        this.repeatToggleButton = (ImageView) findViewById(R.id.exo_repeat_toggle);
        ImageView imageView = this.repeatToggleButton;
        if (imageView != null) {
            imageView.setOnClickListener(this.componentListener);
        }
        this.shuffleButton = (ImageView) findViewById(R.id.exo_shuffle);
        ImageView imageView2 = this.shuffleButton;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.componentListener);
        }
        this.vrButton = findViewById(R.id.exo_vr);
        setShowVrButton(false);
        Resources resources = context.getResources();
        this.buttonAlphaEnabled = ((float) resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled)) / 100.0f;
        this.buttonAlphaDisabled = ((float) resources.getInteger(R.integer.exo_media_button_opacity_percentage_disabled)) / 100.0f;
        this.repeatOffButtonDrawable = resources.getDrawable(R.drawable.exo_controls_repeat_off);
        this.repeatOneButtonDrawable = resources.getDrawable(R.drawable.exo_controls_repeat_one);
        this.repeatAllButtonDrawable = resources.getDrawable(R.drawable.exo_controls_repeat_all);
        this.shuffleOnButtonDrawable = resources.getDrawable(R.drawable.exo_controls_shuffle_on);
        this.shuffleOffButtonDrawable = resources.getDrawable(R.drawable.exo_controls_shuffle_off);
        this.repeatOffButtonContentDescription = resources.getString(R.string.exo_controls_repeat_off_description);
        this.repeatOneButtonContentDescription = resources.getString(R.string.exo_controls_repeat_one_description);
        this.repeatAllButtonContentDescription = resources.getString(R.string.exo_controls_repeat_all_description);
        this.shuffleOnContentDescription = resources.getString(R.string.exo_controls_shuffle_on_description);
        this.shuffleOffContentDescription = resources.getString(R.string.exo_controls_shuffle_off_description);
    }

    private static int getRepeatToggleModes(TypedArray typedArray, int i) {
        return typedArray.getInt(8, i);
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player2) {
        boolean z = true;
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        if (!(player2 == null || player2.getApplicationLooper() == Looper.getMainLooper())) {
            z = false;
        }
        Assertions.checkArgument(z);
        Player player3 = this.player;
        if (player3 != player2) {
            if (player3 != null) {
                player3.removeListener(this.componentListener);
            }
            this.player = player2;
            if (player2 != null) {
                player2.addListener(this.componentListener);
            }
            updateAll();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.showMultiWindowTimeBar = z;
        updateTimeline();
    }

    public void setExtraAdGroupMarkers(long[] jArr, boolean[] zArr) {
        boolean z = false;
        if (jArr == null) {
            this.extraAdGroupTimesMs = new long[0];
            this.extraPlayedAdGroups = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) Assertions.checkNotNull(zArr);
            if (jArr.length == zArr2.length) {
                z = true;
            }
            Assertions.checkArgument(z);
            this.extraAdGroupTimesMs = jArr;
            this.extraPlayedAdGroups = zArr2;
        }
        updateTimeline();
    }

    public void addVisibilityListener(VisibilityListener visibilityListener) {
        this.visibilityListeners.add(visibilityListener);
    }

    public void removeVisibilityListener(VisibilityListener visibilityListener) {
        this.visibilityListeners.remove(visibilityListener);
    }

    public void setProgressUpdateListener(ProgressUpdateListener progressUpdateListener2) {
        this.progressUpdateListener = progressUpdateListener2;
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer2) {
        this.playbackPreparer = playbackPreparer2;
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher2) {
        if (this.controlDispatcher != controlDispatcher2) {
            this.controlDispatcher = controlDispatcher2;
            updateNavigation();
        }
    }

    @Deprecated
    public void setRewindIncrementMs(int i) {
        ControlDispatcher controlDispatcher2 = this.controlDispatcher;
        if (controlDispatcher2 instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher2).setRewindIncrementMs((long) i);
            updateNavigation();
        }
    }

    @Deprecated
    public void setFastForwardIncrementMs(int i) {
        ControlDispatcher controlDispatcher2 = this.controlDispatcher;
        if (controlDispatcher2 instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher2).setFastForwardIncrementMs((long) i);
            updateNavigation();
        }
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public void setShowTimeoutMs(int i) {
        this.showTimeoutMs = i;
        if (isVisible()) {
            hideAfterTimeout();
        }
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public void setRepeatToggleModes(int i) {
        this.repeatToggleModes = i;
        Player player2 = this.player;
        if (player2 != null) {
            int repeatMode = player2.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 2);
            }
        }
        updateRepeatModeButton();
    }

    public boolean getShowShuffleButton() {
        return this.showShuffleButton;
    }

    public void setShowShuffleButton(boolean z) {
        this.showShuffleButton = z;
        updateShuffleButton();
    }

    public boolean getShowVrButton() {
        View view = this.vrButton;
        return view != null && view.getVisibility() == 0;
    }

    public void setShowVrButton(boolean z) {
        View view = this.vrButton;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.vrButton;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.timeBarMinUpdateIntervalMs = Util.constrainValue(i, 16, 1000);
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            Iterator<VisibilityListener> it = this.visibilityListeners.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(getVisibility());
            }
            updateAll();
            requestPlayPauseFocus();
        }
        hideAfterTimeout();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            Iterator<VisibilityListener> it = this.visibilityListeners.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.updateProgressAction);
            removeCallbacks(this.hideAction);
            this.hideAtMs = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    private void hideAfterTimeout() {
        removeCallbacks(this.hideAction);
        if (this.showTimeoutMs > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.showTimeoutMs;
            this.hideAtMs = uptimeMillis + ((long) i);
            if (this.isAttachedToWindow) {
                postDelayed(this.hideAction, (long) i);
                return;
            }
            return;
        }
        this.hideAtMs = -9223372036854775807L;
    }

    private void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateRepeatModeButton();
        updateShuffleButton();
        updateTimeline();
    }

    public void updatePlayPauseButton() {
        boolean z;
        if (isVisible() && this.isAttachedToWindow) {
            boolean shouldShowPauseButton = shouldShowPauseButton();
            View view = this.playButton;
            int i = 8;
            boolean z2 = true;
            if (view != null) {
                z = (shouldShowPauseButton && view.isFocused()) | false;
                this.playButton.setVisibility(shouldShowPauseButton ? 8 : 0);
            } else {
                z = false;
            }
            View view2 = this.pauseButton;
            if (view2 != null) {
                if (shouldShowPauseButton || !view2.isFocused()) {
                    z2 = false;
                }
                z |= z2;
                View view3 = this.pauseButton;
                if (shouldShowPauseButton) {
                    i = 0;
                }
                view3.setVisibility(i);
            }
            if (z) {
                requestPlayPauseFocus();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    public void updateNavigation() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        TimeBar timeBar2;
        if (isVisible() && this.isAttachedToWindow) {
            Player player2 = this.player;
            boolean z5 = false;
            if (player2 != null) {
                Timeline currentTimeline = player2.getCurrentTimeline();
                if (!currentTimeline.isEmpty() && !player2.isPlayingAd()) {
                    currentTimeline.getWindow(player2.getCurrentWindowIndex(), this.window);
                    z3 = this.window.isSeekable;
                    boolean z6 = z3 || !this.window.isDynamic || player2.hasPrevious();
                    z2 = z3 && this.controlDispatcher.isRewindEnabled();
                    z = z3 && this.controlDispatcher.isFastForwardEnabled();
                    if (this.window.isDynamic || player2.hasNext()) {
                        z5 = true;
                    }
                    z4 = z5;
                    z5 = z6;
                    setButtonEnabled(z5, this.previousButton);
                    setButtonEnabled(z2, this.rewindButton);
                    setButtonEnabled(z, this.fastForwardButton);
                    setButtonEnabled(z4, this.nextButton);
                    timeBar2 = this.timeBar;
                    if (timeBar2 == null) {
                        timeBar2.setEnabled(z3);
                        return;
                    }
                    return;
                }
            }
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
            setButtonEnabled(z5, this.previousButton);
            setButtonEnabled(z2, this.rewindButton);
            setButtonEnabled(z, this.fastForwardButton);
            setButtonEnabled(z4, this.nextButton);
            timeBar2 = this.timeBar;
            if (timeBar2 == null) {
            }
        }
    }

    public void updateRepeatModeButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.repeatToggleButton) != null) {
            if (this.repeatToggleModes == 0) {
                imageView.setVisibility(8);
                return;
            }
            Player player2 = this.player;
            if (player2 == null) {
                setButtonEnabled(false, imageView);
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                return;
            }
            setButtonEnabled(true, imageView);
            int repeatMode = player2.getRepeatMode();
            if (repeatMode == 0) {
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
            } else if (repeatMode == 1) {
                this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
            } else if (repeatMode == 2) {
                this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
            }
            this.repeatToggleButton.setVisibility(0);
        }
    }

    public void updateShuffleButton() {
        ImageView imageView;
        String str;
        ImageView imageView2;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.shuffleButton) != null) {
            Player player2 = this.player;
            if (!this.showShuffleButton) {
                imageView.setVisibility(8);
                return;
            }
            if (player2 == null) {
                setButtonEnabled(false, imageView);
                this.shuffleButton.setImageDrawable(this.shuffleOffButtonDrawable);
                imageView2 = this.shuffleButton;
            } else {
                setButtonEnabled(true, imageView);
                this.shuffleButton.setImageDrawable(player2.getShuffleModeEnabled() ? this.shuffleOnButtonDrawable : this.shuffleOffButtonDrawable);
                imageView2 = this.shuffleButton;
                if (player2.getShuffleModeEnabled()) {
                    str = this.shuffleOnContentDescription;
                    imageView2.setContentDescription(str);
                }
            }
            str = this.shuffleOffContentDescription;
            imageView2.setContentDescription(str);
        }
    }

    public void updateTimeline() {
        long j;
        int i;
        Player player2 = this.player;
        if (player2 != null) {
            boolean z = true;
            this.multiWindowTimeBar = this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(player2.getCurrentTimeline(), this.window);
            this.currentWindowOffset = 0;
            Timeline currentTimeline = player2.getCurrentTimeline();
            if (!currentTimeline.isEmpty()) {
                int currentWindowIndex = player2.getCurrentWindowIndex();
                int i2 = this.multiWindowTimeBar ? 0 : currentWindowIndex;
                int windowCount = this.multiWindowTimeBar ? currentTimeline.getWindowCount() - 1 : currentWindowIndex;
                long j2 = 0;
                i = 0;
                while (true) {
                    if (i2 > windowCount) {
                        break;
                    }
                    if (i2 == currentWindowIndex) {
                        this.currentWindowOffset = C.usToMs(j2);
                    }
                    currentTimeline.getWindow(i2, this.window);
                    if (this.window.durationUs == -9223372036854775807L) {
                        Assertions.checkState(this.multiWindowTimeBar ^ z);
                        break;
                    }
                    int i3 = this.window.firstPeriodIndex;
                    while (i3 <= this.window.lastPeriodIndex) {
                        currentTimeline.getPeriod(i3, this.period);
                        int adGroupCount = this.period.getAdGroupCount();
                        int i4 = i;
                        for (int i5 = 0; i5 < adGroupCount; i5++) {
                            long adGroupTimeUs = this.period.getAdGroupTimeUs(i5);
                            if (adGroupTimeUs == Long.MIN_VALUE) {
                                if (this.period.durationUs != -9223372036854775807L) {
                                    adGroupTimeUs = this.period.durationUs;
                                }
                            }
                            long positionInWindowUs = adGroupTimeUs + this.period.getPositionInWindowUs();
                            if (positionInWindowUs >= 0) {
                                long[] jArr = this.adGroupTimesMs;
                                if (i4 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.adGroupTimesMs = Arrays.copyOf(this.adGroupTimesMs, length);
                                    this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, length);
                                }
                                this.adGroupTimesMs[i4] = C.usToMs(j2 + positionInWindowUs);
                                this.playedAdGroups[i4] = this.period.hasPlayedAdGroup(i5);
                                i4++;
                            }
                        }
                        i3++;
                        i = i4;
                    }
                    j2 += this.window.durationUs;
                    i2++;
                    z = true;
                }
                j = j2;
            } else {
                i = 0;
                j = 0;
            }
            long usToMs = C.usToMs(j);
            TextView textView = this.durationView;
            if (textView != null) {
                textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, usToMs));
            }
            TimeBar timeBar2 = this.timeBar;
            if (timeBar2 != null) {
                timeBar2.setDuration(usToMs);
                int length2 = this.extraAdGroupTimesMs.length;
                int i6 = i + length2;
                long[] jArr2 = this.adGroupTimesMs;
                if (i6 > jArr2.length) {
                    this.adGroupTimesMs = Arrays.copyOf(jArr2, i6);
                    this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, i6);
                }
                System.arraycopy(this.extraAdGroupTimesMs, 0, this.adGroupTimesMs, i, length2);
                System.arraycopy(this.extraPlayedAdGroups, 0, this.playedAdGroups, i, length2);
                this.timeBar.setAdGroupTimesMs(this.adGroupTimesMs, this.playedAdGroups, i6);
            }
            updateProgress();
        }
    }

    public void updateProgress() {
        long j;
        int i;
        if (isVisible() && this.isAttachedToWindow) {
            Player player2 = this.player;
            long j2 = 0;
            if (player2 != null) {
                j2 = this.currentWindowOffset + player2.getContentPosition();
                j = this.currentWindowOffset + player2.getContentBufferedPosition();
            } else {
                j = 0;
            }
            TextView textView = this.positionView;
            if (textView != null && !this.scrubbing) {
                textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, j2));
            }
            TimeBar timeBar2 = this.timeBar;
            if (timeBar2 != null) {
                timeBar2.setPosition(j2);
                this.timeBar.setBufferedPosition(j);
            }
            ProgressUpdateListener progressUpdateListener2 = this.progressUpdateListener;
            if (progressUpdateListener2 != null) {
                progressUpdateListener2.onProgressUpdate(j2, j);
            }
            removeCallbacks(this.updateProgressAction);
            if (player2 == null) {
                i = 1;
            } else {
                i = player2.getPlaybackState();
            }
            long j3 = 1000;
            if (player2 != null && player2.isPlaying()) {
                TimeBar timeBar3 = this.timeBar;
                long min = Math.min(timeBar3 != null ? timeBar3.getPreferredUpdateDelay() : 1000, 1000 - (j2 % 1000));
                float playbackSpeed = player2.getPlaybackSpeed();
                if (playbackSpeed > 0.0f) {
                    j3 = (long) (((float) min) / playbackSpeed);
                }
                postDelayed(this.updateProgressAction, Util.constrainValue(j3, (long) this.timeBarMinUpdateIntervalMs, 1000));
            } else if (i != 4 && i != 1) {
                postDelayed(this.updateProgressAction, 1000);
            }
        }
    }

    private void requestPlayPauseFocus() {
        View view;
        View view2;
        boolean shouldShowPauseButton = shouldShowPauseButton();
        if (!shouldShowPauseButton && (view2 = this.playButton) != null) {
            view2.requestFocus();
        } else if (shouldShowPauseButton && (view = this.pauseButton) != null) {
            view.requestFocus();
        }
    }

    private void setButtonEnabled(boolean z, View view) {
        if (view != null) {
            view.setEnabled(z);
            view.setAlpha(z ? this.buttonAlphaEnabled : this.buttonAlphaDisabled);
            view.setVisibility(0);
        }
    }

    public void seekToTimeBarPosition(Player player2, long j) {
        int i;
        Timeline currentTimeline = player2.getCurrentTimeline();
        if (!this.multiWindowTimeBar || currentTimeline.isEmpty()) {
            i = player2.getCurrentWindowIndex();
        } else {
            int windowCount = currentTimeline.getWindowCount();
            i = 0;
            while (true) {
                long durationMs = currentTimeline.getWindow(i, this.window).getDurationMs();
                if (j < durationMs) {
                    break;
                } else if (i == windowCount - 1) {
                    j = durationMs;
                    break;
                } else {
                    j -= durationMs;
                    i++;
                }
            }
        }
        if (!seekTo(player2, i, j)) {
            updateProgress();
        }
    }

    public boolean seekTo(Player player2, int i, long j) {
        return this.controlDispatcher.dispatchSeekTo(player2, i, j);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        long j = this.hideAtMs;
        if (j != -9223372036854775807L) {
            long uptimeMillis = j - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.hideAction, uptimeMillis);
            }
        } else if (isVisible()) {
            hideAfterTimeout();
        }
        updateAll();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        removeCallbacks(this.updateProgressAction);
        removeCallbacks(this.hideAction);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.hideAction);
        } else if (motionEvent.getAction() == 1) {
            hideAfterTimeout();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player2 = this.player;
        if (player2 == null || !isHandledMediaKey(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                this.controlDispatcher.dispatchFastForward(player2);
            } else if (keyCode == 89) {
                this.controlDispatcher.dispatchRewind(player2);
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 85) {
                    this.controlDispatcher.dispatchSetPlayWhenReady(player2, !player2.getPlayWhenReady());
                } else if (keyCode == 87) {
                    this.controlDispatcher.dispatchNext(player2);
                } else if (keyCode == 88) {
                    this.controlDispatcher.dispatchPrevious(player2);
                } else if (keyCode == 126) {
                    this.controlDispatcher.dispatchSetPlayWhenReady(player2, true);
                } else if (keyCode == 127) {
                    this.controlDispatcher.dispatchSetPlayWhenReady(player2, false);
                }
            }
        }
        return true;
    }

    private boolean shouldShowPauseButton() {
        Player player2 = this.player;
        if (player2 == null || player2.getPlaybackState() == 4 || this.player.getPlaybackState() == 1 || !this.player.getPlayWhenReady()) {
            return false;
        }
        return true;
    }

    private static boolean canShowMultiWindowTimeBar(Timeline timeline, Timeline.Window window2) {
        if (timeline.getWindowCount() > 100) {
            return false;
        }
        int windowCount = timeline.getWindowCount();
        for (int i = 0; i < windowCount; i++) {
            if (timeline.getWindow(i, window2).durationUs == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    final class ComponentListener implements View.OnClickListener, Player.EventListener, TimeBar.OnScrubListener {
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
        }

        @Deprecated
        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onLoadingChanged(this, z);
        }

        @Deprecated
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        public /* synthetic */ void onPlaybackSpeedChanged(float f) {
            Player.EventListener.CC.$default$onPlaybackSpeedChanged(this, f);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
        }

        @Deprecated
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayerStateChanged(this, z, i);
        }

        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        @Deprecated
        public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
        }

        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        private ComponentListener() {
        }

        public final void onScrubStart(TimeBar timeBar, long j) {
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.scrubbing = true;
            if (playerControlView.positionView != null) {
                PlayerControlView.this.positionView.setText(Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, j));
            }
        }

        public final void onScrubMove(TimeBar timeBar, long j) {
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, j));
            }
        }

        public final void onScrubStop(TimeBar timeBar, long j, boolean z) {
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.scrubbing = false;
            if (!z && playerControlView.player != null) {
                PlayerControlView playerControlView2 = PlayerControlView.this;
                playerControlView2.seekToTimeBarPosition(playerControlView2.player, j);
            }
        }

        public final void onPlaybackStateChanged(int i) {
            PlayerControlView.this.updatePlayPauseButton();
            PlayerControlView.this.updateProgress();
        }

        public final void onPlayWhenReadyChanged(boolean z, int i) {
            PlayerControlView.this.updatePlayPauseButton();
            PlayerControlView.this.updateProgress();
        }

        public final void onIsPlayingChanged(boolean z) {
            PlayerControlView.this.updateProgress();
        }

        public final void onRepeatModeChanged(int i) {
            PlayerControlView.this.updateRepeatModeButton();
            PlayerControlView.this.updateNavigation();
        }

        public final void onShuffleModeEnabledChanged(boolean z) {
            PlayerControlView.this.updateShuffleButton();
            PlayerControlView.this.updateNavigation();
        }

        public final void onPositionDiscontinuity(int i) {
            PlayerControlView.this.updateNavigation();
            PlayerControlView.this.updateTimeline();
        }

        public final void onTimelineChanged(Timeline timeline, int i) {
            PlayerControlView.this.updateNavigation();
            PlayerControlView.this.updateTimeline();
        }

        public final void onClick(View view) {
            Player player = PlayerControlView.this.player;
            if (player != null) {
                if (PlayerControlView.this.nextButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchNext(player);
                } else if (PlayerControlView.this.previousButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchPrevious(player);
                } else if (PlayerControlView.this.fastForwardButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchFastForward(player);
                } else if (PlayerControlView.this.rewindButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchRewind(player);
                } else if (PlayerControlView.this.playButton == view) {
                    if (player.getPlaybackState() == 1) {
                        if (PlayerControlView.this.playbackPreparer != null) {
                            PlayerControlView.this.playbackPreparer.preparePlayback();
                        }
                    } else if (player.getPlaybackState() == 4) {
                        PlayerControlView.this.seekTo(player, player.getCurrentWindowIndex(), -9223372036854775807L);
                    }
                    PlayerControlView.this.controlDispatcher.dispatchSetPlayWhenReady(player, true);
                } else if (PlayerControlView.this.pauseButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchSetPlayWhenReady(player, false);
                } else if (PlayerControlView.this.repeatToggleButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchSetRepeatMode(player, RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), PlayerControlView.this.repeatToggleModes));
                } else if (PlayerControlView.this.shuffleButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchSetShuffleModeEnabled(player, !player.getShuffleModeEnabled());
                }
            }
        }
    }
}
