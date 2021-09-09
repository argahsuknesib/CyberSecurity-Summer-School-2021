package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

public final class zze implements Parcelable.Creator<Barcode.CalendarEvent> {
    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Barcode.CalendarDateTime calendarDateTime = null;
        Barcode.CalendarDateTime calendarDateTime2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    calendarDateTime = SafeParcelReader.createParcelable(parcel, readHeader, Barcode.CalendarDateTime.CREATOR);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    calendarDateTime2 = SafeParcelReader.createParcelable(parcel, readHeader, Barcode.CalendarDateTime.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Barcode.CalendarEvent(str, str2, str3, str4, str5, calendarDateTime, calendarDateTime2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Barcode.CalendarEvent[i];
    }
}
