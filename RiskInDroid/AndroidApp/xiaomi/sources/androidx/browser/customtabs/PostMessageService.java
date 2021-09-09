package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

public class PostMessageService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    private IPostMessageService.Stub f2773O000000o = new IPostMessageService.Stub() {
        /* class androidx.browser.customtabs.PostMessageService.AnonymousClass1 */

        public void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException {
            iCustomTabsCallback.onMessageChannelReady(bundle);
        }

        public void onPostMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) throws RemoteException {
            iCustomTabsCallback.onPostMessage(str, bundle);
        }
    };

    public IBinder onBind(Intent intent) {
        return this.f2773O000000o;
    }
}
