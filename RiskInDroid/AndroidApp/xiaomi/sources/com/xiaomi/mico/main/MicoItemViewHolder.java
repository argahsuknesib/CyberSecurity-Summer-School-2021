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
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;

public class MicoItemViewHolder extends RecyclerView.O000OOo0 {
    @BindView(6559)
    ImageView indicator;
    @BindView(6562)
    ImageView mPlayStatusView;
    @BindView(6563)
    SimpleDraweeView mSoundImageView;
    @BindView(6560)
    TextView name;
    @BindView(6948)
    TextView roomNameOff;
    @BindView(6949)
    TextView roomNameOn;
    @BindView(6561)
    TextView tvOffline;
    @BindView(6557)
    View view;

    public MicoItemViewHolder(View view2) {
        super(view2);
        ButterKnife.bind(this, view2);
    }

    public void bindView(Resources resources, Admin.Mico mico, String str, String str2, String str3) {
        if (mico != null) {
            if (mico.deviceID.equals(str)) {
                this.indicator.setVisibility(0);
            } else {
                this.indicator.setVisibility(4);
            }
            if (mico.isOnline()) {
                this.name.setTextColor(resources.getColor(R.color.mj_color_black));
                this.mSoundImageView.setAlpha(1.0f);
                this.name.setAlpha(1.0f);
                this.roomNameOn.setTextColor(resources.getColor(R.color.mj_color_gray_lighter));
                this.name.setAlpha(1.0f);
                if (mico.deviceID.equals(str)) {
                    if (PlayerManager.getInstance().getPlayerStatus() == null || PlayerManager.getInstance().getPlayerStatus().status != 1) {
                        this.mPlayStatusView.setVisibility(8);
                    } else {
                        this.mPlayStatusView.setVisibility(0);
                    }
                    this.name.setTextColor(resources.getColor(R.color.mj_color_green_normal));
                    this.roomNameOn.setTextColor(resources.getColor(R.color.mj_color_green_normal));
                } else {
                    this.mPlayStatusView.setVisibility(8);
                }
                this.tvOffline.setVisibility(8);
            } else {
                this.name.setTextColor(resources.getColor(R.color.mj_color_black));
                this.name.setAlpha(0.3f);
                this.roomNameOn.setTextColor(resources.getColor(R.color.mj_color_gray_lighter));
                this.roomNameOn.setAlpha(0.3f);
                this.mSoundImageView.setAlpha(0.3f);
                this.mPlayStatusView.setVisibility(8);
                this.tvOffline.setVisibility(0);
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
            if (str2 == null) {
                this.roomNameOn.setVisibility(8);
                this.roomNameOff.setVisibility(8);
            } else if (mico.isOnline()) {
                this.roomNameOn.setVisibility(0);
                this.roomNameOff.setVisibility(8);
                TextView textView = this.roomNameOn;
                textView.setText(str3 + "-" + str2);
            } else {
                this.roomNameOn.setVisibility(8);
                this.roomNameOff.setVisibility(0);
                TextView textView2 = this.roomNameOff;
                textView2.setText(str3 + "-" + str2);
            }
        }
    }
}
