package com.xiaomi.mico.music.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.editorbar.ActionMenu;
import com.xiaomi.mico.common.editorbar.EditorBar;
import com.xiaomi.mico.common.recyclerview.adapter.EditableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.mico.music.viewholder.HeaderViewHolder;
import com.xiaomi.mico.music.viewholder.SongViewHolder;
import com.xiaomi.smarthome.R;
import java.io.Serializable;

public class SongAdapter {

    public static class Lovable<T> extends LovableAdapter<ItemClickableAdapter.ViewHolder, T> {
        private final int headerCount;
        private Remote.Response.Directive playingDirective;
        private String playingMusicID;
        private int stableDataSize;
        private final boolean transparent;

        public boolean isHeader(int i) {
            return i == 1;
        }

        public boolean needDecorator(int i) {
            return (i == 3 || i == 2 || i == 4) ? false : true;
        }

        public Lovable(boolean z) {
            this(z, false);
        }

        public Lovable(boolean z, boolean z2) {
            this.headerCount = z ? 1 : 0;
            this.transparent = z2;
        }

        public void setStableDataSize(int i) {
            if (this.stableDataSize != i) {
                this.stableDataSize = i;
                if (this.headerCount > 0 && getItemCount() > 0) {
                    notifyItemChanged(0);
                }
            }
        }

        public void resetPlaying() {
            this.playingMusicID = null;
            this.playingDirective = null;
            if (getDataSize() > 0) {
                notifyDataSetChanged();
            }
        }

        public void updatePlayingMusicID(String str) {
            updatePlayingMusicID(str, true);
        }

        public String getPlayingMusicID() {
            return this.playingMusicID;
        }

        public void updatePlayingMusicID(String str, boolean z) {
            if (!CommonUtils.equals(this.playingMusicID, str)) {
                this.playingDirective = null;
                this.playingMusicID = str;
                if (z && getDataSize() > 0) {
                    notifyDataSetChanged();
                }
            }
        }

        public void updatePlayingDirective(Remote.Response.Directive directive) {
            if (!CommonUtils.equals(this.playingDirective, directive)) {
                this.playingMusicID = null;
                this.playingDirective = directive;
                if (getDataSize() > 0) {
                    notifyDataSetChanged();
                }
            }
        }

        public int getDataIndex(int i) {
            return i - this.headerCount;
        }

        public int getItemCount() {
            if (this.dataList == null || this.dataList.isEmpty()) {
                return 0;
            }
            return this.dataList.size() + this.headerCount;
        }

        public int getItemViewType(int i) {
            if (i < this.headerCount) {
                return 1;
            }
            return getDataType();
        }

        public final ItemClickableAdapter.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
            return new HeaderViewHolder.PlayAll(viewGroup, this.onItemClickListener);
        }

