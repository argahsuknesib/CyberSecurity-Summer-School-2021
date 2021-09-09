package _m_j;

import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.bluetooth.XmBluetoothSearchManager;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.device.bluetooth.search.BluetoothSearchManager$2;
import com.xiaomi.smarthome.frame.plugin.host.PluginBluetoothSearchManagerHostApi;
import java.util.UUID;

@Deprecated
public final class fph extends PluginBluetoothSearchManagerHostApi {
    public final void startScanBluetooth(final XmBluetoothSearchManager.BluetoothHandler bluetoothHandler) {
        if (bluetoothHandler != null) {
            startScanBluetooth(new XmBluetoothSearchManager.XmBluetoothSearchRequest(bluetoothHandler), new XmBluetoothSearchManager.XmBluetoothSearchResponse() {
                /* class _m_j.fph.AnonymousClass1 */

                public final void onSearchStarted() {
                    try {
                        bluetoothHandler.onSearchStarted();
                    } catch (Throwable unused) {
                    }
                }

                public final void onDeviceFounded(XmBluetoothDevice xmBluetoothDevice) {
                    try {
                        bluetoothHandler.onDeviceFounded(xmBluetoothDevice);
                    } catch (Throwable unused) {
                    }
                }

                public final void onSearchStopped() {
                    try {
                        bluetoothHandler.onSearchStopped();
                    } catch (Throwable unused) {
                    }
                }

                public final void onSearchCanceled() {
                    try {
                        bluetoothHandler.onSearchStopped();
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        throw new NullPointerException("handler null");
    }

    public final void stopScanBluetooth(XmBluetoothSearchManager.BluetoothHandler bluetoothHandler) {
        gsy.O000000o(4, "stopScan", "BSM stop");
        fpo.O00000Oo();
    }

    public final void startScanBluetoothImmediately(XmBluetoothSearchManager.BluetoothHandler bluetoothHandler) {
        startScanBluetooth(bluetoothHandler);
    }

    public final void stopScanBluetooth() {
        gsy.O000000o(4, "stopScan", "BSM stop");
        fpo.O00000Oo();
    }

    public final void startScanBluetooth(XmBluetoothSearchManager.XmBluetoothSearchRequest xmBluetoothSearchRequest, XmBluetoothSearchManager.XmBluetoothSearchResponse xmBluetoothSearchResponse) {
        if (xmBluetoothSearchRequest == null || xmBluetoothSearchResponse == null) {
            throw new NullPointerException("request or response null");
        }
        SearchRequest.O000000o o000000o = new SearchRequest.O000000o();
        if (xmBluetoothSearchRequest.taskType == 1) {
            o000000o.O000000o(xmBluetoothSearchRequest.taskDuration, (UUID[]) null);
        } else if (xmBluetoothSearchRequest.taskType == 2) {
            o000000o.O000000o(xmBluetoothSearchRequest.taskDuration);
        } else {
            throw new IllegalArgumentException("invalid request type");
        }
        fpo.O000000o(o000000o.O000000o(), new BluetoothSearchManager$2(this, xmBluetoothSearchResponse));
    }
}
