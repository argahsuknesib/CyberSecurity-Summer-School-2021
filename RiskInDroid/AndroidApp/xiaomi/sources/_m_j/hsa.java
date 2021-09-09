package _m_j;

import android.content.Intent;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.List;

@RouterService
public class hsa implements fae {
    private static final hsa INSTANCE = new hsa();
    private boolean mNofity;

    @cug
    public static hsa provideInstance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hsf.O000000o(com.xiaomi.smarthome.homeroom.model.GridViewData, boolean):com.xiaomi.miot.DeviceInfo
     arg types: [com.xiaomi.smarthome.homeroom.model.GridViewData, int]
     candidates:
      _m_j.hsf.O000000o(com.xiaomi.smarthome.device.Device, java.util.ArrayList<android.util.Pair>):android.os.Bundle
      _m_j.hsf.O000000o(com.xiaomi.smarthome.homeroom.model.GridViewData, boolean):com.xiaomi.miot.DeviceInfo */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void sendBrodCard(String str) {
        List<GridViewData> list;
        LogType logType = LogType.CARD;
        gsy.O00000o0(logType, "AssistantApiImpl", "sendBrodCard " + str + " notify " + this.mNofity);
        if (str != null && this.mNofity) {
            if (far.O000000o().O00000Oo()) {
                list = far.O000000o().O00000o0();
            } else {
                list = ggb.O00000Oo().O0000o0();
            }
            for (GridViewData gridViewData : list) {
                if (gridViewData.f8988O000000o == GridViewData.GridType.TYPE_NORMAL && gridViewData.O00000Oo.did.equals(str)) {
                    Intent intent = new Intent();
                    intent.setAction("com.xiaomi.smarthome.refresh_device");
                    intent.putExtra("current_uid", CoreApi.O000000o().O0000o0());
                    intent.putExtra("device_infos", hsf.O000000o(gridViewData, false));
                    intent.putExtra("device_show_infos", hsf.O000000o(gridViewData));
                    intent.putExtra("fileter_key", false);
                    CommonApplication.getAppContext().sendBroadcast(intent);
                    return;
                }
            }
        }
    }

    public void notifyEnable(boolean z) {
        this.mNofity = z;
        gsy.O00000o0(LogType.CARD, "AssistantApiImpl", "notifyEnable ".concat(String.valueOf(z)));
    }

    public boolean isEnableMiuiWidgetMemoryOpt() {
        return far.O000000o().O00000Oo();
    }

    public List<GridViewData> getMiuiCacheDeviceList() {
        return far.O000000o().O00000o0();
    }

    public String getRoomNameByDid(String str) {
        return far.O000000o().O00000Oo.get(str);
    }

    public String getHomeNameByDid(String str) {
        return far.O000000o().O00000o0.get(str);
    }
}
