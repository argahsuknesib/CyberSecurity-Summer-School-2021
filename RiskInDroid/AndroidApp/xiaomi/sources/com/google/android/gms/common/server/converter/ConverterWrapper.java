package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

@SafeParcelable.Class(creator = "ConverterWrapperCreator")
public class ConverterWrapper extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConverterWrapper> CREATOR = new ConverterWrapperCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getStringToIntConverter", id = 2)
    private final StringToIntConverter zzwd;

    @SafeParcelable.Constructor
    ConverterWrapper(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) StringToIntConverter stringToIntConverter) {
        this.zzal = i;
        this.zzwd = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.zzal = 1;
        this.zzwd = stringToIntConverter;
    }

    public static ConverterWrapper wrap(FastJsonResponse.FieldConverter<?, ?> fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public FastJsonResponse.FieldConverter<?, ?> unwrap() {
        StringToIntConverter stringToIntConverter = this.zzwd;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzwd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
