package com.xiaomi.miplay.audioclient;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class MediaMetaData implements Parcelable {
    public static final Parcelable.Creator<MediaMetaData> CREATOR = new Parcelable.Creator<MediaMetaData>() {
        /* class com.xiaomi.miplay.audioclient.MediaMetaData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaMetaData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MediaMetaData(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6038O000000o;
    public String O00000Oo;
    public long O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public int O0000O0o;
    public long O0000OOo;
    public long O0000Oo;
    public Bitmap O0000Oo0;

    public int describeContents() {
        return 0;
    }

    public MediaMetaData() {
        this.f6038O000000o = "";
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = 0;
        this.O00000oO = "";
        this.O00000oo = "";
        this.O0000O0o = 0;
        this.O0000OOo = 0;
        this.O0000Oo0 = null;
        this.O0000Oo = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediaMetaData{mArtist='");
        sb.append(this.f6038O000000o);
        sb.append('\'');
        sb.append(", mAlbum='");
        sb.append(this.O00000Oo);
        sb.append('\'');
        sb.append(", mTitle='");
        sb.append(this.O00000o0);
        sb.append('\'');
        sb.append(", mDuration=");
        sb.append(this.O00000o);
        sb.append(", mId='");
        sb.append(this.O00000oO);
        sb.append('\'');
        sb.append(", mCoverUrl='");
        sb.append(this.O00000oo);
        sb.append('\'');
        sb.append(", mStatus=");
        sb.append(this.O0000O0o);
        sb.append(", mVolume=");
        sb.append(this.O0000OOo);
        sb.append(", mArt=");
        sb.append(this.O0000Oo0 == null ? "null" : "valid");
        sb.append(", mPosition=");
        sb.append(this.O0000Oo);
        sb.append('}');
        return sb.toString();
    }

    protected MediaMetaData(Parcel parcel) {
        this.f6038O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readLong();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readLong();
        this.O0000Oo0 = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.O0000Oo = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6038O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeLong(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeLong(this.O0000OOo);
        parcel.writeParcelable(this.O0000Oo0, i);
        parcel.writeLong(this.O0000Oo);
    }
}
