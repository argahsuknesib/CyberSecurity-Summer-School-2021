package com.xiaomi.mico.music.patchwall;

import _m_j.gsy;
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
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.channel.ChannelManager;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.favourite.FavouriteActivity;
import com.xiaomi.mico.music.patchwall.MySongsFragment;
import com.xiaomi.mico.music.puchased.PurchasedRecordActivity;
import com.xiaomi.mico.music.recentplay.RecentPlayActivity;
import com.xiaomi.mico.music.viewholder.HeaderViewHolder;
import com.xiaomi.mico.setting.stereo.StereoMainActivity;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import rx.functions.Action1;

public class MySongsFragment extends BasePatchWallFragment implements ItemClickableAdapter.OnItemClickListener {
    public boolean isQQBuildPlaylist = true;
    public PersonalAdapter mPersonalAdapter;
    public List<Music.Channel> qqCollections;

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
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
            /* class com.xiaomi.mico.music.patchwall.MySongsFragment.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Channel>) ((List) obj));
            }

            public void onSuccess(List<Music.Channel> list) {
                MySongsFragment.this.qqCollections = list;
                for (Music.Channel channel : list) {
                    channel.isQQCollection = true;
                }
                if (!MySongsFragment.this.isQQBuildPlaylist) {
                    MySongsFragment.this.mPersonalAdapter.updateChannelList(list);
                }
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError;
                gsy.O00000Oo(12000, "12000.4.4", "remote qq songslist fail");
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
            /* class com.xiaomi.mico.music.patchwall.MySongsFragment.AnonymousClass2 */

