package com.facebook.login;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    private static final String[] CHROME_PACKAGES = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new Parcelable.Creator() {
        /* class com.facebook.login.CustomTabLoginMethodHandler.AnonymousClass1 */

        public final CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
            return new CustomTabLoginMethodHandler(parcel);
        }

        public final CustomTabLoginMethodHandler[] newArray(int i) {
            return new CustomTabLoginMethodHandler[i];
        }
    };
    private String currentPackage;
    private String expectedChallenge;

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public String getNameForLogging() {
        return "custom_tab";
    }

    /* access modifiers changed from: protected */
    public String getSSODevice() {
        return "chrome_custom_tab";
    }

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.expectedChallenge = Utility.generateRandomString(20);
    }

    /* access modifiers changed from: package-private */
    public AccessTokenSource getTokenSource() {
        return AccessTokenSource.CHROME_CUSTOM_TAB;
    }

    /* access modifiers changed from: package-private */
    public boolean tryAuthorize(LoginClient.Request request) {
        if (!isCustomTabsAllowed()) {
            return false;
        }
        Bundle addExtraParameters = addExtraParameters(getParameters(request), request);
        Intent intent = new Intent(this.loginClient.getActivity(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, addExtraParameters);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
        this.loginClient.getFragment().startActivityForResult(intent, 1);
        return true;
    }

    private boolean isCustomTabsAllowed() {
        return getChromePackage() != null && Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext());
    }

    private String getChromePackage() {
        String str = this.currentPackage;
        if (str != null) {
            return str;
        }
        FragmentActivity activity = this.loginClient.getActivity();
        List<ResolveInfo> queryIntentServices = activity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (queryIntentServices == null) {
            return null;
        }
        HashSet hashSet = new HashSet(Arrays.asList(CHROME_PACKAGES));
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                this.currentPackage = serviceInfo.packageName;
                return this.currentPackage;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            return super.onActivityResult(i, i2, intent);
        }
        LoginClient.Request pendingRequest = this.loginClient.getPendingRequest();
        if (i2 == -1) {
            onCustomTabComplete(intent.getStringExtra(CustomTabMainActivity.EXTRA_URL), pendingRequest);
            return true;
        }
        super.onComplete(pendingRequest, null, new FacebookOperationCanceledException());
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6  */
    private void onCustomTabComplete(String str, LoginClient.Request request) {
        int i;
        if (str != null && str.startsWith(CustomTabMainActivity.getRedirectUrl())) {
            Uri parse = Uri.parse(str);
            Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
            parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
            if (!validateChallengeParam(parseUrlQueryString)) {
                super.onComplete(request, null, new FacebookException("Invalid state parameter"));
                return;
            }
            String string = parseUrlQueryString.getString("error");
            if (string == null) {
                string = parseUrlQueryString.getString("error_type");
            }
            String string2 = parseUrlQueryString.getString("error_msg");
            if (string2 == null) {
                string2 = parseUrlQueryString.getString("error_message");
            }
            if (string2 == null) {
                string2 = parseUrlQueryString.getString("error_description");
            }
            String string3 = parseUrlQueryString.getString("error_code");
            if (!Utility.isNullOrEmpty(string3)) {
                try {
                    i = Integer.parseInt(string3);
                } catch (NumberFormatException unused) {
                }
                if (!Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && i == -1) {
                    super.onComplete(request, parseUrlQueryString, null);
                    return;
                } else if (string == null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                    super.onComplete(request, null, new FacebookOperationCanceledException());
                    return;
                } else if (i != 4201) {
                    super.onComplete(request, null, new FacebookOperationCanceledException());
                    return;
                } else {
                    super.onComplete(request, null, new FacebookServiceException(new FacebookRequestError(i, string, string2), string2));
                    return;
                }
            }
            i = -1;
            if (!Utility.isNullOrEmpty(string)) {
            }
            if (string == null) {
            }
            if (i != 4201) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
        jSONObject.put("7_challenge", this.expectedChallenge);
    }

    private boolean validateChallengeParam(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return new JSONObject(string).getString("7_challenge").equals(this.expectedChallenge);
        } catch (JSONException unused) {
            return false;
        }
    }

    CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.expectedChallenge = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.expectedChallenge);
    }
}
