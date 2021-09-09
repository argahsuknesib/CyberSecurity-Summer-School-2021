package com.swmansion.reanimated;

import _m_j.dev;
import _m_j.dey;
import _m_j.dez;
import _m_j.dfa;
import _m_j.dfb;
import _m_j.dfc;
import _m_j.dfd;
import _m_j.dfe;
import _m_j.dff;
import _m_j.dfg;
import _m_j.dfi;
import _m_j.dfj;
import _m_j.dfk;
import _m_j.dfm;
import _m_j.dfn;
import _m_j.dfo;
import _m_j.dfp;
import _m_j.dfq;
import _m_j.dfr;
import _m_j.dfs;
import _m_j.dfv;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModuleListener;
import com.swmansion.reanimated.nodes.EventNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@ReactModule(name = "ReanimatedModule")
public class ReanimatedModule extends ReactContextBaseJavaModule implements LifecycleEventListener, UIManagerModuleListener {
    private dev mNodesManager;
    private ArrayList<O000000o> mOperations = new ArrayList<>();
    private dfv mTransitionManager;

    interface O000000o {
        void O000000o(dev dev);
    }

    public String getName() {
        return "ReanimatedModule";
    }

    public void onHostDestroy() {
    }

    public ReanimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void initialize() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        UIManagerModule uIManagerModule = (UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class);
        reactApplicationContext.addLifecycleEventListener(this);
        uIManagerModule.addUIManagerListener(this);
        this.mTransitionManager = new dfv(uIManagerModule);
    }

    public void onHostPause() {
        dev dev = this.mNodesManager;
        if (dev != null && dev.O00000oo.get()) {
            if (dev.O00000oo.getAndSet(false)) {
                dev.O00000o.removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, dev.O00000oO);
            }
            dev.O00000oo.set(true);
        }
    }

    public void onHostResume() {
        dev dev = this.mNodesManager;
        if (dev != null && dev.O00000oo.getAndSet(false)) {
            dev.O000000o();
        }
    }

    public void willDispatchViewUpdates(UIManagerModule uIManagerModule) {
        if (!this.mOperations.isEmpty()) {
            final ArrayList<O000000o> arrayList = this.mOperations;
            this.mOperations = new ArrayList<>();
            uIManagerModule.addUIBlock(new UIBlock() {
                /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass1 */

                public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    dev nodesManager = ReanimatedModule.this.getNodesManager();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((O000000o) it.next()).O000000o(nodesManager);
                    }
                }
            });
        }
    }

    public dev getNodesManager() {
        if (this.mNodesManager == null) {
            this.mNodesManager = new dev(getReactApplicationContext());
        }
        return this.mNodesManager;
    }

    @ReactMethod
    public void animateNextTransition(int i, ReadableMap readableMap) {
        dfv dfv = this.mTransitionManager;
        dfv.f14590O000000o.prependUIBlock(new UIBlock(i, readableMap) {
            /* class _m_j.dfv.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ int f14591O000000o;
            final /* synthetic */ ReadableMap O00000Oo;

            {
                this.f14591O000000o = r2;
                this.O00000Oo = r3;
            }

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    View resolveView = nativeViewHierarchyManager.resolveView(this.f14591O000000o);
                    if (resolveView instanceof ViewGroup) {
                        ReadableArray array = this.O00000Oo.getArray("transitions");
                        int size = array.size();
                        for (int i = 0; i < size; i++) {
                            TransitionManager.beginDelayedTransition((ViewGroup) resolveView, dfw.O000000o(array.getMap(i)));
                        }
                    }
                } catch (IllegalViewOperationException unused) {
                }
            }
        });
    }

    @ReactMethod
    public void createNode(final int i, final ReadableMap readableMap) {
        this.mOperations.add(new O000000o() {
            /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass4 */

            public final void O000000o(dev dev) {
                Object obj;
                int i = i;
                ReadableMap readableMap = readableMap;
                if (dev.f14562O000000o.get(i) == null) {
                    String string = readableMap.getString("type");
                    if ("props".equals(string)) {
                        obj = new dfo(i, readableMap, dev, dev.O00000o0);
                    } else if ("style".equals(string)) {
                        obj = new dfq(i, readableMap, dev);
                    } else if ("transform".equals(string)) {
                        obj = new dfr(i, readableMap, dev);
                    } else if ("value".equals(string)) {
                        obj = new dfs(i, readableMap, dev);
                    } else if ("block".equals(string)) {
                        obj = new dfa(i, readableMap, dev);
                    } else if ("cond".equals(string)) {
                        obj = new dff(i, readableMap, dev);
                    } else if ("op".equals(string)) {
                        obj = new dfm(i, readableMap, dev);
                    } else if ("set".equals(string)) {
                        obj = new dfp(i, readableMap, dev);
                    } else if ("debug".equals(string)) {
                        obj = new dfg(i, readableMap, dev);
                    } else if ("clock".equals(string)) {
                        obj = new dfc(i, readableMap, dev);
                    } else if ("clockStart".equals(string)) {
                        obj = new dfd.O000000o(i, readableMap, dev);
                    } else if ("clockStop".equals(string)) {
                        obj = new dfd.O00000Oo(i, readableMap, dev);
                    } else if ("clockTest".equals(string)) {
                        obj = new dfd.O00000o0(i, readableMap, dev);
                    } else if ("call".equals(string)) {
                        obj = new dfj(i, readableMap, dev);
                    } else if ("bezier".equals(string)) {
                        obj = new dez(i, readableMap, dev);
                    } else if ("event".equals(string)) {
                        obj = new EventNode(i, readableMap, dev);
                    } else if ("always".equals(string)) {
                        obj = new dey(i, readableMap, dev);
                    } else if ("concat".equals(string)) {
                        obj = new dfe(i, readableMap, dev);
                    } else if ("param".equals(string)) {
                        obj = new dfn(i, readableMap, dev);
                    } else if ("func".equals(string)) {
                        obj = new dfi(i, readableMap, dev);
                    } else if ("callfunc".equals(string)) {
                        obj = new dfb(i, readableMap, dev);
                    } else {
                        throw new JSApplicationIllegalArgumentException("Unsupported node type: ".concat(String.valueOf(string)));
                    }
                    dev.f14562O000000o.put(i, obj);
                    return;
                }
                throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " already exists");
            }
        });
    }

    @ReactMethod
    public void dropNode(final int i) {
        this.mOperations.add(new O000000o() {
            /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass5 */

            public final void O000000o(dev dev) {
                dev.f14562O000000o.remove(i);
            }
        });
    }

    @ReactMethod
    public void connectNodes(final int i, final int i2) {
        this.mOperations.add(new O000000o() {
            /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass6 */

            public final void O000000o(dev dev) {
                int i = i;
                int i2 = i2;
                dfk dfk = dev.f14562O000000o.get(i);
                if (dfk != null) {
                    dfk dfk2 = dev.f14562O000000o.get(i2);
                    if (dfk2 != null) {
                        dfk.addChild(dfk2);
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException("Animated node with ID " + i2 + " does not exists");
                }
                throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " does not exists");
            }
        });
    }

    @ReactMethod
    public void disconnectNodes(final int i, final int i2) {
        this.mOperations.add(new O000000o() {
            /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass7 */

            public final void O000000o(dev dev) {
                int i = i;
                int i2 = i2;
                dfk dfk = dev.f14562O000000o.get(i);
                if (dfk != null) {
                    dfk dfk2 = dev.f14562O000000o.get(i2);
                    if (dfk2 != null) {
                        dfk.removeChild(dfk2);
                        return;
                    }
                    throw new JSApplicationIllegalArgumentException("Animated node with ID " + i2 + " does not exists");
                }
                throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " does not exists");
            }
        });
    }

    @ReactMethod
    public void connectNodeToView(final int i, final int i2) {
        this.mOperations.add(new O000000o() {
            /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass8 */

            public final void O000000o(dev dev) {
                int i = i;
                int i2 = i2;
                dfk dfk = dev.f14562O000000o.get(i);
                if (dfk == null) {
                    throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " does not exists");
                } else if (dfk instanceof dfo) {
                    ((dfo) dfk).O000000o(i2);
                } else {
                    throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + dfo.class.getName());
                }
            }
        });
    }

    @ReactMethod
    public void disconnectNodeFromView(final int i, final int i2) {
        this.mOperations.add(new O000000o() {
            /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass9 */

            public final void O000000o(dev dev) {
                int i = i;
                dfk dfk = dev.f14562O000000o.get(i);
                if (dfk == null) {
                    throw new JSApplicationIllegalArgumentException("Animated node with ID " + i + " does not exists");
                } else if (dfk instanceof dfo) {
                    ((dfo) dfk).f14581O000000o = -1;
                } else {
                    throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + dfo.class.getName());
                }
            }
        });
    }

    @ReactMethod
    public void attachEvent(final int i, final String str, final int i2) {
        this.mOperations.add(new O000000o() {
            /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass10 */

            public final void O000000o(dev dev) {
                int i = i;
                String str = str;
                int i2 = i2;
                String str2 = i + str;
                EventNode eventNode = (EventNode) dev.f14562O000000o.get(i2);
                if (eventNode == null) {
                    throw new JSApplicationIllegalArgumentException("Event node " + i2 + " does not exists");
                } else if (!dev.O00000Oo.containsKey(str2)) {
                    dev.O00000Oo.put(str2, eventNode);
                } else {
                    throw new JSApplicationIllegalArgumentException("Event handler already set for the given view and event type");
                }
            }
        });
    }

    @ReactMethod
    public void detachEvent(final int i, final String str, final int i2) {
        this.mOperations.add(new O000000o() {
            /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass11 */

            public final void O000000o(dev dev) {
                int i = i;
                String str = str;
                dev.O00000Oo.remove(i + str);
            }
        });
    }

    @ReactMethod
    public void configureProps(ReadableArray readableArray, ReadableArray readableArray2) {
        int size = readableArray.size();
        final HashSet hashSet = new HashSet(size);
        for (int i = 0; i < size; i++) {
            hashSet.add(readableArray.getString(i));
        }
        int size2 = readableArray2.size();
        final HashSet hashSet2 = new HashSet(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            hashSet2.add(readableArray2.getString(i2));
        }
        this.mOperations.add(new O000000o() {
            /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass2 */

            public final void O000000o(dev dev) {
                Set<String> set = hashSet;
                Set<String> set2 = hashSet2;
                dev.O0000o0O = set;
                dev.O0000o0 = set2;
            }
        });
    }

    @ReactMethod
    public void getValue(final int i, final Callback callback) {
        this.mOperations.add(new O000000o() {
            /* class com.swmansion.reanimated.ReanimatedModule.AnonymousClass3 */

            public final void O000000o(dev dev) {
                int i = i;
                callback.invoke(dev.f14562O000000o.get(i).value());
            }
        });
    }
}
