package com.hannto.print.bean;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.SectionEntity;

public class PhotoBean extends SectionEntity implements Parcelable {
    public static final Parcelable.Creator<PhotoBean> CREATOR = new O000000o();
    public int copies;
    public int counts;
    public int height;
    public String imageId;
    public String imagePath;
    public Uri imageUri;
    public boolean isCameraView;
    public boolean isSelected;
    public long mLastModifyTimeStampt;
    public boolean mLoadSuccess;
    public int position;
    public String printUrl;
    public int size;
    public String time;
    public int uploadProgress;
    public int width;

    public static class O000000o implements Parcelable.Creator<PhotoBean> {
        public final Object createFromParcel(Parcel parcel) {
            return new PhotoBean(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoBean[i];
        }
    }

    public PhotoBean() {
        super(false, null);
        this.isSelected = false;
        this.mLoadSuccess = true;
        this.copies = 1;
        this.isCameraView = false;
        this.isCameraView = true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoBean(Parcel parcel) {
        super(false, null);
        boolean z = false;
        this.isSelected = false;
        this.mLoadSuccess = true;
        this.copies = 1;
        this.isCameraView = false;
        this.imageId = parcel.readString();
        this.imagePath = parcel.readString();
        this.isSelected = parcel.readByte() != 0;
        this.size = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.mLastModifyTimeStampt = parcel.readLong();
        this.counts = parcel.readInt();
        this.time = parcel.readString();
        this.position = parcel.readInt();
        this.copies = parcel.readInt();
        this.uploadProgress = parcel.readInt();
        this.printUrl = parcel.readString();
        this.isCameraView = parcel.readByte() != 0 ? true : z;
        this.imageUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public PhotoBean(boolean z, String str) {
        super(z, str);
        this.isSelected = false;
        this.mLoadSuccess = true;
        this.copies = 1;
        this.isCameraView = false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.imageId);
        parcel.writeString(this.imagePath);
        parcel.writeByte(this.isSelected ? (byte) 1 : 0);
        parcel.writeInt(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeLong(this.mLastModifyTimeStampt);
        parcel.writeInt(this.counts);
        parcel.writeString(this.time);
        parcel.writeInt(this.position);
        parcel.writeInt(this.copies);
        parcel.writeInt(this.uploadProgress);
        parcel.writeString(this.printUrl);
        parcel.writeByte(this.isCameraView ? (byte) 1 : 0);
        parcel.writeParcelable(this.imageUri, 0);
    }
}
