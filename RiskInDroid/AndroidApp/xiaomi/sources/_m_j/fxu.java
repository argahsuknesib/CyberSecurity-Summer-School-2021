package _m_j;

import android.os.Build;
import android.util.Log;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSBundleLoaderDelegate;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.queue.MessageQueueThreadSpec;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.v8.reactexecutor.V8ExecutorFactory;
import com.xiaomi.smarthome.framework.plugin.rn.jsc.JSCallee;
import com.xiaomi.smarthome.framework.plugin.rn.jsc.JSCaller;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class fxu extends fxr {
    private static final AtomicLong O00000o = new AtomicLong(100);

    /* renamed from: O000000o  reason: collision with root package name */
    private final Map<String, ModuleHolder> f17387O000000o = new HashMap();
    private JSCallee O00000Oo = null;
    private CatalystInstanceImpl O00000o0 = null;
    private final String O00000oO = ("jsc_" + O00000o.incrementAndGet());

    public final String O000000o() {
        return this.O00000oO;
    }

    public final boolean O00000Oo() {
        CatalystInstanceImpl catalystInstanceImpl = this.O00000o0;
        return catalystInstanceImpl != null && catalystInstanceImpl.hasRunJSBundle() && !this.O00000o0.isDestroyed();
    }

    public final void close() {
        CatalystInstanceImpl catalystInstanceImpl = this.O00000o0;
        if (catalystInstanceImpl != null) {
            if (catalystInstanceImpl.isDestroyed()) {
                this.O00000o0 = null;
                return;
            }
            synchronized (this) {
                if (!catalystInstanceImpl.isDestroyed()) {
                    catalystInstanceImpl.destroy();
                }
            }
            this.O00000o0 = null;
        }
    }

    public final void O000000o(String str, String str2, fxv fxv) {
        if (this.O00000Oo == null || !O00000Oo()) {
            fxv.O00000Oo("jsc is not ready");
            return;
        }
        String add = this.O00000Oo.add(fxv);
        try {
            ((JSCaller) this.O00000o0.getJSModule(JSCaller.class)).invoke(add, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            if (!this.O00000Oo.checkInvokedAndRemove(add)) {
                fxv.O00000Oo(e.getMessage());
            }
        }
    }

    public final void O000000o(final ReactApplicationContext reactApplicationContext, final String str, String str2) throws Exception {
        MessageQueueThreadSpec messageQueueThreadSpec;
        JavaScriptExecutor create = new V8ExecutorFactory().create();
        this.O00000Oo = new JSCallee();
        JSCallee jSCallee = this.O00000Oo;
        String name = jSCallee.getName();
        Class<?> cls = jSCallee.getClass();
        if (this.f17387O000000o.containsKey(name)) {
            ModuleHolder moduleHolder = this.f17387O000000o.get(name);
            if (moduleHolder.getCanOverrideExistingModule()) {
                this.f17387O000000o.remove(moduleHolder);
            } else {
                throw new IllegalStateException("Native module " + cls.getSimpleName() + " tried to override " + moduleHolder.getClassName() + " for module name " + name + ". If this was your intention, set canOverrideExistingModule=true");
            }
        }
        this.f17387O000000o.put(name, new ModuleHolder(jSCallee));
        NativeModuleRegistry nativeModuleRegistry = new NativeModuleRegistry(reactApplicationContext, this.f17387O000000o);
        CatalystInstanceImpl.Builder builder = new CatalystInstanceImpl.Builder();
        builder.setJSBundleLoader(new JSBundleLoader() {
            /* class _m_j.fxu.AnonymousClass1 */

            public final String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                JSBundleLoader.createAssetLoader(reactApplicationContext, "assets://plugin/RNExecutorBase.jx", false).loadScript(jSBundleLoaderDelegate);
                if (str.startsWith("assets://")) {
                    return JSBundleLoader.createAssetLoader(reactApplicationContext, str, false).loadScript(jSBundleLoaderDelegate);
                }
                String str = str;
                return JSBundleLoader.createFileLoader(str, str, false).loadScript(jSBundleLoaderDelegate);
            }
        });
        builder.setNativeModuleCallExceptionHandler(new NativeModuleCallExceptionHandler() {
            /* class _m_j.fxu.AnonymousClass2 */

            public final void handleException(Exception exc) {
                Log.i("JSCORE", "error raised", exc);
            }
        });
        String str3 = this.O00000oO;
        if (Build.VERSION.SDK_INT < 21) {
            messageQueueThreadSpec = MessageQueueThreadSpec.newBackgroundThreadSpec(str3, 2000000);
        } else {
            messageQueueThreadSpec = MessageQueueThreadSpec.newBackgroundThreadSpec(str3);
        }
        ReactQueueConfigurationSpec.Builder builder2 = ReactQueueConfigurationSpec.builder();
        builder.setReactQueueConfigurationSpec(builder2.setJSQueueThreadSpec(MessageQueueThreadSpec.newBackgroundThreadSpec(str3 + "_js")).setNativeModulesQueueThreadSpec(messageQueueThreadSpec).build());
        builder.setJSExecutor(create);
        builder.setRegistry(nativeModuleRegistry);
        this.O00000o0 = builder.build();
        this.O00000o0.setGlobalVariable("initialProps", str2);
        this.O00000o0.runJSBundle();
    }
}
