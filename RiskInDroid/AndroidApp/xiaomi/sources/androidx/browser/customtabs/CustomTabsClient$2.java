package androidx.browser.customtabs;

import _m_j.o0O00O0o;
import _m_j.o0O00OOO;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;

public class CustomTabsClient$2 extends ICustomTabsCallback.Stub {
    private Handler mHandler = new Handler(Looper.getMainLooper());
    final /* synthetic */ o0O00OOO this$0;
    final /* synthetic */ o0O00O0o val$callback;

    CustomTabsClient$2(o0O00OOO o0o00ooo, o0O00O0o o0o00o0o) {
        this.this$0 = o0o00ooo;
        this.val$callback = o0o00o0o;
    }

    public void onNavigationEvent(final int i, final Bundle bundle) {
        if (this.val$callback != null) {
            this.mHandler.post(new Runnable() {
                /* class androidx.browser.customtabs.CustomTabsClient$2.AnonymousClass1 */

                public final void run() {
                    CustomTabsClient$2.this.val$callback.O000000o(i, bundle);
                }
            });
        }
    }

    public void extraCallback(final String str, final Bundle bundle) throws RemoteException {
        if (this.val$callback != null) {
            this.mHandler.post(new Runnable() {
                /* class androidx.browser.customtabs.CustomTabsClient$2.AnonymousClass2 */

                public final void run() {
                    CustomTabsClient$2.this.val$callback.O000000o(str, bundle);
                }
            });
        }
    }

    public void onMessageChannelReady(final Bundle bundle) throws RemoteException {
        if (this.val$callback != null) {
            this.mHandler.post(new Runnable() {
                /* class androidx.browser.customtabs.CustomTabsClient$2.AnonymousClass3 */

                public final void run() {
                    CustomTabsClient$2.this.val$callback.O000000o(bundle);
                }
            });
        }
    }

    public void onPostMessage(final String str, final Bundle bundle) throws RemoteException {
        if (this.val$callback != null) {
            this.mHandler.post(new Runnable() {
                /* class androidx.browser.customtabs.CustomTabsClient$2.AnonymousClass4 */

                public final void run() {
                    CustomTabsClient$2.this.val$callback.O00000Oo(str, bundle);
                }
            });
        }
    }

    public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) throws RemoteException {
        if (this.val$callback != null) {
            final int i2 = i;
            final Uri uri2 = uri;
            final boolean z2 = z;
            final Bundle bundle2 = bundle;
            this.mHandler.post(new Runnable() {
                /* class androidx.browser.customtabs.CustomTabsClient$2.AnonymousClass5 */

                public final void run() {
                    CustomTabsClient$2.this.val$callback.O000000o(i2, uri2, z2, bundle2);
                }
            });
        }
    }
}
