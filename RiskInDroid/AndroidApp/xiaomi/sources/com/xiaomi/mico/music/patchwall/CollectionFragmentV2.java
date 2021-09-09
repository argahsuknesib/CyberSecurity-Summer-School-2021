package com.xiaomi.mico.music.patchwall;

import _m_j.jgc;
import _m_j.jgi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Transformation;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.adapter.MiCoinPriceAdapter;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.application.AreaCode;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.KKBoxAuthPopupView;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.channel.ChannelManager;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.favourite.FavouriteActivity;
import com.xiaomi.mico.music.patchwall.CollectionFragmentV2;
import com.xiaomi.mico.music.puchased.PurchasedRecordActivity;
import com.xiaomi.mico.music.recentplay.RecentPlayActivity;
import com.xiaomi.mico.setting.MusicAccountAuthInfoActivity;
import com.xiaomi.mico.setting.MusicSourceSettingActivity;
import com.xiaomi.mico.setting.RechargeMiCoinActivity;
import com.xiaomi.mico.setting.SettingItem;
import com.xiaomi.mico.setting.TrafficSettingActivity;
import com.xiaomi.mico.setting.stereo.StereoMainActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import rx.functions.Action1;

public class CollectionFragmentV2 extends BasePatchWallFragment implements ItemClickableAdapter.OnItemClickListener {
    public boolean isQQBuildPlaylist = true;
    public PersonalAdapter mPersonalAdapter;
    public float miCoinBalance = 0.0f;
    public List<Music.Channel> qqCollections;

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mRecyclerView.setBackgroundColor(getResources().getColor(17170443));
        this.mRecyclerView.setHasFixedSize(true);
        this.mPersonalAdapter = new PersonalAdapter();
        this.mPersonalAdapter.setOnItemClickListener(this);
        this.mRecyclerView.setAdapter(this.mPersonalAdapter);
        jgc.O000000o().O000000o(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        jgc.O000000o().O00000o0(this);
    }

    public void onActivate() {
        super.onActivate();
        loadChannelList();
    }

