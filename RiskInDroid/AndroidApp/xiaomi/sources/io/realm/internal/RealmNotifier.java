package io.realm.internal;

import _m_j.iro;
import _m_j.ise;
import io.realm.internal.OsObject;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

@Keep
public abstract class RealmNotifier implements Closeable {
    private List<Runnable> finishedSendingNotificationsCallbacks = new ArrayList();
    private final ise.O000000o<O000000o> onChangeCallBack = new ise.O000000o<O000000o>() {
        /* class io.realm.internal.RealmNotifier.AnonymousClass1 */

        public final /* synthetic */ void O000000o(ise.O00000Oo o00000Oo, Object obj) {
            if (RealmNotifier.this.sharedRealm != null) {
                RealmNotifier.this.sharedRealm.isClosed();
            }
        }
    };
    private ise<O000000o> realmObserverPairs = new ise<>();
    public OsSharedRealm sharedRealm;
    private List<Runnable> startSendingNotificationsCallbacks = new ArrayList();
    private List<Runnable> transactionCallbacks = new ArrayList();

    public abstract boolean post(Runnable runnable);

    static class O000000o<T> extends ise.O00000Oo<T, iro<T>> {
        public O000000o(T t, iro<T> iro) {
            super(t, iro);
        }
    }

    protected RealmNotifier(OsSharedRealm osSharedRealm) {
        this.sharedRealm = osSharedRealm;
    }

    /* access modifiers changed from: package-private */
    public void didChange() {
        this.realmObserverPairs.O000000o((ise.O000000o<OsObject.O00000Oo>) this.onChangeCallBack);
        if (!this.transactionCallbacks.isEmpty()) {
            List<Runnable> list = this.transactionCallbacks;
            this.transactionCallbacks = new ArrayList();
            for (Runnable run : list) {
                run.run();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void beforeNotify() {
        this.sharedRealm.invalidateIterators();
    }

    /* access modifiers changed from: package-private */
    public void willSendNotifications() {
        for (int i = 0; i < this.startSendingNotificationsCallbacks.size(); i++) {
            this.startSendingNotificationsCallbacks.get(i).run();
        }
    }

    /* access modifiers changed from: package-private */
    public void didSendNotifications() {
        for (int i = 0; i < this.startSendingNotificationsCallbacks.size(); i++) {
            this.finishedSendingNotificationsCallbacks.get(i).run();
        }
    }

    public void close() {
        removeAllChangeListeners();
        this.startSendingNotificationsCallbacks.clear();
        this.finishedSendingNotificationsCallbacks.clear();
    }

    public <T> void addChangeListener(T t, iro<T> iro) {
        this.realmObserverPairs.O000000o((OsObject.O00000Oo) new O000000o(t, iro));
    }

    public <E> void removeChangeListener(E e, iro<E> iro) {
        this.realmObserverPairs.O000000o(e, iro);
    }

    public <E> void removeChangeListeners(E e) {
        this.realmObserverPairs.O000000o((Object) e);
    }

    private void removeAllChangeListeners() {
        ise<O000000o> ise = this.realmObserverPairs;
        ise.O00000Oo = true;
        ise.f1600O000000o.clear();
    }

    public void addTransactionCallback(Runnable runnable) {
        this.transactionCallbacks.add(runnable);
    }

    public int getListenersListSize() {
        return this.realmObserverPairs.f1600O000000o.size();
    }

    public void addBeginSendingNotificationsCallback(Runnable runnable) {
        this.startSendingNotificationsCallbacks.add(runnable);
    }

    public void addFinishedSendingNotificationsCallback(Runnable runnable) {
        this.finishedSendingNotificationsCallbacks.add(runnable);
    }
}
