package _m_j;

import android.app.Activity;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public interface hsv {
    void checkMsgAlert(BaseActivity baseActivity, int i);

    Class<?> getShareDeviceActivity();

    Class<?> getShareDeviceInfoActivity();

    void getShareManagerInstance();

    void startShareHomeActivityForResult(Activity activity, String str, int i, boolean z);
}
