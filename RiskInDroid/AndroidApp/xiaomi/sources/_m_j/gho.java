package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.library.log.LogType;

@RouterService
public class gho implements eyb {
    public void doSmartHomeJumper(Activity activity, Intent intent) {
        fvf fvf;
        Uri data = intent.getData();
        if (data != null) {
            hxj hxj = hxi.f950O000000o;
            hxj.f951O000000o.O00000Oo("entry_uri", data.toString(), new Object[0]);
            fvb fvb = (fvb) fbs.O000000o(fvb.class, "com.xiaomi.smarthome.framework.navigate.IUriJumperApi");
            if (fvb != null) {
                fvf = fvb.getUriJumper(activity);
            } else {
                gsy.O00000o0(LogType.SERIOUS_EXCEPTION, "SmartHomeJumper", "uri jumper is null");
                fvf = new fve(activity);
            }
        } else {
            fvf = new fve(activity);
        }
        if (fvf != null) {
            fvf.O000000o(intent);
        }
    }
}
