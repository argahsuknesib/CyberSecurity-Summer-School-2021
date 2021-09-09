package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.cnr;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.gpc;
import _m_j.gqg;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.cloudstorage.adapter.PlayListAdapter;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoData;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoImageDownloader;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CloudVideoListAdapter extends RecyclerView.O000000o {
    private Context context;
    public int currentPlayPosition = -1;
    public String did = null;
    private cnw displayImageOptions;
    public IItemClickListener iItemClickListener;
    public IItemLongClickListener iItemLongClickListener;
    private InternalClickListener internalClickListener = new InternalClickListener();
    private InternalLongClickListener internalLongClickListener = new InternalLongClickListener();
    public boolean isInEditMode = false;
    public ModeChangedListener modeChangedListener;
    public RecyclerView recyclerView;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    public List<CloudVideoData> videoDataList;

    public interface IItemClickListener<T> {
        void onItemClick(View view, int i, T t);
    }

    public interface IItemLongClickListener {
        void onItemLongClick(View view, int i);
    }

    public interface ModeChangedListener {
        void onEditModeChanged(boolean z);
    }

    public List<CloudVideoData> getVideoDataList() {
        return this.videoDataList;
    }

    public void setVideoDataList(List<CloudVideoData> list) {
        this.videoDataList.clear();
        this.videoDataList.addAll(list);
    }

    public void appendVideoDataList(List<CloudVideoData> list) {
        this.videoDataList.addAll(list);
    }

    public boolean getEditMode() {
        return this.isInEditMode;
    }

    public void setEditMode(boolean z) {
        if (!z) {
            for (CloudVideoData cloudVideoData : this.videoDataList) {
                cloudVideoData.isSelected = false;
            }
        }
        ModeChangedListener modeChangedListener2 = this.modeChangedListener;
        if (modeChangedListener2 != null) {
            modeChangedListener2.onEditModeChanged(z);
        }
        this.isInEditMode = z;
    }

    public int getSelectedItemCount() {
        List<CloudVideoData> list = this.videoDataList;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.videoDataList.size(); i2++) {
            i += this.videoDataList.get(i2).isSelected ? 1 : 0;
        }
        return i;
    }

    public List<CloudVideoData> getSelectedItems() {
        ArrayList arrayList = new ArrayList();
        if (getSelectedItemCount() > 0) {
            for (CloudVideoData next : this.videoDataList) {
                if (next.isSelected) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public CloudVideoListAdapter(Context context2, String str) {
        this.context = context2;
        this.did = str;
        this.videoDataList = new ArrayList();
    }

    public CloudVideoListAdapter(Context context2, String str, List<CloudVideoData> list) {
        this.context = context2;
        this.did = str;
        if (list != null) {
            this.videoDataList = list;
        } else {
            this.videoDataList = new ArrayList();
        }
    }

    private void init() {
        if (!cnx.O000000o().O00000Oo()) {
            ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this.context);
            builder.O000000o();
            builder.O0000o0 = true;
            builder.O000000o(new cnr());
            builder.O00000Oo();
            builder.O000000o(QueueProcessingType.LIFO);
            builder.O0000oO0 = new CloudVideoImageDownloader(this.context);
            cnx.O000000o().O000000o(builder.O00000o0());
            cnw.O000000o o000000o = new cnw.O000000o();
            o000000o.O0000OOo = true;
            o000000o.O0000Oo0 = true;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            o000000o.O0000OoO = options;
            this.displayImageOptions = o000000o.O000000o();
        }
    }

    private void release() {
        if (cnx.O000000o().O00000Oo()) {
            cnx.O000000o().O00000o();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.cs_view_video_child_list_item, viewGroup, false);
        CloudVideoListViewHolder cloudVideoListViewHolder = new CloudVideoListViewHolder(inflate);
        inflate.setOnClickListener(this.internalClickListener);
        return cloudVideoListViewHolder;
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        TextView textView = (TextView) o000OOo0.itemView.findViewById(R.id.tvDuration);
        TextView textView2 = (TextView) o000OOo0.itemView.findViewById(R.id.tvStartTime);
        ImageView imageView = (ImageView) o000OOo0.itemView.findViewById(R.id.ivImage);
        CheckBox checkBox = (CheckBox) o000OOo0.itemView.findViewById(R.id.cbEdit);
        ImageView imageView2 = (ImageView) o000OOo0.itemView.findViewById(R.id.ivPlaying);
        CloudVideoData cloudVideoData = this.videoDataList.get(i);
        if (cloudVideoData.isPlaying) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        o000OOo0.itemView.setOnLongClickListener(this.internalLongClickListener);
        checkBox.setOnTouchListener(new View.OnTouchListener(cloudVideoData) {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListAdapter$NtT3vUy1brpMFcJKwKlJCzkg */
            private final /* synthetic */ CloudVideoData f$1;

            {
                this.f$1 = r2;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CloudVideoListAdapter.this.lambda$onBindViewHolder$0$CloudVideoListAdapter(this.f$1, view, motionEvent);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoListAdapter$AAdtXGZVp854wwQ36633NJ8Uz1A */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CloudVideoData.this.isSelected = z;
            }
        });
        textView.setText(longToDate(cloudVideoData.duration));
        if (cloudVideoData.isPeople) {
            textView2.setCompoundDrawablePadding(gpc.O000000o(2.0f));
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, (int) R.drawable.people_move, 0);
        } else {
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        textView2.setText(this.sdf.format(Long.valueOf(cloudVideoData.startTime)));
        imageView.setImageResource(R.drawable.set_bg_02_visual_nor);
        if (TextUtils.isEmpty(cloudVideoData.imgStoreUrl)) {
            cloudVideoData.imgStoreUrl = CloudVideoNetUtils.getInstance().getSnapshotUrl(this.did, cloudVideoData.fileId, cloudVideoData.imgStoreId);
        }
        if (!TextUtils.isEmpty(cloudVideoData.imgStoreUrl) && cnx.O000000o().O00000Oo()) {
            cnx.O000000o().O000000o(cloudVideoData.imgStoreUrl, imageView, this.displayImageOptions);
        }
        if (this.isInEditMode) {
            checkBox.setVisibility(0);
            if (cloudVideoData.isSelected) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
        } else {
            checkBox.setVisibility(8);
        }
    }

    public /* synthetic */ boolean lambda$onBindViewHolder$0$CloudVideoListAdapter(CloudVideoData cloudVideoData, View view, MotionEvent motionEvent) {
        if (cloudVideoData.isSelected || getSelectedItemCount() < PlayListAdapter.MAX_SELECT_COUNT) {
            return false;
        }
        gqg.O00000Oo((int) R.string.cs_max_download_50);
        return true;
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

    public int getItemCount() {
        return this.videoDataList.size();
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
        init();
        this.recyclerView = recyclerView2;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView2) {
        this.recyclerView = null;
        super.onDetachedFromRecyclerView(recyclerView2);
        release();
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List list) {
        if (!list.isEmpty()) {
            o000OOo0.itemView.findViewById(R.id.rlItemContainer);
            o000OOo0.itemView.findViewById(R.id.ivImage);
            o000OOo0.itemView.findViewById(R.id.tvDuration);
            o000OOo0.itemView.findViewById(R.id.tvStartTime);
            CheckBox checkBox = (CheckBox) o000OOo0.itemView.findViewById(R.id.cbEdit);
            ImageView imageView = (ImageView) o000OOo0.itemView.findViewById(R.id.ivPlaying);
            if (this.videoDataList.get(i).isPlaying) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            checkBox.setChecked(this.videoDataList.get(i).isSelected);
            return;
        }
        super.onBindViewHolder(o000OOo0, i, list);
    }

    class InternalClickListener implements View.OnClickListener {
        private InternalClickListener() {
        }

        public void onClick(View view) {
            if (CloudVideoListAdapter.this.recyclerView != null) {
                int childAdapterPosition = CloudVideoListAdapter.this.recyclerView.getChildAdapterPosition(view);
                if (!CloudVideoListAdapter.this.isInEditMode) {
                    CloudVideoListAdapter cloudVideoListAdapter = CloudVideoListAdapter.this;
                    cloudVideoListAdapter.currentPlayPosition = childAdapterPosition;
                    if (cloudVideoListAdapter.iItemClickListener != null) {
                        CloudVideoListAdapter.this.iItemClickListener.onItemClick(view, CloudVideoListAdapter.this.recyclerView.getChildAdapterPosition(view), null);
                    }
                } else if (CloudVideoListAdapter.this.videoDataList.get(childAdapterPosition).isSelected || CloudVideoListAdapter.this.getSelectedItemCount() < PlayListAdapter.MAX_SELECT_COUNT) {
                    if (CloudVideoListAdapter.this.videoDataList.get(childAdapterPosition).isSelected) {
                        CloudVideoListAdapter.this.videoDataList.get(childAdapterPosition).isSelected = false;
                    } else {
                        CloudVideoListAdapter.this.videoDataList.get(childAdapterPosition).isSelected = true;
                    }
                    CloudVideoListAdapter.this.notifyItemChanged(childAdapterPosition);
                } else {
                    gqg.O00000Oo((int) R.string.cs_max_download_50);
                }
            }
        }
    }

    class InternalLongClickListener implements View.OnLongClickListener {
        private InternalLongClickListener() {
        }

        public boolean onLongClick(View view) {
            if (CloudVideoListAdapter.this.iItemLongClickListener == null) {
                return false;
            }
            CloudVideoListAdapter.this.iItemLongClickListener.onItemLongClick(view, CloudVideoListAdapter.this.recyclerView.getChildAdapterPosition(view));
            return true;
        }
    }

    public String longToDate(long j) {
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

    public int calCurrentPlayPosition(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < this.videoDataList.size(); i++) {
            if (str.equals(this.videoDataList.get(i).fileId)) {
                return i;
            }
        }
        return -1;
    }

    public void setCurrentPlayItem(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.videoDataList.size(); i++) {
                if (str.equals(this.videoDataList.get(i).fileId)) {
                    this.videoDataList.get(i).isPlaying = true;
                    this.currentPlayPosition = i;
                } else {
                    this.videoDataList.get(i).isPlaying = false;
                }
            }
        }
    }

    public void selectAll() {
        for (int i = 0; i < this.videoDataList.size(); i++) {
            this.videoDataList.get(i).isSelected = true;
        }
        notifyDataSetChanged();
    }

    public void clearAll() {
        for (int i = 0; i < this.videoDataList.size(); i++) {
            this.videoDataList.get(i).isSelected = false;
        }
        notifyDataSetChanged();
    }
}
