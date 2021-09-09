package com.xiaomi.mico.music.detail;

import _m_j.czx;
import _m_j.dai;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.base.EditorBarActivity;
import com.xiaomi.mico.common.editorbar.ActionCallback;
import com.xiaomi.mico.common.editorbar.ActionMenu;
import com.xiaomi.mico.common.editorbar.MenuBuilder;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.LEEAdapter;
import com.xiaomi.mico.common.recyclerview.itemdecoration.Ignore;
import com.xiaomi.mico.common.recyclerview.itemdecoration.ItemDecorationHelper;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.util.ViewUtil;
import com.xiaomi.mico.common.widget.ChannelDetailEditPopupView;
import com.xiaomi.mico.common.widget.OpenQQMusicVipPopupView;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.common.widget.dialog.InputViewDialog;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.mico.music.adapter.SongAdapter;
import com.xiaomi.mico.music.channel.ChannelManager;
import com.xiaomi.mico.music.detail.DetailListTab;
import com.xiaomi.mico.music.player.PlayerActivityV2;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import com.xiaomi.mico.music.search.SearchActivity;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class ChannelDetailActivity extends EditorBarActivity implements ItemClickableAdapter.OnItemClickListener, TitleBar.OnRightIconClickListener, LovableAdapter.Lovable, DetailListTab.DetailPlayAllListener, PlayerStatusTrack.onTrackListener {
    DetailHeader detailHeader;
    DetailTitleBar detailTitleBar;
    private ApiRequest mApiRequest;
    public Music.Channel mChannel;
    public LEEAdapter mLEEAdapter;
    RecyclerView recyclerView;
    SmartRefreshLayout refreshLayout;
    DetailListTab tabView;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_detail_general_loadmore);
        this.tabView = (DetailListTab) findViewById(R.id.detail_list_tab);
        this.detailHeader = (DetailHeader) findViewById(R.id.detail_header);
        this.detailTitleBar = (DetailTitleBar) findViewById(R.id.title_bar);
        this.recyclerView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        this.refreshLayout = (SmartRefreshLayout) findViewById(R.id.refresh_layout);
        boolean booleanExtra = getIntent().getBooleanExtra("new_create", false);
        this.mChannel = (Music.Channel) getIntent().getSerializableExtra("music");
        if (this.mChannel == null) {
            finish();
            return;
        }
        this.detailTitleBar.setLeftIcon(R.drawable.mj_common_title_bar_return);
        this.detailTitleBar.setRightIcon(R.drawable.icon_more_normal, this);
        this.detailHeader.setMusic(this.mChannel, false);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.addItemDecoration(ItemDecorationHelper.listDivider(this, getResources().getDimensionPixelSize(R.dimen.music_item_header_height), 0, new Ignore() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass1 */

            public boolean needIgnore(int i, int i2) {
                return ChannelDetailActivity.this.mLEEAdapter.getCurrentView() != 100 || ChannelDetailActivity.this.getRealAdapter().isHeaderByPosition(i);
            }
        }));
        SongAdapter.Editable editable = new SongAdapter.Editable(this.editorBar, new ActionMenu.MenuCallback() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass2 */

            public void onPrepareMenu(MenuBuilder menuBuilder) {
                menuBuilder.add(1, R.drawable.icon_menu_delete, ChannelDetailActivity.this.getString(R.string.common_menu_delete));
            }

            public void onMenuItemClick(MenuBuilder.MenuItem menuItem) {
                if (menuItem.getId() == 1) {
                    ChannelDetailActivity channelDetailActivity = ChannelDetailActivity.this;
                    channelDetailActivity.deleteSongs(channelDetailActivity.getRealAdapter().getSelectedPositions());
                }
            }
        }, false);
        editable.setOnItemClickListener(this);
        if (!booleanExtra) {
            editable.setStableDataSize(this.mChannel.songCount);
        }
        editable.setLovable(this);
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.view_loading, (ViewGroup) this.recyclerView, false);
        View inflate2 = LayoutInflater.from(getContext()).inflate((int) R.layout.view_empty_error, (ViewGroup) this.recyclerView, false);
        ViewUtil.setupEmptyView(inflate2, true, getString(R.string.music_channel_empty_tip), getString(R.string.music_channel_add_song), new Action1<Void>() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass3 */

            public void call(Void voidR) {
                ChannelDetailActivity.this.addSongs();
            }
        });
        View inflate3 = LayoutInflater.from(getContext()).inflate((int) R.layout.view_empty_error, (ViewGroup) this.recyclerView, false);
        ViewUtil.setupErrorView(inflate3, true, new Action1<Void>() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass4 */

            public void call(Void voidR) {
                ChannelDetailActivity.this.mLEEAdapter.setCurrentView(101);
                ChannelDetailActivity.this.getChannelInfo(0);
            }
        });
        this.mLEEAdapter = new LEEAdapter(editable, inflate, inflate2, inflate3);
        this.mLEEAdapter.setCurrentView(!booleanExtra ? 101 : 102);
        this.recyclerView.setAdapter(this.mLEEAdapter);
        this.editorBar.setSelector(editable);
        this.editorBar.addActionCallback(new ActionCallback() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass5 */

            public void onActionStarted() {
                onAction(true);
            }

            public void onActionFinished() {
                onAction(false);
            }

            private void onAction(boolean z) {
                ((LinearLayout.LayoutParams) ChannelDetailActivity.this.recyclerView.getLayoutParams()).bottomMargin = z ? ChannelDetailActivity.this.getResources().getDimensionPixelSize(R.dimen.common_bottom_bar_height) : 0;
            }
        });
        if (!booleanExtra) {
            getChannelInfo(0);
        }
        if (this.mChannel.isQQCollection) {
            this.detailTitleBar.getRightIcon().setVisibility(8);
            this.editorBar.setCanEdit(false);
        }
        List<Music.Channel> channelList = ChannelManager.getInstance().getChannelList();
        if (channelList == null || channelList.isEmpty()) {
            ChannelManager.getInstance().getChannelList(null);
        }
        this.refreshLayout.O00000o0(false);
        this.refreshLayout.O0000O0o(true);
        this.refreshLayout.O00000o(true);
        this.refreshLayout.O000000o(new dai() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass6 */

            public void onLoadMore(czx czx) {
                if (ChannelDetailActivity.this.mLEEAdapter.getCurrentView() == 100) {
                    ChannelDetailActivity channelDetailActivity = ChannelDetailActivity.this;
                    channelDetailActivity.getChannelInfo(channelDetailActivity.getRealAdapter().getDataSize());
                    return;
                }
                czx.O0000O0o(false);
                czx.O0000O0o();
            }
        });
        this.detailHeader.mTabView.setPlayAllListener(this);
        this.detailHeader.updateDescInfo(null);
        this.detailHeader.showPlayAllView();
        loadQQVIPStatus();
    }

    public void onResume() {
        super.onResume();
        PlayerStatusTrack.getInstance().register(this);
        this.detailTitleBar.onResume();
    }

    public void onPause() {
        super.onPause();
        PlayerStatusTrack.getInstance().unregister(this);
        this.detailTitleBar.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        ApiRequest apiRequest = this.mApiRequest;
        if (apiRequest != null) {
            apiRequest.cancel();
            this.mApiRequest = null;
        }
    }

    public void onRightIconClick() {
        ChannelDetailEditPopupView.show(getContext(), this.detailTitleBar.getRightIcon(), !this.mChannel.isDefault && this.mChannel.operable, new ChannelDetailEditPopupView.onEditChannelListener() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass7 */

            public void onAddSong() {
                ChannelDetailActivity.this.addSongs();
            }

            public void onEnterEdit() {
                ItemClickableAdapter.OnItemLongClickListener onItemLongClickListener;
                RecyclerView.O000000o<RecyclerView.O000OOo0> wrappedAdapter = ChannelDetailActivity.this.mLEEAdapter.getWrappedAdapter();
                if (wrappedAdapter.getItemCount() <= 0) {
                    ToastUtil.showToast((int) R.string.music_channel_disable_edit);
                } else if ((wrappedAdapter instanceof SongAdapter.Editable) && (onItemLongClickListener = ((SongAdapter.Editable) wrappedAdapter).getOnItemLongClickListener()) != null) {
                    onItemLongClickListener.onItemLongClick(null, -1);
                }
            }

            public void onRenameChanne() {
                ChannelDetailActivity.this.renameChannel();
            }

            public void onDeleteSong() {
                ChannelDetailActivity.this.deleteChannel();
            }
        });
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        if (getRealAdapter() != null) {
            getRealAdapter().updatePlayingMusicID(MusicHelper.getPlayingMusicID(playerStatus));
        }
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        final SongAdapter.Editable<Music.Song> realAdapter = getRealAdapter();
        Music.Song data = realAdapter.getData(i);
        OpenQQMusicVipPopupView.showOpenVipPopupView(data, getContext());
        if (String.valueOf(data.songID).equals(realAdapter.getPlayingMusicID())) {
            PlayerActivityV2.displayPlayerWithAnim(getContext());
        } else {
            MusicHelper.playSongs(1, this.mChannel.id, realAdapter.getDataList(), realAdapter.isHeaderByPosition(i) ? -1 : realAdapter.getDataIndex(i), new MusicHelper.OnPlayingListener() {
                /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass8 */

                public void onPlaying(String str) {
                    realAdapter.updatePlayingMusicID(str);
                }
            });
        }
    }

    public void onLove(View view, Serializable serializable) {
        MusicHelper.addToChannel(getContext(), (Music.Song) serializable);
    }

    public SongAdapter.Editable<Music.Song> getRealAdapter() {
        return (SongAdapter.Editable) this.mLEEAdapter.getWrappedAdapter();
    }

    public void getChannelInfo(final int i) {
        final SongAdapter.Editable<Music.Song> realAdapter = getRealAdapter();
        this.mApiRequest = ChannelManager.getInstance().getChannelInfo(this.mChannel.id, i, 20, new ApiRequest.Listener<Music.Channel>() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass9 */

            public void onSuccess(Music.Channel channel) {
                ChannelDetailActivity.this.refreshLayout.O0000O0o();
                List<Music.Song> list = channel.songList;
                boolean z = false;
                if (i <= 0) {
                    realAdapter.setStableDataSize(channel.songCount);
                    realAdapter.updateDataList(list);
                    ChannelDetailActivity.this.updateChannelCore(channel);
                    SmartRefreshLayout smartRefreshLayout = ChannelDetailActivity.this.refreshLayout;
                    if (list.size() >= 20) {
                        z = true;
                    }
                    smartRefreshLayout.O0000O0o(z);
                } else if (!list.isEmpty()) {
                    realAdapter.addDataList(list);
                } else {
                    ToastUtil.showToast((int) R.string.loadmore_result_nothing);
                    ChannelDetailActivity.this.refreshLayout.O0000O0o(false);
                }
                if (realAdapter.getDataSize() <= 0) {
                    ChannelDetailActivity.this.mLEEAdapter.setCurrentView(102);
                } else if (i <= 0) {
                    ChannelDetailActivity.this.mLEEAdapter.setCurrentView(100);
                }
            }

            public void onFailure(ApiError apiError) {
                ChannelDetailActivity.this.refreshLayout.O0000O0o();
                if (realAdapter.isNullDataList()) {
                    ChannelDetailActivity.this.mLEEAdapter.setCurrentView(103);
                    ChannelDetailActivity.this.refreshLayout.O0000O0o(false);
                }
            }
        });
    }

    public void updateChannelCore(Music.Channel channel) {
        channel.isDefault = this.mChannel.isDefault;
        channel.songList = null;
        channel.name = this.mChannel.name;
        channel.cover = this.mChannel.cover;
        channel.operable = this.mChannel.operable;
        channel.origin = this.mChannel.origin;
        channel.isQQCollection = this.mChannel.isQQCollection;
        this.mChannel = channel;
        this.detailHeader.updateMusic(this.mChannel);
    }

    public void addSongs() {
        startActivityForResult(new Intent(this, SearchActivity.class), 101);
    }

    public void renameChannel() {
        Observable.create(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass13 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super String>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super String> subscriber) {
                new InputViewDialog(ChannelDetailActivity.this.getContext()).setTitle((int) R.string.music_channel_rename).setInitText(ChannelDetailActivity.this.mChannel.name).setListener(new InputViewDialog.Listener() {
                    /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass13.AnonymousClass1 */

                    public void onFinish(String str) {
                        if (!str.equals(ChannelDetailActivity.this.mChannel.name)) {
                            subscriber.onNext(str);
                        }
                        subscriber.onCompleted();
                    }
                }).show();
            }
        }).flatMap(new Func1<String, Observable<String>>() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass12 */

            public Observable<String> call(String str) {
                ChannelDetailActivity channelDetailActivity = ChannelDetailActivity.this;
                channelDetailActivity.showProgressDialog(channelDetailActivity.getString(R.string.common_waiting));
                return ChannelManager.getInstance().renameChannel(ChannelDetailActivity.this.mChannel.id, str);
            }
        }).subscribe(new Action1<String>() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass10 */

            public void call(String str) {
                ChannelDetailActivity.this.dismissProgressDialog();
                ChannelDetailActivity.this.mChannel.name = str;
                ChannelDetailActivity.this.detailHeader.updateName(str);
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass11 */

            public void call(Throwable th) {
                ChannelDetailActivity.this.dismissProgressDialog();
                if (!(th instanceof ApiError.ApiErrorException) || ((ApiError.ApiErrorException) th).getCode() != 215) {
                    ToastUtil.showToast((int) R.string.common_failed);
                } else {
                    ToastUtil.showToast((int) R.string.music_channel_qq_modify_tip);
                }
            }
        });
    }

    public void deleteChannel() {
        showProgressDialog(getString(R.string.common_waiting));
        ChannelManager.getInstance().deleteChannel(this.mChannel.id).subscribe(new Action1<Boolean>() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass14 */

            public void call(Boolean bool) {
                ChannelDetailActivity.this.dismissProgressDialog();
                ChannelDetailActivity.this.finish();
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass15 */

            public void call(Throwable th) {
                ChannelDetailActivity.this.dismissProgressDialog();
                if (!(th instanceof ApiError.ApiErrorException) || ((ApiError.ApiErrorException) th).getCode() != 215) {
                    ToastUtil.showToast((int) R.string.common_failed);
                } else {
                    ToastUtil.showToast((int) R.string.music_channel_qq_delete_tip);
                }
            }
        });
    }

    public void deleteSongs(final List<Integer> list) {
        if (list != null && !list.isEmpty()) {
            final SongAdapter.Editable<Music.Song> realAdapter = getRealAdapter();
            ArrayList arrayList = new ArrayList(list.size());
            for (Integer intValue : list) {
                arrayList.add(realAdapter.getData(intValue.intValue()));
            }
            showProgressDialog(getString(R.string.common_waiting));
            ChannelManager.getInstance().deleteSongs(this.mChannel.id, arrayList).subscribe(new Action1<Boolean>() {
                /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass16 */

                public void call(Boolean bool) {
                    ChannelDetailActivity.this.dismissProgressDialog();
                    realAdapter.decreaseStableDataSize(list.size());
                    realAdapter.removeSelectedPositions(list);
                    if (realAdapter.getDataSize() == 0) {
                        ChannelDetailActivity.this.refreshLayout.O0000O0o(false);
                        ChannelDetailActivity.this.mLEEAdapter.setCurrentView(102);
                    }
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.mico.music.detail.ChannelDetailActivity.AnonymousClass17 */

                public void call(Throwable th) {
                    ChannelDetailActivity.this.dismissProgressDialog();
                    ToastUtil.showToast((int) R.string.common_failed);
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 101) {
            getChannelInfo(0);
        }
    }

    public void onPlayAll() {
        if (this.mLEEAdapter.getWrappedAdapter().getItemCount() > 0) {
            onItemClick(null, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void loadQQVIPStatus() {
        DetailListTab detailListTab = this.tabView;
        if (detailListTab != null) {
            detailListTab.updateOpenVipViewVisibility();
        }
    }
}
