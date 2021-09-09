package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class k {

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f6455O000000o;
        private final boolean O00000Oo = false;

        O000000o(String str) {
            this.f6455O000000o = str;
        }
    }

    static final class O00000Oo implements ServiceConnection {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f6456O000000o;
        final LinkedBlockingQueue<IBinder> O00000Oo;

        private O00000Oo() {
            this.f6456O000000o = false;
            this.O00000Oo = new LinkedBlockingQueue<>(1);
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.O00000Oo.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f6457a;

        public c(IBinder iBinder) {
            this.f6457a = iBinder;
        }

        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f6457a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final IBinder asBinder() {
            return this.f6457a;
        }
    }

    public static O000000o O000000o(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                O00000Oo o00000Oo = new O00000Oo((byte) 0);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, o00000Oo, 1)) {
                    try {
                        if (!o00000Oo.f6456O000000o) {
                            o00000Oo.f6456O000000o = true;
                            IBinder poll = o00000Oo.O00000Oo.poll(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, TimeUnit.MILLISECONDS);
                            if (poll != null) {
                                O000000o o000000o = new O000000o(new c(poll).a());
                                context.unbindService(o00000Oo);
                                return o000000o;
                            }
                            context.unbindService(o00000Oo);
                        } else {
                            throw new IllegalStateException();
                        }
                    } catch (Exception e) {
                        throw e;
                    } catch (Throwable th) {
                        context.unbindService(o00000Oo);
                        throw th;
                    }
                }
                throw new IOException("Google Play connection failed");
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }
}
