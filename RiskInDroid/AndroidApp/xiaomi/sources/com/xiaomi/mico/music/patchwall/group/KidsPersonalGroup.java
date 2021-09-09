package com.xiaomi.mico.music.patchwall.group;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import butterknife.Optional;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.music.patchwall.group.KidsPersonalGroup;
import com.xiaomi.mico.setting.babyschedule.BabyScheduleActivity;
import com.xiaomi.smarthome.R;

public class KidsPersonalGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
    public String getID() {
        return "HOME_BUTTON";
    }

    public int getItemViewType(int i) {
        return 15;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
    }

    public static class KidsPersonalViewHolder extends ItemClickableAdapter.ViewHolder {
        private Context context;

        public KidsPersonalViewHolder(View view) {
            super(view, null);
            this.context = view.getContext();
            view.findViewById(R.id.babySchedule).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.group.$$Lambda$KidsPersonalGroup$KidsPersonalViewHolder$GExUtysDUzG1NFp_KNyroIiFgjs */

                public final void onClick(View view) {
                    KidsPersonalGroup.KidsPersonalViewHolder.this.lambda$new$0$KidsPersonalGroup$KidsPersonalViewHolder(view);
                }
            });
        }

        @Optional
        /* renamed from: onClick */
        public void lambda$new$0$KidsPersonalGroup$KidsPersonalViewHolder(View view) {
            new Bundle().putString("PAGE_TYPE", "kid");
            if (view.getId() == R.id.babySchedule) {
                BabyScheduleActivity.start(this.context);
            }
        }
    }
}
