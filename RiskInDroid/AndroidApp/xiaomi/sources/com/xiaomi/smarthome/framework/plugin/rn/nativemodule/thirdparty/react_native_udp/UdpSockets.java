package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_udp;

import _m_j.gak;
import _m_j.gal;
import _m_j.gan;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

public final class UdpSockets extends ReactContextBaseJavaModule implements gan.O00000Oo, gan.O00000o0 {
    public SparseArray<gan> mClients = new SparseArray<>();
    public WifiManager.MulticastLock mMulticastLock;
    private boolean mShuttingDown = false;

    public final String getName() {
        return "UdpSockets";
    }

    public UdpSockets(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public final void initialize() {
        this.mShuttingDown = false;
    }

    public final void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
        try {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_udp.UdpSockets.AnonymousClass1 */

                public final /* synthetic */ void doInBackgroundGuarded(Object[] objArr) {
                    for (int i = 0; i < UdpSockets.this.mClients.size(); i++) {
                        try {
                            UdpSockets.this.mClients.valueAt(i).O000000o();
                        } catch (IOException e) {
                            FLog.e("UdpSockets", "exception when shutting down", e);
                        }
                    }
                    UdpSockets.this.mClients.clear();
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]).get();
        } catch (InterruptedException e) {
            FLog.e("UdpSockets", "onCatalystInstanceDestroy", e);
        } catch (ExecutionException e2) {
            FLog.e("UdpSockets", "onCatalystInstanceDestroy", e2);
        }
    }

    public final gan findClient(Integer num, Callback callback) {
        gan gan = this.mClients.get(num.intValue());
        if (gan == null) {
            if (callback == null) {
                FLog.e("UdpSockets", "missing callback parameter.");
            } else {
                callback.invoke(gak.O000000o("no client found with id ".concat(String.valueOf(num))), null);
            }
        }
        return gan;
    }

    @ReactMethod
    public final void createSocket(Integer num, ReadableMap readableMap) {
        if (num == null) {
            FLog.e("UdpSockets", "createSocket called with nil id parameter.");
        } else if (this.mClients.get(num.intValue()) != null) {
            FLog.e("UdpSockets", "createSocket called twice with the same id.");
        } else {
            this.mClients.put(num.intValue(), new gan(new gan.O000000o(this, this), (byte) 0));
        }
    }

    @ReactMethod
    public final void bind(Integer num, Integer num2, String str, ReadableMap readableMap, Callback callback) {
        final Integer num3 = num;
        final Callback callback2 = callback;
        final Integer num4 = num2;
        final String str2 = str;
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_udp.UdpSockets.AnonymousClass2 */

            public final /* synthetic */ void doInBackgroundGuarded(Object[] objArr) {
                InetSocketAddress inetSocketAddress;
                gan findClient = UdpSockets.this.findClient(num3, callback2);
                if (findClient != null) {
                    try {
                        Integer num = num4;
                        String str = str2;
                        findClient.O00000o0 = new MulticastSocket((SocketAddress) null);
                        findClient.O00000Oo = new gal();
                        if (str != null) {
                            inetSocketAddress = new InetSocketAddress(InetAddress.getByName(str), num.intValue());
                        } else {
                            inetSocketAddress = new InetSocketAddress(num.intValue());
                        }
                        findClient.O00000o0.setReuseAddress(findClient.f17465O000000o);
                        findClient.O00000o0.bind(inetSocketAddress);
                        findClient.O00000Oo.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Pair(findClient.O00000o0, findClient));
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("address", str2);
                        createMap.putInt("port", num4.intValue());
                        callback2.invoke(null, createMap);
                    } catch (SocketException e) {
                        callback2.invoke(gak.O000000o(e.getMessage()));
                    } catch (IllegalArgumentException e2) {
                        callback2.invoke(gak.O000000o(e2.getMessage()));
                    } catch (IOException e3) {
                        callback2.invoke(gak.O000000o(e3.getMessage()));
                    }
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public final void addMembership(final Integer num, final String str) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_udp.UdpSockets.AnonymousClass3 */

            public final /* synthetic */ void doInBackgroundGuarded(Object[] objArr) {
                gan findClient = UdpSockets.this.findClient(num, null);
                if (findClient != null) {
                    if (UdpSockets.this.mMulticastLock == null) {
                        UdpSockets.this.mMulticastLock = ((WifiManager) UdpSockets.this.getReactApplicationContext().getApplicationContext().getSystemService("wifi")).createMulticastLock("react-native-udp");
                        UdpSockets.this.mMulticastLock.setReferenceCounted(true);
                    }
                    try {
                        UdpSockets.this.mMulticastLock.acquire();
                        String str = str;
                        if (findClient.O00000o0 == null || !findClient.O00000o0.isBound()) {
                            throw new IllegalStateException("Socket is not bound.");
                        }
                        ((MulticastSocket) findClient.O00000o0).joinGroup(InetAddress.getByName(str));
                        findClient.O00000o = true;
                    } catch (IllegalStateException e) {
                        if (UdpSockets.this.mMulticastLock != null && UdpSockets.this.mMulticastLock.isHeld()) {
                            UdpSockets.this.mMulticastLock.release();
                        }
                        FLog.e("UdpSockets", "addMembership", e);
                    } catch (UnknownHostException e2) {
                        if (UdpSockets.this.mMulticastLock != null && UdpSockets.this.mMulticastLock.isHeld()) {
                            UdpSockets.this.mMulticastLock.release();
                        }
                        FLog.e("UdpSockets", "addMembership", e2);
                    } catch (IOException e3) {
                        if (UdpSockets.this.mMulticastLock != null && UdpSockets.this.mMulticastLock.isHeld()) {
                            UdpSockets.this.mMulticastLock.release();
                        }
                        FLog.e("UdpSockets", "addMembership", e3);
                    }
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public final void dropMembership(final Integer num, final String str) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_udp.UdpSockets.AnonymousClass4 */

            public final /* synthetic */ void doInBackgroundGuarded(Object[] objArr) {
                gan findClient = UdpSockets.this.findClient(num, null);
                if (findClient != null) {
                    try {
                        ((MulticastSocket) findClient.O00000o0).leaveGroup(InetAddress.getByName(str));
                        findClient.O00000o = false;
                        if (UdpSockets.this.mMulticastLock == null || !UdpSockets.this.mMulticastLock.isHeld()) {
                            return;
                        }
                    } catch (IOException e) {
                        FLog.e("UdpSockets", "dropMembership", e);
                        if (UdpSockets.this.mMulticastLock == null || !UdpSockets.this.mMulticastLock.isHeld()) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (UdpSockets.this.mMulticastLock != null && UdpSockets.this.mMulticastLock.isHeld()) {
                            UdpSockets.this.mMulticastLock.release();
                        }
                        throw th;
                    }
                    UdpSockets.this.mMulticastLock.release();
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public final void send(Integer num, String str, Integer num2, String str2, Callback callback) {
        final Integer num3 = num;
        final Callback callback2 = callback;
        final String str3 = str;
        final Integer num4 = num2;
        final String str4 = str2;
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_udp.UdpSockets.AnonymousClass5 */

            public final /* synthetic */ void doInBackgroundGuarded(Object[] objArr) {
                gan findClient = UdpSockets.this.findClient(num3, callback2);
                if (findClient != null) {
                    try {
                        findClient.O000000o(str3, num4, str4, callback2);
                    } catch (IllegalStateException e) {
                        callback2.invoke(gak.O000000o(e.getMessage()));
                    } catch (UnknownHostException e2) {
                        callback2.invoke(gak.O000000o(e2.getMessage()));
                    } catch (IOException e3) {
                        callback2.invoke(gak.O000000o(e3.getMessage()));
                    }
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public final void close(final Integer num, final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_udp.UdpSockets.AnonymousClass6 */

            public final /* synthetic */ void doInBackgroundGuarded(Object[] objArr) {
                gan findClient = UdpSockets.this.findClient(num, callback);
                if (findClient != null) {
                    if (UdpSockets.this.mMulticastLock != null && UdpSockets.this.mMulticastLock.isHeld() && findClient.O00000o) {
                        UdpSockets.this.mMulticastLock.release();
                    }
                    try {
                        findClient.O000000o();
                        callback.invoke(new Object[0]);
                    } catch (IOException e) {
                        callback.invoke(gak.O000000o(e.getMessage()));
                    }
                    UdpSockets.this.mClients.remove(num.intValue());
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public final void setBroadcast(Integer num, Boolean bool, Callback callback) {
        final Integer num2 = num;
        final Callback callback2 = callback;
        final Boolean bool2 = bool;
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_udp.UdpSockets.AnonymousClass7 */

            public final /* synthetic */ void doInBackgroundGuarded(Object[] objArr) {
                gan findClient = UdpSockets.this.findClient(num2, callback2);
                if (findClient != null) {
                    try {
                        boolean booleanValue = bool2.booleanValue();
                        if (findClient.O00000o0 != null) {
                            findClient.O00000o0.setBroadcast(booleanValue);
                        }
                        callback2.invoke(new Object[0]);
                    } catch (SocketException e) {
                        callback2.invoke(gak.O000000o(e.getMessage()));
                    }
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void didReceiveData(gan gan, String str, String str2, int i) {
        final gan gan2 = gan;
        final String str3 = str;
        final String str4 = str2;
        final int i2 = i;
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_udp.UdpSockets.AnonymousClass8 */

            public final /* synthetic */ void doInBackgroundGuarded(Object[] objArr) {
                int i = -1;
                for (int i2 = 0; i2 < UdpSockets.this.mClients.size(); i2++) {
                    i = UdpSockets.this.mClients.keyAt(i2);
                    if (gan2.equals(UdpSockets.this.mClients.get(i))) {
                        break;
                    }
                }
                if (i != -1) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("data", str3);
                    createMap.putString("address", str4);
                    createMap.putInt("port", i2);
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) UdpSockets.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("udp-" + i + "-data", createMap);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void didReceiveError(gan gan, String str) {
        FLog.e("UdpSockets", str);
    }

    public final void didReceiveException(RuntimeException runtimeException) {
        getReactApplicationContext().handleException(runtimeException);
    }
}
