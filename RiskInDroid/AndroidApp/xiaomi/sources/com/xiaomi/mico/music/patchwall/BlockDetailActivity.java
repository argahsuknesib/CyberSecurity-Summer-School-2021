package com.xiaomi.mico.music.patchwall;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.application.AreaCode;
import com.xiaomi.mico.common.recyclerview.LoadMoreListener;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapter;
import com.xiaomi.mico.music.patchwall.adapter.BlockStationListAdapter;
import com.xiaomi.smarthome.R;
import java.util.List;

public class BlockDetailActivity extends MicoBaseActivity implements ItemClickableAdapter.OnItemClickListener {
    private String blockTitle;
    private String blockType;
    private int categoryType;
    private List<String> cpList;
    private ApiRequest.Listener listener = null;
    private ApiRequest mApiRequest;
    private long mBlockID;
    public int mCurrentPage = 0;
    public BlockDetailAdapter mDetailAdapter;
    public LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
        /* class com.xiaomi.mico.music.patchwall.BlockDetailActivity.AnonymousClass1 */

        public void onLoadMore() {
            BlockDetailActivity blockDetailActivity = BlockDetailActivity.this;
            blockDetailActivity.getPatchWallBlock(blockDetailActivity.mCurrentPage);
        }
    };
    RecyclerView mRecyclerView;
    TitleBar mTitleBar;
    public BlockStationListAdapter stationListAdapter;
    private ApiRequest.Listener<List<Music.Station>> stationListener = null;

    public boolean isDarkMode() {
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int
     arg types: [com.xiaomi.mico.music.patchwall.BlockDetailActivity, int]
     candidates:
      com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.content.Context, float):int
      com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_detail_block);
        ButterKnife.bind(this);
        this.mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        this.mBlockID = getIntent().getLongExtra("block_id", -1);
        this.blockType = getIntent().getStringExtra("block_type");
        this.categoryType = getIntent().getIntExtra("category_type", -1);
        this.blockTitle = getIntent().getStringExtra("block_title");
        this.cpList = getIntent().getStringArrayListExtra("block_cp_list");
        this.mTitleBar.setTitle(this.blockTitle).setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$SAN9RN8mKhNUCr4frQqdGHvIbgY */

            public final void onLeftIconClick() {
                BlockDetailActivity.this.finish();
            }
        });
        if ("block_type_dedao".equals(this.blockType)) {
            this.stationListAdapter = new BlockStationListAdapter(this);
            this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.mRecyclerView.setAdapter(this.stationListAdapter);
        } else {
            this.mDetailAdapter = new BlockDetailAdapter(this, this.blockType);
            this.mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            this.mRecyclerView.addItemDecoration(new BlockDetailAdapter.SpacingItemDecoration(2, MusicHelper.getDefaultCornerRadius(this), false, DisplayUtils.dip2px((Activity) this, 10.0f)));
            this.mRecyclerView.setAdapter(this.mDetailAdapter);
        }
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.addOnScrollListener(this.mLoadMoreListener);
        getPatchWallBlock(0);
    }

    public void onDestroy() {
        super.onDestroy();
        ApiRequest apiRequest = this.mApiRequest;
        if (apiRequest != null) {
            apiRequest.cancel();
            this.mApiRequest = null;
        }
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        MusicHelper.processBlockItem(this, (PatchWall.Item) this.mDetailAdapter.getData(i));
    }

    public void getPatchWallBlock(int i) {
        initListener();
        if ("block_type_music_qq".equals(this.blockType)) {
            ApiHelper.getQQPathWallBlock(this.mBlockID, i, this.listener);
        } else if ("block_type_music_kids".equals(this.blockType)) {
            ApiHelper.getKidsPathWallBlock(this.mBlockID, i, this.listener);
        } else if ("block_type_dedao".equals(this.blockType)) {
            getDedaoStationList(this.categoryType);
        } else if ("block_type_audio_novel".equals(this.blockType)) {
            ApiHelper.getNovelPatchWallBlock(this.mBlockID, i, this.listener);
        } else if ("block_type_audio_top_quality".equals(this.blockType)) {
            ApiHelper.getTopQualityPatchWallBlock(this.mBlockID, i, this.listener);
        } else if (ApiConstants.getAreaCode() == AreaCode.TW) {
            ApiHelper.getKKboxPathWallBlock("block_type_audio_boox".equals(this.blockType), this.mBlockID, i, this.listener);
        } else {
            ApiHelper.getPatchWallBlock(this.mBlockID, i, this.listener);
        }
    }

    private void initListener() {
        if (this.listener == null) {
            this.listener = new ApiRequest.Listener<PatchWall.Block>() {
                /* class com.xiaomi.mico.music.patchwall.BlockDetailActivity.AnonymousClass2 */

                public void onSuccess(PatchWall.Block block) {
                    BlockDetailActivity.this.mLoadMoreListener.finishLoading();
                    if (block == null || !ContainerUtil.hasData(block.items)) {
                        BlockDetailActivity.this.mLoadMoreListener.setCanLoadMore(false);
                        return;
                    }
                    BlockDetailActivity.this.mLoadMoreListener.setCanLoadMore(true);
                    BlockDetailActivity.this.mDetailAdapter.updateUiTypeAndDataList(false, true, block);
                    BlockDetailActivity.this.mCurrentPage++;
                }

                public void onFailure(ApiError apiError) {
                    BlockDetailActivity.this.mLoadMoreListener.finishLoading();
                }
            };
        }
    }

    private void getDedaoStationList(int i) {
        initStationListener();
        if (i == 0 || i == 1) {
            ApiHelper.paymentOrderDedao(i, this.mCurrentPage, 20, this.stationListener);
        } else if (i == 2) {
            ApiHelper.getPathWallDedaoBlock(this.cpList, this.mCurrentPage, 20, this.stationListener);
        }
    }

    private void initStationListener() {
        if (this.stationListener == null) {
            this.stationListener = new ApiRequest.Listener<List<Music.Station>>() {
                /* class com.xiaomi.mico.music.patchwall.BlockDetailActivity.AnonymousClass3 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<Music.Station>) ((List) obj));
                }

                public void onSuccess(List<Music.Station> list) {
                    BlockDetailActivity.this.mLoadMoreListener.finishLoading();
                    if (ContainerUtil.hasData(list)) {
                        BlockDetailActivity.this.mLoadMoreListener.setCanLoadMore(true);
                        BlockDetailActivity.this.stationListAdapter.addDataList(list);
                        BlockDetailActivity.this.mCurrentPage++;
                        return;
                    }
                    BlockDetailActivity.this.mLoadMoreListener.setCanLoadMore(false);
                }

                public void onFailure(ApiError apiError) {
                    BlockDetailActivity.this.mLoadMoreListener.finishLoading();
                }
            };
        }
    }
}
