package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fhc;
import android.os.IBinder;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleMeshRegisterConnector$6 implements IBleResponse {
    final /* synthetic */ fhc this$0;

    public IBinder asBinder() {
        return null;
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: _m_j.grs.O000000o(java.lang.String, int):byte[] in method: com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleMeshRegisterConnector$6.onResponse(int, android.os.Bundle):void, dex: classes5.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: _m_j.grs.O000000o(java.lang.String, int):byte[]
        	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
        	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:528)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	... 5 more
        */
    public void onResponse(int r1, android.os.Bundle r2) {
        /*
            r5 = this;
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "BleMeshRegisterConnector Step 4 onResponse: "
            r7.<init>(r0)
            java.lang.String r0 = _m_j.gmc.O000000o(r6)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            _m_j.fte.O00000Oo(r7)
            r7 = -28
            r0 = 2
            r1 = 27
            if (r6 != 0) goto L_0x004e
            _m_j.hmh r6 = _m_j.fec.O00000o()
            r6.O00000Oo(r1)
            _m_j.fhc r6 = r5.this$0
            _m_j.hmh r1 = _m_j.fec.O00000o()
            r2 = 28
            r1.O000000o(r2)
            java.lang.String r1 = r6.O0000o0O
            r3 = 24
            byte[] r1 = _m_j.grs.O000000o(r1, r3)
            r3 = 8
            com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleMeshRegisterConnector$7 r4 = new com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleMeshRegisterConnector$7
            r4.<init>(r6)
            boolean r1 = r6.O000000o(r1, r3, r4)
            if (r1 != 0) goto L_0x004d
            _m_j.hmh r1 = _m_j.fec.O00000o()
            r1.O000000o(r2, r0)
            r6.O000000o(r7)
        L_0x004d:
            return
        L_0x004e:
            _m_j.hmh r2 = _m_j.fec.O00000o()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r3 = "error_code"
            r2.O000000o(r1, r3, r6)
            _m_j.hmh r6 = _m_j.fec.O00000o()
            r6.O000000o(r1, r0)
            _m_j.fhc r6 = r5.this$0
            r6.O000000o(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleMeshRegisterConnector$6.onResponse(int, android.os.Bundle):void");
    }

    BleMeshRegisterConnector$6(fhc fhc) {
        this.this$0 = fhc;
    }
}
