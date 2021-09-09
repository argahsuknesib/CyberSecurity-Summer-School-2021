package com.xiaomi.mico.music.adapter;

import android.view.ViewGroup;
import com.xiaomi.mico.common.editorbar.ActionMenu;
import com.xiaomi.mico.common.editorbar.EditorBar;
import com.xiaomi.mico.common.recyclerview.adapter.EditableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.music.viewholder.DefaultViewHolder;
import java.io.Serializable;

public class DefaultAdapter {

    public static class Lovable<T> extends LovableAdapter<ItemClickableAdapter.ViewHolder, T> {
        public ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
            return new DefaultViewHolder.Lovable(viewGroup, this.onItemClickListener, this.lovable);
        }

        public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindItemViewHolder(viewHolder, i);
            ((DefaultViewHolder.Lovable) viewHolder).bindView((Serializable) getData(i));
        }
    }

    public static class Editable<T> extends EditableAdapter<ItemClickableAdapter.ViewHolder, T> {
        private int adapterType;
        private String playingMusicID;

        public Editable(EditorBar editorBar, ActionMenu.MenuCallback menuCallback) {
            super(editorBar, menuCallback);
        }

        public void setAdapterType(int i) {
            this.adapterType = i;
        }

        public ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
            if (this.adapterType == 2) {
                return new DefaultViewHolder.EditableStation(viewGroup, this.onItemClickListener);
            }
            return new DefaultViewHolder.Editable(viewGroup, this.onItemClickListener);
        }

        public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            super.onBindItemViewHolder(viewHolder, i);
            Serializable serializable = (Serializable) getData(i);
            if (this.adapterType == 2) {
                ((DefaultViewHolder.EditableStation) viewHolder).bindView(serializable);
            } else {
                ((DefaultViewHolder.Editable) viewHolder).bindView(serializable, this.playingMusicID);
            }
        }

        public void updatePlayingMusicID(String str) {
            if (!CommonUtils.equals(this.playingMusicID, str)) {
                this.playingMusicID = str;
                if (getDataSize() > 0) {
                    notifyDataSetChanged();
                }
            }
        }
    }
}
