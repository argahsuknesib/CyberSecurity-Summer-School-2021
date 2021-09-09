package _m_j;

import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0006H&J$\u0010\u0013\u001a\u00020\u00062\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0004H&¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/operation/provider/IOperationProvider;", "T", "", "commonTestCanShow", "", "dispose", "", "getCache", "()Ljava/lang/Object;", "haveCache", "haveShown", "isCacheValid", "isImageCacheValid", "load", "url", "", "target", "Lcom/facebook/drawee/view/SimpleDraweeView;", "setHaveShown", "sync", "consumer", "Lio/reactivex/functions/Consumer;", "needCache", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface hlr<T> {
    void O000000o(Consumer<List<hju>> consumer, boolean z);

    void O000000o(String str, SimpleDraweeView simpleDraweeView);

    boolean O000000o();

    T O00000Oo();

    void O00000o();

    boolean O00000o0();

    void O00000oO();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.hlr.O000000o(io.reactivex.functions.Consumer<java.util.List<_m_j.hju>>, boolean):void
         arg types: [io.reactivex.functions.Consumer, int]
         candidates:
          _m_j.hlr.O000000o(java.lang.String, com.facebook.drawee.view.SimpleDraweeView):void
          _m_j.hlr.O000000o(io.reactivex.functions.Consumer<java.util.List<_m_j.hju>>, boolean):void */
        public static /* synthetic */ void O000000o(hlr hlr, Consumer consumer, int i) {
            if ((i & 1) != 0) {
                consumer = null;
            }
            hlr.O000000o((Consumer<List<hju>>) consumer, false);
        }
    }
}
