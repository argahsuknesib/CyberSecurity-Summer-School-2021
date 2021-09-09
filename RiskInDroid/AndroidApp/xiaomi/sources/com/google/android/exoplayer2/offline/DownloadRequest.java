package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() {
        /* class com.google.android.exoplayer2.offline.DownloadRequest.AnonymousClass1 */

        public final DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        public final DownloadRequest[] newArray(int i) {
            return new DownloadRequest[i];
        }
    };
    public final String customCacheKey;
    public final byte[] data;
    public final String id;
    public final List<StreamKey> streamKeys;
    public final String type;
    public final Uri uri;

    public static class UnsupportedRequestException extends IOException {
    }

    public final int describeContents() {
        return 0;
    }

    public DownloadRequest(String str, String str2, Uri uri2, List<StreamKey> list, String str3, byte[] bArr) {
        if ("dash".equals(str2) || "hls".equals(str2) || "ss".equals(str2)) {
            Assertions.checkArgument(str3 == null, "customCacheKey must be null for type: ".concat(String.valueOf(str2)));
        }
        this.id = str;
        this.type = str2;
        this.uri = uri2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.customCacheKey = str3;
        this.data = bArr != null ? Arrays.copyOf(bArr, bArr.length) : Util.EMPTY_BYTE_ARRAY;
    }

    DownloadRequest(Parcel parcel) {
        this.id = (String) Util.castNonNull(parcel.readString());
        this.type = (String) Util.castNonNull(parcel.readString());
        this.uri = Uri.parse((String) Util.castNonNull(parcel.readString()));
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.customCacheKey = parcel.readString();
        this.data = (byte[]) Util.castNonNull(parcel.createByteArray());
    }

    public final DownloadRequest copyWithId(String str) {
        return new DownloadRequest(str, this.type, this.uri, this.streamKeys, this.customCacheKey, this.data);
    }

    public final DownloadRequest copyWithMergedRequest(DownloadRequest downloadRequest) {
        List list;
        Assertions.checkArgument(this.id.equals(downloadRequest.id));
        Assertions.checkArgument(this.type.equals(downloadRequest.type));
        if (this.streamKeys.isEmpty() || downloadRequest.streamKeys.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList(this.streamKeys);
            for (int i = 0; i < downloadRequest.streamKeys.size(); i++) {
                StreamKey streamKey = downloadRequest.streamKeys.get(i);
                if (!list.contains(streamKey)) {
                    list.add(streamKey);
                }
            }
        }
        return new DownloadRequest(this.id, this.type, downloadRequest.uri, list, downloadRequest.customCacheKey, downloadRequest.data);
    }

    public final String toString() {
        return this.type + ":" + this.id;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        if (!this.id.equals(downloadRequest.id) || !this.type.equals(downloadRequest.type) || !this.uri.equals(downloadRequest.uri) || !this.streamKeys.equals(downloadRequest.streamKeys) || !Util.areEqual(this.customCacheKey, downloadRequest.customCacheKey) || !Arrays.equals(this.data, downloadRequest.data)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = ((((((((this.type.hashCode() * 31) + this.id.hashCode()) * 31) + this.type.hashCode()) * 31) + this.uri.hashCode()) * 31) + this.streamKeys.hashCode()) * 31;
        String str = this.customCacheKey;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.data);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.type);
        parcel.writeString(this.uri.toString());
        parcel.writeInt(this.streamKeys.size());
        for (int i2 = 0; i2 < this.streamKeys.size(); i2++) {
            parcel.writeParcelable(this.streamKeys.get(i2), 0);
        }
        parcel.writeString(this.customCacheKey);
        parcel.writeByteArray(this.data);
    }
}
