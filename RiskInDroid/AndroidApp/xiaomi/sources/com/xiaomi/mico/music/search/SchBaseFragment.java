package com.xiaomi.mico.music.search;

import _m_j.gsy;
import _m_j.jgc;
import _m_j.jgi;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.base.MicoBaseFragment;
import com.xiaomi.mico.common.recyclerview.LoadMoreListener;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.LEEAdapter;
import com.xiaomi.mico.common.util.ViewUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import rx.functions.Action1;

public abstract class SchBaseFragment<T> extends MicoBaseFragment implements ItemClickableAdapter.OnItemClickListener {
    private AudioProvider audioProvider;
    protected LovableAdapter mAdapter;
    private ApiRequest mApiRequest;
    private KeyProvider mKeyProvider;
    public LEEAdapter mLEEAdapter;
    public LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
        /* class com.xiaomi.mico.music.search.SchBaseFragment.AnonymousClass1 */

        public void onLoadMore() {
            if (SchBaseFragment.this.mLEEAdapter.getCurrentView() == 100) {
                SchBaseFragment schBaseFragment = SchBaseFragment.this;
                schBaseFragment.search(schBaseFragment.mAdapter.getDataSize());
                return;
            }
            setCanLoadMore(false);
            finishLoading();
        }
    };
    RecyclerView mRecyclerView;
    private String mSavedKey;

    interface AudioProvider {
        int getCategoryType();

        List<String> getSearchCpList();

        String getSearchTag();
    }

    interface KeyProvider {
        String getKey();
    }

    /* access modifiers changed from: protected */
    public boolean canLoadMore() {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract LovableAdapter<ItemClickableAdapter.ViewHolder, T> getAdapter();

    /* access modifiers changed from: protected */
    public LovableAdapter.Lovable getLovable() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract int getSearchType();

    /* access modifiers changed from: protected */
    public abstract List<T> parseResult(Music.SearchResult searchResult);

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof KeyProvider) {
            this.mKeyProvider = (KeyProvider) context;
            if (context instanceof AudioProvider) {
                this.audioProvider = (AudioProvider) context;
                return;
            }
            return;
        }
        throw new IllegalStateException("Host Activity of SearchFragment must implement KeyProvider.");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.view_linear_recycler_view, viewGroup, false);
        this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.linear_recycle_view);
        jgc.O000000o().O000000o(this);
        new Object[1][0] = "onSearchKeyChanged register";
        return inflate;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.addOnScrollListener(this.mLoadMoreListener);
        if (this.mAdapter == null) {
            this.mAdapter = getAdapter();
            this.mAdapter.setOnItemClickListener(this);
        }
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.view_loading, (ViewGroup) this.mRecyclerView, false);
        View inflate2 = LayoutInflater.from(getContext()).inflate((int) R.layout.view_empty_error, (ViewGroup) this.mRecyclerView, false);
        ViewUtil.setupEmptyView(inflate2, getString(R.string.common_search_empty));
        View inflate3 = LayoutInflater.from(getContext()).inflate((int) R.layout.view_empty_error, (ViewGroup) this.mRecyclerView, false);
        ViewUtil.setupErrorView(inflate3, new Action1<Void>() {
            /* class com.xiaomi.mico.music.search.SchBaseFragment.AnonymousClass2 */

            public void call(Void voidR) {
                SchBaseFragment.this.mLEEAdapter.setCurrentView(101);
                SchBaseFragment.this.search(0);
            }
        });
        this.mLEEAdapter = new LEEAdapter(this.mAdapter, inflate, inflate2, inflate3);
        String key = this.mKeyProvider.getKey();
        if (!TextUtils.isEmpty(key)) {
            if (this.mAdapter.isNullDataList() || !key.equalsIgnoreCase(this.mSavedKey)) {
                this.mAdapter.clearAllData(false);
                this.mSavedKey = key;
                this.mLEEAdapter.setCurrentView(101);
                search(0);
            } else if (this.mAdapter.getDataSize() == 0) {
                this.mLEEAdapter.setCurrentView(102);
            }
        }
        this.mRecyclerView.setAdapter(this.mLEEAdapter);
    }

    public void onDestroyView() {
        super.onDestroyView();
        jgc.O000000o().O00000o0(this);
        cancelSearch();
        this.mLEEAdapter = null;
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        MusicHelper.processMusic(getContext(), (Serializable) this.mAdapter.getData(i));
    }

    private void cancelSearch() {
        this.mLoadMoreListener.setCanLoadMore(false);
        this.mLoadMoreListener.finishLoading();
        ApiRequest apiRequest = this.mApiRequest;
        if (apiRequest != null) {
            apiRequest.cancel();
            this.mApiRequest = null;
        }
    }

    public void search(final int i) {
        AudioProvider audioProvider2 = this.audioProvider;
        if (audioProvider2 == null || audioProvider2.getSearchTag() == null || this.audioProvider.getSearchTag().isEmpty()) {
            this.mApiRequest = PlayerManager.getInstance().searchMusic(this.mSavedKey, getSearchType(), i, 20, true, new ApiRequest.Listener<Music.SearchResult>() {
                /* class com.xiaomi.mico.music.search.SchBaseFragment.AnonymousClass3 */

                public void onSuccess(Music.SearchResult searchResult) {
                    SchBaseFragment.this.mLoadMoreListener.finishLoading();
                    List parseResult = SchBaseFragment.this.parseResult(searchResult);
                    if (i <= 0) {
                        SchBaseFragment.this.mAdapter.updateDataList(parseResult);
                    } else if (!parseResult.isEmpty()) {
                        SchBaseFragment.this.mAdapter.addDataList(parseResult);
                    }
                    if (SchBaseFragment.this.mAdapter.getDataSize() <= 0) {
                        SchBaseFragment.this.mLEEAdapter.setCurrentView(102);
                    } else if (i <= 0) {
                        SchBaseFragment.this.mLEEAdapter.setCurrentView(100);
                    }
                    boolean z = false;
                    if (SchBaseFragment.this.canLoadMore()) {
                        LoadMoreListener loadMoreListener = SchBaseFragment.this.mLoadMoreListener;
                        if (parseResult.size() > 0) {
                            z = true;
                        }
                        loadMoreListener.setCanLoadMore(z);
                        return;
                    }
                    SchBaseFragment.this.mLoadMoreListener.setCanLoadMore(false);
                }

                public void onFailure(ApiError apiError) {
                    SchBaseFragment.this.mLoadMoreListener.finishLoading();
                    if (SchBaseFragment.this.mAdapter.isNullDataList()) {
                        SchBaseFragment.this.mLEEAdapter.setCurrentView(103);
                    }
                    gsy.O00000Oo(12000, "12000.3.1", "remote fail");
                }
            });
            return;
        }
        this.mApiRequest = ApiHelper.searchCategoryItem(this.audioProvider.getSearchTag(), this.audioProvider.getCategoryType(), this.audioProvider.getSearchCpList(), "all", this.mSavedKey, i, 20, ApiConstants.localeIdentifierUppercase(), new ApiRequest.Listener<List<Music.Station>>() {
            /* class com.xiaomi.mico.music.search.SchBaseFragment.AnonymousClass4 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Station>) ((List) obj));
            }

            public void onSuccess(List<Music.Station> list) {
                SchBaseFragment.this.mLoadMoreListener.finishLoading();
                SchBaseFragment.this.mLoadMoreListener.setCanLoadMore(list.size() > 0);
                if (i <= 0) {
                    SchBaseFragment.this.mAdapter.updateDataList(list);
                } else if (!list.isEmpty()) {
                    SchBaseFragment.this.mAdapter.addDataList(list);
                }
                if (SchBaseFragment.this.mAdapter.getDataSize() <= 0) {
                    SchBaseFragment.this.mLEEAdapter.setCurrentView(102);
                } else if (i <= 0) {
                    SchBaseFragment.this.mLEEAdapter.setCurrentView(100);
                }
            }

            public void onFailure(ApiError apiError) {
                SchBaseFragment.this.mLoadMoreListener.finishLoading();
                if (SchBaseFragment.this.mAdapter.isNullDataList()) {
                    SchBaseFragment.this.mLEEAdapter.setCurrentView(103);
                }
            }
        });
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onSearchKeyChanged(MusicEvent.SearchKeyChanged searchKeyChanged) {
        if (!searchKeyChanged.key.equalsIgnoreCase(this.mSavedKey)) {
            cancelSearch();
            this.mAdapter.clearAllData(true);
            this.mSavedKey = searchKeyChanged.key;
            this.mLEEAdapter.setCurrentView(101);
            search(0);
        }
    }
}
