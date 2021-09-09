package com.libra.sinvoice;

import android.content.Context;

public class VoiceEncoder {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f4505O000000o;

    public interface O000000o {
    }

    public native void create(Context context, String str, String str2);

    public native void destroy();

    public native void send(byte[] bArr);

    public native void setEffect(int i);

    public native void start(int i);

    public native void stop();

    public VoiceEncoder(O000000o o000000o) {
        this.f4505O000000o = o000000o;
    }
}
