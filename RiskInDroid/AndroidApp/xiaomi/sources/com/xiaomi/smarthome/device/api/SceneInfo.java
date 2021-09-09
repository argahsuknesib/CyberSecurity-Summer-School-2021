package com.xiaomi.smarthome.device.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SceneInfo implements Parcelable {
    public static final Parcelable.Creator<SceneInfo> CREATOR = new Parcelable.Creator<SceneInfo>() {
        /* class com.xiaomi.smarthome.device.api.SceneInfo.AnonymousClass1 */

        public final SceneInfo createFromParcel(Parcel parcel) {
            return new SceneInfo(parcel);
        }

        public final SceneInfo[] newArray(int i) {
            return new SceneInfo[i];
        }
    };
    public List<SceneAction> mActions;
    public List<ConditionDevice> mConditionDevice;
    public boolean mEnable;
    @Deprecated
    public SceneLaunch mLaunch;
    public List<SceneLaunch> mLaunchList;
    public String mName;
    public int mRecommId;
    @Deprecated
    public int mSceneId;
    public String mSceneIdV2;
    public int mStatus;
    public int mType;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSceneId);
        parcel.writeString(this.mSceneIdV2);
        parcel.writeInt(this.mRecommId);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mEnable ? 1 : 0);
        parcel.writeValue(this.mLaunch);
        parcel.writeList(this.mLaunchList);
        parcel.writeList(this.mActions);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mStatus);
    }

    public SceneInfo() {
    }

    public SceneInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    /* access modifiers changed from: package-private */
    public void readFromParcel(Parcel parcel) {
        boolean z = false;
        try {
            this.mSceneId = parcel.readInt();
        } catch (Exception unused) {
            this.mSceneId = 0;
        }
        this.mSceneIdV2 = parcel.readString();
        this.mRecommId = parcel.readInt();
        this.mName = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        }
        this.mEnable = z;
        try {
            this.mLaunch = (SceneLaunch) parcel.readValue(SceneLaunch.class.getClassLoader());
        } catch (Exception unused2) {
            this.mLaunch = null;
        }
        this.mLaunchList = new ArrayList();
        try {
            parcel.readList(this.mLaunchList, SceneLaunch.class.getClassLoader());
        } catch (Exception unused3) {
        }
        this.mActions = new ArrayList();
        try {
            parcel.readList(this.mActions, SceneAction.class.getClassLoader());
        } catch (Exception unused4) {
        }
        this.mType = parcel.readInt();
        this.mStatus = parcel.readInt();
    }

    public static class SceneLaunch implements Parcelable {
        public static final Parcelable.Creator<SceneLaunch> CREATOR = new Parcelable.Creator<SceneLaunch>() {
            /* class com.xiaomi.smarthome.device.api.SceneInfo.SceneLaunch.AnonymousClass1 */

            public final SceneLaunch createFromParcel(Parcel parcel) {
                return new SceneLaunch(parcel);
            }

            public final SceneLaunch[] newArray(int i) {
                return new SceneLaunch[i];
            }
        };
        public String mDeviceModel;
        public String mDid;
        public String mEventString;
        public Object mEventValue;
        public String mExtra;
        public String mLaunchName;
        public int mLaunchType;

        public int describeContents() {
            return 0;
        }

        public SceneLaunch() {
        }

        public SceneLaunch(Parcel parcel) {
            this.mLaunchType = parcel.readInt();
            this.mLaunchName = parcel.readString();
            this.mDeviceModel = parcel.readString();
            this.mEventString = parcel.readString();
            try {
                this.mEventValue = parcel.readValue(ClassLoader.getSystemClassLoader());
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mDid = parcel.readString();
            this.mExtra = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mLaunchType);
            parcel.writeString(this.mLaunchName);
            parcel.writeString(this.mDeviceModel);
            parcel.writeString(this.mEventString);
            Object obj = this.mEventValue;
            if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
                parcel.writeValue(this.mEventValue.toString());
            } else {
                try {
                    parcel.writeValue(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            parcel.writeString(this.mDid);
            parcel.writeString(this.mExtra);
        }
    }

    public static class SceneAction implements Parcelable {
        public static final Parcelable.Creator<SceneAction> CREATOR = new Parcelable.Creator<SceneAction>() {
            /* class com.xiaomi.smarthome.device.api.SceneInfo.SceneAction.AnonymousClass1 */

            public final SceneAction createFromParcel(Parcel parcel) {
                return new SceneAction(parcel);
            }

            public final SceneAction[] newArray(int i) {
                return new SceneAction[i];
            }
        };
        public String mActionName;
        public String mActionString;
        public int mActionType;
        public Object mActionValue;
        public int mDelayTime;
        public String mDeviceModel;
        public String mDeviceName;
        public String mDid;
        public String mExtra;

        public int describeContents() {
            return 0;
        }

        public SceneAction() {
        }

        public SceneAction(Parcel parcel) {
            this.mDeviceName = parcel.readString();
            this.mDeviceModel = parcel.readString();
            this.mActionName = parcel.readString();
            this.mActionString = parcel.readString();
            try {
                this.mActionValue = parcel.readValue(ClassLoader.getSystemClassLoader());
            } catch (Exception unused) {
            }
            this.mDid = parcel.readString();
            this.mExtra = parcel.readString();
            this.mDelayTime = parcel.readInt();
            this.mActionType = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mDeviceName);
            parcel.writeString(this.mDeviceModel);
            parcel.writeString(this.mActionName);
            parcel.writeString(this.mActionString);
            Object obj = this.mActionValue;
            if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
                parcel.writeValue(this.mActionValue.toString());
            } else {
                parcel.writeValue(obj);
            }
            parcel.writeString(this.mDid);
            parcel.writeString(this.mExtra);
            parcel.writeInt(this.mDelayTime);
            parcel.writeInt(this.mActionType);
        }
    }

    public static class ConditionDevice {
        public String did;
        public String model;

        public ConditionDevice(String str, String str2) {
            this.did = str;
            this.model = str2;
        }
    }
}
