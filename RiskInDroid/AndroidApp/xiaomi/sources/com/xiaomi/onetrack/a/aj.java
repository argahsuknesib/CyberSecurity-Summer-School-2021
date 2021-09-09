package com.xiaomi.onetrack.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.miui.analytics.ITrack;
import com.xiaomi.onetrack.h.q;

class aj implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f6097a;

    aj(ai aiVar) {
        this.f6097a = aiVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        synchronized (this.f6097a.g) {
            i = 0;
            this.f6097a.e.set(false);
            this.f6097a.f.set(true);
            ITrack unused = this.f6097a.d = ITrack.Stub.asInterface(iBinder);
        }
        this.f6097a.f();
        StringBuilder sb = new StringBuilder("onServiceConnected  mConnecting ");
        sb.append(this.f6097a.e);
        sb.append(" mIOneTrackService ");
        if (this.f6097a.d != null) {
            i = 1;
        }
        sb.append(i);
        sb.append(" pid:");
        sb.append(Process.myPid());
        sb.append(" tid:");
        sb.append(Process.myTid());
        q.a("ServiceConnectManager", sb.toString());
    }

    public void onServiceDisconnected(ComponentName componentName) {
        int i;
        synchronized (this.f6097a.g) {
            ITrack unused = this.f6097a.d = null;
            i = 0;
            this.f6097a.e.set(false);
            this.f6097a.f.set(false);
        }
        StringBuilder sb = new StringBuilder("onServiceDisconnected:  mConnecting ");
        sb.append(this.f6097a.e);
        sb.append(" mIOneTrackService ");
        if (this.f6097a.d != null) {
            i = 1;
        }
        sb.append(i);
        q.a("ServiceConnectManager", sb.toString());
    }
}
