package com.xiaomi.mico.music.player;

import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;

public class PlayerActivityV2_ViewBinding implements Unbinder {
    private PlayerActivityV2 target;
    private View view1aa8;

    public PlayerActivityV2_ViewBinding(PlayerActivityV2 playerActivityV2) {
        this(playerActivityV2, playerActivityV2.getWindow().getDecorView());
    }

    public PlayerActivityV2_ViewBinding(final PlayerActivityV2 playerActivityV2, View view) {
        this.target = playerActivityV2;
        playerActivityV2.mTitleBar = (TitleBar) Utils.findRequiredViewAsType(view, R.id.title_bar, "field 'mTitleBar'", TitleBar.class);
        playerActivityV2.mViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.player_view_pager, "field 'mViewPager'", ViewPager.class);
        playerActivityV2.mControlBar = (ControlBarV2) Utils.findRequiredViewAsType(view, R.id.player_control_bar, "field 'mControlBar'", ControlBarV2.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.player_control_multi_room, "field 'multiRoomBtn' and method 'onClickView'");
        playerActivityV2.multiRoomBtn = (TextView) Utils.castView(findRequiredView, R.id.player_control_multi_room, "field 'multiRoomBtn'", TextView.class);
        this.view1aa8 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.PlayerActivityV2_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                playerActivityV2.onClickView(view);
            }
        });
    }

    public void unbind() {
        PlayerActivityV2 playerActivityV2 = this.target;
        if (playerActivityV2 != null) {
            this.target = null;
            playerActivityV2.mTitleBar = null;
            playerActivityV2.mViewPager = null;
            playerActivityV2.mControlBar = null;
            playerActivityV2.multiRoomBtn = null;
            this.view1aa8.setOnClickListener(null);
            this.view1aa8 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
