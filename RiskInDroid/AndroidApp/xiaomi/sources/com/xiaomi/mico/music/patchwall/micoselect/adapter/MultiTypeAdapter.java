package com.xiaomi.mico.music.patchwall.micoselect.adapter;

import _m_j.gsy;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.common.widget.RatioBanner;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ItemViewBinder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiTypeAdapter<T, Binder extends ItemViewBinder> extends RecyclerView.O000000o<RecyclerView.O000OOo0> implements RatioBanner.OnStateChange {
    private List<Binder> mBinders = new ArrayList();
    private boolean mIsActivate;
    private List<T> mItems = new ArrayList();
    private List<T> mOriginalItems;
    private HashMap<Object, Integer> mTypeIndexMap = new HashMap<>();
    private TypeProvider mTypeProvider;

    public MultiTypeAdapter(TypeProvider<T> typeProvider) {
        this.mTypeProvider = typeProvider;
    }

    public void register(Object obj, Binder binder) {
        this.mTypeIndexMap.put(obj, Integer.valueOf(this.mBinders.size()));
        this.mBinders.add(binder);
        binder.adapter = this;
    }

    public void registerAll(HashMap<Object, Binder> hashMap) {
        for (Map.Entry next : hashMap.entrySet()) {
            register(next.getKey(), (ItemViewBinder) next.getValue());
        }
    }

    public boolean isSupportType(Object obj) {
        return this.mTypeIndexMap.containsKey(obj);
    }

    public void updateData(List<T> list) {
        if (list != null && list != this.mOriginalItems) {
            this.mOriginalItems = list;
            this.mItems = filterSupportType(list);
            notifyDataSetChanged();
        }
    }

    private List<T> filterSupportType(List<T> list) {
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (isSupportType(this.mTypeProvider.getType(next))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public T getItem(int i) {
        List<T> list = this.mItems;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.mItems.get(i);
    }

    public int getItemViewType(int i) {
        return this.mTypeIndexMap.get(this.mTypeProvider.getType(this.mItems.get(i))).intValue();
    }

    public int getItemCount() {
        return this.mItems.size();
    }

    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        gsy.O00000Oo("PatchWall", "indexViewType".concat(String.valueOf(i)));
        RecyclerView.O000OOo0 onCreateViewHolder = ((ItemViewBinder) this.mBinders.get(i)).onCreateViewHolder(from, viewGroup);
        if (onCreateViewHolder.itemView.getParent() != null) {
            ((ViewGroup) onCreateViewHolder.itemView.getParent()).removeView(onCreateViewHolder.itemView);
        }
        return onCreateViewHolder;
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        onBindViewHolder(o000OOo0, i, Collections.emptyList());
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List<Object> list) {
        T t = this.mItems.get(i);
        ((ItemViewBinder) this.mBinders.get(this.mTypeIndexMap.get(this.mTypeProvider.getType(t)).intValue())).onBindViewHolder(o000OOo0, t, list, i);
    }

    public long getItemId(int i) {
        T t = this.mItems.get(i);
        return ((ItemViewBinder) this.mBinders.get(this.mTypeIndexMap.get(this.mTypeProvider.getType(t)).intValue())).getItemId(t);
    }

    public void onViewRecycled(RecyclerView.O000OOo0 o000OOo0) {
        getRawViewBinder(o000OOo0).onViewRecycled(o000OOo0);
    }

    public boolean onFailedToRecycleView(RecyclerView.O000OOo0 o000OOo0) {
        return getRawViewBinder(o000OOo0).onFailedToRecycleView(o000OOo0);
    }

    public void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
        getRawViewBinder(o000OOo0).onViewAttachedToWindow(o000OOo0);
    }

    public void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
        getRawViewBinder(o000OOo0).onViewDetachedFromWindow(o000OOo0);
    }

    private ItemViewBinder getRawViewBinder(RecyclerView.O000OOo0 o000OOo0) {
        return (ItemViewBinder) this.mBinders.get(o000OOo0.getItemViewType());
    }

    public void onActivate() {
        this.mIsActivate = true;
        notifyDataSetChanged();
    }

    public void onDeactivate() {
        this.mIsActivate = false;
        notifyDataSetChanged();
    }

    public boolean isActivate() {
        return this.mIsActivate;
    }
}
