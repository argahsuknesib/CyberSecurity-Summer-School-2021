package android.support.v13.app;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.support.annotation.RequiresApi;

@TargetApi(23)
@RequiresApi(23)
class FragmentCompat23 {
    FragmentCompat23() {
    }

    public static void requestPermissions(Fragment fragment, String[] strArr, int i) {
        fragment.requestPermissions(strArr, i);
    }

    public static boolean shouldShowRequestPermissionRationale(Fragment fragment, String str) {
        return fragment.shouldShowRequestPermissionRationale(str);
    }
}
