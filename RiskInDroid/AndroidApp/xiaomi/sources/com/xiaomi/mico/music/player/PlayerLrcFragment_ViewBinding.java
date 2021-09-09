package com.xiaomi.mico.music.player;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.mico.music.player.lrc.LrcViewImpl1;
import com.xiaomi.smarthome.R;
import me.wcy.lrcview.LrcView;

public class PlayerLrcFragment_ViewBinding implements Unbinder {
    private PlayerLrcFragment target;
    private View view1aad;

    public PlayerLrcFragment_ViewBinding(final PlayerLrcFragment playerLrcFragment, View view) {
        this.target = playerLrcFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.player_lrc_view, "field 'mLrcView' and method 'onClick'");
        playerLrcFragment.mLrcView = (LrcViewImpl1) Utils.castView(findRequiredView, R.id.player_lrc_view, "field 'mLrcView'", LrcViewImpl1.class);
        this.view1aad = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerLrcFragment_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                playerLrcFragment.onClick();
            }
        });
        playerLrcFragment.mLrcView2 = (LrcView) Utils.findRequiredViewAsType(view, R.id.lrc_view, "field 'mLrcView2'", LrcView.class);
    }

    public void unbind() {
        PlayerLrcFragment playerLrcFragment = this.target;
        if (playerLrcFragment != null) {
            this.target = null;
            playerLrcFragment.mLrcView = null;
            playerLrcFragment.mLrcView2 = null;
            this.view1aad.setOnClickListener(null);
            this.view1aad = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
