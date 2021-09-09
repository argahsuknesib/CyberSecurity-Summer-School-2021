package no.nordicsemi.android.dfu;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import java.security.InvalidParameterException;
import java.util.UUID;

public class DfuServiceInitiator {
    private Parcelable[] buttonlessDfuWithBondSharingUuids;
    private Parcelable[] buttonlessDfuWithoutBondSharingUuids;
    private int currentMtu = 23;
    private final String deviceAddress;
    private String deviceName;
    private boolean disableNotification = false;
    private boolean disableResume = false;
    private boolean enableUnsafeExperimentalButtonlessDfu = false;
    private Parcelable[] experimentalButtonlessDfuUuids;
    private String filePath;
    private int fileResId;
    private int fileType = -1;
    private Uri fileUri;
    private boolean forceDfu = false;
    private String initFilePath;
    private int initFileResId;
    private Uri initFileUri;
    private boolean keepBond;
    private Parcelable[] legacyDfuUuids;
    private String mimeType;
    private int mtu = 517;
    private int numberOfPackets = 12;
    private Boolean packetReceiptNotificationsEnabled;
    private boolean restoreBond;
    private Parcelable[] secureDfuUuids;
    private boolean startAsForegroundService = true;

    public DfuServiceInitiator(String str) {
        this.deviceAddress = str;
    }

    public DfuServiceInitiator setDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public DfuServiceInitiator setDisableNotification(boolean z) {
        this.disableNotification = z;
        return this;
    }

    public DfuServiceInitiator setForeground(boolean z) {
        this.startAsForegroundService = z;
        return this;
    }

    public DfuServiceInitiator setKeepBond(boolean z) {
        this.keepBond = z;
        return this;
    }

    public DfuServiceInitiator setRestoreBond(boolean z) {
        this.restoreBond = z;
        return this;
    }

    public DfuServiceInitiator setPacketsReceiptNotificationsEnabled(boolean z) {
        this.packetReceiptNotificationsEnabled = Boolean.valueOf(z);
        return this;
    }

    public DfuServiceInitiator setPacketsReceiptNotificationsValue(int i) {
        if (i <= 0) {
            i = 12;
        }
        this.numberOfPackets = i;
        return this;
    }

    public DfuServiceInitiator setForceDfu(boolean z) {
        this.forceDfu = z;
        return this;
    }

    public DfuServiceInitiator disableResume() {
        this.disableResume = true;
        return this;
    }

    public DfuServiceInitiator setMtu(int i) {
        this.mtu = i;
        return this;
    }

    public DfuServiceInitiator setCurrentMtu(int i) {
        this.currentMtu = i;
        return this;
    }

    public DfuServiceInitiator disableMtuRequest() {
        this.mtu = 0;
        return this;
    }

    public DfuServiceInitiator setScope(int i) {
        if ("application/zip".equals(this.mimeType)) {
            if (i == 3542) {
                this.fileType = 4;
            } else if (i == 7578) {
                this.fileType = 3;
            } else {
                throw new UnsupportedOperationException("Unknown scope");
            }
            return this;
        }
        throw new UnsupportedOperationException("Scope can be set only for a ZIP file");
    }

