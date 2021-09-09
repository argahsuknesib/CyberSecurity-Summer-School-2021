package com.xiaomi.push.service;

import _m_j.duv;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

class bn implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ServiceClient f6529a;

    bn(ServiceClient serviceClient) {
        this.f6529a = serviceClient;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.ServiceClient.a(com.xiaomi.push.service.ServiceClient, boolean):boolean
     arg types: [com.xiaomi.push.service.ServiceClient, int]
     candidates:
      com.xiaomi.push.service.ServiceClient.a(com.xiaomi.push.service.ServiceClient, android.os.Messenger):android.os.Messenger
      com.xiaomi.push.service.ServiceClient.a(com.xiaomi.push.service.ServiceClient, boolean):boolean */
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f6529a) {
            Messenger unused = this.f6529a.f188b = new Messenger(iBinder);
            boolean unused2 = this.f6529a.f189b = false;
            for (Message send : ServiceClient.a(this.f6529a)) {
                try {
                    ServiceClient.a(this.f6529a).send(send);
                } catch (RemoteException e) {
                    duv.O000000o(e);
                }
            }
            ServiceClient.a(this.f6529a).clear();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.ServiceClient.a(com.xiaomi.push.service.ServiceClient, boolean):boolean
     arg types: [com.xiaomi.push.service.ServiceClient, int]
     candidates:
      com.xiaomi.push.service.ServiceClient.a(com.xiaomi.push.service.ServiceClient, android.os.Messenger):android.os.Messenger
      com.xiaomi.push.service.ServiceClient.a(com.xiaomi.push.service.ServiceClient, boolean):boolean */
    public void onServiceDisconnected(ComponentName componentName) {
        Messenger unused = this.f6529a.f188b = (Messenger) null;
        boolean unused2 = this.f6529a.f189b = false;
    }
}
