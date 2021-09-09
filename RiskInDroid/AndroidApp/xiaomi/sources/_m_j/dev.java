package _m_j;

import android.util.SparseArray;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerReanimatedHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.swmansion.reanimated.nodes.EventNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class dev implements EventDispatcherListener {
    private static final Double O0000o = Double.valueOf(0.0d);

    /* renamed from: O000000o  reason: collision with root package name */
    public final SparseArray<dfk> f14562O000000o = new SparseArray<>();
    public final Map<String, EventNode> O00000Oo = new HashMap();
    public final ReactChoreographer O00000o;
    public final UIImplementation O00000o0;
    public final GuardedFrameCallback O00000oO;
    public final AtomicBoolean O00000oo = new AtomicBoolean();
    final ReactContext O0000O0o;
    public final UIManagerModule O0000OOo;
    ConcurrentLinkedQueue<Event> O0000Oo = new ConcurrentLinkedQueue<>();
    List<O00000Oo> O0000Oo0 = new ArrayList();
    public boolean O0000OoO;
    public double O0000Ooo;
    public Set<String> O0000o0 = Collections.emptySet();
    public final dew O0000o00;
    public Set<String> O0000o0O = Collections.emptySet();
    public Queue<O000000o> O0000o0o = new LinkedList();
    private final UIManagerModule.CustomEventNamesResolver O0000oO;
    private final DeviceEventManagerModule.RCTDeviceEventEmitter O0000oO0;
    private final dfl O0000oOO;

    public interface O00000Oo {
        void O000000o();
    }

    public final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f14565O000000o;
        public WritableMap O00000Oo;

        public O000000o(int i, WritableMap writableMap) {
            this.f14565O000000o = i;
            this.O00000Oo = writableMap;
        }
    }

    public dev(ReactContext reactContext) {
        this.O0000O0o = reactContext;
        this.O0000OOo = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        this.O0000o00 = new dew();
        this.O00000o0 = this.O0000OOo.getUIImplementation();
        this.O0000oO = this.O0000OOo.getDirectEventNamesResolver();
        this.O0000OOo.getEventDispatcher().addListener(this);
        this.O0000oO0 = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        this.O00000o = ReactChoreographer.getInstance();
        this.O00000oO = new GuardedFrameCallback(reactContext) {
            /* class _m_j.dev.AnonymousClass1 */

            public final void doFrameGuarded(long j) {
                dev dev = dev.this;
                double d = (double) j;
                Double.isNaN(d);
                dev.O0000Ooo = d / 1000000.0d;
                while (!dev.O0000Oo.isEmpty()) {
                    dev.O000000o(dev.O0000Oo.poll());
                }
                if (!dev.O0000Oo0.isEmpty()) {
                    List<O00000Oo> list = dev.O0000Oo0;
                    dev.O0000Oo0 = new ArrayList(list.size());
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        list.get(i).O000000o();
                    }
                }
                if (dev.O0000OoO) {
                    dfk.runUpdates(dev.O0000o00);
                }
                if (!dev.O0000o0o.isEmpty()) {
                    Queue<O000000o> queue = dev.O0000o0o;
                    dev.O0000o0o = new LinkedList();
                    dev.O0000O0o.runOnNativeModulesQueueThread(new GuardedRunnable(dev.O0000O0o, queue) {
                        /* class _m_j.dev.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Queue f14564O000000o;

                        {
                            this.f14564O000000o = r3;
                        }

                        public final void runGuarded() {
                            boolean isOperationQueueEmpty = UIManagerReanimatedHelper.isOperationQueueEmpty(dev.this.O00000o0);
                            while (!this.f14564O000000o.isEmpty()) {
                                O000000o o000000o = (O000000o) this.f14564O000000o.remove();
                                ReactShadowNode resolveShadowNode = dev.this.O00000o0.resolveShadowNode(o000000o.f14565O000000o);
                                if (resolveShadowNode != null) {
                                    dev.this.O0000OOo.updateView(o000000o.f14565O000000o, resolveShadowNode.getViewClass(), o000000o.O00000Oo);
                                }
                            }
                            if (isOperationQueueEmpty) {
                                dev.this.O00000o0.dispatchViewUpdates(-1);
                            }
                        }
                    });
                }
                dev.O00000oo.set(false);
                dev.O0000OoO = false;
                if (!dev.O0000Oo0.isEmpty() || !dev.O0000Oo.isEmpty()) {
                    dev.O000000o();
                }
            }
        };
        this.O0000oOO = new dfl(this);
    }

    public final void O000000o() {
        if (!this.O00000oo.getAndSet(true)) {
            this.O00000o.postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.O00000oO);
        }
    }

    public final Object O000000o(int i) {
        dfk dfk = this.f14562O000000o.get(i);
        if (dfk != null) {
            return dfk.value();
        }
        return O0000o;
    }

    public final <T extends dfk> T O000000o(int i, Class<T> cls) {
        T t = (dfk) this.f14562O000000o.get(i);
        if (t == null) {
            if (cls == dfk.class || cls == dfs.class) {
                return this.O0000oOO;
            }
            throw new IllegalArgumentException("Requested node with id " + i + " of type " + cls + " cannot be found");
        } else if (cls.isInstance(t)) {
            return t;
        } else {
            throw new IllegalArgumentException("Node with id " + i + " is of incompatible type " + t.getClass() + ", requested type was " + cls);
        }
    }

    public final void O000000o(O00000Oo o00000Oo) {
        this.O0000Oo0.add(o00000Oo);
        O000000o();
    }

    public final void onEventDispatch(Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            O000000o(event);
            return;
        }
        this.O0000Oo.offer(event);
        O000000o();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Event event) {
        if (!this.O00000Oo.isEmpty()) {
            String resolveCustomEventName = this.O0000oO.resolveCustomEventName(event.getEventName());
            int viewTag = event.getViewTag();
            EventNode eventNode = this.O00000Oo.get(viewTag + resolveCustomEventName);
            if (eventNode != null) {
                event.dispatch(eventNode);
            }
        }
    }

    public final void O000000o(String str, WritableMap writableMap) {
        this.O0000oO0.emit(str, writableMap);
    }
}
