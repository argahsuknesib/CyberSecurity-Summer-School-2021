package com.xiaomi.mico.music.player;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class PlayerProgressBar_ViewBinding implements Unbinder {
    private PlayerProgressBar target;

    public PlayerProgressBar_ViewBinding(PlayerProgressBar playerProgressBar) {
        this(playerProgressBar, playerProgressBar);
    }

    public PlayerProgressBar_ViewBinding(PlayerProgressBar playerProgressBar, View view) {
        this.target = playerProgressBar;
        playerProgressBar.mInitTime = (TextView) Utils.findRequiredViewAsType(view, R.id.player_control_bar_init_time, "field 'mInitTime'", TextView.class);
        playerProgressBar.mEndTime = (TextView) Utils.findRequiredViewAsType(view, R.id.player_control_bar_end_time, "field 'mEndTime'", TextView.class);
        playerProgressBar.mSeekBar = (SeekBar) Utils.findRequiredViewAsType(view, R.id.player_control_bar_progress_seek, "field 'mSeekBar'", SeekBar.class);
    }

    public void unbind() {
        PlayerProgressBar playerProgressBar = this.target;
        if (playerProgressBar != null) {
            this.target = null;
            playerProgressBar.mInitTime = null;
            playerProgressBar.mEndTime = null;
            playerProgressBar.mSeekBar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
