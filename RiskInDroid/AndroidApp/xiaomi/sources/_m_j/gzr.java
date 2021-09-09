package _m_j;

import android.app.Activity;
import android.graphics.RectF;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.adapter.DviceEditInterface;

public interface gzr {
    void enterEditMode(DviceEditInterface dviceEditInterface);

    void exitEditMode();

    Activity getActivity();

    void onClickCommonUseDevice(Device device, RectF rectF, String str);

    void onStateChanged();

    void updateActionItems(DviceEditInterface dviceEditInterface, int i);
}
