package com.xiaomi.smarthome.scene.model;

import _m_j.goz;
import _m_j.gsy;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class CorntabUtils {

    public static class CorntabParam implements Parcelable, Cloneable {
        public static final Parcelable.Creator<CorntabParam> CREATOR = new Parcelable.Creator<CorntabParam>() {
            /* class com.xiaomi.smarthome.scene.model.CorntabUtils.CorntabParam.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CorntabParam[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CorntabParam(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public int f11160O000000o;
        public int O00000Oo;
        public int O00000o;
        public int O00000o0;
        public int O00000oO;
        public int O00000oo;
        public boolean[] O0000O0o = new boolean[7];
        public String O0000OOo = "";

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
        public CorntabParam() {
            Calendar instance = Calendar.getInstance();
            this.O00000o = instance.get(5);
            this.O00000oO = instance.get(2) + 1;
            this.O00000o0 = instance.get(11);
            this.O00000Oo = instance.get(12);
            this.f11160O000000o = instance.get(13);
            this.O00000oo = instance.get(1);
            Arrays.fill(this.O0000O0o, false);
            this.O0000OOo = "";
        }

        public String toString() {
            return "CorntabParam----" + this.O00000oo + "year," + this.O00000oO + "month," + this.O00000o + "day," + this.O00000o0 + "hour," + this.O00000Oo + "minute," + this.f11160O000000o + "second";
        }

        public final boolean O000000o() {
            return O000000o(new CorntabParam()) < 0;
        }

        public final int O000000o(CorntabParam corntabParam) {
            int i = this.O00000oo;
            int i2 = corntabParam.O00000oo;
            if (i > i2) {
                return 1;
            }
            if (i < i2) {
                return -1;
            }
            int i3 = this.O00000oO;
            int i4 = corntabParam.O00000oO;
            if (i3 > i4) {
                return 1;
            }
            if (i3 < i4) {
                return -1;
            }
            int i5 = this.O00000o;
            int i6 = corntabParam.O00000o;
            if (i5 > i6) {
                return 1;
            }
            if (i5 < i6) {
                return -1;
            }
            int i7 = this.O00000o0;
            int i8 = corntabParam.O00000o0;
            if (i7 > i8) {
                return 1;
            }
            if (i7 < i8) {
                return -1;
            }
            int i9 = this.O00000Oo;
            int i10 = corntabParam.O00000Oo;
            if (i9 > i10) {
                return 1;
            }
            if (i9 < i10) {
                return -1;
            }
            int i11 = this.f11160O000000o;
            int i12 = corntabParam.f11160O000000o;
            if (i11 > i12) {
                return 1;
            }
            if (i11 < i12) {
                return -1;
            }
            return 0;
        }

        protected CorntabParam(Parcel parcel) {
            this.f11160O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = parcel.readInt();
            this.O00000o = parcel.readInt();
            this.O00000oO = parcel.readInt();
            this.O00000oo = parcel.readInt();
            this.O0000O0o = parcel.createBooleanArray();
            this.O0000OOo = parcel.readString();
        }

        public Object clone() {
            try {
                CorntabParam corntabParam = (CorntabParam) super.clone();
                try {
                    corntabParam.f11160O000000o = this.f11160O000000o;
                    corntabParam.O00000Oo = this.O00000Oo;
                    corntabParam.O00000o0 = this.O00000o0;
                    corntabParam.O00000o = this.O00000o;
                    corntabParam.O00000oO = this.O00000oO;
                    corntabParam.O00000oo = this.O00000oo;
                    corntabParam.O0000O0o = new boolean[7];
                    System.arraycopy(this.O0000O0o, 0, corntabParam.O0000O0o, 0, this.O0000O0o.length);
                    corntabParam.O0000OOo = this.O0000OOo;
                    return corntabParam;
                } catch (CloneNotSupportedException unused) {
                    return corntabParam;
                }
            } catch (CloneNotSupportedException unused2) {
                return null;
            }
        }

        public final int O00000Oo() {
            int i = 0;
            if (this.O00000o != -1) {
                return 0;
            }
            int i2 = 0;
            while (true) {
                boolean[] zArr = this.O0000O0o;
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
            if ("cn_freeday".equals(this.O0000OOo)) {
                return 6;
            }
            if ("cn_workday".equals(this.O0000OOo)) {
                return 5;
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
        public final void O000000o(int i) {
            if (i == 0) {
                Calendar instance = Calendar.getInstance();
                this.O00000o = instance.get(5);
                this.O00000oO = instance.get(2) + 1;
                this.O00000oo = instance.get(1);
                Arrays.fill(this.O0000O0o, false);
                return;
            }
            this.O00000o = -1;
            this.O00000oO = -1;
            this.O00000oo = -1;
            int i2 = 0;
            while (true) {
                boolean[] zArr = this.O0000O0o;
                if (i2 < zArr.length) {
                    zArr[i2] = ((1 << i2) & i) > 0;
                    i2++;
                } else {
                    return;
                }
            }
        }

        public final void O000000o(int i, boolean z) {
            this.O00000o = -1;
            this.O00000oO = -1;
            this.O0000O0o[i] = z;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CorntabParam)) {
                return false;
            }
            CorntabParam corntabParam = (CorntabParam) obj;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                boolean[] zArr = this.O0000O0o;
                if (i >= zArr.length) {
                    break;
                }
                if (zArr[i]) {
                    i2 |= 1 << i;
                }
                if (corntabParam.O0000O0o[i]) {
                    i3 |= 1 << i;
                }
                i++;
            }
            if (this.O00000Oo == corntabParam.O00000Oo && this.O00000o0 == corntabParam.O00000o0 && this.O00000o == corntabParam.O00000o && this.O00000oO == corntabParam.O00000oO && this.O00000oo == corntabParam.O00000oo && this.f11160O000000o == corntabParam.f11160O000000o && i2 == i3 && this.O0000OOo.equals(corntabParam.O0000OOo)) {
                return true;
            }
            return false;
        }

        public final boolean O000000o(Object obj) {
            if (!(obj instanceof CorntabParam)) {
                return false;
            }
            CorntabParam corntabParam = (CorntabParam) obj;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                boolean[] zArr = this.O0000O0o;
                if (i >= zArr.length) {
                    break;
                }
                if (zArr[i]) {
                    i2 |= 1 << i;
                }
                if (corntabParam.O0000O0o[i]) {
                    i3 |= 1 << i;
                }
                i++;
            }
            if (this.O00000Oo == corntabParam.O00000Oo && this.O00000o0 == corntabParam.O00000o0 && this.O00000o == corntabParam.O00000o && this.O00000oO == corntabParam.O00000oO && this.O00000oo == corntabParam.O00000oo && i2 == i3 && this.O0000OOo.equals(corntabParam.O0000OOo)) {
                return true;
            }
            return false;
        }

        public final String O000000o(Context context) {
            int i = 0;
            int i2 = 0;
            while (true) {
                boolean[] zArr = this.O0000O0o;
                if (i >= zArr.length) {
                    break;
                }
                if (zArr[i]) {
                    i2 |= 1 << i;
                }
                i++;
            }
            if (i2 == 0) {
                Calendar instance = Calendar.getInstance();
                Calendar instance2 = Calendar.getInstance();
                instance2.set(instance.get(1), this.O00000oO - 1, this.O00000o);
                if (goz.O000000o(instance, instance2)) {
                    return context.getString(R.string.plug_timer_today);
                }
                if (goz.O000000o(instance2, 1)) {
                    return context.getString(R.string.plug_timer_tomorrow);
                }
                if (goz.O000000o(instance2)) {
                    return context.getString(R.string.plug_timer_yesterday);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.O00000oO);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.O00000o);
                return context.getString(R.string.plug_timer_month_day, sb.toString(), sb2.toString());
            } else if (i2 == 62) {
                return context.getString(R.string.plug_timer_workday);
            } else {
                if (i2 == 65) {
                    return context.getString(R.string.plug_timer_weekend);
                }
                if (i2 != 127) {
                    String[] stringArray = context.getResources().getStringArray(R.array.weekday_short);
                    StringBuilder sb3 = new StringBuilder();
                    if (stringArray.length != this.O0000O0o.length) {
                        gsy.O000000o(6, "CorntabUtils", "dayList.length!=weeks.length");
                    }
                    boolean z = false;
                    for (int i3 = 0; i3 < stringArray.length; i3++) {
                        boolean[] zArr2 = this.O0000O0o;
                        if (i3 >= zArr2.length) {
                            break;
                        }
                        if (zArr2[i3]) {
                            if (i3 == 0) {
                                z = true;
                            } else {
                                sb3.append(stringArray[i3]);
                                sb3.append(", ");
                            }
                        }
                    }
                    if (z) {
                        sb3.append(stringArray[0]);
                        sb3.append(", ");
                    }
                    return sb3.substring(0, sb3.length() - 2);
                } else if ("cn_workday".equals(this.O0000OOo)) {
                    return context.getString(R.string.plug_timer_statutory_workingday);
                } else {
                    if ("cn_freeday".equals(this.O0000OOo)) {
                        return context.getString(R.string.plug_timer_statutory_holidays);
                    }
                    return context.getString(R.string.plug_timer_everyday);
                }
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f11160O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o0);
            parcel.writeInt(this.O00000o);
            parcel.writeInt(this.O00000oO);
            parcel.writeInt(this.O00000oo);
            parcel.writeBooleanArray(this.O0000O0o);
            parcel.writeString(this.O0000OOo);
        }
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
    public static CorntabParam O000000o(String str) {
        String[] split;
        int i;
        if (TextUtils.isEmpty(str) || (split = str.split(" ")) == null) {
            return null;
        }
        if (split.length == 6) {
            return O00000o0(str);
        }
        if (split.length == 7) {
            return O00000o(str);
        }
        if (split.length != 5) {
            return null;
        }
        CorntabParam corntabParam = new CorntabParam();
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                i = Integer.valueOf(split[i2]).intValue();
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i2 == 0) {
                corntabParam.O00000Oo = i;
            } else if (i2 == 1) {
                corntabParam.O00000o0 = i;
            } else if (i2 == 2) {
                corntabParam.O00000o = i;
            } else if (i2 == 3) {
                corntabParam.O00000oO = i;
            } else if (i2 == 4) {
                boolean[] zArr = new boolean[7];
                if (split[i2].equals("*") && corntabParam.O00000o == -1 && corntabParam.O00000oO == -1) {
                    Arrays.fill(zArr, true);
                } else {
                    Arrays.fill(zArr, false);
                    try {
                        String[] split2 = split[i2].split(",");
                        if (split2 != null) {
                            for (String trim : split2) {
                                zArr[Integer.valueOf(trim.trim()).intValue()] = true;
                            }
                        }
                    } catch (NumberFormatException unused2) {
                    }
                }
                corntabParam.O0000O0o = zArr;
            }
        }
        return corntabParam;
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
    private static CorntabParam O00000o0(String str) {
        int i;
        String[] split = str.split(" ");
        CorntabParam corntabParam = new CorntabParam();
        corntabParam.f11160O000000o = 0;
        corntabParam.O00000oo = Calendar.getInstance().get(1);
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                i = Integer.valueOf(split[i2]).intValue();
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i2 == 0) {
                corntabParam.O00000Oo = i;
            } else if (i2 == 1) {
                corntabParam.O00000o0 = i;
            } else if (i2 == 2) {
                corntabParam.O00000o = i;
            } else if (i2 == 3) {
                corntabParam.O00000oO = i;
            } else if (i2 == 4) {
                boolean[] zArr = new boolean[7];
                if (split[i2].equals("*") && corntabParam.O00000o == -1 && corntabParam.O00000oO == -1) {
                    Arrays.fill(zArr, true);
                } else {
                    Arrays.fill(zArr, false);
                    try {
                        String[] split2 = split[i2].split(",");
                        if (split2 != null) {
                            for (String trim : split2) {
                                zArr[Integer.valueOf(trim.trim()).intValue()] = true;
                            }
                        }
                    } catch (NumberFormatException unused2) {
                    }
                }
                corntabParam.O0000O0o = zArr;
            } else if (i2 == 5) {
                corntabParam.O00000oo = i;
            }
        }
        return corntabParam;
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
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0083 A[SYNTHETIC] */
    private static CorntabParam O00000o(String str) {
        int i;
        String[] split = str.split(" ");
        CorntabParam corntabParam = new CorntabParam();
        corntabParam.f11160O000000o = 0;
        corntabParam.O00000oo = Calendar.getInstance().get(1);
        for (int i2 = 0; i2 < split.length; i2++) {
            if (!TextUtils.equals("*", split[i2])) {
                try {
                    i = Integer.valueOf(split[i2]).intValue();
                } catch (NumberFormatException unused) {
                }
                switch (i2) {
                    case 0:
                        corntabParam.O00000Oo = i;
                        break;
                    case 1:
                        corntabParam.O00000Oo = i;
                        break;
                    case 2:
                        corntabParam.O00000o0 = i;
                        break;
                    case 3:
                        corntabParam.O00000o = i;
                        break;
                    case 4:
                        corntabParam.O00000oO = i;
                        break;
                    case 5:
                        boolean[] zArr = new boolean[7];
                        if (split[i2].equals("*") && corntabParam.O00000o == -1 && corntabParam.O00000oO == -1) {
                            Arrays.fill(zArr, true);
                        } else {
                            Arrays.fill(zArr, false);
                            try {
                                String[] split2 = split[i2].split(",");
                                if (split2 != null) {
                                    for (String trim : split2) {
                                        zArr[Integer.parseInt(trim.trim())] = true;
                                    }
                                }
                            } catch (NumberFormatException unused2) {
                            }
                        }
                        corntabParam.O0000O0o = zArr;
                        break;
                    case 6:
                        corntabParam.O00000oo = i;
                        break;
                }
            }
            i = -1;
            switch (i2) {
            }
        }
        return corntabParam;
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
    public static CorntabParam O00000Oo(String str) {
        String[] split = str.split(" ");
        if (split == null) {
            return null;
        }
        CorntabParam corntabParam = new CorntabParam();
        if (split.length < 7) {
            split = (corntabParam.f11160O000000o + " " + str + " " + corntabParam.O00000oo).split(" ");
        }
        for (int i = 0; i < split.length; i++) {
            int i2 = -1;
            try {
                i2 = Integer.valueOf(split[i]).intValue();
            } catch (NumberFormatException unused) {
            }
            switch (i) {
                case 0:
                    corntabParam.f11160O000000o = i2;
                    break;
                case 1:
                    corntabParam.O00000Oo = i2;
                    break;
                case 2:
                    corntabParam.O00000o0 = i2;
                    break;
                case 3:
                    corntabParam.O00000o = i2;
                    break;
                case 4:
                    corntabParam.O00000oO = i2;
                    break;
                case 5:
                    boolean[] zArr = new boolean[7];
                    Arrays.fill(zArr, false);
                    try {
                        String[] split2 = split[i].split(",");
                        if (split2 != null) {
                            for (String trim : split2) {
                                zArr[Integer.valueOf(trim.trim()).intValue()] = true;
                            }
                        }
                    } catch (NumberFormatException unused2) {
                    }
                    if (TextUtils.equals("*", split[3]) && TextUtils.equals("*", split[4]) && TextUtils.equals("*", split[i])) {
                        Arrays.fill(zArr, true);
                    }
                    corntabParam.O0000O0o = zArr;
                    break;
                case 6:
                    corntabParam.O00000oo = i2;
                    break;
            }
        }
        return corntabParam;
    }

    public static String O000000o(CorntabParam corntabParam) {
        StringBuilder sb = new StringBuilder();
        sb.append(corntabParam.f11160O000000o);
        sb.append(" ");
        sb.append(corntabParam.O00000Oo);
        sb.append(" ");
        sb.append(corntabParam.O00000o0);
        sb.append(" ");
        if (corntabParam.O00000o == -1 || corntabParam.O00000oO == -1) {
            sb.append("* ");
            sb.append("* ");
        } else {
            sb.append(corntabParam.O00000o);
            sb.append(" ");
            sb.append(corntabParam.O00000oO);
            sb.append(" ");
        }
        if (corntabParam.O00000o == -1 || corntabParam.O00000oO == -1) {
            boolean z = false;
            for (int i = 0; i < 7; i++) {
                if (corntabParam.O0000O0o[i]) {
                    if (z) {
                        sb.append(",");
                    }
                    sb.append(i);
                    z = true;
                }
            }
        } else {
            sb.append("*");
        }
        if (corntabParam.O00000Oo() == 0) {
            if (corntabParam.O00000oo <= Calendar.getInstance().get(1)) {
                corntabParam.O00000oo = Calendar.getInstance().get(1);
            }
            sb.append(" ");
            sb.append(corntabParam.O00000oo);
        } else {
            sb.append(" *");
        }
        return sb.toString();
    }

    public static String O00000Oo(CorntabParam corntabParam) {
        StringBuilder sb = new StringBuilder();
        sb.append(corntabParam.O00000Oo);
        sb.append(" ");
        sb.append(corntabParam.O00000o0);
        sb.append(" ");
        if (corntabParam.O00000o == -1 || corntabParam.O00000oO == -1) {
            sb.append("* ");
            sb.append("* ");
        } else {
            sb.append(corntabParam.O00000o);
            sb.append(" ");
            sb.append(corntabParam.O00000oO);
            sb.append(" ");
        }
        if (corntabParam.O00000o == -1 || corntabParam.O00000oO == -1) {
            boolean z = false;
            for (int i = 0; i < 7; i++) {
                if (corntabParam.O0000O0o[i]) {
                    if (z) {
                        sb.append(",");
                    }
                    sb.append(i);
                    z = true;
                }
            }
        } else {
            sb.append("*");
        }
        return sb.toString();
    }

    public static CorntabParam O000000o(TimeZone timeZone, CorntabParam corntabParam) {
        return O00000Oo(timeZone, new GregorianCalendar().getTimeZone(), corntabParam);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: com.xiaomi.smarthome.scene.model.CorntabUtils$CorntabParam} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static CorntabParam O000000o(TimeZone timeZone, TimeZone timeZone2, CorntabParam corntabParam) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        int convert = (int) (TimeUnit.MINUTES.convert((long) timeZone.getOffset(currentTimeMillis), TimeUnit.MILLISECONDS) - TimeUnit.MINUTES.convert((long) timeZone2.getOffset(currentTimeMillis), TimeUnit.MILLISECONDS));
        boolean[] zArr = corntabParam.O0000O0o;
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (zArr[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        Calendar instance = Calendar.getInstance();
        instance.set(2, corntabParam.O00000oO - 1);
        instance.set(5, corntabParam.O00000o);
        instance.set(11, corntabParam.O00000o0);
        instance.set(12, corntabParam.O00000Oo);
        instance.add(11, convert / 60);
        instance.add(12, convert % 60);
        CorntabParam corntabParam2 = (CorntabParam) corntabParam.clone();
        if (z) {
            corntabParam2.O00000oO = instance.get(2) + 1;
            corntabParam2.O00000o = instance.get(5);
            corntabParam2.O00000o0 = instance.get(11);
            corntabParam2.O00000Oo = instance.get(12);
        } else {
            int i3 = (corntabParam.O00000o0 * 60) + corntabParam.O00000Oo + convert;
            if (i3 < 0) {
                boolean[] zArr2 = new boolean[7];
                while (i < corntabParam.O0000O0o.length) {
                    zArr2[(i + 6) % 7] = corntabParam.O0000O0o[i];
                    i++;
                }
                corntabParam2.O0000O0o = zArr2;
            } else if (i3 >= 1440) {
                boolean[] zArr3 = new boolean[7];
                while (i < corntabParam.O0000O0o.length) {
                    int i4 = i + 1;
                    zArr3[i4 % 7] = corntabParam.O0000O0o[i];
                    i = i4;
                }
                corntabParam2.O0000O0o = zArr3;
            } else {
                corntabParam2 = corntabParam.clone();
            }
        }
        corntabParam2.O00000o0 = instance.get(11);
        corntabParam2.O00000Oo = instance.get(12);
        return corntabParam2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: com.xiaomi.smarthome.scene.model.CorntabUtils$CorntabParam} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static CorntabParam O00000Oo(TimeZone timeZone, TimeZone timeZone2, CorntabParam corntabParam) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        int convert = (int) (TimeUnit.MINUTES.convert((long) timeZone.getOffset(currentTimeMillis), TimeUnit.MILLISECONDS) - TimeUnit.MINUTES.convert((long) timeZone2.getOffset(currentTimeMillis), TimeUnit.MILLISECONDS));
        boolean[] zArr = corntabParam.O0000O0o;
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (zArr[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        Calendar instance = Calendar.getInstance();
        instance.set(1, corntabParam.O00000oo);
        instance.set(2, corntabParam.O00000oO - 1);
        instance.set(5, corntabParam.O00000o);
        instance.set(11, corntabParam.O00000o0);
        instance.set(12, corntabParam.O00000Oo);
        instance.add(11, convert / 60);
        instance.add(12, convert % 60);
        CorntabParam corntabParam2 = (CorntabParam) corntabParam.clone();
        if (z) {
            corntabParam2.O00000oo = instance.get(1);
            corntabParam2.O00000oO = instance.get(2) + 1;
            corntabParam2.O00000o = instance.get(5);
            corntabParam2.O00000o0 = instance.get(11);
            corntabParam2.O00000Oo = instance.get(12);
        } else {
            int i3 = (corntabParam.O00000o0 * 60) + corntabParam.O00000Oo + convert;
            if (i3 < 0) {
                boolean[] zArr2 = new boolean[7];
                while (i < corntabParam.O0000O0o.length) {
                    zArr2[(i + 6) % 7] = corntabParam.O0000O0o[i];
                    i++;
                }
                corntabParam2.O0000O0o = zArr2;
            } else if (i3 >= 1440) {
                boolean[] zArr3 = new boolean[7];
                while (i < corntabParam.O0000O0o.length) {
                    int i4 = i + 1;
                    zArr3[i4 % 7] = corntabParam.O0000O0o[i];
                    i = i4;
                }
                corntabParam2.O0000O0o = zArr3;
            } else {
                corntabParam2 = corntabParam.clone();
            }
        }
        corntabParam2.O00000o0 = instance.get(11);
        corntabParam2.O00000Oo = instance.get(12);
        return corntabParam2;
    }
}
