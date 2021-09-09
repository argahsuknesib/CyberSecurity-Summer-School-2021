package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.NotificationClickedActivity;

public final class eag extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ NotificationClickedActivity f15121O000000o;

    public eag(NotificationClickedActivity notificationClickedActivity) {
        this.f15121O000000o = notificationClickedActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        duv.O00000Oo("clicked activity finish by normal.");
        this.f15121O000000o.finish();
    }
}
