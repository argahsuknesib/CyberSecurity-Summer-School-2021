package com.xiaomi.mico.common.recyclerview.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LEEAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private int mCurrentView = 100;
    private View mEmptyView;
    private View mErrorView;
    private View mLoadingView;
    private final RecyclerView.O000000o<RecyclerView.O000OOo0> mWrappedAdapter;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CurrentView {
    }

    /* access modifiers changed from: protected */
    public void onBindEmptyViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
    }

    /* access modifiers changed from: protected */
    public void onBindErrorViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
    }

    /* access modifiers changed from: protected */
    public void onBindLoadingViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
    }

    public LEEAdapter(RecyclerView.O000000o o000000o, View view, View view2, View view3) {
        this.mWrappedAdapter = o000000o;
        this.mLoadingView = view;
        this.mEmptyView = view2;
        this.mErrorView = view3;
    }

    public int getCurrentView() {
        return this.mCurrentView;
    }

    public void setCurrentView(int i) {
        if (this.mCurrentView != i) {
            this.mCurrentView = i;
            this.mWrappedAdapter.notifyDataSetChanged();
        }
    }

    public RecyclerView.O000000o<RecyclerView.O000OOo0> getWrappedAdapter() {
        return this.mWrappedAdapter;
    }

    public int getItemCount() {
        switch (this.mCurrentView) {
            case 100:
                return this.mWrappedAdapter.getItemCount();
            case 101:
            case 102:
            case 103:
                return 1;
            default:
                throw new IllegalArgumentException("No View State found matching currentView: " + this.mCurrentView);
        }
    }

    public int getItemViewType(int i) {
        switch (this.mCurrentView) {
            case 100:
                return this.mWrappedAdapter.getItemViewType(i);
            case 101:
                return 201;
            case 102:
                return 202;
            case 103:
                return 203;
            default:
                throw new IllegalArgumentException("No View State found matching currentView: " + this.mCurrentView);
        }
    }

    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (this.mCurrentView) {
            case 100:
                return this.mWrappedAdapter.onCreateViewHolder(viewGroup, i);
            case 101:
                return new RecyclerView.O000OOo0(this.mLoadingView) {
                    /* class com.xiaomi.mico.common.recyclerview.adapter.LEEAdapter.AnonymousClass1 */
                };
            case 102:
                return new RecyclerView.O000OOo0(this.mEmptyView) {
                    /* class com.xiaomi.mico.common.recyclerview.adapter.LEEAdapter.AnonymousClass2 */
                };
            case 103:
                return new RecyclerView.O000OOo0(this.mErrorView) {
                    /* class com.xiaomi.mico.common.recyclerview.adapter.LEEAdapter.AnonymousClass3 */
                };
            default:
                throw new IllegalArgumentException("No View State found matching currentView: " + this.mCurrentView);
        }
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        switch (this.mCurrentView) {
            case 100:
                this.mWrappedAdapter.onBindViewHolder(o000OOo0, i);
                return;
            case 101:
                onBindLoadingViewHolder(o000OOo0, i);
                return;
            case 102:
                onBindEmptyViewHolder(o000OOo0, i);
                return;
            case 103:
                onBindErrorViewHolder(o000OOo0, i);
                return;
            default:
                throw new IllegalArgumentException("No View State found matching currentView: " + this.mCurrentView);
        }
    }

    public void setHasStableIds(boolean z) {
        if (this.mCurrentView == 100) {
            this.mWrappedAdapter.setHasStableIds(z);
        } else {
            super.setHasStableIds(z);
        }
    }

    public long getItemId(int i) {
        if (this.mCurrentView == 100) {
            return this.mWrappedAdapter.getItemId(i);
        }
        return super.getItemId(i);
    }

    public void onViewRecycled(RecyclerView.O000OOo0 o000OOo0) {
        if (this.mCurrentView == 100) {
            this.mWrappedAdapter.onViewRecycled(o000OOo0);
        } else {
            super.onViewRecycled(o000OOo0);
        }
    }

    public boolean onFailedToRecycleView(RecyclerView.O000OOo0 o000OOo0) {
        if (this.mCurrentView == 100) {
            return this.mWrappedAdapter.onFailedToRecycleView(o000OOo0);
        }
        return super.onFailedToRecycleView(o000OOo0);
    }

    public void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
        if (this.mCurrentView == 100) {
            this.mWrappedAdapter.onViewAttachedToWindow(o000OOo0);
        } else {
            super.onViewAttachedToWindow(o000OOo0);
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
        if (this.mCurrentView == 100) {
            this.mWrappedAdapter.onViewDetachedFromWindow(o000OOo0);
        } else {
            super.onViewDetachedFromWindow(o000OOo0);
        }
    }

    public void registerAdapterDataObserver(RecyclerView.O00000o0 o00000o0) {
        this.mWrappedAdapter.registerAdapterDataObserver(o00000o0);
    }

    public void unregisterAdapterDataObserver(RecyclerView.O00000o0 o00000o0) {
        this.mWrappedAdapter.unregisterAdapterDataObserver(o00000o0);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.mWrappedAdapter.onAttachedToRecyclerView(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mWrappedAdapter.onDetachedFromRecyclerView(recyclerView);
    }
}
