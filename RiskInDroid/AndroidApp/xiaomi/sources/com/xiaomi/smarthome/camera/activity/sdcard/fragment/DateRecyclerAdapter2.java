package com.xiaomi.smarthome.camera.activity.sdcard.fragment;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDateListViewHolder;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDate;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class DateRecyclerAdapter2 extends RecyclerView.O000000o {
    public List<CloudVideoDate> cloudVideoDates = new ArrayList();
    private Context context;
    public IItemClickListener iItemClickListener;
    private InternalClickListener internalClickListener = new InternalClickListener();
    private int itemBackGround = 0;
    public RecyclerView recyclerView;
    public int selectedItemPosition = -1;
    private String[] weeks;

    public interface IItemClickListener<T> {
        void onItemClick(View view, int i, T t);
    }

    public DateRecyclerAdapter2(Context context2, int i) {
        this.itemBackGround = i;
        this.context = context2;
        this.weeks = new String[]{context2.getString(R.string.sun), context2.getString(R.string.Mon), context2.getString(R.string.Tue), context2.getString(R.string.Wed), context2.getString(R.string.Thu), context2.getString(R.string.Fri), context2.getString(R.string.Sat)};
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
        ((FrameLayout) inflate.findViewById(R.id.rlDateItem)).setBackgroundResource(this.itemBackGround);
        return new CloudVideoDateListViewHolder(inflate);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        TextView textView = (TextView) o000OOo0.itemView.findViewById(R.id.tvDay);
        TextView textView2 = (TextView) o000OOo0.itemView.findViewById(R.id.tvWeek);
        if (this.selectedItemPosition == i) {
            o000OOo0.itemView.setSelected(true);
            textView.setTextColor(Color.parseColor("#ffffff"));
            textView2.setTextColor(Color.parseColor("#ffffff"));
        } else {
            o000OOo0.itemView.setSelected(false);
            textView.setTextColor(this.context.getResources().getColor(R.color.mj_color_black));
            textView2.setTextColor(this.context.getResources().getColor(R.color.mj_color_gray_light));
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
            if (!(DateRecyclerAdapter2.this.recyclerView == null || DateRecyclerAdapter2.this.iItemClickListener == null)) {
                int childAdapterPosition = DateRecyclerAdapter2.this.recyclerView.getChildAdapterPosition(view);
                if (DateRecyclerAdapter2.this.cloudVideoDates != null && DateRecyclerAdapter2.this.cloudVideoDates.size() > 0) {
                    if (DateRecyclerAdapter2.this.cloudVideoDates.get(childAdapterPosition).isHasVideo) {
                        for (int i = 0; i < DateRecyclerAdapter2.this.cloudVideoDates.size(); i++) {
                            View findViewByPosition = DateRecyclerAdapter2.this.recyclerView.getLayoutManager().findViewByPosition(i);
                            if (findViewByPosition != null) {
                                findViewByPosition.setSelected(false);
                            }
                        }
                    } else {
                        return;
                    }
                }
                DateRecyclerAdapter2 dateRecyclerAdapter2 = DateRecyclerAdapter2.this;
                dateRecyclerAdapter2.selectedItemPosition = childAdapterPosition;
                IItemClickListener iItemClickListener = dateRecyclerAdapter2.iItemClickListener;
                int i2 = DateRecyclerAdapter2.this.selectedItemPosition;
                DateRecyclerAdapter2 dateRecyclerAdapter22 = DateRecyclerAdapter2.this;
                iItemClickListener.onItemClick(view, i2, dateRecyclerAdapter22.getItem(dateRecyclerAdapter22.selectedItemPosition));
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
