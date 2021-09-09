package com.xiaomi.mico.music.detail;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.music.player.PlayerIndicator;
import com.xiaomi.smarthome.R;

public class DetailTitleBar extends TitleBar {
    PlayerIndicatorStatClickListener mListener;
    private PlayerIndicator mPlayerIndicator;

    public interface PlayerIndicatorStatClickListener {
        void onStatClick();
    }

    public DetailTitleBar(Context context) {
        super(context);
    }

    public DetailTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerIndicator getPlayerIndicator() {
        return this.mPlayerIndicator;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
                /* class com.xiaomi.mico.music.detail.$$Lambda$DetailTitleBar$2OuC8FmNVML5HBJSiXJTgzuMUsQ */

                public final void onLeftIconClick() {
                    DetailTitleBar.this.lambda$onFinishInflate$0$DetailTitleBar();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onFinishInflate$0$DetailTitleBar() {
        ((Activity) getContext()).finish();
    }

    /* access modifiers changed from: package-private */
    public void onResume() {
        PlayerIndicator playerIndicator = this.mPlayerIndicator;
        if (playerIndicator != null) {
            playerIndicator.onResume();
        }
    }

    /* access modifiers changed from: package-private */
    public void onPause() {
        PlayerIndicator playerIndicator = this.mPlayerIndicator;
        if (playerIndicator != null) {
            playerIndicator.onPause();
        }
    }

    /* access modifiers changed from: package-private */
    public void setRightIcon(int i, TitleBar.OnRightIconClickListener onRightIconClickListener) {
        setRightIcon(i).setOnRightIconClickListener(onRightIconClickListener);
    }

    /* access modifiers changed from: package-private */
    public void addPlayerIndicator() {
        addCustomView(R.layout.view_music_player_indicator);
    }

    /* access modifiers changed from: package-private */
    public void addPlayerIndicator(PlayerIndicatorStatClickListener playerIndicatorStatClickListener) {
        this.mListener = playerIndicatorStatClickListener;
        addCustomView(R.layout.view_music_player_indicator);
    }

    public void removePlayerIndicator() {
        PlayerIndicator playerIndicator = this.mPlayerIndicator;
        if (playerIndicator != null) {
            playerIndicator.setVisibility(8);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, com.xiaomi.mico.music.detail.DetailTitleBar, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: package-private */
    public void addCustomView(int i) {
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity |= 16;
        addView(inflate, layoutParams);
        this.mPlayerIndicator = (PlayerIndicator) inflate.findViewById(R.id.music_player_indicator);
    }

    /* access modifiers changed from: package-private */
    public void updatePlayerStatus(Remote.Response.PlayerStatus playerStatus) {
        PlayerIndicator playerIndicator = this.mPlayerIndicator;
        if (playerIndicator != null) {
            playerIndicator.updatePlayerStatus(playerStatus, this.mListener);
        }
    }
}
