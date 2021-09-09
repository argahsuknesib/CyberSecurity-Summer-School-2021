package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.BleSecureConnectManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleSecurityChipRegister$4$1$1$1;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleSecurityChipRegister$5;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.ArrayList;
import java.util.UUID;

public final class fhi extends fgn {
    public IBleChannelWriter O0000Oo;
    public Handler O0000Oo0;
    public IBleChannelReader O0000OoO = new BleSecurityChipRegister$5(this);
    O000000o O0000Ooo;
    private fhj O0000o00;

    public fhi(String str, int i, BleConnectOptions bleConnectOptions) {
        super(str, i, bleConnectOptions);
        this.O0000o00 = new fhj(this.O0000OOo, bleConnectOptions);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.O0000Oo0 = new Handler(myLooper);
        }
    }

    public final fgm O00000o0() {
        return this.O0000o00;
    }

    public final void O000000o(final int i, Bundle bundle) {
        if (i == 0) {
            byte[] byteArray = bundle.getByteArray("ltmk");
            byte[] byteArray2 = bundle.getByteArray("key_token");
            ffr.O00000o(this.O00000Oo, 2);
            ffr.O00000oO(this.O00000Oo, this.O0000o00.O0000o0O());
            ffr.O00000Oo(this.O00000Oo, byteArray2);
            ffr.O00000o0(this.O00000Oo, byteArray);
            this.O0000o00.O000000o(this.O00000Oo, this.O0000o00.O0000o0O(), new feo<Void, fes>() {
                /* class _m_j.fhi.AnonymousClass1 */

                public final void O000000o(fes fes) {
                    fhi.this.O00000o0(i);
                }

                public final /* synthetic */ void O000000o(Object obj) {
                    fhi.this.O00000o0(i);
                }
            });
            return;
        }
        O00000Oo(i);
    }

    public final void O000000o(int i) {
        if (i != 0 && ffr.O0000o0(this.O00000Oo) == 2 && !TextUtils.isEmpty(this.O0000o00.O0000o0O())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.O0000o00.O0000o0O());
            fec.O00000o0().O000000o(arrayList, new fep() {
                /* class _m_j.fhi.AnonymousClass2 */

                public final void O000000o() {
                    ffr.O00000o(fhi.this.O00000Oo, 0);
                }
            });
        }
    }

    public final void O00000o0(final int i) {
        if (this.O00000o.O00000oo != null) {
            BleSecureConnectManager.O000000o(this.O00000Oo);
            this.O0000o00.O000000o();
            Handler handler = this.O0000Oo0;
            if (handler != null) {
                handler.postDelayed(new Runnable() {
                    /* class _m_j.fhi.AnonymousClass3 */

                    public final void run() {
                        fhi.this.O000000o(new Response.BleResponse() {
                            /* class _m_j.fhi.AnonymousClass3.AnonymousClass1 */

                            public final void onResponse(int i, Object obj) {
                                fhi fhi = fhi.this;
                                if (fhi.O0000Ooo != null) {
                                    gnl.O000000o(fhi.O0000Ooo);
                                    fhi.O0000Ooo = null;
                                }
                                few.O00000Oo().O000000o(fhi.this.O00000Oo, fhi.this.O0000OoO);
                                fhi.this.O000000o("action.ble.bind", 0);
                                fhi.this.O00000Oo(i);
                                glw.O000000o().disconnect(fhi.this.O00000Oo);
                            }
                        }, 1);
                    }
                }, 3000);
                return;
            }
            return;
        }
        O000000o("action.ble.bind", 0);
        O00000Oo(i);
        this.O0000o00.O000000o();
    }

    public final void O000000o(final Response.BleResponse bleResponse, final int i) {
        SecureConnectOptions.O000000o o000000o = new SecureConnectOptions.O000000o();
        o000000o.f6884O000000o = this.O00000o;
        SecureConnectOptions O000000o2 = o000000o.O000000o();
        fte.O00000Oo(" securityChipConnect start retryTime = ".concat(String.valueOf(i)));
        BleSecureConnectManager.O00000Oo(this.O00000Oo, O000000o2, new gle() {
            /* class _m_j.fhi.AnonymousClass4 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                fte.O00000Oo(" securityChipConnect onResponse: " + XmBluetoothManager.Code.toString(i));
                if (i == 0) {
                    fhi.this.O0000Oo = few.O00000Oo().O00000Oo(fhi.this.O00000Oo, fhi.this.O0000OoO);
                    fhi fhi = fhi.this;
                    if (fhi.O0000Ooo == null) {
                        fhi.O0000Ooo = new O000000o(fhi, (byte) 0);
                        gnl.O000000o(fhi.O0000Ooo, new IntentFilter("com.xiaomi.smarthome.bluetooth.character_changed"));
                    }
                    glw.O000000o().writeNoRsp(fhi.this.O00000Oo, glb.f17954O000000o, glb.O0000OOo, new byte[]{-91}, new BleWriteResponse() {
                        /* class _m_j.fhi.AnonymousClass4.AnonymousClass1 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            if (i == 0) {
                                BleComboWifiConfig bleComboWifiConfig = fhi.this.O00000o.O00000oo;
                                bleComboWifiConfig.O0000OoO = ffr.O0000o0O(fhi.this.O00000Oo);
                                fhe.O000000o(fhi.this.O00000Oo, bleComboWifiConfig.O000000o(), new BleReadResponse() {
                                    /* class _m_j.fhi.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                    public final /* synthetic */ void onResponse(int i, Object obj) {
                                        byte[] bArr = (byte[]) obj;
                                        fte.O00000Oo(" BleSecurityChipEncrypt encrypt code: ".concat(String.valueOf(i)));
                                        if (i != 0) {
                                            fte.O00000Oo(" BleSecurityChipEncrypt encrypt wifi config failed!");
                                            bleResponse.onResponse(-28, null);
                                        } else if (!fhi.this.O000000o(bArr, new BleSecurityChipRegister$4$1$1$1(this))) {
                                            fte.O00000Oo(" BleSecurityChipEncrypt write failed!");
                                            bleResponse.onResponse(-28, null);
                                        }
                                    }
                                });
                                return;
                            }
                            bleResponse.onResponse(-28, null);
                        }
                    });
                } else if (i != -6 || i <= 0) {
                    bleResponse.onResponse(-28, null);
                } else if (fhi.this.O0000Oo0 != null) {
                    glw.O000000o().disconnectAllDevices();
                    fhi.this.O0000Oo0.postDelayed(new Runnable() {
                        /* class _m_j.fhi.AnonymousClass4.AnonymousClass2 */

                        public final void run() {
                            fhi.this.O000000o(bleResponse, i - 1);
                        }
                    }, 3000);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(byte[] bArr, IBleResponse iBleResponse) {
        try {
            if (this.O0000Oo != null) {
                this.O0000Oo.write(bArr, 15, iBleResponse);
                return true;
            }
            fte.O00000Oo(" channel writer is null,so can not write");
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(fhi fhi, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            ChannelManager.O000000o O00000oO;
            if (intent != null) {
                String action = intent.getAction();
                fte.O00000Oo("get mReceiver action： ".concat(String.valueOf(action)));
                if (!"com.xiaomi.smarthome.bluetooth.character_changed".equalsIgnoreCase(action)) {
                    return;
                }
                if (fhi.this.O00000Oo.equalsIgnoreCase(intent.getStringExtra("key_device_address"))) {
                    UUID uuid = (UUID) intent.getSerializableExtra("key_service_uuid");
                    UUID uuid2 = (UUID) intent.getSerializableExtra("key_character_uuid");
                    byte[] byteArrayExtra = intent.getByteArrayExtra("key_character_value");
                    if (uuid != null && uuid2 != null) {
                        fhi fhi = fhi.this;
                        if (glb.f17954O000000o.equals(uuid) && glb.O0000o0.equals(uuid2) && (O00000oO = few.O00000Oo().O00000oO(fhi.O00000Oo)) != null) {
                            O00000oO.O000000o(byteArrayExtra);
                        }
                    }
                }
            }
        }
    }

    public final void O000000o(gle gle) {
        fec.O00000o().O000000o(3);
        super.O000000o(gle);
    }
}
