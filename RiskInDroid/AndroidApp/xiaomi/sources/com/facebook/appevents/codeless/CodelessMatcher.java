package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

class CodelessMatcher {
    public static final String TAG = "com.facebook.appevents.codeless.CodelessMatcher";
    private static CodelessMatcher codelessMatcher;
    private Set<Activity> activitiesSet = Collections.newSetFromMap(new WeakHashMap());
    private HashMap<Integer, HashSet<String>> activityToListenerMap = new HashMap<>();
    private HashSet<String> listenerSet = new HashSet<>();
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private Set<ViewMatcher> viewMatchers = new HashSet();

    private CodelessMatcher() {
    }

    public static synchronized CodelessMatcher getInstance() {
        CodelessMatcher codelessMatcher2;
        synchronized (CodelessMatcher.class) {
            if (codelessMatcher == null) {
                codelessMatcher = new CodelessMatcher();
            }
            codelessMatcher2 = codelessMatcher;
        }
        return codelessMatcher2;
    }

    public void add(Activity activity) {
        if (!InternalSettings.isUnityApp()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.activitiesSet.add(activity);
                this.listenerSet.clear();
                if (this.activityToListenerMap.containsKey(Integer.valueOf(activity.hashCode()))) {
                    this.listenerSet = this.activityToListenerMap.get(Integer.valueOf(activity.hashCode()));
                }
                startTracking();
                return;
            }
            throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
        }
    }

    public void remove(Activity activity) {
        if (!InternalSettings.isUnityApp()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.activitiesSet.remove(activity);
                this.viewMatchers.clear();
                this.activityToListenerMap.put(Integer.valueOf(activity.hashCode()), (HashSet) this.listenerSet.clone());
                this.listenerSet.clear();
                return;
            }
            throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
        }
    }

    public void destroy(Activity activity) {
        this.activityToListenerMap.remove(Integer.valueOf(activity.hashCode()));
    }

    public static Bundle getParameters(EventBinding eventBinding, View view, View view2) {
        List<ParameterComponent> viewParameters;
        List<MatchedView> list;
        Bundle bundle = new Bundle();
        if (!(eventBinding == null || (viewParameters = eventBinding.getViewParameters()) == null)) {
            for (ParameterComponent next : viewParameters) {
                if (next.value == null || next.value.length() <= 0) {
                    if (next.path.size() > 0) {
                        if (next.pathType.equals("relative")) {
                            list = ViewMatcher.findViewByPath(eventBinding, view2, next.path, 0, -1, view2.getClass().getSimpleName());
                        } else {
                            list = ViewMatcher.findViewByPath(eventBinding, view, next.path, 0, -1, view.getClass().getSimpleName());
                        }
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            MatchedView matchedView = (MatchedView) it.next();
                            if (matchedView.getView() != null) {
                                String textOfView = ViewHierarchy.getTextOfView(matchedView.getView());
                                if (textOfView.length() > 0) {
                                    bundle.putString(next.name, textOfView);
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    bundle.putString(next.name, next.value);
                }
            }
        }
        return bundle;
    }

    private void startTracking() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            matchViews();
        } else {
            this.uiThreadHandler.post(new Runnable() {
                /* class com.facebook.appevents.codeless.CodelessMatcher.AnonymousClass1 */

                public void run() {
                    CodelessMatcher.this.matchViews();
                }
            });
        }
    }

    public void matchViews() {
        for (Activity next : this.activitiesSet) {
            if (next != null) {
                this.viewMatchers.add(new ViewMatcher(next.getWindow().getDecorView().getRootView(), this.uiThreadHandler, this.listenerSet, next.getClass().getSimpleName()));
            }
        }
    }

    public static class MatchedView {
        private WeakReference<View> view;
        private String viewMapKey;

        public MatchedView(View view2, String str) {
            this.view = new WeakReference<>(view2);
            this.viewMapKey = str;
        }

        public View getView() {
            WeakReference<View> weakReference = this.view;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public String getViewMapKey() {
            return this.viewMapKey;
        }
    }

    public static class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        private final String activityName;
        private List<EventBinding> eventBindings;
        private final Handler handler;
        private HashSet<String> listenerSet;
        private WeakReference<View> rootView;

        public ViewMatcher(View view, Handler handler2, HashSet<String> hashSet, String str) {
            this.rootView = new WeakReference<>(view);
            this.handler = handler2;
            this.listenerSet = hashSet;
            this.activityName = str;
            this.handler.postDelayed(this, 200);
        }

        public void run() {
            View view;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                this.eventBindings = EventBinding.parseArray(appSettingsWithoutQuery.getEventBindings());
                if (this.eventBindings != null && (view = this.rootView.get()) != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalLayoutListener(this);
                        viewTreeObserver.addOnScrollChangedListener(this);
                    }
                    startMatch();
                }
            }
        }

        public void onGlobalLayout() {
            startMatch();
        }

        public void onScrollChanged() {
            startMatch();
        }

        private void startMatch() {
            if (this.eventBindings != null && this.rootView.get() != null) {
                for (int i = 0; i < this.eventBindings.size(); i++) {
                    findView(this.eventBindings.get(i), this.rootView.get());
                }
            }
        }

        public void findView(EventBinding eventBinding, View view) {
            if (eventBinding != null && view != null) {
                if (TextUtils.isEmpty(eventBinding.getActivityName()) || eventBinding.getActivityName().equals(this.activityName)) {
                    List<PathComponent> viewPath = eventBinding.getViewPath();
                    if (viewPath.size() <= 25) {
                        for (MatchedView attachListener : findViewByPath(eventBinding, view, viewPath, 0, -1, this.activityName)) {
                            attachListener(attachListener, view, eventBinding);
                        }
                    }
                }
            }
        }

        public static List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> list, int i, int i2, String str) {
            String str2 = str + "." + String.valueOf(i2);
            ArrayList arrayList = new ArrayList();
            if (view == null) {
                return arrayList;
            }
            if (i >= list.size()) {
                arrayList.add(new MatchedView(view, str2));
            } else {
                PathComponent pathComponent = list.get(i);
                if (pathComponent.className.equals("..")) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        List<View> findVisibleChildren = findVisibleChildren((ViewGroup) parent);
                        int size = findVisibleChildren.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList.addAll(findViewByPath(eventBinding, findVisibleChildren.get(i3), list, i + 1, i3, str2));
                        }
                    }
                    return arrayList;
                } else if (pathComponent.className.equals(".")) {
                    arrayList.add(new MatchedView(view, str2));
                    return arrayList;
                } else if (!isTheSameView(view, pathComponent, i2)) {
                    return arrayList;
                } else {
                    if (i == list.size() - 1) {
                        arrayList.add(new MatchedView(view, str2));
                    }
                }
            }
            if (view instanceof ViewGroup) {
                List<View> findVisibleChildren2 = findVisibleChildren((ViewGroup) view);
                int size2 = findVisibleChildren2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    arrayList.addAll(findViewByPath(eventBinding, findVisibleChildren2.get(i4), list, i + 1, i4, str2));
                }
            }
            return arrayList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
            if (r5.getClass().getSimpleName().equals(r7[r7.length - 1]) == false) goto L_0x0043;
         */
        private static boolean isTheSameView(View view, PathComponent pathComponent, int i) {
            String str;
            String str2;
            if (pathComponent.index != -1 && i != pathComponent.index) {
                return false;
            }
            if (!view.getClass().getCanonicalName().equals(pathComponent.className)) {
                if (pathComponent.className.matches(".*android\\..*")) {
                    String[] split = pathComponent.className.split("\\.");
                    if (split.length > 0) {
                    }
                }
                return false;
            }
            if ((pathComponent.matchBitmask & PathComponent.MatchBitmaskType.ID.getValue()) > 0 && pathComponent.id != view.getId()) {
                return false;
            }
            if ((pathComponent.matchBitmask & PathComponent.MatchBitmaskType.TEXT.getValue()) > 0) {
                String str3 = pathComponent.text;
                String textOfView = ViewHierarchy.getTextOfView(view);
                String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), "");
                if (!str3.equals(textOfView) && !str3.equals(coerceValueIfNullOrEmpty)) {
                    return false;
                }
            }
            if ((pathComponent.matchBitmask & PathComponent.MatchBitmaskType.DESCRIPTION.getValue()) > 0) {
                String str4 = pathComponent.description;
                if (view.getContentDescription() == null) {
                    str2 = "";
                } else {
                    str2 = String.valueOf(view.getContentDescription());
                }
                String coerceValueIfNullOrEmpty2 = Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(str2), "");
                if (!str4.equals(str2) && !str4.equals(coerceValueIfNullOrEmpty2)) {
                    return false;
                }
            }
            if ((pathComponent.matchBitmask & PathComponent.MatchBitmaskType.HINT.getValue()) > 0) {
                String str5 = pathComponent.hint;
                String hintOfView = ViewHierarchy.getHintOfView(view);
                String coerceValueIfNullOrEmpty3 = Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), "");
                if (!str5.equals(hintOfView) && !str5.equals(coerceValueIfNullOrEmpty3)) {
                    return false;
                }
            }
            if ((pathComponent.matchBitmask & PathComponent.MatchBitmaskType.TAG.getValue()) > 0) {
                String str6 = pathComponent.tag;
                if (view.getTag() == null) {
                    str = "";
                } else {
                    str = String.valueOf(view.getTag());
                }
                String coerceValueIfNullOrEmpty4 = Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(str), "");
                if (str6.equals(str) || str6.equals(coerceValueIfNullOrEmpty4)) {
                    return true;
                }
                return false;
            }
            return true;
        }

        private static List<View> findVisibleChildren(ViewGroup viewGroup) {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
            }
            return arrayList;
        }

        private void attachListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            if (eventBinding != null) {
                try {
                    View view2 = matchedView.getView();
                    if (view2 != null) {
                        View findRCTRootView = ViewHierarchy.findRCTRootView(view2);
                        if (findRCTRootView != null && ViewHierarchy.isRCTButton(view2, findRCTRootView)) {
                            attachRCTListener(matchedView, view, eventBinding);
                        } else if (!view2.getClass().getName().startsWith("com.facebook.react")) {
                            if (!(view2 instanceof AdapterView)) {
                                attachOnClickListener(matchedView, view, eventBinding);
                            } else if (view2 instanceof ListView) {
                                attachOnItemClickListener(matchedView, view, eventBinding);
                            }
                        }
                    }
                } catch (Exception e) {
                    Utility.logd(CodelessMatcher.TAG, e);
                }
            }
        }

        private void attachOnClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            View view2 = matchedView.getView();
            if (view2 != null) {
                String viewMapKey = matchedView.getViewMapKey();
                View.OnClickListener existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
                boolean z = (existingOnClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnClickListener) && ((CodelessLoggingEventListener.AutoLoggingOnClickListener) existingOnClickListener).getSupportCodelessLogging();
                if (!this.listenerSet.contains(viewMapKey) && !z) {
                    view2.setOnClickListener(CodelessLoggingEventListener.getOnClickListener(eventBinding, view, view2));
                    this.listenerSet.add(viewMapKey);
                }
            }
        }

        private void attachOnItemClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            AdapterView adapterView = (AdapterView) matchedView.getView();
            if (adapterView != null) {
                String viewMapKey = matchedView.getViewMapKey();
                AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
                boolean z = (onItemClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnItemClickListener) && ((CodelessLoggingEventListener.AutoLoggingOnItemClickListener) onItemClickListener).getSupportCodelessLogging();
                if (!this.listenerSet.contains(viewMapKey) && !z) {
                    adapterView.setOnItemClickListener(CodelessLoggingEventListener.getOnItemClickListener(eventBinding, view, adapterView));
                    this.listenerSet.add(viewMapKey);
                }
            }
        }

        private void attachRCTListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            View view2 = matchedView.getView();
            if (view2 != null) {
                String viewMapKey = matchedView.getViewMapKey();
                View.OnTouchListener existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
                boolean z = (existingOnTouchListener instanceof RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) && ((RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) existingOnTouchListener).getSupportCodelessLogging();
                if (!this.listenerSet.contains(viewMapKey) && !z) {
                    view2.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(eventBinding, view, view2));
                    this.listenerSet.add(viewMapKey);
                }
            }
        }
    }
}
