package com.ximalaya.ting.android.opensdk.model.category;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryModel implements Parcelable {
    public static final Parcelable.Creator<CategoryModel> CREATOR = new Parcelable.Creator<CategoryModel>() {
        /* class com.ximalaya.ting.android.opensdk.model.category.CategoryModel.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CategoryModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.f12175O000000o = parcel.readInt();
            categoryModel.O00000Oo = parcel.readString();
            return categoryModel;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12175O000000o;
    public String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12175O000000o);
        parcel.writeString(this.O00000Oo);
    }
}
