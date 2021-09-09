package com.mibi.sdk.mvp;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.mvp.IView;
import com.mibi.sdk.mvp.lifecycle.ILifeCycleListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class Presenter<T extends IView> implements IPresenter {
    private Bundle mArguments;
    private Context mContext;
    private String mId = UUID.randomUUID().toString();
    private final Presenter<T>.PendingEventInvocationHandler mInvocationHandler;
    private ArrayList<ILifeCycleListener> mLifeCycleListeners = new ArrayList<>();
    public T mView;
    private final Class<T> mViewInterface;
    private T mViewProxy;

    /* access modifiers changed from: protected */
    public void onAttach() {
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
    }

    /* access modifiers changed from: protected */
    public void onInit(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onPause() {
    }

    /* access modifiers changed from: protected */
    public void onRelease() {
    }

    /* access modifiers changed from: protected */
    public void onResume(IView iView) {
    }

    /* access modifiers changed from: protected */
    public void onSave(Bundle bundle) {
    }

    public Presenter(Class<T> cls) {
        this.mViewInterface = cls;
        this.mInvocationHandler = new PendingEventInvocationHandler();
    }

    public final void init(Context context, Bundle bundle, Bundle bundle2) {
        this.mContext = context.getApplicationContext();
        this.mArguments = bundle;
        if (bundle2 != null) {
            this.mId = bundle2.getString("SAVE_ID");
        }
        onInit(bundle2);
    }

    public Bundle getArguments() {
        checkInLifecycle();
        return this.mArguments;
    }

    public final void attach(IView iView) {
        this.mView = iView;
        this.mInvocationHandler.applyPendingEvent();
        onAttach();
    }

    public final void detach() {
        onDetach();
        this.mView = null;
    }

    public void resume(IView iView) {
        onResume(iView);
        Iterator<ILifeCycleListener> it = this.mLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    public void pause() {
        onPause();
        Iterator<ILifeCycleListener> it = this.mLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    public final void save(Bundle bundle) {
        bundle.putString("SAVE_ID", this.mId);
        onSave(bundle);
    }

    public final void release() {
        onRelease();
        this.mView = null;
        Iterator<ILifeCycleListener> it = this.mLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mInvocationHandler.clear();
        this.mLifeCycleListeners.clear();
    }

    public String getId() {
        return this.mId;
    }

    public T getView() {
        Utils.ensureOnMainThread();
        if (this.mViewProxy == null) {
            this.mViewProxy = (IView) Proxy.newProxyInstance(this.mViewInterface.getClassLoader(), new Class[]{this.mViewInterface}, this.mInvocationHandler);
        }
        return this.mViewProxy;
    }

    public Context getContext() {
        checkInLifecycle();
        return this.mContext;
    }

    public void handleResult(int i, int i2, Bundle bundle) {
        Iterator<ILifeCycleListener> it = this.mLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().handleResult(i, i2, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void checkInLifecycle() {
        if (this.mContext == null) {
            throw new IllegalStateException("Do not call this method before onInit");
        }
    }

    /* access modifiers changed from: protected */
    public void addLifeCycleListener(ILifeCycleListener iLifeCycleListener) {
        this.mLifeCycleListeners.add(iLifeCycleListener);
    }

    class PendingEventInvocationHandler implements InvocationHandler {
        private Queue<Presenter<T>.PendingEventInvocationHandler.ViewEvent> mPendingViewEvents;

        private PendingEventInvocationHandler() {
            this.mPendingViewEvents = new LinkedList();
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Utils.ensureOnMainThread();
            ViewEvent viewEvent = new ViewEvent();
            viewEvent.mMethod = method;
            viewEvent.mArgs = objArr;
            this.mPendingViewEvents.offer(viewEvent);
            applyPendingEvent();
            return null;
        }

        public void applyPendingEvent() {
            if (Presenter.this.mView != null) {
                while (!this.mPendingViewEvents.isEmpty()) {
                    ViewEvent poll = this.mPendingViewEvents.poll();
                    try {
                        poll.mMethod.invoke(Presenter.this.mView, poll.mArgs);
                    } catch (Exception e) {
                        throw new IllegalStateException("apply pending method invocation error when view attached", e);
                    }
                }
            }
        }

        public void clear() {
            this.mPendingViewEvents.clear();
        }

        class ViewEvent {
            Object[] mArgs;
            Method mMethod;

            private ViewEvent() {
            }
        }
    }
}
