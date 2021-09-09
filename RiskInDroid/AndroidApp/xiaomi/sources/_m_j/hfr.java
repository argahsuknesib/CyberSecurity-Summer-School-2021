package _m_j;

import _m_j.gp;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "from", "", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "to", "animTracer", "Lcom/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer;", "(Ljava/util/List;Ljava/util/List;Lcom/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer;)V", "areContentsTheSame", "", "lh", "", "rh", "areItemsTheSame", "getNewListSize", "getOldListSize", "AnimTracer", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hfr extends gp.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private final List<MainPageDeviceModel> f18867O000000o;
    private final List<MainPageDeviceModel> O00000Oo;
    private final O000000o O00000o0;

    public hfr(List<MainPageDeviceModel> list, List<MainPageDeviceModel> list2, O000000o o000000o) {
        ixe.O00000o(list, "from");
        ixe.O00000o(list2, "to");
        ixe.O00000o(o000000o, "animTracer");
        this.f18867O000000o = list;
        this.O00000Oo = list2;
        this.O00000o0 = o000000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final boolean O000000o(int i, int i2) {
        return ixe.O000000o((Object) this.f18867O000000o.get(i).O00000oo, (Object) this.O00000Oo.get(i2).O00000oo);
    }

    public final int O000000o() {
        return this.f18867O000000o.size();
    }

    public final int O00000Oo() {
        return this.O00000Oo.size();
    }

    public final boolean O00000Oo(int i, int i2) {
        O000000o o000000o = this.O00000o0;
        String str = this.f18867O000000o.get(i).O00000oo;
        ixe.O00000o(str, "did");
        if (o000000o.O00000Oo.hasMessages(str.hashCode())) {
            return true;
        }
        return ixe.O000000o(this.f18867O000000o.get(i), this.O00000Oo.get(i2));
    }

    @Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\b\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer;", "", "callback", "Lcom/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer$IAnimEndCallback;", "(Lcom/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer$IAnimEndCallback;)V", "getCallback", "()Lcom/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer$IAnimEndCallback;", "handler", "com/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer$handler$1", "Lcom/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer$handler$1;", "dispose", "", "isInAnim", "", "did", "", "traceItem", "IAnimEndCallback", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final C0115O000000o f18868O000000o;
        final O00000Oo O00000Oo = new O00000Oo(this, Looper.getMainLooper());

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer$IAnimEndCallback;", "", "onAnimEnd", "", "did", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: _m_j.hfr$O000000o$O000000o  reason: collision with other inner class name */
        public interface C0115O000000o {
            void O000000o(String str);
        }

        public O000000o(C0115O000000o o000000o) {
            ixe.O00000o(o000000o, "callback");
            this.f18868O000000o = o000000o;
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer$handler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O00000Oo extends Handler {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O000000o f18869O000000o;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            O00000Oo(O000000o o000000o, Looper looper) {
                super(looper);
                this.f18869O000000o = o000000o;
            }

            public final void handleMessage(Message message) {
                ixe.O00000o(message, "msg");
                C0115O000000o o000000o = this.f18869O000000o.f18868O000000o;
                Object obj = message.obj;
                String str = obj instanceof String ? (String) obj : null;
                if (str != null) {
                    o000000o.O000000o(str);
                }
            }
        }
    }
}
