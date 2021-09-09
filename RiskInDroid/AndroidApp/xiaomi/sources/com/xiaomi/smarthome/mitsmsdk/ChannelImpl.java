package com.xiaomi.smarthome.mitsmsdk;

import android.content.Context;
import cn.com.xm.bt.profile.nfc.ApduResponse;
import cn.com.xm.bt.profile.nfc.HMNFCStatus;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.terminal.external.IChannel;

public class ChannelImpl implements IChannel {
    private Context mContext;

    public ChannelImpl(Context context) {
        this.mContext = context;
    }

    public void open() {
        LogUtils.v("ChannelImpl open()");
        HMNFCStatus openApduChannel = NfcChannelManager.getInstance().getHMBleDevice().openApduChannel();
        if (openApduChannel != null && openApduChannel.getStatus() != 0) {
            LogUtils.e("ChannelImpl open failed! status = ".concat(String.valueOf(openApduChannel)));
        }
    }

    public void close() {
        LogUtils.v("ChannelImpl close()");
        HMNFCStatus closeApduChannel = NfcChannelManager.getInstance().getHMBleDevice().closeApduChannel();
        if (closeApduChannel != null && closeApduChannel.getStatus() != 0) {
            LogUtils.e("ChannelImpl close failed! status = ".concat(String.valueOf(closeApduChannel)));
        }
    }

    public byte[] transceive(byte[] bArr) {
        ApduResponse sendApduData = NfcChannelManager.getInstance().getHMBleDevice().sendApduData(bArr, bArr.length, false);
        if (sendApduData != null) {
            return sendApduData.getData();
        }
        return new byte[0];
    }
}
