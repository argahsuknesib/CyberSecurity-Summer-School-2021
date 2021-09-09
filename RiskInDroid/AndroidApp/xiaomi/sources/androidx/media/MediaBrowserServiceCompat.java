package androidx.media;

import _m_j.be;
import _m_j.fx;
import _m_j.fy;
import _m_j.fz;
import _m_j.ga;
import _m_j.gb;
import _m_j.o0O0OOO0;
import _m_j.oOOO0OO0;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    static final boolean f2893O000000o = Log.isLoggable("MBServiceCompat", 3);
    final o0O0OOO0<IBinder, O00000Oo> O00000Oo = new o0O0OOO0<>();
    final O000O00o O00000o = new O000O00o();
    O00000Oo O00000o0;
    MediaSessionCompat.Token O00000oO;
    private O00000o0 O00000oo;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f2898O000000o;
        final Bundle O00000Oo;
    }

    interface O00000o0 {
        IBinder O000000o(Intent intent);

        void O000000o();

        void O000000o(gb.O000000o o000000o, String str, Bundle bundle);

        void O000000o(MediaSessionCompat.Token token);

        void O000000o(String str, Bundle bundle);

        Bundle O00000Oo();

        gb.O000000o O00000o0();
    }

    interface O0000o {
        IBinder O000000o();

        void O000000o(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void O000000o(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;

        void O00000Oo() throws RemoteException;
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract O000000o onGetRoot(String str, int i, Bundle bundle);

    public abstract void onLoadChildren(String str, O0000o00<List<MediaBrowserCompat.MediaItem>> o0000o00);

    public void onSubscribe(String str, Bundle bundle) {
    }

    public void onUnsubscribe(String str) {
    }

    class O0000Oo implements O00000o0 {
        private Messenger O00000Oo;

        O0000Oo() {
        }

        public final void O000000o() {
            this.O00000Oo = new Messenger(MediaBrowserServiceCompat.this.O00000o);
        }

        public final IBinder O000000o(Intent intent) {
            if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
                return this.O00000Oo.getBinder();
            }
            return null;
        }

        public final void O000000o(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.O00000o.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.O0000Oo.AnonymousClass1 */

                public final void run() {
                    Iterator<O00000Oo> it = MediaBrowserServiceCompat.this.O00000Oo.values().iterator();
                    while (it.hasNext()) {
                        O00000Oo next = it.next();
                        try {
                            next.O00000oo.O000000o(next.O0000OOo.f2898O000000o, token, next.O0000OOo.O00000Oo);
                        } catch (RemoteException unused) {
                            Log.w("MBServiceCompat", "Connection for " + next.f2899O000000o + " is no longer valid.");
                            it.remove();
                        }
                    }
                }
            });
        }

        public final void O000000o(final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.O00000o.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.O0000Oo.AnonymousClass2 */

                public final void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.O00000Oo.keySet()) {
                        o0O0OOO0<IBinder, O00000Oo> o0o0ooo0 = MediaBrowserServiceCompat.this.O00000Oo;
                        O0000Oo.this.O000000o(o0o0ooo0.get(iBinder), str, bundle);
                    }
                }
            });
        }

        public final void O000000o(final gb.O000000o o000000o, final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.O00000o.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.O0000Oo.AnonymousClass3 */

                public final void run() {
                    for (int i = 0; i < MediaBrowserServiceCompat.this.O00000Oo.size(); i++) {
                        O00000Oo O00000o02 = MediaBrowserServiceCompat.this.O00000Oo.O00000o0(i);
                        if (O00000o02.O00000o.equals(o000000o)) {
                            O0000Oo.this.O000000o(O00000o02, str, bundle);
                            return;
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(O00000Oo o00000Oo, String str, Bundle bundle) {
            List<be> list = o00000Oo.O0000O0o.get(str);
            if (list != null) {
                for (be beVar : list) {
                    if (fx.O00000Oo(bundle, (Bundle) beVar.O00000Oo)) {
                        MediaBrowserServiceCompat.this.O000000o(str, o00000Oo, (Bundle) beVar.O00000Oo, bundle);
                    }
                }
            }
        }

        public final Bundle O00000Oo() {
            if (MediaBrowserServiceCompat.this.O00000o0 == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (MediaBrowserServiceCompat.this.O00000o0.O00000oO == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.O00000o0.O00000oO);
            }
        }

        public final gb.O000000o O00000o0() {
            if (MediaBrowserServiceCompat.this.O00000o0 != null) {
                return MediaBrowserServiceCompat.this.O00000o0.O00000o;
            }
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
    }

    class O00000o implements fy.O00000o, O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<Bundle> f2901O000000o = new ArrayList();
        Object O00000Oo;
        Messenger O00000o0;

        O00000o() {
        }

        public void O000000o() {
            this.O00000Oo = new fy.O00000Oo(MediaBrowserServiceCompat.this, this);
            ((MediaBrowserService) this.O00000Oo).onCreate();
        }

        public final IBinder O000000o(Intent intent) {
            return ((MediaBrowserService) this.O00000Oo).onBind(intent);
        }

        public final void O000000o(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.O00000o.O000000o(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.O00000o.AnonymousClass1 */

                public final void run() {
                    if (!O00000o.this.f2901O000000o.isEmpty()) {
                        IMediaSession extraBinder = token.getExtraBinder();
                        if (extraBinder != null) {
                            for (Bundle O000000o2 : O00000o.this.f2901O000000o) {
                                oOOO0OO0.O000000o(O000000o2, "extra_session_binder", extraBinder.asBinder());
                            }
                        }
                        O00000o.this.f2901O000000o.clear();
                    }
                    ((MediaBrowserService) O00000o.this.O00000Oo).setSessionToken((MediaSession.Token) token.getToken());
                }
            });
        }

        public final void O000000o(final String str, final Bundle bundle) {
            O00000Oo(str, bundle);
            MediaBrowserServiceCompat.this.O00000o.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.O00000o.AnonymousClass3 */

                public final void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.O00000Oo.keySet()) {
                        o0O0OOO0<IBinder, O00000Oo> o0o0ooo0 = MediaBrowserServiceCompat.this.O00000Oo;
                        O00000o.this.O000000o(o0o0ooo0.get(iBinder), str, bundle);
                    }
                }
            });
        }

        public final fy.O000000o O000000o(String str, int i, Bundle bundle) {
            Bundle bundle2;
            IBinder iBinder;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove("extra_client_version");
                this.O00000o0 = new Messenger(MediaBrowserServiceCompat.this.O00000o);
                bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                oOOO0OO0.O000000o(bundle2, "extra_messenger", this.O00000o0.getBinder());
                if (MediaBrowserServiceCompat.this.O00000oO != null) {
                    IMediaSession extraBinder = MediaBrowserServiceCompat.this.O00000oO.getExtraBinder();
                    if (extraBinder == null) {
                        iBinder = null;
                    } else {
                        iBinder = extraBinder.asBinder();
                    }
                    oOOO0OO0.O000000o(bundle2, "extra_session_binder", iBinder);
                } else {
                    this.f2901O000000o.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.O00000o0 = new O00000Oo(str, -1, i, bundle, null);
            O000000o onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            MediaBrowserServiceCompat.this.O00000o0 = null;
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.O00000Oo;
            } else if (onGetRoot.O00000Oo != null) {
                bundle2.putAll(onGetRoot.O00000Oo);
            }
            return new fy.O000000o(onGetRoot.f2898O000000o, bundle2);
        }

        public final void O000000o(String str, final fy.O00000o0<List<Parcel>> o00000o0) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new O0000o00<List<MediaBrowserCompat.MediaItem>>(str) {
                /* class androidx.media.MediaBrowserServiceCompat.O00000o.AnonymousClass2 */

                /* access modifiers changed from: package-private */
                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    o00000o0.O000000o((Object) null);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void O00000Oo(String str, Bundle bundle) {
            ((MediaBrowserService) this.O00000Oo).notifyChildrenChanged(str);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(O00000Oo o00000Oo, String str, Bundle bundle) {
            List<be> list = o00000Oo.O0000O0o.get(str);
            if (list != null) {
                for (be beVar : list) {
                    if (fx.O00000Oo(bundle, (Bundle) beVar.O00000Oo)) {
                        MediaBrowserServiceCompat.this.O000000o(str, o00000Oo, (Bundle) beVar.O00000Oo, bundle);
                    }
                }
            }
        }

        public Bundle O00000Oo() {
            if (this.O00000o0 == null) {
                return null;
            }
            if (MediaBrowserServiceCompat.this.O00000o0 == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (MediaBrowserServiceCompat.this.O00000o0.O00000oO == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.O00000o0.O00000oO);
            }
        }

        public gb.O000000o O00000o0() {
            if (MediaBrowserServiceCompat.this.O00000o0 != null) {
                return MediaBrowserServiceCompat.this.O00000o0.O00000o;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        public final void O000000o(final gb.O000000o o000000o, final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.O00000o.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.O00000o.AnonymousClass4 */

                public final void run() {
                    for (int i = 0; i < MediaBrowserServiceCompat.this.O00000Oo.size(); i++) {
                        O00000Oo O00000o02 = MediaBrowserServiceCompat.this.O00000Oo.O00000o0(i);
                        if (O00000o02.O00000o.equals(o000000o)) {
                            O00000o.this.O000000o(O00000o02, str, bundle);
                        }
                    }
                }
            });
        }
    }

    class O0000O0o extends O00000o implements fz.O00000Oo {
        O0000O0o() {
            super();
        }

        public void O000000o() {
            this.O00000Oo = new fz.O000000o(MediaBrowserServiceCompat.this, this);
            ((MediaBrowserService) this.O00000Oo).onCreate();
        }

        public final void O00000Oo(String str, final fy.O00000o0<Parcel> o00000o0) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new O0000o00<MediaBrowserCompat.MediaItem>(str) {
                /* class androidx.media.MediaBrowserServiceCompat.O0000O0o.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    o00000o0.O000000o((Object) null);
                }
            });
        }
    }

    class O0000OOo extends O0000O0o implements ga.O00000o0 {
        O0000OOo() {
            super();
        }

        public final void O000000o() {
            this.O00000Oo = ga.O000000o(MediaBrowserServiceCompat.this, this);
            ((MediaBrowserService) this.O00000Oo).onCreate();
        }

        public final void O000000o(String str, final ga.O00000Oo o00000Oo, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new O0000o00<List<MediaBrowserCompat.MediaItem>>(str) {
                /* class androidx.media.MediaBrowserServiceCompat.O0000OOo.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public final /* synthetic */ void O000000o(Object obj) {
                    ga.O00000Oo o00000Oo = o00000Oo;
                    try {
                        ga.f17455O000000o.setInt(o00000Oo.f17456O000000o, this.O0000Oo0);
                    } catch (IllegalAccessException e) {
                        Log.w("MBSCompatApi26", e);
                    }
                    o00000Oo.f17456O000000o.sendResult(null);
                }
            }, bundle);
        }

        public final Bundle O00000Oo() {
            if (MediaBrowserServiceCompat.this.O00000o0 == null) {
                return ga.O000000o(this.O00000Oo);
            }
            if (MediaBrowserServiceCompat.this.O00000o0.O00000oO == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.O00000o0.O00000oO);
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo(String str, Bundle bundle) {
            if (bundle != null) {
                ga.O000000o(this.O00000Oo, str, bundle);
            } else {
                super.O00000Oo(str, bundle);
            }
        }
    }

    class O0000Oo0 extends O0000OOo {
        O0000Oo0() {
            super();
        }

        public final gb.O000000o O00000o0() {
            if (MediaBrowserServiceCompat.this.O00000o0 != null) {
                return MediaBrowserServiceCompat.this.O00000o0.O00000o;
            }
            return new gb.O000000o(((MediaBrowserService) this.O00000Oo).getCurrentBrowserInfo());
        }
    }

    final class O000O00o extends Handler {
        private final O0000o0 O00000Oo = new O0000o0();

        O000O00o() {
        }

        public final void handleMessage(Message message) {
            Message message2 = message;
            Bundle data = message.getData();
            switch (message2.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    O0000o0 o0000o0 = this.O00000Oo;
                    String string = data.getString("data_package_name");
                    int i = data.getInt("data_calling_pid");
                    int i2 = data.getInt("data_calling_uid");
                    O00oOooO o00oOooO = new O00oOooO(message2.replyTo);
                    MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                    boolean z = false;
                    if (string != null) {
                        String[] packagesForUid = mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i2);
                        int length = packagesForUid.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                if (packagesForUid[i3].equals(string)) {
                                    z = true;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                    if (z) {
                        MediaBrowserServiceCompat.this.O00000o.O000000o(new Runnable(o00oOooO, string, i, i2, bundle) {
                            /* class androidx.media.MediaBrowserServiceCompat.O0000o0.AnonymousClass1 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ O0000o f2913O000000o;
                            final /* synthetic */ String O00000Oo;
                            final /* synthetic */ int O00000o;
                            final /* synthetic */ int O00000o0;
                            final /* synthetic */ Bundle O00000oO;

                            {
                                this.f2913O000000o = r2;
                                this.O00000Oo = r3;
                                this.O00000o0 = r4;
                                this.O00000o = r5;
                                this.O00000oO = r6;
                            }

                            public final void run() {
                                IBinder O000000o2 = this.f2913O000000o.O000000o();
                                MediaBrowserServiceCompat.this.O00000Oo.remove(O000000o2);
                                O00000Oo o00000Oo = new O00000Oo(this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.f2913O000000o);
                                MediaBrowserServiceCompat.this.O00000o0 = o00000Oo;
                                o00000Oo.O0000OOo = MediaBrowserServiceCompat.this.onGetRoot(this.O00000Oo, this.O00000o, this.O00000oO);
                                MediaBrowserServiceCompat.this.O00000o0 = null;
                                if (o00000Oo.O0000OOo == null) {
                                    Log.i("MBServiceCompat", "No root for client " + this.O00000Oo + " from service " + getClass().getName());
                                    try {
                                        this.f2913O000000o.O00000Oo();
                                    } catch (RemoteException unused) {
                                        Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.O00000Oo);
                                    }
                                } else {
                                    try {
                                        MediaBrowserServiceCompat.this.O00000Oo.put(O000000o2, o00000Oo);
                                        O000000o2.linkToDeath(o00000Oo, 0);
                                        if (MediaBrowserServiceCompat.this.O00000oO != null) {
                                            this.f2913O000000o.O000000o(o00000Oo.O0000OOo.f2898O000000o, MediaBrowserServiceCompat.this.O00000oO, o00000Oo.O0000OOo.O00000Oo);
                                        }
                                    } catch (RemoteException unused2) {
                                        Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.O00000Oo);
                                        MediaBrowserServiceCompat.this.O00000Oo.remove(O000000o2);
                                    }
                                }
                            }
                        });
                        return;
                    }
                    throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + string);
                case 2:
                    O0000o0 o0000o02 = this.O00000Oo;
                    MediaBrowserServiceCompat.this.O00000o.O000000o(new Runnable(new O00oOooO(message2.replyTo)) {
                        /* class androidx.media.MediaBrowserServiceCompat.O0000o0.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O0000o f2914O000000o;

                        {
                            this.f2914O000000o = r2;
                        }

                        public final void run() {
                            O00000Oo remove = MediaBrowserServiceCompat.this.O00000Oo.remove(this.f2914O000000o.O000000o());
                            if (remove != null) {
                                remove.O00000oo.O000000o().unlinkToDeath(remove, 0);
                            }
                        }
                    });
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    O0000o0 o0000o03 = this.O00000Oo;
                    String string2 = data.getString("data_media_item_id");
                    IBinder O000000o2 = oOOO0OO0.O000000o(data, "data_callback_token");
                    MediaBrowserServiceCompat.this.O00000o.O000000o(new Runnable(new O00oOooO(message2.replyTo), string2, O000000o2, bundle2) {
                        /* class androidx.media.MediaBrowserServiceCompat.O0000o0.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O0000o f2915O000000o;
                        final /* synthetic */ String O00000Oo;
                        final /* synthetic */ Bundle O00000o;
                        final /* synthetic */ IBinder O00000o0;

                        {
                            this.f2915O000000o = r2;
                            this.O00000Oo = r3;
                            this.O00000o0 = r4;
                            this.O00000o = r5;
                        }

                        public final void run() {
                            O00000Oo o00000Oo = MediaBrowserServiceCompat.this.O00000Oo.get(this.f2915O000000o.O000000o());
                            if (o00000Oo == null) {
                                Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.O00000Oo);
                                return;
                            }
                            MediaBrowserServiceCompat.this.O000000o(this.O00000Oo, o00000Oo, this.O00000o0, this.O00000o);
                        }
                    });
                    return;
                case 4:
                    O0000o0 o0000o04 = this.O00000Oo;
                    String string3 = data.getString("data_media_item_id");
                    IBinder O000000o3 = oOOO0OO0.O000000o(data, "data_callback_token");
                    MediaBrowserServiceCompat.this.O00000o.O000000o(new Runnable(new O00oOooO(message2.replyTo), string3, O000000o3) {
                        /* class androidx.media.MediaBrowserServiceCompat.O0000o0.AnonymousClass4 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O0000o f2916O000000o;
                        final /* synthetic */ String O00000Oo;
                        final /* synthetic */ IBinder O00000o0;

                        {
                            this.f2916O000000o = r2;
                            this.O00000Oo = r3;
                            this.O00000o0 = r4;
                        }

                        public final void run() {
                            O00000Oo o00000Oo = MediaBrowserServiceCompat.this.O00000Oo.get(this.f2916O000000o.O000000o());
                            if (o00000Oo == null) {
                                Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.O00000Oo);
                            } else if (!MediaBrowserServiceCompat.this.O000000o(this.O00000Oo, o00000Oo, this.O00000o0)) {
                                Log.w("MBServiceCompat", "removeSubscription called for " + this.O00000Oo + " which is not subscribed");
                            }
                        }
                    });
                    return;
                case 5:
                    O0000o0 o0000o05 = this.O00000Oo;
                    String string4 = data.getString("data_media_item_id");
                    ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    O00oOooO o00oOooO2 = new O00oOooO(message2.replyTo);
                    if (!TextUtils.isEmpty(string4) && resultReceiver != null) {
                        MediaBrowserServiceCompat.this.O00000o.O000000o(new Runnable(o00oOooO2, string4, resultReceiver) {
                            /* class androidx.media.MediaBrowserServiceCompat.O0000o0.AnonymousClass5 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ O0000o f2917O000000o;
                            final /* synthetic */ String O00000Oo;
                            final /* synthetic */ ResultReceiver O00000o0;

                            {
                                this.f2917O000000o = r2;
                                this.O00000Oo = r3;
                                this.O00000o0 = r4;
                            }

                            public final void run() {
                                O00000Oo o00000Oo = MediaBrowserServiceCompat.this.O00000Oo.get(this.f2917O000000o.O000000o());
                                if (o00000Oo == null) {
                                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.O00000Oo);
                                    return;
                                }
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                                String str = this.O00000Oo;
                                AnonymousClass2 r4 = new O0000o00<MediaBrowserCompat.MediaItem>(str, this.O00000o0) {
                                    /* class androidx.media.MediaBrowserServiceCompat.AnonymousClass2 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ ResultReceiver f2895O000000o;

                                    {
                                        this.f2895O000000o = r3;
                                    }

                                    /* access modifiers changed from: package-private */
                                    public final /* synthetic */ void O000000o(Object obj) {
                                        if ((this.O0000Oo0 & 2) != 0) {
                                            this.f2895O000000o.send(-1, null);
                                            return;
                                        }
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("media_item", null);
                                        this.f2895O000000o.send(0, bundle);
                                    }
                                };
                                mediaBrowserServiceCompat.O00000o0 = o00000Oo;
                                mediaBrowserServiceCompat.onLoadItem(str, r4);
                                mediaBrowserServiceCompat.O00000o0 = null;
                                if (!r4.O00000Oo()) {
                                    throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=".concat(String.valueOf(str)));
                                }
                            }
                        });
                        return;
                    }
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    O0000o0 o0000o06 = this.O00000Oo;
                    MediaBrowserServiceCompat.this.O00000o.O000000o(new Runnable(new O00oOooO(message2.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3) {
                        /* class androidx.media.MediaBrowserServiceCompat.O0000o0.AnonymousClass6 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O0000o f2918O000000o;
                        final /* synthetic */ String O00000Oo;
                        final /* synthetic */ int O00000o;
                        final /* synthetic */ int O00000o0;
                        final /* synthetic */ Bundle O00000oO;

                        {
                            this.f2918O000000o = r2;
                            this.O00000Oo = r3;
                            this.O00000o0 = r4;
                            this.O00000o = r5;
                            this.O00000oO = r6;
                        }

                        public final void run() {
                            IBinder O000000o2 = this.f2918O000000o.O000000o();
                            MediaBrowserServiceCompat.this.O00000Oo.remove(O000000o2);
                            O00000Oo o00000Oo = new O00000Oo(this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.f2918O000000o);
                            MediaBrowserServiceCompat.this.O00000Oo.put(O000000o2, o00000Oo);
                            try {
                                O000000o2.linkToDeath(o00000Oo, 0);
                            } catch (RemoteException unused) {
                                Log.w("MBServiceCompat", "IBinder is already dead.");
                            }
                        }
                    });
                    return;
                case 7:
                    O0000o0 o0000o07 = this.O00000Oo;
                    MediaBrowserServiceCompat.this.O00000o.O000000o(new Runnable(new O00oOooO(message2.replyTo)) {
                        /* class androidx.media.MediaBrowserServiceCompat.O0000o0.AnonymousClass7 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O0000o f2919O000000o;

                        {
                            this.f2919O000000o = r2;
                        }

                        public final void run() {
                            IBinder O000000o2 = this.f2919O000000o.O000000o();
                            O00000Oo remove = MediaBrowserServiceCompat.this.O00000Oo.remove(O000000o2);
                            if (remove != null) {
                                O000000o2.unlinkToDeath(remove, 0);
                            }
                        }
                    });
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    O0000o0 o0000o08 = this.O00000Oo;
                    String string5 = data.getString("data_search_query");
                    ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    O00oOooO o00oOooO3 = new O00oOooO(message2.replyTo);
                    if (!TextUtils.isEmpty(string5) && resultReceiver2 != null) {
                        MediaBrowserServiceCompat.this.O00000o.O000000o(new Runnable(o00oOooO3, string5, bundle4, resultReceiver2) {
                            /* class androidx.media.MediaBrowserServiceCompat.O0000o0.AnonymousClass8 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ O0000o f2920O000000o;
                            final /* synthetic */ String O00000Oo;
                            final /* synthetic */ ResultReceiver O00000o;
                            final /* synthetic */ Bundle O00000o0;

                            {
                                this.f2920O000000o = r2;
                                this.O00000Oo = r3;
                                this.O00000o0 = r4;
                                this.O00000o = r5;
                            }

                            public final void run() {
                                O00000Oo o00000Oo = MediaBrowserServiceCompat.this.O00000Oo.get(this.f2920O000000o.O000000o());
                                if (o00000Oo == null) {
                                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.O00000Oo);
                                    return;
                                }
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                                String str = this.O00000Oo;
                                Bundle bundle = this.O00000o0;
                                AnonymousClass3 r5 = new O0000o00<List<MediaBrowserCompat.MediaItem>>(str, this.O00000o) {
                                    /* class androidx.media.MediaBrowserServiceCompat.AnonymousClass3 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ ResultReceiver f2896O000000o;

                                    {
                                        this.f2896O000000o = r3;
                                    }

                                    /* access modifiers changed from: package-private */
                                    public final /* synthetic */ void O000000o(Object obj) {
                                        this.f2896O000000o.send(-1, null);
                                    }
                                };
                                mediaBrowserServiceCompat.O00000o0 = o00000Oo;
                                mediaBrowserServiceCompat.onSearch(str, bundle, r5);
                                mediaBrowserServiceCompat.O00000o0 = null;
                                if (!r5.O00000Oo()) {
                                    throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=".concat(String.valueOf(str)));
                                }
                            }
                        });
                        return;
                    }
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    O0000o0 o0000o09 = this.O00000Oo;
                    String string6 = data.getString("data_custom_action");
                    ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    O00oOooO o00oOooO4 = new O00oOooO(message2.replyTo);
                    if (!TextUtils.isEmpty(string6) && resultReceiver3 != null) {
                        MediaBrowserServiceCompat.this.O00000o.O000000o(new Runnable(o00oOooO4, string6, bundle5, resultReceiver3) {
                            /* class androidx.media.MediaBrowserServiceCompat.O0000o0.AnonymousClass9 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ O0000o f2921O000000o;
                            final /* synthetic */ String O00000Oo;
                            final /* synthetic */ ResultReceiver O00000o;
                            final /* synthetic */ Bundle O00000o0;

                            {
                                this.f2921O000000o = r2;
                                this.O00000Oo = r3;
                                this.O00000o0 = r4;
                                this.O00000o = r5;
                            }

                            public final void run() {
                                O00000Oo o00000Oo = MediaBrowserServiceCompat.this.O00000Oo.get(this.f2921O000000o.O000000o());
                                if (o00000Oo == null) {
                                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.O00000Oo + ", extras=" + this.O00000o0);
                                    return;
                                }
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                                String str = this.O00000Oo;
                                Bundle bundle = this.O00000o0;
                                AnonymousClass4 r5 = new O0000o00<Bundle>(str, this.O00000o) {
                                    /* class androidx.media.MediaBrowserServiceCompat.AnonymousClass4 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ ResultReceiver f2897O000000o;

                                    {
                                        this.f2897O000000o = r3;
                                    }

                                    /* access modifiers changed from: package-private */
                                    public final void O000000o(Bundle bundle) {
                                        this.f2897O000000o.send(-1, null);
                                    }

                                    /* access modifiers changed from: package-private */
                                    public final /* synthetic */ void O000000o(Object obj) {
                                        this.f2897O000000o.send(0, null);
                                    }
                                };
                                mediaBrowserServiceCompat.O00000o0 = o00000Oo;
                                mediaBrowserServiceCompat.onCustomAction(str, bundle, r5);
                                mediaBrowserServiceCompat.O00000o0 = null;
                                if (!r5.O00000Oo()) {
                                    throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
                                }
                            }
                        });
                        return;
                    }
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message2 + "\n  Service version: 2\n  Client version: " + message2.arg1);
                    return;
            }
        }

        public final boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }

        public final void O000000o(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    class O00000Oo implements IBinder.DeathRecipient {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f2899O000000o;
        public final int O00000Oo;
        public final gb.O000000o O00000o;
        public final int O00000o0;
        public final Bundle O00000oO;
        public final O0000o O00000oo;
        public final HashMap<String, List<be<IBinder, Bundle>>> O0000O0o = new HashMap<>();
        public O000000o O0000OOo;

        O00000Oo(String str, int i, int i2, Bundle bundle, O0000o o0000o) {
            this.f2899O000000o = str;
            this.O00000Oo = i;
            this.O00000o0 = i2;
            this.O00000o = new gb.O000000o(str, i, i2);
            this.O00000oO = bundle;
            this.O00000oo = o0000o;
        }

        public final void binderDied() {
            MediaBrowserServiceCompat.this.O00000o.post(new Runnable() {
                /* class androidx.media.MediaBrowserServiceCompat.O00000Oo.AnonymousClass1 */

                public final void run() {
                    MediaBrowserServiceCompat.this.O00000Oo.remove(O00000Oo.this.O00000oo.O000000o());
                }
            });
        }
    }

    public static class O0000o00<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f2922O000000o;
        final Object O00000oo;
        boolean O0000O0o;
        boolean O0000OOo;
        int O0000Oo0;

        /* access modifiers changed from: package-private */
        public void O000000o(T t) {
        }

        O0000o00(Object obj) {
            this.O00000oo = obj;
        }

        public final void O000000o() {
            if (this.O0000O0o || this.O0000OOo) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.O00000oo);
            }
            this.O0000O0o = true;
            O000000o((Object) null);
        }

        /* access modifiers changed from: package-private */
        public final boolean O00000Oo() {
            return this.f2922O000000o || this.O0000O0o || this.O0000OOo;
        }

        /* access modifiers changed from: package-private */
        public void O000000o(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.O00000oo);
        }
    }

    class O0000o0 {
        O0000o0() {
        }
    }

    static class O00oOooO implements O0000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final Messenger f2924O000000o;

        O00oOooO(Messenger messenger) {
            this.f2924O000000o = messenger;
        }

        public final IBinder O000000o() {
            return this.f2924O000000o.getBinder();
        }

        public final void O000000o(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            O000000o(1, bundle2);
        }

        public final void O00000Oo() throws RemoteException {
            O000000o(2, null);
        }

        public final void O000000o(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            O000000o(3, bundle3);
        }

        private void O000000o(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f2924O000000o.send(obtain);
        }
    }

    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            this.O00000oo = new O0000Oo0();
        } else if (Build.VERSION.SDK_INT >= 26) {
            this.O00000oo = new O0000OOo();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.O00000oo = new O0000O0o();
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.O00000oo = new O00000o();
        } else {
            this.O00000oo = new O0000Oo();
        }
        this.O00000oo.O000000o();
    }

    public IBinder onBind(Intent intent) {
        return this.O00000oo.O000000o(intent);
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.O00000oO == null) {
            this.O00000oO = token;
            this.O00000oo.O000000o(token);
        } else {
            throw new IllegalStateException("The session token has already been set.");
        }
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.O00000oO;
    }

    public final Bundle getBrowserRootHints() {
        return this.O00000oo.O00000Oo();
    }

    public final gb.O000000o getCurrentBrowserInfo() {
        return this.O00000oo.O00000o0();
    }

    public void notifyChildrenChanged(String str) {
        if (str != null) {
            this.O00000oo.O000000o(str, null);
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public void notifyChildrenChanged(String str, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.O00000oo.O000000o(str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    public void notifyChildrenChanged(gb.O000000o o000000o, String str, Bundle bundle) {
        if (o000000o == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        } else if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.O00000oo.O000000o(o000000o, str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str, O00000Oo o00000Oo, IBinder iBinder, Bundle bundle) {
        List<be> list = o00000Oo.O0000O0o.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (be beVar : list) {
            if (iBinder == beVar.f12896O000000o && fx.O000000o(bundle, (Bundle) beVar.O00000Oo)) {
                return;
            }
        }
        list.add(new be(iBinder, bundle));
        o00000Oo.O0000O0o.put(str, list);
        O000000o(str, o00000Oo, bundle, (Bundle) null);
        this.O00000o0 = o00000Oo;
        onSubscribe(str, bundle);
        this.O00000o0 = null;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(String str, O00000Oo o00000Oo, IBinder iBinder) {
        boolean z = true;
        boolean z2 = false;
        if (iBinder == null) {
            try {
                if (o00000Oo.O0000O0o.remove(str) == null) {
                    z = false;
                }
                return z;
            } finally {
                this.O00000o0 = o00000Oo;
                onUnsubscribe(str);
                this.O00000o0 = null;
            }
        } else {
            List list = o00000Oo.O0000O0o.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((be) it.next()).f12896O000000o) {
                        it.remove();
                        z2 = true;
                    }
                }
                if (list.size() == 0) {
                    o00000Oo.O0000O0o.remove(str);
                }
            }
            this.O00000o0 = o00000Oo;
            onUnsubscribe(str);
            this.O00000o0 = null;
            return z2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str, O00000Oo o00000Oo, Bundle bundle, Bundle bundle2) {
        final O00000Oo o00000Oo2 = o00000Oo;
        final String str2 = str;
        final Bundle bundle3 = bundle;
        final Bundle bundle4 = bundle2;
        AnonymousClass1 r0 = new O0000o00<List<MediaBrowserCompat.MediaItem>>(str) {
            /* class androidx.media.MediaBrowserServiceCompat.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public final /* synthetic */ void O000000o(Object obj) {
                if (MediaBrowserServiceCompat.this.O00000Oo.get(o00000Oo2.O00000oo.O000000o()) == o00000Oo2) {
                    List<MediaBrowserCompat.MediaItem> list = null;
                    if ((this.O0000Oo0 & 1) != 0) {
                        list = MediaBrowserServiceCompat.O000000o(null, bundle3);
                    }
                    try {
                        o00000Oo2.O00000oo.O000000o(str2, list, bundle3, bundle4);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str2 + " package=" + o00000Oo2.f2899O000000o);
                    }
                } else if (MediaBrowserServiceCompat.f2893O000000o) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + o00000Oo2.f2899O000000o + " id=" + str2);
                }
            }
        };
        this.O00000o0 = o00000Oo;
        if (bundle == null) {
            onLoadChildren(str, r0);
        } else {
            onLoadChildren(str, r0, bundle);
        }
        this.O00000o0 = null;
        if (!r0.O00000Oo()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + o00000Oo.f2899O000000o + " id=" + str);
        }
    }

    static List<MediaBrowserCompat.MediaItem> O000000o(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int i4 = i3 + i2;
        if (i < 0 || i2 <= 0 || i3 >= list.size()) {
            return Collections.emptyList();
        }
        if (i4 > list.size()) {
            i4 = list.size();
        }
        return list.subList(i3, i4);
    }

    public void onLoadChildren(String str, O0000o00<List<MediaBrowserCompat.MediaItem>> o0000o00, Bundle bundle) {
        o0000o00.O0000Oo0 = 1;
        onLoadChildren(str, o0000o00);
    }

    public void onLoadItem(String str, O0000o00<MediaBrowserCompat.MediaItem> o0000o00) {
        o0000o00.O0000Oo0 = 2;
        o0000o00.O000000o();
    }

    public void onSearch(String str, Bundle bundle, O0000o00<List<MediaBrowserCompat.MediaItem>> o0000o00) {
        o0000o00.O0000Oo0 = 4;
        o0000o00.O000000o();
    }

    public void onCustomAction(String str, Bundle bundle, O0000o00<Bundle> o0000o00) {
        if (o0000o00.O0000O0o || o0000o00.O0000OOo) {
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + o0000o00.O00000oo);
        }
        o0000o00.O0000OOo = true;
        o0000o00.O000000o((Bundle) null);
    }
}
