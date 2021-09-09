package _m_j;

import android.app.Activity;
import android.content.Intent;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity;
import com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity;
import java.util.List;

@RouterService
public class ftv implements hmm {
    private static final ftv INSTANCE = new ftv();

    @cug
    public static ftv provideInstance() {
        return INSTANCE;
    }

    public Intent getShareLogFileIntent() {
        return fxj.O000000o();
    }

    public void checkRnConfigUpdate() {
        gat.O000000o();
    }

    public boolean isPluginRNActivity(Activity activity) {
        return activity instanceof PluginRNActivity;
    }

    public Class<?> getLoadingRNActivityClass() {
        return LoadingRNActivity.class;
    }

    public void downloadRnExtModules() {
        fxy.O000000o().O000000o((fkv<Integer, Integer>) null);
    }

    public List<String> getDelFolderPathBatch(List<String> list) {
        fwz.O000000o().O00000Oo();
        return fwy.O000000o(list);
    }

    public void delDataAfterDelDevice(List<String> list) {
        fwz.O000000o().O00000Oo();
        fwy.O00000Oo(list);
    }

    public String getQrDebugModePackageName() {
        fvw O000000o2 = fvw.O000000o();
        if (!O000000o2.f17292O000000o) {
            return null;
        }
        return O000000o2.O00000o0;
    }

    public boolean isDebugQRCode(String str) {
        fvw.O000000o();
        return fvw.O000000o(str);
    }

    public boolean isExperiencePluginQRCode(String str) {
        fvw.O000000o();
        return fvw.O00000Oo(str);
    }

    public void exitQRDebugMode() {
        fvw O000000o2 = fvw.O000000o();
        O000000o2.f17292O000000o = false;
        O000000o2.O00000Oo = null;
        O000000o2.O00000o0 = null;
    }

    public void initQrDebugMode(String str, String str2) {
        fvw O000000o2 = fvw.O000000o();
        O000000o2.f17292O000000o = true;
        O000000o2.O00000Oo = str;
        O000000o2.O00000o0 = str2;
    }
}
