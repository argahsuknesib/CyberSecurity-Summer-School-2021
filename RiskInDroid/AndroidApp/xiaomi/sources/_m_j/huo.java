package _m_j;

import android.content.Context;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.Locale;

public final class huo implements huz {
    public final void addSmartHomeStatRecord(StatType statType, String str, String str2, String str3, boolean z) {
    }

    public final void addStatRecord(StatType statType, String str, String str2, String str3, String str4, boolean z) {
    }

    public final void downloadPlugin(String str, huh huh) {
    }

    public final String getCountryCode() {
        return "";
    }

    public final String getCountryDomain() {
        return "";
    }

    public final PluginDeviceInfo getExtraPluginInfo(String str) {
        return null;
    }

    public final Locale getGlobalSettingLocale() {
        return null;
    }

    public final ServerBean getGlobalSettingServer() {
        return null;
    }

    public final String getGlobalSettingServerEnv() {
        return "";
    }

    public final huw getInstallInfo(String str) {
        return null;
    }

    public final String getMiId() {
        return "";
    }

    public final String getModelByProductId(int i) {
        return null;
    }

    public final PluginDeviceInfo getPluginInfo(String str) {
        return null;
    }

    public final void isCoreReady(Context context, hug hug) {
    }

    public final boolean isInternationalServer() {
        return false;
    }

    public final boolean isMiLoggedIn() {
        return false;
    }

    public final IBleChannelWriter registerSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
        return null;
    }

    public final void setScanTimePeriod(int i) {
    }

    public final void startScan(int i, huf huf) {
    }

    public final void startScanWithModel(String str, huf huf) {
    }

    public final void stopScan() {
    }

    public final void stopSearchBluetoothDevice() {
    }

    public final void unRegisterSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
    }
}
