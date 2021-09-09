package com.xiaomi.mico.music.detail;

import _m_j.czx;
import _m_j.dai;
import _m_j.gwg;
import _m_j.hxi;
import android.os.Bundle;
import android.text.TextUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.OpenQQMusicVipPopupView;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.channel.ChannelManager;
import com.xiaomi.mico.music.detail.DetailListTab;
import com.xiaomi.mico.music.player.PlayerActivityV2;
import com.xiaomi.smarthome.R;
import java.util.List;
import org.json.JSONObject;

public class SheetDetailActivity extends SongListActivity implements DetailListTab.DetailPlayAllListener {
    SmartRefreshLayout refreshLayout;
    private Music.Sheet sheet;

    /* access modifiers changed from: protected */
    public int getAdapterViewType() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResID() {
        return R.layout.activity_detail_general_loadmore;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sheet = (Music.Sheet) getIntent().getSerializableExtra("music");
        if (this.sheet == null) {
            finish();
            return;
        }
        this.detailHeader.setMusic(this.sheet, false);
        this.refreshLayout = (SmartRefreshLayout) findViewById(R.id.refresh_layout);
        this.refreshLayout.O00000o0(false);
        this.refreshLayout.O0000O0o(true);
        this.refreshLayout.O00000o(true);
        this.refreshLayout.O000000o(new dai() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$SheetDetailActivity$BFNzrchekseuYcEqjIBENyMrBE */

            public final void onLoadMore(czx czx) {
                SheetDetailActivity.this.lambda$onCreate$0$SheetDetailActivity(czx);
            }
        });
        getSheetInfo(0);
        this.detailHeader.mTabView.setPlayAllListener(this);
        this.detailHeader.showPlayAllView();
        gwg.O00000o0(this);
        hxi.O00000o0.O00000o0(2);
    }

    public /* synthetic */ void lambda$onCreate$0$SheetDetailActivity(czx czx) {
        getSheetInfo(this.detailAdapter.getDataSize());
    }

    /* access modifiers changed from: protected */
    public void onPlay(List<Music.Song> list, int i, MusicHelper.OnPlayingListener onPlayingListener) {
        Music.Song song = list.get(i);
        OpenQQMusicVipPopupView.showOpenVipPopupView(song, getContext());
        if (String.valueOf(song.songID).equals(this.detailAdapter.getPlayingMusicID())) {
            PlayerActivityV2.displayPlayerWithAnim(getContext());
        } else {
            MusicHelper.playSongs(1, this.sheet.sheetID, list, i, onPlayingListener);
        }
    }

    private void getSheetInfo(final int i) {
        this.apiRequest = ChannelManager.getInstance().getChannelInfo(this.sheet.sheetID, i, 20, new ApiRequest.Listener<Music.Channel>() {
            /* class com.xiaomi.mico.music.detail.SheetDetailActivity.AnonymousClass1 */

            public void onSuccess(Music.Channel channel) {
                SheetDetailActivity.this.refreshLayout.O0000O0o();
                List<Music.Song> list = channel.songList;
                boolean z = true;
                SheetDetailActivity.this.refreshLayout.O0000O0o(list.size() > 10);
                if (i <= 0) {
                    SheetDetailActivity.this.updateSheetCore(channel);
                    SheetDetailActivity.this.detailAdapter.updateDataList(list);
                    SmartRefreshLayout smartRefreshLayout = SheetDetailActivity.this.refreshLayout;
                    if (list.size() < 20) {
                        z = false;
                    }
                    smartRefreshLayout.O0000O0o(z);
                } else if (!list.isEmpty()) {
                    SheetDetailActivity.this.detailAdapter.addDataList(list);
                } else {
                    ToastUtil.showToast((int) R.string.loadmore_result_nothing);
                    SheetDetailActivity.this.refreshLayout.O0000O0o(false);
                }
            }

            public void onFailure(ApiError apiError) {
                SheetDetailActivity.this.refreshLayout.O0000O0o();
            }
        });
    }

    public void updateSheetCore(Music.Channel channel) {
        if (!TextUtils.isEmpty(channel.name)) {
            this.sheet.name = channel.name;
        }
        if (!TextUtils.isEmpty(channel.subtitle)) {
            this.sheet.subtitle = channel.subtitle;
        }
        if (!TextUtils.isEmpty(channel.intro)) {
            this.sheet.intro = channel.intro;
        }
        if (!TextUtils.isEmpty(channel.cover)) {
            this.sheet.cover = channel.cover;
        }
        if (!ContainerUtil.hasData(channel.tags)) {
            this.sheet.tags = channel.tags;
        }
        if (channel.songCount > 0) {
            this.detailAdapter.setStableDataSize(channel.songCount);
        }
        this.detailHeader.updateMusic(this.sheet);
    }

    public void onPlayAll() {
        if (this.detailAdapter.getItemCount() > 0) {
            onItemClick(null, 0);
        }
        hxi.O00000o.O000000o("content_qqdetail_tall", (JSONObject) null);
        Music.Sheet sheet2 = this.sheet;
        if (sheet2 != null) {
            TextUtils.isEmpty(sheet2.cpName);
        }
    }
}
