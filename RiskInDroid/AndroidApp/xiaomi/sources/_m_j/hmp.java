package _m_j;

import android.content.Context;
import android.net.Uri;

public interface hmp {
    boolean checkShouldOpenWearablesActivity(Uri uri);

    void destroySmartHomeMainActivity();

    Uri getWearablesUri();

    void startSmartHomeMainActivity();

    void startWearablesScanActivity(Context context, Uri uri);
}
