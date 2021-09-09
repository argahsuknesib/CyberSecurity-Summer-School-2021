package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;

public interface faz<E extends hcc.O000000o<T>, T> extends gze {
    hcc<E, T> getActivityCard(Device device);

    Pair<State, String> getButtonDrawable(Device device, int i, hcc.O000000o<T> o000000o, boolean z);

    ArrayList<Long> getDeviceDataUpdateTime(Device device);

    ArrayList<Pair> getDeviceRenderData(Device device, hcc<E, T> hcc);

    hcc<E, T> getGridCard(Device device);

    boolean isSameCard(Device device);

    void toggleButton(Device device, int i, hcc.O000000o<T> o000000o, fsm<Void, fso> fsm);
}
