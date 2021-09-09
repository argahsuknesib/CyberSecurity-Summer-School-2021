package com.libra.sinvoice;

import android.content.Context;

public class VoiceDecoder {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f4504O000000o;
    private long O00000Oo = 0;

    public interface O000000o {
    }

    public native void create(Context context, String str, String str2);

    public native void destroy();

    public native void putData(byte[] bArr, int i);

    public native void setEffect(int i);

    public native void start();

    public native void stop();

    public VoiceDecoder(O000000o o000000o) {
        this.f4504O000000o = o000000o;
    }
}
