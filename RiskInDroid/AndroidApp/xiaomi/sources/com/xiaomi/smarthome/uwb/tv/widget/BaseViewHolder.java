package com.xiaomi.smarthome.uwb.tv.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;

public abstract class BaseViewHolder<M> extends RecyclerView.O000OOo0 {
    public void setData(Object obj) {
    }

    public BaseViewHolder(View view) {
        super(view);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public BaseViewHolder(ViewGroup viewGroup, int i) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
    }

    /* access modifiers changed from: protected */
    public <T extends View> T $(int i) {
        return this.itemView.findViewById(i);
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.itemView.getContext();
    }

    /* access modifiers changed from: protected */
    public <T extends RecyclerView.O000000o> T getOwnerAdapter() {
        RecyclerView ownerRecyclerView = getOwnerRecyclerView();
        if (ownerRecyclerView == null) {
            return null;
        }
        return ownerRecyclerView.getAdapter();
    }

    /* access modifiers changed from: protected */
    public RecyclerView getOwnerRecyclerView() {
        try {
            Field declaredField = RecyclerView.O000OOo0.class.getDeclaredField("mOwnerRecyclerView");
            declaredField.setAccessible(true);
            return (RecyclerView) declaredField.get(this);
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }
}
