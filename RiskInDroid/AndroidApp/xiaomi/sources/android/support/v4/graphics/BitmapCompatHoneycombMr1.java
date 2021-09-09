package android.support.v4.graphics;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@TargetApi(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
@RequiresApi(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
class BitmapCompatHoneycombMr1 {
    BitmapCompatHoneycombMr1() {
    }

    static int getAllocationByteCount(Bitmap bitmap) {
        return bitmap.getByteCount();
    }
}
