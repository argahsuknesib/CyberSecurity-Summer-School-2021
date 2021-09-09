package com.xiaomi.mico.music.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.detail.DetailTitleBar;
import com.xiaomi.smarthome.R;
import rx.functions.Action1;

public class PlayerIndicator extends FrameLayout {
    private boolean isBlack;
    private boolean mIsPlaying;
    private ImageView mPlayerIcon;
    DetailTitleBar.PlayerIndicatorStatClickListener mPlayerIndicatorStatClickListener;
    private LottieAnimationView mPlayingIcon;
    private LottieAnimationView playingBlackIcon;

    public PlayerIndicator(Context context) {
        super(context);
    }

    public PlayerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            if (getChildCount() <= 0) {
                this.mIsPlaying = false;
                innerAddView(getPlayerIcon());
                RxUtil.debounceClick(this, new Action1() {
                    /* class com.xiaomi.mico.music.player.$$Lambda$PlayerIndicator$E4YDVThob2ADfIG5U1XUjRA9FN0 */

                    public final void call(Object obj) {
                        PlayerIndicator.this.lambda$onFinishInflate$0$PlayerIndicator((Void) obj);
                    }
                });
                return;
            }
            throw new IllegalStateException("IndicatorView must not contain any child when initialized.");
        }
    }

    public /* synthetic */ void lambda$onFinishInflate$0$PlayerIndicator(Void voidR) {
        PlayerActivityV2.displayPlayerWithAnim(getContext());
        DetailTitleBar.PlayerIndicatorStatClickListener playerIndicatorStatClickListener = this.mPlayerIndicatorStatClickListener;
        if (playerIndicatorStatClickListener != null) {
            playerIndicatorStatClickListener.onStatClick();
        }
    }

    public void onResume() {
        if (this.isBlack) {
            if (this.mIsPlaying && !this.playingBlackIcon.isAnimating()) {
                this.playingBlackIcon.resumeAnimation();
            }
        } else if (this.mIsPlaying && !this.mPlayingIcon.isAnimating()) {
            this.mPlayingIcon.resumeAnimation();
        }
    }

    public void onPause() {
        if (this.isBlack) {
            if (this.mIsPlaying && this.playingBlackIcon.isAnimating()) {
                this.playingBlackIcon.pauseAnimation();
            }
        } else if (this.mIsPlaying && this.mPlayingIcon.isAnimating()) {
            this.mPlayingIcon.pauseAnimation();
        }
    }

    public void updatePlayerStatus(Remote.Response.PlayerStatus playerStatus) {
        boolean isPlaying = MusicHelper.isPlaying(playerStatus);
        if (this.mIsPlaying != isPlaying) {
            removeAllViews();
            this.mIsPlaying = isPlaying;
            innerAddView(isPlaying ? getPlayingIcon() : getPlayerIcon());
        }
    }

    public void updatePlayerStatus(Remote.Response.PlayerStatus playerStatus, DetailTitleBar.PlayerIndicatorStatClickListener playerIndicatorStatClickListener) {
        this.mPlayerIndicatorStatClickListener = playerIndicatorStatClickListener;
        updatePlayerStatus(playerStatus);
    }

    public void setPlayerPlayingIcon(int i, boolean z) {
        ImageView imageView = this.mPlayerIcon;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        this.isBlack = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.mico.music.player.PlayerIndicator, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private ImageView getPlayerIcon() {
        if (this.mPlayerIcon == null) {
            this.mPlayerIcon = (ImageView) LayoutInflater.from(getContext()).inflate((int) R.layout.view_music_player, (ViewGroup) this, false);
        }
        return this.mPlayerIcon;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.mico.music.player.PlayerIndicator, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private LottieAnimationView getPlayingIcon() {
        if (this.mPlayingIcon == null) {
            this.mPlayingIcon = (LottieAnimationView) LayoutInflater.from(getContext()).inflate((int) R.layout.view_music_playing, (ViewGroup) this, false);
            this.mPlayingIcon.setScale(0.33333334f);
        }
        if (this.playingBlackIcon == null) {
            this.playingBlackIcon = (LottieAnimationView) LayoutInflater.from(getContext()).inflate((int) R.layout.view_music_playing_black, (ViewGroup) this, false);
            this.playingBlackIcon.setScale(0.33333334f);
        }
        return this.isBlack ? this.playingBlackIcon : this.mPlayingIcon;
    }

    private void innerAddView(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.gravity = 17;
        addView(view, layoutParams);
    }
}
