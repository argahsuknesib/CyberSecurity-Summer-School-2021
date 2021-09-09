package com.xiaomi.smarthome.miio.camera.cloudstorage;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

public class CloudVideoListViewHolder extends RecyclerView.O000OOo0 {
    private CheckBox cbEdit;
    private ImageView ivImage;
    private ImageView ivPlaying;
    private RelativeLayout rlItemContainer;
    private TextView tvDuration;
    private TextView tvStartTime;

    public CloudVideoListViewHolder(View view) {
        super(view);
        this.rlItemContainer = (RelativeLayout) view.findViewById(R.id.rlItemContainer);
        this.tvDuration = (TextView) view.findViewById(R.id.tvDuration);
        this.ivImage = (ImageView) view.findViewById(R.id.ivImage);
        this.tvStartTime = (TextView) view.findViewById(R.id.tvStartTime);
        this.ivPlaying = (ImageView) view.findViewById(R.id.ivPlaying);
        this.cbEdit = (CheckBox) view.findViewById(R.id.cbEdit);
    }

    public String toString() {
        return super.toString();
    }
}
