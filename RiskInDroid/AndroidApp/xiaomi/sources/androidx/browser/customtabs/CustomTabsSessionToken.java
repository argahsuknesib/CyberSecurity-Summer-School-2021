package androidx.browser.customtabs;

import _m_j.o0O00O0o;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;

public final class CustomTabsSessionToken {

    /* renamed from: O000000o  reason: collision with root package name */
    final ICustomTabsCallback f2771O000000o;
    private final o0O00O0o O00000Oo = new o0O00O0o() {
        /* class androidx.browser.customtabs.CustomTabsSessionToken.AnonymousClass1 */

        public final void O000000o(int i, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.f2771O000000o.onNavigationEvent(i, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public final void O000000o(String str, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.f2771O000000o.extraCallback(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public final void O000000o(Bundle bundle) {
            try {
                CustomTabsSessionToken.this.f2771O000000o.onMessageChannelReady(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public final void O00000Oo(String str, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.f2771O000000o.onPostMessage(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public final void O000000o(int i, Uri uri, boolean z, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.f2771O000000o.onRelationshipValidationResult(i, uri, z, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    };

    static class MockCallback extends ICustomTabsCallback.Stub {
        public IBinder asBinder() {
            return this;
        }

        public void extraCallback(String str, Bundle bundle) {
        }

        public void onMessageChannelReady(Bundle bundle) {
        }

        public void onNavigationEvent(int i, Bundle bundle) {
        }

        public void onPostMessage(String str, Bundle bundle) {
        }

        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
        }

        MockCallback() {
        }
    }

    CustomTabsSessionToken(ICustomTabsCallback iCustomTabsCallback) {
        this.f2771O000000o = iCustomTabsCallback;
    }

    /* access modifiers changed from: package-private */
    public final IBinder O000000o() {
        return this.f2771O000000o.asBinder();
    }

    public final int hashCode() {
        return O000000o().hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        return ((CustomTabsSessionToken) obj).O000000o().equals(this.f2771O000000o.asBinder());
    }
}
