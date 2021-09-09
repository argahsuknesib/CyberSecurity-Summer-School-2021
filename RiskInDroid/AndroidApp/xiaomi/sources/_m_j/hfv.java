package _m_j;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"bindMiioRemoteDeviceIfNeed", "", "context", "Landroid/content/Context;", "cd", "Lcom/xiaomi/smarthome/device/Device;", "smarthome-mainpage_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class hfv {

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/MainGridViewHolderKt$bindMiioRemoteDeviceIfNeed$1", "Lcom/xiaomi/smarthome/device/IBindDeviceCallback;", "onCancel", "", "onFail", "onFailBindingNetworkError", "error", "", "onFailFetchTokenError", "onSuccess", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o implements fmo {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ Context f18877O000000o;

        O000000o(Context context) {
            this.f18877O000000o = context;
        }

        public final void O000000o() {
            ft.O000000o(this.f18877O000000o).O000000o(new Intent("force_update_data"));
        }

        public final void O00000Oo() {
            ft.O000000o(this.f18877O000000o).O000000o(new Intent("com.smarthome.refresh_list_view"));
        }
    }
}
