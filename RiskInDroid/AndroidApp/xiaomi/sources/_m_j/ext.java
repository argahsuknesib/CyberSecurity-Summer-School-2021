package _m_j;

import com.xiaomi.smarthome.device.Device;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/xiaomi/smarthome/DeviceRenderRouterFactory;", "", "()V", "Companion", "smarthome-mainpage-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ext {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f15931O000000o = new O000000o((byte) 0);

    public static final eyc O000000o(Device device) {
        return O000000o.O000000o(device);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/DeviceRenderRouterFactory$Companion;", "", "()V", "KEY_DEVICE_RENDER", "", "getDeviceRenderProvider", "Lcom/xiaomi/smarthome/IDeviceRendererProvider;", "device", "Lcom/xiaomi/smarthome/device/Device;", "smarthome-mainpage-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/xiaomi/smarthome/DeviceRenderRouterFactory$Companion$getDeviceRenderProvider$1", "Lcom/sankuai/waimai/router/service/IFactory;", "create", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "smarthome-mainpage-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: _m_j.ext$O000000o$O000000o  reason: collision with other inner class name */
        public static final class C0106O000000o implements cyy {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Device f15932O000000o;

            C0106O000000o(Device device) {
                this.f15932O000000o = device;
            }

            public final <T> T O000000o(Class<T> cls) {
                ixe.O00000o(cls, "clazz");
                Method declaredMethod = cls.getDeclaredMethod("get", Device.class);
                ixe.O00000Oo(declaredMethod, "clazz.getDeclaredMethod(\"get\", Device::class.java)");
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, this.f15932O000000o);
            }
        }

        public static eyc O000000o(Device device) {
            ixe.O00000o(device, "device");
            eyc eyc = (eyc) cub.O000000o(eyc.class, "key_device_render", new C0106O000000o(device));
            return eyc == null ? eyj.f15948O000000o : eyc;
        }
    }
}
