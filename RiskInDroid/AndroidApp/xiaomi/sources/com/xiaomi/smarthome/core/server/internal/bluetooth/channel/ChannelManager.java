package com.xiaomi.smarthome.core.server.internal.bluetooth.channel;

import _m_j.fev;
import _m_j.ffr;
import _m_j.glb;
import _m_j.glc;
import _m_j.glg;
import _m_j.glh;
import _m_j.glw;
import _m_j.gnk;
import _m_j.gnl;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleRequestMtuResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class ChannelManager {

    /* renamed from: O000000o  reason: collision with root package name */
    public static ConcurrentMap<String, Integer> f6800O000000o = new ConcurrentHashMap();
    public static ConcurrentMap<String, Integer> O00000Oo = new ConcurrentHashMap();
    public static ConcurrentMap<String, Boolean> O00000o0 = new ConcurrentHashMap();
    private static String O00000oO = null;
    private ConcurrentMap<String, O000000o> O00000o = new ConcurrentHashMap();
    private BroadcastReceiver O00000oo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            gnk.O00000o("channel manager receive action=".concat(String.valueOf(action)));
            if (TextUtils.equals(action, "com.xiaomi.smarthome.bluetooth.connect_status_changed")) {
                String stringExtra = intent.getStringExtra("key_device_address");
                if (intent.getIntExtra("key_connect_status", 5) == 32) {
                    ChannelManager.O00000o0.put(stringExtra, Boolean.FALSE);
                    ChannelManager.O000000o(stringExtra);
                    ChannelManager.O000000o(stringExtra, 23);
                    gnk.O000000o("channel manager receive device mac=%s, disconnected", stringExtra);
                    ChannelManager.O00000Oo(stringExtra);
                    ffr.O0000o(stringExtra, null);
                }
            }
        }
    };

    public static abstract class BleChannelReader extends IBleChannelReader.Stub {
    }

    public abstract void O000000o(String str, List<byte[]> list, glh glh);

    public abstract void O000000o(String str, byte[] bArr, glh glh, boolean z);

    public abstract boolean O000000o();

    protected ChannelManager() {
        gnl.O000000o(this.O00000oo, new IntentFilter("com.xiaomi.smarthome.bluetooth.connect_status_changed"));
    }

    public static void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            O00000Oo.remove(str);
            f6800O000000o.remove(str);
        }
    }

    public static void O00000Oo(String str) {
        O000000o O00000oO2 = fev.O00000Oo().O00000oO(str);
        if (O00000oO2 != null) {
            O00000oO2.O00000oo();
        }
    }

    public static void O000000o(String str, int i) {
        String str2 = str + ":" + i;
        if (TextUtils.isEmpty(O00000oO) || !str2.equals(O00000oO)) {
            O00000oO = str2;
            String O00000oo2 = ffr.O00000oo(str);
            Intent intent = new Intent("com.xiaomi.deviceStatusChanged");
            intent.putExtra("did", O00000oo2);
            Bundle bundle = new Bundle();
            bundle.putInt("mtu", i);
            intent.putExtra("deviceStatus", bundle);
            glc.O0000O0o.sendBroadcast(intent);
        }
    }

    public final void O00000o0(String str) {
        Integer num = f6800O000000o.get(str);
        Boolean bool = O00000o0.get(str);
        if (num != null) {
            return;
        }
        if (bool == null || !bool.booleanValue()) {
            O00000o0.put(str, Boolean.TRUE);
            gnk.O000000o("channel manager receive device mac=%s, connected,send request mtu ", str);
            glw.O000000o().requestMtu(str, 247, new BleRequestMtuResponse(str, 247, null) {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f6802O000000o;
                final /* synthetic */ int O00000Oo = 247;
                final /* synthetic */ BleRequestMtuResponse O00000o0 = null;

                {
                    this.f6802O000000o = r2;
                }

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    Integer num = (Integer) obj;
                    gnk.O00000o("request mtu ,mac =" + this.f6802O000000o + ",mtu=" + this.O00000Oo + ",resp code =" + i + ",data=" + num);
                    if (i != 0 || num == null) {
                        ChannelManager.f6800O000000o.put(this.f6802O000000o, 23);
                        BleRequestMtuResponse bleRequestMtuResponse = this.O00000o0;
                        if (bleRequestMtuResponse != null) {
                            bleRequestMtuResponse.onResponse(0, null);
                            return;
                        }
                        return;
                    }
                    ChannelManager.f6800O000000o.put(this.f6802O000000o, num);
                    ChannelManager.O000000o(this.f6802O000000o, num.intValue());
                    ChannelManager channelManager = ChannelManager.this;
                    String str = this.f6802O000000o;
                    gnk.O000000o("channel manager receive device mac=%s, connected,send A4 again", str);
                    glw.O000000o().write(str, glb.f17954O000000o, glb.O0000OOo, new byte[]{-92}, new BleWriteResponse(str) {
                        /* class com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ String f6803O000000o;

                        {
                            this.f6803O000000o = r2;
                        }

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            gnk.O000000o("ChannelManager write 0xA4 ,mac = %s,response code =%d", this.f6803O000000o, Integer.valueOf(i));
                        }
                    });
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        return;
     */
    public final synchronized void O000000o(String str, IBleChannelReader iBleChannelReader) {
        O000000o o000000o = this.O00000o.get(str);
        if (o000000o != null) {
            if (iBleChannelReader != null) {
                o000000o.O00000Oo.remove(iBleChannelReader);
            }
        }
    }

    public synchronized IBleChannelWriter O00000Oo(String str, IBleChannelReader iBleChannelReader) {
        O000000o o000000o;
        gnk.O00000o0(String.format("registerChannelReader mac =%s ", str));
        o000000o = this.O00000o.get(str);
        if (o000000o == null) {
            o000000o = new O000000o(str, this, O000000o());
            this.O00000o.put(str, o000000o);
        }
        o000000o.O000000o(iBleChannelReader);
        return o000000o.f6806O000000o;
    }

    public final synchronized IBleChannelWriter O00000o0(String str, IBleChannelReader iBleChannelReader) {
        O000000o o000000o;
        gnk.O00000o0(String.format("registerChannelReader mac =%s ", str));
        o000000o = this.O00000o.get(str);
        if (o000000o == null) {
            o000000o = new O000000o(str, this, O000000o());
            this.O00000o.put(str, o000000o);
        }
        o000000o.O000000o(iBleChannelReader);
        return o000000o.f6806O000000o;
    }

    public final synchronized IBleChannelWriter O00000o(String str) {
        O000000o o000000o = this.O00000o.get(str);
        if (o000000o == null) {
            return null;
        }
        return o000000o.f6806O000000o;
    }

    public final synchronized O000000o O00000oO(String str) {
        return this.O00000o.get(str);
    }

    public static class O000000o extends glg {

        /* renamed from: O000000o  reason: collision with root package name */
        public IBleChannelWriter f6806O000000o = new ChannelManager$BleChannel$1(this);
        List<IBleChannelReader> O00000Oo = new ArrayList();
        private String O0000Oo;
        private ChannelManager O0000OoO;
        private boolean O0000Ooo;

        O000000o(String str, ChannelManager channelManager, boolean z) {
            this.O0000Oo = str;
            this.O0000OoO = channelManager;
            this.O0000Ooo = z;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(IBleChannelReader iBleChannelReader) {
            if (iBleChannelReader != null) {
                Iterator<IBleChannelReader> it = this.O00000Oo.iterator();
                while (it.hasNext()) {
                    IBleChannelReader next = it.next();
                    if (next != null && next.asBinder() != null && next.asBinder().equals(iBleChannelReader.asBinder())) {
                        return;
                    }
                    if (next == null || next.asBinder() == null) {
                        it.remove();
                    }
                }
                this.O00000Oo.add(iBleChannelReader);
            }
        }

        public final void O000000o(byte[] bArr, glh glh, boolean z) {
            this.O0000OoO.O000000o(this.O0000Oo, bArr, glh, z);
        }

        public final void O000000o(List<byte[]> list, glh glh) {
            this.O0000OoO.O000000o(this.O0000Oo, list, glh);
        }

        public final void O000000o(byte[] bArr, int i) {
            for (IBleChannelReader next : this.O00000Oo) {
                if (next != null) {
                    try {
                        next.onRead(this.O0000Oo, bArr, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public final boolean O000000o() {
            return this.O0000Ooo;
        }

        public final int O00000Oo() {
            Integer num = ChannelManager.f6800O000000o.get(this.O0000Oo);
            if (num == null || num.intValue() < 5) {
                return 18;
            }
            return num.intValue() - 5;
        }

        public final int O00000o0() {
            Integer num = ChannelManager.O00000Oo.get(this.O0000Oo);
            if (num == null || num.intValue() < 5) {
                return 18;
            }
            return num.intValue();
        }

        public final void O000000o(int i) {
            ChannelManager.O00000Oo.put(this.O0000Oo, Integer.valueOf(i));
        }

        public final int O00000o() {
            return O00000o0() == 18 ? 1 : 6;
        }
    }
}
