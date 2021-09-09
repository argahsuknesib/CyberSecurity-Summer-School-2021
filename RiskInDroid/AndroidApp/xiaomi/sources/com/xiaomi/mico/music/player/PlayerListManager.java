package com.xiaomi.mico.music.player;

import _m_j.gsy;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.recyclerview.LoadMoreListener;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.OpenQQMusicVipPopupView;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.SongAdapter;
import com.xiaomi.mico.music.cache.MusicCache;
import com.xiaomi.mico.music.channel.ChannelManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class PlayerListManager implements ItemClickableAdapter.OnItemClickListener {
    private static volatile PlayerListManager playerListManager;
    public List<Long> audioIdList;
    private Context contextShowPlayerList;
    public List dataList;
    public int lastIndex;
    public ListProvider mListProvider;
    public LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
        /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass1 */

        public void onLoadMore() {
            if (PlayerListManager.this.mListProvider != null) {
                PlayerListManager.this.mLoadMoreListener.setCanLoadMore(false);
                Remote.Response.PlayerStatus playerStatus = PlayerManager.getInstance().getPlayerStatus();
                if (PlayerListManager.this.mListProvider.mediaType == -1) {
                    PlayerListManager.this.audioIdList.clear();
                    if (!(playerStatus == null || playerStatus.track_list == null)) {
                        for (int i = PlayerListManager.this.lastIndex; i < playerStatus.track_list.size() && PlayerListManager.this.audioIdList.size() < 50; i++) {
                            PlayerListManager.this.audioIdList.add(playerStatus.track_list.get(i));
                        }
                    }
                    PlayerListManager.this.lastIndex += PlayerListManager.this.audioIdList.size();
                    gsy.O00000Oo("PlayerListManager", "PlayerListManager  mLoadMoreListener audioIdListSize: " + PlayerListManager.this.audioIdList.size() + " audioId: " + PlayerListManager.this.audioIdList);
                    PlayerListManager playerListManager = PlayerListManager.this;
                    playerListManager.subscription = playerListManager.mListProvider.getSongListV3(PlayerListManager.this.audioIdList).subscribe(new Action1<List<Music.Song>>() {
                        /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass1.AnonymousClass1 */

                        public /* bridge */ /* synthetic */ void call(Object obj) {
                            call((List<Music.Song>) ((List) obj));
                        }

                        public void call(List<Music.Song> list) {
                            PlayerListManager.this.mLoadMoreListener.finishLoading();
                            PlayerListManager.this.mLoadMoreListener.setCanLoadMore(list.size() > 0);
                            if (list.size() > 0) {
                                PlayerListManager.this.playerListAdapter.addDataList(list);
                                PlayerListManager.this.dataList.addAll(list);
                            }
                        }
                    }, new Action1<Throwable>() {
                        /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass1.AnonymousClass2 */

                        public void call(Throwable th) {
                            PlayerListManager.this.mLoadMoreListener.finishLoading();
                        }
                    });
                    return;
                }
                PlayerListManager playerListManager2 = PlayerListManager.this;
                playerListManager2.subscription = playerListManager2.mListProvider.getSongList(PlayerListManager.this.playerListAdapter.getDataSize()).subscribe(new Action1<List<Music.Song>>() {
                    /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass1.AnonymousClass3 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((List<Music.Song>) ((List) obj));
                    }

                    public void call(List<Music.Song> list) {
                        PlayerListManager.this.mLoadMoreListener.finishLoading();
                        PlayerListManager.this.mLoadMoreListener.setCanLoadMore(list.size() > 0);
                        if (list.size() > 0) {
                            PlayerListManager.this.playerListAdapter.addDataList(list);
                            PlayerListManager.this.dataList.addAll(list);
                        }
                    }
                }, new Action1<Throwable>() {
                    /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass1.AnonymousClass4 */

                    public void call(Throwable th) {
                        PlayerListManager.this.mLoadMoreListener.finishLoading();
                    }
                });
            }
        }
    };
    public SongAdapter.PlayerListAdapter playerListAdapter = new SongAdapter.PlayerListAdapter(false);
    private PlayerList playerListWidget;
    public Subscription subscription;

    public static class ForceFreshPlayingDataEvent {
    }

    public static PlayerListManager shareInstance() {
        if (playerListManager == null) {
            synchronized (PlayerListManager.class) {
                if (playerListManager == null) {
                    playerListManager = new PlayerListManager();
                }
            }
        }
        return playerListManager;
    }

    private PlayerListManager() {
        this.playerListAdapter.setOnItemClickListener(this);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"InflateParams"})
    public void popupPlayList(Context context) {
        this.contextShowPlayerList = context;
        MLAlertDialog O00000o = new MLAlertDialog.Builder(context).O00000o();
        this.playerListWidget = (PlayerList) LayoutInflater.from(context).inflate((int) R.layout.mico_view_music_player_list, (ViewGroup) null);
        this.playerListWidget.setAdapter(this.playerListAdapter, this.mLoadMoreListener);
        this.playerListWidget.updateQQMusicVipStatus();
        this.playerListWidget.setCloseBtnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.player.$$Lambda$PlayerListManager$unsYKYlqCdxcBu4Us_Eo4ZQcmF8 */

            public final void onClick(View view) {
                MLAlertDialog.this.dismiss();
            }
        });
        O00000o.setView(this.playerListWidget, 0, 0, 0, 0);
        O00000o.show();
        O00000o.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiaomi.mico.music.player.$$Lambda$PlayerListManager$dLGnBTMZGQEkJR88uoduMrXz6Q */

            public final void onDismiss(DialogInterface dialogInterface) {
                PlayerListManager.this.lambda$popupPlayList$1$PlayerListManager(dialogInterface);
            }
        });
        if (hasData()) {
            this.playerListWidget.setLoadingUI(false);
            this.playerListAdapter.updateDataList(this.dataList);
            this.playerListWidget.scrollToPlayingPosition();
            return;
        }
        new Object[1][0] = "PlayerListManager popupPlayList need loading";
        this.playerListWidget.setLoadingUI(true);
    }

    public /* synthetic */ void lambda$popupPlayList$1$PlayerListManager(DialogInterface dialogInterface) {
        PlayerList playerList = this.playerListWidget;
        if (playerList != null) {
            playerList.setAdapter(null, null);
            this.playerListWidget = null;
        }
    }

    private boolean hasData() {
        List list = this.dataList;
        return list != null && list.size() > 0;
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        long j;
        Object data = this.playerListAdapter.getData(i);
        if (data instanceof Music.Song) {
            Music.Song song = (Music.Song) data;
            OpenQQMusicVipPopupView.showOpenVipPopupView(song, this.contextShowPlayerList);
            if (!song.isLegal()) {
                ToastUtil.showToast((int) R.string.music_play_illegal);
                return;
            }
            j = song.duration;
        } else if (!(data instanceof Music.Station) || ((Music.Station) data).isLegal()) {
            j = 0;
        } else {
            ToastUtil.showToast((int) R.string.music_play_illegal);
            return;
        }
        PlayerManager.getInstance().playIndex(this.playerListAdapter.getDataIndex(i), j, null);
    }

    private void cancelSubscription() {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null && !subscription2.isUnsubscribed()) {
            this.subscription.unsubscribe();
            this.subscription = null;
        }
    }

    private void resetPlaylist() {
        cancelSubscription();
        this.mListProvider = null;
        this.mLoadMoreListener.setCanLoadMore(false);
        this.mLoadMoreListener.finishLoading();
        this.playerListAdapter.updatePlayingMusicID(null, false);
        this.playerListAdapter.clearAllData(true);
        this.lastIndex = 0;
    }

    public void updatePlaylistV3(Remote.Response.PlayerStatus playerStatus, final boolean z) {
        List<Long> list = this.audioIdList;
        if (list == null) {
            this.audioIdList = new ArrayList();
        } else {
            list.clear();
        }
        if (!z) {
            resetPlaylist();
            if (!(playerStatus == null || playerStatus.track_list == null)) {
                for (int i = 0; i < playerStatus.track_list.size() && this.audioIdList.size() < 50; i++) {
                    this.audioIdList.add(playerStatus.track_list.get(i));
                }
            }
            this.lastIndex += this.audioIdList.size();
            if (this.audioIdList.size() > 1) {
                StringBuilder sb = new StringBuilder("PlayerListManager updatePlaylistV3 初次加载个数：");
                sb.append(this.audioIdList.size());
                sb.append(" 最后一个：");
                List<Long> list2 = this.audioIdList;
                sb.append(list2.get(list2.size() - 1));
                new Object[1][0] = sb.toString();
            }
        } else {
            if (!(playerStatus == null || playerStatus.track_list == null)) {
                for (int i2 = this.lastIndex; i2 < playerStatus.track_list.size() && this.audioIdList.size() < 50; i2++) {
                    this.audioIdList.add(playerStatus.track_list.get(i2));
                }
            }
            this.lastIndex += this.audioIdList.size();
            gsy.O00000Oo("PlayerListManager", "PlayerListManager 音箱loadmore触发加载更多：" + this.audioIdList);
        }
        if (!this.audioIdList.isEmpty()) {
            if (this.mListProvider == null) {
                this.mListProvider = new ListProvider();
            }
            this.subscription = this.mListProvider.getSongListV3(this.audioIdList).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<Music.Song>>() {
                /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass2 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((List<Music.Song>) ((List) obj));
                }

                public void call(List<Music.Song> list) {
                    boolean z = true;
                    new Object[1][0] = "PlayerListManager updatePlaylistV3 getSongListV3 success songList size:" + list.size();
                    LoadMoreListener loadMoreListener = PlayerListManager.this.mLoadMoreListener;
                    if (list.size() <= 0) {
                        z = false;
                    }
                    loadMoreListener.setCanLoadMore(z);
                    if (!z) {
                        PlayerListManager.this.updateDataList(list);
                        return;
                    }
                    PlayerListManager.this.playerListAdapter.addDataList(list);
                    PlayerListManager.this.dataList.addAll(list);
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass3 */

                public void call(Throwable th) {
                    Object[] objArr = {"PlayerListManager updatePlaylistV3 getSongListV3", th};
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void updatePlaylist(int i, long j, List<Long> list, List<Remote.Response.TrackData> list2) {
        resetPlaylist();
        if (!ContainerUtil.isEmpty(list2) || !ContainerUtil.isEmpty(list)) {
            this.mListProvider = new ListProvider(i, j);
            if (MusicHelper.isPlayingSong(i)) {
                this.subscription = MusicCache.getSongs(songListId(list, list2)).subscribe(new Action1<List<Music.Song>>() {
                    /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass4 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((List<Music.Song>) ((List) obj));
                    }

                    public void call(List<Music.Song> list) {
                        PlayerListManager.this.updateDataList(list);
                    }
                }, new Action1<Throwable>() {
                    /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass5 */

                    public void call(Throwable th) {
                        Object[] objArr = {"PlayerListManager updatePlaylist getSongs", th};
                    }
                });
            } else if (MusicHelper.isPlayingDirective(i)) {
                ArrayList arrayList = new ArrayList(list2.size());
                for (Remote.Response.TrackData directive : list2) {
                    arrayList.add(directive.toDirective());
                }
                updateDataList(arrayList);
            } else {
                int playingStationType = MusicHelper.getPlayingStationType(i, -1);
                if (playingStationType != -1) {
                    ArrayList arrayList2 = new ArrayList();
                    if (list2 != null) {
                        for (Remote.Response.TrackData next : list2) {
                            arrayList2.add(new Music.Station.Simple(next.musicID, next.cpID, next.cpOrigin, playingStationType));
                        }
                    }
                    this.subscription = ObservableApiHelper.getStationInfo(arrayList2).subscribe(new Action1<List<Music.Station>>() {
                        /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass6 */

                        public /* bridge */ /* synthetic */ void call(Object obj) {
                            call((List<Music.Station>) ((List) obj));
                        }

                        public void call(List<Music.Station> list) {
                            PlayerListManager.this.updateDataList(list);
                        }
                    }, new Action1<Throwable>() {
                        /* class com.xiaomi.mico.music.player.PlayerListManager.AnonymousClass7 */

                        public void call(Throwable th) {
                        }
                    });
                }
            }
        }
    }

    private List<Long> songListId(List<Long> list, List<Remote.Response.TrackData> list2) {
        ArrayList arrayList = new ArrayList();
        if (list2 == null || list2.isEmpty()) {
            return (list == null || list.isEmpty()) ? arrayList : list;
        }
        for (Remote.Response.TrackData trackData : list2) {
            arrayList.add(Long.valueOf(trackData.musicID));
        }
        return arrayList;
    }

    public void updatePlayingMusic(int i, Remote.Response.TrackData trackData) {
        String playingMusicID = MusicHelper.getPlayingMusicID(i, trackData);
        if (!TextUtils.isEmpty(playingMusicID)) {
            this.playerListAdapter.updatePlayingMusicID(playingMusicID);
        } else if (!MusicHelper.isPlayingDirective(i) || trackData == null) {
            this.playerListAdapter.resetPlaying();
        } else {
            this.playerListAdapter.updatePlayingDirective(trackData.toDirective());
        }
    }

    public void updatePlayingMusic(Serializable serializable) {
        this.playerListAdapter.updatePlayingMusicID(MusicHelper.getID(serializable));
    }

    public void updateDataList(List list) {
        this.dataList = list;
        if (this.playerListWidget != null) {
            this.playerListAdapter.updateDataList(list);
            this.playerListWidget.setLoadingUI(false);
            this.playerListWidget.scrollToPlayingPosition();
        }
    }

    static class ListProvider {
        public long id;
        public int mediaType;

        public ListProvider() {
            this.mediaType = -1;
        }

        private ListProvider(int i, long j) {
            this.mediaType = -1;
            this.mediaType = i;
            this.id = j;
        }

        public Observable<List<Music.Song>> getSongListV3(List<Long> list) {
            return MusicCache.getSongsV3(list).retryWhen(new RxUtil.RetryWithDelay(100, 2));
        }

        public Observable<List<Music.Song>> getSongList(final int i) {
            if (MusicHelper.isPlayingAlbum(this.mediaType)) {
                return Observable.unsafeCreate(new Observable.OnSubscribe<List<Music.Song>>() {
                    /* class com.xiaomi.mico.music.player.PlayerListManager.ListProvider.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((Subscriber<? super List<Music.Song>>) ((Subscriber) obj));
                    }

                    public void call(final Subscriber<? super List<Music.Song>> subscriber) {
                        PlayerManager.getInstance().getAlbumInfo(ListProvider.this.id, new ApiRequest.Listener<Music.Album>() {
                            /* class com.xiaomi.mico.music.player.PlayerListManager.ListProvider.AnonymousClass1.AnonymousClass1 */

                            public void onSuccess(Music.Album album) {
                                if (!subscriber.isUnsubscribed()) {
                                    subscriber.onNext(album.songList);
                                    subscriber.onCompleted();
                                }
                            }

                            public void onFailure(ApiError apiError) {
                                if (!subscriber.isUnsubscribed()) {
                                    subscriber.onError(apiError.toThrowable());
                                }
                            }
                        });
                    }
                });
            }
            return MusicHelper.isPlayingSheet(this.mediaType) ? Observable.unsafeCreate(new Observable.OnSubscribe<List<Music.Song>>() {
                /* class com.xiaomi.mico.music.player.PlayerListManager.ListProvider.AnonymousClass2 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super List<Music.Song>>) ((Subscriber) obj));
                }

                public void call(final Subscriber<? super List<Music.Song>> subscriber) {
                    ChannelManager.getInstance().getChannelInfo(ListProvider.this.id, i, 20, new ApiRequest.Listener<Music.Channel>() {
                        /* class com.xiaomi.mico.music.player.PlayerListManager.ListProvider.AnonymousClass2.AnonymousClass1 */

                        public void onSuccess(Music.Channel channel) {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onNext(channel.songList);
                                subscriber.onCompleted();
                            }
                        }

                        public void onFailure(ApiError apiError) {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onError(apiError.toThrowable());
                            }
                        }
                    });
                }
            }) : Observable.error(new Throwable("Media Type Error!"));
        }
    }
}
