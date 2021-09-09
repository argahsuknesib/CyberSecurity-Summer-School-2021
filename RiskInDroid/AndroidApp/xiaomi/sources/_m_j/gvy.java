package _m_j;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;

public interface gvy {
    Intent buildCommonWebViewIntent(Context context, String str, String str2, boolean z);

    gvz createMicoMainFragment();

    void disableWifiSpeakerBluetooth(String str);

    Intent getAddressSelectionIntent(Activity activity, String str, double d, double d2, String str2, String str3, String str4);

    Intent getAlarmRingIntent(Activity activity, String str, String str2, String str3, String str4, String str5);

    Application.ActivityLifecycleCallbacks getMicoActivityLifecycleMonitor();

    void getMicoApplicationInstance();

    Class<?> getMicoMainActivityClass();

    String getMicoMainFragmentName();

    Class<?> getStereoMainActivityClass();

    void getWifiSpeakerBtSwitchStatus(Context context, String str, fkv<Integer, Integer> fkv);

    void initMicoHelper(Context context);

    boolean isMeshBtConflict(String str);

    gvu parseAddressSelectionResult(Intent intent);

    gvv parseAlarmRingResult(Intent intent);

    void refreshServiceTokenBySystemAccountNew(String str, MiServiceTokenInfo miServiceTokenInfo, MessageCallback messageCallback);
}
