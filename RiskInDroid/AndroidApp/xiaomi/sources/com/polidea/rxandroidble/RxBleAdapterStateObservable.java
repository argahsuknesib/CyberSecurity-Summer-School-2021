package com.polidea.rxandroidble;

import _m_j.cqt;
import _m_j.cqu;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

public class RxBleAdapterStateObservable extends Observable<O000000o> {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f5415O000000o = new O000000o(true);
        public static final O000000o O00000Oo = new O000000o(false);
        public static final O000000o O00000o = new O000000o(false);
        public static final O000000o O00000o0 = new O000000o(false);
        private final boolean O00000oO;

        private O000000o(boolean z) {
            this.O00000oO = z;
        }
    }

    public RxBleAdapterStateObservable(Context context) {
        super(cqt.O000000o(context));
    }

    public static /* synthetic */ void O000000o(Context context, final Subscriber subscriber) {
        Context applicationContext = context.getApplicationContext();
        AnonymousClass1 r0 = new BroadcastReceiver() {
            /* class com.polidea.rxandroidble.RxBleAdapterStateObservable.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                RxBleAdapterStateObservable.O000000o(intent, subscriber);
            }
        };
        applicationContext.registerReceiver(r0, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        subscriber.add(Subscriptions.create(cqu.O000000o(applicationContext, r0)));
    }

    public static void O000000o(Intent intent, Subscriber<? super O000000o> subscriber) {
        O000000o o000000o;
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1)) {
                case 11:
                    o000000o = O000000o.O00000o0;
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    o000000o = O000000o.f5415O000000o;
                    break;
                case 13:
                    o000000o = O000000o.O00000o;
                    break;
                default:
                    o000000o = O000000o.O00000Oo;
                    break;
            }
            subscriber.onNext(o000000o);
        }
    }
}
