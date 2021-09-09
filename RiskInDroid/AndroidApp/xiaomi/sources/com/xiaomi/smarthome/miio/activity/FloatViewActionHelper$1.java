package com.xiaomi.smarthome.miio.activity;

import _m_j.gns;
import _m_j.gsy;
import _m_j.gwk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.feedback.FeedBackMainActivity;
import com.xiaomi.smarthome.feedback.FeedbackActivity;
import com.xiaomi.smarthome.library.log.LogType;

public class FloatViewActionHelper$1 extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ gwk f9667O000000o;

    public FloatViewActionHelper$1(gwk gwk) {
        this.f9667O000000o = gwk;
    }

    public final void onReceive(Context context, Intent intent) {
        gsy.O00000o0(LogType.GENERAL, "zhudong_float_view_tag", intent.getAction());
        if (intent.getAction().equals("action_save_float_view_status")) {
            this.f9667O000000o.O000000o(gns.O00000o0());
        } else if (!intent.getAction().equals("action_go_feed_back_activity")) {
        } else {
            if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                Intent intent2 = new Intent(ServiceApplication.getAppContext(), FeedBackMainActivity.class);
                intent2.setFlags(268435456);
                ServiceApplication.getAppContext().startActivity(intent2);
                return;
            }
            Intent intent3 = new Intent(ServiceApplication.getAppContext(), FeedbackActivity.class);
            intent3.putExtra("extra_device_model", "exp");
            intent3.setFlags(268435456);
            ServiceApplication.getAppContext().startActivity(intent3);
        }
    }
}
