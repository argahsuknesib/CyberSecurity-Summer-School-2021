package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.gsy;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import java.util.ArrayList;
import java.util.List;

public class CloudVideoDownloadListViewAdapter extends RecyclerView.O000000o {
    public IItemClickListener clickListener;
    public List<CloudVideoDownloadInfo> downloadInfoList = new ArrayList();
    private InternalClickListener internalClickListener = new InternalClickListener();
    private boolean isEditMode = false;
    public ModeChangedListener modeChangedListener;
    public RecyclerView recyclerView;

    public interface IItemClickListener<T> {
        void onItemClick(View view, int i, T t);

        void onItemLongClick(View view, int i, T t);
    }

    public interface ModeChangedListener {
        void onEditModeChanged(boolean z);
    }

    public boolean getEditMode() {
        return this.isEditMode;
    }

    public void setEditMode(boolean z) {
        this.isEditMode = z;
        ModeChangedListener modeChangedListener2 = this.modeChangedListener;
        if (modeChangedListener2 != null) {
            modeChangedListener2.onEditModeChanged(z);
        }
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List list) {
        CloudVideoDownloadInfo cloudVideoDownloadInfo = this.downloadInfoList.get(i);
        if (list.isEmpty()) {
            onBindViewHolder(o000OOo0, i);
        } else if (list.get(0).equals("editMode")) {
            CheckBox checkBox = (CheckBox) o000OOo0.itemView.findViewById(R.id.cbDelete);
            if (cloudVideoDownloadInfo.isSelected) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
        } else {
            o000OOo0.itemView.findViewById(R.id.tvTitle);
            ImageView imageView = (ImageView) o000OOo0.itemView.findViewById(R.id.ivDownloadStatus);
            TextView textView = (TextView) o000OOo0.itemView.findViewById(R.id.tvProgress);
            SeekBar seekBar = (SeekBar) o000OOo0.itemView.findViewById(R.id.sbProgress);
            TextView textView2 = (TextView) o000OOo0.itemView.findViewById(R.id.tvStatus);
            TextView textView3 = (TextView) o000OOo0.itemView.findViewById(R.id.tvDuration);
            textView3.setVisibility(8);
            ((TextView) o000OOo0.itemView.findViewById(R.id.tvTime)).setText(cloudVideoDownloadInfo.startTimePretty);
            textView.setText(cloudVideoDownloadInfo.progress + "%");
            if (cloudVideoDownloadInfo.status == 1) {
                textView.setVisibility(0);
                seekBar.setVisibility(0);
                seekBar.setProgress(cloudVideoDownloadInfo.progress);
                textView2.setText((int) R.string.cs_downloading);
                textView2.setTextColor(Color.parseColor("#3fb57d"));
                imageView.setImageDrawable(null);
            } else if (cloudVideoDownloadInfo.status == 2) {
                seekBar.setVisibility(8);
                textView.setVisibility(8);
                textView2.setText((int) R.string.cs_download_fail);
                textView2.setTextColor(Color.parseColor("#FC4949"));
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 != null) {
                    imageView.setImageDrawable(recyclerView2.getContext().getResources().getDrawable(R.drawable.cs_download_icon_retry_normal));
                }
            } else if (cloudVideoDownloadInfo.status == 4) {
                seekBar.setVisibility(8);
                textView2.setText((int) R.string.cs_download_prepare);
                textView.setVisibility(8);
                textView2.setTextColor(Color.parseColor("#969696"));
                imageView.setImageDrawable(null);
            } else if (cloudVideoDownloadInfo.status == 0) {
                seekBar.setVisibility(8);
                textView3.setVisibility(0);
                textView.setVisibility(8);
                textView3.setText(longToDate(cloudVideoDownloadInfo.duration));
                textView2.setText((int) R.string.cs_download_finish);
                textView2.setTextColor(Color.parseColor("#969696"));
                imageView.setImageDrawable(null);
            } else if (cloudVideoDownloadInfo.status == 8) {
                seekBar.setVisibility(8);
                textView.setVisibility(8);
                textView2.setText((int) R.string.cs_download_pause);
                textView2.setTextColor(Color.parseColor("#6f97e4"));
                RecyclerView recyclerView3 = this.recyclerView;
                if (recyclerView3 != null) {
                    imageView.setImageDrawable(recyclerView3.getContext().getResources().getDrawable(R.drawable.home_icon_play_3_nor));
                }
            }
        }
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
    }

    public long getItemId(int i) {
        return super.getItemId(i);
    }

    public void onViewRecycled(RecyclerView.O000OOo0 o000OOo0) {
        super.onViewRecycled(o000OOo0);
    }

    public boolean onFailedToRecycleView(RecyclerView.O000OOo0 o000OOo0) {
        return super.onFailedToRecycleView(o000OOo0);
    }

    public void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
        super.onViewAttachedToWindow(o000OOo0);
    }

    public void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
        super.onViewDetachedFromWindow(o000OOo0);
    }

    public void registerAdapterDataObserver(RecyclerView.O00000o0 o00000o0) {
        super.registerAdapterDataObserver(o00000o0);
    }

    public void unregisterAdapterDataObserver(RecyclerView.O00000o0 o00000o0) {
        super.unregisterAdapterDataObserver(o00000o0);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView2) {
        super.onAttachedToRecyclerView(recyclerView2);
        this.recyclerView = recyclerView2;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView2) {
        super.onDetachedFromRecyclerView(recyclerView2);
        this.recyclerView = null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.cs_view_download_video_item, viewGroup, false);
        inflate.setOnClickListener(this.internalClickListener);
        return new CloudVideoDownloadListViewHolder(inflate);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        CloudVideoDownloadInfo cloudVideoDownloadInfo = this.downloadInfoList.get(i);
        gsy.O00000Oo("CloudVideoDownloadListViewAdapter", "onBindViewHolder position:".concat(String.valueOf(i)));
        o000OOo0.itemView.findViewById(R.id.ivPic);
        ImageView imageView = (ImageView) o000OOo0.itemView.findViewById(R.id.ivDownloadStatus);
        TextView textView = (TextView) o000OOo0.itemView.findViewById(R.id.tvDuration);
        TextView textView2 = (TextView) o000OOo0.itemView.findViewById(R.id.tvTitle);
        TextView textView3 = (TextView) o000OOo0.itemView.findViewById(R.id.tvTime);
        TextView textView4 = (TextView) o000OOo0.itemView.findViewById(R.id.tvStatus);
        CheckBox checkBox = (CheckBox) o000OOo0.itemView.findViewById(R.id.cbDelete);
        TextView textView5 = (TextView) o000OOo0.itemView.findViewById(R.id.tvProgress);
        SeekBar seekBar = (SeekBar) o000OOo0.itemView.findViewById(R.id.sbProgress);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadListViewAdapter$DpOnRfKTMbP1iNtHra0dYeYauto */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CloudVideoDownloadInfo.this.isSelected = z;
            }
        });
        o000OOo0.itemView.setOnClickListener(new View.OnClickListener(o000OOo0, cloudVideoDownloadInfo) {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadListViewAdapter$Fd5V_dYJhSn5IaVmKLlbIeDR1fI */
            private final /* synthetic */ RecyclerView.O000OOo0 f$1;
            private final /* synthetic */ CloudVideoDownloadInfo f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                CloudVideoDownloadListViewAdapter.this.lambda$onBindViewHolder$1$CloudVideoDownloadListViewAdapter(this.f$1, this.f$2, view);
            }
        });
        o000OOo0.itemView.setOnLongClickListener(new View.OnLongClickListener(o000OOo0, cloudVideoDownloadInfo) {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoDownloadListViewAdapter$p7VYa5u9e6sWlJBtDAZibgqwpxk */
            private final /* synthetic */ RecyclerView.O000OOo0 f$1;
            private final /* synthetic */ CloudVideoDownloadInfo f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final boolean onLongClick(View view) {
                return CloudVideoDownloadListViewAdapter.this.lambda$onBindViewHolder$2$CloudVideoDownloadListViewAdapter(this.f$1, this.f$2, view);
            }
        });
        textView.setVisibility(8);
        if (!TextUtils.isEmpty(cloudVideoDownloadInfo.title)) {
            textView2.setText(cloudVideoDownloadInfo.title);
        } else {
            textView2.setText((int) R.string.cs_default_deivce_name);
        }
        textView3.setText(cloudVideoDownloadInfo.startTimePretty);
        textView5.setText(cloudVideoDownloadInfo.progress + "/%");
        if (cloudVideoDownloadInfo.status != 1) {
            if (cloudVideoDownloadInfo.status == 2) {
                textView4.setText((int) R.string.cs_download_fail);
                seekBar.setVisibility(8);
                textView5.setVisibility(8);
                textView4.setTextColor(Color.parseColor("#FC4949"));
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 != null) {
                    imageView.setImageDrawable(recyclerView2.getContext().getResources().getDrawable(R.drawable.cs_download_icon_retry_normal));
                }
            } else if (cloudVideoDownloadInfo.status == 4) {
                textView4.setText((int) R.string.cs_download_prepare);
                seekBar.setVisibility(8);
                textView5.setVisibility(8);
                textView4.setTextColor(Color.parseColor("#969696"));
                imageView.setImageDrawable(null);
            } else if (cloudVideoDownloadInfo.status == 0) {
                textView.setVisibility(0);
                seekBar.setVisibility(8);
                textView5.setVisibility(8);
                textView.setText(longToDate(cloudVideoDownloadInfo.duration));
                textView4.setText((int) R.string.cs_download_finish);
                textView4.setTextColor(Color.parseColor("#969696"));
                imageView.setImageDrawable(null);
            } else if (cloudVideoDownloadInfo.status == 8) {
                textView4.setText((int) R.string.cs_download_pause);
                seekBar.setVisibility(8);
                textView5.setVisibility(8);
                textView4.setTextColor(Color.parseColor("#6f97e4"));
                RecyclerView recyclerView3 = this.recyclerView;
                if (recyclerView3 != null) {
                    imageView.setImageDrawable(recyclerView3.getContext().getResources().getDrawable(R.drawable.home_icon_play_3_nor));
                }
            }
        }
        if (this.isEditMode) {
            checkBox.setVisibility(0);
            if (cloudVideoDownloadInfo.isSelected) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
        } else {
            checkBox.setVisibility(8);
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$CloudVideoDownloadListViewAdapter(RecyclerView.O000OOo0 o000OOo0, CloudVideoDownloadInfo cloudVideoDownloadInfo, View view) {
        IItemClickListener iItemClickListener = this.clickListener;
        if (iItemClickListener != null) {
            iItemClickListener.onItemClick(view, o000OOo0.getAdapterPosition(), cloudVideoDownloadInfo);
        }
    }

    public /* synthetic */ boolean lambda$onBindViewHolder$2$CloudVideoDownloadListViewAdapter(RecyclerView.O000OOo0 o000OOo0, CloudVideoDownloadInfo cloudVideoDownloadInfo, View view) {
        IItemClickListener iItemClickListener = this.clickListener;
        if (iItemClickListener == null) {
            return false;
        }
        iItemClickListener.onItemLongClick(view, o000OOo0.getAdapterPosition(), cloudVideoDownloadInfo);
        return true;
    }

    public int getItemCount() {
        List<CloudVideoDownloadInfo> list = this.downloadInfoList;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.downloadInfoList.size();
    }

    public int getSelectedItemCount() {
        List<CloudVideoDownloadInfo> list = this.downloadInfoList;
        int i = 0;
        if (list != null) {
            for (CloudVideoDownloadInfo cloudVideoDownloadInfo : list) {
                i += cloudVideoDownloadInfo.isSelected ? 1 : 0;
            }
        }
        return i;
    }

    public List<CloudVideoDownloadInfo> getSelectedItem() {
        ArrayList arrayList = new ArrayList();
        List<CloudVideoDownloadInfo> list = this.downloadInfoList;
        if (list != null) {
            for (CloudVideoDownloadInfo next : list) {
                if (next.isSelected) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void updateDownloadingItem(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        for (CloudVideoDownloadInfo next : this.downloadInfoList) {
            if (cloudVideoDownloadInfo.id == next.id) {
                next.size = cloudVideoDownloadInfo.size;
                next.mp4FilePath = cloudVideoDownloadInfo.mp4FilePath;
                next.m3u8FilePath = cloudVideoDownloadInfo.m3u8FilePath;
                next.progress = cloudVideoDownloadInfo.progress;
                next.did = cloudVideoDownloadInfo.did;
                next.status = cloudVideoDownloadInfo.status;
                next.createTime = cloudVideoDownloadInfo.createTime;
                next.m3u8LocalPath = cloudVideoDownloadInfo.m3u8LocalPath;
                next.uid = cloudVideoDownloadInfo.uid;
                next.videoUrl = cloudVideoDownloadInfo.videoUrl;
                next.endTime = cloudVideoDownloadInfo.endTime;
                next.startTime = cloudVideoDownloadInfo.startTime;
                next.timezoneId = cloudVideoDownloadInfo.timezoneId;
                return;
            }
        }
    }

    private String longToDate(long j) {
        if (j <= 0) {
            return "";
        }
        int i = (int) j;
        int i2 = i / 3600;
        int i3 = i2 * 3600;
        int i4 = ((int) (j - ((long) i3))) / 60;
        int i5 = (i - (i4 * 60)) - i3;
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            if (i2 < 10) {
                sb.append("0".concat(String.valueOf(i2)));
            } else {
                sb.append(i2);
            }
            sb.append(":");
        }
        if (i4 < 10) {
            sb.append("0".concat(String.valueOf(i4)));
        } else {
            sb.append(i4);
        }
        sb.append(":");
        if (i5 < 10) {
            sb.append("0".concat(String.valueOf(i5)));
        } else {
            sb.append(i5);
        }
        return sb.toString();
    }

    public <T> T getItem(int i) {
        List<CloudVideoDownloadInfo> list = this.downloadInfoList;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.downloadInfoList.size()) {
            return null;
        }
        return this.downloadInfoList.get(i);
    }

    public void clearAll() {
        for (int i = 0; i < this.downloadInfoList.size(); i++) {
            this.downloadInfoList.get(i).isSelected = false;
        }
        notifyDataSetChanged();
    }

    public void selectAll() {
        for (int i = 0; i < this.downloadInfoList.size(); i++) {
            this.downloadInfoList.get(i).isSelected = true;
        }
        notifyDataSetChanged();
    }

    class InternalClickListener implements View.OnClickListener {
        private InternalClickListener() {
        }

        public void onClick(View view) {
            int childAdapterPosition = CloudVideoDownloadListViewAdapter.this.recyclerView.getChildAdapterPosition(view);
            gsy.O00000Oo("CloudVideoDownloadListViewAdapter", "InternalClickListener:".concat(String.valueOf(childAdapterPosition)));
            if (CloudVideoDownloadListViewAdapter.this.clickListener != null) {
                CloudVideoDownloadListViewAdapter.this.clickListener.onItemClick(view, childAdapterPosition, CloudVideoDownloadListViewAdapter.this.getItem(childAdapterPosition));
            }
        }
    }
}
