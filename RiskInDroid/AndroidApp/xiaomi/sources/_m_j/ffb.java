package _m_j;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public abstract class ffb {

    /* renamed from: O000000o  reason: collision with root package name */
    public BluetoothDevice f16208O000000o = null;
    public final BluetoothAdapter O00000Oo;
    public O000000o O00000o = null;
    public O00000Oo O00000o0 = null;
    public UUID O00000oO;
    public int O00000oo = 4;

    /* access modifiers changed from: package-private */
    public abstract void O000000o(int i);

    /* access modifiers changed from: package-private */
    public abstract void O00000Oo(byte[] bArr);

    ffb(BluetoothManager bluetoothManager) {
        if (bluetoothManager == null) {
            this.O00000Oo = BluetoothAdapter.getDefaultAdapter();
            O000000o("AbsClassicBTProvider:No available BluetoothManager, BluetoothAdapter initialised with BluetoothAdapter.getDefaultAdapter.");
        } else {
            this.O00000Oo = bluetoothManager.getAdapter();
        }
        if (this.O00000Oo == null) {
            O00000Oo("AbsClassicBTProvider", "Initialisation of the Bluetooth Adapter failed: unable to initialize BluetoothAdapter.");
        }
    }

    public final boolean O000000o() {
        if (this.O00000oo == 0) {
            O00000Oo("AbsClassicBTProvider:disconnection failed: no device connected.");
            return false;
        }
        O00000Oo(3);
        O00000Oo();
        O00000o0();
        O00000Oo(0);
        StringBuilder sb = new StringBuilder("AbsClassicBTProvider:Provider disconnected from BluetoothDevice ");
        BluetoothDevice bluetoothDevice = this.f16208O000000o;
        sb.append(bluetoothDevice != null ? bluetoothDevice.getAddress() : "null");
        O000000o(sb.toString());
        return true;
    }

    public final boolean O000000o(byte[] bArr) {
        synchronized (this) {
            if (this.O00000oo != 2) {
                O00000Oo("AbsClassicBTProvider:Attempt to send data failed: provider not currently connected to a device.");
                return false;
            } else if (this.O00000o == null) {
                O00000Oo("AbsClassicBTProvider:Attempt to send data failed: CommunicationThread is null.");
                return false;
            } else {
                O000000o o000000o = this.O00000o;
                return o000000o.O000000o(bArr);
            }
        }
    }

    public final synchronized void O00000Oo(int i) {
        this.O00000oo = i;
        O000000o(i);
    }

    public final void O00000Oo() {
        O00000Oo o00000Oo = this.O00000o0;
        if (o00000Oo != null) {
            o00000Oo.interrupt();
            this.O00000o0 = null;
        }
    }

    public final void O00000o0() {
        if (this.O00000o != null) {
            O000000o("MyTest", "cancel CommunicationThread: " + this.O00000o);
            this.O00000o.O000000o();
            this.O00000o = null;
        }
    }

    public final boolean O00000o() {
        return this.O00000Oo != null;
    }

    public class O00000Oo extends Thread {
        private final BluetoothSocket O00000Oo;
        private final String O00000o0;

        public /* synthetic */ O00000Oo(ffb ffb, BluetoothSocket bluetoothSocket, byte b) {
            this(bluetoothSocket);
        }

        private O00000Oo(BluetoothSocket bluetoothSocket) {
            this.O00000o0 = "ConnectionThread";
            setName("ConnectionThread" + getId());
            this.O00000Oo = bluetoothSocket;
        }

        public final void run() {
            try {
                this.O00000Oo.connect();
                ffb ffb = ffb.this;
                BluetoothSocket bluetoothSocket = this.O00000Oo;
                ffb.O00000Oo();
                ffb.O00000o0();
                ffb.O00000o = new O000000o(bluetoothSocket);
                ffb.O00000o.start();
                ffb.O00000Oo(2);
                ffb.O000000o("AbsClassicBTProvider:Successful connection to device: " + ffb.f16208O000000o.getAddress());
            } catch (IOException e) {
                ffb.O000000o("MyTest", "ConnectException " + e.toString());
                ffb.O00000Oo("AbsClassicBTProvider:Exception while connecting: " + e.toString());
                try {
                    this.O00000Oo.close();
                } catch (IOException e2) {
                    ffb.O00000Oo("AbsClassicBTProvider:Could not close the client socket" + e2.getMessage());
                }
                ffb.this.O00000Oo(0);
                ffb.this.O00000o0 = null;
            }
        }
    }

    class O000000o extends Thread {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f16209O000000o = false;
        private final OutputStream O00000o;
        private final InputStream O00000o0;
        private final BluetoothSocket O00000oO;
        private final String O00000oo = "CommunicationThread";

        O000000o(BluetoothSocket bluetoothSocket) {
            InputStream inputStream;
            setName("CommunicationThread" + getId());
            this.O00000oO = bluetoothSocket;
            OutputStream outputStream = null;
            try {
                inputStream = this.O00000oO.getInputStream();
                try {
                    outputStream = this.O00000oO.getOutputStream();
                } catch (IOException e) {
                    e = e;
                    ffb.O00000Oo("CommunicationThread", "Error occurred when getting input and output streams" + e.getMessage());
                    this.O00000o0 = inputStream;
                    this.O00000o = outputStream;
                }
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                ffb.O00000Oo("CommunicationThread", "Error occurred when getting input and output streams" + e.getMessage());
                this.O00000o0 = inputStream;
                this.O00000o = outputStream;
            }
            this.O00000o0 = inputStream;
            this.O00000o = outputStream;
        }

        public final void run() {
            if (this.O00000o0 == null) {
                ffb.O00000Oo("AbsClassicBTProvider:Run thread failed: InputStream is null.");
                ffb.this.O000000o();
            } else if (this.O00000o == null) {
                ffb.O00000Oo("AbsClassicBTProvider:Run thread failed: OutputStream is null.");
                ffb.this.O000000o();
            } else {
                BluetoothSocket bluetoothSocket = this.O00000oO;
                if (bluetoothSocket == null) {
                    ffb.O00000Oo("AbsClassicBTProvider:Run thread failed: BluetoothSocket is null.");
                    ffb.this.O000000o();
                } else if (!bluetoothSocket.isConnected()) {
                    ffb.O00000Oo("AbsClassicBTProvider:Run thread failed: BluetoothSocket is not connected.");
                    ffb.this.O000000o();
                } else {
                    byte[] bArr = new byte[1024];
                    this.f16209O000000o = true;
                    while (ffb.this.O00000oo == 2 && this.f16209O000000o) {
                        try {
                            int read = this.O00000o0.read(bArr);
                            if (read > 0) {
                                byte[] bArr2 = new byte[read];
                                System.arraycopy(bArr, 0, bArr2, 0, read);
                                ffb.O00000Oo("MyTest", "receiveData = " + ffb.O00000o0(bArr2));
                                ffb.this.O00000Oo(bArr2);
                            }
                        } catch (IOException e) {
                            ffb.O00000Oo("CommunicationThread", "Reception of data failed: exception occurred while reading: " + e.toString());
                            this.f16209O000000o = false;
                            if (ffb.this.O00000oo == 2) {
                                ffb.this.O00000Oo(0);
                            }
                            ffb.O000000o("MyTest", "clear CommunicationThread:" + ffb.this.O00000o);
                            ffb.this.O00000o = null;
                            return;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(byte[] bArr) {
            BluetoothSocket bluetoothSocket = this.O00000oO;
            if (bluetoothSocket == null) {
                ffb.O00000Oo("AbsClassicBTProvider:Sending of data failed: BluetoothSocket is null.");
                return false;
            } else if (!bluetoothSocket.isConnected()) {
                ffb.O00000Oo("AbsClassicBTProvider:Sending of data failed: BluetoothSocket is not connected.");
                return false;
            } else if (ffb.this.O00000oo != 2) {
                ffb.O00000Oo("AbsClassicBTProvider:Sending of data failed: Provider is not connected.");
                return false;
            } else {
                OutputStream outputStream = this.O00000o;
                if (outputStream == null) {
                    ffb.O00000Oo("AbsClassicBTProvider:Sending of data failed: OutputStream is null.");
                    return false;
                }
                try {
                    outputStream.write(bArr);
                    this.O00000o.flush();
                    gnk.O00000oO("MyTest" + ":" + ("sendData = " + ffb.O00000o0(bArr)));
                    return true;
                } catch (IOException e) {
                    ffb.O000000o("MyTest", "sendData error");
                    ffb.O00000Oo("AbsClassicBTProvider:Sending of data failed: Exception occurred while writing data: " + e.toString());
                    return false;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.f16209O000000o = false;
            try {
                this.O00000oO.close();
            } catch (IOException e) {
                ffb.O00000Oo("AbsClassicBTProvider:Cancellation of the Thread: Close of BluetoothSocket failed: " + e.toString());
            }
        }
    }

    public static String O00000o0(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            for (int i = 0; i < bArr.length; i++) {
                sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
            }
        }
        return sb.toString();
    }

    public static void O000000o(String str) {
        gnk.O00000o("AbsClassicBTProvider:".concat(String.valueOf(str)));
    }

    public static void O000000o(String str, String str2) {
        gnk.O00000o(str + ":" + str2);
    }

    public static void O00000Oo(String str) {
        gnk.O00000oO("AbsClassicBTProvider:".concat(String.valueOf(str)));
    }

    public static void O00000Oo(String str, String str2) {
        gnk.O00000Oo(str + ":" + str2);
    }

    public static BluetoothSocket O000000o(BluetoothDevice bluetoothDevice, UUID uuid) {
        try {
            if (Build.VERSION.SDK_INT >= 10) {
                return bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid);
            }
            return bluetoothDevice.createRfcommSocketToServiceRecord(uuid);
        } catch (IOException e) {
            O00000Oo("AbsClassicBTProvider:Exception occurs while creating Bluetooth socket: " + e.toString());
            O000000o("AbsClassicBTProvider:Attempting to invoke method to create Bluetooth Socket.");
            try {
                return (BluetoothSocket) bluetoothDevice.getClass().getMethod("createRfcommSocket", Integer.TYPE).invoke(bluetoothDevice, 1);
            } catch (Exception unused) {
                O00000Oo("AbsClassicBTProvider:Exception occurs while creating Bluetooth socket by invoking method: " + e.toString());
                return null;
            }
        }
    }
}
