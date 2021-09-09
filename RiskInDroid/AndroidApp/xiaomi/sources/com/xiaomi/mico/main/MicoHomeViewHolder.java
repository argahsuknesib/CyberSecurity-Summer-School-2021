package com.xiaomi.mico.main;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

public class MicoHomeViewHolder extends RecyclerView.O000OOo0 {
    TextView homeName;

    public MicoHomeViewHolder(View view) {
        super(view);
        this.homeName = (TextView) view.findViewById(R.id.mico_item_home);
    }
}
