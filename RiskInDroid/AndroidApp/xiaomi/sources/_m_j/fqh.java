package _m_j;

import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.List;

@RouterService
public class fqh implements fmn {
    private static final fqh INSTANCE = new fqh();

    @cug
    public static fqh provideInstance() {
        return INSTANCE;
    }

    private fqh() {
    }

    public List<ScanResult> getDiscoveredUnconnectDevice() {
        return flw.O000000o().f16591O000000o;
    }

    public void changeScanResultToOnline(ScanResult scanResult) {
        flw.O000000o().O000000o(scanResult);
    }

    public ScanResult getDeviceScanResult(String str) {
        return flw.O000000o().O000000o(str);
    }

    public void registerReceiver() {
        flw O000000o2 = flw.O000000o();
        ft.O000000o(CommonApplication.getAppContext()).O000000o(O000000o2.O00000o, new IntentFilter("wifi_scan_device"));
        CommonApplication.getAppContext().registerReceiver(O000000o2.O00000o, new IntentFilter("android.net.wifi.STATE_CHANGE"));
    }

    public void unregisterReceiver() {
        flw O000000o2 = flw.O000000o();
        try {
            ft.O000000o(CommonApplication.getAppContext()).O000000o(O000000o2.O00000o);
            CommonApplication.getAppContext().unregisterReceiver(O000000o2.O00000o);
        } catch (Exception unused) {
        }
    }
}
