package com.xiaomi.mico.music.player;

import _m_j.gsy;
import _m_j.hxi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.adapter.TabPagerAdapter;
import com.xiaomi.mico.common.application.AppCapability;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.player.BasePlayerFragment;
import com.xiaomi.mico.music.player.ControlBarV2;
import com.xiaomi.mico.music.player.multiroom.MultiRoomView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerActivityV2 extends MicoBaseActivity implements BasePlayerFragment.OnViewCreatedCallback, ControlBarV2.OnMusicUpdateListener {
    private int mAttachedFragmentCount = 0;
    @BindView(6810)
    ControlBarV2 mControlBar;
    private PlayerFragmentV2 mPlayerFragment;
    @BindView(7228)
    TitleBar mTitleBar;
    @BindView(6834)
    ViewPager mViewPager;
    @BindView(6824)
    TextView multiRoomBtn;
    private PlayerLrcFragment playerLrcFragment;
    public PlayerVolumeBar playerVolumeBar;

    public static void displayPlayerWithAnim(Context context) {
        context.startActivity(new Intent(context, PlayerActivityV2.class));
        ((Activity) context).overridePendingTransition(R.anim.mico_player_open_enter, R.anim.mico_player_open_exit);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int
     arg types: [com.xiaomi.mico.music.player.PlayerActivityV2, int]
     candidates:
      com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.content.Context, float):int
      com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.mico_activity_player_v2);
        ButterKnife.bind(this);
        this.mTitleBar.getRootView().setPadding(DisplayUtils.dip2px((Activity) this, 15.0f), 0, DisplayUtils.dip2px((Activity) this, 15.0f), 0);
        this.mTitleBar.getTitleView().setTextColor(getResources().getColor(R.color.mj_color_black));
        this.mTitleBar.getTitleView().setTextSize(2, 26.0f);
        this.mTitleBar.getTitleView().setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.mTitleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.music.player.$$Lambda$PlayerActivityV2$1sYSGpbBWjV1wFzxqKBbNbHFKbI */

            public final void onLeftIconClick() {
                PlayerActivityV2.this.lambda$onCreate$0$PlayerActivityV2();
            }
        });
        this.mControlBar.addOnPlayingMusicUpdateListener(this);
        final ArrayList arrayList = new ArrayList(2);
        PlayerFragmentV2 playerFragmentV2 = new PlayerFragmentV2();
        this.mPlayerFragment = playerFragmentV2;
        arrayList.add(TabPagerAdapter.TabPage.newPage(playerFragmentV2));
        PlayerLrcFragment playerLrcFragment2 = new PlayerLrcFragment();
        this.playerLrcFragment = playerLrcFragment2;
        arrayList.add(TabPagerAdapter.TabPage.newPage(playerLrcFragment2));
        this.mViewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager(), arrayList));
        this.mViewPager.addOnPageChangeListener(new ViewPager.O0000Oo() {
            /* class com.xiaomi.mico.music.player.PlayerActivityV2.AnonymousClass1 */

            public void onPageSelected(int i) {
                PlayerActivityV2.this.mTitleBar.getTitleView().setVisibility(i == arrayList.size() + -1 ? 0 : 8);
            }
        });
        int i = 8;
        this.mTitleBar.getTitleView().setVisibility(8);
        TextView textView = this.multiRoomBtn;
        if (AppCapability.hasCapabilityMultiRoomMusic()) {
            i = 0;
        }
        textView.setVisibility(i);
        hxi.O00000o0.f957O000000o.O000000o("content_playpage_page", new Object[0]);
    }

    public /* synthetic */ void lambda$onCreate$0$PlayerActivityV2() {
        finish();
        overridePendingTransition(R.anim.mico_player_close_enter, R.anim.mico_player_close_exit);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!canShowSoundBar() || (i != 24 && i != 25)) {
            return super.onKeyDown(i, keyEvent);
        }
        showSoundBar();
        return true;
    }

    public void showSoundBar() {
        MLAlertDialog O00000o = new MLAlertDialog.Builder(getContext()).O00000o();
        this.playerVolumeBar = (PlayerVolumeBar) LayoutInflater.from(getContext()).inflate((int) R.layout.mico_view_music_player_volume_bar, (ViewGroup) null);
        O00000o.setView(this.playerVolumeBar, 0, 0, 0, 0);
        O00000o.setOnKeyListener(new DialogInterface.OnKeyListener() {
            /* class com.xiaomi.mico.music.player.$$Lambda$PlayerActivityV2$RIHybUqyz3SfmM4GBSBu0XIlG3g */

            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return PlayerActivityV2.this.lambda$showSoundBar$1$PlayerActivityV2(dialogInterface, i, keyEvent);
            }
        });
        O00000o.show();
        this.playerVolumeBar.onResume();
        O00000o.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiaomi.mico.music.player.$$Lambda$PlayerActivityV2$RL1MqUHU8Z4ouh6fHfdSf71eKM */

            public final void onDismiss(DialogInterface dialogInterface) {
                PlayerActivityV2.this.lambda$showSoundBar$2$PlayerActivityV2(dialogInterface);
            }
        });
        int volume = PlayerManager.getInstance().getVolume();
        gsy.O00000Oo("showSoundBar", "start volume is ".concat(String.valueOf(volume)));
        this.playerVolumeBar.updatePlayerVolume(volume);
    }

    public /* synthetic */ boolean lambda$showSoundBar$1$PlayerActivityV2(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (!canShowSoundBar()) {
            return false;
        }
        if (i != 24 && i != 25) {
            return false;
        }
        this.playerVolumeBar.onKeyDown(i, keyEvent);
        return true;
    }

    public /* synthetic */ void lambda$showSoundBar$2$PlayerActivityV2(DialogInterface dialogInterface) {
        PlayerVolumeBar playerVolumeBar2 = this.playerVolumeBar;
        if (playerVolumeBar2 != null) {
            playerVolumeBar2.onPause();
            this.playerVolumeBar.clear();
            this.playerVolumeBar = null;
        }
    }

    private void updateTitle(CharSequence charSequence) {
        TitleBar titleBar = this.mTitleBar;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        titleBar.setTitle(charSequence);
        this.mTitleBar.setTitleMarquee();
    }

    public void onResume() {
        super.onResume();
        if (this.mAttachedFragmentCount == 2) {
            this.mControlBar.onResume();
        }
    }

    public void onViewCreated(Fragment fragment) {
        this.mAttachedFragmentCount++;
        if (this.mAttachedFragmentCount == 2) {
            this.mControlBar.onResume();
        }
        gsy.O00000Oo("PlayerActivityV2 fragment %s onViewCreated", fragment.getClass().getSimpleName());
    }

    public void onPause() {
        super.onPause();
        this.mControlBar.onPause();
    }

    public void onPlayingStatusUpdate(boolean z) {
        this.mPlayerFragment.updatePlayingStatus(z);
    }

    public void onPlaylistUpdateV3(Remote.Response.PlayerStatus playerStatus, boolean z) {
        PlayerListManager.shareInstance().updatePlaylistV3(playerStatus, z);
    }

    public void onPlaylistUpdate(int i, long j, List<Long> list, List<Remote.Response.TrackData> list2) {
        PlayerListManager.shareInstance().updatePlaylist(i, j, list, list2);
    }

    public void onPlayingMusicUpdate(int i, Remote.Response.TrackData trackData) {
        this.playerLrcFragment.updatePlayingMusic(i, trackData);
        this.mPlayerFragment.updatePlayingMusic(i, trackData);
        PlayerListManager.shareInstance().updatePlayingMusic(i, trackData);
        if ("s6".equals(MicoManager.getInstance().getCurrentMicoType()) && trackData != null && trackData.title != null && trackData.title.startsWith("file:")) {
            String str = trackData.title;
            int lastIndexOf = str.lastIndexOf("/");
            gsy.O000000o(3, "ControlBar", "trackingData title / pos:".concat(String.valueOf(lastIndexOf)));
            String substring = str.substring(lastIndexOf + 1, str.length());
            gsy.O000000o(3, "ControlBar", "trackingData title name:".concat(String.valueOf(substring)));
            updateTitle(substring);
        }
    }

    public void onPlayerPositionUpdate(int i, boolean z) {
        this.playerLrcFragment.updatePlayerPosition(i, z);
    }

    public void onPlayingMusicUpdate(Serializable serializable) {
        if (MicoManager.getInstance().currentMicoIsAiProtocolV3() && (serializable instanceof Music.Song)) {
            this.playerLrcFragment.updatePlayingMusicV3((Music.Song) serializable);
        }
        this.mPlayerFragment.updatePlayingMusic(serializable);
        if (!"s6".equals(MicoManager.getInstance().getCurrentMicoType()) || !TextUtils.isEmpty(MusicHelper.getTitle(serializable))) {
            CharSequence singer = MusicHelper.getSinger(serializable);
            CharSequence title = MusicHelper.getTitle(serializable);
            if (serializable instanceof Music.Song) {
                TextUtils.isEmpty(singer);
            }
            updateTitle(title);
            return;
        }
        gsy.O00000Oo("ControlBar", "s6 local, use trackingData");
    }

    public void onPlayingDirectiveUpdate(Remote.Response.Directive directive) {
        this.mPlayerFragment.updatePlayingDirective(directive);
        updateTitle(directive.title);
    }

    public void setCurrentItem(int i) {
        this.mViewPager.setCurrentItem(i);
    }

    @OnClick({6824})
    public void onClickView(View view) {
        showMultiRoomView();
        hxi.O00000o.f952O000000o.O000000o("content_playpage_allplay", new Object[0]);
    }

    private void showMultiRoomView() {
        MultiRoomView multiRoomView = (MultiRoomView) LayoutInflater.from(this).inflate((int) R.layout.mico_view_multi_room, (ViewGroup) null);
        MLAlertDialog O00000o = new MLAlertDialog.Builder(getContext()).O000000o(multiRoomView).O00000o();
        O00000o.setCanceledOnTouchOutside(false);
        multiRoomView.show(O00000o);
    }
}
