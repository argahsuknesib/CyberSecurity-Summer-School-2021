package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;

class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator<WebViewLoginMethodHandler>() {
        /* class com.facebook.login.WebViewLoginMethodHandler.AnonymousClass2 */

        public final WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
            return new WebViewLoginMethodHandler(parcel);
        }

        public final WebViewLoginMethodHandler[] newArray(int i) {
            return new WebViewLoginMethodHandler[i];
        }
    };
    private String e2e;
    private WebDialog loginDialog;

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public String getNameForLogging() {
        return "web_view";
    }

    /* access modifiers changed from: package-private */
    public boolean needsInternetPermission() {
        return true;
    }

    WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: package-private */
    public AccessTokenSource getTokenSource() {
        return AccessTokenSource.WEB_VIEW;
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        WebDialog webDialog = this.loginDialog;
        if (webDialog != null) {
            webDialog.cancel();
            this.loginDialog = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean tryAuthorize(final LoginClient.Request request) {
        Bundle parameters = getParameters(request);
        AnonymousClass1 r1 = new WebDialog.OnCompleteListener() {
            /* class com.facebook.login.WebViewLoginMethodHandler.AnonymousClass1 */

            public void onComplete(Bundle bundle, FacebookException facebookException) {
                WebViewLoginMethodHandler.this.onWebDialogComplete(request, bundle, facebookException);
            }
        };
        this.e2e = LoginClient.getE2E();
        addLoggingExtra("e2e", this.e2e);
        FragmentActivity activity = this.loginClient.getActivity();
        this.loginDialog = new AuthDialogBuilder(activity, request.getApplicationId(), parameters).setE2E(this.e2e).setIsChromeOS(Utility.isChromeOS(activity)).setAuthType(request.getAuthType()).setOnCompleteListener(r1).build();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.setDialog(this.loginDialog);
        facebookDialogFragment.show(activity.getSupportFragmentManager(), "FacebookDialogFragment");
        return true;
    }

    /* access modifiers changed from: package-private */
    public void onWebDialogComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        super.onComplete(request, bundle, facebookException);
    }

    static class AuthDialogBuilder extends WebDialog.Builder {
        private String authType;
        private String e2e;
        private String redirect_uri = "fbconnect://success";

        public AuthDialogBuilder setIsRerequest(boolean z) {
            return this;
        }

        public AuthDialogBuilder(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
        }

        public AuthDialogBuilder setE2E(String str) {
            this.e2e = str;
            return this;
        }

        public AuthDialogBuilder setIsChromeOS(boolean z) {
            this.redirect_uri = z ? "fbconnect://chrome_os_success" : "fbconnect://success";
            return this;
        }

        public AuthDialogBuilder setAuthType(String str) {
            this.authType = str;
            return this;
        }

        public WebDialog build() {
            Bundle parameters = getParameters();
            parameters.putString("redirect_uri", this.redirect_uri);
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", this.e2e);
            parameters.putString("response_type", "token,signed_request");
            parameters.putString("return_scopes", "true");
            parameters.putString("auth_type", this.authType);
            return WebDialog.newInstance(getContext(), "oauth", parameters, getTheme(), getListener());
        }
    }

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.e2e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.e2e);
    }
}