    public DfuServiceInitiator setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(boolean z) {
        this.enableUnsafeExperimentalButtonlessDfu = z;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForLegacyDfu(UUID uuid, UUID uuid2, UUID uuid3, UUID uuid4) {
        ParcelUuid[] parcelUuidArr = new ParcelUuid[4];
        ParcelUuid parcelUuid = null;
        parcelUuidArr[0] = uuid != null ? new ParcelUuid(uuid) : null;
        parcelUuidArr[1] = uuid2 != null ? new ParcelUuid(uuid2) : null;
        parcelUuidArr[2] = uuid3 != null ? new ParcelUuid(uuid3) : null;
        if (uuid4 != null) {
            parcelUuid = new ParcelUuid(uuid4);
        }
        parcelUuidArr[3] = parcelUuid;
        this.legacyDfuUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForSecureDfu(UUID uuid, UUID uuid2, UUID uuid3) {
        ParcelUuid[] parcelUuidArr = new ParcelUuid[3];
        ParcelUuid parcelUuid = null;
        parcelUuidArr[0] = uuid != null ? new ParcelUuid(uuid) : null;
        parcelUuidArr[1] = uuid2 != null ? new ParcelUuid(uuid2) : null;
        if (uuid3 != null) {
            parcelUuid = new ParcelUuid(uuid3);
        }
        parcelUuidArr[2] = parcelUuid;
        this.secureDfuUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForExperimentalButtonlessDfu(UUID uuid, UUID uuid2) {
        ParcelUuid[] parcelUuidArr = new ParcelUuid[2];
        ParcelUuid parcelUuid = null;
        parcelUuidArr[0] = uuid != null ? new ParcelUuid(uuid) : null;
        if (uuid2 != null) {
            parcelUuid = new ParcelUuid(uuid2);
        }
        parcelUuidArr[1] = parcelUuid;
        this.experimentalButtonlessDfuUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForButtonlessDfuWithBondSharing(UUID uuid, UUID uuid2) {
        ParcelUuid[] parcelUuidArr = new ParcelUuid[2];
        ParcelUuid parcelUuid = null;
        parcelUuidArr[0] = uuid != null ? new ParcelUuid(uuid) : null;
        if (uuid2 != null) {
            parcelUuid = new ParcelUuid(uuid2);
        }
        parcelUuidArr[1] = parcelUuid;
        this.buttonlessDfuWithBondSharingUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForButtonlessDfuWithoutBondSharing(UUID uuid, UUID uuid2) {
        ParcelUuid[] parcelUuidArr = new ParcelUuid[2];
        ParcelUuid parcelUuid = null;
        parcelUuidArr[0] = uuid != null ? new ParcelUuid(uuid) : null;
        if (uuid2 != null) {
            parcelUuid = new ParcelUuid(uuid2);
        }
        parcelUuidArr[1] = parcelUuid;
        this.buttonlessDfuWithoutBondSharingUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setZip(Uri uri) {
        return init(uri, null, 0, 0, "application/zip");
    }

    public DfuServiceInitiator setZip(String str) {
        return init(null, str, 0, 0, "application/zip");
    }

    public DfuServiceInitiator setZip(int i) {
        return init(null, null, i, 0, "application/zip");
    }

    public DfuServiceInitiator setZip(Uri uri, String str) {
        return init(uri, str, 0, 0, "application/zip");
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, Uri uri) {
        if (i != 0) {
            return init(uri, null, 0, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, String str) {
        if (i != 0) {
            return init(null, str, 0, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, Uri uri, String str) {
        if (i != 0) {
            return init(uri, str, 0, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, int i2) {
        if (i != 0) {
            return init(null, null, i2, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(Uri uri) {
        return init(uri, null, 0);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(String str) {
        return init(null, str, 0);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(int i) {
        return init(null, null, i);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(Uri uri, String str) {
        return init(uri, str, 0);
    }

    public DfuServiceController start(Context context, Class<? extends DfuBaseService> cls) {
        if (this.fileType != -1) {
            Intent intent = new Intent(context, cls);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.deviceAddress);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", this.deviceName);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION", this.disableNotification);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE", this.startAsForegroundService);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE", this.mimeType);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE", this.fileType);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI", this.fileUri);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH", this.filePath);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID", this.fileResId);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI", this.initFileUri);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH", this.initFilePath);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID", this.initFileResId);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", this.keepBond);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND", this.restoreBond);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU", this.forceDfu);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME", this.disableResume);
            int i = this.mtu;
            if (i > 0) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_MTU", i);
            }
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU", this.currentMtu);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU", this.enableUnsafeExperimentalButtonlessDfu);
            Boolean bool = this.packetReceiptNotificationsEnabled;
            if (bool != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED", bool);
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE", this.numberOfPackets);
            }
            Parcelable[] parcelableArr = this.legacyDfuUuids;
            if (parcelableArr != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU", parcelableArr);
            }
            Parcelable[] parcelableArr2 = this.secureDfuUuids;
            if (parcelableArr2 != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU", parcelableArr2);
            }
            Parcelable[] parcelableArr3 = this.experimentalButtonlessDfuUuids;
            if (parcelableArr3 != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU", parcelableArr3);
            }
            Parcelable[] parcelableArr4 = this.buttonlessDfuWithoutBondSharingUuids;
            if (parcelableArr4 != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING", parcelableArr4);
            }
            Parcelable[] parcelableArr5 = this.buttonlessDfuWithBondSharingUuids;
            if (parcelableArr5 != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING", parcelableArr5);
            }
            if (Build.VERSION.SDK_INT < 26 || !this.startAsForegroundService) {
                context.startService(intent);
            } else {
                context.startForegroundService(intent);
            }
            return new DfuServiceController(context);
        }
        throw new UnsupportedOperationException("You must specify the firmware file before starting the service");
    }

    private DfuServiceInitiator init(Uri uri, String str, int i) {
        if (!"application/zip".equals(this.mimeType)) {
            this.initFileUri = uri;
            this.initFilePath = str;
            this.initFileResId = i;
            return this;
        }
        throw new InvalidParameterException("Init file must be located inside the ZIP");
    }

    private DfuServiceInitiator init(Uri uri, String str, int i, int i2, String str2) {
        this.fileUri = uri;
        this.filePath = str;
        this.fileResId = i;
        this.fileType = i2;
        this.mimeType = str2;
        if ("application/zip".equals(str2)) {
            this.initFileUri = null;
            this.initFilePath = null;
            this.initFileResId = 0;
        }
        return this;
    }

    public static void createDfuNotificationChannel(Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("dfu", context.getString(R.string.dfu_channel_name), 2);
        notificationChannel.setDescription(context.getString(R.string.dfu_channel_description));
        notificationChannel.setShowBadge(false);
        notificationChannel.setLockscreenVisibility(1);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
