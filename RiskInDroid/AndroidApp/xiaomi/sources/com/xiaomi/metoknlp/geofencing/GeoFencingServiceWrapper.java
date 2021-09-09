package com.xiaomi.metoknlp.geofencing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.xiaomi.metoknlp.geofencing.IGeoFencing;
import java.util.ArrayList;
import java.util.List;

public class GeoFencingServiceWrapper {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f5980O000000o;
    public IGeoFencing O00000Oo;
    public int O00000o = 0;
    public boolean O00000o0 = false;
    public Handler O00000oO;
    private List<O00000Oo> O00000oo = new ArrayList();
    private final ServiceConnection O0000O0o = new ServiceConnection() {
        /* class com.xiaomi.metoknlp.geofencing.GeoFencingServiceWrapper.AnonymousClass1 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.v("GeoFencingServiceWrapper", "*** GeoFencingService connected ***");
            GeoFencingServiceWrapper.this.O00000Oo = IGeoFencing.Stub.asInterface(iBinder);
            if (GeoFencingServiceWrapper.this.O00000oO != null) {
                GeoFencingServiceWrapper.this.O00000oO.sendEmptyMessageDelayed(2, 60000);
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            Log.v("GeoFencingServiceWrapper", "*** GeoFencingService disconnected ***");
            GeoFencingServiceWrapper.this.O00000Oo = null;
        }
    };

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public double f5983O000000o;
        public double O00000Oo;
        public long O00000o;
        public float O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
    }

    public GeoFencingServiceWrapper(Context context) {
        this.f5980O000000o = context;
        this.O00000o0 = false;
        O000000o(context);
        HandlerThread handlerThread = new HandlerThread("GeoFencingServiceWrapper");
        handlerThread.start();
        this.O00000oO = new O000000o(handlerThread.getLooper());
        if (!this.O00000o0) {
            this.O00000oO.sendEmptyMessageDelayed(1, 10000);
        }
    }

    class O000000o extends Handler {
        public O000000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GeoFencingServiceWrapper.this.O00000o++;
                GeoFencingServiceWrapper geoFencingServiceWrapper = GeoFencingServiceWrapper.this;
                geoFencingServiceWrapper.O000000o(geoFencingServiceWrapper.f5980O000000o);
                Log.w("GeoFencingServiceWrapper", "Try bindService count=" + GeoFencingServiceWrapper.this.O00000o + ",mBinded=" + GeoFencingServiceWrapper.this.O00000o0);
                if (!GeoFencingServiceWrapper.this.O00000o0 && GeoFencingServiceWrapper.this.O00000oO != null && GeoFencingServiceWrapper.this.O00000o < 10) {
                    GeoFencingServiceWrapper.this.O00000oO.sendEmptyMessageDelayed(1, 10000);
                }
            } else if (i != 2) {
                Log.w("GeoFencingServiceWrapper", "unknown message type ");
            } else {
                GeoFencingServiceWrapper.this.O000000o();
            }
        }
    }

    public final void O000000o() {
        IGeoFencing iGeoFencing;
        Log.d("GeoFencingServiceWrapper", "registerPendingFence");
        for (O00000Oo next : this.O00000oo) {
            if (!(next == null || (iGeoFencing = this.O00000Oo) == null)) {
                try {
                    iGeoFencing.registerFenceListener(next.f5983O000000o, next.O00000Oo, next.O00000o0, next.O00000o, next.O00000oO, next.O00000oo, next.O0000O0o);
                } catch (RemoteException e) {
                    Log.w("GeoFencingServiceWrapper", "registerPendingFence:".concat(String.valueOf(e)));
                }
            }
        }
    }

    public final void O000000o(Context context) {
        if (!this.O00000o0 && context != null) {
            if (this.O00000Oo == null) {
                Intent intent = new Intent("com.xiaomi.metoknlp.GeoFencingService");
                intent.setPackage("com.xiaomi.metoknlp");
                try {
                    if (!context.bindService(intent, this.O0000O0o, 1)) {
                        Log.d("GeoFencingServiceWrapper", "Can't bind GeoFencingService");
                        this.O00000o0 = false;
                        return;
                    }
                    Log.d("GeoFencingServiceWrapper", "GeoFencingService started");
                    this.O00000o0 = true;
                } catch (SecurityException e) {
                    Log.e("GeoFencingServiceWrapper", "SecurityException:".concat(String.valueOf(e)));
                }
            } else {
                Log.d("GeoFencingServiceWrapper", "GeoFencingService already started");
            }
        }
    }
}
