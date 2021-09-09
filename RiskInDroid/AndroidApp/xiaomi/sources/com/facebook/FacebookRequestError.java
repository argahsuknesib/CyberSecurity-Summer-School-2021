package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new Parcelable.Creator<FacebookRequestError>() {
        /* class com.facebook.FacebookRequestError.AnonymousClass1 */

        public final FacebookRequestError createFromParcel(Parcel parcel) {
            return new FacebookRequestError(parcel);
        }

        public final FacebookRequestError[] newArray(int i) {
            return new FacebookRequestError[i];
        }
    };
    static final Range HTTP_RANGE_SUCCESS = new Range(200, 299);
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    public final int describeContents() {
        return 0;
    }

    static class Range {
        private final int end;
        private final int start;

        private Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean contains(int i) {
            return this.start <= i && i <= this.end;
        }
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        boolean z2;
        Category category2;
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        if (facebookException != null) {
            this.exception = facebookException;
            z2 = true;
        } else {
            this.exception = new FacebookServiceException(this, str2);
            z2 = false;
        }
        FacebookRequestErrorClassification errorClassification = getErrorClassification();
        if (z2) {
            category2 = Category.OTHER;
        } else {
            category2 = errorClassification.classify(i2, i3, z);
        }
        this.category = category2;
        this.errorRecoveryMessage = errorClassification.getRecoveryMessage(this.category);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, r0 instanceof FacebookException ? (FacebookException) r0 : new FacebookException(r0));
        Exception exc2 = exc;
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    public final Category getCategory() {
        return this.category;
    }

    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getErrorMessage() {
        String str = this.errorMessage;
        if (str != null) {
            return str;
        }
        return this.exception.getLocalizedMessage();
    }

    public final String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    public final String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public final String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public final JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public final JSONObject getRequestResult() {
        return this.requestResult;
    }

    public final Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final FacebookException getException() {
        return this.exception;
    }

    public final String toString() {
        return "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
    }

    static FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        JSONObject jSONObject2 = jSONObject;
        try {
            if (jSONObject2.has("code")) {
                int i3 = jSONObject2.getInt("code");
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject2, "body", "FACEBOOK_NON_JSON_RESULT");
                if (stringPropertyAsJSON != null && (stringPropertyAsJSON instanceof JSONObject)) {
                    JSONObject jSONObject3 = (JSONObject) stringPropertyAsJSON;
                    boolean z2 = true;
                    if (jSONObject3.has("error")) {
                        JSONObject jSONObject4 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject3, "error", null);
                        String optString = jSONObject4.optString("type", null);
                        String optString2 = jSONObject4.optString("message", null);
                        i2 = jSONObject4.optInt("code", -1);
                        int optInt = jSONObject4.optInt("error_subcode", -1);
                        String optString3 = jSONObject4.optString("error_user_msg", null);
                        str = jSONObject4.optString("error_user_title", null);
                        z = jSONObject4.optBoolean("is_transient", false);
                        str2 = optString3;
                        str3 = optString2;
                        i = optInt;
                        str4 = optString;
                    } else {
                        if (!jSONObject3.has("error_code")) {
                            if (!jSONObject3.has("error_msg")) {
                                if (!jSONObject3.has("error_reason")) {
                                    str4 = null;
                                    str3 = null;
                                    str2 = null;
                                    str = null;
                                    i2 = 0;
                                    i = 0;
                                    z2 = false;
                                    z = false;
                                }
                            }
                        }
                        String optString4 = jSONObject3.optString("error_reason", null);
                        String optString5 = jSONObject3.optString("error_msg", null);
                        int optInt2 = jSONObject3.optInt("error_code", -1);
                        i = jSONObject3.optInt("error_subcode", -1);
                        str4 = optString4;
                        str3 = optString5;
                        str2 = null;
                        str = null;
                        z = false;
                        i2 = optInt2;
                    }
                    if (z2) {
                        return new FacebookRequestError(i3, i2, i, str4, str3, str, str2, z, jSONObject3, jSONObject, obj, httpURLConnection, null);
                    }
                }
                if (!HTTP_RANGE_SUCCESS.contains(i3)) {
                    return new FacebookRequestError(i3, -1, -1, null, null, null, null, false, jSONObject2.has("body") ? (JSONObject) Utility.getStringPropertyAsJSON(jSONObject2, "body", "FACEBOOK_NON_JSON_RESULT") : null, jSONObject, obj, httpURLConnection, null);
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    static synchronized FacebookRequestErrorClassification getErrorClassification() {
        synchronized (FacebookRequestError.class) {
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                FacebookRequestErrorClassification defaultErrorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
                return defaultErrorClassification;
            }
            FacebookRequestErrorClassification errorClassification = appSettingsWithoutQuery.getErrorClassification();
            return errorClassification;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.requestStatusCode);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.subErrorCode);
        parcel.writeString(this.errorType);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.errorUserTitle);
        parcel.writeString(this.errorUserMessage);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
    }
}
