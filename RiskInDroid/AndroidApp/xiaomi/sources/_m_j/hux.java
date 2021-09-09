package _m_j;

import android.net.wifi.ScanResult;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.ArrayList;

@RouterService
public class hux implements htw {
    public int getTimeLen() {
        return 50000;
    }

    public void init() {
        htk.O000000o();
    }

    public void setCurrentScrollToDid(String str) {
        htk.O000000o();
        htk.O00000Oo(str);
    }

    public void stopScanNewDevice() {
        htk.O000000o().O00000Oo();
    }

    public void stopScanNewDevice4Timeout(hto hto) {
        htk.O000000o().O000000o(hto);
    }

    public boolean scanNewDevice(hto hto, long j, htl htl) {
        return htk.O000000o().O000000o(hto, j, htl);
    }

    public boolean scanNewDevice(htl htl, String str, String str2, String str3, String str4, String str5, long j) {
        return htk.O000000o().O000000o(htl, str, str2, str4, str5, j);
    }

    public boolean isFindingNew() {
        return htk.O000000o().O00000o;
    }

    public void setApChildErrorCode(String str, int i) {
        htk.O000000o().O000000o(str, i);
    }

    public void resetFinder() {
        htk.O000000o().O00000o();
    }

    public void cleanScrollToDid() {
        htk.O000000o();
        gjn.O000000o().O0000OOo();
    }

    public ArrayList<ScanResult> getWifiScanResult() {
        return iae.O00000o0;
    }

    public void startScan(int i) {
        SmartConfigRouterFactory.getCoreApiManager().startScan(i, new huf() {
            /* class _m_j.iaf.AnonymousClass1 */

            public final void accept(final String str) {
                iaf.this.f1081O000000o.post(new Runnable() {
                    /* class _m_j.iaf.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        iaf.O00000Oo(str);
                    }
                });
            }
        });
    }

    public void startScan() {
        iaf.O000000o().O00000Oo();
    }

    public hun createWifiDeviceFinder() {
        return new iae();
    }
}
