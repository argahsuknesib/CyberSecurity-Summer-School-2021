package _m_j;

import com.xiaomi.smarthome.homeroom.model.GridViewData;
import java.util.List;

public interface fae extends gze {
    String getHomeNameByDid(String str);

    List<GridViewData> getMiuiCacheDeviceList();

    String getRoomNameByDid(String str);

    boolean isEnableMiuiWidgetMemoryOpt();

    void notifyEnable(boolean z);

    void sendBrodCard(String str);
}
