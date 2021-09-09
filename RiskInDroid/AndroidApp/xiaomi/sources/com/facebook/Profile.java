package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        /* class com.facebook.Profile.AnonymousClass2 */

        public final Profile createFromParcel(Parcel parcel) {
            return new Profile(parcel);
        }

        public final Profile[] newArray(int i) {
            return new Profile[i];
        }
    };
    public static final String TAG = "Profile";
    private final String firstName;
    private final String id;
    private final String lastName;
    private final Uri linkUri;
    private final String middleName;
    private final String name;

    public final int describeContents() {
        return 0;
    }

    public static Profile getCurrentProfile() {
        return ProfileManager.getInstance().getCurrentProfile();
    }

    public static void setCurrentProfile(Profile profile) {
        ProfileManager.getInstance().setCurrentProfile(profile);
    }

    public static void fetchProfileForCurrentAccessToken() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (!AccessToken.isCurrentAccessTokenActive()) {
            setCurrentProfile(null);
        } else {
            Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new Utility.GraphMeRequestWithCacheCallback() {
                /* class com.facebook.Profile.AnonymousClass1 */

                public final void onSuccess(JSONObject jSONObject) {
                    String optString = jSONObject.optString("id");
                    if (optString != null) {
                        String optString2 = jSONObject.optString("link");
                        Profile.setCurrentProfile(new Profile(optString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
                    }
                }

                public final void onFailure(FacebookException facebookException) {
                    Log.e(Profile.TAG, "Got unexpected exception: ".concat(String.valueOf(facebookException)));
                }
            });
        }
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        Validate.notNullOrEmpty(str, "id");
        this.id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
    }

    public final Uri getProfilePictureUri(int i, int i2) {
        return ImageRequest.getProfilePictureUri(this.id, i, i2, AccessToken.isCurrentAccessTokenActive() ? AccessToken.getCurrentAccessToken().getToken() : "");
    }

    public final String getId() {
        return this.id;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        if (this.id.equals(profile.id) && this.firstName == null) {
            return profile.firstName == null;
        }
        if (this.firstName.equals(profile.firstName) && this.middleName == null) {
            return profile.middleName == null;
        }
        if (this.middleName.equals(profile.middleName) && this.lastName == null) {
            return profile.lastName == null;
        }
        if (this.lastName.equals(profile.lastName) && this.name == null) {
            return profile.name == null;
        }
        if (!this.name.equals(profile.name) || this.linkUri != null) {
            return this.linkUri.equals(profile.linkUri);
        }
        return profile.linkUri == null;
    }

    public final int hashCode() {
        int hashCode = this.id.hashCode() + 527;
        String str = this.firstName;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        String str2 = this.middleName;
        if (str2 != null) {
            hashCode = (hashCode * 31) + str2.hashCode();
        }
        String str3 = this.lastName;
        if (str3 != null) {
            hashCode = (hashCode * 31) + str3.hashCode();
        }
        String str4 = this.name;
        if (str4 != null) {
            hashCode = (hashCode * 31) + str4.hashCode();
        }
        Uri uri = this.linkUri;
        return uri != null ? (hashCode * 31) + uri.hashCode() : hashCode;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("first_name", this.firstName);
            jSONObject.put("middle_name", this.middleName);
            jSONObject.put("last_name", this.lastName);
            jSONObject.put("name", this.name);
            if (this.linkUri == null) {
                return jSONObject;
            }
            jSONObject.put("link_uri", this.linkUri.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    Profile(JSONObject jSONObject) {
        Uri uri = null;
        this.id = jSONObject.optString("id", null);
        this.firstName = jSONObject.optString("first_name", null);
        this.middleName = jSONObject.optString("middle_name", null);
        this.lastName = jSONObject.optString("last_name", null);
        this.name = jSONObject.optString("name", null);
        String optString = jSONObject.optString("link_uri", null);
        this.linkUri = optString != null ? Uri.parse(optString) : uri;
    }

    private Profile(Parcel parcel) {
        Uri uri;
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String readString = parcel.readString();
        if (readString == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString);
        }
        this.linkUri = uri;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.name);
        Uri uri = this.linkUri;
        parcel.writeString(uri == null ? null : uri.toString());
    }
}
