package com.xiaomi.mico.music.recentplay;

import _m_j.gsy;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.mico.api.RecentPlayApiHelper;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.editorbar.ActionMenu;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.widget.OpenQQMusicVipPopupView;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.detail.DetailListTab;
import com.xiaomi.mico.music.detail.DetailListTab2;
import com.xiaomi.mico.music.favourite.BasePersonalFragment;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import com.xiaomi.smarthome.R;
import java.util.List;
import rx.Observable;

public class RecentPlaySongFragment extends BasePersonalFragment<Music.Song> implements PlayerStatusTrack.onTrackListener {
    DetailListTab2 detailListTab;
    private String pageType;

    public int getFavType() {
        return 4;
    }

    public int getLayoutId() {
        return R.layout.fragment_rencent_play;
    }

    public ActionMenu.MenuCallback getMenuCallback() {
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        PlayerStatusTrack.getInstance().register(this);
        this.detailListTab = (DetailListTab2) onCreateView.findViewById(R.id.detail_list_tab2);
        this.detailListTab.setPlayAllListener(new DetailListTab.DetailPlayAllListener() {
            /* class com.xiaomi.mico.music.recentplay.$$Lambda$RecentPlaySongFragment$6_mJGAXD7GDpzY5gY8ZXmFaTayI */

            public final void onPlayAll() {
                RecentPlaySongFragment.this.lambda$onCreateView$0$RecentPlaySongFragment();
            }
        });
        return onCreateView;
    }

    public /* synthetic */ void lambda$onCreateView$0$RecentPlaySongFragment() {
        if (this.mAdapter.getItemCount() > 0) {
            onItemClick(null, 0);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        PlayerStatusTrack.getInstance().unregister(this);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            this.pageType = (String) getArguments().get("PAGE_TYPE");
        }
    }

    public Observable<List<Music.Song>> getListObservable() {
        return RecentPlayApiHelper.getRecentPlayListObservable();
    }

    public String getStationType() {
        return this.pageType;
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        List dataList = this.mAdapter.getDataList();
        if (!ContainerUtil.isEmpty(dataList)) {
            onPlay(dataList, this.mAdapter.isHeaderByPosition(i) ? -1 : this.mAdapter.getDataIndex(i), new MusicHelper.OnPlayingListener() {
                /* class com.xiaomi.mico.music.recentplay.$$Lambda$RecentPlaySongFragment$sfzbCib22ONezNxP73YOPmbpgiw */

                public final void onPlaying(String str) {
                    RecentPlaySongFragment.this.lambda$onItemClick$1$RecentPlaySongFragment(str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onItemClick$1$RecentPlaySongFragment(String str) {
        this.mAdapter.updatePlayingMusicID(str);
    }

    /* access modifiers changed from: protected */
    public void onPlay(List<Music.Song> list, int i, MusicHelper.OnPlayingListener onPlayingListener) {
        OpenQQMusicVipPopupView.showOpenVipPopupView(list.get(i), getContext());
        MusicHelper.playSongs(list, i, onPlayingListener);
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        if (this.mAdapter != null) {
            this.mAdapter.updatePlayingMusicID(MusicHelper.getPlayingMusicID(playerStatus));
        }
    }

    public void handleFetchFailed() {
        super.handleFetchFailed();
        updateDetailListTabVisibility();
        gsy.O00000Oo(12000, "12000.4.2", "remote song fail");
    }

    public void handleFetchSuccess(List<Music.Song> list) {
        super.handleFetchSuccess(list);
        updateDetailListTabVisibility();
    }

    private void updateDetailListTabVisibility() {
        this.detailListTab.setVisibility(ContainerUtil.isEmpty(this.mAdapter.getDataList()) ? 8 : 0);
    }
}
