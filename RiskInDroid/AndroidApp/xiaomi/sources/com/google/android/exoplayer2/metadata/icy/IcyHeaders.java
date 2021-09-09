package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.Map;

public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new Parcelable.Creator<IcyHeaders>() {
        /* class com.google.android.exoplayer2.metadata.icy.IcyHeaders.AnonymousClass1 */

        public final IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        public final IcyHeaders[] newArray(int i) {
            return new IcyHeaders[i];
        }
    };
    public final int bitrate;
    public final String genre;
    public final boolean isPublic;
    public final int metadataInterval;
    public final String name;
    public final String url;

    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return Metadata.Entry.CC.$default$getWrappedMetadataBytes(this);
    }

    public /* synthetic */ Format getWrappedMetadataFormat() {
        return Metadata.Entry.CC.$default$getWrappedMetadataFormat(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d8 A[RETURN] */
    public static IcyHeaders parse(Map<String, List<String>> map) {
        int i;
        boolean z;
        List list;
        boolean z2;
        String str;
        List list2;
        String str2;
        List list3;
        String str3;
        List list4;
        boolean z3;
        List list5;
        int i2;
        int i3;
        List list6 = map.get("icy-br");
        int i4 = -1;
        if (list6 != null) {
            String str4 = (String) list6.get(0);
            try {
                i3 = Integer.parseInt(str4) * 1000;
                if (i3 > 0) {
                    i = i3;
                    z = true;
                    list = map.get("icy-genre");
                    if (list != null) {
                        str = (String) list.get(0);
                        z2 = true;
                    } else {
                        z2 = z;
                        str = null;
                    }
                    list2 = map.get("icy-name");
                    if (list2 != null) {
                        str2 = (String) list2.get(0);
                        z2 = true;
                    } else {
                        str2 = null;
                    }
                    list3 = map.get("icy-url");
                    if (list3 != null) {
                        str3 = (String) list3.get(0);
                        z2 = true;
                    } else {
                        str3 = null;
                    }
                    list4 = map.get("icy-pub");
                    if (list4 != null) {
                        z3 = ((String) list4.get(0)).equals("1");
                        z2 = true;
                    } else {
                        z3 = false;
                    }
                    list5 = map.get("icy-metaint");
                    if (list5 != null) {
                        String str5 = (String) list5.get(0);
                        try {
                            int parseInt = Integer.parseInt(str5);
                            if (parseInt > 0) {
                                i2 = parseInt;
                                z2 = true;
                                if (z2) {
                                    return new IcyHeaders(i, str, str2, str3, z3, i2);
                                }
                                return null;
                            }
                            try {
                                Log.w("IcyHeaders", "Invalid metadata interval: ".concat(String.valueOf(str5)));
                            } catch (NumberFormatException unused) {
                                i4 = parseInt;
                            }
                        } catch (NumberFormatException unused2) {
                            Log.w("IcyHeaders", "Invalid metadata interval: ".concat(String.valueOf(str5)));
                            i2 = i4;
                            if (z2) {
                            }
                        }
                    }
                    i2 = -1;
                    if (z2) {
                    }
                } else {
                    try {
                        Log.w("IcyHeaders", "Invalid bitrate: ".concat(String.valueOf(str4)));
                    } catch (NumberFormatException unused3) {
                    }
                }
            } catch (NumberFormatException unused4) {
                i3 = -1;
                Log.w("IcyHeaders", "Invalid bitrate header: ".concat(String.valueOf(str4)));
                i = i3;
                z = false;
                list = map.get("icy-genre");
                if (list != null) {
                }
                list2 = map.get("icy-name");
                if (list2 != null) {
                }
                list3 = map.get("icy-url");
                if (list3 != null) {
                }
                list4 = map.get("icy-pub");
                if (list4 != null) {
                }
                list5 = map.get("icy-metaint");
                if (list5 != null) {
                }
                i2 = -1;
                if (z2) {
                }
            }
        }
        z = false;
        i = -1;
        list = map.get("icy-genre");
        if (list != null) {
        }
        list2 = map.get("icy-name");
        if (list2 != null) {
        }
        list3 = map.get("icy-url");
        if (list3 != null) {
        }
        list4 = map.get("icy-pub");
        if (list4 != null) {
        }
        list5 = map.get("icy-metaint");
        if (list5 != null) {
        }
        i2 = -1;
        if (z2) {
        }
    }

    public IcyHeaders(int i, String str, String str2, String str3, boolean z, int i2) {
        Assertions.checkArgument(i2 == -1 || i2 > 0);
        this.bitrate = i;
        this.genre = str;
        this.name = str2;
        this.url = str3;
        this.isPublic = z;
        this.metadataInterval = i2;
    }

    IcyHeaders(Parcel parcel) {
        this.bitrate = parcel.readInt();
        this.genre = parcel.readString();
        this.name = parcel.readString();
        this.url = parcel.readString();
        this.isPublic = Util.readBoolean(parcel);
        this.metadataInterval = parcel.readInt();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            IcyHeaders icyHeaders = (IcyHeaders) obj;
            return this.bitrate == icyHeaders.bitrate && Util.areEqual(this.genre, icyHeaders.genre) && Util.areEqual(this.name, icyHeaders.name) && Util.areEqual(this.url, icyHeaders.url) && this.isPublic == icyHeaders.isPublic && this.metadataInterval == icyHeaders.metadataInterval;
        }
    }

    public final int hashCode() {
        int i = (this.bitrate + 527) * 31;
        String str = this.genre;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((((hashCode2 + i2) * 31) + (this.isPublic ? 1 : 0)) * 31) + this.metadataInterval;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.name + "\", genre=\"" + this.genre + "\", bitrate=" + this.bitrate + ", metadataInterval=" + this.metadataInterval;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bitrate);
        parcel.writeString(this.genre);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        Util.writeBoolean(parcel, this.isPublic);
        parcel.writeInt(this.metadataInterval);
    }
}
