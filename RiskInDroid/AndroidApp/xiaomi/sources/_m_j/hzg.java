package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public interface hzg extends gze {
    void init();

    boolean isTagType(String str);

    void logD(String str, String str2);

    void processUWBIntent(Context context, Intent intent, Uri uri);

    void refreshUwbData();

    void showUwbPermissionSettingDialog(Activity activity);

    void syncUwbConfig();
}
