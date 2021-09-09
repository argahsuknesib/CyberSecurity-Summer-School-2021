package com.xiaomi.mico.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class MicoHeaderViewHolder_ViewBinding implements Unbinder {
    private MicoHeaderViewHolder target;

    public MicoHeaderViewHolder_ViewBinding(MicoHeaderViewHolder micoHeaderViewHolder, View view) {
        this.target = micoHeaderViewHolder;
        micoHeaderViewHolder.view = Utils.findRequiredView(view, R.id.mico_header_item, "field 'view'");
        micoHeaderViewHolder.name = (TextView) Utils.findRequiredViewAsType(view, R.id.mico_item_name, "field 'name'", TextView.class);
        micoHeaderViewHolder.roomNameOff = (TextView) Utils.findRequiredViewAsType(view, R.id.room_name_off, "field 'roomNameOff'", TextView.class);
        micoHeaderViewHolder.roomNameOn = (TextView) Utils.findRequiredViewAsType(view, R.id.room_name_on, "field 'roomNameOn'", TextView.class);
        micoHeaderViewHolder.mSoundImageView = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.mico_header_sound, "field 'mSoundImageView'", SimpleDraweeView.class);
        micoHeaderViewHolder.mCancleView = (ImageView) Utils.findRequiredViewAsType(view, R.id.mico_pop_close, "field 'mCancleView'", ImageView.class);
    }

    public void unbind() {
        MicoHeaderViewHolder micoHeaderViewHolder = this.target;
        if (micoHeaderViewHolder != null) {
            this.target = null;
            micoHeaderViewHolder.view = null;
            micoHeaderViewHolder.name = null;
            micoHeaderViewHolder.roomNameOff = null;
            micoHeaderViewHolder.roomNameOn = null;
            micoHeaderViewHolder.mSoundImageView = null;
            micoHeaderViewHolder.mCancleView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
