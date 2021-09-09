package com.mijia.model.alarmcloud;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class FileIdMetaResult implements Parcelable {
    public static final Parcelable.Creator<FileIdMetaResult> CREATOR = new Parcelable.Creator<FileIdMetaResult>() {
        /* class com.mijia.model.alarmcloud.FileIdMetaResult.AnonymousClass1 */

        public final FileIdMetaResult createFromParcel(Parcel parcel) {
            return new FileIdMetaResult(parcel);
        }

        public final FileIdMetaResult[] newArray(int i) {
            return new FileIdMetaResult[i];
        }
    };
    public boolean babyCrying;
    public List<FaceInfoMeta> faceInfoMetas;
    public String fileId;
    public int offset;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FileIdMetaResult{babyCrying=" + this.babyCrying + ", fileId='" + this.fileId + '\'' + ", offset=" + this.offset + ", faceInfoMetas=" + this.faceInfoMetas + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.babyCrying ? (byte) 1 : 0);
        parcel.writeString(this.fileId);
        parcel.writeInt(this.offset);
        parcel.writeTypedList(this.faceInfoMetas);
    }

    public FileIdMetaResult() {
    }

    protected FileIdMetaResult(Parcel parcel) {
        this.babyCrying = parcel.readByte() != 0;
        this.fileId = parcel.readString();
        this.offset = parcel.readInt();
        this.faceInfoMetas = parcel.createTypedArrayList(FaceInfoMeta.CREATOR);
    }
}
