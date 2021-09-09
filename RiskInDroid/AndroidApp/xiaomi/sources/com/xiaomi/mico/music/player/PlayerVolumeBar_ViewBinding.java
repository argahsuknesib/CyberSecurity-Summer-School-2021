package com.xiaomi.mico.music.player;

import android.view.View;
import android.widget.SeekBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class PlayerVolumeBar_ViewBinding implements Unbinder {
    private PlayerVolumeBar target;

    public PlayerVolumeBar_ViewBinding(PlayerVolumeBar playerVolumeBar) {
        this(playerVolumeBar, playerVolumeBar);
    }

    public PlayerVolumeBar_ViewBinding(PlayerVolumeBar playerVolumeBar, View view) {
        this.target = playerVolumeBar;
        playerVolumeBar.mSeekBar = (SeekBar) Utils.findRequiredViewAsType(view, R.id.player_control_bar_seek, "field 'mSeekBar'", SeekBar.class);
    }

    public void unbind() {
        PlayerVolumeBar playerVolumeBar = this.target;
        if (playerVolumeBar != null) {
            this.target = null;
            playerVolumeBar.mSeekBar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
