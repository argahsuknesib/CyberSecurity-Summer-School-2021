package com.xiaomi.mico.music.player;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class PlayerControler_ViewBinding implements Unbinder {
    private PlayerControler target;
    private View view1aab;
    private View view1ab1;

    public PlayerControler_ViewBinding(PlayerControler playerControler) {
        this(playerControler, playerControler);
    }

    public PlayerControler_ViewBinding(final PlayerControler playerControler, View view) {
        this.target = playerControler;
        playerControler.mCover = (ImageView) Utils.findRequiredViewAsType(view, R.id.player_cover, "field 'mCover'", ImageView.class);
        playerControler.mName = (TextView) Utils.findRequiredViewAsType(view, R.id.player_name, "field 'mName'", TextView.class);
        playerControler.mCp = (TextView) Utils.findRequiredViewAsType(view, R.id.player_cp, "field 'mCp'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.player_state, "field 'mState' and method 'onClick'");
        playerControler.mState = (ImageView) Utils.castView(findRequiredView, R.id.player_state, "field 'mState'", ImageView.class);
        this.view1ab1 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerControler_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                playerControler.onClick(view);
            }
        });
        playerControler.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.player_progress, "field 'mProgressBar'", ProgressBar.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.player_list, "field 'classification' and method 'onClick'");
        playerControler.classification = (ImageView) Utils.castView(findRequiredView2, R.id.player_list, "field 'classification'", ImageView.class);
        this.view1aab = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerControler_ViewBinding.AnonymousClass2 */

            public void doClick(View view) {
                playerControler.onClick(view);
            }
        });
        playerControler.mBackground = (ImageView) Utils.findRequiredViewAsType(view, R.id.player_background, "field 'mBackground'", ImageView.class);
    }

    public void unbind() {
        PlayerControler playerControler = this.target;
        if (playerControler != null) {
            this.target = null;
            playerControler.mCover = null;
            playerControler.mName = null;
            playerControler.mCp = null;
            playerControler.mState = null;
            playerControler.mProgressBar = null;
            playerControler.classification = null;
            playerControler.mBackground = null;
            this.view1ab1.setOnClickListener(null);
            this.view1ab1 = null;
            this.view1aab.setOnClickListener(null);
            this.view1aab = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
