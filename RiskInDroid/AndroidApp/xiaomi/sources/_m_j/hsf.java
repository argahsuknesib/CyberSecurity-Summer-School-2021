package _m_j;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.miot.DeviceInfo;
import com.xiaomi.miot.DeviceInfo2;
import com.xiaomi.miot.DeviceShowInfo;
import com.xiaomi.miot.service.ICallback;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class hsf extends hse {
    private final boolean O00000o;
    private final boolean O00000o0;

    public hsf(ICallback iCallback, boolean z, boolean z2, boolean z3) {
        super(iCallback, z);
        this.O00000o0 = z2;
        this.O00000o = z3;
    }

    public hsf(ICallback iCallback, boolean z, boolean z2) {
        this(iCallback, z, z2, false);
    }

    public final void O000000o(List<GridViewData> list) {
        try {
            Bundle bundle = new Bundle();
            ArrayList<? super Parcelable> O00000Oo = O00000Oo(list);
            if (O00000Oo.size() > 0) {
                bundle.setClassLoader(DeviceInfo.class.getClassLoader());
                bundle.putString("current_uid", CoreApi.O000000o().O0000o0());
                bundle.putParcelableArrayList("device_infos", O00000Oo);
                LogType logType = LogType.DEVICE_CONTROL;
                gsy.O00000o0(logType, "GetDeviceTask", "notify success cache return" + O00000Oo.size() + "  " + O00000Oo);
                if (this.f586O000000o != null) {
                    this.f586O000000o.onSuccess(bundle);
                    return;
                }
                return;
            }
            gsy.O00000o0(LogType.DEVICE_CONTROL, "GetDeviceTask", "notify success cache return  onFailure viewData:".concat(String.valueOf(O00000Oo)));
            bundle.putInt("error_code", 4);
            if (this.f586O000000o != null) {
                this.f586O000000o.onFailure(bundle);
            }
        } catch (Throwable th) {
            gsy.O00000o0(LogType.CARD, "GetDeviceTask", Log.getStackTraceString(th));
        }
    }

    public static DeviceInfo O000000o(GridViewData gridViewData, boolean z) {
        if (gridViewData.f8988O000000o != GridViewData.GridType.TYPE_IR) {
            return O000000o(gridViewData.O00000Oo, gridViewData.O00000o0, z);
        }
        DeviceInfo deviceInfo2 = z ? new DeviceInfo2() : new DeviceInfo();
        deviceInfo2.f6032O000000o = fml.O000000o();
        deviceInfo2.O0000O0o = true;
        deviceInfo2.O00000Oo = ServiceApplication.getAppContext().getString(R.string.phone_ir_device);
        int O00000o02 = fqw.O00000o0(ServiceApplication.getAppContext());
        deviceInfo2.O00000oO = ServiceApplication.getAppContext().getResources().getQuantityString(R.plurals.ir_device_count, O00000o02, Integer.valueOf(O00000o02));
        return deviceInfo2;
    }

    public static DeviceShowInfo O000000o(GridViewData gridViewData) {
        if (gridViewData.f8988O000000o == GridViewData.GridType.TYPE_IR) {
            DeviceShowInfo deviceShowInfo = new DeviceShowInfo();
            deviceShowInfo.f6033O000000o = fml.O000000o();
            deviceShowInfo.O0000O0o = true;
            deviceShowInfo.O00000Oo = ServiceApplication.getAppContext().getString(R.string.phone_ir_device);
            int O00000o02 = fqw.O00000o0(ServiceApplication.getAppContext());
            deviceShowInfo.O00000oO = ServiceApplication.getAppContext().getResources().getQuantityString(R.plurals.ir_device_count, O00000o02, Integer.valueOf(O00000o02));
            return deviceShowInfo;
        }
        Device device = gridViewData.O00000Oo;
        String str = gridViewData.O00000o0;
        DeviceShowInfo deviceShowInfo2 = new DeviceShowInfo();
        deviceShowInfo2.O0000Oo = false;
        deviceShowInfo2.f6033O000000o = device.did;
        deviceShowInfo2.O00000Oo = str;
        deviceShowInfo2.O00000o = device.model;
        deviceShowInfo2.O0000OOo = false;
        deviceShowInfo2.O0000O0o = device.isOnlineAdvance();
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
        if (O00000oO != null) {
            deviceShowInfo2.O00000o0 = O00000oO.O0000o0();
            deviceShowInfo2.O00000oO = O000000o(device);
            ArrayList<Pair> deviceRenderData = faw.O00000o0().getDeviceRenderData(device, faw.O00000o0().getGridCard(device));
            if (deviceRenderData != null) {
                if (device.isOnline) {
                    int i = 0;
                    while (true) {
                        if (i >= deviceRenderData.size()) {
                            break;
                        }
                        Pair pair = deviceRenderData.get(i);
                        if (pair.first instanceof State) {
                            if (device.isSetPinCode == 0) {
                                if (State.NOR == pair.first) {
                                    deviceShowInfo2.O0000OOo = true;
                                    deviceShowInfo2.O0000Oo0 = false;
                                } else if (State.SELECTED == pair.first) {
                                    deviceShowInfo2.O0000OOo = true;
                                    deviceShowInfo2.O0000Oo0 = true;
                                }
                            }
                        } else if ((pair.first instanceof String) && (pair.second instanceof String)) {
                            deviceShowInfo2.O00000oo.add(pair);
                        }
                        i++;
                    }
                } else {
                    deviceShowInfo2.O00000oo.add(new Pair(ServiceApplication.getAppContext().getString(R.string.code_device_offline), ""));
                }
            }
        }
        return deviceShowInfo2;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    public static DeviceInfo O000000o(Device device, String str, boolean z) {
        DeviceInfo2 deviceInfo2;
        if (z) {
            DeviceInfo2 deviceInfo22 = new DeviceInfo2();
            deviceInfo22.O0000Oo = false;
            deviceInfo2 = deviceInfo22;
        } else {
            deviceInfo2 = new DeviceInfo();
        }
        deviceInfo2.f6032O000000o = device.did;
        deviceInfo2.O00000Oo = str;
        deviceInfo2.O00000o = device.model;
        deviceInfo2.O0000O0o = device.isOnlineAdvance();
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
        if (O00000oO != null) {
            deviceInfo2.O00000o0 = O00000oO.O0000o0();
            deviceInfo2.O00000oO = O000000o(device);
            ArrayList<Pair> deviceRenderData = faw.O00000o0().getDeviceRenderData(device, faw.O00000o0().getGridCard(device));
            if (deviceRenderData != null) {
                deviceInfo2.O00000oo = O000000o(device, deviceRenderData);
                Pair O000000o2 = gzt.O000000o(device, deviceRenderData);
                if (O000000o2 == null) {
                    deviceInfo2.O0000OOo = false;
                } else if (device.isSetPinCode == 0) {
                    if (State.NOR == O000000o2.first) {
                        deviceInfo2.O0000OOo = true;
                        deviceInfo2.O0000Oo0 = false;
                    } else if (State.SELECTED == O000000o2.first) {
                        deviceInfo2.O0000OOo = true;
                        deviceInfo2.O0000Oo0 = true;
                    } else {
                        deviceInfo2.O0000OOo = false;
                    }
                }
            }
        }
        return deviceInfo2;
    }

    private ArrayList<? super Parcelable> O00000Oo(List<GridViewData> list) {
        ArrayList<? super Parcelable> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        for (GridViewData next : list) {
            if (this.O00000o) {
                arrayList.add(O000000o(next));
            } else {
                arrayList.add(O000000o(next, this.O00000o0));
            }
        }
        return arrayList;
    }

    public static String O000000o(Device device) {
        if (device.property != null && !TextUtils.isEmpty(device.property.getString("device_list_switch_subtitle", ""))) {
            return device.property.getString("device_list_switch_subtitle", "");
        }
        String subtitleByDesc = DeviceRouterFactory.getDeviceWrapper().getSubtitleByDesc(device, ServiceApplication.getAppContext(), false);
        return TextUtils.isEmpty(subtitleByDesc) ? new fqq(device).O000000o(ServiceApplication.getAppContext(), false) : subtitleByDesc;
    }

    private static Bundle O000000o(Device device, ArrayList<Pair> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (device.isOnline) {
            Iterator<Pair> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                if ((next.first instanceof String) && next.second != null) {
                    bundle.putString((String) next.first, next.second.toString());
                }
            }
        } else {
            bundle.putString(ServiceApplication.getAppContext().getString(R.string.code_device_offline), "");
        }
        return bundle;
    }
}
