package _m_j;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.thread.DefaultPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

final class nz {

    /* renamed from: O000000o  reason: collision with root package name */
    static ILogger f2213O000000o = new ob("ARouter::");
    public static Context O00000Oo;
    private static volatile boolean O00000o = false;
    private static volatile boolean O00000o0 = false;
    private static volatile boolean O00000oO = false;
    private static volatile nz O00000oo = null;
    private static volatile boolean O0000O0o = false;
    private static volatile ThreadPoolExecutor O0000OOo = DefaultPoolExecutor.getInstance();
    private static InterceptorService O0000Oo;
    private static Handler O0000Oo0;

    private nz() {
    }

    protected static synchronized boolean O000000o(Application application) {
        synchronized (nz.class) {
            O00000Oo = application;
            nw.O000000o(application, O0000OOo);
            f2213O000000o.info("ARouter::", "ARouter init success!");
            O0000O0o = true;
            O0000Oo0 = new Handler(Looper.getMainLooper());
        }
        return true;
    }

    protected static nz O000000o() {
        if (O0000O0o) {
            if (O00000oo == null) {
                synchronized (nz.class) {
                    if (O00000oo == null) {
                        O00000oo = new nz();
                    }
                }
            }
            return O00000oo;
        }
        throw new InitException("ARouterCore::Init::Invoke init(context) first!");
    }

    @Deprecated
    static boolean O00000Oo() {
        return O00000oO;
    }

    static boolean O00000o0() {
        return O00000o;
    }

