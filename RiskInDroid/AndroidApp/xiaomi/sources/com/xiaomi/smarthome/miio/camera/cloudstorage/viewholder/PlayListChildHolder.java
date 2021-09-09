package com.xiaomi.smarthome.miio.camera.cloudstorage.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

public class PlayListChildHolder extends RecyclerView.O000OOo0 {
    public CheckBox cbEdit;
    public ImageView ivHuman;
    public ImageView ivImage;
    public ImageView ivPlaying;
    public RelativeLayout rlItemContainer;
    public TextView tvDuration;
    public TextView tvStartTime;

    public PlayListChildHolder(View view) {
        super(view);
        this.ivImage = (ImageView) view.findViewById(R.id.ivImage);
        this.tvDuration = (TextView) view.findViewById(R.id.tvDuration);
        this.tvStartTime = (TextView) view.findViewById(R.id.tvStartTime);
        this.ivPlaying = (ImageView) view.findViewById(R.id.ivPlaying);
        this.cbEdit = (CheckBox) view.findViewById(R.id.cbEdit);
    }

    public String toString() {
        return super.toString();
    }
}
