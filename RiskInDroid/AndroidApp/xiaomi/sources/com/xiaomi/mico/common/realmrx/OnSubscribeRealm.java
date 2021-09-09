package com.xiaomi.mico.common.realmrx;

import _m_j.irn;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

abstract class OnSubscribeRealm<T> implements Observable.OnSubscribe<T> {
    public final AtomicBoolean mCanceled = new AtomicBoolean();
    private final boolean mIgnoreError;
    public final Object mLock = new Object();
    public final List<Subscriber<? super T>> mSubscribers = new ArrayList();

    public abstract T get(irn irn);

    OnSubscribeRealm(boolean z) {
        this.mIgnoreError = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r7.add(newUnsubscribeAction(r7));
        r6.mSubscribers.add(r7);
        r7 = _m_j.irn.O0000OOo();
        r0 = null;
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r6.mCanceled.get() != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r7.O000000o();
        r0 = get(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        if (r0 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        if (r6.mCanceled.get() != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        r7.O00000Oo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        r7.O00000o0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        r7.O00000o0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        if (r6.mIgnoreError == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        sendOnError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006a, code lost:
        r7.O00000o0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006f, code lost:
        if (r6.mIgnoreError == false) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0071, code lost:
        sendOnError(new io.realm.exceptions.RealmException("Error during transaction.", r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0086, code lost:
        sendOnNext(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0090, code lost:
        if (r6.mIgnoreError == false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0092, code lost:
        sendOnError(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0096, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0097, code lost:
        if (r2 == false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0099, code lost:
        sendOnCompleted();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009c, code lost:
        r6.mCanceled.set(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a1, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0099  */
    public void call(Subscriber<? super T> subscriber) {
        synchronized (this.mLock) {
            boolean z = this.mCanceled.get();
            if (!z && !this.mSubscribers.isEmpty()) {
                subscriber.add(newUnsubscribeAction(subscriber));
                this.mSubscribers.add(subscriber);
            } else if (z) {
            }
        }
    }

    private void sendOnNext(T t) {
        for (int i = 0; i < this.mSubscribers.size(); i++) {
            this.mSubscribers.get(i).onNext(t);
        }
    }

    private void sendOnError(Throwable th) {
        for (int i = 0; i < this.mSubscribers.size(); i++) {
            this.mSubscribers.get(i).onError(th);
        }
    }

    private void sendOnCompleted() {
        for (int i = 0; i < this.mSubscribers.size(); i++) {
            this.mSubscribers.get(i).onCompleted();
        }
    }

    private Subscription newUnsubscribeAction(final Subscriber<? super T> subscriber) {
        return Subscriptions.create(new Action0() {
            /* class com.xiaomi.mico.common.realmrx.OnSubscribeRealm.AnonymousClass1 */

            public void call() {
                synchronized (OnSubscribeRealm.this.mLock) {
                    OnSubscribeRealm.this.mSubscribers.remove(subscriber);
                    if (OnSubscribeRealm.this.mSubscribers.isEmpty()) {
                        OnSubscribeRealm.this.mCanceled.set(true);
                    }
                }
            }
        });
    }
}
