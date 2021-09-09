package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.smarthome.R;

public class ItemBinderEmpty extends BaseItemBinder<EmptyViewHolder> {
    public ItemBinderEmpty(Context context) {
        super(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public EmptyViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new EmptyViewHolder(layoutInflater.inflate((int) R.layout.mico_select_view_patchwall_empty, viewGroup, false));
    }

    class EmptyViewHolder extends BaseItemBinder.ViewHolder {
        public void updateData(ViewSection viewSection, int i) {
        }

        public EmptyViewHolder(View view) {
            super(view);
        }
    }
}
