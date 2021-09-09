package com.xiaomi.smarthome.camera;

import _m_j.gpy;
import _m_j.grv;
import _m_j.ixc;
import _m_j.ixe;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/xiaomi/smarthome/camera/CameraBinderReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "camera-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CameraBinderReceiver extends BroadcastReceiver {
    public static final Companion Companion = new Companion(null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/camera/CameraBinderReceiver$Companion;", "", "()V", "TAG", "", "camera-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(ixc ixc) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onReceive(Context context, Intent intent) {
        String str = null;
        String stringExtra = intent == null ? null : intent.getStringExtra("extra_device_did");
        if (intent != null) {
            str = intent.getStringExtra("extra_device_model");
        }
        String O000000o2 = grv.O000000o(ixe.O000000o(str, (Object) stringExtra));
        if (gpy.O000000o(context, O000000o2, "SP_KEY_SAFE_PASSWORD", -1) == 1) {
            gpy.O00000Oo(context, O000000o2, "SP_KEY_SAFE_PASSWORD", -1);
        }
    }
}
