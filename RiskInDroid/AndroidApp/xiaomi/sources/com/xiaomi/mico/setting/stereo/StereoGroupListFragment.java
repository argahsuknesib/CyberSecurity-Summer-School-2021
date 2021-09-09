package com.xiaomi.mico.setting.stereo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.MicoLanGroup;
import com.xiaomi.mico.api.model.StereoData;
import com.xiaomi.mico.base.MicoBaseFragment;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.setting.stereo.StereoGroupListFragment;
import com.xiaomi.smarthome.R;
import java.util.List;

public class StereoGroupListFragment extends MicoBaseFragment {
    private StereoGroupAdapter groupAdapter;
    private MicoLanGroup micoLanGroup;
    RecyclerView recyclerView;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.activity_setting_stereo_group_list, viewGroup, false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.recycle_view);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.groupAdapter = new StereoGroupAdapter();
        this.recyclerView.setAdapter(this.groupAdapter);
        updateData();
        return inflate;
    }

    public void setData(MicoLanGroup micoLanGroup2) {
        this.micoLanGroup = micoLanGroup2;
        updateData();
    }

    public void updateData() {
        MicoLanGroup micoLanGroup2;
        if (this.groupAdapter != null && (micoLanGroup2 = this.micoLanGroup) != null && micoLanGroup2.pairedGroupInfo != null && !ContainerUtil.isEmpty(this.micoLanGroup.pairedGroupInfo.stereoList)) {
            this.groupAdapter.setData(this.micoLanGroup.pairedGroupInfo.stereoList);
        }
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            updateData();
        }
    }

    class StereoGroupAdapter extends RecyclerView.O000000o<ViewHolder> {
        private List<StereoData.StereoGroup> list;

        public long getItemId(int i) {
            return (long) i;
        }

        StereoGroupAdapter() {
        }

        public void setData(List<StereoData.StereoGroup> list2) {
            this.list = list2;
            notifyDataSetChanged();
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_item_stereo_group_list, (ViewGroup) null));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.refresh(this.list.get(i));
        }

        public int getItemCount() {
            return ContainerUtil.getSize(this.list);
        }
    }

    class ViewHolder extends RecyclerView.O000OOo0 {
        LinearLayout rootLL;
        ImageView stereoItemIcon;
        ImageView stereoItemMore;
        TextView stereoItemText;

        public ViewHolder(View view) {
            super(view);
            this.rootLL = (LinearLayout) view.findViewById(R.id.root_ll);
            this.stereoItemIcon = (ImageView) view.findViewById(R.id.stereo_item_icon);
            this.stereoItemText = (TextView) view.findViewById(R.id.stereo_item_text);
            this.stereoItemMore = (ImageView) view.findViewById(R.id.stereo_item_more);
        }

        public void refresh(StereoData.StereoGroup stereoGroup) {
            Hardware hardware;
            Hardware hardware2;
            if (TextUtils.isEmpty(stereoGroup.leftDeviceHardware)) {
                hardware = Hardware.LX06;
            } else {
                hardware = Hardware.safeValueOf(stereoGroup.leftDeviceHardware.toUpperCase());
            }
            if (TextUtils.isEmpty(stereoGroup.rightDeviceHardware)) {
                hardware2 = Hardware.LX06;
            } else {
                hardware2 = Hardware.safeValueOf(stereoGroup.rightDeviceHardware.toUpperCase());
            }
            if (hardware == Hardware.LX06 && hardware2 == Hardware.LX06) {
                this.stereoItemIcon.setImageResource(R.drawable.mico_image_group_stereo_a);
            } else if (hardware == Hardware.L06A && hardware2 == Hardware.L06A) {
                this.stereoItemIcon.setImageResource(R.drawable.mico_image_group_stereo_c);
            } else if (hardware == Hardware.L09A || hardware2 == Hardware.L09A) {
                this.stereoItemIcon.setImageResource(R.drawable.mico_image_group_stereo_d);
            } else if (hardware == Hardware.L09B || hardware2 == Hardware.L09B) {
                this.stereoItemIcon.setImageResource(R.drawable.mico_image_stereo_group_l09b);
            } else if (hardware == Hardware.L15A || hardware2 == Hardware.L15A) {
                this.stereoItemIcon.setImageResource(R.drawable.mico_image_stereo_group_l15a);
            } else if (hardware == Hardware.L16A || hardware2 == Hardware.L16A) {
                this.stereoItemIcon.setImageResource(R.drawable.mico_image_stereo_group_l16a);
            } else {
                this.stereoItemIcon.setImageResource(R.drawable.mico_image_group_stereo_b);
            }
            this.stereoItemText.setText(stereoGroup.groupName);
            this.rootLL.setOnClickListener(new View.OnClickListener(stereoGroup) {
                /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoGroupListFragment$ViewHolder$543LXIx1ksP2kMqjix1lIcfoQVY */
                private final /* synthetic */ StereoData.StereoGroup f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    StereoGroupListFragment.ViewHolder.this.lambda$refresh$0$StereoGroupListFragment$ViewHolder(this.f$1, view);
                }
            });
        }

        public /* synthetic */ void lambda$refresh$0$StereoGroupListFragment$ViewHolder(StereoData.StereoGroup stereoGroup, View view) {
            Intent intent = new Intent(StereoGroupListFragment.this.getContext(), StereoConfigActivity.class);
            intent.putExtra("stereo_group", stereoGroup);
            StereoGroupListFragment.this.startActivity(intent);
        }
    }
}
