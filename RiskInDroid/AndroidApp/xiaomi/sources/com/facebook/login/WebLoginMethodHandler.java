package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.util.Locale;

abstract class WebLoginMethodHandler extends LoginMethodHandler {
    private String e2e;

    /* access modifiers changed from: protected */
    public String getSSODevice() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract AccessTokenSource getTokenSource();

    private static final String getRedirectUri() {
        return "fb" + FacebookSdk.getApplicationId() + "://authorize";
    }

    WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    /* access modifiers changed from: protected */
    public Bundle getParameters(LoginClient.Request request) {
        Bundle bundle = new Bundle();
        if (!Utility.isNullOrEmpty(request.getPermissions())) {
            String join = TextUtils.join(",", request.getPermissions());
            bundle.putString("scope", join);
            addLoggingExtra("scope", join);
        }
        bundle.putString("default_audience", request.getDefaultAudience().getNativeProtocolAudience());
        bundle.putString("state", getClientState(request.getAuthId()));
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        String token = currentAccessToken != null ? currentAccessToken.getToken() : null;
        if (token == null || !token.equals(loadCookieToken())) {
            Utility.clearFacebookCookies(this.loginClient.getActivity());
            addLoggingExtra("access_token", "0");
        } else {
            bundle.putString("access_token", token);
            addLoggingExtra("access_token", "1");
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public Bundle addExtraParameters(Bundle bundle, LoginClient.Request request) {
        bundle.putString("redirect_uri", getRedirectUri());
        bundle.putString("client_id", request.getApplicationId());
        bundle.putString("e2e", LoginClient.getE2E());
        bundle.putString("response_type", "token,signed_request");
        bundle.putString("return_scopes", "true");
        bundle.putString("auth_type", request.getAuthType());
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", FacebookSdk.getSdkVersion()));
        if (getSSODevice() != null) {
            bundle.putString("sso", getSSODevice());
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        LoginClient.Result result;
        String str;
        this.e2e = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.e2e = bundle.getString("e2e");
            }
            try {
                AccessToken createAccessTokenFromWebBundle = createAccessTokenFromWebBundle(request.getPermissions(), bundle, getTokenSource(), request.getApplicationId());
                result = LoginClient.Result.createTokenResult(this.loginClient.getPendingRequest(), createAccessTokenFromWebBundle);
                CookieSyncManager.createInstance(this.loginClient.getActivity()).sync();
                saveCookieToken(createAccessTokenFromWebBundle.getToken());
            } catch (FacebookException e) {
                result = LoginClient.Result.createErrorResult(this.loginClient.getPendingRequest(), null, e.getMessage());
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            result = LoginClient.Result.createCancelResult(this.loginClient.getPendingRequest(), "User canceled log in.");
        } else {
            this.e2e = null;
            String message = facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                str = String.format(Locale.ROOT, "%d", Integer.valueOf(requestError.getErrorCode()));
                message = requestError.toString();
            } else {
                str = null;
            }
            result = LoginClient.Result.createErrorResult(this.loginClient.getPendingRequest(), null, message, str);
        }
        if (!Utility.isNullOrEmpty(this.e2e)) {
            logWebLoginCompleted(this.e2e);
        }
        this.loginClient.completeAndValidate(result);
    }

    private String loadCookieToken() {
        return this.loginClient.getActivity().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    private void saveCookieToken(String str) {
        this.loginClient.getActivity().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", str).apply();
    }
}
