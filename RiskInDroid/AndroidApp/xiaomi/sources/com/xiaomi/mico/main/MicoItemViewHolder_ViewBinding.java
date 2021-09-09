package com.xiaomi.mico.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class MicoItemViewHolder_ViewBinding implements Unbinder {
    private MicoItemViewHolder target;

    public MicoItemViewHolder_ViewBinding(MicoItemViewHolder micoItemViewHolder, View view) {
        this.target = micoItemViewHolder;
        micoItemViewHolder.view = Utils.findRequiredView(view, R.id.mico_item, "field 'view'");
        micoItemViewHolder.indicator = (ImageView) Utils.findRequiredViewAsType(view, R.id.mico_item_indicator, "field 'indicator'", ImageView.class);
        micoItemViewHolder.name = (TextView) Utils.findRequiredViewAsType(view, R.id.mico_item_name, "field 'name'", TextView.class);
        micoItemViewHolder.roomNameOff = (TextView) Utils.findRequiredViewAsType(view, R.id.room_name_off, "field 'roomNameOff'", TextView.class);
        micoItemViewHolder.roomNameOn = (TextView) Utils.findRequiredViewAsType(view, R.id.room_name_on, "field 'roomNameOn'", TextView.class);
        micoItemViewHolder.mPlayStatusView = (ImageView) Utils.findRequiredViewAsType(view, R.id.mico_item_playstatus, "field 'mPlayStatusView'", ImageView.class);
        micoItemViewHolder.mSoundImageView = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.mico_item_sound, "field 'mSoundImageView'", SimpleDraweeView.class);
        micoItemViewHolder.tvOffline = (TextView) Utils.findRequiredViewAsType(view, R.id.mico_item_offline, "field 'tvOffline'", TextView.class);
    }

    public void unbind() {
        MicoItemViewHolder micoItemViewHolder = this.target;
        if (micoItemViewHolder != null) {
            this.target = null;
            micoItemViewHolder.view = null;
            micoItemViewHolder.indicator = null;
            micoItemViewHolder.name = null;
            micoItemViewHolder.roomNameOff = null;
            micoItemViewHolder.roomNameOn = null;
            micoItemViewHolder.mPlayStatusView = null;
            micoItemViewHolder.mSoundImageView = null;
            micoItemViewHolder.tvOffline = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
