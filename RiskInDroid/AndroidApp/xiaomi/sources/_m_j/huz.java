package _m_j;

import android.content.Context;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.Locale;

public interface huz {
    void addSmartHomeStatRecord(StatType statType, String str, String str2, String str3, boolean z);

    void addStatRecord(StatType statType, String str, String str2, String str3, String str4, boolean z);

    void downloadPlugin(String str, huh huh);

    String getCountryCode();

    String getCountryDomain();

    PluginDeviceInfo getExtraPluginInfo(String str);

    Locale getGlobalSettingLocale();

    ServerBean getGlobalSettingServer();

    String getGlobalSettingServerEnv();

    huw getInstallInfo(String str);

    String getMiId();

    String getModelByProductId(int i);

    PluginDeviceInfo getPluginInfo(String str);

    void isCoreReady(Context context, hug hug);

    boolean isInternationalServer();

    boolean isMiLoggedIn();

    IBleChannelWriter registerSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException;

    void setScanTimePeriod(int i);

    void startScan(int i, huf huf);

    void startScanWithModel(String str, huf huf);

    void stopScan();

    void stopSearchBluetoothDevice();

    void unRegisterSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException;
}
