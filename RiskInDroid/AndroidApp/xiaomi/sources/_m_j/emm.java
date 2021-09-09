package _m_j;

import android.content.Context;

public final class emm implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public dvm f15631O000000o;
    public Context O00000Oo;

    public final void run() {
        try {
            if (this.f15631O000000o != null) {
                this.f15631O000000o.O000000o();
            }
            duv.O00000o0("begin read and send perf / event");
            if (this.f15631O000000o instanceof dvk) {
                emq.O000000o(this.O00000Oo).O000000o("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (this.f15631O000000o instanceof dvl) {
                emq.O000000o(this.O00000Oo).O000000o("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            duv.O000000o(e);
        }
    }
}
