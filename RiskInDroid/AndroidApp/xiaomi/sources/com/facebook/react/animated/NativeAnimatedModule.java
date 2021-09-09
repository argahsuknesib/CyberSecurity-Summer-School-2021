package com.facebook.react.animated;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModuleListener;
import java.util.ArrayList;
import java.util.Iterator;

@ReactModule(name = "NativeAnimatedModule")
public class NativeAnimatedModule extends ReactContextBaseJavaModule implements LifecycleEventListener, UIManagerModuleListener {
    public final GuardedFrameCallback mAnimatedFrameCallback;
    private NativeAnimatedNodesManager mNodesManager;
    private ArrayList<UIThreadOperation> mOperations = new ArrayList<>();
    private ArrayList<UIThreadOperation> mPreOperations = new ArrayList<>();
    public final ReactChoreographer mReactChoreographer = ReactChoreographer.getInstance();

    interface UIThreadOperation {
        void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager);
    }

    public String getName() {
        return "NativeAnimatedModule";
    }

    public void onHostDestroy() {
    }

    public NativeAnimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mAnimatedFrameCallback = new GuardedFrameCallback(reactApplicationContext) {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass1 */

            public void doFrameGuarded(long j) {
                NativeAnimatedNodesManager nodesManager = NativeAnimatedModule.this.getNodesManager();
                if (nodesManager.hasActiveAnimations()) {
                    nodesManager.runUpdates(j);
                }
                ((ReactChoreographer) Assertions.assertNotNull(NativeAnimatedModule.this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, NativeAnimatedModule.this.mAnimatedFrameCallback);
            }
        };
    }

    public void initialize() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.addLifecycleEventListener(this);
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIManagerListener(this);
    }

    public void onHostResume() {
        enqueueFrameCallback();
    }

    public void willDispatchViewUpdates(UIManagerModule uIManagerModule) {
        if (!this.mOperations.isEmpty() || !this.mPreOperations.isEmpty()) {
            final ArrayList<UIThreadOperation> arrayList = this.mPreOperations;
            final ArrayList<UIThreadOperation> arrayList2 = this.mOperations;
            this.mPreOperations = new ArrayList<>();
            this.mOperations = new ArrayList<>();
            uIManagerModule.prependUIBlock(new UIBlock() {
                /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass2 */

                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NativeAnimatedNodesManager nodesManager = NativeAnimatedModule.this.getNodesManager();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((UIThreadOperation) it.next()).execute(nodesManager);
                    }
                }
            });
            uIManagerModule.addUIBlock(new UIBlock() {
                /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass3 */

                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NativeAnimatedNodesManager nodesManager = NativeAnimatedModule.this.getNodesManager();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((UIThreadOperation) it.next()).execute(nodesManager);
                    }
                }
            });
        }
    }

    public void onHostPause() {
        clearFrameCallback();
    }

    public NativeAnimatedNodesManager getNodesManager() {
        if (this.mNodesManager == null) {
            this.mNodesManager = new NativeAnimatedNodesManager((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class));
        }
        return this.mNodesManager;
    }

    private void clearFrameCallback() {
        ((ReactChoreographer) Assertions.assertNotNull(this.mReactChoreographer)).removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    private void enqueueFrameCallback() {
        ((ReactChoreographer) Assertions.assertNotNull(this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    @VisibleForTesting
    public void setNodesManager(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNodesManager = nativeAnimatedNodesManager;
    }

    @ReactMethod
    public void createAnimatedNode(final int i, final ReadableMap readableMap) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass4 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.createAnimatedNode(i, readableMap);
            }
        });
    }

    @ReactMethod
    public void startListeningToAnimatedNodeValue(final int i) {
        final AnonymousClass5 r0 = new AnimatedNodeValueListener() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass5 */

            public void onValueUpdate(double d) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("tag", i);
                createMap.putDouble("value", d);
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) NativeAnimatedModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAnimatedValueUpdate", createMap);
            }
        };
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass6 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.startListeningToAnimatedNodeValue(i, r0);
            }
        });
    }

    @ReactMethod
    public void stopListeningToAnimatedNodeValue(final int i) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass7 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.stopListeningToAnimatedNodeValue(i);
            }
        });
    }

    @ReactMethod
    public void dropAnimatedNode(final int i) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass8 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.dropAnimatedNode(i);
            }
        });
    }

    @ReactMethod
    public void setAnimatedNodeValue(final int i, final double d) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass9 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.setAnimatedNodeValue(i, d);
            }
        });
    }

    @ReactMethod
    public void setAnimatedNodeOffset(final int i, final double d) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass10 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.setAnimatedNodeOffset(i, d);
            }
        });
    }

    @ReactMethod
    public void flattenAnimatedNodeOffset(final int i) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass11 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.flattenAnimatedNodeOffset(i);
            }
        });
    }

    @ReactMethod
    public void extractAnimatedNodeOffset(final int i) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass12 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.extractAnimatedNodeOffset(i);
            }
        });
    }

    @ReactMethod
    public void startAnimatingNode(int i, int i2, ReadableMap readableMap, Callback callback) {
        final int i3 = i;
        final int i4 = i2;
        final ReadableMap readableMap2 = readableMap;
        final Callback callback2 = callback;
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass13 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.startAnimatingNode(i3, i4, readableMap2, callback2);
            }
        });
    }

    @ReactMethod
    public void stopAnimation(final int i) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass14 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.stopAnimation(i);
            }
        });
    }

    @ReactMethod
    public void connectAnimatedNodes(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass15 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.connectAnimatedNodes(i, i2);
            }
        });
    }

    @ReactMethod
    public void disconnectAnimatedNodes(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass16 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.disconnectAnimatedNodes(i, i2);
            }
        });
    }

    @ReactMethod
    public void connectAnimatedNodeToView(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass17 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.connectAnimatedNodeToView(i, i2);
            }
        });
    }

    @ReactMethod
    public void disconnectAnimatedNodeFromView(final int i, final int i2) {
        this.mPreOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass18 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.restoreDefaultValues(i, i2);
            }
        });
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass19 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.disconnectAnimatedNodeFromView(i, i2);
            }
        });
    }

    @ReactMethod
    public void addAnimatedEventToView(final int i, final String str, final ReadableMap readableMap) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass20 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.addAnimatedEventToView(i, str, readableMap);
            }
        });
    }

    @ReactMethod
    public void removeAnimatedEventFromView(final int i, final String str, final int i2) {
        this.mOperations.add(new UIThreadOperation() {
            /* class com.facebook.react.animated.NativeAnimatedModule.AnonymousClass21 */

            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.removeAnimatedEventFromView(i, str, i2);
            }
        });
    }
}
