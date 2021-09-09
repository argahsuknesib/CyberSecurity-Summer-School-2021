package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

public final class nw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static ThreadPoolExecutor f2209O000000o;
    private static Context O00000Oo;
    private static boolean O00000o0;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045 A[Catch:{ Exception -> 0x01cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046 A[Catch:{ Exception -> 0x01cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f2 A[Catch:{ Exception -> 0x01cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0185 A[Catch:{ Exception -> 0x01cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0194 A[Catch:{ Exception -> 0x01cf }] */
    public static synchronized void O000000o(Context context, ThreadPoolExecutor threadPoolExecutor) throws HandlerException {
        Set<String> set;
        boolean z;
        synchronized (nw.class) {
            O00000Oo = context;
            f2209O000000o = threadPoolExecutor;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                O00000o0 = false;
                if (!ny.O00000Oo()) {
                    PackageInfo O000000o2 = od.O000000o(context);
                    if (O000000o2 != null) {
                        String str = O000000o2.versionName;
                        int i = O000000o2.versionCode;
                        SharedPreferences sharedPreferences = context.getSharedPreferences("SP_AROUTER_CACHE", 0);
                        if (str.equals(sharedPreferences.getString("LAST_VERSION_NAME", null))) {
                            if (i == sharedPreferences.getInt("LAST_VERSION_CODE", -1)) {
                                z = false;
                                if (z) {
                                    ny.f2212O000000o.info("ARouter::", "Load router map from cache.");
                                    set = new HashSet<>(context.getSharedPreferences("SP_AROUTER_CACHE", 0).getStringSet("ROUTER_MAP", new HashSet()));
                                    ILogger iLogger = ny.f2212O000000o;
                                    iLogger.info("ARouter::", "Find router map finished, map size = " + set.size() + ", cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    for (String str2 : set) {
                                        if (str2.startsWith("com.alibaba.android.arouter.routes.ARouter$$Root")) {
                                            ((IRouteRoot) Class.forName(str2).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(nx.f2211O000000o);
                                        } else if (str2.startsWith("com.alibaba.android.arouter.routes.ARouter$$Interceptors")) {
                                            ((IInterceptorGroup) Class.forName(str2).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(nx.O00000oO);
                                        } else if (str2.startsWith("com.alibaba.android.arouter.routes.ARouter$$Providers")) {
                                            ((IProviderGroup) Class.forName(str2).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(nx.O00000o);
                                        }
                                    }
                                    ILogger iLogger2 = ny.f2212O000000o;
                                    iLogger2.info("ARouter::", "Load root element finished, cost " + (System.currentTimeMillis() - currentTimeMillis2) + " ms.");
                                    if (nx.f2211O000000o.size() == 0) {
                                        ny.f2212O000000o.error("ARouter::", "No mapping files were found, check your configuration please!");
                                    }
                                    if (ny.O00000Oo()) {
                                        ny.f2212O000000o.debug("ARouter::", String.format(Locale.getDefault(), "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]", Integer.valueOf(nx.f2211O000000o.size()), Integer.valueOf(nx.O00000oO.size()), Integer.valueOf(nx.O00000o.size())));
                                    }
                                }
                            }
                        }
                        od.f2339O000000o = str;
                        od.O00000Oo = i;
                    }
                    z = true;
                    if (z) {
                    }
                }
                ny.f2212O000000o.info("ARouter::", "Run with debug mode or new install, rebuild router map.");
                set = oa.O000000o(O00000Oo, "com.alibaba.android.arouter.routes");
                if (!set.isEmpty()) {
                    context.getSharedPreferences("SP_AROUTER_CACHE", 0).edit().putStringSet("ROUTER_MAP", set).apply();
                }
                if (!TextUtils.isEmpty(od.f2339O000000o) && od.O00000Oo != 0) {
                    context.getSharedPreferences("SP_AROUTER_CACHE", 0).edit().putString("LAST_VERSION_NAME", od.f2339O000000o).putInt("LAST_VERSION_CODE", od.O00000Oo).apply();
                }
                ILogger iLogger3 = ny.f2212O000000o;
                iLogger3.info("ARouter::", "Find router map finished, map size = " + set.size() + ", cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
                long currentTimeMillis22 = System.currentTimeMillis();
                while (r9.hasNext()) {
                }
                ILogger iLogger22 = ny.f2212O000000o;
                iLogger22.info("ARouter::", "Load root element finished, cost " + (System.currentTimeMillis() - currentTimeMillis22) + " ms.");
                if (nx.f2211O000000o.size() == 0) {
                }
                if (ny.O00000Oo()) {
                }
            } catch (Exception e) {
                throw new HandlerException("ARouter::ARouter init logistics center exception! [" + e.getMessage() + "]");
            }
        }
    }

    public static Postcard O000000o(String str) {
        RouteMeta routeMeta = nx.O00000o.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008f, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ac, code lost:
        throw new com.alibaba.android.arouter.exception.HandlerException("ARouter::Fatal exception when loading group meta. [" + r14.getMessage() + "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x026e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0296, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02ae, code lost:
        throw new com.alibaba.android.arouter.exception.HandlerException("Init provider failed! " + r14.getMessage());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0024, B:84:0x027d] */
    public static synchronized void O000000o(Postcard postcard) {
        synchronized (nw.class) {
            if (postcard != null) {
                RouteMeta routeMeta = nx.O00000Oo.get(postcard.getPath());
                if (routeMeta == null) {
                    Class cls = nx.f2211O000000o.get(postcard.getGroup());
                    if (cls != null) {
                        if (ny.O00000Oo()) {
                            ny.f2212O000000o.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] starts loading, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                        }
                        ((IRouteGroup) cls.getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(nx.O00000Oo);
                        nx.f2211O000000o.remove(postcard.getGroup());
                        if (ny.O00000Oo()) {
                            ny.f2212O000000o.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] has already been loaded, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                        }
                        O000000o(postcard);
                        return;
                    }
                    throw new NoRouteFoundException("ARouter::There is no route match the path [" + postcard.getPath() + "], in group [" + postcard.getGroup() + "]");
                }
                postcard.setDestination(routeMeta.getDestination());
                postcard.setType(routeMeta.getType());
                postcard.setPriority(routeMeta.getPriority());
                postcard.setExtra(routeMeta.getExtra());
                Uri uri = postcard.getUri();
                if (uri != null) {
                    Map<String, String> O000000o2 = oe.O000000o(uri);
                    Map<String, Integer> paramsType = routeMeta.getParamsType();
                    if (oc.O000000o(paramsType)) {
                        for (Map.Entry next : paramsType.entrySet()) {
                            Integer num = (Integer) next.getValue();
                            String str = (String) next.getKey();
                            String str2 = O000000o2.get(next.getKey());
                            if (!oe.O000000o((CharSequence) str) && !oe.O000000o((CharSequence) str2)) {
                                if (num != null) {
                                    try {
                                        if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                                            postcard.withBoolean(str, Boolean.parseBoolean(str2));
                                        } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                                            postcard.withByte(str, Byte.valueOf(str2).byteValue());
                                        } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                                            postcard.withShort(str, Short.valueOf(str2).shortValue());
                                        } else if (num.intValue() == TypeKind.INT.ordinal()) {
                                            postcard.withInt(str, Integer.valueOf(str2).intValue());
                                        } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                                            postcard.withLong(str, Long.valueOf(str2).longValue());
                                        } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                                            postcard.withFloat(str, Float.valueOf(str2).floatValue());
                                        } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                                            postcard.withDouble(str, Double.valueOf(str2).doubleValue());
                                        } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                                            postcard.withString(str, str2);
                                        } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                                            if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                                                postcard.withString(str, str2);
                                            } else {
                                                postcard.withString(str, str2);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        ILogger iLogger = ny.f2212O000000o;
                                        iLogger.warning("ARouter::", "LogisticsCenter setValue failed! " + th.getMessage());
                                    }
                                } else {
                                    postcard.withString(str, str2);
                                }
                            }
                        }
                        postcard.getExtras().putStringArray("wmHzgD4lOj5o4241", (String[]) paramsType.keySet().toArray(new String[0]));
                    }
                    postcard.withString("NTeRQWvye18AkPd6G", uri.toString());
                }
                int i = AnonymousClass1.f2210O000000o[routeMeta.getType().ordinal()];
                if (i == 1) {
                    Class<?> destination = routeMeta.getDestination();
                    IProvider iProvider = nx.O00000o0.get(destination);
                    if (iProvider == null) {
                        iProvider = (IProvider) destination.getConstructor(new Class[0]).newInstance(new Object[0]);
                        iProvider.init(O00000Oo);
                        nx.O00000o0.put(destination, iProvider);
                    }
                    postcard.setProvider(iProvider);
                    postcard.greenChannel();
                } else if (i == 2) {
                    postcard.greenChannel();
                }
            } else {
                throw new NoRouteFoundException("ARouter::No postcard!");
            }
        }
    }

    /* renamed from: _m_j.nw$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2210O000000o = new int[RouteType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f2210O000000o[RouteType.PROVIDER.ordinal()] = 1;
            f2210O000000o[RouteType.FRAGMENT.ordinal()] = 2;
        }
    }
}
