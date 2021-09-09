package _m_j;

import _m_j.hjq;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.smarthome.application.ServiceApplication;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010&\u001a\u00020\u0005H&J\b\u0010'\u001a\u00020\u001aH\u0016J&\u0010(\u001a\u00020\u001a2\u0014\u0010)\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0018H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00108BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/xiaomi/smarthome/operation/provider/seq/CommonBaseOperationProvider;", "E", "Lcom/xiaomi/smarthome/operation/beans/IAdOperation;", "Lcom/xiaomi/smarthome/operation/provider/seq/ISequenceOperationProvider;", "cacheKey", "", "path", "params", "", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "disposes", "Lio/reactivex/disposables/CompositeDisposable;", "imageCacheHelper", "Lcom/xiaomi/smarthome/operation/helper/OperationImageCacheHelper;", "operations", "", "getOperations", "()Ljava/util/List;", "requestAndCacheHelper", "Lcom/xiaomi/smarthome/operation/helper/OperationRequestAndCacheHelper;", "shownHelper", "Lcom/xiaomi/smarthome/operation/helper/IShownHelper;", "commonTestCanShow", "", "dispose", "", "getCache", "haveCache", "haveShown", "installCookiePreRequest", "isCacheValid", "isImageCacheValid", "load", "url", "target", "Lcom/facebook/drawee/view/SimpleDraweeView;", "parse", "string", "setHaveShown", "sync", "consumer", "Lio/reactivex/functions/Consumer;", "needCache", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class hlt<E extends hjq> implements hlv<E> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f19054O000000o;
    private final Map<String, iwb<String>> O00000Oo;
    private final hkc O00000o;
    private final hjz<E> O00000o0;
    private final hkb O00000oO;
    private final CompositeDisposable O00000oo;
    private List<? extends E> O0000O0o;

    public abstract List<E> O000000o(String str);

    public /* synthetic */ hlt(String str, String str2) {
        this(str, str2, null);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.Map<java.lang.String, ? extends _m_j.iwb<java.lang.String>>, java.util.Map<java.lang.String, _m_j.iwb<java.lang.String>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public hlt(String str, String str2, Map<String, ? extends iwb<String>> r4) {
        ixe.O00000o(str, "cacheKey");
        ixe.O00000o(str2, "path");
        this.f19054O000000o = str2;
        this.O00000Oo = r4;
        this.O00000o0 = new hjw(str);
        this.O00000o = new hkc(str);
        this.O00000oO = new hkb();
        this.O00000oo = new CompositeDisposable();
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public final List<E> O00000Oo() {
        List<E> list = this.O0000O0o;
        if (list != null) {
            return list;
        }
        return O000000o(this.O00000o.O000000o());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final void O000000o(hlt hlt, Consumer consumer, boolean z, String str) {
        ixe.O00000o(hlt, "this$0");
        gsy.O00000Oo("BaseOperation", ixe.O000000o("sync ,latest : ", (Object) str));
        ixe.O00000Oo(str, "latest");
        List<? extends E> O000000o2 = hlt.O000000o(str);
        if (!O000000o2.isEmpty()) {
            if (!ixe.O000000o(hlt.O00000Oo(), O000000o2)) {
                hlt.O0000O0o = O000000o2;
                hkc hkc = hlt.O00000o;
                ixe.O00000o(str, "json");
                if (!TextUtils.isEmpty(str)) {
                    gpy.O000000o(ServiceApplication.getAppContext(), hkc.O00000Oo(), ixe.O000000o(hkc.O00000Oo, (Object) "_cached_data"), str);
                }
                Iterator it = O000000o2.iterator();
                while (it.hasNext()) {
                    hkb hkb = hlt.O00000oO;
                    String O00000Oo2 = ((hjq) it.next()).O00000Oo();
                    ixe.O00000o(O00000Oo2, "url");
                    if (!TextUtils.isEmpty(O00000Oo2)) {
                        Fresco.getImagePipeline().prefetchToDiskCache(ImageRequestBuilder.newBuilderWithSource(Uri.parse(O00000Oo2)).setLocalThumbnailPreviewsEnabled(false).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH).setProgressiveRenderingEnabled(false).build(), hkb);
                    }
                }
                if (consumer != null) {
                    consumer.accept(O000000o2);
                }
            } else if (z && consumer != null) {
                consumer.accept(O000000o2);
            }
        }
    }

    public final void O000000o(String str, SimpleDraweeView simpleDraweeView) {
        ixe.O00000o(str, "url");
        ixe.O00000o(simpleDraweeView, "target");
        hkb.O000000o(str, simpleDraweeView);
    }

    public final void O00000o() {
        hjz<E> hjz = this.O00000o0;
        List O00000oo2 = O00000Oo();
        if (O00000oo2 != null) {
            hjz.O00000Oo(O00000oo2);
        }
    }

    public final void O00000oO() {
        this.O00000oo.clear();
    }

    public final boolean O00000o0() {
        boolean z;
        boolean z2;
        List O00000oo2 = O00000Oo();
        Collection collection = O00000oo2;
        if (!(collection == null || collection.isEmpty())) {
            Iterable iterable = O00000oo2;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    hkb hkb = this.O00000oO;
                    String O00000Oo2 = ((hjq) it.next()).O00000Oo();
                    ixe.O00000o(O00000Oo2, "url");
                    if (TextUtils.isEmpty(O00000Oo2)) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = ImagePipelineFactory.getInstance().getMainBufferedDiskCache().diskCheckSync(DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(ImageRequest.fromUri(O00000Oo2), hkb));
                        continue;
                    }
                    if (!z2) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void O000000o(Consumer<List<E>> consumer, boolean z) {
        hjx.f19006O000000o.O00000Oo();
        this.O00000oo.add(hkc.O000000o(this.f19054O000000o, this.O00000Oo).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(consumer, false) {
            /* class _m_j.$$Lambda$hlt$uRMjeajkDR2IeQOkN4hPzIyc3s */
            private final /* synthetic */ Consumer f$1;
            private final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                hlt.O000000o(hlt.this, this.f$1, this.f$2, (String) obj);
            }
        }));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    public final boolean O000000o() {
        boolean z;
        boolean z2;
        if (this.O00000o.O000000o().length() > 0) {
            List O00000oo2 = O00000Oo();
            Collection collection = O00000oo2;
            if (!(collection == null || collection.isEmpty())) {
                Iterable iterable = O00000oo2;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!(!((hjq) it.next()).O000000o())) {
                                z2 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z2) {
                        z = true;
                        return !z && !this.O00000o0.O000000o(O00000Oo());
                    }
                }
                z2 = true;
                if (z2) {
                }
            }
            z = false;
            if (!z) {
            }
        }
    }
}
