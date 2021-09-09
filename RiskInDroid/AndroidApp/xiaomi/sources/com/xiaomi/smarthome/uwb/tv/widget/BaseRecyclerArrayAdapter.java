package com.xiaomi.smarthome.uwb.tv.widget;

import _m_j.gsy;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseRecyclerArrayAdapter<T> extends RecyclerView.O000000o<BaseViewHolder> {
    private static final String TAG = "com.xiaomi.smarthome.uwb.tv.widget.BaseRecyclerArrayAdapter";
    protected final Object mLock = new Object();
    protected List<T> mObjects;

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public BaseRecyclerArrayAdapter() {
        init(new ArrayList());
    }

    public BaseRecyclerArrayAdapter(List<T> list) {
        init(list);
    }

    private void init(List<T> list) {
        this.mObjects = list;
    }

    public void add(T t) {
        synchronized (this.mLock) {
            this.mObjects.add(t);
        }
        notifyItemInserted(getItemCount() - 1);
    }

    public void addAll(Collection<? extends T> collection) {
        int i;
        if (collection != null && collection.size() != 0) {
            synchronized (this.mLock) {
                this.mObjects.addAll(collection);
            }
            if (collection == null) {
                i = 0;
            } else {
                i = collection.size();
            }
            String str = TAG;
            gsy.O000000o(3, str, "addAll: " + (getItemCount() - i) + " dataCount: " + i);
            notifyItemRangeInserted(getItemCount() - i, i);
        }
    }

    public void insert(T t, int i) {
        synchronized (this.mLock) {
            this.mObjects.add(i, t);
        }
        notifyItemInserted(i);
    }

    public void insertAll(Collection<? extends T> collection, int i) {
        int i2;
        if (collection != null && collection.size() != 0) {
            synchronized (this.mLock) {
                this.mObjects.addAll(i, collection);
            }
            if (collection == null) {
                i2 = 0;
            } else {
                i2 = collection.size();
            }
            String str = TAG;
            gsy.O000000o(3, str, "insertAll: " + i + " dataCount: " + i2);
            notifyItemRangeInserted(i, i2);
        }
    }

    public void remove(T t) {
        int indexOf = this.mObjects.indexOf(t);
        synchronized (this.mLock) {
            if (this.mObjects.remove(t)) {
                notifyItemRemoved(indexOf);
            }
        }
    }

    public void remove(int i) {
        if (i >= 0 && i < getItemCount()) {
            synchronized (this.mLock) {
                this.mObjects.remove(i);
            }
            notifyItemRemoved(i);
        }
    }

    public void removeAll() {
        synchronized (this.mLock) {
            this.mObjects.clear();
        }
        notifyDataSetChanged();
    }

    public void setData(Collection<? extends T> collection) {
        synchronized (this.mLock) {
            this.mObjects.clear();
            this.mObjects.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.mObjects.size();
    }

    public final void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.itemView.setId(i);
        OnBindViewHolder(baseViewHolder, i);
    }

    public void OnBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.setData(getItem(i));
    }

    public List<T> getAllData() {
        return new ArrayList(this.mObjects);
    }

    public T getItem(int i) {
        if (i >= this.mObjects.size() || i < 0) {
            return null;
        }
        return this.mObjects.get(i);
    }

    public int indexOfItem(Object obj) {
        return this.mObjects.indexOf(obj);
    }
}