    public void loadChannelList() {
        if (this.isQQBuildPlaylist) {
            this.mPersonalAdapter.updateChannelList(ChannelManager.getInstance().getChannelList());
            ChannelManager.getInstance().getChannelList(null);
            return;
        }
        this.mPersonalAdapter.updateChannelList(this.qqCollections);
        ApiHelper.getQQCollectionsList(new ApiRequest.Listener<List<Music.Channel>>() {
            /* class com.xiaomi.mico.music.patchwall.CollectionFragmentV2.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Channel>) ((List) obj));
            }

            public void onSuccess(List<Music.Channel> list) {
                CollectionFragmentV2.this.qqCollections = list;
                for (Music.Channel channel : list) {
                    channel.isQQCollection = true;
                }
                if (!CollectionFragmentV2.this.isQQBuildPlaylist) {
                    CollectionFragmentV2.this.mPersonalAdapter.updateChannelList(list);
                }
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError;
            }
        }).bindToLifecycle(this);
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onChannelListChanged(MusicEvent.ChannelListChanged channelListChanged) {
        if (this.isQQBuildPlaylist) {
            this.mPersonalAdapter.updateChannelList(ChannelManager.getInstance().getChannelList());
        }
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        Object item = this.mPersonalAdapter.getItem(i);
        if (item != null) {
            MusicHelper.processMusic(getContext(), (Music.Channel) item);
        } else {
            createChannel();
        }
    }

    public void createChannel() {
        MusicHelper.createChannel(getContext()).subscribe(new Action1<Long>() {
            /* class com.xiaomi.mico.music.patchwall.CollectionFragmentV2.AnonymousClass2 */

            public void call(Long l) {
                Music.Channel channelById = ChannelManager.getInstance().getChannelById(l.longValue());
                channelById.isDefault = false;
                channelById.operable = true;
                if (channelById != null) {
                    MusicHelper.processChannel(CollectionFragmentV2.this.getContext(), channelById, true);
                }
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.patchwall.CollectionFragmentV2.AnonymousClass3 */

            public void call(Throwable th) {
                if (!(th instanceof ApiError.ApiErrorException) || ((ApiError.ApiErrorException) th).getCode() != 215) {
                    ToastUtil.showToast((int) R.string.common_failed);
                } else {
                    ToastUtil.showToast((int) R.string.music_channel_qq_create_tip);
                }
            }
        });
    }

    class PersonalAdapter extends GroupAdapter<ItemClickableAdapter.ViewHolder> {
        private PersonalAdapter() {
            addGroup(new PersonalGroup());
            addGroup(new DividerGroup());
            AreaCode areaCode = ApiConstants.getAreaCode();
            if (AreaCode.CN == areaCode) {
                addGroup(new SettingGroup());
            } else if (AreaCode.TW == areaCode) {
                addGroup(new SettingGroupTW());
            }
            addGroup(new EmptyGroup());
        }

        public void updateChannelList(List<Music.Channel> list) {
            GroupAdapter.Group groupByID = getGroupByID("channel");
            if (groupByID != null) {
                ArrayList arrayList = null;
                if (list != null) {
                    arrayList = new ArrayList();
                    arrayList.addAll(list);
                }
                if (groupByID instanceof ChannelGroup) {
                    ((ChannelGroup) groupByID).updateChannelList(arrayList);
                }
                notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public ItemClickableAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 101 || i == 102 || i == 103) {
                return new PersonalViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_collection_header_single, viewGroup, false));
            }
            if (i == 201) {
                return new SettingsViewHolder(new SettingItem(viewGroup.getContext()));
            }
            if (i == 301) {
                return new DividerGroupViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_collection_divider, viewGroup, false));
            }
            if (i != 6) {
                return null;
            }
            return new EmptyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_channel_empty, viewGroup, false));
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindViewHolder(viewHolder, i);
        }
    }

    static class PersonalGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        public int getHeaderCount() {
            return 0;
        }

        public String getID() {
            return "personal";
        }

        public int getItemCount() {
            return 3;
        }

        public int getItemViewType(int i) {
            if (i == 0) {
                return 101;
            }
            if (i == 1) {
                return 102;
            }
            return i == 2 ? 103 : 101;
        }

        private PersonalGroup() {
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            if (i == 0) {
                ((TextView) viewHolder.itemView.findViewById(R.id.title)).setText((int) R.string.music_my_play_record);
                viewHolder.itemView.findViewById(R.id.music_personal_recent).setBackgroundResource(R.drawable.mico_mine_item_play_record_bg);
            } else if (i == 1) {
                ((TextView) viewHolder.itemView.findViewById(R.id.title)).setText((int) R.string.music_my_favourite);
                viewHolder.itemView.findViewById(R.id.music_personal_recent).setBackgroundResource(R.drawable.mico_mine_item_my_fav_bg);
            } else if (i == 2) {
                ((TextView) viewHolder.itemView.findViewById(R.id.title)).setText((int) R.string.music_my_play_list);
                viewHolder.itemView.findViewById(R.id.music_personal_recent).setBackgroundResource(R.drawable.mico_mine_item_my_songlist_bg);
            }
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(i) {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$CollectionFragmentV2$PersonalGroup$GtuDrXG5dsMrduqG_fNZ5ZqseGs */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CollectionFragmentV2.PersonalGroup.this.lambda$onBindViewHolder$0$CollectionFragmentV2$PersonalGroup(this.f$1, view);
                }
            });
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$CollectionFragmentV2$PersonalGroup(int i, View view) {
            onClick(i);
        }

        private void onClick(int i) {
            Intent intent;
            Context appContext = CommonApplication.getAppContext();
            if (i == 0) {
                intent = new Intent(appContext, RecentPlayActivity.class);
            } else if (i == 1) {
                intent = new Intent(appContext, FavouriteActivity.class);
            } else {
                intent = i == 2 ? new Intent(appContext, MySongsActivity.class) : null;
            }
            if (intent != null) {
                intent.addFlags(268435456);
                appContext.startActivity(intent);
            }
        }
    }

    class ChannelGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        private List<Music.Channel> channelList;

        public String getID() {
            return "channel";
        }

        private ChannelGroup() {
        }

        public void updateChannelList(List<Music.Channel> list) {
            this.channelList = list;
        }

        private int getChannelSize() {
            List<Music.Channel> list = this.channelList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public int getItemCount() {
            if (this.channelList == null) {
                return 0;
            }
            if (!AccountProfile.current().isQQMusicSource() || AccountProfile.current().isQQAccountAuthValid() || !ApiConstants.isAreaCodeInCN()) {
                return getChannelSize();
            }
            return 0;
        }

        public Music.Channel getItem(int i) {
            if (i < getChannelSize()) {
                return this.channelList.get(i);
            }
            return null;
        }

        public int getItemViewType(int i) {
            return isHeader(i) ? 5 : 3;
        }

        public int getHeaderCount() {
            return super.getHeaderCount();
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof QQMusicChannelViewHolder) {
                ((QQMusicChannelViewHolder) viewHolder).refreshUI(getItem(i - getHeaderCount()));
            } else if (viewHolder instanceof QQmusicPlaylistSwitchViewHolder) {
                ((QQmusicPlaylistSwitchViewHolder) viewHolder).refreshUI(getItemCount());
            }
        }
    }

    private void getMiCoinBalance() {
        ApiHelper.getMiCoinBalance(new ApiRequest.Listener<Long>() {
            /* class com.xiaomi.mico.music.patchwall.CollectionFragmentV2.AnonymousClass4 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(Long l) {
                if (CollectionFragmentV2.this.isValid()) {
                    CollectionFragmentV2.this.miCoinBalance = ((float) l.longValue()) / 100.0f;
                    CollectionFragmentV2.this.getActivity().runOnUiThread(new Runnable() {
                        /* class com.xiaomi.mico.music.patchwall.CollectionFragmentV2.AnonymousClass4.AnonymousClass1 */

                        public void run() {
                            CollectionFragmentV2.this.mPersonalAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    class SettingGroupTW extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        public int getHeaderCount() {
            return 0;
        }

        public String getID() {
            return "setting";
        }

        public int getItemCount() {
            return 1;
        }

        public int getItemViewType(int i) {
            return 201;
        }

        private SettingGroupTW() {
        }

        public Object getItem(int i) {
            return super.getItem(i);
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            SettingItem settingItem = (SettingItem) viewHolder.itemView;
            settingItem.setMinimumHeight(settingItem.getContext().getResources().getDimensionPixelSize(R.dimen.mico_common_list_item_height));
            if (i == 0) {
                settingItem.setText(CollectionFragmentV2.this.getContext().getText(R.string.mico_auth_account));
                if (AccountProfile.current().isKKBoxAuthValid()) {
                    MusicAccountAuthInfoActivity.start(CollectionFragmentV2.this.getContext(), "kkbox", "个人中心");
                } else {
                    KKBoxAuthPopupView.showAuthAlert(CollectionFragmentV2.this.getContext());
                }
            }
        }
    }

    class SettingGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        public int getHeaderCount() {
            return 0;
        }

        public String getID() {
            return "setting";
        }

        public int getItemCount() {
            return 6;
        }

        public int getItemViewType(int i) {
            return 201;
        }

        private SettingGroup() {
        }

        public Object getItem(int i) {
            return super.getItem(i);
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            SettingItem settingItem = (SettingItem) viewHolder.itemView;
            settingItem.setMinimumHeight(settingItem.getContext().getResources().getDimensionPixelSize(R.dimen.mico_common_list_item_height));
            if (i == 0) {
                settingItem.setText(CollectionFragmentV2.this.getContext().getText(R.string.mico_mine_recharge));
                settingItem.setContent("余额" + MiCoinPriceAdapter.PriceItem.getFormatMiCoin(CollectionFragmentV2.this.miCoinBalance));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.$$Lambda$CollectionFragmentV2$SettingGroup$q_X6N_E525XhCQZXEPCeoyvBspw */

                    public final void onClick(View view) {
                        CollectionFragmentV2.SettingGroup.this.lambda$onBindViewHolder$0$CollectionFragmentV2$SettingGroup(view);
                    }
                });
            } else if (i == 1) {
                settingItem.setText(CollectionFragmentV2.this.getContext().getText(R.string.mico_mine_buy_list));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.$$Lambda$CollectionFragmentV2$SettingGroup$S17JHJ6yjT66CIjUAj4joZTmgg */

                    public final void onClick(View view) {
                        CollectionFragmentV2.SettingGroup.this.lambda$onBindViewHolder$1$CollectionFragmentV2$SettingGroup(view);
                    }
                });
            } else if (i == 2) {
                settingItem.setText(CollectionFragmentV2.this.getContext().getText(R.string.mico_auth_account));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.$$Lambda$CollectionFragmentV2$SettingGroup$cZiweMV6gIWzTOdsaKvtbZHpZ0 */

                    public final void onClick(View view) {
                        CollectionFragmentV2.SettingGroup.this.lambda$onBindViewHolder$2$CollectionFragmentV2$SettingGroup(view);
                    }
                });
            } else if (i == 3) {
                settingItem.setText(CollectionFragmentV2.this.getContext().getText(R.string.mico_mine_music_setting));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.$$Lambda$CollectionFragmentV2$SettingGroup$cv5EO5JUc6Uisq8bF_aSoWePrgc */

                    public final void onClick(View view) {
                        CollectionFragmentV2.SettingGroup.this.lambda$onBindViewHolder$3$CollectionFragmentV2$SettingGroup(view);
                    }
                });
            } else if (i == 4) {
                settingItem.setText(CollectionFragmentV2.this.getContext().getText(R.string.mico_mine_stereo_setting));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.$$Lambda$CollectionFragmentV2$SettingGroup$H8XIjcBsCnVf7BK8anuMy72Qwa8 */

                    public final void onClick(View view) {
                        CollectionFragmentV2.SettingGroup.this.lambda$onBindViewHolder$4$CollectionFragmentV2$SettingGroup(view);
                    }
                });
            } else if (i == 5) {
                settingItem.setText(CollectionFragmentV2.this.getContext().getText(R.string.mico_mine_traffic));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.$$Lambda$CollectionFragmentV2$SettingGroup$JfPwUiPBZ_8zsksBbAjRfroVifA */

                    public final void onClick(View view) {
                        CollectionFragmentV2.SettingGroup.this.lambda$onBindViewHolder$5$CollectionFragmentV2$SettingGroup(view);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$CollectionFragmentV2$SettingGroup(View view) {
            CollectionFragmentV2.this.getContext().startActivity(new Intent(CollectionFragmentV2.this.getContext(), RechargeMiCoinActivity.class));
        }

        public /* synthetic */ void lambda$onBindViewHolder$1$CollectionFragmentV2$SettingGroup(View view) {
            CollectionFragmentV2.this.getContext().startActivity(new Intent(CollectionFragmentV2.this.getContext(), PurchasedRecordActivity.class));
        }

        public /* synthetic */ void lambda$onBindViewHolder$2$CollectionFragmentV2$SettingGroup(View view) {
            SchemaManager.handleSchema(CollectionFragmentV2.this.getContext(), "mico://services/oauth?skillId=279202210947007488&providerID=269135865337350144");
        }

        public /* synthetic */ void lambda$onBindViewHolder$3$CollectionFragmentV2$SettingGroup(View view) {
            CollectionFragmentV2.this.getContext().startActivity(new Intent(CollectionFragmentV2.this.getContext(), MusicSourceSettingActivity.class));
        }

        public /* synthetic */ void lambda$onBindViewHolder$4$CollectionFragmentV2$SettingGroup(View view) {
            CollectionFragmentV2.this.getContext().startActivity(new Intent(CollectionFragmentV2.this.getContext(), StereoMainActivity.class));
        }

        public /* synthetic */ void lambda$onBindViewHolder$5$CollectionFragmentV2$SettingGroup(View view) {
            CollectionFragmentV2.this.getContext().startActivity(new Intent(CollectionFragmentV2.this.getContext(), TrafficSettingActivity.class));
        }
    }

    static class PersonalViewHolder extends ItemClickableAdapter.ViewHolder {
        private Context context;

        private PersonalViewHolder(View view) {
            super(view, null);
            this.context = view.getContext();
        }

        public void onClick(View view) {
            view.getId();
        }
    }

    static class SettingsViewHolder extends ItemClickableAdapter.ViewHolder {
        private Context context;

        private SettingsViewHolder(SettingItem settingItem) {
            super(settingItem, null);
            this.context = settingItem.getContext();
            settingItem.setDivider(false);
        }

        public void onClick(View view) {
            view.getId();
        }
    }

    static class DividerGroupViewHolder extends ItemClickableAdapter.ViewHolder {
        private Context context;

        private DividerGroupViewHolder(View view) {
            super(view, null);
            this.context = view.getContext();
        }

        public void onClick(View view) {
            view.getId();
        }
    }

    static class EmptyGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        public String getID() {
            return "empty";
        }

        public int getItemViewType(int i) {
            return 6;
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        }

        private EmptyGroup() {
        }
    }

    static class DividerGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        public String getID() {
            return "DividerGroup";
        }

        public int getItemViewType(int i) {
            return 301;
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        }

        private DividerGroup() {
        }
    }

    class EmptyViewHolder extends ItemClickableAdapter.ViewHolder {
        public void refreshUI() {
        }

        public EmptyViewHolder(View view) {
            super(view, null);
        }
    }

    class QQmusicPlaylistSwitchViewHolder extends ItemClickableAdapter.ViewHolder {
        TextView buildPlayList;
        TextView channelCount;
        TextView collectPlayList;
        private Context context;
        View viewBuildNew;
        View viewMiChannelTitle;
        View viewQQChannelSwitcher;

        public QQmusicPlaylistSwitchViewHolder(View view) {
            super(view, null);
            this.buildPlayList = (TextView) view.findViewById(R.id.build_playlist);
            this.buildPlayList.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$CollectionFragmentV2$QQmusicPlaylistSwitchViewHolder$9aDDhtqN3vL5lhaey93Fa51D5BY */

                public final void onClick(View view) {
                    CollectionFragmentV2.QQmusicPlaylistSwitchViewHolder.this.lambda$new$0$CollectionFragmentV2$QQmusicPlaylistSwitchViewHolder(view);
                }
            });
            this.collectPlayList = (TextView) view.findViewById(R.id.collection_playlist);
            this.collectPlayList.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$CollectionFragmentV2$QQmusicPlaylistSwitchViewHolder$v1tXdMnhUJtgkKKzFOrTM5n3UxM */

                public final void onClick(View view) {
                    CollectionFragmentV2.QQmusicPlaylistSwitchViewHolder.this.lambda$new$1$CollectionFragmentV2$QQmusicPlaylistSwitchViewHolder(view);
                }
            });
            this.channelCount = (TextView) view.findViewById(R.id.music_collection_count);
            this.viewBuildNew = view.findViewById(R.id.music_build_new_channel);
            this.viewBuildNew.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$CollectionFragmentV2$QQmusicPlaylistSwitchViewHolder$w_NsI6gDkPLcbYMc1FRiwdpfNc */

                public final void onClick(View view) {
                    CollectionFragmentV2.QQmusicPlaylistSwitchViewHolder.this.lambda$new$2$CollectionFragmentV2$QQmusicPlaylistSwitchViewHolder(view);
                }
            });
            this.viewMiChannelTitle = view.findViewById(R.id.mi_channel_title);
            this.viewQQChannelSwitcher = view.findViewById(R.id.channel_qq_switcher);
            this.context = view.getContext();
            this.collectPlayList.setText((int) R.string.music_channel_qq_coll);
            this.buildPlayList.setText((int) R.string.music_channel_qq_build);
            if (AccountProfile.current().isQQMusicSource()) {
                this.viewQQChannelSwitcher.setVisibility(0);
                this.viewMiChannelTitle.setVisibility(8);
                selectedBuildPlayList();
                return;
            }
            this.viewQQChannelSwitcher.setVisibility(8);
            this.viewMiChannelTitle.setVisibility(0);
        }

        private void selectedBuildPlayList() {
            this.collectPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_gray_lighter));
            this.buildPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_black));
            this.buildPlayList.setTextSize(2, 15.0f);
            this.collectPlayList.setTextSize(2, 13.0f);
            CollectionFragmentV2.this.isQQBuildPlaylist = true;
        }

        public void refreshUI(int i) {
            this.channelCount.setText(this.context.getString(R.string.music_channel_size, Integer.valueOf(i)));
            if (!AccountProfile.current().isQQMusicSource() || AccountProfile.current().isQQAccountAuthValid() || !ApiConstants.isAreaCodeInCN()) {
                this.itemView.setVisibility(0);
            } else {
                this.itemView.setVisibility(4);
            }
        }

        /* renamed from: onClick */
        public void lambda$new$2$CollectionFragmentV2$QQmusicPlaylistSwitchViewHolder(View view) {
            int id = view.getId();
            if (id == R.id.build_playlist) {
                this.collectPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_gray_lighter));
                this.buildPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_black));
                this.buildPlayList.setTextSize(2, 15.0f);
                this.collectPlayList.setTextSize(2, 13.0f);
                CollectionFragmentV2.this.isQQBuildPlaylist = true;
                this.viewBuildNew.setVisibility(0);
                CollectionFragmentV2.this.loadChannelList();
            } else if (id == R.id.build_playlist) {
                this.buildPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_gray_lighter));
                this.collectPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_black));
                this.collectPlayList.setTextSize(2, 15.0f);
                this.buildPlayList.setTextSize(2, 13.0f);
                CollectionFragmentV2.this.isQQBuildPlaylist = false;
                this.viewBuildNew.setVisibility(8);
                CollectionFragmentV2.this.loadChannelList();
            } else if (id == R.id.music_build_new_channel) {
                CollectionFragmentV2.this.createChannel();
            }
        }
    }

    class QQMusicChannelViewHolder extends ItemClickableAdapter.ViewHolder {
        TextView desc;
        ImageView mCover;
        TextView title;

        public QQMusicChannelViewHolder(View view, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(view, onItemClickListener);
            this.desc = (TextView) view.findViewById(R.id.music_item_description);
            this.title = (TextView) view.findViewById(R.id.music_item_title);
            this.mCover = (ImageView) view.findViewById(R.id.music_item_image);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
         arg types: [java.lang.String, android.widget.ImageView, ?, ?, int, int, com.xiaomi.mico.common.transformation.CropSquareTransformation]
         candidates:
          com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
          com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void */
        public void refreshUI(Music.Channel channel) {
            this.title.setText(channel.name);
            int i = 0;
            this.desc.setText(this.itemView.getContext().getString(R.string.song_quantity, Integer.valueOf(channel.songCount)));
            TextView textView = this.desc;
            if (!CollectionFragmentV2.this.isQQBuildPlaylist) {
                i = 8;
            }
            textView.setVisibility(i);
            MusicHelper.loadCover(channel.cover, this.mCover, (int) R.dimen.music_cover_size_43, (int) R.dimen.music_cover_size_43, MusicHelper.getChannelDefaultCover(channel), true, (Transformation) new CropSquareTransformation());
        }
    }
}
