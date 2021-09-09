package _m_j;

import com.xiaomi.mipush.sdk.NotificationClickedActivity;

public final class eaf implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ NotificationClickedActivity f15120O000000o;

    public eaf(NotificationClickedActivity notificationClickedActivity) {
        this.f15120O000000o = notificationClickedActivity;
    }

    public final void run() {
        duv.O000000o("clicked activity finish by timeout.");
        this.f15120O000000o.finish();
    }
}
