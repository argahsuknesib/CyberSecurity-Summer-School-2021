package com.xiaomi.mico.music.player.multiroom;

import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.DeviceState;
import com.xiaomi.mico.api.model.StereoData;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiRoomDeviceAdapter extends RecyclerView.O000000o<DeviceViewHolder> {
    private Context mContext;
    public boolean mItemClickEnable = true;
    public List<DeviceState> mList;
    public OnItemClickListener mOnItemClickListener;
    public List<DeviceState> selectList;

    public interface OnItemClickListener {
        void onItemClicked(DeviceState deviceState, int i, List<DeviceState> list);
    }

    public MultiRoomDeviceAdapter(Context context) {
        this.mContext = context;
    }

    public void setList(List<DeviceState> list) {
        this.mList = list;
        boolean z = false;
        for (DeviceState next : list) {
            if (next.select) {
                if (isL16A(next)) {
                    z = true;
                }
                if (this.selectList == null) {
                    this.selectList = new ArrayList();
                }
                this.selectList.add(next);
            }
        }
        if (z) {
            for (DeviceState next2 : this.mList) {
                if (!isL16A(next2)) {
                    next2.isEnable = false;
                }
            }
        }
    }

    public List<DeviceState> getList() {
        return this.mList;
    }

    public void setItemClickEnable(boolean z) {
        this.mItemClickEnable = z;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        this.selectList = new ArrayList();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public DeviceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final DeviceViewHolder deviceViewHolder = new DeviceViewHolder(LayoutInflater.from(this.mContext).inflate((int) R.layout.mico_item_multi_room_device, viewGroup, false));
        deviceViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.player.multiroom.MultiRoomDeviceAdapter.AnonymousClass1 */

            public void onClick(View view) {
                if (!MultiRoomDeviceAdapter.this.mItemClickEnable) {
                    ToastUtil.showToast("需要先点击确定按钮，删除脏数据旧组合");
                    return;
                }
                int adapterPosition = deviceViewHolder.getAdapterPosition();
                if (adapterPosition != -1) {
                    DeviceState deviceState = MultiRoomDeviceAdapter.this.mList.get(adapterPosition);
                    if (deviceState.isEnable) {
                        boolean isL16A = MultiRoomDeviceAdapter.this.isL16A(deviceState);
                        gsy.O00000o0(LogType.MICO, "", " enableL16a ".concat(String.valueOf(isL16A)));
                        Iterator<DeviceState> it = MultiRoomDeviceAdapter.this.mList.iterator();
                        while (true) {
                            boolean z = true;
                            if (!it.hasNext()) {
                                break;
                            }
                            DeviceState next = it.next();
                            if (isL16A) {
                                z = MultiRoomDeviceAdapter.this.isL16A(next);
                            } else if (MultiRoomDeviceAdapter.this.isL16A(next)) {
                                z = false;
                            }
                            next.isEnable = z;
                            LogType logType = LogType.MICO;
                            gsy.O00000o0(logType, "", "device.isEnable " + next.isEnable);
                        }
                        deviceState.select = !deviceState.select;
                        if (deviceState.select) {
                            MultiRoomDeviceAdapter.this.selectList.add(deviceState);
                        } else {
                            MultiRoomDeviceAdapter.this.selectList.remove(deviceState);
                        }
                        if (MultiRoomDeviceAdapter.this.selectList.isEmpty()) {
                            for (DeviceState deviceState2 : MultiRoomDeviceAdapter.this.mList) {
                                deviceState2.isEnable = true;
                            }
                        }
                        MultiRoomDeviceAdapter.this.notifyItemChanged(adapterPosition);
                        if (MultiRoomDeviceAdapter.this.mOnItemClickListener != null) {
                            MultiRoomDeviceAdapter.this.mOnItemClickListener.onItemClicked(deviceState, adapterPosition, MultiRoomDeviceAdapter.this.selectList);
                        }
                    }
                }
            }
        });
        return deviceViewHolder;
    }

    public void onBindViewHolder(DeviceViewHolder deviceViewHolder, int i) {
        Hardware hardware;
        Hardware hardware2;
        DeviceState deviceState = this.mList.get(i);
        deviceViewHolder.nameTv.setText(deviceState.deviceName);
        deviceViewHolder.selectIv.setImageResource(deviceState.select ? R.drawable.mj_webp_widget_checkbox_pres : R.drawable.mj_webp_widget_checkbox_uncheck_pres);
        deviceViewHolder.nameTv.setTextColor(this.mContext.getResources().getColor(deviceState.select ? R.color.mj_color_green_normal : R.color.mj_color_black));
        if (TextUtils.isEmpty(deviceState.stereoJson)) {
            Hardware safeValueOf = Hardware.safeValueOf(deviceState.hardware.toUpperCase());
            if (safeValueOf == Hardware.LX06) {
                deviceViewHolder.iconIv.setImageResource(R.drawable.mico_icon_stereo_lx06);
            } else if (safeValueOf == Hardware.L06A) {
                deviceViewHolder.iconIv.setImageResource(R.drawable.mico_icon_stereo_lx06a);
            } else if (safeValueOf == Hardware.L09A) {
                deviceViewHolder.iconIv.setImageResource(R.drawable.mico_icon_stereo_lx09a);
            } else if (safeValueOf == Hardware.L09B) {
                deviceViewHolder.iconIv.setImageResource(R.drawable.mico_icon_stereo_l09b);
            } else if (safeValueOf == Hardware.L15A) {
                deviceViewHolder.iconIv.setImageResource(R.drawable.mico_icon_stereo_l15a);
            } else if (safeValueOf == Hardware.L16A) {
                deviceViewHolder.iconIv.setImageResource(R.drawable.mico_icon_stereo_l16a);
            }
        } else {
            StereoData.StereoGroup stereoGroup = MicoManager.getInstance().getStereoGroup(deviceState.stereoJson);
            if (stereoGroup != null) {
                if (TextUtils.isEmpty(stereoGroup.leftDeviceHardware)) {
                    hardware = Hardware.LX06;
                } else {
                    hardware = Hardware.safeValueOf(stereoGroup.leftDeviceHardware.toUpperCase());
                }
                if (TextUtils.isEmpty(stereoGroup.rightDeviceHardware)) {
                    hardware2 = Hardware.LX06;
                } else {
                    hardware2 = Hardware.safeValueOf(stereoGroup.rightDeviceHardware.toUpperCase());
                }
                if (hardware == Hardware.LX06 && hardware2 == Hardware.LX06) {
                    deviceViewHolder.iconIv.setImageResource(R.drawable.mico_image_group_stereo_a);
                } else if (hardware == Hardware.L06A && hardware2 == Hardware.L06A) {
                    deviceViewHolder.iconIv.setImageResource(R.drawable.mico_image_group_stereo_c);
                } else if (hardware == Hardware.L09A && hardware2 == Hardware.L09A) {
                    deviceViewHolder.iconIv.setImageResource(R.drawable.mico_image_group_stereo_d);
                } else if (hardware == Hardware.L09B && hardware2 == Hardware.L09B) {
                    deviceViewHolder.iconIv.setImageResource(R.drawable.mico_image_stereo_group_l09b);
                } else if (hardware == Hardware.L15A && hardware2 == Hardware.L15A) {
                    deviceViewHolder.iconIv.setImageResource(R.drawable.mico_image_stereo_group_l15a);
                } else if (hardware == Hardware.L16A && hardware2 == Hardware.L16A) {
                    deviceViewHolder.iconIv.setImageResource(R.drawable.mico_image_stereo_group_l16a);
                } else {
                    deviceViewHolder.iconIv.setImageResource(R.drawable.mico_image_group_stereo_b);
                }
            }
        }
        LogType logType = LogType.MICO;
        gsy.O00000o0(logType, "", "isEnable setAlpha " + deviceState.isEnable);
        if (deviceState.isEnable) {
            deviceViewHolder.itemView.setAlpha(1.0f);
        } else {
            deviceViewHolder.itemView.setAlpha(0.4f);
        }
        deviceViewHolder.itemView.setTag(R.id.mico_tag_item_data, deviceState);
    }

    public int getItemCount() {
        return ContainerUtil.getSize(this.mList);
    }

    class DeviceViewHolder extends RecyclerView.O000OOo0 {
        public ImageView iconIv;
        public TextView nameTv;
        ImageView selectIv;

        public DeviceViewHolder(View view) {
            super(view);
            this.nameTv = (TextView) view.findViewById(R.id.name);
            this.iconIv = (ImageView) view.findViewById(R.id.device_icon);
            this.selectIv = (ImageView) view.findViewById(R.id.status);
        }
    }

    public boolean isL16A(DeviceState deviceState) {
        return Hardware.safeValueOf(deviceState.hardware.toUpperCase()) == Hardware.L16A;
    }
}
