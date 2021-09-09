package com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth;

import _m_j.fec;
import _m_j.fir;
import _m_j.fiw;
import _m_j.fte;
import _m_j.gmc;
import _m_j.got;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;

public class BleStandardAuthRegisterConnector$14 implements IBleResponse {
    final /* synthetic */ fiw this$0;
    final /* synthetic */ byte[] val$devRandom;

    public IBinder asBinder() {
        return null;
    }

    public BleStandardAuthRegisterConnector$14(fiw fiw, byte[] bArr) {
        this.this$0 = fiw;
        this.val$devRandom = bArr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fiw.O000000o(boolean, com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void
     arg types: [int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthRegisterConnector$14$1]
     candidates:
      _m_j.fiw.O000000o(byte[], byte[]):byte[]
      _m_j.fiw.O000000o(byte[], int):void
      _m_j.fiw.O000000o(byte[], com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void
      _m_j.fis.O000000o(byte[], int):void
      _m_j.fgm.O000000o(int, boolean):void
      _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
      _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
      _m_j.fiw.O000000o(boolean, com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fiw.O000000o(boolean, com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void
     arg types: [int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthRegisterConnector$14$2]
     candidates:
      _m_j.fiw.O000000o(byte[], byte[]):byte[]
      _m_j.fiw.O000000o(byte[], int):void
      _m_j.fiw.O000000o(byte[], com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void
      _m_j.fis.O000000o(byte[], int):void
      _m_j.fgm.O000000o(int, boolean):void
      _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
      _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
      _m_j.fiw.O000000o(boolean, com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse):void */
    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleStandardAuthRegisterConnector recvDevRandom onResponse: " + gmc.O000000o(i));
        if (i != 0) {
            fec.O00000o().O000000o(20, 2);
            this.this$0.O000000o(-28);
        } else if (got.O00000o(this.this$0.O0000o00)) {
            fec.O00000o().O000000o(20, "msg", "oob is empty");
            fec.O00000o().O000000o(20, 2);
            fte.O00000Oo("BleStandardAuthRegisterConnector recvDevRandom mOOB is empty");
            this.this$0.O000000o(false, (BleWriteResponse) new BleWriteResponse() {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthRegisterConnector$14.AnonymousClass1 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    BleStandardAuthRegisterConnector$14.this.this$0.O000000o(-49);
                }
            });
        } else {
            byte[] bArr = new byte[32];
            System.arraycopy(this.val$devRandom, 0, bArr, 0, 16);
            System.arraycopy(this.this$0.O0000o00, 0, bArr, 16, 16);
            if (got.O000000o(this.this$0.O0000o0, fir.O000000o(this.this$0.O0000Ooo.getEncoded(), bArr))) {
                fec.O00000o().O00000Oo(20);
                this.this$0.O0000o0();
                return;
            }
            fec.O00000o().O000000o(20, "msg", "dev confirm not match");
            fec.O00000o().O000000o(20, 2);
            this.this$0.O000000o(false, (BleWriteResponse) new BleWriteResponse() {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth.BleStandardAuthRegisterConnector$14.AnonymousClass2 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    BleStandardAuthRegisterConnector$14.this.this$0.O000000o(-49);
                }
            });
        }
    }
}
