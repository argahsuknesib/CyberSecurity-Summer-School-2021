package _m_j;

import android.app.Activity;
import android.content.Intent;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.framework.page.EmptyPlaceholderActivity;
import java.util.List;

public final class hmi implements hmm {
    public final void checkRnConfigUpdate() {
    }

    public final void delDataAfterDelDevice(List<String> list) {
    }

    public final void downloadRnExtModules() {
    }

    public final void exitQRDebugMode() {
    }

    public final List<String> getDelFolderPathBatch(List<String> list) {
        return null;
    }

    public final String getQrDebugModePackageName() {
        return null;
    }

    public final void initQrDebugMode(String str, String str2) {
    }

    public final boolean isDebugQRCode(String str) {
        return false;
    }

    public final boolean isExperiencePluginQRCode(String str) {
        return false;
    }

    public final boolean isPluginRNActivity(Activity activity) {
        return false;
    }

    public final Intent getShareLogFileIntent() {
        Intent intent = new Intent(CommonApplication.getAppContext(), EmptyPlaceholderActivity.class);
        intent.addFlags(268435456);
        return intent;
    }

    public final Class<?> getLoadingRNActivityClass() {
        return EmptyPlaceholderActivity.class;
    }
}
