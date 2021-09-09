package com.xiaomi.mico.music.search;

import android.view.View;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.AppCapability;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.widget.OpenQQMusicVipPopupView;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.mico.music.adapter.SongAdapter;
import com.xiaomi.mico.music.player.PlayerActivityV2;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import java.io.Serializable;
import java.util.List;

public class SchSongFragment extends SchBaseFragment<Music.Song> implements LovableAdapter.Lovable, PlayerStatusTrack.onTrackListener {
    /* access modifiers changed from: protected */
    public int getSearchType() {
        return 1;
    }

    public void onActivate() {
        super.onActivate();
        PlayerStatusTrack.getInstance().register(this);
    }

    public void onDeactivate() {
        super.onDeactivate();
        PlayerStatusTrack.getInstance().unregister(this);
    }

    /* access modifiers changed from: protected */
    public LovableAdapter<ItemClickableAdapter.ViewHolder, Music.Song> getAdapter() {
        SongAdapter.Lovable lovable = new SongAdapter.Lovable(false);
        if (getLovable() != null) {
            lovable.setLovable(getLovable());
        }
        return lovable;
    }

    /* access modifiers changed from: protected */
    public List<Music.Song> parseResult(Music.SearchResult searchResult) {
        return searchResult.songList;
    }

    /* access modifiers changed from: protected */
    public boolean canLoadMore() {
        return this.mAdapter.getDataList() == null || this.mAdapter.getDataList().size() < 200 || !MicoManager.getInstance().limitingPlayMusicSize();
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        List dataList = this.mAdapter.getDataList();
        if (!ContainerUtil.isEmpty(dataList)) {
            OpenQQMusicVipPopupView.showOpenVipPopupView((Music.Song) dataList.get(i), getContext());
        }
        MusicHelper.playSongs(dataList, i, new MusicHelper.OnPlayingListener() {
            /* class com.xiaomi.mico.music.search.SchSongFragment.AnonymousClass1 */

            public void onPlaying(String str) {
                if (SchSongFragment.this.isAdded()) {
                    ((SongAdapter.Lovable) SchSongFragment.this.mAdapter).updatePlayingMusicID(str);
                    PlayerActivityV2.displayPlayerWithAnim(SchSongFragment.this.getContext());
                }
            }
        });
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        if (this.mAdapter != null) {
            ((SongAdapter.Lovable) this.mAdapter).updatePlayingMusicID(MusicHelper.getPlayingMusicID(playerStatus));
        }
    }

    public void onLove(View view, Serializable serializable) {
        MusicHelper.addToChannel(getContext(), (Music.Song) serializable);
    }

    /* access modifiers changed from: protected */
    public LovableAdapter.Lovable getLovable() {
        if (!AppCapability.hasCapabilitySongCollection()) {
            return null;
        }
        return this;
    }
}
