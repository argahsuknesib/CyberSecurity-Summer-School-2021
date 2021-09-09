package com.xiaomi.mico.music.detail;

import _m_j.gwg;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.widget.OpenQQMusicVipPopupView;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.channel.ChannelManager;
import com.xiaomi.mico.music.detail.DetailListTab;
import com.xiaomi.mico.music.player.PlayerActivityV2;
import com.xiaomi.smarthome.R;
import java.util.List;

public class SongBookDetailActivity extends SongListActivity implements DetailListTab.DetailPlayAllListener {
    private String songBookCover;
    private String songBookId;
    private String songBookName;
    private String songBookType;

    /* access modifiers changed from: protected */
    public int getAdapterViewType() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResID() {
        return R.layout.activity_detail_general;
    }

    public static Intent shareIntent(Context context, String str) {
        Intent intent = new Intent(context, SongBookDetailActivity.class);
        intent.putExtra("target", str);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("target");
        if (stringExtra != null) {
            Uri parse = Uri.parse(stringExtra);
            this.songBookType = parse.getQueryParameter("type");
            this.songBookId = parse.getQueryParameter("id");
            this.songBookName = parse.getQueryParameter("name");
            this.songBookCover = parse.getQueryParameter("cover");
        }
        if (this.songBookType == null && this.songBookId == null) {
            finish();
            return;
        }
        this.detailHeader.mLove.setVisibility(8);
        this.detailHeader.ivLoveBellow.setVisibility(8);
        getSheetSongs();
        this.detailHeader.mTabView.setPlayAllListener(this);
        this.detailHeader.showPlayAllView();
        gwg.O00000o0(this);
        List<Music.Channel> channelList = ChannelManager.getInstance().getChannelList();
        if (channelList == null || channelList.isEmpty()) {
            ChannelManager.getInstance().getChannelList(null);
        }
    }

    /* access modifiers changed from: protected */
    public void onPlay(List<Music.Song> list, int i, MusicHelper.OnPlayingListener onPlayingListener) {
        Music.Song song = list.get(i);
        OpenQQMusicVipPopupView.showOpenVipPopupView(song, getContext());
        if (String.valueOf(song.songID).equals(this.detailAdapter.getPlayingMusicID())) {
            PlayerActivityV2.displayPlayerWithAnim(getContext());
        } else {
            MusicHelper.playSongs(2, 0, list, i, onPlayingListener);
        }
    }

    private void getSheetSongs() {
        ApiHelper.getQQMusicSheetSongs(this.songBookId, this.songBookType, new ApiRequest.Listener<Music.SongBook>() {
            /* class com.xiaomi.mico.music.detail.SongBookDetailActivity.AnonymousClass1 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(Music.SongBook songBook) {
                if (songBook != null && songBook.songList != null) {
                    SongBookDetailActivity.this.updateSheetInfo(songBook);
                    SongBookDetailActivity.this.detailAdapter.updateDataList(songBook.songList);
                }
            }
        }).bindToLifecycle(this);
    }

    public void updateSheetInfo(Music.SongBook songBook) {
        Music.Sheet sheet = new Music.Sheet();
        sheet.cover = TextUtils.isEmpty(songBook.cover) ? this.songBookCover : songBook.cover;
        sheet.name = TextUtils.isEmpty(songBook.name) ? this.songBookName : songBook.name;
        this.detailHeader.setMusic(sheet, false);
    }

    public void onPlayAll() {
        if (this.detailAdapter.getItemCount() > 0) {
            onItemClick(null, 0);
        }
    }
}
