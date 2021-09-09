package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

class DfuServiceProvider implements DfuCallback {
    private boolean mAborted;
    private BaseDfuImpl mImpl;
    private boolean mPaused;

    DfuServiceProvider() {
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public DfuService getServiceImpl(Intent intent, DfuBaseService dfuBaseService, BluetoothGatt bluetoothGatt) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        try {
            this.mImpl = new ButtonlessDfuWithBondSharingImpl(intent, dfuBaseService);
            if (this.mImpl.isClientCompatible(intent, bluetoothGatt)) {
                BaseDfuImpl baseDfuImpl = this.mImpl;
                BaseDfuImpl baseDfuImpl2 = this.mImpl;
                if (baseDfuImpl2 != null) {
                    if (this.mPaused) {
                        baseDfuImpl2.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl;
            }
            this.mImpl = new ButtonlessDfuWithoutBondSharingImpl(intent, dfuBaseService);
            if (this.mImpl.isClientCompatible(intent, bluetoothGatt)) {
                BaseDfuImpl baseDfuImpl3 = this.mImpl;
                BaseDfuImpl baseDfuImpl4 = this.mImpl;
                if (baseDfuImpl4 != null) {
                    if (this.mPaused) {
                        baseDfuImpl4.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl3;
            }
            this.mImpl = new SecureDfuImpl(intent, dfuBaseService);
            if (this.mImpl.isClientCompatible(intent, bluetoothGatt)) {
                BaseDfuImpl baseDfuImpl5 = this.mImpl;
                BaseDfuImpl baseDfuImpl6 = this.mImpl;
                if (baseDfuImpl6 != null) {
                    if (this.mPaused) {
                        baseDfuImpl6.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl5;
            }
            this.mImpl = new LegacyButtonlessDfuImpl(intent, dfuBaseService);
            if (this.mImpl.isClientCompatible(intent, bluetoothGatt)) {
                BaseDfuImpl baseDfuImpl7 = this.mImpl;
                BaseDfuImpl baseDfuImpl8 = this.mImpl;
                if (baseDfuImpl8 != null) {
                    if (this.mPaused) {
                        baseDfuImpl8.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl7;
            }
            this.mImpl = new LegacyDfuImpl(intent, dfuBaseService);
            if (this.mImpl.isClientCompatible(intent, bluetoothGatt)) {
                BaseDfuImpl baseDfuImpl9 = this.mImpl;
                BaseDfuImpl baseDfuImpl10 = this.mImpl;
                if (baseDfuImpl10 != null) {
                    if (this.mPaused) {
                        baseDfuImpl10.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl9;
            }
            if (intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU", false)) {
                this.mImpl = new ExperimentalButtonlessDfuImpl(intent, dfuBaseService);
                if (this.mImpl.isClientCompatible(intent, bluetoothGatt)) {
                    BaseDfuImpl baseDfuImpl11 = this.mImpl;
                    BaseDfuImpl baseDfuImpl12 = this.mImpl;
                    if (baseDfuImpl12 != null) {
                        if (this.mPaused) {
                            baseDfuImpl12.pause();
                        }
                        if (this.mAborted) {
                            this.mImpl.abort();
                        }
                    }
                    return baseDfuImpl11;
                }
            }
            BaseDfuImpl baseDfuImpl13 = this.mImpl;
            if (baseDfuImpl13 == null) {
                return null;
            }
            if (this.mPaused) {
                baseDfuImpl13.pause();
            }
            if (!this.mAborted) {
                return null;
            }
            this.mImpl.abort();
            return null;
        } catch (Throwable th) {
            BaseDfuImpl baseDfuImpl14 = this.mImpl;
            if (baseDfuImpl14 != null) {
                if (this.mPaused) {
                    baseDfuImpl14.pause();
                }
                if (this.mAborted) {
                    this.mImpl.abort();
                }
            }
            throw th;
        }
    }

    public DfuCallback.DfuGattCallback getGattCallback() {
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            return baseDfuImpl.getGattCallback();
        }
        return null;
    }

    public void onBondStateChanged(int i) {
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            baseDfuImpl.onBondStateChanged(i);
        }
    }

    public void pause() {
        this.mPaused = true;
    }

    public void resume() {
        this.mPaused = false;
    }

    public void abort() {
        this.mAborted = true;
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            baseDfuImpl.abort();
        }
    }
}
