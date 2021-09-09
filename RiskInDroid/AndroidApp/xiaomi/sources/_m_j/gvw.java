package _m_j;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.framework.page.EmptyPlaceholderActivity;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;

public final class gvw implements gvy {
    public final gvz createMicoMainFragment() {
        return null;
    }

    public final void disableWifiSpeakerBluetooth(String str) {
    }

    public final void getMicoApplicationInstance() {
    }

    public final String getMicoMainFragmentName() {
        return "MainMicoFragment";
    }

    public final void getWifiSpeakerBtSwitchStatus(Context context, String str, fkv<Integer, Integer> fkv) {
    }

    public final void initMicoHelper(Context context) {
    }

    public final boolean isMeshBtConflict(String str) {
        return false;
    }

    public final gvu parseAddressSelectionResult(Intent intent) {
        return null;
    }

    public final gvv parseAlarmRingResult(Intent intent) {
        return null;
    }

    public final void refreshServiceTokenBySystemAccountNew(String str, MiServiceTokenInfo miServiceTokenInfo, MessageCallback messageCallback) {
    }

    public final Intent getAlarmRingIntent(Activity activity, String str, String str2, String str3, String str4, String str5) {
        return new Intent(activity, EmptyPlaceholderActivity.class);
    }

    public final Intent getAddressSelectionIntent(Activity activity, String str, double d, double d2, String str2, String str3, String str4) {
        return new Intent(activity, EmptyPlaceholderActivity.class);
    }

    public final Application.ActivityLifecycleCallbacks getMicoActivityLifecycleMonitor() {
        return new Application.ActivityLifecycleCallbacks() {
            /* class _m_j.gvw.AnonymousClass1 */

            public final void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public final void onActivityDestroyed(Activity activity) {
            }

            public final void onActivityPaused(Activity activity) {
            }

            public final void onActivityResumed(Activity activity) {
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
            }
        };
    }

    public final Class<?> getStereoMainActivityClass() {
        return EmptyPlaceholderActivity.class;
    }

    public final Class<?> getMicoMainActivityClass() {
        return EmptyPlaceholderActivity.class;
    }

    public final Intent buildCommonWebViewIntent(Context context, String str, String str2, boolean z) {
        return new Intent(context, EmptyPlaceholderActivity.class);
    }
}
