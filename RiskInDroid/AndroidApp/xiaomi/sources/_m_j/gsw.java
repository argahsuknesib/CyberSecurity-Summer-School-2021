package _m_j;

import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.library.log.LogType;

@RouterService
public class gsw implements gtu {
    private static final gsw INSTANCE = new gsw();

    @cug
    public static gsw provideInstance() {
        return INSTANCE;
    }

    public void writeLogOnAll(String str, String str2) {
        gsy.O00000o0(LogType.GENERAL, str, str2);
    }

    public void writeLogOnGrey(String str, String str2) {
        gsy.O00000Oo(LogType.GENERAL, str, str2);
    }

    public void writeLogOnAll(LogType logType, String str, String str2) {
        gsy.O00000o0(logType, str, str2);
    }

    public void writeLogOnGrey(LogType logType, String str, String str2) {
        gsy.O00000Oo(logType, str, str2);
    }
}
