package com.xiaomi.mico.music.player;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.mico.music.OpenQQMusicVIPView;
import com.xiaomi.smarthome.R;
import com.xiasuhuei321.loadingdialog.view.LoadCircleView;

public class PlayerList_ViewBinding implements Unbinder {
    private PlayerList target;

    public PlayerList_ViewBinding(PlayerList playerList) {
        this(playerList, playerList);
    }

    public PlayerList_ViewBinding(PlayerList playerList, View view) {
        this.target = playerList;
        playerList.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.linear_recycle_view, "field 'recyclerView'", RecyclerView.class);
        playerList.openVipView = (OpenQQMusicVIPView) Utils.findRequiredViewAsType(view, R.id.openVipView, "field 'openVipView'", OpenQQMusicVIPView.class);
        playerList.mLoading = (LoadCircleView) Utils.findRequiredViewAsType(view, R.id.player_control_bat_list_loading, "field 'mLoading'", LoadCircleView.class);
        playerList.btnClose = (TextView) Utils.findRequiredViewAsType(view, R.id.btn_close, "field 'btnClose'", TextView.class);
        playerList.mFrameLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_playlist, "field 'mFrameLayout'", FrameLayout.class);
    }

    public void unbind() {
        PlayerList playerList = this.target;
        if (playerList != null) {
            this.target = null;
            playerList.recyclerView = null;
            playerList.openVipView = null;
            playerList.mLoading = null;
            playerList.btnClose = null;
            playerList.mFrameLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
