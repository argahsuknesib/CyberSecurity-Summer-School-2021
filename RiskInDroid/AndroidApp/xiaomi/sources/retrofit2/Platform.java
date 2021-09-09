package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter;

class Platform {
    private static final Platform PLATFORM = findPlatform();

    /* access modifiers changed from: package-private */
    public Executor defaultCallbackExecutor() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean isDefaultMethod(Method method) {
        return false;
    }

    Platform() {
    }

    static Platform get() {
        return PLATFORM;
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new Java8();
        } catch (ClassNotFoundException unused2) {
            try {
                Class.forName("org.robovm.apple.foundation.NSObject");
                return new IOS();
            } catch (ClassNotFoundException unused3) {
                return new Platform();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public CallAdapter.Factory defaultCallAdapterFactory(Executor executor) {
        if (executor != null) {
            return new ExecutorCallAdapterFactory(executor);
        }
        return DefaultCallAdapterFactory.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    static class Java8 extends Platform {
        Java8() {
        }

        /* access modifiers changed from: package-private */
        public boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }

        /* access modifiers changed from: package-private */
        public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor<MethodHandles.Lookup> declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(cls, -1).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    static class Android extends Platform {
        Android() {
        }

        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        /* access modifiers changed from: package-private */
        public CallAdapter.Factory defaultCallAdapterFactory(Executor executor) {
            return new ExecutorCallAdapterFactory(executor);
        }

        static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }
    }

    static class IOS extends Platform {
        IOS() {
        }

        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        /* access modifiers changed from: package-private */
        public CallAdapter.Factory defaultCallAdapterFactory(Executor executor) {
            return new ExecutorCallAdapterFactory(executor);
        }

        static class MainThreadExecutor implements Executor {
            private static Method addOperation;
            private static Object queue;

            MainThreadExecutor() {
            }

            static {
                try {
                    Class<?> cls = Class.forName("org.robovm.apple.foundation.NSOperationQueue");
                    queue = cls.getDeclaredMethod("getMainQueue", new Class[0]).invoke(null, new Object[0]);
                    addOperation = cls.getDeclaredMethod("addOperation", Runnable.class);
                } catch (Exception e) {
                    throw new AssertionError(e);
                }
            }

            public void execute(Runnable runnable) {
                try {
                    addOperation.invoke(queue, runnable);
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    throw new AssertionError(e);
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    } else if (cause instanceof Error) {
                        throw ((Error) cause);
                    } else {
                        throw new RuntimeException(cause);
                    }
                }
            }
        }
    }
}
