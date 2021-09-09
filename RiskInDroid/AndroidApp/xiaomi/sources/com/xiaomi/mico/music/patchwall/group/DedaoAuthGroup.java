package com.xiaomi.mico.music.patchwall.group;

import _m_j.jgc;
import android.os.Bundle;
import android.view.View;
import com.xiaomi.mico.common.application.UserPreference;
import com.xiaomi.mico.common.event.DeDaoAuthEvent;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.music.patchwall.group.DedaoAuthGroup;
import com.xiaomi.smarthome.R;

public class DedaoAuthGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
    public String getID() {
        return "HOME_BUTTON";
    }

    public int getItemViewType(int i) {
        return 14;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
    }

    public static class DedaoAuthViewHolder extends ItemClickableAdapter.ViewHolder {
        public DedaoAuthViewHolder(View view) {
            super(view, null);
            view.findViewById(R.id.root_view).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.group.$$Lambda$DedaoAuthGroup$DedaoAuthViewHolder$AHt222OVGXjGQt09fHyF2Wo7AQ */

                public final void onClick(View view) {
                    DedaoAuthGroup.DedaoAuthViewHolder.this.lambda$new$0$DedaoAuthGroup$DedaoAuthViewHolder(view);
                }
            });
            view.findViewById(R.id.close_auth_view).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.group.$$Lambda$DedaoAuthGroup$DedaoAuthViewHolder$ecsPEeuaHgaGyLDXur9aAjUo5y0 */

                public final void onClick(View view) {
                    DedaoAuthGroup.DedaoAuthViewHolder.this.lambda$new$1$DedaoAuthGroup$DedaoAuthViewHolder(view);
                }
            });
        }

        /* renamed from: onClick */
        public void lambda$new$1$DedaoAuthGroup$DedaoAuthViewHolder(View view) {
            new Bundle().putString("PAGE_TYPE", "kid");
            int id = view.getId();
            if (id == R.id.root_view) {
                SchemaManager.handleSchema(view.getContext(), "mico://services/oauth?skillId=279202210947007488&providerID=269135865337350144");
            } else if (id == R.id.close_auth_view) {
                UserPreference.setDedaoAuthClosed(true);
                jgc.O000000o().O00000o(new DeDaoAuthEvent());
            }
        }
    }
}
