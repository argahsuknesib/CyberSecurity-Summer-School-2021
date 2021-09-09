package com.xiaomi.mico.music.adapter;

import android.view.View;
import android.widget.ImageView;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter.ViewHolder;
import com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import rx.functions.Action1;

public abstract class LovableAdapter<VH extends ItemClickableAdapter.ViewHolder, T> extends SingleAdapter<VH, T> implements LovableDataSource {
    private Map<String, Boolean> favouriteMap = new HashMap();
    protected Lovable lovable;

    public interface Lovable {
        void onLove(View view, Serializable serializable);
    }

    public void setLovable(Lovable lovable2) {
        this.lovable = lovable2;
    }

    public void updateFavouriteMap(Map<String, Boolean> map) {
        this.favouriteMap.clear();
        addFavouriteMap(map);
    }

    public void addFavouriteMap(Map<String, Boolean> map) {
        this.favouriteMap.putAll(map);
        notifyDataSetChanged();
    }

    public void updateFavouriteData(String str, boolean z) {
        this.favouriteMap.put(str, Boolean.valueOf(z));
    }

    public void onBindItemViewHolder(VH vh, int i) {
        super.onBindItemViewHolder(vh, i);
        Object data = getData(i);
        boolean z = false;
        if (data instanceof Serializable) {
            String id = MusicHelper.getID((Serializable) data);
            Map<String, Boolean> map = this.favouriteMap;
            if (map != null && map.containsKey(id)) {
                z = this.favouriteMap.get(id).booleanValue();
            }
            ((ItemViewHolder) vh).bindView(data, z);
            return;
        }
        ((ItemViewHolder) vh).bindView(data, false);
    }

    public static class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        ImageView love;

        public ItemViewHolder(View view, ItemClickableAdapter.OnItemClickListener onItemClickListener, final Lovable lovable) {
            super(view, onItemClickListener);
            this.love = (ImageView) view.findViewById(R.id.music_item_love);
            ImageView imageView = this.love;
            if (imageView == null) {
                return;
            }
            if (lovable != null) {
                RxUtil.debounceClick(imageView, new Action1<Void>() {
                    /* class com.xiaomi.mico.music.adapter.LovableAdapter.ItemViewHolder.AnonymousClass1 */

                    public void call(Void voidR) {
                        lovable.onLove(ItemViewHolder.this.love, (Serializable) ItemViewHolder.this.love.getTag());
                    }
                });
            } else {
                imageView.setVisibility(8);
            }
        }

        /* access modifiers changed from: protected */
        public void bindView(Object obj, boolean z) {
            ImageView imageView = this.love;
            if (imageView != null && imageView.getVisibility() != 8) {
                if (obj instanceof Serializable) {
                    this.love.setTag(obj);
                    if (MusicHelper.isLegal((Serializable) obj)) {
                        this.love.setEnabled(true);
                        this.love.setSelected(z);
                        return;
                    }
                    this.love.setEnabled(false);
                    this.love.setSelected(false);
                    return;
                }
                this.love.setEnabled(false);
                this.love.setSelected(false);
            }
        }
    }
}
