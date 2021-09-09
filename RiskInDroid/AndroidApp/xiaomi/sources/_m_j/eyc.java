package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.device.Device;

public interface eyc {

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    Intent getAction(Device device, Context context, int i, Bundle bundle, boolean z, O000000o o000000o);

    Intent getAction(Device device, Context context, Bundle bundle, boolean z, O000000o o000000o);

    void onItemClick(View view, Handler handler, Device device, Context context, Activity activity);

    void refreshClickedDeviceDesc();

    void setNameStatus(Context context, TextView textView, Device device, boolean z);
}
