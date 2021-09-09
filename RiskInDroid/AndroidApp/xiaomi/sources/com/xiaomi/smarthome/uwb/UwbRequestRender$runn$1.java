package com.xiaomi.smarthome.uwb;

import _m_j.ixe;
import android.os.Handler;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/xiaomi/smarthome/uwb/UwbRequestRender$runn$1", "Ljava/lang/Runnable;", "run", "", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbRequestRender$runn$1 implements Runnable {
    final /* synthetic */ UwbRequestRender<C, E, T> this$0;

    UwbRequestRender$runn$1(UwbRequestRender<C, E, T> uwbRequestRender) {
        this.this$0 = uwbRequestRender;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void run() {
        Handler handler = this.this$0.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this);
        }
        if (this.this$0.getRequestingSize() <= 1) {
            Handler handler2 = this.this$0.mHandler;
            if (handler2 != null) {
                handler2.postDelayed(this, Math.max((this.this$0.getDelayTime() * 3) / 2, 3000L));
            }
            this.this$0.refreshProps(true);
            return;
        }
        Handler handler3 = this.this$0.mHandler;
        if (handler3 != null) {
            handler3.postDelayed(this, 1000);
        }
        UwbLogUtil.d("UwbRequestRender", ixe.O000000o("requestSender.getRequestingSize() ", (Object) Integer.valueOf(this.this$0.getRequestingSize())));
    }
}
