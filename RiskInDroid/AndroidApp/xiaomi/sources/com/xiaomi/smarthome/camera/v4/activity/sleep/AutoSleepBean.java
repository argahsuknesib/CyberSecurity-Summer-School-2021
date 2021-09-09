package com.xiaomi.smarthome.camera.v4.activity.sleep;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;

public class AutoSleepBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AutoSleepBean> CREATOR = new Parcelable.Creator<AutoSleepBean>() {
        /* class com.xiaomi.smarthome.camera.v4.activity.sleep.AutoSleepBean.AnonymousClass1 */

        public final AutoSleepBean createFromParcel(Parcel parcel) {
            return new AutoSleepBean(parcel);
        }

        public final AutoSleepBean[] newArray(int i) {
            return new AutoSleepBean[i];
        }
    };
    public int day;
    public int hour;
    public int minute;
    public int month;
    public boolean[] weeks = new boolean[7];

    public int describeContents() {
        return 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    public AutoSleepBean() {
        Calendar instance = Calendar.getInstance();
        this.day = instance.get(5);
        this.month = instance.get(2) + 1;
        this.hour = instance.get(11);
        this.minute = instance.get(12);
        Arrays.fill(this.weeks, false);
    }

    protected AutoSleepBean(Parcel parcel) {
        this.minute = parcel.readInt();
        this.hour = parcel.readInt();
        this.day = parcel.readInt();
        this.month = parcel.readInt();
        this.weeks = parcel.createBooleanArray();
    }

    public int getRepeatType() {
        int i = 0;
        if (this.day != -1) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.weeks;
            if (i >= zArr.length) {
                break;
            }
            if (zArr[i]) {
                i2 |= 1 << i;
            }
            i++;
        }
        if (i2 == 62) {
            return 2;
        }
        if (i2 == 65) {
            return 3;
        }
        if (i2 != 127) {
            return 4;
        }
        return 1;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    public void setRepeat(int i) {
        if (i == 0) {
            Calendar instance = Calendar.getInstance();
            this.day = instance.get(5);
            this.month = instance.get(2) + 1;
            Arrays.fill(this.weeks, false);
            return;
        }
        this.day = -1;
        this.month = -1;
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.weeks;
            if (i2 < zArr.length) {
                zArr[i2] = ((1 << i2) & i) > 0;
                i2++;
            } else {
                return;
            }
        }
    }

    public void setWeekday(int i, boolean z) {
        this.day = -1;
        this.month = -1;
        this.weeks[i] = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.minute);
        parcel.writeInt(this.hour);
        parcel.writeInt(this.day);
        parcel.writeInt(this.month);
        parcel.writeBooleanArray(this.weeks);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AutoSleepBean)) {
            return false;
        }
        AutoSleepBean autoSleepBean = (AutoSleepBean) obj;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean[] zArr = this.weeks;
            if (i >= zArr.length) {
                break;
            }
            if (zArr[i]) {
                i2 |= 1 << i;
            }
            if (autoSleepBean.weeks[i]) {
                i3 |= 1 << i;
            }
            i++;
        }
        if (this.minute == autoSleepBean.minute && this.hour == autoSleepBean.hour && this.day == autoSleepBean.day && this.month == autoSleepBean.month && i2 == i3) {
            return true;
        }
        return false;
    }

    public void shiftWeekday(int i) {
        if (this.day == -1 && this.month == -1) {
            boolean[] zArr = this.weeks;
            int length = i % zArr.length;
            int i2 = 0;
            int i3 = 0;
            for (int length2 = zArr.length - 1; i3 < length2; length2--) {
                boolean[] zArr2 = this.weeks;
                boolean z = zArr2[i3];
                zArr2[i3] = zArr2[length2];
                zArr2[length2] = z;
                i3++;
            }
            for (int i4 = length - 1; i2 < i4; i4--) {
                boolean[] zArr3 = this.weeks;
                boolean z2 = zArr3[i2];
                zArr3[i2] = zArr3[i4];
                zArr3[i4] = z2;
                i2++;
            }
            for (int length3 = this.weeks.length - 1; length < length3; length3--) {
                boolean[] zArr4 = this.weeks;
                boolean z3 = zArr4[length];
                zArr4[length] = zArr4[length3];
                zArr4[length3] = z3;
                length++;
            }
        }
    }

    public Object clone() {
        AutoSleepBean autoSleepBean;
        CloneNotSupportedException e;
        try {
            autoSleepBean = (AutoSleepBean) super.clone();
            try {
                autoSleepBean.minute = this.minute;
                autoSleepBean.hour = this.hour;
                autoSleepBean.day = this.day;
                autoSleepBean.month = this.month;
                autoSleepBean.weeks = new boolean[7];
                System.arraycopy(this.weeks, 0, autoSleepBean.weeks, 0, this.weeks.length);
            } catch (CloneNotSupportedException e2) {
                e = e2;
            }
        } catch (CloneNotSupportedException e3) {
            CloneNotSupportedException cloneNotSupportedException = e3;
            autoSleepBean = null;
            e = cloneNotSupportedException;
            e.printStackTrace();
            return autoSleepBean;
        }
        return autoSleepBean;
    }
}
