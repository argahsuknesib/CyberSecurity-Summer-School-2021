package _m_j;

import android.app.Activity;
import android.content.Intent;
import java.util.List;

public interface hmm {
    void checkRnConfigUpdate();

    void delDataAfterDelDevice(List<String> list);

    void downloadRnExtModules();

    void exitQRDebugMode();

    List<String> getDelFolderPathBatch(List<String> list);

    Class<?> getLoadingRNActivityClass();

    String getQrDebugModePackageName();

    Intent getShareLogFileIntent();

    void initQrDebugMode(String str, String str2);

    boolean isDebugQRCode(String str);

    boolean isExperiencePluginQRCode(String str);

    boolean isPluginRNActivity(Activity activity);
}
