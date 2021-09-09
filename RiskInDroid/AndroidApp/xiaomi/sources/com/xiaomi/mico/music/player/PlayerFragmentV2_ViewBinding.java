package com.xiaomi.mico.music.player;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class PlayerFragmentV2_ViewBinding implements Unbinder {
    private PlayerFragmentV2 target;
    private View view1aa9;

    public PlayerFragmentV2_ViewBinding(final PlayerFragmentV2 playerFragmentV2, View view) {
        this.target = playerFragmentV2;
        View findRequiredView = Utils.findRequiredView(view, R.id.player_cover, "field 'mCover' and method 'onClick'");
        playerFragmentV2.mCover = (ImageView) Utils.castView(findRequiredView, R.id.player_cover, "field 'mCover'", ImageView.class);
        this.view1aa9 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerFragmentV2_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                playerFragmentV2.onClick(view);
            }
        });
        playerFragmentV2.mAudioName = (TextView) Utils.findRequiredViewAsType(view, R.id.player_audio_name, "field 'mAudioName'", TextView.class);
        playerFragmentV2.mArtistName = (TextView) Utils.findRequiredViewAsType(view, R.id.player_artist_name, "field 'mArtistName'", TextView.class);
        playerFragmentV2.mLove = (ImageView) Utils.findRequiredViewAsType(view, R.id.player_control_bar_love, "field 'mLove'", ImageView.class);
        playerFragmentV2.mScrollView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.sv_player_cover, "field 'mScrollView'", ScrollView.class);
    }

    public void unbind() {
        PlayerFragmentV2 playerFragmentV2 = this.target;
        if (playerFragmentV2 != null) {
            this.target = null;
            playerFragmentV2.mCover = null;
            playerFragmentV2.mAudioName = null;
            playerFragmentV2.mArtistName = null;
            playerFragmentV2.mLove = null;
            playerFragmentV2.mScrollView = null;
            this.view1aa9.setOnClickListener(null);
            this.view1aa9 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
