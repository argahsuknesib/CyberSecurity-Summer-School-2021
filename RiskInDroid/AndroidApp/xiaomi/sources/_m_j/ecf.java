package _m_j;

import android.os.Process;

final class ecf implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ ece f15162O000000o;

    ecf(ece ece) {
        this.f15162O000000o = ece;
    }

    public final void run() {
        Process.killProcess(Process.myPid());
    }
}
