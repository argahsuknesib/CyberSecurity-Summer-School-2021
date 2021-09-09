package com.xiaomi.smarthome.miio.camera.cloudstorage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDate;
import java.util.ArrayList;
import java.util.List;

public class CloudVideoDateListViewAdapter extends RecyclerView.O000000o {
    public List<CloudVideoDate> cloudVideoDates;
    public IItemClickListener iItemClickListener;
    private InternalClickListener internalClickListener = new InternalClickListener();
    public RecyclerView recyclerView;
    public int selectedItemPosition = -1;

    public interface IItemClickListener<T> {
        void onItemClick(View view, int i, Object obj);
    }

    public CloudVideoDateListViewAdapter() {
        if (this.cloudVideoDates == null) {
            this.cloudVideoDates = new ArrayList();
        }
    }

    public CloudVideoDateListViewAdapter(List<CloudVideoDate> list) {
        if (list != null) {
            this.cloudVideoDates = list;
        } else {
            this.cloudVideoDates = new ArrayList();
        }
    }

    public CloudVideoDateListViewAdapter(List<CloudVideoDate> list, IItemClickListener iItemClickListener2) {
        if (list != null) {
            this.cloudVideoDates = list;
        } else {
            this.cloudVideoDates = new ArrayList();
        }
        this.iItemClickListener = iItemClickListener2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.cs_view_date_list_item, viewGroup, false);
        inflate.setOnClickListener(this.internalClickListener);
        return new CloudVideoDateListViewHolder(inflate);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        TextView textView = (TextView) o000OOo0.itemView.findViewById(R.id.tvDay);
        TextView textView2 = (TextView) o000OOo0.itemView.findViewById(R.id.tvMonth);
        if (this.selectedItemPosition == i) {
            o000OOo0.itemView.setSelected(true);
            textView.setTextColor(o000OOo0.itemView.getContext().getResources().getColor(R.color.camera_white));
            textView2.setTextColor(o000OOo0.itemView.getContext().getResources().getColor(R.color.camera_white));
        } else {
            o000OOo0.itemView.setSelected(false);
            textView.setTextColor(o000OOo0.itemView.getContext().getResources().getColor(R.color.mj_color_black));
            textView2.setTextColor(o000OOo0.itemView.getContext().getResources().getColor(R.color.mj_color_gray_light));
        }
        if (this.cloudVideoDates.get(i).isHasVideo) {
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, (int) R.drawable.cs_icon_purple_dot_bg);
        } else {
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        textView.setText(this.cloudVideoDates.get(i).day);
        textView2.setText(this.cloudVideoDates.get(i).monthChinaPattern);
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
        List<CloudVideoDate> list = this.cloudVideoDates;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public <T> T getItem(int i) {
        List<CloudVideoDate> list = this.cloudVideoDates;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.cloudVideoDates.size()) {
            return null;
        }
        return this.cloudVideoDates.get(i);
    }

    public void onViewRecycled(RecyclerView.O000OOo0 o000OOo0) {
        super.onViewRecycled(o000OOo0);
    }

    public boolean onFailedToRecycleView(RecyclerView.O000OOo0 o000OOo0) {
        return super.onFailedToRecycleView(o000OOo0);
    }

    public void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
        super.onViewAttachedToWindow(o000OOo0);
        refreshSelectedStatus(o000OOo0);
    }

    public void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
        super.onViewDetachedFromWindow(o000OOo0);
        refreshSelectedStatus(o000OOo0);
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
        this.recyclerView = null;
        super.onDetachedFromRecyclerView(recyclerView2);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List list) {
        super.onBindViewHolder(o000OOo0, i, list);
    }

    class InternalClickListener implements View.OnClickListener {
        private InternalClickListener() {
        }

        public void onClick(View view) {
            if (!(CloudVideoDateListViewAdapter.this.recyclerView == null || CloudVideoDateListViewAdapter.this.iItemClickListener == null)) {
                CloudVideoDateListViewAdapter cloudVideoDateListViewAdapter = CloudVideoDateListViewAdapter.this;
                cloudVideoDateListViewAdapter.selectedItemPosition = cloudVideoDateListViewAdapter.recyclerView.getChildAdapterPosition(view);
                IItemClickListener iItemClickListener = CloudVideoDateListViewAdapter.this.iItemClickListener;
                int i = CloudVideoDateListViewAdapter.this.selectedItemPosition;
                CloudVideoDateListViewAdapter cloudVideoDateListViewAdapter2 = CloudVideoDateListViewAdapter.this;
                iItemClickListener.onItemClick(view, i, cloudVideoDateListViewAdapter2.getItem(cloudVideoDateListViewAdapter2.selectedItemPosition));
            }
            CloudVideoDateListViewAdapter.this.notifyDataSetChanged();
        }
    }

    private void refreshSelectedStatus(RecyclerView.O000OOo0 o000OOo0) {
        if (o000OOo0 != null) {
            if (this.selectedItemPosition == this.recyclerView.getChildAdapterPosition(o000OOo0.itemView)) {
                o000OOo0.itemView.setSelected(true);
            } else {
                o000OOo0.itemView.setSelected(false);
            }
        }
    }

    public boolean isAllDateDataUpdated() {
        List<CloudVideoDate> list = this.cloudVideoDates;
        if (list == null || list.size() <= 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (CloudVideoDate cloudVideoDate : this.cloudVideoDates) {
            if (currentTimeMillis - cloudVideoDate.lastUpdateTS > 60000) {
                return false;
            }
        }
        return true;
    }
}
