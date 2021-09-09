package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;

public interface frp {
    void bindFb(Activity activity, frn<String, String> frn);

    void initFacebookSdk(boolean z);

    void logOut();

    void onActivityResult(int i, int i2, Intent intent);

    void shareFacebook(Activity activity, Bitmap bitmap, boolean z, String str, String str2);
}
