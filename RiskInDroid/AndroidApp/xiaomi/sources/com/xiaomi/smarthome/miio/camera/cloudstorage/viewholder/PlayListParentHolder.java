package com.xiaomi.smarthome.miio.camera.cloudstorage.viewholder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

public class PlayListParentHolder extends RecyclerView.O000OOo0 {
    public RelativeLayout rlItemContainer;
    public TextView tvTitle;

    public PlayListParentHolder(View view) {
        super(view);
        this.rlItemContainer = (RelativeLayout) view.findViewById(R.id.rlItemContainer);
        this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
    }

    public String toString() {
        return super.toString();
    }
}
