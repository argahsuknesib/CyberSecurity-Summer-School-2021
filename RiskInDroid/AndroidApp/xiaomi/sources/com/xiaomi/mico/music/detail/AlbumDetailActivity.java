package com.xiaomi.mico.music.detail;

import android.os.Bundle;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.smarthome.R;
import java.util.List;

public class AlbumDetailActivity extends SongListActivity {
    private Music.Album mAlbum;

    /* access modifiers changed from: protected */
    public int getAdapterViewType() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResID() {
        return R.layout.activity_detail_general;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlbum = (Music.Album) getIntent().getSerializableExtra("music");
        if (this.mAlbum == null) {
            finish();
            return;
        }
        this.detailHeader.setMusic(this.mAlbum, true);
        getAlbumInfo(this.mAlbum.albumID);
    }

    /* access modifiers changed from: protected */
    public void onPlay(List<Music.Song> list, int i, MusicHelper.OnPlayingListener onPlayingListener) {
        MusicHelper.playSongs(0, this.mAlbum.albumID, list, i, onPlayingListener);
    }

    private void getAlbumInfo(long j) {
        this.apiRequest = PlayerManager.getInstance().getAlbumInfo(j, new ApiRequest.Listener<Music.Album>() {
            /* class com.xiaomi.mico.music.detail.AlbumDetailActivity.AnonymousClass1 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(Music.Album album) {
                AlbumDetailActivity.this.updateDataList(album.songList);
                AlbumDetailActivity.this.updateAlbumCore(album);
            }
        });
    }

    public void updateAlbumCore(Music.Album album) {
        album.songList = null;
        this.mAlbum = album;
        this.detailHeader.updateMusic(this.mAlbum);
    }
}
