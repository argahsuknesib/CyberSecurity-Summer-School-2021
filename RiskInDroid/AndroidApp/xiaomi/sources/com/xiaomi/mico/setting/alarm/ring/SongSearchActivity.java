package com.xiaomi.mico.setting.alarm.ring;

import _m_j.jgc;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.recyclerview.LoadMoreListener;
import com.xiaomi.mico.common.recyclerview.adapter.LEEAdapter;
import com.xiaomi.mico.common.util.ViewUtil;
import com.xiaomi.mico.common.widget.SearchBarV2;
import com.xiaomi.mico.common.widget.SearchTagsView;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.mico.music.search.SearchContainer;
import com.xiaomi.mico.setting.alarm.AlarmHelper;
import com.xiaomi.mico.setting.alarm.ring.SongSearchActivity;
import com.xiaomi.smarthome.R;
import io.reactivex.annotations.NonNull;
import java.util.List;
import rx.functions.Action1;

public class SongSearchActivity extends MicoBaseActivity {
    private ApiRequest apiRequest;
    public SearchSongAdapter mAdapter;
    private String mKey;
    LEEAdapter mLEEAdapter;
    public LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
        /* class com.xiaomi.mico.setting.alarm.ring.SongSearchActivity.AnonymousClass1 */

        public void onLoadMore() {
            if (SongSearchActivity.this.mLEEAdapter.getCurrentView() == 100) {
                SongSearchActivity songSearchActivity = SongSearchActivity.this;
                songSearchActivity.searchSong(songSearchActivity.mAdapter.getItemCount());
                return;
            }
            setCanLoadMore(false);
            finishLoading();
        }
    };
    SearchBarV2 mSearchBar;
    SearchContainer mSearchContainer;
    RecyclerView resultRecyclerView;
    SearchTagsView searchTagsView;

    public boolean isDarkMode() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_alarm_song_search);
        this.mSearchBar = (SearchBarV2) findViewById(R.id.title_bar);
        this.mSearchContainer = (SearchContainer) findViewById(R.id.search_container);
        this.searchTagsView = (SearchTagsView) findViewById(R.id.search_tag_view);
        this.resultRecyclerView = (RecyclerView) findViewById(R.id.song_recycle);
        this.mSearchBar.setListener(new SearchBarV2.Listener() {
            /* class com.xiaomi.mico.setting.alarm.ring.SongSearchActivity.AnonymousClass2 */

            public void onBack() {
                SongSearchActivity.this.finish();
            }

            public void onClear() {
                if (SongSearchActivity.this.searchTagsView.getVisibility() != 0) {
                    SongSearchActivity.this.searchTagsView.setVisibility(0);
                    SongSearchActivity.this.resultRecyclerView.setVisibility(8);
                }
            }

            public void onSearch(String str) {
                SongSearchActivity.this.doSearch(str);
            }
        });
        this.mSearchContainer.setOnTouchStartListener(new SearchContainer.OnTouchStartListener() {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$SongSearchActivity$wVETUwTdivStcH_KUeINbr1wNU */

            public final void onTouchStart() {
                SongSearchActivity.this.lambda$onCreate$0$SongSearchActivity();
            }
        });
        this.mSearchBar.setHint((int) R.string.alarm_ring_music_search_hint);
        this.searchTagsView.setOnSearchListener(new SearchTagsView.OnSearchListener() {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$SongSearchActivity$z2HAfQdpwJoBkTfE7t4lLcKwHz4 */

            public final void onSearch(String str) {
                SongSearchActivity.this.lambda$onCreate$1$SongSearchActivity(str);
            }
        });
        setResultAdapter();
    }

    public /* synthetic */ void lambda$onCreate$0$SongSearchActivity() {
        this.mSearchBar.clearEditorFocus();
    }

    public /* synthetic */ void lambda$onCreate$1$SongSearchActivity(String str) {
        this.mSearchBar.search(str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void setResultAdapter() {
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.view_loading, (ViewGroup) this.resultRecyclerView, false);
        View inflate2 = LayoutInflater.from(getContext()).inflate((int) R.layout.view_empty_error, (ViewGroup) this.resultRecyclerView, false);
        ViewUtil.setupEmptyView(inflate2, getString(R.string.common_search_empty));
        View inflate3 = LayoutInflater.from(getContext()).inflate((int) R.layout.view_empty_error, (ViewGroup) this.resultRecyclerView, false);
        ViewUtil.setupErrorView(inflate3, new Action1<Void>() {
            /* class com.xiaomi.mico.setting.alarm.ring.SongSearchActivity.AnonymousClass3 */

            public void call(Void voidR) {
                SongSearchActivity.this.mLEEAdapter.setCurrentView(101);
                SongSearchActivity.this.searchSong(0);
            }
        });
        this.mAdapter = new SearchSongAdapter();
        this.mLEEAdapter = new LEEAdapter(this.mAdapter, inflate, inflate2, inflate3);
        this.resultRecyclerView.setHasFixedSize(true);
        this.resultRecyclerView.addOnScrollListener(this.mLoadMoreListener);
        this.resultRecyclerView.setAdapter(this.mLEEAdapter);
    }

    public void onDestroy() {
        super.onDestroy();
        ApiRequest apiRequest2 = this.apiRequest;
        if (apiRequest2 != null) {
            apiRequest2.cancel();
            this.apiRequest = null;
        }
    }

    public void doSearch(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.mSearchBar.clearEditorFocus();
            this.searchTagsView.addOrUpdateHistoryKey(str);
            this.searchTagsView.setVisibility(8);
            this.resultRecyclerView.setVisibility(0);
            if (!str.equalsIgnoreCase(this.mKey)) {
                this.mKey = str;
                searchSong(0);
            }
        }
    }

    public void searchSong(final int i) {
        if (!TextUtils.isEmpty(this.mKey)) {
            this.apiRequest = PlayerManager.getInstance().searchMusic(this.mKey, 1, i, 20, true, new ApiRequest.Listener<Music.SearchResult>() {
                /* class com.xiaomi.mico.setting.alarm.ring.SongSearchActivity.AnonymousClass4 */

                public void onSuccess(Music.SearchResult searchResult) {
                    SongSearchActivity.this.mLoadMoreListener.finishLoading();
                    List<Music.Song> list = searchResult.songList;
                    if (i <= 0) {
                        SongSearchActivity.this.mAdapter.updateDataList(list);
                    } else if (!list.isEmpty()) {
                        SongSearchActivity.this.mAdapter.addDataList(list);
                    }
                    if (SongSearchActivity.this.mAdapter.getItemCount() <= 0) {
                        SongSearchActivity.this.mLEEAdapter.setCurrentView(102);
                    } else if (i <= 0) {
                        SongSearchActivity.this.mLEEAdapter.setCurrentView(100);
                    }
                    SongSearchActivity.this.mLoadMoreListener.setCanLoadMore(list.size() > 0);
                }

                public void onFailure(ApiError apiError) {
                    SongSearchActivity.this.mLoadMoreListener.finishLoading();
                    if (SongSearchActivity.this.mAdapter.isNullDataList()) {
                        SongSearchActivity.this.mLEEAdapter.setCurrentView(103);
                    }
                }
            });
        }
    }

    public class SearchSongAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private List<Music.Song> songs;

        public SearchSongAdapter() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        @NonNull
        public RecyclerView.O000OOo0 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new SearchSongViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_item_song_alarm_search, viewGroup, false));
        }

        public void onBindViewHolder(@NonNull RecyclerView.O000OOo0 o000OOo0, int i) {
            ((SearchSongViewHolder) o000OOo0).bindView(this.songs.get(i));
        }

        public int getItemCount() {
            List<Music.Song> list = this.songs;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public boolean isNullDataList() {
            List<Music.Song> list = this.songs;
            return list == null || list.isEmpty();
        }

        public void updateDataList(List<Music.Song> list) {
            this.songs = list;
            notifyDataSetChanged();
        }

        public void addDataList(List<Music.Song> list) {
            List<Music.Song> list2 = this.songs;
            if (list2 != null) {
                list2.addAll(list);
                notifyDataSetChanged();
            }
        }
    }

    static class SearchSongViewHolder extends RecyclerView.O000OOo0 {
        TextView descriptionView;
        private Music.Song music;
        TextView nameView;

        public SearchSongViewHolder(View view) {
            super(view);
            this.nameView = (TextView) view.findViewById(R.id.music_item_title);
            this.descriptionView = (TextView) view.findViewById(R.id.music_item_description);
            view.findViewById(R.id.root_view).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$SongSearchActivity$SearchSongViewHolder$vaYypbX6lUIm7d4A8fxrgGVc4A */

                public final void onClick(View view) {
                    SongSearchActivity.SearchSongViewHolder.this.lambda$new$0$SongSearchActivity$SearchSongViewHolder(view);
                }
            });
        }

        public void bindView(Music.Song song) {
            this.music = song;
            this.nameView.setText(MusicHelper.getTitle(song));
            this.descriptionView.setText(MusicHelper.getDescription(song));
        }

        /* renamed from: onClick */
        public void lambda$new$0$SongSearchActivity$SearchSongViewHolder(View view) {
            jgc.O000000o().O00000o(new MicoEvent.AlarmRingChange(AlarmHelper.getSongAlarmRing(this.music)));
            ((Activity) view.getContext()).finish();
        }
    }
}
