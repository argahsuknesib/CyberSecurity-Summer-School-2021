package no.nordicsemi.android.dfu;

import android.content.Intent;
import android.os.ParcelUuid;
import android.os.Parcelable;

class UuidHelper {
    UuidHelper() {
    }

    static void assignCustomUuids(Intent intent) {
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU");
        if (parcelableArrayExtra == null || parcelableArrayExtra.length != 4) {
            LegacyDfuImpl.DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            LegacyDfuImpl.DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            LegacyDfuImpl.DFU_PACKET_UUID = LegacyDfuImpl.DEFAULT_DFU_PACKET_UUID;
            LegacyDfuImpl.DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
            LegacyButtonlessDfuImpl.DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            LegacyButtonlessDfuImpl.DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            LegacyButtonlessDfuImpl.DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
        } else {
            LegacyDfuImpl.DFU_SERVICE_UUID = parcelableArrayExtra[0] != null ? ((ParcelUuid) parcelableArrayExtra[0]).getUuid() : LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            LegacyDfuImpl.DFU_CONTROL_POINT_UUID = parcelableArrayExtra[1] != null ? ((ParcelUuid) parcelableArrayExtra[1]).getUuid() : LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            LegacyDfuImpl.DFU_PACKET_UUID = parcelableArrayExtra[2] != null ? ((ParcelUuid) parcelableArrayExtra[2]).getUuid() : LegacyDfuImpl.DEFAULT_DFU_PACKET_UUID;
            LegacyDfuImpl.DFU_VERSION_UUID = parcelableArrayExtra[3] != null ? ((ParcelUuid) parcelableArrayExtra[3]).getUuid() : LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
            LegacyButtonlessDfuImpl.DFU_SERVICE_UUID = LegacyDfuImpl.DFU_SERVICE_UUID;
            LegacyButtonlessDfuImpl.DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DFU_CONTROL_POINT_UUID;
            LegacyButtonlessDfuImpl.DFU_VERSION_UUID = LegacyDfuImpl.DFU_VERSION_UUID;
        }
        Parcelable[] parcelableArrayExtra2 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU");
        if (parcelableArrayExtra2 == null || parcelableArrayExtra2.length != 3) {
            SecureDfuImpl.DFU_SERVICE_UUID = SecureDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            SecureDfuImpl.DFU_CONTROL_POINT_UUID = SecureDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            SecureDfuImpl.DFU_PACKET_UUID = SecureDfuImpl.DEFAULT_DFU_PACKET_UUID;
        } else {
            SecureDfuImpl.DFU_SERVICE_UUID = parcelableArrayExtra2[0] != null ? ((ParcelUuid) parcelableArrayExtra2[0]).getUuid() : SecureDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            SecureDfuImpl.DFU_CONTROL_POINT_UUID = parcelableArrayExtra2[1] != null ? ((ParcelUuid) parcelableArrayExtra2[1]).getUuid() : SecureDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            SecureDfuImpl.DFU_PACKET_UUID = parcelableArrayExtra2[2] != null ? ((ParcelUuid) parcelableArrayExtra2[2]).getUuid() : SecureDfuImpl.DEFAULT_DFU_PACKET_UUID;
        }
        Parcelable[] parcelableArrayExtra3 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU");
        if (parcelableArrayExtra3 == null || parcelableArrayExtra3.length != 2) {
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_UUID = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
        } else {
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = parcelableArrayExtra3[0] != null ? ((ParcelUuid) parcelableArrayExtra3[0]).getUuid() : ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_UUID = parcelableArrayExtra3[1] != null ? ((ParcelUuid) parcelableArrayExtra3[1]).getUuid() : ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
        }
        Parcelable[] parcelableArrayExtra4 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING");
        if (parcelableArrayExtra4 == null || parcelableArrayExtra4.length != 2) {
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_UUID = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
        } else {
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = parcelableArrayExtra4[0] != null ? ((ParcelUuid) parcelableArrayExtra4[0]).getUuid() : ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_UUID = parcelableArrayExtra4[1] != null ? ((ParcelUuid) parcelableArrayExtra4[1]).getUuid() : ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
        }
        Parcelable[] parcelableArrayExtra5 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING");
        if (parcelableArrayExtra5 == null || parcelableArrayExtra5.length != 2) {
            ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_UUID = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
            return;
        }
        ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = parcelableArrayExtra5[0] != null ? ((ParcelUuid) parcelableArrayExtra5[0]).getUuid() : ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
        ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_UUID = parcelableArrayExtra5[1] != null ? ((ParcelUuid) parcelableArrayExtra5[1]).getUuid() : ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
    }
}
