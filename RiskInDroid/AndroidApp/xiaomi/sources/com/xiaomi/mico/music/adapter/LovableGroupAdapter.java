package com.xiaomi.mico.music.adapter;

import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter.ViewHolder;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class LovableGroupAdapter<VH extends ItemClickableAdapter.ViewHolder> extends GroupAdapter<VH> implements LovableDataSource {
    private Map<String, Boolean> favouriteMap = new HashMap();
    protected LovableAdapter.Lovable lovable;

    public void setLovable(LovableAdapter.Lovable lovable2) {
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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter.onBindViewHolder(com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter$ViewHolder, int):void
     arg types: [VH, int]
     candidates:
      com.xiaomi.mico.music.adapter.LovableGroupAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$O000OOo0, int):void
      com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$O000OOo0, int):void
      androidx.recyclerview.widget.RecyclerView.O000000o.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$O000OOo0, int):void
      com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter.onBindViewHolder(com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter$ViewHolder, int):void */
    public void onBindViewHolder(VH vh, int i) {
        super.onBindViewHolder((ItemClickableAdapter.ViewHolder) vh, i);
        if (vh instanceof LovableAdapter.ItemViewHolder) {
            Object item = getItem(i);
            boolean z = false;
            if (item instanceof Serializable) {
                String id = MusicHelper.getID((Serializable) item);
                Map<String, Boolean> map = this.favouriteMap;
                if (map != null && map.containsKey(id)) {
                    z = this.favouriteMap.get(id).booleanValue();
                }
                ((LovableAdapter.ItemViewHolder) vh).bindView(item, z);
                return;
            }
            ((LovableAdapter.ItemViewHolder) vh).bindView(item, false);
        }
    }
}
