package com.xiaomi.smarthome.device.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class RecommendSceneItem implements Parcelable {
    public static final Parcelable.Creator<RecommendSceneItem> CREATOR = new Parcelable.Creator<RecommendSceneItem>() {
        /* class com.xiaomi.smarthome.device.api.RecommendSceneItem.AnonymousClass1 */

        public final RecommendSceneItem createFromParcel(Parcel parcel) {
            return new RecommendSceneItem(parcel);
        }

        public final RecommendSceneItem[] newArray(int i) {
            return new RecommendSceneItem[i];
        }
    };
    public boolean mEnablePush;
    public String mIcon;
    public String mName;
    public int mRecommId;
    public double mRecommLevel;
    public RemommendSceneAction[] mRecommendActionList;
    public RemommendSceneCondition[] mRecommendConditionList;
    public boolean mShowInMainPage;
    public int mStatus;

    public int describeContents() {
        return 0;
    }

    public static class Key {
        public String mKey;
        public String mName;
        public Object mValues;

        public void writeToParcel(Parcel parcel) {
            parcel.writeString(this.mKey);
            parcel.writeValue(this.mValues);
            parcel.writeString(this.mName);
        }

        public void readFromParcel(Parcel parcel) {
            this.mKey = parcel.readString();
            this.mValues = parcel.readValue(ClassLoader.getSystemClassLoader());
            this.mName = parcel.readString();
        }
    }

    public static class RemommendSceneCondition {
        public Boolean mAddAllDevice = Boolean.FALSE;
        public String mConditionName;
        public String[] mDeviceModels;
        public Key[] mKeys;
        public String mProductId;
        public String mSrc;
        public int tempId;

        public void writeToParcel(Parcel parcel) {
            parcel.writeStringArray(this.mDeviceModels);
            parcel.writeString(this.mConditionName);
            Key[] keyArr = this.mKeys;
            int i = 0;
            if (keyArr != null) {
                parcel.writeInt(keyArr.length);
                while (true) {
                    Key[] keyArr2 = this.mKeys;
                    if (i >= keyArr2.length) {
                        break;
                    }
                    keyArr2[i].writeToParcel(parcel);
                    i++;
                }
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.mProductId);
            parcel.writeValue(this.mAddAllDevice);
            parcel.writeString(this.mSrc);
        }

        public void readFromParcel(Parcel parcel) {
            this.mDeviceModels = parcel.createStringArray();
            this.mConditionName = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt != 0) {
                this.mKeys = new Key[readInt];
                for (int i = 0; i < readInt; i++) {
                    this.mKeys[i] = new Key();
                    this.mKeys[i].readFromParcel(parcel);
                }
            }
            this.mProductId = parcel.readString();
            this.mAddAllDevice = (Boolean) parcel.readValue(ClassLoader.getSystemClassLoader());
            this.mSrc = parcel.readString();
        }
    }

    public static class RemommendSceneAction {
        public String mActionName;
        public Boolean mAddAllDevice;
        public String[] mDeviceModels;
        public Key[] mKeys;
        public String mProductId;
        public int tempId;

        public void writeToParcel(Parcel parcel) {
            parcel.writeStringArray(this.mDeviceModels);
            parcel.writeString(this.mActionName);
            Key[] keyArr = this.mKeys;
            int i = 0;
            if (keyArr != null) {
                parcel.writeInt(keyArr.length);
                while (true) {
                    Key[] keyArr2 = this.mKeys;
                    if (i >= keyArr2.length) {
                        break;
                    }
                    keyArr2[i].writeToParcel(parcel);
                    i++;
                }
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.mProductId);
            parcel.writeValue(this.mAddAllDevice);
        }

        public void readFromParcel(Parcel parcel) {
            this.mDeviceModels = parcel.createStringArray();
            this.mActionName = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt != 0) {
                this.mKeys = new Key[readInt];
                for (int i = 0; i < readInt; i++) {
                    this.mKeys[i] = new Key();
                    this.mKeys[i].readFromParcel(parcel);
                }
            }
            this.mProductId = parcel.readString();
            this.mAddAllDevice = (Boolean) parcel.readValue(ClassLoader.getSystemClassLoader());
        }

        public String toString() {
            return "RemommendSceneAction{mDeviceModels=" + Arrays.toString(this.mDeviceModels) + ", mActionName='" + this.mActionName + '\'' + ", mKeys=" + Arrays.toString(this.mKeys) + ", mProductId='" + this.mProductId + '\'' + ", mAddAllDevice=" + this.mAddAllDevice + ", tempId=" + this.tempId + '}';
        }
    }

    public RecommendSceneItem(Parcel parcel) {
        this.mRecommId = parcel.readInt();
        this.mName = parcel.readString();
        this.mIcon = parcel.readString();
        this.mRecommLevel = parcel.readDouble();
        this.mEnablePush = ((Boolean) parcel.readValue(ClassLoader.getSystemClassLoader())).booleanValue();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.mRecommendConditionList = new RemommendSceneCondition[readInt];
            for (int i = 0; i < readInt; i++) {
                this.mRecommendConditionList[i] = new RemommendSceneCondition();
                this.mRecommendConditionList[i].readFromParcel(parcel);
            }
        }
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            this.mRecommendActionList = new RemommendSceneAction[readInt2];
            for (int i2 = 0; i2 < readInt2; i2++) {
                this.mRecommendActionList[i2] = new RemommendSceneAction();
                this.mRecommendActionList[i2].readFromParcel(parcel);
            }
        }
        this.mStatus = parcel.readInt();
    }

    public RecommendSceneItem() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRecommId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mIcon);
        parcel.writeDouble(this.mRecommLevel);
        parcel.writeValue(Boolean.valueOf(this.mEnablePush));
        parcel.writeInt(this.mRecommendConditionList.length);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            RemommendSceneCondition[] remommendSceneConditionArr = this.mRecommendConditionList;
            if (i3 >= remommendSceneConditionArr.length) {
                break;
            }
            remommendSceneConditionArr[i3].writeToParcel(parcel);
            i3++;
        }
        parcel.writeInt(this.mRecommendActionList.length);
        while (true) {
            RemommendSceneAction[] remommendSceneActionArr = this.mRecommendActionList;
            if (i2 < remommendSceneActionArr.length) {
                remommendSceneActionArr[i2].writeToParcel(parcel);
                i2++;
            } else {
                parcel.writeInt(this.mStatus);
                return;
            }
        }
    }

    public String toString() {
        return "RecommendSceneItem{mRecommId=" + this.mRecommId + ", mName='" + this.mName + '\'' + ", mRecommendConditionList=" + Arrays.toString(this.mRecommendConditionList) + ", mRecommendActionList=" + Arrays.toString(this.mRecommendActionList) + ", mRecommLevel=" + this.mRecommLevel + ", mEnablePush=" + this.mEnablePush + ", mShowInMainPage=" + this.mShowInMainPage + ", mIcon='" + this.mIcon + '\'' + ", mStatus=" + this.mStatus + '}';
    }
}
