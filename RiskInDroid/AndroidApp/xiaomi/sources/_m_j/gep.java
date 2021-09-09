package _m_j;

import com.sankuai.waimai.router.annotation.RouterService;
import org.json.JSONObject;

@RouterService
public class gep extends gdy {
    private static final gep INSTANCE = new gep();

    @cug
    public static gep provideInstance() {
        return INSTANCE;
    }

    public boolean onReceiveMessage(String str, String str2) {
        processMessage(str2);
        return true;
    }

    private void processMessage(String str) {
        try {
            new JSONObject(str);
        } catch (Exception unused) {
        }
    }
}
