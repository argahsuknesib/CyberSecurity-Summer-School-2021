package no.nordicsemi.android.dfu;

import _m_j.ft;
import _m_j.jah;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.xiaomi.smarthome.R;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuProgressInfo;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.HexInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.SizeValidationException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

public abstract class DfuBaseService extends IntentService implements DfuProgressInfo.ProgressListener {
    static boolean DEBUG = false;
    public boolean mAborted;
    private BluetoothAdapter mBluetoothAdapter;
    private final BroadcastReceiver mBluetoothStateBroadcastReceiver = new BroadcastReceiver() {
        /* class no.nordicsemi.android.dfu.DfuBaseService.AnonymousClass2 */

        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 12);
            DfuBaseService dfuBaseService = DfuBaseService.this;
            dfuBaseService.logw("Action received: android.bluetooth.adapter.action.STATE_CHANGED [state: " + intExtra + ", previous state: " + intExtra2 + "]");
            if (intExtra2 != 12) {
                return;
            }
            if (intExtra == 13 || intExtra == 10) {
                DfuBaseService.this.sendLogBroadcast(15, "Bluetooth adapter disabled");
                DfuBaseService dfuBaseService2 = DfuBaseService.this;
                dfuBaseService2.mConnectionState = 0;
                if (dfuBaseService2.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                }
            }
        }
    };
    private final BroadcastReceiver mBondStateBroadcastReceiver = new BroadcastReceiver() {
        /* class no.nordicsemi.android.dfu.DfuBaseService.AnonymousClass3 */

        public void onReceive(Context context, Intent intent) {
            int intExtra;
            if (((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(DfuBaseService.this.mDeviceAddress) && (intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) != 11 && DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.onBondStateChanged(intExtra);
            }
        }
    };
    protected int mConnectionState;
    private final BroadcastReceiver mConnectionStateBroadcastReceiver = new BroadcastReceiver() {
        /* class no.nordicsemi.android.dfu.DfuBaseService.AnonymousClass4 */

        public void onReceive(Context context, Intent intent) {
            if (((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(DfuBaseService.this.mDeviceAddress)) {
                String action = intent.getAction();
                DfuBaseService.this.logi("Action received: ".concat(String.valueOf(action)));
                DfuBaseService.this.sendLogBroadcast(0, "[Broadcast] Action received: ".concat(String.valueOf(action)));
            }
        }
    };
    public String mDeviceAddress;
    private String mDeviceName;
    private final BroadcastReceiver mDfuActionReceiver = new BroadcastReceiver() {
        /* class no.nordicsemi.android.dfu.DfuBaseService.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 0);
            DfuBaseService.this.logi("User action received: ".concat(String.valueOf(intExtra)));
            if (intExtra == 0) {
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Pause action received");
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.pause();
                }
            } else if (intExtra == 1) {
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Resume action received");
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.resume();
                }
            } else if (intExtra == 2) {
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Abort action received");
                DfuBaseService dfuBaseService = DfuBaseService.this;
                dfuBaseService.mAborted = true;
                if (dfuBaseService.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.abort();
                }
            }
        }
    };
    public DfuCallback mDfuServiceImpl;
    private boolean mDisableNotification;
    public int mError;
    private InputStream mFirmwareInputStream;
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        /* class no.nordicsemi.android.dfu.DfuBaseService.AnonymousClass5 */

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i != 0) {
                if (i == 8 || i == 19) {
                    DfuBaseService.this.logw("Target device disconnected with status: ".concat(String.valueOf(i)));
                } else {
                    DfuBaseService dfuBaseService = DfuBaseService.this;
                    dfuBaseService.loge("Connection state change error: " + i + " newState: " + i2);
                }
                DfuBaseService dfuBaseService2 = DfuBaseService.this;
                dfuBaseService2.mError = i | 32768;
                if (i2 == 0) {
                    dfuBaseService2.mConnectionState = 0;
                    if (dfuBaseService2.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                    }
                }
            } else if (i2 == 2) {
                DfuBaseService.this.logi("Connected to GATT server");
                DfuBaseService dfuBaseService3 = DfuBaseService.this;
                dfuBaseService3.sendLogBroadcast(5, "Connected to " + DfuBaseService.this.mDeviceAddress);
                DfuBaseService.this.mConnectionState = -2;
                if (bluetoothGatt.getDevice().getBondState() == 12) {
                    DfuBaseService.this.logi("Waiting 1600 ms for a possible Service Changed indication...");
                    DfuBaseService.this.waitFor(1600);
                }
                DfuBaseService.this.sendLogBroadcast(1, "Discovering services...");
                DfuBaseService.this.sendLogBroadcast(0, "gatt.discoverServices()");
                boolean discoverServices = bluetoothGatt.discoverServices();
                DfuBaseService dfuBaseService4 = DfuBaseService.this;
                StringBuilder sb = new StringBuilder("Attempting to start service discovery... ");
                sb.append(discoverServices ? "succeed" : "failed");
                dfuBaseService4.logi(sb.toString());
                if (!discoverServices) {
                    DfuBaseService.this.mError = 4101;
                } else {
                    return;
                }
            } else if (i2 == 0) {
                DfuBaseService.this.logi("Disconnected from GATT server");
                DfuBaseService dfuBaseService5 = DfuBaseService.this;
                dfuBaseService5.mConnectionState = 0;
                if (dfuBaseService5.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                }
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                DfuBaseService.this.logi("Services discovered");
                DfuBaseService.this.mConnectionState = -3;
            } else {
                DfuBaseService.this.loge("Service discovery error: ".concat(String.valueOf(i)));
                DfuBaseService.this.mError = i | 16384;
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            }
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            }
        }

        @SuppressLint({"NewApi"})
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onMtuChanged(bluetoothGatt, i, i2);
            }
        }

        @SuppressLint({"NewApi"})
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onPhyUpdate(bluetoothGatt, i, i2, i3);
            }
        }
    };
    private InputStream mInitFileInputStream;
    private long mLastNotificationTime;
    private int mLastProgress = -1;
    public final Object mLock = new Object();
    DfuProgressInfo mProgressInfo;

    /* access modifiers changed from: protected */
    public abstract Class<? extends Activity> getNotificationTarget();

    /* access modifiers changed from: protected */
    public boolean isDebug() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void updateErrorNotification(NotificationCompat.Builder builder) {
    }

    /* access modifiers changed from: protected */
    public void updateForegroundNotification(NotificationCompat.Builder builder) {
    }

    public DfuBaseService() {
        super("DfuBaseService");
    }

    private static IntentFilter makeDfuActionIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
        return intentFilter;
    }

    public void onCreate() {
        super.onCreate();
        DEBUG = isDebug();
        logi("DFU service created. Version: 1.8.0");
        initialize();
        ft O000000o2 = ft.O000000o(this);
        IntentFilter makeDfuActionIntentFilter = makeDfuActionIntentFilter();
        O000000o2.O000000o(this.mDfuActionReceiver, makeDfuActionIntentFilter);
        registerReceiver(this.mDfuActionReceiver, makeDfuActionIntentFilter);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        registerReceiver(this.mConnectionStateBroadcastReceiver, intentFilter);
        registerReceiver(this.mBondStateBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
        registerReceiver(this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        ((NotificationManager) getSystemService("notification")).cancel(283);
        stopSelf();
    }

    public void onDestroy() {
        super.onDestroy();
        DfuCallback dfuCallback = this.mDfuServiceImpl;
        if (dfuCallback != null) {
            dfuCallback.abort();
        }
        ft.O000000o(this).O000000o(this.mDfuActionReceiver);
        unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mConnectionStateBroadcastReceiver);
        unregisterReceiver(this.mBondStateBroadcastReceiver);
        unregisterReceiver(this.mBluetoothStateBroadcastReceiver);
        try {
            if (this.mFirmwareInputStream != null) {
                this.mFirmwareInputStream.close();
            }
            if (this.mInitFileInputStream != null) {
                this.mInitFileInputStream.close();
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.mFirmwareInputStream = null;
            this.mInitFileInputStream = null;
            throw th;
        }
        this.mFirmwareInputStream = null;
        this.mInitFileInputStream = null;
        logi("DFU service destroyed");
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:189:0x037c */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:218:0x03cd */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: no.nordicsemi.android.dfu.DfuService} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: no.nordicsemi.android.dfu.DfuService} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: no.nordicsemi.android.dfu.DfuService} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v12, resolved type: no.nordicsemi.android.dfu.DfuService} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: no.nordicsemi.android.dfu.DfuService} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v15, resolved type: no.nordicsemi.android.dfu.DfuService} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v23, resolved type: java.io.InputStream} */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x03b6, code lost:
        if (r14 != 0) goto L_0x03b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0444, code lost:
        if (r14 != null) goto L_0x03b8;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:231:0x044b */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x03d7 A[Catch:{ UploadAbortedException -> 0x044b, DeviceDisconnectedException -> 0x042b, DfuException -> 0x03ca, all -> 0x0448 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x03fa A[Catch:{ UploadAbortedException -> 0x044b, DeviceDisconnectedException -> 0x042b, DfuException -> 0x03ca, all -> 0x0448 }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x042a A[Catch:{ UploadAbortedException -> 0x044b, DeviceDisconnectedException -> 0x042b, DfuException -> 0x03ca, all -> 0x0448 }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x045e A[SYNTHETIC, Splitter:B:234:0x045e] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0463  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0469 A[SYNTHETIC, Splitter:B:239:0x0469] */
    /* JADX WARNING: Removed duplicated region for block: B:285:? A[RETURN, SYNTHETIC] */
    public void onHandleIntent(Intent intent) {
        int i;
        InputStream inputStream;
        InputStream inputStream2;
        int i2;
        BluetoothGatt connect;
        DfuService dfuService;
        DfuService dfuService2;
        int errorNumber;
        int i3;
        InputStream inputStream3;
        InputStream inputStream4;
        InputStream inputStream5;
        Intent intent2 = intent;
        String stringExtra = intent2.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS");
        String stringExtra2 = intent2.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME");
        boolean booleanExtra = intent2.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION", false);
        boolean booleanExtra2 = intent2.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE", true);
        String stringExtra3 = intent2.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH");
        Uri uri = (Uri) intent2.getParcelableExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI");
        int intExtra = intent2.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID", 0);
        String stringExtra4 = intent2.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH");
        Uri uri2 = (Uri) intent2.getParcelableExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI");
        int intExtra2 = intent2.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID", 0);
        int intExtra3 = intent2.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE", 0);
        if (stringExtra3 != null && intExtra3 == 0) {
            intExtra3 = stringExtra3.toLowerCase(Locale.US).endsWith("zip") ? 0 : 4;
        }
        String stringExtra5 = intent2.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE");
        if (stringExtra5 == null) {
            stringExtra5 = intExtra3 == 0 ? "application/zip" : "application/octet-stream";
        }
        int i4 = intExtra2;
        if ((intExtra3 & -8) > 0 || (!"application/zip".equals(stringExtra5) && !"application/octet-stream".equals(stringExtra5))) {
            logw("File type or file mime-type not supported");
            sendLogBroadcast(15, "File type or file mime-type not supported");
            report(4105);
        } else if ("application/octet-stream".equals(stringExtra5) && intExtra3 != 1 && intExtra3 != 2 && intExtra3 != 4) {
            logw("Unable to determine file type");
            sendLogBroadcast(15, "Unable to determine file type");
            report(4105);
        } else if (booleanExtra || getNotificationTarget() != null) {
            if (!booleanExtra2 && Build.VERSION.SDK_INT >= 26) {
                logw("Foreground service disabled. Android Oreo or newer may kill a background service few moments after user closes the application.\nConsider enabling foreground service using DfuServiceInitiator#setForeground(boolean)");
            }
            UuidHelper.assignCustomUuids(intent);
            this.mDeviceAddress = stringExtra;
            this.mDeviceName = stringExtra2;
            this.mDisableNotification = booleanExtra;
            this.mConnectionState = 0;
            this.mError = 0;
            try {
                i = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("settings_mbr_size", "4096"));
                if (i < 0) {
                    i = 0;
                }
            } catch (NumberFormatException unused) {
                i = 4096;
            }
            if (booleanExtra2) {
                startForeground();
            }
            sendLogBroadcast(1, "DFU service started");
            InputStream inputStream6 = this.mFirmwareInputStream;
            InputStream inputStream7 = this.mInitFileInputStream;
            boolean z = inputStream6 == null;
            InputStream inputStream8 = inputStream6;
            if (z) {
                InputStream inputStream9 = inputStream7;
                try {
                    sendLogBroadcast(1, "Opening file...");
                    if (uri != null) {
                        inputStream4 = openInputStream(uri, stringExtra5, i, intExtra3);
                    } else if (stringExtra3 != null) {
                        inputStream4 = openInputStream(stringExtra3, stringExtra5, i, intExtra3);
                    } else {
                        inputStream4 = intExtra > 0 ? openInputStream(intExtra, stringExtra5, i, intExtra3) : inputStream8;
                    }
                    if (uri2 != null) {
                        inputStream5 = getContentResolver().openInputStream(uri2);
                    } else if (stringExtra4 != null) {
                        inputStream5 = new FileInputStream(stringExtra4);
                    } else {
                        inputStream5 = i4 > 0 ? getResources().openRawResource(i4) : inputStream9;
                    }
                    if (inputStream4.available() % 4 == 0) {
                        inputStream = inputStream4;
                        inputStream7 = inputStream5;
                    } else {
                        throw new SizeValidationException("The new firmware is not word-aligned.");
                    }
                } catch (SecurityException e) {
                    loge("A security exception occurred while opening file", e);
                    sendLogBroadcast(20, "Opening file failed: Permission required");
                    report(4097);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                } catch (FileNotFoundException e2) {
                    loge("An exception occurred while opening file", e2);
                    sendLogBroadcast(20, "Opening file failed: File not found");
                    report(4097);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                } catch (SizeValidationException e3) {
                    loge("Firmware not word-aligned", e3);
                    sendLogBroadcast(20, "Opening file failed: Firmware size must be word-aligned");
                    report(4108);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                } catch (IOException e4) {
                    IOException iOException = e4;
                    loge("An exception occurred while calculating file size", iOException);
                    sendLogBroadcast(20, "Opening file failed: " + iOException.getLocalizedMessage());
                    report(4098);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                } catch (Exception e5) {
                    Exception exc = e5;
                    loge("An exception occurred while opening files. Did you set the firmware file?", exc);
                    sendLogBroadcast(20, "Opening file failed: " + exc.getLocalizedMessage());
                    report(4098);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                    }
                    throw th2;
                }
            } else {
                InputStream inputStream10 = inputStream7;
                inputStream = inputStream8;
            }
            if ("application/zip".equals(stringExtra5)) {
                ArchiveInputStream archiveInputStream = (ArchiveInputStream) inputStream;
                if (intExtra3 == 0) {
                    i3 = archiveInputStream.getContentType();
                } else {
                    i3 = archiveInputStream.setContentType(intExtra3);
                }
                if ((i3 & 4) > 0) {
                    if (archiveInputStream.applicationImageSize() % 4 != 0) {
                        throw new SizeValidationException("Application firmware is not word-aligned.");
                    }
                }
                if ((i3 & 2) > 0) {
                    if (archiveInputStream.bootloaderImageSize() % 4 != 0) {
                        throw new SizeValidationException("Bootloader firmware is not word-aligned.");
                    }
                }
                if ((i3 & 1) > 0) {
                    if (archiveInputStream.softDeviceImageSize() % 4 != 0) {
                        throw new SizeValidationException("Soft Device firmware is not word-aligned.");
                    }
                }
                if (i3 == 4) {
                    if (archiveInputStream.getApplicationInit() != null) {
                        inputStream3 = new ByteArrayInputStream(archiveInputStream.getApplicationInit());
                    }
                    i2 = i3;
                    inputStream2 = inputStream7;
                } else {
                    if (archiveInputStream.getSystemInit() != null) {
                        inputStream3 = new ByteArrayInputStream(archiveInputStream.getSystemInit());
                    }
                    i2 = i3;
                    inputStream2 = inputStream7;
                }
                inputStream2 = inputStream3;
                i2 = i3;
            } else {
                inputStream2 = inputStream7;
                i2 = intExtra3;
            }
            if (z) {
                inputStream.mark(inputStream.available());
                if (inputStream2 != null) {
                    inputStream2.mark(inputStream2.available());
                }
            }
            this.mFirmwareInputStream = inputStream;
            this.mInitFileInputStream = inputStream2;
            sendLogBroadcast(5, "Firmware file opened successfully");
            if (!z) {
                waitFor(1000);
                waitFor(1000);
            }
            this.mProgressInfo = new DfuProgressInfo(this);
            if (this.mAborted) {
                logw("Upload aborted");
                sendLogBroadcast(15, "Upload aborted");
                this.mProgressInfo.setProgress(-7);
                if (booleanExtra2) {
                    stopForeground(booleanExtra);
                    return;
                }
                return;
            }
            sendLogBroadcast(1, "Connecting to DFU target...");
            this.mProgressInfo.setProgress(-1);
            connect = connect(stringExtra);
            if (connect == null) {
                loge("Bluetooth adapter disabled");
                sendLogBroadcast(20, "Bluetooth adapter disabled");
                report(4106);
                if (booleanExtra2) {
                    stopForeground(booleanExtra);
                }
            } else if (this.mConnectionState == 0) {
                if (this.mError == 32901) {
                    loge("Device not reachable. Check if the device with address " + stringExtra + " is in range, is advertising and is connectable");
                    sendLogBroadcast(20, "Error 133: Connection timeout");
                } else {
                    loge("Device got disconnected before service discovery finished");
                    sendLogBroadcast(20, "Disconnected");
                }
                terminateConnection(connect, 4096);
                if (booleanExtra2) {
                    stopForeground(booleanExtra);
                }
            } else if (this.mError > 0) {
                if ((this.mError & 32768) > 0) {
                    int i5 = this.mError & -32769;
                    loge("An error occurred while connecting to the device:".concat(String.valueOf(i5)));
                    sendLogBroadcast(20, String.format(Locale.US, "Connection failed (0x%02X): %s", Integer.valueOf(i5), jah.O000000o(i5)));
                } else {
                    int i6 = this.mError & -16385;
                    loge("An error occurred during discovering services:".concat(String.valueOf(i6)));
                    sendLogBroadcast(20, String.format(Locale.US, "Connection failed (0x%02X): %s", Integer.valueOf(i6), jah.O00000Oo(i6)));
                }
                Intent intent3 = intent;
                if (intent3.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ATTEMPT", 0) == 0) {
                    sendLogBroadcast(15, "Retrying...");
                    if (this.mConnectionState != 0) {
                        disconnect(connect);
                    }
                    refreshDeviceCache(connect, true);
                    close(connect);
                    logi("Restarting the service");
                    Intent intent4 = new Intent();
                    intent4.fillIn(intent3, 24);
                    intent4.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ATTEMPT", 1);
                    startService(intent4);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                }
                terminateConnection(connect, this.mError);
                if (booleanExtra2) {
                    stopForeground(booleanExtra);
                }
            } else {
                Intent intent5 = intent;
                if (this.mAborted) {
                    logw("Upload aborted");
                    sendLogBroadcast(15, "Upload aborted");
                    terminateConnection(connect, 0);
                    this.mProgressInfo.setProgress(-7);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                }
                sendLogBroadcast(5, "Services discovered");
                intent5.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ATTEMPT", 0);
                dfuService = null;
                try {
                    DfuServiceProvider dfuServiceProvider = new DfuServiceProvider();
                    this.mDfuServiceImpl = dfuServiceProvider;
                    inputStream7 = dfuServiceProvider.getServiceImpl(intent5, this, connect);
                    try {
                        this.mDfuServiceImpl = inputStream7;
                        if (inputStream7 == 0) {
                            Log.w("DfuBaseService", "DFU Service not found.");
                            sendLogBroadcast(15, "DFU Service not found");
                            terminateConnection(connect, 4102);
                            if (inputStream7 != 0) {
                                inputStream7.release();
                            }
                            if (booleanExtra2) {
                                stopForeground(booleanExtra);
                            }
                        } else if (inputStream7.initialize(intent, connect, i2, inputStream, inputStream2)) {
                            inputStream7.performDfu(intent5);
                        }
                    } catch (UploadAbortedException unused2) {
                        dfuService = inputStream7;
                        try {
                            logw("Upload aborted");
                            sendLogBroadcast(15, "Upload aborted");
                            terminateConnection(connect, 0);
                            this.mProgressInfo.setProgress(-7);
                            if (dfuService != null) {
                            }
                            if (!booleanExtra2) {
                                stopForeground(booleanExtra);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            dfuService2 = dfuService;
                            Throwable th4 = th;
                            if (dfuService2 != null) {
                            }
                            throw th4;
                        }
                    } catch (DeviceDisconnectedException e6) {
                        e = e6;
                        sendLogBroadcast(20, "Device has disconnected");
                        loge(e.getMessage());
                        close(connect);
                        report(4096);
                    } catch (DfuException e7) {
                        e = e7;
                        DfuException dfuException = e;
                        errorNumber = dfuException.getErrorNumber();
                        if ((32768 & errorNumber) <= 0) {
                        }
                        loge(dfuException.getMessage());
                        terminateConnection(connect, dfuException.getErrorNumber());
                        if (inputStream7 != 0) {
                        }
                        if (!booleanExtra2) {
                        }
                    }
                } catch (UploadAbortedException ) {
                    logw("Upload aborted");
                    sendLogBroadcast(15, "Upload aborted");
                    terminateConnection(connect, 0);
                    this.mProgressInfo.setProgress(-7);
                    if (dfuService != null) {
                        dfuService.release();
                    }
                } catch (DeviceDisconnectedException e8) {
                    e = e8;
                    inputStream7 = null;
                    sendLogBroadcast(20, "Device has disconnected");
                    loge(e.getMessage());
                    close(connect);
                    report(4096);
                } catch (DfuException e9) {
                    e = e9;
                    inputStream7 = null;
                    DfuException dfuException2 = e;
                    errorNumber = dfuException2.getErrorNumber();
                    if ((32768 & errorNumber) <= 0) {
                        int i7 = errorNumber & -32769;
                        sendLogBroadcast(20, String.format(Locale.US, "Error (0x%02X): %s", Integer.valueOf(i7), jah.O000000o(i7)));
                    } else {
                        int i8 = errorNumber & -16385;
                        sendLogBroadcast(20, String.format(Locale.US, "Error (0x%02X): %s", Integer.valueOf(i8), jah.O00000Oo(i8)));
                    }
                    loge(dfuException2.getMessage());
                    terminateConnection(connect, dfuException2.getErrorNumber());
                    if (inputStream7 != 0) {
                        inputStream7.release();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    dfuService2 = inputStream7;
                    Throwable th42 = th;
                    if (dfuService2 != null) {
                        dfuService2.release();
                    }
                    throw th42;
                }
            }
        } else {
            throw new NullPointerException("getNotificationTarget() must not return null if notifications are enabled");
        }
    }

    private InputStream openInputStream(String str, String str2, int i, int i2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        if ("application/zip".equals(str2)) {
            return new ArchiveInputStream(fileInputStream, i, i2);
        }
        return str.toLowerCase(Locale.US).endsWith("hex") ? new HexInputStream(fileInputStream, i) : fileInputStream;
    }

    private InputStream openInputStream(Uri uri, String str, int i, int i2) throws IOException {
        InputStream openInputStream = getContentResolver().openInputStream(uri);
        if ("application/zip".equals(str)) {
            return new ArchiveInputStream(openInputStream, i, i2);
        }
        Cursor query = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        try {
            if (query.moveToNext() && query.getString(0).toLowerCase(Locale.US).endsWith("hex")) {
                return new HexInputStream(openInputStream, i);
            }
            query.close();
            return openInputStream;
        } finally {
            query.close();
        }
    }

    private InputStream openInputStream(int i, String str, int i2, int i3) throws IOException {
        InputStream openRawResource = getResources().openRawResource(i);
        if ("application/zip".equals(str)) {
            return new ArchiveInputStream(openRawResource, i2, i3);
        }
        openRawResource.mark(2);
        int read = openRawResource.read();
        openRawResource.reset();
        return read == 58 ? new HexInputStream(openRawResource, i2) : openRawResource;
    }

    /* access modifiers changed from: protected */
    public BluetoothGatt connect(String str) {
        if (!this.mBluetoothAdapter.isEnabled()) {
            return null;
        }
        this.mConnectionState = -1;
        logi("Connecting to the device...");
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false)");
        BluetoothGatt connectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mConnectionState == -1 || this.mConnectionState == -2) && this.mError == 0) {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return connectGatt;
    }

    /* access modifiers changed from: protected */
    public void terminateConnection(BluetoothGatt bluetoothGatt, int i) {
        if (this.mConnectionState != 0) {
            disconnect(bluetoothGatt);
        }
        refreshDeviceCache(bluetoothGatt, false);
        close(bluetoothGatt);
        waitFor(600);
        if (i != 0) {
            report(i);
        }
    }

    /* access modifiers changed from: protected */
    public void disconnect(BluetoothGatt bluetoothGatt) {
        if (this.mConnectionState != 0) {
            sendLogBroadcast(1, "Disconnecting...");
            this.mProgressInfo.setProgress(-5);
            this.mConnectionState = -4;
            logi("Disconnecting from the device...");
            sendLogBroadcast(0, "gatt.disconnect()");
            bluetoothGatt.disconnect();
            waitUntilDisconnected();
            sendLogBroadcast(5, "Disconnected");
        }
    }

    /* access modifiers changed from: protected */
    public void waitUntilDisconnected() {
        try {
            synchronized (this.mLock) {
                while (this.mConnectionState != 0 && this.mError == 0) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    /* access modifiers changed from: protected */
    public void waitFor(int i) {
        synchronized (this.mLock) {
            try {
                sendLogBroadcast(0, "wait(" + i + ")");
                this.mLock.wait((long) i);
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void close(BluetoothGatt bluetoothGatt) {
        logi("Cleaning up...");
        sendLogBroadcast(0, "gatt.close()");
        bluetoothGatt.close();
        this.mConnectionState = -5;
    }

    /* access modifiers changed from: protected */
    public void refreshDeviceCache(BluetoothGatt bluetoothGatt, boolean z) {
        if (z || bluetoothGatt.getDevice().getBondState() == 10) {
            sendLogBroadcast(0, "gatt.refresh() (hidden)");
            try {
                Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
                if (method != null) {
                    logi("Refreshing result: ".concat(String.valueOf(((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue())));
                }
            } catch (Exception e) {
                loge("An exception occurred while refreshing device", e);
                sendLogBroadcast(15, "Refreshing failed");
            }
        }
    }

    public void updateProgressNotification() {
        String str;
        DfuProgressInfo dfuProgressInfo = this.mProgressInfo;
        int progress = dfuProgressInfo.getProgress();
        if (this.mLastProgress != progress) {
            this.mLastProgress = progress;
            sendProgressBroadcast(dfuProgressInfo);
            if (!this.mDisableNotification) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - this.mLastNotificationTime >= 250 || -6 == progress || -7 == progress) {
                    this.mLastNotificationTime = elapsedRealtime;
                    String str2 = this.mDeviceAddress;
                    String str3 = this.mDeviceName;
                    if (str3 == null) {
                        str3 = getString(R.string.dfu_unknown_name);
                    }
                    NotificationCompat.Builder O000000o2 = new NotificationCompat.Builder(this, "dfu").O000000o(17301640).O000000o();
                    O000000o2.O000O0Oo = -7829368;
                    switch (progress) {
                        case -7:
                            O000000o2.O000000o(2, false);
                            O000000o2.O000000o(getString(R.string.dfu_status_aborted)).O000000o(17301641).O00000Oo(getString(R.string.dfu_status_aborted_msg)).O00000Oo();
                            break;
                        case -6:
                            O000000o2.O000000o(2, false);
                            O000000o2.O000000o(getString(R.string.dfu_status_completed)).O000000o(17301641).O00000Oo(getString(R.string.dfu_status_completed_msg)).O00000Oo().O000O0Oo = -16730086;
                            break;
                        case -5:
                            O000000o2.O000000o(2, true);
                            O000000o2.O000000o(getString(R.string.dfu_status_disconnecting)).O00000Oo(getString(R.string.dfu_status_disconnecting_msg, new Object[]{str3})).O000000o(100, 0, true);
                            break;
                        case -4:
                            O000000o2.O000000o(2, true);
                            O000000o2.O000000o(getString(R.string.dfu_status_validating)).O00000Oo(getString(R.string.dfu_status_validating_msg)).O000000o(100, 0, true);
                            break;
                        case -3:
                            O000000o2.O000000o(2, true);
                            O000000o2.O000000o(getString(R.string.dfu_status_switching_to_dfu)).O00000Oo(getString(R.string.dfu_status_switching_to_dfu_msg)).O000000o(100, 0, true);
                            break;
                        case -2:
                            O000000o2.O000000o(2, true);
                            O000000o2.O000000o(getString(R.string.dfu_status_starting)).O00000Oo(getString(R.string.dfu_status_starting_msg)).O000000o(100, 0, true);
                            break;
                        case -1:
                            O000000o2.O000000o(2, true);
                            O000000o2.O000000o(getString(R.string.dfu_status_connecting)).O00000Oo(getString(R.string.dfu_status_connecting_msg, new Object[]{str3})).O000000o(100, 0, true);
                            break;
                        default:
                            if (dfuProgressInfo.getTotalParts() == 1) {
                                str = getString(R.string.dfu_status_uploading);
                            } else {
                                str = getString(R.string.dfu_status_uploading_part, new Object[]{Integer.valueOf(dfuProgressInfo.getCurrentPart()), Integer.valueOf(dfuProgressInfo.getTotalParts())});
                            }
                            String string = getString(R.string.dfu_status_uploading_msg, new Object[]{str3});
                            O000000o2.O000000o(2, true);
                            O000000o2.O000000o(str).O00000Oo(string).O000000o(100, progress, false);
                            break;
                    }
                    Intent intent = new Intent(this, getNotificationTarget());
                    intent.addFlags(268435456);
                    intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", str2);
                    intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", str3);
                    intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS", progress);
                    O000000o2.O00000oo = PendingIntent.getActivity(this, 0, intent, 134217728);
                    updateProgressNotification(O000000o2, progress);
                    ((NotificationManager) getSystemService("notification")).notify(283, O000000o2.O00000o());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateProgressNotification(NotificationCompat.Builder builder, int i) {
        if (i != -7 && i != -6) {
            Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 2);
            PendingIntent broadcast = PendingIntent.getBroadcast(this, 1, intent, 134217728);
            builder.O00000Oo.add(new NotificationCompat.O000000o((int) R.drawable.ic_action_notify_cancel, getString(R.string.dfu_action_abort), broadcast));
        }
    }

    private void report(int i) {
        sendErrorBroadcast(i);
        if (!this.mDisableNotification) {
            String str = this.mDeviceAddress;
            String str2 = this.mDeviceName;
            if (str2 == null) {
                str2 = getString(R.string.dfu_unknown_name);
            }
            NotificationCompat.Builder O000000o2 = new NotificationCompat.Builder(this, "dfu").O000000o(17301640).O000000o();
            O000000o2.O000O0Oo = -65536;
            O000000o2.O000000o(2, false);
            NotificationCompat.Builder O00000Oo = O000000o2.O000000o(getString(R.string.dfu_status_error)).O000000o(17301641).O00000Oo(getString(R.string.dfu_status_error_msg)).O00000Oo();
            Intent intent = new Intent(this, getNotificationTarget());
            intent.addFlags(268435456);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", str);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", str2);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS", i);
            O00000Oo.O00000oo = PendingIntent.getActivity(this, 0, intent, 134217728);
            updateErrorNotification(O00000Oo);
            ((NotificationManager) getSystemService("notification")).notify(283, O00000Oo.O00000o());
        }
    }

    private void startForeground() {
        NotificationCompat.Builder O00000Oo = new NotificationCompat.Builder(this, "dfu").O000000o(17301640).O000000o(getString(R.string.dfu_status_foreground_title)).O00000Oo(getString(R.string.dfu_status_foreground_content));
        O00000Oo.O000O0Oo = -7829368;
        O00000Oo.O0000Ooo = -1;
        O00000Oo.O000000o(2, true);
        Class<? extends Activity> notificationTarget = getNotificationTarget();
        if (notificationTarget != null) {
            Intent intent = new Intent(this, notificationTarget);
            intent.addFlags(268435456);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.mDeviceAddress);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", this.mDeviceName);
            O00000Oo.O00000oo = PendingIntent.getActivity(this, 0, intent, 134217728);
        } else {
            logw("getNotificationTarget() should not return null if the service is to be started as a foreground service");
        }
        updateForegroundNotification(O00000Oo);
        startForeground(283, O00000Oo.O00000o());
    }

    private void sendProgressBroadcast(DfuProgressInfo dfuProgressInfo) {
        Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", dfuProgressInfo.getProgress());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.mDeviceAddress);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", dfuProgressInfo.getCurrentPart());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", dfuProgressInfo.getTotalParts());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS", dfuProgressInfo.getSpeed());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS", dfuProgressInfo.getAverageSpeed());
        ft.O000000o(this).O000000o(intent);
    }

    private void sendErrorBroadcast(int i) {
        Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
        if ((i & 16384) > 0) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i & -16385);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 2);
        } else if ((32768 & i) > 0) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i & -32769);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 1);
        } else if ((i & 8192) > 0) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i & -8193);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 3);
        } else {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 0);
        }
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.mDeviceAddress);
        ft.O000000o(this).O000000o(intent);
    }

    /* access modifiers changed from: package-private */
    public void sendLogBroadcast(int i, String str) {
        String concat = "[DFU] ".concat(String.valueOf(str));
        Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG");
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO", concat);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL", i);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.mDeviceAddress);
        ft.O000000o(this).O000000o(intent);
    }

    private boolean initialize() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            loge("Unable to initialize BluetoothManager.");
            return false;
        }
        this.mBluetoothAdapter = bluetoothManager.getAdapter();
        if (this.mBluetoothAdapter != null) {
            return true;
        }
        loge("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    public void loge(String str) {
        Log.e("DfuBaseService", str);
    }

    private void loge(String str, Throwable th) {
        Log.e("DfuBaseService", str, th);
    }

    public void logw(String str) {
        if (DEBUG) {
            Log.w("DfuBaseService", str);
        }
    }

    public void logi(String str) {
        if (DEBUG) {
            Log.i("DfuBaseService", str);
        }
    }
}
