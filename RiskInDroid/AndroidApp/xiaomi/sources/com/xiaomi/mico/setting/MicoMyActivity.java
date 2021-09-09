package com.xiaomi.mico.setting;

import _m_j.hxi;
import _m_j.jgc;
import _m_j.jgi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Transformation;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.adapter.MiCoinPriceAdapter;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.event.KKBoxAuthEvent;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.schema.handler.SkillSchemaHandler;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.channel.ChannelManager;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.favourite.FavouriteActivity;
import com.xiaomi.mico.music.patchwall.MySongsActivity;
import com.xiaomi.mico.music.puchased.PurchasedRecordActivity;
import com.xiaomi.mico.music.recentplay.RecentPlayActivity;
import com.xiaomi.mico.setting.MicoMyActivity;
import com.xiaomi.mico.setting.stereo.StereoMainActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.Action1;

public class MicoMyActivity extends MicoBaseActivity implements ItemClickableAdapter.OnItemClickListener {
    public boolean isQQBuildPlaylist = true;
    ImageView mBackImgView;
    public PersonalAdapter mPersonalAdapter;
    protected RecyclerView mRecyclerView;
    public float miCoinBalance = 0.0f;
    public List<Music.Channel> qqCollections;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.mico_my_activity);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        this.mBackImgView = (ImageView) findViewById(R.id.title_bar_left_icon);
        this.mBackImgView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$zFMeumsOKJ3XxH_lM1DzdfInqhU */

            public final void onClick(View view) {
                MicoMyActivity.this.lambda$onCreate$0$MicoMyActivity(view);
            }
        });
        this.mRecyclerView.setHasFixedSize(true);
        this.mPersonalAdapter = new PersonalAdapter();
        this.mPersonalAdapter.setOnItemClickListener(this);
        this.mRecyclerView.setAdapter(this.mPersonalAdapter);
        jgc.O000000o().O000000o(this);
        loadChannelList();
        hxi.O00000o0.O00000o0(1);
    }

    public /* synthetic */ void lambda$onCreate$0$MicoMyActivity(View view) {
        onBackPressed();
    }

    public void onDestroy() {
        super.onDestroy();
        jgc.O000000o().O00000o0(this);
    }

    public void loadChannelList() {
        getMiCoinBalance();
        if (this.isQQBuildPlaylist) {
            this.mPersonalAdapter.updateChannelList(ChannelManager.getInstance().getChannelList());
            ChannelManager.getInstance().getChannelList(null);
            return;
        }
        this.mPersonalAdapter.updateChannelList(this.qqCollections);
        ApiHelper.getQQCollectionsList(new ApiRequest.Listener<List<Music.Channel>>() {
            /* class com.xiaomi.mico.setting.MicoMyActivity.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Channel>) ((List) obj));
            }

            public void onSuccess(List<Music.Channel> list) {
                MicoMyActivity.this.qqCollections = list;
                for (Music.Channel channel : list) {
                    channel.isQQCollection = true;
                }
                if (!MicoMyActivity.this.isQQBuildPlaylist) {
                    MicoMyActivity.this.mPersonalAdapter.updateChannelList(list);
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
            /* class com.xiaomi.mico.setting.MicoMyActivity.AnonymousClass2 */

            public void call(Long l) {
                Music.Channel channelById = ChannelManager.getInstance().getChannelById(l.longValue());
                channelById.isDefault = false;
                channelById.operable = true;
                if (channelById != null) {
                    MusicHelper.processChannel(MicoMyActivity.this.getContext(), channelById, true);
                }
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.setting.MicoMyActivity.AnonymousClass3 */

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
            if (ApiConstants.isAreaCodeInCN()) {
                addGroup(new PersonalGroup());
                addGroup(new DividerGroup());
                addGroup(new SettingGroup());
            } else if (ApiConstants.isAreaCodeInTaiWan()) {
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
                ((TextView) viewHolder.itemView.findViewById(R.id.title)).setText((int) R.string.music_recent);
                viewHolder.itemView.findViewById(R.id.music_personal_recent).setBackgroundResource(R.drawable.mico_mine_item_play_record_bg);
            } else if (i == 1) {
                ((TextView) viewHolder.itemView.findViewById(R.id.title)).setText((int) R.string.music_my_favourite);
                viewHolder.itemView.findViewById(R.id.music_personal_recent).setBackgroundResource(R.drawable.mico_mine_item_my_fav_bg);
            } else if (i == 2) {
                ((TextView) viewHolder.itemView.findViewById(R.id.title)).setText((int) R.string.music_my_play_list);
                viewHolder.itemView.findViewById(R.id.music_personal_recent).setBackgroundResource(R.drawable.mico_mine_item_my_songlist_bg);
            }
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(i) {
                /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$PersonalGroup$EbbWJ98VfkicLNNd5Ri2fKLw44 */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    MicoMyActivity.PersonalGroup.this.lambda$onBindViewHolder$0$MicoMyActivity$PersonalGroup(this.f$1, view);
                }
            });
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$MicoMyActivity$PersonalGroup(int i, View view) {
            onClick(i);
        }

        private void onClick(int i) {
            Intent intent;
            Context appContext = CommonApplication.getAppContext();
            if (i == 0) {
                intent = new Intent(appContext, RecentPlayActivity.class);
                hxi.O00000o.O000000o("content_me_recently", (JSONObject) null);
            } else if (i == 1) {
                intent = new Intent(appContext, FavouriteActivity.class);
                hxi.O00000o.O000000o("content_me_collect", (JSONObject) null);
            } else if (i == 2) {
                intent = new Intent(appContext, MySongsActivity.class);
                hxi.O00000o.O000000o("content_me_sheet", (JSONObject) null);
            } else {
                intent = null;
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
        if (ApiConstants.isAreaCodeInCN()) {
            ApiHelper.getMiCoinBalance(new ApiRequest.Listener<Long>() {
                /* class com.xiaomi.mico.setting.MicoMyActivity.AnonymousClass4 */

                public void onFailure(ApiError apiError) {
                }

                public void onSuccess(Long l) {
                    if (MicoMyActivity.this.isValid()) {
                        MicoMyActivity.this.miCoinBalance = ((float) l.longValue()) / 100.0f;
                        MicoMyActivity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.mico.setting.MicoMyActivity.AnonymousClass4.AnonymousClass1 */

                            public void run() {
                                MicoMyActivity.this.mPersonalAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }
            });
        }
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
                settingItem.setText(MicoMyActivity.this.getContext().getText(R.string.mico_auth_account));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$SettingGroupTW$pX1A23Hzc35iPlyp0pYmtXlI7sA */

                    public final void onClick(View view) {
                        MicoMyActivity.SettingGroupTW.this.lambda$onBindViewHolder$0$MicoMyActivity$SettingGroupTW(view);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$MicoMyActivity$SettingGroupTW(View view) {
            hxi.O00000o.O000000o("content_me_account", (JSONObject) null);
            MicoMyActivity.this.getContext().startActivity(new Intent(MicoMyActivity.this.getContext(), MicoCpAccountActivity.class));
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
            return 5;
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
                settingItem.setText(MicoMyActivity.this.getContext().getText(R.string.mico_mine_recharge));
                settingItem.setContent("余额" + MiCoinPriceAdapter.PriceItem.getFormatMiCoin(MicoMyActivity.this.miCoinBalance));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$SettingGroup$A0h0mHhgr6gAXApFyW0knXIG_g */

                    public final void onClick(View view) {
                        MicoMyActivity.SettingGroup.this.lambda$onBindViewHolder$0$MicoMyActivity$SettingGroup(view);
                    }
                });
            } else if (i == 1) {
                settingItem.setText(MicoMyActivity.this.getContext().getText(R.string.mico_mine_buy_list));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$SettingGroup$JL3tebs_ZTGjkT6vbCui8qAu4A */

                    public final void onClick(View view) {
                        MicoMyActivity.SettingGroup.this.lambda$onBindViewHolder$1$MicoMyActivity$SettingGroup(view);
                    }
                });
            } else if (i == 2) {
                settingItem.setText(MicoMyActivity.this.getContext().getText(R.string.mico_auth_account));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$SettingGroup$ofj1ebA1b8O0F_fVyt4Cr_nwobM */

                    public final void onClick(View view) {
                        MicoMyActivity.SettingGroup.this.lambda$onBindViewHolder$2$MicoMyActivity$SettingGroup(view);
                    }
                });
            } else if (i == 3) {
                settingItem.setText(MicoMyActivity.this.getContext().getText(R.string.mico_mine_music_setting));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$SettingGroup$a4TSs5BwnLVlwx6J9FLTCmULEP4 */

                    public final void onClick(View view) {
                        MicoMyActivity.SettingGroup.this.lambda$onBindViewHolder$3$MicoMyActivity$SettingGroup(view);
                    }
                });
            } else if (i == 4) {
                settingItem.setText(MicoMyActivity.this.getContext().getText(R.string.mico_mine_stereo_setting));
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$SettingGroup$ZfXc9GJeJdVZmFtxx_QKlx99i0g */

                    public final void onClick(View view) {
                        MicoMyActivity.SettingGroup.this.lambda$onBindViewHolder$4$MicoMyActivity$SettingGroup(view);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$MicoMyActivity$SettingGroup(View view) {
            hxi.O00000o.O000000o("content_me_recharge", (JSONObject) null);
            MicoMyActivity.this.getContext().startActivity(new Intent(MicoMyActivity.this.getContext(), RechargeMiCoinActivity.class));
        }

        public /* synthetic */ void lambda$onBindViewHolder$1$MicoMyActivity$SettingGroup(View view) {
            hxi.O00000o.O000000o("content_me_purchased", (JSONObject) null);
            MicoMyActivity.this.getContext().startActivity(new Intent(MicoMyActivity.this.getContext(), PurchasedRecordActivity.class));
        }

        public /* synthetic */ void lambda$onBindViewHolder$2$MicoMyActivity$SettingGroup(View view) {
            hxi.O00000o.O000000o("content_me_account", (JSONObject) null);
            MicoMyActivity.this.getContext().startActivity(new Intent(MicoMyActivity.this.getContext(), MicoCpAccountActivity.class));
        }

        public /* synthetic */ void lambda$onBindViewHolder$3$MicoMyActivity$SettingGroup(View view) {
            int i;
            AccountProfile.MusicSuorce musicSource = AccountProfile.current().getMusicSource();
            if (AccountProfile.MusicSuorce.MI.getSource().equals(musicSource.getSource())) {
                i = 2;
            } else {
                i = AccountProfile.MusicSuorce.QQ.getSource().equals(musicSource.getSource()) ? 1 : 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", i);
                hxi.O00000o.O000000o("content_me_music set", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MusicSourceSettingPopupView2.showAlert(MicoMyActivity.this.getContext());
        }

        public /* synthetic */ void lambda$onBindViewHolder$4$MicoMyActivity$SettingGroup(View view) {
            hxi.O00000o.O000000o("content_me_stereo", (JSONObject) null);
            MicoMyActivity.this.getContext().startActivity(new Intent(MicoMyActivity.this.getContext(), StereoMainActivity.class));
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
                /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$QQmusicPlaylistSwitchViewHolder$ls81vq_XdmtJiqM_E_ITqmtum1U */

                public final void onClick(View view) {
                    MicoMyActivity.QQmusicPlaylistSwitchViewHolder.this.lambda$new$0$MicoMyActivity$QQmusicPlaylistSwitchViewHolder(view);
                }
            });
            this.collectPlayList = (TextView) view.findViewById(R.id.collection_playlist);
            this.collectPlayList.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$QQmusicPlaylistSwitchViewHolder$ENkEURHTc7pcluAeSadJpuOIqnM */

                public final void onClick(View view) {
                    MicoMyActivity.QQmusicPlaylistSwitchViewHolder.this.lambda$new$1$MicoMyActivity$QQmusicPlaylistSwitchViewHolder(view);
                }
            });
            this.channelCount = (TextView) view.findViewById(R.id.music_collection_count);
            this.viewBuildNew = view.findViewById(R.id.music_build_new_channel);
            this.viewBuildNew.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.$$Lambda$MicoMyActivity$QQmusicPlaylistSwitchViewHolder$eHCuqL2UZLN5_9JCQpMHTRYs_H4 */

                public final void onClick(View view) {
                    MicoMyActivity.QQmusicPlaylistSwitchViewHolder.this.lambda$new$2$MicoMyActivity$QQmusicPlaylistSwitchViewHolder(view);
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
            MicoMyActivity.this.isQQBuildPlaylist = true;
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
        public void lambda$new$2$MicoMyActivity$QQmusicPlaylistSwitchViewHolder(View view) {
            int id = view.getId();
            if (id == R.id.build_playlist) {
                this.collectPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_gray_lighter));
                this.buildPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_black));
                this.buildPlayList.setTextSize(2, 15.0f);
                this.collectPlayList.setTextSize(2, 13.0f);
                MicoMyActivity.this.isQQBuildPlaylist = true;
                this.viewBuildNew.setVisibility(0);
                MicoMyActivity.this.loadChannelList();
            } else if (id == R.id.build_playlist) {
                this.buildPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_gray_lighter));
                this.collectPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_black));
                this.collectPlayList.setTextSize(2, 15.0f);
                this.buildPlayList.setTextSize(2, 13.0f);
                MicoMyActivity.this.isQQBuildPlaylist = false;
                this.viewBuildNew.setVisibility(8);
                MicoMyActivity.this.loadChannelList();
            } else if (id == R.id.music_build_new_channel) {
                MicoMyActivity.this.createChannel();
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
            if (!MicoMyActivity.this.isQQBuildPlaylist) {
                i = 8;
            }
            textView.setVisibility(i);
            MusicHelper.loadCover(channel.cover, this.mCover, (int) R.dimen.music_cover_size_43, (int) R.dimen.music_cover_size_43, MusicHelper.getChannelDefaultCover(channel), true, (Transformation) new CropSquareTransformation());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1102) {
            KKBoxAuthEvent completeEvent = KKBoxAuthEvent.completeEvent(intent.getData());
            if (completeEvent.success) {
                acquireMembership();
            }
            jgc.O000000o().O00000o(completeEvent);
        }
    }

    private static void acquireMembership() {
        String currentMicoID = MicoManager.getInstance().getCurrentMicoID();
        String currentMicoSN = MicoManager.getInstance().getCurrentMicoSN();
        if (!TextUtils.isEmpty(currentMicoID)) {
            ApiHelper.kkboxSalesPromotion(currentMicoID, currentMicoSN, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.setting.MicoMyActivity.AnonymousClass5 */

                public final void onFailure(ApiError apiError) {
                }

                public final void onSuccess(String str) {
                    if (str != null && !TextUtils.isEmpty(str)) {
                        try {
                            String optString = new JSONObject(str).optString("url");
                            if (!TextUtils.isEmpty(optString)) {
                                SchemaManager.handleSchema(MicoApplication.getInstance().getGlobalContext(), SkillSchemaHandler.buildWebSchema("", optString, false));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
