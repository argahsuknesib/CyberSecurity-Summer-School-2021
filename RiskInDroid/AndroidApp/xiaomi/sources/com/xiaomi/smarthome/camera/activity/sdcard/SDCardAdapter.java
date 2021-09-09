package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.clu;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.HourOfDayView;
import java.util.ArrayList;
import java.util.List;

public class SDCardAdapter extends BaseAdapter {
    private Context mContext;
    private List<clu> mData = new ArrayList();
    public boolean mIsMultiSelectMode;
    public HourOfDayView.HourOfDayViewListener mListener = null;

    public long getItemId(int i) {
        return (long) i;
    }

    public SDCardAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<clu> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void setMultiSelectMode(boolean z) {
        if (this.mIsMultiSelectMode != z) {
            this.mIsMultiSelectMode = z;
            if (!z) {
                unSelectAll();
            }
            notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public void setDayViewListener(HourOfDayView.HourOfDayViewListener hourOfDayViewListener) {
        this.mListener = hourOfDayViewListener;
    }

    public int getCount() {
        return this.mData.size();
    }

    /* access modifiers changed from: package-private */
    public int getSelectCount() {
        int i = 0;
        for (int i2 = 0; i2 < this.mData.size(); i2++) {
            clu clu = this.mData.get(i2);
            int i3 = 0;
            for (boolean z : clu.O0000OOo) {
                if (z) {
                    i3++;
                }
            }
            i += i3;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public int getDataCount() {
        int i = 0;
        for (clu clu : this.mData) {
            i += clu.O0000O0o.size();
        }
        return i;
    }

    public void selectAll() {
        for (int i = 0; i < this.mData.size(); i++) {
            this.mData.get(i).O000000o(true);
        }
        notifyDataSetChanged();
    }

    public void unSelectAll() {
        for (int i = 0; i < this.mData.size(); i++) {
            this.mData.get(i).O000000o(false);
        }
        notifyDataSetChanged();
    }

    public List<TimeItem> getSelectItems() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mData.size(); i++) {
            arrayList.addAll(this.mData.get(i).O000000o());
        }
        return arrayList;
    }

    public clu getItem(int i) {
        return this.mData.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(this.mContext).inflate((int) R.layout.camera_sdcard_file_item, (ViewGroup) null);
            viewHolder.mTitle = (TextView) view2.findViewById(R.id.title);
            viewHolder.hourOfDayView = (HourOfDayView) view2.findViewById(R.id.hour_of_day_view);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.binView(i);
        return view2;
    }

    class ViewHolder {
        HourOfDayView hourOfDayView;
        TextView mTitle;

        ViewHolder() {
        }

        /* access modifiers changed from: package-private */
        public void binView(int i) {
            if (i == SDCardAdapter.this.getCount() - 1) {
                if (this.hourOfDayView.getPaddingBottom() == 0) {
                    this.hourOfDayView.setPadding(0, 0, 0, 51);
                }
            } else if (this.hourOfDayView.getPaddingBottom() != 0) {
                this.hourOfDayView.setPadding(0, 0, 0, 0);
            }
            clu item = SDCardAdapter.this.getItem(i);
            this.mTitle.setText(item.O00000oO);
            this.hourOfDayView.setTimeItemDay(item, i);
            this.hourOfDayView.setMultiSelect(SDCardAdapter.this.mIsMultiSelectMode);
            this.hourOfDayView.setHourOfDayViewListener(SDCardAdapter.this.mListener);
        }
    }
}
