package com.xiaomi.mico.music.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import java.util.List;

public class HorizontalScrollStationView extends HorizontalScrollView {
    public LinearLayout contain;
    public int selectedIndex;
    List<String> stations;

    public void scrollNext() {
    }

    public void setSelectNext() {
    }

    public HorizontalScrollStationView(Context context) {
        super(context);
        initView(context);
    }

    public HorizontalScrollStationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public HorizontalScrollStationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        setClipChildren(false);
        LayoutInflater.from(context).inflate((int) R.layout.view_horizontal_station, this);
        this.contain = (LinearLayout) findViewById(R.id.container);
    }

    public void setStations(List<String> list) {
        this.stations = list;
        for (int i = 0; i < list.size(); i++) {
            final StationTabCell stationTabCell = new StationTabCell(getContext());
            stationTabCell.setTabName(list.get(i));
            stationTabCell.setIndex(i);
            stationTabCell.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.widget.HorizontalScrollStationView.AnonymousClass1 */

                public void onClick(View view) {
                    if (HorizontalScrollStationView.this.selectedIndex != stationTabCell.getIndex()) {
                        stationTabCell.setSelected(true);
                        ((StationTabCell) HorizontalScrollStationView.this.contain.getChildAt(HorizontalScrollStationView.this.selectedIndex)).setSelected(false);
                        HorizontalScrollStationView.this.selectedIndex = stationTabCell.getIndex();
                    }
                }
            });
            this.contain.addView(stationTabCell);
            if (i == 0) {
                stationTabCell.setSelected(true);
            }
        }
    }
}
