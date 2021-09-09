package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.CreateMountItem;
import com.facebook.react.fabric.mounting.mountitems.DeleteMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchStringCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.InsertMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateEventEmitterMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLayoutMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLocalDataMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePropsMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateStateMountItem;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.google.android.exoplayer2.C;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"MissingNativeLoadLibrary"})
public class FabricUIManager implements LifecycleEventListener, UIManager {
    public static final boolean DEBUG = (ReactFeatureFlags.enableFabricLogs || PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.FABRIC_UI_MANAGER));
    public static final String TAG = "FabricUIManager";
    private long mBatchedExecutionTime = 0;
    private Binding mBinding;
    private long mCommitStartTime = 0;
    private int mCurrentSynchronousCommitNumber = C.MSG_CUSTOM_BASE;
    @ThreadConfined("UI")
    public final DispatchUIFrameCallback mDispatchUIFrameCallback;
    private long mDispatchViewUpdatesTime = 0;
    private final EventBeatManager mEventBeatManager;
    private final EventDispatcher mEventDispatcher;
    private long mFinishTransactionCPPTime = 0;
    private long mFinishTransactionTime = 0;
    @ThreadConfined("UI")
    public boolean mIsMountingEnabled = true;
    private long mLayoutTime = 0;
    private List<MountItem> mMountItems = new ArrayList();
    private final Object mMountItemsLock = new Object();
    private final MountingManager mMountingManager;
    private ArrayDeque<MountItem> mPreMountItems = new ArrayDeque<>(250);
    private final Object mPreMountItemsLock = new Object();
    private final ReactApplicationContext mReactApplicationContext;
    private final ConcurrentHashMap<Integer, ThemedReactContext> mReactContextForRootTag = new ConcurrentHashMap<>();
    private long mRunStartTime = 0;

    public void onHostDestroy() {
    }

    public void profileNextBatch() {
    }

    static {
        FabricSoLoader.staticInit();
    }

    public FabricUIManager(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, EventBeatManager eventBeatManager) {
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mMountingManager = new MountingManager(viewManagerRegistry);
        this.mEventDispatcher = eventDispatcher;
        this.mEventBeatManager = eventBeatManager;
        this.mReactApplicationContext.addLifecycleEventListener(this);
    }

    public <T extends View> int addRootView(T t, WritableMap writableMap, String str) {
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, t.getContext());
        this.mMountingManager.addRootView(nextRootViewTag, t);
        this.mReactContextForRootTag.put(Integer.valueOf(nextRootViewTag), themedReactContext);
        String jSModuleName = ((ReactRoot) t).getJSModuleName();
        if (DEBUG) {
            FLog.d(TAG, "Starting surface for module: %s and reactTag: %d", jSModuleName, Integer.valueOf(nextRootViewTag));
        }
        this.mBinding.startSurface(nextRootViewTag, jSModuleName, (NativeMap) writableMap);
        if (str != null) {
            this.mBinding.renderTemplateToSurface(nextRootViewTag, str);
        }
        return nextRootViewTag;
    }

    public <T extends View> int startSurface(T t, String str, WritableMap writableMap, int i, int i2) {
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, t.getContext());
        if (DEBUG) {
            FLog.d(TAG, "Starting surface for module: %s and reactTag: %d", str, Integer.valueOf(nextRootViewTag));
        }
        this.mMountingManager.addRootView(nextRootViewTag, t);
        this.mReactContextForRootTag.put(Integer.valueOf(nextRootViewTag), themedReactContext);
        this.mBinding.startSurfaceWithConstraints(nextRootViewTag, str, (NativeMap) writableMap, LayoutMetricsConversions.getMinSize(i), LayoutMetricsConversions.getMaxSize(i), LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2));
        return nextRootViewTag;
    }

    @DoNotStrip
    public void onRequestEventBeat() {
        this.mEventDispatcher.dispatchAllEvents();
    }

    public void stopSurface(int i) {
        this.mBinding.stopSurface(i);
    }

    public void initialize() {
        this.mEventDispatcher.registerEventEmitter(2, new FabricEventEmitter(this));
        this.mEventDispatcher.addBatchEventDispatchedListener(this.mEventBeatManager);
    }

    public void onCatalystInstanceDestroy() {
        if (DEBUG) {
            FLog.d(TAG, "Destroying Catalyst Instance");
        }
        this.mEventDispatcher.removeBatchEventDispatchedListener(this.mEventBeatManager);
        this.mEventDispatcher.unregisterEventEmitter(2);
        this.mBinding.unregister();
        ViewManagerPropertyUpdater.clear();
    }

    @DoNotStrip
    private void preallocateView(int i, int i2, String str, ReadableMap readableMap, Object obj, boolean z) {
        ThemedReactContext themedReactContext = this.mReactContextForRootTag.get(Integer.valueOf(i));
        String fabricComponentName = FabricComponents.getFabricComponentName(str);
        synchronized (this.mPreMountItemsLock) {
            this.mPreMountItems.add(new PreAllocateViewMountItem(themedReactContext, i, i2, fabricComponentName, readableMap, (StateWrapper) obj, z));
        }
    }

    @DoNotStrip
    private MountItem createMountItem(String str, ReadableMap readableMap, Object obj, int i, int i2, boolean z) {
        String fabricComponentName = FabricComponents.getFabricComponentName(str);
        ThemedReactContext themedReactContext = this.mReactContextForRootTag.get(Integer.valueOf(i));
        if (themedReactContext != null) {
            return new CreateMountItem(themedReactContext, i, i2, fabricComponentName, readableMap, (StateWrapper) obj, z);
        }
        throw new IllegalArgumentException("Unable to find ReactContext for root: ".concat(String.valueOf(i)));
    }

    @DoNotStrip
    private MountItem removeMountItem(int i, int i2, int i3) {
        return new RemoveMountItem(i, i2, i3);
    }

    @DoNotStrip
    private MountItem insertMountItem(int i, int i2, int i3) {
        return new InsertMountItem(i, i2, i3);
    }

    @DoNotStrip
    private MountItem deleteMountItem(int i) {
        return new DeleteMountItem(i);
    }

    @DoNotStrip
    private MountItem updateLayoutMountItem(int i, int i2, int i3, int i4, int i5, int i6) {
        return new UpdateLayoutMountItem(i, i2, i3, i4, i5, i6);
    }

    @DoNotStrip
    private MountItem updatePropsMountItem(int i, ReadableMap readableMap) {
        return new UpdatePropsMountItem(i, readableMap);
    }

    @DoNotStrip
    private MountItem updateLocalDataMountItem(int i, ReadableMap readableMap) {
        return new UpdateLocalDataMountItem(i, readableMap);
    }

    @DoNotStrip
    private MountItem updateStateMountItem(int i, Object obj) {
        return new UpdateStateMountItem(i, (StateWrapper) obj);
    }

    @DoNotStrip
    private MountItem updateEventEmitterMountItem(int i, Object obj) {
        return new UpdateEventEmitterMountItem(i, (EventEmitterWrapper) obj);
    }

    @DoNotStrip
    private MountItem createBatchMountItem(MountItem[] mountItemArr, int i, int i2) {
        return new BatchMountItem(mountItemArr, i, i2);
    }

    @DoNotStrip
    private long measure(String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, float f2, float f3, float f4) {
        return this.mMountingManager.measure(this.mReactApplicationContext, str, readableMap, readableMap2, readableMap3, LayoutMetricsConversions.getYogaSize(f, f2), LayoutMetricsConversions.getYogaMeasureMode(f, f2), LayoutMetricsConversions.getYogaSize(f3, f4), LayoutMetricsConversions.getYogaMeasureMode(f3, f4));
    }

    public void synchronouslyUpdateViewOnUIThread(int i, ReadableMap readableMap) {
        String str;
        int i2;
        ReactMarkerConstants reactMarkerConstants;
        String str2;
        int i3;
        long uptimeMillis = SystemClock.uptimeMillis();
        int i4 = this.mCurrentSynchronousCommitNumber;
        this.mCurrentSynchronousCommitNumber = i4 + 1;
        try {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START, null, i4);
            int i5 = i4;
            try {
                scheduleMountItem(updatePropsMountItem(i, readableMap), i4, uptimeMillis, 0, 0, 0, 0, 0, 0);
                reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
                i2 = i5;
                str = null;
            } catch (Exception unused) {
                i2 = i5;
                str = null;
                reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
                ReactMarker.logFabricMarker(reactMarkerConstants, str, i2);
            } catch (Throwable th) {
                th = th;
                i3 = i5;
                str2 = null;
                ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i3);
                throw th;
            }
        } catch (Exception unused2) {
            str = null;
            i2 = i4;
            reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
            ReactMarker.logFabricMarker(reactMarkerConstants, str, i2);
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
            i3 = i4;
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i3);
            throw th;
        }
        ReactMarker.logFabricMarker(reactMarkerConstants, str, i2);
    }

    @DoNotStrip
    private void scheduleMountItem(MountItem mountItem, int i, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        int i2 = i;
        long j8 = j4;
        long j9 = j5;
        long j10 = j6;
        long j11 = j7;
        boolean z = mountItem instanceof BatchMountItem;
        if (z) {
            this.mCommitStartTime = j;
            this.mLayoutTime = j9 - j8;
            this.mFinishTransactionCPPTime = j11 - j10;
            this.mFinishTransactionTime = SystemClock.uptimeMillis() - j10;
            this.mDispatchViewUpdatesTime = SystemClock.uptimeMillis();
        }
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(mountItem);
        }
        if (z) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_START, null, i2, this.mCommitStartTime);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START, null, i2, j10);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END, null, i2, j11);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_START, null, i2, j2);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_END, null, i2, j3);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_START, null, i2, j8);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_END, null, i2, j9);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_END, null, i2);
        }
        if (UiThreadUtil.isOnUiThread()) {
            dispatchMountItems();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r9.mPreMountItems.isEmpty() != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r0 = r9.mPreMountItems;
        r9.mPreMountItems = new java.util.ArrayDeque<>(250);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r0 == null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        com.facebook.systrace.Systrace.beginSection(0, "FabricUIManager::mountViews preMountItems to execute: " + r0.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r0.isEmpty() != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        r0.pollFirst().execute(r9.mMountingManager);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        com.facebook.systrace.Systrace.endSection(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0063, code lost:
        com.facebook.systrace.Systrace.beginSection(0, "FabricUIManager::mountViews mountItems to execute: " + r1.size());
        r4 = android.os.SystemClock.uptimeMillis();
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        if (r0.hasNext() == false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0086, code lost:
        r1 = r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008e, code lost:
        if (com.facebook.react.fabric.FabricUIManager.DEBUG == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0090, code lost:
        com.facebook.common.logging.FLog.d(com.facebook.react.fabric.FabricUIManager.TAG, "dispatchMountItems: Executing mountItem: ".concat(java.lang.String.valueOf(r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009f, code lost:
        r1.execute(r9.mMountingManager);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a5, code lost:
        r9.mBatchedExecutionTime = android.os.SystemClock.uptimeMillis() - r4;
        com.facebook.systrace.Systrace.endSection(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00af, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r0 = null;
        r2 = r9.mPreMountItemsLock;
     */
    public void dispatchMountItems() {
        this.mRunStartTime = SystemClock.uptimeMillis();
        synchronized (this.mMountItemsLock) {
            if (!this.mMountItems.isEmpty()) {
                List<MountItem> list = this.mMountItems;
                this.mMountItems = new ArrayList();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        com.facebook.systrace.Systrace.endSection(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        return;
     */
    public void dispatchPreMountItems(long j) {
        MountItem pollFirst;
        Systrace.beginSection(0, "FabricUIManager::premountViews");
        while (true) {
            if (16 - ((System.nanoTime() - j) / 1000000) < 8) {
                break;
            }
            synchronized (this.mPreMountItemsLock) {
                if (!this.mPreMountItems.isEmpty()) {
                    pollFirst = this.mPreMountItems.pollFirst();
                }
            }
            pollFirst.execute(this.mMountingManager);
        }
        while (true) {
        }
    }

    public void setBinding(Binding binding) {
        this.mBinding = binding;
    }

    public void updateRootLayoutSpecs(int i, int i2, int i3) {
        if (DEBUG) {
            FLog.d(TAG, "Updating Root Layout Specs");
        }
        this.mBinding.setConstraints(i, LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2), LayoutMetricsConversions.getMinSize(i3), LayoutMetricsConversions.getMaxSize(i3));
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        EventEmitterWrapper eventEmitter = this.mMountingManager.getEventEmitter(i);
        if (eventEmitter == null) {
            String str2 = TAG;
            FLog.d(str2, "Unable to invoke event: " + str + " for reactTag: " + i);
            return;
        }
        eventEmitter.invoke(str, writableMap);
    }

    public void onHostResume() {
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public void onHostPause() {
        ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    @Deprecated
    public void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new DispatchCommandMountItem(i, i2, readableArray));
        }
    }

    public void dispatchCommand(int i, String str, ReadableArray readableArray) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new DispatchStringCommandMountItem(i, str, readableArray));
        }
    }

    @DoNotStrip
    public void setJSResponder(final int i, final int i2, final boolean z) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new MountItem() {
                /* class com.facebook.react.fabric.FabricUIManager.AnonymousClass1 */

                public void execute(MountingManager mountingManager) {
                    mountingManager.setJSResponder(i, i2, z);
                }
            });
        }
    }

    @DoNotStrip
    public void clearJSResponder() {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new MountItem() {
                /* class com.facebook.react.fabric.FabricUIManager.AnonymousClass2 */

                public void execute(MountingManager mountingManager) {
                    mountingManager.clearJSResponder();
                }
            });
        }
    }

    public Map<String, Long> getPerformanceCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mCommitStartTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mRunStartTime));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mBatchedExecutionTime));
        hashMap.put("FinishFabricTransactionTime", Long.valueOf(this.mFinishTransactionTime));
        hashMap.put("FinishFabricTransactionCPPTime", Long.valueOf(this.mFinishTransactionCPPTime));
        return hashMap;
    }

    class DispatchUIFrameCallback extends GuardedFrameCallback {
        private DispatchUIFrameCallback(ReactContext reactContext) {
            super(reactContext);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.facebook.common.logging.FLog.i(java.lang.String, java.lang.String, java.lang.Throwable):void
         arg types: [java.lang.String, java.lang.String, java.lang.Exception]
         candidates:
          com.facebook.common.logging.FLog.i(java.lang.Class<?>, java.lang.String, java.lang.Object):void
          com.facebook.common.logging.FLog.i(java.lang.Class<?>, java.lang.String, java.lang.Throwable):void
          com.facebook.common.logging.FLog.i(java.lang.Class<?>, java.lang.String, java.lang.Object[]):void
          com.facebook.common.logging.FLog.i(java.lang.String, java.lang.String, java.lang.Object):void
          com.facebook.common.logging.FLog.i(java.lang.String, java.lang.String, java.lang.Object[]):void
          com.facebook.common.logging.FLog.i(java.lang.String, java.lang.String, java.lang.Throwable):void */
        public void doFrameGuarded(long j) {
            if (!FabricUIManager.this.mIsMountingEnabled) {
                FLog.w("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            try {
                FabricUIManager.this.dispatchPreMountItems(j);
                FabricUIManager.this.dispatchMountItems();
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
            } catch (Exception e) {
                FLog.i("ReactNative", "Exception thrown when executing UIFrameGuarded", (Throwable) e);
                FabricUIManager.this.mIsMountingEnabled = false;
                throw e;
            } catch (Throwable th) {
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
                throw th;
            }
        }
    }
}
