package com.xiaomi.mico.music.search;

import android.view.ViewGroup;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.mico.music.player.PlayerActivityV2;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import com.xiaomi.mico.music.viewholder.DefaultViewHolder;
import java.util.List;

public class SchStationFragment extends SchBaseFragment<Music.Station> implements PlayerStatusTrack.onTrackListener {
    /* access modifiers changed from: protected */
    public int getSearchType() {
        return 4;
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
    public LovableAdapter<ItemClickableAdapter.ViewHolder, Music.Station> getAdapter() {
        return new SchStationAdapter();
    }

    /* access modifiers changed from: protected */
    public List<Music.Station> parseResult(Music.SearchResult searchResult) {
        return searchResult.stationList;
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        Music.Station station = (Music.Station) this.mAdapter.getData(i);
        if (((SchStationAdapter) this.mAdapter).isPlayingStation(station.stationID)) {
            PlayerActivityV2.displayPlayerWithAnim(getContext());
        } else {
            MusicHelper.processMusic(getContext(), station, new MusicHelper.OnPlayingListener() {
                /* class com.xiaomi.mico.music.search.SchStationFragment.AnonymousClass1 */

                public void onPlaying(String str) {
                    if (SchStationFragment.this.isAdded()) {
                        ((SchStationAdapter) SchStationFragment.this.mAdapter).updatePlayingStationID(str);
                    }
                }
            });
        }
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        if (this.mAdapter != null) {
            ((SchStationAdapter) this.mAdapter).updatePlayingStationID(MusicHelper.getPlayingMusicID(playerStatus));
        }
    }

    static class SchStationAdapter extends LovableAdapter<ItemClickableAdapter.ViewHolder, Music.Station> {
        private String playingStationID;

        private SchStationAdapter() {
        }

        public void updatePlayingStationID(String str) {
            if (!CommonUtils.equals(this.playingStationID, str)) {
                this.playingStationID = str;
                if (getDataSize() > 0) {
                    notifyDataSetChanged();
                }
            }
        }

        public ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
            return new DefaultViewHolder.Lovable(viewGroup, this.onItemClickListener, null);
        }

        public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindItemViewHolder(viewHolder, i);
            ((DefaultViewHolder.Lovable) viewHolder).bindViewV2((Music.Station) getData(i), this.playingStationID);
        }

        public boolean isPlayingStation(String str) {
            String str2 = this.playingStationID;
            return (str2 == null || str == null || !str.equals(str2)) ? false : true;
        }
    }
}
