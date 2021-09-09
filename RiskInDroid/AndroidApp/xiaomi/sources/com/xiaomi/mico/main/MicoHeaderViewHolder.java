package com.xiaomi.mico.main;

import _m_j.fno;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;

public class MicoHeaderViewHolder extends RecyclerView.O000OOo0 {
    @BindView(6578)
    ImageView mCancleView;
    @BindView(6539)
    SimpleDraweeView mSoundImageView;
    @BindView(6560)
    TextView name;
    @BindView(6948)
    TextView roomNameOff;
    @BindView(6949)
    TextView roomNameOn;
    @BindView(6538)
    View view;

    public MicoHeaderViewHolder(View view2) {
        super(view2);
        ButterKnife.bind(this, view2);
    }

    public void bindView(Resources resources, Admin.Mico mico, String str) {
        if (mico != null) {
            if (mico.isOnline()) {
                this.mSoundImageView.setAlpha(1.0f);
                this.name.setAlpha(1.0f);
                this.name.setAlpha(1.0f);
            } else {
                this.name.setAlpha(0.3f);
                this.roomNameOn.setAlpha(0.3f);
                this.mSoundImageView.setAlpha(0.3f);
            }
            if (!TextUtils.isEmpty(mico.miotDID)) {
                Device O000000o2 = fno.O000000o().O000000o(mico.miotDID);
                if (O000000o2 != null) {
                    DeviceFactory.O00000Oo(O000000o2.model, this.mSoundImageView);
                } else if (mico.getHardwareType() != null) {
                    this.mSoundImageView.setImageResource(mico.getHardwareType().getMenuIcon());
                } else {
                    this.mSoundImageView.setImageResource(R.drawable.mico_icon_lx06_menu);
                }
            } else if (mico.getHardwareType() != null) {
                this.mSoundImageView.setImageResource(mico.getHardwareType().getMenuIcon());
            } else {
                this.mSoundImageView.setImageResource(R.drawable.mico_icon_lx06_menu);
            }
            this.name.setText(mico.getDisplayName());
            if (TextUtils.isEmpty(str)) {
                this.roomNameOn.setVisibility(8);
                this.roomNameOff.setVisibility(8);
            } else if (mico.isOnline()) {
                this.roomNameOn.setVisibility(0);
                this.roomNameOff.setVisibility(8);
                this.roomNameOn.setText("-".concat(String.valueOf(str)));
            } else {
                this.roomNameOn.setVisibility(8);
                this.roomNameOff.setVisibility(0);
                this.roomNameOff.setText("-".concat(String.valueOf(str)));
            }
        }
    }
}
