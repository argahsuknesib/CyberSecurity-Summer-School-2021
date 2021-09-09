package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final String TAG = "com.facebook.appevents.suggestedevents.ViewObserver";
    private static final Map<Integer, ViewObserver> observers = new HashMap();
    public WeakReference<Activity> activityWeakReference;
    private AtomicBoolean isTracking = new AtomicBoolean(false);
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    static void startTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        if (!observers.containsKey(Integer.valueOf(hashCode))) {
            ViewObserver viewObserver = new ViewObserver(activity);
            observers.put(Integer.valueOf(hashCode), viewObserver);
            viewObserver.startTracking();
        }
    }

    static void stopTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        if (observers.containsKey(Integer.valueOf(hashCode))) {
            observers.remove(Integer.valueOf(hashCode));
            observers.get(Integer.valueOf(hashCode)).stopTracking();
        }
    }

    private ViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
    }

    private void startTracking() {
        View rootView;
        if (!this.isTracking.getAndSet(true) && (rootView = getRootView()) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
                process();
            }
        }
    }

    private void stopTracking() {
        View rootView;
        if (this.isTracking.getAndSet(false) && (rootView = getRootView()) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                if (Build.VERSION.SDK_INT < 16) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                } else {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
        }
    }

    public final void onGlobalLayout() {
        process();
    }

    private void process() {
        AnonymousClass1 r0 = new Runnable() {
            /* class com.facebook.appevents.suggestedevents.ViewObserver.AnonymousClass1 */

            public void run() {
                try {
                    View rootView = ViewObserver.this.getRootView();
                    Activity activity = ViewObserver.this.activityWeakReference.get();
                    if (rootView == null) {
                        return;
                    }
                    if (activity != null) {
                        for (View next : SuggestedEventViewHierarchy.getAllClickableViews(rootView)) {
                            if (!SensitiveUserDataUtils.isSensitiveUserData(next)) {
                                String textOfView = ViewHierarchy.getTextOfView(next);
                                if (!textOfView.isEmpty() && textOfView.length() <= 300) {
                                    ViewOnClickListener.attachListener(next, rootView, activity.getLocalClassName());
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r0.run();
        } else {
            this.uiThreadHandler.post(r0);
        }
    }

    public final View getRootView() {
        Window window;
        Activity activity = this.activityWeakReference.get();
        if (activity == null || (window = activity.getWindow()) == null) {
            return null;
        }
        return window.getDecorView().getRootView();
    }
}