    static void O000000o(Object obj) {
        ny.O000000o();
        AutowiredService autowiredService = (AutowiredService) ny.O000000o("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    protected static Postcard O000000o(String str) {
        if (!oe.O000000o((CharSequence) str)) {
            ny.O000000o();
            PathReplaceService pathReplaceService = (PathReplaceService) ny.O000000o(PathReplaceService.class);
            if (pathReplaceService != null) {
                str = pathReplaceService.forString(str);
            }
            String O00000Oo2 = O00000Oo(str);
            if (oe.O000000o((CharSequence) str) || oe.O000000o((CharSequence) O00000Oo2)) {
                throw new HandlerException("ARouter::Parameter is invalid!");
            }
            ny.O000000o();
            PathReplaceService pathReplaceService2 = (PathReplaceService) ny.O000000o(PathReplaceService.class);
            if (pathReplaceService2 != null) {
                str = pathReplaceService2.forString(str);
            }
            return new Postcard(str, O00000Oo2);
        }
        throw new HandlerException("ARouter::Parameter is invalid!");
    }

    private static String O00000Oo(String str) {
        if (oe.O000000o((CharSequence) str) || !str.startsWith("/")) {
            throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String substring = str.substring(1, str.indexOf("/", 1));
            if (!oe.O000000o((CharSequence) substring)) {
                return substring;
            }
            throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
        } catch (Exception e) {
            ILogger iLogger = f2213O000000o;
            iLogger.warning("ARouter::", "Failed to extract default group! " + e.getMessage());
            return null;
        }
    }

    static void O00000o() {
        ny.O000000o();
        O0000Oo = (InterceptorService) ny.O000000o("/arouter/service/interceptor").navigation();
    }

    protected static <T> T O000000o(Class cls) {
        try {
            Postcard O000000o2 = nw.O000000o(cls.getName());
            if (O000000o2 == null) {
                O000000o2 = nw.O000000o(cls.getSimpleName());
            }
            if (O000000o2 == null) {
                return null;
            }
            nw.O000000o(O000000o2);
            return O000000o2.getProvider();
        } catch (NoRouteFoundException e) {
            f2213O000000o.warning("ARouter::", e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final Object O000000o(Context context, final Postcard postcard, int i, NavigationCallback navigationCallback) {
        try {
            nw.O000000o(postcard);
            if (navigationCallback != null) {
                navigationCallback.onFound(postcard);
            }
            if (postcard.isGreenChannel()) {
                return O00000Oo(context, postcard, i, navigationCallback);
            }
            final Context context2 = context;
            final int i2 = i;
            final NavigationCallback navigationCallback2 = navigationCallback;
            final Postcard postcard2 = postcard;
            O0000Oo.doInterceptions(postcard, new InterceptorCallback() {
                /* class _m_j.nz.AnonymousClass2 */

                public final void onContinue(Postcard postcard) {
                    nz.this.O00000Oo(context2, postcard, i2, navigationCallback2);
                }

                public final void onInterrupt(Throwable th) {
                    NavigationCallback navigationCallback = navigationCallback2;
                    if (navigationCallback != null) {
                        navigationCallback.onInterrupt(postcard2);
                    }
                    ILogger iLogger = nz.f2213O000000o;
                    iLogger.info("ARouter::", "Navigation failed, termination by interceptor : " + th.getMessage());
                }
            });
            return null;
        } catch (NoRouteFoundException e) {
            f2213O000000o.warning("ARouter::", e.getMessage());
            if (O00000o) {
                O000000o((Runnable) new Runnable() {
                    /* class _m_j.nz.AnonymousClass1 */

                    public final void run() {
                        Context context = nz.O00000Oo;
                        Toast.makeText(context, "There's no route matched!\n Path = [" + postcard.getPath() + "]\n Group = [" + postcard.getGroup() + "]", 1).show();
                    }
                });
            }
            if (navigationCallback != null) {
                navigationCallback.onLost(postcard);
            } else {
                ny.O000000o();
                DegradeService degradeService = (DegradeService) ny.O000000o(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, postcard);
                }
            }
            return null;
        }
    }

    public final Object O00000Oo(Context context, Postcard postcard, int i, NavigationCallback navigationCallback) {
        if (context == null) {
            context = O00000Oo;
        }
        final Context context2 = context;
        int i2 = AnonymousClass4.f2217O000000o[postcard.getType().ordinal()];
        if (i2 == 1) {
            final Intent intent = new Intent(context2, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (-1 != flags) {
                intent.setFlags(flags);
            } else if (!(context2 instanceof Activity)) {
                intent.setFlags(268435456);
            }
            String action = postcard.getAction();
            if (!oe.O000000o((CharSequence) action)) {
                intent.setAction(action);
            }
            final int i3 = i;
            final Postcard postcard2 = postcard;
            final NavigationCallback navigationCallback2 = navigationCallback;
            O000000o((Runnable) new Runnable() {
                /* class _m_j.nz.AnonymousClass3 */

                public final void run() {
                    nz.O000000o(i3, context2, intent, postcard2, navigationCallback2);
                }
            });
            return null;
        } else if (i2 == 2) {
            return postcard.getProvider();
        } else {
            if (i2 == 3 || i2 == 4 || i2 == 5) {
                try {
                    Object newInstance = postcard.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (newInstance instanceof Fragment) {
                        ((Fragment) newInstance).setArguments(postcard.getExtras());
                    } else if (newInstance instanceof androidx.fragment.app.Fragment) {
                        ((androidx.fragment.app.Fragment) newInstance).setArguments(postcard.getExtras());
                    }
                    return newInstance;
                } catch (Exception e) {
                    ILogger iLogger = f2213O000000o;
                    iLogger.error("ARouter::", "Fetch fragment instance error, " + oe.O000000o(e.getStackTrace()));
                }
            }
            return null;
        }
    }

    /* renamed from: _m_j.nz$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2217O000000o = new int[RouteType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f2217O000000o[RouteType.ACTIVITY.ordinal()] = 1;
            f2217O000000o[RouteType.PROVIDER.ordinal()] = 2;
            f2217O000000o[RouteType.BOARDCAST.ordinal()] = 3;
            f2217O000000o[RouteType.CONTENT_PROVIDER.ordinal()] = 4;
            f2217O000000o[RouteType.FRAGMENT.ordinal()] = 5;
            f2217O000000o[RouteType.METHOD.ordinal()] = 6;
            try {
                f2217O000000o[RouteType.SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static void O000000o(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            O0000Oo0.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void O000000o(int i, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i < 0) {
            oOOO00o0.O000000o(context, intent, postcard.getOptionsBundle());
        } else if (context instanceof Activity) {
            oOOO00o0.O000000o((Activity) context, intent, i, postcard.getOptionsBundle());
        } else {
            f2213O000000o.warning("ARouter::", "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (!(-1 == postcard.getEnterAnim() || -1 == postcard.getExitAnim() || !(context instanceof Activity))) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }
}
