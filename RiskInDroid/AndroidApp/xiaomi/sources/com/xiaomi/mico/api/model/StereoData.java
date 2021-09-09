package com.xiaomi.mico.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.xiaomi.mico.api.model.LanGroupInfo;
import java.util.List;

public class StereoData {
    @SerializedName(alternate = {"lanDeviceInfoList"}, value = "lanInfo")
    public List<LanGroupInfo.LanGroup> lanDeviceInfoList;
    @SerializedName(alternate = {"multiRoom"}, value = "multiRoomInfo")
    public MultiRoomData multiRoom;
    @SerializedName(alternate = {"stereoList"}, value = "stereoInfo")
    public List<StereoGroup> stereoList;

    public static class StereoGroup implements Parcelable {
        public static final Parcelable.Creator<StereoGroup> CREATOR = new Parcelable.Creator<StereoGroup>() {
            /* class com.xiaomi.mico.api.model.StereoData.StereoGroup.AnonymousClass1 */

            public final StereoGroup createFromParcel(Parcel parcel) {
                return new StereoGroup(parcel);
            }

            public final StereoGroup[] newArray(int i) {
                return new StereoGroup[i];
            }
        };
        public int audioTrackStatus = 1;
        public String groupId;
        public String groupName;
        public String leftDeviceHardware;
        public String leftDeviceId;
        public String leftDeviceName;
        public String leftDeviceResource;
        public boolean leftUnknownError;
        public String rightDeviceHardware;
        public String rightDeviceId;
        public String rightDeviceName;
        public String rightDeviceResource;
        public boolean rightUnknownError;
        public boolean select;
        public String server;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.groupId);
            parcel.writeInt(this.audioTrackStatus);
            parcel.writeString(this.groupName);
            parcel.writeString(this.leftDeviceId);
            parcel.writeString(this.leftDeviceHardware);
            parcel.writeString(this.leftDeviceResource);
            parcel.writeString(this.leftDeviceName);
            parcel.writeString(this.rightDeviceId);
            parcel.writeString(this.rightDeviceHardware);
            parcel.writeString(this.rightDeviceResource);
            parcel.writeString(this.rightDeviceName);
            parcel.writeString(this.server);
            parcel.writeByte(this.leftUnknownError ? (byte) 1 : 0);
            parcel.writeByte(this.rightUnknownError ? (byte) 1 : 0);
        }

        public StereoGroup() {
        }

        protected StereoGroup(Parcel parcel) {
            boolean z = true;
            this.groupId = parcel.readString();
            this.audioTrackStatus = parcel.readInt();
            this.groupName = parcel.readString();
            this.leftDeviceId = parcel.readString();
            this.leftDeviceHardware = parcel.readString();
            this.leftDeviceResource = parcel.readString();
            this.leftDeviceName = parcel.readString();
            this.rightDeviceId = parcel.readString();
            this.rightDeviceHardware = parcel.readString();
            this.rightDeviceResource = parcel.readString();
            this.rightDeviceName = parcel.readString();
            this.server = parcel.readString();
            this.leftUnknownError = parcel.readByte() != 0;
            this.rightUnknownError = parcel.readByte() == 0 ? false : z;
        }
    }
}
