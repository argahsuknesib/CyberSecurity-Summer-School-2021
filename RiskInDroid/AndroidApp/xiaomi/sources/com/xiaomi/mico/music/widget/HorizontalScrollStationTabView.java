package com.xiaomi.mico.music.widget;

import _m_j.gsy;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.List;

public class HorizontalScrollStationTabView extends RelativeLayout {
    private StationTabAdapter adapter;
    private int cellWidth;
    private LinearLayoutManager linearLayoutManager;
    private OnTabClickedListener listener;
    public RecyclerView recyclerView;
    private int selectedIndex;
    List<StationTab> stations;

    public interface OnTabClickedListener {
        void onTabClicked(int i, int i2);
    }

    public HorizontalScrollStationTabView(Context context) {
        super(context);
        initView(context);
    }

    public HorizontalScrollStationTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public HorizontalScrollStationTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.view_horizontal_station_tab, this);
        this.recyclerView = (RecyclerView) findViewById(R.id.tablayout);
        this.adapter = new StationTabAdapter(context);
        this.linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.recyclerView.setLayoutManager(this.linearLayoutManager);
        this.recyclerView.setAdapter(this.adapter);
    }

    public void setStations(List<StationTab> list) {
        list.get(this.selectedIndex).selected = true;
        this.adapter.setStations(list);
        this.stations = list;
    }

    public void onTabSelected() {
        OnTabClickedListener onTabClickedListener = this.listener;
        if (onTabClickedListener != null) {
            int i = this.selectedIndex;
            onTabClickedListener.onTabClicked(i, this.stations.get(i).count);
        }
    }

    public int getGenreCount(int i) {
        return this.stations.get(i).count;
    }

    public int getSelectedTabCount() {
        return this.stations.get(this.selectedIndex).count;
    }

    public boolean setSelectedIndex(int i) {
        if (this.selectedIndex == i) {
            return false;
        }
        gsy.O000000o(6, "HEHE", "setSelectedIndex=".concat(String.valueOf(i)));
        gsy.O000000o(6, "HEHE", "findLastVisibleItemPosition=" + this.linearLayoutManager.findLastVisibleItemPosition());
        if (this.linearLayoutManager.findFirstVisibleItemPosition() >= i) {
            this.linearLayoutManager.scrollToPositionWithOffset(i, 0);
        } else if (this.linearLayoutManager.findLastVisibleItemPosition() < i + 1) {
            LinearLayoutManager linearLayoutManager2 = this.linearLayoutManager;
            linearLayoutManager2.scrollToPositionWithOffset(linearLayoutManager2.findFirstVisibleItemPosition() + 1, -50);
        }
        setSelected(i);
        return true;
    }

    public void setSelected(int i) {
        if (this.selectedIndex != i) {
            this.adapter.getStations().get(i).selected = true;
            this.adapter.getStations().get(this.selectedIndex).selected = false;
            this.adapter.notifyDataSetChanged();
            this.selectedIndex = i;
        }
    }

    public void setListener(OnTabClickedListener onTabClickedListener) {
        this.listener = onTabClickedListener;
    }

    public class StationTabAdapter extends RecyclerView.O000000o<StationTabViewHolder> {
        private Context context;
        private List<StationTab> stations;

        public StationTabAdapter(Context context2) {
            this.context = context2;
        }

        public void setStations(List list) {
            this.stations = list;
            notifyDataSetChanged();
        }

        public List<StationTab> getStations() {
            return this.stations;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public StationTabViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new StationTabViewHolder(viewGroup.getContext(), LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_station_tab_cell, viewGroup, false));
        }

        public void onBindViewHolder(StationTabViewHolder stationTabViewHolder, int i) {
            StationTab stationTab = this.stations.get(i);
            boolean z = true;
            if (i != this.stations.size() - 1) {
                z = false;
            }
            stationTabViewHolder.refreshUI(stationTab, i, z);
        }

        public int getItemCount() {
            List<StationTab> list = this.stations;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    public static class StationTab {
        public int count;
        public String id;
        public String name;
        public boolean selected;

        public StationTab(String str, int i) {
            this.name = str;
            this.count = i;
        }
    }

    class StationTabViewHolder extends RecyclerView.O000OOo0 {
        TextView name;
        public int position;
        StationTab stationTab;
        View tag;
        View tagLeft;
        View tagRight;
        View tagRightTwo;

        public StationTabViewHolder(Context context, View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.name);
            this.tag = view.findViewById(R.id.tag);
            this.tagLeft = view.findViewById(R.id.tag_left);
            this.tagRight = view.findViewById(R.id.tag_right);
            this.tagRightTwo = view.findViewById(R.id.tag_right_two);
            view.findViewById(R.id.qq_station_tab_cotain).setOnClickListener(new View.OnClickListener(HorizontalScrollStationTabView.this) {
                /* class com.xiaomi.mico.music.widget.HorizontalScrollStationTabView.StationTabViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    HorizontalScrollStationTabView.this.setSelected(StationTabViewHolder.this.position);
                    HorizontalScrollStationTabView.this.onTabSelected();
                }
            });
        }

        public void refreshUI(StationTab stationTab2, int i, boolean z) {
            this.position = i;
            this.stationTab = stationTab2;
            this.name.setText(stationTab2.name);
            this.name.setSelected(stationTab2.selected);
            if (stationTab2.selected) {
                this.name.setTextSize(1, 17.0f);
                this.name.setTypeface(Typeface.defaultFromStyle(1));
                this.tag.setBackgroundResource(R.drawable.split_line_qq_station_selected);
            } else {
                this.name.setTextSize(1, 15.0f);
                this.tag.setBackgroundResource(R.drawable.split_line_qq_station);
                this.name.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (i == 0) {
                this.tagLeft.setVisibility(8);
            } else {
                this.tagLeft.setVisibility(0);
            }
            if (z) {
                this.tagRight.setVisibility(8);
                this.tagRightTwo.setVisibility(8);
                return;
            }
            this.tagRight.setVisibility(0);
            this.tagRightTwo.setVisibility(0);
        }
    }
}
