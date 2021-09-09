package com.xiaomi.mico.music.patchwall;

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
import com.xiaomi.mico.music.patchwall.adapter.ListDetailAdapter;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class ListDetailActivity extends MicoBaseActivity implements ItemClickableAdapter.OnItemClickListener {
    private String blockTitle;
    private String blockType;
    private int categoryType;
    private List<String> cpList;
    public ListDetailAdapter listDetailAdapter;
    private ApiRequest mApiRequest;
    public int mCurrentPage = 0;
    public LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
        /* class com.xiaomi.mico.music.patchwall.ListDetailActivity.AnonymousClass1 */

        public void onLoadMore() {
            ListDetailActivity.this.getStationList();
        }
    };
    RecyclerView mRecyclerView;
    TitleBar mTitleBar;
    public List<Music.Station> stations;

    public boolean isDarkMode() {
        return true;
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_detail_block);
        this.mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        this.blockType = getIntent().getStringExtra("block_type");
        this.blockTitle = getIntent().getStringExtra("block_title");
        this.categoryType = getIntent().getIntExtra("block_category_type", -1);
        this.cpList = getIntent().getStringArrayListExtra("block_cp_list");
        this.mTitleBar.setTitle(getString(R.string.music_must_listen, new Object[]{this.blockTitle})).setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.music.patchwall.ListDetailActivity.AnonymousClass2 */

            public void onLeftIconClick() {
                ListDetailActivity.this.finish();
            }
        });
        this.listDetailAdapter = new ListDetailAdapter(this, this.blockType);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.addOnScrollListener(this.mLoadMoreListener);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setAdapter(this.listDetailAdapter);
        getStationList();
    }

    public void onDestroy() {
        super.onDestroy();
        ApiRequest apiRequest = this.mApiRequest;
        if (apiRequest != null) {
            apiRequest.cancel();
            this.mApiRequest = null;
        }
    }

    public void getStationList() {
        ApiHelper.getAudioBooksAll(this.blockTitle, this.categoryType, this.cpList, "mustListen", this.mCurrentPage, 10, ApiConstants.localeIdentifierUppercase(), new ApiRequest.Listener<List<Music.Station>>() {
            /* class com.xiaomi.mico.music.patchwall.ListDetailActivity.AnonymousClass3 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Station>) ((List) obj));
            }

            public void onSuccess(List<Music.Station> list) {
                ListDetailActivity.this.mLoadMoreListener.finishLoading();
                if (list == null || list.size() <= 0) {
                    ListDetailActivity.this.mLoadMoreListener.setCanLoadMore(false);
                    return;
                }
                ListDetailActivity.this.mLoadMoreListener.setCanLoadMore(true);
                if (ListDetailActivity.this.stations == null) {
                    ListDetailActivity.this.stations = new ArrayList();
                }
                ListDetailActivity.this.stations.addAll(list);
                ListDetailActivity.this.listDetailAdapter.updateUiTypeAndDataList(ListDetailActivity.this.stations);
                ListDetailActivity.this.mCurrentPage++;
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError;
                ListDetailActivity.this.mLoadMoreListener.finishLoading();
            }
        });
    }
}
