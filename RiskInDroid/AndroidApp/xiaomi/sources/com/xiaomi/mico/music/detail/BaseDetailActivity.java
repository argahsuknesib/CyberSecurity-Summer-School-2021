package com.xiaomi.mico.music.detail;

import _m_j.hxi;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.mico.music.adapter.SongAdapter;
import com.xiaomi.mico.music.detail.DetailTitleBar;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import com.xiaomi.smarthome.R;
import java.util.List;
import org.json.JSONObject;

public abstract class BaseDetailActivity<T> extends MicoBaseActivity implements ItemClickableAdapter.OnItemClickListener, PlayerStatusTrack.onTrackListener {
    protected SongAdapter.Lovable<T> detailAdapter;
    DetailHeader detailHeader;
    public ImageView empty;
    public TextView emptyText;
    public RecyclerView recyclerView;
    DetailListTab tabView;
    public DetailTitleBar titleBar;

    /* access modifiers changed from: protected */
    public abstract int getAdapterViewType();

    /* access modifiers changed from: protected */
    public abstract int getLayoutResID();

    /* access modifiers changed from: protected */
    public LovableAdapter.Lovable getLovable() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void onPlay(List<T> list, int i, MusicHelper.OnPlayingListener onPlayingListener);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutResID());
        this.titleBar = (DetailTitleBar) findViewById(R.id.title_bar);
        this.detailHeader = (DetailHeader) findViewById(R.id.detail_header);
        this.tabView = (DetailListTab) findViewById(R.id.detail_list_tab);
        this.recyclerView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        this.empty = (ImageView) findViewById(R.id.detail_empty);
        this.emptyText = (TextView) findViewById(R.id.detail_empty_text);
        this.titleBar.addPlayerIndicator(new DetailTitleBar.PlayerIndicatorStatClickListener() {
            /* class com.xiaomi.mico.music.detail.BaseDetailActivity.AnonymousClass1 */

            public void onStatClick() {
                hxi.O00000o.O000000o("content_qqdetail_player", (JSONObject) null);
            }
        });
        this.recyclerView.setHasFixedSize(true);
        getResources().getDimensionPixelSize(R.dimen.music_item_header_height);
        this.detailAdapter = new SongAdapter.Lovable<>(false);
        this.detailAdapter.setOnItemClickListener(this);
        LovableAdapter.Lovable lovable = getLovable();
        if (lovable != null) {
            this.detailAdapter.setLovable(lovable);
        }
        this.recyclerView.setAdapter(this.detailAdapter);
    }

    public void onResume() {
        super.onResume();
        PlayerStatusTrack.getInstance().register(this);
        this.titleBar.onResume();
    }

    public void onPause() {
        super.onPause();
        PlayerStatusTrack.getInstance().unregister(this);
        this.titleBar.onPause();
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        this.titleBar.updatePlayerStatus(playerStatus);
        SongAdapter.Lovable<T> lovable = this.detailAdapter;
        if (lovable != null) {
            lovable.updatePlayingMusicID(MusicHelper.getPlayingMusicID(playerStatus));
        }
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        List<T> dataList = this.detailAdapter.getDataList();
        if (!ContainerUtil.isEmpty(dataList)) {
            onPlay(dataList, this.detailAdapter.isHeaderByPosition(i) ? -1 : this.detailAdapter.getDataIndex(i), new MusicHelper.OnPlayingListener() {
                /* class com.xiaomi.mico.music.detail.$$Lambda$BaseDetailActivity$bEtIkaLLlHzYqhZds641r7RSsko */

                public final void onPlaying(String str) {
                    BaseDetailActivity.this.lambda$onItemClick$0$BaseDetailActivity(str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onItemClick$0$BaseDetailActivity(String str) {
        this.detailAdapter.updatePlayingMusicID(str);
    }

    /* access modifiers changed from: protected */
    public void updateDataList(List<T> list) {
        this.detailAdapter.updateDataList(list);
    }

    /* access modifiers changed from: protected */
    public void updateDataList(List<T> list, int i) {
        this.detailAdapter.updateDataList(list, i);
    }
}
