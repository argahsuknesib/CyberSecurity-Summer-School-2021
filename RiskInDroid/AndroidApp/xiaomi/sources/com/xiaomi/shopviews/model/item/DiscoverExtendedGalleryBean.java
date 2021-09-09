package com.xiaomi.shopviews.model.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscoverExtendedGalleryBean implements Parcelable {
    public static final Parcelable.Creator<DiscoverExtendedGalleryBean> CREATOR = new Parcelable.Creator<DiscoverExtendedGalleryBean>() {
        /* class com.xiaomi.shopviews.model.item.DiscoverExtendedGalleryBean.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DiscoverExtendedGalleryBean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DiscoverExtendedGalleryBean(parcel);
        }
    };
    @SerializedName("image_url")
    @Expose

    /* renamed from: O000000o  reason: collision with root package name */
    public String f3929O000000o;
    @SerializedName("video_url")
    @Expose
    private String O00000Oo;
    @SerializedName("jump_to")
    @Expose
    private String O00000o;
    @SerializedName("desc")
    @Expose
    private String O00000o0;
    @SerializedName("jump_to_btn_text")
    @Expose
    private String O00000oO;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3929O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
    }

    public DiscoverExtendedGalleryBean() {
    }

    protected DiscoverExtendedGalleryBean(Parcel parcel) {
        this.f3929O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
    }
}
