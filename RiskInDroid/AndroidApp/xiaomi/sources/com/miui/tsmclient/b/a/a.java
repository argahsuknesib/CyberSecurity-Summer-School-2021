package com.miui.tsmclient.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.miui.tsmclient.util.CardEnvironmentConfig;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.exception.NfcEeIOException;
import com.tsmclient.smartcard.terminal.APDUConstants;
import com.tsmclient.smartcard.terminal.BaseTerminal;
import com.tsmclient.smartcard.terminal.TerminalType;
import com.tsmclient.smartcard.terminal.external.IApduExecutor;
import com.tsmclient.smartcard.terminal.external.IChannel;
import com.tsmclient.smartcard.terminal.response.ScResponse;
import java.io.IOException;

public class a extends BaseTerminal {
    private static IChannel b;
    private static IApduExecutor c;

    /* renamed from: a  reason: collision with root package name */
    private IChannel f3585a;

    public a(Context context, String str) {
        super(context);
        this.mTerminalCategory = str;
        this.mTerminalType = TerminalType.PERIPHERAL;
    }

    public static void a(IApduExecutor iApduExecutor) {
        c = iApduExecutor;
    }

    public static void a(IChannel iChannel) {
        b = iChannel;
    }

    private IChannel c() throws IOException {
        Object obj;
        if (TextUtils.isEmpty(this.mTerminalCategory)) {
            Log.d("NfcEETerminal", "terminal category is null");
            return null;
        }
        try {
            obj = Class.forName(this.mTerminalCategory + ".mitsmsdk.ChannelImpl").getConstructor(Context.class).newInstance(this.mContext.getApplicationContext());
        } catch (Exception e) {
            Log.e("NfcEETerminal", "createChannel failed", e);
            obj = null;
        }
        if (obj instanceof IChannel) {
            return (IChannel) obj;
        }
        return null;
    }

    public IChannel a() {
        return this.f3585a;
    }

    public IApduExecutor b() {
        return c;
    }

    public void checkNfcEEStatus() throws IOException, InterruptedException {
        try {
            open();
            if (ByteArray.equals(transmit(APDUConstants.SELECT_CRS).getStatus(), ScResponse.STATUS_SE_RESTRICT)) {
                throw new NfcEeIOException("nfc ee has been restricted", 5);
            }
        } finally {
            close();
        }
    }

    public String getPrefKey(String str) {
        return str + CardEnvironmentConfig.getDeviceInfo().getDeviceId(this.mContext);
    }

    public String getSignedSpiPK() throws IOException, InterruptedException {
        throw new RuntimeException("getSignedSpiPK is not supported.");
    }

    public void internalClose() {
        IChannel iChannel = this.f3585a;
        if (iChannel != null) {
            try {
                iChannel.close();
            } catch (IOException unused) {
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
            this.f3585a = null;
        }
    }

    public void internalConnect() throws IOException, InterruptedException {
        if (this.f3585a != null) {
            throw new NfcEeIOException("nfc ee is open, close it first", 3);
        } else if (this.mContext != null) {
            this.f3585a = b;
            if (this.f3585a == null) {
                this.f3585a = c();
            }
            IChannel iChannel = this.f3585a;
            if (iChannel != null) {
                try {
                    iChannel.open();
                } catch (IOException unused) {
                    throw new NfcEeIOException("nfc was dead or nfc ee occurred an unknown error", 4);
                }
            } else {
                throw new NfcEeIOException("nfc is unavailable on this device", 1);
            }
        } else {
            throw new IOException("context is null!");
        }
    }

    public synchronized byte[] internalTransmit(byte[] bArr) throws IOException, InterruptedException {
        if (isInterruptible()) {
            Thread.sleep(1);
        }
        return this.f3585a.transceive(bArr);
    }
}
