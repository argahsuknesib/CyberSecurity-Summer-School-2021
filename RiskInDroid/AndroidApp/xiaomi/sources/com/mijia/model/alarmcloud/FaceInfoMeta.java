package com.mijia.model.alarmcloud;

import android.os.Parcel;
import android.os.Parcelable;

public class FaceInfoMeta implements Parcelable {
    public static final Parcelable.Creator<FaceInfoMeta> CREATOR = new Parcelable.Creator<FaceInfoMeta>() {
        /* class com.mijia.model.alarmcloud.FaceInfoMeta.AnonymousClass1 */

        public final FaceInfoMeta createFromParcel(Parcel parcel) {
            return new FaceInfoMeta(parcel);
        }

        public final FaceInfoMeta[] newArray(int i) {
            return new FaceInfoMeta[i];
        }
    };
    public int age;
    public float ageConfidence;
    public String faceId;
    public String figureId;
    public String figureInfo;
    public String figureName;
    public int gender;
    public float genderConfidence;
    public boolean matched;
    public float score;
    public boolean wearGlasses;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.faceId);
        parcel.writeString(this.figureId);
        parcel.writeFloat(this.score);
        parcel.writeFloat(this.ageConfidence);
        parcel.writeFloat(this.genderConfidence);
        parcel.writeString(this.figureInfo);
        parcel.writeInt(this.gender);
        parcel.writeByte(this.wearGlasses ? (byte) 1 : 0);
        parcel.writeByte(this.matched ? (byte) 1 : 0);
        parcel.writeString(this.figureName);
        parcel.writeInt(this.age);
    }

    public FaceInfoMeta() {
    }

    protected FaceInfoMeta(Parcel parcel) {
        this.faceId = parcel.readString();
        this.figureId = parcel.readString();
        this.score = parcel.readFloat();
        this.ageConfidence = parcel.readFloat();
        this.genderConfidence = parcel.readFloat();
        this.figureInfo = parcel.readString();
        this.gender = parcel.readInt();
        boolean z = true;
        this.wearGlasses = parcel.readByte() != 0;
        this.matched = parcel.readByte() == 0 ? false : z;
        this.figureName = parcel.readString();
        this.age = parcel.readInt();
    }
}
