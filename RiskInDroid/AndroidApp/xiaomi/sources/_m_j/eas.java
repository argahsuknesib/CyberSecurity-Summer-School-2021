package _m_j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

final class eas implements ServiceConnection {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ eao f15132O000000o;

    eas(eao eao) {
        this.f15132O000000o = eao;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f15132O000000o) {
            Messenger unused = this.f15132O000000o.O00000oO = new Messenger(iBinder);
            boolean unused2 = this.f15132O000000o.O0000Oo = false;
            for (Message send : this.f15132O000000o.O0000Oo0) {
                try {
                    this.f15132O000000o.O00000oO.send(send);
                } catch (RemoteException e) {
                    duv.O000000o(e);
                }
            }
            this.f15132O000000o.O0000Oo0.clear();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Messenger unused = this.f15132O000000o.O00000oO = (Messenger) null;
        boolean unused2 = this.f15132O000000o.O0000Oo = false;
    }
}
