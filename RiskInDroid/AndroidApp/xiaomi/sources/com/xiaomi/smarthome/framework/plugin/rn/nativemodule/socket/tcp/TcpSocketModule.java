package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.socket.tcp;

import _m_j.fyc;
import _m_j.fzd;
import _m_j.fze;
import _m_j.fzg;
import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.util.Base64;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TcpSocketModule extends ReactContextBaseJavaModule implements fzd.O000000o {
    public final O000000o currentNetwork = new O000000o((byte) 0);
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private final ConcurrentHashMap<String, Network> mNetworkMap = new ConcurrentHashMap<>();
    public final ReactApplicationContext mReactContext;
    public final ConcurrentHashMap<Integer, fze> socketClients = new ConcurrentHashMap<>();

    public String getName() {
        return "TcpSockets";
    }

    public TcpSocketModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    private void sendEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    @SuppressLint({"StaticFieldLeak"})
    @ReactMethod
    public void connect(Integer num, String str, Integer num2, ReadableMap readableMap) {
        final String str2 = str;
        final Integer num3 = num;
        final ReadableMap readableMap2 = readableMap;
        final Integer num4 = num2;
        this.executorService.execute(new Thread(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.socket.tcp.TcpSocketModule.AnonymousClass1 */

            public final void run() {
                if (!TcpSocketModule.this.isLocalAddress(str2)) {
                    fyc.O00000o("TcpSockets", String.format("invalid host:%s, only support local host.", str2));
                    TcpSocketModule.this.onError(num3, "TcpSocketsinvalid host, only support local host.");
                } else if (TcpSocketModule.this.socketClients.get(num3) != null) {
                    TcpSocketModule.this.onError(num3, "TcpSocketscreateSocket called twice with the same id.");
                } else {
                    try {
                        TcpSocketModule.this.selectNetwork(readableMap2.hasKey("interface") ? readableMap2.getString("interface") : null, readableMap2.hasKey("localAddress") ? readableMap2.getString("localAddress") : null);
                        fze fze = new fze(TcpSocketModule.this, num3, null);
                        TcpSocketModule.this.socketClients.put(num3, fze);
                        fze.O000000o(TcpSocketModule.this.mReactContext, str2, num4, readableMap2, TcpSocketModule.this.currentNetwork.f8392O000000o);
                        TcpSocketModule.this.onConnect(num3, str2, num4.intValue());
                    } catch (Exception e) {
                        TcpSocketModule.this.onError(num3, e.getMessage());
                    }
                }
            }
        }));
    }

    @SuppressLint({"StaticFieldLeak"})
    @ReactMethod
    public void write(final Integer num, final String str, final Callback callback) {
        this.executorService.execute(new Thread(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.socket.tcp.TcpSocketModule.AnonymousClass2 */

            public final void run() {
                fze fze = TcpSocketModule.this.socketClients.get(num);
                if (fze != null) {
                    try {
                        fze.O000000o(Base64.decode(str, 2));
                        if (callback != null) {
                            callback.invoke(new Object[0]);
                        }
                    } catch (IOException e) {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.invoke(e.toString());
                        }
                        TcpSocketModule.this.onError(num, e.toString());
                    }
                }
            }
        }));
    }

    @SuppressLint({"StaticFieldLeak"})
    @ReactMethod
    public void end(final Integer num) {
        this.executorService.execute(new Thread(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.socket.tcp.TcpSocketModule.AnonymousClass3 */

            public final void run() {
                fze fze = TcpSocketModule.this.socketClients.get(num);
                if (fze != null) {
                    fze.O00000o();
                    TcpSocketModule.this.socketClients.remove(num);
                }
            }
        }));
    }

    @ReactMethod
    public void destroy(Integer num) {
        end(num);
    }

    @SuppressLint({"StaticFieldLeak"})
    @ReactMethod
    public void listen(final Integer num, final ReadableMap readableMap) {
        this.executorService.execute(new Thread(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.socket.tcp.TcpSocketModule.AnonymousClass4 */

            public final void run() {
                try {
                    TcpSocketModule.this.socketClients.put(num, new fzg(TcpSocketModule.this.socketClients, TcpSocketModule.this, num, readableMap));
                    int i = readableMap.getInt("port");
                    String string = readableMap.getString("host");
                    if (!TcpSocketModule.this.isLocalAddress(string)) {
                        fyc.O00000o("TcpSockets", String.format("invalid host:%s, only support local host.", string));
                        TcpSocketModule.this.onError(num, "TcpSocketsinvalid host, only support local host.");
                        return;
                    }
                    TcpSocketModule.this.onConnect(num, string, i);
                } catch (Exception e) {
                    TcpSocketModule.this.onError(num, e.getMessage());
                }
            }
        }));
    }

    @ReactMethod
    public void setNoDelay(Integer num, boolean z) {
        fze fze = this.socketClients.get(num);
        if (fze == null) {
            onError(num, "TcpSocketssocket not found.");
            return;
        }
        try {
            fze.O000000o(z);
        } catch (IOException e) {
            onError(num, e.getMessage());
        }
    }

    @ReactMethod
    public void setKeepAlive(Integer num, boolean z, int i) {
        fze fze = this.socketClients.get(num);
        if (fze == null) {
            onError(num, "TcpSocketssocket not found.");
            return;
        }
        try {
            fze.O000000o(z, i);
        } catch (IOException e) {
            onError(num, e.getMessage());
        }
    }

    public boolean isLocalAddress(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName == null || byName.isSiteLocalAddress()) {
                return true;
            }
            return false;
        } catch (UnknownHostException e) {
            fyc.O000000o("TcpSockets", "isLocalAddress error:", e);
            return true;
        }
    }

    private void requestNetwork(int i) throws InterruptedException {
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addTransportType(i);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ((ConnectivityManager) this.mReactContext.getSystemService("connectivity")).requestNetwork(builder.build(), new ConnectivityManager.NetworkCallback() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.socket.tcp.TcpSocketModule.AnonymousClass5 */

            public final void onAvailable(Network network) {
                TcpSocketModule.this.currentNetwork.f8392O000000o = network;
                countDownLatch.countDown();
            }

            public final void onUnavailable() {
                countDownLatch.countDown();
            }
        });
        new ScheduledThreadPoolExecutor(1).schedule(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.socket.tcp.TcpSocketModule.AnonymousClass6 */

            public final void run() {
                countDownLatch.countDown();
            }
        }, 5, TimeUnit.SECONDS);
        countDownLatch.await();
    }

    public void selectNetwork(String str, String str2) throws InterruptedException, IOException {
        this.currentNetwork.f8392O000000o = null;
        if (str != null) {
            if (str2 != null) {
                ConcurrentHashMap<String, Network> concurrentHashMap = this.mNetworkMap;
                Network network = concurrentHashMap.get(str + str2);
                if (network != null) {
                    this.currentNetwork.f8392O000000o = network;
                    return;
                }
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1419358249) {
                if (hashCode != -916596374) {
                    if (hashCode == 3649301 && str.equals("wifi")) {
                        c = 0;
                    }
                } else if (str.equals("cellular")) {
                    c = 1;
                }
            } else if (str.equals("ethernet")) {
                c = 2;
            }
            if (c == 0) {
                requestNetwork(1);
            } else if (c == 1) {
                requestNetwork(0);
            } else if (c == 2) {
                requestNetwork(3);
            }
            if (this.currentNetwork.f8392O000000o == null) {
                throw new IOException("Interface " + str + " unreachable");
            } else if (str2 != null && !str2.equals("0.0.0.0")) {
                ConcurrentHashMap<String, Network> concurrentHashMap2 = this.mNetworkMap;
                concurrentHashMap2.put(str + str2, this.currentNetwork.f8392O000000o);
            }
        }
    }

    public void onConnect(Integer num, String str, int i) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", num.intValue());
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putString("address", str);
        createMap2.putInt("port", i);
        createMap.putMap("address", createMap2);
        sendEvent("connect", createMap);
    }

    public void onData(Integer num, byte[] bArr) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", num.intValue());
        createMap.putString("data", Base64.encodeToString(bArr, 2));
        sendEvent("data", createMap);
    }

    public void onClose(Integer num, String str) {
        if (str != null) {
            onError(num, str);
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", num.intValue());
        createMap.putBoolean("hadError", str != null);
        sendEvent("close", createMap);
    }

    public void onError(Integer num, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", num.intValue());
        createMap.putString("error", str);
        sendEvent("error", createMap);
    }

    public void onConnection(Integer num, Integer num2, InetSocketAddress inetSocketAddress) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", num.intValue());
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt("id", num2.intValue());
        InetAddress address = inetSocketAddress.getAddress();
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putString("address", address.getHostAddress());
        createMap3.putInt("port", inetSocketAddress.getPort());
        createMap3.putString("family", address instanceof Inet6Address ? "IPv6" : "IPv4");
        createMap2.putMap("address", createMap3);
        createMap.putMap("info", createMap2);
        sendEvent("connection", createMap);
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Network f8392O000000o;

        /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
            this.f8392O000000o = null;
        }
    }
}
