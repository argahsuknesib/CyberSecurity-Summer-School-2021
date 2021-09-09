package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseGmsClient<T extends IInterface> {
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    private static final Feature[] zzqz = new Feature[0];
    @VisibleForTesting
    protected ConnectionProgressReportCallbacks mConnectionProgressReportCallbacks;
    private final Context mContext;
    @VisibleForTesting
    protected AtomicInteger mDisconnectCount;
    final Handler mHandler;
    private final Object mLock;
    private final Looper zzcn;
    private final GoogleApiAvailabilityLight zzgk;
    private int zzra;
    private long zzrb;
    private long zzrc;
    private int zzrd;
    private long zzre;
    @VisibleForTesting
    private GmsServiceEndpoint zzrf;
    private final GmsClientSupervisor zzrg;
    /* access modifiers changed from: private */
    public final Object zzrh;
    /* access modifiers changed from: private */
    public IGmsServiceBroker zzri;
    private T zzrj;
    /* access modifiers changed from: private */
    public final ArrayList<BaseGmsClient<T>.CallbackProxy<?>> zzrk;
    private BaseGmsClient<T>.GmsServiceConnection zzrl;
    private int zzrm;
    /* access modifiers changed from: private */
    public final BaseConnectionCallbacks zzrn;
    /* access modifiers changed from: private */
    public final BaseOnConnectionFailedListener zzro;
    private final int zzrp;
    private final String zzrq;
    /* access modifiers changed from: private */
    public ConnectionResult zzrr;
    /* access modifiers changed from: private */
    public boolean zzrs;
    private volatile ConnectionInfo zzrt;

    public interface BaseConnectionCallbacks {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public abstract class CallbackProxy<TListener> {
        private TListener zzli;
        private boolean zzrv = false;

        public CallbackProxy(TListener tlistener) {
            this.zzli = tlistener;
        }

        public void deliverCallback() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.zzli;
                if (this.zzrv) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    deliverCallback(tlistener);
                } catch (RuntimeException e) {
                    onDeliverCallbackFailed();
                    throw e;
                }
            } else {
                onDeliverCallbackFailed();
            }
            synchronized (this) {
                this.zzrv = true;
            }
            unregister();
        }

        /* access modifiers changed from: protected */
        public abstract void deliverCallback(TListener tlistener);

        /* access modifiers changed from: protected */
        public abstract void onDeliverCallbackFailed();

        public void removeListener() {
            synchronized (this) {
                this.zzli = null;
            }
        }

        public void unregister() {
            removeListener();
            synchronized (BaseGmsClient.this.zzrk) {
                BaseGmsClient.this.zzrk.remove(this);
            }
        }
    }

    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    @VisibleForTesting
    public static final class GmsCallbacks extends IGmsCallbacks.Stub {
        private BaseGmsClient zzrw;
        private final int zzrx;

        public GmsCallbacks(BaseGmsClient baseGmsClient, int i) {
            this.zzrw = baseGmsClient;
            this.zzrx = i;
        }

        public final void onAccountValidationComplete(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
            Preconditions.checkNotNull(this.zzrw, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzrw.onPostInitHandler(i, iBinder, bundle, this.zzrx);
            this.zzrw = null;
        }

        public final void onPostInitCompleteWithConnectionInfo(int i, IBinder iBinder, ConnectionInfo connectionInfo) {
            Preconditions.checkNotNull(this.zzrw, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.checkNotNull(connectionInfo);
            this.zzrw.zza(connectionInfo);
            onPostInitComplete(i, iBinder, connectionInfo.getResolutionBundle());
        }
    }

    @VisibleForTesting
    public final class GmsServiceConnection implements ServiceConnection {
        private final int zzrx;

        public GmsServiceConnection(int i) {
            this.zzrx = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder == null) {
                BaseGmsClient.this.zzj(16);
                return;
            }
            synchronized (BaseGmsClient.this.zzrh) {
                IGmsServiceBroker unused = BaseGmsClient.this.zzri = IGmsServiceBroker.Stub.asInterface(iBinder);
            }
            BaseGmsClient.this.onPostServiceBindingHandler(0, null, this.zzrx);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.zzrh) {
                IGmsServiceBroker unused = BaseGmsClient.this.zzri = (IGmsServiceBroker) null;
            }
            BaseGmsClient.this.mHandler.sendMessage(BaseGmsClient.this.mHandler.obtainMessage(6, this.zzrx, 1));
        }
    }

    public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        public LegacyClientCallbackAdapter() {
        }

        public void onReportServiceBinding(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else if (BaseGmsClient.this.zzro != null) {
                BaseGmsClient.this.zzro.onConnectionFailed(connectionResult);
            }
        }
    }

    public final class PostInitCallback extends zza {
        public final IBinder service;

        public PostInitCallback(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.service = iBinder;
        }

        /* access modifiers changed from: protected */
        public final void handleServiceFailure(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.zzro != null) {
                BaseGmsClient.this.zzro.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public final boolean handleServiceSuccess() {
            try {
                String interfaceDescriptor = this.service.getInterfaceDescriptor();
                if (!BaseGmsClient.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String serviceDescriptor = BaseGmsClient.this.getServiceDescriptor();
                    StringBuilder sb = new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(serviceDescriptor);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface createServiceInterface = BaseGmsClient.this.createServiceInterface(this.service);
                if (createServiceInterface == null || (!BaseGmsClient.this.zza(2, 4, createServiceInterface) && !BaseGmsClient.this.zza(3, 4, createServiceInterface))) {
                    return false;
                }
                ConnectionResult unused = BaseGmsClient.this.zzrr = (ConnectionResult) null;
                Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                if (BaseGmsClient.this.zzrn == null) {
                    return true;
                }
                BaseGmsClient.this.zzrn.onConnected(connectionHint);
                return true;
            } catch (RemoteException unused2) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    public final class PostServiceBindingCallback extends zza {
        public PostServiceBindingCallback(int i, Bundle bundle) {
            super(i, bundle);
        }

        /* access modifiers changed from: protected */
        public final void handleServiceFailure(ConnectionResult connectionResult) {
            BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(connectionResult);
            BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public final boolean handleServiceSuccess() {
            BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    public interface SignOutCallbacks {
        void onSignOutComplete();
    }

    abstract class zza extends BaseGmsClient<T>.CallbackProxy<Boolean> {
        public final Bundle resolution;
        public final int statusCode;

        protected zza(int i, Bundle bundle) {
            super(Boolean.TRUE);
            this.statusCode = i;
            this.resolution = bundle;
        }

        /* JADX WARN: Type inference failed for: r4v10, types: [android.os.Parcelable] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        public void deliverCallback(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                BaseGmsClient.this.zza(1, (IInterface) null);
                return;
            }
            int i = this.statusCode;
            if (i != 0) {
                if (i != 10) {
                    BaseGmsClient.this.zza(1, (IInterface) null);
                    Bundle bundle = this.resolution;
                    if (bundle != null) {
                        pendingIntent = bundle.getParcelable("pendingIntent");
                    }
                    handleServiceFailure(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
                }
                BaseGmsClient.this.zza(1, (IInterface) null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            } else if (!handleServiceSuccess()) {
                BaseGmsClient.this.zza(1, (IInterface) null);
                handleServiceFailure(new ConnectionResult(8, null));
            }
        }

        /* access modifiers changed from: protected */
        public abstract void handleServiceFailure(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean handleServiceSuccess();

        /* access modifiers changed from: protected */
        public void onDeliverCallbackFailed() {
        }
    }

    final class zzb extends Handler {
        public zzb(Looper looper) {
            super(looper);
        }

        private static void zza(Message message) {
            CallbackProxy callbackProxy = (CallbackProxy) message.obj;
            callbackProxy.onDeliverCallbackFailed();
            callbackProxy.unregister();
        }

        private static boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.app.PendingIntent} */
        /* JADX WARNING: Multi-variable type inference failed */
        public final void handleMessage(Message message) {
            if (BaseGmsClient.this.mDisconnectCount.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                }
            } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !BaseGmsClient.this.isConnecting()) {
                zza(message);
            } else {
                PendingIntent pendingIntent = null;
                if (message.what == 4) {
                    ConnectionResult unused = BaseGmsClient.this.zzrr = new ConnectionResult(message.arg2);
                    if (!BaseGmsClient.this.zzcr() || BaseGmsClient.this.zzrs) {
                        ConnectionResult zzd = BaseGmsClient.this.zzrr != null ? BaseGmsClient.this.zzrr : new ConnectionResult(8);
                        BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(zzd);
                        BaseGmsClient.this.onConnectionFailed(zzd);
                        return;
                    }
                    BaseGmsClient.this.zza(3, (IInterface) null);
                } else if (message.what == 5) {
                    ConnectionResult zzd2 = BaseGmsClient.this.zzrr != null ? BaseGmsClient.this.zzrr : new ConnectionResult(8);
                    BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(zzd2);
                    BaseGmsClient.this.onConnectionFailed(zzd2);
                } else if (message.what == 3) {
                    if (message.obj instanceof PendingIntent) {
                        pendingIntent = message.obj;
                    }
                    ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                    BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(connectionResult);
                    BaseGmsClient.this.onConnectionFailed(connectionResult);
                } else if (message.what == 6) {
                    BaseGmsClient.this.zza(5, (IInterface) null);
                    if (BaseGmsClient.this.zzrn != null) {
                        BaseGmsClient.this.zzrn.onConnectionSuspended(message.arg2);
                    }
                    BaseGmsClient.this.onConnectionSuspended(message.arg2);
                    boolean unused2 = BaseGmsClient.this.zza(5, 1, null);
                } else if (message.what == 2 && !BaseGmsClient.this.isConnected()) {
                    zza(message);
                } else if (zzb(message)) {
                    ((CallbackProxy) message.obj).deliverCallback();
                } else {
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i);
                    Log.wtf("GmsClient", sb.toString(), new Exception());
                }
            }
        }
    }

    @VisibleForTesting
    protected BaseGmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.mLock = new Object();
        this.zzrh = new Object();
        this.zzrk = new ArrayList<>();
        this.zzrm = 1;
        this.zzrr = null;
        this.zzrs = false;
        this.zzrt = null;
        this.mDisconnectCount = new AtomicInteger(0);
        this.mContext = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.mHandler = (Handler) Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zzcn = handler.getLooper();
        this.zzrg = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzgk = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzrp = i;
        this.zzrn = baseConnectionCallbacks;
        this.zzro = baseOnConnectionFailedListener;
        this.zzrq = null;
    }

    protected BaseGmsClient(Context context, Looper looper, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailabilityLight.getInstance(), i, (BaseConnectionCallbacks) Preconditions.checkNotNull(baseConnectionCallbacks), (BaseOnConnectionFailedListener) Preconditions.checkNotNull(baseOnConnectionFailedListener), str);
    }

    @VisibleForTesting
    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.mLock = new Object();
        this.zzrh = new Object();
        this.zzrk = new ArrayList<>();
        this.zzrm = 1;
        this.zzrr = null;
        this.zzrs = false;
        this.zzrt = null;
        this.mDisconnectCount = new AtomicInteger(0);
        this.mContext = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.zzcn = (Looper) Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzrg = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzgk = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.mHandler = new zzb(looper);
        this.zzrp = i;
        this.zzrn = baseConnectionCallbacks;
        this.zzro = baseOnConnectionFailedListener;
        this.zzrq = str;
    }

    /* access modifiers changed from: private */
    public final void zza(int i, T t) {
        Preconditions.checkArgument((i == 4) == (t != null));
        synchronized (this.mLock) {
            this.zzrm = i;
            this.zzrj = t;
            onSetConnectState(i, t);
            if (i != 1) {
                if (i == 2 || i == 3) {
                    if (!(this.zzrl == null || this.zzrf == null)) {
                        String zzcw = this.zzrf.zzcw();
                        String packageName = this.zzrf.getPackageName();
                        StringBuilder sb = new StringBuilder(String.valueOf(zzcw).length() + 70 + String.valueOf(packageName).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(zzcw);
                        sb.append(" on ");
                        sb.append(packageName);
                        Log.e("GmsClient", sb.toString());
                        this.zzrg.unbindService(this.zzrf.zzcw(), this.zzrf.getPackageName(), this.zzrf.getBindFlags(), this.zzrl, getRealClientName());
                        this.mDisconnectCount.incrementAndGet();
                    }
                    this.zzrl = new GmsServiceConnection(this.mDisconnectCount.get());
                    this.zzrf = (this.zzrm != 3 || getLocalStartServiceAction() == null) ? new GmsServiceEndpoint(getStartServicePackage(), getStartServiceAction(), false, getServiceBindFlags()) : new GmsServiceEndpoint(getContext().getPackageName(), getLocalStartServiceAction(), true, getServiceBindFlags());
                    if (!this.zzrg.bindService(this.zzrf.zzcw(), this.zzrf.getPackageName(), this.zzrf.getBindFlags(), this.zzrl, getRealClientName())) {
                        String zzcw2 = this.zzrf.zzcw();
                        String packageName2 = this.zzrf.getPackageName();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(zzcw2).length() + 34 + String.valueOf(packageName2).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(zzcw2);
                        sb2.append(" on ");
                        sb2.append(packageName2);
                        Log.e("GmsClient", sb2.toString());
                        onPostServiceBindingHandler(16, null, this.mDisconnectCount.get());
                    }
                } else if (i == 4) {
                    onConnectedLocked(t);
                }
            } else if (this.zzrl != null) {
                this.zzrg.unbindService(getStartServiceAction(), getStartServicePackage(), getServiceBindFlags(), this.zzrl, getRealClientName());
                this.zzrl = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zza(ConnectionInfo connectionInfo) {
        this.zzrt = connectionInfo;
    }

    /* access modifiers changed from: private */
    public final boolean zza(int i, int i2, T t) {
        synchronized (this.mLock) {
            if (this.zzrm != i) {
                return false;
            }
            zza(i2, t);
            return true;
        }
    }

    private final boolean zzcq() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzrm == 3;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final boolean zzcr() {
        if (this.zzrs || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzj(int i) {
        int i2;
        if (zzcq()) {
            i2 = 5;
            this.zzrs = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(i2, this.mDisconnectCount.get(), 16));
    }

    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzgk.isGooglePlayServicesAvailable(this.mContext, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, (IInterface) null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, null);
            return;
        }
        connect(new LegacyClientCallbackAdapter());
    }

    /* access modifiers changed from: protected */
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.mConnectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        zza(2, (IInterface) null);
    }

    /* access modifiers changed from: protected */
    public abstract T createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.mDisconnectCount.incrementAndGet();
        synchronized (this.zzrk) {
            int size = this.zzrk.size();
            for (int i = 0; i < size; i++) {
                this.zzrk.get(i).removeListener();
            }
            this.zzrk.clear();
        }
        synchronized (this.zzrh) {
            this.zzri = null;
        }
        zza(1, (IInterface) null);
    }

    @Deprecated
    public final void doCallbackDEPRECATED(BaseGmsClient<T>.CallbackProxy<?> callbackProxy) {
        synchronized (this.zzrk) {
            this.zzrk.add(callbackProxy);
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(2, this.mDisconnectCount.get(), -1, callbackProxy));
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.mLock) {
            i = this.zzrm;
            t = this.zzrj;
        }
        synchronized (this.zzrh) {
            iGmsServiceBroker = this.zzri;
        }
        printWriter.append((CharSequence) str).append((CharSequence) "mConnectState=");
        printWriter.print(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append((CharSequence) " mService=");
        if (t == null) {
            printWriter.append((CharSequence) "null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append((CharSequence) "@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append((CharSequence) " mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append((CharSequence) "IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzrc > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append((CharSequence) "lastConnectedTime=");
            long j = this.zzrc;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzrb > 0) {
            printWriter.append((CharSequence) str).append((CharSequence) "lastSuspendedCause=");
            int i2 = this.zzra;
            printWriter.append((CharSequence) (i2 != 1 ? i2 != 2 ? String.valueOf(i2) : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED"));
            PrintWriter append2 = printWriter.append((CharSequence) " lastSuspendedTime=");
            long j2 = this.zzrb;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzre > 0) {
            printWriter.append((CharSequence) str).append((CharSequence) "lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzrd));
            PrintWriter append3 = printWriter.append((CharSequence) " lastFailedTime=");
            long j3 = this.zzre;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Account getAccountOrDefault() {
        return getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
    }

    public Feature[] getApiFeatures() {
        return zzqz;
    }

    public final Feature[] getAvailableFeatures() {
        ConnectionInfo connectionInfo = this.zzrt;
        if (connectionInfo == null) {
            return null;
        }
        return connectionInfo.getAvailableFeatures();
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public String getEndpointPackageName() {
        GmsServiceEndpoint gmsServiceEndpoint;
        if (isConnected() && (gmsServiceEndpoint = this.zzrf) != null) {
            return gmsServiceEndpoint.getPackageName();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    /* access modifiers changed from: protected */
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @VisibleForTesting
    public final Handler getHandlerForTesting() {
        return this.mHandler;
    }

    /* access modifiers changed from: protected */
    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzcn;
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getRealClientName() {
        String str = this.zzrq;
        return str == null ? this.mContext.getClass().getName() : str;
    }

    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        GetServiceRequest extraArgs = new GetServiceRequest(this.zzrp).setCallingPackage(this.mContext.getPackageName()).setExtraArgs(getGetServiceRequestExtraArgs());
        if (set != null) {
            extraArgs.setScopes(set);
        }
        if (requiresSignIn()) {
            extraArgs.setClientRequestedAccount(getAccountOrDefault()).setAuthenticatedAccount(iAccountAccessor);
        } else if (requiresAccount()) {
            extraArgs.setClientRequestedAccount(getAccount());
        }
        extraArgs.setClientRequiredFeatures(getRequiredFeatures());
        extraArgs.setClientApiFeatures(getApiFeatures());
        try {
            synchronized (this.zzrh) {
                if (this.zzri != null) {
                    this.zzri.getService(new GmsCallbacks(this, this.mDisconnectCount.get()), extraArgs);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            triggerConnectionSuspended(1);
        } catch (SecurityException e2) {
            throw e2;
        } catch (RemoteException | RuntimeException e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            onPostInitHandler(8, null, null, this.mDisconnectCount.get());
        }
    }

    public Feature[] getRequiredFeatures() {
        return zzqz;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> getScopes() {
        return Collections.EMPTY_SET;
    }

    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.mLock) {
            if (this.zzrm != 5) {
                checkConnected();
                Preconditions.checkState(this.zzrj != null, "Client is connected but service is null");
                t = this.zzrj;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public int getServiceBindFlags() {
        return 129;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzrh) {
            if (this.zzri == null) {
                return null;
            }
            IBinder asBinder = this.zzri.asBinder();
            return asBinder;
        }
    }

    @VisibleForTesting
    public final IGmsServiceBroker getServiceBrokerForTesting() {
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.zzrh) {
            iGmsServiceBroker = this.zzri;
        }
        return iGmsServiceBroker;
    }

    /* access modifiers changed from: protected */
    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* access modifiers changed from: protected */
    public abstract String getStartServiceAction();

    /* access modifiers changed from: protected */
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzrm == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            if (this.zzrm != 2) {
                if (this.zzrm != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onConnectedLocked(T t) {
        this.zzrc = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzrd = connectionResult.getErrorCode();
        this.zzre = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onConnectionSuspended(int i) {
        this.zzra = i;
        this.zzrb = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new PostInitCallback(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    public void onPostServiceBindingHandler(int i, Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new PostServiceBindingCallback(i, bundle)));
    }

    /* access modifiers changed from: package-private */
    public void onSetConnectState(int i, T t) {
    }

    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    @VisibleForTesting
    public void setConnectionInfoForTesting(ConnectionInfo connectionInfo) {
        this.zzrt = connectionInfo;
    }

    @VisibleForTesting
    public final void setServiceBrokerForTesting(IGmsServiceBroker iGmsServiceBroker) {
        synchronized (this.zzrh) {
            this.zzri = iGmsServiceBroker;
        }
    }

    @VisibleForTesting
    public final void setServiceForTesting(T t) {
        zza(t != null ? (char) 4 : 1, t);
    }

    public void triggerConnectionSuspended(int i) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(6, this.mDisconnectCount.get(), i));
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public void triggerNotAvailable(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, PendingIntent pendingIntent) {
        this.mConnectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3, this.mDisconnectCount.get(), i, pendingIntent));
    }
}
