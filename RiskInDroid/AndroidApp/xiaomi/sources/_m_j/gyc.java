package _m_j;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;

public interface gyc {

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    void checkUpdate(O000000o o000000o);

    int getNewVersionCode();

    String getNewVersionUrl();

    int getmForceUpdate();

    boolean hasDownloadedNewVersionApk(Context context, int i);

    boolean hasNewVersion();

    void ignoreThisNewVersion();

    boolean isApkInstalling();

    boolean isNewVersionIgnore();

    void registerReceiver();

    void showForceUpdateDialog(Activity activity);

    void showHalfForceUpdateDialog(Activity activity);

    void showNorifyProgress(boolean z);

    void startDownloadApk(Context context, boolean z, String str, Bitmap bitmap);

    void startInstallApkIntent(Context context);

    void unRegisterReceiver();
}
