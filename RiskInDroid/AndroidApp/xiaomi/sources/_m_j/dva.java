package _m_j;

import android.content.Context;
import android.os.Process;
import com.xiaomi.push.g;

public final class dva {
    public static void O000000o(Context context, duw duw, dvk dvk, dvl dvl) {
        duv.O00000o0("init in process " + g.O000000o(context, Process.myPid()) + " pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        dvb O000000o2 = dvb.O000000o(context);
        O000000o2.O00000oO = duw;
        O000000o2.O0000O0o = dvk;
        O000000o2.O0000OOo = dvl;
        O000000o2.O0000O0o.O000000o(O000000o2.O00000o0);
        O000000o2.O0000OOo.O000000o(O000000o2.O00000Oo);
        if (g.O000000o(context)) {
            duv.O00000o0("init in process　start scheduleJob");
            dvb O000000o3 = dvb.O000000o(context);
            dvb.O000000o(O000000o3.O00000o).O00000Oo();
            dvb.O000000o(O000000o3.O00000o).O00000o0();
        }
    }

    public static void O000000o(Context context, dux dux) {
        if (dux != null) {
            dvb O000000o2 = dvb.O000000o(context);
            if (O000000o2.O000000o().O00000Oo) {
                O000000o2.f14966O000000o.execute(new dvc(O000000o2, dux));
            }
        }
    }

    public static void O000000o(Context context, duy duy) {
        if (duy != null) {
            dvb O000000o2 = dvb.O000000o(context);
            if (O000000o2.O000000o().O00000o0) {
                O000000o2.f14966O000000o.execute(new dvd(O000000o2, duy));
            }
        }
    }
}
