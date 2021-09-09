package com.alibaba.android.arouter.core;

import _m_j.nw;
import _m_j.nx;
import _m_j.ny;
import _m_j.oc;
import android.content.Context;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.thread.CancelableCountDownLatch;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Route(path = "/arouter/service/interceptor")
public class InterceptorServiceImpl implements InterceptorService {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f3117O000000o;
    public static final Object O00000Oo = new Object();

    public void doInterceptions(final Postcard postcard, final InterceptorCallback interceptorCallback) {
        if (nx.O00000oo == null || nx.O00000oo.size() <= 0) {
            interceptorCallback.onContinue(postcard);
            return;
        }
        synchronized (O00000Oo) {
            while (!f3117O000000o) {
                try {
                    O00000Oo.wait(10000);
                } catch (InterruptedException e) {
                    throw new HandlerException("ARouter::Interceptor init cost too much time error! reason = [" + e.getMessage() + "]");
                }
            }
        }
        if (!f3117O000000o) {
            interceptorCallback.onInterrupt(new HandlerException("Interceptors initialization takes too much time."));
        } else {
            nw.f2209O000000o.execute(new Runnable() {
                /* class com.alibaba.android.arouter.core.InterceptorServiceImpl.AnonymousClass1 */

                public final void run() {
                    CancelableCountDownLatch cancelableCountDownLatch = new CancelableCountDownLatch(nx.O00000oo.size());
                    try {
                        InterceptorServiceImpl.O000000o(0, cancelableCountDownLatch, postcard);
                        cancelableCountDownLatch.await((long) postcard.getTimeout(), TimeUnit.SECONDS);
                        if (cancelableCountDownLatch.getCount() > 0) {
                            interceptorCallback.onInterrupt(new HandlerException("The interceptor processing timed out."));
                        } else if (postcard.getTag() != null) {
                            interceptorCallback.onInterrupt(new HandlerException(postcard.getTag().toString()));
                        } else {
                            interceptorCallback.onContinue(postcard);
                        }
                    } catch (Exception e) {
                        interceptorCallback.onInterrupt(e);
                    }
                }
            });
        }
    }

    public static void O000000o(final int i, final CancelableCountDownLatch cancelableCountDownLatch, final Postcard postcard) {
        if (i < nx.O00000oo.size()) {
            nx.O00000oo.get(i).process(postcard, new InterceptorCallback() {
                /* class com.alibaba.android.arouter.core.InterceptorServiceImpl.AnonymousClass2 */

                public final void onContinue(Postcard postcard) {
                    cancelableCountDownLatch.countDown();
                    InterceptorServiceImpl.O000000o(i + 1, cancelableCountDownLatch, postcard);
                }

                public final void onInterrupt(Throwable th) {
                    postcard.setTag(th == null ? new HandlerException("No message.") : th.getMessage());
                    cancelableCountDownLatch.cancel();
                }
            });
        }
    }

    public void init(final Context context) {
        nw.f2209O000000o.execute(new Runnable() {
            /* class com.alibaba.android.arouter.core.InterceptorServiceImpl.AnonymousClass3 */

            public final void run() {
                if (oc.O000000o(nx.O00000oO)) {
                    for (Map.Entry<Integer, Class<? extends IInterceptor>> value : nx.O00000oO.entrySet()) {
                        Class cls = (Class) value.getValue();
                        try {
                            IInterceptor iInterceptor = (IInterceptor) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                            iInterceptor.init(context);
                            nx.O00000oo.add(iInterceptor);
                        } catch (Exception e) {
                            throw new HandlerException("ARouter::ARouter init interceptor error! name = [" + cls.getName() + "], reason = [" + e.getMessage() + "]");
                        }
                    }
                    InterceptorServiceImpl.f3117O000000o = true;
                    ny.f2212O000000o.info("ARouter::", "ARouter interceptors init over.");
                    synchronized (InterceptorServiceImpl.O00000Oo) {
                        InterceptorServiceImpl.O00000Oo.notifyAll();
                    }
                }
            }
        });
    }
}
