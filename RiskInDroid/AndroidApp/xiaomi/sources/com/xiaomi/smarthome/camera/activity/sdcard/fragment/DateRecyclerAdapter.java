package com.xiaomi.smarthome.camera.activity.sdcard.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDateListViewHolder;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDate;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class DateRecyclerAdapter extends RecyclerView.O000000o {
    public List<CloudVideoDate> cloudVideoDates = new ArrayList();
    public IItemClickListener iItemClickListener;
    private InternalClickListener internalClickListener = new InternalClickListener();
    public RecyclerView recyclerView;
    public int selectedItemPosition = -1;
    private String[] weeks;

    public interface IItemClickListener<T> {
        void onItemClick(View view, int i, T t);
    }

    public DateRecyclerAdapter(Context context) {
        this.weeks = new String[]{context.getString(R.string.sun), context.getString(R.string.Mon), context.getString(R.string.Tue), context.getString(R.string.Wed), context.getString(R.string.Thu), context.getString(R.string.Fri), context.getString(R.string.Sat)};
    }

    public void setData(List<CloudVideoDate> list) {
        this.cloudVideoDates = list;
        notifyDataSetChanged();
    }

    public void setListener(IItemClickListener<CloudVideoDate> iItemClickListener2) {
        this.iItemClickListener = iItemClickListener2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.cs_view_date_list_item2, viewGroup, false);
        inflate.setOnClickListener(this.internalClickListener);
        return new CloudVideoDateListViewHolder(inflate);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (this.selectedItemPosition == i) {
            o000OOo0.itemView.setSelected(true);
        } else {
            o000OOo0.itemView.setSelected(false);
        }
        TextView textView = (TextView) o000OOo0.itemView.findViewById(R.id.tvDay);
        TextView textView2 = (TextView) o000OOo0.itemView.findViewById(R.id.tvWeek);
        if (this.cloudVideoDates.get(i).isHasVideo) {
            textView.setTextColor(o000OOo0.itemView.getResources().getColor(R.color.mj_color_black));
            textView2.setTextColor(o000OOo0.itemView.getResources().getColor(R.color.mj_color_black_80_transparent));
        } else {
            textView.setTextColor(o000OOo0.itemView.getResources().getColor(R.color.mj_color_black_30_transparent));
            textView2.setTextColor(o000OOo0.itemView.getResources().getColor(R.color.mj_color_black_30_transparent));
        }
        textView.setText(MessageFormat.format("{0}", this.cloudVideoDates.get(i).day));
        textView2.setText(this.weeks[this.cloudVideoDates.get(i).week]);
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

    public void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
        super.onViewAttachedToWindow(o000OOo0);
        refreshSelectedStatus(o000OOo0);
    }

    public void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
        super.onViewDetachedFromWindow(o000OOo0);
        refreshSelectedStatus(o000OOo0);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView2) {
        super.onAttachedToRecyclerView(recyclerView2);
        this.recyclerView = recyclerView2;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView2) {
        this.recyclerView = null;
        super.onDetachedFromRecyclerView(recyclerView2);
    }

    class InternalClickListener implements View.OnClickListener {
        private InternalClickListener() {
        }

        public void onClick(View view) {
            if (!(DateRecyclerAdapter.this.recyclerView == null || DateRecyclerAdapter.this.iItemClickListener == null)) {
                int childAdapterPosition = DateRecyclerAdapter.this.recyclerView.getChildAdapterPosition(view);
                if (DateRecyclerAdapter.this.cloudVideoDates != null && DateRecyclerAdapter.this.cloudVideoDates.size() > 0) {
                    if (DateRecyclerAdapter.this.cloudVideoDates.get(childAdapterPosition).isHasVideo) {
                        for (int i = 0; i < DateRecyclerAdapter.this.cloudVideoDates.size(); i++) {
                            View findViewByPosition = DateRecyclerAdapter.this.recyclerView.getLayoutManager().findViewByPosition(i);
                            if (findViewByPosition != null) {
                                findViewByPosition.setSelected(false);
                            }
                        }
                    } else {
                        return;
                    }
                }
                DateRecyclerAdapter dateRecyclerAdapter = DateRecyclerAdapter.this;
                dateRecyclerAdapter.selectedItemPosition = childAdapterPosition;
                IItemClickListener iItemClickListener = dateRecyclerAdapter.iItemClickListener;
                int i2 = DateRecyclerAdapter.this.selectedItemPosition;
                DateRecyclerAdapter dateRecyclerAdapter2 = DateRecyclerAdapter.this;
                iItemClickListener.onItemClick(view, i2, dateRecyclerAdapter2.getItem(dateRecyclerAdapter2.selectedItemPosition));
            }
            view.setSelected(true);
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
}