        public final ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
            if (i == 2) {
                return new SongViewHolder.LovableStation(viewGroup, this.transparent, this.onItemClickListener, this.lovable);
            }
            if (i == 3) {
                return new SongViewHolder.StationCategoryViewHolder(viewGroup, this.onItemClickListener, this.lovable);
            }
            if (i == 4) {
                return new SongViewHolder.CollectStation(viewGroup, this.transparent, this.onItemClickListener, this.lovable);
            }
            return new SongViewHolder.Lovable(viewGroup, this.transparent, this.onItemClickListener, this.lovable);
        }

        public final void onBindHeaderViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindHeaderViewHolder(viewHolder, i);
            int dataSize = getDataSize();
            int i2 = this.stableDataSize;
            if (i2 > dataSize) {
                dataSize = i2;
            }
            ((HeaderViewHolder.PlayAll) viewHolder).bindView(viewHolder.itemView.getResources(), dataSize);
        }

        public final void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindItemViewHolder(viewHolder, i);
            Object data = getData(i);
            if (data instanceof Remote.Response.Directive) {
                ((SongViewHolder.Lovable) viewHolder).bindView((Remote.Response.Directive) data, this.playingDirective, i);
            } else if (getDataType() == 4) {
                ((SongViewHolder.CollectStation) viewHolder).bindView((Serializable) data, this.playingMusicID);
            } else if (getDataType() == 2) {
                ((SongViewHolder.LovableStation) viewHolder).bindView((Serializable) data, this.playingMusicID, true);
            } else if (getDataType() == 3) {
                ((SongViewHolder.StationCategoryViewHolder) viewHolder).bindView((Serializable) data);
            } else {
                ((SongViewHolder.Lovable) viewHolder).bindView((Serializable) data, this.playingMusicID, i);
            }
        }
    }

    public static class Editable<T> extends EditableAdapter<ItemClickableAdapter.ViewHolder, T> {
        private final int headerCount;
        protected LovableAdapter.Lovable lovable;
        private String playingMusicID;
        private int stableDataSize;

        public boolean isHeader(int i) {
            return i == 1;
        }

        public boolean needDecorator(int i) {
            return (i == 2 || i == 4 || i == 3) ? false : true;
        }

        public Editable(EditorBar editorBar, ActionMenu.MenuCallback menuCallback, boolean z) {
            super(editorBar, menuCallback);
            this.headerCount = z ? 1 : 0;
        }

        public void setLovable(LovableAdapter.Lovable lovable2) {
            this.lovable = lovable2;
        }

        public void setStableDataSize(int i) {
            if (this.stableDataSize != i) {
                this.stableDataSize = i;
                if (this.headerCount > 0 && getItemCount() > 0) {
                    notifyItemChanged(0);
                }
            }
        }

        public void decreaseStableDataSize(int i) {
            this.stableDataSize -= i;
        }

        public void updatePlayingMusicID(String str) {
            if (!CommonUtils.equals(this.playingMusicID, str)) {
                this.playingMusicID = str;
                if (getDataSize() > 0) {
                    notifyDataSetChanged();
                }
            }
        }

        public String getPlayingMusicID() {
            return this.playingMusicID;
        }

        public int getDataIndex(int i) {
            return i - this.headerCount;
        }

        public int getItemCount() {
            if (this.dataList == null || this.dataList.isEmpty()) {
                return 0;
            }
            return this.dataList.size() + this.headerCount;
        }

        public int getItemViewType(int i) {
            if (i < this.headerCount) {
                return 1;
            }
            if (getData(i) instanceof Music.Station) {
                return 2;
            }
            return super.getItemViewType(i);
        }

        public final ItemClickableAdapter.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
            return new HeaderViewHolder.PlayAll(viewGroup, this.onItemClickListener);
        }

        public final ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
            if (i == 2) {
                return new SongViewHolder.EditableStation(viewGroup, this.onItemClickListener, this.lovable);
            }
            return new SongViewHolder.Editable(viewGroup, this.onItemClickListener, this.lovable);
        }

        public final void onBindHeaderViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindHeaderViewHolder(viewHolder, i);
            int dataSize = getDataSize();
            int i2 = this.stableDataSize;
            if (i2 > dataSize) {
                dataSize = i2;
            }
            ((HeaderViewHolder.PlayAll) viewHolder).bindView(viewHolder.itemView.getResources(), dataSize);
        }

        public final void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindItemViewHolder(viewHolder, i);
            Serializable serializable = (Serializable) getData(i);
            if (serializable instanceof Music.Station) {
                ((SongViewHolder.EditableStation) viewHolder).bindView(serializable, this.playingMusicID, i);
            } else {
                ((SongViewHolder.Editable) viewHolder).bindView(serializable, this.playingMusicID, i);
            }
        }
    }

    public static class PlayerListAdapter<T> extends SingleAdapter<ItemClickableAdapter.ViewHolder, T> {
        private final int headerCount;
        private Remote.Response.Directive playingDirective;
        private String playingMusicID;
        private int stableDataSize;

        public boolean isHeader(int i) {
            return i == 1;
        }

        public PlayerListAdapter(boolean z) {
            this(z, false);
        }

        PlayerListAdapter(boolean z, boolean z2) {
            this.headerCount = z ? 1 : 0;
        }

        public void setStableDataSize(int i) {
            if (this.stableDataSize != i) {
                this.stableDataSize = i;
                if (this.headerCount > 0 && getItemCount() > 0) {
                    notifyItemChanged(0);
                }
            }
        }

        public void resetPlaying() {
            this.playingMusicID = null;
            this.playingDirective = null;
            if (getDataSize() > 0) {
                notifyDataSetChanged();
            }
        }

        public void updatePlayingMusicID(String str) {
            updatePlayingMusicID(str, true);
        }

        public void updatePlayingMusicID(String str, boolean z) {
            if (!CommonUtils.equals(this.playingMusicID, str)) {
                this.playingDirective = null;
                this.playingMusicID = str;
                if (z && getDataSize() > 0) {
                    notifyDataSetChanged();
                }
            }
        }

        public void updatePlayingDirective(Remote.Response.Directive directive) {
            if (!CommonUtils.equals(this.playingDirective, directive)) {
                this.playingMusicID = null;
                this.playingDirective = directive;
                if (getDataSize() > 0) {
                    notifyDataSetChanged();
                }
            }
        }

        public int getDataIndex(int i) {
            return i - this.headerCount;
        }

        public int getItemCount() {
            if (this.dataList == null || this.dataList.isEmpty()) {
                return 0;
            }
            return this.dataList.size() + this.headerCount;
        }

        public int getItemViewType(int i) {
            if (i < this.headerCount) {
                return 1;
            }
            return super.getItemViewType(i);
        }

        public final ItemClickableAdapter.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
            return new HeaderViewHolder.PlayAll(viewGroup, this.onItemClickListener);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
            return new SongViewHolder.PlayerListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_player_item_song, viewGroup, false), this.onItemClickListener);
        }

        public final void onBindHeaderViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindHeaderViewHolder(viewHolder, i);
            int dataSize = getDataSize();
            int i2 = this.stableDataSize;
            if (i2 > dataSize) {
                dataSize = i2;
            }
            ((HeaderViewHolder.PlayAll) viewHolder).bindView(viewHolder.itemView.getResources(), dataSize);
        }

        public final void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindItemViewHolder(viewHolder, i);
            Object data = getData(i);
            if (data instanceof Remote.Response.Directive) {
                ((SongViewHolder.PlayerListViewHolder) viewHolder).bindView((Remote.Response.Directive) data, this.playingDirective, i);
            } else {
                ((SongViewHolder.PlayerListViewHolder) viewHolder).bindView((Serializable) data, this.playingMusicID, i);
            }
        }
    }
}
