package com.mi.global.shop.model.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class AddressItem implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AddressItem> CREATOR = new Parcelable.Creator<AddressItem>() {
        /* class com.mi.global.shop.model.user.AddressItem.AnonymousClass1 */

        public final AddressItem createFromParcel(Parcel parcel) {
            return new AddressItem(parcel);
        }

        public final AddressItem[] newArray(int i) {
            return new AddressItem[i];
        }
    };
    public static int DEFAULT_ADDRESS = 1;
    public static int OTHER_ADDRESS;
    @SerializedName("addr_india")
    public Addr_India addr_india;
    @SerializedName("address")
    public String address;
    @SerializedName("address_id")
    public String address_id;
    @SerializedName("can_cod")
    public String can_cod;
    public String city_id;
    @SerializedName("city")
    public City_India city_india;
    public String city_name;
    @SerializedName("consignee")
    public String consignee;
    @SerializedName("dealer")
    public String dealer;
    public String district_id;
    @SerializedName("district")
    public District_India district_india;
    @SerializedName("email")
    public String email;
    public String india_address;
    public String india_city;
    public String india_landmark;
    public String india_state;
    @SerializedName("is_default")
    public int is_default;
    @SerializedName("is_invalid")
    public String is_invalid;
    public String landmark;
    @SerializedName("limit")
    public String limit;
    @SerializedName("limit_cod")
    public String limit_cod;
    public Boolean selected;
    @SerializedName("tel")
    public String tel;
    @SerializedName("zipcode")
    public String zipcode;

    public int describeContents() {
        return 0;
    }

    public AddressItem() {
        this.selected = Boolean.FALSE;
        this.selected = Boolean.FALSE;
    }

    public static class Addr_India implements Parcelable {
        public static final Parcelable.Creator<Addr_India> CREATOR = new Parcelable.Creator<Addr_India>() {
            /* class com.mi.global.shop.model.user.AddressItem.Addr_India.AnonymousClass1 */

            public final Addr_India createFromParcel(Parcel parcel) {
                return new Addr_India(parcel);
            }

            public final Addr_India[] newArray(int i) {
                return new Addr_India[i];
            }
        };
        @SerializedName("addr")
        public String addr;
        @SerializedName("city")
        public String city;
        @SerializedName("landmark")
        public String landmark;

        public int describeContents() {
            return 0;
        }

        public Addr_India() {
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.addr);
            parcel.writeString(this.landmark);
            parcel.writeString(this.city);
        }

        protected Addr_India(Parcel parcel) {
            this.addr = parcel.readString();
            this.landmark = parcel.readString();
            this.city = parcel.readString();
        }
    }

    public static class City_India implements Parcelable {
        public static final Parcelable.Creator<City_India> CREATOR = new Parcelable.Creator<City_India>() {
            /* class com.mi.global.shop.model.user.AddressItem.City_India.AnonymousClass1 */

            public final City_India createFromParcel(Parcel parcel) {
                return new City_India(parcel);
            }

            public final City_India[] newArray(int i) {
                return new City_India[i];
            }
        };
        @SerializedName("can_cod")
        public String can_cod;
        @SerializedName("id")
        public String id;
        @SerializedName("name")
        public String name;

        public int describeContents() {
            return 0;
        }

        public City_India() {
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.can_cod);
        }

        protected City_India(Parcel parcel) {
            this.id = parcel.readString();
            this.name = parcel.readString();
            this.can_cod = parcel.readString();
        }
    }

    public static class District_India implements Parcelable {
        public static final Parcelable.Creator<District_India> CREATOR = new Parcelable.Creator<District_India>() {
            /* class com.mi.global.shop.model.user.AddressItem.District_India.AnonymousClass1 */

            public final District_India createFromParcel(Parcel parcel) {
                return new District_India(parcel);
            }

            public final District_India[] newArray(int i) {
                return new District_India[i];
            }
        };
        @SerializedName("can_cod")
        public String can_cod;
        @SerializedName("id")
        public String id;
        @SerializedName("name")
        public String name;

        public int describeContents() {
            return 0;
        }

        public District_India() {
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.can_cod);
        }

        protected District_India(Parcel parcel) {
            this.id = parcel.readString();
            this.name = parcel.readString();
            this.can_cod = parcel.readString();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.address_id);
        parcel.writeString(this.consignee);
        parcel.writeString(this.email);
        parcel.writeString(this.zipcode);
        parcel.writeString(this.landmark);
        parcel.writeString(this.tel);
        parcel.writeString(this.city_id);
        parcel.writeString(this.district_id);
        parcel.writeString(this.dealer);
        parcel.writeString(this.limit);
        parcel.writeString(this.limit_cod);
        parcel.writeString(this.can_cod);
        parcel.writeString(this.is_invalid);
        parcel.writeInt(this.is_default);
        parcel.writeString(this.address);
        parcel.writeParcelable(this.addr_india, i);
        parcel.writeParcelable(this.city_india, i);
        parcel.writeParcelable(this.district_india, i);
        parcel.writeString(this.city_name);
        parcel.writeString(this.india_address);
        parcel.writeString(this.india_landmark);
        parcel.writeString(this.india_city);
        parcel.writeString(this.india_state);
        parcel.writeValue(this.selected);
    }

    protected AddressItem(Parcel parcel) {
        this.selected = Boolean.FALSE;
        this.address_id = parcel.readString();
        this.consignee = parcel.readString();
        this.email = parcel.readString();
        this.zipcode = parcel.readString();
        this.landmark = parcel.readString();
        this.tel = parcel.readString();
        this.city_id = parcel.readString();
        this.district_id = parcel.readString();
        this.dealer = parcel.readString();
        this.limit = parcel.readString();
        this.limit_cod = parcel.readString();
        this.can_cod = parcel.readString();
        this.is_invalid = parcel.readString();
        this.is_default = parcel.readInt();
        this.address = parcel.readString();
        this.addr_india = (Addr_India) parcel.readParcelable(Addr_India.class.getClassLoader());
        this.city_india = (City_India) parcel.readParcelable(City_India.class.getClassLoader());
        this.district_india = (District_India) parcel.readParcelable(District_India.class.getClassLoader());
        this.city_name = parcel.readString();
        this.india_address = parcel.readString();
        this.india_landmark = parcel.readString();
        this.india_city = parcel.readString();
        this.india_state = parcel.readString();
        this.selected = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }
}
