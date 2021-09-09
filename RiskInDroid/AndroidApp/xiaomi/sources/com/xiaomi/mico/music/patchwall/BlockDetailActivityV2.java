package com.xiaomi.mico.music.patchwall;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.recyclerview.LoadMoreListener;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapterV2;
import com.xiaomi.mico.music.search.SearchAudioActivity;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class BlockDetailActivityV2 extends MicoBaseActivity implements ItemClickableAdapter.OnItemClickListener {
    public List<Music.Station> allStations;
    public BlockDetailAdapterV2 blockDetailAdapter;
    private String blockTitle;
    private int categoryType;
    private List<String> cpList;
    private ApiRequest mApiRequest;
    public int mCurrentPage = 0;
    public LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
        /* class com.xiaomi.mico.music.patchwall.BlockDetailActivityV2.AnonymousClass1 */

        public void onLoadMore() {
            BlockDetailActivityV2.this.getStationList(false);
        }
    };
    RecyclerView mRecyclerView;
    TitleBar mTitleBar;

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_detail_block);
        this.mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        this.blockTitle = getIntent().getStringExtra("block_title");
        this.categoryType = getIntent().getIntExtra("block_category_type", -1);
        this.cpList = getIntent().getStringArrayListExtra("block_cp_list");
        this.mTitleBar.setTitle(this.blockTitle).setRightIcon(R.drawable.mico_icon_search_entr).setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$BlockDetailActivityV2$TEDKQDzfLuUo9sna8jAZssDF2Y */

            public final void onLeftIconClick() {
                BlockDetailActivityV2.this.lambda$onCreate$0$BlockDetailActivityV2();
            }
        }).setOnRightIconClickListener(new TitleBar.OnRightIconClickListener() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$BlockDetailActivityV2$DMbSsfD8FhMtR24VXW2IBk9KK08 */

            public final void onRightIconClick() {
                BlockDetailActivityV2.this.lambda$onCreate$1$BlockDetailActivityV2();
            }
        });
        this.blockDetailAdapter = new BlockDetailAdapterV2(this, this.blockTitle, this.categoryType, this.cpList);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.addOnScrollListener(this.mLoadMoreListener);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setAdapter(this.blockDetailAdapter);
        getStationList(true);
    }

    public /* synthetic */ void lambda$onCreate$0$BlockDetailActivityV2() {
        finish();
    }

    public /* synthetic */ void lambda$onCreate$1$BlockDetailActivityV2() {
        Intent intent = new Intent(getContext(), SearchAudioActivity.class);
        intent.putExtra("block_title", this.blockTitle);
        intent.putExtra("block_category_type", this.categoryType);
        intent.putStringArrayListExtra("block_cp_list", (ArrayList) this.cpList);
        getContext().startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        ApiRequest apiRequest = this.mApiRequest;
        if (apiRequest != null) {
            apiRequest.cancel();
            this.mApiRequest = null;
        }
    }

    public void getStationList(boolean z) {
        if (z) {
            ApiHelper.getAudioBooksRandom(this.blockTitle, this.categoryType, this.cpList, "mustListen", new ApiRequest.Listener<List<Music.Station>>() {
                /* class com.xiaomi.mico.music.patchwall.BlockDetailActivityV2.AnonymousClass2 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<Music.Station>) ((List) obj));
                }

                public void onSuccess(List<Music.Station> list) {
                    if (list != null && list.size() > 0) {
                        BlockDetailActivityV2.this.blockDetailAdapter.updateUiTypeAndDataList("mustListen", list);
                    }
                }

                public void onFailure(ApiError apiError) {
                    new Object[1][0] = apiError;
                }
            });
        }
        ApiHelper.getAudioBooksAll(this.blockTitle, this.categoryType, this.cpList, "all", this.mCurrentPage, 12, ApiConstants.localeIdentifierUppercase(), new ApiRequest.Listener<List<Music.Station>>() {
            /* class com.xiaomi.mico.music.patchwall.BlockDetailActivityV2.AnonymousClass3 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Station>) ((List) obj));
            }

            public void onSuccess(List<Music.Station> list) {
                BlockDetailActivityV2.this.mLoadMoreListener.finishLoading();
                if (list == null || list.size() <= 0) {
                    BlockDetailActivityV2.this.mLoadMoreListener.setCanLoadMore(false);
                    return;
                }
                BlockDetailActivityV2.this.mLoadMoreListener.setCanLoadMore(true);
                if (BlockDetailActivityV2.this.allStations == null) {
                    BlockDetailActivityV2.this.allStations = new ArrayList();
                }
                BlockDetailActivityV2.this.allStations.addAll(list);
                BlockDetailActivityV2.this.blockDetailAdapter.updateUiTypeAndDataList("all", BlockDetailActivityV2.this.allStations);
                BlockDetailActivityV2.this.mCurrentPage++;
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError;
                BlockDetailActivityV2.this.mLoadMoreListener.finishLoading();
            }
        });
    }
}
