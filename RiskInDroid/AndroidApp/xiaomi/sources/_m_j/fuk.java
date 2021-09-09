package _m_j;

import android.content.Context;
import android.net.Uri;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity;

@RouterService
public class fuk implements hmp {
    private static final fuk INSTANCE = new fuk();

    @cug
    public static fuk provideInstance() {
        return INSTANCE;
    }

    public boolean checkShouldOpenWearablesActivity(Uri uri) {
        fxc.O000000o();
        return fxc.O000000o(uri);
    }

    public void startWearablesScanActivity(Context context, Uri uri) {
        WearablesScanActivity.startActivity(context, uri);
    }

    public void destroySmartHomeMainActivity() {
        fxc.O000000o().f17362O000000o = false;
    }

    public Uri getWearablesUri() {
        return fxc.O000000o().O00000Oo;
    }

    public void startSmartHomeMainActivity() {
        fxc.O000000o().f17362O000000o = true;
    }

    public boolean isSmartHomeMainActivityLaunch() {
        return fxc.O000000o().f17362O000000o;
    }
}
