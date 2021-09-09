package rx.plugins;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins {
    static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaErrorHandler() {
        /* class rx.plugins.RxJavaPlugins.AnonymousClass1 */
    };
    private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
    private final AtomicReference<RxJavaCompletableExecutionHook> completableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference<>();
    private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSingleExecutionHook> singleExecutionHook = new AtomicReference<>();

    @Deprecated
    public static RxJavaPlugins getInstance() {
        return INSTANCE;
    }

    RxJavaPlugins() {
    }

    public void reset() {
        INSTANCE.errorHandler.set(null);
        INSTANCE.observableExecutionHook.set(null);
        INSTANCE.singleExecutionHook.set(null);
        INSTANCE.completableExecutionHook.set(null);
        INSTANCE.schedulersHook.set(null);
    }

    public RxJavaErrorHandler getErrorHandler() {
        if (this.errorHandler.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaErrorHandler.class, System.getProperties());
            if (pluginImplementationViaProperty == null) {
                this.errorHandler.compareAndSet(null, DEFAULT_ERROR_HANDLER);
            } else {
                this.errorHandler.compareAndSet(null, (RxJavaErrorHandler) pluginImplementationViaProperty);
            }
        }
        return this.errorHandler.get();
    }

    public void registerErrorHandler(RxJavaErrorHandler rxJavaErrorHandler) {
        if (!this.errorHandler.compareAndSet(null, rxJavaErrorHandler)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.errorHandler.get());
        }
    }

    public RxJavaObservableExecutionHook getObservableExecutionHook() {
        if (this.observableExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaObservableExecutionHook.class, System.getProperties());
            if (pluginImplementationViaProperty == null) {
                this.observableExecutionHook.compareAndSet(null, RxJavaObservableExecutionHookDefault.getInstance());
            } else {
                this.observableExecutionHook.compareAndSet(null, (RxJavaObservableExecutionHook) pluginImplementationViaProperty);
            }
        }
        return this.observableExecutionHook.get();
    }

    public void registerObservableExecutionHook(RxJavaObservableExecutionHook rxJavaObservableExecutionHook) {
        if (!this.observableExecutionHook.compareAndSet(null, rxJavaObservableExecutionHook)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.observableExecutionHook.get());
        }
    }

    public RxJavaSingleExecutionHook getSingleExecutionHook() {
        if (this.singleExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaSingleExecutionHook.class, System.getProperties());
            if (pluginImplementationViaProperty == null) {
                this.singleExecutionHook.compareAndSet(null, RxJavaSingleExecutionHookDefault.getInstance());
            } else {
                this.singleExecutionHook.compareAndSet(null, (RxJavaSingleExecutionHook) pluginImplementationViaProperty);
            }
        }
        return this.singleExecutionHook.get();
    }

    public void registerSingleExecutionHook(RxJavaSingleExecutionHook rxJavaSingleExecutionHook) {
        if (!this.singleExecutionHook.compareAndSet(null, rxJavaSingleExecutionHook)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
        }
    }

    public RxJavaCompletableExecutionHook getCompletableExecutionHook() {
        if (this.completableExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaCompletableExecutionHook.class, System.getProperties());
            if (pluginImplementationViaProperty == null) {
                this.completableExecutionHook.compareAndSet(null, new RxJavaCompletableExecutionHook() {
                    /* class rx.plugins.RxJavaPlugins.AnonymousClass2 */
                });
            } else {
                this.completableExecutionHook.compareAndSet(null, (RxJavaCompletableExecutionHook) pluginImplementationViaProperty);
            }
        }
        return this.completableExecutionHook.get();
    }

    public void registerCompletableExecutionHook(RxJavaCompletableExecutionHook rxJavaCompletableExecutionHook) {
        if (!this.completableExecutionHook.compareAndSet(null, rxJavaCompletableExecutionHook)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a9 A[SYNTHETIC, Splitter:B:17:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012a A[RETURN] */
    static Object getPluginImplementationViaProperty(Class<?> cls, Properties properties) {
        String str;
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            Iterator it = properties2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String obj = entry.getKey().toString();
                if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                    String str2 = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                    str = properties2.getProperty(str2);
                    if (str == null) {
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str2);
                    }
                }
            }
            if (str != null) {
                return null;
            }
            try {
                return Class.forName(str).asSubclass(cls).newInstance();
            } catch (ClassCastException e) {
                throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + str, e);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException(simpleName + " implementation class not found: " + str, e2);
            } catch (InstantiationException e3) {
                throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + str, e3);
            } catch (IllegalAccessException e4) {
                throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + str, e4);
            }
        }
        str = property;
        if (str != null) {
        }
    }

    public RxJavaSchedulersHook getSchedulersHook() {
        if (this.schedulersHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaSchedulersHook.class, System.getProperties());
            if (pluginImplementationViaProperty == null) {
                this.schedulersHook.compareAndSet(null, RxJavaSchedulersHook.getDefaultInstance());
            } else {
                this.schedulersHook.compareAndSet(null, (RxJavaSchedulersHook) pluginImplementationViaProperty);
            }
        }
        return this.schedulersHook.get();
    }

    public void registerSchedulersHook(RxJavaSchedulersHook rxJavaSchedulersHook) {
        if (!this.schedulersHook.compareAndSet(null, rxJavaSchedulersHook)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
        }
    }
}
