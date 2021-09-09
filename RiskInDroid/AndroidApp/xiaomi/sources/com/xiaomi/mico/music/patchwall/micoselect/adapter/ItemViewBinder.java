package com.xiaomi.mico.music.patchwall.micoselect.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.O000OOo0;
import java.util.List;

public abstract class ItemViewBinder<T, VH extends RecyclerView.O000OOo0> {
    MultiTypeAdapter adapter;

    /* access modifiers changed from: protected */
    public long getItemId(T t) {
        return -1;
    }

    /* access modifiers changed from: protected */
    public abstract void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, Object obj, int i);

    /* access modifiers changed from: protected */
    public abstract VH onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public boolean onFailedToRecycleView(VH vh) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
    }

    /* access modifiers changed from: protected */
    public void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
    }

    /* access modifiers changed from: protected */
    public void onViewRecycled(VH vh) {
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(VH vh, T t, List<Object> list, int i) {
        onBindViewHolder(vh, t, i);
    }

    /* access modifiers changed from: protected */
    public final int getPosition(RecyclerView.O000OOo0 o000OOo0) {
        return o000OOo0.getAdapterPosition();
    }

    /* access modifiers changed from: protected */
    public final MultiTypeAdapter getAdapter() {
        MultiTypeAdapter multiTypeAdapter = this.adapter;
        if (multiTypeAdapter != null) {
            return multiTypeAdapter;
        }
        throw new IllegalStateException("ItemViewBinder " + this + " not attached to MultiTypeAdapter. You should not call the method before registering the binder.");
    }
}
