package com.xiaomi.mico.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class MultiRoomData {
    public List<MultiRoomGroup> groups;
    public String userId;

    public static class MultiRoomGroup implements Parcelable, Serializable {
        public static final Parcelable.Creator<MultiRoomGroup> CREATOR = new Parcelable.Creator<MultiRoomGroup>() {
            /* class com.xiaomi.mico.api.model.MultiRoomData.MultiRoomGroup.AnonymousClass1 */

            public final MultiRoomGroup createFromParcel(Parcel parcel) {
                return new MultiRoomGroup(parcel);
            }

            public final MultiRoomGroup[] newArray(int i) {
                return new MultiRoomGroup[i];
            }
        };
        @Expose
        public String groupId;
        @Expose
        public String groupName;
        @Expose
        public int groupSwitch;
        @Expose
        public List<MultiRoomMember> members;
        @Expose
        public String server;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.groupSwitch);
            parcel.writeString(this.groupId);
            parcel.writeString(this.groupName);
            parcel.writeString(this.server);
            parcel.writeTypedList(this.members);
        }

        public MultiRoomGroup() {
        }

        protected MultiRoomGroup(Parcel parcel) {
            this.groupSwitch = parcel.readInt();
            this.groupId = parcel.readString();
            this.groupName = parcel.readString();
            this.server = parcel.readString();
            this.members = parcel.createTypedArrayList(MultiRoomMember.CREATOR);
        }
    }

    public static class MultiRoomMember implements Parcelable, Serializable {
        public static final Parcelable.Creator<MultiRoomMember> CREATOR = new Parcelable.Creator<MultiRoomMember>() {
            /* class com.xiaomi.mico.api.model.MultiRoomData.MultiRoomMember.AnonymousClass1 */

            public final MultiRoomMember createFromParcel(Parcel parcel) {
                return new MultiRoomMember(parcel);
            }

            public final MultiRoomMember[] newArray(int i) {
                return new MultiRoomMember[i];
            }
        };
        @Expose
        public String deviceId;
        @SerializedName("appId")
        @Expose
        public String hardWare;
        public String name;
        @Expose
        public String resource;
        public boolean unKnownError;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hardWare);
            parcel.writeString(this.deviceId);
            parcel.writeString(this.resource);
            parcel.writeString(this.name);
            parcel.writeByte(this.unKnownError ? (byte) 1 : 0);
        }

        public MultiRoomMember() {
        }

        protected MultiRoomMember(Parcel parcel) {
            this.hardWare = parcel.readString();
            this.deviceId = parcel.readString();
            this.resource = parcel.readString();
            this.name = parcel.readString();
            this.unKnownError = parcel.readByte() != 0;
        }
    }
}
