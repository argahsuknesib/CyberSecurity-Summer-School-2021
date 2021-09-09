package com.xiaomi.mico.music.detail;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.itemdecoration.Ignore;
import com.xiaomi.mico.common.recyclerview.itemdecoration.ItemDecorationHelper;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.mico.music.adapter.LovableGroupAdapter;
import com.xiaomi.mico.music.cache.MusicCache;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import com.xiaomi.mico.music.viewholder.HeaderViewHolder;
import com.xiaomi.mico.music.viewholder.SimpleViewHolder;
import com.xiaomi.mico.music.viewholder.SongViewHolder;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.util.List;
import rx.Subscription;
import rx.functions.Action1;

public class ArtistDetailActivity extends MicoBaseActivity implements ItemClickableAdapter.OnItemClickListener, LovableAdapter.Lovable, PlayerStatusTrack.onTrackListener {
    private ApiRequest mApiRequest;
    public ArtistDetailAdapter mDetailAdapter;
    DetailHeader mDetailHeader;
    RecyclerView mRecyclerView;
    private Subscription mSubscription;
    DetailTitleBar mTitleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_detail_general);
        this.mDetailHeader = (DetailHeader) findViewById(R.id.detail_header);
        this.mTitleBar = (DetailTitleBar) findViewById(R.id.title_bar);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        Music.Artist artist = (Music.Artist) getIntent().getSerializableExtra("music");
        if (artist == null) {
            finish();
            return;
        }
        this.mTitleBar.addPlayerIndicator();
        this.mDetailHeader.setMusic(artist, true);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.addItemDecoration(ItemDecorationHelper.listDivider(this, 0, 0, new Ignore() {
            /* class com.xiaomi.mico.music.detail.ArtistDetailActivity.AnonymousClass1 */

            public boolean needIgnore(int i, int i2) {
                int itemViewType = ArtistDetailActivity.this.mDetailAdapter.getItemViewType(i);
                return itemViewType == 1 || itemViewType == 3;
            }
        }));
        this.mDetailAdapter = new ArtistDetailAdapter(this);
        this.mDetailAdapter.setOnItemClickListener(this);
        this.mDetailAdapter.setLovable(this);
        this.mRecyclerView.setAdapter(this.mDetailAdapter);
        getArtistHomepage(artist.artistID);
    }

    public void onResume() {
        super.onResume();
        PlayerStatusTrack.getInstance().register(this);
        this.mTitleBar.onResume();
    }

    public void onPause() {
        super.onPause();
        PlayerStatusTrack.getInstance().unregister(this);
        this.mTitleBar.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        ApiRequest apiRequest = this.mApiRequest;
        if (apiRequest != null) {
            apiRequest.cancel();
            this.mApiRequest = null;
        }
        Subscription subscription = this.mSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
            this.mSubscription = null;
        }
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        this.mTitleBar.updatePlayerStatus(playerStatus);
        ArtistDetailAdapter artistDetailAdapter = this.mDetailAdapter;
        if (artistDetailAdapter != null) {
            artistDetailAdapter.updatePlayingSongID(MusicHelper.getPlayingMusicID(playerStatus));
        }
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        GroupAdapter.Group group = this.mDetailAdapter.getGroup(i);
        if (this.mDetailAdapter.isHeader(i)) {
            ((ArtistDetailGroup) group).onHeaderClick();
        } else {
            ((ArtistDetailGroup) group).onItemClick(this.mDetailAdapter.getItemInnerPosition(i));
        }
    }

    public void onLove(View view, Serializable serializable) {
        if (serializable instanceof Music.Song) {
            MusicHelper.addToChannel(getContext(), (Music.Song) serializable);
        }
    }

    private void getArtistHomepage(long j) {
        this.mApiRequest = ApiHelper.getArtistHomepage(j, new ApiRequest.Listener<Music.ArtistHomepage>() {
            /* class com.xiaomi.mico.music.detail.ArtistDetailActivity.AnonymousClass2 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(Music.ArtistHomepage artistHomepage) {
                ArtistDetailActivity.this.mDetailHeader.updateMusic(artistHomepage.artist);
                ArtistDetailActivity.this.getSongs(artistHomepage.songIDList);
                ArtistDetailActivity.this.getAlbums(artistHomepage.albumIDList);
            }
        });
    }

    public void getSongs(List<Long> list) {
        this.mSubscription = MusicCache.getSongs(list).subscribe(new Action1<List<Music.Song>>() {
            /* class com.xiaomi.mico.music.detail.ArtistDetailActivity.AnonymousClass3 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((List<Music.Song>) ((List) obj));
            }

            public void call(List<Music.Song> list) {
                ArtistDetailActivity.this.mDetailAdapter.updateSongList(list);
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.detail.ArtistDetailActivity.AnonymousClass4 */

            public void call(Throwable th) {
            }
        });
    }

    public void getAlbums(List<Long> list) {
        ApiHelper.getAlbumInfo(list, new ApiRequest.Listener<List<Music.Album>>() {
            /* class com.xiaomi.mico.music.detail.ArtistDetailActivity.AnonymousClass5 */

            public void onFailure(ApiError apiError) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Album>) ((List) obj));
            }

            public void onSuccess(List<Music.Album> list) {
                ArtistDetailActivity.this.mDetailAdapter.updateAlbumList(list);
            }
        });
    }

    static class ArtistDetailAdapter extends LovableGroupAdapter<ItemClickableAdapter.ViewHolder> {
        public String playingSongID;

        private ArtistDetailAdapter(Context context) {
            addGroup(new SongGroup(context, this));
            addGroup(new AlbumGroup(context));
        }

        public void updateSongList(List<Music.Song> list) {
            GroupAdapter.Group groupByID = getGroupByID("1");
            if (groupByID != null) {
                ((SongGroup) groupByID).updateDataList(list, 5);
                notifyDataSetChanged();
            }
        }

        public void updateAlbumList(List<Music.Album> list) {
            GroupAdapter.Group groupByID = getGroupByID("2");
            if (groupByID != null) {
                ((AlbumGroup) groupByID).updateDataList(list);
                notifyDataSetChanged();
            }
        }

        public void updatePlayingSongID(String str) {
            if (!CommonUtils.equals(this.playingSongID, str)) {
                this.playingSongID = str;
                int i = 0;
                GroupAdapter.Group groupByID = getGroupByID("1");
                if (groupByID != null) {
                    i = groupByID.getItemCount();
                }
                if (i > 0) {
                    notifyDataSetChanged();
                }
            }
        }

        public ItemClickableAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new HeaderViewHolder.PlayAll(viewGroup, this.onItemClickListener);
            }
            if (i == 2) {
                return new SongViewHolder.Lovable(viewGroup, this.onItemClickListener, this.lovable);
            }
            if (i == 3) {
                return new HeaderViewHolder.Expand(viewGroup, this.onItemClickListener);
            }
            if (i == 4) {
                return new HeaderViewHolder.Comment(viewGroup, null, viewGroup.getContext().getString(R.string.music_all_album));
            }
            return new SimpleViewHolder.Normal(viewGroup, this.onItemClickListener);
        }
    }

    static abstract class ArtistDetailGroup<T> extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        protected Context context;
        protected List<T> dataList;

        public void onHeaderClick() {
        }

        public abstract void onItemClick(int i);

        private ArtistDetailGroup(Context context2) {
            this.context = context2;
        }

        /* access modifiers changed from: protected */
        public void updateDataList(List<T> list) {
            this.dataList = list;
        }

        public int getItemCount() {
            List<T> list = this.dataList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public T getItem(int i) {
            return this.dataList.get(i);
        }
    }

    static class SongGroup extends ArtistDetailGroup<Music.Song> {
        public ArtistDetailAdapter detailAdapter;
        private int expandSize;
        private boolean expanded;

        public String getID() {
            return "1";
        }

        private SongGroup(Context context, ArtistDetailAdapter artistDetailAdapter) {
            super(context);
            this.detailAdapter = artistDetailAdapter;
        }

        /* access modifiers changed from: protected */
        public void updateDataList(List<Music.Song> list, int i) {
            super.updateDataList(list);
            this.expandSize = i;
            this.expanded = i >= list.size();
        }

        public int getItemCount() {
            if (this.expanded) {
                return super.getItemCount();
            }
            int i = this.expandSize;
            if (i > 0) {
                return i + 1;
            }
            return 0;
        }

        public int getItemViewType(int i) {
            if (isHeader(i)) {
                return 1;
            }
            return (this.expanded || i - getHeaderCount() < this.expandSize) ? 2 : 3;
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            if (isHeader(i)) {
                ((HeaderViewHolder.PlayAll) viewHolder).bindView(this.context.getResources(), super.getItemCount());
            } else if (this.expanded || i - getHeaderCount() < this.expandSize) {
                ((SongViewHolder.Lovable) viewHolder).bindView((Music.Song) getItem(i - getHeaderCount()), this.detailAdapter.playingSongID, i);
            }
        }

        public void onHeaderClick() {
            MusicHelper.playSongs(this.dataList, -1, new MusicHelper.OnPlayingListener() {
                /* class com.xiaomi.mico.music.detail.ArtistDetailActivity.SongGroup.AnonymousClass1 */

                public void onPlaying(String str) {
                    SongGroup.this.detailAdapter.updatePlayingSongID(str);
                }
            });
        }

        public void onItemClick(int i) {
            if (this.expanded || i < this.expandSize) {
                MusicHelper.playSongs(this.dataList, i, new MusicHelper.OnPlayingListener() {
                    /* class com.xiaomi.mico.music.detail.ArtistDetailActivity.SongGroup.AnonymousClass2 */

                    public void onPlaying(String str) {
                        SongGroup.this.detailAdapter.updatePlayingSongID(str);
                    }
                });
                return;
            }
            this.expanded = true;
            this.detailAdapter.notifyDataSetChanged();
        }
    }

    static class AlbumGroup extends ArtistDetailGroup<Music.Album> {
        public String getID() {
            return "2";
        }

        private AlbumGroup(Context context) {
            super(context);
        }

        public int getItemViewType(int i) {
            return isHeader(i) ? 4 : 5;
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            if (!isHeader(i)) {
                ((SimpleViewHolder.Normal) viewHolder).bindView((Music.Album) getItem(i - getHeaderCount()));
            }
        }

        public void onItemClick(int i) {
            MusicHelper.processMusic(this.context, (Serializable) getItem(i));
        }
    }
}
