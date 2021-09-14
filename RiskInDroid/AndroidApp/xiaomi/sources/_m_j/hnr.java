package _m_j;

import android.content.Intent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.scene.api.SceneApi;

public class hnr extends hnm implements hoz {
    public final int O000000o() {
        return R.string.smarthome_scene_create_auto_device;
    }

    public final int O000000o(int i) {
        return 0;
    }

    public final int O000000o(SceneApi.Action action, Object obj) {
        return 0;
    }

    public final int O000000o(String str, Object obj) {
        return 0;
    }

    public final SceneApi.Action O000000o(String str, int i, Object obj, Intent intent) {
        return null;
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: com.xiaomi.smarthome.application.ServiceApplication.getAppContext():android.content.Context in method: _m_j.hnr.O000000o(java.lang.Object):java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: com.xiaomi.smarthome.application.ServiceApplication.getAppContext():android.content.Context
        	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
        	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:528)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	... 5 more
        */
    public final java.lang.String O000000o(java.lang.Object r1) {
        /*
            r1 = this;
            android.content.Context r2 = com.xiaomi.smarthome.application.ServiceApplication.getAppContext()
            r0 = 2132678066(0x7f1e15b2, float:2.1013067E38)
            java.lang.String r2 = r2.getString(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.hnr.O000000o(java.lang.Object):java.lang.String");
    }
}
