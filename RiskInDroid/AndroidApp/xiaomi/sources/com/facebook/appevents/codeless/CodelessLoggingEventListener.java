package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import java.lang.ref.WeakReference;

public class CodelessLoggingEventListener {
    private static final String TAG = "com.facebook.appevents.codeless.CodelessLoggingEventListener";

    public static AutoLoggingOnClickListener getOnClickListener(EventBinding eventBinding, View view, View view2) {
        return new AutoLoggingOnClickListener(eventBinding, view, view2);
    }

    public static AutoLoggingOnItemClickListener getOnItemClickListener(EventBinding eventBinding, View view, AdapterView adapterView) {
        return new AutoLoggingOnItemClickListener(eventBinding, view, adapterView);
    }

    public static void logEvent(EventBinding eventBinding, View view, View view2) {
        final String eventName = eventBinding.getEventName();
        final Bundle parameters = CodelessMatcher.getParameters(eventBinding, view, view2);
        if (parameters.containsKey("_valueToSum")) {
            parameters.putDouble("_valueToSum", AppEventUtility.normalizePrice(parameters.getString("_valueToSum")));
        }
        parameters.putString("_is_fb_codeless", "1");
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.codeless.CodelessLoggingEventListener.AnonymousClass1 */

            public final void run() {
                AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
            }
        });
    }

    public static class AutoLoggingOnClickListener implements View.OnClickListener {
        private View.OnClickListener existingOnClickListener;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        private AutoLoggingOnClickListener(EventBinding eventBinding, View view, View view2) {
            this.supportCodelessLogging = false;
            if (eventBinding != null && view != null && view2 != null) {
                this.existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
                this.mapping = eventBinding;
                this.hostView = new WeakReference<>(view2);
                this.rootView = new WeakReference<>(view);
                this.supportCodelessLogging = true;
            }
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.existingOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (this.rootView.get() != null && this.hostView.get() != null) {
                CodelessLoggingEventListener.logEvent(this.mapping, this.rootView.get(), this.hostView.get());
            }
        }

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }
    }

    public static class AutoLoggingOnItemClickListener implements AdapterView.OnItemClickListener {
        private AdapterView.OnItemClickListener existingOnItemClickListener;
        private WeakReference<AdapterView> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        private AutoLoggingOnItemClickListener(EventBinding eventBinding, View view, AdapterView adapterView) {
            this.supportCodelessLogging = false;
            if (eventBinding != null && view != null && adapterView != null) {
                this.existingOnItemClickListener = adapterView.getOnItemClickListener();
                this.mapping = eventBinding;
                this.hostView = new WeakReference<>(adapterView);
                this.rootView = new WeakReference<>(view);
                this.supportCodelessLogging = true;
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AdapterView.OnItemClickListener onItemClickListener = this.existingOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
            if (this.rootView.get() != null && this.hostView.get() != null) {
                CodelessLoggingEventListener.logEvent(this.mapping, this.rootView.get(), this.hostView.get());
            }
        }

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }
    }
}