            public void call(Long l) {
                Music.Channel channelById = ChannelManager.getInstance().getChannelById(l.longValue());
                channelById.isDefault = false;
                channelById.operable = true;
                if (channelById != null) {
                    MusicHelper.processChannel(MySongsFragment.this.getContext(), channelById, true);
                }
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.patchwall.MySongsFragment.AnonymousClass3 */

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
            addGroup(new ChannelGroup());
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
            if (i == 1) {
                return new PersonalViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_collection_header, viewGroup, false));
            }
            if (i == 2) {
                return new HeaderViewHolder.Comment(viewGroup, null, viewGroup.getContext().getString(R.string.music_channel));
            }
            if (i == 5) {
                return new QQmusicPlaylistSwitchViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_collection_list_header, viewGroup, false));
            } else if (i == 3) {
                return new QQMusicChannelViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_item_channel, viewGroup, false), this.onItemClickListener);
            } else if (i != 6) {
                return null;
            } else {
                return new EmptyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_channel_empty, viewGroup, false));
            }
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindViewHolder(viewHolder, i);
        }
    }

    static class PersonalGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        public String getID() {
            return "personal";
        }

        public int getItemViewType(int i) {
            return 1;
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        }

        private PersonalGroup() {
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

    class SettingGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        private List<Music.Channel> channelList;

        public String getID() {
            return "channel";
        }

        private SettingGroup() {
        }

        private void updateChannelList(List<Music.Channel> list) {
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
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$MySongsFragment$SettingGroup$h9SKkdQDBl2kUr8IJJFGGY9SYzQ */

                public final void onClick(View view) {
                    MySongsFragment.SettingGroup.this.lambda$onBindViewHolder$0$MySongsFragment$SettingGroup(view);
                }
            });
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$MySongsFragment$SettingGroup(View view) {
            MySongsFragment.this.getContext().startActivity(new Intent(MySongsFragment.this.getContext(), StereoMainActivity.class));
        }
    }

    static class PersonalViewHolder extends ItemClickableAdapter.ViewHolder {
        private Context context;

        private PersonalViewHolder(View view) {
            super(view, null);
            view.findViewById(R.id.music_personal_recent).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$MySongsFragment$PersonalViewHolder$VIBpOUwsFymBtbeLM24B83bvZfg */

                public final void onClick(View view) {
                    MySongsFragment.PersonalViewHolder.this.lambda$new$0$MySongsFragment$PersonalViewHolder(view);
                }
            });
            view.findViewById(R.id.music_personal_love).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$MySongsFragment$PersonalViewHolder$UI97iCQk1p32C6ezJuL5w4PkGho */

                public final void onClick(View view) {
                    MySongsFragment.PersonalViewHolder.this.lambda$new$1$MySongsFragment$PersonalViewHolder(view);
                }
            });
            view.findViewById(R.id.music_purchased).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$MySongsFragment$PersonalViewHolder$fNggtPTd0xEP9QBL2J8crYELPQA */

                public final void onClick(View view) {
                    MySongsFragment.PersonalViewHolder.this.lambda$new$2$MySongsFragment$PersonalViewHolder(view);
                }
            });
            this.context = view.getContext();
        }

        /* renamed from: onClick */
        public void lambda$new$2$MySongsFragment$PersonalViewHolder(View view) {
            int id = view.getId();
            if (id == R.id.music_personal_recent) {
                this.context.startActivity(new Intent(this.context, RecentPlayActivity.class));
            } else if (id == R.id.music_personal_love) {
                this.context.startActivity(new Intent(this.context, FavouriteActivity.class));
            } else if (id == R.id.music_purchased) {
                this.context.startActivity(new Intent(this.context, PurchasedRecordActivity.class));
            }
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
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$MySongsFragment$QQmusicPlaylistSwitchViewHolder$Cb28P2zdNCNLH5lXppFqkQ4vBc */

                public final void onClick(View view) {
                    MySongsFragment.QQmusicPlaylistSwitchViewHolder.this.lambda$new$0$MySongsFragment$QQmusicPlaylistSwitchViewHolder(view);
                }
            });
            this.collectPlayList = (TextView) view.findViewById(R.id.collection_playlist);
            this.collectPlayList.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$MySongsFragment$QQmusicPlaylistSwitchViewHolder$28hfaB2cG9AvCXACWTd56n3dQt4 */

                public final void onClick(View view) {
                    MySongsFragment.QQmusicPlaylistSwitchViewHolder.this.lambda$new$1$MySongsFragment$QQmusicPlaylistSwitchViewHolder(view);
                }
            });
            this.channelCount = (TextView) view.findViewById(R.id.music_collection_count);
            this.viewBuildNew = view.findViewById(R.id.music_build_new_channel);
            this.viewBuildNew.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$MySongsFragment$QQmusicPlaylistSwitchViewHolder$p26_aDp8jE1Jgbh3LRJTrH4N13I */

                public final void onClick(View view) {
                    MySongsFragment.QQmusicPlaylistSwitchViewHolder.this.lambda$new$2$MySongsFragment$QQmusicPlaylistSwitchViewHolder(view);
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
            this.viewMiChannelTitle.setVisibility(8);
        }

        private void selectedBuildPlayList() {
            this.collectPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_gray_lighter));
            this.buildPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_green_normal));
            MySongsFragment.this.isQQBuildPlaylist = true;
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
        public void lambda$new$2$MySongsFragment$QQmusicPlaylistSwitchViewHolder(View view) {
            int id = view.getId();
            if (id == R.id.build_playlist) {
                this.collectPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_gray_lighter));
                this.buildPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_green_normal));
                MySongsFragment.this.isQQBuildPlaylist = true;
                this.viewBuildNew.setVisibility(0);
                MySongsFragment.this.loadChannelList();
            } else if (id == R.id.collection_playlist) {
                this.buildPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_gray_lighter));
                this.collectPlayList.setTextColor(this.context.getResources().getColor(R.color.mj_color_green_normal));
                MySongsFragment.this.isQQBuildPlaylist = false;
                this.viewBuildNew.setVisibility(8);
                MySongsFragment.this.loadChannelList();
            } else if (id == R.id.music_build_new_channel) {
                MySongsFragment.this.createChannel();
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
            if (!MySongsFragment.this.isQQBuildPlaylist) {
                i = 8;
            }
            textView.setVisibility(i);
            MusicHelper.loadCover(channel.cover, this.mCover, (int) R.dimen.music_cover_size_43, (int) R.dimen.music_cover_size_43, MusicHelper.getChannelDefaultCover(channel), true, (Transformation) new CropSquareTransformation());
        }
    }
}
