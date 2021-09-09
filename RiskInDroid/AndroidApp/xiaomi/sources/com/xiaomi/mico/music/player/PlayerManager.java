package com.xiaomi.mico.music.player;

import _m_j.fg;
import _m_j.gsy;
import _m_j.jgc;
import _m_j.jgi;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.WrappedApiListener;
import com.xiaomi.mico.api.WrappedIncompleteApiListener;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.util.Base64Coder;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.cache.MusicCache;
import com.xiaomi.mico.music.event.MusicEvent;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class PlayerManager {
    private static PlayerManager sInstance = new PlayerManager();
    public volatile Remote.Response.PlayerStatus mPlayerStatus;
    private final PlayingRepair mPlayingRepair;
    private AtomicInteger mQueryCount = new AtomicInteger(0);
    private Subscription mQuerySubscription;
    public volatile fg<Remote.Response.PlayerStatus> mUwbRemoteLiveData;
    public int mVolume = 5;
    private String queryDeviceId = MicoManager.getInstance().getCurrentMicoID();

    public static PlayerManager getInstance() {
        return sInstance;
    }

    private PlayerManager() {
        jgc.O000000o().O000000o(this);
        this.mPlayingRepair = new PlayingRepair();
    }

    public void setQueryDeviceId(String str) {
        this.queryDeviceId = str;
        resetAndQuery(true);
    }

    public String getQueryDeviceId() {
        return this.queryDeviceId;
    }

    public Remote.Response.PlayerStatus getPlayerStatus() {
        return this.mPlayerStatus;
    }

    public int getVolume() {
        if (this.mPlayerStatus != null) {
            return this.mPlayerStatus.volume;
        }
        return this.mVolume;
    }

    public void startQuery() {
        if (this.mQueryCount.incrementAndGet() == 1) {
            startQueryInner();
        }
    }

    public void stopQuery() {
        int decrementAndGet = this.mQueryCount.decrementAndGet();
        if (decrementAndGet <= 0) {
            stopQueryInner();
            this.mQueryCount.compareAndSet(decrementAndGet, 0);
            stripPlayerStatus(true);
        }
    }

    public void setUwbRemoteLiveData(fg<Remote.Response.PlayerStatus> fgVar) {
        this.mUwbRemoteLiveData = fgVar;
    }

    private void startQueryInner() {
        if (!TextUtils.isEmpty(this.queryDeviceId)) {
            this.mQuerySubscription = queryObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Remote.Response.PlayerStatus>() {
                /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass1 */

                public void call(Remote.Response.PlayerStatus playerStatus) {
                    PlayerManager.this.updatePlayerStatus(playerStatus);
                    if (PlayerManager.this.mUwbRemoteLiveData != null) {
                        PlayerManager.this.mUwbRemoteLiveData.postValue(PlayerManager.this.mPlayerStatus);
                    }
                }
            });
        }
    }

    private void stopQueryInner() {
        Subscription subscription = this.mQuerySubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mQuerySubscription.unsubscribe();
            this.mQuerySubscription = null;
        }
    }

    @Deprecated
    private Observable<Remote.Response.PlayerStatus> queryPlayStatus() {
        return ObservableApiHelper.remote(MicoManager.getInstance().getCurrentMicoID(), "mediaplayer", "player_get_play_status", "{}", Remote.Response.PlayerStatus.class);
    }

    private Observable<Remote.Response.PlayerStatus> queryObservable() {
        return ObservableApiHelper.remote(this.queryDeviceId, "mediaplayer", "player_get_play_status", "{}", Remote.Response.PlayerStatus.class).retryWhen(new RxUtil.RetryWithDelay(5000)).repeatWhen(new RxUtil.RepeatWithDelay(5000));
    }

    public ApiRequest playSong(Music.Song song, IncompleteApiListener incompleteApiListener) {
        return playSongs(-1, Collections.singletonList(song), 0, incompleteApiListener);
    }

    public ApiRequest playSongs(long j, List<Music.Song> list, int i, IncompleteApiListener incompleteApiListener) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Song list must not be empty when play songs");
        }
        return ApiHelper.remote(this.queryDeviceId, "mediaplayer", "player_play_music", MicoManager.getInstance().currentMicoIsAiProtocolV3() ? Remote.Request.buildV3PlaySongJson("SONGBOOK", list, j, i) : Remote.Request.buildSongListMessage(list, i), new WrappedIncompleteApiListener<Remote.Response.NullInfo>(incompleteApiListener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass2 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                super.onSuccess((Object) nullInfo);
                PlayerManager.this.updatePlayerControlerState();
            }

            public void onFailure(ApiError apiError) {
                super.onFailure(apiError);
                gsy.O00000Oo("Mico-Api", "player_play_music-->" + apiError.toString());
            }
        }, Remote.Response.NullInfo.class);
    }

    public ApiRequest playStation(Music.Station station, IncompleteApiListener incompleteApiListener) {
        return playStations(null, Collections.singletonList(station), 0, station.isReverse, incompleteApiListener);
    }

    public ApiRequest playStations(String str, List<Music.Station> list, int i, String str2, IncompleteApiListener incompleteApiListener) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Station list must not be empty when play songs");
        }
        return ApiHelper.remote(this.queryDeviceId, "mediaplayer", "player_play_music", MicoManager.getInstance().currentMicoIsAiProtocolV3() ? Remote.Request.buildV3PlayStationListMessage(str, list, i, str2) : Remote.Request.buildStationListMessage(str, list, i), new WrappedIncompleteApiListener<Remote.Response.NullInfo>(incompleteApiListener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass3 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                super.onSuccess((Object) nullInfo);
                PlayerManager.this.updatePlayerControlerState();
            }

            public void onFailure(ApiError apiError) {
                super.onFailure(apiError);
                gsy.O00000Oo("Mico-Api", "player_play_music-->" + apiError.toString());
            }
        }, Remote.Response.NullInfo.class);
    }

    public ApiRequest playList(int i, long j, List<Music.Song> list, int i2, IncompleteApiListener incompleteApiListener) {
        final String str = MicoManager.getInstance().currentMicoIsAiProtocolV3() ? "player_play_music" : "player_play_album_playlist";
        return ApiHelper.remote(this.queryDeviceId, "mediaplayer", str, MicoManager.getInstance().currentMicoIsAiProtocolV3() ? Remote.Request.buildV3PlaySongJson("PLAYLIST", list, j, i2) : Remote.Request.buildSimpleMessage(i, j, i2), new WrappedIncompleteApiListener<Remote.Response.NullInfo>(incompleteApiListener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass4 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                super.onSuccess((Object) nullInfo);
                PlayerManager.this.updatePlayerControlerState();
            }

            public void onFailure(ApiError apiError) {
                super.onFailure(apiError);
                gsy.O00000Oo("Mico-Api", str + "-->" + apiError.toString());
            }
        }, Remote.Response.NullInfo.class);
    }

    public ApiRequest playPrivate(ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(this.queryDeviceId).path("mediaplayer").method("player_play_private_fm").param("media", "app_android").listener(new WrappedApiListener<Remote.Response.NullInfo>(listener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass5 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                super.onSuccess((Object) nullInfo);
                PlayerManager.this.updatePlayerControlerState();
            }
        }).classOf(Remote.Response.NullInfo.class).build();
    }

    public ApiRequest playIndex(int i, long j, IncompleteApiListener incompleteApiListener) {
        final int i2 = i;
        final long j2 = j;
        return ApiHelper.remote(this.queryDeviceId, "mediaplayer", "player_play_index", Remote.Request.buildPlayerIndex(i), new WrappedIncompleteApiListener<Remote.Response.NullInfo>(incompleteApiListener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass6 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                super.onSuccess((Object) nullInfo);
                PlayerManager.this.updatePlayerIndex(i2, j2);
                PlayerManager.this.updatePlayerControlerState();
            }
        }, Remote.Response.NullInfo.class);
    }

    public ApiRequest setPosition(long j, IncompleteApiListener incompleteApiListener) {
        this.mPlayingRepair.setPosition(j);
        return ApiHelper.remote(this.queryDeviceId, "mediaplayer", "player_set_positon", Remote.Request.buildPlayerPosition(j), new WrappedIncompleteApiListener(incompleteApiListener), Remote.Response.NullInfo.class);
    }

    public ApiRequest getRecent(ApiRequest.Listener<Remote.Response.Recent> listener) {
        return ApiHelper.remote(this.queryDeviceId, "mediaplayer", "player_get_latest_playlist", "{}", listener, Remote.Response.Recent.class);
    }

    public ApiRequest searchMusic(String str, final int i, int i2, int i3, boolean z, ApiRequest.Listener<Music.SearchResult> listener) {
        return ApiHelper.searchMusic(str, i, i2, i3, z, new WrappedApiListener<Music.SearchResult>(listener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass7 */

            public void onSuccess(Music.SearchResult searchResult) {
                super.onSuccess((Object) searchResult);
                if (1 == i) {
                    MusicCache.addSongs(searchResult.songList);
                }
            }
        });
    }

    public ApiRequest getAlbumInfo(long j, ApiRequest.Listener<Music.Album> listener) {
        return ApiHelper.getAlbumInfo(j, new WrappedApiListener<Music.Album>(listener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass8 */

            public void onSuccess(Music.Album album) {
                super.onSuccess((Object) album);
                MusicCache.addSongs(album.songList);
            }
        });
    }

    public ApiRequest playOrPause(IncompleteApiListener incompleteApiListener) {
        if (this.mPlayerStatus == null || this.mPlayerStatus.status == 0) {
            return control("toggle", incompleteApiListener);
        }
        if (this.mPlayerStatus.status == 1) {
            return control("pause", incompleteApiListener);
        }
        if (this.mPlayerStatus.status == 2) {
            return control("play", incompleteApiListener);
        }
        return null;
    }

    public ApiRequest prev(IncompleteApiListener incompleteApiListener) {
        if (this.mPlayerStatus == null || this.mPlayerStatus.status == 0) {
            return control("toggle", incompleteApiListener);
        }
        return control("prev", incompleteApiListener);
    }

    public ApiRequest next(IncompleteApiListener incompleteApiListener) {
        if (this.mPlayerStatus == null || this.mPlayerStatus.status == 0) {
            return control("toggle", incompleteApiListener);
        }
        return control("next", incompleteApiListener);
    }

    /* access modifiers changed from: package-private */
    public ApiRequest stop(IncompleteApiListener incompleteApiListener) {
        return control("stop", incompleteApiListener);
    }

    public void refreshMicoLoveStatus() {
        if (MicoManager.getInstance().getCurrentMico().getHardwareType().hasScreen()) {
            refreshMicoLoveStatus(null);
        }
    }

    private ApiRequest refreshMicoLoveStatus(IncompleteApiListener incompleteApiListener) {
        return ApiHelper.remote(this.queryDeviceId, "mediaplayer", "player_refresh_lovablestatus", Remote.Request.buildControlActionMessage("refresh"), new WrappedIncompleteApiListener<Remote.Response.NullInfo>(incompleteApiListener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass9 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                super.onSuccess((Object) nullInfo);
            }
        }, Remote.Response.NullInfo.class);
    }

    /* access modifiers changed from: package-private */
    public ApiRequest control(String str, IncompleteApiListener incompleteApiListener) {
        return control(this.queryDeviceId, str, incompleteApiListener);
    }

    public ApiRequest control(String str, final String str2, IncompleteApiListener incompleteApiListener) {
        return ApiHelper.remote(str, "mediaplayer", "player_play_operation", Remote.Request.buildControlActionMessage(str2), new WrappedIncompleteApiListener<Remote.Response.NullInfo>(incompleteApiListener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass10 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                PlayerManager.this.updatePlayerAction(str2);
                super.onSuccess((Object) nullInfo);
            }

            public void onFailure(ApiError apiError) {
                super.onFailure(apiError);
                gsy.O00000Oo("Mico-Api", "player_play_operation/" + str2 + "--->" + apiError.toString());
            }
        }, Remote.Response.NullInfo.class);
    }

    public ApiRequest playLocal(String str, String str2, IncompleteApiListener incompleteApiListener) {
        return ApiHelper.remote(this.queryDeviceId, "mediaplayer", "player_play_filepath", String.format("{\"name\":\"%s\",\"path\":\"%s\",\"nameBase64\":\"%s\",\"pathBase64\":\"%s\"}", str, str2, !TextUtils.isEmpty(str) ? Base64Coder.encodeBytes(str.getBytes()) : str, !TextUtils.isEmpty(str2) ? Base64Coder.encodeBytes(str2.getBytes()) : str2), new WrappedIncompleteApiListener<Remote.Response.NullInfo>(incompleteApiListener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass11 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                super.onSuccess((Object) nullInfo);
                PlayerManager.this.resetAndQuery(false);
            }
        }, Remote.Response.NullInfo.class);
    }

    /* access modifiers changed from: package-private */
    public ApiRequest loop(int i, IncompleteApiListener incompleteApiListener) {
        return loop(this.queryDeviceId, i, incompleteApiListener);
    }

    public ApiRequest loop(String str, final int i, IncompleteApiListener incompleteApiListener) {
        return ApiHelper.remote(str, "mediaplayer", "player_set_loop", Remote.Request.buildLoopTypeMessage(i), new WrappedIncompleteApiListener<Remote.Response.NullInfo>(incompleteApiListener) {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass12 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                PlayerManager.this.updatePlayerType(i);
                super.onSuccess((Object) nullInfo);
            }

            public void onFailure(ApiError apiError) {
                super.onFailure(apiError);
                gsy.O00000Oo("Mico-Api", "player_set_loop--->" + apiError.toString());
            }
        }, Remote.Response.NullInfo.class);
    }

    @SuppressLint({"DefaultLocale"})
    public Observable<Remote.Response.NullInfo> modifyVolumeByValue(final int i) {
        new Object[1][0] = "set volume to " + String.valueOf(i);
        return ObservableApiHelper.remote(this.queryDeviceId, "mediaplayer", "player_set_volume", String.format("{\"volume\":%d,\"media\":\"app_android\"}", Integer.valueOf(i)), Remote.Response.NullInfo.class).doOnNext(new Action1<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.music.player.PlayerManager.AnonymousClass13 */

            public void call(Remote.Response.NullInfo nullInfo) {
                PlayerManager playerManager = PlayerManager.this;
                playerManager.mVolume = i;
                if (playerManager.mPlayerStatus != null) {
                    PlayerManager.this.mPlayerStatus.volume = i;
                }
            }
        });
    }

    @SuppressLint({"DefaultLocale"})
    public Observable<Remote.Response.NullInfo> modifyVolumeByDelta(boolean z, int i) {
        new Object[1][0] = z ? "set volume up with 10" : "set volume down with 10";
        return ObservableApiHelper.remote(MicoManager.getInstance().getCurrentMicoID(), "mediaplayer", "player_modify_volume", String.format("{\"isVolumeUp\":%d,\"value\":%d}", Integer.valueOf(z ? 1 : 0), Integer.valueOf(i)), Remote.Response.NullInfo.class);
    }

    public void updatePlayerStatus(Remote.Response.PlayerStatus playerStatus) {
        if (playerStatus != null) {
            PlayingRepair playingRepair = this.mPlayingRepair;
            Remote.Response.PlayingData playingData = playerStatus.play_song_detail;
            boolean z = true;
            if (playerStatus.status != 1) {
                z = false;
            }
            playerStatus.play_song_detail = playingRepair.updatePlayingData(playingData, z);
            this.mPlayerStatus = playerStatus;
            sendPlayerStatusUpdateEvent();
        }
    }

    public void updatePlayerAction(String str) {
        if (this.mPlayerStatus != null && !"toggle".equals(str)) {
            if ("play".equals(str) || "prev".equals(str) || "next".equals(str)) {
                this.mPlayerStatus.status = 1;
            } else if ("pause".equals(str)) {
                this.mPlayerStatus.status = 2;
            } else if ("stop".equals(str)) {
                this.mPlayerStatus.status = 0;
            }
            if ("play".equals(str)) {
                this.mPlayingRepair.startRepair();
            } else if ("pause".equals(str) || "stop".equals(str)) {
                this.mPlayingRepair.stopRepair();
            }
            sendPlayerStatusUpdateEvent();
        }
    }

    public void updatePlayerType(int i) {
        if (this.mPlayerStatus != null) {
            this.mPlayerStatus.loop_type = i;
            sendPlayerStatusUpdateEvent();
        }
    }

    public void updatePlayerIndex(int i, long j) {
        if (this.mPlayerStatus != null && this.mPlayerStatus.play_song_detail != null && this.mPlayerStatus.extra_track_list != null) {
            if (i > 0 || i < this.mPlayerStatus.extra_track_list.size()) {
                this.mPlayingRepair.updatePlayingData(this.mPlayerStatus.extra_track_list.get(i), 0, 1000 * j);
                sendPlayerStatusUpdateEvent();
            }
        }
    }

    private void sendPlayerStatusUpdateEvent() {
        jgc.O000000o().O00000oO(new MusicEvent.PlayerStatusUpdate(this.mPlayerStatus));
    }

    private void stripPlayerStatus(boolean z) {
        if (z) {
            this.mPlayerStatus = null;
        } else {
            this.mPlayerStatus.list_id = 0;
            this.mPlayerStatus.extra_track_list = null;
            this.mPlayerStatus.play_song_detail = null;
        }
        this.mPlayingRepair.resetPlayingData();
        jgc.O000000o().O00000Oo(MusicEvent.PlayerStatusUpdate.class);
    }

    public void resetAndQuery(boolean z) {
        stripPlayerStatus(z);
        if (this.mQueryCount.get() > 0) {
            stopQueryInner();
            startQueryInner();
        }
    }

    private void restartQuery() {
        if (this.mQueryCount.get() > 0) {
            stopQueryInner();
            startQueryInner();
        }
    }

    public boolean isLoadMore(List<Long> list, List<Long> list2) {
        if (list == null || list2 == null || list2.size() <= list.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void updatePlayerControlerState() {
        jgc.O000000o().O00000o(new MusicEvent.MusicUserPlay());
    }

    @jgi(O000000o = ThreadMode.MAIN, O00000o0 = 100)
    public void onCurrentMicoChanged(MicoEvent.CurrentMicoChanged currentMicoChanged) {
        this.queryDeviceId = currentMicoChanged.queryDeviceId;
        if (!TextUtils.isEmpty(this.queryDeviceId)) {
            Object[] objArr = {"PlayerManager onCurrentMicoChanged queryDeviceId %s", this.queryDeviceId};
            restartQuery();
            return;
        }
        this.queryDeviceId = MicoManager.getInstance().getCurrentMicoID();
        new Object[1][0] = "PlayerManager onCurrentMicoChanged resetAndQuery";
        resetAndQuery(true);
    }

    public void resetAndStopQuery() {
        this.queryDeviceId = "";
        stopQuery();
    }
}
