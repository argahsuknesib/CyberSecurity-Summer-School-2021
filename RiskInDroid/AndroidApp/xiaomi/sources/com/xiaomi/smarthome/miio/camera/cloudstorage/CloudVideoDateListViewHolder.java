package com.xiaomi.smarthome.miio.camera.cloudstorage;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

public class CloudVideoDateListViewHolder extends RecyclerView.O000OOo0 {
    private TextView tvDay;
    private TextView tvMonth;

    public CloudVideoDateListViewHolder(View view) {
        super(view);
        this.tvDay = (TextView) view.findViewById(R.id.tvDay);
        this.tvMonth = (TextView) view.findViewById(R.id.tvMonth);
    }

    public String toString() {
        return super.toString();
    }
}
