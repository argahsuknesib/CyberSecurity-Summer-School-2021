package com.xiaomi.mico.music.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.OpenQQMusicVIPView;
import com.xiaomi.mico.music.adapter.SongAdapter;
import com.xiasuhuei321.loadingdialog.view.LoadCircleView;
import java.util.List;

public class PlayerList extends LinearLayout {
    @BindView(5920)
    TextView btnClose;
    private SongAdapter.PlayerListAdapter listAdapter;
    @BindView(6235)
    FrameLayout mFrameLayout;
    @BindView(6823)
    LoadCircleView mLoading;
    @BindView(6734)
    OpenQQMusicVIPView openVipView;
    @BindView(6434)
    RecyclerView recyclerView;

    public PlayerList(Context context) {
        super(context);
    }

    public PlayerList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        ViewGroup.LayoutParams layoutParams = this.mFrameLayout.getLayoutParams();
        layoutParams.height = (int) (((float) DisplayUtils.getScreenHeightPixels(getContext())) * 0.55f);
        this.mFrameLayout.setLayoutParams(layoutParams);
    }

    public void setLoadingUI(boolean z) {
        int i = 8;
        this.recyclerView.setVisibility(z ? 8 : 0);
        LoadCircleView loadCircleView = this.mLoading;
        if (z) {
            i = 0;
        }
        loadCircleView.setVisibility(i);
    }

    public void setAdapter(RecyclerView.O000000o o000000o, RecyclerView.O00oOooO o00oOooO) {
        this.listAdapter = (SongAdapter.PlayerListAdapter) o000000o;
        this.recyclerView.addOnScrollListener(o00oOooO);
        this.recyclerView.setAdapter(o000000o);
    }

    public void setCloseBtnClickListener(View.OnClickListener onClickListener) {
        this.btnClose.setOnClickListener(onClickListener);
    }

    public void scrollToPlayingPosition() {
        int playingPosition = getPlayingPosition();
        if (playingPosition != -1) {
            this.recyclerView.smoothScrollToPosition(playingPosition);
        }
    }

    private int getPlayingPosition() {
        Remote.Response.PlayerStatus playerStatus;
        int i;
        List dataList = this.listAdapter.getDataList();
        if (!(ContainerUtil.isEmpty(dataList) || (playerStatus = PlayerManager.getInstance().getPlayerStatus()) == null || playerStatus.play_song_detail == null)) {
            int i2 = 0;
            if (playerStatus.media_type == -1) {
                i = 0;
                while (i < dataList.size()) {
                    Object obj = dataList.get(i);
                    if ((obj instanceof Music.Song) && String.valueOf(playerStatus.play_song_detail.audio_id).equals(((Music.Song) obj).audioID)) {
                        return i;
                    }
                    i++;
                }
            } else {
                i = -1;
            }
            if (MusicHelper.isPlayingSong(playerStatus.media_type)) {
                while (true) {
                    if (i2 >= dataList.size()) {
                        break;
                    }
                    Object obj2 = dataList.get(i2);
                    if (obj2 instanceof Music.Song) {
                        if (((Music.Song) obj2).songID == playerStatus.play_song_detail.musicID) {
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            } else {
                if (MusicHelper.isPlayingStation(playerStatus.media_type)) {
                    while (true) {
                        if (i2 >= dataList.size()) {
                            break;
                        }
                        Object obj3 = dataList.get(i2);
                        if (obj3 instanceof Music.Station) {
                            if (CommonUtils.equals(((Music.Station) obj3).stationID, playerStatus.play_song_detail.cpID)) {
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                } else {
                    i2 = MusicHelper.isPlayingDirective(playerStatus.media_type) ? dataList.indexOf(playerStatus.play_song_detail.getTrackingData().toDirective()) : i;
                }
                if (i2 >= 0 || i2 >= dataList.size()) {
                    return -1;
                }
                return i2;
            }
            i2 = -1;
            if (i2 >= 0) {
            }
        }
        return -1;
    }

    public void updateQQMusicVipStatus() {
        OpenQQMusicVIPView openQQMusicVIPView = this.openVipView;
        openQQMusicVIPView.updateOpenVipViewVisibility(openQQMusicVIPView.getContext());
    }
}
