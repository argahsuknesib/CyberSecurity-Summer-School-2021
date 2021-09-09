package androidx.browser.customtabs;

import _m_j.o0O0OOO0;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    final Map<IBinder, IBinder.DeathRecipient> f2769O000000o = new o0O0OOO0();
    private ICustomTabsService.Stub O00000Oo = new ICustomTabsService.Stub() {
        /* class androidx.browser.customtabs.CustomTabsService.AnonymousClass1 */

        public boolean warmup(long j) {
            return CustomTabsService.this.O000000o();
        }

        public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
            final CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(iCustomTabsCallback);
            try {
                AnonymousClass1 r2 = new IBinder.DeathRecipient() {
                    /* class androidx.browser.customtabs.CustomTabsService.AnonymousClass1.AnonymousClass1 */

                    public final void binderDied() {
                        CustomTabsService.this.O000000o(customTabsSessionToken);
                    }
                };
                synchronized (CustomTabsService.this.f2769O000000o) {
                    iCustomTabsCallback.asBinder().linkToDeath(r2, 0);
                    CustomTabsService.this.f2769O000000o.put(iCustomTabsCallback.asBinder(), r2);
                }
                return CustomTabsService.this.O00000Oo();
            } catch (RemoteException unused) {
                return false;
            }
        }

        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new CustomTabsSessionToken(iCustomTabsCallback);
            return customTabsService.O00000o0();
        }

        public Bundle extraCommand(String str, Bundle bundle) {
            return CustomTabsService.this.O00000o();
        }

        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new CustomTabsSessionToken(iCustomTabsCallback);
            return customTabsService.O00000oO();
        }

        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new CustomTabsSessionToken(iCustomTabsCallback);
            return customTabsService.O00000oo();
        }

        public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new CustomTabsSessionToken(iCustomTabsCallback);
            return customTabsService.O0000O0o();
        }

        public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i, Uri uri, Bundle bundle) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new CustomTabsSessionToken(iCustomTabsCallback);
            return customTabsService.O0000OOo();
        }
    };

    /* access modifiers changed from: protected */
    public abstract boolean O000000o();

    /* access modifiers changed from: protected */
    public abstract boolean O00000Oo();

    /* access modifiers changed from: protected */
    public abstract Bundle O00000o();

    /* access modifiers changed from: protected */
    public abstract boolean O00000o0();

    /* access modifiers changed from: protected */
    public abstract boolean O00000oO();

    /* access modifiers changed from: protected */
    public abstract boolean O00000oo();

    /* access modifiers changed from: protected */
    public abstract int O0000O0o();

    /* access modifiers changed from: protected */
    public abstract boolean O0000OOo();

    public IBinder onBind(Intent intent) {
        return this.O00000Oo;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(CustomTabsSessionToken customTabsSessionToken) {
        try {
            synchronized (this.f2769O000000o) {
                IBinder O000000o2 = customTabsSessionToken.O000000o();
                O000000o2.unlinkToDeath(this.f2769O000000o.get(O000000o2), 0);
                this.f2769O000000o.remove(O000000o2);
            }
            return true;
        } catch (NoSuchElementException unused) {
            return false;
        }
    }
}
