package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@TargetApi(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
@RequiresApi(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
class MotionEventCompatHoneycombMr1 {
    MotionEventCompatHoneycombMr1() {
    }

    static float getAxisValue(MotionEvent motionEvent, int i) {
        return motionEvent.getAxisValue(i);
    }

    static float getAxisValue(MotionEvent motionEvent, int i, int i2) {
        return motionEvent.getAxisValue(i, i2);
    }
}
