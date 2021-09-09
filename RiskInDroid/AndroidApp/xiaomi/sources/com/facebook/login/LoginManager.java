package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LoginManager {
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS = getOtherPublishPermissions();
    private static volatile LoginManager instance;
    private String authType = "rerequest";
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    private final SharedPreferences sharedPreferences;

    LoginManager() {
        Validate.sdkInitialized();
        this.sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.loginManager", 0);
    }

    public static LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    public void resolveError(Activity activity, GraphResponse graphResponse) {
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(graphResponse));
    }

    public void resolveError(Fragment fragment, GraphResponse graphResponse) {
        resolveError(new FragmentWrapper(fragment), graphResponse);
    }

    public void resolveError(android.app.Fragment fragment, GraphResponse graphResponse) {
        resolveError(new FragmentWrapper(fragment), graphResponse);
    }

    private void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
    }

    private LoginClient.Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        Validate.notNull(graphResponse, "response");
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        return createLoginRequest(accessToken != null ? accessToken.getPermissions() : null);
    }

    public void registerCallback(CallbackManager callbackManager, final FacebookCallback<LoginResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() {
                /* class com.facebook.login.LoginManager.AnonymousClass1 */

                public boolean onActivityResult(int i, Intent intent) {
                    return LoginManager.this.onActivityResult(i, intent, facebookCallback);
                }
            });
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public void unregisterCallback(CallbackManager callbackManager) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    /* access modifiers changed from: package-private */
    public boolean onActivityResult(int i, Intent intent) {
        return onActivityResult(i, intent, null);
    }

    /* access modifiers changed from: package-private */
    public boolean onActivityResult(int i, Intent intent, FacebookCallback<LoginResult> facebookCallback) {
        Map<String, String> map;
        LoginClient.Result.Code code;
        boolean z;
        AccessToken accessToken;
        LoginClient.Request request;
        LoginClient.Request request2;
        Map<String, String> map2;
        AccessToken accessToken2;
        int i2 = i;
        Intent intent2 = intent;
        LoginClient.Result.Code code2 = LoginClient.Result.Code.ERROR;
        FacebookException facebookException = null;
        boolean z2 = false;
        if (intent2 != null) {
            LoginClient.Result result = (LoginClient.Result) intent2.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                LoginClient.Request request3 = result.request;
                LoginClient.Result.Code code3 = result.code;
                if (i2 == -1) {
                    if (result.code == LoginClient.Result.Code.SUCCESS) {
                        accessToken2 = result.token;
                    } else {
                        facebookException = new FacebookAuthorizationException(result.errorMessage);
                        accessToken2 = null;
                    }
                } else if (i2 == 0) {
                    accessToken2 = null;
                    z2 = true;
                } else {
                    accessToken2 = null;
                }
                map2 = result.loggingExtras;
                LoginClient.Result.Code code4 = code3;
                request2 = request3;
                code2 = code4;
            } else {
                accessToken2 = null;
                map2 = null;
                request2 = null;
            }
            map = map2;
            code = code2;
            z = z2;
            LoginClient.Request request4 = request2;
            accessToken = accessToken2;
            request = request4;
        } else if (i2 == 0) {
            code = LoginClient.Result.Code.CANCEL;
            request = null;
            accessToken = null;
            map = null;
            z = true;
        } else {
            code = code2;
            request = null;
            accessToken = null;
            map = null;
            z = false;
        }
        if (facebookException == null && accessToken == null && !z) {
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        logCompleteLogin(null, code, map, facebookException, true, request);
        finishLogin(accessToken, request, facebookException, z, facebookCallback);
        return true;
    }

    static Map<String, String> getExtraDataFromIntent(Intent intent) {
        LoginClient.Result result;
        if (intent == null || (result = (LoginClient.Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result")) == null) {
            return null;
        }
        return result.extraData;
    }

    public LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public LoginManager setLoginBehavior(LoginBehavior loginBehavior2) {
        this.loginBehavior = loginBehavior2;
        return this;
    }

    public DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    public LoginManager setDefaultAudience(DefaultAudience defaultAudience2) {
        this.defaultAudience = defaultAudience2;
        return this;
    }

    public String getAuthType() {
        return this.authType;
    }

    public LoginManager setAuthType(String str) {
        this.authType = str;
        return this;
    }

    public void logOut() {
        AccessToken.setCurrentAccessToken(null);
        Profile.setCurrentProfile(null);
        setExpressLoginStatus(false);
    }

    public void retrieveLoginStatus(Context context, LoginStatusCallback loginStatusCallback) {
        retrieveLoginStatus(context, 5000, loginStatusCallback);
    }

    public void retrieveLoginStatus(Context context, long j, LoginStatusCallback loginStatusCallback) {
        retrieveLoginStatusImpl(context, loginStatusCallback, j);
    }

    public void logInWithReadPermissions(Fragment fragment, Collection<String> collection) {
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    public void logInWithReadPermissions(android.app.Fragment fragment, Collection<String> collection) {
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    private void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validateReadPermissions(collection);
        logIn(fragmentWrapper, collection);
    }

    public void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        validateReadPermissions(collection);
        logIn(activity, collection);
    }

    public void reauthorizeDataAccess(Activity activity) {
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
    }

    public void reauthorizeDataAccess(Fragment fragment) {
        reauthorizeDataAccess(new FragmentWrapper(fragment));
    }

    private void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
    }

    public void logInWithPublishPermissions(Fragment fragment, Collection<String> collection) {
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    public void logInWithPublishPermissions(android.app.Fragment fragment, Collection<String> collection) {
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    private void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validatePublishPermissions(collection);
        logIn(fragmentWrapper, collection);
    }

    public void logInWithPublishPermissions(Activity activity, Collection<String> collection) {
        validatePublishPermissions(collection);
        logIn(activity, collection);
    }

    public void logIn(Fragment fragment, Collection<String> collection) {
        logIn(new FragmentWrapper(fragment), collection);
    }

    public void logIn(android.app.Fragment fragment, Collection<String> collection) {
        logIn(new FragmentWrapper(fragment), collection);
    }

    public void logIn(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequest(collection));
    }

    public void logIn(Activity activity, Collection<String> collection) {
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequest(collection));
    }

    private void validateReadPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String next : collection) {
                if (isPublishPermission(next)) {
                    throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", next));
                }
            }
        }
    }

    private void validatePublishPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String next : collection) {
                if (!isPublishPermission(next)) {
                    throw new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", next));
                }
            }
        }
    }

    static boolean isPublishPermission(String str) {
        if (str != null) {
            return str.startsWith("publish") || str.startsWith("manage") || OTHER_PUBLISH_PERMISSIONS.contains(str);
        }
        return false;
    }

    private static Set<String> getOtherPublishPermissions() {
        return Collections.unmodifiableSet(new HashSet<String>() {
            /* class com.facebook.login.LoginManager.AnonymousClass2 */

            {
                add("ads_management");
                add("create_event");
                add("rsvp_event");
            }
        });
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        LoginClient.Request request = new LoginClient.Request(this.loginBehavior, Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet()), this.defaultAudience, this.authType, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
        request.setRerequest(AccessToken.isCurrentAccessTokenActive());
        return request;
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createReauthorizeRequest() {
        return new LoginClient.Request(LoginBehavior.DIALOG_ONLY, new HashSet(), this.defaultAudience, "reauthorize", FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
    }

    private void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) throws FacebookException {
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() {
            /* class com.facebook.login.LoginManager.AnonymousClass3 */

            public boolean onActivityResult(int i, Intent intent) {
                return LoginManager.this.onActivityResult(i, intent);
            }
        });
        if (!tryFacebookActivity(startActivityDelegate, request)) {
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, facebookException, false, request);
            throw facebookException;
        }
    }

    private void logStartLogin(Context context, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.getLogger(context);
        if (logger != null && request != null) {
            logger.logStartLogin(request);
        }
    }

    private void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.getLogger(context);
        if (logger != null) {
            if (request == null) {
                logger.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("try_login_activity", z ? "1" : "0");
            logger.logCompleteLogin(request.getAuthId(), hashMap, code, map, exc);
        }
    }

    private boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private boolean resolveIntent(Intent intent) {
        if (FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Intent getFacebookActivityIntent(LoginClient.Request request) {
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        return intent;
    }

    static LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken) {
        Set<String> permissions = request.getPermissions();
        HashSet hashSet = new HashSet(accessToken.getPermissions());
        if (request.isRerequest()) {
            hashSet.retainAll(permissions);
        }
        HashSet hashSet2 = new HashSet(permissions);
        hashSet2.removeAll(hashSet);
        return new LoginResult(accessToken, hashSet, hashSet2);
    }

    private void finishLogin(AccessToken accessToken, LoginClient.Request request, FacebookException facebookException, boolean z, FacebookCallback<LoginResult> facebookCallback) {
        if (accessToken != null) {
            AccessToken.setCurrentAccessToken(accessToken);
            Profile.fetchProfileForCurrentAccessToken();
        }
        if (facebookCallback != null) {
            LoginResult computeLoginResult = accessToken != null ? computeLoginResult(request, accessToken) : null;
            if (z || (computeLoginResult != null && computeLoginResult.getRecentlyGrantedPermissions().size() == 0)) {
                facebookCallback.onCancel();
            } else if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else if (accessToken != null) {
                setExpressLoginStatus(true);
                facebookCallback.onSuccess(computeLoginResult);
            }
        }
    }

    private void retrieveLoginStatusImpl(Context context, LoginStatusCallback loginStatusCallback, long j) {
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        LoginLogger loginLogger = new LoginLogger(context, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
            return;
        }
        LoginStatusClient loginStatusClient = new LoginStatusClient(context, applicationId, uuid, FacebookSdk.getGraphApiVersion(), j);
        final String str = uuid;
        final LoginLogger loginLogger2 = loginLogger;
        final LoginStatusCallback loginStatusCallback2 = loginStatusCallback;
        final String str2 = applicationId;
        loginStatusClient.setCompletedListener(new PlatformServiceClient.CompletedListener() {
            /* class com.facebook.login.LoginManager.AnonymousClass4 */

            public void completed(Bundle bundle) {
                if (bundle != null) {
                    String string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
                    String string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
                    if (string != null) {
                        LoginManager.handleLoginStatusError(string, string2, str, loginLogger2, loginStatusCallback2);
                        return;
                    }
                    String string3 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
                    Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0));
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
                    String string4 = bundle.getString("signed request");
                    Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0));
                    String userIDFromSignedRequest = !Utility.isNullOrEmpty(string4) ? LoginMethodHandler.getUserIDFromSignedRequest(string4) : null;
                    if (Utility.isNullOrEmpty(string3) || stringArrayList == null || stringArrayList.isEmpty() || Utility.isNullOrEmpty(userIDFromSignedRequest)) {
                        loginLogger2.logLoginStatusFailure(str);
                        loginStatusCallback2.onFailure();
                        return;
                    }
                    AccessToken accessToken = new AccessToken(string3, str2, userIDFromSignedRequest, stringArrayList, null, null, null, bundleLongAsDate, null, bundleLongAsDate2);
                    AccessToken.setCurrentAccessToken(accessToken);
                    Profile profileFromBundle = LoginManager.getProfileFromBundle(bundle);
                    if (profileFromBundle != null) {
                        Profile.setCurrentProfile(profileFromBundle);
                    } else {
                        Profile.fetchProfileForCurrentAccessToken();
                    }
                    loginLogger2.logLoginStatusSuccess(str);
                    loginStatusCallback2.onCompleted(accessToken);
                    return;
                }
                loginLogger2.logLoginStatusFailure(str);
                loginStatusCallback2.onFailure();
            }
        });
        loginLogger.logLoginStatusStart(uuid);
        if (!loginStatusClient.start()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
        }
    }

    private void setExpressLoginStatus(boolean z) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean("express_login_allowed", z);
        edit.apply();
    }

    private boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean("express_login_allowed", true);
    }

    public static Profile getProfileFromBundle(Bundle bundle) {
        String string = bundle.getString("com.facebook.platform.extra.PROFILE_NAME");
        String string2 = bundle.getString("com.facebook.platform.extra.PROFILE_FIRST_NAME");
        String string3 = bundle.getString("com.facebook.platform.extra.PROFILE_MIDDLE_NAME");
        String string4 = bundle.getString("com.facebook.platform.extra.PROFILE_LAST_NAME");
        String string5 = bundle.getString("com.facebook.platform.extra.PROFILE_LINK");
        String string6 = bundle.getString("com.facebook.platform.extra.PROFILE_USER_ID");
        if (string == null || string2 == null || string3 == null || string4 == null || string5 == null || string6 == null) {
            return null;
        }
        return new Profile(string6, string2, string3, string4, string, Uri.parse(string5));
    }

    public static void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
        FacebookException facebookException = new FacebookException(str + ": " + str2);
        loginLogger.logLoginStatusError(str3, facebookException);
        loginStatusCallback.onError(facebookException);
    }

    static class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activity;

        ActivityStartActivityDelegate(Activity activity2) {
            Validate.notNull(activity2, "activity");
            this.activity = activity2;
        }

        public void startActivityForResult(Intent intent, int i) {
            this.activity.startActivityForResult(intent, i);
        }

        public Activity getActivityContext() {
            return this.activity;
        }
    }

    static class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final FragmentWrapper fragment;

        FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            Validate.notNull(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
        }

        public void startActivityForResult(Intent intent, int i) {
            this.fragment.startActivityForResult(intent, i);
        }

        public Activity getActivityContext() {
            return this.fragment.getActivity();
        }
    }

    static class LoginLoggerHolder {
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        public static synchronized LoginLogger getLogger(Context context) {
            synchronized (LoginLoggerHolder.class) {
                if (context == null) {
                    context = FacebookSdk.getApplicationContext();
                }
                if (context == null) {
                    return null;
                }
                if (logger == null) {
                    logger = new LoginLogger(context, FacebookSdk.getApplicationId());
                }
                LoginLogger loginLogger = logger;
                return loginLogger;
            }
        }
    }
}
