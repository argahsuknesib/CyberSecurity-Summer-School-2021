package com.xiaomi.smarthome.network;

import _m_j.fdh;
import _m_j.fdi;
import _m_j.fdp;
import _m_j.fdq;
import _m_j.fds;
import _m_j.fdt;
import _m_j.gzp;
import android.os.IBinder;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.server.CoreAsyncTask;

public class SmartHomeRequestManager$5 extends CoreAsyncTask {
    fdi mNetHandle;
    final /* synthetic */ gzp this$0;
    final /* synthetic */ Crypto val$crypto;
    final /* synthetic */ fdh val$netCallback;
    final /* synthetic */ NetRequest val$request;

    public IBinder asBinder() {
        return null;
    }

    public SmartHomeRequestManager$5(gzp gzp, Crypto crypto, NetRequest netRequest, fdh fdh) {
        this.this$0 = gzp;
        this.val$crypto = crypto;
        this.val$request = netRequest;
        this.val$netCallback = fdh;
    }

    public void onCancel() {
        fdi fdi = this.mNetHandle;
        if (fdi != null) {
            fdi.O000000o();
        }
    }

    public void run() {
        if (this.val$crypto == Crypto.RC4) {
            this.mNetHandle = fdt.O000000o().O000000o(this.val$request, this.val$netCallback);
        } else if (this.val$crypto == Crypto.NONE) {
            this.mNetHandle = fds.O000000o().O000000o(this.val$request, this.val$netCallback);
        } else if (this.val$crypto == Crypto.AES) {
            this.mNetHandle = fdp.O000000o().O000000o(this.val$request, this.val$netCallback);
        } else if (this.val$crypto == Crypto.HTTPS) {
            this.mNetHandle = fdq.O000000o().O000000o(this.val$request, this.val$netCallback);
        } else {
            this.val$netCallback.onFailure(new NetError(-9999, "crypto not support"));
        }
    }
}
