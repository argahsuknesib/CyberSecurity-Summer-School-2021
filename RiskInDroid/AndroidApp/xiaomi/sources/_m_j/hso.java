package _m_j;

import java.util.List;
import org.json.JSONObject;

public interface hso {
    fsn authV2(String str, String str2, String str3, String str4, String str5, fsm fsm);

    void checkPrivacy(int i, String str, fsm<? super JSONObject, fso> fsm);

    void clear();

    fsn deleteAuthV2(List<String> list, fsm fsm);

    String getAuthAppId();

    String getAuthAppName();

    fsn getAuthV2(fsm fsm);

    void handleAuthFail(int i);

    void handleAuthSuccess(int i);

    void setAppId(String str);

    void setAppSign(String str);

    void setPackageName(String str);
}
