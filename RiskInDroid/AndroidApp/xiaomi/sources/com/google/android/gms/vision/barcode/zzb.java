package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class zzb implements Parcelable.Creator<Barcode> {
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        Point[] pointArr = null;
        Barcode.Email email = null;
        Barcode.Phone phone = null;
        Barcode.Sms sms = null;
        Barcode.WiFi wiFi = null;
        Barcode.UrlBookmark urlBookmark = null;
        Barcode.GeoPoint geoPoint = null;
        Barcode.CalendarEvent calendarEvent = null;
        Barcode.ContactInfo contactInfo = null;
        Barcode.DriverLicense driverLicense = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 6:
                    pointArr = SafeParcelReader.createTypedArray(parcel2, readHeader, Point.CREATOR);
                    break;
                case 7:
                    email = SafeParcelReader.createParcelable(parcel2, readHeader, Barcode.Email.CREATOR);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    phone = SafeParcelReader.createParcelable(parcel2, readHeader, Barcode.Phone.CREATOR);
                    break;
                case 9:
                    sms = SafeParcelReader.createParcelable(parcel2, readHeader, Barcode.Sms.CREATOR);
                    break;
                case 10:
                    wiFi = SafeParcelReader.createParcelable(parcel2, readHeader, Barcode.WiFi.CREATOR);
                    break;
                case 11:
                    urlBookmark = SafeParcelReader.createParcelable(parcel2, readHeader, Barcode.UrlBookmark.CREATOR);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    geoPoint = SafeParcelReader.createParcelable(parcel2, readHeader, Barcode.GeoPoint.CREATOR);
                    break;
                case 13:
                    calendarEvent = SafeParcelReader.createParcelable(parcel2, readHeader, Barcode.CalendarEvent.CREATOR);
                    break;
                case 14:
                    contactInfo = SafeParcelReader.createParcelable(parcel2, readHeader, Barcode.ContactInfo.CREATOR);
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    driverLicense = SafeParcelReader.createParcelable(parcel2, readHeader, Barcode.DriverLicense.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new Barcode(i, str, str2, i2, pointArr, email, phone, sms, wiFi, urlBookmark, geoPoint, calendarEvent, contactInfo, driverLicense);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Barcode[i];
    }
}
